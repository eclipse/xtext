/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
import java.util.LinkedList;
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
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
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.utils.GenModelHelper;
import org.eclipse.emf.mwe2.ecore.CvsIdFilteringGeneratorAdapterFactoryDescriptor;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
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
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;

@Log
@SuppressWarnings("all")
public class EMFGeneratorFragment2 extends AbstractGeneratorFragment2 {
  @Inject
  private CodeConfig codeConfig;
  
  /**
   * The java package into which the generated Java classes shall be placed.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String basePackage;
  
  /**
   * Whether EMF edit code shall be generated.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean generateEdit = false;
  
  /**
   * The target directory for the generated EMF edit code. Only needed if you want to generate an EMF edit plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String editDirectory;
  
  /**
   * The plug-in ID of the generated EMF edit plug-in. Only needed if you want to generate an EMF edit plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String editPluginID;
  
  /**
   * Whether EMF editor code shall be generated.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean generateEditor = false;
  
  /**
   * The target directory for the generated EMF editor code. Only needed if you want to generate an EMF editor plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String editorDirectory;
  
  /**
   * The plug-in ID of the generated EMF editor plug-in. Only needed if you want to generate an EMF editor plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String editorPluginID;
  
  /**
   * If an existing EMF GenModel should be used, set the path to that file in this property.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String genModel;
  
  /**
   * Sets the target directory for the generated EMF model code. Only needed if you want to generate the EMF code into
   * a separate plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String javaModelDirectory;
  
  /**
   * Sets the ID of the generated EMF model plug-in. Only needed if you want to generate the EMF code into a separate plug-in.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String modelPluginID;
  
  /**
   * Whether the Java class generation should be skipped. If <code>true</code> only the ecore file is generated.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean skipGenerate = false;
  
  /**
   * Whether the build.properties should be updated.
   */
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean updateBuildProperties = true;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String fileExtensions;
  
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
  
  private GenRuntimeVersion emfRuntimeVersion;
  
  private GenJDKLevel jdkLevel = GenJDKLevel.JDK60_LITERAL;
  
