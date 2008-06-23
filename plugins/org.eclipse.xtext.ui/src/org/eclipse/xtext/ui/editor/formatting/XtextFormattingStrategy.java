/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;
import org.eclipse.xtext.ui.service.IFormatterService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextFormattingStrategy extends AbstractXtextFormattingStrategy {

	public static final String NEW_LINE = "\n";
	public static final String TAB = "\t";
	public static final String SPACE = " ";

	private short indent = 0;

	public XtextFormattingStrategy(IEditorModelProvider editorModelProvider, IFormatterService formatter) {
		super(editorModelProvider, formatter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.editor.formatting.AbstractXtextFormattingStrategy
	 * #format(org.eclipse.jface.text.IDocument, org.eclipse.jface.text.IRegion)
	 */
	@Override
	protected void format(IDocument document, IRegion region) {
		indent = 0;
		EObject astRoot = getEditorModelProvider().getModel().getAstRoot();
		if (astRoot != null) {
			StringBuilder stringBuilder = new StringBuilder();
			append(astRoot, stringBuilder);
			try {
				String string = stringBuilder.toString().trim();
				if (!document.get().equals(string))
					document.replace(0, document.getLength(), string);
			}
			catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}

	private void append(EObject eObject, StringBuilder stringBuilder) {
		NodeAdapter adapter = NodeUtil.getNodeAdapter(eObject);
		CompositeNode parserNode = adapter.getParserNode();
		boolean shouldIndent = getFormatterService().shouldIndent(parserNode);
		if (shouldIndent)
			indent++;
		for (EObject an : parserNode.eContents()) {
			if (an instanceof LeafNode) {
				LeafNode ln = (LeafNode) an;
				appendLeafNode(stringBuilder, ln);
			}
			else if (an instanceof CompositeNode) {
				CompositeNode cn = (CompositeNode) an;
				if (cn.getElement() != null) {
					append(cn.getElement(), stringBuilder);
				}
				else {
					for (LeafNode ln : cn.getLeafNodes())
						appendLeafNode(stringBuilder, ln);
				}
			}
		}
		if (shouldIndent)
			indent--;
	}

	private void appendLeafNode(StringBuilder stringBuilder, LeafNode ln) {
		if (!isWhiteSpace(ln)) {
			StringBuilder toAppend = new StringBuilder();
			toAppend.append(getFormatterService().bevor(ln));
			toAppend.append(ln.getText().trim());
			stringBuilder.append(toAppend.toString().replaceAll("\\n", NEW_LINE + indentString()));
		}
	}

	// private void lineToLongHandling(StringBuilder toAppend) {
	// int counter = 1;
	// int index = 120 * counter;
	// while (toAppend.length() > index) {
	// toAppend.insert(index, NEW_LINE);
	// counter++;
	// index = 120 * counter;
	// }
	// }

	/**
	 * 
	 */
	private String indentString() {
		StringBuilder indentSB = new StringBuilder();
		for (short s = indent; s > 0; s--) {
			indentSB.append(TAB);
		}
		return indentSB.toString();
	}

	private boolean isWhiteSpace(LeafNode ln) {
		return ln.isHidden() && ln.getGrammarElement() instanceof LexerRule
				&& "WS".equals(((LexerRule) ln.getGrammarElement()).getName());
	}

}
