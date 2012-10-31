package org.xpect.ui.highlighting;

import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.xpect.registry.DefaultBinding;
import org.xpect.ui.util.XpectFileAccess;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

public class XtHighlightingCalculator implements ISemanticHighlightingCalculator {

	protected static Pattern ALPHANUMERIC = Pattern.compile("[a-zA-Z0-9_]+");

	protected static final Map<String, String> RULE_TO_FOMRAT = Maps.newHashMap();

	static {
		RULE_TO_FOMRAT.put("ID", XtHighlightingConfiguration.DEFAULT_ID);
		RULE_TO_FOMRAT.put("INVOCATION", XtHighlightingConfiguration.DEFAULT_ID);
		RULE_TO_FOMRAT.put("ML_COMMENT", XtHighlightingConfiguration.COMMENT_ID);
		RULE_TO_FOMRAT.put("SL_COMMENT", XtHighlightingConfiguration.COMMENT_ID);
		RULE_TO_FOMRAT.put("INT", XtHighlightingConfiguration.NUMBER_ID);
		RULE_TO_FOMRAT.put("STRING", XtHighlightingConfiguration.STRING_ID);
	}

	@DefaultBinding
	@Inject(optional = true)
	private ISemanticHighlightingCalculator original;

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (original != null)
			original.provideHighlightingFor(resource, acceptor);
		provideHighlightingForXpect(resource, acceptor);
	}

	protected void provideHighlightingForKeyword(ILeafNode node, Keyword kw, IHighlightedPositionAcceptor acceptor) {
		if (ALPHANUMERIC.matcher(kw.getValue()).matches())
			acceptor.addPosition(node.getOffset(), node.getLength(), XtHighlightingConfiguration.KEYWORD_ID);
		else
			acceptor.addPosition(node.getOffset(), node.getLength(), XtHighlightingConfiguration.PUNCTUATION_ID);
	}

	protected void provideHighlightingForRule(ILeafNode node, TerminalRule rule, IHighlightedPositionAcceptor acceptor) {
		String conf = RULE_TO_FOMRAT.get(rule.getName());
		if (conf != null)
			acceptor.addPosition(node.getOffset(), node.getLength(), conf);
	}

	protected void provideHighlightingForHidden(ILeafNode node, EObject grammarEle, IHighlightedPositionAcceptor acceptor) {
		if (node.getText().trim().length() == 0)
			acceptor.addPosition(node.getOffset(), node.getLength(), XtHighlightingConfiguration.WHITESPACE_ID);
		else
			acceptor.addPosition(node.getOffset(), node.getLength(), XtHighlightingConfiguration.COMMENT_ID);
	}

	protected void provideHighlightingForXpect(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		ICompositeNode rootNode = XpectFileAccess.getXpectResource(resource).getParseResult().getRootNode();
		for (ILeafNode node : rootNode.getLeafNodes()) {
			EObject ele = node.getGrammarElement();
			if (node.isHidden())
				provideHighlightingForHidden(node, ele, acceptor);
			else if (ele instanceof Keyword)
				provideHighlightingForKeyword(node, (Keyword) ele, acceptor);
			else if (ele instanceof TerminalRule)
				provideHighlightingForRule(node, (TerminalRule) ele, acceptor);
			else if (ele instanceof RuleCall) {
				AbstractRule rule = ((RuleCall) ele).getRule();
				if (rule instanceof TerminalRule)
					provideHighlightingForRule(node, (TerminalRule) rule, acceptor);
			} else if (ele instanceof CrossReference) {
				AbstractElement rc = ((CrossReference) ele).getTerminal();
				if (rc instanceof RuleCall) {
					AbstractRule rule = ((RuleCall) rc).getRule();
					if (rule instanceof TerminalRule)
						provideHighlightingForRule(node, (TerminalRule) rule, acceptor);
				}
			}
		}
	}
}