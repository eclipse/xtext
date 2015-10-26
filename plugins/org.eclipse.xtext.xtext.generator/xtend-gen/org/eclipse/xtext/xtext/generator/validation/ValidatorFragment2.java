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
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.AbstractInheritingFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
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
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
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
  
  @Inject
  private CodeConfig codeConfig;
  
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
      boolean _and = false;
      boolean _isInheritImplementation = this.isInheritImplementation();
      if (!_isInheritImplementation) {
        _and = false;
      } else {
        _and = (superGrammar != null);
      }
      if (_and) {
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
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    Grammar _grammar = this.getGrammar();
    TypeReference _validatorClass = this._validatorNaming.getValidatorClass(_grammar);
    Grammar _grammar_1 = this.getGrammar();
    TypeReference _validatorClass_1 = this._validatorNaming.getValidatorClass(_grammar_1);
    GuiceModuleAccess.BindingFactory _addTypeToTypeEagerSingleton = _bindingFactory.addTypeToTypeEagerSingleton(_validatorClass, _validatorClass_1);
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    _addTypeToTypeEagerSingleton.contributeTo(_runtimeGenModule);
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
      if (_isPreferXtendStubs) {
        this.generateXtendValidatorStub();
      } else {
        this.generateJavaValidatorStub();
      }
    }
    this.generateGenValidator();
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    ManifestAccess _manifest = _runtime.getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
      ManifestAccess _manifest_1 = _runtime_1.getManifest();
      Set<String> _exportedPackages = _manifest_1.getExportedPackages();
      Grammar _grammar_2 = this.getGrammar();
      TypeReference _validatorClass_2 = this._validatorNaming.getValidatorClass(_grammar_2);
      String _packageName = _validatorClass_2.getPackageName();
      _exportedPackages.add(_packageName);
    }
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig_2.getEclipsePlugin();
    PluginXmlAccess _pluginXml = _eclipsePlugin.getPluginXml();
    boolean _tripleNotEquals_1 = (_pluginXml != null);
    if (_tripleNotEquals_1) {
      this.contributeEclipsePluginExtensions();
    }
  }
  
  protected void generateXtendValidatorStub() {
    Grammar _grammar = this.getGrammar();
    TypeReference _validatorClass = this._validatorNaming.getValidatorClass(_grammar);
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
        Grammar _grammar = ValidatorFragment2.this.getGrammar();
        TypeReference _validatorClass = ValidatorFragment2.this._validatorNaming.getValidatorClass(_grammar);
        String _simpleName = _validatorClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = ValidatorFragment2.this.getGrammar();
        TypeReference _abstractValidatorClass = ValidatorFragment2.this._validatorNaming.getAbstractValidatorClass(_grammar_1);
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
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
    _createXtendFile.writeTo(_src);
  }
  
  protected void generateJavaValidatorStub() {
    Grammar _grammar = this.getGrammar();
    TypeReference _validatorClass = this._validatorNaming.getValidatorClass(_grammar);
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
        Grammar _grammar = ValidatorFragment2.this.getGrammar();
        TypeReference _validatorClass = ValidatorFragment2.this._validatorNaming.getValidatorClass(_grammar);
        String _simpleName = _validatorClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = ValidatorFragment2.this.getGrammar();
        TypeReference _abstractValidatorClass = ValidatorFragment2.this._validatorNaming.getAbstractValidatorClass(_grammar_1);
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
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
    _createJavaFile.writeTo(_src);
  }
  
  protected void generateGenValidator() {
    TypeReference _xifexpression = null;
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      Grammar _grammar = this.getGrammar();
      _xifexpression = this._validatorNaming.getAbstractValidatorClass(_grammar);
    } else {
      Grammar _grammar_1 = this.getGrammar();
      _xifexpression = this._validatorNaming.getValidatorClass(_grammar_1);
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
                TypeReference _typeRef = TypeReference.typeRef(validator);
                _builder.append(_typeRef, "");
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
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar = ValidatorFragment2.this.getGrammar();
        TypeReference _genValidatorSuperClass = ValidatorFragment2.this.getGenValidatorSuperClass(_grammar);
        _builder.append(_genValidatorSuperClass, "");
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
          boolean _isInheritImplementation = ValidatorFragment2.this.isInheritImplementation();
          if (!_isInheritImplementation) {
            _and = false;
          } else {
            Grammar _grammar_1 = ValidatorFragment2.this.getGrammar();
            Grammar _nonTerminalsSuperGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(_grammar_1);
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
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
    javaFile.writeTo(_srcGen);
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
      IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
      PluginXmlAccess _pluginXml = _eclipsePlugin.getPluginXml();
      List<CharSequence> _entries = _pluginXml.getEntries();
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
}
