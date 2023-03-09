/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;
import java.util.ResourceBundle;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.texteditor.AbstractMarkerAnnotationModel;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.SelectMarkerRulerAction;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;

/**
 * Super class is marked as not extendable, but it should be extendable
 * 
 * @author Dennis Hübner - Initial contribution and API
 * @author Holger Schill and Sebastian Zarnekow - https://bugs.eclipse.org/bugs/show_bug.cgi?id=310813
 */
public final class XtextMarkerRulerAction extends SelectMarkerRulerAction {
	protected XtextEditor textEditor;
	protected IVerticalRulerInfo ruler;

	public XtextMarkerRulerAction(ResourceBundle bundle, String prefix, XtextEditor editor, IVerticalRulerInfo ruler) {
		super(bundle, prefix, editor, ruler);
		this.textEditor = editor;// can't access private super field
		this.ruler = ruler;
	}

	@Override
	public void run() {
		try {
			// Move offset to the line of the annotation, if necessary
			IDocument document = getDocument();
			int annotationLine = ruler.getLineOfLastMouseButtonActivity();
			int annotationLineOffet = document.getLineOffset(annotationLine);
			Point currentSelection = textEditor.getInternalSourceViewer().getSelectedRange();
			int currentLine = document.getLineOfOffset(currentSelection.x);
			if (currentLine != annotationLine)
				textEditor.getInternalSourceViewer().setSelectedRange(annotationLineOffet, 0);
		
			// show QuickFix dialog
			ITextOperationTarget operation = textEditor.getAdapter(ITextOperationTarget.class);
			final int opCode = ISourceViewer.QUICK_ASSIST;
			if (operation != null && operation.canDoOperation(opCode))
				operation.doOperation(opCode);
		} catch (BadLocationException e) {
			// Ignore -> do nothing
		}
	}

	@Override
	public void update() {
		setEnabled(hasQuickFixableAnnotationInCurrentLine());
	}

	protected boolean hasQuickFixableAnnotationInCurrentLine() {
		try {
			AbstractMarkerAnnotationModel annotationModel = getAnnotationModel();
      if (annotationModel == null)
        return false;
			int line = ruler.getLineOfLastMouseButtonActivity();
			IDocument document = getDocument();
			IRegion region = document.getLineInformation(line);
			Iterator<?> iterator = annotationModel.getAnnotationIterator(region
					.getOffset(), region.getLength(), true, true);
			while (iterator.hasNext()) {
				Object element = iterator.next();
				if (element instanceof XtextAnnotation) {
					XtextAnnotation annotation = (XtextAnnotation) element;
					if (annotation.isQuickFixable())
						return true;
				} else if (element instanceof MarkerAnnotation) {
					MarkerAnnotation annotation = (MarkerAnnotation) element;
					if (annotation.isQuickFixableStateSet() && annotation.isQuickFixable())
						return true;
				}
			}
		} catch (BadLocationException e) {
			// Ignore -> false is returned anyway
		}
		return false;
	}

}
