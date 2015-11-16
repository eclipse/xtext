/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.generator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

@SuppressWarnings("all")
public class GeneratorFragment2 extends AbstractStubGeneratingFragment {
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean generateMwe = false;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean generateJavaMain = false;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean generateXtendMain = false;
  
  @Override
  public boolean isGenerateStub() {
    boolean _and = false;
    Grammar _grammar = this.getGrammar();
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(_grammar);
    boolean _not = (!_inheritsXbase);
    if (!_not) {
      _and = false;
    } else {
      boolean _isGenerateStub = super.isGenerateStub();
      _and = _isGenerateStub;
    }
    return _and;
  }
  
  public boolean isGenerateJavaMain() {
    boolean _and = false;
    Grammar _grammar = this.getGrammar();
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(_grammar);
    boolean _not = (!_inheritsXbase);
    if (!_not) {
      _and = false;
    } else {
      _and = this.generateJavaMain;
    }
    return _and;
  }
  
  public boolean isGenerateXtendMain() {
    boolean _and = false;
    Grammar _grammar = this.getGrammar();
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(_grammar);
    boolean _not = (!_inheritsXbase);
    if (!_not) {
      _and = false;
    } else {
      _and = this.generateXtendMain;
    }
    return _and;
  }
  
  public boolean isGenerateMwe() {
    boolean _and = false;
    Grammar _grammar = this.getGrammar();
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(_grammar);
    boolean _not = (!_inheritsXbase);
    if (!_not) {
      _and = false;
    } else {
      _and = this.generateMwe;
    }
    return _and;
  }
  
  protected TypeReference getGeneratorStub(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".generator.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "Generator");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getJavaMain(final Grammar grammar) {
    TypeReference _generatorStub = this.getGeneratorStub(grammar);
    String _packageName = _generatorStub.getPackageName();
    String _plus = (_packageName + ".Main");
    return new TypeReference(_plus);
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    boolean _and = false;
    if (!this.generateJavaMain) {
      _and = false;
    } else {
      _and = this.generateXtendMain;
    }
    if (_and) {
      issues.addWarning(
        "Options \'generateJavaMain\' and \'generateXtendMain\' are mutually exclusive. Generating Xtend only.", this);
      this.generateJavaMain = false;
    }
  }
  
