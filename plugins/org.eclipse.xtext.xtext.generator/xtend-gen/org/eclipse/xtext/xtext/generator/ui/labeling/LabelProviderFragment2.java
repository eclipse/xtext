/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.labeling;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

/**
 * Contributes the Labeling provider stub, either in Xtend or Java language.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class LabelProviderFragment2 extends AbstractGeneratorFragment2 {
  private final static String XBASE_LABEL_PROVIDER = "org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider";
  
  private final static String XBASE_DESCRIPTION_LABEL_PROVIDER = "org.eclipse.xtext.xbase.ui.labeling.XbaseDescriptionLabelProvider";
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;
  
  @Inject
  @Extension
  private CodeConfig _codeConfig;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Accessors
  private boolean generateStub = true;
  
  protected TypeReference getEObjectLabelProviderClass(final Grammar g) {
    String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(g);
    String _plus = (_eclipsePluginBasePackage + ".labeling.");
    String _simpleName = GrammarUtil.getSimpleName(g);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "LabelProvider");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getEObjectLabelProviderSuperClass(final Grammar g) {
    TypeReference _xifexpression = null;
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(g);
    if (_inheritsXbase) {
      _xifexpression = new TypeReference(LabelProviderFragment2.XBASE_LABEL_PROVIDER);
    } else {
      _xifexpression = this.getDefaultEObjectLabelProviderSuperClass();
    }
    return _xifexpression;
  }
  
  /**
   * Extra getter facilitates customization by overriding.
   */
  protected TypeReference getDefaultEObjectLabelProviderSuperClass() {
    return new TypeReference("org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider");
  }
  
  protected TypeReference getDescriptionLabelProviderClass(final Grammar g) {
    String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(g);
    String _plus = (_eclipsePluginBasePackage + ".labeling.");
    String _simpleName = GrammarUtil.getSimpleName(g);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "DescriptionLabelProvider");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getDescriptionLabelProviderSuperClass(final Grammar g) {
    TypeReference _xifexpression = null;
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(g);
    if (_inheritsXbase) {
      _xifexpression = new TypeReference(LabelProviderFragment2.XBASE_DESCRIPTION_LABEL_PROVIDER);
    } else {
      _xifexpression = this.getDefaultDescriptionLabelProviderSuperClass();
    }
    return _xifexpression;
  }
  
  /**
   * Extra getter facilitates customization by overriding.
   */
  protected TypeReference getDefaultDescriptionLabelProviderSuperClass() {
    return new TypeReference("org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider");
  }
  
  @Override
  public void generate() {
    boolean _or = false;
    if (this.generateStub) {
      _or = true;
    } else {
      Grammar _grammar = this.getGrammar();
      boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(_grammar);
      _or = _inheritsXbase;
    }
    if (_or) {
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
      ManifestAccess _manifest = _eclipsePlugin.getManifest();
      boolean _notEquals = (!Objects.equal(_manifest, null));
      if (_notEquals) {
        IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
        ManifestAccess _manifest_1 = _eclipsePlugin_1.getManifest();
        Set<String> _requiredBundles = _manifest_1.getRequiredBundles();
        _requiredBundles.add("org.eclipse.xtext.ui");
      }
      TypeReference _xifexpression = null;
      if (this.generateStub) {
        Grammar _grammar_1 = this.getGrammar();
        _xifexpression = this.getEObjectLabelProviderClass(_grammar_1);
      } else {
        _xifexpression = new TypeReference(LabelProviderFragment2.XBASE_LABEL_PROVIDER);
      }
      final TypeReference labelProviderClass = _xifexpression;
      TypeReference _xifexpression_1 = null;
      if (this.generateStub) {
        Grammar _grammar_2 = this.getGrammar();
        _xifexpression_1 = this.getDescriptionLabelProviderClass(_grammar_2);
      } else {
        _xifexpression_1 = new TypeReference(LabelProviderFragment2.XBASE_DESCRIPTION_LABEL_PROVIDER);
      }
      final TypeReference descriptionLabelProviderClass = _xifexpression_1;
      final TypeReference iLabelProviderClass = new TypeReference("org.eclipse.jface.viewers.ILabelProvider");
      final TypeReference rsdLabelProviderClass = new TypeReference("org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider");
      GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
      GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(iLabelProviderClass, labelProviderClass);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("binder.bind(");
          _builder.append(iLabelProviderClass, "");
          _builder.append(".class).annotatedWith(");
          _builder.append(rsdLabelProviderClass, "");
          _builder.append(".class).to(");
          _builder.append(descriptionLabelProviderClass, "");
          _builder.append(".class);");
          _builder.newLineIfNotEmpty();
        }
      };
      GuiceModuleAccess.BindingFactory _addConfiguredBinding = _addTypeToType.addConfiguredBinding("ResourceUIServiceLabelProvider", _client);
      ILanguageConfig _language = this.getLanguage();
      GuiceModuleAccess _eclipsePluginGenModule = _language.getEclipsePluginGenModule();
      _addConfiguredBinding.contributeTo(_eclipsePluginGenModule);
    }
    boolean _and = false;
    if (!this.generateStub) {
      _and = false;
    } else {
      IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_2 = _projectConfig_2.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _src = _eclipsePlugin_2.getSrc();
      boolean _tripleNotEquals = (_src != null);
      _and = _tripleNotEquals;
    }
    if (_and) {
      boolean _isPreferXtendStubs = this._codeConfig.isPreferXtendStubs();
      if (_isPreferXtendStubs) {
        this.generateXtendEObjectLabelProvider();
        this.generateXtendDescriptionLabelProvider();
      } else {
        this.generateJavaEObjectLabelProvider();
        this.generateJavaDescriptionLabelProvider();
      }
    }
  }
  
  protected void generateXtendEObjectLabelProvider() {
    Grammar _grammar = this.getGrammar();
    TypeReference _eObjectLabelProviderClass = this.getEObjectLabelProviderClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Provides labels for EObjects.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        Grammar _grammar = LabelProviderFragment2.this.getGrammar();
        TypeReference _eObjectLabelProviderClass = LabelProviderFragment2.this.getEObjectLabelProviderClass(_grammar);
        String _simpleName = _eObjectLabelProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = LabelProviderFragment2.this.getGrammar();
        TypeReference _eObjectLabelProviderSuperClass = LabelProviderFragment2.this.getEObjectLabelProviderSuperClass(_grammar_1);
        _builder.append(_eObjectLabelProviderSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("new(");
        TypeReference _typeReference = new TypeReference("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider");
        _builder.append(_typeReference, "\t");
        _builder.append(" delegate) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(delegate);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// Labels and icons can be computed like this:");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("//\tdef text(Greeting ele) {");
        _builder.newLine();
        _builder.append("//\t\t\'A greeting to \' + ele.name");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("//");
        _builder.newLine();
        _builder.append("//\tdef image(Greeting ele) {");
        _builder.newLine();
        _builder.append("//\t\t\'Greeting.gif\'");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_eObjectLabelProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    _createXtendFile.writeTo(_src);
  }
  
  protected void generateXtendDescriptionLabelProvider() {
    Grammar _grammar = this.getGrammar();
    TypeReference _descriptionLabelProviderClass = this.getDescriptionLabelProviderClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Provides labels for IEObjectDescriptions and IResourceDescriptions.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        Grammar _grammar = LabelProviderFragment2.this.getGrammar();
        TypeReference _descriptionLabelProviderClass = LabelProviderFragment2.this.getDescriptionLabelProviderClass(_grammar);
        String _simpleName = _descriptionLabelProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = LabelProviderFragment2.this.getGrammar();
        TypeReference _descriptionLabelProviderSuperClass = LabelProviderFragment2.this.getDescriptionLabelProviderSuperClass(_grammar_1);
        _builder.append(_descriptionLabelProviderSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// Labels and icons can be computed like this:");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("//\toverride text(IEObjectDescription ele) {");
        _builder.newLine();
        _builder.append("//\t\tele.name.toString");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("//\t ");
        _builder.newLine();
        _builder.append("//\toverride image(IEObjectDescription ele) {");
        _builder.newLine();
        _builder.append("//\t\tele.EClass.name + \'.gif\'");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_descriptionLabelProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    _createXtendFile.writeTo(_src);
  }
  
  protected void generateJavaEObjectLabelProvider() {
    Grammar _grammar = this.getGrammar();
    TypeReference _eObjectLabelProviderClass = this.getEObjectLabelProviderClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Provides labels for EObjects.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        Grammar _grammar = LabelProviderFragment2.this.getGrammar();
        TypeReference _eObjectLabelProviderClass = LabelProviderFragment2.this.getEObjectLabelProviderClass(_grammar);
        String _simpleName = _eObjectLabelProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = LabelProviderFragment2.this.getGrammar();
        TypeReference _eObjectLabelProviderSuperClass = LabelProviderFragment2.this.getEObjectLabelProviderSuperClass(_grammar_1);
        _builder.append(_eObjectLabelProviderSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        Grammar _grammar_2 = LabelProviderFragment2.this.getGrammar();
        TypeReference _eObjectLabelProviderClass_1 = LabelProviderFragment2.this.getEObjectLabelProviderClass(_grammar_2);
        String _simpleName_1 = _eObjectLabelProviderClass_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        TypeReference _typeReference = new TypeReference("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider");
        _builder.append(_typeReference, "\t");
        _builder.append(" delegate) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(delegate);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// Labels and icons can be computed like this:");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("//\tString text(Greeting ele) {");
        _builder.newLine();
        _builder.append("//\t\treturn \"A greeting to \" + ele.getName();");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("//");
        _builder.newLine();
        _builder.append("//\tString image(Greeting ele) {");
        _builder.newLine();
        _builder.append("//\t\treturn \"Greeting.gif\";");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_eObjectLabelProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    _createJavaFile.writeTo(_src);
  }
  
  protected void generateJavaDescriptionLabelProvider() {
    Grammar _grammar = this.getGrammar();
    TypeReference _descriptionLabelProviderClass = this.getDescriptionLabelProviderClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Provides labels for IEObjectDescriptions and IResourceDescriptions.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        Grammar _grammar = LabelProviderFragment2.this.getGrammar();
        TypeReference _descriptionLabelProviderClass = LabelProviderFragment2.this.getDescriptionLabelProviderClass(_grammar);
        String _simpleName = _descriptionLabelProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = LabelProviderFragment2.this.getGrammar();
        TypeReference _descriptionLabelProviderSuperClass = LabelProviderFragment2.this.getDescriptionLabelProviderSuperClass(_grammar_1);
        _builder.append(_descriptionLabelProviderSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// Labels and icons can be computed like this:");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("//\tString text(IEObjectDescription ele) {");
        _builder.newLine();
        _builder.append("//\t   return ele.getName().toString();");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("//\t ");
        _builder.newLine();
        _builder.append("//  String image(IEObjectDescription ele) {");
        _builder.newLine();
        _builder.append("//     return ele.getEClass().getName() + \".gif\";");
        _builder.newLine();
        _builder.append("//  }\t ");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_descriptionLabelProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    _createJavaFile.writeTo(_src);
  }
  
  @Pure
  public boolean isGenerateStub() {
    return this.generateStub;
  }
  
  public void setGenerateStub(final boolean generateStub) {
    this.generateStub = generateStub;
  }
}
