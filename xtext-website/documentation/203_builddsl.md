---
layout: documentation
title: Build Language
part: Seven JVM Languages Built With Xbase
---

# {{page.title}} {#builddsl}

Build tools like Ant or [Gradle](http://gradle.org/) decompose the build process into a set of tasks. A task can stand for a compilation step, copying some files, bundling, running tests etc. The order of execution is calculated from the dependencies of the defined tasks.

![](images/builddsl_screenshot.png)

This build language combines the declarative approach of defining tasks and dependencies with the full power of a modern expression language. It is a bit similar to Ant but statically typed and with very good IDE support.

## Overview {#builddsl-solution}

The above screenshot shows an exemplary build script. A script has a couple of parameters. The tasks define dependencies to other tasks. What happens if the task is executed is defined in a block within curly braces. 

A build script can be run from the command line, assigning values to the parameters in the syntax `myscript --<paramName> <value>`. 

We have put most functionality of the language in the runtime library: Detecting the order of execution, parsing parameters, etc. The language itself focusses on the structural parts, and leaves the actions to Xbase. This allows both us and future users to add new tasks as library methods instead of hard-coding them in the language.

## Running the Example {#builddsl-running}

In the runtime workspace, open the *BuildExample.build* in the editor. The example project comes with some sample java code to compile in the *example-project* folder. Choose *Run as &rarr; Build Task* from the context menu of any task to execute it. 

## Grammar {#builddsl-grammar}

The grammar of the DSL is once again quite slim: 

```xtext
grammar org.xtext.builddsl.BuildDSL with org.eclipse.xtext.xbase.Xbase

generate build "http://www.xtext.org/builddsl"

BuildFile:
	("package" name=QualifiedName)?
	importSection=XImportSection?
	declarations+=Declaration*;

Declaration:
	Task | Parameter;

Parameter:
	'param' type=JvmTypeReference? name=ValidID ('=' init=XExpression)?;

Task:
	'task' name=ValidID 
	('depends' depends+=[Task|ValidID] (',' depends+=[Task|ValidID])*)?
	action=XBlockExpression;
```

A *BuildFile* starts with a *package* declaration. The generated Java class will be located in this namespace. The next part is an *importSection*. Since version 2.4, Xbase includes extensive tooling to validate and organize import statements. To make this available in your language, you just have to include an *XImportSection* as in this example. The imports are followed by the *Declarations*. A *Declaration* can be a *Task* or a *Parameter*. A *Parameter* can declare a type and an initialization expression. *Tasks* define dependencies on other tasks by means of an Xtext cross-reference. They also contain an action, which is a [XBlockExpression]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase/emf-gen/org/eclipse/xtext/xbase/XBlockExpression.java) from Xbase, thus everthing is possible within a task.

## Translation to Java {#builddsl-inferrer}

For each *BuildFile* we create a Java class that extends the library class [BuildScript]({{site.src.sevenlang}}/languages/org.xtext.builddsl.lib/src/org/xtext/builddsl/lib/BuildScript.xtend). We generate a main method allowing to execute the script as a Java application with command line parameters. The use of `System.exit` allows to return error codes to the caller. 

*   DSL:
    
    ```builddsl
    package sample
    ```
*   Java:
    
    ```java
    package sample;
    ...
    public class SimpleBuild extends BuildScript {
    ...
      public static void main(final String... args) {
        SimpleBuild script = new SimpleBuild();
        if (script.showHelp(args)) {
          System.exit(HELP);
        }
        System.exit(script.doBuild(args));
      }
    ...
    }
    ```

The respective inferrer code looks like this: 

```xtend
class BuildDSLJvmModelInferrer extends AbstractModelInferrer {

  @Inject extension JvmTypesBuilder

  def dispatch void infer(BuildFile file, 
                          extension IJvmDeclaredTypeAcceptor acceptor, 
                          boolean isPreIndexingPhase) {
    val qualifiedName = file.javaClassName
    val simpleName = Strings.lastToken(qualifiedName, ".")
    accept(file.toClass(fqn))[
      superTypes += typeRef(BuildScript)
...      
      val stringArray = typeRef(String).addArrayTypeDimension
      members += file.toMethod("main", typeRef(void)) [
        parameters += file.toParameter("args", stringArray)
        varArgs = true
        static = true
        body = '''
          «scriptName» script = new «scriptName»();
          if (script.showHelp(args)) {
            System.exit(HELP);
          }
          System.exit(script.doBuild(args));
        '''
      ]
    ]
...
```

Each *Task* becomes a method in the Java class. A [DependsOn]({{site.src.sevenlang}}/languages/org.xtext.builddsl.lib/src/org/xtext/builddsl/lib/DependsOn.xtend) annotation communicates the dependencies to the runtime. The superclass will scan for such annotations and execute the dependencies in the right order.

*   DSL:
    
    ```builddsl
    task print depends prepare {
      print(name)
    }
    ```
*   Java:
    
    ```java
    @DependsOn("prepare")
    protected void print() {
      InputOutput.<String>print(this.name);
    }
    ```

The annotation part may be interesting, so here is the snippet from the inferrer: 

```xtend
// a method for the actual task body
members += file.tasks.map[ task | toMethod(task.methodName, typeRef(Void.TYPE)) [
  visibility = JvmVisibility.PROTECTED
  annotations += annotationRef(DependsOn, task.depends.map[name])
  body = task.action
  ]
]
```

Finally, we create a field with the [Param]({{site.src.sevenlang}}/languages/org.xtext.builddsl.lib/src/org/xtext/builddsl/lib/Param.xtend) annotation from each *Parameter*. The superclass will make the so marked fields initializable from command line arguments. 

