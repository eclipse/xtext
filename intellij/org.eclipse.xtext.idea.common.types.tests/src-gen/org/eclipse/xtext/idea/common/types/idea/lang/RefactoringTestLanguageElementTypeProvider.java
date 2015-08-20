package org.eclipse.xtext.idea.common.types.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.idea.common.types.idea.lang.psi.impl.RefactoringTestLanguageFileImpl;
import org.eclipse.xtext.idea.common.types.services.RefactoringTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class RefactoringTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<RefactoringTestLanguageFileImpl>>(RefactoringTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final RefactoringTestLanguageGrammarAccess GRAMMAR_ACCESS = RefactoringTestLanguageLanguage.INSTANCE.getInstance(RefactoringTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_ReferenceHolderAssignmentElementType() {
			return new IGrammarAwareElementType("Model_ReferenceHolderAssignment_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getReferenceHolderAssignment());
		}
		public static IGrammarAwareElementType createModel_ReferenceHolderReferenceHolderParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_ReferenceHolderReferenceHolderParserRuleCall_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_ReferenceHolderAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_ReferenceHolderAssignmentElementType());

	public static final IGrammarAwareElementType Model_ReferenceHolderReferenceHolderParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ReferenceHolderReferenceHolderParserRuleCall_0ElementType());

	private static class ReferenceHolderFactory {
		public static IGrammarAwareElementType createReferenceHolderElementType() {
			return new IGrammarAwareElementType("ReferenceHolder_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceHolderRule());
		}
		public static IGrammarAwareElementType createReferenceHolder_GroupElementType() {
			return new IGrammarAwareElementType("ReferenceHolder_Group_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceHolderAccess().getGroup());
		}
		public static IGrammarAwareElementType createReferenceHolder_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("ReferenceHolder_NameAssignment_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceHolderAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createReferenceHolder_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("ReferenceHolder_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createReferenceHolder_DefaultReferenceAssignment_1ElementType() {
			return new IGrammarAwareElementType("ReferenceHolder_DefaultReferenceAssignment_1_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceHolderAccess().getDefaultReferenceAssignment_1());
		}
		public static IGrammarAwareElementType createReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("ReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0());
		}
		public static IGrammarAwareElementType createReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("ReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_1_0_1());
		}
	}

	public static final IGrammarAwareElementType ReferenceHolder_ELEMENT_TYPE = associate(ReferenceHolderFactory.createReferenceHolderElementType());

	public static final IGrammarAwareElementType ReferenceHolder_Group_ELEMENT_TYPE = associate(ReferenceHolderFactory.createReferenceHolder_GroupElementType());

	public static final IGrammarAwareElementType ReferenceHolder_NameAssignment_0_ELEMENT_TYPE = associate(ReferenceHolderFactory.createReferenceHolder_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType ReferenceHolder_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ReferenceHolderFactory.createReferenceHolder_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType ReferenceHolder_DefaultReferenceAssignment_1_ELEMENT_TYPE = associate(ReferenceHolderFactory.createReferenceHolder_DefaultReferenceAssignment_1ElementType());

	public static final IGrammarAwareElementType ReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0_ELEMENT_TYPE = associate(ReferenceHolderFactory.createReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType ReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1_ELEMENT_TYPE = associate(ReferenceHolderFactory.createReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1ElementType());

	private static class FQNFactory {
		public static IGrammarAwareElementType createFQNElementType() {
			return new IGrammarAwareElementType("FQN_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNRule());
		}
		public static IGrammarAwareElementType createFQN_GroupElementType() {
			return new IGrammarAwareElementType("FQN_Group_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN_Group_1ElementType() {
			return new IGrammarAwareElementType("FQN_Group_1_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createFQN_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("FQN_FullStopKeyword_1_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_1_1());
		}
		public static IGrammarAwareElementType createFQN_Group_2ElementType() {
			return new IGrammarAwareElementType("FQN_Group_2_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createFQN_DollarSignKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("FQN_DollarSignKeyword_2_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getDollarSignKeyword_2_0());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_2_1ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_2_1_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_2_1());
		}
	}

	public static final IGrammarAwareElementType FQN_ELEMENT_TYPE = associate(FQNFactory.createFQNElementType());

	public static final IGrammarAwareElementType FQN_Group_ELEMENT_TYPE = associate(FQNFactory.createFQN_GroupElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType FQN_Group_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_Group_1ElementType());

	public static final IGrammarAwareElementType FQN_FullStopKeyword_1_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_1_1ElementType());

	public static final IGrammarAwareElementType FQN_Group_2_ELEMENT_TYPE = associate(FQNFactory.createFQN_Group_2ElementType());

	public static final IGrammarAwareElementType FQN_DollarSignKeyword_2_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_DollarSignKeyword_2_0ElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_2_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_2_1ElementType());

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

	public IGrammarAwareElementType getModel_ReferenceHolderAssignmentElementType() {
		return Model_ReferenceHolderAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ReferenceHolderReferenceHolderParserRuleCall_0ElementType() {
		return Model_ReferenceHolderReferenceHolderParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferenceHolderElementType() {
		return ReferenceHolder_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferenceHolder_GroupElementType() {
		return ReferenceHolder_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferenceHolder_NameAssignment_0ElementType() {
		return ReferenceHolder_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferenceHolder_NameIDTerminalRuleCall_0_0ElementType() {
		return ReferenceHolder_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferenceHolder_DefaultReferenceAssignment_1ElementType() {
		return ReferenceHolder_DefaultReferenceAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0ElementType() {
		return ReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1ElementType() {
		return ReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getFQN_Group_2ElementType() {
		return FQN_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_DollarSignKeyword_2_0ElementType() {
		return FQN_DollarSignKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_IDTerminalRuleCall_2_1ElementType() {
		return FQN_IDTerminalRuleCall_2_1_ELEMENT_TYPE;
	}

}
