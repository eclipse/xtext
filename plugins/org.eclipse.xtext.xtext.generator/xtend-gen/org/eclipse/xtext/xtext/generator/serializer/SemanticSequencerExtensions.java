/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class SemanticSequencerExtensions {
  @FinalFieldsConstructor
  @Accessors
  protected static class SuperGrammar extends AdapterImpl {
    private final Grammar grammar;
    
    @Override
    public boolean isAdapterForType(final Object type) {
      return (type == SemanticSequencerExtensions.SuperGrammar.class);
    }
    
    public SuperGrammar(final Grammar grammar) {
      super();
      this.grammar = grammar;
    }
    
    @Pure
    public Grammar getGrammar() {
      return this.grammar;
    }
  }
  
  @Inject
  private IGrammarConstraintProvider gcp;
  
  public Map<IGrammarConstraintProvider.IConstraint, List<EObject>> getGrammarConstraints(final Grammar grammar, final EClass clazz) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field constraints is undefined for the type Object"
      + "\nThe method or field context is undefined for the type Object"
      + "\nType mismatch: cannot convert from Map<IContext, IConstraint> to Iterable<?>"
      + "\ntype cannot be resolved"
      + "\n=== cannot be resolved");
  }
  
  public /* List<IConstraintContext> */Object getGrammarConstraintContexts(final Grammar grammar) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Map<IContext, IConstraint> to List<IConstraintContext>");
  }
  
  protected ResourceSet cloneResourceSet(final ResourceSet rs) {
    final XtextResourceSet result = new XtextResourceSet();
    EPackage.Registry _packageRegistry = rs.getPackageRegistry();
    result.setPackageRegistry(_packageRegistry);
    Resource.Factory.Registry _resourceFactoryRegistry = rs.getResourceFactoryRegistry();
    result.setResourceFactoryRegistry(_resourceFactoryRegistry);
    URIConverter _uRIConverter = rs.getURIConverter();
    result.setURIConverter(_uRIConverter);
    if ((rs instanceof XtextResourceSet)) {
      Object _classpathURIContext = ((XtextResourceSet)rs).getClasspathURIContext();
      result.setClasspathURIContext(_classpathURIContext);
      IClasspathUriResolver _classpathUriResolver = ((XtextResourceSet)rs).getClasspathUriResolver();
      result.setClasspathUriResolver(_classpathUriResolver);
    }
    return result;
  }
  
  public Grammar getSuperGrammar(final Grammar grammar) {
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    boolean _isEmpty = _usedGrammars.isEmpty();
    if (_isEmpty) {
      return null;
    }
    Adapter _existingAdapter = EcoreUtil.getExistingAdapter(grammar, SemanticSequencerExtensions.SuperGrammar.class);
    SemanticSequencerExtensions.SuperGrammar sg = ((SemanticSequencerExtensions.SuperGrammar) _existingAdapter);
    if ((sg != null)) {
      return sg.grammar;
    }
    EList<Grammar> _usedGrammars_1 = grammar.getUsedGrammars();
    Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars_1);
    Resource _eResource = _head.eResource();
    final URI uri = _eResource.getURI();
    Resource _eResource_1 = grammar.eResource();
    ResourceSet _resourceSet = _eResource_1.getResourceSet();
    ResourceSet _cloneResourceSet = this.cloneResourceSet(_resourceSet);
    final Resource resource = _cloneResourceSet.getResource(uri, true);
    EList<EObject> _contents = resource.getContents();
    EObject _head_1 = IterableExtensions.<EObject>head(_contents);
    final Grammar result = ((Grammar) _head_1);
    EList<Adapter> _eAdapters = grammar.eAdapters();
    SemanticSequencerExtensions.SuperGrammar _superGrammar = new SemanticSequencerExtensions.SuperGrammar(result);
    _eAdapters.add(_superGrammar);
    return result;
  }
  
  public Collection<IGrammarConstraintProvider.IConstraint> getGrammarConstraints(final Grammar grammar) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field constraints is undefined for the type Object"
      + "\nType mismatch: cannot convert from Map<IContext, IConstraint> to Iterable<?>");
  }
  
  public List<ISemanticSequencerNfaProvider.ISemState> getLinearListOfMandatoryAssignments(final IGrammarConstraintProvider.IConstraint constraint) {
    final Nfa<ISemanticSequencerNfaProvider.ISemState> nfa = constraint.getNfa();
    ISemanticSequencerNfaProvider.ISemState state = nfa.getStart();
    final List<ISemanticSequencerNfaProvider.ISemState> result = CollectionLiterals.<ISemanticSequencerNfaProvider.ISemState>newArrayList();
    final Set<EStructuralFeature> features = CollectionLiterals.<EStructuralFeature>newHashSet();
    while ((state != null)) {
      {
        ISemanticSequencerNfaProvider.ISemState _stop = nfa.getStop();
        boolean _tripleEquals = (state == _stop);
        if (_tripleEquals) {
          List<ISemanticSequencerNfaProvider.ISemState> _xifexpression = null;
          boolean _isEmpty = result.isEmpty();
          if (_isEmpty) {
            _xifexpression = null;
          } else {
            _xifexpression = result;
          }
          return _xifexpression;
        }
        List<ISemanticSequencerNfaProvider.ISemState> _followers = state.getFollowers();
        int _size = _followers.size();
        boolean _tripleNotEquals = (_size != 1);
        if (_tripleNotEquals) {
          return null;
        }
        ISemanticSequencerNfaProvider.ISemState _start = nfa.getStart();
        boolean _tripleNotEquals_1 = (state != _start);
        if (_tripleNotEquals_1) {
          final EStructuralFeature feature = state.getFeature();
          boolean _or = false;
          boolean _or_1 = false;
          if ((feature == null)) {
            _or_1 = true;
          } else {
            boolean _isMany = feature.isMany();
            _or_1 = _isMany;
          }
          if (_or_1) {
            _or = true;
          } else {
            boolean _add = features.add(feature);
            boolean _not = (!_add);
            _or = _not;
          }
          if (_or) {
            return null;
          }
          result.add(state);
        }
        List<ISemanticSequencerNfaProvider.ISemState> _followers_1 = state.getFollowers();
        ISemanticSequencerNfaProvider.ISemState _head = IterableExtensions.<ISemanticSequencerNfaProvider.ISemState>head(_followers_1);
        state = _head;
      }
    }
    return null;
  }
  
  public String toAcceptMethod(final IGrammarConstraintProvider.ConstraintElementType type) {
    String _switchResult = null;
    if (type != null) {
      switch (type) {
        case ASSIGNED_ACTION_CALL:
          _switchResult = "acceptAssignedAction";
          break;
        case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
          _switchResult = "acceptAssignedCrossRefDatatype";
          break;
        case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
          _switchResult = "acceptAssignedCrossRefEnum";
          break;
        case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
          _switchResult = "acceptAssignedCrossRefTerminal";
          break;
        case ASSIGNED_CROSSREF_KEYWORD:
          _switchResult = "acceptAssignedCrossRefKeyword";
          break;
        case ASSIGNED_DATATYPE_RULE_CALL:
          _switchResult = "acceptAssignedDatatype";
          break;
        case ASSIGNED_ENUM_RULE_CALL:
          _switchResult = "acceptAssignedEnum";
          break;
        case ASSIGNED_KEYWORD:
          _switchResult = "acceptAssignedKeyword";
          break;
        case ASSIGNED_PARSER_RULE_CALL:
          _switchResult = "acceptAssignedParserRuleCall";
          break;
        case ASSIGNED_TERMINAL_RULE_CALL:
          _switchResult = "acceptAssignedTerminal";
          break;
        default:
          _switchResult = (("<error, unknown type \'" + type) + "\'>");
          break;
      }
    } else {
      _switchResult = (("<error, unknown type \'" + type) + "\'>");
    }
    return _switchResult;
  }
  
  public String toNodeType(final IGrammarConstraintProvider.ConstraintElementType type) {
    String _switchResult = null;
    if (type != null) {
      switch (type) {
        case ASSIGNED_ACTION_CALL:
        case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
        case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
        case ASSIGNED_CROSSREF_KEYWORD:
        case ASSIGNED_DATATYPE_RULE_CALL:
        case ASSIGNED_ENUM_RULE_CALL:
        case ASSIGNED_PARSER_RULE_CALL:
          _switchResult = ICompositeNode.class.getSimpleName();
          break;
        case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
        case ASSIGNED_KEYWORD:
        case ASSIGNED_TERMINAL_RULE_CALL:
          _switchResult = ILeafNode.class.getSimpleName();
          break;
        default:
          _switchResult = (("<error, unknown type \'" + type) + "\'>");
          break;
      }
    } else {
      _switchResult = (("<error, unknown type \'" + type) + "\'>");
    }
    return _switchResult;
  }
}
