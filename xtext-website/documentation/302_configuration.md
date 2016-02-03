---
layout: documentation
title: Configuration
part: Reference Documentation
---

# {{page.title}} {#configuration}

Xtext offers two levels on which you can configure your language: the language generator and dependency injection. The language generator uses a special DSL called MWE2 to configure the generator.

## A Short Introduction to MWE2 {#short-intro-to-mwe}

MWE2 (Modeling Workflow Engine) allows to compose object graphs declaratively in a very compact manner. The nice thing about it is that it just instantiates Java classes and the configuration is done through public setter and adder methods as known from Java Beans encapsulation principles. More in-depth information can be found in the [MWE2 documentation](306_mwe2.html).

Given the following simple Java class (POJO):

```java
package com.mycompany;

public class Person {

  private String name;

  public void setName(String name) { 
    this.name = name;
  }

  private final List<Person> children = new ArrayList<Person>();

  public void addChild(Person child) {
    this.children.add(child);
  }
}
```

One can create a family tree with MWE2 easily by describing it in a declarative manner without writing a single line of Java code and without the need to compile classes:

```mwe2
module com.mycompany.CreatePersons

Person {
  name = "Grandpa"
  child = Person {
    name = "Father"
    child = {
      name = "Son"
    }
  }
}
```

These few lines will, when interpreted by MWE2, result in an object tree consisting of three instances of *com.mycompany.Person*. The interpreter will basically do the same as the following *main* method: 

```java
package com.mycompany;

public class CreatePersons {
    public static void main(String[] args) {
        Person grandpa = new Person();
        grandpa.setName("Grandpa");
        Person father = new Person();
        father.setName("Father");
        grandpa.addChild(father);
        Person son = new Person();
        son.setName("Son");
        father.addChild(son);
    }
}
```

And this is how it works: The root element is a plain Java class name. As this MWE2 module is a sibling to the class *com.mycompany.Person* it is not necessary to use fully qualified name. The constructed objects are furthermore configured according to the declaration in the module, i.e. a second instance of Person is created and added to the list of children of "Grandpa" while the third person becomes a child of "Father". All three instances will have their respective *name* assigned via a reflective invocation of the *setName* method. Note that in this example the *Person* type for "Father" is given explicitly, while for "Son" it is inferred from the assigned feature *child*.

*Hint: Whenever you are in an \*.mwe2 file and wonder what kind of configuration the underlying component may accept: Just use content assist (ctrl + space) in the MWE2 Editor or navigate directly to the declaration of the underlying Java implementation by means of F3 (Go To Declaration).*

Another frequently used feature of MWE2 is *variables*, which can be declared with `var` as shown below. Such a variable can be reset from outside when calling the module, e.g. allowing to use different settings when calling it from a Maven build. You can refer the variables inside strings using the `${variable-name}` notation.

```mwe2
module com.mycompany.CreatePersons

var surname = "Johnson"

Person {
  name = "John ${surname}"
  child = {
    name = "Jim ${surname}"
  }
  child = {
    name = "Jane ${surname}"
  }
}
```

Although arbitrary Java classes can be used, the standard root element for MWE2 files is [Workflow]({{site.src.mwe}}/plugins/org.eclipse.emf.mwe2.runtime/src/org/eclipse/emf/mwe2/runtime/workflow/Workflow.java), which is part of the very slim runtime model shipped with MWE2. It accepts *beans* and *components*.

* The method Workflow.addBean(Object) provides a means to apply global side-effects, which unfortunately is required sometimes. For instance, [StandaloneSetup]({{site.src.mwe}}/plugins/org.eclipse.emf.mwe.utils/src/org/eclipse/emf/mwe/utils/StandaloneSetup.java) can be used to initialize global EMF metadata such as the [Epackage.Registry]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java).

* The method Workflow.addComponent(..) accepts instances of [IWorkflowComponent]({{site.src.mwe}}/plugins/org.eclipse.emf.mwe2.runtime/src/org/eclipse/emf/mwe2/runtime/workflow/IWorkflowComponent.java), which is the primary concept of the workflow model of MWE2. The language generator component itself is an instance of IWorkflowComponent and can therefore be used within MWE2 workflows.

