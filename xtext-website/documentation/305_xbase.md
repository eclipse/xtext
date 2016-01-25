---
layout: documentation
title: Xtext and Java
part: Reference Documentation
---

# {{page.title}} {#xbase}

The following chapter demonstrates how to integrate your own DSL with Java. We will do this in four stages: First, you will learn how to refer to existing Java elements from within your language. Then you will use Xbase to refer to generic types. In the third step, you will map your own DSL's concepts to Java concepts. Last but not least, you will use both Java types and your concepts within Xbase expressions and execute it. 

Throughout this chapter, we will step by step improve the [domain model example from the tutorial](103_domainmodelnextsteps.html). 

## Plug-in Setup

In the following, we are going to use the JVM types model and the Xbase language library. Have a look at your MWE2 workflow and make sure that 

*   the Xbase models are registered in the standalone setup and
*   the [TypesGeneratorFragment]({{site.src.xtext}}/plugins/org.eclipse.xtext.generator/src/org/eclipse/xtext/generator/types/TypesGeneratorFragment.java) and the [XbaseGeneratorFragment]({{site.src.xtext}}/plugins/org.eclipse.xtext.generator/src/org/eclipse/xtext/generator/xbase/XbaseGeneratorFragment.java) are enabled.

```mwe2
bean = StandaloneSetup {
  ...
  registerGeneratedEPackage = "org.eclipse.xtext.xbase.XbasePackage"
  registerGenModelFile = "platform:/resource/org.eclipse.xtext.xbase/model/Xbase.genmodel"
}
...
fragment = types.TypesGeneratorFragment {}
fragment = xbase.XbaseGeneratorFragment {}
```
Needs to be updated. we have changed the structure of the generator.
To avoid running out of memory when regenerating, make sure to run the workflow with reasonably sized heap and PermGen space. We recommend at least 

`-Xmx512m -XX:MaxPermSize=128m`

in the *VM Arguments* section of the *Arguments* tab of the run configuration. If you are experiencing ambiguity warnings from Antlr, the [usual countermeasures](301_grammarlanguage.html#syntactic-predicates) apply. The launch configuration that you get with a new Xtext project is already configured properly.

## Referring to Java Elements using JVM Types {#jvmtypes}

A common case when developing languages is the requirement to refer to existing concepts of other languages. Xtext makes this very easy for other self defined DSLs. However, it is often very useful to have access to the available types of the Java Virtual Machine as well. The JVM types Ecore model enables clients to do exactly this. It is possible to create cross-references to classes, interfaces, and their fields and methods. Basically every information about the structural concepts of the Java type system is available via the JVM types. This includes annotations and their specific values and enumeration literals, too.

The implementation will be selected transparently depending on how the client code is executed. If the environment is a plain stand-alone Java or OSGi environment, the *java.lang.reflect* API will be used to deduce the necessary data. On the contrary, the type-model will be created from the live data of the JDT in an interactive Eclipse environment. All this happens transparently for the clients behind the scenes via different implementations that are bound to specific interfaces by means of Google Guice. 

Using the JVM types model is very simple. First of all, the grammar has to import the *JavaVMTypes* Ecore model. Thanks to content assist this is easy to spot in the list of proposals. 

```xtext
import "http://www.eclipse.org/xtext/common/JavaVMTypes" as jvmTypes
```

The next step is to actually refer to an imported concept. Let's define a mapping to available Java types for the simple data types in the domain model language. This can be done with a simple cross-reference:

```xtext
// simple cross reference to a Java type
DataType:
  'datatype' name=ID 
  'mapped-to' javaType=[jvmTypes::JvmType|QualifiedName];
```

After regenerating your language, it will be allowed to define a type `Date` that maps to the [Date]({{site.javadoc.java}}/java/util/Date.html) like this:

```javatypesexample
  datatype Date mapped-to java.util.Date
```

These two steps will provide a nice integration into the Eclipse JDT. There is *Find References* on Java methods, fields and types that will reveal results in your language files. *Go To Declaration* works as expected and content assist will propose the list of available types. Even the *import* statements will also apply for Java types. 

### Customization Points

There are several customization hooks in the runtime layer of the JVM types and on the editor side as well:

The [AbstractTypeScopeProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/src/org/eclipse/xtext/common/types/xtext/AbstractTypeScopeProvider.java) can be used to create scopes for members with respect to the override semantics of the Java language. Of course it is possible to use this implementation to create scopes for types as well.

As the Java VM types expose a lot of information about visibility, parameter types and return types, generics, available annotations or enumeration literals, it is very easy to define constraints for the referred types.

The [ITypesProposalProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types.ui/src/org/eclipse/xtext/common/types/xtext/ui/ITypesProposalProvider.java) can be used to provide optimized proposals based on various filter criteria. The most common selector can be used directly via `createSubTypeProposals(..)`. The implementation is optimized and uses the JDT Index directly to minimize the effort for object instantiation. The class [TypeMatchFilters]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types.ui/src/org/eclipse/xtext/common/types/xtext/ui/TypeMatchFilters.java) provides a comprehensive set of reusable filters that can be easily combined to reduce the list of proposals to a smaller number of valid entries. 

## Referring to Java Types Using Xbase {#xbase-java-references}

While the JVM types approach from the previous chapter allows to refer to any Java element, it is quite limited when it comes to generics. Usually, a type reference in Java can have type arguments which can also include wildcards, upper and lower bounds etc. A simple cross-reference using a qualified name is not enough to express neither the syntax nor the structure of such a type reference. 

Xbase offers a parser rule *JvmTypeReference* which supports the full syntax of a Java type reference and instantiates a JVM element of type [JvmTypeReference]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/emf-gen/org/eclipse/xtext/common/types/JvmTypeReference.java). So let us start by inheriting from Xbase:

```xtext
grammar org.eclipse.xtext.example.Domainmodel 
   with org.eclipse.xtext.xbase.Xbase
```

Because we can express all kinds of Java type references directly now, an indirection for *DataTypes* as in the previous section is no longer necessary. If we start from the [domain model example in the tutorial](103_domainmodelnextsteps.html) again, we have to replace all cross-references to *Types* by calls to the production rule *JvmTypeReference*. The rules *DataType*, *Type*, and *QualifiedName* become obsolete (the latter is already defined in Xbase), and the *Type* in *AbstractEntity* must be changed to *Entity*. As we now have all kinds of generic Java collections at hand, *Feature.many* is obsolete, too. The whole grammar now reads concisely:

```xtext
grammar org.eclipse.xtext.example.Domainmodel with
                                      org.eclipse.xtext.xbase.Xbase

generate domainmodel "http://www.eclipse.org/xtext/example/Domainmodel"

Domainmodel:
  importSection=XImportSection?
  (elements += AbstractElement)*
;

PackageDeclaration:
  'package' name = QualifiedName '{'
    (elements += AbstractElement)*
  '}'
;

AbstractElement:
  PackageDeclaration | Entity
;

Entity:
  'entity' name = ID 
              ('extends' superType = JvmTypeReference)?
  '{'
    (features += Feature)*
  '}'
;
 
Feature:
  name = ID ':' type = JvmTypeReference
; 
```

