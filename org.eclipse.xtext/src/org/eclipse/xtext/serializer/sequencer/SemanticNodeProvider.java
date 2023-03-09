/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SemanticNodeProvider implements ISemanticNodeProvider {

	public static class SemanticNode implements ISemanticNode {
		private final INode node;
		private final AbstractElement grammarElement;
		private SemanticNode follower = null;

		public SemanticNode(INode node) {
			this.node = node;
			EObject ge = node.getGrammarElement();
			if (ge instanceof CrossReference)
				this.grammarElement = ((CrossReference) ge).getTerminal();
			else if (ge instanceof AbstractElement)
				this.grammarElement = (AbstractElement) ge;
			else
				this.grammarElement = null;
		}

		@Override
		public INode getNode() {
			return node;
		}

		@Override
		public ISemanticNode getFollower() {
			return follower;
		}

		@Override
		public AbstractElement getGrammarElement() {
			return grammarElement;
		}
	}

	public static class NodesForEObjectProvider implements INodesForEObjectProvider {

		protected final Object[] childrenByFeatureIDAndIndex;

		protected Map<EObject, SemanticNode> childrenBySemanticChild = null;

		protected SemanticNode first = null;

		protected final ICompositeNode node;

		protected final EObject semanticObject;

		public NodesForEObjectProvider(EObject semanticObject, ICompositeNode node) {
			super();
			this.semanticObject = semanticObject;
			this.node = node;
			this.childrenByFeatureIDAndIndex = new Object[semanticObject.eClass().getFeatureCount()];
			collectNodesForFeatures();
		}

		protected SemanticNode add(String featureName, INode child, SemanticNode last) {
			if (featureName == null)
				return last;
			EClass eClass = this.semanticObject.eClass();
			EStructuralFeature feature = eClass.getEStructuralFeature(featureName);
			if (feature == null)
				return last;
			SemanticNode sem = new SemanticNode(child);
			if (last != null) {
				last.follower = sem;
			}
			if (this.first == null) {
				this.first = sem;
			}
			int id = eClass.getFeatureID(feature);
			if (feature.isMany()) {
				@SuppressWarnings("unchecked")
				List<SemanticNode> nodes = (List<SemanticNode>) childrenByFeatureIDAndIndex[id];
				if (nodes == null)
					childrenByFeatureIDAndIndex[id] = nodes = Lists.<SemanticNode>newArrayList();
				nodes.add(sem);
			} else {
				childrenByFeatureIDAndIndex[id] = sem;
			}
			if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					EObject semanitcChild = getSemanticChild(child);
					if (semanitcChild != null) {
						if (this.childrenBySemanticChild == null)
							this.childrenBySemanticChild = Maps.newHashMap();
						this.childrenBySemanticChild.put(semanitcChild, sem);
					}
				}
			}
			return sem;
		}

		// this implementation should be synonym to
		// org.eclipse.xtext.nodemodel.util.NodeModelUtils.findNodesForFeature(EObject,
		// INode, EStructuralFeature)
		protected void collectNodesForFeatures() {
			SemanticNode last = null;
			BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
			while (iterator.hasNext()) {
				INode child = iterator.next();
				EObject grammarElement = child.getGrammarElement();
				if (grammarElement != null) {
					if (grammarElement instanceof Action) {
						Action action = (Action) grammarElement;
						if (child.getSemanticElement() == this.semanticObject) {
							child = iterator.next();
							last = add(action.getFeature(), child, last);
						} else {
							// navigate the action's left side (first child)
							// until we find an assignment (a rule call)
							// the assignment will tell us about the feature to
							// which we assigned
							// the semantic object that has been created by the
							// action
							INode firstChild = ((ICompositeNode) child).getFirstChild();
							while (firstChild.getGrammarElement() instanceof Action) {
								firstChild = ((ICompositeNode) firstChild).getFirstChild();
							}
							EObject firstChildGrammarElement = firstChild.getGrammarElement();
							Assignment assignment = GrammarUtil.containingAssignment(firstChildGrammarElement);
							if (assignment != null)
								last = add(assignment.getFeature(), child, last);
						}
						iterator.prune();
					} else if (child != node) {
						Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
						if (assignment != null) {
							last = add(assignment.getFeature(), child, last);
							iterator.prune();
						}
					}
				}
			}
		}

		@Override
		public SemanticNode getSemanticNodeForMultiValue(EStructuralFeature feat, int indexInFeat,
				int indexInNonTransient, Object val) {
			if (childrenBySemanticChild != null && feat instanceof EReference && ((EReference) feat).isContainment()) {
				SemanticNode candiadate = this.childrenBySemanticChild.get(val);
				if (candiadate != null)
					return candiadate;
			}
			Object object = this.childrenByFeatureIDAndIndex[semanticObject.eClass().getFeatureID(feat)];
			if (feat.isMany() && object instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<SemanticNode> nodes = (List<SemanticNode>) object;
				if (indexInNonTransient >= 0 && indexInNonTransient < nodes.size())
					return nodes.get(indexInNonTransient);
			} else if (object instanceof SemanticNode)
				return (SemanticNode) object;
			return null;
		}

		@Override
		public SemanticNode getSemanticNodeForSingelValue(EStructuralFeature feature, Object value) {
			return getSemanticNodeForMultiValue(feature, 0, 0, value);
		}

		protected EObject getSemanticChild(INode node) {
			EObject root = node.getSemanticElement();
			if (root != null && root != this.semanticObject)
				return root;
			BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
			while (iterator.hasNext()) {
				EObject candidate = iterator.next().getSemanticElement();
				if (candidate != null && candidate != this.semanticObject)
					return candidate;
			}
			return null;
		}

		@Override
		public INode getNodeForMultiValue(EStructuralFeature feature, int indexInFeature, int indexInNonTransient,
				Object value) {
			SemanticNode semantic = getSemanticNodeForMultiValue(feature, indexInFeature, indexInNonTransient, value);
			if (semantic == null)
				return null;
			return semantic.getNode();
		}

		@Override
		public INode getNodeForSingelValue(EStructuralFeature feature, Object value) {
			SemanticNode semantic = getSemanticNodeForSingelValue(feature, value);
			if (semantic == null)
				return null;
			return semantic.getNode();
		}

		@Override
		public ISemanticNode getFirstSemanticNode() {
			return first;
		}

	}

	protected NodesForEObjectProvider createNodesForEObjectProvider(EObject semanticObject, ICompositeNode node) {
		return new NodesForEObjectProvider(semanticObject, node);
	}

	@Override
	public INodesForEObjectProvider getNodesForSemanticObject(EObject semanticObject,
			ICompositeNode suggestedComposite) {
		if (suggestedComposite != null)
			return createNodesForEObjectProvider(semanticObject, suggestedComposite);
		ICompositeNode actualComposite = NodeModelUtils.findActualNodeFor(semanticObject);
		if (actualComposite != null)
			return createNodesForEObjectProvider(semanticObject, actualComposite);
		return ISemanticNodeProvider.NULL_NODES_PROVIDER;
	}
}
