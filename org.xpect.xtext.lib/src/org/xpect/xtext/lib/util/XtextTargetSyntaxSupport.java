package org.xpect.xtext.lib.util;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.resource.XtextResource;
import org.xpect.XpectInvocation;
import org.xpect.expectation.impl.TargetSyntaxSupport;
import org.xpect.parameter.IStatementRelatedRegion;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.text.IReplacement;
import org.xpect.text.Replacement;
import org.xpect.text.Text;
import org.xpect.xtext.lib.setup.ThisResource;
import org.xpect.xtext.lib.util.GrammarAnalyzer.CommentRule;
import org.xpect.xtext.lib.util.GrammarAnalyzer.MLCommentRule;
import org.xpect.xtext.lib.util.GrammarAnalyzer.SLCommentRule;

@XpectSetupFactory
public class XtextTargetSyntaxSupport extends TargetSyntaxSupport {

	public class XtextTargetSyntaxLiteral extends TargetLiteralSupport {

		private final CommentRule commentRule;
		private final ILeafNode leaf;

		public XtextTargetSyntaxLiteral(ILeafNode leaf, CommentRule commentRule) {
			super();
			this.leaf = leaf;
			this.commentRule = commentRule;
		}

		public IReplacement adoptToTargetSyntax(IReplacement replacement, boolean enforceMultilineLiteral) {
			if (leaf.getOffset() > replacement.getOffset())
				return replacement;
			if (leaf.getOffset() + leaf.getLength() < replacement.getOffset() + replacement.getLength())
				return replacement;
			if (commentRule instanceof SLCommentRule) {
				if (enforceMultilineLiteral)
					return convertToMultiLine(leaf, (SLCommentRule) commentRule, replacement);
			} else if (commentRule instanceof MLCommentRule) {
				MLCommentRule mlCommentRule = (MLCommentRule) commentRule;
				if (replacement.getReplacement().contains(mlCommentRule.getEnd()))
					return escapeTextInMultiLineComment(mlCommentRule, replacement);
			}
			return replacement;
		}

		public String escape(String value) {
			if (commentRule instanceof MLCommentRule)
				return escapeTextInMultiLineComment((MLCommentRule) commentRule, value);
			return value;
		}

		public boolean isMultiline() {
			return commentRule instanceof MLCommentRule;
		}

	}

	private final GrammarAnalyzer grammarAnalyzer;
	private final XtextResource resource;

	public XtextTargetSyntaxSupport(@ThisResource XtextResource resource) {
		this.resource = resource;
		this.grammarAnalyzer = new GrammarAnalyzer(resource.getResourceServiceProvider().get(IGrammarAccess.class).getGrammar());
	}

	protected IReplacement convertToMultiLine(ILeafNode leaf, SLCommentRule slRule, IReplacement replacement) {
		MLCommentRule mlRule = getFirstMLCommentRule();
		if (mlRule != null) {
			String text = leaf.getText();
			int end = text.length();
			while (text.charAt(end - 1) == '\n' || text.charAt(end - 1) == '\r')
				end--;
			int offsetInLeaf = replacement.getOffset() - leaf.getOffset();
			StringBuilder newText = new StringBuilder();
			newText.append(mlRule.getStart());
			newText.append(text.substring(slRule.getStart().length(), offsetInLeaf));
			newText.append(replacement.getReplacement());
			int beginIndex = offsetInLeaf + replacement.getLength();
			if (beginIndex < end)
				newText.append(text.substring(beginIndex, end));
			newText.append(" ");
			newText.append(mlRule.getEnd());
			return new Replacement(replacement.getDocument(), leaf.getOffset(), end, newText.toString());
		} else {
			String document = leaf.getRootNode().getText();
			StringBuilder postIndentaiton = new StringBuilder();
			String text = leaf.getText();
			int i = slRule.getStart().length();
			while (i < text.length() && Character.isWhitespace(text.charAt(i)))
				postIndentaiton.append(text.charAt(i++));
			String indentation = new Text(document).findIndentation(leaf.getOffset());
			String oldIndentation = "\n" + indentation;
			String newIndentation = "\n" + indentation + slRule.getStart() + postIndentaiton;
			String newText = replacement.getReplacement().replace(oldIndentation, newIndentation);
			return new Replacement(replacement.getDocument(), replacement.getOffset(), replacement.getLength(), newText);
		}
	}

	@Creates
	public TargetSyntaxSupport create() {
		return this;
	}

	protected IReplacement escapeTextInMultiLineComment(MLCommentRule commentRule, IReplacement replacement) {
		String text = escapeTextInMultiLineComment(commentRule, replacement.getReplacement());
		return new Replacement(replacement.getDocument(), replacement.getOffset(), replacement.getLength(), text);
	}

	protected String escapeTextInMultiLineComment(MLCommentRule commentRule, String replacement) {
		String escapedStart = getEscapeString(commentRule.getStart());
		String escapedEnd = getEscapeString(commentRule.getEnd());
		return replacement.replace(commentRule.getStart(), escapedStart).replace(commentRule.getEnd(), escapedEnd);
	}

	protected CommentRule findCommentRule(ILeafNode leaf) {
		String text = leaf.getText();
		for (CommentRule rule : grammarAnalyzer.getCommentRules())
			if (text.startsWith(rule.getStart()))
				return rule;
		return null;
	}

	protected String getEscapeString(String startOrEnd) {
		if (startOrEnd.length() == 1)
			return "_";
		if (startOrEnd.length() > 1)
			return startOrEnd.charAt(0) + "\\" + startOrEnd.substring(1);
		return startOrEnd;
	}

	protected MLCommentRule getFirstMLCommentRule() {
		for (CommentRule rule : grammarAnalyzer.getCommentRules())
			if (rule instanceof MLCommentRule)
				return (MLCommentRule) rule;
		return null;
	}

	public TargetLiteralSupport getLiteralSupport(int offset) {
		ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
		CommentRule commentRule = findCommentRule(leaf);
		return new XtextTargetSyntaxLiteral(leaf, commentRule);
	}

	public XtextResource getResource() {
		return resource;
	}

	public boolean supportsMultiLineLiteral() {
		return getFirstMLCommentRule() != null;
	}

	@Override
	public int findFirstSemanticCharAfterStatement(XpectInvocation statement) {
		IStatementRelatedRegion region = statement.getExtendedRegion();
		int end = region.getOffset() + region.getLength();
		ILeafNode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), end);
		if (!node.isHidden())
			return node.getOffset();
		NodeIterator it = new NodeIterator(node);
		while (it.hasNext()) {
			INode next = it.next();
			if (next instanceof ILeafNode && !((ILeafNode) next).isHidden())
				return next.getOffset();
		}
		throw new RuntimeException("Reached end of file while looking for semantic element for OFFSET");
	}

}
