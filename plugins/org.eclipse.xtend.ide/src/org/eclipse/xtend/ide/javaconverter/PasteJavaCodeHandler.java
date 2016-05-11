/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.javaconverter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.util.ClipboardUtil;
import org.eclipse.xtext.ui.util.ClipboardUtil.JavaImportData;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.ui.imports.ImportsUtil;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class PasteJavaCodeHandler extends AbstractHandler {
	private @Inject Provider<JavaConverter> javaConverterProvider;
	private @Inject ImportsUtil importsUtil;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final XtextEditor activeXtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (activeXtextEditor == null) {
			return null;
		}

		String clipboardText = ClipboardUtil.getTextFromClipboard();
		if (!Strings.isEmpty(clipboardText)) {
			JavaImportData javaImports = ClipboardUtil.getJavaImportsContent();
			doPasteJavaCode(activeXtextEditor, clipboardText, javaImports);
		}
		return null;
	}

	private void doPasteJavaCode(final XtextEditor activeXtextEditor, final String javaCode, final JavaImportData javaImports)
			throws ExecutionException {
		ISourceViewer sourceViewer = activeXtextEditor.getInternalSourceViewer();
		final IXtextDocument xtextDocument = activeXtextEditor.getDocument();
		IJavaProject project = null;
		IEditorInput editorInput = activeXtextEditor.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			IProject iProject = ((IFileEditorInput) editorInput).getFile().getProject();
			project = JavaCore.create(iProject);
		}
		final int selectionOffset = sourceViewer.getSelectedRange().x - 1;
		EObject targetElement = xtextDocument.readOnly(new IUnitOfWork<EObject, XtextResource>() {

			@Override
			public EObject exec(XtextResource state) throws Exception {
				IParseResult parseResult = state.getParseResult();
				if (parseResult == null) {
					return null;
				}
				ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), selectionOffset);
				return leafNode.getSemanticElement();
			}
		});
		JavaConverter javaConverter = javaConverterProvider.get();
		final String xtendCode = javaConverter.toXtend(javaCode, javaImports != null ? javaImports.getImports() : null,
				targetElement, project);
		if (!Strings.isEmpty(xtendCode)) {
			if (javaImports != null) {
				importsUtil.addImports(javaImports.getImports(), javaImports.getStaticImports(), new String[] {}, xtextDocument);
			}
			Point selection = sourceViewer.getSelectedRange();
			try {
				xtextDocument.replace(selection.x, selection.y, xtendCode);
			} catch (BadLocationException e) {
				throw new ExecutionException("Failed to replace content.", e);
			}
			//TODO enable formatting, when performance became better
			//	https://bugs.eclipse.org/bugs/show_bug.cgi?id=457814
			//			doFormat(sourceViewer, xtendCode, selection);
		}
	}

	void doFormat(ISourceViewer sourceViewer, final String xtendCode, Point selection) {
		int offset = selection.x;
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
