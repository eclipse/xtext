/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.scoping;

import com.google.common.base.Objects;
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
import org.eclipse.xtext.scoping.impl.DelegatingScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IGeneratesStub;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

@SuppressWarnings("all")
public class ImportNamespacesScopingFragment2 extends AbstractXtextGeneratorFragment implements IGeneratesStub {
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
    String _name = grammar.getName();
    boolean _equals = Objects.equal(_name, "org.eclipse.xtext.xbase.Xbase");
    if (_equals) {
      return TypeReference.typeRef("org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider");
    }
    String _name_1 = grammar.getName();
    boolean _equals_1 = Objects.equal(_name_1, "org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations");
    if (_equals_1) {
      return TypeReference.typeRef("org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider");
    }
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".scoping.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "ScopeProvider");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getAbstractScopeProviderClass(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".scoping.");
    String _plus_1 = (_plus + "Abstract");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_2 = (_plus_1 + _simpleName);
    String _plus_3 = (_plus_2 + "ScopeProvider");
    return new TypeReference(_plus_3);
  }
  
  protected TypeReference getScopeProviderSuperClass(final Grammar grammar) {
    final Grammar superGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(grammar);
    boolean _and = false;
    if (!this.inheritImplementation) {
      _and = false;
    } else {
      _and = (superGrammar != null);
    }
    if (_and) {
      return this.getScopeProviderClass(superGrammar);
    } else {
      return this.getDefaultScopeProviderSuperClass();
    }
  }
  
  protected TypeReference getDefaultScopeProviderSuperClass() {
    TypeReference _xifexpression = null;
    IXtextGeneratorLanguage _language = this.getLanguage();
    Grammar _grammar = _language.getGrammar();
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(_grammar);
    if (_inheritsXbase) {
      _xifexpression = TypeReference.typeRef("org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider");
    } else {
      _xifexpression = TypeReference.typeRef(DelegatingScopeProvider.class);
    }
    return _xifexpression;
  }
  
  public TypeReference getDelegateScopeProvider() {
    TypeReference _xifexpression = null;
    IXtextGeneratorLanguage _language = this.getLanguage();
    Grammar _grammar = _language.getGrammar();
    boolean _usesXImportSection = this._xbaseUsageDetector.usesXImportSection(_grammar);
    if (_usesXImportSection) {
      _xifexpression = TypeReference.typeRef("org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider");
    } else {
      _xifexpression = TypeReference.typeRef(ImportedNamespaceAwareLocalScopeProvider.class);
    }
    return _xifexpression;
  }
  
  @Override
  public void generate() {
    this.contributeRuntimeGuiceBindings();
    if (this.generateStub) {
      this.generateAbstractScopeProvider();
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
        Grammar _grammar = this.getGrammar();
        TypeReference _scopeProviderClass = this.getScopeProviderClass(_grammar);
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
    if (this.generateStub) {
      TypeReference _typeRef = TypeReference.typeRef(IScopeProvider.class);
      Grammar _grammar = this.getGrammar();
      TypeReference _scopeProviderClass = this.getScopeProviderClass(_grammar);
      bindingFactory.addTypeToType(_typeRef, _scopeProviderClass);
    } else {
      TypeReference _typeRef_1 = TypeReference.typeRef(IScopeProvider.class);
      Grammar _grammar_1 = this.getGrammar();
      TypeReference _scopeProviderSuperClass = this.getScopeProviderSuperClass(_grammar_1);
      bindingFactory.addTypeToType(_typeRef_1, _scopeProviderSuperClass);
    }
    String _simpleName = IScopeProvider.class.getSimpleName();
    String _plus = (_simpleName + "Delegate");
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
        TypeReference _delegateScopeProvider = ImportNamespacesScopingFragment2.this.getDelegateScopeProvider();
        _builder.append(_delegateScopeProvider, "");
        _builder.append(".class);");
      }
    };
    bindingFactory.addConfiguredBinding(_plus, _client);
    TypeReference _typeRef_2 = TypeReference.typeRef(IGlobalScopeProvider.class);
    TypeReference _typeRef_3 = TypeReference.typeRef(DefaultGlobalScopeProvider.class);
    bindingFactory.addTypeToType(_typeRef_2, _typeRef_3);
    String _simpleName_1 = IgnoreCaseLinking.class.getSimpleName();
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
    bindingFactory.addConfiguredBinding(_simpleName_1, _client_1);
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    bindingFactory.contributeTo(_runtimeGenModule);
  }
  
  public void generateAbstractScopeProvider() {
    Grammar _grammar = this.getGrammar();
    TypeReference _abstractScopeProviderClass = this.getAbstractScopeProviderClass(_grammar);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(_abstractScopeProviderClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        Grammar _grammar = ImportNamespacesScopingFragment2.this.getGrammar();
        TypeReference _abstractScopeProviderClass = ImportNamespacesScopingFragment2.this.getAbstractScopeProviderClass(_grammar);
        String _simpleName = _abstractScopeProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = ImportNamespacesScopingFragment2.this.getGrammar();
        TypeReference _scopeProviderSuperClass = ImportNamespacesScopingFragment2.this.getScopeProviderSuperClass(_grammar_1);
        _builder.append(_scopeProviderSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
    file.writeTo(_srcGen);
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
        TypeReference _abstractScopeProviderClass = ImportNamespacesScopingFragment2.this.getAbstractScopeProviderClass(_grammar_1);
        _builder.append(_abstractScopeProviderClass, "");
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
        TypeReference _abstractScopeProviderClass = ImportNamespacesScopingFragment2.this.getAbstractScopeProviderClass(_grammar_1);
        _builder.append(_abstractScopeProviderClass, "");
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
