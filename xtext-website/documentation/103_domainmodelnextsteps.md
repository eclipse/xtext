---
layout: documentation
title: 15 Minutes Tutorial - Extended
part: Getting Started
---

# {{page.title}} {#domainmodel-next-steps}

After you have developed you first own DSL, the question arises how the behavior and the semantics of the language can be customized. Here you find a few mini-tutorials that illustrate common use cases when crafting an own DSL. These lessons are independent from each other. Each of them will be based on the language that was built in the first [domain model tutorial](102_domainmodelwalkthrough.html).

## Writing a Code Generator With Xtend {#tutorial-code-generation}

As soon as you generate the Xtext artifacts for a grammar, a code generator stub is put into the runtime project of your language. Let's dive into Xtend and see how you can integrate your own code generator with Eclipse.

In this lesson you will generate Java Beans for entities that are defined in the domain model DSL. For each *Entity*, a Java class is generated and each *Feature* will lead to a private field in that class including public getters and setters. For the sake of simplicity, we will use fully qualified names all over the generated code.

```java
package my.company.blog;

public class HasAuthor {
    private java.lang.String author;
    
    public java.lang.String getAuthor() {
        return author;
    }
    
    public void setAuthor(java.lang.String author) {
        this.author = author;
    }
}
```

First of all, locate the file *DomainmodelGenerator.xtend* in the package *org.example.domainmodel.generator*. This Xtend class is used to generate code for your models in the standalone scenario and in the interactive Eclipse environment. Let's make the implementation more meaningful and start writing the code generator. The strategy is to find all entities within a resource and trigger code generation for each one.

1.  First of all, you will have to filter the contents of the resource down to the defined entities. Therefore we need to iterate a resource with all its deeply nested elements. This can be achieved with the method `getAllContents()`. To use the resulting [TreeIterator]({{site.src.emf}}/plugins/org.eclipse.emf.common/src/org/eclipse/emf/common/util/TreeIterator.java) in a `for` loop, we use the extension method `toIterable()` from the built-in library class [IteratorExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/IteratorExtensions.java).     
    
    ```xtend
    class DomainmodelGenerator implements IGenerator {
        override void doGenerate(Resource resource, IFileSystemAccess fsa) {
            for (e : resource.allContents.toIterable.filter(Entity)) {
                
            }
        }
    }
    ```

1.  Now let's answer the question how we determine the file name of the Java class that each *Entity* should yield. This information should be derived from the qualified name of the *Entity* since Java enforces this pattern. The qualified name itself has to be obtained from a special service that is available for each language. Fortunately, Xtend allows to reuse that one easily. We simply inject the [IQualifiedNameProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/naming/IQualifiedNameProvider.java) into the generator.     
    
    ```xtend
      @Inject extension IQualifiedNameProvider
    ```

    This allows to ask for the name of an entity. It is straightforward to convert the name into a file name:     
    
    ```xtend
    override void doGenerate(Resource resource, IFileSystemAccess fsa) {
        for (e : resource.allContents.toIterable.filter(Entity)) {
            fsa.generateFile(
                e.fullyQualifiedName.toString("/") + ".java",
                e.compile)
        }
    }
    ```

1.  The next step is to write the actual template code for an entity. For now, the function `Entity.compile` does not exist, but it is easy to create it:     
    
    ```xtend
    def compile(Entity e) '''
        package «e.eContainer.fullyQualifiedName»;
        
        public class «e.name» {
        }
    '''
    ```

