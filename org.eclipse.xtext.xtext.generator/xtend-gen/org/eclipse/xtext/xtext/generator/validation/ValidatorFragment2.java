/**
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.validation;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Annotation;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.AnnotationNames;
import org.eclipse.xtext.xtext.generator.AbstractInheritingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

/**
 * By using this fragment validation gets enabled.
 * By using @Deprecated in the grammar on a ParserRule a validation gets generated that raises an issue for that.
 * In this way model evolution becomes possible.
 */
@SuppressWarnings("all")
public class ValidatorFragment2 extends AbstractInheritingFragment {
  @Inject
  @Extension
  private ValidatorNaming _validatorNaming;

  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Inject
  private FileAccessFactory fileAccessFactory;

  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;

  @Accessors
  private boolean generateDeprecationValidation = false;

  @Accessors
  private boolean generatePropertyPage = false;

  private final List<String> composedChecks = CollectionLiterals.<String>newArrayList();

  /**
   * Adds a validator that is to be executed additionally.
   * 
   * @param composedCheckValidator
   *            name of a class extending {@link AbstractDeclarativeValidator}
   */
  public void addComposedCheck(final String composedCheckValidator) {
    this.composedChecks.add(composedCheckValidator);
  }

  /**
   * @since 2.14
   */
  protected TypeReference getConfigurableIssueCodesProviderClass() {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
    String _plus = (_runtimeBasePackage + ".validation.");
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "ConfigurableIssueCodesProvider");
    return new TypeReference(_plus_2);
  }

  /**
   * @since 2.14
   */
  protected TypeReference getValidatorConfigurationBlockClass() {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
    String _plus = (_runtimeBasePackage + ".validation.");
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "ValidatorConfigurationBlock");
    return new TypeReference(_plus_2);
  }

  /**
   * @since 2.14
   */
  protected TypeReference getAbstractValidatorConfigurationBlockClass() {
    return new TypeReference("org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock");
  }

  /**
   * @since 2.14
   */
  protected TypeReference getXbaseValidationConfigurationBlockClass() {
    return new TypeReference("org.eclipse.xtext.xbase.ui.validation.XbaseValidationConfigurationBlock");
  }

  /**
   * @since 2.14
   */
  protected TypeReference getSuperConfigurableIssueCodesProviderClass() {
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(this.getLanguage().getGrammar());
    if (_inheritsXbase) {
      return new TypeReference("org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes");
    } else {
      return new TypeReference(ConfigurableIssueCodesProvider.class);
    }
  }

  protected TypeReference getGenValidatorSuperClass(final Grammar grammar) {
    TypeReference _xblockexpression = null;
    {
      final Grammar superGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(grammar);
      TypeReference _xifexpression = null;
      if ((this.isInheritImplementation() && (superGrammar != null))) {
        _xifexpression = this._validatorNaming.getValidatorClass(superGrammar);
      } else {
        _xifexpression = this.getDefaultValidatorSuperClass();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  protected TypeReference getDefaultValidatorSuperClass() {
    return new TypeReference(AbstractDeclarativeValidator.class);
  }

  /**
   * @since 2.14
   */
  protected void contributeRuntimeGuiceBindings() {
    final GuiceModuleAccess.BindingFactory bindingFactory = new GuiceModuleAccess.BindingFactory();
    bindingFactory.addTypeToTypeEagerSingleton(this._validatorNaming.getValidatorClass(this.getGrammar()), this._validatorNaming.getValidatorClass(this.getGrammar()));
    if ((this.generateDeprecationValidation || this.generatePropertyPage)) {
      bindingFactory.addTypeToType(this.getSuperConfigurableIssueCodesProviderClass(), this.getConfigurableIssueCodesProviderClass());
    }
    bindingFactory.contributeTo(this.getLanguage().getRuntimeGenModule());
  }

  /**
   * @since 2.14
   */
  protected void contributePluginGuiceBindings() {
    if ((this.generateDeprecationValidation || this.generatePropertyPage)) {
      final GuiceModuleAccess.BindingFactory bindingFactory = new GuiceModuleAccess.BindingFactory();
      bindingFactory.addTypeToType(this.getAbstractValidatorConfigurationBlockClass(), this.getValidatorConfigurationBlockClass());
      bindingFactory.contributeTo(this.getLanguage().getEclipsePluginGenModule());
    }
  }

  @Override
  public void generate() {
    this.contributeRuntimeGuiceBindings();
    this.contributePluginGuiceBindings();
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        this.generateXtendValidatorStub();
      } else {
        this.generateJavaValidatorStub();
      }
    }
    this.generateGenValidator().writeTo(this.getProjectConfig().getRuntime().getSrcGen());
    if ((this.generateDeprecationValidation || this.generatePropertyPage)) {
      this.generateIssueProvider().writeTo(this.getProjectConfig().getRuntime().getSrcGen());
      this.generateValidationConfigurationBlock().writeTo(this.getProjectConfig().getEclipsePlugin().getSrcGen());
    }
    ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Set<String> _exportedPackages = this.getProjectConfig().getRuntime().getManifest().getExportedPackages();
      String _packageName = this._validatorNaming.getValidatorClass(this.getGrammar()).getPackageName();
      _exportedPackages.add(_packageName);
    }
    PluginXmlAccess _pluginXml = this.getProjectConfig().getEclipsePlugin().getPluginXml();
    boolean _tripleNotEquals_1 = (_pluginXml != null);
    if (_tripleNotEquals_1) {
      this.contributeEclipsePluginExtensions();
    }
  }

  protected void generateXtendValidatorStub() {
    TypeReference _validatorClass = this._validatorNaming.getValidatorClass(this.getGrammar());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* This class contains custom validation rules. ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        String _simpleName = ValidatorFragment2.this._validatorNaming.getValidatorClass(ValidatorFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _abstractValidatorClass = ValidatorFragment2.this._validatorNaming.getAbstractValidatorClass(ValidatorFragment2.this.getGrammar());
        _builder.append(_abstractValidatorClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("//\tpublic static val INVALID_NAME = \'invalidName\'");
        _builder.newLine();
        _builder.append("//");
        _builder.newLine();
        _builder.append("//\t@Check");
        _builder.newLine();
        _builder.append("//\tdef checkGreetingStartsWithCapital(Greeting greeting) {");
        _builder.newLine();
        _builder.append("//\t\tif (!Character.isUpperCase(greeting.name.charAt(0))) {");
        _builder.newLine();
        _builder.append("//\t\t\twarning(\'Name should start with a capital\', ");
        _builder.newLine();
        _builder.append("//\t\t\t\t\t");
        String _simpleName_1 = GrammarUtil.getSimpleName(ValidatorFragment2.this.getGrammar());
        _builder.append(_simpleName_1);
        _builder.append("Package.Literals.GREETING__NAME,");
        _builder.newLineIfNotEmpty();
        _builder.append("//\t\t\t\t\tINVALID_NAME)");
        _builder.newLine();
        _builder.append("//\t\t}");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createXtendFile(_validatorClass, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
  }

  protected void generateJavaValidatorStub() {
    TypeReference _validatorClass = this._validatorNaming.getValidatorClass(this.getGrammar());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* This class contains custom validation rules. ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = ValidatorFragment2.this._validatorNaming.getValidatorClass(ValidatorFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _abstractValidatorClass = ValidatorFragment2.this._validatorNaming.getAbstractValidatorClass(ValidatorFragment2.this.getGrammar());
        _builder.append(_abstractValidatorClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("//\tpublic static final String INVALID_NAME = \"invalidName\";");
        _builder.newLine();
        _builder.append("//");
        _builder.newLine();
        _builder.append("//\t@Check");
        _builder.newLine();
        _builder.append("//\tpublic void checkGreetingStartsWithCapital(Greeting greeting) {");
        _builder.newLine();
        _builder.append("//\t\tif (!Character.isUpperCase(greeting.getName().charAt(0))) {");
        _builder.newLine();
        _builder.append("//\t\t\twarning(\"Name should start with a capital\",");
        _builder.newLine();
        _builder.append("//\t\t\t\t\t");
        String _simpleName_1 = GrammarUtil.getSimpleName(ValidatorFragment2.this.getGrammar());
        _builder.append(_simpleName_1);
        _builder.append("Package.Literals.GREETING__NAME,");
        _builder.newLineIfNotEmpty();
        _builder.append("//\t\t\t\t\tINVALID_NAME);");
        _builder.newLine();
        _builder.append("//\t\t}");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createJavaFile(_validatorClass, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
  }

  protected GeneratedJavaFileAccess generateGenValidator() {
    TypeReference _xifexpression = null;
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      _xifexpression = this._validatorNaming.getAbstractValidatorClass(this.getGrammar());
    } else {
      _xifexpression = this._validatorNaming.getValidatorClass(this.getGrammar());
    }
    final TypeReference genClass = _xifexpression;
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(genClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          boolean _isEmpty = ValidatorFragment2.this.composedChecks.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("@");
            _builder.append(ComposedChecks.class);
            _builder.append("(validators = {");
            {
              boolean _hasElements = false;
              for(final String validator : ValidatorFragment2.this.composedChecks) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                TypeReference _typeRef = TypeReference.typeRef(validator);
                _builder.append(_typeRef);
                _builder.append(".class");
              }
            }
            _builder.append("})");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("public ");
        {
          boolean _isGenerateStub = ValidatorFragment2.this.isGenerateStub();
          if (_isGenerateStub) {
            _builder.append("abstract ");
          }
        }
        _builder.append("class ");
        String _simpleName = genClass.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _genValidatorSuperClass = ValidatorFragment2.this.getGenValidatorSuperClass(ValidatorFragment2.this.getGrammar());
        _builder.append(_genValidatorSuperClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(List.class, "\t");
        _builder.append("<");
        _builder.append(EPackage.class, "\t");
        _builder.append("> getEPackages() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append(List.class, "\t\t");
        _builder.append("<");
        _builder.append(EPackage.class, "\t\t");
        _builder.append("> result = new ");
        _builder.append(ArrayList.class, "\t\t");
        _builder.append("<");
        _builder.append(EPackage.class, "\t\t");
        _builder.append(">(");
        {
          if ((ValidatorFragment2.this.isInheritImplementation() && (GrammarUtil2.getNonTerminalsSuperGrammar(ValidatorFragment2.this.getGrammar()) != null))) {
            _builder.append("super.getEPackages()");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        {
          Iterable<EPackage> _generatedPackagesToValidate = ValidatorFragment2.this.getGeneratedPackagesToValidate();
          for(final EPackage e : _generatedPackagesToValidate) {
            _builder.append("\t\t");
            _builder.append("result.add(");
            String _generatedEPackageName = ValidatorFragment2.this.getGeneratedEPackageName(e);
            _builder.append(_generatedEPackageName, "\t\t");
            _builder.append(".eINSTANCE);");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          Collection<EPackage> _registryPackagesToValidate = ValidatorFragment2.this.getRegistryPackagesToValidate();
          for(final EPackage e_1 : _registryPackagesToValidate) {
            _builder.append("\t\t");
            _builder.append("result.add(EPackage.Registry.INSTANCE.getEPackage(\"");
            String _nsURI = e_1.getNsURI();
            _builder.append(_nsURI, "\t\t");
            _builder.append("\"));");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("return result;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        StringConcatenationClient _generateValidationToDeprecateRules = ValidatorFragment2.this.generateValidationToDeprecateRules();
        _builder.append(_generateValidationToDeprecateRules, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setContent(_client);
    return javaFile;
  }

  /**
   * @since 2.14
   */
  protected GeneratedJavaFileAccess generateIssueProvider() {
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(this.getConfigurableIssueCodesProviderClass());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          boolean _inheritsXbase = ValidatorFragment2.this._xbaseUsageDetector.inheritsXbase(ValidatorFragment2.this.getLanguage().getGrammar());
          if (_inheritsXbase) {
            _builder.append("@SuppressWarnings(\"restriction\")");
            _builder.newLine();
          }
        }
        _builder.append("public class ");
        TypeReference _configurableIssueCodesProviderClass = ValidatorFragment2.this.getConfigurableIssueCodesProviderClass();
        _builder.append(_configurableIssueCodesProviderClass);
        _builder.append(" extends ");
        TypeReference _superConfigurableIssueCodesProviderClass = ValidatorFragment2.this.getSuperConfigurableIssueCodesProviderClass();
        _builder.append(_superConfigurableIssueCodesProviderClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("protected static final String ISSUE_CODE_PREFIX = \"");
        String _runtimeBasePackage = ValidatorFragment2.this._xtextGeneratorNaming.getRuntimeBasePackage(ValidatorFragment2.this.getGrammar());
        _builder.append(_runtimeBasePackage, "\t");
        _builder.append(".\";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          if (ValidatorFragment2.this.generateDeprecationValidation) {
            _builder.append("\t");
            _builder.append("public static final String DEPRECATED_MODEL_PART = ISSUE_CODE_PREFIX + \"deprecatedModelPart\";");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void initialize(");
        _builder.append(IAcceptor.class, "\t");
        _builder.append("<");
        _builder.append(PreferenceKey.class, "\t");
        _builder.append("> acceptor) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super.initialize(acceptor);");
        _builder.newLine();
        {
          if (ValidatorFragment2.this.generateDeprecationValidation) {
            _builder.append("\t\t");
            _builder.append("acceptor.accept(create(DEPRECATED_MODEL_PART, ");
            _builder.append(SeverityConverter.class, "\t\t");
            _builder.append(".SEVERITY_WARNING));");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setContent(_client);
    return javaFile;
  }

  protected GeneratedJavaFileAccess generateValidationConfigurationBlock() {
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(this.getValidatorConfigurationBlockClass());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("@SuppressWarnings(\"restriction\")");
        _builder.newLine();
        _builder.append("public class ");
        TypeReference _validatorConfigurationBlockClass = ValidatorFragment2.this.getValidatorConfigurationBlockClass();
        _builder.append(_validatorConfigurationBlockClass);
        _builder.append(" extends ");
        TypeReference _xifexpression = null;
        boolean _inheritsXbase = ValidatorFragment2.this._xbaseUsageDetector.inheritsXbase(ValidatorFragment2.this.getLanguage().getGrammar());
        if (_inheritsXbase) {
          _xifexpression = ValidatorFragment2.this.getXbaseValidationConfigurationBlockClass();
        } else {
          _xifexpression = ValidatorFragment2.this.getAbstractValidatorConfigurationBlockClass();
        }
        _builder.append(_xifexpression);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected static final String SETTINGS_SECTION_NAME = \"");
        String _simpleName = GrammarUtil.getSimpleName(ValidatorFragment2.this.getGrammar());
        _builder.append(_simpleName, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void fillSettingsPage(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.swt.widgets.Composite");
        _builder.append(_typeRef, "\t");
        _builder.append(" composite, int nColumns, int defaultIndent) {");
        _builder.newLineIfNotEmpty();
        {
          if (ValidatorFragment2.this.generateDeprecationValidation) {
            _builder.append("\t\t");
            _builder.append("addComboBox(");
            TypeReference _configurableIssueCodesProviderClass = ValidatorFragment2.this.getConfigurableIssueCodesProviderClass();
            _builder.append(_configurableIssueCodesProviderClass, "\t\t");
            _builder.append(".DEPRECATED_MODEL_PART, \"Deprecated Model Part\", composite, defaultIndent);");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _inheritsXbase_1 = ValidatorFragment2.this._xbaseUsageDetector.inheritsXbase(ValidatorFragment2.this.getLanguage().getGrammar());
          if (_inheritsXbase_1) {
            _builder.append("\t\t");
            _builder.append("super.fillSettingsPage(composite, nColumns, defaultIndent);");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void dispose() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("storeSectionExpansionStates(getDialogSettings());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("super.dispose();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.jface.dialogs.IDialogSettings");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" getDialogSettings() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.jface.dialogs.IDialogSettings");
        _builder.append(_typeRef_2, "\t\t");
        _builder.append(" dialogSettings = super.getDialogSettings();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.jface.dialogs.IDialogSettings");
        _builder.append(_typeRef_3, "\t\t");
        _builder.append(" section = dialogSettings.getSection(SETTINGS_SECTION_NAME);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("if (section == null) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return section;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setContent(_client);
    return javaFile;
  }

  protected StringConcatenationClient generateValidationToDeprecateRules() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          if (ValidatorFragment2.this.generateDeprecationValidation) {
            {
              List<AbstractRule> _deprecatedRulesFromGrammar = ValidatorFragment2.this.getDeprecatedRulesFromGrammar();
              for(final AbstractRule deprecatedRule : _deprecatedRulesFromGrammar) {
                EClassifier _classifier = deprecatedRule.getType().getClassifier();
                ResourceSet _resourceSet = ValidatorFragment2.this.getGrammar().eResource().getResourceSet();
                final TypeReference elementType = new TypeReference(((EClass) _classifier), _resourceSet);
                _builder.newLineIfNotEmpty();
                _builder.newLine();
                _builder.append("@");
                _builder.append(Check.class);
                _builder.newLineIfNotEmpty();
                _builder.append("public void checkDeprecated");
                String _simpleName = elementType.getSimpleName();
                _builder.append(_simpleName);
                _builder.append("(");
                _builder.append(elementType);
                _builder.append(" element) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("addIssue(\"This part of the language is marked as deprecated and might get removed in the future!\", element, ");
                TypeReference _configurableIssueCodesProviderClass = ValidatorFragment2.this.getConfigurableIssueCodesProviderClass();
                _builder.append(_configurableIssueCodesProviderClass, "\t");
                _builder.append(".DEPRECATED_MODEL_PART);");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    };
    return _client;
  }

  protected Iterable<EPackage> getGeneratedPackagesToValidate() {
    final Function1<GeneratedMetamodel, EPackage> _function = (GeneratedMetamodel it) -> {
      return it.getEPackage();
    };
    return IterableExtensions.<GeneratedMetamodel, EPackage>map(Iterables.<GeneratedMetamodel>filter(this.getGrammar().getMetamodelDeclarations(), GeneratedMetamodel.class), _function);
  }

  protected Collection<EPackage> getRegistryPackagesToValidate() {
    final Collection<EPackage> packages = GrammarUtil.allEPackagesToValidate(this.getGrammar());
    final Function1<GeneratedMetamodel, EPackage> _function = (GeneratedMetamodel it) -> {
      return it.getEPackage();
    };
    packages.removeAll(IterableExtensions.<EPackage>toList(IterableExtensions.<GeneratedMetamodel, EPackage>map(Iterables.<GeneratedMetamodel>filter(GrammarUtil.allMetamodelDeclarations(this.getGrammar()), GeneratedMetamodel.class), _function)));
    return packages;
  }

  protected String getGeneratedEPackageName(final EPackage pack) {
    StringConcatenation _builder = new StringConcatenation();
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
    _builder.append(_runtimeBasePackage);
    _builder.append(".");
    String _name = pack.getName();
    _builder.append(_name);
    _builder.append(".");
    String _firstUpper = StringExtensions.toFirstUpper(pack.getName());
    _builder.append(_firstUpper);
    _builder.append("Package");
    return _builder.toString();
  }

  protected boolean contributeEclipsePluginExtensions() {
    boolean _xblockexpression = false;
    {
      final String simpleName = GrammarUtil.getSimpleName(this.getGrammar());
      List<CharSequence> _entries = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- marker definitions for ");
      String _name = this.getGrammar().getName();
      _builder.append(_name);
      _builder.append(" -->");
      _builder.newLineIfNotEmpty();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("id=\"");
      String _lowerCase = simpleName.toLowerCase();
      _builder.append(_lowerCase, "\t\t");
      _builder.append(".check.fast\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("name=\"");
      _builder.append(simpleName, "\t\t");
      _builder.append(" Problem\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("point=\"org.eclipse.core.resources.markers\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<super type=\"org.eclipse.xtext.ui.check.fast\"/>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<persistent value=\"true\"/>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("id=\"");
      String _lowerCase_1 = simpleName.toLowerCase();
      _builder.append(_lowerCase_1, "\t\t");
      _builder.append(".check.normal\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("name=\"");
      _builder.append(simpleName, "\t\t");
      _builder.append(" Problem\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("point=\"org.eclipse.core.resources.markers\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<super type=\"org.eclipse.xtext.ui.check.normal\"/>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<persistent value=\"true\"/>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("id=\"");
      String _lowerCase_2 = simpleName.toLowerCase();
      _builder.append(_lowerCase_2, "\t\t");
      _builder.append(".check.expensive\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("name=\"");
      _builder.append(simpleName, "\t\t");
      _builder.append(" Problem\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("point=\"org.eclipse.core.resources.markers\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<super type=\"org.eclipse.xtext.ui.check.expensive\"/>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<persistent value=\"true\"/>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      {
        if ((this.generateDeprecationValidation || this.generatePropertyPage)) {
          _builder.append("<extension point=\"org.eclipse.ui.preferencePages\">");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("<page");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("category=\"");
          String _name_1 = this.getGrammar().getName();
          _builder.append(_name_1, "\t\t");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("class=\"");
          TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
          _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
          _builder.append(":org.eclipse.xtext.ui.validation.ValidatorPreferencePage\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("id=\"");
          String _name_2 = this.getGrammar().getName();
          _builder.append(_name_2, "\t\t");
          _builder.append(".validator.preferencePage\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("name=\"Errors/Warnings\">");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("<keywordReference id=\"");
          String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(this.getGrammar());
          _builder.append(_eclipsePluginBasePackage, "\t\t");
          _builder.append(".keyword_");
          _builder.append(simpleName, "\t\t");
          _builder.append("\"/>");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("</page>");
          _builder.newLine();
          _builder.append("</extension>");
          _builder.newLine();
        }
      }
      _xblockexpression = _entries.add(_builder.toString());
    }
    return _xblockexpression;
  }

  /**
   * @since 2.14
   */
  protected List<AbstractRule> getDeprecatedRulesFromGrammar() {
    final HashSet<EClassifier> alreadyCollected = CollectionLiterals.<EClassifier>newHashSet();
    final Function1<AbstractRule, Boolean> _function = (AbstractRule it) -> {
      return Boolean.valueOf((this.isDeprecated(it) && alreadyCollected.add(it.getType().getClassifier())));
    };
    return IterableExtensions.<AbstractRule>toList(IterableExtensions.<AbstractRule>filter(this.getGrammar().getRules(), _function));
  }

  /**
   * @since 2.14
   */
  protected boolean isDeprecated(final AbstractRule rule) {
    final Function1<Annotation, Boolean> _function = (Annotation it) -> {
      return Boolean.valueOf(AnnotationNames.DEPRECATED.equals(it.getName()));
    };
    return IterableExtensions.<Annotation>exists(rule.getAnnotations(), _function);
  }

  @Pure
  public boolean isGenerateDeprecationValidation() {
    return this.generateDeprecationValidation;
  }

  public void setGenerateDeprecationValidation(final boolean generateDeprecationValidation) {
    this.generateDeprecationValidation = generateDeprecationValidation;
  }

  @Pure
  public boolean isGeneratePropertyPage() {
    return this.generatePropertyPage;
  }

  public void setGeneratePropertyPage(final boolean generatePropertyPage) {
    this.generatePropertyPage = generatePropertyPage;
  }
}
