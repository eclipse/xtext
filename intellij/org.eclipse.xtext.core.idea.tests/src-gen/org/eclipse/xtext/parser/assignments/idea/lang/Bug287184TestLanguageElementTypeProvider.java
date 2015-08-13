package org.eclipse.xtext.parser.assignments.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.assignments.idea.lang.psi.impl.Bug287184TestLanguageFileImpl;
import org.eclipse.xtext.parser.assignments.services.Bug287184TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug287184TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug287184TestLanguageFileImpl>>(Bug287184TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug287184TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug287184TestLanguageLanguage.INSTANCE.getInstance(Bug287184TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ModelKeyword_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelKeyword_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelKeyword_0());
		}
		public static IGrammarAwareElementType createModel_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_NameAssignment_1_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createModel_NameFQNParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_NameFQNParserRuleCall_1_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameFQNParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModel_DetailAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_DetailAssignment_2_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDetailAssignment_2());
		}
		public static IGrammarAwareElementType createModel_DetailAlternatives_2_0ElementType() {
			return new IGrammarAwareElementType("Model_DetailAlternatives_2_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDetailAlternatives_2_0());
		}
		public static IGrammarAwareElementType createModel_DetailDetailParserRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("Model_DetailDetailParserRuleCall_2_0_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDetailDetailParserRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createModel_DetailAssociatedDetailParserRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Model_DetailAssociatedDetailParserRuleCall_2_0_1_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDetailAssociatedDetailParserRuleCall_2_0_1());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ModelKeyword_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelKeyword_0ElementType());

	public static final IGrammarAwareElementType Model_NameAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_NameFQNParserRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NameFQNParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Model_DetailAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_DetailAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_DetailAlternatives_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DetailAlternatives_2_0ElementType());

	public static final IGrammarAwareElementType Model_DetailDetailParserRuleCall_2_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DetailDetailParserRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType Model_DetailAssociatedDetailParserRuleCall_2_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_DetailAssociatedDetailParserRuleCall_2_0_1ElementType());

	private static class AbstractDetailFactory {
		public static IGrammarAwareElementType createAbstractDetailElementType() {
			return new IGrammarAwareElementType("AbstractDetail_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractDetailRule());
		}
		public static IGrammarAwareElementType createAbstractDetail_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractDetail_Alternatives_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractDetailAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractDetail_DetailParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractDetail_DetailParserRuleCall_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractDetailAccess().getDetailParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractDetail_AssociatedDetailParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractDetail_AssociatedDetailParserRuleCall_1_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractDetailAccess().getAssociatedDetailParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractDetail_ELEMENT_TYPE = associate(AbstractDetailFactory.createAbstractDetailElementType());

	public static final IGrammarAwareElementType AbstractDetail_Alternatives_ELEMENT_TYPE = associate(AbstractDetailFactory.createAbstractDetail_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractDetail_DetailParserRuleCall_0_ELEMENT_TYPE = associate(AbstractDetailFactory.createAbstractDetail_DetailParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractDetail_AssociatedDetailParserRuleCall_1_ELEMENT_TYPE = associate(AbstractDetailFactory.createAbstractDetail_AssociatedDetailParserRuleCall_1ElementType());

	private static class DetailFactory {
		public static IGrammarAwareElementType createDetailElementType() {
			return new IGrammarAwareElementType("Detail_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailRule());
		}
		public static IGrammarAwareElementType createDetail_GroupElementType() {
			return new IGrammarAwareElementType("Detail_Group_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailAccess().getGroup());
		}
		public static IGrammarAwareElementType createDetail_DetailKeyword_0ElementType() {
			return new IGrammarAwareElementType("Detail_DetailKeyword_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailAccess().getDetailKeyword_0());
		}
		public static IGrammarAwareElementType createDetail_VisibilityAssignment_1ElementType() {
			return new IGrammarAwareElementType("Detail_VisibilityAssignment_1_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailAccess().getVisibilityAssignment_1());
		}
		public static IGrammarAwareElementType createDetail_VisibilityAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("Detail_VisibilityAlternatives_1_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailAccess().getVisibilityAlternatives_1_0());
		}
		public static IGrammarAwareElementType createDetail_VisibilityPrivateKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Detail_VisibilityPrivateKeyword_1_0_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailAccess().getVisibilityPrivateKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createDetail_VisibilityProtectedKeyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("Detail_VisibilityProtectedKeyword_1_0_1_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailAccess().getVisibilityProtectedKeyword_1_0_1());
		}
		public static IGrammarAwareElementType createDetail_VisibilityPublicKeyword_1_0_2ElementType() {
			return new IGrammarAwareElementType("Detail_VisibilityPublicKeyword_1_0_2_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailAccess().getVisibilityPublicKeyword_1_0_2());
		}
		public static IGrammarAwareElementType createDetail_DetailClassAssignment_2ElementType() {
			return new IGrammarAwareElementType("Detail_DetailClassAssignment_2_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailAccess().getDetailClassAssignment_2());
		}
		public static IGrammarAwareElementType createDetail_DetailClassModelCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("Detail_DetailClassModelCrossReference_2_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailAccess().getDetailClassModelCrossReference_2_0());
		}
		public static IGrammarAwareElementType createDetail_DetailClassModelFQNParserRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Detail_DetailClassModelFQNParserRuleCall_2_0_1_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDetailAccess().getDetailClassModelFQNParserRuleCall_2_0_1());
		}
	}

	public static final IGrammarAwareElementType Detail_ELEMENT_TYPE = associate(DetailFactory.createDetailElementType());

	public static final IGrammarAwareElementType Detail_Group_ELEMENT_TYPE = associate(DetailFactory.createDetail_GroupElementType());

	public static final IGrammarAwareElementType Detail_DetailKeyword_0_ELEMENT_TYPE = associate(DetailFactory.createDetail_DetailKeyword_0ElementType());

	public static final IGrammarAwareElementType Detail_VisibilityAssignment_1_ELEMENT_TYPE = associate(DetailFactory.createDetail_VisibilityAssignment_1ElementType());

	public static final IGrammarAwareElementType Detail_VisibilityAlternatives_1_0_ELEMENT_TYPE = associate(DetailFactory.createDetail_VisibilityAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType Detail_VisibilityPrivateKeyword_1_0_0_ELEMENT_TYPE = associate(DetailFactory.createDetail_VisibilityPrivateKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Detail_VisibilityProtectedKeyword_1_0_1_ELEMENT_TYPE = associate(DetailFactory.createDetail_VisibilityProtectedKeyword_1_0_1ElementType());

	public static final IGrammarAwareElementType Detail_VisibilityPublicKeyword_1_0_2_ELEMENT_TYPE = associate(DetailFactory.createDetail_VisibilityPublicKeyword_1_0_2ElementType());

	public static final IGrammarAwareElementType Detail_DetailClassAssignment_2_ELEMENT_TYPE = associate(DetailFactory.createDetail_DetailClassAssignment_2ElementType());

	public static final IGrammarAwareElementType Detail_DetailClassModelCrossReference_2_0_ELEMENT_TYPE = associate(DetailFactory.createDetail_DetailClassModelCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType Detail_DetailClassModelFQNParserRuleCall_2_0_1_ELEMENT_TYPE = associate(DetailFactory.createDetail_DetailClassModelFQNParserRuleCall_2_0_1ElementType());

	private static class AssociatedDetailFactory {
		public static IGrammarAwareElementType createAssociatedDetailElementType() {
			return new IGrammarAwareElementType("AssociatedDetail_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssociatedDetailRule());
		}
		public static IGrammarAwareElementType createAssociatedDetail_GroupElementType() {
			return new IGrammarAwareElementType("AssociatedDetail_Group_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssociatedDetailAccess().getGroup());
		}
		public static IGrammarAwareElementType createAssociatedDetail_AssociatedKeyword_0ElementType() {
			return new IGrammarAwareElementType("AssociatedDetail_AssociatedKeyword_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssociatedDetailAccess().getAssociatedKeyword_0());
		}
		public static IGrammarAwareElementType createAssociatedDetail_DetailClassAssignment_1ElementType() {
			return new IGrammarAwareElementType("AssociatedDetail_DetailClassAssignment_1_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssociatedDetailAccess().getDetailClassAssignment_1());
		}
		public static IGrammarAwareElementType createAssociatedDetail_DetailClassModelCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("AssociatedDetail_DetailClassModelCrossReference_1_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssociatedDetailAccess().getDetailClassModelCrossReference_1_0());
		}
		public static IGrammarAwareElementType createAssociatedDetail_DetailClassModelFQNParserRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("AssociatedDetail_DetailClassModelFQNParserRuleCall_1_0_1_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssociatedDetailAccess().getDetailClassModelFQNParserRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createAssociatedDetail_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("AssociatedDetail_SemicolonKeyword_2_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssociatedDetailAccess().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType AssociatedDetail_ELEMENT_TYPE = associate(AssociatedDetailFactory.createAssociatedDetailElementType());

	public static final IGrammarAwareElementType AssociatedDetail_Group_ELEMENT_TYPE = associate(AssociatedDetailFactory.createAssociatedDetail_GroupElementType());

	public static final IGrammarAwareElementType AssociatedDetail_AssociatedKeyword_0_ELEMENT_TYPE = associate(AssociatedDetailFactory.createAssociatedDetail_AssociatedKeyword_0ElementType());

	public static final IGrammarAwareElementType AssociatedDetail_DetailClassAssignment_1_ELEMENT_TYPE = associate(AssociatedDetailFactory.createAssociatedDetail_DetailClassAssignment_1ElementType());

	public static final IGrammarAwareElementType AssociatedDetail_DetailClassModelCrossReference_1_0_ELEMENT_TYPE = associate(AssociatedDetailFactory.createAssociatedDetail_DetailClassModelCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType AssociatedDetail_DetailClassModelFQNParserRuleCall_1_0_1_ELEMENT_TYPE = associate(AssociatedDetailFactory.createAssociatedDetail_DetailClassModelFQNParserRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType AssociatedDetail_SemicolonKeyword_2_ELEMENT_TYPE = associate(AssociatedDetailFactory.createAssociatedDetail_SemicolonKeyword_2ElementType());

	private static class FQNFactory {
		public static IGrammarAwareElementType createFQNElementType() {
			return new IGrammarAwareElementType("FQN_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNRule());
		}
		public static IGrammarAwareElementType createFQN_GroupElementType() {
			return new IGrammarAwareElementType("FQN_Group_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN_Group_1ElementType() {
			return new IGrammarAwareElementType("FQN_Group_1_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createFQN_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("FQN_FullStopKeyword_1_0_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE", Bug287184TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType FQN_ELEMENT_TYPE = associate(FQNFactory.createFQNElementType());

	public static final IGrammarAwareElementType FQN_Group_ELEMENT_TYPE = associate(FQNFactory.createFQN_GroupElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType FQN_Group_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_Group_1ElementType());

	public static final IGrammarAwareElementType FQN_FullStopKeyword_1_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_1_1ElementType());

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

	public IGrammarAwareElementType getModel_NameAssignment_1ElementType() {
		return Model_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameFQNParserRuleCall_1_0ElementType() {
		return Model_NameFQNParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DetailAssignment_2ElementType() {
		return Model_DetailAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DetailAlternatives_2_0ElementType() {
		return Model_DetailAlternatives_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DetailDetailParserRuleCall_2_0_0ElementType() {
		return Model_DetailDetailParserRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DetailAssociatedDetailParserRuleCall_2_0_1ElementType() {
		return Model_DetailAssociatedDetailParserRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractDetailElementType() {
		return AbstractDetail_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractDetail_AlternativesElementType() {
		return AbstractDetail_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractDetail_DetailParserRuleCall_0ElementType() {
		return AbstractDetail_DetailParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractDetail_AssociatedDetailParserRuleCall_1ElementType() {
		return AbstractDetail_AssociatedDetailParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetailElementType() {
		return Detail_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetail_GroupElementType() {
		return Detail_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetail_DetailKeyword_0ElementType() {
		return Detail_DetailKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetail_VisibilityAssignment_1ElementType() {
		return Detail_VisibilityAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetail_VisibilityAlternatives_1_0ElementType() {
		return Detail_VisibilityAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetail_VisibilityPrivateKeyword_1_0_0ElementType() {
		return Detail_VisibilityPrivateKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetail_VisibilityProtectedKeyword_1_0_1ElementType() {
		return Detail_VisibilityProtectedKeyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetail_VisibilityPublicKeyword_1_0_2ElementType() {
		return Detail_VisibilityPublicKeyword_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetail_DetailClassAssignment_2ElementType() {
		return Detail_DetailClassAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetail_DetailClassModelCrossReference_2_0ElementType() {
		return Detail_DetailClassModelCrossReference_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDetail_DetailClassModelFQNParserRuleCall_2_0_1ElementType() {
		return Detail_DetailClassModelFQNParserRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssociatedDetailElementType() {
		return AssociatedDetail_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssociatedDetail_GroupElementType() {
		return AssociatedDetail_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssociatedDetail_AssociatedKeyword_0ElementType() {
		return AssociatedDetail_AssociatedKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssociatedDetail_DetailClassAssignment_1ElementType() {
		return AssociatedDetail_DetailClassAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssociatedDetail_DetailClassModelCrossReference_1_0ElementType() {
		return AssociatedDetail_DetailClassModelCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssociatedDetail_DetailClassModelFQNParserRuleCall_1_0_1ElementType() {
		return AssociatedDetail_DetailClassModelFQNParserRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssociatedDetail_SemicolonKeyword_2ElementType() {
		return AssociatedDetail_SemicolonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQNElementType() {
		return FQN_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_GroupElementType() {
		return FQN_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_IDTerminalRuleCall_0ElementType() {
		return FQN_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_Group_1ElementType() {
		return FQN_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_FullStopKeyword_1_0ElementType() {
		return FQN_FullStopKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_IDTerminalRuleCall_1_1ElementType() {
		return FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

}
