/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.xtend.ide.autoedit.TokenTypeToPartitionMapper;
import org.eclipse.xtend.ide.contentassist.javadoc.XtendJavaDocContentAssistProcessor;
import org.eclipse.xtext.ui.editor.contentassist.DefaultContentAssistantFactory;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendContentAssistFactory extends DefaultContentAssistantFactory {

	@Inject
	private XtendJavaDocContentAssistProcessor javaDocContentAssistProcessor;

	@Override
	protected void setContentAssistProcessor(ContentAssistant assistant, SourceViewerConfiguration configuration,
			ISourceViewer sourceViewer) {
		super.setContentAssistProcessor(assistant, configuration, sourceViewer);
		assistant.setContentAssistProcessor(javaDocContentAssistProcessor,TokenTypeToPartitionMapper.JAVA_DOC_PARTITION);
		assistant.setContentAssistProcessor(null, TerminalsTokenTypeToPartitionMapper.SL_COMMENT_PARTITION);
		assistant.setContentAssistProcessor(null, TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION);
	}
}
