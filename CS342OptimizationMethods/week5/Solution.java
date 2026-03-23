import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Solution {

    static final int NUM_ITEMS = 100;
    static final int NUM_CONSTRAINTS = 10;
    static final int MAX_EVALUATIONS = 1000;

    // 占位符：这里的权重、价值和容量需要从 Excel 或 CSV 中读取
    static double[] values = new double[NUM_ITEMS];
    static double[][] weights = new double[NUM_ITEMS][NUM_CONSTRAINTS];
    static double[] capacities = new double[NUM_CONSTRAINTS];

    static Random random = new Random();
    static int evaluations = 0;

    public static void main(String[] args) {
        // 从CSV文件读取数据
        loadDataFromCSV();

        int[] initialSolution = getInitialSolution();
        System.out.println("初始解价值: " + evaluate(initialSolution));

        // 不同的冷却策略参数 (初始温度, 冷却速率, D)
        System.out.println("--- 快速降温, D=1 ---");
        simulatedAnnealing(initialSolution, 1000.0, 0.8, 1);

        System.out.println("--- 慢速降温, D=2 ---");
        simulatedAnnealing(initialSolution, 1000.0, 0.99, 2);
        
        System.out.println("--- 恒定中等温度, D=3 ---");
        simulatedAnnealing(initialSolution, 100.0, 1.0, 3);
    }

    private static void loadDataFromCSV() {
        try {
            // 1. 读取 100 个物品的价值 (100行 x 1列)
            BufferedReader brValues = new BufferedReader(new FileReader("value_for_100_items.csv"));
            for (int i = 0; i < NUM_ITEMS; i++) {
                String line = brValues.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    values[i] = Double.parseDouble(line.trim());
                }
            }
            brValues.close();

            // 2. 读取 100 个物品针对 10 个约束的权重 (100行 x 10列)
            BufferedReader brWeights = new BufferedReader(new FileReader("weight_for_ten_constraints.csv"));
            for (int i = 0; i < NUM_ITEMS; i++) {
                String line = brWeights.readLine();
                if (line != null) {
                    String[] parts = line.split(",");
                    for (int j = 0; j < NUM_CONSTRAINTS && j < parts.length; j++) {
                        weights[i][j] = Double.parseDouble(parts[j].trim());
                    }
                }
            }
            brWeights.close();

            // 3. 读取 10 个约束的容量限制 (1行 x 10列)
            BufferedReader brCapacities = new BufferedReader(new FileReader("capacity_for_ten_constraints.csv"));
            String capLine = brCapacities.readLine();
            if (capLine != null) {
                String[] parts = capLine.split(",");
                for (int j = 0; j < NUM_CONSTRAINTS && j < parts.length; j++) {
                    capacities[j] = Double.parseDouble(parts[j].trim());
                }
            }
            brCapacities.close();

        } catch (IOException | NumberFormatException e) {
            System.err.println("读取CSV文件时发生错误，请确认文件是否存在且格式正确: " + e.getMessage());
        }
    }

    // 生成初始可行解：按顺序将物品放入
    private static int[] getInitialSolution() {
        int[] sol = new int[NUM_ITEMS];
        double[] currentWeights = new double[NUM_CONSTRAINTS];

        for (int i = 0; i < NUM_ITEMS; i++) {
            boolean canAdd = true;
            for (int j = 0; j < NUM_CONSTRAINTS; j++) {
                if (currentWeights[j] + weights[i][j] > capacities[j]) {
                    canAdd = false;
                    break;
                }
            }
            if (canAdd) {
                sol[i] = 1;
                for (int j = 0; j < NUM_CONSTRAINTS; j++) {
                    currentWeights[j] += weights[i][j];
                }
            } else {
                break; // 如果第 k+1 个物品无法放入，则初始可行解由前 k 个构成
            }
        }
        return sol;
    }

    // 邻域操作：汉明距离为 D
    private static int[] getNeighbor(int[] current, int D) {
        int[] neighbor = Arrays.copyOf(current, NUM_ITEMS);
        for (int i = 0; i < D; i++) {
            int idx = random.nextInt(NUM_ITEMS);
            neighbor[idx] = 1 - neighbor[idx]; // 翻转 0->1 或 1->0
        }
        // 修复不可行解 (Fixing Method)
        repair(neighbor);
        return neighbor;
    }

    // 修复方法：随机移除直到满足容量约束
    private static void repair(int[] sol) {
        while (!isValid(sol)) {
            // 找出所有在背包中的物品
            int count = 0;
            for (int x : sol) if (x == 1) count++;
            if (count == 0) break;

            int[] inBag = new int[count];
            int idx = 0;
            for (int i = 0; i < NUM_ITEMS; i++) {
                if (sol[i] == 1) {
                    inBag[idx++] = i;
                }
            }

            // 随机移除一个物品
            int toRemove = inBag[random.nextInt(count)];
            sol[toRemove] = 0;
        }
    }

    private static boolean isValid(int[] sol) {
        for (int j = 0; j < NUM_CONSTRAINTS; j++) {
            double totalWeight = 0;
            for (int i = 0; i < NUM_ITEMS; i++) {
                totalWeight += sol[i] * weights[i][j];
            }
            if (totalWeight > capacities[j]) return false;
        }
        return true;
    }

    // 计算目标函数值
    private static double evaluate(int[] sol) {
        evaluations++;
        double totalValue = 0;
        for (int i = 0; i < NUM_ITEMS; i++) {
            totalValue += sol[i] * values[i];
        }
        return totalValue;
    }

    // 模拟退火算法
    private static void simulatedAnnealing(int[] initialSolution, double initialTemp, double coolingRate, int D) {
        evaluations = 0;
        int[] bestSol = Arrays.copyOf(initialSolution, NUM_ITEMS);
        double bestVal = evaluate(bestSol);

        int[] currentSol = Arrays.copyOf(initialSolution, NUM_ITEMS);
        double currentVal = bestVal;

        double temp = initialTemp;

        while (evaluations < MAX_EVALUATIONS) {
            int[] neighbor = getNeighbor(currentSol, D);
            double neighborVal = evaluate(neighbor);

            double delta = neighborVal - currentVal;

            if (delta > 0 || Math.exp(delta / temp) > random.nextDouble()) {
                currentSol = neighbor;
                currentVal = neighborVal;

                if (currentVal > bestVal) {
                    bestSol = Arrays.copyOf(currentSol, NUM_ITEMS);
                    bestVal = currentVal;
                }
            }

            temp *= coolingRate; // 冷却
        }

        System.out.println("最佳解价值: " + bestVal);
    }
}
