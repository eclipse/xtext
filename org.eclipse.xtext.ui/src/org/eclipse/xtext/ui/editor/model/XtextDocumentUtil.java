package org.eclipse.xtext.ui.editor.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.projection.ProjectionDocument;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;

public class XtextDocumentUtil {
	
	/**
	 * @deprecated Inject an instance of {@link XtextDocumentUtil} instead and use {@link #getXtextDocument(Object)}
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
	public IXtextDocument getXtextDocument(Object context) {
		return get(context);
	}
	
}
