/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DocumentRootNode extends AbstractOutlineNode {

	private IXtextDocument document;
	
	private DefaultOutlineTreeProvider treeProvider;

	public DocumentRootNode(Image image, String text, IXtextDocument document,
			DefaultOutlineTreeProvider treeProvider) {
		super(null, image, text, false);
		this.document = document;
		this.treeProvider = treeProvider;
		setTextRegion(new TextRegion(0, document.getLength()));
	}

	@Override
	public IXtextDocument getDocument() {
		return document;
	}

	@Override
	public DefaultOutlineTreeProvider getTreeProvider() {
		return treeProvider;
	}

	@Override
	public <T> T readOnly(final IUnitOfWork<T, EObject> work) {
		return document.readOnly(new IUnitOfWork<T, XtextResource>() {
			public T exec(XtextResource resource) throws Exception {
				if(resource != null && !resource.getContents().isEmpty()) {
					work.exec(resource.getContents().get(0));
				}
				return null;
			}
		});
	}
}
