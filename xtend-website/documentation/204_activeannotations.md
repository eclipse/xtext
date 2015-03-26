---
layout: documentation
title: Active Annotations
part: Reference Documentation
---

# {{page.title}} {#active-annotations}

*Active annotations* allow developers to participate in the translation process of Xtend source code to Java code via library. That's useful in cases where Java requires to write a lot of boilerplate manually. For instance, many of the good old design patterns fall into this category. With *active annotations* you no longer need to remember how the [Visitor](http://en.wikipedia.org/wiki/Visitor_pattern) or the [Observer](http://en.wikipedia.org/wiki/Observer_pattern) pattern should be implemented. In Xtend you can implement the expansion of such patterns in a library and let the compiler do the heavy lifting for you.

An *active annotation* is just an annotation declared either in Java or Xtend, which is itself annotated with [Active]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/Active.java). `@Active` takes a type literal as a parameter pointing to the processor.

The IDE plugin comes with an example project, which you can easily materialize into your workspace. To do so use the new project wizard and in the category *Xtend Examples* choose the active annotation example. The examples contain three different annotations which we will use for further explanation.

For instance, `@Extract` is an annotation which extracts an interface for a class. The annotation declaration looks like this:

```xtend
@Active(ExtractProcessor)
annotation Extract {}
```

## Annotation Processor {#active-annotations-processor}

A processor class must implement one or more of the lifecycle call-back interfaces provided by the compiler. This interfaces are: 

*   [RegisterGlobalsParticipant]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/RegisterGlobalsParticipant.java) The first call back. Only called to register type names when a global symbol table (i.e. index) is created. See [Phase 1](204_activeannotations.html#active-annotations-register-globals).
*   [TransformationParticipant]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/TransformationParticipant.java) This callback is often the most useful, as it allows to alter the translated Java structure by e.g. adding, removing or altering members See [Phase 2](204_activeannotations.html#active-annotations-transformation-phase).
*   [ValidationParticipant]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/ValidationParticipant.java) Although you can already do validation during transformation, you are only during this callback allowed to fully resolve any types. See [Phase 3](204_activeannotations.html#active-annotations-validation-phase).
*   [CodeGenerationParticipant]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/CodeGenerationParticipant.java) If you want to generate some additional text, e.g. XML, this hook is for you. See [Phase 4](204_activeannotations.html#active-annotations-code-generation).

There are base classes that implment all callback interfaces. You should subclass one of those depending on your annotation target: 

*   [AbstractClassProcessor]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/AbstractClassProcessor.java) is a base class for class annotations
*   [AbstractInterfaceProcessor]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/AbstractInterfaceProcessor.java) is a base class for interface annotations
*   [AbstractAnnotationTypeProcessor]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/AbstractAnnotationTypeProcessor.java) is a base class for annotation type annotations
*   [AbstractEnumerationTypeProcessor]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/AbstractEnumerationTypeProcessor.java) is a base class for enumeration type annotations
*   [AbstractMethodProcessor]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/AbstractMethodProcessor.java) is a base class for method annotations
*   [AbstractFieldProcessor]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/AbstractFieldProcessor.java) is a base class for field annotations

If you want to annotate other elements such as parameters or constructors, you should have a look at the bases classes and adapt their implementation (basically the type parameter) accordingly. It is also possible to have a very generic processor by using [Declaration]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/declaration/Declaration.java), the super type of all declared elements.

### Phase 1: Register Globals {#active-annotations-register-globals}

The first phase in the lifecycle of the compiler is about indexing the types as globally available symbols. By implementing a [RegisterGlobalsParticipant]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/RegisterGlobalsParticipant.java) you have the chance to create and register new Java types during this phase. It's important to do this in a first phase so later on the compiler can find and access these types.

For example the ExtractProcessor adds one interface per annotated class:

```xtend
class ExtractProcessor extends AbstractClassProcessor {
  
  override doRegisterGlobals(ClassDeclaration annotatedClass, RegisterGlobalsContext context) {
    context.registerInterface(annotatedClass.interfaceName)
  }

  def getInterfaceName(ClassDeclaration annotatedClass) {
    annotatedClass.qualifiedName+"Interface"
  }
  
  ...
}
```

The [RegisterGlobalsContext]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/RegisterGlobalsContext.java) provides all the services that are available during this compilation step. It is passed into the method `doRegisterGlobals()` along with a read-only representation of the annotated source elements. The AbstractClassProcessor in this example is invoked for all classes that are annotated with `@Extract`.

The compiler calls [RegisterGlobalsParticipant]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/RegisterGlobalsParticipant.java) once per compilation unit and provides access to all elements which are annotated with the *active annotation* this processor is registered for. Therefore the `ExtractProcessor` is invoked with a list of all classes that are defined in the same Xtend file for all the files that are being compiled.

