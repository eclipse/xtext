/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.quickoutline;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class ShowQuickOutlineActionHandler extends AbstractHandler {
	
	@Inject
	private Provider<QuickOutlinePopup> quickOutlinePopupProvider;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (xtextEditor != null) {
			final IXtextDocument document = xtextEditor.getDocument();
			document.readOnly(new IUnitOfWork.Void<XtextResource>()  {
				@Override
				public void process(XtextResource state) throws Exception {
					QuickOutlinePopup quickOutlinePopup = quickOutlinePopupProvider.get();
					quickOutlinePopup.setEditor(xtextEditor);
					quickOutlinePopup.setInput(document);
					
					quickOutlinePopup.open();
				}
			});
		}
		return null;
	}

}
