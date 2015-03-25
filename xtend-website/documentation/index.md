---
layout: documentation
title: Documentation
part: Xtend User Guide
---

# Introduction {#introduction}

Xtend is a statically-typed programming language which translates to comprehensible Java source code. Syntactically and semantically Xtend has its roots in the Java programming language but improves on many aspects: 

*   **[Extension methods](202_xtend_classes_members.html#extension-methods)** - enhance closed types with new functionality
*   **[Lambda Expressions](203_xtend_expressions.html#lambdas)** - concise syntax for anonymous function literals
*   **[ActiveAnnotations](204_activeannotations.html)** - annotation processing on steroids
*   **[Operator overloading](203_xtend_expressions.html#operators)** - make your libraries even more expressive
*   **[Powerful switch expressions](203_xtend_expressions.html#switch-expression)** - type based switching with implicit casts
*   **[Multiple dispatch](202_xtend_classes_members.html#polymorphic-dispatch)** - a.k.a. polymorphic method invocation
*   **[Template expressions](203_xtend_expressions.html#templates)** - with intelligent white space handling
*   **[No statements](203_xtend_expressions.html)** - everything is an expression
*   **[Properties](203_xtend_expressions.html#property-access)** - shorthands for accessing and defining getters and setter
*   **Type inference** - you rarely need to write down type signatures anymore
*   **Full support for Java generics** - including all conformance and conversion rules
*   **Translates to Java** not bytecode - understand what is going on and use your code for platforms such as Android or GWT

Unlike other JVM languages Xtend has [zero interoperability issues](201_types.html) with Java: Everything you write interacts with Java exactly as expected. At the same time Xtend is much more concise, readable and expressive. Xtend's small library is just a thin layer that provides useful utilities and extensions on top of the Java Development Kit (JDK). 

Of course, you can call Xtend methods from Java, too, in a completely transparent way. Furthermore, Xtend provides a modern Eclipse-based IDE closely integrated with the Eclipse Java Development Tools (JDT), including features like call-hierarchies, rename refactoring, debugging and many more.

---

**[Next Chapter: Hello World](101_gettingstarted.html)**