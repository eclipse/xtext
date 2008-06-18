/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.formatter.ContextBasedFormattingStrategy;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;

final class PrototypeFormattingStrategy extends ContextBasedFormattingStrategy {

	/**
	 * @param xtextSourceViewerConfiguration
	 */
	PrototypeFormattingStrategy(IEditorModelProvider editorModelProvider) {
		this.editorModelProvider = editorModelProvider;
	}

	private int tabs = 0;
	private IEditorModelProvider editorModelProvider;

	@Override
	public String format(String content, boolean start, String indentation, int[] positions) {
		tabs = 0;
		StringBuffer buffy = new StringBuffer();
		IEditorModel model = this.editorModelProvider.getModel();
		if (model != null && !model.hasErrors()) {
			appendNode(buffy, model.getParseTreeRootNode());
			return buffy.toString();
		}
		else
			return content;
	}

	private void appendNode(StringBuffer buffy, EObject node) {
		String lineWrapper = "\n";
		String tab = "\t";
		if (node instanceof LeafNode && !isWhiteSpace(((LeafNode) node))) {
			LeafNode leafNode = (LeafNode) node;
			String text = leafNode.getText();
			if (text.endsWith(lineWrapper)) {
				text = text.substring(0, text.length() - 1);
			}
			boolean shouldWrapBefor = shouldWrapBefor(leafNode);
			int tabsToIdent = tabs;
			if (preventIdent(leafNode))
				tabsToIdent--;
			if (shouldWrapBefor) {
				buffy.append(lineWrapper);
				for (int i = 0; i < tabsToIdent; i++) {
					buffy.append(tab);
				}
			}
			buffy.append(text);
			boolean shouldWrapAfter = shouldWrapAfter(leafNode);
			if (shouldWrapAfter) {
				buffy.append(lineWrapper);
				for (int i = 0; i < tabsToIdent; i++) {
					buffy.append(tab);
				}
			}
			else {
//				LeafNode nextNode = nextNode(leafNode.getParent(), leafNode);
//				if (nextNode != null && !shouldWrapBefor(nextNode) && !shouldWrapAfter)
					buffy.append(" ");
			}
		}
		else if (node instanceof CompositeNode) {
			CompositeNode cNode = (CompositeNode) node;
			boolean idented = false;
			boolean identNow = false;
			for (Iterator<EObject> iter = cNode.eContents().iterator(); iter.hasNext();) {
				EObject child = iter.next();
				if (identNow) {
					if (shouldIdent(cNode)) {
						tabs++;
						identNow = false;
						idented = true;
					}
				}
				if (idented && !iter.hasNext())
					tabs--;
				appendNode(buffy, child);
				if (!idented && child instanceof LeafNode) {
					LeafNode ln = (LeafNode) child;
					if (!ln.isHidden()) {
						identNow = true;
					}
				}

			}
		}
	}

	private LeafNode nextNode(CompositeNode parent, LeafNode leafNode) {
		Iterator<LeafNode> iter = parent.getLeafNodes().listIterator(parent.getLeafNodes().indexOf(leafNode));
		iter.next();
		LeafNode retVal = null;
		for (; iter.hasNext();) {
			LeafNode current = iter.next();
			if (!isWhiteSpace(current)) {
				retVal = current;
				break;
			}
		}
		if (retVal == null && parent.getParent() != null) {
			EList<AbstractNode> children = parent.getParent().getChildren();
			ListIterator<AbstractNode> listIterator = children.listIterator(children.indexOf(parent));
			listIterator.next();
			if (listIterator.hasNext()) {
				AbstractNode nextParent = listIterator.next();
				for (LeafNode ln : nextParent.getLeafNodes()) {
					if (!isWhiteSpace(ln)) {
						retVal = ln;
						break;
					}
				}
			}
		}
		return retVal;
	}

	private boolean shouldIdent(CompositeNode node) {
		return true;
	}

	private boolean preventIdent(LeafNode node) {
		return false;// "}".equals(node.getText());
	}

	private boolean shouldWrapAfter(LeafNode leafNode) {
		return false;// (leafNode != null && (leafNode.isHidden()));
	}

	private boolean shouldWrapBefor(LeafNode leafNode) {
		return "}".equals(leafNode.getText())
				|| (leafNode.getGrammarElement() instanceof Keyword && leafNode.getText().length() > 1);

	}

	private boolean isWhiteSpace(LeafNode ln) {
		return ln.isHidden() && ln.getGrammarElement() instanceof LexerRule
				&& "WS".equals(((LexerRule) ln.getGrammarElement()).getName());
	}

	@Override
	public void formatterStarts(String indentation) {
		super.formatterStarts(indentation);
	}
}