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
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;

@SuppressWarnings("all")
public class ValidatorFragment2 extends AbstractGeneratorFragment2 {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Inject
  private CodeConfig codeConfig;
  
  @Accessors
  private boolean generateStub = true;
  
  @Accessors
  private boolean inheritImplementation = true;
  
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
  
  protected TypeReference getValidatorClass(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".validation.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "Validator");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getAbstractValidatorClass(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".validation.Abstract");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "Validator");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getValidatorSuperClass(final Grammar grammar) {
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
        _xifexpression = this.getValidatorClass(superGrammar);
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
    final GuiceModuleAccess.BindingFactory bindingFactory = new GuiceModuleAccess.BindingFactory();
    if (this.generateStub) {
      Grammar _grammar = this.getGrammar();
      TypeReference _validatorClass = this.getValidatorClass(_grammar);
      Grammar _grammar_1 = this.getGrammar();
      TypeReference _validatorClass_1 = this.getValidatorClass(_grammar_1);
      bindingFactory.addTypeToTypeEagerSingleton(_validatorClass, _validatorClass_1);
    } else {
      Grammar _grammar_2 = this.getGrammar();
      TypeReference _abstractValidatorClass = this.getAbstractValidatorClass(_grammar_2);
      Grammar _grammar_3 = this.getGrammar();
      TypeReference _abstractValidatorClass_1 = this.getAbstractValidatorClass(_grammar_3);
      bindingFactory.addTypeToTypeEagerSingleton(_abstractValidatorClass, _abstractValidatorClass_1);
    }
    ILanguageConfig _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    bindingFactory.contributeTo(_runtimeGenModule);
    if (this.generateStub) {
      boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
      if (_isPreferXtendStubs) {
        this.generateXtendValidatorStub();
      } else {
        this.generateJavaValidatorStub();
      }
    }
    this.generateAbstractValidator();
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    ManifestAccess _runtimeManifest = _projectConfig.getRuntimeManifest();
    boolean _tripleNotEquals = (_runtimeManifest != null);
    if (_tripleNotEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      ManifestAccess _runtimeManifest_1 = _projectConfig_1.getRuntimeManifest();
      Set<String> _exportedPackages = _runtimeManifest_1.getExportedPackages();
      Grammar _grammar_4 = this.getGrammar();
      TypeReference _validatorClass_2 = this.getValidatorClass(_grammar_4);
      String _packageName = _validatorClass_2.getPackageName();
      _exportedPackages.add(_packageName);
    }
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    PluginXmlAccess _eclipsePluginPluginXml = _projectConfig_2.getEclipsePluginPluginXml();
    boolean _tripleNotEquals_1 = (_eclipsePluginPluginXml != null);
    if (_tripleNotEquals_1) {
      this.contributeEclipsePluginExtensions();
    }
  }
  
