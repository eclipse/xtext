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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.serializer.analysis.GrammarAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;

@SuppressWarnings("all")
public class SyntacticSequencerExtensions {
  @Inject
  private ISyntacticSequencerPDAProvider pdaProvider;

  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;

  @Inject
  private Grammar grammar;

  @Inject
  private InjectableRuleNames ruleNames;

  private List<EqualAmbiguousTransitions> ambiguousTransitions;

  protected List<ISyntacticSequencerPDAProvider.ISynAbsorberState> getAllPDAs() {
    final Function1<SerializationContextMap.Entry<ISyntacticSequencerPDAProvider.ISynAbsorberState>, ISyntacticSequencerPDAProvider.ISynAbsorberState> _function = (SerializationContextMap.Entry<ISyntacticSequencerPDAProvider.ISynAbsorberState> it) -> {
      return it.getValue();
    };
    return CollectionLiterals.<ISyntacticSequencerPDAProvider.ISynAbsorberState>newArrayList(((ISyntacticSequencerPDAProvider.ISynAbsorberState[])Conversions.unwrapArray(ListExtensions.<SerializationContextMap.Entry<ISyntacticSequencerPDAProvider.ISynAbsorberState>, ISyntacticSequencerPDAProvider.ISynAbsorberState>map(this.pdaProvider.getSyntacticSequencerPDAs(this.grammar).values(), _function), ISyntacticSequencerPDAProvider.ISynAbsorberState.class)));
  }

  protected void collectAllAmbiguousTransitions(final ISyntacticSequencerPDAProvider.ISynFollowerOwner state, final Set<ISyntacticSequencerPDAProvider.ISynTransition> result, final Set<Object> visited) {
    boolean _add = visited.add(state);
    boolean _not = (!_add);
    if (_not) {
      return;
    }
    if (((state instanceof ISyntacticSequencerPDAProvider.ISynTransition) && ((ISyntacticSequencerPDAProvider.ISynTransition) state).isSyntacticallyAmbiguous())) {
      result.add(((ISyntacticSequencerPDAProvider.ISynTransition) state));
    }
    if ((state instanceof ISyntacticSequencerPDAProvider.ISynAbsorberState)) {
      List<ISyntacticSequencerPDAProvider.ISynTransition> _outTransitions = ((ISyntacticSequencerPDAProvider.ISynAbsorberState)state).getOutTransitions();
      for (final ISyntacticSequencerPDAProvider.ISynTransition trans : _outTransitions) {
        this.collectAllAmbiguousTransitions(trans, result, visited);
      }
    } else {
      List<ISyntacticSequencerPDAProvider.ISynState> _followers = state.getFollowers();
      for (final ISyntacticSequencerPDAProvider.ISynState follower : _followers) {
        this.collectAllAmbiguousTransitions(follower, result, visited);
      }
    }
  }

  public Set<ISyntacticSequencerPDAProvider.ISynTransition> getAllAmbiguousTransitions() {
    final Set<ISyntacticSequencerPDAProvider.ISynTransition> result = CollectionLiterals.<ISyntacticSequencerPDAProvider.ISynTransition>newLinkedHashSet();
    List<ISyntacticSequencerPDAProvider.ISynAbsorberState> _allPDAs = this.getAllPDAs();
    for (final ISyntacticSequencerPDAProvider.ISynAbsorberState start : _allPDAs) {
      this.collectAllAmbiguousTransitions(start, result, CollectionLiterals.<Object>newHashSet());
    }
    return result;
  }

