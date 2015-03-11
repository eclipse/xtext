/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor.actions;

import java.util.ResourceBundle;

import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.ui.editors.text.IFoldingCommandIds;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.folding.FoldingActionContributor;
import org.eclipse.xtext.ui.editor.folding.FoldingActionGroup;
import org.eclipse.xtext.ui.editor.folding.FoldingMessages;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;

/**
 * @author dhuebner - Initial contribution and API
 */
public class XbaseFoldingActionContributor extends FoldingActionContributor {

	@Override
	public void contributeActions(XtextEditor xtextEditor) {
		foldingActionGroup = new FoldingActionGroup(xtextEditor, xtextEditor.getInternalSourceViewer()) {
			@Override
			protected TextEditorAction createToggleFoldingAction(ITextEditor editor) {
				TextEditorAction toggle = new ResourceActionExtension(FoldingMessages.getResourceBundle(),
						"Projection.Toggle.", editor, ProjectionViewer.TOGGLE);
				toggle.setChecked(true);
				toggle.setActionDefinitionId(IFoldingCommandIds.FOLDING_TOGGLE);
				return toggle;
			}
		};
	}

	private @Inject IPreferenceStoreAccess storeAccess;

	/**
	 * @author dhuebner - Initial contribution and API
	 */
	private final class ResourceActionExtension extends TextEditorAction {

		private ResourceActionExtension(ResourceBundle bundle, String prefix, ITextEditor editor, int style) {
			super(bundle, prefix, editor, style);
		}

		@Override
		public void run() {
			boolean currentstate = currentPreferenceStoreState();
			PreferenceConstants.getPreferenceStore()
					.setValue(PreferenceConstants.EDITOR_FOLDING_ENABLED, !currentstate);
		}

		private boolean currentPreferenceStoreState() {
			return storeAccess.getPreferenceStore().getBoolean(PreferenceConstants.EDITOR_FOLDING_ENABLED);
		}

		@Override
		public void update() {
			ITextOperationTarget target = (ITextOperationTarget) getTextEditor().getAdapter(ITextOperationTarget.class);
			boolean isEnabled = (target instanceof ProjectionViewer);
			setEnabled(isEnabled);
		}
	}

}