As we changed the grammar, we have to regenerate the language now.

Being able to parse a Java type reference is already nice, but we also have to write them back to their string representation when we generate Java code. Unfortunately, a generic type reference with fully qualified class names can become a bit bulky. Therefore, the [ImportManager]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/compiler/ImportManager.java) shortens fully qualified names, keeps track of imported namespaces, avoids name collisions, and helps to serialize [JvmTypeReferences]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/emf-gen/org/eclipse/xtext/common/types/JvmTypeReference.java) by means of the [TypeReferenceSerializer]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/compiler/TypeReferenceSerializer.java). This utility encapsulates how type references may be serialized depending on the concrete context in the output.

The following snippet shows our code generator using an [ImportManager]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/compiler/ImportManager.java) in conjunction with as [TypeReferenceSerializer]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/compiler/TypeReferenceSerializer.java). We create a new instance and pass it through the generation functions, collecting types on the way. As the import section in a Java file precedes the class body, we create the body into a String variable and assemble the whole file's content in a second step.

```xtend
class DomainmodelGenerator implements IGenerator {
  
  @Inject extension IQualifiedNameProvider
  @Inject extension TypeReferenceSerializer 

  override void doGenerate(Resource resource, IFileSystemAccess fsa) {
    for(e: resource.allContents.toIterable.filter(typeof(Entity))) {
      fsa.generateFile(
        e.fullyQualifiedName.toString("/") + ".java",
        e.compile)
    }
  }
  
  def compile(Entity it) '''
    «val importManager = new ImportManager(true)» 
    «val body = body(importManager)»
    «IF eContainer != null»
      package «eContainer.fullyQualifiedName»;
    «ENDIF»
    
    «FOR i:importManager.imports»
      import «i»;
    «ENDFOR»
    
    «body»
  '''
  
  def body(Entity it, ImportManager importManager) '''
    public class «name» «IF superType != null»
      extends «superType.shortName(importManager)» «ENDIF»{
      «FOR f : features»
        «f.compile(importManager)»
      «ENDFOR»
    }
  '''
    
  def compile(Feature it, ImportManager importManager) '''
    private «type.shortName(importManager)» «name»;
    
    public «type.shortName(importManager)» 
      get«name.toFirstUpper»() {
      return «name»;
    }
    
    public void set«name.toFirstUpper»(
      «type.shortName(importManager)» «name») {
      this.«name» = «name»;
    }
  '''
  
  def shortName(JvmTypeReference ref, 
          ImportManager importManager) {
    val result = new StringBuilderBasedAppendable(importManager)
    ref.serialize(ref.eContainer, result);
    result.toString
  }
}
```

Please note that when *org.eclipse.xtext.xbase.Xbase* is used the default binding for the interface [IGenerator]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/generator/IGenerator.java) is [JvmModelGenerator]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/compiler/JvmModelGenerator.xtend). To use a custom one we have to bind our own implementation in *org.example.domainmodel.DomainmodelRuntimeModule* like this: 

```java
public class DomainmodelRuntimeModule extends org.example.domainmodel.AbstractDomainmodelRuntimeModule {
 	override Class<? extends IGenerator> bindIGenerator() {
		return DomainmodelGenerator
	}
}
```

## Inferring a JVM Model {#xbase-inferred-type}

In many cases, you will want your DSLs concepts to be usable as Java elements, e.g. an *Entity* will become a Java class and should be usable as such. In the domain model example, you can write 

```domainexample
entity Employee extends Person {
  boss: Person
...

entity Person {
  friends: List<Person>
...
```

You can use entities instead of Java types or even mix Java types as [List]({{site.javadoc.java}}/java/util/List.html) with entities such as *Person*. One way to achieve this is to let your concepts inherit from a corresponding JVM type, e.g. let *Entity* inherit from [JvmGenericType]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/emf-gen/org/eclipse/xtext/common/types/JvmGenericType.java). But this would result in a lot of accidentally inherited properties in your domain model. In Xbase there is an alternative: You can simply define how to derive a JVM model from your model. This *inferred JVM model* is the representation of your concepts in the type system of Xbase. 

The main component for the inferred JVM model is the [IJvmModelInferrer]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/jvmmodel/IJvmModelInferrer.java). It has a single method that takes the root model element as an argument and produces a number of [JvmDeclaredTypes]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/emf-gen/org/eclipse/xtext/common/types/JvmDeclaredType.java). As Xbase cannot guess how you would like to map your concepts to JVM elements, you have to implement this component yourself. This usually boils down to using an injected [JvmTypesBuilder]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/jvmmodel/JvmTypesBuilder.java) to create a hierarchy of JVM elements. The [builder]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/jvmmodel/JvmTypesBuilder.java) helps to initialize the produced types with sensible defaults and encapsulates the logic that associates the source elements with the derived JVM concepts. As this kind of transformation can be elegantly implemented using polymorphic dispatch functions and extension methods, it is a good choice to write the [IJvmModelInferrer]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/jvmmodel/IJvmModelInferrer.java) in Xtend. It becomes even simpler if you inherit from the [AbstractModelInferrer]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/jvmmodel/AbstractModelInferrer.java) which traverses the input model and dispatches to its contents until you decide which elements to handle. 

The inference runs in two phases: In the first phase all the types are created with empty bodies. This way you make sure all types exist when you might lookup types during initializing the members in the second phase. Use `acceptor.accept(JvmDeclaredType, Procedure1<JvmDeclaredType>)` and pass in the created Java type as the first argument and the initialization block as the second. For our domain model example, we implement a polymorphic dispatch function *infer* for *Entities* to transform them into a [JvmGenericType]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/emf-gen/org/eclipse/xtext/common/types/JvmGenericType.java) in the first phase. In the second phase, we add a [JvmField]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/emf-gen/org/eclipse/xtext/common/types/JvmField.java) and corresponding accessors for each *Property*. The final *DomainmodelJvmModelInferrer* looks like this:

```xtend
class DomainmodelJvmModelInferrer extends AbstractModelInferrer {

  @Inject extension JvmTypesBuilder
  
  @Inject extension IQualifiedNameProvider
  
  def dispatch void infer(Entity element, 
                IJvmDeclaredTypeAcceptor acceptor, 
                boolean isPrelinkingPhase) {
    
    acceptor.accept(element.toClass(element.fullyQualifiedName)) [
      documentation = element.documentation
      for (feature : element.features) {
        members += feature.toField(feature.name, feature.type)
        members += feature.toSetter(feature.name, feature.type)
        members += feature.toGetter(feature.name, feature.type)
      }
    ]
  }
}
```

