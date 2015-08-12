package org.eclipse.xtext.dummy.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.dummy.idea.lang.psi.impl.DummyTestLanguageFileImpl;
import org.eclipse.xtext.dummy.services.DummyTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class DummyTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<DummyTestLanguageFileImpl>>(DummyTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final DummyTestLanguageGrammarAccess GRAMMAR_ACCESS = DummyTestLanguageLanguage.INSTANCE.getInstance(DummyTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_ElementsAssignmentElementType() {
			return new IGrammarAwareElementType("Model_ElementsAssignment_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsAssignment());
		}
		public static IGrammarAwareElementType createModel_ElementsElementParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsElementParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_ElementsAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsAssignmentElementType());

	public static final IGrammarAwareElementType Model_ElementsElementParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsElementParserRuleCall_0ElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_GroupElementType() {
			return new IGrammarAwareElementType("Element_Group_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createElement_OptionalAssignment_0ElementType() {
			return new IGrammarAwareElementType("Element_OptionalAssignment_0_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getOptionalAssignment_0());
		}
		public static IGrammarAwareElementType createElement_OptionalOptionalKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Element_OptionalOptionalKeyword_0_0_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getOptionalOptionalKeyword_0_0());
		}
		public static IGrammarAwareElementType createElement_ElementKeyword_1ElementType() {
			return new IGrammarAwareElementType("Element_ElementKeyword_1_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementKeyword_1());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_2_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createElement_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Element_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createElement_DescriptionsAssignment_3ElementType() {
			return new IGrammarAwareElementType("Element_DescriptionsAssignment_3_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getDescriptionsAssignment_3());
		}
		public static IGrammarAwareElementType createElement_DescriptionsSTRINGTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Element_DescriptionsSTRINGTerminalRuleCall_3_0_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getDescriptionsSTRINGTerminalRuleCall_3_0());
		}
		public static IGrammarAwareElementType createElement_SemicolonKeyword_4ElementType() {
			return new IGrammarAwareElementType("Element_SemicolonKeyword_4_ELEMENT_TYPE", DummyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getSemicolonKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Group_ELEMENT_TYPE = associate(ElementFactory.createElement_GroupElementType());

	public static final IGrammarAwareElementType Element_OptionalAssignment_0_ELEMENT_TYPE = associate(ElementFactory.createElement_OptionalAssignment_0ElementType());

	public static final IGrammarAwareElementType Element_OptionalOptionalKeyword_0_0_ELEMENT_TYPE = associate(ElementFactory.createElement_OptionalOptionalKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Element_ElementKeyword_1_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementKeyword_1ElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_2_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType Element_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Element_DescriptionsAssignment_3_ELEMENT_TYPE = associate(ElementFactory.createElement_DescriptionsAssignment_3ElementType());

	public static final IGrammarAwareElementType Element_DescriptionsSTRINGTerminalRuleCall_3_0_ELEMENT_TYPE = associate(ElementFactory.createElement_DescriptionsSTRINGTerminalRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Element_SemicolonKeyword_4_ELEMENT_TYPE = associate(ElementFactory.createElement_SemicolonKeyword_4ElementType());

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

	public IGrammarAwareElementType getElement_OptionalAssignment_0ElementType() {
		return Element_OptionalAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_OptionalOptionalKeyword_0_0ElementType() {
		return Element_OptionalOptionalKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementKeyword_1ElementType() {
		return Element_ElementKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameAssignment_2ElementType() {
		return Element_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameIDTerminalRuleCall_2_0ElementType() {
		return Element_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_DescriptionsAssignment_3ElementType() {
		return Element_DescriptionsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_DescriptionsSTRINGTerminalRuleCall_3_0ElementType() {
		return Element_DescriptionsSTRINGTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_SemicolonKeyword_4ElementType() {
		return Element_SemicolonKeyword_4_ELEMENT_TYPE;
	}

}