  public List<EqualAmbiguousTransitions> getAllAmbiguousTransitionsBySyntax() {
    if ((this.ambiguousTransitions != null)) {
      return this.ambiguousTransitions;
    }
    final Map<GrammarAlias.AbstractElementAlias, EqualAmbiguousTransitions> result = new LinkedHashMap<GrammarAlias.AbstractElementAlias, EqualAmbiguousTransitions>();
    Set<ISyntacticSequencerPDAProvider.ISynTransition> _allAmbiguousTransitions = this.getAllAmbiguousTransitions();
    for (final ISyntacticSequencerPDAProvider.ISynTransition transition : _allAmbiguousTransitions) {
      List<GrammarAlias.AbstractElementAlias> _ambiguousSyntaxes = transition.getAmbiguousSyntaxes();
      for (final GrammarAlias.AbstractElementAlias syntax : _ambiguousSyntaxes) {
        {
          EqualAmbiguousTransitions list = result.get(syntax);
          if ((list == null)) {
            String _elementAliasToIdentifier = this.elementAliasToIdentifier(syntax);
            EqualAmbiguousTransitions _equalAmbiguousTransitions = new EqualAmbiguousTransitions(_elementAliasToIdentifier, syntax);
            list = _equalAmbiguousTransitions;
            result.put(syntax, list);
          }
          list.getTransitions().add(transition);
        }
      }
    }
    this.ambiguousTransitions = CollectionLiterals.<EqualAmbiguousTransitions>newArrayList(((EqualAmbiguousTransitions[])Conversions.unwrapArray(result.values(), EqualAmbiguousTransitions.class)));
    ListExtensions.<EqualAmbiguousTransitions>sortInplace(this.ambiguousTransitions);
    return this.ambiguousTransitions;
  }

