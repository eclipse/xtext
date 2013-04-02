/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.xpect.parameters.AbstractOffsetProvider;
import org.xpect.parameters.IParameterAdapter;
import org.xpect.parameters.IParameterProvider;
import org.xpect.parameters.ParameterProvider;

import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextOffsetAdapter implements IParameterAdapter {

	protected static class CrossEReferenceAndEObject extends EStructuralFeatureAndEObject implements ICrossEReferenceAndEObject {

		public CrossEReferenceAndEObject(XtextResource resource, int offset) {
			super(resource, offset);
		}

		public EReference getCrossEReference() {
			return (EReference) getEStructuralFeature();
		}

		@Override
		protected boolean matches(EObject object, EStructuralFeature feature) {
			return feature instanceof EReference && !((EReference) feature).isContainment();
		}
	}

	protected static class EAttributeAndEObject extends EStructuralFeatureAndEObject implements IEAttributeAndEObject {

		public EAttributeAndEObject(XtextResource resource, int offset) {
			super(resource, offset);
		}

		public EAttribute getEAttribute() {
			return (EAttribute) getEStructuralFeature();
		}

		@Override
		protected boolean matches(EObject object, EStructuralFeature feature) {
			return feature instanceof EAttribute;
		}
	}

	protected static class EObjectProvider implements IParameterProvider {

		private final EObject object;

		public EObjectProvider(XtextResource res, int offset, Class<?> expectedType) {
			this.object = find(res, offset, expectedType);
		}

		public boolean canProvide(Class<?> expectedType) {
			return expectedType.isInstance(object);
		}

		protected EObject find(Class<?> expectedType, INode node, Set<EObject> visited) {
			EObject current = node.getSemanticElement();
			while (current != null) {
				if (expectedType.isInstance(current))
					return current;
				visited.add(current);
				current = current.eContainer();
			}
			return null;
		}

		protected EObject find(XtextResource res, int offset, Class<?> expectedType) {
			INode leaf = NodeModelUtils.findLeafNodeAtOffset(res.getParseResult().getRootNode(), offset);
			Set<EObject> visited = Sets.newHashSet();
			NodeIterator ni = null;
			while (ni == null || ni.hasNext()) {
				INode next = ni == null ? leaf : ni.next();
				if (ni == null)
					ni = new NodeIterator(leaf);
				EObject result = find(expectedType, next, visited);
				if (result != null)
					return result;
			}
			return null;
		}

		@SuppressWarnings("unchecked")
		public <T> T get(Class<T> expectedType) {
			if (expectedType.isInstance(object))
				return (T) object;
			return null;
		}

	}

	protected static class EReferenceAndEObject extends EStructuralFeatureAndEObject implements IEReferenceAndEObject {

		public EReferenceAndEObject(XtextResource resource, int offset) {
			super(resource, offset);
		}

		public EReference getEReference() {
			return (EReference) getEStructuralFeature();
		}

		@Override
		protected boolean matches(EObject object, EStructuralFeature feature) {
			return feature instanceof EReference;
		}
	}

	protected static class EStructuralFeatureAndEObject implements IEStructuralFeatureAndEObject {

		private final EStructuralFeature feature;
		private final EObject object;

		public EStructuralFeatureAndEObject(XtextResource resource, int offset) {
			Pair<EObject, EStructuralFeature> match = find(resource, offset);
			this.object = match.getFirst();
			this.feature = match.getSecond();
		}

		protected Pair<EObject, EStructuralFeature> find(XtextResource resource, int offset) {
			INode leaf = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
			NodeIterator ni = null;
			while (ni == null || ni.hasNext()) {
				INode next = ni == null ? leaf : ni.next();
				if (ni == null)
					ni = new NodeIterator(leaf);
				Assignment ass = GrammarUtil.containingAssignment(next.getGrammarElement());
				if (ass != null) {
					EObject object = NodeModelUtils.findActualSemanticObjectFor(next);
					EStructuralFeature feat = object.eClass().getEStructuralFeature(ass.getFeature());
					if (feat != null && matches(object, feat))
						return Tuples.create(object, feat);
				}
			}
			throw new RuntimeException("No EStructuralFeature found at offset " + offset);
		}

		public EObject getEObject() {
			return object;
		}

		public EStructuralFeature getEStructuralFeature() {
			return feature;
		}

		protected boolean matches(EObject object, EStructuralFeature feature) {
			return true;
		}

	}

	public static interface ICrossEReferenceAndEObject extends IEObjectOwner {
		EReference getCrossEReference();
	}

	public static interface IEAttributeAndEObject extends IEObjectOwner {
		EAttribute getEAttribute();
	}

	public static interface IEObjectOwner {
		EObject getEObject();
	}

	public static interface IEReferenceAndEObject extends IEObjectOwner {
		EReference getEReference();
	}

	public static interface IEStructuralFeatureAndEObject extends IEObjectOwner {
		EStructuralFeature getEStructuralFeature();
	}

	protected static class NodeProvider extends ParameterProvider {

		public NodeProvider(XtextResource res, int offset) {
			super(NodeModelUtils.findLeafNodeAtOffset(res.getParseResult().getRootNode(), offset));
		}

	}

	private XtextResource resource;

	public XtextOffsetAdapter(XtextResource resource) {
		this.resource = resource;
	}

	public IParameterProvider adapt(IParameterProvider provider, Class<?> expectedType) {
		if (provider instanceof AbstractOffsetProvider) {
			int offset = provider.get(Integer.TYPE);
			if (expectedType == IEStructuralFeatureAndEObject.class)
				return new ParameterProvider(new EAttributeAndEObject(resource, offset));
			if (expectedType == IEAttributeAndEObject.class)
				return new ParameterProvider(new EAttributeAndEObject(resource, offset));
			if (expectedType == IEReferenceAndEObject.class)
				return new ParameterProvider(new EReferenceAndEObject(resource, offset));
			if (expectedType == ICrossEReferenceAndEObject.class)
				return new ParameterProvider(new CrossEReferenceAndEObject(resource, offset));
			if (expectedType == INode.class || expectedType == ILeafNode.class)
				return new NodeProvider(resource, offset);
			if (EObject.class.isAssignableFrom(expectedType))
				return new EObjectProvider(resource, offset, expectedType);
		}
		return null;
	}

	protected boolean canAdapt(Class<?> expectedType) {
		return expectedType == IEStructuralFeatureAndEObject.class || //
				expectedType == IEAttributeAndEObject.class || //
				expectedType == IEReferenceAndEObject.class || //
				expectedType == ICrossEReferenceAndEObject.class || //
				expectedType == INode.class || //
				expectedType == ILeafNode.class || //
				EObject.class.isAssignableFrom(expectedType);

	}

	public boolean canAdapt(IParameterProvider provider, Class<?> expectedType) {
		return provider instanceof AbstractOffsetProvider && canAdapt(expectedType);
	}

	public XtextResource getResource() {
		return resource;
	}

}
