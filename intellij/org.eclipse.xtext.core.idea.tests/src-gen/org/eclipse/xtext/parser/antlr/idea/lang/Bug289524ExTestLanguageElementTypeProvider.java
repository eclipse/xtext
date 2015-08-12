package org.eclipse.xtext.parser.antlr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.lang.psi.impl.Bug289524ExTestLanguageFileImpl;
import org.eclipse.xtext.parser.antlr.services.Bug289524ExTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug289524ExTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug289524ExTestLanguageFileImpl>>(Bug289524ExTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug289524ExTestLanguageGrammarAccess GRAMMAR_ACCESS = Bug289524ExTestLanguageLanguage.INSTANCE.getInstance(Bug289524ExTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ModelAction_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelAction_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelAction_0());
		}
		public static IGrammarAwareElementType createModel_ModelKeyword_1ElementType() {
			return new IGrammarAwareElementType("Model_ModelKeyword_1_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelKeyword_1());
		}
		public static IGrammarAwareElementType createModel_RefsAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_RefsAssignment_2_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRefsAssignment_2());
		}
		public static IGrammarAwareElementType createModel_RefsModelElementParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Model_RefsModelElementParserRuleCall_2_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRefsModelElementParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ModelAction_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelAction_0ElementType());

	public static final IGrammarAwareElementType Model_ModelKeyword_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelKeyword_1ElementType());

	public static final IGrammarAwareElementType Model_RefsAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_RefsAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_RefsModelElementParserRuleCall_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_RefsModelElementParserRuleCall_2_0ElementType());

	private static class ModelElementFactory {
		public static IGrammarAwareElementType createModelElementElementType() {
			return new IGrammarAwareElementType("ModelElement_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementRule());
		}
		public static IGrammarAwareElementType createModelElement_GroupElementType() {
			return new IGrammarAwareElementType("ModelElement_Group_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createModelElement_ModelElementAction_0ElementType() {
			return new IGrammarAwareElementType("ModelElement_ModelElementAction_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getModelElementAction_0());
		}
		public static IGrammarAwareElementType createModelElement_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("ModelElement_Alternatives_1_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createModelElement_ContainmentsAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("ModelElement_ContainmentsAssignment_1_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getContainmentsAssignment_1_0());
		}
		public static IGrammarAwareElementType createModelElement_ContainmentsContainedParserRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("ModelElement_ContainmentsContainedParserRuleCall_1_0_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createModelElement_Group_1_1ElementType() {
			return new IGrammarAwareElementType("ModelElement_Group_1_1_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createModelElement_ReferenceKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("ModelElement_ReferenceKeyword_1_1_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getReferenceKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createModelElement_RefsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("ModelElement_RefsAssignment_1_1_1_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getRefsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createModelElement_RefsContainedCrossReference_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("ModelElement_RefsContainedCrossReference_1_1_1_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getRefsContainedCrossReference_1_1_1_0());
		}
		public static IGrammarAwareElementType createModelElement_RefsContainedIDTerminalRuleCall_1_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("ModelElement_RefsContainedIDTerminalRuleCall_1_1_1_0_1_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getRefsContainedIDTerminalRuleCall_1_1_1_0_1());
		}
		public static IGrammarAwareElementType createModelElement_Group_1_1_2ElementType() {
			return new IGrammarAwareElementType("ModelElement_Group_1_1_2_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getGroup_1_1_2());
		}
		public static IGrammarAwareElementType createModelElement_DollarSignKeyword_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("ModelElement_DollarSignKeyword_1_1_2_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getDollarSignKeyword_1_1_2_0());
		}
		public static IGrammarAwareElementType createModelElement_RefsAssignment_1_1_2_1ElementType() {
			return new IGrammarAwareElementType("ModelElement_RefsAssignment_1_1_2_1_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getRefsAssignment_1_1_2_1());
		}
		public static IGrammarAwareElementType createModelElement_RefsContainedCrossReference_1_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("ModelElement_RefsContainedCrossReference_1_1_2_1_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getRefsContainedCrossReference_1_1_2_1_0());
		}
		public static IGrammarAwareElementType createModelElement_RefsContainedIDTerminalRuleCall_1_1_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("ModelElement_RefsContainedIDTerminalRuleCall_1_1_2_1_0_1_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelElementAccess().getRefsContainedIDTerminalRuleCall_1_1_2_1_0_1());
		}
	}

	public static final IGrammarAwareElementType ModelElement_ELEMENT_TYPE = associate(ModelElementFactory.createModelElementElementType());

	public static final IGrammarAwareElementType ModelElement_Group_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_GroupElementType());

	public static final IGrammarAwareElementType ModelElement_ModelElementAction_0_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_ModelElementAction_0ElementType());

	public static final IGrammarAwareElementType ModelElement_Alternatives_1_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_Alternatives_1ElementType());

	public static final IGrammarAwareElementType ModelElement_ContainmentsAssignment_1_0_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_ContainmentsAssignment_1_0ElementType());

	public static final IGrammarAwareElementType ModelElement_ContainmentsContainedParserRuleCall_1_0_0_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_ContainmentsContainedParserRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType ModelElement_Group_1_1_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_Group_1_1ElementType());

	public static final IGrammarAwareElementType ModelElement_ReferenceKeyword_1_1_0_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_ReferenceKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType ModelElement_RefsAssignment_1_1_1_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_RefsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType ModelElement_RefsContainedCrossReference_1_1_1_0_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_RefsContainedCrossReference_1_1_1_0ElementType());

	public static final IGrammarAwareElementType ModelElement_RefsContainedIDTerminalRuleCall_1_1_1_0_1_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_RefsContainedIDTerminalRuleCall_1_1_1_0_1ElementType());

	public static final IGrammarAwareElementType ModelElement_Group_1_1_2_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_Group_1_1_2ElementType());

	public static final IGrammarAwareElementType ModelElement_DollarSignKeyword_1_1_2_0_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_DollarSignKeyword_1_1_2_0ElementType());

	public static final IGrammarAwareElementType ModelElement_RefsAssignment_1_1_2_1_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_RefsAssignment_1_1_2_1ElementType());

	public static final IGrammarAwareElementType ModelElement_RefsContainedCrossReference_1_1_2_1_0_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_RefsContainedCrossReference_1_1_2_1_0ElementType());

	public static final IGrammarAwareElementType ModelElement_RefsContainedIDTerminalRuleCall_1_1_2_1_0_1_ELEMENT_TYPE = associate(ModelElementFactory.createModelElement_RefsContainedIDTerminalRuleCall_1_1_2_1_0_1ElementType());

	private static class ContainedFactory {
		public static IGrammarAwareElementType createContainedElementType() {
			return new IGrammarAwareElementType("Contained_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainedRule());
		}
		public static IGrammarAwareElementType createContained_GroupElementType() {
			return new IGrammarAwareElementType("Contained_Group_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainedAccess().getGroup());
		}
		public static IGrammarAwareElementType createContained_ContainmentKeyword_0ElementType() {
			return new IGrammarAwareElementType("Contained_ContainmentKeyword_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainedAccess().getContainmentKeyword_0());
		}
		public static IGrammarAwareElementType createContained_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Contained_NameAssignment_1_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainedAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createContained_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Contained_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug289524ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContainedAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Contained_ELEMENT_TYPE = associate(ContainedFactory.createContainedElementType());

	public static final IGrammarAwareElementType Contained_Group_ELEMENT_TYPE = associate(ContainedFactory.createContained_GroupElementType());

	public static final IGrammarAwareElementType Contained_ContainmentKeyword_0_ELEMENT_TYPE = associate(ContainedFactory.createContained_ContainmentKeyword_0ElementType());

	public static final IGrammarAwareElementType Contained_NameAssignment_1_ELEMENT_TYPE = associate(ContainedFactory.createContained_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Contained_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ContainedFactory.createContained_NameIDTerminalRuleCall_1_0ElementType());

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

	public IGrammarAwareElementType getModel_ModelAction_0ElementType() {
		return Model_ModelAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ModelKeyword_1ElementType() {
		return Model_ModelKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RefsAssignment_2ElementType() {
		return Model_RefsAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RefsModelElementParserRuleCall_2_0ElementType() {
		return Model_RefsModelElementParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElementElementType() {
		return ModelElement_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_GroupElementType() {
		return ModelElement_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_ModelElementAction_0ElementType() {
		return ModelElement_ModelElementAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_Alternatives_1ElementType() {
		return ModelElement_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_ContainmentsAssignment_1_0ElementType() {
		return ModelElement_ContainmentsAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_ContainmentsContainedParserRuleCall_1_0_0ElementType() {
		return ModelElement_ContainmentsContainedParserRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_Group_1_1ElementType() {
		return ModelElement_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_ReferenceKeyword_1_1_0ElementType() {
		return ModelElement_ReferenceKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_RefsAssignment_1_1_1ElementType() {
		return ModelElement_RefsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_RefsContainedCrossReference_1_1_1_0ElementType() {
		return ModelElement_RefsContainedCrossReference_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_RefsContainedIDTerminalRuleCall_1_1_1_0_1ElementType() {
		return ModelElement_RefsContainedIDTerminalRuleCall_1_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_Group_1_1_2ElementType() {
		return ModelElement_Group_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_DollarSignKeyword_1_1_2_0ElementType() {
		return ModelElement_DollarSignKeyword_1_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_RefsAssignment_1_1_2_1ElementType() {
		return ModelElement_RefsAssignment_1_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_RefsContainedCrossReference_1_1_2_1_0ElementType() {
		return ModelElement_RefsContainedCrossReference_1_1_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElement_RefsContainedIDTerminalRuleCall_1_1_2_1_0_1ElementType() {
		return ModelElement_RefsContainedIDTerminalRuleCall_1_1_2_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContainedElementType() {
		return Contained_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContained_GroupElementType() {
		return Contained_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContained_ContainmentKeyword_0ElementType() {
		return Contained_ContainmentKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContained_NameAssignment_1ElementType() {
		return Contained_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContained_NameIDTerminalRuleCall_1_0ElementType() {
		return Contained_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

}
