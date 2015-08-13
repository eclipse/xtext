package org.eclipse.xtext.grammarinheritance.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl.InheritanceTest3LanguageFileImpl;
import org.eclipse.xtext.grammarinheritance.services.InheritanceTest3LanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class InheritanceTest3LanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<InheritanceTest3LanguageFileImpl>>(InheritanceTest3LanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final InheritanceTest3LanguageGrammarAccess GRAMMAR_ACCESS = InheritanceTest3LanguageLanguage.INSTANCE.getInstance(InheritanceTest3LanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_ModelParserRuleCallElementType() {
			return new IGrammarAwareElementType("Model_ModelParserRuleCall_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_ModelParserRuleCall_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelParserRuleCallElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_AlternativesElementType() {
			return new IGrammarAwareElementType("Element_Alternatives_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createElement_ElementParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementParserRuleCall_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementParserRuleCall_0());
		}
		public static IGrammarAwareElementType createElement_Group_1ElementType() {
			return new IGrammarAwareElementType("Element_Group_1_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createElement_ElementAction_1_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementAction_1_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementAction_1_0());
		}
		public static IGrammarAwareElementType createElement_ElementKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("Element_ElementKeyword_1_1_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementKeyword_1_1());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_1_2_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_1_2());
		}
		public static IGrammarAwareElementType createElement_NameIDTerminalRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Element_NameIDTerminalRuleCall_1_2_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameIDTerminalRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createElement_Group_2ElementType() {
			return new IGrammarAwareElementType("Element_Group_2_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createElement_ElementAction_2_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementAction_2_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementAction_2_0());
		}
		public static IGrammarAwareElementType createElement_ElementKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("Element_ElementKeyword_2_1_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementKeyword_2_1());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_2_2_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_2_2());
		}
		public static IGrammarAwareElementType createElement_NameSTRINGTerminalRuleCall_2_2_0ElementType() {
			return new IGrammarAwareElementType("Element_NameSTRINGTerminalRuleCall_2_2_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameSTRINGTerminalRuleCall_2_2_0());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Alternatives_ELEMENT_TYPE = associate(ElementFactory.createElement_AlternativesElementType());

	public static final IGrammarAwareElementType Element_ElementParserRuleCall_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Element_Group_1_ELEMENT_TYPE = associate(ElementFactory.createElement_Group_1ElementType());

	public static final IGrammarAwareElementType Element_ElementAction_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementAction_1_0ElementType());

	public static final IGrammarAwareElementType Element_ElementKeyword_1_1_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementKeyword_1_1ElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_1_2_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Element_NameIDTerminalRuleCall_1_2_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameIDTerminalRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType Element_Group_2_ELEMENT_TYPE = associate(ElementFactory.createElement_Group_2ElementType());

	public static final IGrammarAwareElementType Element_ElementAction_2_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementAction_2_0ElementType());

	public static final IGrammarAwareElementType Element_ElementKeyword_2_1_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementKeyword_2_1ElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_2_2_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_2_2ElementType());

	public static final IGrammarAwareElementType Element_NameSTRINGTerminalRuleCall_2_2_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameSTRINGTerminalRuleCall_2_2_0ElementType());

	private static class InheritanceTestLanguageModelFactory {
		public static IGrammarAwareElementType createInheritanceTestLanguageModelElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageModel_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageModelRule());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageModel_GroupElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageModel_Group_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageModel_ModelKeyword_0ElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageModel_ModelKeyword_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageModelAccess().getModelKeyword_0());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageModel_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageModel_NameAssignment_1_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageModelAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageModel_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageModel_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageModelAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageModel_LeftCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageModel_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageModelAccess().getLeftCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageModel_ElementsAssignment_3ElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageModel_ElementsAssignment_3_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageModelAccess().getElementsAssignment_3());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageModel_ElementsElementParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageModel_ElementsElementParserRuleCall_3_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageModelAccess().getElementsElementParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageModel_RightCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageModel_RightCurlyBracketKeyword_4_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageModelAccess().getRightCurlyBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType InheritanceTestLanguageModel_ELEMENT_TYPE = associate(InheritanceTestLanguageModelFactory.createInheritanceTestLanguageModelElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageModel_Group_ELEMENT_TYPE = associate(InheritanceTestLanguageModelFactory.createInheritanceTestLanguageModel_GroupElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageModel_ModelKeyword_0_ELEMENT_TYPE = associate(InheritanceTestLanguageModelFactory.createInheritanceTestLanguageModel_ModelKeyword_0ElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageModel_NameAssignment_1_ELEMENT_TYPE = associate(InheritanceTestLanguageModelFactory.createInheritanceTestLanguageModel_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageModel_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(InheritanceTestLanguageModelFactory.createInheritanceTestLanguageModel_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageModel_LeftCurlyBracketKeyword_2_ELEMENT_TYPE = associate(InheritanceTestLanguageModelFactory.createInheritanceTestLanguageModel_LeftCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageModel_ElementsAssignment_3_ELEMENT_TYPE = associate(InheritanceTestLanguageModelFactory.createInheritanceTestLanguageModel_ElementsAssignment_3ElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageModel_ElementsElementParserRuleCall_3_0_ELEMENT_TYPE = associate(InheritanceTestLanguageModelFactory.createInheritanceTestLanguageModel_ElementsElementParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageModel_RightCurlyBracketKeyword_4_ELEMENT_TYPE = associate(InheritanceTestLanguageModelFactory.createInheritanceTestLanguageModel_RightCurlyBracketKeyword_4ElementType());

	private static class InheritanceTestLanguageElementFactory {
		public static IGrammarAwareElementType createInheritanceTestLanguageElementElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageElement_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageElementRule());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageElement_GroupElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageElement_Group_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageElement_ElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageElement_ElementKeyword_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageElementAccess().getElementKeyword_0());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageElement_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageElement_NameAssignment_1_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageElementAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createInheritanceTestLanguageElement_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("InheritanceTestLanguageElement_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritanceTestLanguageElementAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType InheritanceTestLanguageElement_ELEMENT_TYPE = associate(InheritanceTestLanguageElementFactory.createInheritanceTestLanguageElementElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageElement_Group_ELEMENT_TYPE = associate(InheritanceTestLanguageElementFactory.createInheritanceTestLanguageElement_GroupElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageElement_ElementKeyword_0_ELEMENT_TYPE = associate(InheritanceTestLanguageElementFactory.createInheritanceTestLanguageElement_ElementKeyword_0ElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageElement_NameAssignment_1_ELEMENT_TYPE = associate(InheritanceTestLanguageElementFactory.createInheritanceTestLanguageElement_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType InheritanceTestLanguageElement_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(InheritanceTestLanguageElementFactory.createInheritanceTestLanguageElement_NameIDTerminalRuleCall_1_0ElementType());

	private static class FQNFactory {
		public static IGrammarAwareElementType createFQNElementType() {
			return new IGrammarAwareElementType("FQN_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNRule());
		}
		public static IGrammarAwareElementType createFQN_GroupElementType() {
			return new IGrammarAwareElementType("FQN_Group_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN_Group_1ElementType() {
			return new IGrammarAwareElementType("FQN_Group_1_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createFQN_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("FQN_FullStopKeyword_1_0_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE", InheritanceTest3LanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType FQN_ELEMENT_TYPE = associate(FQNFactory.createFQNElementType());

	public static final IGrammarAwareElementType FQN_Group_ELEMENT_TYPE = associate(FQNFactory.createFQN_GroupElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType FQN_Group_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_Group_1ElementType());

	public static final IGrammarAwareElementType FQN_FullStopKeyword_1_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_1_1ElementType());

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

	public IGrammarAwareElementType getModel_ModelParserRuleCallElementType() {
		return Model_ModelParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElementElementType() {
		return Element_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_AlternativesElementType() {
		return Element_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementParserRuleCall_0ElementType() {
		return Element_ElementParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_Group_1ElementType() {
		return Element_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementAction_1_0ElementType() {
		return Element_ElementAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementKeyword_1_1ElementType() {
		return Element_ElementKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameAssignment_1_2ElementType() {
		return Element_NameAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameIDTerminalRuleCall_1_2_0ElementType() {
		return Element_NameIDTerminalRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_Group_2ElementType() {
		return Element_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementAction_2_0ElementType() {
		return Element_ElementAction_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementKeyword_2_1ElementType() {
		return Element_ElementKeyword_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameAssignment_2_2ElementType() {
		return Element_NameAssignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameSTRINGTerminalRuleCall_2_2_0ElementType() {
		return Element_NameSTRINGTerminalRuleCall_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageModelElementType() {
		return InheritanceTestLanguageModel_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageModel_GroupElementType() {
		return InheritanceTestLanguageModel_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageModel_ModelKeyword_0ElementType() {
		return InheritanceTestLanguageModel_ModelKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageModel_NameAssignment_1ElementType() {
		return InheritanceTestLanguageModel_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageModel_NameIDTerminalRuleCall_1_0ElementType() {
		return InheritanceTestLanguageModel_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageModel_LeftCurlyBracketKeyword_2ElementType() {
		return InheritanceTestLanguageModel_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageModel_ElementsAssignment_3ElementType() {
		return InheritanceTestLanguageModel_ElementsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageModel_ElementsElementParserRuleCall_3_0ElementType() {
		return InheritanceTestLanguageModel_ElementsElementParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageModel_RightCurlyBracketKeyword_4ElementType() {
		return InheritanceTestLanguageModel_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageElementElementType() {
		return InheritanceTestLanguageElement_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageElement_GroupElementType() {
		return InheritanceTestLanguageElement_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageElement_ElementKeyword_0ElementType() {
		return InheritanceTestLanguageElement_ElementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageElement_NameAssignment_1ElementType() {
		return InheritanceTestLanguageElement_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritanceTestLanguageElement_NameIDTerminalRuleCall_1_0ElementType() {
		return InheritanceTestLanguageElement_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
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

}
