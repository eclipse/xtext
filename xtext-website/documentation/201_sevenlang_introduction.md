---
layout: documentation
title: Introduction to the Seven Languages
part: Seven JVM Languages Built With Xbase
---

# Introduction {#sevenlang-introduction}

Building a domain-specific language (DSL) for structural parts of an application has always been rather easy with Xtext. But structure alone is not sufficient in many cases. When it comes to the behavioral aspects users often fall back to implementing them in Java. The reasons are obvious: expressions and statements are hard to get right and extremely complex and therefore costly to implement.

This document introduces and explains a new API, which allows reusing predefined language constructs such as type references, annotations and fully featured expressions anywhere in your languages. You not only reuse the grammar but the complete implementation including a compiler, interpreter, the whole Java type system and a tight IDE integration. And the best part is, that it is relatively easy to do so. It is actually just two steps:

## Write the Grammar

Using the traditional Xtext grammar language you freely describe the syntax of your language. The specialty for JVM languages is, that you inherit from an abstract grammar org.eclipse.xtext.xbase.Xbase, which predefines the syntax for the reusable parts. You do not need to use all of them directly and you can of course change the syntax or add new concepts, as it seems fit.

## Map to Java

Having the grammar defined, you now need to tell Xtext what your language concepts mean in terms of Java constructs. For that purpose you use a so-called *model inferrer*, a special API that allows you to create any number of Java classes, interfaces or members from your DSL. This hook not only defines how your language is translated to Java, but also defines the scope of the embedded expressions. The expressions from your language 'live' in the context you give them. If you want an expression to have access to certain local variables, just put it into a method with appropriate parameters or use instance fields if they work better.

While in plain Xtext you would usually customize a bunch of further services to fit your needs, Xbase already has JVM model aware implementations almost all of them. For example, a generic code generator generates the Java code directly from the inferred model. The same way, Xbase already integrates your language with JDT to an extend that customizations beyond the JVM model inferrer will only be necessary for very special cases. You can naturally mix Java and DSL code in the same application without any barriers. 

The inferred model also reveals your DSL constructs to other JVM languages. The Java type system is used as a common hub to integrate arbitrary languages with each other. You can for instance call [templates](207_template.html) directly from a [script](202_scripting.html) and vice versa. You do not even need to generate the equivalent Java code; everything is based on the Java types you create in the model inferrer.

To illustrate the power and flexibility of these two abstractions, we have built seven example languages using them:

*   [A simple scripting language](202_scripting.html)
*   [A Grade-like build DSL](203_builddsl.html)
*   [A DSL for statically-typed MongoDB documents](204_mongodb.html)
*   [A Guice modules DSL](205_guice.html)
*   [A Playframework-like HTTP routing language](206_httprouting.html)
*   [A template language](207_template.html)
*   [A Logo-like programming environment for educational purposes](208_tortoise.html)

Each language is very simple and focuses on the value a DSL can add to the respective viewpoint. It is meant to give you an idea of what is possible without being a complete practical solution. Yet the languages are flexible and come with powerful core abstractions. We also covered different technical aspects of customizing to the language infrastructure. Some languages have special syntax coloring, others provide customized outline views or content assist. All aspects of a language are still fully customizable when using Xbase.

## CAUTION: This is Provisional API {#provisional-API}

**Please be aware that some of the new API covered in this document is not yet finalized and will likely be improved in future releases in incompatible ways. Usages of such API are marked with a warning.**

## Common Requirements {#common-requirements}

