/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * The default implementation of an {@link IOutlineTreeProvider}.
 * If you would like to run your outline in Background, please have a look at {@link BackgroundOutlineTreeProvider}.
 * Please note that this would have implications to you LabelProvider implementation. Please read the JavaDoc in the mentioned class carefully.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultOutlineTreeProvider implements IOutlineTreeStructureProvider, IOutlineTreeProvider, IOutlineTreeProvider.Cancelable {

	@Inject
	protected ILabelProvider labelProvider;

	@Inject
	protected ILocationInFileProvider locationInFileProvider;

	private CancelIndicator cancelIndicator = CancelIndicator.NullImpl;
	
	public DefaultOutlineTreeProvider() {
	}

	/**
	 * For testing.
	 */
	public DefaultOutlineTreeProvider(ILabelProvider labelProvider, ILocationInFileProvider locationInFileProvider) {
		this.labelProvider = labelProvider;
		this.locationInFileProvider = locationInFileProvider;
	}

	protected PolymorphicDispatcher<Void> createChildrenDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_createChildren", 2, 2, this);

	protected PolymorphicDispatcher<Void> createNodeDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_createNode", 2, 2, this);

	protected PolymorphicDispatcher<Object> textDispatcher = PolymorphicDispatcher.createForSingleTarget("_text", 1, 1,
			this);

	protected PolymorphicDispatcher<Image> imageDispatcher = PolymorphicDispatcher.createForSingleTarget("_image", 1,
			1, this);

	protected PolymorphicDispatcher<Boolean> isLeafDispatcher = PolymorphicDispatcher.createForSingleTarget("_isLeaf",
			1, 1, this);

	@Override
	public IOutlineNode createRoot(IXtextDocument document) {
		DocumentRootNode documentNode = new DocumentRootNode(labelProvider.getImage(document),
				labelProvider.getText(document), document, this);
		documentNode.setTextRegion(new TextRegion(0, document.getLength()));
		return documentNode;
	}
	
	/**
	 * @since 2.7
	 */
	@Override
	public IOutlineNode createRoot(IXtextDocument document, CancelIndicator cancelIndicator) {
		try {
			this.cancelIndicator = cancelIndicator;
			return createRoot(document);
		} finally {
			this.cancelIndicator = CancelIndicator.NullImpl;
		}
	}

	/**
	 * @since 2.7
	 */
	protected void checkCanceled() {
		if(cancelIndicator.isCanceled())
			throw new OperationCanceledException();
	}
	
	@Override
	public void createChildren(IOutlineNode parent, EObject modelElement) {
		checkCanceled();
		if (modelElement != null && parent.hasChildren())
			createChildrenDispatcher.invoke(parent, modelElement);
	}

	protected void _createChildren(DocumentRootNode parentNode, EObject modelElement) {
		createNode(parentNode, modelElement);
	}

	protected void _createChildren(IOutlineNode parentNode, EObject modelElement) {
		for (EObject childElement : modelElement.eContents())
			createNode(parentNode, childElement);
	}

	protected void _createChildren(EStructuralFeatureNode parentNode, EObject modelElement) {
		Object values = modelElement.eGet(parentNode.getEStructuralFeature());
		if (values != null) {
			if (parentNode.getEStructuralFeature().isMany()) {
				for (EObject value : EcoreUtil2.typeSelect((List<?>) values, EObject.class)) {
					createNode(parentNode, value);
				}
			} else {
				if (values instanceof EObject)
					createNode(parentNode, (EObject) values);
			}
		}
	}

	protected void createNode(IOutlineNode parent, EObject modelElement) {
		checkCanceled();
		createNodeDispatcher.invoke(parent, modelElement);
	}

	/**
	 * @since 2.1
	 */
	protected void _createNode(DocumentRootNode parentNode, EObject modelElement) {
		Object text = textDispatcher.invoke(modelElement);
		if (text == null) {
			text = modelElement.eResource().getURI().trimFileExtension().lastSegment();
		}
		createEObjectNode(parentNode, modelElement, imageDispatcher.invoke(modelElement), text,
				isLeafDispatcher.invoke(modelElement));
	}

	protected void _createNode(IOutlineNode parentNode, EObject modelElement) {
		Object text = textDispatcher.invoke(modelElement);
		boolean isLeaf = isLeafDispatcher.invoke(modelElement);
		if (text == null && isLeaf)
			return;
		Image image = imageDispatcher.invoke(modelElement);
		createEObjectNode(parentNode, modelElement, image, text, isLeaf);
	}

	protected EObjectNode createEObjectNode(IOutlineNode parentNode, EObject modelElement) {
		return createEObjectNode(parentNode, modelElement, imageDispatcher.invoke(modelElement),
				textDispatcher.invoke(modelElement), isLeafDispatcher.invoke(modelElement));
	}

	/**
	 * @since 2.2
	 */
	protected boolean isLocalElement(IOutlineNode node, final EObject element) {
		if (node instanceof AbstractOutlineNode) {
			return ((AbstractOutlineNode) node).getDocument().tryReadOnly(new IUnitOfWork<Boolean, XtextResource>() {
				@Override
				public Boolean exec(XtextResource state) throws Exception {
					return element.eResource() == state;
				}
			}, () -> false);
		}
		return true;
	}

	/**
	 * @since 2.1
	 */
	protected EObjectNode createEObjectNode(IOutlineNode parentNode, EObject modelElement, Image image, Object text,
			boolean isLeaf) {
		EObjectNode eObjectNode = new EObjectNode(modelElement, parentNode, image, text, isLeaf);
		ICompositeNode parserNode = NodeModelUtils.getNode(modelElement);
		if (parserNode != null)
			eObjectNode.setTextRegion(parserNode.getTextRegion());
		if (isLocalElement(parentNode, modelElement))
			eObjectNode.setShortTextRegion(locationInFileProvider.getSignificantTextRegion(modelElement));
		return eObjectNode;
	}

	protected boolean _isLeaf(final EObject modelElement) {
		return !Iterables.any(modelElement.eClass().getEAllContainments(), new Predicate<EReference>() {
			@Override
			public boolean apply(EReference containmentRef) {
				return modelElement.eIsSet(containmentRef);
			}
		});
	}

	protected EStructuralFeatureNode createEStructuralFeatureNode(IOutlineNode parentNode, EObject owner,
			EStructuralFeature feature, Image image, Object text, boolean isLeaf) {
		boolean isFeatureSet = owner.eIsSet(feature);
		EStructuralFeatureNode eStructuralFeatureNode = new EStructuralFeatureNode(owner, feature, parentNode, image,
				text, isLeaf || !isFeatureSet);
		setTextRegion(eStructuralFeatureNode, isFeatureSet, owner, feature);
		return eStructuralFeatureNode;
	}

	/**
	 * @since 2.12
	 */
	protected EStructuralFeatureNode createEStructuralFeatureNode(IOutlineNode parentNode, EObject owner,
			EStructuralFeature feature, ImageDescriptor imageDescriptor, Object text, boolean isLeaf) {
		boolean isFeatureSet = owner.eIsSet(feature);
		EStructuralFeatureNode eStructuralFeatureNode = new EStructuralFeatureNode(owner, feature, parentNode, imageDescriptor,
				text, isLeaf || !isFeatureSet);
		setTextRegion(eStructuralFeatureNode, isFeatureSet, owner, feature);
		return eStructuralFeatureNode;
	}

	/**
	 * @since 2.12
	 */
	protected void setTextRegion(EStructuralFeatureNode eStructuralFeatureNode, boolean setTextRegion, EObject owner,
			EStructuralFeature feature) {
		if (setTextRegion) {
			ITextRegion region = locationInFileProvider.getFullTextRegion(owner, feature, 0);
			if (feature.isMany()) {
				int numValues = ((Collection<?>) owner.eGet(feature)).size();
				ITextRegion fullTextRegion = locationInFileProvider.getFullTextRegion(owner, feature, numValues - 1);
				if (fullTextRegion != null)
					region = region.merge(fullTextRegion);
			}
			eStructuralFeatureNode.setTextRegion(region);
		}
	}

	/**
	 * Default for createChildrenDispatcher
	 */
	protected void _createChildren(Object parent, Object element) {
		// do nothing
	}

	/**
	 * Default for createNodeDispatcher
	 */
	protected void _createNode(Object parentObject, EObject modelElement) {
		throw new IllegalArgumentException("Could not find method createNode(" + nullSafeClassName(parentObject) + ","
				+ nullSafeClassName(modelElement));
	}

	/**
	 * Default for isLeafDispatcher
	 */
	protected boolean _isLeaf(Object modelElement) {
		return true;
	}

	/**
	 * Default for textDispatcher
	 */
	protected Object _text(Object modelElement) {
		if (labelProvider instanceof IStyledLabelProvider)
			return ((IStyledLabelProvider) labelProvider).getStyledText(modelElement);
		else
			return labelProvider.getText(modelElement);
	}

	/**
	 * Default for imageDispatcher
	 */
	protected Image _image(Object modelElement) {
		return labelProvider.getImage(modelElement);
	}

	protected String nullSafeClassName(Object object) {
		return (object != null) ? object.getClass().getName() : "null";
	}
}
