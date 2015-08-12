package org.eclipse.xtext.parser.indentation.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.indentation.idea.lang.psi.impl.IndentationAwareTestLanguageFileImpl;
import org.eclipse.xtext.parser.indentation.services.IndentationAwareTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class IndentationAwareTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<IndentationAwareTestLanguageFileImpl>>(IndentationAwareTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final IndentationAwareTestLanguageGrammarAccess GRAMMAR_ACCESS = IndentationAwareTestLanguageLanguage.INSTANCE.getInstance(IndentationAwareTestLanguageGrammarAccess.class);

	private static class TreeFactory {
		public static IGrammarAwareElementType createTreeElementType() {
			return new IGrammarAwareElementType("Tree_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeRule());
		}
		public static IGrammarAwareElementType createTree_GroupElementType() {
			return new IGrammarAwareElementType("Tree_Group_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeAccess().getGroup());
		}
		public static IGrammarAwareElementType createTree_TreeAction_0ElementType() {
			return new IGrammarAwareElementType("Tree_TreeAction_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeAccess().getTreeAction_0());
		}
		public static IGrammarAwareElementType createTree_NodesAssignment_1ElementType() {
			return new IGrammarAwareElementType("Tree_NodesAssignment_1_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeAccess().getNodesAssignment_1());
		}
		public static IGrammarAwareElementType createTree_NodesTreeNodeParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Tree_NodesTreeNodeParserRuleCall_1_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeAccess().getNodesTreeNodeParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Tree_ELEMENT_TYPE = associate(TreeFactory.createTreeElementType());

	public static final IGrammarAwareElementType Tree_Group_ELEMENT_TYPE = associate(TreeFactory.createTree_GroupElementType());

	public static final IGrammarAwareElementType Tree_TreeAction_0_ELEMENT_TYPE = associate(TreeFactory.createTree_TreeAction_0ElementType());

	public static final IGrammarAwareElementType Tree_NodesAssignment_1_ELEMENT_TYPE = associate(TreeFactory.createTree_NodesAssignment_1ElementType());

	public static final IGrammarAwareElementType Tree_NodesTreeNodeParserRuleCall_1_0_ELEMENT_TYPE = associate(TreeFactory.createTree_NodesTreeNodeParserRuleCall_1_0ElementType());

	private static class TreeNodeFactory {
		public static IGrammarAwareElementType createTreeNodeElementType() {
			return new IGrammarAwareElementType("TreeNode_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeNodeRule());
		}
		public static IGrammarAwareElementType createTreeNode_GroupElementType() {
			return new IGrammarAwareElementType("TreeNode_Group_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeNodeAccess().getGroup());
		}
		public static IGrammarAwareElementType createTreeNode_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("TreeNode_NameAssignment_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeNodeAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createTreeNode_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("TreeNode_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeNodeAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createTreeNode_Group_1ElementType() {
			return new IGrammarAwareElementType("TreeNode_Group_1_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeNodeAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createTreeNode_INDENTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TreeNode_INDENTTerminalRuleCall_1_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeNodeAccess().getINDENTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTreeNode_ChildrenAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("TreeNode_ChildrenAssignment_1_1_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeNodeAccess().getChildrenAssignment_1_1());
		}
		public static IGrammarAwareElementType createTreeNode_ChildrenTreeNodeParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("TreeNode_ChildrenTreeNodeParserRuleCall_1_1_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createTreeNode_DEDENTTerminalRuleCall_1_2ElementType() {
			return new IGrammarAwareElementType("TreeNode_DEDENTTerminalRuleCall_1_2_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTreeNodeAccess().getDEDENTTerminalRuleCall_1_2());
		}
	}

	public static final IGrammarAwareElementType TreeNode_ELEMENT_TYPE = associate(TreeNodeFactory.createTreeNodeElementType());

	public static final IGrammarAwareElementType TreeNode_Group_ELEMENT_TYPE = associate(TreeNodeFactory.createTreeNode_GroupElementType());

	public static final IGrammarAwareElementType TreeNode_NameAssignment_0_ELEMENT_TYPE = associate(TreeNodeFactory.createTreeNode_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType TreeNode_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(TreeNodeFactory.createTreeNode_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType TreeNode_Group_1_ELEMENT_TYPE = associate(TreeNodeFactory.createTreeNode_Group_1ElementType());

	public static final IGrammarAwareElementType TreeNode_INDENTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TreeNodeFactory.createTreeNode_INDENTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TreeNode_ChildrenAssignment_1_1_ELEMENT_TYPE = associate(TreeNodeFactory.createTreeNode_ChildrenAssignment_1_1ElementType());

	public static final IGrammarAwareElementType TreeNode_ChildrenTreeNodeParserRuleCall_1_1_0_ELEMENT_TYPE = associate(TreeNodeFactory.createTreeNode_ChildrenTreeNodeParserRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType TreeNode_DEDENTTerminalRuleCall_1_2_ELEMENT_TYPE = associate(TreeNodeFactory.createTreeNode_DEDENTTerminalRuleCall_1_2ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getTreeElementType() {
		return Tree_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTree_GroupElementType() {
		return Tree_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTree_TreeAction_0ElementType() {
		return Tree_TreeAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTree_NodesAssignment_1ElementType() {
		return Tree_NodesAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTree_NodesTreeNodeParserRuleCall_1_0ElementType() {
		return Tree_NodesTreeNodeParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTreeNodeElementType() {
		return TreeNode_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTreeNode_GroupElementType() {
		return TreeNode_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTreeNode_NameAssignment_0ElementType() {
		return TreeNode_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTreeNode_NameIDTerminalRuleCall_0_0ElementType() {
		return TreeNode_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTreeNode_Group_1ElementType() {
		return TreeNode_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTreeNode_INDENTTerminalRuleCall_1_0ElementType() {
		return TreeNode_INDENTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTreeNode_ChildrenAssignment_1_1ElementType() {
		return TreeNode_ChildrenAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTreeNode_ChildrenTreeNodeParserRuleCall_1_1_0ElementType() {
		return TreeNode_ChildrenTreeNodeParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTreeNode_DEDENTTerminalRuleCall_1_2ElementType() {
		return TreeNode_DEDENTTerminalRuleCall_1_2_ELEMENT_TYPE;
	}

}
