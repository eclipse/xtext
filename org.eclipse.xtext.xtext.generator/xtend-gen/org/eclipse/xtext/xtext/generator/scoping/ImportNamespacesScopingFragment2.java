/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.scoping;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Names;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.AccessorType;
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
import org.eclipse.xtext.xtext.generator.AbstractInheritingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

@SuppressWarnings("all")
public class ImportNamespacesScopingFragment2 extends AbstractInheritingFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;

  @Inject
  private FileAccessFactory fileAccessFactory;

  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private boolean ignoreCase = false;

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
    if ((this.isInheritImplementation() && (superGrammar != null))) {
      return this.getScopeProviderClass(superGrammar);
    } else {
      return this.getDefaultScopeProviderSuperClass();
    }
  }

  protected TypeReference getDefaultScopeProviderSuperClass() {
    TypeReference _xifexpression = null;
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(this.getLanguage().getGrammar());
    if (_inheritsXbase) {
      _xifexpression = TypeReference.typeRef("org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider");
    } else {
      _xifexpression = TypeReference.typeRef(DelegatingScopeProvider.class);
    }
    return _xifexpression;
  }

  protected TypeReference getDelegateScopeProvider() {
    TypeReference _xifexpression = null;
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(this.getLanguage().getGrammar());
    if (_inheritsXbase) {
      _xifexpression = TypeReference.typeRef("org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider");
    } else {
      _xifexpression = TypeReference.typeRef(ImportedNamespaceAwareLocalScopeProvider.class);
    }
    return _xifexpression;
  }

  protected TypeReference getGlobalScopeProvider() {
    return TypeReference.typeRef(DefaultGlobalScopeProvider.class);
  }

  @Override
  public void generate() {
    this.contributeRuntimeGuiceBindings();
    this.generateGenScopeProvider();
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        this.generateXtendScopeProvider();
      } else {
        this.generateJavaScopeProvider();
      }
      ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
      boolean _tripleNotEquals = (_manifest != null);
      if (_tripleNotEquals) {
        Set<String> _exportedPackages = this.getProjectConfig().getRuntime().getManifest().getExportedPackages();
        String _packageName = this.getScopeProviderClass(this.getGrammar()).getPackageName();
        _exportedPackages.add(_packageName);
        boolean _isGenerateXtendStub_1 = this.isGenerateXtendStub();
        if (_isGenerateXtendStub_1) {
          Set<String> _requiredBundles = this.getProjectConfig().getRuntime().getManifest().getRequiredBundles();
          String _xbaseLibVersionLowerBound = this.getProjectConfig().getRuntime().getXbaseLibVersionLowerBound();
          String _plus = ("org.eclipse.xtext.xbase.lib;bundle-version=\"" + _xbaseLibVersionLowerBound);
          String _plus_1 = (_plus + "\"");
          _requiredBundles.add(_plus_1);
        }
      }
    }
  }

  protected void contributeRuntimeGuiceBindings() {
    final GuiceModuleAccess.BindingFactory bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _xifexpression = null;
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(this.getLanguage().getGrammar());
    if (_inheritsXbase) {
      _xifexpression = TypeReference.typeRef("org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider");
    } else {
      _xifexpression = TypeReference.typeRef(IScopeProvider.class);
    }
    final TypeReference targetType = _xifexpression;
    bindingFactory.addTypeToType(targetType, this.getScopeProviderClass(this.getGrammar()));
    String _simpleName = IScopeProvider.class.getSimpleName();
    String _plus = (_simpleName + "Delegate");
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IScopeProvider.class);
        _builder.append(".class).annotatedWith(");
        _builder.append(Names.class);
        _builder.append(".named(");
        _builder.append(AbstractDeclarativeScopeProvider.class);
        _builder.append(".NAMED_DELEGATE)).to(");
        TypeReference _delegateScopeProvider = ImportNamespacesScopingFragment2.this.getDelegateScopeProvider();
        _builder.append(_delegateScopeProvider);
        _builder.append(".class);");
      }
    };
    bindingFactory.addConfiguredBinding(_plus, _client);
    bindingFactory.addTypeToType(TypeReference.typeRef(IGlobalScopeProvider.class), this.getGlobalScopeProvider());
    String _simpleName_1 = IgnoreCaseLinking.class.getSimpleName();
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bindConstant().annotatedWith(");
        _builder.append(IgnoreCaseLinking.class);
        _builder.append(".class).to(");
        _builder.append(ImportNamespacesScopingFragment2.this.ignoreCase);
        _builder.append(");");
      }
    };
    bindingFactory.addConfiguredBinding(_simpleName_1, _client_1);
    bindingFactory.contributeTo(this.getLanguage().getRuntimeGenModule());
  }

  protected void generateGenScopeProvider() {
    TypeReference _xifexpression = null;
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      _xifexpression = this.getAbstractScopeProviderClass(this.getGrammar());
    } else {
      _xifexpression = this.getScopeProviderClass(this.getGrammar());
    }
    final TypeReference genClass = _xifexpression;
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(genClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public ");
        {
          boolean _isGenerateStub = ImportNamespacesScopingFragment2.this.isGenerateStub();
          if (_isGenerateStub) {
            _builder.append("abstract ");
          }
        }
        _builder.append("class ");
        String _simpleName = genClass.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _scopeProviderSuperClass = ImportNamespacesScopingFragment2.this.getScopeProviderSuperClass(ImportNamespacesScopingFragment2.this.getGrammar());
        _builder.append(_scopeProviderSuperClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getRuntime().getSrcGen());
  }

  protected void generateJavaScopeProvider() {
    TypeReference _scopeProviderClass = this.getScopeProviderClass(this.getGrammar());
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
        String _simpleName = ImportNamespacesScopingFragment2.this.getScopeProviderClass(ImportNamespacesScopingFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _abstractScopeProviderClass = ImportNamespacesScopingFragment2.this.getAbstractScopeProviderClass(ImportNamespacesScopingFragment2.this.getGrammar());
        _builder.append(_abstractScopeProviderClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createJavaFile(_scopeProviderClass, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
  }

  protected void generateXtendScopeProvider() {
    TypeReference _scopeProviderClass = this.getScopeProviderClass(this.getGrammar());
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
        String _simpleName = ImportNamespacesScopingFragment2.this.getScopeProviderClass(ImportNamespacesScopingFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _abstractScopeProviderClass = ImportNamespacesScopingFragment2.this.getAbstractScopeProviderClass(ImportNamespacesScopingFragment2.this.getGrammar());
        _builder.append(_abstractScopeProviderClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createXtendFile(_scopeProviderClass, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
  }

  @Pure
  protected boolean isIgnoreCase() {
    return this.ignoreCase;
  }

  public void setIgnoreCase(final boolean ignoreCase) {
    this.ignoreCase = ignoreCase;
  }
}
