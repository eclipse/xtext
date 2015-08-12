package org.eclipse.xtext.testlanguages.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.TreeTestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class TreeTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<TreeTestLanguageFileImpl>>(TreeTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final TreeTestLanguageGrammarAccess GRAMMAR_ACCESS = TreeTestLanguageLanguage.INSTANCE.getInstance(TreeTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_ChildrenAssignmentElementType() {
			return new IGrammarAwareElementType("Model_ChildrenAssignment_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getChildrenAssignment());
		}
		public static IGrammarAwareElementType createModel_ChildrenNodeParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_ChildrenNodeParserRuleCall_0_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getChildrenNodeParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_ChildrenAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_ChildrenAssignmentElementType());

	public static final IGrammarAwareElementType Model_ChildrenNodeParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ChildrenNodeParserRuleCall_0ElementType());

	private static class NodeFactory {
		public static IGrammarAwareElementType createNodeElementType() {
			return new IGrammarAwareElementType("Node_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeRule());
		}
		public static IGrammarAwareElementType createNode_GroupElementType() {
			return new IGrammarAwareElementType("Node_Group_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getGroup());
		}
		public static IGrammarAwareElementType createNode_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Node_NameAssignment_0_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createNode_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Node_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createNode_LeftParenthesisKeyword_1ElementType() {
			return new IGrammarAwareElementType("Node_LeftParenthesisKeyword_1_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getLeftParenthesisKeyword_1());
		}
		public static IGrammarAwareElementType createNode_AttribAssignment_2ElementType() {
			return new IGrammarAwareElementType("Node_AttribAssignment_2_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getAttribAssignment_2());
		}
		public static IGrammarAwareElementType createNode_AttribSTRINGTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Node_AttribSTRINGTerminalRuleCall_2_0_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getAttribSTRINGTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createNode_RightParenthesisKeyword_3ElementType() {
			return new IGrammarAwareElementType("Node_RightParenthesisKeyword_3_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getRightParenthesisKeyword_3());
		}
		public static IGrammarAwareElementType createNode_LeftCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("Node_LeftCurlyBracketKeyword_4_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getLeftCurlyBracketKeyword_4());
		}
		public static IGrammarAwareElementType createNode_ChildrenAssignment_5ElementType() {
			return new IGrammarAwareElementType("Node_ChildrenAssignment_5_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getChildrenAssignment_5());
		}
		public static IGrammarAwareElementType createNode_ChildrenNodeParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("Node_ChildrenNodeParserRuleCall_5_0_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getChildrenNodeParserRuleCall_5_0());
		}
		public static IGrammarAwareElementType createNode_RightCurlyBracketSemicolonKeyword_6ElementType() {
			return new IGrammarAwareElementType("Node_RightCurlyBracketSemicolonKeyword_6_ELEMENT_TYPE", TreeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getRightCurlyBracketSemicolonKeyword_6());
		}
	}

	public static final IGrammarAwareElementType Node_ELEMENT_TYPE = associate(NodeFactory.createNodeElementType());

	public static final IGrammarAwareElementType Node_Group_ELEMENT_TYPE = associate(NodeFactory.createNode_GroupElementType());

	public static final IGrammarAwareElementType Node_NameAssignment_0_ELEMENT_TYPE = associate(NodeFactory.createNode_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Node_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(NodeFactory.createNode_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Node_LeftParenthesisKeyword_1_ELEMENT_TYPE = associate(NodeFactory.createNode_LeftParenthesisKeyword_1ElementType());

	public static final IGrammarAwareElementType Node_AttribAssignment_2_ELEMENT_TYPE = associate(NodeFactory.createNode_AttribAssignment_2ElementType());

	public static final IGrammarAwareElementType Node_AttribSTRINGTerminalRuleCall_2_0_ELEMENT_TYPE = associate(NodeFactory.createNode_AttribSTRINGTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Node_RightParenthesisKeyword_3_ELEMENT_TYPE = associate(NodeFactory.createNode_RightParenthesisKeyword_3ElementType());

	public static final IGrammarAwareElementType Node_LeftCurlyBracketKeyword_4_ELEMENT_TYPE = associate(NodeFactory.createNode_LeftCurlyBracketKeyword_4ElementType());

	public static final IGrammarAwareElementType Node_ChildrenAssignment_5_ELEMENT_TYPE = associate(NodeFactory.createNode_ChildrenAssignment_5ElementType());

	public static final IGrammarAwareElementType Node_ChildrenNodeParserRuleCall_5_0_ELEMENT_TYPE = associate(NodeFactory.createNode_ChildrenNodeParserRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType Node_RightCurlyBracketSemicolonKeyword_6_ELEMENT_TYPE = associate(NodeFactory.createNode_RightCurlyBracketSemicolonKeyword_6ElementType());

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

	public IGrammarAwareElementType getModel_ChildrenAssignmentElementType() {
		return Model_ChildrenAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ChildrenNodeParserRuleCall_0ElementType() {
		return Model_ChildrenNodeParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeElementType() {
		return Node_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_GroupElementType() {
		return Node_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_NameAssignment_0ElementType() {
		return Node_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_NameIDTerminalRuleCall_0_0ElementType() {
		return Node_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_LeftParenthesisKeyword_1ElementType() {
		return Node_LeftParenthesisKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_AttribAssignment_2ElementType() {
		return Node_AttribAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_AttribSTRINGTerminalRuleCall_2_0ElementType() {
		return Node_AttribSTRINGTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_RightParenthesisKeyword_3ElementType() {
		return Node_RightParenthesisKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_LeftCurlyBracketKeyword_4ElementType() {
		return Node_LeftCurlyBracketKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_ChildrenAssignment_5ElementType() {
		return Node_ChildrenAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_ChildrenNodeParserRuleCall_5_0ElementType() {
		return Node_ChildrenNodeParserRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_RightCurlyBracketSemicolonKeyword_6ElementType() {
		return Node_RightCurlyBracketSemicolonKeyword_6_ELEMENT_TYPE;
	}

}
