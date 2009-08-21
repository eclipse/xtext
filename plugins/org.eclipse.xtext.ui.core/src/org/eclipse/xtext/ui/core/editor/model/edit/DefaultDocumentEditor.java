/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model.edit;

import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;

import com.google.inject.Inject;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DefaultDocumentEditor implements IDocumentEditor {

	@Inject
	private ITextEditComposer composer;

	private final class ReconcilingUnitOfWork<T> implements IUnitOfWork<T, XtextResource> {

		private final IUnitOfWork<T, XtextResource> work;
		private final IXtextDocument document;

		private ReconcilingUnitOfWork(IUnitOfWork<T, XtextResource> work, IXtextDocument document) {
			this.work = work;
			this.document = document;
		}

		public T exec(XtextResource state) throws Exception {
			composer.beginRecording(state);
			T result = work.exec(state);
			final TextEdit edit = composer.endRecording();
			if (edit != null) {
				String original = document.get();
				try {
					edit.apply(document);
				}
				catch (Exception e) {
					document.set(original);
					throw new RuntimeException(e);
				}
			}
			return result;
		}
	}

	public <T> T process(final IUnitOfWork<T, XtextResource> work, final IXtextDocument document) {
		IUnitOfWork<T, XtextResource> reconcilingUnitOfWork = new ReconcilingUnitOfWork<T>(work, document);
		return document.modify(reconcilingUnitOfWork);
	}

}
