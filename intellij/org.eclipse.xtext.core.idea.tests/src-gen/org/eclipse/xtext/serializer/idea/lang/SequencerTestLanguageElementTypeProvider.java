package org.eclipse.xtext.serializer.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.serializer.idea.lang.psi.impl.SequencerTestLanguageFileImpl;
import org.eclipse.xtext.serializer.services.SequencerTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class SequencerTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<SequencerTestLanguageFileImpl>>(SequencerTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final SequencerTestLanguageGrammarAccess GRAMMAR_ACCESS = SequencerTestLanguageLanguage.INSTANCE.getInstance(SequencerTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_X1Assignment_0ElementType() {
			return new IGrammarAwareElementType("Model_X1Assignment_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX1Assignment_0());
		}
		public static IGrammarAwareElementType createModel_X1SimpleGroupParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_X1SimpleGroupParserRuleCall_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX1SimpleGroupParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_X2Assignment_1ElementType() {
			return new IGrammarAwareElementType("Model_X2Assignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX2Assignment_1());
		}
		public static IGrammarAwareElementType createModel_X2SimpleAlternativeParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_X2SimpleAlternativeParserRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX2SimpleAlternativeParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModel_X3Assignment_2ElementType() {
			return new IGrammarAwareElementType("Model_X3Assignment_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX3Assignment_2());
		}
		public static IGrammarAwareElementType createModel_X3SimpleMultiplicitiesParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Model_X3SimpleMultiplicitiesParserRuleCall_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX3SimpleMultiplicitiesParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createModel_X4Assignment_3ElementType() {
			return new IGrammarAwareElementType("Model_X4Assignment_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX4Assignment_3());
		}
		public static IGrammarAwareElementType createModel_X4GroupMultiplicitiesParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Model_X4GroupMultiplicitiesParserRuleCall_3_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX4GroupMultiplicitiesParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createModel_X5Assignment_4ElementType() {
			return new IGrammarAwareElementType("Model_X5Assignment_4_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX5Assignment_4());
		}
		public static IGrammarAwareElementType createModel_X5AlternativeMultiplicitiesParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Model_X5AlternativeMultiplicitiesParserRuleCall_4_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX5AlternativeMultiplicitiesParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createModel_X6Assignment_5ElementType() {
			return new IGrammarAwareElementType("Model_X6Assignment_5_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX6Assignment_5());
		}
		public static IGrammarAwareElementType createModel_X6List1ParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("Model_X6List1ParserRuleCall_5_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX6List1ParserRuleCall_5_0());
		}
		public static IGrammarAwareElementType createModel_X7Assignment_6ElementType() {
			return new IGrammarAwareElementType("Model_X7Assignment_6_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX7Assignment_6());
		}
		public static IGrammarAwareElementType createModel_X7List2ParserRuleCall_6_0ElementType() {
			return new IGrammarAwareElementType("Model_X7List2ParserRuleCall_6_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX7List2ParserRuleCall_6_0());
		}
		public static IGrammarAwareElementType createModel_X8Assignment_7ElementType() {
			return new IGrammarAwareElementType("Model_X8Assignment_7_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX8Assignment_7());
		}
		public static IGrammarAwareElementType createModel_X8AltList1ParserRuleCall_7_0ElementType() {
			return new IGrammarAwareElementType("Model_X8AltList1ParserRuleCall_7_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX8AltList1ParserRuleCall_7_0());
		}
		public static IGrammarAwareElementType createModel_X9Assignment_8ElementType() {
			return new IGrammarAwareElementType("Model_X9Assignment_8_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX9Assignment_8());
		}
		public static IGrammarAwareElementType createModel_X9AltList2ParserRuleCall_8_0ElementType() {
			return new IGrammarAwareElementType("Model_X9AltList2ParserRuleCall_8_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX9AltList2ParserRuleCall_8_0());
		}
		public static IGrammarAwareElementType createModel_X10Assignment_9ElementType() {
			return new IGrammarAwareElementType("Model_X10Assignment_9_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX10Assignment_9());
		}
		public static IGrammarAwareElementType createModel_X10SingleKeywordsParserRuleCall_9_0ElementType() {
			return new IGrammarAwareElementType("Model_X10SingleKeywordsParserRuleCall_9_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX10SingleKeywordsParserRuleCall_9_0());
		}
		public static IGrammarAwareElementType createModel_X11Assignment_10ElementType() {
			return new IGrammarAwareElementType("Model_X11Assignment_10_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX11Assignment_10());
		}
		public static IGrammarAwareElementType createModel_X11SingleKeywordsOrIDParserRuleCall_10_0ElementType() {
			return new IGrammarAwareElementType("Model_X11SingleKeywordsOrIDParserRuleCall_10_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX11SingleKeywordsOrIDParserRuleCall_10_0());
		}
		public static IGrammarAwareElementType createModel_X12Assignment_11ElementType() {
			return new IGrammarAwareElementType("Model_X12Assignment_11_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX12Assignment_11());
		}
		public static IGrammarAwareElementType createModel_X12SingleTerminalsParserRuleCall_11_0ElementType() {
			return new IGrammarAwareElementType("Model_X12SingleTerminalsParserRuleCall_11_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX12SingleTerminalsParserRuleCall_11_0());
		}
		public static IGrammarAwareElementType createModel_X10Assignment_12ElementType() {
			return new IGrammarAwareElementType("Model_X10Assignment_12_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX10Assignment_12());
		}
		public static IGrammarAwareElementType createModel_X10MultiKeywordsParserRuleCall_12_0ElementType() {
			return new IGrammarAwareElementType("Model_X10MultiKeywordsParserRuleCall_12_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX10MultiKeywordsParserRuleCall_12_0());
		}
		public static IGrammarAwareElementType createModel_X11Assignment_13ElementType() {
			return new IGrammarAwareElementType("Model_X11Assignment_13_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX11Assignment_13());
		}
		public static IGrammarAwareElementType createModel_X11MultiKeywordsOrIDParserRuleCall_13_0ElementType() {
			return new IGrammarAwareElementType("Model_X11MultiKeywordsOrIDParserRuleCall_13_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX11MultiKeywordsOrIDParserRuleCall_13_0());
		}
		public static IGrammarAwareElementType createModel_X12Assignment_14ElementType() {
			return new IGrammarAwareElementType("Model_X12Assignment_14_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX12Assignment_14());
		}
		public static IGrammarAwareElementType createModel_X12MultiTerminalsParserRuleCall_14_0ElementType() {
			return new IGrammarAwareElementType("Model_X12MultiTerminalsParserRuleCall_14_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX12MultiTerminalsParserRuleCall_14_0());
		}
		public static IGrammarAwareElementType createModel_X13Assignment_15ElementType() {
			return new IGrammarAwareElementType("Model_X13Assignment_15_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX13Assignment_15());
		}
		public static IGrammarAwareElementType createModel_X13SingleEnumParserRuleCall_15_0ElementType() {
			return new IGrammarAwareElementType("Model_X13SingleEnumParserRuleCall_15_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX13SingleEnumParserRuleCall_15_0());
		}
		public static IGrammarAwareElementType createModel_X14Assignment_16ElementType() {
			return new IGrammarAwareElementType("Model_X14Assignment_16_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX14Assignment_16());
		}
		public static IGrammarAwareElementType createModel_X14SingleCrossReferenceParserRuleCall_16_0ElementType() {
			return new IGrammarAwareElementType("Model_X14SingleCrossReferenceParserRuleCall_16_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX14SingleCrossReferenceParserRuleCall_16_0());
		}
		public static IGrammarAwareElementType createModel_X15Assignment_17ElementType() {
			return new IGrammarAwareElementType("Model_X15Assignment_17_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX15Assignment_17());
		}
		public static IGrammarAwareElementType createModel_X15SingleContainmentReferenceParserRuleCall_17_0ElementType() {
			return new IGrammarAwareElementType("Model_X15SingleContainmentReferenceParserRuleCall_17_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX15SingleContainmentReferenceParserRuleCall_17_0());
		}
		public static IGrammarAwareElementType createModel_X19Assignment_18ElementType() {
			return new IGrammarAwareElementType("Model_X19Assignment_18_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX19Assignment_18());
		}
		public static IGrammarAwareElementType createModel_X19DependentAlternative1ParserRuleCall_18_0ElementType() {
			return new IGrammarAwareElementType("Model_X19DependentAlternative1ParserRuleCall_18_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX19DependentAlternative1ParserRuleCall_18_0());
		}
		public static IGrammarAwareElementType createModel_X20Assignment_19ElementType() {
			return new IGrammarAwareElementType("Model_X20Assignment_19_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX20Assignment_19());
		}
		public static IGrammarAwareElementType createModel_X20DependentAlternative2ParserRuleCall_19_0ElementType() {
			return new IGrammarAwareElementType("Model_X20DependentAlternative2ParserRuleCall_19_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX20DependentAlternative2ParserRuleCall_19_0());
		}
		public static IGrammarAwareElementType createModel_X21Assignment_20ElementType() {
			return new IGrammarAwareElementType("Model_X21Assignment_20_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX21Assignment_20());
		}
		public static IGrammarAwareElementType createModel_X21OptionalParserRuleCall_20_0ElementType() {
			return new IGrammarAwareElementType("Model_X21OptionalParserRuleCall_20_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX21OptionalParserRuleCall_20_0());
		}
		public static IGrammarAwareElementType createModel_X22Assignment_21ElementType() {
			return new IGrammarAwareElementType("Model_X22Assignment_21_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX22Assignment_21());
		}
		public static IGrammarAwareElementType createModel_X22FloatParserRuleCall_21_0ElementType() {
			return new IGrammarAwareElementType("Model_X22FloatParserRuleCall_21_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX22FloatParserRuleCall_21_0());
		}
		public static IGrammarAwareElementType createModel_X23Assignment_22ElementType() {
			return new IGrammarAwareElementType("Model_X23Assignment_22_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX23Assignment_22());
		}
		public static IGrammarAwareElementType createModel_X23UnorderedAlternativeParserRuleCall_22_0ElementType() {
			return new IGrammarAwareElementType("Model_X23UnorderedAlternativeParserRuleCall_22_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX23UnorderedAlternativeParserRuleCall_22_0());
		}
		public static IGrammarAwareElementType createModel_X24Assignment_23ElementType() {
			return new IGrammarAwareElementType("Model_X24Assignment_23_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX24Assignment_23());
		}
		public static IGrammarAwareElementType createModel_X24UnorderedGroupParserRuleCall_23_0ElementType() {
			return new IGrammarAwareElementType("Model_X24UnorderedGroupParserRuleCall_23_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX24UnorderedGroupParserRuleCall_23_0());
		}
		public static IGrammarAwareElementType createModel_X25Assignment_24ElementType() {
			return new IGrammarAwareElementType("Model_X25Assignment_24_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX25Assignment_24());
		}
		public static IGrammarAwareElementType createModel_X25UnorderedGroupOptionalParserRuleCall_24_0ElementType() {
			return new IGrammarAwareElementType("Model_X25UnorderedGroupOptionalParserRuleCall_24_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX25UnorderedGroupOptionalParserRuleCall_24_0());
		}
		public static IGrammarAwareElementType createModel_X26Assignment_25ElementType() {
			return new IGrammarAwareElementType("Model_X26Assignment_25_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX26Assignment_25());
		}
		public static IGrammarAwareElementType createModel_X26UnorderedGroupBooleanParserRuleCall_25_0ElementType() {
			return new IGrammarAwareElementType("Model_X26UnorderedGroupBooleanParserRuleCall_25_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX26UnorderedGroupBooleanParserRuleCall_25_0());
		}
		public static IGrammarAwareElementType createModel_X27Assignment_26ElementType() {
			return new IGrammarAwareElementType("Model_X27Assignment_26_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX27Assignment_26());
		}
		public static IGrammarAwareElementType createModel_X27Complex1ParserRuleCall_26_0ElementType() {
			return new IGrammarAwareElementType("Model_X27Complex1ParserRuleCall_26_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX27Complex1ParserRuleCall_26_0());
		}
		public static IGrammarAwareElementType createModel_X28Assignment_27ElementType() {
			return new IGrammarAwareElementType("Model_X28Assignment_27_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX28Assignment_27());
		}
		public static IGrammarAwareElementType createModel_X28OptionalDoubleParserRuleCall_27_0ElementType() {
			return new IGrammarAwareElementType("Model_X28OptionalDoubleParserRuleCall_27_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX28OptionalDoubleParserRuleCall_27_0());
		}
		public static IGrammarAwareElementType createModel_X29Assignment_28ElementType() {
			return new IGrammarAwareElementType("Model_X29Assignment_28_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX29Assignment_28());
		}
		public static IGrammarAwareElementType createModel_X29NullValueGeneratedParserRuleCall_28_0ElementType() {
			return new IGrammarAwareElementType("Model_X29NullValueGeneratedParserRuleCall_28_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX29NullValueGeneratedParserRuleCall_28_0());
		}
		public static IGrammarAwareElementType createModel_X30Assignment_29ElementType() {
			return new IGrammarAwareElementType("Model_X30Assignment_29_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX30Assignment_29());
		}
		public static IGrammarAwareElementType createModel_X30NullValueInterpretedParserRuleCall_29_0ElementType() {
			return new IGrammarAwareElementType("Model_X30NullValueInterpretedParserRuleCall_29_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX30NullValueInterpretedParserRuleCall_29_0());
		}
		public static IGrammarAwareElementType createModel_X31Assignment_30ElementType() {
			return new IGrammarAwareElementType("Model_X31Assignment_30_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX31Assignment_30());
		}
		public static IGrammarAwareElementType createModel_X31NullCrossRefGeneratedParserRuleCall_30_0ElementType() {
			return new IGrammarAwareElementType("Model_X31NullCrossRefGeneratedParserRuleCall_30_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX31NullCrossRefGeneratedParserRuleCall_30_0());
		}
		public static IGrammarAwareElementType createModel_X32Assignment_31ElementType() {
			return new IGrammarAwareElementType("Model_X32Assignment_31_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX32Assignment_31());
		}
		public static IGrammarAwareElementType createModel_X32NullCrossRefInterpretedParserRuleCall_31_0ElementType() {
			return new IGrammarAwareElementType("Model_X32NullCrossRefInterpretedParserRuleCall_31_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getX32NullCrossRefInterpretedParserRuleCall_31_0());
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

	public static final IGrammarAwareElementType Model_X6List1ParserRuleCall_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X6List1ParserRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType Model_X7Assignment_6_ELEMENT_TYPE = associate(ModelFactory.createModel_X7Assignment_6ElementType());

	public static final IGrammarAwareElementType Model_X7List2ParserRuleCall_6_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X7List2ParserRuleCall_6_0ElementType());

	public static final IGrammarAwareElementType Model_X8Assignment_7_ELEMENT_TYPE = associate(ModelFactory.createModel_X8Assignment_7ElementType());

	public static final IGrammarAwareElementType Model_X8AltList1ParserRuleCall_7_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X8AltList1ParserRuleCall_7_0ElementType());

	public static final IGrammarAwareElementType Model_X9Assignment_8_ELEMENT_TYPE = associate(ModelFactory.createModel_X9Assignment_8ElementType());

	public static final IGrammarAwareElementType Model_X9AltList2ParserRuleCall_8_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X9AltList2ParserRuleCall_8_0ElementType());

	public static final IGrammarAwareElementType Model_X10Assignment_9_ELEMENT_TYPE = associate(ModelFactory.createModel_X10Assignment_9ElementType());

	public static final IGrammarAwareElementType Model_X10SingleKeywordsParserRuleCall_9_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X10SingleKeywordsParserRuleCall_9_0ElementType());

	public static final IGrammarAwareElementType Model_X11Assignment_10_ELEMENT_TYPE = associate(ModelFactory.createModel_X11Assignment_10ElementType());

	public static final IGrammarAwareElementType Model_X11SingleKeywordsOrIDParserRuleCall_10_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X11SingleKeywordsOrIDParserRuleCall_10_0ElementType());

	public static final IGrammarAwareElementType Model_X12Assignment_11_ELEMENT_TYPE = associate(ModelFactory.createModel_X12Assignment_11ElementType());

	public static final IGrammarAwareElementType Model_X12SingleTerminalsParserRuleCall_11_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X12SingleTerminalsParserRuleCall_11_0ElementType());

	public static final IGrammarAwareElementType Model_X10Assignment_12_ELEMENT_TYPE = associate(ModelFactory.createModel_X10Assignment_12ElementType());

	public static final IGrammarAwareElementType Model_X10MultiKeywordsParserRuleCall_12_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X10MultiKeywordsParserRuleCall_12_0ElementType());

	public static final IGrammarAwareElementType Model_X11Assignment_13_ELEMENT_TYPE = associate(ModelFactory.createModel_X11Assignment_13ElementType());

	public static final IGrammarAwareElementType Model_X11MultiKeywordsOrIDParserRuleCall_13_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X11MultiKeywordsOrIDParserRuleCall_13_0ElementType());

	public static final IGrammarAwareElementType Model_X12Assignment_14_ELEMENT_TYPE = associate(ModelFactory.createModel_X12Assignment_14ElementType());

	public static final IGrammarAwareElementType Model_X12MultiTerminalsParserRuleCall_14_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X12MultiTerminalsParserRuleCall_14_0ElementType());

	public static final IGrammarAwareElementType Model_X13Assignment_15_ELEMENT_TYPE = associate(ModelFactory.createModel_X13Assignment_15ElementType());

	public static final IGrammarAwareElementType Model_X13SingleEnumParserRuleCall_15_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X13SingleEnumParserRuleCall_15_0ElementType());

	public static final IGrammarAwareElementType Model_X14Assignment_16_ELEMENT_TYPE = associate(ModelFactory.createModel_X14Assignment_16ElementType());

	public static final IGrammarAwareElementType Model_X14SingleCrossReferenceParserRuleCall_16_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X14SingleCrossReferenceParserRuleCall_16_0ElementType());

	public static final IGrammarAwareElementType Model_X15Assignment_17_ELEMENT_TYPE = associate(ModelFactory.createModel_X15Assignment_17ElementType());

	public static final IGrammarAwareElementType Model_X15SingleContainmentReferenceParserRuleCall_17_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X15SingleContainmentReferenceParserRuleCall_17_0ElementType());

	public static final IGrammarAwareElementType Model_X19Assignment_18_ELEMENT_TYPE = associate(ModelFactory.createModel_X19Assignment_18ElementType());

	public static final IGrammarAwareElementType Model_X19DependentAlternative1ParserRuleCall_18_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X19DependentAlternative1ParserRuleCall_18_0ElementType());

	public static final IGrammarAwareElementType Model_X20Assignment_19_ELEMENT_TYPE = associate(ModelFactory.createModel_X20Assignment_19ElementType());

	public static final IGrammarAwareElementType Model_X20DependentAlternative2ParserRuleCall_19_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X20DependentAlternative2ParserRuleCall_19_0ElementType());

	public static final IGrammarAwareElementType Model_X21Assignment_20_ELEMENT_TYPE = associate(ModelFactory.createModel_X21Assignment_20ElementType());

	public static final IGrammarAwareElementType Model_X21OptionalParserRuleCall_20_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X21OptionalParserRuleCall_20_0ElementType());

	public static final IGrammarAwareElementType Model_X22Assignment_21_ELEMENT_TYPE = associate(ModelFactory.createModel_X22Assignment_21ElementType());

	public static final IGrammarAwareElementType Model_X22FloatParserRuleCall_21_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X22FloatParserRuleCall_21_0ElementType());

	public static final IGrammarAwareElementType Model_X23Assignment_22_ELEMENT_TYPE = associate(ModelFactory.createModel_X23Assignment_22ElementType());

	public static final IGrammarAwareElementType Model_X23UnorderedAlternativeParserRuleCall_22_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X23UnorderedAlternativeParserRuleCall_22_0ElementType());

	public static final IGrammarAwareElementType Model_X24Assignment_23_ELEMENT_TYPE = associate(ModelFactory.createModel_X24Assignment_23ElementType());

	public static final IGrammarAwareElementType Model_X24UnorderedGroupParserRuleCall_23_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X24UnorderedGroupParserRuleCall_23_0ElementType());

	public static final IGrammarAwareElementType Model_X25Assignment_24_ELEMENT_TYPE = associate(ModelFactory.createModel_X25Assignment_24ElementType());

	public static final IGrammarAwareElementType Model_X25UnorderedGroupOptionalParserRuleCall_24_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X25UnorderedGroupOptionalParserRuleCall_24_0ElementType());

	public static final IGrammarAwareElementType Model_X26Assignment_25_ELEMENT_TYPE = associate(ModelFactory.createModel_X26Assignment_25ElementType());

	public static final IGrammarAwareElementType Model_X26UnorderedGroupBooleanParserRuleCall_25_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X26UnorderedGroupBooleanParserRuleCall_25_0ElementType());

	public static final IGrammarAwareElementType Model_X27Assignment_26_ELEMENT_TYPE = associate(ModelFactory.createModel_X27Assignment_26ElementType());

	public static final IGrammarAwareElementType Model_X27Complex1ParserRuleCall_26_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X27Complex1ParserRuleCall_26_0ElementType());

	public static final IGrammarAwareElementType Model_X28Assignment_27_ELEMENT_TYPE = associate(ModelFactory.createModel_X28Assignment_27ElementType());

	public static final IGrammarAwareElementType Model_X28OptionalDoubleParserRuleCall_27_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X28OptionalDoubleParserRuleCall_27_0ElementType());

	public static final IGrammarAwareElementType Model_X29Assignment_28_ELEMENT_TYPE = associate(ModelFactory.createModel_X29Assignment_28ElementType());

	public static final IGrammarAwareElementType Model_X29NullValueGeneratedParserRuleCall_28_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X29NullValueGeneratedParserRuleCall_28_0ElementType());

	public static final IGrammarAwareElementType Model_X30Assignment_29_ELEMENT_TYPE = associate(ModelFactory.createModel_X30Assignment_29ElementType());

	public static final IGrammarAwareElementType Model_X30NullValueInterpretedParserRuleCall_29_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X30NullValueInterpretedParserRuleCall_29_0ElementType());

	public static final IGrammarAwareElementType Model_X31Assignment_30_ELEMENT_TYPE = associate(ModelFactory.createModel_X31Assignment_30ElementType());

	public static final IGrammarAwareElementType Model_X31NullCrossRefGeneratedParserRuleCall_30_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X31NullCrossRefGeneratedParserRuleCall_30_0ElementType());

	public static final IGrammarAwareElementType Model_X32Assignment_31_ELEMENT_TYPE = associate(ModelFactory.createModel_X32Assignment_31ElementType());

	public static final IGrammarAwareElementType Model_X32NullCrossRefInterpretedParserRuleCall_31_0_ELEMENT_TYPE = associate(ModelFactory.createModel_X32NullCrossRefInterpretedParserRuleCall_31_0ElementType());

	private static class SimpleGroupFactory {
		public static IGrammarAwareElementType createSimpleGroupElementType() {
			return new IGrammarAwareElementType("SimpleGroup_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupRule());
		}
		public static IGrammarAwareElementType createSimpleGroup_GroupElementType() {
			return new IGrammarAwareElementType("SimpleGroup_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getGroup());
		}
		public static IGrammarAwareElementType createSimpleGroup_NumberSignDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("SimpleGroup_NumberSignDigitOneKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getNumberSignDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createSimpleGroup_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("SimpleGroup_Val1Assignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createSimpleGroup_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleGroup_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSimpleGroup_Val2Assignment_2ElementType() {
			return new IGrammarAwareElementType("SimpleGroup_Val2Assignment_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getVal2Assignment_2());
		}
		public static IGrammarAwareElementType createSimpleGroup_Val2IDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("SimpleGroup_Val2IDTerminalRuleCall_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleGroupAccess().getVal2IDTerminalRuleCall_2_0());
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
			return new IGrammarAwareElementType("SimpleAlternative_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeRule());
		}
		public static IGrammarAwareElementType createSimpleAlternative_GroupElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getGroup());
		}
		public static IGrammarAwareElementType createSimpleAlternative_NumberSignDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getNumberSignDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Alternatives_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Group_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Group_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Kw1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Kw1Keyword_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getKw1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Val1Assignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Val1Assignment_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getVal1Assignment_1_0_1());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getVal1IDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Group_1_1ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Group_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Kw2Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Kw2Keyword_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getKw2Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Val2Assignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Val2Assignment_1_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getVal2Assignment_1_1_1());
		}
		public static IGrammarAwareElementType createSimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAlternativeAccess().getVal2IDTerminalRuleCall_1_1_1_0());
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
			return new IGrammarAwareElementType("SimpleMultiplicities_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesRule());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_GroupElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getGroup());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_NumberSignDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getNumberSignDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val1Assignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Kw1Keyword_2ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Kw1Keyword_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getKw1Keyword_2());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val2Assignment_3ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val2Assignment_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal2Assignment_3());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val2IDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val2IDTerminalRuleCall_3_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Kw2Keyword_4ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Kw2Keyword_4_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getKw2Keyword_4());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val3Assignment_5ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val3Assignment_5_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal3Assignment_5());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val3IDTerminalRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val3IDTerminalRuleCall_5_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal3IDTerminalRuleCall_5_0());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Kw3Keyword_6ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Kw3Keyword_6_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getKw3Keyword_6());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val4Assignment_7ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val4Assignment_7_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal4Assignment_7());
		}
		public static IGrammarAwareElementType createSimpleMultiplicities_Val4IDTerminalRuleCall_7_0ElementType() {
			return new IGrammarAwareElementType("SimpleMultiplicities_Val4IDTerminalRuleCall_7_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleMultiplicitiesAccess().getVal4IDTerminalRuleCall_7_0());
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
			return new IGrammarAwareElementType("GroupMultiplicities_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesRule());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_GroupElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getGroup());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_NumberSignDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_NumberSignDigitFourKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getNumberSignDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val1Assignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Kw1Keyword_2ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Kw1Keyword_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getKw1Keyword_2());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Group_3ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Group_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val2Assignment_3_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val2Assignment_3_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal2Assignment_3_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val2IDTerminalRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val2IDTerminalRuleCall_3_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val3Assignment_3_1ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val3Assignment_3_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal3Assignment_3_1());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val3IDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val3IDTerminalRuleCall_3_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal3IDTerminalRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Kw2Keyword_4ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Kw2Keyword_4_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getKw2Keyword_4());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Group_5ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Group_5_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val4Assignment_5_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val4Assignment_5_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal4Assignment_5_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val4IDTerminalRuleCall_5_0_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val4IDTerminalRuleCall_5_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal4IDTerminalRuleCall_5_0_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val5Assignment_5_1ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val5Assignment_5_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal5Assignment_5_1());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val5IDTerminalRuleCall_5_1_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val5IDTerminalRuleCall_5_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal5IDTerminalRuleCall_5_1_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Kw3Keyword_6ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Kw3Keyword_6_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getKw3Keyword_6());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Group_7ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Group_7_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getGroup_7());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val6Assignment_7_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val6Assignment_7_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal6Assignment_7_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val6IDTerminalRuleCall_7_0_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val6IDTerminalRuleCall_7_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal6IDTerminalRuleCall_7_0_0());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val7Assignment_7_1ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val7Assignment_7_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal7Assignment_7_1());
		}
		public static IGrammarAwareElementType createGroupMultiplicities_Val7IDTerminalRuleCall_7_1_0ElementType() {
			return new IGrammarAwareElementType("GroupMultiplicities_Val7IDTerminalRuleCall_7_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupMultiplicitiesAccess().getVal7IDTerminalRuleCall_7_1_0());
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
			return new IGrammarAwareElementType("AlternativeMultiplicities_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesRule());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_GroupElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getGroup());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_NumberSignDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getNumberSignDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Alternatives_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val2Assignment_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val2Assignment_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal2Assignment_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal2IDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Group_1_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Group_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Kw1Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Kw1Keyword_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getKw1Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val3Assignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val3Assignment_1_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal3Assignment_1_1_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal3IDTerminalRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Kw2Keyword_2ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Kw2Keyword_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getKw2Keyword_2());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Alternatives_3ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Alternatives_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getAlternatives_3());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val4Assignment_3_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val4Assignment_3_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal4Assignment_3_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal4IDTerminalRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Group_3_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Group_3_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Kw3Keyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Kw3Keyword_3_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getKw3Keyword_3_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val5Assignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val5Assignment_3_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal5Assignment_3_1_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal5IDTerminalRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Kw4Keyword_4ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Kw4Keyword_4_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getKw4Keyword_4());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Alternatives_5ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Alternatives_5_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getAlternatives_5());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val6Assignment_5_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val6Assignment_5_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal6Assignment_5_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal6IDTerminalRuleCall_5_0_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Group_5_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Group_5_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getGroup_5_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Kw5Keyword_5_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Kw5Keyword_5_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getKw5Keyword_5_1_0());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val7Assignment_5_1_1ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val7Assignment_5_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal7Assignment_5_1_1());
		}
		public static IGrammarAwareElementType createAlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0ElementType() {
			return new IGrammarAwareElementType("AlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativeMultiplicitiesAccess().getVal7IDTerminalRuleCall_5_1_1_0());
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

	private static class List1Factory {
		public static IGrammarAwareElementType createList1ElementType() {
			return new IGrammarAwareElementType("List1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Rule());
		}
		public static IGrammarAwareElementType createList1_GroupElementType() {
			return new IGrammarAwareElementType("List1_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getGroup());
		}
		public static IGrammarAwareElementType createList1_NumberSignDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("List1_NumberSignDigitSixKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getNumberSignDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createList1_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("List1_Val1Assignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createList1_Val1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("List1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getVal1IDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createList1_Group_2ElementType() {
			return new IGrammarAwareElementType("List1_Group_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getGroup_2());
		}
		public static IGrammarAwareElementType createList1_CommaKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("List1_CommaKeyword_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getCommaKeyword_2_0());
		}
		public static IGrammarAwareElementType createList1_Val1Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("List1_Val1Assignment_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getVal1Assignment_2_1());
		}
		public static IGrammarAwareElementType createList1_Val1IDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("List1_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList1Access().getVal1IDTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType List1_ELEMENT_TYPE = associate(List1Factory.createList1ElementType());

	public static final IGrammarAwareElementType List1_Group_ELEMENT_TYPE = associate(List1Factory.createList1_GroupElementType());

	public static final IGrammarAwareElementType List1_NumberSignDigitSixKeyword_0_ELEMENT_TYPE = associate(List1Factory.createList1_NumberSignDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType List1_Val1Assignment_1_ELEMENT_TYPE = associate(List1Factory.createList1_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType List1_Val1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(List1Factory.createList1_Val1IDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType List1_Group_2_ELEMENT_TYPE = associate(List1Factory.createList1_Group_2ElementType());

	public static final IGrammarAwareElementType List1_CommaKeyword_2_0_ELEMENT_TYPE = associate(List1Factory.createList1_CommaKeyword_2_0ElementType());

	public static final IGrammarAwareElementType List1_Val1Assignment_2_1_ELEMENT_TYPE = associate(List1Factory.createList1_Val1Assignment_2_1ElementType());

	public static final IGrammarAwareElementType List1_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(List1Factory.createList1_Val1IDTerminalRuleCall_2_1_0ElementType());

	private static class List2Factory {
		public static IGrammarAwareElementType createList2ElementType() {
			return new IGrammarAwareElementType("List2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Rule());
		}
		public static IGrammarAwareElementType createList2_GroupElementType() {
			return new IGrammarAwareElementType("List2_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getGroup());
		}
		public static IGrammarAwareElementType createList2_NumberSignDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("List2_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getNumberSignDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createList2_List2Action_1ElementType() {
			return new IGrammarAwareElementType("List2_List2Action_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getList2Action_1());
		}
		public static IGrammarAwareElementType createList2_Group_2ElementType() {
			return new IGrammarAwareElementType("List2_Group_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getGroup_2());
		}
		public static IGrammarAwareElementType createList2_Val1Assignment_2_0ElementType() {
			return new IGrammarAwareElementType("List2_Val1Assignment_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getVal1Assignment_2_0());
		}
		public static IGrammarAwareElementType createList2_Val1IDTerminalRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("List2_Val1IDTerminalRuleCall_2_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getVal1IDTerminalRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createList2_Group_2_1ElementType() {
			return new IGrammarAwareElementType("List2_Group_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getGroup_2_1());
		}
		public static IGrammarAwareElementType createList2_CommaKeyword_2_1_0ElementType() {
			return new IGrammarAwareElementType("List2_CommaKeyword_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getCommaKeyword_2_1_0());
		}
		public static IGrammarAwareElementType createList2_Val1Assignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("List2_Val1Assignment_2_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getVal1Assignment_2_1_1());
		}
		public static IGrammarAwareElementType createList2_Val1IDTerminalRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("List2_Val1IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getList2Access().getVal1IDTerminalRuleCall_2_1_1_0());
		}
	}

	public static final IGrammarAwareElementType List2_ELEMENT_TYPE = associate(List2Factory.createList2ElementType());

	public static final IGrammarAwareElementType List2_Group_ELEMENT_TYPE = associate(List2Factory.createList2_GroupElementType());

	public static final IGrammarAwareElementType List2_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE = associate(List2Factory.createList2_NumberSignDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType List2_List2Action_1_ELEMENT_TYPE = associate(List2Factory.createList2_List2Action_1ElementType());

	public static final IGrammarAwareElementType List2_Group_2_ELEMENT_TYPE = associate(List2Factory.createList2_Group_2ElementType());

	public static final IGrammarAwareElementType List2_Val1Assignment_2_0_ELEMENT_TYPE = associate(List2Factory.createList2_Val1Assignment_2_0ElementType());

	public static final IGrammarAwareElementType List2_Val1IDTerminalRuleCall_2_0_0_ELEMENT_TYPE = associate(List2Factory.createList2_Val1IDTerminalRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType List2_Group_2_1_ELEMENT_TYPE = associate(List2Factory.createList2_Group_2_1ElementType());

	public static final IGrammarAwareElementType List2_CommaKeyword_2_1_0_ELEMENT_TYPE = associate(List2Factory.createList2_CommaKeyword_2_1_0ElementType());

	public static final IGrammarAwareElementType List2_Val1Assignment_2_1_1_ELEMENT_TYPE = associate(List2Factory.createList2_Val1Assignment_2_1_1ElementType());

	public static final IGrammarAwareElementType List2_Val1IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE = associate(List2Factory.createList2_Val1IDTerminalRuleCall_2_1_1_0ElementType());

	private static class AltList1Factory {
		public static IGrammarAwareElementType createAltList1ElementType() {
			return new IGrammarAwareElementType("AltList1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Rule());
		}
		public static IGrammarAwareElementType createAltList1_GroupElementType() {
			return new IGrammarAwareElementType("AltList1_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getGroup());
		}
		public static IGrammarAwareElementType createAltList1_NumberSignDigitEightKeyword_0ElementType() {
			return new IGrammarAwareElementType("AltList1_NumberSignDigitEightKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getNumberSignDigitEightKeyword_0());
		}
		public static IGrammarAwareElementType createAltList1_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("AltList1_Alternatives_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createAltList1_Group_1_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Group_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createAltList1_Val1Assignment_1_0_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1Assignment_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1Assignment_1_0_0());
		}
		public static IGrammarAwareElementType createAltList1_Val1IDTerminalRuleCall_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1IDTerminalRuleCall_1_0_0_0());
		}
		public static IGrammarAwareElementType createAltList1_Val2Assignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("AltList1_Val2Assignment_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal2Assignment_1_0_1());
		}
		public static IGrammarAwareElementType createAltList1_Val2IDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val2IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal2IDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createAltList1_Group_1_1ElementType() {
			return new IGrammarAwareElementType("AltList1_Group_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAltList1_Kw1Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Kw1Keyword_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getKw1Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createAltList1_Val1Assignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1Assignment_1_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1Assignment_1_1_1());
		}
		public static IGrammarAwareElementType createAltList1_Val1IDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1IDTerminalRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createAltList1_Val3Assignment_1_1_2ElementType() {
			return new IGrammarAwareElementType("AltList1_Val3Assignment_1_1_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal3Assignment_1_1_2());
		}
		public static IGrammarAwareElementType createAltList1_Val3IDTerminalRuleCall_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val3IDTerminalRuleCall_1_1_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal3IDTerminalRuleCall_1_1_2_0());
		}
		public static IGrammarAwareElementType createAltList1_Group_1_2ElementType() {
			return new IGrammarAwareElementType("AltList1_Group_1_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getGroup_1_2());
		}
		public static IGrammarAwareElementType createAltList1_Kw2Keyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Kw2Keyword_1_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getKw2Keyword_1_2_0());
		}
		public static IGrammarAwareElementType createAltList1_Val1Assignment_1_2_1ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1Assignment_1_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1Assignment_1_2_1());
		}
		public static IGrammarAwareElementType createAltList1_Val1IDTerminalRuleCall_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val1IDTerminalRuleCall_1_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal1IDTerminalRuleCall_1_2_1_0());
		}
		public static IGrammarAwareElementType createAltList1_Val4Assignment_1_2_2ElementType() {
			return new IGrammarAwareElementType("AltList1_Val4Assignment_1_2_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal4Assignment_1_2_2());
		}
		public static IGrammarAwareElementType createAltList1_Val4IDTerminalRuleCall_1_2_2_0ElementType() {
			return new IGrammarAwareElementType("AltList1_Val4IDTerminalRuleCall_1_2_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList1Access().getVal4IDTerminalRuleCall_1_2_2_0());
		}
	}

	public static final IGrammarAwareElementType AltList1_ELEMENT_TYPE = associate(AltList1Factory.createAltList1ElementType());

	public static final IGrammarAwareElementType AltList1_Group_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_GroupElementType());

	public static final IGrammarAwareElementType AltList1_NumberSignDigitEightKeyword_0_ELEMENT_TYPE = associate(AltList1Factory.createAltList1_NumberSignDigitEightKeyword_0ElementType());

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
			return new IGrammarAwareElementType("AltList2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Rule());
		}
		public static IGrammarAwareElementType createAltList2_GroupElementType() {
			return new IGrammarAwareElementType("AltList2_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getGroup());
		}
		public static IGrammarAwareElementType createAltList2_NumberSignDigitNineKeyword_0ElementType() {
			return new IGrammarAwareElementType("AltList2_NumberSignDigitNineKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getNumberSignDigitNineKeyword_0());
		}
		public static IGrammarAwareElementType createAltList2_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("AltList2_Alternatives_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createAltList2_Group_1_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Group_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createAltList2_Val1Assignment_1_0_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1Assignment_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1Assignment_1_0_0());
		}
		public static IGrammarAwareElementType createAltList2_Val1IDTerminalRuleCall_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1IDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1IDTerminalRuleCall_1_0_0_0());
		}
		public static IGrammarAwareElementType createAltList2_Val2Assignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("AltList2_Val2Assignment_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal2Assignment_1_0_1());
		}
		public static IGrammarAwareElementType createAltList2_Val2IDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val2IDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal2IDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createAltList2_Group_1_1ElementType() {
			return new IGrammarAwareElementType("AltList2_Group_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAltList2_KwKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("AltList2_KwKeyword_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getKwKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createAltList2_Val1Assignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1Assignment_1_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1Assignment_1_1_1());
		}
		public static IGrammarAwareElementType createAltList2_Val1IDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1IDTerminalRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createAltList2_Group_1_1_2ElementType() {
			return new IGrammarAwareElementType("AltList2_Group_1_1_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getGroup_1_1_2());
		}
		public static IGrammarAwareElementType createAltList2_CommaKeyword_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("AltList2_CommaKeyword_1_1_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getCommaKeyword_1_1_2_0());
		}
		public static IGrammarAwareElementType createAltList2_Val1Assignment_1_1_2_1ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1Assignment_1_1_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1Assignment_1_1_2_1());
		}
		public static IGrammarAwareElementType createAltList2_Val1IDTerminalRuleCall_1_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val1IDTerminalRuleCall_1_1_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal1IDTerminalRuleCall_1_1_2_1_0());
		}
		public static IGrammarAwareElementType createAltList2_Val3Assignment_1_1_3ElementType() {
			return new IGrammarAwareElementType("AltList2_Val3Assignment_1_1_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal3Assignment_1_1_3());
		}
		public static IGrammarAwareElementType createAltList2_Val3IDTerminalRuleCall_1_1_3_0ElementType() {
			return new IGrammarAwareElementType("AltList2_Val3IDTerminalRuleCall_1_1_3_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltList2Access().getVal3IDTerminalRuleCall_1_1_3_0());
		}
	}

	public static final IGrammarAwareElementType AltList2_ELEMENT_TYPE = associate(AltList2Factory.createAltList2ElementType());

	public static final IGrammarAwareElementType AltList2_Group_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_GroupElementType());

	public static final IGrammarAwareElementType AltList2_NumberSignDigitNineKeyword_0_ELEMENT_TYPE = associate(AltList2Factory.createAltList2_NumberSignDigitNineKeyword_0ElementType());

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

	private static class SingleKeywordsFactory {
		public static IGrammarAwareElementType createSingleKeywordsElementType() {
			return new IGrammarAwareElementType("SingleKeywords_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsRule());
		}
		public static IGrammarAwareElementType createSingleKeywords_GroupElementType() {
			return new IGrammarAwareElementType("SingleKeywords_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsAccess().getGroup());
		}
		public static IGrammarAwareElementType createSingleKeywords_NumberSignDigitOneDigitZeroKeyword_0ElementType() {
			return new IGrammarAwareElementType("SingleKeywords_NumberSignDigitOneDigitZeroKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsAccess().getNumberSignDigitOneDigitZeroKeyword_0());
		}
		public static IGrammarAwareElementType createSingleKeywords_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("SingleKeywords_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createSingleKeywords_ValAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("SingleKeywords_ValAlternatives_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsAccess().getValAlternatives_1_0());
		}
		public static IGrammarAwareElementType createSingleKeywords_ValKw1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("SingleKeywords_ValKw1Keyword_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsAccess().getValKw1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createSingleKeywords_ValKw2Keyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleKeywords_ValKw2Keyword_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsAccess().getValKw2Keyword_1_0_1());
		}
		public static IGrammarAwareElementType createSingleKeywords_ValKw3Keyword_1_0_2ElementType() {
			return new IGrammarAwareElementType("SingleKeywords_ValKw3Keyword_1_0_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsAccess().getValKw3Keyword_1_0_2());
		}
	}

	public static final IGrammarAwareElementType SingleKeywords_ELEMENT_TYPE = associate(SingleKeywordsFactory.createSingleKeywordsElementType());

	public static final IGrammarAwareElementType SingleKeywords_Group_ELEMENT_TYPE = associate(SingleKeywordsFactory.createSingleKeywords_GroupElementType());

	public static final IGrammarAwareElementType SingleKeywords_NumberSignDigitOneDigitZeroKeyword_0_ELEMENT_TYPE = associate(SingleKeywordsFactory.createSingleKeywords_NumberSignDigitOneDigitZeroKeyword_0ElementType());

	public static final IGrammarAwareElementType SingleKeywords_ValAssignment_1_ELEMENT_TYPE = associate(SingleKeywordsFactory.createSingleKeywords_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType SingleKeywords_ValAlternatives_1_0_ELEMENT_TYPE = associate(SingleKeywordsFactory.createSingleKeywords_ValAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType SingleKeywords_ValKw1Keyword_1_0_0_ELEMENT_TYPE = associate(SingleKeywordsFactory.createSingleKeywords_ValKw1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType SingleKeywords_ValKw2Keyword_1_0_1_ELEMENT_TYPE = associate(SingleKeywordsFactory.createSingleKeywords_ValKw2Keyword_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleKeywords_ValKw3Keyword_1_0_2_ELEMENT_TYPE = associate(SingleKeywordsFactory.createSingleKeywords_ValKw3Keyword_1_0_2ElementType());

	private static class SingleKeywordsOrIDFactory {
		public static IGrammarAwareElementType createSingleKeywordsOrIDElementType() {
			return new IGrammarAwareElementType("SingleKeywordsOrID_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsOrIDRule());
		}
		public static IGrammarAwareElementType createSingleKeywordsOrID_GroupElementType() {
			return new IGrammarAwareElementType("SingleKeywordsOrID_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsOrIDAccess().getGroup());
		}
		public static IGrammarAwareElementType createSingleKeywordsOrID_NumberSignDigitOneDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("SingleKeywordsOrID_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsOrIDAccess().getNumberSignDigitOneDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createSingleKeywordsOrID_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("SingleKeywordsOrID_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsOrIDAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createSingleKeywordsOrID_ValAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("SingleKeywordsOrID_ValAlternatives_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsOrIDAccess().getValAlternatives_1_0());
		}
		public static IGrammarAwareElementType createSingleKeywordsOrID_ValKw1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("SingleKeywordsOrID_ValKw1Keyword_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsOrIDAccess().getValKw1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createSingleKeywordsOrID_ValKw2Keyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleKeywordsOrID_ValKw2Keyword_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsOrIDAccess().getValKw2Keyword_1_0_1());
		}
		public static IGrammarAwareElementType createSingleKeywordsOrID_ValKw3Keyword_1_0_2ElementType() {
			return new IGrammarAwareElementType("SingleKeywordsOrID_ValKw3Keyword_1_0_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsOrIDAccess().getValKw3Keyword_1_0_2());
		}
		public static IGrammarAwareElementType createSingleKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType() {
			return new IGrammarAwareElementType("SingleKeywordsOrID_ValIDTerminalRuleCall_1_0_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleKeywordsOrIDAccess().getValIDTerminalRuleCall_1_0_3());
		}
	}

	public static final IGrammarAwareElementType SingleKeywordsOrID_ELEMENT_TYPE = associate(SingleKeywordsOrIDFactory.createSingleKeywordsOrIDElementType());

	public static final IGrammarAwareElementType SingleKeywordsOrID_Group_ELEMENT_TYPE = associate(SingleKeywordsOrIDFactory.createSingleKeywordsOrID_GroupElementType());

	public static final IGrammarAwareElementType SingleKeywordsOrID_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE = associate(SingleKeywordsOrIDFactory.createSingleKeywordsOrID_NumberSignDigitOneDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType SingleKeywordsOrID_ValAssignment_1_ELEMENT_TYPE = associate(SingleKeywordsOrIDFactory.createSingleKeywordsOrID_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType SingleKeywordsOrID_ValAlternatives_1_0_ELEMENT_TYPE = associate(SingleKeywordsOrIDFactory.createSingleKeywordsOrID_ValAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType SingleKeywordsOrID_ValKw1Keyword_1_0_0_ELEMENT_TYPE = associate(SingleKeywordsOrIDFactory.createSingleKeywordsOrID_ValKw1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType SingleKeywordsOrID_ValKw2Keyword_1_0_1_ELEMENT_TYPE = associate(SingleKeywordsOrIDFactory.createSingleKeywordsOrID_ValKw2Keyword_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleKeywordsOrID_ValKw3Keyword_1_0_2_ELEMENT_TYPE = associate(SingleKeywordsOrIDFactory.createSingleKeywordsOrID_ValKw3Keyword_1_0_2ElementType());

	public static final IGrammarAwareElementType SingleKeywordsOrID_ValIDTerminalRuleCall_1_0_3_ELEMENT_TYPE = associate(SingleKeywordsOrIDFactory.createSingleKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType());

	private static class SingleTerminalsFactory {
		public static IGrammarAwareElementType createSingleTerminalsElementType() {
			return new IGrammarAwareElementType("SingleTerminals_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleTerminalsRule());
		}
		public static IGrammarAwareElementType createSingleTerminals_GroupElementType() {
			return new IGrammarAwareElementType("SingleTerminals_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleTerminalsAccess().getGroup());
		}
		public static IGrammarAwareElementType createSingleTerminals_NumberSignDigitOneDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("SingleTerminals_NumberSignDigitOneDigitTwoKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleTerminalsAccess().getNumberSignDigitOneDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createSingleTerminals_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("SingleTerminals_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleTerminalsAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createSingleTerminals_ValAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("SingleTerminals_ValAlternatives_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleTerminalsAccess().getValAlternatives_1_0());
		}
		public static IGrammarAwareElementType createSingleTerminals_ValID1TerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("SingleTerminals_ValID1TerminalRuleCall_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleTerminalsAccess().getValID1TerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createSingleTerminals_ValID2TerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleTerminals_ValID2TerminalRuleCall_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleTerminalsAccess().getValID2TerminalRuleCall_1_0_1());
		}
	}

	public static final IGrammarAwareElementType SingleTerminals_ELEMENT_TYPE = associate(SingleTerminalsFactory.createSingleTerminalsElementType());

	public static final IGrammarAwareElementType SingleTerminals_Group_ELEMENT_TYPE = associate(SingleTerminalsFactory.createSingleTerminals_GroupElementType());

	public static final IGrammarAwareElementType SingleTerminals_NumberSignDigitOneDigitTwoKeyword_0_ELEMENT_TYPE = associate(SingleTerminalsFactory.createSingleTerminals_NumberSignDigitOneDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType SingleTerminals_ValAssignment_1_ELEMENT_TYPE = associate(SingleTerminalsFactory.createSingleTerminals_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType SingleTerminals_ValAlternatives_1_0_ELEMENT_TYPE = associate(SingleTerminalsFactory.createSingleTerminals_ValAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType SingleTerminals_ValID1TerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(SingleTerminalsFactory.createSingleTerminals_ValID1TerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType SingleTerminals_ValID2TerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(SingleTerminalsFactory.createSingleTerminals_ValID2TerminalRuleCall_1_0_1ElementType());

	private static class SingleEnumFactory {
		public static IGrammarAwareElementType createSingleEnumElementType() {
			return new IGrammarAwareElementType("SingleEnum_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleEnumRule());
		}
		public static IGrammarAwareElementType createSingleEnum_GroupElementType() {
			return new IGrammarAwareElementType("SingleEnum_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleEnumAccess().getGroup());
		}
		public static IGrammarAwareElementType createSingleEnum_NumberSignDigitOneDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("SingleEnum_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleEnumAccess().getNumberSignDigitOneDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createSingleEnum_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("SingleEnum_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleEnumAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createSingleEnum_ValAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("SingleEnum_ValAlternatives_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleEnumAccess().getValAlternatives_1_0());
		}
		public static IGrammarAwareElementType createSingleEnum_ValDefEnum1EnumRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("SingleEnum_ValDefEnum1EnumRuleCall_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleEnumAccess().getValDefEnum1EnumRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createSingleEnum_ValDefEnum2EnumRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleEnum_ValDefEnum2EnumRuleCall_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleEnumAccess().getValDefEnum2EnumRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createSingleEnum_ValDefEnum3EnumRuleCall_1_0_2ElementType() {
			return new IGrammarAwareElementType("SingleEnum_ValDefEnum3EnumRuleCall_1_0_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleEnumAccess().getValDefEnum3EnumRuleCall_1_0_2());
		}
	}

	public static final IGrammarAwareElementType SingleEnum_ELEMENT_TYPE = associate(SingleEnumFactory.createSingleEnumElementType());

	public static final IGrammarAwareElementType SingleEnum_Group_ELEMENT_TYPE = associate(SingleEnumFactory.createSingleEnum_GroupElementType());

	public static final IGrammarAwareElementType SingleEnum_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE = associate(SingleEnumFactory.createSingleEnum_NumberSignDigitOneDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType SingleEnum_ValAssignment_1_ELEMENT_TYPE = associate(SingleEnumFactory.createSingleEnum_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType SingleEnum_ValAlternatives_1_0_ELEMENT_TYPE = associate(SingleEnumFactory.createSingleEnum_ValAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType SingleEnum_ValDefEnum1EnumRuleCall_1_0_0_ELEMENT_TYPE = associate(SingleEnumFactory.createSingleEnum_ValDefEnum1EnumRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType SingleEnum_ValDefEnum2EnumRuleCall_1_0_1_ELEMENT_TYPE = associate(SingleEnumFactory.createSingleEnum_ValDefEnum2EnumRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleEnum_ValDefEnum3EnumRuleCall_1_0_2_ELEMENT_TYPE = associate(SingleEnumFactory.createSingleEnum_ValDefEnum3EnumRuleCall_1_0_2ElementType());

	private static class DefEnum1Factory {
		public static IGrammarAwareElementType createDefEnum1ElementType() {
			return new IGrammarAwareElementType("DefEnum1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefEnum1Rule());
		}
		public static IGrammarAwareElementType createDefEnum1_Kw1EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("DefEnum1_Kw1EnumLiteralDeclaration_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefEnum1Access().getKw1EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createDefEnum1_Kw1Kw1Keyword_0ElementType() {
			return new IGrammarAwareElementType("DefEnum1_Kw1Kw1Keyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefEnum1Access().getKw1Kw1Keyword_0());
		}
	}

	public static final IGrammarAwareElementType DefEnum1_ELEMENT_TYPE = associate(DefEnum1Factory.createDefEnum1ElementType());

	public static final IGrammarAwareElementType DefEnum1_Kw1EnumLiteralDeclaration_ELEMENT_TYPE = associate(DefEnum1Factory.createDefEnum1_Kw1EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType DefEnum1_Kw1Kw1Keyword_0_ELEMENT_TYPE = associate(DefEnum1Factory.createDefEnum1_Kw1Kw1Keyword_0ElementType());

	private static class DefEnum2Factory {
		public static IGrammarAwareElementType createDefEnum2ElementType() {
			return new IGrammarAwareElementType("DefEnum2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefEnum2Rule());
		}
		public static IGrammarAwareElementType createDefEnum2_Kw2EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("DefEnum2_Kw2EnumLiteralDeclaration_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefEnum2Access().getKw2EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createDefEnum2_Kw2Kw2Keyword_0ElementType() {
			return new IGrammarAwareElementType("DefEnum2_Kw2Kw2Keyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefEnum2Access().getKw2Kw2Keyword_0());
		}
	}

	public static final IGrammarAwareElementType DefEnum2_ELEMENT_TYPE = associate(DefEnum2Factory.createDefEnum2ElementType());

	public static final IGrammarAwareElementType DefEnum2_Kw2EnumLiteralDeclaration_ELEMENT_TYPE = associate(DefEnum2Factory.createDefEnum2_Kw2EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType DefEnum2_Kw2Kw2Keyword_0_ELEMENT_TYPE = associate(DefEnum2Factory.createDefEnum2_Kw2Kw2Keyword_0ElementType());

	private static class DefEnum3Factory {
		public static IGrammarAwareElementType createDefEnum3ElementType() {
			return new IGrammarAwareElementType("DefEnum3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefEnum3Rule());
		}
		public static IGrammarAwareElementType createDefEnum3_Kw3EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("DefEnum3_Kw3EnumLiteralDeclaration_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefEnum3Access().getKw3EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createDefEnum3_Kw3Kw3Keyword_0ElementType() {
			return new IGrammarAwareElementType("DefEnum3_Kw3Kw3Keyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefEnum3Access().getKw3Kw3Keyword_0());
		}
	}

	public static final IGrammarAwareElementType DefEnum3_ELEMENT_TYPE = associate(DefEnum3Factory.createDefEnum3ElementType());

	public static final IGrammarAwareElementType DefEnum3_Kw3EnumLiteralDeclaration_ELEMENT_TYPE = associate(DefEnum3Factory.createDefEnum3_Kw3EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType DefEnum3_Kw3Kw3Keyword_0_ELEMENT_TYPE = associate(DefEnum3Factory.createDefEnum3_Kw3Kw3Keyword_0ElementType());

	private static class SingleCrossReferenceFactory {
		public static IGrammarAwareElementType createSingleCrossReferenceElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceRule());
		}
		public static IGrammarAwareElementType createSingleCrossReference_GroupElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getGroup());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NumberSignDigitOneDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNumberSignDigitOneDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NameAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NameAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NameAlternatives_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNameAlternatives_1_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NameID1TerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NameID1TerminalRuleCall_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNameID1TerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NameID2TerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NameID2TerminalRuleCall_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNameID2TerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_NameID3TerminalRuleCall_1_0_2ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_NameID3TerminalRuleCall_1_0_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getNameID3TerminalRuleCall_1_0_2());
		}
		public static IGrammarAwareElementType createSingleCrossReference_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_Alternatives_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createSingleCrossReference_RefAssignment_2_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_RefAssignment_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRefAssignment_2_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_RefSingleCrossReferenceCrossReference_2_0_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_RefSingleCrossReferenceCrossReference_2_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRefSingleCrossReferenceCrossReference_2_0_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_RefSingleCrossReferenceID1TerminalRuleCall_2_0_0_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_RefSingleCrossReferenceID1TerminalRuleCall_2_0_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRefSingleCrossReferenceID1TerminalRuleCall_2_0_0_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_RefAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_RefAssignment_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRefAssignment_2_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_RefSingleCrossReferenceCrossReference_2_1_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_RefSingleCrossReferenceCrossReference_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRefSingleCrossReferenceCrossReference_2_1_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_RefSingleCrossReferenceID2TerminalRuleCall_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_RefSingleCrossReferenceID2TerminalRuleCall_2_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRefSingleCrossReferenceID2TerminalRuleCall_2_1_0_1());
		}
		public static IGrammarAwareElementType createSingleCrossReference_RefAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_RefAssignment_2_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRefAssignment_2_2());
		}
		public static IGrammarAwareElementType createSingleCrossReference_RefSingleCrossReferenceCrossReference_2_2_0ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_RefSingleCrossReferenceCrossReference_2_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRefSingleCrossReferenceCrossReference_2_2_0());
		}
		public static IGrammarAwareElementType createSingleCrossReference_RefSingleCrossReferenceID3TerminalRuleCall_2_2_0_1ElementType() {
			return new IGrammarAwareElementType("SingleCrossReference_RefSingleCrossReferenceID3TerminalRuleCall_2_2_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleCrossReferenceAccess().getRefSingleCrossReferenceID3TerminalRuleCall_2_2_0_1());
		}
	}

	public static final IGrammarAwareElementType SingleCrossReference_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReferenceElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Group_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_GroupElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NumberSignDigitOneDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NameAssignment_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NameAlternatives_1_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NameAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NameID1TerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NameID1TerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NameID2TerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NameID2TerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_NameID3TerminalRuleCall_1_0_2_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_NameID3TerminalRuleCall_1_0_2ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_Alternatives_2_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_Alternatives_2ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_RefAssignment_2_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_RefAssignment_2_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_RefSingleCrossReferenceCrossReference_2_0_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_RefSingleCrossReferenceCrossReference_2_0_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_RefSingleCrossReferenceID1TerminalRuleCall_2_0_0_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_RefSingleCrossReferenceID1TerminalRuleCall_2_0_0_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_RefAssignment_2_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_RefAssignment_2_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_RefSingleCrossReferenceCrossReference_2_1_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_RefSingleCrossReferenceCrossReference_2_1_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_RefSingleCrossReferenceID2TerminalRuleCall_2_1_0_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_RefSingleCrossReferenceID2TerminalRuleCall_2_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_RefAssignment_2_2_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_RefAssignment_2_2ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_RefSingleCrossReferenceCrossReference_2_2_0_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_RefSingleCrossReferenceCrossReference_2_2_0ElementType());

	public static final IGrammarAwareElementType SingleCrossReference_RefSingleCrossReferenceID3TerminalRuleCall_2_2_0_1_ELEMENT_TYPE = associate(SingleCrossReferenceFactory.createSingleCrossReference_RefSingleCrossReferenceID3TerminalRuleCall_2_2_0_1ElementType());

	private static class SingleContainmentReferenceFactory {
		public static IGrammarAwareElementType createSingleContainmentReferenceElementType() {
			return new IGrammarAwareElementType("SingleContainmentReference_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceRule());
		}
		public static IGrammarAwareElementType createSingleContainmentReference_GroupElementType() {
			return new IGrammarAwareElementType("SingleContainmentReference_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceAccess().getGroup());
		}
		public static IGrammarAwareElementType createSingleContainmentReference_NumberSignDigitOneDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReference_NumberSignDigitOneDigitFiveKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceAccess().getNumberSignDigitOneDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createSingleContainmentReference_ChildAssignment_1ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReference_ChildAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceAccess().getChildAssignment_1());
		}
		public static IGrammarAwareElementType createSingleContainmentReference_ChildAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReference_ChildAlternatives_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceAccess().getChildAlternatives_1_0());
		}
		public static IGrammarAwareElementType createSingleContainmentReference_ChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReference_ChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceAccess().getChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createSingleContainmentReference_ChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReference_ChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceAccess().getChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createSingleContainmentReference_ChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReference_ChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceAccess().getChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2());
		}
	}

	public static final IGrammarAwareElementType SingleContainmentReference_ELEMENT_TYPE = associate(SingleContainmentReferenceFactory.createSingleContainmentReferenceElementType());

	public static final IGrammarAwareElementType SingleContainmentReference_Group_ELEMENT_TYPE = associate(SingleContainmentReferenceFactory.createSingleContainmentReference_GroupElementType());

	public static final IGrammarAwareElementType SingleContainmentReference_NumberSignDigitOneDigitFiveKeyword_0_ELEMENT_TYPE = associate(SingleContainmentReferenceFactory.createSingleContainmentReference_NumberSignDigitOneDigitFiveKeyword_0ElementType());

	public static final IGrammarAwareElementType SingleContainmentReference_ChildAssignment_1_ELEMENT_TYPE = associate(SingleContainmentReferenceFactory.createSingleContainmentReference_ChildAssignment_1ElementType());

	public static final IGrammarAwareElementType SingleContainmentReference_ChildAlternatives_1_0_ELEMENT_TYPE = associate(SingleContainmentReferenceFactory.createSingleContainmentReference_ChildAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType SingleContainmentReference_ChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0_ELEMENT_TYPE = associate(SingleContainmentReferenceFactory.createSingleContainmentReference_ChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType SingleContainmentReference_ChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1_ELEMENT_TYPE = associate(SingleContainmentReferenceFactory.createSingleContainmentReference_ChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleContainmentReference_ChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2_ELEMENT_TYPE = associate(SingleContainmentReferenceFactory.createSingleContainmentReference_ChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2ElementType());

	private static class SingleContainmentReferenceChild1Factory {
		public static IGrammarAwareElementType createSingleContainmentReferenceChild1ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReferenceChild1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceChild1Rule());
		}
		public static IGrammarAwareElementType createSingleContainmentReferenceChild1_ValAssignmentElementType() {
			return new IGrammarAwareElementType("SingleContainmentReferenceChild1_ValAssignment_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceChild1Access().getValAssignment());
		}
		public static IGrammarAwareElementType createSingleContainmentReferenceChild1_ValKw1Keyword_0ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReferenceChild1_ValKw1Keyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceChild1Access().getValKw1Keyword_0());
		}
	}

	public static final IGrammarAwareElementType SingleContainmentReferenceChild1_ELEMENT_TYPE = associate(SingleContainmentReferenceChild1Factory.createSingleContainmentReferenceChild1ElementType());

	public static final IGrammarAwareElementType SingleContainmentReferenceChild1_ValAssignment_ELEMENT_TYPE = associate(SingleContainmentReferenceChild1Factory.createSingleContainmentReferenceChild1_ValAssignmentElementType());

	public static final IGrammarAwareElementType SingleContainmentReferenceChild1_ValKw1Keyword_0_ELEMENT_TYPE = associate(SingleContainmentReferenceChild1Factory.createSingleContainmentReferenceChild1_ValKw1Keyword_0ElementType());

	private static class SingleContainmentReferenceChild2Factory {
		public static IGrammarAwareElementType createSingleContainmentReferenceChild2ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReferenceChild2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceChild2Rule());
		}
		public static IGrammarAwareElementType createSingleContainmentReferenceChild2_ValAssignmentElementType() {
			return new IGrammarAwareElementType("SingleContainmentReferenceChild2_ValAssignment_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceChild2Access().getValAssignment());
		}
		public static IGrammarAwareElementType createSingleContainmentReferenceChild2_ValKw2Keyword_0ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReferenceChild2_ValKw2Keyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceChild2Access().getValKw2Keyword_0());
		}
	}

	public static final IGrammarAwareElementType SingleContainmentReferenceChild2_ELEMENT_TYPE = associate(SingleContainmentReferenceChild2Factory.createSingleContainmentReferenceChild2ElementType());

	public static final IGrammarAwareElementType SingleContainmentReferenceChild2_ValAssignment_ELEMENT_TYPE = associate(SingleContainmentReferenceChild2Factory.createSingleContainmentReferenceChild2_ValAssignmentElementType());

	public static final IGrammarAwareElementType SingleContainmentReferenceChild2_ValKw2Keyword_0_ELEMENT_TYPE = associate(SingleContainmentReferenceChild2Factory.createSingleContainmentReferenceChild2_ValKw2Keyword_0ElementType());

	private static class SingleContainmentReferenceChild3Factory {
		public static IGrammarAwareElementType createSingleContainmentReferenceChild3ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReferenceChild3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceChild3Rule());
		}
		public static IGrammarAwareElementType createSingleContainmentReferenceChild3_ValAssignmentElementType() {
			return new IGrammarAwareElementType("SingleContainmentReferenceChild3_ValAssignment_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceChild3Access().getValAssignment());
		}
		public static IGrammarAwareElementType createSingleContainmentReferenceChild3_ValKw3Keyword_0ElementType() {
			return new IGrammarAwareElementType("SingleContainmentReferenceChild3_ValKw3Keyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleContainmentReferenceChild3Access().getValKw3Keyword_0());
		}
	}

	public static final IGrammarAwareElementType SingleContainmentReferenceChild3_ELEMENT_TYPE = associate(SingleContainmentReferenceChild3Factory.createSingleContainmentReferenceChild3ElementType());

	public static final IGrammarAwareElementType SingleContainmentReferenceChild3_ValAssignment_ELEMENT_TYPE = associate(SingleContainmentReferenceChild3Factory.createSingleContainmentReferenceChild3_ValAssignmentElementType());

	public static final IGrammarAwareElementType SingleContainmentReferenceChild3_ValKw3Keyword_0_ELEMENT_TYPE = associate(SingleContainmentReferenceChild3Factory.createSingleContainmentReferenceChild3_ValKw3Keyword_0ElementType());

	private static class MultiKeywordsFactory {
		public static IGrammarAwareElementType createMultiKeywordsElementType() {
			return new IGrammarAwareElementType("MultiKeywords_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsRule());
		}
		public static IGrammarAwareElementType createMultiKeywords_GroupElementType() {
			return new IGrammarAwareElementType("MultiKeywords_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsAccess().getGroup());
		}
		public static IGrammarAwareElementType createMultiKeywords_NumberSignDigitOneDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("MultiKeywords_NumberSignDigitOneDigitSixKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsAccess().getNumberSignDigitOneDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createMultiKeywords_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("MultiKeywords_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createMultiKeywords_ValAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("MultiKeywords_ValAlternatives_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsAccess().getValAlternatives_1_0());
		}
		public static IGrammarAwareElementType createMultiKeywords_ValKw1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("MultiKeywords_ValKw1Keyword_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsAccess().getValKw1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createMultiKeywords_ValKw2Keyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("MultiKeywords_ValKw2Keyword_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsAccess().getValKw2Keyword_1_0_1());
		}
		public static IGrammarAwareElementType createMultiKeywords_ValKw3Keyword_1_0_2ElementType() {
			return new IGrammarAwareElementType("MultiKeywords_ValKw3Keyword_1_0_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsAccess().getValKw3Keyword_1_0_2());
		}
	}

	public static final IGrammarAwareElementType MultiKeywords_ELEMENT_TYPE = associate(MultiKeywordsFactory.createMultiKeywordsElementType());

	public static final IGrammarAwareElementType MultiKeywords_Group_ELEMENT_TYPE = associate(MultiKeywordsFactory.createMultiKeywords_GroupElementType());

	public static final IGrammarAwareElementType MultiKeywords_NumberSignDigitOneDigitSixKeyword_0_ELEMENT_TYPE = associate(MultiKeywordsFactory.createMultiKeywords_NumberSignDigitOneDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType MultiKeywords_ValAssignment_1_ELEMENT_TYPE = associate(MultiKeywordsFactory.createMultiKeywords_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType MultiKeywords_ValAlternatives_1_0_ELEMENT_TYPE = associate(MultiKeywordsFactory.createMultiKeywords_ValAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType MultiKeywords_ValKw1Keyword_1_0_0_ELEMENT_TYPE = associate(MultiKeywordsFactory.createMultiKeywords_ValKw1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType MultiKeywords_ValKw2Keyword_1_0_1_ELEMENT_TYPE = associate(MultiKeywordsFactory.createMultiKeywords_ValKw2Keyword_1_0_1ElementType());

	public static final IGrammarAwareElementType MultiKeywords_ValKw3Keyword_1_0_2_ELEMENT_TYPE = associate(MultiKeywordsFactory.createMultiKeywords_ValKw3Keyword_1_0_2ElementType());

	private static class MultiKeywordsOrIDFactory {
		public static IGrammarAwareElementType createMultiKeywordsOrIDElementType() {
			return new IGrammarAwareElementType("MultiKeywordsOrID_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsOrIDRule());
		}
		public static IGrammarAwareElementType createMultiKeywordsOrID_GroupElementType() {
			return new IGrammarAwareElementType("MultiKeywordsOrID_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsOrIDAccess().getGroup());
		}
		public static IGrammarAwareElementType createMultiKeywordsOrID_NumberSignDigitOneDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("MultiKeywordsOrID_NumberSignDigitOneDigitSevenKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsOrIDAccess().getNumberSignDigitOneDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createMultiKeywordsOrID_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("MultiKeywordsOrID_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsOrIDAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createMultiKeywordsOrID_ValAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("MultiKeywordsOrID_ValAlternatives_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsOrIDAccess().getValAlternatives_1_0());
		}
		public static IGrammarAwareElementType createMultiKeywordsOrID_ValKw1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("MultiKeywordsOrID_ValKw1Keyword_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsOrIDAccess().getValKw1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createMultiKeywordsOrID_ValKw2Keyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("MultiKeywordsOrID_ValKw2Keyword_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsOrIDAccess().getValKw2Keyword_1_0_1());
		}
		public static IGrammarAwareElementType createMultiKeywordsOrID_ValKw3Keyword_1_0_2ElementType() {
			return new IGrammarAwareElementType("MultiKeywordsOrID_ValKw3Keyword_1_0_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsOrIDAccess().getValKw3Keyword_1_0_2());
		}
		public static IGrammarAwareElementType createMultiKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType() {
			return new IGrammarAwareElementType("MultiKeywordsOrID_ValIDTerminalRuleCall_1_0_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiKeywordsOrIDAccess().getValIDTerminalRuleCall_1_0_3());
		}
	}

	public static final IGrammarAwareElementType MultiKeywordsOrID_ELEMENT_TYPE = associate(MultiKeywordsOrIDFactory.createMultiKeywordsOrIDElementType());

	public static final IGrammarAwareElementType MultiKeywordsOrID_Group_ELEMENT_TYPE = associate(MultiKeywordsOrIDFactory.createMultiKeywordsOrID_GroupElementType());

	public static final IGrammarAwareElementType MultiKeywordsOrID_NumberSignDigitOneDigitSevenKeyword_0_ELEMENT_TYPE = associate(MultiKeywordsOrIDFactory.createMultiKeywordsOrID_NumberSignDigitOneDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType MultiKeywordsOrID_ValAssignment_1_ELEMENT_TYPE = associate(MultiKeywordsOrIDFactory.createMultiKeywordsOrID_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType MultiKeywordsOrID_ValAlternatives_1_0_ELEMENT_TYPE = associate(MultiKeywordsOrIDFactory.createMultiKeywordsOrID_ValAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType MultiKeywordsOrID_ValKw1Keyword_1_0_0_ELEMENT_TYPE = associate(MultiKeywordsOrIDFactory.createMultiKeywordsOrID_ValKw1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType MultiKeywordsOrID_ValKw2Keyword_1_0_1_ELEMENT_TYPE = associate(MultiKeywordsOrIDFactory.createMultiKeywordsOrID_ValKw2Keyword_1_0_1ElementType());

	public static final IGrammarAwareElementType MultiKeywordsOrID_ValKw3Keyword_1_0_2_ELEMENT_TYPE = associate(MultiKeywordsOrIDFactory.createMultiKeywordsOrID_ValKw3Keyword_1_0_2ElementType());

	public static final IGrammarAwareElementType MultiKeywordsOrID_ValIDTerminalRuleCall_1_0_3_ELEMENT_TYPE = associate(MultiKeywordsOrIDFactory.createMultiKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType());

	private static class MultiTerminalsFactory {
		public static IGrammarAwareElementType createMultiTerminalsElementType() {
			return new IGrammarAwareElementType("MultiTerminals_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiTerminalsRule());
		}
		public static IGrammarAwareElementType createMultiTerminals_GroupElementType() {
			return new IGrammarAwareElementType("MultiTerminals_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiTerminalsAccess().getGroup());
		}
		public static IGrammarAwareElementType createMultiTerminals_NumberSignDigitOneDigitEightKeyword_0ElementType() {
			return new IGrammarAwareElementType("MultiTerminals_NumberSignDigitOneDigitEightKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiTerminalsAccess().getNumberSignDigitOneDigitEightKeyword_0());
		}
		public static IGrammarAwareElementType createMultiTerminals_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("MultiTerminals_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiTerminalsAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createMultiTerminals_ValAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("MultiTerminals_ValAlternatives_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiTerminalsAccess().getValAlternatives_1_0());
		}
		public static IGrammarAwareElementType createMultiTerminals_ValID1TerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("MultiTerminals_ValID1TerminalRuleCall_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiTerminalsAccess().getValID1TerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createMultiTerminals_ValID2TerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("MultiTerminals_ValID2TerminalRuleCall_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiTerminalsAccess().getValID2TerminalRuleCall_1_0_1());
		}
	}

	public static final IGrammarAwareElementType MultiTerminals_ELEMENT_TYPE = associate(MultiTerminalsFactory.createMultiTerminalsElementType());

	public static final IGrammarAwareElementType MultiTerminals_Group_ELEMENT_TYPE = associate(MultiTerminalsFactory.createMultiTerminals_GroupElementType());

	public static final IGrammarAwareElementType MultiTerminals_NumberSignDigitOneDigitEightKeyword_0_ELEMENT_TYPE = associate(MultiTerminalsFactory.createMultiTerminals_NumberSignDigitOneDigitEightKeyword_0ElementType());

	public static final IGrammarAwareElementType MultiTerminals_ValAssignment_1_ELEMENT_TYPE = associate(MultiTerminalsFactory.createMultiTerminals_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType MultiTerminals_ValAlternatives_1_0_ELEMENT_TYPE = associate(MultiTerminalsFactory.createMultiTerminals_ValAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType MultiTerminals_ValID1TerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(MultiTerminalsFactory.createMultiTerminals_ValID1TerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType MultiTerminals_ValID2TerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(MultiTerminalsFactory.createMultiTerminals_ValID2TerminalRuleCall_1_0_1ElementType());

	private static class DependentAlternative1Factory {
		public static IGrammarAwareElementType createDependentAlternative1ElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Rule());
		}
		public static IGrammarAwareElementType createDependentAlternative1_GroupElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Access().getGroup());
		}
		public static IGrammarAwareElementType createDependentAlternative1_NumberSignDigitOneDigitNineKeyword_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_NumberSignDigitOneDigitNineKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Access().getNumberSignDigitOneDigitNineKeyword_0());
		}
		public static IGrammarAwareElementType createDependentAlternative1_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_Alternatives_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createDependentAlternative1_ValAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_ValAssignment_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Access().getValAssignment_1_0());
		}
		public static IGrammarAwareElementType createDependentAlternative1_ValIDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_ValIDTerminalRuleCall_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Access().getValIDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createDependentAlternative1_Group_1_1ElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_Group_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createDependentAlternative1_ValAssignment_1_1_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_ValAssignment_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Access().getValAssignment_1_1_0());
		}
		public static IGrammarAwareElementType createDependentAlternative1_ValIDTerminalRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_ValIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Access().getValIDTerminalRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createDependentAlternative1_FlagAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_FlagAssignment_1_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Access().getFlagAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createDependentAlternative1_FlagKw1Keyword_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative1_FlagKw1Keyword_1_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative1Access().getFlagKw1Keyword_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType DependentAlternative1_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1ElementType());

	public static final IGrammarAwareElementType DependentAlternative1_Group_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1_GroupElementType());

	public static final IGrammarAwareElementType DependentAlternative1_NumberSignDigitOneDigitNineKeyword_0_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1_NumberSignDigitOneDigitNineKeyword_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative1_Alternatives_1_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1_Alternatives_1ElementType());

	public static final IGrammarAwareElementType DependentAlternative1_ValAssignment_1_0_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1_ValAssignment_1_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative1_ValIDTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1_ValIDTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative1_Group_1_1_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1_Group_1_1ElementType());

	public static final IGrammarAwareElementType DependentAlternative1_ValAssignment_1_1_0_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1_ValAssignment_1_1_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative1_ValIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1_ValIDTerminalRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative1_FlagAssignment_1_1_1_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1_FlagAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType DependentAlternative1_FlagKw1Keyword_1_1_1_0_ELEMENT_TYPE = associate(DependentAlternative1Factory.createDependentAlternative1_FlagKw1Keyword_1_1_1_0ElementType());

	private static class DependentAlternative2Factory {
		public static IGrammarAwareElementType createDependentAlternative2ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Rule());
		}
		public static IGrammarAwareElementType createDependentAlternative2_GroupElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getGroup());
		}
		public static IGrammarAwareElementType createDependentAlternative2_NumberSignDigitTwoDigitZeroKeyword_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_NumberSignDigitTwoDigitZeroKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getNumberSignDigitTwoDigitZeroKeyword_0());
		}
		public static IGrammarAwareElementType createDependentAlternative2_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_Alternatives_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createDependentAlternative2_Group_1_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_Group_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createDependentAlternative2_ValAssignment_1_0_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_ValAssignment_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getValAssignment_1_0_0());
		}
		public static IGrammarAwareElementType createDependentAlternative2_ValIDTerminalRuleCall_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_ValIDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getValIDTerminalRuleCall_1_0_0_0());
		}
		public static IGrammarAwareElementType createDependentAlternative2_ValAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_ValAssignment_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getValAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createDependentAlternative2_ValIDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_ValIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getValIDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createDependentAlternative2_Group_1_1ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_Group_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createDependentAlternative2_ValAssignment_1_1_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_ValAssignment_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getValAssignment_1_1_0());
		}
		public static IGrammarAwareElementType createDependentAlternative2_ValIDTerminalRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_ValIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getValIDTerminalRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createDependentAlternative2_FlagAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_FlagAssignment_1_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getFlagAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createDependentAlternative2_FlagKw1Keyword_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("DependentAlternative2_FlagKw1Keyword_1_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDependentAlternative2Access().getFlagKw1Keyword_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType DependentAlternative2_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_Group_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_GroupElementType());

	public static final IGrammarAwareElementType DependentAlternative2_NumberSignDigitTwoDigitZeroKeyword_0_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_NumberSignDigitTwoDigitZeroKeyword_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_Alternatives_1_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_Alternatives_1ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_Group_1_0_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_Group_1_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_ValAssignment_1_0_0_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_ValAssignment_1_0_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_ValIDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_ValIDTerminalRuleCall_1_0_0_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_ValAssignment_1_0_1_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_ValAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_ValIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_ValIDTerminalRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_Group_1_1_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_Group_1_1ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_ValAssignment_1_1_0_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_ValAssignment_1_1_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_ValIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_ValIDTerminalRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_FlagAssignment_1_1_1_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_FlagAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType DependentAlternative2_FlagKw1Keyword_1_1_1_0_ELEMENT_TYPE = associate(DependentAlternative2Factory.createDependentAlternative2_FlagKw1Keyword_1_1_1_0ElementType());

	private static class OptionalFactory {
		public static IGrammarAwareElementType createOptionalElementType() {
			return new IGrammarAwareElementType("Optional_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalRule());
		}
		public static IGrammarAwareElementType createOptional_GroupElementType() {
			return new IGrammarAwareElementType("Optional_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalAccess().getGroup());
		}
		public static IGrammarAwareElementType createOptional_NumberSignDigitTwoDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("Optional_NumberSignDigitTwoDigitOneKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalAccess().getNumberSignDigitTwoDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createOptional_Int0Assignment_1ElementType() {
			return new IGrammarAwareElementType("Optional_Int0Assignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalAccess().getInt0Assignment_1());
		}
		public static IGrammarAwareElementType createOptional_Int0INTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Optional_Int0INTTerminalRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalAccess().getInt0INTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createOptional_Group_2ElementType() {
			return new IGrammarAwareElementType("Optional_Group_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createOptional_Int1Assignment_2_0ElementType() {
			return new IGrammarAwareElementType("Optional_Int1Assignment_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalAccess().getInt1Assignment_2_0());
		}
		public static IGrammarAwareElementType createOptional_Int1INTTerminalRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("Optional_Int1INTTerminalRuleCall_2_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalAccess().getInt1INTTerminalRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createOptional_Int2Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("Optional_Int2Assignment_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalAccess().getInt2Assignment_2_1());
		}
		public static IGrammarAwareElementType createOptional_Int2INTTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Optional_Int2INTTerminalRuleCall_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalAccess().getInt2INTTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType Optional_ELEMENT_TYPE = associate(OptionalFactory.createOptionalElementType());

	public static final IGrammarAwareElementType Optional_Group_ELEMENT_TYPE = associate(OptionalFactory.createOptional_GroupElementType());

	public static final IGrammarAwareElementType Optional_NumberSignDigitTwoDigitOneKeyword_0_ELEMENT_TYPE = associate(OptionalFactory.createOptional_NumberSignDigitTwoDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType Optional_Int0Assignment_1_ELEMENT_TYPE = associate(OptionalFactory.createOptional_Int0Assignment_1ElementType());

	public static final IGrammarAwareElementType Optional_Int0INTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(OptionalFactory.createOptional_Int0INTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Optional_Group_2_ELEMENT_TYPE = associate(OptionalFactory.createOptional_Group_2ElementType());

	public static final IGrammarAwareElementType Optional_Int1Assignment_2_0_ELEMENT_TYPE = associate(OptionalFactory.createOptional_Int1Assignment_2_0ElementType());

	public static final IGrammarAwareElementType Optional_Int1INTTerminalRuleCall_2_0_0_ELEMENT_TYPE = associate(OptionalFactory.createOptional_Int1INTTerminalRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType Optional_Int2Assignment_2_1_ELEMENT_TYPE = associate(OptionalFactory.createOptional_Int2Assignment_2_1ElementType());

	public static final IGrammarAwareElementType Optional_Int2INTTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(OptionalFactory.createOptional_Int2INTTerminalRuleCall_2_1_0ElementType());

	private static class FloatFactory {
		public static IGrammarAwareElementType createFloatElementType() {
			return new IGrammarAwareElementType("Float_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFloatRule());
		}
		public static IGrammarAwareElementType createFloat_GroupElementType() {
			return new IGrammarAwareElementType("Float_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFloatAccess().getGroup());
		}
		public static IGrammarAwareElementType createFloat_NumberSignDigitTwoDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("Float_NumberSignDigitTwoDigitTwoKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFloatAccess().getNumberSignDigitTwoDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createFloat_FloatAction_1ElementType() {
			return new IGrammarAwareElementType("Float_FloatAction_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFloatAccess().getFloatAction_1());
		}
		public static IGrammarAwareElementType createFloat_ByeKeyword_2ElementType() {
			return new IGrammarAwareElementType("Float_ByeKeyword_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFloatAccess().getByeKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Float_ELEMENT_TYPE = associate(FloatFactory.createFloatElementType());

	public static final IGrammarAwareElementType Float_Group_ELEMENT_TYPE = associate(FloatFactory.createFloat_GroupElementType());

	public static final IGrammarAwareElementType Float_NumberSignDigitTwoDigitTwoKeyword_0_ELEMENT_TYPE = associate(FloatFactory.createFloat_NumberSignDigitTwoDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType Float_FloatAction_1_ELEMENT_TYPE = associate(FloatFactory.createFloat_FloatAction_1ElementType());

	public static final IGrammarAwareElementType Float_ByeKeyword_2_ELEMENT_TYPE = associate(FloatFactory.createFloat_ByeKeyword_2ElementType());

	private static class UnorderedAlternativeFactory {
		public static IGrammarAwareElementType createUnorderedAlternativeElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeRule());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_GroupElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_NumberSignDigitTwoDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_NumberSignDigitTwoDigitThreeKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getNumberSignDigitTwoDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_UnorderedAlternativeAction_1ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_UnorderedAlternativeAction_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getUnorderedAlternativeAction_1());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_Alternatives_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_Val1Assignment_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_Val1Assignment_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getVal1Assignment_2_0());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_Val1IDTerminalRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_Val1IDTerminalRuleCall_2_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getVal1IDTerminalRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_Val2Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_Val2Assignment_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getVal2Assignment_2_1());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_Val2INTTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_Val2INTTerminalRuleCall_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getVal2INTTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_Val3Assignment_2_2ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_Val3Assignment_2_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getVal3Assignment_2_2());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_Val3UnorderedAlternativeValParserRuleCall_2_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_Val3UnorderedAlternativeValParserRuleCall_2_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getVal3UnorderedAlternativeValParserRuleCall_2_2_0());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_Val4Assignment_2_3ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_Val4Assignment_2_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getVal4Assignment_2_3());
		}
		public static IGrammarAwareElementType createUnorderedAlternative_Val4UnorderedAlternativeValDelegateParserRuleCall_2_3_0ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternative_Val4UnorderedAlternativeValDelegateParserRuleCall_2_3_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeAccess().getVal4UnorderedAlternativeValDelegateParserRuleCall_2_3_0());
		}
	}

	public static final IGrammarAwareElementType UnorderedAlternative_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternativeElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_Group_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_GroupElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_NumberSignDigitTwoDigitThreeKeyword_0_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_NumberSignDigitTwoDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_UnorderedAlternativeAction_1_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_UnorderedAlternativeAction_1ElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_Alternatives_2_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_Alternatives_2ElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_Val1Assignment_2_0_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_Val1Assignment_2_0ElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_Val1IDTerminalRuleCall_2_0_0_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_Val1IDTerminalRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_Val2Assignment_2_1_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_Val2Assignment_2_1ElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_Val2INTTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_Val2INTTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_Val3Assignment_2_2_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_Val3Assignment_2_2ElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_Val3UnorderedAlternativeValParserRuleCall_2_2_0_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_Val3UnorderedAlternativeValParserRuleCall_2_2_0ElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_Val4Assignment_2_3_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_Val4Assignment_2_3ElementType());

	public static final IGrammarAwareElementType UnorderedAlternative_Val4UnorderedAlternativeValDelegateParserRuleCall_2_3_0_ELEMENT_TYPE = associate(UnorderedAlternativeFactory.createUnorderedAlternative_Val4UnorderedAlternativeValDelegateParserRuleCall_2_3_0ElementType());

	private static class UnorderedAlternativeValFactory {
		public static IGrammarAwareElementType createUnorderedAlternativeValElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeVal_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeValRule());
		}
		public static IGrammarAwareElementType createUnorderedAlternativeVal_GroupElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeVal_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeValAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnorderedAlternativeVal_Kw1Keyword_0ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeVal_Kw1Keyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeValAccess().getKw1Keyword_0());
		}
		public static IGrammarAwareElementType createUnorderedAlternativeVal_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeVal_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeValAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createUnorderedAlternativeVal_ValIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeVal_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeValAccess().getValIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType UnorderedAlternativeVal_ELEMENT_TYPE = associate(UnorderedAlternativeValFactory.createUnorderedAlternativeValElementType());

	public static final IGrammarAwareElementType UnorderedAlternativeVal_Group_ELEMENT_TYPE = associate(UnorderedAlternativeValFactory.createUnorderedAlternativeVal_GroupElementType());

	public static final IGrammarAwareElementType UnorderedAlternativeVal_Kw1Keyword_0_ELEMENT_TYPE = associate(UnorderedAlternativeValFactory.createUnorderedAlternativeVal_Kw1Keyword_0ElementType());

	public static final IGrammarAwareElementType UnorderedAlternativeVal_ValAssignment_1_ELEMENT_TYPE = associate(UnorderedAlternativeValFactory.createUnorderedAlternativeVal_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType UnorderedAlternativeVal_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(UnorderedAlternativeValFactory.createUnorderedAlternativeVal_ValIDTerminalRuleCall_1_0ElementType());

	private static class UnorderedAlternativeValDelegateFactory {
		public static IGrammarAwareElementType createUnorderedAlternativeValDelegateElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeValDelegate_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeValDelegateRule());
		}
		public static IGrammarAwareElementType createUnorderedAlternativeValDelegate_UnorderedAlternativeVal2ParserRuleCallElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeValDelegate_UnorderedAlternativeVal2ParserRuleCall_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeValDelegateAccess().getUnorderedAlternativeVal2ParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType UnorderedAlternativeValDelegate_ELEMENT_TYPE = associate(UnorderedAlternativeValDelegateFactory.createUnorderedAlternativeValDelegateElementType());

	public static final IGrammarAwareElementType UnorderedAlternativeValDelegate_UnorderedAlternativeVal2ParserRuleCall_ELEMENT_TYPE = associate(UnorderedAlternativeValDelegateFactory.createUnorderedAlternativeValDelegate_UnorderedAlternativeVal2ParserRuleCallElementType());

	private static class UnorderedAlternativeVal2Factory {
		public static IGrammarAwareElementType createUnorderedAlternativeVal2ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeVal2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeVal2Rule());
		}
		public static IGrammarAwareElementType createUnorderedAlternativeVal2_GroupElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeVal2_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeVal2Access().getGroup());
		}
		public static IGrammarAwareElementType createUnorderedAlternativeVal2_Kw2Keyword_0ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeVal2_Kw2Keyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeVal2Access().getKw2Keyword_0());
		}
		public static IGrammarAwareElementType createUnorderedAlternativeVal2_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeVal2_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeVal2Access().getValAssignment_1());
		}
		public static IGrammarAwareElementType createUnorderedAlternativeVal2_ValIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedAlternativeVal2_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedAlternativeVal2Access().getValIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType UnorderedAlternativeVal2_ELEMENT_TYPE = associate(UnorderedAlternativeVal2Factory.createUnorderedAlternativeVal2ElementType());

	public static final IGrammarAwareElementType UnorderedAlternativeVal2_Group_ELEMENT_TYPE = associate(UnorderedAlternativeVal2Factory.createUnorderedAlternativeVal2_GroupElementType());

	public static final IGrammarAwareElementType UnorderedAlternativeVal2_Kw2Keyword_0_ELEMENT_TYPE = associate(UnorderedAlternativeVal2Factory.createUnorderedAlternativeVal2_Kw2Keyword_0ElementType());

	public static final IGrammarAwareElementType UnorderedAlternativeVal2_ValAssignment_1_ELEMENT_TYPE = associate(UnorderedAlternativeVal2Factory.createUnorderedAlternativeVal2_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType UnorderedAlternativeVal2_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(UnorderedAlternativeVal2Factory.createUnorderedAlternativeVal2_ValIDTerminalRuleCall_1_0ElementType());

	private static class UnorderedGroupFactory {
		public static IGrammarAwareElementType createUnorderedGroupElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupRule());
		}
		public static IGrammarAwareElementType createUnorderedGroup_GroupElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnorderedGroup_NumberSignDigitTwoDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_NumberSignDigitTwoDigitFourKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getNumberSignDigitTwoDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createUnorderedGroup_UnorderedGroup_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_UnorderedGroup_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getUnorderedGroup_1());
		}
		public static IGrammarAwareElementType createUnorderedGroup_Val1Assignment_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Val1Assignment_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getVal1Assignment_1_0());
		}
		public static IGrammarAwareElementType createUnorderedGroup_Val1IDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getVal1IDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createUnorderedGroup_Val2Assignment_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Val2Assignment_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getVal2Assignment_1_1());
		}
		public static IGrammarAwareElementType createUnorderedGroup_Val2INTTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Val2INTTerminalRuleCall_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getVal2INTTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createUnorderedGroup_Val3Assignment_1_2ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Val3Assignment_1_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getVal3Assignment_1_2());
		}
		public static IGrammarAwareElementType createUnorderedGroup_Val3UnorderedGroupValParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Val3UnorderedGroupValParserRuleCall_1_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getVal3UnorderedGroupValParserRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createUnorderedGroup_Val4Assignment_1_3ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Val4Assignment_1_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getVal4Assignment_1_3());
		}
		public static IGrammarAwareElementType createUnorderedGroup_Val4UnorderedGroupValDelegateParserRuleCall_1_3_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Val4UnorderedGroupValDelegateParserRuleCall_1_3_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getVal4UnorderedGroupValDelegateParserRuleCall_1_3_0());
		}
	}

	public static final IGrammarAwareElementType UnorderedGroup_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroupElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Group_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_GroupElementType());

	public static final IGrammarAwareElementType UnorderedGroup_NumberSignDigitTwoDigitFourKeyword_0_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_NumberSignDigitTwoDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_UnorderedGroup_1_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_UnorderedGroup_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Val1Assignment_1_0_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_Val1Assignment_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_Val1IDTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Val2Assignment_1_1_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_Val2Assignment_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Val2INTTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_Val2INTTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Val3Assignment_1_2_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_Val3Assignment_1_2ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Val3UnorderedGroupValParserRuleCall_1_2_0_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_Val3UnorderedGroupValParserRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Val4Assignment_1_3_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_Val4Assignment_1_3ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Val4UnorderedGroupValDelegateParserRuleCall_1_3_0_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_Val4UnorderedGroupValDelegateParserRuleCall_1_3_0ElementType());

	private static class UnorderedGroupValFactory {
		public static IGrammarAwareElementType createUnorderedGroupValElementType() {
			return new IGrammarAwareElementType("UnorderedGroupVal_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupValRule());
		}
		public static IGrammarAwareElementType createUnorderedGroupVal_GroupElementType() {
			return new IGrammarAwareElementType("UnorderedGroupVal_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupValAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnorderedGroupVal_Kw1Keyword_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupVal_Kw1Keyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupValAccess().getKw1Keyword_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupVal_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupVal_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupValAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createUnorderedGroupVal_ValIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupVal_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupValAccess().getValIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType UnorderedGroupVal_ELEMENT_TYPE = associate(UnorderedGroupValFactory.createUnorderedGroupValElementType());

	public static final IGrammarAwareElementType UnorderedGroupVal_Group_ELEMENT_TYPE = associate(UnorderedGroupValFactory.createUnorderedGroupVal_GroupElementType());

	public static final IGrammarAwareElementType UnorderedGroupVal_Kw1Keyword_0_ELEMENT_TYPE = associate(UnorderedGroupValFactory.createUnorderedGroupVal_Kw1Keyword_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupVal_ValAssignment_1_ELEMENT_TYPE = associate(UnorderedGroupValFactory.createUnorderedGroupVal_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroupVal_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(UnorderedGroupValFactory.createUnorderedGroupVal_ValIDTerminalRuleCall_1_0ElementType());

	private static class UnorderedGroupValDelegateFactory {
		public static IGrammarAwareElementType createUnorderedGroupValDelegateElementType() {
			return new IGrammarAwareElementType("UnorderedGroupValDelegate_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupValDelegateRule());
		}
		public static IGrammarAwareElementType createUnorderedGroupValDelegate_UnorderedGroupVal2ParserRuleCallElementType() {
			return new IGrammarAwareElementType("UnorderedGroupValDelegate_UnorderedGroupVal2ParserRuleCall_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupValDelegateAccess().getUnorderedGroupVal2ParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType UnorderedGroupValDelegate_ELEMENT_TYPE = associate(UnorderedGroupValDelegateFactory.createUnorderedGroupValDelegateElementType());

	public static final IGrammarAwareElementType UnorderedGroupValDelegate_UnorderedGroupVal2ParserRuleCall_ELEMENT_TYPE = associate(UnorderedGroupValDelegateFactory.createUnorderedGroupValDelegate_UnorderedGroupVal2ParserRuleCallElementType());

	private static class UnorderedGroupVal2Factory {
		public static IGrammarAwareElementType createUnorderedGroupVal2ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupVal2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupVal2Rule());
		}
		public static IGrammarAwareElementType createUnorderedGroupVal2_GroupElementType() {
			return new IGrammarAwareElementType("UnorderedGroupVal2_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupVal2Access().getGroup());
		}
		public static IGrammarAwareElementType createUnorderedGroupVal2_Kw2Keyword_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupVal2_Kw2Keyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupVal2Access().getKw2Keyword_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupVal2_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupVal2_ValAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupVal2Access().getValAssignment_1());
		}
		public static IGrammarAwareElementType createUnorderedGroupVal2_ValIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupVal2_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupVal2Access().getValIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType UnorderedGroupVal2_ELEMENT_TYPE = associate(UnorderedGroupVal2Factory.createUnorderedGroupVal2ElementType());

	public static final IGrammarAwareElementType UnorderedGroupVal2_Group_ELEMENT_TYPE = associate(UnorderedGroupVal2Factory.createUnorderedGroupVal2_GroupElementType());

	public static final IGrammarAwareElementType UnorderedGroupVal2_Kw2Keyword_0_ELEMENT_TYPE = associate(UnorderedGroupVal2Factory.createUnorderedGroupVal2_Kw2Keyword_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupVal2_ValAssignment_1_ELEMENT_TYPE = associate(UnorderedGroupVal2Factory.createUnorderedGroupVal2_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroupVal2_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(UnorderedGroupVal2Factory.createUnorderedGroupVal2_ValIDTerminalRuleCall_1_0ElementType());

	private static class UnorderedGroupOptionalFactory {
		public static IGrammarAwareElementType createUnorderedGroupOptionalElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalRule());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_GroupElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_NumberSignDigitTwoDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_NumberSignDigitTwoDigitFiveKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getNumberSignDigitTwoDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_UnorderedGroupOptionalAction_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_UnorderedGroupOptionalAction_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getUnorderedGroupOptionalAction_1());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_UnorderedGroup_2ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_UnorderedGroup_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getUnorderedGroup_2());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Group_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Group_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getGroup_2_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Kw1Keyword_2_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Kw1Keyword_2_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getKw1Keyword_2_0_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Val1Assignment_2_0_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Val1Assignment_2_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getVal1Assignment_2_0_1());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Val1IDTerminalRuleCall_2_0_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Val1IDTerminalRuleCall_2_0_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getVal1IDTerminalRuleCall_2_0_1_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Group_2_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Group_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getGroup_2_1());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Kw2Keyword_2_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Kw2Keyword_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getKw2Keyword_2_1_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Va2Assignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Va2Assignment_2_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getVa2Assignment_2_1_1());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Va2IDTerminalRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Va2IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getVa2IDTerminalRuleCall_2_1_1_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Group_2_2ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Group_2_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getGroup_2_2());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Kw3Keyword_2_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Kw3Keyword_2_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getKw3Keyword_2_2_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Val3Assignment_2_2_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Val3Assignment_2_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getVal3Assignment_2_2_1());
		}
		public static IGrammarAwareElementType createUnorderedGroupOptional_Val3IDTerminalRuleCall_2_2_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupOptional_Val3IDTerminalRuleCall_2_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupOptionalAccess().getVal3IDTerminalRuleCall_2_2_1_0());
		}
	}

	public static final IGrammarAwareElementType UnorderedGroupOptional_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptionalElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Group_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_GroupElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_NumberSignDigitTwoDigitFiveKeyword_0_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_NumberSignDigitTwoDigitFiveKeyword_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_UnorderedGroupOptionalAction_1_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_UnorderedGroupOptionalAction_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_UnorderedGroup_2_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_UnorderedGroup_2ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Group_2_0_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Group_2_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Kw1Keyword_2_0_0_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Kw1Keyword_2_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Val1Assignment_2_0_1_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Val1Assignment_2_0_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Val1IDTerminalRuleCall_2_0_1_0_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Val1IDTerminalRuleCall_2_0_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Group_2_1_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Group_2_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Kw2Keyword_2_1_0_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Kw2Keyword_2_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Va2Assignment_2_1_1_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Va2Assignment_2_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Va2IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Va2IDTerminalRuleCall_2_1_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Group_2_2_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Group_2_2ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Kw3Keyword_2_2_0_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Kw3Keyword_2_2_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Val3Assignment_2_2_1_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Val3Assignment_2_2_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroupOptional_Val3IDTerminalRuleCall_2_2_1_0_ELEMENT_TYPE = associate(UnorderedGroupOptionalFactory.createUnorderedGroupOptional_Val3IDTerminalRuleCall_2_2_1_0ElementType());

	private static class UnorderedGroupBooleanFactory {
		public static IGrammarAwareElementType createUnorderedGroupBooleanElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanRule());
		}
		public static IGrammarAwareElementType createUnorderedGroupBoolean_GroupElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnorderedGroupBoolean_NumberSignDigitTwoDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_NumberSignDigitTwoDigitSixKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanAccess().getNumberSignDigitTwoDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupBoolean_UnorderedGroupBooleanAction_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_UnorderedGroupBooleanAction_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanAccess().getUnorderedGroupBooleanAction_1());
		}
		public static IGrammarAwareElementType createUnorderedGroupBoolean_UnorderedGroup_2ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_UnorderedGroup_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
		}
		public static IGrammarAwareElementType createUnorderedGroupBoolean_Val1Assignment_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_Val1Assignment_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanAccess().getVal1Assignment_2_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupBoolean_Val1Kw1Keyword_2_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_Val1Kw1Keyword_2_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanAccess().getVal1Kw1Keyword_2_0_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupBoolean_Val2Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_Val2Assignment_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanAccess().getVal2Assignment_2_1());
		}
		public static IGrammarAwareElementType createUnorderedGroupBoolean_Val2Kw2Keyword_2_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_Val2Kw2Keyword_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanAccess().getVal2Kw2Keyword_2_1_0());
		}
		public static IGrammarAwareElementType createUnorderedGroupBoolean_Val3Assignment_2_2ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_Val3Assignment_2_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanAccess().getVal3Assignment_2_2());
		}
		public static IGrammarAwareElementType createUnorderedGroupBoolean_Val3Kw3Keyword_2_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroupBoolean_Val3Kw3Keyword_2_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupBooleanAccess().getVal3Kw3Keyword_2_2_0());
		}
	}

	public static final IGrammarAwareElementType UnorderedGroupBoolean_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBooleanElementType());

	public static final IGrammarAwareElementType UnorderedGroupBoolean_Group_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBoolean_GroupElementType());

	public static final IGrammarAwareElementType UnorderedGroupBoolean_NumberSignDigitTwoDigitSixKeyword_0_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBoolean_NumberSignDigitTwoDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupBoolean_UnorderedGroupBooleanAction_1_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBoolean_UnorderedGroupBooleanAction_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroupBoolean_UnorderedGroup_2_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBoolean_UnorderedGroup_2ElementType());

	public static final IGrammarAwareElementType UnorderedGroupBoolean_Val1Assignment_2_0_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBoolean_Val1Assignment_2_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupBoolean_Val1Kw1Keyword_2_0_0_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBoolean_Val1Kw1Keyword_2_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupBoolean_Val2Assignment_2_1_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBoolean_Val2Assignment_2_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroupBoolean_Val2Kw2Keyword_2_1_0_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBoolean_Val2Kw2Keyword_2_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroupBoolean_Val3Assignment_2_2_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBoolean_Val3Assignment_2_2ElementType());

	public static final IGrammarAwareElementType UnorderedGroupBoolean_Val3Kw3Keyword_2_2_0_ELEMENT_TYPE = associate(UnorderedGroupBooleanFactory.createUnorderedGroupBoolean_Val3Kw3Keyword_2_2_0ElementType());

	private static class Complex1Factory {
		public static IGrammarAwareElementType createComplex1ElementType() {
			return new IGrammarAwareElementType("Complex1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Rule());
		}
		public static IGrammarAwareElementType createComplex1_GroupElementType() {
			return new IGrammarAwareElementType("Complex1_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getGroup());
		}
		public static IGrammarAwareElementType createComplex1_NumberSignDigitTwoDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("Complex1_NumberSignDigitTwoDigitSevenKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getNumberSignDigitTwoDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createComplex1_Complex1Action_1ElementType() {
			return new IGrammarAwareElementType("Complex1_Complex1Action_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getComplex1Action_1());
		}
		public static IGrammarAwareElementType createComplex1_Group_2ElementType() {
			return new IGrammarAwareElementType("Complex1_Group_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getGroup_2());
		}
		public static IGrammarAwareElementType createComplex1_Kw1Keyword_2_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Kw1Keyword_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getKw1Keyword_2_0());
		}
		public static IGrammarAwareElementType createComplex1_Val1Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("Complex1_Val1Assignment_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal1Assignment_2_1());
		}
		public static IGrammarAwareElementType createComplex1_Val1IDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal1IDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createComplex1_Group_3ElementType() {
			return new IGrammarAwareElementType("Complex1_Group_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getGroup_3());
		}
		public static IGrammarAwareElementType createComplex1_Kw2Keyword_3_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Kw2Keyword_3_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getKw2Keyword_3_0());
		}
		public static IGrammarAwareElementType createComplex1_Val2Assignment_3_1ElementType() {
			return new IGrammarAwareElementType("Complex1_Val2Assignment_3_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal2Assignment_3_1());
		}
		public static IGrammarAwareElementType createComplex1_Val2IDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Val2IDTerminalRuleCall_3_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal2IDTerminalRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createComplex1_Alternatives_4ElementType() {
			return new IGrammarAwareElementType("Complex1_Alternatives_4_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getAlternatives_4());
		}
		public static IGrammarAwareElementType createComplex1_Group_4_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Group_4_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getGroup_4_0());
		}
		public static IGrammarAwareElementType createComplex1_Kw3Keyword_4_0_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Kw3Keyword_4_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getKw3Keyword_4_0_0());
		}
		public static IGrammarAwareElementType createComplex1_Val3Assignment_4_0_1ElementType() {
			return new IGrammarAwareElementType("Complex1_Val3Assignment_4_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal3Assignment_4_0_1());
		}
		public static IGrammarAwareElementType createComplex1_Val3IDTerminalRuleCall_4_0_1_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Val3IDTerminalRuleCall_4_0_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal3IDTerminalRuleCall_4_0_1_0());
		}
		public static IGrammarAwareElementType createComplex1_Group_4_1ElementType() {
			return new IGrammarAwareElementType("Complex1_Group_4_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getGroup_4_1());
		}
		public static IGrammarAwareElementType createComplex1_Kw4Keyword_4_1_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Kw4Keyword_4_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getKw4Keyword_4_1_0());
		}
		public static IGrammarAwareElementType createComplex1_Val4Assignment_4_1_1ElementType() {
			return new IGrammarAwareElementType("Complex1_Val4Assignment_4_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal4Assignment_4_1_1());
		}
		public static IGrammarAwareElementType createComplex1_Val4IDTerminalRuleCall_4_1_1_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Val4IDTerminalRuleCall_4_1_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal4IDTerminalRuleCall_4_1_1_0());
		}
		public static IGrammarAwareElementType createComplex1_Group_4_2ElementType() {
			return new IGrammarAwareElementType("Complex1_Group_4_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getGroup_4_2());
		}
		public static IGrammarAwareElementType createComplex1_Kw5Keyword_4_2_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Kw5Keyword_4_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getKw5Keyword_4_2_0());
		}
		public static IGrammarAwareElementType createComplex1_Val5Assignment_4_2_1ElementType() {
			return new IGrammarAwareElementType("Complex1_Val5Assignment_4_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal5Assignment_4_2_1());
		}
		public static IGrammarAwareElementType createComplex1_Val5IDTerminalRuleCall_4_2_1_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Val5IDTerminalRuleCall_4_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal5IDTerminalRuleCall_4_2_1_0());
		}
		public static IGrammarAwareElementType createComplex1_Group_4_3ElementType() {
			return new IGrammarAwareElementType("Complex1_Group_4_3_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getGroup_4_3());
		}
		public static IGrammarAwareElementType createComplex1_Kw6Keyword_4_3_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Kw6Keyword_4_3_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getKw6Keyword_4_3_0());
		}
		public static IGrammarAwareElementType createComplex1_Val6Assignment_4_3_1ElementType() {
			return new IGrammarAwareElementType("Complex1_Val6Assignment_4_3_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal6Assignment_4_3_1());
		}
		public static IGrammarAwareElementType createComplex1_Val6IDTerminalRuleCall_4_3_1_0ElementType() {
			return new IGrammarAwareElementType("Complex1_Val6IDTerminalRuleCall_4_3_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComplex1Access().getVal6IDTerminalRuleCall_4_3_1_0());
		}
	}

	public static final IGrammarAwareElementType Complex1_ELEMENT_TYPE = associate(Complex1Factory.createComplex1ElementType());

	public static final IGrammarAwareElementType Complex1_Group_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_GroupElementType());

	public static final IGrammarAwareElementType Complex1_NumberSignDigitTwoDigitSevenKeyword_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_NumberSignDigitTwoDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType Complex1_Complex1Action_1_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Complex1Action_1ElementType());

	public static final IGrammarAwareElementType Complex1_Group_2_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Group_2ElementType());

	public static final IGrammarAwareElementType Complex1_Kw1Keyword_2_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Kw1Keyword_2_0ElementType());

	public static final IGrammarAwareElementType Complex1_Val1Assignment_2_1_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val1Assignment_2_1ElementType());

	public static final IGrammarAwareElementType Complex1_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val1IDTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Complex1_Group_3_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Group_3ElementType());

	public static final IGrammarAwareElementType Complex1_Kw2Keyword_3_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Kw2Keyword_3_0ElementType());

	public static final IGrammarAwareElementType Complex1_Val2Assignment_3_1_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val2Assignment_3_1ElementType());

	public static final IGrammarAwareElementType Complex1_Val2IDTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val2IDTerminalRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType Complex1_Alternatives_4_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Alternatives_4ElementType());

	public static final IGrammarAwareElementType Complex1_Group_4_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Group_4_0ElementType());

	public static final IGrammarAwareElementType Complex1_Kw3Keyword_4_0_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Kw3Keyword_4_0_0ElementType());

	public static final IGrammarAwareElementType Complex1_Val3Assignment_4_0_1_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val3Assignment_4_0_1ElementType());

	public static final IGrammarAwareElementType Complex1_Val3IDTerminalRuleCall_4_0_1_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val3IDTerminalRuleCall_4_0_1_0ElementType());

	public static final IGrammarAwareElementType Complex1_Group_4_1_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Group_4_1ElementType());

	public static final IGrammarAwareElementType Complex1_Kw4Keyword_4_1_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Kw4Keyword_4_1_0ElementType());

	public static final IGrammarAwareElementType Complex1_Val4Assignment_4_1_1_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val4Assignment_4_1_1ElementType());

	public static final IGrammarAwareElementType Complex1_Val4IDTerminalRuleCall_4_1_1_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val4IDTerminalRuleCall_4_1_1_0ElementType());

	public static final IGrammarAwareElementType Complex1_Group_4_2_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Group_4_2ElementType());

	public static final IGrammarAwareElementType Complex1_Kw5Keyword_4_2_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Kw5Keyword_4_2_0ElementType());

	public static final IGrammarAwareElementType Complex1_Val5Assignment_4_2_1_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val5Assignment_4_2_1ElementType());

	public static final IGrammarAwareElementType Complex1_Val5IDTerminalRuleCall_4_2_1_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val5IDTerminalRuleCall_4_2_1_0ElementType());

	public static final IGrammarAwareElementType Complex1_Group_4_3_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Group_4_3ElementType());

	public static final IGrammarAwareElementType Complex1_Kw6Keyword_4_3_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Kw6Keyword_4_3_0ElementType());

	public static final IGrammarAwareElementType Complex1_Val6Assignment_4_3_1_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val6Assignment_4_3_1ElementType());

	public static final IGrammarAwareElementType Complex1_Val6IDTerminalRuleCall_4_3_1_0_ELEMENT_TYPE = associate(Complex1Factory.createComplex1_Val6IDTerminalRuleCall_4_3_1_0ElementType());

	private static class OptionalDoubleFactory {
		public static IGrammarAwareElementType createOptionalDoubleElementType() {
			return new IGrammarAwareElementType("OptionalDouble_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalDoubleRule());
		}
		public static IGrammarAwareElementType createOptionalDouble_GroupElementType() {
			return new IGrammarAwareElementType("OptionalDouble_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalDoubleAccess().getGroup());
		}
		public static IGrammarAwareElementType createOptionalDouble_NumberSignDigitTwoDigitEightKeyword_0ElementType() {
			return new IGrammarAwareElementType("OptionalDouble_NumberSignDigitTwoDigitEightKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalDoubleAccess().getNumberSignDigitTwoDigitEightKeyword_0());
		}
		public static IGrammarAwareElementType createOptionalDouble_Double0Assignment_1ElementType() {
			return new IGrammarAwareElementType("OptionalDouble_Double0Assignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalDoubleAccess().getDouble0Assignment_1());
		}
		public static IGrammarAwareElementType createOptionalDouble_Double0DOUBLEParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("OptionalDouble_Double0DOUBLEParserRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalDoubleAccess().getDouble0DOUBLEParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createOptionalDouble_Group_2ElementType() {
			return new IGrammarAwareElementType("OptionalDouble_Group_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalDoubleAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createOptionalDouble_Double1Assignment_2_0ElementType() {
			return new IGrammarAwareElementType("OptionalDouble_Double1Assignment_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalDoubleAccess().getDouble1Assignment_2_0());
		}
		public static IGrammarAwareElementType createOptionalDouble_Double1DOUBLEParserRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("OptionalDouble_Double1DOUBLEParserRuleCall_2_0_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalDoubleAccess().getDouble1DOUBLEParserRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createOptionalDouble_Double2Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("OptionalDouble_Double2Assignment_2_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalDoubleAccess().getDouble2Assignment_2_1());
		}
		public static IGrammarAwareElementType createOptionalDouble_Double2DOUBLEParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("OptionalDouble_Double2DOUBLEParserRuleCall_2_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOptionalDoubleAccess().getDouble2DOUBLEParserRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType OptionalDouble_ELEMENT_TYPE = associate(OptionalDoubleFactory.createOptionalDoubleElementType());

	public static final IGrammarAwareElementType OptionalDouble_Group_ELEMENT_TYPE = associate(OptionalDoubleFactory.createOptionalDouble_GroupElementType());

	public static final IGrammarAwareElementType OptionalDouble_NumberSignDigitTwoDigitEightKeyword_0_ELEMENT_TYPE = associate(OptionalDoubleFactory.createOptionalDouble_NumberSignDigitTwoDigitEightKeyword_0ElementType());

	public static final IGrammarAwareElementType OptionalDouble_Double0Assignment_1_ELEMENT_TYPE = associate(OptionalDoubleFactory.createOptionalDouble_Double0Assignment_1ElementType());

	public static final IGrammarAwareElementType OptionalDouble_Double0DOUBLEParserRuleCall_1_0_ELEMENT_TYPE = associate(OptionalDoubleFactory.createOptionalDouble_Double0DOUBLEParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType OptionalDouble_Group_2_ELEMENT_TYPE = associate(OptionalDoubleFactory.createOptionalDouble_Group_2ElementType());

	public static final IGrammarAwareElementType OptionalDouble_Double1Assignment_2_0_ELEMENT_TYPE = associate(OptionalDoubleFactory.createOptionalDouble_Double1Assignment_2_0ElementType());

	public static final IGrammarAwareElementType OptionalDouble_Double1DOUBLEParserRuleCall_2_0_0_ELEMENT_TYPE = associate(OptionalDoubleFactory.createOptionalDouble_Double1DOUBLEParserRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType OptionalDouble_Double2Assignment_2_1_ELEMENT_TYPE = associate(OptionalDoubleFactory.createOptionalDouble_Double2Assignment_2_1ElementType());

	public static final IGrammarAwareElementType OptionalDouble_Double2DOUBLEParserRuleCall_2_1_0_ELEMENT_TYPE = associate(OptionalDoubleFactory.createOptionalDouble_Double2DOUBLEParserRuleCall_2_1_0ElementType());

	private static class DOUBLEFactory {
		public static IGrammarAwareElementType createDOUBLEElementType() {
			return new IGrammarAwareElementType("DOUBLE_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDOUBLERule());
		}
		public static IGrammarAwareElementType createDOUBLE_GroupElementType() {
			return new IGrammarAwareElementType("DOUBLE_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDOUBLEAccess().getGroup());
		}
		public static IGrammarAwareElementType createDOUBLE_INTTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("DOUBLE_INTTerminalRuleCall_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDOUBLEAccess().getINTTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createDOUBLE_Group_1ElementType() {
			return new IGrammarAwareElementType("DOUBLE_Group_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDOUBLEAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createDOUBLE_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("DOUBLE_FullStopKeyword_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDOUBLEAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createDOUBLE_INTTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("DOUBLE_INTTerminalRuleCall_1_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDOUBLEAccess().getINTTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType DOUBLE_ELEMENT_TYPE = associate(DOUBLEFactory.createDOUBLEElementType());

	public static final IGrammarAwareElementType DOUBLE_Group_ELEMENT_TYPE = associate(DOUBLEFactory.createDOUBLE_GroupElementType());

	public static final IGrammarAwareElementType DOUBLE_INTTerminalRuleCall_0_ELEMENT_TYPE = associate(DOUBLEFactory.createDOUBLE_INTTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType DOUBLE_Group_1_ELEMENT_TYPE = associate(DOUBLEFactory.createDOUBLE_Group_1ElementType());

	public static final IGrammarAwareElementType DOUBLE_FullStopKeyword_1_0_ELEMENT_TYPE = associate(DOUBLEFactory.createDOUBLE_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType DOUBLE_INTTerminalRuleCall_1_1_ELEMENT_TYPE = associate(DOUBLEFactory.createDOUBLE_INTTerminalRuleCall_1_1ElementType());

	private static class NullValueGeneratedFactory {
		public static IGrammarAwareElementType createNullValueGeneratedElementType() {
			return new IGrammarAwareElementType("NullValueGenerated_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueGeneratedRule());
		}
		public static IGrammarAwareElementType createNullValueGenerated_GroupElementType() {
			return new IGrammarAwareElementType("NullValueGenerated_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueGeneratedAccess().getGroup());
		}
		public static IGrammarAwareElementType createNullValueGenerated_NumberSignDigitTwoDigitNineKeyword_0ElementType() {
			return new IGrammarAwareElementType("NullValueGenerated_NumberSignDigitTwoDigitNineKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueGeneratedAccess().getNumberSignDigitTwoDigitNineKeyword_0());
		}
		public static IGrammarAwareElementType createNullValueGenerated_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("NullValueGenerated_ValueAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueGeneratedAccess().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createNullValueGenerated_ValueNULL_STRINGParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NullValueGenerated_ValueNULL_STRINGParserRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueGeneratedAccess().getValueNULL_STRINGParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType NullValueGenerated_ELEMENT_TYPE = associate(NullValueGeneratedFactory.createNullValueGeneratedElementType());

	public static final IGrammarAwareElementType NullValueGenerated_Group_ELEMENT_TYPE = associate(NullValueGeneratedFactory.createNullValueGenerated_GroupElementType());

	public static final IGrammarAwareElementType NullValueGenerated_NumberSignDigitTwoDigitNineKeyword_0_ELEMENT_TYPE = associate(NullValueGeneratedFactory.createNullValueGenerated_NumberSignDigitTwoDigitNineKeyword_0ElementType());

	public static final IGrammarAwareElementType NullValueGenerated_ValueAssignment_1_ELEMENT_TYPE = associate(NullValueGeneratedFactory.createNullValueGenerated_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType NullValueGenerated_ValueNULL_STRINGParserRuleCall_1_0_ELEMENT_TYPE = associate(NullValueGeneratedFactory.createNullValueGenerated_ValueNULL_STRINGParserRuleCall_1_0ElementType());

	private static class NullValueInterpretedFactory {
		public static IGrammarAwareElementType createNullValueInterpretedElementType() {
			return new IGrammarAwareElementType("NullValueInterpreted_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueInterpretedRule());
		}
		public static IGrammarAwareElementType createNullValueInterpreted_GroupElementType() {
			return new IGrammarAwareElementType("NullValueInterpreted_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueInterpretedAccess().getGroup());
		}
		public static IGrammarAwareElementType createNullValueInterpreted_NumberSignDigitThreeDigitZeroKeyword_0ElementType() {
			return new IGrammarAwareElementType("NullValueInterpreted_NumberSignDigitThreeDigitZeroKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueInterpretedAccess().getNumberSignDigitThreeDigitZeroKeyword_0());
		}
		public static IGrammarAwareElementType createNullValueInterpreted_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("NullValueInterpreted_ValueAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueInterpretedAccess().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createNullValueInterpreted_ValueNULL_STRINGParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NullValueInterpreted_ValueNULL_STRINGParserRuleCall_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueInterpretedAccess().getValueNULL_STRINGParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createNullValueInterpreted_FooAssignment_2ElementType() {
			return new IGrammarAwareElementType("NullValueInterpreted_FooAssignment_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueInterpretedAccess().getFooAssignment_2());
		}
		public static IGrammarAwareElementType createNullValueInterpreted_FooIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("NullValueInterpreted_FooIDTerminalRuleCall_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullValueInterpretedAccess().getFooIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType NullValueInterpreted_ELEMENT_TYPE = associate(NullValueInterpretedFactory.createNullValueInterpretedElementType());

	public static final IGrammarAwareElementType NullValueInterpreted_Group_ELEMENT_TYPE = associate(NullValueInterpretedFactory.createNullValueInterpreted_GroupElementType());

	public static final IGrammarAwareElementType NullValueInterpreted_NumberSignDigitThreeDigitZeroKeyword_0_ELEMENT_TYPE = associate(NullValueInterpretedFactory.createNullValueInterpreted_NumberSignDigitThreeDigitZeroKeyword_0ElementType());

	public static final IGrammarAwareElementType NullValueInterpreted_ValueAssignment_1_ELEMENT_TYPE = associate(NullValueInterpretedFactory.createNullValueInterpreted_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType NullValueInterpreted_ValueNULL_STRINGParserRuleCall_1_0_ELEMENT_TYPE = associate(NullValueInterpretedFactory.createNullValueInterpreted_ValueNULL_STRINGParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType NullValueInterpreted_FooAssignment_2_ELEMENT_TYPE = associate(NullValueInterpretedFactory.createNullValueInterpreted_FooAssignment_2ElementType());

	public static final IGrammarAwareElementType NullValueInterpreted_FooIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(NullValueInterpretedFactory.createNullValueInterpreted_FooIDTerminalRuleCall_2_0ElementType());

	private static class NULL_STRINGFactory {
		public static IGrammarAwareElementType createNULL_STRINGElementType() {
			return new IGrammarAwareElementType("NULL_STRING_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNULL_STRINGRule());
		}
		public static IGrammarAwareElementType createNULL_STRING_STRINGTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("NULL_STRING_STRINGTerminalRuleCall_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNULL_STRINGAccess().getSTRINGTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType NULL_STRING_ELEMENT_TYPE = associate(NULL_STRINGFactory.createNULL_STRINGElementType());

	public static final IGrammarAwareElementType NULL_STRING_STRINGTerminalRuleCall_ELEMENT_TYPE = associate(NULL_STRINGFactory.createNULL_STRING_STRINGTerminalRuleCallElementType());

	private static class NullCrossRefGeneratedFactory {
		public static IGrammarAwareElementType createNullCrossRefGeneratedElementType() {
			return new IGrammarAwareElementType("NullCrossRefGenerated_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefGeneratedRule());
		}
		public static IGrammarAwareElementType createNullCrossRefGenerated_GroupElementType() {
			return new IGrammarAwareElementType("NullCrossRefGenerated_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefGeneratedAccess().getGroup());
		}
		public static IGrammarAwareElementType createNullCrossRefGenerated_NumberSignDigitThreeDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("NullCrossRefGenerated_NumberSignDigitThreeDigitOneKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefGeneratedAccess().getNumberSignDigitThreeDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createNullCrossRefGenerated_RefAssignment_1ElementType() {
			return new IGrammarAwareElementType("NullCrossRefGenerated_RefAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefGeneratedAccess().getRefAssignment_1());
		}
		public static IGrammarAwareElementType createNullCrossRefGenerated_RefEObjectCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("NullCrossRefGenerated_RefEObjectCrossReference_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefGeneratedAccess().getRefEObjectCrossReference_1_0());
		}
		public static IGrammarAwareElementType createNullCrossRefGenerated_RefEObjectIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("NullCrossRefGenerated_RefEObjectIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefGeneratedAccess().getRefEObjectIDTerminalRuleCall_1_0_1());
		}
	}

	public static final IGrammarAwareElementType NullCrossRefGenerated_ELEMENT_TYPE = associate(NullCrossRefGeneratedFactory.createNullCrossRefGeneratedElementType());

	public static final IGrammarAwareElementType NullCrossRefGenerated_Group_ELEMENT_TYPE = associate(NullCrossRefGeneratedFactory.createNullCrossRefGenerated_GroupElementType());

	public static final IGrammarAwareElementType NullCrossRefGenerated_NumberSignDigitThreeDigitOneKeyword_0_ELEMENT_TYPE = associate(NullCrossRefGeneratedFactory.createNullCrossRefGenerated_NumberSignDigitThreeDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType NullCrossRefGenerated_RefAssignment_1_ELEMENT_TYPE = associate(NullCrossRefGeneratedFactory.createNullCrossRefGenerated_RefAssignment_1ElementType());

	public static final IGrammarAwareElementType NullCrossRefGenerated_RefEObjectCrossReference_1_0_ELEMENT_TYPE = associate(NullCrossRefGeneratedFactory.createNullCrossRefGenerated_RefEObjectCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType NullCrossRefGenerated_RefEObjectIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(NullCrossRefGeneratedFactory.createNullCrossRefGenerated_RefEObjectIDTerminalRuleCall_1_0_1ElementType());

	private static class NullCrossRefInterpretedFactory {
		public static IGrammarAwareElementType createNullCrossRefInterpretedElementType() {
			return new IGrammarAwareElementType("NullCrossRefInterpreted_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefInterpretedRule());
		}
		public static IGrammarAwareElementType createNullCrossRefInterpreted_GroupElementType() {
			return new IGrammarAwareElementType("NullCrossRefInterpreted_Group_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefInterpretedAccess().getGroup());
		}
		public static IGrammarAwareElementType createNullCrossRefInterpreted_NumberSignDigitThreeDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("NullCrossRefInterpreted_NumberSignDigitThreeDigitTwoKeyword_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefInterpretedAccess().getNumberSignDigitThreeDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createNullCrossRefInterpreted_RefAssignment_1ElementType() {
			return new IGrammarAwareElementType("NullCrossRefInterpreted_RefAssignment_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefInterpretedAccess().getRefAssignment_1());
		}
		public static IGrammarAwareElementType createNullCrossRefInterpreted_RefEObjectCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("NullCrossRefInterpreted_RefEObjectCrossReference_1_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefInterpretedAccess().getRefEObjectCrossReference_1_0());
		}
		public static IGrammarAwareElementType createNullCrossRefInterpreted_RefEObjectIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("NullCrossRefInterpreted_RefEObjectIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefInterpretedAccess().getRefEObjectIDTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createNullCrossRefInterpreted_FooAssignment_2ElementType() {
			return new IGrammarAwareElementType("NullCrossRefInterpreted_FooAssignment_2_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefInterpretedAccess().getFooAssignment_2());
		}
		public static IGrammarAwareElementType createNullCrossRefInterpreted_FooIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("NullCrossRefInterpreted_FooIDTerminalRuleCall_2_0_ELEMENT_TYPE", SequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNullCrossRefInterpretedAccess().getFooIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType NullCrossRefInterpreted_ELEMENT_TYPE = associate(NullCrossRefInterpretedFactory.createNullCrossRefInterpretedElementType());

	public static final IGrammarAwareElementType NullCrossRefInterpreted_Group_ELEMENT_TYPE = associate(NullCrossRefInterpretedFactory.createNullCrossRefInterpreted_GroupElementType());

	public static final IGrammarAwareElementType NullCrossRefInterpreted_NumberSignDigitThreeDigitTwoKeyword_0_ELEMENT_TYPE = associate(NullCrossRefInterpretedFactory.createNullCrossRefInterpreted_NumberSignDigitThreeDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType NullCrossRefInterpreted_RefAssignment_1_ELEMENT_TYPE = associate(NullCrossRefInterpretedFactory.createNullCrossRefInterpreted_RefAssignment_1ElementType());

	public static final IGrammarAwareElementType NullCrossRefInterpreted_RefEObjectCrossReference_1_0_ELEMENT_TYPE = associate(NullCrossRefInterpretedFactory.createNullCrossRefInterpreted_RefEObjectCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType NullCrossRefInterpreted_RefEObjectIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(NullCrossRefInterpretedFactory.createNullCrossRefInterpreted_RefEObjectIDTerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType NullCrossRefInterpreted_FooAssignment_2_ELEMENT_TYPE = associate(NullCrossRefInterpretedFactory.createNullCrossRefInterpreted_FooAssignment_2ElementType());

	public static final IGrammarAwareElementType NullCrossRefInterpreted_FooIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(NullCrossRefInterpretedFactory.createNullCrossRefInterpreted_FooIDTerminalRuleCall_2_0ElementType());

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

	public IGrammarAwareElementType getModel_X6List1ParserRuleCall_5_0ElementType() {
		return Model_X6List1ParserRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X7Assignment_6ElementType() {
		return Model_X7Assignment_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X7List2ParserRuleCall_6_0ElementType() {
		return Model_X7List2ParserRuleCall_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X8Assignment_7ElementType() {
		return Model_X8Assignment_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X8AltList1ParserRuleCall_7_0ElementType() {
		return Model_X8AltList1ParserRuleCall_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X9Assignment_8ElementType() {
		return Model_X9Assignment_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X9AltList2ParserRuleCall_8_0ElementType() {
		return Model_X9AltList2ParserRuleCall_8_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X10Assignment_9ElementType() {
		return Model_X10Assignment_9_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X10SingleKeywordsParserRuleCall_9_0ElementType() {
		return Model_X10SingleKeywordsParserRuleCall_9_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X11Assignment_10ElementType() {
		return Model_X11Assignment_10_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X11SingleKeywordsOrIDParserRuleCall_10_0ElementType() {
		return Model_X11SingleKeywordsOrIDParserRuleCall_10_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X12Assignment_11ElementType() {
		return Model_X12Assignment_11_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X12SingleTerminalsParserRuleCall_11_0ElementType() {
		return Model_X12SingleTerminalsParserRuleCall_11_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X10Assignment_12ElementType() {
		return Model_X10Assignment_12_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X10MultiKeywordsParserRuleCall_12_0ElementType() {
		return Model_X10MultiKeywordsParserRuleCall_12_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X11Assignment_13ElementType() {
		return Model_X11Assignment_13_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X11MultiKeywordsOrIDParserRuleCall_13_0ElementType() {
		return Model_X11MultiKeywordsOrIDParserRuleCall_13_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X12Assignment_14ElementType() {
		return Model_X12Assignment_14_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X12MultiTerminalsParserRuleCall_14_0ElementType() {
		return Model_X12MultiTerminalsParserRuleCall_14_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X13Assignment_15ElementType() {
		return Model_X13Assignment_15_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X13SingleEnumParserRuleCall_15_0ElementType() {
		return Model_X13SingleEnumParserRuleCall_15_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X14Assignment_16ElementType() {
		return Model_X14Assignment_16_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X14SingleCrossReferenceParserRuleCall_16_0ElementType() {
		return Model_X14SingleCrossReferenceParserRuleCall_16_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X15Assignment_17ElementType() {
		return Model_X15Assignment_17_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X15SingleContainmentReferenceParserRuleCall_17_0ElementType() {
		return Model_X15SingleContainmentReferenceParserRuleCall_17_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X19Assignment_18ElementType() {
		return Model_X19Assignment_18_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X19DependentAlternative1ParserRuleCall_18_0ElementType() {
		return Model_X19DependentAlternative1ParserRuleCall_18_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X20Assignment_19ElementType() {
		return Model_X20Assignment_19_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X20DependentAlternative2ParserRuleCall_19_0ElementType() {
		return Model_X20DependentAlternative2ParserRuleCall_19_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X21Assignment_20ElementType() {
		return Model_X21Assignment_20_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X21OptionalParserRuleCall_20_0ElementType() {
		return Model_X21OptionalParserRuleCall_20_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X22Assignment_21ElementType() {
		return Model_X22Assignment_21_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X22FloatParserRuleCall_21_0ElementType() {
		return Model_X22FloatParserRuleCall_21_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X23Assignment_22ElementType() {
		return Model_X23Assignment_22_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X23UnorderedAlternativeParserRuleCall_22_0ElementType() {
		return Model_X23UnorderedAlternativeParserRuleCall_22_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X24Assignment_23ElementType() {
		return Model_X24Assignment_23_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X24UnorderedGroupParserRuleCall_23_0ElementType() {
		return Model_X24UnorderedGroupParserRuleCall_23_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X25Assignment_24ElementType() {
		return Model_X25Assignment_24_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X25UnorderedGroupOptionalParserRuleCall_24_0ElementType() {
		return Model_X25UnorderedGroupOptionalParserRuleCall_24_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X26Assignment_25ElementType() {
		return Model_X26Assignment_25_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X26UnorderedGroupBooleanParserRuleCall_25_0ElementType() {
		return Model_X26UnorderedGroupBooleanParserRuleCall_25_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X27Assignment_26ElementType() {
		return Model_X27Assignment_26_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X27Complex1ParserRuleCall_26_0ElementType() {
		return Model_X27Complex1ParserRuleCall_26_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X28Assignment_27ElementType() {
		return Model_X28Assignment_27_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X28OptionalDoubleParserRuleCall_27_0ElementType() {
		return Model_X28OptionalDoubleParserRuleCall_27_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X29Assignment_28ElementType() {
		return Model_X29Assignment_28_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X29NullValueGeneratedParserRuleCall_28_0ElementType() {
		return Model_X29NullValueGeneratedParserRuleCall_28_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X30Assignment_29ElementType() {
		return Model_X30Assignment_29_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X30NullValueInterpretedParserRuleCall_29_0ElementType() {
		return Model_X30NullValueInterpretedParserRuleCall_29_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X31Assignment_30ElementType() {
		return Model_X31Assignment_30_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X31NullCrossRefGeneratedParserRuleCall_30_0ElementType() {
		return Model_X31NullCrossRefGeneratedParserRuleCall_30_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X32Assignment_31ElementType() {
		return Model_X32Assignment_31_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_X32NullCrossRefInterpretedParserRuleCall_31_0ElementType() {
		return Model_X32NullCrossRefInterpretedParserRuleCall_31_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getList1ElementType() {
		return List1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1_GroupElementType() {
		return List1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList1_NumberSignDigitSixKeyword_0ElementType() {
		return List1_NumberSignDigitSixKeyword_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getList2_NumberSignDigitSevenKeyword_0ElementType() {
		return List2_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_List2Action_1ElementType() {
		return List2_List2Action_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Group_2ElementType() {
		return List2_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Val1Assignment_2_0ElementType() {
		return List2_Val1Assignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Val1IDTerminalRuleCall_2_0_0ElementType() {
		return List2_Val1IDTerminalRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Group_2_1ElementType() {
		return List2_Group_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_CommaKeyword_2_1_0ElementType() {
		return List2_CommaKeyword_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Val1Assignment_2_1_1ElementType() {
		return List2_Val1Assignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getList2_Val1IDTerminalRuleCall_2_1_1_0ElementType() {
		return List2_Val1IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1ElementType() {
		return AltList1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_GroupElementType() {
		return AltList1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltList1_NumberSignDigitEightKeyword_0ElementType() {
		return AltList1_NumberSignDigitEightKeyword_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getAltList2_NumberSignDigitNineKeyword_0ElementType() {
		return AltList2_NumberSignDigitNineKeyword_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getSingleKeywordsElementType() {
		return SingleKeywords_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywords_GroupElementType() {
		return SingleKeywords_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywords_NumberSignDigitOneDigitZeroKeyword_0ElementType() {
		return SingleKeywords_NumberSignDigitOneDigitZeroKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywords_ValAssignment_1ElementType() {
		return SingleKeywords_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywords_ValAlternatives_1_0ElementType() {
		return SingleKeywords_ValAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywords_ValKw1Keyword_1_0_0ElementType() {
		return SingleKeywords_ValKw1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywords_ValKw2Keyword_1_0_1ElementType() {
		return SingleKeywords_ValKw2Keyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywords_ValKw3Keyword_1_0_2ElementType() {
		return SingleKeywords_ValKw3Keyword_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywordsOrIDElementType() {
		return SingleKeywordsOrID_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywordsOrID_GroupElementType() {
		return SingleKeywordsOrID_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywordsOrID_NumberSignDigitOneDigitOneKeyword_0ElementType() {
		return SingleKeywordsOrID_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywordsOrID_ValAssignment_1ElementType() {
		return SingleKeywordsOrID_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywordsOrID_ValAlternatives_1_0ElementType() {
		return SingleKeywordsOrID_ValAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywordsOrID_ValKw1Keyword_1_0_0ElementType() {
		return SingleKeywordsOrID_ValKw1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywordsOrID_ValKw2Keyword_1_0_1ElementType() {
		return SingleKeywordsOrID_ValKw2Keyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywordsOrID_ValKw3Keyword_1_0_2ElementType() {
		return SingleKeywordsOrID_ValKw3Keyword_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType() {
		return SingleKeywordsOrID_ValIDTerminalRuleCall_1_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleTerminalsElementType() {
		return SingleTerminals_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleTerminals_GroupElementType() {
		return SingleTerminals_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleTerminals_NumberSignDigitOneDigitTwoKeyword_0ElementType() {
		return SingleTerminals_NumberSignDigitOneDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleTerminals_ValAssignment_1ElementType() {
		return SingleTerminals_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleTerminals_ValAlternatives_1_0ElementType() {
		return SingleTerminals_ValAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleTerminals_ValID1TerminalRuleCall_1_0_0ElementType() {
		return SingleTerminals_ValID1TerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleTerminals_ValID2TerminalRuleCall_1_0_1ElementType() {
		return SingleTerminals_ValID2TerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleEnumElementType() {
		return SingleEnum_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleEnum_GroupElementType() {
		return SingleEnum_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleEnum_NumberSignDigitOneDigitThreeKeyword_0ElementType() {
		return SingleEnum_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleEnum_ValAssignment_1ElementType() {
		return SingleEnum_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleEnum_ValAlternatives_1_0ElementType() {
		return SingleEnum_ValAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleEnum_ValDefEnum1EnumRuleCall_1_0_0ElementType() {
		return SingleEnum_ValDefEnum1EnumRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleEnum_ValDefEnum2EnumRuleCall_1_0_1ElementType() {
		return SingleEnum_ValDefEnum2EnumRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleEnum_ValDefEnum3EnumRuleCall_1_0_2ElementType() {
		return SingleEnum_ValDefEnum3EnumRuleCall_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefEnum1ElementType() {
		return DefEnum1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefEnum1_Kw1EnumLiteralDeclarationElementType() {
		return DefEnum1_Kw1EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefEnum1_Kw1Kw1Keyword_0ElementType() {
		return DefEnum1_Kw1Kw1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefEnum2ElementType() {
		return DefEnum2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefEnum2_Kw2EnumLiteralDeclarationElementType() {
		return DefEnum2_Kw2EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefEnum2_Kw2Kw2Keyword_0ElementType() {
		return DefEnum2_Kw2Kw2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefEnum3ElementType() {
		return DefEnum3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefEnum3_Kw3EnumLiteralDeclarationElementType() {
		return DefEnum3_Kw3EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefEnum3_Kw3Kw3Keyword_0ElementType() {
		return DefEnum3_Kw3Kw3Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReferenceElementType() {
		return SingleCrossReference_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_GroupElementType() {
		return SingleCrossReference_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NumberSignDigitOneDigitFourKeyword_0ElementType() {
		return SingleCrossReference_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NameAssignment_1ElementType() {
		return SingleCrossReference_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NameAlternatives_1_0ElementType() {
		return SingleCrossReference_NameAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NameID1TerminalRuleCall_1_0_0ElementType() {
		return SingleCrossReference_NameID1TerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NameID2TerminalRuleCall_1_0_1ElementType() {
		return SingleCrossReference_NameID2TerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_NameID3TerminalRuleCall_1_0_2ElementType() {
		return SingleCrossReference_NameID3TerminalRuleCall_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_Alternatives_2ElementType() {
		return SingleCrossReference_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_RefAssignment_2_0ElementType() {
		return SingleCrossReference_RefAssignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_RefSingleCrossReferenceCrossReference_2_0_0ElementType() {
		return SingleCrossReference_RefSingleCrossReferenceCrossReference_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_RefSingleCrossReferenceID1TerminalRuleCall_2_0_0_1ElementType() {
		return SingleCrossReference_RefSingleCrossReferenceID1TerminalRuleCall_2_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_RefAssignment_2_1ElementType() {
		return SingleCrossReference_RefAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_RefSingleCrossReferenceCrossReference_2_1_0ElementType() {
		return SingleCrossReference_RefSingleCrossReferenceCrossReference_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_RefSingleCrossReferenceID2TerminalRuleCall_2_1_0_1ElementType() {
		return SingleCrossReference_RefSingleCrossReferenceID2TerminalRuleCall_2_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_RefAssignment_2_2ElementType() {
		return SingleCrossReference_RefAssignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_RefSingleCrossReferenceCrossReference_2_2_0ElementType() {
		return SingleCrossReference_RefSingleCrossReferenceCrossReference_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleCrossReference_RefSingleCrossReferenceID3TerminalRuleCall_2_2_0_1ElementType() {
		return SingleCrossReference_RefSingleCrossReferenceID3TerminalRuleCall_2_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReferenceElementType() {
		return SingleContainmentReference_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReference_GroupElementType() {
		return SingleContainmentReference_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReference_NumberSignDigitOneDigitFiveKeyword_0ElementType() {
		return SingleContainmentReference_NumberSignDigitOneDigitFiveKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReference_ChildAssignment_1ElementType() {
		return SingleContainmentReference_ChildAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReference_ChildAlternatives_1_0ElementType() {
		return SingleContainmentReference_ChildAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReference_ChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0ElementType() {
		return SingleContainmentReference_ChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReference_ChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1ElementType() {
		return SingleContainmentReference_ChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReference_ChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2ElementType() {
		return SingleContainmentReference_ChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReferenceChild1ElementType() {
		return SingleContainmentReferenceChild1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReferenceChild1_ValAssignmentElementType() {
		return SingleContainmentReferenceChild1_ValAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReferenceChild1_ValKw1Keyword_0ElementType() {
		return SingleContainmentReferenceChild1_ValKw1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReferenceChild2ElementType() {
		return SingleContainmentReferenceChild2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReferenceChild2_ValAssignmentElementType() {
		return SingleContainmentReferenceChild2_ValAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReferenceChild2_ValKw2Keyword_0ElementType() {
		return SingleContainmentReferenceChild2_ValKw2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReferenceChild3ElementType() {
		return SingleContainmentReferenceChild3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReferenceChild3_ValAssignmentElementType() {
		return SingleContainmentReferenceChild3_ValAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleContainmentReferenceChild3_ValKw3Keyword_0ElementType() {
		return SingleContainmentReferenceChild3_ValKw3Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywordsElementType() {
		return MultiKeywords_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywords_GroupElementType() {
		return MultiKeywords_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywords_NumberSignDigitOneDigitSixKeyword_0ElementType() {
		return MultiKeywords_NumberSignDigitOneDigitSixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywords_ValAssignment_1ElementType() {
		return MultiKeywords_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywords_ValAlternatives_1_0ElementType() {
		return MultiKeywords_ValAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywords_ValKw1Keyword_1_0_0ElementType() {
		return MultiKeywords_ValKw1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywords_ValKw2Keyword_1_0_1ElementType() {
		return MultiKeywords_ValKw2Keyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywords_ValKw3Keyword_1_0_2ElementType() {
		return MultiKeywords_ValKw3Keyword_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywordsOrIDElementType() {
		return MultiKeywordsOrID_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywordsOrID_GroupElementType() {
		return MultiKeywordsOrID_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywordsOrID_NumberSignDigitOneDigitSevenKeyword_0ElementType() {
		return MultiKeywordsOrID_NumberSignDigitOneDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywordsOrID_ValAssignment_1ElementType() {
		return MultiKeywordsOrID_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywordsOrID_ValAlternatives_1_0ElementType() {
		return MultiKeywordsOrID_ValAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywordsOrID_ValKw1Keyword_1_0_0ElementType() {
		return MultiKeywordsOrID_ValKw1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywordsOrID_ValKw2Keyword_1_0_1ElementType() {
		return MultiKeywordsOrID_ValKw2Keyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywordsOrID_ValKw3Keyword_1_0_2ElementType() {
		return MultiKeywordsOrID_ValKw3Keyword_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType() {
		return MultiKeywordsOrID_ValIDTerminalRuleCall_1_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiTerminalsElementType() {
		return MultiTerminals_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiTerminals_GroupElementType() {
		return MultiTerminals_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiTerminals_NumberSignDigitOneDigitEightKeyword_0ElementType() {
		return MultiTerminals_NumberSignDigitOneDigitEightKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiTerminals_ValAssignment_1ElementType() {
		return MultiTerminals_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiTerminals_ValAlternatives_1_0ElementType() {
		return MultiTerminals_ValAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiTerminals_ValID1TerminalRuleCall_1_0_0ElementType() {
		return MultiTerminals_ValID1TerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiTerminals_ValID2TerminalRuleCall_1_0_1ElementType() {
		return MultiTerminals_ValID2TerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1ElementType() {
		return DependentAlternative1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1_GroupElementType() {
		return DependentAlternative1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1_NumberSignDigitOneDigitNineKeyword_0ElementType() {
		return DependentAlternative1_NumberSignDigitOneDigitNineKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1_Alternatives_1ElementType() {
		return DependentAlternative1_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1_ValAssignment_1_0ElementType() {
		return DependentAlternative1_ValAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1_ValIDTerminalRuleCall_1_0_0ElementType() {
		return DependentAlternative1_ValIDTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1_Group_1_1ElementType() {
		return DependentAlternative1_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1_ValAssignment_1_1_0ElementType() {
		return DependentAlternative1_ValAssignment_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1_ValIDTerminalRuleCall_1_1_0_0ElementType() {
		return DependentAlternative1_ValIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1_FlagAssignment_1_1_1ElementType() {
		return DependentAlternative1_FlagAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative1_FlagKw1Keyword_1_1_1_0ElementType() {
		return DependentAlternative1_FlagKw1Keyword_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2ElementType() {
		return DependentAlternative2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_GroupElementType() {
		return DependentAlternative2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_NumberSignDigitTwoDigitZeroKeyword_0ElementType() {
		return DependentAlternative2_NumberSignDigitTwoDigitZeroKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_Alternatives_1ElementType() {
		return DependentAlternative2_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_Group_1_0ElementType() {
		return DependentAlternative2_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_ValAssignment_1_0_0ElementType() {
		return DependentAlternative2_ValAssignment_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_ValIDTerminalRuleCall_1_0_0_0ElementType() {
		return DependentAlternative2_ValIDTerminalRuleCall_1_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_ValAssignment_1_0_1ElementType() {
		return DependentAlternative2_ValAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_ValIDTerminalRuleCall_1_0_1_0ElementType() {
		return DependentAlternative2_ValIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_Group_1_1ElementType() {
		return DependentAlternative2_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_ValAssignment_1_1_0ElementType() {
		return DependentAlternative2_ValAssignment_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_ValIDTerminalRuleCall_1_1_0_0ElementType() {
		return DependentAlternative2_ValIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_FlagAssignment_1_1_1ElementType() {
		return DependentAlternative2_FlagAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDependentAlternative2_FlagKw1Keyword_1_1_1_0ElementType() {
		return DependentAlternative2_FlagKw1Keyword_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalElementType() {
		return Optional_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptional_GroupElementType() {
		return Optional_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptional_NumberSignDigitTwoDigitOneKeyword_0ElementType() {
		return Optional_NumberSignDigitTwoDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptional_Int0Assignment_1ElementType() {
		return Optional_Int0Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptional_Int0INTTerminalRuleCall_1_0ElementType() {
		return Optional_Int0INTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptional_Group_2ElementType() {
		return Optional_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptional_Int1Assignment_2_0ElementType() {
		return Optional_Int1Assignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptional_Int1INTTerminalRuleCall_2_0_0ElementType() {
		return Optional_Int1INTTerminalRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptional_Int2Assignment_2_1ElementType() {
		return Optional_Int2Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptional_Int2INTTerminalRuleCall_2_1_0ElementType() {
		return Optional_Int2INTTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFloatElementType() {
		return Float_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFloat_GroupElementType() {
		return Float_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFloat_NumberSignDigitTwoDigitTwoKeyword_0ElementType() {
		return Float_NumberSignDigitTwoDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFloat_FloatAction_1ElementType() {
		return Float_FloatAction_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFloat_ByeKeyword_2ElementType() {
		return Float_ByeKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeElementType() {
		return UnorderedAlternative_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_GroupElementType() {
		return UnorderedAlternative_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_NumberSignDigitTwoDigitThreeKeyword_0ElementType() {
		return UnorderedAlternative_NumberSignDigitTwoDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_UnorderedAlternativeAction_1ElementType() {
		return UnorderedAlternative_UnorderedAlternativeAction_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_Alternatives_2ElementType() {
		return UnorderedAlternative_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_Val1Assignment_2_0ElementType() {
		return UnorderedAlternative_Val1Assignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_Val1IDTerminalRuleCall_2_0_0ElementType() {
		return UnorderedAlternative_Val1IDTerminalRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_Val2Assignment_2_1ElementType() {
		return UnorderedAlternative_Val2Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_Val2INTTerminalRuleCall_2_1_0ElementType() {
		return UnorderedAlternative_Val2INTTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_Val3Assignment_2_2ElementType() {
		return UnorderedAlternative_Val3Assignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_Val3UnorderedAlternativeValParserRuleCall_2_2_0ElementType() {
		return UnorderedAlternative_Val3UnorderedAlternativeValParserRuleCall_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_Val4Assignment_2_3ElementType() {
		return UnorderedAlternative_Val4Assignment_2_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternative_Val4UnorderedAlternativeValDelegateParserRuleCall_2_3_0ElementType() {
		return UnorderedAlternative_Val4UnorderedAlternativeValDelegateParserRuleCall_2_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeValElementType() {
		return UnorderedAlternativeVal_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeVal_GroupElementType() {
		return UnorderedAlternativeVal_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeVal_Kw1Keyword_0ElementType() {
		return UnorderedAlternativeVal_Kw1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeVal_ValAssignment_1ElementType() {
		return UnorderedAlternativeVal_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeVal_ValIDTerminalRuleCall_1_0ElementType() {
		return UnorderedAlternativeVal_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeValDelegateElementType() {
		return UnorderedAlternativeValDelegate_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeValDelegate_UnorderedAlternativeVal2ParserRuleCallElementType() {
		return UnorderedAlternativeValDelegate_UnorderedAlternativeVal2ParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeVal2ElementType() {
		return UnorderedAlternativeVal2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeVal2_GroupElementType() {
		return UnorderedAlternativeVal2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeVal2_Kw2Keyword_0ElementType() {
		return UnorderedAlternativeVal2_Kw2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeVal2_ValAssignment_1ElementType() {
		return UnorderedAlternativeVal2_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedAlternativeVal2_ValIDTerminalRuleCall_1_0ElementType() {
		return UnorderedAlternativeVal2_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupElementType() {
		return UnorderedGroup_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_GroupElementType() {
		return UnorderedGroup_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_NumberSignDigitTwoDigitFourKeyword_0ElementType() {
		return UnorderedGroup_NumberSignDigitTwoDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_UnorderedGroup_1ElementType() {
		return UnorderedGroup_UnorderedGroup_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_Val1Assignment_1_0ElementType() {
		return UnorderedGroup_Val1Assignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_Val1IDTerminalRuleCall_1_0_0ElementType() {
		return UnorderedGroup_Val1IDTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_Val2Assignment_1_1ElementType() {
		return UnorderedGroup_Val2Assignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_Val2INTTerminalRuleCall_1_1_0ElementType() {
		return UnorderedGroup_Val2INTTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_Val3Assignment_1_2ElementType() {
		return UnorderedGroup_Val3Assignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_Val3UnorderedGroupValParserRuleCall_1_2_0ElementType() {
		return UnorderedGroup_Val3UnorderedGroupValParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_Val4Assignment_1_3ElementType() {
		return UnorderedGroup_Val4Assignment_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_Val4UnorderedGroupValDelegateParserRuleCall_1_3_0ElementType() {
		return UnorderedGroup_Val4UnorderedGroupValDelegateParserRuleCall_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupValElementType() {
		return UnorderedGroupVal_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupVal_GroupElementType() {
		return UnorderedGroupVal_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupVal_Kw1Keyword_0ElementType() {
		return UnorderedGroupVal_Kw1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupVal_ValAssignment_1ElementType() {
		return UnorderedGroupVal_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupVal_ValIDTerminalRuleCall_1_0ElementType() {
		return UnorderedGroupVal_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupValDelegateElementType() {
		return UnorderedGroupValDelegate_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupValDelegate_UnorderedGroupVal2ParserRuleCallElementType() {
		return UnorderedGroupValDelegate_UnorderedGroupVal2ParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupVal2ElementType() {
		return UnorderedGroupVal2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupVal2_GroupElementType() {
		return UnorderedGroupVal2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupVal2_Kw2Keyword_0ElementType() {
		return UnorderedGroupVal2_Kw2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupVal2_ValAssignment_1ElementType() {
		return UnorderedGroupVal2_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupVal2_ValIDTerminalRuleCall_1_0ElementType() {
		return UnorderedGroupVal2_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptionalElementType() {
		return UnorderedGroupOptional_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_GroupElementType() {
		return UnorderedGroupOptional_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_NumberSignDigitTwoDigitFiveKeyword_0ElementType() {
		return UnorderedGroupOptional_NumberSignDigitTwoDigitFiveKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_UnorderedGroupOptionalAction_1ElementType() {
		return UnorderedGroupOptional_UnorderedGroupOptionalAction_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_UnorderedGroup_2ElementType() {
		return UnorderedGroupOptional_UnorderedGroup_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Group_2_0ElementType() {
		return UnorderedGroupOptional_Group_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Kw1Keyword_2_0_0ElementType() {
		return UnorderedGroupOptional_Kw1Keyword_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Val1Assignment_2_0_1ElementType() {
		return UnorderedGroupOptional_Val1Assignment_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Val1IDTerminalRuleCall_2_0_1_0ElementType() {
		return UnorderedGroupOptional_Val1IDTerminalRuleCall_2_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Group_2_1ElementType() {
		return UnorderedGroupOptional_Group_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Kw2Keyword_2_1_0ElementType() {
		return UnorderedGroupOptional_Kw2Keyword_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Va2Assignment_2_1_1ElementType() {
		return UnorderedGroupOptional_Va2Assignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Va2IDTerminalRuleCall_2_1_1_0ElementType() {
		return UnorderedGroupOptional_Va2IDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Group_2_2ElementType() {
		return UnorderedGroupOptional_Group_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Kw3Keyword_2_2_0ElementType() {
		return UnorderedGroupOptional_Kw3Keyword_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Val3Assignment_2_2_1ElementType() {
		return UnorderedGroupOptional_Val3Assignment_2_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupOptional_Val3IDTerminalRuleCall_2_2_1_0ElementType() {
		return UnorderedGroupOptional_Val3IDTerminalRuleCall_2_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBooleanElementType() {
		return UnorderedGroupBoolean_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBoolean_GroupElementType() {
		return UnorderedGroupBoolean_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBoolean_NumberSignDigitTwoDigitSixKeyword_0ElementType() {
		return UnorderedGroupBoolean_NumberSignDigitTwoDigitSixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBoolean_UnorderedGroupBooleanAction_1ElementType() {
		return UnorderedGroupBoolean_UnorderedGroupBooleanAction_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBoolean_UnorderedGroup_2ElementType() {
		return UnorderedGroupBoolean_UnorderedGroup_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBoolean_Val1Assignment_2_0ElementType() {
		return UnorderedGroupBoolean_Val1Assignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBoolean_Val1Kw1Keyword_2_0_0ElementType() {
		return UnorderedGroupBoolean_Val1Kw1Keyword_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBoolean_Val2Assignment_2_1ElementType() {
		return UnorderedGroupBoolean_Val2Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBoolean_Val2Kw2Keyword_2_1_0ElementType() {
		return UnorderedGroupBoolean_Val2Kw2Keyword_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBoolean_Val3Assignment_2_2ElementType() {
		return UnorderedGroupBoolean_Val3Assignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupBoolean_Val3Kw3Keyword_2_2_0ElementType() {
		return UnorderedGroupBoolean_Val3Kw3Keyword_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1ElementType() {
		return Complex1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_GroupElementType() {
		return Complex1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_NumberSignDigitTwoDigitSevenKeyword_0ElementType() {
		return Complex1_NumberSignDigitTwoDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Complex1Action_1ElementType() {
		return Complex1_Complex1Action_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Group_2ElementType() {
		return Complex1_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Kw1Keyword_2_0ElementType() {
		return Complex1_Kw1Keyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val1Assignment_2_1ElementType() {
		return Complex1_Val1Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val1IDTerminalRuleCall_2_1_0ElementType() {
		return Complex1_Val1IDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Group_3ElementType() {
		return Complex1_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Kw2Keyword_3_0ElementType() {
		return Complex1_Kw2Keyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val2Assignment_3_1ElementType() {
		return Complex1_Val2Assignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val2IDTerminalRuleCall_3_1_0ElementType() {
		return Complex1_Val2IDTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Alternatives_4ElementType() {
		return Complex1_Alternatives_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Group_4_0ElementType() {
		return Complex1_Group_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Kw3Keyword_4_0_0ElementType() {
		return Complex1_Kw3Keyword_4_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val3Assignment_4_0_1ElementType() {
		return Complex1_Val3Assignment_4_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val3IDTerminalRuleCall_4_0_1_0ElementType() {
		return Complex1_Val3IDTerminalRuleCall_4_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Group_4_1ElementType() {
		return Complex1_Group_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Kw4Keyword_4_1_0ElementType() {
		return Complex1_Kw4Keyword_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val4Assignment_4_1_1ElementType() {
		return Complex1_Val4Assignment_4_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val4IDTerminalRuleCall_4_1_1_0ElementType() {
		return Complex1_Val4IDTerminalRuleCall_4_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Group_4_2ElementType() {
		return Complex1_Group_4_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Kw5Keyword_4_2_0ElementType() {
		return Complex1_Kw5Keyword_4_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val5Assignment_4_2_1ElementType() {
		return Complex1_Val5Assignment_4_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val5IDTerminalRuleCall_4_2_1_0ElementType() {
		return Complex1_Val5IDTerminalRuleCall_4_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Group_4_3ElementType() {
		return Complex1_Group_4_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Kw6Keyword_4_3_0ElementType() {
		return Complex1_Kw6Keyword_4_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val6Assignment_4_3_1ElementType() {
		return Complex1_Val6Assignment_4_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComplex1_Val6IDTerminalRuleCall_4_3_1_0ElementType() {
		return Complex1_Val6IDTerminalRuleCall_4_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalDoubleElementType() {
		return OptionalDouble_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalDouble_GroupElementType() {
		return OptionalDouble_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalDouble_NumberSignDigitTwoDigitEightKeyword_0ElementType() {
		return OptionalDouble_NumberSignDigitTwoDigitEightKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalDouble_Double0Assignment_1ElementType() {
		return OptionalDouble_Double0Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalDouble_Double0DOUBLEParserRuleCall_1_0ElementType() {
		return OptionalDouble_Double0DOUBLEParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalDouble_Group_2ElementType() {
		return OptionalDouble_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalDouble_Double1Assignment_2_0ElementType() {
		return OptionalDouble_Double1Assignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalDouble_Double1DOUBLEParserRuleCall_2_0_0ElementType() {
		return OptionalDouble_Double1DOUBLEParserRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalDouble_Double2Assignment_2_1ElementType() {
		return OptionalDouble_Double2Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOptionalDouble_Double2DOUBLEParserRuleCall_2_1_0ElementType() {
		return OptionalDouble_Double2DOUBLEParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDOUBLEElementType() {
		return DOUBLE_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDOUBLE_GroupElementType() {
		return DOUBLE_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDOUBLE_INTTerminalRuleCall_0ElementType() {
		return DOUBLE_INTTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDOUBLE_Group_1ElementType() {
		return DOUBLE_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDOUBLE_FullStopKeyword_1_0ElementType() {
		return DOUBLE_FullStopKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDOUBLE_INTTerminalRuleCall_1_1ElementType() {
		return DOUBLE_INTTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueGeneratedElementType() {
		return NullValueGenerated_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueGenerated_GroupElementType() {
		return NullValueGenerated_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueGenerated_NumberSignDigitTwoDigitNineKeyword_0ElementType() {
		return NullValueGenerated_NumberSignDigitTwoDigitNineKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueGenerated_ValueAssignment_1ElementType() {
		return NullValueGenerated_ValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueGenerated_ValueNULL_STRINGParserRuleCall_1_0ElementType() {
		return NullValueGenerated_ValueNULL_STRINGParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueInterpretedElementType() {
		return NullValueInterpreted_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueInterpreted_GroupElementType() {
		return NullValueInterpreted_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueInterpreted_NumberSignDigitThreeDigitZeroKeyword_0ElementType() {
		return NullValueInterpreted_NumberSignDigitThreeDigitZeroKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueInterpreted_ValueAssignment_1ElementType() {
		return NullValueInterpreted_ValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueInterpreted_ValueNULL_STRINGParserRuleCall_1_0ElementType() {
		return NullValueInterpreted_ValueNULL_STRINGParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueInterpreted_FooAssignment_2ElementType() {
		return NullValueInterpreted_FooAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullValueInterpreted_FooIDTerminalRuleCall_2_0ElementType() {
		return NullValueInterpreted_FooIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNULL_STRINGElementType() {
		return NULL_STRING_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNULL_STRING_STRINGTerminalRuleCallElementType() {
		return NULL_STRING_STRINGTerminalRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefGeneratedElementType() {
		return NullCrossRefGenerated_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefGenerated_GroupElementType() {
		return NullCrossRefGenerated_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefGenerated_NumberSignDigitThreeDigitOneKeyword_0ElementType() {
		return NullCrossRefGenerated_NumberSignDigitThreeDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefGenerated_RefAssignment_1ElementType() {
		return NullCrossRefGenerated_RefAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefGenerated_RefEObjectCrossReference_1_0ElementType() {
		return NullCrossRefGenerated_RefEObjectCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefGenerated_RefEObjectIDTerminalRuleCall_1_0_1ElementType() {
		return NullCrossRefGenerated_RefEObjectIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefInterpretedElementType() {
		return NullCrossRefInterpreted_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefInterpreted_GroupElementType() {
		return NullCrossRefInterpreted_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefInterpreted_NumberSignDigitThreeDigitTwoKeyword_0ElementType() {
		return NullCrossRefInterpreted_NumberSignDigitThreeDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefInterpreted_RefAssignment_1ElementType() {
		return NullCrossRefInterpreted_RefAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefInterpreted_RefEObjectCrossReference_1_0ElementType() {
		return NullCrossRefInterpreted_RefEObjectCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefInterpreted_RefEObjectIDTerminalRuleCall_1_0_1ElementType() {
		return NullCrossRefInterpreted_RefEObjectIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefInterpreted_FooAssignment_2ElementType() {
		return NullCrossRefInterpreted_FooAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNullCrossRefInterpreted_FooIDTerminalRuleCall_2_0ElementType() {
		return NullCrossRefInterpreted_FooIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

}
