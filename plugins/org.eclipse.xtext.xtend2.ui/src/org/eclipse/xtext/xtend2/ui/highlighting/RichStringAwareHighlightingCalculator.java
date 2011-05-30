/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.highlighting;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingCalculator;
import org.eclipse.xtext.xtend2.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.richstring.DefaultIndentationHandler;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.services.Xtend2GrammarAccess;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringAwareHighlightingCalculator extends XbaseHighlightingCalculator {

	@Inject
	private RichStringProcessor processor;

	@Inject
	private Provider<DefaultIndentationHandler> indentationHandlerProvider;

	private Keyword createKeyword;

	@Inject
	protected void setXtendGrammarAccess(Xtend2GrammarAccess grammarAccess) {
		this.createKeyword = grammarAccess.getValidIDAccess().getCreateKeyword_1();
	}
	
	@Override
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		XtendFile file = (XtendFile) resource.getContents().get(0);
		if (file.getXtendClass() != null) {
			for (XtendMember member : file.getXtendClass().getMembers()) {
				if (member.eClass() == Xtend2Package.Literals.XTEND_FUNCTION) {
					XtendFunction function = (XtendFunction) member;
					XExpression rootExpression = function.getExpression();
					highlightRichStrings(rootExpression, acceptor);
				}
			}
		}
		super.doProvideHighlightingFor(resource, acceptor);
	}

	protected void highlightRichStrings(XExpression expression, IHighlightedPositionAcceptor acceptor) {
		if (expression != null) {
			TreeIterator<EObject> iterator = EcoreUtil2.eAll(expression);
			while (iterator.hasNext()) {
				EObject object = iterator.next();
				if (object instanceof RichString) {
					RichStringHighlighter highlighter = createRichStringHighlighter(acceptor);
					processor.process((RichString) object, highlighter, indentationHandlerProvider.get());
					iterator.prune();
				}
			}
		}
	}

	protected RichStringHighlighter createRichStringHighlighter(IHighlightedPositionAcceptor acceptor) {
		return new RichStringHighlighter(acceptor);
	}
	
	@Override
	protected void highlightSpecialIdentifiers(ILeafNode leafNode, IHighlightedPositionAcceptor acceptor,
			TerminalRule idRule) {
		super.highlightSpecialIdentifiers(leafNode, acceptor, idRule);
		if (leafNode.getGrammarElement() == createKeyword) {
			acceptor.addPosition(leafNode.getOffset(), leafNode.getLength(), DefaultHighlightingConfiguration.DEFAULT_ID);
		}
	}

	protected class RichStringHighlighter extends AbstractRichStringPartAcceptor.ForLoopOnce {

		private int currentOffset = -1;
		private RichStringLiteral recent = null;
		private final IHighlightedPositionAcceptor acceptor;

		public RichStringHighlighter(IHighlightedPositionAcceptor acceptor) {
			this.acceptor = acceptor;
		}

		@Override
		public void announceNextLiteral(RichStringLiteral object) {
			resetCurrentOffset(object);
		}

		@Override
		public void acceptSemanticText(CharSequence text, RichStringLiteral origin) {
			resetCurrentOffset(origin);
			currentOffset += text.length();
		}

		protected void resetCurrentOffset(RichStringLiteral origin) {
			if (origin != null && origin != recent) {
				// no actions are involved, we are interested in the real node
				recent = origin;
				List<INode> featureNodes = NodeModelUtils.findNodesForFeature(origin,
						XbasePackage.Literals.XSTRING_LITERAL__VALUE);
				if (featureNodes.size() == 1) {
					INode node = featureNodes.get(0);
					currentOffset = node.getOffset();
					if (node.getText().charAt(0) == '\'') {
						acceptor.addPosition(currentOffset, 3, HighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
						highlightClosingQuotes(node);
						currentOffset += 3;
					} else {
						highlightClosingQuotes(node);
						currentOffset += 1;
					}
				}
			}
		}

		protected void highlightClosingQuotes(INode node) {
			int length = 0;
			if (node.getText().endsWith("'''")) {
				length = 3;
			} else if (node.getText().endsWith("''")) {
				length = 2;
			} else if (node.getText().endsWith("'")) {
				length = 1;
			}
			if (length != 0) {
				acceptor.addPosition(currentOffset + node.getLength() - length, length,
							HighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
			}
		}

		@Override
		public void acceptTemplateText(CharSequence text, RichStringLiteral origin) {
			resetCurrentOffset(origin);
			if (text.length() > 0) {
				acceptor.addPosition(currentOffset, text.length(),
						HighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
				currentOffset += text.length();
			}
		}

		@Override
		public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
			resetCurrentOffset(origin);
			if (controlStructureSeen)
				acceptor.addPosition(currentOffset, charCount, HighlightingConfiguration.POTENTIAL_LINE_BREAK);
			else
				acceptor.addPosition(currentOffset, charCount, HighlightingConfiguration.TEMPLATE_LINE_BREAK);
			currentOffset += charCount;
		}

		@Override
		public void acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
			resetCurrentOffset(origin);
			currentOffset += charCount;
		}

		@Override
		public void acceptIfCondition(XExpression condition) {
			highlightRichStrings(condition, acceptor);
		}

		@Override
		public void acceptElseIfCondition(XExpression condition) {
			highlightRichStrings(condition, acceptor);
		}

		@Override
		public void acceptForLoop(JvmFormalParameter parameter, XExpression expression) {
			highlightRichStrings(expression, acceptor);
			super.acceptForLoop(parameter, expression);
		}

		@Override
		public void acceptExpression(XExpression expression, CharSequence indentation) {
			highlightRichStrings(expression, acceptor);
		}
	}

}
