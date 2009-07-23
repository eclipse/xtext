/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.reconciler;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocumentContentObserver;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;

import com.google.inject.Inject;

/**
 * Standard JFace Reconcilers, e.g. the MonoReconciler, convert an replace event
 * into a delete and an insert DirtyRegion. This leads to significant overhead,
 * as DRs of different types cannot be merged, and the partial parsing has to be
 * performed for each DR in the queue. We overcome this situation by writing our
 * own reconciler that only creates ReplaceRegions which can always be merged,
 * such that we have to call the partial parser only once.
 *
 * Additionally, we simplify the reconciler by using the Job API.
 *
 * @author Jan Köhnlein - Initial contribution and API
 * @author Michael Clay
 */
public class XtextReconciler extends Job implements IReconciler {

	private static final Logger log = Logger.getLogger(XtextReconciler.class);

	private boolean isInstalled;
	private ITextViewer textViewer;
	private TextInputListener textInputListener;
	private final DocumentListener documentListener;
	private ReplaceRegion pendingReplaceRegion;
	private final Object pendingReplaceRegionLock;
	private int delay;
	private IReconcilingStrategy strategy;

	class DocumentListener implements IDocumentListener, IXtextDocumentContentObserver {

		public void documentAboutToBeChanged(DocumentEvent event) {
			// do nothing so far
		}

		public void documentChanged(DocumentEvent event) {
			handleDocumentChanged(event);
		}

		public void performNecessaryUpdates(Processor processor) {
			final IXtextDocument document = XtextDocumentUtil.get(textViewer);
			if (document != null) {
				final ReplaceRegion replaceRegionToBeProcessed = getAndResetReplaceRegion();
				if (replaceRegionToBeProcessed != null) {
					processor.process(new XtextReconcilerUnitOfWork(replaceRegionToBeProcessed, document));
				}
			}
		}

	}

	/**
	 * Reconciles the entire document when the document in the viewer is
	 * changed. This happens when the document is initially opened, as well as
	 * after a save-as.
	 */
	class TextInputListener implements ITextInputListener {
		public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
			// do nothing
		}

		public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
			handleInputDocumentChanged(oldInput, newInput);
		}
	}

	@Inject
	public XtextReconciler(XtextDocumentReconcileStrategy strategy) {
		super("XtextReconcilerJob");
		setPriority(Job.SHORT);
		setSystem(true);
		isInstalled = false;
		documentListener = new DocumentListener();
		pendingReplaceRegionLock = new Object();
		setDelay(500);
		setReconcilingStrategy(strategy);
	}

	public IReconcilingStrategy getReconcilingStrategy(String contentType) {
		return strategy;
	}

	public void setReconcilingStrategy(IReconcilingStrategy strategy) {
		this.strategy = strategy;
	}

	public void install(ITextViewer textViewer) {
		if (!isInstalled) {
			this.textViewer = textViewer;
			textInputListener = new TextInputListener();
			textViewer.addTextInputListener(textInputListener);
			handleInputDocumentChanged(null, textViewer.getDocument());
			isInstalled = true;
		}
	}

	public void uninstall() {
		if (isInstalled) {
			textViewer.removeTextInputListener(textInputListener);
			isInstalled = false;
		}
	}

	/**
	 * @param oldInput
	 * @param newInput
	 */
	private void handleInputDocumentChanged(IDocument oldInput, IDocument newInput) {
		if (oldInput != null) {
			((IXtextDocument)oldInput).removeXtextDocumentContentObserver(documentListener);
		}
		if (newInput != null) {
			((IXtextDocument) newInput).addXtextDocumentContentObserver(documentListener);
			final IXtextDocument document = XtextDocumentUtil.get(textViewer);
			strategy.setDocument(document);
			document.modify(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource resource) throws Exception {
					try {
						if (log.isDebugEnabled())
							log.debug("XtextReconiler: Reparsing document.");
						resource.reparse(document.get());
					}
					catch (Throwable t) {
						if (log.isDebugEnabled())
							log.debug("Partial parsing failed. Performing full reparse", t);
					}
				}
			});
		}
	}

	private void handleDocumentChanged(DocumentEvent event) {
		cancel();
		ReplaceRegion newReplaceRegion = new ReplaceRegion(event.getOffset(), event.getLength(), event.getText());
		synchronized (pendingReplaceRegionLock) {
			if (pendingReplaceRegion != null) {
				pendingReplaceRegion.mergeWith(newReplaceRegion, event.getDocument());
			}
			else {
				pendingReplaceRegion = newReplaceRegion;
			}
		}
		schedule(delay);
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	@Override
	public boolean belongsTo(Object family) {
		return XtextReconciler.class.getName().equals(family);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;

		long start = System.currentTimeMillis();
		if (log.isDebugEnabled()) {
			log.debug("Preparing reconciliation.");
		}

		final IXtextDocument document = XtextDocumentUtil.get(textViewer);
		if (document != null) {
			final ReplaceRegion replaceRegionToBeProcessed = getAndResetReplaceRegion();
			if (replaceRegionToBeProcessed != null) {
				strategy.reconcile(replaceRegionToBeProcessed);
			}
		}
		if (log.isDebugEnabled())
			log.debug("Reconciliation finished. Time required: " + (System.currentTimeMillis() - start));
		return Status.OK_STATUS;
	}

	private ReplaceRegion getAndResetReplaceRegion() {
		final ReplaceRegion replaceRegionToBeProcessed;
		synchronized (pendingReplaceRegionLock) {
			if (pendingReplaceRegion != null) {
				replaceRegionToBeProcessed = pendingReplaceRegion;
			}
			else {
				replaceRegionToBeProcessed = null;
			}
			pendingReplaceRegion = null;
		}
		return replaceRegionToBeProcessed;
	}

}
