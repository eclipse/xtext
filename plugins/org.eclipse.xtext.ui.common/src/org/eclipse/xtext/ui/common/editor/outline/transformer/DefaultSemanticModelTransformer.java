/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.transformer;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.IContentOutlineNodeFactory;
import org.eclipse.xtext.util.concurrent.IStateAccess;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Michael Clay
 */
public class DefaultSemanticModelTransformer extends AbstractSemanticModelTransformer {
	private static final Logger logger = Logger.getLogger(DefaultSemanticModelTransformer.class);
	@Inject
	private IContentOutlineNodeFactory contentOutlineNodeFactory;

	private IStateAccess<XtextResource> resourceAccess;

	public void setResourceAccess(IStateAccess<XtextResource> resourceAccess) {
		this.resourceAccess = resourceAccess;
	}

	public void setContentOutlineNodeFactory(IContentOutlineNodeFactory contentOutlineNodeFactory) {
		this.contentOutlineNodeFactory = contentOutlineNodeFactory;
	}

	@Override
	public boolean consumeSemanticNode(EObject semanticModelObject) {
		if (semanticModelObject != null) {
			String name = semanticModelObject.eClass().getName();
			if (logger.isDebugEnabled()) {
				logger.debug("Consume semantic node type [" + name + "]?");
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean consumeSemanticChildNodes(EObject semanticModelObject) {
		if (semanticModelObject != null) {
			String name = semanticModelObject.eClass().getName();
			if (logger.isDebugEnabled()) {
				logger.debug("Consume semantic children of node type [" + name + "]?");
			}
			return true;
		}
		return false;
	}

	protected ContentOutlineNode newOutlineNode(EObject semanticModelObject, ContentOutlineNode outlineParentNode) {
		return contentOutlineNodeFactory.create(resourceAccess, semanticModelObject, outlineParentNode);
	}

	@Override
	protected ContentOutlineNode createOutlineNode(EObject semanticModelObject, ContentOutlineNode outlineParentNode) {
		return newOutlineNode(semanticModelObject, outlineParentNode);
	}
	
	public IContentOutlineNodeFactory getContentOutlineNodeFactory() {
		return contentOutlineNodeFactory;
	}

}