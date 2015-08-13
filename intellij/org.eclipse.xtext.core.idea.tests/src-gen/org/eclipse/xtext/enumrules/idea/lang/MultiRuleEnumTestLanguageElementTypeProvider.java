package org.eclipse.xtext.enumrules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.enumrules.idea.lang.psi.impl.MultiRuleEnumTestLanguageFileImpl;
import org.eclipse.xtext.enumrules.services.MultiRuleEnumTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class MultiRuleEnumTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<MultiRuleEnumTestLanguageFileImpl>>(MultiRuleEnumTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final MultiRuleEnumTestLanguageGrammarAccess GRAMMAR_ACCESS = MultiRuleEnumTestLanguageLanguage.INSTANCE.getInstance(MultiRuleEnumTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_SomeEnumKeyword_0ElementType() {
			return new IGrammarAwareElementType("Model_SomeEnumKeyword_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSomeEnumKeyword_0());
		}
		public static IGrammarAwareElementType createModel_AAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_AAssignment_1_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAAssignment_1());
		}
		public static IGrammarAwareElementType createModel_AEnumRuleAEnumRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_AEnumRuleAEnumRuleCall_1_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAEnumRuleAEnumRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModel_BAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_BAssignment_2_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBAssignment_2());
		}
		public static IGrammarAwareElementType createModel_BEnumRuleBEnumRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Model_BEnumRuleBEnumRuleCall_2_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBEnumRuleBEnumRuleCall_2_0());
		}
		public static IGrammarAwareElementType createModel_CAssignment_3ElementType() {
			return new IGrammarAwareElementType("Model_CAssignment_3_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getCAssignment_3());
		}
		public static IGrammarAwareElementType createModel_CEnumRuleCEnumRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Model_CEnumRuleCEnumRuleCall_3_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getCEnumRuleCEnumRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_SomeEnumKeyword_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SomeEnumKeyword_0ElementType());

	public static final IGrammarAwareElementType Model_AAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_AAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_AEnumRuleAEnumRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AEnumRuleAEnumRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Model_BAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_BAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_BEnumRuleBEnumRuleCall_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_BEnumRuleBEnumRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Model_CAssignment_3_ELEMENT_TYPE = associate(ModelFactory.createModel_CAssignment_3ElementType());

	public static final IGrammarAwareElementType Model_CEnumRuleCEnumRuleCall_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_CEnumRuleCEnumRuleCall_3_0ElementType());

	private static class EnumRuleAFactory {
		public static IGrammarAwareElementType createEnumRuleAElementType() {
			return new IGrammarAwareElementType("EnumRuleA_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleARule());
		}
		public static IGrammarAwareElementType createEnumRuleA_AlternativesElementType() {
			return new IGrammarAwareElementType("EnumRuleA_Alternatives_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createEnumRuleA_AEnumLiteralDeclaration_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleA_AEnumLiteralDeclaration_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAAccess().getAEnumLiteralDeclaration_0());
		}
		public static IGrammarAwareElementType createEnumRuleA_AAKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleA_AAKeyword_0_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAAccess().getAAKeyword_0_0());
		}
		public static IGrammarAwareElementType createEnumRuleA_BEnumLiteralDeclaration_1ElementType() {
			return new IGrammarAwareElementType("EnumRuleA_BEnumLiteralDeclaration_1_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAAccess().getBEnumLiteralDeclaration_1());
		}
		public static IGrammarAwareElementType createEnumRuleA_BBKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleA_BBKeyword_1_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAAccess().getBBKeyword_1_0());
		}
		public static IGrammarAwareElementType createEnumRuleA_CEnumLiteralDeclaration_2ElementType() {
			return new IGrammarAwareElementType("EnumRuleA_CEnumLiteralDeclaration_2_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAAccess().getCEnumLiteralDeclaration_2());
		}
		public static IGrammarAwareElementType createEnumRuleA_CCKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleA_CCKeyword_2_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAAccess().getCCKeyword_2_0());
		}
	}

	public static final IGrammarAwareElementType EnumRuleA_ELEMENT_TYPE = associate(EnumRuleAFactory.createEnumRuleAElementType());

	public static final IGrammarAwareElementType EnumRuleA_Alternatives_ELEMENT_TYPE = associate(EnumRuleAFactory.createEnumRuleA_AlternativesElementType());

	public static final IGrammarAwareElementType EnumRuleA_AEnumLiteralDeclaration_0_ELEMENT_TYPE = associate(EnumRuleAFactory.createEnumRuleA_AEnumLiteralDeclaration_0ElementType());

	public static final IGrammarAwareElementType EnumRuleA_AAKeyword_0_0_ELEMENT_TYPE = associate(EnumRuleAFactory.createEnumRuleA_AAKeyword_0_0ElementType());

	public static final IGrammarAwareElementType EnumRuleA_BEnumLiteralDeclaration_1_ELEMENT_TYPE = associate(EnumRuleAFactory.createEnumRuleA_BEnumLiteralDeclaration_1ElementType());

	public static final IGrammarAwareElementType EnumRuleA_BBKeyword_1_0_ELEMENT_TYPE = associate(EnumRuleAFactory.createEnumRuleA_BBKeyword_1_0ElementType());

	public static final IGrammarAwareElementType EnumRuleA_CEnumLiteralDeclaration_2_ELEMENT_TYPE = associate(EnumRuleAFactory.createEnumRuleA_CEnumLiteralDeclaration_2ElementType());

	public static final IGrammarAwareElementType EnumRuleA_CCKeyword_2_0_ELEMENT_TYPE = associate(EnumRuleAFactory.createEnumRuleA_CCKeyword_2_0ElementType());

	private static class EnumRuleBFactory {
		public static IGrammarAwareElementType createEnumRuleBElementType() {
			return new IGrammarAwareElementType("EnumRuleB_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleBRule());
		}
		public static IGrammarAwareElementType createEnumRuleB_AlternativesElementType() {
			return new IGrammarAwareElementType("EnumRuleB_Alternatives_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleBAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createEnumRuleB_CEnumLiteralDeclaration_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleB_CEnumLiteralDeclaration_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleBAccess().getCEnumLiteralDeclaration_0());
		}
		public static IGrammarAwareElementType createEnumRuleB_CCKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleB_CCKeyword_0_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleBAccess().getCCKeyword_0_0());
		}
		public static IGrammarAwareElementType createEnumRuleB_DEnumLiteralDeclaration_1ElementType() {
			return new IGrammarAwareElementType("EnumRuleB_DEnumLiteralDeclaration_1_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleBAccess().getDEnumLiteralDeclaration_1());
		}
		public static IGrammarAwareElementType createEnumRuleB_DDKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleB_DDKeyword_1_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleBAccess().getDDKeyword_1_0());
		}
		public static IGrammarAwareElementType createEnumRuleB_EEnumLiteralDeclaration_2ElementType() {
			return new IGrammarAwareElementType("EnumRuleB_EEnumLiteralDeclaration_2_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleBAccess().getEEnumLiteralDeclaration_2());
		}
		public static IGrammarAwareElementType createEnumRuleB_EEKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleB_EEKeyword_2_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleBAccess().getEEKeyword_2_0());
		}
	}

	public static final IGrammarAwareElementType EnumRuleB_ELEMENT_TYPE = associate(EnumRuleBFactory.createEnumRuleBElementType());

	public static final IGrammarAwareElementType EnumRuleB_Alternatives_ELEMENT_TYPE = associate(EnumRuleBFactory.createEnumRuleB_AlternativesElementType());

	public static final IGrammarAwareElementType EnumRuleB_CEnumLiteralDeclaration_0_ELEMENT_TYPE = associate(EnumRuleBFactory.createEnumRuleB_CEnumLiteralDeclaration_0ElementType());

	public static final IGrammarAwareElementType EnumRuleB_CCKeyword_0_0_ELEMENT_TYPE = associate(EnumRuleBFactory.createEnumRuleB_CCKeyword_0_0ElementType());

	public static final IGrammarAwareElementType EnumRuleB_DEnumLiteralDeclaration_1_ELEMENT_TYPE = associate(EnumRuleBFactory.createEnumRuleB_DEnumLiteralDeclaration_1ElementType());

	public static final IGrammarAwareElementType EnumRuleB_DDKeyword_1_0_ELEMENT_TYPE = associate(EnumRuleBFactory.createEnumRuleB_DDKeyword_1_0ElementType());

	public static final IGrammarAwareElementType EnumRuleB_EEnumLiteralDeclaration_2_ELEMENT_TYPE = associate(EnumRuleBFactory.createEnumRuleB_EEnumLiteralDeclaration_2ElementType());

	public static final IGrammarAwareElementType EnumRuleB_EEKeyword_2_0_ELEMENT_TYPE = associate(EnumRuleBFactory.createEnumRuleB_EEKeyword_2_0ElementType());

	private static class EnumRuleCFactory {
		public static IGrammarAwareElementType createEnumRuleCElementType() {
			return new IGrammarAwareElementType("EnumRuleC_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleCRule());
		}
		public static IGrammarAwareElementType createEnumRuleC_AlternativesElementType() {
			return new IGrammarAwareElementType("EnumRuleC_Alternatives_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleCAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createEnumRuleC_AEnumLiteralDeclaration_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleC_AEnumLiteralDeclaration_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleCAccess().getAEnumLiteralDeclaration_0());
		}
		public static IGrammarAwareElementType createEnumRuleC_AAKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleC_AAKeyword_0_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleCAccess().getAAKeyword_0_0());
		}
		public static IGrammarAwareElementType createEnumRuleC_DEnumLiteralDeclaration_1ElementType() {
			return new IGrammarAwareElementType("EnumRuleC_DEnumLiteralDeclaration_1_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleCAccess().getDEnumLiteralDeclaration_1());
		}
		public static IGrammarAwareElementType createEnumRuleC_DDKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleC_DDKeyword_1_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleCAccess().getDDKeyword_1_0());
		}
		public static IGrammarAwareElementType createEnumRuleC_BEnumLiteralDeclaration_2ElementType() {
			return new IGrammarAwareElementType("EnumRuleC_BEnumLiteralDeclaration_2_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleCAccess().getBEnumLiteralDeclaration_2());
		}
		public static IGrammarAwareElementType createEnumRuleC_BBKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("EnumRuleC_BBKeyword_2_0_ELEMENT_TYPE", MultiRuleEnumTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleCAccess().getBBKeyword_2_0());
		}
	}

	public static final IGrammarAwareElementType EnumRuleC_ELEMENT_TYPE = associate(EnumRuleCFactory.createEnumRuleCElementType());

	public static final IGrammarAwareElementType EnumRuleC_Alternatives_ELEMENT_TYPE = associate(EnumRuleCFactory.createEnumRuleC_AlternativesElementType());

	public static final IGrammarAwareElementType EnumRuleC_AEnumLiteralDeclaration_0_ELEMENT_TYPE = associate(EnumRuleCFactory.createEnumRuleC_AEnumLiteralDeclaration_0ElementType());

	public static final IGrammarAwareElementType EnumRuleC_AAKeyword_0_0_ELEMENT_TYPE = associate(EnumRuleCFactory.createEnumRuleC_AAKeyword_0_0ElementType());

	public static final IGrammarAwareElementType EnumRuleC_DEnumLiteralDeclaration_1_ELEMENT_TYPE = associate(EnumRuleCFactory.createEnumRuleC_DEnumLiteralDeclaration_1ElementType());

	public static final IGrammarAwareElementType EnumRuleC_DDKeyword_1_0_ELEMENT_TYPE = associate(EnumRuleCFactory.createEnumRuleC_DDKeyword_1_0ElementType());

	public static final IGrammarAwareElementType EnumRuleC_BEnumLiteralDeclaration_2_ELEMENT_TYPE = associate(EnumRuleCFactory.createEnumRuleC_BEnumLiteralDeclaration_2ElementType());

	public static final IGrammarAwareElementType EnumRuleC_BBKeyword_2_0_ELEMENT_TYPE = associate(EnumRuleCFactory.createEnumRuleC_BBKeyword_2_0ElementType());

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

	public IGrammarAwareElementType getModel_SomeEnumKeyword_0ElementType() {
		return Model_SomeEnumKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AAssignment_1ElementType() {
		return Model_AAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AEnumRuleAEnumRuleCall_1_0ElementType() {
		return Model_AEnumRuleAEnumRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BAssignment_2ElementType() {
		return Model_BAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BEnumRuleBEnumRuleCall_2_0ElementType() {
		return Model_BEnumRuleBEnumRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_CAssignment_3ElementType() {
		return Model_CAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_CEnumRuleCEnumRuleCall_3_0ElementType() {
		return Model_CEnumRuleCEnumRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleAElementType() {
		return EnumRuleA_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleA_AlternativesElementType() {
		return EnumRuleA_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleA_AEnumLiteralDeclaration_0ElementType() {
		return EnumRuleA_AEnumLiteralDeclaration_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleA_AAKeyword_0_0ElementType() {
		return EnumRuleA_AAKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleA_BEnumLiteralDeclaration_1ElementType() {
		return EnumRuleA_BEnumLiteralDeclaration_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleA_BBKeyword_1_0ElementType() {
		return EnumRuleA_BBKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleA_CEnumLiteralDeclaration_2ElementType() {
		return EnumRuleA_CEnumLiteralDeclaration_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleA_CCKeyword_2_0ElementType() {
		return EnumRuleA_CCKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleBElementType() {
		return EnumRuleB_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleB_AlternativesElementType() {
		return EnumRuleB_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleB_CEnumLiteralDeclaration_0ElementType() {
		return EnumRuleB_CEnumLiteralDeclaration_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleB_CCKeyword_0_0ElementType() {
		return EnumRuleB_CCKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleB_DEnumLiteralDeclaration_1ElementType() {
		return EnumRuleB_DEnumLiteralDeclaration_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleB_DDKeyword_1_0ElementType() {
		return EnumRuleB_DDKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleB_EEnumLiteralDeclaration_2ElementType() {
		return EnumRuleB_EEnumLiteralDeclaration_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleB_EEKeyword_2_0ElementType() {
		return EnumRuleB_EEKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleCElementType() {
		return EnumRuleC_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleC_AlternativesElementType() {
		return EnumRuleC_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleC_AEnumLiteralDeclaration_0ElementType() {
		return EnumRuleC_AEnumLiteralDeclaration_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleC_AAKeyword_0_0ElementType() {
		return EnumRuleC_AAKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleC_DEnumLiteralDeclaration_1ElementType() {
		return EnumRuleC_DEnumLiteralDeclaration_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleC_DDKeyword_1_0ElementType() {
		return EnumRuleC_DDKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleC_BEnumLiteralDeclaration_2ElementType() {
		return EnumRuleC_BEnumLiteralDeclaration_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleC_BBKeyword_2_0ElementType() {
		return EnumRuleC_BBKeyword_2_0_ELEMENT_TYPE;
	}

}
