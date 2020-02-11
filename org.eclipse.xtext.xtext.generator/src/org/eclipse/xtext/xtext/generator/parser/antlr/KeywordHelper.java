/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;

import com.google.common.base.Function;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Heiko Behrens
 */
public class KeywordHelper implements Adapter {

	private BiMap<CharSequence, String> keywordValueToToken;
	private boolean ignoreCase;
	private GrammarAccessExtensions grammarUtil;
	
	public KeywordHelper(Grammar grammar, boolean ignoreCase, GrammarAccessExtensions grammarUtil) {
		this.ignoreCase = ignoreCase;
		this.grammarUtil = grammarUtil;
		keywordValueToToken = createKeywordMap(grammar);
		grammar.eResource().getResourceSet().eAdapters().add(this);
	}

	public void discardHelper(Grammar grammar) {
		grammar.eResource().getResourceSet().eAdapters().remove(this);
	}

	public static KeywordHelper getHelper(EObject context) {
		for(Adapter candidate: context.eResource().getResourceSet().eAdapters()) {
			if (candidate instanceof KeywordHelper)
				return (KeywordHelper) candidate;
		}
		return null;
	}

	public String getRuleName(String keywordValue) {
		return keywordValueToToken.get(createKey(keywordValue));
	}

	public String getKeywordValue(String ruleName) {
		return keywordValueToToken.inverse().get(ruleName).toString();
	}

	public boolean isKeywordRule(String ruleName) {
		return keywordValueToToken.containsValue(ruleName);
	}

	public final static Comparator<String> keywordComparator = new Comparator<String>() {

		@Override
		public int compare(String s1, String s2) {
			// sortBy(e|e).sortBy(e|e.length*-1)
			int result = s2.length() - s1.length();
			return result != 0 ? result : s1.compareTo(s2);
		}
	};

	public Set<String> getAllKeywords() {
		Set<String> result = new TreeSet<String>(keywordComparator);
		for(CharSequence cs : keywordValueToToken.keySet())
			result.add(cs.toString());

		return Collections.unmodifiableSet(result);
	}

	private BiMap<CharSequence, String> createKeywordMap(Grammar grammar) {
		List<ParserRule> parserRules = GrammarUtil.allParserRules(grammar);
		List<EnumRule> enumRules = GrammarUtil.allEnumRules(grammar);
		Iterator<EObject> iter = Iterators.concat(
				EcoreUtil.<EObject>getAllContents(parserRules), EcoreUtil.<EObject>getAllContents(enumRules));
		Iterator<Keyword> filtered = Iterators.filter(iter, Keyword.class);
		Iterator<String> transformed = Iterators.transform(filtered, new Function<Keyword, String>() {
			@Override
			public String apply(Keyword from) {
				return from.getValue();
			}
		});
		TreeSet<String> treeSet = Sets.newTreeSet(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length())
					return o1.compareTo(o2);
				return Integer.valueOf(o1.length()).compareTo(Integer.valueOf(o2.length()));
			}
		});
		Iterators.addAll(treeSet, transformed);
		BiMap<CharSequence, String> result = HashBiMap.create();
		for(String s: treeSet) {
			CharSequence key = createKey(s);
			String readableName = toAntlrTokenIdentifier(s);
			if (result.containsValue(readableName)) {
				int i = 1;
				String next = readableName + "_" + i;
				while(result.containsValue(next)) {
					i++;
					next = readableName + "_" + i;
				}
				readableName = next;
			}
			result.put(key, readableName);
		}
		return result;
	}

	private String toAntlrTokenIdentifier(String s) {
		String result = grammarUtil.toJavaIdentifier(s, Boolean.TRUE);
		// Antlr doesn't allow umlauts in rule names
		result =result.replace("ä", "ae")
			.replace("ö", "Oe")
			.replace("ü", "Ue")
			.replace("Ä", "Ae")
			.replace("Ö", "Oe")
			.replace("Ü", "Ue");
		if (
				result.charAt(0) == '_' // rule names may not start with an underscore 
			|| "System".equals(result) // the generated code contains System.err.printlns which is ambiguous with the generated field name
			|| result.startsWith("DFA") // the generated code may have fields named DFA... - avoid (unlikely) conflicts
			|| result.startsWith("EOF") // the generated code may have fields named EOF... - avoid (unlikely) conflicts
			|| result.startsWith("FOLLOW") // same with FOLLOW_ field names
			|| result.startsWith("Internal") && result.endsWith("Parser") // same with the name of the class itself
			) { 
			result = "KW_" + result;
		}
		return result;
	}

	private CharSequence createKey(String s) {
		if(ignoreCase)
			return new IgnoreCaseString(s);
		else
			return s;
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return false;
	}

	@Override
	public void notifyChanged(Notification notification) {
	}

	@Override
	public void setTarget(Notifier newTarget) {
	}

}
