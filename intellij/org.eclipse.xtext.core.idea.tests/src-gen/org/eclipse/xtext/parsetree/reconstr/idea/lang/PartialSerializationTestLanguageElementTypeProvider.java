package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.PartialSerializationTestLanguageFileImpl;
import org.eclipse.xtext.parsetree.reconstr.services.PartialSerializationTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class PartialSerializationTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<PartialSerializationTestLanguageFileImpl>>(PartialSerializationTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final PartialSerializationTestLanguageGrammarAccess GRAMMAR_ACCESS = PartialSerializationTestLanguageLanguage.INSTANCE.getInstance(PartialSerializationTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_NodeRootParserRuleCallElementType() {
			return new IGrammarAwareElementType("Model_NodeRootParserRuleCall_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNodeRootParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_NodeRootParserRuleCall_ELEMENT_TYPE = associate(ModelFactory.createModel_NodeRootParserRuleCallElementType());

	private static class NodeRootFactory {
		public static IGrammarAwareElementType createNodeRootElementType() {
			return new IGrammarAwareElementType("NodeRoot_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeRootRule());
		}
		public static IGrammarAwareElementType createNodeRoot_GroupElementType() {
			return new IGrammarAwareElementType("NodeRoot_Group_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeRootAccess().getGroup());
		}
		public static IGrammarAwareElementType createNodeRoot_NumberSignDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("NodeRoot_NumberSignDigitOneKeyword_0_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeRootAccess().getNumberSignDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createNodeRoot_NodeAssignment_1ElementType() {
			return new IGrammarAwareElementType("NodeRoot_NodeAssignment_1_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeRootAccess().getNodeAssignment_1());
		}
		public static IGrammarAwareElementType createNodeRoot_NodeNodeParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NodeRoot_NodeNodeParserRuleCall_1_0_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeRootAccess().getNodeNodeParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType NodeRoot_ELEMENT_TYPE = associate(NodeRootFactory.createNodeRootElementType());

	public static final IGrammarAwareElementType NodeRoot_Group_ELEMENT_TYPE = associate(NodeRootFactory.createNodeRoot_GroupElementType());

	public static final IGrammarAwareElementType NodeRoot_NumberSignDigitOneKeyword_0_ELEMENT_TYPE = associate(NodeRootFactory.createNodeRoot_NumberSignDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType NodeRoot_NodeAssignment_1_ELEMENT_TYPE = associate(NodeRootFactory.createNodeRoot_NodeAssignment_1ElementType());

	public static final IGrammarAwareElementType NodeRoot_NodeNodeParserRuleCall_1_0_ELEMENT_TYPE = associate(NodeRootFactory.createNodeRoot_NodeNodeParserRuleCall_1_0ElementType());

	private static class NodeFactory {
		public static IGrammarAwareElementType createNodeElementType() {
			return new IGrammarAwareElementType("Node_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeRule());
		}
		public static IGrammarAwareElementType createNode_GroupElementType() {
			return new IGrammarAwareElementType("Node_Group_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getGroup());
		}
		public static IGrammarAwareElementType createNode_NodeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Node_NodeKeyword_0_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getNodeKeyword_0());
		}
		public static IGrammarAwareElementType createNode_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Node_NameAssignment_1_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createNode_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Node_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createNode_Group_2ElementType() {
			return new IGrammarAwareElementType("Node_Group_2_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createNode_LeftParenthesisKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Node_LeftParenthesisKeyword_2_0_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getLeftParenthesisKeyword_2_0());
		}
		public static IGrammarAwareElementType createNode_ChildrenAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Node_ChildrenAssignment_2_1_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getChildrenAssignment_2_1());
		}
		public static IGrammarAwareElementType createNode_ChildrenNodeParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Node_ChildrenNodeParserRuleCall_2_1_0_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getChildrenNodeParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createNode_RightParenthesisKeyword_2_2ElementType() {
			return new IGrammarAwareElementType("Node_RightParenthesisKeyword_2_2_ELEMENT_TYPE", PartialSerializationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getRightParenthesisKeyword_2_2());
		}
	}

	public static final IGrammarAwareElementType Node_ELEMENT_TYPE = associate(NodeFactory.createNodeElementType());

	public static final IGrammarAwareElementType Node_Group_ELEMENT_TYPE = associate(NodeFactory.createNode_GroupElementType());

	public static final IGrammarAwareElementType Node_NodeKeyword_0_ELEMENT_TYPE = associate(NodeFactory.createNode_NodeKeyword_0ElementType());

	public static final IGrammarAwareElementType Node_NameAssignment_1_ELEMENT_TYPE = associate(NodeFactory.createNode_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Node_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(NodeFactory.createNode_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Node_Group_2_ELEMENT_TYPE = associate(NodeFactory.createNode_Group_2ElementType());

	public static final IGrammarAwareElementType Node_LeftParenthesisKeyword_2_0_ELEMENT_TYPE = associate(NodeFactory.createNode_LeftParenthesisKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Node_ChildrenAssignment_2_1_ELEMENT_TYPE = associate(NodeFactory.createNode_ChildrenAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Node_ChildrenNodeParserRuleCall_2_1_0_ELEMENT_TYPE = associate(NodeFactory.createNode_ChildrenNodeParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Node_RightParenthesisKeyword_2_2_ELEMENT_TYPE = associate(NodeFactory.createNode_RightParenthesisKeyword_2_2ElementType());

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

	public IGrammarAwareElementType getModel_NodeRootParserRuleCallElementType() {
		return Model_NodeRootParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeRootElementType() {
		return NodeRoot_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeRoot_GroupElementType() {
		return NodeRoot_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeRoot_NumberSignDigitOneKeyword_0ElementType() {
		return NodeRoot_NumberSignDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeRoot_NodeAssignment_1ElementType() {
		return NodeRoot_NodeAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeRoot_NodeNodeParserRuleCall_1_0ElementType() {
		return NodeRoot_NodeNodeParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeElementType() {
		return Node_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_GroupElementType() {
		return Node_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_NodeKeyword_0ElementType() {
		return Node_NodeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_NameAssignment_1ElementType() {
		return Node_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_NameIDTerminalRuleCall_1_0ElementType() {
		return Node_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_Group_2ElementType() {
		return Node_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_LeftParenthesisKeyword_2_0ElementType() {
		return Node_LeftParenthesisKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_ChildrenAssignment_2_1ElementType() {
		return Node_ChildrenAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_ChildrenNodeParserRuleCall_2_1_0ElementType() {
		return Node_ChildrenNodeParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_RightParenthesisKeyword_2_2ElementType() {
		return Node_RightParenthesisKeyword_2_2_ELEMENT_TYPE;
	}

}
