/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
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
    return ((!this._xbaseUsageDetector.inheritsXbase(this.getGrammar())) && super.isGenerateStub());
  }

  public boolean isGenerateJavaMain() {
    return ((!this._xbaseUsageDetector.inheritsXbase(this.getGrammar())) && this.generateJavaMain);
  }

  public boolean isGenerateXtendMain() {
    return ((!this._xbaseUsageDetector.inheritsXbase(this.getGrammar())) && this.generateXtendMain);
  }

  public boolean isGenerateMwe() {
    return ((!this._xbaseUsageDetector.inheritsXbase(this.getGrammar())) && this.generateMwe);
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
    String _packageName = this.getGeneratorStub(grammar).getPackageName();
    String _plus = (_packageName + ".Main");
    return new TypeReference(_plus);
  }

  @Override
  public void checkConfiguration(final Issues issues) {
    if ((this.generateJavaMain && this.generateXtendMain)) {
      issues.addWarning(
        "Options \'generateJavaMain\' and \'generateXtendMain\' are mutually exclusive. Generating Xtend only.", this);
      this.generateJavaMain = false;
    }
  }

  @Override
  public void generate() {
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      new GuiceModuleAccess.BindingFactory().addTypeToType(TypeReference.typeRef(IGenerator2.class), this.getGeneratorStub(this.getLanguage().getGrammar())).contributeTo(this.getLanguage().getRuntimeGenModule());
      ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
      boolean _tripleNotEquals = (_manifest != null);
      if (_tripleNotEquals) {
        Set<String> _requiredBundles = this.getProjectConfig().getRuntime().getManifest().getRequiredBundles();
        String _xbaseLibVersionLowerBound = this.getProjectConfig().getRuntime().getXbaseLibVersionLowerBound();
        String _plus = ("org.eclipse.xtext.xbase.lib;bundle-version=\"" + _xbaseLibVersionLowerBound);
        String _plus_1 = (_plus + "\"");
        _requiredBundles.add(_plus_1);
      }
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        this.doGenerateXtendStubFile();
      } else {
        this.doGenerateJavaStubFile();
      }
    }
    if ((this.isGenerateStub() || this.isGenerateJavaMain())) {
      ManifestAccess _manifest_1 = this.getProjectConfig().getRuntime().getManifest();
      boolean _tripleNotEquals_1 = (_manifest_1 != null);
      if (_tripleNotEquals_1) {
        Set<String> _exportedPackages = this.getProjectConfig().getRuntime().getManifest().getExportedPackages();
        String _packageName = this.getGeneratorStub(this.getLanguage().getGrammar()).getPackageName();
        _exportedPackages.add(_packageName);
      }
    }
    boolean _isGenerateJavaMain = this.isGenerateJavaMain();
    if (_isGenerateJavaMain) {
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
    ManifestAccess _manifest_2 = this.getProjectConfig().getEclipsePlugin().getManifest();
    boolean _tripleNotEquals_2 = (_manifest_2 != null);
    if (_tripleNotEquals_2) {
      Set<String> _requiredBundles_1 = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
      _requiredBundles_1.add("org.eclipse.xtext.builder");
    }
    PluginXmlAccess _pluginXml = this.getProjectConfig().getEclipsePlugin().getPluginXml();
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
        _builder.append(_typeRef);
        _builder.append(".getWorkspace().getRoot()");
      }
    };
    final StringConcatenationClient expression = _client;
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer");
        _builder.append(_typeRef);
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
    new GuiceModuleAccess.BindingFactory().addTypeToType(TypeReference.typeRef("org.eclipse.xtext.builder.IXtextBuilderParticipant"), 
      TypeReference.typeRef("org.eclipse.xtext.builder.BuilderParticipant")).addTypeToInstance(TypeReference.typeRef("org.eclipse.core.resources.IWorkspaceRoot"), expression).addConfiguredBinding("BuilderPreferenceStoreInitializer", statement).contributeTo(this.getLanguage().getEclipsePluginGenModule());
  }

  protected void doGenerateXtendStubFile() {
    TypeReference _generatorStub = this.getGeneratorStub(this.getGrammar());
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
        String _simpleName = GeneratorFragment2.this.getGeneratorStub(GeneratorFragment2.this.getLanguage().getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        _builder.append(AbstractGenerator.class);
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
        _builder.append("//\t\t\t\t.filter(Greeting)");
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
    this.fileAccessFactory.createXtendFile(_generatorStub, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
  }

  protected void doGenerateJavaStubFile() {
    TypeReference _generatorStub = this.getGeneratorStub(this.getGrammar());
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
        String _simpleName = GeneratorFragment2.this.getGeneratorStub(GeneratorFragment2.this.getLanguage().getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        _builder.append(AbstractGenerator.class);
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
        _builder.append(Override.class);
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
    this.fileAccessFactory.createJavaFile(_generatorStub, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
  }

  protected void doGenerateJavaMain() {
    TypeReference _javaMain = this.getJavaMain(this.getGrammar());
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
        TypeReference _runtimeSetup = GeneratorFragment2.this._xtextGeneratorNaming.getRuntimeSetup(GeneratorFragment2.this.getGrammar());
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
        _builder.append(".createFileURI(string), true);");
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
    this.fileAccessFactory.createJavaFile(_javaMain, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
  }

  protected void doGenerateXtendMain() {
    TypeReference _javaMain = this.getJavaMain(this.getGrammar());
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
        TypeReference _runtimeSetup = GeneratorFragment2.this._xtextGeneratorNaming.getRuntimeSetup(GeneratorFragment2.this.getGrammar());
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
        _builder.append(".createFileURI(string), true)");
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
    this.fileAccessFactory.createXtendFile(_javaMain, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
  }

  protected void doGenerateMweFile() {
    String _path = this.getGeneratorStub(this.getLanguage().getGrammar()).getPath();
    String _plus = (_path + "MWE.mwe2");
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        String _fileHeader = GeneratorFragment2.this.codeConfig.getFileHeader();
        _builder.append(_fileHeader);
        _builder.newLineIfNotEmpty();
        _builder.append("module ");
        String _name = GeneratorFragment2.this.getGeneratorStub(GeneratorFragment2.this.getLanguage().getGrammar()).getName();
        _builder.append(_name);
        _builder.append("MWE");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("import org.eclipse.emf.mwe.utils.*");
        _builder.newLine();
        _builder.append("import ");
        String _packageName = GeneratorFragment2.this._xtextGeneratorNaming.getRuntimeSetup(GeneratorFragment2.this.getGrammar()).getPackageName();
        _builder.append(_packageName);
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
        String _simpleName = GeneratorFragment2.this._xtextGeneratorNaming.getRuntimeSetup(GeneratorFragment2.this.getGrammar()).getSimpleName();
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
        String _simpleName_1 = GeneratorFragment2.this._xtextGeneratorNaming.getRuntimeSetup(GeneratorFragment2.this.getGrammar()).getSimpleName();
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
    this.fileAccessFactory.createTextFile(_plus, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
  }

  protected boolean contributeEclipsePluginExtensions() {
    boolean _xblockexpression = false;
    {
      final String name = this.getLanguage().getGrammar().getName();
      List<CharSequence> _entries = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<extension point=\"org.eclipse.xtext.builder.participant\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<participant");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
      _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.xtext.builder.IXtextBuilderParticipant\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("fileExtensions=\"");
      String _join = IterableExtensions.join(this.getLanguage().getFileExtensions(), ",");
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
      TypeReference _eclipsePluginExecutableExtensionFactory_1 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
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
      String _namespace = GrammarUtil.getNamespace(this.getLanguage().getGrammar());
      String _plus = (_namespace + ".ui.keyword_");
      String _simpleName = GrammarUtil.getSimpleName(this.getLanguage().getGrammar());
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
      TypeReference _eclipsePluginExecutableExtensionFactory_2 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
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
      String _namespace_1 = GrammarUtil.getNamespace(this.getLanguage().getGrammar());
      String _plus_2 = (_namespace_1 + ".ui.keyword_");
      String _simpleName_1 = GrammarUtil.getSimpleName(this.getLanguage().getGrammar());
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
      TypeReference _eclipsePluginExecutableExtensionFactory_3 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
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
