package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.Bug302128TestLanguageFileImpl;
import org.eclipse.xtext.parsetree.reconstr.services.Bug302128TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug302128TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug302128TestLanguageFileImpl>>(Bug302128TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug302128TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug302128TestLanguageLanguage.INSTANCE.getInstance(Bug302128TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_ElementsAssignmentElementType() {
			return new IGrammarAwareElementType("Model_ElementsAssignment_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsAssignment());
		}
		public static IGrammarAwareElementType createModel_ElementsElementParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsElementParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_ElementsAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsAssignmentElementType());

	public static final IGrammarAwareElementType Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsElementParserRuleCall_0ElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_GroupElementType() {
			return new IGrammarAwareElementType("Element_Group_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_0_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createElement_NameVariableParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Element_NameVariableParserRuleCall_0_0_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameVariableParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createElement_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("Element_ValueAssignment_1_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createElement_ValueValueTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Element_ValueValueTerminalRuleCall_1_0_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getValueValueTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Group_ELEMENT_TYPE = associate(ElementFactory.createElement_GroupElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Element_NameVariableParserRuleCall_0_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameVariableParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Element_ValueAssignment_1_ELEMENT_TYPE = associate(ElementFactory.createElement_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType Element_ValueValueTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ValueValueTerminalRuleCall_1_0ElementType());

	private static class VariableFactory {
		public static IGrammarAwareElementType createVariableElementType() {
			return new IGrammarAwareElementType("Variable_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableRule());
		}
		public static IGrammarAwareElementType createVariable_GroupElementType() {
			return new IGrammarAwareElementType("Variable_Group_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getGroup());
		}
		public static IGrammarAwareElementType createVariable_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Variable_IDTerminalRuleCall_0_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createVariable_Group_1ElementType() {
			return new IGrammarAwareElementType("Variable_Group_1_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createVariable_Alternatives_1_0ElementType() {
			return new IGrammarAwareElementType("Variable_Alternatives_1_0_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getAlternatives_1_0());
		}
		public static IGrammarAwareElementType createVariable_FullStopKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Variable_FullStopKeyword_1_0_0_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getFullStopKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createVariable_HyphenMinusKeyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("Variable_HyphenMinusKeyword_1_0_1_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getHyphenMinusKeyword_1_0_1());
		}
		public static IGrammarAwareElementType createVariable_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("Variable_IDTerminalRuleCall_1_1_ELEMENT_TYPE", Bug302128TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType Variable_ELEMENT_TYPE = associate(VariableFactory.createVariableElementType());

	public static final IGrammarAwareElementType Variable_Group_ELEMENT_TYPE = associate(VariableFactory.createVariable_GroupElementType());

	public static final IGrammarAwareElementType Variable_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(VariableFactory.createVariable_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType Variable_Group_1_ELEMENT_TYPE = associate(VariableFactory.createVariable_Group_1ElementType());

	public static final IGrammarAwareElementType Variable_Alternatives_1_0_ELEMENT_TYPE = associate(VariableFactory.createVariable_Alternatives_1_0ElementType());

	public static final IGrammarAwareElementType Variable_FullStopKeyword_1_0_0_ELEMENT_TYPE = associate(VariableFactory.createVariable_FullStopKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Variable_HyphenMinusKeyword_1_0_1_ELEMENT_TYPE = associate(VariableFactory.createVariable_HyphenMinusKeyword_1_0_1ElementType());

	public static final IGrammarAwareElementType Variable_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(VariableFactory.createVariable_IDTerminalRuleCall_1_1ElementType());

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

	public IGrammarAwareElementType getElement_NameAssignment_0ElementType() {
		return Element_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameVariableParserRuleCall_0_0ElementType() {
		return Element_NameVariableParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ValueAssignment_1ElementType() {
		return Element_ValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ValueValueTerminalRuleCall_1_0ElementType() {
		return Element_ValueValueTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariableElementType() {
		return Variable_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_GroupElementType() {
		return Variable_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_IDTerminalRuleCall_0ElementType() {
		return Variable_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_Group_1ElementType() {
		return Variable_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_Alternatives_1_0ElementType() {
		return Variable_Alternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_FullStopKeyword_1_0_0ElementType() {
		return Variable_FullStopKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_HyphenMinusKeyword_1_0_1ElementType() {
		return Variable_HyphenMinusKeyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_IDTerminalRuleCall_1_1ElementType() {
		return Variable_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

}
