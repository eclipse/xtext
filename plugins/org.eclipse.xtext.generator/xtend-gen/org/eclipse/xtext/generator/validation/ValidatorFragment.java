/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.validation;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IInheriting;
import org.eclipse.xtext.generator.IStubGenerating;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.generator.validation.ValidatorNaming;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Generates an Xtend-based model validator.
 * 
 * @author Jan Koehnlein
 * @since 2.4
 */
@SuppressWarnings("all")
public class ValidatorFragment extends Xtend2GeneratorFragment implements IInheriting, IStubGenerating {
  @Inject
  @Extension
  private ValidatorNaming _validatorNaming;
  
  private boolean _inheritImplementation = true;
  
  public boolean isInheritImplementation() {
    return this._inheritImplementation;
  }
  
  public void setInheritImplementation(final boolean inheritImplementation) {
    this._inheritImplementation = inheritImplementation;
  }
  
  private boolean _generateStub = true;
  
  public boolean isGenerateStub() {
    return this._generateStub;
  }
  
  public void setGenerateStub(final boolean generateStub) {
    this._generateStub = generateStub;
  }
  
  @Inject
  private Grammar grammar;
  
  @Inject
  @Named("fileHeader")
  private String fileHeader;
  
  private final ArrayList<String> composedChecks = CollectionLiterals.<String>newArrayList();
  
  public boolean addComposedCheck(final String composedCheckValidator) {
    return this.composedChecks.add(composedCheckValidator);
  }
  
  public Set<Binding> getGuiceBindingsRt(final Grammar grammar) {
    Set<Binding> _xblockexpression = null;
    {
      final BindFactory bindFactory = new BindFactory();
      boolean _isGenerateStub = this.isGenerateStub();
      if (_isGenerateStub) {
        String _validatorName = this._validatorNaming.getValidatorName(grammar);
        String _validatorName_1 = this._validatorNaming.getValidatorName(grammar);
        bindFactory.addTypeToTypeEagerSingleton(_validatorName, _validatorName_1);
      } else {
        String _abstractValidatorName = this._validatorNaming.getAbstractValidatorName();
        String _abstractValidatorName_1 = this._validatorNaming.getAbstractValidatorName();
        bindFactory.addTypeToTypeEagerSingleton(_abstractValidatorName, _abstractValidatorName_1);
      }
      _xblockexpression = bindFactory.getBindings();
    }
    return _xblockexpression;
  }
  
