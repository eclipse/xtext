package org.eclipse.xtext.linking.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.IgnoreCaseNamespacesTestLanguageFileImpl;
import org.eclipse.xtext.linking.services.IgnoreCaseNamespacesTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class IgnoreCaseNamespacesTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<IgnoreCaseNamespacesTestLanguageFileImpl>>(IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final IgnoreCaseNamespacesTestLanguageGrammarAccess GRAMMAR_ACCESS = IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE.getInstance(IgnoreCaseNamespacesTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ImportsAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_ImportsAssignment_0_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getImportsAssignment_0());
		}
		public static IGrammarAwareElementType createModel_ImportsImportParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ImportsImportParserRuleCall_0_0_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getImportsImportParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_ElementsAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_ElementsAssignment_1_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsAssignment_1());
		}
		public static IGrammarAwareElementType createModel_ElementsElementParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ElementsElementParserRuleCall_1_0_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsElementParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ImportsAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ImportsAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_ImportsImportParserRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ImportsImportParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_ElementsAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_ElementsElementParserRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsElementParserRuleCall_1_0ElementType());

	private static class ImportFactory {
		public static IGrammarAwareElementType createImportElementType() {
			return new IGrammarAwareElementType("Import_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportRule());
		}
		public static IGrammarAwareElementType createImport_ImportedNamespaceAssignmentElementType() {
			return new IGrammarAwareElementType("Import_ImportedNamespaceAssignment_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getImportedNamespaceAssignment());
		}
		public static IGrammarAwareElementType createImport_ImportedNamespaceSTRINGTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Import_ImportedNamespaceSTRINGTerminalRuleCall_0_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getImportedNamespaceSTRINGTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Import_ELEMENT_TYPE = associate(ImportFactory.createImportElementType());

	public static final IGrammarAwareElementType Import_ImportedNamespaceAssignment_ELEMENT_TYPE = associate(ImportFactory.createImport_ImportedNamespaceAssignmentElementType());

	public static final IGrammarAwareElementType Import_ImportedNamespaceSTRINGTerminalRuleCall_0_ELEMENT_TYPE = associate(ImportFactory.createImport_ImportedNamespaceSTRINGTerminalRuleCall_0ElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_GroupElementType() {
			return new IGrammarAwareElementType("Element_Group_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_0_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createElement_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Element_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createElement_ReferenceAssignment_1ElementType() {
			return new IGrammarAwareElementType("Element_ReferenceAssignment_1_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getReferenceAssignment_1());
		}
		public static IGrammarAwareElementType createElement_ReferenceElementCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("Element_ReferenceElementCrossReference_1_0_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getReferenceElementCrossReference_1_0());
		}
		public static IGrammarAwareElementType createElement_ReferenceElementIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("Element_ReferenceElementIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getReferenceElementIDTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createElement_LeftCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("Element_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getLeftCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createElement_ElementsAssignment_3ElementType() {
			return new IGrammarAwareElementType("Element_ElementsAssignment_3_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementsAssignment_3());
		}
		public static IGrammarAwareElementType createElement_ElementsElementParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementsElementParserRuleCall_3_0_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementsElementParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createElement_RightCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("Element_RightCurlyBracketKeyword_4_ELEMENT_TYPE", IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getRightCurlyBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Group_ELEMENT_TYPE = associate(ElementFactory.createElement_GroupElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Element_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Element_ReferenceAssignment_1_ELEMENT_TYPE = associate(ElementFactory.createElement_ReferenceAssignment_1ElementType());

	public static final IGrammarAwareElementType Element_ReferenceElementCrossReference_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ReferenceElementCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType Element_ReferenceElementIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(ElementFactory.createElement_ReferenceElementIDTerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType Element_LeftCurlyBracketKeyword_2_ELEMENT_TYPE = associate(ElementFactory.createElement_LeftCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType Element_ElementsAssignment_3_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementsAssignment_3ElementType());

	public static final IGrammarAwareElementType Element_ElementsElementParserRuleCall_3_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementsElementParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Element_RightCurlyBracketKeyword_4_ELEMENT_TYPE = associate(ElementFactory.createElement_RightCurlyBracketKeyword_4ElementType());

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

	public IGrammarAwareElementType getModel_ImportsAssignment_0ElementType() {
		return Model_ImportsAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ImportsImportParserRuleCall_0_0ElementType() {
		return Model_ImportsImportParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ElementsAssignment_1ElementType() {
		return Model_ElementsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ElementsElementParserRuleCall_1_0ElementType() {
		return Model_ElementsElementParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImportElementType() {
		return Import_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_ImportedNamespaceAssignmentElementType() {
		return Import_ImportedNamespaceAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_ImportedNamespaceSTRINGTerminalRuleCall_0ElementType() {
		return Import_ImportedNamespaceSTRINGTerminalRuleCall_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getElement_NameIDTerminalRuleCall_0_0ElementType() {
		return Element_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ReferenceAssignment_1ElementType() {
		return Element_ReferenceAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ReferenceElementCrossReference_1_0ElementType() {
		return Element_ReferenceElementCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ReferenceElementIDTerminalRuleCall_1_0_1ElementType() {
		return Element_ReferenceElementIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_LeftCurlyBracketKeyword_2ElementType() {
		return Element_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementsAssignment_3ElementType() {
		return Element_ElementsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementsElementParserRuleCall_3_0ElementType() {
		return Element_ElementsElementParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_RightCurlyBracketKeyword_4ElementType() {
		return Element_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	}

}