1.  This small template is basically the first shot at a Java-Beans generator. However, it is currently rather incomplete and will fail if the *Entity* is not contained in a package. A small modification fixes this. The `package` declaration has to be wrapped in an `IF` expression:     
    
    ```xtend
    def compile(Entity e) '''
        «IF e.eContainer.fullyQualifiedName != null»
            package «e.eContainer.fullyQualifiedName»;
        «ENDIF»
        
        public class «e.name» {
        }
    '''
    ```

    Let's handle the *superType* of an *Entity* gracefully, too, by using another `IF` expression:     
    
    ```xtend
    def compile(Entity e) ''' 
        «IF e.eContainer.fullyQualifiedName != null»
            package «e.eContainer.fullyQualifiedName»;
        «ENDIF»
        
        public class «e.name» «IF e.superType != null
                »extends «e.superType.fullyQualifiedName» «ENDIF»{
        }
    '''
    ```

1.  Even though the template will compile the *Entities* without any complaints, it still lacks support for the Java properties that each of the declared features should yield. For that purpose, you have to create another Xtend function that compiles a single feature to the respective Java code.
    
    ```xtend
    def compile(Feature f) '''
        private «f.type.fullyQualifiedName» «f.name»;
        
        public «f.type.fullyQualifiedName» get«f.name.toFirstUpper»() {
            return «f.name»;
        }
        
        public void set«f.name.toFirstUpper»(«f.type.fullyQualifiedName» «f.name») {
            this.«f.name» = «f.name»;
        }
    '''
    ```

    As you can see, there is nothing fancy about this one. Last but not least, we have to make sure that the function is actually used.     
    
    ```xtend
    def compile(Entity e) ''' 
        «IF e.eContainer.fullyQualifiedName != null»
            package «e.eContainer.fullyQualifiedName»;
        «ENDIF»
        
        public class «e.name» «IF e.superType != null
                »extends «e.superType.fullyQualifiedName» «ENDIF»{
            «FOR f:e.features»
                «f.compile»
            «ENDFOR»
        }
    '''
    ```

The final code generator is listed below. Now you can give it a try! Launch a new Eclipse Application (*Run As &rarr; Eclipse Application* on the Xtext project) and create a *dmodel* file in a Java Project. Now simply create a new source folder *src-gen* in the that project and see how the compiler will pick up your sample *Entities* and generate Java code for them. 

```xtend
package org.example.domainmodel.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.example.domainmodel.domainmodel.Entity
import org.example.domainmodel.domainmodel.Feature
import org.eclipse.xtext.naming.IQualifiedNameProvider

import com.google.inject.Inject

class DomainmodelGenerator implements IGenerator {

    @Inject extension IQualifiedNameProvider

    override void doGenerate(Resource resource, IFileSystemAccess fsa) {
        for (e : resource.allContents.toIterable.filter(Entity)) {
            fsa.generateFile(
                e.fullyQualifiedName.toString("/") + ".java",
                e.compile)
        }
    }

    def compile(Entity e) ''' 
        «IF e.eContainer.fullyQualifiedName != null»
            package «e.eContainer.fullyQualifiedName»;
        «ENDIF»
        
        public class «e.name» «IF e.superType != null
                »extends «e.superType.fullyQualifiedName» «ENDIF»{
            «FOR f : e.features»
                «f.compile»
            «ENDFOR»
        }
    '''

    def compile(Feature f) '''
        private «f.type.fullyQualifiedName» «f.name»;
        
        public «f.type.fullyQualifiedName» get«f.name.toFirstUpper»() {
            return «f.name»;
        }
        
        public void set«f.name.toFirstUpper»(«f.type.fullyQualifiedName» «f.name») {
            this.«f.name» = «f.name»;
        }
    '''
}
```

If you want to play around with Xtend, you can try to use the Xtend tutorial which can be materialized into your workspace. Simply choose *New &rarr; Example &rarr; Xtend Examples &rarr; Xtend Introductory Examples* and have a look at the features of Xtend. As a small exercise, you could implement support for the *many* attribute of a *Feature* or enforce naming conventions, e.g. generated field names should start with an underscore.

## Unit Testing the Language {#tutorial-unit-tests}

