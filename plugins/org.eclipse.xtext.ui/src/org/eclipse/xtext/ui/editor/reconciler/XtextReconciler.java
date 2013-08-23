/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.ContentAssistantFacade;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.ISourceViewerExtension4;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextDocumentContentObserver;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.DiffUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * Reconciling strategy that reconciles an {@link IXtextDocument}'s contents with the model in the underlying
 * {@link XtextResource}.
 * 
 * Standard JFace Reconcilers, e.g. the MonoReconciler, convert an replace event into a delete and an insert
 * DirtyRegion. This leads to significant overhead, as DRs of different types cannot be merged, and the partial parsing
 * has to be performed for each DR in the queue. We overcome this situation by writing our own reconciler that only
 * creates ReplaceRegions which can always be merged, such that we have to call the partial parser only once.
 * 
 * Additionally, we simplify the reconciler by using the Job API.
 * 
 * @author Jan Koehnlein - Initial contribution and API
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
	private int delay;
	private IReconcilingStrategy strategy;
	private boolean initalProcessDone;
	
	@Inject
	private XtextReconcilerDebugger debugger;
	
	private LinkedBlockingQueue<DocumentEvent> pendingChanges = new LinkedBlockingQueue<DocumentEvent>();

	/**
	 * A special {@link DocumentEvent} that signals that an editors input has been replaced.
	 * 
	 * @author Jan Koehnlein - Initial contribution and API
	 * @since 2.4
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	protected class InputChangedDocumentEvent extends DocumentEvent {
		public InputChangedDocumentEvent(IDocument oldInput, IDocument newInput) {
			super(newInput, 0, oldInput.getLength(), newInput.get());
		}
	}
	
	protected class DocumentListener implements IXtextDocumentContentObserver, ICompletionListener {

		private volatile boolean sessionStarted = false;

		public void documentAboutToBeChanged(DocumentEvent event) {
		}

		public void documentChanged(DocumentEvent event) {
			handleDocumentChanged(event);
		}

		public void performNecessaryUpdates(Processor processor) {
			try {
				if (!pendingChanges.isEmpty()) {
					processor.process(new IUnitOfWork.Void<XtextResource>() {
						@Override
						public void process(XtextResource state) throws Exception {
							doRun(state, null);
						}
					});
				}
			} catch (Exception exc) {
				log.error("Error while forcing reconciliation", exc);
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
			// do nothing
		}

	}

	/**
	 * Reconciles the entire document when the document in the viewer is changed. This happens when the document is
	 * initially opened, as well as after a save-as.
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
		super(Messages.XtextReconciler_JobName);
		setPriority(Job.SHORT);
		setSystem(true);
		isInstalled = false;
		documentListener = new DocumentListener();
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
				if (strategy instanceof ISourceViewerAware) {
					((ISourceViewerAware) strategy).setSourceViewer((ISourceViewer) textViewer);
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
				if (textViewer.getDocument() instanceof IXtextDocument) {
					((IXtextDocument) textViewer.getDocument()).removeXtextDocumentContentObserver(documentListener);
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
		if (oldInput instanceof IXtextDocument) {
			((IXtextDocument) oldInput).removeXtextDocumentContentObserver(documentListener);
		}
		if (newInput instanceof IXtextDocument) {
			((IXtextDocument) newInput).addXtextDocumentContentObserver(documentListener);
			final IXtextDocument document = XtextDocumentUtil.get(textViewer);
			strategy.setDocument(document);
			if (!initalProcessDone && strategy instanceof IReconcilingStrategyExtension) {
				initalProcessDone = true;
				IReconcilingStrategyExtension reconcilingStrategyExtension = (IReconcilingStrategyExtension) strategy;
				reconcilingStrategyExtension.initialReconcile();
			}
		}
		if (oldInput != null && newInput != null) {
			handleDocumentChanged(new InputChangedDocumentEvent(oldInput, newInput));
		}
	}

	private void handleDocumentChanged(DocumentEvent event) {
		if (Display.getCurrent() == null) {
			log.error("Changes to the document must only be applied from the Display thread to keep them ordered",
					new Exception());
		}
		cancel();
		if (log.isTraceEnabled())
			log.trace("Reconciler cancelled");
		reallyEnqueueEvent(event);
		schedule(delay);
		if (log.isTraceEnabled())
			log.trace("Reconciler scheduled with delay: " + delay);
	}

	/**
	 * {@link Display#syncExec(Runnable)} will interrupt the Display thread causing pendingChange.put() to fail. A
	 * skipped event will break the resource, so we try again until the queue eats it.
	 * 
	 * @since 2.4
	 */
	private void reallyEnqueueEvent(DocumentEvent event) {
		try {
			pendingChanges.put(event);
		} catch (InterruptedException e) {
			reallyEnqueueEvent(event);
		}
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
	protected IStatus run(final IProgressMonitor monitor) {
		if (monitor.isCanceled() || paused)
			return Status.CANCEL_STATUS;

		long start = System.currentTimeMillis();
		final IXtextDocument document = XtextDocumentUtil.get(textViewer);
		if (document instanceof XtextDocument) {
			((XtextDocument) document).internalModify(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					doRun(state, monitor);
				}
			});
		}
		if (log.isDebugEnabled())
			log.debug("Reconciliation finished. Time required: " + (System.currentTimeMillis() - start)); //$NON-NLS-1$
		return Status.OK_STATUS;
	}

	/**
	 * Not thread safe. Guard access with a transaction on the resource.
	 * 
	 * @since 2.4
	 */
	private ReconcilerReplaceRegion getMergedReplaceRegion(XtextResource resource) {
		List<DocumentEvent> events = newArrayListWithExpectedSize(pendingChanges.size());
		pendingChanges.drainTo(events);
		if (events.isEmpty() || resource == null)
			return null;
		IParseResult parseResult = resource.getParseResult();
		String resourceText = (parseResult != null) ? parseResult.getRootNode().getText() : "";
		ReconcilerReplaceRegion.Builder builder = ReconcilerReplaceRegion.builder(resourceText);
		for (DocumentEvent event : events) {
			if (event instanceof InputChangedDocumentEvent) {
				builder = ReconcilerReplaceRegion.builder(resourceText);
				if(!resourceText.equals(event.getText())) {
					if(log.isDebugEnabled())
						log.debug("Resource text is not up-to-date:\n" + DiffUtil.diff(resourceText,event.getText()));
					builder.add(0, resourceText.length(), event.getText());
				}
			} else {
				builder.add(event.getOffset(), event.getLength(), event.getText());
			}
		}
		ReconcilerReplaceRegion mergedRegion = builder.create();
		mergedRegion.setModificationStamp(events.get(events.size()-1).getModificationStamp());
		if(log.isDebugEnabled()) {
			for(DocumentEvent event: events)
				mergedRegion.addDocumentEvent(event);
		}
		return mergedRegion;
	}

	/**
	 * @deprecated no longer called by the framework. Use {@link #getMergedReplaceRegion(XtextResource)} instead.
	 */
	@Deprecated
	protected ReplaceRegion getAndResetReplaceRegion() {
		return null;
	}

	/**
	 * Must be run with a write lock on the IXtextDocument.
	 * 
	 * @since 2.4
	 */
	private void doRun(XtextResource state, @Nullable final IProgressMonitor monitor) {
		if (log.isDebugEnabled()) {
			log.debug("Preparing reconciliation."); //$NON-NLS-1$
		}
		final ReconcilerReplaceRegion replaceRegionToBeProcessed = getMergedReplaceRegion(state);
		if (replaceRegionToBeProcessed != null) {
			if (strategy instanceof IReconcilingStrategyExtension) {
				((IReconcilingStrategyExtension) strategy).setProgressMonitor(monitor != null ? monitor
						: new NullProgressMonitor());
			}
			if (strategy instanceof XtextDocumentReconcileStrategy) {
				((XtextDocumentReconcileStrategy) strategy).setResource(state);
			}
			strategy.reconcile(replaceRegionToBeProcessed);
			if (log.isDebugEnabled()) { 
				debugger.assertModelInSyncWithDocument(replaceRegionToBeProcessed.getDocumentEvents().get(0).getDocument(), 
						state, replaceRegionToBeProcessed);
				debugger.assertResouceParsedCorrectly(state, replaceRegionToBeProcessed);
			}
		}
	}
}
