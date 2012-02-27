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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 * @author Sebastian Zarnekow
 */
public class XtextDocumentReconcileStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension, ISourceViewerAware {

	private static final Logger log = Logger.getLogger(XtextDocumentReconcileStrategy.class);
	
	private XtextDocument document;
	
	@Inject
	private XtextSpellingReconcileStrategy.Factory spellingReconcileStrategyFactory;
	
	private XtextSpellingReconcileStrategy spellingReconcileStrategy;

	public void reconcile(final IRegion region) {
		if (log.isTraceEnabled()) {
			log.trace("reconcile region: " + region, new Exception());
		}
		document.internalModify(new XtextReconcilerUnitOfWork(region, document));
		if (spellingReconcileStrategy != null) {
			spellingReconcileStrategy.reconcile(region);
		}
	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(subRegion);
	}

	public void setDocument(IDocument document) {
		if (!(document instanceof XtextDocument)) {
			throw new IllegalArgumentException("Document must be an "  + XtextDocument.class.getSimpleName());
		}
		this.document = (XtextDocument) document;
		if (spellingReconcileStrategy != null) {
			spellingReconcileStrategy.setDocument(document);
		}
	}

	/**
	 * @since 2.3
	 */
	public void setSourceViewer(ISourceViewer sourceViewer) {
		spellingReconcileStrategy = spellingReconcileStrategyFactory.create(sourceViewer);
	}
	
	/**
	 * @since 2.3
	 */
	public void setProgressMonitor(IProgressMonitor monitor) {
		if (spellingReconcileStrategy != null) {
			spellingReconcileStrategy.setProgressMonitor(monitor);
		}
	}

	/**
	 * @since 2.3
	 */
	public void initialReconcile() {
		if (spellingReconcileStrategy != null) {
			spellingReconcileStrategy.initialReconcile();
		}
	}

}
