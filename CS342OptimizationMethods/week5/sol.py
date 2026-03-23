import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import random

# Load data
capacities = pd.read_csv("capacity_for_ten_constraints.csv", header=None).values[0]
values = pd.read_csv("value_for_100_items.csv", header=None).values.flatten()
weights = pd.read_csv("weight_for_ten_constraints.csv", header=None).values

NUM_ITEMS = 100
NUM_CONSTRAINTS = 10
MAX_EVALS = 1000

def get_initial_solution():
    sol = np.zeros(NUM_ITEMS, dtype=int)
    cur_weight = np.zeros(NUM_CONSTRAINTS)
    for i in range(NUM_ITEMS):
        if np.all(cur_weight + weights[i] <= capacities):
            sol[i] = 1
            cur_weight += weights[i]
        else:
            break
    return sol

def evaluate(sol):
    return np.sum(sol * values)

def is_valid(sol):
    total_weights = np.dot(sol, weights)
    return np.all(total_weights <= capacities)

def repair(sol):
    sol = sol.copy()
    while not is_valid(sol):
        in_bag = np.where(sol == 1)[0]
        if len(in_bag) == 0:
            break
        to_remove = random.choice(in_bag)
        sol[to_remove] = 0
    return sol

def simulated_annealing(initial_sol, D, cooling_strategy, seed=None):
    if seed is not None:
        random.seed(seed)
        np.random.seed(seed)
        
    current_sol = initial_sol.copy()
    best_sol = initial_sol.copy()
    
    current_val = evaluate(current_sol)
    best_val = current_val
    evals = 1 # We evaluated initial_sol
    
    temp = cooling_strategy['T']
    rate = cooling_strategy['rate']
    
    best_vals_history = [best_val]
    
    while evals < MAX_EVALS:
        # Generate neighbor
        neighbor = current_sol.copy()
        flip_indices = random.sample(range(NUM_ITEMS), D)
        for idx in flip_indices:
            neighbor[idx] = 1 - neighbor[idx]
            
        # Repair
        neighbor = repair(neighbor)
        
        # Evaluate
        neighbor_val = evaluate(neighbor)
        evals += 1
        
        delta = neighbor_val - current_val
        
        # Metropolis acceptance criterion
        if delta > 0:
            current_sol = neighbor
            current_val = neighbor_val
            if current_val > best_val:
                best_sol = current_sol.copy()
                best_val = current_val
        else:
            # Need to avoid math domain error with exp
            if temp > 1e-6:
                prob = np.exp(delta / temp)
            else:
                prob = 0
                
            if random.random() < prob:
                current_sol = neighbor
                current_val = neighbor_val
                
        # Update temp
        if rate is not None:
            temp *= rate
            
        best_vals_history.append(best_val)
        
    return best_vals_history

cooling_strategies = {
    'Constant High': {'T': 1000.0, 'rate': 1.0},
    'Constant Medium': {'T': 100.0, 'rate': 1.0},
    'Constant Low': {'T': 10.0, 'rate': 1.0},
    'Fast Cooling': {'T': 1000.0, 'rate': 0.8},
    'Slow Cooling': {'T': 1000.0, 'rate': 0.99},
}

D_values = [1, 2, 3]

plt.rcParams['font.sans-serif'] = ['SimHei'] # for Chinese labels
plt.rcParams['axes.unicode_minus'] = False 

fig, axes = plt.subplots(1, 3, figsize=(18, 5))

initial_sol = get_initial_solution()
num_runs = 10 # Average over multiple runs to make curves smoother

for idx, D in enumerate(D_values):
    ax = axes[idx]
    
    for strategy_name, strategy_params in cooling_strategies.items():
        avg_history = np.zeros(MAX_EVALS)
        for run in range(num_runs):
            history = simulated_annealing(initial_sol, D, strategy_params)
            avg_history += np.array(history[:MAX_EVALS])
        avg_history /= num_runs
        
        ax.plot(range(1, MAX_EVALS+1), avg_history, label=strategy_name)
    
    ax.set_title(f'D = {D}')
    ax.set_xlabel('Evaluations')
    ax.set_ylabel('Best Value')
    ax.grid(True)
    if idx == 0:
        ax.legend()

plt.tight_layout()
plt.savefig('result_comparison.png')
print("Simulation completed. Plot saved to result_comparison.png")