Out of the inferred model the corresponding Java class gets generated. To ensure that this will work make sure that the binding in the rumtime module for [IGenerator]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/generator/IGenerator.java) is pointing to [JvmModelGenerator]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/compiler/JvmModelGenerator.xtend). This is the default case, but as we dealt with a custom implementation in the last section this may lead to problems.

### Linking and Indexing

As Java elements and your concepts are now represented as JVM model elements, other models can now transparently link to Java or your DSL. In other words, you can use a mapped element of your DSL in the same places as the corresponding Java type.

The Xbase framework will automatically switch between the JVM element or the DSL element when needed, e.g. when following hyperlinks. The component allowing to navigate between the source model and the JVM model is called [IJvmModelAssociations]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/jvmmodel/IJvmModelAssociations.java), the read-only antagonist of the [IJvmModelAssociator]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/jvmmodel/IJvmModelAssociator.java) that is used by the [JvmTypesBuilder]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/jvmmodel/JvmTypesBuilder.java).

By default, the inferred model is [indexed](303_runtime_concepts.html#global-scopes), so it can be cross referenced from other models.

## Using Xbase Expressions {#xbase-expressions}

Xbase is an expression language that can be embedded into Xtext languages. Its syntax is close to Java, but it additionally offers type inference, lambda expressions, a powerful switch expression and a lot more. For details on this expression language, please consult the [reference documentation](#xbase-language-ref-introduction) and the Xbase tutorial *(File &rarr; New &rarr; Example &rarr; Xtext Examples &rarr; Xbase Tutorial)*. 

Xbase ships with an interpreter and a compiler that produces Java code. Thus, it is easy to add behavior to your DSLs and make them executable. As Xbase integrates tightly with Java, there is usually no additional code needed to run your DSL as part of a Java application. 

### Making Your Grammar Refer To Xbase

If you want to refer to [EClassifiers]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClassifier.java) from the Xbase model, you need to import Xbase first:

```xtext
import "http://www.eclipse.org/xtext/xbase/Xbase" as xbase
```

Now identify the location in your grammar where you want references to Java types and Xbase expressions to appear and call the appropriate rules of the super grammar. Adding Xbase expression to the domainmodel example leads to the additional concept *Operation*: An *Operation*'s parameters are *FullJvmFormalParameters*. The production rule for *FullJvmFormalParameters* expects both the name and the type here. That is reasonable since the type of parameters should not be inferred. The operation's return type is a *JvmTypeReference* and its *body* is an *XBlockExpression*. The final parser rule reads as:

```xtext
Operation:
  'op' name=ValidID '(' 
  (params+=FullJvmFormalParameter (',' params+=FullJvmFormalParameter)*)? ')' 
  ':' type=JvmTypeReference 
    body=XBlockExpression;
```

If you are unsure which entry point to choose for your expressions, consider the *XBlockExpression*.

To integrate *Operations* in our models, we have to call this rule. We copy the previous *Feature* to a new rule *Property* and let *Feature* become the super type of *Property* and *Operation*:

```xtext
Feature:
  Property | Operation
;
 
Property:
  name = ID ':' type = JvmTypeReference
;
```

Note: You will have to adapt the [IJvmModelInferrer]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/jvmmodel/IJvmModelInferrer.java) to these changes, i.e. rename *Feature* to *Property* and create a [JvmOperation]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/emf-gen/org/eclipse/xtext/common/types/JvmOperation.java) for each *Operation*. We leave that as an exercise :-) 

If you are done with that, everything will work out of the box. Since each expression is now logically contained in an [operation]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/emf-gen/org/eclipse/xtext/common/types/JvmOperation.java), all the scoping rules and visibility constraints are implied from that context. The framework will take care that the operation's parameters are visible inside the operation's body and that the declared return types are validated against the actual expression types.

There is yet another aspect of the JVM model that can be explored. Since all the coarse grained concepts such as [types]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/emf-gen/org/eclipse/xtext/common/types/JvmType.java) and [operations]({{site.src.xtext}}/plugins/org.eclipse.xtext.common.types/emf-gen/org/eclipse/xtext/common/types/JvmOperation.java) were already derived from the model, a generator can be used to serialize that information to Java code. There is no need to write a code generator on top of that. The [JvmModelGenerator]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/compiler/JvmModelGenerator.xtend) knows how to generate operation bodies properly. 

### Using the Xbase Interpreter

Sometimes it is more convenient to interpret a model that uses Xbase than to generate code from it. Xbase ships with the [XbaseInterpreter]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/interpreter/impl/XbaseInterpreter.java) which makes this rather easy.

An interpreter is essentially an external visitor, that recursively processes a model based on the model element's types. In the [XbaseInterpreter]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/interpreter/impl/XbaseInterpreter.java), the method *doEvaluate(XExpression, IEvaluationContext, CancelIndicator)* delegates to more specialised implementations e.g.

```java
protected Object _doEvaluate(XBlockExpression literal,
							IEvaluationContext context,
							CancelIndicator indicator)
```

The [IEvaluationContext]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/interpreter/IEvaluationContext.java) keeps the state of the running application, i.e. the local variables and their values. Additionally, it can be *fork*ed, thus allowing to shadow the elements of the original context. Here is an example code snippet how to call the [XbaseInterpreter]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/src/org/eclipse/xtext/xbase/interpreter/impl/XbaseInterpreter.java):

```java
@Inject private XbaseInterpreter xbaseInterpreter;

@Inject private Provider<IEvaluationContext> contextProvider;

...
public Object evaluate(XExpression expression, Object thisElement) {
  IEvaluationContext evaluationContext = contextProvider.get();
  // provide initial context and implicit variables
  evaluationContext.newValue(XbaseScopeProvider.THIS, thisElement);
  
  IEvaluationResult result = xbaseInterpreter.evaluate(expression,   
    evaluationContext, CancelIndicator.NullImpl);
  if (result.getException() != null) {
    // handle exception
  } 
  return result.getResult();
}
```

## Xbase Language Reference {#xbase-language-ref-introduction}

This document describes the expression language library Xbase. Xbase is a partial programming language implemented in Xtext and is meant to be embedded and extended within other programming languages and domain-specific languages (DSL) written in Xtext. Xtext is a highly extendible language development framework covering all aspects of language infrastructure such as parsers, linkers, compilers, interpreters and even full-blown IDE support based on Eclipse. 

Developing DSLs has become incredibly easy with Xtext. Structural languages which introduce new coarse-grained concepts, such as services, entities, value objects or state-machines can be developed in minutes. However, software systems do not consist of structures solely. At some point a system needs to have some behavior, which is usually specified using so called *expressions*. Expressions are the heart of every programming language and are not easy to get right. On the other hand, expressions are well understood and many programming languages share a common set and understanding of expressions.

That is why most people do not add support for expressions in their DSL but try to solve this differently. The most often used workaround is to define only the structural information in the DSL and add behavior by modifying or extending the generated code. It is not only unpleasant to write, read and maintain information which closely belongs together in two different places, abstraction levels and languages. Also, modifying the generated source code comes with a lot of additional problems. This has long time been the preferred solution since adding support for expressions (and a corresponding execution environment) for your language has been hard - even with Xtext.

