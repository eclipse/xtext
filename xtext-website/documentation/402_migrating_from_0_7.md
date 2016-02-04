---
layout: documentation
title: Migrating from Xtext 0.7.x to 1.0
part: Appendix
---

# {{page.title}} {#migrating-from-0_7}

For the sake of completeness, here is how you migrate from Xtext 0.7.x to Xtext 1.0, so you might do a migration to 2.0 in two steps. Nevertheless, there have been so many new features and changes that it probably makes more sense to just copy the grammar and start with a new Xtext 2.0 project. The grammar language is fully backward compatible. 

## Migrating Step By Step

Once again, you should make sure that no old plug-ins are in your target platform. Some plug-ins from Xtext 0.7.x have been merged and do no longer exist. 

*Hint: The following steps try to use the Eclipse compiler to spot any source-incompatible changes while fixing them with only a few well described user actions. Doing these steps in another order causes most likely a higher effort.*

### Update the Plug-in Dependencies and Import Statements

You should update the constraints from version *0.7.x* to *\[1.0.0,2.0.0)* in your manifest files if you specified any concrete versions. Make sure that your *dsl.ui*-projects do not refer to the plug-in *org.eclipse.xtext.ui.common* or *org.eclipse.xtext.ui.core* but to *org.eclipse.xtext.ui* instead. The arguably easiest way is a global text-based search and replace across the manifest files. The bundle *org.eclipse.xtext.log4j* is obsolete as well. The generator will create *import-package* entries in the manifests later on.

The next step is to fix the import statements in your classes to match the refactored naming scheme in Xtext. Perform a global search for `import org.eclipse.xtext.ui.common.` and `org.eclipse.xtext.ui.core.` and replace the matches with `import org.eclipse.xtext.ui.`. This fixes most of the problems in the manually written code. 

### Rename the Packages in the dsl.ui-Plug-in

We changed the naming pattern for artifacts in the *dsl.ui*-plug-in to match the OSGi conventions. The easiest way to update your existing projects is to apply a "Rename Package" refactoring on the packages in the *src*- and *src-gen* folder *before* you re-run the workflow that regenerates your language. Make sure you ticked "Rename subpackages" in the rename dialog. It is error-prone to enable the search in non-Java files as this will perform incompatible changes in the manifest files. Furthermore, it is important to perform the rename operation in the *src-gen* folder, too. This ensures that the references in your manually written code are properly updated.

### Update the Workflow

The *JavaScopingFragment* does no longer exist. It has been superseded by the [ImportURIScopingFragment]({{site.src.xtext}}/plugins/org.eclipse.xtext.generator/src/org/eclipse/xtext/generator/scoping/ImportURIScopingFragment.java) in combination with the [SimpleNamesFragment]({{site.src.xtext}}/plugins/org.eclipse.xtext.generator/src/org/eclipse/xtext/generator/exporting/SimpleNamesFragment.java). Please replace 

```xml
<fragment class=
  "org.eclipse.xtext.generator.scoping.JavaScopingFragment"/>
```

with

```xml
<fragment class=
  "org.eclipse.xtext.generator.scoping.ImportURIScopingFragment"/>
<fragment class=
  "org.eclipse.xtext.generator.exporting.SimpleNamesFragment"/>
```

The *PackratParserFragment* has been abandoned as well. It is save to remove the reference to that one if it is activated in your workflow. After you've changed your workflow, it should be possible to regenerate your language without any errors in the console. It is ok to have compilation errors prior to executing the workflow.

### MANIFEST.MF and plugin.xml

The previous rename package refactoring updated most of the entries in the *MANIFEST.MF* and and some entries in the *plugin.xml*. Others have to be fixed manually. The Eclipse compiler will point to many of the remaining problems in the manifest files but it is unlikely that it will spot the erroneous references in the *plugin.xml*.

