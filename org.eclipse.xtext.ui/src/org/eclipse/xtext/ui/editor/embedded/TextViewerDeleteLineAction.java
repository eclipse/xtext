/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import java.util.ResourceBundle;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ui.texteditor.DeleteLineAction;
import org.eclipse.ui.texteditor.TextViewerDeleteLineTarget;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public class TextViewerDeleteLineAction extends TextViewerAction {

	/**
	 * Delete the whole line.
	 */
	public static final int WHOLE= 0;
	/**
	 * Delete to the beginning of line.
	 */
	public static final int TO_BEGINNING= 1;
	/**
	 * Delete to the end of line.
	 */
	public static final int TO_END= 2;

	
	/**
	 * The type of deletion.
	 * @see DeleteLineAction
	 */
	private final int fType;
	/**
	 * Should the deleted line be copied to the clipboard.
	 * @since 2.1
	 */
	private final boolean fCopyToClipboard;
	/** The deletion target.
	 * @since 2.1
	 */
	private TextViewerDeleteLineTarget fTarget;

	/**
	 * Creates a line deletion action.
	 * 
	 * @param bundle the resource bundle for UI strings
	 * @param prefix the prefix for the property keys into <code>bundle</code>
	 * @param viewer the viewer
	 * @param type the line deletion type, must be one of <code>WHOLE_LINE</code>,
	 *            <code>TO_BEGINNING</code> or <code>TO_END</code>
	 */
	public TextViewerDeleteLineAction(ResourceBundle bundle, String prefix, ITextViewer viewer, int type) {
		this(bundle, prefix, viewer, type, true);
	}

	/**
	 * Creates a line deletion action.
	 *
	 * @param bundle the resource bundle for UI strings
	 * @param prefix the prefix for the property keys into <code>bundle</code>
	 * @param viewer the viewer
	 * @param type the line deletion type, must be one of
	 * 	<code>WHOLE_LINE</code>, <code>TO_BEGINNING</code> or <code>TO_END</code>
	 * @param copyToClipboard if <code>true</code>, the contents of the deleted line are copied to the clipboard
	 * @since 2.1
	 */
	public TextViewerDeleteLineAction(ResourceBundle bundle, String prefix, ITextViewer viewer, int type, boolean copyToClipboard) {
		super(bundle, prefix, viewer);
		fType= type;
		fCopyToClipboard= copyToClipboard;
		update();
	}

	/**
	 * Creates a line deletion action.
	 * 
	 * @param viewer the viewer
	 * @param type the line deletion type, must be one of <code>WHOLE_LINE</code>,
	 *            <code>TO_BEGINNING</code> or <code>TO_END</code>
	 * @param copyToClipboard if <code>true</code>, the contents of the deleted line are copied to
	 *            the clipboard
	 * @since 3.5
	 */
	public TextViewerDeleteLineAction(ITextViewer viewer, int type, boolean copyToClipboard) {
		this(EmbeddedEditorMessages.getBundleForConstructedKeys(), getPrefix(type, copyToClipboard), viewer, type, copyToClipboard);
	}

	/**
	 * Returns the default resource bundle prefix for the given arguments.
	 * 
	 * @param type the line deletion type, must be one of <code>WHOLE_LINE</code>,
	 *            <code>TO_BEGINNING</code> or <code>TO_END</code>
	 * @param copyToClipboard if <code>true</code>, the contents of the deleted line are copied to
	 *            the clipboard
	 * @return the prefix for the property keys into <code>bundle</code>
	 * @since 3.5
	 */
	private static String getPrefix(int type, boolean copyToClipboard) {
		switch (type) {
			case WHOLE:
				return copyToClipboard ? "Editor.CutLine." : "Editor.DeleteLine."; //$NON-NLS-1$ //$NON-NLS-2$
			case TO_BEGINNING:
				return copyToClipboard ? "Editor.CutLineToBeginning." : "Editor.DeleteLineToBeginning."; //$NON-NLS-1$ //$NON-NLS-2$
			case TO_END:
				return copyToClipboard ? "Editor.CutLineToEnd." : "Editor.DeleteLineToEnd."; //$NON-NLS-1$ //$NON-NLS-2$
			default:
				Assert.isLegal(false);
				return ""; //$NON-NLS-1$
		}
	}

	/*
	 * @see IAction#run()
	 */
	@Override
	public void run() {

		if (fTarget == null)
			return;

		ITextViewer viewer= getTextViewer();
		if (viewer == null)
			return;

		if (!canModifyViewer())
			return;

		IDocument document= viewer.getDocument();
		if (document == null)
			return;

		ITextSelection selection= getSelection(viewer);
		if (selection == null)
			return;

		try {
			fTarget.deleteLine(document, selection, fType, fCopyToClipboard);
		} catch (BadLocationException e) {
			// should not happen
		}
	}

	/*
	 * @see IUpdate#update()
	 */
	@Override
	public void update() {

		super.update();
		if (!isEnabled())
			return;

		if (!canModifyViewer()) {
			setEnabled(false);
			return;
		}

		ITextViewer viewer= getTextViewer();
		if (viewer != null) {
			if (fTarget == null) {
				fTarget= new TextViewerDeleteLineTarget(viewer);
			}
		} else {
			fTarget= null;
		}

		setEnabled(fTarget != null);
	}

}
