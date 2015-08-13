package org.eclipse.xtext.validation.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.validation.idea.lang.psi.impl.ConcreteSyntaxValidationTestLanguageFileImpl;
import org.eclipse.xtext.validation.services.ConcreteSyntaxValidationTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class ConcreteSyntaxValidationTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<ConcreteSyntaxValidationTestLanguageFileImpl>>(ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final ConcreteSyntaxValidationTestLanguageGrammarAccess GRAMMAR_ACCESS = ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE.getInstance(ConcreteSyntaxValidationTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_X1Assignment_0ElementType() {
			return new IGrammarAwareElementType("Model_X1Assignment_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX1Assignment_0());
		}
		public static IGrammarAwareElementType createModel_X1SimpleGroupParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_X1SimpleGroupParserRuleCall_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX1SimpleGroupParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_X2Assignment_1ElementType() {
			return new IGrammarAwareElementType("Model_X2Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX2Assignment_1());
		}
		public static IGrammarAwareElementType createModel_X2SimpleAlternativeParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_X2SimpleAlternativeParserRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX2SimpleAlternativeParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModel_X3Assignment_2ElementType() {
			return new IGrammarAwareElementType("Model_X3Assignment_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX3Assignment_2());
		}
		public static IGrammarAwareElementType createModel_X3SimpleMultiplicitiesParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Model_X3SimpleMultiplicitiesParserRuleCall_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX3SimpleMultiplicitiesParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createModel_X4Assignment_3ElementType() {
			return new IGrammarAwareElementType("Model_X4Assignment_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX4Assignment_3());
		}
		public static IGrammarAwareElementType createModel_X4GroupMultiplicitiesParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Model_X4GroupMultiplicitiesParserRuleCall_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX4GroupMultiplicitiesParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createModel_X5Assignment_4ElementType() {
			return new IGrammarAwareElementType("Model_X5Assignment_4_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX5Assignment_4());
		}
		public static IGrammarAwareElementType createModel_X5AlternativeMultiplicitiesParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Model_X5AlternativeMultiplicitiesParserRuleCall_4_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX5AlternativeMultiplicitiesParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createModel_X6Assignment_5ElementType() {
			return new IGrammarAwareElementType("Model_X6Assignment_5_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX6Assignment_5());
		}
		public static IGrammarAwareElementType createModel_X6AssignedActionParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("Model_X6AssignedActionParserRuleCall_5_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX6AssignedActionParserRuleCall_5_0());
		}
		public static IGrammarAwareElementType createModel_X7Assignment_6ElementType() {
			return new IGrammarAwareElementType("Model_X7Assignment_6_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX7Assignment_6());
		}
		public static IGrammarAwareElementType createModel_X7AssignedActionSecondParserRuleCall_6_0ElementType() {
			return new IGrammarAwareElementType("Model_X7AssignedActionSecondParserRuleCall_6_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX7AssignedActionSecondParserRuleCall_6_0());
		}
		public static IGrammarAwareElementType createModel_X8Assignment_7ElementType() {
			return new IGrammarAwareElementType("Model_X8Assignment_7_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX8Assignment_7());
		}
		public static IGrammarAwareElementType createModel_X8UnassignedAction1ParserRuleCall_7_0ElementType() {
			return new IGrammarAwareElementType("Model_X8UnassignedAction1ParserRuleCall_7_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX8UnassignedAction1ParserRuleCall_7_0());
		}
		public static IGrammarAwareElementType createModel_X9Assignment_8ElementType() {
			return new IGrammarAwareElementType("Model_X9Assignment_8_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX9Assignment_8());
		}
		public static IGrammarAwareElementType createModel_X9UnassignedAction2ParserRuleCall_8_0ElementType() {
			return new IGrammarAwareElementType("Model_X9UnassignedAction2ParserRuleCall_8_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX9UnassignedAction2ParserRuleCall_8_0());
		}
		public static IGrammarAwareElementType createModel_X10Assignment_9ElementType() {
			return new IGrammarAwareElementType("Model_X10Assignment_9_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX10Assignment_9());
		}
		public static IGrammarAwareElementType createModel_X10UnassignedAction3ParserRuleCall_9_0ElementType() {
			return new IGrammarAwareElementType("Model_X10UnassignedAction3ParserRuleCall_9_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX10UnassignedAction3ParserRuleCall_9_0());
		}
		public static IGrammarAwareElementType createModel_X11Assignment_10ElementType() {
			return new IGrammarAwareElementType("Model_X11Assignment_10_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX11Assignment_10());
		}
		public static IGrammarAwareElementType createModel_X11UnassignedRuleCall1ParserRuleCall_10_0ElementType() {
			return new IGrammarAwareElementType("Model_X11UnassignedRuleCall1ParserRuleCall_10_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX11UnassignedRuleCall1ParserRuleCall_10_0());
		}
		public static IGrammarAwareElementType createModel_X12Assignment_11ElementType() {
			return new IGrammarAwareElementType("Model_X12Assignment_11_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX12Assignment_11());
		}
		public static IGrammarAwareElementType createModel_X12UnassignedRuleCall2ParserRuleCall_11_0ElementType() {
			return new IGrammarAwareElementType("Model_X12UnassignedRuleCall2ParserRuleCall_11_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX12UnassignedRuleCall2ParserRuleCall_11_0());
		}
		public static IGrammarAwareElementType createModel_X13Assignment_12ElementType() {
			return new IGrammarAwareElementType("Model_X13Assignment_12_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX13Assignment_12());
		}
		public static IGrammarAwareElementType createModel_X13Combination1ParserRuleCall_12_0ElementType() {
			return new IGrammarAwareElementType("Model_X13Combination1ParserRuleCall_12_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX13Combination1ParserRuleCall_12_0());
		}
		public static IGrammarAwareElementType createModel_X14Assignment_13ElementType() {
			return new IGrammarAwareElementType("Model_X14Assignment_13_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX14Assignment_13());
		}
		public static IGrammarAwareElementType createModel_X14Combination2ParserRuleCall_13_0ElementType() {
			return new IGrammarAwareElementType("Model_X14Combination2ParserRuleCall_13_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX14Combination2ParserRuleCall_13_0());
		}
		public static IGrammarAwareElementType createModel_X15Assignment_14ElementType() {
			return new IGrammarAwareElementType("Model_X15Assignment_14_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX15Assignment_14());
		}
		public static IGrammarAwareElementType createModel_X15Combination3ParserRuleCall_14_0ElementType() {
			return new IGrammarAwareElementType("Model_X15Combination3ParserRuleCall_14_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX15Combination3ParserRuleCall_14_0());
		}
		public static IGrammarAwareElementType createModel_X16Assignment_15ElementType() {
			return new IGrammarAwareElementType("Model_X16Assignment_15_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX16Assignment_15());
		}
		public static IGrammarAwareElementType createModel_X16Combination4ParserRuleCall_15_0ElementType() {
			return new IGrammarAwareElementType("Model_X16Combination4ParserRuleCall_15_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX16Combination4ParserRuleCall_15_0());
		}
		public static IGrammarAwareElementType createModel_X17Assignment_16ElementType() {
			return new IGrammarAwareElementType("Model_X17Assignment_16_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX17Assignment_16());
		}
		public static IGrammarAwareElementType createModel_X17List1ParserRuleCall_16_0ElementType() {
			return new IGrammarAwareElementType("Model_X17List1ParserRuleCall_16_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX17List1ParserRuleCall_16_0());
		}
		public static IGrammarAwareElementType createModel_X18Assignment_17ElementType() {
			return new IGrammarAwareElementType("Model_X18Assignment_17_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX18Assignment_17());
		}
		public static IGrammarAwareElementType createModel_X18List2ParserRuleCall_17_0ElementType() {
			return new IGrammarAwareElementType("Model_X18List2ParserRuleCall_17_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX18List2ParserRuleCall_17_0());
		}
		public static IGrammarAwareElementType createModel_X19Assignment_18ElementType() {
			return new IGrammarAwareElementType("Model_X19Assignment_18_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX19Assignment_18());
		}
		public static IGrammarAwareElementType createModel_X19List3ParserRuleCall_18_0ElementType() {
			return new IGrammarAwareElementType("Model_X19List3ParserRuleCall_18_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX19List3ParserRuleCall_18_0());
		}
		public static IGrammarAwareElementType createModel_X20Assignment_19ElementType() {
			return new IGrammarAwareElementType("Model_X20Assignment_19_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX20Assignment_19());
		}
		public static IGrammarAwareElementType createModel_X20List4ParserRuleCall_19_0ElementType() {
			return new IGrammarAwareElementType("Model_X20List4ParserRuleCall_19_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX20List4ParserRuleCall_19_0());
		}
		public static IGrammarAwareElementType createModel_X21Assignment_20ElementType() {
			return new IGrammarAwareElementType("Model_X21Assignment_20_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX21Assignment_20());
		}
		public static IGrammarAwareElementType createModel_X21List5ParserRuleCall_20_0ElementType() {
			return new IGrammarAwareElementType("Model_X21List5ParserRuleCall_20_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX21List5ParserRuleCall_20_0());
		}
		public static IGrammarAwareElementType createModel_X22Assignment_21ElementType() {
			return new IGrammarAwareElementType("Model_X22Assignment_21_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX22Assignment_21());
		}
		public static IGrammarAwareElementType createModel_X22AltList1ParserRuleCall_21_0ElementType() {
			return new IGrammarAwareElementType("Model_X22AltList1ParserRuleCall_21_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX22AltList1ParserRuleCall_21_0());
		}
		public static IGrammarAwareElementType createModel_X23Assignment_22ElementType() {
			return new IGrammarAwareElementType("Model_X23Assignment_22_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX23Assignment_22());
		}
		public static IGrammarAwareElementType createModel_X23AltList2ParserRuleCall_22_0ElementType() {
			return new IGrammarAwareElementType("Model_X23AltList2ParserRuleCall_22_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX23AltList2ParserRuleCall_22_0());
		}
		public static IGrammarAwareElementType createModel_X24Assignment_23ElementType() {
			return new IGrammarAwareElementType("Model_X24Assignment_23_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX24Assignment_23());
		}
		public static IGrammarAwareElementType createModel_X24TransientObjectParserRuleCall_23_0ElementType() {
			return new IGrammarAwareElementType("Model_X24TransientObjectParserRuleCall_23_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX24TransientObjectParserRuleCall_23_0());
		}
		public static IGrammarAwareElementType createModel_X25Assignment_24ElementType() {
			return new IGrammarAwareElementType("Model_X25Assignment_24_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX25Assignment_24());
		}
		public static IGrammarAwareElementType createModel_X25TransientSerializeables1ParserRuleCall_24_0ElementType() {
			return new IGrammarAwareElementType("Model_X25TransientSerializeables1ParserRuleCall_24_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX25TransientSerializeables1ParserRuleCall_24_0());
		}
		public static IGrammarAwareElementType createModel_X26Assignment_25ElementType() {
			return new IGrammarAwareElementType("Model_X26Assignment_25_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX26Assignment_25());
		}
		public static IGrammarAwareElementType createModel_X26StaticSimplificationParserRuleCall_25_0ElementType() {
			return new IGrammarAwareElementType("Model_X26StaticSimplificationParserRuleCall_25_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX26StaticSimplificationParserRuleCall_25_0());
		}
		public static IGrammarAwareElementType createModel_X27Assignment_26ElementType() {
			return new IGrammarAwareElementType("Model_X27Assignment_26_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX27Assignment_26());
		}
		public static IGrammarAwareElementType createModel_X27TwoVersionParserRuleCall_26_0ElementType() {
			return new IGrammarAwareElementType("Model_X27TwoVersionParserRuleCall_26_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX27TwoVersionParserRuleCall_26_0());
		}
		public static IGrammarAwareElementType createModel_X28Assignment_27ElementType() {
			return new IGrammarAwareElementType("Model_X28Assignment_27_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX28Assignment_27());
		}
		public static IGrammarAwareElementType createModel_X28Heuristic1ParserRuleCall_27_0ElementType() {
			return new IGrammarAwareElementType("Model_X28Heuristic1ParserRuleCall_27_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX28Heuristic1ParserRuleCall_27_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_X1Assignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X1Assignment_0ElementType());

	public static final IGrammarAwareElementType Model_X1SimpleGroupParserRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X1SimpleGroupParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_X2Assignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_X2Assignment_1ElementType());

	public static final IGrammarAwareElementType Model_X2SimpleAlternativeParserRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X2SimpleAlternativeParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Model_X3Assignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_X3Assignment_2ElementType());

	public static final IGrammarAwareElementType Model_X3SimpleMultiplicitiesParserRuleCall_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X3SimpleMultiplicitiesParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Model_X4Assignment_3_ELEMENT_TYPE = associate(ModelFactory.createModel_X4Assignment_3ElementType());

	public static final IGrammarAwareElementType Model_X4GroupMultiplicitiesParserRuleCall_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X4GroupMultiplicitiesParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Model_X5Assignment_4_ELEMENT_TYPE = associate(ModelFactory.createModel_X5Assignment_4ElementType());

	public static final IGrammarAwareElementType Model_X5AlternativeMultiplicitiesParserRuleCall_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X5AlternativeMultiplicitiesParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Model_X6Assignment_5_ELEMENT_TYPE = associate(ModelFactory.createModel_X6Assignment_5ElementType());

	public static final IGrammarAwareElementType Model_X6AssignedActionParserRuleCall_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X6AssignedActionParserRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType Model_X7Assignment_6_ELEMENT_TYPE = associate(ModelFactory.createModel_X7Assignment_6ElementType());

	public static final IGrammarAwareElementType Model_X7AssignedActionSecondParserRuleCall_6_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X7AssignedActionSecondParserRuleCall_6_0ElementType());

	public static final IGrammarAwareElementType Model_X8Assignment_7_ELEMENT_TYPE = associate(ModelFactory.createModel_X8Assignment_7ElementType());

	public static final IGrammarAwareElementType Model_X8UnassignedAction1ParserRuleCall_7_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X8UnassignedAction1ParserRuleCall_7_0ElementType());

	public static final IGrammarAwareElementType Model_X9Assignment_8_ELEMENT_TYPE = associate(ModelFactory.createModel_X9Assignment_8ElementType());

	public static final IGrammarAwareElementType Model_X9UnassignedAction2ParserRuleCall_8_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X9UnassignedAction2ParserRuleCall_8_0ElementType());

	public static final IGrammarAwareElementType Model_X10Assignment_9_ELEMENT_TYPE = associate(ModelFactory.createModel_X10Assignment_9ElementType());

	public static final IGrammarAwareElementType Model_X10UnassignedAction3ParserRuleCall_9_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X10UnassignedAction3ParserRuleCall_9_0ElementType());

	public static final IGrammarAwareElementType Model_X11Assignment_10_ELEMENT_TYPE = associate(ModelFactory.createModel_X11Assignment_10ElementType());

	public static final IGrammarAwareElementType Model_X11UnassignedRuleCall1ParserRuleCall_10_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X11UnassignedRuleCall1ParserRuleCall_10_0ElementType());

	public static final IGrammarAwareElementType Model_X12Assignment_11_ELEMENT_TYPE = associate(ModelFactory.createModel_X12Assignment_11ElementType());

	public static final IGrammarAwareElementType Model_X12UnassignedRuleCall2ParserRuleCall_11_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X12UnassignedRuleCall2ParserRuleCall_11_0ElementType());

	public static final IGrammarAwareElementType Model_X13Assignment_12_ELEMENT_TYPE = associate(ModelFactory.createModel_X13Assignment_12ElementType());

	public static final IGrammarAwareElementType Model_X13Combination1ParserRuleCall_12_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X13Combination1ParserRuleCall_12_0ElementType());

	public static final IGrammarAwareElementType Model_X14Assignment_13_ELEMENT_TYPE = associate(ModelFactory.createModel_X14Assignment_13ElementType());

	public static final IGrammarAwareElementType Model_X14Combination2ParserRuleCall_13_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X14Combination2ParserRuleCall_13_0ElementType());

	public static final IGrammarAwareElementType Model_X15Assignment_14_ELEMENT_TYPE = associate(ModelFactory.createModel_X15Assignment_14ElementType());

	public static final IGrammarAwareElementType Model_X15Combination3ParserRuleCall_14_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X15Combination3ParserRuleCall_14_0ElementType());

	public static final IGrammarAwareElementType Model_X16Assignment_15_ELEMENT_TYPE = associate(ModelFactory.createModel_X16Assignment_15ElementType());

	public static final IGrammarAwareElementType Model_X16Combination4ParserRuleCall_15_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X16Combination4ParserRuleCall_15_0ElementType());

	public static final IGrammarAwareElementType Model_X17Assignment_16_ELEMENT_TYPE = associate(ModelFactory.createModel_X17Assignment_16ElementType());

	public static final IGrammarAwareElementType Model_X17List1ParserRuleCall_16_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X17List1ParserRuleCall_16_0ElementType());

	public static final IGrammarAwareElementType Model_X18Assignment_17_ELEMENT_TYPE = associate(ModelFactory.createModel_X18Assignment_17ElementType());

	public static final IGrammarAwareElementType Model_X18List2ParserRuleCall_17_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X18List2ParserRuleCall_17_0ElementType());

	public static final IGrammarAwareElementType Model_X19Assignment_18_ELEMENT_TYPE = associate(ModelFactory.createModel_X19Assignment_18ElementType());

	public static final IGrammarAwareElementType Model_X19List3ParserRuleCall_18_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X19List3ParserRuleCall_18_0ElementType());

	public static final IGrammarAwareElementType Model_X20Assignment_19_ELEMENT_TYPE = associate(ModelFactory.createModel_X20Assignment_19ElementType());

	public static final IGrammarAwareElementType Model_X20List4ParserRuleCall_19_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X20List4ParserRuleCall_19_0ElementType());

	public static final IGrammarAwareElementType Model_X21Assignment_20_ELEMENT_TYPE = associate(ModelFactory.createModel_X21Assignment_20ElementType());

	public static final IGrammarAwareElementType Model_X21List5ParserRuleCall_20_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X21List5ParserRuleCall_20_0ElementType());

	public static final IGrammarAwareElementType Model_X22Assignment_21_ELEMENT_TYPE = associate(ModelFactory.createModel_X22Assignment_21ElementType());

	public static final IGrammarAwareElementType Model_X22AltList1ParserRuleCall_21_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X22AltList1ParserRuleCall_21_0ElementType());

	public static final IGrammarAwareElementType Model_X23Assignment_22_ELEMENT_TYPE = associate(ModelFactory.createModel_X23Assignment_22ElementType());

	public static final IGrammarAwareElementType Model_X23AltList2ParserRuleCall_22_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X23AltList2ParserRuleCall_22_0ElementType());

	public static final IGrammarAwareElementType Model_X24Assignment_23_ELEMENT_TYPE = associate(ModelFactory.createModel_X24Assignment_23ElementType());

	public static final IGrammarAwareElementType Model_X24TransientObjectParserRuleCall_23_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X24TransientObjectParserRuleCall_23_0ElementType());

	public static final IGrammarAwareElementType Model_X25Assignment_24_ELEMENT_TYPE = associate(ModelFactory.createModel_X25Assignment_24ElementType());

	public static final IGrammarAwareElementType Model_X25TransientSerializeables1ParserRuleCall_24_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X25TransientSerializeables1ParserRuleCall_24_0ElementType());

	public static final IGrammarAwareElementType Model_X26Assignment_25_ELEMENT_TYPE = associate(ModelFactory.createModel_X26Assignment_25ElementType());

	public static final IGrammarAwareElementType Model_X26StaticSimplificationParserRuleCall_25_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X26StaticSimplificationParserRuleCall_25_0ElementType());

	public static final IGrammarAwareElementType Model_X27Assignment_26_ELEMENT_TYPE = associate(ModelFactory.createModel_X27Assignment_26ElementType());

	public static final IGrammarAwareElementType Model_X27TwoVersionParserRuleCall_26_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X27TwoVersionParserRuleCall_26_0ElementType());

	public static final IGrammarAwareElementType Model_X28Assignment_27_ELEMENT_TYPE = associate(ModelFactory.createModel_X28Assignment_27ElementType());

	public static final IGrammarAwareElementType Model_X28Heuristic1ParserRuleCall_27_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X28Heuristic1ParserRuleCall_27_0ElementType());

	private static class SimpleGroupFactory {
		public static IGrammarAwareElementType createSimpleGroupElementType() {
			return new IGrammarAwareElementType("SimpleGroup_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupRule());
		}
		public static IGrammarAwareElementType createSimpleGroup_GroupElementType() {
			return new IGrammarAwareElementType("SimpleGroup_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getGroup());
		}
		public static IGrammarAwareElementType createSimpleGroup_NumberSignDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("SimpleGroup_NumberSignDigitOneKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getNumberSignDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createSimpleGroup_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("SimpleGroup_Val1Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createSimpleGroup_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleGroup_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSimpleGroup_Val2Assignment_2ElementType() {
			return new IGrammarAwareElementType("SimpleGroup_Val2Assignment_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getVal2Assignment_2());
		}
		public static IGrammarAwareElementType createSimpleGroup_Val2IDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("SimpleGroup_Val2IDTerminalRuleCall_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getVal2IDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType SimpleGroup_ELEMENT_TYPE = associate(SimpleGroupFactory.createSimpleGroupElementType());

	public static final IGrammarAwareElementType SimpleGroup_Group_ELEMENT_TYPE = associate(SimpleGroupFactory.createSimpleGroup_GroupElementType());

	public static final IGrammarAwareElementType SimpleGroup_NumberSignDigitOneKeyword_0_ELEMENT_TYPE = associate(SimpleGroupFactory.createSimpleGroup_NumberSignDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType SimpleGroup_Val1Assignment_1_ELEMENT_TYPE = associate(SimpleGroupFactory.createSimpleGroup_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType SimpleGroup_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SimpleGroupFactory.createSimpleGroup_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType SimpleGroup_Val2Assignment_2_ELEMENT_TYPE = associate(SimpleGroupFactory.createSimpleGroup_Val2Assignment_2ElementType());

	public static final IGrammarAwareElementType SimpleGroup_Val2IDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(SimpleGroupFactory.createSimpleGroup_Val2IDTerminalRuleCall_2_0ElementType());

	private static class SimpleAlternativeFactory {
		public static IGrammarAwareElementType createSimpleAlternativeElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeRule());
		}
		public static IGrammarAwareElementType createSimpleAlternative_GroupElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getGroup());
		}
		public static IGrammarAwareElementType createSimpleAlternative_NumberSignDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getNumberSignDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Alternatives_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Group_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Group_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Kw1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Kw1Keyword_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getKw1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Val1Assignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Val1Assignment_1_0_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getVal1Assignment_1_0_1());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getVal1IDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Group_1_1ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Group_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Kw2Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Kw2Keyword_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getKw2Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Val2Assignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Val2Assignment_1_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getVal2Assignment_1_1_1());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getVal2IDTerminalRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType SimpleAlternative_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternativeElementType());

	public static final IGrammarAwareElementType SimpleAlternative_Group_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_GroupElementType());

	public static final IGrammarAwareElementType SimpleAlternative_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_NumberSignDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType SimpleAlternative_Alternatives_1_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_Alternatives_1ElementType());

	public static final IGrammarAwareElementType SimpleAlternative_Group_1_0_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_Group_1_0ElementType());

	public static final IGrammarAwareElementType SimpleAlternative_Kw1Keyword_1_0_0_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_Kw1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType SimpleAlternative_Val1Assignment_1_0_1_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_Val1Assignment_1_0_1ElementType());

	public static final IGrammarAwareElementType SimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType SimpleAlternative_Group_1_1_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_Group_1_1ElementType());

	public static final IGrammarAwareElementType SimpleAlternative_Kw2Keyword_1_1_0_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_Kw2Keyword_1_1_0ElementType());

	public static final IGrammarAwareElementType SimpleAlternative_Val2Assignment_1_1_1_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_Val2Assignment_1_1_1ElementType());

	public static final IGrammarAwareElementType SimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE = associate(SimpleAlternativeFactory.createSimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0ElementType());

	private static class SimpleMultiplicitiesFactory {
		public static IGrammarAwareElementType createSimpleMultiplicitiesElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesRule());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_GroupElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getGroup());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_NumberSignDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getNumberSignDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val1Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Kw1Keyword_2ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Kw1Keyword_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getKw1Keyword_2());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val2Assignment_3ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val2Assignment_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal2Assignment_3());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val2IDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Kw2Keyword_4ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Kw2Keyword_4_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getKw2Keyword_4());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val3Assignment_5ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val3Assignment_5_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal3Assignment_5());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val3IDTerminalRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val3IDTerminalRuleCall_5_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal3IDTerminalRuleCall_5_0());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Kw3Keyword_6ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Kw3Keyword_6_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getKw3Keyword_6());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val4Assignment_7ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val4Assignment_7_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal4Assignment_7());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val4IDTerminalRuleCall_7_0ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val4IDTerminalRuleCall_7_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal4IDTerminalRuleCall_7_0());
		}
	}

	public static final IGrammarAwareElementType SimpleMultiplicities_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicitiesElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Group_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_GroupElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_NumberSignDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Val1Assignment_1_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Kw1Keyword_2_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Kw1Keyword_2ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Val2Assignment_3_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Val2Assignment_3ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Val2IDTerminalRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Kw2Keyword_4_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Kw2Keyword_4ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Val3Assignment_5_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Val3Assignment_5ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Val3IDTerminalRuleCall_5_0_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Val3IDTerminalRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Kw3Keyword_6_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Kw3Keyword_6ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Val4Assignment_7_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Val4Assignment_7ElementType());

	public static final IGrammarAwareElementType SimpleMultiplicities_Val4IDTerminalRuleCall_7_0_ELEMENT_TYPE = associate(SimpleMultiplicitiesFactory.createSimpleMultiplicities_Val4IDTerminalRuleCall_7_0ElementType());

	private static class GroupMultiplicitiesFactory {
		public static IGrammarAwareElementType createGroupMultiplicitiesElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesRule());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_GroupElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getGroup());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_NumberSignDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_NumberSignDigitFourKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getNumberSignDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val1Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Kw1Keyword_2ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Kw1Keyword_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getKw1Keyword_2());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Group_3ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Group_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val2Assignment_3_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val2Assignment_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal2Assignment_3_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val2IDTerminalRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val2IDTerminalRuleCall_3_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val3Assignment_3_1ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val3Assignment_3_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal3Assignment_3_1());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val3IDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val3IDTerminalRuleCall_3_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal3IDTerminalRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Kw2Keyword_4ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Kw2Keyword_4_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getKw2Keyword_4());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Group_5ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Group_5_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val4Assignment_5_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val4Assignment_5_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal4Assignment_5_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val4IDTerminalRuleCall_5_0_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val4IDTerminalRuleCall_5_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal4IDTerminalRuleCall_5_0_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val5Assignment_5_1ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val5Assignment_5_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal5Assignment_5_1());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val5IDTerminalRuleCall_5_1_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val5IDTerminalRuleCall_5_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal5IDTerminalRuleCall_5_1_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Kw3Keyword_6ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Kw3Keyword_6_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getKw3Keyword_6());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Group_7ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Group_7_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getGroup_7());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val6Assignment_7_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val6Assignment_7_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal6Assignment_7_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val6IDTerminalRuleCall_7_0_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val6IDTerminalRuleCall_7_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal6IDTerminalRuleCall_7_0_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val7Assignment_7_1ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val7Assignment_7_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal7Assignment_7_1());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val7IDTerminalRuleCall_7_1_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val7IDTerminalRuleCall_7_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal7IDTerminalRuleCall_7_1_0());
		}
	}

	public static final IGrammarAwareElementType GroupMultiplicities_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicitiesElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Group_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_GroupElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_NumberSignDigitFourKeyword_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_NumberSignDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val1Assignment_1_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Kw1Keyword_2_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Kw1Keyword_2ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Group_3_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Group_3ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val2Assignment_3_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val2Assignment_3_0ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val2IDTerminalRuleCall_3_0_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val2IDTerminalRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val3Assignment_3_1_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val3Assignment_3_1ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val3IDTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val3IDTerminalRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Kw2Keyword_4_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Kw2Keyword_4ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Group_5_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Group_5ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val4Assignment_5_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val4Assignment_5_0ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val4IDTerminalRuleCall_5_0_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val4IDTerminalRuleCall_5_0_0ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val5Assignment_5_1_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val5Assignment_5_1ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val5IDTerminalRuleCall_5_1_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val5IDTerminalRuleCall_5_1_0ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Kw3Keyword_6_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Kw3Keyword_6ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Group_7_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Group_7ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val6Assignment_7_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val6Assignment_7_0ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val6IDTerminalRuleCall_7_0_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val6IDTerminalRuleCall_7_0_0ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val7Assignment_7_1_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val7Assignment_7_1ElementType());

	public static final IGrammarAwareElementType GroupMultiplicities_Val7IDTerminalRuleCall_7_1_0_ELEMENT_TYPE = associate(GroupMultiplicitiesFactory.createGroupMultiplicities_Val7IDTerminalRuleCall_7_1_0ElementType());

	private static class AlternativeMultiplicitiesFactory {
		public static IGrammarAwareElementType createAlternativeMultiplicitiesElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesRule());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_GroupElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getGroup());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_NumberSignDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getNumberSignDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Alternatives_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val2Assignment_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val2Assignment_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal2Assignment_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal2IDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Group_1_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Group_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Kw1Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Kw1Keyword_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getKw1Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val3Assignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val3Assignment_1_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal3Assignment_1_1_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal3IDTerminalRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Kw2Keyword_2ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Kw2Keyword_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getKw2Keyword_2());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Alternatives_3ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Alternatives_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getAlternatives_3());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val4Assignment_3_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val4Assignment_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal4Assignment_3_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal4IDTerminalRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Group_3_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Group_3_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Kw3Keyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Kw3Keyword_3_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getKw3Keyword_3_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val5Assignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val5Assignment_3_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal5Assignment_3_1_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal5IDTerminalRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Kw4Keyword_4ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Kw4Keyword_4_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getKw4Keyword_4());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Alternatives_5ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Alternatives_5_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getAlternatives_5());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val6Assignment_5_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val6Assignment_5_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal6Assignment_5_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal6IDTerminalRuleCall_5_0_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Group_5_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Group_5_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getGroup_5_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Kw5Keyword_5_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Kw5Keyword_5_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getKw5Keyword_5_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val7Assignment_5_1_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val7Assignment_5_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal7Assignment_5_1_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal7IDTerminalRuleCall_5_1_1_0());
		}
	}

	public static final IGrammarAwareElementType AlternativeMultiplicities_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicitiesElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Group_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_GroupElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_NumberSignDigitFiveKeyword_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Alternatives_1_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Alternatives_1ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val2Assignment_1_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val2Assignment_1_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Group_1_1_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Group_1_1ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Kw1Keyword_1_1_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Kw1Keyword_1_1_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val3Assignment_1_1_1_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val3Assignment_1_1_1ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Kw2Keyword_2_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Kw2Keyword_2ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Alternatives_3_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Alternatives_3ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val4Assignment_3_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val4Assignment_3_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Group_3_1_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Group_3_1ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Kw3Keyword_3_1_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Kw3Keyword_3_1_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val5Assignment_3_1_1_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val5Assignment_3_1_1ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Kw4Keyword_4_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Kw4Keyword_4ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Alternatives_5_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Alternatives_5ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val6Assignment_5_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val6Assignment_5_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Group_5_1_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Group_5_1ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Kw5Keyword_5_1_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Kw5Keyword_5_1_0ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val7Assignment_5_1_1_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val7Assignment_5_1_1ElementType());

	public static final IGrammarAwareElementType AlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0_ELEMENT_TYPE = associate(AlternativeMultiplicitiesFactory.createAlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0ElementType());

	private static class AssignedActionFactory {
		public static IGrammarAwareElementType createAssignedActionElementType() {
			return new IGrammarAwareElementType("AssignedAction_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionRule());
		}
		public static IGrammarAwareElementType createAssignedAction_GroupElementType() {
			return new IGrammarAwareElementType("AssignedAction_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionAccess().getGroup());
		}
		public static IGrammarAwareElementType createAssignedAction_NumberSignDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("AssignedAction_NumberSignDigitSixKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionAccess().getNumberSignDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createAssignedAction_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("AssignedAction_Val1Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionAccess().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createAssignedAction_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AssignedAction_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionAccess().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createAssignedAction_Group_2ElementType() {
			return new IGrammarAwareElementType("AssignedAction_Group_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createAssignedAction_AssignedActionChildAction_2_0ElementType() {
			return new IGrammarAwareElementType("AssignedAction_AssignedActionChildAction_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionAccess().getAssignedActionChildAction_2_0());
		}
		public static IGrammarAwareElementType createAssignedAction_Val1Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("AssignedAction_Val1Assignment_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionAccess().getVal1Assignment_2_1());
		}
		public static IGrammarAwareElementType createAssignedAction_Val1IDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("AssignedAction_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionAccess().getVal1IDTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType AssignedAction_ELEMENT_TYPE = associate(AssignedActionFactory.createAssignedActionElementType());

	public static final IGrammarAwareElementType AssignedAction_Group_ELEMENT_TYPE = associate(AssignedActionFactory.createAssignedAction_GroupElementType());

	public static final IGrammarAwareElementType AssignedAction_NumberSignDigitSixKeyword_0_ELEMENT_TYPE = associate(AssignedActionFactory.createAssignedAction_NumberSignDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType AssignedAction_Val1Assignment_1_ELEMENT_TYPE = associate(AssignedActionFactory.createAssignedAction_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType AssignedAction_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AssignedActionFactory.createAssignedAction_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType AssignedAction_Group_2_ELEMENT_TYPE = associate(AssignedActionFactory.createAssignedAction_Group_2ElementType());

	public static final IGrammarAwareElementType AssignedAction_AssignedActionChildAction_2_0_ELEMENT_TYPE = associate(AssignedActionFactory.createAssignedAction_AssignedActionChildAction_2_0ElementType());

	public static final IGrammarAwareElementType AssignedAction_Val1Assignment_2_1_ELEMENT_TYPE = associate(AssignedActionFactory.createAssignedAction_Val1Assignment_2_1ElementType());

	public static final IGrammarAwareElementType AssignedAction_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(AssignedActionFactory.createAssignedAction_Val1IDTerminalRuleCall_2_1_0ElementType());

	private static class AssignedActionSecondFactory {
		public static IGrammarAwareElementType createAssignedActionSecondElementType() {
			return new IGrammarAwareElementType("AssignedActionSecond_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionSecondRule());
		}
		public static IGrammarAwareElementType createAssignedActionSecond_GroupElementType() {
			return new IGrammarAwareElementType("AssignedActionSecond_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionSecondAccess().getGroup());
		}
		public static IGrammarAwareElementType createAssignedActionSecond_NumberSignDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("AssignedActionSecond_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionSecondAccess().getNumberSignDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createAssignedActionSecond_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("AssignedActionSecond_Val1Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionSecondAccess().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createAssignedActionSecond_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AssignedActionSecond_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionSecondAccess().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createAssignedActionSecond_Kw1Keyword_2ElementType() {
			return new IGrammarAwareElementType("AssignedActionSecond_Kw1Keyword_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionSecondAccess().getKw1Keyword_2());
		}
		public static IGrammarAwareElementType createAssignedActionSecond_Val2Assignment_3ElementType() {
			return new IGrammarAwareElementType("AssignedActionSecond_Val2Assignment_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionSecondAccess().getVal2Assignment_3());
		}
		public static IGrammarAwareElementType createAssignedActionSecond_Val2IDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("AssignedActionSecond_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignedActionSecondAccess().getVal2IDTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType AssignedActionSecond_ELEMENT_TYPE = associate(AssignedActionSecondFactory.createAssignedActionSecondElementType());

	public static final IGrammarAwareElementType AssignedActionSecond_Group_ELEMENT_TYPE = associate(AssignedActionSecondFactory.createAssignedActionSecond_GroupElementType());

	public static final IGrammarAwareElementType AssignedActionSecond_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE = associate(AssignedActionSecondFactory.createAssignedActionSecond_NumberSignDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType AssignedActionSecond_Val1Assignment_1_ELEMENT_TYPE = associate(AssignedActionSecondFactory.createAssignedActionSecond_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType AssignedActionSecond_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AssignedActionSecondFactory.createAssignedActionSecond_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType AssignedActionSecond_Kw1Keyword_2_ELEMENT_TYPE = associate(AssignedActionSecondFactory.createAssignedActionSecond_Kw1Keyword_2ElementType());

	public static final IGrammarAwareElementType AssignedActionSecond_Val2Assignment_3_ELEMENT_TYPE = associate(AssignedActionSecondFactory.createAssignedActionSecond_Val2Assignment_3ElementType());

	public static final IGrammarAwareElementType AssignedActionSecond_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(AssignedActionSecondFactory.createAssignedActionSecond_Val2IDTerminalRuleCall_3_0ElementType());

	private static class UnassignedAction1Factory {
		public static IGrammarAwareElementType createUnassignedAction1ElementType() {
			return new IGrammarAwareElementType("UnassignedAction1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction1Rule());
		}
		public static IGrammarAwareElementType createUnassignedAction1_GroupElementType() {
			return new IGrammarAwareElementType("UnassignedAction1_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction1Access().getGroup());
		}
		public static IGrammarAwareElementType createUnassignedAction1_UnassignedAction1Action_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction1_UnassignedAction1Action_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction1Access().getUnassignedAction1Action_0());
		}
		public static IGrammarAwareElementType createUnassignedAction1_NumberSignDigitEightKeyword_1ElementType() {
			return new IGrammarAwareElementType("UnassignedAction1_NumberSignDigitEightKeyword_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction1Access().getNumberSignDigitEightKeyword_1());
		}
		public static IGrammarAwareElementType createUnassignedAction1_Val1Assignment_2ElementType() {
			return new IGrammarAwareElementType("UnassignedAction1_Val1Assignment_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction1Access().getVal1Assignment_2());
		}
		public static IGrammarAwareElementType createUnassignedAction1_Val1IDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction1_Val1IDTerminalRuleCall_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction1Access().getVal1IDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createUnassignedAction1_Val2Assignment_3ElementType() {
			return new IGrammarAwareElementType("UnassignedAction1_Val2Assignment_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction1Access().getVal2Assignment_3());
		}
		public static IGrammarAwareElementType createUnassignedAction1_Val2IDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction1_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction1Access().getVal2IDTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType UnassignedAction1_ELEMENT_TYPE = associate(UnassignedAction1Factory.createUnassignedAction1ElementType());

	public static final IGrammarAwareElementType UnassignedAction1_Group_ELEMENT_TYPE = associate(UnassignedAction1Factory.createUnassignedAction1_GroupElementType());

	public static final IGrammarAwareElementType UnassignedAction1_UnassignedAction1Action_0_ELEMENT_TYPE = associate(UnassignedAction1Factory.createUnassignedAction1_UnassignedAction1Action_0ElementType());

	public static final IGrammarAwareElementType UnassignedAction1_NumberSignDigitEightKeyword_1_ELEMENT_TYPE = associate(UnassignedAction1Factory.createUnassignedAction1_NumberSignDigitEightKeyword_1ElementType());

	public static final IGrammarAwareElementType UnassignedAction1_Val1Assignment_2_ELEMENT_TYPE = associate(UnassignedAction1Factory.createUnassignedAction1_Val1Assignment_2ElementType());

	public static final IGrammarAwareElementType UnassignedAction1_Val1IDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(UnassignedAction1Factory.createUnassignedAction1_Val1IDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType UnassignedAction1_Val2Assignment_3_ELEMENT_TYPE = associate(UnassignedAction1Factory.createUnassignedAction1_Val2Assignment_3ElementType());

	public static final IGrammarAwareElementType UnassignedAction1_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(UnassignedAction1Factory.createUnassignedAction1_Val2IDTerminalRuleCall_3_0ElementType());

	private static class UnassignedAction2Factory {
		public static IGrammarAwareElementType createUnassignedAction2ElementType() {
			return new IGrammarAwareElementType("UnassignedAction2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction2Rule());
		}
		public static IGrammarAwareElementType createUnassignedAction2_GroupElementType() {
			return new IGrammarAwareElementType("UnassignedAction2_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction2Access().getGroup());
		}
		public static IGrammarAwareElementType createUnassignedAction2_UnassignedAction2SubAction_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction2_UnassignedAction2SubAction_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction2Access().getUnassignedAction2SubAction_0());
		}
		public static IGrammarAwareElementType createUnassignedAction2_NumberSignDigitNineKeyword_1ElementType() {
			return new IGrammarAwareElementType("UnassignedAction2_NumberSignDigitNineKeyword_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction2Access().getNumberSignDigitNineKeyword_1());
		}
		public static IGrammarAwareElementType createUnassignedAction2_Val1Assignment_2ElementType() {
			return new IGrammarAwareElementType("UnassignedAction2_Val1Assignment_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction2Access().getVal1Assignment_2());
		}
		public static IGrammarAwareElementType createUnassignedAction2_Val1IDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction2_Val1IDTerminalRuleCall_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction2Access().getVal1IDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createUnassignedAction2_Val2Assignment_3ElementType() {
			return new IGrammarAwareElementType("UnassignedAction2_Val2Assignment_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction2Access().getVal2Assignment_3());
		}
		public static IGrammarAwareElementType createUnassignedAction2_Val2IDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction2_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction2Access().getVal2IDTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType UnassignedAction2_ELEMENT_TYPE = associate(UnassignedAction2Factory.createUnassignedAction2ElementType());

	public static final IGrammarAwareElementType UnassignedAction2_Group_ELEMENT_TYPE = associate(UnassignedAction2Factory.createUnassignedAction2_GroupElementType());

	public static final IGrammarAwareElementType UnassignedAction2_UnassignedAction2SubAction_0_ELEMENT_TYPE = associate(UnassignedAction2Factory.createUnassignedAction2_UnassignedAction2SubAction_0ElementType());

	public static final IGrammarAwareElementType UnassignedAction2_NumberSignDigitNineKeyword_1_ELEMENT_TYPE = associate(UnassignedAction2Factory.createUnassignedAction2_NumberSignDigitNineKeyword_1ElementType());

	public static final IGrammarAwareElementType UnassignedAction2_Val1Assignment_2_ELEMENT_TYPE = associate(UnassignedAction2Factory.createUnassignedAction2_Val1Assignment_2ElementType());

	public static final IGrammarAwareElementType UnassignedAction2_Val1IDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(UnassignedAction2Factory.createUnassignedAction2_Val1IDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType UnassignedAction2_Val2Assignment_3_ELEMENT_TYPE = associate(UnassignedAction2Factory.createUnassignedAction2_Val2Assignment_3ElementType());

	public static final IGrammarAwareElementType UnassignedAction2_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(UnassignedAction2Factory.createUnassignedAction2_Val2IDTerminalRuleCall_3_0ElementType());

	private static class UnassignedAction3Factory {
		public static IGrammarAwareElementType createUnassignedAction3ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Rule());
		}
		public static IGrammarAwareElementType createUnassignedAction3_GroupElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getGroup());
		}
		public static IGrammarAwareElementType createUnassignedAction3_NumberSignDigitOneDigitZeroKeyword_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_NumberSignDigitOneDigitZeroKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getNumberSignDigitOneDigitZeroKeyword_0());
		}
		public static IGrammarAwareElementType createUnassignedAction3_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_Alternatives_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createUnassignedAction3_Group_1_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_Group_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createUnassignedAction3_Kw1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_Kw1Keyword_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getKw1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createUnassignedAction3_UnassignedAction2Sub1Action_1_0_1ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_UnassignedAction2Sub1Action_1_0_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getUnassignedAction2Sub1Action_1_0_1());
		}
		public static IGrammarAwareElementType createUnassignedAction3_Group_1_1ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_Group_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createUnassignedAction3_Kw2Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_Kw2Keyword_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getKw2Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createUnassignedAction3_UnassignedAction2Sub2Action_1_1_1ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_UnassignedAction2Sub2Action_1_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getUnassignedAction2Sub2Action_1_1_1());
		}
		public static IGrammarAwareElementType createUnassignedAction3_Val1Assignment_2ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_Val1Assignment_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getVal1Assignment_2());
		}
		public static IGrammarAwareElementType createUnassignedAction3_Val1IDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_Val1IDTerminalRuleCall_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getVal1IDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createUnassignedAction3_Val2Assignment_3ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_Val2Assignment_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getVal2Assignment_3());
		}
		public static IGrammarAwareElementType createUnassignedAction3_Val2IDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction3_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAction3Access().getVal2IDTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType UnassignedAction3_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_Group_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_GroupElementType());

	public static final IGrammarAwareElementType UnassignedAction3_NumberSignDigitOneDigitZeroKeyword_0_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_NumberSignDigitOneDigitZeroKeyword_0ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_Alternatives_1_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_Alternatives_1ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_Group_1_0_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_Group_1_0ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_Kw1Keyword_1_0_0_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_Kw1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_UnassignedAction2Sub1Action_1_0_1_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_UnassignedAction2Sub1Action_1_0_1ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_Group_1_1_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_Group_1_1ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_Kw2Keyword_1_1_0_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_Kw2Keyword_1_1_0ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_UnassignedAction2Sub2Action_1_1_1_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_UnassignedAction2Sub2Action_1_1_1ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_Val1Assignment_2_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_Val1Assignment_2ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_Val1IDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_Val1IDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_Val2Assignment_3_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_Val2Assignment_3ElementType());

	public static final IGrammarAwareElementType UnassignedAction3_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(UnassignedAction3Factory.createUnassignedAction3_Val2IDTerminalRuleCall_3_0ElementType());

	private static class UnassignedRuleCall1Factory {
		public static IGrammarAwareElementType createUnassignedRuleCall1ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall1Rule());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall1_GroupElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall1_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall1Access().getGroup());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall1_NumberSignDigitOneDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall1_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall1Access().getNumberSignDigitOneDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall1_UnassignedRuleCall1SubParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall1_UnassignedRuleCall1SubParserRuleCall_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall1Access().getUnassignedRuleCall1SubParserRuleCall_1());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall1_Val2Assignment_2ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall1_Val2Assignment_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall1Access().getVal2Assignment_2());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall1_Val2IDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall1_Val2IDTerminalRuleCall_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall1Access().getVal2IDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType UnassignedRuleCall1_ELEMENT_TYPE = associate(UnassignedRuleCall1Factory.createUnassignedRuleCall1ElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall1_Group_ELEMENT_TYPE = associate(UnassignedRuleCall1Factory.createUnassignedRuleCall1_GroupElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall1_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE = associate(UnassignedRuleCall1Factory.createUnassignedRuleCall1_NumberSignDigitOneDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall1_UnassignedRuleCall1SubParserRuleCall_1_ELEMENT_TYPE = associate(UnassignedRuleCall1Factory.createUnassignedRuleCall1_UnassignedRuleCall1SubParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall1_Val2Assignment_2_ELEMENT_TYPE = associate(UnassignedRuleCall1Factory.createUnassignedRuleCall1_Val2Assignment_2ElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall1_Val2IDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(UnassignedRuleCall1Factory.createUnassignedRuleCall1_Val2IDTerminalRuleCall_2_0ElementType());

	private static class UnassignedRuleCall1SubFactory {
		public static IGrammarAwareElementType createUnassignedRuleCall1SubElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall1Sub_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall1SubRule());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall1Sub_Val1AssignmentElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall1Sub_Val1Assignment_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall1SubAccess().getVal1Assignment());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall1Sub_Val1IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall1Sub_Val1IDTerminalRuleCall_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall1SubAccess().getVal1IDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType UnassignedRuleCall1Sub_ELEMENT_TYPE = associate(UnassignedRuleCall1SubFactory.createUnassignedRuleCall1SubElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall1Sub_Val1Assignment_ELEMENT_TYPE = associate(UnassignedRuleCall1SubFactory.createUnassignedRuleCall1Sub_Val1AssignmentElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall1Sub_Val1IDTerminalRuleCall_0_ELEMENT_TYPE = associate(UnassignedRuleCall1SubFactory.createUnassignedRuleCall1Sub_Val1IDTerminalRuleCall_0ElementType());

	private static class UnassignedRuleCall2Factory {
		public static IGrammarAwareElementType createUnassignedRuleCall2ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall2Rule());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall2_GroupElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall2_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall2Access().getGroup());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall2_NumberSignDigitOneDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall2_NumberSignDigitOneDigitTwoKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall2Access().getNumberSignDigitOneDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall2_UnassignedRuleCall2SubParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall2_UnassignedRuleCall2SubParserRuleCall_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall2Access().getUnassignedRuleCall2SubParserRuleCall_1());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall2_Val2Assignment_2ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall2_Val2Assignment_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall2Access().getVal2Assignment_2());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall2_Val2IDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall2_Val2IDTerminalRuleCall_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall2Access().getVal2IDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType UnassignedRuleCall2_ELEMENT_TYPE = associate(UnassignedRuleCall2Factory.createUnassignedRuleCall2ElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall2_Group_ELEMENT_TYPE = associate(UnassignedRuleCall2Factory.createUnassignedRuleCall2_GroupElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall2_NumberSignDigitOneDigitTwoKeyword_0_ELEMENT_TYPE = associate(UnassignedRuleCall2Factory.createUnassignedRuleCall2_NumberSignDigitOneDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall2_UnassignedRuleCall2SubParserRuleCall_1_ELEMENT_TYPE = associate(UnassignedRuleCall2Factory.createUnassignedRuleCall2_UnassignedRuleCall2SubParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall2_Val2Assignment_2_ELEMENT_TYPE = associate(UnassignedRuleCall2Factory.createUnassignedRuleCall2_Val2Assignment_2ElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall2_Val2IDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(UnassignedRuleCall2Factory.createUnassignedRuleCall2_Val2IDTerminalRuleCall_2_0ElementType());

	private static class UnassignedRuleCall2SubFactory {
		public static IGrammarAwareElementType createUnassignedRuleCall2SubElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall2Sub_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall2SubRule());
		}
		public static IGrammarAwareElementType createUnassignedRuleCall2Sub_UnassignedRuleCall2SubActionActionElementType() {
			return new IGrammarAwareElementType("UnassignedRuleCall2Sub_UnassignedRuleCall2SubActionAction_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRuleCall2SubAccess().getUnassignedRuleCall2SubActionAction());
		}
	}

	public static final IGrammarAwareElementType UnassignedRuleCall2Sub_ELEMENT_TYPE = associate(UnassignedRuleCall2SubFactory.createUnassignedRuleCall2SubElementType());

	public static final IGrammarAwareElementType UnassignedRuleCall2Sub_UnassignedRuleCall2SubActionAction_ELEMENT_TYPE = associate(UnassignedRuleCall2SubFactory.createUnassignedRuleCall2Sub_UnassignedRuleCall2SubActionActionElementType());

	private static class Combination1Factory {
		public static IGrammarAwareElementType createCombination1ElementType() {
			return new IGrammarAwareElementType("Combination1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Rule());
		}
		public static IGrammarAwareElementType createCombination1_GroupElementType() {
			return new IGrammarAwareElementType("Combination1_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getGroup());
		}
		public static IGrammarAwareElementType createCombination1_NumberSignDigitOneDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Combination1_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getNumberSignDigitOneDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createCombination1_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("Combination1_Val1Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createCombination1_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Combination1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createCombination1_Group_2ElementType() {
			return new IGrammarAwareElementType("Combination1_Group_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getGroup_2());
		}
		public static IGrammarAwareElementType createCombination1_Kw1Keyword_2_0ElementType() {
			return new IGrammarAwareElementType("Combination1_Kw1Keyword_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getKw1Keyword_2_0());
		}
		public static IGrammarAwareElementType createCombination1_Val2Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("Combination1_Val2Assignment_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getVal2Assignment_2_1());
		}
		public static IGrammarAwareElementType createCombination1_Val2IDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Combination1_Val2IDTerminalRuleCall_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getVal2IDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createCombination1_Alternatives_2_2ElementType() {
			return new IGrammarAwareElementType("Combination1_Alternatives_2_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getAlternatives_2_2());
		}
		public static IGrammarAwareElementType createCombination1_Group_2_2_0ElementType() {
			return new IGrammarAwareElementType("Combination1_Group_2_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getGroup_2_2_0());
		}
		public static IGrammarAwareElementType createCombination1_Kw2Keyword_2_2_0_0ElementType() {
			return new IGrammarAwareElementType("Combination1_Kw2Keyword_2_2_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getKw2Keyword_2_2_0_0());
		}
		public static IGrammarAwareElementType createCombination1_Val3Assignment_2_2_0_1ElementType() {
			return new IGrammarAwareElementType("Combination1_Val3Assignment_2_2_0_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getVal3Assignment_2_2_0_1());
		}
		public static IGrammarAwareElementType createCombination1_Val3IDTerminalRuleCall_2_2_0_1_0ElementType() {
			return new IGrammarAwareElementType("Combination1_Val3IDTerminalRuleCall_2_2_0_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getVal3IDTerminalRuleCall_2_2_0_1_0());
		}
		public static IGrammarAwareElementType createCombination1_Val4Assignment_2_2_1ElementType() {
			return new IGrammarAwareElementType("Combination1_Val4Assignment_2_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getVal4Assignment_2_2_1());
		}
		public static IGrammarAwareElementType createCombination1_Val4IDTerminalRuleCall_2_2_1_0ElementType() {
			return new IGrammarAwareElementType("Combination1_Val4IDTerminalRuleCall_2_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination1Access().getVal4IDTerminalRuleCall_2_2_1_0());
		}
	}

	public static final IGrammarAwareElementType Combination1_ELEMENT_TYPE = associate(Combination1Factory.createCombination1ElementType());

	public static final IGrammarAwareElementType Combination1_Group_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_GroupElementType());

	public static final IGrammarAwareElementType Combination1_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_NumberSignDigitOneDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType Combination1_Val1Assignment_1_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType Combination1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Combination1_Group_2_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Group_2ElementType());

	public static final IGrammarAwareElementType Combination1_Kw1Keyword_2_0_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Kw1Keyword_2_0ElementType());

	public static final IGrammarAwareElementType Combination1_Val2Assignment_2_1_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Val2Assignment_2_1ElementType());

	public static final IGrammarAwareElementType Combination1_Val2IDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Val2IDTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Combination1_Alternatives_2_2_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Alternatives_2_2ElementType());

	public static final IGrammarAwareElementType Combination1_Group_2_2_0_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Group_2_2_0ElementType());

	public static final IGrammarAwareElementType Combination1_Kw2Keyword_2_2_0_0_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Kw2Keyword_2_2_0_0ElementType());

	public static final IGrammarAwareElementType Combination1_Val3Assignment_2_2_0_1_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Val3Assignment_2_2_0_1ElementType());

	public static final IGrammarAwareElementType Combination1_Val3IDTerminalRuleCall_2_2_0_1_0_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Val3IDTerminalRuleCall_2_2_0_1_0ElementType());

	public static final IGrammarAwareElementType Combination1_Val4Assignment_2_2_1_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Val4Assignment_2_2_1ElementType());

	public static final IGrammarAwareElementType Combination1_Val4IDTerminalRuleCall_2_2_1_0_ELEMENT_TYPE = associate(Combination1Factory.createCombination1_Val4IDTerminalRuleCall_2_2_1_0ElementType());

	private static class Combination2Factory {
		public static IGrammarAwareElementType createCombination2ElementType() {
			return new IGrammarAwareElementType("Combination2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Rule());
		}
		public static IGrammarAwareElementType createCombination2_GroupElementType() {
			return new IGrammarAwareElementType("Combination2_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getGroup());
		}
		public static IGrammarAwareElementType createCombination2_NumberSignDigitOneDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("Combination2_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getNumberSignDigitOneDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createCombination2_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("Combination2_Val1Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createCombination2_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Combination2_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createCombination2_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("Combination2_Alternatives_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getAlternatives_2());
		}
		public static IGrammarAwareElementType createCombination2_Group_2_0ElementType() {
			return new IGrammarAwareElementType("Combination2_Group_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getGroup_2_0());
		}
		public static IGrammarAwareElementType createCombination2_Kw1Keyword_2_0_0ElementType() {
			return new IGrammarAwareElementType("Combination2_Kw1Keyword_2_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getKw1Keyword_2_0_0());
		}
		public static IGrammarAwareElementType createCombination2_Val2Assignment_2_0_1ElementType() {
			return new IGrammarAwareElementType("Combination2_Val2Assignment_2_0_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getVal2Assignment_2_0_1());
		}
		public static IGrammarAwareElementType createCombination2_Val2IDTerminalRuleCall_2_0_1_0ElementType() {
			return new IGrammarAwareElementType("Combination2_Val2IDTerminalRuleCall_2_0_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getVal2IDTerminalRuleCall_2_0_1_0());
		}
		public static IGrammarAwareElementType createCombination2_Group_2_1ElementType() {
			return new IGrammarAwareElementType("Combination2_Group_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getGroup_2_1());
		}
		public static IGrammarAwareElementType createCombination2_Val3Assignment_2_1_0ElementType() {
			return new IGrammarAwareElementType("Combination2_Val3Assignment_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getVal3Assignment_2_1_0());
		}
		public static IGrammarAwareElementType createCombination2_Val3IDTerminalRuleCall_2_1_0_0ElementType() {
			return new IGrammarAwareElementType("Combination2_Val3IDTerminalRuleCall_2_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getVal3IDTerminalRuleCall_2_1_0_0());
		}
		public static IGrammarAwareElementType createCombination2_Val4Assignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("Combination2_Val4Assignment_2_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getVal4Assignment_2_1_1());
		}
		public static IGrammarAwareElementType createCombination2_Val4IDTerminalRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("Combination2_Val4IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination2Access().getVal4IDTerminalRuleCall_2_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Combination2_ELEMENT_TYPE = associate(Combination2Factory.createCombination2ElementType());

	public static final IGrammarAwareElementType Combination2_Group_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_GroupElementType());

	public static final IGrammarAwareElementType Combination2_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_NumberSignDigitOneDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType Combination2_Val1Assignment_1_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType Combination2_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Combination2_Alternatives_2_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Alternatives_2ElementType());

	public static final IGrammarAwareElementType Combination2_Group_2_0_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Group_2_0ElementType());

	public static final IGrammarAwareElementType Combination2_Kw1Keyword_2_0_0_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Kw1Keyword_2_0_0ElementType());

	public static final IGrammarAwareElementType Combination2_Val2Assignment_2_0_1_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Val2Assignment_2_0_1ElementType());

	public static final IGrammarAwareElementType Combination2_Val2IDTerminalRuleCall_2_0_1_0_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Val2IDTerminalRuleCall_2_0_1_0ElementType());

	public static final IGrammarAwareElementType Combination2_Group_2_1_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Group_2_1ElementType());

	public static final IGrammarAwareElementType Combination2_Val3Assignment_2_1_0_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Val3Assignment_2_1_0ElementType());

	public static final IGrammarAwareElementType Combination2_Val3IDTerminalRuleCall_2_1_0_0_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Val3IDTerminalRuleCall_2_1_0_0ElementType());

	public static final IGrammarAwareElementType Combination2_Val4Assignment_2_1_1_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Val4Assignment_2_1_1ElementType());

	public static final IGrammarAwareElementType Combination2_Val4IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE = associate(Combination2Factory.createCombination2_Val4IDTerminalRuleCall_2_1_1_0ElementType());

	private static class Combination3Factory {
		public static IGrammarAwareElementType createCombination3ElementType() {
			return new IGrammarAwareElementType("Combination3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination3Rule());
		}
		public static IGrammarAwareElementType createCombination3_GroupElementType() {
			return new IGrammarAwareElementType("Combination3_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination3Access().getGroup());
		}
		public static IGrammarAwareElementType createCombination3_NumberSignDigitOneDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("Combination3_NumberSignDigitOneDigitFiveKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination3Access().getNumberSignDigitOneDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createCombination3_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Combination3_Alternatives_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination3Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createCombination3_Val1Assignment_1_0ElementType() {
			return new IGrammarAwareElementType("Combination3_Val1Assignment_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination3Access().getVal1Assignment_1_0());
		}
		public static IGrammarAwareElementType createCombination3_Val1IDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("Combination3_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination3Access().getVal1IDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createCombination3_Val2Assignment_1_1ElementType() {
			return new IGrammarAwareElementType("Combination3_Val2Assignment_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination3Access().getVal2Assignment_1_1());
		}
		public static IGrammarAwareElementType createCombination3_Val2INTTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Combination3_Val2INTTerminalRuleCall_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination3Access().getVal2INTTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createCombination3_Val3Assignment_1_2ElementType() {
			return new IGrammarAwareElementType("Combination3_Val3Assignment_1_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination3Access().getVal3Assignment_1_2());
		}
		public static IGrammarAwareElementType createCombination3_Val3STRINGTerminalRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Combination3_Val3STRINGTerminalRuleCall_1_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination3Access().getVal3STRINGTerminalRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Combination3_ELEMENT_TYPE = associate(Combination3Factory.createCombination3ElementType());

	public static final IGrammarAwareElementType Combination3_Group_ELEMENT_TYPE = associate(Combination3Factory.createCombination3_GroupElementType());

	public static final IGrammarAwareElementType Combination3_NumberSignDigitOneDigitFiveKeyword_0_ELEMENT_TYPE = associate(Combination3Factory.createCombination3_NumberSignDigitOneDigitFiveKeyword_0ElementType());

	public static final IGrammarAwareElementType Combination3_Alternatives_1_ELEMENT_TYPE = associate(Combination3Factory.createCombination3_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Combination3_Val1Assignment_1_0_ELEMENT_TYPE = associate(Combination3Factory.createCombination3_Val1Assignment_1_0ElementType());

	public static final IGrammarAwareElementType Combination3_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(Combination3Factory.createCombination3_Val1IDTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType Combination3_Val2Assignment_1_1_ELEMENT_TYPE = associate(Combination3Factory.createCombination3_Val2Assignment_1_1ElementType());

	public static final IGrammarAwareElementType Combination3_Val2INTTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(Combination3Factory.createCombination3_Val2INTTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Combination3_Val3Assignment_1_2_ELEMENT_TYPE = associate(Combination3Factory.createCombination3_Val3Assignment_1_2ElementType());

	public static final IGrammarAwareElementType Combination3_Val3STRINGTerminalRuleCall_1_2_0_ELEMENT_TYPE = associate(Combination3Factory.createCombination3_Val3STRINGTerminalRuleCall_1_2_0ElementType());

	private static class Combination4Factory {
		public static IGrammarAwareElementType createCombination4ElementType() {
			return new IGrammarAwareElementType("Combination4_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Rule());
		}
		public static IGrammarAwareElementType createCombination4_GroupElementType() {
			return new IGrammarAwareElementType("Combination4_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Access().getGroup());
		}
		public static IGrammarAwareElementType createCombination4_NumberSignDigitOneDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("Combination4_NumberSignDigitOneDigitSixKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Access().getNumberSignDigitOneDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createCombination4_Group_1ElementType() {
			return new IGrammarAwareElementType("Combination4_Group_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Access().getGroup_1());
		}
		public static IGrammarAwareElementType createCombination4_GroupKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Combination4_GroupKeyword_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Access().getGroupKeyword_1_0());
		}
		public static IGrammarAwareElementType createCombination4_Val1Assignment_1_1ElementType() {
			return new IGrammarAwareElementType("Combination4_Val1Assignment_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Access().getVal1Assignment_1_1());
		}
		public static IGrammarAwareElementType createCombination4_Val1IDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Combination4_Val1IDTerminalRuleCall_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Access().getVal1IDTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createCombination4_Val2Assignment_1_2ElementType() {
			return new IGrammarAwareElementType("Combination4_Val2Assignment_1_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Access().getVal2Assignment_1_2());
		}
		public static IGrammarAwareElementType createCombination4_Val2IDTerminalRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Combination4_Val2IDTerminalRuleCall_1_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Access().getVal2IDTerminalRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createCombination4_Val3Assignment_1_3ElementType() {
			return new IGrammarAwareElementType("Combination4_Val3Assignment_1_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Access().getVal3Assignment_1_3());
		}
		public static IGrammarAwareElementType createCombination4_Val3IDTerminalRuleCall_1_3_0ElementType() {
			return new IGrammarAwareElementType("Combination4_Val3IDTerminalRuleCall_1_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCombination4Access().getVal3IDTerminalRuleCall_1_3_0());
		}
	}

	public static final IGrammarAwareElementType Combination4_ELEMENT_TYPE = associate(Combination4Factory.createCombination4ElementType());

	public static final IGrammarAwareElementType Combination4_Group_ELEMENT_TYPE = associate(Combination4Factory.createCombination4_GroupElementType());

	public static final IGrammarAwareElementType Combination4_NumberSignDigitOneDigitSixKeyword_0_ELEMENT_TYPE = associate(Combination4Factory.createCombination4_NumberSignDigitOneDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType Combination4_Group_1_ELEMENT_TYPE = associate(Combination4Factory.createCombination4_Group_1ElementType());

	public static final IGrammarAwareElementType Combination4_GroupKeyword_1_0_ELEMENT_TYPE = associate(Combination4Factory.createCombination4_GroupKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Combination4_Val1Assignment_1_1_ELEMENT_TYPE = associate(Combination4Factory.createCombination4_Val1Assignment_1_1ElementType());

	public static final IGrammarAwareElementType Combination4_Val1IDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(Combination4Factory.createCombination4_Val1IDTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Combination4_Val2Assignment_1_2_ELEMENT_TYPE = associate(Combination4Factory.createCombination4_Val2Assignment_1_2ElementType());

	public static final IGrammarAwareElementType Combination4_Val2IDTerminalRuleCall_1_2_0_ELEMENT_TYPE = associate(Combination4Factory.createCombination4_Val2IDTerminalRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType Combination4_Val3Assignment_1_3_ELEMENT_TYPE = associate(Combination4Factory.createCombination4_Val3Assignment_1_3ElementType());

	public static final IGrammarAwareElementType Combination4_Val3IDTerminalRuleCall_1_3_0_ELEMENT_TYPE = associate(Combination4Factory.createCombination4_Val3IDTerminalRuleCall_1_3_0ElementType());

	private static class List1Factory {
		public static IGrammarAwareElementType createList1ElementType() {
			return new IGrammarAwareElementType("List1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Rule());
		}
		public static IGrammarAwareElementType createList1_GroupElementType() {
			return new IGrammarAwareElementType("List1_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getGroup());
		}
		public static IGrammarAwareElementType createList1_NumberSignDigitOneDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("List1_NumberSignDigitOneDigitSevenKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getNumberSignDigitOneDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createList1_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("List1_Val1Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createList1_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("List1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createList1_Group_2ElementType() {
			return new IGrammarAwareElementType("List1_Group_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getGroup_2());
		}
		public static IGrammarAwareElementType createList1_CommaKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("List1_CommaKeyword_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getCommaKeyword_2_0());
		}
		public static IGrammarAwareElementType createList1_Val1Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("List1_Val1Assignment_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getVal1Assignment_2_1());
		}
		public static IGrammarAwareElementType createList1_Val1IDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("List1_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getVal1IDTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType List1_ELEMENT_TYPE = associate(List1Factory.createList1ElementType());

	public static final IGrammarAwareElementType List1_Group_ELEMENT_TYPE = associate(List1Factory.createList1_GroupElementType());

	public static final IGrammarAwareElementType List1_NumberSignDigitOneDigitSevenKeyword_0_ELEMENT_TYPE = associate(List1Factory.createList1_NumberSignDigitOneDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType List1_Val1Assignment_1_ELEMENT_TYPE = associate(List1Factory.createList1_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType List1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(List1Factory.createList1_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType List1_Group_2_ELEMENT_TYPE = associate(List1Factory.createList1_Group_2ElementType());

	public static final IGrammarAwareElementType List1_CommaKeyword_2_0_ELEMENT_TYPE = associate(List1Factory.createList1_CommaKeyword_2_0ElementType());

	public static final IGrammarAwareElementType List1_Val1Assignment_2_1_ELEMENT_TYPE = associate(List1Factory.createList1_Val1Assignment_2_1ElementType());

	public static final IGrammarAwareElementType List1_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(List1Factory.createList1_Val1IDTerminalRuleCall_2_1_0ElementType());

	private static class List2Factory {
		public static IGrammarAwareElementType createList2ElementType() {
			return new IGrammarAwareElementType("List2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Rule());
		}
		public static IGrammarAwareElementType createList2_GroupElementType() {
			return new IGrammarAwareElementType("List2_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getGroup());
		}
		public static IGrammarAwareElementType createList2_NumberSignDigitOneDigitEightKeyword_0ElementType() {
			return new IGrammarAwareElementType("List2_NumberSignDigitOneDigitEightKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getNumberSignDigitOneDigitEightKeyword_0());
		}
		public static IGrammarAwareElementType createList2_Group_1ElementType() {
			return new IGrammarAwareElementType("List2_Group_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getGroup_1());
		}
		public static IGrammarAwareElementType createList2_Val1Assignment_1_0ElementType() {
			return new IGrammarAwareElementType("List2_Val1Assignment_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getVal1Assignment_1_0());
		}
		public static IGrammarAwareElementType createList2_Val1IDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("List2_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getVal1IDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createList2_Group_1_1ElementType() {
			return new IGrammarAwareElementType("List2_Group_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createList2_CommaKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("List2_CommaKeyword_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getCommaKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createList2_Val1Assignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("List2_Val1Assignment_1_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getVal1Assignment_1_1_1());
		}
		public static IGrammarAwareElementType createList2_Val1IDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("List2_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getVal1IDTerminalRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType List2_ELEMENT_TYPE = associate(List2Factory.createList2ElementType());

	public static final IGrammarAwareElementType List2_Group_ELEMENT_TYPE = associate(List2Factory.createList2_GroupElementType());

	public static final IGrammarAwareElementType List2_NumberSignDigitOneDigitEightKeyword_0_ELEMENT_TYPE = associate(List2Factory.createList2_NumberSignDigitOneDigitEightKeyword_0ElementType());

	public static final IGrammarAwareElementType List2_Group_1_ELEMENT_TYPE = associate(List2Factory.createList2_Group_1ElementType());

	public static final IGrammarAwareElementType List2_Val1Assignment_1_0_ELEMENT_TYPE = associate(List2Factory.createList2_Val1Assignment_1_0ElementType());

	public static final IGrammarAwareElementType List2_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(List2Factory.createList2_Val1IDTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType List2_Group_1_1_ELEMENT_TYPE = associate(List2Factory.createList2_Group_1_1ElementType());

	public static final IGrammarAwareElementType List2_CommaKeyword_1_1_0_ELEMENT_TYPE = associate(List2Factory.createList2_CommaKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType List2_Val1Assignment_1_1_1_ELEMENT_TYPE = associate(List2Factory.createList2_Val1Assignment_1_1_1ElementType());

	public static final IGrammarAwareElementType List2_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE = associate(List2Factory.createList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());

	private static class List3Factory {
		public static IGrammarAwareElementType createList3ElementType() {
			return new IGrammarAwareElementType("List3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Rule());
		}
		public static IGrammarAwareElementType createList3_AlternativesElementType() {
			return new IGrammarAwareElementType("List3_Alternatives_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getAlternatives());
		}
		public static IGrammarAwareElementType createList3_Group_0ElementType() {
			return new IGrammarAwareElementType("List3_Group_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getGroup_0());
		}
		public static IGrammarAwareElementType createList3_NumberSignDigitOneDigitNineKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("List3_NumberSignDigitOneDigitNineKeyword_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getNumberSignDigitOneDigitNineKeyword_0_0());
		}
		public static IGrammarAwareElementType createList3_Group_0_1ElementType() {
			return new IGrammarAwareElementType("List3_Group_0_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getGroup_0_1());
		}
		public static IGrammarAwareElementType createList3_Val1Assignment_0_1_0ElementType() {
			return new IGrammarAwareElementType("List3_Val1Assignment_0_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getVal1Assignment_0_1_0());
		}
		public static IGrammarAwareElementType createList3_Val1IDTerminalRuleCall_0_1_0_0ElementType() {
			return new IGrammarAwareElementType("List3_Val1IDTerminalRuleCall_0_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getVal1IDTerminalRuleCall_0_1_0_0());
		}
		public static IGrammarAwareElementType createList3_Group_0_1_1ElementType() {
			return new IGrammarAwareElementType("List3_Group_0_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getGroup_0_1_1());
		}
		public static IGrammarAwareElementType createList3_CommaKeyword_0_1_1_0ElementType() {
			return new IGrammarAwareElementType("List3_CommaKeyword_0_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getCommaKeyword_0_1_1_0());
		}
		public static IGrammarAwareElementType createList3_Val1Assignment_0_1_1_1ElementType() {
			return new IGrammarAwareElementType("List3_Val1Assignment_0_1_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getVal1Assignment_0_1_1_1());
		}
		public static IGrammarAwareElementType createList3_Val1IDTerminalRuleCall_0_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("List3_Val1IDTerminalRuleCall_0_1_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getVal1IDTerminalRuleCall_0_1_1_1_0());
		}
		public static IGrammarAwareElementType createList3_Group_1ElementType() {
			return new IGrammarAwareElementType("List3_Group_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getGroup_1());
		}
		public static IGrammarAwareElementType createList3_Kw3Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("List3_Kw3Keyword_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getKw3Keyword_1_0());
		}
		public static IGrammarAwareElementType createList3_Val2Assignment_1_1ElementType() {
			return new IGrammarAwareElementType("List3_Val2Assignment_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getVal2Assignment_1_1());
		}
		public static IGrammarAwareElementType createList3_Val2IDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("List3_Val2IDTerminalRuleCall_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList3Access().getVal2IDTerminalRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType List3_ELEMENT_TYPE = associate(List3Factory.createList3ElementType());

	public static final IGrammarAwareElementType List3_Alternatives_ELEMENT_TYPE = associate(List3Factory.createList3_AlternativesElementType());

	public static final IGrammarAwareElementType List3_Group_0_ELEMENT_TYPE = associate(List3Factory.createList3_Group_0ElementType());

	public static final IGrammarAwareElementType List3_NumberSignDigitOneDigitNineKeyword_0_0_ELEMENT_TYPE = associate(List3Factory.createList3_NumberSignDigitOneDigitNineKeyword_0_0ElementType());

	public static final IGrammarAwareElementType List3_Group_0_1_ELEMENT_TYPE = associate(List3Factory.createList3_Group_0_1ElementType());

	public static final IGrammarAwareElementType List3_Val1Assignment_0_1_0_ELEMENT_TYPE = associate(List3Factory.createList3_Val1Assignment_0_1_0ElementType());

	public static final IGrammarAwareElementType List3_Val1IDTerminalRuleCall_0_1_0_0_ELEMENT_TYPE = associate(List3Factory.createList3_Val1IDTerminalRuleCall_0_1_0_0ElementType());

	public static final IGrammarAwareElementType List3_Group_0_1_1_ELEMENT_TYPE = associate(List3Factory.createList3_Group_0_1_1ElementType());

	public static final IGrammarAwareElementType List3_CommaKeyword_0_1_1_0_ELEMENT_TYPE = associate(List3Factory.createList3_CommaKeyword_0_1_1_0ElementType());

	public static final IGrammarAwareElementType List3_Val1Assignment_0_1_1_1_ELEMENT_TYPE = associate(List3Factory.createList3_Val1Assignment_0_1_1_1ElementType());

	public static final IGrammarAwareElementType List3_Val1IDTerminalRuleCall_0_1_1_1_0_ELEMENT_TYPE = associate(List3Factory.createList3_Val1IDTerminalRuleCall_0_1_1_1_0ElementType());

	public static final IGrammarAwareElementType List3_Group_1_ELEMENT_TYPE = associate(List3Factory.createList3_Group_1ElementType());

	public static final IGrammarAwareElementType List3_Kw3Keyword_1_0_ELEMENT_TYPE = associate(List3Factory.createList3_Kw3Keyword_1_0ElementType());

	public static final IGrammarAwareElementType List3_Val2Assignment_1_1_ELEMENT_TYPE = associate(List3Factory.createList3_Val2Assignment_1_1ElementType());

	public static final IGrammarAwareElementType List3_Val2IDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(List3Factory.createList3_Val2IDTerminalRuleCall_1_1_0ElementType());

	private static class List4Factory {
		public static IGrammarAwareElementType createList4ElementType() {
			return new IGrammarAwareElementType("List4_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Rule());
		}
		public static IGrammarAwareElementType createList4_GroupElementType() {
			return new IGrammarAwareElementType("List4_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getGroup());
		}
		public static IGrammarAwareElementType createList4_NumberSignDigitTwoDigitZeroKeyword_0ElementType() {
			return new IGrammarAwareElementType("List4_NumberSignDigitTwoDigitZeroKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getNumberSignDigitTwoDigitZeroKeyword_0());
		}
		public static IGrammarAwareElementType createList4_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("List4_Val1Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createList4_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("List4_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createList4_Group_2ElementType() {
			return new IGrammarAwareElementType("List4_Group_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getGroup_2());
		}
		public static IGrammarAwareElementType createList4_CommaKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("List4_CommaKeyword_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getCommaKeyword_2_0());
		}
		public static IGrammarAwareElementType createList4_Val1Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("List4_Val1Assignment_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getVal1Assignment_2_1());
		}
		public static IGrammarAwareElementType createList4_Val1IDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("List4_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getVal1IDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createList4_Kw3Keyword_3ElementType() {
			return new IGrammarAwareElementType("List4_Kw3Keyword_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getKw3Keyword_3());
		}
		public static IGrammarAwareElementType createList4_Val2Assignment_4ElementType() {
			return new IGrammarAwareElementType("List4_Val2Assignment_4_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getVal2Assignment_4());
		}
		public static IGrammarAwareElementType createList4_Val2IDTerminalRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("List4_Val2IDTerminalRuleCall_4_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList4Access().getVal2IDTerminalRuleCall_4_0());
		}
	}

	public static final IGrammarAwareElementType List4_ELEMENT_TYPE = associate(List4Factory.createList4ElementType());

	public static final IGrammarAwareElementType List4_Group_ELEMENT_TYPE = associate(List4Factory.createList4_GroupElementType());

	public static final IGrammarAwareElementType List4_NumberSignDigitTwoDigitZeroKeyword_0_ELEMENT_TYPE = associate(List4Factory.createList4_NumberSignDigitTwoDigitZeroKeyword_0ElementType());

	public static final IGrammarAwareElementType List4_Val1Assignment_1_ELEMENT_TYPE = associate(List4Factory.createList4_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType List4_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(List4Factory.createList4_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType List4_Group_2_ELEMENT_TYPE = associate(List4Factory.createList4_Group_2ElementType());

	public static final IGrammarAwareElementType List4_CommaKeyword_2_0_ELEMENT_TYPE = associate(List4Factory.createList4_CommaKeyword_2_0ElementType());

	public static final IGrammarAwareElementType List4_Val1Assignment_2_1_ELEMENT_TYPE = associate(List4Factory.createList4_Val1Assignment_2_1ElementType());

	public static final IGrammarAwareElementType List4_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(List4Factory.createList4_Val1IDTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType List4_Kw3Keyword_3_ELEMENT_TYPE = associate(List4Factory.createList4_Kw3Keyword_3ElementType());

	public static final IGrammarAwareElementType List4_Val2Assignment_4_ELEMENT_TYPE = associate(List4Factory.createList4_Val2Assignment_4ElementType());

	public static final IGrammarAwareElementType List4_Val2IDTerminalRuleCall_4_0_ELEMENT_TYPE = associate(List4Factory.createList4_Val2IDTerminalRuleCall_4_0ElementType());

	private static class List5Factory {
		public static IGrammarAwareElementType createList5ElementType() {
			return new IGrammarAwareElementType("List5_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Rule());
		}
		public static IGrammarAwareElementType createList5_GroupElementType() {
			return new IGrammarAwareElementType("List5_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getGroup());
		}
		public static IGrammarAwareElementType createList5_NumberSignDigitTwoDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("List5_NumberSignDigitTwoDigitOneKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getNumberSignDigitTwoDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createList5_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("List5_Alternatives_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createList5_Group_1_0ElementType() {
			return new IGrammarAwareElementType("List5_Group_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createList5_Val1Assignment_1_0_0ElementType() {
			return new IGrammarAwareElementType("List5_Val1Assignment_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getVal1Assignment_1_0_0());
		}
		public static IGrammarAwareElementType createList5_Val1IDTerminalRuleCall_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("List5_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getVal1IDTerminalRuleCall_1_0_0_0());
		}
		public static IGrammarAwareElementType createList5_Group_1_0_1ElementType() {
			return new IGrammarAwareElementType("List5_Group_1_0_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getGroup_1_0_1());
		}
		public static IGrammarAwareElementType createList5_CommaKeyword_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("List5_CommaKeyword_1_0_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getCommaKeyword_1_0_1_0());
		}
		public static IGrammarAwareElementType createList5_Val1Assignment_1_0_1_1ElementType() {
			return new IGrammarAwareElementType("List5_Val1Assignment_1_0_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getVal1Assignment_1_0_1_1());
		}
		public static IGrammarAwareElementType createList5_Val1IDTerminalRuleCall_1_0_1_1_0ElementType() {
			return new IGrammarAwareElementType("List5_Val1IDTerminalRuleCall_1_0_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getVal1IDTerminalRuleCall_1_0_1_1_0());
		}
		public static IGrammarAwareElementType createList5_Kw3Keyword_1_0_2ElementType() {
			return new IGrammarAwareElementType("List5_Kw3Keyword_1_0_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getKw3Keyword_1_0_2());
		}
		public static IGrammarAwareElementType createList5_Val2Assignment_1_0_3ElementType() {
			return new IGrammarAwareElementType("List5_Val2Assignment_1_0_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getVal2Assignment_1_0_3());
		}
		public static IGrammarAwareElementType createList5_Val2IDTerminalRuleCall_1_0_3_0ElementType() {
			return new IGrammarAwareElementType("List5_Val2IDTerminalRuleCall_1_0_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getVal2IDTerminalRuleCall_1_0_3_0());
		}
		public static IGrammarAwareElementType createList5_Val3Assignment_1_1ElementType() {
			return new IGrammarAwareElementType("List5_Val3Assignment_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getVal3Assignment_1_1());
		}
		public static IGrammarAwareElementType createList5_Val3IDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("List5_Val3IDTerminalRuleCall_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList5Access().getVal3IDTerminalRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType List5_ELEMENT_TYPE = associate(List5Factory.createList5ElementType());

	public static final IGrammarAwareElementType List5_Group_ELEMENT_TYPE = associate(List5Factory.createList5_GroupElementType());

	public static final IGrammarAwareElementType List5_NumberSignDigitTwoDigitOneKeyword_0_ELEMENT_TYPE = associate(List5Factory.createList5_NumberSignDigitTwoDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType List5_Alternatives_1_ELEMENT_TYPE = associate(List5Factory.createList5_Alternatives_1ElementType());

	public static final IGrammarAwareElementType List5_Group_1_0_ELEMENT_TYPE = associate(List5Factory.createList5_Group_1_0ElementType());

	public static final IGrammarAwareElementType List5_Val1Assignment_1_0_0_ELEMENT_TYPE = associate(List5Factory.createList5_Val1Assignment_1_0_0ElementType());

	public static final IGrammarAwareElementType List5_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE = associate(List5Factory.createList5_Val1IDTerminalRuleCall_1_0_0_0ElementType());

	public static final IGrammarAwareElementType List5_Group_1_0_1_ELEMENT_TYPE = associate(List5Factory.createList5_Group_1_0_1ElementType());

	public static final IGrammarAwareElementType List5_CommaKeyword_1_0_1_0_ELEMENT_TYPE = associate(List5Factory.createList5_CommaKeyword_1_0_1_0ElementType());

	public static final IGrammarAwareElementType List5_Val1Assignment_1_0_1_1_ELEMENT_TYPE = associate(List5Factory.createList5_Val1Assignment_1_0_1_1ElementType());

	public static final IGrammarAwareElementType List5_Val1IDTerminalRuleCall_1_0_1_1_0_ELEMENT_TYPE = associate(List5Factory.createList5_Val1IDTerminalRuleCall_1_0_1_1_0ElementType());

	public static final IGrammarAwareElementType List5_Kw3Keyword_1_0_2_ELEMENT_TYPE = associate(List5Factory.createList5_Kw3Keyword_1_0_2ElementType());

	public static final IGrammarAwareElementType List5_Val2Assignment_1_0_3_ELEMENT_TYPE = associate(List5Factory.createList5_Val2Assignment_1_0_3ElementType());

	public static final IGrammarAwareElementType List5_Val2IDTerminalRuleCall_1_0_3_0_ELEMENT_TYPE = associate(List5Factory.createList5_Val2IDTerminalRuleCall_1_0_3_0ElementType());

	public static final IGrammarAwareElementType List5_Val3Assignment_1_1_ELEMENT_TYPE = associate(List5Factory.createList5_Val3Assignment_1_1ElementType());

	public static final IGrammarAwareElementType List5_Val3IDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(List5Factory.createList5_Val3IDTerminalRuleCall_1_1_0ElementType());

	private static class AltList1Factory {
		public static IGrammarAwareElementType createAltList1ElementType() {
			return new IGrammarAwareElementType("AltList1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Rule());
		}
		public static IGrammarAwareElementType createAltList1_GroupElementType() {
			return new IGrammarAwareElementType("AltList1_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getGroup());
		}
		public static IGrammarAwareElementType createAltList1_NumberSignDigitTwoDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("AltList1_NumberSignDigitTwoDigitTwoKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getNumberSignDigitTwoDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createAltList1_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("AltList1_Alternatives_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createAltList1_Group_1_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Group_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createAltList1_Val1Assignment_1_0_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1Assignment_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1Assignment_1_0_0());
		}
		public static IGrammarAwareElementType createAltList1_Val1IDTerminalRuleCall_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1IDTerminalRuleCall_1_0_0_0());
		}
		public static IGrammarAwareElementType createAltList1_Val2Assignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("AltList1_Val2Assignment_1_0_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal2Assignment_1_0_1());
		}
		public static IGrammarAwareElementType createAltList1_Val2IDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val2IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal2IDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createAltList1_Group_1_1ElementType() {
			return new IGrammarAwareElementType("AltList1_Group_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAltList1_Kw1Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Kw1Keyword_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getKw1Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createAltList1_Val1Assignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1Assignment_1_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1Assignment_1_1_1());
		}
		public static IGrammarAwareElementType createAltList1_Val1IDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1IDTerminalRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createAltList1_Val3Assignment_1_1_2ElementType() {
			return new IGrammarAwareElementType("AltList1_Val3Assignment_1_1_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal3Assignment_1_1_2());
		}
		public static IGrammarAwareElementType createAltList1_Val3IDTerminalRuleCall_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val3IDTerminalRuleCall_1_1_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal3IDTerminalRuleCall_1_1_2_0());
		}
		public static IGrammarAwareElementType createAltList1_Group_1_2ElementType() {
			return new IGrammarAwareElementType("AltList1_Group_1_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getGroup_1_2());
		}
		public static IGrammarAwareElementType createAltList1_Kw2Keyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Kw2Keyword_1_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getKw2Keyword_1_2_0());
		}
		public static IGrammarAwareElementType createAltList1_Val1Assignment_1_2_1ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1Assignment_1_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1Assignment_1_2_1());
		}
		public static IGrammarAwareElementType createAltList1_Val1IDTerminalRuleCall_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1IDTerminalRuleCall_1_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1IDTerminalRuleCall_1_2_1_0());
		}
		public static IGrammarAwareElementType createAltList1_Val4Assignment_1_2_2ElementType() {
			return new IGrammarAwareElementType("AltList1_Val4Assignment_1_2_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal4Assignment_1_2_2());
		}
		public static IGrammarAwareElementType createAltList1_Val4IDTerminalRuleCall_1_2_2_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val4IDTerminalRuleCall_1_2_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal4IDTerminalRuleCall_1_2_2_0());
		}
	}

	public static final IGrammarAwareElementType AltList1_ELEMENT_TYPE = associate(AltList1Factory.createAltList1ElementType());

	public static final IGrammarAwareElementType AltList1_Group_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_GroupElementType());

	public static final IGrammarAwareElementType AltList1_NumberSignDigitTwoDigitTwoKeyword_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_NumberSignDigitTwoDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType AltList1_Alternatives_1_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Alternatives_1ElementType());

	public static final IGrammarAwareElementType AltList1_Group_1_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Group_1_0ElementType());

	public static final IGrammarAwareElementType AltList1_Val1Assignment_1_0_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val1Assignment_1_0_0ElementType());

	public static final IGrammarAwareElementType AltList1_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val1IDTerminalRuleCall_1_0_0_0ElementType());

	public static final IGrammarAwareElementType AltList1_Val2Assignment_1_0_1_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val2Assignment_1_0_1ElementType());

	public static final IGrammarAwareElementType AltList1_Val2IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val2IDTerminalRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType AltList1_Group_1_1_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Group_1_1ElementType());

	public static final IGrammarAwareElementType AltList1_Kw1Keyword_1_1_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Kw1Keyword_1_1_0ElementType());

	public static final IGrammarAwareElementType AltList1_Val1Assignment_1_1_1_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val1Assignment_1_1_1ElementType());

	public static final IGrammarAwareElementType AltList1_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val1IDTerminalRuleCall_1_1_1_0ElementType());

	public static final IGrammarAwareElementType AltList1_Val3Assignment_1_1_2_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val3Assignment_1_1_2ElementType());

	public static final IGrammarAwareElementType AltList1_Val3IDTerminalRuleCall_1_1_2_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val3IDTerminalRuleCall_1_1_2_0ElementType());

	public static final IGrammarAwareElementType AltList1_Group_1_2_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Group_1_2ElementType());

	public static final IGrammarAwareElementType AltList1_Kw2Keyword_1_2_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Kw2Keyword_1_2_0ElementType());

	public static final IGrammarAwareElementType AltList1_Val1Assignment_1_2_1_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val1Assignment_1_2_1ElementType());

	public static final IGrammarAwareElementType AltList1_Val1IDTerminalRuleCall_1_2_1_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val1IDTerminalRuleCall_1_2_1_0ElementType());

	public static final IGrammarAwareElementType AltList1_Val4Assignment_1_2_2_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val4Assignment_1_2_2ElementType());

	public static final IGrammarAwareElementType AltList1_Val4IDTerminalRuleCall_1_2_2_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_Val4IDTerminalRuleCall_1_2_2_0ElementType());

	private static class AltList2Factory {
		public static IGrammarAwareElementType createAltList2ElementType() {
			return new IGrammarAwareElementType("AltList2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Rule());
		}
		public static IGrammarAwareElementType createAltList2_GroupElementType() {
			return new IGrammarAwareElementType("AltList2_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getGroup());
		}
		public static IGrammarAwareElementType createAltList2_NumberSignDigitTwoDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("AltList2_NumberSignDigitTwoDigitThreeKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getNumberSignDigitTwoDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createAltList2_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("AltList2_Alternatives_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createAltList2_Group_1_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Group_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createAltList2_Val1Assignment_1_0_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1Assignment_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1Assignment_1_0_0());
		}
		public static IGrammarAwareElementType createAltList2_Val1IDTerminalRuleCall_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1IDTerminalRuleCall_1_0_0_0());
		}
		public static IGrammarAwareElementType createAltList2_Val2Assignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("AltList2_Val2Assignment_1_0_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal2Assignment_1_0_1());
		}
		public static IGrammarAwareElementType createAltList2_Val2IDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val2IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal2IDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createAltList2_Group_1_1ElementType() {
			return new IGrammarAwareElementType("AltList2_Group_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAltList2_KwKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("AltList2_KwKeyword_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getKwKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createAltList2_Val1Assignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1Assignment_1_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1Assignment_1_1_1());
		}
		public static IGrammarAwareElementType createAltList2_Val1IDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1IDTerminalRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createAltList2_Group_1_1_2ElementType() {
			return new IGrammarAwareElementType("AltList2_Group_1_1_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getGroup_1_1_2());
		}
		public static IGrammarAwareElementType createAltList2_CommaKeyword_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("AltList2_CommaKeyword_1_1_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getCommaKeyword_1_1_2_0());
		}
		public static IGrammarAwareElementType createAltList2_Val1Assignment_1_1_2_1ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1Assignment_1_1_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1Assignment_1_1_2_1());
		}
		public static IGrammarAwareElementType createAltList2_Val1IDTerminalRuleCall_1_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1IDTerminalRuleCall_1_1_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1IDTerminalRuleCall_1_1_2_1_0());
		}
		public static IGrammarAwareElementType createAltList2_Val3Assignment_1_1_3ElementType() {
			return new IGrammarAwareElementType("AltList2_Val3Assignment_1_1_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal3Assignment_1_1_3());
		}
		public static IGrammarAwareElementType createAltList2_Val3IDTerminalRuleCall_1_1_3_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val3IDTerminalRuleCall_1_1_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal3IDTerminalRuleCall_1_1_3_0());
		}
	}

	public static final IGrammarAwareElementType AltList2_ELEMENT_TYPE = associate(AltList2Factory.createAltList2ElementType());

	public static final IGrammarAwareElementType AltList2_Group_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_GroupElementType());

	public static final IGrammarAwareElementType AltList2_NumberSignDigitTwoDigitThreeKeyword_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_NumberSignDigitTwoDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType AltList2_Alternatives_1_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Alternatives_1ElementType());

	public static final IGrammarAwareElementType AltList2_Group_1_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Group_1_0ElementType());

	public static final IGrammarAwareElementType AltList2_Val1Assignment_1_0_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Val1Assignment_1_0_0ElementType());

	public static final IGrammarAwareElementType AltList2_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Val1IDTerminalRuleCall_1_0_0_0ElementType());

	public static final IGrammarAwareElementType AltList2_Val2Assignment_1_0_1_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Val2Assignment_1_0_1ElementType());

	public static final IGrammarAwareElementType AltList2_Val2IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Val2IDTerminalRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType AltList2_Group_1_1_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Group_1_1ElementType());

	public static final IGrammarAwareElementType AltList2_KwKeyword_1_1_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_KwKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType AltList2_Val1Assignment_1_1_1_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Val1Assignment_1_1_1ElementType());

	public static final IGrammarAwareElementType AltList2_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());

	public static final IGrammarAwareElementType AltList2_Group_1_1_2_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Group_1_1_2ElementType());

	public static final IGrammarAwareElementType AltList2_CommaKeyword_1_1_2_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_CommaKeyword_1_1_2_0ElementType());

	public static final IGrammarAwareElementType AltList2_Val1Assignment_1_1_2_1_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Val1Assignment_1_1_2_1ElementType());

	public static final IGrammarAwareElementType AltList2_Val1IDTerminalRuleCall_1_1_2_1_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Val1IDTerminalRuleCall_1_1_2_1_0ElementType());

	public static final IGrammarAwareElementType AltList2_Val3Assignment_1_1_3_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Val3Assignment_1_1_3ElementType());

	public static final IGrammarAwareElementType AltList2_Val3IDTerminalRuleCall_1_1_3_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_Val3IDTerminalRuleCall_1_1_3_0ElementType());

	private static class TransientObjectFactory {
		public static IGrammarAwareElementType createTransientObjectElementType() {
			return new IGrammarAwareElementType("TransientObject_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectRule());
		}
		public static IGrammarAwareElementType createTransientObject_GroupElementType() {
			return new IGrammarAwareElementType("TransientObject_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectAccess().getGroup());
		}
		public static IGrammarAwareElementType createTransientObject_NumberSignDigitTwoDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("TransientObject_NumberSignDigitTwoDigitFourKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectAccess().getNumberSignDigitTwoDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createTransientObject_Group_1ElementType() {
			return new IGrammarAwareElementType("TransientObject_Group_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createTransientObject_Val1Assignment_1_0ElementType() {
			return new IGrammarAwareElementType("TransientObject_Val1Assignment_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectAccess().getVal1Assignment_1_0());
		}
		public static IGrammarAwareElementType createTransientObject_Val1IDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("TransientObject_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectAccess().getVal1IDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createTransientObject_NestedAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("TransientObject_NestedAssignment_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectAccess().getNestedAssignment_1_1());
		}
		public static IGrammarAwareElementType createTransientObject_NestedTransientObjectSubParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("TransientObject_NestedTransientObjectSubParserRuleCall_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectAccess().getNestedTransientObjectSubParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType TransientObject_ELEMENT_TYPE = associate(TransientObjectFactory.createTransientObjectElementType());

	public static final IGrammarAwareElementType TransientObject_Group_ELEMENT_TYPE = associate(TransientObjectFactory.createTransientObject_GroupElementType());

	public static final IGrammarAwareElementType TransientObject_NumberSignDigitTwoDigitFourKeyword_0_ELEMENT_TYPE = associate(TransientObjectFactory.createTransientObject_NumberSignDigitTwoDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType TransientObject_Group_1_ELEMENT_TYPE = associate(TransientObjectFactory.createTransientObject_Group_1ElementType());

	public static final IGrammarAwareElementType TransientObject_Val1Assignment_1_0_ELEMENT_TYPE = associate(TransientObjectFactory.createTransientObject_Val1Assignment_1_0ElementType());

	public static final IGrammarAwareElementType TransientObject_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(TransientObjectFactory.createTransientObject_Val1IDTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType TransientObject_NestedAssignment_1_1_ELEMENT_TYPE = associate(TransientObjectFactory.createTransientObject_NestedAssignment_1_1ElementType());

	public static final IGrammarAwareElementType TransientObject_NestedTransientObjectSubParserRuleCall_1_1_0_ELEMENT_TYPE = associate(TransientObjectFactory.createTransientObject_NestedTransientObjectSubParserRuleCall_1_1_0ElementType());

	private static class TransientObjectSubFactory {
		public static IGrammarAwareElementType createTransientObjectSubElementType() {
			return new IGrammarAwareElementType("TransientObjectSub_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectSubRule());
		}
		public static IGrammarAwareElementType createTransientObjectSub_GroupElementType() {
			return new IGrammarAwareElementType("TransientObjectSub_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectSubAccess().getGroup());
		}
		public static IGrammarAwareElementType createTransientObjectSub_Val2Assignment_0ElementType() {
			return new IGrammarAwareElementType("TransientObjectSub_Val2Assignment_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectSubAccess().getVal2Assignment_0());
		}
		public static IGrammarAwareElementType createTransientObjectSub_Val2IDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("TransientObjectSub_Val2IDTerminalRuleCall_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectSubAccess().getVal2IDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createTransientObjectSub_Val3Assignment_1ElementType() {
			return new IGrammarAwareElementType("TransientObjectSub_Val3Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectSubAccess().getVal3Assignment_1());
		}
		public static IGrammarAwareElementType createTransientObjectSub_Val3IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TransientObjectSub_Val3IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientObjectSubAccess().getVal3IDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType TransientObjectSub_ELEMENT_TYPE = associate(TransientObjectSubFactory.createTransientObjectSubElementType());

	public static final IGrammarAwareElementType TransientObjectSub_Group_ELEMENT_TYPE = associate(TransientObjectSubFactory.createTransientObjectSub_GroupElementType());

	public static final IGrammarAwareElementType TransientObjectSub_Val2Assignment_0_ELEMENT_TYPE = associate(TransientObjectSubFactory.createTransientObjectSub_Val2Assignment_0ElementType());

	public static final IGrammarAwareElementType TransientObjectSub_Val2IDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(TransientObjectSubFactory.createTransientObjectSub_Val2IDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType TransientObjectSub_Val3Assignment_1_ELEMENT_TYPE = associate(TransientObjectSubFactory.createTransientObjectSub_Val3Assignment_1ElementType());

	public static final IGrammarAwareElementType TransientObjectSub_Val3IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TransientObjectSubFactory.createTransientObjectSub_Val3IDTerminalRuleCall_1_0ElementType());

	private static class TransientSerializeables1Factory {
		public static IGrammarAwareElementType createTransientSerializeables1ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Rule());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_GroupElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getGroup());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_NumberSignDigitTwoDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_NumberSignDigitTwoDigitFiveKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getNumberSignDigitTwoDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_Group_1ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Group_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getGroup_1());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_Val1Assignment_1_0ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Val1Assignment_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getVal1Assignment_1_0());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_Val1IDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getVal1IDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_Enum1Assignment_1_1ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Enum1Assignment_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getEnum1Assignment_1_1());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_Enum1TransientSerializeables1EnumEnumRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Enum1TransientSerializeables1EnumEnumRuleCall_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getEnum1TransientSerializeables1EnumEnumRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_Group_2ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Group_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getGroup_2());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_Val2Assignment_2_0ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Val2Assignment_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getVal2Assignment_2_0());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_Val2IDTerminalRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Val2IDTerminalRuleCall_2_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getVal2IDTerminalRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_Int1Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Int1Assignment_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getInt1Assignment_2_1());
		}
		public static IGrammarAwareElementType createTransientSerializeables1_Int1INTTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1_Int1INTTerminalRuleCall_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1Access().getInt1INTTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType TransientSerializeables1_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Group_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_GroupElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_NumberSignDigitTwoDigitFiveKeyword_0_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_NumberSignDigitTwoDigitFiveKeyword_0ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Group_1_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_Group_1ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Val1Assignment_1_0_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_Val1Assignment_1_0ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_Val1IDTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Enum1Assignment_1_1_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_Enum1Assignment_1_1ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Enum1TransientSerializeables1EnumEnumRuleCall_1_1_0_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_Enum1TransientSerializeables1EnumEnumRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Group_2_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_Group_2ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Val2Assignment_2_0_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_Val2Assignment_2_0ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Val2IDTerminalRuleCall_2_0_0_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_Val2IDTerminalRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Int1Assignment_2_1_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_Int1Assignment_2_1ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1_Int1INTTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(TransientSerializeables1Factory.createTransientSerializeables1_Int1INTTerminalRuleCall_2_1_0ElementType());

	private static class TransientSerializeables1EnumFactory {
		public static IGrammarAwareElementType createTransientSerializeables1EnumElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1Enum_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1EnumRule());
		}
		public static IGrammarAwareElementType createTransientSerializeables1Enum_AlternativesElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1Enum_Alternatives_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1EnumAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createTransientSerializeables1Enum_Lit1EnumLiteralDeclaration_0ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1Enum_Lit1EnumLiteralDeclaration_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1EnumAccess().getLit1EnumLiteralDeclaration_0());
		}
		public static IGrammarAwareElementType createTransientSerializeables1Enum_Lit1Lit1Keyword_0_0ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1Enum_Lit1Lit1Keyword_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1EnumAccess().getLit1Lit1Keyword_0_0());
		}
		public static IGrammarAwareElementType createTransientSerializeables1Enum_Lit2EnumLiteralDeclaration_1ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1Enum_Lit2EnumLiteralDeclaration_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1EnumAccess().getLit2EnumLiteralDeclaration_1());
		}
		public static IGrammarAwareElementType createTransientSerializeables1Enum_Lit2Lit2Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("TransientSerializeables1Enum_Lit2Lit2Keyword_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransientSerializeables1EnumAccess().getLit2Lit2Keyword_1_0());
		}
	}

	public static final IGrammarAwareElementType TransientSerializeables1Enum_ELEMENT_TYPE = associate(TransientSerializeables1EnumFactory.createTransientSerializeables1EnumElementType());

	public static final IGrammarAwareElementType TransientSerializeables1Enum_Alternatives_ELEMENT_TYPE = associate(TransientSerializeables1EnumFactory.createTransientSerializeables1Enum_AlternativesElementType());

	public static final IGrammarAwareElementType TransientSerializeables1Enum_Lit1EnumLiteralDeclaration_0_ELEMENT_TYPE = associate(TransientSerializeables1EnumFactory.createTransientSerializeables1Enum_Lit1EnumLiteralDeclaration_0ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1Enum_Lit1Lit1Keyword_0_0_ELEMENT_TYPE = associate(TransientSerializeables1EnumFactory.createTransientSerializeables1Enum_Lit1Lit1Keyword_0_0ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1Enum_Lit2EnumLiteralDeclaration_1_ELEMENT_TYPE = associate(TransientSerializeables1EnumFactory.createTransientSerializeables1Enum_Lit2EnumLiteralDeclaration_1ElementType());

	public static final IGrammarAwareElementType TransientSerializeables1Enum_Lit2Lit2Keyword_1_0_ELEMENT_TYPE = associate(TransientSerializeables1EnumFactory.createTransientSerializeables1Enum_Lit2Lit2Keyword_1_0ElementType());

	private static class StaticSimplificationFactory {
		public static IGrammarAwareElementType createStaticSimplificationElementType() {
			return new IGrammarAwareElementType("StaticSimplification_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationRule());
		}
		public static IGrammarAwareElementType createStaticSimplification_GroupElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getGroup());
		}
		public static IGrammarAwareElementType createStaticSimplification_NumberSignDigitTwoDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_NumberSignDigitTwoDigitSixKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getNumberSignDigitTwoDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createStaticSimplification_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Alternatives_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createStaticSimplification_Kw1Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Kw1Keyword_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getKw1Keyword_1_0());
		}
		public static IGrammarAwareElementType createStaticSimplification_EmptyAlternativeSubAction_1_1ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_EmptyAlternativeSubAction_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getEmptyAlternativeSubAction_1_1());
		}
		public static IGrammarAwareElementType createStaticSimplification_Val1Assignment_1_2ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Val1Assignment_1_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getVal1Assignment_1_2());
		}
		public static IGrammarAwareElementType createStaticSimplification_Val1IDTerminalRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Val1IDTerminalRuleCall_1_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getVal1IDTerminalRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createStaticSimplification_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Alternatives_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createStaticSimplification_Kw2Keyword_2_0ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Kw2Keyword_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getKw2Keyword_2_0());
		}
		public static IGrammarAwareElementType createStaticSimplification_Val2Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Val2Assignment_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getVal2Assignment_2_1());
		}
		public static IGrammarAwareElementType createStaticSimplification_Val2IDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Val2IDTerminalRuleCall_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getVal2IDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createStaticSimplification_Group_3ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Group_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createStaticSimplification_Kw3Keyword_3_0ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Kw3Keyword_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getKw3Keyword_3_0());
		}
		public static IGrammarAwareElementType createStaticSimplification_Group_3_1ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Group_3_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createStaticSimplification_Kw4Keyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Kw4Keyword_3_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getKw4Keyword_3_1_0());
		}
		public static IGrammarAwareElementType createStaticSimplification_Val3Assignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Val3Assignment_3_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getVal3Assignment_3_1_1());
		}
		public static IGrammarAwareElementType createStaticSimplification_Val3IDTerminalRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("StaticSimplification_Val3IDTerminalRuleCall_3_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticSimplificationAccess().getVal3IDTerminalRuleCall_3_1_1_0());
		}
	}

	public static final IGrammarAwareElementType StaticSimplification_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplificationElementType());

	public static final IGrammarAwareElementType StaticSimplification_Group_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_GroupElementType());

	public static final IGrammarAwareElementType StaticSimplification_NumberSignDigitTwoDigitSixKeyword_0_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_NumberSignDigitTwoDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Alternatives_1_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Alternatives_1ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Kw1Keyword_1_0_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Kw1Keyword_1_0ElementType());

	public static final IGrammarAwareElementType StaticSimplification_EmptyAlternativeSubAction_1_1_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_EmptyAlternativeSubAction_1_1ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Val1Assignment_1_2_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Val1Assignment_1_2ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Val1IDTerminalRuleCall_1_2_0_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Val1IDTerminalRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Alternatives_2_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Alternatives_2ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Kw2Keyword_2_0_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Kw2Keyword_2_0ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Val2Assignment_2_1_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Val2Assignment_2_1ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Val2IDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Val2IDTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Group_3_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Group_3ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Kw3Keyword_3_0_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Kw3Keyword_3_0ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Group_3_1_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Group_3_1ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Kw4Keyword_3_1_0_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Kw4Keyword_3_1_0ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Val3Assignment_3_1_1_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Val3Assignment_3_1_1ElementType());

	public static final IGrammarAwareElementType StaticSimplification_Val3IDTerminalRuleCall_3_1_1_0_ELEMENT_TYPE = associate(StaticSimplificationFactory.createStaticSimplification_Val3IDTerminalRuleCall_3_1_1_0ElementType());

	private static class TwoVersionFactory {
		public static IGrammarAwareElementType createTwoVersionElementType() {
			return new IGrammarAwareElementType("TwoVersion_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionRule());
		}
		public static IGrammarAwareElementType createTwoVersion_GroupElementType() {
			return new IGrammarAwareElementType("TwoVersion_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionAccess().getGroup());
		}
		public static IGrammarAwareElementType createTwoVersion_NumberSignDigitTwoDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("TwoVersion_NumberSignDigitTwoDigitSevenKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionAccess().getNumberSignDigitTwoDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createTwoVersion_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("TwoVersion_Alternatives_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createTwoVersion_TwoVersionNo1ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TwoVersion_TwoVersionNo1ParserRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionAccess().getTwoVersionNo1ParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTwoVersion_TwoVersionNo2ParserRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("TwoVersion_TwoVersionNo2ParserRuleCall_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionAccess().getTwoVersionNo2ParserRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType TwoVersion_ELEMENT_TYPE = associate(TwoVersionFactory.createTwoVersionElementType());

	public static final IGrammarAwareElementType TwoVersion_Group_ELEMENT_TYPE = associate(TwoVersionFactory.createTwoVersion_GroupElementType());

	public static final IGrammarAwareElementType TwoVersion_NumberSignDigitTwoDigitSevenKeyword_0_ELEMENT_TYPE = associate(TwoVersionFactory.createTwoVersion_NumberSignDigitTwoDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType TwoVersion_Alternatives_1_ELEMENT_TYPE = associate(TwoVersionFactory.createTwoVersion_Alternatives_1ElementType());

	public static final IGrammarAwareElementType TwoVersion_TwoVersionNo1ParserRuleCall_1_0_ELEMENT_TYPE = associate(TwoVersionFactory.createTwoVersion_TwoVersionNo1ParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TwoVersion_TwoVersionNo2ParserRuleCall_1_1_ELEMENT_TYPE = associate(TwoVersionFactory.createTwoVersion_TwoVersionNo2ParserRuleCall_1_1ElementType());

	private static class TwoVersionNo1Factory {
		public static IGrammarAwareElementType createTwoVersionNo1ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Rule());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_GroupElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getGroup());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Shared1Assignment_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Shared1Assignment_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getShared1Assignment_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Shared1IDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Shared1IDTerminalRuleCall_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getShared1IDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Shared2Assignment_1ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Shared2Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getShared2Assignment_1());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Shared2IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Shared2IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getShared2IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_ShortKeyword_2ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_ShortKeyword_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getShortKeyword_2());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Group_3ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Group_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getGroup_3());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Shared3Assignment_3_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Shared3Assignment_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getShared3Assignment_3_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Shared3IDTerminalRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Shared3IDTerminalRuleCall_3_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getShared3IDTerminalRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Shared3Assignment_3_1ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Shared3Assignment_3_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getShared3Assignment_3_1());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Shared3IDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Shared3IDTerminalRuleCall_3_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getShared3IDTerminalRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_OneKeyword_4ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_OneKeyword_4_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getOneKeyword_4());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Version1Assignment_5ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Version1Assignment_5_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getVersion1Assignment_5());
		}
		public static IGrammarAwareElementType createTwoVersionNo1_Version1IDTerminalRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo1_Version1IDTerminalRuleCall_5_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo1Access().getVersion1IDTerminalRuleCall_5_0());
		}
	}

	public static final IGrammarAwareElementType TwoVersionNo1_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Group_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_GroupElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Shared1Assignment_0_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Shared1Assignment_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Shared1IDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Shared1IDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Shared2Assignment_1_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Shared2Assignment_1ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Shared2IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Shared2IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_ShortKeyword_2_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_ShortKeyword_2ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Group_3_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Group_3ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Shared3Assignment_3_0_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Shared3Assignment_3_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Shared3IDTerminalRuleCall_3_0_0_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Shared3IDTerminalRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Shared3Assignment_3_1_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Shared3Assignment_3_1ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Shared3IDTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Shared3IDTerminalRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_OneKeyword_4_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_OneKeyword_4ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Version1Assignment_5_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Version1Assignment_5ElementType());

	public static final IGrammarAwareElementType TwoVersionNo1_Version1IDTerminalRuleCall_5_0_ELEMENT_TYPE = associate(TwoVersionNo1Factory.createTwoVersionNo1_Version1IDTerminalRuleCall_5_0ElementType());

	private static class TwoVersionNo2Factory {
		public static IGrammarAwareElementType createTwoVersionNo2ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Rule());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_GroupElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getGroup());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Shared1Assignment_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Shared1Assignment_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getShared1Assignment_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Shared1IDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Shared1IDTerminalRuleCall_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getShared1IDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Shared2Assignment_1ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Shared2Assignment_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getShared2Assignment_1());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Shared2IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Shared2IDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getShared2IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_LongKeyword_2ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_LongKeyword_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getLongKeyword_2());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Group_3ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Group_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getGroup_3());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Shared3Assignment_3_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Shared3Assignment_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getShared3Assignment_3_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Shared3IDTerminalRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Shared3IDTerminalRuleCall_3_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getShared3IDTerminalRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Shared3Assignment_3_1ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Shared3Assignment_3_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getShared3Assignment_3_1());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Shared3IDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Shared3IDTerminalRuleCall_3_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getShared3IDTerminalRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_ExtraKeyword_4ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_ExtraKeyword_4_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getExtraKeyword_4());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Extra1Assignment_5ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Extra1Assignment_5_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getExtra1Assignment_5());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Extra1IDTerminalRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Extra1IDTerminalRuleCall_5_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getExtra1IDTerminalRuleCall_5_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Alternatives_6ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Alternatives_6_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getAlternatives_6());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Group_6_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Group_6_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getGroup_6_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Extra2Assignment_6_0_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Extra2Assignment_6_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getExtra2Assignment_6_0_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Extra2IDTerminalRuleCall_6_0_0_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Extra2IDTerminalRuleCall_6_0_0_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getExtra2IDTerminalRuleCall_6_0_0_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Extra3Assignment_6_0_1ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Extra3Assignment_6_0_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getExtra3Assignment_6_0_1());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Extra3IDTerminalRuleCall_6_0_1_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Extra3IDTerminalRuleCall_6_0_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getExtra3IDTerminalRuleCall_6_0_1_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Group_6_1ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Group_6_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getGroup_6_1());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_TwoKeyword_6_1_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_TwoKeyword_6_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getTwoKeyword_6_1_0());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Extra4Assignment_6_1_1ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Extra4Assignment_6_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getExtra4Assignment_6_1_1());
		}
		public static IGrammarAwareElementType createTwoVersionNo2_Extra4IDTerminalRuleCall_6_1_1_0ElementType() {
			return new IGrammarAwareElementType("TwoVersionNo2_Extra4IDTerminalRuleCall_6_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoVersionNo2Access().getExtra4IDTerminalRuleCall_6_1_1_0());
		}
	}

	public static final IGrammarAwareElementType TwoVersionNo2_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Group_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_GroupElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Shared1Assignment_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Shared1Assignment_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Shared1IDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Shared1IDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Shared2Assignment_1_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Shared2Assignment_1ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Shared2IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Shared2IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_LongKeyword_2_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_LongKeyword_2ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Group_3_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Group_3ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Shared3Assignment_3_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Shared3Assignment_3_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Shared3IDTerminalRuleCall_3_0_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Shared3IDTerminalRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Shared3Assignment_3_1_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Shared3Assignment_3_1ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Shared3IDTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Shared3IDTerminalRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_ExtraKeyword_4_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_ExtraKeyword_4ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Extra1Assignment_5_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Extra1Assignment_5ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Extra1IDTerminalRuleCall_5_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Extra1IDTerminalRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Alternatives_6_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Alternatives_6ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Group_6_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Group_6_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Extra2Assignment_6_0_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Extra2Assignment_6_0_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Extra2IDTerminalRuleCall_6_0_0_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Extra2IDTerminalRuleCall_6_0_0_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Extra3Assignment_6_0_1_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Extra3Assignment_6_0_1ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Extra3IDTerminalRuleCall_6_0_1_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Extra3IDTerminalRuleCall_6_0_1_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Group_6_1_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Group_6_1ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_TwoKeyword_6_1_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_TwoKeyword_6_1_0ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Extra4Assignment_6_1_1_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Extra4Assignment_6_1_1ElementType());

	public static final IGrammarAwareElementType TwoVersionNo2_Extra4IDTerminalRuleCall_6_1_1_0_ELEMENT_TYPE = associate(TwoVersionNo2Factory.createTwoVersionNo2_Extra4IDTerminalRuleCall_6_1_1_0ElementType());

	private static class Heuristic1Factory {
		public static IGrammarAwareElementType createHeuristic1ElementType() {
			return new IGrammarAwareElementType("Heuristic1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Rule());
		}
		public static IGrammarAwareElementType createHeuristic1_GroupElementType() {
			return new IGrammarAwareElementType("Heuristic1_Group_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getGroup());
		}
		public static IGrammarAwareElementType createHeuristic1_NumberSignDigitTwoDigitEightKeyword_0ElementType() {
			return new IGrammarAwareElementType("Heuristic1_NumberSignDigitTwoDigitEightKeyword_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getNumberSignDigitTwoDigitEightKeyword_0());
		}
		public static IGrammarAwareElementType createHeuristic1_Group_1ElementType() {
			return new IGrammarAwareElementType("Heuristic1_Group_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getGroup_1());
		}
		public static IGrammarAwareElementType createHeuristic1_Kw1Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("Heuristic1_Kw1Keyword_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getKw1Keyword_1_0());
		}
		public static IGrammarAwareElementType createHeuristic1_AAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Heuristic1_AAssignment_1_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getAAssignment_1_1());
		}
		public static IGrammarAwareElementType createHeuristic1_AIDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Heuristic1_AIDTerminalRuleCall_1_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getAIDTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createHeuristic1_BAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Heuristic1_BAssignment_1_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getBAssignment_1_2());
		}
		public static IGrammarAwareElementType createHeuristic1_BIDTerminalRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Heuristic1_BIDTerminalRuleCall_1_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getBIDTerminalRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createHeuristic1_Group_2ElementType() {
			return new IGrammarAwareElementType("Heuristic1_Group_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getGroup_2());
		}
		public static IGrammarAwareElementType createHeuristic1_Kw2Keyword_2_0ElementType() {
			return new IGrammarAwareElementType("Heuristic1_Kw2Keyword_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getKw2Keyword_2_0());
		}
		public static IGrammarAwareElementType createHeuristic1_AAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Heuristic1_AAssignment_2_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getAAssignment_2_1());
		}
		public static IGrammarAwareElementType createHeuristic1_AIDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Heuristic1_AIDTerminalRuleCall_2_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getAIDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createHeuristic1_CAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("Heuristic1_CAssignment_2_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getCAssignment_2_2());
		}
		public static IGrammarAwareElementType createHeuristic1_CIDTerminalRuleCall_2_2_0ElementType() {
			return new IGrammarAwareElementType("Heuristic1_CIDTerminalRuleCall_2_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getCIDTerminalRuleCall_2_2_0());
		}
		public static IGrammarAwareElementType createHeuristic1_Group_3ElementType() {
			return new IGrammarAwareElementType("Heuristic1_Group_3_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getGroup_3());
		}
		public static IGrammarAwareElementType createHeuristic1_Kw3Keyword_3_0ElementType() {
			return new IGrammarAwareElementType("Heuristic1_Kw3Keyword_3_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getKw3Keyword_3_0());
		}
		public static IGrammarAwareElementType createHeuristic1_BAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Heuristic1_BAssignment_3_1_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getBAssignment_3_1());
		}
		public static IGrammarAwareElementType createHeuristic1_BIDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Heuristic1_BIDTerminalRuleCall_3_1_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getBIDTerminalRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createHeuristic1_CAssignment_3_2ElementType() {
			return new IGrammarAwareElementType("Heuristic1_CAssignment_3_2_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getCAssignment_3_2());
		}
		public static IGrammarAwareElementType createHeuristic1_CIDTerminalRuleCall_3_2_0ElementType() {
			return new IGrammarAwareElementType("Heuristic1_CIDTerminalRuleCall_3_2_0_ELEMENT_TYPE", ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHeuristic1Access().getCIDTerminalRuleCall_3_2_0());
		}
	}

	public static final IGrammarAwareElementType Heuristic1_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1ElementType());

	public static final IGrammarAwareElementType Heuristic1_Group_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_GroupElementType());

	public static final IGrammarAwareElementType Heuristic1_NumberSignDigitTwoDigitEightKeyword_0_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_NumberSignDigitTwoDigitEightKeyword_0ElementType());

	public static final IGrammarAwareElementType Heuristic1_Group_1_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_Group_1ElementType());

	public static final IGrammarAwareElementType Heuristic1_Kw1Keyword_1_0_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_Kw1Keyword_1_0ElementType());

	public static final IGrammarAwareElementType Heuristic1_AAssignment_1_1_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_AAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Heuristic1_AIDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_AIDTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Heuristic1_BAssignment_1_2_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_BAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Heuristic1_BIDTerminalRuleCall_1_2_0_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_BIDTerminalRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType Heuristic1_Group_2_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_Group_2ElementType());

	public static final IGrammarAwareElementType Heuristic1_Kw2Keyword_2_0_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_Kw2Keyword_2_0ElementType());

	public static final IGrammarAwareElementType Heuristic1_AAssignment_2_1_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_AAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Heuristic1_AIDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_AIDTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Heuristic1_CAssignment_2_2_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_CAssignment_2_2ElementType());

	public static final IGrammarAwareElementType Heuristic1_CIDTerminalRuleCall_2_2_0_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_CIDTerminalRuleCall_2_2_0ElementType());

	public static final IGrammarAwareElementType Heuristic1_Group_3_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_Group_3ElementType());

	public static final IGrammarAwareElementType Heuristic1_Kw3Keyword_3_0_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_Kw3Keyword_3_0ElementType());

	public static final IGrammarAwareElementType Heuristic1_BAssignment_3_1_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_BAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Heuristic1_BIDTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_BIDTerminalRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType Heuristic1_CAssignment_3_2_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_CAssignment_3_2ElementType());

	public static final IGrammarAwareElementType Heuristic1_CIDTerminalRuleCall_3_2_0_ELEMENT_TYPE = associate(Heuristic1Factory.createHeuristic1_CIDTerminalRuleCall_3_2_0ElementType());

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

	public IGrammarAwareElementType getModel_X1SimpleGroupParserRuleCall_0_0ElementType() {
		return Model_X1SimpleGroupParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X2Assignment_1ElementType() {
		return Model_X2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X2SimpleAlternativeParserRuleCall_1_0ElementType() {
		return Model_X2SimpleAlternativeParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X3Assignment_2ElementType() {
		return Model_X3Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X3SimpleMultiplicitiesParserRuleCall_2_0ElementType() {
		return Model_X3SimpleMultiplicitiesParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X4Assignment_3ElementType() {
		return Model_X4Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X4GroupMultiplicitiesParserRuleCall_3_0ElementType() {
		return Model_X4GroupMultiplicitiesParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X5Assignment_4ElementType() {
		return Model_X5Assignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X5AlternativeMultiplicitiesParserRuleCall_4_0ElementType() {
		return Model_X5AlternativeMultiplicitiesParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X6Assignment_5ElementType() {
		return Model_X6Assignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X6AssignedActionParserRuleCall_5_0ElementType() {
		return Model_X6AssignedActionParserRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X7Assignment_6ElementType() {
		return Model_X7Assignment_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X7AssignedActionSecondParserRuleCall_6_0ElementType() {
		return Model_X7AssignedActionSecondParserRuleCall_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X8Assignment_7ElementType() {
		return Model_X8Assignment_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X8UnassignedAction1ParserRuleCall_7_0ElementType() {
		return Model_X8UnassignedAction1ParserRuleCall_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X9Assignment_8ElementType() {
		return Model_X9Assignment_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X9UnassignedAction2ParserRuleCall_8_0ElementType() {
		return Model_X9UnassignedAction2ParserRuleCall_8_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X10Assignment_9ElementType() {
		return Model_X10Assignment_9_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X10UnassignedAction3ParserRuleCall_9_0ElementType() {
		return Model_X10UnassignedAction3ParserRuleCall_9_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X11Assignment_10ElementType() {
		return Model_X11Assignment_10_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X11UnassignedRuleCall1ParserRuleCall_10_0ElementType() {
		return Model_X11UnassignedRuleCall1ParserRuleCall_10_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X12Assignment_11ElementType() {
		return Model_X12Assignment_11_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X12UnassignedRuleCall2ParserRuleCall_11_0ElementType() {
		return Model_X12UnassignedRuleCall2ParserRuleCall_11_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X13Assignment_12ElementType() {
		return Model_X13Assignment_12_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X13Combination1ParserRuleCall_12_0ElementType() {
		return Model_X13Combination1ParserRuleCall_12_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X14Assignment_13ElementType() {
		return Model_X14Assignment_13_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X14Combination2ParserRuleCall_13_0ElementType() {
		return Model_X14Combination2ParserRuleCall_13_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X15Assignment_14ElementType() {
		return Model_X15Assignment_14_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X15Combination3ParserRuleCall_14_0ElementType() {
		return Model_X15Combination3ParserRuleCall_14_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X16Assignment_15ElementType() {
		return Model_X16Assignment_15_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X16Combination4ParserRuleCall_15_0ElementType() {
		return Model_X16Combination4ParserRuleCall_15_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X17Assignment_16ElementType() {
		return Model_X17Assignment_16_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X17List1ParserRuleCall_16_0ElementType() {
		return Model_X17List1ParserRuleCall_16_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X18Assignment_17ElementType() {
		return Model_X18Assignment_17_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X18List2ParserRuleCall_17_0ElementType() {
		return Model_X18List2ParserRuleCall_17_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X19Assignment_18ElementType() {
		return Model_X19Assignment_18_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X19List3ParserRuleCall_18_0ElementType() {
		return Model_X19List3ParserRuleCall_18_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X20Assignment_19ElementType() {
		return Model_X20Assignment_19_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X20List4ParserRuleCall_19_0ElementType() {
		return Model_X20List4ParserRuleCall_19_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X21Assignment_20ElementType() {
		return Model_X21Assignment_20_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X21List5ParserRuleCall_20_0ElementType() {
		return Model_X21List5ParserRuleCall_20_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X22Assignment_21ElementType() {
		return Model_X22Assignment_21_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X22AltList1ParserRuleCall_21_0ElementType() {
		return Model_X22AltList1ParserRuleCall_21_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X23Assignment_22ElementType() {
		return Model_X23Assignment_22_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X23AltList2ParserRuleCall_22_0ElementType() {
		return Model_X23AltList2ParserRuleCall_22_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X24Assignment_23ElementType() {
		return Model_X24Assignment_23_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X24TransientObjectParserRuleCall_23_0ElementType() {
		return Model_X24TransientObjectParserRuleCall_23_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X25Assignment_24ElementType() {
		return Model_X25Assignment_24_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X25TransientSerializeables1ParserRuleCall_24_0ElementType() {
		return Model_X25TransientSerializeables1ParserRuleCall_24_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X26Assignment_25ElementType() {
		return Model_X26Assignment_25_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X26StaticSimplificationParserRuleCall_25_0ElementType() {
		return Model_X26StaticSimplificationParserRuleCall_25_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X27Assignment_26ElementType() {
		return Model_X27Assignment_26_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X27TwoVersionParserRuleCall_26_0ElementType() {
		return Model_X27TwoVersionParserRuleCall_26_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X28Assignment_27ElementType() {
		return Model_X28Assignment_27_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X28Heuristic1ParserRuleCall_27_0ElementType() {
		return Model_X28Heuristic1ParserRuleCall_27_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleGroupElementType() {
		return SimpleGroup_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleGroup_GroupElementType() {
		return SimpleGroup_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleGroup_NumberSignDigitOneKeyword_0ElementType() {
		return SimpleGroup_NumberSignDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleGroup_Val1Assignment_1ElementType() {
		return SimpleGroup_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleGroup_Val1IDTerminalRuleCall_1_0ElementType() {
		return SimpleGroup_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleGroup_Val2Assignment_2ElementType() {
		return SimpleGroup_Val2Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleGroup_Val2IDTerminalRuleCall_2_0ElementType() {
		return SimpleGroup_Val2IDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternativeElementType() {
		return SimpleAlternative_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_GroupElementType() {
		return SimpleAlternative_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_NumberSignDigitTwoKeyword_0ElementType() {
		return SimpleAlternative_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_Alternatives_1ElementType() {
		return SimpleAlternative_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_Group_1_0ElementType() {
		return SimpleAlternative_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_Kw1Keyword_1_0_0ElementType() {
		return SimpleAlternative_Kw1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_Val1Assignment_1_0_1ElementType() {
		return SimpleAlternative_Val1Assignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0ElementType() {
		return SimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_Group_1_1ElementType() {
		return SimpleAlternative_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_Kw2Keyword_1_1_0ElementType() {
		return SimpleAlternative_Kw2Keyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_Val2Assignment_1_1_1ElementType() {
		return SimpleAlternative_Val2Assignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0ElementType() {
		return SimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicitiesElementType() {
		return SimpleMultiplicities_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_GroupElementType() {
		return SimpleMultiplicities_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_NumberSignDigitThreeKeyword_0ElementType() {
		return SimpleMultiplicities_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Val1Assignment_1ElementType() {
		return SimpleMultiplicities_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Val1IDTerminalRuleCall_1_0ElementType() {
		return SimpleMultiplicities_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Kw1Keyword_2ElementType() {
		return SimpleMultiplicities_Kw1Keyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Val2Assignment_3ElementType() {
		return SimpleMultiplicities_Val2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Val2IDTerminalRuleCall_3_0ElementType() {
		return SimpleMultiplicities_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Kw2Keyword_4ElementType() {
		return SimpleMultiplicities_Kw2Keyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Val3Assignment_5ElementType() {
		return SimpleMultiplicities_Val3Assignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Val3IDTerminalRuleCall_5_0ElementType() {
		return SimpleMultiplicities_Val3IDTerminalRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Kw3Keyword_6ElementType() {
		return SimpleMultiplicities_Kw3Keyword_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Val4Assignment_7ElementType() {
		return SimpleMultiplicities_Val4Assignment_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleMultiplicities_Val4IDTerminalRuleCall_7_0ElementType() {
		return SimpleMultiplicities_Val4IDTerminalRuleCall_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicitiesElementType() {
		return GroupMultiplicities_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_GroupElementType() {
		return GroupMultiplicities_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_NumberSignDigitFourKeyword_0ElementType() {
		return GroupMultiplicities_NumberSignDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val1Assignment_1ElementType() {
		return GroupMultiplicities_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val1IDTerminalRuleCall_1_0ElementType() {
		return GroupMultiplicities_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Kw1Keyword_2ElementType() {
		return GroupMultiplicities_Kw1Keyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Group_3ElementType() {
		return GroupMultiplicities_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val2Assignment_3_0ElementType() {
		return GroupMultiplicities_Val2Assignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val2IDTerminalRuleCall_3_0_0ElementType() {
		return GroupMultiplicities_Val2IDTerminalRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val3Assignment_3_1ElementType() {
		return GroupMultiplicities_Val3Assignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val3IDTerminalRuleCall_3_1_0ElementType() {
		return GroupMultiplicities_Val3IDTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Kw2Keyword_4ElementType() {
		return GroupMultiplicities_Kw2Keyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Group_5ElementType() {
		return GroupMultiplicities_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val4Assignment_5_0ElementType() {
		return GroupMultiplicities_Val4Assignment_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val4IDTerminalRuleCall_5_0_0ElementType() {
		return GroupMultiplicities_Val4IDTerminalRuleCall_5_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val5Assignment_5_1ElementType() {
		return GroupMultiplicities_Val5Assignment_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val5IDTerminalRuleCall_5_1_0ElementType() {
		return GroupMultiplicities_Val5IDTerminalRuleCall_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Kw3Keyword_6ElementType() {
		return GroupMultiplicities_Kw3Keyword_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Group_7ElementType() {
		return GroupMultiplicities_Group_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val6Assignment_7_0ElementType() {
		return GroupMultiplicities_Val6Assignment_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val6IDTerminalRuleCall_7_0_0ElementType() {
		return GroupMultiplicities_Val6IDTerminalRuleCall_7_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val7Assignment_7_1ElementType() {
		return GroupMultiplicities_Val7Assignment_7_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupMultiplicities_Val7IDTerminalRuleCall_7_1_0ElementType() {
		return GroupMultiplicities_Val7IDTerminalRuleCall_7_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicitiesElementType() {
		return AlternativeMultiplicities_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_GroupElementType() {
		return AlternativeMultiplicities_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_NumberSignDigitFiveKeyword_0ElementType() {
		return AlternativeMultiplicities_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Alternatives_1ElementType() {
		return AlternativeMultiplicities_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val2Assignment_1_0ElementType() {
		return AlternativeMultiplicities_Val2Assignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0ElementType() {
		return AlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Group_1_1ElementType() {
		return AlternativeMultiplicities_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Kw1Keyword_1_1_0ElementType() {
		return AlternativeMultiplicities_Kw1Keyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val3Assignment_1_1_1ElementType() {
		return AlternativeMultiplicities_Val3Assignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0ElementType() {
		return AlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Kw2Keyword_2ElementType() {
		return AlternativeMultiplicities_Kw2Keyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Alternatives_3ElementType() {
		return AlternativeMultiplicities_Alternatives_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val4Assignment_3_0ElementType() {
		return AlternativeMultiplicities_Val4Assignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0ElementType() {
		return AlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Group_3_1ElementType() {
		return AlternativeMultiplicities_Group_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Kw3Keyword_3_1_0ElementType() {
		return AlternativeMultiplicities_Kw3Keyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val5Assignment_3_1_1ElementType() {
		return AlternativeMultiplicities_Val5Assignment_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0ElementType() {
		return AlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Kw4Keyword_4ElementType() {
		return AlternativeMultiplicities_Kw4Keyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Alternatives_5ElementType() {
		return AlternativeMultiplicities_Alternatives_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val6Assignment_5_0ElementType() {
		return AlternativeMultiplicities_Val6Assignment_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0ElementType() {
		return AlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Group_5_1ElementType() {
		return AlternativeMultiplicities_Group_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Kw5Keyword_5_1_0ElementType() {
		return AlternativeMultiplicities_Kw5Keyword_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val7Assignment_5_1_1ElementType() {
		return AlternativeMultiplicities_Val7Assignment_5_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0ElementType() {
		return AlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedActionElementType() {
		return AssignedAction_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedAction_GroupElementType() {
		return AssignedAction_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedAction_NumberSignDigitSixKeyword_0ElementType() {
		return AssignedAction_NumberSignDigitSixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedAction_Val1Assignment_1ElementType() {
		return AssignedAction_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedAction_Val1IDTerminalRuleCall_1_0ElementType() {
		return AssignedAction_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedAction_Group_2ElementType() {
		return AssignedAction_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedAction_AssignedActionChildAction_2_0ElementType() {
		return AssignedAction_AssignedActionChildAction_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedAction_Val1Assignment_2_1ElementType() {
		return AssignedAction_Val1Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedAction_Val1IDTerminalRuleCall_2_1_0ElementType() {
		return AssignedAction_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedActionSecondElementType() {
		return AssignedActionSecond_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedActionSecond_GroupElementType() {
		return AssignedActionSecond_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedActionSecond_NumberSignDigitSevenKeyword_0ElementType() {
		return AssignedActionSecond_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedActionSecond_Val1Assignment_1ElementType() {
		return AssignedActionSecond_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedActionSecond_Val1IDTerminalRuleCall_1_0ElementType() {
		return AssignedActionSecond_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedActionSecond_Kw1Keyword_2ElementType() {
		return AssignedActionSecond_Kw1Keyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedActionSecond_Val2Assignment_3ElementType() {
		return AssignedActionSecond_Val2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignedActionSecond_Val2IDTerminalRuleCall_3_0ElementType() {
		return AssignedActionSecond_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction1ElementType() {
		return UnassignedAction1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction1_GroupElementType() {
		return UnassignedAction1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction1_UnassignedAction1Action_0ElementType() {
		return UnassignedAction1_UnassignedAction1Action_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction1_NumberSignDigitEightKeyword_1ElementType() {
		return UnassignedAction1_NumberSignDigitEightKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction1_Val1Assignment_2ElementType() {
		return UnassignedAction1_Val1Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction1_Val1IDTerminalRuleCall_2_0ElementType() {
		return UnassignedAction1_Val1IDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction1_Val2Assignment_3ElementType() {
		return UnassignedAction1_Val2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction1_Val2IDTerminalRuleCall_3_0ElementType() {
		return UnassignedAction1_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction2ElementType() {
		return UnassignedAction2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction2_GroupElementType() {
		return UnassignedAction2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction2_UnassignedAction2SubAction_0ElementType() {
		return UnassignedAction2_UnassignedAction2SubAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction2_NumberSignDigitNineKeyword_1ElementType() {
		return UnassignedAction2_NumberSignDigitNineKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction2_Val1Assignment_2ElementType() {
		return UnassignedAction2_Val1Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction2_Val1IDTerminalRuleCall_2_0ElementType() {
		return UnassignedAction2_Val1IDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction2_Val2Assignment_3ElementType() {
		return UnassignedAction2_Val2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction2_Val2IDTerminalRuleCall_3_0ElementType() {
		return UnassignedAction2_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3ElementType() {
		return UnassignedAction3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_GroupElementType() {
		return UnassignedAction3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_NumberSignDigitOneDigitZeroKeyword_0ElementType() {
		return UnassignedAction3_NumberSignDigitOneDigitZeroKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_Alternatives_1ElementType() {
		return UnassignedAction3_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_Group_1_0ElementType() {
		return UnassignedAction3_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_Kw1Keyword_1_0_0ElementType() {
		return UnassignedAction3_Kw1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_UnassignedAction2Sub1Action_1_0_1ElementType() {
		return UnassignedAction3_UnassignedAction2Sub1Action_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_Group_1_1ElementType() {
		return UnassignedAction3_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_Kw2Keyword_1_1_0ElementType() {
		return UnassignedAction3_Kw2Keyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_UnassignedAction2Sub2Action_1_1_1ElementType() {
		return UnassignedAction3_UnassignedAction2Sub2Action_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_Val1Assignment_2ElementType() {
		return UnassignedAction3_Val1Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_Val1IDTerminalRuleCall_2_0ElementType() {
		return UnassignedAction3_Val1IDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_Val2Assignment_3ElementType() {
		return UnassignedAction3_Val2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction3_Val2IDTerminalRuleCall_3_0ElementType() {
		return UnassignedAction3_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall1ElementType() {
		return UnassignedRuleCall1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall1_GroupElementType() {
		return UnassignedRuleCall1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall1_NumberSignDigitOneDigitOneKeyword_0ElementType() {
		return UnassignedRuleCall1_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall1_UnassignedRuleCall1SubParserRuleCall_1ElementType() {
		return UnassignedRuleCall1_UnassignedRuleCall1SubParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall1_Val2Assignment_2ElementType() {
		return UnassignedRuleCall1_Val2Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall1_Val2IDTerminalRuleCall_2_0ElementType() {
		return UnassignedRuleCall1_Val2IDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall1SubElementType() {
		return UnassignedRuleCall1Sub_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall1Sub_Val1AssignmentElementType() {
		return UnassignedRuleCall1Sub_Val1Assignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall1Sub_Val1IDTerminalRuleCall_0ElementType() {
		return UnassignedRuleCall1Sub_Val1IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall2ElementType() {
		return UnassignedRuleCall2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall2_GroupElementType() {
		return UnassignedRuleCall2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall2_NumberSignDigitOneDigitTwoKeyword_0ElementType() {
		return UnassignedRuleCall2_NumberSignDigitOneDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall2_UnassignedRuleCall2SubParserRuleCall_1ElementType() {
		return UnassignedRuleCall2_UnassignedRuleCall2SubParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall2_Val2Assignment_2ElementType() {
		return UnassignedRuleCall2_Val2Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall2_Val2IDTerminalRuleCall_2_0ElementType() {
		return UnassignedRuleCall2_Val2IDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall2SubElementType() {
		return UnassignedRuleCall2Sub_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedRuleCall2Sub_UnassignedRuleCall2SubActionActionElementType() {
		return UnassignedRuleCall2Sub_UnassignedRuleCall2SubActionAction_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1ElementType() {
		return Combination1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_GroupElementType() {
		return Combination1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_NumberSignDigitOneDigitThreeKeyword_0ElementType() {
		return Combination1_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Val1Assignment_1ElementType() {
		return Combination1_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Val1IDTerminalRuleCall_1_0ElementType() {
		return Combination1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Group_2ElementType() {
		return Combination1_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Kw1Keyword_2_0ElementType() {
		return Combination1_Kw1Keyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Val2Assignment_2_1ElementType() {
		return Combination1_Val2Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Val2IDTerminalRuleCall_2_1_0ElementType() {
		return Combination1_Val2IDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Alternatives_2_2ElementType() {
		return Combination1_Alternatives_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Group_2_2_0ElementType() {
		return Combination1_Group_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Kw2Keyword_2_2_0_0ElementType() {
		return Combination1_Kw2Keyword_2_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Val3Assignment_2_2_0_1ElementType() {
		return Combination1_Val3Assignment_2_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Val3IDTerminalRuleCall_2_2_0_1_0ElementType() {
		return Combination1_Val3IDTerminalRuleCall_2_2_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Val4Assignment_2_2_1ElementType() {
		return Combination1_Val4Assignment_2_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination1_Val4IDTerminalRuleCall_2_2_1_0ElementType() {
		return Combination1_Val4IDTerminalRuleCall_2_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2ElementType() {
		return Combination2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_GroupElementType() {
		return Combination2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_NumberSignDigitOneDigitFourKeyword_0ElementType() {
		return Combination2_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Val1Assignment_1ElementType() {
		return Combination2_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Val1IDTerminalRuleCall_1_0ElementType() {
		return Combination2_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Alternatives_2ElementType() {
		return Combination2_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Group_2_0ElementType() {
		return Combination2_Group_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Kw1Keyword_2_0_0ElementType() {
		return Combination2_Kw1Keyword_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Val2Assignment_2_0_1ElementType() {
		return Combination2_Val2Assignment_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Val2IDTerminalRuleCall_2_0_1_0ElementType() {
		return Combination2_Val2IDTerminalRuleCall_2_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Group_2_1ElementType() {
		return Combination2_Group_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Val3Assignment_2_1_0ElementType() {
		return Combination2_Val3Assignment_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Val3IDTerminalRuleCall_2_1_0_0ElementType() {
		return Combination2_Val3IDTerminalRuleCall_2_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Val4Assignment_2_1_1ElementType() {
		return Combination2_Val4Assignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination2_Val4IDTerminalRuleCall_2_1_1_0ElementType() {
		return Combination2_Val4IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination3ElementType() {
		return Combination3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination3_GroupElementType() {
		return Combination3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination3_NumberSignDigitOneDigitFiveKeyword_0ElementType() {
		return Combination3_NumberSignDigitOneDigitFiveKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination3_Alternatives_1ElementType() {
		return Combination3_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination3_Val1Assignment_1_0ElementType() {
		return Combination3_Val1Assignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination3_Val1IDTerminalRuleCall_1_0_0ElementType() {
		return Combination3_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination3_Val2Assignment_1_1ElementType() {
		return Combination3_Val2Assignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination3_Val2INTTerminalRuleCall_1_1_0ElementType() {
		return Combination3_Val2INTTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination3_Val3Assignment_1_2ElementType() {
		return Combination3_Val3Assignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination3_Val3STRINGTerminalRuleCall_1_2_0ElementType() {
		return Combination3_Val3STRINGTerminalRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4ElementType() {
		return Combination4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4_GroupElementType() {
		return Combination4_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4_NumberSignDigitOneDigitSixKeyword_0ElementType() {
		return Combination4_NumberSignDigitOneDigitSixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4_Group_1ElementType() {
		return Combination4_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4_GroupKeyword_1_0ElementType() {
		return Combination4_GroupKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4_Val1Assignment_1_1ElementType() {
		return Combination4_Val1Assignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4_Val1IDTerminalRuleCall_1_1_0ElementType() {
		return Combination4_Val1IDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4_Val2Assignment_1_2ElementType() {
		return Combination4_Val2Assignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4_Val2IDTerminalRuleCall_1_2_0ElementType() {
		return Combination4_Val2IDTerminalRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4_Val3Assignment_1_3ElementType() {
		return Combination4_Val3Assignment_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCombination4_Val3IDTerminalRuleCall_1_3_0ElementType() {
		return Combination4_Val3IDTerminalRuleCall_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1ElementType() {
		return List1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1_GroupElementType() {
		return List1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1_NumberSignDigitOneDigitSevenKeyword_0ElementType() {
		return List1_NumberSignDigitOneDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1_Val1Assignment_1ElementType() {
		return List1_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1_Val1IDTerminalRuleCall_1_0ElementType() {
		return List1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1_Group_2ElementType() {
		return List1_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1_CommaKeyword_2_0ElementType() {
		return List1_CommaKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1_Val1Assignment_2_1ElementType() {
		return List1_Val1Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1_Val1IDTerminalRuleCall_2_1_0ElementType() {
		return List1_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2ElementType() {
		return List2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_GroupElementType() {
		return List2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_NumberSignDigitOneDigitEightKeyword_0ElementType() {
		return List2_NumberSignDigitOneDigitEightKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Group_1ElementType() {
		return List2_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Val1Assignment_1_0ElementType() {
		return List2_Val1Assignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Val1IDTerminalRuleCall_1_0_0ElementType() {
		return List2_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Group_1_1ElementType() {
		return List2_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_CommaKeyword_1_1_0ElementType() {
		return List2_CommaKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Val1Assignment_1_1_1ElementType() {
		return List2_Val1Assignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Val1IDTerminalRuleCall_1_1_1_0ElementType() {
		return List2_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3ElementType() {
		return List3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_AlternativesElementType() {
		return List3_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Group_0ElementType() {
		return List3_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_NumberSignDigitOneDigitNineKeyword_0_0ElementType() {
		return List3_NumberSignDigitOneDigitNineKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Group_0_1ElementType() {
		return List3_Group_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Val1Assignment_0_1_0ElementType() {
		return List3_Val1Assignment_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Val1IDTerminalRuleCall_0_1_0_0ElementType() {
		return List3_Val1IDTerminalRuleCall_0_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Group_0_1_1ElementType() {
		return List3_Group_0_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_CommaKeyword_0_1_1_0ElementType() {
		return List3_CommaKeyword_0_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Val1Assignment_0_1_1_1ElementType() {
		return List3_Val1Assignment_0_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Val1IDTerminalRuleCall_0_1_1_1_0ElementType() {
		return List3_Val1IDTerminalRuleCall_0_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Group_1ElementType() {
		return List3_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Kw3Keyword_1_0ElementType() {
		return List3_Kw3Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Val2Assignment_1_1ElementType() {
		return List3_Val2Assignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList3_Val2IDTerminalRuleCall_1_1_0ElementType() {
		return List3_Val2IDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4ElementType() {
		return List4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_GroupElementType() {
		return List4_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_NumberSignDigitTwoDigitZeroKeyword_0ElementType() {
		return List4_NumberSignDigitTwoDigitZeroKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_Val1Assignment_1ElementType() {
		return List4_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_Val1IDTerminalRuleCall_1_0ElementType() {
		return List4_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_Group_2ElementType() {
		return List4_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_CommaKeyword_2_0ElementType() {
		return List4_CommaKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_Val1Assignment_2_1ElementType() {
		return List4_Val1Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_Val1IDTerminalRuleCall_2_1_0ElementType() {
		return List4_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_Kw3Keyword_3ElementType() {
		return List4_Kw3Keyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_Val2Assignment_4ElementType() {
		return List4_Val2Assignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList4_Val2IDTerminalRuleCall_4_0ElementType() {
		return List4_Val2IDTerminalRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5ElementType() {
		return List5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_GroupElementType() {
		return List5_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_NumberSignDigitTwoDigitOneKeyword_0ElementType() {
		return List5_NumberSignDigitTwoDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Alternatives_1ElementType() {
		return List5_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Group_1_0ElementType() {
		return List5_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Val1Assignment_1_0_0ElementType() {
		return List5_Val1Assignment_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Val1IDTerminalRuleCall_1_0_0_0ElementType() {
		return List5_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Group_1_0_1ElementType() {
		return List5_Group_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_CommaKeyword_1_0_1_0ElementType() {
		return List5_CommaKeyword_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Val1Assignment_1_0_1_1ElementType() {
		return List5_Val1Assignment_1_0_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Val1IDTerminalRuleCall_1_0_1_1_0ElementType() {
		return List5_Val1IDTerminalRuleCall_1_0_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Kw3Keyword_1_0_2ElementType() {
		return List5_Kw3Keyword_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Val2Assignment_1_0_3ElementType() {
		return List5_Val2Assignment_1_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Val2IDTerminalRuleCall_1_0_3_0ElementType() {
		return List5_Val2IDTerminalRuleCall_1_0_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Val3Assignment_1_1ElementType() {
		return List5_Val3Assignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList5_Val3IDTerminalRuleCall_1_1_0ElementType() {
		return List5_Val3IDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1ElementType() {
		return AltList1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_GroupElementType() {
		return AltList1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_NumberSignDigitTwoDigitTwoKeyword_0ElementType() {
		return AltList1_NumberSignDigitTwoDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Alternatives_1ElementType() {
		return AltList1_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Group_1_0ElementType() {
		return AltList1_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val1Assignment_1_0_0ElementType() {
		return AltList1_Val1Assignment_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val1IDTerminalRuleCall_1_0_0_0ElementType() {
		return AltList1_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val2Assignment_1_0_1ElementType() {
		return AltList1_Val2Assignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val2IDTerminalRuleCall_1_0_1_0ElementType() {
		return AltList1_Val2IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Group_1_1ElementType() {
		return AltList1_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Kw1Keyword_1_1_0ElementType() {
		return AltList1_Kw1Keyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val1Assignment_1_1_1ElementType() {
		return AltList1_Val1Assignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val1IDTerminalRuleCall_1_1_1_0ElementType() {
		return AltList1_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val3Assignment_1_1_2ElementType() {
		return AltList1_Val3Assignment_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val3IDTerminalRuleCall_1_1_2_0ElementType() {
		return AltList1_Val3IDTerminalRuleCall_1_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Group_1_2ElementType() {
		return AltList1_Group_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Kw2Keyword_1_2_0ElementType() {
		return AltList1_Kw2Keyword_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val1Assignment_1_2_1ElementType() {
		return AltList1_Val1Assignment_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val1IDTerminalRuleCall_1_2_1_0ElementType() {
		return AltList1_Val1IDTerminalRuleCall_1_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val4Assignment_1_2_2ElementType() {
		return AltList1_Val4Assignment_1_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_Val4IDTerminalRuleCall_1_2_2_0ElementType() {
		return AltList1_Val4IDTerminalRuleCall_1_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2ElementType() {
		return AltList2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_GroupElementType() {
		return AltList2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_NumberSignDigitTwoDigitThreeKeyword_0ElementType() {
		return AltList2_NumberSignDigitTwoDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Alternatives_1ElementType() {
		return AltList2_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Group_1_0ElementType() {
		return AltList2_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Val1Assignment_1_0_0ElementType() {
		return AltList2_Val1Assignment_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Val1IDTerminalRuleCall_1_0_0_0ElementType() {
		return AltList2_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Val2Assignment_1_0_1ElementType() {
		return AltList2_Val2Assignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Val2IDTerminalRuleCall_1_0_1_0ElementType() {
		return AltList2_Val2IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Group_1_1ElementType() {
		return AltList2_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_KwKeyword_1_1_0ElementType() {
		return AltList2_KwKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Val1Assignment_1_1_1ElementType() {
		return AltList2_Val1Assignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Val1IDTerminalRuleCall_1_1_1_0ElementType() {
		return AltList2_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Group_1_1_2ElementType() {
		return AltList2_Group_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_CommaKeyword_1_1_2_0ElementType() {
		return AltList2_CommaKeyword_1_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Val1Assignment_1_1_2_1ElementType() {
		return AltList2_Val1Assignment_1_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Val1IDTerminalRuleCall_1_1_2_1_0ElementType() {
		return AltList2_Val1IDTerminalRuleCall_1_1_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Val3Assignment_1_1_3ElementType() {
		return AltList2_Val3Assignment_1_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList2_Val3IDTerminalRuleCall_1_1_3_0ElementType() {
		return AltList2_Val3IDTerminalRuleCall_1_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObjectElementType() {
		return TransientObject_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObject_GroupElementType() {
		return TransientObject_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObject_NumberSignDigitTwoDigitFourKeyword_0ElementType() {
		return TransientObject_NumberSignDigitTwoDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObject_Group_1ElementType() {
		return TransientObject_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObject_Val1Assignment_1_0ElementType() {
		return TransientObject_Val1Assignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObject_Val1IDTerminalRuleCall_1_0_0ElementType() {
		return TransientObject_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObject_NestedAssignment_1_1ElementType() {
		return TransientObject_NestedAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObject_NestedTransientObjectSubParserRuleCall_1_1_0ElementType() {
		return TransientObject_NestedTransientObjectSubParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObjectSubElementType() {
		return TransientObjectSub_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObjectSub_GroupElementType() {
		return TransientObjectSub_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObjectSub_Val2Assignment_0ElementType() {
		return TransientObjectSub_Val2Assignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObjectSub_Val2IDTerminalRuleCall_0_0ElementType() {
		return TransientObjectSub_Val2IDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObjectSub_Val3Assignment_1ElementType() {
		return TransientObjectSub_Val3Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientObjectSub_Val3IDTerminalRuleCall_1_0ElementType() {
		return TransientObjectSub_Val3IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1ElementType() {
		return TransientSerializeables1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_GroupElementType() {
		return TransientSerializeables1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_NumberSignDigitTwoDigitFiveKeyword_0ElementType() {
		return TransientSerializeables1_NumberSignDigitTwoDigitFiveKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_Group_1ElementType() {
		return TransientSerializeables1_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_Val1Assignment_1_0ElementType() {
		return TransientSerializeables1_Val1Assignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_Val1IDTerminalRuleCall_1_0_0ElementType() {
		return TransientSerializeables1_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_Enum1Assignment_1_1ElementType() {
		return TransientSerializeables1_Enum1Assignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_Enum1TransientSerializeables1EnumEnumRuleCall_1_1_0ElementType() {
		return TransientSerializeables1_Enum1TransientSerializeables1EnumEnumRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_Group_2ElementType() {
		return TransientSerializeables1_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_Val2Assignment_2_0ElementType() {
		return TransientSerializeables1_Val2Assignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_Val2IDTerminalRuleCall_2_0_0ElementType() {
		return TransientSerializeables1_Val2IDTerminalRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_Int1Assignment_2_1ElementType() {
		return TransientSerializeables1_Int1Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1_Int1INTTerminalRuleCall_2_1_0ElementType() {
		return TransientSerializeables1_Int1INTTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1EnumElementType() {
		return TransientSerializeables1Enum_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1Enum_AlternativesElementType() {
		return TransientSerializeables1Enum_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1Enum_Lit1EnumLiteralDeclaration_0ElementType() {
		return TransientSerializeables1Enum_Lit1EnumLiteralDeclaration_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1Enum_Lit1Lit1Keyword_0_0ElementType() {
		return TransientSerializeables1Enum_Lit1Lit1Keyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1Enum_Lit2EnumLiteralDeclaration_1ElementType() {
		return TransientSerializeables1Enum_Lit2EnumLiteralDeclaration_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransientSerializeables1Enum_Lit2Lit2Keyword_1_0ElementType() {
		return TransientSerializeables1Enum_Lit2Lit2Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplificationElementType() {
		return StaticSimplification_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_GroupElementType() {
		return StaticSimplification_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_NumberSignDigitTwoDigitSixKeyword_0ElementType() {
		return StaticSimplification_NumberSignDigitTwoDigitSixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Alternatives_1ElementType() {
		return StaticSimplification_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Kw1Keyword_1_0ElementType() {
		return StaticSimplification_Kw1Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_EmptyAlternativeSubAction_1_1ElementType() {
		return StaticSimplification_EmptyAlternativeSubAction_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Val1Assignment_1_2ElementType() {
		return StaticSimplification_Val1Assignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Val1IDTerminalRuleCall_1_2_0ElementType() {
		return StaticSimplification_Val1IDTerminalRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Alternatives_2ElementType() {
		return StaticSimplification_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Kw2Keyword_2_0ElementType() {
		return StaticSimplification_Kw2Keyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Val2Assignment_2_1ElementType() {
		return StaticSimplification_Val2Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Val2IDTerminalRuleCall_2_1_0ElementType() {
		return StaticSimplification_Val2IDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Group_3ElementType() {
		return StaticSimplification_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Kw3Keyword_3_0ElementType() {
		return StaticSimplification_Kw3Keyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Group_3_1ElementType() {
		return StaticSimplification_Group_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Kw4Keyword_3_1_0ElementType() {
		return StaticSimplification_Kw4Keyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Val3Assignment_3_1_1ElementType() {
		return StaticSimplification_Val3Assignment_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStaticSimplification_Val3IDTerminalRuleCall_3_1_1_0ElementType() {
		return StaticSimplification_Val3IDTerminalRuleCall_3_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionElementType() {
		return TwoVersion_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersion_GroupElementType() {
		return TwoVersion_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersion_NumberSignDigitTwoDigitSevenKeyword_0ElementType() {
		return TwoVersion_NumberSignDigitTwoDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersion_Alternatives_1ElementType() {
		return TwoVersion_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersion_TwoVersionNo1ParserRuleCall_1_0ElementType() {
		return TwoVersion_TwoVersionNo1ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersion_TwoVersionNo2ParserRuleCall_1_1ElementType() {
		return TwoVersion_TwoVersionNo2ParserRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1ElementType() {
		return TwoVersionNo1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_GroupElementType() {
		return TwoVersionNo1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Shared1Assignment_0ElementType() {
		return TwoVersionNo1_Shared1Assignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Shared1IDTerminalRuleCall_0_0ElementType() {
		return TwoVersionNo1_Shared1IDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Shared2Assignment_1ElementType() {
		return TwoVersionNo1_Shared2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Shared2IDTerminalRuleCall_1_0ElementType() {
		return TwoVersionNo1_Shared2IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_ShortKeyword_2ElementType() {
		return TwoVersionNo1_ShortKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Group_3ElementType() {
		return TwoVersionNo1_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Shared3Assignment_3_0ElementType() {
		return TwoVersionNo1_Shared3Assignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Shared3IDTerminalRuleCall_3_0_0ElementType() {
		return TwoVersionNo1_Shared3IDTerminalRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Shared3Assignment_3_1ElementType() {
		return TwoVersionNo1_Shared3Assignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Shared3IDTerminalRuleCall_3_1_0ElementType() {
		return TwoVersionNo1_Shared3IDTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_OneKeyword_4ElementType() {
		return TwoVersionNo1_OneKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Version1Assignment_5ElementType() {
		return TwoVersionNo1_Version1Assignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo1_Version1IDTerminalRuleCall_5_0ElementType() {
		return TwoVersionNo1_Version1IDTerminalRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2ElementType() {
		return TwoVersionNo2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_GroupElementType() {
		return TwoVersionNo2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Shared1Assignment_0ElementType() {
		return TwoVersionNo2_Shared1Assignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Shared1IDTerminalRuleCall_0_0ElementType() {
		return TwoVersionNo2_Shared1IDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Shared2Assignment_1ElementType() {
		return TwoVersionNo2_Shared2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Shared2IDTerminalRuleCall_1_0ElementType() {
		return TwoVersionNo2_Shared2IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_LongKeyword_2ElementType() {
		return TwoVersionNo2_LongKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Group_3ElementType() {
		return TwoVersionNo2_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Shared3Assignment_3_0ElementType() {
		return TwoVersionNo2_Shared3Assignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Shared3IDTerminalRuleCall_3_0_0ElementType() {
		return TwoVersionNo2_Shared3IDTerminalRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Shared3Assignment_3_1ElementType() {
		return TwoVersionNo2_Shared3Assignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Shared3IDTerminalRuleCall_3_1_0ElementType() {
		return TwoVersionNo2_Shared3IDTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_ExtraKeyword_4ElementType() {
		return TwoVersionNo2_ExtraKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Extra1Assignment_5ElementType() {
		return TwoVersionNo2_Extra1Assignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Extra1IDTerminalRuleCall_5_0ElementType() {
		return TwoVersionNo2_Extra1IDTerminalRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Alternatives_6ElementType() {
		return TwoVersionNo2_Alternatives_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Group_6_0ElementType() {
		return TwoVersionNo2_Group_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Extra2Assignment_6_0_0ElementType() {
		return TwoVersionNo2_Extra2Assignment_6_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Extra2IDTerminalRuleCall_6_0_0_0ElementType() {
		return TwoVersionNo2_Extra2IDTerminalRuleCall_6_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Extra3Assignment_6_0_1ElementType() {
		return TwoVersionNo2_Extra3Assignment_6_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Extra3IDTerminalRuleCall_6_0_1_0ElementType() {
		return TwoVersionNo2_Extra3IDTerminalRuleCall_6_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Group_6_1ElementType() {
		return TwoVersionNo2_Group_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_TwoKeyword_6_1_0ElementType() {
		return TwoVersionNo2_TwoKeyword_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Extra4Assignment_6_1_1ElementType() {
		return TwoVersionNo2_Extra4Assignment_6_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoVersionNo2_Extra4IDTerminalRuleCall_6_1_1_0ElementType() {
		return TwoVersionNo2_Extra4IDTerminalRuleCall_6_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1ElementType() {
		return Heuristic1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_GroupElementType() {
		return Heuristic1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_NumberSignDigitTwoDigitEightKeyword_0ElementType() {
		return Heuristic1_NumberSignDigitTwoDigitEightKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_Group_1ElementType() {
		return Heuristic1_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_Kw1Keyword_1_0ElementType() {
		return Heuristic1_Kw1Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_AAssignment_1_1ElementType() {
		return Heuristic1_AAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_AIDTerminalRuleCall_1_1_0ElementType() {
		return Heuristic1_AIDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_BAssignment_1_2ElementType() {
		return Heuristic1_BAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_BIDTerminalRuleCall_1_2_0ElementType() {
		return Heuristic1_BIDTerminalRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_Group_2ElementType() {
		return Heuristic1_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_Kw2Keyword_2_0ElementType() {
		return Heuristic1_Kw2Keyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_AAssignment_2_1ElementType() {
		return Heuristic1_AAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_AIDTerminalRuleCall_2_1_0ElementType() {
		return Heuristic1_AIDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_CAssignment_2_2ElementType() {
		return Heuristic1_CAssignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_CIDTerminalRuleCall_2_2_0ElementType() {
		return Heuristic1_CIDTerminalRuleCall_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_Group_3ElementType() {
		return Heuristic1_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_Kw3Keyword_3_0ElementType() {
		return Heuristic1_Kw3Keyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_BAssignment_3_1ElementType() {
		return Heuristic1_BAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_BIDTerminalRuleCall_3_1_0ElementType() {
		return Heuristic1_BIDTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_CAssignment_3_2ElementType() {
		return Heuristic1_CAssignment_3_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHeuristic1_CIDTerminalRuleCall_3_2_0ElementType() {
		return Heuristic1_CIDTerminalRuleCall_3_2_0_ELEMENT_TYPE;
	}

}
