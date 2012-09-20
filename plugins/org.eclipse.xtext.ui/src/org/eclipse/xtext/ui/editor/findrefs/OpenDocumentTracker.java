/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Tracks open document to allow easy read access to their already loaded resources.
 * 
 * As the tracking is separated from the access, this avoids deadlocks resulting from the lock order inversion of the UI
 * lock and the document lock.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class OpenDocumentTracker {

	protected class PartListener implements IPartListener2 {
		public void partOpened(IWorkbenchPartReference partRef) {
			Pair<URI, IXtextDocument> entry = getEntry(partRef);
			if (entry != null) {
				synchronized (resourceUri2document) {
					resourceUri2document.put(entry.getFirst(), entry.getSecond());
					part2resourceURI.put(partRef, entry.getFirst());
				}
			}
		}

		public void partInputChanged(IWorkbenchPartReference partRef) {
			Pair<URI, IXtextDocument> entry = getEntry(partRef);
			if (entry != null) {
				synchronized (resourceUri2document) {
					URI oldURI = part2resourceURI.remove(partRef);
					resourceUri2document.remove(oldURI);
					resourceUri2document.put(entry.getFirst(), entry.getSecond());
				}
			}
		}

		public void partClosed(IWorkbenchPartReference partRef) {
			Pair<URI, IXtextDocument> entry = getEntry(partRef);
			if (entry != null) {
				synchronized (resourceUri2document) {
					part2resourceURI.remove(partRef);
					resourceUri2document.remove(entry.getFirst());
				}
			}
		}

		public void partVisible(IWorkbenchPartReference partRef) {
		}

		public void partHidden(IWorkbenchPartReference partRef) {
		}

		public void partDeactivated(IWorkbenchPartReference partRef) {
		}

		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}

		public void partActivated(IWorkbenchPartReference partRef) {
		}
	}

	protected class PageListener implements IPageListener {
		public void pageOpened(IWorkbenchPage page) {
			page.addPartListener(partListener);
		}

		public void pageClosed(IWorkbenchPage page) {
			page.removePartListener(partListener);
		}

		public void pageActivated(IWorkbenchPage page) {
		}
	}

	private static final Logger LOG = Logger.getLogger(OpenDocumentTracker.class);

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	private Map<URI, IXtextDocument> resourceUri2document = newHashMap();

	private Map<IWorkbenchPartReference, URI> part2resourceURI = newHashMap();

	private IPageListener pageListener;

	private IPartListener2 partListener;

	@Inject(optional=true)
	protected void initialize(final IWorkbench workbench) {
		Assert.isNotNull(Display.getCurrent());
		partListener = new PartListener();
		pageListener = new PageListener();
		for (IWorkbenchWindow window : workbench.getWorkbenchWindows()) {
			window.addPageListener(pageListener);
			for (IWorkbenchPage page : window.getPages()) {
				page.addPartListener(partListener);
				for (IEditorReference editorRef : page.getEditorReferences()) {
					Pair<URI, IXtextDocument> entry = getEntry(editorRef);
					if (entry != null) {
						resourceUri2document.put(entry.getFirst(), entry.getSecond());
					}
				}
			}
		}
	}

	protected Pair<URI, IXtextDocument> getEntry(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		if (part instanceof XtextEditor) {
			XtextEditor xtextEditor = (XtextEditor) part;
			URI resourceURI = getResourceURI(xtextEditor);
			IXtextDocument document = xtextEditor.getDocument();
			if (resourceURI != null && document != null)
				return Tuples.create(resourceURI, document);
		}
		return null;
	}

	protected URI getResourceURI(XtextEditor editor) {
		IEditorInput editorInput = editor.getEditorInput();
		if (editorInput instanceof IStorageEditorInput) {
			try {
				return storage2UriMapper.getUri(((IStorageEditorInput) editorInput).getStorage());
			} catch (CoreException e) {
				LOG.error("Error getting URI for storage", e);
			}
		}
		return null;
	}

	public IXtextDocument getOpenDocument(URI resourceURI) {
		synchronized (resourceUri2document) {
			return resourceUri2document.get(resourceURI);
		}
	}
}
