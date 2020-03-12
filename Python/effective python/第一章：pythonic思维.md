# Pythonic Thinking

> 我觉得就是python化思维。关于pythonic：就是指具有python语言特色的。

  一门编程语言的习惯用语总是由它的用户所定义的。自python面世以来，python社区使用形容词pythonic来描述一种有着特殊风格的代码。pythonic风格不是由编译来强制执行，它是随着你使用语言的经历和与他人共同工作来积累经验。python程序员们更喜欢的清晰的，简单的好过复杂的，以及最大程度的可读性。

  熟悉其它语言的程序员可能会试着用他们所了解的c++、java的方式去写python。一个新手程序员可能会对Python重的一些概念感到舒服。每个人都必须在python中以pythonic的方式去执行很多常用的操作。这些部分会影响你写的每一个程序。

  ## 项目1：了解你现在用的python的版本

  这本书内，大部分的例子是用的python3.4，也会提供一些python 2.7的例子去强调一些重要的不同。我的大部分建议都适用于所有流行的python解释器：CPython,Jython,IronPython,PyPy,等.

> CPython:用C语言实现python的一种解释器。
>
> Jython:用JAVA实现python的解释器。
>
> IronPython:用.NET实现python的解释器。
>
> PyPy:python自身实现的解释器。

  许多电脑都附带多个版本的CPython，在运行时预安装。然而，在命令行可能并不清楚python命令的意思。python可能是python2.7的别名，也可能是python2.6,python2.5的命名。为了搞清楚你在用的到底是哪个版本的python，你需要使用-- version 。

``` shell
$ python -version
Python 2.7.8
```

  Python3 通常是使用python3这个名字的

```shell
$ python3 -version
Python 3.4.2
```

  你也可以在解释器内使用内置模块sys来搞清楚你使用的是什么版本的python。

```python
import sys
print(sys.version_info)
print(sys.version)
```

  Python2和Python3在python社区内都保持活跃，python2的开发在错误修复、安全改进和后端接口这些方面都已经冻结了以简化从python2到python3的过渡。也存在一些有用的工具使得过渡更容易。

  Python3不断地有一些新特性和改进，而这些并不会在python2中添加。截止写这本书地时候，大多数的python常见开源库都是兼容python3。我强烈建议你在你以后地python项目中使用python3。

### 一些需要记住的事

- Python现在仍在被广泛使用的两个版本：Python2和Python3.
- 现在的几个常用受欢迎的解释器：CPython,Jpython,IronPython,PyPy,等。
- 确保你的系统在运行的Python版本是你所希望的那个。
- 首选Python3作为你下一个项目要用的语言，因为这是python社区的主要焦点。

