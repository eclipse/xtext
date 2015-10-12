/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.scoping;

import com.google.inject.Inject;
import com.google.inject.name.Names;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.IgnoreCaseLinking;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

@SuppressWarnings("all")
public class ImportNamespacesScopingFragment2 extends AbstractGeneratorFragment2 {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;
  
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Accessors
  private boolean generateStub = true;
  
  @Accessors
  private boolean ignoreCase = false;
  
  @Accessors
  private boolean inheritImplementation = true;
  
  protected TypeReference getScopeProviderClass(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".scoping.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "ScopeProvider");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getScopeProviderSuperClass(final Grammar grammar) {
    TypeReference _xblockexpression = null;
    {
      final Grammar superGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(grammar);
      TypeReference _xifexpression = null;
      boolean _and = false;
      if (!this.inheritImplementation) {
        _and = false;
      } else {
        _and = (superGrammar != null);
      }
      if (_and) {
        _xifexpression = this.getScopeProviderClass(superGrammar);
      } else {
        _xifexpression = this.getDefaultScopeProviderSuperClass();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected TypeReference getDefaultScopeProviderSuperClass() {
    return new TypeReference(AbstractDeclarativeScopeProvider.class);
  }
  
  @Override
  public void generate() {
    this.contributeRuntimeGuiceBindings();
    boolean _and = false;
    if (!this.generateStub) {
      _and = false;
    } else {
      Grammar _grammar = this.getGrammar();
      boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(_grammar);
      boolean _not = (!_inheritsXbase);
      _and = _not;
    }
    if (_and) {
      boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
      if (_isPreferXtendStubs) {
        this.generateXtendScopeProvider();
      } else {
        this.generateJavaScopeProvider();
      }
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
      ManifestAccess _manifest = _runtime.getManifest();
      boolean _tripleNotEquals = (_manifest != null);
      if (_tripleNotEquals) {
        IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
        ManifestAccess _manifest_1 = _runtime_1.getManifest();
        Set<String> _exportedPackages = _manifest_1.getExportedPackages();
        Grammar _grammar_1 = this.getGrammar();
        TypeReference _scopeProviderClass = this.getScopeProviderClass(_grammar_1);
        String _packageName = _scopeProviderClass.getPackageName();
        _exportedPackages.add(_packageName);
        boolean _isPreferXtendStubs_1 = this.codeConfig.isPreferXtendStubs();
        if (_isPreferXtendStubs_1) {
          IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
          IRuntimeProjectConfig _runtime_2 = _projectConfig_2.getRuntime();
          ManifestAccess _manifest_2 = _runtime_2.getManifest();
          Set<String> _requiredBundles = _manifest_2.getRequiredBundles();
          _requiredBundles.add("org.eclipse.xtext.xbase.lib");
        }
      }
    }
  }
  
  protected void contributeRuntimeGuiceBindings() {
    final GuiceModuleAccess.BindingFactory bindingFactory = new GuiceModuleAccess.BindingFactory();
    Grammar _grammar = this.getGrammar();
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(_grammar);
    boolean _not = (!_inheritsXbase);
    if (_not) {
      if (this.generateStub) {
        TypeReference _typeRef = TypeReference.typeRef(IScopeProvider.class);
        Grammar _grammar_1 = this.getGrammar();
        TypeReference _scopeProviderClass = this.getScopeProviderClass(_grammar_1);
        bindingFactory.addTypeToType(_typeRef, _scopeProviderClass);
      } else {
        TypeReference _typeRef_1 = TypeReference.typeRef(IScopeProvider.class);
        TypeReference _typeRef_2 = TypeReference.typeRef(ImportedNamespaceAwareLocalScopeProvider.class);
        bindingFactory.addTypeToType(_typeRef_1, _typeRef_2);
      }
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("binder.bind(");
          _builder.append(IScopeProvider.class, "");
          _builder.append(".class).annotatedWith(");
          _builder.append(Names.class, "");
          _builder.append(".named(");
          _builder.append(AbstractDeclarativeScopeProvider.class, "");
          _builder.append(".NAMED_DELEGATE)).to(");
          _builder.append(ImportedNamespaceAwareLocalScopeProvider.class, "");
          _builder.append(".class);");
        }
      };
      final StringConcatenationClient statement = _client;
      String _simpleName = IScopeProvider.class.getSimpleName();
      String _plus = (_simpleName + "Delegate");
      bindingFactory.addConfiguredBinding(_plus, statement);
      TypeReference _typeRef_3 = TypeReference.typeRef(IGlobalScopeProvider.class);
      TypeReference _typeRef_4 = TypeReference.typeRef(DefaultGlobalScopeProvider.class);
      bindingFactory.addTypeToType(_typeRef_3, _typeRef_4);
    }
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bindConstant().annotatedWith(");
        _builder.append(IgnoreCaseLinking.class, "");
        _builder.append(".class).to(");
        _builder.append(ImportNamespacesScopingFragment2.this.ignoreCase, "");
        _builder.append(");");
      }
    };
    final StringConcatenationClient statement_1 = _client_1;
    String _simpleName_1 = IgnoreCaseLinking.class.getSimpleName();
    bindingFactory.addConfiguredBinding(_simpleName_1, statement_1);
    ILanguageConfig _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    bindingFactory.contributeTo(_runtimeGenModule);
  }
  
  protected void generateJavaScopeProvider() {
    Grammar _grammar = this.getGrammar();
    TypeReference _scopeProviderClass = this.getScopeProviderClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* This class contains custom scoping description.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* on how and when to use it.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        Grammar _grammar = ImportNamespacesScopingFragment2.this.getGrammar();
        TypeReference _scopeProviderClass = ImportNamespacesScopingFragment2.this.getScopeProviderClass(_grammar);
        String _simpleName = _scopeProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = ImportNamespacesScopingFragment2.this.getGrammar();
        TypeReference _scopeProviderSuperClass = ImportNamespacesScopingFragment2.this.getScopeProviderSuperClass(_grammar_1);
        _builder.append(_scopeProviderSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_scopeProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
    _createJavaFile.writeTo(_src);
  }
  
  protected void generateXtendScopeProvider() {
    Grammar _grammar = this.getGrammar();
    TypeReference _scopeProviderClass = this.getScopeProviderClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* This class contains custom scoping description.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* on how and when to use it.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        Grammar _grammar = ImportNamespacesScopingFragment2.this.getGrammar();
        TypeReference _scopeProviderClass = ImportNamespacesScopingFragment2.this.getScopeProviderClass(_grammar);
        String _simpleName = _scopeProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = ImportNamespacesScopingFragment2.this.getGrammar();
        TypeReference _scopeProviderSuperClass = ImportNamespacesScopingFragment2.this.getScopeProviderSuperClass(_grammar_1);
        _builder.append(_scopeProviderSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_scopeProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
    _createXtendFile.writeTo(_src);
  }
  
  @Pure
  public boolean isGenerateStub() {
    return this.generateStub;
  }
  
  public void setGenerateStub(final boolean generateStub) {
    this.generateStub = generateStub;
  }
  
  @Pure
  public boolean isIgnoreCase() {
    return this.ignoreCase;
  }
  
  public void setIgnoreCase(final boolean ignoreCase) {
    this.ignoreCase = ignoreCase;
  }
  
  @Pure
  public boolean isInheritImplementation() {
    return this.inheritImplementation;
  }
  
  public void setInheritImplementation(final boolean inheritImplementation) {
    this.inheritImplementation = inheritImplementation;
  }
}
