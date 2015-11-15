package org.eclipse.xtext.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.idea.lang.psi.impl.XtextGrammarTestLanguageFileImpl;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class XtextGrammarTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<XtextGrammarTestLanguageFileImpl>>(XtextGrammarTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final XtextGrammarTestLanguageGrammarAccess GRAMMAR_ACCESS = XtextGrammarTestLanguageLanguage.INSTANCE.getInstance(XtextGrammarTestLanguageGrammarAccess.class);

	private static class GrammarFactory {
		public static IGrammarAwareElementType createGrammarElementType() {
			return new IGrammarAwareElementType("Grammar_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarRule());
		}
		public static IGrammarAwareElementType createGrammar_GroupElementType() {
			return new IGrammarAwareElementType("Grammar_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGroup());
		}
		public static IGrammarAwareElementType createGrammar_GrammarKeyword_0ElementType() {
			return new IGrammarAwareElementType("Grammar_GrammarKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGrammarKeyword_0());
		}
		public static IGrammarAwareElementType createGrammar_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Grammar_NameAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createGrammar_NameGrammarIDParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Grammar_NameGrammarIDParserRuleCall_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createGrammar_Group_2ElementType() {
			return new IGrammarAwareElementType("Grammar_Group_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createGrammar_WithKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Grammar_WithKeyword_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getWithKeyword_2_0());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsAssignment_2_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsAssignment_2_1());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsGrammarCrossReference_2_1_0ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsGrammarCrossReference_2_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1());
		}
		public static IGrammarAwareElementType createGrammar_Group_2_2ElementType() {
			return new IGrammarAwareElementType("Grammar_Group_2_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGroup_2_2());
		}
		public static IGrammarAwareElementType createGrammar_CommaKeyword_2_2_0ElementType() {
			return new IGrammarAwareElementType("Grammar_CommaKeyword_2_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getCommaKeyword_2_2_0());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsAssignment_2_2_1ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsAssignment_2_2_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsAssignment_2_2_1());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsGrammarCrossReference_2_2_1_0ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsGrammarCrossReference_2_2_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1());
		}
		public static IGrammarAwareElementType createGrammar_HiddenClauseParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Grammar_HiddenClauseParserRuleCall_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getHiddenClauseParserRuleCall_3());
		}
		public static IGrammarAwareElementType createGrammar_MetamodelDeclarationsAssignment_4ElementType() {
			return new IGrammarAwareElementType("Grammar_MetamodelDeclarationsAssignment_4_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getMetamodelDeclarationsAssignment_4());
		}
		public static IGrammarAwareElementType createGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Grammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createGrammar_RulesAssignment_5ElementType() {
			return new IGrammarAwareElementType("Grammar_RulesAssignment_5_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getRulesAssignment_5());
		}
		public static IGrammarAwareElementType createGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("Grammar_RulesAbstractRuleParserRuleCall_5_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0());
		}
	}

	public static final IGrammarAwareElementType Grammar_ELEMENT_TYPE = associate(GrammarFactory.createGrammarElementType());

	public static final IGrammarAwareElementType Grammar_Group_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_GroupElementType());

	public static final IGrammarAwareElementType Grammar_GrammarKeyword_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_GrammarKeyword_0ElementType());

	public static final IGrammarAwareElementType Grammar_NameAssignment_1_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Grammar_NameGrammarIDParserRuleCall_1_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_NameGrammarIDParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Grammar_Group_2_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_Group_2ElementType());

	public static final IGrammarAwareElementType Grammar_WithKeyword_2_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_WithKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Grammar_UsedGrammarsAssignment_2_1_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_UsedGrammarsAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Grammar_UsedGrammarsGrammarCrossReference_2_1_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_UsedGrammarsGrammarCrossReference_2_1_0ElementType());

	public static final IGrammarAwareElementType Grammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1ElementType());

	public static final IGrammarAwareElementType Grammar_Group_2_2_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_Group_2_2ElementType());

	public static final IGrammarAwareElementType Grammar_CommaKeyword_2_2_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_CommaKeyword_2_2_0ElementType());

	public static final IGrammarAwareElementType Grammar_UsedGrammarsAssignment_2_2_1_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_UsedGrammarsAssignment_2_2_1ElementType());

	public static final IGrammarAwareElementType Grammar_UsedGrammarsGrammarCrossReference_2_2_1_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_UsedGrammarsGrammarCrossReference_2_2_1_0ElementType());

	public static final IGrammarAwareElementType Grammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1ElementType());

	public static final IGrammarAwareElementType Grammar_HiddenClauseParserRuleCall_3_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_HiddenClauseParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType Grammar_MetamodelDeclarationsAssignment_4_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_MetamodelDeclarationsAssignment_4ElementType());

	public static final IGrammarAwareElementType Grammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Grammar_RulesAssignment_5_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_RulesAssignment_5ElementType());

	public static final IGrammarAwareElementType Grammar_RulesAbstractRuleParserRuleCall_5_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType());

	private static class HiddenClauseFactory {
		public static IGrammarAwareElementType createHiddenClauseElementType() {
			return new IGrammarAwareElementType("HiddenClause_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseRule());
		}
		public static IGrammarAwareElementType createHiddenClause_GroupElementType() {
			return new IGrammarAwareElementType("HiddenClause_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getGroup());
		}
		public static IGrammarAwareElementType createHiddenClause_DefinesHiddenTokensAssignment_0ElementType() {
			return new IGrammarAwareElementType("HiddenClause_DefinesHiddenTokensAssignment_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getDefinesHiddenTokensAssignment_0());
		}
		public static IGrammarAwareElementType createHiddenClause_DefinesHiddenTokensHiddenKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("HiddenClause_DefinesHiddenTokensHiddenKeyword_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getDefinesHiddenTokensHiddenKeyword_0_0());
		}
		public static IGrammarAwareElementType createHiddenClause_LeftParenthesisKeyword_1ElementType() {
			return new IGrammarAwareElementType("HiddenClause_LeftParenthesisKeyword_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getLeftParenthesisKeyword_1());
		}
		public static IGrammarAwareElementType createHiddenClause_Group_2ElementType() {
			return new IGrammarAwareElementType("HiddenClause_Group_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createHiddenClause_HiddenTokensAssignment_2_0ElementType() {
			return new IGrammarAwareElementType("HiddenClause_HiddenTokensAssignment_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getHiddenTokensAssignment_2_0());
		}
		public static IGrammarAwareElementType createHiddenClause_HiddenTokensAbstractRuleCrossReference_2_0_0ElementType() {
			return new IGrammarAwareElementType("HiddenClause_HiddenTokensAbstractRuleCrossReference_2_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getHiddenTokensAbstractRuleCrossReference_2_0_0());
		}
		public static IGrammarAwareElementType createHiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_0_0_1ElementType() {
			return new IGrammarAwareElementType("HiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_0_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_0_0_1());
		}
		public static IGrammarAwareElementType createHiddenClause_Group_2_1ElementType() {
			return new IGrammarAwareElementType("HiddenClause_Group_2_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getGroup_2_1());
		}
		public static IGrammarAwareElementType createHiddenClause_CommaKeyword_2_1_0ElementType() {
			return new IGrammarAwareElementType("HiddenClause_CommaKeyword_2_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getCommaKeyword_2_1_0());
		}
		public static IGrammarAwareElementType createHiddenClause_HiddenTokensAssignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("HiddenClause_HiddenTokensAssignment_2_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getHiddenTokensAssignment_2_1_1());
		}
		public static IGrammarAwareElementType createHiddenClause_HiddenTokensAbstractRuleCrossReference_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("HiddenClause_HiddenTokensAbstractRuleCrossReference_2_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getHiddenTokensAbstractRuleCrossReference_2_1_1_0());
		}
		public static IGrammarAwareElementType createHiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("HiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_1_1_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_1_1_0_1());
		}
		public static IGrammarAwareElementType createHiddenClause_RightParenthesisKeyword_3ElementType() {
			return new IGrammarAwareElementType("HiddenClause_RightParenthesisKeyword_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHiddenClauseAccess().getRightParenthesisKeyword_3());
		}
	}

	public static final IGrammarAwareElementType HiddenClause_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClauseElementType());

	public static final IGrammarAwareElementType HiddenClause_Group_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_GroupElementType());

	public static final IGrammarAwareElementType HiddenClause_DefinesHiddenTokensAssignment_0_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_DefinesHiddenTokensAssignment_0ElementType());

	public static final IGrammarAwareElementType HiddenClause_DefinesHiddenTokensHiddenKeyword_0_0_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_DefinesHiddenTokensHiddenKeyword_0_0ElementType());

	public static final IGrammarAwareElementType HiddenClause_LeftParenthesisKeyword_1_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_LeftParenthesisKeyword_1ElementType());

	public static final IGrammarAwareElementType HiddenClause_Group_2_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_Group_2ElementType());

	public static final IGrammarAwareElementType HiddenClause_HiddenTokensAssignment_2_0_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_HiddenTokensAssignment_2_0ElementType());

	public static final IGrammarAwareElementType HiddenClause_HiddenTokensAbstractRuleCrossReference_2_0_0_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_HiddenTokensAbstractRuleCrossReference_2_0_0ElementType());

	public static final IGrammarAwareElementType HiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_0_0_1_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_0_0_1ElementType());

	public static final IGrammarAwareElementType HiddenClause_Group_2_1_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_Group_2_1ElementType());

	public static final IGrammarAwareElementType HiddenClause_CommaKeyword_2_1_0_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_CommaKeyword_2_1_0ElementType());

	public static final IGrammarAwareElementType HiddenClause_HiddenTokensAssignment_2_1_1_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_HiddenTokensAssignment_2_1_1ElementType());

	public static final IGrammarAwareElementType HiddenClause_HiddenTokensAbstractRuleCrossReference_2_1_1_0_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_HiddenTokensAbstractRuleCrossReference_2_1_1_0ElementType());

	public static final IGrammarAwareElementType HiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_1_1_0_1_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_1_1_0_1ElementType());

	public static final IGrammarAwareElementType HiddenClause_RightParenthesisKeyword_3_ELEMENT_TYPE = associate(HiddenClauseFactory.createHiddenClause_RightParenthesisKeyword_3ElementType());

	private static class GrammarIDFactory {
		public static IGrammarAwareElementType createGrammarIDElementType() {
			return new IGrammarAwareElementType("GrammarID_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDRule());
		}
		public static IGrammarAwareElementType createGrammarID_GroupElementType() {
			return new IGrammarAwareElementType("GrammarID_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDAccess().getGroup());
		}
		public static IGrammarAwareElementType createGrammarID_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("GrammarID_IDTerminalRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createGrammarID_Group_1ElementType() {
			return new IGrammarAwareElementType("GrammarID_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createGrammarID_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("GrammarID_FullStopKeyword_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createGrammarID_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("GrammarID_IDTerminalRuleCall_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType GrammarID_ELEMENT_TYPE = associate(GrammarIDFactory.createGrammarIDElementType());

	public static final IGrammarAwareElementType GrammarID_Group_ELEMENT_TYPE = associate(GrammarIDFactory.createGrammarID_GroupElementType());

	public static final IGrammarAwareElementType GrammarID_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(GrammarIDFactory.createGrammarID_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType GrammarID_Group_1_ELEMENT_TYPE = associate(GrammarIDFactory.createGrammarID_Group_1ElementType());

	public static final IGrammarAwareElementType GrammarID_FullStopKeyword_1_0_ELEMENT_TYPE = associate(GrammarIDFactory.createGrammarID_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType GrammarID_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(GrammarIDFactory.createGrammarID_IDTerminalRuleCall_1_1ElementType());

	private static class AbstractRuleFactory {
		public static IGrammarAwareElementType createAbstractRuleElementType() {
			return new IGrammarAwareElementType("AbstractRule_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleRule());
		}
		public static IGrammarAwareElementType createAbstractRule_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractRule_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractRule_ParserRuleParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractRule_ParserRuleParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getParserRuleParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractRule_TerminalRuleParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractRule_TerminalRuleParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1());
		}
		public static IGrammarAwareElementType createAbstractRule_EnumRuleParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("AbstractRule_EnumRuleParserRuleCall_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getEnumRuleParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType AbstractRule_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRuleElementType());

	public static final IGrammarAwareElementType AbstractRule_Alternatives_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractRule_ParserRuleParserRuleCall_0_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_ParserRuleParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractRule_TerminalRuleParserRuleCall_1_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_TerminalRuleParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType AbstractRule_EnumRuleParserRuleCall_2_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_EnumRuleParserRuleCall_2ElementType());

	private static class AbstractMetamodelDeclarationFactory {
		public static IGrammarAwareElementType createAbstractMetamodelDeclarationElementType() {
			return new IGrammarAwareElementType("AbstractMetamodelDeclaration_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMetamodelDeclarationRule());
		}
		public static IGrammarAwareElementType createAbstractMetamodelDeclaration_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractMetamodelDeclaration_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMetamodelDeclarationAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractMetamodelDeclaration_ELEMENT_TYPE = associate(AbstractMetamodelDeclarationFactory.createAbstractMetamodelDeclarationElementType());

	public static final IGrammarAwareElementType AbstractMetamodelDeclaration_Alternatives_ELEMENT_TYPE = associate(AbstractMetamodelDeclarationFactory.createAbstractMetamodelDeclaration_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0_ELEMENT_TYPE = associate(AbstractMetamodelDeclarationFactory.createAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1_ELEMENT_TYPE = associate(AbstractMetamodelDeclarationFactory.createAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType());

	private static class GeneratedMetamodelFactory {
		public static IGrammarAwareElementType createGeneratedMetamodelElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelRule());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_GroupElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getGroup());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_GenerateKeyword_0ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_GenerateKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getGenerateKeyword_0());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_NameAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_EPackageAssignment_2ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_EPackageAssignment_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getEPackageAssignment_2());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_EPackageEPackageCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_EPackageEPackageCrossReference_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_2_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_Group_3ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_Group_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_AsKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_AsKeyword_3_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getAsKeyword_3_0());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_AliasAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_AliasAssignment_3_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getAliasAssignment_3_1());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType GeneratedMetamodel_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodelElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_Group_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_GroupElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_GenerateKeyword_0_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_GenerateKeyword_0ElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_NameAssignment_1_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_EPackageAssignment_2_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_EPackageAssignment_2ElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_EPackageEPackageCrossReference_2_0_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_EPackageEPackageCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_2_0_1_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_2_0_1ElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_Group_3_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_Group_3ElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_AsKeyword_3_0_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_AsKeyword_3_0ElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_AliasAssignment_3_1_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_AliasAssignment_3_1ElementType());

	public static final IGrammarAwareElementType GeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(GeneratedMetamodelFactory.createGeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0ElementType());

	private static class ReferencedMetamodelFactory {
		public static IGrammarAwareElementType createReferencedMetamodelElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelRule());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_GroupElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getGroup());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_ImportKeyword_0ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_ImportKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getImportKeyword_0());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_EPackageAssignment_1ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_EPackageAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getEPackageAssignment_1());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_EPackageEPackageCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_EPackageEPackageCrossReference_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_1_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_Group_2ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_Group_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_AsKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_AsKeyword_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getAsKeyword_2_0());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_AliasAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_AliasAssignment_2_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getAliasAssignment_2_1());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType ReferencedMetamodel_ELEMENT_TYPE = associate(ReferencedMetamodelFactory.createReferencedMetamodelElementType());

	public static final IGrammarAwareElementType ReferencedMetamodel_Group_ELEMENT_TYPE = associate(ReferencedMetamodelFactory.createReferencedMetamodel_GroupElementType());

	public static final IGrammarAwareElementType ReferencedMetamodel_ImportKeyword_0_ELEMENT_TYPE = associate(ReferencedMetamodelFactory.createReferencedMetamodel_ImportKeyword_0ElementType());

	public static final IGrammarAwareElementType ReferencedMetamodel_EPackageAssignment_1_ELEMENT_TYPE = associate(ReferencedMetamodelFactory.createReferencedMetamodel_EPackageAssignment_1ElementType());

	public static final IGrammarAwareElementType ReferencedMetamodel_EPackageEPackageCrossReference_1_0_ELEMENT_TYPE = associate(ReferencedMetamodelFactory.createReferencedMetamodel_EPackageEPackageCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType ReferencedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(ReferencedMetamodelFactory.createReferencedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType ReferencedMetamodel_Group_2_ELEMENT_TYPE = associate(ReferencedMetamodelFactory.createReferencedMetamodel_Group_2ElementType());

	public static final IGrammarAwareElementType ReferencedMetamodel_AsKeyword_2_0_ELEMENT_TYPE = associate(ReferencedMetamodelFactory.createReferencedMetamodel_AsKeyword_2_0ElementType());

	public static final IGrammarAwareElementType ReferencedMetamodel_AliasAssignment_2_1_ELEMENT_TYPE = associate(ReferencedMetamodelFactory.createReferencedMetamodel_AliasAssignment_2_1ElementType());

	public static final IGrammarAwareElementType ReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(ReferencedMetamodelFactory.createReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0ElementType());

	private static class ParserRuleFactory {
		public static IGrammarAwareElementType createParserRuleElementType() {
			return new IGrammarAwareElementType("ParserRule_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleRule());
		}
		public static IGrammarAwareElementType createParserRule_GroupElementType() {
			return new IGrammarAwareElementType("ParserRule_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createParserRule_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_Alternatives_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getAlternatives_0());
		}
		public static IGrammarAwareElementType createParserRule_Group_0_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_Group_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getGroup_0_0());
		}
		public static IGrammarAwareElementType createParserRule_FragmentAssignment_0_0_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_FragmentAssignment_0_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getFragmentAssignment_0_0_0());
		}
		public static IGrammarAwareElementType createParserRule_FragmentFragmentKeyword_0_0_0_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_FragmentFragmentKeyword_0_0_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getFragmentFragmentKeyword_0_0_0_0());
		}
		public static IGrammarAwareElementType createParserRule_RuleNameAndParamsParserRuleCall_0_0_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_RuleNameAndParamsParserRuleCall_0_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_0_1());
		}
		public static IGrammarAwareElementType createParserRule_Alternatives_0_0_2ElementType() {
			return new IGrammarAwareElementType("ParserRule_Alternatives_0_0_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getAlternatives_0_0_2());
		}
		public static IGrammarAwareElementType createParserRule_WildcardAssignment_0_0_2_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_WildcardAssignment_0_0_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getWildcardAssignment_0_0_2_0());
		}
		public static IGrammarAwareElementType createParserRule_WildcardAsteriskKeyword_0_0_2_0_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_WildcardAsteriskKeyword_0_0_2_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getWildcardAsteriskKeyword_0_0_2_0_0());
		}
		public static IGrammarAwareElementType createParserRule_ReturnsClauseParserRuleCall_0_0_2_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_ReturnsClauseParserRuleCall_0_0_2_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getReturnsClauseParserRuleCall_0_0_2_1());
		}
		public static IGrammarAwareElementType createParserRule_Group_0_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_Group_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getGroup_0_1());
		}
		public static IGrammarAwareElementType createParserRule_RuleNameAndParamsParserRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_RuleNameAndParamsParserRuleCall_0_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createParserRule_ReturnsClauseParserRuleCall_0_1_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_ReturnsClauseParserRuleCall_0_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getReturnsClauseParserRuleCall_0_1_1());
		}
		public static IGrammarAwareElementType createParserRule_HiddenClauseParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_HiddenClauseParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getHiddenClauseParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParserRule_ColonKeyword_2ElementType() {
			return new IGrammarAwareElementType("ParserRule_ColonKeyword_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getColonKeyword_2());
		}
		public static IGrammarAwareElementType createParserRule_AlternativesAssignment_3ElementType() {
			return new IGrammarAwareElementType("ParserRule_AlternativesAssignment_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getAlternativesAssignment_3());
		}
		public static IGrammarAwareElementType createParserRule_AlternativesAlternativesParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_AlternativesAlternativesParserRuleCall_3_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createParserRule_SemicolonKeyword_4ElementType() {
			return new IGrammarAwareElementType("ParserRule_SemicolonKeyword_4_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getSemicolonKeyword_4());
		}
	}

	public static final IGrammarAwareElementType ParserRule_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRuleElementType());

	public static final IGrammarAwareElementType ParserRule_Group_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_GroupElementType());

	public static final IGrammarAwareElementType ParserRule_Alternatives_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_Alternatives_0ElementType());

	public static final IGrammarAwareElementType ParserRule_Group_0_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_Group_0_0ElementType());

	public static final IGrammarAwareElementType ParserRule_FragmentAssignment_0_0_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_FragmentAssignment_0_0_0ElementType());

	public static final IGrammarAwareElementType ParserRule_FragmentFragmentKeyword_0_0_0_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_FragmentFragmentKeyword_0_0_0_0ElementType());

	public static final IGrammarAwareElementType ParserRule_RuleNameAndParamsParserRuleCall_0_0_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_RuleNameAndParamsParserRuleCall_0_0_1ElementType());

	public static final IGrammarAwareElementType ParserRule_Alternatives_0_0_2_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_Alternatives_0_0_2ElementType());

	public static final IGrammarAwareElementType ParserRule_WildcardAssignment_0_0_2_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_WildcardAssignment_0_0_2_0ElementType());

	public static final IGrammarAwareElementType ParserRule_WildcardAsteriskKeyword_0_0_2_0_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_WildcardAsteriskKeyword_0_0_2_0_0ElementType());

	public static final IGrammarAwareElementType ParserRule_ReturnsClauseParserRuleCall_0_0_2_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_ReturnsClauseParserRuleCall_0_0_2_1ElementType());

	public static final IGrammarAwareElementType ParserRule_Group_0_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_Group_0_1ElementType());

	public static final IGrammarAwareElementType ParserRule_RuleNameAndParamsParserRuleCall_0_1_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_RuleNameAndParamsParserRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType ParserRule_ReturnsClauseParserRuleCall_0_1_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_ReturnsClauseParserRuleCall_0_1_1ElementType());

	public static final IGrammarAwareElementType ParserRule_HiddenClauseParserRuleCall_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_HiddenClauseParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType ParserRule_ColonKeyword_2_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_ColonKeyword_2ElementType());

	public static final IGrammarAwareElementType ParserRule_AlternativesAssignment_3_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_AlternativesAssignment_3ElementType());

	public static final IGrammarAwareElementType ParserRule_AlternativesAlternativesParserRuleCall_3_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_AlternativesAlternativesParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType ParserRule_SemicolonKeyword_4_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_SemicolonKeyword_4ElementType());

	private static class RuleNameAndParamsFactory {
		public static IGrammarAwareElementType createRuleNameAndParamsElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsRule());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_GroupElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getGroup());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_NameAssignment_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_Group_1ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_LeftSquareBracketKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_LeftSquareBracketKeyword_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getLeftSquareBracketKeyword_1_0());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_Group_1_1ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_Group_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_ParametersAssignment_1_1_0ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_ParametersAssignment_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_ParametersParameterParserRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_ParametersParameterParserRuleCall_1_1_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_Group_1_1_1ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_Group_1_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getGroup_1_1_1());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_CommaKeyword_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_CommaKeyword_1_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_ParametersAssignment_1_1_1_1ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_ParametersAssignment_1_1_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_ParametersParameterParserRuleCall_1_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_ParametersParameterParserRuleCall_1_1_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0());
		}
		public static IGrammarAwareElementType createRuleNameAndParams_RightSquareBracketKeyword_1_2ElementType() {
			return new IGrammarAwareElementType("RuleNameAndParams_RightSquareBracketKeyword_1_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleNameAndParamsAccess().getRightSquareBracketKeyword_1_2());
		}
	}

	public static final IGrammarAwareElementType RuleNameAndParams_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParamsElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_Group_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_GroupElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_NameAssignment_0_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_Group_1_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_Group_1ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_LeftSquareBracketKeyword_1_0_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_LeftSquareBracketKeyword_1_0ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_Group_1_1_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_Group_1_1ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_ParametersAssignment_1_1_0_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_ParametersAssignment_1_1_0ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_ParametersParameterParserRuleCall_1_1_0_0_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_ParametersParameterParserRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_Group_1_1_1_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_Group_1_1_1ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_CommaKeyword_1_1_1_0_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_CommaKeyword_1_1_1_0ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_ParametersAssignment_1_1_1_1_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_ParametersAssignment_1_1_1_1ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_ParametersParameterParserRuleCall_1_1_1_1_0_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_ParametersParameterParserRuleCall_1_1_1_1_0ElementType());

	public static final IGrammarAwareElementType RuleNameAndParams_RightSquareBracketKeyword_1_2_ELEMENT_TYPE = associate(RuleNameAndParamsFactory.createRuleNameAndParams_RightSquareBracketKeyword_1_2ElementType());

	private static class ReturnsClauseFactory {
		public static IGrammarAwareElementType createReturnsClauseElementType() {
			return new IGrammarAwareElementType("ReturnsClause_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReturnsClauseRule());
		}
		public static IGrammarAwareElementType createReturnsClause_GroupElementType() {
			return new IGrammarAwareElementType("ReturnsClause_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReturnsClauseAccess().getGroup());
		}
		public static IGrammarAwareElementType createReturnsClause_ReturnsKeyword_0ElementType() {
			return new IGrammarAwareElementType("ReturnsClause_ReturnsKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReturnsClauseAccess().getReturnsKeyword_0());
		}
		public static IGrammarAwareElementType createReturnsClause_TypeAssignment_1ElementType() {
			return new IGrammarAwareElementType("ReturnsClause_TypeAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReturnsClauseAccess().getTypeAssignment_1());
		}
		public static IGrammarAwareElementType createReturnsClause_TypeTypeRefParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ReturnsClause_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReturnsClauseAccess().getTypeTypeRefParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType ReturnsClause_ELEMENT_TYPE = associate(ReturnsClauseFactory.createReturnsClauseElementType());

	public static final IGrammarAwareElementType ReturnsClause_Group_ELEMENT_TYPE = associate(ReturnsClauseFactory.createReturnsClause_GroupElementType());

	public static final IGrammarAwareElementType ReturnsClause_ReturnsKeyword_0_ELEMENT_TYPE = associate(ReturnsClauseFactory.createReturnsClause_ReturnsKeyword_0ElementType());

	public static final IGrammarAwareElementType ReturnsClause_TypeAssignment_1_ELEMENT_TYPE = associate(ReturnsClauseFactory.createReturnsClause_TypeAssignment_1ElementType());

	public static final IGrammarAwareElementType ReturnsClause_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE = associate(ReturnsClauseFactory.createReturnsClause_TypeTypeRefParserRuleCall_1_0ElementType());

	private static class ParameterFactory {
		public static IGrammarAwareElementType createParameterElementType() {
			return new IGrammarAwareElementType("Parameter_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterRule());
		}
		public static IGrammarAwareElementType createParameter_NameAssignmentElementType() {
			return new IGrammarAwareElementType("Parameter_NameAssignment_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createParameter_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Parameter_NameIDTerminalRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Parameter_ELEMENT_TYPE = associate(ParameterFactory.createParameterElementType());

	public static final IGrammarAwareElementType Parameter_NameAssignment_ELEMENT_TYPE = associate(ParameterFactory.createParameter_NameAssignmentElementType());

	public static final IGrammarAwareElementType Parameter_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(ParameterFactory.createParameter_NameIDTerminalRuleCall_0ElementType());

	private static class TypeRefFactory {
		public static IGrammarAwareElementType createTypeRefElementType() {
			return new IGrammarAwareElementType("TypeRef_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefRule());
		}
		public static IGrammarAwareElementType createTypeRef_GroupElementType() {
			return new IGrammarAwareElementType("TypeRef_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getGroup());
		}
		public static IGrammarAwareElementType createTypeRef_Group_0ElementType() {
			return new IGrammarAwareElementType("TypeRef_Group_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createTypeRef_MetamodelAssignment_0_0ElementType() {
			return new IGrammarAwareElementType("TypeRef_MetamodelAssignment_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getMetamodelAssignment_0_0());
		}
		public static IGrammarAwareElementType createTypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0ElementType() {
			return new IGrammarAwareElementType("TypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0());
		}
		public static IGrammarAwareElementType createTypeRef_MetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1ElementType() {
			return new IGrammarAwareElementType("TypeRef_MetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1());
		}
		public static IGrammarAwareElementType createTypeRef_ColonColonKeyword_0_1ElementType() {
			return new IGrammarAwareElementType("TypeRef_ColonColonKeyword_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getColonColonKeyword_0_1());
		}
		public static IGrammarAwareElementType createTypeRef_ClassifierAssignment_1ElementType() {
			return new IGrammarAwareElementType("TypeRef_ClassifierAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getClassifierAssignment_1());
		}
		public static IGrammarAwareElementType createTypeRef_ClassifierEClassifierCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("TypeRef_ClassifierEClassifierCrossReference_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0());
		}
		public static IGrammarAwareElementType createTypeRef_ClassifierEClassifierIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("TypeRef_ClassifierEClassifierIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1());
		}
	}

	public static final IGrammarAwareElementType TypeRef_ELEMENT_TYPE = associate(TypeRefFactory.createTypeRefElementType());

	public static final IGrammarAwareElementType TypeRef_Group_ELEMENT_TYPE = associate(TypeRefFactory.createTypeRef_GroupElementType());

	public static final IGrammarAwareElementType TypeRef_Group_0_ELEMENT_TYPE = associate(TypeRefFactory.createTypeRef_Group_0ElementType());

	public static final IGrammarAwareElementType TypeRef_MetamodelAssignment_0_0_ELEMENT_TYPE = associate(TypeRefFactory.createTypeRef_MetamodelAssignment_0_0ElementType());

	public static final IGrammarAwareElementType TypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0_ELEMENT_TYPE = associate(TypeRefFactory.createTypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0ElementType());

	public static final IGrammarAwareElementType TypeRef_MetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1_ELEMENT_TYPE = associate(TypeRefFactory.createTypeRef_MetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1ElementType());

	public static final IGrammarAwareElementType TypeRef_ColonColonKeyword_0_1_ELEMENT_TYPE = associate(TypeRefFactory.createTypeRef_ColonColonKeyword_0_1ElementType());

	public static final IGrammarAwareElementType TypeRef_ClassifierAssignment_1_ELEMENT_TYPE = associate(TypeRefFactory.createTypeRef_ClassifierAssignment_1ElementType());

	public static final IGrammarAwareElementType TypeRef_ClassifierEClassifierCrossReference_1_0_ELEMENT_TYPE = associate(TypeRefFactory.createTypeRef_ClassifierEClassifierCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType TypeRef_ClassifierEClassifierIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(TypeRefFactory.createTypeRef_ClassifierEClassifierIDTerminalRuleCall_1_0_1ElementType());

	private static class AlternativesFactory {
		public static IGrammarAwareElementType createAlternativesElementType() {
			return new IGrammarAwareElementType("Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesRule());
		}
		public static IGrammarAwareElementType createAlternatives_GroupElementType() {
			return new IGrammarAwareElementType("Alternatives_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getGroup());
		}
		public static IGrammarAwareElementType createAlternatives_ConditionalBranchParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Alternatives_ConditionalBranchParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getConditionalBranchParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAlternatives_Group_1ElementType() {
			return new IGrammarAwareElementType("Alternatives_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createAlternatives_AlternativesElementsAction_1_0ElementType() {
			return new IGrammarAwareElementType("Alternatives_AlternativesElementsAction_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getAlternativesElementsAction_1_0());
		}
		public static IGrammarAwareElementType createAlternatives_Group_1_1ElementType() {
			return new IGrammarAwareElementType("Alternatives_Group_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAlternatives_VerticalLineKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("Alternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getVerticalLineKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createAlternatives_ElementsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("Alternatives_ElementsAssignment_1_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getElementsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createAlternatives_ElementsConditionalBranchParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Alternatives_ElementsConditionalBranchParserRuleCall_1_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Alternatives_ELEMENT_TYPE = associate(AlternativesFactory.createAlternativesElementType());

	public static final IGrammarAwareElementType Alternatives_Group_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_GroupElementType());

	public static final IGrammarAwareElementType Alternatives_ConditionalBranchParserRuleCall_0_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_ConditionalBranchParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Alternatives_Group_1_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_Group_1ElementType());

	public static final IGrammarAwareElementType Alternatives_AlternativesElementsAction_1_0_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_AlternativesElementsAction_1_0ElementType());

	public static final IGrammarAwareElementType Alternatives_Group_1_1_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_Group_1_1ElementType());

	public static final IGrammarAwareElementType Alternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_VerticalLineKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType Alternatives_ElementsAssignment_1_1_1_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_ElementsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType Alternatives_ElementsConditionalBranchParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_ElementsConditionalBranchParserRuleCall_1_1_1_0ElementType());

	private static class ConditionalBranchFactory {
		public static IGrammarAwareElementType createConditionalBranchElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchRule());
		}
		public static IGrammarAwareElementType createConditionalBranch_AlternativesElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createConditionalBranch_UnorderedGroupParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_UnorderedGroupParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0());
		}
		public static IGrammarAwareElementType createConditionalBranch_Group_1ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createConditionalBranch_ConditionalBranchAction_1_0ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_ConditionalBranchAction_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getConditionalBranchAction_1_0());
		}
		public static IGrammarAwareElementType createConditionalBranch_LeftSquareBracketKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_LeftSquareBracketKeyword_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getLeftSquareBracketKeyword_1_1());
		}
		public static IGrammarAwareElementType createConditionalBranch_FilteredAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_FilteredAssignment_1_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getFilteredAssignment_1_2());
		}
		public static IGrammarAwareElementType createConditionalBranch_FilteredInverseLiteralValueParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_FilteredInverseLiteralValueParserRuleCall_1_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getFilteredInverseLiteralValueParserRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createConditionalBranch_ParameterAssignment_1_3ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_ParameterAssignment_1_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getParameterAssignment_1_3());
		}
		public static IGrammarAwareElementType createConditionalBranch_ParameterParameterCrossReference_1_3_0ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_ParameterParameterCrossReference_1_3_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getParameterParameterCrossReference_1_3_0());
		}
		public static IGrammarAwareElementType createConditionalBranch_ParameterParameterIDTerminalRuleCall_1_3_0_1ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_ParameterParameterIDTerminalRuleCall_1_3_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getParameterParameterIDTerminalRuleCall_1_3_0_1());
		}
		public static IGrammarAwareElementType createConditionalBranch_RightSquareBracketKeyword_1_4ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_RightSquareBracketKeyword_1_4_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getRightSquareBracketKeyword_1_4());
		}
		public static IGrammarAwareElementType createConditionalBranch_GuardedElementAssignment_1_5ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_GuardedElementAssignment_1_5_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getGuardedElementAssignment_1_5());
		}
		public static IGrammarAwareElementType createConditionalBranch_GuardedElementUnorderedGroupParserRuleCall_1_5_0ElementType() {
			return new IGrammarAwareElementType("ConditionalBranch_GuardedElementUnorderedGroupParserRuleCall_1_5_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConditionalBranchAccess().getGuardedElementUnorderedGroupParserRuleCall_1_5_0());
		}
	}

	public static final IGrammarAwareElementType ConditionalBranch_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranchElementType());

	public static final IGrammarAwareElementType ConditionalBranch_Alternatives_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_AlternativesElementType());

	public static final IGrammarAwareElementType ConditionalBranch_UnorderedGroupParserRuleCall_0_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_UnorderedGroupParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_Group_1_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_Group_1ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_ConditionalBranchAction_1_0_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_ConditionalBranchAction_1_0ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_LeftSquareBracketKeyword_1_1_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_LeftSquareBracketKeyword_1_1ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_FilteredAssignment_1_2_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_FilteredAssignment_1_2ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_FilteredInverseLiteralValueParserRuleCall_1_2_0_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_FilteredInverseLiteralValueParserRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_ParameterAssignment_1_3_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_ParameterAssignment_1_3ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_ParameterParameterCrossReference_1_3_0_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_ParameterParameterCrossReference_1_3_0ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_ParameterParameterIDTerminalRuleCall_1_3_0_1_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_ParameterParameterIDTerminalRuleCall_1_3_0_1ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_RightSquareBracketKeyword_1_4_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_RightSquareBracketKeyword_1_4ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_GuardedElementAssignment_1_5_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_GuardedElementAssignment_1_5ElementType());

	public static final IGrammarAwareElementType ConditionalBranch_GuardedElementUnorderedGroupParserRuleCall_1_5_0_ELEMENT_TYPE = associate(ConditionalBranchFactory.createConditionalBranch_GuardedElementUnorderedGroupParserRuleCall_1_5_0ElementType());

	private static class UnorderedGroupFactory {
		public static IGrammarAwareElementType createUnorderedGroupElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupRule());
		}
		public static IGrammarAwareElementType createUnorderedGroup_GroupElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnorderedGroup_GroupParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_GroupParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getGroupParserRuleCall_0());
		}
		public static IGrammarAwareElementType createUnorderedGroup_Group_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createUnorderedGroup_UnorderedGroupElementsAction_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_UnorderedGroupElementsAction_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0());
		}
		public static IGrammarAwareElementType createUnorderedGroup_Group_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_Group_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createUnorderedGroup_AmpersandKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_AmpersandKeyword_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createUnorderedGroup_ElementsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_ElementsAssignment_1_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getElementsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createUnorderedGroup_ElementsGroupParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedGroup_ElementsGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType UnorderedGroup_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroupElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Group_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_GroupElementType());

	public static final IGrammarAwareElementType UnorderedGroup_GroupParserRuleCall_0_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_GroupParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Group_1_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_Group_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_UnorderedGroupElementsAction_1_0_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_UnorderedGroupElementsAction_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_Group_1_1_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_Group_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_AmpersandKeyword_1_1_0_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_AmpersandKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_ElementsAssignment_1_1_1_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_ElementsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedGroup_ElementsGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(UnorderedGroupFactory.createUnorderedGroup_ElementsGroupParserRuleCall_1_1_1_0ElementType());

	private static class GroupFactory {
		public static IGrammarAwareElementType createGroupElementType() {
			return new IGrammarAwareElementType("Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupRule());
		}
		public static IGrammarAwareElementType createGroup_GroupElementType() {
			return new IGrammarAwareElementType("Group_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getGroup());
		}
		public static IGrammarAwareElementType createGroup_AbstractTokenParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Group_AbstractTokenParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getAbstractTokenParserRuleCall_0());
		}
		public static IGrammarAwareElementType createGroup_Group_1ElementType() {
			return new IGrammarAwareElementType("Group_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createGroup_GroupElementsAction_1_0ElementType() {
			return new IGrammarAwareElementType("Group_GroupElementsAction_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getGroupElementsAction_1_0());
		}
		public static IGrammarAwareElementType createGroup_ElementsAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Group_ElementsAssignment_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getElementsAssignment_1_1());
		}
		public static IGrammarAwareElementType createGroup_ElementsAbstractTokenParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Group_ElementsAbstractTokenParserRuleCall_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Group_ELEMENT_TYPE = associate(GroupFactory.createGroupElementType());

	public static final IGrammarAwareElementType Group_Group_ELEMENT_TYPE = associate(GroupFactory.createGroup_GroupElementType());

	public static final IGrammarAwareElementType Group_AbstractTokenParserRuleCall_0_ELEMENT_TYPE = associate(GroupFactory.createGroup_AbstractTokenParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Group_Group_1_ELEMENT_TYPE = associate(GroupFactory.createGroup_Group_1ElementType());

	public static final IGrammarAwareElementType Group_GroupElementsAction_1_0_ELEMENT_TYPE = associate(GroupFactory.createGroup_GroupElementsAction_1_0ElementType());

	public static final IGrammarAwareElementType Group_ElementsAssignment_1_1_ELEMENT_TYPE = associate(GroupFactory.createGroup_ElementsAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Group_ElementsAbstractTokenParserRuleCall_1_1_0_ELEMENT_TYPE = associate(GroupFactory.createGroup_ElementsAbstractTokenParserRuleCall_1_1_0ElementType());

	private static class AbstractTokenFactory {
		public static IGrammarAwareElementType createAbstractTokenElementType() {
			return new IGrammarAwareElementType("AbstractToken_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenRule());
		}
		public static IGrammarAwareElementType createAbstractToken_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractToken_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractToken_AbstractTokenWithCardinalityParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractToken_ActionParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractToken_ActionParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenAccess().getActionParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractToken_ELEMENT_TYPE = associate(AbstractTokenFactory.createAbstractTokenElementType());

	public static final IGrammarAwareElementType AbstractToken_Alternatives_ELEMENT_TYPE = associate(AbstractTokenFactory.createAbstractToken_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractToken_AbstractTokenWithCardinalityParserRuleCall_0_ELEMENT_TYPE = associate(AbstractTokenFactory.createAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractToken_ActionParserRuleCall_1_ELEMENT_TYPE = associate(AbstractTokenFactory.createAbstractToken_ActionParserRuleCall_1ElementType());

	private static class AbstractTokenWithCardinalityFactory {
		public static IGrammarAwareElementType createAbstractTokenWithCardinalityElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityRule());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_GroupElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getGroup());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_Alternatives_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getAlternatives_0());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_AssignmentParserRuleCall_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_CardinalitiesParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_CardinalitiesParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getCardinalitiesParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinalityElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_Group_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_GroupElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_Alternatives_0_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_Alternatives_0ElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_AssignmentParserRuleCall_0_0_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_CardinalitiesParserRuleCall_1_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_CardinalitiesParserRuleCall_1ElementType());

	private static class CardinalitiesFactory {
		public static IGrammarAwareElementType createCardinalitiesElementType() {
			return new IGrammarAwareElementType("Cardinalities_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCardinalitiesRule());
		}
		public static IGrammarAwareElementType createCardinalities_CardinalityAssignmentElementType() {
			return new IGrammarAwareElementType("Cardinalities_CardinalityAssignment_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCardinalitiesAccess().getCardinalityAssignment());
		}
		public static IGrammarAwareElementType createCardinalities_CardinalityAlternatives_0ElementType() {
			return new IGrammarAwareElementType("Cardinalities_CardinalityAlternatives_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCardinalitiesAccess().getCardinalityAlternatives_0());
		}
		public static IGrammarAwareElementType createCardinalities_CardinalityQuestionMarkKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Cardinalities_CardinalityQuestionMarkKeyword_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCardinalitiesAccess().getCardinalityQuestionMarkKeyword_0_0());
		}
		public static IGrammarAwareElementType createCardinalities_CardinalityAsteriskKeyword_0_1ElementType() {
			return new IGrammarAwareElementType("Cardinalities_CardinalityAsteriskKeyword_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCardinalitiesAccess().getCardinalityAsteriskKeyword_0_1());
		}
		public static IGrammarAwareElementType createCardinalities_CardinalityPlusSignKeyword_0_2ElementType() {
			return new IGrammarAwareElementType("Cardinalities_CardinalityPlusSignKeyword_0_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCardinalitiesAccess().getCardinalityPlusSignKeyword_0_2());
		}
	}

	public static final IGrammarAwareElementType Cardinalities_ELEMENT_TYPE = associate(CardinalitiesFactory.createCardinalitiesElementType());

	public static final IGrammarAwareElementType Cardinalities_CardinalityAssignment_ELEMENT_TYPE = associate(CardinalitiesFactory.createCardinalities_CardinalityAssignmentElementType());

	public static final IGrammarAwareElementType Cardinalities_CardinalityAlternatives_0_ELEMENT_TYPE = associate(CardinalitiesFactory.createCardinalities_CardinalityAlternatives_0ElementType());

	public static final IGrammarAwareElementType Cardinalities_CardinalityQuestionMarkKeyword_0_0_ELEMENT_TYPE = associate(CardinalitiesFactory.createCardinalities_CardinalityQuestionMarkKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Cardinalities_CardinalityAsteriskKeyword_0_1_ELEMENT_TYPE = associate(CardinalitiesFactory.createCardinalities_CardinalityAsteriskKeyword_0_1ElementType());

	public static final IGrammarAwareElementType Cardinalities_CardinalityPlusSignKeyword_0_2_ELEMENT_TYPE = associate(CardinalitiesFactory.createCardinalities_CardinalityPlusSignKeyword_0_2ElementType());

	private static class ActionFactory {
		public static IGrammarAwareElementType createActionElementType() {
			return new IGrammarAwareElementType("Action_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionRule());
		}
		public static IGrammarAwareElementType createAction_GroupElementType() {
			return new IGrammarAwareElementType("Action_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getGroup());
		}
		public static IGrammarAwareElementType createAction_LeftCurlyBracketKeyword_0ElementType() {
			return new IGrammarAwareElementType("Action_LeftCurlyBracketKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getLeftCurlyBracketKeyword_0());
		}
		public static IGrammarAwareElementType createAction_TypeAssignment_1ElementType() {
			return new IGrammarAwareElementType("Action_TypeAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getTypeAssignment_1());
		}
		public static IGrammarAwareElementType createAction_TypeTypeRefParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Action_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getTypeTypeRefParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createAction_Group_2ElementType() {
			return new IGrammarAwareElementType("Action_Group_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createAction_FullStopKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Action_FullStopKeyword_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getFullStopKeyword_2_0());
		}
		public static IGrammarAwareElementType createAction_FeatureAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Action_FeatureAssignment_2_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getFeatureAssignment_2_1());
		}
		public static IGrammarAwareElementType createAction_FeatureIDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Action_FeatureIDTerminalRuleCall_2_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createAction_OperatorAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("Action_OperatorAssignment_2_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getOperatorAssignment_2_2());
		}
		public static IGrammarAwareElementType createAction_OperatorAlternatives_2_2_0ElementType() {
			return new IGrammarAwareElementType("Action_OperatorAlternatives_2_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getOperatorAlternatives_2_2_0());
		}
		public static IGrammarAwareElementType createAction_OperatorEqualsSignKeyword_2_2_0_0ElementType() {
			return new IGrammarAwareElementType("Action_OperatorEqualsSignKeyword_2_2_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0());
		}
		public static IGrammarAwareElementType createAction_OperatorPlusSignEqualsSignKeyword_2_2_0_1ElementType() {
			return new IGrammarAwareElementType("Action_OperatorPlusSignEqualsSignKeyword_2_2_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1());
		}
		public static IGrammarAwareElementType createAction_CurrentKeyword_2_3ElementType() {
			return new IGrammarAwareElementType("Action_CurrentKeyword_2_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getCurrentKeyword_2_3());
		}
		public static IGrammarAwareElementType createAction_RightCurlyBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("Action_RightCurlyBracketKeyword_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getRightCurlyBracketKeyword_3());
		}
	}

	public static final IGrammarAwareElementType Action_ELEMENT_TYPE = associate(ActionFactory.createActionElementType());

	public static final IGrammarAwareElementType Action_Group_ELEMENT_TYPE = associate(ActionFactory.createAction_GroupElementType());

	public static final IGrammarAwareElementType Action_LeftCurlyBracketKeyword_0_ELEMENT_TYPE = associate(ActionFactory.createAction_LeftCurlyBracketKeyword_0ElementType());

	public static final IGrammarAwareElementType Action_TypeAssignment_1_ELEMENT_TYPE = associate(ActionFactory.createAction_TypeAssignment_1ElementType());

	public static final IGrammarAwareElementType Action_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE = associate(ActionFactory.createAction_TypeTypeRefParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Action_Group_2_ELEMENT_TYPE = associate(ActionFactory.createAction_Group_2ElementType());

	public static final IGrammarAwareElementType Action_FullStopKeyword_2_0_ELEMENT_TYPE = associate(ActionFactory.createAction_FullStopKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Action_FeatureAssignment_2_1_ELEMENT_TYPE = associate(ActionFactory.createAction_FeatureAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Action_FeatureIDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(ActionFactory.createAction_FeatureIDTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Action_OperatorAssignment_2_2_ELEMENT_TYPE = associate(ActionFactory.createAction_OperatorAssignment_2_2ElementType());

	public static final IGrammarAwareElementType Action_OperatorAlternatives_2_2_0_ELEMENT_TYPE = associate(ActionFactory.createAction_OperatorAlternatives_2_2_0ElementType());

	public static final IGrammarAwareElementType Action_OperatorEqualsSignKeyword_2_2_0_0_ELEMENT_TYPE = associate(ActionFactory.createAction_OperatorEqualsSignKeyword_2_2_0_0ElementType());

	public static final IGrammarAwareElementType Action_OperatorPlusSignEqualsSignKeyword_2_2_0_1_ELEMENT_TYPE = associate(ActionFactory.createAction_OperatorPlusSignEqualsSignKeyword_2_2_0_1ElementType());

	public static final IGrammarAwareElementType Action_CurrentKeyword_2_3_ELEMENT_TYPE = associate(ActionFactory.createAction_CurrentKeyword_2_3ElementType());

	public static final IGrammarAwareElementType Action_RightCurlyBracketKeyword_3_ELEMENT_TYPE = associate(ActionFactory.createAction_RightCurlyBracketKeyword_3ElementType());

	private static class AbstractTerminalFactory {
		public static IGrammarAwareElementType createAbstractTerminalElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalRule());
		}
		public static IGrammarAwareElementType createAbstractTerminal_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractTerminal_KeywordParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getKeywordParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractTerminal_RuleCallParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getRuleCallParserRuleCall_1());
		}
		public static IGrammarAwareElementType createAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_ParenthesizedElementParserRuleCall_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2());
		}
		public static IGrammarAwareElementType createAbstractTerminal_PredicatedKeywordParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_PredicatedKeywordParserRuleCall_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3());
		}
		public static IGrammarAwareElementType createAbstractTerminal_PredicatedRuleCallParserRuleCall_4ElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_PredicatedRuleCallParserRuleCall_4_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4());
		}
		public static IGrammarAwareElementType createAbstractTerminal_PredicatedGroupParserRuleCall_5ElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_PredicatedGroupParserRuleCall_5_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5());
		}
	}

	public static final IGrammarAwareElementType AbstractTerminal_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminalElementType());

	public static final IGrammarAwareElementType AbstractTerminal_Alternatives_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_KeywordParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_RuleCallParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType AbstractTerminal_ParenthesizedElementParserRuleCall_2_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType AbstractTerminal_PredicatedKeywordParserRuleCall_3_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_PredicatedKeywordParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType AbstractTerminal_PredicatedRuleCallParserRuleCall_4_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_PredicatedRuleCallParserRuleCall_4ElementType());

	public static final IGrammarAwareElementType AbstractTerminal_PredicatedGroupParserRuleCall_5_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_PredicatedGroupParserRuleCall_5ElementType());

	private static class KeywordFactory {
		public static IGrammarAwareElementType createKeywordElementType() {
			return new IGrammarAwareElementType("Keyword_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordRule());
		}
		public static IGrammarAwareElementType createKeyword_ValueAssignmentElementType() {
			return new IGrammarAwareElementType("Keyword_ValueAssignment_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordAccess().getValueAssignment());
		}
		public static IGrammarAwareElementType createKeyword_ValueSTRINGTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Keyword_ValueSTRINGTerminalRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordAccess().getValueSTRINGTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Keyword_ELEMENT_TYPE = associate(KeywordFactory.createKeywordElementType());

	public static final IGrammarAwareElementType Keyword_ValueAssignment_ELEMENT_TYPE = associate(KeywordFactory.createKeyword_ValueAssignmentElementType());

	public static final IGrammarAwareElementType Keyword_ValueSTRINGTerminalRuleCall_0_ELEMENT_TYPE = associate(KeywordFactory.createKeyword_ValueSTRINGTerminalRuleCall_0ElementType());

	private static class RuleCallFactory {
		public static IGrammarAwareElementType createRuleCallElementType() {
			return new IGrammarAwareElementType("RuleCall_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallRule());
		}
		public static IGrammarAwareElementType createRuleCall_GroupElementType() {
			return new IGrammarAwareElementType("RuleCall_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getGroup());
		}
		public static IGrammarAwareElementType createRuleCall_RuleCallAction_0ElementType() {
			return new IGrammarAwareElementType("RuleCall_RuleCallAction_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getRuleCallAction_0());
		}
		public static IGrammarAwareElementType createRuleCall_RuleAssignment_1ElementType() {
			return new IGrammarAwareElementType("RuleCall_RuleAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getRuleAssignment_1());
		}
		public static IGrammarAwareElementType createRuleCall_RuleAbstractRuleCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCall_RuleAbstractRuleCrossReference_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getRuleAbstractRuleCrossReference_1_0());
		}
		public static IGrammarAwareElementType createRuleCall_RuleAbstractRuleRuleIDParserRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("RuleCall_RuleAbstractRuleRuleIDParserRuleCall_1_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createRuleCall_Group_2ElementType() {
			return new IGrammarAwareElementType("RuleCall_Group_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createRuleCall_LeftSquareBracketKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("RuleCall_LeftSquareBracketKeyword_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getLeftSquareBracketKeyword_2_0());
		}
		public static IGrammarAwareElementType createRuleCall_ArgumentsAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("RuleCall_ArgumentsAssignment_2_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getArgumentsAssignment_2_1());
		}
		public static IGrammarAwareElementType createRuleCall_ArgumentsNamedArgumentParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCall_ArgumentsNamedArgumentParserRuleCall_2_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createRuleCall_Group_2_2ElementType() {
			return new IGrammarAwareElementType("RuleCall_Group_2_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getGroup_2_2());
		}
		public static IGrammarAwareElementType createRuleCall_CommaKeyword_2_2_0ElementType() {
			return new IGrammarAwareElementType("RuleCall_CommaKeyword_2_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getCommaKeyword_2_2_0());
		}
		public static IGrammarAwareElementType createRuleCall_ArgumentsAssignment_2_2_1ElementType() {
			return new IGrammarAwareElementType("RuleCall_ArgumentsAssignment_2_2_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getArgumentsAssignment_2_2_1());
		}
		public static IGrammarAwareElementType createRuleCall_ArgumentsNamedArgumentParserRuleCall_2_2_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCall_ArgumentsNamedArgumentParserRuleCall_2_2_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0());
		}
		public static IGrammarAwareElementType createRuleCall_RightSquareBracketKeyword_2_3ElementType() {
			return new IGrammarAwareElementType("RuleCall_RightSquareBracketKeyword_2_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getRightSquareBracketKeyword_2_3());
		}
	}

	public static final IGrammarAwareElementType RuleCall_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCallElementType());

	public static final IGrammarAwareElementType RuleCall_Group_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_GroupElementType());

	public static final IGrammarAwareElementType RuleCall_RuleCallAction_0_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_RuleCallAction_0ElementType());

	public static final IGrammarAwareElementType RuleCall_RuleAssignment_1_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_RuleAssignment_1ElementType());

	public static final IGrammarAwareElementType RuleCall_RuleAbstractRuleCrossReference_1_0_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_RuleAbstractRuleCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType RuleCall_RuleAbstractRuleRuleIDParserRuleCall_1_0_1_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_RuleAbstractRuleRuleIDParserRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType RuleCall_Group_2_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_Group_2ElementType());

	public static final IGrammarAwareElementType RuleCall_LeftSquareBracketKeyword_2_0_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_LeftSquareBracketKeyword_2_0ElementType());

	public static final IGrammarAwareElementType RuleCall_ArgumentsAssignment_2_1_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_ArgumentsAssignment_2_1ElementType());

	public static final IGrammarAwareElementType RuleCall_ArgumentsNamedArgumentParserRuleCall_2_1_0_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_ArgumentsNamedArgumentParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType RuleCall_Group_2_2_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_Group_2_2ElementType());

	public static final IGrammarAwareElementType RuleCall_CommaKeyword_2_2_0_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_CommaKeyword_2_2_0ElementType());

	public static final IGrammarAwareElementType RuleCall_ArgumentsAssignment_2_2_1_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_ArgumentsAssignment_2_2_1ElementType());

	public static final IGrammarAwareElementType RuleCall_ArgumentsNamedArgumentParserRuleCall_2_2_1_0_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_ArgumentsNamedArgumentParserRuleCall_2_2_1_0ElementType());

	public static final IGrammarAwareElementType RuleCall_RightSquareBracketKeyword_2_3_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_RightSquareBracketKeyword_2_3ElementType());

	private static class LiteralValueFactory {
		public static IGrammarAwareElementType createLiteralValueElementType() {
			return new IGrammarAwareElementType("LiteralValue_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLiteralValueRule());
		}
		public static IGrammarAwareElementType createLiteralValue_AlternativesElementType() {
			return new IGrammarAwareElementType("LiteralValue_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLiteralValueAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createLiteralValue_ExclamationMarkKeyword_0ElementType() {
			return new IGrammarAwareElementType("LiteralValue_ExclamationMarkKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLiteralValueAccess().getExclamationMarkKeyword_0());
		}
		public static IGrammarAwareElementType createLiteralValue_PlusSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("LiteralValue_PlusSignKeyword_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLiteralValueAccess().getPlusSignKeyword_1());
		}
	}

	public static final IGrammarAwareElementType LiteralValue_ELEMENT_TYPE = associate(LiteralValueFactory.createLiteralValueElementType());

	public static final IGrammarAwareElementType LiteralValue_Alternatives_ELEMENT_TYPE = associate(LiteralValueFactory.createLiteralValue_AlternativesElementType());

	public static final IGrammarAwareElementType LiteralValue_ExclamationMarkKeyword_0_ELEMENT_TYPE = associate(LiteralValueFactory.createLiteralValue_ExclamationMarkKeyword_0ElementType());

	public static final IGrammarAwareElementType LiteralValue_PlusSignKeyword_1_ELEMENT_TYPE = associate(LiteralValueFactory.createLiteralValue_PlusSignKeyword_1ElementType());

	private static class InverseLiteralValueFactory {
		public static IGrammarAwareElementType createInverseLiteralValueElementType() {
			return new IGrammarAwareElementType("InverseLiteralValue_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInverseLiteralValueRule());
		}
		public static IGrammarAwareElementType createInverseLiteralValue_LiteralValueParserRuleCallElementType() {
			return new IGrammarAwareElementType("InverseLiteralValue_LiteralValueParserRuleCall_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInverseLiteralValueAccess().getLiteralValueParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType InverseLiteralValue_ELEMENT_TYPE = associate(InverseLiteralValueFactory.createInverseLiteralValueElementType());

	public static final IGrammarAwareElementType InverseLiteralValue_LiteralValueParserRuleCall_ELEMENT_TYPE = associate(InverseLiteralValueFactory.createInverseLiteralValue_LiteralValueParserRuleCallElementType());

	private static class NamedArgumentFactory {
		public static IGrammarAwareElementType createNamedArgumentElementType() {
			return new IGrammarAwareElementType("NamedArgument_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentRule());
		}
		public static IGrammarAwareElementType createNamedArgument_GroupElementType() {
			return new IGrammarAwareElementType("NamedArgument_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getGroup());
		}
		public static IGrammarAwareElementType createNamedArgument_NamedArgumentAction_0ElementType() {
			return new IGrammarAwareElementType("NamedArgument_NamedArgumentAction_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getNamedArgumentAction_0());
		}
		public static IGrammarAwareElementType createNamedArgument_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("NamedArgument_Alternatives_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createNamedArgument_Group_1_0ElementType() {
			return new IGrammarAwareElementType("NamedArgument_Group_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createNamedArgument_LiteralValueAssignment_1_0_0ElementType() {
			return new IGrammarAwareElementType("NamedArgument_LiteralValueAssignment_1_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getLiteralValueAssignment_1_0_0());
		}
		public static IGrammarAwareElementType createNamedArgument_LiteralValueLiteralValueParserRuleCall_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("NamedArgument_LiteralValueLiteralValueParserRuleCall_1_0_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getLiteralValueLiteralValueParserRuleCall_1_0_0_0());
		}
		public static IGrammarAwareElementType createNamedArgument_ParameterAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("NamedArgument_ParameterAssignment_1_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getParameterAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createNamedArgument_ParameterParameterCrossReference_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("NamedArgument_ParameterParameterCrossReference_1_0_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getParameterParameterCrossReference_1_0_1_0());
		}
		public static IGrammarAwareElementType createNamedArgument_ParameterParameterIDTerminalRuleCall_1_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("NamedArgument_ParameterParameterIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_1_0_1_0_1());
		}
		public static IGrammarAwareElementType createNamedArgument_Group_1_1ElementType() {
			return new IGrammarAwareElementType("NamedArgument_Group_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createNamedArgument_ParameterAssignment_1_1_0ElementType() {
			return new IGrammarAwareElementType("NamedArgument_ParameterAssignment_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getParameterAssignment_1_1_0());
		}
		public static IGrammarAwareElementType createNamedArgument_ParameterParameterCrossReference_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("NamedArgument_ParameterParameterCrossReference_1_1_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getParameterParameterCrossReference_1_1_0_0());
		}
		public static IGrammarAwareElementType createNamedArgument_ParameterParameterIDTerminalRuleCall_1_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("NamedArgument_ParameterParameterIDTerminalRuleCall_1_1_0_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_1_1_0_0_1());
		}
		public static IGrammarAwareElementType createNamedArgument_EqualsSignKeyword_1_1_1ElementType() {
			return new IGrammarAwareElementType("NamedArgument_EqualsSignKeyword_1_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getEqualsSignKeyword_1_1_1());
		}
		public static IGrammarAwareElementType createNamedArgument_ValueAssignment_1_1_2ElementType() {
			return new IGrammarAwareElementType("NamedArgument_ValueAssignment_1_1_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getValueAssignment_1_1_2());
		}
		public static IGrammarAwareElementType createNamedArgument_ValueParameterCrossReference_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("NamedArgument_ValueParameterCrossReference_1_1_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getValueParameterCrossReference_1_1_2_0());
		}
		public static IGrammarAwareElementType createNamedArgument_ValueParameterIDTerminalRuleCall_1_1_2_0_1ElementType() {
			return new IGrammarAwareElementType("NamedArgument_ValueParameterIDTerminalRuleCall_1_1_2_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedArgumentAccess().getValueParameterIDTerminalRuleCall_1_1_2_0_1());
		}
	}

	public static final IGrammarAwareElementType NamedArgument_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgumentElementType());

	public static final IGrammarAwareElementType NamedArgument_Group_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_GroupElementType());

	public static final IGrammarAwareElementType NamedArgument_NamedArgumentAction_0_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_NamedArgumentAction_0ElementType());

	public static final IGrammarAwareElementType NamedArgument_Alternatives_1_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_Alternatives_1ElementType());

	public static final IGrammarAwareElementType NamedArgument_Group_1_0_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_Group_1_0ElementType());

	public static final IGrammarAwareElementType NamedArgument_LiteralValueAssignment_1_0_0_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_LiteralValueAssignment_1_0_0ElementType());

	public static final IGrammarAwareElementType NamedArgument_LiteralValueLiteralValueParserRuleCall_1_0_0_0_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_LiteralValueLiteralValueParserRuleCall_1_0_0_0ElementType());

	public static final IGrammarAwareElementType NamedArgument_ParameterAssignment_1_0_1_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_ParameterAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType NamedArgument_ParameterParameterCrossReference_1_0_1_0_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_ParameterParameterCrossReference_1_0_1_0ElementType());

	public static final IGrammarAwareElementType NamedArgument_ParameterParameterIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_ParameterParameterIDTerminalRuleCall_1_0_1_0_1ElementType());

	public static final IGrammarAwareElementType NamedArgument_Group_1_1_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_Group_1_1ElementType());

	public static final IGrammarAwareElementType NamedArgument_ParameterAssignment_1_1_0_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_ParameterAssignment_1_1_0ElementType());

	public static final IGrammarAwareElementType NamedArgument_ParameterParameterCrossReference_1_1_0_0_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_ParameterParameterCrossReference_1_1_0_0ElementType());

	public static final IGrammarAwareElementType NamedArgument_ParameterParameterIDTerminalRuleCall_1_1_0_0_1_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_ParameterParameterIDTerminalRuleCall_1_1_0_0_1ElementType());

	public static final IGrammarAwareElementType NamedArgument_EqualsSignKeyword_1_1_1_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_EqualsSignKeyword_1_1_1ElementType());

	public static final IGrammarAwareElementType NamedArgument_ValueAssignment_1_1_2_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_ValueAssignment_1_1_2ElementType());

	public static final IGrammarAwareElementType NamedArgument_ValueParameterCrossReference_1_1_2_0_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_ValueParameterCrossReference_1_1_2_0ElementType());

	public static final IGrammarAwareElementType NamedArgument_ValueParameterIDTerminalRuleCall_1_1_2_0_1_ELEMENT_TYPE = associate(NamedArgumentFactory.createNamedArgument_ValueParameterIDTerminalRuleCall_1_1_2_0_1ElementType());

	private static class TerminalRuleCallFactory {
		public static IGrammarAwareElementType createTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("TerminalRuleCall_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleCallRule());
		}
		public static IGrammarAwareElementType createTerminalRuleCall_RuleAssignmentElementType() {
			return new IGrammarAwareElementType("TerminalRuleCall_RuleAssignment_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleCallAccess().getRuleAssignment());
		}
		public static IGrammarAwareElementType createTerminalRuleCall_RuleAbstractRuleCrossReference_0ElementType() {
			return new IGrammarAwareElementType("TerminalRuleCall_RuleAbstractRuleCrossReference_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0());
		}
		public static IGrammarAwareElementType createTerminalRuleCall_RuleAbstractRuleRuleIDParserRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("TerminalRuleCall_RuleAbstractRuleRuleIDParserRuleCall_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType TerminalRuleCall_ELEMENT_TYPE = associate(TerminalRuleCallFactory.createTerminalRuleCallElementType());

	public static final IGrammarAwareElementType TerminalRuleCall_RuleAssignment_ELEMENT_TYPE = associate(TerminalRuleCallFactory.createTerminalRuleCall_RuleAssignmentElementType());

	public static final IGrammarAwareElementType TerminalRuleCall_RuleAbstractRuleCrossReference_0_ELEMENT_TYPE = associate(TerminalRuleCallFactory.createTerminalRuleCall_RuleAbstractRuleCrossReference_0ElementType());

	public static final IGrammarAwareElementType TerminalRuleCall_RuleAbstractRuleRuleIDParserRuleCall_0_1_ELEMENT_TYPE = associate(TerminalRuleCallFactory.createTerminalRuleCall_RuleAbstractRuleRuleIDParserRuleCall_0_1ElementType());

	private static class RuleIDFactory {
		public static IGrammarAwareElementType createRuleIDElementType() {
			return new IGrammarAwareElementType("RuleID_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleIDRule());
		}
		public static IGrammarAwareElementType createRuleID_GroupElementType() {
			return new IGrammarAwareElementType("RuleID_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleIDAccess().getGroup());
		}
		public static IGrammarAwareElementType createRuleID_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("RuleID_IDTerminalRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleIDAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createRuleID_Group_1ElementType() {
			return new IGrammarAwareElementType("RuleID_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleIDAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createRuleID_ColonColonKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("RuleID_ColonColonKeyword_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleIDAccess().getColonColonKeyword_1_0());
		}
		public static IGrammarAwareElementType createRuleID_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("RuleID_IDTerminalRuleCall_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleIDAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType RuleID_ELEMENT_TYPE = associate(RuleIDFactory.createRuleIDElementType());

	public static final IGrammarAwareElementType RuleID_Group_ELEMENT_TYPE = associate(RuleIDFactory.createRuleID_GroupElementType());

	public static final IGrammarAwareElementType RuleID_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(RuleIDFactory.createRuleID_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType RuleID_Group_1_ELEMENT_TYPE = associate(RuleIDFactory.createRuleID_Group_1ElementType());

	public static final IGrammarAwareElementType RuleID_ColonColonKeyword_1_0_ELEMENT_TYPE = associate(RuleIDFactory.createRuleID_ColonColonKeyword_1_0ElementType());

	public static final IGrammarAwareElementType RuleID_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(RuleIDFactory.createRuleID_IDTerminalRuleCall_1_1ElementType());

	private static class PredicatedKeywordFactory {
		public static IGrammarAwareElementType createPredicatedKeywordElementType() {
			return new IGrammarAwareElementType("PredicatedKeyword_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedKeywordRule());
		}
		public static IGrammarAwareElementType createPredicatedKeyword_GroupElementType() {
			return new IGrammarAwareElementType("PredicatedKeyword_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedKeywordAccess().getGroup());
		}
		public static IGrammarAwareElementType createPredicatedKeyword_PredicateParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PredicatedKeyword_PredicateParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedKeywordAccess().getPredicateParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPredicatedKeyword_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("PredicatedKeyword_ValueAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedKeywordAccess().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createPredicatedKeyword_ValueSTRINGTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("PredicatedKeyword_ValueSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType PredicatedKeyword_ELEMENT_TYPE = associate(PredicatedKeywordFactory.createPredicatedKeywordElementType());

	public static final IGrammarAwareElementType PredicatedKeyword_Group_ELEMENT_TYPE = associate(PredicatedKeywordFactory.createPredicatedKeyword_GroupElementType());

	public static final IGrammarAwareElementType PredicatedKeyword_PredicateParserRuleCall_0_ELEMENT_TYPE = associate(PredicatedKeywordFactory.createPredicatedKeyword_PredicateParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType PredicatedKeyword_ValueAssignment_1_ELEMENT_TYPE = associate(PredicatedKeywordFactory.createPredicatedKeyword_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType PredicatedKeyword_ValueSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE = associate(PredicatedKeywordFactory.createPredicatedKeyword_ValueSTRINGTerminalRuleCall_1_0ElementType());

	private static class PredicatedRuleCallFactory {
		public static IGrammarAwareElementType createPredicatedRuleCallElementType() {
			return new IGrammarAwareElementType("PredicatedRuleCall_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedRuleCallRule());
		}
		public static IGrammarAwareElementType createPredicatedRuleCall_GroupElementType() {
			return new IGrammarAwareElementType("PredicatedRuleCall_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedRuleCallAccess().getGroup());
		}
		public static IGrammarAwareElementType createPredicatedRuleCall_PredicateParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PredicatedRuleCall_PredicateParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedRuleCallAccess().getPredicateParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPredicatedRuleCall_RuleAssignment_1ElementType() {
			return new IGrammarAwareElementType("PredicatedRuleCall_RuleAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedRuleCallAccess().getRuleAssignment_1());
		}
		public static IGrammarAwareElementType createPredicatedRuleCall_RuleAbstractRuleCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("PredicatedRuleCall_RuleAbstractRuleCrossReference_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0());
		}
		public static IGrammarAwareElementType createPredicatedRuleCall_RuleAbstractRuleIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("PredicatedRuleCall_RuleAbstractRuleIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_1_0_1());
		}
	}

	public static final IGrammarAwareElementType PredicatedRuleCall_ELEMENT_TYPE = associate(PredicatedRuleCallFactory.createPredicatedRuleCallElementType());

	public static final IGrammarAwareElementType PredicatedRuleCall_Group_ELEMENT_TYPE = associate(PredicatedRuleCallFactory.createPredicatedRuleCall_GroupElementType());

	public static final IGrammarAwareElementType PredicatedRuleCall_PredicateParserRuleCall_0_ELEMENT_TYPE = associate(PredicatedRuleCallFactory.createPredicatedRuleCall_PredicateParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType PredicatedRuleCall_RuleAssignment_1_ELEMENT_TYPE = associate(PredicatedRuleCallFactory.createPredicatedRuleCall_RuleAssignment_1ElementType());

	public static final IGrammarAwareElementType PredicatedRuleCall_RuleAbstractRuleCrossReference_1_0_ELEMENT_TYPE = associate(PredicatedRuleCallFactory.createPredicatedRuleCall_RuleAbstractRuleCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType PredicatedRuleCall_RuleAbstractRuleIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(PredicatedRuleCallFactory.createPredicatedRuleCall_RuleAbstractRuleIDTerminalRuleCall_1_0_1ElementType());

	private static class AssignmentFactory {
		public static IGrammarAwareElementType createAssignmentElementType() {
			return new IGrammarAwareElementType("Assignment_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentRule());
		}
		public static IGrammarAwareElementType createAssignment_GroupElementType() {
			return new IGrammarAwareElementType("Assignment_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getGroup());
		}
		public static IGrammarAwareElementType createAssignment_PredicateParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Assignment_PredicateParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getPredicateParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAssignment_FeatureAssignment_1ElementType() {
			return new IGrammarAwareElementType("Assignment_FeatureAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getFeatureAssignment_1());
		}
		public static IGrammarAwareElementType createAssignment_FeatureIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Assignment_FeatureIDTerminalRuleCall_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getFeatureIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createAssignment_OperatorAssignment_2ElementType() {
			return new IGrammarAwareElementType("Assignment_OperatorAssignment_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getOperatorAssignment_2());
		}
		public static IGrammarAwareElementType createAssignment_OperatorAlternatives_2_0ElementType() {
			return new IGrammarAwareElementType("Assignment_OperatorAlternatives_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getOperatorAlternatives_2_0());
		}
		public static IGrammarAwareElementType createAssignment_OperatorPlusSignEqualsSignKeyword_2_0_0ElementType() {
			return new IGrammarAwareElementType("Assignment_OperatorPlusSignEqualsSignKeyword_2_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0());
		}
		public static IGrammarAwareElementType createAssignment_OperatorEqualsSignKeyword_2_0_1ElementType() {
			return new IGrammarAwareElementType("Assignment_OperatorEqualsSignKeyword_2_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1());
		}
		public static IGrammarAwareElementType createAssignment_OperatorQuestionMarkEqualsSignKeyword_2_0_2ElementType() {
			return new IGrammarAwareElementType("Assignment_OperatorQuestionMarkEqualsSignKeyword_2_0_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2());
		}
		public static IGrammarAwareElementType createAssignment_TerminalAssignment_3ElementType() {
			return new IGrammarAwareElementType("Assignment_TerminalAssignment_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getTerminalAssignment_3());
		}
		public static IGrammarAwareElementType createAssignment_TerminalAssignableTerminalParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Assignment_TerminalAssignableTerminalParserRuleCall_3_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType Assignment_ELEMENT_TYPE = associate(AssignmentFactory.createAssignmentElementType());

	public static final IGrammarAwareElementType Assignment_Group_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_GroupElementType());

	public static final IGrammarAwareElementType Assignment_PredicateParserRuleCall_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_PredicateParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Assignment_FeatureAssignment_1_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_FeatureAssignment_1ElementType());

	public static final IGrammarAwareElementType Assignment_FeatureIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_FeatureIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Assignment_OperatorAssignment_2_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_OperatorAssignment_2ElementType());

	public static final IGrammarAwareElementType Assignment_OperatorAlternatives_2_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_OperatorAlternatives_2_0ElementType());

	public static final IGrammarAwareElementType Assignment_OperatorPlusSignEqualsSignKeyword_2_0_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_OperatorPlusSignEqualsSignKeyword_2_0_0ElementType());

	public static final IGrammarAwareElementType Assignment_OperatorEqualsSignKeyword_2_0_1_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_OperatorEqualsSignKeyword_2_0_1ElementType());

	public static final IGrammarAwareElementType Assignment_OperatorQuestionMarkEqualsSignKeyword_2_0_2_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_OperatorQuestionMarkEqualsSignKeyword_2_0_2ElementType());

	public static final IGrammarAwareElementType Assignment_TerminalAssignment_3_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_TerminalAssignment_3ElementType());

	public static final IGrammarAwareElementType Assignment_TerminalAssignableTerminalParserRuleCall_3_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_TerminalAssignableTerminalParserRuleCall_3_0ElementType());

	private static class PredicateFactory {
		public static IGrammarAwareElementType createPredicateElementType() {
			return new IGrammarAwareElementType("Predicate_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicateRule());
		}
		public static IGrammarAwareElementType createPredicate_AlternativesElementType() {
			return new IGrammarAwareElementType("Predicate_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicateAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createPredicate_PredicatedAssignment_0ElementType() {
			return new IGrammarAwareElementType("Predicate_PredicatedAssignment_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicateAccess().getPredicatedAssignment_0());
		}
		public static IGrammarAwareElementType createPredicate_PredicatedEqualsSignGreaterThanSignKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Predicate_PredicatedEqualsSignGreaterThanSignKeyword_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicateAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0());
		}
		public static IGrammarAwareElementType createPredicate_FirstSetPredicatedAssignment_1ElementType() {
			return new IGrammarAwareElementType("Predicate_FirstSetPredicatedAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicateAccess().getFirstSetPredicatedAssignment_1());
		}
		public static IGrammarAwareElementType createPredicate_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Predicate_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicateAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0());
		}
	}

	public static final IGrammarAwareElementType Predicate_ELEMENT_TYPE = associate(PredicateFactory.createPredicateElementType());

	public static final IGrammarAwareElementType Predicate_Alternatives_ELEMENT_TYPE = associate(PredicateFactory.createPredicate_AlternativesElementType());

	public static final IGrammarAwareElementType Predicate_PredicatedAssignment_0_ELEMENT_TYPE = associate(PredicateFactory.createPredicate_PredicatedAssignment_0ElementType());

	public static final IGrammarAwareElementType Predicate_PredicatedEqualsSignGreaterThanSignKeyword_0_0_ELEMENT_TYPE = associate(PredicateFactory.createPredicate_PredicatedEqualsSignGreaterThanSignKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Predicate_FirstSetPredicatedAssignment_1_ELEMENT_TYPE = associate(PredicateFactory.createPredicate_FirstSetPredicatedAssignment_1ElementType());

	public static final IGrammarAwareElementType Predicate_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0_ELEMENT_TYPE = associate(PredicateFactory.createPredicate_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0ElementType());

	private static class AssignableTerminalFactory {
		public static IGrammarAwareElementType createAssignableTerminalElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalRule());
		}
		public static IGrammarAwareElementType createAssignableTerminal_AlternativesElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAssignableTerminal_KeywordParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalAccess().getKeywordParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAssignableTerminal_RuleCallParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalAccess().getRuleCallParserRuleCall_1());
		}
		public static IGrammarAwareElementType createAssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2());
		}
		public static IGrammarAwareElementType createAssignableTerminal_CrossReferenceParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_CrossReferenceParserRuleCall_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3());
		}
	}

	public static final IGrammarAwareElementType AssignableTerminal_ELEMENT_TYPE = associate(AssignableTerminalFactory.createAssignableTerminalElementType());

	public static final IGrammarAwareElementType AssignableTerminal_Alternatives_ELEMENT_TYPE = associate(AssignableTerminalFactory.createAssignableTerminal_AlternativesElementType());

	public static final IGrammarAwareElementType AssignableTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE = associate(AssignableTerminalFactory.createAssignableTerminal_KeywordParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AssignableTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE = associate(AssignableTerminalFactory.createAssignableTerminal_RuleCallParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType AssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2_ELEMENT_TYPE = associate(AssignableTerminalFactory.createAssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType AssignableTerminal_CrossReferenceParserRuleCall_3_ELEMENT_TYPE = associate(AssignableTerminalFactory.createAssignableTerminal_CrossReferenceParserRuleCall_3ElementType());

	private static class ParenthesizedAssignableElementFactory {
		public static IGrammarAwareElementType createParenthesizedAssignableElementElementType() {
			return new IGrammarAwareElementType("ParenthesizedAssignableElement_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAssignableElementRule());
		}
		public static IGrammarAwareElementType createParenthesizedAssignableElement_GroupElementType() {
			return new IGrammarAwareElementType("ParenthesizedAssignableElement_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAssignableElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("ParenthesizedAssignableElement_LeftParenthesisKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParenthesizedAssignableElement_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("ParenthesizedAssignableElement_RightParenthesisKeyword_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2());
		}
	}

	public static final IGrammarAwareElementType ParenthesizedAssignableElement_ELEMENT_TYPE = associate(ParenthesizedAssignableElementFactory.createParenthesizedAssignableElementElementType());

	public static final IGrammarAwareElementType ParenthesizedAssignableElement_Group_ELEMENT_TYPE = associate(ParenthesizedAssignableElementFactory.createParenthesizedAssignableElement_GroupElementType());

	public static final IGrammarAwareElementType ParenthesizedAssignableElement_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParenthesizedAssignableElementFactory.createParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType ParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1_ELEMENT_TYPE = associate(ParenthesizedAssignableElementFactory.createParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType ParenthesizedAssignableElement_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParenthesizedAssignableElementFactory.createParenthesizedAssignableElement_RightParenthesisKeyword_2ElementType());

	private static class AssignableAlternativesFactory {
		public static IGrammarAwareElementType createAssignableAlternativesElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesRule());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_GroupElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getGroup());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_AssignableTerminalParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_Group_1ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_AlternativesElementsAction_1_0ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_AlternativesElementsAction_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_Group_1_1ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_Group_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_ElementsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_ElementsAssignment_1_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getElementsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_ElementsAssignableTerminalParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_ElementsAssignableTerminalParserRuleCall_1_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType AssignableAlternatives_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternativesElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_Group_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_GroupElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_AssignableTerminalParserRuleCall_0_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_Group_1_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_Group_1ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_AlternativesElementsAction_1_0_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_AlternativesElementsAction_1_0ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_Group_1_1_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_Group_1_1ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_ElementsAssignment_1_1_1_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_ElementsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_ElementsAssignableTerminalParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_ElementsAssignableTerminalParserRuleCall_1_1_1_0ElementType());

	private static class CrossReferenceFactory {
		public static IGrammarAwareElementType createCrossReferenceElementType() {
			return new IGrammarAwareElementType("CrossReference_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceRule());
		}
		public static IGrammarAwareElementType createCrossReference_GroupElementType() {
			return new IGrammarAwareElementType("CrossReference_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getGroup());
		}
		public static IGrammarAwareElementType createCrossReference_LeftSquareBracketKeyword_0ElementType() {
			return new IGrammarAwareElementType("CrossReference_LeftSquareBracketKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getLeftSquareBracketKeyword_0());
		}
		public static IGrammarAwareElementType createCrossReference_TypeAssignment_1ElementType() {
			return new IGrammarAwareElementType("CrossReference_TypeAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getTypeAssignment_1());
		}
		public static IGrammarAwareElementType createCrossReference_TypeTypeRefParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("CrossReference_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createCrossReference_Group_2ElementType() {
			return new IGrammarAwareElementType("CrossReference_Group_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createCrossReference_VerticalLineKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("CrossReference_VerticalLineKeyword_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getVerticalLineKeyword_2_0());
		}
		public static IGrammarAwareElementType createCrossReference_TerminalAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("CrossReference_TerminalAssignment_2_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getTerminalAssignment_2_1());
		}
		public static IGrammarAwareElementType createCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("CrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createCrossReference_RightSquareBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("CrossReference_RightSquareBracketKeyword_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getRightSquareBracketKeyword_3());
		}
	}

	public static final IGrammarAwareElementType CrossReference_ELEMENT_TYPE = associate(CrossReferenceFactory.createCrossReferenceElementType());

	public static final IGrammarAwareElementType CrossReference_Group_ELEMENT_TYPE = associate(CrossReferenceFactory.createCrossReference_GroupElementType());

	public static final IGrammarAwareElementType CrossReference_LeftSquareBracketKeyword_0_ELEMENT_TYPE = associate(CrossReferenceFactory.createCrossReference_LeftSquareBracketKeyword_0ElementType());

	public static final IGrammarAwareElementType CrossReference_TypeAssignment_1_ELEMENT_TYPE = associate(CrossReferenceFactory.createCrossReference_TypeAssignment_1ElementType());

	public static final IGrammarAwareElementType CrossReference_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE = associate(CrossReferenceFactory.createCrossReference_TypeTypeRefParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType CrossReference_Group_2_ELEMENT_TYPE = associate(CrossReferenceFactory.createCrossReference_Group_2ElementType());

	public static final IGrammarAwareElementType CrossReference_VerticalLineKeyword_2_0_ELEMENT_TYPE = associate(CrossReferenceFactory.createCrossReference_VerticalLineKeyword_2_0ElementType());

	public static final IGrammarAwareElementType CrossReference_TerminalAssignment_2_1_ELEMENT_TYPE = associate(CrossReferenceFactory.createCrossReference_TerminalAssignment_2_1ElementType());

	public static final IGrammarAwareElementType CrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0_ELEMENT_TYPE = associate(CrossReferenceFactory.createCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType CrossReference_RightSquareBracketKeyword_3_ELEMENT_TYPE = associate(CrossReferenceFactory.createCrossReference_RightSquareBracketKeyword_3ElementType());

	private static class CrossReferenceableTerminalFactory {
		public static IGrammarAwareElementType createCrossReferenceableTerminalElementType() {
			return new IGrammarAwareElementType("CrossReferenceableTerminal_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceableTerminalRule());
		}
		public static IGrammarAwareElementType createCrossReferenceableTerminal_AlternativesElementType() {
			return new IGrammarAwareElementType("CrossReferenceableTerminal_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceableTerminalAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("CrossReferenceableTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0());
		}
		public static IGrammarAwareElementType createCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("CrossReferenceableTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType CrossReferenceableTerminal_ELEMENT_TYPE = associate(CrossReferenceableTerminalFactory.createCrossReferenceableTerminalElementType());

	public static final IGrammarAwareElementType CrossReferenceableTerminal_Alternatives_ELEMENT_TYPE = associate(CrossReferenceableTerminalFactory.createCrossReferenceableTerminal_AlternativesElementType());

	public static final IGrammarAwareElementType CrossReferenceableTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE = associate(CrossReferenceableTerminalFactory.createCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType CrossReferenceableTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE = associate(CrossReferenceableTerminalFactory.createCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType());

	private static class ParenthesizedElementFactory {
		public static IGrammarAwareElementType createParenthesizedElementElementType() {
			return new IGrammarAwareElementType("ParenthesizedElement_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedElementRule());
		}
		public static IGrammarAwareElementType createParenthesizedElement_GroupElementType() {
			return new IGrammarAwareElementType("ParenthesizedElement_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createParenthesizedElement_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("ParenthesizedElement_LeftParenthesisKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParenthesizedElement_AlternativesParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ParenthesizedElement_AlternativesParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedElementAccess().getAlternativesParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParenthesizedElement_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("ParenthesizedElement_RightParenthesisKeyword_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedElementAccess().getRightParenthesisKeyword_2());
		}
	}

	public static final IGrammarAwareElementType ParenthesizedElement_ELEMENT_TYPE = associate(ParenthesizedElementFactory.createParenthesizedElementElementType());

	public static final IGrammarAwareElementType ParenthesizedElement_Group_ELEMENT_TYPE = associate(ParenthesizedElementFactory.createParenthesizedElement_GroupElementType());

	public static final IGrammarAwareElementType ParenthesizedElement_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParenthesizedElementFactory.createParenthesizedElement_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType ParenthesizedElement_AlternativesParserRuleCall_1_ELEMENT_TYPE = associate(ParenthesizedElementFactory.createParenthesizedElement_AlternativesParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType ParenthesizedElement_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParenthesizedElementFactory.createParenthesizedElement_RightParenthesisKeyword_2ElementType());

	private static class PredicatedGroupFactory {
		public static IGrammarAwareElementType createPredicatedGroupElementType() {
			return new IGrammarAwareElementType("PredicatedGroup_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedGroupRule());
		}
		public static IGrammarAwareElementType createPredicatedGroup_GroupElementType() {
			return new IGrammarAwareElementType("PredicatedGroup_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedGroupAccess().getGroup());
		}
		public static IGrammarAwareElementType createPredicatedGroup_PredicateParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PredicatedGroup_PredicateParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedGroupAccess().getPredicateParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPredicatedGroup_LeftParenthesisKeyword_1ElementType() {
			return new IGrammarAwareElementType("PredicatedGroup_LeftParenthesisKeyword_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedGroupAccess().getLeftParenthesisKeyword_1());
		}
		public static IGrammarAwareElementType createPredicatedGroup_ElementsAssignment_2ElementType() {
			return new IGrammarAwareElementType("PredicatedGroup_ElementsAssignment_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedGroupAccess().getElementsAssignment_2());
		}
		public static IGrammarAwareElementType createPredicatedGroup_ElementsAlternativesParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("PredicatedGroup_ElementsAlternativesParserRuleCall_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createPredicatedGroup_RightParenthesisKeyword_3ElementType() {
			return new IGrammarAwareElementType("PredicatedGroup_RightParenthesisKeyword_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPredicatedGroupAccess().getRightParenthesisKeyword_3());
		}
	}

	public static final IGrammarAwareElementType PredicatedGroup_ELEMENT_TYPE = associate(PredicatedGroupFactory.createPredicatedGroupElementType());

	public static final IGrammarAwareElementType PredicatedGroup_Group_ELEMENT_TYPE = associate(PredicatedGroupFactory.createPredicatedGroup_GroupElementType());

	public static final IGrammarAwareElementType PredicatedGroup_PredicateParserRuleCall_0_ELEMENT_TYPE = associate(PredicatedGroupFactory.createPredicatedGroup_PredicateParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType PredicatedGroup_LeftParenthesisKeyword_1_ELEMENT_TYPE = associate(PredicatedGroupFactory.createPredicatedGroup_LeftParenthesisKeyword_1ElementType());

	public static final IGrammarAwareElementType PredicatedGroup_ElementsAssignment_2_ELEMENT_TYPE = associate(PredicatedGroupFactory.createPredicatedGroup_ElementsAssignment_2ElementType());

	public static final IGrammarAwareElementType PredicatedGroup_ElementsAlternativesParserRuleCall_2_0_ELEMENT_TYPE = associate(PredicatedGroupFactory.createPredicatedGroup_ElementsAlternativesParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType PredicatedGroup_RightParenthesisKeyword_3_ELEMENT_TYPE = associate(PredicatedGroupFactory.createPredicatedGroup_RightParenthesisKeyword_3ElementType());

	private static class TerminalRuleFactory {
		public static IGrammarAwareElementType createTerminalRuleElementType() {
			return new IGrammarAwareElementType("TerminalRule_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleRule());
		}
		public static IGrammarAwareElementType createTerminalRule_GroupElementType() {
			return new IGrammarAwareElementType("TerminalRule_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createTerminalRule_TerminalKeyword_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_TerminalKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getTerminalKeyword_0());
		}
		public static IGrammarAwareElementType createTerminalRule_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("TerminalRule_Alternatives_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createTerminalRule_Group_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_Group_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createTerminalRule_FragmentAssignment_1_0_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_FragmentAssignment_1_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getFragmentAssignment_1_0_0());
		}
		public static IGrammarAwareElementType createTerminalRule_FragmentFragmentKeyword_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_FragmentFragmentKeyword_1_0_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0());
		}
		public static IGrammarAwareElementType createTerminalRule_NameAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("TerminalRule_NameAssignment_1_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getNameAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createTerminalRule_NameIDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_NameIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createTerminalRule_Group_1_1ElementType() {
			return new IGrammarAwareElementType("TerminalRule_Group_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createTerminalRule_NameAssignment_1_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_NameAssignment_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getNameAssignment_1_1_0());
		}
		public static IGrammarAwareElementType createTerminalRule_NameIDTerminalRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_NameIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createTerminalRule_ReturnsClauseParserRuleCall_1_1_1ElementType() {
			return new IGrammarAwareElementType("TerminalRule_ReturnsClauseParserRuleCall_1_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getReturnsClauseParserRuleCall_1_1_1());
		}
		public static IGrammarAwareElementType createTerminalRule_ColonKeyword_2ElementType() {
			return new IGrammarAwareElementType("TerminalRule_ColonKeyword_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getColonKeyword_2());
		}
		public static IGrammarAwareElementType createTerminalRule_AlternativesAssignment_3ElementType() {
			return new IGrammarAwareElementType("TerminalRule_AlternativesAssignment_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getAlternativesAssignment_3());
		}
		public static IGrammarAwareElementType createTerminalRule_AlternativesTerminalAlternativesParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_AlternativesTerminalAlternativesParserRuleCall_3_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createTerminalRule_SemicolonKeyword_4ElementType() {
			return new IGrammarAwareElementType("TerminalRule_SemicolonKeyword_4_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getSemicolonKeyword_4());
		}
	}

	public static final IGrammarAwareElementType TerminalRule_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRuleElementType());

	public static final IGrammarAwareElementType TerminalRule_Group_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_GroupElementType());

	public static final IGrammarAwareElementType TerminalRule_TerminalKeyword_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_TerminalKeyword_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_Alternatives_1_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_Alternatives_1ElementType());

	public static final IGrammarAwareElementType TerminalRule_Group_1_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_Group_1_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_FragmentAssignment_1_0_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_FragmentAssignment_1_0_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_FragmentFragmentKeyword_1_0_0_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_FragmentFragmentKeyword_1_0_0_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_NameAssignment_1_0_1_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_NameAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType TerminalRule_NameIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_NameIDTerminalRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_Group_1_1_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_Group_1_1ElementType());

	public static final IGrammarAwareElementType TerminalRule_NameAssignment_1_1_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_NameAssignment_1_1_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_NameIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_NameIDTerminalRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_ReturnsClauseParserRuleCall_1_1_1_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_ReturnsClauseParserRuleCall_1_1_1ElementType());

	public static final IGrammarAwareElementType TerminalRule_ColonKeyword_2_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_ColonKeyword_2ElementType());

	public static final IGrammarAwareElementType TerminalRule_AlternativesAssignment_3_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_AlternativesAssignment_3ElementType());

	public static final IGrammarAwareElementType TerminalRule_AlternativesTerminalAlternativesParserRuleCall_3_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_AlternativesTerminalAlternativesParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_SemicolonKeyword_4_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_SemicolonKeyword_4ElementType());

	private static class TerminalAlternativesFactory {
		public static IGrammarAwareElementType createTerminalAlternativesElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesRule());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_GroupElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getGroup());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_TerminalGroupParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_Group_1ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_AlternativesElementsAction_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_AlternativesElementsAction_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_Group_1_1ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_Group_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_ElementsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_ElementsAssignment_1_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getElementsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_ElementsTerminalGroupParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_ElementsTerminalGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType TerminalAlternatives_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternativesElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_Group_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_GroupElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_TerminalGroupParserRuleCall_0_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_Group_1_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_Group_1ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_AlternativesElementsAction_1_0_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_AlternativesElementsAction_1_0ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_Group_1_1_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_Group_1_1ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_ElementsAssignment_1_1_1_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_ElementsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_ElementsTerminalGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_ElementsTerminalGroupParserRuleCall_1_1_1_0ElementType());

	private static class TerminalGroupFactory {
		public static IGrammarAwareElementType createTerminalGroupElementType() {
			return new IGrammarAwareElementType("TerminalGroup_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupRule());
		}
		public static IGrammarAwareElementType createTerminalGroup_GroupElementType() {
			return new IGrammarAwareElementType("TerminalGroup_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getGroup());
		}
		public static IGrammarAwareElementType createTerminalGroup_TerminalTokenParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("TerminalGroup_TerminalTokenParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerminalGroup_Group_1ElementType() {
			return new IGrammarAwareElementType("TerminalGroup_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createTerminalGroup_GroupElementsAction_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalGroup_GroupElementsAction_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getGroupElementsAction_1_0());
		}
		public static IGrammarAwareElementType createTerminalGroup_ElementsAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("TerminalGroup_ElementsAssignment_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getElementsAssignment_1_1());
		}
		public static IGrammarAwareElementType createTerminalGroup_ElementsTerminalTokenParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalGroup_ElementsTerminalTokenParserRuleCall_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType TerminalGroup_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroupElementType());

	public static final IGrammarAwareElementType TerminalGroup_Group_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_GroupElementType());

	public static final IGrammarAwareElementType TerminalGroup_TerminalTokenParserRuleCall_0_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_TerminalTokenParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType TerminalGroup_Group_1_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_Group_1ElementType());

	public static final IGrammarAwareElementType TerminalGroup_GroupElementsAction_1_0_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_GroupElementsAction_1_0ElementType());

	public static final IGrammarAwareElementType TerminalGroup_ElementsAssignment_1_1_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_ElementsAssignment_1_1ElementType());

	public static final IGrammarAwareElementType TerminalGroup_ElementsTerminalTokenParserRuleCall_1_1_0_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_ElementsTerminalTokenParserRuleCall_1_1_0ElementType());

	private static class TerminalTokenFactory {
		public static IGrammarAwareElementType createTerminalTokenElementType() {
			return new IGrammarAwareElementType("TerminalToken_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenRule());
		}
		public static IGrammarAwareElementType createTerminalToken_GroupElementType() {
			return new IGrammarAwareElementType("TerminalToken_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenAccess().getGroup());
		}
		public static IGrammarAwareElementType createTerminalToken_TerminalTokenElementParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("TerminalToken_TerminalTokenElementParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerminalToken_CardinalitiesParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("TerminalToken_CardinalitiesParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenAccess().getCardinalitiesParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType TerminalToken_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalTokenElementType());

	public static final IGrammarAwareElementType TerminalToken_Group_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalToken_GroupElementType());

	public static final IGrammarAwareElementType TerminalToken_TerminalTokenElementParserRuleCall_0_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalToken_TerminalTokenElementParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType TerminalToken_CardinalitiesParserRuleCall_1_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalToken_CardinalitiesParserRuleCall_1ElementType());

	private static class TerminalTokenElementFactory {
		public static IGrammarAwareElementType createTerminalTokenElementElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementRule());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_AlternativesElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_CharacterRangeParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_TerminalRuleCallParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_TerminalRuleCallParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_AbstractNegatedTokenParserRuleCall_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_WildcardParserRuleCall_4ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_WildcardParserRuleCall_4_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getWildcardParserRuleCall_4());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_EOFParserRuleCall_5ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_EOFParserRuleCall_5_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getEOFParserRuleCall_5());
		}
	}

	public static final IGrammarAwareElementType TerminalTokenElement_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElementElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_Alternatives_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_AlternativesElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_CharacterRangeParserRuleCall_0_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_TerminalRuleCallParserRuleCall_1_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_TerminalRuleCallParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_AbstractNegatedTokenParserRuleCall_3_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_WildcardParserRuleCall_4_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_WildcardParserRuleCall_4ElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_EOFParserRuleCall_5_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_EOFParserRuleCall_5ElementType());

	private static class ParenthesizedTerminalElementFactory {
		public static IGrammarAwareElementType createParenthesizedTerminalElementElementType() {
			return new IGrammarAwareElementType("ParenthesizedTerminalElement_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedTerminalElementRule());
		}
		public static IGrammarAwareElementType createParenthesizedTerminalElement_GroupElementType() {
			return new IGrammarAwareElementType("ParenthesizedTerminalElement_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedTerminalElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("ParenthesizedTerminalElement_LeftParenthesisKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParenthesizedTerminalElement_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("ParenthesizedTerminalElement_RightParenthesisKeyword_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2());
		}
	}

	public static final IGrammarAwareElementType ParenthesizedTerminalElement_ELEMENT_TYPE = associate(ParenthesizedTerminalElementFactory.createParenthesizedTerminalElementElementType());

	public static final IGrammarAwareElementType ParenthesizedTerminalElement_Group_ELEMENT_TYPE = associate(ParenthesizedTerminalElementFactory.createParenthesizedTerminalElement_GroupElementType());

	public static final IGrammarAwareElementType ParenthesizedTerminalElement_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParenthesizedTerminalElementFactory.createParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType ParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1_ELEMENT_TYPE = associate(ParenthesizedTerminalElementFactory.createParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType ParenthesizedTerminalElement_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParenthesizedTerminalElementFactory.createParenthesizedTerminalElement_RightParenthesisKeyword_2ElementType());

	private static class AbstractNegatedTokenFactory {
		public static IGrammarAwareElementType createAbstractNegatedTokenElementType() {
			return new IGrammarAwareElementType("AbstractNegatedToken_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractNegatedTokenRule());
		}
		public static IGrammarAwareElementType createAbstractNegatedToken_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractNegatedToken_Alternatives_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractNegatedTokenAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractNegatedToken_NegatedTokenParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractNegatedToken_UntilTokenParserRuleCall_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractNegatedToken_ELEMENT_TYPE = associate(AbstractNegatedTokenFactory.createAbstractNegatedTokenElementType());

	public static final IGrammarAwareElementType AbstractNegatedToken_Alternatives_ELEMENT_TYPE = associate(AbstractNegatedTokenFactory.createAbstractNegatedToken_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractNegatedToken_NegatedTokenParserRuleCall_0_ELEMENT_TYPE = associate(AbstractNegatedTokenFactory.createAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractNegatedToken_UntilTokenParserRuleCall_1_ELEMENT_TYPE = associate(AbstractNegatedTokenFactory.createAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType());

	private static class NegatedTokenFactory {
		public static IGrammarAwareElementType createNegatedTokenElementType() {
			return new IGrammarAwareElementType("NegatedToken_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNegatedTokenRule());
		}
		public static IGrammarAwareElementType createNegatedToken_GroupElementType() {
			return new IGrammarAwareElementType("NegatedToken_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNegatedTokenAccess().getGroup());
		}
		public static IGrammarAwareElementType createNegatedToken_ExclamationMarkKeyword_0ElementType() {
			return new IGrammarAwareElementType("NegatedToken_ExclamationMarkKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNegatedTokenAccess().getExclamationMarkKeyword_0());
		}
		public static IGrammarAwareElementType createNegatedToken_TerminalAssignment_1ElementType() {
			return new IGrammarAwareElementType("NegatedToken_TerminalAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNegatedTokenAccess().getTerminalAssignment_1());
		}
		public static IGrammarAwareElementType createNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType NegatedToken_ELEMENT_TYPE = associate(NegatedTokenFactory.createNegatedTokenElementType());

	public static final IGrammarAwareElementType NegatedToken_Group_ELEMENT_TYPE = associate(NegatedTokenFactory.createNegatedToken_GroupElementType());

	public static final IGrammarAwareElementType NegatedToken_ExclamationMarkKeyword_0_ELEMENT_TYPE = associate(NegatedTokenFactory.createNegatedToken_ExclamationMarkKeyword_0ElementType());

	public static final IGrammarAwareElementType NegatedToken_TerminalAssignment_1_ELEMENT_TYPE = associate(NegatedTokenFactory.createNegatedToken_TerminalAssignment_1ElementType());

	public static final IGrammarAwareElementType NegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0_ELEMENT_TYPE = associate(NegatedTokenFactory.createNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());

	private static class UntilTokenFactory {
		public static IGrammarAwareElementType createUntilTokenElementType() {
			return new IGrammarAwareElementType("UntilToken_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUntilTokenRule());
		}
		public static IGrammarAwareElementType createUntilToken_GroupElementType() {
			return new IGrammarAwareElementType("UntilToken_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUntilTokenAccess().getGroup());
		}
		public static IGrammarAwareElementType createUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("UntilToken_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0());
		}
		public static IGrammarAwareElementType createUntilToken_TerminalAssignment_1ElementType() {
			return new IGrammarAwareElementType("UntilToken_TerminalAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUntilTokenAccess().getTerminalAssignment_1());
		}
		public static IGrammarAwareElementType createUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("UntilToken_TerminalTerminalTokenElementParserRuleCall_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType UntilToken_ELEMENT_TYPE = associate(UntilTokenFactory.createUntilTokenElementType());

	public static final IGrammarAwareElementType UntilToken_Group_ELEMENT_TYPE = associate(UntilTokenFactory.createUntilToken_GroupElementType());

	public static final IGrammarAwareElementType UntilToken_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE = associate(UntilTokenFactory.createUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType());

	public static final IGrammarAwareElementType UntilToken_TerminalAssignment_1_ELEMENT_TYPE = associate(UntilTokenFactory.createUntilToken_TerminalAssignment_1ElementType());

	public static final IGrammarAwareElementType UntilToken_TerminalTerminalTokenElementParserRuleCall_1_0_ELEMENT_TYPE = associate(UntilTokenFactory.createUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());

	private static class WildcardFactory {
		public static IGrammarAwareElementType createWildcardElementType() {
			return new IGrammarAwareElementType("Wildcard_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWildcardRule());
		}
		public static IGrammarAwareElementType createWildcard_GroupElementType() {
			return new IGrammarAwareElementType("Wildcard_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWildcardAccess().getGroup());
		}
		public static IGrammarAwareElementType createWildcard_WildcardAction_0ElementType() {
			return new IGrammarAwareElementType("Wildcard_WildcardAction_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWildcardAccess().getWildcardAction_0());
		}
		public static IGrammarAwareElementType createWildcard_FullStopKeyword_1ElementType() {
			return new IGrammarAwareElementType("Wildcard_FullStopKeyword_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWildcardAccess().getFullStopKeyword_1());
		}
	}

	public static final IGrammarAwareElementType Wildcard_ELEMENT_TYPE = associate(WildcardFactory.createWildcardElementType());

	public static final IGrammarAwareElementType Wildcard_Group_ELEMENT_TYPE = associate(WildcardFactory.createWildcard_GroupElementType());

	public static final IGrammarAwareElementType Wildcard_WildcardAction_0_ELEMENT_TYPE = associate(WildcardFactory.createWildcard_WildcardAction_0ElementType());

	public static final IGrammarAwareElementType Wildcard_FullStopKeyword_1_ELEMENT_TYPE = associate(WildcardFactory.createWildcard_FullStopKeyword_1ElementType());

	private static class EOFFactory {
		public static IGrammarAwareElementType createEOFElementType() {
			return new IGrammarAwareElementType("EOF_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEOFRule());
		}
		public static IGrammarAwareElementType createEOF_GroupElementType() {
			return new IGrammarAwareElementType("EOF_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEOFAccess().getGroup());
		}
		public static IGrammarAwareElementType createEOF_EOFAction_0ElementType() {
			return new IGrammarAwareElementType("EOF_EOFAction_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEOFAccess().getEOFAction_0());
		}
		public static IGrammarAwareElementType createEOF_EOFKeyword_1ElementType() {
			return new IGrammarAwareElementType("EOF_EOFKeyword_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEOFAccess().getEOFKeyword_1());
		}
	}

	public static final IGrammarAwareElementType EOF_ELEMENT_TYPE = associate(EOFFactory.createEOFElementType());

	public static final IGrammarAwareElementType EOF_Group_ELEMENT_TYPE = associate(EOFFactory.createEOF_GroupElementType());

	public static final IGrammarAwareElementType EOF_EOFAction_0_ELEMENT_TYPE = associate(EOFFactory.createEOF_EOFAction_0ElementType());

	public static final IGrammarAwareElementType EOF_EOFKeyword_1_ELEMENT_TYPE = associate(EOFFactory.createEOF_EOFKeyword_1ElementType());

	private static class CharacterRangeFactory {
		public static IGrammarAwareElementType createCharacterRangeElementType() {
			return new IGrammarAwareElementType("CharacterRange_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeRule());
		}
		public static IGrammarAwareElementType createCharacterRange_GroupElementType() {
			return new IGrammarAwareElementType("CharacterRange_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getGroup());
		}
		public static IGrammarAwareElementType createCharacterRange_KeywordParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("CharacterRange_KeywordParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getKeywordParserRuleCall_0());
		}
		public static IGrammarAwareElementType createCharacterRange_Group_1ElementType() {
			return new IGrammarAwareElementType("CharacterRange_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createCharacterRange_CharacterRangeLeftAction_1_0ElementType() {
			return new IGrammarAwareElementType("CharacterRange_CharacterRangeLeftAction_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0());
		}
		public static IGrammarAwareElementType createCharacterRange_FullStopFullStopKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("CharacterRange_FullStopFullStopKeyword_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1());
		}
		public static IGrammarAwareElementType createCharacterRange_RightAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("CharacterRange_RightAssignment_1_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getRightAssignment_1_2());
		}
		public static IGrammarAwareElementType createCharacterRange_RightKeywordParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("CharacterRange_RightKeywordParserRuleCall_1_2_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType CharacterRange_ELEMENT_TYPE = associate(CharacterRangeFactory.createCharacterRangeElementType());

	public static final IGrammarAwareElementType CharacterRange_Group_ELEMENT_TYPE = associate(CharacterRangeFactory.createCharacterRange_GroupElementType());

	public static final IGrammarAwareElementType CharacterRange_KeywordParserRuleCall_0_ELEMENT_TYPE = associate(CharacterRangeFactory.createCharacterRange_KeywordParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType CharacterRange_Group_1_ELEMENT_TYPE = associate(CharacterRangeFactory.createCharacterRange_Group_1ElementType());

	public static final IGrammarAwareElementType CharacterRange_CharacterRangeLeftAction_1_0_ELEMENT_TYPE = associate(CharacterRangeFactory.createCharacterRange_CharacterRangeLeftAction_1_0ElementType());

	public static final IGrammarAwareElementType CharacterRange_FullStopFullStopKeyword_1_1_ELEMENT_TYPE = associate(CharacterRangeFactory.createCharacterRange_FullStopFullStopKeyword_1_1ElementType());

	public static final IGrammarAwareElementType CharacterRange_RightAssignment_1_2_ELEMENT_TYPE = associate(CharacterRangeFactory.createCharacterRange_RightAssignment_1_2ElementType());

	public static final IGrammarAwareElementType CharacterRange_RightKeywordParserRuleCall_1_2_0_ELEMENT_TYPE = associate(CharacterRangeFactory.createCharacterRange_RightKeywordParserRuleCall_1_2_0ElementType());

	private static class EnumRuleFactory {
		public static IGrammarAwareElementType createEnumRuleElementType() {
			return new IGrammarAwareElementType("EnumRule_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleRule());
		}
		public static IGrammarAwareElementType createEnumRule_GroupElementType() {
			return new IGrammarAwareElementType("EnumRule_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createEnumRule_EnumKeyword_0ElementType() {
			return new IGrammarAwareElementType("EnumRule_EnumKeyword_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getEnumKeyword_0());
		}
		public static IGrammarAwareElementType createEnumRule_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("EnumRule_NameAssignment_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createEnumRule_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("EnumRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createEnumRule_ReturnsClauseParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("EnumRule_ReturnsClauseParserRuleCall_2_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getReturnsClauseParserRuleCall_2());
		}
		public static IGrammarAwareElementType createEnumRule_ColonKeyword_3ElementType() {
			return new IGrammarAwareElementType("EnumRule_ColonKeyword_3_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getColonKeyword_3());
		}
		public static IGrammarAwareElementType createEnumRule_AlternativesAssignment_4ElementType() {
			return new IGrammarAwareElementType("EnumRule_AlternativesAssignment_4_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getAlternativesAssignment_4());
		}
		public static IGrammarAwareElementType createEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("EnumRule_AlternativesEnumLiteralsParserRuleCall_4_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createEnumRule_SemicolonKeyword_5ElementType() {
			return new IGrammarAwareElementType("EnumRule_SemicolonKeyword_5_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getSemicolonKeyword_5());
		}
	}

	public static final IGrammarAwareElementType EnumRule_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRuleElementType());

	public static final IGrammarAwareElementType EnumRule_Group_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_GroupElementType());

	public static final IGrammarAwareElementType EnumRule_EnumKeyword_0_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_EnumKeyword_0ElementType());

	public static final IGrammarAwareElementType EnumRule_NameAssignment_1_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType EnumRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType EnumRule_ReturnsClauseParserRuleCall_2_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_ReturnsClauseParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType EnumRule_ColonKeyword_3_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_ColonKeyword_3ElementType());

	public static final IGrammarAwareElementType EnumRule_AlternativesAssignment_4_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_AlternativesAssignment_4ElementType());

	public static final IGrammarAwareElementType EnumRule_AlternativesEnumLiteralsParserRuleCall_4_0_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType EnumRule_SemicolonKeyword_5_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_SemicolonKeyword_5ElementType());

	private static class EnumLiteralsFactory {
		public static IGrammarAwareElementType createEnumLiteralsElementType() {
			return new IGrammarAwareElementType("EnumLiterals_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsRule());
		}
		public static IGrammarAwareElementType createEnumLiterals_GroupElementType() {
			return new IGrammarAwareElementType("EnumLiterals_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getGroup());
		}
		public static IGrammarAwareElementType createEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_EnumLiteralDeclarationParserRuleCall_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0());
		}
		public static IGrammarAwareElementType createEnumLiterals_Group_1ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createEnumLiterals_AlternativesElementsAction_1_0ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_AlternativesElementsAction_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getAlternativesElementsAction_1_0());
		}
		public static IGrammarAwareElementType createEnumLiterals_Group_1_1ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_Group_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createEnumLiterals_VerticalLineKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_VerticalLineKeyword_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createEnumLiterals_ElementsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_ElementsAssignment_1_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getElementsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createEnumLiterals_ElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_ElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType EnumLiterals_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiteralsElementType());

	public static final IGrammarAwareElementType EnumLiterals_Group_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_GroupElementType());

	public static final IGrammarAwareElementType EnumLiterals_EnumLiteralDeclarationParserRuleCall_0_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType EnumLiterals_Group_1_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_Group_1ElementType());

	public static final IGrammarAwareElementType EnumLiterals_AlternativesElementsAction_1_0_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_AlternativesElementsAction_1_0ElementType());

	public static final IGrammarAwareElementType EnumLiterals_Group_1_1_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_Group_1_1ElementType());

	public static final IGrammarAwareElementType EnumLiterals_VerticalLineKeyword_1_1_0_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_VerticalLineKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType EnumLiterals_ElementsAssignment_1_1_1_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_ElementsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType EnumLiterals_ElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_ElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType());

	private static class EnumLiteralDeclarationFactory {
		public static IGrammarAwareElementType createEnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationRule());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_GroupElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_Group_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getGroup());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_EnumLiteralAssignment_0ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_EnumLiteralAssignment_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_EnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_EnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_Group_1ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_Group_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_EqualsSignKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_EqualsSignKeyword_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_LiteralAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_LiteralAssignment_1_1_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0_ELEMENT_TYPE", XtextGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType EnumLiteralDeclaration_ELEMENT_TYPE = associate(EnumLiteralDeclarationFactory.createEnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType EnumLiteralDeclaration_Group_ELEMENT_TYPE = associate(EnumLiteralDeclarationFactory.createEnumLiteralDeclaration_GroupElementType());

	public static final IGrammarAwareElementType EnumLiteralDeclaration_EnumLiteralAssignment_0_ELEMENT_TYPE = associate(EnumLiteralDeclarationFactory.createEnumLiteralDeclaration_EnumLiteralAssignment_0ElementType());

	public static final IGrammarAwareElementType EnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0_ELEMENT_TYPE = associate(EnumLiteralDeclarationFactory.createEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType());

	public static final IGrammarAwareElementType EnumLiteralDeclaration_EnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1_ELEMENT_TYPE = associate(EnumLiteralDeclarationFactory.createEnumLiteralDeclaration_EnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1ElementType());

	public static final IGrammarAwareElementType EnumLiteralDeclaration_Group_1_ELEMENT_TYPE = associate(EnumLiteralDeclarationFactory.createEnumLiteralDeclaration_Group_1ElementType());

	public static final IGrammarAwareElementType EnumLiteralDeclaration_EqualsSignKeyword_1_0_ELEMENT_TYPE = associate(EnumLiteralDeclarationFactory.createEnumLiteralDeclaration_EqualsSignKeyword_1_0ElementType());

	public static final IGrammarAwareElementType EnumLiteralDeclaration_LiteralAssignment_1_1_ELEMENT_TYPE = associate(EnumLiteralDeclarationFactory.createEnumLiteralDeclaration_LiteralAssignment_1_1ElementType());

	public static final IGrammarAwareElementType EnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0_ELEMENT_TYPE = associate(EnumLiteralDeclarationFactory.createEnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getGrammarElementType() {
		return Grammar_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_GroupElementType() {
		return Grammar_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_GrammarKeyword_0ElementType() {
		return Grammar_GrammarKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_NameAssignment_1ElementType() {
		return Grammar_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_NameGrammarIDParserRuleCall_1_0ElementType() {
		return Grammar_NameGrammarIDParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_Group_2ElementType() {
		return Grammar_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_WithKeyword_2_0ElementType() {
		return Grammar_WithKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_UsedGrammarsAssignment_2_1ElementType() {
		return Grammar_UsedGrammarsAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_UsedGrammarsGrammarCrossReference_2_1_0ElementType() {
		return Grammar_UsedGrammarsGrammarCrossReference_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1ElementType() {
		return Grammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_Group_2_2ElementType() {
		return Grammar_Group_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_CommaKeyword_2_2_0ElementType() {
		return Grammar_CommaKeyword_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_UsedGrammarsAssignment_2_2_1ElementType() {
		return Grammar_UsedGrammarsAssignment_2_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_UsedGrammarsGrammarCrossReference_2_2_1_0ElementType() {
		return Grammar_UsedGrammarsGrammarCrossReference_2_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1ElementType() {
		return Grammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_HiddenClauseParserRuleCall_3ElementType() {
		return Grammar_HiddenClauseParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_MetamodelDeclarationsAssignment_4ElementType() {
		return Grammar_MetamodelDeclarationsAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType() {
		return Grammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_RulesAssignment_5ElementType() {
		return Grammar_RulesAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType() {
		return Grammar_RulesAbstractRuleParserRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClauseElementType() {
		return HiddenClause_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_GroupElementType() {
		return HiddenClause_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_DefinesHiddenTokensAssignment_0ElementType() {
		return HiddenClause_DefinesHiddenTokensAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_DefinesHiddenTokensHiddenKeyword_0_0ElementType() {
		return HiddenClause_DefinesHiddenTokensHiddenKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_LeftParenthesisKeyword_1ElementType() {
		return HiddenClause_LeftParenthesisKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_Group_2ElementType() {
		return HiddenClause_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_HiddenTokensAssignment_2_0ElementType() {
		return HiddenClause_HiddenTokensAssignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_HiddenTokensAbstractRuleCrossReference_2_0_0ElementType() {
		return HiddenClause_HiddenTokensAbstractRuleCrossReference_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_0_0_1ElementType() {
		return HiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_Group_2_1ElementType() {
		return HiddenClause_Group_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_CommaKeyword_2_1_0ElementType() {
		return HiddenClause_CommaKeyword_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_HiddenTokensAssignment_2_1_1ElementType() {
		return HiddenClause_HiddenTokensAssignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_HiddenTokensAbstractRuleCrossReference_2_1_1_0ElementType() {
		return HiddenClause_HiddenTokensAbstractRuleCrossReference_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_1_1_0_1ElementType() {
		return HiddenClause_HiddenTokensAbstractRuleIDTerminalRuleCall_2_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHiddenClause_RightParenthesisKeyword_3ElementType() {
		return HiddenClause_RightParenthesisKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammarIDElementType() {
		return GrammarID_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammarID_GroupElementType() {
		return GrammarID_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammarID_IDTerminalRuleCall_0ElementType() {
		return GrammarID_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammarID_Group_1ElementType() {
		return GrammarID_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammarID_FullStopKeyword_1_0ElementType() {
		return GrammarID_FullStopKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammarID_IDTerminalRuleCall_1_1ElementType() {
		return GrammarID_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractRuleElementType() {
		return AbstractRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractRule_AlternativesElementType() {
		return AbstractRule_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractRule_ParserRuleParserRuleCall_0ElementType() {
		return AbstractRule_ParserRuleParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractRule_TerminalRuleParserRuleCall_1ElementType() {
		return AbstractRule_TerminalRuleParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractRule_EnumRuleParserRuleCall_2ElementType() {
		return AbstractRule_EnumRuleParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMetamodelDeclarationElementType() {
		return AbstractMetamodelDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMetamodelDeclaration_AlternativesElementType() {
		return AbstractMetamodelDeclaration_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType() {
		return AbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType() {
		return AbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodelElementType() {
		return GeneratedMetamodel_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_GroupElementType() {
		return GeneratedMetamodel_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_GenerateKeyword_0ElementType() {
		return GeneratedMetamodel_GenerateKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_NameAssignment_1ElementType() {
		return GeneratedMetamodel_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_NameIDTerminalRuleCall_1_0ElementType() {
		return GeneratedMetamodel_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_EPackageAssignment_2ElementType() {
		return GeneratedMetamodel_EPackageAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_EPackageEPackageCrossReference_2_0ElementType() {
		return GeneratedMetamodel_EPackageEPackageCrossReference_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_2_0_1ElementType() {
		return GeneratedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_Group_3ElementType() {
		return GeneratedMetamodel_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_AsKeyword_3_0ElementType() {
		return GeneratedMetamodel_AsKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_AliasAssignment_3_1ElementType() {
		return GeneratedMetamodel_AliasAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0ElementType() {
		return GeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferencedMetamodelElementType() {
		return ReferencedMetamodel_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferencedMetamodel_GroupElementType() {
		return ReferencedMetamodel_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferencedMetamodel_ImportKeyword_0ElementType() {
		return ReferencedMetamodel_ImportKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferencedMetamodel_EPackageAssignment_1ElementType() {
		return ReferencedMetamodel_EPackageAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferencedMetamodel_EPackageEPackageCrossReference_1_0ElementType() {
		return ReferencedMetamodel_EPackageEPackageCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferencedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_1_0_1ElementType() {
		return ReferencedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferencedMetamodel_Group_2ElementType() {
		return ReferencedMetamodel_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferencedMetamodel_AsKeyword_2_0ElementType() {
		return ReferencedMetamodel_AsKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferencedMetamodel_AliasAssignment_2_1ElementType() {
		return ReferencedMetamodel_AliasAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0ElementType() {
		return ReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleElementType() {
		return ParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_GroupElementType() {
		return ParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_Alternatives_0ElementType() {
		return ParserRule_Alternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_Group_0_0ElementType() {
		return ParserRule_Group_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_FragmentAssignment_0_0_0ElementType() {
		return ParserRule_FragmentAssignment_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_FragmentFragmentKeyword_0_0_0_0ElementType() {
		return ParserRule_FragmentFragmentKeyword_0_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_RuleNameAndParamsParserRuleCall_0_0_1ElementType() {
		return ParserRule_RuleNameAndParamsParserRuleCall_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_Alternatives_0_0_2ElementType() {
		return ParserRule_Alternatives_0_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_WildcardAssignment_0_0_2_0ElementType() {
		return ParserRule_WildcardAssignment_0_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_WildcardAsteriskKeyword_0_0_2_0_0ElementType() {
		return ParserRule_WildcardAsteriskKeyword_0_0_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_ReturnsClauseParserRuleCall_0_0_2_1ElementType() {
		return ParserRule_ReturnsClauseParserRuleCall_0_0_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_Group_0_1ElementType() {
		return ParserRule_Group_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_RuleNameAndParamsParserRuleCall_0_1_0ElementType() {
		return ParserRule_RuleNameAndParamsParserRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_ReturnsClauseParserRuleCall_0_1_1ElementType() {
		return ParserRule_ReturnsClauseParserRuleCall_0_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_HiddenClauseParserRuleCall_1ElementType() {
		return ParserRule_HiddenClauseParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_ColonKeyword_2ElementType() {
		return ParserRule_ColonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_AlternativesAssignment_3ElementType() {
		return ParserRule_AlternativesAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_AlternativesAlternativesParserRuleCall_3_0ElementType() {
		return ParserRule_AlternativesAlternativesParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_SemicolonKeyword_4ElementType() {
		return ParserRule_SemicolonKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParamsElementType() {
		return RuleNameAndParams_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_GroupElementType() {
		return RuleNameAndParams_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_NameAssignment_0ElementType() {
		return RuleNameAndParams_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_NameIDTerminalRuleCall_0_0ElementType() {
		return RuleNameAndParams_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_Group_1ElementType() {
		return RuleNameAndParams_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_LeftSquareBracketKeyword_1_0ElementType() {
		return RuleNameAndParams_LeftSquareBracketKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_Group_1_1ElementType() {
		return RuleNameAndParams_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_ParametersAssignment_1_1_0ElementType() {
		return RuleNameAndParams_ParametersAssignment_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_ParametersParameterParserRuleCall_1_1_0_0ElementType() {
		return RuleNameAndParams_ParametersParameterParserRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_Group_1_1_1ElementType() {
		return RuleNameAndParams_Group_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_CommaKeyword_1_1_1_0ElementType() {
		return RuleNameAndParams_CommaKeyword_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_ParametersAssignment_1_1_1_1ElementType() {
		return RuleNameAndParams_ParametersAssignment_1_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_ParametersParameterParserRuleCall_1_1_1_1_0ElementType() {
		return RuleNameAndParams_ParametersParameterParserRuleCall_1_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleNameAndParams_RightSquareBracketKeyword_1_2ElementType() {
		return RuleNameAndParams_RightSquareBracketKeyword_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReturnsClauseElementType() {
		return ReturnsClause_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReturnsClause_GroupElementType() {
		return ReturnsClause_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReturnsClause_ReturnsKeyword_0ElementType() {
		return ReturnsClause_ReturnsKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReturnsClause_TypeAssignment_1ElementType() {
		return ReturnsClause_TypeAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReturnsClause_TypeTypeRefParserRuleCall_1_0ElementType() {
		return ReturnsClause_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterElementType() {
		return Parameter_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_NameAssignmentElementType() {
		return Parameter_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_NameIDTerminalRuleCall_0ElementType() {
		return Parameter_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeRefElementType() {
		return TypeRef_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeRef_GroupElementType() {
		return TypeRef_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeRef_Group_0ElementType() {
		return TypeRef_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeRef_MetamodelAssignment_0_0ElementType() {
		return TypeRef_MetamodelAssignment_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0ElementType() {
		return TypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeRef_MetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1ElementType() {
		return TypeRef_MetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeRef_ColonColonKeyword_0_1ElementType() {
		return TypeRef_ColonColonKeyword_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeRef_ClassifierAssignment_1ElementType() {
		return TypeRef_ClassifierAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeRef_ClassifierEClassifierCrossReference_1_0ElementType() {
		return TypeRef_ClassifierEClassifierCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeRef_ClassifierEClassifierIDTerminalRuleCall_1_0_1ElementType() {
		return TypeRef_ClassifierEClassifierIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternativesElementType() {
		return Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_GroupElementType() {
		return Alternatives_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_ConditionalBranchParserRuleCall_0ElementType() {
		return Alternatives_ConditionalBranchParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_Group_1ElementType() {
		return Alternatives_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_AlternativesElementsAction_1_0ElementType() {
		return Alternatives_AlternativesElementsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_Group_1_1ElementType() {
		return Alternatives_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_VerticalLineKeyword_1_1_0ElementType() {
		return Alternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_ElementsAssignment_1_1_1ElementType() {
		return Alternatives_ElementsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_ElementsConditionalBranchParserRuleCall_1_1_1_0ElementType() {
		return Alternatives_ElementsConditionalBranchParserRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranchElementType() {
		return ConditionalBranch_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_AlternativesElementType() {
		return ConditionalBranch_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_UnorderedGroupParserRuleCall_0ElementType() {
		return ConditionalBranch_UnorderedGroupParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_Group_1ElementType() {
		return ConditionalBranch_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_ConditionalBranchAction_1_0ElementType() {
		return ConditionalBranch_ConditionalBranchAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_LeftSquareBracketKeyword_1_1ElementType() {
		return ConditionalBranch_LeftSquareBracketKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_FilteredAssignment_1_2ElementType() {
		return ConditionalBranch_FilteredAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_FilteredInverseLiteralValueParserRuleCall_1_2_0ElementType() {
		return ConditionalBranch_FilteredInverseLiteralValueParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_ParameterAssignment_1_3ElementType() {
		return ConditionalBranch_ParameterAssignment_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_ParameterParameterCrossReference_1_3_0ElementType() {
		return ConditionalBranch_ParameterParameterCrossReference_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_ParameterParameterIDTerminalRuleCall_1_3_0_1ElementType() {
		return ConditionalBranch_ParameterParameterIDTerminalRuleCall_1_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_RightSquareBracketKeyword_1_4ElementType() {
		return ConditionalBranch_RightSquareBracketKeyword_1_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_GuardedElementAssignment_1_5ElementType() {
		return ConditionalBranch_GuardedElementAssignment_1_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConditionalBranch_GuardedElementUnorderedGroupParserRuleCall_1_5_0ElementType() {
		return ConditionalBranch_GuardedElementUnorderedGroupParserRuleCall_1_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroupElementType() {
		return UnorderedGroup_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_GroupElementType() {
		return UnorderedGroup_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_GroupParserRuleCall_0ElementType() {
		return UnorderedGroup_GroupParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_Group_1ElementType() {
		return UnorderedGroup_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_UnorderedGroupElementsAction_1_0ElementType() {
		return UnorderedGroup_UnorderedGroupElementsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_Group_1_1ElementType() {
		return UnorderedGroup_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_AmpersandKeyword_1_1_0ElementType() {
		return UnorderedGroup_AmpersandKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_ElementsAssignment_1_1_1ElementType() {
		return UnorderedGroup_ElementsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedGroup_ElementsGroupParserRuleCall_1_1_1_0ElementType() {
		return UnorderedGroup_ElementsGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroupElementType() {
		return Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroup_GroupElementType() {
		return Group_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroup_AbstractTokenParserRuleCall_0ElementType() {
		return Group_AbstractTokenParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroup_Group_1ElementType() {
		return Group_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroup_GroupElementsAction_1_0ElementType() {
		return Group_GroupElementsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroup_ElementsAssignment_1_1ElementType() {
		return Group_ElementsAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroup_ElementsAbstractTokenParserRuleCall_1_1_0ElementType() {
		return Group_ElementsAbstractTokenParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenElementType() {
		return AbstractToken_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractToken_AlternativesElementType() {
		return AbstractToken_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType() {
		return AbstractToken_AbstractTokenWithCardinalityParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractToken_ActionParserRuleCall_1ElementType() {
		return AbstractToken_ActionParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenWithCardinalityElementType() {
		return AbstractTokenWithCardinality_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenWithCardinality_GroupElementType() {
		return AbstractTokenWithCardinality_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenWithCardinality_Alternatives_0ElementType() {
		return AbstractTokenWithCardinality_Alternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType() {
		return AbstractTokenWithCardinality_AssignmentParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType() {
		return AbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenWithCardinality_CardinalitiesParserRuleCall_1ElementType() {
		return AbstractTokenWithCardinality_CardinalitiesParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCardinalitiesElementType() {
		return Cardinalities_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCardinalities_CardinalityAssignmentElementType() {
		return Cardinalities_CardinalityAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCardinalities_CardinalityAlternatives_0ElementType() {
		return Cardinalities_CardinalityAlternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCardinalities_CardinalityQuestionMarkKeyword_0_0ElementType() {
		return Cardinalities_CardinalityQuestionMarkKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCardinalities_CardinalityAsteriskKeyword_0_1ElementType() {
		return Cardinalities_CardinalityAsteriskKeyword_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCardinalities_CardinalityPlusSignKeyword_0_2ElementType() {
		return Cardinalities_CardinalityPlusSignKeyword_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionElementType() {
		return Action_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_GroupElementType() {
		return Action_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_LeftCurlyBracketKeyword_0ElementType() {
		return Action_LeftCurlyBracketKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_TypeAssignment_1ElementType() {
		return Action_TypeAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_TypeTypeRefParserRuleCall_1_0ElementType() {
		return Action_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_Group_2ElementType() {
		return Action_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_FullStopKeyword_2_0ElementType() {
		return Action_FullStopKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_FeatureAssignment_2_1ElementType() {
		return Action_FeatureAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_FeatureIDTerminalRuleCall_2_1_0ElementType() {
		return Action_FeatureIDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_OperatorAssignment_2_2ElementType() {
		return Action_OperatorAssignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_OperatorAlternatives_2_2_0ElementType() {
		return Action_OperatorAlternatives_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_OperatorEqualsSignKeyword_2_2_0_0ElementType() {
		return Action_OperatorEqualsSignKeyword_2_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_OperatorPlusSignEqualsSignKeyword_2_2_0_1ElementType() {
		return Action_OperatorPlusSignEqualsSignKeyword_2_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_CurrentKeyword_2_3ElementType() {
		return Action_CurrentKeyword_2_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction_RightCurlyBracketKeyword_3ElementType() {
		return Action_RightCurlyBracketKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTerminalElementType() {
		return AbstractTerminal_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTerminal_AlternativesElementType() {
		return AbstractTerminal_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTerminal_KeywordParserRuleCall_0ElementType() {
		return AbstractTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTerminal_RuleCallParserRuleCall_1ElementType() {
		return AbstractTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType() {
		return AbstractTerminal_ParenthesizedElementParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTerminal_PredicatedKeywordParserRuleCall_3ElementType() {
		return AbstractTerminal_PredicatedKeywordParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTerminal_PredicatedRuleCallParserRuleCall_4ElementType() {
		return AbstractTerminal_PredicatedRuleCallParserRuleCall_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTerminal_PredicatedGroupParserRuleCall_5ElementType() {
		return AbstractTerminal_PredicatedGroupParserRuleCall_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeywordElementType() {
		return Keyword_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeyword_ValueAssignmentElementType() {
		return Keyword_ValueAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKeyword_ValueSTRINGTerminalRuleCall_0ElementType() {
		return Keyword_ValueSTRINGTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallElementType() {
		return RuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_GroupElementType() {
		return RuleCall_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_RuleCallAction_0ElementType() {
		return RuleCall_RuleCallAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_RuleAssignment_1ElementType() {
		return RuleCall_RuleAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_RuleAbstractRuleCrossReference_1_0ElementType() {
		return RuleCall_RuleAbstractRuleCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_RuleAbstractRuleRuleIDParserRuleCall_1_0_1ElementType() {
		return RuleCall_RuleAbstractRuleRuleIDParserRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_Group_2ElementType() {
		return RuleCall_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_LeftSquareBracketKeyword_2_0ElementType() {
		return RuleCall_LeftSquareBracketKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_ArgumentsAssignment_2_1ElementType() {
		return RuleCall_ArgumentsAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_ArgumentsNamedArgumentParserRuleCall_2_1_0ElementType() {
		return RuleCall_ArgumentsNamedArgumentParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_Group_2_2ElementType() {
		return RuleCall_Group_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_CommaKeyword_2_2_0ElementType() {
		return RuleCall_CommaKeyword_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_ArgumentsAssignment_2_2_1ElementType() {
		return RuleCall_ArgumentsAssignment_2_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_ArgumentsNamedArgumentParserRuleCall_2_2_1_0ElementType() {
		return RuleCall_ArgumentsNamedArgumentParserRuleCall_2_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_RightSquareBracketKeyword_2_3ElementType() {
		return RuleCall_RightSquareBracketKeyword_2_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLiteralValueElementType() {
		return LiteralValue_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLiteralValue_AlternativesElementType() {
		return LiteralValue_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLiteralValue_ExclamationMarkKeyword_0ElementType() {
		return LiteralValue_ExclamationMarkKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLiteralValue_PlusSignKeyword_1ElementType() {
		return LiteralValue_PlusSignKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInverseLiteralValueElementType() {
		return InverseLiteralValue_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInverseLiteralValue_LiteralValueParserRuleCallElementType() {
		return InverseLiteralValue_LiteralValueParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgumentElementType() {
		return NamedArgument_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_GroupElementType() {
		return NamedArgument_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_NamedArgumentAction_0ElementType() {
		return NamedArgument_NamedArgumentAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_Alternatives_1ElementType() {
		return NamedArgument_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_Group_1_0ElementType() {
		return NamedArgument_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_LiteralValueAssignment_1_0_0ElementType() {
		return NamedArgument_LiteralValueAssignment_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_LiteralValueLiteralValueParserRuleCall_1_0_0_0ElementType() {
		return NamedArgument_LiteralValueLiteralValueParserRuleCall_1_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_ParameterAssignment_1_0_1ElementType() {
		return NamedArgument_ParameterAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_ParameterParameterCrossReference_1_0_1_0ElementType() {
		return NamedArgument_ParameterParameterCrossReference_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_ParameterParameterIDTerminalRuleCall_1_0_1_0_1ElementType() {
		return NamedArgument_ParameterParameterIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_Group_1_1ElementType() {
		return NamedArgument_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_ParameterAssignment_1_1_0ElementType() {
		return NamedArgument_ParameterAssignment_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_ParameterParameterCrossReference_1_1_0_0ElementType() {
		return NamedArgument_ParameterParameterCrossReference_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_ParameterParameterIDTerminalRuleCall_1_1_0_0_1ElementType() {
		return NamedArgument_ParameterParameterIDTerminalRuleCall_1_1_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_EqualsSignKeyword_1_1_1ElementType() {
		return NamedArgument_EqualsSignKeyword_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_ValueAssignment_1_1_2ElementType() {
		return NamedArgument_ValueAssignment_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_ValueParameterCrossReference_1_1_2_0ElementType() {
		return NamedArgument_ValueParameterCrossReference_1_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedArgument_ValueParameterIDTerminalRuleCall_1_1_2_0_1ElementType() {
		return NamedArgument_ValueParameterIDTerminalRuleCall_1_1_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRuleCallElementType() {
		return TerminalRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRuleCall_RuleAssignmentElementType() {
		return TerminalRuleCall_RuleAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRuleCall_RuleAbstractRuleCrossReference_0ElementType() {
		return TerminalRuleCall_RuleAbstractRuleCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRuleCall_RuleAbstractRuleRuleIDParserRuleCall_0_1ElementType() {
		return TerminalRuleCall_RuleAbstractRuleRuleIDParserRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleIDElementType() {
		return RuleID_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleID_GroupElementType() {
		return RuleID_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleID_IDTerminalRuleCall_0ElementType() {
		return RuleID_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleID_Group_1ElementType() {
		return RuleID_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleID_ColonColonKeyword_1_0ElementType() {
		return RuleID_ColonColonKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleID_IDTerminalRuleCall_1_1ElementType() {
		return RuleID_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedKeywordElementType() {
		return PredicatedKeyword_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedKeyword_GroupElementType() {
		return PredicatedKeyword_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedKeyword_PredicateParserRuleCall_0ElementType() {
		return PredicatedKeyword_PredicateParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedKeyword_ValueAssignment_1ElementType() {
		return PredicatedKeyword_ValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedKeyword_ValueSTRINGTerminalRuleCall_1_0ElementType() {
		return PredicatedKeyword_ValueSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedRuleCallElementType() {
		return PredicatedRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedRuleCall_GroupElementType() {
		return PredicatedRuleCall_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedRuleCall_PredicateParserRuleCall_0ElementType() {
		return PredicatedRuleCall_PredicateParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedRuleCall_RuleAssignment_1ElementType() {
		return PredicatedRuleCall_RuleAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedRuleCall_RuleAbstractRuleCrossReference_1_0ElementType() {
		return PredicatedRuleCall_RuleAbstractRuleCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedRuleCall_RuleAbstractRuleIDTerminalRuleCall_1_0_1ElementType() {
		return PredicatedRuleCall_RuleAbstractRuleIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentElementType() {
		return Assignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_GroupElementType() {
		return Assignment_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_PredicateParserRuleCall_0ElementType() {
		return Assignment_PredicateParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_FeatureAssignment_1ElementType() {
		return Assignment_FeatureAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_FeatureIDTerminalRuleCall_1_0ElementType() {
		return Assignment_FeatureIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_OperatorAssignment_2ElementType() {
		return Assignment_OperatorAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_OperatorAlternatives_2_0ElementType() {
		return Assignment_OperatorAlternatives_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_OperatorPlusSignEqualsSignKeyword_2_0_0ElementType() {
		return Assignment_OperatorPlusSignEqualsSignKeyword_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_OperatorEqualsSignKeyword_2_0_1ElementType() {
		return Assignment_OperatorEqualsSignKeyword_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_OperatorQuestionMarkEqualsSignKeyword_2_0_2ElementType() {
		return Assignment_OperatorQuestionMarkEqualsSignKeyword_2_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_TerminalAssignment_3ElementType() {
		return Assignment_TerminalAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_TerminalAssignableTerminalParserRuleCall_3_0ElementType() {
		return Assignment_TerminalAssignableTerminalParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicateElementType() {
		return Predicate_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicate_AlternativesElementType() {
		return Predicate_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicate_PredicatedAssignment_0ElementType() {
		return Predicate_PredicatedAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicate_PredicatedEqualsSignGreaterThanSignKeyword_0_0ElementType() {
		return Predicate_PredicatedEqualsSignGreaterThanSignKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicate_FirstSetPredicatedAssignment_1ElementType() {
		return Predicate_FirstSetPredicatedAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicate_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0ElementType() {
		return Predicate_FirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableTerminalElementType() {
		return AssignableTerminal_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableTerminal_AlternativesElementType() {
		return AssignableTerminal_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableTerminal_KeywordParserRuleCall_0ElementType() {
		return AssignableTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableTerminal_RuleCallParserRuleCall_1ElementType() {
		return AssignableTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2ElementType() {
		return AssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableTerminal_CrossReferenceParserRuleCall_3ElementType() {
		return AssignableTerminal_CrossReferenceParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedAssignableElementElementType() {
		return ParenthesizedAssignableElement_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedAssignableElement_GroupElementType() {
		return ParenthesizedAssignableElement_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType() {
		return ParenthesizedAssignableElement_LeftParenthesisKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType() {
		return ParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedAssignableElement_RightParenthesisKeyword_2ElementType() {
		return ParenthesizedAssignableElement_RightParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternativesElementType() {
		return AssignableAlternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_GroupElementType() {
		return AssignableAlternatives_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType() {
		return AssignableAlternatives_AssignableTerminalParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_Group_1ElementType() {
		return AssignableAlternatives_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_AlternativesElementsAction_1_0ElementType() {
		return AssignableAlternatives_AlternativesElementsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_Group_1_1ElementType() {
		return AssignableAlternatives_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType() {
		return AssignableAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_ElementsAssignment_1_1_1ElementType() {
		return AssignableAlternatives_ElementsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_ElementsAssignableTerminalParserRuleCall_1_1_1_0ElementType() {
		return AssignableAlternatives_ElementsAssignableTerminalParserRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReferenceElementType() {
		return CrossReference_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReference_GroupElementType() {
		return CrossReference_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReference_LeftSquareBracketKeyword_0ElementType() {
		return CrossReference_LeftSquareBracketKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReference_TypeAssignment_1ElementType() {
		return CrossReference_TypeAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReference_TypeTypeRefParserRuleCall_1_0ElementType() {
		return CrossReference_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReference_Group_2ElementType() {
		return CrossReference_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReference_VerticalLineKeyword_2_0ElementType() {
		return CrossReference_VerticalLineKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReference_TerminalAssignment_2_1ElementType() {
		return CrossReference_TerminalAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType() {
		return CrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReference_RightSquareBracketKeyword_3ElementType() {
		return CrossReference_RightSquareBracketKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReferenceableTerminalElementType() {
		return CrossReferenceableTerminal_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReferenceableTerminal_AlternativesElementType() {
		return CrossReferenceableTerminal_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType() {
		return CrossReferenceableTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType() {
		return CrossReferenceableTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedElementElementType() {
		return ParenthesizedElement_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedElement_GroupElementType() {
		return ParenthesizedElement_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedElement_LeftParenthesisKeyword_0ElementType() {
		return ParenthesizedElement_LeftParenthesisKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedElement_AlternativesParserRuleCall_1ElementType() {
		return ParenthesizedElement_AlternativesParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedElement_RightParenthesisKeyword_2ElementType() {
		return ParenthesizedElement_RightParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedGroupElementType() {
		return PredicatedGroup_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedGroup_GroupElementType() {
		return PredicatedGroup_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedGroup_PredicateParserRuleCall_0ElementType() {
		return PredicatedGroup_PredicateParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedGroup_LeftParenthesisKeyword_1ElementType() {
		return PredicatedGroup_LeftParenthesisKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedGroup_ElementsAssignment_2ElementType() {
		return PredicatedGroup_ElementsAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedGroup_ElementsAlternativesParserRuleCall_2_0ElementType() {
		return PredicatedGroup_ElementsAlternativesParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPredicatedGroup_RightParenthesisKeyword_3ElementType() {
		return PredicatedGroup_RightParenthesisKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRuleElementType() {
		return TerminalRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_GroupElementType() {
		return TerminalRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_TerminalKeyword_0ElementType() {
		return TerminalRule_TerminalKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_Alternatives_1ElementType() {
		return TerminalRule_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_Group_1_0ElementType() {
		return TerminalRule_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_FragmentAssignment_1_0_0ElementType() {
		return TerminalRule_FragmentAssignment_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_FragmentFragmentKeyword_1_0_0_0ElementType() {
		return TerminalRule_FragmentFragmentKeyword_1_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_NameAssignment_1_0_1ElementType() {
		return TerminalRule_NameAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_NameIDTerminalRuleCall_1_0_1_0ElementType() {
		return TerminalRule_NameIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_Group_1_1ElementType() {
		return TerminalRule_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_NameAssignment_1_1_0ElementType() {
		return TerminalRule_NameAssignment_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_NameIDTerminalRuleCall_1_1_0_0ElementType() {
		return TerminalRule_NameIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_ReturnsClauseParserRuleCall_1_1_1ElementType() {
		return TerminalRule_ReturnsClauseParserRuleCall_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_ColonKeyword_2ElementType() {
		return TerminalRule_ColonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_AlternativesAssignment_3ElementType() {
		return TerminalRule_AlternativesAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_AlternativesTerminalAlternativesParserRuleCall_3_0ElementType() {
		return TerminalRule_AlternativesTerminalAlternativesParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_SemicolonKeyword_4ElementType() {
		return TerminalRule_SemicolonKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternativesElementType() {
		return TerminalAlternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_GroupElementType() {
		return TerminalAlternatives_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType() {
		return TerminalAlternatives_TerminalGroupParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_Group_1ElementType() {
		return TerminalAlternatives_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_AlternativesElementsAction_1_0ElementType() {
		return TerminalAlternatives_AlternativesElementsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_Group_1_1ElementType() {
		return TerminalAlternatives_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType() {
		return TerminalAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_ElementsAssignment_1_1_1ElementType() {
		return TerminalAlternatives_ElementsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_ElementsTerminalGroupParserRuleCall_1_1_1_0ElementType() {
		return TerminalAlternatives_ElementsTerminalGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalGroupElementType() {
		return TerminalGroup_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalGroup_GroupElementType() {
		return TerminalGroup_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalGroup_TerminalTokenParserRuleCall_0ElementType() {
		return TerminalGroup_TerminalTokenParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalGroup_Group_1ElementType() {
		return TerminalGroup_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalGroup_GroupElementsAction_1_0ElementType() {
		return TerminalGroup_GroupElementsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalGroup_ElementsAssignment_1_1ElementType() {
		return TerminalGroup_ElementsAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalGroup_ElementsTerminalTokenParserRuleCall_1_1_0ElementType() {
		return TerminalGroup_ElementsTerminalTokenParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalTokenElementType() {
		return TerminalToken_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalToken_GroupElementType() {
		return TerminalToken_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalToken_TerminalTokenElementParserRuleCall_0ElementType() {
		return TerminalToken_TerminalTokenElementParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalToken_CardinalitiesParserRuleCall_1ElementType() {
		return TerminalToken_CardinalitiesParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalTokenElementElementType() {
		return TerminalTokenElement_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalTokenElement_AlternativesElementType() {
		return TerminalTokenElement_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType() {
		return TerminalTokenElement_CharacterRangeParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalTokenElement_TerminalRuleCallParserRuleCall_1ElementType() {
		return TerminalTokenElement_TerminalRuleCallParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType() {
		return TerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType() {
		return TerminalTokenElement_AbstractNegatedTokenParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalTokenElement_WildcardParserRuleCall_4ElementType() {
		return TerminalTokenElement_WildcardParserRuleCall_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalTokenElement_EOFParserRuleCall_5ElementType() {
		return TerminalTokenElement_EOFParserRuleCall_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedTerminalElementElementType() {
		return ParenthesizedTerminalElement_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedTerminalElement_GroupElementType() {
		return ParenthesizedTerminalElement_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType() {
		return ParenthesizedTerminalElement_LeftParenthesisKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType() {
		return ParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedTerminalElement_RightParenthesisKeyword_2ElementType() {
		return ParenthesizedTerminalElement_RightParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractNegatedTokenElementType() {
		return AbstractNegatedToken_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractNegatedToken_AlternativesElementType() {
		return AbstractNegatedToken_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType() {
		return AbstractNegatedToken_NegatedTokenParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType() {
		return AbstractNegatedToken_UntilTokenParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNegatedTokenElementType() {
		return NegatedToken_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNegatedToken_GroupElementType() {
		return NegatedToken_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNegatedToken_ExclamationMarkKeyword_0ElementType() {
		return NegatedToken_ExclamationMarkKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNegatedToken_TerminalAssignment_1ElementType() {
		return NegatedToken_TerminalAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType() {
		return NegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUntilTokenElementType() {
		return UntilToken_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUntilToken_GroupElementType() {
		return UntilToken_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType() {
		return UntilToken_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUntilToken_TerminalAssignment_1ElementType() {
		return UntilToken_TerminalAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType() {
		return UntilToken_TerminalTerminalTokenElementParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWildcardElementType() {
		return Wildcard_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWildcard_GroupElementType() {
		return Wildcard_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWildcard_WildcardAction_0ElementType() {
		return Wildcard_WildcardAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWildcard_FullStopKeyword_1ElementType() {
		return Wildcard_FullStopKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEOFElementType() {
		return EOF_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEOF_GroupElementType() {
		return EOF_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEOF_EOFAction_0ElementType() {
		return EOF_EOFAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEOF_EOFKeyword_1ElementType() {
		return EOF_EOFKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCharacterRangeElementType() {
		return CharacterRange_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCharacterRange_GroupElementType() {
		return CharacterRange_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCharacterRange_KeywordParserRuleCall_0ElementType() {
		return CharacterRange_KeywordParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCharacterRange_Group_1ElementType() {
		return CharacterRange_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCharacterRange_CharacterRangeLeftAction_1_0ElementType() {
		return CharacterRange_CharacterRangeLeftAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCharacterRange_FullStopFullStopKeyword_1_1ElementType() {
		return CharacterRange_FullStopFullStopKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCharacterRange_RightAssignment_1_2ElementType() {
		return CharacterRange_RightAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCharacterRange_RightKeywordParserRuleCall_1_2_0ElementType() {
		return CharacterRange_RightKeywordParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRuleElementType() {
		return EnumRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_GroupElementType() {
		return EnumRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_EnumKeyword_0ElementType() {
		return EnumRule_EnumKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_NameAssignment_1ElementType() {
		return EnumRule_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_NameIDTerminalRuleCall_1_0ElementType() {
		return EnumRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_ReturnsClauseParserRuleCall_2ElementType() {
		return EnumRule_ReturnsClauseParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_ColonKeyword_3ElementType() {
		return EnumRule_ColonKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_AlternativesAssignment_4ElementType() {
		return EnumRule_AlternativesAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType() {
		return EnumRule_AlternativesEnumLiteralsParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_SemicolonKeyword_5ElementType() {
		return EnumRule_SemicolonKeyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiteralsElementType() {
		return EnumLiterals_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_GroupElementType() {
		return EnumLiterals_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType() {
		return EnumLiterals_EnumLiteralDeclarationParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_Group_1ElementType() {
		return EnumLiterals_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_AlternativesElementsAction_1_0ElementType() {
		return EnumLiterals_AlternativesElementsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_Group_1_1ElementType() {
		return EnumLiterals_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_VerticalLineKeyword_1_1_0ElementType() {
		return EnumLiterals_VerticalLineKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_ElementsAssignment_1_1_1ElementType() {
		return EnumLiterals_ElementsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_ElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType() {
		return EnumLiterals_ElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiteralDeclarationElementType() {
		return EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiteralDeclaration_GroupElementType() {
		return EnumLiteralDeclaration_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiteralDeclaration_EnumLiteralAssignment_0ElementType() {
		return EnumLiteralDeclaration_EnumLiteralAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType() {
		return EnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiteralDeclaration_EnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1ElementType() {
		return EnumLiteralDeclaration_EnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiteralDeclaration_Group_1ElementType() {
		return EnumLiteralDeclaration_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiteralDeclaration_EqualsSignKeyword_1_0ElementType() {
		return EnumLiteralDeclaration_EqualsSignKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiteralDeclaration_LiteralAssignment_1_1ElementType() {
		return EnumLiteralDeclaration_LiteralAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0ElementType() {
		return EnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

}
