/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.validation;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
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
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
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
import org.eclipse.xtext.xtext.generator.validation.ValidatorNaming;

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
  
  @Accessors
  private boolean generateDeprecationValidation = true;
  
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
  
  @Override
  public void generate() {
    new GuiceModuleAccess.BindingFactory().addTypeToTypeEagerSingleton(this._validatorNaming.getValidatorClass(this.getGrammar()), 
      this._validatorNaming.getValidatorClass(this.getGrammar())).contributeTo(this.getLanguage().getRuntimeGenModule());
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        this.generateXtendValidatorStub();
      } else {
        this.generateJavaValidatorStub();
      }
    }
    this.generateGenValidator();
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
        _builder.append("//\tpublic static final INVALID_NAME = \'invalidName\'");
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
  
  protected void generateGenValidator() {
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
    javaFile.writeTo(this.getProjectConfig().getRuntime().getSrcGen());
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
                _builder.append("warning(\"This part of the language is marked as deprecated and might get removed in the future!\", element, null);");
                _builder.newLine();
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
      _xblockexpression = _entries.add(_builder.toString());
    }
    return _xblockexpression;
  }
  
  /**
   * @since 2.14
   */
  protected List<AbstractRule> getDeprecatedRulesFromGrammar() {
    List<AbstractRule> _xblockexpression = null;
    {
      final HashSet<EClassifier> alreadyCollected = CollectionLiterals.<EClassifier>newHashSet();
      final Function1<AbstractRule, Boolean> _function = (AbstractRule it) -> {
        return Boolean.valueOf((this.isDeprecated(it) && alreadyCollected.add(it.getType().getClassifier())));
      };
      _xblockexpression = IterableExtensions.<AbstractRule>toList(IterableExtensions.<AbstractRule>filter(this.getGrammar().getRules(), _function));
    }
    return _xblockexpression;
  }
  
  /**
   * @since 2.14
   */
  protected boolean isDeprecated(final AbstractRule rule) {
    final Predicate<Annotation> _function = (Annotation e) -> {
      return AnnotationNames.DEPRECATED.equals(e.getName());
    };
    return rule.getAnnotations().stream().anyMatch(_function);
  }
  
  @Pure
  public boolean isGenerateDeprecationValidation() {
    return this.generateDeprecationValidation;
  }
  
  public void setGenerateDeprecationValidation(final boolean generateDeprecationValidation) {
    this.generateDeprecationValidation = generateDeprecationValidation;
  }
}
