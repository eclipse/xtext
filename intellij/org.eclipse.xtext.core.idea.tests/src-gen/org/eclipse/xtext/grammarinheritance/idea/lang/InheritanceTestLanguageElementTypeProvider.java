package org.eclipse.xtext.grammarinheritance.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl.InheritanceTestLanguageFileImpl;
import org.eclipse.xtext.grammarinheritance.services.InheritanceTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class InheritanceTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<InheritanceTestLanguageFileImpl>>(InheritanceTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final InheritanceTestLanguageGrammarAccess GRAMMAR_ACCESS = InheritanceTestLanguageLanguage.INSTANCE.getInstance(InheritanceTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ModelKeyword_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelKeyword_0_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelKeyword_0());
		}
		public static IGrammarAwareElementType createModel_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_NameAssignment_1_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createModel_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModel_LeftCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("Model_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getLeftCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createModel_ElementsAssignment_3ElementType() {
			return new IGrammarAwareElementType("Model_ElementsAssignment_3_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsAssignment_3());
		}
		public static IGrammarAwareElementType createModel_ElementsElementParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Model_ElementsElementParserRuleCall_3_0_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsElementParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createModel_RightCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("Model_RightCurlyBracketKeyword_4_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRightCurlyBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ModelKeyword_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelKeyword_0ElementType());

	public static final IGrammarAwareElementType Model_NameAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Model_LeftCurlyBracketKeyword_2_ELEMENT_TYPE = associate(ModelFactory.createModel_LeftCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType Model_ElementsAssignment_3_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsAssignment_3ElementType());

	public static final IGrammarAwareElementType Model_ElementsElementParserRuleCall_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsElementParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Model_RightCurlyBracketKeyword_4_ELEMENT_TYPE = associate(ModelFactory.createModel_RightCurlyBracketKeyword_4ElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_GroupElementType() {
			return new IGrammarAwareElementType("Element_Group_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createElement_ElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementKeyword_0_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementKeyword_0());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_1_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createElement_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Element_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Group_ELEMENT_TYPE = associate(ElementFactory.createElement_GroupElementType());

	public static final IGrammarAwareElementType Element_ElementKeyword_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementKeyword_0ElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_1_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Element_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameIDTerminalRuleCall_1_0ElementType());

	private static class FQNFactory {
		public static IGrammarAwareElementType createFQNElementType() {
			return new IGrammarAwareElementType("FQN_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNRule());
		}
		public static IGrammarAwareElementType createFQN_GroupElementType() {
			return new IGrammarAwareElementType("FQN_Group_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_0_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN_Group_1ElementType() {
			return new IGrammarAwareElementType("FQN_Group_1_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createFQN_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("FQN_FullStopKeyword_1_0_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE", InheritanceTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_1_1());
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

	public IGrammarAwareElementType getModel_GroupElementType() {
		return Model_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ModelKeyword_0ElementType() {
		return Model_ModelKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameAssignment_1ElementType() {
		return Model_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameIDTerminalRuleCall_1_0ElementType() {
		return Model_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_LeftCurlyBracketKeyword_2ElementType() {
		return Model_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ElementsAssignment_3ElementType() {
		return Model_ElementsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ElementsElementParserRuleCall_3_0ElementType() {
		return Model_ElementsElementParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RightCurlyBracketKeyword_4ElementType() {
		return Model_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
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
