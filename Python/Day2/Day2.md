# Day2

## 语言元素

### 变量和类型

- 整数
- 浮点型
- 字符串型：单引号或双引号括起来的任意文本
- 布尔值：True、False
- 复数型【不常用】

#### 变量命名

- 硬性规则：
  - 变量不能以数字开头
  - 大小写敏感
  - 不要和关键字和系统保留字冲突
- PEP 8要求
  - 用小写字母拼写，多个单词用下划线连接
  - 受保护的实例属性用单个下划线开头
  - 私有的实例属性用两个下划线开头
- 见名知意是程序员基本

#### 变量强制转换

- int()：转换为整数，可以指定进制
- float():将一个字符串转换为浮点数
- str()：将指定的对象转换为字符串形式，可以指定编码
- chr():将整数转换成该编码对应的字符串（一个字符)
- ord():将字符串（一个字符）转换为对应的编码

### 运算符

- 运算符顺序可以直接用括号来保证

## 分支结构

### if语句

- 通过不同的条件运行不同的指令，不同于顺序结构

### 注意：

- Python的分治结构不需要用花括号来构造代码块，采用的是缩进的方式来设置代码的层次结构
- if后接的判断条件也不需要用括号括起来，只需要用空格隔开，条件输入完成后用冒号
- elif 和else 可以构造新的分支，其中，elif后可以继续连接判断条件，else不需要

### 例子：

```python
m = int(input())
	if m == 0:
		print("it's 0")
    elif m > 0:
        print("it's bigger than 0")
	else:
		print("not")
```

## 循环结构

### for-in循环

- 适合明确知道循环执行的次数

### while循环

- 不确定执行次数，明确循环结束的条件时
- 其中可用break终止循环
- 也可使用continue让循环进行下一轮

## 构造程序逻辑

### 生成斐波那契数列的前20个数

- 说明：数列的前两个数都是1，从第三个数开始，每个数都是它前面两个数的和

```python
def test():
	l = [1,1]
	for i in range(18):
		c = l[i] + l[i+1]
		l.append(c)

	return l
if  __name__  == '__main__':
	a = test()
	print(a)
	print(len(a))
```

### 找出10000以内的完美数

- 说明：它的所有的真因子（即除了自身以外的因子）的和（即因子函数）恰好等于它本身。

```python
def test():
	a = []
	for i in range(1,10000):
		num = 0
		for j in range(1,i-1):
			if i % j == 0 :
				num = num + j
		if num == i:
			a.append(i)
	return a
if  __name__  == '__main__':
	b = test()
	print(b)
```

### 输出100以内所有的素数

- 说明：素数指的是只能被1和自身整除的正整数（不包括1）

```python
def test():
	a = []
	for i in range(1,100):
		num = 0
		for j in range(2,i-1):
			if i % j == 0 :
				num = num + 1
				break
		if num == 0 :
			a.append(i)
	return a
if  __name__  == '__main__':
	b = test()
	print(b)
```

## 函数和模块的使用

### 关于\__name__的理解

- 个人理解：对于\__name__在最开始时候，也没有特别去查询它的意思，只是把它当作是程序运行的一个通道，一个标识，类似于c语言中的main函数。

- 而后看到的理解：\_\_name\_\_是内置变量，用于标识当前模块的名字，同时可以反映一个包的结构，也就是说一个模块被直接运行时，其没有包结构，其\_\__name__的值为\_\_main\_\_。
- 就是说：如果模块是被直接运行的，则代码块被运行，如果模块是被导入的，则代码块不被运行。