  protected String elementAliasToIdentifier(final GrammarAlias.AbstractElementAlias alias, final Set<String> rules, final boolean isNested) {
    String _xifexpression = null;
    if ((alias.isMany() && alias.isOptional())) {
      _xifexpression = "a";
    } else {
      String _xifexpression_1 = null;
      boolean _isMany = alias.isMany();
      if (_isMany) {
        _xifexpression_1 = "p";
      } else {
        String _xifexpression_2 = null;
        boolean _isOptional = alias.isOptional();
        if (_isOptional) {
          _xifexpression_2 = "q";
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    String card = _xifexpression;
    if ((alias instanceof GrammarAlias.TokenAlias)) {
      rules.add(this.ruleNames.getUniqueRuleName(GrammarUtil.containingRule(((GrammarAlias.TokenAlias)alias).getToken())));
      String _xifexpression_3 = null;
      if ((card == null)) {
        _xifexpression_3 = "";
      } else {
        _xifexpression_3 = ("_" + card);
      }
      card = _xifexpression_3;
      String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(((GrammarAlias.TokenAlias)alias).getToken());
      return (_gaElementIdentifier + card);
    } else {
      if ((alias instanceof GrammarAlias.GroupAlias)) {
        final List<String> children = CollectionLiterals.<String>newArrayList();
        List<GrammarAlias.AbstractElementAlias> _children = ((GrammarAlias.GroupAlias)alias).getChildren();
        for (final GrammarAlias.AbstractElementAlias child : _children) {
          children.add(this.elementAliasToIdentifier(child, rules, true));
        }
        final String body = IterableExtensions.join(children, "_");
        if ((isNested || (card != null))) {
          String _elvis = null;
          if (card != null) {
            _elvis = card;
          } else {
            _elvis = "";
          }
          card = _elvis;
          return ((("__" + body) + "__") + card);
        } else {
          return body;
        }
      } else {
        if ((alias instanceof GrammarAlias.AlternativeAlias)) {
          final List<String> children_1 = CollectionLiterals.<String>newArrayList();
          Set<GrammarAlias.AbstractElementAlias> _children_1 = ((GrammarAlias.AlternativeAlias)alias).getChildren();
          for (final GrammarAlias.AbstractElementAlias child_1 : _children_1) {
            children_1.add(this.elementAliasToIdentifier(child_1, rules, true));
          }
          ListExtensions.<String>sortInplace(children_1);
          final String body_1 = IterableExtensions.join(children_1, "_or_");
          if ((isNested || (card != null))) {
            String _elvis_1 = null;
            if (card != null) {
              _elvis_1 = card;
            } else {
              _elvis_1 = "";
            }
            card = _elvis_1;
            return ((("__" + body_1) + "__") + card);
          } else {
            return body_1;
          }
        }
      }
    }
    throw new RuntimeException("unknown element");
  }

  public StringConcatenationClient elementAliasToConstructor(final GrammarAlias.AbstractElementAlias alias) {
    final String many = String.valueOf(alias.isMany());
    final String optional = String.valueOf(alias.isOptional());
    if ((alias instanceof GrammarAlias.TokenAlias)) {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("new ");
          _builder.append(GrammarAlias.TokenAlias.class);
          _builder.append("(");
          _builder.append(many);
          _builder.append(", ");
          _builder.append(optional);
          _builder.append(", grammarAccess.");
          String _gaAccessor = SyntacticSequencerExtensions.this._grammarAccessExtensions.gaAccessor(((GrammarAlias.TokenAlias)alias).getToken());
          _builder.append(_gaAccessor);
          _builder.append(")");
        }
      };
      return _client;
    } else {
      if ((alias instanceof GrammarAlias.GroupAlias)) {
        final List<StringConcatenationClient> children = CollectionLiterals.<StringConcatenationClient>newArrayList();
        List<GrammarAlias.AbstractElementAlias> _children = ((GrammarAlias.GroupAlias)alias).getChildren();
        for (final GrammarAlias.AbstractElementAlias child : _children) {
          children.add(this.elementAliasToConstructor(child));
        }
        StringConcatenationClient _client_1 = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("new ");
            _builder.append(GrammarAlias.GroupAlias.class);
            _builder.append("(");
            _builder.append(many);
            _builder.append(", ");
            _builder.append(optional);
            _builder.append(", ");
            {
              boolean _hasElements = false;
              for(final StringConcatenationClient c : children) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "");
                }
                _builder.append(c);
              }
            }
            _builder.append(")");
          }
        };
        return _client_1;
      } else {
        if ((alias instanceof GrammarAlias.AlternativeAlias)) {
          final List<StringConcatenationClient> children_1 = CollectionLiterals.<StringConcatenationClient>newArrayList();
          Set<GrammarAlias.AbstractElementAlias> _children_1 = ((GrammarAlias.AlternativeAlias)alias).getChildren();
          for (final GrammarAlias.AbstractElementAlias child_1 : _children_1) {
            children_1.add(this.elementAliasToConstructor(child_1));
          }
          final Function1<StringConcatenationClient, String> _function = (StringConcatenationClient it) -> {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append(it);
            return _builder.toString();
          };
          ListExtensions.<StringConcatenationClient, String>sortInplaceBy(children_1, _function);
          StringConcatenationClient _client_2 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("new ");
              _builder.append(GrammarAlias.AlternativeAlias.class);
              _builder.append("(");
              _builder.append(many);
              _builder.append(", ");
              _builder.append(optional);
              _builder.append(", ");
              {
                boolean _hasElements = false;
                for(final StringConcatenationClient c : children_1) {
                  if (!_hasElements) {
                    _hasElements = true;
                  } else {
                    _builder.appendImmediate(", ", "");
                  }
                  _builder.append(c);
                }
              }
              _builder.append(")");
            }
          };
          return _client_2;
        }
      }
    }
    throw new RuntimeException("unknown element");
  }

  protected String elementAliasToIdentifier(final GrammarAlias.AbstractElementAlias alias) {
    final Set<String> rulesSet = CollectionLiterals.<String>newHashSet();
    final String body = this.elementAliasToIdentifier(alias, rulesSet, false);
    final List<String> rulesList = CollectionLiterals.<String>newArrayList(((String[])Conversions.unwrapArray(rulesSet, String.class)));
    ListExtensions.<String>sortInplace(rulesList);
    final String rule = IterableExtensions.join(rulesList, "_");
    return ((rule + "_") + body);
  }
}
