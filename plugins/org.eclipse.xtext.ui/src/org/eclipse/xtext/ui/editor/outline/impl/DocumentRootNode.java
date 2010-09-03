/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.util.TextLocation;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DocumentRootNode extends AbstractOutlineNode {

	private IXtextDocument document;
	private IOutlineTreeProvider treeProvider;
	private ILocationInFileProvider locationInFileProvider;

	public DocumentRootNode(Image image, String text, boolean hasPredictedChildren, IXtextDocument document,
			IOutlineTreeProvider treeProvider, ILocationInFileProvider locationInFileProvider) {
		super(null, image, text, hasPredictedChildren);
		this.document = document;
		this.treeProvider = treeProvider;
		this.locationInFileProvider = locationInFileProvider;
		setTextRegion(new TextLocation(0, document.getLength()));
	}

	@Override
	public IXtextDocument getDocument() {
		return document;
	}

	@Override
	public IOutlineTreeProvider getTreeProvider() {
		return treeProvider;
	}

	@Override
	public ILocationInFileProvider getLocationInFileProvider() {
		return locationInFileProvider;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && document.equals(((DocumentRootNode) obj).getDocument());
	}

	@Override
	public int hashCode() {
		return super.hashCode() + 23 * document.hashCode();
	}
}
