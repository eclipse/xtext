package org.eclipse.xtext.parsetree.unassignedtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.reconstr.impl.ValueSerializer;
import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess.CommonTerminalsRuleElements;
import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess.MultiRuleElements;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.PluralRule;

import com.google.inject.Inject;

public class UnassignedTextTestSerializer extends ValueSerializer {

	@Inject
	private IGrammarAccess grammar;

	@Override
	protected String serializeUnassignedValueByRule(AbstractRule rule, EObject current, AbstractNode node) {
		UnassignedTextTestLanguageGrammarAccess g = (UnassignedTextTestLanguageGrammarAccess) grammar;

		if (rule == g.getCaseInsensitiveKeywordRule())
			return "KeyWord";

		if (rule == g.getPluralRule()) {
			PluralRule pr = (PluralRule) current;
			return pr.getCount() == 1 ? "item" : "items";
		}
		return null;
	}

	@Override
	protected String serializeUnassignedValueByRuleCall(RuleCall ruleCall, EObject current, AbstractNode node) {
		UnassignedTextTestLanguageGrammarAccess g = (UnassignedTextTestLanguageGrammarAccess) grammar;

		if (ruleCall == g.getCaseInsensitiveKeywordRuleAccess().getCaseInsensitiveKeywordTerminalRuleCall_0())
			return "KeyWord";

		if (ruleCall == g.getPluralRuleAccess().getPluralTerminalRuleCall_2()) {
			PluralRule pr = (PluralRule) current;
			return pr.getCount() == 1 ? "item" : "items";
		}

		MultiRuleElements e = g.getMultiRuleAccess();
		if (ruleCall == e.getMultiTerminalRuleCall_2())
			return "accegj01";
		if (ruleCall == e.getMultiTerminalRuleCall_3())
			return "accegj02";
		if (ruleCall == e.getMultiTerminalRuleCall_4())
			return "accegj03";

		if (ruleCall == g.getDatatypeRuleAccess().getDatatypeParserRuleCall_2())
			return "str";

		CommonTerminalsRuleElements c = g.getCommonTerminalsRuleAccess();
		if (ruleCall == c.getIDTerminalRuleCall_1())
			return "abc";
		if (ruleCall == c.getINTTerminalRuleCall_2())
			return "123";
		if (ruleCall == c.getSTRINGTerminalRuleCall_3())
			return "'abc'";

		return null;
	}
}
