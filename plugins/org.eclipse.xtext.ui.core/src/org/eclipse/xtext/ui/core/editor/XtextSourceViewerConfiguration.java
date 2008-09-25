package org.eclipse.xtext.ui.core.editor;

import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentReconcileStrategy;

public class XtextSourceViewerConfiguration extends TextSourceViewerConfiguration {
	
	@Inject(optional=true)
	private IContentAssistant contentAssistant;
	
	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		if (contentAssistant instanceof ISourceViewerAware)
			((ISourceViewerAware)contentAssistant).setSourceViewer(sourceViewer);
		return contentAssistant;
	}
	
	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		XtextDocumentReconcileStrategy strategy = new XtextDocumentReconcileStrategy(sourceViewer);
		MonoReconciler monoReconciler = new MonoReconciler(strategy,true);
		monoReconciler.setDelay(500);
		return monoReconciler;
	}
}
