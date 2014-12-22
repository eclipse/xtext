/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.javaconverter;

import java.util.Arrays;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtend.core.javaconverter.JavaCodeAnalyzer;
import org.eclipse.xtend.core.javaconverter.JavaCodeAnalyzer.JavaParseResult;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend.core.javaconverter.JavaConverter.ConversionResult;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.util.ClipboardUtil;
import org.eclipse.xtext.ui.util.ClipboardUtil.JavaImportData;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.ui.imports.ImportsUtil;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class PasteJavaCodeHandler extends AbstractHandler {
	private @Inject Provider<JavaConverter> javaConverterProvider;
	private @Inject ImportsUtil importsUtil;
	private @Inject JavaCodeAnalyzer codeAnalyzer;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final XtextEditor activeXtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (activeXtextEditor == null) {
			return null;
		}

		String clipboardText = ClipboardUtil.getTextFromClipboard();
		JavaImportData javaImports = ClipboardUtil.getJavaImportsContent();
		if (!Strings.isEmpty(clipboardText)) {
			doPasteJavaCode(activeXtextEditor, clipboardText, javaImports);
		}
		return null;
	}

	private void doPasteJavaCode(final XtextEditor activeXtextEditor, final String javaCode,
			final JavaImportData javaImports) throws ExecutionException {
		ISourceViewer sourceViewer = activeXtextEditor.getInternalSourceViewer();

		IJavaProject project = null;
		IEditorInput editorInput = activeXtextEditor.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			IProject iProject = ((IFileEditorInput) editorInput).getFile().getProject();
			project = JavaCore.create(iProject);
		}
		final StringBuilder sb = new StringBuilder();
		if (javaImports != null) {
			String imports = Strings.toString(Arrays.asList(javaImports.getImports()), new Function<String, String>() {
				@Override
				public String apply(String input) {
					return "import " + input + ";";
				}
			}, "");
			sb.append(imports);

		}
		sb.append(javaCode);
		JavaParseResult<? extends ASTNode> parseResult = codeAnalyzer.determinateJavaType(javaCode);
		JavaConverter javaConverter = javaConverterProvider.get();
		ConversionResult conversionResult;
		if (parseResult.getType() >= ASTParser.K_CLASS_BODY_DECLARATIONS) {
			conversionResult = javaConverter.bodyDeclarationToXtend(sb.toString(), javaImports, project);
		} else {
			conversionResult = javaConverter.statementToXtend(javaCode);
		}
		final String xtendCode = conversionResult.getXtendCode();
		if (!Strings.isEmpty(xtendCode)) {
			final IXtextDocument xtextDocument = activeXtextEditor.getDocument();
			if (javaImports != null) {
				importsUtil.addImports(javaImports.getImports(), javaImports.getStaticImports(), new String[] {},
						xtextDocument);
			}
			final Point sel = sourceViewer.getSelectedRange();
			try {
				xtextDocument.replace(sel.x, sel.y, xtendCode);
			} catch (BadLocationException e) {
				throw new ExecutionException("Failed to replace content.", e);
			}
			int offset = sel.x;
			int length = xtendCode.length();
			if (offset - 1 >= 0) {
				offset--;
				length++;
			}
			sourceViewer.setSelectedRange(offset, length);
			sourceViewer.getTextOperationTarget().doOperation(ISourceViewer.FORMAT);
			int restoreCaretAtOffset = sourceViewer.getSelectedRange().x + sourceViewer.getSelectedRange().y;
			sourceViewer.setSelectedRange(restoreCaretAtOffset, 0);
		}
	}
}
