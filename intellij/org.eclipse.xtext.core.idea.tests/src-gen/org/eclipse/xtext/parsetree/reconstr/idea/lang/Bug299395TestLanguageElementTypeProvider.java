package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.Bug299395TestLanguageFileImpl;
import org.eclipse.xtext.parsetree.reconstr.services.Bug299395TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug299395TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug299395TestLanguageFileImpl>>(Bug299395TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug299395TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug299395TestLanguageLanguage.INSTANCE.getInstance(Bug299395TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ModelAction_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelAction_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelAction_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_LeftCurlyBracketKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_LeftCurlyBracketKeyword_1_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getLeftCurlyBracketKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_StringsAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_StringsAssignment_1_1_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getStringsAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_StringsSTRINGTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_StringsSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getStringsSTRINGTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createModel_RightCurlyBracketKeyword_1_2ElementType() {
			return new IGrammarAwareElementType("Model_RightCurlyBracketKeyword_1_2_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRightCurlyBracketKeyword_1_2());
		}
		public static IGrammarAwareElementType createModel_Group_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_2_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createModel_LeftSquareBracketKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_LeftSquareBracketKeyword_2_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getLeftSquareBracketKeyword_2_0());
		}
		public static IGrammarAwareElementType createModel_Group_2_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_2_1_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_2_1());
		}
		public static IGrammarAwareElementType createModel_KeysAssignment_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_KeysAssignment_2_1_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getKeysAssignment_2_1_0());
		}
		public static IGrammarAwareElementType createModel_KeysSTRINGTerminalRuleCall_2_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_KeysSTRINGTerminalRuleCall_2_1_0_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getKeysSTRINGTerminalRuleCall_2_1_0_0());
		}
		public static IGrammarAwareElementType createModel_ValuesAssignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("Model_ValuesAssignment_2_1_1_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValuesAssignment_2_1_1());
		}
		public static IGrammarAwareElementType createModel_ValuesSTRINGTerminalRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValuesSTRINGTerminalRuleCall_2_1_1_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValuesSTRINGTerminalRuleCall_2_1_1_0());
		}
		public static IGrammarAwareElementType createModel_RightSquareBracketKeyword_2_2ElementType() {
			return new IGrammarAwareElementType("Model_RightSquareBracketKeyword_2_2_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRightSquareBracketKeyword_2_2());
		}
		public static IGrammarAwareElementType createModel_Group_3ElementType() {
			return new IGrammarAwareElementType("Model_Group_3_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createModel_SubModelKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Model_SubModelKeyword_3_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSubModelKeyword_3_0());
		}
		public static IGrammarAwareElementType createModel_SubModelAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Model_SubModelAssignment_3_1_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSubModelAssignment_3_1());
		}
		public static IGrammarAwareElementType createModel_SubModelSubModelParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SubModelSubModelParserRuleCall_3_1_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSubModelSubModelParserRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ModelAction_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelAction_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_LeftCurlyBracketKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_LeftCurlyBracketKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_StringsAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_StringsAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_StringsSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_StringsSTRINGTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_RightCurlyBracketKeyword_1_2_ELEMENT_TYPE = associate(ModelFactory.createModel_RightCurlyBracketKeyword_1_2ElementType());

	public static final IGrammarAwareElementType Model_Group_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_2ElementType());

	public static final IGrammarAwareElementType Model_LeftSquareBracketKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_LeftSquareBracketKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Model_Group_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_2_1ElementType());

	public static final IGrammarAwareElementType Model_KeysAssignment_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_KeysAssignment_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_KeysSTRINGTerminalRuleCall_2_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_KeysSTRINGTerminalRuleCall_2_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_ValuesAssignment_2_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValuesAssignment_2_1_1ElementType());

	public static final IGrammarAwareElementType Model_ValuesSTRINGTerminalRuleCall_2_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValuesSTRINGTerminalRuleCall_2_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_RightSquareBracketKeyword_2_2_ELEMENT_TYPE = associate(ModelFactory.createModel_RightSquareBracketKeyword_2_2ElementType());

	public static final IGrammarAwareElementType Model_Group_3_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_3ElementType());

	public static final IGrammarAwareElementType Model_SubModelKeyword_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SubModelKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Model_SubModelAssignment_3_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SubModelAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Model_SubModelSubModelParserRuleCall_3_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SubModelSubModelParserRuleCall_3_1_0ElementType());

	private static class SubModelFactory {
		public static IGrammarAwareElementType createSubModelElementType() {
			return new IGrammarAwareElementType("SubModel_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubModelRule());
		}
		public static IGrammarAwareElementType createSubModel_GroupElementType() {
			return new IGrammarAwareElementType("SubModel_Group_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createSubModel_SubModelAction_0ElementType() {
			return new IGrammarAwareElementType("SubModel_SubModelAction_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubModelAccess().getSubModelAction_0());
		}
		public static IGrammarAwareElementType createSubModel_Group_1ElementType() {
			return new IGrammarAwareElementType("SubModel_Group_1_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createSubModel_DigitOneKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("SubModel_DigitOneKeyword_1_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubModelAccess().getDigitOneKeyword_1_0());
		}
		public static IGrammarAwareElementType createSubModel_DigitTwoKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("SubModel_DigitTwoKeyword_1_1_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubModelAccess().getDigitTwoKeyword_1_1());
		}
		public static IGrammarAwareElementType createSubModel_StringsAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("SubModel_StringsAssignment_1_2_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubModelAccess().getStringsAssignment_1_2());
		}
		public static IGrammarAwareElementType createSubModel_StringsSTRINGTerminalRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("SubModel_StringsSTRINGTerminalRuleCall_1_2_0_ELEMENT_TYPE", Bug299395TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubModelAccess().getStringsSTRINGTerminalRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType SubModel_ELEMENT_TYPE = associate(SubModelFactory.createSubModelElementType());

	public static final IGrammarAwareElementType SubModel_Group_ELEMENT_TYPE = associate(SubModelFactory.createSubModel_GroupElementType());

	public static final IGrammarAwareElementType SubModel_SubModelAction_0_ELEMENT_TYPE = associate(SubModelFactory.createSubModel_SubModelAction_0ElementType());

	public static final IGrammarAwareElementType SubModel_Group_1_ELEMENT_TYPE = associate(SubModelFactory.createSubModel_Group_1ElementType());

	public static final IGrammarAwareElementType SubModel_DigitOneKeyword_1_0_ELEMENT_TYPE = associate(SubModelFactory.createSubModel_DigitOneKeyword_1_0ElementType());

	public static final IGrammarAwareElementType SubModel_DigitTwoKeyword_1_1_ELEMENT_TYPE = associate(SubModelFactory.createSubModel_DigitTwoKeyword_1_1ElementType());

	public static final IGrammarAwareElementType SubModel_StringsAssignment_1_2_ELEMENT_TYPE = associate(SubModelFactory.createSubModel_StringsAssignment_1_2ElementType());

	public static final IGrammarAwareElementType SubModel_StringsSTRINGTerminalRuleCall_1_2_0_ELEMENT_TYPE = associate(SubModelFactory.createSubModel_StringsSTRINGTerminalRuleCall_1_2_0ElementType());

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

	public IGrammarAwareElementType getModel_ModelAction_0ElementType() {
		return Model_ModelAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_LeftCurlyBracketKeyword_1_0ElementType() {
		return Model_LeftCurlyBracketKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_StringsAssignment_1_1ElementType() {
		return Model_StringsAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_StringsSTRINGTerminalRuleCall_1_1_0ElementType() {
		return Model_StringsSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RightCurlyBracketKeyword_1_2ElementType() {
		return Model_RightCurlyBracketKeyword_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_2ElementType() {
		return Model_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_LeftSquareBracketKeyword_2_0ElementType() {
		return Model_LeftSquareBracketKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_2_1ElementType() {
		return Model_Group_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_KeysAssignment_2_1_0ElementType() {
		return Model_KeysAssignment_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_KeysSTRINGTerminalRuleCall_2_1_0_0ElementType() {
		return Model_KeysSTRINGTerminalRuleCall_2_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValuesAssignment_2_1_1ElementType() {
		return Model_ValuesAssignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValuesSTRINGTerminalRuleCall_2_1_1_0ElementType() {
		return Model_ValuesSTRINGTerminalRuleCall_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RightSquareBracketKeyword_2_2ElementType() {
		return Model_RightSquareBracketKeyword_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_3ElementType() {
		return Model_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SubModelKeyword_3_0ElementType() {
		return Model_SubModelKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SubModelAssignment_3_1ElementType() {
		return Model_SubModelAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SubModelSubModelParserRuleCall_3_1_0ElementType() {
		return Model_SubModelSubModelParserRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubModelElementType() {
		return SubModel_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubModel_GroupElementType() {
		return SubModel_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubModel_SubModelAction_0ElementType() {
		return SubModel_SubModelAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubModel_Group_1ElementType() {
		return SubModel_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubModel_DigitOneKeyword_1_0ElementType() {
		return SubModel_DigitOneKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubModel_DigitTwoKeyword_1_1ElementType() {
		return SubModel_DigitTwoKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubModel_StringsAssignment_1_2ElementType() {
		return SubModel_StringsAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubModel_StringsSTRINGTerminalRuleCall_1_2_0ElementType() {
		return SubModel_StringsSTRINGTerminalRuleCall_1_2_0_ELEMENT_TYPE;
	}

}
