/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.partialEditing;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SourceViewerHandleFactory {
	
	@Inject 
	private XtextSourceViewer.Factory sourceViewerFactory;
	
	@Inject 
	private Provider<XtextSourceViewerConfiguration> sourceViewerConfigurationProvider;
	
	@Inject 
	private Provider<XtextDocument> documentProvider;
	
	@Inject 
	private Provider<IDocumentPartitioner> documentPartitionerProvider;
	
	@Inject 
	private IResourceValidator resourceValidator;
	
	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	public SourceViewerHandle create(Composite parent, ISyntheticResourceProvider resourceProvider) {
		final XtextSourceViewer viewer= sourceViewerFactory.createSourceViewer(parent, null, null, false, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		XtextSourceViewerConfiguration viewerConfiguration = sourceViewerConfigurationProvider.get();
//		SourceViewerConfiguration configuration= new SourceViewerConfiguration() {
//			public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
//
//				ContentAssistant assistant= new ContentAssistant();
//				assistant.enableAutoActivation(true);
//				assistant.enableAutoInsert(true);
//				assistant.setContentAssistProcessor(fTemplateProcessor, IDocument.DEFAULT_CONTENT_TYPE);
//				return assistant;
//			}
//		};
		viewer.configure(viewerConfiguration);
		
		final SourceViewerDecorationSupport viewerDecorationSupport = new SourceViewerDecorationSupport(viewer, null, new DefaultMarkerAnnotationAccess(), getSharedColors());
		MarkerAnnotationPreferences annotationPreferences = new MarkerAnnotationPreferences();
		Iterator<AnnotationPreference> e= Iterators.filter(annotationPreferences.getAnnotationPreferences().iterator(), AnnotationPreference.class);
		while (e.hasNext())
			viewerDecorationSupport.setAnnotationPreference(e.next());
		viewerDecorationSupport.install(preferenceStoreAccess.getPreferenceStore());
		parent.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				viewerDecorationSupport.dispose();
			}
		});
		final XtextDocument document = documentProvider.get();
		IDocumentPartitioner partitioner = documentPartitionerProvider.get();
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);
		final SourceViewerHandle result = new SourceViewerHandle(document, viewer, viewerConfiguration, resourceProvider);
		ValidationJob job = new ValidationJob(resourceValidator, document, 
				new IValidationIssueProcessor() {
					private AnnotationIssueProcessor annotationIssueProcessor;
					
					public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
						IValidationIssueProcessor issueProcessor = result.getIssueProcessor();
						if (issueProcessor != null)
							issueProcessor.processIssues(issues, monitor);
						if (annotationIssueProcessor == null) {
							annotationIssueProcessor = new AnnotationIssueProcessor(document, 
									viewer.getAnnotationModel(), 
									new IssueResolutionProvider.NullImpl());
						}
						if (annotationIssueProcessor != null)
							annotationIssueProcessor.processIssues(issues, monitor);						
					}
				}, CheckMode.FAST_ONLY);
		document.setValidationJob(job);
		return result;
	}
	
	protected ISharedTextColors getSharedColors() {
		return EditorsUI.getSharedTextColors();
	}
}
