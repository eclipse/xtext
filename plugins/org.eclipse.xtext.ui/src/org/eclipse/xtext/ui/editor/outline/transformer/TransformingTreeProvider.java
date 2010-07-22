/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.transformer;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Michael Clay
 */
public class TransformingTreeProvider implements IOutlineTreeProvider {
	private static final Object[] EMPTY_ARRAY = new Object[0];
	@Inject
	private ISemanticModelTransformer semanticModelTransformer;

	private IContentOutlineNode outlineModel;

	private IContentOutlineNode transformSemanticModelToOutlineModel(EObject semanticModel) {
		return semanticModelTransformer.transformSemanticModel(semanticModel);
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		Assert.isTrue(viewer instanceof TreeViewer);

		if (newInput instanceof XtextDocument) {
			XtextDocument document = (XtextDocument) newInput;
			semanticModelTransformer.setResourceAccess(document);
			outlineModel = document.readOnly(new IUnitOfWork<IContentOutlineNode, XtextResource>() {
				public IContentOutlineNode exec(XtextResource resource) throws Exception {
					if (resource == null || resource.getParseResult() == null
							|| resource.getParseResult().getRootASTElement() == null)
						return createErrorNode();
					EObject semanticModelRoot = resource.getParseResult().getRootASTElement();
					return transformSemanticModelToOutlineModel(semanticModelRoot);
				}

				private IContentOutlineNode createErrorNode() {
					return new ContentOutlineNode(new StyledString("Error: No model available.", StyledString
							.createColorRegistryStyler(JFacePreferences.ERROR_COLOR, null)));
				}
			});
		}
	}

	public IContentOutlineNode[] getChildren(Object parentElement) {
		if (parentElement instanceof IContentOutlineNode) {
			IContentOutlineNode node = (IContentOutlineNode) parentElement;
			IContentOutlineNode[] children = node.getChildrenAsArray();
			return children;
		}
		return null;
	}

	public IContentOutlineNode getParent(Object element) {
		if (element instanceof IContentOutlineNode) {
			IContentOutlineNode node = (IContentOutlineNode) element;
			return node.getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof IContentOutlineNode) {
			IContentOutlineNode node = (IContentOutlineNode) element;
			return node.hasChildren();
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		if (outlineModel != null) {
			IContentOutlineNode[] children = outlineModel.getChildrenAsArray();
			return children;
		}
		return EMPTY_ARRAY;
	}

	public void dispose() {
		outlineModel = null;
	}

}
