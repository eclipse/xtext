/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.xtend.ide.autoedit.TokenTypeToPartitionMapper;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.contentassist.DefaultContentAssistantFactory;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendContentAssistFactory extends DefaultContentAssistantFactory {

	@Inject(optional = true)
	private IContentAssistProcessor contentAssistProcessor;

	@Override
	protected void setContentAssistProcessor(ContentAssistant assistant, SourceViewerConfiguration configuration,
			ISourceViewer sourceViewer) {
		super.setContentAssistProcessor(assistant, configuration, sourceViewer);
		if (contentAssistProcessor != null) {
			XtendJavaDocCompletionProposalProcessor processor = new XtendJavaDocCompletionProposalProcessor(
					((XtextSourceViewerConfiguration) configuration).getEditor(), assistant);
			assistant.setContentAssistProcessor(processor, TokenTypeToPartitionMapper.JAVA_DOC_PARTITION);
		}
	}
}