We will now have a look at the component model used to configure the Xtext language generator.

## The Language Generator {#generator}

Xtext provides a lot of generic implementations for the infrastructure of your language, but also uses code generation to create specialized components. Such generated components are for instance the parser, the serializer, the inferred Ecore model (if any) and a couple of convenient base classes for further configuration. The generator also contributes to shared project resources such as the *plugin.xml*, *MANIFEST.MF* and the [Guice modules](#guicemodules).

This documentation is about the new generator infrastructure introduced with Xtext 2.9. In order to migrate an older Xtext project to this new infrastructure, the recommended approach is to create a new Xtext project and copy the grammar and existing configuration from the old project to the new one step by step.

The entry point for Xtext code generation is [XtextGenerator]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/XtextGenerator.xtend), which is composed of a *general configuration* and a set of *language configurations*. The general configuration describes the structure of your project as well as general settings for generating code. Each language configuration corresponds to a specific grammar file and allows to configure the generated code for the respective language. The actual code generation is performed by *generator fragments* contained in a language configuration.

In the following we see an exemplary language generator configuration written in MWE2: 

```mwe2
module org.example.domainmodel.GenerateDomainmodel

import org.eclipse.xtext.xtext.generator.*
import org.eclipse.xtext.xtext.generator.model.project.*

var rootPath = ".."

Workflow {
    component = XtextGenerator {
        configuration = {
            project = StandardProjectConfig {
                baseName = "org.example.domainmodel"
                rootPath = rootPath
                eclipsePlugin = {
                    enabled = true
                }
                createEclipseMetaData = true
            }
            code = {
                encoding = "UTF-8"
            }
        }
        language = StandardLanguage {
            name = "org.example.domainmodel.Domainmodel"
            fileExtensions = "dmodel"

            serializer = {
                generateStub = false
            }
        }
    }
}
```

This example is similar to the workflows generated by the Xtext project wizard when you create new projects. It uses two convenience classes [StandardProjectConfig]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/model/project/StandardProjectConfig.xtend) and [StandardLanguage]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/StandardLanguage.xtend), both of which are designed to apply default configurations that work for the majority of language projects.

### Project Configuration {#project-configuration}

The Xtext generator needs to know the structure of your project in order to generate code into the correct paths. The base class for describing the project structure is [XtextProjectConfig]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/model/project/XtextProjectConfig.xtend). It is composed of several descriptors for the individual subprojects:

* `runtime` &ndash; The basic language features: grammar definition, parser, serializer, scoping, validation, etc.
* `runtimeTest` &ndash; Unit tests for `runtime`
* `genericIde` &ndash; Platform-independent IDE features such as services for content assist
* `eclipsePlugin` &ndash; Integration plug-in for Eclipse
* `eclipsePluginTest` &ndash; Unit tests for `eclipsePlugin`
* `ideaPlugin` &ndash; Integration plug-in for IntelliJ IDEA
* `web` &ndash; Integration into web applications

These subprojects are of type [SubProjectConfig]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/model/project/SubProjectConfig.xtend) and offer important parameters:

* `enabled` &ndash; whether the subproject is present or not
* `name` &ndash; the name of the subproject
* `root` &ndash; the path to the root folder of the subproject
* `src` &ndash; the path to the folder for Java source files
* `srcGen` &ndash; the path to the folder for generated Java source files
* `manifest` &ndash; configuration for the MANIFEST.MF file
* `pluginXml` &ndash; configuration for the plugin.xml file

Since setting all these parameters manually would be tedious and the structure of most Xtext projects is quite similar, it is advisable to use the [StandardProjectConfig]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/model/project/StandardProjectConfig.xtend) as shown in our example above. This specialized project configuration applies default values to all parameters, so you only have to specify those where you wish to override the defaults. For example, given the configuration

```mwe2
project = StandardProjectConfig {
    baseName = "org.example.domainmodel"
    rootPath = rootPath
    eclipsePlugin = {
        enabled = true
    }
    createEclipseMetaData = true
}
```