Xbase serves as a language library providing a common expression language bound to the Java platform (i.e. Java Virtual Machine). It consists of an Xtext grammar, as well as reusable and adaptable implementations for the different aspects of a language infrastructure such as an AST structure, a compiler, an interpreter, a linker, and a static analyzer. In addition it comes with implementations to integrate the expression language within an Xtext-based Eclipse IDE. Default implementations for aspects like content assistance, syntax coloring, hovering, folding and navigation can be easily integrated and reused within any Xtext based language. 

Conceptually and syntactically, Xbase is very close to Java statements and expressions, but with a few differences: 

*   No checked exceptions
*   Everything is an expression, there are no statements
*   Lambda expressions
*   Type inference
*   Properties
*   Simple operator overloading
*   Powerful switch expressions

---

### Lexical Syntax {#xbase-language-ref-syntax}

Xbase comes with a small set of terminal rules, which can be overridden and hence changed by users. However the default implementation is carefully chosen and it is recommended to stick with the lexical syntax described in the following.

#### Identifiers {#xbase-syntax-identifiers}

Identifiers are used to name all constructs, such as types, methods and variables. Xbase uses the default identifier-syntax from Xtext - compared to Java, they are slightly simplified to match the common cases while having less ambiguities. They start with a letter *a*-*z*, *A*-*Z* or an underscore followed by more of these characters or any digit *0*-*9*. 

##### Escaped Identifiers {#xbase-syntax-escaped-identifiers}

Identifiers must not have the same spelling as any reserved keyword. However, this limitation can be avoided by escaping identifiers with the prefix `^`. Escaped identifiers are used in cases when there is a conflict with a reserved keyword. Imagine you have introduced a keyword `service` in your language but want to call a Java property *service*. In such cases you can use the escaped identifier `^service` to reference the Java property.

##### Syntax

```xtext
terminal ID: 
  '^'? ('a'..'z'|'A'..'Z'|'_'|'$') ('a'..'z'|'A'..'Z'|'_'|'$'|'0'..'9')*
;
```

##### Examples

*   `Foo`
*   `Foo42`
*   `FOO`
*   `_42`
*   `_foo`
*   `$$foo$$`
*   `^extends`

#### Comments {#xbase-syntax-comments}

Xbase comes with two different kinds of comments: Single-line comments and multi-line comments. The syntax is the same as the one known from Java (see [§ 3.7 Comments](http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.7)).

#### White Space {#xbase-syntax-whitespace}

The white space characters `' '`, `'\t'`, `'\n'`, and `'\r'` are allowed to occur anywhere between the other syntactic elements. 

#### Reserved Keywords {#xbase-syntax-keywords}

The following list of words are reserved keywords, thus reducing the set of possible identifiers: 

1.  `as`
1.  `case`
1.  `catch`
1.  `default`
1.  `do`
1.  `else`
1.  `extends`
1.  `extension`
1.  `false`
1.  `finally`
1.  `for`
1.  `if`
1.  `import`
1.  `instanceof`
1.  `new`
1.  `null`
1.  `return`
1.  `static`
1.  `super`
1.  `switch`
1.  `throw`
1.  `true`
1.  `try`
1.  `typeof`
1.  `val`
1.  `var`
1.  `while`