  protected void generateXtendValidatorStub() {
    Grammar _grammar = this.getGrammar();
    TypeReference _validatorClass = this.getValidatorClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("//import org.eclipse.xtext.validation.Check");
        _builder.newLine();
        _builder.newLine();
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
        Grammar _grammar = ValidatorFragment2.this.getGrammar();
        TypeReference _validatorClass = ValidatorFragment2.this.getValidatorClass(_grammar);
        String _simpleName = _validatorClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = ValidatorFragment2.this.getGrammar();
        TypeReference _abstractValidatorClass = ValidatorFragment2.this.getAbstractValidatorClass(_grammar_1);
        _builder.append(_abstractValidatorClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("//  public static val INVALID_NAME = \'invalidName\'");
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
        _builder.append("//\t\t\t\t\tMyDslPackage.Literals.GREETING__NAME,");
        _builder.newLine();
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
    XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_validatorClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IXtextGeneratorFileSystemAccess _runtimeSrc = _projectConfig.getRuntimeSrc();
    _createXtendFile.writeTo(_runtimeSrc);
  }
  
  protected void generateJavaValidatorStub() {
    Grammar _grammar = this.getGrammar();
    TypeReference _validatorClass = this.getValidatorClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("//import org.eclipse.xtext.validation.Check;");
        _builder.newLine();
        _builder.newLine();
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
        Grammar _grammar = ValidatorFragment2.this.getGrammar();
        TypeReference _validatorClass = ValidatorFragment2.this.getValidatorClass(_grammar);
        String _simpleName = _validatorClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = ValidatorFragment2.this.getGrammar();
        TypeReference _abstractValidatorClass = ValidatorFragment2.this.getAbstractValidatorClass(_grammar_1);
        _builder.append(_abstractValidatorClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("//\t@Check");
        _builder.newLine();
        _builder.append("//\tpublic void checkGreetingStartsWithCapital(Greeting greeting) {");
        _builder.newLine();
        _builder.append("//\t\tif (!Character.isUpperCase(greeting.getName().charAt(0))) {");
        _builder.newLine();
        _builder.append("//\t\t\twarning(\"Name should start with a capital\", MyDslPackage.Literals.GREETING__NAME);");
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
    JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_validatorClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IXtextGeneratorFileSystemAccess _runtimeSrc = _projectConfig.getRuntimeSrc();
    _createJavaFile.writeTo(_runtimeSrc);
  }
  
  protected void generateAbstractValidator() {
    Grammar _grammar = this.getGrammar();
    TypeReference _abstractValidatorClass = this.getAbstractValidatorClass(_grammar);
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(_abstractValidatorClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          boolean _isEmpty = ValidatorFragment2.this.composedChecks.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("@");
            _builder.append(ComposedChecks.class, "");
            _builder.append("(validators = {");
            {
              boolean _hasElements = false;
              for(final String validator : ValidatorFragment2.this.composedChecks) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                _builder.append(validator, "");
                _builder.append(".class");
              }
            }
            _builder.append("})");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("public ");
        {
          if (ValidatorFragment2.this.generateStub) {
            _builder.append("abstract ");
          }
        }
        _builder.append("class ");
        Grammar _grammar = ValidatorFragment2.this.getGrammar();
        TypeReference _abstractValidatorClass = ValidatorFragment2.this.getAbstractValidatorClass(_grammar);
        String _simpleName = _abstractValidatorClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = ValidatorFragment2.this.getGrammar();
        TypeReference _validatorSuperClass = ValidatorFragment2.this.getValidatorSuperClass(_grammar_1);
        _builder.append(_validatorSuperClass, "");
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
        _builder.append("\t    ");
        _builder.append(List.class, "\t    ");
        _builder.append("<");
        _builder.append(EPackage.class, "\t    ");
        _builder.append("> result = new ");
        _builder.append(ArrayList.class, "\t    ");
        _builder.append("<");
        _builder.append(EPackage.class, "\t    ");
        _builder.append(">(");
        {
          boolean _and = false;
          if (!ValidatorFragment2.this.inheritImplementation) {
            _and = false;
          } else {
            Grammar _grammar_2 = ValidatorFragment2.this.getGrammar();
            Grammar _nonTerminalsSuperGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(_grammar_2);
            boolean _tripleNotEquals = (_nonTerminalsSuperGrammar != null);
            _and = _tripleNotEquals;
          }
          if (_and) {
            _builder.append("super.getEPackages()");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        {
          Iterable<EPackage> _generatedPackagesToValidate = ValidatorFragment2.this.getGeneratedPackagesToValidate();
          for(final EPackage e : _generatedPackagesToValidate) {
            _builder.append("\t    ");
            _builder.append("result.add(");
            String _generatedEPackageName = ValidatorFragment2.this.getGeneratedEPackageName(e);
            _builder.append(_generatedEPackageName, "\t    ");
            _builder.append(".eINSTANCE);");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          Collection<EPackage> _registryPackagesToValidate = ValidatorFragment2.this.getRegistryPackagesToValidate();
          for(final EPackage e_1 : _registryPackagesToValidate) {
            _builder.append("\t    ");
            _builder.append("result.add(EPackage.Registry.INSTANCE.getEPackage(\"");
            String _nsURI = e_1.getNsURI();
            _builder.append(_nsURI, "\t    ");
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
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setContent(_client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IXtextGeneratorFileSystemAccess _runtimeSrcGen = _projectConfig.getRuntimeSrcGen();
    javaFile.writeTo(_runtimeSrcGen);
  }
  
  protected Iterable<EPackage> getGeneratedPackagesToValidate() {
    Grammar _grammar = this.getGrammar();
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations = _grammar.getMetamodelDeclarations();
    Iterable<GeneratedMetamodel> _filter = Iterables.<GeneratedMetamodel>filter(_metamodelDeclarations, GeneratedMetamodel.class);
    final Function1<GeneratedMetamodel, EPackage> _function = new Function1<GeneratedMetamodel, EPackage>() {
      @Override
      public EPackage apply(final GeneratedMetamodel it) {
        return it.getEPackage();
      }
    };
    return IterableExtensions.<GeneratedMetamodel, EPackage>map(_filter, _function);
  }
  
  protected Collection<EPackage> getRegistryPackagesToValidate() {
    Grammar _grammar = this.getGrammar();
    final Collection<EPackage> packages = GrammarUtil.allEPackagesToValidate(_grammar);
    Grammar _grammar_1 = this.getGrammar();
    List<AbstractMetamodelDeclaration> _allMetamodelDeclarations = GrammarUtil.allMetamodelDeclarations(_grammar_1);
    Iterable<GeneratedMetamodel> _filter = Iterables.<GeneratedMetamodel>filter(_allMetamodelDeclarations, GeneratedMetamodel.class);
    final Function1<GeneratedMetamodel, EPackage> _function = new Function1<GeneratedMetamodel, EPackage>() {
      @Override
      public EPackage apply(final GeneratedMetamodel it) {
        return it.getEPackage();
      }
    };
    Iterable<EPackage> _map = IterableExtensions.<GeneratedMetamodel, EPackage>map(_filter, _function);
    List<EPackage> _list = IterableExtensions.<EPackage>toList(_map);
    packages.removeAll(_list);
    return packages;
  }
  
  protected String getGeneratedEPackageName(final EPackage pack) {
    StringConcatenation _builder = new StringConcatenation();
    Grammar _grammar = this.getGrammar();
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(_grammar);
    _builder.append(_runtimeBasePackage, "");
    _builder.append(".");
    String _name = pack.getName();
    _builder.append(_name, "");
    _builder.append(".");
    String _name_1 = pack.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append("Package");
    return _builder.toString();
  }
  
  protected boolean contributeEclipsePluginExtensions() {
    boolean _xblockexpression = false;
    {
      Grammar _grammar = this.getGrammar();
      final String simpleName = GrammarUtil.getSimpleName(_grammar);
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      PluginXmlAccess _eclipsePluginPluginXml = _projectConfig.getEclipsePluginPluginXml();
      List<CharSequence> _entries = _eclipsePluginPluginXml.getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- marker definitions for ");
      Grammar _grammar_1 = this.getGrammar();
      String _name = _grammar_1.getName();
      _builder.append(_name, "");
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
  
  @Pure
  public boolean isGenerateStub() {
    return this.generateStub;
  }
  
  public void setGenerateStub(final boolean generateStub) {
    this.generateStub = generateStub;
  }
  
  @Pure
  public boolean isInheritImplementation() {
    return this.inheritImplementation;
  }
  
  public void setInheritImplementation(final boolean inheritImplementation) {
    this.inheritImplementation = inheritImplementation;
  }
}