we obtain a runtime project with the name `org.example.domainmodel`, an Eclipse integration project with the name `org.example.domainmodel.ui`, and a generic IDE project with the name `org.example.domainmodel.ide` (the generic IDE project is enabled automatically if any integration project is enabled). The source folder, MANIFEST.MF and plugin.xml paths are set to the defaults for Eclipse plug-in projects. If you don't want a separate IDE project you can merge its content into another subproject by assigning it the same name:

```mwe2
project = StandardProjectConfig {
    baseName = "org.example.domainmodel"
    rootPath = rootPath
    genericIde = {
        name = "org.example.domainmodel.ui"
    }
    eclipsePlugin = {
        enabled = true
    }
    createEclipseMetaData = true
}
```

This leads to the generic IDE code being generated into the Eclipse integration plug-in.

### Other General Configuration

The configuration block of our generator workflow example above contains a [CodeConfig]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/CodeConfig.xtend) as sibling of [StandardProjectConfig]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/model/project/StandardProjectConfig.xtend). As the name suggests, the parameters of CodeConfig influence the generated code:

* `encoding` &ndash; The character encoding
* `fileHeader` &ndash; The file header comment to insert at the beginning of each file
* `preferXtendStubs` &ndash; Whether to prefer Xtend over Java for stub files to be implemented manually; this option applies only to files in `src` folders, while for `src-gen` folders Java files are always generated.

The container for the [StandardProjectConfig]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/model/project/StandardProjectConfig.xtend) and [CodeConfig]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/CodeConfig.xtend) is of type [DefaultGeneratorModule]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/DefaultGeneratorModule.xtend) and is assigned to the property `configuration` of the [XtextGenerator]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/XtextGenerator.xtend). The DefaultGeneratorModule is actually a [Guice](https://github.com/google/guice) module, which can be subclassed in a similar way as explained in [Dependency Injection](#dependency-injection) for overriding default configurations. This allows to alter the configuration in places that are not accessible through MWE2. For instance, you could bind your own subclass of [XtextGeneratorNaming]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/XtextGeneratorNaming.xtend) in order to influence the names of generated classes.

### Language Configuration {#language-configuration}

The base class for describing a language configuration is [XtextGeneratorLanguage]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/XtextGeneratorLanguage.xtend), whose most important parameters are

