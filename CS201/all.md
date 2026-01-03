# CS201 Note

## 04 Complexity of Algorithms

1. $$|f(x)| \leq C|g(x)| \Rightarrow f(x) = O(g(x))$$  
   $$\log n! = O(n \log n)$$  
   $$(f_1 + f_2)(x) = O(\max(|g_1(x)|, |g_2(x)|))$$  
   $$(f_1 f_2)(x) = O(g_1 g_2(x))$$

2. $$|f(x)| \geq C|g(x)|$$

3. $$f(x) = \Theta(f(x))$$

4. 我们应该使用输入大小（$$L = \log_2 n$$）来衡量复杂度。

5. **多项式时间算法**：运行时间为 $$O(n^c)$$ 的算法，常数 $$c>0$$ 且与 n 无关  
   **非多项式时间算法**

6. **易处理问题**：存在一个多项式时间算法可以解决该问题

7. **P 类**：由所有可以在多项式时间内解决的判定问题组成

8. **证明书**：对于一个 yes 输入，证明书是一个用于验证/证明/表明该输入确实是 yes 输入的具体对象

9. **NP 类**（非确定性多项式时间）：由所有满足以下条件的判定问题组成：  
   存在一个多项式时间算法 $$V$$，使得  
   一个输入是 yes 输入  
   $$\Leftarrow$$  
   存在一个证明书，  
   借助该证明书，$$V$$ 可以验证该输入确实是 yes 输入。

10. **NP 完全问题**：由 NP 中最难的问题组成。NP 完全问题可以相互规约，即，它们是同等困难的。

11. **NP 难问题**：由至少与 NP 完全问题一样困难的判定问题组成。不一定属于 NP


![NP-hardness - Wikipedia](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/P_np_np-complete_np-hard.svg/1200px-P_np_np-complete_np-hard.svg.png)

# 05 Number Theory and Cryptography

1. a|b: b能被a整除

2. $ab\mod m=(𝑎\mod m)(𝑏\mod m)\mod m$

3. $a_{+m}b=(a+b)\mod m$,    $a_{\cdot m}b=(a\cdot b)\mod m$

   Modular Arithmetic Properties

    - Closure
    - Associativity 结合性
    - Identity Elements 单位元  if $a\in \mathbb{Z}_m$, then $a_{+m}0=a$ and $a_{\cdot m}1=a$
    - Additive Inverses
    - Commutativity 交换性
    - Distributivity

4. 二进制加法  $O(n)=O(\max(\log a,\log b))$

5. 二进制乘法 $O(n^2)=O(\log a\log b)$

   ```pseudocode
   procedure multiply(a,b:positve integers)
   {the binary expansions of a and b are(a_{n-1}...a_0)_2 and (b_{n-1}...b_0)_2}
   for j:=0 to n-1
   	if b_j=1 then c_j:=a shifted j places
   	else c_j:=0
   {c_0,...c_{n-1}are the partial products}
   p:=0
   for j:=0 to n-1
   	p:=add(p,c_j)
   return p{p is the value of ab}
   ```

6. 二进制除法

   - (low) $\Theta(q\log a)=\Theta(2^{\log_{2}q\log d})$, $\log_2 q\approx\log_2 a+\log_2 d$ (input size)

   - (high) $O(\log a\cdot\max(\log q,\log d))$

     ```pseudocode
     procedure division2(a,d)
     if a<d
         return (q,r)=(0,a)
     (q,r)=division2(⌊a/2⌋,d)
     q=2q,r=2r
     if a is odd
         r=r+1
     if r >=d
        r=r-d
        q=q+1
     return(q,r)
     ```

7. **快速模幂运算** $O(\log b\log m+\log n(\log m)^2)$

   ```pseudocode
   procedure modular exponentiation(b:integer,n=(a_{k-1}a_{k-2}...a_1a_0)_2,m:postive integers)
   x:1
   power:=b mod m
   for i:=0 to k-1
   	if a_i thenx:=(x·power)mod m
   	power:=(power·power)mod m
   return x{x equals b^n mod m}
   ```