### Phase 2: Transformation {#active-annotations-transformation-phase}

In the second phase developers can modify the compiled Java classes and Java code. Annotation processors that implement [TransformationParticipant]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/TransformationParticipant.java) participate in this compile step. Similar to the [RegisterGlobalsParticipant]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/RegisterGlobalsParticipant.java) interface the compiler provides two arguments: The list of annotated translated and now mutable Java elements and a [TransformationContext]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/TransformationContext.java). The context provides services that are specific for this second step.

A transformation participant can access and modify mutable Java elements. These are an in-memory representation of the generated Java code. They are usually very similar to the source elements, but can be modified and new methods, fields or constructors can be added. It is not possible to create new types during the transformation step. Also note, that other annotation processors might already have altered the model.

The `ExtractProcessor` implements the method `doTransform` like this:

```xtend
class ExtractProcessor extends AbstractClassProcessor {
  
  override doRegisterGlobals(ClassDeclaration annotatedClass, RegisterGlobalsContext context) {
    context.registerInterface(annotatedClass.interfaceName)
  }

  def getInterfaceName(ClassDeclaration annotatedClass) {
    annotatedClass.qualifiedName+"Interface"
  }
  
  override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
    val interfaceType = findInterface(annotatedClass.interfaceName)
    
    // add the interface to the list of implemented interfaces
    annotatedClass.implementedInterfaces = annotatedClass.implementedInterfaces + #[interfaceType.newTypeReference]
    
    // add the public methods to the interface
    for (method : annotatedClass.declaredMethods) {
      if (method.visibility == Visibility.PUBLIC) {
        interfaceType.addMethod(method.simpleName) [
          docComment = method.docComment
          returnType = method.returnType
          for (p : method.parameters) {
            addParameter(p.simpleName, p.type)
          }
          exceptions = method.exceptions
        ]
      }
    }
  }
}
```

In the first line, `findInterface` retrieves the interface which was registered during the registration of global symbols in the first phase: The method is defined in [TransformationContext]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/TransformationContext.java) which is used as an [extension provider](202_xtend_classes_members.html#extension-provider).

Next up the newly created interface is added to the existing list of implemented interfaces. 

```xtend
annotatedClass.implementedInterfaces = annotatedClass.implementedInterfaces + #[interfaceType.newTypeReference]
```

The code calls `setImplementedInterfaces(Iterable<TypeReference>)` on the annotated class. The right hand side of the assignment is a concatenation of the existing implemented interfaces and a type reference pointing to the freshly created interface.

A [TypeReference]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/declaration/TypeReference.java) can be created using one of the various methods from [TypeReferenceProvider]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/services/TypeReferenceProvider.java) which is a super type of [TransformationContext]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/TransformationContext.java). These utilities are available as extensions, too.

### Phase 3: Validation {#active-annotations-validation-phase}

The third lifecycle allows to participate in validation. You can already do validation during transformation and even during registerGlobals, but it is only now that you can fully resolve everything, including inferred type references.

### Phase 4: Code Generation {#active-annotations-code-generation}

The last phase in the lifecycle of the compiler lets you participate in writing and updating the files. In the IDE this phase is only executed on save , while the previous two get executed after minor edits in the editor as well. In order to participate your processor needs to implement [CodeGenerationParticipant]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/CodeGenerationParticipant.java). The extract interface example doesn't make use of this hook, but another example for internationalization which is also included, generates a \*.properties file, like this:

```xtend
class ExternalizedProcessor extends AbstractClassProcessor {
  
  ...
  
  override doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements, extension CodeGenerationContext context) {
    for (clazz : annotatedSourceElements) {
      val filePath = clazz.compilationUnit.filePath
      val file = filePath.targetFolder.append(clazz.qualifiedName.replace('.', '/') + ".properties")
      file.contents = '''
        «FOR field : clazz.declaredFields»
          «field.simpleName» = «field.initializerAsString»
        «ENDFOR»
      '''
    }
  }

}
```

The [CodeGenerationContext]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/CodeGenerationContext.java) provides all the services that are available during this phase. Have a look at the Java doc for more details.

## On Expressions and Statements {#active-annotations-expression}

Most of the generated Java code is represented in the form of in-memory elements. Basically all the structural elements are represented as a dedicated [Element]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/declaration/Element.java). If you want to generate the body of a method or the initializer of a field, you have two options.

### Generating Blackbox Java Code {#active-annotations-compilation-strategies}

The first option is to assign a compilation strategy and take care of the Java code by yourself. As an example the body of a setter method of an observable instance is implemented by the following code snippet:

```xtend
observableType.addMethod('set' + fieldName.toFirstUpper) [
  addParameter(fieldName, fieldType)
  body = '''
    «fieldType» _oldValue = this.«fieldName»;
    this.«fieldName» = «fieldName»;
    _propertyChangeSupport.firePropertyChange("«fieldName»", _oldValue, «fieldName»);
  '''
]
```

