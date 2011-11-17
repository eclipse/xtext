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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.CfgAdapter;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDAElementFactory;
import org.eclipse.xtext.util.formallang.FollowerFunctionImpl;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaUtil;
import org.eclipse.xtext.util.formallang.Production;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class ContextPDAProvider implements IContextPDAProvider {

	protected static class SerializerCfg extends CfgAdapter {
		protected EObject context;

		public SerializerCfg(EObject context) {
			super(GrammarUtil.getGrammar(context));
			this.context = context;
		}

		@Override
		public AbstractElement getCall(AbstractElement ele) {
			if (ele instanceof RuleCall && !GrammarUtil.isAssigned(ele)
					&& ((RuleCall) ele).getRule().getType().getClassifier() instanceof EClass)
				return ((RuleCall) ele).getRule().getAlternatives();
			return null;
		}

		@Override
		public AbstractElement getRoot() {
			if (context instanceof AbstractRule)
				return ((AbstractRule) context).getAlternatives();
			if (context instanceof Action)
				return GrammarUtil.containingRule(context).getAlternatives();
			return super.getRoot();
		}
	}

	protected static class SerializerFollowerFunction extends FollowerFunctionImpl<AbstractElement, AbstractElement> {

		protected Action actionCtx;
		protected AbstractRule ruleCtx;

		public SerializerFollowerFunction(Production<AbstractElement, AbstractElement> production, EObject context) {
			super(production);
			this.actionCtx = context instanceof Action ? (Action) context : null;
			this.ruleCtx = context instanceof AbstractRule ? (AbstractRule) context : null;
		}

		@Override
		public Iterable<AbstractElement> getFollowers(AbstractElement element) {
			Set<AbstractElement> result = Sets.newLinkedHashSet();
			for (AbstractElement ele : super.getFollowers(element))
				if (ele == null) {
					if (isStop(element))
						result.add(null);
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
					if (isStop(root))
						result.add(null);
				} else if (actionCtx == ele) {
					result.add(null);
				} else if (!GrammarUtil.isAssignedAction(ele))
					result.add(ele);
			return result;
		}

		protected boolean isStop(AbstractElement element) {
			return actionCtx == null || (GrammarUtil.containingRule(actionCtx) != GrammarUtil.containingRule(element));
		}

	}

	protected Map<EObject, Pda<ISerState, RuleCall>> cache = Maps.newHashMap();

	protected Pda<ISerState, RuleCall> createPDA(EObject context) {
		SerializerCfg cfg = new SerializerCfg(context);
		SerializerFollowerFunction ff = new SerializerFollowerFunction(cfg, context);
		Pda<ISerState, RuleCall> pda = new PdaUtil().create(cfg, ff, new SerializerPDAElementFactory());
		new NfaUtil().removeOrphans(pda);
		return pda;
	}

	public Pda<ISerState, RuleCall> getContextPDA(EObject context) {
		Pda<ISerState, RuleCall> result = cache.get(context);
		if (result == null)
			cache.put(context, result = createPDA(context));
		return result;
	}

}
