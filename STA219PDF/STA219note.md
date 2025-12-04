STA219 note

# 0 积分公式

1. 

$$
\int_{a}^{b} f(x)\, g'(x)\,dx
   = \bigl[f(x)g(x)\bigr]_{a}^{b}
- \int_{a}^{b} f'(x)\, g(x)\,dx
$$

2. $$
   J_F(x,y)=
   \begin{bmatrix}
   \frac{\partial f_1}{\partial x} & \frac{\partial f_1}{\partial y}\\
   \frac{\partial f_2}{\partial x} & \frac{\partial f_2}{\partial y}
   \end{bmatrix}.
   $$
3. $d\tan x=\sec^2x$
   
   $d\sec x=\sec x\tan x$
   
   $d\cot x=-\csc^2x$
   
   $d\csc x=-\csc x\cot x$
   
   $d\sin^{-1}x=\frac{1}{\sqrt{1-x^2}}$
   
   $d\cos^{-1}x=-\frac{1}{\sqrt{1-x^2}}$
   
   $d\tan^{-1}x=\frac{1}{1+x^2}$
4. Taylor series
   
   $$
   \frac{1}{1-x}
    = 1 + x + x^2 + \cdots + x^n + \cdots
    = \sum_{n=0}^{\infty} x^n,\qquad |x|<1.
   $$
   
   $$
   \frac{1}{1+x}
    = 1 - x + x^2 - \cdots + (-x)^n + \cdots
    = \sum_{n=0}^{\infty} (-1)^n x^n,\qquad |x|<1.
   $$
   
   $$
   e^{x}
    = 1 + x + \frac{x^{2}}{2!} + \cdots + \frac{x^{n}}{n!} + \cdots
    = \sum_{n=0}^{\infty} \frac{x^{n}}{n!},\qquad x\in\mathbb{R}.
   $$
   
   $$
   \sin x
    = x - \frac{x^{3}}{3!} + \frac{x^{5}}{5!} - \cdots + (-1)^n\frac{x^{2n+1}}{(2n+1)!} + \cdots
    = \sum_{n=0}^{\infty} (-1)^n \frac{x^{2n+1}}{(2n+1)!},\qquad x\in\mathbb{R}.
   $$
   
   $$
   \cos x
    = 1 - \frac{x^{2}}{2!} + \frac{x^{4}}{4!} - \cdots + (-1)^n\frac{x^{2n}}{(2n)!} + \cdots
    = \sum_{n=0}^{\infty} (-1)^n \frac{x^{2n}}{(2n)!},\qquad x\in\mathbb{R}.
   $$
   
   $$
   \ln(1+x)
    = x - \frac{x^{2}}{2} + \frac{x^{3}}{3} - \cdots + (-1)^{n-1}\frac{x^{n}}{n} + \cdots
    = \sum_{n=1}^{\infty} (-1)^{n-1}\frac{x^{n}}{n},\qquad -1<x\le 1.
   $$
   
   $$
   \tan^{-1}x
    = x-\frac{x^{3}}{3}+\frac{x^{5}}{5}-\cdots+(-1)^n\frac{x^{2n+1}}{2n+1}+\cdots
    = \sum_{n=0}^{\infty}(-1)^n\frac{x^{2n+1}}{2n+1},\qquad |x|\le 1.
   $$

# 1 Basic Ideas in Probability

1. **容斥原理**:
   $P(A_1\cap A_2\cap...\cap A_n)=\sum_{i=1}^{n}P(A_i)-\sum_{1\leq i<j\leq n}P(A_iA_j)+...(-1)^{n-1}P(A_1A_2...A_n)$
2. $C_n^k=(_k^n)=\frac{n!}{k!(n-k)!}$

# 2 Random Variables and Distribution

1. **琴生**:
   凸: $E(g(X))\geq g(E(X))$
   凹: $E(g(X))\leq g(E(X))$

- $E(|X|) \geq |E(X)|$ $(g(x) = |x|)$
- $E(X^2) \geq (E(X))^2$ $(g(x) = x^2)$
- $E(|X|^p) \geq |E(X)|^p$ 对于 $p \geq 1$ $(g(x) = |x|^p,  p \geq 1)$
- $E(e^{cX}) \geq e^{cE(X)}$ $(g(x) = e^{cX})$

