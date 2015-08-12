package org.eclipse.xtext.parsetree.formatter.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.formatter.idea.lang.psi.impl.ElementMatcherTestLanguageFileImpl;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class ElementMatcherTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<ElementMatcherTestLanguageFileImpl>>(ElementMatcherTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final ElementMatcherTestLanguageGrammarAccess GRAMMAR_ACCESS = ElementMatcherTestLanguageLanguage.INSTANCE.getInstance(ElementMatcherTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_SimpleParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_SimpleParserRuleCall_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSimpleParserRuleCall_0());
		}
		public static IGrammarAwareElementType createModel_RuleCallsParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Model_RuleCallsParserRuleCall_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRuleCallsParserRuleCall_1());
		}
		public static IGrammarAwareElementType createModel_OptionalCallsParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Model_OptionalCallsParserRuleCall_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getOptionalCallsParserRuleCall_2());
		}
		public static IGrammarAwareElementType createModel_RecursionParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Model_RecursionParserRuleCall_3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRecursionParserRuleCall_3());
		}
		public static IGrammarAwareElementType createModel_LoopParserRuleCall_4ElementType() {
			return new IGrammarAwareElementType("Model_LoopParserRuleCall_4_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getLoopParserRuleCall_4());
		}
		public static IGrammarAwareElementType createModel_ExpressionParserRuleCall_5ElementType() {
			return new IGrammarAwareElementType("Model_ExpressionParserRuleCall_5_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getExpressionParserRuleCall_5());
		}
		public static IGrammarAwareElementType createModel_RuleCalls12ParserRuleCall_6ElementType() {
			return new IGrammarAwareElementType("Model_RuleCalls12ParserRuleCall_6_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRuleCalls12ParserRuleCall_6());
		}
		public static IGrammarAwareElementType createModel_NestedStartParserRuleCall_7ElementType() {
			return new IGrammarAwareElementType("Model_NestedStartParserRuleCall_7_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedStartParserRuleCall_7());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_SimpleParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SimpleParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Model_RuleCallsParserRuleCall_1_ELEMENT_TYPE = associate(ModelFactory.createModel_RuleCallsParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Model_OptionalCallsParserRuleCall_2_ELEMENT_TYPE = associate(ModelFactory.createModel_OptionalCallsParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType Model_RecursionParserRuleCall_3_ELEMENT_TYPE = associate(ModelFactory.createModel_RecursionParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType Model_LoopParserRuleCall_4_ELEMENT_TYPE = associate(ModelFactory.createModel_LoopParserRuleCall_4ElementType());

	public static final IGrammarAwareElementType Model_ExpressionParserRuleCall_5_ELEMENT_TYPE = associate(ModelFactory.createModel_ExpressionParserRuleCall_5ElementType());

	public static final IGrammarAwareElementType Model_RuleCalls12ParserRuleCall_6_ELEMENT_TYPE = associate(ModelFactory.createModel_RuleCalls12ParserRuleCall_6ElementType());

	public static final IGrammarAwareElementType Model_NestedStartParserRuleCall_7_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedStartParserRuleCall_7ElementType());

	private static class SimpleFactory {
		public static IGrammarAwareElementType createSimpleElementType() {
			return new IGrammarAwareElementType("Simple_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleRule());
		}
		public static IGrammarAwareElementType createSimple_GroupElementType() {
			return new IGrammarAwareElementType("Simple_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getGroup());
		}
		public static IGrammarAwareElementType createSimple_NumberSignDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("Simple_NumberSignDigitOneKeyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getNumberSignDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createSimple_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Simple_NameAssignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSimple_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Simple_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSimple_Group_2ElementType() {
			return new IGrammarAwareElementType("Simple_Group_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createSimple_Kw1Keyword_2_0ElementType() {
			return new IGrammarAwareElementType("Simple_Kw1Keyword_2_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getKw1Keyword_2_0());
		}
		public static IGrammarAwareElementType createSimple_OptionalAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Simple_OptionalAssignment_2_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getOptionalAssignment_2_1());
		}
		public static IGrammarAwareElementType createSimple_OptionalIDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Simple_OptionalIDTerminalRuleCall_2_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getOptionalIDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createSimple_DatatypeAssignment_3ElementType() {
			return new IGrammarAwareElementType("Simple_DatatypeAssignment_3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getDatatypeAssignment_3());
		}
		public static IGrammarAwareElementType createSimple_DatatypeFQNParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Simple_DatatypeFQNParserRuleCall_3_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getDatatypeFQNParserRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType Simple_ELEMENT_TYPE = associate(SimpleFactory.createSimpleElementType());

	public static final IGrammarAwareElementType Simple_Group_ELEMENT_TYPE = associate(SimpleFactory.createSimple_GroupElementType());

	public static final IGrammarAwareElementType Simple_NumberSignDigitOneKeyword_0_ELEMENT_TYPE = associate(SimpleFactory.createSimple_NumberSignDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType Simple_NameAssignment_1_ELEMENT_TYPE = associate(SimpleFactory.createSimple_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Simple_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SimpleFactory.createSimple_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Simple_Group_2_ELEMENT_TYPE = associate(SimpleFactory.createSimple_Group_2ElementType());

	public static final IGrammarAwareElementType Simple_Kw1Keyword_2_0_ELEMENT_TYPE = associate(SimpleFactory.createSimple_Kw1Keyword_2_0ElementType());

	public static final IGrammarAwareElementType Simple_OptionalAssignment_2_1_ELEMENT_TYPE = associate(SimpleFactory.createSimple_OptionalAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Simple_OptionalIDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(SimpleFactory.createSimple_OptionalIDTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Simple_DatatypeAssignment_3_ELEMENT_TYPE = associate(SimpleFactory.createSimple_DatatypeAssignment_3ElementType());

	public static final IGrammarAwareElementType Simple_DatatypeFQNParserRuleCall_3_0_ELEMENT_TYPE = associate(SimpleFactory.createSimple_DatatypeFQNParserRuleCall_3_0ElementType());

	private static class FQNFactory {
		public static IGrammarAwareElementType createFQNElementType() {
			return new IGrammarAwareElementType("FQN_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNRule());
		}
		public static IGrammarAwareElementType createFQN_GroupElementType() {
			return new IGrammarAwareElementType("FQN_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN_Group_1ElementType() {
			return new IGrammarAwareElementType("FQN_Group_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createFQN_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("FQN_FullStopKeyword_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType FQN_ELEMENT_TYPE = associate(FQNFactory.createFQNElementType());

	public static final IGrammarAwareElementType FQN_Group_ELEMENT_TYPE = associate(FQNFactory.createFQN_GroupElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType FQN_Group_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_Group_1ElementType());

	public static final IGrammarAwareElementType FQN_FullStopKeyword_1_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_1_1ElementType());

	private static class RuleCallsFactory {
		public static IGrammarAwareElementType createRuleCallsElementType() {
			return new IGrammarAwareElementType("RuleCalls_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsRule());
		}
		public static IGrammarAwareElementType createRuleCalls_GroupElementType() {
			return new IGrammarAwareElementType("RuleCalls_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAccess().getGroup());
		}
		public static IGrammarAwareElementType createRuleCalls_NumberSignDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("RuleCalls_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAccess().getNumberSignDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createRuleCalls_RuleCallsSubParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("RuleCalls_RuleCallsSubParserRuleCall_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAccess().getRuleCallsSubParserRuleCall_1());
		}
		public static IGrammarAwareElementType createRuleCalls_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("RuleCalls_NameAssignment_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createRuleCalls_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("RuleCalls_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createRuleCalls_Call1Assignment_3ElementType() {
			return new IGrammarAwareElementType("RuleCalls_Call1Assignment_3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAccess().getCall1Assignment_3());
		}
		public static IGrammarAwareElementType createRuleCalls_Call1RuleCallsAss1ParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("RuleCalls_Call1RuleCallsAss1ParserRuleCall_3_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAccess().getCall1RuleCallsAss1ParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createRuleCalls_Call2Assignment_4ElementType() {
			return new IGrammarAwareElementType("RuleCalls_Call2Assignment_4_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAccess().getCall2Assignment_4());
		}
		public static IGrammarAwareElementType createRuleCalls_Call2RuleCallsAss2ParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("RuleCalls_Call2RuleCallsAss2ParserRuleCall_4_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAccess().getCall2RuleCallsAss2ParserRuleCall_4_0());
		}
	}

	public static final IGrammarAwareElementType RuleCalls_ELEMENT_TYPE = associate(RuleCallsFactory.createRuleCallsElementType());

	public static final IGrammarAwareElementType RuleCalls_Group_ELEMENT_TYPE = associate(RuleCallsFactory.createRuleCalls_GroupElementType());

	public static final IGrammarAwareElementType RuleCalls_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE = associate(RuleCallsFactory.createRuleCalls_NumberSignDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType RuleCalls_RuleCallsSubParserRuleCall_1_ELEMENT_TYPE = associate(RuleCallsFactory.createRuleCalls_RuleCallsSubParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType RuleCalls_NameAssignment_2_ELEMENT_TYPE = associate(RuleCallsFactory.createRuleCalls_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType RuleCalls_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(RuleCallsFactory.createRuleCalls_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType RuleCalls_Call1Assignment_3_ELEMENT_TYPE = associate(RuleCallsFactory.createRuleCalls_Call1Assignment_3ElementType());

	public static final IGrammarAwareElementType RuleCalls_Call1RuleCallsAss1ParserRuleCall_3_0_ELEMENT_TYPE = associate(RuleCallsFactory.createRuleCalls_Call1RuleCallsAss1ParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType RuleCalls_Call2Assignment_4_ELEMENT_TYPE = associate(RuleCallsFactory.createRuleCalls_Call2Assignment_4ElementType());

	public static final IGrammarAwareElementType RuleCalls_Call2RuleCallsAss2ParserRuleCall_4_0_ELEMENT_TYPE = associate(RuleCallsFactory.createRuleCalls_Call2RuleCallsAss2ParserRuleCall_4_0ElementType());

	private static class RuleCallsSubFactory {
		public static IGrammarAwareElementType createRuleCallsSubElementType() {
			return new IGrammarAwareElementType("RuleCallsSub_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsSubRule());
		}
		public static IGrammarAwareElementType createRuleCallsSub_SubAssignmentElementType() {
			return new IGrammarAwareElementType("RuleCallsSub_SubAssignment_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsSubAccess().getSubAssignment());
		}
		public static IGrammarAwareElementType createRuleCallsSub_SubSubKeyword_0ElementType() {
			return new IGrammarAwareElementType("RuleCallsSub_SubSubKeyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsSubAccess().getSubSubKeyword_0());
		}
	}

	public static final IGrammarAwareElementType RuleCallsSub_ELEMENT_TYPE = associate(RuleCallsSubFactory.createRuleCallsSubElementType());

	public static final IGrammarAwareElementType RuleCallsSub_SubAssignment_ELEMENT_TYPE = associate(RuleCallsSubFactory.createRuleCallsSub_SubAssignmentElementType());

	public static final IGrammarAwareElementType RuleCallsSub_SubSubKeyword_0_ELEMENT_TYPE = associate(RuleCallsSubFactory.createRuleCallsSub_SubSubKeyword_0ElementType());

	private static class RuleCallsAss1Factory {
		public static IGrammarAwareElementType createRuleCallsAss1ElementType() {
			return new IGrammarAwareElementType("RuleCallsAss1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAss1Rule());
		}
		public static IGrammarAwareElementType createRuleCallsAss1_GroupElementType() {
			return new IGrammarAwareElementType("RuleCallsAss1_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAss1Access().getGroup());
		}
		public static IGrammarAwareElementType createRuleCallsAss1_Ass1Keyword_0ElementType() {
			return new IGrammarAwareElementType("RuleCallsAss1_Ass1Keyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAss1Access().getAss1Keyword_0());
		}
		public static IGrammarAwareElementType createRuleCallsAss1_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("RuleCallsAss1_NameAssignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAss1Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createRuleCallsAss1_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCallsAss1_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAss1Access().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType RuleCallsAss1_ELEMENT_TYPE = associate(RuleCallsAss1Factory.createRuleCallsAss1ElementType());

	public static final IGrammarAwareElementType RuleCallsAss1_Group_ELEMENT_TYPE = associate(RuleCallsAss1Factory.createRuleCallsAss1_GroupElementType());

	public static final IGrammarAwareElementType RuleCallsAss1_Ass1Keyword_0_ELEMENT_TYPE = associate(RuleCallsAss1Factory.createRuleCallsAss1_Ass1Keyword_0ElementType());

	public static final IGrammarAwareElementType RuleCallsAss1_NameAssignment_1_ELEMENT_TYPE = associate(RuleCallsAss1Factory.createRuleCallsAss1_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType RuleCallsAss1_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(RuleCallsAss1Factory.createRuleCallsAss1_NameIDTerminalRuleCall_1_0ElementType());

	private static class RuleCallsAss2Factory {
		public static IGrammarAwareElementType createRuleCallsAss2ElementType() {
			return new IGrammarAwareElementType("RuleCallsAss2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAss2Rule());
		}
		public static IGrammarAwareElementType createRuleCallsAss2_GroupElementType() {
			return new IGrammarAwareElementType("RuleCallsAss2_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAss2Access().getGroup());
		}
		public static IGrammarAwareElementType createRuleCallsAss2_Ass2Keyword_0ElementType() {
			return new IGrammarAwareElementType("RuleCallsAss2_Ass2Keyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAss2Access().getAss2Keyword_0());
		}
		public static IGrammarAwareElementType createRuleCallsAss2_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("RuleCallsAss2_NameAssignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAss2Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createRuleCallsAss2_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCallsAss2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallsAss2Access().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType RuleCallsAss2_ELEMENT_TYPE = associate(RuleCallsAss2Factory.createRuleCallsAss2ElementType());

	public static final IGrammarAwareElementType RuleCallsAss2_Group_ELEMENT_TYPE = associate(RuleCallsAss2Factory.createRuleCallsAss2_GroupElementType());

	public static final IGrammarAwareElementType RuleCallsAss2_Ass2Keyword_0_ELEMENT_TYPE = associate(RuleCallsAss2Factory.createRuleCallsAss2_Ass2Keyword_0ElementType());

	public static final IGrammarAwareElementType RuleCallsAss2_NameAssignment_1_ELEMENT_TYPE = associate(RuleCallsAss2Factory.createRuleCallsAss2_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType RuleCallsAss2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(RuleCallsAss2Factory.createRuleCallsAss2_NameIDTerminalRuleCall_1_0ElementType());

	private static class OptionalCallsFactory {
		public static IGrammarAwareElementType createOptionalCallsElementType() {
			return new IGrammarAwareElementType("OptionalCalls_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsRule());
		}
		public static IGrammarAwareElementType createOptionalCalls_GroupElementType() {
			return new IGrammarAwareElementType("OptionalCalls_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsAccess().getGroup());
		}
		public static IGrammarAwareElementType createOptionalCalls_NumberSignDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("OptionalCalls_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsAccess().getNumberSignDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createOptionalCalls_OptionalCallsAction_1ElementType() {
			return new IGrammarAwareElementType("OptionalCalls_OptionalCallsAction_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsAccess().getOptionalCallsAction_1());
		}
		public static IGrammarAwareElementType createOptionalCalls_Opt1Assignment_2ElementType() {
			return new IGrammarAwareElementType("OptionalCalls_Opt1Assignment_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsAccess().getOpt1Assignment_2());
		}
		public static IGrammarAwareElementType createOptionalCalls_Opt1OptionalCallsSub1ParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("OptionalCalls_Opt1OptionalCallsSub1ParserRuleCall_2_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsAccess().getOpt1OptionalCallsSub1ParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createOptionalCalls_NameAssignment_3ElementType() {
			return new IGrammarAwareElementType("OptionalCalls_NameAssignment_3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsAccess().getNameAssignment_3());
		}
		public static IGrammarAwareElementType createOptionalCalls_NameIDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("OptionalCalls_NameIDTerminalRuleCall_3_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsAccess().getNameIDTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType OptionalCalls_ELEMENT_TYPE = associate(OptionalCallsFactory.createOptionalCallsElementType());

	public static final IGrammarAwareElementType OptionalCalls_Group_ELEMENT_TYPE = associate(OptionalCallsFactory.createOptionalCalls_GroupElementType());

	public static final IGrammarAwareElementType OptionalCalls_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE = associate(OptionalCallsFactory.createOptionalCalls_NumberSignDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType OptionalCalls_OptionalCallsAction_1_ELEMENT_TYPE = associate(OptionalCallsFactory.createOptionalCalls_OptionalCallsAction_1ElementType());

	public static final IGrammarAwareElementType OptionalCalls_Opt1Assignment_2_ELEMENT_TYPE = associate(OptionalCallsFactory.createOptionalCalls_Opt1Assignment_2ElementType());

	public static final IGrammarAwareElementType OptionalCalls_Opt1OptionalCallsSub1ParserRuleCall_2_0_ELEMENT_TYPE = associate(OptionalCallsFactory.createOptionalCalls_Opt1OptionalCallsSub1ParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType OptionalCalls_NameAssignment_3_ELEMENT_TYPE = associate(OptionalCallsFactory.createOptionalCalls_NameAssignment_3ElementType());

	public static final IGrammarAwareElementType OptionalCalls_NameIDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(OptionalCallsFactory.createOptionalCalls_NameIDTerminalRuleCall_3_0ElementType());

	private static class OptionalCallsSub1Factory {
		public static IGrammarAwareElementType createOptionalCallsSub1ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub1Rule());
		}
		public static IGrammarAwareElementType createOptionalCallsSub1_GroupElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub1_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub1Access().getGroup());
		}
		public static IGrammarAwareElementType createOptionalCallsSub1_OptionalCallsSub1Action_0ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub1_OptionalCallsSub1Action_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub1Access().getOptionalCallsSub1Action_0());
		}
		public static IGrammarAwareElementType createOptionalCallsSub1_Opt2Assignment_1ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub1_Opt2Assignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub1Access().getOpt2Assignment_1());
		}
		public static IGrammarAwareElementType createOptionalCallsSub1_Opt2OptionalCallsSub2ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub1_Opt2OptionalCallsSub2ParserRuleCall_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub1Access().getOpt2OptionalCallsSub2ParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createOptionalCallsSub1_SubKeyword_2ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub1_SubKeyword_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub1Access().getSubKeyword_2());
		}
		public static IGrammarAwareElementType createOptionalCallsSub1_Opt3Assignment_3ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub1_Opt3Assignment_3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub1Access().getOpt3Assignment_3());
		}
		public static IGrammarAwareElementType createOptionalCallsSub1_Opt3OptionalCallsSub3ParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub1_Opt3OptionalCallsSub3ParserRuleCall_3_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub1Access().getOpt3OptionalCallsSub3ParserRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType OptionalCallsSub1_ELEMENT_TYPE = associate(OptionalCallsSub1Factory.createOptionalCallsSub1ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub1_Group_ELEMENT_TYPE = associate(OptionalCallsSub1Factory.createOptionalCallsSub1_GroupElementType());

	public static final IGrammarAwareElementType OptionalCallsSub1_OptionalCallsSub1Action_0_ELEMENT_TYPE = associate(OptionalCallsSub1Factory.createOptionalCallsSub1_OptionalCallsSub1Action_0ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub1_Opt2Assignment_1_ELEMENT_TYPE = associate(OptionalCallsSub1Factory.createOptionalCallsSub1_Opt2Assignment_1ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub1_Opt2OptionalCallsSub2ParserRuleCall_1_0_ELEMENT_TYPE = associate(OptionalCallsSub1Factory.createOptionalCallsSub1_Opt2OptionalCallsSub2ParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub1_SubKeyword_2_ELEMENT_TYPE = associate(OptionalCallsSub1Factory.createOptionalCallsSub1_SubKeyword_2ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub1_Opt3Assignment_3_ELEMENT_TYPE = associate(OptionalCallsSub1Factory.createOptionalCallsSub1_Opt3Assignment_3ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub1_Opt3OptionalCallsSub3ParserRuleCall_3_0_ELEMENT_TYPE = associate(OptionalCallsSub1Factory.createOptionalCallsSub1_Opt3OptionalCallsSub3ParserRuleCall_3_0ElementType());

	private static class OptionalCallsSub2Factory {
		public static IGrammarAwareElementType createOptionalCallsSub2ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub2Rule());
		}
		public static IGrammarAwareElementType createOptionalCallsSub2_GroupElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub2_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub2Access().getGroup());
		}
		public static IGrammarAwareElementType createOptionalCallsSub2_Sub2Keyword_0ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub2_Sub2Keyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub2Access().getSub2Keyword_0());
		}
		public static IGrammarAwareElementType createOptionalCallsSub2_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub2_NameAssignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub2Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createOptionalCallsSub2_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub2Access().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType OptionalCallsSub2_ELEMENT_TYPE = associate(OptionalCallsSub2Factory.createOptionalCallsSub2ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub2_Group_ELEMENT_TYPE = associate(OptionalCallsSub2Factory.createOptionalCallsSub2_GroupElementType());

	public static final IGrammarAwareElementType OptionalCallsSub2_Sub2Keyword_0_ELEMENT_TYPE = associate(OptionalCallsSub2Factory.createOptionalCallsSub2_Sub2Keyword_0ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub2_NameAssignment_1_ELEMENT_TYPE = associate(OptionalCallsSub2Factory.createOptionalCallsSub2_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(OptionalCallsSub2Factory.createOptionalCallsSub2_NameIDTerminalRuleCall_1_0ElementType());

	private static class OptionalCallsSub3Factory {
		public static IGrammarAwareElementType createOptionalCallsSub3ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub3Rule());
		}
		public static IGrammarAwareElementType createOptionalCallsSub3_GroupElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub3_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub3Access().getGroup());
		}
		public static IGrammarAwareElementType createOptionalCallsSub3_Sub3Keyword_0ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub3_Sub3Keyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub3Access().getSub3Keyword_0());
		}
		public static IGrammarAwareElementType createOptionalCallsSub3_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub3_NameAssignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub3Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createOptionalCallsSub3_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("OptionalCallsSub3_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalCallsSub3Access().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType OptionalCallsSub3_ELEMENT_TYPE = associate(OptionalCallsSub3Factory.createOptionalCallsSub3ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub3_Group_ELEMENT_TYPE = associate(OptionalCallsSub3Factory.createOptionalCallsSub3_GroupElementType());

	public static final IGrammarAwareElementType OptionalCallsSub3_Sub3Keyword_0_ELEMENT_TYPE = associate(OptionalCallsSub3Factory.createOptionalCallsSub3_Sub3Keyword_0ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub3_NameAssignment_1_ELEMENT_TYPE = associate(OptionalCallsSub3Factory.createOptionalCallsSub3_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType OptionalCallsSub3_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(OptionalCallsSub3Factory.createOptionalCallsSub3_NameIDTerminalRuleCall_1_0ElementType());

	private static class RecursionFactory {
		public static IGrammarAwareElementType createRecursionElementType() {
			return new IGrammarAwareElementType("Recursion_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionRule());
		}
		public static IGrammarAwareElementType createRecursion_GroupElementType() {
			return new IGrammarAwareElementType("Recursion_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionAccess().getGroup());
		}
		public static IGrammarAwareElementType createRecursion_NumberSignDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("Recursion_NumberSignDigitFourKeyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionAccess().getNumberSignDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createRecursion_RecursionSubParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Recursion_RecursionSubParserRuleCall_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionAccess().getRecursionSubParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Recursion_ELEMENT_TYPE = associate(RecursionFactory.createRecursionElementType());

	public static final IGrammarAwareElementType Recursion_Group_ELEMENT_TYPE = associate(RecursionFactory.createRecursion_GroupElementType());

	public static final IGrammarAwareElementType Recursion_NumberSignDigitFourKeyword_0_ELEMENT_TYPE = associate(RecursionFactory.createRecursion_NumberSignDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType Recursion_RecursionSubParserRuleCall_1_ELEMENT_TYPE = associate(RecursionFactory.createRecursion_RecursionSubParserRuleCall_1ElementType());

	private static class RecursionSubFactory {
		public static IGrammarAwareElementType createRecursionSubElementType() {
			return new IGrammarAwareElementType("RecursionSub_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubRule());
		}
		public static IGrammarAwareElementType createRecursionSub_GroupElementType() {
			return new IGrammarAwareElementType("RecursionSub_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getGroup());
		}
		public static IGrammarAwareElementType createRecursionSub_RecursionSubAction_0ElementType() {
			return new IGrammarAwareElementType("RecursionSub_RecursionSubAction_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getRecursionSubAction_0());
		}
		public static IGrammarAwareElementType createRecursionSub_LeftCurlyBracketKeyword_1ElementType() {
			return new IGrammarAwareElementType("RecursionSub_LeftCurlyBracketKeyword_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getLeftCurlyBracketKeyword_1());
		}
		public static IGrammarAwareElementType createRecursionSub_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("RecursionSub_Alternatives_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createRecursionSub_SubAssignment_2_0ElementType() {
			return new IGrammarAwareElementType("RecursionSub_SubAssignment_2_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getSubAssignment_2_0());
		}
		public static IGrammarAwareElementType createRecursionSub_SubRecursionSubParserRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("RecursionSub_SubRecursionSubParserRuleCall_2_0_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getSubRecursionSubParserRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createRecursionSub_ValsAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("RecursionSub_ValsAssignment_2_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getValsAssignment_2_1());
		}
		public static IGrammarAwareElementType createRecursionSub_ValsIDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("RecursionSub_ValsIDTerminalRuleCall_2_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getValsIDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createRecursionSub_RightCurlyBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("RecursionSub_RightCurlyBracketKeyword_3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getRightCurlyBracketKeyword_3());
		}
		public static IGrammarAwareElementType createRecursionSub_SemiAssignment_4ElementType() {
			return new IGrammarAwareElementType("RecursionSub_SemiAssignment_4_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getSemiAssignment_4());
		}
		public static IGrammarAwareElementType createRecursionSub_SemiSemicolonKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("RecursionSub_SemiSemicolonKeyword_4_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursionSubAccess().getSemiSemicolonKeyword_4_0());
		}
	}

	public static final IGrammarAwareElementType RecursionSub_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSubElementType());

	public static final IGrammarAwareElementType RecursionSub_Group_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_GroupElementType());

	public static final IGrammarAwareElementType RecursionSub_RecursionSubAction_0_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_RecursionSubAction_0ElementType());

	public static final IGrammarAwareElementType RecursionSub_LeftCurlyBracketKeyword_1_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_LeftCurlyBracketKeyword_1ElementType());

	public static final IGrammarAwareElementType RecursionSub_Alternatives_2_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_Alternatives_2ElementType());

	public static final IGrammarAwareElementType RecursionSub_SubAssignment_2_0_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_SubAssignment_2_0ElementType());

	public static final IGrammarAwareElementType RecursionSub_SubRecursionSubParserRuleCall_2_0_0_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_SubRecursionSubParserRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType RecursionSub_ValsAssignment_2_1_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_ValsAssignment_2_1ElementType());

	public static final IGrammarAwareElementType RecursionSub_ValsIDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_ValsIDTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType RecursionSub_RightCurlyBracketKeyword_3_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_RightCurlyBracketKeyword_3ElementType());

	public static final IGrammarAwareElementType RecursionSub_SemiAssignment_4_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_SemiAssignment_4ElementType());

	public static final IGrammarAwareElementType RecursionSub_SemiSemicolonKeyword_4_0_ELEMENT_TYPE = associate(RecursionSubFactory.createRecursionSub_SemiSemicolonKeyword_4_0ElementType());

	private static class LoopFactory {
		public static IGrammarAwareElementType createLoopElementType() {
			return new IGrammarAwareElementType("Loop_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopRule());
		}
		public static IGrammarAwareElementType createLoop_GroupElementType() {
			return new IGrammarAwareElementType("Loop_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getGroup());
		}
		public static IGrammarAwareElementType createLoop_NumberSignDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("Loop_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getNumberSignDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createLoop_NamesAssignment_1ElementType() {
			return new IGrammarAwareElementType("Loop_NamesAssignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getNamesAssignment_1());
		}
		public static IGrammarAwareElementType createLoop_NamesIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Loop_NamesIDTerminalRuleCall_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getNamesIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createLoop_Group_2ElementType() {
			return new IGrammarAwareElementType("Loop_Group_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createLoop_GrKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Loop_GrKeyword_2_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getGrKeyword_2_0());
		}
		public static IGrammarAwareElementType createLoop_GrAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Loop_GrAssignment_2_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getGrAssignment_2_1());
		}
		public static IGrammarAwareElementType createLoop_GrIDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Loop_GrIDTerminalRuleCall_2_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getGrIDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createLoop_Alternatives_3ElementType() {
			return new IGrammarAwareElementType("Loop_Alternatives_3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getAlternatives_3());
		}
		public static IGrammarAwareElementType createLoop_IntsAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("Loop_IntsAssignment_3_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getIntsAssignment_3_0());
		}
		public static IGrammarAwareElementType createLoop_IntsINTTerminalRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("Loop_IntsINTTerminalRuleCall_3_0_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getIntsINTTerminalRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createLoop_StringsAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Loop_StringsAssignment_3_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getStringsAssignment_3_1());
		}
		public static IGrammarAwareElementType createLoop_StringsSTRINGTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Loop_StringsSTRINGTerminalRuleCall_3_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopAccess().getStringsSTRINGTerminalRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType Loop_ELEMENT_TYPE = associate(LoopFactory.createLoopElementType());

	public static final IGrammarAwareElementType Loop_Group_ELEMENT_TYPE = associate(LoopFactory.createLoop_GroupElementType());

	public static final IGrammarAwareElementType Loop_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE = associate(LoopFactory.createLoop_NumberSignDigitFiveKeyword_0ElementType());

	public static final IGrammarAwareElementType Loop_NamesAssignment_1_ELEMENT_TYPE = associate(LoopFactory.createLoop_NamesAssignment_1ElementType());

	public static final IGrammarAwareElementType Loop_NamesIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(LoopFactory.createLoop_NamesIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Loop_Group_2_ELEMENT_TYPE = associate(LoopFactory.createLoop_Group_2ElementType());

	public static final IGrammarAwareElementType Loop_GrKeyword_2_0_ELEMENT_TYPE = associate(LoopFactory.createLoop_GrKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Loop_GrAssignment_2_1_ELEMENT_TYPE = associate(LoopFactory.createLoop_GrAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Loop_GrIDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(LoopFactory.createLoop_GrIDTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Loop_Alternatives_3_ELEMENT_TYPE = associate(LoopFactory.createLoop_Alternatives_3ElementType());

	public static final IGrammarAwareElementType Loop_IntsAssignment_3_0_ELEMENT_TYPE = associate(LoopFactory.createLoop_IntsAssignment_3_0ElementType());

	public static final IGrammarAwareElementType Loop_IntsINTTerminalRuleCall_3_0_0_ELEMENT_TYPE = associate(LoopFactory.createLoop_IntsINTTerminalRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType Loop_StringsAssignment_3_1_ELEMENT_TYPE = associate(LoopFactory.createLoop_StringsAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Loop_StringsSTRINGTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(LoopFactory.createLoop_StringsSTRINGTerminalRuleCall_3_1_0ElementType());

	private static class ExpressionFactory {
		public static IGrammarAwareElementType createExpressionElementType() {
			return new IGrammarAwareElementType("Expression_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionRule());
		}
		public static IGrammarAwareElementType createExpression_GroupElementType() {
			return new IGrammarAwareElementType("Expression_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createExpression_NumberSignDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("Expression_NumberSignDigitSixKeyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getNumberSignDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createExpression_AddParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Expression_AddParserRuleCall_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getAddParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Expression_ELEMENT_TYPE = associate(ExpressionFactory.createExpressionElementType());

	public static final IGrammarAwareElementType Expression_Group_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_GroupElementType());

	public static final IGrammarAwareElementType Expression_NumberSignDigitSixKeyword_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_NumberSignDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType Expression_AddParserRuleCall_1_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_AddParserRuleCall_1ElementType());

	private static class AddFactory {
		public static IGrammarAwareElementType createAddElementType() {
			return new IGrammarAwareElementType("Add_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddRule());
		}
		public static IGrammarAwareElementType createAdd_GroupElementType() {
			return new IGrammarAwareElementType("Add_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddAccess().getGroup());
		}
		public static IGrammarAwareElementType createAdd_MultParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Add_MultParserRuleCall_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddAccess().getMultParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAdd_Group_1ElementType() {
			return new IGrammarAwareElementType("Add_Group_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createAdd_AddLeftAction_1_0ElementType() {
			return new IGrammarAwareElementType("Add_AddLeftAction_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddAccess().getAddLeftAction_1_0());
		}
		public static IGrammarAwareElementType createAdd_PlusSignKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("Add_PlusSignKeyword_1_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddAccess().getPlusSignKeyword_1_1());
		}
		public static IGrammarAwareElementType createAdd_RightAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Add_RightAssignment_1_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddAccess().getRightAssignment_1_2());
		}
		public static IGrammarAwareElementType createAdd_RightMultParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Add_RightMultParserRuleCall_1_2_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddAccess().getRightMultParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Add_ELEMENT_TYPE = associate(AddFactory.createAddElementType());

	public static final IGrammarAwareElementType Add_Group_ELEMENT_TYPE = associate(AddFactory.createAdd_GroupElementType());

	public static final IGrammarAwareElementType Add_MultParserRuleCall_0_ELEMENT_TYPE = associate(AddFactory.createAdd_MultParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Add_Group_1_ELEMENT_TYPE = associate(AddFactory.createAdd_Group_1ElementType());

	public static final IGrammarAwareElementType Add_AddLeftAction_1_0_ELEMENT_TYPE = associate(AddFactory.createAdd_AddLeftAction_1_0ElementType());

	public static final IGrammarAwareElementType Add_PlusSignKeyword_1_1_ELEMENT_TYPE = associate(AddFactory.createAdd_PlusSignKeyword_1_1ElementType());

	public static final IGrammarAwareElementType Add_RightAssignment_1_2_ELEMENT_TYPE = associate(AddFactory.createAdd_RightAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Add_RightMultParserRuleCall_1_2_0_ELEMENT_TYPE = associate(AddFactory.createAdd_RightMultParserRuleCall_1_2_0ElementType());

	private static class MultFactory {
		public static IGrammarAwareElementType createMultElementType() {
			return new IGrammarAwareElementType("Mult_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultRule());
		}
		public static IGrammarAwareElementType createMult_GroupElementType() {
			return new IGrammarAwareElementType("Mult_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultAccess().getGroup());
		}
		public static IGrammarAwareElementType createMult_PrimParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Mult_PrimParserRuleCall_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultAccess().getPrimParserRuleCall_0());
		}
		public static IGrammarAwareElementType createMult_Group_1ElementType() {
			return new IGrammarAwareElementType("Mult_Group_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createMult_MultLeftAction_1_0ElementType() {
			return new IGrammarAwareElementType("Mult_MultLeftAction_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultAccess().getMultLeftAction_1_0());
		}
		public static IGrammarAwareElementType createMult_AsteriskKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("Mult_AsteriskKeyword_1_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultAccess().getAsteriskKeyword_1_1());
		}
		public static IGrammarAwareElementType createMult_RightAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Mult_RightAssignment_1_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultAccess().getRightAssignment_1_2());
		}
		public static IGrammarAwareElementType createMult_RightPrimParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Mult_RightPrimParserRuleCall_1_2_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultAccess().getRightPrimParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Mult_ELEMENT_TYPE = associate(MultFactory.createMultElementType());

	public static final IGrammarAwareElementType Mult_Group_ELEMENT_TYPE = associate(MultFactory.createMult_GroupElementType());

	public static final IGrammarAwareElementType Mult_PrimParserRuleCall_0_ELEMENT_TYPE = associate(MultFactory.createMult_PrimParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Mult_Group_1_ELEMENT_TYPE = associate(MultFactory.createMult_Group_1ElementType());

	public static final IGrammarAwareElementType Mult_MultLeftAction_1_0_ELEMENT_TYPE = associate(MultFactory.createMult_MultLeftAction_1_0ElementType());

	public static final IGrammarAwareElementType Mult_AsteriskKeyword_1_1_ELEMENT_TYPE = associate(MultFactory.createMult_AsteriskKeyword_1_1ElementType());

	public static final IGrammarAwareElementType Mult_RightAssignment_1_2_ELEMENT_TYPE = associate(MultFactory.createMult_RightAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Mult_RightPrimParserRuleCall_1_2_0_ELEMENT_TYPE = associate(MultFactory.createMult_RightPrimParserRuleCall_1_2_0ElementType());

	private static class PrimFactory {
		public static IGrammarAwareElementType createPrimElementType() {
			return new IGrammarAwareElementType("Prim_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimRule());
		}
		public static IGrammarAwareElementType createPrim_AlternativesElementType() {
			return new IGrammarAwareElementType("Prim_Alternatives_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createPrim_Group_0ElementType() {
			return new IGrammarAwareElementType("Prim_Group_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createPrim_ValueAction_0_0ElementType() {
			return new IGrammarAwareElementType("Prim_ValueAction_0_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getValueAction_0_0());
		}
		public static IGrammarAwareElementType createPrim_ValAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Prim_ValAssignment_0_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getValAssignment_0_1());
		}
		public static IGrammarAwareElementType createPrim_ValINTTerminalRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Prim_ValINTTerminalRuleCall_0_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getValINTTerminalRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createPrim_Group_1ElementType() {
			return new IGrammarAwareElementType("Prim_Group_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createPrim_FunctionAction_1_0ElementType() {
			return new IGrammarAwareElementType("Prim_FunctionAction_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getFunctionAction_1_0());
		}
		public static IGrammarAwareElementType createPrim_FuncAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Prim_FuncAssignment_1_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getFuncAssignment_1_1());
		}
		public static IGrammarAwareElementType createPrim_FuncIDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Prim_FuncIDTerminalRuleCall_1_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getFuncIDTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createPrim_LeftParenthesisKeyword_1_2ElementType() {
			return new IGrammarAwareElementType("Prim_LeftParenthesisKeyword_1_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getLeftParenthesisKeyword_1_2());
		}
		public static IGrammarAwareElementType createPrim_ParamAssignment_1_3ElementType() {
			return new IGrammarAwareElementType("Prim_ParamAssignment_1_3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getParamAssignment_1_3());
		}
		public static IGrammarAwareElementType createPrim_ParamAddParserRuleCall_1_3_0ElementType() {
			return new IGrammarAwareElementType("Prim_ParamAddParserRuleCall_1_3_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getParamAddParserRuleCall_1_3_0());
		}
		public static IGrammarAwareElementType createPrim_Group_1_4ElementType() {
			return new IGrammarAwareElementType("Prim_Group_1_4_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getGroup_1_4());
		}
		public static IGrammarAwareElementType createPrim_CommaKeyword_1_4_0ElementType() {
			return new IGrammarAwareElementType("Prim_CommaKeyword_1_4_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getCommaKeyword_1_4_0());
		}
		public static IGrammarAwareElementType createPrim_ParamAssignment_1_4_1ElementType() {
			return new IGrammarAwareElementType("Prim_ParamAssignment_1_4_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getParamAssignment_1_4_1());
		}
		public static IGrammarAwareElementType createPrim_ParamAddParserRuleCall_1_4_1_0ElementType() {
			return new IGrammarAwareElementType("Prim_ParamAddParserRuleCall_1_4_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getParamAddParserRuleCall_1_4_1_0());
		}
		public static IGrammarAwareElementType createPrim_RightParenthesisKeyword_1_5ElementType() {
			return new IGrammarAwareElementType("Prim_RightParenthesisKeyword_1_5_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getRightParenthesisKeyword_1_5());
		}
		public static IGrammarAwareElementType createPrim_Group_2ElementType() {
			return new IGrammarAwareElementType("Prim_Group_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createPrim_PointerAction_2_0ElementType() {
			return new IGrammarAwareElementType("Prim_PointerAction_2_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getPointerAction_2_0());
		}
		public static IGrammarAwareElementType createPrim_EqualsSignGreaterThanSignKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("Prim_EqualsSignGreaterThanSignKeyword_2_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getEqualsSignGreaterThanSignKeyword_2_1());
		}
		public static IGrammarAwareElementType createPrim_TargetAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("Prim_TargetAssignment_2_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getTargetAssignment_2_2());
		}
		public static IGrammarAwareElementType createPrim_TargetPrimParserRuleCall_2_2_0ElementType() {
			return new IGrammarAwareElementType("Prim_TargetPrimParserRuleCall_2_2_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getTargetPrimParserRuleCall_2_2_0());
		}
		public static IGrammarAwareElementType createPrim_Group_3ElementType() {
			return new IGrammarAwareElementType("Prim_Group_3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createPrim_LeftParenthesisKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Prim_LeftParenthesisKeyword_3_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getLeftParenthesisKeyword_3_0());
		}
		public static IGrammarAwareElementType createPrim_AddParserRuleCall_3_1ElementType() {
			return new IGrammarAwareElementType("Prim_AddParserRuleCall_3_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getAddParserRuleCall_3_1());
		}
		public static IGrammarAwareElementType createPrim_RightParenthesisKeyword_3_2ElementType() {
			return new IGrammarAwareElementType("Prim_RightParenthesisKeyword_3_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimAccess().getRightParenthesisKeyword_3_2());
		}
	}

	public static final IGrammarAwareElementType Prim_ELEMENT_TYPE = associate(PrimFactory.createPrimElementType());

	public static final IGrammarAwareElementType Prim_Alternatives_ELEMENT_TYPE = associate(PrimFactory.createPrim_AlternativesElementType());

	public static final IGrammarAwareElementType Prim_Group_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_Group_0ElementType());

	public static final IGrammarAwareElementType Prim_ValueAction_0_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_ValueAction_0_0ElementType());

	public static final IGrammarAwareElementType Prim_ValAssignment_0_1_ELEMENT_TYPE = associate(PrimFactory.createPrim_ValAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Prim_ValINTTerminalRuleCall_0_1_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_ValINTTerminalRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Prim_Group_1_ELEMENT_TYPE = associate(PrimFactory.createPrim_Group_1ElementType());

	public static final IGrammarAwareElementType Prim_FunctionAction_1_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_FunctionAction_1_0ElementType());

	public static final IGrammarAwareElementType Prim_FuncAssignment_1_1_ELEMENT_TYPE = associate(PrimFactory.createPrim_FuncAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Prim_FuncIDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_FuncIDTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Prim_LeftParenthesisKeyword_1_2_ELEMENT_TYPE = associate(PrimFactory.createPrim_LeftParenthesisKeyword_1_2ElementType());

	public static final IGrammarAwareElementType Prim_ParamAssignment_1_3_ELEMENT_TYPE = associate(PrimFactory.createPrim_ParamAssignment_1_3ElementType());

	public static final IGrammarAwareElementType Prim_ParamAddParserRuleCall_1_3_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_ParamAddParserRuleCall_1_3_0ElementType());

	public static final IGrammarAwareElementType Prim_Group_1_4_ELEMENT_TYPE = associate(PrimFactory.createPrim_Group_1_4ElementType());

	public static final IGrammarAwareElementType Prim_CommaKeyword_1_4_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_CommaKeyword_1_4_0ElementType());

	public static final IGrammarAwareElementType Prim_ParamAssignment_1_4_1_ELEMENT_TYPE = associate(PrimFactory.createPrim_ParamAssignment_1_4_1ElementType());

	public static final IGrammarAwareElementType Prim_ParamAddParserRuleCall_1_4_1_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_ParamAddParserRuleCall_1_4_1_0ElementType());

	public static final IGrammarAwareElementType Prim_RightParenthesisKeyword_1_5_ELEMENT_TYPE = associate(PrimFactory.createPrim_RightParenthesisKeyword_1_5ElementType());

	public static final IGrammarAwareElementType Prim_Group_2_ELEMENT_TYPE = associate(PrimFactory.createPrim_Group_2ElementType());

	public static final IGrammarAwareElementType Prim_PointerAction_2_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_PointerAction_2_0ElementType());

	public static final IGrammarAwareElementType Prim_EqualsSignGreaterThanSignKeyword_2_1_ELEMENT_TYPE = associate(PrimFactory.createPrim_EqualsSignGreaterThanSignKeyword_2_1ElementType());

	public static final IGrammarAwareElementType Prim_TargetAssignment_2_2_ELEMENT_TYPE = associate(PrimFactory.createPrim_TargetAssignment_2_2ElementType());

	public static final IGrammarAwareElementType Prim_TargetPrimParserRuleCall_2_2_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_TargetPrimParserRuleCall_2_2_0ElementType());

	public static final IGrammarAwareElementType Prim_Group_3_ELEMENT_TYPE = associate(PrimFactory.createPrim_Group_3ElementType());

	public static final IGrammarAwareElementType Prim_LeftParenthesisKeyword_3_0_ELEMENT_TYPE = associate(PrimFactory.createPrim_LeftParenthesisKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Prim_AddParserRuleCall_3_1_ELEMENT_TYPE = associate(PrimFactory.createPrim_AddParserRuleCall_3_1ElementType());

	public static final IGrammarAwareElementType Prim_RightParenthesisKeyword_3_2_ELEMENT_TYPE = associate(PrimFactory.createPrim_RightParenthesisKeyword_3_2ElementType());

	private static class RuleCalls12Factory {
		public static IGrammarAwareElementType createRuleCalls12ElementType() {
			return new IGrammarAwareElementType("RuleCalls12_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCalls12Rule());
		}
		public static IGrammarAwareElementType createRuleCalls12_GroupElementType() {
			return new IGrammarAwareElementType("RuleCalls12_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCalls12Access().getGroup());
		}
		public static IGrammarAwareElementType createRuleCalls12_NumberSignDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("RuleCalls12_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCalls12Access().getNumberSignDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createRuleCalls12_ConstructorAssignment_1ElementType() {
			return new IGrammarAwareElementType("RuleCalls12_ConstructorAssignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCalls12Access().getConstructorAssignment_1());
		}
		public static IGrammarAwareElementType createRuleCalls12_ConstructorConstructorParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCalls12_ConstructorConstructorParserRuleCall_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCalls12Access().getConstructorConstructorParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createRuleCalls12_FieldsAssignment_2ElementType() {
			return new IGrammarAwareElementType("RuleCalls12_FieldsAssignment_2_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCalls12Access().getFieldsAssignment_2());
		}
		public static IGrammarAwareElementType createRuleCalls12_FieldsFieldParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("RuleCalls12_FieldsFieldParserRuleCall_2_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCalls12Access().getFieldsFieldParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createRuleCalls12_Kw3Keyword_3ElementType() {
			return new IGrammarAwareElementType("RuleCalls12_Kw3Keyword_3_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCalls12Access().getKw3Keyword_3());
		}
	}

	public static final IGrammarAwareElementType RuleCalls12_ELEMENT_TYPE = associate(RuleCalls12Factory.createRuleCalls12ElementType());

	public static final IGrammarAwareElementType RuleCalls12_Group_ELEMENT_TYPE = associate(RuleCalls12Factory.createRuleCalls12_GroupElementType());

	public static final IGrammarAwareElementType RuleCalls12_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE = associate(RuleCalls12Factory.createRuleCalls12_NumberSignDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType RuleCalls12_ConstructorAssignment_1_ELEMENT_TYPE = associate(RuleCalls12Factory.createRuleCalls12_ConstructorAssignment_1ElementType());

	public static final IGrammarAwareElementType RuleCalls12_ConstructorConstructorParserRuleCall_1_0_ELEMENT_TYPE = associate(RuleCalls12Factory.createRuleCalls12_ConstructorConstructorParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType RuleCalls12_FieldsAssignment_2_ELEMENT_TYPE = associate(RuleCalls12Factory.createRuleCalls12_FieldsAssignment_2ElementType());

	public static final IGrammarAwareElementType RuleCalls12_FieldsFieldParserRuleCall_2_0_ELEMENT_TYPE = associate(RuleCalls12Factory.createRuleCalls12_FieldsFieldParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType RuleCalls12_Kw3Keyword_3_ELEMENT_TYPE = associate(RuleCalls12Factory.createRuleCalls12_Kw3Keyword_3ElementType());

	private static class ConstructorFactory {
		public static IGrammarAwareElementType createConstructorElementType() {
			return new IGrammarAwareElementType("Constructor_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConstructorRule());
		}
		public static IGrammarAwareElementType createConstructor_GroupElementType() {
			return new IGrammarAwareElementType("Constructor_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConstructorAccess().getGroup());
		}
		public static IGrammarAwareElementType createConstructor_ConstructorAction_0ElementType() {
			return new IGrammarAwareElementType("Constructor_ConstructorAction_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConstructorAccess().getConstructorAction_0());
		}
		public static IGrammarAwareElementType createConstructor_Kw1Assignment_1ElementType() {
			return new IGrammarAwareElementType("Constructor_Kw1Assignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConstructorAccess().getKw1Assignment_1());
		}
		public static IGrammarAwareElementType createConstructor_Kw1Kw1Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("Constructor_Kw1Kw1Keyword_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConstructorAccess().getKw1Kw1Keyword_1_0());
		}
	}

	public static final IGrammarAwareElementType Constructor_ELEMENT_TYPE = associate(ConstructorFactory.createConstructorElementType());

	public static final IGrammarAwareElementType Constructor_Group_ELEMENT_TYPE = associate(ConstructorFactory.createConstructor_GroupElementType());

	public static final IGrammarAwareElementType Constructor_ConstructorAction_0_ELEMENT_TYPE = associate(ConstructorFactory.createConstructor_ConstructorAction_0ElementType());

	public static final IGrammarAwareElementType Constructor_Kw1Assignment_1_ELEMENT_TYPE = associate(ConstructorFactory.createConstructor_Kw1Assignment_1ElementType());

	public static final IGrammarAwareElementType Constructor_Kw1Kw1Keyword_1_0_ELEMENT_TYPE = associate(ConstructorFactory.createConstructor_Kw1Kw1Keyword_1_0ElementType());

	private static class FieldFactory {
		public static IGrammarAwareElementType createFieldElementType() {
			return new IGrammarAwareElementType("Field_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFieldRule());
		}
		public static IGrammarAwareElementType createField_GroupElementType() {
			return new IGrammarAwareElementType("Field_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFieldAccess().getGroup());
		}
		public static IGrammarAwareElementType createField_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Field_IDTerminalRuleCall_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFieldAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createField_ParameterParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Field_ParameterParserRuleCall_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFieldAccess().getParameterParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Field_ELEMENT_TYPE = associate(FieldFactory.createFieldElementType());

	public static final IGrammarAwareElementType Field_Group_ELEMENT_TYPE = associate(FieldFactory.createField_GroupElementType());

	public static final IGrammarAwareElementType Field_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FieldFactory.createField_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType Field_ParameterParserRuleCall_1_ELEMENT_TYPE = associate(FieldFactory.createField_ParameterParserRuleCall_1ElementType());

	private static class ParameterFactory {
		public static IGrammarAwareElementType createParameterElementType() {
			return new IGrammarAwareElementType("Parameter_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterRule());
		}
		public static IGrammarAwareElementType createParameter_GroupElementType() {
			return new IGrammarAwareElementType("Parameter_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getGroup());
		}
		public static IGrammarAwareElementType createParameter_ParameterAction_0ElementType() {
			return new IGrammarAwareElementType("Parameter_ParameterAction_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getParameterAction_0());
		}
		public static IGrammarAwareElementType createParameter_Kw2Assignment_1ElementType() {
			return new IGrammarAwareElementType("Parameter_Kw2Assignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getKw2Assignment_1());
		}
		public static IGrammarAwareElementType createParameter_Kw2Kw2Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("Parameter_Kw2Kw2Keyword_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getKw2Kw2Keyword_1_0());
		}
	}

	public static final IGrammarAwareElementType Parameter_ELEMENT_TYPE = associate(ParameterFactory.createParameterElementType());

	public static final IGrammarAwareElementType Parameter_Group_ELEMENT_TYPE = associate(ParameterFactory.createParameter_GroupElementType());

	public static final IGrammarAwareElementType Parameter_ParameterAction_0_ELEMENT_TYPE = associate(ParameterFactory.createParameter_ParameterAction_0ElementType());

	public static final IGrammarAwareElementType Parameter_Kw2Assignment_1_ELEMENT_TYPE = associate(ParameterFactory.createParameter_Kw2Assignment_1ElementType());

	public static final IGrammarAwareElementType Parameter_Kw2Kw2Keyword_1_0_ELEMENT_TYPE = associate(ParameterFactory.createParameter_Kw2Kw2Keyword_1_0ElementType());

	private static class NestedStartFactory {
		public static IGrammarAwareElementType createNestedStartElementType() {
			return new IGrammarAwareElementType("NestedStart_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedStartRule());
		}
		public static IGrammarAwareElementType createNestedStart_GroupElementType() {
			return new IGrammarAwareElementType("NestedStart_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedStartAccess().getGroup());
		}
		public static IGrammarAwareElementType createNestedStart_NestedStartSubParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("NestedStart_NestedStartSubParserRuleCall_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedStartAccess().getNestedStartSubParserRuleCall_0());
		}
		public static IGrammarAwareElementType createNestedStart_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("NestedStart_NameAssignment_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedStartAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createNestedStart_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NestedStart_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedStartAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType NestedStart_ELEMENT_TYPE = associate(NestedStartFactory.createNestedStartElementType());

	public static final IGrammarAwareElementType NestedStart_Group_ELEMENT_TYPE = associate(NestedStartFactory.createNestedStart_GroupElementType());

	public static final IGrammarAwareElementType NestedStart_NestedStartSubParserRuleCall_0_ELEMENT_TYPE = associate(NestedStartFactory.createNestedStart_NestedStartSubParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType NestedStart_NameAssignment_1_ELEMENT_TYPE = associate(NestedStartFactory.createNestedStart_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType NestedStart_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(NestedStartFactory.createNestedStart_NameIDTerminalRuleCall_1_0ElementType());

	private static class NestedStartSubFactory {
		public static IGrammarAwareElementType createNestedStartSubElementType() {
			return new IGrammarAwareElementType("NestedStartSub_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedStartSubRule());
		}
		public static IGrammarAwareElementType createNestedStartSub_GroupElementType() {
			return new IGrammarAwareElementType("NestedStartSub_Group_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedStartSubAccess().getGroup());
		}
		public static IGrammarAwareElementType createNestedStartSub_NumberSignDigitEightKeyword_0ElementType() {
			return new IGrammarAwareElementType("NestedStartSub_NumberSignDigitEightKeyword_0_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedStartSubAccess().getNumberSignDigitEightKeyword_0());
		}
		public static IGrammarAwareElementType createNestedStartSub_NestedStartSubAction_1ElementType() {
			return new IGrammarAwareElementType("NestedStartSub_NestedStartSubAction_1_ELEMENT_TYPE", ElementMatcherTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedStartSubAccess().getNestedStartSubAction_1());
		}
	}

	public static final IGrammarAwareElementType NestedStartSub_ELEMENT_TYPE = associate(NestedStartSubFactory.createNestedStartSubElementType());

	public static final IGrammarAwareElementType NestedStartSub_Group_ELEMENT_TYPE = associate(NestedStartSubFactory.createNestedStartSub_GroupElementType());

	public static final IGrammarAwareElementType NestedStartSub_NumberSignDigitEightKeyword_0_ELEMENT_TYPE = associate(NestedStartSubFactory.createNestedStartSub_NumberSignDigitEightKeyword_0ElementType());

	public static final IGrammarAwareElementType NestedStartSub_NestedStartSubAction_1_ELEMENT_TYPE = associate(NestedStartSubFactory.createNestedStartSub_NestedStartSubAction_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getModelElementType() {
		return Model_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AlternativesElementType() {
		return Model_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SimpleParserRuleCall_0ElementType() {
		return Model_SimpleParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RuleCallsParserRuleCall_1ElementType() {
		return Model_RuleCallsParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_OptionalCallsParserRuleCall_2ElementType() {
		return Model_OptionalCallsParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RecursionParserRuleCall_3ElementType() {
		return Model_RecursionParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_LoopParserRuleCall_4ElementType() {
		return Model_LoopParserRuleCall_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ExpressionParserRuleCall_5ElementType() {
		return Model_ExpressionParserRuleCall_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RuleCalls12ParserRuleCall_6ElementType() {
		return Model_RuleCalls12ParserRuleCall_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedStartParserRuleCall_7ElementType() {
		return Model_NestedStartParserRuleCall_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleElementType() {
		return Simple_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_GroupElementType() {
		return Simple_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_NumberSignDigitOneKeyword_0ElementType() {
		return Simple_NumberSignDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_NameAssignment_1ElementType() {
		return Simple_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_NameIDTerminalRuleCall_1_0ElementType() {
		return Simple_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_Group_2ElementType() {
		return Simple_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_Kw1Keyword_2_0ElementType() {
		return Simple_Kw1Keyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_OptionalAssignment_2_1ElementType() {
		return Simple_OptionalAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_OptionalIDTerminalRuleCall_2_1_0ElementType() {
		return Simple_OptionalIDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_DatatypeAssignment_3ElementType() {
		return Simple_DatatypeAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_DatatypeFQNParserRuleCall_3_0ElementType() {
		return Simple_DatatypeFQNParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQNElementType() {
		return FQN_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_GroupElementType() {
		return FQN_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_IDTerminalRuleCall_0ElementType() {
		return FQN_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_Group_1ElementType() {
		return FQN_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_FullStopKeyword_1_0ElementType() {
		return FQN_FullStopKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_IDTerminalRuleCall_1_1ElementType() {
		return FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsElementType() {
		return RuleCalls_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls_GroupElementType() {
		return RuleCalls_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls_NumberSignDigitTwoKeyword_0ElementType() {
		return RuleCalls_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls_RuleCallsSubParserRuleCall_1ElementType() {
		return RuleCalls_RuleCallsSubParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls_NameAssignment_2ElementType() {
		return RuleCalls_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls_NameIDTerminalRuleCall_2_0ElementType() {
		return RuleCalls_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls_Call1Assignment_3ElementType() {
		return RuleCalls_Call1Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls_Call1RuleCallsAss1ParserRuleCall_3_0ElementType() {
		return RuleCalls_Call1RuleCallsAss1ParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls_Call2Assignment_4ElementType() {
		return RuleCalls_Call2Assignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls_Call2RuleCallsAss2ParserRuleCall_4_0ElementType() {
		return RuleCalls_Call2RuleCallsAss2ParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsSubElementType() {
		return RuleCallsSub_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsSub_SubAssignmentElementType() {
		return RuleCallsSub_SubAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsSub_SubSubKeyword_0ElementType() {
		return RuleCallsSub_SubSubKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsAss1ElementType() {
		return RuleCallsAss1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsAss1_GroupElementType() {
		return RuleCallsAss1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsAss1_Ass1Keyword_0ElementType() {
		return RuleCallsAss1_Ass1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsAss1_NameAssignment_1ElementType() {
		return RuleCallsAss1_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsAss1_NameIDTerminalRuleCall_1_0ElementType() {
		return RuleCallsAss1_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsAss2ElementType() {
		return RuleCallsAss2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsAss2_GroupElementType() {
		return RuleCallsAss2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsAss2_Ass2Keyword_0ElementType() {
		return RuleCallsAss2_Ass2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsAss2_NameAssignment_1ElementType() {
		return RuleCallsAss2_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallsAss2_NameIDTerminalRuleCall_1_0ElementType() {
		return RuleCallsAss2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsElementType() {
		return OptionalCalls_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCalls_GroupElementType() {
		return OptionalCalls_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCalls_NumberSignDigitThreeKeyword_0ElementType() {
		return OptionalCalls_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCalls_OptionalCallsAction_1ElementType() {
		return OptionalCalls_OptionalCallsAction_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCalls_Opt1Assignment_2ElementType() {
		return OptionalCalls_Opt1Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCalls_Opt1OptionalCallsSub1ParserRuleCall_2_0ElementType() {
		return OptionalCalls_Opt1OptionalCallsSub1ParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCalls_NameAssignment_3ElementType() {
		return OptionalCalls_NameAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCalls_NameIDTerminalRuleCall_3_0ElementType() {
		return OptionalCalls_NameIDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub1ElementType() {
		return OptionalCallsSub1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub1_GroupElementType() {
		return OptionalCallsSub1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub1_OptionalCallsSub1Action_0ElementType() {
		return OptionalCallsSub1_OptionalCallsSub1Action_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub1_Opt2Assignment_1ElementType() {
		return OptionalCallsSub1_Opt2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub1_Opt2OptionalCallsSub2ParserRuleCall_1_0ElementType() {
		return OptionalCallsSub1_Opt2OptionalCallsSub2ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub1_SubKeyword_2ElementType() {
		return OptionalCallsSub1_SubKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub1_Opt3Assignment_3ElementType() {
		return OptionalCallsSub1_Opt3Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub1_Opt3OptionalCallsSub3ParserRuleCall_3_0ElementType() {
		return OptionalCallsSub1_Opt3OptionalCallsSub3ParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub2ElementType() {
		return OptionalCallsSub2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub2_GroupElementType() {
		return OptionalCallsSub2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub2_Sub2Keyword_0ElementType() {
		return OptionalCallsSub2_Sub2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub2_NameAssignment_1ElementType() {
		return OptionalCallsSub2_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub2_NameIDTerminalRuleCall_1_0ElementType() {
		return OptionalCallsSub2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub3ElementType() {
		return OptionalCallsSub3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub3_GroupElementType() {
		return OptionalCallsSub3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub3_Sub3Keyword_0ElementType() {
		return OptionalCallsSub3_Sub3Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub3_NameAssignment_1ElementType() {
		return OptionalCallsSub3_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalCallsSub3_NameIDTerminalRuleCall_1_0ElementType() {
		return OptionalCallsSub3_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionElementType() {
		return Recursion_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursion_GroupElementType() {
		return Recursion_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursion_NumberSignDigitFourKeyword_0ElementType() {
		return Recursion_NumberSignDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursion_RecursionSubParserRuleCall_1ElementType() {
		return Recursion_RecursionSubParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSubElementType() {
		return RecursionSub_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_GroupElementType() {
		return RecursionSub_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_RecursionSubAction_0ElementType() {
		return RecursionSub_RecursionSubAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_LeftCurlyBracketKeyword_1ElementType() {
		return RecursionSub_LeftCurlyBracketKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_Alternatives_2ElementType() {
		return RecursionSub_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_SubAssignment_2_0ElementType() {
		return RecursionSub_SubAssignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_SubRecursionSubParserRuleCall_2_0_0ElementType() {
		return RecursionSub_SubRecursionSubParserRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_ValsAssignment_2_1ElementType() {
		return RecursionSub_ValsAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_ValsIDTerminalRuleCall_2_1_0ElementType() {
		return RecursionSub_ValsIDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_RightCurlyBracketKeyword_3ElementType() {
		return RecursionSub_RightCurlyBracketKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_SemiAssignment_4ElementType() {
		return RecursionSub_SemiAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursionSub_SemiSemicolonKeyword_4_0ElementType() {
		return RecursionSub_SemiSemicolonKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoopElementType() {
		return Loop_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_GroupElementType() {
		return Loop_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_NumberSignDigitFiveKeyword_0ElementType() {
		return Loop_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_NamesAssignment_1ElementType() {
		return Loop_NamesAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_NamesIDTerminalRuleCall_1_0ElementType() {
		return Loop_NamesIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_Group_2ElementType() {
		return Loop_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_GrKeyword_2_0ElementType() {
		return Loop_GrKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_GrAssignment_2_1ElementType() {
		return Loop_GrAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_GrIDTerminalRuleCall_2_1_0ElementType() {
		return Loop_GrIDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_Alternatives_3ElementType() {
		return Loop_Alternatives_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_IntsAssignment_3_0ElementType() {
		return Loop_IntsAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_IntsINTTerminalRuleCall_3_0_0ElementType() {
		return Loop_IntsINTTerminalRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_StringsAssignment_3_1ElementType() {
		return Loop_StringsAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop_StringsSTRINGTerminalRuleCall_3_1_0ElementType() {
		return Loop_StringsSTRINGTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpressionElementType() {
		return Expression_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_GroupElementType() {
		return Expression_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_NumberSignDigitSixKeyword_0ElementType() {
		return Expression_NumberSignDigitSixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_AddParserRuleCall_1ElementType() {
		return Expression_AddParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddElementType() {
		return Add_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAdd_GroupElementType() {
		return Add_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAdd_MultParserRuleCall_0ElementType() {
		return Add_MultParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAdd_Group_1ElementType() {
		return Add_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAdd_AddLeftAction_1_0ElementType() {
		return Add_AddLeftAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAdd_PlusSignKeyword_1_1ElementType() {
		return Add_PlusSignKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAdd_RightAssignment_1_2ElementType() {
		return Add_RightAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAdd_RightMultParserRuleCall_1_2_0ElementType() {
		return Add_RightMultParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultElementType() {
		return Mult_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMult_GroupElementType() {
		return Mult_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMult_PrimParserRuleCall_0ElementType() {
		return Mult_PrimParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMult_Group_1ElementType() {
		return Mult_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMult_MultLeftAction_1_0ElementType() {
		return Mult_MultLeftAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMult_AsteriskKeyword_1_1ElementType() {
		return Mult_AsteriskKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMult_RightAssignment_1_2ElementType() {
		return Mult_RightAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMult_RightPrimParserRuleCall_1_2_0ElementType() {
		return Mult_RightPrimParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrimElementType() {
		return Prim_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_AlternativesElementType() {
		return Prim_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_Group_0ElementType() {
		return Prim_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_ValueAction_0_0ElementType() {
		return Prim_ValueAction_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_ValAssignment_0_1ElementType() {
		return Prim_ValAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_ValINTTerminalRuleCall_0_1_0ElementType() {
		return Prim_ValINTTerminalRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_Group_1ElementType() {
		return Prim_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_FunctionAction_1_0ElementType() {
		return Prim_FunctionAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_FuncAssignment_1_1ElementType() {
		return Prim_FuncAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_FuncIDTerminalRuleCall_1_1_0ElementType() {
		return Prim_FuncIDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_LeftParenthesisKeyword_1_2ElementType() {
		return Prim_LeftParenthesisKeyword_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_ParamAssignment_1_3ElementType() {
		return Prim_ParamAssignment_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_ParamAddParserRuleCall_1_3_0ElementType() {
		return Prim_ParamAddParserRuleCall_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_Group_1_4ElementType() {
		return Prim_Group_1_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_CommaKeyword_1_4_0ElementType() {
		return Prim_CommaKeyword_1_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_ParamAssignment_1_4_1ElementType() {
		return Prim_ParamAssignment_1_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_ParamAddParserRuleCall_1_4_1_0ElementType() {
		return Prim_ParamAddParserRuleCall_1_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_RightParenthesisKeyword_1_5ElementType() {
		return Prim_RightParenthesisKeyword_1_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_Group_2ElementType() {
		return Prim_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_PointerAction_2_0ElementType() {
		return Prim_PointerAction_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_EqualsSignGreaterThanSignKeyword_2_1ElementType() {
		return Prim_EqualsSignGreaterThanSignKeyword_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_TargetAssignment_2_2ElementType() {
		return Prim_TargetAssignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_TargetPrimParserRuleCall_2_2_0ElementType() {
		return Prim_TargetPrimParserRuleCall_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_Group_3ElementType() {
		return Prim_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_LeftParenthesisKeyword_3_0ElementType() {
		return Prim_LeftParenthesisKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_AddParserRuleCall_3_1ElementType() {
		return Prim_AddParserRuleCall_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim_RightParenthesisKeyword_3_2ElementType() {
		return Prim_RightParenthesisKeyword_3_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls12ElementType() {
		return RuleCalls12_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls12_GroupElementType() {
		return RuleCalls12_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls12_NumberSignDigitSevenKeyword_0ElementType() {
		return RuleCalls12_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls12_ConstructorAssignment_1ElementType() {
		return RuleCalls12_ConstructorAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls12_ConstructorConstructorParserRuleCall_1_0ElementType() {
		return RuleCalls12_ConstructorConstructorParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls12_FieldsAssignment_2ElementType() {
		return RuleCalls12_FieldsAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls12_FieldsFieldParserRuleCall_2_0ElementType() {
		return RuleCalls12_FieldsFieldParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCalls12_Kw3Keyword_3ElementType() {
		return RuleCalls12_Kw3Keyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConstructorElementType() {
		return Constructor_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConstructor_GroupElementType() {
		return Constructor_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConstructor_ConstructorAction_0ElementType() {
		return Constructor_ConstructorAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConstructor_Kw1Assignment_1ElementType() {
		return Constructor_Kw1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConstructor_Kw1Kw1Keyword_1_0ElementType() {
		return Constructor_Kw1Kw1Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFieldElementType() {
		return Field_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getField_GroupElementType() {
		return Field_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getField_IDTerminalRuleCall_0ElementType() {
		return Field_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getField_ParameterParserRuleCall_1ElementType() {
		return Field_ParameterParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterElementType() {
		return Parameter_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_GroupElementType() {
		return Parameter_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_ParameterAction_0ElementType() {
		return Parameter_ParameterAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_Kw2Assignment_1ElementType() {
		return Parameter_Kw2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_Kw2Kw2Keyword_1_0ElementType() {
		return Parameter_Kw2Kw2Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedStartElementType() {
		return NestedStart_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedStart_GroupElementType() {
		return NestedStart_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedStart_NestedStartSubParserRuleCall_0ElementType() {
		return NestedStart_NestedStartSubParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedStart_NameAssignment_1ElementType() {
		return NestedStart_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedStart_NameIDTerminalRuleCall_1_0ElementType() {
		return NestedStart_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedStartSubElementType() {
		return NestedStartSub_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedStartSub_GroupElementType() {
		return NestedStartSub_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedStartSub_NumberSignDigitEightKeyword_0ElementType() {
		return NestedStartSub_NumberSignDigitEightKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedStartSub_NestedStartSubAction_1ElementType() {
		return NestedStartSub_NestedStartSubAction_1_ELEMENT_TYPE;
	}

}
