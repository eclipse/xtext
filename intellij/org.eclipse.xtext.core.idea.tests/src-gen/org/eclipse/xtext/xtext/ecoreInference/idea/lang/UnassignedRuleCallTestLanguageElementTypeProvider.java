package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.psi.impl.UnassignedRuleCallTestLanguageFileImpl;
import org.eclipse.xtext.xtext.ecoreInference.services.UnassignedRuleCallTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class UnassignedRuleCallTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<UnassignedRuleCallTestLanguageFileImpl>>(UnassignedRuleCallTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final UnassignedRuleCallTestLanguageGrammarAccess GRAMMAR_ACCESS = UnassignedRuleCallTestLanguageLanguage.INSTANCE.getInstance(UnassignedRuleCallTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ModelKeyword_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelKeyword_0_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelKeyword_0());
		}
		public static IGrammarAwareElementType createModel_INTTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Model_INTTerminalRuleCall_1_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getINTTerminalRuleCall_1());
		}
		public static IGrammarAwareElementType createModel_ModelFeaturesAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_ModelFeaturesAssignment_2_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelFeaturesAssignment_2());
		}
		public static IGrammarAwareElementType createModel_ModelFeaturesModelFeaturesParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelFeaturesModelFeaturesParserRuleCall_2_0_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelFeaturesModelFeaturesParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ModelKeyword_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelKeyword_0ElementType());

	public static final IGrammarAwareElementType Model_INTTerminalRuleCall_1_ELEMENT_TYPE = associate(ModelFactory.createModel_INTTerminalRuleCall_1ElementType());

	public static final IGrammarAwareElementType Model_ModelFeaturesAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelFeaturesAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_ModelFeaturesModelFeaturesParserRuleCall_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelFeaturesModelFeaturesParserRuleCall_2_0ElementType());

	private static class ModelFeaturesFactory {
		public static IGrammarAwareElementType createModelFeaturesElementType() {
			return new IGrammarAwareElementType("ModelFeatures_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelFeaturesRule());
		}
		public static IGrammarAwareElementType createModelFeatures_GroupElementType() {
			return new IGrammarAwareElementType("ModelFeatures_Group_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelFeaturesAccess().getGroup());
		}
		public static IGrammarAwareElementType createModelFeatures_FeatureKeyword_0ElementType() {
			return new IGrammarAwareElementType("ModelFeatures_FeatureKeyword_0_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelFeaturesAccess().getFeatureKeyword_0());
		}
		public static IGrammarAwareElementType createModelFeatures_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("ModelFeatures_NameAssignment_1_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelFeaturesAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createModelFeatures_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ModelFeatures_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelFeaturesAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModelFeatures_DataTypeRuleParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("ModelFeatures_DataTypeRuleParserRuleCall_2_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelFeaturesAccess().getDataTypeRuleParserRuleCall_2());
		}
		public static IGrammarAwareElementType createModelFeatures_SemicolonKeyword_3ElementType() {
			return new IGrammarAwareElementType("ModelFeatures_SemicolonKeyword_3_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelFeaturesAccess().getSemicolonKeyword_3());
		}
	}

	public static final IGrammarAwareElementType ModelFeatures_ELEMENT_TYPE = associate(ModelFeaturesFactory.createModelFeaturesElementType());

	public static final IGrammarAwareElementType ModelFeatures_Group_ELEMENT_TYPE = associate(ModelFeaturesFactory.createModelFeatures_GroupElementType());

	public static final IGrammarAwareElementType ModelFeatures_FeatureKeyword_0_ELEMENT_TYPE = associate(ModelFeaturesFactory.createModelFeatures_FeatureKeyword_0ElementType());

	public static final IGrammarAwareElementType ModelFeatures_NameAssignment_1_ELEMENT_TYPE = associate(ModelFeaturesFactory.createModelFeatures_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType ModelFeatures_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ModelFeaturesFactory.createModelFeatures_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType ModelFeatures_DataTypeRuleParserRuleCall_2_ELEMENT_TYPE = associate(ModelFeaturesFactory.createModelFeatures_DataTypeRuleParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType ModelFeatures_SemicolonKeyword_3_ELEMENT_TYPE = associate(ModelFeaturesFactory.createModelFeatures_SemicolonKeyword_3ElementType());

	private static class DataTypeRuleFactory {
		public static IGrammarAwareElementType createDataTypeRuleElementType() {
			return new IGrammarAwareElementType("DataTypeRule_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeRuleRule());
		}
		public static IGrammarAwareElementType createDataTypeRule_GroupElementType() {
			return new IGrammarAwareElementType("DataTypeRule_Group_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createDataTypeRule_INTTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("DataTypeRule_INTTerminalRuleCall_0_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeRuleAccess().getINTTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createDataTypeRule_KeywordKeyword_1ElementType() {
			return new IGrammarAwareElementType("DataTypeRule_KeywordKeyword_1_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeRuleAccess().getKeywordKeyword_1());
		}
		public static IGrammarAwareElementType createDataTypeRule_INTTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("DataTypeRule_INTTerminalRuleCall_2_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeRuleAccess().getINTTerminalRuleCall_2());
		}
		public static IGrammarAwareElementType createDataTypeRule_STRINGTerminalRuleCall_3ElementType() {
			return new IGrammarAwareElementType("DataTypeRule_STRINGTerminalRuleCall_3_ELEMENT_TYPE", UnassignedRuleCallTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeRuleAccess().getSTRINGTerminalRuleCall_3());
		}
	}

	public static final IGrammarAwareElementType DataTypeRule_ELEMENT_TYPE = associate(DataTypeRuleFactory.createDataTypeRuleElementType());

	public static final IGrammarAwareElementType DataTypeRule_Group_ELEMENT_TYPE = associate(DataTypeRuleFactory.createDataTypeRule_GroupElementType());

	public static final IGrammarAwareElementType DataTypeRule_INTTerminalRuleCall_0_ELEMENT_TYPE = associate(DataTypeRuleFactory.createDataTypeRule_INTTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType DataTypeRule_KeywordKeyword_1_ELEMENT_TYPE = associate(DataTypeRuleFactory.createDataTypeRule_KeywordKeyword_1ElementType());

	public static final IGrammarAwareElementType DataTypeRule_INTTerminalRuleCall_2_ELEMENT_TYPE = associate(DataTypeRuleFactory.createDataTypeRule_INTTerminalRuleCall_2ElementType());

	public static final IGrammarAwareElementType DataTypeRule_STRINGTerminalRuleCall_3_ELEMENT_TYPE = associate(DataTypeRuleFactory.createDataTypeRule_STRINGTerminalRuleCall_3ElementType());

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

	public IGrammarAwareElementType getModel_GroupElementType() {
		return Model_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ModelKeyword_0ElementType() {
		return Model_ModelKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_INTTerminalRuleCall_1ElementType() {
		return Model_INTTerminalRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ModelFeaturesAssignment_2ElementType() {
		return Model_ModelFeaturesAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ModelFeaturesModelFeaturesParserRuleCall_2_0ElementType() {
		return Model_ModelFeaturesModelFeaturesParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelFeaturesElementType() {
		return ModelFeatures_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelFeatures_GroupElementType() {
		return ModelFeatures_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelFeatures_FeatureKeyword_0ElementType() {
		return ModelFeatures_FeatureKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelFeatures_NameAssignment_1ElementType() {
		return ModelFeatures_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelFeatures_NameIDTerminalRuleCall_1_0ElementType() {
		return ModelFeatures_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelFeatures_DataTypeRuleParserRuleCall_2ElementType() {
		return ModelFeatures_DataTypeRuleParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelFeatures_SemicolonKeyword_3ElementType() {
		return ModelFeatures_SemicolonKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeRuleElementType() {
		return DataTypeRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeRule_GroupElementType() {
		return DataTypeRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeRule_INTTerminalRuleCall_0ElementType() {
		return DataTypeRule_INTTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeRule_KeywordKeyword_1ElementType() {
		return DataTypeRule_KeywordKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeRule_INTTerminalRuleCall_2ElementType() {
		return DataTypeRule_INTTerminalRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeRule_STRINGTerminalRuleCall_3ElementType() {
		return DataTypeRule_STRINGTerminalRuleCall_3_ELEMENT_TYPE;
	}

}
