/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ecore;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenRuntimeVersion;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.mwe.utils.GenModelHelper;
import org.eclipse.emf.mwe2.ecore.CvsIdFilteringGeneratorAdapterFactoryDescriptor;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;

@Log
@SuppressWarnings("all")
public class EMFGeneratorFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  private CodeConfig codeConfig;
  
  /**
   * The java package into which the generated Java classes shall be placed.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String basePackage;
  
  /**
   * Sets the ID of the generated EMF model plug-in. Only needed if you want to generate the EMF code into a separate plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String modelPluginID;
  
  /**
   * Sets the target directory for the generated EMF model code. Only needed if you want to generate the EMF code into
   * a separate plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String javaModelDirectory;
  
  /**
   * Whether EMF edit code shall be generated.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean generateEdit = false;
  
  /**
   * The plug-in ID of the generated EMF edit plug-in. Only needed if you want to generate an EMF edit plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String editPluginID;
  
  /**
   * The target directory for the generated EMF edit code. Only needed if you want to generate an EMF edit plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String editDirectory;
  
  /**
   * Whether EMF editor code shall be generated.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean generateEditor = false;
  
  /**
   * The plug-in ID of the generated EMF editor plug-in. Only needed if you want to generate an EMF editor plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String editorPluginID;
  
  /**
   * The target directory for the generated EMF editor code. Only needed if you want to generate an EMF editor plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String editorDirectory;
  
  /**
   * If an existing EMF GenModel should be used, set the path to that file in this property.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String genModel;
  
  /**
   * Whether the Java class generation should be skipped. If <code>true</code> only the ecore file is generated.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean skipGenerate = false;
  
  /**
   * Whether the build.properties should be updated. Skipped if the model code is generated into a separate
   * plugin or if no manifest is configured for the runtime project (see {@code WizardConfig#createEclipseMetaData}).
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean updateBuildProperties = true;
  
  /**
   * Whether to use a qualified name for the xmi files, e.g.
   * <code>org_eclipse_xtext_Xtext.ecore</code> rather than <code>Xtext.ecore</code>.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean longFileNames = false;
  
  /**
   * The generated package implementation uses 'load initialization' if it becomes very large, which means
   * that an additional ecore file is generated and the package content is loaded at runtime from that file.
   * This is to prevent the compiled class file from becoming too large. Set this property to true in order
   * to suppress this behavior.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean suppressLoadInitialization = false;
  
  /**
   * Default to 2.20 if available, otherwise #get will return null
   */
  private GenRuntimeVersion emfRuntimeVersion = GenRuntimeVersion.get(GenRuntimeVersion.EMF220_VALUE);
  
  private GenJDKLevel jdkLevel = GenJDKLevel.JDK80_LITERAL;
  
  private String rootExtendsClass = "org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container";
  
  /**
   * Sets the target EMF runtime version to generate for to the specified value.
   * Defaults to 2.20.
   */
  public void setEmfRuntimeVersion(final String emfRuntimeVersion) {
    this.emfRuntimeVersion = GenRuntimeVersion.get(emfRuntimeVersion);
    if ((this.emfRuntimeVersion == null)) {
      EMFGeneratorFragment2.LOG.warn(("Illegal EMF runtime version: " + emfRuntimeVersion));
    }
  }
  
  /**
   * Set the JDK compatibility level. The following values are valid:
   * <ul>
   *   <li>"JDK14"</li>
   *   <li>"JDK50"</li>
   *   <li>"JDK60"</li>
   *   <li>"JDK70"</li>
   *   <li>"JDK80"</li>
   * </ul>
   * The default level is "JDK80".
   */
  public void setJdkLevel(final String jdkLevel) {
    this.jdkLevel = GenJDKLevel.getByName(jdkLevel);
    if ((this.jdkLevel == null)) {
      EMFGeneratorFragment2.LOG.warn(("Illegal JDK level: " + jdkLevel));
    }
  }
  
  /**
   * Sets the BaseClass for the EClasses in the inferred GenModel.
   * Default value is {@link org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container}.
   * 
   * @since 2.16
   */
  public void setRootExtendsClass(final String rootExtendsClass) {
    this.rootExtendsClass = rootExtendsClass;
  }
  
  private boolean bindEPackageAndEFactory = false;
  
  /**
   * If set generated {@link EPackage} and {@link EFactory} interfaces are bound to their <code>eINSTANCE</code> instance.
   * @since 2.11
   */
  public void setBindEPackageAndEFactory(final boolean bindEPackageAndEFactory) {
    this.bindEPackageAndEFactory = bindEPackageAndEFactory;
  }
  
  protected String getModelPluginID() {
    String _elvis = null;
    if (this.modelPluginID != null) {
      _elvis = this.modelPluginID;
    } else {
      String _name = this.getProjectConfig().getRuntime().getName();
      _elvis = _name;
    }
    return _elvis;
  }
  
  protected String getJavaModelDirectory() {
    if ((this.javaModelDirectory != null)) {
      return this.javaModelDirectory;
    }
    final String srcGenPath = this.getProjectConfig().getRuntime().getSrcGen().getPath();
    final String rootPath = this.getProjectConfig().getRuntime().getRoot().getPath();
    if (((!StringExtensions.isNullOrEmpty(rootPath)) && srcGenPath.startsWith(rootPath))) {
      String _modelPluginID = this.getModelPluginID();
      String _plus = ("/" + _modelPluginID);
      String _substring = srcGenPath.substring(rootPath.length());
      return (_plus + _substring);
    }
    throw new RuntimeException(
      "Could not derive the Java model directory from the project configuration. Please set the property \'javaModelDirectory\' explicitly.");
  }
  
  protected String getModelName(final Grammar grammar) {
    String _xifexpression = null;
    if (this.longFileNames) {
      _xifexpression = grammar.getName().replace(".", "_");
    } else {
      _xifexpression = GrammarUtil.getSimpleName(grammar);
    }
    return _xifexpression;
  }
  
  protected String getEcoreFilePath(final Grammar grammar) {
    String _xblockexpression = null;
    {
      final String ecoreModelFolder = this.getProjectConfig().getRuntime().getEcoreModelFolder();
      String _modelPluginID = this.getModelPluginID();
      String _plus = ("/" + _modelPluginID);
      String _plus_1 = (_plus + "/");
      String _plus_2 = (_plus_1 + ecoreModelFolder);
      String _plus_3 = (_plus_2 + "/");
      String _modelName = this.getModelName(grammar);
      String _plus_4 = (_plus_3 + _modelName);
      _xblockexpression = (_plus_4 + ".ecore");
    }
    return _xblockexpression;
  }
  
  protected URI getEcoreFileUri(final Grammar grammar) {
    return URI.createPlatformResourceURI(this.getEcoreFilePath(grammar), true);
  }
  
  protected String getGenModelPath(final Grammar grammar) {
    String _elvis = null;
    if (this.genModel != null) {
      _elvis = this.genModel;
    } else {
      String _xblockexpression = null;
      {
        final String ecoreModelFolder = this.getProjectConfig().getRuntime().getEcoreModelFolder();
        String _modelPluginID = this.getModelPluginID();
        String _plus = ("/" + _modelPluginID);
        String _plus_1 = (_plus + "/");
        String _plus_2 = (_plus_1 + ecoreModelFolder);
        String _plus_3 = (_plus_2 + "/");
        String _modelName = this.getModelName(grammar);
        String _plus_4 = (_plus_3 + _modelName);
        _xblockexpression = (_plus_4 + ".genmodel");
      }
      _elvis = _xblockexpression;
    }
    return _elvis;
  }
  
  protected URI getGenModelUri(final Grammar grammar) {
    return URI.createPlatformResourceURI(this.getGenModelPath(grammar), true);
  }
  
  protected String getRelativePath(final String pathInRoot) {
    String _xblockexpression = null;
    {
      String _name = this.getProjectConfig().getRuntime().getName();
      final String projectPath = ("/" + _name);
      String _xifexpression = null;
      boolean _startsWith = pathInRoot.startsWith(projectPath);
      if (_startsWith) {
        int _length = projectPath.length();
        int _plus = (_length + 1);
        _xifexpression = pathInRoot.substring(_plus);
      } else {
        _xifexpression = pathInRoot;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String getEditPluginID() {
    String _elvis = null;
    if (this.editPluginID != null) {
      _elvis = this.editPluginID;
    } else {
      String _modelPluginID = this.getModelPluginID();
      String _plus = (_modelPluginID + ".edit");
      _elvis = _plus;
    }
    return _elvis;
  }
  
  protected String getEditDirectory() {
    String _elvis = null;
    if (this.editDirectory != null) {
      _elvis = this.editDirectory;
    } else {
      String _editPluginID = this.getEditPluginID();
      String _plus = ("/" + _editPluginID);
      String _plus_1 = (_plus + "/src");
      _elvis = _plus_1;
    }
    return _elvis;
  }
  
  protected String getEditorPluginID() {
    String _elvis = null;
    if (this.editorPluginID != null) {
      _elvis = this.editorPluginID;
    } else {
      String _modelPluginID = this.getModelPluginID();
      String _plus = (_modelPluginID + ".editor");
      _elvis = _plus;
    }
    return _elvis;
  }
  
  protected String getEditorDirectory() {
    String _elvis = null;
    if (this.editorDirectory != null) {
      _elvis = this.editorDirectory;
    } else {
      String _editorPluginID = this.getEditorPluginID();
      String _plus = (_editorPluginID + "/src");
      _elvis = _plus;
    }
    return _elvis;
  }
  
  protected String getBasePackage(final Grammar grammar) {
    String _elvis = null;
    if (this.basePackage != null) {
      _elvis = this.basePackage;
    } else {
      String _namespace = GrammarUtil.getNamespace(grammar);
      _elvis = _namespace;
    }
    return _elvis;
  }
  
  @Override
  public void initialize(final Injector injector) {
    super.initialize(injector);
    boolean _containsKey = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("genmodel");
    boolean _not = (!_containsKey);
    if (_not) {
      Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
      EcoreResourceFactoryImpl _ecoreResourceFactoryImpl = new EcoreResourceFactoryImpl();
      _extensionToFactoryMap.put("genmodel", _ecoreResourceFactoryImpl);
    }
    GenModelPackage.eINSTANCE.getGenAnnotation();
  }
  
  @Override
  public void generate() {
    boolean _isEmpty = IterableExtensions.isEmpty(Iterables.<GeneratedMetamodel>filter(this.getGrammar().getMetamodelDeclarations(), GeneratedMetamodel.class));
    if (_isEmpty) {
      return;
    }
    try {
      final Grammar clonedGrammar = this.cloneGrammarIntoNewResourceSet(this.getGrammar());
      final ResourceSet workingResourceSet = clonedGrammar.eResource().getResourceSet();
      final Function1<GeneratedMetamodel, EPackage> _function = (GeneratedMetamodel it) -> {
        return it.getEPackage();
      };
      final List<EPackage> generatedPackages = IterableExtensions.<EPackage>toList(IterableExtensions.<GeneratedMetamodel, EPackage>map(Iterables.<GeneratedMetamodel>filter(clonedGrammar.getMetamodelDeclarations(), GeneratedMetamodel.class), _function));
      if ((this.genModel != null)) {
        this.registerUsedGenModel(workingResourceSet.getURIConverter(), clonedGrammar);
      }
      boolean _isEmpty_1 = generatedPackages.isEmpty();
      boolean _not = (!_isEmpty_1);
      if (_not) {
        final Map<String, EPackage> usedEPackages = this.findAllUsedEPackages(generatedPackages);
        final Map<String, EPackage> loadedEPackages = this.findEPackagesInGenPackages(usedEPackages.keySet(), workingResourceSet);
        final Map<EObject, EObject> eNamedElementMapping = this.createENamedElementMapping(usedEPackages, loadedEPackages);
        this.replaceReferencesInGeneratedPackages(generatedPackages, eNamedElementMapping);
        final Resource ePackageResource = this.createResourceForEPackages(clonedGrammar, generatedPackages, workingResourceSet);
        if ((!this.skipGenerate)) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Generating EMF model");
          {
            if (this.generateEdit) {
              {
                if (this.generateEditor) {
                  _builder.append(", edit");
                } else {
                  _builder.append(" and edit");
                }
              }
            }
          }
          {
            if (this.generateEditor) {
              _builder.append(" and editor");
            }
          }
          _builder.append(" code");
          EMFGeneratorFragment2.LOG.info(_builder);
          final GenModel genModel = this.getSaveAndReconcileGenModel(clonedGrammar, generatedPackages, workingResourceSet);
          genModel.reconcile();
          this.doGenerate(genModel);
          this.addProjectContributions(clonedGrammar, generatedPackages, workingResourceSet);
          if (this.bindEPackageAndEFactory) {
            for (final EPackage pkg : generatedPackages) {
              {
                final GenPackage genPkg = GenModelUtil2.getGenPackage(pkg, genModel.eResource().getResourceSet());
                GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
                TypeReference _typeRef = TypeReference.typeRef(genPkg.getQualifiedPackageInterfaceName());
                StringConcatenationClient _client = new StringConcatenationClient() {
                  @Override
                  protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                    String _packageInterfaceName = genPkg.getPackageInterfaceName();
                    _builder.append(_packageInterfaceName);
                    _builder.append(".eINSTANCE");
                  }
                };
                GuiceModuleAccess.BindingFactory _addTypeToInstance = _bindingFactory.addTypeToInstance(_typeRef, _client);
                TypeReference _typeRef_1 = TypeReference.typeRef(genPkg.getQualifiedFactoryInterfaceName());
                StringConcatenationClient _client_1 = new StringConcatenationClient() {
                  @Override
                  protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                    String _factoryInterfaceName = genPkg.getFactoryInterfaceName();
                    _builder.append(_factoryInterfaceName);
                    _builder.append(".eINSTANCE");
                  }
                };
                _addTypeToInstance.addTypeToInstance(_typeRef_1, _client_1).contributeTo(this.getLanguage().getRuntimeGenModule());
              }
            }
          }
        }
        this.saveResource(ePackageResource);
      }
      this.updateBuildProperties();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        EMFGeneratorFragment2.LOG.error("Failed to execute EMF generator", e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected void addProjectContributions(final Grammar grammar, final List<EPackage> generatedPackages, final ResourceSet rs) {
    PluginXmlAccess _pluginXml = this.getProjectConfig().getRuntime().getPluginXml();
    boolean _tripleNotEquals = (_pluginXml != null);
    if (_tripleNotEquals) {
      List<CharSequence> _entries = this.getProjectConfig().getRuntime().getPluginXml().getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<extension point=\"org.eclipse.emf.ecore.generated_package\">");
      _builder.newLine();
      {
        for(final EPackage pack : generatedPackages) {
          _builder.append("\t");
          _builder.append("<package");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("uri = \"");
          String _nsURI = pack.getNsURI();
          _builder.append(_nsURI, "\t\t");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("class = \"");
          String _qualifiedPackageInterfaceName = GenModelUtil2.getGenPackage(pack, rs).getQualifiedPackageInterfaceName();
          _builder.append(_qualifiedPackageInterfaceName, "\t\t");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("genModel = \"");
          String _relativePath = this.getRelativePath(this.getGenModelPath(grammar));
          _builder.append(_relativePath, "\t\t");
          _builder.append("\" />");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("</extension>");
      _builder.newLine();
      _entries.add(_builder.toString());
    }
    ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
    boolean _tripleNotEquals_1 = (_manifest != null);
    if (_tripleNotEquals_1) {
      CollectionExtensions.<String>addAll(this.getProjectConfig().getRuntime().getManifest().getRequiredBundles(), "org.eclipse.emf.ecore", "org.eclipse.emf.common");
    }
    for (final EPackage pack_1 : generatedPackages) {
      {
        final GenPackage genPackage = GenModelUtil2.getGenPackage(pack_1, rs);
        if (((this.getProjectConfig().getRuntime().getManifest() != null) && (this.modelPluginID == null))) {
          CollectionExtensions.<String>addAll(this.getProjectConfig().getRuntime().getManifest().getExportedPackages(), 
            genPackage.getInterfacePackageName(), 
            genPackage.getClassPackageName(), 
            genPackage.getUtilitiesPackageName());
        }
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("if (!");
            _builder.append(EPackage.class);
            _builder.append(".Registry.INSTANCE.containsKey(\"");
            String _nsURI = pack_1.getNsURI();
            _builder.append(_nsURI);
            _builder.append("\")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(EPackage.class, "\t");
            _builder.append(".Registry.INSTANCE.put(\"");
            String _nsURI_1 = pack_1.getNsURI();
            _builder.append(_nsURI_1, "\t");
            _builder.append("\", ");
            String _qualifiedPackageInterfaceName = genPackage.getQualifiedPackageInterfaceName();
            TypeReference _typeReference = new TypeReference(_qualifiedPackageInterfaceName);
            _builder.append(_typeReference, "\t");
            _builder.append(".eINSTANCE);");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        };
        this.getLanguage().getRuntimeGenSetup().getRegistrations().add(_client);
      }
    }
  }
  
  /**
   * Create a clone of the original grammar. The clone will not refer to a node model.
   */
  private Grammar cloneGrammarIntoNewResourceSet(final Grammar original) {
    final Resource originalResource = original.eResource();
    XtextResourceSet _xtextResourceSet = new XtextResourceSet();
    final XtextResourceSet clonedResourceSet = EcoreUtil2.<XtextResourceSet>clone(_xtextResourceSet, originalResource.getResourceSet());
    final Resource clonedResource = clonedResourceSet.getResource(originalResource.getURI(), false);
    EObject _head = IterableExtensions.<EObject>head(clonedResource.getContents());
    return ((Grammar) _head);
  }
  
  private void registerUsedGenModel(final URIConverter converter, final Grammar grammar) {
    final URI genModelUri = this.getGenModelUri(grammar);
    boolean _exists = converter.exists(genModelUri, null);
    if (_exists) {
      try {
        GenModelHelper _genModelHelper = new GenModelHelper();
        XtextResourceSet _xtextResourceSet = new XtextResourceSet();
        _genModelHelper.registerGenModel(_xtextResourceSet, genModelUri);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          EMFGeneratorFragment2.LOG.error("Failed to register GenModel", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  private Map<String, EPackage> findAllUsedEPackages(final List<EPackage> generatedPackages) {
    final HashMap<String, EPackage> result = CollectionLiterals.<String, EPackage>newHashMap();
    final TreeIterator<EObject> packageContentIterator = EcoreUtil.<EObject>getAllContents(generatedPackages);
    while (packageContentIterator.hasNext()) {
      {
        final EObject current = packageContentIterator.next();
        EList<EObject> _eCrossReferences = current.eCrossReferences();
        for (final EObject referenced : _eCrossReferences) {
          {
            boolean _eIsProxy = referenced.eIsProxy();
            if (_eIsProxy) {
              throw new RuntimeException(((("Unresolved proxy: " + referenced) + " in ") + current));
            }
            if ((referenced instanceof EClassifier)) {
              final EPackage referencedPackage = ((EClassifier)referenced).getEPackage();
              boolean _contains = generatedPackages.contains(referencedPackage);
              boolean _not = (!_contains);
              if (_not) {
                result.put(referencedPackage.getNsURI(), referencedPackage);
              }
            }
          }
        }
      }
    }
    return result;
  }
  
  private Map<String, EPackage> findEPackagesInGenPackages(final Collection<String> packageNsURIs, final ResourceSet resourceSet) {
    final HashMap<String, EPackage> result = CollectionLiterals.<String, EPackage>newHashMap();
    for (final String nsURI : packageNsURIs) {
      {
        final Resource resource = GenModelUtil2.getGenModelResource(null, nsURI, resourceSet);
        if ((resource != null)) {
          final GenModel loadedGenModel = IterableExtensions.<GenModel>head(Iterables.<GenModel>filter(resource.getContents(), GenModel.class));
          if ((loadedGenModel != null)) {
            final GenPackage genPackage = this.findGenPackageByNsURI(loadedGenModel, nsURI);
            result.put(nsURI, genPackage.getEcorePackage());
          }
        }
      }
    }
    return result;
  }
  
  private GenPackage findGenPackageByNsURI(final GenModel genModel, final String nsURI) {
    final List<GenPackage> allGenPackages = genModel.getAllGenUsedAndStaticGenPackagesWithClassifiers();
    for (final GenPackage genPackage : allGenPackages) {
      {
        final EPackage ecorePackage = genPackage.getEcorePackage();
        if (((ecorePackage == null) || ecorePackage.eIsProxy())) {
          URI _uRI = genModel.eResource().getURI();
          String _plus = ((("Unresolved proxy: " + ecorePackage) + " in ") + _uRI);
          throw new RuntimeException(_plus);
        }
        String _nsURI = ecorePackage.getNsURI();
        boolean _equals = Objects.equal(nsURI, _nsURI);
        if (_equals) {
          return genPackage;
        }
      }
    }
    URI _uRI = genModel.eResource().getURI();
    String _plus = ((("No GenPackage for NsURI " + nsURI) + " found in ") + _uRI);
    throw new RuntimeException(_plus);
  }
  
  private Map<EObject, EObject> createENamedElementMapping(final Map<String, EPackage> usedEPackages, final Map<String, EPackage> loadedEPackages) {
    final HashMap<EObject, EObject> result = CollectionLiterals.<EObject, EObject>newHashMap();
    Set<Map.Entry<String, EPackage>> _entrySet = usedEPackages.entrySet();
    for (final Map.Entry<String, EPackage> entry : _entrySet) {
      this.putMappingData(result, entry.getValue(), loadedEPackages.get(entry.getKey()));
    }
    return result;
  }
  
  private void putMappingData(final Map<EObject, EObject> result, final EPackage usedEPackage, final EPackage loadedEPackage) {
    if (((loadedEPackage != null) && (!Objects.equal(usedEPackage, loadedEPackage)))) {
      result.put(usedEPackage, loadedEPackage);
      EList<EClassifier> _eClassifiers = usedEPackage.getEClassifiers();
      for (final EClassifier usedClassifier : _eClassifiers) {
        {
          final EClassifier loadedClassifier = loadedEPackage.getEClassifier(usedClassifier.getName());
          if ((loadedClassifier == null)) {
            String _name = usedClassifier.getName();
            String _plus = ("Cannot find classifier \'" + _name);
            String _plus_1 = (_plus + "\' in loaded EPackage from ");
            URI _uRI = loadedEPackage.eResource().getURI();
            String _plus_2 = (_plus_1 + _uRI);
            throw new RuntimeException(_plus_2);
          }
          result.put(usedClassifier, loadedClassifier);
        }
      }
      EList<EPackage> _eSubpackages = usedEPackage.getESubpackages();
      for (final EPackage usedNestedPackage : _eSubpackages) {
        {
          final Function1<EPackage, Boolean> _function = (EPackage it) -> {
            String _name = it.getName();
            String _name_1 = usedNestedPackage.getName();
            return Boolean.valueOf(Objects.equal(_name, _name_1));
          };
          final EPackage loadedNestedPackage = IterableExtensions.<EPackage>findFirst(loadedEPackage.getESubpackages(), _function);
          if ((loadedNestedPackage != null)) {
            this.putMappingData(result, usedNestedPackage, loadedNestedPackage);
          }
        }
      }
    }
  }
  
  private void replaceReferencesInGeneratedPackages(final List<EPackage> generatedPackages, final Map<EObject, EObject> eNamedElementMapping) {
    final TreeIterator<EObject> packageContentIterator = EcoreUtil.<EObject>getAllContents(generatedPackages);
    while (packageContentIterator.hasNext()) {
      {
        final EObject current = packageContentIterator.next();
        EList<EStructuralFeature> _eAllStructuralFeatures = current.eClass().getEAllStructuralFeatures();
        final EStructuralFeature[] crossReferenceFeatures = ((EClassImpl.FeatureSubsetSupplier) _eAllStructuralFeatures).crossReferences();
        if ((crossReferenceFeatures != null)) {
          for (final EStructuralFeature crossReferenceFeature : crossReferenceFeatures) {
            boolean _isChangeable = crossReferenceFeature.isChangeable();
            if (_isChangeable) {
              final EReference reference = ((EReference) crossReferenceFeature);
              boolean _isMany = reference.isMany();
              if (_isMany) {
                Object _eGet = current.eGet(reference);
                final List<EObject> values = ((List<EObject>) _eGet);
                for (final EObject value : values) {
                  boolean _containsKey = eNamedElementMapping.containsKey(value);
                  if (_containsKey) {
                    EcoreUtil.replace(current, reference, value, eNamedElementMapping.get(value));
                  }
                }
              } else {
                Object _eGet_1 = current.eGet(reference);
                final EObject value_1 = ((EObject) _eGet_1);
                boolean _containsKey_1 = eNamedElementMapping.containsKey(value_1);
                if (_containsKey_1) {
                  EcoreUtil.replace(current, reference, value_1, eNamedElementMapping.get(value_1));
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected Resource createResourceForEPackages(final Grammar grammar, final List<EPackage> packs, final ResourceSet rs) {
    final URI ecoreFileUri = this.getEcoreFileUri(grammar);
    final Resource existing = rs.getResource(ecoreFileUri, false);
    if ((existing != null)) {
      existing.unload();
      rs.getResources().remove(existing);
    }
    final Resource ecoreFile = rs.createResource(ecoreFileUri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
    ecoreFile.getContents().addAll(packs);
    return ecoreFile;
  }
  
  protected GenModel getSaveAndReconcileGenModel(final Grammar grammar, final List<EPackage> packs, final ResourceSet rs) {
    final GenModel genModel = this.getGenModel(rs, grammar);
    genModel.initialize(packs);
    EList<GenPackage> _genPackages = genModel.getGenPackages();
    for (final GenPackage genPackage : _genPackages) {
      {
        genPackage.setBasePackage(this.getBasePackage(grammar));
        if (this.suppressLoadInitialization) {
          genPackage.setLoadInitialization(false);
        }
        if (((!this.getLanguage().getFileExtensions().isEmpty()) && packs.contains(genPackage.getEcorePackage()))) {
          genPackage.setFileExtensions(IterableExtensions.join(this.getLanguage().getFileExtensions(), ","));
        }
      }
    }
    final Set<EPackage> referencedEPackages = this.getReferencedEPackages(packs);
    final List<GenPackage> usedGenPackages = this.getGenPackagesForPackages(genModel, referencedEPackages);
    this.reconcileMissingGenPackagesInUsedModels(usedGenPackages);
    genModel.getUsedGenPackages().addAll(usedGenPackages);
    this.saveResource(genModel.eResource());
    new GenModelHelper().registerGenModel(genModel);
    return genModel;
  }
  
  /**
   * @since 2.14
   */
  protected void reconcileMissingGenPackagesInUsedModels(final List<GenPackage> usedGenPackages) {
    final HashSet<GenModel> processedModels = Sets.<GenModel>newHashSetWithExpectedSize(usedGenPackages.size());
    for (final GenPackage usedGenPackage : usedGenPackages) {
      {
        final GenModel genModel = usedGenPackage.getGenModel();
        boolean _add = processedModels.add(genModel);
        if (_add) {
          final List<EPackage> missingPackages = genModel.getMissingPackages();
          final List<GenPackage> missingGenPackages = this.getGenPackagesForPackages(genModel, missingPackages);
          genModel.getUsedGenPackages().addAll(missingGenPackages);
        }
      }
    }
  }
  
  protected GenModel getGenModel(final ResourceSet rs, final Grammar grammar) {
    try {
      final URI genModelUri = this.getGenModelUri(grammar);
      final Resource resource = rs.getResource(genModelUri, false);
      if ((resource != null)) {
        resource.unload();
        rs.getResources().remove(resource);
      }
      final Resource genModelFile = rs.createResource(genModelUri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
      GenModel genModel = null;
      boolean _exists = rs.getURIConverter().exists(genModelUri, null);
      if (_exists) {
        genModelFile.load(null);
        boolean _hasFragment = genModelUri.hasFragment();
        if (_hasFragment) {
          EObject _eObject = genModelFile.getEObject(genModelUri.fragment());
          genModel = ((GenModel) _eObject);
        } else {
          EObject _head = IterableExtensions.<EObject>head(genModelFile.getContents());
          genModel = ((GenModel) _head);
        }
      } else {
        genModel = new GenModelImpl() {
          @Override
          public GenPackage createGenPackage() {
            return new GenPackageImpl() {
              @Override
              public String getSerializedPackageFilename() {
                String _name = this.getName();
                return (_name + ".loadinitialization_ecore");
              }
            };
          }
        };
        genModel.setModelName(this.getModelName(grammar));
        genModel.setModelPluginID(this.getModelPluginID());
        genModel.setModelDirectory(this.getJavaModelDirectory());
        if (this.generateEdit) {
          genModel.setEditPluginID(this.getEditPluginID());
          genModel.setEditDirectory(this.getEditDirectory());
        }
        if (this.generateEditor) {
          genModel.setEditorPluginID(this.getEditorPluginID());
          genModel.setEditorDirectory(this.getEditorDirectory());
        }
        genModel.setValidateModel(false);
        genModel.setForceOverwrite(true);
        genModel.setFacadeHelperClass(null);
        genModel.setBundleManifest(true);
        genModel.setUpdateClasspath(false);
        genModel.setComplianceLevel(this.jdkLevel);
        genModel.setRuntimeVersion(this.emfRuntimeVersion);
        genModel.setRootExtendsClass(this.rootExtendsClass);
        genModel.setLineDelimiter(this.codeConfig.getLineDelimiter());
        String _fileHeader = this.codeConfig.getFileHeader();
        boolean _tripleNotEquals = (_fileHeader != null);
        if (_tripleNotEquals) {
          genModel.setCopyrightText(this.trimMultiLineComment(this.codeConfig.getFileHeader()));
        }
      }
      genModelFile.getContents().add(genModel);
      return genModel;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String trimMultiLineComment(final String string) {
    return string.replace(" * ", "").replaceAll("/\\*+\\s*|\\s*\\*+/", "").trim();
  }
  
  protected Set<EPackage> getReferencedEPackages(final List<EPackage> packs) {
    final HashSet<EPackage> result = CollectionLiterals.<EPackage>newHashSet();
    for (final EPackage pkg : packs) {
      {
        final TreeIterator<EObject> iterator = pkg.eAllContents();
        while (iterator.hasNext()) {
          {
            final EObject obj = iterator.next();
            EList<EObject> _eCrossReferences = obj.eCrossReferences();
            for (final EObject crossRef : _eCrossReferences) {
              boolean _eIsProxy = crossRef.eIsProxy();
              if (_eIsProxy) {
                URI _eProxyURI = ((InternalEObject) crossRef).eProxyURI();
                String _plus = ("Proxy \'" + _eProxyURI);
                String _plus_1 = (_plus + "\' could not be resolved");
                EMFGeneratorFragment2.LOG.error(_plus_1);
              } else {
                final EPackage p = EcoreUtil2.<EPackage>getContainerOfType(crossRef, EPackage.class);
                if ((p != null)) {
                  result.add(p);
                }
              }
            }
          }
        }
      }
    }
    result.removeAll(packs);
    result.remove(EcorePackage.eINSTANCE);
    result.remove(XMLTypePackage.eINSTANCE);
    result.remove(XMLNamespacePackage.eINSTANCE);
    return result;
  }
  
  protected List<GenPackage> getGenPackagesForPackages(final GenModel existingGenModel, final Collection<EPackage> packs) {
    final ArrayList<GenPackage> result = CollectionLiterals.<GenPackage>newArrayList();
    for (final EPackage pkg : packs) {
      final Function1<GenPackage, Boolean> _function = (GenPackage it) -> {
        EPackage _ecorePackage = it.getEcorePackage();
        String _nsURI = null;
        if (_ecorePackage!=null) {
          _nsURI=_ecorePackage.getNsURI();
        }
        String _nsURI_1 = pkg.getNsURI();
        return Boolean.valueOf(Objects.equal(_nsURI, _nsURI_1));
      };
      boolean _exists = IterableExtensions.<GenPackage>exists(existingGenModel.getGenPackages(), _function);
      boolean _not = (!_exists);
      if (_not) {
        result.add(GenModelUtil2.getGenPackage(pkg, existingGenModel.eResource().getResourceSet()));
      }
    }
    final Comparator<GenPackage> _function_1 = (GenPackage o1, GenPackage o2) -> {
      return EcoreUtil.getURI(o1).toString().compareTo(EcoreUtil.getURI(o2).toString());
    };
    Collections.<GenPackage>sort(result, _function_1);
    return result;
  }
  
  /**
   * @since 2.14
   */
  protected void saveResource(final Resource resource) {
    try {
      final HashMap<String, Object> saveOptions = CollectionLiterals.<String, Object>newHashMap();
      saveOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.AbsoluteCrossBundleAware() {
        @Override
        public URI deresolve(final URI uri) {
          boolean _isPlatform = uri.isPlatform();
          boolean _not = (!_isPlatform);
          if (_not) {
            Set<Map.Entry<String, URI>> _entrySet = EcorePlugin.getPlatformResourceMap().entrySet();
            for (final Map.Entry<String, URI> entry : _entrySet) {
              {
                String _key = entry.getKey();
                String _plus = ("platform:/resource/" + _key);
                String _plus_1 = (_plus + "/");
                final URI newPrefix = URI.createURI(_plus_1);
                final URI uri2 = uri.replacePrefix(entry.getValue(), newPrefix);
                if ((uri2 != null)) {
                  return super.deresolve(uri2);
                }
              }
            }
          }
          return super.deresolve(uri);
        }
      });
      saveOptions.put(Resource.OPTION_LINE_DELIMITER, this.codeConfig.getLineDelimiter());
      resource.save(saveOptions);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void doGenerate(final GenModel genModel) {
    final Generator generator = new Generator() {
      @Override
      public JControlModel getJControlModel() {
        if ((this.jControlModel == null)) {
          JControlModel _jControlModel = new JControlModel();
          this.jControlModel = _jControlModel;
          this.jControlModel.initialize(null, this.options.mergeRulesURI);
        }
        return this.jControlModel;
      }
    };
    GeneratorAdapterFactory.Descriptor.Registry _adapterFactoryDescriptorRegistry = generator.getAdapterFactoryDescriptorRegistry();
    String _lineDelimiter = this.codeConfig.getLineDelimiter();
    CvsIdFilteringGeneratorAdapterFactoryDescriptor _cvsIdFilteringGeneratorAdapterFactoryDescriptor = new CvsIdFilteringGeneratorAdapterFactoryDescriptor(_lineDelimiter);
    _adapterFactoryDescriptorRegistry.addDescriptor(GenModelPackage.eNS_URI, _cvsIdFilteringGeneratorAdapterFactoryDescriptor);
    genModel.setCanGenerate(true);
    generator.setInput(genModel);
    BasicMonitor _basicMonitor = new BasicMonitor();
    final Diagnostic diagnostic = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, _basicMonitor);
    int _severity = diagnostic.getSeverity();
    boolean _notEquals = (_severity != Diagnostic.OK);
    if (_notEquals) {
      EMFGeneratorFragment2.LOG.warn(diagnostic);
    }
    if (this.generateEdit) {
      BasicMonitor _basicMonitor_1 = new BasicMonitor();
      final Diagnostic editDiag = generator.generate(genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, _basicMonitor_1);
      int _severity_1 = editDiag.getSeverity();
      boolean _notEquals_1 = (_severity_1 != Diagnostic.OK);
      if (_notEquals_1) {
        EMFGeneratorFragment2.LOG.warn(editDiag);
      }
    }
    if (this.generateEditor) {
      BasicMonitor _basicMonitor_2 = new BasicMonitor();
      final Diagnostic editorDiag = generator.generate(genModel, GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE, _basicMonitor_2);
      int _severity_2 = editorDiag.getSeverity();
      boolean _notEquals_2 = (_severity_2 != Diagnostic.OK);
      if (_notEquals_2) {
        EMFGeneratorFragment2.LOG.warn(editorDiag);
      }
    }
  }
  
  private void updateBuildProperties() {
    try {
      if ((((!this.updateBuildProperties) || (this.modelPluginID != null)) || (this.getProjectConfig().getRuntime().getManifest() == null))) {
        return;
      }
      String _path = this.getProjectConfig().getRuntime().getRoot().getPath();
      final String buildPropertiesPath = (_path + "/build.properties");
      final File buildPropertiesFile = new File(buildPropertiesPath);
      boolean _exists = buildPropertiesFile.exists();
      if (_exists) {
        final String modelContainer = this.getProjectConfig().getRuntime().getEcoreModelFolder();
        final Properties buildProperties = new Properties();
        final Charset charset = Charset.forName(this.codeConfig.getEncoding());
        FileInputStream _fileInputStream = new FileInputStream(buildPropertiesFile);
        final InputStreamReader reader = new InputStreamReader(_fileInputStream, charset);
        String _xtrycatchfinallyexpression = null;
        try {
          _xtrycatchfinallyexpression = CharStreams.toString(reader);
        } finally {
          reader.close();
        }
        String existingContent = _xtrycatchfinallyexpression;
        StringInputStream _stringInputStream = new StringInputStream(existingContent, "ISO-8859-1");
        buildProperties.load(_stringInputStream);
        final String binIncludes = buildProperties.getProperty("bin.includes");
        boolean changed = false;
        if ((binIncludes == null)) {
          String _existingContent = existingContent;
          String _newLine = Strings.newLine();
          String _plus = ((("bin.includes = " + modelContainer) + "/") + _newLine);
          String _plus_1 = (_plus + "               ");
          existingContent = (_existingContent + _plus_1);
          changed = true;
        } else {
          boolean _contains = binIncludes.contains(modelContainer);
          boolean _not = (!_contains);
          if (_not) {
            String _newLine_1 = Strings.newLine();
            String _plus_2 = ((("bin.includes = " + modelContainer) + "/,\\") + _newLine_1);
            String _plus_3 = (_plus_2 + "               ");
            existingContent = existingContent.replace("bin.includes = ", _plus_3);
            changed = true;
          }
        }
        if (changed) {
          FileOutputStream _fileOutputStream = new FileOutputStream(buildPropertiesFile);
          final OutputStreamWriter writer = new OutputStreamWriter(_fileOutputStream, charset);
          try {
            writer.write(existingContent);
          } finally {
            writer.close();
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static final Logger LOG = Logger.getLogger(EMFGeneratorFragment2.class);
  
  public void setBasePackage(final String basePackage) {
    this.basePackage = basePackage;
  }
  
  public void setModelPluginID(final String modelPluginID) {
    this.modelPluginID = modelPluginID;
  }
  
  public void setJavaModelDirectory(final String javaModelDirectory) {
    this.javaModelDirectory = javaModelDirectory;
  }
  
  public void setGenerateEdit(final boolean generateEdit) {
    this.generateEdit = generateEdit;
  }
  
  public void setEditPluginID(final String editPluginID) {
    this.editPluginID = editPluginID;
  }
  
  public void setEditDirectory(final String editDirectory) {
    this.editDirectory = editDirectory;
  }
  
  public void setGenerateEditor(final boolean generateEditor) {
    this.generateEditor = generateEditor;
  }
  
  public void setEditorPluginID(final String editorPluginID) {
    this.editorPluginID = editorPluginID;
  }
  
  public void setEditorDirectory(final String editorDirectory) {
    this.editorDirectory = editorDirectory;
  }
  
  public void setGenModel(final String genModel) {
    this.genModel = genModel;
  }
  
  public void setSkipGenerate(final boolean skipGenerate) {
    this.skipGenerate = skipGenerate;
  }
  
  public void setUpdateBuildProperties(final boolean updateBuildProperties) {
    this.updateBuildProperties = updateBuildProperties;
  }
  
  public void setLongFileNames(final boolean longFileNames) {
    this.longFileNames = longFileNames;
  }
  
  public void setSuppressLoadInitialization(final boolean suppressLoadInitialization) {
    this.suppressLoadInitialization = suppressLoadInitialization;
  }
}
