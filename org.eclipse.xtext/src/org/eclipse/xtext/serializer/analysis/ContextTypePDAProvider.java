/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.SerializationContext.TypeContext;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDACloneFactory;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaUtil;
import org.eclipse.xtext.util.formallang.Traverser;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class ContextTypePDAProvider implements IContextTypePDAProvider {

	protected static abstract class AbstractTypeTraverser implements Traverser<Pda<ISerState, RuleCall>, ISerState, FilterState> {

		@Override
		public FilterState enter(Pda<ISerState, RuleCall> pda, ISerState state, FilterState previous) {
			switch (state.getType()) {
				case ELEMENT:
					if (previous.type == null) {
						EClass cls = getInstantiatedType(state.getGrammarElement());
						if (cls != null)
							return enterType(state, previous, previous.stack, cls);
					} else if (state.getGrammarElement() instanceof Action)
						return null;
					return new FilterState(previous, previous.type, previous.stack, state);
				case POP:
					if (previous.stack != null && state.getGrammarElement() == previous.stack.rc)
						return new FilterState(previous, previous.type, previous.stack.parent, state);
					return null;
				case PUSH:
					RuleCall rc = (RuleCall) state.getGrammarElement();
					if (previous.type == null) {
						EClass cls = getInstantiatedType(rc);
						if (cls != null)
							return enterType(state, previous, new StackItem(previous.stack, rc), cls);
					}
					return new FilterState(previous, previous.type, new StackItem(previous.stack, rc), state);
				case START:
					return new FilterState(previous, null, null, state);
				case STOP:
					if (previous.stack == null)
						return previous;
					return null;
			}
			return null;
		}

		protected abstract FilterState enterType(ISerState state, FilterState previous, StackItem stack, EClass newType);

		protected EClass getInstantiatedType(AbstractElement element) {
			TypeRef type = null;
			if (GrammarUtil.isAssigned(element) || GrammarUtil.isEObjectFragmentRuleCall(element)) {
				type = GrammarUtil.containingRule(element).getType();
			} else if (element instanceof Action) {
				type = ((Action) element).getType();
			}
			if (type != null) {
				EClassifier classifier = type.getClassifier();
				if (classifier instanceof EClass && !classifier.eIsProxy()) {
					return (EClass) classifier;
				}
			}
			return null;
		}

		@Override
		public boolean isSolution(FilterState result) {
			return true;
		}

	}

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

	protected static class TypeCollector extends AbstractTypeTraverser {
		final protected Set<EClass> types = Sets.newLinkedHashSet();

		@Override
		protected FilterState enterType(ISerState state, FilterState previous, StackItem stack, EClass newType) {
			types.add(newType);
			return null;
		}

		public Set<EClass> getTypes() {
			return types;
		}

		@Override
		public boolean isSolution(FilterState result) {
			types.add(null);
			return false;
		}

	}

	protected static class TypeFilter extends AbstractTypeTraverser {
		final protected EClass type;

		public TypeFilter(EClass type) {
			super();
			this.type = type;
		}

		@Override
		protected FilterState enterType(ISerState state, FilterState previous, StackItem stack, EClass newType) {
			if (newType == type)
				return new FilterState(previous, type, stack, state);
			return null;
		}

		@Override
		public boolean isSolution(FilterState result) {
			return result.type == type;
		}

	}

	private static Logger LOG = Logger.getLogger(ContextTypePDAProvider.class);

	private Map<Grammar, Map<ISerializationContext, Pda<ISerState, RuleCall>>> cache = Maps.newHashMap();

	@Inject
	protected SerializerPDACloneFactory factory;

	@Inject
	protected IContextPDAProvider pdaProvider;

	@Inject
	protected PdaUtil pdaUtil;

	protected Set<EClass> collectTypes(Pda<ISerState, RuleCall> contextPda) {
		TypeCollector collector = newTypeCollector();
		pdaUtil.filterEdges(contextPda, collector, null);
		return collector.getTypes();
	}

	protected Pda<ISerState, RuleCall> filterByType(Pda<ISerState, RuleCall> contextPda, EClass type) {
		TypeFilter typeFilter = newTypeFilter(type);
		SerializerPDA pda = pdaUtil.filterEdges(contextPda, typeFilter, factory);
		return pda;
	}

	@Override
	public Map<ISerializationContext, Pda<ISerState, RuleCall>> getContextTypePDAs(Grammar grammar) {
		Map<ISerializationContext, Pda<ISerState, RuleCall>> result = cache.get(grammar);
		if (result != null)
			return result;
		result = Maps.newLinkedHashMap();
		cache.put(grammar, result);
		Map<ISerializationContext, Pda<ISerState, RuleCall>> contextPDAs = pdaProvider.getContextPDAs(grammar);
		for (Entry<ISerializationContext, Pda<ISerState, RuleCall>> e : contextPDAs.entrySet()) {
			ISerializationContext parent = e.getKey();
			Pda<ISerState, RuleCall> contextPDA = e.getValue();
			try {
				Set<EClass> types = collectTypes(contextPDA);
				if (types.size() == 1) {
					TypeContext ctx = new TypeContext(parent, types.iterator().next());
					result.put(ctx, contextPDA);
				} else {
					for (EClass type : types) {
						TypeContext typeContext = new TypeContext(parent, type);
						Pda<ISerState, RuleCall> filtered = filterByType(contextPDA, type);
						result.put(typeContext, filtered);
					}
				}
			} catch (Exception x) {
				LOG.error("Error extracting PDAs for types for context '" + parent + "': " + x.getMessage(), x);
			}
		}
		return result;
	}

	protected TypeCollector newTypeCollector() {
		return new TypeCollector();
	}

	protected TypeFilter newTypeFilter(EClass type) {
		return new TypeFilter(type);
	}
}