  /**
   * Sets the target EMF runtime version to generate for to the specified value.
   */
  public void setEmfRuntimeVersion(final String emfRuntimeVersion) {
    GenRuntimeVersion _get = GenRuntimeVersion.get(emfRuntimeVersion);
    this.emfRuntimeVersion = _get;
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
   * The default level is "JDK60".
   */
  public void setJdkLevel(final String jdkLevel) {
    GenJDKLevel _byName = GenJDKLevel.getByName(jdkLevel);
    this.jdkLevel = _byName;
    if ((this.jdkLevel == null)) {
      EMFGeneratorFragment2.LOG.warn(("Illegal JDK level: " + jdkLevel));
    }
  }
  
  protected String getJavaModelDirectory() {
    String _elvis = null;
    if (this.javaModelDirectory != null) {
      _elvis = this.javaModelDirectory;
    } else {
      XtextProjectConfig _projectConfig = this.getProjectConfig();
      RuntimeProjectConfig _runtime = _projectConfig.getRuntime();
      IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
      String _path = _srcGen.getPath();
      _elvis = _path;
    }
    return _elvis;
  }
  
  protected String getModelName(final Grammar grammar) {
    String _xifexpression = null;
    if (this.longFileNames) {
      String _name = grammar.getName();
      _xifexpression = _name.replace(".", "_");
    } else {
      _xifexpression = GrammarUtil.getSimpleName(grammar);
    }
    return _xifexpression;
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
  
  protected String getEcoreFilePath(final Grammar grammar) {
    XtextProjectConfig _projectConfig = this.getProjectConfig();
    RuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _ecoreModel = _runtime.getEcoreModel();
    String _path = _ecoreModel.getPath();
    String _plus = (_path + "/");
    String _modelName = this.getModelName(grammar);
    String _plus_1 = (_plus + _modelName);
    return (_plus_1 + ".ecore");
  }
  
  protected URI getEcoreFileUri(final Grammar grammar) {
    String _ecoreFilePath = this.getEcoreFilePath(grammar);
    String _canonicalPath = this.getCanonicalPath(_ecoreFilePath);
    return URI.createPlatformResourceURI(_canonicalPath, true);
  }
  
  protected String getGenModelPath(final Grammar grammar) {
    String _elvis = null;
    if (this.genModel != null) {
      _elvis = this.genModel;
    } else {
      XtextProjectConfig _projectConfig = this.getProjectConfig();
      RuntimeProjectConfig _runtime = _projectConfig.getRuntime();
      IXtextGeneratorFileSystemAccess _ecoreModel = _runtime.getEcoreModel();
      String _path = _ecoreModel.getPath();
      String _plus = (_path + "/");
      String _modelName = this.getModelName(grammar);
      String _plus_1 = (_plus + _modelName);
      String _plus_2 = (_plus_1 + ".genmodel");
      _elvis = _plus_2;
    }
    return _elvis;
  }
  
  protected URI getGenModelUri(final Grammar grammar) {
    String _genModelPath = this.getGenModelPath(grammar);
    String _canonicalPath = this.getCanonicalPath(_genModelPath);
    return URI.createPlatformResourceURI(_canonicalPath, true);
  }
  
  protected String getRelativePath(final String pathInRoot) {
    String _xblockexpression = null;
    {
      XtextProjectConfig _projectConfig = this.getProjectConfig();
      RuntimeProjectConfig _runtime = _projectConfig.getRuntime();
      IXtextGeneratorFileSystemAccess _root = _runtime.getRoot();
      final String projectRoot = _root.getPath();
      String _xifexpression = null;
      boolean _startsWith = pathInRoot.startsWith(projectRoot);
      if (_startsWith) {
        int _length = projectRoot.length();
        int _plus = (_length + 1);
        _xifexpression = pathInRoot.substring(_plus);
      } else {
        _xifexpression = pathInRoot;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String getCanonicalPath(final String path) {
    final LinkedList<String> result = CollectionLiterals.<String>newLinkedList();
    boolean isAbsolute = path.startsWith("/");
    String[] _split = path.split("[/\\\\]");
    for (final String segment : _split) {
      boolean _equals = Objects.equal(segment, "..");
      if (_equals) {
        boolean _isEmpty = result.isEmpty();
        if (_isEmpty) {
          isAbsolute = true;
        } else {
          result.removeLast();
        }
      } else {
        boolean _and = false;
        int _length = segment.length();
        boolean _greaterThan = (_length > 0);
        if (!_greaterThan) {
          _and = false;
        } else {
          boolean _notEquals = (!Objects.equal(segment, "."));
          _and = _notEquals;
        }
        if (_and) {
          result.addLast(segment);
        }
      }
    }
    if (isAbsolute) {
      final Function1<String, CharSequence> _function = new Function1<String, CharSequence>() {
        @Override
        public CharSequence apply(final String it) {
          return it;
        }
      };
      return IterableExtensions.<String>join(result, "/", "/", null, _function);
    } else {
      return IterableExtensions.join(result, "/");
    }
  }
  
  protected String getModelPluginID() {
    String _elvis = null;
    if (this.modelPluginID != null) {
      _elvis = this.modelPluginID;
    } else {
      String _xblockexpression = null;
      {
        XtextProjectConfig _projectConfig = this.getProjectConfig();
        RuntimeProjectConfig _runtime = _projectConfig.getRuntime();
        IXtextGeneratorFileSystemAccess _root = _runtime.getRoot();
        final String path = _root.getPath();
        int _lastIndexOf = path.lastIndexOf("/");
        int _plus = (_lastIndexOf + 1);
        _xblockexpression = path.substring(_plus);
      }
      _elvis = _xblockexpression;
    }
    return _elvis;
  }
  
  protected String getEditDirectory() {
    String _elvis = null;
    if (this.editDirectory != null) {
      _elvis = this.editDirectory;
    } else {
      XtextProjectConfig _projectConfig = this.getProjectConfig();
      RuntimeProjectConfig _runtime = _projectConfig.getRuntime();
      IXtextGeneratorFileSystemAccess _root = _runtime.getRoot();
      String _path = _root.getPath();
      String _plus = (_path + ".edit/src");
      _elvis = _plus;
    }
    return _elvis;
  }
  
  protected String getEditorDirectory() {
    String _elvis = null;
    if (this.editorDirectory != null) {
      _elvis = this.editorDirectory;
    } else {
      XtextProjectConfig _projectConfig = this.getProjectConfig();
      RuntimeProjectConfig _runtime = _projectConfig.getRuntime();
      IXtextGeneratorFileSystemAccess _root = _runtime.getRoot();
      String _path = _root.getPath();
      String _plus = (_path + ".editor/src");
      _elvis = _plus;
    }
    return _elvis;
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
  
  @Override
  public void initialize(final Injector injector) {
    super.initialize(injector);
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    boolean _containsKey = _extensionToFactoryMap.containsKey("genmodel");
    boolean _not = (!_containsKey);
    if (_not) {
      Map<String, Object> _extensionToFactoryMap_1 = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
      EcoreResourceFactoryImpl _ecoreResourceFactoryImpl = new EcoreResourceFactoryImpl();
      _extensionToFactoryMap_1.put("genmodel", _ecoreResourceFactoryImpl);
    }
    GenModelPackage.eINSTANCE.getGenAnnotation();
  }
  
  @Override
  public void generate() {
    Grammar _grammar = this.getGrammar();
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations = _grammar.getMetamodelDeclarations();
    Iterable<GeneratedMetamodel> _filter = Iterables.<GeneratedMetamodel>filter(_metamodelDeclarations, GeneratedMetamodel.class);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter);
    if (_isEmpty) {
      return;
    }
    try {
      Grammar _grammar_1 = this.getGrammar();
      final Grammar clonedGrammar = this.cloneGrammarIntoNewResourceSet(_grammar_1);
      Resource _eResource = clonedGrammar.eResource();
      final ResourceSet workingResourceSet = _eResource.getResourceSet();
      EList<AbstractMetamodelDeclaration> _metamodelDeclarations_1 = clonedGrammar.getMetamodelDeclarations();
      Iterable<GeneratedMetamodel> _filter_1 = Iterables.<GeneratedMetamodel>filter(_metamodelDeclarations_1, GeneratedMetamodel.class);
      final Function1<GeneratedMetamodel, EPackage> _function = new Function1<GeneratedMetamodel, EPackage>() {
        @Override
        public EPackage apply(final GeneratedMetamodel it) {
          return it.getEPackage();
        }
      };
      Iterable<EPackage> _map = IterableExtensions.<GeneratedMetamodel, EPackage>map(_filter_1, _function);
      final List<EPackage> generatedPackages = IterableExtensions.<EPackage>toList(_map);
      if ((this.genModel != null)) {
        URIConverter _uRIConverter = workingResourceSet.getURIConverter();
        this.registerUsedGenModel(_uRIConverter, clonedGrammar);
      }
      boolean _isEmpty_1 = generatedPackages.isEmpty();
      boolean _not = (!_isEmpty_1);
      if (_not) {
        final Map<String, EPackage> usedEPackages = this.findAllUsedEPackages(generatedPackages);
        Set<String> _keySet = usedEPackages.keySet();
        final Map<String, EPackage> loadedEPackages = this.findEPackagesInGenPackages(_keySet, workingResourceSet);
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
    XtextProjectConfig _projectConfig = this.getProjectConfig();
    RuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    PluginXmlAccess _pluginXml = _runtime.getPluginXml();
    boolean _tripleNotEquals = (_pluginXml != null);
    if (_tripleNotEquals) {
      XtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      RuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
      PluginXmlAccess _pluginXml_1 = _runtime_1.getPluginXml();
      List<CharSequence> _entries = _pluginXml_1.getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<extension point=\"org.eclipse.emf.ecore.generated_package\">");
      _builder.newLine();
      {
        for(final EPackage pack : generatedPackages) {
          _builder.append("\t");
          _builder.append("<package ");
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
          GenPackage _genPackage = GenModelUtil2.getGenPackage(pack, rs);
          String _qualifiedPackageInterfaceName = _genPackage.getQualifiedPackageInterfaceName();
          _builder.append(_qualifiedPackageInterfaceName, "\t\t");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("genModel = \"");
          String _genModelPath = this.getGenModelPath(grammar);
          String _relativePath = this.getRelativePath(_genModelPath);
          _builder.append(_relativePath, "\t\t");
          _builder.append("\" />");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("</extension>");
      _builder.newLine();
      _entries.add(_builder.toString());
    }
    XtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    RuntimeProjectConfig _runtime_2 = _projectConfig_2.getRuntime();
    ManifestAccess _manifest = _runtime_2.getManifest();
    boolean _tripleNotEquals_1 = (_manifest != null);
    if (_tripleNotEquals_1) {
      XtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      RuntimeProjectConfig _runtime_3 = _projectConfig_3.getRuntime();
      ManifestAccess _manifest_1 = _runtime_3.getManifest();
      Set<String> _requiredBundles = _manifest_1.getRequiredBundles();
      CollectionExtensions.<String>addAll(_requiredBundles, "org.eclipse.emf.ecore", "org.eclipse.emf.common");
    }
    for (final EPackage pack_1 : generatedPackages) {
      {
        final GenPackage genPackage = GenModelUtil2.getGenPackage(pack_1, rs);
        boolean _and = false;
        XtextProjectConfig _projectConfig_4 = this.getProjectConfig();
        RuntimeProjectConfig _runtime_4 = _projectConfig_4.getRuntime();
        ManifestAccess _manifest_2 = _runtime_4.getManifest();
        boolean _tripleNotEquals_2 = (_manifest_2 != null);
        if (!_tripleNotEquals_2) {
          _and = false;
        } else {
          boolean _equals = Objects.equal(this.modelPluginID, null);
          _and = _equals;
        }
        if (_and) {
          XtextProjectConfig _projectConfig_5 = this.getProjectConfig();
          RuntimeProjectConfig _runtime_5 = _projectConfig_5.getRuntime();
          ManifestAccess _manifest_3 = _runtime_5.getManifest();
          Set<String> _exportedPackages = _manifest_3.getExportedPackages();
          String _interfacePackageName = genPackage.getInterfacePackageName();
          String _classPackageName = genPackage.getClassPackageName();
          String _utilitiesPackageName = genPackage.getUtilitiesPackageName();
          CollectionExtensions.<String>addAll(_exportedPackages, _interfacePackageName, _classPackageName, _utilitiesPackageName);
        }
        ILanguageConfig _language = this.getLanguage();
        StandaloneSetupAccess _runtimeGenSetup = _language.getRuntimeGenSetup();
        List<StringConcatenationClient> _registrations = _runtimeGenSetup.getRegistrations();
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("if (!");
            _builder.append(EPackage.class, "");
            _builder.append(".Registry.INSTANCE.containsKey(\"");
            String _nsURI = pack_1.getNsURI();
            _builder.append(_nsURI, "");
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
        _registrations.add(_client);
      }
    }
  }
  
  /**
   * Create a clone of the original grammar. The clone will not refer to a node model.
   */
  private Grammar cloneGrammarIntoNewResourceSet(final Grammar original) {
    final Resource originalResource = original.eResource();
    XtextResourceSet _xtextResourceSet = new XtextResourceSet();
    ResourceSet _resourceSet = originalResource.getResourceSet();
    final XtextResourceSet clonedResourceSet = EcoreUtil2.<XtextResourceSet>clone(_xtextResourceSet, _resourceSet);
    URI _uRI = originalResource.getURI();
    final Resource clonedResource = clonedResourceSet.getResource(_uRI, false);
    EList<EObject> _contents = clonedResource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
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
        if (_t instanceof ConfigurationException) {
          final ConfigurationException ce = (ConfigurationException)_t;
          throw ce;
        } else if (_t instanceof Exception) {
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
                String _nsURI = referencedPackage.getNsURI();
                result.put(_nsURI, referencedPackage);
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
        boolean _notEquals = (!Objects.equal(resource, null));
        if (_notEquals) {
          EList<EObject> _contents = resource.getContents();
          Iterable<GenModel> _filter = Iterables.<GenModel>filter(_contents, GenModel.class);
          final GenModel loadedGenModel = IterableExtensions.<GenModel>head(_filter);
          if ((loadedGenModel != null)) {
            final GenPackage genPackage = this.findGenPackageByNsURI(loadedGenModel, nsURI);
            EPackage _ecorePackage = genPackage.getEcorePackage();
            result.put(nsURI, _ecorePackage);
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
        boolean _or = false;
        if ((ecorePackage == null)) {
          _or = true;
        } else {
          boolean _eIsProxy = ecorePackage.eIsProxy();
          _or = _eIsProxy;
        }
        if (_or) {
          Resource _eResource = genModel.eResource();
          URI _uRI = _eResource.getURI();
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
    Resource _eResource = genModel.eResource();
    URI _uRI = _eResource.getURI();
    String _plus = ((("No GenPackage for NsURI " + nsURI) + " found in ") + _uRI);
    throw new RuntimeException(_plus);
  }
  
  private Map<EObject, EObject> createENamedElementMapping(final Map<String, EPackage> usedEPackages, final Map<String, EPackage> loadedEPackages) {
    final HashMap<EObject, EObject> result = CollectionLiterals.<EObject, EObject>newHashMap();
    Set<Map.Entry<String, EPackage>> _entrySet = usedEPackages.entrySet();
    for (final Map.Entry<String, EPackage> entry : _entrySet) {
      EPackage _value = entry.getValue();
      String _key = entry.getKey();
      EPackage _get = loadedEPackages.get(_key);
      this.putMappingData(result, _value, _get);
    }
    return result;
  }
  
  private void putMappingData(final Map<EObject, EObject> result, final EPackage usedEPackage, final EPackage loadedEPackage) {
    boolean _and = false;
    if (!(loadedEPackage != null)) {
      _and = false;
    } else {
      boolean _notEquals = (!Objects.equal(usedEPackage, loadedEPackage));
      _and = _notEquals;
    }
    if (_and) {
      result.put(usedEPackage, loadedEPackage);
      EList<EClassifier> _eClassifiers = usedEPackage.getEClassifiers();
      for (final EClassifier usedClassifier : _eClassifiers) {
        {
          String _name = usedClassifier.getName();
          final EClassifier loadedClassifier = loadedEPackage.getEClassifier(_name);
          if ((loadedClassifier == null)) {
            String _name_1 = usedClassifier.getName();
            String _plus = ("Cannot find classifier \'" + _name_1);
            String _plus_1 = (_plus + "\' in loaded EPackage from ");
            Resource _eResource = loadedEPackage.eResource();
            URI _uRI = _eResource.getURI();
            String _plus_2 = (_plus_1 + _uRI);
            throw new RuntimeException(_plus_2);
          }
          result.put(usedClassifier, loadedClassifier);
        }
      }
      EList<EPackage> _eSubpackages = usedEPackage.getESubpackages();
      for (final EPackage usedNestedPackage : _eSubpackages) {
        {
          EList<EPackage> _eSubpackages_1 = loadedEPackage.getESubpackages();
          final Function1<EPackage, Boolean> _function = new Function1<EPackage, Boolean>() {
            @Override
            public Boolean apply(final EPackage it) {
              String _name = it.getName();
              String _name_1 = usedNestedPackage.getName();
              return Boolean.valueOf(Objects.equal(_name, _name_1));
            }
          };
          final EPackage loadedNestedPackage = IterableExtensions.<EPackage>findFirst(_eSubpackages_1, _function);
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
        EClass _eClass = current.eClass();
        EList<EStructuralFeature> _eAllStructuralFeatures = _eClass.getEAllStructuralFeatures();
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
                    EObject _get = eNamedElementMapping.get(value);
                    EcoreUtil.replace(current, reference, value, _get);
                  }
                }
              } else {
                Object _eGet_1 = current.eGet(reference);
                final EObject value_1 = ((EObject) _eGet_1);
                boolean _containsKey_1 = eNamedElementMapping.containsKey(value_1);
                if (_containsKey_1) {
                  EObject _get_1 = eNamedElementMapping.get(value_1);
                  EcoreUtil.replace(current, reference, value_1, _get_1);
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
      EList<Resource> _resources = rs.getResources();
      _resources.remove(existing);
    }
    final Resource ecoreFile = rs.createResource(ecoreFileUri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
    EList<EObject> _contents = ecoreFile.getContents();
    _contents.addAll(packs);
    return ecoreFile;
  }
  
  protected GenModel getSaveAndReconcileGenModel(final Grammar grammar, final List<EPackage> packs, final ResourceSet rs) {
    final GenModel genModel = this.getGenModel(rs, grammar);
    genModel.initialize(packs);
    EList<GenPackage> _genPackages = genModel.getGenPackages();
    for (final GenPackage genPackage : _genPackages) {
      {
        String _basePackage = this.getBasePackage(grammar);
        genPackage.setBasePackage(_basePackage);
        if (this.suppressLoadInitialization) {
          genPackage.setLoadInitialization(false);
        }
        boolean _and = false;
        if (!(this.fileExtensions != null)) {
          _and = false;
        } else {
          EPackage _ecorePackage = genPackage.getEcorePackage();
          boolean _contains = packs.contains(_ecorePackage);
          _and = _contains;
        }
        if (_and) {
          genPackage.setFileExtensions(this.fileExtensions);
        }
      }
    }
    final Set<EPackage> referencedEPackages = this.getReferencedEPackages(packs);
    final List<GenPackage> usedGenPackages = this.getGenPackagesForPackages(genModel, referencedEPackages);
    this.reconcileMissingGenPackagesInUsedModels(usedGenPackages);
    EList<GenPackage> _usedGenPackages = genModel.getUsedGenPackages();
    _usedGenPackages.addAll(usedGenPackages);
    Resource _eResource = genModel.eResource();
    this.saveResource(_eResource);
    GenModelHelper _genModelHelper = new GenModelHelper();
    _genModelHelper.registerGenModel(genModel);
    return genModel;
  }
  
  private void reconcileMissingGenPackagesInUsedModels(final List<GenPackage> usedGenPackages) {
    int _size = usedGenPackages.size();
    final HashSet<GenModel> processedModels = Sets.<GenModel>newHashSetWithExpectedSize(_size);
    for (final GenPackage usedGenPackage : usedGenPackages) {
      {
        final GenModel genModel = usedGenPackage.getGenModel();
        boolean _add = processedModels.add(genModel);
        if (_add) {
          final List<EPackage> missingPackages = genModel.getMissingPackages();
          final List<GenPackage> missingGenPackages = this.getGenPackagesForPackages(genModel, missingPackages);
          EList<GenPackage> _usedGenPackages = genModel.getUsedGenPackages();
          _usedGenPackages.addAll(missingGenPackages);
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
        EList<Resource> _resources = rs.getResources();
        _resources.remove(resource);
      }
      final Resource genModelFile = rs.createResource(genModelUri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
      GenModel genModel = null;
      URIConverter _uRIConverter = rs.getURIConverter();
      boolean _exists = _uRIConverter.exists(genModelUri, null);
      if (_exists) {
        genModelFile.load(null);
        boolean _hasFragment = genModelUri.hasFragment();
        if (_hasFragment) {
          String _fragment = genModelUri.fragment();
          EObject _eObject = genModelFile.getEObject(_fragment);
          genModel = ((GenModel) _eObject);
        } else {
          EList<EObject> _contents = genModelFile.getContents();
          EObject _head = IterableExtensions.<EObject>head(_contents);
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
        String _modelName = this.getModelName(grammar);
        genModel.setModelName(_modelName);
        String _javaModelDirectory = this.getJavaModelDirectory();
        String _genModelProjectPath = this.toGenModelProjectPath(_javaModelDirectory);
        genModel.setModelDirectory(_genModelProjectPath);
        String _modelPluginID = this.getModelPluginID();
        genModel.setModelPluginID(_modelPluginID);
        String _editDirectory = this.getEditDirectory();
        String _genModelProjectPath_1 = this.toGenModelProjectPath(_editDirectory);
        genModel.setEditDirectory(_genModelProjectPath_1);
        String _editPluginID = this.getEditPluginID();
        genModel.setEditPluginID(_editPluginID);
        String _editorDirectory = this.getEditorDirectory();
        String _genModelProjectPath_2 = this.toGenModelProjectPath(_editorDirectory);
        genModel.setEditorDirectory(_genModelProjectPath_2);
        String _editorPluginID = this.getEditorPluginID();
        genModel.setEditorPluginID(_editorPluginID);
        genModel.setValidateModel(false);
        genModel.setForceOverwrite(true);
        genModel.setCanGenerate(true);
        genModel.setFacadeHelperClass(null);
        genModel.setBundleManifest(true);
        genModel.setUpdateClasspath(false);
        genModel.setComplianceLevel(this.jdkLevel);
        genModel.setRuntimeVersion(this.emfRuntimeVersion);
        genModel.setRootExtendsClass("org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container");
        String _lineDelimiter = this.codeConfig.getLineDelimiter();
        genModel.setLineDelimiter(_lineDelimiter);
      }
      EList<EObject> _contents_1 = genModelFile.getContents();
      _contents_1.add(genModel);
      return genModel;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Required to match the path format as expected from {@link GenModelImpl#getProjectPath}.
   */
  protected String toGenModelProjectPath(final String path) {
    String _xifexpression = null;
    boolean _or = false;
    boolean _or_1 = false;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(path);
    if (_isNullOrEmpty) {
      _or_1 = true;
    } else {
      boolean _startsWith = path.startsWith("/");
      _or_1 = _startsWith;
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _contains = path.contains("/");
      boolean _not = (!_contains);
      _or = _not;
    }
    if (_or) {
      _xifexpression = path;
    } else {
      int _indexOf = path.indexOf("/");
      _xifexpression = path.substring(_indexOf);
    }
    return _xifexpression;
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
      EList<GenPackage> _genPackages = existingGenModel.getGenPackages();
      final Function1<GenPackage, Boolean> _function = new Function1<GenPackage, Boolean>() {
        @Override
        public Boolean apply(final GenPackage it) {
          EPackage _ecorePackage = it.getEcorePackage();
          String _nsURI = null;
          if (_ecorePackage!=null) {
            _nsURI=_ecorePackage.getNsURI();
          }
          String _nsURI_1 = pkg.getNsURI();
          return Boolean.valueOf(Objects.equal(_nsURI, _nsURI_1));
        }
      };
      boolean _exists = IterableExtensions.<GenPackage>exists(_genPackages, _function);
      boolean _not = (!_exists);
      if (_not) {
        Resource _eResource = existingGenModel.eResource();
        ResourceSet _resourceSet = _eResource.getResourceSet();
        GenPackage _genPackage = GenModelUtil2.getGenPackage(pkg, _resourceSet);
        result.add(_genPackage);
      }
    }
    final Comparator<GenPackage> _function_1 = new Comparator<GenPackage>() {
      @Override
      public int compare(final GenPackage o1, final GenPackage o2) {
        URI _uRI = EcoreUtil.getURI(o1);
        String _string = _uRI.toString();
        URI _uRI_1 = EcoreUtil.getURI(o2);
        String _string_1 = _uRI_1.toString();
        return _string.compareTo(_string_1);
      }
    };
    Collections.<GenPackage>sort(result, _function_1);
    return result;
  }
  
  private void saveResource(final Resource resource) {
    try {
      final HashMap<String, Object> saveOptions = CollectionLiterals.<String, Object>newHashMap();
      saveOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.AbsoluteCrossBundleAware() {
        @Override
        public URI deresolve(final URI uri) {
          boolean _isPlatform = uri.isPlatform();
          boolean _not = (!_isPlatform);
          if (_not) {
            Map<String, URI> _platformResourceMap = EcorePlugin.getPlatformResourceMap();
            Set<Map.Entry<String, URI>> _entrySet = _platformResourceMap.entrySet();
            for (final Map.Entry<String, URI> entry : _entrySet) {
              {
                String _key = entry.getKey();
                String _plus = ("platform:/resource/" + _key);
                String _plus_1 = (_plus + "/");
                final URI newPrefix = URI.createURI(_plus_1);
                URI _value = entry.getValue();
                final URI uri2 = uri.replacePrefix(_value, newPrefix);
                if ((uri2 != null)) {
                  return super.deresolve(uri2);
                }
              }
            }
          }
          return super.deresolve(uri);
        }
      });
      String _lineDelimiter = this.codeConfig.getLineDelimiter();
      saveOptions.put(Resource.OPTION_LINE_DELIMITER, _lineDelimiter);
      resource.save(saveOptions);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void doGenerate(final GenModel genModel) {
    final Generator generator = new Generator() {
      @Override
      public JControlModel getJControlModel() {
        boolean _equals = Objects.equal(this.jControlModel, null);
        if (_equals) {
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
      if (((!this.updateBuildProperties) || (this.modelPluginID != null))) {
        return;
      }
      XtextProjectConfig _projectConfig = this.getProjectConfig();
      RuntimeProjectConfig _runtime = _projectConfig.getRuntime();
      final IXtextGeneratorFileSystemAccess rootOutlet = _runtime.getRoot();
      String _path = rootOutlet.getPath();
      final String buildPropertiesPath = (_path + "/build.properties");
      XtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      RuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
      final String modelContainer = _runtime_1.getEcoreModelFolder();
      final Properties buildProperties = new Properties();
      File _file = new File(buildPropertiesPath);
      FileInputStream _fileInputStream = new FileInputStream(_file);
      String _encoding = this.codeConfig.getEncoding();
      Charset _forName = Charset.forName(_encoding);
      final InputStreamReader reader = new InputStreamReader(_fileInputStream, _forName);
      try {
        String existingContent = CharStreams.toString(reader);
        StringInputStream _stringInputStream = new StringInputStream(existingContent, "ISO-8859-1");
        buildProperties.load(_stringInputStream);
        final String binIncludes = buildProperties.getProperty("bin.includes");
        boolean changed = false;
        if ((binIncludes == null)) {
          String _existingContent = existingContent;
          String _newLine = Strings.newLine();
          String _plus = (("bin.includes = " + modelContainer) + _newLine);
          String _plus_1 = (_plus + "               ");
          existingContent = (_existingContent + _plus_1);
          changed = true;
        } else {
          boolean _contains = binIncludes.contains(modelContainer);
          boolean _not = (!_contains);
          if (_not) {
            String _newLine_1 = Strings.newLine();
            String _plus_2 = ((("bin.includes = " + modelContainer) + ",\\") + _newLine_1);
            String _plus_3 = (_plus_2 + "               ");
            String _replace = existingContent.replace("bin.includes = ", _plus_3);
            existingContent = _replace;
            changed = true;
          }
        }
        if (changed) {
          File _file_1 = new File(buildPropertiesPath);
          FileOutputStream _fileOutputStream = new FileOutputStream(_file_1);
          String _encoding_1 = this.codeConfig.getEncoding();
          Charset _forName_1 = Charset.forName(_encoding_1);
          final OutputStreamWriter writer = new OutputStreamWriter(_fileOutputStream, _forName_1);
          writer.write(existingContent);
          writer.close();
        }
      } finally {
        reader.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private final static Logger LOG = Logger.getLogger(EMFGeneratorFragment2.class);
  
  public void setBasePackage(final String basePackage) {
    this.basePackage = basePackage;
  }
  
  public void setGenerateEdit(final boolean generateEdit) {
    this.generateEdit = generateEdit;
  }
  
  public void setEditDirectory(final String editDirectory) {
    this.editDirectory = editDirectory;
  }
  
  public void setEditPluginID(final String editPluginID) {
    this.editPluginID = editPluginID;
  }
  
  public void setGenerateEditor(final boolean generateEditor) {
    this.generateEditor = generateEditor;
  }
  
  public void setEditorDirectory(final String editorDirectory) {
    this.editorDirectory = editorDirectory;
  }
  
  public void setEditorPluginID(final String editorPluginID) {
    this.editorPluginID = editorPluginID;
  }
  
  public void setGenModel(final String genModel) {
    this.genModel = genModel;
  }
  
  public void setJavaModelDirectory(final String javaModelDirectory) {
    this.javaModelDirectory = javaModelDirectory;
  }
  
  public void setModelPluginID(final String modelPluginID) {
    this.modelPluginID = modelPluginID;
  }
  
  public void setSkipGenerate(final boolean skipGenerate) {
    this.skipGenerate = skipGenerate;
  }
  
  public void setUpdateBuildProperties(final boolean updateBuildProperties) {
    this.updateBuildProperties = updateBuildProperties;
  }
  
  public void setFileExtensions(final String fileExtensions) {
    this.fileExtensions = fileExtensions;
  }
  
  public void setLongFileNames(final boolean longFileNames) {
    this.longFileNames = longFileNames;
  }
  
  public void setSuppressLoadInitialization(final boolean suppressLoadInitialization) {
    this.suppressLoadInitialization = suppressLoadInitialization;
  }
}
