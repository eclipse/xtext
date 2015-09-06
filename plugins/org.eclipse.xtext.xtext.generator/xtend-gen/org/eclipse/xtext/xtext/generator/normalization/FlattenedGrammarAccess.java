/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.normalization;

import com.google.common.base.Objects;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.Condition;
import org.eclipse.xtext.Conjunction;
import org.eclipse.xtext.Disjunction;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.LiteralCondition;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.Negation;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParameterReference;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.UsedRulesFinder;
import org.eclipse.xtext.xtext.generator.normalization.OriginalElement;
import org.eclipse.xtext.xtext.generator.normalization.OriginalGrammar;
import org.eclipse.xtext.xtext.generator.normalization.RuleFilter;
import org.eclipse.xtext.xtext.generator.normalization.RuleWithParameterValues;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@EmfAdaptable
@SuppressWarnings("all")
public class FlattenedGrammarAccess {
  public static class FlattenedGrammarAccessAdapter extends AdapterImpl {
    private FlattenedGrammarAccess element;
    
    public FlattenedGrammarAccessAdapter(final FlattenedGrammarAccess element) {
      this.element = element;
    }
    
    public FlattenedGrammarAccess get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == FlattenedGrammarAccess.class;
    }
  }
  
  @Accessors
  private final Grammar flattenedGrammar;
  
  public FlattenedGrammarAccess(final RuleNames names, final RuleFilter filter) {
    final Grammar grammar = names.getContextGrammar();
    Grammar flattenedGrammar = this.<Grammar>copy(grammar);
    String _name = grammar.getName();
    flattenedGrammar.setName(_name);
    LinkedHashMap<RuleWithParameterValues, AbstractRule> origToCopy = Maps.<RuleWithParameterValues, AbstractRule>newLinkedHashMap();
    List<AbstractRule> _rules = filter.getRules(grammar);
    final ArrayList<AbstractRule> copies = this.copyRuleStubs(names, origToCopy, _rules);
    EList<AbstractRule> _rules_1 = flattenedGrammar.getRules();
    Iterables.<AbstractRule>addAll(_rules_1, copies);
    Multimap<TerminalRule, AbstractRule> calledFrom = this.copyRuleBodies(copies, origToCopy);
    this.setHiddenTokens(flattenedGrammar, grammar, origToCopy);
    this.markAsFragment(calledFrom);
    boolean _isDiscardUnreachableRules = filter.isDiscardUnreachableRules();
    if (_isDiscardUnreachableRules) {
      Set<AbstractRule> usedRules = CollectionLiterals.<AbstractRule>newHashSet();
      boolean _isDiscardTerminalRules = filter.isDiscardTerminalRules();
      boolean _not = (!_isDiscardTerminalRules);
      if (_not) {
        List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(flattenedGrammar);
        usedRules.addAll(_allTerminalRules);
      }
      UsedRulesFinder finder = new UsedRulesFinder(usedRules);
      finder.compute(flattenedGrammar);
      EList<AbstractRule> _rules_2 = flattenedGrammar.getRules();
      _rules_2.retainAll(usedRules);
    }
    this.flattenedGrammar = flattenedGrammar;
    OriginalGrammar _originalGrammar = new OriginalGrammar(grammar);
    _originalGrammar.attachToEmfObject(flattenedGrammar);
  }
  
  private void setHiddenTokens(final Grammar copy, final Grammar orig, final Map<RuleWithParameterValues, AbstractRule> origToCopy) {
    if ((orig == null)) {
      copy.setDefinesHiddenTokens(true);
    } else {
      boolean _isDefinesHiddenTokens = orig.isDefinesHiddenTokens();
      boolean _not = (!_isDefinesHiddenTokens);
      if (_not) {
        EList<Grammar> _usedGrammars = orig.getUsedGrammars();
        Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars);
        this.setHiddenTokens(copy, _head, origToCopy);
      } else {
        copy.setDefinesHiddenTokens(true);
        EList<AbstractRule> _hiddenTokens = copy.getHiddenTokens();
        EList<AbstractRule> _hiddenTokens_1 = orig.getHiddenTokens();
        final Function1<AbstractRule, AbstractRule> _function = new Function1<AbstractRule, AbstractRule>() {
          @Override
          public AbstractRule apply(final AbstractRule hidden) {
            RuleWithParameterValues _ruleWithParameterValues = new RuleWithParameterValues(hidden);
            return origToCopy.get(_ruleWithParameterValues);
          }
        };
        List<AbstractRule> _map = ListExtensions.<AbstractRule, AbstractRule>map(_hiddenTokens_1, _function);
        Iterables.<AbstractRule>addAll(_hiddenTokens, _map);
      }
    }
  }
  
  private void markAsFragment(final Multimap<TerminalRule, AbstractRule> calledFrom) {
    Set<TerminalRule> _keySet = calledFrom.keySet();
    final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
      @Override
      public Boolean apply(final TerminalRule it) {
        boolean _isFragment = it.isFragment();
        return Boolean.valueOf((!_isFragment));
      }
    };
    Iterable<TerminalRule> _filter = IterableExtensions.<TerminalRule>filter(_keySet, _function);
    final Function1<TerminalRule, Boolean> _function_1 = new Function1<TerminalRule, Boolean>() {
      @Override
      public Boolean apply(final TerminalRule it) {
        Collection<AbstractRule> _get = calledFrom.get(it);
        return Boolean.valueOf(FlattenedGrammarAccess.this.allAreTerminalRules(_get));
      }
    };
    Iterable<TerminalRule> _filter_1 = IterableExtensions.<TerminalRule>filter(_filter, _function_1);
    final Function1<TerminalRule, Boolean> _function_2 = new Function1<TerminalRule, Boolean>() {
      @Override
      public Boolean apply(final TerminalRule it) {
        EObject _eContainer = it.eContainer();
        EList<AbstractRule> _hiddenTokens = ((Grammar) _eContainer).getHiddenTokens();
        boolean _contains = _hiddenTokens.contains(it);
        return Boolean.valueOf((!_contains));
      }
    };
    Iterable<TerminalRule> _filter_2 = IterableExtensions.<TerminalRule>filter(_filter_1, _function_2);
    final Procedure1<TerminalRule> _function_3 = new Procedure1<TerminalRule>() {
      @Override
      public void apply(final TerminalRule it) {
        it.setFragment(true);
      }
    };
    IterableExtensions.<TerminalRule>forEach(_filter_2, _function_3);
  }
  
  private Multimap<TerminalRule, AbstractRule> copyRuleBodies(final List<AbstractRule> copies, final Map<RuleWithParameterValues, AbstractRule> origToCopy) {
    abstract class __FlattenedGrammarAccess_1 extends EcoreUtil.Copier {
      final __FlattenedGrammarAccess_1 _this__FlattenedGrammarAccess_1 = this;
      
      abstract Set<Parameter> getParameterConfig(final RuleCall origRuleCall, final RuleCall copyRuleCall);
      
      abstract void mergePredicates(final AbstractElement into, final AbstractElement from);
      
      abstract void mergeCardinalities(final AbstractElement into, final AbstractElement from);
      
      abstract boolean evaluate(final Condition condition);
    }
    
    final HashMultimap<TerminalRule, AbstractRule> calledFrom = HashMultimap.<TerminalRule, AbstractRule>create();
    for (final AbstractRule copy : copies) {
      {
        AbstractRule orig = RuleWithParameterValues.getOriginalRule(copy);
        final Set<Parameter> paramValues = RuleWithParameterValues.getParamValues(copy);
        EcoreUtil.Copier copier = new __FlattenedGrammarAccess_1() {
          @Override
          protected void copyReference(final EReference eReference, final EObject eObject, final EObject copyEObject) {
            if ((eReference == XtextPackage.Literals.RULE_CALL__RULE)) {
              RuleCall origRuleCall = ((RuleCall) eObject);
              RuleCall copyRuleCall = ((RuleCall) copyEObject);
              AbstractRule _rule = origRuleCall.getRule();
              Set<Parameter> _parameterConfig = this.getParameterConfig(origRuleCall, copyRuleCall);
              RuleWithParameterValues _ruleWithParameterValues = new RuleWithParameterValues(_rule, _parameterConfig);
              AbstractRule calledCopy = origToCopy.get(_ruleWithParameterValues);
              copyRuleCall.setRule(calledCopy);
              if ((calledCopy instanceof TerminalRule)) {
                calledFrom.put(((TerminalRule)calledCopy), copy);
              }
            } else {
              super.copyReference(eReference, eObject, copyEObject);
            }
          }
          
          Set<Parameter> getParameterConfig(final RuleCall origRuleCall, final RuleCall copyRuleCall) {
            EList<NamedArgument> _arguments = origRuleCall.getArguments();
            boolean _isEmpty = _arguments.isEmpty();
            if (_isEmpty) {
              return Collections.<Parameter>emptySet();
            }
            EList<NamedArgument> _arguments_1 = origRuleCall.getArguments();
            final Function1<NamedArgument, Boolean> _function = new Function1<NamedArgument, Boolean>() {
              @Override
              public Boolean apply(final NamedArgument it) {
                Condition _value = it.getValue();
                return Boolean.valueOf(_this__FlattenedGrammarAccess_1.evaluate(_value));
              }
            };
            Iterable<NamedArgument> _filter = IterableExtensions.<NamedArgument>filter(_arguments_1, _function);
            final Function1<NamedArgument, Parameter> _function_1 = new Function1<NamedArgument, Parameter>() {
              @Override
              public Parameter apply(final NamedArgument it) {
                return it.getParameter();
              }
            };
            Iterable<Parameter> _map = IterableExtensions.<NamedArgument, Parameter>map(_filter, _function_1);
            Set<Parameter> result = IterableExtensions.<Parameter>toSet(_map);
            return result;
          }
          
          @Override
          protected void copyContainment(final EReference eReference, final EObject eObject, final EObject copyEObject) {
            boolean _matched = false;
            if (!_matched) {
              if (Objects.equal(eReference, XtextPackage.Literals.RULE_CALL__ARGUMENTS)) {
                _matched=true;
              }
              if (!_matched) {
                if (Objects.equal(eReference, XtextPackage.Literals.GROUP__GUARD_CONDITION)) {
                  _matched=true;
                }
              }
              if (_matched) {
                return;
              }
            }
            super.copyContainment(eReference, eObject, copyEObject);
          }
          
          @Override
          public EObject copy(final EObject eObject) {
            if ((eObject instanceof Group)) {
              Group group = ((Group)eObject);
              Condition _guardCondition = group.getGuardCondition();
              boolean _tripleNotEquals = (_guardCondition != null);
              if (_tripleNotEquals) {
                Condition _guardCondition_1 = group.getGuardCondition();
                boolean _evaluate = this.evaluate(_guardCondition_1);
                boolean _not = (!_evaluate);
                if (_not) {
                  return null;
                }
              }
            }
            EObject result = super.copy(eObject);
            if ((result instanceof CompoundElement)) {
              List<AbstractElement> elements = ((CompoundElement)result).getElements();
              int _size = elements.size();
              boolean _tripleEquals = (_size == 1);
              if (_tripleEquals) {
                boolean _and = false;
                boolean _isFirstSetPredicated = ((CompoundElement)result).isFirstSetPredicated();
                boolean _not_1 = (!_isFirstSetPredicated);
                if (!_not_1) {
                  _and = false;
                } else {
                  boolean _isPredicated = ((CompoundElement)result).isPredicated();
                  boolean _not_2 = (!_isPredicated);
                  _and = _not_2;
                }
                if (_and) {
                  AbstractElement element = elements.get(0);
                  this.mergeCardinalities(element, ((AbstractElement)result));
                  this.mergePredicates(element, ((AbstractElement)result));
                  return element;
                } else {
                  AbstractElement element_1 = elements.get(0);
                  this.mergeCardinalities(((AbstractElement)result), element_1);
                  this.mergePredicates(((AbstractElement)result), element_1);
                  element_1.setFirstSetPredicated(false);
                  element_1.setPredicated(false);
                }
              }
            }
            if ((eObject instanceof AbstractElement)) {
              OriginalElement original = new OriginalElement(((AbstractElement)eObject));
              original.attachToEmfObject(result);
            }
            return result;
          }
          
          void mergePredicates(final AbstractElement into, final AbstractElement from) {
            boolean _isPredicated = from.isPredicated();
            if (_isPredicated) {
              into.setPredicated(true);
              into.setFirstSetPredicated(false);
            } else {
              boolean _and = false;
              boolean _isPredicated_1 = into.isPredicated();
              boolean _not = (!_isPredicated_1);
              if (!_not) {
                _and = false;
              } else {
                boolean _isFirstSetPredicated = from.isFirstSetPredicated();
                _and = _isFirstSetPredicated;
              }
              if (_and) {
                into.setFirstSetPredicated(true);
              }
            }
          }
          
          void mergeCardinalities(final AbstractElement into, final AbstractElement from) {
            String c1 = into.getCardinality();
            String c2 = from.getCardinality();
            String _switchResult = null;
            boolean _matched = false;
            if (!_matched) {
              boolean _or = false;
              boolean _equals = Objects.equal(c1, "*");
              if (_equals) {
                _or = true;
              } else {
                boolean _equals_1 = Objects.equal(c2, "*");
                _or = _equals_1;
              }
              if (_or) {
                _matched=true;
              }
              if (!_matched) {
                boolean _and = false;
                boolean _equals_2 = Objects.equal(c1, "+");
                if (!_equals_2) {
                  _and = false;
                } else {
                  boolean _equals_3 = Objects.equal(c2, "?");
                  _and = _equals_3;
                }
                if (_and) {
                  _matched=true;
                }
              }
              if (!_matched) {
                boolean _and_1 = false;
                boolean _equals_4 = Objects.equal(c1, "?");
                if (!_equals_4) {
                  _and_1 = false;
                } else {
                  boolean _equals_5 = Objects.equal(c2, "+");
                  _and_1 = _equals_5;
                }
                if (_and_1) {
                  _matched=true;
                }
              }
              if (_matched) {
                _switchResult = "*";
              }
            }
            if (!_matched) {
              if (Objects.equal(c1, null)) {
                _matched=true;
                _switchResult = c2;
              }
            }
            if (!_matched) {
              _switchResult = c1;
            }
            into.setCardinality(_switchResult);
          }
          
          boolean evaluate(final Condition condition) {
            Boolean result = new XtextSwitch<Boolean>() {
              @Override
              public Boolean caseDisjunction(final Disjunction object) {
                boolean _or = false;
                Condition _left = object.getLeft();
                Boolean _doSwitch = this.doSwitch(_left);
                if ((_doSwitch).booleanValue()) {
                  _or = true;
                } else {
                  Condition _right = object.getRight();
                  Boolean _doSwitch_1 = this.doSwitch(_right);
                  _or = (_doSwitch_1).booleanValue();
                }
                return Boolean.valueOf(_or);
              }
              
              @Override
              public Boolean caseConjunction(final Conjunction object) {
                boolean _and = false;
                Condition _left = object.getLeft();
                Boolean _doSwitch = this.doSwitch(_left);
                if (!(_doSwitch).booleanValue()) {
                  _and = false;
                } else {
                  Condition _right = object.getRight();
                  Boolean _doSwitch_1 = this.doSwitch(_right);
                  _and = (_doSwitch_1).booleanValue();
                }
                return Boolean.valueOf(_and);
              }
              
              @Override
              public Boolean caseNegation(final Negation object) {
                Condition _value = object.getValue();
                Boolean _doSwitch = this.doSwitch(_value);
                return Boolean.valueOf((!(_doSwitch).booleanValue()));
              }
              
              @Override
              public Boolean caseParameterReference(final ParameterReference object) {
                Parameter _parameter = object.getParameter();
                return Boolean.valueOf(paramValues.contains(_parameter));
              }
              
              @Override
              public Boolean caseLiteralCondition(final LiteralCondition object) {
                return Boolean.valueOf(object.isTrue());
              }
            }.doSwitch(condition);
            return (result).booleanValue();
          }
        };
        AbstractElement _alternatives = orig.getAlternatives();
        EObject _copy = copier.copy(_alternatives);
        AbstractElement copiedBody = ((AbstractElement) _copy);
        copier.copyReferences();
        copy.setAlternatives(copiedBody);
        if ((orig instanceof ParserRule)) {
          ParserRule castedCopy = ((ParserRule) copy);
          boolean _isDefinesHiddenTokens = ((ParserRule)orig).isDefinesHiddenTokens();
          if (_isDefinesHiddenTokens) {
            castedCopy.setDefinesHiddenTokens(true);
            EList<AbstractRule> _hiddenTokens = ((ParserRule)orig).getHiddenTokens();
            for (final AbstractRule rule : _hiddenTokens) {
              {
                RuleWithParameterValues _ruleWithParameterValues = new RuleWithParameterValues(rule);
                final AbstractRule copiedTerminalRule = origToCopy.get(_ruleWithParameterValues);
                EList<AbstractRule> _hiddenTokens_1 = castedCopy.getHiddenTokens();
                _hiddenTokens_1.add(copiedTerminalRule);
                calledFrom.put(((TerminalRule) copiedTerminalRule), castedCopy);
              }
            }
          }
        }
      }
    }
    return calledFrom;
  }
  
  private ArrayList<AbstractRule> copyRuleStubs(final RuleNames names, final Map<RuleWithParameterValues, AbstractRule> origToCopy, final List<AbstractRule> rulesToCopy) {
    final ArrayList<AbstractRule> result = CollectionLiterals.<AbstractRule>newArrayList();
    for (final AbstractRule rule : rulesToCopy) {
      {
        String ruleName = names.getAntlrRuleName(rule);
        boolean _matched = false;
        if (!_matched) {
          if (rule instanceof ParserRule) {
            _matched=true;
            List<Parameter> params = ((ParserRule)rule).getParameters();
            boolean _isEmpty = params.isEmpty();
            if (_isEmpty) {
              ParserRule copy = this.<ParserRule>copy(((ParserRule)rule));
              copy.setName(ruleName);
              boolean _isFragment = ((ParserRule)rule).isFragment();
              copy.setFragment(_isFragment);
              boolean _isWildcard = ((ParserRule)rule).isWildcard();
              copy.setWildcard(_isWildcard);
              this.attachTo(copy, rule, origToCopy);
              result.add(copy);
            } else {
              ImmutableSet<Parameter> _copyOf = ImmutableSet.<Parameter>copyOf(params);
              Set<Set<Parameter>> _powerSet = Sets.<Parameter>powerSet(_copyOf);
              final Procedure2<Set<Parameter>, Integer> _function = new Procedure2<Set<Parameter>, Integer>() {
                @Override
                public void apply(final Set<Parameter> parameterConfig, final Integer i) {
                  RuleWithParameterValues parameterValues = new RuleWithParameterValues(rule, parameterConfig);
                  ParserRule copy = FlattenedGrammarAccess.this.<ParserRule>copy(((ParserRule)rule));
                  String _antlrRuleName = names.getAntlrRuleName(rule, (i).intValue());
                  copy.setName(_antlrRuleName);
                  boolean _isFragment = ((ParserRule)rule).isFragment();
                  copy.setFragment(_isFragment);
                  boolean _isWildcard = ((ParserRule)rule).isWildcard();
                  copy.setWildcard(_isWildcard);
                  origToCopy.put(parameterValues, copy);
                  parameterValues.attachToEmfObject(copy);
                  result.add(copy);
                }
              };
              IterableExtensions.<Set<Parameter>>forEach(_powerSet, _function);
            }
          }
        }
        if (!_matched) {
          if (rule instanceof TerminalRule) {
            _matched=true;
            TerminalRule orig = ((TerminalRule)rule);
            TerminalRule copy = this.<TerminalRule>copy(orig);
            copy.setName(ruleName);
            boolean _isFragment = orig.isFragment();
            copy.setFragment(_isFragment);
            this.attachTo(copy, orig, origToCopy);
            result.add(copy);
          }
        }
        if (!_matched) {
          if (rule instanceof EnumRule) {
            _matched=true;
            EnumRule copy = this.<EnumRule>copy(((EnumRule)rule));
            copy.setName(ruleName);
            this.attachTo(copy, rule, origToCopy);
            result.add(copy);
          }
        }
      }
    }
    return result;
  }
  
  private AbstractRule attachTo(final AbstractRule copy, final AbstractRule orig, final Map<RuleWithParameterValues, AbstractRule> origToCopy) {
    AbstractRule _xblockexpression = null;
    {
      RuleWithParameterValues parameterValues = new RuleWithParameterValues(orig);
      parameterValues.attachToEmfObject(copy);
      _xblockexpression = origToCopy.put(parameterValues, copy);
    }
    return _xblockexpression;
  }
  
  private boolean allAreTerminalRules(final Collection<AbstractRule> callers) {
    final Function1<AbstractRule, Boolean> _function = new Function1<AbstractRule, Boolean>() {
      @Override
      public Boolean apply(final AbstractRule it) {
        return Boolean.valueOf((it instanceof TerminalRule));
      }
    };
    return IterableExtensions.<AbstractRule>forall(callers, _function);
  }
  
  private <T extends EObject> T copy(final T t) {
    EClass _eClass = t.eClass();
    EObject _create = EcoreUtil.create(_eClass);
    T result = ((T) _create);
    return result;
  }
  
  public static FlattenedGrammarAccess findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof FlattenedGrammarAccess.FlattenedGrammarAccessAdapter) {
    		return ((FlattenedGrammarAccess.FlattenedGrammarAccessAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static FlattenedGrammarAccess removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof FlattenedGrammarAccess.FlattenedGrammarAccessAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((FlattenedGrammarAccess.FlattenedGrammarAccessAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    FlattenedGrammarAccess result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for FlattenedGrammarAccess");
    FlattenedGrammarAccess.FlattenedGrammarAccessAdapter adapter = new FlattenedGrammarAccess.FlattenedGrammarAccessAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
  
  @Pure
  public Grammar getFlattenedGrammar() {
    return this.flattenedGrammar;
  }
}
