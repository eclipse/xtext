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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DefaultSemanticModelTransformer extends AbstractSemanticModelTransformer {

	final static Logger logger = Logger.getLogger(AbstractSemanticModelTransformer.class);

	private final ILocationInFileProvider locationProvider;

	@Inject
	public DefaultSemanticModelTransformer(ILocationInFileProvider locationProvider, ILabelProvider labelProvider) {
		super(labelProvider);
		this.locationProvider = locationProvider;
	}

	@Override
	public boolean consumeSemanticNode(EObject semanticNode) {
		if (semanticNode != null) {
			String name = semanticNode.eClass().getName();
			if (logger.isDebugEnabled()) {
				logger.debug("Consume semantic node type [" + name + "]?");
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean consumeSemanticChildNodes(EObject semanticNode) {
		if (semanticNode != null) {
			String name = semanticNode.eClass().getName();
			if (logger.isDebugEnabled()) {
				logger.debug("Consume semantic children of node type [" + name + "]?");
			}
			return true;
		}
		return false;
	}

	@Override
	protected boolean doSortChildren(EObject semanticNode) {
		return false;
	}

	@Override
	protected ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = new ContentOutlineNode();

		outlineNode.setLabel(getText(semanticNode));
		Image image = getImage(semanticNode);
		if (image != null) {
			outlineNode.setImage(image);
		}

		Region location = locationProvider.getLocation(semanticNode);
		outlineNode.setSelectionOffset(location.getOffset());
		outlineNode.setSelectionLength(location.getLength());

		// link with parent
		if (outlineParentNode != null) {
			outlineParentNode.getChildren().add(outlineNode);
			outlineNode.setParent(outlineParentNode);
		}

		/*
		 * This adapter will be added to the semantic node in order to later be
		 * able to get the corresponding ContentOutlineNode. This is needed e.g.
		 * when we want to synch the outline with the currently selected editor
		 * position.
		 *
		 * XXX SZ: is this feasible? What if I want to create more than one one outline node
		 *         per semantic node? Can't we use the offset information of the outline node
		 *         and the editor to synchronize them?
		 *     PF: Reason for using an adapter was to not need to traverse a (more or less)
		 *         large part the outline model when syncing the outline to the editor selection.
		 *         However, SZ and I agreed on leaving it as-is and look into a tree traversal
		 *         approach if we run into memory problems.
		 */
		ContentOutlineNodeAdapter outlineAdapter = (ContentOutlineNodeAdapter) ContentOutlineNodeAdapterFactory.INSTANCE
				.adapt(semanticNode, ContentOutlineNode.class);
		outlineAdapter.setContentOutlineNode(outlineNode);

		return outlineNode;
	}

}