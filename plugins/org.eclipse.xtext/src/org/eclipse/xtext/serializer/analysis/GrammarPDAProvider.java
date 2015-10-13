/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.CfgAdapter;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDAElementFactory;
import org.eclipse.xtext.util.formallang.FollowerFunctionImpl;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaUtil;
import org.eclipse.xtext.util.formallang.Production;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class GrammarPDAProvider implements IGrammarPDAProvider {

	protected static class SerializerParserRuleCfg extends CfgAdapter {

		private final ParserRule entryRule;

		public SerializerParserRuleCfg(Grammar grammar, ParserRule entryRule) {
			super(grammar);
			this.entryRule = entryRule;
		}

		@Override
		public AbstractElement getCall(AbstractElement ele) {
			if (GrammarUtil.isEObjectRuleCall(ele) && !GrammarUtil.isAssigned(ele)) {
				return ((RuleCall) ele).getRule().getAlternatives();
			}
			return null;
		}

		@Override
		public AbstractElement getRoot() {
			return entryRule.getAlternatives();
		}

	}

	protected static class SerializerParserRuleFollowerFunction
			extends FollowerFunctionImpl<AbstractElement, AbstractElement> {

		public SerializerParserRuleFollowerFunction(Production<AbstractElement, AbstractElement> production) {
			super(production);
		}

	}

	protected Map<ParserRule, Pda<ISerState, RuleCall>> cache = Maps.newHashMap();

	@Inject
	protected PdaUtil pdaUtil;

	protected Pda<ISerState, RuleCall> createPDA(Grammar grammar, ParserRule entryRule) {
		Preconditions.checkArgument(isValidRule(entryRule));
		SerializerParserRuleCfg cfg = new SerializerParserRuleCfg(grammar, entryRule);
		SerializerParserRuleFollowerFunction ff = new SerializerParserRuleFollowerFunction(cfg);
		Pda<ISerState, RuleCall> pda = pdaUtil.create(cfg, ff, new SerializerPDAElementFactory());
		//		return pdaUtil.filterOrphans(pda, new SerializerPDACloneFactory());
		return pda;
	}

	@Override
	public Pda<ISerState, RuleCall> getGrammarPDA(Grammar grammar, ParserRule entryRule) {
		Pda<ISerState, RuleCall> result = cache.get(entryRule);
		if (result == null)
			cache.put(entryRule, result = createPDA(grammar, entryRule));
		return result;
	}

	protected boolean isValidRule(ParserRule rule) {
		return GrammarUtil.isEObjectRule(rule) && !rule.isFragment();
	}

	@Override
	public Set<ParserRule> getAllRules(Grammar grammar) {
		Set<ParserRule> result = Sets.newLinkedHashSet();
		for (ParserRule rule : GrammarUtil.allParserRules(grammar))
			if (isValidRule(rule))
				result.add(rule);
		return result;
	}

}
