/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.codemining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.codemining.AbstractCodeMiningProvider;
import org.eclipse.jface.text.codemining.ICodeMining;
import org.eclipse.jface.text.codemining.LineContentCodeMining;
import org.eclipse.jface.text.codemining.LineHeaderCodeMining;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;

import com.google.common.annotations.Beta;

/**
 * Xtext integration for Code Mining support. Clients have to subclass and
 * compute minings for a given Xtext resource.
 * 
 * @since 2.14
 * @author René Purrio - Initial contribution and API
 * @author Karsten Thoms - Initial contribution and API
 */
@Beta
public abstract class AbstractXtextCodeMiningProvider extends AbstractCodeMiningProvider {
	/*
	 * This indicator checks if monitor is canceled or if
	 * CancelableUnitOfWork-cancelIndicator is canceled.
	 */
	private static class CombinedCancelIndicator implements CancelIndicator {
		private IProgressMonitor monitor;
		private CancelIndicator uowCancelIndicator;

		public CombinedCancelIndicator(IProgressMonitor monitor, CancelIndicator uowCancelIndicator) {
			this.monitor = monitor;
			this.uowCancelIndicator = uowCancelIndicator;
		}

		@Override
		public boolean isCanceled() {
			// uowCancelIndicator.isCanceled() will return true, when the resource was changed
			// thanks to CancelableUnitOfWork
			return (uowCancelIndicator != null && uowCancelIndicator.isCanceled())
					// monitor.isCanceled() throws an CancellationException when monitor is canceled
					|| (monitor != null && monitor.isCanceled());
		}
	}

	@Override
	public CompletableFuture<List<? extends ICodeMining>> provideCodeMinings(ITextViewer viewer,
			IProgressMonitor monitor) {
		CompletableFuture<List<? extends ICodeMining>> future = CompletableFuture.supplyAsync(() -> {
			CancelableUnitOfWork<List<ICodeMining>, XtextResource> uow = new CancelableUnitOfWork<List<ICodeMining>, XtextResource>() {
				@Override
				public List<ICodeMining> exec(XtextResource resource, CancelIndicator uowCancelIndicator) throws Exception {
					CombinedCancelIndicator indicator = new CombinedCancelIndicator(monitor, uowCancelIndicator);
					return createCodeMinings(viewer.getDocument(), resource, indicator);
				}

			};
			return XtextDocumentUtil.get(viewer).tryReadOnly(uow, () -> Collections.emptyList());
		});
		return future;
	}
	
	/**
	 * Creates code minings for a document
	 * @param document The document
	 * @param resource The resource for that document
	 * @param indicator Cancelation indicator
	 * @return Computed minings
	 * @throws BadLocationException when line number doesn't exists
	 */
	protected List<ICodeMining> createCodeMinings(IDocument document, XtextResource resource,
			CancelIndicator cancelIndicator)
			throws BadLocationException {
		List<ICodeMining> codeMiningList = new ArrayList<>();
		IAcceptor<ICodeMining> acceptor = new IAcceptor<ICodeMining>() {
			@Override
			public void accept(ICodeMining codeMiningObject) {
				if (cancelIndicator.isCanceled()) {
					// do not accept mining and abort processing when operation was canceled
					throw new CancellationException();
				}
				codeMiningList.add(codeMiningObject);
			}
		};
		
		createCodeMinings(document, resource, cancelIndicator, acceptor);

		return codeMiningList;
	}

	/**
	 * Clients have to implement this method to provide code minings.
	 * 
	 * @param document The document
	 * @param resource The resource for that document
	 * @param indicator Cancelation indicator
	 * @param acceptor Accepts created minings
	 * @throws BadLocationException when line number doesn't exists
	 */
	protected abstract void createCodeMinings(IDocument document, XtextResource resource,
			CancelIndicator indicator, IAcceptor<? super ICodeMining> acceptor) throws BadLocationException;

	/**
	 * Creates a {@link LineContentCodeMining} object for an inline annotation.
	 * @param beforeCharacter inline annotation will be created before this character number.
	 * @param contentText text for inline annotation.
	 * @return a new {@link LineContentCodeMining} object.
	 */
	protected LineContentCodeMining createNewLineContentCodeMining(int beforeCharacter, String contentText) {
		return createNewLineContentCodeMining(beforeCharacter, contentText, null);
	}
	
	/**
	 * Creates a {@link LineContentCodeMining} object for an inline annotation.
	 * @param beforeCharacter inline annotation will be created before this character number.
	 * @param contentText text for inline annotation.
	 * @param action the action to execute when mining is clicked and null otherwise.
	 * @return a new {@link LineContentCodeMining} object.
	 */
	protected LineContentCodeMining createNewLineContentCodeMining(int beforeCharacter, String contentText,
			Consumer<MouseEvent> action) {
		return new LineContentCodeMining(new Position(beforeCharacter, 1), this, action) {
			@Override
			protected CompletableFuture<Void> doResolve(ITextViewer viewer, IProgressMonitor monitor) {
				return CompletableFuture.runAsync(() -> {
					super.setLabel(contentText);
				});
			}
		};
	}

	/**
	 * Creates a {@link LineHeaderCodeMining} object for a header annotation.
	 * @param beforeLineNumber the line number where codemining must be drawn. Use 0 if you wish to locate the code mining before the first line number (1).
	 * @param document the document.
	 * @param headerText text for header annotation.
	 * @return a new {@link LineHeaderCodeMining} object.
	 * @throws BadLocationException when line number doesn't exists
	 */
	protected LineHeaderCodeMining createNewLineHeaderCodeMining(int beforeLineNumber, IDocument document,
			String headerText) throws BadLocationException {
		return createNewLineHeaderCodeMining(beforeLineNumber, document, headerText, null);
	}

	/**
	 * Creates a {@link LineHeaderCodeMining} object for a header annotation.
	 * @param beforeLineNumber the line number where codemining must be drawn. Use 0 if you wish to locate the code mining before the first line number (1).
	 * @param document the document.
	 * @param headerText text for header annotation.
	 * @param action the action to execute when mining is clicked and null otherwise.
	 * @return a new {@link LineHeaderCodeMining} object.
	 * @throws BadLocationException when line number doesn't exists
	 */
	protected LineHeaderCodeMining createNewLineHeaderCodeMining(int beforeLineNumber, IDocument document,
		String headerText, Consumer<MouseEvent> action) throws BadLocationException {
		return new LineHeaderCodeMining(beforeLineNumber, document, this, action) {
			@Override
			protected CompletableFuture<Void> doResolve(ITextViewer viewer, IProgressMonitor monitor) {
				return CompletableFuture.runAsync(() -> {
					super.setLabel(headerText);
				});
			}
		};
	}

}
