/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.generator.contentAssist;

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
    String _firstUpper = StringExtensions.toFirstUpper(GrammarUtil.containingParserRule(it).getName());
    String _plus = (_firstUpper + "_");
    String _firstUpper_1 = StringExtensions.toFirstUpper(it.getFeature());
    return (_plus + _firstUpper_1);
  }
  
  public static String getFqFeatureName(final AbstractRule it) {
    String _name = it.getName();
    return ("_" + _name);
  }
  
  public static Grammar getSuperGrammar(final Grammar grammar) {
    return IterableExtensions.<Grammar>head(grammar.getUsedGrammars());
  }
  
  public static Set<String> getFqFeatureNamesToExclude(final Grammar grammar) {
    Set<String> toExclude = CollectionLiterals.<String>newHashSet();
    final Grammar superGrammar = ContentAssistFragmentExtensions.getSuperGrammar(grammar);
    if ((superGrammar != null)) {
      final Set<String> superGrammarsFqFeatureNames = ContentAssistFragmentExtensions.computeFqFeatureNamesFromSuperGrammars(grammar);
      final Set<String> thisGrammarFqFeatureNames = IterableExtensions.<String>toSet(ContentAssistFragmentExtensions.computeFqFeatureNames(grammar));
      toExclude = Sets.<String>intersection(thisGrammarFqFeatureNames, superGrammarsFqFeatureNames);
    }
    return toExclude;
  }
  
  private static Set<String> computeFqFeatureNamesFromSuperGrammars(final Grammar grammar) {
    Set<String> _xblockexpression = null;
    {
      final HashSet<Grammar> superGrammars = CollectionLiterals.<Grammar>newHashSet();
      ContentAssistFragmentExtensions.computeAllSuperGrammars(grammar, superGrammars);
      final Function1<Grammar, Iterable<String>> _function = (Grammar it) -> {
        return ContentAssistFragmentExtensions.computeFqFeatureNames(it);
      };
      _xblockexpression = IterableExtensions.<String>toSet(Iterables.<String>concat(IterableExtensions.<Grammar, Iterable<String>>map(superGrammars, _function)));
    }
    return _xblockexpression;
  }
  
  private static Iterable<String> computeFqFeatureNames(final Grammar grammar) {
    final Function1<Assignment, String> _function = (Assignment it) -> {
      return ContentAssistFragmentExtensions.getFqFeatureName(it);
    };
    List<String> _map = ListExtensions.<Assignment, String>map(GrammarUtil.containedAssignments(grammar), _function);
    final Function1<AbstractRule, String> _function_1 = (AbstractRule it) -> {
      return ContentAssistFragmentExtensions.getFqFeatureName(it);
    };
    List<String> _map_1 = ListExtensions.<AbstractRule, String>map(grammar.getRules(), _function_1);
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
