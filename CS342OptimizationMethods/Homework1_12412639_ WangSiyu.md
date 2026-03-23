# Homework1_12412639_ WangSiyu

## Q1

If we consider all possible tours without regard to equivalence, there are $n!$ tours. 

However, since a tour and its reverse (clockwise vs. counterclockwise) are considered the same, we divide by 2. 

Additionally, tours that differ only by the starting city are also identical, so we divide by $n$. 

Therefore, the number of distinct tours is $\frac{(n-1)!}{2}$.

## Q2

Assign 0,1,3 jobs to machines respectively: $C_4^1$ ways.

Assign 1,1,2 jobs to machines respectively: $C_4^2$ ways.

Assign 0,2,2 jobs to machines respectively: $\frac{C_4^2}2$ ways.

Assign 0,0,4 jobs to machines respectively: 1 ways.

Hence, there are $C_4^1+C_4^2+\frac{C_4^2}2+1=14$

## Q3

If we consider all possible solutions without regard to the equivalence of two machines, there are $C_n^0+C_n^1+C_n^2+...+C_n^n=2^n$ solutions.

But the two machines are the same, hence we have $2^{n-1}$ solutions.

## Q4

The problem is the same as finding the number of subset of a set of 30 elements. Hence there are $2^{30}$ solutions.

## Q5

$$
2^n=\frac{(1000-1)!}2\\
n+1=\log_2(999!)\\n=(\sum_{i=1}^{999}\log_2i) -1\\
n\approx8518.43
$$

8518 items.

## Q6

$2^{1000}=\frac{(n-1)!}2$
$$
\lg (n-1)!=1001\lg2=301.33\\
$$
Let's test $n = 168$: $\log_{10}(167!) \approx 300.18$

Let's test $n = 169$: $\log_{10}(168!) \approx 302.40$

Hence,  A TSP with **168** to **169** cities will yield a search space similar in size to a 1000-item knapsack problem.