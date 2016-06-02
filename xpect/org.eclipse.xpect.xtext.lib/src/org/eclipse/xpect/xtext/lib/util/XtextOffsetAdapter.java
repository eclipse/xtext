/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.xtext.lib.util;

import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.parameter.OffsetRegion;
import org.eclipse.xpect.setup.ThisArgumentType;
import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.state.Creates;
import org.eclipse.xpect.text.OffsetToString;
import org.eclipse.xpect.xtext.lib.setup.ThisResource;
import org.eclipse.xpect.xtext.lib.util.XtextOffsetAdapter.EObjectProvider;
import org.eclipse.xpect.xtext.lib.util.XtextOffsetAdapter.NodeProvider;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@XpectImport({ NodeProvider.class, EObjectProvider.class })
public class XtextOffsetAdapter {

	protected static class CrossEReferenceAndEObject extends EStructuralFeatureAndEObject implements ICrossEReferenceAndEObject {

		public CrossEReferenceAndEObject(EObject object, EStructuralFeature feature) {
			super(object, feature);
		}

		public EReference getCrossEReference() {
			return (EReference) getEStructuralFeature();
		}

	}

	@XpectSetupFactory
	protected static class CrossEReferenceAndEObjectProvider extends EStructuralFeatureAndEObjectProvider {

		public CrossEReferenceAndEObjectProvider(@ThisResource XtextResource resource, XpectInvocation statement) {
			super(resource, statement);
		}

		public CrossEReferenceAndEObjectProvider(@ThisResource XtextResource resource, XpectInvocation statement, OffsetRegion region) {
			super(resource, statement, region);
		}

		@Override
		protected EStructuralFeatureAndEObject create(EObject object, EStructuralFeature feat) {
			return new CrossEReferenceAndEObject(object, feat);
		}

		@Creates
		public ICrossEReferenceAndEObject createCrossEReferenceAndEObject() {
			return (ICrossEReferenceAndEObject) createStructuralFeatureAndEObject();
		}

		@Override
		protected boolean matches(EObject object, EStructuralFeature feature) {
			return feature instanceof EReference && !((EReference) feature).isContainment();
		}

		@Creates
		public ICrossEReferenceAndEObject create() {
			return (ICrossEReferenceAndEObject) createStructuralFeatureAndEObject();
		}

	}

	protected static class EAttributeAndEObject extends EStructuralFeatureAndEObject implements IEAttributeAndEObject {

		public EAttributeAndEObject(EObject object, EStructuralFeature feature) {
			super(object, feature);
		}

		public EAttribute getEAttribute() {
			return (EAttribute) getEStructuralFeature();
		}

	}

	@XpectSetupFactory
	protected static class EAttributeAndEObjectProvider extends EStructuralFeatureAndEObjectProvider {

		public EAttributeAndEObjectProvider(XtextResource resource, XpectInvocation statement) {
			super(resource, statement);
		}

		public EAttributeAndEObjectProvider(XtextResource resource, XpectInvocation statement, OffsetRegion region) {
			super(resource, statement, region);
		}

		@Override
		protected EStructuralFeatureAndEObject create(EObject object, EStructuralFeature feat) {
			return new EAttributeAndEObject(object, feat);
		}

		@Creates
		public IEAttributeAndEObject createEAttributeAndEObject() {
			return (IEAttributeAndEObject) createStructuralFeatureAndEObject();
		}

		@Override
		protected boolean matches(EObject object, EStructuralFeature feature) {
			return feature instanceof EAttribute;
		}

	}

	@XpectSetupFactory
	protected static class EObjectProvider<T extends EObject> {

		private final T eObject;

		public EObjectProvider(@ThisResource XtextResource resource, XpectInvocation statement, @ThisArgumentType Class<T> expectedType) {
			ICompositeNode statementNode = NodeModelUtils.getNode(statement);
			this.eObject = find(resource, statementNode.getOffset() + statementNode.getLength(), expectedType);
		}

		public EObjectProvider(@ThisResource XtextResource resource, XpectInvocation statement, @ThisArgumentType Class<T> expectedType, OffsetRegion offset) {
			this.eObject = find(resource, offset.getMatchedOffset(), expectedType);
		}

