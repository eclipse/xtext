package org.eclipse.xtext.parsetree.unassignedtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess.MultiRuleElements;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.PluralRule;

public class UnassignedTextTestLanguageSyntacticSequencer extends AbstractUnassignedTextTestLanguageSyntacticSequencer {
	@Override
	protected String getCaseInsensitiveKeywordToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "KeyWord";
	}

	@Override
	protected String getDatatypeToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "str";
	}

	@Override
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "abc";
	}

	@Override
	protected String getINTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "123";
	}

	@Override
	protected String getMultiToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		MultiRuleElements e = grammarAccess.getMultiRuleAccess();
		if (ruleCall == e.getMultiTerminalRuleCall_2())
			return "accegj01";
		if (ruleCall == e.getMultiTerminalRuleCall_3())
			return "accegj02";
		if (ruleCall == e.getMultiTerminalRuleCall_4())
			return "accegj03";
		return "";
	}

	@Override
	protected String getPluralToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		PluralRule pr = (PluralRule) semanticObject;
		return pr.getCount() == 1 ? "item" : "items";
	}

	@Override
	protected String getSTRINGToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "'abc'";
	}
}
