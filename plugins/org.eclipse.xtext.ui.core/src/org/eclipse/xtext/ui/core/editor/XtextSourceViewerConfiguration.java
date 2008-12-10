package org.eclipse.xtext.ui.core.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.core.editor.reconciler.XtextDocumentReconcileStrategy;
import org.eclipse.xtext.ui.core.editor.reconciler.XtextReconciler;

public class XtextSourceViewerConfiguration extends TextSourceViewerConfiguration {

	@Inject(optional = true)
	private IContentAssistant contentAssistant;
	
	@Inject(optional = true)
	private IContentAssistProcessor contentAssistProcessor;

	@Inject(optional = true)
	private ITokenScanner tokenScanner;

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		if (contentAssistant instanceof ISourceViewerAware)
			((ISourceViewerAware) contentAssistant).setSourceViewer(sourceViewer);
		if (contentAssistant instanceof ContentAssistant && contentAssistProcessor != null) {
			((ContentAssistant) contentAssistant).setContentAssistProcessor(contentAssistProcessor,
					IDocument.DEFAULT_CONTENT_TYPE);
		}
		return contentAssistant;
	}

	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		XtextDocumentReconcileStrategy strategy = new XtextDocumentReconcileStrategy();
		XtextReconciler xtextReconciler = new XtextReconciler(strategy);
		xtextReconciler.setDelay(500);
		return xtextReconciler;
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		if (tokenScanner != null) {
			PresentationReconciler reconciler = (PresentationReconciler) super.getPresentationReconciler(sourceViewer);
			DefaultDamagerRepairer defDR = new DefaultDamagerRepairer(tokenScanner);
			reconciler.setRepairer(defDR, IDocument.DEFAULT_CONTENT_TYPE);
			reconciler.setDamager(defDR, IDocument.DEFAULT_CONTENT_TYPE);
			return reconciler;
		}
		else {
			return super.getPresentationReconciler(sourceViewer);
		}
	}
	
	@Override
	public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer sourceViewer) {
		List<IHyperlinkDetector> detectors = new LinkedList<IHyperlinkDetector>();
		IHyperlinkDetector[] inheritedDetectors = super.getHyperlinkDetectors(sourceViewer);
		if (inheritedDetectors != null) {
			for (final IHyperlinkDetector detector : inheritedDetectors) {
				detectors.add(new IHyperlinkDetector() {
					public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region,
							boolean canShowMultipleHyperlinks) {
						try {
							return detector.detectHyperlinks(textViewer, region, canShowMultipleHyperlinks);
						}
						catch (Throwable e) {
							// fail safe hyperlink detector - prevent others
							// from failing
						}
						return null;
					}

				});
			}
		}
		detectors.add(new XtextHyperlinkDetector());
		return detectors.toArray(new IHyperlinkDetector[detectors.size()]);
	}

}
