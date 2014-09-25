/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.edit;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.internal.corext.refactoring.reorg.JavaElementTransfer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtend.core.conversion.JavaConverter;
import org.eclipse.xtend.core.conversion.JavaConverter.ConversionResult;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.copyqualifiedname.ClipboardUtil;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.util.SWTUtil;

import com.google.inject.Inject;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class PasteJavaCodeHandler extends AbstractHandler {
	private @Inject JavaConverter java2xtendConverter;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor activeXtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (activeXtextEditor == null) {
			return null;
		}
		Clipboard clipboard = null;
		JavaElementTransfer javaElementTransfer = JavaElementTransfer.getInstance();
		Object contents = null;
		try {
			Display display = SWTUtil.getStandardDisplay();
			clipboard = new Clipboard(display);
			contents = clipboard.getContents(javaElementTransfer, DND.CLIPBOARD);
		} finally {
			if (clipboard != null) {
				clipboard.dispose();
			}
		}
		Object clipboardContent = ClipboardUtil.getClipboardContent(DND.CLIPBOARD);
		int sourceKind = ASTParser.K_CLASS_BODY_DECLARATIONS;
		//TODO		if (contents != null) {
		//			IJavaElement iJavaElement = ((org.eclipse.jdt.core.IJavaElement[]) contents)[0];
		//			if (iJavaElement.getElementType() == IJavaElement.COMPILATION_UNIT) {
		//				sourceKind = ASTParser.K_COMPILATION_UNIT;
		//			}
		//		}
		StyledText textWidget = activeXtextEditor.getInternalSourceViewer().getTextWidget();
		ConversionResult conversionResult = java2xtendConverter.toXtend("SNIPPET",clipboardContent.toString(), sourceKind);
		String xtendCode = conversionResult.getXtendCode();
		textWidget.insert(xtendCode);
		return null;
	}
}