8. **Fundamental Theorem of Arithmetic** 算术基本定理 

   任何不小于2的整数都能唯一地写做质数或多个质数的积

9. **Theorem**: n 是合数(composite) $\to$ n 至少有一个 prime divisor $\leq\sqrt{n}$

10. **Mersenne Prime**: a prime of the form $2^p  − 1$, where p is prime

11. **The Euclidean Algorithm**  $O(\log\min(a,b))$

    ```pseudocode
    procedure gcd(a,b:positive integers)
    x:=a
    y:=b
    while y ≠ 0
    	r:=x mod y
    	x:=y
    	y:=r
    return x{gcd(a,b)is x}
    ```

12. **Lemma**: $(a = b · q + r)\to (\gcd(a, b) = \gcd(b, r))$.
    **Proof:**

> - For any d such that d | a and d | b, d also divides a − b · q = r.
>   Hence, any common divisor of a and b must also be a common
>   divisor of b and r. This implies gcd(a, b) ≤ gcd(b, r).
> - For any d such that d | b and d | r, d also divides b · q + r = a.
>   Hence, any common divisor of b and r must also be a common
>   divisor of a and b. This implies gcd(a, b) ≥ gcd(b, r).
> - Therefore, $\gcd(a, b) = \gcd(b, r)$.

13. **Bézout’s Theorem**
    $a,b\in\mathbb{Z}^+\to\exists s\exists t(\gcd(a, b) = s · a + t · b)$.

- _Corollary 1_: $(a,b\in\mathbb{Z}^+\land(\gcd(a, b) = 1)
  \land a | bc)\to a | c$
- _Corollary 2_: $(Prime(p)\land p | a_1a_2 ··· a_n)\to\exists i(p | a_i)$

14. **Theorem**:
    $m\in\mathbb{Z}^+$. $a ≡ b \pmod m \land c ≡ d
    \pmod m \to (a + c ≡ b + d \pmod m \land ac ≡ bd \pmod m)$
15. **Theorem**:
    $m\in\mathbb{Z}^+$.
    $ac ≡ bc \pmod m \land (\gcd(c, m) = 1) \to a ≡ b \pmod m$
16. **Theorem**:
    $\gcd(a,m)=1\land m>1\to\exists$ a模m的逆元，
    且该逆元在模m定义下唯一
17. **Theorem**:
    $d=\gcd(a,m)$. $ax \equiv b\pmod m$有解 $\Leftrightarrow$ d|b,且在 $\mathbb{Z}_m$ 中解的个数为d

> 此处省略证明，记得看

18. **中国剩余定理**

    设 $m_1, m_2, \dots, m_k$ 是 **两两互质** 的正整数。对于任意整数 $a_1, a_2, \dots, a_k$，同余方程组：
    $$
    \begin{cases}
    x \equiv a_1 \pmod{m_1} \\
    x \equiv a_2 \pmod{m_2} \\
    \vdots \\
    x \equiv a_k \pmod{m_k}
    \end{cases}
    $$
    $M = m_1 m_2 \cdots m_k$  

    $M_i = \frac{M}{m_i}$  

    $M_i$ 模 $m_i$ 的乘法逆元 $t_i$（即满足 $M_i \cdot t_i \equiv 1 \pmod{m_i}$）

    存在一个整数 $x$（在 $0$ 到 $M-1$ 之间）满足所有方程，并且所有解在模 $M$ 下同余：  
    $$
    x \equiv a_1 M_1 t_1 + a_2 M_2 t_2 + \cdots + a_k M_k t_k \pmod{M}
    $$

19. **费马小定理**: p质， $p\nmid a\to a^{p-1}\equiv1\pmod p$

20. **欧拉定理**:  $ a,n\in\mathbb{Z}^+ $ 互质 $ \to a^{\phi(n)}\equiv1\pmod n $

