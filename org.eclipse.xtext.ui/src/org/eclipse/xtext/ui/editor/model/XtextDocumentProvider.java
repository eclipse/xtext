/*******************************************************************************
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.UnsupportedCharsetException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IEncodedStorage;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.quickfix.XtextResourceMarkerAnnotationModel;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.common.io.Closeables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 * @author Michael Clay
 * @author Heiko Behrens
 * @author Sebastian Zarnekow - Resetting unchanged flag on undo / redo, support for IURIEditorInput
 * @author Karsten Thoms - Bug#449340
 * @since 2.4
 */
public class XtextDocumentProvider extends FileDocumentProvider {
	
	/**
	 * Bundle of all required information to allow {@link java.net.URI} as underlying document content provider.
	 * @since 2.3
	 */
	protected class URIInfo extends ElementInfo {

		/** The flag representing the cached state whether the storage is modifiable. */
		public boolean isModifiable= false;
		/** The flag representing the cached state whether the storage is read-only. */
		public boolean isReadOnly= true;
		/** The flag representing the need to update the cached flag.  */
		public boolean updateCache= true;
		/** 
		 * The time stamp at which this provider changed the file.
		 * @since 2.12
		 */
		public long synchronizationStamp = IDocumentExtension4.UNKNOWN_MODIFICATION_STAMP;

		public URIInfo(IDocument document, IAnnotationModel model) {
			super(document, model);
		}
	}
	
	@Inject
	private Provider<XtextDocument> documentProvider;

	@Inject
	private Provider<IDocumentPartitioner> documentPartitioner;

	@Inject
	private IResourceValidator resourceValidator;

	@Inject
	private IssueResolutionProvider issueResolutionProvider;

	@Inject
	private IssueUtil issueUtil;

	@Inject
	private IResourceForEditorInputFactory resourceForEditorInputFactory;

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	private IEncodingProvider encodingProvider;
	
	/**
	 * @since 2.4
	 */
	protected IStorage2UriMapper getStorage2UriMapper() {
		return storage2UriMapper;
	}

	@Override
	protected XtextDocument createEmptyDocument() {
		XtextDocument xtextDocument = documentProvider.get();
		return xtextDocument;
	}

	@Override
	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = null;
		if (isWorkspaceExternalEditorInput(element)) {
			document= createEmptyDocument();
			if (setDocumentContent(document, (IEditorInput) element, getEncoding(element))) {
				setupDocument(element, document);
			}
		} else {
			document = super.createDocument(element);
		}
		if (document != null) {
			IDocumentPartitioner partitioner = documentPartitioner.get();
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		return document;
	}

