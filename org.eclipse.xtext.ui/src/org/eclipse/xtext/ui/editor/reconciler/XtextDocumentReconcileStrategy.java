/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.collect.Lists;
import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

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
 * @author René Purrio - Code Mining support
 * @author Karsten Thoms - Code Mining support
 */
public class XtextDocumentReconcileStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension,
		ISourceViewerAware {

	private static final Logger log = Logger.getLogger(XtextDocumentReconcileStrategy.class);
	
	private List<IReconcileStrategyFactory> strategyFactories = new ArrayList<>();
	
	private List<IReconcilingStrategy> strategies = new ArrayList<>();
	
	private XtextResource resource;

	private IProgressMonitor monitor;

	private XtextEditor editor;

	
	@Inject
	private void initializeStrategyFactories(Injector injector) {
		List<Binding<IReconcileStrategyFactory>> bindingsByType = injector == null ? Lists
				.<Binding<IReconcileStrategyFactory>> newArrayList() : injector.findBindingsByType(TypeLiteral
				.get(IReconcileStrategyFactory.class));
		for (Binding<IReconcileStrategyFactory> binding : bindingsByType) {
			try {
				strategyFactories.add(binding.getProvider().get());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	@Override
	public void reconcile(final IRegion region) {
		if (log.isTraceEnabled()) {
			log.trace("reconcile region: " + region);
		}
		doReconcile(region);
		for (IReconcilingStrategy strategy: strategies) {
			strategy.reconcile(region);
		}
	}

	@Override
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(subRegion);
	}
	
	/**
	 * @since 2.7
	 */
	public void setEditor(XtextEditor editor) {
		this.editor = editor;
	}

	@Override
	public void setDocument(IDocument document) {
		if (!(document instanceof XtextDocument)) {
			throw new IllegalArgumentException("Document must be an " + XtextDocument.class + " but was " + document.getClass().getName());
		}
		for (IReconcilingStrategy strategy: strategies) {
			strategy.setDocument(document);
		}
	}

	/**
	 * @since 2.3
	 */
	@Override
	public void setSourceViewer(ISourceViewer sourceViewer) {
		strategies.clear();
		for(IReconcileStrategyFactory factory: strategyFactories) {
			IReconcilingStrategy strategy = factory.createOrNull(sourceViewer);
			if (strategy != null)
				strategies.add(strategy);
		}
	}

	/**
	 * @since 2.3
	 */
	@Override
	public void setProgressMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
		for (IReconcilingStrategy strategy: strategies) {
			if (strategy instanceof IReconcilingStrategyExtension) {
				((IReconcilingStrategyExtension) strategy).setProgressMonitor(monitor);
			}
		}
	}

	/**
	 * @since 2.3
	 */
	@Override
	public void initialReconcile() {
		for (IReconcilingStrategy strategy: strategies) {
			if (strategy instanceof IReconcilingStrategyExtension) {
				((IReconcilingStrategyExtension) strategy).initialReconcile();
			}
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
			postParse(resource, monitor);
		} catch (OperationCanceledException e) {
			resource.getCache().clear(resource);
		} catch (OperationCanceledError e) {
			resource.getCache().clear(resource);
		} catch (RuntimeException exc) {
			log.error("Parsing in reconciler failed.", exc);
			throw exc;
		}
	}

	/**
	 * @since 2.7
	 */
	protected void postParse(XtextResource resource, final IProgressMonitor monitor) throws OperationCanceledError, OperationCanceledException {
		CancelIndicator cancelIndicator = new CancelIndicator() {
			@Override
			public boolean isCanceled() {
				return monitor.isCanceled();
			}
		};
		try {
			EcoreUtil2.resolveLazyCrossReferences(resource, cancelIndicator);
			if (editor != null) {
				DirtyStateEditorSupport dirtyStateEditorSupport = editor.getDirtyStateEditorSupport();
				if (dirtyStateEditorSupport != null && !monitor.isCanceled())
					dirtyStateEditorSupport.announceDirtyState(resource);
			}
		} catch(OperationCanceledException e) {
			throw e;
		} catch(RuntimeException e) {
			String message = createPostParseErrorMessage(resource);
			log.error(message, e);
			resource.getCache().clear(resource);
		}
	}

	/**
	 * Creates an error message containing the source code of the {@code resource}
	 * 
	 * @since 2.15
	 */
	protected String createPostParseErrorMessage(XtextResource resource) {
		String message = "Error post-processing resource with content";
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			message += ":\n" + parseResult.getRootNode().getText();
		}
		return message;
	}
}
