/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.generator.contentAssist;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Created for <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=471434">https://bugs.eclipse.org/bugs/show_bug.cgi?id=471434</a>
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 * @since 2.8
 * @noreference This class is not intended to be referenced by clients.
 */
public class ContentAssistFragmentExtensions {
	public static String getFqFeatureName(Assignment it) {
		return StringExtensions.toFirstUpper(GrammarUtil.containingParserRule(it).getName()) + "_"
				+ StringExtensions.toFirstUpper(it.getFeature());
	}

	public static String getFqFeatureName(AbstractRule it) {
		return "_" + it.getName();
	}

	public static Grammar getSuperGrammar(Grammar grammar) {
		return Iterables.getFirst(grammar.getUsedGrammars(), null);
	}

	public static Set<String> getFqFeatureNamesToExclude(Grammar grammar) {
		Set<String> toExclude = new HashSet<>();
		Grammar superGrammar = ContentAssistFragmentExtensions.getSuperGrammar(grammar);
		if (superGrammar != null) {
			Set<String> superGrammarsFqFeatureNames = ContentAssistFragmentExtensions
					.computeFqFeatureNamesFromSuperGrammars(grammar);
			Set<String> thisGrammarFqFeatureNames = IterableExtensions
					.toSet(ContentAssistFragmentExtensions.computeFqFeatureNames(grammar));
			toExclude = Sets.intersection(thisGrammarFqFeatureNames, superGrammarsFqFeatureNames);
		}
		return toExclude;
	}

	private static Set<String> computeFqFeatureNamesFromSuperGrammars(Grammar grammar) {
		HashSet<Grammar> superGrammars = new HashSet<>();
		ContentAssistFragmentExtensions.computeAllSuperGrammars(grammar, superGrammars);
		return IterableExtensions.toSet(Iterables.concat(
				Iterables.transform(superGrammars, g -> ContentAssistFragmentExtensions.computeFqFeatureNames(g))));
	}

	private static Iterable<String> computeFqFeatureNames(Grammar grammar) {
		return Iterables.concat(
				Lists.transform(GrammarUtil.containedAssignments(grammar),
						a -> ContentAssistFragmentExtensions.getFqFeatureName(a)),
				Lists.transform(grammar.getRules(), r -> ContentAssistFragmentExtensions.getFqFeatureName(r)));
	}

	private static void computeAllSuperGrammars(Grammar current, Set<Grammar> visitedGrammars) {
		for (Grammar s : current.getUsedGrammars()) {
			if (!visitedGrammars.contains(s)) {
				visitedGrammars.add(s);
				ContentAssistFragmentExtensions.computeAllSuperGrammars(s, visitedGrammars);
			}
		}
	}
}