[详细理解参见此博客](<http://blog.konghy.cn/2017/04/24/python-entry-program/>)

- 使用def关键字定义函数，将重复使用的代码封装成函数使用
- 定义函数的参数时，可以设定默认值，当调用参数时若没有带参数，则函数运行默认值，若带有参数则输入参数覆盖默认参数【python定义变量不会标明数据类型，传入参数时要注意参数类型】

### 注意：

- Python没有函数重载的概念，后面的定义会覆盖之前的定义

  - 也就是说，当定义两个同名函数但参数不同时，运行时只按后面的定义运行

- 例子

- ```python
  def test(n=0):
  	print(n+1)
  
  def test():
  	print('test')
  
  if  __name__  == '__main__':
  	test()
  	test(2)
  	test(3)
  ```

- 此例子的结果为

- ```python
  test
  TypeError: test() takes 0 positional arguments but 1 was given
  ```

### 变量作用域

- 局部作用域：下例中c
- 嵌套作用域：下例中b
- 全局作用域：下例中a
- 内置作用域：Python内置的那些隐含标识符min、len等都属于内置作用域

#### 举例

```python
def foo():
    b = 'hello'

    def bar():  
        c = True
        print(a)
        print(b)
        print(c)

    bar()
    	print(c)  


if __name__ == '__main__':
    a = 100
    foo()
```

## 字符串与常用数据结构

- 在python中，字符串就是用单引号或者双引号包围起来的单个或多个字符

- 以三个双引号或单引号开头的字符串可以折行

  - 例: 

  - ```python
    def test():
    	s = """
    	zhe
    	ye 
    	ke
    	yi
    	"""
    	print(s)
    
    if  __name__  == '__main__':
    	test()
    ```

- 字符串中\代表转义，其中若不要转义可以用r来说明。

- python中可以用`+`来实现字符串的拼接，可以用`*`来重复一个字符串内容，还有`in`和`not in`进行判断运算，`[]`和`[:]`对字符进行切片运算

### 处理字符串相关函数

```python
str1 = 'hello, world!'
# 通过内置函数len计算字符串的长度
print(len(str1)) # 13
# 获得字符串首字母大写的拷贝
print(str1.capitalize()) # Hello, world!
# 获得字符串每个单词首字母大写的拷贝
print(str1.title()) # Hello, World!
# 获得字符串变大写后的拷贝
print(str1.upper()) # HELLO, WORLD!
# 从字符串中查找子串所在位置
print(str1.find('or')) # 8
print(str1.find('shit')) # -1
# 与find类似但找不到子串时会引发异常
# print(str1.index('or'))
# print(str1.index('shit'))
# 检查字符串是否以指定的字符串开头
print(str1.startswith('He')) # False
print(str1.startswith('hel')) # True
# 检查字符串是否以指定的字符串结尾
print(str1.endswith('!')) # True
# 将字符串以指定的宽度居中并在两侧填充指定的字符
print(str1.center(50, '*'))
# 将字符串以指定的宽度靠右放置左侧填充指定的字符
print(str1.rjust(50, ' '))
str2 = 'abc123456'
# 检查字符串是否由数字构成
print(str2.isdigit())  # False
# 检查字符串是否以字母构成
print(str2.isalpha())  # False
# 检查字符串是否以数字和字母构成
print(str2.isalnum())  # True
```

### 列表相关操作

```python
list1 = [1, 3, 5, 7, 100]
# 计算列表长度(元素个数)
print(len(list1))
# 下标(索引)运算
print(list1[0]
print(list1[-3])
# 添加元素
list1.append(200) #添加至列表最后
list1.insert(1, 400) #在下标为1处添加
list1 += [1000, 2000] # 列表内容连接，相同项依旧保留，相当于在list后面直接添加1000和2000
# 删除元素
list1.remove(3) # 删除3这个元素
if 1234 in list1:
    list1.remove(1234)
del list1[0]   #删除下标为0的这项
print(list1)
# 清空列表元素
list1.clear()
print(list1)
```

- 列表也可以做切片操作
- 列表的查询函数sort

```python
list1 = ['orange', 'apple', 'zoo', 'internationalization', 'blueberry']
list2 = sorted(list1)
# sorted函数返回列表排序后的拷贝不会修改传入的列表
# 函数的设计就应该像sorted函数一样尽可能不产生副作用
list3 = sorted(list1, reverse=True)
# 通过key关键字参数指定根据字符串长度进行排序而不是默认的字母表顺序
list4 = sorted(list1, key=len)
print(list1)
print(list2)
print(list3)
print(list4)
# 给列表对象发出排序消息直接在列表对象上进行排序
list1.sort(reverse=True)
print(list1)
```

#### 列表生成式和生成器

[查阅到的介绍列表生成式和生成器的详细](<https://www.cnblogs.com/yyds/p/6281453.html>)

#### 列表生成式

- 一个用来生成列表的特定语法形式的表达式

- 这种语法创建列表之后元素已经准备就绪所以需要耗费较多的内存空间

##### 语法格式

- 基础语法格式

- ```python
  [exp for iter_var in iterable]
  
  #相当于下面过程
  L = []
  for iter_var in iterable:
      L.append(exp)
  ```

- 带有过滤功能的

- ```python
  [exp for iter_var in iterable if_exp]
  
  #相当于下面过程
  L = []
  for iter_var in iterable:
      if_exp:
          L.append(exp)
  ```

- 循环嵌套语法格式

- ```python
  [exp for iter_var_A in iterable_A for iter_var_B in iterable_B]
  
  #相当于下面过程
  L = []
  for iter_var_A in iterable_A:
      for iter_var_B in iterable_B:
          L.append(exp)
  
  ```

##### 比较适合应用的地方

- 根据已存在的可迭代对象推导出一个新的list，使代码简洁

#### 生成器

- 通过生成器可以获取到数据但它不占用额外的空间存储数据，每次需要数据的时候就通过内部的运算得到数据（需要花费额外的时间）

- 按照某种算法不断生成新的数据，直到满足某一个指定的条件结束

##### 生成器的构造方式

- 使用类似列表生成式的方式生成，是括号()，不是[]
- 使用包含yield的函数生成

##### 生成器的执行过程、调用方式与特性

- 执行过程
  - 遇到yield关键字就会中断执行，下次调用则继续从上次中断的位置继续执行
- 调用方式
  - 调用内置的next函数
  - 使用循环对生成器进行遍历
  - 调用生成器对象的send方法
- 特性
  - 只有在调用时才会生成对应的数据
  - 只记录当前的位置
  - 只能next，不能prev

### 元组相关操作

