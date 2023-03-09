/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.formatting;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;

@SuppressWarnings("all")
public class Formatter2Fragment2 extends AbstractStubGeneratingFragment {
  @Inject
  private FileAccessFactory fileAccessFactory;

  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;

  protected TypeReference getFormatter2Stub(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".formatting2.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "Formatter");
    return new TypeReference(_plus_2);
  }

  @Override
  public void generate() {
    boolean _isGenerateStub = this.isGenerateStub();
    boolean _not = (!_isGenerateStub);
    if (_not) {
      return;
    }
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IPreferenceValuesProvider.class);
        _builder.append(".class).annotatedWith(");
        _builder.append(FormatterPreferences.class);
        _builder.append(".class).to(");
        _builder.append(FormatterPreferenceValuesProvider.class);
        _builder.append(".class);");
      }
    };
    final StringConcatenationClient statement = _client;
    new GuiceModuleAccess.BindingFactory().addTypeToType(TypeReference.typeRef(IFormatter2.class), this.getFormatter2Stub(this.getLanguage().getGrammar())).addConfiguredBinding(FormatterPreferences.class.getSimpleName(), statement).contributeTo(this.getLanguage().getRuntimeGenModule());
    new GuiceModuleAccess.BindingFactory().addTypeToType(TypeReference.typeRef("org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory"), 
      TypeReference.typeRef("org.eclipse.xtext.ui.editor.formatting2.ContentFormatterFactory")).contributeTo(this.getLanguage().getEclipsePluginGenModule());
    ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Set<String> _exportedPackages = this.getProjectConfig().getRuntime().getManifest().getExportedPackages();
      String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
      String _plus = (_runtimeBasePackage + ".formatting2");
      _exportedPackages.add(_plus);
    }
    this.doGenerateStubFile();
  }

  protected void doGenerateStubFile() {
    final JavaFileAccess file = this.doGetStubFile();
    if (file!=null) {
      file.writeTo(this.getProjectConfig().getRuntime().getSrc());
    }
  }

  protected JavaFileAccess doGetStubFile() {
    boolean _isGenerateStub = this.isGenerateStub();
    boolean _not = (!_isGenerateStub);
    if (_not) {
      return null;
    }
    boolean _isGenerateXtendStub = this.isGenerateXtendStub();
    if (_isGenerateXtendStub) {
      final XtendFileAccess xtendFile = this.fileAccessFactory.createXtendFile(this.getFormatter2Stub(this.getGrammar()));
      xtendFile.setResourceSet(this.getLanguage().getResourceSet());
      final LinkedHashMultimap<EClass, EReference> type2ref = LinkedHashMultimap.<EClass, EReference>create();
      this.getLocallyAssignedContainmentReferences(this.getLanguage().getGrammar(), type2ref);
      final LinkedHashMultimap<EClass, EReference> inheritedTypes = LinkedHashMultimap.<EClass, EReference>create();
      this.getInheritedContainmentReferences(this.getLanguage().getGrammar(), inheritedTypes, CollectionLiterals.<Grammar>newHashSet());
      final Set<EClass> types = type2ref.keySet();
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("class ");
          String _simpleName = Formatter2Fragment2.this.getFormatter2Stub(Formatter2Fragment2.this.getGrammar()).getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" extends ");
          TypeReference _stubSuperClass = Formatter2Fragment2.this.getStubSuperClass();
          _builder.append(_stubSuperClass);
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@");
          _builder.append(Inject.class, "\t");
          _builder.append(" extension ");
          TypeReference _grammarAccess = Formatter2Fragment2.this._grammarAccessExtensions.getGrammarAccess(Formatter2Fragment2.this.getGrammar());
          _builder.append(_grammarAccess, "\t");
          _builder.newLineIfNotEmpty();
          {
            Iterable<EClass> _take = IterableExtensions.<EClass>take(types, 2);
            for(final EClass type : _take) {
              _builder.newLine();
              _builder.append("\t");
              StringConcatenationClient _generateFormatMethod = Formatter2Fragment2.this.generateFormatMethod(type, type2ref.get(type), inheritedTypes.containsKey(type));
              _builder.append(_generateFormatMethod, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.newLine();
          {
            int _length = ((Object[])Conversions.unwrapArray(types, Object.class)).length;
            boolean _greaterThan = (_length > 2);
            if (_greaterThan) {
              _builder.append("\t");
              _builder.append("// TODO: implement for ");
              final Function1<EClass, String> _function = (EClass it) -> {
                return it.getName();
              };
              String _join = IterableExtensions.join(IterableExtensions.<EClass, String>map(IterableExtensions.<EClass>drop(types, 2), _function), ", ");
              _builder.append(_join, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      };
      xtendFile.setContent(_client);
      return xtendFile;
    } else {
      final JavaFileAccess javaFile = this.fileAccessFactory.createJavaFile(this.getFormatter2Stub(this.getGrammar()));
      javaFile.setResourceSet(this.getLanguage().getResourceSet());
      final LinkedHashMultimap<EClass, EReference> type2ref_1 = LinkedHashMultimap.<EClass, EReference>create();
      this.getLocallyAssignedContainmentReferences(this.getLanguage().getGrammar(), type2ref_1);
      final LinkedHashMultimap<EClass, EReference> inheritedTypes_1 = LinkedHashMultimap.<EClass, EReference>create();
      this.getInheritedContainmentReferences(this.getLanguage().getGrammar(), inheritedTypes_1, CollectionLiterals.<Grammar>newHashSet());
      final Set<EClass> types_1 = type2ref_1.keySet();
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          String _simpleName = Formatter2Fragment2.this.getFormatter2Stub(Formatter2Fragment2.this.getGrammar()).getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" extends ");
          TypeReference _stubSuperClass = Formatter2Fragment2.this.getStubSuperClass();
          _builder.append(_stubSuperClass);
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          {
            Iterable<EClass> _take = IterableExtensions.<EClass>take(types_1, 2);
            for(final EClass type : _take) {
              _builder.newLine();
              _builder.append("\t");
              StringConcatenationClient _generateJavaFormatMethod = Formatter2Fragment2.this.generateJavaFormatMethod(type, type2ref_1.get(type), inheritedTypes_1.containsKey(type));
              _builder.append(_generateJavaFormatMethod, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.newLine();
          {
            int _length = ((Object[])Conversions.unwrapArray(types_1, Object.class)).length;
            boolean _greaterThan = (_length > 2);
            if (_greaterThan) {
              _builder.append("\t");
              _builder.append("// TODO: implement for ");
              final Function1<EClass, String> _function = (EClass it) -> {
                return it.getName();
              };
              String _join = IterableExtensions.join(IterableExtensions.<EClass, String>map(IterableExtensions.<EClass>drop(types_1, 2), _function), ", ");
              _builder.append(_join, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      };
      javaFile.setContent(_client_1);
      return javaFile;
    }
  }

  protected StringConcatenationClient generateFormatMethod(final EClass clazz, final Collection<EReference> containmentRefs, final boolean isOverriding) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          if (isOverriding) {
            _builder.append("override");
          } else {
            _builder.append("def");
          }
        }
        _builder.append(" dispatch void format(");
        _builder.append(clazz);
        _builder.append(" ");
        String _varName = Formatter2Fragment2.this.toVarName(clazz);
        _builder.append(_varName);
        _builder.append(", extension ");
        _builder.append(IFormattableDocument.class);
        _builder.append(" document) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("// TODO: format HiddenRegions around keywords, attributes, cross references, etc. ");
        _builder.newLine();
        {
          for(final EReference ref : containmentRefs) {
            {
              boolean _isMany = ref.isMany();
              if (_isMany) {
                _builder.append("\t");
                _builder.append("for (");
                String _varName_1 = Formatter2Fragment2.this.toVarName(ref, Formatter2Fragment2.this.toVarName(clazz), "document");
                _builder.append(_varName_1, "\t");
                _builder.append(" : ");
                String _varName_2 = Formatter2Fragment2.this.toVarName(clazz);
                _builder.append(_varName_2, "\t");
                _builder.append(".");
                String _getAccessor = Formatter2Fragment2.this.getGetAccessor(ref);
                _builder.append(_getAccessor, "\t");
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                String _varName_3 = Formatter2Fragment2.this.toVarName(ref, Formatter2Fragment2.this.toVarName(clazz), "document");
                _builder.append(_varName_3, "\t\t");
                _builder.append(".format");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("\t");
                String _varName_4 = Formatter2Fragment2.this.toVarName(clazz);
                _builder.append(_varName_4, "\t");
                _builder.append(".");
                String _getAccessor_1 = Formatter2Fragment2.this.getGetAccessor(ref);
                _builder.append(_getAccessor_1, "\t");
                _builder.append(".format");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }

  protected StringConcatenationClient generateJavaFormatMethod(final EClass clazz, final Collection<EReference> containmentRefs, final boolean isOverriding) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          if (isOverriding) {
            _builder.append("@Override ");
          }
        }
        _builder.append("protected void format(");
        _builder.append(clazz);
        _builder.append(" ");
        String _varName = Formatter2Fragment2.this.toVarName(clazz);
        _builder.append(_varName);
        _builder.append(", ");
        _builder.append(IFormattableDocument.class);
        _builder.append(" doc) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("// TODO: format HiddenRegions around keywords, attributes, cross references, etc. ");
        _builder.newLine();
        {
          for(final EReference ref : containmentRefs) {
            {
              boolean _isMany = ref.isMany();
              if (_isMany) {
                _builder.append("\t");
                _builder.append("for (");
                String _getAccessorType = Formatter2Fragment2.this.getGetAccessorType(ref);
                TypeReference _typeReference = new TypeReference(_getAccessorType);
                _builder.append(_typeReference, "\t");
                _builder.append(" ");
                String _varName_1 = Formatter2Fragment2.this.toVarName(ref, Formatter2Fragment2.this.toVarName(clazz), "doc");
                _builder.append(_varName_1, "\t");
                _builder.append(" : ");
                String _varName_2 = Formatter2Fragment2.this.toVarName(clazz);
                _builder.append(_varName_2, "\t");
                _builder.append(".get");
                String _firstUpper = StringExtensions.toFirstUpper(Formatter2Fragment2.this.getGetAccessor(ref));
                _builder.append(_firstUpper, "\t");
                _builder.append("()) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("doc.format(");
                String _varName_3 = Formatter2Fragment2.this.toVarName(ref, Formatter2Fragment2.this.toVarName(clazz), "doc");
                _builder.append(_varName_3, "\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append("doc.format(");
                String _varName_4 = Formatter2Fragment2.this.toVarName(clazz);
                _builder.append(_varName_4, "\t");
                _builder.append(".get");
                String _firstUpper_1 = StringExtensions.toFirstUpper(Formatter2Fragment2.this.getGetAccessor(ref));
                _builder.append(_firstUpper_1, "\t");
                _builder.append("());");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }

  protected void getLocallyAssignedContainmentReferences(final Grammar grammar, final Multimap<EClass, EReference> type2ref) {
    List<Assignment> _containedAssignments = GrammarUtil.containedAssignments(grammar);
    for (final Assignment assignment : _containedAssignments) {
      {
        final EClassifier type = GrammarUtil.findCurrentType(assignment);
        if ((type instanceof EClass)) {
          final EStructuralFeature feature = ((EClass)type).getEStructuralFeature(assignment.getFeature());
          if (((feature instanceof EReference) && ((EReference) feature).isContainment())) {
            type2ref.put(((EClass)type), ((EReference) feature));
          }
        }
      }
    }
    List<Action> _containedActions = GrammarUtil.containedActions(grammar);
    for (final Action action : _containedActions) {
      {
        final String featureName = action.getFeature();
        if ((featureName != null)) {
          final EClassifier type = action.getType().getClassifier();
          if ((type instanceof EClass)) {
            final EStructuralFeature feature = ((EClass)type).getEStructuralFeature(featureName);
            if (((feature instanceof EReference) && ((EReference) feature).isContainment())) {
              type2ref.put(((EClass)type), ((EReference) feature));
            }
          }
        }
      }
    }
  }

  protected void getInheritedContainmentReferences(final Grammar grammar, final Multimap<EClass, EReference> type2ref, final Set<Grammar> visitedGrammars) {
    visitedGrammars.add(grammar);
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    for (final Grammar usedGrammar : _usedGrammars) {
      boolean _contains = visitedGrammars.contains(usedGrammar);
      boolean _not = (!_contains);
      if (_not) {
        this.getLocallyAssignedContainmentReferences(usedGrammar, type2ref);
        this.getInheritedContainmentReferences(usedGrammar, type2ref, visitedGrammars);
      }
    }
  }

  protected TypeReference getStubSuperClass() {
    final Grammar superGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(this.getLanguage().getGrammar());
    if ((superGrammar != null)) {
      return this.getFormatter2Stub(superGrammar);
    } else {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        return TypeReference.typeRef(AbstractFormatter2.class);
      } else {
        return TypeReference.typeRef(AbstractJavaFormatter.class);
      }
    }
  }

  protected String toVarName(final ENamedElement element, final String... reservedNames) {
    String _xblockexpression = null;
    {
      if ((element instanceof EReference)) {
        return this.toVarName(((EReference)element).getEReferenceType(), reservedNames);
      }
      String name = StringExtensions.toFirstLower(element.getName());
      boolean _contains = XtendFileAccess.XTEND_KEYWORDS.contains(name);
      if (_contains) {
        name = ("_" + name);
      }
      boolean _contains_1 = ArrayExtensions.contains(reservedNames, name);
      if (_contains_1) {
        name = ("_" + name);
      }
      _xblockexpression = name;
    }
    return _xblockexpression;
  }

  protected String getGetAccessor(final EStructuralFeature feature) {
    return GenModelUtil2.getGenFeature(feature, this.getLanguage().getResourceSet()).getName();
  }

  protected String getGetAccessorType(final EStructuralFeature feature) {
    String _xifexpression = null;
    boolean _isMany = feature.isMany();
    if (_isMany) {
      _xifexpression = GenModelUtil2.getGenFeature(feature, this.getLanguage().getResourceSet()).getListItemType(null);
    } else {
      _xifexpression = GenModelUtil2.getGenFeature(feature, this.getLanguage().getResourceSet()).getImportedType(null);
    }
    return _xifexpression;
  }
}
