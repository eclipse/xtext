/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.MultiPassContentFormatter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.quickassist.IQuickAssistAssistant;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.texteditor.HippieProposalProcessor;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.editor.codecompletion.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.editor.formatting.XtextFormattingStrategy;
import org.eclipse.xtext.ui.editor.hover.XtextTextHover;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;
import org.eclipse.xtext.ui.editor.model.XtextEditorModelReconcileStrategy;
import org.eclipse.xtext.ui.editor.quickfix.XtextQuickAssistProcessor;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.service.IFormatter;
import org.eclipse.xtext.ui.service.IHoverInfo;
import org.eclipse.xtext.ui.service.IProposalsProvider;

/**
 * 
 *TODO inject services instead of using serviceregistry
 * 
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextSourceViewerConfiguration extends TextSourceViewerConfiguration {
	private final IEditorModelProvider editorModelProvider;
	private final IServiceScope languageDescriptor;

	/**
	 * @param languageDescriptor
	 * @param preferenceStore
	 * @param editorModelPovider
	 */
	public XtextSourceViewerConfiguration(IEditorModelProvider editorModelPovider, IPreferenceStore preferenceStore) {
		super(preferenceStore);
		this.editorModelProvider = editorModelPovider;
		this.languageDescriptor = editorModelPovider.getModel().getLanguageDescriptor();
	}

	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		return new MonoReconciler(new XtextEditorModelReconcileStrategy(editorModelProvider), false);
	}

	@Override
	public IQuickAssistAssistant getQuickAssistAssistant(ISourceViewer sourceViewer) {
		IQuickAssistAssistant assistant = new QuickAssistAssistant();
		assistant.setQuickAssistProcessor(new XtextQuickAssistProcessor());
		assistant.setInformationControlCreator(new AbstractReusableInformationControlCreator() {
			public IInformationControl doCreateInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, (IInformationPresenter) null);
			}
		});
		return assistant;
	}

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		IProposalsProvider proposalsProvider = ServiceRegistry.getService(languageDescriptor, IProposalsProvider.class);
		IContentAssistProcessor processor;
		if (proposalsProvider != null) {
			processor = new XtextContentAssistProcessor(editorModelProvider, proposalsProvider);
		}
		else {
			processor = new HippieProposalProcessor();
		}
		ContentAssistant ca = new ContentAssistant();
		ca.enableColoredLabels(true);
		ca.enablePrefixCompletion(true);
		ca.enableAutoInsert(true);
		ca.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);
		ca.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
		ca.setProposalPopupOrientation(IContentAssistant.PROPOSAL_STACKED);
		ca.setInformationControlCreator(new AbstractReusableInformationControlCreator() {
			@Override
			protected IInformationControl doCreateInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, false);
			}
		});
		return ca;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.source.SourceViewerConfiguration#
	 * getPresentationReconciler(org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = (PresentationReconciler) super.getPresentationReconciler(sourceViewer);
		DefaultDamagerRepairer defDR = new DefaultDamagerRepairer(new XtextTokenScanner(languageDescriptor)) {
			@Override
			public void createPresentation(TextPresentation presentation, ITypedRegion region) {
				final long time = System.currentTimeMillis();
				super.createPresentation(presentation, region);
				if (Activator.DEBUG_SYNTAX_COLORING) {
					System.out.println("PresentationReconciler FULL createPresentation took:"
							+ (System.currentTimeMillis() - time) + "ms");

				}
			}
		};
		reconciler.setRepairer(defDR, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setDamager(defDR, IDocument.DEFAULT_CONTENT_TYPE);
		return reconciler;
	}

	/*
	 * Just a little PrototypeFormattingStrategy
	 * 
	 * @see
	 * org.eclipse.jface.text.source.SourceViewerConfiguration#getContentFormatter
	 * (org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
		IFormatter service = ServiceRegistry.getService(languageDescriptor, IFormatter.class);
		if (service != null) {
			MultiPassContentFormatter formatter = new MultiPassContentFormatter(
					getConfiguredDocumentPartitioning(sourceViewer), IDocument.DEFAULT_CONTENT_TYPE);
			formatter.setMasterStrategy(new XtextFormattingStrategy(this.editorModelProvider, service));
			return formatter;
		}
		return null;
	}

	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		IHoverInfo service = ServiceRegistry.getService(languageDescriptor, IHoverInfo.class);
		if (service != null) {
			return new XtextTextHover(sourceViewer, editorModelProvider, service);
		}
		return super.getTextHover(sourceViewer, contentType);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Map getHyperlinkDetectorTargets(final ISourceViewer sourceViewer) {
		Map<Object, Object> targets = super.getHyperlinkDetectorTargets(sourceViewer);
		targets.put("org.eclipse.xtext.ui.hyperlinkTarget", new IAdaptable() { //$NON-NLS-1$
					public Object getAdapter(Class adapter) {
						if (adapter.equals(IEditorModel.class)) {
							return editorModelProvider.getModel();
						}
						return null;
					}
				});
		return targets;
	}
}
