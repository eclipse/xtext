/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext;

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
import java.util.function.Consumer;
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
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.ConditionEvaluator;
import org.eclipse.xtext.xtext.OriginalElement;
import org.eclipse.xtext.xtext.OriginalGrammar;
import org.eclipse.xtext.xtext.RuleFilter;
import org.eclipse.xtext.xtext.RuleNames;
import org.eclipse.xtext.xtext.RuleWithParameterValues;
import org.eclipse.xtext.xtext.UsedRulesFinder;

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
    flattenedGrammar.setName(grammar.getName());
    LinkedHashMap<RuleWithParameterValues, AbstractRule> origToCopy = Maps.<RuleWithParameterValues, AbstractRule>newLinkedHashMap();
    final ArrayList<AbstractRule> copies = this.copyRuleStubs(names, origToCopy, filter.getRules(grammar), filter.isDiscardRuleTypeRef());
    EList<AbstractRule> _rules = flattenedGrammar.getRules();
    Iterables.<AbstractRule>addAll(_rules, copies);
    Multimap<TerminalRule, AbstractRule> calledFrom = this.copyRuleBodies(copies, origToCopy);
    this.setHiddenTokens(flattenedGrammar, grammar, origToCopy);
    this.markAsFragment(calledFrom);
    boolean _isDiscardUnreachableRules = filter.isDiscardUnreachableRules();
    if (_isDiscardUnreachableRules) {
      Set<AbstractRule> usedRules = CollectionLiterals.<AbstractRule>newHashSet();
      boolean _isDiscardTerminalRules = filter.isDiscardTerminalRules();
      boolean _not = (!_isDiscardTerminalRules);
      if (_not) {
        usedRules.addAll(GrammarUtil.allTerminalRules(flattenedGrammar));
      }
      UsedRulesFinder finder = new UsedRulesFinder(usedRules);
      finder.compute(flattenedGrammar);
      flattenedGrammar.getRules().retainAll(usedRules);
    }
    this.flattenedGrammar = flattenedGrammar;
    new OriginalGrammar(grammar).attachToEmfObject(flattenedGrammar);
  }
  
  private void setHiddenTokens(final Grammar copy, final Grammar orig, final Map<RuleWithParameterValues, AbstractRule> origToCopy) {
    if ((orig == null)) {
      copy.setDefinesHiddenTokens(true);
    } else {
      boolean _isDefinesHiddenTokens = orig.isDefinesHiddenTokens();
      boolean _not = (!_isDefinesHiddenTokens);
      if (_not) {
        this.setHiddenTokens(copy, IterableExtensions.<Grammar>head(orig.getUsedGrammars()), origToCopy);
      } else {
        copy.setDefinesHiddenTokens(true);
        EList<AbstractRule> _hiddenTokens = copy.getHiddenTokens();
        final Function1<AbstractRule, AbstractRule> _function = (AbstractRule hidden) -> {
          RuleWithParameterValues _ruleWithParameterValues = new RuleWithParameterValues(hidden);
          return origToCopy.get(_ruleWithParameterValues);
        };
        List<AbstractRule> _map = ListExtensions.<AbstractRule, AbstractRule>map(orig.getHiddenTokens(), _function);
        Iterables.<AbstractRule>addAll(_hiddenTokens, _map);
      }
    }
  }
  
  private void markAsFragment(final Multimap<TerminalRule, AbstractRule> calledFrom) {
    final Function1<TerminalRule, Boolean> _function = (TerminalRule it) -> {
      boolean _isFragment = it.isFragment();
      return Boolean.valueOf((!_isFragment));
    };
    final Function1<TerminalRule, Boolean> _function_1 = (TerminalRule it) -> {
      return Boolean.valueOf(this.allAreTerminalRules(calledFrom.get(it)));
    };
    final Function1<TerminalRule, Boolean> _function_2 = (TerminalRule it) -> {
      EObject _eContainer = it.eContainer();
      boolean _contains = ((Grammar) _eContainer).getHiddenTokens().contains(it);
      return Boolean.valueOf((!_contains));
    };
    final Consumer<TerminalRule> _function_3 = (TerminalRule it) -> {
      it.setFragment(true);
    };
    IterableExtensions.<TerminalRule>filter(IterableExtensions.<TerminalRule>filter(IterableExtensions.<TerminalRule>filter(calledFrom.keySet(), _function), _function_1), _function_2).forEach(_function_3);
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
            boolean _isEmpty = origRuleCall.getArguments().isEmpty();
            if (_isEmpty) {
              return Collections.<Parameter>emptySet();
            }
            final Function1<NamedArgument, Boolean> _function = (NamedArgument it) -> {
              return Boolean.valueOf(this.evaluate(it.getValue()));
            };
            final Function1<NamedArgument, Parameter> _function_1 = (NamedArgument it) -> {
              return it.getParameter();
            };
            Set<Parameter> result = IterableExtensions.<Parameter>toSet(IterableExtensions.<NamedArgument, Parameter>map(IterableExtensions.<NamedArgument>filter(origRuleCall.getArguments(), _function), _function_1));
            return result;
          }
          
          @Override
          protected void copyContainment(final EReference eReference, final EObject eObject, final EObject copyEObject) {
            boolean _matched = false;
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
            super.copyContainment(eReference, eObject, copyEObject);
          }
          
          @Override
          public EObject copy(final EObject eObject) {
            if ((eObject instanceof Group)) {
              Group group = ((Group)eObject);
              Condition _guardCondition = group.getGuardCondition();
              boolean _tripleNotEquals = (_guardCondition != null);
              if (_tripleNotEquals) {
                boolean _evaluate = this.evaluate(group.getGuardCondition());
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
                if (((!((CompoundElement)result).isFirstSetPredicated()) && (!((CompoundElement)result).isPredicated()))) {
                  AbstractElement element = elements.get(0);
                  this.mergeCardinalities(element, ((AbstractElement)result));
                  this.mergePredicates(element, ((AbstractElement)result));
                  return element;
                } else {
                  AbstractElement element_1 = elements.get(0);
                  this.mergePredicates(((AbstractElement)result), element_1);
                  element_1.setFirstSetPredicated(false);
                  element_1.setPredicated(false);
                }
              }
            }
            if ((eObject instanceof AbstractElement)) {
              OriginalElement original = new OriginalElement(((AbstractElement)eObject));
              EClass _eClass = ((AbstractElement)eObject).eClass();
              EClass _eClass_1 = result.eClass();
              boolean _notEquals = (!Objects.equal(_eClass, _eClass_1));
              if (_notEquals) {
                String _name = result.eClass().getName();
                String _plus = ("copy is: \'" + _name);
                String _plus_1 = (_plus + "\' but original was: \'");
                String _name_1 = ((AbstractElement)eObject).eClass().getName();
                String _plus_2 = (_plus_1 + _name_1);
                String _plus_3 = (_plus_2 + "\'");
                throw new IllegalStateException(_plus_3);
              }
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
              if (((!into.isPredicated()) && from.isFirstSetPredicated())) {
                into.setFirstSetPredicated(true);
              }
            }
          }
          
          void mergeCardinalities(final AbstractElement into, final AbstractElement from) {
            String c1 = into.getCardinality();
            String c2 = from.getCardinality();
            String _switchResult = null;
            boolean _matched = false;
            if ((Objects.equal(c1, "*") || Objects.equal(c2, "*"))) {
              _matched=true;
            }
            if (!_matched) {
              if ((Objects.equal(c1, "+") && Objects.equal(c2, "?"))) {
                _matched=true;
              }
            }
            if (!_matched) {
              if ((Objects.equal(c1, "?") && Objects.equal(c2, "+"))) {
                _matched=true;
              }
            }
            if (_matched) {
              _switchResult = "*";
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
            boolean result = new ConditionEvaluator(paramValues).evaluate(condition);
            return result;
          }
        };
        EObject _copy = copier.copy(orig.getAlternatives());
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
  
  private TypeRef copyTypeRef(final TypeRef ref) {
    if ((ref == null)) {
      return null;
    }
    final TypeRef copy = this.<TypeRef>copy(ref);
    copy.setClassifier(ref.getClassifier());
    return copy;
  }
  
  private ArrayList<AbstractRule> copyRuleStubs(final RuleNames names, final Map<RuleWithParameterValues, AbstractRule> origToCopy, final List<AbstractRule> rulesToCopy, final boolean discardTypeRef) {
    final ArrayList<AbstractRule> result = CollectionLiterals.<AbstractRule>newArrayList();
    for (final AbstractRule rule : rulesToCopy) {
      {
        String ruleName = names.getAntlrRuleName(rule);
        boolean _matched = false;
        if (rule instanceof ParserRule) {
          _matched=true;
          List<Parameter> params = ((ParserRule)rule).getParameters();
          boolean _isEmpty = params.isEmpty();
          if (_isEmpty) {
            ParserRule copy = this.<ParserRule>copy(((ParserRule)rule));
            copy.setName(ruleName);
            copy.setFragment(((ParserRule)rule).isFragment());
            copy.setWildcard(((ParserRule)rule).isWildcard());
            if ((!discardTypeRef)) {
              copy.setType(this.copyTypeRef(((ParserRule)rule).getType()));
            }
            this.attachTo(copy, rule, origToCopy);
            result.add(copy);
          } else {
            final Procedure2<Set<Parameter>, Integer> _function = (Set<Parameter> parameterConfig, Integer i) -> {
              RuleWithParameterValues parameterValues = new RuleWithParameterValues(rule, parameterConfig);
              ParserRule copy_1 = this.<ParserRule>copy(((ParserRule)rule));
              copy_1.setName(names.getAntlrRuleName(rule, (i).intValue()));
              copy_1.setFragment(((ParserRule)rule).isFragment());
              copy_1.setWildcard(((ParserRule)rule).isWildcard());
              if ((!discardTypeRef)) {
                copy_1.setType(this.copyTypeRef(((ParserRule)rule).getType()));
              }
              origToCopy.put(parameterValues, copy_1);
              parameterValues.attachToEmfObject(copy_1);
              result.add(copy_1);
            };
            IterableExtensions.<Set<Parameter>>forEach(Sets.<Parameter>powerSet(ImmutableSet.<Parameter>copyOf(params)), _function);
          }
        }
        if (!_matched) {
          if (rule instanceof TerminalRule) {
            _matched=true;
            TerminalRule orig = ((TerminalRule)rule);
            TerminalRule copy = this.<TerminalRule>copy(orig);
            copy.setName(ruleName);
            copy.setFragment(orig.isFragment());
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
    final Function1<AbstractRule, Boolean> _function = (AbstractRule it) -> {
      return Boolean.valueOf((it instanceof TerminalRule));
    };
    return IterableExtensions.<AbstractRule>forall(callers, _function);
  }
  
  private <T extends EObject> T copy(final T t) {
    EObject _create = EcoreUtil.create(t.eClass());
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
