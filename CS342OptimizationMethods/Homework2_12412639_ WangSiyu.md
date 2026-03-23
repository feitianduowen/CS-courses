# Homework2_12412639_ WangSiyu

### T1

- **Example:** a knapsack with capacity $ W = 200 $ kg and two items: 

  | Item | Value ($) | Weight (kg) | Value/Weight |
  | ---- | --------- | ----------- | ------------ |
  | 1    | 2         | 1           | 2            |
  | 2    | 200       | 200         | 1            |

- **Greedy algorithm** (pick items by highest value-to-weight ratio):  
  - Item 1 has ratio 2 > 1, so it is selected first.  
  - Remaining capacity: 199 kg, but item 2 weighs 200 kg and cannot be added.  
  - Total value = $2.

- **Optimal solution**:  
  - Select item 2 only.  
  - Total value = $200.

**Ratio**: $ \frac{200}{2} = 100 $, i.e., the greedy solution is 100 times worse than the optimal.

---

### T2

- **Example:** A **hub-and-spoke star-tree** configuration. 

  There are a cluster of dots densely distributes at the center of the wheel and the distance between them can be ignored. Besides, we place points along each "spoke" with exponentially decreasing intervals (the closer to the center, the denser the points). 

- **Optimal tour**: 

  Directly traverse the perimeters.

- **Greedy**: 

  Traveling to and fro between the center. When the number of spokes is really large, the path can be sufficiently longer than two times of the optimal path

- **ratio**:

  if the distance between the dots on the perimeter is $a_0$, then the distance between the dots on spokes should no more than $a_0$. Hence we assume that the number of spokes is n, then $a_0=\frac{2\pi r}{2n}=\frac{\pi r}n$. Hence, we can have $l$ concentric circles and $s$ spokes. 

  - optimal: $r+2\pi rl$

  - greedy: $2sr+2\pi r$

  - $$
    \text{When the s is large enough,}\\ratio=\lim_{s\to\infty}\frac{2sr+2\pi r}{r+2\pi rl}=\lim_{s\to\infty}\frac{s}{\pi l}>2
    $$

---

### T3

**Example**: $ m = 10 $ identical machines and 91 jobs:

- 90 jobs of processing time 1
- 1 job of processing time 10

**Greedy algorithm** (assign each job to the machine with the smallest current load) processes jobs in the order: all 90 small jobs first, then the large job.
- After the 90 small jobs, each machine gets $ 90/10 = 9 $ (since they are distributed evenly).
- The large job (time 10) is then assigned to one machine, making its load $ 9 + 10 = 19 $.
- Makespan = 19.

**Optimal schedule**:  
- Place the large job on one machine (load 10).  
- Distribute the 90 small jobs evenly among the other 9 machines, each getting $ 90/9 = 10 $.  
- Makespan = 10.

**Ratio**: $ \frac{19}{10} = 1.9 $, which approaches 2 as the number of machines increases (e.g., for $ m = 100 $, ratio = $ 2 - 1/m \approx 1.99 $).

Thus the greedy makespan is nearly twice the optimal.