2. $Y=g(X)$, $h(y)=g^{-1}(y)$,
   $\Rightarrow f_Y(y)=\left\{\begin{aligned}|h'(y)|\cdot f_X(h(y)), 在h(y)有定义处\\
   0，否则\end{aligned}\right.$
3. | 分布                   | PDF/PMF                                                      | 期望                | 方差                  |
   | :--------------------- | ------------------------------------------------------------ | ------------------- | --------------------- |
   | 均匀 $(a, b)$          | $f(x) = \begin{cases} \frac{1}{b-a}, & \text{if } a < x < b \\ 0, & \text{otherwise} \end{cases}$ | $\frac{a+b}{2}$     | $\frac{(b-a)^2}{12}$  |
   | 正态 $(\mu, \sigma^2)$ | $f(x) = \frac{1}{\sqrt{2\pi}\sigma} e^{-\frac{(x-\mu)^2}{2\sigma^2}}$ | $\mu$               | $\sigma^2$            |
   | 指数 $(\lambda)$       | $f(x) = \begin{cases} \lambda e^{-\lambda x}, & \text{if } x \geq 0 \\ 0, & \text{otherwise} \end{cases}$ | $\frac{1}{\lambda}$ | $\frac{1}{\lambda^2}$ |
   | 几何 (p)(无记忆离散)   | $p(x)=p(1-p)^{x-1}$                                          | $\frac{1}{p}$       | $\frac{1-p}{p^2}$     |
   | 泊松($\lambda$)        | $p(x)=\frac{\lambda^x}{x!}e^{-\lambda}$                      | $\lambda$           | $\lambda$             |
   | 二项(n,p)              | $p(x)=C_n^xp^x(1-p)^{n-x}$                                   | np                  | np(1-p)               |
   | 伯努利(p)              | $p(x)=p^x(1-p)^{1-x}$                                        | p                   | p(1-p)                |
   
4. 泊松: 计算在特定时间段内发生 **k** 次事件的概率;
   
   指数: 计算下一个事件发生的时间是否在某个时间点之前
5. 标准化：$Z=\frac{X-\mu}{\sigma}$
6. $E(X)=\int_{-\infty}^{\infty}xf(x)dx$
7. $E(Y)=E(g(X))=\int_{-\infty}^{\infty}g(x)f(x)dx$
8. $\text{Var(X)}=E(X-E(X))^2=E(X^2)-[E(X)]^2=\int_{-\infty}^{\infty}[x-E(X)]^2f(x)dx$

# 3 Joint Distributions

1. $\text{Cov}(X,Y)=E(XY)-E(X)E(Y)=E[(X-E(X))(Y-E(Y))]$

2. $\text{Cov}(aX,bY)=ab\text{Cov}(X,Y)$

3. $\text{Var}(X\pm Y )=\text{Var}(X)+\text{Var}(Y)\pm 2\text{Cov}(X,Y)$

4. $\text{Cov}(\sum_{i=1}^{n}a_iX_i,\sum_{j=1}^{m}b_jY_j)=\sum_{i=1}^{n}\sum_{i=1}^{m}a_ib_j\text{Cov}(X_i,Y_j)$

5. $\rho_{XY}=Cor(X,Y)=\frac{\text{Cov}(X,Y)}{\sqrt{\text{Var}(X)\text{Var}(Y)}}$

6. **MSE**:
   $b_0=\frac{\text{Cov}(X,Y)}{\text{Var}(X)}$
   $a_0=E(Y)-\frac{\text{Cov}(X,Y)}{\text{Var}(X)}E(X)$
   $\min\limits_{a,b}MSE=\text{Var}(Y)(1-\rho^2_{XY})$

7. **Law of total expectation**: $E(X)=E((X|Y))$

   $E(X)=\int_{-\infty}^\infty E(X|Y=y)\cdot f_Y(y)dy$

8. **convolution (卷积)**: $ f_z(z)=f_X*f_Y\triangleq\int_{-\infty}^\infty f_X(z-y)f_Y(y)dx=\int_{-\infty}^\infty f_X(x)f_Y(z-x)dx$, (X,Y独立)

9. **伽马分布**$Gamma(r,\lambda)$: $ f_Z(z)= \begin{cases}\frac{\lambda^r}{(r-1)!}z^{r-1}e^{-\lambda z}, & z>0 \\ 0, & \text{otherwise} \end{cases}$, $Z=T_1+T_2+...+T_r$

10. **Central Limit Theorem (CLT, 中心极限定理)**: 
    $$
    Z_n=\frac{S_n-\mathrm{E}(S_n)}{\sqrt{\mathrm{Var}(S_n)}}
    =\frac{S_n-n\mu}{\sqrt{n\sigma^2}}
    =\frac{\sqrt{n}\,(\bar X_n-\mu)}{\sigma}.
    $$

​	$Z_n$ **converges in distribution (依分布收敛)** :  
$$
F_{Z_n}(z)=\Pr(Z_n\le z)\xrightarrow[n\to\infty]{}\Phi(z)\;\text{for all }z.
$$

11. **normal approximation to binomial distribution (二项分布的正态近似)**:  
    $$
    % 标准化后近似标准正态
    \frac{S_n-\mathrm{E}(S_n)}{\sqrt{\mathrm{Var}(S_n)}}
    =\frac{S_n-np}{\sqrt{np(1-p)}}
    \ \overset{\text{approx.}}{\sim}\ \mathcal{N}(0,1)\\
    S_n\ \overset{\text{approx.}}{\sim}\ \mathcal{N}\!\big(np,\;np(1-p)\big)
    $$

12. When $p$ is small, the Poisson approximation is better while the normal approximation is better for large $p$.

13. **bivariate normal distribution (二元正态分布)**：
    $$
    f(x,y)
    = \frac{1}{2\pi\,\sigma_X\sigma_Y\sqrt{1-\rho^2}}
    \exp\!\left\{
    -\frac{1}{2(1-\rho^2)}
    \left[
    \frac{(x-\mu_X)^2}{\sigma_X^2}
    - 2\rho\,\frac{(x-\mu_X)(y-\mu_Y)}{\sigma_X\sigma_Y}
    + \frac{(y-\mu_Y)^2}{\sigma_Y^2}
    \right]
    \right\}.
    $$

    $$
    \begin{pmatrix}X\\ Y\end{pmatrix}
    \sim \mathcal{N}\!\left(
    \begin{pmatrix}\mu_X\\ \mu_Y\end{pmatrix},
    \begin{pmatrix}
    \sigma_X^2 & \rho\,\sigma_X\sigma_Y\\
    \rho\,\sigma_X\sigma_Y & \sigma_Y^2
    \end{pmatrix}
    \right)
    = \mathcal{N}(\boldsymbol{\mu},\boldsymbol{\Sigma}).
    $$

    

14. X and Y are independent $\to$ X and Y are uncorrelated

15. $$
    X|Y=y\sim N(\mu_X+\frac{\rho\sigma_X}{\sigma_Y}(y-\mu_Y),(1-\rho^2)\sigma_X^2)
    $$

# 4 Monte Carlo Methods

1.  **weak law of large numbers (LLN, 大数定律)**

   - $X_1, X_2, \ldots$ random variables  
     
     $\mu \triangleq E(X_i) < \infty$,  
     $\bar X_n = (X_1 + X_2 + \cdots + X_n)/n$.
     
   - $\bar X_n$ **converges in probability**（依概率收敛）to $\mu$ as $n \to \infty$:

     $$\bar X_n \xrightarrow{P} \mu,\quad \text{as } n \to \infty.$$

   - For any $\varepsilon > 0$,

     $$\lim_{n\to\infty} P\left(\left|\frac{1}{n}\sum_{i=1}^n X_i - \mu\right| > \varepsilon\right) = 0.$$
     
   - $\bar X_n\overset{\text{approx.}}{\sim}N(\mu,\frac{\sigma^2}{n})$

2.  **Inverse transformation sampling (逆变换采样)**

   若F(x)是某个连续随机变量的分布函数（CDF），且其反函数 $F^{-1}(x)$存在，
    令$U \sim U[0,1]$，则$X = F^{-1}(U) \sim F(x)$.

3. $N(0,1)$分布的随机数: 

   若 $U_1 \sim U[0,1]$，$U_2 \sim U[0,1]$独立，令

$$
Z_1 = \sqrt{-2\ln U_1}\cos(2\pi U_2),\quad   Z_2 = \sqrt{-2\ln U_1}\sin(2\pi U_2),
$$

则 $Z_1$, $Z_2$为一对独立的标准正态随机变量。

对于$N(\mu,\sigma^2)$， $y_i=\mu+\sigma z_i$.

4. **拒绝采样**

   目标分布（target distribution) 从某个难以直接采样的分布, 其 PDF 为 f(x)，采样。

   参考分布/建议分布（proposal distribution）改为从一个容易采样的分布 g(x) 取样

   - 从proposal分布g(x)采样得到$x_i$

   - $u_i\sim U[0,1]$

   - 拒绝$x_i$若$u_i>\frac{f(x_i)}{cg(x_i)}$

   - 接受 
     $$
     P\!\left(U \le \frac{f(X)}{c\,g(X)}\right)
     = \int_{-\infty}^{\infty} P\!\left(U \le \frac{f(X)}{c\,g(X)} \,\middle|\, X = x\right) g(x)\,dx
     = \int_{-\infty}^{\infty} \frac{f(x)}{c\,g(x)} g(x)\,dx
     = \frac{1}{c}.
     $$

   - 为提高效率, $c$尽量小

   - $c=\sup_x\frac{f(x)}{g(x)}$,理想情况下接受率最高   

