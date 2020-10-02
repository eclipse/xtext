/*******************************************************************************
 * Copyright (c) 2011, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ShowWhitespaceCharactersAction;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.internal.Activator;

import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * 
 * @since 2.24
 */
@Singleton
public class ShowWhitespaceCharactersActionContributor implements IActionContributor {

	private static final class ActionContributionItemExtension extends ActionContributionItem {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 0;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (getClass() != obj.getClass())
				return false;
			ActionContributionItemExtension other = (ActionContributionItemExtension) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		final String id;

		private ActionContributionItemExtension(IAction action) {
			super(action);
			this.id = action.getId();
		}

	}

	@Override
	public void contributeActions(XtextEditor editor) {
		IToolBarManager toolBarManager = editor.getEditorSite().getActionBars().getToolBarManager();
		IAction action = editor.getAction(ITextEditorActionConstants.SHOW_WHITESPACE_CHARACTERS);
		action.setImageDescriptor(Activator.getImageDescriptor("icons/full/etool16/show_whitespace_chars.gif"));
		action.setDisabledImageDescriptor(Activator.getImageDescriptor("icons/full/dtool16/show_whitespace_chars.gif"));
		if (toolBarManager.find(action.getId()) == null) {
			toolBarManager.add(new ActionContributionItemExtension(action));
		}
	}

	@Override
	public void editorDisposed(XtextEditor editor) {
		IToolBarManager toolBarManager = editor.getEditorSite().getActionBars().getToolBarManager();
		IContributionItem i = toolBarManager.remove(ITextEditorActionConstants.SHOW_WHITESPACE_CHARACTERS);
		if (i instanceof ActionContributionItem) {
			IAction action = ((ActionContributionItem) i).getAction();
			if (action instanceof ShowWhitespaceCharactersAction) {
				((ShowWhitespaceCharactersAction) action).setEditor(null);
			}
		}
	}

}