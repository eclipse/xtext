/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import org.eclipse.jdt.internal.ui.text.javadoc.JavadocCompletionProcessor;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.ui.IEditorPart;

public class XtendJavaDocCompletionProposalProcessor extends JavadocCompletionProcessor {

	private XtendJavaDocContentAssistInvocationContext context;

	public XtendJavaDocCompletionProposalProcessor(IEditorPart editor, ContentAssistant assistant) {
		super(editor, assistant);
	}

	@Override
	protected ContentAssistInvocationContext createContext(ITextViewer viewer, int offset) {
		context = new XtendJavaDocContentAssistInvocationContext(viewer, offset, fEditor);
		return context;
	}

	public ContentAssistInvocationContext getContext() {
		return context;
	}
}