package org.eclipse.xtext.serializer.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.serializer.idea.lang.psi.impl.AssignmentFinderTestLanguageFileImpl;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class AssignmentFinderTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<AssignmentFinderTestLanguageFileImpl>>(AssignmentFinderTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final AssignmentFinderTestLanguageGrammarAccess GRAMMAR_ACCESS = AssignmentFinderTestLanguageLanguage.INSTANCE.getInstance(AssignmentFinderTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroDigitZeroKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroDigitZeroKeyword_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroDigitZeroKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_KeywordValAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Model_KeywordValAssignment_0_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getKeywordValAssignment_0_1());
		}
		public static IGrammarAwareElementType createModel_KeywordValKeywordValParserRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_KeywordValKeywordValParserRuleCall_0_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getKeywordValKeywordValParserRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroDigitOneKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroDigitOneKeyword_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroDigitOneKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_TerminalValAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_TerminalValAssignment_1_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTerminalValAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_TerminalValTerminalValParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_TerminalValTerminalValParserRuleCall_1_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTerminalValTerminalValParserRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_2_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroDigitTwoKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroDigitTwoKeyword_2_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroDigitTwoKeyword_2_0());
		}
		public static IGrammarAwareElementType createModel_EnumValAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Model_EnumValAssignment_2_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEnumValAssignment_2_1());
		}
		public static IGrammarAwareElementType createModel_EnumValEnumValParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_EnumValEnumValParserRuleCall_2_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEnumValEnumValParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_3ElementType() {
			return new IGrammarAwareElementType("Model_Group_3_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroDigitThreeKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroDigitThreeKeyword_3_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroDigitThreeKeyword_3_0());
		}
		public static IGrammarAwareElementType createModel_KeywordBoolAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Model_KeywordBoolAssignment_3_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getKeywordBoolAssignment_3_1());
		}
		public static IGrammarAwareElementType createModel_KeywordBoolKeywordBoolParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Model_KeywordBoolKeywordBoolParserRuleCall_3_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getKeywordBoolKeywordBoolParserRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_4ElementType() {
			return new IGrammarAwareElementType("Model_Group_4_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroDigitFourKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroDigitFourKeyword_4_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroDigitFourKeyword_4_0());
		}
		public static IGrammarAwareElementType createModel_TerminalBoolAssignment_4_1ElementType() {
			return new IGrammarAwareElementType("Model_TerminalBoolAssignment_4_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTerminalBoolAssignment_4_1());
		}
		public static IGrammarAwareElementType createModel_TerminalBoolTerminalBoolParserRuleCall_4_1_0ElementType() {
			return new IGrammarAwareElementType("Model_TerminalBoolTerminalBoolParserRuleCall_4_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTerminalBoolTerminalBoolParserRuleCall_4_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_5ElementType() {
			return new IGrammarAwareElementType("Model_Group_5_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroDigitFiveKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroDigitFiveKeyword_5_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroDigitFiveKeyword_5_0());
		}
		public static IGrammarAwareElementType createModel_EnumBoolAssignment_5_1ElementType() {
			return new IGrammarAwareElementType("Model_EnumBoolAssignment_5_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEnumBoolAssignment_5_1());
		}
		public static IGrammarAwareElementType createModel_EnumBoolEnumBoolParserRuleCall_5_1_0ElementType() {
			return new IGrammarAwareElementType("Model_EnumBoolEnumBoolParserRuleCall_5_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEnumBoolEnumBoolParserRuleCall_5_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_6ElementType() {
			return new IGrammarAwareElementType("Model_Group_6_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_6());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroDigitSixKeyword_6_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroDigitSixKeyword_6_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroDigitSixKeyword_6_0());
		}
		public static IGrammarAwareElementType createModel_MixedBoolAssignment_6_1ElementType() {
			return new IGrammarAwareElementType("Model_MixedBoolAssignment_6_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMixedBoolAssignment_6_1());
		}
		public static IGrammarAwareElementType createModel_MixedBoolMixedBoolParserRuleCall_6_1_0ElementType() {
			return new IGrammarAwareElementType("Model_MixedBoolMixedBoolParserRuleCall_6_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMixedBoolMixedBoolParserRuleCall_6_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_7ElementType() {
			return new IGrammarAwareElementType("Model_Group_7_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_7());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroDigitSevenKeyword_7_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroDigitSevenKeyword_7_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroDigitSevenKeyword_7_0());
		}
		public static IGrammarAwareElementType createModel_MixedValueAssignment_7_1ElementType() {
			return new IGrammarAwareElementType("Model_MixedValueAssignment_7_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMixedValueAssignment_7_1());
		}
		public static IGrammarAwareElementType createModel_MixedValueMixedValueParserRuleCall_7_1_0ElementType() {
			return new IGrammarAwareElementType("Model_MixedValueMixedValueParserRuleCall_7_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMixedValueMixedValueParserRuleCall_7_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_8ElementType() {
			return new IGrammarAwareElementType("Model_Group_8_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_8());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroDigitEightKeyword_8_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroDigitEightKeyword_8_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroDigitEightKeyword_8_0());
		}
		public static IGrammarAwareElementType createModel_ContainmentRefAssignment_8_1ElementType() {
			return new IGrammarAwareElementType("Model_ContainmentRefAssignment_8_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getContainmentRefAssignment_8_1());
		}
		public static IGrammarAwareElementType createModel_ContainmentRefContainmentRefParserRuleCall_8_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ContainmentRefContainmentRefParserRuleCall_8_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getContainmentRefContainmentRefParserRuleCall_8_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_9ElementType() {
			return new IGrammarAwareElementType("Model_Group_9_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_9());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroDigitNineKeyword_9_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroDigitNineKeyword_9_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroDigitNineKeyword_9_0());
		}
		public static IGrammarAwareElementType createModel_CrossRefAssignment_9_1ElementType() {
			return new IGrammarAwareElementType("Model_CrossRefAssignment_9_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getCrossRefAssignment_9_1());
		}
		public static IGrammarAwareElementType createModel_CrossRefCrossRefParserRuleCall_9_1_0ElementType() {
			return new IGrammarAwareElementType("Model_CrossRefCrossRefParserRuleCall_9_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getCrossRefCrossRefParserRuleCall_9_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroDigitZeroKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroDigitZeroKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_KeywordValAssignment_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_KeywordValAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Model_KeywordValKeywordValParserRuleCall_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_KeywordValKeywordValParserRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroDigitOneKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroDigitOneKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_TerminalValAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_TerminalValAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_TerminalValTerminalValParserRuleCall_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_TerminalValTerminalValParserRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_2ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroDigitTwoKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroDigitTwoKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Model_EnumValAssignment_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_EnumValAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Model_EnumValEnumValParserRuleCall_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_EnumValEnumValParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_3_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_3ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroDigitThreeKeyword_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroDigitThreeKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Model_KeywordBoolAssignment_3_1_ELEMENT_TYPE = associate(ModelFactory.createModel_KeywordBoolAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Model_KeywordBoolKeywordBoolParserRuleCall_3_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_KeywordBoolKeywordBoolParserRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_4_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_4ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroDigitFourKeyword_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroDigitFourKeyword_4_0ElementType());

	public static final IGrammarAwareElementType Model_TerminalBoolAssignment_4_1_ELEMENT_TYPE = associate(ModelFactory.createModel_TerminalBoolAssignment_4_1ElementType());

	public static final IGrammarAwareElementType Model_TerminalBoolTerminalBoolParserRuleCall_4_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_TerminalBoolTerminalBoolParserRuleCall_4_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_5_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_5ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroDigitFiveKeyword_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroDigitFiveKeyword_5_0ElementType());

	public static final IGrammarAwareElementType Model_EnumBoolAssignment_5_1_ELEMENT_TYPE = associate(ModelFactory.createModel_EnumBoolAssignment_5_1ElementType());

	public static final IGrammarAwareElementType Model_EnumBoolEnumBoolParserRuleCall_5_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_EnumBoolEnumBoolParserRuleCall_5_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_6_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_6ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroDigitSixKeyword_6_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroDigitSixKeyword_6_0ElementType());

	public static final IGrammarAwareElementType Model_MixedBoolAssignment_6_1_ELEMENT_TYPE = associate(ModelFactory.createModel_MixedBoolAssignment_6_1ElementType());

	public static final IGrammarAwareElementType Model_MixedBoolMixedBoolParserRuleCall_6_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_MixedBoolMixedBoolParserRuleCall_6_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_7_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_7ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroDigitSevenKeyword_7_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroDigitSevenKeyword_7_0ElementType());

	public static final IGrammarAwareElementType Model_MixedValueAssignment_7_1_ELEMENT_TYPE = associate(ModelFactory.createModel_MixedValueAssignment_7_1ElementType());

	public static final IGrammarAwareElementType Model_MixedValueMixedValueParserRuleCall_7_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_MixedValueMixedValueParserRuleCall_7_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_8_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_8ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroDigitEightKeyword_8_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroDigitEightKeyword_8_0ElementType());

	public static final IGrammarAwareElementType Model_ContainmentRefAssignment_8_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ContainmentRefAssignment_8_1ElementType());

	public static final IGrammarAwareElementType Model_ContainmentRefContainmentRefParserRuleCall_8_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ContainmentRefContainmentRefParserRuleCall_8_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_9_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_9ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroDigitNineKeyword_9_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroDigitNineKeyword_9_0ElementType());

	public static final IGrammarAwareElementType Model_CrossRefAssignment_9_1_ELEMENT_TYPE = associate(ModelFactory.createModel_CrossRefAssignment_9_1ElementType());

	public static final IGrammarAwareElementType Model_CrossRefCrossRefParserRuleCall_9_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_CrossRefCrossRefParserRuleCall_9_1_0ElementType());

	private static class KeywordValFactory {
		public static IGrammarAwareElementType createKeywordValElementType() {
			return new IGrammarAwareElementType("KeywordVal_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordValRule());
		}
		public static IGrammarAwareElementType createKeywordVal_AlternativesElementType() {
			return new IGrammarAwareElementType("KeywordVal_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordValAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createKeywordVal_KwAssignment_0ElementType() {
			return new IGrammarAwareElementType("KeywordVal_KwAssignment_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordValAccess().getKwAssignment_0());
		}
		public static IGrammarAwareElementType createKeywordVal_KwKw1Keyword_0_0ElementType() {
			return new IGrammarAwareElementType("KeywordVal_KwKw1Keyword_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordValAccess().getKwKw1Keyword_0_0());
		}
		public static IGrammarAwareElementType createKeywordVal_KwAssignment_1ElementType() {
			return new IGrammarAwareElementType("KeywordVal_KwAssignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordValAccess().getKwAssignment_1());
		}
		public static IGrammarAwareElementType createKeywordVal_KwKw2Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("KeywordVal_KwKw2Keyword_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordValAccess().getKwKw2Keyword_1_0());
		}
	}

	public static final IGrammarAwareElementType KeywordVal_ELEMENT_TYPE = associate(KeywordValFactory.createKeywordValElementType());

	public static final IGrammarAwareElementType KeywordVal_Alternatives_ELEMENT_TYPE = associate(KeywordValFactory.createKeywordVal_AlternativesElementType());

	public static final IGrammarAwareElementType KeywordVal_KwAssignment_0_ELEMENT_TYPE = associate(KeywordValFactory.createKeywordVal_KwAssignment_0ElementType());

	public static final IGrammarAwareElementType KeywordVal_KwKw1Keyword_0_0_ELEMENT_TYPE = associate(KeywordValFactory.createKeywordVal_KwKw1Keyword_0_0ElementType());

	public static final IGrammarAwareElementType KeywordVal_KwAssignment_1_ELEMENT_TYPE = associate(KeywordValFactory.createKeywordVal_KwAssignment_1ElementType());

	public static final IGrammarAwareElementType KeywordVal_KwKw2Keyword_1_0_ELEMENT_TYPE = associate(KeywordValFactory.createKeywordVal_KwKw2Keyword_1_0ElementType());

	private static class TerminalValFactory {
		public static IGrammarAwareElementType createTerminalValElementType() {
			return new IGrammarAwareElementType("TerminalVal_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalValRule());
		}
		public static IGrammarAwareElementType createTerminalVal_AlternativesElementType() {
			return new IGrammarAwareElementType("TerminalVal_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalValAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createTerminalVal_TermAssignment_0ElementType() {
			return new IGrammarAwareElementType("TerminalVal_TermAssignment_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalValAccess().getTermAssignment_0());
		}
		public static IGrammarAwareElementType createTerminalVal_TermTerminal1TerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("TerminalVal_TermTerminal1TerminalRuleCall_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalValAccess().getTermTerminal1TerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createTerminalVal_TermAssignment_1ElementType() {
			return new IGrammarAwareElementType("TerminalVal_TermAssignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalValAccess().getTermAssignment_1());
		}
		public static IGrammarAwareElementType createTerminalVal_TermTerminal2TerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalVal_TermTerminal2TerminalRuleCall_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalValAccess().getTermTerminal2TerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTerminalVal_TermAssignment_2ElementType() {
			return new IGrammarAwareElementType("TerminalVal_TermAssignment_2_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalValAccess().getTermAssignment_2());
		}
		public static IGrammarAwareElementType createTerminalVal_TermFooKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("TerminalVal_TermFooKeyword_2_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalValAccess().getTermFooKeyword_2_0());
		}
	}

	public static final IGrammarAwareElementType TerminalVal_ELEMENT_TYPE = associate(TerminalValFactory.createTerminalValElementType());

	public static final IGrammarAwareElementType TerminalVal_Alternatives_ELEMENT_TYPE = associate(TerminalValFactory.createTerminalVal_AlternativesElementType());

	public static final IGrammarAwareElementType TerminalVal_TermAssignment_0_ELEMENT_TYPE = associate(TerminalValFactory.createTerminalVal_TermAssignment_0ElementType());

	public static final IGrammarAwareElementType TerminalVal_TermTerminal1TerminalRuleCall_0_0_ELEMENT_TYPE = associate(TerminalValFactory.createTerminalVal_TermTerminal1TerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType TerminalVal_TermAssignment_1_ELEMENT_TYPE = associate(TerminalValFactory.createTerminalVal_TermAssignment_1ElementType());

	public static final IGrammarAwareElementType TerminalVal_TermTerminal2TerminalRuleCall_1_0_ELEMENT_TYPE = associate(TerminalValFactory.createTerminalVal_TermTerminal2TerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TerminalVal_TermAssignment_2_ELEMENT_TYPE = associate(TerminalValFactory.createTerminalVal_TermAssignment_2ElementType());

	public static final IGrammarAwareElementType TerminalVal_TermFooKeyword_2_0_ELEMENT_TYPE = associate(TerminalValFactory.createTerminalVal_TermFooKeyword_2_0ElementType());

	private static class EnumValFactory {
		public static IGrammarAwareElementType createEnumValElementType() {
			return new IGrammarAwareElementType("EnumVal_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumValRule());
		}
		public static IGrammarAwareElementType createEnumVal_AlternativesElementType() {
			return new IGrammarAwareElementType("EnumVal_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumValAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createEnumVal_EnAssignment_0ElementType() {
			return new IGrammarAwareElementType("EnumVal_EnAssignment_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumValAccess().getEnAssignment_0());
		}
		public static IGrammarAwareElementType createEnumVal_EnEnum1EnumRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("EnumVal_EnEnum1EnumRuleCall_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumValAccess().getEnEnum1EnumRuleCall_0_0());
		}
		public static IGrammarAwareElementType createEnumVal_EnAssignment_1ElementType() {
			return new IGrammarAwareElementType("EnumVal_EnAssignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumValAccess().getEnAssignment_1());
		}
		public static IGrammarAwareElementType createEnumVal_EnEnum2EnumRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("EnumVal_EnEnum2EnumRuleCall_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumValAccess().getEnEnum2EnumRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType EnumVal_ELEMENT_TYPE = associate(EnumValFactory.createEnumValElementType());

	public static final IGrammarAwareElementType EnumVal_Alternatives_ELEMENT_TYPE = associate(EnumValFactory.createEnumVal_AlternativesElementType());

	public static final IGrammarAwareElementType EnumVal_EnAssignment_0_ELEMENT_TYPE = associate(EnumValFactory.createEnumVal_EnAssignment_0ElementType());

	public static final IGrammarAwareElementType EnumVal_EnEnum1EnumRuleCall_0_0_ELEMENT_TYPE = associate(EnumValFactory.createEnumVal_EnEnum1EnumRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType EnumVal_EnAssignment_1_ELEMENT_TYPE = associate(EnumValFactory.createEnumVal_EnAssignment_1ElementType());

	public static final IGrammarAwareElementType EnumVal_EnEnum2EnumRuleCall_1_0_ELEMENT_TYPE = associate(EnumValFactory.createEnumVal_EnEnum2EnumRuleCall_1_0ElementType());

	private static class Enum1Factory {
		public static IGrammarAwareElementType createEnum1ElementType() {
			return new IGrammarAwareElementType("Enum1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Rule());
		}
		public static IGrammarAwareElementType createEnum1_Lit1EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("Enum1_Lit1EnumLiteralDeclaration_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Access().getLit1EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createEnum1_Lit1Lit1Keyword_0ElementType() {
			return new IGrammarAwareElementType("Enum1_Lit1Lit1Keyword_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Access().getLit1Lit1Keyword_0());
		}
	}

	public static final IGrammarAwareElementType Enum1_ELEMENT_TYPE = associate(Enum1Factory.createEnum1ElementType());

	public static final IGrammarAwareElementType Enum1_Lit1EnumLiteralDeclaration_ELEMENT_TYPE = associate(Enum1Factory.createEnum1_Lit1EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType Enum1_Lit1Lit1Keyword_0_ELEMENT_TYPE = associate(Enum1Factory.createEnum1_Lit1Lit1Keyword_0ElementType());

	private static class Enum2Factory {
		public static IGrammarAwareElementType createEnum2ElementType() {
			return new IGrammarAwareElementType("Enum2_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum2Rule());
		}
		public static IGrammarAwareElementType createEnum2_Lit2EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("Enum2_Lit2EnumLiteralDeclaration_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum2Access().getLit2EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createEnum2_Lit2Lit2Keyword_0ElementType() {
			return new IGrammarAwareElementType("Enum2_Lit2Lit2Keyword_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum2Access().getLit2Lit2Keyword_0());
		}
	}

	public static final IGrammarAwareElementType Enum2_ELEMENT_TYPE = associate(Enum2Factory.createEnum2ElementType());

	public static final IGrammarAwareElementType Enum2_Lit2EnumLiteralDeclaration_ELEMENT_TYPE = associate(Enum2Factory.createEnum2_Lit2EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType Enum2_Lit2Lit2Keyword_0_ELEMENT_TYPE = associate(Enum2Factory.createEnum2_Lit2Lit2Keyword_0ElementType());

	private static class Enum3Factory {
		public static IGrammarAwareElementType createEnum3ElementType() {
			return new IGrammarAwareElementType("Enum3_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum3Rule());
		}
		public static IGrammarAwareElementType createEnum3_Lit3EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("Enum3_Lit3EnumLiteralDeclaration_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum3Access().getLit3EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createEnum3_Lit3Lit3Keyword_0ElementType() {
			return new IGrammarAwareElementType("Enum3_Lit3Lit3Keyword_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum3Access().getLit3Lit3Keyword_0());
		}
	}

	public static final IGrammarAwareElementType Enum3_ELEMENT_TYPE = associate(Enum3Factory.createEnum3ElementType());

	public static final IGrammarAwareElementType Enum3_Lit3EnumLiteralDeclaration_ELEMENT_TYPE = associate(Enum3Factory.createEnum3_Lit3EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType Enum3_Lit3Lit3Keyword_0_ELEMENT_TYPE = associate(Enum3Factory.createEnum3_Lit3Lit3Keyword_0ElementType());

	private static class KeywordBoolFactory {
		public static IGrammarAwareElementType createKeywordBoolElementType() {
			return new IGrammarAwareElementType("KeywordBool_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordBoolRule());
		}
		public static IGrammarAwareElementType createKeywordBool_AlternativesElementType() {
			return new IGrammarAwareElementType("KeywordBool_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordBoolAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createKeywordBool_KwAssignment_0ElementType() {
			return new IGrammarAwareElementType("KeywordBool_KwAssignment_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordBoolAccess().getKwAssignment_0());
		}
		public static IGrammarAwareElementType createKeywordBool_KwKw1Keyword_0_0ElementType() {
			return new IGrammarAwareElementType("KeywordBool_KwKw1Keyword_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordBoolAccess().getKwKw1Keyword_0_0());
		}
		public static IGrammarAwareElementType createKeywordBool_KwAssignment_1ElementType() {
			return new IGrammarAwareElementType("KeywordBool_KwAssignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordBoolAccess().getKwAssignment_1());
		}
		public static IGrammarAwareElementType createKeywordBool_KwKw2Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("KeywordBool_KwKw2Keyword_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordBoolAccess().getKwKw2Keyword_1_0());
		}
	}

	public static final IGrammarAwareElementType KeywordBool_ELEMENT_TYPE = associate(KeywordBoolFactory.createKeywordBoolElementType());

	public static final IGrammarAwareElementType KeywordBool_Alternatives_ELEMENT_TYPE = associate(KeywordBoolFactory.createKeywordBool_AlternativesElementType());

	public static final IGrammarAwareElementType KeywordBool_KwAssignment_0_ELEMENT_TYPE = associate(KeywordBoolFactory.createKeywordBool_KwAssignment_0ElementType());

	public static final IGrammarAwareElementType KeywordBool_KwKw1Keyword_0_0_ELEMENT_TYPE = associate(KeywordBoolFactory.createKeywordBool_KwKw1Keyword_0_0ElementType());

	public static final IGrammarAwareElementType KeywordBool_KwAssignment_1_ELEMENT_TYPE = associate(KeywordBoolFactory.createKeywordBool_KwAssignment_1ElementType());

	public static final IGrammarAwareElementType KeywordBool_KwKw2Keyword_1_0_ELEMENT_TYPE = associate(KeywordBoolFactory.createKeywordBool_KwKw2Keyword_1_0ElementType());

	private static class TerminalBoolFactory {
		public static IGrammarAwareElementType createTerminalBoolElementType() {
			return new IGrammarAwareElementType("TerminalBool_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalBoolRule());
		}
		public static IGrammarAwareElementType createTerminalBool_AlternativesElementType() {
			return new IGrammarAwareElementType("TerminalBool_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalBoolAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createTerminalBool_TermAssignment_0ElementType() {
			return new IGrammarAwareElementType("TerminalBool_TermAssignment_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalBoolAccess().getTermAssignment_0());
		}
		public static IGrammarAwareElementType createTerminalBool_TermTerminal1TerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("TerminalBool_TermTerminal1TerminalRuleCall_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalBoolAccess().getTermTerminal1TerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createTerminalBool_TermAssignment_1ElementType() {
			return new IGrammarAwareElementType("TerminalBool_TermAssignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalBoolAccess().getTermAssignment_1());
		}
		public static IGrammarAwareElementType createTerminalBool_TermTerminal2TerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalBool_TermTerminal2TerminalRuleCall_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalBoolAccess().getTermTerminal2TerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTerminalBool_TermAssignment_2ElementType() {
			return new IGrammarAwareElementType("TerminalBool_TermAssignment_2_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalBoolAccess().getTermAssignment_2());
		}
		public static IGrammarAwareElementType createTerminalBool_TermFooKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("TerminalBool_TermFooKeyword_2_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalBoolAccess().getTermFooKeyword_2_0());
		}
	}

	public static final IGrammarAwareElementType TerminalBool_ELEMENT_TYPE = associate(TerminalBoolFactory.createTerminalBoolElementType());

	public static final IGrammarAwareElementType TerminalBool_Alternatives_ELEMENT_TYPE = associate(TerminalBoolFactory.createTerminalBool_AlternativesElementType());

	public static final IGrammarAwareElementType TerminalBool_TermAssignment_0_ELEMENT_TYPE = associate(TerminalBoolFactory.createTerminalBool_TermAssignment_0ElementType());

	public static final IGrammarAwareElementType TerminalBool_TermTerminal1TerminalRuleCall_0_0_ELEMENT_TYPE = associate(TerminalBoolFactory.createTerminalBool_TermTerminal1TerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType TerminalBool_TermAssignment_1_ELEMENT_TYPE = associate(TerminalBoolFactory.createTerminalBool_TermAssignment_1ElementType());

	public static final IGrammarAwareElementType TerminalBool_TermTerminal2TerminalRuleCall_1_0_ELEMENT_TYPE = associate(TerminalBoolFactory.createTerminalBool_TermTerminal2TerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TerminalBool_TermAssignment_2_ELEMENT_TYPE = associate(TerminalBoolFactory.createTerminalBool_TermAssignment_2ElementType());

	public static final IGrammarAwareElementType TerminalBool_TermFooKeyword_2_0_ELEMENT_TYPE = associate(TerminalBoolFactory.createTerminalBool_TermFooKeyword_2_0ElementType());

	private static class EnumBoolFactory {
		public static IGrammarAwareElementType createEnumBoolElementType() {
			return new IGrammarAwareElementType("EnumBool_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBoolRule());
		}
		public static IGrammarAwareElementType createEnumBool_AlternativesElementType() {
			return new IGrammarAwareElementType("EnumBool_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBoolAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createEnumBool_EnAssignment_0ElementType() {
			return new IGrammarAwareElementType("EnumBool_EnAssignment_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBoolAccess().getEnAssignment_0());
		}
		public static IGrammarAwareElementType createEnumBool_EnEnum1EnumRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("EnumBool_EnEnum1EnumRuleCall_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBoolAccess().getEnEnum1EnumRuleCall_0_0());
		}
		public static IGrammarAwareElementType createEnumBool_EnAssignment_1ElementType() {
			return new IGrammarAwareElementType("EnumBool_EnAssignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBoolAccess().getEnAssignment_1());
		}
		public static IGrammarAwareElementType createEnumBool_EnEnum2EnumRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("EnumBool_EnEnum2EnumRuleCall_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBoolAccess().getEnEnum2EnumRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType EnumBool_ELEMENT_TYPE = associate(EnumBoolFactory.createEnumBoolElementType());

	public static final IGrammarAwareElementType EnumBool_Alternatives_ELEMENT_TYPE = associate(EnumBoolFactory.createEnumBool_AlternativesElementType());

	public static final IGrammarAwareElementType EnumBool_EnAssignment_0_ELEMENT_TYPE = associate(EnumBoolFactory.createEnumBool_EnAssignment_0ElementType());

	public static final IGrammarAwareElementType EnumBool_EnEnum1EnumRuleCall_0_0_ELEMENT_TYPE = associate(EnumBoolFactory.createEnumBool_EnEnum1EnumRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType EnumBool_EnAssignment_1_ELEMENT_TYPE = associate(EnumBoolFactory.createEnumBool_EnAssignment_1ElementType());

	public static final IGrammarAwareElementType EnumBool_EnEnum2EnumRuleCall_1_0_ELEMENT_TYPE = associate(EnumBoolFactory.createEnumBool_EnEnum2EnumRuleCall_1_0ElementType());

	private static class MixedBoolFactory {
		public static IGrammarAwareElementType createMixedBoolElementType() {
			return new IGrammarAwareElementType("MixedBool_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedBoolRule());
		}
		public static IGrammarAwareElementType createMixedBool_AlternativesElementType() {
			return new IGrammarAwareElementType("MixedBool_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedBoolAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createMixedBool_ValAssignment_0ElementType() {
			return new IGrammarAwareElementType("MixedBool_ValAssignment_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedBoolAccess().getValAssignment_0());
		}
		public static IGrammarAwareElementType createMixedBool_ValKw1Keyword_0_0ElementType() {
			return new IGrammarAwareElementType("MixedBool_ValKw1Keyword_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedBoolAccess().getValKw1Keyword_0_0());
		}
		public static IGrammarAwareElementType createMixedBool_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("MixedBool_ValAssignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedBoolAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createMixedBool_ValBooleanParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("MixedBool_ValBooleanParserRuleCall_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedBoolAccess().getValBooleanParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType MixedBool_ELEMENT_TYPE = associate(MixedBoolFactory.createMixedBoolElementType());

	public static final IGrammarAwareElementType MixedBool_Alternatives_ELEMENT_TYPE = associate(MixedBoolFactory.createMixedBool_AlternativesElementType());

	public static final IGrammarAwareElementType MixedBool_ValAssignment_0_ELEMENT_TYPE = associate(MixedBoolFactory.createMixedBool_ValAssignment_0ElementType());

	public static final IGrammarAwareElementType MixedBool_ValKw1Keyword_0_0_ELEMENT_TYPE = associate(MixedBoolFactory.createMixedBool_ValKw1Keyword_0_0ElementType());

	public static final IGrammarAwareElementType MixedBool_ValAssignment_1_ELEMENT_TYPE = associate(MixedBoolFactory.createMixedBool_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType MixedBool_ValBooleanParserRuleCall_1_0_ELEMENT_TYPE = associate(MixedBoolFactory.createMixedBool_ValBooleanParserRuleCall_1_0ElementType());

	private static class BooleanFactory {
		public static IGrammarAwareElementType createBooleanElementType() {
			return new IGrammarAwareElementType("Boolean_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanRule());
		}
		public static IGrammarAwareElementType createBoolean_AlternativesElementType() {
			return new IGrammarAwareElementType("Boolean_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createBoolean_TrueKeyword_0ElementType() {
			return new IGrammarAwareElementType("Boolean_TrueKeyword_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAccess().getTrueKeyword_0());
		}
		public static IGrammarAwareElementType createBoolean_FalseKeyword_1ElementType() {
			return new IGrammarAwareElementType("Boolean_FalseKeyword_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAccess().getFalseKeyword_1());
		}
	}

	public static final IGrammarAwareElementType Boolean_ELEMENT_TYPE = associate(BooleanFactory.createBooleanElementType());

	public static final IGrammarAwareElementType Boolean_Alternatives_ELEMENT_TYPE = associate(BooleanFactory.createBoolean_AlternativesElementType());

	public static final IGrammarAwareElementType Boolean_TrueKeyword_0_ELEMENT_TYPE = associate(BooleanFactory.createBoolean_TrueKeyword_0ElementType());

	public static final IGrammarAwareElementType Boolean_FalseKeyword_1_ELEMENT_TYPE = associate(BooleanFactory.createBoolean_FalseKeyword_1ElementType());

	private static class MixedValueFactory {
		public static IGrammarAwareElementType createMixedValueElementType() {
			return new IGrammarAwareElementType("MixedValue_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedValueRule());
		}
		public static IGrammarAwareElementType createMixedValue_AlternativesElementType() {
			return new IGrammarAwareElementType("MixedValue_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedValueAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createMixedValue_ValAssignment_0ElementType() {
			return new IGrammarAwareElementType("MixedValue_ValAssignment_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedValueAccess().getValAssignment_0());
		}
		public static IGrammarAwareElementType createMixedValue_ValEnum1EnumRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("MixedValue_ValEnum1EnumRuleCall_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedValueAccess().getValEnum1EnumRuleCall_0_0());
		}
		public static IGrammarAwareElementType createMixedValue_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("MixedValue_ValAssignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedValueAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createMixedValue_ValDatEnumParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("MixedValue_ValDatEnumParserRuleCall_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedValueAccess().getValDatEnumParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType MixedValue_ELEMENT_TYPE = associate(MixedValueFactory.createMixedValueElementType());

	public static final IGrammarAwareElementType MixedValue_Alternatives_ELEMENT_TYPE = associate(MixedValueFactory.createMixedValue_AlternativesElementType());

	public static final IGrammarAwareElementType MixedValue_ValAssignment_0_ELEMENT_TYPE = associate(MixedValueFactory.createMixedValue_ValAssignment_0ElementType());

	public static final IGrammarAwareElementType MixedValue_ValEnum1EnumRuleCall_0_0_ELEMENT_TYPE = associate(MixedValueFactory.createMixedValue_ValEnum1EnumRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType MixedValue_ValAssignment_1_ELEMENT_TYPE = associate(MixedValueFactory.createMixedValue_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType MixedValue_ValDatEnumParserRuleCall_1_0_ELEMENT_TYPE = associate(MixedValueFactory.createMixedValue_ValDatEnumParserRuleCall_1_0ElementType());

	private static class DatEnumFactory {
		public static IGrammarAwareElementType createDatEnumElementType() {
			return new IGrammarAwareElementType("DatEnum_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatEnumRule());
		}
		public static IGrammarAwareElementType createDatEnum_Lit3KeywordElementType() {
			return new IGrammarAwareElementType("DatEnum_Lit3Keyword_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatEnumAccess().getLit3Keyword());
		}
	}

	public static final IGrammarAwareElementType DatEnum_ELEMENT_TYPE = associate(DatEnumFactory.createDatEnumElementType());

	public static final IGrammarAwareElementType DatEnum_Lit3Keyword_ELEMENT_TYPE = associate(DatEnumFactory.createDatEnum_Lit3KeywordElementType());

	private static class ContainmentRefFactory {
		public static IGrammarAwareElementType createContainmentRefElementType() {
			return new IGrammarAwareElementType("ContainmentRef_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRefRule());
		}
		public static IGrammarAwareElementType createContainmentRef_AlternativesElementType() {
			return new IGrammarAwareElementType("ContainmentRef_Alternatives_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRefAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createContainmentRef_CtxAssignment_0ElementType() {
			return new IGrammarAwareElementType("ContainmentRef_CtxAssignment_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRefAccess().getCtxAssignment_0());
		}
		public static IGrammarAwareElementType createContainmentRef_CtxContainmentRef1ParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("ContainmentRef_CtxContainmentRef1ParserRuleCall_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRefAccess().getCtxContainmentRef1ParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createContainmentRef_CtxAssignment_1ElementType() {
			return new IGrammarAwareElementType("ContainmentRef_CtxAssignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRefAccess().getCtxAssignment_1());
		}
		public static IGrammarAwareElementType createContainmentRef_CtxContainmentRef2ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ContainmentRef_CtxContainmentRef2ParserRuleCall_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRefAccess().getCtxContainmentRef2ParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType ContainmentRef_ELEMENT_TYPE = associate(ContainmentRefFactory.createContainmentRefElementType());

	public static final IGrammarAwareElementType ContainmentRef_Alternatives_ELEMENT_TYPE = associate(ContainmentRefFactory.createContainmentRef_AlternativesElementType());

	public static final IGrammarAwareElementType ContainmentRef_CtxAssignment_0_ELEMENT_TYPE = associate(ContainmentRefFactory.createContainmentRef_CtxAssignment_0ElementType());

	public static final IGrammarAwareElementType ContainmentRef_CtxContainmentRef1ParserRuleCall_0_0_ELEMENT_TYPE = associate(ContainmentRefFactory.createContainmentRef_CtxContainmentRef1ParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType ContainmentRef_CtxAssignment_1_ELEMENT_TYPE = associate(ContainmentRefFactory.createContainmentRef_CtxAssignment_1ElementType());

	public static final IGrammarAwareElementType ContainmentRef_CtxContainmentRef2ParserRuleCall_1_0_ELEMENT_TYPE = associate(ContainmentRefFactory.createContainmentRef_CtxContainmentRef2ParserRuleCall_1_0ElementType());

	private static class ContainmentRef1Factory {
		public static IGrammarAwareElementType createContainmentRef1ElementType() {
			return new IGrammarAwareElementType("ContainmentRef1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRef1Rule());
		}
		public static IGrammarAwareElementType createContainmentRef1_GroupElementType() {
			return new IGrammarAwareElementType("ContainmentRef1_Group_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRef1Access().getGroup());
		}
		public static IGrammarAwareElementType createContainmentRef1_Kw1Keyword_0ElementType() {
			return new IGrammarAwareElementType("ContainmentRef1_Kw1Keyword_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRef1Access().getKw1Keyword_0());
		}
		public static IGrammarAwareElementType createContainmentRef1_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("ContainmentRef1_Val1Assignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRef1Access().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createContainmentRef1_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ContainmentRef1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRef1Access().getVal1IDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType ContainmentRef1_ELEMENT_TYPE = associate(ContainmentRef1Factory.createContainmentRef1ElementType());

	public static final IGrammarAwareElementType ContainmentRef1_Group_ELEMENT_TYPE = associate(ContainmentRef1Factory.createContainmentRef1_GroupElementType());

	public static final IGrammarAwareElementType ContainmentRef1_Kw1Keyword_0_ELEMENT_TYPE = associate(ContainmentRef1Factory.createContainmentRef1_Kw1Keyword_0ElementType());

	public static final IGrammarAwareElementType ContainmentRef1_Val1Assignment_1_ELEMENT_TYPE = associate(ContainmentRef1Factory.createContainmentRef1_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType ContainmentRef1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ContainmentRef1Factory.createContainmentRef1_Val1IDTerminalRuleCall_1_0ElementType());

	private static class ContainmentRef2Factory {
		public static IGrammarAwareElementType createContainmentRef2ElementType() {
			return new IGrammarAwareElementType("ContainmentRef2_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRef2Rule());
		}
		public static IGrammarAwareElementType createContainmentRef2_GroupElementType() {
			return new IGrammarAwareElementType("ContainmentRef2_Group_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRef2Access().getGroup());
		}
		public static IGrammarAwareElementType createContainmentRef2_Kw2Keyword_0ElementType() {
			return new IGrammarAwareElementType("ContainmentRef2_Kw2Keyword_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRef2Access().getKw2Keyword_0());
		}
		public static IGrammarAwareElementType createContainmentRef2_Val2Assignment_1ElementType() {
			return new IGrammarAwareElementType("ContainmentRef2_Val2Assignment_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRef2Access().getVal2Assignment_1());
		}
		public static IGrammarAwareElementType createContainmentRef2_Val2IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ContainmentRef2_Val2IDTerminalRuleCall_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainmentRef2Access().getVal2IDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType ContainmentRef2_ELEMENT_TYPE = associate(ContainmentRef2Factory.createContainmentRef2ElementType());

	public static final IGrammarAwareElementType ContainmentRef2_Group_ELEMENT_TYPE = associate(ContainmentRef2Factory.createContainmentRef2_GroupElementType());

	public static final IGrammarAwareElementType ContainmentRef2_Kw2Keyword_0_ELEMENT_TYPE = associate(ContainmentRef2Factory.createContainmentRef2_Kw2Keyword_0ElementType());

	public static final IGrammarAwareElementType ContainmentRef2_Val2Assignment_1_ELEMENT_TYPE = associate(ContainmentRef2Factory.createContainmentRef2_Val2Assignment_1ElementType());

	public static final IGrammarAwareElementType ContainmentRef2_Val2IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ContainmentRef2Factory.createContainmentRef2_Val2IDTerminalRuleCall_1_0ElementType());

	private static class CrossRefFactory {
		public static IGrammarAwareElementType createCrossRefElementType() {
			return new IGrammarAwareElementType("CrossRef_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefRule());
		}
		public static IGrammarAwareElementType createCrossRef_GroupElementType() {
			return new IGrammarAwareElementType("CrossRef_Group_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getGroup());
		}
		public static IGrammarAwareElementType createCrossRef_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("CrossRef_NameAssignment_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createCrossRef_NameAlternatives_0_0ElementType() {
			return new IGrammarAwareElementType("CrossRef_NameAlternatives_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getNameAlternatives_0_0());
		}
		public static IGrammarAwareElementType createCrossRef_NameTerminal1TerminalRuleCall_0_0_0ElementType() {
			return new IGrammarAwareElementType("CrossRef_NameTerminal1TerminalRuleCall_0_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getNameTerminal1TerminalRuleCall_0_0_0());
		}
		public static IGrammarAwareElementType createCrossRef_NameTerminal2TerminalRuleCall_0_0_1ElementType() {
			return new IGrammarAwareElementType("CrossRef_NameTerminal2TerminalRuleCall_0_0_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getNameTerminal2TerminalRuleCall_0_0_1());
		}
		public static IGrammarAwareElementType createCrossRef_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("CrossRef_Alternatives_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createCrossRef_CrossRefAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("CrossRef_CrossRefAssignment_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getCrossRefAssignment_1_0());
		}
		public static IGrammarAwareElementType createCrossRef_CrossRefCrossRefCrossReference_1_0_0ElementType() {
			return new IGrammarAwareElementType("CrossRef_CrossRefCrossRefCrossReference_1_0_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getCrossRefCrossRefCrossReference_1_0_0());
		}
		public static IGrammarAwareElementType createCrossRef_CrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("CrossRef_CrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getCrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1());
		}
		public static IGrammarAwareElementType createCrossRef_CrossRefAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("CrossRef_CrossRefAssignment_1_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getCrossRefAssignment_1_1());
		}
		public static IGrammarAwareElementType createCrossRef_CrossRefCrossRefCrossReference_1_1_0ElementType() {
			return new IGrammarAwareElementType("CrossRef_CrossRefCrossRefCrossReference_1_1_0_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getCrossRefCrossRefCrossReference_1_1_0());
		}
		public static IGrammarAwareElementType createCrossRef_CrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("CrossRef_CrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1_ELEMENT_TYPE", AssignmentFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefAccess().getCrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1());
		}
	}

	public static final IGrammarAwareElementType CrossRef_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRefElementType());

	public static final IGrammarAwareElementType CrossRef_Group_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_GroupElementType());

	public static final IGrammarAwareElementType CrossRef_NameAssignment_0_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType CrossRef_NameAlternatives_0_0_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_NameAlternatives_0_0ElementType());

	public static final IGrammarAwareElementType CrossRef_NameTerminal1TerminalRuleCall_0_0_0_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_NameTerminal1TerminalRuleCall_0_0_0ElementType());

	public static final IGrammarAwareElementType CrossRef_NameTerminal2TerminalRuleCall_0_0_1_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_NameTerminal2TerminalRuleCall_0_0_1ElementType());

	public static final IGrammarAwareElementType CrossRef_Alternatives_1_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_Alternatives_1ElementType());

	public static final IGrammarAwareElementType CrossRef_CrossRefAssignment_1_0_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_CrossRefAssignment_1_0ElementType());

	public static final IGrammarAwareElementType CrossRef_CrossRefCrossRefCrossReference_1_0_0_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_CrossRefCrossRefCrossReference_1_0_0ElementType());

	public static final IGrammarAwareElementType CrossRef_CrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_CrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1ElementType());

	public static final IGrammarAwareElementType CrossRef_CrossRefAssignment_1_1_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_CrossRefAssignment_1_1ElementType());

	public static final IGrammarAwareElementType CrossRef_CrossRefCrossRefCrossReference_1_1_0_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_CrossRefCrossRefCrossReference_1_1_0ElementType());

	public static final IGrammarAwareElementType CrossRef_CrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1_ELEMENT_TYPE = associate(CrossRefFactory.createCrossRef_CrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1ElementType());

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

	public IGrammarAwareElementType getModel_Group_0ElementType() {
		return Model_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitZeroDigitZeroKeyword_0_0ElementType() {
		return Model_NumberSignDigitZeroDigitZeroKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_KeywordValAssignment_0_1ElementType() {
		return Model_KeywordValAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_KeywordValKeywordValParserRuleCall_0_1_0ElementType() {
		return Model_KeywordValKeywordValParserRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitZeroDigitOneKeyword_1_0ElementType() {
		return Model_NumberSignDigitZeroDigitOneKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TerminalValAssignment_1_1ElementType() {
		return Model_TerminalValAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TerminalValTerminalValParserRuleCall_1_1_0ElementType() {
		return Model_TerminalValTerminalValParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_2ElementType() {
		return Model_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitZeroDigitTwoKeyword_2_0ElementType() {
		return Model_NumberSignDigitZeroDigitTwoKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_EnumValAssignment_2_1ElementType() {
		return Model_EnumValAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_EnumValEnumValParserRuleCall_2_1_0ElementType() {
		return Model_EnumValEnumValParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_3ElementType() {
		return Model_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitZeroDigitThreeKeyword_3_0ElementType() {
		return Model_NumberSignDigitZeroDigitThreeKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_KeywordBoolAssignment_3_1ElementType() {
		return Model_KeywordBoolAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_KeywordBoolKeywordBoolParserRuleCall_3_1_0ElementType() {
		return Model_KeywordBoolKeywordBoolParserRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_4ElementType() {
		return Model_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitZeroDigitFourKeyword_4_0ElementType() {
		return Model_NumberSignDigitZeroDigitFourKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TerminalBoolAssignment_4_1ElementType() {
		return Model_TerminalBoolAssignment_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TerminalBoolTerminalBoolParserRuleCall_4_1_0ElementType() {
		return Model_TerminalBoolTerminalBoolParserRuleCall_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_5ElementType() {
		return Model_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitZeroDigitFiveKeyword_5_0ElementType() {
		return Model_NumberSignDigitZeroDigitFiveKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_EnumBoolAssignment_5_1ElementType() {
		return Model_EnumBoolAssignment_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_EnumBoolEnumBoolParserRuleCall_5_1_0ElementType() {
		return Model_EnumBoolEnumBoolParserRuleCall_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_6ElementType() {
		return Model_Group_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitZeroDigitSixKeyword_6_0ElementType() {
		return Model_NumberSignDigitZeroDigitSixKeyword_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MixedBoolAssignment_6_1ElementType() {
		return Model_MixedBoolAssignment_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MixedBoolMixedBoolParserRuleCall_6_1_0ElementType() {
		return Model_MixedBoolMixedBoolParserRuleCall_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_7ElementType() {
		return Model_Group_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitZeroDigitSevenKeyword_7_0ElementType() {
		return Model_NumberSignDigitZeroDigitSevenKeyword_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MixedValueAssignment_7_1ElementType() {
		return Model_MixedValueAssignment_7_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MixedValueMixedValueParserRuleCall_7_1_0ElementType() {
		return Model_MixedValueMixedValueParserRuleCall_7_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_8ElementType() {
		return Model_Group_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitZeroDigitEightKeyword_8_0ElementType() {
		return Model_NumberSignDigitZeroDigitEightKeyword_8_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ContainmentRefAssignment_8_1ElementType() {
		return Model_ContainmentRefAssignment_8_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ContainmentRefContainmentRefParserRuleCall_8_1_0ElementType() {
		return Model_ContainmentRefContainmentRefParserRuleCall_8_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_9ElementType() {
		return Model_Group_9_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitZeroDigitNineKeyword_9_0ElementType() {
		return Model_NumberSignDigitZeroDigitNineKeyword_9_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_CrossRefAssignment_9_1ElementType() {
		return Model_CrossRefAssignment_9_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_CrossRefCrossRefParserRuleCall_9_1_0ElementType() {
		return Model_CrossRefCrossRefParserRuleCall_9_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordValElementType() {
		return KeywordVal_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordVal_AlternativesElementType() {
		return KeywordVal_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordVal_KwAssignment_0ElementType() {
		return KeywordVal_KwAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordVal_KwKw1Keyword_0_0ElementType() {
		return KeywordVal_KwKw1Keyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordVal_KwAssignment_1ElementType() {
		return KeywordVal_KwAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordVal_KwKw2Keyword_1_0ElementType() {
		return KeywordVal_KwKw2Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalValElementType() {
		return TerminalVal_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalVal_AlternativesElementType() {
		return TerminalVal_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalVal_TermAssignment_0ElementType() {
		return TerminalVal_TermAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalVal_TermTerminal1TerminalRuleCall_0_0ElementType() {
		return TerminalVal_TermTerminal1TerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalVal_TermAssignment_1ElementType() {
		return TerminalVal_TermAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalVal_TermTerminal2TerminalRuleCall_1_0ElementType() {
		return TerminalVal_TermTerminal2TerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalVal_TermAssignment_2ElementType() {
		return TerminalVal_TermAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalVal_TermFooKeyword_2_0ElementType() {
		return TerminalVal_TermFooKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumValElementType() {
		return EnumVal_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumVal_AlternativesElementType() {
		return EnumVal_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumVal_EnAssignment_0ElementType() {
		return EnumVal_EnAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumVal_EnEnum1EnumRuleCall_0_0ElementType() {
		return EnumVal_EnEnum1EnumRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumVal_EnAssignment_1ElementType() {
		return EnumVal_EnAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumVal_EnEnum2EnumRuleCall_1_0ElementType() {
		return EnumVal_EnEnum2EnumRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1ElementType() {
		return Enum1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1_Lit1EnumLiteralDeclarationElementType() {
		return Enum1_Lit1EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1_Lit1Lit1Keyword_0ElementType() {
		return Enum1_Lit1Lit1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum2ElementType() {
		return Enum2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum2_Lit2EnumLiteralDeclarationElementType() {
		return Enum2_Lit2EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum2_Lit2Lit2Keyword_0ElementType() {
		return Enum2_Lit2Lit2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum3ElementType() {
		return Enum3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum3_Lit3EnumLiteralDeclarationElementType() {
		return Enum3_Lit3EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum3_Lit3Lit3Keyword_0ElementType() {
		return Enum3_Lit3Lit3Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordBoolElementType() {
		return KeywordBool_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordBool_AlternativesElementType() {
		return KeywordBool_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordBool_KwAssignment_0ElementType() {
		return KeywordBool_KwAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordBool_KwKw1Keyword_0_0ElementType() {
		return KeywordBool_KwKw1Keyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordBool_KwAssignment_1ElementType() {
		return KeywordBool_KwAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordBool_KwKw2Keyword_1_0ElementType() {
		return KeywordBool_KwKw2Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalBoolElementType() {
		return TerminalBool_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalBool_AlternativesElementType() {
		return TerminalBool_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalBool_TermAssignment_0ElementType() {
		return TerminalBool_TermAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalBool_TermTerminal1TerminalRuleCall_0_0ElementType() {
		return TerminalBool_TermTerminal1TerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalBool_TermAssignment_1ElementType() {
		return TerminalBool_TermAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalBool_TermTerminal2TerminalRuleCall_1_0ElementType() {
		return TerminalBool_TermTerminal2TerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalBool_TermAssignment_2ElementType() {
		return TerminalBool_TermAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalBool_TermFooKeyword_2_0ElementType() {
		return TerminalBool_TermFooKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBoolElementType() {
		return EnumBool_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBool_AlternativesElementType() {
		return EnumBool_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBool_EnAssignment_0ElementType() {
		return EnumBool_EnAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBool_EnEnum1EnumRuleCall_0_0ElementType() {
		return EnumBool_EnEnum1EnumRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBool_EnAssignment_1ElementType() {
		return EnumBool_EnAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBool_EnEnum2EnumRuleCall_1_0ElementType() {
		return EnumBool_EnEnum2EnumRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedBoolElementType() {
		return MixedBool_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedBool_AlternativesElementType() {
		return MixedBool_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedBool_ValAssignment_0ElementType() {
		return MixedBool_ValAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedBool_ValKw1Keyword_0_0ElementType() {
		return MixedBool_ValKw1Keyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedBool_ValAssignment_1ElementType() {
		return MixedBool_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedBool_ValBooleanParserRuleCall_1_0ElementType() {
		return MixedBool_ValBooleanParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanElementType() {
		return Boolean_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBoolean_AlternativesElementType() {
		return Boolean_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBoolean_TrueKeyword_0ElementType() {
		return Boolean_TrueKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBoolean_FalseKeyword_1ElementType() {
		return Boolean_FalseKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedValueElementType() {
		return MixedValue_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedValue_AlternativesElementType() {
		return MixedValue_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedValue_ValAssignment_0ElementType() {
		return MixedValue_ValAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedValue_ValEnum1EnumRuleCall_0_0ElementType() {
		return MixedValue_ValEnum1EnumRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedValue_ValAssignment_1ElementType() {
		return MixedValue_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedValue_ValDatEnumParserRuleCall_1_0ElementType() {
		return MixedValue_ValDatEnumParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatEnumElementType() {
		return DatEnum_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatEnum_Lit3KeywordElementType() {
		return DatEnum_Lit3Keyword_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRefElementType() {
		return ContainmentRef_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef_AlternativesElementType() {
		return ContainmentRef_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef_CtxAssignment_0ElementType() {
		return ContainmentRef_CtxAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef_CtxContainmentRef1ParserRuleCall_0_0ElementType() {
		return ContainmentRef_CtxContainmentRef1ParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef_CtxAssignment_1ElementType() {
		return ContainmentRef_CtxAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef_CtxContainmentRef2ParserRuleCall_1_0ElementType() {
		return ContainmentRef_CtxContainmentRef2ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef1ElementType() {
		return ContainmentRef1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef1_GroupElementType() {
		return ContainmentRef1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef1_Kw1Keyword_0ElementType() {
		return ContainmentRef1_Kw1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef1_Val1Assignment_1ElementType() {
		return ContainmentRef1_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef1_Val1IDTerminalRuleCall_1_0ElementType() {
		return ContainmentRef1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef2ElementType() {
		return ContainmentRef2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef2_GroupElementType() {
		return ContainmentRef2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef2_Kw2Keyword_0ElementType() {
		return ContainmentRef2_Kw2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef2_Val2Assignment_1ElementType() {
		return ContainmentRef2_Val2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainmentRef2_Val2IDTerminalRuleCall_1_0ElementType() {
		return ContainmentRef2_Val2IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefElementType() {
		return CrossRef_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_GroupElementType() {
		return CrossRef_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_NameAssignment_0ElementType() {
		return CrossRef_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_NameAlternatives_0_0ElementType() {
		return CrossRef_NameAlternatives_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_NameTerminal1TerminalRuleCall_0_0_0ElementType() {
		return CrossRef_NameTerminal1TerminalRuleCall_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_NameTerminal2TerminalRuleCall_0_0_1ElementType() {
		return CrossRef_NameTerminal2TerminalRuleCall_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_Alternatives_1ElementType() {
		return CrossRef_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_CrossRefAssignment_1_0ElementType() {
		return CrossRef_CrossRefAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_CrossRefCrossRefCrossReference_1_0_0ElementType() {
		return CrossRef_CrossRefCrossRefCrossReference_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_CrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1ElementType() {
		return CrossRef_CrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_CrossRefAssignment_1_1ElementType() {
		return CrossRef_CrossRefAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_CrossRefCrossRefCrossReference_1_1_0ElementType() {
		return CrossRef_CrossRefCrossRefCrossReference_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRef_CrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1ElementType() {
		return CrossRef_CrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1_ELEMENT_TYPE;
	}

}
