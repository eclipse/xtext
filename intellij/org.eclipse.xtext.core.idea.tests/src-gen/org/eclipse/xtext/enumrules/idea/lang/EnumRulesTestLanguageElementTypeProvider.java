package org.eclipse.xtext.enumrules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.enumrules.idea.lang.psi.impl.EnumRulesTestLanguageFileImpl;
import org.eclipse.xtext.enumrules.services.EnumRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class EnumRulesTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<EnumRulesTestLanguageFileImpl>>(EnumRulesTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final EnumRulesTestLanguageGrammarAccess GRAMMAR_ACCESS = EnumRulesTestLanguageLanguage.INSTANCE.getInstance(EnumRulesTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_ExistingKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ExistingKeyword_0_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getExistingKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_ExistingAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ExistingAssignment_0_1_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getExistingAssignment_0_1());
		}
		public static IGrammarAwareElementType createModel_ExistingExistingEnumEnumRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ExistingExistingEnumEnumRuleCall_0_1_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_0_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_2_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0_2());
		}
		public static IGrammarAwareElementType createModel_GeneratedKeyword_0_2_0ElementType() {
			return new IGrammarAwareElementType("Model_GeneratedKeyword_0_2_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGeneratedKeyword_0_2_0());
		}
		public static IGrammarAwareElementType createModel_GeneratedAssignment_0_2_1ElementType() {
			return new IGrammarAwareElementType("Model_GeneratedAssignment_0_2_1_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGeneratedAssignment_0_2_1());
		}
		public static IGrammarAwareElementType createModel_GeneratedGeneratedEnumEnumRuleCall_0_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_GeneratedGeneratedEnumEnumRuleCall_0_2_1_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_0_2_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_GeneratedKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_GeneratedKeyword_1_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGeneratedKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_GeneratedAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_GeneratedAssignment_1_1_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGeneratedAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_GeneratedGeneratedEnumEnumRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_GeneratedGeneratedEnumEnumRuleCall_1_1_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_ExistingKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ExistingKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_ExistingAssignment_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ExistingAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Model_ExistingExistingEnumEnumRuleCall_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ExistingExistingEnumEnumRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_0_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0_2ElementType());

	public static final IGrammarAwareElementType Model_GeneratedKeyword_0_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_GeneratedKeyword_0_2_0ElementType());

	public static final IGrammarAwareElementType Model_GeneratedAssignment_0_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_GeneratedAssignment_0_2_1ElementType());

	public static final IGrammarAwareElementType Model_GeneratedGeneratedEnumEnumRuleCall_0_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_GeneratedGeneratedEnumEnumRuleCall_0_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_GeneratedKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_GeneratedKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_GeneratedAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_GeneratedAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_GeneratedGeneratedEnumEnumRuleCall_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_GeneratedGeneratedEnumEnumRuleCall_1_1_0ElementType());

	private static class ExistingEnumFactory {
		public static IGrammarAwareElementType createExistingEnumElementType() {
			return new IGrammarAwareElementType("ExistingEnum_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExistingEnumRule());
		}
		public static IGrammarAwareElementType createExistingEnum_AlternativesElementType() {
			return new IGrammarAwareElementType("ExistingEnum_Alternatives_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExistingEnumAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createExistingEnum_SameNameEnumLiteralDeclaration_0ElementType() {
			return new IGrammarAwareElementType("ExistingEnum_SameNameEnumLiteralDeclaration_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0());
		}
		public static IGrammarAwareElementType createExistingEnum_SameNameSameNameKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("ExistingEnum_SameNameSameNameKeyword_0_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExistingEnumAccess().getSameNameSameNameKeyword_0_0());
		}
		public static IGrammarAwareElementType createExistingEnum_OverriddenLiteralEnumLiteralDeclaration_1ElementType() {
			return new IGrammarAwareElementType("ExistingEnum_OverriddenLiteralEnumLiteralDeclaration_1_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1());
		}
		public static IGrammarAwareElementType createExistingEnum_OverriddenLiteralOverriddenKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("ExistingEnum_OverriddenLiteralOverriddenKeyword_1_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExistingEnumAccess().getOverriddenLiteralOverriddenKeyword_1_0());
		}
		public static IGrammarAwareElementType createExistingEnum_DifferentNameEnumLiteralDeclaration_2ElementType() {
			return new IGrammarAwareElementType("ExistingEnum_DifferentNameEnumLiteralDeclaration_2_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2());
		}
		public static IGrammarAwareElementType createExistingEnum_DifferentNameDifferentLiteralKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("ExistingEnum_DifferentNameDifferentLiteralKeyword_2_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExistingEnumAccess().getDifferentNameDifferentLiteralKeyword_2_0());
		}
	}

	public static final IGrammarAwareElementType ExistingEnum_ELEMENT_TYPE = associate(ExistingEnumFactory.createExistingEnumElementType());

	public static final IGrammarAwareElementType ExistingEnum_Alternatives_ELEMENT_TYPE = associate(ExistingEnumFactory.createExistingEnum_AlternativesElementType());

	public static final IGrammarAwareElementType ExistingEnum_SameNameEnumLiteralDeclaration_0_ELEMENT_TYPE = associate(ExistingEnumFactory.createExistingEnum_SameNameEnumLiteralDeclaration_0ElementType());

	public static final IGrammarAwareElementType ExistingEnum_SameNameSameNameKeyword_0_0_ELEMENT_TYPE = associate(ExistingEnumFactory.createExistingEnum_SameNameSameNameKeyword_0_0ElementType());

	public static final IGrammarAwareElementType ExistingEnum_OverriddenLiteralEnumLiteralDeclaration_1_ELEMENT_TYPE = associate(ExistingEnumFactory.createExistingEnum_OverriddenLiteralEnumLiteralDeclaration_1ElementType());

	public static final IGrammarAwareElementType ExistingEnum_OverriddenLiteralOverriddenKeyword_1_0_ELEMENT_TYPE = associate(ExistingEnumFactory.createExistingEnum_OverriddenLiteralOverriddenKeyword_1_0ElementType());

	public static final IGrammarAwareElementType ExistingEnum_DifferentNameEnumLiteralDeclaration_2_ELEMENT_TYPE = associate(ExistingEnumFactory.createExistingEnum_DifferentNameEnumLiteralDeclaration_2ElementType());

	public static final IGrammarAwareElementType ExistingEnum_DifferentNameDifferentLiteralKeyword_2_0_ELEMENT_TYPE = associate(ExistingEnumFactory.createExistingEnum_DifferentNameDifferentLiteralKeyword_2_0ElementType());

	private static class GeneratedEnumFactory {
		public static IGrammarAwareElementType createGeneratedEnumElementType() {
			return new IGrammarAwareElementType("GeneratedEnum_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedEnumRule());
		}
		public static IGrammarAwareElementType createGeneratedEnum_AlternativesElementType() {
			return new IGrammarAwareElementType("GeneratedEnum_Alternatives_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedEnumAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createGeneratedEnum_SameNameEnumLiteralDeclaration_0ElementType() {
			return new IGrammarAwareElementType("GeneratedEnum_SameNameEnumLiteralDeclaration_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0());
		}
		public static IGrammarAwareElementType createGeneratedEnum_SameNameSameNameKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("GeneratedEnum_SameNameSameNameKeyword_0_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedEnumAccess().getSameNameSameNameKeyword_0_0());
		}
		public static IGrammarAwareElementType createGeneratedEnum_DifferentNameEnumLiteralDeclaration_1ElementType() {
			return new IGrammarAwareElementType("GeneratedEnum_DifferentNameEnumLiteralDeclaration_1_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1());
		}
		public static IGrammarAwareElementType createGeneratedEnum_DifferentNameDifferentLiteralKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("GeneratedEnum_DifferentNameDifferentLiteralKeyword_1_0_ELEMENT_TYPE", EnumRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedEnumAccess().getDifferentNameDifferentLiteralKeyword_1_0());
		}
	}

	public static final IGrammarAwareElementType GeneratedEnum_ELEMENT_TYPE = associate(GeneratedEnumFactory.createGeneratedEnumElementType());

	public static final IGrammarAwareElementType GeneratedEnum_Alternatives_ELEMENT_TYPE = associate(GeneratedEnumFactory.createGeneratedEnum_AlternativesElementType());

	public static final IGrammarAwareElementType GeneratedEnum_SameNameEnumLiteralDeclaration_0_ELEMENT_TYPE = associate(GeneratedEnumFactory.createGeneratedEnum_SameNameEnumLiteralDeclaration_0ElementType());

	public static final IGrammarAwareElementType GeneratedEnum_SameNameSameNameKeyword_0_0_ELEMENT_TYPE = associate(GeneratedEnumFactory.createGeneratedEnum_SameNameSameNameKeyword_0_0ElementType());

	public static final IGrammarAwareElementType GeneratedEnum_DifferentNameEnumLiteralDeclaration_1_ELEMENT_TYPE = associate(GeneratedEnumFactory.createGeneratedEnum_DifferentNameEnumLiteralDeclaration_1ElementType());

	public static final IGrammarAwareElementType GeneratedEnum_DifferentNameDifferentLiteralKeyword_1_0_ELEMENT_TYPE = associate(GeneratedEnumFactory.createGeneratedEnum_DifferentNameDifferentLiteralKeyword_1_0ElementType());

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

	public IGrammarAwareElementType getModel_ExistingKeyword_0_0ElementType() {
		return Model_ExistingKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ExistingAssignment_0_1ElementType() {
		return Model_ExistingAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ExistingExistingEnumEnumRuleCall_0_1_0ElementType() {
		return Model_ExistingExistingEnumEnumRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_0_2ElementType() {
		return Model_Group_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GeneratedKeyword_0_2_0ElementType() {
		return Model_GeneratedKeyword_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GeneratedAssignment_0_2_1ElementType() {
		return Model_GeneratedAssignment_0_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GeneratedGeneratedEnumEnumRuleCall_0_2_1_0ElementType() {
		return Model_GeneratedGeneratedEnumEnumRuleCall_0_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GeneratedKeyword_1_0ElementType() {
		return Model_GeneratedKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GeneratedAssignment_1_1ElementType() {
		return Model_GeneratedAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GeneratedGeneratedEnumEnumRuleCall_1_1_0ElementType() {
		return Model_GeneratedGeneratedEnumEnumRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExistingEnumElementType() {
		return ExistingEnum_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExistingEnum_AlternativesElementType() {
		return ExistingEnum_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExistingEnum_SameNameEnumLiteralDeclaration_0ElementType() {
		return ExistingEnum_SameNameEnumLiteralDeclaration_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExistingEnum_SameNameSameNameKeyword_0_0ElementType() {
		return ExistingEnum_SameNameSameNameKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExistingEnum_OverriddenLiteralEnumLiteralDeclaration_1ElementType() {
		return ExistingEnum_OverriddenLiteralEnumLiteralDeclaration_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExistingEnum_OverriddenLiteralOverriddenKeyword_1_0ElementType() {
		return ExistingEnum_OverriddenLiteralOverriddenKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExistingEnum_DifferentNameEnumLiteralDeclaration_2ElementType() {
		return ExistingEnum_DifferentNameEnumLiteralDeclaration_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExistingEnum_DifferentNameDifferentLiteralKeyword_2_0ElementType() {
		return ExistingEnum_DifferentNameDifferentLiteralKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedEnumElementType() {
		return GeneratedEnum_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedEnum_AlternativesElementType() {
		return GeneratedEnum_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedEnum_SameNameEnumLiteralDeclaration_0ElementType() {
		return GeneratedEnum_SameNameEnumLiteralDeclaration_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedEnum_SameNameSameNameKeyword_0_0ElementType() {
		return GeneratedEnum_SameNameSameNameKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedEnum_DifferentNameEnumLiteralDeclaration_1ElementType() {
		return GeneratedEnum_DifferentNameEnumLiteralDeclaration_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedEnum_DifferentNameDifferentLiteralKeyword_1_0ElementType() {
		return GeneratedEnum_DifferentNameDifferentLiteralKeyword_1_0_ELEMENT_TYPE;
	}

}
