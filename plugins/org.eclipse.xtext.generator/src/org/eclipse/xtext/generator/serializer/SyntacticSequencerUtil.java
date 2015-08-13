/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccessUtil;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.IContextProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynFollowerOwner;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerUtil {

	@Inject
	protected IContextProvider contextProvider;

	@Inject
	protected ISyntacticSequencerPDAProvider pdaProvider;

	@Inject
	protected Grammar grammar;
	
	@Inject
	private InjectableRuleNames ruleNames;

	protected List<ISynAbsorberState> getAllPDAs() {
		List<ISynAbsorberState> result = Lists.newArrayList();
		for (EObject context : contextProvider.getAllContexts(grammar))
			for (EClass type : contextProvider.getTypesForContext(context))
				result.add(pdaProvider.getPDA(context, type));
		return result;
	}

	protected void collectAllAmbiguousTransitions(ISynFollowerOwner state, Set<ISynTransition> result,
			Set<Object> visited) {
		if (!visited.add(state))
			return;
		if (state instanceof ISynTransition && ((ISynTransition) state).isSyntacticallyAmbiguous())
			result.add((ISynTransition) state);
		if (state instanceof ISynAbsorberState)
			for (ISynTransition trans : ((ISynAbsorberState) state).getOutTransitions())
				collectAllAmbiguousTransitions(trans, result, visited);
		else
			for (ISynState follower : state.getFollowers())
				collectAllAmbiguousTransitions(follower, result, visited);
	}

	public Set<ISynTransition> getAllAmbiguousTransitions() {
		Set<ISynTransition> result = Sets.newLinkedHashSet();
		for (ISynAbsorberState start : getAllPDAs())
			collectAllAmbiguousTransitions(start, result, Sets.newHashSet());
		return result;
	}

	protected List<EqualAmbiguousTransitions> ambiguousTransitions;

	public List<EqualAmbiguousTransitions> getAllAmbiguousTransitionsBySyntax() {
		if (ambiguousTransitions != null)
			return ambiguousTransitions;
		Map<AbstractElementAlias, EqualAmbiguousTransitions> result = Maps.newHashMap();
		for (ISynTransition transition : getAllAmbiguousTransitions()) {
			for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
				EqualAmbiguousTransitions list = result.get(syntax);
				if (list == null)
					result.put(syntax, list = new EqualAmbiguousTransitions(elementAliasToIdentifyer(syntax), syntax));
				list.getTransitions().add(transition);
			}
		}
		ambiguousTransitions = Lists.newArrayList(result.values());
		Collections.sort(ambiguousTransitions);
		return ambiguousTransitions;
	}

	protected String elementAliasToIdentifier(AbstractElementAlias alias, Set<String> rules, boolean isNested) {
		String card = null;
		if (alias.isMany() && alias.isOptional())
			card = "a";
		else if (alias.isMany())
			card = "p";
		else if (alias.isOptional())
			card = "q";
		if (alias instanceof TokenAlias) {
			TokenAlias ele = (TokenAlias) alias;
			rules.add(ruleNames.getUniqueRuleName(GrammarUtil.containingRule(ele.getToken())));
			card = card == null ? "" : "_" + card;
			return GrammarAccessUtil.getUniqueElementName(ele.getToken()) + card;
		} else if (alias instanceof GroupAlias) {
			List<String> children = Lists.newArrayList();
			for (AbstractElementAlias child : ((GroupAlias) alias).getChildren())
				children.add(elementAliasToIdentifier(child, rules, true));
			String body = Joiner.on("_").join(children);
			if (isNested || card != null) {
				card = card == null ? "" : card;
				return "__" + body + "__" + card;
			} else
				return body;
		} else if (alias instanceof AlternativeAlias) {
			List<String> children = Lists.newArrayList();
			for (AbstractElementAlias child : ((AlternativeAlias) alias).getChildren())
				children.add(elementAliasToIdentifier(child, rules, true));
			Collections.sort(children);
			String body = Joiner.on("_or_").join(children);
			if (isNested || card != null) {
				card = card == null ? "" : card;
				return "__" + body + "__" + card;
			} else
				return body;
		}
		throw new RuntimeException("unknown element");
	}

	@Inject
	protected GrammarAccess grammarAccess;

	public String elementAliasToConstructor(AbstractElementAlias alias, JavaFile file) {
		String many = String.valueOf(alias.isMany());
		String optional = String.valueOf(alias.isOptional());
		//		String absEle = file.imported(AbstractElement.class);
		if (alias instanceof TokenAlias) {
			TokenAlias ele = (TokenAlias) alias;
			String eleAlias = file.imported(TokenAlias.class);
			String eleAcc = "grammarAccess." + grammarAccess.gaAccessor(ele.getToken());
			return "new " + eleAlias + "(" + many + ", " + optional + ", " + eleAcc + ")";
		} else if (alias instanceof GroupAlias) {
			List<String> children = Lists.newArrayList();
			for (AbstractElementAlias child : ((GroupAlias) alias).getChildren())
				children.add(elementAliasToConstructor(child, file));
			String body = Joiner.on(", ").join(children);
			String grpAlias = file.imported(GroupAlias.class);
			return "new " + grpAlias + "(" + many + ", " + optional + ", " + body + ")";
		} else if (alias instanceof AlternativeAlias) {
			List<String> children = Lists.newArrayList();
			for (AbstractElementAlias child : ((AlternativeAlias) alias).getChildren())
				children.add(elementAliasToConstructor(child, file));
			Collections.sort(children);
			String body = Joiner.on(", ").join(children);
			String altAlias = file.imported(AlternativeAlias.class);
			return "new " + altAlias + "(" + many + ", " + optional + ", " + body + ")";
		}
		throw new RuntimeException("unknown element");
	}

	protected String elementAliasToIdentifyer(AbstractElementAlias alias) {
		Set<String> rulesSet = Sets.newHashSet();
		String body = elementAliasToIdentifier(alias, rulesSet, false);
		List<String> rulesList = Lists.newArrayList(rulesSet);
		Collections.sort(rulesList);
		String rule = Joiner.on("_").join(rulesList);
		return rule + "_" + body;
	}

}