21. **模素数的原根**:  模素数p的一个原根是一个整数r $ \in\mathbb{Z}_p $ ,使得 $ \mathbb{Z}_p $ 中每个非零元素都是r模p的幂

22. **Theorem**:  存在模n( $n\geq2$ ) $\leftrightarrow$ $n=2,4,p^k,2p^k$ , p是奇素数， $ k\in\mathbb{Z}^+ $

23. **Hash collisions**:

- move to the next available hash value
- add a secondary structure

24. **pseudorandom number generator (PRNG)**:

$$
x_{n+1}=(ax_n+c)\mod m
$$

25. Symmetric cryptography (secret-key)
    Asymmetric cryptography (public-key)
26. One-Time Pad (**OTP**)一次一密: has very long random one-time keys, no integrity...
27. Diffie-Hellman (**DH**) 密钥交换：
    p大质数，g模p的原根

|        | Alice         |                       | Bob           |
| ------ | ------------- | --------------------- | ------------- |
| Secret | a, K          | g, p, A $\Rightarrow$ | b, K          |
|        | $A=g^a\mod p$ | $\Leftarrow$ B        | $B=g^b\mod p$ |
|        | $K=B^a\mod p$ |                       | $K=A^b\mod p$ |

28. **离散对数问题** (Discrete Logarithm Problem): $b^x\equiv y\pmod m$
29. **RSA**: 大质数p，q, $n=pq$, $\phi(n)=(p-1)(q-1)$ , $\gcd(e,\phi(n))=1$ and $ed\equiv1\pmod{\phi(n)}$  

| Encryption  | encrypt m as $c=m^e\mod n$   | (n,e) public-key      |
| ----------- | ---------------------------- | --------------------- |
| Decryption  | decrypt c as $m=c^d\mod n$   | d private-key         |
| Correctness | for each $m\in\mathbb{Z}_n$, | $m^ed\equiv m\pmod n$ |

30. **(Trivial) Additive Secret Sharing**: $s_i$ and $s – \Sigma s_i$ leak no information about s, unless they are all known and summed up
31. **Shamir’s Threshold Secret Sharing** (SSS): f(n)次数 $\leq t-1$, $f(0)=s$

# 06 Induction and Recursion

1. **Well-Ordering Principle 良序原理:** every nonempty subset of $\mathbb{Z}^+$ has a least/minimum element.

   > a well-ordered set S is a set such that every nonempty subset of S
   > has a least element

2. **Hanoi**

   ```pseudocode
   procedure HanoiMove(int n, char a, char b, char c)
   	if(n==1) then print("plate "+n+" from "+a+" to "+c);
   	else then 
   		HanoiMove(n-1,a,c,b);
   		print("plate "+n+" from "+a+" to "+c);
   		HanoiMove(n-1,b,a,c);
   ```

   M(n) = 2M(n – 1) + 1

3. $$
   a^{\log_2n}=n^{\log_2a}
   $$

4. **Master Theorem**:
   $$
   T(n)=aT(n/b)+cn^d
   $$

   - $1\le a\le b^d$ $\Rightarrow$ $T(n)=\Theta(n^d)$
   - $a=b^d$ $\Rightarrow$ $T(n)=\Theta(n^d\log n)$
   - $a\ge b^d$ $\Rightarrow$ $T(n)=\Theta(n^{\log_2a})$

# 07 Counting

1. **The Pigeonhole Principle 鸽笼原理**: N objects are placed 
   into k boxes $\Rightarrow$ there exists at least one box containing at 
   least $\lceil N / k\rceil$ objects

2. **The Division Rule**: a task can be done using a procedure that 
   can be carried out in n “fine-grained” ways, and every “giant” 
   way w corresponds to exactly d of the n “fine-grained” ways, 
   then there are n / d “giant” ways to do it

