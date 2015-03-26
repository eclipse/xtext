---
layout: documentation
title: DSL for Guice
part: Seven JVM Languages Built With Xbase
---

# {{page.title}} {#guice}

The Guice DSL is a little language that lets you define Guice modules in a readable and declarative way. 

![](images/guicemodules_screenshot.png)

## Overview {#guice-solution}

Guice is a great dependency injection container, which uses Java types and annotations to declare and refer to injection points. You could for instance have the following field:

```java
@Inject
@Named("properties") Map<String,String> properties;
```

A module is used to tell the framework what instance to inject into such injection points. For that, Guice comes with a fluent interface API written in Java and a couple of tricks (e.g. *TypeLiteral*) to make the configuration as readable and maintainable as possible.

You could for instance declare the following module:

```java
public class MyModule implements Module {
  @Override
  public void configure(Binder binder) {
    Map<String,String> properties = Maps.newHashMap();
    properties.put("debugLevel", "info");
    
    binder.bind(new TypeLiteral<Map<String,String>>(){})
      .annotatedWith(Names.named("properties"))
      .toInstance(properties);
  }
}
```

The big advantage of using Java over an external text or XML file is that you can leverage the IDE and the type checking. We want to have that. The downside is that you have to trick (i.e. *TypeLiteral*) a lot in order to have an agreeable syntax. Also since the configuration is 'hidden' in a method implementation and not really declarative you cannot validate a Guice module at compile time.

The Guice DSL described in this section lets you describe the module above like this:

```guice
  MyModule {
    @Named("properties") Map<String,String> 
      to-instance newHashMap('debugLevel' -> 'info')
  }
```

This not only uses the exact same syntax one uses in any injection points, but also opens up all kinds of possibilities for static analysis. Usually the instantiation of a Guice injector at runtime takes quite some time, because then all the very helpful validation is done. A language like the one described in this section could do all theses analysis at compile time, that way speeding up start up of the whole application significantly. 

## Running the Example {#guice-running}

In the example located in the project *org.xtext.guicemodules.examples* two modules are declared, one for a possible runtime scenario and one for a test scenario (yes, you sometimes want a module for tests).

```guice
import com.acme.*
import com.acme.impl.*

com.acme.RuntimeModule {
  bind DataProvider to FileDataProvider
  bind @DataFile String to-instance 'my-data.txt'
}

com.acme.TestModule mixin RuntimeModule {
  bind DataProvider to-instance ['dummy-data' ]
  bind LoggingService to BufferedLoggingService
}
```

You can see the two modules in action by running `com.acme.Main` from the context menu as a *Java application* or as a *JUnit test*. 

## Grammar {#guice-grammar}

The grammar is less than 30 lines long. It allows declaring any number of imports using the import mechanism already described for the [scripting language](202_scripting.html#scripting-grammar). A module can 'mixin' any number of other modules, which allows to reuse existing modules but override keys with different bindings. The mixin feature is described as a cross reference to another `ModuleAST`. Cross references are covered in detail in the respective [documentation section](301_grammarlanguage.html#cross-references).

The language allows binding keys to other keys and to instances. Other concepts like binding to providers is something you could do, but would not help in getting the idea across. Everybody is encouraged to fork this first prototype and build something really useful ;-)

Instead of extending `org.eclipse.xtext.xbase.Xbase`, the grammar `org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations` is extended, which adds full support for annotations. You just have to refer to the rule `XAnnotation` as it is done in the rule `KeyAST`. Btw. it is sometimes a good idea to suffix (or prefix) the AST node types to avoid confusion when working with a library where concepts are named similarly.

```xtext
grammar org.xtext.guicemodules.GuiceModules 
   with org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations
 
import "http://www.eclipse.org/xtext/common/JavaVMTypes" as types
generate guiceModules "http://www.xtext.org/guicemodules/GuiceModules"
  
ModulesAST :
	importSection=XImportSection?
	modules+=ModuleAST*;

ModuleAST :
	name=QualifiedName ('mixin' mixins+=[ModuleAST|QualifiedName] 
	  (',' mixins+=[ModuleAST|QualifiedName])*)? 
	'{'
		bindings+=BindingAST*
	'}'
;

BindingAST:
	'bind' from=KeyAST 
	('to' to=KeyAST | 'to-instance' toInstance=XExpression)?;

KeyAST:
	annotation=XAnnotation? type=JvmTypeReference;

```

## Translation to Java {#guice-inferrer}

A module is mapped to a single java class. The 'mixin' modules are not translated to Java inheritance but to a delegation approach. Here is how a simple module declaration with a single mixed-in module is translated.

*   DSL:
    
    ```guice
    MyModule mixin OtherModule { 
    }
    ```
