package org.eclipse.xtext.testlanguages.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.TestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<TestLanguageFileImpl>>(TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final TestLanguageGrammarAccess GRAMMAR_ACCESS = TestLanguageLanguage.INSTANCE.getInstance(TestLanguageGrammarAccess.class);

	private static class EntryRuleFactory {
		public static IGrammarAwareElementType createEntryRuleElementType() {
			return new IGrammarAwareElementType("EntryRule_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntryRuleRule());
		}
		public static IGrammarAwareElementType createEntryRule_MultiFeatureAssignmentElementType() {
			return new IGrammarAwareElementType("EntryRule_MultiFeatureAssignment_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntryRuleAccess().getMultiFeatureAssignment());
		}
		public static IGrammarAwareElementType createEntryRule_MultiFeatureAbstractRuleParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("EntryRule_MultiFeatureAbstractRuleParserRuleCall_0_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntryRuleAccess().getMultiFeatureAbstractRuleParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType EntryRule_ELEMENT_TYPE = associate(EntryRuleFactory.createEntryRuleElementType());

	public static final IGrammarAwareElementType EntryRule_MultiFeatureAssignment_ELEMENT_TYPE = associate(EntryRuleFactory.createEntryRule_MultiFeatureAssignmentElementType());

	public static final IGrammarAwareElementType EntryRule_MultiFeatureAbstractRuleParserRuleCall_0_ELEMENT_TYPE = associate(EntryRuleFactory.createEntryRule_MultiFeatureAbstractRuleParserRuleCall_0ElementType());

	private static class AbstractRuleFactory {
		public static IGrammarAwareElementType createAbstractRuleElementType() {
			return new IGrammarAwareElementType("AbstractRule_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleRule());
		}
		public static IGrammarAwareElementType createAbstractRule_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractRule_Alternatives_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractRule_ChoiceRuleParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractRule_ChoiceRuleParserRuleCall_0_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getChoiceRuleParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractRule_ReducibleRuleParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractRule_ReducibleRuleParserRuleCall_1_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getReducibleRuleParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractRule_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRuleElementType());

	public static final IGrammarAwareElementType AbstractRule_Alternatives_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractRule_ChoiceRuleParserRuleCall_0_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_ChoiceRuleParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractRule_ReducibleRuleParserRuleCall_1_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_ReducibleRuleParserRuleCall_1ElementType());

	private static class ChoiceRuleFactory {
		public static IGrammarAwareElementType createChoiceRuleElementType() {
			return new IGrammarAwareElementType("ChoiceRule_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChoiceRuleRule());
		}
		public static IGrammarAwareElementType createChoiceRule_GroupElementType() {
			return new IGrammarAwareElementType("ChoiceRule_Group_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChoiceRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createChoiceRule_ChoiceKeyword_0ElementType() {
			return new IGrammarAwareElementType("ChoiceRule_ChoiceKeyword_0_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChoiceRuleAccess().getChoiceKeyword_0());
		}
		public static IGrammarAwareElementType createChoiceRule_OptionalKeywordAssignment_1ElementType() {
			return new IGrammarAwareElementType("ChoiceRule_OptionalKeywordAssignment_1_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChoiceRuleAccess().getOptionalKeywordAssignment_1());
		}
		public static IGrammarAwareElementType createChoiceRule_OptionalKeywordOptionalKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("ChoiceRule_OptionalKeywordOptionalKeyword_1_0_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChoiceRuleAccess().getOptionalKeywordOptionalKeyword_1_0());
		}
		public static IGrammarAwareElementType createChoiceRule_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("ChoiceRule_NameAssignment_2_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChoiceRuleAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createChoiceRule_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("ChoiceRule_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChoiceRuleAccess().getNameIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType ChoiceRule_ELEMENT_TYPE = associate(ChoiceRuleFactory.createChoiceRuleElementType());

	public static final IGrammarAwareElementType ChoiceRule_Group_ELEMENT_TYPE = associate(ChoiceRuleFactory.createChoiceRule_GroupElementType());

	public static final IGrammarAwareElementType ChoiceRule_ChoiceKeyword_0_ELEMENT_TYPE = associate(ChoiceRuleFactory.createChoiceRule_ChoiceKeyword_0ElementType());

	public static final IGrammarAwareElementType ChoiceRule_OptionalKeywordAssignment_1_ELEMENT_TYPE = associate(ChoiceRuleFactory.createChoiceRule_OptionalKeywordAssignment_1ElementType());

	public static final IGrammarAwareElementType ChoiceRule_OptionalKeywordOptionalKeyword_1_0_ELEMENT_TYPE = associate(ChoiceRuleFactory.createChoiceRule_OptionalKeywordOptionalKeyword_1_0ElementType());

	public static final IGrammarAwareElementType ChoiceRule_NameAssignment_2_ELEMENT_TYPE = associate(ChoiceRuleFactory.createChoiceRule_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType ChoiceRule_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ChoiceRuleFactory.createChoiceRule_NameIDTerminalRuleCall_2_0ElementType());

	private static class ReducibleRuleFactory {
		public static IGrammarAwareElementType createReducibleRuleElementType() {
			return new IGrammarAwareElementType("ReducibleRule_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReducibleRuleRule());
		}
		public static IGrammarAwareElementType createReducibleRule_GroupElementType() {
			return new IGrammarAwareElementType("ReducibleRule_Group_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReducibleRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createReducibleRule_ReducibleKeyword_0ElementType() {
			return new IGrammarAwareElementType("ReducibleRule_ReducibleKeyword_0_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReducibleRuleAccess().getReducibleKeyword_0());
		}
		public static IGrammarAwareElementType createReducibleRule_TerminalRuleParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ReducibleRule_TerminalRuleParserRuleCall_1_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReducibleRuleAccess().getTerminalRuleParserRuleCall_1());
		}
		public static IGrammarAwareElementType createReducibleRule_Group_2ElementType() {
			return new IGrammarAwareElementType("ReducibleRule_Group_2_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReducibleRuleAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createReducibleRule_ReducibleCompositeActionFeatureAction_2_0ElementType() {
			return new IGrammarAwareElementType("ReducibleRule_ReducibleCompositeActionFeatureAction_2_0_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReducibleRuleAccess().getReducibleCompositeActionFeatureAction_2_0());
		}
		public static IGrammarAwareElementType createReducibleRule_ActionFeatureAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("ReducibleRule_ActionFeatureAssignment_2_1_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReducibleRuleAccess().getActionFeatureAssignment_2_1());
		}
		public static IGrammarAwareElementType createReducibleRule_ActionFeatureTerminalRuleParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("ReducibleRule_ActionFeatureTerminalRuleParserRuleCall_2_1_0_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReducibleRuleAccess().getActionFeatureTerminalRuleParserRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType ReducibleRule_ELEMENT_TYPE = associate(ReducibleRuleFactory.createReducibleRuleElementType());

	public static final IGrammarAwareElementType ReducibleRule_Group_ELEMENT_TYPE = associate(ReducibleRuleFactory.createReducibleRule_GroupElementType());

	public static final IGrammarAwareElementType ReducibleRule_ReducibleKeyword_0_ELEMENT_TYPE = associate(ReducibleRuleFactory.createReducibleRule_ReducibleKeyword_0ElementType());

	public static final IGrammarAwareElementType ReducibleRule_TerminalRuleParserRuleCall_1_ELEMENT_TYPE = associate(ReducibleRuleFactory.createReducibleRule_TerminalRuleParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType ReducibleRule_Group_2_ELEMENT_TYPE = associate(ReducibleRuleFactory.createReducibleRule_Group_2ElementType());

	public static final IGrammarAwareElementType ReducibleRule_ReducibleCompositeActionFeatureAction_2_0_ELEMENT_TYPE = associate(ReducibleRuleFactory.createReducibleRule_ReducibleCompositeActionFeatureAction_2_0ElementType());

	public static final IGrammarAwareElementType ReducibleRule_ActionFeatureAssignment_2_1_ELEMENT_TYPE = associate(ReducibleRuleFactory.createReducibleRule_ActionFeatureAssignment_2_1ElementType());

	public static final IGrammarAwareElementType ReducibleRule_ActionFeatureTerminalRuleParserRuleCall_2_1_0_ELEMENT_TYPE = associate(ReducibleRuleFactory.createReducibleRule_ActionFeatureTerminalRuleParserRuleCall_2_1_0ElementType());

	private static class TerminalRuleFactory {
		public static IGrammarAwareElementType createTerminalRuleElementType() {
			return new IGrammarAwareElementType("TerminalRule_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleRule());
		}
		public static IGrammarAwareElementType createTerminalRule_StringFeatureAssignmentElementType() {
			return new IGrammarAwareElementType("TerminalRule_StringFeatureAssignment_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getStringFeatureAssignment());
		}
		public static IGrammarAwareElementType createTerminalRule_StringFeatureSTRINGTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_StringFeatureSTRINGTerminalRuleCall_0_ELEMENT_TYPE", TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getStringFeatureSTRINGTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType TerminalRule_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRuleElementType());

	public static final IGrammarAwareElementType TerminalRule_StringFeatureAssignment_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_StringFeatureAssignmentElementType());

	public static final IGrammarAwareElementType TerminalRule_StringFeatureSTRINGTerminalRuleCall_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_StringFeatureSTRINGTerminalRuleCall_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getEntryRuleElementType() {
		return EntryRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntryRule_MultiFeatureAssignmentElementType() {
		return EntryRule_MultiFeatureAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntryRule_MultiFeatureAbstractRuleParserRuleCall_0ElementType() {
		return EntryRule_MultiFeatureAbstractRuleParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractRuleElementType() {
		return AbstractRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractRule_AlternativesElementType() {
		return AbstractRule_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractRule_ChoiceRuleParserRuleCall_0ElementType() {
		return AbstractRule_ChoiceRuleParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractRule_ReducibleRuleParserRuleCall_1ElementType() {
		return AbstractRule_ReducibleRuleParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChoiceRuleElementType() {
		return ChoiceRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChoiceRule_GroupElementType() {
		return ChoiceRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChoiceRule_ChoiceKeyword_0ElementType() {
		return ChoiceRule_ChoiceKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChoiceRule_OptionalKeywordAssignment_1ElementType() {
		return ChoiceRule_OptionalKeywordAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChoiceRule_OptionalKeywordOptionalKeyword_1_0ElementType() {
		return ChoiceRule_OptionalKeywordOptionalKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChoiceRule_NameAssignment_2ElementType() {
		return ChoiceRule_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChoiceRule_NameIDTerminalRuleCall_2_0ElementType() {
		return ChoiceRule_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReducibleRuleElementType() {
		return ReducibleRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReducibleRule_GroupElementType() {
		return ReducibleRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReducibleRule_ReducibleKeyword_0ElementType() {
		return ReducibleRule_ReducibleKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReducibleRule_TerminalRuleParserRuleCall_1ElementType() {
		return ReducibleRule_TerminalRuleParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReducibleRule_Group_2ElementType() {
		return ReducibleRule_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReducibleRule_ReducibleCompositeActionFeatureAction_2_0ElementType() {
		return ReducibleRule_ReducibleCompositeActionFeatureAction_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReducibleRule_ActionFeatureAssignment_2_1ElementType() {
		return ReducibleRule_ActionFeatureAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReducibleRule_ActionFeatureTerminalRuleParserRuleCall_2_1_0ElementType() {
		return ReducibleRule_ActionFeatureTerminalRuleParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRuleElementType() {
		return TerminalRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_StringFeatureAssignmentElementType() {
		return TerminalRule_StringFeatureAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_StringFeatureSTRINGTerminalRuleCall_0ElementType() {
		return TerminalRule_StringFeatureSTRINGTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
