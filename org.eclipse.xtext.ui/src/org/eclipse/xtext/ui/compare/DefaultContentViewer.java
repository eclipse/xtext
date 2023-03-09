/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.text.ITextViewerExtension2;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultContentViewer extends AbstractContentViewer {
	@Inject
	protected XtextSourceViewerConfiguration sourceViewerConfiguration;
	@Inject
	protected StreamContentDocumentProvider documentProvider;

	@Override
	protected ISourceViewer createSourceViewer() {
		return new SourceViewer(getParent(), null, SWT.LEFT_TO_RIGHT | SWT.H_SCROLL | SWT.V_SCROLL);
	}

	@Override
	protected void configureSourceViewer(ISourceViewer sourceViewer) {
		sourceViewer.setEditable(false);
		sourceViewer.configure(sourceViewerConfiguration);
		if (sourceViewer instanceof ITextViewerExtension6) {
			ITextViewerExtension6 textViewerExtension6 = (ITextViewerExtension6) sourceViewer;
			textViewerExtension6.setHyperlinkDetectors(null,
					sourceViewerConfiguration.getHyperlinkStateMask(sourceViewer));
		}
		if (sourceViewer instanceof ITextViewerExtension2) {
			ITextViewerExtension2 textViewerExtension2 = (ITextViewerExtension2) sourceViewer;
			String[] configuredContentTypes = sourceViewerConfiguration.getConfiguredContentTypes(sourceViewer);
			for (String contentType : configuredContentTypes) {
				textViewerExtension2.removeTextHovers(contentType);
			}
		}
	}

	@Override
	public void setInput(Object input) {
		documentProvider.disconnect(getInput());
		super.setInput(input);
		if (input != null) {
			try {
				documentProvider.connect(input);
				sourceViewer.setDocument(documentProvider.getDocument(input));
			} catch (CoreException coreException) {
				throw new WrappedException(coreException);
			}
		}
	}

}
