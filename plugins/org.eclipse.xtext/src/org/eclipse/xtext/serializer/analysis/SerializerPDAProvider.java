/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.CfgAdapter;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.FollowerFunctionImpl;
import org.eclipse.xtext.util.formallang.NfaGraphFormatter;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaFactory;
import org.eclipse.xtext.util.formallang.PdaUtil;
import org.eclipse.xtext.util.formallang.Production;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class SerializerPDAProvider implements ISerializerPDAProvider {

	protected static class SerializerCfg extends CfgAdapter {
		public SerializerCfg(Grammar grammar) {
			super(grammar);
		}

		@Override
		public AbstractElement getCall(AbstractElement ele) {
			if (ele instanceof RuleCall && GrammarUtil.isAssigned(ele)
					&& ((RuleCall) ele).getRule().getType().getClassifier() instanceof EClass)
				return ele;
			return null;
		}
	}

	protected static class SerializerFollowerFunction extends FollowerFunctionImpl<AbstractElement, AbstractElement> {

		protected Action actionCtx;
		protected AbstractRule ruleCtx;
		protected EClass type;

		public SerializerFollowerFunction(Production<AbstractElement, AbstractElement> production, EObject context,
				EClass type) {
			super(production);
			this.actionCtx = context instanceof Action ? (Action) context : null;
			this.ruleCtx = context instanceof AbstractRule ? (AbstractRule) context : null;
			this.type = type;
		}

		@Override
		public Iterable<AbstractElement> getFollowers(AbstractElement element) {
			Set<AbstractElement> result = Sets.newLinkedHashSet();
			for (AbstractElement ele : super.getFollowers(element))
				if (ele == null) {
					if (actionCtx == null)
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
				if (act.getFeature() != null && act.getType().getClassifier() == type)
					result.add(act);
			for (AbstractElement ele : super.getStarts(root))
				if (ele == null) {
					if (actionCtx == null)
						result.add(null);
				} else if (actionCtx == ele) {
					result.add(null);
				} else if (!GrammarUtil.isAssignedAction(ele)
						&& getType(ele, Sets.<AbstractElement> newHashSet()) != false)
					result.add(ele);
			return result;
		}

		protected Boolean getType(AbstractElement ele, Set<AbstractElement> visited) {
			if (!visited.add(ele))
				return null;
			if (ele instanceof Action)
				return ((Action) ele).getType().getClassifier() == type;
			if (GrammarUtil.isAssigned(ele))
				return GrammarUtil.containingRule(ele).getType().getClassifier() == type;
			for (AbstractElement f : super.getFollowers(ele))
				if (f != null && getType(ele, visited) == true)
					return true;
			return null;
		}
	}

	protected static class SerializerPDA implements Pda<SerializerPDAState, RuleCall> {

		protected SerializerPDAState start;
		protected SerializerPDAState stop;

		public SerializerPDA(SerializerPDAState start, SerializerPDAState stop) {
			super();
			this.start = start;
			this.stop = stop;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			return new NfaUtil().equalsIgnoreOrder(this, (SerializerPDA) obj);
		}

		public Iterable<SerializerPDAState> getFollowers(SerializerPDAState state) {
			return state.followers;
		}

		public RuleCall getPop(SerializerPDAState state) {
			return state.pop;
		}

		public RuleCall getPush(SerializerPDAState state) {
			return state.push;
		}

		public SerializerPDAState getStart() {
			return start;
		}

		public SerializerPDAState getStop() {
			return stop;
		}

		@Override
		public int hashCode() {
			int r = 0;
			if (start != null && start.followers != null)
				for (SerializerPDAState s : start.followers)
					if (s != null)
						r += s.hashCode();
			return r;
		}

		@Override
		public String toString() {
			return new NfaGraphFormatter().format(this);
		}

	}

	protected static class SerializerPDAFactory implements
			PdaFactory<SerializerPDA, SerializerPDAState, RuleCall, AbstractElement> {

		public SerializerPDA create(AbstractElement start, AbstractElement stop) {
			return new SerializerPDA(new SerializerPDAState(start), new SerializerPDAState(stop));
		}

		public SerializerPDAState createPop(SerializerPDA pda, AbstractElement token) {
			return new SerializerPDAState(token, (RuleCall) token, null);
		}

		public SerializerPDAState createPush(SerializerPDA pda, AbstractElement token) {
			return new SerializerPDAState(token, null, (RuleCall) token);
		}

		public SerializerPDAState createState(SerializerPDA nfa, AbstractElement token) {
			return new SerializerPDAState(token);
		}

		public void setFollowers(SerializerPDA nfa, SerializerPDAState owner, Iterable<SerializerPDAState> followers) {
			owner.followers = Lists.newArrayList(followers);
		}
	}

	protected static class SerializerPDAState implements ISerState {
		protected List<SerializerPDAState> followers;
		protected AbstractElement grammarElement;
		protected RuleCall pop;
		protected RuleCall push;

		public SerializerPDAState(AbstractElement grammarElement) {
			this(grammarElement, null, null);
		}

		public SerializerPDAState(AbstractElement grammarElement, RuleCall pop, RuleCall push) {
			super();
			this.grammarElement = grammarElement;
			this.push = push;
			this.pop = pop;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			SerializerPDAState s = (SerializerPDAState) obj;
			return grammarElement == s.grammarElement && pop == s.pop && push == s.push;
		}

		public List<SerializerPDAState> getFollowers() {
			return followers;
		}

		public AbstractElement getGrammarElement() {
			return grammarElement;
		}

		@Override
		public int hashCode() {
			int r = grammarElement != null ? grammarElement.hashCode() : 0;
			if (pop != null)
				r *= 7;
			if (push != null)
				r *= 13;
			return r;
		}

		@Override
		public String toString() {
			String p = pop != null && push != null ? "<>" : (pop != null ? "<<" : (push != null ? ">>" : ""));
			return p + new GrammarElementTitleSwitch().hideCardinality().showQualified().apply(grammarElement);
		}
	}

	protected Map<Pair<EObject, EClass>, Pda<? extends ISerState, RuleCall>> cache = Maps.newHashMap();

	protected SerializerCfg cfg;

	protected Pda<? extends ISerState, RuleCall> createPDA(EObject context, EClass type) {
		SerializerFollowerFunction ff = new SerializerFollowerFunction(cfg, context, type);
		return new PdaUtil().create(cfg, ff, new SerializerPDAFactory());
	}

	public Pda<? extends ISerState, RuleCall> getPDA(EObject context, EClass type) {
		Pair<EObject, EClass> key = Tuples.create(context, type);
		Pda<? extends ISerState, RuleCall> result = cache.get(key);
		if (result == null)
			cache.put(key, result = createPDA(context, type));
		return result;
	}

	@Inject
	protected void setGrammarAccess(IGrammarAccess ga) {
		this.cfg = new SerializerCfg(ga.getGrammar());
	}

}
