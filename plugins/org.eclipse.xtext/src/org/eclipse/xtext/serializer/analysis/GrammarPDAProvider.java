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

import org.apache.log4j.Logger;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.CfgAdapter;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.SerializationContext.ParameterValueContext;
import org.eclipse.xtext.serializer.analysis.SerializationContext.RuleContext;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDAElementFactory;
import org.eclipse.xtext.util.formallang.FollowerFunctionImpl;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaFactory;
import org.eclipse.xtext.util.formallang.PdaUtil;
import org.eclipse.xtext.util.formallang.Production;
import org.eclipse.xtext.xtext.FlattenedGrammarAccess;
import org.eclipse.xtext.xtext.OriginalElement;
import org.eclipse.xtext.xtext.RuleFilter;
import org.eclipse.xtext.xtext.RuleNames;
import org.eclipse.xtext.xtext.RuleWithParameterValues;

import com.google.common.collect.Iterables;
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

	protected static class SerializerParserRuleFollowerFunction extends FollowerFunctionImpl<AbstractElement, AbstractElement> {

		public SerializerParserRuleFollowerFunction(Production<AbstractElement, AbstractElement> production) {
			super(production);
		}

	}

	protected static class ToOriginal implements PdaFactory<SerializerPDA, ISerState, RuleCall, AbstractElement> {

		private final SerializerPDAElementFactory delegate;
		private final Map<AbstractElement, ISerState> pops = Maps.newHashMap();
		private final Map<AbstractElement, ISerState> pushs = Maps.newHashMap();
		private final Map<AbstractElement, ISerState> states = Maps.newHashMap();

		public ToOriginal(SerializerPDAElementFactory delegate) {
			super();
			this.delegate = delegate;
		}

		@Override
		public SerializerPDA create(AbstractElement start, AbstractElement stop) {
			return delegate.create(original(start), original(stop));
		}

		@Override
		public ISerState createPop(SerializerPDA pda, AbstractElement token) {
			AbstractElement original = original(token);
			ISerState state = pops.get(original);
			if (state == null) {
				state = delegate.createPop(pda, original);
				pops.put(original, state);
			}
			return state;
		}

		@Override
		public ISerState createPush(SerializerPDA pda, AbstractElement token) {
			AbstractElement original = original(token);
			ISerState state = pushs.get(original);
			if (state == null) {
				state = delegate.createPush(pda, original);
				pushs.put(original, state);
			}
			return state;
		}

		@Override
		public ISerState createState(SerializerPDA nfa, AbstractElement token) {
			AbstractElement original = original(token);
			ISerState state = states.get(original);
			if (state == null) {
				state = delegate.createState(nfa, original);
				states.put(original, state);
			}
			return state;
		}

		protected AbstractElement original(AbstractElement ele) {
			if (ele == null)
				return null;
			AbstractElement original = OriginalElement.findInEmfObject(ele).getOriginal();
			if (original == null) {
				String name = new GrammarElementTitleSwitch().showQualified().showAssignments().apply(ele);
				throw new IllegalStateException("no original grammar element found for  " + name);
			}
			return original;
		}

		@Override
		public void setFollowers(SerializerPDA nfa, ISerState owner, Iterable<ISerState> followers) {
			Set<ISerState> all = Sets.newLinkedHashSet(owner.getFollowers());
			Iterables.addAll(all, followers);
			delegate.setFollowers(nfa, owner, all);
		}
	}

	private static Logger LOG = Logger.getLogger(GrammarPDAProvider.class);

	@Inject
	protected SerializerPDAElementFactory factory;

	@Inject
	protected PdaUtil pdaUtil;

	protected ISerializationContext createContext(ParserRule original, Set<Parameter> params) {
		ISerializationContext context = new RuleContext(null, original);
		if (params != null && !params.isEmpty())
			context = new ParameterValueContext(context, params);
		return context;
	}

	protected Pda<ISerState, RuleCall> createPDA(Grammar flattened, ParserRule entryRule) {
		SerializerParserRuleCfg cfg = new SerializerParserRuleCfg(flattened, entryRule);
		SerializerParserRuleFollowerFunction ff = new SerializerParserRuleFollowerFunction(cfg);
		SerializerPDA pda = pdaUtil.create(cfg, ff, new ToOriginal(factory));
		//		SerializerPDA pda = pdaUtil.create(cfg, ff, factory);
		return pda;
	}

	@Override
	public Map<ISerializationContext, Pda<ISerState, RuleCall>> getGrammarPDAs(Grammar grammar) {
		RuleNames names = RuleNames.getRuleNames(grammar, true);
		RuleFilter filter = new RuleFilter();
		filter.setDiscardTerminalRules(true);
		filter.setDiscardUnreachableRules(false);
		filter.setDiscardRuleTypeRef(false);
		Grammar flattened = new FlattenedGrammarAccess(names, filter).getFlattenedGrammar();
		Map<ISerializationContext, Pda<ISerState, RuleCall>> result = Maps.newLinkedHashMap();
		for (ParserRule rule : GrammarUtil.allParserRules(flattened)) {
			RuleWithParameterValues withParams = RuleWithParameterValues.findInEmfObject(rule);
			AbstractRule original = withParams.getOriginal();
			if (original instanceof ParserRule && isValidRule((ParserRule) original)) {
				ISerializationContext context = createContext((ParserRule) original, withParams.getParamValues());
				try {
					Pda<ISerState, RuleCall> pda = createPDA(grammar, rule);
					result.put(context, pda);
				} catch (Exception e) {
					LOG.error("Error creating PDA for context '" + context + "': " + e.getMessage(), e);
				}
			}
		}
		return result;
	}

	protected boolean isValidRule(ParserRule rule) {
		return GrammarUtil.isEObjectRule(rule) && !rule.isFragment();
	}

}
