/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDACloneFactory;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaUtil;
import org.eclipse.xtext.util.formallang.Traverser;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class ContextTypePDAProvider implements IContextTypePDAProvider {

	protected static class FilterState {
		final protected FilterState previous;
		final protected StackItem stack;
		final protected ISerState state;
		final protected EClass type;

		public FilterState(FilterState previous, EClass type, StackItem stack, ISerState state) {
			super();
			this.previous = previous;
			this.type = type;
			this.stack = stack;
			this.state = state;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			FilterState other = (FilterState) obj;
			if (type != other.type || state != other.state)
				return false;
			if (stack == null)
				return other.stack == null;
			return stack.equals(other.stack);
		}

		@Override
		public int hashCode() {
			int r = state.getType().hashCode();
			if (state.getGrammarElement() != null)
				r *= state.getGrammarElement().hashCode();
			if (type != null)
				r *= type.hashCode() * 7;
			if (stack != null)
				r *= stack.rc.hashCode() * 13;
			return r;
		}
	}

	protected static class StackItem {
		final protected StackItem parent;
		final protected RuleCall rc;

		public StackItem(StackItem parent, RuleCall rc) {
			super();
			this.parent = parent;
			this.rc = rc;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			StackItem current1 = this;
			StackItem current2 = (StackItem) obj;
			int count = 0;
			while (true) {
				if (current1 == null && current2 == null)
					return true;
				if (current1 == null || current2 == null)
					return false;
				if (current1.rc != current2.rc)
					return false;
				if (current1 != this && current1.rc == this.rc)
					count++;
				if (count > 0)
					return true;
				current1 = current1.parent;
				current2 = current2.parent;
			}
		}

		@Override
		public int hashCode() {
			return rc.hashCode();
		}
	}

	protected static class TypeFilter implements Traverser<Pda<ISerState, RuleCall>, ISerState, FilterState> {
		final protected EClass type;

		public TypeFilter(EClass type) {
			super();
			this.type = type;
		}

		@Override
		public FilterState enter(Pda<ISerState, RuleCall> pda, ISerState state, FilterState previous) {
			switch (state.getType()) {
				case ELEMENT:
					if (previous.type == null) {
						Assignment ass = GrammarUtil.containingAssignment(state.getGrammarElement());
						if (ass != null) {
							TypeRef returnType = GrammarUtil.containingRule(ass).getType();
							EClassifier cls = returnType != null ? returnType.getClassifier() : null;
							if (cls == type)
								return new FilterState(previous, type, previous.stack, state);
							return null;
						}
						if (state.getGrammarElement() instanceof Action) {
							EClassifier cls = ((Action) state.getGrammarElement()).getType().getClassifier();
							if (cls == type)
								return new FilterState(previous, type, previous.stack, state);
							return null;
						}
					} else if (state.getGrammarElement() instanceof Action)
						return null;
					return new FilterState(previous, previous.type, previous.stack, state);
				case POP:
					if (previous.stack != null && state.getGrammarElement() == previous.stack.rc)
						return new FilterState(previous, previous.type, previous.stack.parent, state);
					return null;
				case PUSH:
					RuleCall rc = (RuleCall) state.getGrammarElement();
					return new FilterState(previous, previous.type, new StackItem(previous.stack, rc), state);
				case START:
					return new FilterState(previous, null, null, state);
				case STOP:
					if (previous.type == type && previous.stack == null)
						return previous;
					return null;
			}
			return null;
		}

		@Override
		public boolean isSolution(FilterState result) {
			return true;
		}

	}

	protected Map<Pair<EObject, EClass>, Pda<ISerState, RuleCall>> cache = Maps.newHashMap();
	@Inject
	protected IContextProvider contextProvider;

	@Inject
	protected IContextPDAProvider pdaProvider;

	protected Pda<ISerState, RuleCall> createPDA(EObject context, EClass type) {
		Pda<ISerState, RuleCall> contextPda = pdaProvider.getContextPDA(context);
		Pda<ISerState, RuleCall> contextTypePda = null;
		if (contextProvider.getTypesForContext(context).size() > 1) {
			TypeFilter typeFilter = newTypeFilter(type);
			SerializerPDACloneFactory factory = new SerializerPDACloneFactory();
			contextTypePda = new PdaUtil().filterEdges(contextPda, typeFilter, factory);
		} else
			contextTypePda = contextPda;
		return contextTypePda;
	}

	@Override
	public Pda<ISerState, RuleCall> getContextTypePDA(EObject context, EClass type) {
		Pair<EObject, EClass> key = Tuples.create(context, type);
		Pda<ISerState, RuleCall> result = cache.get(key);
		if (result == null)
			cache.put(key, result = createPDA(context, type));
		return result;
	}

	protected TypeFilter newTypeFilter(EClass type) {
		return new TypeFilter(type);
	}
}