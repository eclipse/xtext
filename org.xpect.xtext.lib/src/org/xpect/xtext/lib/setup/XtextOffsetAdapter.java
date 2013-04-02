/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
import org.xpect.parameter.AbstractOffsetProvider;
import org.xpect.parameter.IParameterAdapter;
import org.xpect.parameter.IParameterParser.IParsedParameterProvider;
import org.xpect.parameter.IParameterProvider;
import org.xpect.util.IRegion;

import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextOffsetAdapter implements IParameterAdapter {

	protected static class CrossEReferenceAndEObject extends EStructuralFeatureAndEObject implements ICrossEReferenceAndEObject {

		public CrossEReferenceAndEObject(EObject object, EStructuralFeature feature) {
			super(object, feature);
		}

		public EReference getCrossEReference() {
			return (EReference) getEStructuralFeature();
		}

	}

	protected static class CrossEReferenceAndEObjectProvider extends EStructuralFeatureAndEObjectProvider {

		public CrossEReferenceAndEObjectProvider(AbstractOffsetProvider delegate) {
			super(delegate);
		}

		@Override
		public boolean canProvide(Class<?> expectedType) {
			return expectedType.isAssignableFrom(ICrossEReferenceAndEObject.class);
		}

		@Override
		protected EStructuralFeatureAndEObject create(EObject object, EStructuralFeature feat) {
			return new CrossEReferenceAndEObject(object, feat);
		}

		@Override
		protected boolean matches(EObject object, EStructuralFeature feature) {
			return feature instanceof EReference && !((EReference) feature).isContainment();
		}

	}

	protected abstract static class DelegatingOffsetBasedProvider implements IParsedParameterProvider {
		protected final AbstractOffsetProvider delegate;

		public DelegatingOffsetBasedProvider(AbstractOffsetProvider delegate) {
			super();
			this.delegate = delegate;
		}

		public IRegion getClaimedRegion() {
			if (delegate instanceof IParsedParameterProvider)
				return ((IParsedParameterProvider) delegate).getClaimedRegion();
			return null;
		}

		protected int getOffset() {
			return delegate.getOffset();
		}

		public List<IRegion> getSemanticRegions() {
			if (delegate instanceof IParsedParameterProvider)
				return ((IParsedParameterProvider) delegate).getSemanticRegions();
			return Collections.emptyList();
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

	protected static class EAttributeAndEObjectProvider extends EStructuralFeatureAndEObjectProvider {

		public EAttributeAndEObjectProvider(AbstractOffsetProvider delegate) {
			super(delegate);
		}

		@Override
		protected EStructuralFeatureAndEObject create(EObject object, EStructuralFeature feat) {
			return new EAttributeAndEObject(object, feat);
		}

		@Override
		protected boolean matches(EObject object, EStructuralFeature feature) {
			return feature instanceof EAttribute;
		}

	}

	protected static class EObjectProvider extends DelegatingOffsetBasedProvider {

		public EObjectProvider(AbstractOffsetProvider delegate) {
			super(delegate);
		}

		public boolean canProvide(Class<?> expectedType) {
			return EObject.class.isAssignableFrom(expectedType);
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
		public <T> T get(Class<T> expectedType, Map<Class<? extends Annotation>, IParameterProvider> context) {
			XtextResource xtextResource = context.get(ThisResource.class).get(XtextResource.class, context);
			EObject result = find(xtextResource, getOffset(), expectedType);
			if (expectedType.isInstance(result))
				return (T) result;
			return null;
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

	protected static class EReferenceAndEObjectProvider extends EStructuralFeatureAndEObjectProvider {

		public EReferenceAndEObjectProvider(AbstractOffsetProvider delegate) {
			super(delegate);
		}

		@Override
		public boolean canProvide(Class<?> expectedType) {
			return expectedType.isAssignableFrom(IEReferenceAndEObject.class);
		}

		@Override
		protected EStructuralFeatureAndEObject create(EObject object, EStructuralFeature feat) {
			return new EReferenceAndEObject(object, feat);
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

	protected static class EStructuralFeatureAndEObjectProvider extends DelegatingOffsetBasedProvider {

		public EStructuralFeatureAndEObjectProvider(AbstractOffsetProvider delegate) {
			super(delegate);
		}

		public boolean canProvide(Class<?> expectedType) {
			return expectedType.isAssignableFrom(IEStructuralFeatureAndEObject.class);
		}

		protected EStructuralFeatureAndEObject create(EObject object, EStructuralFeature feat) {
			return new EStructuralFeatureAndEObject(object, feat);
		}

		protected EStructuralFeatureAndEObject find(XtextResource resource, int offset) {
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
						return create(object, feat);
				}
			}
			throw new RuntimeException("No EStructuralFeature found at offset " + offset);
		}

		@SuppressWarnings("unchecked")
		public <T> T get(Class<T> expectedType, Map<Class<? extends Annotation>, IParameterProvider> context) {
			XtextResource xtextResource = context.get(ThisResource.class).get(XtextResource.class, context);
			return (T) find(xtextResource, getOffset());
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

	protected static class NodeProvider extends DelegatingOffsetBasedProvider {

		public NodeProvider(AbstractOffsetProvider delegate) {
			super(delegate);
		}

		public boolean canProvide(Class<?> expectedType) {
			return expectedType.isAssignableFrom(ILeafNode.class);
		}

		@SuppressWarnings("unchecked")
		public <T> T get(Class<T> expectedType, Map<Class<? extends Annotation>, IParameterProvider> context) {
			XtextResource xtextResource = context.get(ThisResource.class).get(XtextResource.class, context);
			return (T) NodeModelUtils.findLeafNodeAtOffset(xtextResource.getParseResult().getRootNode(), getOffset());
		}

	}

	public IParameterProvider adapt(IParameterProvider provider, Class<?> expectedType) {
		if (provider instanceof AbstractOffsetProvider) {
			AbstractOffsetProvider delegate = (AbstractOffsetProvider) provider;
			if (expectedType == IEStructuralFeatureAndEObject.class)
				return new EStructuralFeatureAndEObjectProvider(delegate);
			if (expectedType == IEAttributeAndEObject.class)
				return new EAttributeAndEObjectProvider(delegate);
			if (expectedType == IEReferenceAndEObject.class)
				return new EReferenceAndEObjectProvider(delegate);
			if (expectedType == ICrossEReferenceAndEObject.class)
				return new CrossEReferenceAndEObjectProvider(delegate);
			if (expectedType == INode.class || expectedType == ILeafNode.class)
				return new NodeProvider(delegate);
			if (EObject.class.isAssignableFrom(expectedType))
				return new EObjectProvider(delegate);
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

}
