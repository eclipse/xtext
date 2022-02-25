/*******************************************************************************
 * Copyright (c) 2010, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.projection.ProjectionDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.DocumentProviderRegistry;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;

public class XtextDocumentUtil {
	
	/**
	 * @deprecated Inject an instance of {@link XtextDocumentUtil} instead and use {@code getXtextDocument(..)}
	 * instead. This allows to override the lookup of documents.
	 */
	@Deprecated
	public static IXtextDocument get(Object ctx) {
		if (ctx instanceof IXtextDocument)
			return (IXtextDocument) ctx;
		if (ctx instanceof ProjectionDocument)
			return get(((ProjectionDocument) ctx).getMasterDocument());
		if (ctx instanceof XtextSourceViewer)
			return ((XtextSourceViewer) ctx).getXtextDocument();
		if (ctx instanceof ITextViewer)
			return get(((ITextViewer) ctx).getDocument());
		if (ctx instanceof XtextEditor)
			return ((XtextEditor) ctx).getDocument();
		if (ctx instanceof IFile) {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			return get(activePage.findEditor(new FileEditorInput((IFile) ctx)));
		}
		return null;
	}
	
	/**
	 * @since 2.19
	 */
	public IXtextDocument getXtextDocument(IDocument document) {
		if (document instanceof IXtextDocument) {
			return (IXtextDocument) document;
		}
		if (document instanceof ProjectionDocument) {
			return getXtextDocument(((ProjectionDocument) document).getMasterDocument());
		}
		return null;
	}
	
	/**
	 * @since 2.19
	 */
	public IXtextDocument getXtextDocument(ITextViewer viewer) {
		if (viewer instanceof XtextSourceViewer) {
			return ((XtextSourceViewer) viewer).getXtextDocument();
		}
		return getXtextDocument(viewer.getDocument());
	}
	
	/**
	 * @since 2.19
	 */
	public IXtextDocument getXtextDocument(IEditorPart editor) {
		if (editor instanceof XtextEditor) {
			return ((XtextEditor) editor).getDocument();
		}
		IEditorInput editorInput = editor.getEditorInput();
		return getXtextDocument(editorInput);
	}

	/**
	 * @since 2.19
	 */
	public IXtextDocument getXtextDocument(IEditorInput editorInput) {
		IDocumentProvider documentProvider = DocumentProviderRegistry.getDefault().getDocumentProvider(editorInput);
		if (documentProvider == null) {
			return null;
		}
		IDocument document = documentProvider.getDocument(editorInput);
		if (document != null) {
			return getXtextDocument(document);
		}
		return null;
	}
	
	/**
	 * @since 2.19
	 */
	public IXtextDocument getXtextDocument(IResource resource) {
		if (resource instanceof IFile) {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorPart editor = activePage.findEditor(new FileEditorInput((IFile) resource));
			if (editor != null) {
				return getXtextDocument(editor);
			}
			return getXtextDocument(new FileEditorInput((IFile) resource));
		}
		return null;
	}
	
}
