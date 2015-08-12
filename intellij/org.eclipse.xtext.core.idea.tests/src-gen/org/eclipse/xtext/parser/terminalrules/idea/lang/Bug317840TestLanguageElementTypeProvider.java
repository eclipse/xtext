package org.eclipse.xtext.parser.terminalrules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.Bug317840TestLanguageFileImpl;
import org.eclipse.xtext.parser.terminalrules.services.Bug317840TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug317840TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug317840TestLanguageFileImpl>>(Bug317840TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug317840TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug317840TestLanguageLanguage.INSTANCE.getInstance(Bug317840TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_ElementsAssignmentElementType() {
			return new IGrammarAwareElementType("Model_ElementsAssignment_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsAssignment());
		}
		public static IGrammarAwareElementType createModel_ElementsElementParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsElementParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_ElementsAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsAssignmentElementType());

	public static final IGrammarAwareElementType Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsElementParserRuleCall_0ElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_GroupElementType() {
			return new IGrammarAwareElementType("Element_Group_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createElement_ElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementKeyword_0_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementKeyword_0());
		}
		public static IGrammarAwareElementType createElement_FirstAssignment_1ElementType() {
			return new IGrammarAwareElementType("Element_FirstAssignment_1_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getFirstAssignment_1());
		}
		public static IGrammarAwareElementType createElement_FirstNamedParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Element_FirstNamedParserRuleCall_1_0_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getFirstNamedParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createElement_SecondAssignment_2ElementType() {
			return new IGrammarAwareElementType("Element_SecondAssignment_2_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getSecondAssignment_2());
		}
		public static IGrammarAwareElementType createElement_SecondNamedParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Element_SecondNamedParserRuleCall_2_0_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getSecondNamedParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createElement_Group_3ElementType() {
			return new IGrammarAwareElementType("Element_Group_3_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createElement_ThirdAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("Element_ThirdAssignment_3_0_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getThirdAssignment_3_0());
		}
		public static IGrammarAwareElementType createElement_ThirdNamedParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("Element_ThirdNamedParserRuleCall_3_0_0_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getThirdNamedParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createElement_ForthAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Element_ForthAssignment_3_1_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getForthAssignment_3_1());
		}
		public static IGrammarAwareElementType createElement_ForthNamedParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Element_ForthNamedParserRuleCall_3_1_0_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getForthNamedParserRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Group_ELEMENT_TYPE = associate(ElementFactory.createElement_GroupElementType());

	public static final IGrammarAwareElementType Element_ElementKeyword_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementKeyword_0ElementType());

	public static final IGrammarAwareElementType Element_FirstAssignment_1_ELEMENT_TYPE = associate(ElementFactory.createElement_FirstAssignment_1ElementType());

	public static final IGrammarAwareElementType Element_FirstNamedParserRuleCall_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_FirstNamedParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Element_SecondAssignment_2_ELEMENT_TYPE = associate(ElementFactory.createElement_SecondAssignment_2ElementType());

	public static final IGrammarAwareElementType Element_SecondNamedParserRuleCall_2_0_ELEMENT_TYPE = associate(ElementFactory.createElement_SecondNamedParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Element_Group_3_ELEMENT_TYPE = associate(ElementFactory.createElement_Group_3ElementType());

	public static final IGrammarAwareElementType Element_ThirdAssignment_3_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ThirdAssignment_3_0ElementType());

	public static final IGrammarAwareElementType Element_ThirdNamedParserRuleCall_3_0_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ThirdNamedParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType Element_ForthAssignment_3_1_ELEMENT_TYPE = associate(ElementFactory.createElement_ForthAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Element_ForthNamedParserRuleCall_3_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ForthNamedParserRuleCall_3_1_0ElementType());

	private static class NamedFactory {
		public static IGrammarAwareElementType createNamedElementType() {
			return new IGrammarAwareElementType("Named_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedRule());
		}
		public static IGrammarAwareElementType createNamed_NameAssignmentElementType() {
			return new IGrammarAwareElementType("Named_NameAssignment_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createNamed_NameNAMEParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Named_NameNAMEParserRuleCall_0_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedAccess().getNameNAMEParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Named_ELEMENT_TYPE = associate(NamedFactory.createNamedElementType());

	public static final IGrammarAwareElementType Named_NameAssignment_ELEMENT_TYPE = associate(NamedFactory.createNamed_NameAssignmentElementType());

	public static final IGrammarAwareElementType Named_NameNAMEParserRuleCall_0_ELEMENT_TYPE = associate(NamedFactory.createNamed_NameNAMEParserRuleCall_0ElementType());

	private static class NAMEFactory {
		public static IGrammarAwareElementType createNAMEElementType() {
			return new IGrammarAwareElementType("NAME_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNAMERule());
		}
		public static IGrammarAwareElementType createNAME_GroupElementType() {
			return new IGrammarAwareElementType("NAME_Group_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNAMEAccess().getGroup());
		}
		public static IGrammarAwareElementType createNAME_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("NAME_IDTerminalRuleCall_0_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNAMEAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createNAME_Group_1ElementType() {
			return new IGrammarAwareElementType("NAME_Group_1_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNAMEAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createNAME_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("NAME_FullStopKeyword_1_0_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNAMEAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createNAME_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("NAME_IDTerminalRuleCall_1_1_ELEMENT_TYPE", Bug317840TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNAMEAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType NAME_ELEMENT_TYPE = associate(NAMEFactory.createNAMEElementType());

	public static final IGrammarAwareElementType NAME_Group_ELEMENT_TYPE = associate(NAMEFactory.createNAME_GroupElementType());

	public static final IGrammarAwareElementType NAME_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(NAMEFactory.createNAME_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType NAME_Group_1_ELEMENT_TYPE = associate(NAMEFactory.createNAME_Group_1ElementType());

	public static final IGrammarAwareElementType NAME_FullStopKeyword_1_0_ELEMENT_TYPE = associate(NAMEFactory.createNAME_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType NAME_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(NAMEFactory.createNAME_IDTerminalRuleCall_1_1ElementType());

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

	public IGrammarAwareElementType getElement_FirstAssignment_1ElementType() {
		return Element_FirstAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_FirstNamedParserRuleCall_1_0ElementType() {
		return Element_FirstNamedParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_SecondAssignment_2ElementType() {
		return Element_SecondAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_SecondNamedParserRuleCall_2_0ElementType() {
		return Element_SecondNamedParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_Group_3ElementType() {
		return Element_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ThirdAssignment_3_0ElementType() {
		return Element_ThirdAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ThirdNamedParserRuleCall_3_0_0ElementType() {
		return Element_ThirdNamedParserRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ForthAssignment_3_1ElementType() {
		return Element_ForthAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ForthNamedParserRuleCall_3_1_0ElementType() {
		return Element_ForthNamedParserRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedElementType() {
		return Named_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamed_NameAssignmentElementType() {
		return Named_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamed_NameNAMEParserRuleCall_0ElementType() {
		return Named_NameNAMEParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNAMEElementType() {
		return NAME_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNAME_GroupElementType() {
		return NAME_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNAME_IDTerminalRuleCall_0ElementType() {
		return NAME_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNAME_Group_1ElementType() {
		return NAME_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNAME_FullStopKeyword_1_0ElementType() {
		return NAME_FullStopKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNAME_IDTerminalRuleCall_1_1ElementType() {
		return NAME_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

}
