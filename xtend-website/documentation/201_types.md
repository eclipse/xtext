---
layout: documentation
title: Java Interoperability
part: Reference Documentation
---

# {{page.title}} {#types}

Xtend, like Java, is a statically typed language. In fact it completely supports Java's type system, including the primitive types like `int` or `boolean`, arrays and all the Java classes, interfaces, enums and annotations that reside on the class path. 

Java generics are fully supported as well: You can define type parameters on methods and classes and pass type arguments to generic types just as you are used to from Java. The type system and its conformance and casting rules are implemented as defined in [the Java Language Specification](http://docs.oracle.com/javase/specs/jls/se6/html/conversions.html).

Resembling and supporting every aspect of Java's type system ensures that there is no impedance mismatch between Java and Xtend. This means that Xtend and Java are 100% interoperable. There are no exceptional cases and you do not have to think in two worlds. You can invoke Xtend code from Java and vice versa without any surprises or hassles. As a bonus, if you know Java's type system and are familiar with Java's generic types, you already know the most complicated part of Xtend.

The default behavior of the Xtend-to-Java compiler is to generate Java code with the same language version compatibility as specified for the Java compiler in the respective project. This can be changed in the global preferences or in the project properties on the *Xtend &rarr; Compiler* page (since 2.8). Depending on which Java language version is chosen, Xtend might generate different but equivalent code. For example, [lambda expressions](203_xtend_expressions.html#lambdas) are translated to Java lambdas if the compiler is set to Java 8, while for lower Java versions anonymous classes are generated.

## Type Inference {#local-type-inference}

One of the problems with Java is that you are forced to write type signatures over and over again. That is why so many people do not like static typing. But this is in fact not a problem of static typing but simply a problem with Java. Although Xtend is statically typed just like Java, you rarely have to write types down because they can be computed from the context.

Consider the following Java variable declaration:

```java
final LinkedList<String> list = new LinkedList<String>();
```

The type name written for the constructor call must be repeated to declare the variable type. In Xtend the variable type can be inferred from the initialization expression:

```xtend
val list = new LinkedList<String>
```

## Conversion Rules {#conversion-rules}

In addition to Java's autoboxing to convert primitives to their corresponding wrapper types (e.g. `int` is automatically converted to [Integer]({{site.javadoc.java}}/java/lang/Integer.html) when needed), there are additional conversion rules in Xtend.

Arrays are automatically converted to [`List<ComponentType>`]({{site.javadoc.java}}/java/util/List.html) and vice versa. That is you can write the following:

```xtend
def toList(String[] array) {
  val List<String> asList = array
  return asList
}
```

Subsequent changes to the array are reflected by the list and vice versa. Arrays of primitive types are converted to lists of their respective wrapper types.

The conversion works the other way round, too. In fact, all subtypes of [Iterable]({{site.javadoc.java}}/java/lang/Iterable.html) are automatically converted to arrays on demand.

Another very useful conversion applies to lambda expressions. A lambda expression usually is of one of the types declared in [Functions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Functions.java) or [Procedures]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Procedures.java). However, if the expected type is an interface or a class with a single abstract method declaration, a lambda expression is automatically converted to that type. This allows to use lambda expressions with many existing Java libraries. See [Lambda Expression Typing](203_xtend_expressions.html#closure-types) for more details. 

---

**[Next Chapter: Classes and Members](202_xtend_classes_members.html)**