package org.eclipse.xtext.ui.core.editor;

import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.xtext.service.Inject;

public class XtextSourceViewerConfiguration extends TextSourceViewerConfiguration {
	
	@Inject(optional=true)
	private IContentAssistant contentAssistant;
	
	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		if (contentAssistant instanceof ISourceViewerAware)
			((ISourceViewerAware)contentAssistant).setSourceViewer(sourceViewer);
		return contentAssistant;
	}
	
}