5. CDF of the accepted numbers $F(t)=\int_{-\infty}^t f(x)dx$

6. 

   

# 5 Basic Concepts in Statistics

> $X_1,...,X_n$ 是来自总体$ X∼f(x;\theta_1,...,\theta_k),X∼f(x;\theta_1,...,\theta_k)$ 的一个简单随机样本

1. Sample variance (样本方差)
   $$
   S^2=\frac1{n-1}\sum_{i=1}^n(X_i-\bar{X})^2
   $$
   

2. **Sample p-quantile** (样本p分位数)
   $$
   Q_p=\begin{cases} 
   X_{(np+1)}, & \text{如果 } np \text{ 不是整数} \\ 
   \frac{X_{(np)} + X_{(np+1)}}{2}, & \text{如果 } np \text{ 是整数}
   \end{cases}
   $$
   

3. 若$\forall\theta\in\Theta$, $E_\theta(\hat\theta_l)=\theta_l$, 则 $\hat\theta_l$ 是$\theta$的**无偏估计量**, 否则是**有偏估计量**. $E_\theta(\hat\theta_l)-\theta_l$是偏差. 若偏差不为0但收敛为0($n\to\infty$), 则 $\hat\theta_l$是 $\theta$ **渐近无偏估计量**

4. 如果对于 ∀𝜃∈Θ和 ∀𝜖>0，我们有
   $$
   \lim_{n\to\infty}P_\theta(|\hat\theta_i-\theta_i|>\epsilon)=0
   $$
   

   那么$\hat\theta_i$称为$\theta_i$的一个**相合估计量**。

