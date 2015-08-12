package org.eclipse.xtext.testlanguages.indent.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.indent.idea.lang.psi.impl.IndentationAwareTestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.indent.services.IndentationAwareTestLanguageGrammarAccess;
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

	private static class NodeListFactory {
		public static IGrammarAwareElementType createNodeListElementType() {
			return new IGrammarAwareElementType("NodeList_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeListRule());
		}
		public static IGrammarAwareElementType createNodeList_GroupElementType() {
			return new IGrammarAwareElementType("NodeList_Group_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeListAccess().getGroup());
		}
		public static IGrammarAwareElementType createNodeList_ChildrenAssignment_0ElementType() {
			return new IGrammarAwareElementType("NodeList_ChildrenAssignment_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeListAccess().getChildrenAssignment_0());
		}
		public static IGrammarAwareElementType createNodeList_ChildrenNodeParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("NodeList_ChildrenNodeParserRuleCall_0_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeListAccess().getChildrenNodeParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createNodeList_Group_1ElementType() {
			return new IGrammarAwareElementType("NodeList_Group_1_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeListAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createNodeList_NLTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NodeList_NLTerminalRuleCall_1_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeListAccess().getNLTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createNodeList_ChildrenAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("NodeList_ChildrenAssignment_1_1_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeListAccess().getChildrenAssignment_1_1());
		}
		public static IGrammarAwareElementType createNodeList_ChildrenNodeParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("NodeList_ChildrenNodeParserRuleCall_1_1_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeListAccess().getChildrenNodeParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType NodeList_ELEMENT_TYPE = associate(NodeListFactory.createNodeListElementType());

	public static final IGrammarAwareElementType NodeList_Group_ELEMENT_TYPE = associate(NodeListFactory.createNodeList_GroupElementType());

	public static final IGrammarAwareElementType NodeList_ChildrenAssignment_0_ELEMENT_TYPE = associate(NodeListFactory.createNodeList_ChildrenAssignment_0ElementType());

	public static final IGrammarAwareElementType NodeList_ChildrenNodeParserRuleCall_0_0_ELEMENT_TYPE = associate(NodeListFactory.createNodeList_ChildrenNodeParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType NodeList_Group_1_ELEMENT_TYPE = associate(NodeListFactory.createNodeList_Group_1ElementType());

	public static final IGrammarAwareElementType NodeList_NLTerminalRuleCall_1_0_ELEMENT_TYPE = associate(NodeListFactory.createNodeList_NLTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType NodeList_ChildrenAssignment_1_1_ELEMENT_TYPE = associate(NodeListFactory.createNodeList_ChildrenAssignment_1_1ElementType());

	public static final IGrammarAwareElementType NodeList_ChildrenNodeParserRuleCall_1_1_0_ELEMENT_TYPE = associate(NodeListFactory.createNodeList_ChildrenNodeParserRuleCall_1_1_0ElementType());

	private static class NodeFactory {
		public static IGrammarAwareElementType createNodeElementType() {
			return new IGrammarAwareElementType("Node_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeRule());
		}
		public static IGrammarAwareElementType createNode_GroupElementType() {
			return new IGrammarAwareElementType("Node_Group_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getGroup());
		}
		public static IGrammarAwareElementType createNode_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Node_NameAssignment_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createNode_NameStringParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Node_NameStringParserRuleCall_0_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getNameStringParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createNode_Group_1ElementType() {
			return new IGrammarAwareElementType("Node_Group_1_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createNode_NLTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Node_NLTerminalRuleCall_1_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getNLTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createNode_BEGINTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("Node_BEGINTerminalRuleCall_1_1_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getBEGINTerminalRuleCall_1_1());
		}
		public static IGrammarAwareElementType createNode_ChildrenAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Node_ChildrenAssignment_1_2_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getChildrenAssignment_1_2());
		}
		public static IGrammarAwareElementType createNode_ChildrenNodeListParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Node_ChildrenNodeListParserRuleCall_1_2_0_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getChildrenNodeListParserRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createNode_ENDTerminalRuleCall_1_3ElementType() {
			return new IGrammarAwareElementType("Node_ENDTerminalRuleCall_1_3_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNodeAccess().getENDTerminalRuleCall_1_3());
		}
	}

	public static final IGrammarAwareElementType Node_ELEMENT_TYPE = associate(NodeFactory.createNodeElementType());

	public static final IGrammarAwareElementType Node_Group_ELEMENT_TYPE = associate(NodeFactory.createNode_GroupElementType());

	public static final IGrammarAwareElementType Node_NameAssignment_0_ELEMENT_TYPE = associate(NodeFactory.createNode_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Node_NameStringParserRuleCall_0_0_ELEMENT_TYPE = associate(NodeFactory.createNode_NameStringParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Node_Group_1_ELEMENT_TYPE = associate(NodeFactory.createNode_Group_1ElementType());

	public static final IGrammarAwareElementType Node_NLTerminalRuleCall_1_0_ELEMENT_TYPE = associate(NodeFactory.createNode_NLTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Node_BEGINTerminalRuleCall_1_1_ELEMENT_TYPE = associate(NodeFactory.createNode_BEGINTerminalRuleCall_1_1ElementType());

	public static final IGrammarAwareElementType Node_ChildrenAssignment_1_2_ELEMENT_TYPE = associate(NodeFactory.createNode_ChildrenAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Node_ChildrenNodeListParserRuleCall_1_2_0_ELEMENT_TYPE = associate(NodeFactory.createNode_ChildrenNodeListParserRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType Node_ENDTerminalRuleCall_1_3_ELEMENT_TYPE = associate(NodeFactory.createNode_ENDTerminalRuleCall_1_3ElementType());

	private static class StringFactory {
		public static IGrammarAwareElementType createStringElementType() {
			return new IGrammarAwareElementType("String_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStringRule());
		}
		public static IGrammarAwareElementType createString_OTHERTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("String_OTHERTerminalRuleCall_ELEMENT_TYPE", IndentationAwareTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStringAccess().getOTHERTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType String_ELEMENT_TYPE = associate(StringFactory.createStringElementType());

	public static final IGrammarAwareElementType String_OTHERTerminalRuleCall_ELEMENT_TYPE = associate(StringFactory.createString_OTHERTerminalRuleCallElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getNodeListElementType() {
		return NodeList_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeList_GroupElementType() {
		return NodeList_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeList_ChildrenAssignment_0ElementType() {
		return NodeList_ChildrenAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeList_ChildrenNodeParserRuleCall_0_0ElementType() {
		return NodeList_ChildrenNodeParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeList_Group_1ElementType() {
		return NodeList_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeList_NLTerminalRuleCall_1_0ElementType() {
		return NodeList_NLTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeList_ChildrenAssignment_1_1ElementType() {
		return NodeList_ChildrenAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNodeList_ChildrenNodeParserRuleCall_1_1_0ElementType() {
		return NodeList_ChildrenNodeParserRuleCall_1_1_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getNode_NameStringParserRuleCall_0_0ElementType() {
		return Node_NameStringParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_Group_1ElementType() {
		return Node_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_NLTerminalRuleCall_1_0ElementType() {
		return Node_NLTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_BEGINTerminalRuleCall_1_1ElementType() {
		return Node_BEGINTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_ChildrenAssignment_1_2ElementType() {
		return Node_ChildrenAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_ChildrenNodeListParserRuleCall_1_2_0ElementType() {
		return Node_ChildrenNodeListParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNode_ENDTerminalRuleCall_1_3ElementType() {
		return Node_ENDTerminalRuleCall_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStringElementType() {
		return String_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getString_OTHERTerminalRuleCallElementType() {
		return String_OTHERTerminalRuleCall_ELEMENT_TYPE;
	}

}