To run any of the examples, you will need [Eclipse 3.6 or better](http://www.eclipse.org/downloads/) for your platform. In addition, you have to install [Xtend](http://www.eclipse.org/xtend/download.html) and of course [Xtext 2.7 or latter](http://www.eclipse.org/Xtext/download.html).

If you prefer a simple all-inclusive installation, consider downloading the latest [Xtext distribution](http://www.eclipse.org/Xtext/download.html).

Additional requirements are mentioned in the *Running the Example* section of each chapter.

## Getting the Code {#installation}

You can get the source code for all languages from the github repository at [github.com/xtext-dev/seven-languages-xtext](https://github.com/xtext-dev/seven-languages-xtext.git). The repository contains two folders *languages* and *examples*. Download the plug-ins from *languages* into the root workspace and the *examples* into the runtime workspace spawned from the root one using *Run &rarr; Run Configurations... &rarr; Eclipse Application &rarr; Run (\<language\>)*.

Each language consists of several Eclipse projects 

|:---|:---|
|*org.xtext.\<language\>*|The base infrastructure|
|*org.xtext.\<language\>.ui*|The editor based on Eclipse|
|*org.xtext.\<language\>.tests*|Tests for the language|
|*org.xtext.\<language\>.lib*|Runtime library|
|*org.xtext.\<language\>.example*|Examples for using the language|

Some of the languages do not include all of these plug-ins but the general structure is always the same.

## A Short Xtend Primer {#xtend-primer}

Any general code in the examples is implemented in [Xtend](http://www.xtend-lang.org). Xtend is a more expressive and less verbose way to implement Java applications. It is 100% interoperable with Java APIs and compiles to readable Java code. In addition, it uses the same expressions that we use in our example languages. In fact it is built with the very same API that is described in this document. This should give you a taste of how powerful JVM-languages built with Xtext can actually be. 

Xtend is designed to be easy to learn for Java developers. In this section we will shortly describe the most important language features that were used in our examples. For a full description of the Xtend language, please refer to the [Xtend documentation](http://www.xtend-lang.org/documentation). 

Just like a Java file, an Xtend file starts with a `package` declaration and an `import` section followed by one or more class declarations. Semicolons are optional. All types are `public` by default. Xtend classes can extend other classes and implement interfaces just like in Java. It does not make any difference whether they were originally declared in Xtend or in Java.

<a name="xtend_property"/> JavaBean properties can be accessed directly by their name. The access will be automatically mapped to the appropriate accessor method. That means you can write 

```xtend
println(foo.bar)      // instead of println(foo.getBar())
foo.bar = baz         // instead of foo.setBar(baz)
foo.fooBars += foobar // instead of foo.getFooBars().add(foobar)
```

Empty parentheses on method or constructor calls can be skipped.

<a name="xtend_methods"/>

Methods are introduced with the keyword `def` or `override` if they override/implement a super type's method. Methods are public if not specified otherwise. The value of the last expression is returned if no explicit return expression is used and the method's return type is not `void`.

<a name="xtend_variables"/>

Variables are declared with the keywords `val` (final) or `var` (non-final). Field declarations can use the same syntax as in Java.

<a name="xtend_typeinferrence"/>

Xtend is statically typed, but you do not have to specify the type in a declaration if it can be inferred from the context: 

```xtend
val x = newArrayList('foo', 'bar', 'baz') // x is of type List<String>
def foo() {  // equivalent to  def int foo()...
  1
}
```

<a name="xtend_extension"/> The methods of fields marked as `extension` are callable in extension syntax. That means, you can put the first argument in front as if it were the receiver of the call, e.g. 

```xtend
// assume the class Foo defines a method foo(Baz)
extension Foo theFoo

def bar(Baz baz) {
  baz.foo  // calls theFoo.foo(baz)
}
```

Static methods can be put on the extension scope with a `static extension` import, e.g. 

```xtend
import static extension java.util.Collections.*
...
val foo = singleton('foo') // calls Collections.<String>singleton('foo')
```

<a name="xtend_it"/> In addition to Java's `this`, you can define another implicit receiver variable named `it`. As with `this`, you can omit `it` in feature calls, i.e. 

```xtend
class Foo {
  def foo(Bar it) {
    foo // will call it.foo() or if that doesn't exist this.foo()
  }
}
```

<a name="xtend_lambda"/> Xtend provides lambda expressions. These are anonymous functions in square brackets. 

```xtend
[String foo, String bar | foo + bar]  
  // a function (String foo, String bar) { foo + bar }
```

<a name="xtend_lambda_coercion"/> As this is a bit bulky, there are more rules to make working with lambdas more attractive: 

1.  When a lambda expression is the last argument in a method call, it can be put behind the closing parentheses.
1.  Lambdas are automatically coerced to interfaces with a single function. Parameter types will be inferred.
1.  If you skip the declaration of the only parameter, it will be implicitly called `it`.

```xtend
new Thread [ println("Hello concurrent world") ] 
  // lambda will be coerced to a java.lang.Runnable
val list = #['fooooo', 'fo', 'foo']  // #[] delimits a list literal
list.sortBy[ length ]   
  // lambda is coerced to a function (String)=>Comparable
  // equivalent to list.sortBy[String it | it.length]
```

<a name="xtend_templates"/> Also noteworthy is the template expression, which allows defining interpolated multi-line string literals. In addition, the template expressions has intelligent whitespace handling and supports a special `FOR` and `IF` construct, which is far better readable in this context. In model inferrers, the template expressions are enhanced further to support type literals, automatically adding an import to the generated Java file.

We most often use this expression in the examples to generate some synthetic Java boilerplate code. Here is an example from the [http routing language](206_httprouting.html):

```xtend
'''
  String url =  request.getRequestURL().toString();
  «FOR route : routes»
    {
      //java.util.regex.Matcher will be imported in the generated Java file
      «Matcher» _matcher = _pattern«route.index».matcher(url);
      if (_matcher.find()) {
        «FOR variable : route.url.variables»
            String «variable.name» = _matcher.group(«variable.index + 1»);
        «ENDFOR»
        «IF route.condition != null»
          if («route.nameOfRouteMethod»Condition(request, response
            «FOR v : route.url.variables 
             BEFORE ", " 
             SEPARATOR ", "»«v.name»«ENDFOR»))
        «ENDIF»
        «route.nameOfRouteMethod»(request, response
          «FOR v : route.url.variables», «v.name»«ENDFOR»);
      }
    }
  «ENDFOR»
'''
```

---

**[Next Chapter: Scripting Language](202_scripting.html)**
