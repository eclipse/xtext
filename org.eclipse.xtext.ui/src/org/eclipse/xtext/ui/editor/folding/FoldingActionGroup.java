/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.source.projection.IProjectionListener;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.editors.text.IFoldingCommandIds;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.ResourceAction;
import org.eclipse.ui.texteditor.TextEditorAction;
import org.eclipse.ui.texteditor.TextOperationAction;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * Groups the Xtext folding actions. Initially copied from org.eclipse.jdt.internal.ui.actions.FoldingActionGroup
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class FoldingActionGroup extends ActionGroup {

	private static abstract class PreferenceAction extends ResourceAction implements IUpdate {
		PreferenceAction(ResourceBundle bundle, String prefix, int style) {
			super(bundle, prefix, style);
		}
	}

	private class FoldingAction extends PreferenceAction {

		FoldingAction(ResourceBundle bundle, String prefix) {
			super(bundle, prefix, IAction.AS_PUSH_BUTTON);
		}

		@Override
		public void update() {
			setEnabled(FoldingActionGroup.this.isEnabled() && viewer.isProjectionMode());
		}

	}

	private ProjectionViewer viewer;
	private final TextEditorAction toggle;
	private final TextOperationAction expand;
	private final TextOperationAction collapse;
	private final TextOperationAction expandAll;
	private final TextOperationAction collapseAll;
	private final IProjectionListener projectionListener;

	private final PreferenceAction restoreDefaults;

	/**
	 * Creates a new projection action group for <code>editor</code>. If the supplied viewer is not an instance of
	 * <code>ProjectionViewer</code>, the action group is disabled.
	 * 
	 * @param editor
	 *            the text editor to operate on
	 * @param viewer
	 *            the viewer of the editor
	 */
	public FoldingActionGroup(final ITextEditor editor, ITextViewer viewer) {
		if (!(viewer instanceof ProjectionViewer)) {
			toggle = null;
			expand = null;
			collapse = null;
			expandAll = null;
			collapseAll = null;
			restoreDefaults = null;
			projectionListener = null;
			return;
		}

		this.viewer = (ProjectionViewer) viewer;

		projectionListener = new IProjectionListener() {

			@Override
			public void projectionEnabled() {
				update();
			}

			@Override
			public void projectionDisabled() {
				update();
			}
		};

		this.viewer.addProjectionListener(projectionListener);

		toggle = createToggleFoldingAction(editor);
		toggle.setChecked(this.viewer.isProjectionMode());
		toggle.setActionDefinitionId(IFoldingCommandIds.FOLDING_TOGGLE);
		editor.setAction("FoldingToggle", toggle); //$NON-NLS-1$

		expandAll = new TextOperationAction(FoldingMessages.getResourceBundle(),
				"Projection.ExpandAll.", editor, ProjectionViewer.EXPAND_ALL, true); //$NON-NLS-1$
		expandAll.setActionDefinitionId(IFoldingCommandIds.FOLDING_EXPAND_ALL);
		editor.setAction("FoldingExpandAll", expandAll); //$NON-NLS-1$

		collapseAll = new TextOperationAction(FoldingMessages.getResourceBundle(),
				"Projection.CollapseAll.", editor, ProjectionViewer.COLLAPSE_ALL, true); //$NON-NLS-1$
		collapseAll.setActionDefinitionId(IFoldingCommandIds.FOLDING_COLLAPSE_ALL);
		editor.setAction("FoldingCollapseAll", collapseAll); //$NON-NLS-1$

		expand = new TextOperationAction(FoldingMessages.getResourceBundle(),
				"Projection.Expand.", editor, ProjectionViewer.EXPAND, true); //$NON-NLS-1$
		expand.setActionDefinitionId(IFoldingCommandIds.FOLDING_EXPAND);
		editor.setAction("FoldingExpand", expand); //$NON-NLS-1$

		collapse = new TextOperationAction(FoldingMessages.getResourceBundle(),
				"Projection.Collapse.", editor, ProjectionViewer.COLLAPSE, true); //$NON-NLS-1$
		collapse.setActionDefinitionId(IFoldingCommandIds.FOLDING_COLLAPSE);
		editor.setAction("FoldingCollapse", collapse); //$NON-NLS-1$

		restoreDefaults = new FoldingAction(FoldingMessages.getResourceBundle(), "Projection.Restore.") { //$NON-NLS-1$
			@Override
			public void run() {
				if (editor instanceof XtextEditor) {
					XtextEditor xtextEditor = (XtextEditor) editor;
					xtextEditor.resetProjection();
				}
			}
		};
		restoreDefaults.setActionDefinitionId(IFoldingCommandIds.FOLDING_RESTORE);
		restoreDefaults.update();
		editor.setAction("FoldingRestore", restoreDefaults); //$NON-NLS-1$

	}

	/**
	 * @since 2.8
	 */
	protected TextEditorAction createToggleFoldingAction(ITextEditor editor) {
		return new TextOperationAction(FoldingMessages.getResourceBundle(), "Projection.Toggle.", editor,
				ProjectionViewer.TOGGLE, true);
	}

	/**
	 * Returns <code>true</code> if the group is enabled.
	 * 
	 * <pre>
	 * Invariant: isEnabled() &lt;=&gt; fViewer and all actions are != null.
	 * </pre>
	 * 
	 * @return <code>true</code> if the group is enabled
	 */
	protected boolean isEnabled() {
		return viewer != null;
	}

	/*
	 * @see org.eclipse.ui.actions.ActionGroup#dispose()
	 */
	@Override
	public void dispose() {
		if (isEnabled()) {
			viewer.removeProjectionListener(projectionListener);
			viewer = null;
		}
		super.dispose();
	}

	/**
	 * Updates the actions.
	 */
	protected void update() {
		if (isEnabled()) {
			toggle.update();
			toggle.setChecked(viewer.isProjectionMode());
			expand.update();
			expandAll.update();
			collapse.update();
			collapseAll.update();
			restoreDefaults.update();
		}
	}

	/**
	 * Fills the menu with all folding actions.
	 * 
	 * @param manager
	 *            the menu manager for the folding submenu
	 */
	public void fillMenu(IMenuManager manager) {
		if (isEnabled()) {
			update();
			manager.add(toggle);
			manager.add(expandAll);
			manager.add(expand);
			manager.add(collapse);
			manager.add(collapseAll);
			manager.add(restoreDefaults);
		}
	}

	/*
	 * @see org.eclipse.ui.actions.ActionGroup#updateActionBars()
	 */
	@Override
	public void updateActionBars() {
		update();
	}
}
