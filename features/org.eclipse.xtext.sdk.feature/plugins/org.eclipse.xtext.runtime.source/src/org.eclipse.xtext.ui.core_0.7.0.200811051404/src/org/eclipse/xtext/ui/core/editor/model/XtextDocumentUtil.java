package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.projection.ProjectionDocument;

public class XtextDocumentUtil {
	
	public static IXtextDocument get(Object ctx) {
		if (ctx instanceof IXtextDocument)
			return (IXtextDocument) ctx;
		if (ctx instanceof ProjectionDocument)
			return get(((ProjectionDocument) ctx).getMasterDocument());
		if (ctx instanceof ITextViewer)
			return get(((ITextViewer) ctx).getDocument());
		throw new IllegalArgumentException("Couldn't handle " + ctx.toString());
	}
}