*   Java:
    
    ```java
    public class MyModule implements Module {
    
      private OtherModule otherModule = new OtherModule();
    
      public void configure(final Binder binder) {
        configure(binder, new HashSet<com.google.inject.Key<?>>());
      }
    
      public void configure(final Binder bind, 
          final Set<Key<? extends Object>> usedKeys) {
        try {
          testModule.configure(bind, usedKeys);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }
    ```

As you can see, the language simply leverages the nice `equals`/`hashCode` implementation of Guice's [Key]({{site.javadoc.guice}}/com/google/inject/Key.html) to implement the override semantics of mixed-in modules.

The corresponding parts in [GuiceModulesJvmModelInferrer]({{site.src.sevenlang}}/languages/org.xtext.guicemodules/src/org/xtext/guicemodules/jvmmodel/GuiceModulesJvmModelInferrer.xtend) are:

```xtend
accept(module.toClass(module.fullyQualifiedName))[
...      
  // declare a field for each mixed-in module
  for (mixin : module.mixins) {
    if (!mixin.eIsProxy)
      members += mixin.toField( mixin.simpleName, 
        typeRef(mixin.fullyQualifiedName.toString)) [
        initializer = '''new «mixin.name»()'''
      ]
  }
  
  // and later when declaring the configure method
  members+= module.toMethod("configure", typeRef(void)) [
    documentation = 'Registers bindings for keys not present in ...'
    parameters += module.toParameter("bind", typeRef(Binder))
    parameters += module.toParameter("usedKeys", typeRef(Set, typeRef(Key, wildcard)))
    body = '''
      try {
        ...some other code
        «FOR mix : module.mixins»
          «mix.simpleName».configure(bind, usedKeys);
        «ENDFOR»
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    '''
  ]
```

Expressions are used in `to-instance` bindings and as always they need a proper scope to live in. The simplest way is to declare a private method for each expression.

```xtend
for (binding : module.bindings) {
  // if it's a toInstance binding, create a synthetic
  // method to give the expression a proper scope
  if (binding.toInstance != null) {
    members += binding.toMethod(binding.syntheticToInstanceName, 
        binding.from.type) [
      visibility = JvmVisibility.PRIVATE
      body = binding.toInstance
    ]
  } 
...
```

In order to obtain instances of annotations as required by Guice's [Binder]({{site.javadoc.guice}}/com/google/inject/Binder.html), we declare dummy fields for annotated types and use reflection to get corresponding instances.

*   DSL:
    
    ```guice
    com.acme.RuntimeModule {
      bind @DataFile String to-instance 'my-data.txt'
    }
    ```
*   Java:
    
    ```java
    // declaration of dummy field with annotation
    @DataFile
    private String _from0;
      
    // and later the following code is used to get the key
      Key<java.lang.String> key = 
          Key.get(new TypeLiteral<String>(){}, 
              getClass().getDeclaredField("_from0").getAnnotations()[0]);
    ```

The two sections in the model inferrer responsible for this are:

```xtend
for (binding : module.bindings) {
...
  // if a key has an annotation, declare a field so we can use that 
  // annotation via reflection later.
  if (binding.to?.annotation != null) {
    members += binding.toField(binding.to.syntheticName, binding.to.type) [
      addAnnotation(binding.to.annotation)
      visibility = JvmVisibility.PRIVATE
    ]
  }
  if (binding.from.annotation != null) {
    members += binding.toField(binding.from.syntheticName, 
        binding.from.type) [
      addAnnotation(binding.from.annotation)
      visibility = JvmVisibility.PRIVATE
    ]
  }
}

// and the following method
def guiceKey(KeyAST it) '''
  Key.get(new TypeLiteral<«type>(){}«
  IF annotation != null
  », getClass().getDeclaredField("«syntheticName»").getAnnotations()[0]«
  ENDIF»)'''
```

That is basically it. The rest should hopefully be self-explanatory.

## Validation {#guice-validation}

One of the sweet spots for a Guice modules DSL is the ability to do a lot of the validation usually done at runtime during compile time. Since this is just an example it just scratches the surface. There is just a single compiler check validating whether any used annotation is itself annotated with `BindingAnnotation`.

This is the relevant code from [GuiceModulesValidator]({{site.src.sevenlang}}/languages/org.xtext.guicemodules/src/org/xtext/guicemodules/validation/GuiceModulesValidator.xtend):

```xtend
  @Check def checkAnnotationIsBindingAnnotation(XAnnotation it) {
    switch type : annotationType {
      JvmAnnotationType: 
        if(!type.annotations.exists[ 
            annotation.is(BindingAnnotation) 
           ])
		  error("The annotation is not annotated with @BindingAnnotation", 
		  XANNOTATION__ANNOTATION_TYPE)
    }
  }
```

It would be really cool to leverage the full information, which is available and analyze the dependencies transitively so you get feedback while you type for any unfulfilled dependencies. Also using all the information to compile a ready to use [Injector]({{site.javadoc.guice}}/com/google/inject/Injector.html) instead of a module seems interesting. 

---

**[Next Chapter: Http Routing Language](206_httprouting.html)**