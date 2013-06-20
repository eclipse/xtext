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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Inject;

/**
 * Reconciling strategy that reconciles an {@link IXtextDocument}'s contents with the model in the underlying
 * {@link XtextResource}. Uses partial parsing to only update a minimum section of the model.
 * 
 * Since 2.4.2, it must run in a write transaction on the document. You have to call
 * {@link #setSourceViewer(ISourceViewer)}, {@link #setDocument(IDocument)} and {@link #setResource(XtextResource)}
 * before calling any reconcile method.
 * 
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 * @author Sebastian Zarnekow
 * @author Jan Koehnlein
 */
public class XtextDocumentReconcileStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension,
		ISourceViewerAware {

	private static final Logger log = Logger.getLogger(XtextDocumentReconcileStrategy.class);

	@Inject
	private XtextSpellingReconcileStrategy.Factory spellingReconcileStrategyFactory;

	private XtextSpellingReconcileStrategy spellingReconcileStrategy;

	private XtextResource resource;

	public void reconcile(final IRegion region) {
		if (log.isTraceEnabled()) {
			log.trace("reconcile region: " + region);
		}
		doReconcile(region);
		if (spellingReconcileStrategy != null) {
			spellingReconcileStrategy.reconcile(region);
		}
	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(subRegion);
	}

	public void setDocument(IDocument document) {
		if (!(document instanceof XtextDocument)) {
			throw new IllegalArgumentException("Document must be an " + XtextDocument.class.getSimpleName());
		}
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

	/**
	 * @since 2.4
	 */
	public void setResource(XtextResource resource) {
		this.resource = resource;
	}

	/**
	 * @since 2.4
	 */
	protected void doReconcile(IRegion region) {
		if (resource == null) {
			if (log.isDebugEnabled())
				log.debug("Resource is null in XtextReconcilerUnitOfWork.");
			return;
		}
		if (log.isDebugEnabled())
			log.debug("Preparing reconciliation.");
		try {
			if (!(region instanceof ReconcilerReplaceRegion)) {
				throw new IllegalArgumentException("Region to be reconciled must be a ReplaceRegion");
			}
			ReconcilerReplaceRegion replaceRegionToBeProcessed = (ReconcilerReplaceRegion) region;
			if (log.isTraceEnabled()) {
				log.trace("Parsing replace region '" + replaceRegionToBeProcessed + "'.");
			}
			resource.update(replaceRegionToBeProcessed.getOffset(), replaceRegionToBeProcessed.getLength(),
					replaceRegionToBeProcessed.getText());
			resource.setModificationStamp(replaceRegionToBeProcessed.getModificationStamp());
		} catch (RuntimeException exc) {
			log.error("Parsing in reconciler failed.", exc);
			throw exc;
		}
	}
}
