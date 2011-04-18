/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 * @author Sebastian Zarnekow
 */
public class XtextDocumentReconcileStrategy implements IReconcilingStrategy {

	private static final Logger log = Logger.getLogger(XtextDocumentReconcileStrategy.class);
	
	private XtextDocument document;

	public void reconcile(final IRegion region) {
		if (log.isTraceEnabled()) {
			log.trace("reconcile region: " + region, new Exception());
		}
		document.internalModify(new XtextReconcilerUnitOfWork(region, document));
	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(subRegion);
	}

	public void setDocument(IDocument document) {
		if (!(document instanceof XtextDocument)) {
			throw new IllegalArgumentException("Document must be an "  + XtextDocument.class.getSimpleName());
		}
		this.document = (XtextDocument) document;
	}

}
