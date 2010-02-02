/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.quickassist.IQuickAssistAssistant;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategy;
import org.eclipse.xtext.ui.editor.contentassist.IContentAssistantFactory;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.hover.ProblemHover;
import org.eclipse.xtext.ui.editor.quickfix.XtextQuickAssistAssistant;
import org.eclipse.xtext.ui.editor.toggleComments.ISingleLineCommentHelper;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextSourceViewerConfiguration extends TextSourceViewerConfiguration {

	@Inject
	private IContentAssistantFactory contentAssistantFactory;

	@Inject
	private IHyperlinkDetector detector;

	@Inject
	private Provider<IReconciler> reconcilerProvider;

	@Inject(optional = true)
	private Provider<IDamagerRepairer> damagerRepairerProvider;
	
	@Inject(optional=true)
	private IContentFormatterFactory contentFormatterFactory;
	
	@Inject(optional=true)
	private ISingleLineCommentHelper singleLineCommentHelper;
	
	@Inject
	private Provider<XtextQuickAssistAssistant> quickAssistAssistentProvider;
	
	@Inject
	private Provider<XtextPresentationReconciler> presentationReconcilerProvider;
	
	@Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return new ProblemHover(sourceViewer);
	}
	
	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		return new ProblemHover(sourceViewer);
	}

	@Inject(optional = true)
	private IQuickAssistAssistant quickAssistant;

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
			XtextPresentationReconciler reconciler = getPresentationReconcilerProvider().get();
			reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
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

    @Override
    public IQuickAssistAssistant getQuickAssistAssistant(ISourceViewer sourceViewer) {
        if (sourceViewer.isEditable()) {
            if (quickAssistant == null)
                quickAssistant = quickAssistAssistentProvider.get();
            return quickAssistant;
        }
        return null;
    }

	@Override
	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
		if (contentFormatterFactory != null)
			return contentFormatterFactory.createConfiguredFormatter(this, sourceViewer);
		return super.getContentFormatter(sourceViewer);
	}
	
	@Override
	public String[] getDefaultPrefixes(ISourceViewer sourceViewer, String contentType) {
		if (singleLineCommentHelper != null)
			return singleLineCommentHelper.getDefaultPrefixes(sourceViewer, contentType);
		return super.getDefaultPrefixes(sourceViewer, contentType);
	}

	public void setSingleLineCommentHelper(ISingleLineCommentHelper singleLineCommentHelper) {
		this.singleLineCommentHelper = singleLineCommentHelper;
	}

	public ISingleLineCommentHelper getSingleLineCommentHelper() {
		return singleLineCommentHelper;
	}

	public void setPresentationReconcilerProvider(Provider<XtextPresentationReconciler> presentationReconcilerProvider) {
		this.presentationReconcilerProvider = presentationReconcilerProvider;
	}

	public Provider<XtextPresentationReconciler> getPresentationReconcilerProvider() {
		return presentationReconcilerProvider;
	}
	
	@Inject(optional=true)
	private IAutoEditStrategy autoEditStrategy ;
	@Inject
	private DefaultAutoEditStrategy defaultEditStrategy; 
	
	protected IAutoEditStrategy internalGetEditStrategy() {
		if (autoEditStrategy==null)
			return defaultEditStrategy;
		return autoEditStrategy;
	}
	
	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
		if (internalGetEditStrategy() instanceof ISourceViewerAware) {
			((ISourceViewerAware) internalGetEditStrategy()).setSourceViewer(sourceViewer);
		}
		return new IAutoEditStrategy[]{new DefaultIndentLineAutoEditStrategy(),internalGetEditStrategy()};
	}

	
}
