/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.ContentAssistantFacade;
import org.eclipse.jface.text.source.ISourceViewerExtension4;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextDocumentContentObserver;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;

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
	private boolean shouldInstallCompletionListener;
	private volatile boolean paused;
	private ITextViewer textViewer;
	private TextInputListener textInputListener;
	private final DocumentListener documentListener;
	private ReplaceRegion pendingReplaceRegion;
	private final Object pendingReplaceRegionLock;
	private int delay;
	private IReconcilingStrategy strategy;

	protected class DocumentListener implements IXtextDocumentContentObserver, ICompletionListener {

		private volatile boolean sessionStarted = false;
		
		public void documentAboutToBeChanged(DocumentEvent event) {
			
		}

		public void documentChanged(DocumentEvent event) {
			handleDocumentChanged(event);
		}

		public void performNecessaryUpdates(Processor processor) {
			final IXtextDocument document = XtextDocumentUtil.get(textViewer);
			if (document != null && !paused) {
				final ReplaceRegion replaceRegionToBeProcessed = getAndResetReplaceRegion();
				if (replaceRegionToBeProcessed != null) {
					processor.process(new XtextReconcilerUnitOfWork(replaceRegionToBeProcessed, document));
				}
			}
			if (sessionStarted && !paused) {
				pause();
			}
		}

		public void assistSessionStarted(ContentAssistEvent event) {
			sessionStarted = true;
		}

		public void assistSessionEnded(ContentAssistEvent event) {
			sessionStarted = false;
			resume();
		}

		public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
			// TODO Auto-generated method stub
			
		}

	}

	/**
	 * Reconciles the entire document when the document in the viewer is
	 * changed. This happens when the document is initially opened, as well as
	 * after a save-as.
	 */
	protected class TextInputListener implements ITextInputListener {
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
		paused = false;
		shouldInstallCompletionListener = false;
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
			if (textViewer instanceof ISourceViewerExtension4) {
				ContentAssistantFacade facade = ((ISourceViewerExtension4) textViewer).getContentAssistantFacade();
				if (facade == null) {
					shouldInstallCompletionListener = true;
				} else {
					facade.addCompletionListener(documentListener);
				}
			}
			isInstalled = true;
		}
	}

	public void uninstall() {
		if (isInstalled) {
			textViewer.removeTextInputListener(textInputListener);
			isInstalled = false;
			if (documentListener != null) {
				if (textViewer instanceof ISourceViewerExtension4) {
					ContentAssistantFacade facade = ((ISourceViewerExtension4) textViewer).getContentAssistantFacade();
					facade.removeCompletionListener(documentListener);
				}
			}
		}
	}

	protected void handleInputDocumentChanged(IDocument oldInput, IDocument newInput) {
		if (shouldInstallCompletionListener) {
			ContentAssistantFacade facade = ((ISourceViewerExtension4) textViewer).getContentAssistantFacade();
			if (facade != null) {
				facade.addCompletionListener(documentListener);
			}
			shouldInstallCompletionListener = false;
		}
		if (oldInput != null) {
			((IXtextDocument)oldInput).removeXtextDocumentContentObserver(documentListener);
		}
		if (newInput != null) {
			((IXtextDocument) newInput).addXtextDocumentContentObserver(documentListener);
			final IXtextDocument document = XtextDocumentUtil.get(textViewer);
			strategy.setDocument(document);
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
	
	protected void pause() {
		paused = true;
	}

	protected void resume() {
		paused = false;
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
		if (monitor.isCanceled() || paused)
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

	protected ReplaceRegion getAndResetReplaceRegion() {
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
