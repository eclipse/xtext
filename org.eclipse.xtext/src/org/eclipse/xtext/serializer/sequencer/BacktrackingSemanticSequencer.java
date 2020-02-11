/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider.ISemState;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.ISemanticNode;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaUtil;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class BacktrackingSemanticSequencer extends AbstractSemanticSequencer {

	public static class FollowerSorter implements Comparator<ISemState> {

		protected EObject nodeModelEle;

		protected SerializableObject obj;

		public FollowerSorter(SerializableObject obj, AbstractElement nodeModelEle) {
			super();
			this.obj = obj;
			this.nodeModelEle = nodeModelEle;
		}

		@Override
		public int compare(ISemState o1, ISemState o2) {
			if (nodeModelEle != null) {
				if (o1.getAssignedGrammarElement() == nodeModelEle)
					return -1;
				if (o2.getAssignedGrammarElement() == nodeModelEle)
					return 1;
			}
			if (o1.getAssignedGrammarElement() == null && o2.getAssignedGrammarElement() == null)
				return 0;
			if (o1.getAssignedGrammarElement() == null)
				return -1;
			if (o2.getAssignedGrammarElement() == null)
				return 1;
			boolean o1Opt = obj.isOptional(o1.getFeatureID());
			boolean o2Opt = obj.isOptional(o2.getFeatureID());
			if (o1Opt && !o2Opt)
				return 1;
			if (o2Opt && !o1Opt)
				return -1;
			int o1Cnt = obj.getValueCount(o1.getFeatureID());
			int o2Cnt = obj.getValueCount(o2.getFeatureID());
			if (o1Cnt == 0 && o2Cnt > 0)
				return 1;
			if (o2Cnt == 0 && o1Cnt > 0)
				return -1;
			int o1id = o1.getOrderID();
			int o2id = o2.getOrderID();
			return o1id < o2id ? -1 : o1id > o2id ? 1 : 0;
		}

	}

	public class SerializableObject {
		protected final EObject eObject;
		protected final ISerializationContext context;
		protected List<ISemanticNode>[] nodes;
		protected final ISemanticNode firstNode;
		protected boolean[] optional;
		protected Map<Pair<AbstractElement, Integer>, Boolean> valid = Maps.newHashMap();
		protected Object[] values;

		@SuppressWarnings("unchecked")
		public SerializableObject(ISerializationContext context, EObject eObject,
				INodesForEObjectProvider nodeProvider) {
			super();
			this.eObject = eObject;
			this.context = context;
			this.firstNode = nodeProvider.getFirstSemanticNode();
			EClass clazz = eObject.eClass();
			values = new Object[clazz.getFeatureCount()];
			nodes = new List[clazz.getFeatureCount()];
			optional = new boolean[clazz.getFeatureCount()];
			for (EStructuralFeature feature : eObject.eClass().getEAllStructuralFeatures()) {
				int featureID = eObject.eClass().getFeatureID(feature);
				if (feature.isMany())
					switch (transientValues.isListTransient(eObject, feature)) {
					case NO:
						List<ISemanticNode> nodes1 = Lists.newArrayList();
						List<?> values1;
						if (feature instanceof EReference && ((EReference) feature).isResolveProxies()) {
							values1 = ((InternalEList<?>) eObject.eGet(feature)).basicList();
						} else {
							values1 = (List<?>) eObject.eGet(feature);
						}
						for (int i = 0; i < values1.size(); i++)
							nodes1.add(nodeProvider.getSemanticNodeForMultiValue(feature, i, i, values1.get(i)));
						values[featureID] = values1;
						nodes[featureID] = nodes1;
						break;
					case SOME:
						List<ISemanticNode> nodes2 = Lists.newArrayList();
						List<?> values2;
						if (feature instanceof EReference && ((EReference) feature).isResolveProxies()) {
							values2 = ((InternalEList<?>) eObject.eGet(feature)).basicList();
						} else {
							values2 = (List<?>) eObject.eGet(feature);
						}
						List<Object> values3 = Lists.newArrayList();
						for (int i = 0, j = 0; i < values2.size(); i++)
							if (!transientValues.isValueInListTransient(eObject, i, feature)) {
								Object value = values2.get(i);
								ISemanticNode node = nodeProvider.getSemanticNodeForMultiValue(feature, i, j++, value);
								values3.add(value);
								nodes2.add(node);
							}
						values[featureID] = values3;
						nodes[featureID] = nodes2;
						break;
					case YES:
						values[featureID] = INVALID;
					}
				else
					switch (transientValues.isValueTransient(eObject, feature)) {
					case PREFERABLY:
						optional[featureID] = true;
						Object value1 = eObject.eGet(feature, false);
						values[featureID] = value1;
						nodes[featureID] = Collections
								.singletonList(nodeProvider.getSemanticNodeForSingelValue(feature, value1));
						break;
					case NO:
						Object value2 = eObject.eGet(feature, false);
						values[featureID] = value2;
						nodes[featureID] = Collections
								.singletonList(nodeProvider.getSemanticNodeForSingelValue(feature, value2));
						break;
					case YES:
						values[featureID] = INVALID;
					}
			}
		}

		public EObject getEObject() {
			return eObject;
		}

		public ISemanticNode getFirstNode() {
			return firstNode;
		}

		public ISemanticNode getNode(int featureID, int index) {
			List<ISemanticNode> featureNodes = nodes[featureID];
			if (featureNodes != null && index >= 0 && index < featureNodes.size())
				return featureNodes.get(index);
			return null;
		}

		public Object getValue(ISemState state, int index) {
			Object value = values[state.getFeatureID()];
			if (value instanceof List<?>)
				value = ((List<?>) value).get(index);
			if (!isValueValid(state, index, value))
				return INVALID;
			return value;
		}

		public int getValueCount(int featureID) {
			Object v = values[featureID];
			if (v == INVALID)
				return 0;
			else if (v instanceof List<?>)
				return ((List<?>) v).size();
			return 1;
		}

		public String getValuesString() {
			List<String> items = Lists.newArrayList();
			for (int i = 0; i < values.length; i++) {
				int count = getValueCount(i);
				if (count > 0) {
					EStructuralFeature feature = eObject.eClass().getEStructuralFeature(i);
					String cnt = this.optional[i] ? "0-" + count : String.valueOf(count);
					items.add(feature.getName() + "(" + cnt + ")");
				}
			}
			return "Values: " + Joiner.on(", ").join(items);
		}

		public boolean isList(int featureID) {
			return values[featureID] instanceof List<?>;
		}

		public boolean isOptional(int featureID) {
			return optional[featureID];
		}

		protected boolean isValueValid(ISemState state, int index, Object value) {
			List<AbstractElement> candidates = state.getToBeValidatedAssignedElements();
			if (candidates.isEmpty())
				return true;

			Pair<AbstractElement, Integer> key = Tuples.create(state.getAssignedGrammarElement(), index);
			if (valid.get(key) == Boolean.TRUE)
				return true;

			ISemanticNode semanticNode = getNode(state.getFeatureID(), index);
			INode node = semanticNode == null ? null : semanticNode.getNode();
			Multimap<AbstractElement, ISerializationContext> assignments = ArrayListMultimap.create();
			for (AbstractElement ele : candidates)
				assignments.put(ele, context);
			Set<AbstractElement> found = assignmentFinder.findAssignmentsByValue(eObject, assignments, value, node);
			boolean result = found.contains(state.getAssignedGrammarElement());
			valid.put(key, result);
			return result;
		}

		@Override
		public String toString() {
			List<String> mandatory = Lists.newArrayList();
			List<String> optional = Lists.newArrayList();
			for (int i = 0; i < values.length; i++) {
				int count = getValueCount(i);
				if (count > 0) {
					EStructuralFeature feature = eObject.eClass().getEStructuralFeature(i);
					if (this.optional[i])
						optional.add(feature.getName() + "(" + count + ")");
					else
						mandatory.add(feature.getName() + "(" + count + ")");
				}
			}
			StringBuilder result = new StringBuilder();
			result.append("EObject: " + EmfFormatter.objPath(eObject) + "\n");
			result.append(getValuesString() + "\n");
			return result.toString();
		}

	}

	protected static class TraceItem {
		protected int index;
		protected int[] nextIndex;
		protected ISemanticNode node;
		protected SerializableObject obj;
		protected TraceItem parent;
		protected ISemState state;
		protected Object value;

		public TraceItem(SerializableObject obj) {
			this(obj, new int[obj.getEObject().eClass().getFeatureCount()]);
		}

		public TraceItem(SerializableObject obj, int[] unconsumed) {
			super();
			this.obj = obj;
			this.nextIndex = unconsumed;
		}

		public boolean canEnter(ISemState state) {
			if (state.isBooleanAssignment() && !Boolean.TRUE.equals(obj.getValue(state, state.getFeatureID())))
				return false;
			for (int i = 0; i < nextIndex.length; i++)
				if (i != state.getFeatureID()) {
					int count = nextIndex[i];
					if (count < obj.getValueCount(i)) {
						if (count == 0 && obj.isOptional(i))
							continue;
						if (!state.getAllFollowerFeatures().get(i))
							return false;
					}
				}
			return true;
		}

		public TraceItem clone(ISemState state) {
			TraceItem result = new TraceItem(obj, nextIndex);
			result.parent = this;
			result.state = state;
			result.value = value;
			result.index = index;
			result.node = node;
			return result;
		}

		public TraceItem cloneAndConsume(ISemState state) {
			int index = nextIndex[state.getFeatureID()];
			if (index >= obj.getValueCount(state.getFeatureID()))
				return null;
			Object value = obj.getValue(state, index);
			if (value == INVALID)
				return null;
			int[] unconsumedCopy = new int[nextIndex.length];
			System.arraycopy(nextIndex, 0, unconsumedCopy, 0, nextIndex.length);
			unconsumedCopy[state.getFeatureID()] = index + 1;
			TraceItem result = new TraceItem(obj, unconsumedCopy);
			result.parent = this;
			result.state = state;
			result.value = value;
			result.index = index;
			result.node = obj.getNode(state.getFeatureID(), index);
			return result;
		}

		public int getIndex() {
			return index;
		}

		public AbstractElement getNextGrammarElement() {
			ISemanticNode sem = null;
			if (obj != null && (parent == null || parent.parent == null)) {
				sem = obj.getFirstNode();
			} else if (node != null) {
				sem = node.getFollower();
			}
			if (sem != null) {
				return sem.getGrammarElement();
			}
			return null;
		}

		public INode getNode() {
			if (node == null)
				return null;
			return node.getNode();
		}

		public ICompositeNode getCompositeNode() {
			INode result = this.getNode();
			return result instanceof ICompositeNode ? (ICompositeNode) result : null;
		}

		public ILeafNode getLeafNode() {
			INode result = this.getNode();
			return result instanceof ILeafNode ? (ILeafNode) result : null;
		}

		public SerializableObject getObj() {
			return obj;
		}

		public TraceItem getParent() {
			return parent;
		}

		public ISemState getState() {
			return state;
		}

		public Object getValue() {
			return value;
		}

		public boolean isConsumed() {
			for (int i = 0; i < nextIndex.length; i++) {
				int count = nextIndex[i];
				if (count < obj.getValueCount(i)) {
					if (count != 0 || !obj.isOptional(i))
						return false;
				}
			}
			return true;
		}

		@Override
		public String toString() {
			List<String> mandatory = Lists.newArrayList();
			List<String> optional = Lists.newArrayList();
			List<String> consumed = Lists.newArrayList();
			for (int i = 0; i < nextIndex.length; i++) {
				int count = nextIndex[i];
				int max = obj.getValueCount(i);
				EStructuralFeature feature = obj.getEObject().eClass().getEStructuralFeature(i);
				if (count < max) {
					if (count == 0 && obj.isOptional(i))
						optional.add(feature.getName() + "(" + (max - count) + ")");
					else
						mandatory.add(feature.getName() + "(" + (max - count) + ")");
				} else if (max > 0)
					consumed.add(feature.getName() + "(" + count + ")");
			}
			StringBuilder result = new StringBuilder();
			result.append("State: " + state + "\n");
			result.append("EObject: " + EmfFormatter.objPath(obj.getEObject()) + "\n");
			result.append("Remaining Mandatory Values: " + Joiner.on(", ").join(mandatory) + "\n");
			result.append("Remaining Optional Values: " + Joiner.on(", ").join(optional) + "\n");
			result.append("Consumed Values: " + Joiner.on(", ").join(consumed) + "\n");
			return result.toString();
		}

	}

	protected static final Object INVALID = new Object();

	@Inject
	protected IAssignmentFinder assignmentFinder;

	@Inject
	private IGrammarConstraintProvider constraintProvider;

	@Inject
	protected TransientValueUtil transientValueUtil;

	protected void accept(TraceItem ti, SequenceFeeder feeder) {
		AbstractElement ele = ti.getState().getAssignedGrammarElement();
		if (ti.getState().getFeature().isMany()) {
			if (ele instanceof RuleCall)
				feeder.accept((RuleCall) ele, ti.getValue(), ti.getIndex(), ti.getNode());
			else if (ele instanceof Action)
				feeder.accept((Action) ele, (EObject) ti.getValue(), ti.getCompositeNode());
			else if (ele instanceof Keyword)
				feeder.accept((Keyword) ele, ti.getValue(), ti.getIndex(), ti.getLeafNode());
		} else {
			if (ele instanceof RuleCall)
				feeder.accept((RuleCall) ele, ti.getValue(), ti.getNode());
			else if (ele instanceof Action)
				feeder.accept((Action) ele, (EObject) ti.getValue(), ti.getCompositeNode());
			else if (ele instanceof Keyword)
				feeder.accept((Keyword) ele, ti.getValue(), ti.getLeafNode());
		}
	}

	protected Comparator<ISemState> createFollowerSorter(SerializableObject obj, AbstractElement nodeModelEle) {
		return new FollowerSorter(obj, nodeModelEle);
	}

	@Override
	@Deprecated
	public void createSequence(EObject context, final EObject obj) {
		createSequence(SerializationContext.fromEObject(context, obj), obj);
	}

	@Inject
	private IGrammarAccess grammar;

	@Override
	public void createSequence(ISerializationContext context, EObject obj) {
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(obj, null);
		SerializationContextMap<IConstraint> constraints = constraintProvider.getConstraints(grammar.getGrammar());
		IConstraint constraint = constraints.get(context);
		if (constraint == null)
			throw new IllegalStateException("Invalid context: " + context);
		Nfa<ISemState> nfa = constraint.getNfa();
		final SerializableObject object = new SerializableObject(context, obj, nodes);
		TraceItem co = new TraceItem(object);
		List<TraceItem> trace = new NfaUtil().backtrack(nfa, co, new NfaUtil.BacktrackHandler<ISemState, TraceItem>() {
			@Override
			public TraceItem handle(ISemState state, TraceItem previous) {
				if (!previous.canEnter(state))
					return null;
				if (state.getFeature() != null) {
					return previous.cloneAndConsume(state);
				} else
					return previous.clone(state);
			}

			@Override
			public boolean isSolution(TraceItem result) {
				return result.isConsumed();
			}

			@Override
			public Iterable<ISemState> sortFollowers(TraceItem result, Iterable<ISemState> followers) {
				AbstractElement next = result.getNextGrammarElement();
				List<ISemState> r = Lists.newArrayList(followers);
				Collections.sort(r, createFollowerSorter(object, next));
				return r;
			}
		});
		SequenceFeeder feeder = feederProvider.create(context, obj, nodes, masterSequencer, sequenceAcceptor,
				errorAcceptor);
		if (trace != null) {
			for (TraceItem ti : trace)
				if (ti.getState() != null && ti.getState().getFeature() != null)
					accept(ti, feeder);
		} else if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createBacktrackingFailedDiagnostic(object, context, constraint));
		feeder.finish();
	}

}
