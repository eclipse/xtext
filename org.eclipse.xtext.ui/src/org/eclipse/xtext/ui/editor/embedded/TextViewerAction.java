/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import java.util.ResourceBundle;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.ResourceAction;

/**
 * Skeleton of a standard text viewer action. The action is initially associated with a text viewer via the constructor,
 * but can subsequently be changed using {@link #setViewer(ITextViewer)} Subclasses must implement the <code>run</code>
 * method and if required override the <code>update</code> method.
 * <p>
 * Subclasses that may modify the editor content should use {@link #canModifyViewer()} in their <code>update</code> code
 * to check whether updating the viewer is possible.
 * </p>
 * 
 * @since 2.3
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class TextViewerAction extends ResourceAction implements IUpdate {

	/** The action's viewer */
	private ITextViewer viewer;

	/**
	 * Creates and initializes the action for the given text editor. The action configures its visual representation
	 * from the given resource bundle.
	 * 
	 * @param bundle
	 *            the resource bundle
	 * @param prefix
	 *            a prefix to be prepended to the various resource keys (described in <code>ResourceAction</code>
	 *            constructor), or <code>null</code> if none
	 * @param viewer
	 *            the text viewer
	 * @see ResourceAction#ResourceAction(ResourceBundle, String)
	 */
	protected TextViewerAction(ResourceBundle bundle, String prefix, ITextViewer viewer) {
		this(bundle, prefix);
		setViewer(viewer);
		update();
	}

	/**
	 * Make sure the Viewer in set after calling this constructor and before calling {@link #update()}
	 */
	protected TextViewerAction(ResourceBundle bundle, String prefix) {
		super(bundle, prefix);
	}

	/**
	 * Creates and initializes the action for the given text editor. The action configures its visual representation
	 * from the given resource bundle.
	 * 
	 * @param bundle
	 *            the resource bundle
	 * @param prefix
	 *            a prefix to be prepended to the various resource keys (described in <code>ResourceAction</code>
	 *            constructor), or <code>null</code> if none
	 * @param viewer
	 *            the text editor
	 * @param style
	 *            the style of this action
	 * @see ResourceAction#ResourceAction(ResourceBundle, String, int)
	 */
	protected TextViewerAction(ResourceBundle bundle, String prefix, ITextViewer viewer, int style) {
		super(bundle, prefix, style);
		setViewer(viewer);
		update();
	}

	/**
	 * Returns the action's text editor.
	 * 
	 * @return the action's text editor
	 */
	protected ITextViewer getTextViewer() {
		return viewer;
	}

	/**
	 * Retargets this action to the given editor.
	 * 
	 * @param viewer
	 *            the new viewer, or <code>null</code> if none
	 */
	public void setViewer(ITextViewer viewer) {
		this.viewer = viewer;
	}

	/**
	 * Always enables this action if it is connected to a text editor. If the associated editor is <code>null</code>,
	 * the action is disabled. Subclasses may override.
	 */
	@Override
	public void update() {
		setEnabled(getTextViewer() != null);
	}

	/**
	 * Checks the viewer's modifiable state. Returns <code>true</code> if the viewer can be modified
	 * 
	 * @return <code>true</code> if a modifying action should be enabled, <code>false</code> otherwise
	 */
	protected boolean canModifyViewer() {
		ITextViewer viewer = getTextViewer();
		if (viewer != null)
			return viewer.isEditable();
		else
			return false;
	}

	/**
	 * Returns the viewer's selection.
	 * 
	 * @param viewer
	 *            the viewer
	 * @return the viewer's selection
	 */
	protected ITextSelection getSelection(ITextViewer viewer) {

		ISelectionProvider selectionProvider = viewer.getSelectionProvider();
		if (selectionProvider == null)
			return null;

		ISelection selection = selectionProvider.getSelection();
		if (!(selection instanceof ITextSelection))
			return null;

		return (ITextSelection) selection;
	}

}
