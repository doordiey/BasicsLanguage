# html相关知识

## 基本介绍

- 超文本标记语言
- 通过便签将网络资源进行整理。

## 历史发展

- HTML1.0   1993年
- HTML2.0   1995年
- HTML3.0    1996年 W3C提出标准
- HTML4.0    1997年
- HTML4.1     1999年
- HTML5      2014年提出

### 主流浏览器

火狐、IE、谷歌、Opera、Safari

- 浏览器内核由渲染引擎和JS引擎两部分组成

#### 浏览器内核：

- Trident(IE)
- Webkit(safari/chrome)
- blink(chrome/opera)
- Gecko(火狐)

国内多是双核驱动(Trident&webkit或trident&blink)

移动端：iphoe/ipad 用webkit内核，android4.4以下用的webkit,以上用的blink内核

## 具体细节

### 基本结构

```html
<html>
    <head>
        <meta charset='UTF-8'> //设置对应内容
        <title></title>
    </head>
    <body></body>
</html>
```

### 标签

#### 块级和行级(内联)

##### 块级 ：多为结构性标记

- 块级独占一行，识别宽高，如果不设置，宽度为整行宽度，高度为内容实际的高度。
- 可以通过设置`display:inline` 转换为行级标签。
- 块级元素中可以包含块级元素和行内元素。
- 举例：div,p,h1-h6,p,hr,ul,ol,pre,table,address
  - div:无特定含义，常用来进行文档布局，还可以与CSS配合使用对大的内容块设置样式属性
  - h1-h6:标题，从h1到h6字体逐渐变小
  - p:段落，p标签内换行不识别，多个空格只识别一个。
  - hr:在页面中创建水平线，没有关闭标签
    - `<hr>`和`<hr />`都能被浏览器正确的识别，但多用后者。
  - ul:无序列表
  - ol:有序列表
  - pre:预格式化的文本，保留空格和换行符，文本会呈现为等宽字体，常见应用是表示计算机的源代码

##### 行级：多为描述性标记

- 行级不独占一行，不能设置宽高,宽高分别为内容实际的宽高。
- 可以通过设置`display:blick`转换为块级标签。
- 行内元素只能包含行内元素。
- 举例：span,br,a,img,b,strong,i,em,sup,sub
  - span:无特定含义，可以用作文本的容器，还可以与CSS配合为部分文本设置样式属性
  - br:不产生新段落的情况下进行换行，没有关闭标签
    - `<br>`和`<br />`两种写法都可以被浏览器正确的识别，但后者是更长远的保障。
  - a:超链接，两种使用方式
    - 通过href属性，创建指向另一个文档的链接
    - 通过使用name属性，创建文档内的书签
    - 可以使用target属性定义被链接的文档在何处显示
  - img:行内块元素，没有闭合标签
    - src属性，图片的地址
    - alt属性，当图片无法加载时，显示的信息
    - title属性，当鼠标移动到图片上时显示的文字
  - b:定义粗体文本
  - strong:定义加重语气，也可以加粗
    - 主要用于提取关键字的便捷
  - i:定义斜体字
  - em:着重文字
    - 斜体且强调
  - sup:定义上标字
  - sub:定义下标字

#### 标签属性

大部分标签由标签名、标签属性和文本内容三部分组成，标签属性用来对标签进行描述

- 通常由属性名='属性值'组成
- 起附加信息的作用
- 不是所有标签都有属性，如br标签就没有

##### 通用属性

- id:给标签取一个唯一的名称
- class:用来取一个类名
- style:样式
- title:鼠标移动到此处时，显示的内容

##### 自定义属性

- 格式：data-*=""

#### 一些特殊的标签

##### table 

```html
<table>
    <tr>
    	<th></th>
    </tr>
    <tr>
        <td></td>
    </tr>
</table>
```

- table 定义表格
- caption 表格标题
- th 表头
- tr 行
- td 表格单元
- thead 页眉
- tbody 表格主题
- tfoot 页脚
- col 列的属性
- colgroup 列的组

##### form

```html
<form>
    <input type='text' name='name'>
    <button type='button' onclict='alert("you torch me!")'> 
    </button>
</form>
```

- form 表单的一些属性

  - accept-charset：提交表单使用的字符集
  - action：向何处提交表单
  - autocomplete:自动完成表单
  - enctype:规定被提交数据的编码
  - method 提交表单的http方法【默认是get
    - get的话，url内会显示表单提交的信息
    - post不会
    - name 表单的名称
    - novalidate  浏览器不验证表单
- input 元素一些type
  - text:文本输入的单行输入字段
  - password：密码字段
  - submit：定义提交表单数据到表单处理程序
  - radio：单选按钮
  - checkbox：复选框
  - button：定义按钮
  - 还有很多html5新的输入类型，如date,color,email,number等，还可以对输入数据进行限制。
- select元素定义下拉列表
  - option表示下拉列表的每一项
- texterea元素定义多行输入字段【文本域
- button元素定义按钮

##### 框架

- 在一个浏览器窗口中显示不止一个页面

### W3C规范

- 结构
- 表现
- 行为

#### 嵌套规范

- 块级元素可以包含行级元素，但行级元素只能包含行级元素
- p,h1-h6-dt标签中只能包含行级标签，不能包含块级标签
- 块级元素与块级元素并列，行级与行级并列