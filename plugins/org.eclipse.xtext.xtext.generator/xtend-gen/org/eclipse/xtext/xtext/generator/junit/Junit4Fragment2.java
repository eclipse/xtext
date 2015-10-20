package org.eclipse.xtext.xtext.generator.junit;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;

@SuppressWarnings("all")
public class Junit4Fragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Override
  public void generate() {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _runtimeTest = _projectConfig.getRuntimeTest();
    ManifestAccess _manifest = _runtimeTest.getManifest();
    boolean _notEquals = (!Objects.equal(_manifest, null));
    if (_notEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IBundleProjectConfig _runtimeTest_1 = _projectConfig_1.getRuntimeTest();
      ManifestAccess _manifest_1 = _runtimeTest_1.getManifest();
      final Procedure1<ManifestAccess> _function = new Procedure1<ManifestAccess>() {
        @Override
        public void apply(final ManifestAccess it) {
          Set<String> _requiredBundles = it.getRequiredBundles();
          CollectionExtensions.<String>addAll(_requiredBundles, 
            "org.eclipse.xtext.junit4", 
            "org.eclipse.xtext.xbase.lib");
          Set<String> _exportedPackages = it.getExportedPackages();
          Grammar _grammar = Junit4Fragment2.this.getGrammar();
          String _runtimeTestBasePackage = Junit4Fragment2.this._xtextGeneratorNaming.getRuntimeTestBasePackage(_grammar);
          _exportedPackages.add(_runtimeTestBasePackage);
        }
      };
      ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifest_1, _function);
    }
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePluginTest = _projectConfig_2.getEclipsePluginTest();
    ManifestAccess _manifest_2 = _eclipsePluginTest.getManifest();
    boolean _notEquals_1 = (!Objects.equal(_manifest_2, null));
    if (_notEquals_1) {
      IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePluginTest_1 = _projectConfig_3.getEclipsePluginTest();
      ManifestAccess _manifest_3 = _eclipsePluginTest_1.getManifest();
      final Procedure1<ManifestAccess> _function_1 = new Procedure1<ManifestAccess>() {
        @Override
        public void apply(final ManifestAccess it) {
          Set<String> _requiredBundles = it.getRequiredBundles();
          CollectionExtensions.<String>addAll(_requiredBundles, 
            "org.eclipse.core.runtime", 
            "org.eclipse.ui.workbench;resolution:=optional");
          Set<String> _exportedPackages = it.getExportedPackages();
          Grammar _grammar = Junit4Fragment2.this.getGrammar();
          String _eclipsePluginTestBasePackage = Junit4Fragment2.this._xtextGeneratorNaming.getEclipsePluginTestBasePackage(_grammar);
          _exportedPackages.add(_eclipsePluginTestBasePackage);
        }
      };
      ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifest_3, _function_1);
    }
    IXtextProjectConfig _projectConfig_4 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig_4.getEclipsePlugin();
    ManifestAccess _manifest_4 = _eclipsePlugin.getManifest();
    boolean _notEquals_2 = (!Objects.equal(_manifest_4, null));
    if (_notEquals_2) {
      IXtextProjectConfig _projectConfig_5 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_5.getEclipsePlugin();
      ManifestAccess _manifest_5 = _eclipsePlugin_1.getManifest();
      Set<String> _exportedPackages = _manifest_5.getExportedPackages();
      Grammar _grammar = this.getGrammar();
      TypeReference _eclipsePluginActivator = this._xtextGeneratorNaming.getEclipsePluginActivator(_grammar);
      String _packageName = _eclipsePluginActivator.getPackageName();
      _exportedPackages.add(_packageName);
    }
    IXtextProjectConfig _projectConfig_6 = this.getProjectConfig();
    IBundleProjectConfig _runtimeTest_2 = _projectConfig_6.getRuntimeTest();
    ManifestAccess _manifest_6 = _runtimeTest_2.getManifest();
    IXtextProjectConfig _projectConfig_7 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePluginTest_2 = _projectConfig_7.getEclipsePluginTest();
    ManifestAccess _manifest_7 = _eclipsePluginTest_2.getManifest();
    Iterable<ManifestAccess> _filterNull = IterableExtensions.<ManifestAccess>filterNull(Collections.<ManifestAccess>unmodifiableList(CollectionLiterals.<ManifestAccess>newArrayList(_manifest_6, _manifest_7)));
    final Procedure1<ManifestAccess> _function_2 = new Procedure1<ManifestAccess>() {
      @Override
      public void apply(final ManifestAccess it) {
        Set<String> _importedPackages = it.getImportedPackages();
        CollectionExtensions.<String>addAll(_importedPackages, 
          "org.junit;version=\"4.5.0\"", 
          "org.junit.runner;version=\"4.5.0\"", 
          "org.junit.runner.manipulation;version=\"4.5.0\"", 
          "org.junit.runner.notification;version=\"4.5.0\"", 
          "org.junit.runners;version=\"4.5.0\"", 
          "org.junit.runners.model;version=\"4.5.0\"", 
          "org.hamcrest.core");
      }
    };
    IterableExtensions.<ManifestAccess>forEach(_filterNull, _function_2);
    JavaFileAccess _generateInjectorProvider = this.generateInjectorProvider();
    IXtextProjectConfig _projectConfig_8 = this.getProjectConfig();
    IBundleProjectConfig _runtimeTest_3 = _projectConfig_8.getRuntimeTest();
    IXtextGeneratorFileSystemAccess _srcGen = _runtimeTest_3.getSrcGen();
    _generateInjectorProvider.writeTo(_srcGen);
    JavaFileAccess _generateExampleRuntimeTest = this.generateExampleRuntimeTest();
    IXtextProjectConfig _projectConfig_9 = this.getProjectConfig();
    IBundleProjectConfig _runtimeTest_4 = _projectConfig_9.getRuntimeTest();
    IXtextGeneratorFileSystemAccess _src = _runtimeTest_4.getSrc();
    _generateExampleRuntimeTest.writeTo(_src);
    JavaFileAccess _generateUiInjectorProvider = this.generateUiInjectorProvider();
    IXtextProjectConfig _projectConfig_10 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePluginTest_3 = _projectConfig_10.getEclipsePluginTest();
    IXtextGeneratorFileSystemAccess _srcGen_1 = _eclipsePluginTest_3.getSrcGen();
    _generateUiInjectorProvider.writeTo(_srcGen_1);
  }
  
  public JavaFileAccess generateExampleRuntimeTest() {
    final TypeReference xtextRunner = new TypeReference("org.eclipse.xtext.junit4.XtextRunner");
    final TypeReference runWith = new TypeReference("org.junit.runner.RunWith");
    final TypeReference injectWith = new TypeReference("org.eclipse.xtext.junit4.InjectWith");
    final TypeReference parseHelper = new TypeReference("org.eclipse.xtext.junit4.util.ParseHelper");
    final TypeReference test = new TypeReference("org.junit.Test");
    final TypeReference assert_ = new TypeReference("org.junit.Assert");
    Grammar _grammar = this.getGrammar();
    EList<AbstractRule> _rules = _grammar.getRules();
    AbstractRule _head = IterableExtensions.<AbstractRule>head(_rules);
    TypeRef _type = _head.getType();
    EClassifier _classifier = _type.getClassifier();
    Grammar _grammar_1 = this.getGrammar();
    Resource _eResource = _grammar_1.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    String _javaTypeName = GenModelUtil2.getJavaTypeName(_classifier, _resourceSet);
    final TypeReference rootType = new TypeReference(_javaTypeName);
    TypeReference _exampleRuntimeTest = this.exampleRuntimeTest();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("@");
        _builder.append(runWith, "");
        _builder.append("(");
        _builder.append(xtextRunner, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("@");
        _builder.append(injectWith, "");
        _builder.append("(");
        TypeReference _injectorProvider = Junit4Fragment2.this.injectorProvider();
        _builder.append(_injectorProvider, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("class ");
        TypeReference _exampleRuntimeTest = Junit4Fragment2.this.exampleRuntimeTest();
        _builder.append(_exampleRuntimeTest, "");
        _builder.append("{");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(parseHelper, "\t");
        _builder.append("<");
        _builder.append(rootType, "\t");
        _builder.append("> parseHelper;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(test, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("def void loadModel() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("val result = parseHelper.parse(\'\'");
        _builder.append("\'");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("Hello Xtext!");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\'\'");
        _builder.append("\')");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(assert_, "\t\t");
        _builder.append(".assertNotNull(result)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_exampleRuntimeTest, _client);
  }
  
  public TypeReference exampleRuntimeTest() {
    Grammar _grammar = this.getGrammar();
    String _runtimeTestBasePackage = this._xtextGeneratorNaming.getRuntimeTestBasePackage(_grammar);
    Grammar _grammar_1 = this.getGrammar();
    String _simpleName = GrammarUtil.getSimpleName(_grammar_1);
    String _plus = (_simpleName + "ParsingTest");
    return new TypeReference(_runtimeTestBasePackage, _plus);
  }
  
  public JavaFileAccess generateInjectorProvider() {
    JavaFileAccess _xblockexpression = null;
    {
      TypeReference _injectorProvider = this.injectorProvider();
      final JavaFileAccess file = this.fileAccessFactory.createJavaFile(_injectorProvider);
      final TypeReference globalRegistries = new TypeReference("org.eclipse.xtext.junit4.GlobalRegistries");
      final TypeReference globalStateMemento = new TypeReference("org.eclipse.xtext.junit4.GlobalRegistries.GlobalStateMemento");
      final TypeReference iRegistryConfigurator = new TypeReference("org.eclipse.xtext.junit4.IRegistryConfigurator");
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          TypeReference _injectorProvider = Junit4Fragment2.this.injectorProvider();
          String _simpleName = _injectorProvider.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" implements ");
          TypeReference _iInjectorProvider = Junit4Fragment2.this.iInjectorProvider();
          _builder.append(_iInjectorProvider, "");
          _builder.append(", ");
          _builder.append(iRegistryConfigurator, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected ");
          _builder.append(globalStateMemento, "\t");
          _builder.append(" stateBeforeInjectorCreation;");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("protected ");
          _builder.append(globalStateMemento, "\t");
          _builder.append(" stateAfterInjectorCreation;");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("protected ");
          _builder.append(Injector.class, "\t");
          _builder.append(" injector;");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("static {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append(globalRegistries, "\t\t");
          _builder.append(".initializeDefaults();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public ");
          _builder.append(Injector.class, "\t");
          _builder.append(" getInjector()\t{");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("if (injector == null) {");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("stateBeforeInjectorCreation = ");
          _builder.append(globalRegistries, "\t\t\t");
          _builder.append(".makeCopyOfGlobalState();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("this.injector = internalCreateInjector();");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("stateAfterInjectorCreation = ");
          _builder.append(globalRegistries, "\t\t\t");
          _builder.append(".makeCopyOfGlobalState();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return injector;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected ");
          _builder.append(Injector.class, "\t");
          _builder.append(" internalCreateInjector() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("return new ");
          Grammar _grammar = Junit4Fragment2.this.getGrammar();
          TypeReference _runtimeSetup = Junit4Fragment2.this._xtextGeneratorNaming.getRuntimeSetup(_grammar);
          _builder.append(_runtimeSetup, "\t\t");
          _builder.append("().createInjectorAndDoEMFRegistration();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void restoreRegistry() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("stateBeforeInjectorCreation.restoreGlobalState();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void setupRegistry() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("getInjector();");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("stateAfterInjectorCreation.restoreGlobalState();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      file.setContent(_client);
      _xblockexpression = file;
    }
    return _xblockexpression;
  }
  
  public TypeReference iInjectorProvider() {
    return new TypeReference("org.eclipse.xtext.junit4.IInjectorProvider");
  }
  
  public TypeReference injectorProvider() {
    Grammar _grammar = this.getGrammar();
    String _runtimeTestBasePackage = this._xtextGeneratorNaming.getRuntimeTestBasePackage(_grammar);
    Grammar _grammar_1 = this.getGrammar();
    String _simpleName = GrammarUtil.getSimpleName(_grammar_1);
    String _plus = (_simpleName + "InjectorProvider");
    return new TypeReference(_runtimeTestBasePackage, _plus);
  }
  
  public JavaFileAccess generateUiInjectorProvider() {
    JavaFileAccess _xblockexpression = null;
    {
      TypeReference _uiInjectorProvider = this.uiInjectorProvider();
      final JavaFileAccess file = this.fileAccessFactory.createJavaFile(_uiInjectorProvider);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          TypeReference _uiInjectorProvider = Junit4Fragment2.this.uiInjectorProvider();
          String _simpleName = _uiInjectorProvider.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" implements ");
          TypeReference _iInjectorProvider = Junit4Fragment2.this.iInjectorProvider();
          _builder.append(_iInjectorProvider, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public ");
          _builder.append(Injector.class, "\t");
          _builder.append(" getInjector() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("return ");
          Grammar _grammar = Junit4Fragment2.this.getGrammar();
          TypeReference _eclipsePluginActivator = Junit4Fragment2.this._xtextGeneratorNaming.getEclipsePluginActivator(_grammar);
          _builder.append(_eclipsePluginActivator, "\t\t");
          _builder.append(".getInstance().getInjector(\"");
          Grammar _grammar_1 = Junit4Fragment2.this.getGrammar();
          String _name = _grammar_1.getName();
          _builder.append(_name, "\t\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      file.setContent(_client);
      _xblockexpression = file;
    }
    return _xblockexpression;
  }
  
  public TypeReference uiInjectorProvider() {
    Grammar _grammar = this.getGrammar();
    String _eclipsePluginTestBasePackage = this._xtextGeneratorNaming.getEclipsePluginTestBasePackage(_grammar);
    Grammar _grammar_1 = this.getGrammar();
    String _simpleName = GrammarUtil.getSimpleName(_grammar_1);
    String _plus = (_simpleName + "UiInjectorProvider");
    return new TypeReference(_eclipsePluginTestBasePackage, _plus);
  }
}
