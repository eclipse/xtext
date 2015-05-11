/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.contentassist;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.Proposals;
import org.eclipse.xtext.web.server.contentassist.WebContentProposalProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public abstract class AbstractDeclarativeWebContentProposalProvider extends WebContentProposalProvider {
  @Inject
  private IGrammarAccess grammarAccess;
  
  private boolean initialized;
  
  private Map<String, Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>>> ruleCallProposalComputers;
  
  private Map<Pair<String, String>, Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>>> assignmentProposalComputers;
  
  @Override
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    this.initialize();
    AbstractRule _rule = ruleCall.getRule();
    String _name = _rule.getName();
    final Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>> proposalComputer = this.ruleCallProposalComputers.get(_name);
    if ((proposalComputer != null)) {
      proposalComputer.apply(ruleCall, context, acceptor);
    } else {
      super._createProposals(ruleCall, context, acceptor);
    }
  }
  
  @Override
  protected void _createProposals(final Assignment assignment, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    this.initialize();
    final AbstractRule rule = GrammarUtil.containingRule(assignment);
    String _name = rule.getName();
    String _feature = assignment.getFeature();
    Pair<String, String> _mappedTo = Pair.<String, String>of(_name, _feature);
    final Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>> proposalComputer = this.assignmentProposalComputers.get(_mappedTo);
    if ((proposalComputer != null)) {
      proposalComputer.apply(assignment, context, acceptor);
    } else {
      super._createProposals(assignment, context, acceptor);
    }
  }
  
  protected final synchronized boolean initialize() {
    boolean _xifexpression = false;
    if ((!this.initialized)) {
      boolean _xblockexpression = false;
      {
        HashMap<String, Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>>> _newHashMap = CollectionLiterals.<String, Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>>>newHashMap();
        this.ruleCallProposalComputers = _newHashMap;
        HashMap<Pair<String, String>, Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>>> _newHashMap_1 = CollectionLiterals.<Pair<String, String>, Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>>>newHashMap();
        this.assignmentProposalComputers = _newHashMap_1;
        Class<? extends AbstractDeclarativeWebContentProposalProvider> _class = this.getClass();
        Method[] _methods = _class.getMethods();
        for (final Method method : _methods) {
          {
            final Proposals annot = method.<Proposals>getAnnotation(Proposals.class);
            if ((annot != null)) {
              Grammar _grammar = this.grammarAccess.getGrammar();
              String _rule = annot.rule();
              final AbstractRule rule = GrammarUtil.findRuleForName(_grammar, _rule);
              if ((rule == null)) {
                String _rule_1 = annot.rule();
                String _plus = ("The grammar rule \'" + _rule_1);
                String _plus_1 = (_plus + "\' does not exist.");
                throw new RuntimeException(_plus_1);
              }
              Class<?> _returnType = method.getReturnType();
              boolean _tripleNotEquals = (_returnType != Void.TYPE);
              if (_tripleNotEquals) {
                String _name = method.getName();
                String _plus_2 = ("The method \'" + _name);
                String _plus_3 = (_plus_2 + "\' annotated with \'");
                String _simpleName = Proposals.class.getSimpleName();
                String _plus_4 = (_plus_3 + _simpleName);
                String _plus_5 = (_plus_4 + "\' must have void return type.");
                throw new RuntimeException(_plus_5);
              }
              String _feature = annot.feature();
              boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_feature);
              if (_isNullOrEmpty) {
                String _name_1 = rule.getName();
                boolean _containsKey = this.ruleCallProposalComputers.containsKey(_name_1);
                if (_containsKey) {
                  String _simpleName_1 = Proposals.class.getSimpleName();
                  String _plus_6 = ("Multiple methods with \'" + _simpleName_1);
                  String _plus_7 = (_plus_6 + "\' annotation for the same rule \'");
                  String _rule_2 = annot.rule();
                  String _plus_8 = (_plus_7 + _rule_2);
                  String _plus_9 = (_plus_8 + "\'");
                  throw new RuntimeException(_plus_9);
                }
                final Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>> computer = this.createMethodInvocation(method, RuleCall.class);
                method.setAccessible(true);
                String _name_2 = rule.getName();
                this.ruleCallProposalComputers.put(_name_2, computer);
              } else {
                TypeRef _type = rule.getType();
                EClassifier _classifier = null;
                if (_type!=null) {
                  _classifier=_type.getClassifier();
                }
                final EClassifier classifier = _classifier;
                if ((classifier instanceof EClass)) {
                  String _feature_1 = annot.feature();
                  EStructuralFeature _eStructuralFeature = ((EClass)classifier).getEStructuralFeature(_feature_1);
                  boolean _tripleEquals = (_eStructuralFeature == null);
                  if (_tripleEquals) {
                    String _feature_2 = annot.feature();
                    String _plus_10 = ("The feature \'" + _feature_2);
                    String _plus_11 = (_plus_10 + "\' does not exist for the metamodel class \'");
                    String _name_3 = ((EClass)classifier).getName();
                    String _plus_12 = (_plus_11 + _name_3);
                    String _plus_13 = (_plus_12 + "\'.");
                    throw new RuntimeException(_plus_13);
                  }
                }
                String _name_4 = rule.getName();
                String _feature_3 = annot.feature();
                final Pair<String, String> key = Pair.<String, String>of(_name_4, _feature_3);
                boolean _containsKey_1 = this.assignmentProposalComputers.containsKey(key);
                if (_containsKey_1) {
                  String _simpleName_2 = Proposals.class.getSimpleName();
                  String _plus_14 = ("Multiple methods with \'" + _simpleName_2);
                  String _plus_15 = (_plus_14 + "\' annotation for the same feature \'");
                  String _rule_3 = annot.rule();
                  String _plus_16 = (_plus_15 + _rule_3);
                  String _plus_17 = (_plus_16 + ".");
                  String _feature_4 = annot.feature();
                  String _plus_18 = (_plus_17 + _feature_4);
                  String _plus_19 = (_plus_18 + "\'");
                  throw new RuntimeException(_plus_19);
                }
                final Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>> computer_1 = this.createMethodInvocation(method, Assignment.class);
                method.setAccessible(true);
                this.assignmentProposalComputers.put(key, computer_1);
              }
            }
          }
        }
        _xblockexpression = this.initialized = true;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  private Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>> createMethodInvocation(final Method method, final Type elementType) {
    Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>> _xblockexpression = null;
    {
      int elementIndex = (-1);
      int contextIndex = (-1);
      int acceptorIndex = (-1);
      int eobjectIndex = (-1);
      Type[] _genericParameterTypes = method.getGenericParameterTypes();
      final int argumentsLength = _genericParameterTypes.length;
      for (int i = 0; (i < argumentsLength); i++) {
        {
          Type[] _genericParameterTypes_1 = method.getGenericParameterTypes();
          final Type type = _genericParameterTypes_1[i];
          if ((type instanceof ParameterizedType)) {
            boolean _and = false;
            boolean _and_1 = false;
            Type _rawType = ((ParameterizedType)type).getRawType();
            boolean _equals = Objects.equal(_rawType, IAcceptor.class);
            if (!_equals) {
              _and_1 = false;
            } else {
              Type[] _actualTypeArguments = ((ParameterizedType)type).getActualTypeArguments();
              int _length = _actualTypeArguments.length;
              boolean _equals_1 = (_length == 1);
              _and_1 = _equals_1;
            }
            if (!_and_1) {
              _and = false;
            } else {
              Type[] _actualTypeArguments_1 = ((ParameterizedType)type).getActualTypeArguments();
              Type _get = _actualTypeArguments_1[0];
              boolean _equals_2 = Objects.equal(_get, ContentAssistResult.Entry.class);
              _and = _equals_2;
            }
            if (_and) {
              acceptorIndex = i;
            } else {
              String _name = method.getName();
              String _plus = ("Unrecognized argument type for method \'" + _name);
              String _plus_1 = (_plus + "\' annotated with \'");
              String _simpleName = Proposals.class.getSimpleName();
              String _plus_2 = (_plus_1 + _simpleName);
              String _plus_3 = (_plus_2 + "\' (index ");
              String _plus_4 = (_plus_3 + Integer.valueOf(i));
              String _plus_5 = (_plus_4 + ")");
              throw new RuntimeException(_plus_5);
            }
          } else {
            boolean _equals_3 = Objects.equal(type, ContentAssistContext.class);
            if (_equals_3) {
              contextIndex = i;
            } else {
              boolean _equals_4 = Objects.equal(type, elementType);
              if (_equals_4) {
                elementIndex = i;
              } else {
                boolean _isAssignableFrom = EObject.class.isAssignableFrom(((Class<?>) type));
                if (_isAssignableFrom) {
                  eobjectIndex = i;
                } else {
                  String _name_1 = method.getName();
                  String _plus_6 = ("Unrecognized argument type for method \'" + _name_1);
                  String _plus_7 = (_plus_6 + "\' annotated with \'");
                  String _simpleName_1 = Proposals.class.getSimpleName();
                  String _plus_8 = (_plus_7 + _simpleName_1);
                  String _plus_9 = (_plus_8 + "\' (index ");
                  String _plus_10 = (_plus_9 + Integer.valueOf(i));
                  String _plus_11 = (_plus_10 + ")");
                  throw new RuntimeException(_plus_11);
                }
              }
            }
          }
        }
      }
      _xblockexpression = this.createMethodInvocation(method, elementIndex, contextIndex, acceptorIndex, eobjectIndex);
    }
    return _xblockexpression;
  }
  
  private Procedure3<? super AbstractElement, ? super ContentAssistContext, ? super IAcceptor<ContentAssistResult.Entry>> createMethodInvocation(final Method method, final int elementIndex, final int contextIndex, final int acceptorIndex, final int eobjectIndex) {
    final Procedure3<AbstractElement, ContentAssistContext, IAcceptor<ContentAssistResult.Entry>> _function = new Procedure3<AbstractElement, ContentAssistContext, IAcceptor<ContentAssistResult.Entry>>() {
      @Override
      public void apply(final AbstractElement element, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
        try {
          Type[] _genericParameterTypes = method.getGenericParameterTypes();
          int _length = _genericParameterTypes.length;
          final Object[] arguments = new Object[_length];
          if ((elementIndex >= 0)) {
            arguments[elementIndex] = element;
          }
          if ((contextIndex >= 0)) {
            arguments[contextIndex] = context;
          }
          if ((acceptorIndex >= 0)) {
            arguments[acceptorIndex] = acceptor;
          }
          if ((eobjectIndex >= 0)) {
            EObject _currentModel = context.getCurrentModel();
            arguments[eobjectIndex] = _currentModel;
          }
          method.invoke(AbstractDeclarativeWebContentProposalProvider.this, arguments);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    return _function;
  }
  
  public void createProposals(final AbstractElement assignment, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    if (assignment instanceof Assignment) {
      _createProposals((Assignment)assignment, context, acceptor);
      return;
    } else if (assignment instanceof CrossReference) {
      _createProposals((CrossReference)assignment, context, acceptor);
      return;
    } else if (assignment instanceof Keyword) {
      _createProposals((Keyword)assignment, context, acceptor);
      return;
    } else if (assignment instanceof RuleCall) {
      _createProposals((RuleCall)assignment, context, acceptor);
      return;
    } else if (assignment != null) {
      _createProposals(assignment, context, acceptor);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment, context, acceptor).toString());
    }
  }
}
