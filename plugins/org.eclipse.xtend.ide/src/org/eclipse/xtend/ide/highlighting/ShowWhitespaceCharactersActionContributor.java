/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.highlighting;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class ShowWhitespaceCharactersActionContributor implements IActionContributor {

	@Inject
	private IImageDescriptorHelper imageHelper;
	public void contributeActions(XtextEditor editor) {
		
		IToolBarManager toolBarManager = editor.getEditorSite().getActionBars().getToolBarManager();
		IAction action = editor.getAction(ITextEditorActionConstants.SHOW_WHITESPACE_CHARACTERS);
		action.setImageDescriptor(imageHelper
				.getImageDescriptor("full/etool16/show_whitespace_chars.gif"));
		action.setDisabledImageDescriptor(imageHelper
				.getImageDescriptor("full/dtool16/show_whitespace_chars.gif"));
		if(toolBarManager.find(action.getId())==null) {
			toolBarManager.add(action);				
		}
	}
	
	public void editorDisposed(XtextEditor editor) {
	}

}
