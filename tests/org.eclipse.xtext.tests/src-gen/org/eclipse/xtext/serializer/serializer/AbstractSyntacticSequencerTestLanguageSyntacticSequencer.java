package org.eclipse.xtext.serializer.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.eclipse.xtext.serializer.services.SyntacticSequencerTestLanguageGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractSyntacticSequencerTestLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SyntacticSequencerTestLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AlternativeTransition_KW1ParserRuleCall_1_0_or_Kw2Keyword_1_1;
	protected AbstractElementAlias match_LongAlternative___Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a;
	protected AbstractElementAlias match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0__a_Kw8Keyword_2_7_0__p;
	protected AbstractElementAlias match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw8Keyword_2_7_0__a_Kw7Keyword_2_6_0__p;
	protected AbstractElementAlias match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw6Keyword_2_5_0__p;
	protected AbstractElementAlias match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw5Keyword_2_4_0__p;
	protected AbstractElementAlias match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw4Keyword_2_3_0__p;
	protected AbstractElementAlias match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw3Keyword_2_2_0__p;
	protected AbstractElementAlias match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw2Keyword_2_1_0__p;
	protected AbstractElementAlias match_LongAlternative_____Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw1Keyword_2_0_0__p;
	protected AbstractElementAlias match_MandatoryManyTransition_KW1ParserRuleCall_1_p;
	protected AbstractElementAlias match_OptionalManyTransition_KW1ParserRuleCall_1_a;
	protected AbstractElementAlias match_OptionalSingleTransition_KW1ParserRuleCall_1_q;
	protected AbstractElementAlias match_Prim1_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_Prim1_LeftParenthesisKeyword_1_0_p;
	protected AbstractElementAlias match_Prim2_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_Prim2_LeftParenthesisKeyword_1_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SyntacticSequencerTestLanguageGrammarAccess) access;
		match_AlternativeTransition_KW1ParserRuleCall_1_0_or_Kw2Keyword_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAlternativeTransitionAccess().getKW1ParserRuleCall_1_0()), new TokenAlias(false, false, grammarAccess.getAlternativeTransitionAccess().getKw2Keyword_1_1()));
		match_LongAlternative___Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw1Keyword_2_0_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw2Keyword_2_1_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw3Keyword_2_2_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw4Keyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw5Keyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw6Keyword_2_5_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw7Keyword_2_6_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw8Keyword_2_7_0()));
		match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0__a_Kw8Keyword_2_7_0__p = new GroupAlias(true, false, new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw1Keyword_2_0_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw2Keyword_2_1_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw3Keyword_2_2_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw4Keyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw5Keyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw6Keyword_2_5_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw7Keyword_2_6_0())), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw8Keyword_2_7_0()));
		match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw8Keyword_2_7_0__a_Kw7Keyword_2_6_0__p = new GroupAlias(true, false, new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw1Keyword_2_0_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw2Keyword_2_1_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw3Keyword_2_2_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw4Keyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw5Keyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw6Keyword_2_5_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw8Keyword_2_7_0())), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw7Keyword_2_6_0()));
		match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw6Keyword_2_5_0__p = new GroupAlias(true, false, new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw1Keyword_2_0_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw2Keyword_2_1_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw3Keyword_2_2_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw4Keyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw5Keyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw7Keyword_2_6_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw8Keyword_2_7_0())), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw6Keyword_2_5_0()));
		match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw5Keyword_2_4_0__p = new GroupAlias(true, false, new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw1Keyword_2_0_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw2Keyword_2_1_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw3Keyword_2_2_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw4Keyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw6Keyword_2_5_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw7Keyword_2_6_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw8Keyword_2_7_0())), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw5Keyword_2_4_0()));
		match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw4Keyword_2_3_0__p = new GroupAlias(true, false, new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw1Keyword_2_0_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw2Keyword_2_1_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw3Keyword_2_2_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw5Keyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw6Keyword_2_5_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw7Keyword_2_6_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw8Keyword_2_7_0())), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw4Keyword_2_3_0()));
		match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw3Keyword_2_2_0__p = new GroupAlias(true, false, new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw1Keyword_2_0_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw2Keyword_2_1_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw4Keyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw5Keyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw6Keyword_2_5_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw7Keyword_2_6_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw8Keyword_2_7_0())), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw3Keyword_2_2_0()));
		match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw2Keyword_2_1_0__p = new GroupAlias(true, false, new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw1Keyword_2_0_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw3Keyword_2_2_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw4Keyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw5Keyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw6Keyword_2_5_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw7Keyword_2_6_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw8Keyword_2_7_0())), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw2Keyword_2_1_0()));
		match_LongAlternative_____Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw1Keyword_2_0_0__p = new GroupAlias(true, false, new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw2Keyword_2_1_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw3Keyword_2_2_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw4Keyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw5Keyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw6Keyword_2_5_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw7Keyword_2_6_0()), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw8Keyword_2_7_0())), new TokenAlias(false, false, grammarAccess.getLongAlternativeAccess().getKw1Keyword_2_0_0()));
		match_MandatoryManyTransition_KW1ParserRuleCall_1_p = new TokenAlias(true, false, grammarAccess.getMandatoryManyTransitionAccess().getKW1ParserRuleCall_1());
		match_OptionalManyTransition_KW1ParserRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getOptionalManyTransitionAccess().getKW1ParserRuleCall_1());
		match_OptionalSingleTransition_KW1ParserRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getOptionalSingleTransitionAccess().getKW1ParserRuleCall_1());
		match_Prim1_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getPrim1Access().getLeftParenthesisKeyword_1_0());
		match_Prim1_LeftParenthesisKeyword_1_0_p = new TokenAlias(true, false, grammarAccess.getPrim1Access().getLeftParenthesisKeyword_1_0());
		match_Prim2_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getPrim2Access().getLeftParenthesisKeyword_1_0());
		match_Prim2_LeftParenthesisKeyword_1_0_p = new TokenAlias(true, false, grammarAccess.getPrim2Access().getLeftParenthesisKeyword_1_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getBOOLEAN_TERMINAL_IDRule())
			return getBOOLEAN_TERMINAL_IDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getBooleanDatatypeIDRule())
			return getBooleanDatatypeIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getKW1Rule())
			return getKW1Token(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal BOOLEAN_TERMINAL_ID:
	 * 	'%1' ID;
	 */
	protected String getBOOLEAN_TERMINAL_IDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "%1";
	}
	
	/**
	 * BooleanDatatypeID:
	 * 	ID;
	 */
	protected String getBooleanDatatypeIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * KW1:
	 * 	"kw1" | "matched" INT?;
	 */
	protected String getKW1Token(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "kw1";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AlternativeTransition_KW1ParserRuleCall_1_0_or_Kw2Keyword_1_1.equals(syntax))
				emit_AlternativeTransition_KW1ParserRuleCall_1_0_or_Kw2Keyword_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LongAlternative___Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a.equals(syntax))
				emit_LongAlternative___Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0__a_Kw8Keyword_2_7_0__p.equals(syntax))
				emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0__a_Kw8Keyword_2_7_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw8Keyword_2_7_0__a_Kw7Keyword_2_6_0__p.equals(syntax))
				emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw8Keyword_2_7_0__a_Kw7Keyword_2_6_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw6Keyword_2_5_0__p.equals(syntax))
				emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw6Keyword_2_5_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw5Keyword_2_4_0__p.equals(syntax))
				emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw5Keyword_2_4_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw4Keyword_2_3_0__p.equals(syntax))
				emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw4Keyword_2_3_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw3Keyword_2_2_0__p.equals(syntax))
				emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw3Keyword_2_2_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LongAlternative_____Kw1Keyword_2_0_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw2Keyword_2_1_0__p.equals(syntax))
				emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw2Keyword_2_1_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LongAlternative_____Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw1Keyword_2_0_0__p.equals(syntax))
				emit_LongAlternative_____Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw1Keyword_2_0_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MandatoryManyTransition_KW1ParserRuleCall_1_p.equals(syntax))
				emit_MandatoryManyTransition_KW1ParserRuleCall_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_OptionalManyTransition_KW1ParserRuleCall_1_a.equals(syntax))
				emit_OptionalManyTransition_KW1ParserRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_OptionalSingleTransition_KW1ParserRuleCall_1_q.equals(syntax))
				emit_OptionalSingleTransition_KW1ParserRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Prim1_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_Prim1_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Prim1_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_Prim1_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Prim2_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_Prim2_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Prim2_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_Prim2_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'kw2' | KW1
	 */
	protected void emit_AlternativeTransition_KW1ParserRuleCall_1_0_or_Kw2Keyword_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     'kw2' | 
	     'kw7' | 
	     'kw3' | 
	     'kw4' | 
	     'kw8' | 
	     'kw1' | 
	     'kw6' | 
	     'kw5'
	 )*
	 */
	protected void emit_LongAlternative___Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     (
	         'kw2' | 
	         'kw7' | 
	         'kw3' | 
	         'kw4' | 
	         'kw1' | 
	         'kw6' | 
	         'kw5'
	     )* 
	     'kw8'
	 )+
	 */
	protected void emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0__a_Kw8Keyword_2_7_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     (
	         'kw2' | 
	         'kw3' | 
	         'kw4' | 
	         'kw8' | 
	         'kw1' | 
	         'kw6' | 
	         'kw5'
	     )* 
	     'kw7'
	 )+
	 */
	protected void emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw8Keyword_2_7_0__a_Kw7Keyword_2_6_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     (
	         'kw2' | 
	         'kw7' | 
	         'kw3' | 
	         'kw4' | 
	         'kw8' | 
	         'kw1' | 
	         'kw5'
	     )* 
	     'kw6'
	 )+
	 */
	protected void emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw6Keyword_2_5_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     (
	         'kw2' | 
	         'kw7' | 
	         'kw3' | 
	         'kw4' | 
	         'kw8' | 
	         'kw1' | 
	         'kw6'
	     )* 
	     'kw5'
	 )+
	 */
	protected void emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw5Keyword_2_4_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     (
	         'kw2' | 
	         'kw7' | 
	         'kw3' | 
	         'kw8' | 
	         'kw1' | 
	         'kw6' | 
	         'kw5'
	     )* 
	     'kw4'
	 )+
	 */
	protected void emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw4Keyword_2_3_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     (
	         'kw2' | 
	         'kw7' | 
	         'kw4' | 
	         'kw8' | 
	         'kw1' | 
	         'kw6' | 
	         'kw5'
	     )* 
	     'kw3'
	 )+
	 */
	protected void emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw2Keyword_2_1_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw3Keyword_2_2_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     (
	         'kw7' | 
	         'kw3' | 
	         'kw4' | 
	         'kw8' | 
	         'kw1' | 
	         'kw6' | 
	         'kw5'
	     )* 
	     'kw2'
	 )+
	 */
	protected void emit_LongAlternative_____Kw1Keyword_2_0_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw2Keyword_2_1_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     (
	         'kw2' | 
	         'kw7' | 
	         'kw3' | 
	         'kw4' | 
	         'kw8' | 
	         'kw6' | 
	         'kw5'
	     )* 
	     'kw1'
	 )+
	 */
	protected void emit_LongAlternative_____Kw2Keyword_2_1_0_or_Kw3Keyword_2_2_0_or_Kw4Keyword_2_3_0_or_Kw5Keyword_2_4_0_or_Kw6Keyword_2_5_0_or_Kw7Keyword_2_6_0_or_Kw8Keyword_2_7_0__a_Kw1Keyword_2_0_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     KW1+
	 */
	protected void emit_MandatoryManyTransition_KW1ParserRuleCall_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     KW1*
	 */
	protected void emit_OptionalManyTransition_KW1ParserRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     KW1?
	 */
	protected void emit_OptionalSingleTransition_KW1ParserRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_Prim1_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_Prim1_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_Prim2_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_Prim2_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
