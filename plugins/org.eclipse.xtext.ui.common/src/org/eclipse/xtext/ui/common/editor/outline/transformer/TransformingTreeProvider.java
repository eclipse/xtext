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

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.StyledString;
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
 * @author Michael Clay
 */
public class TransformingTreeProvider extends BaseLabelProvider implements ITreeProvider {
	private static final Object[] EMPTY_ARRAY = new Object[0];
	@Inject
	private ISemanticModelTransformer semanticModelTransformer;
	private final LocalResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources());
	private ContentOutlineNode outlineModel;
	
	private ContentOutlineNode transformSemanticModelToOutlineModel(EObject semanticModel) {
		return semanticModelTransformer.transformSemanticModel(semanticModel);
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
					return new ContentOutlineNode(new StyledString("Error: No model available.", StyledString
							.createColorRegistryStyler(JFacePreferences.ERROR_COLOR, null)));
				}
			});
		}
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
			return (node.getChildren()!=null && node.getChildren().size() > 0);
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

	public StyledString getStyledText(Object element) {
		StyledString styledString = new StyledString();
		if (element instanceof ContentOutlineNode) {
			ContentOutlineNode contentOutlineNode = (ContentOutlineNode) element;
			if (null!=contentOutlineNode.getStyledString()) {
				styledString = contentOutlineNode.getStyledString();
			} else {
				String label = contentOutlineNode.getLabel();
				styledString = new StyledString(null==label?"":label,StyledString.COUNTER_STYLER);
				
			}
		}
		return styledString;
	}

	public Image getImage(Object element) {
		Image image = null;
		if (element instanceof ContentOutlineNode) {
			ContentOutlineNode contentOutlineNode = (ContentOutlineNode) element;
			image = contentOutlineNode.getImage();
			if (image == null) {
				ImageDescriptor imageDescriptor = contentOutlineNode.getImageDescriptor();
				if (imageDescriptor == null) {
					imageDescriptor = Activator.getImageDescriptor("icons/defaultoutlinenode.gif");
				}
				image = resourceManager.createImage(imageDescriptor);
			}
		}
		return image;
	}
	

	@Override
	public void dispose() {
		resourceManager.dispose();
		outlineModel = null;
	}

}
