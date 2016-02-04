---
layout: documentation
title: Migrating from Xtext 1.0.x to 2.0
part: Appendix
---

# {{page.title}} {#migrating-from-1_0_x}

Most of the tasks when migrating to Xtext 2.0 can be automated. Some changes will be necessary in the manually written code where you have to carefully verify that your implementation is still working with Xtext 2.0. A reliable test-suite helps a lot. 

The grammar language is fully backward compatible. You should not have to apply any changes in the primary artifact. However, we introduced some additional validation rules that mark inconsistencies in your grammar. If you get any warnings in the grammar editor, it should be straight forward to fix them.

*Hint: You'll learn something about the new features if you compare a freshly created Xtext project based on 1.0.x with a new Xtext project based on 2.0. Especially the new fragments in the workflow are a good indicator for useful new features.*

## Take the Shortcut

If you haven't made too many customizations to the generated defaults and if you're not referencing many classes of your Xtext language from the outside, you might consider starting with a new Xtext project, copying your grammar and then manually restoring your changes step by step. If that does not work for you, go on reading!

## Migrating Step By Step

Before you start the migration to Xtext 2.0, you should make sure that no old plug-ins are in your target platform.

*Hint: The following steps try to use the Eclipse compiler to spot any source-incompatible changes while fixing them with only a few well described user actions. Doing these steps in another order causes most likely a higher effort.*

### Update the Plug-in Dependencies and Import Statements

You should update the version constraints of the plug-in dependencies in your manifest files from version *1.0.x* to *2.0* if you specified any concrete versions. Also the constraint of *org.antlr.runtime* must be updated from *\[3.0.0,3.0.2)* to *3.2.0*.

The next step is to fix the import statements in your classes to match the refactored naming scheme in Xtext. This fixes most of the problems in the manually written code. 

### Introduction of the Qualified Name

With Xtext 2.0 an object for dealing with qualified names has been introduced: [QualifiedName]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/naming/QualifiedName.java). The qualified name is now split into segments which can be queried. The lower-case version of the qualified name is cached so that the performance of case insensitive languages is improved. The signature of the methods used by the [DefaultDeclarativeQualifiedNameProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/naming/DefaultDeclarativeQualifiedNameProvider.java) changed to `QualifiedName qualifiedName(Object)`. 

The [IQualifiedNameConverter]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/naming/IQualifiedNameConverter.java) converts qualified names from/to their [String]({{site.javadoc.java}}/java/lang/String.html) representation. This is also where you specify the separator and wildcard strings. If you already know the segments of a qualified name, you can also create it using `QualifiedName.create(String ...)`. 

[QualifiedName]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/naming/QualifiedName.java) is the new type of the *name* properties in the [IEObjectDescription]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/IEObjectDescription.java). So if you have customized indexing, e.g. implemented your own [Manager]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/IResourceDescription.java), you will have to create [qualified names]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/naming/QualifiedName.java) instead of [strings]({{site.javadoc.java}}/java/lang/String.html). [IEObjectDescriptions]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/IEObjectDescription.java) are also used in other places such as [scoping](303_runtime_concepts.html#scoping), [linking](303_runtime_concepts.html#linking), [serialization](303_runtime_concepts.html#serialization), [content assist](310_eclipse_support.html#content-assist)...

Furthermore, the method [IQualifiedNameProvider.getQualifiedName(EObject)]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/naming/IQualifiedNameProvider.java) has been renamed to `getFullyQualifiedName(EObject)`.

### Changes in the index and in find references

In Xtext 1.0.x the interfaces [IResourceDescriptions]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/IResourceDescriptions.java), [IResourceDescription]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/IResourceDescription.java) and [IContainer]({{site.javadoc.eclipse-platform}}/org/eclipse/core/resources/IContainer.html) have several methods to query them for contained elements. In Xtext 2.0 there is a common interface [ISelectable]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/ISelectable.java) for this use case which is extended by the interfaces mentioned above. For further details have a look at the interface [ISelectable]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/ISelectable.java).

