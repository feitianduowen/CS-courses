CS201 Note
# 04 Complexity of Algorithms
1. $|f(x)|\leq C|g(x)|\Rightarrow f(x)=O(g(x))$  
$\log n!=O(n\log n)$  
$(f_1+f_2)(x)=O(\max(|g_1(x)|,|g_2(x)|))$  
$(f_1f_2)(x)=O(g_1g_2(x))$  
2. $|f(x)|\geq C|g(x)|$
3. $f(x)=\Theta(f(x))$
4.  we should use the input size( $L=\log_2 n$ ) to measure complexity.  
5. **Polynomial-time algorithm**: 运行时间为$O(n^c)$的算法，常数c>0且与n无关  
   **Non-Polynomial-Time Algorithms**
6. **Tractable Problems**: 在一个多项式时间算法可以解决该问题  
7. **Class P**: 由所有可以在多项式时间内解决的判定问题组成  
8. **Certificates** for a yes-input is a specific object that is used to verify/prove/show that this input is indeed a yes-input
9. **Class NP**: (非确定性多项式时间)由所有满足以下条件的判定问题组成：  
存在一个多项式时间算法V，使得  
an input == a yes-input  
$\leftrightarrow$   
there is a certificate
   with which V can verify the input is indeed a yes-input.
10. **NP-Complete**: 由 NP 中最难的问题组成。NP完全问题可以相互规约，即，它们是同等困难的。
11. **NP-Hard**: 由至少与 NP完全问题一样困难的判定问题组成。不一定属于NP
     
