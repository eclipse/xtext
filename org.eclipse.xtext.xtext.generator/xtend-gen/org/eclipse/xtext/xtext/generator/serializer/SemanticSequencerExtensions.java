/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
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
  
  public Map<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>> getGrammarConstraints(final Grammar grammar, final EClass clazz) {
    final Map<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>> result = CollectionLiterals.<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>newLinkedHashMap();
    final SerializationContextMap<IGrammarConstraintProvider.IConstraint> constraints = this.gcp.getConstraints(grammar);
    List<SerializationContextMap.Entry<IGrammarConstraintProvider.IConstraint>> _values = constraints.values();
    for (final SerializationContextMap.Entry<IGrammarConstraintProvider.IConstraint> e : _values) {
      {
        final IGrammarConstraintProvider.IConstraint constraint = e.getValue();
        EClass _type = constraint.getType();
        boolean _tripleEquals = (_type == clazz);
        if (_tripleEquals) {
          List<ISerializationContext> contexts = result.get(constraint);
          if ((contexts == null)) {
            contexts = CollectionLiterals.<ISerializationContext>newArrayList();
            result.put(constraint, contexts);
          }
          contexts.addAll(e.getContexts(clazz));
        }
      }
    }
    return result;
  }
  
  protected ResourceSet cloneResourceSet(final ResourceSet rs) {
    final XtextResourceSet result = new XtextResourceSet();
    result.setPackageRegistry(rs.getPackageRegistry());
    result.setResourceFactoryRegistry(rs.getResourceFactoryRegistry());
    result.setURIConverter(rs.getURIConverter());
    if ((rs instanceof XtextResourceSet)) {
      result.setClasspathURIContext(((XtextResourceSet)rs).getClasspathURIContext());
      result.setClasspathUriResolver(((XtextResourceSet)rs).getClasspathUriResolver());
    }
    return result;
  }
  
  public Grammar getSuperGrammar(final Grammar grammar) {
    boolean _isEmpty = grammar.getUsedGrammars().isEmpty();
    if (_isEmpty) {
      return null;
    }
    Adapter _existingAdapter = EcoreUtil.getExistingAdapter(grammar, SemanticSequencerExtensions.SuperGrammar.class);
    SemanticSequencerExtensions.SuperGrammar sg = ((SemanticSequencerExtensions.SuperGrammar) _existingAdapter);
    if ((sg != null)) {
      return sg.grammar;
    }
    final URI uri = IterableExtensions.<Grammar>head(grammar.getUsedGrammars()).eResource().getURI();
    final Resource resource = this.cloneResourceSet(grammar.eResource().getResourceSet()).getResource(uri, true);
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final Grammar result = ((Grammar) _head);
    EList<Adapter> _eAdapters = grammar.eAdapters();
    SemanticSequencerExtensions.SuperGrammar _superGrammar = new SemanticSequencerExtensions.SuperGrammar(result);
    _eAdapters.add(_superGrammar);
    return result;
  }
  
  public Collection<IGrammarConstraintProvider.IConstraint> getGrammarConstraints(final Grammar grammar) {
    if ((grammar == null)) {
      return CollectionLiterals.<IGrammarConstraintProvider.IConstraint>emptySet();
    }
    final Function1<SerializationContextMap.Entry<IGrammarConstraintProvider.IConstraint>, IGrammarConstraintProvider.IConstraint> _function = (SerializationContextMap.Entry<IGrammarConstraintProvider.IConstraint> it) -> {
      return it.getValue();
    };
    return ListExtensions.<SerializationContextMap.Entry<IGrammarConstraintProvider.IConstraint>, IGrammarConstraintProvider.IConstraint>map(this.gcp.getConstraints(grammar).values(), _function);
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
        int _size = state.getFollowers().size();
        boolean _tripleNotEquals = (_size != 1);
        if (_tripleNotEquals) {
          return null;
        }
        ISemanticSequencerNfaProvider.ISemState _start = nfa.getStart();
        boolean _tripleNotEquals_1 = (state != _start);
        if (_tripleNotEquals_1) {
          final EStructuralFeature feature = state.getFeature();
          if ((((feature == null) || feature.isMany()) || (!features.add(feature)))) {
            return null;
          }
          result.add(state);
        }
        state = IterableExtensions.<ISemanticSequencerNfaProvider.ISemState>head(state.getFollowers());
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
