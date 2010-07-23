/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.MarkerUtil;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.quickfix.XtextResourceMarkerAnnotationModel;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 * @author Michael Clay
 * @author Heiko Behrens
 */
public class XtextDocumentProvider extends FileDocumentProvider {
	@Inject
	private Provider<XtextDocument> document;
	
	@Inject
	private IResourceValidator resourceValidator;
	
	// TODO use a provider for objects that depend on issueResolitionProvider+markerUtil when guice2 is available
	@Inject
	private IssueResolutionProvider issueResolutionProvider;
	
	@Inject
	private MarkerUtil markerUtil;
	
	@Inject
	private IResourceForEditorInputFactory resourceForEditorInputFactory;
	
	@Inject 
	private IStorage2UriMapper storage2UriMapper;
	
	@Inject 
	private IEncodingProvider encodingProvider;
	
	@Override
	protected XtextDocument createEmptyDocument() {
		XtextDocument xtextDocument = document.get();
		return xtextDocument;
	}
	
	@Override
	public boolean isDeleted(Object element) {
		if (element instanceof IFileEditorInput) {
			final IFileEditorInput input = (IFileEditorInput) element;

			final IPath path = input.getFile().getLocation();
			if (path == null) {
				// return true;
				return !input.getFile().exists(); // fixed for EFS compatibility
			}
			return !path.toFile().exists();
		}
		return super.isDeleted(element);
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding)
			throws CoreException {
		boolean result = super.setDocumentContent(document, editorInput, encoding);
		if (result) {
			XtextDocument xtextDocument = (XtextDocument) document;
			XtextResource xtextResource = (XtextResource) resourceForEditorInputFactory.createResource(editorInput);
			loadResource(xtextResource, xtextDocument.get(), encoding);
			xtextDocument.setInput(xtextResource);
		}
		return result;
	}
	
	@Override
	protected void disposeElementInfo(Object element, ElementInfo info) {
		if (info.fDocument instanceof XtextDocument) {
			XtextDocument document = (XtextDocument) info.fDocument;
			document.disposeInput();
		}
		super.disposeElementInfo(element, info);
	}
	
	protected void loadResource(XtextResource resource, String document, String encoding) throws CoreException {
		try {
			resource.load(new ByteArrayInputStream(document.getBytes(encoding)),
					Collections.singletonMap(XtextResource.OPTION_ENCODING, encoding));
		} catch (IOException ex) {
			String message = (ex.getMessage() != null ? ex.getMessage() : ex.toString());
			IStatus s = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, message, ex);
			throw new CoreException(s);
		}
	}
	
	@Override
	protected ElementInfo createElementInfo(Object element) throws CoreException {
		ElementInfo info = super.createElementInfo(element);
		XtextDocument doc = (XtextDocument) info.fDocument;
		AnnotationIssueProcessor annotationIssueProcessor = new AnnotationIssueProcessor(doc, info.fModel, issueResolutionProvider);
		ValidationJob job = new ValidationJob(resourceValidator, doc, annotationIssueProcessor,CheckMode.FAST_ONLY);
		doc.setValidationJob(job);
		return info;
	}
	
	private UnchangedElementListener listener;
	
	public class UnchangedElementListener implements IDocumentListener {

		private final ElementInfo element;
		private long modificationStamp;

		public UnchangedElementListener(ElementInfo element) {
			this.element = element;
			if (element.fDocument instanceof IDocumentExtension4) {
				modificationStamp = ((IDocumentExtension4) element.fDocument).getModificationStamp();
			} else {
				modificationStamp = IDocumentExtension4.UNKNOWN_MODIFICATION_STAMP;
			}
			
		}
		
		public void documentAboutToBeChanged(DocumentEvent event) {
		}

		public void documentChanged(DocumentEvent event) {
			if (element.fCanBeSaved && modificationStamp == event.getModificationStamp()) {
				element.fCanBeSaved= false;
				fireElementDirtyStateChanged(element.fElement, element.fCanBeSaved);
			} else if (!element.fCanBeSaved) {
				element.fCanBeSaved= true;
				fireElementDirtyStateChanged(element.fElement, element.fCanBeSaved);
			}
		}
		
	}
	
	@Override
	protected void addUnchangedElementListeners(Object element, ElementInfo info) {
		if (info.fDocument != null) {
			if (listener != null)
				info.fDocument.removeDocumentListener(listener);
			listener = new UnchangedElementListener(info);
			info.fDocument.addDocumentListener(new UnchangedElementListener(info));
		}
	}
	
	@Override
	protected void removeUnchangedElementListeners(Object element, ElementInfo info) {
		if (listener != null) {
			info.fDocument.removeDocumentListener(listener);
			listener = null;
		}
	}
	
	@Override
	protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
		if (element instanceof IFileEditorInput) {
			IFileEditorInput input= (IFileEditorInput) element;
			return new XtextResourceMarkerAnnotationModel(input.getFile(), issueResolutionProvider, markerUtil);
		}
		return super.createAnnotationModel(element);
	}

	public void setResourceForEditorInputFactory(IResourceForEditorInputFactory resourceForEditorInputFactory) {
		this.resourceForEditorInputFactory = resourceForEditorInputFactory;
	}

	public IResourceForEditorInputFactory getResourceForEditorInputFactory() {
		return resourceForEditorInputFactory;
	}
	
	@Override
	public String getEncoding(Object element) {
		String encoding = super.getEncoding(element);
		if(encoding == null && element instanceof IStorageEditorInput) {
			try {
				IStorage storage = ((IStorageEditorInput)element).getStorage();
				URI uri = storage2UriMapper.getUri(storage);
				if(uri != null) {
					return encodingProvider.getEncoding(uri);
				}
			} catch (CoreException e) {
				throw new WrappedException(e);
			}
		}
		return encoding;
	}

}
