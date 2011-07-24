/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider.ISemState;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.INfaAdapter;
import org.eclipse.xtext.util.formallang.NfaUtil;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class BacktrackingSemanticSequencer extends AbstractSemanticSequencer {

	protected class SerializableObject {
		protected EObject eObject;
		protected boolean[] optional;
		protected Map<Pair<AbstractElement, Integer>, Boolean> valid = Maps.newHashMap();
		protected Object[] values;
		protected List<INode>[] nodes;

		public EObject getEObject() {
			return eObject;
		}

		@SuppressWarnings("unchecked")
		public SerializableObject(EObject eObject, INodesForEObjectProvider nodeProvider) {
			super();
			this.eObject = eObject;
			EClass clazz = eObject.eClass();
			values = new Object[clazz.getFeatureCount()];
			nodes = new List[clazz.getFeatureCount()];
			optional = new boolean[clazz.getFeatureCount()];
			for (EStructuralFeature feature : eObject.eClass().getEAllStructuralFeatures()) {
				int featureID = eObject.eClass().getFeatureID(feature);
				if (feature.isMany())
					switch (transientValueService.isListTransient(eObject, feature)) {
						case NO:
							List<INode> nodes1 = Lists.newArrayList();
							List<?> values1 = (List<?>) eObject.eGet(feature);
							for (int i = 0; i < values1.size(); i++)
								nodes1.add(nodeProvider.getNodeForMultiValue(feature, i, i, values1.get(i)));
							values[featureID] = values1;
							nodes[featureID] = nodes1;
							break;
						case SOME:
							List<INode> nodes2 = Lists.newArrayList();
							List<?> values2 = (List<?>) eObject.eGet(feature);
							List<Object> values3 = Lists.newArrayList();
							for (int i = 0, j = 0; i < values2.size(); i++)
								if (!transientValueService.isValueInListTransient(eObject, i, feature)) {
									Object value = values2.get(i);
									INode node = nodeProvider.getNodeForMultiValue(feature, i, j++, value);
									values3.add(value);
									nodes2.add(node);
								}
							values[featureID] = values3;
							nodes[featureID] = nodes2;
							break;
						case YES:
					}
				else
					switch (transientValueService.isValueTransient(eObject, feature)) {
						case PREFERABLY:
							optional[featureID] = true;
						case NO:
							Object value = eObject.eGet(feature);
							values[featureID] = value;
							nodes[featureID] = Collections.singletonList(nodeProvider.getNodeForSingelValue(feature,
									value));
						case YES:
					}
			}
		}

		public INode getNode(int featureID, int index) {
			List<INode> featureNodes = nodes[featureID];
			if (featureNodes != null && index >= 0 && index < featureNodes.size())
				return featureNodes.get(index);
			return null;
		}

		public Object getValue(ISemState state, int index) {
			Object value = values[state.getFeatureID()];
			if (value instanceof List<?>)
				value = ((List<?>) value).get(index);
			if (!isValueValid(state, index, value))
				return null;
			return value;
		}

		public int getValueCount(int featureID) {
			Object v = values[featureID];
			if (v == null)
				return 0;
			else if (v instanceof List<?>)
				return ((List<?>) v).size();
			return 1;
		}

		public boolean isOptional(int featureID) {
			return optional[featureID];
		}

		public boolean isList(int featureID) {
			return values[featureID] instanceof List<?>;
		}

		protected boolean isValueValid(ISemState state, int index, Object value) {
			if (state.getToBeValidatedAssignedElements().isEmpty())
				return true;

			Pair<AbstractElement, Integer> key = Tuples.create(state.getAssignedGrammarElement(), index);
			if (valid.get(key) == Boolean.TRUE)
				return true;

			Set<AbstractElement> validAssignments = Sets.newHashSet(assignmentFinder.findAssignmentsByValue(eObject,
					state.getToBeValidatedAssignedElements(), value, getNode(state.getFeatureID(), index)));
			boolean result = validAssignments.contains(state.getAssignedGrammarElement());
			valid.put(key, result);
			return result;
		}
	}

	protected class TraceItem {
		protected int index;
		protected SerializableObject obj;
		protected TraceItem parent;
		protected ISemState state;
		protected int[] nextIndex;
		protected Object value;
		protected INode node;

		public TraceItem(SerializableObject obj) {
			this(obj, new int[obj.getEObject().eClass().getFeatureCount()]);
		}

		public TraceItem(SerializableObject obj, int[] unconsumed) {
			super();
			this.obj = obj;
			this.nextIndex = unconsumed;
		}

		public TraceItem cloneAndConsume(ISemState state) {
			int index = nextIndex[state.getFeatureID()];
			if (index >= obj.getValueCount(state.getFeatureID()))
				return null;
			Object value = obj.getValue(state, index);
			if (value == null)
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

		public TraceItem clone(ISemState state) {
			TraceItem result = new TraceItem(obj, nextIndex);
			result.parent = this;
			result.state = state;
			result.value = value;
			result.index = index;
			result.node = node;
			return result;
		}

		public int getIndex() {
			return index;
		}

		public SerializableObject getObj() {
			return obj;
		}

		public INode getNode() {
			return node;
		}

		public INode getNextNode() {
			if (node == null)
				return null;
			NodeIterator ni = new NodeIterator(node);
			while (ni.hasNext()) {
				INode n = ni.next();
				if (n.getGrammarElement() instanceof AbstractElement) {
					AbstractElement e = (AbstractElement) n.getGrammarElement();
					if ((e instanceof Keyword || e instanceof RuleCall) && GrammarUtil.isAssigned(e))
						return n;
					if (GrammarUtil.isAssignedAction(e))
						return n;
				}
			}
			return null;
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
			for (int i = 0; i < nextIndex.length; i++) {
				int count = nextIndex[i];
				if (count < obj.getValueCount(i)) {
					EStructuralFeature feature = obj.getEObject().eClass().getEStructuralFeature(i);
					if (count == 0 && obj.isOptional(i))
						optional.add(feature.getName() + "(" + (count + 1) + ")");
					else
						mandatory.add(feature.getName() + "(" + (count + 1) + ")");
				}
			}
			StringBuilder result = new StringBuilder();
			result.append("EObject: " + EmfFormatter.objPath(obj.getEObject()) + "\n");
			result.append("Mandatory Values: " + Joiner.on(", ").join(mandatory) + "\n");
			result.append("Optional Values: " + Joiner.on(", ").join(optional) + "\n");
			return result.toString();
		}

	}

	@Inject
	protected IAssignmentFinder assignmentFinder;

	@Inject
	protected ISemanticNodeProvider nodeProvider;

	@Inject
	protected ISemanticSequencerNfaProvider nfaProvider;

	@Inject
	protected ITransientValueService transientValueService;

	@Inject
	protected TransientValueUtil transientValueUtil;

	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;

	public void createSequence(EObject context, final EObject obj) {
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(obj, null);
		INfaAdapter<ISemState, List<ISemState>> nfa = nfaProvider.getNFA(context, obj.eClass());
		SerializableObject object = new SerializableObject(obj, nodes);
		TraceItem co = new TraceItem(object);
		List<TraceItem> trace = new NfaUtil().backtrack(nfa, co, new NfaUtil.BacktrackHandler<ISemState, TraceItem>() {
			public TraceItem handle(ISemState state, TraceItem previous) {
				if (state.getFeature() != null) {
					return previous.cloneAndConsume(state);
				} else
					return previous.clone(state);
			}

			public boolean isSolution(TraceItem result) {
				return result.isConsumed();
			}

			public Iterable<ISemState> sortFollowers(TraceItem result, Iterable<ISemState> followers) {
				INode next = result.getNextNode();
				if (next == null)
					return followers;
				List<ISemState> r = Lists.newArrayList(followers);
				for (int i = 1; i < r.size(); i++)
					if (r.get(i).getAssignedGrammarElement() == next.getGrammarElement()) {
						Collections.swap(r, 0, i);
						break;
					}
				return r;
			}
		});
		SequenceFeeder feeder = feederProvider.create(obj, nodes, masterSequencer, sequenceAcceptor, errorAcceptor);
		if (trace != null) {
			for (TraceItem ti : trace)
				if (ti.getState() != null && ti.getState().getFeature() != null)
					accept(ti, feeder);
		} else if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createBacktrackingFailedDiagnostic(obj, nfa));
		feeder.finish();
	}

	protected void accept(TraceItem ti, SequenceFeeder feeder) {
		AbstractElement ele = ti.getState().getAssignedGrammarElement();
		if (ti.getState().getFeature().isMany()) {
			if (ele instanceof RuleCall)
				feeder.accept((RuleCall) ele, ti.getValue(), ti.getIndex(), ti.getNode());
			else if (ele instanceof Action)
				feeder.accept((Action) ele, (EObject) ti.getValue(), (ICompositeNode) ti.getNode());
			else if (ele instanceof Keyword)
				feeder.accept((Keyword) ele, ti.getValue(), ti.getIndex(), (ILeafNode) ti.getNode());
		} else {
			if (ele instanceof RuleCall)
				feeder.accept((RuleCall) ele, ti.getValue(), ti.getNode());
			else if (ele instanceof Action)
				feeder.accept((Action) ele, (EObject) ti.getValue(), (ICompositeNode) ti.getNode());
			else if (ele instanceof Keyword)
				feeder.accept((Keyword) ele, ti.getValue(), (ILeafNode) ti.getNode());
		}
	}

}