	@Override
	public boolean isDeleted(Object element) {
		if (isWorkspaceExternalEditorInput(element)) {
			final IURIEditorInput input = (IURIEditorInput) element;
			boolean result = !input.exists();
			return result;
		}
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
		boolean result;
		try {
			if (isWorkspaceExternalEditorInput(editorInput)) {
				java.net.URI uri= ((IURIEditorInput) editorInput).getURI();
				try (InputStream contentStream = uri.toURL().openStream()) {
					setDocumentContent(document, contentStream, encoding);
					result = true;
				}
			} else {
				result = super.setDocumentContent(document, editorInput, encoding);
			}
			if (result) 
				setDocumentResource((XtextDocument) document, editorInput, encoding);
			return result;
		} catch (IOException ex) {
			String message= (ex.getMessage() != null ? ex.getMessage() : ""); //$NON-NLS-1$
			IStatus s= new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID, IStatus.OK, message, ex);
			throw new CoreException(s);
		}
	}

	/**
	 * @since 2.4
	 */
	protected void setDocumentResource(XtextDocument xtextDocument, IEditorInput editorInput, String encoding) throws CoreException {
		try {
			XtextResource xtextResource = (XtextResource) resourceForEditorInputFactory.createResource(editorInput);
			// encoding can be null for FileRevisionEditorInput
			loadResource(xtextResource, xtextDocument.get(), encoding == null ? getWorkspaceOrDefaultEncoding() : encoding);
			xtextResource.setModificationStamp(xtextDocument.getModificationStamp());
			xtextDocument.setInput(xtextResource);
		} catch(CoreException e) {
			throw e;
		} catch(RuntimeException e) {
			Throwable cause = e.getCause();
			if (cause instanceof CoreException) {
				throw (CoreException) cause;
			}
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
	}

	@Override
	protected void disposeElementInfo(Object element, ElementInfo info) {
		if (info.fDocument instanceof XtextDocument) {
			XtextDocument document = (XtextDocument) info.fDocument;
			ValidationJob job = (ValidationJob) document.getValidationJob();
			if (job != null) {
				job.cancel();
			}
			document.disposeInput();
		}
		super.disposeElementInfo(element, info);
	}

	protected void loadResource(XtextResource resource, String document, String encoding) throws CoreException {
		try {
			byte[] bytes = encoding != null ? document.getBytes(encoding) : document.getBytes();
			resource.load(new ByteArrayInputStream(bytes), Collections.singletonMap(XtextResource.OPTION_ENCODING, encoding));
		} catch (IOException ex) {
			String message = (ex.getMessage() != null ? ex.getMessage() : ex.toString());
			IStatus s = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, ex);
			throw new CoreException(s);
		}
	}

	@Override
	protected ElementInfo createElementInfo(Object element) throws CoreException {
		ElementInfo info;
		if (isWorkspaceExternalEditorInput(element)) {
			IDocument document= null;
			IStatus status= null;
			try {
				document= createDocument(element);
			} catch (CoreException x) {
				status= x.getStatus();
				document= createEmptyDocument();
			}

			info= new URIInfo(document, createAnnotationModel(element));
			info.fStatus= status;
		} else {
			info = super.createElementInfo(element);
		}
		registerAnnotationInfoProcessor(info);
		return info;
	}

	/**
	 * @since 2.4
	 */
	protected void registerAnnotationInfoProcessor(ElementInfo info) {
		XtextDocument doc = (XtextDocument) info.fDocument;
		if(doc != null && info.fModel != null) {
			AnnotationIssueProcessor annotationIssueProcessor = new AnnotationIssueProcessor(doc, info.fModel,
				issueResolutionProvider);
			ValidationJob job = new ValidationJob(resourceValidator, doc, annotationIssueProcessor, CheckMode.FAST_ONLY);
			doc.setValidationJob(job);
		}
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

		@Override
		public void documentAboutToBeChanged(DocumentEvent event) {
		}

		@Override
		public void documentChanged(DocumentEvent event) {
			if (element.fCanBeSaved && modificationStamp == event.getModificationStamp()) {
				element.fCanBeSaved = false;
				fireElementDirtyStateChanged(element.fElement, element.fCanBeSaved);
			} else if (!element.fCanBeSaved) {
				element.fCanBeSaved = true;
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
			info.fDocument.addDocumentListener(listener);
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
			IFileEditorInput input = (IFileEditorInput) element;
			return new XtextResourceMarkerAnnotationModel(input.getFile(), issueResolutionProvider, issueUtil);
		} else if (element instanceof IURIEditorInput) {
			return new AnnotationModel();
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
		if (encoding == null && element instanceof IStorageEditorInput) {
			try {
				IStorage storage = ((IStorageEditorInput) element).getStorage();
				URI uri = storage2UriMapper.getUri(storage);
				if (uri != null) {
					encoding = encodingProvider.getEncoding(uri);
				} else if (storage instanceof IEncodedStorage) {
					encoding = ((IEncodedStorage)storage).getCharset();
				}
			} catch (CoreException e) {
				throw new WrappedException(e);
			}
		}
		if (encoding == null) {
			if (isWorkspaceExternalEditorInput(element))
				encoding = getWorkspaceExternalEncoding((IURIEditorInput)element);
			else
				encoding = getWorkspaceOrDefaultEncoding();
		}
		return encoding;
	}

	/**
	 * @since 2.5
	 */
	protected String getWorkspaceExternalEncoding(IURIEditorInput element) {
		URI emfURI = toEmfUri(element.getURI());
		return encodingProvider.getEncoding(emfURI);
	}
	
	/**
	 * @since 2.5
	 */
	protected String getWorkspaceOrDefaultEncoding() {
		return encodingProvider.getEncoding(null);
	}
	
	@Override
	public long getModificationStamp(Object element) {
		if (isWorkspaceExternalEditorInput(element)) {
			IFileStore fileStore = Adapters.adapt(element, IFileStore.class);
			if (fileStore != null) {
				IFileInfo info = fileStore.fetchInfo();
				if (info.exists()) {
					return info.getLastModified();
				}
			}
			return IDocumentExtension4.UNKNOWN_MODIFICATION_STAMP;
		} else {
			return super.getModificationStamp(element);
		}
	}
	
	@Override
	public boolean isSynchronized(Object element) {
		ElementInfo info = getElementInfo(element);
		long synchronizationStamp;
		if (info instanceof FileInfo) {
			synchronizationStamp = ((FileInfo) info).fModificationStamp;
		} else if (info instanceof URIInfo) {
			synchronizationStamp = ((URIInfo) info).synchronizationStamp;
		} else {
			return super.isSynchronized(element);
		}
		return synchronizationStamp == getModificationStamp(element);
	}
	
	@Override
	public boolean isModifiable(Object element) {
		if (isWorkspaceExternalEditorInput(element)) {
			URIInfo info= (URIInfo) getElementInfo(element);
			if (info != null) {
				if (info.updateCache) {
					try {
						updateCache((IURIEditorInput) element);
					} catch (CoreException x) {
						handleCoreException(x, "XtextDocumentProvider.isModifiable");
					}
				}
				return info.isModifiable;
			}
		}
		return super.isModifiable(element);
	}
	
	@Override
	public boolean isReadOnly(Object element) {
		if (isWorkspaceExternalEditorInput(element)) {
			URIInfo info= (URIInfo) getElementInfo(element);
			if (info != null) {
				if (info.updateCache) {
					try {
						updateCache((IURIEditorInput) element);
					} catch (CoreException x) {
						handleCoreException(x, "XtextDocumentProvider.isReadOnly");
					}
				}
				return info.isReadOnly;
			}
		}
		return super.isReadOnly(element);
	}

	/**
	 * @since 2.3
	 */
	protected boolean isWorkspaceExternalEditorInput(Object element) {
		return element instanceof IURIEditorInput && !(element instanceof IFileEditorInput);
	}
	
	/**
	 * @since 2.3
	 */
	protected void updateCache(IURIEditorInput input) throws CoreException {
		URIInfo info= (URIInfo) getElementInfo(input);
		if (info != null) {
			URI emfURI = toEmfUri(input.getURI());
			if (emfURI != null) {
				boolean readOnly = true;
				if (emfURI.isFile() && !emfURI.isArchive()) {
					// TODO: Should we use the ResourceSet somehow to obtain the URIConverter for the file protocol?
					// see also todo below, but don't run into a stackoverflow ;-)
					Map<String, ?> attributes = URIConverter.INSTANCE.getAttributes(emfURI, null);
					readOnly = Boolean.TRUE.equals(attributes.get(URIConverter.ATTRIBUTE_READ_ONLY));
				}
				info.isReadOnly=  readOnly;
				info.isModifiable= !readOnly;
			}
			info.updateCache= false;
		}
	}
	
	private URI toEmfUri(java.net.URI uri) {
		if (uri == null)
			return null;
		String uriAsString = uri.toString();
		URI emfURI = URI.createURI(uriAsString);
		return emfURI;
	}
	
	private Charset getCharset(String name) {
		try {
			return Charset.forName(name);
		} catch(UnsupportedCharsetException e) {
			return Charset.defaultCharset();
		}
	}
	
	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite)
			throws CoreException {
		if (isWorkspaceExternalEditorInput(element)) {
			IURIEditorInput casted = (IURIEditorInput) element;
			String encoding = getWorkspaceExternalEncoding(casted);
			CharsetEncoder encoder= getCharset(encoding).newEncoder();
			encoder.onMalformedInput(CodingErrorAction.REPLACE);
			encoder.onUnmappableCharacter(CodingErrorAction.REPORT);
			OutputStream stream = null;
			try {
				try {
					monitor.beginTask("Saving", 2000);
					byte[] bytes;
					ByteBuffer byteBuffer= encoder.encode(CharBuffer.wrap(document.get()));
					if (byteBuffer.hasArray())
						bytes= byteBuffer.array();
					else {
						bytes= new byte[byteBuffer.limit()];
						byteBuffer.get(bytes);
					}
					
					// TODO: see todo above
					stream = URIConverter.INSTANCE.createOutputStream(toEmfUri(casted.getURI()));
					stream.write(bytes, 0, byteBuffer.limit());
					URIInfo info = (URIInfo) getElementInfo(element);
					if (info != null) {
						info.synchronizationStamp = getModificationStamp(element);
					}
				} finally {
					monitor.done();
				}
			} catch (CharacterCodingException ex) {
				String message= MessageFormat.format("Some characters cannot be mapped using \"{0}\" character encoding.\n" +
						"Either change the encoding or remove the characters which are not supported by the \"{0}\" character encoding.", new Object[]{ Charset.defaultCharset().name() });
				IStatus s= new Status(IStatus.ERROR, Activator.PLUGIN_ID, 1 /* EditorsUI.CHARSET_MAPPING_FAILED */, message, null);
				throw new CoreException(s);
			} catch (IOException e) {
				String message= "Could not save file.";
				IStatus s= new Status(IStatus.ERROR, Activator.PLUGIN_ID, IResourceStatus.FAILED_WRITE_LOCAL, message, null);
				throw new CoreException(s);
			} finally {
				try {
					Closeables.close(stream, true);
				} catch (IOException e) {
					//never thrown, swallowed by Closeables.close
				}
			}
			return;
		}
		super.doSaveDocument(monitor, element, document, overwrite);
	}
	
	@Override
	protected void doSynchronize(Object element, IProgressMonitor monitor) throws CoreException {
		if (isWorkspaceExternalEditorInput(element)) {
			doResetDocument(element, monitor);
		} else {
			super.doSynchronize(element, monitor);
		}
	}
	
	@Override
	protected void doUpdateStateCache(Object element) throws CoreException {
		if (isWorkspaceExternalEditorInput(element)) {
			URIInfo info= (URIInfo) getElementInfo(element);
			if (info != null) {
				info.updateCache= true;
				return;
			}
		}
		super.doUpdateStateCache(element);
	}
	
	@Override
	protected void handleCoreException(CoreException exception, String message) {
		if(exception.getStatus() == null || exception.getStatus().getCode() != IResourceStatus.RESOURCE_NOT_FOUND)
			super.handleCoreException(exception, message);
	}
}
