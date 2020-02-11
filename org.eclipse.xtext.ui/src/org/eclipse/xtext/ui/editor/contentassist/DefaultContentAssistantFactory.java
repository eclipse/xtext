/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Michael Clay
 */
public class DefaultContentAssistantFactory implements IContentAssistantFactory {

	@Inject(optional = true)
	private IContentAssistProcessor contentAssistProcessor;
	
	@Inject(optional=true)
	private IDialogSettings dialogSettings;
	
	@Inject(optional=true)
	@Named("xtext.enable.styledLables")
	private boolean enableStyledLabels = true;
	
	@Override
	public IContentAssistant createConfiguredAssistant(SourceViewerConfiguration configuration,
			ISourceViewer sourceViewer) {
		ContentAssistant assistant = createAssistant();
		configureContentAssistant(assistant, configuration, sourceViewer);
		return assistant;
	}

	protected ContentAssistant createAssistant() {
		return new ContentAssistant();
	}
	
	protected void configureContentAssistant(ContentAssistant assistant, SourceViewerConfiguration configuration, ISourceViewer sourceViewer) {
		configureDefaults(assistant, configuration, sourceViewer);
		loadPreferences(assistant);
	}

	protected void loadPreferences(ContentAssistant assistant) {
		// TODO load CA preferences
	}

	private void configureDefaults(ContentAssistant assistant, SourceViewerConfiguration configuration, ISourceViewer sourceViewer) {
		setAutoInsert(assistant);
		setAutoActivation(assistant);
		setContentAssistProcessor(assistant, configuration, sourceViewer);
		setInformationControlCreator(assistant, configuration, sourceViewer);
		setDialogSettings(assistant);
		setColoredLabels(assistant);
	}

	private void setDialogSettings(ContentAssistant assistant) {
		if (dialogSettings != null)
			assistant.setRestoreCompletionProposalSize(dialogSettings);
	}
	
	private void setInformationControlCreator(ContentAssistant assistant, SourceViewerConfiguration configuration,
			ISourceViewer sourceViewer) {
		if (configuration != null && sourceViewer != null)
			assistant.setInformationControlCreator(configuration.getInformationControlCreator(sourceViewer));
	}

	protected void setAutoInsert(ContentAssistant assistant) {
		assistant.enableAutoInsert(true);
	}
	
	protected void setAutoActivation(ContentAssistant assistant) {
		if (contentAssistProcessor != null) {
			boolean activated = contentAssistProcessor.getCompletionProposalAutoActivationCharacters() != null;
			assistant.enableAutoActivation(activated);
		}
	}
	
	protected void setContentAssistProcessor(ContentAssistant assistant, SourceViewerConfiguration configuration, ISourceViewer sourceViewer) {
		if (contentAssistProcessor != null) {
			for(String contentType: configuration.getConfiguredContentTypes(sourceViewer)) {
				assistant.setContentAssistProcessor(contentAssistProcessor, contentType);
			}
			if (contentAssistProcessor instanceof ICompletionListener) {
				assistant.setRepeatedInvocationMode(true);
				assistant.setStatusLineVisible(true);
				assistant.addCompletionListener((ICompletionListener) contentAssistProcessor);
			}
		}
	}

	public void setDialogSettings(IDialogSettings dialogSettings) {
		this.dialogSettings = dialogSettings;
	}

	public IDialogSettings getDialogSettings() {
		return dialogSettings;
	}
	
	protected void setColoredLabels(ContentAssistant assistant) {
		assistant.enableColoredLabels(enableStyledLabels);
	}
	
}