Automated tests are crucial for the maintanability and the quality of a software product. That is why it is strongly recommended to write unit tests for your language, too. The Xtext project wizard creates two test projects for that purpose. These simplify the setup procedure for testing the basic language features and the Eclipse UI integration.

This tutorial is about testing the parser and the linker for the *Domainmodel*. It leverages Xtend to write the test case.

1.  The core of the test infrastructure is the [XtextRunner]({{site.src.xtext}}/plugins/org.eclipse.xtext.junit4/src/org/eclipse/xtext/junit4/XtextRunner.java) and the language-specific [IInjectorProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext.junit4/src/org/eclipse/xtext/junit4/IInjectorProvider.java). Both have to be provided by means of class annotations. An example test class should have already been generated by the Xtext code generator, named *org.example.domainmodel.tests.DomainmodelParsingTest*:
    
    ```xtend
    @RunWith(XtextRunner)
    @InjectWith(DomainmodelInjectorProvider)
    class DomainmodelParsingTest{
    
        @Inject
        ParseHelper<Domainmodel> parseHelper
    
        @Test 
        def void loadModel() {
            val result = parseHelper.parse('''
                Hello Xtext!
            ''')
            Assert.assertNotNull(result)
        }
    
    }
    ```

1.  The utility class [ParseHelper]({{site.src.xtext}}/plugins/org.eclipse.xtext.junit4/src/org/eclipse/xtext/junit4/util/ParseHelper.java) allows to parse an arbitrary string into a *Domainmodel*. The model itself can be traversed and checked afterwards. A static import of [Assert]({{site.javadoc.junit}}/org/junit/Assert.html) leads to concise and readable test cases. You can rewrite the generated example as follows:
    
    ```xtend
    import static org.junit.Assert.*
    
    ...
    
        @Test 
        def void parseDomainmodel() {
            val model = parser.parse(
                "entity MyEntity {
                    parent: MyEntity
                }")
            val entity = model.elements.head as Entity
            assertSame(entity, entity.features.head.type)
        }
    ```

1.  After saving the Xtend file, it is time to run the test. Select *Run As &rarr; JUnit Test* from the editor's context menu. 

## Creating Custom Validation Rules {#tutorial-validation}

One of the main advantages of DSLs is the possibility to statically validate domain-specific constraints. Because this is a common use case, Xtext provides a dedicated hook for this kind of validation rules. In this lesson, we want to ensure that the name of an *Entity* starts with an upper-case letter and that all features have distinct names across the inheritance relationship of an *Entity*.

Locate the class *DomainmodelValidator* in the package *org.example.domainmodel.validation* of the language project. Defining the constraint itself is only a matter of a few lines of code:

```xtend
@Check
def void checkNameStartsWithCapital(Entity entity) {
    if (!Character.isUpperCase(entity.name.charAt(0))) {
        warning("Name should start with a capital", 
            DomainmodelPackage.Literals.TYPE__NAME)
    }
}
```

Any name for the method will do. The important thing is the [Check]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/validation/Check.java) annotation that advises the framework to use the method as a validation rule. If the name starts with a lower case letter, a warning will be attached to the name of the *Entity*.

The second validation rule is straight-forward, too. We traverse the inheritance hierarchy of the *Entity* and look for features with equal names.

```xtend
@Check
def void checkFeatureNameIsUnique(Feature f) {
    var superEntity = (f.eContainer as Entity).superType
    while (superEntity != null) {
        for (other : superEntity.features) {
            if (f.name == other.name) {
                error("Feature names have to be unique",
                    DomainmodelPackage.Literals.FEATURE__NAME)
                return
            }
        }
        superEntity = superEntity.getSuperType();
    }
}
```

The sibling features that are defined in the same entity are automatically validated by the Xtext framework, thus they do not have to be checked twice. Note that this implementation is not optimal in terms of execution time because the iteration over the features is done for all features of each entity.

---

**[Next Chapter: Five simple steps to your JVM language](104_jvmdomainmodel.html)**