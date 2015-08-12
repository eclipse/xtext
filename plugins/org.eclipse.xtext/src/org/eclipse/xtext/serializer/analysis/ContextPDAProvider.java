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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.CfgAdapter;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDACloneFactory;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDAElementFactory;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDAGetToken;
import org.eclipse.xtext.util.formallang.FollowerFunctionImpl;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaUtil;
import org.eclipse.xtext.util.formallang.Production;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class ContextPDAProvider implements IContextPDAProvider {

	protected class ExpandRuleCalls implements Function<ISerState, Pda<ISerState, RuleCall>> {
		@Override
		public Pda<ISerState, RuleCall> apply(ISerState input) {
			if (GrammarUtil.isUnassignedEObjectRuleCall(input.getGrammarElement()))
				return getContextPDA((((RuleCall) input.getGrammarElement()).getRule()));
			return null;
		}
	}

	protected static class SerializerActionCfg extends CfgAdapter {
		protected Action context;

		public SerializerActionCfg(Action context) {
			super(GrammarUtil.getGrammar(context));
			this.context = context;
		}

		@Override
		public AbstractElement getCall(AbstractElement ele) {
			return null;
		}

		@Override
		public AbstractElement getRoot() {
			return GrammarUtil.containingRule(context).getAlternatives();
		}
	}

	protected static class SerializerActionFollowerFunction extends
			FollowerFunctionImpl<AbstractElement, AbstractElement> {

		protected Action actionCtx;

		public SerializerActionFollowerFunction(Production<AbstractElement, AbstractElement> production, Action context) {
			super(production);
			this.actionCtx = context;
		}

		@Override
		public Iterable<AbstractElement> getFollowers(AbstractElement element) {
			Set<AbstractElement> result = Sets.newLinkedHashSet();
			for (AbstractElement ele : super.getFollowers(element))
				if (ele == null) {
				} else if (actionCtx == ele)
					result.add(null);
				else if (!GrammarUtil.isAssignedAction(ele))
					result.add(ele);
			return result;
		}

		@Override
		public Iterable<AbstractElement> getStarts(AbstractElement root) {
			Set<AbstractElement> result = Sets.newLinkedHashSet();
			for (Action act : GrammarUtil.containedActions(root))
				if (act.getFeature() != null)
					result.add(act);
			for (AbstractElement ele : super.getStarts(root))
				if (ele == null) {
				} else if (actionCtx == ele) {
					result.add(null);
				} else if (!GrammarUtil.isAssignedAction(ele))
					result.add(ele);
			return result;
		}

	}

	protected static class SerializerParserRuleCfg extends CfgAdapter {
		protected ParserRule context;

		public SerializerParserRuleCfg(ParserRule context) {
			super(GrammarUtil.getGrammar(context));
			this.context = context;
		}

		@Override
		public AbstractElement getCall(AbstractElement ele) {
			if (ele instanceof RuleCall && !GrammarUtil.isAssigned(ele)
					&& GrammarUtil.isEObjectRuleCall(ele))
				return ((RuleCall) ele).getRule().getAlternatives();
			return null;
		}

		@Override
		public AbstractElement getRoot() {
			return context.getAlternatives();
		}
	}

	protected static class SerializerParserRuleFollowerFunction extends
			FollowerFunctionImpl<AbstractElement, AbstractElement> {

		protected ParserRule ruleCtx;

		public SerializerParserRuleFollowerFunction(Production<AbstractElement, AbstractElement> production,
				ParserRule context) {
			super(production);
			this.ruleCtx = context;
		}

		@Override
		public Iterable<AbstractElement> getFollowers(AbstractElement element) {
			Set<AbstractElement> result = Sets.newLinkedHashSet();
			for (AbstractElement ele : super.getFollowers(element))
				if (ele == null)
					result.add(null);
				else if (!GrammarUtil.isAssignedAction(ele))
					result.add(ele);
			return result;
		}

		@Override
		public Iterable<AbstractElement> getStarts(AbstractElement root) {
			Set<AbstractElement> result = Sets.newLinkedHashSet();
			for (Action act : GrammarUtil.containedActions(root))
				if (act.getFeature() != null)
					result.add(act);
			for (AbstractElement ele : super.getStarts(root))
				if (ele == null)
					result.add(null);
				else if (!GrammarUtil.isAssignedAction(ele))
					result.add(ele);
			return result;
		}

	}

	protected Map<EObject, Pda<ISerState, RuleCall>> cache = Maps.newHashMap();

	@Inject
	protected PdaUtil pdaUtil;

	protected Pda<ISerState, RuleCall> createPDA(Action action) {
		SerializerActionCfg cfg = new SerializerActionCfg(action);
		SerializerActionFollowerFunction ff = new SerializerActionFollowerFunction(cfg, action);
		SerializerPDAElementFactory fact = new SerializerPDAElementFactory();
		Pda<ISerState, RuleCall> actionpda = pdaUtil.create(cfg, ff, fact);
		SerializerPDAGetToken getToken = new SerializerPDAGetToken();
		Pda<ISerState, RuleCall> expandedpda = pdaUtil.expand(actionpda, new ExpandRuleCalls(), getToken, fact);
		Pda<ISerState, RuleCall> filteredpda = pdaUtil.filterOrphans(expandedpda, new SerializerPDACloneFactory());
		return filteredpda;
	}

	protected Pda<ISerState, RuleCall> createPDA(EObject context, Pda<ISerState, RuleCall> result) {
		if (context instanceof ParserRule)
			return createPDA((ParserRule) context);
		else if (context instanceof Action)
			return createPDA((Action) context);
		throw new IllegalStateException("illegal context");
	}

	protected Pda<ISerState, RuleCall> createPDA(ParserRule rule) {
		SerializerParserRuleCfg cfg = new SerializerParserRuleCfg(rule);
		SerializerParserRuleFollowerFunction ff = new SerializerParserRuleFollowerFunction(cfg, rule);
		Pda<ISerState, RuleCall> pda = pdaUtil.create(cfg, ff, new SerializerPDAElementFactory());
		return pdaUtil.filterOrphans(pda, new SerializerPDACloneFactory());
	}

	@Override
	public Pda<ISerState, RuleCall> getContextPDA(EObject context) {
		Pda<ISerState, RuleCall> result = cache.get(context);
		if (result == null)
			cache.put(context, result = createPDA(context, result));
		return result;
	}

}