  @Override
  public void generate() {
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
      TypeReference _typeRef = TypeReference.typeRef(IGenerator2.class);
      IXtextGeneratorLanguage _language = this.getLanguage();
      Grammar _grammar = _language.getGrammar();
      TypeReference _generatorStub = this.getGeneratorStub(_grammar);
      GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _generatorStub);
      IXtextGeneratorLanguage _language_1 = this.getLanguage();
      GuiceModuleAccess _runtimeGenModule = _language_1.getRuntimeGenModule();
      _addTypeToType.contributeTo(_runtimeGenModule);
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
      ManifestAccess _manifest = _runtime.getManifest();
      boolean _tripleNotEquals = (_manifest != null);
      if (_tripleNotEquals) {
        IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
        ManifestAccess _manifest_1 = _runtime_1.getManifest();
        Set<String> _requiredBundles = _manifest_1.getRequiredBundles();
        _requiredBundles.add("org.eclipse.xtext.xbase.lib");
      }
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        this.doGenerateXtendStubFile();
      } else {
        this.doGenerateJavaStubFile();
      }
    }
    boolean _or = false;
    boolean _isGenerateStub_1 = this.isGenerateStub();
    if (_isGenerateStub_1) {
      _or = true;
    } else {
      boolean _isGenerateJavaMain = this.isGenerateJavaMain();
      _or = _isGenerateJavaMain;
    }
    if (_or) {
      IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_2 = _projectConfig_2.getRuntime();
      ManifestAccess _manifest_2 = _runtime_2.getManifest();
      boolean _tripleNotEquals_1 = (_manifest_2 != null);
      if (_tripleNotEquals_1) {
        IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_3 = _projectConfig_3.getRuntime();
        ManifestAccess _manifest_3 = _runtime_3.getManifest();
        Set<String> _exportedPackages = _manifest_3.getExportedPackages();
        IXtextGeneratorLanguage _language_2 = this.getLanguage();
        Grammar _grammar_1 = _language_2.getGrammar();
        TypeReference _generatorStub_1 = this.getGeneratorStub(_grammar_1);
        String _packageName = _generatorStub_1.getPackageName();
        _exportedPackages.add(_packageName);
      }
    }
    boolean _isGenerateJavaMain_1 = this.isGenerateJavaMain();
    if (_isGenerateJavaMain_1) {
      this.doGenerateJavaMain();
    }
    boolean _isGenerateXtendMain = this.isGenerateXtendMain();
    if (_isGenerateXtendMain) {
      this.doGenerateXtendMain();
    }
    boolean _isGenerateMwe = this.isGenerateMwe();
    if (_isGenerateMwe) {
      this.doGenerateMweFile();
    }
    this.contributeEclipsePluginGuiceBindings();
    IXtextProjectConfig _projectConfig_4 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig_4.getEclipsePlugin();
    ManifestAccess _manifest_4 = _eclipsePlugin.getManifest();
    boolean _tripleNotEquals_2 = (_manifest_4 != null);
    if (_tripleNotEquals_2) {
      IXtextProjectConfig _projectConfig_5 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_5.getEclipsePlugin();
      ManifestAccess _manifest_5 = _eclipsePlugin_1.getManifest();
      Set<String> _requiredBundles_1 = _manifest_5.getRequiredBundles();
      _requiredBundles_1.add("org.eclipse.xtext.builder");
    }
    IXtextProjectConfig _projectConfig_6 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin_2 = _projectConfig_6.getEclipsePlugin();
    PluginXmlAccess _pluginXml = _eclipsePlugin_2.getPluginXml();
    boolean _tripleNotEquals_3 = (_pluginXml != null);
    if (_tripleNotEquals_3) {
      this.contributeEclipsePluginExtensions();
    }
  }
  
  protected void contributeEclipsePluginGuiceBindings() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.core.resources.ResourcesPlugin");
        _builder.append(_typeRef, "");
        _builder.append(".getWorkspace().getRoot()");
      }
    };
    final StringConcatenationClient expression = _client;
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer");
        _builder.append(_typeRef, "");
        _builder.append(".class)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".annotatedWith(");
        _builder.append(Names.class, "\t");
        _builder.append(".named(\"builderPreferenceInitializer\"))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".to(");
        TypeReference _typeReference = new TypeReference("org.eclipse.xtext.builder.preferences", "BuilderPreferenceAccess.Initializer");
        _builder.append(_typeReference, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    };
    final StringConcatenationClient statement = _client_1;
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.builder.IXtextBuilderParticipant");
    TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.builder.BuilderParticipant");
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _typeRef_1);
    TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.core.resources.IWorkspaceRoot");
    GuiceModuleAccess.BindingFactory _addTypeToInstance = _addTypeToType.addTypeToInstance(_typeRef_2, expression);
    GuiceModuleAccess.BindingFactory _addConfiguredBinding = _addTypeToInstance.addConfiguredBinding("BuilderPreferenceStoreInitializer", statement);
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language.getEclipsePluginGenModule();
    _addConfiguredBinding.contributeTo(_eclipsePluginGenModule);
  }
  
  protected void doGenerateXtendStubFile() {
    Grammar _grammar = this.getGrammar();
    TypeReference _generatorStub = this.getGeneratorStub(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Generates code from your model files on save.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        IXtextGeneratorLanguage _language = GeneratorFragment2.this.getLanguage();
        Grammar _grammar = _language.getGrammar();
        TypeReference _generatorStub = GeneratorFragment2.this.getGeneratorStub(_grammar);
        String _simpleName = _generatorStub.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(AbstractGenerator.class, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("override void doGenerate(");
        _builder.append(Resource.class, "\t");
        _builder.append(" resource, ");
        _builder.append(IFileSystemAccess2.class, "\t");
        _builder.append(" fsa, ");
        _builder.append(IGeneratorContext.class, "\t");
        _builder.append(" context) {");
        _builder.newLineIfNotEmpty();
        _builder.append("//\t\tfsa.generateFile(\'greetings.txt\', \'People to greet: \' + ");
        _builder.newLine();
        _builder.append("//\t\t\tresource.allContents");
        _builder.newLine();
        _builder.append("//\t\t\t\t.filter(typeof(Greeting))");
        _builder.newLine();
        _builder.append("//\t\t\t\t.map[name]");
        _builder.newLine();
        _builder.append("//\t\t\t\t.join(\', \'))");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_generatorStub, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
    _createXtendFile.writeTo(_src);
  }
  
  protected void doGenerateJavaStubFile() {
    Grammar _grammar = this.getGrammar();
    TypeReference _generatorStub = this.getGeneratorStub(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Generates code from your model files on save.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        IXtextGeneratorLanguage _language = GeneratorFragment2.this.getLanguage();
        Grammar _grammar = _language.getGrammar();
        TypeReference _generatorStub = GeneratorFragment2.this.getGeneratorStub(_grammar);
        String _simpleName = _generatorStub.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(AbstractGenerator.class, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Override.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public void doGenerate(");
        _builder.append(Resource.class, "\t");
        _builder.append(" resource, ");
        _builder.append(IFileSystemAccess2.class, "\t");
        _builder.append(" fsa, ");
        _builder.append(IGeneratorContext.class, "\t");
        _builder.append(" context) {");
        _builder.newLineIfNotEmpty();
        _builder.append("//\t\tIterator<Greeting> filtered = Iterators.filter(resource.getAllContents(), Greeting.class);");
        _builder.newLine();
        _builder.append("//\t\tIterator<String> names = Iterators.transform(filtered, new Function<Greeting, String>() {");
        _builder.newLine();
        _builder.append("//");
        _builder.newLine();
        _builder.append("//\t\t\t@");
        _builder.append(Override.class, "");
        _builder.newLineIfNotEmpty();
        _builder.append("//\t\t\tpublic String apply(Greeting greeting) {");
        _builder.newLine();
        _builder.append("//\t\t\t\treturn greeting.getName();");
        _builder.newLine();
        _builder.append("//\t\t\t}");
        _builder.newLine();
        _builder.append("//\t\t});");
        _builder.newLine();
        _builder.append("//\t\tfsa.generateFile(\"greetings.txt\", \"People to greet: \" + IteratorExtensions.join(names, \", \"));");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_generatorStub, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
    _createJavaFile.writeTo(_src);
  }
  
  protected void doGenerateJavaMain() {
    Grammar _grammar = this.getGrammar();
    TypeReference _javaMain = this.getJavaMain(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class Main {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void main(String[] args) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (args.length == 0) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("System.err.println(\"Aborting: no path to EMF resource provided!\");");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(Injector.class, "\t\t");
        _builder.append(" injector = new ");
        Grammar _grammar = GeneratorFragment2.this.getGrammar();
        TypeReference _runtimeSetup = GeneratorFragment2.this._xtextGeneratorNaming.getRuntimeSetup(_grammar);
        _builder.append(_runtimeSetup, "\t\t");
        _builder.append("().createInjectorAndDoEMFRegistration();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("Main main = injector.getInstance(Main.class);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("main.runGenerator(args[0]);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ");
        _builder.append(Provider.class, "\t");
        _builder.append("<");
        _builder.append(ResourceSet.class, "\t");
        _builder.append("> resourceSetProvider;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ");
        _builder.append(IResourceValidator.class, "\t");
        _builder.append(" validator;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ");
        _builder.append(GeneratorDelegate.class, "\t");
        _builder.append(" generator;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ");
        _builder.append(JavaIoFileSystemAccess.class, "\t");
        _builder.append(" fileAccess;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void runGenerator(String string) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// Load the resource");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(ResourceSet.class, "\t\t");
        _builder.append(" set = resourceSetProvider.get();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append(Resource.class, "\t\t");
        _builder.append(" resource = set.getResource(");
        _builder.append(URI.class, "\t\t");
        _builder.append(".createURI(string), true);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// Validate the resource");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(List.class, "\t\t");
        _builder.append("<");
        _builder.append(Issue.class, "\t\t");
        _builder.append("> list = validator.validate(resource, ");
        _builder.append(CheckMode.class, "\t\t");
        _builder.append(".ALL, ");
        _builder.append(CancelIndicator.class, "\t\t");
        _builder.append(".NullImpl);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("if (!list.isEmpty()) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("for (");
        _builder.append(Issue.class, "\t\t\t");
        _builder.append(" issue : list) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("System.err.println(issue);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// Configure and start the generator");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("fileAccess.setOutputPath(\"src-gen/\");");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(GeneratorContext.class, "\t\t");
        _builder.append(" context = new ");
        _builder.append(GeneratorContext.class, "\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("context.setCancelIndicator(");
        _builder.append(CancelIndicator.class, "\t\t");
        _builder.append(".NullImpl);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("generator.generate(resource, fileAccess, context);");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("System.out.println(\"Code generation finished.\");");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_javaMain, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
    _createJavaFile.writeTo(_src);
  }
  
  protected void doGenerateXtendMain() {
    Grammar _grammar = this.getGrammar();
    TypeReference _javaMain = this.getJavaMain(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("class Main {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def static main(String[] args) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (args.empty) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("System::err.println(\'Aborting: no path to EMF resource provided!\')");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("val injector = new ");
        Grammar _grammar = GeneratorFragment2.this.getGrammar();
        TypeReference _runtimeSetup = GeneratorFragment2.this._xtextGeneratorNaming.getRuntimeSetup(_grammar);
        _builder.append(_runtimeSetup, "\t\t");
        _builder.append("().createInjectorAndDoEMFRegistration");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("val main = injector.getInstance(Main)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("main.runGenerator(args.get(0))");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.append(" ");
        _builder.append(Provider.class, "\t");
        _builder.append("<");
        _builder.append(ResourceSet.class, "\t");
        _builder.append("> resourceSetProvider");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.append(" ");
        _builder.append(IResourceValidator.class, "\t");
        _builder.append(" validator");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.append(" ");
        _builder.append(GeneratorDelegate.class, "\t");
        _builder.append(" generator");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.append(" ");
        _builder.append(JavaIoFileSystemAccess.class, "\t");
        _builder.append(" fileAccess");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def protected runGenerator(String string) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// Load the resource");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("val set = resourceSetProvider.get");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("val resource = set.getResource(");
        _builder.append(URI.class, "\t\t");
        _builder.append(".createURI(string), true)");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// Validate the resource");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("val issues = validator.validate(resource, ");
        _builder.append(CheckMode.class, "\t\t");
        _builder.append(".ALL, ");
        _builder.append(CancelIndicator.class, "\t\t");
        _builder.append(".NullImpl)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("if (!issues.empty) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("issues.forEach[System.err.println(it)]");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// Configure and start the generator");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("fileAccess.outputPath = \'src-gen/\'");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("val context = new ");
        _builder.append(GeneratorContext.class, "\t\t");
        _builder.append(" => [");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("cancelIndicator = ");
        _builder.append(CancelIndicator.class, "\t\t\t");
        _builder.append(".NullImpl");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("]");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("generator.generate(resource, fileAccess, context)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("System.out.println(\'Code generation finished.\')");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_javaMain, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
    _createXtendFile.writeTo(_src);
  }
  
  protected void doGenerateMweFile() {
    IXtextGeneratorLanguage _language = this.getLanguage();
    Grammar _grammar = _language.getGrammar();
    TypeReference _generatorStub = this.getGeneratorStub(_grammar);
    String _path = _generatorStub.getPath();
    String _plus = (_path + "MWE.mwe2");
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        String _fileHeader = GeneratorFragment2.this.codeConfig.getFileHeader();
        _builder.append(_fileHeader, "");
        _builder.newLineIfNotEmpty();
        _builder.append("module ");
        IXtextGeneratorLanguage _language = GeneratorFragment2.this.getLanguage();
        Grammar _grammar = _language.getGrammar();
        TypeReference _generatorStub = GeneratorFragment2.this.getGeneratorStub(_grammar);
        String _name = _generatorStub.getName();
        _builder.append(_name, "");
        _builder.append("MWE");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("import org.eclipse.emf.mwe.utils.*");
        _builder.newLine();
        _builder.append("import ");
        Grammar _grammar_1 = GeneratorFragment2.this.getGrammar();
        TypeReference _runtimeSetup = GeneratorFragment2.this._xtextGeneratorNaming.getRuntimeSetup(_grammar_1);
        String _packageName = _runtimeSetup.getPackageName();
        _builder.append(_packageName, "");
        _builder.append(".*");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("var targetDir");
        _builder.newLine();
        _builder.append("var modelPath");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Workflow {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("component = org.eclipse.xtext.mwe.Reader {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// lookup all resources on the classpath");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// useJavaClassPath = true");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// or define search scope explicitly");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("path = modelPath");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// this class will be generated by the xtext generator ");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("register = ");
        Grammar _grammar_2 = GeneratorFragment2.this.getGrammar();
        TypeReference _runtimeSetup_1 = GeneratorFragment2.this._xtextGeneratorNaming.getRuntimeSetup(_grammar_2);
        String _simpleName = _runtimeSetup_1.getSimpleName();
        _builder.append(_simpleName, "\t\t");
        _builder.append(" {}");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("loadResource = {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("slot = \"model\"");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("component = org.eclipse.xtext.generator.GeneratorComponent {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("register = ");
        Grammar _grammar_3 = GeneratorFragment2.this.getGrammar();
        TypeReference _runtimeSetup_2 = GeneratorFragment2.this._xtextGeneratorNaming.getRuntimeSetup(_grammar_3);
        String _simpleName_1 = _runtimeSetup_2.getSimpleName();
        _builder.append(_simpleName_1, "\t\t");
        _builder.append(" {}");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("slot = \'model\'");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("outlet = {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("path = targetDir");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    TextFileAccess _createTextFile = this.fileAccessFactory.createTextFile(_plus, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
    _createTextFile.writeTo(_src);
  }
  
  protected boolean contributeEclipsePluginExtensions() {
    boolean _xblockexpression = false;
    {
      IXtextGeneratorLanguage _language = this.getLanguage();
      Grammar _grammar = _language.getGrammar();
      final String name = _grammar.getName();
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
      PluginXmlAccess _pluginXml = _eclipsePlugin.getPluginXml();
      List<CharSequence> _entries = _pluginXml.getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<extension point=\"org.eclipse.xtext.builder.participant\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<participant");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      Grammar _grammar_1 = this.getGrammar();
      TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar_1);
      _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.xtext.builder.IXtextBuilderParticipant\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("fileExtensions=\"");
      IXtextGeneratorLanguage _language_1 = this.getLanguage();
      List<String> _fileExtensions = _language_1.getFileExtensions();
      String _join = IterableExtensions.join(_fileExtensions, ",");
      _builder.append(_join, "\t\t");
      _builder.append("\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.preferencePages\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<page");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("category=\"");
      _builder.append(name, "\t\t");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("class=\"");
      Grammar _grammar_2 = this.getGrammar();
      TypeReference _eclipsePluginExecutableExtensionFactory_1 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar_2);
      _builder.append(_eclipsePluginExecutableExtensionFactory_1, "\t\t");
      _builder.append(":org.eclipse.xtext.builder.preferences.BuilderPreferencePage\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("id=\"");
      _builder.append(name, "\t\t");
      _builder.append(".compiler.preferencePage\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("name=\"Compiler\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<keywordReference id=\"");
      IXtextGeneratorLanguage _language_2 = this.getLanguage();
      Grammar _grammar_3 = _language_2.getGrammar();
      String _namespace = GrammarUtil.getNamespace(_grammar_3);
      String _plus = (_namespace + ".ui.keyword_");
      IXtextGeneratorLanguage _language_3 = this.getLanguage();
      Grammar _grammar_4 = _language_3.getGrammar();
      String _simpleName = GrammarUtil.getSimpleName(_grammar_4);
      String _plus_1 = (_plus + _simpleName);
      _builder.append(_plus_1, "\t\t");
      _builder.append("\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</page>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.propertyPages\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<page");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("category=\"");
      _builder.append(name, "\t\t");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("class=\"");
      Grammar _grammar_5 = this.getGrammar();
      TypeReference _eclipsePluginExecutableExtensionFactory_2 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar_5);
      _builder.append(_eclipsePluginExecutableExtensionFactory_2, "\t\t");
      _builder.append(":org.eclipse.xtext.builder.preferences.BuilderPreferencePage\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("id=\"");
      _builder.append(name, "\t\t");
      _builder.append(".compiler.propertyPage\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("name=\"Compiler\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<keywordReference id=\"");
      IXtextGeneratorLanguage _language_4 = this.getLanguage();
      Grammar _grammar_6 = _language_4.getGrammar();
      String _namespace_1 = GrammarUtil.getNamespace(_grammar_6);
      String _plus_2 = (_namespace_1 + ".ui.keyword_");
      IXtextGeneratorLanguage _language_5 = this.getLanguage();
      Grammar _grammar_7 = _language_5.getGrammar();
      String _simpleName_1 = GrammarUtil.getSimpleName(_grammar_7);
      String _plus_3 = (_plus_2 + _simpleName_1);
      _builder.append(_plus_3, "\t\t");
      _builder.append("\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("<enabledWhen>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<adapt type=\"org.eclipse.core.resources.IProject\"/>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</enabledWhen>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<filter name=\"projectNature\" value=\"org.eclipse.xtext.ui.shared.xtextNature\"/>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</page>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.menus\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<menuContribution locationURI=\"popup:#TextEditorContext?after=xtext.ui.openDeclaration\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<command");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("commandId=\"org.eclipse.xtext.ui.OpenGeneratedFileCommand\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("id=\"");
      _builder.append(name, "\t\t\t");
      _builder.append(".OpenGeneratedCode\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("style=\"push\">");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<visibleWhen checkEnabled=\"false\">");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<reference definitionId=\"");
      _builder.append(name, "\t\t\t\t");
      _builder.append(".Editor.opened\" />");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("</visibleWhen>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</command>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</menuContribution>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.handlers\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<handler");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      Grammar _grammar_8 = this.getGrammar();
      TypeReference _eclipsePluginExecutableExtensionFactory_3 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar_8);
      _builder.append(_eclipsePluginExecutableExtensionFactory_3, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.generator.trace.OpenGeneratedFileHandler\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("commandId=\"org.eclipse.xtext.ui.OpenGeneratedFileCommand\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<activeWhen>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<reference definitionId=\"");
      _builder.append(name, "\t\t\t");
      _builder.append(".Editor.opened\" />");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("</activeWhen>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</handler>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _xblockexpression = _entries.add(_builder.toString());
    }
    return _xblockexpression;
  }
  
  public void setGenerateMwe(final boolean generateMwe) {
    this.generateMwe = generateMwe;
  }
  
  public void setGenerateJavaMain(final boolean generateJavaMain) {
    this.generateJavaMain = generateJavaMain;
  }
  
  public void setGenerateXtendMain(final boolean generateXtendMain) {
    this.generateXtendMain = generateXtendMain;
  }
}
