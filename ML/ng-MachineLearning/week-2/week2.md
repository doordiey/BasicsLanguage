# week-2

## Environment Setup Instructions

## Multivariate Linear Regression

### Multiple Features

当线性回归问题有了多个特征量。

即多元线性回归。

### Gradient Descent for Multiple Variables

$$
\begin{align*}h_\theta(x) =\begin{bmatrix}\theta_0 \hspace{2em} \theta_1 \hspace{2em} ... \hspace{2em} \theta_n\end{bmatrix}\begin{bmatrix}x_0 \newline x_1 \newline \vdots \newline x_n\end{bmatrix}= \theta^T x\end{align*}
$$

参数更新公式：
$$
\begin{align*}& \text{repeat until convergence:} \; \lbrace \newline \; & \theta_j := \theta_j - \alpha \frac{1}{m} \sum\limits_{i=1}^{m} (h_\theta(x^{(i)}) - y^{(i)}) \cdot x_j^{(i)} \; & \text{for j := 0...n}\newline \rbrace\end{align*}
$$

### Gradient Descent in Practice I - Feature Scaling

#### 特征缩放

使多个特征的在一个相似较合适的范围内，使梯度下降速度变快。

归一化处理

### Gradient Descent in Practice II - Learning Rate

#### 学习率

If α is too small: slow convergence.

If α is too large: ￼may not decrease on every iteration and thus may not converge.

#### 自动收敛测试

### Features and Polynomial Regression

#### 一些选择特征的方法

## Computing Parameters Analytically

### Normal Equation

 #### 正规方程



##### 优点：

- 不需要选择学习速率
- 不需要迭代

##### 缺点：

- 需要求解矩阵，当N大时，求解参数困难。

### Normal Equation Noninvertibility

#### 正规方程不可逆性

#### Octave 求解矩阵的逆的两个函数：

- pinv（）展现数学上的过程
- inv（）

#### 当矩阵不可逆时的原因及解决方法

###### 原因：

- 其中有特征之间关系密切（线性相关

- 特征过多

###### 方法:

- 减少一些特征
- 使用正则化

## Submitting Programming Assignments

提交作业。

### Working on and Submitting Programming Assignments

## Octave/Matlab Tutorial

### Basic Operations

``` octave
1 == 2 % false  百分号为注释
1 && 0 % 逻辑与
1 || 0 % 逻辑或
PS1('>>'); %使命令行精简
% semicolon supressing output 不输出
disp 命令
sprintf 命令
format % 默认输出数据格式
v = 1:0.1:2 % 表示从1开始，以步长0.1增长到2的集合v
ones(m,n) %建立一个m行n列的值均为1的矩阵
zeros(m,n) %建立一个m行n列的值均为0的矩阵
randn(m,n) %建立一个m行n列的值为任意的矩阵
hist(m,z) %建立函数m的直方图，直方图有n个横坐标的值
help %命令大全
eye(n) %生成n行n列的单位矩阵
```

### Moving Data Around

```octave
size(A) %返回矩阵的行 列
length(V) %返回向量的维度
load %命令加载文件
who %显示当前工作空间内的全部变量
whos %显示比who更详细的变量信息
clear %去除某个变量
save %将变量存储于硬盘空间内的文件
： %冒号表示该行或该列的所有元素

```

#### 索引操作

### Computing on Data

```octave
A .* B % 结果为A中的每个值乘以对应位置的B的值
exp() %
abs() % 所有的都加绝对值
A' %返回A矩阵的转置
max(A) %矩阵每一列的最大值
find() %
magic() %
floor() %
prod() %
ceil() %
pinv() %

```

### Plotting Data

关于画图。

```octave
plot(x,y,'r') %以x为横轴，y为纵轴,线为红色。
hold on  %在同一个图内继续作图
xlabel('') %定义横轴名称
ylabel('') %定义纵轴名称
legend %定义标识图
title('') %定义标题
subplot %将图像拆分。
clf %将作图清除
imagesc %作灰度分布图
%使用逗号可进行函数连续调用。
```

### Control Statements:for,while,if statement

一些控制语句。

要在函数文件到目录下才可以运行。

或者使用Octave search path.

添加函数所在路径到octave，使octave能找到对应的函数的定义。

### Vectorization【2019.5.23】

向量化，使程序运行加快。

