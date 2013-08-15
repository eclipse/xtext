package org.xpect.xtext.lib.util;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.xpect.expectation.ITargetSyntaxSupport;
import org.xpect.text.IReplacement;
import org.xpect.text.Replacement;
import org.xpect.xtext.lib.util.GrammarAnalyzer.CommentRule;
import org.xpect.xtext.lib.util.GrammarAnalyzer.MLCommentRule;
import org.xpect.xtext.lib.util.GrammarAnalyzer.SLCommentRule;

public class XtextTargetSyntaxSupport implements ITargetSyntaxSupport {

	private final XtextResource resource;
	private final GrammarAnalyzer grammarAnalyzer;

	public XtextTargetSyntaxSupport(XtextResource resource) {
		this.resource = resource;
		this.grammarAnalyzer = new GrammarAnalyzer(resource.getResourceServiceProvider().get(IGrammarAccess.class).getGrammar());
	}

	protected CommentRule findCommentRule(ILeafNode leaf) {
		String text = leaf.getText();
		for (CommentRule rule : grammarAnalyzer.getCommentRules())
			if (text.startsWith(rule.getStart()))
				return rule;
		return null;
	}

	public IReplacement adoptToTargetSyntax(IReplacement replacement, boolean enforceMultilineLiteral) {
		ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), replacement.getOffset());
		if (leaf.getOffset() > replacement.getOffset())
			return replacement;
		if (leaf.getOffset() + leaf.getLength() < replacement.getOffset() + replacement.getLength())
			return replacement;
		CommentRule commentRule = findCommentRule(leaf);
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

	protected IReplacement convertToMultiLine(ILeafNode leaf, SLCommentRule slRule, IReplacement replacement) {
		MLCommentRule mlRule = getFirstMLCommentRule();
		if (mlRule == null)
			return replacement;
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
		return new Replacement(leaf.getOffset(), end, newText.toString());
	}

	protected MLCommentRule getFirstMLCommentRule() {
		for (CommentRule rule : grammarAnalyzer.getCommentRules())
			if (rule instanceof MLCommentRule)
				return (MLCommentRule) rule;
		return null;
	}

	protected IReplacement escapeTextInMultiLineComment(MLCommentRule commentRule, IReplacement replacement) {
		String text = replacement.getReplacement();
		String escapedStart = getEscapeString(commentRule.getStart());
		String escapedEnd = getEscapeString(commentRule.getEnd());
		String escaped = text.replace(commentRule.getStart(), escapedStart).replace(commentRule.getEnd(), escapedEnd);
		return new Replacement(replacement.getOffset(), replacement.getLength(), escaped);
	}

	protected String getEscapeString(String startOrEnd) {
		if (startOrEnd.length() == 1)
			return "_";
		if (startOrEnd.length() > 1)
			return startOrEnd.charAt(0) + "\\" + startOrEnd.substring(1);
		return startOrEnd;
	}

	public XtextResource getResource() {
		return resource;
	}

	public boolean supportsMultiLineLiteral() {
		return true;
	}

}
