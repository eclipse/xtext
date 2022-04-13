/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.validation;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IInheriting;
import org.eclipse.xtext.generator.IStubGenerating;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Generates an Xtend-based model validator.
 * 
 * @author Jan Koehnlein
 * @since 2.4
 */
@Deprecated
@SuppressWarnings("all")
public class ValidatorFragment extends Xtend2GeneratorFragment implements IInheriting, IStubGenerating {
  @Inject
  @Extension
  private Naming _naming;

  @Inject
  @Extension
  private ValidatorNaming _validatorNaming;

  @Accessors
  private boolean inheritImplementation = true;

  @Accessors
  private boolean generateStub = true;

  @Inject
  private Grammar grammar;

  private final ArrayList<String> composedChecks = CollectionLiterals.<String>newArrayList();

  public boolean addComposedCheck(final String composedCheckValidator) {
    return this.composedChecks.add(composedCheckValidator);
  }

  @Override
  public Set<Binding> getGuiceBindingsRt(final Grammar grammar) {
    Set<Binding> _xblockexpression = null;
    {
      final BindFactory bindFactory = new BindFactory();
      if (this.generateStub) {
        bindFactory.addTypeToTypeEagerSingleton(
          this._validatorNaming.getValidatorName(grammar), 
          this._validatorNaming.getValidatorName(grammar));
      } else {
        bindFactory.addTypeToTypeEagerSingleton(
          this._validatorNaming.getAbstractValidatorName(), 
          this._validatorNaming.getAbstractValidatorName());
      }
      _xblockexpression = bindFactory.getBindings();
    }
    return _xblockexpression;
  }

  @Override
  public void generate(final Xtend2ExecutionContext ctx) {
    String _asPath = this._naming.asPath(this._validatorNaming.getAbstractValidatorName());
    String _plus = (_asPath + ".java");
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = this._naming.fileHeader();
    _builder.append(_fileHeader);
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _packageName = this._naming.packageName(this._validatorNaming.getAbstractValidatorName());
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _annotationImports = this._naming.annotationImports();
    _builder.append(_annotationImports);
    _builder.newLineIfNotEmpty();
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
            _builder.append(validator);
            _builder.append(".class");
          }
        }
        _builder.append("})");
        _builder.newLineIfNotEmpty();
      }
    }
    String _classAnnotations = this._naming.classAnnotations();
    _builder.append(_classAnnotations);
    _builder.append("public class ");
    String _simpleName = this._naming.toSimpleName(this._validatorNaming.getAbstractValidatorName());
    _builder.append(_simpleName);
    _builder.append(" extends ");
    String _validatorSuperClassName = this._validatorNaming.getValidatorSuperClassName(this.isInheritImplementation());
    _builder.append(_validatorSuperClassName);
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
    _builder.append("List<EPackage> result = new ArrayList<EPackage>(");
    {
      if ((this.isInheritImplementation() && (IInheriting.Util.getNonTerminalsSuperGrammar(this.grammar) != null))) {
        _builder.append("super.getEPackages()");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
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
    if (this.generateStub) {
      String _asPath_1 = this._naming.asPath(this._validatorNaming.getValidatorName(this.grammar));
      String _plus_1 = (_asPath_1 + ".xtend");
      StringConcatenation _builder_1 = new StringConcatenation();
      String _fileHeader_1 = this._naming.fileHeader();
      _builder_1.append(_fileHeader_1);
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("package ");
      String _packageName_1 = this._naming.packageName(this._validatorNaming.getValidatorName(this.grammar));
      _builder_1.append(_packageName_1);
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      _builder_1.append("//import org.eclipse.xtext.validation.Check");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("/**");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* This class contains custom validation rules. ");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("class ");
      String _simpleName_1 = this._naming.toSimpleName(this._validatorNaming.getValidatorName(this.grammar));
      _builder_1.append(_simpleName_1);
      _builder_1.append(" extends ");
      String _simpleName_2 = this._naming.toSimpleName(this._validatorNaming.getAbstractValidatorName());
      _builder_1.append(_simpleName_2);
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
    final Function1<GeneratedMetamodel, EPackage> _function = (GeneratedMetamodel it) -> {
      return it.getEPackage();
    };
    return IterableExtensions.<GeneratedMetamodel, EPackage>map(Iterables.<GeneratedMetamodel>filter(this.grammar.getMetamodelDeclarations(), GeneratedMetamodel.class), _function);
  }

  protected Collection<EPackage> getRegistryPackagesToValidate() {
    Collection<EPackage> _xblockexpression = null;
    {
      final Collection<EPackage> packages = GrammarUtil.allEPackagesToValidate(this.grammar);
      final Function1<GeneratedMetamodel, EPackage> _function = (GeneratedMetamodel it) -> {
        return it.getEPackage();
      };
      packages.removeAll(
        IterableExtensions.<EPackage>toList(IterableExtensions.<GeneratedMetamodel, EPackage>map(Iterables.<GeneratedMetamodel>filter(GrammarUtil.allMetamodelDeclarations(this.grammar), GeneratedMetamodel.class), _function)));
      _xblockexpression = packages;
    }
    return _xblockexpression;
  }

  @Override
  public List<String> getExportedPackagesRtList(final Grammar grammar) {
    return CollectionLiterals.<String>newArrayList(this._naming.packageName(this._validatorNaming.getValidatorName(grammar)));
  }

  @Override
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
    String _lowerCase = this._naming.toSimpleName(this.grammar.getName()).toLowerCase();
    _builder.append(_lowerCase, "\t        ");
    _builder.append(".check.fast\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("name=\"");
    String _simpleName = this._naming.toSimpleName(this.grammar.getName());
    _builder.append(_simpleName, "\t        ");
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
    String _lowerCase_1 = this._naming.toSimpleName(this.grammar.getName()).toLowerCase();
    _builder.append(_lowerCase_1, "\t        ");
    _builder.append(".check.normal\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("name=\"");
    String _simpleName_1 = this._naming.toSimpleName(this.grammar.getName());
    _builder.append(_simpleName_1, "\t        ");
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
    String _lowerCase_2 = this._naming.toSimpleName(this.grammar.getName()).toLowerCase();
    _builder.append(_lowerCase_2, "\t        ");
    _builder.append(".check.expensive\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("name=\"");
    String _simpleName_2 = this._naming.toSimpleName(this.grammar.getName());
    _builder.append(_simpleName_2, "\t        ");
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

  @Pure
  @Override
  public boolean isInheritImplementation() {
    return this.inheritImplementation;
  }

  public void setInheritImplementation(final boolean inheritImplementation) {
    this.inheritImplementation = inheritImplementation;
  }

  @Pure
  @Override
  public boolean isGenerateStub() {
    return this.generateStub;
  }

  public void setGenerateStub(final boolean generateStub) {
    this.generateStub = generateStub;
  }
}
