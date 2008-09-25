/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 */
public class XtextDocumentReconcileStrategy implements IReconcilingStrategy {
	
	private static final Logger log = Logger.getLogger(XtextDocumentReconcileStrategy.class);

	private final IXtextDocument document;

	public XtextDocumentReconcileStrategy(ISourceViewer sourceViewer) {
		this.document = (IXtextDocument) sourceViewer.getDocument();
	}

	public void reconcile(final IRegion region) {
		try {
			document.modify(new UnitOfWork<Object>() {
				public Object exec(XtextResource resource) throws Exception {
					resource.update(region.getOffset(), document.get(region.getOffset(), region.getLength()));
					return null;
				}});
		} catch (Throwable t) {
			log.error("Reconciling failed. " + t);
		}
	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(subRegion);
	}

	public void setDocument(IDocument document) {
	}

}
