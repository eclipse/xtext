package org.eclipse.xtext.parsetree.unassignedtext.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.psi.impl.UnassignedTextTestLanguageFileImpl;
import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class UnassignedTextTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<UnassignedTextTestLanguageFileImpl>>(UnassignedTextTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final UnassignedTextTestLanguageGrammarAccess GRAMMAR_ACCESS = UnassignedTextTestLanguageLanguage.INSTANCE.getInstance(UnassignedTextTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_CaseInsensitiveKeywordRuleParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_CaseInsensitiveKeywordRuleParserRuleCall_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getCaseInsensitiveKeywordRuleParserRuleCall_0());
		}
		public static IGrammarAwareElementType createModel_PluralRuleParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Model_PluralRuleParserRuleCall_1_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getPluralRuleParserRuleCall_1());
		}
		public static IGrammarAwareElementType createModel_MultiRuleParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Model_MultiRuleParserRuleCall_2_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiRuleParserRuleCall_2());
		}
		public static IGrammarAwareElementType createModel_DatatypeRuleParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Model_DatatypeRuleParserRuleCall_3_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDatatypeRuleParserRuleCall_3());
		}
		public static IGrammarAwareElementType createModel_CommonTerminalsRuleParserRuleCall_4ElementType() {
			return new IGrammarAwareElementType("Model_CommonTerminalsRuleParserRuleCall_4_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getCommonTerminalsRuleParserRuleCall_4());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_CaseInsensitiveKeywordRuleParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_CaseInsensitiveKeywordRuleParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Model_PluralRuleParserRuleCall_1_ELEMENT_TYPE = associate(ModelFactory.createModel_PluralRuleParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Model_MultiRuleParserRuleCall_2_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiRuleParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType Model_DatatypeRuleParserRuleCall_3_ELEMENT_TYPE = associate(ModelFactory.createModel_DatatypeRuleParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType Model_CommonTerminalsRuleParserRuleCall_4_ELEMENT_TYPE = associate(ModelFactory.createModel_CommonTerminalsRuleParserRuleCall_4ElementType());

	private static class CaseInsensitiveKeywordRuleFactory {
		public static IGrammarAwareElementType createCaseInsensitiveKeywordRuleElementType() {
			return new IGrammarAwareElementType("CaseInsensitiveKeywordRule_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCaseInsensitiveKeywordRuleRule());
		}
		public static IGrammarAwareElementType createCaseInsensitiveKeywordRule_GroupElementType() {
			return new IGrammarAwareElementType("CaseInsensitiveKeywordRule_Group_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCaseInsensitiveKeywordRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createCaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("CaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCaseInsensitiveKeywordRuleAccess().getCaseInsensitiveKeywordTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createCaseInsensitiveKeywordRule_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("CaseInsensitiveKeywordRule_ValAssignment_1_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCaseInsensitiveKeywordRuleAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createCaseInsensitiveKeywordRule_ValINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("CaseInsensitiveKeywordRule_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCaseInsensitiveKeywordRuleAccess().getValINTTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType CaseInsensitiveKeywordRule_ELEMENT_TYPE = associate(CaseInsensitiveKeywordRuleFactory.createCaseInsensitiveKeywordRuleElementType());

	public static final IGrammarAwareElementType CaseInsensitiveKeywordRule_Group_ELEMENT_TYPE = associate(CaseInsensitiveKeywordRuleFactory.createCaseInsensitiveKeywordRule_GroupElementType());

	public static final IGrammarAwareElementType CaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0_ELEMENT_TYPE = associate(CaseInsensitiveKeywordRuleFactory.createCaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType CaseInsensitiveKeywordRule_ValAssignment_1_ELEMENT_TYPE = associate(CaseInsensitiveKeywordRuleFactory.createCaseInsensitiveKeywordRule_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType CaseInsensitiveKeywordRule_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(CaseInsensitiveKeywordRuleFactory.createCaseInsensitiveKeywordRule_ValINTTerminalRuleCall_1_0ElementType());

	private static class PluralRuleFactory {
		public static IGrammarAwareElementType createPluralRuleElementType() {
			return new IGrammarAwareElementType("PluralRule_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPluralRuleRule());
		}
		public static IGrammarAwareElementType createPluralRule_GroupElementType() {
			return new IGrammarAwareElementType("PluralRule_Group_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPluralRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createPluralRule_ContentsKeyword_0ElementType() {
			return new IGrammarAwareElementType("PluralRule_ContentsKeyword_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPluralRuleAccess().getContentsKeyword_0());
		}
		public static IGrammarAwareElementType createPluralRule_CountAssignment_1ElementType() {
			return new IGrammarAwareElementType("PluralRule_CountAssignment_1_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPluralRuleAccess().getCountAssignment_1());
		}
		public static IGrammarAwareElementType createPluralRule_CountINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("PluralRule_CountINTTerminalRuleCall_1_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPluralRuleAccess().getCountINTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createPluralRule_PluralTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("PluralRule_PluralTerminalRuleCall_2_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPluralRuleAccess().getPluralTerminalRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType PluralRule_ELEMENT_TYPE = associate(PluralRuleFactory.createPluralRuleElementType());

	public static final IGrammarAwareElementType PluralRule_Group_ELEMENT_TYPE = associate(PluralRuleFactory.createPluralRule_GroupElementType());

	public static final IGrammarAwareElementType PluralRule_ContentsKeyword_0_ELEMENT_TYPE = associate(PluralRuleFactory.createPluralRule_ContentsKeyword_0ElementType());

	public static final IGrammarAwareElementType PluralRule_CountAssignment_1_ELEMENT_TYPE = associate(PluralRuleFactory.createPluralRule_CountAssignment_1ElementType());

	public static final IGrammarAwareElementType PluralRule_CountINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(PluralRuleFactory.createPluralRule_CountINTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType PluralRule_PluralTerminalRuleCall_2_ELEMENT_TYPE = associate(PluralRuleFactory.createPluralRule_PluralTerminalRuleCall_2ElementType());

	private static class MultiRuleFactory {
		public static IGrammarAwareElementType createMultiRuleElementType() {
			return new IGrammarAwareElementType("MultiRule_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiRuleRule());
		}
		public static IGrammarAwareElementType createMultiRule_GroupElementType() {
			return new IGrammarAwareElementType("MultiRule_Group_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createMultiRule_MultiKeyword_0ElementType() {
			return new IGrammarAwareElementType("MultiRule_MultiKeyword_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiRuleAccess().getMultiKeyword_0());
		}
		public static IGrammarAwareElementType createMultiRule_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("MultiRule_ValAssignment_1_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiRuleAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createMultiRule_ValINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("MultiRule_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiRuleAccess().getValINTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createMultiRule_MultiTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("MultiRule_MultiTerminalRuleCall_2_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiRuleAccess().getMultiTerminalRuleCall_2());
		}
		public static IGrammarAwareElementType createMultiRule_MultiTerminalRuleCall_3ElementType() {
			return new IGrammarAwareElementType("MultiRule_MultiTerminalRuleCall_3_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiRuleAccess().getMultiTerminalRuleCall_3());
		}
		public static IGrammarAwareElementType createMultiRule_MultiTerminalRuleCall_4ElementType() {
			return new IGrammarAwareElementType("MultiRule_MultiTerminalRuleCall_4_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiRuleAccess().getMultiTerminalRuleCall_4());
		}
	}

	public static final IGrammarAwareElementType MultiRule_ELEMENT_TYPE = associate(MultiRuleFactory.createMultiRuleElementType());

	public static final IGrammarAwareElementType MultiRule_Group_ELEMENT_TYPE = associate(MultiRuleFactory.createMultiRule_GroupElementType());

	public static final IGrammarAwareElementType MultiRule_MultiKeyword_0_ELEMENT_TYPE = associate(MultiRuleFactory.createMultiRule_MultiKeyword_0ElementType());

	public static final IGrammarAwareElementType MultiRule_ValAssignment_1_ELEMENT_TYPE = associate(MultiRuleFactory.createMultiRule_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType MultiRule_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(MultiRuleFactory.createMultiRule_ValINTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType MultiRule_MultiTerminalRuleCall_2_ELEMENT_TYPE = associate(MultiRuleFactory.createMultiRule_MultiTerminalRuleCall_2ElementType());

	public static final IGrammarAwareElementType MultiRule_MultiTerminalRuleCall_3_ELEMENT_TYPE = associate(MultiRuleFactory.createMultiRule_MultiTerminalRuleCall_3ElementType());

	public static final IGrammarAwareElementType MultiRule_MultiTerminalRuleCall_4_ELEMENT_TYPE = associate(MultiRuleFactory.createMultiRule_MultiTerminalRuleCall_4ElementType());

	private static class DatatypeRuleFactory {
		public static IGrammarAwareElementType createDatatypeRuleElementType() {
			return new IGrammarAwareElementType("DatatypeRule_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRuleRule());
		}
		public static IGrammarAwareElementType createDatatypeRule_GroupElementType() {
			return new IGrammarAwareElementType("DatatypeRule_Group_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createDatatypeRule_DatatypeKeyword_0ElementType() {
			return new IGrammarAwareElementType("DatatypeRule_DatatypeKeyword_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRuleAccess().getDatatypeKeyword_0());
		}
		public static IGrammarAwareElementType createDatatypeRule_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("DatatypeRule_ValAssignment_1_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRuleAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createDatatypeRule_ValINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("DatatypeRule_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRuleAccess().getValINTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createDatatypeRule_DatatypeParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("DatatypeRule_DatatypeParserRuleCall_2_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRuleAccess().getDatatypeParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType DatatypeRule_ELEMENT_TYPE = associate(DatatypeRuleFactory.createDatatypeRuleElementType());

	public static final IGrammarAwareElementType DatatypeRule_Group_ELEMENT_TYPE = associate(DatatypeRuleFactory.createDatatypeRule_GroupElementType());

	public static final IGrammarAwareElementType DatatypeRule_DatatypeKeyword_0_ELEMENT_TYPE = associate(DatatypeRuleFactory.createDatatypeRule_DatatypeKeyword_0ElementType());

	public static final IGrammarAwareElementType DatatypeRule_ValAssignment_1_ELEMENT_TYPE = associate(DatatypeRuleFactory.createDatatypeRule_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType DatatypeRule_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(DatatypeRuleFactory.createDatatypeRule_ValINTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType DatatypeRule_DatatypeParserRuleCall_2_ELEMENT_TYPE = associate(DatatypeRuleFactory.createDatatypeRule_DatatypeParserRuleCall_2ElementType());

	private static class DatatypeFactory {
		public static IGrammarAwareElementType createDatatypeElementType() {
			return new IGrammarAwareElementType("Datatype_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRule());
		}
		public static IGrammarAwareElementType createDatatype_AlternativesElementType() {
			return new IGrammarAwareElementType("Datatype_Alternatives_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createDatatype_StrKeyword_0ElementType() {
			return new IGrammarAwareElementType("Datatype_StrKeyword_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getStrKeyword_0());
		}
		public static IGrammarAwareElementType createDatatype_INTTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Datatype_INTTerminalRuleCall_1_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getINTTerminalRuleCall_1());
		}
		public static IGrammarAwareElementType createDatatype_Datatype2ParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Datatype_Datatype2ParserRuleCall_2_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getDatatype2ParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType Datatype_ELEMENT_TYPE = associate(DatatypeFactory.createDatatypeElementType());

	public static final IGrammarAwareElementType Datatype_Alternatives_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_AlternativesElementType());

	public static final IGrammarAwareElementType Datatype_StrKeyword_0_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_StrKeyword_0ElementType());

	public static final IGrammarAwareElementType Datatype_INTTerminalRuleCall_1_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_INTTerminalRuleCall_1ElementType());

	public static final IGrammarAwareElementType Datatype_Datatype2ParserRuleCall_2_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_Datatype2ParserRuleCall_2ElementType());

	private static class Datatype2Factory {
		public static IGrammarAwareElementType createDatatype2ElementType() {
			return new IGrammarAwareElementType("Datatype2_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatype2Rule());
		}
		public static IGrammarAwareElementType createDatatype2_STRINGTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("Datatype2_STRINGTerminalRuleCall_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatype2Access().getSTRINGTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType Datatype2_ELEMENT_TYPE = associate(Datatype2Factory.createDatatype2ElementType());

	public static final IGrammarAwareElementType Datatype2_STRINGTerminalRuleCall_ELEMENT_TYPE = associate(Datatype2Factory.createDatatype2_STRINGTerminalRuleCallElementType());

	private static class CommonTerminalsRuleFactory {
		public static IGrammarAwareElementType createCommonTerminalsRuleElementType() {
			return new IGrammarAwareElementType("CommonTerminalsRule_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommonTerminalsRuleRule());
		}
		public static IGrammarAwareElementType createCommonTerminalsRule_GroupElementType() {
			return new IGrammarAwareElementType("CommonTerminalsRule_Group_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommonTerminalsRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createCommonTerminalsRule_TerminalsKeyword_0ElementType() {
			return new IGrammarAwareElementType("CommonTerminalsRule_TerminalsKeyword_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommonTerminalsRuleAccess().getTerminalsKeyword_0());
		}
		public static IGrammarAwareElementType createCommonTerminalsRule_IDTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("CommonTerminalsRule_IDTerminalRuleCall_1_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommonTerminalsRuleAccess().getIDTerminalRuleCall_1());
		}
		public static IGrammarAwareElementType createCommonTerminalsRule_INTTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("CommonTerminalsRule_INTTerminalRuleCall_2_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommonTerminalsRuleAccess().getINTTerminalRuleCall_2());
		}
		public static IGrammarAwareElementType createCommonTerminalsRule_STRINGTerminalRuleCall_3ElementType() {
			return new IGrammarAwareElementType("CommonTerminalsRule_STRINGTerminalRuleCall_3_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommonTerminalsRuleAccess().getSTRINGTerminalRuleCall_3());
		}
		public static IGrammarAwareElementType createCommonTerminalsRule_ValAssignment_4ElementType() {
			return new IGrammarAwareElementType("CommonTerminalsRule_ValAssignment_4_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommonTerminalsRuleAccess().getValAssignment_4());
		}
		public static IGrammarAwareElementType createCommonTerminalsRule_ValIDTerminalRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("CommonTerminalsRule_ValIDTerminalRuleCall_4_0_ELEMENT_TYPE", UnassignedTextTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommonTerminalsRuleAccess().getValIDTerminalRuleCall_4_0());
		}
	}

	public static final IGrammarAwareElementType CommonTerminalsRule_ELEMENT_TYPE = associate(CommonTerminalsRuleFactory.createCommonTerminalsRuleElementType());

	public static final IGrammarAwareElementType CommonTerminalsRule_Group_ELEMENT_TYPE = associate(CommonTerminalsRuleFactory.createCommonTerminalsRule_GroupElementType());

	public static final IGrammarAwareElementType CommonTerminalsRule_TerminalsKeyword_0_ELEMENT_TYPE = associate(CommonTerminalsRuleFactory.createCommonTerminalsRule_TerminalsKeyword_0ElementType());

	public static final IGrammarAwareElementType CommonTerminalsRule_IDTerminalRuleCall_1_ELEMENT_TYPE = associate(CommonTerminalsRuleFactory.createCommonTerminalsRule_IDTerminalRuleCall_1ElementType());

	public static final IGrammarAwareElementType CommonTerminalsRule_INTTerminalRuleCall_2_ELEMENT_TYPE = associate(CommonTerminalsRuleFactory.createCommonTerminalsRule_INTTerminalRuleCall_2ElementType());

	public static final IGrammarAwareElementType CommonTerminalsRule_STRINGTerminalRuleCall_3_ELEMENT_TYPE = associate(CommonTerminalsRuleFactory.createCommonTerminalsRule_STRINGTerminalRuleCall_3ElementType());

	public static final IGrammarAwareElementType CommonTerminalsRule_ValAssignment_4_ELEMENT_TYPE = associate(CommonTerminalsRuleFactory.createCommonTerminalsRule_ValAssignment_4ElementType());

	public static final IGrammarAwareElementType CommonTerminalsRule_ValIDTerminalRuleCall_4_0_ELEMENT_TYPE = associate(CommonTerminalsRuleFactory.createCommonTerminalsRule_ValIDTerminalRuleCall_4_0ElementType());

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

	public IGrammarAwareElementType getModel_CaseInsensitiveKeywordRuleParserRuleCall_0ElementType() {
		return Model_CaseInsensitiveKeywordRuleParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_PluralRuleParserRuleCall_1ElementType() {
		return Model_PluralRuleParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiRuleParserRuleCall_2ElementType() {
		return Model_MultiRuleParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DatatypeRuleParserRuleCall_3ElementType() {
		return Model_DatatypeRuleParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_CommonTerminalsRuleParserRuleCall_4ElementType() {
		return Model_CommonTerminalsRuleParserRuleCall_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCaseInsensitiveKeywordRuleElementType() {
		return CaseInsensitiveKeywordRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCaseInsensitiveKeywordRule_GroupElementType() {
		return CaseInsensitiveKeywordRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0ElementType() {
		return CaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCaseInsensitiveKeywordRule_ValAssignment_1ElementType() {
		return CaseInsensitiveKeywordRule_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCaseInsensitiveKeywordRule_ValINTTerminalRuleCall_1_0ElementType() {
		return CaseInsensitiveKeywordRule_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPluralRuleElementType() {
		return PluralRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPluralRule_GroupElementType() {
		return PluralRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPluralRule_ContentsKeyword_0ElementType() {
		return PluralRule_ContentsKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPluralRule_CountAssignment_1ElementType() {
		return PluralRule_CountAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPluralRule_CountINTTerminalRuleCall_1_0ElementType() {
		return PluralRule_CountINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPluralRule_PluralTerminalRuleCall_2ElementType() {
		return PluralRule_PluralTerminalRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiRuleElementType() {
		return MultiRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiRule_GroupElementType() {
		return MultiRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiRule_MultiKeyword_0ElementType() {
		return MultiRule_MultiKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiRule_ValAssignment_1ElementType() {
		return MultiRule_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiRule_ValINTTerminalRuleCall_1_0ElementType() {
		return MultiRule_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiRule_MultiTerminalRuleCall_2ElementType() {
		return MultiRule_MultiTerminalRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiRule_MultiTerminalRuleCall_3ElementType() {
		return MultiRule_MultiTerminalRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiRule_MultiTerminalRuleCall_4ElementType() {
		return MultiRule_MultiTerminalRuleCall_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeRuleElementType() {
		return DatatypeRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeRule_GroupElementType() {
		return DatatypeRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeRule_DatatypeKeyword_0ElementType() {
		return DatatypeRule_DatatypeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeRule_ValAssignment_1ElementType() {
		return DatatypeRule_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeRule_ValINTTerminalRuleCall_1_0ElementType() {
		return DatatypeRule_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeRule_DatatypeParserRuleCall_2ElementType() {
		return DatatypeRule_DatatypeParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeElementType() {
		return Datatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_AlternativesElementType() {
		return Datatype_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_StrKeyword_0ElementType() {
		return Datatype_StrKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_INTTerminalRuleCall_1ElementType() {
		return Datatype_INTTerminalRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_Datatype2ParserRuleCall_2ElementType() {
		return Datatype_Datatype2ParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype2ElementType() {
		return Datatype2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype2_STRINGTerminalRuleCallElementType() {
		return Datatype2_STRINGTerminalRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommonTerminalsRuleElementType() {
		return CommonTerminalsRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommonTerminalsRule_GroupElementType() {
		return CommonTerminalsRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommonTerminalsRule_TerminalsKeyword_0ElementType() {
		return CommonTerminalsRule_TerminalsKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommonTerminalsRule_IDTerminalRuleCall_1ElementType() {
		return CommonTerminalsRule_IDTerminalRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommonTerminalsRule_INTTerminalRuleCall_2ElementType() {
		return CommonTerminalsRule_INTTerminalRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommonTerminalsRule_STRINGTerminalRuleCall_3ElementType() {
		return CommonTerminalsRule_STRINGTerminalRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommonTerminalsRule_ValAssignment_4ElementType() {
		return CommonTerminalsRule_ValAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommonTerminalsRule_ValIDTerminalRuleCall_4_0ElementType() {
		return CommonTerminalsRule_ValIDTerminalRuleCall_4_0_ELEMENT_TYPE;
	}

}