		public boolean canProvide(Class<?> expectedType) {
			return EObject.class.isAssignableFrom(expectedType);
		}

		protected T find(Class<T> expectedType, INode node, Set<EObject> visited) {
			EObject current = node.getSemanticElement();
			int startoffset = node.getOffset();
			T result = null;
			while (current != null && NodeModelUtils.getNode(current).getOffset() >= startoffset) {
				if (expectedType.isInstance(current))
					result = expectedType.cast(current);
				visited.add(current);
				current = current.eContainer();
			}
			return result;
		}

		protected T find(XtextResource res, int offset, Class<T> expectedType) {
			INode leaf = NodeModelUtils.findLeafNodeAtOffset(res.getParseResult().getRootNode(), offset);
			Set<EObject> visited = Sets.newHashSet();
			NodeIterator ni = null;
			while (ni == null || ni.hasNext()) {
				INode next = ni == null ? leaf : ni.next();
				if (ni == null)
					ni = new NodeIterator(leaf);
				T result = find(expectedType, next, visited);
				if (result != null)
					return result;
			}
			return null;
		}

		@Creates
		public T getEObject() {
			return eObject;
		}

	}

	protected static class EReferenceAndEObject extends EStructuralFeatureAndEObject implements IEReferenceAndEObject {

		public EReferenceAndEObject(EObject object, EStructuralFeature feature) {
			super(object, feature);
		}

		public EReference getEReference() {
			return (EReference) getEStructuralFeature();
		}

	}

	@XpectSetupFactory
	protected static class EReferenceAndEObjectProvider extends EStructuralFeatureAndEObjectProvider {

		public EReferenceAndEObjectProvider(XtextResource resource, XpectInvocation statement) {
			super(resource, statement);
		}

		public EReferenceAndEObjectProvider(XtextResource resource, XpectInvocation statement, OffsetRegion region) {
			super(resource, statement, region);
		}

		@Override
		protected EStructuralFeatureAndEObject create(EObject object, EStructuralFeature feat) {
			return new EReferenceAndEObject(object, feat);
		}

		@Creates
		public IEReferenceAndEObject createReferenceAndEObject() {
			return (IEReferenceAndEObject) createStructuralFeatureAndEObject();
		}

		@Override
		protected boolean matches(EObject object, EStructuralFeature feature) {
			return feature instanceof EReference;
		}
	}

	protected static class EStructuralFeatureAndEObject implements IEStructuralFeatureAndEObject {

		private final EStructuralFeature feature;
		private final EObject object;

		public EStructuralFeatureAndEObject(EObject object, EStructuralFeature feature) {
			this.object = object;
			this.feature = feature;
		}

		public EObject getEObject() {
			return object;
		}

		public EStructuralFeature getEStructuralFeature() {
			return feature;
		}

	}

	@XpectSetupFactory
	protected static class EStructuralFeatureAndEObjectProvider {

		private final IEStructuralFeatureAndEObject structuralFeatureAndEObject;

		public EStructuralFeatureAndEObjectProvider(@ThisResource XtextResource resource, XpectInvocation statement) {
			ICompositeNode statementNode = NodeModelUtils.getNode(statement);
			int offset = statementNode.getOffset() + statementNode.getLength();
			this.structuralFeatureAndEObject = findAfterOffset(resource, offset);
		}

		public EStructuralFeatureAndEObjectProvider(@ThisResource XtextResource resource, XpectInvocation statement, OffsetRegion region) {
			int offset = region.getMatchedOffset();
			if (region.getMatchedRegion() == null)
				this.structuralFeatureAndEObject = findAfterOffset(resource, offset);
			else
				this.structuralFeatureAndEObject = findAtOffset(resource, region, offset);
		}

		protected EStructuralFeatureAndEObject create(EObject object, EStructuralFeature feat) {
			return new EStructuralFeatureAndEObject(object, feat);
		}

		@Creates
		public IEStructuralFeatureAndEObject createStructuralFeatureAndEObject() {
			return this.structuralFeatureAndEObject;
		}