5. 

- 一个（渐近）无偏估计量可能不是一个相合估计量。
- 一个相合估计量可能不是一个（渐近）无偏估计量。

6. 如果$\hat\theta$ 是$\theta$的一个渐近无偏估计量，并且当$n\to\infty$ 时$Var(\hat\theta)\to0$，那么$\hat\theta$是$\theta$的一个相合估计量

7. **切比雪夫不等式**

   Let X be a random variable with mean 𝜇 = E(X) and variance $\sigma ^2$ = Var(X) both exists, then
   $$
   P(|X-\mu|\ge k\sigma)\le\frac1{k^2}
   $$

8. No matter what is the population distribution, if the population mean $\mu=E(X)$ and population
   variance $\sigma=Var(X)$ exist, then $\hat\mu=\bar X$ and $\hat\sigma^2=S$ are consistent estimators of $\mu$ and $\sigma ^2$  

9.  **总体𝑘阶矩**: $\mu_k=E(X^k)$    

   **样本𝑘阶矩**: $M_k=\frac1n\sum_{i=1}^nX^k_i$  

   **总体𝑘阶中心矩**: $\tilde\mu_k=E[(X-\mu_1)^k]$    

   **样本𝑘阶中心矩**: $\tilde M_k=\frac1n\sum_{i=1}^n(X_i-\bar X)^k$  

10. 一个参数的矩估计量可能不是唯一的。

11. **似然函数**: 
    $$
    L(\theta;x_1,
     ,...,x_n)=\Pi_{i=1}^nf(x_i;\theta),\theta\in\Theta.
    $$
    如果存在 $\hat{\theta} = \hat{\theta}(x_1, ..., x_n)$ 使得

    $$
    L(\hat{\theta}) = \max_{\theta \in \Theta} L(\theta; x_1, ..., x_n),
    $$

    (估计量和估计值都可以表示为 $\hat{\theta}_0$。)

    - 那么 $\hat{\theta}(x_1, ..., x_n)$ 是 $\theta$ 的极大似然估计值 (极大似然估计值)，对应的估计量 $\hat{\theta}(X_1, ..., X_n)$ 是 $\theta$ 的极大似然估计量 (极大似然估计量)。

    - 最大化 $L(\theta; x)$ 等价于最大化对数似然函数 (对数似然函数):

    $$
    \ell(\theta; x) = \log L(\theta; x) = \sum_{i=1}^n \log f(x_i; \theta).
    $$

12. - 在温和的正则条件下，矩估计量和极大似然估计量都是相合且渐近无偏的估计量。
    - 在温和的正则条件下，对于大样本，极大似然估计量具有近似正态分布。这个性质称为**渐近正态性** (**渐近正态性**)。