## 项目2：遵守PEP8编码规范

  python改善建议#8，也被称为PEP8，它是一种关于如何将Python代码进行一定格式化的样式指南。当然欢迎你随意编写Python代码，只要它具有有效的语法即可。但是，使用一致的风格会使你的代码更加友好且容易阅读。在一个项目里和别的python程序员使用相同的代码风格会促进合作效率。即使你是唯一会再阅读你的代码的人，遵守一定的编码规范会使你以后更改代码时变得简单。

  PEP8有许多关于如何写整洁的python代码的细节。并且随着python语言的发展，它会持续更新。它是值得[在线阅读](http://www.python.org/dev/peps/pep-0008/)整个规范的.下面有一些规则你必须确保遵守：

### 空格

>   在python的句意中是十分重要的。python程序员对空格对代码的影响特别在意。

- 使用空格而不是tabs来表示缩进
- 使用4个空格表示语法中每个级别的缩进
- 一行最多有79个字符
- 长表达式在其它行上的延续应从它正常的缩进级别缩进4个空格
- 在一个文件中，函数和类之间用两个空白行分隔开
- 在一个类里，方法之间用一个空白行分隔开
- list的索引，函数调用，关键字参数周围不要空格
- 在变量赋值之前和之后分别只放置一个空格

### 命名

> PEP8 建议在语言中的不同部分有着独特的命名方式，这样可以使得在阅读代码时能很容易的区分类型对应的名字。

- 函数、变量和属性应该以全部小写的格式
- 受保护的实例属性应该以1个下划线开头的格式
- 私有的实例属性应该以2个下划线开头的格式
- 类和exception应该以大写字母的格式
- 模块级常量应用ALL_CAPS的格式
- 类里面的实例方法应该使用`self`作为第一个参数
- 类方法应该使用cls作为第一个参数

### 表达式和陈述

> python之禅写了：“应该有一种，最好只有一种明显的方式来做到这一点。”PEP8想以这个为指导编写关于表达式和陈述的规范。

- 使用内联否定（`if a is not b`）而不是否定一个肯定的表达（`if not a is b`）
- 不要在检查一个空值（[] or ''）的时候用长度检查。使用 if somelist 并假设空值的值为false
- 同样，检查一个值不为空([1] or 'a?')时也用if somelist检查。
- 避免单行if语句、for和while循环，复合语句除外。将它们以多行的格式写可以显得更加清楚。
- 总是将import语句放在文件的顶部
- 在应用模块的时候总是使用模块的绝对名字，而不是使用相对路径。举个例子，从bar包内引入foo模块，你应该写`from bar import foo`，而不是`import foo`
- 如果你必须使用相对引入，使用显式同步`from . import foo`
- 引用的应该在下列的选择中：标准库模块，第三方模块，你自己的模块。每个小节应该按照字母顺序引入。

### 一些需要记住的事

- 当你写python代码的时候总是遵守PEP8编码规范
- 与更大的python社区共享一个通用的规范可以促进与他人的合作
- 使用一个一致的编码规范可以使你在后期要修改你自己的代码的时候变得轻松

## 项目3：了解bytes、str、unicode之间的区别

  在python3中，有两种类型可以表示字符序列：字节和str。一个字节由8比特组成。str则由国标码组成。

  在python2中，也有来那种类型表示字符序列：字符串和国标码。和python3不同的是，它的一个字符串包含8个比特值，而国标码包含国标码字符。

  有很多方法可以证明国标码字符是二进制数据（8个比特值）。最常用的国标码是UTF-8.最重要的是，在Python3中的字符串实例和python2中的国标码实例并不包含有关联的二进制编码。要想将国际码字符转换为二进制编码，你必须使用编码模式，而要想将二进制编码转换为国际码字符，你必须使用解码模式。

  当你在写python程序时，你必须要在你接口处处理关于编码和解码的问题。你的代码核心应该使用国际码字符类型（python中的str或者python2中的unicode），不要对字符编码有任何假设。这样处理可以使你的代码可以容易的接收其它文本编码的输入([Latin-1](<https://baike.baidu.com/item/Latin1>),[Shift JIS](<https://zh.wikipedia.org/zh-hans/Shift_JIS>),[Big5](<https://zh.wikipedia.org/wiki/%E5%A4%A7%E4%BA%94%E7%A2%BC>))，同时还严格限制你的输出文本编码（最好是utf-8）。

  字符类型的不同在Python代码中会导致两个常见的情况：

- 你想生成一个8比特值的由UTF-8编码的字符
- 你想生成一个国标码字符，不采用特别的编码方式 

  你可以使用两个有用函数的去在两个类型之间进行转换，以此去确保输入类型符合你代码的要求。

  在python3中，你需要一个方法接收str或bytes，返回一个str，如下：

```python
def to_str(bytes_or_str):
    if isinstance(byte_or_str, bytes):
    //如果接收的是bytes，对其进行按照utf-8解码
        value = bytes_or_str.decode('utf-8')
    else:
        value = bytes_or_str
    return value //str类型
```

  还需要另一个方法接收str或者bytes，返回bytes。如下：

```python
def to_bytes(bytes_or_str): 
	if isinstance(byte_or_str, str):
		value = bytes_or_str.encode('utf-8')
    else:
        value = bytes_or_str
    return value
```

  在python2中，一个方法接收str或unicode，返回unicode时，如下：

```python
def to_unicode(unicode_or_str):
    if isinstance(unicode_or_str, str):
        value = unicode_or_str.decode('utf-8')
    else:
        value = unicode_or_str
    return value
```

  另一个情况是返回str的，如下。

```python
def to_unicode(unicode_or_str):
    if isinstance(unicode_or_str, unicode):
        value = unicode_or_str.encode('utf-8')
    else:
        value = unicode_or_str
    return value
```

  下面说明两个python在处理8比特值和unicode字符时容易碰到的陷阱。

  第一个陷阱是在python2中，当str仅包含7比特的ASCII字符时，它和unicode似乎是同一个类型。

- 你可以在把str和unicode结合时使用+操作
- 你可以在比较str和unicode时使用相等和不相等的操作
- 你可以在使用unicode作为格式化字符串，例如’%s‘

  上述的可行性意味着你在给函数传参时，传递一个str或一个unicode都会有同样的效果（正如处理的只是7比特的ASCII一样）。但python3中，bytes和str并不具有等价性，即使是一个空的字符串，所以在你对函数传参时要尤其对字符序列的类型进行注意。

  第二个陷阱是在python3中，对文件处理时默认是UTF-8编码，而在python2中对文件处理的默认编码的二进制编码。这会导致一些出乎意料的错误，尤其是对已经习惯了python2的程序员来说。

  举个例子，如果你想在一个文件里写一些随机的二进制数据，在python2中是可行的，但python3中不行。

```python
with open('/random.bin','w') as f:
    f.write(os.urandom(10))
//TypeError:	must be	str,not	bytes
```

  这个异常的原因是python3在open中的类型错误。python3默认的是'utf-8'。这就表示其的读写操作默认只允许是str，而不是二进制数据。

  为了解决上面的那个异常，你必须需改其模式为'wb'，而不是'w'。下面为修改后可运行的。

```python
with open('/random.bin','wb') as f:
    f.write(os.urandom(10))
```

  不光是写文件的时候如此，在读取文件内容的操作也是一样，应为”rb"模式，而不是'r'模式。

### 一些需要记住的事

- 在python3中，bytes是8比特的序列，str是Unicode字符序列。两者不能使用+ > like  操作进行比较
- 在python2中，str是8比特的序列，而Unicode是Unicode字符序列，当str只包含7比特的ascii字符时，两者可以使用+ > like 进行操作
- 使用有效的函数去确保你的输入是你期望的字符序列类型
- 如果你想要读写二进制数据或文件，总是以rb wb的二进制模式进行打开。

## 项目4： 编写辅助函数而不是复杂的表达式

​    python的特殊句法使得你可在一个单行的表达式中实现一个复杂的逻辑。举个例子，如果你想要从一个URL中解码一个查询的字符串，每个查询字符串代表一个整数值。

```python 
from urllib.parse import parse_qs
my_values = parse_qs('red=5&blue=0&green=',keep_blank_values=True)
print(repr(my_values))

//输出：
{‘red’:	[‘5’],	‘green’:[”],‘blue’:	[‘0’]
```

  查询字符串参数可能有多个不同的值，可能是单一的值，可能是存在但值为空，可能会丢失。在结果的字典中使用get方法可以返回每个情况各自不同的值

```python
print(‘Red:	’,	my_values.get(‘red’))
print(‘Green:’,	my_values.get(‘green’)) 
print(‘Opacity:	‘,	my_values.get(‘opacity’)
      
//输出：
Red:[‘5’]
Green:[”] 
Opacity:None
```

  当一个参数是不支持的或者其值为空，默认返回为0是一个很好的做法。你可能会选择布尔表达式来进行处理，因为这种逻辑似乎不适合整个if语句或辅助函数。

  python的句法可以使变得简单，python中空字符串，空列表和零在逻辑判断中都等价为False，因此，当第一个子表达式为False时，就取后面的值，下面的代码使用了or运算符。

```python
red = my_values.get('red',[''])[0] or 0
green = my_values.get('green',[''])[0] or 0
opacity = my_values.get('opacity',[''])[0] or 0
print(‘Red:	’,	my_values.get(‘red’))
```

  对于red的情况它的key为'5'，所以最后取值为逻辑判断的第一部分。

  对于green的情况它的key为空字符串，所以最后取值为or逻辑判断的第二部分。

  对于opacity的情况从列表中没有它的值，则返回get函数的第二项即一个['']，所以最后取值为or逻辑判断的第二部分。

  然而进行了上述的处理后，得到的结果仍然不是你想要的答案，你想要的是每个查询字符值为一个整数。为了达到你的要求，你还需要对red的情况进行类型强制转换为Int型。

```python 
red = int(my_values.get('red',[''])[0] or 0)
```

  这样处理后会使得代码难以阅读，别人来阅读代码时还是需要花费一定的时间将这个表达式拆成各个部分，才能看懂它到底是在做什么。虽然简短是很好的，但不必把所有内容放在一行内。

  python2添加if/else的判断表达使得这个在保持简短的同时更加清晰。

```python
red = my_values.get('red',[''])
red = int(red[0]) if red[0] else 0
```

  这是更好的写法，对于不太复杂的情况，if/else表达式可以使事情变得情况。但是，这样写还是不如在多行上使用完整的if/else语句的替代方案更清晰。看道所有逻辑这样展开，显然密集版本显得更加复杂。

```python
green = my_values.get('green',[''])
if green[0]:
    green = int(green[0])
else:
    green = 0
```

  然而，如果每一个都展开写，会显得代码特别长，因此写一个辅助函数去解决需要重复的使用同一逻辑的情况是一个很好的办法。

``` python
def get_frint_int(values, key, default=0):
    found = values.get(key,[''])
    if found[0]:
        found = int(found[0])
    else:
        found = default
    return found
```

通过调用函数比使用or或者使用if/else表达式的方法都更加清晰。

一旦你的表达式变得复杂，你就要考虑是否要将这个逻辑写成一个辅助函数调用的形式。你在可读性上做出的提升得到的收益总是会比简洁性多。不要让python复杂表达式的特殊语法使得你陷入混乱中。

### 一些需要记住的事情

- python的语法会很容易让你写出单行的表达式，但它们有时候会过于复杂，不具备可读性
- 将复杂的表达写入辅助函数中，尤其是当你需要多次调用相同的逻辑。
- if / else表达式比在表达式中使用布尔运算符（如or和and和）更具备可读性。

## 项目5：知道如何对序列进行切片处理

  python的语法里包括了将序列切片成各个部分的操作。切片使得你可以很轻松的获得一个序列的子集。最简单的用途的对类型list,str和bytes的处理。切片可以扩展道实现__getitem\_\_和\_\_setitem\_\_的任何python方法。

  切片最基础的语法是`somelist[start:end]`，包括start，不包括end。

```python
a = ['a','b','c','d','e','f','g','h']
print(a[:4])
print(a[-4:])
print(a[3:-3])
```

  当你是要从列表头部开始切片时，你应该省略0值，这样使得更加简洁

  同样，当你的切片要进行到列表的最后一项时，你应该省略长度不屑，这样显得更加简洁。

  使用负数进行切片有助于相对于列表的结尾进行偏移。

  所有这些形式的切片对代码阅读都是清晰的，所以我鼓励你使用这种形式。

  切片可以正确处理超出列表长度的索引。这使得你的代码很容易确定要考虑输入序列的最大长度。

  但如果不是使用切片，只是索引一个超过范围的值则会报错。

  切片的结果是一个新的列表。保留了对原始列表中对象的引用。修改切片结果的值并不会影响原列表的值

```python
b = a[4:]
print(b)
b[1] = 99
print(b)
print(a)
```

  当你在分配中使用时，切片会替换原始列表中的指定范围。

```python
print(a)
a[2:7] = [90,289,89]
print(a)
```

  如果你在切片时start和end的值都不设置，你会得到一个原始列表的复制。

  如果你声明一个切片没有start和end索引，你将替换原始的整个内容。

```python
print(a)
a[:] = [101,102,103]
print(a)
```

### 一些需要记住的事情

- 保持代码简洁：不要为索引提供0或者序列的长度
- 切片可以正确处理超过范围的开始或结束索引，可以易于在前后边界表达切片
- 使用切片对列表进行修改或赋值时，即使长度不同，也将使用引用的内容替换原始序列范围内的值。

## 项目6：在单个切片中避免使用start,end,stride同时存在

  补充一下项目5中对切片的描述，切片还有一种特别的语法去生成[start;end;stride]。其中的stride你可以理解为步长，就是相隔几步取一个值。举个例子，步长可以使你能轻松的将一个列表按奇、偶分组索引。

```python
a = [1,2,3,4,5,6]
odds = a[::2]
evens = a[1::2]
print(odds)
print(evens)
```

这个特殊的语法的问题在于它经常出现一些出乎意料的表现，这样的表现会产生bug。举个例子，一个常见的python技巧将切片步长设置为-1来将一个byte字符进行逆序输出。

```python
x = b'mongoose'
y = x[::-1]
print(y)
//输出：
b'esoognom'
```

  ```python
w = '你好'
x = w.encode('utf-8')
y = x[::-1]
z = y.decode('utf-8')

//输出：
  ```



上面例子可以看出其对byte字符串和ascii字符串都是有效的，但是对unicode字符生成的utf-8字节字符串是无效的。

  除了-1以外，还有哪些负数的步长是有用的呢？考虑下面的例子。

```python
a = [1,2,3,4,5,6,7,8]
a[::2]
a[::-2]
```

  例子中的::2说明从列表的开始每隔1个取一个，::-2则是从列表的尾往前每隔1个取一个。

  切片语法的步长部分可能会造成阅读时的困难，括号中的三个数字不便于阅读。在写步长的时候，开始索引和结束索引生效的部分并不明显。

  为了解决这个问题，我们应该避免步长参数和开始、结束索引一同使用。如果你必须使用步长的话，最好将步长设置为正值，且省略开始索引和结束索引。如果你必须要同时使用的话，可以考虑将其拆成两个部分。如下所示。

```python
b = a[::2]
c = b[1:-1]
```

  切片和步长会生成数据的浅拷贝【对引用的拷贝】。第一步操作尽可能地减少了切片结果的长度。如果你的程序不能承受两步的时间或内存，可以考虑使用itertools内置模块islice方法【会在后面的第46个项目提到】，那个方法不允许start,end,stride为负值。

### 一些需要记住的事情

- 在切片中指定开始，结束和步长可能会造成混乱。
- 尽可能避免使用负的步长，在使用正的步长的时候最好不要有开始和结束的索引。
- 在一个切片中避免三个参数同时使用。如果你实在是需要三个参数才能完成你的操作的话，把它拆成两个步骤进行，或者使用itertools内置模块中的islice方法。

## 项目7：使用列表生成器而不是map和filter

  Python提供了紧凑的语法派生出一个列表。这些表达式被称为列表生成器。举个例子，如果你想要计算一个列表中的每一个数的平方。你可以用列表生成器，通过提供表达式和要循环的输入序列来实现。

```python
a = [1,2,3,4,5,6]
squares = [x**2 for x in a]
print(squares)
```

  除非您使用单个参数的函数，不然在处理简单的情况时，列表生成器比内置函数map要清晰的多。map需要提供一个匿名函数，这没有列表生成式更明显。

```python 
//map方法
squares = map(lambda x: x ** 2, a)
```

  和map不同，列表生成器让你可以很轻松的从输入列表中选择需要的项，得到你想要的输出。举个例子，如果你只想要得到列表中的偶数的平方的结果列表。那么你可以在列表生成式里循环的后面家伙是那个一个逻辑表达式。

```python
even_squares = [x**2 for x in a if x % 2 == 0]
print(even_squares)
```

  内置函数filter可以和map一起使用达到同样的效果，但是它更难阅读。

```python
alt = map(lambda x: x**2, filter(lambda x: x%2 == 0,a))
print(list(alt))
```

字典和集合也可以用列表生成器类似的语法。这使得在写一个算法时要创建一个数据结构变得容易。

```python
ranks = {'yi':1,'er':2,'san':3}
rank_dict = {rank: name for name, rank in ranks.items()}
rank_sets = {len(name) for name in rank_dict.values()}
print(ranks,rank_dict,rank_sets)
```

### 一些需要记住的事情

- 列表生成器比map+filter内置函数更易读，因为它不需要用到额外的匿名函数。
- 列表生成器使你可以从输入列表中很容易的挑选需要的项，而map函数在不借助filter函数的帮助下无法做到。
- 字典和集合也提供列表生成器这样的表达。

## 项目8：在列表生成式中避免超过两个表达式

  列表生成式处理项目7中的基本用法以外，它也支持多重循环。举个例子，你想要简化一个矩阵，将其所有的元素变成一个一维列表。你可以使用列表生成式做到，下面的例子是从左到右展开。

```python
matrix = [[1,2,3],[4,5,6],[7,8,9]]
flat = [x for row in matrix for x in row]
print(flat)
```

  这个例子是多重循环的一个简单的，易于理解的用途。多重循环的另一个用法是复制输入列表的多维结构。举个例子，你想要将一个二维矩阵中的每一个元素计算它的平方，也可以用列表生成式完成。

```python
squared = [[x**2 for x in row] for row in matrix]
```

  虽然这个表达式多了一个[]，但它还是易于理解的。但如果它包含的是另外的循环，这个就不好理解了，那么就需要你将循环拆分为多行。

```python
matrix = [
    [[1,2,3],[4,5,6]],
    [[7,8,9],…
]
flat = [x for sublist1 in matrix
       for sublist2 in sublist1
       for x in sublist2]
```

  这种情况下，多行理解也并不比其它方法简短，这种情况下普通的循环语句比列表生成式要清晰。

```python
flat = []
for sublist1 in my_lists:
    for sublist2 in sublist1:
        flat.append(sublist2)
```

  列表生成式同样也支持多重的if判断。同一级别的多重判断是隐式的and表达式。举个例子，你想要得到一个列表中大于4的偶数。下面的两个列表生成式是等价的。

```python
a = [1,2,3,4,5,6,7,8]
b = [x for x in a if x > 4 if x % 2 == 0]
c = [x for x in a if x > 4 and x % 2 == 0]
```

  可以在for表达式后的每个循环级别指定条件判断，举个例子，如果你想要选出一个矩阵里是3的整数倍，且该行的元素总和大于10。这样的列表生成式简短，但不易理解。

```python
matrix = [[1,2,3],[4,5,6],[7,8,9]]
filtered = [[x for x in row if x % 3 == 0]
           for row in matrix if sum(row) >= 10]
```

  虽然这个例子有些复杂，但是在实际应用中你会发现这样的表达式也有一些很适合的情况。我强烈建议你避免像上面这样使用俩表上次那个式。这样的代码别人会很难以理解。你这样节省的行数可能会在以后对你造成一些困难。

  经验告诉我们避免在列表生成式中使用两个以上的表达式。可以包括两个条件判断，或者两重循环，或者一个判断一个循环。一旦比这些情况更复杂的话，那么你应该使用正常的if或for循环，或者写辅助函数。

### 一些需要记住的事情

- 列表生成式支持多重循环或者一个循环等级内有多个条件判断
- 列表生成式内如果出现超过两个的表达式会使得代码变得不易阅读，我们应该避免这种情况。

## 项目9：数据量大的输入考虑使用生成器表达式

  在项目7中我们考虑的列表生成器是计算输入列表里的每一个元素计算求值得到一个新的列表。这对于一个数据量不大的输入列表是很好的，但如果输入一个数据量大的列表的话会消耗大量的内存从而导致你的程序拥挤。

  举个例子，如果你想要阅读一个文件返回每一行字符的个数。使用列表生成器来做到这个要求的话就会需要在内存中保存文件每一行的长度。如果文件十分大或者可能是一个不中断的网络连接的话，列表生成式就会出现问题。下面我使用列表生成式只处理一个较小的输入量。

```python
value = [len(x) for x in open('/my_file.txt')]
print(value)
//输出：
[100,	57,	15,	1,	12,	75,	5,	86,	89,	11]
```

  为了解决数据量大的情况，Python提供了生成器表达式的概括和生成器。生成器表达式不会在运行时实现整个输出序列。它会生成一个迭代器，该迭代器一次从表达式中只返回一个结果。

  一个生成器表达式和列表生成器类似，它是用的()。下面我使用生成器表达式写和上面的列表生成式等价的代码。但生成的是一个迭代器。

```python
it = (len(x) for x in open('/my_file.txt'))
print(it)
print(next(it))
print(next(it))
```

  返回的迭代器可以使用next函数调用，将返回的迭代器前进一步，得到输出。你的代码可以使用任意数量的生成器表达式，且不会出现内存不够的麻烦。

  生成器表达式的另一个强大之处在于，它可以进行组合。下面举一个例子，它返回的就是一个迭代器和基于该生成器表达式再运算得到的生成器表达式的一个组合。

```python
roots = ((x, x**2) for x in it)
```

 每次我推进迭代器，它会自动推进内部迭代器，从而产生循环的效果，评估条件表达式以及传递输入和输出。

  像这样链式的生成器在python中这样执行是非常快的。当你想找一个方式来组合可在大量输入中运行的功能时，生成器表达式就是一个很好的工具。唯一的问题是生成器表达式返回的迭代器是有状态的，你必须要小心的注意使用它的次数。

### 一些需要记住的事情

- 列表生成器要处理数据量大的输入的话会占用过多的内存
- 生成器表达式可以通过返回一个迭代器来避免消耗大量内存的问题
- 生成器表达式可以将另一个生成器表达式返回的迭代器进行迭代
- 链式生成器在python中执行十分迅速

## 项目10：枚举比range好

  内置函数range在for循环中是十分有用的工具可以迭代一个范围内的整数。

```python
random_bit = 0 
for i in range(64):
    if randint(0, 1):
        random_bit |= 1 << i
```

  当你想要迭代一个数据结构中的每一项时，比如一个字符串列表，你可以直接循环这个序列。

```python
c_list = ['a', 'b', 'c', 'd']
for x in c_list:
    print(x)
```

  通常，你想要迭代一个列表中的每一项的值以及它的索引。举个例子，如果你想要输出c_list列表中的每一项以及它的索引。有一种方式是使用range函数。

```python
for i in range(len(c_list)):
    print(i, c_list[i])
```

  这样的写法显得有些笨拙，你需要知道列表的长度，你需要在访问时索引，且不具备易读性。

  python提供了内置函数enumerate来解决这种情况。枚举用惰性生成器包装任何迭代器。会同时返回索引和值。

```python
for i, c in enumerate(c_list):
    print(i, c)
```

  你可以使用指定开始计数的数字。

```python
for i, c in enumerate(c_list, 1):
    print(i, c)
```

### 一些需要记住的事情

- 枚举提供了简洁的语法，用于遍历迭代器并在你进行操作时获取索引

- 当你需要遍历一个序列时，枚举比range函数好

- 你可以对enumerate指定第二个参数表示从哪个数开始计数


## 项目11：使用`zip`去并行处理迭代器

  有时候你想要在python中多个相关的对象里查找数据。列表生成器使得你可以轻松的按照一定的表达式和输入数据生成一个相关数据的列表。

```python
names = ['zhang', 'wang', 'yu', 'li']
letters = [len(n) for n in names]
```

  派生列表中的项目通过索引与原列表的项目有一定的管理。想要并行生成两个列表，你可以通过迭代names原列表内的每一项。

```python
longest_name = None
max_letters = 0
for i in range(len(names)):
    count = letters[i]
    if count > max_letters :
        longest_name = names[i]
        max_letters = count
print(longest_name)
```

  按上面的代码处理的话整个循环显得十分复杂，因为同时要用到索引和值，我们可以使用项目10中的枚举。

```python
for i, name in enumerate(names):
    count = letters[i]
    if count > max_letters:
        longest_name = name
        max_letters = count
```

  但这样还是不够理想，为了使代码更加简洁，python提供了内置函数`zip`。在python3中，zip可以通过懒生成器包装两个及以上的多个迭代器。zip生成器每次包含每个迭代器的值。下面的代码示例用`zip`来处理多个列表。

```python
for name, count in zip(names, letters):
    if count > max_letters:
        longest_name = name
        max_letters = count
```

  关于内置函数`zip`有两个问题。

  第一个问题是python2中的zip不是一个生成器，它会返回创建的所有元组的列表。这会导致使用很多的内存，导致你的程序卡顿。如果你想要在python2中使用`zip`处理一个很大的迭代器的话，你可以使用`itertools`内置模块中的`izip`。

  第二个问题是如果输入迭代器有着不同的长度的话，那么zip的表现会有些奇怪。举个例子，在names列表中添加一个，而letters中不添加。再运行zip，会出现不是你设想的那样的结果。

```python
names.append('ms')
for name, count in zip(names, letters):
    print(name)
```

  你会发现，新添加的ms并没有进行输出。这就是zip的工作机制，它会遍历迭代知道其中一个迭代器无法迭代为止。这样的机制在你处理有着相同长度的迭代器时会有很好的表现。但在另一些情况，如果你不能确定迭代器的长度相等的话，你可以考虑使用`itertools`内置模块中的`zip_longest`函数。

### 一些需要记住的事情

- `zip`内置函数可以用来并行处理多个迭代器
- 在python3中，`zip`是一个输出元组的懒生成器，在python2中`zip`会返回所有元组的列表集合。
- `zip`会按照多个迭代器最短的那个长度作为终止的条件
- 如果你不能确定迭代器的长度相等的话，你可以考虑使用`itertools`内置模块中的`zip_longest`函数。

## 项目12： 在循环结构体后避免else块

  python循环有一个别的程序语言没有的额外特性：你可以在一个循环体后直接放一个else块

```python
for i in range(3):
    print('i')
else:
    print('else')
```

  可以发现，else块在循环结束后立即执行了。为什么这个叫else？而不是and?在if/else语句中，else的意思是“如果判断的条件不成立的话就执行这个”。在try/except语句中，except也有着类似的定义“如果尝试此操作之前失败，请执行此操作”。

  将else的所有用法都告诉一个新的程序员后，这个程序员可能会在理解for/else中else的含义理解为“如果循环没有完成的话，请执行此操作“。但事实上，正好相反。如果在循环中使用了break终止循环的进行则会跳过else块。

```python
for i in range(3):
    print(i)
    if i == 1:
        break
else:
    print('else')
```

  另外，如果循环的是一个空的集合或者while false时，else块仍然会运行。

```python
for i in []:
    print(i)
else:
    print('else')
while False:
    print('1')
else:
    print('else')
```

  这些表现的可以看出在循环后接else块可以处理当你使用循环搜索某些内容的情况。比如，如果你想要确定两个数是否互质。那么你可以迭代每个可能的共因数进行测试。当每一个可能性都尝试后，循环完毕，运行else块就说明是互质，在循环测试过程中没有被break打断。

```python
a = 4
b = 9
for i in range(2, min(a, b) + 1):
    print(i)
    if a % i == 0 and b % i == 0:
        print('not coprime')
        break
else:
    print('comprime')
```

  然而实际上你并不会用这样的代码，你通常会写一个辅助函数来帮助计算。关于辅助函数有下面两种写法。

  第一种方法是当你在循环中找到符合条件的就直接返回，如果循环正常完毕就返回默认值

```python
def coprime(a, b):
    for i in range(2, min(a, b) + 1):
        if a % i == 0 and b % i == 0:
            return False
    return True
```



​    第二种方法是设置一个结果变量如下。

```python
def coprime(a, b):
    is_coprime = True
    for i in range(2, min(a, b) + 1):
        if a % i == 0 and b % i == 0:
            is_coprime = False
            break
    return is_coprime
```

   辅助函数得这两种写法都比用else的方法表现得更清楚。像循环这种简单的构造在python中是很好理解的，所以尽量避免在循环结构体后直接接else块。

### 一些需要记住的事情：

- python有可以在循环结构体后直接接else块的特殊结构
- 在循环结构体后的else块只有当循环是正常完全遍历后才会执行
- 避免在循环结构体后直接接else块

## 项目13：利用好try/except/else/finally的每一个部分

  在python中异常处理时有四个不同的时间可以采取措施。由`try`，`except`，`else`，`finally`这四个部分组成。每个部分都有它自己的独特目的，它们的部分结合也十分有用。

### finally块

  当你希望异常发生时，即使发生异常也要运行清除代码的话，请使用try/finally。一个常用的用法是在文件处理时。

```python
handle = open('data.txt')
try:
    data = handle.read()
finally:
    handle.close()
```

  无论在读时出现什么异常，finally块都会执行会记得把文件关闭。你必须在try块之前调用open，因为当打开文件时发生异常就不需要finally块的关闭处理。

### else块

  当try块没有抛出异常的情况下，else块就会运行。该部分会使你的代码变得简洁并提高可读性。举个例子，如果你想要从一个字符串中加载json字典，并返回其包含的key值。

```python
def load_json_key(data, key):
    try:
        result_dict = json.loads(data)
    except ValueError as e:
        raise KeyError from e
    else:
        return result_dict[key]
```

  如果数据不是合法的json，按照json.loads处理后就会抛出一个ValueError。这个异常就会被expect部分捕捉并处理。如果是正常的就是执行else块。这就使得代码十分清晰。

### 一起使用

四个部分一起使用。举个例子，如果你想要从一个文件中做一些处理工作，并在原文件位置更新数据。可以按下方代码编写。

```python
UNDEFINED = object()
def divide_json(path):
    handle = open(path, 'r+')
    try:
        data = handle.read()
        op = json.loads(data)
        value = (        	op['numerator']/op['denominator']
        )
    except ZeroDivisionError as e:
        return UNDEFINED
    else:
        op['result'] = value
        result = json.dumps(op)
        handle.seek(0)
        handle.write(result)
        return value
   finally:
    handle.close()
```

### 一些需要记住的事情

- try/finally的复合语句可以让你不管try块是否出现异常都运行清除代码
- else使你的代码变得简洁，将try和except清晰分开
- 在成功的try块之后但在finally块中的常规清理之前，else块可用于执行其他操作

