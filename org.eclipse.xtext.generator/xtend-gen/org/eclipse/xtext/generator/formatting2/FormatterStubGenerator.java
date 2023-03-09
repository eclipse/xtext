/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.formatting2;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.generator.IInheriting;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccessUtil;
import org.eclipse.xtext.generator.serializer.JavaEMFFile;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated(forRemoval = true)
@FinalFieldsConstructor
@SuppressWarnings("all")
public class FormatterStubGenerator {
  @Accessors(AccessorType.PUBLIC_GETTER)
  public static class Service {
    @Inject
    private Naming naming;

    public FormatterStubGenerator createGenerator(final Grammar grammar) {
      return new FormatterStubGenerator(this, grammar);
    }

    @Pure
    public Naming getNaming() {
      return this.naming;
    }
  }

  private final FormatterStubGenerator.Service service;

  private final Grammar grammar;

  public String getStubSimpleName() {
    StringConcatenation _builder = new StringConcatenation();
    String _simpleName = this.service.naming.toSimpleName(this.grammar.getName());
    _builder.append(_simpleName);
    _builder.append("Formatter");
    return _builder.toString();
  }

  public String getStubPackageName() {
    StringConcatenation _builder = new StringConcatenation();
    String _packageName = this.service.naming.toPackageName(this.grammar.getName());
    _builder.append(_packageName);
    _builder.append(".formatting2");
    return _builder.toString();
  }

  public String getStubQualifiedName() {
    StringConcatenation _builder = new StringConcatenation();
    String _stubPackageName = this.getStubPackageName();
    _builder.append(_stubPackageName);
    _builder.append(".");
    String _stubSimpleName = this.getStubSimpleName();
    _builder.append(_stubSimpleName);
    return _builder.toString();
  }

  public String getStubFileName() {
    StringConcatenation _builder = new StringConcatenation();
    String _asPath = this.service.naming.asPath(this.getStubQualifiedName());
    _builder.append(_asPath);
    _builder.append(".xtend");
    return _builder.toString();
  }

  public String getStubSuperClassName() {
    final Grammar superGrammar = IInheriting.Util.getNonTerminalsSuperGrammar(this.grammar);
    if ((superGrammar != null)) {
      return this.service.createGenerator(superGrammar).getStubQualifiedName();
    } else {
      return AbstractFormatter2.class.getName();
    }
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

  public String generateStubFileContents() {
    ResourceSet _resourceSet = this.grammar.eResource().getResourceSet();
    String _stubPackageName = this.getStubPackageName();
    String _fileHeader = this.service.naming.fileHeader();
    @Extension
    final JavaEMFFile file = new JavaEMFFile(_resourceSet, _stubPackageName, _fileHeader);
    file.imported(IFormattableDocument.class);
    final LinkedHashMultimap<EClass, EReference> type2ref = LinkedHashMultimap.<EClass, EReference>create();
    this.getLocallyAssignedContainmentReferences(this.grammar, type2ref);
    final LinkedHashMultimap<EClass, EReference> inheritedTypes = LinkedHashMultimap.<EClass, EReference>create();
    this.getInheritedContainmentReferences(this.grammar, inheritedTypes, CollectionLiterals.<Grammar>newHashSet());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    String _stubSimpleName = this.getStubSimpleName();
    _builder.append(_stubSimpleName);
    _builder.append(" extends ");
    String _imported = file.imported(this.getStubSuperClassName());
    _builder.append(_imported);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@");
    String _imported_1 = file.imported(Inject.class);
    _builder.append(_imported_1, "\t");
    _builder.append(" extension ");
    String _imported_2 = file.imported(GrammarAccessUtil.getGrammarAccessFQName(this.grammar, this.service.naming));
    _builder.append(_imported_2, "\t");
    _builder.newLineIfNotEmpty();
    {
      Set<EClass> _keySet = type2ref.keySet();
      for(final EClass type : _keySet) {
        _builder.newLine();
        _builder.append("\t");
        CharSequence _generateFormatMethod = this.generateFormatMethod(type, file, type2ref.get(type), inheritedTypes.containsKey(type));
        _builder.append(_generateFormatMethod, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    file.setBody(_builder.toString());
    return file.toString();
  }

  protected String toName(final EClass clazz) {
    return clazz.getName().toLowerCase();
  }

  protected CharSequence generateFormatMethod(final EClass clazz, @Extension final JavaEMFFile file, final Collection<EReference> containmentRefs, final boolean isOverriding) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (isOverriding) {
        _builder.append("override");
      } else {
        _builder.append("def");
      }
    }
    _builder.append(" dispatch void format(");
    String _importedGenTypeName = file.importedGenTypeName(clazz);
    _builder.append(_importedGenTypeName);
    _builder.append(" ");
    String _name = this.toName(clazz);
    _builder.append(_name);
    _builder.append(", extension IFormattableDocument document) {");
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
            String _importedGenTypeName_1 = file.importedGenTypeName(ref.getEReferenceType());
            _builder.append(_importedGenTypeName_1, "\t");
            _builder.append(" ");
            String _name_1 = ref.getName();
            _builder.append(_name_1, "\t");
            _builder.append(" : ");
            String _name_2 = this.toName(clazz);
            _builder.append(_name_2, "\t");
            _builder.append(".");
            String _getAccessor = file.getGetAccessor(ref);
            _builder.append(_getAccessor, "\t");
            _builder.append("()) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("format(");
            String _name_3 = ref.getName();
            _builder.append(_name_3, "\t\t");
            _builder.append(", document);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("format(");
            String _name_4 = this.toName(clazz);
            _builder.append(_name_4, "\t");
            _builder.append(".");
            String _getAccessor_1 = file.getGetAccessor(ref);
            _builder.append(_getAccessor_1, "\t");
            _builder.append("(), document);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public FormatterStubGenerator(final FormatterStubGenerator.Service service, final Grammar grammar) {
    super();
    this.service = service;
    this.grammar = grammar;
  }
}