		protected IEStructuralFeatureAndEObject findInParent(INode node) {

			return null;
		}

		protected IEStructuralFeatureAndEObject findAfterOffset(XtextResource resource, int offset) {
			INode leaf = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
			NodeIterator ni = null;
			while (ni == null || ni.hasNext()) {
				INode next = ni == null ? leaf : ni.next();
				if (ni == null)
					ni = new NodeIterator(leaf);
				EObject object = NodeModelUtils.findActualSemanticObjectFor(next);
				INode current = next;
				do {
					Assignment ass = GrammarUtil.containingAssignment(current.getGrammarElement());
					if (ass != null) {
						EStructuralFeature feat = object.eClass().getEStructuralFeature(ass.getFeature());
						if (feat != null && matches(object, feat))
							return create(object, feat);
					}
					current = current.getParent();
				} while (current != null && object == NodeModelUtils.findActualSemanticObjectFor(current));
			}
			throw new RuntimeException("No EStructuralFeature found at offset " + offset);
		}

		protected IEStructuralFeatureAndEObject findAtOffset(XtextResource resource, OffsetRegion region, int offset) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
			EObject object = NodeModelUtils.findActualSemanticObjectFor(leaf);
			INode current = leaf;
			do {
				Assignment ass = GrammarUtil.containingAssignment(current.getGrammarElement());
				if (ass != null) {
					EStructuralFeature feat = object.eClass().getEStructuralFeature(ass.getFeature());
					if (feat != null) {
						if (matches(object, feat))
							return create(object, feat);
						String name = feat.eClass().getName() + " '" + feat.getEContainingClass().getName() + "." + feat.getName() + "'";
						String offsetString = new OffsetToString().with(offset, region.getDocument()).toString();
						throw new RuntimeException("The " + name + " found at " + offsetString + " is not valid here.");
					}
				}
				current = current.getParent();
			} while (current != null && object == NodeModelUtils.findActualSemanticObjectFor(current));
			String offsetString = new OffsetToString().with(offset, region.getDocument()).toString();
			throw new RuntimeException("no EStructuralFeature found at '" + offsetString + "'");
		}

		protected boolean matches(EObject object, EStructuralFeature feature) {
			return true;
		}
	}

	@XpectImport(CrossEReferenceAndEObjectProvider.class)
	public static interface ICrossEReferenceAndEObject extends IEObjectOwner {
		EReference getCrossEReference();
	}

	@XpectImport(EAttributeAndEObjectProvider.class)
	public static interface IEAttributeAndEObject extends IEObjectOwner {
		EAttribute getEAttribute();
	}

	public static interface IEObjectOwner {
		EObject getEObject();
	}

	@XpectImport(EReferenceAndEObjectProvider.class)
	public static interface IEReferenceAndEObject extends IEObjectOwner {
		EReference getEReference();
	}

	@XpectImport(EStructuralFeatureAndEObjectProvider.class)
	public static interface IEStructuralFeatureAndEObject extends IEObjectOwner {
		EStructuralFeature getEStructuralFeature();
	}

	@XpectSetupFactory
	protected static class NodeProvider {

		private final ILeafNode leaf;

		public NodeProvider(@ThisResource XtextResource resource, XpectInvocation statement) {
			ICompositeNode statementNode = NodeModelUtils.getNode(statement);
			int offset = statementNode.getOffset() + statementNode.getLength();
			ILeafNode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
			NodeIterator it = new NodeIterator(node);
			ILeafNode cand = null;
			while (cand == null && it.hasNext()) {
				INode next = it.next();
				if (next instanceof ILeafNode && !((ILeafNode) next).isHidden())
					cand = (ILeafNode) next;
			}
			this.leaf = cand;
		}

		public NodeProvider(@ThisResource XtextResource resource, XpectInvocation statement, OffsetRegion offset) {
			this.leaf = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset.getMatchedOffset());
		}

		@Creates
		public ICompositeNode getCompositeNode() {
			return leaf.getParent();
		}

		@Creates
		public ILeafNode getLeafNode() {
			return leaf;
		}

		@Creates
		public INode getNode() {
			return leaf;
		}

	}

}