* `name` &ndash; The name of the language exactly as specified in the first line of your grammar definition
* `grammarUri` &ndash; A [URI]({{site.src.emf}}/plugins/org.eclipse.emf.common/src/org/eclipse/emf/common/util/URI.java) pointing to the grammar definition file; if omitted, the grammar file is assumed to be in the Java source folder of the runtime project and to be named according to the language name.
* `fileExtensions` &ndash; A comma-separated list of file extensions for the language
* `referencedResources` &ndash; Additional resources to load (see [Importing Existing Metamodels](#importing-metamodels))

The actual code generation is performed by [generator fragments]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/IXtextGeneratorFragment.xtend), which can be added to a language configuration using the `fragment` property. The Xtext project wizard creates a workflow that employs the [StandardLanguage]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/StandardLanguage.xtend), which specializes XtextGeneratorLanguage in a similar way as StandardProjectConfig specializes XtextProjectConfig (see [Project Configuration](#project-configuration)). The main contribution of StandardLanguage is a default list of generator fragments that includes all features of Xtext. These fragments automatically adapt their generated code to your language and project configuration. Some fragments offer their own configuration parameters, hence each fragment can be accessed via a dedicated property in StandardLanguage. For instance, in the language configuration

```mwe2
language = StandardLanguage {
    name = "org.example.domainmodel.Domainmodel"
    fileExtensions = "dmodel"

    serializer = {
        generateStub = false
    }
}
```
we see the `generateStub` parameter disabled for the `serializer` fragment, which means that the fragment should not create any stub file for customizing serialization.

It is not possible to remove fragments from the [StandardLanguage]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/StandardLanguage.xtend). If you need a language configuration where one or more of the default fragments are omitted, you can do so by using [XtextGeneratorLanguage]({{site.src.xtext}}/plugins/org.eclipse.xtext.xtext.generator/src/org/eclipse/xtext/xtext/generator/XtextGeneratorLanguage.xtend) instead and listing the required fragments explicitly. You can take the following configuration as a template:

```mwe2
language = XtextGeneratorLanguage {
    name = "org.example.domainmodel.Domainmodel"
    fileExtensions = "dmodel"
    referencedResource = "platform:/resource/org.eclipse.xtext.xbase/model/Xbase.genmodel"

    fragment = grammarAccess.GrammarAccessFragment2 {}
    fragment = ecore.EMFGeneratorFragment2 {}
    fragment = serializer.SerializerFragment2 {}
    fragment = resourceFactory.ResourceFactoryFragment2 {}
    fragment = parser.antlr.XtextAntlrGeneratorFragment2 {}
    fragment = validation.ValidatorFragment2 {}
    fragment = scoping.ImportNamespacesScopingFragment2 {}
    fragment = exporting.QualifiedNamesFragment2 {}
    fragment = builder.BuilderIntegrationFragment2 {}
    fragment = generator.GeneratorFragment2 {}
    fragment = formatting.Formatter2Fragment2 {}
    fragment = ui.labeling.LabelProviderFragment2 {}
    fragment = ui.outline.QuickOutlineFragment2 {}
    fragment = ui.outline.OutlineTreeProviderFragment2 {}
    fragment = ui.quickfix.QuickfixProviderFragment2 {}
    fragment = ui.contentAssist.ContentAssistFragment2 {}
    fragment = junit.Junit4Fragment2 {}
    fragment = ui.refactoring.RefactorElementNameFragment2 {}
    fragment = types.TypesGeneratorFragment2 {}
    fragment = xbase.XtypeGeneratorFragment2 {}
    fragment = xbase.XbaseGeneratorFragment2 {}
    fragment = ui.templates.CodetemplatesGeneratorFragment2 {}
    fragment = ui.compare.CompareFragment2 {}
    fragment = idea.parser.antlr.XtextAntlrIDEAGeneratorFragment {}
    fragment = idea.IdeaPluginGenerator {}
    fragment = web.WebIntegrationFragment {
        framework = "Ace"
    }
}
```

### Importing Existing Metamodels {#importing-metamodels}

As explained in the [grammar language reference](301_grammarlanguage.html#epackage-import) it is possible to import existing metamodels into your language definition. 

You can use namespace URIs in your grammar file in order to import existing EPackages. This is generally preferable, and other URI schemes are considered deprecated. With a namespace URI the package will be read from the Xtext index and therefore your grammar is independent from the concrete location of the respective ecore file. You have to make sure though that the ecore file is contained in a project that is managed by Xtext. Therefore the project has to have the Xtext project nature attached. Ecore files that reside in referenced Java archives (JARs) are automatically picked up and indexed if the referencing project itself is an Xtext project.

In order to be able to find the referenced package in the language generator, its Ecore generator model has to be mentioned in the language configuration:

```mwe2
language = StandardLanguage {
    name = "org.example.domainmodel.Domainmodel"
    fileExtensions = "dmodel"
    referencedResource =
        "platform:/resource/org.example.domainmodel/model/Domainmodel.genmodel"
}
```

If you are importing more than one metamodel, you can add more `referencedResource` declarations as required.

In some occasions this simple way of referencing metamodels is not sufficient; you can then use the [StandaloneSetup]({{site.src.mwe}}/plugins/org.eclipse.emf.mwe.utils/src/org/eclipse/emf/mwe/utils/StandaloneSetup.java) as a Workflow bean for fine-tuning your EMF setup. Example:

```mwe2
bean = StandaloneSetup {
    platformUri = "${rootPath}"
    scanClassPath = true
    registerGeneratedEPackage = "my.project.DomainmodelPackage"
    registerGenModelFile = "platform:/resource/my.project/model/Domainmodel.genmodel"
}
```

---

## Dependency Injection {#dependency-injection}

All Xtext components are assembled by means of dependency injection (DI). This means basically that whenever some code is in need for functionality (or state) from another component, one just declares the dependency rather then stating how to resolve it, i.e. obtaining that component.

For instance when some code wants to use a scope provider, it just declares a field (or method or constructor) and adds the [Inject]({{site.javadoc.guice}}/com/google/inject/Inject.html) annotation: 

```java
public class MyLanguageLinker extends Linker {

    @Inject
    private IScopeProvider scopeProvider;

}
```

It is not the duty of the client code to care about where the [IScopeProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/scoping/IScopeProvider.java) implementation comes from or how it is created. When the above class is instantiated, Guice sees that it requires an instance of IScopeProvider and assigns it to the specified field or method parameter. This of course only works if the object itself is created by Guice. In Xtext almost every instance is created that way and therefore the whole dependency net is controlled and configured by the means of Guice.

Guice of course needs to know how to instantiate real objects for declared dependencies. This is done in so-called [Modules]({{site.javadoc.guice}}/com/google/inject/Module.html). A [Module]({{site.javadoc.guice}}/com/google/inject/Module.html) defines a set of mappings from types to either existing instances, instance providers or concrete classes. Modules are implemented in Java. Here's an example:

```java
public class MyDslRuntimeModule implements Module {
  
    @Override
    public void configure(Binder binder) {
        binder
            .bind(IScopeProvider.class)
            .to(MyConcreteScopeProvider.class);
    }
}
```

With plain Guice modules one implements a method called configure and gets a [Binder]({{site.javadoc.guice}}/com/google/inject/Binder.html) passed in. That binder provides a fluent API to define the mentioned mappings.

### The Module API {#guicemodules}

After running the Xtext generator you get several different modules for your language: one for the base project and one for each platform integration project. For instance, for a language named *Domainmodel* we would have a *DomainmodelRuntimeModule*, a *DomainmodelUiModule* (for the Eclipse integration), a *DomainmodelIdeaModule* (for the IntelliJ IDEA integration), and a *DomainmodelWebModule*. The bindings from the runtime module are shared by all integration projects.

Xtext comes with a slightly enhanced module API. The abstract base class [AbstractGenericModule]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/service/AbstractGenericModule.java) looks reflectively for certain methods in order to find declared bindings. The most common kind of method is

```java
public Class<? extends IScopeProvider> bindIScopeProvider() {
    return MyConcreteScopeProvider.class;
}
```

which would do the same as the code snippet above. It simply declares a binding from [IScopeProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/scoping/IScopeProvider.java) to *MyConcreteScopeProvider*. That binding will make Guice instantiate and inject a new instance of *MyConcreteScopeProvider* whenever a dependency to [IScopeProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/scoping/IScopeProvider.java) is declared.

Having one method per binding allows to deactivate individual bindings by overriding the corresponding methods and either change the binding by returning a different target type or removing that binding completely by returning null.

There are two additional kinds of binding-methods supported. The first one allows to configure a [Provider]({{site.javadoc.guice}}/com/google/inject/Provider.html), which is like a factory for one specific type. This one can be used if you need a hook whenever an instance of a certain type is created. For instance if you want to provide lazy access to a singleton or you need to do some computation each time an instance is created (i.e. factory). If you want to point to a provider rather than to a concrete class you can use the following binding method.

```java
public Class<? extends Provider<IScopeProvider>> provideIScopeProvider() {
    return MyConcreteScopeProviderFactory.class;
}
```

Note: Please forgive us the overuse of the term *provider*. The [IScopeProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/scoping/IScopeProvider.java) is not a Guice [Provider]({{site.javadoc.guice}}/com/google/inject/Provider.html).

That binding tells Guice to instantiate *MyConcreteScopeProviderFactory* and invoke get() in order to obtain an instance of [IScopeProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/scoping/IScopeProvider.java) for clients having declared a dependency to that type. Both mentioned binding methods are allowed to return an instance instead of a type. This may be useful if some global state should be shared in the application. For a simple instance this would be

```java
public IScopeProvider bindIScopeProvider() {
    return new MyConcreteScopeProvider();
}
```

and for a provider binding

```java
public Provider<IScopeProvider> provideIScopeProvider() {
    return new MyConcreteScopeProviderFactory();
}
```

The third binding method provided by Xtext allows to do anything you can do with the binding API of Guice, since it allows you to use the [Binder]({{site.javadoc.guice}}/com/google/inject/Binder.html) directly. The name of the method has to start with the 'configure', the return type must be `void`, and it must accept one argument of type [Binder]({{site.javadoc.guice}}/com/google/inject/Binder.html):

```java
public void configureIScopeProvider(Binder binder) {
    binder.bind(IScopeProvider.class).to(MyConcreteScopeProvider.class);
} 
```

These are the basic ideas around Guice and the small extension Xtext provides on top. For more information we strongly encourage you to read through the documentation on [the website of Google Guice](https://github.com/google/guice).

### Obtaining an Injector

In every application wired up with Guice there is usually one point where you initialize an [Injector]({{site.javadoc.guice}}/com/google/inject/Injector.html) using the modules declared. Usually this is done with the static methods of [Guice]({{site.javadoc.guice}}/com/google/inject/Guice.html). In Xtext, however, you should never instantiate the injector of your language yourself.

Xtext may be used in different environments which introduce different constraints. Especially important is the difference between OSGi managed containers and plain vanilla Java programs. To honor these differences Xtext uses the concept of [ISetup]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/ISetup.java) implementations in normal mode and uses the extension mechanism of Eclipse when it should be configured in an OSGi environment.

#### Runtime Setup {#runtime-setup}

For each language there is an implementation of [ISetup]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/ISetup.java) generated. It implements a method called `createInjectorAndDoEMFRegistration()`, which can be called to do the initialization of the language infrastructure.

