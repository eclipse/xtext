/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;

import org.eclipse.compare.IEncodedStreamContentAccessor;
import org.eclipse.compare.IResourceProvider;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class StreamContentDocumentProvider extends AbstractDocumentProvider {
	private static final String SCHEME_REVISION = "revision:/";
	@Inject
	protected Provider<XtextDocument> documentProvider;
	@Inject
	protected Provider<IDocumentPartitioner> documentPartitioner;
	@Inject
	private IResourceSetProvider resourceSetProvider;
	@Inject
	private IResourceFactory resourceFactory;

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
		return document;
	}

	protected void setupDocument(Object element, IDocument document) {
		String content = getString(element);
		document.set(content);

		IDocumentPartitioner partitioner = documentPartitioner.get();
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);

		XtextResource resource = createResource(element);
		loadResource(element, resource);
		if (resource!=null) {
			((XtextDocument) document).setInput(resource);
		}
	}

	protected XtextResource createResource(Object element) {
		XtextResource xtextResource = null;
		if (element instanceof IResourceProvider) {
			IResourceProvider resourceProvider = (IResourceProvider) element;
			IResource resource = resourceProvider.getResource();
			if (resource != null) {
				ResourceSet resourceSet = resourceSetProvider.get(resource.getProject());
				URI uri = URI.createURI(SCHEME_REVISION + resource.getName());
				xtextResource = (XtextResource) resourceFactory.createResource(uri);
				xtextResource.setValidationDisabled(true);
				resourceSet.getResources().add(xtextResource);
			}
		}
		return xtextResource;
	}

	protected void loadResource(Object element, Resource resource) {
		if (resource == null) {
			return;
		}
		if (element instanceof IStreamContentAccessor) {
			IStreamContentAccessor streamContentAccessor = (IStreamContentAccessor) element;
			InputStream inputStream = null;
			try {
				inputStream = streamContentAccessor.getContents();
				if (inputStream != null) {
					resource.load(inputStream,
							Collections.singletonMap(XtextResource.OPTION_ENCODING, getEncoding(element)));
				}
			} catch (Exception exception) {
				throw new WrappedException(exception);
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
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

	@Override
	protected void disposeElementInfo(Object element, ElementInfo info) {
		if (info.fDocument instanceof XtextDocument) {
			XtextDocument document = (XtextDocument) info.fDocument;
			document.disposeInput();
		}
		super.disposeElementInfo(element, info);
	}

	protected String getEncoding(Object element) {
		String encoding = ResourcesPlugin.getEncoding();
		if (element instanceof IEncodedStreamContentAccessor) {
			try {
				String streamEncoding = ((IEncodedStreamContentAccessor) element).getCharset();
				if (!Strings.isNullOrEmpty(streamEncoding)) {
					encoding = streamEncoding;
				}
			} catch (CoreException exception) {
			}
		}
		return encoding;
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
		InputStream inputStream = streamContentAccessor.getContents();
		if (inputStream != null) {
			String encoding = getEncoding(streamContentAccessor);
			return readString(inputStream, encoding);
		}
		return null;
	}

	protected String readString(InputStream inputStream, String encoding) {
		if (inputStream == null) {
			return null;
		}
		BufferedReader reader = null;
		try {
			StringBuffer buffer = new StringBuffer();
			char[] part = new char[2048];
			int read = 0;
			reader = new BufferedReader(new InputStreamReader(inputStream, encoding));

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
