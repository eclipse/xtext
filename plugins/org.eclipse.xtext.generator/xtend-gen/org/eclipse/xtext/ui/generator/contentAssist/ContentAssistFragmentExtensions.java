/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.generator.contentAssist;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Created for https://bugs.eclipse.org/bugs/show_bug.cgi?id=471434
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 * @since 2.8
 * @noreference This class is not intended to be referenced by clients.
 */
@SuppressWarnings("all")
public class ContentAssistFragmentExtensions {
  public static String getFqFeatureName(final Assignment it) {
    ParserRule _containingParserRule = GrammarUtil.containingParserRule(it);
    String _name = _containingParserRule.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    String _plus = (_firstUpper + "_");
    String _feature = it.getFeature();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_feature);
    return (_plus + _firstUpper_1);
  }
  
  public static String getFqFeatureName(final AbstractRule it) {
    String _name = it.getName();
    return ("_" + _name);
  }
  
  public static Grammar getSuperGrammar(final Grammar grammar) {
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    return IterableExtensions.<Grammar>head(_usedGrammars);
  }
  
  public static Set<String> getFqFeatureNamesToExclude(final Grammar grammar) {
    Set<String> toExclude = CollectionLiterals.<String>newHashSet();
    final Grammar superGrammar = ContentAssistFragmentExtensions.getSuperGrammar(grammar);
    boolean _notEquals = (!Objects.equal(superGrammar, null));
    if (_notEquals) {
      final Set<String> superGrammarsFqFeatureNames = ContentAssistFragmentExtensions.computeFqFeatureNamesFromSuperGrammars(grammar);
      Iterable<String> _computeFqFeatureNames = ContentAssistFragmentExtensions.computeFqFeatureNames(grammar);
      final Set<String> thisGrammarFqFeatureNames = IterableExtensions.<String>toSet(_computeFqFeatureNames);
      Sets.SetView<String> _intersection = Sets.<String>intersection(thisGrammarFqFeatureNames, superGrammarsFqFeatureNames);
      toExclude = _intersection;
    }
    return toExclude;
  }
  
  private static Set<String> computeFqFeatureNamesFromSuperGrammars(final Grammar grammar) {
    Set<String> _xblockexpression = null;
    {
      final HashSet<Grammar> superGrammars = CollectionLiterals.<Grammar>newHashSet();
      ContentAssistFragmentExtensions.computeAllSuperGrammars(grammar, superGrammars);
      final Function1<Grammar, Iterable<String>> _function = new Function1<Grammar, Iterable<String>>() {
        @Override
        public Iterable<String> apply(final Grammar it) {
          return ContentAssistFragmentExtensions.computeFqFeatureNames(it);
        }
      };
      Iterable<Iterable<String>> _map = IterableExtensions.<Grammar, Iterable<String>>map(superGrammars, _function);
      Iterable<String> _flatten = Iterables.<String>concat(_map);
      _xblockexpression = IterableExtensions.<String>toSet(_flatten);
    }
    return _xblockexpression;
  }
  
  private static Iterable<String> computeFqFeatureNames(final Grammar grammar) {
    List<Assignment> _containedAssignments = GrammarUtil.containedAssignments(grammar);
    final Function1<Assignment, String> _function = new Function1<Assignment, String>() {
      @Override
      public String apply(final Assignment it) {
        return ContentAssistFragmentExtensions.getFqFeatureName(it);
      }
    };
    List<String> _map = ListExtensions.<Assignment, String>map(_containedAssignments, _function);
    EList<AbstractRule> _rules = grammar.getRules();
    final Function1<AbstractRule, String> _function_1 = new Function1<AbstractRule, String>() {
      @Override
      public String apply(final AbstractRule it) {
        return ContentAssistFragmentExtensions.getFqFeatureName(it);
      }
    };
    List<String> _map_1 = ListExtensions.<AbstractRule, String>map(_rules, _function_1);
    return Iterables.<String>concat(_map, _map_1);
  }
  
  private static void computeAllSuperGrammars(final Grammar current, final Set<Grammar> visitedGrammars) {
    EList<Grammar> _usedGrammars = current.getUsedGrammars();
    for (final Grammar s : _usedGrammars) {
      boolean _contains = visitedGrammars.contains(s);
      boolean _not = (!_contains);
      if (_not) {
        visitedGrammars.add(s);
        ContentAssistFragmentExtensions.computeAllSuperGrammars(s, visitedGrammars);
      }
    }
  }
}
