package org.eclipse.xtext.parsetree.impl.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.impl.idea.lang.psi.impl.CommentAssociationTestLanguageFileImpl;
import org.eclipse.xtext.parsetree.impl.services.CommentAssociationTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class CommentAssociationTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<CommentAssociationTestLanguageFileImpl>>(CommentAssociationTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final CommentAssociationTestLanguageGrammarAccess GRAMMAR_ACCESS = CommentAssociationTestLanguageLanguage.INSTANCE.getInstance(CommentAssociationTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_ElementsAssignmentElementType() {
			return new IGrammarAwareElementType("Model_ElementsAssignment_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsAssignment());
		}
		public static IGrammarAwareElementType createModel_ElementsElementParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsElementParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_ElementsAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsAssignmentElementType());

	public static final IGrammarAwareElementType Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsElementParserRuleCall_0ElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_GroupElementType() {
			return new IGrammarAwareElementType("Element_Group_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createElement_ElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementKeyword_0_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementKeyword_0());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_1_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createElement_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Element_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createElement_Group_2ElementType() {
			return new IGrammarAwareElementType("Element_Group_2_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createElement_ElementChildAction_2_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementChildAction_2_0_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementChildAction_2_0());
		}
		public static IGrammarAwareElementType createElement_ParentKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("Element_ParentKeyword_2_1_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getParentKeyword_2_1());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_2_2_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_2_2());
		}
		public static IGrammarAwareElementType createElement_NameIDTerminalRuleCall_2_2_0ElementType() {
			return new IGrammarAwareElementType("Element_NameIDTerminalRuleCall_2_2_0_ELEMENT_TYPE", CommentAssociationTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameIDTerminalRuleCall_2_2_0());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Group_ELEMENT_TYPE = associate(ElementFactory.createElement_GroupElementType());

	public static final IGrammarAwareElementType Element_ElementKeyword_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementKeyword_0ElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_1_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Element_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Element_Group_2_ELEMENT_TYPE = associate(ElementFactory.createElement_Group_2ElementType());

	public static final IGrammarAwareElementType Element_ElementChildAction_2_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementChildAction_2_0ElementType());

	public static final IGrammarAwareElementType Element_ParentKeyword_2_1_ELEMENT_TYPE = associate(ElementFactory.createElement_ParentKeyword_2_1ElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_2_2_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_2_2ElementType());

	public static final IGrammarAwareElementType Element_NameIDTerminalRuleCall_2_2_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameIDTerminalRuleCall_2_2_0ElementType());

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

	public IGrammarAwareElementType getModel_ElementsAssignmentElementType() {
		return Model_ElementsAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ElementsElementParserRuleCall_0ElementType() {
		return Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElementElementType() {
		return Element_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_GroupElementType() {
		return Element_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementKeyword_0ElementType() {
		return Element_ElementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameAssignment_1ElementType() {
		return Element_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameIDTerminalRuleCall_1_0ElementType() {
		return Element_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_Group_2ElementType() {
		return Element_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementChildAction_2_0ElementType() {
		return Element_ElementChildAction_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ParentKeyword_2_1ElementType() {
		return Element_ParentKeyword_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameAssignment_2_2ElementType() {
		return Element_NameAssignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameIDTerminalRuleCall_2_2_0ElementType() {
		return Element_NameIDTerminalRuleCall_2_2_0_ELEMENT_TYPE;
	}

}
