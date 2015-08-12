package org.eclipse.xtext.linking.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.Bug289059TestLanguageFileImpl;
import org.eclipse.xtext.linking.services.Bug289059TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug289059TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug289059TestLanguageFileImpl>>(Bug289059TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug289059TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug289059TestLanguageLanguage.INSTANCE.getInstance(Bug289059TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_NameAssignment_0_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createModel_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_EnabledAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_EnabledAssignment_1_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEnabledAssignment_1());
		}
		public static IGrammarAwareElementType createModel_EnabledUnassignedActionParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_EnabledUnassignedActionParserRuleCall_1_0_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEnabledUnassignedActionParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModel_ReferenceAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_ReferenceAssignment_2_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getReferenceAssignment_2());
		}
		public static IGrammarAwareElementType createModel_ReferenceModelCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("Model_ReferenceModelCrossReference_2_0_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getReferenceModelCrossReference_2_0());
		}
		public static IGrammarAwareElementType createModel_ReferenceModelIDTerminalRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ReferenceModelIDTerminalRuleCall_2_0_1_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getReferenceModelIDTerminalRuleCall_2_0_1());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_NameAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_EnabledAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_EnabledAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_EnabledUnassignedActionParserRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_EnabledUnassignedActionParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Model_ReferenceAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_ReferenceAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_ReferenceModelCrossReference_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ReferenceModelCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType Model_ReferenceModelIDTerminalRuleCall_2_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ReferenceModelIDTerminalRuleCall_2_0_1ElementType());

	private static class UnassignedActionFactory {
		public static IGrammarAwareElementType createUnassignedActionElementType() {
			return new IGrammarAwareElementType("UnassignedAction_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedActionRule());
		}
		public static IGrammarAwareElementType createUnassignedAction_GroupElementType() {
			return new IGrammarAwareElementType("UnassignedAction_Group_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedActionAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnassignedAction_UnassignedActionAction_0ElementType() {
			return new IGrammarAwareElementType("UnassignedAction_UnassignedActionAction_0_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedActionAccess().getUnassignedActionAction_0());
		}
		public static IGrammarAwareElementType createUnassignedAction_EnabledKeyword_1ElementType() {
			return new IGrammarAwareElementType("UnassignedAction_EnabledKeyword_1_ELEMENT_TYPE", Bug289059TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedActionAccess().getEnabledKeyword_1());
		}
	}

	public static final IGrammarAwareElementType UnassignedAction_ELEMENT_TYPE = associate(UnassignedActionFactory.createUnassignedActionElementType());

	public static final IGrammarAwareElementType UnassignedAction_Group_ELEMENT_TYPE = associate(UnassignedActionFactory.createUnassignedAction_GroupElementType());

	public static final IGrammarAwareElementType UnassignedAction_UnassignedActionAction_0_ELEMENT_TYPE = associate(UnassignedActionFactory.createUnassignedAction_UnassignedActionAction_0ElementType());

	public static final IGrammarAwareElementType UnassignedAction_EnabledKeyword_1_ELEMENT_TYPE = associate(UnassignedActionFactory.createUnassignedAction_EnabledKeyword_1ElementType());

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

	public IGrammarAwareElementType getModel_NameAssignment_0ElementType() {
		return Model_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameIDTerminalRuleCall_0_0ElementType() {
		return Model_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_EnabledAssignment_1ElementType() {
		return Model_EnabledAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_EnabledUnassignedActionParserRuleCall_1_0ElementType() {
		return Model_EnabledUnassignedActionParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ReferenceAssignment_2ElementType() {
		return Model_ReferenceAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ReferenceModelCrossReference_2_0ElementType() {
		return Model_ReferenceModelCrossReference_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ReferenceModelIDTerminalRuleCall_2_0_1ElementType() {
		return Model_ReferenceModelIDTerminalRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedActionElementType() {
		return UnassignedAction_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction_GroupElementType() {
		return UnassignedAction_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction_UnassignedActionAction_0ElementType() {
		return UnassignedAction_UnassignedActionAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedAction_EnabledKeyword_1ElementType() {
		return UnassignedAction_EnabledKeyword_1_ELEMENT_TYPE;
	}

}