```java
public static void main(String[] args) {
    Injector injector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
    MyApplication application = injector.getInstance(MyApplication.class);
    application.run();
}
```

The setup method returns an [Injector]({{site.javadoc.guice}}/com/google/inject/Injector.html), which can further be used to obtain a parser, etc. It also registers the [Resource.Factory]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/resource/Resource.java) and generated [EPackages]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) to the respective global registries provided by EMF. So basically after having run the setup and you can start using EMF API to load and store models of your language.

**Caveat:** The [ISetup]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/ISetup.java) class is intended to be used for runtime and for unit testing, only. if you use it in an Equinox scenario, you will very likely break the running application because entries to the global registries will be overwritten.

#### Setup within Eclipse-Equinox (OSGi) {#equinox-setup}

Within Eclipse we have a generated *Activator*, which creates a Guice [Injector]({{site.javadoc.guice}}/com/google/inject/Injector.html) using the [modules](#guicemodules). In addition an [IExecutableExtensionFactory]({{site.javadoc.eclipse-platform}}/org/eclipse/core/runtime/IExecutableExtensionFactory.html) is generated for each language, which is used to create [IExecutableExtensions]({{site.javadoc.eclipse-platform}}/org/eclipse/core/runtime/IExecutableExtension.html). This means that everything which is created via extension points is managed by Guice as well, i.e. you can declare dependencies and get them injected upon creation.

The only thing you have to do in order to use this factory is to prefix the class with the generated *ExecutableExtensionFactory* name followed by a colon.

```xml
<extension point="org.eclipse.ui.editors">
  <editor
    class=
      "example.MyDslExecutableExtensionFactory:org.eclipse.xtext.ui.editor.XtextEditor"
    contributorClass=
      "org.eclipse.ui.editors.text.TextEditorActionContributor"
    default="true"
    extensions="mydsl"
    id="org.eclipse.xtext.example.MyDsl"
    name="MyDsl Editor">
  </editor>
</extension>
```

---

## Logging

Xtext uses [Apache Log4j](http://logging.apache.org/log4j/) for logging. It is configured using files named *log4j.properties*, which are looked up in the root of the Java class path. If you want to change or provide configuration at runtime (i.e. non-OSGi), all you have to do is putting such a *log4j.properties* in place and make sure that it is not overridden by other *log4j.properties* in previous class path entries.

In OSGi you provide configuration by creating a fragment for *org.apache.log4j*. In this case you need to make sure that there is not any second fragment contributing a *log4j.properties* file.

---

**[Next Chapter: Basic Language Features](303_runtime_concepts.html)**
