/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.formatting2;

import com.google.common.base.Objects;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
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
    String _name = this.grammar.getName();
    String _simpleName = this.service.naming.toSimpleName(_name);
    _builder.append(_simpleName, "");
    _builder.append("Formatter");
    return _builder.toString();
  }
  
  public String getStubPackageName() {
    StringConcatenation _builder = new StringConcatenation();
    String _name = this.grammar.getName();
    String _packageName = this.service.naming.toPackageName(_name);
    _builder.append(_packageName, "");
    _builder.append(".formatting2");
    return _builder.toString();
  }
  
  public String getStubQualifiedName() {
    StringConcatenation _builder = new StringConcatenation();
    String _stubPackageName = this.getStubPackageName();
    _builder.append(_stubPackageName, "");
    _builder.append(".");
    String _stubSimpleName = this.getStubSimpleName();
    _builder.append(_stubSimpleName, "");
    return _builder.toString();
  }
  
  public String getStubFileName() {
    StringConcatenation _builder = new StringConcatenation();
    String _stubQualifiedName = this.getStubQualifiedName();
    String _asPath = this.service.naming.asPath(_stubQualifiedName);
    _builder.append(_asPath, "");
    _builder.append(".xtend");
    return _builder.toString();
  }
  
  public String getStubSuperClassName() {
    final Grammar superGrammar = IInheriting.Util.getNonTerminalsSuperGrammar(this.grammar);
    boolean _notEquals = (!Objects.equal(superGrammar, null));
    if (_notEquals) {
      FormatterStubGenerator _createGenerator = this.service.createGenerator(superGrammar);
      return _createGenerator.getStubQualifiedName();
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
          String _feature = assignment.getFeature();
          final EStructuralFeature feature = ((EClass)type).getEStructuralFeature(_feature);
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
        boolean _notEquals = (!Objects.equal(featureName, null));
        if (_notEquals) {
          TypeRef _type = action.getType();
          final EClassifier type = _type.getClassifier();
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
    Resource _eResource = this.grammar.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    String _stubPackageName = this.getStubPackageName();
    String _fileHeader = this.service.naming.fileHeader();
    @Extension
    final JavaEMFFile file = new JavaEMFFile(_resourceSet, _stubPackageName, _fileHeader);
    file.imported(IFormattableDocument.class);
    final LinkedHashMultimap<EClass, EReference> type2ref = LinkedHashMultimap.<EClass, EReference>create();
    this.getLocallyAssignedContainmentReferences(this.grammar, type2ref);
    final LinkedHashMultimap<EClass, EReference> inheritedTypes = LinkedHashMultimap.<EClass, EReference>create();
    HashSet<Grammar> _newHashSet = CollectionLiterals.<Grammar>newHashSet();
    this.getInheritedContainmentReferences(this.grammar, inheritedTypes, _newHashSet);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    String _stubSimpleName = this.getStubSimpleName();
    _builder.append(_stubSimpleName, "");
    _builder.append(" extends ");
    String _stubSuperClassName = this.getStubSuperClassName();
    String _imported = file.imported(_stubSuperClassName);
    _builder.append(_imported, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@");
    String _imported_1 = file.imported(Inject.class);
    _builder.append(_imported_1, "\t");
    _builder.append(" extension ");
    String _grammarAccessFQName = GrammarAccessUtil.getGrammarAccessFQName(this.grammar, this.service.naming);
    String _imported_2 = file.imported(_grammarAccessFQName);
    _builder.append(_imported_2, "\t");
    _builder.newLineIfNotEmpty();
    {
      Set<EClass> _keySet = type2ref.keySet();
      for(final EClass type : _keySet) {
        _builder.newLine();
        _builder.append("\t");
        Set<EReference> _get = type2ref.get(type);
        boolean _containsKey = inheritedTypes.containsKey(type);
        CharSequence _generateFormatMethod = this.generateFormatMethod(type, file, _get, _containsKey);
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
    String _name = clazz.getName();
    return _name.toLowerCase();
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
    _builder.append(_importedGenTypeName, "");
    _builder.append(" ");
    String _name = this.toName(clazz);
    _builder.append(_name, "");
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
            EClass _eReferenceType = ref.getEReferenceType();
            String _importedGenTypeName_1 = file.importedGenTypeName(_eReferenceType);
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
