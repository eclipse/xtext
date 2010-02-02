/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.ResourceBundle;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.quickassist.IQuickFixableAnnotation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.SelectMarkerRulerAction;

/**
 * Super class is marked as not extendable, but it should be extendable
 * 
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public final class XtextMarkerRulerAction extends SelectMarkerRulerAction {
	private ITextEditor textEditor;

	public XtextMarkerRulerAction(ResourceBundle bundle, String prefix, ITextEditor editor, IVerticalRulerInfo ruler) {
		super(bundle, prefix, editor, ruler);
		this.textEditor = editor;// can't access private super field
	}

	@Override
	public void run() {
		super.run();
		// if at least one fixable marker found in current line, show QuickFix
		// dialog
		for (Object m : getMarkers()) {
			if (m instanceof IMarker) {
				IQuickFixableAnnotation qfAno = getAnnotationModel().getMarkerAnnotation((IMarker) m);
				if (qfAno.isQuickFixable()) {
					ITextOperationTarget operation = (ITextOperationTarget) textEditor
							.getAdapter(ITextOperationTarget.class);
					final int opCode = ISourceViewer.QUICK_ASSIST;
					if (operation != null && operation.canDoOperation(opCode)) {
						operation.doOperation(opCode);
					}
					break;
				}
			}
		}
	}

}