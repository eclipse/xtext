/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DocumentRootNode extends AbstractOutlineNode {

	private IXtextDocument document;
	
	private IOutlineTreeStructureProvider treeProvider;

	/**
	 * A {@link BackgroundOutlineTreeProvider} must use
	 * {@link #DocumentRootNode(ImageDescriptor, Object, IXtextDocument, IOutlineTreeStructureProvider)} instead.
	 */
	public DocumentRootNode(Image image, Object text, IXtextDocument document,
			IOutlineTreeStructureProvider treeProvider) {
		super(null, image, text, false);
		this.document = document;
		this.treeProvider = treeProvider;
	}

	/**
	 * @since 2.4
	 */
	public DocumentRootNode(ImageDescriptor imageDescriptor, Object text, IXtextDocument document,
			IOutlineTreeStructureProvider treeProvider) {
		super(null, imageDescriptor, text, false);
		this.document = document;
		this.treeProvider = treeProvider;
	}

	@Override
	public IXtextDocument getDocument() {
		return document;
	}

	@Override
	public IOutlineTreeStructureProvider getTreeProvider() {
		return treeProvider;
	}

	@Override
	public <T> T readOnly(final IUnitOfWork<T, EObject> work) {
		return document.tryReadOnly(new IUnitOfWork<T, XtextResource>() {
			@Override
			public T exec(XtextResource resource) throws Exception {
				if(!resource.getContents().isEmpty()) {
					return work.exec(resource.getContents().get(0));
				}
				return null;
			}
		});
	}
}