3. **The Birthday Attack**: 
   $$
   p(n;H):=1-\Pi_{i=1}^{n-1}(1-\frac iH)\\n(p;H)\approx\sqrt{2H\ln\frac1{1-p}}
   $$

4. $$
   \sum_{k=0}^n(_k^n)=2^n
   $$

5. **Pascal’s Identity**: 
   $$
   (_k^n)=(^{n-1}_{k-1})+(^{n-1}_{\;\;k})
   $$

6. **The Binomial Theorem**:
   $$
   \sum_{k=0}^n(_k^n)x^{n-k}y^k=(x+y)^n
   $$

7. **The Principle of Inclusion-Exclusion**:
   $$
   |\cup_{i=1}^nE_i|=\sum_{k=1}^n(-1)^{k+1}\sum_{1\le i_1\le i_2\le...\le i_k\le n}|E_{i_1}\cap E_{i_2}\cap...\cap E_{i_k}|
   $$

8. 设特征方程 $r^k - c_1 r^{k-1} - \cdots - c_k = 0$ 有 $t$ 个不同的根 $r_1, \dots, r_t$，重数分别为 $m_1, \dots, m_t$，其中 $m_i \geq 1$ 且 $m_1 + \cdots + m_t = k$。那么
   $$
   a_n = \sum_{i=1}^t \left( \sum_{j=0}^{m_i-1} \alpha_{i,j} n^j \right) r_i^n, \quad n \geq 0,
   $$
   其中 $\alpha_{i,j}$ 是常数。

9. 

$$(1 + x)^n = \sum_{k=0}^n C(n, k)x^k$$

$$(1 + ax)^n = \sum_{k=0}^n C(n, k)a^kx^k$$

