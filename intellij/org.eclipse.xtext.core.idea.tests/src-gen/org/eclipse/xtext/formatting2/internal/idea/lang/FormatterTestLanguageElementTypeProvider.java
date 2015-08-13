package org.eclipse.xtext.formatting2.internal.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.formatting2.internal.idea.lang.psi.impl.FormatterTestLanguageFileImpl;
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class FormatterTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<FormatterTestLanguageFileImpl>>(FormatterTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final FormatterTestLanguageGrammarAccess GRAMMAR_ACCESS = FormatterTestLanguageLanguage.INSTANCE.getInstance(FormatterTestLanguageGrammarAccess.class);

	private static class RootFactory {
		public static IGrammarAwareElementType createRootElementType() {
			return new IGrammarAwareElementType("Root_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRule());
		}
		public static IGrammarAwareElementType createRoot_AlternativesElementType() {
			return new IGrammarAwareElementType("Root_Alternatives_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createRoot_IDListParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Root_IDListParserRuleCall_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getIDListParserRuleCall_0());
		}
		public static IGrammarAwareElementType createRoot_KWListParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Root_KWListParserRuleCall_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getKWListParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Root_ELEMENT_TYPE = associate(RootFactory.createRootElementType());

	public static final IGrammarAwareElementType Root_Alternatives_ELEMENT_TYPE = associate(RootFactory.createRoot_AlternativesElementType());

	public static final IGrammarAwareElementType Root_IDListParserRuleCall_0_ELEMENT_TYPE = associate(RootFactory.createRoot_IDListParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Root_KWListParserRuleCall_1_ELEMENT_TYPE = associate(RootFactory.createRoot_KWListParserRuleCall_1ElementType());

	private static class IDListFactory {
		public static IGrammarAwareElementType createIDListElementType() {
			return new IGrammarAwareElementType("IDList_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIDListRule());
		}
		public static IGrammarAwareElementType createIDList_GroupElementType() {
			return new IGrammarAwareElementType("IDList_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIDListAccess().getGroup());
		}
		public static IGrammarAwareElementType createIDList_IDListAction_0ElementType() {
			return new IGrammarAwareElementType("IDList_IDListAction_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIDListAccess().getIDListAction_0());
		}
		public static IGrammarAwareElementType createIDList_IdlistKeyword_1ElementType() {
			return new IGrammarAwareElementType("IDList_IdlistKeyword_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIDListAccess().getIdlistKeyword_1());
		}
		public static IGrammarAwareElementType createIDList_IdsAssignment_2ElementType() {
			return new IGrammarAwareElementType("IDList_IdsAssignment_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIDListAccess().getIdsAssignment_2());
		}
		public static IGrammarAwareElementType createIDList_IdsIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("IDList_IdsIDTerminalRuleCall_2_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIDListAccess().getIdsIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType IDList_ELEMENT_TYPE = associate(IDListFactory.createIDListElementType());

	public static final IGrammarAwareElementType IDList_Group_ELEMENT_TYPE = associate(IDListFactory.createIDList_GroupElementType());

	public static final IGrammarAwareElementType IDList_IDListAction_0_ELEMENT_TYPE = associate(IDListFactory.createIDList_IDListAction_0ElementType());

	public static final IGrammarAwareElementType IDList_IdlistKeyword_1_ELEMENT_TYPE = associate(IDListFactory.createIDList_IdlistKeyword_1ElementType());

	public static final IGrammarAwareElementType IDList_IdsAssignment_2_ELEMENT_TYPE = associate(IDListFactory.createIDList_IdsAssignment_2ElementType());

	public static final IGrammarAwareElementType IDList_IdsIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(IDListFactory.createIDList_IdsIDTerminalRuleCall_2_0ElementType());

	private static class KWListFactory {
		public static IGrammarAwareElementType createKWListElementType() {
			return new IGrammarAwareElementType("KWList_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListRule());
		}
		public static IGrammarAwareElementType createKWList_GroupElementType() {
			return new IGrammarAwareElementType("KWList_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getGroup());
		}
		public static IGrammarAwareElementType createKWList_KWListAction_0ElementType() {
			return new IGrammarAwareElementType("KWList_KWListAction_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKWListAction_0());
		}
		public static IGrammarAwareElementType createKWList_KwlistKeyword_1ElementType() {
			return new IGrammarAwareElementType("KWList_KwlistKeyword_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKwlistKeyword_1());
		}
		public static IGrammarAwareElementType createKWList_Kw1Assignment_2ElementType() {
			return new IGrammarAwareElementType("KWList_Kw1Assignment_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKw1Assignment_2());
		}
		public static IGrammarAwareElementType createKWList_Kw1Kw1Keyword_2_0ElementType() {
			return new IGrammarAwareElementType("KWList_Kw1Kw1Keyword_2_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKw1Kw1Keyword_2_0());
		}
		public static IGrammarAwareElementType createKWList_Kw2Assignment_3ElementType() {
			return new IGrammarAwareElementType("KWList_Kw2Assignment_3_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKw2Assignment_3());
		}
		public static IGrammarAwareElementType createKWList_Kw2Kw2Keyword_3_0ElementType() {
			return new IGrammarAwareElementType("KWList_Kw2Kw2Keyword_3_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKw2Kw2Keyword_3_0());
		}
		public static IGrammarAwareElementType createKWList_Kw3Assignment_4ElementType() {
			return new IGrammarAwareElementType("KWList_Kw3Assignment_4_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKw3Assignment_4());
		}
		public static IGrammarAwareElementType createKWList_Kw3Kw3Keyword_4_0ElementType() {
			return new IGrammarAwareElementType("KWList_Kw3Kw3Keyword_4_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKw3Kw3Keyword_4_0());
		}
		public static IGrammarAwareElementType createKWList_Kw4Assignment_5ElementType() {
			return new IGrammarAwareElementType("KWList_Kw4Assignment_5_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKw4Assignment_5());
		}
		public static IGrammarAwareElementType createKWList_Kw4Kw4Keyword_5_0ElementType() {
			return new IGrammarAwareElementType("KWList_Kw4Kw4Keyword_5_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKw4Kw4Keyword_5_0());
		}
		public static IGrammarAwareElementType createKWList_Kw5Assignment_6ElementType() {
			return new IGrammarAwareElementType("KWList_Kw5Assignment_6_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKw5Assignment_6());
		}
		public static IGrammarAwareElementType createKWList_Kw5Kw5Keyword_6_0ElementType() {
			return new IGrammarAwareElementType("KWList_Kw5Kw5Keyword_6_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKWListAccess().getKw5Kw5Keyword_6_0());
		}
	}

	public static final IGrammarAwareElementType KWList_ELEMENT_TYPE = associate(KWListFactory.createKWListElementType());

	public static final IGrammarAwareElementType KWList_Group_ELEMENT_TYPE = associate(KWListFactory.createKWList_GroupElementType());

	public static final IGrammarAwareElementType KWList_KWListAction_0_ELEMENT_TYPE = associate(KWListFactory.createKWList_KWListAction_0ElementType());

	public static final IGrammarAwareElementType KWList_KwlistKeyword_1_ELEMENT_TYPE = associate(KWListFactory.createKWList_KwlistKeyword_1ElementType());

	public static final IGrammarAwareElementType KWList_Kw1Assignment_2_ELEMENT_TYPE = associate(KWListFactory.createKWList_Kw1Assignment_2ElementType());

	public static final IGrammarAwareElementType KWList_Kw1Kw1Keyword_2_0_ELEMENT_TYPE = associate(KWListFactory.createKWList_Kw1Kw1Keyword_2_0ElementType());

	public static final IGrammarAwareElementType KWList_Kw2Assignment_3_ELEMENT_TYPE = associate(KWListFactory.createKWList_Kw2Assignment_3ElementType());

	public static final IGrammarAwareElementType KWList_Kw2Kw2Keyword_3_0_ELEMENT_TYPE = associate(KWListFactory.createKWList_Kw2Kw2Keyword_3_0ElementType());

	public static final IGrammarAwareElementType KWList_Kw3Assignment_4_ELEMENT_TYPE = associate(KWListFactory.createKWList_Kw3Assignment_4ElementType());

	public static final IGrammarAwareElementType KWList_Kw3Kw3Keyword_4_0_ELEMENT_TYPE = associate(KWListFactory.createKWList_Kw3Kw3Keyword_4_0ElementType());

	public static final IGrammarAwareElementType KWList_Kw4Assignment_5_ELEMENT_TYPE = associate(KWListFactory.createKWList_Kw4Assignment_5ElementType());

	public static final IGrammarAwareElementType KWList_Kw4Kw4Keyword_5_0_ELEMENT_TYPE = associate(KWListFactory.createKWList_Kw4Kw4Keyword_5_0ElementType());

	public static final IGrammarAwareElementType KWList_Kw5Assignment_6_ELEMENT_TYPE = associate(KWListFactory.createKWList_Kw5Assignment_6ElementType());

	public static final IGrammarAwareElementType KWList_Kw5Kw5Keyword_6_0_ELEMENT_TYPE = associate(KWListFactory.createKWList_Kw5Kw5Keyword_6_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getRootElementType() {
		return Root_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_AlternativesElementType() {
		return Root_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_IDListParserRuleCall_0ElementType() {
		return Root_IDListParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_KWListParserRuleCall_1ElementType() {
		return Root_KWListParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIDListElementType() {
		return IDList_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIDList_GroupElementType() {
		return IDList_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIDList_IDListAction_0ElementType() {
		return IDList_IDListAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIDList_IdlistKeyword_1ElementType() {
		return IDList_IdlistKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIDList_IdsAssignment_2ElementType() {
		return IDList_IdsAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIDList_IdsIDTerminalRuleCall_2_0ElementType() {
		return IDList_IdsIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWListElementType() {
		return KWList_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_GroupElementType() {
		return KWList_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_KWListAction_0ElementType() {
		return KWList_KWListAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_KwlistKeyword_1ElementType() {
		return KWList_KwlistKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_Kw1Assignment_2ElementType() {
		return KWList_Kw1Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_Kw1Kw1Keyword_2_0ElementType() {
		return KWList_Kw1Kw1Keyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_Kw2Assignment_3ElementType() {
		return KWList_Kw2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_Kw2Kw2Keyword_3_0ElementType() {
		return KWList_Kw2Kw2Keyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_Kw3Assignment_4ElementType() {
		return KWList_Kw3Assignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_Kw3Kw3Keyword_4_0ElementType() {
		return KWList_Kw3Kw3Keyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_Kw4Assignment_5ElementType() {
		return KWList_Kw4Assignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_Kw4Kw4Keyword_5_0ElementType() {
		return KWList_Kw4Kw4Keyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_Kw5Assignment_6ElementType() {
		return KWList_Kw5Assignment_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKWList_Kw5Kw5Keyword_6_0ElementType() {
		return KWList_Kw5Kw5Keyword_6_0_ELEMENT_TYPE;
	}

}
