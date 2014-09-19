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
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtend.core.conversion.JavaConverter;
import org.eclipse.xtend.core.conversion.JavaASTFlattener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.copyqualifiedname.ClipboardUtil;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author dhuebner - Initial contribution and API
 */
public class PasteJavaCodeHandler extends AbstractHandler {
	private @Inject Injector injector;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor activeXtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (activeXtextEditor == null) {
			return null;
		}
		Object clipboardContent = ClipboardUtil.getClipboardContent(DND.CLIPBOARD);
		System.out.println("PasteJavaCodeHandler.execute()");
		System.out.println(clipboardContent);
		StyledText textWidget = activeXtextEditor.getInternalSourceViewer().getTextWidget();
		Point selection = textWidget.getSelection();
		JavaConverter converter = new JavaConverter() {
			@Override
			protected String doConvert(ASTNode ast) {
				JavaASTFlattener flattener = new JavaASTFlattener() {
					@Override
					public boolean visit(TypeDeclaration it) {
						if ("MISSING".equals(it.getName().getIdentifier()) && !it.isInterface()
								&& it.getModifiers() == 0) {
							for (BodyDeclaration body : (Iterable<BodyDeclaration>) it.bodyDeclarations()) {
								body.accept(this);
							}
							return false;
						}
						return super.visit(it);
					}
				};
				injector.injectMembers(flattener);
				ast.accept(flattener);
				return flattener.getResult();
			}
		};
		injector.injectMembers(converter);
		String xtendCode = converter.toXtend(clipboardContent.toString(), ASTParser.K_CLASS_BODY_DECLARATIONS);
		System.out.println(xtendCode);
		textWidget.insert(xtendCode);
		return null;
	}

}
