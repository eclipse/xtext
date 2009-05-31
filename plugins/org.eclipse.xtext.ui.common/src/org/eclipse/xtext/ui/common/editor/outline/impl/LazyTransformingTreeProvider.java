/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.impl;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.IFilterableContentProvider;
import org.eclipse.xtext.ui.common.editor.outline.ILazyTreeProvider;
import org.eclipse.xtext.ui.common.editor.outline.IOutlineFilter;
import org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer;
import org.eclipse.xtext.ui.common.editor.outline.ISortableContentProvider;
import org.eclipse.xtext.ui.common.internal.Activator;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class LazyTransformingTreeProvider extends LabelProvider implements ILazyTreeProvider, ISortableContentProvider, IFilterableContentProvider {

	final static Logger logger = Logger.getLogger(LazyTransformingTreeProvider.class);

	private final LocalResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources());

	private TreeViewer viewer;
	private ContentOutlineNode outlineModel;

	@Override
	public void dispose() {
		super.dispose();
		resourceManager.dispose();
		outlineModel = null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		Assert.isTrue(viewer instanceof TreeViewer);
		this.viewer = (TreeViewer) viewer;

		if (newInput instanceof XtextDocument) {
			XtextDocument document = (XtextDocument) newInput;
			outlineModel = document.readOnly(new IUnitOfWork<ContentOutlineNode, XtextResource>() {
				public ContentOutlineNode exec(XtextResource resource) throws Exception {
					if (resource == null || resource.getParseResult() == null || resource.getParseResult().getRootASTElement() == null)
						return createErrorNode();
					EObject semanticModelRoot = resource.getParseResult().getRootASTElement();
					return transformSemanticModelToOutlineModel(semanticModelRoot);
				}

				private ContentOutlineNode createErrorNode() {
					ContentOutlineNode errorNode = new ContentOutlineNode();
					errorNode.setLabel("Error: No model available.");
					return errorNode;
				}
			});
		}
	}

	@Inject
	private ISemanticModelTransformer semanticModelTransformer;

	private ContentOutlineNode transformSemanticModelToOutlineModel(EObject semanticModel) {
		return semanticModelTransformer.transformSemanticModel(semanticModel);
	}

	public Object getParent(Object element) {
		if (element instanceof ContentOutlineNode) {
			return ((ContentOutlineNode) element).getParent();
		}
		return outlineModel;
	}

	public void updateChildCount(Object element, int currentChildCount) {
		int length = 0;
		if (outlineModel != null) { // happens when tree had been disposed.
			if (element instanceof IXtextDocument) {
				length = outlineModel.getChildren().size();
			}
			else if (element instanceof ContentOutlineNode) {
				ContentOutlineNode node = (ContentOutlineNode) element;
				length = node.getChildren().size();
			}
		}
		viewer.setChildCount(element, length);
	}

	public void updateElement(Object parent, int index) {
		if (logger.isDebugEnabled()) {
			logger.debug("Updating tree element at index [" + index + "]");
		}
		Object element = null;
		if (parent instanceof IXtextDocument) {
			element = outlineModel.getChildren().get(index);
		}
		else if (parent instanceof ContentOutlineNode) {
			element = ((ContentOutlineNode) parent).getChildren().get(index);
		}
		viewer.replace(parent, index, element);
		updateChildCount(element, -1);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof ContentOutlineNode) {
			ContentOutlineNode contentOutlineNode = (ContentOutlineNode) element;
			return contentOutlineNode.getLabel();
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof ContentOutlineNode) {
			ContentOutlineNode contentOutlineNode = (ContentOutlineNode) element;
			Image image = contentOutlineNode.getImage();
			if (image == null) {
				ImageDescriptor imageDescriptor = contentOutlineNode.getImageDescriptor();
				if (imageDescriptor == null) {
					imageDescriptor = Activator.getImageDescriptor("icons/defaultoutlinenode.gif");
				}
				image = resourceManager.createImage(imageDescriptor);
				contentOutlineNode.setImage(image);
			}
			return image;
		}
		return super.getImage(element);
	}

	public void setSorted(boolean on) {
		semanticModelTransformer.setSorted(on);
	}

	public void enableFilter(IOutlineFilter filterSpec) {
		semanticModelTransformer.enableFilter(filterSpec);
	}

	public void disableFilter(IOutlineFilter filterSpec) {
		semanticModelTransformer.disableFilter(filterSpec);
	}

}
