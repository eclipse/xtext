---
layout: documentation
title: Expressions
part: Reference Documentation
---

# {{page.title}} {#xtend-expressions}

In Xtend everything is an expression and has a return type. Statements do not exist. That allows you to compose your code in interesting ways. For example, you can have a `try catch` expression on the right hand side of an assignment: 

```xtend
val data = try {
    fileContentsToString('data.txt')
  } catch (IOException e) {
    'dummy data'
  }
```

If `fileContentsToString()` throws an [IOException]({{site.javadoc.java}}/java/io/IOException.html), it is caught and the string `'dummy data'` is assigned to the value `data`. Expressions can appear as [initializers of fields](202_xtend_classes_members.html#fields), the body of constructors or methods and as values in annotations. A method body can either be a [block expression](203_xtend_expressions.html#blocks) or a [template expression](203_xtend_expressions.html#templates).

## Literals {#xtend-expressions-literals}

A literal denotes a fixed, unchangeable value. Literals for [strings](203_xtend_expressions.html#string-literals), [numbers](203_xtend_expressions.html#number-literals), [booleans](203_xtend_expressions.html#boolean-literal), `null` and [Java types](203_xtend_expressions.html#type-literal) are supported as well as literals for unmodifiable collection types like lists, sets and maps or literals for arrays.

### String Literals {#string-literals}

A string literal is of type [String]({{site.javadoc.java}}/java/lang/String.html). String literals are enclosed in a pair of single quotes or double quotes. Single quotes are more common because the signal-to-noise ration is better, but generally you should use the terminals which are least likely to occur in the string value. Special characters can be quoted with a backslash or defined using unicode notation. Contrary to Java, strings can span multiple lines.

```xtend
'Hello World !'
"Hello World !"
'Hello "World" !'
"Hello \"World\" !"
"Hello 

  World !"
```

### Character Literals {#character-literals}

Character literals use the same notation as String literals. If a single character literal is used in a context where a primitive `char` or the wrapper type [Character]({{site.javadoc.java}}/java/lang/Character.html) is expected, the compiler will treat the literal as such a value or instance.

```xtend
val char c = 'c'
```

### Number Literals {#number-literals}

Xtend supports roughly the same number literals as Java with a few differences. First, there are no signed number literals. If you put a minus operator in front of a number literal it is treated as a [unary operator](203_xtend_expressions.html#operators) with one argument (the positive number literal). Second, as in Java 7, you can separate digits using `_` for better readability of large numbers. An integer literal creates an `int`, a `long` (suffix `L`) or a [BigInteger]({{site.javadoc.java}}/java/math/BigInteger.html) (suffix `BI`). There are no octal numbers

```xtend
42
1_234_567_890 
0xbeef    // hexadecimal
077       // decimal 77 (*NOT* octal)
-1  // an expression consisting of the unary - operator and an integer literal  
42L
0xbeef#L // hexadecimal, mind the '#'
0xbeef_beef_beef_beef_beef#BI // BigInteger
```

A floating-point literal creates a `double` (suffix `D` or none), a `float` (suffix `F`) or a [BigDecimal]({{site.javadoc.java}}/java/math/BigDecimal.html) (suffix `BD`). If you use a `.` you have to specify both, the integral and the fractional part of the mantissa. There are only decimal floating-point literals. 

```xtend
42d     // double
0.42e2  // implicit double
0.42e2f // float
4.2f    // float
0.123_456_789_123_456_789_123_456_789e2000bd // BigDecimal
```

### Boolean Literals {#boolean-literal}

There are two boolean literals, `true` and `false` which correspond to their Java counterpart of type `boolean`. 

### Null Literal {#null-literal}

The null pointer literal `null` has exactly the same semantics as in Java.

### Type Literals {#type-literal}

The syntax for type literals is generally the plain name of the type, e.g. the snippet `String` is equivalent to the Java code `String.class`. Nested types use the delimiter `'.'`.

To disambiguate the expression, type literals may also be specified using the keyword `typeof`.

*   `Map.Entry` is equivalent to `Map.Entry.class`
*   `typeof(StringBuilder)` yields `StringBuilder.class`

Consequently it is possible to access the members of a type reflectively by using its plain name `String.getDeclaredFields`.

The keyword `typeof` is mandatory for references to array types, e.g. `typeof(int[]`

Previous versions of Xtend (2.4.1 and before) used the dollar as the delimiter character for nested types and enforced the use of `typeof` for all type literals:

*   `typeof(Map$Entry)` yields `Map.Entry.class`

### Collection Literals {#collection-literals}

The methods in [CollectionLiterals]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/CollectionLiterals.java) are automatically imported so it's very easy and convenient to create instances of the various collection types the JDK offers.

```xtend
val myList = newArrayList('Hello', 'World')
val myMap = newLinkedHashMap('a' -> 1, 'b' -> 2) 
```

In addition xtend supports collection literals to create immutable collections and arrays, depending on the target type. An immutable list can be created like this:

```xtend
val myList = #['Hello','World']
```

If the target type is an array as in the following example an array is created instead without any conversion:

```xtend
val String[] myArray = #['Hello','World']
```

An immutable set can be created using curly braces instead of the squared brackets:

```xtend
val mySet = #{'Hello','World'}
```

An immutable map is created like this: 

```xtend
val myMap = #{'a' -> 1 ,'b' ->2}
```

### Arrays {#arrays}

Java arrays can be created either using a [literal](203_xtend_expressions.html#collection-literals) as described in the previous section, or if it should be a new array with a fixed size, one of the methods from [ArrayLiterals]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/ArrayLiterals.java) can be used. The generic `newArrayOfSize(int)` method works for all reference types, while there is a specific factory method for each primitive type.

Example: 

```xtend
val String[] myArray = newArrayOfSize(400)
val int[] intArray = newIntArrayOfSize(400)
```

Retrieving and setting values of arrays is done through the extension methods `get(int)` and `set(int, T)` which are specifically overloaded for arrays and are translated directly to the equivalent native Java code `myArray[int]`.

Also `length` is available as an extension method and is directly translated to Java's equivalent `myArray.length`.

Furthermore arrays are automatically converted to lists (`java.util.List`) when needed. This works similar to how boxing and unboxing between primitives and their respective wrapper types work.

Example: 

```xtend
val int[] myArray = #[1,2,3]
val List<Integer> myList = myArray
```

## Type Casts {#type-casts}

A type cast behaves exactly like casts in Java, but has a slightly more readable syntax. Type casts bind stronger than any other operator but weaker than feature calls.

The conformance rules for casts are defined in the [Java Language Specification](http://docs.oracle.com/javase/specs/jls/se6/html/conversions.html#5.5). Here are some examples: 

```xtend
something as MyClass
42 as Integer
```

Instead of a plain type cast it's also possible to use a [switch with a type guard](203_xtend_expressions.html#switch-expression) which performs both the casting and the instance-of check. [Dispatch methods](202_xtend_classes_members.html#polymorphic-dispatch) are another alternative to casts that offers the potential to enhance the number of expected and handled types in subclasses.

## Infix Operators and Operator Overloading {#operators}

There are a couple of common predefined infix operators. These operators are not limited to operations on certain types. Instead an operator-to-method mapping allows to redefine the operators for any type just by implementing the corresponding method signature. As an example, the runtime library contains a class [BigDecimalExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/BigDecimalExtensions.java) that defines operators for [BigDecimals]({{site.javadoc.java}}/java/math/BigDecimal.html). The following code is therefore perfectly valid: 

```xtend
val x = 2.71BD
val y = 3.14BD
val sum = x + y    // calls BigDecimalExtension.operator_plus(x,y)
```

This is the complete list of all available operators and their corresponding method signatures:

|:---|:---|
|`e1 += e2`|`e1.operator_add(e2)`|
|`e1 -= e2`|`e1.operator_remove(e2)`|
|||
|`e1 || e2`|`e1.operator_or(e2)`|
|||
|`e1 && e2`|`e1.operator_and(e2)`|
|||
|`e1 == e2`|`e1.operator_equals(e2)`|
|`e1 != e2`|`e1.operator_notEquals(e2)`|
|`e1 === e2`|`e1.operator_tripleEquals(e2)`|
|`e1 !== e2`|`e1.operator_tripleNotEquals(e2)`|
|||
|`e1 < e2`|`e1.operator_lessThan(e2)`|
|`e1 > e2`|`e1.operator_greaterThan(e2)`|
|`e1 <= e2`|`e1.operator_lessEqualsThan(e2)`|
|`e1 >= e2`|`e1.operator_greaterEqualsThan(e2)`|
|||
|`e1 -> e2`|`e1.operator_mappedTo(e2)`|
|`e1 .. e2`|`e1.operator_upTo(e2)`|
|`e1 >.. e2`|`e1.operator_greaterThanDoubleDot(e2)`|
|`e1 ..< e2`|`e1.operator_doubleDotLessThan(e2)`|
|`e1 => e2`|`e1.operator_doubleArrow(e2)`|
|`e1 << e2`|`e1.operator_doubleLessThan(e2)`|
|`e1 >> e2`|`e1.operator_doubleGreaterThan(e2)`|
|`e1 <<< e2`|`e1.operator_tripleLessThan(e2)`|
|`e1 >>> e2`|`e1.operator_tripleGreaterThan(e2)`|
|`e1 <> e2`|`e1.operator_diamond(e2)`|
|`e1 ?: e2`|`e1.operator_elvis(e2)`|
|`e1 <=> e2`|`e1.operator_spaceship(e2)`|
|||
|`e1 + e2`|`e1.operator_plus(e2)`|
|`e1 - e2`|`e1.operator_minus(e2)`|
|||
|`e1 * e2`|`e1.operator_multiply(e2)`|
|`e1 / e2`|`e1.operator_divide(e2)`|
|`e1 % e2`|`e1.operator_modulo(e2)`|
|`e1 ** e2`|`e1.operator_power(e2)`|
|||
|`! e1`|`e1.operator_not()`|
|`- e1`|`e1.operator_minus()`|
|`+ e1`|`e1.operator_plus()`|

The table above also defines the operator precedence in ascending order. The blank lines separate precedence levels. The assignment operators `+=` and `-=` are right-to-left associative in the same way as the plain assignment operator `=` is. That is a = b = c is executed as a = (b = c), all other operators are left-to-right associative. Parentheses can be used to adjust the default precedence and associativity. 

### Short-Circuit Boolean Operators

If the operators `||`, `&&`, and `?:` are bound to the library methods [`BooleanExtensions.operator_and(boolean l, boolean r)`]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/BooleanExtensions.java), [`BooleanExtensions.operator_or(boolean l, boolean r)`]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/BooleanExtensions.java) resp. [`<T> T operator_elvis(T first, T second)`]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/ObjectExtensions.java) the operation is inlined and evaluated in short circuit mode. That means that the right hand operand might not be evaluated at all in the following cases: 

1.  in the case of `||` the operand on the right hand side is not evaluated if the left operand evaluates to `true`.
1.  in the case of `&&` the operand on the right hand side is not evaluated if the left operand evaluates to `false`.
1.  in the case of `?:` the operand on the right hand side is not evaluated if the left operand evaluates to anything but `null`.

Still you can overload these operators for your types or even override it for booleans, in which case both operands are always evaluated and the defined method is invoked, i.e. no short-circuit execution is happening.

### Postfix Operators

The two postfix operators `++` and `--` use the following method mapping:

|:---|:---|
|`e1++`|`e1.operator_plusPlus()`|
|`e1--`|`e1.operator_minusMinus()`|

### Defined Operators in The Library

Xtend offers operators for common types from the JDK.

#### Equality Operators

In Xtend the equals operators (`==`,`!=`) are bound to `Object.equals`. So you can write:

```xtend
if (name == 'Homer')
	println('Hi Homer')
```

Java's identity equals semantic is mapped to the tripple-equals operators `===` and `!==` in Xtend.

```xtend
if (someObject === anotherObject)
	println('same objects')
```

#### Comparison Operators

In Xtend the usual comparison operators (`>`,`<`,`>=`, and `<=`) work as expected on the primitive numbers:

```xtend
if (42 > myNumber) {
	...
}
```

In addition these operators are overloaded for all instances of `java.lang.Comparable`. So you can also write

```xtend
if (startTime < arrivalTime)
	println("You are too late!")
```

#### Arithmetic Operators

The arithmetic operators (`+`,`-`,`*`,`/`,`%`, and `**`) are not only available for the primitive types, but also for other reasonable types such as `BigDecimal` and `BigInteger`.

```xtend
val x = 2.71BD
val y = 3.14BD
val sum = x + y    // calls BigDecimalExtension.operator_plus(x,y)
```

#### Elvis Operator

In addition to [null-safe feature calls](203_xtend_expressions.html#null-safe-feature-calls) Xtend supports the elvis operator known from Groovy.

```xtend
val salutation = person.firstName ?: 'Sir/Madam' 
```

The right hand side of the expression is only evaluated if the left side was `null`.

#### With Operator

The with operator is very handy when you want to initialize objects or when you want to use a particular instance a couple of time in subsequent lines of code. It simply passes the left hand side argument to the lambda on the right hand and returns the left hand after that.

Here's an example:

```xtend
val person = new Person => [
	firstName = 'Homer'
	lastName = 'Simpson'
	address = new Address => [
		street = '742 Evergreen Terrace'
		city = 'SpringField'
	]
]
```

#### Range Operators

There are three different range operators. The most useful ones are `..<` and `>..` which create exclusive ranges.

```xtend
// iterate the list forwards
for (i : 0 ..< list.size) {
	val element = list.get(i)
	...
}
```

```xtend
// or backwards
for (i : list.size >.. 0) {
	val element = list.get(i)
	...
}
```

In addition there is the inclusive range, which is nice if you know both ends well. In the movies example the range is used to check whether a movie was made in a certain decade:

```xtend
movies.filter[1980..1989.contains(year)]
```

Please keep in mind that there are other means to iterator lists, too. For example, you may want to use the `forEach` extension

```xtend
list.forEach[ element, index |
	.. // if you need access to the current index
]
list.reverseView.forEach[
  .. // if you just need the element it in reverse order
]
```

#### Pair Operator

Sometimes you want to use a pair of two elements locally without introducing a new structure. In Xtend you can use the `->`-operator which returns an instance of `Pair<A,B>`:

```xtend
val nameAndAge = 'Homer' -> 42
```

If you want to surface a such a pair of values on the interface of a method or field, it's generally a better idea to use a data class with a well defined name, instead:

```xtend
@Data class NameAndAge {
	String name
	int age
}
```

### Assignments {#assignments}

[Local variables](203_xtend_expressions.html#variable-declaration) can be assigned using the `=` operator. 

```xtend
var greeting = 'Hello'
if (isInformal)
  greeting = 'Hi'
```

Of course, also non-final fields can be set using an assignment: 

```xtend
myObj.myField = 'foo'
```

#### Setting Properties {#property-assignments}

The lack of properties in Java leads to a lot of syntactic noise when working with data objects. As Xtend is designed to integrate with existing Java APIs it respects the Java Beans convention, hence you can call a setter using an assignment:

```xtend
myObj.myProperty = 'foo' // calls myObj.setMyProperty("foo")
```

The setter is only used if the field is not accessible from the given context. That is why the [@Property annotation](204_activeannotations.html#property-annotation) would rename the local field to `_myProperty`.

The return type of an assignment is the type of the right hand side, in case it is a simple assignment. If it is translated to a setter method it yields whatever the setter method returns.

#### Assignment Operators {#assignment-operators}

Compound assignment operators can be used as a shorthand for the assignment of a binary expression.

```xtend
var BigDecimal bd = 45bd
bd += 12bd // equivalent to bd = bd + 12bd
bd -= 12bd // equivalent to bd = bd - 12bd
bd /= 12bd // equivalent to bd = bd / 12bd
bd *= 12bd // equivalent to bd = bd * 12bd
```

Compound assignments work automatically when the infix operator is declared. The following compound assignment operators are supported:

|:---|:---|
|`e1 += e2`|`+`|
|`e1 -= e2`|`-`|
|`e1 *= e2`|`*`|
|`e1 /= e2`|`/`|
|`e1 %= e2`|`%`|

---

## Blocks {#blocks}

The block expression allows to have imperative code sequences. It consists of a sequence of expressions. The value of the last expression in the block is the value of the complete block. The type of a block is also the type of the last expression. Empty blocks return `null` and have the type [Object]({{site.javadoc.java}}/java/lang/Object.html). [Variable declarations](203_xtend_expressions.html#variable-declaration) are only allowed within blocks and cannot be used as a block's last expression.

A block expression is surrounded by curly braces. The expressions in a block can be terminated by an optional semicolon.

Here are two examples:

```xtend
{
  doSideEffect("foo")
  result
}
```

```xtend
{
  var x = greeting;
  if (x.equals("Hello ")) {
    x + "World!" 
  } else {
    x
  }
}
```

## Variable Declarations {#variable-declaration}

Variable declarations are only allowed within [blocks](203_xtend_expressions.html#blocks). They are visible from any subsequent expressions in the block. 

A variable declaration starting with the keyword `val` denotes a value, which is essentially a final, unsettable variable. The variable needs to be declared with the keyword `var`, which stands for 'variable' if it should be allowed to reassign its value.

A typical example for using `var` is a counter in a loop: 

```xtend
{
  val max = 100
  var i = 0
  while (i < max) {
    println("Hi there!")
    i = i + 1
  }
}
```

Shadowing variables from outer scopes is not allowed, the only exception is the [implicit variable](203_xtend_expressions.html#implicit-variables)`it`.

Variables declared outside of a lambda expression using the `var` keyword are not accessible from within the lambda expressions.

A local variable can be marked with the `extension` keyword to make its methods available as extensions ([see extension provider](202_xtend_classes_members.html#extension-provider)). 

### Typing

The type of the variable itself can either be explicitly declared or it can be inferred from the initializer expression. Here is an example for an explicitly declared type: 

```xtend
var List<String> strings = new ArrayList
```

In such cases, the type of the right hand expression must conform to the type of the expression on the left side.

Alternatively the type can be inferred from the initializater: 

```xtend
var strings = new ArrayList<String> // -> msg is of type ArrayList<String>  
```

## Field Access and Method Invocations {#feature-calls}

A simple name can refer to a local field, variable or parameter. In addition it can point to a method with zero arguments, since empty parentheses are optional. 

### Property Access {#property-access}

If there is no field with the given name and also no method with the name and zero parameters accessible, a simple name binds to a corresponding Java-Bean getter method if available:

```xtend
myObj.myProperty // myObj.getMyProperty()  (.. in case myObj.myProperty is not visible.)
```

### Implicit Variables this and it {#implicit-variables}

Like in Java the current instance of the class is bound to `this`. This allows for either qualified field access or method invocations like in:

```xtend
this.myField
```

or it is possible to omit the receiver:

```xtend
myField
```

You can use the variable name `it` to get the same behavior for any variable or parameter:

```xtend
val it = new Person
name = 'Horst' // translates to 'it.setName("Horst");'
```

Another speciality of the variable `it` is that it is allowed to be shadowed. This is especially useful when used together with [lambda expressions](203_xtend_expressions.html#lambdas).

As `this` is bound to the surrounding object in Java, `it` can be used in finer-grained constructs such as [lambda expressions](203_xtend_expressions.html#lambdas). That is why `it.myProperty` has higher precedence than `this.myProperty`.

### Static Access {#static-access}

For accessing a static field or method you can use the recommended Java syntax or the more explicit double colon `::`. That means, the following epxressions are pairwise equivalent:

```xtend
MyClass.myField
MyClass::myField
```

```xtend
com.acme.MyClass.myMethod('foo')
com.acme.MyClass::myMethod('foo')
com::acme::MyClass::myMethod('foo')
```

Alternatively you could import the method or field using a [static import](202_xtend_classes_members.html#imports).

### Null-Safe Feature Calls {#null-safe-feature-calls}

Checking for `null` references can make code very unreadable. In many situations it is ok for an expression to return `null` if a receiver was `null`. Xtend supports the safe navigation operator `?.` to make such code better readable.

Instead of writing 

```java
if (myRef != null) myRef.doStuff()
```

one can write 

```xtend
myRef?.doStuff
```

Arguments that would be passed to the method are only evaluated if the method will be invoked at all.

For primitive types the default value is returned (e.g. 0 for int). This may not be what you want in some cases, so a warning will be raised by default. You can turn that off in the preferences if you wish.

## Constructor Calls {#constructor-call}

Constructor calls have the same syntax as in Java. The only difference is that empty parentheses are optional: 

```xtend
new String() == new String
new ArrayList<BigDecimal>() == new ArrayList<BigDecimal>
```

If type arguments are omitted, they will be inferred from the current context similar to Java's diamond operator on generic method and constructor calls.

## Lambda Expressions {#lambdas}

A lambda expression is basically a piece of code wrapped into an object to pass it around. As a Java developer it is best to think of a lambda expression as an anonymous class with a single method, i.e. like in the following Java code :

```java
// Java Code!
final JTextField textField = new JTextField();
textField.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    textField.setText("Something happened!");
  }
});
```

This kind of anonymous classes can be found everywhere in Java code and have always been the poor-man's replacement for lambda expressions in Java. This has been improved with [Java 8 lambda expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html), which are conceptually very similar to Xtend lambda expressions. Depending on the selected target language version, Xtend lambdas are translated differently to Java: Java lambdas are generated for Java 8 (since 2.8), while anonymous classes are generated for lower versions.

The code above can be written in Xtend like this:

```xtend
val textField = new JTextField
textField.addActionListener([ ActionEvent e |
  textField.text = "Something happened!"
])
```

As you might have guessed, a lambda expression is surrounded by square brackets (inspired from Smalltalk). Similarly to a method, a lambda expression may declare parameters. The lambda above has one parameter called `e` which is of type `ActionEvent`. You do not have to specify the type explicitly because it can be inferred from the context:

```xtend
textField.addActionListener([ e |
  textField.text = "The command '" + e.actionCommand + "' happened!"
])
```

You do not need to speficy the argument names. If you leave them out, a single argument is named `it`. If the lambda has more arguments, the implicit names are `$1,$2,...,$n` depending on the number of arguments of course. Here's an example with a single argument named `it`. In this case `actionCommand` is equivalent to `it.actionCommand`.

```xtend
textField.addActionListener([
  textField.text = "The command '" + actionCommand + "' happened!"
])
```

A lambda expression with zero arguments can be written with or without the bar. They are both the same.

```xtend
val Runnable aBar = [|
  println("Hello I'm executed!")
]
val Runnable noBar = [
  println("Hello I'm executed!")
]
```

When a method call's last parameter is a lambda it can be passed right after the parameter list. For instance if you want to sort some strings by their length, you could write :

```xtend
Collections.sort(someStrings) [ a, b |
  a.length - b.length
]
```

which is just the same as writing

```xtend
Collections.sort(someStrings, [ a, b |
  a.length - b.length
])
```

Since you can leave out empty parentheses for methods which get a lambda as their only argument, you can reduce the code above further down to:

```xtend
textField.addActionListener [
  textField.text = "Something happened!"
]
```

A lambda expression also captures the current scope. Any final local variables and all parameters that are visible at construction time can be referred to from within the lambda body. That is exactly what we did with the variable `textField` above.

The variable `this` refers to the outer class. The lambda instance itself is available with the identifier `self`.

```xtend
val lineReader = new LineReader(r);
val AbstractIterator<String> lineIterator = [|
	val result = lineReader.readLine 
	if (result==null)
		self.endOfData
	return result
]
```

### Typing {#closure-types}

Lambdas are expressions which produce *Function* objects. The type of a lambda expression generally depends on the target type, as seen in the previous examples. That is, the lambda expression can coerce to any interface or abstract class which has declared only one abstract method. This allows for using lambda expressions in many existing Java APIs in a similar way as [Java 8 lambdas](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#target-typing) can be used. 

However, if you write a lambda expression without having any target type expectation, like in the following assignment:

```xtend
val toUpperCaseFunction = [ String s | s.toUpperCase ] // inferred type is (String)=>String
```

The type will be one of the inner types found in [Functions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Functions.java) or [Procedures]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Procedures.java). It is a procedure if the return type is `void`, otherwise it is a function.

Xtend supports a shorthand syntax for function types. Instead of writing `Function1<? super String,? extends String>` which is what you will find in the generated Java code, you can simply write `(String)=>String`.

Example: 

```xtend
val (String)=>String stringToStringFunction = [ toUpperCase ]
// or
val Function1<? super String,? extends String> same = [ toUpperCase ]
// or
val stringToStringFunction2 = [ String s | s.toUpperCase ] // inferred type is (String)=>String
```

Checked exceptions that are thrown in the body of a lambda expression but not declared in the implemented method of the target type are thrown using the [sneaky-throw technique](202_xtend_classes_members.html#declared-exceptions). Of course you can always [catch and handle](203_xtend_expressions.html#xtend-expressions-try-catch) them.

## Anonymous Classes {#anonymous-classes}

An anonymous class in Xtend has the very same semantics as in Java (see [Java Language Sepcification](http://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.9.5)). Here's an example:

```xtend
val tabListener = new ActionBar.TabListener() {
  override onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
    // show the given tab
  }

  override onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    // hide the given tab
  }

  override onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    // probably ignore this event
  }
};
```

## If Expression {#if-expression}

An if-expression is used to choose between two different values based on a predicate.

An expression 

```xtend
if (p) e1 else e2
```

results in either the value `e1` or `e2` depending on whether the predicate `p` evaluates to `true` or `false`. The else part is optional which is a shorthand for an else branch that returns the default value of the current type, e.g. for reference type this is equivalent to `else null`. That means 

```xtend
if (foo) x 
```

is a short hand for

```xtend
if (foo) x else null
```

The type of an if expression is the common super type of the return types `T1` and `T2` of the two expression `e1` and `e2`.

While the if expression has the syntax of Java's if statement it behaves more like Java's ternary operator (`predicate ? thenPart : elsePart`), because it is an expression and returns a value. Consequently, you can use if expressions deeply nested within expressions:

```xtend
  val name = if (firstName != null) firstName + ' ' + lastName else lastName
```

## Switch Expression {#switch-expression}

The switch expression is very different from Java's switch statement. The use of `switch` is not limited to certain values but can be used for any object reference. `Object.equals(Object)` is used to compare the value in the case with the one you are switching over. Given the following example: 

```xtend
switch myString {
  case myString.length > 5 : "a long string."
  case 'some' : "It's some string."
  default : "It's another short string."
}
```

the main expression `myString` is evaluated first and then compared to each case sequentially. If the case expression is of type `boolean`, the case matches if the expression evaluates to `true`. If it is not of type `boolean` it is compared to the value of the main expression using `Object.equals(Object)`.

If a case is a match, that is it evaluates to `true` or the result equals the one we are switching over, the case expression after the colon is evaluated and is the result of the whole switch expression.

The main expression can also be a computed value instead of a field or variable. If you want to reuse that value in the body of the switch expression, you can create a local value for that by using the following notation which is similar to the syntax in [`for` loops](203_xtend_expressions.html#for-loop).

```xtend
switch myString : someComputation() {
  ..
}
```

### Type guards

Instead of or in addition to the case guard you can specify a *type guard*. The case only matches if the switch value conforms to this type. A case with both a type guard and a predicate only matches if both conditions match. If the switch value is a field, parameter or variable, it is automatically casted to the given type within the predicate and the case body.

```xtend
def length(Object x) {
  switch x {
    String case x.length > 0 : x.length // length is defined for String 
    List<?> : x.size    // size is defined for List
    default : -1
  }
}
```

Switches with type guards are a safe and much more readable alternative to instance of / casting cascades you might know from Java.

### Fall Through

You can have multiple type guards and cases separated with a comma, to have all of them share the same then part.

```xtend
def isMale(String salutation) {
  switch salutation {
    case "Mr.", 
    case "Sir" : true
    default : false
  }
}
```

## For Loop {#for-loop}

The for loop 

```xtend
for (T1 variable : arrayOrIterable) expression
```

is used to execute a certain expression for each element of an array or an instance of [Iterable]({{site.javadoc.java}}/java/lang/Iterable.html). The local `variable` is final, hence cannot be updated. 

The type of a for loop is `void`. The type of the local variable can be inferred from the iterable or array that is processed. 

```xtend
for (String s : myStrings) {
  doSideEffect(s)
}

for (s : myStrings)
  doSideEffect(s)
```

## Basic For Loop {#traditional-for-loop}

The traditional for loop 

```xtend
for (<init-expression> ;  <predicate> ; <update-expression>) body-expression
```

is very similar to the one known from Java, or even C. When executed, it first executes the `init-expression`, where local variables can be declared. Next the `predicate` is executed and if it evaluates to `true`, the `body-expression` is executed. On any subsequent iterations the `update-expressio` is executed instead of the init-expression. This happens until the `predicate` returns `false`.

The type of a for loop is `void`.

```xtend
for (var i = 0 ; i < s.length ; i++) {
  println(s.subString(0,i)
}
```

## While Loop {#while-expression}

A while loop 

```xtend
while (predicate) expression
```

is used to execute a certain expression unless the predicate is evaluated to `false`. The type of a while loop is `void`.

```xtend
while (true) {
  doSideEffect("foo")
}

while ((i=i+1) < max) 
  doSideEffect("foo")
```

## Do-While Loop {#do-while-expression}

A do-while loop 

```xtend
do expression while (predicate)
```

is used to execute a certain expression until the predicate is evaluated to `false`. The difference to the [while loop](203_xtend_expressions.html#while-expression) is that the execution starts by executing the block once before evaluating the predicate for the first time. The type of a do-while loop is `void`.

```xtend
do {
  doSideEffect("foo");
} while (true)


do doSideEffect("foo") while ((i=i+1)<max)
```

## Return Expression {#xtend-expressions-return}

A method or lambda expression automatically returns the value of its body expression. If it is a [block expression](203_xtend_expressions.html#blocks) this is the value of the last expression in it. However, sometimes you want to return early or make it explicit.

The syntax is just like in Java:

```xtend
listOfStrings.map [ e | 
  if (e==null) 
    return "NULL"
  e.toUpperCase
]
```

## Throwing Exceptions {#xtend-expressions-throw}

Throwing [Throwable]({{site.javadoc.java}}/java/lang/Throwable.html)s up the call stack has the same semantics and syntax as in Java.

```xtend
{
...
if (myList.isEmpty)
  throw new IllegalArgumentException("the list must not be empty")
...
}
```

## Try, Catch, Finally {#xtend-expressions-try-catch}

The try-catch-finally expression is used to handle exceptional situations. Checked exceptions are treated like runtime exceptions and only optionally validated. You can but do not have to catch them as they will be silently thrown (see the [section on declared exceptions](202_xtend_classes_members.html#declared-exceptions)).

```xtend
try {
  throw new RuntimeException()
} catch (NullPointerException e) {
  // handle e
} finally {
  // do stuff
}
```

For try-catch it is again beneficial that it is an expression, because you can write code like the following and do not have to rely on non-final variables:

```xtend
val name = try {
    readFromFile
  } catch (IOException e) {
    "unknown"
  }
```

## Synchronized {#xtend-expressions-synchronized}

The synchonized expression does the same as it does in Java (see [Java Language Specification](http://docs.oracle.com/javase/specs/jls/se7/html/jls-14.html#jls-14.19)). The only difference is that in Xtend it is an expression and can therefore be used at more places.

```xtend
synchronized(lock) {
  println("Hello")
}
```

```xtend
val name = synchronized(lock) { 
  doStuff() 
}
```

## Template Expressions {#templates}

Templates allow for readable string concatenation. Templates are surrounded by triple single quotes (`'''`). A template expression can span multiple lines and expressions can be nested which are evaluated and their `toString()` representation is automatically inserted at that position.

The terminals for interpolated expression are so called guillemets `«expression»`. They read nicely and are not often used in text so you seldom need to escape them. These escaping conflicts are the reason why template languages often use longer character sequences like e.g. `<%= expression %>` in JSP, for the price of worse readability. The downside with the guillemets in Xtend is that you will have to have a consistent encoding. Always use UTF-8 and you are good.

If you use the Eclipse plug-in the guillemets will be inserted on content assist within a template. They are additionally bound to *CTRL+\<* and *CTRL+\>* for `«` and `»` respectively. 

Let us have a look at an example of how a typical method with a template expressions looks like:

```xtend
def someHTML(String content) '''
  <html>
    <body>
      «content»
    </body>
  </html>
'''
```

As you can see, template expressions can be used as the body of a method. If an interpolation expression evaluates to `null` an empty string is added.

Template expressions can occur everywhere. Here is an example showing it in conjunction with the powerful [switch expression](203_xtend_expressions.html#switch-expression):

```xtend
def toText(Node n) {
  switch n {
    Contents : n.text

    A : '''<a href="«n.href»">«n.applyContents»</a>'''

    default : '''
        <«n.tagName»>
          «n.applyContents»
        </«n.tagName»>
    '''
  }
}
```

### Conditions in Templates {#template-if}

There is a special `IF` to be used within templates:

```xtend
def someHTML(Paragraph p) '''
  <html>
    <body>
      «IF p.headLine != null»
        <h1>«p.headline»</h1>
      «ENDIF»
      <p>
        «p.text»
      </p>
    </body>
  </html>
'''
```

### Loops in Templates {#template-foreach}

Also a `FOR` expression is available:

```xtend
def someHTML(List<Paragraph> paragraphs) '''
  <html>
    <body>
      «FOR p : paragraphs»
        «IF p.headLine != null»
          <h1>«p.headline»</h1>
        «ENDIF»
        <p>
          «p.text»
        </p>
      «ENDFOR»
    </body>
  </html>
'''
```

The for expression optionally allows to specify what to prepend (`BEFORE`), put in-between (`SEPARATOR`), and what to put at the end (`AFTER`) of all iterations. `BEFORE` and `AFTER` are only executed if there is at least one iteration. (`SEPARATOR`) is only added between iterations. It is executed if there are at least two iterations.

Here is an example:

```xtend
def someHTML(List<Paragraph> paragraphs) '''
  <html>
    <body>
      «FOR p : paragraphs BEFORE '<div>' SEPARATOR '</div><div>' AFTER '</div>'»
        «IF p.headLine != null»
          <h1>«p.headline»</h1>
        «ENDIF»
        <p>
          «p.text»
        </p>
      «ENDFOR»
    </body>
  </html>
'''
```

### Typing {#template-type}

The template expression is of type [CharSequence]({{site.javadoc.java}}/java/lang/CharSequence.html). It is automatically converted to [String]({{site.javadoc.java}}/java/lang/String.html) if that is the expected target type.

### White Space Handling {#whitespace-handling}

One of the key features of templates is the smart handling of white space in the template output. The white space is not written into the output data structure as is but preprocessed. This allows for readable templates as well as nicely formatted output. The following three rules are applied when the template is evaluated:

1.  Indentation in the template that is relative to a control structure will not be propagated to the output string. A control structure is a `FOR`-loop or a condition (`IF`) as well as the opening and closing marks of the template string itself. The indentation is considered to be relative to such a control structure if the previous line ends with a control structure followed by optional white space. The amount of indentation white space is not taken into account but the delta to the other lines. 
1.  Lines that do not contain any static text which is not white space but do contain control structures or invocations of other templates which evaluate to an empty string, will not appear in the output. 
1.  Any newlines in appended strings (no matter they are created with template expressions or not) will be prepended with the current indentation when inserted. 

Although this algorithm sounds a bit complicated at first it behaves very intuitively. In addition the syntax coloring in Eclipse communicates this behavior.

![Syntax Coloring For Templates In Eclipse](images/Xtend_template_coloring.png)

The behavior is best described with a set of examples. The following table assumes a data structure of nested nodes.

|:---|:---|
|

```xtend
class Template {
  def print(Node n) '''
    node «n.name» {}
  '''
}
```

|

```
node NodeName {}
```

|

The indentation before `node «n.name»` will be skipped as it is relative to the opening mark of the template string and thereby not considered to be relevant for the output but only for the readability of the template itself.

|:---|:---|
|

```xtend
class Template {
  def print(Node n) '''
    node «n.name» {
      «IF hasChildren»
        «n.children.map[print]»
      «ENDIF»
    }
  '''
}
```

|

```
node Parent{
  node FirstChild {
  }
  node SecondChild {
    node Leaf {
    }
  }
}
```

|

As in the previous example, there is no indentation on the root level for the same reason. The first nesting level has only one indentation level in the output. This is derived from the indentation of the `IF hasChildren` condition in the template which is nested in the node. The additional nesting of the recursive invocation `children.map[print]` is not visible in the output as it is relative the the surrounding control structure. The line with `IF` and `ENDIF` contain only control structures thus they are skipped in the output. Note the additional indentation of the node *Leaf* which happens due to the first rule: Indentation is propagated to called templates.

---

**[Next Chapter: Active Annotations](204_activeannotations.html)**