A template expression is used to implement the body. Although this code is execute during transform, the actual concatenation only happens during code generation. It's a special form of a string concatenation, that will automatically add imports when concatenating a TypeReference, java.lang.Class or a TypeDeclaration. It takes existing imports into account and adds new imports on the fly if necessary.

### Assigning Expressions {#active-annotations-assigning-expressions}

A second alternative is to put expressions from the Xtend source into the context of a generated Java element. This allows to directly use the code that was written in the source file. An annotation `@Lazy` which turns fields into lazily initialized properties, may be used like this: 

```xtend
class MyClass {
  @Lazy String myField = expensiveComputation()
}
```

The processor for this *active annotation* could infer a synthetic initializer method and add a getter-method, which calls the initializer if the field is still `null`. Therefore, the initialization expression of the field has to become the method body of the synthesized initializer method. The following code performs this transformation:

```xtend
override doTransform(MutableFieldDeclaration field, extension TransformationContext context) {

  // add synthetic init-method
  field.declaringType.addMethod('_init' + field.simpleName) [
    visibility = Visibility.PRIVATE
    returnType = field.type
    // reassign the initializer expression to be the init method's body
    // this automatically removes the expression as the field's initializer
    body = field.initializer
  ]

  // add a getter method which lazily initializes the field
  field.declaringType.addMethod('get' + field.simpleName.toFirstUpper) [
    returnType = field.type
    body = ['''
      if («field.simpleName»==null)
        «field.simpleName» = _init«field.simpleName»();
      return «field.simpleName»;
    ''']
  ]
}
```

## Custom Compiler Checks {#active-annotations-validation}

The previous example requires each annotated field to have an initializer. Otherwise it would not be possible to use lazy initialization to assign its value. Also a simple check for a `null` reference could cause trouble with primitive values. A validation for that case would be sensible, too. In order to guide the user dedicated compilation errors should be raised if these constrains are violated.

The [TransformationContext]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/TransformationContext.java) inherits methods for exactly that purpose from the [ProblemSupport]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib.macro/src/org/eclipse/xtend/lib/macro/services/ProblemSupport.java) service.

Since the `context` is declared as an [extension provider](202_xtend_classes_members.html#extension-provider), those methods can be used as extensions and it allows to implement the constraint check accordingly:

```xtend
override doTransform(MutableFieldDeclaration field, extension TransformationContext context) {
  if (field.type.primitive)
    field.addError("Fields with primitives are not supported by @Lazy")
    
  if (field.initializer == null)
    field.addError("A lazy field must have an initializer.")
  ...
}
```

This ensures that the user is notified about invalid applications of the *active annotation* `@Lazy`.

## Class Path Setup and Testing {#active-annotation-classpath}

An *active annotation* can not be used in the same project it is declared in, but has to reside on an upstream project. Alternatively it can be compiled and deployed in a jar. The annotation and the processor itself only rely on the interfaces defined in `org.eclipse.xtend.lib.macro` which is part of Xtend's small standard library.

Also note that the macro library as well as the processors are strictly speaking compile-time only dependencies. So if it matters, like e.g. on Android devices, you don't need to ship them at runtime.

When used in an IDE the compiled annotation processor is loaded and executed on the fly within the IDE process.

Therefore, careful testing and debugging of the processor is essential. It is best done in a unit test. Such a test needs the whole Xtend compiler on the class path, which you can obtain by means of an OSGi bundle dependency or via Maven. The maven dependency is

```
<dependency>
  <groupId>org.eclipse.xtend</groupId>
  <artifactId>org.eclipse.xtend.core</artifactId>
  <version>2.7.1</version>
  <scope>test</scope>
</dependency>
```

and the equivalent OSGI bundle is `org.eclipse.xtend.core`.

### Testing {#active-annotation-compiler-tester}

The `XtendCompilerTester` is a convenient helper class for testing the processing and the compilation. It allows to test active annotation processors by either comparing the generated Java source using a String comparison or by inspecting the produced Java elements. In addition you can even compile the generated Java source to a Java class and create and test instances of it reflectively.

The example project contains a couple of test cases:

```xtend
class LazyTest {
  extension XtendCompilerTester compilerTester = XtendCompilerTester.newXtendCompilerTester(Lazy)

  @Test def void testLazy() {
    '''
      import lazy.Lazy
      
      class Person {
        @Lazy String name = 'foo'
      }
    '''.assertCompilesTo(
    '''
      import lazy.Lazy;

      @SuppressWarnings("all")
      public class Person {
        @Lazy
        private String name;
        
        private String _initname() {
          return "foo";
        }
        
        public String getName() {
          if (name==null)
            name = _initname();
          return name;
          
        }
      }
    ''')
  }
}
```

This is a basic string comparison. It is a good way to start the development of a new annotation processor. Later on assertions against the produced elements and syntax tree (AST) may be a better choice since these are not so fragile against changes in the formatting. The `@Extract`-example uses this technique: 

```xtend
@Test def void testExtractAnnotation() {
  '''
    @extract.Extract
    class MyClass {
      override String doStuff(String myParam) throws IllegalArgumentException {
        return myParam
      }
    }
  '''.compile [
    // declare the transformation context as a local extensions
    val extension ctx = transformationContext
    
    // look up the interface and the class
    val interf = findInterface('MyClassInterface')
    val clazz = findClass('MyClass')
    
    
    // do assertions
    assertEquals(interf, clazz.implementedInterfaces.head.type)
    
    interf.declaredMethods.head => [
      assertEquals('doStuff', simpleName)
      assertEquals(string, returnType)
      assertEquals(IllegalArgumentException.newTypeReference, exceptions.head)
    ]
  ]
}
```

### Wrap Up

*Active Annotations* are a powerful and unique concept that allows to solve a large class of problems that previously had to be solved in cumbersome ways. IDE wizards, many code generators or manually writing boilerplate code are no longer state of the art. Active annotations basically *is* a means of code generation, but its simple integration with existing projects and the fast development turnarounds diminish the typical downsides of code generation.

## Existing Active Annotations

Xtend comes with ready-to-use active annotations for common code patterns. They reside in the `org.eclipse.xtend.lib.annotations` plug-in/jar which must be on the class path of the project containing the Xtend files.

## @Accessors {#property-annotation}

If you want to add getter and or setter methods for your fields [`@Accessors`]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib/src/org/eclipse/xtend/lib/annotations/Accessors.xtend) is your friend. Here's a basic example.

