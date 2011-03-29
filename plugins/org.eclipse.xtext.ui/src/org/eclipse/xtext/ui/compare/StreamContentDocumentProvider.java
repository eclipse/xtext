/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.compare.IEncodedStreamContentAccessor;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class StreamContentDocumentProvider extends AbstractDocumentProvider {
	@Inject
	protected Provider<XtextDocument> documentProvider;
	@Inject
	protected Provider<IDocumentPartitioner> documentPartitioner;

	protected XtextDocument createEmptyDocument() {
		return documentProvider.get();
	}

	@Override
	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = null;
		if (element instanceof IStreamContentAccessor) {
			document = createEmptyDocument();
			setupDocument(element, document);
		}
		if (document != null) {
			IDocumentPartitioner partitioner = documentPartitioner.get();
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		return document;
	}

	protected void setupDocument(Object element, IDocument document) {
		if (element instanceof IStreamContentAccessor) {
			document.set(getString(element));
		}
	}

	@Override
	protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
		return null;
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite)
			throws CoreException {

	}

	@Override
	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		return null;
	}

	// helper methods initially copied from o.e.compare.internal.Utilities
	protected String getString(Object input) {
		if (input instanceof IStreamContentAccessor) {
			IStreamContentAccessor streamContentAccessor = (IStreamContentAccessor) input;
			try {
				return readString(streamContentAccessor);
			} catch (CoreException ex) {
				throw new WrappedException(ex);
			}
		}
		return ""; //$NON-NLS-1$
	}

	protected String readString(IStreamContentAccessor streamContentAccessor) throws CoreException {
		InputStream is = streamContentAccessor.getContents();
		if (is != null) {
			String encoding = null;
			if (streamContentAccessor instanceof IEncodedStreamContentAccessor) {
				try {
					encoding = ((IEncodedStreamContentAccessor) streamContentAccessor).getCharset();
				} catch (CoreException exception) {
				}
			}
			if (encoding == null) {
				encoding = ResourcesPlugin.getEncoding();
			}
			return readString(is, encoding);
		}
		return null;
	}

	protected String readString(InputStream is, String encoding) {
		if (is == null) {
			return null;
		}
		BufferedReader reader = null;
		try {
			StringBuffer buffer = new StringBuffer();
			char[] part = new char[2048];
			int read = 0;
			reader = new BufferedReader(new InputStreamReader(is, encoding));

			while ((read = reader.read(part)) != -1)
				buffer.append(part, 0, read);

			return buffer.toString();

		} catch (IOException ex) {

		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {

				}
			}
		}
		return null;
	}

}
