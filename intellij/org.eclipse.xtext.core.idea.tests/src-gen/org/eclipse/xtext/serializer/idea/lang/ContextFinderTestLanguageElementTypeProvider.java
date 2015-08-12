package org.eclipse.xtext.serializer.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.serializer.idea.lang.psi.impl.ContextFinderTestLanguageFileImpl;
import org.eclipse.xtext.serializer.services.ContextFinderTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class ContextFinderTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<ContextFinderTestLanguageFileImpl>>(ContextFinderTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final ContextFinderTestLanguageGrammarAccess GRAMMAR_ACCESS = ContextFinderTestLanguageLanguage.INSTANCE.getInstance(ContextFinderTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitZeroKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitZeroKeyword_0_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitZeroKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_ModelAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ModelAssignment_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelAssignment_0_1());
		}
		public static IGrammarAwareElementType createModel_ModelModel2ParserRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelModel2ParserRuleCall_0_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelModel2ParserRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitOneKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitOneKeyword_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitOneKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_AttributeExclusionAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_AttributeExclusionAssignment_1_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributeExclusionAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_AttributeExclusionAlternatives_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_AttributeExclusionAlternatives_1_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributeExclusionAlternatives_1_1_0());
		}
		public static IGrammarAwareElementType createModel_AttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_AttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createModel_AttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_AttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1());
		}
		public static IGrammarAwareElementType createModel_Group_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitTwoKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitTwoKeyword_2_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitTwoKeyword_2_0());
		}
		public static IGrammarAwareElementType createModel_NestedTypeAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Model_NestedTypeAssignment_2_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedTypeAssignment_2_1());
		}
		public static IGrammarAwareElementType createModel_NestedTypeAlternatives_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_NestedTypeAlternatives_2_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedTypeAlternatives_2_1_0());
		}
		public static IGrammarAwareElementType createModel_NestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_NestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0());
		}
		public static IGrammarAwareElementType createModel_NestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_NestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1());
		}
		public static IGrammarAwareElementType createModel_Group_3ElementType() {
			return new IGrammarAwareElementType("Model_Group_3_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitThreeKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitThreeKeyword_3_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitThreeKeyword_3_0());
		}
		public static IGrammarAwareElementType createModel_NestedTypeRecursiveTest2Assignment_3_1ElementType() {
			return new IGrammarAwareElementType("Model_NestedTypeRecursiveTest2Assignment_3_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedTypeRecursiveTest2Assignment_3_1());
		}
		public static IGrammarAwareElementType createModel_NestedTypeRecursiveTest2Alternatives_3_1_0ElementType() {
			return new IGrammarAwareElementType("Model_NestedTypeRecursiveTest2Alternatives_3_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedTypeRecursiveTest2Alternatives_3_1_0());
		}
		public static IGrammarAwareElementType createModel_NestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_NestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0());
		}
		public static IGrammarAwareElementType createModel_NestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_NestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1());
		}
		public static IGrammarAwareElementType createModel_Group_4ElementType() {
			return new IGrammarAwareElementType("Model_Group_4_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitFourKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitFourKeyword_4_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitFourKeyword_4_0());
		}
		public static IGrammarAwareElementType createModel_ParentRefAssignment_4_1ElementType() {
			return new IGrammarAwareElementType("Model_ParentRefAssignment_4_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getParentRefAssignment_4_1());
		}
		public static IGrammarAwareElementType createModel_ParentRefAlternatives_4_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ParentRefAlternatives_4_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getParentRefAlternatives_4_1_0());
		}
		public static IGrammarAwareElementType createModel_ParentRefParentRefTest1ParserRuleCall_4_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ParentRefParentRefTest1ParserRuleCall_4_1_0_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getParentRefParentRefTest1ParserRuleCall_4_1_0_0());
		}
		public static IGrammarAwareElementType createModel_ParentRefParentRefTest2ParserRuleCall_4_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ParentRefParentRefTest2ParserRuleCall_4_1_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getParentRefParentRefTest2ParserRuleCall_4_1_0_1());
		}
		public static IGrammarAwareElementType createModel_Group_5ElementType() {
			return new IGrammarAwareElementType("Model_Group_5_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitFiveKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitFiveKeyword_5_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitFiveKeyword_5_0());
		}
		public static IGrammarAwareElementType createModel_QuantityExclusionAssignment_5_1ElementType() {
			return new IGrammarAwareElementType("Model_QuantityExclusionAssignment_5_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getQuantityExclusionAssignment_5_1());
		}
		public static IGrammarAwareElementType createModel_QuantityExclusionAlternatives_5_1_0ElementType() {
			return new IGrammarAwareElementType("Model_QuantityExclusionAlternatives_5_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getQuantityExclusionAlternatives_5_1_0());
		}
		public static IGrammarAwareElementType createModel_QuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_QuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getQuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0());
		}
		public static IGrammarAwareElementType createModel_QuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_QuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getQuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1());
		}
		public static IGrammarAwareElementType createModel_Group_6ElementType() {
			return new IGrammarAwareElementType("Model_Group_6_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_6());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitSixKeyword_6_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitSixKeyword_6_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitSixKeyword_6_0());
		}
		public static IGrammarAwareElementType createModel_ValueExclusionAssignment_6_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueExclusionAssignment_6_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueExclusionAssignment_6_1());
		}
		public static IGrammarAwareElementType createModel_ValueExclusionAlternatives_6_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueExclusionAlternatives_6_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueExclusionAlternatives_6_1_0());
		}
		public static IGrammarAwareElementType createModel_ValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0());
		}
		public static IGrammarAwareElementType createModel_ValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1());
		}
		public static IGrammarAwareElementType createModel_Group_7ElementType() {
			return new IGrammarAwareElementType("Model_Group_7_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_7());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitSevenKeyword_7_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitSevenKeyword_7_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitSevenKeyword_7_0());
		}
		public static IGrammarAwareElementType createModel_NameAssignment_7_1ElementType() {
			return new IGrammarAwareElementType("Model_NameAssignment_7_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameAssignment_7_1());
		}
		public static IGrammarAwareElementType createModel_NameSTRINGTerminalRuleCall_7_1_0ElementType() {
			return new IGrammarAwareElementType("Model_NameSTRINGTerminalRuleCall_7_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameSTRINGTerminalRuleCall_7_1_0());
		}
		public static IGrammarAwareElementType createModel_NodeExclusionAssignment_7_2ElementType() {
			return new IGrammarAwareElementType("Model_NodeExclusionAssignment_7_2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNodeExclusionAssignment_7_2());
		}
		public static IGrammarAwareElementType createModel_NodeExclusionAlternatives_7_2_0ElementType() {
			return new IGrammarAwareElementType("Model_NodeExclusionAlternatives_7_2_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNodeExclusionAlternatives_7_2_0());
		}
		public static IGrammarAwareElementType createModel_NodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0ElementType() {
			return new IGrammarAwareElementType("Model_NodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0());
		}
		public static IGrammarAwareElementType createModel_NodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1ElementType() {
			return new IGrammarAwareElementType("Model_NodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1());
		}
		public static IGrammarAwareElementType createModel_Group_8ElementType() {
			return new IGrammarAwareElementType("Model_Group_8_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_8());
		}
		public static IGrammarAwareElementType createModel_NumberSignDigitEightKeyword_8_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignDigitEightKeyword_8_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignDigitEightKeyword_8_0());
		}
		public static IGrammarAwareElementType createModel_NameAssignment_8_1ElementType() {
			return new IGrammarAwareElementType("Model_NameAssignment_8_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameAssignment_8_1());
		}
		public static IGrammarAwareElementType createModel_NameSTRINGTerminalRuleCall_8_1_0ElementType() {
			return new IGrammarAwareElementType("Model_NameSTRINGTerminalRuleCall_8_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameSTRINGTerminalRuleCall_8_1_0());
		}
		public static IGrammarAwareElementType createModel_NodeExclusionListAssignment_8_2ElementType() {
			return new IGrammarAwareElementType("Model_NodeExclusionListAssignment_8_2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNodeExclusionListAssignment_8_2());
		}
		public static IGrammarAwareElementType createModel_NodeExclusionListAlternatives_8_2_0ElementType() {
			return new IGrammarAwareElementType("Model_NodeExclusionListAlternatives_8_2_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNodeExclusionListAlternatives_8_2_0());
		}
		public static IGrammarAwareElementType createModel_NodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0ElementType() {
			return new IGrammarAwareElementType("Model_NodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0());
		}
		public static IGrammarAwareElementType createModel_NodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1ElementType() {
			return new IGrammarAwareElementType("Model_NodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitZeroKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitZeroKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_ModelAssignment_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Model_ModelModel2ParserRuleCall_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelModel2ParserRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitOneKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitOneKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_AttributeExclusionAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributeExclusionAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_AttributeExclusionAlternatives_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributeExclusionAlternatives_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_AttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_AttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_Group_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_2ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitTwoKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitTwoKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Model_NestedTypeAssignment_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedTypeAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Model_NestedTypeAlternatives_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedTypeAlternatives_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_NestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_NestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_Group_3_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_3ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitThreeKeyword_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitThreeKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Model_NestedTypeRecursiveTest2Assignment_3_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedTypeRecursiveTest2Assignment_3_1ElementType());

	public static final IGrammarAwareElementType Model_NestedTypeRecursiveTest2Alternatives_3_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedTypeRecursiveTest2Alternatives_3_1_0ElementType());

	public static final IGrammarAwareElementType Model_NestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_NestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_Group_4_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_4ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitFourKeyword_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitFourKeyword_4_0ElementType());

	public static final IGrammarAwareElementType Model_ParentRefAssignment_4_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ParentRefAssignment_4_1ElementType());

	public static final IGrammarAwareElementType Model_ParentRefAlternatives_4_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ParentRefAlternatives_4_1_0ElementType());

	public static final IGrammarAwareElementType Model_ParentRefParentRefTest1ParserRuleCall_4_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ParentRefParentRefTest1ParserRuleCall_4_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_ParentRefParentRefTest2ParserRuleCall_4_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ParentRefParentRefTest2ParserRuleCall_4_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_Group_5_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_5ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitFiveKeyword_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitFiveKeyword_5_0ElementType());

	public static final IGrammarAwareElementType Model_QuantityExclusionAssignment_5_1_ELEMENT_TYPE = associate(ModelFactory.createModel_QuantityExclusionAssignment_5_1ElementType());

	public static final IGrammarAwareElementType Model_QuantityExclusionAlternatives_5_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_QuantityExclusionAlternatives_5_1_0ElementType());

	public static final IGrammarAwareElementType Model_QuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_QuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_QuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_QuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_Group_6_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_6ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitSixKeyword_6_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitSixKeyword_6_0ElementType());

	public static final IGrammarAwareElementType Model_ValueExclusionAssignment_6_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueExclusionAssignment_6_1ElementType());

	public static final IGrammarAwareElementType Model_ValueExclusionAlternatives_6_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueExclusionAlternatives_6_1_0ElementType());

	public static final IGrammarAwareElementType Model_ValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_ValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_Group_7_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_7ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitSevenKeyword_7_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitSevenKeyword_7_0ElementType());

	public static final IGrammarAwareElementType Model_NameAssignment_7_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NameAssignment_7_1ElementType());

	public static final IGrammarAwareElementType Model_NameSTRINGTerminalRuleCall_7_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NameSTRINGTerminalRuleCall_7_1_0ElementType());

	public static final IGrammarAwareElementType Model_NodeExclusionAssignment_7_2_ELEMENT_TYPE = associate(ModelFactory.createModel_NodeExclusionAssignment_7_2ElementType());

	public static final IGrammarAwareElementType Model_NodeExclusionAlternatives_7_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NodeExclusionAlternatives_7_2_0ElementType());

	public static final IGrammarAwareElementType Model_NodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0ElementType());

	public static final IGrammarAwareElementType Model_NodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1ElementType());

	public static final IGrammarAwareElementType Model_Group_8_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_8ElementType());

	public static final IGrammarAwareElementType Model_NumberSignDigitEightKeyword_8_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignDigitEightKeyword_8_0ElementType());

	public static final IGrammarAwareElementType Model_NameAssignment_8_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NameAssignment_8_1ElementType());

	public static final IGrammarAwareElementType Model_NameSTRINGTerminalRuleCall_8_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NameSTRINGTerminalRuleCall_8_1_0ElementType());

	public static final IGrammarAwareElementType Model_NodeExclusionListAssignment_8_2_ELEMENT_TYPE = associate(ModelFactory.createModel_NodeExclusionListAssignment_8_2ElementType());

	public static final IGrammarAwareElementType Model_NodeExclusionListAlternatives_8_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NodeExclusionListAlternatives_8_2_0ElementType());

	public static final IGrammarAwareElementType Model_NodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0ElementType());

	public static final IGrammarAwareElementType Model_NodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1ElementType());

	private static class Model2Factory {
		public static IGrammarAwareElementType createModel2ElementType() {
			return new IGrammarAwareElementType("Model2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModel2Rule());
		}
		public static IGrammarAwareElementType createModel2_GroupElementType() {
			return new IGrammarAwareElementType("Model2_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModel2Access().getGroup());
		}
		public static IGrammarAwareElementType createModel2_ModelAction_0ElementType() {
			return new IGrammarAwareElementType("Model2_ModelAction_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModel2Access().getModelAction_0());
		}
		public static IGrammarAwareElementType createModel2_ModelKeyword_1ElementType() {
			return new IGrammarAwareElementType("Model2_ModelKeyword_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModel2Access().getModelKeyword_1());
		}
	}

	public static final IGrammarAwareElementType Model2_ELEMENT_TYPE = associate(Model2Factory.createModel2ElementType());

	public static final IGrammarAwareElementType Model2_Group_ELEMENT_TYPE = associate(Model2Factory.createModel2_GroupElementType());

	public static final IGrammarAwareElementType Model2_ModelAction_0_ELEMENT_TYPE = associate(Model2Factory.createModel2_ModelAction_0ElementType());

	public static final IGrammarAwareElementType Model2_ModelKeyword_1_ELEMENT_TYPE = associate(Model2Factory.createModel2_ModelKeyword_1ElementType());

	private static class AttributeExclusionTest1Factory {
		public static IGrammarAwareElementType createAttributeExclusionTest1ElementType() {
			return new IGrammarAwareElementType("AttributeExclusionTest1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeExclusionTest1Rule());
		}
		public static IGrammarAwareElementType createAttributeExclusionTest1_GroupElementType() {
			return new IGrammarAwareElementType("AttributeExclusionTest1_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeExclusionTest1Access().getGroup());
		}
		public static IGrammarAwareElementType createAttributeExclusionTest1_Kw1Keyword_0ElementType() {
			return new IGrammarAwareElementType("AttributeExclusionTest1_Kw1Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeExclusionTest1Access().getKw1Keyword_0());
		}
		public static IGrammarAwareElementType createAttributeExclusionTest1_Attr1Assignment_1ElementType() {
			return new IGrammarAwareElementType("AttributeExclusionTest1_Attr1Assignment_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeExclusionTest1Access().getAttr1Assignment_1());
		}
		public static IGrammarAwareElementType createAttributeExclusionTest1_Attr1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AttributeExclusionTest1_Attr1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeExclusionTest1Access().getAttr1IDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AttributeExclusionTest1_ELEMENT_TYPE = associate(AttributeExclusionTest1Factory.createAttributeExclusionTest1ElementType());

	public static final IGrammarAwareElementType AttributeExclusionTest1_Group_ELEMENT_TYPE = associate(AttributeExclusionTest1Factory.createAttributeExclusionTest1_GroupElementType());

	public static final IGrammarAwareElementType AttributeExclusionTest1_Kw1Keyword_0_ELEMENT_TYPE = associate(AttributeExclusionTest1Factory.createAttributeExclusionTest1_Kw1Keyword_0ElementType());

	public static final IGrammarAwareElementType AttributeExclusionTest1_Attr1Assignment_1_ELEMENT_TYPE = associate(AttributeExclusionTest1Factory.createAttributeExclusionTest1_Attr1Assignment_1ElementType());

	public static final IGrammarAwareElementType AttributeExclusionTest1_Attr1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AttributeExclusionTest1Factory.createAttributeExclusionTest1_Attr1IDTerminalRuleCall_1_0ElementType());

	private static class AttributeExclusionTest2Factory {
		public static IGrammarAwareElementType createAttributeExclusionTest2ElementType() {
			return new IGrammarAwareElementType("AttributeExclusionTest2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeExclusionTest2Rule());
		}
		public static IGrammarAwareElementType createAttributeExclusionTest2_GroupElementType() {
			return new IGrammarAwareElementType("AttributeExclusionTest2_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeExclusionTest2Access().getGroup());
		}
		public static IGrammarAwareElementType createAttributeExclusionTest2_Kw2Keyword_0ElementType() {
			return new IGrammarAwareElementType("AttributeExclusionTest2_Kw2Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeExclusionTest2Access().getKw2Keyword_0());
		}
		public static IGrammarAwareElementType createAttributeExclusionTest2_Attr2Assignment_1ElementType() {
			return new IGrammarAwareElementType("AttributeExclusionTest2_Attr2Assignment_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeExclusionTest2Access().getAttr2Assignment_1());
		}
		public static IGrammarAwareElementType createAttributeExclusionTest2_Attr2IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AttributeExclusionTest2_Attr2IDTerminalRuleCall_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeExclusionTest2Access().getAttr2IDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AttributeExclusionTest2_ELEMENT_TYPE = associate(AttributeExclusionTest2Factory.createAttributeExclusionTest2ElementType());

	public static final IGrammarAwareElementType AttributeExclusionTest2_Group_ELEMENT_TYPE = associate(AttributeExclusionTest2Factory.createAttributeExclusionTest2_GroupElementType());

	public static final IGrammarAwareElementType AttributeExclusionTest2_Kw2Keyword_0_ELEMENT_TYPE = associate(AttributeExclusionTest2Factory.createAttributeExclusionTest2_Kw2Keyword_0ElementType());

	public static final IGrammarAwareElementType AttributeExclusionTest2_Attr2Assignment_1_ELEMENT_TYPE = associate(AttributeExclusionTest2Factory.createAttributeExclusionTest2_Attr2Assignment_1ElementType());

	public static final IGrammarAwareElementType AttributeExclusionTest2_Attr2IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AttributeExclusionTest2Factory.createAttributeExclusionTest2_Attr2IDTerminalRuleCall_1_0ElementType());

	private static class NestedTypeTest1Factory {
		public static IGrammarAwareElementType createNestedTypeTest1ElementType() {
			return new IGrammarAwareElementType("NestedTypeTest1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeTest1Rule());
		}
		public static IGrammarAwareElementType createNestedTypeTest1_NestedAssignmentElementType() {
			return new IGrammarAwareElementType("NestedTypeTest1_NestedAssignment_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeTest1Access().getNestedAssignment());
		}
		public static IGrammarAwareElementType createNestedTypeTest1_NestedNestedTypeChild1ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeTest1_NestedNestedTypeChild1ParserRuleCall_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeTest1Access().getNestedNestedTypeChild1ParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType NestedTypeTest1_ELEMENT_TYPE = associate(NestedTypeTest1Factory.createNestedTypeTest1ElementType());

	public static final IGrammarAwareElementType NestedTypeTest1_NestedAssignment_ELEMENT_TYPE = associate(NestedTypeTest1Factory.createNestedTypeTest1_NestedAssignmentElementType());

	public static final IGrammarAwareElementType NestedTypeTest1_NestedNestedTypeChild1ParserRuleCall_0_ELEMENT_TYPE = associate(NestedTypeTest1Factory.createNestedTypeTest1_NestedNestedTypeChild1ParserRuleCall_0ElementType());

	private static class NestedTypeTest2Factory {
		public static IGrammarAwareElementType createNestedTypeTest2ElementType() {
			return new IGrammarAwareElementType("NestedTypeTest2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeTest2Rule());
		}
		public static IGrammarAwareElementType createNestedTypeTest2_NestedAssignmentElementType() {
			return new IGrammarAwareElementType("NestedTypeTest2_NestedAssignment_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeTest2Access().getNestedAssignment());
		}
		public static IGrammarAwareElementType createNestedTypeTest2_NestedNestedTypeChild2ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeTest2_NestedNestedTypeChild2ParserRuleCall_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeTest2Access().getNestedNestedTypeChild2ParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType NestedTypeTest2_ELEMENT_TYPE = associate(NestedTypeTest2Factory.createNestedTypeTest2ElementType());

	public static final IGrammarAwareElementType NestedTypeTest2_NestedAssignment_ELEMENT_TYPE = associate(NestedTypeTest2Factory.createNestedTypeTest2_NestedAssignmentElementType());

	public static final IGrammarAwareElementType NestedTypeTest2_NestedNestedTypeChild2ParserRuleCall_0_ELEMENT_TYPE = associate(NestedTypeTest2Factory.createNestedTypeTest2_NestedNestedTypeChild2ParserRuleCall_0ElementType());

	private static class NestedTypeChildFactory {
		public static IGrammarAwareElementType createNestedTypeChildElementType() {
			return new IGrammarAwareElementType("NestedTypeChild_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChildRule());
		}
		public static IGrammarAwareElementType createNestedTypeChild_AlternativesElementType() {
			return new IGrammarAwareElementType("NestedTypeChild_Alternatives_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChildAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createNestedTypeChild_NestedTypeChild1ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeChild_NestedTypeChild1ParserRuleCall_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChildAccess().getNestedTypeChild1ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createNestedTypeChild_NestedTypeChild2ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("NestedTypeChild_NestedTypeChild2ParserRuleCall_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChildAccess().getNestedTypeChild2ParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType NestedTypeChild_ELEMENT_TYPE = associate(NestedTypeChildFactory.createNestedTypeChildElementType());

	public static final IGrammarAwareElementType NestedTypeChild_Alternatives_ELEMENT_TYPE = associate(NestedTypeChildFactory.createNestedTypeChild_AlternativesElementType());

	public static final IGrammarAwareElementType NestedTypeChild_NestedTypeChild1ParserRuleCall_0_ELEMENT_TYPE = associate(NestedTypeChildFactory.createNestedTypeChild_NestedTypeChild1ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType NestedTypeChild_NestedTypeChild2ParserRuleCall_1_ELEMENT_TYPE = associate(NestedTypeChildFactory.createNestedTypeChild_NestedTypeChild2ParserRuleCall_1ElementType());

	private static class NestedTypeChild1Factory {
		public static IGrammarAwareElementType createNestedTypeChild1ElementType() {
			return new IGrammarAwareElementType("NestedTypeChild1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChild1Rule());
		}
		public static IGrammarAwareElementType createNestedTypeChild1_GroupElementType() {
			return new IGrammarAwareElementType("NestedTypeChild1_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChild1Access().getGroup());
		}
		public static IGrammarAwareElementType createNestedTypeChild1_Kw1Keyword_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeChild1_Kw1Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChild1Access().getKw1Keyword_0());
		}
		public static IGrammarAwareElementType createNestedTypeChild1_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("NestedTypeChild1_ValAssignment_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChild1Access().getValAssignment_1());
		}
		public static IGrammarAwareElementType createNestedTypeChild1_ValIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeChild1_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChild1Access().getValIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType NestedTypeChild1_ELEMENT_TYPE = associate(NestedTypeChild1Factory.createNestedTypeChild1ElementType());

	public static final IGrammarAwareElementType NestedTypeChild1_Group_ELEMENT_TYPE = associate(NestedTypeChild1Factory.createNestedTypeChild1_GroupElementType());

	public static final IGrammarAwareElementType NestedTypeChild1_Kw1Keyword_0_ELEMENT_TYPE = associate(NestedTypeChild1Factory.createNestedTypeChild1_Kw1Keyword_0ElementType());

	public static final IGrammarAwareElementType NestedTypeChild1_ValAssignment_1_ELEMENT_TYPE = associate(NestedTypeChild1Factory.createNestedTypeChild1_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType NestedTypeChild1_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(NestedTypeChild1Factory.createNestedTypeChild1_ValIDTerminalRuleCall_1_0ElementType());

	private static class NestedTypeChild2Factory {
		public static IGrammarAwareElementType createNestedTypeChild2ElementType() {
			return new IGrammarAwareElementType("NestedTypeChild2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChild2Rule());
		}
		public static IGrammarAwareElementType createNestedTypeChild2_GroupElementType() {
			return new IGrammarAwareElementType("NestedTypeChild2_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChild2Access().getGroup());
		}
		public static IGrammarAwareElementType createNestedTypeChild2_Kw2Keyword_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeChild2_Kw2Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChild2Access().getKw2Keyword_0());
		}
		public static IGrammarAwareElementType createNestedTypeChild2_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("NestedTypeChild2_ValAssignment_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChild2Access().getValAssignment_1());
		}
		public static IGrammarAwareElementType createNestedTypeChild2_ValIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeChild2_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeChild2Access().getValIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType NestedTypeChild2_ELEMENT_TYPE = associate(NestedTypeChild2Factory.createNestedTypeChild2ElementType());

	public static final IGrammarAwareElementType NestedTypeChild2_Group_ELEMENT_TYPE = associate(NestedTypeChild2Factory.createNestedTypeChild2_GroupElementType());

	public static final IGrammarAwareElementType NestedTypeChild2_Kw2Keyword_0_ELEMENT_TYPE = associate(NestedTypeChild2Factory.createNestedTypeChild2_Kw2Keyword_0ElementType());

	public static final IGrammarAwareElementType NestedTypeChild2_ValAssignment_1_ELEMENT_TYPE = associate(NestedTypeChild2Factory.createNestedTypeChild2_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType NestedTypeChild2_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(NestedTypeChild2Factory.createNestedTypeChild2_ValIDTerminalRuleCall_1_0ElementType());

	private static class NestedTypeRecursiveTest1Factory {
		public static IGrammarAwareElementType createNestedTypeRecursiveTest1ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest1Rule());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest1_GroupElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest1_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest1Access().getGroup());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest1_NestedTypeRecursiveTest1Action_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest1_NestedTypeRecursiveTest1Action_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTest1Action_0());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest1_Kw1Keyword_1ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest1_Kw1Keyword_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest1Access().getKw1Keyword_1());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest1_Group_2ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest1_Group_2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest1Access().getGroup_2());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest1_NestedTypeRecursiveTestLeftAction_2_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest1_NestedTypeRecursiveTestLeftAction_2_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTestLeftAction_2_0());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest1_FullStopKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest1_FullStopKeyword_2_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest1Access().getFullStopKeyword_2_1());
		}
	}

	public static final IGrammarAwareElementType NestedTypeRecursiveTest1_ELEMENT_TYPE = associate(NestedTypeRecursiveTest1Factory.createNestedTypeRecursiveTest1ElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest1_Group_ELEMENT_TYPE = associate(NestedTypeRecursiveTest1Factory.createNestedTypeRecursiveTest1_GroupElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest1_NestedTypeRecursiveTest1Action_0_ELEMENT_TYPE = associate(NestedTypeRecursiveTest1Factory.createNestedTypeRecursiveTest1_NestedTypeRecursiveTest1Action_0ElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest1_Kw1Keyword_1_ELEMENT_TYPE = associate(NestedTypeRecursiveTest1Factory.createNestedTypeRecursiveTest1_Kw1Keyword_1ElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest1_Group_2_ELEMENT_TYPE = associate(NestedTypeRecursiveTest1Factory.createNestedTypeRecursiveTest1_Group_2ElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest1_NestedTypeRecursiveTestLeftAction_2_0_ELEMENT_TYPE = associate(NestedTypeRecursiveTest1Factory.createNestedTypeRecursiveTest1_NestedTypeRecursiveTestLeftAction_2_0ElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest1_FullStopKeyword_2_1_ELEMENT_TYPE = associate(NestedTypeRecursiveTest1Factory.createNestedTypeRecursiveTest1_FullStopKeyword_2_1ElementType());

	private static class NestedTypeRecursiveTest2Factory {
		public static IGrammarAwareElementType createNestedTypeRecursiveTest2ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest2Rule());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest2_GroupElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest2_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest2Access().getGroup());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest2_NestedTypeRecursiveTest2Action_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest2_NestedTypeRecursiveTest2Action_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTest2Action_0());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest2_Kw2Keyword_1ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest2_Kw2Keyword_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest2Access().getKw2Keyword_1());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest2_Group_2ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest2_Group_2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest2Access().getGroup_2());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest2_NestedTypeRecursiveTestLeftAction_2_0ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest2_NestedTypeRecursiveTestLeftAction_2_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTestLeftAction_2_0());
		}
		public static IGrammarAwareElementType createNestedTypeRecursiveTest2_FullStopKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("NestedTypeRecursiveTest2_FullStopKeyword_2_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedTypeRecursiveTest2Access().getFullStopKeyword_2_1());
		}
	}

	public static final IGrammarAwareElementType NestedTypeRecursiveTest2_ELEMENT_TYPE = associate(NestedTypeRecursiveTest2Factory.createNestedTypeRecursiveTest2ElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest2_Group_ELEMENT_TYPE = associate(NestedTypeRecursiveTest2Factory.createNestedTypeRecursiveTest2_GroupElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest2_NestedTypeRecursiveTest2Action_0_ELEMENT_TYPE = associate(NestedTypeRecursiveTest2Factory.createNestedTypeRecursiveTest2_NestedTypeRecursiveTest2Action_0ElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest2_Kw2Keyword_1_ELEMENT_TYPE = associate(NestedTypeRecursiveTest2Factory.createNestedTypeRecursiveTest2_Kw2Keyword_1ElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest2_Group_2_ELEMENT_TYPE = associate(NestedTypeRecursiveTest2Factory.createNestedTypeRecursiveTest2_Group_2ElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest2_NestedTypeRecursiveTestLeftAction_2_0_ELEMENT_TYPE = associate(NestedTypeRecursiveTest2Factory.createNestedTypeRecursiveTest2_NestedTypeRecursiveTestLeftAction_2_0ElementType());

	public static final IGrammarAwareElementType NestedTypeRecursiveTest2_FullStopKeyword_2_1_ELEMENT_TYPE = associate(NestedTypeRecursiveTest2Factory.createNestedTypeRecursiveTest2_FullStopKeyword_2_1ElementType());

	private static class ParentRefTest1Factory {
		public static IGrammarAwareElementType createParentRefTest1ElementType() {
			return new IGrammarAwareElementType("ParentRefTest1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTest1Rule());
		}
		public static IGrammarAwareElementType createParentRefTest1_GroupElementType() {
			return new IGrammarAwareElementType("ParentRefTest1_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTest1Access().getGroup());
		}
		public static IGrammarAwareElementType createParentRefTest1_Kw1Keyword_0ElementType() {
			return new IGrammarAwareElementType("ParentRefTest1_Kw1Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTest1Access().getKw1Keyword_0());
		}
		public static IGrammarAwareElementType createParentRefTest1_Child1Assignment_1ElementType() {
			return new IGrammarAwareElementType("ParentRefTest1_Child1Assignment_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTest1Access().getChild1Assignment_1());
		}
		public static IGrammarAwareElementType createParentRefTest1_Child1ParentRefTestChild1ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ParentRefTest1_Child1ParentRefTestChild1ParserRuleCall_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTest1Access().getChild1ParentRefTestChild1ParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType ParentRefTest1_ELEMENT_TYPE = associate(ParentRefTest1Factory.createParentRefTest1ElementType());

	public static final IGrammarAwareElementType ParentRefTest1_Group_ELEMENT_TYPE = associate(ParentRefTest1Factory.createParentRefTest1_GroupElementType());

	public static final IGrammarAwareElementType ParentRefTest1_Kw1Keyword_0_ELEMENT_TYPE = associate(ParentRefTest1Factory.createParentRefTest1_Kw1Keyword_0ElementType());

	public static final IGrammarAwareElementType ParentRefTest1_Child1Assignment_1_ELEMENT_TYPE = associate(ParentRefTest1Factory.createParentRefTest1_Child1Assignment_1ElementType());

	public static final IGrammarAwareElementType ParentRefTest1_Child1ParentRefTestChild1ParserRuleCall_1_0_ELEMENT_TYPE = associate(ParentRefTest1Factory.createParentRefTest1_Child1ParentRefTestChild1ParserRuleCall_1_0ElementType());

	private static class ParentRefTest2Factory {
		public static IGrammarAwareElementType createParentRefTest2ElementType() {
			return new IGrammarAwareElementType("ParentRefTest2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTest2Rule());
		}
		public static IGrammarAwareElementType createParentRefTest2_GroupElementType() {
			return new IGrammarAwareElementType("ParentRefTest2_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTest2Access().getGroup());
		}
		public static IGrammarAwareElementType createParentRefTest2_Kw2Keyword_0ElementType() {
			return new IGrammarAwareElementType("ParentRefTest2_Kw2Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTest2Access().getKw2Keyword_0());
		}
		public static IGrammarAwareElementType createParentRefTest2_Child2Assignment_1ElementType() {
			return new IGrammarAwareElementType("ParentRefTest2_Child2Assignment_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTest2Access().getChild2Assignment_1());
		}
		public static IGrammarAwareElementType createParentRefTest2_Child2ParentRefTestChild2ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ParentRefTest2_Child2ParentRefTestChild2ParserRuleCall_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTest2Access().getChild2ParentRefTestChild2ParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType ParentRefTest2_ELEMENT_TYPE = associate(ParentRefTest2Factory.createParentRefTest2ElementType());

	public static final IGrammarAwareElementType ParentRefTest2_Group_ELEMENT_TYPE = associate(ParentRefTest2Factory.createParentRefTest2_GroupElementType());

	public static final IGrammarAwareElementType ParentRefTest2_Kw2Keyword_0_ELEMENT_TYPE = associate(ParentRefTest2Factory.createParentRefTest2_Kw2Keyword_0ElementType());

	public static final IGrammarAwareElementType ParentRefTest2_Child2Assignment_1_ELEMENT_TYPE = associate(ParentRefTest2Factory.createParentRefTest2_Child2Assignment_1ElementType());

	public static final IGrammarAwareElementType ParentRefTest2_Child2ParentRefTestChild2ParserRuleCall_1_0_ELEMENT_TYPE = associate(ParentRefTest2Factory.createParentRefTest2_Child2ParentRefTestChild2ParserRuleCall_1_0ElementType());

	private static class ParentRefTestChild1Factory {
		public static IGrammarAwareElementType createParentRefTestChild1ElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild1Rule());
		}
		public static IGrammarAwareElementType createParentRefTestChild1_GroupElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild1_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild1Access().getGroup());
		}
		public static IGrammarAwareElementType createParentRefTestChild1_ParentRefTestChildAction_0ElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild1_ParentRefTestChildAction_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild1Access().getParentRefTestChildAction_0());
		}
		public static IGrammarAwareElementType createParentRefTestChild1_FooKeyword_1ElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild1_FooKeyword_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild1Access().getFooKeyword_1());
		}
		public static IGrammarAwareElementType createParentRefTestChild1_ChildAssignment_2ElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild1_ChildAssignment_2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild1Access().getChildAssignment_2());
		}
		public static IGrammarAwareElementType createParentRefTestChild1_ChildParentRefTestChild1ParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild1_ChildParentRefTestChild1ParserRuleCall_2_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild1Access().getChildParentRefTestChild1ParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType ParentRefTestChild1_ELEMENT_TYPE = associate(ParentRefTestChild1Factory.createParentRefTestChild1ElementType());

	public static final IGrammarAwareElementType ParentRefTestChild1_Group_ELEMENT_TYPE = associate(ParentRefTestChild1Factory.createParentRefTestChild1_GroupElementType());

	public static final IGrammarAwareElementType ParentRefTestChild1_ParentRefTestChildAction_0_ELEMENT_TYPE = associate(ParentRefTestChild1Factory.createParentRefTestChild1_ParentRefTestChildAction_0ElementType());

	public static final IGrammarAwareElementType ParentRefTestChild1_FooKeyword_1_ELEMENT_TYPE = associate(ParentRefTestChild1Factory.createParentRefTestChild1_FooKeyword_1ElementType());

	public static final IGrammarAwareElementType ParentRefTestChild1_ChildAssignment_2_ELEMENT_TYPE = associate(ParentRefTestChild1Factory.createParentRefTestChild1_ChildAssignment_2ElementType());

	public static final IGrammarAwareElementType ParentRefTestChild1_ChildParentRefTestChild1ParserRuleCall_2_0_ELEMENT_TYPE = associate(ParentRefTestChild1Factory.createParentRefTestChild1_ChildParentRefTestChild1ParserRuleCall_2_0ElementType());

	private static class ParentRefTestChild2Factory {
		public static IGrammarAwareElementType createParentRefTestChild2ElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild2Rule());
		}
		public static IGrammarAwareElementType createParentRefTestChild2_GroupElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild2_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild2Access().getGroup());
		}
		public static IGrammarAwareElementType createParentRefTestChild2_ParentRefTestChildAction_0ElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild2_ParentRefTestChildAction_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild2Access().getParentRefTestChildAction_0());
		}
		public static IGrammarAwareElementType createParentRefTestChild2_FooKeyword_1ElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild2_FooKeyword_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild2Access().getFooKeyword_1());
		}
		public static IGrammarAwareElementType createParentRefTestChild2_ChildAssignment_2ElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild2_ChildAssignment_2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild2Access().getChildAssignment_2());
		}
		public static IGrammarAwareElementType createParentRefTestChild2_ChildParentRefTestChild2ParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("ParentRefTestChild2_ChildParentRefTestChild2ParserRuleCall_2_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParentRefTestChild2Access().getChildParentRefTestChild2ParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType ParentRefTestChild2_ELEMENT_TYPE = associate(ParentRefTestChild2Factory.createParentRefTestChild2ElementType());

	public static final IGrammarAwareElementType ParentRefTestChild2_Group_ELEMENT_TYPE = associate(ParentRefTestChild2Factory.createParentRefTestChild2_GroupElementType());

	public static final IGrammarAwareElementType ParentRefTestChild2_ParentRefTestChildAction_0_ELEMENT_TYPE = associate(ParentRefTestChild2Factory.createParentRefTestChild2_ParentRefTestChildAction_0ElementType());

	public static final IGrammarAwareElementType ParentRefTestChild2_FooKeyword_1_ELEMENT_TYPE = associate(ParentRefTestChild2Factory.createParentRefTestChild2_FooKeyword_1ElementType());

	public static final IGrammarAwareElementType ParentRefTestChild2_ChildAssignment_2_ELEMENT_TYPE = associate(ParentRefTestChild2Factory.createParentRefTestChild2_ChildAssignment_2ElementType());

	public static final IGrammarAwareElementType ParentRefTestChild2_ChildParentRefTestChild2ParserRuleCall_2_0_ELEMENT_TYPE = associate(ParentRefTestChild2Factory.createParentRefTestChild2_ChildParentRefTestChild2ParserRuleCall_2_0ElementType());

	private static class QuantityExclusionTest1Factory {
		public static IGrammarAwareElementType createQuantityExclusionTest1ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest1Rule());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest1_GroupElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest1_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest1Access().getGroup());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest1_Kw1Keyword_0ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest1_Kw1Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest1Access().getKw1Keyword_0());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest1_Attr1Assignment_1ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest1_Attr1Assignment_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest1Access().getAttr1Assignment_1());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest1_Attr1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest1_Attr1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest1Access().getAttr1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest1_Attr2Assignment_2ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest1_Attr2Assignment_2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest1Access().getAttr2Assignment_2());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest1_Attr2IDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest1_Attr2IDTerminalRuleCall_2_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest1Access().getAttr2IDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType QuantityExclusionTest1_ELEMENT_TYPE = associate(QuantityExclusionTest1Factory.createQuantityExclusionTest1ElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest1_Group_ELEMENT_TYPE = associate(QuantityExclusionTest1Factory.createQuantityExclusionTest1_GroupElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest1_Kw1Keyword_0_ELEMENT_TYPE = associate(QuantityExclusionTest1Factory.createQuantityExclusionTest1_Kw1Keyword_0ElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest1_Attr1Assignment_1_ELEMENT_TYPE = associate(QuantityExclusionTest1Factory.createQuantityExclusionTest1_Attr1Assignment_1ElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest1_Attr1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(QuantityExclusionTest1Factory.createQuantityExclusionTest1_Attr1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest1_Attr2Assignment_2_ELEMENT_TYPE = associate(QuantityExclusionTest1Factory.createQuantityExclusionTest1_Attr2Assignment_2ElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest1_Attr2IDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(QuantityExclusionTest1Factory.createQuantityExclusionTest1_Attr2IDTerminalRuleCall_2_0ElementType());

	private static class QuantityExclusionTest2Factory {
		public static IGrammarAwareElementType createQuantityExclusionTest2ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest2Rule());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest2_GroupElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest2_Group_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest2Access().getGroup());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest2_Kw2Keyword_0ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest2_Kw2Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest2Access().getKw2Keyword_0());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest2_Attr1Assignment_1ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest2_Attr1Assignment_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest2Access().getAttr1Assignment_1());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest2_Attr1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest2_Attr1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest2Access().getAttr1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest2_Attr2Assignment_2ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest2_Attr2Assignment_2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest2Access().getAttr2Assignment_2());
		}
		public static IGrammarAwareElementType createQuantityExclusionTest2_Attr2IDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("QuantityExclusionTest2_Attr2IDTerminalRuleCall_2_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuantityExclusionTest2Access().getAttr2IDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType QuantityExclusionTest2_ELEMENT_TYPE = associate(QuantityExclusionTest2Factory.createQuantityExclusionTest2ElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest2_Group_ELEMENT_TYPE = associate(QuantityExclusionTest2Factory.createQuantityExclusionTest2_GroupElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest2_Kw2Keyword_0_ELEMENT_TYPE = associate(QuantityExclusionTest2Factory.createQuantityExclusionTest2_Kw2Keyword_0ElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest2_Attr1Assignment_1_ELEMENT_TYPE = associate(QuantityExclusionTest2Factory.createQuantityExclusionTest2_Attr1Assignment_1ElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest2_Attr1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(QuantityExclusionTest2Factory.createQuantityExclusionTest2_Attr1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest2_Attr2Assignment_2_ELEMENT_TYPE = associate(QuantityExclusionTest2Factory.createQuantityExclusionTest2_Attr2Assignment_2ElementType());

	public static final IGrammarAwareElementType QuantityExclusionTest2_Attr2IDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(QuantityExclusionTest2Factory.createQuantityExclusionTest2_Attr2IDTerminalRuleCall_2_0ElementType());

	private static class ValueExclusionTest1Factory {
		public static IGrammarAwareElementType createValueExclusionTest1ElementType() {
			return new IGrammarAwareElementType("ValueExclusionTest1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTest1Rule());
		}
		public static IGrammarAwareElementType createValueExclusionTest1_ValAssignmentElementType() {
			return new IGrammarAwareElementType("ValueExclusionTest1_ValAssignment_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTest1Access().getValAssignment());
		}
		public static IGrammarAwareElementType createValueExclusionTest1_ValValueExclusionTestEn1EnumRuleCall_0ElementType() {
			return new IGrammarAwareElementType("ValueExclusionTest1_ValValueExclusionTestEn1EnumRuleCall_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTest1Access().getValValueExclusionTestEn1EnumRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType ValueExclusionTest1_ELEMENT_TYPE = associate(ValueExclusionTest1Factory.createValueExclusionTest1ElementType());

	public static final IGrammarAwareElementType ValueExclusionTest1_ValAssignment_ELEMENT_TYPE = associate(ValueExclusionTest1Factory.createValueExclusionTest1_ValAssignmentElementType());

	public static final IGrammarAwareElementType ValueExclusionTest1_ValValueExclusionTestEn1EnumRuleCall_0_ELEMENT_TYPE = associate(ValueExclusionTest1Factory.createValueExclusionTest1_ValValueExclusionTestEn1EnumRuleCall_0ElementType());

	private static class ValueExclusionTest2Factory {
		public static IGrammarAwareElementType createValueExclusionTest2ElementType() {
			return new IGrammarAwareElementType("ValueExclusionTest2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTest2Rule());
		}
		public static IGrammarAwareElementType createValueExclusionTest2_ValAssignmentElementType() {
			return new IGrammarAwareElementType("ValueExclusionTest2_ValAssignment_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTest2Access().getValAssignment());
		}
		public static IGrammarAwareElementType createValueExclusionTest2_ValValueExclusionTestEn2EnumRuleCall_0ElementType() {
			return new IGrammarAwareElementType("ValueExclusionTest2_ValValueExclusionTestEn2EnumRuleCall_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTest2Access().getValValueExclusionTestEn2EnumRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType ValueExclusionTest2_ELEMENT_TYPE = associate(ValueExclusionTest2Factory.createValueExclusionTest2ElementType());

	public static final IGrammarAwareElementType ValueExclusionTest2_ValAssignment_ELEMENT_TYPE = associate(ValueExclusionTest2Factory.createValueExclusionTest2_ValAssignmentElementType());

	public static final IGrammarAwareElementType ValueExclusionTest2_ValValueExclusionTestEn2EnumRuleCall_0_ELEMENT_TYPE = associate(ValueExclusionTest2Factory.createValueExclusionTest2_ValValueExclusionTestEn2EnumRuleCall_0ElementType());

	private static class ValueExclusionTestEn0Factory {
		public static IGrammarAwareElementType createValueExclusionTestEn0ElementType() {
			return new IGrammarAwareElementType("ValueExclusionTestEn0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTestEn0Rule());
		}
		public static IGrammarAwareElementType createValueExclusionTestEn0_Lit0EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("ValueExclusionTestEn0_Lit0EnumLiteralDeclaration_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTestEn0Access().getLit0EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createValueExclusionTestEn0_Lit0Lit0Keyword_0ElementType() {
			return new IGrammarAwareElementType("ValueExclusionTestEn0_Lit0Lit0Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTestEn0Access().getLit0Lit0Keyword_0());
		}
	}

	public static final IGrammarAwareElementType ValueExclusionTestEn0_ELEMENT_TYPE = associate(ValueExclusionTestEn0Factory.createValueExclusionTestEn0ElementType());

	public static final IGrammarAwareElementType ValueExclusionTestEn0_Lit0EnumLiteralDeclaration_ELEMENT_TYPE = associate(ValueExclusionTestEn0Factory.createValueExclusionTestEn0_Lit0EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType ValueExclusionTestEn0_Lit0Lit0Keyword_0_ELEMENT_TYPE = associate(ValueExclusionTestEn0Factory.createValueExclusionTestEn0_Lit0Lit0Keyword_0ElementType());

	private static class ValueExclusionTestEn1Factory {
		public static IGrammarAwareElementType createValueExclusionTestEn1ElementType() {
			return new IGrammarAwareElementType("ValueExclusionTestEn1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTestEn1Rule());
		}
		public static IGrammarAwareElementType createValueExclusionTestEn1_Lit1EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("ValueExclusionTestEn1_Lit1EnumLiteralDeclaration_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTestEn1Access().getLit1EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createValueExclusionTestEn1_Lit1Lit1Keyword_0ElementType() {
			return new IGrammarAwareElementType("ValueExclusionTestEn1_Lit1Lit1Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTestEn1Access().getLit1Lit1Keyword_0());
		}
	}

	public static final IGrammarAwareElementType ValueExclusionTestEn1_ELEMENT_TYPE = associate(ValueExclusionTestEn1Factory.createValueExclusionTestEn1ElementType());

	public static final IGrammarAwareElementType ValueExclusionTestEn1_Lit1EnumLiteralDeclaration_ELEMENT_TYPE = associate(ValueExclusionTestEn1Factory.createValueExclusionTestEn1_Lit1EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType ValueExclusionTestEn1_Lit1Lit1Keyword_0_ELEMENT_TYPE = associate(ValueExclusionTestEn1Factory.createValueExclusionTestEn1_Lit1Lit1Keyword_0ElementType());

	private static class ValueExclusionTestEn2Factory {
		public static IGrammarAwareElementType createValueExclusionTestEn2ElementType() {
			return new IGrammarAwareElementType("ValueExclusionTestEn2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTestEn2Rule());
		}
		public static IGrammarAwareElementType createValueExclusionTestEn2_Lit2EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("ValueExclusionTestEn2_Lit2EnumLiteralDeclaration_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTestEn2Access().getLit2EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createValueExclusionTestEn2_Lit2Lit2Keyword_0ElementType() {
			return new IGrammarAwareElementType("ValueExclusionTestEn2_Lit2Lit2Keyword_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueExclusionTestEn2Access().getLit2Lit2Keyword_0());
		}
	}

	public static final IGrammarAwareElementType ValueExclusionTestEn2_ELEMENT_TYPE = associate(ValueExclusionTestEn2Factory.createValueExclusionTestEn2ElementType());

	public static final IGrammarAwareElementType ValueExclusionTestEn2_Lit2EnumLiteralDeclaration_ELEMENT_TYPE = associate(ValueExclusionTestEn2Factory.createValueExclusionTestEn2_Lit2EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType ValueExclusionTestEn2_Lit2Lit2Keyword_0_ELEMENT_TYPE = associate(ValueExclusionTestEn2Factory.createValueExclusionTestEn2_Lit2Lit2Keyword_0ElementType());

	private static class NodeExclusion1Factory {
		public static IGrammarAwareElementType createNodeExclusion1ElementType() {
			return new IGrammarAwareElementType("NodeExclusion1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion1Rule());
		}
		public static IGrammarAwareElementType createNodeExclusion1_RefAssignmentElementType() {
			return new IGrammarAwareElementType("NodeExclusion1_RefAssignment_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion1Access().getRefAssignment());
		}
		public static IGrammarAwareElementType createNodeExclusion1_RefModelCrossReference_0ElementType() {
			return new IGrammarAwareElementType("NodeExclusion1_RefModelCrossReference_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion1Access().getRefModelCrossReference_0());
		}
		public static IGrammarAwareElementType createNodeExclusion1_RefModelIDTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("NodeExclusion1_RefModelIDTerminalRuleCall_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion1Access().getRefModelIDTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType NodeExclusion1_ELEMENT_TYPE = associate(NodeExclusion1Factory.createNodeExclusion1ElementType());

	public static final IGrammarAwareElementType NodeExclusion1_RefAssignment_ELEMENT_TYPE = associate(NodeExclusion1Factory.createNodeExclusion1_RefAssignmentElementType());

	public static final IGrammarAwareElementType NodeExclusion1_RefModelCrossReference_0_ELEMENT_TYPE = associate(NodeExclusion1Factory.createNodeExclusion1_RefModelCrossReference_0ElementType());

	public static final IGrammarAwareElementType NodeExclusion1_RefModelIDTerminalRuleCall_0_1_ELEMENT_TYPE = associate(NodeExclusion1Factory.createNodeExclusion1_RefModelIDTerminalRuleCall_0_1ElementType());

	private static class NodeExclusion2Factory {
		public static IGrammarAwareElementType createNodeExclusion2ElementType() {
			return new IGrammarAwareElementType("NodeExclusion2_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion2Rule());
		}
		public static IGrammarAwareElementType createNodeExclusion2_RefAssignmentElementType() {
			return new IGrammarAwareElementType("NodeExclusion2_RefAssignment_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion2Access().getRefAssignment());
		}
		public static IGrammarAwareElementType createNodeExclusion2_RefModelCrossReference_0ElementType() {
			return new IGrammarAwareElementType("NodeExclusion2_RefModelCrossReference_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion2Access().getRefModelCrossReference_0());
		}
		public static IGrammarAwareElementType createNodeExclusion2_RefModelSTRINGTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("NodeExclusion2_RefModelSTRINGTerminalRuleCall_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion2Access().getRefModelSTRINGTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType NodeExclusion2_ELEMENT_TYPE = associate(NodeExclusion2Factory.createNodeExclusion2ElementType());

	public static final IGrammarAwareElementType NodeExclusion2_RefAssignment_ELEMENT_TYPE = associate(NodeExclusion2Factory.createNodeExclusion2_RefAssignmentElementType());

	public static final IGrammarAwareElementType NodeExclusion2_RefModelCrossReference_0_ELEMENT_TYPE = associate(NodeExclusion2Factory.createNodeExclusion2_RefModelCrossReference_0ElementType());

	public static final IGrammarAwareElementType NodeExclusion2_RefModelSTRINGTerminalRuleCall_0_1_ELEMENT_TYPE = associate(NodeExclusion2Factory.createNodeExclusion2_RefModelSTRINGTerminalRuleCall_0_1ElementType());

	private static class NodeExclusion1ListFactory {
		public static IGrammarAwareElementType createNodeExclusion1ListElementType() {
			return new IGrammarAwareElementType("NodeExclusion1List_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion1ListRule());
		}
		public static IGrammarAwareElementType createNodeExclusion1List_RefAssignmentElementType() {
			return new IGrammarAwareElementType("NodeExclusion1List_RefAssignment_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion1ListAccess().getRefAssignment());
		}
		public static IGrammarAwareElementType createNodeExclusion1List_RefModelCrossReference_0ElementType() {
			return new IGrammarAwareElementType("NodeExclusion1List_RefModelCrossReference_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion1ListAccess().getRefModelCrossReference_0());
		}
		public static IGrammarAwareElementType createNodeExclusion1List_RefModelIDTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("NodeExclusion1List_RefModelIDTerminalRuleCall_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion1ListAccess().getRefModelIDTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType NodeExclusion1List_ELEMENT_TYPE = associate(NodeExclusion1ListFactory.createNodeExclusion1ListElementType());

	public static final IGrammarAwareElementType NodeExclusion1List_RefAssignment_ELEMENT_TYPE = associate(NodeExclusion1ListFactory.createNodeExclusion1List_RefAssignmentElementType());

	public static final IGrammarAwareElementType NodeExclusion1List_RefModelCrossReference_0_ELEMENT_TYPE = associate(NodeExclusion1ListFactory.createNodeExclusion1List_RefModelCrossReference_0ElementType());

	public static final IGrammarAwareElementType NodeExclusion1List_RefModelIDTerminalRuleCall_0_1_ELEMENT_TYPE = associate(NodeExclusion1ListFactory.createNodeExclusion1List_RefModelIDTerminalRuleCall_0_1ElementType());

	private static class NodeExclusion2ListFactory {
		public static IGrammarAwareElementType createNodeExclusion2ListElementType() {
			return new IGrammarAwareElementType("NodeExclusion2List_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion2ListRule());
		}
		public static IGrammarAwareElementType createNodeExclusion2List_RefAssignmentElementType() {
			return new IGrammarAwareElementType("NodeExclusion2List_RefAssignment_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion2ListAccess().getRefAssignment());
		}
		public static IGrammarAwareElementType createNodeExclusion2List_RefModelCrossReference_0ElementType() {
			return new IGrammarAwareElementType("NodeExclusion2List_RefModelCrossReference_0_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion2ListAccess().getRefModelCrossReference_0());
		}
		public static IGrammarAwareElementType createNodeExclusion2List_RefModelSTRINGTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("NodeExclusion2List_RefModelSTRINGTerminalRuleCall_0_1_ELEMENT_TYPE", ContextFinderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeExclusion2ListAccess().getRefModelSTRINGTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType NodeExclusion2List_ELEMENT_TYPE = associate(NodeExclusion2ListFactory.createNodeExclusion2ListElementType());

	public static final IGrammarAwareElementType NodeExclusion2List_RefAssignment_ELEMENT_TYPE = associate(NodeExclusion2ListFactory.createNodeExclusion2List_RefAssignmentElementType());

	public static final IGrammarAwareElementType NodeExclusion2List_RefModelCrossReference_0_ELEMENT_TYPE = associate(NodeExclusion2ListFactory.createNodeExclusion2List_RefModelCrossReference_0ElementType());

	public static final IGrammarAwareElementType NodeExclusion2List_RefModelSTRINGTerminalRuleCall_0_1_ELEMENT_TYPE = associate(NodeExclusion2ListFactory.createNodeExclusion2List_RefModelSTRINGTerminalRuleCall_0_1ElementType());

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

	public IGrammarAwareElementType getModel_NumberSignDigitZeroKeyword_0_0ElementType() {
		return Model_NumberSignDigitZeroKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ModelAssignment_0_1ElementType() {
		return Model_ModelAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ModelModel2ParserRuleCall_0_1_0ElementType() {
		return Model_ModelModel2ParserRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitOneKeyword_1_0ElementType() {
		return Model_NumberSignDigitOneKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributeExclusionAssignment_1_1ElementType() {
		return Model_AttributeExclusionAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributeExclusionAlternatives_1_1_0ElementType() {
		return Model_AttributeExclusionAlternatives_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0ElementType() {
		return Model_AttributeExclusionAttributeExclusionTest1ParserRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1ElementType() {
		return Model_AttributeExclusionAttributeExclusionTest2ParserRuleCall_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_2ElementType() {
		return Model_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitTwoKeyword_2_0ElementType() {
		return Model_NumberSignDigitTwoKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedTypeAssignment_2_1ElementType() {
		return Model_NestedTypeAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedTypeAlternatives_2_1_0ElementType() {
		return Model_NestedTypeAlternatives_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0ElementType() {
		return Model_NestedTypeNestedTypeTest1ParserRuleCall_2_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1ElementType() {
		return Model_NestedTypeNestedTypeTest2ParserRuleCall_2_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_3ElementType() {
		return Model_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitThreeKeyword_3_0ElementType() {
		return Model_NumberSignDigitThreeKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedTypeRecursiveTest2Assignment_3_1ElementType() {
		return Model_NestedTypeRecursiveTest2Assignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedTypeRecursiveTest2Alternatives_3_1_0ElementType() {
		return Model_NestedTypeRecursiveTest2Alternatives_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0ElementType() {
		return Model_NestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_3_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1ElementType() {
		return Model_NestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_3_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_4ElementType() {
		return Model_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitFourKeyword_4_0ElementType() {
		return Model_NumberSignDigitFourKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ParentRefAssignment_4_1ElementType() {
		return Model_ParentRefAssignment_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ParentRefAlternatives_4_1_0ElementType() {
		return Model_ParentRefAlternatives_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ParentRefParentRefTest1ParserRuleCall_4_1_0_0ElementType() {
		return Model_ParentRefParentRefTest1ParserRuleCall_4_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ParentRefParentRefTest2ParserRuleCall_4_1_0_1ElementType() {
		return Model_ParentRefParentRefTest2ParserRuleCall_4_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_5ElementType() {
		return Model_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitFiveKeyword_5_0ElementType() {
		return Model_NumberSignDigitFiveKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_QuantityExclusionAssignment_5_1ElementType() {
		return Model_QuantityExclusionAssignment_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_QuantityExclusionAlternatives_5_1_0ElementType() {
		return Model_QuantityExclusionAlternatives_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_QuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0ElementType() {
		return Model_QuantityExclusionQuantityExclusionTest1ParserRuleCall_5_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_QuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1ElementType() {
		return Model_QuantityExclusionQuantityExclusionTest2ParserRuleCall_5_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_6ElementType() {
		return Model_Group_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitSixKeyword_6_0ElementType() {
		return Model_NumberSignDigitSixKeyword_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueExclusionAssignment_6_1ElementType() {
		return Model_ValueExclusionAssignment_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueExclusionAlternatives_6_1_0ElementType() {
		return Model_ValueExclusionAlternatives_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0ElementType() {
		return Model_ValueExclusionValueExclusionTest1ParserRuleCall_6_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1ElementType() {
		return Model_ValueExclusionValueExclusionTest2ParserRuleCall_6_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_7ElementType() {
		return Model_Group_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitSevenKeyword_7_0ElementType() {
		return Model_NumberSignDigitSevenKeyword_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameAssignment_7_1ElementType() {
		return Model_NameAssignment_7_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameSTRINGTerminalRuleCall_7_1_0ElementType() {
		return Model_NameSTRINGTerminalRuleCall_7_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NodeExclusionAssignment_7_2ElementType() {
		return Model_NodeExclusionAssignment_7_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NodeExclusionAlternatives_7_2_0ElementType() {
		return Model_NodeExclusionAlternatives_7_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0ElementType() {
		return Model_NodeExclusionNodeExclusion1ParserRuleCall_7_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1ElementType() {
		return Model_NodeExclusionNodeExclusion2ParserRuleCall_7_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_8ElementType() {
		return Model_Group_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignDigitEightKeyword_8_0ElementType() {
		return Model_NumberSignDigitEightKeyword_8_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameAssignment_8_1ElementType() {
		return Model_NameAssignment_8_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameSTRINGTerminalRuleCall_8_1_0ElementType() {
		return Model_NameSTRINGTerminalRuleCall_8_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NodeExclusionListAssignment_8_2ElementType() {
		return Model_NodeExclusionListAssignment_8_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NodeExclusionListAlternatives_8_2_0ElementType() {
		return Model_NodeExclusionListAlternatives_8_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0ElementType() {
		return Model_NodeExclusionListNodeExclusion1ListParserRuleCall_8_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1ElementType() {
		return Model_NodeExclusionListNodeExclusion2ListParserRuleCall_8_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel2ElementType() {
		return Model2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel2_GroupElementType() {
		return Model2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel2_ModelAction_0ElementType() {
		return Model2_ModelAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel2_ModelKeyword_1ElementType() {
		return Model2_ModelKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeExclusionTest1ElementType() {
		return AttributeExclusionTest1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeExclusionTest1_GroupElementType() {
		return AttributeExclusionTest1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeExclusionTest1_Kw1Keyword_0ElementType() {
		return AttributeExclusionTest1_Kw1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeExclusionTest1_Attr1Assignment_1ElementType() {
		return AttributeExclusionTest1_Attr1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeExclusionTest1_Attr1IDTerminalRuleCall_1_0ElementType() {
		return AttributeExclusionTest1_Attr1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeExclusionTest2ElementType() {
		return AttributeExclusionTest2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeExclusionTest2_GroupElementType() {
		return AttributeExclusionTest2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeExclusionTest2_Kw2Keyword_0ElementType() {
		return AttributeExclusionTest2_Kw2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeExclusionTest2_Attr2Assignment_1ElementType() {
		return AttributeExclusionTest2_Attr2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeExclusionTest2_Attr2IDTerminalRuleCall_1_0ElementType() {
		return AttributeExclusionTest2_Attr2IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeTest1ElementType() {
		return NestedTypeTest1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeTest1_NestedAssignmentElementType() {
		return NestedTypeTest1_NestedAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeTest1_NestedNestedTypeChild1ParserRuleCall_0ElementType() {
		return NestedTypeTest1_NestedNestedTypeChild1ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeTest2ElementType() {
		return NestedTypeTest2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeTest2_NestedAssignmentElementType() {
		return NestedTypeTest2_NestedAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeTest2_NestedNestedTypeChild2ParserRuleCall_0ElementType() {
		return NestedTypeTest2_NestedNestedTypeChild2ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChildElementType() {
		return NestedTypeChild_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild_AlternativesElementType() {
		return NestedTypeChild_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild_NestedTypeChild1ParserRuleCall_0ElementType() {
		return NestedTypeChild_NestedTypeChild1ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild_NestedTypeChild2ParserRuleCall_1ElementType() {
		return NestedTypeChild_NestedTypeChild2ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild1ElementType() {
		return NestedTypeChild1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild1_GroupElementType() {
		return NestedTypeChild1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild1_Kw1Keyword_0ElementType() {
		return NestedTypeChild1_Kw1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild1_ValAssignment_1ElementType() {
		return NestedTypeChild1_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild1_ValIDTerminalRuleCall_1_0ElementType() {
		return NestedTypeChild1_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild2ElementType() {
		return NestedTypeChild2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild2_GroupElementType() {
		return NestedTypeChild2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild2_Kw2Keyword_0ElementType() {
		return NestedTypeChild2_Kw2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild2_ValAssignment_1ElementType() {
		return NestedTypeChild2_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeChild2_ValIDTerminalRuleCall_1_0ElementType() {
		return NestedTypeChild2_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest1ElementType() {
		return NestedTypeRecursiveTest1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest1_GroupElementType() {
		return NestedTypeRecursiveTest1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest1_NestedTypeRecursiveTest1Action_0ElementType() {
		return NestedTypeRecursiveTest1_NestedTypeRecursiveTest1Action_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest1_Kw1Keyword_1ElementType() {
		return NestedTypeRecursiveTest1_Kw1Keyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest1_Group_2ElementType() {
		return NestedTypeRecursiveTest1_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest1_NestedTypeRecursiveTestLeftAction_2_0ElementType() {
		return NestedTypeRecursiveTest1_NestedTypeRecursiveTestLeftAction_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest1_FullStopKeyword_2_1ElementType() {
		return NestedTypeRecursiveTest1_FullStopKeyword_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest2ElementType() {
		return NestedTypeRecursiveTest2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest2_GroupElementType() {
		return NestedTypeRecursiveTest2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest2_NestedTypeRecursiveTest2Action_0ElementType() {
		return NestedTypeRecursiveTest2_NestedTypeRecursiveTest2Action_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest2_Kw2Keyword_1ElementType() {
		return NestedTypeRecursiveTest2_Kw2Keyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest2_Group_2ElementType() {
		return NestedTypeRecursiveTest2_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest2_NestedTypeRecursiveTestLeftAction_2_0ElementType() {
		return NestedTypeRecursiveTest2_NestedTypeRecursiveTestLeftAction_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedTypeRecursiveTest2_FullStopKeyword_2_1ElementType() {
		return NestedTypeRecursiveTest2_FullStopKeyword_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTest1ElementType() {
		return ParentRefTest1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTest1_GroupElementType() {
		return ParentRefTest1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTest1_Kw1Keyword_0ElementType() {
		return ParentRefTest1_Kw1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTest1_Child1Assignment_1ElementType() {
		return ParentRefTest1_Child1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTest1_Child1ParentRefTestChild1ParserRuleCall_1_0ElementType() {
		return ParentRefTest1_Child1ParentRefTestChild1ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTest2ElementType() {
		return ParentRefTest2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTest2_GroupElementType() {
		return ParentRefTest2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTest2_Kw2Keyword_0ElementType() {
		return ParentRefTest2_Kw2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTest2_Child2Assignment_1ElementType() {
		return ParentRefTest2_Child2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTest2_Child2ParentRefTestChild2ParserRuleCall_1_0ElementType() {
		return ParentRefTest2_Child2ParentRefTestChild2ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild1ElementType() {
		return ParentRefTestChild1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild1_GroupElementType() {
		return ParentRefTestChild1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild1_ParentRefTestChildAction_0ElementType() {
		return ParentRefTestChild1_ParentRefTestChildAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild1_FooKeyword_1ElementType() {
		return ParentRefTestChild1_FooKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild1_ChildAssignment_2ElementType() {
		return ParentRefTestChild1_ChildAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild1_ChildParentRefTestChild1ParserRuleCall_2_0ElementType() {
		return ParentRefTestChild1_ChildParentRefTestChild1ParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild2ElementType() {
		return ParentRefTestChild2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild2_GroupElementType() {
		return ParentRefTestChild2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild2_ParentRefTestChildAction_0ElementType() {
		return ParentRefTestChild2_ParentRefTestChildAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild2_FooKeyword_1ElementType() {
		return ParentRefTestChild2_FooKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild2_ChildAssignment_2ElementType() {
		return ParentRefTestChild2_ChildAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParentRefTestChild2_ChildParentRefTestChild2ParserRuleCall_2_0ElementType() {
		return ParentRefTestChild2_ChildParentRefTestChild2ParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest1ElementType() {
		return QuantityExclusionTest1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest1_GroupElementType() {
		return QuantityExclusionTest1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest1_Kw1Keyword_0ElementType() {
		return QuantityExclusionTest1_Kw1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest1_Attr1Assignment_1ElementType() {
		return QuantityExclusionTest1_Attr1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest1_Attr1IDTerminalRuleCall_1_0ElementType() {
		return QuantityExclusionTest1_Attr1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest1_Attr2Assignment_2ElementType() {
		return QuantityExclusionTest1_Attr2Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest1_Attr2IDTerminalRuleCall_2_0ElementType() {
		return QuantityExclusionTest1_Attr2IDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest2ElementType() {
		return QuantityExclusionTest2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest2_GroupElementType() {
		return QuantityExclusionTest2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest2_Kw2Keyword_0ElementType() {
		return QuantityExclusionTest2_Kw2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest2_Attr1Assignment_1ElementType() {
		return QuantityExclusionTest2_Attr1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest2_Attr1IDTerminalRuleCall_1_0ElementType() {
		return QuantityExclusionTest2_Attr1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest2_Attr2Assignment_2ElementType() {
		return QuantityExclusionTest2_Attr2Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuantityExclusionTest2_Attr2IDTerminalRuleCall_2_0ElementType() {
		return QuantityExclusionTest2_Attr2IDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTest1ElementType() {
		return ValueExclusionTest1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTest1_ValAssignmentElementType() {
		return ValueExclusionTest1_ValAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTest1_ValValueExclusionTestEn1EnumRuleCall_0ElementType() {
		return ValueExclusionTest1_ValValueExclusionTestEn1EnumRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTest2ElementType() {
		return ValueExclusionTest2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTest2_ValAssignmentElementType() {
		return ValueExclusionTest2_ValAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTest2_ValValueExclusionTestEn2EnumRuleCall_0ElementType() {
		return ValueExclusionTest2_ValValueExclusionTestEn2EnumRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTestEn0ElementType() {
		return ValueExclusionTestEn0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTestEn0_Lit0EnumLiteralDeclarationElementType() {
		return ValueExclusionTestEn0_Lit0EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTestEn0_Lit0Lit0Keyword_0ElementType() {
		return ValueExclusionTestEn0_Lit0Lit0Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTestEn1ElementType() {
		return ValueExclusionTestEn1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTestEn1_Lit1EnumLiteralDeclarationElementType() {
		return ValueExclusionTestEn1_Lit1EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTestEn1_Lit1Lit1Keyword_0ElementType() {
		return ValueExclusionTestEn1_Lit1Lit1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTestEn2ElementType() {
		return ValueExclusionTestEn2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTestEn2_Lit2EnumLiteralDeclarationElementType() {
		return ValueExclusionTestEn2_Lit2EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueExclusionTestEn2_Lit2Lit2Keyword_0ElementType() {
		return ValueExclusionTestEn2_Lit2Lit2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion1ElementType() {
		return NodeExclusion1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion1_RefAssignmentElementType() {
		return NodeExclusion1_RefAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion1_RefModelCrossReference_0ElementType() {
		return NodeExclusion1_RefModelCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion1_RefModelIDTerminalRuleCall_0_1ElementType() {
		return NodeExclusion1_RefModelIDTerminalRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion2ElementType() {
		return NodeExclusion2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion2_RefAssignmentElementType() {
		return NodeExclusion2_RefAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion2_RefModelCrossReference_0ElementType() {
		return NodeExclusion2_RefModelCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion2_RefModelSTRINGTerminalRuleCall_0_1ElementType() {
		return NodeExclusion2_RefModelSTRINGTerminalRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion1ListElementType() {
		return NodeExclusion1List_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion1List_RefAssignmentElementType() {
		return NodeExclusion1List_RefAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion1List_RefModelCrossReference_0ElementType() {
		return NodeExclusion1List_RefModelCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion1List_RefModelIDTerminalRuleCall_0_1ElementType() {
		return NodeExclusion1List_RefModelIDTerminalRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion2ListElementType() {
		return NodeExclusion2List_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion2List_RefAssignmentElementType() {
		return NodeExclusion2List_RefAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion2List_RefModelCrossReference_0ElementType() {
		return NodeExclusion2List_RefModelCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeExclusion2List_RefModelSTRINGTerminalRuleCall_0_1ElementType() {
		return NodeExclusion2List_RefModelSTRINGTerminalRuleCall_0_1_ELEMENT_TYPE;
	}

}
