package org.eclipse.xtext.parser.terminalrules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.TerminalRulesTestLanguageFileImpl;
import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class TerminalRulesTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<TerminalRulesTestLanguageFileImpl>>(TerminalRulesTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final TerminalRulesTestLanguageGrammarAccess GRAMMAR_ACCESS = TerminalRulesTestLanguageLanguage.INSTANCE.getInstance(TerminalRulesTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_IdValueAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_IdValueAssignment_0_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getIdValueAssignment_0());
		}
		public static IGrammarAwareElementType createModel_IdValueIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_IdValueIDTerminalRuleCall_0_0_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getIdValueIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_IntValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_IntValueAssignment_1_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getIntValueAssignment_1());
		}
		public static IGrammarAwareElementType createModel_IntValueINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_IntValueINTTerminalRuleCall_1_0_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getIntValueINTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModel_StringValueAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_StringValueAssignment_2_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getStringValueAssignment_2());
		}
		public static IGrammarAwareElementType createModel_StringValueSTRINGTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Model_StringValueSTRINGTerminalRuleCall_2_0_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getStringValueSTRINGTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createModel_RichStringValueAssignment_3ElementType() {
			return new IGrammarAwareElementType("Model_RichStringValueAssignment_3_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRichStringValueAssignment_3());
		}
		public static IGrammarAwareElementType createModel_RichStringValueRICH_STRINGTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Model_RichStringValueRICH_STRINGTerminalRuleCall_3_0_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRichStringValueRICH_STRINGTerminalRuleCall_3_0());
		}
		public static IGrammarAwareElementType createModel_MlCommentValueAssignment_4ElementType() {
			return new IGrammarAwareElementType("Model_MlCommentValueAssignment_4_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMlCommentValueAssignment_4());
		}
		public static IGrammarAwareElementType createModel_MlCommentValueML_COMMENTTerminalRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Model_MlCommentValueML_COMMENTTerminalRuleCall_4_0_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMlCommentValueML_COMMENTTerminalRuleCall_4_0());
		}
		public static IGrammarAwareElementType createModel_SlCommentValueAssignment_5ElementType() {
			return new IGrammarAwareElementType("Model_SlCommentValueAssignment_5_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSlCommentValueAssignment_5());
		}
		public static IGrammarAwareElementType createModel_SlCommentValueSL_COMMENTTerminalRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("Model_SlCommentValueSL_COMMENTTerminalRuleCall_5_0_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSlCommentValueSL_COMMENTTerminalRuleCall_5_0());
		}
		public static IGrammarAwareElementType createModel_WsValueAssignment_6ElementType() {
			return new IGrammarAwareElementType("Model_WsValueAssignment_6_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getWsValueAssignment_6());
		}
		public static IGrammarAwareElementType createModel_WsValueWSTerminalRuleCall_6_0ElementType() {
			return new IGrammarAwareElementType("Model_WsValueWSTerminalRuleCall_6_0_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getWsValueWSTerminalRuleCall_6_0());
		}
		public static IGrammarAwareElementType createModel_AnyValueAssignment_7ElementType() {
			return new IGrammarAwareElementType("Model_AnyValueAssignment_7_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAnyValueAssignment_7());
		}
		public static IGrammarAwareElementType createModel_AnyValueANY_OTHERTerminalRuleCall_7_0ElementType() {
			return new IGrammarAwareElementType("Model_AnyValueANY_OTHERTerminalRuleCall_7_0_ELEMENT_TYPE", TerminalRulesTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAnyValueANY_OTHERTerminalRuleCall_7_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_IdValueAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_IdValueAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_IdValueIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_IdValueIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_IntValueAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_IntValueAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_IntValueINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_IntValueINTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Model_StringValueAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_StringValueAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_StringValueSTRINGTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_StringValueSTRINGTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Model_RichStringValueAssignment_3_ELEMENT_TYPE = associate(ModelFactory.createModel_RichStringValueAssignment_3ElementType());

	public static final IGrammarAwareElementType Model_RichStringValueRICH_STRINGTerminalRuleCall_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_RichStringValueRICH_STRINGTerminalRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Model_MlCommentValueAssignment_4_ELEMENT_TYPE = associate(ModelFactory.createModel_MlCommentValueAssignment_4ElementType());

	public static final IGrammarAwareElementType Model_MlCommentValueML_COMMENTTerminalRuleCall_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_MlCommentValueML_COMMENTTerminalRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Model_SlCommentValueAssignment_5_ELEMENT_TYPE = associate(ModelFactory.createModel_SlCommentValueAssignment_5ElementType());

	public static final IGrammarAwareElementType Model_SlCommentValueSL_COMMENTTerminalRuleCall_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SlCommentValueSL_COMMENTTerminalRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType Model_WsValueAssignment_6_ELEMENT_TYPE = associate(ModelFactory.createModel_WsValueAssignment_6ElementType());

	public static final IGrammarAwareElementType Model_WsValueWSTerminalRuleCall_6_0_ELEMENT_TYPE = associate(ModelFactory.createModel_WsValueWSTerminalRuleCall_6_0ElementType());

	public static final IGrammarAwareElementType Model_AnyValueAssignment_7_ELEMENT_TYPE = associate(ModelFactory.createModel_AnyValueAssignment_7ElementType());

	public static final IGrammarAwareElementType Model_AnyValueANY_OTHERTerminalRuleCall_7_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AnyValueANY_OTHERTerminalRuleCall_7_0ElementType());

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

	public IGrammarAwareElementType getModel_AlternativesElementType() {
		return Model_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_IdValueAssignment_0ElementType() {
		return Model_IdValueAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_IdValueIDTerminalRuleCall_0_0ElementType() {
		return Model_IdValueIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_IntValueAssignment_1ElementType() {
		return Model_IntValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_IntValueINTTerminalRuleCall_1_0ElementType() {
		return Model_IntValueINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_StringValueAssignment_2ElementType() {
		return Model_StringValueAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_StringValueSTRINGTerminalRuleCall_2_0ElementType() {
		return Model_StringValueSTRINGTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RichStringValueAssignment_3ElementType() {
		return Model_RichStringValueAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RichStringValueRICH_STRINGTerminalRuleCall_3_0ElementType() {
		return Model_RichStringValueRICH_STRINGTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MlCommentValueAssignment_4ElementType() {
		return Model_MlCommentValueAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MlCommentValueML_COMMENTTerminalRuleCall_4_0ElementType() {
		return Model_MlCommentValueML_COMMENTTerminalRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SlCommentValueAssignment_5ElementType() {
		return Model_SlCommentValueAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SlCommentValueSL_COMMENTTerminalRuleCall_5_0ElementType() {
		return Model_SlCommentValueSL_COMMENTTerminalRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_WsValueAssignment_6ElementType() {
		return Model_WsValueAssignment_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_WsValueWSTerminalRuleCall_6_0ElementType() {
		return Model_WsValueWSTerminalRuleCall_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AnyValueAssignment_7ElementType() {
		return Model_AnyValueAssignment_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AnyValueANY_OTHERTerminalRuleCall_7_0ElementType() {
		return Model_AnyValueANY_OTHERTerminalRuleCall_7_0_ELEMENT_TYPE;
	}

}