*   In the generated UI plug-in's *MANIFEST.MF*, remove the package exports of no longer existing packages and make sure the bundle activator points to the newly generated one (with *.ui.* in its package name). 
*   It was already mentioned that the plug-ins *org.eclipse.xtext.ui.core* and *org.eclipse.xtext.ui.common* have been merged into a new single plug-in *org.eclipse.xtext.ui*. The same happened to the respective Java packages. Change eventually remaining bundle-dependencies in all manifests. 
*   The plug-in *org.eclipse.xtext.log4j* no longer exists. We use a package import of *org.apache.log4j* instead. Also remove the buddy registration. 
*   Due to renamed packages, you have to fix all references to classes therein in the *plugin.xml*. A comparison with the *plugin.xml\_gen* will be a great help. If you haven't added a lot manually, consider merging these into the generated version instead of going the other way around. Note that warnings in the *plugin.xml* can be considered to be real errors most of the time. Make sure the *MyDslExecutableExtensionFactory* has the *.ui.* package prefix. Classes from *org.eclipse.xtext.ui.common* and *org.eclipse.xtext.ui.core* are now usually somewhere in *org.eclipse.xtext.ui*. They are also referenced by the *MyDslExecutableExtensionFactory* and thus not covered by the validation of the *plugin.xml*. 
*   A number of new features are being registered in the *plugin.xml*, e.g. *Find references*, *Quick Outline*, and *Quick Fixes*. You can enable them by manually copying the respective entries from *plugin.xml\_gen* to *plugin.xml*. 
*   To run MWE2 workflows later on, you must change the plug-in dependencies from *org.eclipse.emf.mwe.core* to *org.eclipse.emf.mwe2.launch* in your manifest. Optional resolution is fine. 

### Noteworthy API Changes

The *src* folders are generated once, so existing code will not be overwritten but has to be updated manually. At least one new class has appeared in your *src*-folder of the *ui* plug-in. there will now be a *MyDslStandaloneSetup* inheriting form the generated *MyDslStandaloneSetupGenerated* to allow customization.

You will face a couple of compilation problems due to changes in the API. Here's a list of the most prominent changes. It is usually only necessary to change your code, if you face any compilation problems.

