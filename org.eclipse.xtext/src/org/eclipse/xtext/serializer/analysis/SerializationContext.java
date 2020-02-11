/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.xtext.ConditionEvaluator;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

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

	}

	public static class ParameterValueContext extends SerializationContext {

		private final Set<Parameter> parameters;

		public ParameterValueContext(ISerializationContext parent, Set<Parameter> parameters) {
			super(parent);
			Preconditions.checkNotNull(parent);
			ParserRule rule = parent.getParserRule();
			if (rule != null) {
				List<Parameter> supportedParameters = ((SerializationContext) parent).getDeclaredParameters();
				Preconditions.checkArgument(supportedParameters.containsAll(parameters));
			}
			this.parameters = ImmutableSet.copyOf(parameters);
		}

		@Override
		protected Set<Parameter> getEnabledBooleanParametersInternal() {
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
		protected String getTypeString() {
			return type != null ? type.getName() : "null";
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
		ISerializationContext context = new TypeContext(new ActionContext(/*ruleContext*/null, assignedAction), type);
		if (container != null) {
			Set<Parameter> params = container.getEnabledBooleanParameters();
			if (!params.isEmpty())
				context = new ParameterValueContext(context, params);
		}
		return context;
	}

	public static ISerializationContext forChild(ISerializationContext container, RuleCall ruleCall, EObject sem) {
		EClass type = sem == null ? null : sem.eClass();
		ISerializationContext result = new TypeContext(new RuleContext(null, (ParserRule) ruleCall.getRule()), type);
		EList<NamedArgument> arguments = ruleCall.getArguments();
		if (!arguments.isEmpty() && container != null) {
			Set<Parameter> params = Sets.newLinkedHashSet();
			ConditionEvaluator evaluator = new ConditionEvaluator(container.getEnabledBooleanParameters());
			for (NamedArgument argument : arguments) {
				if (evaluator.evaluate(argument.getValue())) {
					params.add(argument.getParameter());
				}
			}
			result = new SerializationContext.ParameterValueContext(result, params);
		}
		return result;
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
			result.add(((SerializationContext) ctx).getActionOrRule());
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
		EObject o2 = ((SerializationContext) o).getActionOrRule();
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
		List<Parameter> params = getDeclaredParameters();
		if (params.equals(((SerializationContext) o).getDeclaredParameters())) {
			Set<Parameter> v1 = getEnabledBooleanParameters();
			Set<Parameter> v2 = o.getEnabledBooleanParameters();
			if (v1 == null || v2 == null) {
				return v1 != null ? -1 : 1;
			} else {
				for (Parameter param : params) {
					boolean b1 = v1.contains(param);
					boolean b2 = v2.contains(param);
					if (b1 != b2) {
						return b1 ? -1 : 1;
					}
				}
			}
		}
		ISerializationContext p1 = getParent();
		ISerializationContext p2 = ((SerializationContext) o).getParent();
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
		boolean eq1 = equalsInternal(other);
		//		boolean eq2 = toString().equals(other.toString());
		//		if (eq1 != eq2)
		//			System.out.println("Foo");
		return eq1;
	}

	private boolean equalsInternal(ISerializationContext other) {
		if (!Objects.equal(getParserRule(), other.getParserRule()))
			return false;
		if (!Objects.equal(getAssignedAction(), other.getAssignedAction()))
			return false;
		if (!Objects.equal(getEnabledBooleanParameters(), other.getEnabledBooleanParameters()))
			return false;
		if (!Objects.equal(getType(), other.getType()))
			return false;
		return true;
	}

	public EObject getActionOrRule() {
		Action action = getAssignedAction();
		return action != null ? action : getParserRule();
	}

	@Override
	public Action getAssignedAction() {
		return parent != null ? parent.getAssignedAction() : null;
	}

	public List<Parameter> getDeclaredParameters() {
		ParserRule declarator = getParameterDeclarator();
		return declarator == null ? Collections.<Parameter> emptyList() : declarator.getParameters();
	}

	@Override
	public final Set<Parameter> getEnabledBooleanParameters() {
		Set<Parameter> parameters = getEnabledBooleanParametersInternal();
		return parameters != null ? parameters : Collections.<Parameter> emptySet();
	}

	protected Set<Parameter> getEnabledBooleanParametersInternal() {
		return parent != null ? ((SerializationContext) parent).getEnabledBooleanParametersInternal() : null;
	}

	public ParserRule getParameterDeclarator() {
		Action action = getAssignedAction();
		if (action != null) {
			return GrammarUtil.containingParserRule(action);
		}
		ParserRule rule = getParserRule();
		if (rule != null) {
			return rule;
		}
		return null;
	}

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

	protected String getTypeString() {
		return parent != null ? ((SerializationContext) parent).getTypeString() : null;
	}

	@Override
	public int hashCode() {
		ParserRule rule = getParserRule();
		Action action = getAssignedAction();
		Set<Parameter> parameterValues = getEnabledBooleanParameters();
		EClass type = getType();
		int result = 1;
		if (rule != null)
			result = 31 * result + rule.hashCode();
		if (action != null)
			result = 31 * result + action.hashCode();
		if (type != null)
			result = 31 * result + type.hashCode();
		if (parameterValues != null)
			result = 31 * result + parameterValues.hashCode();
		return result;
	}

	@Override
	public String toString() {
		ParserRule rule = getParserRule();
		Action action = getAssignedAction();
		Set<Parameter> parameterValues = getEnabledBooleanParameters();
		String type = getTypeString();
		StringBuilder builder = new StringBuilder();
		if (action != null) {
			builder.append(GrammarUtil.containingRule(action).getName());
			builder.append(".");
			builder.append(new Context2NameFunction().getUniqueActionName(action));
		} else if (rule != null) {
			builder.append(rule.getName());
		} else {
			builder.append("???");
		}
		if (parameterValues != null && !parameterValues.isEmpty()) {
			List<String> names = Lists.newArrayList();
			List<Parameter> declared = getDeclaredParameters();
			for (Parameter p : parameterValues) {
				if (declared.contains(p)) {
					names.add(p.getName());
				} else {
					names.add(((AbstractRule) p.eContainer()).getName() + "." + p.getName());
				}
			}
			builder.append("<");
			builder.append(Joiner.on(",").join(names));
			builder.append(">");
		}
		if (type != null) {
			builder.append(" returns ");
			builder.append(type);
		}
		return builder.toString();
	}

}
