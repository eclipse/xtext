package org.eclipse.xtext.parser.terminalrules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.Bug292245TestLanguageFileImpl;
import org.eclipse.xtext.parser.terminalrules.services.Bug292245TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug292245TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug292245TestLanguageFileImpl>>(Bug292245TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug292245TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug292245TestLanguageLanguage.INSTANCE.getInstance(Bug292245TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_FIXKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FIXKeyword_0_0_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFIXKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_FixAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Model_FixAssignment_0_1_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFixAssignment_0_1());
		}
		public static IGrammarAwareElementType createModel_FixFixParserRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FixFixParserRuleCall_0_1_0_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFixFixParserRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_ERRORKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ERRORKeyword_1_0_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getERRORKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_ErrorAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_ErrorAssignment_1_1_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getErrorAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_ErrorErrorParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ErrorErrorParserRuleCall_1_1_0_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getErrorErrorParserRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_2_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createModel_TICKKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_TICKKeyword_2_0_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTICKKeyword_2_0());
		}
		public static IGrammarAwareElementType createModel_TickAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Model_TickAssignment_2_1_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTickAssignment_2_1());
		}
		public static IGrammarAwareElementType createModel_TickApostropheParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_TickApostropheParserRuleCall_2_1_0_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTickApostropheParserRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_FIXKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FIXKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_FixAssignment_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_FixAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Model_FixFixParserRuleCall_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FixFixParserRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_ERRORKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ERRORKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_ErrorAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ErrorAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_ErrorErrorParserRuleCall_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ErrorErrorParserRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_2ElementType());

	public static final IGrammarAwareElementType Model_TICKKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_TICKKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Model_TickAssignment_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_TickAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Model_TickApostropheParserRuleCall_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_TickApostropheParserRuleCall_2_1_0ElementType());

	private static class ErrorFactory {
		public static IGrammarAwareElementType createErrorElementType() {
			return new IGrammarAwareElementType("Error_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErrorRule());
		}
		public static IGrammarAwareElementType createError_GroupElementType() {
			return new IGrammarAwareElementType("Error_Group_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErrorAccess().getGroup());
		}
		public static IGrammarAwareElementType createError_APOSTROPHE_CHARTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Error_APOSTROPHE_CHARTerminalRuleCall_0_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErrorAccess().getAPOSTROPHE_CHARTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createError_GraphicalParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Error_GraphicalParserRuleCall_1_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErrorAccess().getGraphicalParserRuleCall_1());
		}
		public static IGrammarAwareElementType createError_APOSTROPHE_CHARTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Error_APOSTROPHE_CHARTerminalRuleCall_2_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErrorAccess().getAPOSTROPHE_CHARTerminalRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType Error_ELEMENT_TYPE = associate(ErrorFactory.createErrorElementType());

	public static final IGrammarAwareElementType Error_Group_ELEMENT_TYPE = associate(ErrorFactory.createError_GroupElementType());

	public static final IGrammarAwareElementType Error_APOSTROPHE_CHARTerminalRuleCall_0_ELEMENT_TYPE = associate(ErrorFactory.createError_APOSTROPHE_CHARTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType Error_GraphicalParserRuleCall_1_ELEMENT_TYPE = associate(ErrorFactory.createError_GraphicalParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Error_APOSTROPHE_CHARTerminalRuleCall_2_ELEMENT_TYPE = associate(ErrorFactory.createError_APOSTROPHE_CHARTerminalRuleCall_2ElementType());

	private static class FixFactory {
		public static IGrammarAwareElementType createFixElementType() {
			return new IGrammarAwareElementType("Fix_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFixRule());
		}
		public static IGrammarAwareElementType createFix_GroupElementType() {
			return new IGrammarAwareElementType("Fix_Group_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFixAccess().getGroup());
		}
		public static IGrammarAwareElementType createFix_APOSTROPHE_CHARTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Fix_APOSTROPHE_CHARTerminalRuleCall_0_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFixAccess().getAPOSTROPHE_CHARTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFix_GraphicalParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Fix_GraphicalParserRuleCall_1_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFixAccess().getGraphicalParserRuleCall_1());
		}
		public static IGrammarAwareElementType createFix_APOSTROPHE_CHARTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Fix_APOSTROPHE_CHARTerminalRuleCall_2_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFixAccess().getAPOSTROPHE_CHARTerminalRuleCall_2());
		}
		public static IGrammarAwareElementType createFix_RehideParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Fix_RehideParserRuleCall_3_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFixAccess().getRehideParserRuleCall_3());
		}
	}

	public static final IGrammarAwareElementType Fix_ELEMENT_TYPE = associate(FixFactory.createFixElementType());

	public static final IGrammarAwareElementType Fix_Group_ELEMENT_TYPE = associate(FixFactory.createFix_GroupElementType());

	public static final IGrammarAwareElementType Fix_APOSTROPHE_CHARTerminalRuleCall_0_ELEMENT_TYPE = associate(FixFactory.createFix_APOSTROPHE_CHARTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType Fix_GraphicalParserRuleCall_1_ELEMENT_TYPE = associate(FixFactory.createFix_GraphicalParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Fix_APOSTROPHE_CHARTerminalRuleCall_2_ELEMENT_TYPE = associate(FixFactory.createFix_APOSTROPHE_CHARTerminalRuleCall_2ElementType());

	public static final IGrammarAwareElementType Fix_RehideParserRuleCall_3_ELEMENT_TYPE = associate(FixFactory.createFix_RehideParserRuleCall_3ElementType());

	private static class ApostropheFactory {
		public static IGrammarAwareElementType createApostropheElementType() {
			return new IGrammarAwareElementType("Apostrophe_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getApostropheRule());
		}
		public static IGrammarAwareElementType createApostrophe_APOSTROPHE_CHARTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("Apostrophe_APOSTROPHE_CHARTerminalRuleCall_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getApostropheAccess().getAPOSTROPHE_CHARTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType Apostrophe_ELEMENT_TYPE = associate(ApostropheFactory.createApostropheElementType());

	public static final IGrammarAwareElementType Apostrophe_APOSTROPHE_CHARTerminalRuleCall_ELEMENT_TYPE = associate(ApostropheFactory.createApostrophe_APOSTROPHE_CHARTerminalRuleCallElementType());

	private static class RehideFactory {
		public static IGrammarAwareElementType createRehideElementType() {
			return new IGrammarAwareElementType("Rehide_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRehideRule());
		}
		public static IGrammarAwareElementType createRehide_CircumflexAccentKeywordElementType() {
			return new IGrammarAwareElementType("Rehide_CircumflexAccentKeyword_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRehideAccess().getCircumflexAccentKeyword());
		}
	}

	public static final IGrammarAwareElementType Rehide_ELEMENT_TYPE = associate(RehideFactory.createRehideElementType());

	public static final IGrammarAwareElementType Rehide_CircumflexAccentKeyword_ELEMENT_TYPE = associate(RehideFactory.createRehide_CircumflexAccentKeywordElementType());

	private static class GraphicalFactory {
		public static IGrammarAwareElementType createGraphicalElementType() {
			return new IGrammarAwareElementType("Graphical_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGraphicalRule());
		}
		public static IGrammarAwareElementType createGraphical_AlternativesElementType() {
			return new IGrammarAwareElementType("Graphical_Alternatives_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGraphicalAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createGraphical_CHARTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Graphical_CHARTerminalRuleCall_0_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGraphicalAccess().getCHARTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createGraphical_WSTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Graphical_WSTerminalRuleCall_1_ELEMENT_TYPE", Bug292245TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGraphicalAccess().getWSTerminalRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Graphical_ELEMENT_TYPE = associate(GraphicalFactory.createGraphicalElementType());

	public static final IGrammarAwareElementType Graphical_Alternatives_ELEMENT_TYPE = associate(GraphicalFactory.createGraphical_AlternativesElementType());

	public static final IGrammarAwareElementType Graphical_CHARTerminalRuleCall_0_ELEMENT_TYPE = associate(GraphicalFactory.createGraphical_CHARTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType Graphical_WSTerminalRuleCall_1_ELEMENT_TYPE = associate(GraphicalFactory.createGraphical_WSTerminalRuleCall_1ElementType());

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

	public IGrammarAwareElementType getModel_Group_0ElementType() {
		return Model_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FIXKeyword_0_0ElementType() {
		return Model_FIXKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FixAssignment_0_1ElementType() {
		return Model_FixAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FixFixParserRuleCall_0_1_0ElementType() {
		return Model_FixFixParserRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ERRORKeyword_1_0ElementType() {
		return Model_ERRORKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ErrorAssignment_1_1ElementType() {
		return Model_ErrorAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ErrorErrorParserRuleCall_1_1_0ElementType() {
		return Model_ErrorErrorParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_2ElementType() {
		return Model_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TICKKeyword_2_0ElementType() {
		return Model_TICKKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TickAssignment_2_1ElementType() {
		return Model_TickAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TickApostropheParserRuleCall_2_1_0ElementType() {
		return Model_TickApostropheParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getErrorElementType() {
		return Error_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getError_GroupElementType() {
		return Error_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getError_APOSTROPHE_CHARTerminalRuleCall_0ElementType() {
		return Error_APOSTROPHE_CHARTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getError_GraphicalParserRuleCall_1ElementType() {
		return Error_GraphicalParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getError_APOSTROPHE_CHARTerminalRuleCall_2ElementType() {
		return Error_APOSTROPHE_CHARTerminalRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFixElementType() {
		return Fix_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFix_GroupElementType() {
		return Fix_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFix_APOSTROPHE_CHARTerminalRuleCall_0ElementType() {
		return Fix_APOSTROPHE_CHARTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFix_GraphicalParserRuleCall_1ElementType() {
		return Fix_GraphicalParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFix_APOSTROPHE_CHARTerminalRuleCall_2ElementType() {
		return Fix_APOSTROPHE_CHARTerminalRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFix_RehideParserRuleCall_3ElementType() {
		return Fix_RehideParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getApostropheElementType() {
		return Apostrophe_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getApostrophe_APOSTROPHE_CHARTerminalRuleCallElementType() {
		return Apostrophe_APOSTROPHE_CHARTerminalRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRehideElementType() {
		return Rehide_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRehide_CircumflexAccentKeywordElementType() {
		return Rehide_CircumflexAccentKeyword_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGraphicalElementType() {
		return Graphical_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGraphical_AlternativesElementType() {
		return Graphical_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGraphical_CHARTerminalRuleCall_0ElementType() {
		return Graphical_CHARTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGraphical_WSTerminalRuleCall_1ElementType() {
		return Graphical_WSTerminalRuleCall_1_ELEMENT_TYPE;
	}

}
