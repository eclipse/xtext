package org.eclipse.xtext.valueconverter.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.valueconverter.idea.lang.psi.impl.Bug250313FileImpl;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug250313ElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug250313FileImpl>>(Bug250313Language.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug250313GrammarAccess GRAMMAR_ACCESS = Bug250313Language.INSTANCE.getInstance(Bug250313GrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_DigitOneKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitOneKeyword_0_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitOneKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_0_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_0_1());
		}
		public static IGrammarAwareElementType createModel_ValueAlternatives_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueAlternatives_0_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAlternatives_0_1_0());
		}
		public static IGrammarAwareElementType createModel_ValueMykeyword1Keyword_0_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueMykeyword1Keyword_0_1_0_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueMykeyword1Keyword_0_1_0_0());
		}
		public static IGrammarAwareElementType createModel_ValueSTRINGTerminalRuleCall_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueSTRINGTerminalRuleCall_0_1_0_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueSTRINGTerminalRuleCall_0_1_0_1());
		}
		public static IGrammarAwareElementType createModel_ValueNestedDatatypeParserRuleCall_0_1_0_2ElementType() {
			return new IGrammarAwareElementType("Model_ValueNestedDatatypeParserRuleCall_0_1_0_2_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueNestedDatatypeParserRuleCall_0_1_0_2());
		}
		public static IGrammarAwareElementType createModel_ValueDatatypeParserRuleCall_0_1_0_3ElementType() {
			return new IGrammarAwareElementType("Model_ValueDatatypeParserRuleCall_0_1_0_3_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueDatatypeParserRuleCall_0_1_0_3());
		}
		public static IGrammarAwareElementType createModel_ValueIDTerminalRuleCall_0_1_0_4ElementType() {
			return new IGrammarAwareElementType("Model_ValueIDTerminalRuleCall_0_1_0_4_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueIDTerminalRuleCall_0_1_0_4());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_DigitOnePlusSignKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitOnePlusSignKeyword_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitOnePlusSignKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_MultiValueAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueAssignment_1_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_MultiValueAlternatives_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueAlternatives_1_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueAlternatives_1_1_0());
		}
		public static IGrammarAwareElementType createModel_MultiValueMykeyword1Keyword_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueMykeyword1Keyword_1_1_0_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueMykeyword1Keyword_1_1_0_0());
		}
		public static IGrammarAwareElementType createModel_MultiValueSTRINGTerminalRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueSTRINGTerminalRuleCall_1_1_0_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueSTRINGTerminalRuleCall_1_1_0_1());
		}
		public static IGrammarAwareElementType createModel_MultiValueNestedDatatypeParserRuleCall_1_1_0_2ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueNestedDatatypeParserRuleCall_1_1_0_2_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueNestedDatatypeParserRuleCall_1_1_0_2());
		}
		public static IGrammarAwareElementType createModel_MultiValueDatatypeParserRuleCall_1_1_0_3ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueDatatypeParserRuleCall_1_1_0_3_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueDatatypeParserRuleCall_1_1_0_3());
		}
		public static IGrammarAwareElementType createModel_MultiValueIDTerminalRuleCall_1_1_0_4ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueIDTerminalRuleCall_1_1_0_4_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueIDTerminalRuleCall_1_1_0_4());
		}
		public static IGrammarAwareElementType createModel_Group_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_2_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createModel_DigitTwoKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitTwoKeyword_2_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitTwoKeyword_2_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_2_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_2_1());
		}
		public static IGrammarAwareElementType createModel_ValueSTRINGTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueSTRINGTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_3ElementType() {
			return new IGrammarAwareElementType("Model_Group_3_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createModel_DigitTwoPlusSignKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitTwoPlusSignKeyword_3_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitTwoPlusSignKeyword_3_0());
		}
		public static IGrammarAwareElementType createModel_MultiValueAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueAssignment_3_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueAssignment_3_1());
		}
		public static IGrammarAwareElementType createModel_MultiValueSTRINGTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueSTRINGTerminalRuleCall_3_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueSTRINGTerminalRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_4ElementType() {
			return new IGrammarAwareElementType("Model_Group_4_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createModel_DigitThreeKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitThreeKeyword_4_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitThreeKeyword_4_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_4_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_4_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_4_1());
		}
		public static IGrammarAwareElementType createModel_ValueDatatypeParserRuleCall_4_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueDatatypeParserRuleCall_4_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueDatatypeParserRuleCall_4_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_5ElementType() {
			return new IGrammarAwareElementType("Model_Group_5_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createModel_DigitThreePlusSignKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitThreePlusSignKeyword_5_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitThreePlusSignKeyword_5_0());
		}
		public static IGrammarAwareElementType createModel_MultiValueAssignment_5_1ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueAssignment_5_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueAssignment_5_1());
		}
		public static IGrammarAwareElementType createModel_MultiValueDatatypeParserRuleCall_5_1_0ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueDatatypeParserRuleCall_5_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueDatatypeParserRuleCall_5_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_6ElementType() {
			return new IGrammarAwareElementType("Model_Group_6_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_6());
		}
		public static IGrammarAwareElementType createModel_DigitFourKeyword_6_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitFourKeyword_6_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitFourKeyword_6_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_6_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_6_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_6_1());
		}
		public static IGrammarAwareElementType createModel_ValueNestedDatatypeParserRuleCall_6_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueNestedDatatypeParserRuleCall_6_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueNestedDatatypeParserRuleCall_6_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_7ElementType() {
			return new IGrammarAwareElementType("Model_Group_7_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_7());
		}
		public static IGrammarAwareElementType createModel_DigitFourPlusSignKeyword_7_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitFourPlusSignKeyword_7_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitFourPlusSignKeyword_7_0());
		}
		public static IGrammarAwareElementType createModel_MultiValueAssignment_7_1ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueAssignment_7_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueAssignment_7_1());
		}
		public static IGrammarAwareElementType createModel_MultiValueNestedDatatypeParserRuleCall_7_1_0ElementType() {
			return new IGrammarAwareElementType("Model_MultiValueNestedDatatypeParserRuleCall_7_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiValueNestedDatatypeParserRuleCall_7_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_8ElementType() {
			return new IGrammarAwareElementType("Model_Group_8_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_8());
		}
		public static IGrammarAwareElementType createModel_Group_8_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_8_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_8_0());
		}
		public static IGrammarAwareElementType createModel_ContentKeyword_8_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ContentKeyword_8_0_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getContentKeyword_8_0_0());
		}
		public static IGrammarAwareElementType createModel_ChildrenAssignment_8_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ChildrenAssignment_8_0_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getChildrenAssignment_8_0_1());
		}
		public static IGrammarAwareElementType createModel_ChildrenChildParserRuleCall_8_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ChildrenChildParserRuleCall_8_0_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getChildrenChildParserRuleCall_8_0_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_8_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_8_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_8_1());
		}
		public static IGrammarAwareElementType createModel_RefKeyword_8_1_0ElementType() {
			return new IGrammarAwareElementType("Model_RefKeyword_8_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRefKeyword_8_1_0());
		}
		public static IGrammarAwareElementType createModel_RefAssignment_8_1_1ElementType() {
			return new IGrammarAwareElementType("Model_RefAssignment_8_1_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRefAssignment_8_1_1());
		}
		public static IGrammarAwareElementType createModel_RefAlternatives_8_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_RefAlternatives_8_1_1_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRefAlternatives_8_1_1_0());
		}
		public static IGrammarAwareElementType createModel_RefChild1CrossReference_8_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_RefChild1CrossReference_8_1_1_0_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRefChild1CrossReference_8_1_1_0_0());
		}
		public static IGrammarAwareElementType createModel_RefChild1STRINGTerminalRuleCall_8_1_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("Model_RefChild1STRINGTerminalRuleCall_8_1_1_0_0_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRefChild1STRINGTerminalRuleCall_8_1_1_0_0_1());
		}
		public static IGrammarAwareElementType createModel_RefChild2CrossReference_8_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_RefChild2CrossReference_8_1_1_0_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRefChild2CrossReference_8_1_1_0_1());
		}
		public static IGrammarAwareElementType createModel_RefChild2IDTerminalRuleCall_8_1_1_0_1_1ElementType() {
			return new IGrammarAwareElementType("Model_RefChild2IDTerminalRuleCall_8_1_1_0_1_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRefChild2IDTerminalRuleCall_8_1_1_0_1_1());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_DigitOneKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitOneKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Model_ValueAlternatives_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAlternatives_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_ValueMykeyword1Keyword_0_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueMykeyword1Keyword_0_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_ValueSTRINGTerminalRuleCall_0_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueSTRINGTerminalRuleCall_0_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_ValueNestedDatatypeParserRuleCall_0_1_0_2_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueNestedDatatypeParserRuleCall_0_1_0_2ElementType());

	public static final IGrammarAwareElementType Model_ValueDatatypeParserRuleCall_0_1_0_3_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueDatatypeParserRuleCall_0_1_0_3ElementType());

	public static final IGrammarAwareElementType Model_ValueIDTerminalRuleCall_0_1_0_4_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueIDTerminalRuleCall_0_1_0_4ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_DigitOnePlusSignKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitOnePlusSignKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_MultiValueAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_MultiValueAlternatives_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueAlternatives_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_MultiValueMykeyword1Keyword_1_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueMykeyword1Keyword_1_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_MultiValueSTRINGTerminalRuleCall_1_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueSTRINGTerminalRuleCall_1_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_MultiValueNestedDatatypeParserRuleCall_1_1_0_2_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueNestedDatatypeParserRuleCall_1_1_0_2ElementType());

	public static final IGrammarAwareElementType Model_MultiValueDatatypeParserRuleCall_1_1_0_3_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueDatatypeParserRuleCall_1_1_0_3ElementType());

	public static final IGrammarAwareElementType Model_MultiValueIDTerminalRuleCall_1_1_0_4_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueIDTerminalRuleCall_1_1_0_4ElementType());

	public static final IGrammarAwareElementType Model_Group_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_2ElementType());

	public static final IGrammarAwareElementType Model_DigitTwoKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitTwoKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Model_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueSTRINGTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_3_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_3ElementType());

	public static final IGrammarAwareElementType Model_DigitTwoPlusSignKeyword_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitTwoPlusSignKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Model_MultiValueAssignment_3_1_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Model_MultiValueSTRINGTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueSTRINGTerminalRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_4_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_4ElementType());

	public static final IGrammarAwareElementType Model_DigitThreeKeyword_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitThreeKeyword_4_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_4_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_4_1ElementType());

	public static final IGrammarAwareElementType Model_ValueDatatypeParserRuleCall_4_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueDatatypeParserRuleCall_4_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_5_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_5ElementType());

	public static final IGrammarAwareElementType Model_DigitThreePlusSignKeyword_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitThreePlusSignKeyword_5_0ElementType());

	public static final IGrammarAwareElementType Model_MultiValueAssignment_5_1_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueAssignment_5_1ElementType());

	public static final IGrammarAwareElementType Model_MultiValueDatatypeParserRuleCall_5_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueDatatypeParserRuleCall_5_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_6_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_6ElementType());

	public static final IGrammarAwareElementType Model_DigitFourKeyword_6_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitFourKeyword_6_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_6_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_6_1ElementType());

	public static final IGrammarAwareElementType Model_ValueNestedDatatypeParserRuleCall_6_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueNestedDatatypeParserRuleCall_6_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_7_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_7ElementType());

	public static final IGrammarAwareElementType Model_DigitFourPlusSignKeyword_7_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitFourPlusSignKeyword_7_0ElementType());

	public static final IGrammarAwareElementType Model_MultiValueAssignment_7_1_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueAssignment_7_1ElementType());

	public static final IGrammarAwareElementType Model_MultiValueNestedDatatypeParserRuleCall_7_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiValueNestedDatatypeParserRuleCall_7_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_8_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_8ElementType());

	public static final IGrammarAwareElementType Model_Group_8_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_8_0ElementType());

	public static final IGrammarAwareElementType Model_ContentKeyword_8_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ContentKeyword_8_0_0ElementType());

	public static final IGrammarAwareElementType Model_ChildrenAssignment_8_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ChildrenAssignment_8_0_1ElementType());

	public static final IGrammarAwareElementType Model_ChildrenChildParserRuleCall_8_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ChildrenChildParserRuleCall_8_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_8_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_8_1ElementType());

	public static final IGrammarAwareElementType Model_RefKeyword_8_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_RefKeyword_8_1_0ElementType());

	public static final IGrammarAwareElementType Model_RefAssignment_8_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_RefAssignment_8_1_1ElementType());

	public static final IGrammarAwareElementType Model_RefAlternatives_8_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_RefAlternatives_8_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_RefChild1CrossReference_8_1_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_RefChild1CrossReference_8_1_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_RefChild1STRINGTerminalRuleCall_8_1_1_0_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_RefChild1STRINGTerminalRuleCall_8_1_1_0_0_1ElementType());

	public static final IGrammarAwareElementType Model_RefChild2CrossReference_8_1_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_RefChild2CrossReference_8_1_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_RefChild2IDTerminalRuleCall_8_1_1_0_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_RefChild2IDTerminalRuleCall_8_1_1_0_1_1ElementType());

	private static class DatatypeFactory {
		public static IGrammarAwareElementType createDatatypeElementType() {
			return new IGrammarAwareElementType("Datatype_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getDatatypeRule());
		}
		public static IGrammarAwareElementType createDatatype_GroupElementType() {
			return new IGrammarAwareElementType("Datatype_Group_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createDatatype_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Datatype_IDTerminalRuleCall_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createDatatype_HyphenMinusKeyword_1ElementType() {
			return new IGrammarAwareElementType("Datatype_HyphenMinusKeyword_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getHyphenMinusKeyword_1());
		}
		public static IGrammarAwareElementType createDatatype_IDTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Datatype_IDTerminalRuleCall_2_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getIDTerminalRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType Datatype_ELEMENT_TYPE = associate(DatatypeFactory.createDatatypeElementType());

	public static final IGrammarAwareElementType Datatype_Group_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_GroupElementType());

	public static final IGrammarAwareElementType Datatype_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType Datatype_HyphenMinusKeyword_1_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_HyphenMinusKeyword_1ElementType());

	public static final IGrammarAwareElementType Datatype_IDTerminalRuleCall_2_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_IDTerminalRuleCall_2ElementType());

	private static class NestedDatatypeFactory {
		public static IGrammarAwareElementType createNestedDatatypeElementType() {
			return new IGrammarAwareElementType("NestedDatatype_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getNestedDatatypeRule());
		}
		public static IGrammarAwareElementType createNestedDatatype_GroupElementType() {
			return new IGrammarAwareElementType("NestedDatatype_Group_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getNestedDatatypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createNestedDatatype_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("NestedDatatype_IDTerminalRuleCall_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getNestedDatatypeAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createNestedDatatype_PlusSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("NestedDatatype_PlusSignKeyword_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getNestedDatatypeAccess().getPlusSignKeyword_1());
		}
		public static IGrammarAwareElementType createNestedDatatype_DatatypeParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("NestedDatatype_DatatypeParserRuleCall_2_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getNestedDatatypeAccess().getDatatypeParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType NestedDatatype_ELEMENT_TYPE = associate(NestedDatatypeFactory.createNestedDatatypeElementType());

	public static final IGrammarAwareElementType NestedDatatype_Group_ELEMENT_TYPE = associate(NestedDatatypeFactory.createNestedDatatype_GroupElementType());

	public static final IGrammarAwareElementType NestedDatatype_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(NestedDatatypeFactory.createNestedDatatype_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType NestedDatatype_PlusSignKeyword_1_ELEMENT_TYPE = associate(NestedDatatypeFactory.createNestedDatatype_PlusSignKeyword_1ElementType());

	public static final IGrammarAwareElementType NestedDatatype_DatatypeParserRuleCall_2_ELEMENT_TYPE = associate(NestedDatatypeFactory.createNestedDatatype_DatatypeParserRuleCall_2ElementType());

	private static class ChildFactory {
		public static IGrammarAwareElementType createChildElementType() {
			return new IGrammarAwareElementType("Child_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getChildRule());
		}
		public static IGrammarAwareElementType createChild_AlternativesElementType() {
			return new IGrammarAwareElementType("Child_Alternatives_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createChild_Child1ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Child_Child1ParserRuleCall_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getChild1ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createChild_Child2ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Child_Child2ParserRuleCall_1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getChild2ParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Child_ELEMENT_TYPE = associate(ChildFactory.createChildElementType());

	public static final IGrammarAwareElementType Child_Alternatives_ELEMENT_TYPE = associate(ChildFactory.createChild_AlternativesElementType());

	public static final IGrammarAwareElementType Child_Child1ParserRuleCall_0_ELEMENT_TYPE = associate(ChildFactory.createChild_Child1ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Child_Child2ParserRuleCall_1_ELEMENT_TYPE = associate(ChildFactory.createChild_Child2ParserRuleCall_1ElementType());

	private static class Child1Factory {
		public static IGrammarAwareElementType createChild1ElementType() {
			return new IGrammarAwareElementType("Child1_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getChild1Rule());
		}
		public static IGrammarAwareElementType createChild1_NameAssignmentElementType() {
			return new IGrammarAwareElementType("Child1_NameAssignment_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getChild1Access().getNameAssignment());
		}
		public static IGrammarAwareElementType createChild1_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Child1_NameIDTerminalRuleCall_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getChild1Access().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Child1_ELEMENT_TYPE = associate(Child1Factory.createChild1ElementType());

	public static final IGrammarAwareElementType Child1_NameAssignment_ELEMENT_TYPE = associate(Child1Factory.createChild1_NameAssignmentElementType());

	public static final IGrammarAwareElementType Child1_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(Child1Factory.createChild1_NameIDTerminalRuleCall_0ElementType());

	private static class Child2Factory {
		public static IGrammarAwareElementType createChild2ElementType() {
			return new IGrammarAwareElementType("Child2_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getChild2Rule());
		}
		public static IGrammarAwareElementType createChild2_NameAssignmentElementType() {
			return new IGrammarAwareElementType("Child2_NameAssignment_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getChild2Access().getNameAssignment());
		}
		public static IGrammarAwareElementType createChild2_NameSTRINGTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Child2_NameSTRINGTerminalRuleCall_0_ELEMENT_TYPE", Bug250313Language.INSTANCE, GRAMMAR_ACCESS.getChild2Access().getNameSTRINGTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Child2_ELEMENT_TYPE = associate(Child2Factory.createChild2ElementType());

	public static final IGrammarAwareElementType Child2_NameAssignment_ELEMENT_TYPE = associate(Child2Factory.createChild2_NameAssignmentElementType());

	public static final IGrammarAwareElementType Child2_NameSTRINGTerminalRuleCall_0_ELEMENT_TYPE = associate(Child2Factory.createChild2_NameSTRINGTerminalRuleCall_0ElementType());

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

	public IGrammarAwareElementType getModel_DigitOneKeyword_0_0ElementType() {
		return Model_DigitOneKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_0_1ElementType() {
		return Model_ValueAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAlternatives_0_1_0ElementType() {
		return Model_ValueAlternatives_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueMykeyword1Keyword_0_1_0_0ElementType() {
		return Model_ValueMykeyword1Keyword_0_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueSTRINGTerminalRuleCall_0_1_0_1ElementType() {
		return Model_ValueSTRINGTerminalRuleCall_0_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueNestedDatatypeParserRuleCall_0_1_0_2ElementType() {
		return Model_ValueNestedDatatypeParserRuleCall_0_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueDatatypeParserRuleCall_0_1_0_3ElementType() {
		return Model_ValueDatatypeParserRuleCall_0_1_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueIDTerminalRuleCall_0_1_0_4ElementType() {
		return Model_ValueIDTerminalRuleCall_0_1_0_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitOnePlusSignKeyword_1_0ElementType() {
		return Model_DigitOnePlusSignKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueAssignment_1_1ElementType() {
		return Model_MultiValueAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueAlternatives_1_1_0ElementType() {
		return Model_MultiValueAlternatives_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueMykeyword1Keyword_1_1_0_0ElementType() {
		return Model_MultiValueMykeyword1Keyword_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueSTRINGTerminalRuleCall_1_1_0_1ElementType() {
		return Model_MultiValueSTRINGTerminalRuleCall_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueNestedDatatypeParserRuleCall_1_1_0_2ElementType() {
		return Model_MultiValueNestedDatatypeParserRuleCall_1_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueDatatypeParserRuleCall_1_1_0_3ElementType() {
		return Model_MultiValueDatatypeParserRuleCall_1_1_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueIDTerminalRuleCall_1_1_0_4ElementType() {
		return Model_MultiValueIDTerminalRuleCall_1_1_0_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_2ElementType() {
		return Model_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitTwoKeyword_2_0ElementType() {
		return Model_DigitTwoKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_2_1ElementType() {
		return Model_ValueAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueSTRINGTerminalRuleCall_2_1_0ElementType() {
		return Model_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_3ElementType() {
		return Model_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitTwoPlusSignKeyword_3_0ElementType() {
		return Model_DigitTwoPlusSignKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueAssignment_3_1ElementType() {
		return Model_MultiValueAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueSTRINGTerminalRuleCall_3_1_0ElementType() {
		return Model_MultiValueSTRINGTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_4ElementType() {
		return Model_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitThreeKeyword_4_0ElementType() {
		return Model_DigitThreeKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_4_1ElementType() {
		return Model_ValueAssignment_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueDatatypeParserRuleCall_4_1_0ElementType() {
		return Model_ValueDatatypeParserRuleCall_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_5ElementType() {
		return Model_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitThreePlusSignKeyword_5_0ElementType() {
		return Model_DigitThreePlusSignKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueAssignment_5_1ElementType() {
		return Model_MultiValueAssignment_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueDatatypeParserRuleCall_5_1_0ElementType() {
		return Model_MultiValueDatatypeParserRuleCall_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_6ElementType() {
		return Model_Group_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitFourKeyword_6_0ElementType() {
		return Model_DigitFourKeyword_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_6_1ElementType() {
		return Model_ValueAssignment_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueNestedDatatypeParserRuleCall_6_1_0ElementType() {
		return Model_ValueNestedDatatypeParserRuleCall_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_7ElementType() {
		return Model_Group_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitFourPlusSignKeyword_7_0ElementType() {
		return Model_DigitFourPlusSignKeyword_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueAssignment_7_1ElementType() {
		return Model_MultiValueAssignment_7_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiValueNestedDatatypeParserRuleCall_7_1_0ElementType() {
		return Model_MultiValueNestedDatatypeParserRuleCall_7_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_8ElementType() {
		return Model_Group_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_8_0ElementType() {
		return Model_Group_8_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ContentKeyword_8_0_0ElementType() {
		return Model_ContentKeyword_8_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ChildrenAssignment_8_0_1ElementType() {
		return Model_ChildrenAssignment_8_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ChildrenChildParserRuleCall_8_0_1_0ElementType() {
		return Model_ChildrenChildParserRuleCall_8_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_8_1ElementType() {
		return Model_Group_8_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RefKeyword_8_1_0ElementType() {
		return Model_RefKeyword_8_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RefAssignment_8_1_1ElementType() {
		return Model_RefAssignment_8_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RefAlternatives_8_1_1_0ElementType() {
		return Model_RefAlternatives_8_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RefChild1CrossReference_8_1_1_0_0ElementType() {
		return Model_RefChild1CrossReference_8_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RefChild1STRINGTerminalRuleCall_8_1_1_0_0_1ElementType() {
		return Model_RefChild1STRINGTerminalRuleCall_8_1_1_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RefChild2CrossReference_8_1_1_0_1ElementType() {
		return Model_RefChild2CrossReference_8_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RefChild2IDTerminalRuleCall_8_1_1_0_1_1ElementType() {
		return Model_RefChild2IDTerminalRuleCall_8_1_1_0_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeElementType() {
		return Datatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_GroupElementType() {
		return Datatype_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_IDTerminalRuleCall_0ElementType() {
		return Datatype_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_HyphenMinusKeyword_1ElementType() {
		return Datatype_HyphenMinusKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_IDTerminalRuleCall_2ElementType() {
		return Datatype_IDTerminalRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedDatatypeElementType() {
		return NestedDatatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedDatatype_GroupElementType() {
		return NestedDatatype_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedDatatype_IDTerminalRuleCall_0ElementType() {
		return NestedDatatype_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedDatatype_PlusSignKeyword_1ElementType() {
		return NestedDatatype_PlusSignKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedDatatype_DatatypeParserRuleCall_2ElementType() {
		return NestedDatatype_DatatypeParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildElementType() {
		return Child_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_AlternativesElementType() {
		return Child_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_Child1ParserRuleCall_0ElementType() {
		return Child_Child1ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_Child2ParserRuleCall_1ElementType() {
		return Child_Child2ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild1ElementType() {
		return Child1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild1_NameAssignmentElementType() {
		return Child1_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild1_NameIDTerminalRuleCall_0ElementType() {
		return Child1_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild2ElementType() {
		return Child2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild2_NameAssignmentElementType() {
		return Child2_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild2_NameSTRINGTerminalRuleCall_0ElementType() {
		return Child2_NameSTRINGTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