*   The method [IScopeProvider.getScope(EObject,EClass)]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/scoping/IScopeProvider.java) has been removed. Use `getScope(EObject,EReference)` instead. 
*   Renamed *DefaultScopeProvider* to [SimpleLocalScopeProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/scoping/impl/SimpleLocalScopeProvider.java). There have been further significant changes in the scoping API that allow for optimized implementations. Consult the [section on scoping](303_runtime_concepts.html#scoping) for details. 
*   The return type of [AbstractInjectableValidator.getEPackages()]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/validation/AbstractInjectableValidator.java) was changed from `List<? extends EPackage>` to `List<EPackage>`. 
*   The parser interfaces now use [Reader]({{site.javadoc.java}}/java/io/Reader.html) instead of [InputStream]({{site.javadoc.java}}/java/io/InputStream.html) to explicitly address encoding. Have a look at the [section on encoding](303_runtime_concepts.html#encoding) for details. 
*   The handling of [ILabelProvider]({{site.javadoc.eclipse-platform}}/org/eclipse/jface/viewers/ILabelProvider.html) in various contexts has been refactored. The former base class *DefaultLabelProvider* no longer exists. Use the [DefaultEObjectLabelProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/label/DefaultEObjectLabelProvider.java) instead. See the [section on label providers](310_eclipse_support.html#label-provider) for details. 
*   We have introduced a couple of new packages to better separate concerns. Most classes should be easy to relocate. 
*   The runtime and UI modules have separate base classes [DefaultRuntimeModule]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/service/DefaultRuntimeModule.java) and [DefaultUiModule]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/DefaultUiModule.java) now. We use Guice's module overrides to combine them with the newly introduced [SharedModule]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui.shared/src/org/eclipse/xtext/ui/shared/internal/SharedModule.java). You have to add a constructor the your *MyDslUiModule* that takes an [AbstractUIPlugin]({{site.javadoc.eclipse-platform}}/org/eclipse/ui/plugin/AbstractUIPlugin.html) as argument and pass that one to the super constructor. *Hint: There is an Eclipse quick fix available for that one.*
*   The interfaces *ILexicalHighlightigConfiguration* and *ISemanticHighlightingConfiguration* have been merged into [IHighlightingConfiguration]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/editor/syntaxcoloring/IHighlightingConfiguration.java). 
*   The [DefaultTemplateProposalProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/editor/templates/DefaultTemplateProposalProvider.java) takes an additional, injectable constructor parameter of type [ContextTypeIdHelper]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/editor/templates/ContextTypeIdHelper.java). 
*   The [HyperlinkHelper]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/editor/hyperlinking/HyperlinkHelper.java) uses field injection instead of constructor injection. The method `createHyperlinksByOffset(..)` should be overridden instead of the former `findCrossLinkedEObject`. 
*   The API to skip a node in the outline has changed. Instead of returning the *HIDDEN\_NODE* you'll have to implement `boolean consumeNode(MyType)` and return *false*. **Note: The outline has been re-implemented in Xtext 2.0**. 
*   The *Readonly\*Storage* implementations have been removed. There is a new API to open editors for objects with a given URI. Please use the [IURIEditorOpener]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/editor/IURIEditorOpener.java) to create an editor or the [IStorage2UriMapper]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/resource/IStorage2UriMapper.java) to obtain an [IStorage]({{site.javadoc.eclipse-platform}}/org/eclipse/core/resources/IStorage.html) for a given [URI]({{site.src.emf}}/plugins/org.eclipse.emf.common/src/org/eclipse/emf/common/util/URI.java). 
*   The interfaces *IStateAccess* and *IEObjectHandle* have been moved along with the [IUnitOfWork]({{site.src.xtext}}/plugins/org.eclipse.xtext.util/src/org/eclipse/xtext/util/concurrent/IUnitOfWork.java) to the package *org.eclipse.xtext.util.concurrent*. **Note: IStateAccess was split into IReadAccess and IWriteAccess in Xtext 2.0.**
*   The *ValidationJobFactory* is gone. Please implement a custom [IResourceValidator]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/validation/IResourceValidator.java) instead. 
*   The grammar elements [Alternatives]({{site.src.xtext}}/plugins/org.eclipse.xtext/emf-gen/org/eclipse/xtext/Alternatives.java) and [Group]({{site.src.xtext}}/plugins/org.eclipse.xtext/emf-gen/org/eclipse/xtext/Group.java) have a new common super type [CompoundElement]({{site.src.xtext}}/plugins/org.eclipse.xtext/emf-gen/org/eclipse/xtext/CompoundElement.java). The methods `getGroups()` and `getTokens()` have been refactored to `getElements()`. 
*   Completion proposals take a [StyledString]({{site.javadoc.eclipse-platform}}/org/eclipse/jface/viewers/StyledString.html) instead of a plain string as display string. 
*   The [AbstractLabelProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/label/AbstractLabelProvider.java) does no longer expose its [IImageHelper]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/IImageHelper.java). Use `convertToImage` instead or inject your own [IImageHelper]({{site.src.xtext}}/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext/ui/IImageHelper.java). 
*   The implementation-classes from *org.eclipse.xtext.index* were superseded by the builder infrastructure. Use the [QualifiedNamesFragment]({{site.src.xtext}}/plugins/org.eclipse.xtext.generator/src/org/eclipse/xtext/generator/exporting/QualifiedNamesFragment.java) and the [ImportNamespacesScopingFragment]({{site.src.xtext}}/plugins/org.eclipse.xtext.generator/src/org/eclipse/xtext/generator/scoping/ImportNamespacesScopingFragment.java) instead of the *ImportedNamespacesScopingFragment*. Please refer to the [section about the builder infrastructure](303_runtime_concepts.html#index-based) for details. 
*   All the Xtend-based fragments were removed. 
*   [ILinkingService.getLinkText]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/linking/ILinkingService.java) was removed. Have a look at the [LinkingHelper]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/linking/impl/LinkingHelper.java) and the [CrossReferenceSerializer]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/parsetree/reconstr/impl/CrossReferenceSerializer.java) if you relied on this method. 
*   The *SerializerUtil* was renamed to [Serializer]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/parsetree/reconstr/Serializer.java). There were other heavy refactorings that involved the serializer and its components like e.g. the [ITransientValueService]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/parsetree/reconstr/ITransientValueService.java) but it should be pretty straight forward to migrate existing client code. 
*   The method-signatures of the [IFragmentProvider]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/resource/IFragmentProvider.java) have changed. The [documentation](308_emf_integration.html#fragment-provider) will give a clue on how to update existing implementations. 
*   Some static methods were removed from utility classes such as [EcoreUtil2]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/EcoreUtil2.java) and *ParsetreeUtil* in favor of more sophisticated implementations. 

