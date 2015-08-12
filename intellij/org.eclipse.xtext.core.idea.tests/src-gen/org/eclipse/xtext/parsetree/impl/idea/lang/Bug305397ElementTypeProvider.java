package org.eclipse.xtext.parsetree.impl.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.impl.idea.lang.psi.impl.Bug305397FileImpl;
import org.eclipse.xtext.parsetree.impl.services.Bug305397GrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug305397ElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug305397FileImpl>>(Bug305397Language.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug305397GrammarAccess GRAMMAR_ACCESS = Bug305397Language.INSTANCE.getInstance(Bug305397GrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_ElementsAssignmentElementType() {
			return new IGrammarAwareElementType("Model_ElementsAssignment_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsAssignment());
		}
		public static IGrammarAwareElementType createModel_ElementsElementParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsElementParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_ElementsAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsAssignmentElementType());

	public static final IGrammarAwareElementType Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsElementParserRuleCall_0ElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_GroupElementType() {
			return new IGrammarAwareElementType("Element_Group_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createElement_ElementAction_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementAction_0_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementAction_0());
		}
		public static IGrammarAwareElementType createElement_AAssignment_1ElementType() {
			return new IGrammarAwareElementType("Element_AAssignment_1_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getAAssignment_1());
		}
		public static IGrammarAwareElementType createElement_AAKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Element_AAKeyword_1_0_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getAAKeyword_1_0());
		}
		public static IGrammarAwareElementType createElement_ElementKeyword_2ElementType() {
			return new IGrammarAwareElementType("Element_ElementKeyword_2_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementKeyword_2());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_3ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_3_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_3());
		}
		public static IGrammarAwareElementType createElement_NameIDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Element_NameIDTerminalRuleCall_3_0_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameIDTerminalRuleCall_3_0());
		}
		public static IGrammarAwareElementType createElement_ElementsAssignment_4ElementType() {
			return new IGrammarAwareElementType("Element_ElementsAssignment_4_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementsAssignment_4());
		}
		public static IGrammarAwareElementType createElement_ElementsElementParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementsElementParserRuleCall_4_0_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementsElementParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createElement_EndKeyword_5ElementType() {
			return new IGrammarAwareElementType("Element_EndKeyword_5_ELEMENT_TYPE", Bug305397Language.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getEndKeyword_5());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Group_ELEMENT_TYPE = associate(ElementFactory.createElement_GroupElementType());

	public static final IGrammarAwareElementType Element_ElementAction_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementAction_0ElementType());

	public static final IGrammarAwareElementType Element_AAssignment_1_ELEMENT_TYPE = associate(ElementFactory.createElement_AAssignment_1ElementType());

	public static final IGrammarAwareElementType Element_AAKeyword_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_AAKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Element_ElementKeyword_2_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementKeyword_2ElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_3_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_3ElementType());

	public static final IGrammarAwareElementType Element_NameIDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameIDTerminalRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Element_ElementsAssignment_4_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementsAssignment_4ElementType());

	public static final IGrammarAwareElementType Element_ElementsElementParserRuleCall_4_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementsElementParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Element_EndKeyword_5_ELEMENT_TYPE = associate(ElementFactory.createElement_EndKeyword_5ElementType());

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

	public IGrammarAwareElementType getElement_ElementAction_0ElementType() {
		return Element_ElementAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_AAssignment_1ElementType() {
		return Element_AAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_AAKeyword_1_0ElementType() {
		return Element_AAKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementKeyword_2ElementType() {
		return Element_ElementKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameAssignment_3ElementType() {
		return Element_NameAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameIDTerminalRuleCall_3_0ElementType() {
		return Element_NameIDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementsAssignment_4ElementType() {
		return Element_ElementsAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementsElementParserRuleCall_4_0ElementType() {
		return Element_ElementsElementParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_EndKeyword_5ElementType() {
		return Element_EndKeyword_5_ELEMENT_TYPE;
	}

}
