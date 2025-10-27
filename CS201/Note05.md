CS201 Note

# 05 Number Theory and Cryptography

1. a|b: b能被a整除

2.  $ab\mod m=(𝑎\mod m)(𝑏\mod m)\mod m$

3.  $a_{+m}b=(a+b)\mod m$,    $a_{\cdot m}b=(a\cdot b)\mod m$

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

8. **Fundamental Theorem of Arithmetic** 算术基本定理 （任何不小于的整数都能唯一地写做质数或多个质数的积）

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
> - Therefore, gcd(a, b) = gcd(b, r).

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
    d=gcd(a,m). ax $\equiv$ b(mod m)有解 $\leftrightarrow$ d|b,且在 $\mathbb{Z}_m$ 中解的个数为d

> 此处省略证明，记得看

18. **中国剩余定理**:
    $m_1,m_2,...m_n\in\mathbb{Z}^+$, 两两互质 $\geq2$， $a_1,a_2,...,a_n\in\mathbb{Z}$,
    同余方程组

$$
x\equiv a_1\pmod{m_1}
$$

$$
x\equiv a_2\pmod{m_2}
$$

$$
...
$$

$$
x\equiv a_n\pmod{m_n}
$$


在模 $M=m_1m_2...m_n$ 下有唯一解

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
