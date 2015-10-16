/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class SerializationContext implements ISerializationContext {

	public static class ActionContext extends SerializationContext {

		private final Action action;

		public ActionContext(ISerializationContext parent, Action action) {
			super(parent);
			this.action = action;
		}

		@Override
		public Action getAssignedAction() {
			return action;
		}

		@Override
		protected String toStringInternal() {
			return new Context2NameFunction().getUniqueActionName(action);
		}
	}

	public static class ParameterValueContext extends SerializationContext {

		private final Set<Parameter> parameters;

		public ParameterValueContext(ISerializationContext parent, Set<Parameter> parameters) {
			super(parent);
			this.parameters = ImmutableSet.copyOf(parameters);
		}

		@Override
		protected String toStringInternal() {
			List<String> names = Lists.newArrayList();
			for (Parameter p : parameters)
				names.add(p.getName());
			return Joiner.on("_").join(names);
		}

		@Override
		public Set<Parameter> getParameterValues() {
			return parameters;
		}

	}

	public static class RuleContext extends SerializationContext {

		private final ParserRule rule;

		public RuleContext(ISerializationContext parent, ParserRule rule) {
			super(parent);
			this.rule = rule;
		}

		@Override
		public ParserRule getParserRule() {
			return rule;
		}

		@Override
		protected String toStringInternal() {
			return rule.getName();
		}

	}

	public static class TypeContext extends SerializationContext {

		private final EClass type;

		protected TypeContext(ISerializationContext parent, EClass type) {
			super(parent);
			this.type = type;
		}

		@Override
		public EClass getType() {
			return type;
		}

		@Override
		protected String toStringInternal() {
			return type == null ? "null" : type.getName();
		}

	}

	public static ISerializationContext forChild(ISerializationContext container, AbstractElement assignedElement, EObject sem) {
		if (assignedElement instanceof Action)
			return forChild(container, (Action) assignedElement, sem);
		if (assignedElement instanceof RuleCall)
			return forChild(container, (RuleCall) assignedElement, sem);
		throw new IllegalStateException("Invalid Element:" + assignedElement);
	}

	public static ISerializationContext forChild(ISerializationContext container, Action assignedAction, EObject sem) {
		EClass type = sem == null ? null : sem.eClass();
		//		RuleContext ruleContext = new RuleContext(null, container.getParserRule());
		return new TypeContext(new ActionContext(/*ruleContext*/null, assignedAction), type);
	}

	public static ISerializationContext forChild(ISerializationContext container, RuleCall ruleCall, EObject sem) {
		EClass type = sem == null ? null : sem.eClass();
		return new TypeContext(new RuleContext(null, (ParserRule) ruleCall.getRule()), type);
	}

	public static ISerializationContext fromEObject(EObject ctx, EObject sem) {
		EClass type = sem == null ? null : sem.eClass();
		if (ctx instanceof ParserRule)
			return new TypeContext(new RuleContext(null, (ParserRule) ctx), type);
		else if (ctx instanceof Action)
			return new TypeContext(new ActionContext(null, (Action) ctx), type);
		else if (ctx == null)
			throw new NullPointerException("context is null");
		throw new IllegalStateException("Unknonwn context type:" + ctx.eClass().getName());
	}

	public static List<ISerializationContext> fromEObjects(Iterable<EObject> objects, EObject sem) {
		if (objects == null)
			return null;
		List<ISerializationContext> result = Lists.newArrayList();
		for (EObject ctx : objects)
			result.add(fromEObject(ctx, sem));
		return result;
	}

	public static List<EObject> fromIContexts(Iterable<ISerializationContext> ctxs) {
		if (ctxs == null)
			return null;
		List<EObject> result = Lists.newArrayList();
		for (ISerializationContext ctx : ctxs)
			result.add(ctx.getActionOrRule());
		return result;
	}

	public static <T> List<Pair<List<ISerializationContext>, T>> groupByEqualityAndSort(Map<ISerializationContext, T> items) {
		SetMultimap<ISerializationContext, T> byContext = Multimaps.forMap(items);
		ArrayListMultimap<T, ISerializationContext> byT = Multimaps.invertFrom(byContext, ArrayListMultimap.<T, ISerializationContext> create());
		List<Pair<List<ISerializationContext>, T>> result = Lists.newArrayList();
		for (Entry<T, Collection<ISerializationContext>> e : byT.asMap().entrySet()) {
			T t = e.getKey();
			@SuppressWarnings("serial")
			List<ISerializationContext> contexts = new ArrayList<ISerializationContext>() {
				@Override
				public String toString() {
					return Joiner.on(", ").join(this);
				}
			};
			contexts.addAll(e.getValue());
			Collections.sort(contexts);
			result.add(Tuples.create(contexts, t));
		}
		Collections.sort(result, new Comparator<Pair<List<ISerializationContext>, T>>() {
			@Override
			public int compare(Pair<List<ISerializationContext>, T> o1, Pair<List<ISerializationContext>, T> o2) {
				return o1.getFirst().get(0).compareTo(o2.getFirst().get(0));
			}
		});
		return result;
	}

	private final ISerializationContext parent;

	protected SerializationContext(ISerializationContext parent) {
		super();
		this.parent = parent;
	}

	@Override
	public int compareTo(ISerializationContext o) {
		EObject o1 = getActionOrRule();
		EObject o2 = o.getActionOrRule();
		if (o1 != o2) {
			GrammarElementDeclarationOrder order = GrammarElementDeclarationOrder.get(GrammarUtil.getGrammar(o1));
			int compare = order.compare(o1, o2);
			if (compare != 0)
				return compare;
		}
		EClass t1 = getType();
		EClass t2 = o.getType();
		if (t1 != t2) {
			if (t1 != null && t2 != null) {
				int compare = t1.getName().compareTo(t2.getName());
				if (compare != 0)
					return compare;
			}
			if (t1 != null)
				return -1;
			if (t2 != null)
				return 1;
		}
		ISerializationContext p1 = getParent();
		ISerializationContext p2 = o.getParent();
		if (p1 != p2) {
			if (p1 != null && p2 != null)
				return p1.compareTo(p2);
			if (p1 != null)
				return -1;
			if (p2 != null)
				return 1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ISerializationContext))
			return false;
		if (obj == this)
			return true;
		ISerializationContext other = (ISerializationContext) obj;
		if (!Objects.equal(getParserRule(), other.getParserRule()))
			return false;
		if (!Objects.equal(getAssignedAction(), other.getAssignedAction()))
			return false;
		if (!Objects.equal(getParameterValues(), other.getParameterValues()))
			return false;
		if (!Objects.equal(getType(), other.getType()))
			return false;
		return true;
	}

	@Override
	public EObject getActionOrRule() {
		Action action = getAssignedAction();
		return action != null ? action : getParserRule();
	}

	@Override
	public Action getAssignedAction() {
		return parent != null ? parent.getAssignedAction() : null;
	}

	@Override
	public ISerializationContext getParent() {
		return parent;
	}

	@Override
	public ParserRule getParserRule() {
		return parent != null ? parent.getParserRule() : null;
	}

	@Override
	public EClass getType() {
		return parent != null ? parent.getType() : null;
	}

	@Override
	public Set<Parameter> getParameterValues() {
		return parent != null ? parent.getParameterValues() : null;
	}

	@Override
	public int hashCode() {
		ParserRule rule = getParserRule();
		Action action = getAssignedAction();
		Set<Parameter> parameterValues = getParameterValues();
		EClass type = getType();
		int result = 1;
		if (rule != null)
			result *= rule.hashCode();
		if (action != null)
			result *= action.hashCode() * 7;
		if (type != null)
			result *= type.hashCode() * 19;
		if (parameterValues != null)
			result *= parameterValues.hashCode() * 31;
		return result;
	}

	@Override
	public String toString() {
		if (parent == null) {
			return toStringInternal();
		} else {
			return parent + "_" + toStringInternal();
		}
	}

	abstract protected String toStringInternal();

}
