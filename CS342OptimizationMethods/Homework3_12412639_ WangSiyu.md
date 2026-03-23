# Homework3_12412639_ WangSiyu

### T1

$n$.

From $0$ to $n-1$, we can choose $k$ and $k+1$, where $k\in\{0,...n-1\}$. Hence we have $n$ neighbors.

### T2

$\frac{C_n^1C_{n-1}^1}2=\frac{n(n-1)}2$

From $0$ to $n-1$, we firstly choose city A, then B to change. Because the order shouldn't be considered, it should be divided by 2.

### T3

$n(n-1)$.

1. **Select a city to move:** You have **$n$** choices.

2. **Select a new destination:** Once you remove that city, you have a sequence of $n-1$ cities remaining. There are $n$ possible "gaps" to insert the city back into (including the very front and the very back). However, inserting it into the exact gap it just came from results in the original tour (0 distance shift). This leaves **$n-1$** valid new gaps that actually change the sequence.

### T4

$\frac{n(n-1)}{2}$

The Inversion means choosing two incisions between cities. There's $n$ possible options between $n$ cites to cut. Hence the number is $C_n^2=\frac{n(n-1)}{2}$

### T5

$5\times C_n^3=\frac{5n(n-1)(n-2)}6$

This structure involves choosing any 3 distinct cities in the tour and rearranging them. Here is the step-by-step breakdown:

1. **Select the cities:** You first need to choose 3 cities from the total $n$. The number of combinations is $\binom{n}{3}$, which calculates to $\frac{n(n-1)(n-2)}{6}$.
2. **Permute the cities:** Once you have 3 specific cities (let's call them A, B, and C), there are $3! = 6$ total ways to arrange them.
   - **1** way leaves them in their original order (no change), which is *<u>**invalid**</u>*
   - **3** ways are simple two-city swaps (e.g., swapping A and B while leaving C alone). The prompt explicitly states to **include the two-city changes** from (1) and (2), so we count these.
   - **2** ways are true three-city cyclic shifts (e.g., moving A to B's spot, B to C's spot, and C to A's spot—exactly what the red arrows in the diagram illustrate).