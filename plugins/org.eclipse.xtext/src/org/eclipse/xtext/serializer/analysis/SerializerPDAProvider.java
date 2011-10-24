/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collections;
import java.util.List;
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
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class SerializerPDAProvider implements ISerializerPDAProvider {

	protected static class SerializerCfg extends CfgAdapter {
		protected EObject context;

		public SerializerCfg(EObject context) {
			super(GrammarUtil.getGrammar(context));
			this.context = context;
		}

		@Override
		public AbstractElement getRoot() {
			if (context instanceof AbstractRule)
				return ((AbstractRule) context).getAlternatives();
			if (context instanceof Action)
				return GrammarUtil.containingRule(context).getAlternatives();
			return super.getRoot();
		}

		@Override
		public AbstractElement getCall(AbstractElement ele) {
			if (ele instanceof RuleCall && !GrammarUtil.isAssigned(ele)
					&& ((RuleCall) ele).getRule().getType().getClassifier() instanceof EClass)
				return ((RuleCall) ele).getRule().getAlternatives();
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
					if (actionCtx == null
							|| (GrammarUtil.containingRule(actionCtx) != GrammarUtil.containingRule(element)))
						result.add(null);
				} else if (actionCtx == ele)
					result.add(null);
				else if (ele instanceof Action) {
					Action a = (Action) ele;
					if (type != null && a.getFeature() == null && a.getType().getClassifier() == type)
						result.add(ele);
				} else if (type != null || !GrammarUtil.isAssigned(ele))
					result.add(ele);
			return result;
		}

		@Override
		public Iterable<AbstractElement> getStarts(AbstractElement root) {
			Set<AbstractElement> result = Sets.newLinkedHashSet();
			for (Action act : GrammarUtil.containedActions(root))
				if (type != null && act.getFeature() != null && act.getType().getClassifier() == type)
					result.add(act);
			for (AbstractElement ele : super.getStarts(root))
				if (ele == null) {
					if (actionCtx == null
							|| (GrammarUtil.containingRule(actionCtx) != GrammarUtil.containingRule(root)))
						result.add(null);
				} else if (actionCtx == ele) {
					result.add(null);
				} else if (!GrammarUtil.isAssignedAction(ele)
						&& typeMatches(ele, Sets.<AbstractElement> newHashSet()) != Boolean.FALSE)
					result.add(ele);
			return result;
		}

		protected Boolean typeMatches(AbstractElement ele, Set<AbstractElement> visited) {
			if (!visited.add(ele))
				return null;
			if (ele instanceof Action)
				return type != null && ((Action) ele).getType().getClassifier() == type;
			if (GrammarUtil.isAssigned(ele))
				return type != null && GrammarUtil.containingRule(ele).getType().getClassifier() == type;
			else if (GrammarUtil.isEObjectRuleCall(ele))
				for (Action act : GrammarUtil.containedActions(((RuleCall) ele).getRule().getAlternatives()))
					if (act.getFeature() != null && act.getType().getClassifier() == type)
						return true;
			boolean allFalse = true;
			for (AbstractElement f : GrammarUtil.isEObjectRuleCall(ele) && !GrammarUtil.isAssigned(ele) ? super
					.getStarts(((RuleCall) ele).getRule().getAlternatives()) : super.getFollowers(ele))
				if (f != null) {
					Boolean r = typeMatches(f, visited);
					if (r == Boolean.TRUE)
						return true;
					if (r == null)
						allFalse = false;
				} else if (type == null)
					allFalse = false;
			return allFalse ? false : null;
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
			return state.type == SerStateType.POP ? (RuleCall) state.grammarElement : null;
		}

		public RuleCall getPush(SerializerPDAState state) {
			return state.type == SerStateType.PUSH ? (RuleCall) state.grammarElement : null;
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
			SerializerPDAState s1 = new SerializerPDAState(start, SerStateType.START);
			SerializerPDAState s2 = new SerializerPDAState(stop, SerStateType.STOP);
			return new SerializerPDA(s1, s2);
		}

		public SerializerPDAState createPop(SerializerPDA pda, AbstractElement token) {
			return new SerializerPDAState(token, SerStateType.POP);
		}

		public SerializerPDAState createPush(SerializerPDA pda, AbstractElement token) {
			return new SerializerPDAState(token, SerStateType.PUSH);
		}

		public SerializerPDAState createState(SerializerPDA nfa, AbstractElement token) {
			return new SerializerPDAState(token, SerStateType.ELEMENT);
		}

		public void setFollowers(SerializerPDA nfa, SerializerPDAState owner, Iterable<SerializerPDAState> followers) {
			owner.followers = Lists.newArrayList(followers);
		}
	}

	protected static class SerializerPDAState implements ISerState {
		protected List<SerializerPDAState> followers = Collections.emptyList();
		protected AbstractElement grammarElement;
		protected SerStateType type;

		public SerializerPDAState(AbstractElement grammarElement, SerStateType type) {
			super();
			this.type = type;
			this.grammarElement = grammarElement;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			SerializerPDAState s = (SerializerPDAState) obj;
			return grammarElement == s.grammarElement && type == s.type;
		}

		public List<SerializerPDAState> getFollowers() {
			return followers;
		}

		public AbstractElement getGrammarElement() {
			return grammarElement;
		}

		public SerStateType getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return (grammarElement != null ? grammarElement.hashCode() : 1) * type.hashCode();
		}

		@Override
		public String toString() {
			GrammarElementTitleSwitch fmt = new GrammarElementTitleSwitch().hideCardinality().showQualified();
			switch (type) {
				case ELEMENT:
					return fmt.apply(grammarElement);
				case POP:
					return "<<" + fmt.apply(grammarElement);
				case PUSH:
					return ">>" + fmt.apply(grammarElement);
				case START:
					return "start";
				case STOP:
					return "stop";
			}
			return "";
		}
	}

	protected Map<Pair<EObject, EClass>, Pda<? extends ISerState, RuleCall>> cache = Maps.newHashMap();

	protected Pda<? extends ISerState, RuleCall> createPDA(EObject context, EClass type) {
		SerializerCfg cfg = new SerializerCfg(context);
		SerializerFollowerFunction ff = new SerializerFollowerFunction(cfg, context, type);
		Pda<? extends ISerState, RuleCall> pda = new PdaUtil().create(cfg, ff, new SerializerPDAFactory());
		new NfaUtil().removeOrphans(pda);
		return pda;
	}

	public Pda<? extends ISerState, RuleCall> getPDA(EObject context, EClass type) {
		Pair<EObject, EClass> key = Tuples.create(context, type);
		Pda<? extends ISerState, RuleCall> result = cache.get(key);
		if (result == null)
			cache.put(key, result = createPDA(context, type));
		return result;
	}

}
