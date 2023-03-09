/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.ui.labeling;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

/**
 * Contributes the Labeling provider stub, either in Xtend or Java language.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class LabelProviderFragment2 extends AbstractStubGeneratingFragment {
  private static final String XBASE_LABEL_PROVIDER = "org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider";

  private static final String XBASE_DESCRIPTION_LABEL_PROVIDER = "org.eclipse.xtext.xbase.ui.labeling.XbaseDescriptionLabelProvider";

  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;

  @Inject
  private FileAccessFactory fileAccessFactory;

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
    if ((this.isGenerateStub() || this._xbaseUsageDetector.inheritsXbase(this.getGrammar()))) {
      ManifestAccess _manifest = this.getProjectConfig().getEclipsePlugin().getManifest();
      boolean _tripleNotEquals = (_manifest != null);
      if (_tripleNotEquals) {
        Set<String> _requiredBundles = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
        _requiredBundles.add("org.eclipse.xtext.ui");
      }
      TypeReference _xifexpression = null;
      boolean _isGenerateStub = this.isGenerateStub();
      if (_isGenerateStub) {
        _xifexpression = this.getEObjectLabelProviderClass(this.getGrammar());
      } else {
        _xifexpression = new TypeReference(LabelProviderFragment2.XBASE_LABEL_PROVIDER);
      }
      final TypeReference labelProviderClass = _xifexpression;
      TypeReference _xifexpression_1 = null;
      boolean _isGenerateStub_1 = this.isGenerateStub();
      if (_isGenerateStub_1) {
        _xifexpression_1 = this.getDescriptionLabelProviderClass(this.getGrammar());
      } else {
        _xifexpression_1 = new TypeReference(LabelProviderFragment2.XBASE_DESCRIPTION_LABEL_PROVIDER);
      }
      final TypeReference descriptionLabelProviderClass = _xifexpression_1;
      final TypeReference iLabelProviderClass = new TypeReference("org.eclipse.jface.viewers.ILabelProvider");
      final TypeReference rsdLabelProviderClass = new TypeReference("org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider");
      GuiceModuleAccess.BindingFactory _addTypeToType = new GuiceModuleAccess.BindingFactory().addTypeToType(iLabelProviderClass, labelProviderClass);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("binder.bind(");
          _builder.append(iLabelProviderClass);
          _builder.append(".class).annotatedWith(");
          _builder.append(rsdLabelProviderClass);
          _builder.append(".class).to(");
          _builder.append(descriptionLabelProviderClass);
          _builder.append(".class);");
          _builder.newLineIfNotEmpty();
        }
      };
      _addTypeToType.addConfiguredBinding("ResourceUIServiceLabelProvider", _client).contributeTo(this.getLanguage().getEclipsePluginGenModule());
    }
    if ((this.isGenerateStub() && (this.getProjectConfig().getEclipsePlugin().getSrc() != null))) {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        this.generateXtendEObjectLabelProvider();
        this.generateXtendDescriptionLabelProvider();
      } else {
        this.generateJavaEObjectLabelProvider();
        this.generateJavaDescriptionLabelProvider();
      }
    }
  }

  protected void generateXtendEObjectLabelProvider() {
    TypeReference _eObjectLabelProviderClass = this.getEObjectLabelProviderClass(this.getGrammar());
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
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        String _simpleName = LabelProviderFragment2.this.getEObjectLabelProviderClass(LabelProviderFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _eObjectLabelProviderSuperClass = LabelProviderFragment2.this.getEObjectLabelProviderSuperClass(LabelProviderFragment2.this.getGrammar());
        _builder.append(_eObjectLabelProviderSuperClass);
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
    this.fileAccessFactory.createXtendFile(_eObjectLabelProviderClass, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  protected void generateXtendDescriptionLabelProvider() {
    TypeReference _descriptionLabelProviderClass = this.getDescriptionLabelProviderClass(this.getGrammar());
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
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        String _simpleName = LabelProviderFragment2.this.getDescriptionLabelProviderClass(LabelProviderFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _descriptionLabelProviderSuperClass = LabelProviderFragment2.this.getDescriptionLabelProviderSuperClass(LabelProviderFragment2.this.getGrammar());
        _builder.append(_descriptionLabelProviderSuperClass);
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
    this.fileAccessFactory.createXtendFile(_descriptionLabelProviderClass, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  protected void generateJavaEObjectLabelProvider() {
    TypeReference _eObjectLabelProviderClass = this.getEObjectLabelProviderClass(this.getGrammar());
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
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = LabelProviderFragment2.this.getEObjectLabelProviderClass(LabelProviderFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _eObjectLabelProviderSuperClass = LabelProviderFragment2.this.getEObjectLabelProviderSuperClass(LabelProviderFragment2.this.getGrammar());
        _builder.append(_eObjectLabelProviderSuperClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        String _simpleName_1 = LabelProviderFragment2.this.getEObjectLabelProviderClass(LabelProviderFragment2.this.getGrammar()).getSimpleName();
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
    this.fileAccessFactory.createJavaFile(_eObjectLabelProviderClass, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  protected void generateJavaDescriptionLabelProvider() {
    TypeReference _descriptionLabelProviderClass = this.getDescriptionLabelProviderClass(this.getGrammar());
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
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = LabelProviderFragment2.this.getDescriptionLabelProviderClass(LabelProviderFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _descriptionLabelProviderSuperClass = LabelProviderFragment2.this.getDescriptionLabelProviderSuperClass(LabelProviderFragment2.this.getGrammar());
        _builder.append(_descriptionLabelProviderSuperClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// Labels and icons can be computed like this:");
        _builder.newLine();
        _builder.append("//\t@Override");
        _builder.newLine();
        _builder.append("//\tpublic String text(IEObjectDescription ele) {");
        _builder.newLine();
        _builder.append("//\t\treturn ele.getName().toString();");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("//\t");
        _builder.newLine();
        _builder.append("//\t@Override");
        _builder.newLine();
        _builder.append("//\tpublic String image(IEObjectDescription ele) {");
        _builder.newLine();
        _builder.append("//\t\treturn ele.getEClass().getName() + \".gif\";");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createJavaFile(_descriptionLabelProviderClass, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }
}