$$(1 + x')^n = \sum_{k=0}^n C(n, k)x^{rk}$$

$$\frac{1 - x^{n+1}}{1 - x} = \sum_{k=0}^n x^k = 1 + x + x^2 + \cdots + x^n$$

$$\frac{1}{1 - x} = \sum_{k=0}^\infty x^k = 1 + x + x^2 + \cdots$$

$$\frac{1}{1 - ax} = \sum_{k=0}^\infty a^kx^k = 1 + ax + a^2x^2 + \cdots$$

$$\frac{1}{1 - x'} = \sum_{k=0}^\infty x'^k = 1 + x' + x^{2r} + \cdots$$

$$\frac{1}{(1 - x)^2} = \sum_{k=0}^\infty (k + 1)x^k = 1 + 2x + 3x^2 + \cdots$$
$$
\frac{1}{(1-x)^n} = \sum_{k=0}^\infty C(n+k-1,k)x^k
$$

$$
\frac{1}{(1+x)^n} = \sum_{k=0}^\infty C(n+k-1,k)(-1)^k x^k
$$

$$
\frac{1}{(1-x)^n} = \sum_{k=0}^\infty C(n+k-1,k)a^k x^k
$$

**Taylor series**
$$
e^x = \sum_{k=0}^\infty \frac{x^k}{k!} = 1 + x + \frac{x^2}{2!} + \frac{x^3}{3!} + \cdots
$$

$$
\ln(1+x) = \sum_{k=0}^\infty \frac{(-1)^{k+1}x^k}{k} = x - \frac{x^2}{2} + \frac{x^3}{3} - \frac{x^4}{4} + \cdots
$$



# 08 Relations

1. 从一个 n 元集 A 到一个 m 元集 B，存在$2^{nm}$个二元关系。

2. $$
   R^*=\underset{k=1}{\overset{n}\cup}R^k
   $$

3. **反对称 (Antisymmetric) 关系**：集合 A 上的关系 R 称为反对称的，如果 (b, a) ∈ R 且 (a, b) ∈ R 蕴含 a = b，对于所有 a, b ∈ A。（$m_{ij}$ = 1 implies $m_{ji}$ = 0 for $i \ne j$）( R = { (2, 2), (3, 3) } ,R反对称同时对称)

4. **自反 (Reflexive) 关系**：集合 A 上的关系 R 称为自反的，如果对于 A 中的每个元素 a，都有 (a, a) ∈ R.（对角线上都是1）

5. **反自反关系**：主对角线上都是0

6. The relation R on a set A is **transitive** $\Leftrightarrow R^n\subseteq R$ for n = 1, 2, 3, … 

7. R is **functional** in domain Ai if R can be **indexed** by ai

8. There is a path of length n from a to b in R (as a directed graph)  $\Leftrightarrow$ (a, b)$\in R^n$

9. The **Floyd-Warshall** algorithm: computes $M_{R^*}$ by iterating on k: in the k-th iteration,  the intermediate nodes of all paths are from the first k nodes only. $\Theta(n^3)$

   ```pseudocode
   procedure Warshall (M_R: zero-one n*n matrix)
   W := M_R;
   for k := 1 to n
   	for i := 1 to n
   		for j := 1 to n
   			w_ij := w_ij V ( w_ik ^ w_kj )
   return W
   ```

   

10. **equivalence relation**= **reflexive**, **symmetric**, and **transitive**

    $R$: equivalence relation, 下面三个等价：

    - $(a,b)\in R$
    - $[a]=[b]$
    - $[a]\cap[b]\neq\emptyset$

11. $R$: equivalence relation
    $$
    S=\underset{a\in S}\cup[a]_R
    $$
    The equivalence classes form a partition of S.

12. Let $\{A_1, A_2, …, A_i, ...\}$ be a **partition** of $S\Rightarrow$ there is an equivalence relation $R$ on $S$, which has the sets $A_i$ as its equivalence classes.

13. **partial ordering**: **reflexive**, **antisymmetric**, and **transitive**. 

14. **total ordering**: 每两个元素都是comparable. $(S,\le)$, totally ordered set or linearly ordered set, chain

15. **well-ordered set** = **total order** + every nonempty subset of S has a **least** element.

16. A partially ordered set in which every pair of elements has both a least upper bound and a greatest lower bound is called a **lattice**

17. partial ordering R, a total ordering $\preceq$ is said to be compatible with R if a $\preceq$ b whenever a R b.

18. Every finite nonempty poset (S, ≼) has at least one 
    minimal element.

19. **Topological sorting**: 

    For any minimal element $a_k$ of S, we have $(S – \{a_k\},\preceq)$, if not empty, is still a poset. 

    ```pseudocode
    procedure topological sort ((S, ≼): finite poset)
      k := 1
      while S ≠ ∅ do
        a_k := a minimal element of S  // such an element exists by Lemma 1
        S := S - {a_k}
        k := k + 1
      end while
      return a_1, a_2, ..., a_n  // a_1, a_2, ..., a_n is a compatible total ordering of S
    ```


# 09 Graphs and Trees

1.  An undirected graph has an **even** number of vertices of **odd** degree
2.  $ G $ is a directed graph $\Rightarrow$  $  |E| = \sum_{v \in V} \deg^{-}(v) = \sum_{v \in V} \deg^{+}(v)$

> This theorem applies even if multiple edges and loops are present.  

3. A simple graph G is **bipartite** $\Leftrightarrow$ $\chi(G)\le2$

4. **Hall’s Marriage Theorem**: 

  The **bipartite** graph has a **injective** function from $ V_1 $ to $ V_2 $  $\Leftrightarrow$ $ |N(A)| \geq |A| $ for all subsets $ A $ of $ V_1 $  

  > Proof of the “if” part by strong induction:
  >
  > - Basis step: obviously true for |V1| = 1 since |N(V1)| ≥ |V1| = 1 
  >
  > - Inductive step: Let k be a positive integer and let G = (V, E) is a 
  >   bipartite graph with bipartition (V1, V2) such that |V1| ≤ k.
  >
  > - Inductive hypothesis: |V1| = k and |N(A)| ≥ |A| holds for all subset 
  >   A ⊆ V1 $\Rightarrow$ there is a complete matching M from V1 to V2.
  >
  >   Now, we prove the inductive step by cases. That is, we prove that 
  >   if |V1| = k + 1 and |N(A)| ≥ |A| holds for all subset A ⊆ V1 $\Rightarrow$ there 
  >   is a complete matching M from V1 to V2.
  >    Suppose |V1| = k + 1. We prove the inductive step 
  >   by considering two cases: 
  >
  >   - Case 1: For every nonempty subset A of at most k vertices from 
  >     V1, the vertices in A are adjacent to at least |A| + 1 vertices of V2, 
  >     i.e., for every A such that A ⊆ V1 and 1 ≤ |A| ≤ k, |N(A)| ≥ |A| + 1.
  >
  >   - Case 2: For some integer j with 1 ≤ j ≤ k, there exists a subset V1
  >     ’ 
  >     of j vertices from V1 such that |N(V1’)| = |V1’| = j ≤ k.
  >
  >     > note that “|N(A)| ≥ |A| for all subsets A of V1” = Case 1 + Case 2

5. The graph isomorphism problem is in **NP**, but is not known to be 
   either in P or in NP-complete. 

6. Finding $\chi(G)$ of an arbitrary graph G (graph coloring problem) is **NP-hard**.  

7. the **Hamilton** path problem and Hamilton circuit problem are **NP-complete**.

8. **Euler’s Formula**: 

   a connected planar simple graph G = (V, E) has $f$ faces $\Rightarrow$ $  |V| - |E| + f = 2 $  

9. a **connected planar simple** graph with $|V| \ge 3 \Rightarrow$   **$  |E| \leq 3|V| - 6 $**

10. A graph G = (V, E) is a tree  $\Leftrightarrow$ 

- it is **connected** and **acyclic** and **|E| = |V| - 1**(三选一)
- it has exactly one simple path between any two of its vertices.
- it is connected, and the removal of any edge disconnects the graph.

12. A connected graph G has an **Euler circuit**  $\Leftrightarrow$ every vertex of G has even degree. 

    A directed graph G has an **Euler circuit**  $\Leftrightarrow$

- G is **strongly connected**, and
- for every vertex v of G, **$deg^+(v) = deg^-(v)$**  

14. A connected graph G has an **Euler trail** but not an Euler
    circuit  $\Leftrightarrow$ G has exactly two vertices of odd degree.

15. **Dirac’s Theorem**: a simple graph G with $|V| = n \ge 3$, $\forall v\in V (\deg(v)\ge n/2)\Rightarrow$ G has a **Hamiltonian circuit**.

16. **Ore’s Theorem**: a simple graph G with $|V| = n \ge 3$,   

    $\forall u,v(Nonadj(u,v)\to \deg(u) + \deg(v) \ge n)$ $\Rightarrow$ G has a **Hamiltonian circuit**.

17. There is a simple path between every pair of distinct 
    vertices of a strongly connected directed graph. 

18. 

```pseudocode
procedure Euler(G: connected multigraph with all vertices of even degree)

circuit := a circuit in G beginning at an arbitrarily chosen vertex with edges successively added to form a path that returns to this vertex

H := G \text{ with the edges of this circuit removed}

while H has edges

	subcircuit := a circuit in H beginning at a vertex in H that also is an endpoint of an edge of circuit

	H := H {with edges of subcircuit and all isolated vertices removed}

	circuit := circuit with subcircuit inserted at the appropriate vertex

return circuit {circuit is an Euler circuit}
```

find an arbitrary circuit C

*why always possible?*

$H = G - C$

find a circuit $ C' $ in $ H $ such that  
$ C $ and $ C' $ share some vertex  
*why always possible?*

$H = H - C'$

$C = C + C'$

19. A **planar** graph has a vertex of degree at most **5**. 

20. G is a connected **planar** simple graph, $|V|\ge 3$ vertices, and has no circuits of length 3, 
    $\Rightarrow$ $|E| \le 2|V| − 4$.
21. a graph is **planar**, so will be any graph obtained by 
    removing an edge {u, v} and adding a new vertex w together 
    with edges {u, w} and {w, v}. Such an operation is called an 
    **elementary subdivision**. 
22. **Kuratowski’s Thereom**: A graph is **nonplanar**  $\Leftrightarrow$ it 
    contains a subgraph **homeomorphic** to $K_{3,3}$ or $K_5$.
23. A full $ m $-ary tree with  
    (i) $ n $ vertices  
    has $ i = (n - 1)m $ internal vertices and $ \ell = [(m - 1)n + 1]m $ leaves,  
    (ii) $ i $ internal vertices  
    has $ n = mi + 1 $ vertices and $ \ell = (m - 1)i + 1 $ leaves,  
    (iii) $ \ell $ leaves  
    has $ n = (m\ell - 1)(m - 1) $ vertices and $ i = (\ell - 1)(m - 1) $ internal vertices.
24. There are $\leq m^h$ leaves in an $ m $-ary tree of height $ h $.
25. Consider any $ m \geq 2 $. an $ m $-ary tree of height $ h $ has $\ell$ leaves $\Rightarrow$ $ h \geq \lceil \log_{m}\ell \rceil $. the $ m $-ary tree is full and balanced $\Rightarrow$ $ h = \lceil \log_{m}\ell \rceil $
26. A simple graph is **connected**  $\Leftrightarrow$ it has a **spanning** tree.
27. **procedure** $ DFS(G $: connected graph with vertices $ v_1, v_2, \ldots, v_n $ )  
    $ T := $ tree consisting only of the vertex $ v_1 $  
    $ visit(v_1) $

**procedure** $ visit(v $: vertex of $ G $ )  
**for** each vertex $ w $ adjacent to $ v $ and not yet in $ T $  
add vertex $ w $ and edge $\{v, w\}$ to $ T $  
$ visit(w) $

- Time complexity: $ O(e) $

**procedure** $ BFS(G $: connected graph with vertices $ v_1, v_2, \ldots, v_n $  
$ T := $ tree consisting only of vertex $ v_1 $  
$ L := $ empty list  
put $ v_1 $ in the list $ L $ of unprocessed vertices  

**while** $ L $ is not empty  
remove the first vertex, $ v $, from $ L $  
**for** each neighbor $ w $ of $ v $  
if $ w $ is not in $ L $ and not in $ T $ then  
add $ w $ to the end of the list $ L $  
add $ w $ and edge $\{v, w\}$ to $ T $  

- Time complexity: $ O(e) $

procedure $ Prim(G: $ weighted connected undirected graph with $ n $ vertices)

$ T := $ a minimum-weight edge  
for $ i := 1 $ to $ n - 2 $

$ e := $ an edge of minimum weight incident to a vertex in $ T $ and not forming a simple circuit in $ T $ if added to $ T $

$ T := T $ with $ e $ added  
return $ T $ {$ T $ is a minimum spanning tree of $ G $}

add min-weight edge incident to $ T $  
(not forming a circuit)

- Time complexity: $ O(e \log v) $
  - keeping vertices not yet in T in a priority queue


**procedure** *Kruskal(G: weighted connected undirected graph with $ n $ vertices)*  
$ T := \text{empty graph} $  
*start from an empty tree*  

**for** $ i := 1 $ **to** $ n - 1 $  

- $ e := \text{any edge in } G \text{ with smallest weight that does not form a simple circuit when added to } T $  
  $ T := T \text{ with } e \text{ added} $  
  *add min-weight edge (not forming a circuit)*  

**return** $ T $ {$ T \text{ is a minimum spanning tree of } G $}

- Time complexity: O(e log e)  
  • sorting all edges + union-find data structure  
  • better for sparse graphs 
