---
layout: documentation
title: Classes and Members
part: Reference Documentation
---

# {{page.title}} {#xtend-classes-members}

At a first glance an Xtend file pretty much looks like a Java file. It starts with a package declaration followed by an import section and class definitions. The classes in fact are directly translated to Java classes in the corresponding Java package. A class can have constructors, fields, methods and annotations. 

Here is an examplary Xtend file: 

```xtend
package com.acme

import java.util.List

class MyClass {
  String name
  
  new(String name) {
    this.name = name
  }
  
  def String first(List<String> elements) {
    elements.get(0)
  }
}
```

## Package Declaration {#package-decl}

Package declarations can look like those in Java. Two small, optional differences: 

*   An identifier can be escaped with a `^` character in case it conflicts with a keyword.
*   The terminating semicolon is optional.

```xtend
  package com.acme
```

## Imports {#imports}

The ordinary imports of type names are equivalent to the imports known from Java. Again one can escape any names conflicting with keywords using a `^`. In contrast to Java, the terminating semicolon is optional. Non-static wildcard type imports are deprecated for the benefit of better usability and well defined dependencies. 

Xtend also features static imports for importing static fields and methods. The semantics and syntax are just like in Java. 

As in Java all classes from the `java.lang` package are implicitly imported. 

```xtend
import java.math.BigDecimal
import static java.util.Collections.sort
import static org.junit.Assert.*
```

