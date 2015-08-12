package org.eclipse.xtext.testlanguages.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.ActionTestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class ActionTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<ActionTestLanguageFileImpl>>(ActionTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final ActionTestLanguageGrammarAccess GRAMMAR_ACCESS = ActionTestLanguageLanguage.INSTANCE.getInstance(ActionTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", ActionTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", ActionTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ChildParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_ChildParserRuleCall_0_ELEMENT_TYPE", ActionTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getChildParserRuleCall_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", ActionTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_ParentLeftAction_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ParentLeftAction_1_0_ELEMENT_TYPE", ActionTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getParentLeftAction_1_0());
		}
		public static IGrammarAwareElementType createModel_RightAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_RightAssignment_1_1_ELEMENT_TYPE", ActionTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRightAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_RightChildParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_RightChildParserRuleCall_1_1_0_ELEMENT_TYPE", ActionTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRightChildParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ChildParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ChildParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_ParentLeftAction_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ParentLeftAction_1_0ElementType());

	public static final IGrammarAwareElementType Model_RightAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_RightAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_RightChildParserRuleCall_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_RightChildParserRuleCall_1_1_0ElementType());

	private static class ChildFactory {
		public static IGrammarAwareElementType createChildElementType() {
			return new IGrammarAwareElementType("Child_ELEMENT_TYPE", ActionTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildRule());
		}
		public static IGrammarAwareElementType createChild_NameAssignmentElementType() {
			return new IGrammarAwareElementType("Child_NameAssignment_ELEMENT_TYPE", ActionTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createChild_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Child_NameIDTerminalRuleCall_0_ELEMENT_TYPE", ActionTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Child_ELEMENT_TYPE = associate(ChildFactory.createChildElementType());

	public static final IGrammarAwareElementType Child_NameAssignment_ELEMENT_TYPE = associate(ChildFactory.createChild_NameAssignmentElementType());

	public static final IGrammarAwareElementType Child_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(ChildFactory.createChild_NameIDTerminalRuleCall_0ElementType());

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

	public IGrammarAwareElementType getModel_ChildParserRuleCall_0ElementType() {
		return Model_ChildParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ParentLeftAction_1_0ElementType() {
		return Model_ParentLeftAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RightAssignment_1_1ElementType() {
		return Model_RightAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RightChildParserRuleCall_1_1_0ElementType() {
		return Model_RightChildParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildElementType() {
		return Child_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_NameAssignmentElementType() {
		return Child_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_NameIDTerminalRuleCall_0ElementType() {
		return Child_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
