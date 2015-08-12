package org.eclipse.xtext.parser.datatyperules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.datatyperules.idea.lang.psi.impl.DatatypeRulesTestLanguageFileImpl;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class DatatypeRulesTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<DatatypeRulesTestLanguageFileImpl>>(DatatypeRulesTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final DatatypeRulesTestLanguageGrammarAccess GRAMMAR_ACCESS = DatatypeRulesTestLanguageLanguage.INSTANCE.getInstance(DatatypeRulesTestLanguageGrammarAccess.class);

	private static class CompositeModelFactory {
		public static IGrammarAwareElementType createCompositeModelElementType() {
			return new IGrammarAwareElementType("CompositeModel_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCompositeModelRule());
		}
		public static IGrammarAwareElementType createCompositeModel_ModelAssignmentElementType() {
			return new IGrammarAwareElementType("CompositeModel_ModelAssignment_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCompositeModelAccess().getModelAssignment());
		}
		public static IGrammarAwareElementType createCompositeModel_ModelModelParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("CompositeModel_ModelModelParserRuleCall_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCompositeModelAccess().getModelModelParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType CompositeModel_ELEMENT_TYPE = associate(CompositeModelFactory.createCompositeModelElementType());

	public static final IGrammarAwareElementType CompositeModel_ModelAssignment_ELEMENT_TYPE = associate(CompositeModelFactory.createCompositeModel_ModelAssignmentElementType());

	public static final IGrammarAwareElementType CompositeModel_ModelModelParserRuleCall_0_ELEMENT_TYPE = associate(CompositeModelFactory.createCompositeModel_ModelModelParserRuleCall_0ElementType());

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_IdAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_IdAssignment_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getIdAssignment_0());
		}
		public static IGrammarAwareElementType createModel_IdNestedModelIdParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_IdNestedModelIdParserRuleCall_0_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getIdNestedModelIdParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_ColonKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ColonKeyword_1_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getColonKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_1_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_ValueFractionParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueFractionParserRuleCall_1_1_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueFractionParserRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_2_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createModel_NumberSignKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_NumberSignKeyword_2_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNumberSignKeyword_2_0());
		}
		public static IGrammarAwareElementType createModel_VectorAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Model_VectorAssignment_2_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getVectorAssignment_2_1());
		}
		public static IGrammarAwareElementType createModel_VectorVectorParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_VectorVectorParserRuleCall_2_1_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getVectorVectorParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_3ElementType() {
			return new IGrammarAwareElementType("Model_Group_3_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createModel_PlusSignKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Model_PlusSignKeyword_3_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getPlusSignKeyword_3_0());
		}
		public static IGrammarAwareElementType createModel_DotsAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Model_DotsAssignment_3_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDotsAssignment_3_1());
		}
		public static IGrammarAwareElementType createModel_DotsDotsParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Model_DotsDotsParserRuleCall_3_1_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDotsDotsParserRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_4ElementType() {
			return new IGrammarAwareElementType("Model_Group_4_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createModel_AsteriskKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("Model_AsteriskKeyword_4_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAsteriskKeyword_4_0());
		}
		public static IGrammarAwareElementType createModel_DoubleAssignment_4_1ElementType() {
			return new IGrammarAwareElementType("Model_DoubleAssignment_4_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDoubleAssignment_4_1());
		}
		public static IGrammarAwareElementType createModel_DoubleDoubleParserRuleCall_4_1_0ElementType() {
			return new IGrammarAwareElementType("Model_DoubleDoubleParserRuleCall_4_1_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDoubleDoubleParserRuleCall_4_1_0());
		}
		public static IGrammarAwareElementType createModel_SemicolonKeyword_5ElementType() {
			return new IGrammarAwareElementType("Model_SemicolonKeyword_5_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSemicolonKeyword_5());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_IdAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_IdAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_IdNestedModelIdParserRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_IdNestedModelIdParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_ColonKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ColonKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_ValueFractionParserRuleCall_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueFractionParserRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_2ElementType());

	public static final IGrammarAwareElementType Model_NumberSignKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NumberSignKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Model_VectorAssignment_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_VectorAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Model_VectorVectorParserRuleCall_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_VectorVectorParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_3_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_3ElementType());

	public static final IGrammarAwareElementType Model_PlusSignKeyword_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_PlusSignKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Model_DotsAssignment_3_1_ELEMENT_TYPE = associate(ModelFactory.createModel_DotsAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Model_DotsDotsParserRuleCall_3_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DotsDotsParserRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_4_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_4ElementType());

	public static final IGrammarAwareElementType Model_AsteriskKeyword_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AsteriskKeyword_4_0ElementType());

	public static final IGrammarAwareElementType Model_DoubleAssignment_4_1_ELEMENT_TYPE = associate(ModelFactory.createModel_DoubleAssignment_4_1ElementType());

	public static final IGrammarAwareElementType Model_DoubleDoubleParserRuleCall_4_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DoubleDoubleParserRuleCall_4_1_0ElementType());

	public static final IGrammarAwareElementType Model_SemicolonKeyword_5_ELEMENT_TYPE = associate(ModelFactory.createModel_SemicolonKeyword_5ElementType());

	private static class ModelIdFactory {
		public static IGrammarAwareElementType createModelIdElementType() {
			return new IGrammarAwareElementType("ModelId_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelIdRule());
		}
		public static IGrammarAwareElementType createModelId_GroupElementType() {
			return new IGrammarAwareElementType("ModelId_Group_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelIdAccess().getGroup());
		}
		public static IGrammarAwareElementType createModelId_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("ModelId_IDTerminalRuleCall_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelIdAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createModelId_FullStopKeyword_1ElementType() {
			return new IGrammarAwareElementType("ModelId_FullStopKeyword_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelIdAccess().getFullStopKeyword_1());
		}
		public static IGrammarAwareElementType createModelId_IDTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("ModelId_IDTerminalRuleCall_2_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelIdAccess().getIDTerminalRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType ModelId_ELEMENT_TYPE = associate(ModelIdFactory.createModelIdElementType());

	public static final IGrammarAwareElementType ModelId_Group_ELEMENT_TYPE = associate(ModelIdFactory.createModelId_GroupElementType());

	public static final IGrammarAwareElementType ModelId_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(ModelIdFactory.createModelId_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType ModelId_FullStopKeyword_1_ELEMENT_TYPE = associate(ModelIdFactory.createModelId_FullStopKeyword_1ElementType());

	public static final IGrammarAwareElementType ModelId_IDTerminalRuleCall_2_ELEMENT_TYPE = associate(ModelIdFactory.createModelId_IDTerminalRuleCall_2ElementType());

	private static class NestedModelIdFactory {
		public static IGrammarAwareElementType createNestedModelIdElementType() {
			return new IGrammarAwareElementType("NestedModelId_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelIdRule());
		}
		public static IGrammarAwareElementType createNestedModelId_GroupElementType() {
			return new IGrammarAwareElementType("NestedModelId_Group_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelIdAccess().getGroup());
		}
		public static IGrammarAwareElementType createNestedModelId_ModelIdParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("NestedModelId_ModelIdParserRuleCall_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelIdAccess().getModelIdParserRuleCall_0());
		}
		public static IGrammarAwareElementType createNestedModelId_FullStopKeyword_1ElementType() {
			return new IGrammarAwareElementType("NestedModelId_FullStopKeyword_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelIdAccess().getFullStopKeyword_1());
		}
		public static IGrammarAwareElementType createNestedModelId_ModelIdParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("NestedModelId_ModelIdParserRuleCall_2_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelIdAccess().getModelIdParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType NestedModelId_ELEMENT_TYPE = associate(NestedModelIdFactory.createNestedModelIdElementType());

	public static final IGrammarAwareElementType NestedModelId_Group_ELEMENT_TYPE = associate(NestedModelIdFactory.createNestedModelId_GroupElementType());

	public static final IGrammarAwareElementType NestedModelId_ModelIdParserRuleCall_0_ELEMENT_TYPE = associate(NestedModelIdFactory.createNestedModelId_ModelIdParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType NestedModelId_FullStopKeyword_1_ELEMENT_TYPE = associate(NestedModelIdFactory.createNestedModelId_FullStopKeyword_1ElementType());

	public static final IGrammarAwareElementType NestedModelId_ModelIdParserRuleCall_2_ELEMENT_TYPE = associate(NestedModelIdFactory.createNestedModelId_ModelIdParserRuleCall_2ElementType());

	private static class FractionFactory {
		public static IGrammarAwareElementType createFractionElementType() {
			return new IGrammarAwareElementType("Fraction_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFractionRule());
		}
		public static IGrammarAwareElementType createFraction_GroupElementType() {
			return new IGrammarAwareElementType("Fraction_Group_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFractionAccess().getGroup());
		}
		public static IGrammarAwareElementType createFraction_INTTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Fraction_INTTerminalRuleCall_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFractionAccess().getINTTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFraction_Group_1ElementType() {
			return new IGrammarAwareElementType("Fraction_Group_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFractionAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createFraction_SolidusKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Fraction_SolidusKeyword_1_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFractionAccess().getSolidusKeyword_1_0());
		}
		public static IGrammarAwareElementType createFraction_INTTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("Fraction_INTTerminalRuleCall_1_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFractionAccess().getINTTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType Fraction_ELEMENT_TYPE = associate(FractionFactory.createFractionElementType());

	public static final IGrammarAwareElementType Fraction_Group_ELEMENT_TYPE = associate(FractionFactory.createFraction_GroupElementType());

	public static final IGrammarAwareElementType Fraction_INTTerminalRuleCall_0_ELEMENT_TYPE = associate(FractionFactory.createFraction_INTTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType Fraction_Group_1_ELEMENT_TYPE = associate(FractionFactory.createFraction_Group_1ElementType());

	public static final IGrammarAwareElementType Fraction_SolidusKeyword_1_0_ELEMENT_TYPE = associate(FractionFactory.createFraction_SolidusKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Fraction_INTTerminalRuleCall_1_1_ELEMENT_TYPE = associate(FractionFactory.createFraction_INTTerminalRuleCall_1_1ElementType());

	private static class VectorFactory {
		public static IGrammarAwareElementType createVectorElementType() {
			return new IGrammarAwareElementType("Vector_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVectorRule());
		}
		public static IGrammarAwareElementType createVector_GroupElementType() {
			return new IGrammarAwareElementType("Vector_Group_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVectorAccess().getGroup());
		}
		public static IGrammarAwareElementType createVector_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("Vector_LeftParenthesisKeyword_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVectorAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createVector_INTTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Vector_INTTerminalRuleCall_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVectorAccess().getINTTerminalRuleCall_1());
		}
		public static IGrammarAwareElementType createVector_INTTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Vector_INTTerminalRuleCall_2_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVectorAccess().getINTTerminalRuleCall_2());
		}
		public static IGrammarAwareElementType createVector_RightParenthesisKeyword_3ElementType() {
			return new IGrammarAwareElementType("Vector_RightParenthesisKeyword_3_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVectorAccess().getRightParenthesisKeyword_3());
		}
	}

	public static final IGrammarAwareElementType Vector_ELEMENT_TYPE = associate(VectorFactory.createVectorElementType());

	public static final IGrammarAwareElementType Vector_Group_ELEMENT_TYPE = associate(VectorFactory.createVector_GroupElementType());

	public static final IGrammarAwareElementType Vector_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(VectorFactory.createVector_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType Vector_INTTerminalRuleCall_1_ELEMENT_TYPE = associate(VectorFactory.createVector_INTTerminalRuleCall_1ElementType());

	public static final IGrammarAwareElementType Vector_INTTerminalRuleCall_2_ELEMENT_TYPE = associate(VectorFactory.createVector_INTTerminalRuleCall_2ElementType());

	public static final IGrammarAwareElementType Vector_RightParenthesisKeyword_3_ELEMENT_TYPE = associate(VectorFactory.createVector_RightParenthesisKeyword_3ElementType());

	private static class DotsFactory {
		public static IGrammarAwareElementType createDotsElementType() {
			return new IGrammarAwareElementType("Dots_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDotsRule());
		}
		public static IGrammarAwareElementType createDots_AlternativesElementType() {
			return new IGrammarAwareElementType("Dots_Alternatives_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDotsAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createDots_Group_0ElementType() {
			return new IGrammarAwareElementType("Dots_Group_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDotsAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createDots_FullStopKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Dots_FullStopKeyword_0_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDotsAccess().getFullStopKeyword_0_0());
		}
		public static IGrammarAwareElementType createDots_FullStopKeyword_0_1ElementType() {
			return new IGrammarAwareElementType("Dots_FullStopKeyword_0_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDotsAccess().getFullStopKeyword_0_1());
		}
		public static IGrammarAwareElementType createDots_FullStopFullStopKeyword_1ElementType() {
			return new IGrammarAwareElementType("Dots_FullStopFullStopKeyword_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDotsAccess().getFullStopFullStopKeyword_1());
		}
	}

	public static final IGrammarAwareElementType Dots_ELEMENT_TYPE = associate(DotsFactory.createDotsElementType());

	public static final IGrammarAwareElementType Dots_Alternatives_ELEMENT_TYPE = associate(DotsFactory.createDots_AlternativesElementType());

	public static final IGrammarAwareElementType Dots_Group_0_ELEMENT_TYPE = associate(DotsFactory.createDots_Group_0ElementType());

	public static final IGrammarAwareElementType Dots_FullStopKeyword_0_0_ELEMENT_TYPE = associate(DotsFactory.createDots_FullStopKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Dots_FullStopKeyword_0_1_ELEMENT_TYPE = associate(DotsFactory.createDots_FullStopKeyword_0_1ElementType());

	public static final IGrammarAwareElementType Dots_FullStopFullStopKeyword_1_ELEMENT_TYPE = associate(DotsFactory.createDots_FullStopFullStopKeyword_1ElementType());

	private static class DoubleFactory {
		public static IGrammarAwareElementType createDoubleElementType() {
			return new IGrammarAwareElementType("Double_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDoubleRule());
		}
		public static IGrammarAwareElementType createDouble_GroupElementType() {
			return new IGrammarAwareElementType("Double_Group_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDoubleAccess().getGroup());
		}
		public static IGrammarAwareElementType createDouble_HyphenMinusKeyword_0ElementType() {
			return new IGrammarAwareElementType("Double_HyphenMinusKeyword_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDoubleAccess().getHyphenMinusKeyword_0());
		}
		public static IGrammarAwareElementType createDouble_INTTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Double_INTTerminalRuleCall_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDoubleAccess().getINTTerminalRuleCall_1());
		}
		public static IGrammarAwareElementType createDouble_FullStopKeyword_2ElementType() {
			return new IGrammarAwareElementType("Double_FullStopKeyword_2_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDoubleAccess().getFullStopKeyword_2());
		}
		public static IGrammarAwareElementType createDouble_INTTerminalRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Double_INTTerminalRuleCall_3_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDoubleAccess().getINTTerminalRuleCall_3());
		}
		public static IGrammarAwareElementType createDouble_Group_4ElementType() {
			return new IGrammarAwareElementType("Double_Group_4_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDoubleAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createDouble_EKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("Double_EKeyword_4_0_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDoubleAccess().getEKeyword_4_0());
		}
		public static IGrammarAwareElementType createDouble_HyphenMinusKeyword_4_1ElementType() {
			return new IGrammarAwareElementType("Double_HyphenMinusKeyword_4_1_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDoubleAccess().getHyphenMinusKeyword_4_1());
		}
		public static IGrammarAwareElementType createDouble_INTTerminalRuleCall_4_2ElementType() {
			return new IGrammarAwareElementType("Double_INTTerminalRuleCall_4_2_ELEMENT_TYPE", DatatypeRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDoubleAccess().getINTTerminalRuleCall_4_2());
		}
	}

	public static final IGrammarAwareElementType Double_ELEMENT_TYPE = associate(DoubleFactory.createDoubleElementType());

	public static final IGrammarAwareElementType Double_Group_ELEMENT_TYPE = associate(DoubleFactory.createDouble_GroupElementType());

	public static final IGrammarAwareElementType Double_HyphenMinusKeyword_0_ELEMENT_TYPE = associate(DoubleFactory.createDouble_HyphenMinusKeyword_0ElementType());

	public static final IGrammarAwareElementType Double_INTTerminalRuleCall_1_ELEMENT_TYPE = associate(DoubleFactory.createDouble_INTTerminalRuleCall_1ElementType());

	public static final IGrammarAwareElementType Double_FullStopKeyword_2_ELEMENT_TYPE = associate(DoubleFactory.createDouble_FullStopKeyword_2ElementType());

	public static final IGrammarAwareElementType Double_INTTerminalRuleCall_3_ELEMENT_TYPE = associate(DoubleFactory.createDouble_INTTerminalRuleCall_3ElementType());

	public static final IGrammarAwareElementType Double_Group_4_ELEMENT_TYPE = associate(DoubleFactory.createDouble_Group_4ElementType());

	public static final IGrammarAwareElementType Double_EKeyword_4_0_ELEMENT_TYPE = associate(DoubleFactory.createDouble_EKeyword_4_0ElementType());

	public static final IGrammarAwareElementType Double_HyphenMinusKeyword_4_1_ELEMENT_TYPE = associate(DoubleFactory.createDouble_HyphenMinusKeyword_4_1ElementType());

	public static final IGrammarAwareElementType Double_INTTerminalRuleCall_4_2_ELEMENT_TYPE = associate(DoubleFactory.createDouble_INTTerminalRuleCall_4_2ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getCompositeModelElementType() {
		return CompositeModel_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCompositeModel_ModelAssignmentElementType() {
		return CompositeModel_ModelAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCompositeModel_ModelModelParserRuleCall_0ElementType() {
		return CompositeModel_ModelModelParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElementType() {
		return Model_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GroupElementType() {
		return Model_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_IdAssignment_0ElementType() {
		return Model_IdAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_IdNestedModelIdParserRuleCall_0_0ElementType() {
		return Model_IdNestedModelIdParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ColonKeyword_1_0ElementType() {
		return Model_ColonKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_1_1ElementType() {
		return Model_ValueAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueFractionParserRuleCall_1_1_0ElementType() {
		return Model_ValueFractionParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_2ElementType() {
		return Model_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NumberSignKeyword_2_0ElementType() {
		return Model_NumberSignKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_VectorAssignment_2_1ElementType() {
		return Model_VectorAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_VectorVectorParserRuleCall_2_1_0ElementType() {
		return Model_VectorVectorParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_3ElementType() {
		return Model_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_PlusSignKeyword_3_0ElementType() {
		return Model_PlusSignKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DotsAssignment_3_1ElementType() {
		return Model_DotsAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DotsDotsParserRuleCall_3_1_0ElementType() {
		return Model_DotsDotsParserRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_4ElementType() {
		return Model_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AsteriskKeyword_4_0ElementType() {
		return Model_AsteriskKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DoubleAssignment_4_1ElementType() {
		return Model_DoubleAssignment_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DoubleDoubleParserRuleCall_4_1_0ElementType() {
		return Model_DoubleDoubleParserRuleCall_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SemicolonKeyword_5ElementType() {
		return Model_SemicolonKeyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelIdElementType() {
		return ModelId_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelId_GroupElementType() {
		return ModelId_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelId_IDTerminalRuleCall_0ElementType() {
		return ModelId_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelId_FullStopKeyword_1ElementType() {
		return ModelId_FullStopKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelId_IDTerminalRuleCall_2ElementType() {
		return ModelId_IDTerminalRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModelIdElementType() {
		return NestedModelId_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModelId_GroupElementType() {
		return NestedModelId_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModelId_ModelIdParserRuleCall_0ElementType() {
		return NestedModelId_ModelIdParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModelId_FullStopKeyword_1ElementType() {
		return NestedModelId_FullStopKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModelId_ModelIdParserRuleCall_2ElementType() {
		return NestedModelId_ModelIdParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFractionElementType() {
		return Fraction_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFraction_GroupElementType() {
		return Fraction_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFraction_INTTerminalRuleCall_0ElementType() {
		return Fraction_INTTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFraction_Group_1ElementType() {
		return Fraction_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFraction_SolidusKeyword_1_0ElementType() {
		return Fraction_SolidusKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFraction_INTTerminalRuleCall_1_1ElementType() {
		return Fraction_INTTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVectorElementType() {
		return Vector_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVector_GroupElementType() {
		return Vector_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVector_LeftParenthesisKeyword_0ElementType() {
		return Vector_LeftParenthesisKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVector_INTTerminalRuleCall_1ElementType() {
		return Vector_INTTerminalRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVector_INTTerminalRuleCall_2ElementType() {
		return Vector_INTTerminalRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVector_RightParenthesisKeyword_3ElementType() {
		return Vector_RightParenthesisKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDotsElementType() {
		return Dots_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDots_AlternativesElementType() {
		return Dots_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDots_Group_0ElementType() {
		return Dots_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDots_FullStopKeyword_0_0ElementType() {
		return Dots_FullStopKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDots_FullStopKeyword_0_1ElementType() {
		return Dots_FullStopKeyword_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDots_FullStopFullStopKeyword_1ElementType() {
		return Dots_FullStopFullStopKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDoubleElementType() {
		return Double_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDouble_GroupElementType() {
		return Double_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDouble_HyphenMinusKeyword_0ElementType() {
		return Double_HyphenMinusKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDouble_INTTerminalRuleCall_1ElementType() {
		return Double_INTTerminalRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDouble_FullStopKeyword_2ElementType() {
		return Double_FullStopKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDouble_INTTerminalRuleCall_3ElementType() {
		return Double_INTTerminalRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDouble_Group_4ElementType() {
		return Double_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDouble_EKeyword_4_0ElementType() {
		return Double_EKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDouble_HyphenMinusKeyword_4_1ElementType() {
		return Double_HyphenMinusKeyword_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDouble_INTTerminalRuleCall_4_2ElementType() {
		return Double_INTTerminalRuleCall_4_2_ELEMENT_TYPE;
	}

}