The four keywords `extends, static, import, extension` can be used when invoking operations. In case some of the other keywords have to be used as identifiers, the escape character for [identifiers](#xbase-syntax-escaped-identifiers) comes in handy. 

---

### Types {#xbase-language-ref-types}

Basically all kinds of JVM types are available and referable. 

#### Simple Type References {#xbase-types-type-references}

A simple type reference only consists of a *qualified name*. A qualified name is a name made up of identifiers which are separated by a dot (like in Java).

There is no parser rule for a simple type reference, as it is expressed as a parameterized type references without parameters.

##### Examples

*   `java.lang.String`
*   `String`

#### Parameterized Type References {#xbase-types-parameterized-type-reference}

The general syntax for type references allows to take any number of type arguments. The semantics as well as the syntax is almost the same as in Java, so please refer to the third edition of the [Java Language Specification](http://docs.oracle.com/javase/specs/jls/se7/html/index.html).

The only difference is that in Xbase a type reference can also be a function type. In the following the full syntax of type references is shown, including function types and type arguments.

##### Examples

*   `String`
*   `java.lang.String`
*   `List<?>`
*   `List<? extends Comparable<? extends FooBar>`
*   `List<? super MyLowerBound>`
*   `List<? extends =>Boolean>`

#### Primitives {#xbase-types-primitives}

Xbase supports all Java primitives. The conformance rules (e.g. boxing and unboxing) are also exactly like defined in the Java Language Specification.

#### Arrays {#xbase-types-arrays}

Arrays cannot be instantiated arbitrarily, but there are a couple of useful library functions that allow to create arrays with a fixed length or an initial value set. Besides this restriction, they can be passed around and they are transparently converted to a List of the component type on demand.

In other words, the return type of a Java method that returns an array of ints (`int[]`) can be directly assigned to a variable of type [List\<Integer\>]({{site.javadoc.java}}/java/util/List.html). Due to type inference this conversion happens implicitly. The conversion is bi-directional: Any method that takes an array as argument can be invoked with an argument that has the type `List<ComponentType>` instead.

#### Function Types {#xbase-types-function-types}

Xbase introduces *lambda expressions*, and therefore an additional function type signature. On the JVM-Level a lambda expression (or more generally any function object) is just an instance of one of the types in [Functions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Functions.java), depending on the number of arguments. However, as lambda expressions are a very important language feature, a special sugared syntax for function types has been introduced. So instead of writing `Function1<String, Boolean>` one can write `(String)=>boolean`.

For more information on lambda expressions see [the corresponding section](#xbase-expressions-lambda).

##### Examples

*   `=>Boolean // predicate without parameters`
*   `()=>String // provider of string`
*   `(String)=>boolean // One argument predicate`
*   `(Mutable)=>void // A procedure doing side effects only`
*   `(List<String>, Integer)=>String`

#### Conformance and Conversion {#xbase-types-conformance-rules}

Type conformance rules are used in order to find out whether some expression can be used in a certain situation. For instance when assigning a value to a variable, the type of the right hand expression needs to conform to the type of the variable.

As Xbase implements the type system of Java it also fully supports the conformance rules defined in the [Java Language Specification](http://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html).

Some types in Xbase can be used synonymously even if they do not conform to each other in Java. An example for this are arrays and lists or function types with compatible function parameters. Objects of these types are implicitly converted by Xbase on demand. 

#### Common Super Type {#xbase-types-common-super-type}

Because of type inference Xbase sometimes needs to compute the most common super type of a given set of types. 

For a set *\[T1,T2,...Tn\]* of types the common super type is computed by using the linear type inheritance sequence of *T1* and is iterated until one type conforms to each *T2,..,Tn*. The linear type inheritance sequence of *T1* is computed by ordering all types which are part if the type hierarchy of *T1* by their specificity. A type *T1* is considered more specific than *T2* if *T1* is a subtype of *T2*. Any types with equal specificity will be sorted by the maximal distance to the originating subtype. *CharSequence* has distance 2 to *StringBuilder* because the super type *AbstractStringBuilder* implements the interface, too. Even if *StringBuilder* implements *CharSequence* directly, the interface gets distance 2 in the ordering because it is not the most general class in the type hierarchy that implements the interface. If the distances for two classes are the same in the hierarchy, their qualified name is used as the compare-key to ensure deterministic results. 

---

### Expressions {#xbase-language-ref-expressions}

Expressions are the main language constructs which are used to express behavior and compute values. The concept of statements is not supported, but instead powerful expressions are used to handle situations in which the imperative nature of statements would be helpful. An expression always results in a value (it might be the value `null` or of type `void` though). In addition, every resolved expression is of a static type.

#### Literals {#xbase-expressions-literals}

A literal denotes a fixed unchangeable value. Literals for strings, numbers, booleans, `null` and Java types are supported. Additionally, there exists a literal syntax for collections and arrays.

##### String Literals {#xbase-expressions-string-literal}

String literals can either use `'single quotes'` or `"double quotes"` as their terminating characters. When using double quotes all literals allowed by Java string literals are supported. In addition new line characters are allowed, i.e. in Xbase string literals can span multiple lines. When using single quotes the only difference is that single quotes within the literal have to be escaped and double quotes do not.

See [§ 3.10.5 String Literals](http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10.5)

In contrast to Java, equal string literals within the same class do not necessarily refer to the same instance at runtime, especially in the interpreted mode.

##### Examples

*   `'Foo Bar Baz'`
*   `"Foo Bar Baz"`
*       
    
    ```xbase
"the quick brown fox
    jumps over the lazy dog."
    ```

*   `'Escapes : \' '`
*   `"Escapes : \" "`

##### Number Literals {#xbase-expressions-number-literal}

Xbase supports roughly the same number literals as Java with a few notable differences. As in Java 7, you can separate digits using `_` for better readability of large numbers. An integer literal represents an `int`, a `long` (suffix `L`) or even a [BigInteger]({{site.javadoc.java}}/java/math/BigInteger.html) (suffix `BI`). There are no octal number literals.

```xbase
  42
  1_234_567_890 
  0xbeef    // hexadecimal
  077       // decimal 77 (*NOT* octal)
  42L
  0xbeef#L // hexadecimal, mind the '#'
  0xbeef_beef_beef_beef_beef#BI // BigInteger
```

A floating-point literal creates a `double` (suffix `D` or omitted), a `float` (suffix `F`) or a [BigDecimal]({{site.javadoc.java}}/java/math/BigDecimal.html) (suffix `BD`). If you use a `.` sign you have to specify both, the integer and the fractional part of the mantissa. There are only decimal floating-point literals. 

```xbase
  42d     // double
  0.42e2  // implicit double
  0.42e2f // float
  4.2f    // float
  0.123_456_789_123_456_789_123_456_789e2000bd // BigDecimal
```

##### Boolean Literals {#xbase-expressions-boolean-literal}

There are two boolean literals, `true` and `false` which correspond to their Java counterpart of type *boolean*. 

*   `true`
*   `false`

##### Null Literal {#xbase-expressions-null-literal}

The null literal is, as in Java, `null`. It is compatible to any reference type and therefore always of the null type.

*   `null`

##### Type Literals {#xbase-expressions-type-literal}

The syntax for type literals is generally the plain name of the type, e.g. the Xbase snippet `String` is equivalent to the Java code `String.class`. Nested types use the delimiter `'.'`.

To disambiguate the expression, type literals may also be specified using the keyword `typeof`.

*   `Map.Entry` is equivalent to `Map.Entry.class`
*   `typeof(StringBuilder)` yields `StringBuilder.class`

Consequently it is possible to access the members of a type reflectively by using its plain name `String.getDeclaredFields`.

Previous versions of Xbase used the dollar as the delimiter character for nested types:

*   `typeof(Map$Entry)` yields `Map.Entry.class`

#### Type Casts {#xbase-expressions-type-casts}

Type cast behave the same as in Java, but have a more readable syntax. Type casts bind stronger than any other operator but weaker than feature calls.

The conformance rules for casts are defined in the [Java Language Specification](http://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.5).

##### Examples

*   `my.foo as MyType`
*   `(1 + 3 * 5 * (- 23)) as BigInteger`

#### Infix Operators / Operator Overloading {#xbase-expressions-operators}

There are a couple of common predefined infix operators. In contrast to Java, the operators are not limited to operations on certain types. Instead an operator-to-method mapping allows users to redefine the operators for any type just by implementing the corresponding method signature. The following defines the operators and the corresponding Java method signatures / expressions.

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

The table above also defines the operator precedence in ascending order. The blank lines separate precedence levels. The assignment operator `+=` is right-to-left associative in the same way as the plain assignment operator `=` is. Consequently, `a = b = c` is executed as `a = (b = c)`. All other operators are left-to-right associative. Parentheses can be used to adjust the default precedence and associativity. 

##### Short-Circuit Boolean Operators

If the operators `||` and `&&` are used in a context where the left hand operand is of type boolean, the operation is evaluated in short circuit mode, which means that the right hand operand is not evaluated at all in the following cases: 

1.  in the case of `||` the operand on the right hand side is not evaluated if the left operand evaluates to `true`.
1.  in the case of `&&` the operand on the right hand side is not evaluated if the left operand evaluates to `false`.

##### Examples

*   `my.foo = 23`
*   `myList += 23`
*   `x > 23 && y < 23`
*   `x && y || z`
*   `1 + 3 * 5 * (- 23)`
*   `!(x)`
*   `my.foo = 23`
*   `my.foo = 23`

##### Assignment Operators

Compound assignment operators can be used as a shorthand for the assignment of a binary expression.

```xtend
var BigDecimal bd = 45bd
bd += 12bd // equivalent to bd = bd + 12bd
bd -= 12bd // equivalent to bd = bd - 12bd
bd /= 12bd // equivalent to bd = bd / 12bd
bd *= 12bd // equivalent to bd = bd * 12bd
```

Compound assignments work automatically if the binary operator is declared. The following compound assignment operators are supported:

|:---|:---|
|`e1 += e2`|`+`|
|`e1 -= e2`|`-`|
|`e1 *= e2`|`*`|
|`e1 /= e2`|`/`|
|`e1 %= e2`|`%`|

##### Postfix Operators

The two postfix operators `++` and `--` use the following method mapping:

|:---|:---|
|`e1++`|`e1.operator_plusPlus()`|
|`e1--`|`e1.operator_minusMinus()`|

##### With Operator

The *with* operator `=>` executes the [lambda expression](#xbase-expressions-lambda) with a single parameter on the right-hand side with a given argument on its left-hand side. The result is the left operand after applying the lambda expression. In combination with the [implicit parameter](#xbase-expressions-implicit-parameter)`it` this allows very convenient initialization of newly created objects. Example:

```xbase
  val person = new Person => [
    firstName = 'John'
    lastName = 'Coltrane'
  ]
  // equivalent to
  val person = new Person
  person.firstName = 'John'
  person.lastName = 'Coltrane'
```

#### Assignments {#xbase-expressions-property-assignment}

[Local variables](#xbase-expressions-variable-declaration) can be reassigned using the `=` operator. Also properties can be set using that operator: Given the expression 

```xbase
  myObj.myProperty = "foo"
```

The compiler first looks for an accessible Java Field called `myProperty` on the declared or inferred type of `myObj`. If such a field can be found, the expressions translates to the following Java code:

```java
  myObj.myProperty = "foo";
```

Remember, in Xbase everything is an expression and has to return something. In the case of simple assignments the return value is the value returned from the corresponding Java expression, which is the assigned value.

If there is no accessible field on the left operand's type, a method called `setMyProperty(OneArg)` (JavaBeans setter method) is looked up. It has to take one argument of the type (or a super type) of the right hand operand. The return value of the assignment will be the return value of the setter method (which is usually of type `void` and therefore the value `null`). As a result the compiler translates to :

```java
  myObj.setMyProperty("foo")
```

#### Feature Calls {#xbase-expressions-feature-calls}

A feature call is used to access members of objects, such as fields and methods, but it can also refer to local variables and parameters, which are made available by the current expression's scope. 

##### Property Access {#xbase-expressions-property-access}

Feature calls are directly translated to their Java equivalent with the exception, that access to properties follows similar rules as described in [the previous section](#xbase-expressions-property-assignment). That is, for the expression

```xbase
  myObj.myProperty
```

the compiler first looks for an accessible field `myProperty` in the type of `myObj`. If no such field exists it tries to find a method called `myProperty()` before it looks for the getter methods `getMyProperty()`. If none of these members can be found, the expression is unbound and a compilation error is indicated.

##### Null-Safe Feature Call {#xbase-expressions-null-safe-feature-calls}

Checking for null references can make code very unreadable. In many situations it is ok for an expression to return `null` if a receiver was `null`. Xbase supports the safe navigation operator `?.` to make such code more readable.

Instead of writing 

```java
  if ( myRef != null ) myRef.doStuff()
```

one can write

```xbase
  myRef?.doStuff()
```

##### Static Feature Calls {#xbase-expressions-static-feature-calls}

Static feature calls use the same notation as in Java, e.g. it is possible write `Collections.emptyList()` in Xbase. To make the static invocation more explicit, the double colon can be used as the delimiter. The following snippets are fully equivalent:

```xbase
   java.util.Collections::emptyList
```

```xbase
   java.util.Collections.emptyList
```

Prior to Xbase 2.4.2, this more verbose variant was the only supported syntax to invoke static methods:

```xbase
   java::util::Collections::emptyList
```

#### Implicit variables 'this' and 'it' {#xbase-expressions-implicit-this}

If the current scope contains a variable named `this` or `it`, the compiler will make all its members available implicitly. That is if one of 

```xbase
  it.myProperty
  this.myProperty
```

is a valid expression 

```xbase
  myProperty
```

is valid as well. It resolves to the same feature as long as there is no local variable `myProperty` declared, which would have higher precedence. 

As `this` is bound to the surrounding object in Java, `it` can be used in finer-grained constructs such as function parameters. That is why `it.myProperty` has higher precedence than `this.myProperty`. `it` is also the [default parameter name in lambda expressions](#xbase-expressions-implicit-parameter). 

#### Constructor Call {#xbase-expressions-constructor-call}

Construction of objects is done by invoking Java constructors. The syntax is exactly as in Java.

##### Examples

*       
    
    ```xbase
      new String()
    ```

*       
    
    ```xbase
      new java.util.ArrayList<java.math.BigDecimal>()
    ```

#### Lambda Expressions {#xbase-expressions-lambda}

A lambda expression is a literal that defines an anonymous function. Xbase' lambda expressions are allowed to access variables of the declarator. Any final variables and parameters visible at construction time can be referred to in the lambda expression's body. These expressions are also known as closures.

Lambda expressions are surrounded by square brackets (\`[]`):

```xbase
  myList.findFirst([ e | e.name==null ])
```

When a function object is expected to be the last parameter of a feature call, you may declare the lambda expression after the parentheses: 

```xbase
  myList.findFirst() [ e | e.name==null ]
```

Since in Xbase parentheses are optional for method calls, the same can be written as:

```xbase
  myList.findFirst[ e | e.name==null ]
```

This example can be further simplified since the lambda's parameter is available as the implicit variable `it`, if the parameter is not declared explicitly: 

```xbase
  myList.findFirst[ it.name==null ]
```

Since `it` is implicit, this is the same as:

```xbase
  myList.findFirst[ name==null ]
```

Another use case for lambda expressions is to store function objects in variables:

```xbase
  val func = [ String s | s.length>3 ]
```

##### Typing {#xbase-expressions-lambda-type-inference}

Lambda expressions produce function objects. The type is a [function type](#xbase-types-function-types), parameterized with the types of the lambda's parameters as well as the return type. The return type is never specified explicitly but is always inferred from the expression. The parameter types can be inferred if the lambda expression is used in a context where this is possible.

For instance, given the following Java method signature: 

```java
  public T <T>getFirst(List<T> list, Function0<T,Boolean> predicate) 
```

the type of the parameter can be inferred. Which allows users to write: 

```xbase
  newArrayList( "Foo", "Bar" ).findFirst[ e | e == "Bar" ]
```

instead of 

```xbase
  newArrayList( "Foo", "Bar" ).findFirst[ String e | e == "Bar" ]
```

##### Function Mapping {#xbase-expressions-function-mapping}

An Xbase lambda expression is a Java object of one of the *Function* interfaces that are part of the runtime library of Xbase. There is an interface for each number of parameters (up to six parameters). The names of the interfaces are 

*   [Function0\<ReturnType\>]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Functions.java) for zero parameters, 
*   [Function1\<Param1Type, ReturnType\>]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Functions.java) for one parameters, 
*   [Function2\<Param1Type, Param2Type, ReturnType\>]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Functions.java) for two parameters, 
*   ... 
*   [Function6\<Param1Type, Param2Type, Param3Type, Param4Type, Param5Type, Param6Type, ReturnType\>]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Functions.java) for six parameters, 

or 

*   [Procedure0]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Procedures.java) for zero parameters, 
*   [Procedure1\<Param1Type\>]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Procedures.java) for one parameters, 
*   [Procedure2\<Param1Type, Param2Type\>]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Procedures.java) for two parameters, 
*   ... 
*   [Procedure6\<Param1Type, Param2Type, Param3Type, Param4Type, Param5Type, Param6Type\>]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/Procedures.java) for six parameters, 

if the return type is `void`.

In order to allow seamless integration with existing Java libraries such as the JDK or Google Guava (formerly known as Google Collect) lambda expressions are auto coerced to expected types if those types declare only one abstract method (methods from `java.lang.Object` don't count).

As a result given the method [Collections.sort(List\<T\>, Comparator\<? super T\>)]({{site.javadoc.java}}/java/util/Collections.html) is available as an extension method, it can be invoked like this

```xbase
newArrayList( 'aaa', 'bb', 'c' ).sort [
  e1, e2 | if ( e1.length > e2.length ) {
        -1 
       } else if ( e1.length < e2.length ) { 
        1
       } else { 
        0
       }
]
```

##### Implicit Parameter *it* {#xbase-expressions-implicit-parameter}

If a lambda expression has a single parameter whose type can be inferred, the declaration of the parameter can be omitted. Use `it` to refer to the parameter inside the lambda expression's body. 

```xbase
val (String s)=>String function = [ toUpperCase ] 
  // equivalent to [it | it.toUpperCase]
```

##### Examples

*   `[ | "foo" ]   // lambda expression without parameters`
*   `[ String s | s.toUpperCase() ] // explicit argument type`
*   `[ a, b, c | a+b+c ] // inferred argument types`

##### Refering the current function {#xbase-lambda-self}

If a lambda expressions implements an abstract SAM type that offers additional methods, those can be accessed on the receiver `self`: 

```xbase
val AbstractIterator<String> emptyIterator = [
	return self.endOfData
] 
```

#### If Expression {#xbase-expressions-if-expression}

An if expression is used to choose two different values based on a predicate. While it has the syntax of Java's if statement it behaves like Java's ternary operator (`predicate ? thenPart : elsePart`), i.e. it is an expression that returns a value. Consequently, you can use if expressions deeply nested within other expressions.

An expression `if (p) e1 else e2` results in either the value `e1` or `e2` depending on whether the predicate `p` evaluates to `true` or `false`. The else part is optional which is a shorthand for a default value, e.g `else null` if the type of the `if` expression is a reference type. If the type is a primitive type, its default value is assumed accordingly, e.g. `else false` for `boolean` or `else 1` for numbers. 

That means 

```xbase
  if (foo) x 
```

is the a short hand for

```xbase
  if (foo) x else null
```

##### Typing {#xbase-expressions-if-type-inference}

The type of an `if` expression is calculated from the types `T1` and `T2` of the two expression `e1` and `e2`. It uses the rules defined in the [common super types](#xbase-types-common-super-type) section, if an explicit `else` branch is given. If it is ommitted, the type of the `if` expression is the type `T` of the expression `e` of the form `if (b) e`.

##### Examples

*   `if (isFoo) this else that`
*   `if (isFoo) { this } else if (thatFoo) { that } else { other }`
*   `if (isFoo) this`

#### Switch Expression {#xbase-expressions-switch-expression}

The switch expression is a bit different from Java's, as the use of switch is not limited to certain values but can be used for any object reference instead. For a switch expression 

```xbase
switch e {
  case e1 : er1
  case e2 : er2
  ...
  case en : ern
  default : er
}
```

the main expression `e` is evaluated first and then each case sequentially. If the switch expression contains a variable declaration using the syntax known from [for loops](#xbase-expressions-for-loop), the value is bound to the given name. Expressions of type [Boolean]({{site.javadoc.java}}/java/lang/Boolean.html) or `boolean` are not allowed in a switch expression.

The guard of each case clause is evaluated until the switch value equals the result of the case's guard expression or if the case's guard expression evaluates to `true`. Then the right hand expression of the case evaluated and the result is returned.

If none of the guards matches the default expression is evaluated and returned. If no default expression is specified the expression evaluates to the default value of the common type of all available case expressions. 

Example:

```xbase
switch myString {
  case myString.length>5 : 'a long string.'
  case 'foo' : "It's a foo."
  default : "It's a short non-foo string."
}
```

##### Type guards

In addition to the case guards one can add a so called *Type Guard* which is syntactically just a [type reference](#xbase-types-type-references) preceding the than optional case keyword. The compiler will use that type for the switch expression in subsequent expressions. Example: 

```xbase
var Object x = ...;
switch x {
  String case x.length()>0 : x.length()
  List<?> : x.size()
  default : -1
}
```

Only if the switch value passes a type guard, i.e. an `instanceof` test succeeds, the case's guard expression is executed using the same semantics as explained above. If the switch expression contains an explicit declaration of a local variable or the expression references a local variable, the type guard works like an automated cast. All subsequent references to the switch value will be of the type specified in the type guard, unless it is reassigned to a new value.

##### Fall Through

One can have multiple *type guards* and *cases* separated with a comma, to have all of them share the same *then-expression*.

```xtend
  def isMale(String salutation) {
    switch salutation {
      case "Mr.", 
      case "Sir" : true
      default : false
    }
  }
```

##### Typing

The type of a switch expression is computed using the rules defined in the section on [common super types](#xbase-types-common-super-type). The set of types from which the common super type is computed corresponds to the types of each case expression.

##### Examples

*       
    
    ```xbase
      switch foo {
        Entity : foo.superType.name
        Datatype : foo.name
        default : throw new IllegalStateException
      }
    ```

*       
    
    ```xbase
      switch x : foo.bar.complicated('hello', 42) {
        case "hello42" : ...
        case x.length<2 : ...
        default : ...
      }
    ```

#### Variable Declarations {#xbase-expressions-variable-declaration}

Variable declarations are only allowed within [blocks](#xbase-expressions-blocks). They are visible in any subsequent expressions in the block. Generally, overriding or shadowing variables from outer scopes is not allowed. However, it can be used to overload the [implicit variable](#xbase-expressions-implicit-this) `it`, in order to subsequently access an object's features in an unqualified manner.

A variable declaration starting with the keyword `val` denotes an unchangeable value, which is essentially a final variable. In rare cases, one needs to update the value of a reference. In such situations the variable needs to be declared with the keyword `var`, which stands for variable.

A typical example for using `var` is a counter in a loop. 

```xbase
{
  val max = 100
  var i = 0
  while (i > max) {
    println("Hi there!")
    i = i +1
  }
}
```

Variables declared outside a lambda expression using the `var` keyword are not accessible from within a the lambda expression.

##### Typing

The type of a variable declaration expression is always `void`. The type of the variable itself can either be explicitly declared or be inferred from the right hand side expression. Here is an example for an explicitly declared type: 

```xbase
  var List<String> strings = new ArrayList<String>(); 
```

In such cases, the right hand expression's type must [conform](#xbase-types-conformance-rules) to the type on the left hand side. 

Alternatively the type can be left out and will be inferred from the initialization expression: 

```xbase
  var strings = new ArrayList<String> // -> strings is of type ArrayList<String>  
```

#### Blocks {#xbase-expressions-blocks}

The block expression allows to have imperative code sequences. It consists of a sequence of expressions, and returns the value of the last expression. The type of a block is also the type of the last expression. Empty blocks return `null`. [Variable declarations](#xbase-expressions-variable-declaration) are only allowed within blocks and cannot be used as a block's last expression.

A block expression is surrounded by curly braces and contains at least one expression. It can optionally be terminated by a semicolon.

##### Examples

```xbase
{
  doSideEffect("foo")
  result
}
```

```xbase
{
  var x = greeting();
  if (x.equals("Hello ")) {
    x+"World!"; 
  } else {
    x;
  }
}
```

#### For Loop {#xbase-expressions-for-loop}

The for loop `for (T1 variable : iterableOfT1) expression` is used to execute a certain expression for each element of an array of an instance of [Iterable]({{site.javadoc.java}}/java/lang/Iterable.html). The local `variable` is final, hence cannot be updated. 

The type of a for loop is `void`. The type of the local variable can optionally be inferred from the type of the array or the element type of the [Iterable]({{site.javadoc.java}}/java/lang/Iterable.html) returned by the iterable expression.

*       
    
    ```xbase
      for (String s : myStrings) {
        doSideEffect(s);
      }
    ```

*       
    
    ```xbase
      for (s : myStrings)
        doSideEffect(s)
    ```

#### Basic For Loop {#xbase-expressions-basic-for-loop}

The traditional for loop is very similar to the one known from Java, or even C. 

```xtend
  for (<init-expression> ;  <predicate> ; <update-expression>) body-expression
```

When executed, it first executes the `init-expression`, where local variables can be declared. Next the `predicate` is executed and if it evaluates to `true`, the `body-expression` is executed. On any subsequent iterations the `update-expressio` is executed instead of the init-expression. This happens until the `predicate` returns `false`.

The type of a for loop is `void`.

```xtend
  for (val i = 0 ; i < s.length ; i++) {
    println(s.subString(0,i)
  }
```

#### While Loop {#xbase-expressions-while-expression}

A while loop `while (predicate) expression` is used to execute a certain expression unless the predicate is evaluated to `false`. The type of a while loop is `void`.

##### Examples

*       
    
    ```xbase
      while (true) {
        doSideEffect("foo");
      }
    ```

*       
    
    ```xbase
      while ( ( i = i + 1 ) < max ) 
        doSideEffect( "foo" )
    ```

#### Do-While Loop {#xbase-expressions-do-while-expression}

A do-while loop `do expression while (predicate)` is used to execute a certain expression until the predicate is evaluated to `false`. The difference to the [while loop](#xbase-expressions-while-expression) is that the execution starts by executing the block once before evaluating the predicate for the first time. The type of a do-while loop is `void`.

##### Examples

*       
    
    ```xbase
      do {
        doSideEffect("foo");
      } while (true)
    ```

*       
    
    ```xbase
      do doSideEffect("foo") while ((i=i+1)<max)
    ```

#### Return Expression {#xbase-expressions-return}

Although an explicit return is often not necessary, it is supported. In a lambda expression for instance a return expression is always implied if the expression itself is not of type `void`. Anyway you can make it explicit:

```xbase
  listOfStrings.map [ e |
    if (e==null) 
      return "NULL"
    e.toUpperCase
  ]
```

#### Throwing Exceptions {#xbase-expressions-throw}

It is possible to throw [Throwable]({{site.javadoc.java}}/java/lang/Throwable.html). The syntax is exactly the same as in Java.

```xbase
{
  ...
  if (myList.isEmpty)
    throw new IllegalArgumentException("the list must not be empty")
  ...
}   
```

#### Try, Catch, Finally {#xbase-expressions-try-catch}

The try-catch-finally expression is used to handle exceptional situations. You are not forced to declare checked exceptions. If you don't catch checked exceptions, they are thrown in a way the compiler does not complain about a missing throws clause, using the sneaky-throw technique introduced by [Lombok](http://projectlombok.org/features/SneakyThrows.html).

```xbase
  try {
    throw new RuntimeException()
  } catch (NullPointerException e) {
    // handle e
  } finally {
    // do stuff
  }
```

#### Synchronized {#xbase-expressions-synchronized}

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

---

### Extension Methods {#xbase-language-ref-library-extension}

Languages extending Xbase might want to contribute to the feature scope. Besides that, one can of course change the whole implementation as it seems fit. There is a special hook, which can be used to add so-called extension methods to existing types. 

Xbase itself comes with a standard library of such extension methods adding support for various operators for the common types, such as [String]({{site.javadoc.java}}/java/lang/String.html), [List]({{site.javadoc.java}}/java/util/List.html), etc.

These extension methods are declared in separate Java classes. There are various ways how extension methods can be added. In the simplest case the language designer predefines which extension methods are available. Language users cannot add additional library functions using this mechanism.

Another alternative is to have them looked up by a certain naming convention. Also for more general languages it is possible to let users add extension methods using imports or similar mechanisms. This approach can be seen in the language [Xtend](http://www.xtend-lang.org), where extension methods are lexically imported through static imports and/or dependency injection.

The precedence of extension methods is always lower than real member methods, i.e. you cannot override member features. Also the extension members are not invoked polymorphic. If you have two extension methods on the scope (`foo(Object)` and `foo(String)`) the expression `(foo as Object).foo` would bind and invoke `foo(Object)`.

#### Examples

*   `foo`
*   `my.foo`
*   `my.foo(x)`
*   `oh.my.foo(bar)`

#### Builder Syntax {#xbase-language-ref-builder-syntax}

If the last argument of a method call is a lambda expression, it can be appended to the method call. Thus,

```xbase
foo(42) [ String s | s.toUpperCase ]   
```

will call a Java method with the signature

```java
void foo(int, Function1<String, String>)
```

Used in combination with the [implicit parameter name in lambda expressions](#xbase-expressions-implicit-parameter) you can write [extension libraries](#xbase-language-ref-library-extension) to create and initialize graphs of objects in a concise builder syntax like in Groovy. Consider you have a set of library methods 

```java
HtmlNode html(Function1<HtmlNode, Void> initializer)
HeadNode head(HtmlNode parent, Function1<HeadNode, Void> initializer)
...
```

that create DOM elements for HTML pages inside their respective parent elements. You can then create a DOM using the following Xbase code:

```xbase
html([ html |
  head(html, [ 
    // initialize head
  ]) 
] )
```

Appending the lambda expression parameters and prepending the parent parameters using extension syntax yields 

```xbase
html() [ html |
  html.head() [ 
    // initialize head
  ]  
] 
```

Using implicit parameter `it` and skipping empty parentheses you can simplify this to 

```xbase
html [ 
  head [ 
    // initialize head
  ]  
] 
```

---

**[Next Chapter: MWE2](306_mwe2.html)**
