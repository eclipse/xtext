/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.edit;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.xtend.core.conversion.JavaConverter;
import org.eclipse.xtend.core.conversion.JavaConverter.ConversionResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.util.ClipboardUtil;
import org.eclipse.xtext.ui.util.ClipboardUtil.JavaImportData;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class PasteJavaCodeHandler extends AbstractHandler {
	private @Inject Provider<JavaConverter> javaConverterProvider;
	@Inject
	private RewritableImportSection.Factory importSectionFactory;
	@Inject
	private ReplaceConverter replaceConverter;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final XtextEditor activeXtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (activeXtextEditor == null) {
			return null;
		}

		String clipboardText = ClipboardUtil.getTextFromClipboard();
		if (!Strings.isEmpty(clipboardText)) {
			StyledText textWidget = activeXtextEditor.getInternalSourceViewer().getTextWidget();
			int sourceKind = ASTParser.K_CLASS_BODY_DECLARATIONS;
			ConversionResult conversionResult = javaConverterProvider.get().toXtend("SNIPPET", clipboardText,
					sourceKind);
			final String xtendCode = conversionResult.getXtendCode();
			if (!Strings.isEmpty(xtendCode)) {
				final Point sel = textWidget.getSelectionRange();
				textWidget.replaceTextRange(sel.x, sel.y, xtendCode);
				final JavaImportData javaImports = ClipboardUtil.getJavaImportsContent();
				final IXtextDocument xtextDocument = activeXtextEditor.getDocument();
				IContentFormatter formatter = activeXtextEditor.getXtextSourceViewerConfiguration()
						.getContentFormatter(activeXtextEditor.getInternalSourceViewer());
				formatter.format(xtextDocument, new Region(sel.x, xtendCode.length()));
				addImports(javaImports, xtextDocument);
			}
		}
		return null;
	}

	private void addImports(final JavaImportData javaImports, final IXtextDocument xtextDocument) {
		List<ReplaceRegion> result = xtextDocument.readOnly(new IUnitOfWork<List<ReplaceRegion>, XtextResource>() {
			public List<ReplaceRegion> exec(XtextResource state) throws Exception {
				RewritableImportSection impSection = importSectionFactory.parse(state);
				for (String javaImport : javaImports.getImports()) {
					impSection.addImport(javaImport);
				}
				//for (String javaImport : javaImports.getStaticImports()) {
				//	//impSection.addStaticImport(jvmType);
				//	System.out.println("TODO static import: " + javaImport);
				//}
				return impSection.rewrite();
			}
		});
		try {
			replaceConverter.convertToTextEdit(result).apply(xtextDocument);
		} catch (MalformedTreeException e) {
			//ignore if adding imports fails
		} catch (BadLocationException e) {
			//ignore if adding imports fails
		}
	}
}
