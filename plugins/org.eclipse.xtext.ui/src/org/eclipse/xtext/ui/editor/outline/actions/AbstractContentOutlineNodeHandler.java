/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.ui.editor.outline.actions;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;

/**
 * @author Peter Friese - Initial contribution and API
 */
public abstract class AbstractContentOutlineNodeHandler extends AbstractHandler {

	@SuppressWarnings("unchecked")
	public final Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor activeEditor = (XtextEditor) HandlerUtil.getActiveEditor(event);
		final IXtextDocument document = activeEditor.getDocument();

		EvaluationContext applicationContext = (EvaluationContext) event.getApplicationContext();
		List<ContentOutlineNode> selection = (List<ContentOutlineNode>) applicationContext.getDefaultVariable();
		final ContentOutlineNode outlineNode = selection.get(0);
		doExecute(document, outlineNode);
		return this;
	}

	protected abstract void doExecute(final IXtextDocument document, final ContentOutlineNode outlineNode);

}
