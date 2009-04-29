package org.eclipse.xtext.ui.core.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.xtext.ui.core.editor.contentassist.IContentAssistantFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class XtextSourceViewerConfiguration extends TextSourceViewerConfiguration {

	@Inject
	private IContentAssistantFactory contentAssistantFactory;

	@Inject
	private IHyperlinkDetector detector;

	@Inject
	private Provider<IReconciler> reconcilerProvider;

	@Inject(optional = true)
	private Provider<IDamagerRepairer> damagerRepairerProvider;

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		return contentAssistantFactory.createConfiguredAssistant(this, sourceViewer);
	}

	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		IReconciler reconciler = reconcilerProvider.get();
		return reconciler;
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		if (damagerRepairerProvider != null) {
			PresentationReconciler reconciler = (PresentationReconciler) super.getPresentationReconciler(sourceViewer);
			IDamagerRepairer defDR = damagerRepairerProvider.get();
			reconciler.setRepairer(defDR.getRepairer(), IDocument.DEFAULT_CONTENT_TYPE);
			reconciler.setDamager(defDR.getDamager(), IDocument.DEFAULT_CONTENT_TYPE);
			return reconciler;
		}
		return super.getPresentationReconciler(sourceViewer);
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
		detectors.add(detector);
		return detectors.toArray(new IHyperlinkDetector[detectors.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.source.SourceViewerConfiguration#getContentFormatter
	 * (org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
		// TODO add formatter here, consider to use
		// org.eclipse.jface.text.formatter.ContentFormatter with custom
		// strategy
		return super.getContentFormatter(sourceViewer);
	}
}