*   DSL:
    
    ```builddsl
    param name = 'World'
    ```
*   Java:
    
    ```java
    @Param
    public String name = "World";
    ```

The type can be skipped. If there is an initialization expression, the parameter's type is inferred from the initialization expression. If that one is missing, too, [String]({{site.javadoc.java}}/java/lang/String.html) is assumed. The Elvis-operator `?:` comes handy for this use case. The different sources are tried to find the best type for the field. In the inferrer, this looks like:

```xtend
@Inject ITypeProvider typeProvider
...
val type = declaredParameter.type 
	?: declaredParameter?.init?.inferredType
	?: typeRef(String)
```

## Validation {#builddsl-validation}

When *Tasks* are depending on each other, cycles will break the computation of the execution order. There is a check for this constraint in the validator [BuildDSLValidator]({{site.src.sevenlang}}/languages/org.xtext.builddsl/src/org/xtext/builddsl/validation/BuildDSLValidator.xtend):

```xtend
class BuildDSLValidator extends XbaseJavaValidator {
...
  @Check
  def void checkNoRecursiveDependencies(Task task) {
    task.findDependentTasks [ cycle |
      if (cycle.size == 1) {
        error('''The task '«task.name»' cannot depend on itself.''', 
            cycle.head, DECLARATION__NAME, CYCLIC_DEPENDENCY)
      } else {
        error('''There is a cyclic dependency that involves tasks «
                cycle.map[name].join(", ")»''', 
              cycle.head, DECLARATION__NAME, CYCLIC_DEPENDENCY)
      }
    ]
  }
...
```

## Imports {#builddsl-imports}

By using the *XImportSection* form Xbase, the language automatically supports the notion of *plain imports*, *static imports* and *static extension imports*. While the first two work as in Java, a static extension import puts the static methods of the specified calls on the extension scope, such that it can be called as if it were a method on the first argument. See the [Xtend primer](201_sevenlang_introduction.html#xtend_extension) for a more detailed description.

We ship some predefined extension classes to enhance the Java classes [File]({{site.javadoc.java}}/java/io/File.html) and [Class]({{site.javadoc.java}}/java/lang/Class.html). These are always put onto the extension scope by a customized [BuildDSLImplicitlyImportedFeatures]({{site.src.sevenlang}}/languages/org.xtext.builddsl/src/org/xtext/builddsl/scoping/BuildDSLImplicitlyImportedFeatures.xtend):

```xtend
class BuildDSLImplicitlyImportedFeatures extends ImplicitlyImportedFeatures {
	/**
	 * Add methods from {@link FileExtensions} and {@link ClassExtensions} to the extension scope.
	 */
	override protected getExtensionClasses() {
		(super.getExtensionClasses() + #[FileExtensions, ClassExtensions])
			.toList
	}
}
```

As always, such an implementation has to be bound in the [BuildDSLRuntimeModule]({{site.src.sevenlang}}/languages/org.xtext.builddsl/src/org/xtext/builddsl/BuildDSLRuntimeModule.java):

```java
public class BuildDSLRuntimeModule 
    extends org.xtext.builddsl.AbstractBuildDSLRuntimeModule {
...
  public Class<? extends ImplicitlyImportedFeatures> 
      bindImplicitlyImportedFeatures() {
    return BuildDSLImplicitlyImportedTypes.class;
  }
}
```

## Operator Overloading {#builddsl-library}

As we expect a build language to deal with files and directories a lot, we have extended the syntax around these in the [FileExtensions]({{site.src.sevenlang}}/languages/org.xtext.builddsl.lib/src/org/xtext/builddsl/lib/FileExtensions.xtend). We leverage the fact that Xbase allows to overload operators by means of library extensions. The following examples show how to avoid the noisy constructor calls to [File]({{site.javadoc.java}}/java/io/File.html):

*   DSL:
    
    ```builddsl
    val dir = 'someDir'.file
    val file = dir / 'fileName.txt'
    val theSameFile = 'someDir' / 'fileName.txt'
    ```
*   Java:
    
    ```java
    final File dir = FileExtensions.file("someDir");
    final File file = FileExtensions.operator_divide(dir, "fileName.txt");
    final File theSameFile = FileExtensions.operator_divide(
        "someDir", 
        "fileName.txt");
    ```

The compiler replaces operators with method calls to methods named `operator_<operatorName>()`. These have to be callable on the left operand, i.e. be a method of the left operands type or be added as an extension to the left operand type. In this case, we use the latter approach, since [File]({{site.javadoc.java}}/java/io/File.html) as well as [String]({{site.javadoc.java}}/java/lang/String.html) are sealed types. To learn more about operators and operator overloading please consult the [Xbase documentation](305_xbase.html#xbase-expressions-operators).

## Run as... Integration {#builddsl-launch}

To facilitate executing build scripts from within Java, we have extended Eclipse's launch support. The respective classes are [BuildDSLLaunchDelegate]({{site.src.sevenlang}}/languages/org.xtext.builddsl.ui/src/org/xtext/builddsl/ui/launch/BuildDSLLaunchDelegate.xtend), [BuildDSLLaunchShortcut]({{site.src.sevenlang}}/languages/org.xtext.builddsl.ui/src/org/xtext/builddsl/ui/launch/BuildDSLLaunchShortcut.xtend) and [BuildDSLLaunchTabGroup]({{site.src.sevenlang}}/languages/org.xtext.builddsl.ui/src/org/xtext/builddsl/ui/launch/BuildDSLLaunchTabGroup.xtend). Describing all the details would be a bit lengthy but it is quite straightforward if you are familiar with the launching API. 

---

**[Next Chapter: DSL for MongoDB](204_mongodb.html)**
