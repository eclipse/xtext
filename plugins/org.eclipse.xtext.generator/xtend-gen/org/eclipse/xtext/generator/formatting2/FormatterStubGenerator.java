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
import com.google.inject.name.Named;
import java.util.Collection;
import java.util.List;
import java.util.Set;
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
    
    @Inject
    @Named("fileHeader")
    private String fileHeader;
    
    public FormatterStubGenerator createGenerator(final Grammar grammar) {
      return new FormatterStubGenerator(this, grammar);
    }
    
    @Pure
    public Naming getNaming() {
      return this.naming;
    }
    
    @Pure
    public String getFileHeader() {
      return this.fileHeader;
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
  
  public Multimap<EClass, EReference> getLocalyAssignedContainmentReferences() {
    final LinkedHashMultimap<EClass, EReference> result = LinkedHashMultimap.<EClass, EReference>create();
    List<Assignment> _containedAssignments = GrammarUtil.containedAssignments(this.grammar);
    for (final Assignment assignment : _containedAssignments) {
      {
        final EClassifier type = GrammarUtil.findCurrentType(assignment);
        if ((type instanceof EClass)) {
          String _feature = assignment.getFeature();
          final EStructuralFeature feature = ((EClass)type).getEStructuralFeature(_feature);
          boolean _and = false;
          if (!(feature instanceof EReference)) {
            _and = false;
          } else {
            boolean _isContainment = ((EReference) feature).isContainment();
            _and = _isContainment;
          }
          if (_and) {
            result.put(((EClass)type), ((EReference) feature));
          }
        }
      }
    }
    List<Action> _containedActions = GrammarUtil.containedActions(this.grammar);
    for (final Action action : _containedActions) {
      {
        final String featureName = action.getFeature();
        boolean _notEquals = (!Objects.equal(featureName, null));
        if (_notEquals) {
          TypeRef _type = action.getType();
          final EClassifier type = _type.getClassifier();
          if ((type instanceof EClass)) {
            final EStructuralFeature feature = ((EClass)type).getEStructuralFeature(featureName);
            boolean _and = false;
            if (!(feature instanceof EReference)) {
              _and = false;
            } else {
              boolean _isContainment = ((EReference) feature).isContainment();
              _and = _isContainment;
            }
            if (_and) {
              result.put(((EClass)type), ((EReference) feature));
            }
          }
        }
      }
    }
    return result;
  }
  
  public String generateStubFileContents() {
    Resource _eResource = this.grammar.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    String _stubPackageName = this.getStubPackageName();
    @Extension
    final JavaEMFFile file = new JavaEMFFile(_resourceSet, _stubPackageName);
    file.imported(IFormattableDocument.class);
    final Multimap<EClass, EReference> type2ref = this.getLocalyAssignedContainmentReferences();
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
        Collection<EReference> _get = type2ref.get(type);
        CharSequence _generateFormatMethod = this.generateFormatMethod(type, file, _get);
        _builder.append(_generateFormatMethod, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    file.setBody(_builder.toString());
    return file.toString();
  }
  
  public String toName(final EClass clazz) {
    String _name = clazz.getName();
    return _name.toLowerCase();
  }
  
  public CharSequence generateFormatMethod(final EClass clazz, @Extension final JavaEMFFile file, final Collection<EReference> containmentRefs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def dispatch void format(");
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