The default indexing for Xtext resources as it is defined in [DefaultResourceDescriptionManager]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/impl/DefaultResourceDescriptionManager.java) has changed. Only cross-references pointing to elements outside the current resource are indexed. Furthermore, the [DefaultResourceDescriptionManager]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/impl/DefaultResourceDescriptionManager.java) can now be easier customized with an [IDefaultResourceDescriptionStrategy]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/IDefaultResourceDescriptionStrategy.java). 

For Ecore files only [EPackages]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java), [EClassifiers]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClassifier.java) and [EStructuralFeatures]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EStructuralFeature.java) are indexed, each with both, the *nsURI* and the *name* of the containing [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) in their qualified name.

There is a new interface to find references to Xtext elements: [IReferenceFinder]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/editor/findrefs/IReferenceFinder.java). It allows to distinguish searches in the local [Resource]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/resource/Resource.java) from global index searches. Local searches will yield *all* local cross references independent of the indexing strategy.

### Rewritten Node Model

To reduce memory consumption, the node model has been redesigned in Xtext 2.0. We no longer use EMF, but a chained list of compressed nodes instead. 

The package *org.eclipse.xtext.nodemodel* now contains the relevant interfaces to program against. The new interfaces follow the naming convention of other types in the framework. They are called [INode]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/nodemodel/INode.java), [ICompositeNode]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/nodemodel/ICompositeNode.java) and [ILeafNode]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/nodemodel/ILeafNode.java). That way, most of the migration will be done by prefixing the old names with an *I* and use the organize imports tool. Please make sure not to program against concrete or abstract classes.

If you used the node model a lot, you should have a closer look at the new APIs. The [EObject]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java) API is no longer available on the nodes. Instead, you we offer a couple of [Iterables]({{site.javadoc.java}}/java/lang/Iterable.html) for traversing the tree. Where appropriate, helper methods of the former *ParseTreeUtil* and *NodeUtil* have become members of the nodes, e.g. `NodeUtil.getAllContents(AbstractNode)` has become [INode.getAsTreeIterable()]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/nodemodel/INode.java) The remaining methods have been converted and moved to the new [NodeModelUtils]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/nodemodel/util/NodeModelUtils.java).

### New Outline

The outline view has been completely re-implemented. To use the new one remove the following fragments from your workflow 

```mwe2
fragment = outline.TransformerFragment{}
fragment = outline.OutlineNodeAdapterFactoryFragment{}
```

and add 

```mwe2
fragment = outline.OutlineTreeProviderFragment {}
```

After generating a new class named *MyDslOutlineTreeProvider* is generated. The API changed completely. For that reason you should take a closer look at the [chapter on the outline](310_eclipse_support.html#outline). The old classes named *MyDslTransformer* and *MyDslOutlineNodeAdapterFactory* have become obsolete and should be removed after having migrated your code to the new API.

### AutoEditStrategy

In Xtext 1.0.x your AutoEditStrategy extends the class *DefaultAutoEditStrategy* which implements the interface [IAutoEditStrategy]({{site.javadoc.eclipse-platform}}/org/eclipse/jface/text/IAutoEditStrategy.html). In Xtext 2.0 the [DefaultAutoEditStrategyProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/editor/autoedit/DefaultAutoEditStrategyProvider.java) should be extended instead. The only thing you have to do is to change the superclass from *DefaultAutoEditStrategy* to [DefaultAutoEditStrategyProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/editor/autoedit/DefaultAutoEditStrategyProvider.java). The interface [IEditStrategyAcceptor]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/editor/autoedit/AbstractEditStrategyProvider.java) changed from `accept(IAutoEditStrategy)` to `accept(IAutoEditStrategy, String)`. The last parameter represents the *contentType* of the document. Constants could be found in the [IDocument]({{site.javadoc.eclipse-platform}}/org/eclipse/jface/text/IDocument.html) and in the [TerminalsTokenTypeToPartitionMapper]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/editor/model/TerminalsTokenTypeToPartitionMapper.java). 

As a example the configure method could look like this one: 

