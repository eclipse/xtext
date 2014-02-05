/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
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

	public static class NodesForEObjectProvider implements INodesForEObjectProvider {

		protected final Object[] childrenByFeatureIDAndIndex;

		protected Map<EObject, INode> childrenBySemanticChild = null;

		protected final ICompositeNode node;

		protected final EObject semanticObject;

		public NodesForEObjectProvider(EObject semanticObject, ICompositeNode node) {
			super();
			this.semanticObject = semanticObject;
			this.node = node;
			this.childrenByFeatureIDAndIndex = new Object[semanticObject.eClass().getFeatureCount()];
			collectNodesForFeatures();
		}

		protected void add(String featureName, INode child) {
			if (featureName == null)
				return;
			EStructuralFeature feature = this.semanticObject.eClass().getEStructuralFeature(featureName);
			if (feature == null)
				return;
			int id = feature.getFeatureID();
			if (feature.isMany()) {
				@SuppressWarnings("unchecked")
				List<INode> nodes = (List<INode>) childrenByFeatureIDAndIndex[id];
				if (nodes == null)
					childrenByFeatureIDAndIndex[id] = nodes = Lists.<INode> newArrayList();
				nodes.add(child);
			} else {
				childrenByFeatureIDAndIndex[id] = child;
			}
			if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					EObject semanitcChild = getSemanticChild(child);
					if (semanitcChild != null) {
						if (this.childrenBySemanticChild == null)
							this.childrenBySemanticChild = Maps.newHashMap();
						this.childrenBySemanticChild.put(semanitcChild, child);
					}
				}
			}
		}

		// this implementation should be synonym to 
		// org.eclipse.xtext.nodemodel.util.NodeModelUtils.findNodesForFeature(EObject, INode, EStructuralFeature)
		protected void collectNodesForFeatures() {
			BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
			while (iterator.hasNext()) {
				INode child = iterator.next();
				EObject grammarElement = child.getGrammarElement();
				if (grammarElement != null) {
					if (grammarElement instanceof Action) {
						Action action = (Action) grammarElement;
						if (child.getSemanticElement() == this.semanticObject) {
							child = iterator.next();
							add(action.getFeature(), child);
						} else {
							// navigate the action's left side (first child) until we find an assignment (a rule call)
							// the assignment will tell us about the feature to which we assigned
							// the semantic object that has been created by the action
							INode firstChild = ((ICompositeNode) child).getFirstChild();
							while (firstChild.getGrammarElement() instanceof Action) {
								firstChild = ((ICompositeNode) firstChild).getFirstChild();
							}
							EObject firstChildGrammarElement = firstChild.getGrammarElement();
							Assignment assignment = GrammarUtil.containingAssignment(firstChildGrammarElement);
							if (assignment != null)
								add(assignment.getFeature(), child);
						}
						iterator.prune();
					} else if (child != node) {
						Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
						if (assignment != null) {
							add(assignment.getFeature(), child);
							iterator.prune();
						}
					}
				}
			}
		}

		public INode getNodeForMultiValue(EStructuralFeature feat, int indexInFeat, int indexInNonTransient, Object val) {
			if (childrenBySemanticChild != null && feat instanceof EReference && ((EReference) feat).isContainment()) {
				INode candiadate = this.childrenBySemanticChild.get(val);
				if (candiadate != null)
					return candiadate;
			}
			Object object = this.childrenByFeatureIDAndIndex[feat.getFeatureID()];
			if (feat.isMany() && object instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<INode> nodes = (List<INode>) object;
				if (indexInNonTransient >= 0 && indexInNonTransient < nodes.size())
					return nodes.get(indexInNonTransient);
			} else if (object instanceof INode)
				return (INode) object;
			return null;
		}

		public INode getNodeForSingelValue(EStructuralFeature feature, Object value) {
			return getNodeForMultiValue(feature, 0, 0, value);
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
	}

	protected NodesForEObjectProvider createNodesForEObjectProvider(EObject semanticObject, ICompositeNode node) {
		return new NodesForEObjectProvider(semanticObject, node);
	}

	public INodesForEObjectProvider getNodesForSemanticObject(EObject semanticObject, ICompositeNode suggestedComposite) {
		if (suggestedComposite != null)
			return createNodesForEObjectProvider(semanticObject, suggestedComposite);
		ICompositeNode actualComposite = NodeModelUtils.findActualNodeFor(semanticObject);
		if (actualComposite != null)
			return createNodesForEObjectProvider(semanticObject, actualComposite);
		return ISemanticNodeProvider.NULL_NODES_PROVIDER;
	}
}
