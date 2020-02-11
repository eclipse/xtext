/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.2
 */
public class OutlineNodeElementOpener {
	
	@Inject
	private IURIEditorOpener uriEditorOpener;
	
	public void open(IOutlineNode node, ISourceViewer textViewer) {
		if (node != null) {
			ITextRegion textRegion = node.getSignificantTextRegion();
			if (textRegion != null && textRegion != ITextRegion.EMPTY_REGION) {
				int offset = textRegion.getOffset();
				int length = textRegion.getLength();
				textViewer.setRangeIndication(offset, length, true);
				textViewer.revealRange(offset, length);
				textViewer.setSelectedRange(offset, length);
			} else {
				node.tryReadOnly(new IUnitOfWork.Void<EObject>() {
					@Override
					public void process(EObject state) throws Exception {
						openEObject(state);
					}
				});
			}
			
		}
	}

	protected void openEObject(EObject state) {
		URI uri = EcoreUtil.getURI(state);
		uriEditorOpener.open(uri, true);
	}

}
