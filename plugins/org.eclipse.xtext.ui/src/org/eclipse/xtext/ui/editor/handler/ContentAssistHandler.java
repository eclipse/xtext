/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ContentAssistHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Due to an Handler ExtensionPoint declaration, we have an XtextEditor as Active
		// Editor so can just cast to an ITextEditor
		new ContentAssistAction(XtextUIMessages.getResourceBundle(), "ContentAssistProposal.",
				(ITextEditor) HandlerUtil.getActiveEditor(event)).run();
		return this;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		boolean contentAssistAvailable = false;
		if (evaluationContext instanceof IEvaluationContext) {
			Object var = ((IEvaluationContext) evaluationContext).getVariable(ISources.ACTIVE_EDITOR_NAME);
			if (var instanceof XtextEditor) {
				contentAssistAvailable = ((XtextEditor) var).isContentAssistAvailable();
			}
		}
		super.setBaseEnabled(isEnabled() & contentAssistAvailable);
	}
}
