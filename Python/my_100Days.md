- 原先就有基础
- 入门资料为[廖雪峰的python基础](<https://www.liaoxuefeng.com/wiki/1016959663602400>)
- 目前的个人使用感觉：
  - 方便容易学习
  - 自由

## 初识Python

### 应用领域

- 有所了解
  - web应用开发----python flask框架
  - 网络数据采集----爬虫
  - 机器学习----sklearn
  - 可视化-----matplotlib
  - 科学计算-----numpy、pandas
- 更多未知
  - 云基础设施
  - DevOps

### python解释器安装

- 最初是Python IDLE
- 为了舒适选择了pycharm
- 目前主要是windows环境
- windows＋linux虚拟机

#### linux环境下建议使用iputhon

### 练习

- 1、turtle库 
  - 可使用此进行画图
- 2、import操作进行库的导入

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

- 与列表类似，但是元组的元素不能修改

- 定义

- ```python
  t = (1,2)
  
  #注意，当再一次用同一个变量引用元组时，原来的元组被垃圾回收
  ```

- 可以用list函数将元组转换为列表，用tuple函数将列表转换为元组

##### 元组类型存在的意义

- 从使用上看元组和列表一样，甚至说不如列表使用的方便顺手，导致我很长一段时间都容易忘了还有元组这个数据类型

### 集合相关操作

- 不允许有重复元素

- 操作与数学上集合一样，可以求交集、并集、差集

- ```python
  set.add(s) # 将元素s加入集合中，加到集合末尾。
  set.pop() #将集合内第一个元素删除，并将结果输出
  set.remove(x) #将集合内指定元素x删除，若x不存在会报错
  ```

### 字典相关操作

- 可以存储任意类型对象，由一个键和一个值组成的键值对，键和值通过冒号分开
- 字典内容可以进行更新

```
dict = {'a':9}
```

### 练习

#### 屏幕显示跑马灯文字

- 主要是用字符串的切片和拼接

```python
import time

def main():
    content = '……走马灯……'
    while True:
        print(content)
        time.sleep(0.1)
        content = content[1:] + content[0]


if __name__ == '__main__':
    main()
```

#### 设计一个函数产生指定长度的验证码，验证码由大小写字母和数字组成

- 利用下标索引进行随机

```python
import random

def test():
    YanZheng = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"
    result = ''
    all = len(YanZheng)-1
    num = int(input("要生成几位验证码？"))
    for _ in range(0, num):
        x = random.randint(0, all)
        result = result + YanZheng[x]
    print("生成的验证码为",result)

if __name__ == '__main__':
    test()
```

#### 设计一个函数返回给定文件名的后缀名

- 遍历字符串

```python
def test():
    filename = str(input("给出给定的文件名："))
    num = 0
    for i in range(0, len(filename)):
        if(filename[i]=='.'):
            print("文件名后缀为：",filename[(i+1):])
            num = num + 1
            break
    if num == 0:
        print("真的是文件名吗？")
        
if __name__ == '__main__':
    test()
```

## 面向对象编程

- 面向对象编程语言如：java、c++
- 个人理解：面向对象就像是把现实世界用代码重现，包括现实世界各个事物之间的关系，解决问题的思路就像是要处理一个问题，该问题涉及什么人，

#### 三大要素

- 封装
  - 黑匣子，隐藏具体实现细节，像现实中大部分东西都是封装展现在人们面前，很多细节不需要每个人都知道怎么去做，只要能让需要的人知道如何方便的使用功能。
- 继承
- 多态

#### 一些概念

##### 类和对象

- 类是对象的蓝图，对象是类的实例。
- 用关键字`class`定义类
- 关于类内函数`__init__`，被称为构造器，可以理解为就是对类进行初始化设定，也就是说是在对象的实例化后调用
- python没有从语法上严格保证私有属性之类的，只是给私有的属性和方法换个名字。比如属性名以单下划线开头

##### @property装饰器

- 该装饰器常用于把类的get和set方法包装，使的可以直接在访问属性时直接调用这两个方法
  - 装饰器真的神奇！

##### \__slots\_\_

- 在动态语言限定自定义类型的对象只能绑定某些属性。
  - 只对当前类的对象生效，对子类并不起任何作用
  - 当创建大量实例时，可以使用`__slots__`可以减少内存消耗，但用在普通类上会丧失动态添加属性和弱应用的功能
    - 由于默认情况下用字典保存一个对象的实例属性，而如果属性已知的话，可以使用这个方法来规避内存浪费，告诉python不用字典，给一个固定集合的属性分配空间。

#### 静态方法和类方法

- `@staticment` 
  - 参数可以为空，支持类名调用和对象调用
- `@classmethod`
  - 可以通过类名直接调用，传递一个参数，一般用cls表示class

#### 类之间关系

- 继承
- 关联
- 依赖

## 图形用户界面和游戏开发

- tkinter模块

介绍提到，开发GUI只要五个步骤：

```
1.导入tkinter模块中我们需要的东西。
2.创建一个顶层窗口对象并用它来承载整个GUI应用。
3.在顶层窗口对象上添加GUI组件。
4.通过代码将这些GUI组件的功能组织起来。
5.进入主事件循环(main loop)。
```

- pygame模块

```
开发简单2D小游戏？maybe try a try
模块内包含了对图像、声音、视频、事件、碰撞等的支持
```

- Panda3D模块

```
开发3D游戏？
```

## 文件和异常

python自带的open函数就具备了读取或写入的功能

使用try-except来捕获异常

- 可以使用json模块来读取json文件   -----常用于爬虫

#### 正则表达式

- 相当重要，爬虫中，可以找到你想要的形式的信息
- `re`库

## 进程和线程

