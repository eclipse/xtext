/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.parameterized;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.junit.Assert;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OffsetHelper {

	public Offset at(XtextResource resource, int offset) {
		return new Offset(resource, offset);
	}

	public Offset at(XtextResource resource, String offset) {
		return at(resource, Integer.valueOf(offset));
	}

	public static class Offset {
		protected int offset;
		protected XtextResource resource;

		public Offset(XtextResource resource, int offset) {
			super();
			this.resource = resource;
			this.offset = offset;
		}

		public EObject getEObject() {
			EObject object = NodeModelUtils.findActualSemanticObjectFor(getLeafNodeAtOffset());
			Assert.assertNotNull("No EObject found at offset " + offset, object);
			return object;
		}

		public Pair<EObject, EStructuralFeature> getEStructuralFeatureByParent() {
			INode leaf = getLeafNodeAtOffset();
			EObject object = NodeModelUtils.findActualSemanticObjectFor(leaf);
			Assert.assertNotNull("No EObject found at offset " + offset, object);
			Assignment ass = GrammarUtil.containingAssignment(leaf.getGrammarElement());
			while (ass == null && leaf.getParent() != null) {
				leaf = leaf.getParent();
				ass = GrammarUtil.containingAssignment(leaf.getGrammarElement());
			}
			Assert.assertNotNull("No Assignment found at offset " + offset, ass);
			@SuppressWarnings("null")
			EStructuralFeature feature = object.eClass().getEStructuralFeature(ass.getFeature());
			return Tuples.create(object, feature);
		}

		public Pair<EObject, EStructuralFeature> getEStructuralFeatureByOffset() {
			return getEStructuralFeatureByOffset(Predicates.<EStructuralFeature> alwaysTrue());
		}

		public Pair<EObject, EStructuralFeature> getEStructuralFeatureByOffset(Predicate<EStructuralFeature> matches) {
			INode leaf = getLeafNodeAtOffset();
			NodeIterator ni = null;
			while (ni == null || ni.hasNext()) {
				INode next = ni == null ? leaf : ni.next();
				if (ni == null)
					ni = new NodeIterator(leaf);
				Assignment ass = GrammarUtil.containingAssignment(next.getGrammarElement());
				if (ass != null) {
					EObject object = NodeModelUtils.findActualSemanticObjectFor(next);
					EStructuralFeature feat = object.eClass().getEStructuralFeature(ass.getFeature());
					if (feat != null && matches.apply(feat))
						return Tuples.create(object, feat);
				}
			}
			Assert.fail("No EStructuralFeature found at offset " + offset);
			return null;
		}

		public ILeafNode getLeafNodeAtOffset() {
			ILeafNode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
			Assert.assertNotNull("No Leaf Node found at offset " + offset, node);
			return node;
		}
	}

}
