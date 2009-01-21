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
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.ILazyTreeProvider;
import org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class LazyTransformingTreeProvider extends LabelProvider implements ILazyTreeProvider {

	final static Logger logger = Logger.getLogger(LazyTransformingTreeProvider.class);

	private TreeViewer viewer;
	private ContentOutlineNode outlineModel;

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		Assert.isTrue(viewer instanceof TreeViewer);
		this.viewer = (TreeViewer) viewer;
		
		if (newInput instanceof XtextDocument) {
			XtextDocument document = (XtextDocument) newInput;
			outlineModel = document.readOnly(new UnitOfWork<ContentOutlineNode>() {
				public ContentOutlineNode exec(XtextResource resource) throws Exception {
					EObject semanticModelRoot = resource.getParseResult().getRootASTElement();
					return transformSemanticModelToOutlineModel(semanticModelRoot);
				}
			});
		}
	}
	
	@Inject
	private ISemanticModelTransformer semanticModelTransformer;
	
	private ContentOutlineNode transformSemanticModelToOutlineModel(EObject semanticModel) {
		return semanticModelTransformer.transformSemanticModel(semanticModel);
	}

	public void dispose() {
	}

	public Object getParent(Object element) {
		if (element instanceof ContentOutlineNode) {
			return ((ContentOutlineNode) element).getParent();
		}
		return outlineModel;
	}

	public void updateChildCount(Object element, int currentChildCount) {
		int length = 0;
		if (element instanceof IXtextDocument) {
			length = outlineModel.getChildren().size();
		}
		else if (element instanceof ContentOutlineNode) {
			ContentOutlineNode node = (ContentOutlineNode) element;
			length = node.getChildren().size();
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
			// TODO load image
		}
		return super.getImage(element);
	}

}
