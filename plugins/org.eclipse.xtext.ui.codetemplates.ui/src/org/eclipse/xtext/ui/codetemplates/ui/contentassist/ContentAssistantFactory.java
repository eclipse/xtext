/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.contentassist;

import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.contentassist.DefaultContentAssistantFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistantFactory extends DefaultContentAssistantFactory {

	@Override
	protected void setContentAssistProcessor(ContentAssistant assistant, SourceViewerConfiguration configuration,
			ISourceViewer sourceViewer) {
		super.setContentAssistProcessor(assistant, configuration, sourceViewer);
		for(String contentType: configuration.getConfiguredContentTypes(sourceViewer)) {
			IContentAssistProcessor processor = assistant.getContentAssistProcessor(contentType);
			if (processor instanceof ICompletionListener) {
				assistant.setRepeatedInvocationMode(true);
				assistant.setStatusLineVisible(true);
				assistant.addCompletionListener((ICompletionListener) processor);
			}
		}
	}
	
}