```xtend
@Accessors String name
```

will compile to the Java code

```java
private String name;

public String getName() {
  return this.name;
}

public void setName(final String name) {
  this.name = name;
}
```

So by default a public getter and a public setter method is created. The `@Accessors` can be configured to tell that you only want one or the other and to change the visibility. this is done by means of [AccessorType]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib/src/org/eclipse/xtend/lib/annotations/Accessors.xtend) You can also use the annotation on class level to do the same for all fields.

Here is a more complex example, that shows how it works:

```xtend
@Accessors class Person {
  String name
  String firstName
  @Accessors(PUBLIC_GETTER, PROTECTED_SETTER) int age
  @Accessors(NONE) String internalField
}

```

will compile to the Java code

```java
@Accessors public class Person {
  private String name
  private String firstName
  @Accessors(PUBLIC_GETTER, PROTECTED_SETTER) private int age
  @Accessors(NONE) private String internalField
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public String getFirstName() {
    return this.firstName;
  }
  
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }
  
  public int getAge() {
    return this.age;
  }
  
  protected void setAge(final int age) {
    this.age = age;
  }
}
```

## @Data {#data-annotation}

The annotation [`@Data`]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib/src/org/eclipse/xtend/lib/annotations/Data.xtend), will turn an annotated class into a value object class. A class annotated with `@Data` is processed according to the following rules:

*   all fields are final,
*   getter methods will be generated (if they do not yet exist),
*   a constructor with parameters for all non-initialized fields will be generated (if it does not exist),
*   equals(Object) / hashCode() methods will be generated (if they do not exist),
*   a toString() method will be generated (if it does not exist).

Example:

```xtend
@Data class Person {
  String firstName
  String lastName
  
  def static void main(String[] args) {
    val p = new Person(args.get(0), args.get(1))
    println(p.getFirstName() + ' ' + p.lastName)
  }
}
```

## @Delegate {#delegate-annotation}

The [`@Delegate`]({{site.src.xtext}}/plugins/org.eclipse.xtend.lib/src/org/eclipse/xtend/lib/annotations/Delegate.xtend) annotation automatically generated delegate methods for all interfaces shared between the delegate and the currently implemented class. You can optionally restrict it to explicitly stated interfaces.

Let's start with a basic example:

```xtend
class MyClass implements SomeInterface {

  // generates all methods of List and delegates to this field
  @Delegate SomeSubTypeOfSumInterface myDelegate

}
```

It is not only possible to delegate to fields, but also to methods so you for instance could lazily create the delegate object or use a different one each time. If you use a method you can also declare additional parameters, that will tell you about the method that should be invoked.

Here's another example: 

```xtend
class MyClass implements SomeInterface {

  SomeInterface myDelegate;

  @Delegate def List<? extends String> provideDelegate(String methodName, Class[] paramTypes, Object[] actualArguments) {
     if (!canHandle(methodName,paramTypes,actualArguments) {
        throw new UnsupportedOperationException("The method "+methodName+" is not supported.");
     }
     return myDelegate
  }
}
```

