/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SemanticNodeProvider implements ISemanticNodeProvider {

	public static class NodesForEObjectProvider implements INodesForEObjectProvider {

		protected EObject semanticObject;

		protected ICompositeNode node;

		public NodesForEObjectProvider(EObject semanticObject, ICompositeNode node) {
			super();
			this.semanticObject = semanticObject;
			this.node = node;
		}

		public INode getNodeForMultiValue(EStructuralFeature feature, int indexInFeature, int indexAmongNonTransient,
				Object value) {
			// TODO: find an implementation with better performance for this
			// TODO: check the values of EReferences
			// TODO: consider the node that is passed in as parameter
			// List<INode> nodes = NodeModelUtils.findNodesForFeature(semanticObject, node, feature);
			List<INode> nodes = NodeModelUtils.findNodesForFeature(semanticObject, feature);
			if (indexAmongNonTransient >= 0 && indexAmongNonTransient < nodes.size())
				return nodes.get(indexAmongNonTransient);
			return null;
		}

		public INode getNodeForSingelValue(EStructuralFeature feature, Object value) {
			return getNodeForMultiValue(feature, 0, 0, value);
		}
	}

	protected NodesForEObjectProvider createNodesForEObjectProvider(EObject semanticObject, ICompositeNode node) {
		return new NodesForEObjectProvider(semanticObject, node);
	}

	public INodesForEObjectProvider getNodesForSemanticObject(EObject semanticObject, ICompositeNode suggestedComposite) {
		ICompositeNode actualComposite = NodeModelUtils.findActualNodeFor(semanticObject);
		if (actualComposite != null)
			return createNodesForEObjectProvider(semanticObject, actualComposite);
		if (suggestedComposite != null)
			return createNodesForEObjectProvider(semanticObject, suggestedComposite);
		return ISemanticNodeProvider.NULL_NODES_PROVIDER;
	}
}