13. | 分布              | 似然函数                                                     | 对数似然函数                                                 | 极大似然估计量                                               |
    | ----------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
    | $U(0,\theta)$     | $\frac1{\theta^n}$                                           | $-n\log n$                                                   | $X_{(n)}$                                                    |
    | $N(\mu,\sigma^2)$ | $(\sqrt{2\pi})^{-n} (\sigma^2)^{\frac{n}{2}} e^{-\frac{1}{2\sigma^2} \sum_{i=1}^n (x_i - \mu)^2}$ | $-n \log (\sqrt{2\pi}) - \frac{n}{2} \log (\sigma^2) - \frac{1}{2\sigma^2} \sum_{i=1}^n (x_i - \mu)^2$ | $\hat\mu=\bar{X}, \hat{\sigma}^2 = \frac{1}{n} \sum_{i=1}^n (X_i - \bar{X})^2 = \hat{S}^2$ |

    

14. 对于 $\forall \alpha \in (0, 1)$，如果存在两个统计量 $\hat{\theta}_{11}(X_1, ..., X_n)$ 和 $\hat{\theta}_{12}(X_1, ..., X_n)$ 使得  

    $$
    P_\Theta(\hat{\theta}_{11} < \theta_i < \hat{\theta}_{12}) \geq 1 - \alpha, \forall \Theta \in \Theta,
    $$
     那么 $(\hat{\theta}_{i1}, \hat{\theta}_{i2})$ 称为 $\theta_i$ 的一个置信水平为 $1 - \alpha$ 的**置信区间**（置信水平为 $1 - \alpha$ 的置信区间），或简称为一个 $100(1 - \alpha)\%$ 置信区间。

15. $X\sim N(\mu,\sigma ^2)$, $P(\bar X-c_1<\mu<\bar X+c_2)=1-\alpha$, $\bar X\sim   N(\mu, \frac{\sigma^2}n)$  

    $c_1=c_2=z_{\alpha/2}\frac\sigma{\sqrt{n}}$,  $z_{\alpha/2}$是标准正态分布的上$\alpha/2$分位点。

16. $X\sim N(\mu,\sigma ^2)$, 如果$\sigma ^2$未知，求$\mu$的置信区间. 
    $$
    1-\alpha=P(\mu-c_2<\bar X<\mu+c_1)=P(-\frac{\sqrt nc_2}S<T<\frac{\sqrt nc_1}S)\\
    T=\frac{\bar X-\mu}{S/\sqrt n}
    $$
    当n很大时，$T\overset{approx}\sim N(0,1)$

    **大样本置信区间**: $( \overline{X} - z_{\alpha/2} \frac{S}{\sqrt{n}}, \overline{X} + z_{\alpha/2} \frac{S}{\sqrt{n}}).$  

17. - $\hat{\theta}_i(X_1, \ldots, X_n)$ 是 $\theta_i$ 的一个无偏估计量，且 $\hat{\theta}_i$ 的标准差为 $\sigma(\hat{\theta}_i) = SD(\hat{\theta}_i)$（称为 $\hat{\theta}_i$ 的标准误差（标准误差））。

    - 如果 $\hat{\theta}_i$ 精确服从正态分布，即 $\hat{\theta}_i \sim N(\theta_i, \sigma^2(\hat{\theta}_i))$，并且 $\sigma^2(\hat{\theta}_i)$ 不依赖于任何未知参数，那么 $\theta_i$ 的一个精确 $100(1 - \alpha)\%$ 置信区间为
    $$
    \hat{\theta}_i \pm z_{\alpha/2}\sigma(\hat{\theta}_i) = (\hat{\theta}_i - z_{\alpha/2}\sigma(\hat{\theta}_i), \hat{\theta}_i + z_{\alpha/2}\sigma(\hat{\theta}_i)).
    $$

    - 如果 $\hat{\theta}_i$ 的 $N(\theta_i, \sigma^2(\hat{\theta}_i))$ 或 $\sigma^2(\hat{\theta}_i)$ 依赖于未知参数且 $\sigma^2(\hat{\theta}_i)$ 是 $\sigma^2(\hat{\theta}_i)$ 的一个相合估计量，那么 $\theta_i$ 的一个大样本 $100(1 - \alpha)\%$ 置信区间为
    $$
    \hat{\theta}_i \pm z_{\alpha/2}\hat{\sigma}(\hat{\theta}_i) = (\hat{\theta}_i - z_{\alpha/2}\hat{\sigma}(\hat{\theta}_i), \hat{\theta}_i + z_{\alpha/2}\hat{\sigma}(\hat{\theta}_i)).
    $$

    - 常用值：$z_{0.10} = 1.282$, $z_{0.05} = 1.645$, $z_{0.025} = 1.960$, $z_{0.01} = 2.326$, $z_{0.005} = 2.576$.

# 6

1. 
