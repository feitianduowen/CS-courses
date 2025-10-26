CS201 Note

# 05 Number Theory and Cryptography

1. a|b b能被a整除

2. $ab\mod m=(𝑎\mod m)(𝑏\mod m)\mod  m$

3. $a_{+m}b=(a+b)\mod m$,    $a_{\cdot m}b=(a\cdot b)\mod m$

   Modular Arithmetic Properties

    - Closure
    - Associativity 结合性
    - Identity Elements 单位元  if $a\in \mathbb{Z}_m$, then $a_{+m}0=a$ and $a_{\cdot m}1=a$
    - Additive Inverses
    - Commutativity 交换性
    - Distributivity

4. 二进制加法$O(n)=O(\max(\log a,\log b))$

5. 二进制乘法$O(n^2)=O(\log a\log b)$

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

    - (low) $\Theta(q\log a)=\Theta(2^{\log_{2}q\log d})$, $\log_2 q\approx\log_2 a+\log_2 d(input\;size) $

    - (high)$O(\log a\cdot\max(\log q,\log d))$

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
7. **快速模幂运算**$O(\log b\log m+\log n(\log m)^2)$

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
>- For any d such that d | a and d | b, d also divides a − b · q = r. 
>Hence, any common divisor of a and b must also be a common 
divisor of b and r. This implies gcd(a, b) ≤ gcd(b, r).
>- For any d such that d | b and d | r, d also divides b · q + r = a.   
>Hence, any common divisor of b and r must also be a common 
>divisor of a and b. This implies gcd(a, b) ≥ gcd(b, r). 
>- Therefore, gcd(a, b) = gcd(b, r).  
13. **Bézout’s Theorem**  
$a,b\in\mathbb{Z}^+\to\exists s\exists t(\gcd(a, b) = s · a + t · b)$.
- _Corollary 1_: $(a,b\in\mathbb{Z}^+\land(\gcd(a, b) = 1)
    \land a | bc)\to a | c$
- _Corollary 2_: $(Prime(p)\land p | a_1a_2 ··· a_n)\to\exists i(p | a_i)$
14. **Theorem**:  
$m\in\mathbb{Z}^+$. $a ≡ b (\mod m) \land c ≡ d
    (\mod m) \to (a + c ≡ b + d (\mod m) \land ac ≡ bd (\mod m))$ 
15. **Theorem**:  
    $m\in\mathbb{Z}^+$.  
$ac ≡ bc (\mod m) \land (\gcd(c, m) = 1) \to a ≡ b (\mod m)$
16. **Theorem**:  
$\gcd(a,m)=1\land m>1\to\exists$a模m的逆元，  
且该逆元在模m定义下唯一
17. **Theorem**:  
d=gcd(a,m). ax$\equiv$b(mod m)有解$\leftrightarrow$d|b,且在$\mathbb{Z}_m$中解的个数为d  
