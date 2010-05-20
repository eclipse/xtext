/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.common;

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

import com.google.common.base.Function;
import com.google.common.collect.BiMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Heiko Behrens
 */
public class KeywordHelper implements Adapter {

	private BiMap<CharSequence, String> keywordValueToToken;
	private boolean ignoreCase;
	
	public KeywordHelper(Grammar grammar, boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
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
			public String apply(Keyword from) {
				return from.getValue();
			}
		});
		TreeSet<String> treeSet = Sets.newTreeSet(new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length())
					return o1.compareTo(o2);
				return new Integer(o1.length()).compareTo(new Integer(o2.length()));
			}
		}, transformed);
		BiMap<CharSequence, String> result = Maps.newHashBiMap();
		int i = 1;
		for(String s: treeSet) {
			CharSequence key = createKey(s);
			if (!result.containsKey(key)) {
				result.put(key, "KEYWORD_" + i);
				i++;
			}
		}
		return result;
	}

	private CharSequence createKey(String s) {
		if(ignoreCase)
			return new IgnoreCaseString(s);
		else
			return s;
	}

	public Notifier getTarget() {
		return null;
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

	public void notifyChanged(Notification notification) {
	}

	public void setTarget(Notifier newTarget) {
	}
	
}