Static methods can also be imported as `extension`s. See the section on [extension methods](202_xtend_classes_members.html#extension-methods) for details.

## Class Declaration {#xtend-class-declaration}

The class declaration reuses a lot of Java's syntax but still is a bit different in some aspects: All Xtend types are `public` by default since that's the common case. Java's "package private" default visibility is declared by the more explicit keyword `package` in Xtend. In contrast to Java, Xtend supports multiple public top level class declarations per file. Each Xtend class is compiled to a separate top-level Java class.

Abstract classes are defined using the `abstract` modifier as in Java. See also [abstract methods](202_xtend_classes_members.html#abstract-methods).

Xtend's approach to inheritance is conceptually the same as in Java. Single inheritance of classes as well as implementing multiple interfaces is supported. Xtend classes can extend other Xtend classes, and even Java classes can inherit from Xtend classes. If no super type is specified, [Object]({{site.javadoc.java}}/java/lang/Object.html) is used. 

The most simple class looks like this: 

```xtend
class MyClass {
}
```

A more advanced generic class declaration in Xtend: 

```xtend
class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, 
                   Cloneable, java.io.Serializable {
  ...
}
```

## Constructors {#constructors}

An Xtend class can define any number of constructors. Unlike Java you do not have to repeat the name of the class over and over again, but use the keyword `new` to declare a constructor. Constructors can also delegate to other constructors using `this(args...)` in their first line. 

```xtend
class MyClass extends AnotherClass {
  new(String s) {
    super(s)
  }
  
  new() {
    this("default")
  }
}
```

The same rules with regard to inheritance apply as in Java, i.e. if the super class does not define a no-argument constructor, you have to explicitly call one using `super(args...)` as the first expression in the body of the constructor.

The default visibility of constructors is `public` but you can also specify an explicit visiblity `public`, `protected`, `package` or `private`.

## Fields {#fields}

A field can have an initializer. Final fields are declared using `val`, while `var` introduces a non-final field and can be omitted. Yet, if an initializer expression is present, the type of a field can be inferred if `val` or `var` was used to introduce the field. The keyword `final` is synonym to `val`. Fields marked as `static` will be compiled to static Java fields. 

```xtend
class MyClass {
  int count = 1
  static boolean debug = false
  var name = 'Foo'          // type String is inferred 
  val UNIVERSAL_ANSWER = 42 // final field with inferred type int
  ...
}
```

The default visibility for fields is `private`. You can also declare it explicitly as being `public`, `protected`, `package` or `private`. 

A specialty of Xtend are fields that provide *extension methods* which are covered in [their own section](202_xtend_classes_members.html#extension-methods).

## Methods {#methods}

Xtend methods are declared within a class and are translated to a corresponding Java method with exactly the same signature. The only exceptions are dispatch methods, which are explained [later](202_xtend_classes_members.html#polymorphic-dispatch).

```xtend
def String first(List<String> elements) {
  elements.get(0)
}
```

Method declarations start with the keyword `def`. The default visibility of a method is `public`. You can explicitly declare it as being `public`, `protected`, `package` or `private`.

Xtend supports the `static` modifier for methods and can [infer](202_xtend_classes_members.html#inferred-return-types) the return type if it is not explicitly given: 

```xtend
def static createInstance() {
  new MyClass('foo')
}
```

As in Java, vararg parameters are allowed and accessible as array values in the method body: 

```xtend
def printAll(String... strings) {
  strings.forEach[ s | println(s) ]
}
```

It is possible to infer the return type of a method from its body. Recursive methods and abstract methods have to declare an explicit return type.

### Abstract Methods {#abstract-methods}

An abstract method in Xtend does not define a body and must be declared within an `abstract` class or an interface. Also specifying the return type is mandatory since it cannot be inferred. 

```xtend
abstract class MyAbstractClass() {
  def String abstractMethod() // no body
}
```

### Overriding Methods

Methods can override other methods from the super class or implement interface methods using the keyword `override`. If a method overrides a method from a super type, the `override` keyword is mandatory and replaces the keyword `def`. The override semantics are the same as in Java, e.g. it is impossible to override `final` methods or invisible methods. Overriding methods inherit their return type from the super declaration.

Example: 

```xtend
override String second(List<String> elements) {
  elements.get(1)
}
```

### Declared Exceptions {#declared-exceptions}

Xtend does not force you to catch or declare checked exceptions. Nevertheless, you can still declare the exceptions thrown in a method's body using the `throws` clause as in Java.

If you do not declare checked exceptions in your method but they are possibly thrown in your code, the compiler will throw the checked exception silently (using the sneaky-throw technique introduced by [Lombok](http://projectlombok.org/features/SneakyThrows.html)). 

```xtend
/*
 * throws an Exception
 */
def void throwException() throws Exception {
   throw new Exception
}

/*
 * throws an Exception without declaring it
 */
def void sneakyThrowException() {
   throw new Exception
}
```

Optional validation of checked exception is supported, too, and can be configured on the respective Eclipse preference page for the Xtend Errors and Warnings.

### Inferred Return Types {#inferred-return-types}

If the return type of a method can be inferred from its body it does not have to be declared.

That is the method 

```xtend
def String second(List<String> elements) {
  elements.get(1)
}
```

could be declared like this: 

```xtend
def second(List<String> elements) {
  elements.get(1)
}
```

The return type is mandatory for abstract method declarations as well as for recursive implementations.

### Generic Methods {#generic-methods}

You can specify type parameters on methods. A parameterized variant of the method from the previous section, could look like this:

```xtend
def <T> second(List<T> elements) {
  elements.get(1)
}
```

Type parameter bounds and constraints are supported and share the same syntax and semantics as defined in the [the Java Language Specification](http://docs.oracle.com/javase/specs/jls/se6/html/classes.html#8.4.4).

### Operator Declarations {#operator-declaration}

Xtend supports operator overloading based on an operator-name-mapping as explained in the [section on operators](203_xtend_expressions.html#operators). To declare an operator one can either declare a simple method using the operator's name or by using the operator directly like in the following:

```xtend
class Money {
	def + (Money other) { ... }
	def - (Money other) { ... }
	def * (BigDecimal times) { ... }
	...
}
```

### Dispatch Methods {#polymorphic-dispatch}

Generally, method resolution and binding is done statically at compile time as in Java. Method calls are bound based on the static types of arguments. Sometimes this is not what you want. Especially in the context of [extension methods](202_xtend_classes_members.html#extension-methods) you would like to have polymorphic behavior.

A dispatch method is declared using the keyword `dispatch`. 

```xtend
def dispatch printType(Number x) { 
  "it's a number" 
}

def dispatch printType(Integer x) { 
  "it's an int" 
}
```

For a set of visible dispatch methods in the current type hierarchy with the same name and the same number of arguments, the compiler infers a synthetic dispatcher method. This dispatcher uses the common super type of all declared arguments. The method name of the actual dispatch cases is prepended with an underscore and the visibility of these methods is reduced to protected if they have been defined as public methods. Client code always binds to the synthesized dispatcher method.

For the two dispatch methods in the example above the following Java code would be generated: 

```java
protected String _printType(final Number x) {
  return "it\'s a number";
}

protected String _printType(final Integer x) {
  return "it\'s an int";
}

public String printType(final Number x) {
  if (x instanceof Integer) {
    return _printType((Integer)x);
  } else if (x != null) {
    return _printType(x);
  } else {
    throw new IllegalArgumentException("Unhandled parameter types: " +
      Arrays.<Object>asList(x).toString());
  }
}
```

Note that the `instanceof` cascade is ordered such that more specific types are handled first.

The default visibility of the dispatch cases is `protected`. If all dispatch methods explicitly declare the same visibility, this will be the visibility of the inferred dispatcher, too. Otherwise it is `public`. The comparison of the parameter types is performed from left to right. That is in the following example, the second method declaration is considered more specific since its first parameter type is the most specific:

```xtend
def dispatch printTypes(Number x, Integer y) { 
  "it's some number and an int" 
}

def dispatch printTypes(Integer x, Number y) { 
  "it's an int and a number" 
}
```

generates the following Java code : 

```java
public String printTypes(final Number x, final Number y) {
  if (x instanceof Integer
       && y != null) {
    return _printTypes((Integer)x, y);
  } else if (x != null
       && y instanceof Integer) {
    return _printTypes(x, (Integer)y);
  } else {
    throw new IllegalArgumentException("Unhandled parameter types: " +
      Arrays.<Object>asList(x, y).toString());
  }
}
```

The code is compiled in a way that a `null` reference is never a match. `null` values can be handled by dispatch cases that use the parameter type [Void]({{site.javadoc.java}}/java/lang/Void.html). 

```xtend
def dispatch printType(Number x) { 
  "it's some number" 
}

def dispatch printType(Integer x) { 
  "it's an int" 
}

def dispatch printType(Void x) { 
  "it's null" 
}
```

This compiles to the following Java code: 

```java
public String printType(final Number x) {
  if (x instanceof Integer) {
    return _printType((Integer)x);
  } else if (x != null) {
    return _printType(x);
  } else if (x == null) {
    return _printType((Void)null);
  } else {
    throw new IllegalArgumentException("Unhandled parameter types: " +
      Arrays.<Object>asList(x).toString());
  }
}
```

#### Dispatch Methods and Inheritance

All visible Java methods from all super types that are conformant to the compiled representation of a dispatch method are also included in the dispatcher. Conforming means they have the expected number of arguments and have the same compiled name with the prepended underscore.

For example, consider the following Java class : 

```java
public abstract class AbstractLabelProvider {
   protected String _label(Object o) {
      // some generic implementation
   }
}
```

and the following Xtend class which extends the Java class : 

```xtend
class MyLabelProvider extends AbstractLabelProvider {
   def dispatch label(Entity it)  {
     name
   }
     
   def dispatch label(Method it) { 
     name+"("+params.join(",")+"):"+type
   }
   
   def dispatch label(Field it) { 
     name+type
   }
}
```

The resulting dispatch method in the generated Java class `MyLabelProvider` would then look like this: 

```java
public String label(final Object it) {
  if (it instanceof Entity) {
    return _label((Entity)it);
  } else if (it instanceof Field) {
    return _label((Field)it);
  } else if (it instanceof Method) {
    return _label((Method)it);
  } else if (it != null) {
    return super._label(it);
  } else {
    throw new IllegalArgumentException("Unhandled parameter types: " +
      Arrays.<Object>asList(it).toString());
  }
}
```

#### Static Dispatch Methods

Also static dispatch methods are supported. A mixture of static and non-static dispatch methods is prohibited.

### Create Methods {#create-methods}

Create methods in Xtend allow to do graph transformation in one pass where it usually needs two passes. That means you don't need to separate a translation from one graph to another in the typical two phases: tree construction and interlinking the tree nodes. You basically just need to write the whole transformation using create methods and the built-in identity preservation will take care of the rest.

Consider you want to create a copy of the following list of persons into a :

```
Fred Flintstone {
	marriedTo Willma Flintstone
	friendWith Barny Rubble
}
Willma Flintstone {
	marriedTo Fred Flintstone
}
Barny Rubble {
	friendWith Fred Flintstone
}
```

A function like the following could do the trick :

```xtend
def List<Person> copyPersons(List<Person> persons) {
	persons.map[copy]
}
def copy(Person p) {
	val result = new Person()
	result.name = p.name
	// The following is wrong and results in a stack overflow
	result.friendWith = p.friendWith.map[copy]   
	result.marriedWith = p.marriedWith.map[copy]
}
```

The problem with that code is that we don't track the origins of the created copies. This is the main problem with model transformations. The classic solution is to run the copying in two passes. First we create all instances and then we establish the links. Although it works it results in cluttered and non coherent code. Xtend's create functions handle this problem by introducing identity perservation by tracking the origin of each created instance. Therefore, a create function takes two expressions. One to instantiate the actual object and a second one to initialize it. 

```xtend
def create result: new Person copy(Person p) {
	result.name = p.name
	// now it works	
	result.friendWith = p.friendWith.map[copy]   
	result.marriedWith = p.marriedWith.map[copy]
}	
```

If you do not specify the name of the result variable it is assumed to be the implicit receiver variable `it`, which can be skipped in feature calls inside the body. Furthermore, you can define the return type of a create function:

```xtend
def Person create new PersonImpl() copy(Person p) {
	/* it.*/name = p.name
	friendWith = p.friendWith.map[copy]   
	marriedWith = p.marriedWith.map[copy] 
}	
```

#### How it works

In addition to the keyword `create` one specifies two expressions. The first expression is the factory to create an instance while the second will initialize it further. Prior to invoking the factory expression, a cache lookup is performed to find a previously created instance for the very same arguments. If there is no such instance, the factory expression is evaluated and the result is stored in the cache. Subsequently the main expression (also called the initializer expression) is evaluated. This happens only if there was no previously created instance available in the cache. If that expression in turn calls the create function transitively using the same set of arguments the previously instantiated and cached object is returned. Note that the object is probably currently initialized. That is, its internal state may not yet be available. The lifecycle of the cache is attached to the instance of the declaring Xtend class. That is you can control how long the cache lives by means of Guice.

---

## Annotations {#annotations}

Annotations are available on classes, fields, methods and parameters. They are prefixed with the `@` character and accept a number of key-value pairs or a default value for the annotation property named `value`. Annotation values that expect arrays can handle single values, too. Value arrays are enclosed in array literals `#['first', 'second']`. The semantics for annotations are exactly like defined in the [Java Language Specification](http://docs.oracle.com/javase/specs/jls/se6/html/interfaces.html#9.7). Here is an example:

```xtend
@TypeAnnotation("some value")
class MyClass {
  @FieldAnnotation(value = @NestedAnnotation(true))
  static val CONSTANT = 'a compile-time constant'
  
  @MethodAnnotation(constant = CONSTANT)
  def String myMethod(@ParameterAnnotation String param) {
    //...
  }
}
```

In addition [Active Annotations](204_activeannotations.html) allow users to participate in compilation of Xtend code to Java source code.

## Extension Methods {#extension-methods}

Extension methods allow to add new methods to existing types without modifying them. This feature is actually where Xtend got its name from. They are based on a simple syntactic trick: Instead of passing the first argument of an extension method inside the parentheses of a method invocation, the method can be called with the first argument as its receiver - it can be called as if the method was one of the argument type's members. 

```xtend
"hello".toFirstUpper() // calls StringExtensions.toFirstUpper("hello")
```

Method calls in extension syntax often result in more readable code, as they are chained rather than nested. Another benefit of extensions is that you can add methods which are specific to a certain context or layer of your application.

For instance, you might not want to put UI-specific methods and dependencies into your domain model classes. Therefore this functionality is often defined in static methods or methods in utility classes or service layers. That works, but the code is less readable and less object-oriented if you call methods like this. In Java you often see code like this:

```java
persistenceManager.save(myObject);
```

Without tying your entities to the persistenceManager, extension methods allow you to write

```xtend
myObject.save
```

There are different ways to make methods available as extensions, which are described in the following sections.

### Extensions from the Library {#library-extensions}

The Xtend library puts a lot of very useful extension methods on existing types from the Java SDK without any further ado.

```xtend
"hello".toFirstUpper // calls StringExtensions.toFirstUpper(String)
listOfStrings.map[ toUpperCase ] // calls ListExtensions.<T, R>map(List<T> list, Function<? super T, ? extends R> mapFunction)
```

Have a look at the JavaDoc to learn about the available functionality:

*   [ObjectExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/ObjectExtensions.java)
*   [IterableExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/IterableExtensions.java)
*   [MapExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/MapExtensions.java)
*   [ListExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/ListExtensions.java)
*   [CollectionExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/CollectionExtensions.java)
*   [BooleanExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/BooleanExtensions.java)
*   [IntegerExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/IntegerExtensions.java)
*   [FunctionExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/FunctionExtensions.java)

### Local Extension Methods

All visible non-static methods of the current class and its super types are automatically available as extensions. For example 

```xtend
class MyClass {
  def doSomething(Object obj) {
    // do something with obj
  }
  
  def extensionCall(Object obj) {
    obj.doSomething()  // calls this.doSomething(obj)
  }
}
```

Local static methods have to be made available through an import like any other static method.

### Extension Imports {#extension-imports}

In Java, you would usually write a helper class with static methods to decorate an existing class with additional behavior. In order to integrate such static helper classes, Xtend allows to put the keyword `extension` after the `static` keyword of a [static import](202_xtend_classes_members.html#imports) thus making all imported static functions available as extensions methods.

The following import declaration 

```xtend
import static extension java.util.Collections.singletonList
```

allows us to use singletonList methods like this: 

```xtend
new MyClass().singletonList() 
// calls Collections.singletonList(new MyClass())
```

### Extension Provider {#extension-provider}

By adding the `extension` keyword to a field, a local variable or a parameter declaration, its instance methods become extension methods.

Imagine you want to have some layer specific functionality on a class `Person`. Let us say you are in a servlet-like class and want to persist a `Person` using some persistence mechanism. Let us assume `Person` implements a common interface `Entity`. You could have the following interface 

```java
interface EntityPersistence {
  public save(Entity e);
  public update(Entity e);
  public delete(Entity e);
}
```

And if you have obtained an instance of that type (through a factory or dependency injection or what ever) like this: 

```xtend
class MyServlet {
  extension EntityPersistence ep = Factory.get(EntityPersistence)
  ...
  
}
```

You are able to save, update and delete any entity like this:

```xtend
val Person person = ...
person.save  // calls ep.save(person)
person.name = 'Horst'
person.update  // calls ep.update(person)
person.delete  // calls ep.delete(person)
```

Using the `extension` modifier on values has a significant advantage over static [extension imports](202_xtend_classes_members.html#extension-imports): Your code is not bound to the actual implementation of the extension method. You can simply exchange the component that provides the referenced extension with another implementation from outside, by providing a different instance.

## Interface Declarations {#interfaces}

An interface declaration is very similar to the one in Java. An interface can declare fields, which are by default final static therefore must have an initial value. And of course methods can be declared, which are public by default. Interfaces can extend any number of other interfaces and can declare type parameters. Here's an example: 

```xtend
interface MyInterface<T> extends OtherInterface {
  val CONSTANT = 42
  def T doStuff(String ... varArg) throws SomeException
}
```

Since version 8 of the Java language, interfaces are allowed to contain non-abstract instance methods, called [default methods](http://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html), as well as static methods. This is also supported in Xtend (since 2.8): if Java 8 is selected as target language version, interfaces are allowed to declare methods with bodies like in the following example. 

```xtend
interface MyInterface {
  def doStuff() {
      'This is an instance method returning a string.'
  }
  static def doGlobalStuff() {
      'This is a static method returning a string.'
  }
}
```

The behavior of non-abstract instance methods is equivalent to that of Java default methods. Since interfaces can extend multiple other interfaces, multiple-inheritance conflicts can occur when different implementations of a method are inherited: 

```xtend
interface A {
    def execute() {
        return 1
    }
}

interface B {
    def execute() {
        return 2
    }
}

interface C extends A, B {
}

class D implements A, B {
}
```

The interface `C` and the class `D` are both marked with an error due to the multiple inheritance of the method `execute()`. There are four ways to resolve the problem. 

*   Redeclare the method as abstract (not allowed for non-abstract classes):     
    
    ```xtend
    override execute()
    ```

*   Override the implementation:     
    
    ```xtend
    override execute() {
        return 3
    }
    ```

*   Refer to a supertype implementation:     
    
    ```xtend
    override execute() {
        A.super.execute()
    }
    ```

*   Avoid the inheritance of multiple method implementations in the first place. This is the recommended approach.

## Annotation Type Declarations {#annotation-type-declaration}

Annotation types can also be declared. The are introduced by the keyword `annotation` and declare their values with a concise syntax:

```xtend
annotation MyAnnotation {
  String[] value
  boolean isTricky = false
  int[] lotteryNumbers = #[ 42, 137 ]
}
```

## Enum Type Declarations {#enum-type-declaration}

Enumeration types are declared like this:

```xtend
enum MyColor {
  GREEN,
  BLUE,
  RED
}
```

## Nested Type Declarations {#nested-type-declarations}

Classes, enum, annotation and interface declarations can be nested. Just as in Java nested enums, annotations and interfaces are always static. In Xtend nested classes are also always static. Nested types are public by default and can only be nested within a class, an interface or an annotation declaration.

```xtend
class MyClass {
  static class NestedClass {}
  annotation NestedAnnotation {}
  enum NestedEnum {}
  interface NestedInterface {}
}

interface MyInterface {
  static class NestedClass {}
  annotation NestedAnnotation {}
  enum NestedEnum {}
  interface NestedInterface {}
}

annotation MyAnnotation {
  static class NestedClass {}
  annotation NestedAnnotation {}
  enum NestedEnum {}
  interface NestedInterface {}
}
```

---

**[Next Chapter: Expressions](203_xtend_expressions.html)**