---
layout: documentation
title: Hello World
part: Getting Started
---

# {{page.title}} {#getting-started}

The first thing you want to see in any language is a *Hello World* example. In Xtend, that reads as 

```xtend
class HelloWorld {
  def static void main(String[] args) {
    println("Hello World")
  }
}
```

You see that Xtend looks quite similar to Java. At a first glance the main difference seems to be the `def` keyword to declare a method. Also like in Java it is mandatory to define a class and a main method as the entry point for an application. Admittedly *Hello World* programs are not a particular strength of Xtend. The real expressiveness is unleashed when you do real things as you will learn in a second.

An Xtend class resides in a plain Eclipse Java project. As soon as the SDK is installed, Eclipse will automatically translate all the classes to Java source code. By default you will find it in a source folder *xtend-gen*. The hello world example is translated to the following Java code: 

```java
// Generated Java Source Code
import org.eclipse.xtext.xbase.lib.InputOutput;

public class HelloWorld {
  public static void main(final String[] args) {
    InputOutput.<String>println("Hello World");
  }
}
```

The only surprising fact in the generated Java code may be the referenced library class [InputOutput]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/InputOutput.java). It is part of the runtime library and a nice utility that is quite handy when used in expressions.

You can put an Xtend class into a source folder of any Java project within Eclipse or any Maven project. If the project is not yet configured properly, Eclipse will complain about the missing library. The xtend.lib has to be on the class path. The IDE will provide a quick fix to add it.

The next thing you might want to do is materializing one of the example projects into your workspace. Right click anywhere in the *Navigator* view in Eclipse and select *New &rarr; Example...*.

In the upcoming dialog you will find two examples for Xtend:

*   *Xtend Introductory Examples* contains a couple of example code snippets illustrating certain aspects and strengths of Xtend. For instance it shows how to build an API which allows to write code like this:     
    
    ```xtend
    assertEquals(42.km/h, (40_000.m + 2.km) / 60.min)
    ```

    The *Movies* example explained in detail [in the next section](102_moviesexample.html) is also included there.
*   *Xtend Solutions For Euler* contains solutions to some of the problems you will find at [Project Euler](http://projecteuler.net/). These examples are leveraging the whole expressive power of Xtend. For instance [Euler Problem 1](http://projecteuler.net/problem=1) can be solved with this expression :     
    
    ```xtend
    (1..999).filter[ i | i % 3 == 0 || i % 5 == 0 ].reduce[ i1, i2 | i1 + i2 ]
    ```

---

**[Next Chapter: The Movies Example](102_moviesexample.html)**