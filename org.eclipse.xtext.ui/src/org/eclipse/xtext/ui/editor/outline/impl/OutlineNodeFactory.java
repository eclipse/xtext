/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * Creates {@link IOutlineNode} and links them to a text location.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public class OutlineNodeFactory {

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	
	public IOutlineNode createRoot(IXtextDocument document, ImageDescriptor imageDescriptor, Object text, IOutlineTreeStructureProvider provider) {
		DocumentRootNode documentNode = new DocumentRootNode(imageDescriptor, 
				text, document, provider);
		documentNode.setTextRegion(new TextRegion(0, document.getLength()));
		return documentNode;
	}

	public EStructuralFeatureNode createEStructuralFeatureNode(IOutlineNode parentNode, EObject owner, EStructuralFeature feature,
			ImageDescriptor imageDescriptor, Object text, boolean isLeaf) {
		boolean isFeatureSet = owner.eIsSet(feature);
		EStructuralFeatureNode eStructuralFeatureNode = new EStructuralFeatureNode(owner, feature, parentNode, imageDescriptor,
				text, isLeaf || !isFeatureSet);
		if (isFeatureSet) {
			ITextRegion region = locationInFileProvider.getFullTextRegion(owner, feature, 0);
			if (feature.isMany()) {
				int numValues = ((Collection<?>) owner.eGet(feature)).size();
				ITextRegion fullTextRegion = locationInFileProvider.getFullTextRegion(owner, feature, numValues - 1);
				if(fullTextRegion != null)
					region = region.merge(fullTextRegion);
			}
			eStructuralFeatureNode.setTextRegion(region);
		}
		return eStructuralFeatureNode;
	}

	public EObjectNode createEObjectNode(IOutlineNode parentNode, EObject modelElement, ImageDescriptor imageDescriptor, Object text,
			boolean isLeaf) {
		EObjectNode eObjectNode = new EObjectNode(modelElement, parentNode, imageDescriptor, text, isLeaf);
		ICompositeNode parserNode = NodeModelUtils.getNode(modelElement);
		if (parserNode != null)
			eObjectNode.setTextRegion(parserNode.getTextRegion());
		if(isLocalElement(parentNode, modelElement))
			eObjectNode.setShortTextRegion(locationInFileProvider.getSignificantTextRegion(modelElement));
		return eObjectNode;
	}
	
	protected boolean isLocalElement(IOutlineNode node, final EObject element) {
		if(node instanceof AbstractOutlineNode) {
			return ((AbstractOutlineNode)node).getDocument().tryReadOnly(new IUnitOfWork<Boolean, XtextResource>() {
				@Override
				public Boolean exec(XtextResource state) throws Exception {
					return element.eResource() == state;
				}
			}, () -> false);
		}
		return true;
	}
	
	protected ILocationInFileProvider getLocationInFileProvider() {
		return locationInFileProvider;
	}
}