  public void generate(final Xtend2ExecutionContext ctx) {
    String _abstractValidatorName = this._validatorNaming.getAbstractValidatorName();
    String _asPath = this._validatorNaming.asPath(_abstractValidatorName);
    String _plus = (_asPath + ".java");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append(this.fileHeader, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("package ");
    String _abstractValidatorName_1 = this._validatorNaming.getAbstractValidatorName();
    String _packageName = this._validatorNaming.packageName(_abstractValidatorName_1);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EPackage;");
    _builder.newLine();
    {
      boolean _isEmpty = this.composedChecks.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("import org.eclipse.xtext.validation.ComposedChecks;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      boolean _isEmpty_1 = this.composedChecks.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        _builder.append("@ComposedChecks(validators= {");
        {
          boolean _hasElements = false;
          for(final String validator : this.composedChecks) {
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
    _builder.append("public class ");
    String _abstractValidatorName_2 = this._validatorNaming.getAbstractValidatorName();
    String _simpleName = this._validatorNaming.toSimpleName(_abstractValidatorName_2);
    _builder.append(_simpleName, "");
    _builder.append(" extends ");
    boolean _isInheritImplementation = this.isInheritImplementation();
    String _validatorSuperClassName = this._validatorNaming.getValidatorSuperClassName(_isInheritImplementation);
    _builder.append(_validatorSuperClassName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected List<EPackage> getEPackages() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("List<EPackage> result = new ArrayList<EPackage>();");
    _builder.newLine();
    {
      Iterable<EPackage> _generatedPackagesToValidate = this.getGeneratedPackagesToValidate();
      for(final EPackage e : _generatedPackagesToValidate) {
        _builder.append("\t    ");
        _builder.append("result.add(");
        String _generatedEPackageName = this._validatorNaming.getGeneratedEPackageName(e);
        _builder.append(_generatedEPackageName, "\t    ");
        _builder.append(".eINSTANCE);");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Collection<EPackage> _registryPackagesToValidate = this.getRegistryPackagesToValidate();
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
    _builder.append("}");
    _builder.newLine();
    ctx.writeFile(Generator.SRC_GEN, _plus, _builder);
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      String _validatorName = this._validatorNaming.getValidatorName(this.grammar);
      String _asPath_1 = this._validatorNaming.asPath(_validatorName);
      String _plus_1 = (_asPath_1 + ".xtend");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("/*");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append(this.fileHeader, " ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("package ");
      String _validatorName_1 = this._validatorNaming.getValidatorName(this.grammar);
      String _packageName_1 = this._validatorNaming.packageName(_validatorName_1);
      _builder_1.append(_packageName_1, "");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("//import org.eclipse.xtext.validation.Check");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("/**");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* Custom validation rules. ");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* see http://www.eclipse.org/Xtext/documentation.html#validation");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("class ");
      String _validatorName_2 = this._validatorNaming.getValidatorName(this.grammar);
      String _simpleName_1 = this._validatorNaming.toSimpleName(_validatorName_2);
      _builder_1.append(_simpleName_1, "");
      _builder_1.append(" extends ");
      String _abstractValidatorName_3 = this._validatorNaming.getAbstractValidatorName();
      String _simpleName_2 = this._validatorNaming.toSimpleName(_abstractValidatorName_3);
      _builder_1.append(_simpleName_2, "");
      _builder_1.append(" {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      _builder_1.append("//  public static val INVALID_NAME = \'invalidName\'");
      _builder_1.newLine();
      _builder_1.append("//");
      _builder_1.newLine();
      _builder_1.append("//\t@Check");
      _builder_1.newLine();
      _builder_1.append("//\tdef checkGreetingStartsWithCapital(Greeting greeting) {");
      _builder_1.newLine();
      _builder_1.append("//\t\tif (!Character.isUpperCase(greeting.name.charAt(0))) {");
      _builder_1.newLine();
      _builder_1.append("//\t\t\twarning(\'Name should start with a capital\', ");
      _builder_1.newLine();
      _builder_1.append("//\t\t\t\t\tMyDslPackage.Literals.GREETING__NAME,");
      _builder_1.newLine();
      _builder_1.append("//\t\t\t\t\tINVALID_NAME)");
      _builder_1.newLine();
      _builder_1.append("//\t\t}");
      _builder_1.newLine();
      _builder_1.append("//\t}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      ctx.writeFile(Generator.SRC, _plus_1, _builder_1);
    }
  }
  
  public Iterable<EPackage> getGeneratedPackagesToValidate() {
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations = this.grammar.getMetamodelDeclarations();
    Iterable<GeneratedMetamodel> _filter = Iterables.<GeneratedMetamodel>filter(_metamodelDeclarations, GeneratedMetamodel.class);
    final Function1<GeneratedMetamodel, EPackage> _function = new Function1<GeneratedMetamodel, EPackage>() {
      public EPackage apply(final GeneratedMetamodel it) {
        return it.getEPackage();
      }
    };
    return IterableExtensions.<GeneratedMetamodel, EPackage>map(_filter, _function);
  }
  
  protected Collection<EPackage> getRegistryPackagesToValidate() {
    Collection<EPackage> _xblockexpression = null;
    {
      final Collection<EPackage> packages = GrammarUtil.allEPackagesToValidate(this.grammar);
      List<AbstractMetamodelDeclaration> _allMetamodelDeclarations = GrammarUtil.allMetamodelDeclarations(this.grammar);
      Iterable<GeneratedMetamodel> _filter = Iterables.<GeneratedMetamodel>filter(_allMetamodelDeclarations, GeneratedMetamodel.class);
      final Function1<GeneratedMetamodel, EPackage> _function = new Function1<GeneratedMetamodel, EPackage>() {
        public EPackage apply(final GeneratedMetamodel it) {
          return it.getEPackage();
        }
      };
      Iterable<EPackage> _map = IterableExtensions.<GeneratedMetamodel, EPackage>map(_filter, _function);
      List<EPackage> _list = IterableExtensions.<EPackage>toList(_map);
      packages.removeAll(_list);
      _xblockexpression = packages;
    }
    return _xblockexpression;
  }
  
  public List<String> getExportedPackagesRtList(final Grammar grammar) {
    String _validatorName = this._validatorNaming.getValidatorName(grammar);
    String _packageName = this._validatorNaming.packageName(_validatorName);
    return CollectionLiterals.<String>newArrayList(_packageName);
  }
  
  public void addToPluginXmlUi(final Xtend2ExecutionContext ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<!-- marker definitions for ");
    String _name = this.grammar.getName();
    _builder.append(_name, "\t");
    _builder.append(" -->");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("id=\"");
    String _name_1 = this.grammar.getName();
    String _simpleName = this._validatorNaming.toSimpleName(_name_1);
    String _lowerCase = _simpleName.toLowerCase();
    _builder.append(_lowerCase, "\t        ");
    _builder.append(".check.fast\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("name=\"");
    String _name_2 = this.grammar.getName();
    String _simpleName_1 = this._validatorNaming.toSimpleName(_name_2);
    _builder.append(_simpleName_1, "\t        ");
    _builder.append(" Problem\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("point=\"org.eclipse.core.resources.markers\">");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<super type=\"org.eclipse.xtext.ui.check.fast\"/>");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<persistent value=\"true\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("id=\"");
    String _name_3 = this.grammar.getName();
    String _simpleName_2 = this._validatorNaming.toSimpleName(_name_3);
    String _lowerCase_1 = _simpleName_2.toLowerCase();
    _builder.append(_lowerCase_1, "\t        ");
    _builder.append(".check.normal\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("name=\"");
    String _name_4 = this.grammar.getName();
    String _simpleName_3 = this._validatorNaming.toSimpleName(_name_4);
    _builder.append(_simpleName_3, "\t        ");
    _builder.append(" Problem\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("point=\"org.eclipse.core.resources.markers\">");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<super type=\"org.eclipse.xtext.ui.check.normal\"/>");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<persistent value=\"true\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("id=\"");
    String _name_5 = this.grammar.getName();
    String _simpleName_4 = this._validatorNaming.toSimpleName(_name_5);
    String _lowerCase_2 = _simpleName_4.toLowerCase();
    _builder.append(_lowerCase_2, "\t        ");
    _builder.append(".check.expensive\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("name=\"");
    String _name_6 = this.grammar.getName();
    String _simpleName_5 = this._validatorNaming.toSimpleName(_name_6);
    _builder.append(_simpleName_5, "\t        ");
    _builder.append(" Problem\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("point=\"org.eclipse.core.resources.markers\">");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<super type=\"org.eclipse.xtext.ui.check.expensive\"/>");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<persistent value=\"true\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</extension>");
    _builder.newLine();
    ctx.append(_builder);
  }
}
