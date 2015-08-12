package org.eclipse.xtext.serializer.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.serializer.idea.lang.psi.impl.SyntacticSequencerTestLanguageFileImpl;
import org.eclipse.xtext.serializer.services.SyntacticSequencerTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class SyntacticSequencerTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<SyntacticSequencerTestLanguageFileImpl>>(SyntacticSequencerTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final SyntacticSequencerTestLanguageGrammarAccess GRAMMAR_ACCESS = SyntacticSequencerTestLanguageLanguage.INSTANCE.getInstance(SyntacticSequencerTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_X1Assignment_0ElementType() {
			return new IGrammarAwareElementType("Model_X1Assignment_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX1Assignment_0());
		}
		public static IGrammarAwareElementType createModel_X1MandatoryKeywordsParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_X1MandatoryKeywordsParserRuleCall_0_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX1MandatoryKeywordsParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_X2Assignment_1ElementType() {
			return new IGrammarAwareElementType("Model_X2Assignment_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX2Assignment_1());
		}
		public static IGrammarAwareElementType createModel_X2Exp0ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_X2Exp0ParserRuleCall_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX2Exp0ParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModel_X3Assignment_2ElementType() {
			return new IGrammarAwareElementType("Model_X3Assignment_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX3Assignment_2());
		}
		public static IGrammarAwareElementType createModel_X3Exp1ParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Model_X3Exp1ParserRuleCall_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX3Exp1ParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createModel_X4Assignment_3ElementType() {
			return new IGrammarAwareElementType("Model_X4Assignment_3_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX4Assignment_3());
		}
		public static IGrammarAwareElementType createModel_X4Exp2ParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Model_X4Exp2ParserRuleCall_3_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX4Exp2ParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createModel_X5Assignment_4ElementType() {
			return new IGrammarAwareElementType("Model_X5Assignment_4_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX5Assignment_4());
		}
		public static IGrammarAwareElementType createModel_X5SingleCrossReferenceParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Model_X5SingleCrossReferenceParserRuleCall_4_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX5SingleCrossReferenceParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createModel_X6Assignment_5ElementType() {
			return new IGrammarAwareElementType("Model_X6Assignment_5_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX6Assignment_5());
		}
		public static IGrammarAwareElementType createModel_X6BooleanAlternativeParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("Model_X6BooleanAlternativeParserRuleCall_5_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX6BooleanAlternativeParserRuleCall_5_0());
		}
		public static IGrammarAwareElementType createModel_X7Assignment_6ElementType() {
			return new IGrammarAwareElementType("Model_X7Assignment_6_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX7Assignment_6());
		}
		public static IGrammarAwareElementType createModel_X7UnassignedDatatypeParserRuleCall_6_0ElementType() {
			return new IGrammarAwareElementType("Model_X7UnassignedDatatypeParserRuleCall_6_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX7UnassignedDatatypeParserRuleCall_6_0());
		}
		public static IGrammarAwareElementType createModel_X8Assignment_7ElementType() {
			return new IGrammarAwareElementType("Model_X8Assignment_7_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX8Assignment_7());
		}
		public static IGrammarAwareElementType createModel_X8OptionalSingleTransitionParserRuleCall_7_0ElementType() {
			return new IGrammarAwareElementType("Model_X8OptionalSingleTransitionParserRuleCall_7_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX8OptionalSingleTransitionParserRuleCall_7_0());
		}
		public static IGrammarAwareElementType createModel_X9Assignment_8ElementType() {
			return new IGrammarAwareElementType("Model_X9Assignment_8_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX9Assignment_8());
		}
		public static IGrammarAwareElementType createModel_X9OptionalManyTransitionParserRuleCall_8_0ElementType() {
			return new IGrammarAwareElementType("Model_X9OptionalManyTransitionParserRuleCall_8_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX9OptionalManyTransitionParserRuleCall_8_0());
		}
		public static IGrammarAwareElementType createModel_X10Assignment_9ElementType() {
			return new IGrammarAwareElementType("Model_X10Assignment_9_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX10Assignment_9());
		}
		public static IGrammarAwareElementType createModel_X10MandatoryManyTransitionParserRuleCall_9_0ElementType() {
			return new IGrammarAwareElementType("Model_X10MandatoryManyTransitionParserRuleCall_9_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX10MandatoryManyTransitionParserRuleCall_9_0());
		}
		public static IGrammarAwareElementType createModel_X11Assignment_10ElementType() {
			return new IGrammarAwareElementType("Model_X11Assignment_10_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX11Assignment_10());
		}
		public static IGrammarAwareElementType createModel_X11AlternativeTransitionParserRuleCall_10_0ElementType() {
			return new IGrammarAwareElementType("Model_X11AlternativeTransitionParserRuleCall_10_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX11AlternativeTransitionParserRuleCall_10_0());
		}
		public static IGrammarAwareElementType createModel_X12Assignment_11ElementType() {
			return new IGrammarAwareElementType("Model_X12Assignment_11_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX12Assignment_11());
		}
		public static IGrammarAwareElementType createModel_X12BooleanValuesParserRuleCall_11_0ElementType() {
			return new IGrammarAwareElementType("Model_X12BooleanValuesParserRuleCall_11_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX12BooleanValuesParserRuleCall_11_0());
		}
		public static IGrammarAwareElementType createModel_X13Assignment_12ElementType() {
			return new IGrammarAwareElementType("Model_X13Assignment_12_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX13Assignment_12());
		}
		public static IGrammarAwareElementType createModel_X13LongAlternativeParserRuleCall_12_0ElementType() {
			return new IGrammarAwareElementType("Model_X13LongAlternativeParserRuleCall_12_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX13LongAlternativeParserRuleCall_12_0());
		}
		public static IGrammarAwareElementType createModel_X14Assignment_13ElementType() {
			return new IGrammarAwareElementType("Model_X14Assignment_13_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX14Assignment_13());
		}
		public static IGrammarAwareElementType createModel_X14ActionOnlyParserRuleCall_13_0ElementType() {
			return new IGrammarAwareElementType("Model_X14ActionOnlyParserRuleCall_13_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX14ActionOnlyParserRuleCall_13_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_X1Assignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X1Assignment_0ElementType());

	public static final IGrammarAwareElementType Model_X1MandatoryKeywordsParserRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X1MandatoryKeywordsParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_X2Assignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_X2Assignment_1ElementType());

	public static final IGrammarAwareElementType Model_X2Exp0ParserRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X2Exp0ParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Model_X3Assignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_X3Assignment_2ElementType());

	public static final IGrammarAwareElementType Model_X3Exp1ParserRuleCall_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X3Exp1ParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Model_X4Assignment_3_ELEMENT_TYPE = associate(ModelFactory.createModel_X4Assignment_3ElementType());

	public static final IGrammarAwareElementType Model_X4Exp2ParserRuleCall_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X4Exp2ParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Model_X5Assignment_4_ELEMENT_TYPE = associate(ModelFactory.createModel_X5Assignment_4ElementType());

	public static final IGrammarAwareElementType Model_X5SingleCrossReferenceParserRuleCall_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X5SingleCrossReferenceParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Model_X6Assignment_5_ELEMENT_TYPE = associate(ModelFactory.createModel_X6Assignment_5ElementType());

	public static final IGrammarAwareElementType Model_X6BooleanAlternativeParserRuleCall_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X6BooleanAlternativeParserRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType Model_X7Assignment_6_ELEMENT_TYPE = associate(ModelFactory.createModel_X7Assignment_6ElementType());

	public static final IGrammarAwareElementType Model_X7UnassignedDatatypeParserRuleCall_6_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X7UnassignedDatatypeParserRuleCall_6_0ElementType());

	public static final IGrammarAwareElementType Model_X8Assignment_7_ELEMENT_TYPE = associate(ModelFactory.createModel_X8Assignment_7ElementType());

	public static final IGrammarAwareElementType Model_X8OptionalSingleTransitionParserRuleCall_7_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X8OptionalSingleTransitionParserRuleCall_7_0ElementType());

	public static final IGrammarAwareElementType Model_X9Assignment_8_ELEMENT_TYPE = associate(ModelFactory.createModel_X9Assignment_8ElementType());

	public static final IGrammarAwareElementType Model_X9OptionalManyTransitionParserRuleCall_8_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X9OptionalManyTransitionParserRuleCall_8_0ElementType());

	public static final IGrammarAwareElementType Model_X10Assignment_9_ELEMENT_TYPE = associate(ModelFactory.createModel_X10Assignment_9ElementType());

	public static final IGrammarAwareElementType Model_X10MandatoryManyTransitionParserRuleCall_9_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X10MandatoryManyTransitionParserRuleCall_9_0ElementType());

	public static final IGrammarAwareElementType Model_X11Assignment_10_ELEMENT_TYPE = associate(ModelFactory.createModel_X11Assignment_10ElementType());

	public static final IGrammarAwareElementType Model_X11AlternativeTransitionParserRuleCall_10_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X11AlternativeTransitionParserRuleCall_10_0ElementType());

	public static final IGrammarAwareElementType Model_X12Assignment_11_ELEMENT_TYPE = associate(ModelFactory.createModel_X12Assignment_11ElementType());

	public static final IGrammarAwareElementType Model_X12BooleanValuesParserRuleCall_11_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X12BooleanValuesParserRuleCall_11_0ElementType());

	public static final IGrammarAwareElementType Model_X13Assignment_12_ELEMENT_TYPE = associate(ModelFactory.createModel_X13Assignment_12ElementType());

	public static final IGrammarAwareElementType Model_X13LongAlternativeParserRuleCall_12_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X13LongAlternativeParserRuleCall_12_0ElementType());

	public static final IGrammarAwareElementType Model_X14Assignment_13_ELEMENT_TYPE = associate(ModelFactory.createModel_X14Assignment_13ElementType());

	public static final IGrammarAwareElementType Model_X14ActionOnlyParserRuleCall_13_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X14ActionOnlyParserRuleCall_13_0ElementType());

	private static class MandatoryKeywordsFactory {
		public static IGrammarAwareElementType createMandatoryKeywordsElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsRule());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_GroupElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getGroup());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_NumberSignDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_NumberSignDigitOneKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getNumberSignDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Val1Assignment_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_Kw1Keyword_2ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Kw1Keyword_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getKw1Keyword_2());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_Val2Assignment_3ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Val2Assignment_3_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getVal2Assignment_3());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_Val2IDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getVal2IDTerminalRuleCall_3_0());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_Kw2Keyword_4ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Kw2Keyword_4_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getKw2Keyword_4());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_Kw3Keyword_5ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Kw3Keyword_5_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getKw3Keyword_5());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_Val3Assignment_6ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Val3Assignment_6_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getVal3Assignment_6());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_Val3IDTerminalRuleCall_6_0ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Val3IDTerminalRuleCall_6_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getVal3IDTerminalRuleCall_6_0());
		}
		public static IGrammarAwareElementType createMandatoryKeywords_Kw4Keyword_7ElementType() {
			return new IGrammarAwareElementType("MandatoryKeywords_Kw4Keyword_7_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryKeywordsAccess().getKw4Keyword_7());
		}
	}

	public static final IGrammarAwareElementType MandatoryKeywords_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywordsElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Group_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_GroupElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_NumberSignDigitOneKeyword_0_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_NumberSignDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Val1Assignment_1_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Kw1Keyword_2_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_Kw1Keyword_2ElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Val2Assignment_3_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_Val2Assignment_3ElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_Val2IDTerminalRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Kw2Keyword_4_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_Kw2Keyword_4ElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Kw3Keyword_5_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_Kw3Keyword_5ElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Val3Assignment_6_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_Val3Assignment_6ElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Val3IDTerminalRuleCall_6_0_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_Val3IDTerminalRuleCall_6_0ElementType());

	public static final IGrammarAwareElementType MandatoryKeywords_Kw4Keyword_7_ELEMENT_TYPE = associate(MandatoryKeywordsFactory.createMandatoryKeywords_Kw4Keyword_7ElementType());

	private static class Exp0Factory {
		public static IGrammarAwareElementType createExp0ElementType() {
			return new IGrammarAwareElementType("Exp0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp0Rule());
		}
		public static IGrammarAwareElementType createExp0_GroupElementType() {
			return new IGrammarAwareElementType("Exp0_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp0Access().getGroup());
		}
		public static IGrammarAwareElementType createExp0_NumberSignDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("Exp0_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp0Access().getNumberSignDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createExp0_Addition0ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Exp0_Addition0ParserRuleCall_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp0Access().getAddition0ParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Exp0_ELEMENT_TYPE = associate(Exp0Factory.createExp0ElementType());

	public static final IGrammarAwareElementType Exp0_Group_ELEMENT_TYPE = associate(Exp0Factory.createExp0_GroupElementType());

	public static final IGrammarAwareElementType Exp0_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE = associate(Exp0Factory.createExp0_NumberSignDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType Exp0_Addition0ParserRuleCall_1_ELEMENT_TYPE = associate(Exp0Factory.createExp0_Addition0ParserRuleCall_1ElementType());

	private static class Addition0Factory {
		public static IGrammarAwareElementType createAddition0ElementType() {
			return new IGrammarAwareElementType("Addition0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition0Rule());
		}
		public static IGrammarAwareElementType createAddition0_GroupElementType() {
			return new IGrammarAwareElementType("Addition0_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition0Access().getGroup());
		}
		public static IGrammarAwareElementType createAddition0_Prim0ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Addition0_Prim0ParserRuleCall_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition0Access().getPrim0ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAddition0_Group_1ElementType() {
			return new IGrammarAwareElementType("Addition0_Group_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition0Access().getGroup_1());
		}
		public static IGrammarAwareElementType createAddition0_Add0LeftAction_1_0ElementType() {
			return new IGrammarAwareElementType("Addition0_Add0LeftAction_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition0Access().getAdd0LeftAction_1_0());
		}
		public static IGrammarAwareElementType createAddition0_PlusSignKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("Addition0_PlusSignKeyword_1_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition0Access().getPlusSignKeyword_1_1());
		}
		public static IGrammarAwareElementType createAddition0_RightAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Addition0_RightAssignment_1_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition0Access().getRightAssignment_1_2());
		}
		public static IGrammarAwareElementType createAddition0_RightPrim0ParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Addition0_RightPrim0ParserRuleCall_1_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition0Access().getRightPrim0ParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Addition0_ELEMENT_TYPE = associate(Addition0Factory.createAddition0ElementType());

	public static final IGrammarAwareElementType Addition0_Group_ELEMENT_TYPE = associate(Addition0Factory.createAddition0_GroupElementType());

	public static final IGrammarAwareElementType Addition0_Prim0ParserRuleCall_0_ELEMENT_TYPE = associate(Addition0Factory.createAddition0_Prim0ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Addition0_Group_1_ELEMENT_TYPE = associate(Addition0Factory.createAddition0_Group_1ElementType());

	public static final IGrammarAwareElementType Addition0_Add0LeftAction_1_0_ELEMENT_TYPE = associate(Addition0Factory.createAddition0_Add0LeftAction_1_0ElementType());

	public static final IGrammarAwareElementType Addition0_PlusSignKeyword_1_1_ELEMENT_TYPE = associate(Addition0Factory.createAddition0_PlusSignKeyword_1_1ElementType());

	public static final IGrammarAwareElementType Addition0_RightAssignment_1_2_ELEMENT_TYPE = associate(Addition0Factory.createAddition0_RightAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Addition0_RightPrim0ParserRuleCall_1_2_0_ELEMENT_TYPE = associate(Addition0Factory.createAddition0_RightPrim0ParserRuleCall_1_2_0ElementType());

	private static class Prim0Factory {
		public static IGrammarAwareElementType createPrim0ElementType() {
			return new IGrammarAwareElementType("Prim0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim0Rule());
		}
		public static IGrammarAwareElementType createPrim0_GroupElementType() {
			return new IGrammarAwareElementType("Prim0_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim0Access().getGroup());
		}
		public static IGrammarAwareElementType createPrim0_Val0Action_0ElementType() {
			return new IGrammarAwareElementType("Prim0_Val0Action_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim0Access().getVal0Action_0());
		}
		public static IGrammarAwareElementType createPrim0_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Prim0_NameAssignment_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim0Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createPrim0_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Prim0_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim0Access().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Prim0_ELEMENT_TYPE = associate(Prim0Factory.createPrim0ElementType());

	public static final IGrammarAwareElementType Prim0_Group_ELEMENT_TYPE = associate(Prim0Factory.createPrim0_GroupElementType());

	public static final IGrammarAwareElementType Prim0_Val0Action_0_ELEMENT_TYPE = associate(Prim0Factory.createPrim0_Val0Action_0ElementType());

	public static final IGrammarAwareElementType Prim0_NameAssignment_1_ELEMENT_TYPE = associate(Prim0Factory.createPrim0_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Prim0_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Prim0Factory.createPrim0_NameIDTerminalRuleCall_1_0ElementType());

	private static class Exp1Factory {
		public static IGrammarAwareElementType createExp1ElementType() {
			return new IGrammarAwareElementType("Exp1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp1Rule());
		}
		public static IGrammarAwareElementType createExp1_GroupElementType() {
			return new IGrammarAwareElementType("Exp1_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp1Access().getGroup());
		}
		public static IGrammarAwareElementType createExp1_NumberSignDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Exp1_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp1Access().getNumberSignDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createExp1_Addition1ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Exp1_Addition1ParserRuleCall_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp1Access().getAddition1ParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Exp1_ELEMENT_TYPE = associate(Exp1Factory.createExp1ElementType());

	public static final IGrammarAwareElementType Exp1_Group_ELEMENT_TYPE = associate(Exp1Factory.createExp1_GroupElementType());

	public static final IGrammarAwareElementType Exp1_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE = associate(Exp1Factory.createExp1_NumberSignDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType Exp1_Addition1ParserRuleCall_1_ELEMENT_TYPE = associate(Exp1Factory.createExp1_Addition1ParserRuleCall_1ElementType());

	private static class Addition1Factory {
		public static IGrammarAwareElementType createAddition1ElementType() {
			return new IGrammarAwareElementType("Addition1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition1Rule());
		}
		public static IGrammarAwareElementType createAddition1_GroupElementType() {
			return new IGrammarAwareElementType("Addition1_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition1Access().getGroup());
		}
		public static IGrammarAwareElementType createAddition1_Prim1ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Addition1_Prim1ParserRuleCall_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition1Access().getPrim1ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAddition1_Group_1ElementType() {
			return new IGrammarAwareElementType("Addition1_Group_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition1Access().getGroup_1());
		}
		public static IGrammarAwareElementType createAddition1_Add1LeftAction_1_0ElementType() {
			return new IGrammarAwareElementType("Addition1_Add1LeftAction_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition1Access().getAdd1LeftAction_1_0());
		}
		public static IGrammarAwareElementType createAddition1_PlusSignKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("Addition1_PlusSignKeyword_1_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition1Access().getPlusSignKeyword_1_1());
		}
		public static IGrammarAwareElementType createAddition1_RightAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Addition1_RightAssignment_1_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition1Access().getRightAssignment_1_2());
		}
		public static IGrammarAwareElementType createAddition1_RightPrim1ParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Addition1_RightPrim1ParserRuleCall_1_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition1Access().getRightPrim1ParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Addition1_ELEMENT_TYPE = associate(Addition1Factory.createAddition1ElementType());

	public static final IGrammarAwareElementType Addition1_Group_ELEMENT_TYPE = associate(Addition1Factory.createAddition1_GroupElementType());

	public static final IGrammarAwareElementType Addition1_Prim1ParserRuleCall_0_ELEMENT_TYPE = associate(Addition1Factory.createAddition1_Prim1ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Addition1_Group_1_ELEMENT_TYPE = associate(Addition1Factory.createAddition1_Group_1ElementType());

	public static final IGrammarAwareElementType Addition1_Add1LeftAction_1_0_ELEMENT_TYPE = associate(Addition1Factory.createAddition1_Add1LeftAction_1_0ElementType());

	public static final IGrammarAwareElementType Addition1_PlusSignKeyword_1_1_ELEMENT_TYPE = associate(Addition1Factory.createAddition1_PlusSignKeyword_1_1ElementType());

	public static final IGrammarAwareElementType Addition1_RightAssignment_1_2_ELEMENT_TYPE = associate(Addition1Factory.createAddition1_RightAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Addition1_RightPrim1ParserRuleCall_1_2_0_ELEMENT_TYPE = associate(Addition1Factory.createAddition1_RightPrim1ParserRuleCall_1_2_0ElementType());

	private static class Prim1Factory {
		public static IGrammarAwareElementType createPrim1ElementType() {
			return new IGrammarAwareElementType("Prim1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim1Rule());
		}
		public static IGrammarAwareElementType createPrim1_AlternativesElementType() {
			return new IGrammarAwareElementType("Prim1_Alternatives_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim1Access().getAlternatives());
		}
		public static IGrammarAwareElementType createPrim1_Group_0ElementType() {
			return new IGrammarAwareElementType("Prim1_Group_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim1Access().getGroup_0());
		}
		public static IGrammarAwareElementType createPrim1_Val1Action_0_0ElementType() {
			return new IGrammarAwareElementType("Prim1_Val1Action_0_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim1Access().getVal1Action_0_0());
		}
		public static IGrammarAwareElementType createPrim1_NameAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Prim1_NameAssignment_0_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim1Access().getNameAssignment_0_1());
		}
		public static IGrammarAwareElementType createPrim1_NameIDTerminalRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Prim1_NameIDTerminalRuleCall_0_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim1Access().getNameIDTerminalRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createPrim1_Group_1ElementType() {
			return new IGrammarAwareElementType("Prim1_Group_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim1Access().getGroup_1());
		}
		public static IGrammarAwareElementType createPrim1_LeftParenthesisKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Prim1_LeftParenthesisKeyword_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim1Access().getLeftParenthesisKeyword_1_0());
		}
		public static IGrammarAwareElementType createPrim1_Addition1ParserRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("Prim1_Addition1ParserRuleCall_1_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim1Access().getAddition1ParserRuleCall_1_1());
		}
		public static IGrammarAwareElementType createPrim1_RightParenthesisKeyword_1_2ElementType() {
			return new IGrammarAwareElementType("Prim1_RightParenthesisKeyword_1_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim1Access().getRightParenthesisKeyword_1_2());
		}
	}

	public static final IGrammarAwareElementType Prim1_ELEMENT_TYPE = associate(Prim1Factory.createPrim1ElementType());

	public static final IGrammarAwareElementType Prim1_Alternatives_ELEMENT_TYPE = associate(Prim1Factory.createPrim1_AlternativesElementType());

	public static final IGrammarAwareElementType Prim1_Group_0_ELEMENT_TYPE = associate(Prim1Factory.createPrim1_Group_0ElementType());

	public static final IGrammarAwareElementType Prim1_Val1Action_0_0_ELEMENT_TYPE = associate(Prim1Factory.createPrim1_Val1Action_0_0ElementType());

	public static final IGrammarAwareElementType Prim1_NameAssignment_0_1_ELEMENT_TYPE = associate(Prim1Factory.createPrim1_NameAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Prim1_NameIDTerminalRuleCall_0_1_0_ELEMENT_TYPE = associate(Prim1Factory.createPrim1_NameIDTerminalRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Prim1_Group_1_ELEMENT_TYPE = associate(Prim1Factory.createPrim1_Group_1ElementType());

	public static final IGrammarAwareElementType Prim1_LeftParenthesisKeyword_1_0_ELEMENT_TYPE = associate(Prim1Factory.createPrim1_LeftParenthesisKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Prim1_Addition1ParserRuleCall_1_1_ELEMENT_TYPE = associate(Prim1Factory.createPrim1_Addition1ParserRuleCall_1_1ElementType());

	public static final IGrammarAwareElementType Prim1_RightParenthesisKeyword_1_2_ELEMENT_TYPE = associate(Prim1Factory.createPrim1_RightParenthesisKeyword_1_2ElementType());

	private static class Exp2Factory {
		public static IGrammarAwareElementType createExp2ElementType() {
			return new IGrammarAwareElementType("Exp2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp2Rule());
		}
		public static IGrammarAwareElementType createExp2_GroupElementType() {
			return new IGrammarAwareElementType("Exp2_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp2Access().getGroup());
		}
		public static IGrammarAwareElementType createExp2_NumberSignDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("Exp2_NumberSignDigitFourKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp2Access().getNumberSignDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createExp2_Addition2ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Exp2_Addition2ParserRuleCall_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExp2Access().getAddition2ParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Exp2_ELEMENT_TYPE = associate(Exp2Factory.createExp2ElementType());

	public static final IGrammarAwareElementType Exp2_Group_ELEMENT_TYPE = associate(Exp2Factory.createExp2_GroupElementType());

	public static final IGrammarAwareElementType Exp2_NumberSignDigitFourKeyword_0_ELEMENT_TYPE = associate(Exp2Factory.createExp2_NumberSignDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType Exp2_Addition2ParserRuleCall_1_ELEMENT_TYPE = associate(Exp2Factory.createExp2_Addition2ParserRuleCall_1ElementType());

	private static class Addition2Factory {
		public static IGrammarAwareElementType createAddition2ElementType() {
			return new IGrammarAwareElementType("Addition2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition2Rule());
		}
		public static IGrammarAwareElementType createAddition2_GroupElementType() {
			return new IGrammarAwareElementType("Addition2_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition2Access().getGroup());
		}
		public static IGrammarAwareElementType createAddition2_Multiplication2ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Addition2_Multiplication2ParserRuleCall_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition2Access().getMultiplication2ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAddition2_Group_1ElementType() {
			return new IGrammarAwareElementType("Addition2_Group_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition2Access().getGroup_1());
		}
		public static IGrammarAwareElementType createAddition2_Add2LeftAction_1_0ElementType() {
			return new IGrammarAwareElementType("Addition2_Add2LeftAction_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition2Access().getAdd2LeftAction_1_0());
		}
		public static IGrammarAwareElementType createAddition2_PlusSignKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("Addition2_PlusSignKeyword_1_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition2Access().getPlusSignKeyword_1_1());
		}
		public static IGrammarAwareElementType createAddition2_RightAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Addition2_RightAssignment_1_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition2Access().getRightAssignment_1_2());
		}
		public static IGrammarAwareElementType createAddition2_RightMultiplication2ParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Addition2_RightMultiplication2ParserRuleCall_1_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAddition2Access().getRightMultiplication2ParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Addition2_ELEMENT_TYPE = associate(Addition2Factory.createAddition2ElementType());

	public static final IGrammarAwareElementType Addition2_Group_ELEMENT_TYPE = associate(Addition2Factory.createAddition2_GroupElementType());

	public static final IGrammarAwareElementType Addition2_Multiplication2ParserRuleCall_0_ELEMENT_TYPE = associate(Addition2Factory.createAddition2_Multiplication2ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Addition2_Group_1_ELEMENT_TYPE = associate(Addition2Factory.createAddition2_Group_1ElementType());

	public static final IGrammarAwareElementType Addition2_Add2LeftAction_1_0_ELEMENT_TYPE = associate(Addition2Factory.createAddition2_Add2LeftAction_1_0ElementType());

	public static final IGrammarAwareElementType Addition2_PlusSignKeyword_1_1_ELEMENT_TYPE = associate(Addition2Factory.createAddition2_PlusSignKeyword_1_1ElementType());

	public static final IGrammarAwareElementType Addition2_RightAssignment_1_2_ELEMENT_TYPE = associate(Addition2Factory.createAddition2_RightAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Addition2_RightMultiplication2ParserRuleCall_1_2_0_ELEMENT_TYPE = associate(Addition2Factory.createAddition2_RightMultiplication2ParserRuleCall_1_2_0ElementType());

	private static class Multiplication2Factory {
		public static IGrammarAwareElementType createMultiplication2ElementType() {
			return new IGrammarAwareElementType("Multiplication2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplication2Rule());
		}
		public static IGrammarAwareElementType createMultiplication2_GroupElementType() {
			return new IGrammarAwareElementType("Multiplication2_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplication2Access().getGroup());
		}
		public static IGrammarAwareElementType createMultiplication2_Prim2ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Multiplication2_Prim2ParserRuleCall_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplication2Access().getPrim2ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createMultiplication2_Group_1ElementType() {
			return new IGrammarAwareElementType("Multiplication2_Group_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplication2Access().getGroup_1());
		}
		public static IGrammarAwareElementType createMultiplication2_Mult2LeftAction_1_0ElementType() {
			return new IGrammarAwareElementType("Multiplication2_Mult2LeftAction_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplication2Access().getMult2LeftAction_1_0());
		}
		public static IGrammarAwareElementType createMultiplication2_AsteriskKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("Multiplication2_AsteriskKeyword_1_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplication2Access().getAsteriskKeyword_1_1());
		}
		public static IGrammarAwareElementType createMultiplication2_RightAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Multiplication2_RightAssignment_1_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplication2Access().getRightAssignment_1_2());
		}
		public static IGrammarAwareElementType createMultiplication2_RightPrim2ParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Multiplication2_RightPrim2ParserRuleCall_1_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplication2Access().getRightPrim2ParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Multiplication2_ELEMENT_TYPE = associate(Multiplication2Factory.createMultiplication2ElementType());

	public static final IGrammarAwareElementType Multiplication2_Group_ELEMENT_TYPE = associate(Multiplication2Factory.createMultiplication2_GroupElementType());

	public static final IGrammarAwareElementType Multiplication2_Prim2ParserRuleCall_0_ELEMENT_TYPE = associate(Multiplication2Factory.createMultiplication2_Prim2ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Multiplication2_Group_1_ELEMENT_TYPE = associate(Multiplication2Factory.createMultiplication2_Group_1ElementType());

	public static final IGrammarAwareElementType Multiplication2_Mult2LeftAction_1_0_ELEMENT_TYPE = associate(Multiplication2Factory.createMultiplication2_Mult2LeftAction_1_0ElementType());

	public static final IGrammarAwareElementType Multiplication2_AsteriskKeyword_1_1_ELEMENT_TYPE = associate(Multiplication2Factory.createMultiplication2_AsteriskKeyword_1_1ElementType());

	public static final IGrammarAwareElementType Multiplication2_RightAssignment_1_2_ELEMENT_TYPE = associate(Multiplication2Factory.createMultiplication2_RightAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Multiplication2_RightPrim2ParserRuleCall_1_2_0_ELEMENT_TYPE = associate(Multiplication2Factory.createMultiplication2_RightPrim2ParserRuleCall_1_2_0ElementType());

	private static class Prim2Factory {
		public static IGrammarAwareElementType createPrim2ElementType() {
			return new IGrammarAwareElementType("Prim2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim2Rule());
		}
		public static IGrammarAwareElementType createPrim2_AlternativesElementType() {
			return new IGrammarAwareElementType("Prim2_Alternatives_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim2Access().getAlternatives());
		}
		public static IGrammarAwareElementType createPrim2_Group_0ElementType() {
			return new IGrammarAwareElementType("Prim2_Group_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim2Access().getGroup_0());
		}
		public static IGrammarAwareElementType createPrim2_Val2Action_0_0ElementType() {
			return new IGrammarAwareElementType("Prim2_Val2Action_0_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim2Access().getVal2Action_0_0());
		}
		public static IGrammarAwareElementType createPrim2_NameAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Prim2_NameAssignment_0_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim2Access().getNameAssignment_0_1());
		}
		public static IGrammarAwareElementType createPrim2_NameIDTerminalRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Prim2_NameIDTerminalRuleCall_0_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim2Access().getNameIDTerminalRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createPrim2_Group_1ElementType() {
			return new IGrammarAwareElementType("Prim2_Group_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim2Access().getGroup_1());
		}
		public static IGrammarAwareElementType createPrim2_LeftParenthesisKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Prim2_LeftParenthesisKeyword_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim2Access().getLeftParenthesisKeyword_1_0());
		}
		public static IGrammarAwareElementType createPrim2_Addition2ParserRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("Prim2_Addition2ParserRuleCall_1_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim2Access().getAddition2ParserRuleCall_1_1());
		}
		public static IGrammarAwareElementType createPrim2_RightParenthesisKeyword_1_2ElementType() {
			return new IGrammarAwareElementType("Prim2_RightParenthesisKeyword_1_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrim2Access().getRightParenthesisKeyword_1_2());
		}
	}

	public static final IGrammarAwareElementType Prim2_ELEMENT_TYPE = associate(Prim2Factory.createPrim2ElementType());

	public static final IGrammarAwareElementType Prim2_Alternatives_ELEMENT_TYPE = associate(Prim2Factory.createPrim2_AlternativesElementType());

	public static final IGrammarAwareElementType Prim2_Group_0_ELEMENT_TYPE = associate(Prim2Factory.createPrim2_Group_0ElementType());

	public static final IGrammarAwareElementType Prim2_Val2Action_0_0_ELEMENT_TYPE = associate(Prim2Factory.createPrim2_Val2Action_0_0ElementType());

	public static final IGrammarAwareElementType Prim2_NameAssignment_0_1_ELEMENT_TYPE = associate(Prim2Factory.createPrim2_NameAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Prim2_NameIDTerminalRuleCall_0_1_0_ELEMENT_TYPE = associate(Prim2Factory.createPrim2_NameIDTerminalRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Prim2_Group_1_ELEMENT_TYPE = associate(Prim2Factory.createPrim2_Group_1ElementType());

	public static final IGrammarAwareElementType Prim2_LeftParenthesisKeyword_1_0_ELEMENT_TYPE = associate(Prim2Factory.createPrim2_LeftParenthesisKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Prim2_Addition2ParserRuleCall_1_1_ELEMENT_TYPE = associate(Prim2Factory.createPrim2_Addition2ParserRuleCall_1_1ElementType());

	public static final IGrammarAwareElementType Prim2_RightParenthesisKeyword_1_2_ELEMENT_TYPE = associate(Prim2Factory.createPrim2_RightParenthesisKeyword_1_2ElementType());

	private static class DatatypeIDFactory {
		public static IGrammarAwareElementType createDatatypeIDElementType() {
			return new IGrammarAwareElementType("DatatypeID_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeIDRule());
		}
		public static IGrammarAwareElementType createDatatypeID_IDTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("DatatypeID_IDTerminalRuleCall_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeIDAccess().getIDTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType DatatypeID_ELEMENT_TYPE = associate(DatatypeIDFactory.createDatatypeIDElementType());

	public static final IGrammarAwareElementType DatatypeID_IDTerminalRuleCall_ELEMENT_TYPE = associate(DatatypeIDFactory.createDatatypeID_IDTerminalRuleCallElementType());

	private static class SingleCrossReferenceFactory {
		public static IGrammarAwareElementType createSingleCrossReferenceElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceRule());
		}
		public static IGrammarAwareElementType createSingleCrossReference_GroupElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getGroup());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NumberSignDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNumberSignDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NameAssignment_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NameAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NameAlternatives_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNameAlternatives_1_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NameTERMINAL_IDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NameTERMINAL_IDTerminalRuleCall_1_0_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNameTERMINAL_IDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NameIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NameIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNameIDTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Group_2ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Group_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Kw1Keyword_2_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Kw1Keyword_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getKw1Keyword_2_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref1Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref1Assignment_2_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef1Assignment_2_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef1SingleCrossReferenceCrossReference_2_1_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref1SingleCrossReferenceTERMINAL_IDTerminalRuleCall_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref1SingleCrossReferenceTERMINAL_IDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef1SingleCrossReferenceTERMINAL_IDTerminalRuleCall_2_1_0_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Group_3ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Group_3_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Kw2Keyword_3_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Kw2Keyword_3_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getKw2Keyword_3_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref2Assignment_3_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref2Assignment_3_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef2Assignment_3_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef2SingleCrossReferenceCrossReference_3_1_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref2SingleCrossReferenceDatatypeIDParserRuleCall_3_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref2SingleCrossReferenceDatatypeIDParserRuleCall_3_1_0_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef2SingleCrossReferenceDatatypeIDParserRuleCall_3_1_0_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Group_4ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Group_4_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Kw3Keyword_4_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Kw3Keyword_4_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getKw3Keyword_4_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref3Assignment_4_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref3Assignment_4_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef3Assignment_4_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef3SingleCrossReferenceCrossReference_4_1_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref3SingleCrossReferenceIDTerminalRuleCall_4_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref3SingleCrossReferenceIDTerminalRuleCall_4_1_0_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef3SingleCrossReferenceIDTerminalRuleCall_4_1_0_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Group_5ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Group_5_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Kw4Keyword_5_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Kw4Keyword_5_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getKw4Keyword_5_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref4Assignment_5_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref4Assignment_5_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef4Assignment_5_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref4SingleCrossReferenceCrossReference_5_1_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref4SingleCrossReferenceCrossReference_5_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef4SingleCrossReferenceCrossReference_5_1_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Ref4SingleCrossReferenceIDTerminalRuleCall_5_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Ref4SingleCrossReferenceIDTerminalRuleCall_5_1_0_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRef4SingleCrossReferenceIDTerminalRuleCall_5_1_0_1());
		}
	}

	public static final IGrammarAwareElementType SingleCrossReference_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReferenceElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Group_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_GroupElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NumberSignDigitFiveKeyword_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NameAssignment_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NameAlternatives_1_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NameAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NameTERMINAL_IDTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NameTERMINAL_IDTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NameIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NameIDTerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Group_2_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Group_2ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Kw1Keyword_2_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Kw1Keyword_2_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref1Assignment_2_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref1Assignment_2_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref1SingleCrossReferenceTERMINAL_IDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref1SingleCrossReferenceTERMINAL_IDTerminalRuleCall_2_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Group_3_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Group_3ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Kw2Keyword_3_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Kw2Keyword_3_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref2Assignment_3_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref2Assignment_3_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref2SingleCrossReferenceDatatypeIDParserRuleCall_3_1_0_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref2SingleCrossReferenceDatatypeIDParserRuleCall_3_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Group_4_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Group_4ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Kw3Keyword_4_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Kw3Keyword_4_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref3Assignment_4_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref3Assignment_4_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref3SingleCrossReferenceIDTerminalRuleCall_4_1_0_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref3SingleCrossReferenceIDTerminalRuleCall_4_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Group_5_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Group_5ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Kw4Keyword_5_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Kw4Keyword_5_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref4Assignment_5_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref4Assignment_5_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref4SingleCrossReferenceCrossReference_5_1_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref4SingleCrossReferenceCrossReference_5_1_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Ref4SingleCrossReferenceIDTerminalRuleCall_5_1_0_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Ref4SingleCrossReferenceIDTerminalRuleCall_5_1_0_1ElementType());

	private static class BooleanAlternativeFactory {
		public static IGrammarAwareElementType createBooleanAlternativeElementType() {
			return new IGrammarAwareElementType("BooleanAlternative_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeRule());
		}
		public static IGrammarAwareElementType createBooleanAlternative_GroupElementType() {
			return new IGrammarAwareElementType("BooleanAlternative_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeAccess().getGroup());
		}
		public static IGrammarAwareElementType createBooleanAlternative_NumberSignDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("BooleanAlternative_NumberSignDigitSixKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeAccess().getNumberSignDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createBooleanAlternative_BoolAssignment_1ElementType() {
			return new IGrammarAwareElementType("BooleanAlternative_BoolAssignment_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeAccess().getBoolAssignment_1());
		}
		public static IGrammarAwareElementType createBooleanAlternative_BoolBooleanAlternativeLiteralParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("BooleanAlternative_BoolBooleanAlternativeLiteralParserRuleCall_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeAccess().getBoolBooleanAlternativeLiteralParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType BooleanAlternative_ELEMENT_TYPE = associate(BooleanAlternativeFactory.createBooleanAlternativeElementType());

	public static final IGrammarAwareElementType BooleanAlternative_Group_ELEMENT_TYPE = associate(BooleanAlternativeFactory.createBooleanAlternative_GroupElementType());

	public static final IGrammarAwareElementType BooleanAlternative_NumberSignDigitSixKeyword_0_ELEMENT_TYPE = associate(BooleanAlternativeFactory.createBooleanAlternative_NumberSignDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType BooleanAlternative_BoolAssignment_1_ELEMENT_TYPE = associate(BooleanAlternativeFactory.createBooleanAlternative_BoolAssignment_1ElementType());

	public static final IGrammarAwareElementType BooleanAlternative_BoolBooleanAlternativeLiteralParserRuleCall_1_0_ELEMENT_TYPE = associate(BooleanAlternativeFactory.createBooleanAlternative_BoolBooleanAlternativeLiteralParserRuleCall_1_0ElementType());

	private static class BooleanAlternativeLiteralFactory {
		public static IGrammarAwareElementType createBooleanAlternativeLiteralElementType() {
			return new IGrammarAwareElementType("BooleanAlternativeLiteral_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeLiteralRule());
		}
		public static IGrammarAwareElementType createBooleanAlternativeLiteral_GroupElementType() {
			return new IGrammarAwareElementType("BooleanAlternativeLiteral_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeLiteralAccess().getGroup());
		}
		public static IGrammarAwareElementType createBooleanAlternativeLiteral_BooleanAlternativeLiteralAction_0ElementType() {
			return new IGrammarAwareElementType("BooleanAlternativeLiteral_BooleanAlternativeLiteralAction_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeLiteralAccess().getBooleanAlternativeLiteralAction_0());
		}
		public static IGrammarAwareElementType createBooleanAlternativeLiteral_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("BooleanAlternativeLiteral_Alternatives_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeLiteralAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createBooleanAlternativeLiteral_Kw1Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("BooleanAlternativeLiteral_Kw1Keyword_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeLiteralAccess().getKw1Keyword_1_0());
		}
		public static IGrammarAwareElementType createBooleanAlternativeLiteral_IsTrueAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("BooleanAlternativeLiteral_IsTrueAssignment_1_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeLiteralAccess().getIsTrueAssignment_1_1());
		}
		public static IGrammarAwareElementType createBooleanAlternativeLiteral_IsTrueKw2Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("BooleanAlternativeLiteral_IsTrueKw2Keyword_1_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAlternativeLiteralAccess().getIsTrueKw2Keyword_1_1_0());
		}
	}

	public static final IGrammarAwareElementType BooleanAlternativeLiteral_ELEMENT_TYPE = associate(BooleanAlternativeLiteralFactory.createBooleanAlternativeLiteralElementType());

	public static final IGrammarAwareElementType BooleanAlternativeLiteral_Group_ELEMENT_TYPE = associate(BooleanAlternativeLiteralFactory.createBooleanAlternativeLiteral_GroupElementType());

	public static final IGrammarAwareElementType BooleanAlternativeLiteral_BooleanAlternativeLiteralAction_0_ELEMENT_TYPE = associate(BooleanAlternativeLiteralFactory.createBooleanAlternativeLiteral_BooleanAlternativeLiteralAction_0ElementType());

	public static final IGrammarAwareElementType BooleanAlternativeLiteral_Alternatives_1_ELEMENT_TYPE = associate(BooleanAlternativeLiteralFactory.createBooleanAlternativeLiteral_Alternatives_1ElementType());

	public static final IGrammarAwareElementType BooleanAlternativeLiteral_Kw1Keyword_1_0_ELEMENT_TYPE = associate(BooleanAlternativeLiteralFactory.createBooleanAlternativeLiteral_Kw1Keyword_1_0ElementType());

	public static final IGrammarAwareElementType BooleanAlternativeLiteral_IsTrueAssignment_1_1_ELEMENT_TYPE = associate(BooleanAlternativeLiteralFactory.createBooleanAlternativeLiteral_IsTrueAssignment_1_1ElementType());

	public static final IGrammarAwareElementType BooleanAlternativeLiteral_IsTrueKw2Keyword_1_1_0_ELEMENT_TYPE = associate(BooleanAlternativeLiteralFactory.createBooleanAlternativeLiteral_IsTrueKw2Keyword_1_1_0ElementType());

	private static class UnassignedDatatypeFactory {
		public static IGrammarAwareElementType createUnassignedDatatypeElementType() {
			return new IGrammarAwareElementType("UnassignedDatatype_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedDatatypeRule());
		}
		public static IGrammarAwareElementType createUnassignedDatatype_GroupElementType() {
			return new IGrammarAwareElementType("UnassignedDatatype_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedDatatypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnassignedDatatype_NumberSignDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("UnassignedDatatype_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedDatatypeAccess().getNumberSignDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createUnassignedDatatype_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("UnassignedDatatype_ValAssignment_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedDatatypeAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createUnassignedDatatype_ValIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("UnassignedDatatype_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedDatatypeAccess().getValIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createUnassignedDatatype_KW1ParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("UnassignedDatatype_KW1ParserRuleCall_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedDatatypeAccess().getKW1ParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType UnassignedDatatype_ELEMENT_TYPE = associate(UnassignedDatatypeFactory.createUnassignedDatatypeElementType());

	public static final IGrammarAwareElementType UnassignedDatatype_Group_ELEMENT_TYPE = associate(UnassignedDatatypeFactory.createUnassignedDatatype_GroupElementType());

	public static final IGrammarAwareElementType UnassignedDatatype_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE = associate(UnassignedDatatypeFactory.createUnassignedDatatype_NumberSignDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType UnassignedDatatype_ValAssignment_1_ELEMENT_TYPE = associate(UnassignedDatatypeFactory.createUnassignedDatatype_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType UnassignedDatatype_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(UnassignedDatatypeFactory.createUnassignedDatatype_ValIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType UnassignedDatatype_KW1ParserRuleCall_2_ELEMENT_TYPE = associate(UnassignedDatatypeFactory.createUnassignedDatatype_KW1ParserRuleCall_2ElementType());

	private static class KW1Factory {
		public static IGrammarAwareElementType createKW1ElementType() {
			return new IGrammarAwareElementType("KW1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKW1Rule());
		}
		public static IGrammarAwareElementType createKW1_AlternativesElementType() {
			return new IGrammarAwareElementType("KW1_Alternatives_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKW1Access().getAlternatives());
		}
		public static IGrammarAwareElementType createKW1_Kw1Keyword_0ElementType() {
			return new IGrammarAwareElementType("KW1_Kw1Keyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKW1Access().getKw1Keyword_0());
		}
		public static IGrammarAwareElementType createKW1_Group_1ElementType() {
			return new IGrammarAwareElementType("KW1_Group_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKW1Access().getGroup_1());
		}
		public static IGrammarAwareElementType createKW1_MatchedKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("KW1_MatchedKeyword_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKW1Access().getMatchedKeyword_1_0());
		}
		public static IGrammarAwareElementType createKW1_INTTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("KW1_INTTerminalRuleCall_1_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKW1Access().getINTTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType KW1_ELEMENT_TYPE = associate(KW1Factory.createKW1ElementType());

	public static final IGrammarAwareElementType KW1_Alternatives_ELEMENT_TYPE = associate(KW1Factory.createKW1_AlternativesElementType());

	public static final IGrammarAwareElementType KW1_Kw1Keyword_0_ELEMENT_TYPE = associate(KW1Factory.createKW1_Kw1Keyword_0ElementType());

	public static final IGrammarAwareElementType KW1_Group_1_ELEMENT_TYPE = associate(KW1Factory.createKW1_Group_1ElementType());

	public static final IGrammarAwareElementType KW1_MatchedKeyword_1_0_ELEMENT_TYPE = associate(KW1Factory.createKW1_MatchedKeyword_1_0ElementType());

	public static final IGrammarAwareElementType KW1_INTTerminalRuleCall_1_1_ELEMENT_TYPE = associate(KW1Factory.createKW1_INTTerminalRuleCall_1_1ElementType());

	private static class OptionalSingleTransitionFactory {
		public static IGrammarAwareElementType createOptionalSingleTransitionElementType() {
			return new IGrammarAwareElementType("OptionalSingleTransition_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalSingleTransitionRule());
		}
		public static IGrammarAwareElementType createOptionalSingleTransition_GroupElementType() {
			return new IGrammarAwareElementType("OptionalSingleTransition_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalSingleTransitionAccess().getGroup());
		}
		public static IGrammarAwareElementType createOptionalSingleTransition_NumberSignDigitEightKeyword_0ElementType() {
			return new IGrammarAwareElementType("OptionalSingleTransition_NumberSignDigitEightKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalSingleTransitionAccess().getNumberSignDigitEightKeyword_0());
		}
		public static IGrammarAwareElementType createOptionalSingleTransition_KW1ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("OptionalSingleTransition_KW1ParserRuleCall_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalSingleTransitionAccess().getKW1ParserRuleCall_1());
		}
		public static IGrammarAwareElementType createOptionalSingleTransition_ValAssignment_2ElementType() {
			return new IGrammarAwareElementType("OptionalSingleTransition_ValAssignment_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalSingleTransitionAccess().getValAssignment_2());
		}
		public static IGrammarAwareElementType createOptionalSingleTransition_ValIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("OptionalSingleTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalSingleTransitionAccess().getValIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType OptionalSingleTransition_ELEMENT_TYPE = associate(OptionalSingleTransitionFactory.createOptionalSingleTransitionElementType());

	public static final IGrammarAwareElementType OptionalSingleTransition_Group_ELEMENT_TYPE = associate(OptionalSingleTransitionFactory.createOptionalSingleTransition_GroupElementType());

	public static final IGrammarAwareElementType OptionalSingleTransition_NumberSignDigitEightKeyword_0_ELEMENT_TYPE = associate(OptionalSingleTransitionFactory.createOptionalSingleTransition_NumberSignDigitEightKeyword_0ElementType());

	public static final IGrammarAwareElementType OptionalSingleTransition_KW1ParserRuleCall_1_ELEMENT_TYPE = associate(OptionalSingleTransitionFactory.createOptionalSingleTransition_KW1ParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType OptionalSingleTransition_ValAssignment_2_ELEMENT_TYPE = associate(OptionalSingleTransitionFactory.createOptionalSingleTransition_ValAssignment_2ElementType());

	public static final IGrammarAwareElementType OptionalSingleTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(OptionalSingleTransitionFactory.createOptionalSingleTransition_ValIDTerminalRuleCall_2_0ElementType());

	private static class OptionalManyTransitionFactory {
		public static IGrammarAwareElementType createOptionalManyTransitionElementType() {
			return new IGrammarAwareElementType("OptionalManyTransition_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalManyTransitionRule());
		}
		public static IGrammarAwareElementType createOptionalManyTransition_GroupElementType() {
			return new IGrammarAwareElementType("OptionalManyTransition_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalManyTransitionAccess().getGroup());
		}
		public static IGrammarAwareElementType createOptionalManyTransition_NumberSignDigitNineKeyword_0ElementType() {
			return new IGrammarAwareElementType("OptionalManyTransition_NumberSignDigitNineKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalManyTransitionAccess().getNumberSignDigitNineKeyword_0());
		}
		public static IGrammarAwareElementType createOptionalManyTransition_KW1ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("OptionalManyTransition_KW1ParserRuleCall_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalManyTransitionAccess().getKW1ParserRuleCall_1());
		}
		public static IGrammarAwareElementType createOptionalManyTransition_ValAssignment_2ElementType() {
			return new IGrammarAwareElementType("OptionalManyTransition_ValAssignment_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalManyTransitionAccess().getValAssignment_2());
		}
		public static IGrammarAwareElementType createOptionalManyTransition_ValIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("OptionalManyTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalManyTransitionAccess().getValIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType OptionalManyTransition_ELEMENT_TYPE = associate(OptionalManyTransitionFactory.createOptionalManyTransitionElementType());

	public static final IGrammarAwareElementType OptionalManyTransition_Group_ELEMENT_TYPE = associate(OptionalManyTransitionFactory.createOptionalManyTransition_GroupElementType());

	public static final IGrammarAwareElementType OptionalManyTransition_NumberSignDigitNineKeyword_0_ELEMENT_TYPE = associate(OptionalManyTransitionFactory.createOptionalManyTransition_NumberSignDigitNineKeyword_0ElementType());

	public static final IGrammarAwareElementType OptionalManyTransition_KW1ParserRuleCall_1_ELEMENT_TYPE = associate(OptionalManyTransitionFactory.createOptionalManyTransition_KW1ParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType OptionalManyTransition_ValAssignment_2_ELEMENT_TYPE = associate(OptionalManyTransitionFactory.createOptionalManyTransition_ValAssignment_2ElementType());

	public static final IGrammarAwareElementType OptionalManyTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(OptionalManyTransitionFactory.createOptionalManyTransition_ValIDTerminalRuleCall_2_0ElementType());

	private static class MandatoryManyTransitionFactory {
		public static IGrammarAwareElementType createMandatoryManyTransitionElementType() {
			return new IGrammarAwareElementType("MandatoryManyTransition_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryManyTransitionRule());
		}
		public static IGrammarAwareElementType createMandatoryManyTransition_GroupElementType() {
			return new IGrammarAwareElementType("MandatoryManyTransition_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryManyTransitionAccess().getGroup());
		}
		public static IGrammarAwareElementType createMandatoryManyTransition_NumberSignDigitOneDigitZeroKeyword_0ElementType() {
			return new IGrammarAwareElementType("MandatoryManyTransition_NumberSignDigitOneDigitZeroKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryManyTransitionAccess().getNumberSignDigitOneDigitZeroKeyword_0());
		}
		public static IGrammarAwareElementType createMandatoryManyTransition_KW1ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("MandatoryManyTransition_KW1ParserRuleCall_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryManyTransitionAccess().getKW1ParserRuleCall_1());
		}
		public static IGrammarAwareElementType createMandatoryManyTransition_ValAssignment_2ElementType() {
			return new IGrammarAwareElementType("MandatoryManyTransition_ValAssignment_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryManyTransitionAccess().getValAssignment_2());
		}
		public static IGrammarAwareElementType createMandatoryManyTransition_ValIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("MandatoryManyTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMandatoryManyTransitionAccess().getValIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType MandatoryManyTransition_ELEMENT_TYPE = associate(MandatoryManyTransitionFactory.createMandatoryManyTransitionElementType());

	public static final IGrammarAwareElementType MandatoryManyTransition_Group_ELEMENT_TYPE = associate(MandatoryManyTransitionFactory.createMandatoryManyTransition_GroupElementType());

	public static final IGrammarAwareElementType MandatoryManyTransition_NumberSignDigitOneDigitZeroKeyword_0_ELEMENT_TYPE = associate(MandatoryManyTransitionFactory.createMandatoryManyTransition_NumberSignDigitOneDigitZeroKeyword_0ElementType());

	public static final IGrammarAwareElementType MandatoryManyTransition_KW1ParserRuleCall_1_ELEMENT_TYPE = associate(MandatoryManyTransitionFactory.createMandatoryManyTransition_KW1ParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType MandatoryManyTransition_ValAssignment_2_ELEMENT_TYPE = associate(MandatoryManyTransitionFactory.createMandatoryManyTransition_ValAssignment_2ElementType());

	public static final IGrammarAwareElementType MandatoryManyTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(MandatoryManyTransitionFactory.createMandatoryManyTransition_ValIDTerminalRuleCall_2_0ElementType());

	private static class AlternativeTransitionFactory {
		public static IGrammarAwareElementType createAlternativeTransitionElementType() {
			return new IGrammarAwareElementType("AlternativeTransition_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeTransitionRule());
		}
		public static IGrammarAwareElementType createAlternativeTransition_GroupElementType() {
			return new IGrammarAwareElementType("AlternativeTransition_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeTransitionAccess().getGroup());
		}
		public static IGrammarAwareElementType createAlternativeTransition_NumberSignDigitOneDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("AlternativeTransition_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeTransitionAccess().getNumberSignDigitOneDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createAlternativeTransition_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("AlternativeTransition_Alternatives_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeTransitionAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createAlternativeTransition_KW1ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeTransition_KW1ParserRuleCall_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeTransitionAccess().getKW1ParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createAlternativeTransition_Kw2Keyword_1_1ElementType() {
			return new IGrammarAwareElementType("AlternativeTransition_Kw2Keyword_1_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeTransitionAccess().getKw2Keyword_1_1());
		}
		public static IGrammarAwareElementType createAlternativeTransition_ValAssignment_2ElementType() {
			return new IGrammarAwareElementType("AlternativeTransition_ValAssignment_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeTransitionAccess().getValAssignment_2());
		}
		public static IGrammarAwareElementType createAlternativeTransition_ValIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("AlternativeTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeTransitionAccess().getValIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType AlternativeTransition_ELEMENT_TYPE = associate(AlternativeTransitionFactory.createAlternativeTransitionElementType());

	public static final IGrammarAwareElementType AlternativeTransition_Group_ELEMENT_TYPE = associate(AlternativeTransitionFactory.createAlternativeTransition_GroupElementType());

	public static final IGrammarAwareElementType AlternativeTransition_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE = associate(AlternativeTransitionFactory.createAlternativeTransition_NumberSignDigitOneDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType AlternativeTransition_Alternatives_1_ELEMENT_TYPE = associate(AlternativeTransitionFactory.createAlternativeTransition_Alternatives_1ElementType());

	public static final IGrammarAwareElementType AlternativeTransition_KW1ParserRuleCall_1_0_ELEMENT_TYPE = associate(AlternativeTransitionFactory.createAlternativeTransition_KW1ParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType AlternativeTransition_Kw2Keyword_1_1_ELEMENT_TYPE = associate(AlternativeTransitionFactory.createAlternativeTransition_Kw2Keyword_1_1ElementType());

	public static final IGrammarAwareElementType AlternativeTransition_ValAssignment_2_ELEMENT_TYPE = associate(AlternativeTransitionFactory.createAlternativeTransition_ValAssignment_2ElementType());

	public static final IGrammarAwareElementType AlternativeTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(AlternativeTransitionFactory.createAlternativeTransition_ValIDTerminalRuleCall_2_0ElementType());

	private static class BooleanDatatypeIDFactory {
		public static IGrammarAwareElementType createBooleanDatatypeIDElementType() {
			return new IGrammarAwareElementType("BooleanDatatypeID_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanDatatypeIDRule());
		}
		public static IGrammarAwareElementType createBooleanDatatypeID_IDTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("BooleanDatatypeID_IDTerminalRuleCall_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanDatatypeIDAccess().getIDTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType BooleanDatatypeID_ELEMENT_TYPE = associate(BooleanDatatypeIDFactory.createBooleanDatatypeIDElementType());

	public static final IGrammarAwareElementType BooleanDatatypeID_IDTerminalRuleCall_ELEMENT_TYPE = associate(BooleanDatatypeIDFactory.createBooleanDatatypeID_IDTerminalRuleCallElementType());

	private static class BooleanValuesFactory {
		public static IGrammarAwareElementType createBooleanValuesElementType() {
			return new IGrammarAwareElementType("BooleanValues_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanValuesRule());
		}
		public static IGrammarAwareElementType createBooleanValues_GroupElementType() {
			return new IGrammarAwareElementType("BooleanValues_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanValuesAccess().getGroup());
		}
		public static IGrammarAwareElementType createBooleanValues_BooleanValuesAction_0ElementType() {
			return new IGrammarAwareElementType("BooleanValues_BooleanValuesAction_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanValuesAccess().getBooleanValuesAction_0());
		}
		public static IGrammarAwareElementType createBooleanValues_NumberSignDigitOneDigitTwoKeyword_1ElementType() {
			return new IGrammarAwareElementType("BooleanValues_NumberSignDigitOneDigitTwoKeyword_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanValuesAccess().getNumberSignDigitOneDigitTwoKeyword_1());
		}
		public static IGrammarAwareElementType createBooleanValues_Val1Assignment_2ElementType() {
			return new IGrammarAwareElementType("BooleanValues_Val1Assignment_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanValuesAccess().getVal1Assignment_2());
		}
		public static IGrammarAwareElementType createBooleanValues_Val1Kw1Keyword_2_0ElementType() {
			return new IGrammarAwareElementType("BooleanValues_Val1Kw1Keyword_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanValuesAccess().getVal1Kw1Keyword_2_0());
		}
		public static IGrammarAwareElementType createBooleanValues_Val2Assignment_3ElementType() {
			return new IGrammarAwareElementType("BooleanValues_Val2Assignment_3_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanValuesAccess().getVal2Assignment_3());
		}
		public static IGrammarAwareElementType createBooleanValues_Val2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("BooleanValues_Val2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanValuesAccess().getVal2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0());
		}
		public static IGrammarAwareElementType createBooleanValues_Val3Assignment_4ElementType() {
			return new IGrammarAwareElementType("BooleanValues_Val3Assignment_4_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanValuesAccess().getVal3Assignment_4());
		}
		public static IGrammarAwareElementType createBooleanValues_Val3BooleanDatatypeIDParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("BooleanValues_Val3BooleanDatatypeIDParserRuleCall_4_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanValuesAccess().getVal3BooleanDatatypeIDParserRuleCall_4_0());
		}
	}

	public static final IGrammarAwareElementType BooleanValues_ELEMENT_TYPE = associate(BooleanValuesFactory.createBooleanValuesElementType());

	public static final IGrammarAwareElementType BooleanValues_Group_ELEMENT_TYPE = associate(BooleanValuesFactory.createBooleanValues_GroupElementType());

	public static final IGrammarAwareElementType BooleanValues_BooleanValuesAction_0_ELEMENT_TYPE = associate(BooleanValuesFactory.createBooleanValues_BooleanValuesAction_0ElementType());

	public static final IGrammarAwareElementType BooleanValues_NumberSignDigitOneDigitTwoKeyword_1_ELEMENT_TYPE = associate(BooleanValuesFactory.createBooleanValues_NumberSignDigitOneDigitTwoKeyword_1ElementType());

	public static final IGrammarAwareElementType BooleanValues_Val1Assignment_2_ELEMENT_TYPE = associate(BooleanValuesFactory.createBooleanValues_Val1Assignment_2ElementType());

	public static final IGrammarAwareElementType BooleanValues_Val1Kw1Keyword_2_0_ELEMENT_TYPE = associate(BooleanValuesFactory.createBooleanValues_Val1Kw1Keyword_2_0ElementType());

	public static final IGrammarAwareElementType BooleanValues_Val2Assignment_3_ELEMENT_TYPE = associate(BooleanValuesFactory.createBooleanValues_Val2Assignment_3ElementType());

	public static final IGrammarAwareElementType BooleanValues_Val2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(BooleanValuesFactory.createBooleanValues_Val2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType BooleanValues_Val3Assignment_4_ELEMENT_TYPE = associate(BooleanValuesFactory.createBooleanValues_Val3Assignment_4ElementType());

	public static final IGrammarAwareElementType BooleanValues_Val3BooleanDatatypeIDParserRuleCall_4_0_ELEMENT_TYPE = associate(BooleanValuesFactory.createBooleanValues_Val3BooleanDatatypeIDParserRuleCall_4_0ElementType());

	private static class LongAlternativeFactory {
		public static IGrammarAwareElementType createLongAlternativeElementType() {
			return new IGrammarAwareElementType("LongAlternative_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeRule());
		}
		public static IGrammarAwareElementType createLongAlternative_GroupElementType() {
			return new IGrammarAwareElementType("LongAlternative_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getGroup());
		}
		public static IGrammarAwareElementType createLongAlternative_NumberSignDigitOneDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getNumberSignDigitOneDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createLongAlternative_FooAssignment_1ElementType() {
			return new IGrammarAwareElementType("LongAlternative_FooAssignment_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getFooAssignment_1());
		}
		public static IGrammarAwareElementType createLongAlternative_FooIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_FooIDTerminalRuleCall_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getFooIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Alternatives_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createLongAlternative_Group_2_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Group_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getGroup_2_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Kw1Keyword_2_0_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Kw1Keyword_2_0_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getKw1Keyword_2_0_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Val1Assignment_2_0_1ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val1Assignment_2_0_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal1Assignment_2_0_1());
		}
		public static IGrammarAwareElementType createLongAlternative_Val1IDTerminalRuleCall_2_0_1_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val1IDTerminalRuleCall_2_0_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal1IDTerminalRuleCall_2_0_1_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Group_2_1ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Group_2_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getGroup_2_1());
		}
		public static IGrammarAwareElementType createLongAlternative_Kw2Keyword_2_1_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Kw2Keyword_2_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getKw2Keyword_2_1_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Val2Assignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val2Assignment_2_1_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal2Assignment_2_1_1());
		}
		public static IGrammarAwareElementType createLongAlternative_Val2IDTerminalRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val2IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal2IDTerminalRuleCall_2_1_1_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Group_2_2ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Group_2_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getGroup_2_2());
		}
		public static IGrammarAwareElementType createLongAlternative_Kw3Keyword_2_2_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Kw3Keyword_2_2_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getKw3Keyword_2_2_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Val3Assignment_2_2_1ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val3Assignment_2_2_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal3Assignment_2_2_1());
		}
		public static IGrammarAwareElementType createLongAlternative_Val3IDTerminalRuleCall_2_2_1_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val3IDTerminalRuleCall_2_2_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal3IDTerminalRuleCall_2_2_1_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Group_2_3ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Group_2_3_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getGroup_2_3());
		}
		public static IGrammarAwareElementType createLongAlternative_Kw4Keyword_2_3_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Kw4Keyword_2_3_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getKw4Keyword_2_3_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Val4Assignment_2_3_1ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val4Assignment_2_3_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal4Assignment_2_3_1());
		}
		public static IGrammarAwareElementType createLongAlternative_Val4IDTerminalRuleCall_2_3_1_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val4IDTerminalRuleCall_2_3_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal4IDTerminalRuleCall_2_3_1_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Group_2_4ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Group_2_4_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getGroup_2_4());
		}
		public static IGrammarAwareElementType createLongAlternative_Kw5Keyword_2_4_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Kw5Keyword_2_4_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getKw5Keyword_2_4_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Val5Assignment_2_4_1ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val5Assignment_2_4_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal5Assignment_2_4_1());
		}
		public static IGrammarAwareElementType createLongAlternative_Val5IDTerminalRuleCall_2_4_1_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val5IDTerminalRuleCall_2_4_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal5IDTerminalRuleCall_2_4_1_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Group_2_5ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Group_2_5_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getGroup_2_5());
		}
		public static IGrammarAwareElementType createLongAlternative_Kw6Keyword_2_5_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Kw6Keyword_2_5_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getKw6Keyword_2_5_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Val6Assignment_2_5_1ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val6Assignment_2_5_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal6Assignment_2_5_1());
		}
		public static IGrammarAwareElementType createLongAlternative_Val6IDTerminalRuleCall_2_5_1_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val6IDTerminalRuleCall_2_5_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal6IDTerminalRuleCall_2_5_1_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Group_2_6ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Group_2_6_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getGroup_2_6());
		}
		public static IGrammarAwareElementType createLongAlternative_Kw7Keyword_2_6_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Kw7Keyword_2_6_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getKw7Keyword_2_6_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Val7Assignment_2_6_1ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val7Assignment_2_6_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal7Assignment_2_6_1());
		}
		public static IGrammarAwareElementType createLongAlternative_Val7IDTerminalRuleCall_2_6_1_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val7IDTerminalRuleCall_2_6_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal7IDTerminalRuleCall_2_6_1_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Group_2_7ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Group_2_7_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getGroup_2_7());
		}
		public static IGrammarAwareElementType createLongAlternative_Kw8Keyword_2_7_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Kw8Keyword_2_7_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getKw8Keyword_2_7_0());
		}
		public static IGrammarAwareElementType createLongAlternative_Val8Assignment_2_7_1ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val8Assignment_2_7_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal8Assignment_2_7_1());
		}
		public static IGrammarAwareElementType createLongAlternative_Val8IDTerminalRuleCall_2_7_1_0ElementType() {
			return new IGrammarAwareElementType("LongAlternative_Val8IDTerminalRuleCall_2_7_1_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getVal8IDTerminalRuleCall_2_7_1_0());
		}
		public static IGrammarAwareElementType createLongAlternative_ExclamationMarkKeyword_3ElementType() {
			return new IGrammarAwareElementType("LongAlternative_ExclamationMarkKeyword_3_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLongAlternativeAccess().getExclamationMarkKeyword_3());
		}
	}

	public static final IGrammarAwareElementType LongAlternative_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternativeElementType());

	public static final IGrammarAwareElementType LongAlternative_Group_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_GroupElementType());

	public static final IGrammarAwareElementType LongAlternative_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_NumberSignDigitOneDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_FooAssignment_1_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_FooAssignment_1ElementType());

	public static final IGrammarAwareElementType LongAlternative_FooIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_FooIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Alternatives_2_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Alternatives_2ElementType());

	public static final IGrammarAwareElementType LongAlternative_Group_2_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Group_2_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Kw1Keyword_2_0_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Kw1Keyword_2_0_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val1Assignment_2_0_1_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val1Assignment_2_0_1ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val1IDTerminalRuleCall_2_0_1_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val1IDTerminalRuleCall_2_0_1_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Group_2_1_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Group_2_1ElementType());

	public static final IGrammarAwareElementType LongAlternative_Kw2Keyword_2_1_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Kw2Keyword_2_1_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val2Assignment_2_1_1_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val2Assignment_2_1_1ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val2IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val2IDTerminalRuleCall_2_1_1_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Group_2_2_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Group_2_2ElementType());

	public static final IGrammarAwareElementType LongAlternative_Kw3Keyword_2_2_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Kw3Keyword_2_2_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val3Assignment_2_2_1_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val3Assignment_2_2_1ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val3IDTerminalRuleCall_2_2_1_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val3IDTerminalRuleCall_2_2_1_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Group_2_3_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Group_2_3ElementType());

	public static final IGrammarAwareElementType LongAlternative_Kw4Keyword_2_3_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Kw4Keyword_2_3_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val4Assignment_2_3_1_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val4Assignment_2_3_1ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val4IDTerminalRuleCall_2_3_1_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val4IDTerminalRuleCall_2_3_1_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Group_2_4_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Group_2_4ElementType());

	public static final IGrammarAwareElementType LongAlternative_Kw5Keyword_2_4_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Kw5Keyword_2_4_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val5Assignment_2_4_1_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val5Assignment_2_4_1ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val5IDTerminalRuleCall_2_4_1_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val5IDTerminalRuleCall_2_4_1_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Group_2_5_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Group_2_5ElementType());

	public static final IGrammarAwareElementType LongAlternative_Kw6Keyword_2_5_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Kw6Keyword_2_5_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val6Assignment_2_5_1_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val6Assignment_2_5_1ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val6IDTerminalRuleCall_2_5_1_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val6IDTerminalRuleCall_2_5_1_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Group_2_6_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Group_2_6ElementType());

	public static final IGrammarAwareElementType LongAlternative_Kw7Keyword_2_6_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Kw7Keyword_2_6_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val7Assignment_2_6_1_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val7Assignment_2_6_1ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val7IDTerminalRuleCall_2_6_1_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val7IDTerminalRuleCall_2_6_1_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Group_2_7_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Group_2_7ElementType());

	public static final IGrammarAwareElementType LongAlternative_Kw8Keyword_2_7_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Kw8Keyword_2_7_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val8Assignment_2_7_1_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val8Assignment_2_7_1ElementType());

	public static final IGrammarAwareElementType LongAlternative_Val8IDTerminalRuleCall_2_7_1_0_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_Val8IDTerminalRuleCall_2_7_1_0ElementType());

	public static final IGrammarAwareElementType LongAlternative_ExclamationMarkKeyword_3_ELEMENT_TYPE = associate(LongAlternativeFactory.createLongAlternative_ExclamationMarkKeyword_3ElementType());

	private static class ActionOnlyFactory {
		public static IGrammarAwareElementType createActionOnlyElementType() {
			return new IGrammarAwareElementType("ActionOnly_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionOnlyRule());
		}
		public static IGrammarAwareElementType createActionOnly_GroupElementType() {
			return new IGrammarAwareElementType("ActionOnly_Group_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionOnlyAccess().getGroup());
		}
		public static IGrammarAwareElementType createActionOnly_NumberSignDigitOneDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("ActionOnly_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionOnlyAccess().getNumberSignDigitOneDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createActionOnly_Kw1Keyword_1ElementType() {
			return new IGrammarAwareElementType("ActionOnly_Kw1Keyword_1_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionOnlyAccess().getKw1Keyword_1());
		}
		public static IGrammarAwareElementType createActionOnly_IDTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("ActionOnly_IDTerminalRuleCall_2_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionOnlyAccess().getIDTerminalRuleCall_2());
		}
		public static IGrammarAwareElementType createActionOnly_ActionOnlyAction_3ElementType() {
			return new IGrammarAwareElementType("ActionOnly_ActionOnlyAction_3_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionOnlyAccess().getActionOnlyAction_3());
		}
		public static IGrammarAwareElementType createActionOnly_Kw2Keyword_4ElementType() {
			return new IGrammarAwareElementType("ActionOnly_Kw2Keyword_4_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionOnlyAccess().getKw2Keyword_4());
		}
		public static IGrammarAwareElementType createActionOnly_IDTerminalRuleCall_5ElementType() {
			return new IGrammarAwareElementType("ActionOnly_IDTerminalRuleCall_5_ELEMENT_TYPE", SyntacticSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionOnlyAccess().getIDTerminalRuleCall_5());
		}
	}

	public static final IGrammarAwareElementType ActionOnly_ELEMENT_TYPE = associate(ActionOnlyFactory.createActionOnlyElementType());

	public static final IGrammarAwareElementType ActionOnly_Group_ELEMENT_TYPE = associate(ActionOnlyFactory.createActionOnly_GroupElementType());

	public static final IGrammarAwareElementType ActionOnly_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE = associate(ActionOnlyFactory.createActionOnly_NumberSignDigitOneDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType ActionOnly_Kw1Keyword_1_ELEMENT_TYPE = associate(ActionOnlyFactory.createActionOnly_Kw1Keyword_1ElementType());

	public static final IGrammarAwareElementType ActionOnly_IDTerminalRuleCall_2_ELEMENT_TYPE = associate(ActionOnlyFactory.createActionOnly_IDTerminalRuleCall_2ElementType());

	public static final IGrammarAwareElementType ActionOnly_ActionOnlyAction_3_ELEMENT_TYPE = associate(ActionOnlyFactory.createActionOnly_ActionOnlyAction_3ElementType());

	public static final IGrammarAwareElementType ActionOnly_Kw2Keyword_4_ELEMENT_TYPE = associate(ActionOnlyFactory.createActionOnly_Kw2Keyword_4ElementType());

	public static final IGrammarAwareElementType ActionOnly_IDTerminalRuleCall_5_ELEMENT_TYPE = associate(ActionOnlyFactory.createActionOnly_IDTerminalRuleCall_5ElementType());

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

	public IGrammarAwareElementType getModel_X1Assignment_0ElementType() {
		return Model_X1Assignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X1MandatoryKeywordsParserRuleCall_0_0ElementType() {
		return Model_X1MandatoryKeywordsParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X2Assignment_1ElementType() {
		return Model_X2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X2Exp0ParserRuleCall_1_0ElementType() {
		return Model_X2Exp0ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X3Assignment_2ElementType() {
		return Model_X3Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X3Exp1ParserRuleCall_2_0ElementType() {
		return Model_X3Exp1ParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X4Assignment_3ElementType() {
		return Model_X4Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X4Exp2ParserRuleCall_3_0ElementType() {
		return Model_X4Exp2ParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X5Assignment_4ElementType() {
		return Model_X5Assignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X5SingleCrossReferenceParserRuleCall_4_0ElementType() {
		return Model_X5SingleCrossReferenceParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X6Assignment_5ElementType() {
		return Model_X6Assignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X6BooleanAlternativeParserRuleCall_5_0ElementType() {
		return Model_X6BooleanAlternativeParserRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X7Assignment_6ElementType() {
		return Model_X7Assignment_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X7UnassignedDatatypeParserRuleCall_6_0ElementType() {
		return Model_X7UnassignedDatatypeParserRuleCall_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X8Assignment_7ElementType() {
		return Model_X8Assignment_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X8OptionalSingleTransitionParserRuleCall_7_0ElementType() {
		return Model_X8OptionalSingleTransitionParserRuleCall_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X9Assignment_8ElementType() {
		return Model_X9Assignment_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X9OptionalManyTransitionParserRuleCall_8_0ElementType() {
		return Model_X9OptionalManyTransitionParserRuleCall_8_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X10Assignment_9ElementType() {
		return Model_X10Assignment_9_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X10MandatoryManyTransitionParserRuleCall_9_0ElementType() {
		return Model_X10MandatoryManyTransitionParserRuleCall_9_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X11Assignment_10ElementType() {
		return Model_X11Assignment_10_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X11AlternativeTransitionParserRuleCall_10_0ElementType() {
		return Model_X11AlternativeTransitionParserRuleCall_10_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X12Assignment_11ElementType() {
		return Model_X12Assignment_11_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X12BooleanValuesParserRuleCall_11_0ElementType() {
		return Model_X12BooleanValuesParserRuleCall_11_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X13Assignment_12ElementType() {
		return Model_X13Assignment_12_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X13LongAlternativeParserRuleCall_12_0ElementType() {
		return Model_X13LongAlternativeParserRuleCall_12_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X14Assignment_13ElementType() {
		return Model_X14Assignment_13_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X14ActionOnlyParserRuleCall_13_0ElementType() {
		return Model_X14ActionOnlyParserRuleCall_13_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywordsElementType() {
		return MandatoryKeywords_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_GroupElementType() {
		return MandatoryKeywords_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_NumberSignDigitOneKeyword_0ElementType() {
		return MandatoryKeywords_NumberSignDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_Val1Assignment_1ElementType() {
		return MandatoryKeywords_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_Val1IDTerminalRuleCall_1_0ElementType() {
		return MandatoryKeywords_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_Kw1Keyword_2ElementType() {
		return MandatoryKeywords_Kw1Keyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_Val2Assignment_3ElementType() {
		return MandatoryKeywords_Val2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_Val2IDTerminalRuleCall_3_0ElementType() {
		return MandatoryKeywords_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_Kw2Keyword_4ElementType() {
		return MandatoryKeywords_Kw2Keyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_Kw3Keyword_5ElementType() {
		return MandatoryKeywords_Kw3Keyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_Val3Assignment_6ElementType() {
		return MandatoryKeywords_Val3Assignment_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_Val3IDTerminalRuleCall_6_0ElementType() {
		return MandatoryKeywords_Val3IDTerminalRuleCall_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryKeywords_Kw4Keyword_7ElementType() {
		return MandatoryKeywords_Kw4Keyword_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp0ElementType() {
		return Exp0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp0_GroupElementType() {
		return Exp0_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp0_NumberSignDigitTwoKeyword_0ElementType() {
		return Exp0_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp0_Addition0ParserRuleCall_1ElementType() {
		return Exp0_Addition0ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition0ElementType() {
		return Addition0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition0_GroupElementType() {
		return Addition0_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition0_Prim0ParserRuleCall_0ElementType() {
		return Addition0_Prim0ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition0_Group_1ElementType() {
		return Addition0_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition0_Add0LeftAction_1_0ElementType() {
		return Addition0_Add0LeftAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition0_PlusSignKeyword_1_1ElementType() {
		return Addition0_PlusSignKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition0_RightAssignment_1_2ElementType() {
		return Addition0_RightAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition0_RightPrim0ParserRuleCall_1_2_0ElementType() {
		return Addition0_RightPrim0ParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim0ElementType() {
		return Prim0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim0_GroupElementType() {
		return Prim0_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim0_Val0Action_0ElementType() {
		return Prim0_Val0Action_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim0_NameAssignment_1ElementType() {
		return Prim0_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim0_NameIDTerminalRuleCall_1_0ElementType() {
		return Prim0_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp1ElementType() {
		return Exp1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp1_GroupElementType() {
		return Exp1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp1_NumberSignDigitThreeKeyword_0ElementType() {
		return Exp1_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp1_Addition1ParserRuleCall_1ElementType() {
		return Exp1_Addition1ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition1ElementType() {
		return Addition1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition1_GroupElementType() {
		return Addition1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition1_Prim1ParserRuleCall_0ElementType() {
		return Addition1_Prim1ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition1_Group_1ElementType() {
		return Addition1_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition1_Add1LeftAction_1_0ElementType() {
		return Addition1_Add1LeftAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition1_PlusSignKeyword_1_1ElementType() {
		return Addition1_PlusSignKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition1_RightAssignment_1_2ElementType() {
		return Addition1_RightAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition1_RightPrim1ParserRuleCall_1_2_0ElementType() {
		return Addition1_RightPrim1ParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim1ElementType() {
		return Prim1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim1_AlternativesElementType() {
		return Prim1_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim1_Group_0ElementType() {
		return Prim1_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim1_Val1Action_0_0ElementType() {
		return Prim1_Val1Action_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim1_NameAssignment_0_1ElementType() {
		return Prim1_NameAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim1_NameIDTerminalRuleCall_0_1_0ElementType() {
		return Prim1_NameIDTerminalRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim1_Group_1ElementType() {
		return Prim1_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim1_LeftParenthesisKeyword_1_0ElementType() {
		return Prim1_LeftParenthesisKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim1_Addition1ParserRuleCall_1_1ElementType() {
		return Prim1_Addition1ParserRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim1_RightParenthesisKeyword_1_2ElementType() {
		return Prim1_RightParenthesisKeyword_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp2ElementType() {
		return Exp2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp2_GroupElementType() {
		return Exp2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp2_NumberSignDigitFourKeyword_0ElementType() {
		return Exp2_NumberSignDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExp2_Addition2ParserRuleCall_1ElementType() {
		return Exp2_Addition2ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition2ElementType() {
		return Addition2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition2_GroupElementType() {
		return Addition2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition2_Multiplication2ParserRuleCall_0ElementType() {
		return Addition2_Multiplication2ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition2_Group_1ElementType() {
		return Addition2_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition2_Add2LeftAction_1_0ElementType() {
		return Addition2_Add2LeftAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition2_PlusSignKeyword_1_1ElementType() {
		return Addition2_PlusSignKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition2_RightAssignment_1_2ElementType() {
		return Addition2_RightAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition2_RightMultiplication2ParserRuleCall_1_2_0ElementType() {
		return Addition2_RightMultiplication2ParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication2ElementType() {
		return Multiplication2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication2_GroupElementType() {
		return Multiplication2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication2_Prim2ParserRuleCall_0ElementType() {
		return Multiplication2_Prim2ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication2_Group_1ElementType() {
		return Multiplication2_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication2_Mult2LeftAction_1_0ElementType() {
		return Multiplication2_Mult2LeftAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication2_AsteriskKeyword_1_1ElementType() {
		return Multiplication2_AsteriskKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication2_RightAssignment_1_2ElementType() {
		return Multiplication2_RightAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication2_RightPrim2ParserRuleCall_1_2_0ElementType() {
		return Multiplication2_RightPrim2ParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim2ElementType() {
		return Prim2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim2_AlternativesElementType() {
		return Prim2_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim2_Group_0ElementType() {
		return Prim2_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim2_Val2Action_0_0ElementType() {
		return Prim2_Val2Action_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim2_NameAssignment_0_1ElementType() {
		return Prim2_NameAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim2_NameIDTerminalRuleCall_0_1_0ElementType() {
		return Prim2_NameIDTerminalRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim2_Group_1ElementType() {
		return Prim2_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim2_LeftParenthesisKeyword_1_0ElementType() {
		return Prim2_LeftParenthesisKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim2_Addition2ParserRuleCall_1_1ElementType() {
		return Prim2_Addition2ParserRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrim2_RightParenthesisKeyword_1_2ElementType() {
		return Prim2_RightParenthesisKeyword_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeIDElementType() {
		return DatatypeID_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeID_IDTerminalRuleCallElementType() {
		return DatatypeID_IDTerminalRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReferenceElementType() {
		return SingleCrossReference_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_GroupElementType() {
		return SingleCrossReference_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NumberSignDigitFiveKeyword_0ElementType() {
		return SingleCrossReference_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NameAssignment_1ElementType() {
		return SingleCrossReference_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NameAlternatives_1_0ElementType() {
		return SingleCrossReference_NameAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NameTERMINAL_IDTerminalRuleCall_1_0_0ElementType() {
		return SingleCrossReference_NameTERMINAL_IDTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NameIDTerminalRuleCall_1_0_1ElementType() {
		return SingleCrossReference_NameIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Group_2ElementType() {
		return SingleCrossReference_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Kw1Keyword_2_0ElementType() {
		return SingleCrossReference_Kw1Keyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref1Assignment_2_1ElementType() {
		return SingleCrossReference_Ref1Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0ElementType() {
		return SingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref1SingleCrossReferenceTERMINAL_IDTerminalRuleCall_2_1_0_1ElementType() {
		return SingleCrossReference_Ref1SingleCrossReferenceTERMINAL_IDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Group_3ElementType() {
		return SingleCrossReference_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Kw2Keyword_3_0ElementType() {
		return SingleCrossReference_Kw2Keyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref2Assignment_3_1ElementType() {
		return SingleCrossReference_Ref2Assignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0ElementType() {
		return SingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref2SingleCrossReferenceDatatypeIDParserRuleCall_3_1_0_1ElementType() {
		return SingleCrossReference_Ref2SingleCrossReferenceDatatypeIDParserRuleCall_3_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Group_4ElementType() {
		return SingleCrossReference_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Kw3Keyword_4_0ElementType() {
		return SingleCrossReference_Kw3Keyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref3Assignment_4_1ElementType() {
		return SingleCrossReference_Ref3Assignment_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0ElementType() {
		return SingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref3SingleCrossReferenceIDTerminalRuleCall_4_1_0_1ElementType() {
		return SingleCrossReference_Ref3SingleCrossReferenceIDTerminalRuleCall_4_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Group_5ElementType() {
		return SingleCrossReference_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Kw4Keyword_5_0ElementType() {
		return SingleCrossReference_Kw4Keyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref4Assignment_5_1ElementType() {
		return SingleCrossReference_Ref4Assignment_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref4SingleCrossReferenceCrossReference_5_1_0ElementType() {
		return SingleCrossReference_Ref4SingleCrossReferenceCrossReference_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Ref4SingleCrossReferenceIDTerminalRuleCall_5_1_0_1ElementType() {
		return SingleCrossReference_Ref4SingleCrossReferenceIDTerminalRuleCall_5_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternativeElementType() {
		return BooleanAlternative_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternative_GroupElementType() {
		return BooleanAlternative_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternative_NumberSignDigitSixKeyword_0ElementType() {
		return BooleanAlternative_NumberSignDigitSixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternative_BoolAssignment_1ElementType() {
		return BooleanAlternative_BoolAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternative_BoolBooleanAlternativeLiteralParserRuleCall_1_0ElementType() {
		return BooleanAlternative_BoolBooleanAlternativeLiteralParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternativeLiteralElementType() {
		return BooleanAlternativeLiteral_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternativeLiteral_GroupElementType() {
		return BooleanAlternativeLiteral_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternativeLiteral_BooleanAlternativeLiteralAction_0ElementType() {
		return BooleanAlternativeLiteral_BooleanAlternativeLiteralAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternativeLiteral_Alternatives_1ElementType() {
		return BooleanAlternativeLiteral_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternativeLiteral_Kw1Keyword_1_0ElementType() {
		return BooleanAlternativeLiteral_Kw1Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternativeLiteral_IsTrueAssignment_1_1ElementType() {
		return BooleanAlternativeLiteral_IsTrueAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanAlternativeLiteral_IsTrueKw2Keyword_1_1_0ElementType() {
		return BooleanAlternativeLiteral_IsTrueKw2Keyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedDatatypeElementType() {
		return UnassignedDatatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedDatatype_GroupElementType() {
		return UnassignedDatatype_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedDatatype_NumberSignDigitSevenKeyword_0ElementType() {
		return UnassignedDatatype_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedDatatype_ValAssignment_1ElementType() {
		return UnassignedDatatype_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedDatatype_ValIDTerminalRuleCall_1_0ElementType() {
		return UnassignedDatatype_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedDatatype_KW1ParserRuleCall_2ElementType() {
		return UnassignedDatatype_KW1ParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKW1ElementType() {
		return KW1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKW1_AlternativesElementType() {
		return KW1_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKW1_Kw1Keyword_0ElementType() {
		return KW1_Kw1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKW1_Group_1ElementType() {
		return KW1_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKW1_MatchedKeyword_1_0ElementType() {
		return KW1_MatchedKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKW1_INTTerminalRuleCall_1_1ElementType() {
		return KW1_INTTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalSingleTransitionElementType() {
		return OptionalSingleTransition_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalSingleTransition_GroupElementType() {
		return OptionalSingleTransition_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalSingleTransition_NumberSignDigitEightKeyword_0ElementType() {
		return OptionalSingleTransition_NumberSignDigitEightKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalSingleTransition_KW1ParserRuleCall_1ElementType() {
		return OptionalSingleTransition_KW1ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalSingleTransition_ValAssignment_2ElementType() {
		return OptionalSingleTransition_ValAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalSingleTransition_ValIDTerminalRuleCall_2_0ElementType() {
		return OptionalSingleTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalManyTransitionElementType() {
		return OptionalManyTransition_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalManyTransition_GroupElementType() {
		return OptionalManyTransition_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalManyTransition_NumberSignDigitNineKeyword_0ElementType() {
		return OptionalManyTransition_NumberSignDigitNineKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalManyTransition_KW1ParserRuleCall_1ElementType() {
		return OptionalManyTransition_KW1ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalManyTransition_ValAssignment_2ElementType() {
		return OptionalManyTransition_ValAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalManyTransition_ValIDTerminalRuleCall_2_0ElementType() {
		return OptionalManyTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryManyTransitionElementType() {
		return MandatoryManyTransition_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryManyTransition_GroupElementType() {
		return MandatoryManyTransition_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryManyTransition_NumberSignDigitOneDigitZeroKeyword_0ElementType() {
		return MandatoryManyTransition_NumberSignDigitOneDigitZeroKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryManyTransition_KW1ParserRuleCall_1ElementType() {
		return MandatoryManyTransition_KW1ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryManyTransition_ValAssignment_2ElementType() {
		return MandatoryManyTransition_ValAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMandatoryManyTransition_ValIDTerminalRuleCall_2_0ElementType() {
		return MandatoryManyTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeTransitionElementType() {
		return AlternativeTransition_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeTransition_GroupElementType() {
		return AlternativeTransition_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeTransition_NumberSignDigitOneDigitOneKeyword_0ElementType() {
		return AlternativeTransition_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeTransition_Alternatives_1ElementType() {
		return AlternativeTransition_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeTransition_KW1ParserRuleCall_1_0ElementType() {
		return AlternativeTransition_KW1ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeTransition_Kw2Keyword_1_1ElementType() {
		return AlternativeTransition_Kw2Keyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeTransition_ValAssignment_2ElementType() {
		return AlternativeTransition_ValAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeTransition_ValIDTerminalRuleCall_2_0ElementType() {
		return AlternativeTransition_ValIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanDatatypeIDElementType() {
		return BooleanDatatypeID_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanDatatypeID_IDTerminalRuleCallElementType() {
		return BooleanDatatypeID_IDTerminalRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanValuesElementType() {
		return BooleanValues_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanValues_GroupElementType() {
		return BooleanValues_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanValues_BooleanValuesAction_0ElementType() {
		return BooleanValues_BooleanValuesAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanValues_NumberSignDigitOneDigitTwoKeyword_1ElementType() {
		return BooleanValues_NumberSignDigitOneDigitTwoKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanValues_Val1Assignment_2ElementType() {
		return BooleanValues_Val1Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanValues_Val1Kw1Keyword_2_0ElementType() {
		return BooleanValues_Val1Kw1Keyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanValues_Val2Assignment_3ElementType() {
		return BooleanValues_Val2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanValues_Val2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0ElementType() {
		return BooleanValues_Val2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanValues_Val3Assignment_4ElementType() {
		return BooleanValues_Val3Assignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanValues_Val3BooleanDatatypeIDParserRuleCall_4_0ElementType() {
		return BooleanValues_Val3BooleanDatatypeIDParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternativeElementType() {
		return LongAlternative_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_GroupElementType() {
		return LongAlternative_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_NumberSignDigitOneDigitThreeKeyword_0ElementType() {
		return LongAlternative_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_FooAssignment_1ElementType() {
		return LongAlternative_FooAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_FooIDTerminalRuleCall_1_0ElementType() {
		return LongAlternative_FooIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Alternatives_2ElementType() {
		return LongAlternative_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Group_2_0ElementType() {
		return LongAlternative_Group_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Kw1Keyword_2_0_0ElementType() {
		return LongAlternative_Kw1Keyword_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val1Assignment_2_0_1ElementType() {
		return LongAlternative_Val1Assignment_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val1IDTerminalRuleCall_2_0_1_0ElementType() {
		return LongAlternative_Val1IDTerminalRuleCall_2_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Group_2_1ElementType() {
		return LongAlternative_Group_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Kw2Keyword_2_1_0ElementType() {
		return LongAlternative_Kw2Keyword_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val2Assignment_2_1_1ElementType() {
		return LongAlternative_Val2Assignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val2IDTerminalRuleCall_2_1_1_0ElementType() {
		return LongAlternative_Val2IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Group_2_2ElementType() {
		return LongAlternative_Group_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Kw3Keyword_2_2_0ElementType() {
		return LongAlternative_Kw3Keyword_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val3Assignment_2_2_1ElementType() {
		return LongAlternative_Val3Assignment_2_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val3IDTerminalRuleCall_2_2_1_0ElementType() {
		return LongAlternative_Val3IDTerminalRuleCall_2_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Group_2_3ElementType() {
		return LongAlternative_Group_2_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Kw4Keyword_2_3_0ElementType() {
		return LongAlternative_Kw4Keyword_2_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val4Assignment_2_3_1ElementType() {
		return LongAlternative_Val4Assignment_2_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val4IDTerminalRuleCall_2_3_1_0ElementType() {
		return LongAlternative_Val4IDTerminalRuleCall_2_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Group_2_4ElementType() {
		return LongAlternative_Group_2_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Kw5Keyword_2_4_0ElementType() {
		return LongAlternative_Kw5Keyword_2_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val5Assignment_2_4_1ElementType() {
		return LongAlternative_Val5Assignment_2_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val5IDTerminalRuleCall_2_4_1_0ElementType() {
		return LongAlternative_Val5IDTerminalRuleCall_2_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Group_2_5ElementType() {
		return LongAlternative_Group_2_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Kw6Keyword_2_5_0ElementType() {
		return LongAlternative_Kw6Keyword_2_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val6Assignment_2_5_1ElementType() {
		return LongAlternative_Val6Assignment_2_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val6IDTerminalRuleCall_2_5_1_0ElementType() {
		return LongAlternative_Val6IDTerminalRuleCall_2_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Group_2_6ElementType() {
		return LongAlternative_Group_2_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Kw7Keyword_2_6_0ElementType() {
		return LongAlternative_Kw7Keyword_2_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val7Assignment_2_6_1ElementType() {
		return LongAlternative_Val7Assignment_2_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val7IDTerminalRuleCall_2_6_1_0ElementType() {
		return LongAlternative_Val7IDTerminalRuleCall_2_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Group_2_7ElementType() {
		return LongAlternative_Group_2_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Kw8Keyword_2_7_0ElementType() {
		return LongAlternative_Kw8Keyword_2_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val8Assignment_2_7_1ElementType() {
		return LongAlternative_Val8Assignment_2_7_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_Val8IDTerminalRuleCall_2_7_1_0ElementType() {
		return LongAlternative_Val8IDTerminalRuleCall_2_7_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLongAlternative_ExclamationMarkKeyword_3ElementType() {
		return LongAlternative_ExclamationMarkKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionOnlyElementType() {
		return ActionOnly_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionOnly_GroupElementType() {
		return ActionOnly_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionOnly_NumberSignDigitOneDigitFourKeyword_0ElementType() {
		return ActionOnly_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionOnly_Kw1Keyword_1ElementType() {
		return ActionOnly_Kw1Keyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionOnly_IDTerminalRuleCall_2ElementType() {
		return ActionOnly_IDTerminalRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionOnly_ActionOnlyAction_3ElementType() {
		return ActionOnly_ActionOnlyAction_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionOnly_Kw2Keyword_4ElementType() {
		return ActionOnly_Kw2Keyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionOnly_IDTerminalRuleCall_5ElementType() {
		return ActionOnly_IDTerminalRuleCall_5_ELEMENT_TYPE;
	}

}
