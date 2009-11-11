/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.transformer;

import java.util.List;

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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.ITreeProvider;
import org.eclipse.xtext.ui.common.internal.Activator;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class TransformingTreeProvider extends LabelProvider implements ITreeProvider {
	
	private static final Object[] EMPTY_ARRAY = new Object[0];

	final static Logger logger = Logger.getLogger(TransformingTreeProvider.class);

	private final LocalResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources());

	private ContentOutlineNode outlineModel;
	
	@Override
	public void dispose() {
		super.dispose();
		resourceManager.dispose();
		outlineModel = null;
	}
	
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		Assert.isTrue(viewer instanceof TreeViewer);

		if (newInput instanceof XtextDocument) {
			XtextDocument document = (XtextDocument) newInput;
			semanticModelTransformer.setResourceAccess(document);
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

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ContentOutlineNode) {
			ContentOutlineNode node = (ContentOutlineNode) parentElement;
			List<ContentOutlineNode> children = node.getChildren();
			return children.toArray();
		}
		return null;
	}

	public Object getParent(Object element) {
		if (element instanceof ContentOutlineNode) {
			ContentOutlineNode node = (ContentOutlineNode) element;
			return node.getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof ContentOutlineNode) {
			ContentOutlineNode node = (ContentOutlineNode) element;
			return (node.getChildren().size() > 0);
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		if (outlineModel != null) {
			List<ContentOutlineNode> children = outlineModel.getChildren();
			return children.toArray();
		}
		return EMPTY_ARRAY;
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

}