```java
  @Override
  protected void configure(IEditStrategyAcceptor acceptor) {
    super.configure(acceptor);
    acceptor.accept(new YourAutoEditStrategy(),
            IDocument.DEFAULT_CONTENT_TYPE);
  }
```

The last thing you have to do is to change the binding of the *IAutoEditStrategy* in the *MyDslUIModule* from

```java
public Class<? extends IAutoEditStrategy> bindIAutoEditStrategy()
```

to 

```java
public Class<? extends AbstractEditStrategyProvider> 
  bindAbstractEditStrategyProvider() { .. }
```

### Other Noteworthy API Changes

The *src* folders are generated once, so existing code will not be overwritten but has to be updated manually.

You will face a couple of compilation problems due to changes in the API. Here's a list of the most prominent changes. It is usually only necessary to change your code, if you face any compilation problems. 

*   In the interface [IGlobalScopeProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/scoping/IGlobalScopeProvider.java) the method `getScope(EObject,EReference)` has been removed. Use `getScope(Resource, EReference, Predicate<IEObjectDescription>)` instead. 
*   The interface *IAntlrParser* has been removed. Use the [IParser]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/parser/IParser.java) instead.
*   The methods `error(..)` and `warning(..)` in the [AbstractDeclarativeValidator]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/validation/AbstractDeclarativeValidator.java) used to accept integer constants representing the [EStructuralFeature]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EStructuralFeature.java) which caused the issues. These integer parameters were replaced by the feature itself, e.g. from `error(String, Integer)` to `error(String, EStructuralFeature)`. Use the generated [EPackage.Literals]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) to access the [EStructuralFeatures]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EStructuralFeature.java). 
*   The enum *DiagnosticSeverity* has been renamed to [Severity]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/diagnostics/Severity.java).
*   The class *TextLocation* has been replaced by the interface [ITextRegion]({{site.src.xtext}}/plugins/org.eclipse.xtext.util/src/org/eclipse/xtext/util/ITextRegion.java) with an immutable implementation [TextRegion]({{site.src.xtext}}/plugins/org.eclipse.xtext.util/src/org/eclipse/xtext/util/TextRegion.java).
*   In Xtext 1.0.x the class [EObjectAtOffsetHelper]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/EObjectAtOffsetHelper.java) provided several static methods to resolve elements. In Xtext 2.0 these methods aren't static anymore. For that reason you could create an instance of this class or let Guice do the job for you:     
    
    ```java
      @Inject private EObjectAtOffsetHelper eObjectAtOffsetHelper;
    ```

*   The method [EObjectAtOffsetHelper.resolveElementAt(XtextResource, int, TextLocation)]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/EObjectAtOffsetHelper.java) changed to `resolveElementAt(XtextResource, int)`. You have to use the [ILocationInFileProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/ILocationInFileProvider.java) to compute the [TextRegion]({{site.src.xtext}}/plugins/org.eclipse.xtext.util/src/org/eclipse/xtext/util/TextRegion.java).
*   The [ILocationInFileProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/ILocationInFileProvider.java) now offers methods `getSignificantTextRegion()` and `getFullTextRegion()` to make the distinction between the name and the full region of an element. The old `getLocation()` method was removed. 

If you experience further problems, please refer to the [newsgroup](http://www.eclipse.org/forums/index.php?t=thread&frm_id=27).

## Now go for then new features

After migrating, some of the new features in Xtext 2.0 will be automatically available. Others require further configuration. We recommend exploring 

*   Xbase,
*   the new Xtend,
*   rename refactorings
*   the compare view,
*   rich hovers,
*   the Xtext syntax graph,
*   [support for syntactic predicates](301_grammarlanguage.html#syntactic-predicates),
*   the generated debug grammar,
*   [terminal fragments](301_grammarlanguage.html#terminal-fragment),
*   document partitions and auto edit
*   the redesigned [outline view](310_eclipse_support.html#outline),
*   and the [quick fixes for the Xtext grammar language](310_eclipse_support.html#quick-fixes).

---

**[Next Chapter: Migrating from Xtext 0.7.x to 1.0](402_migrating_from_0_7.html)**