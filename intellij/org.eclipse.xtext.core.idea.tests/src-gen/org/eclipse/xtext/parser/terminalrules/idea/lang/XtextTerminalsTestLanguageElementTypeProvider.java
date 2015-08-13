package org.eclipse.xtext.parser.terminalrules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.XtextTerminalsTestLanguageFileImpl;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class XtextTerminalsTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<XtextTerminalsTestLanguageFileImpl>>(XtextTerminalsTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final XtextTerminalsTestLanguageGrammarAccess GRAMMAR_ACCESS = XtextTerminalsTestLanguageLanguage.INSTANCE.getInstance(XtextTerminalsTestLanguageGrammarAccess.class);

	private static class GrammarFactory {
		public static IGrammarAwareElementType createGrammarElementType() {
			return new IGrammarAwareElementType("Grammar_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarRule());
		}
		public static IGrammarAwareElementType createGrammar_GroupElementType() {
			return new IGrammarAwareElementType("Grammar_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGroup());
		}
		public static IGrammarAwareElementType createGrammar_GrammarKeyword_0ElementType() {
			return new IGrammarAwareElementType("Grammar_GrammarKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGrammarKeyword_0());
		}
		public static IGrammarAwareElementType createGrammar_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Grammar_NameAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createGrammar_NameGrammarIDParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Grammar_NameGrammarIDParserRuleCall_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createGrammar_Group_2ElementType() {
			return new IGrammarAwareElementType("Grammar_Group_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createGrammar_WithKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Grammar_WithKeyword_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getWithKeyword_2_0());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsAssignment_2_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsAssignment_2_1());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsGrammarCrossReference_2_1_0ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsGrammarCrossReference_2_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1());
		}
		public static IGrammarAwareElementType createGrammar_Group_2_2ElementType() {
			return new IGrammarAwareElementType("Grammar_Group_2_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGroup_2_2());
		}
		public static IGrammarAwareElementType createGrammar_CommaKeyword_2_2_0ElementType() {
			return new IGrammarAwareElementType("Grammar_CommaKeyword_2_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getCommaKeyword_2_2_0());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsAssignment_2_2_1ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsAssignment_2_2_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsAssignment_2_2_1());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsGrammarCrossReference_2_2_1_0ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsGrammarCrossReference_2_2_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0());
		}
		public static IGrammarAwareElementType createGrammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("Grammar_UsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1());
		}
		public static IGrammarAwareElementType createGrammar_Group_3ElementType() {
			return new IGrammarAwareElementType("Grammar_Group_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createGrammar_DefinesHiddenTokensAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("Grammar_DefinesHiddenTokensAssignment_3_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0());
		}
		public static IGrammarAwareElementType createGrammar_DefinesHiddenTokensHiddenKeyword_3_0_0ElementType() {
			return new IGrammarAwareElementType("Grammar_DefinesHiddenTokensHiddenKeyword_3_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0());
		}
		public static IGrammarAwareElementType createGrammar_LeftParenthesisKeyword_3_1ElementType() {
			return new IGrammarAwareElementType("Grammar_LeftParenthesisKeyword_3_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getLeftParenthesisKeyword_3_1());
		}
		public static IGrammarAwareElementType createGrammar_Group_3_2ElementType() {
			return new IGrammarAwareElementType("Grammar_Group_3_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGroup_3_2());
		}
		public static IGrammarAwareElementType createGrammar_HiddenTokensAssignment_3_2_0ElementType() {
			return new IGrammarAwareElementType("Grammar_HiddenTokensAssignment_3_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getHiddenTokensAssignment_3_2_0());
		}
		public static IGrammarAwareElementType createGrammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0ElementType() {
			return new IGrammarAwareElementType("Grammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0());
		}
		public static IGrammarAwareElementType createGrammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1ElementType() {
			return new IGrammarAwareElementType("Grammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1());
		}
		public static IGrammarAwareElementType createGrammar_Group_3_2_1ElementType() {
			return new IGrammarAwareElementType("Grammar_Group_3_2_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getGroup_3_2_1());
		}
		public static IGrammarAwareElementType createGrammar_CommaKeyword_3_2_1_0ElementType() {
			return new IGrammarAwareElementType("Grammar_CommaKeyword_3_2_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getCommaKeyword_3_2_1_0());
		}
		public static IGrammarAwareElementType createGrammar_HiddenTokensAssignment_3_2_1_1ElementType() {
			return new IGrammarAwareElementType("Grammar_HiddenTokensAssignment_3_2_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1());
		}
		public static IGrammarAwareElementType createGrammar_HiddenTokensAbstractRuleCrossReference_3_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("Grammar_HiddenTokensAbstractRuleCrossReference_3_2_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0());
		}
		public static IGrammarAwareElementType createGrammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("Grammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1());
		}
		public static IGrammarAwareElementType createGrammar_RightParenthesisKeyword_3_3ElementType() {
			return new IGrammarAwareElementType("Grammar_RightParenthesisKeyword_3_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getRightParenthesisKeyword_3_3());
		}
		public static IGrammarAwareElementType createGrammar_MetamodelDeclarationsAssignment_4ElementType() {
			return new IGrammarAwareElementType("Grammar_MetamodelDeclarationsAssignment_4_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getMetamodelDeclarationsAssignment_4());
		}
		public static IGrammarAwareElementType createGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Grammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createGrammar_RulesAssignment_5ElementType() {
			return new IGrammarAwareElementType("Grammar_RulesAssignment_5_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getRulesAssignment_5());
		}
		public static IGrammarAwareElementType createGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("Grammar_RulesAbstractRuleParserRuleCall_5_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0());
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

	public static final IGrammarAwareElementType Grammar_Group_3_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_Group_3ElementType());

	public static final IGrammarAwareElementType Grammar_DefinesHiddenTokensAssignment_3_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_DefinesHiddenTokensAssignment_3_0ElementType());

	public static final IGrammarAwareElementType Grammar_DefinesHiddenTokensHiddenKeyword_3_0_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_DefinesHiddenTokensHiddenKeyword_3_0_0ElementType());

	public static final IGrammarAwareElementType Grammar_LeftParenthesisKeyword_3_1_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_LeftParenthesisKeyword_3_1ElementType());

	public static final IGrammarAwareElementType Grammar_Group_3_2_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_Group_3_2ElementType());

	public static final IGrammarAwareElementType Grammar_HiddenTokensAssignment_3_2_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_HiddenTokensAssignment_3_2_0ElementType());

	public static final IGrammarAwareElementType Grammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0ElementType());

	public static final IGrammarAwareElementType Grammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1ElementType());

	public static final IGrammarAwareElementType Grammar_Group_3_2_1_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_Group_3_2_1ElementType());

	public static final IGrammarAwareElementType Grammar_CommaKeyword_3_2_1_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_CommaKeyword_3_2_1_0ElementType());

	public static final IGrammarAwareElementType Grammar_HiddenTokensAssignment_3_2_1_1_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_HiddenTokensAssignment_3_2_1_1ElementType());

	public static final IGrammarAwareElementType Grammar_HiddenTokensAbstractRuleCrossReference_3_2_1_1_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_HiddenTokensAbstractRuleCrossReference_3_2_1_1_0ElementType());

	public static final IGrammarAwareElementType Grammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1ElementType());

	public static final IGrammarAwareElementType Grammar_RightParenthesisKeyword_3_3_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_RightParenthesisKeyword_3_3ElementType());

	public static final IGrammarAwareElementType Grammar_MetamodelDeclarationsAssignment_4_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_MetamodelDeclarationsAssignment_4ElementType());

	public static final IGrammarAwareElementType Grammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Grammar_RulesAssignment_5_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_RulesAssignment_5ElementType());

	public static final IGrammarAwareElementType Grammar_RulesAbstractRuleParserRuleCall_5_0_ELEMENT_TYPE = associate(GrammarFactory.createGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType());

	private static class GrammarIDFactory {
		public static IGrammarAwareElementType createGrammarIDElementType() {
			return new IGrammarAwareElementType("GrammarID_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDRule());
		}
		public static IGrammarAwareElementType createGrammarID_GroupElementType() {
			return new IGrammarAwareElementType("GrammarID_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDAccess().getGroup());
		}
		public static IGrammarAwareElementType createGrammarID_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("GrammarID_IDTerminalRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createGrammarID_Group_1ElementType() {
			return new IGrammarAwareElementType("GrammarID_Group_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createGrammarID_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("GrammarID_FullStopKeyword_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createGrammarID_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("GrammarID_IDTerminalRuleCall_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGrammarIDAccess().getIDTerminalRuleCall_1_1());
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
			return new IGrammarAwareElementType("AbstractRule_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleRule());
		}
		public static IGrammarAwareElementType createAbstractRule_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractRule_Alternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractRule_ParserRuleParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractRule_ParserRuleParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getParserRuleParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractRule_TerminalRuleParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractRule_TerminalRuleParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1());
		}
		public static IGrammarAwareElementType createAbstractRule_EnumRuleParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("AbstractRule_EnumRuleParserRuleCall_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractRuleAccess().getEnumRuleParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType AbstractRule_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRuleElementType());

	public static final IGrammarAwareElementType AbstractRule_Alternatives_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractRule_ParserRuleParserRuleCall_0_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_ParserRuleParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractRule_TerminalRuleParserRuleCall_1_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_TerminalRuleParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType AbstractRule_EnumRuleParserRuleCall_2_ELEMENT_TYPE = associate(AbstractRuleFactory.createAbstractRule_EnumRuleParserRuleCall_2ElementType());

	private static class AbstractMetamodelDeclarationFactory {
		public static IGrammarAwareElementType createAbstractMetamodelDeclarationElementType() {
			return new IGrammarAwareElementType("AbstractMetamodelDeclaration_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMetamodelDeclarationRule());
		}
		public static IGrammarAwareElementType createAbstractMetamodelDeclaration_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractMetamodelDeclaration_Alternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMetamodelDeclarationAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractMetamodelDeclaration_ELEMENT_TYPE = associate(AbstractMetamodelDeclarationFactory.createAbstractMetamodelDeclarationElementType());

	public static final IGrammarAwareElementType AbstractMetamodelDeclaration_Alternatives_ELEMENT_TYPE = associate(AbstractMetamodelDeclarationFactory.createAbstractMetamodelDeclaration_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0_ELEMENT_TYPE = associate(AbstractMetamodelDeclarationFactory.createAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1_ELEMENT_TYPE = associate(AbstractMetamodelDeclarationFactory.createAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType());

	private static class GeneratedMetamodelFactory {
		public static IGrammarAwareElementType createGeneratedMetamodelElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelRule());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_GroupElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getGroup());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_GenerateKeyword_0ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_GenerateKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getGenerateKeyword_0());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_NameAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_EPackageAssignment_2ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_EPackageAssignment_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getEPackageAssignment_2());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_EPackageEPackageCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_EPackageEPackageCrossReference_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_2_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_Group_3ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_Group_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_AsKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_AsKeyword_3_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getAsKeyword_3_0());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_AliasAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_AliasAssignment_3_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getAliasAssignment_3_1());
		}
		public static IGrammarAwareElementType createGeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("GeneratedMetamodel_AliasIDTerminalRuleCall_3_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0());
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
			return new IGrammarAwareElementType("ReferencedMetamodel_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelRule());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_GroupElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getGroup());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_ImportKeyword_0ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_ImportKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getImportKeyword_0());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_EPackageAssignment_1ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_EPackageAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getEPackageAssignment_1());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_EPackageEPackageCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_EPackageEPackageCrossReference_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_EPackageEPackageSTRINGTerminalRuleCall_1_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_Group_2ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_Group_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_AsKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_AsKeyword_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getAsKeyword_2_0());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_AliasAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_AliasAssignment_2_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getAliasAssignment_2_1());
		}
		public static IGrammarAwareElementType createReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("ReferencedMetamodel_AliasIDTerminalRuleCall_2_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0());
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
			return new IGrammarAwareElementType("ParserRule_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleRule());
		}
		public static IGrammarAwareElementType createParserRule_GroupElementType() {
			return new IGrammarAwareElementType("ParserRule_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createParserRule_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_NameAssignment_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createParserRule_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createParserRule_Group_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_Group_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createParserRule_ReturnsKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_ReturnsKeyword_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getReturnsKeyword_1_0());
		}
		public static IGrammarAwareElementType createParserRule_TypeAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_TypeAssignment_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getTypeAssignment_1_1());
		}
		public static IGrammarAwareElementType createParserRule_TypeTypeRefParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_TypeTypeRefParserRuleCall_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createParserRule_Group_2ElementType() {
			return new IGrammarAwareElementType("ParserRule_Group_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createParserRule_DefinesHiddenTokensAssignment_2_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_DefinesHiddenTokensAssignment_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0());
		}
		public static IGrammarAwareElementType createParserRule_DefinesHiddenTokensHiddenKeyword_2_0_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_DefinesHiddenTokensHiddenKeyword_2_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0());
		}
		public static IGrammarAwareElementType createParserRule_LeftParenthesisKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_LeftParenthesisKeyword_2_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getLeftParenthesisKeyword_2_1());
		}
		public static IGrammarAwareElementType createParserRule_Group_2_2ElementType() {
			return new IGrammarAwareElementType("ParserRule_Group_2_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getGroup_2_2());
		}
		public static IGrammarAwareElementType createParserRule_HiddenTokensAssignment_2_2_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_HiddenTokensAssignment_2_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getHiddenTokensAssignment_2_2_0());
		}
		public static IGrammarAwareElementType createParserRule_HiddenTokensAbstractRuleCrossReference_2_2_0_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_HiddenTokensAbstractRuleCrossReference_2_2_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0());
		}
		public static IGrammarAwareElementType createParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1());
		}
		public static IGrammarAwareElementType createParserRule_Group_2_2_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_Group_2_2_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getGroup_2_2_1());
		}
		public static IGrammarAwareElementType createParserRule_CommaKeyword_2_2_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_CommaKeyword_2_2_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getCommaKeyword_2_2_1_0());
		}
		public static IGrammarAwareElementType createParserRule_HiddenTokensAssignment_2_2_1_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_HiddenTokensAssignment_2_2_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1());
		}
		public static IGrammarAwareElementType createParserRule_HiddenTokensAbstractRuleCrossReference_2_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_HiddenTokensAbstractRuleCrossReference_2_2_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0());
		}
		public static IGrammarAwareElementType createParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("ParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1());
		}
		public static IGrammarAwareElementType createParserRule_RightParenthesisKeyword_2_3ElementType() {
			return new IGrammarAwareElementType("ParserRule_RightParenthesisKeyword_2_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getRightParenthesisKeyword_2_3());
		}
		public static IGrammarAwareElementType createParserRule_ColonKeyword_3ElementType() {
			return new IGrammarAwareElementType("ParserRule_ColonKeyword_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getColonKeyword_3());
		}
		public static IGrammarAwareElementType createParserRule_AlternativesAssignment_4ElementType() {
			return new IGrammarAwareElementType("ParserRule_AlternativesAssignment_4_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getAlternativesAssignment_4());
		}
		public static IGrammarAwareElementType createParserRule_AlternativesAlternativesParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("ParserRule_AlternativesAlternativesParserRuleCall_4_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createParserRule_SemicolonKeyword_5ElementType() {
			return new IGrammarAwareElementType("ParserRule_SemicolonKeyword_5_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleAccess().getSemicolonKeyword_5());
		}
	}

	public static final IGrammarAwareElementType ParserRule_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRuleElementType());

	public static final IGrammarAwareElementType ParserRule_Group_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_GroupElementType());

	public static final IGrammarAwareElementType ParserRule_NameAssignment_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType ParserRule_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType ParserRule_Group_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_Group_1ElementType());

	public static final IGrammarAwareElementType ParserRule_ReturnsKeyword_1_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_ReturnsKeyword_1_0ElementType());

	public static final IGrammarAwareElementType ParserRule_TypeAssignment_1_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_TypeAssignment_1_1ElementType());

	public static final IGrammarAwareElementType ParserRule_TypeTypeRefParserRuleCall_1_1_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_TypeTypeRefParserRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType ParserRule_Group_2_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_Group_2ElementType());

	public static final IGrammarAwareElementType ParserRule_DefinesHiddenTokensAssignment_2_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_DefinesHiddenTokensAssignment_2_0ElementType());

	public static final IGrammarAwareElementType ParserRule_DefinesHiddenTokensHiddenKeyword_2_0_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_DefinesHiddenTokensHiddenKeyword_2_0_0ElementType());

	public static final IGrammarAwareElementType ParserRule_LeftParenthesisKeyword_2_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_LeftParenthesisKeyword_2_1ElementType());

	public static final IGrammarAwareElementType ParserRule_Group_2_2_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_Group_2_2ElementType());

	public static final IGrammarAwareElementType ParserRule_HiddenTokensAssignment_2_2_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_HiddenTokensAssignment_2_2_0ElementType());

	public static final IGrammarAwareElementType ParserRule_HiddenTokensAbstractRuleCrossReference_2_2_0_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_HiddenTokensAbstractRuleCrossReference_2_2_0_0ElementType());

	public static final IGrammarAwareElementType ParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1ElementType());

	public static final IGrammarAwareElementType ParserRule_Group_2_2_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_Group_2_2_1ElementType());

	public static final IGrammarAwareElementType ParserRule_CommaKeyword_2_2_1_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_CommaKeyword_2_2_1_0ElementType());

	public static final IGrammarAwareElementType ParserRule_HiddenTokensAssignment_2_2_1_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_HiddenTokensAssignment_2_2_1_1ElementType());

	public static final IGrammarAwareElementType ParserRule_HiddenTokensAbstractRuleCrossReference_2_2_1_1_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_HiddenTokensAbstractRuleCrossReference_2_2_1_1_0ElementType());

	public static final IGrammarAwareElementType ParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1ElementType());

	public static final IGrammarAwareElementType ParserRule_RightParenthesisKeyword_2_3_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_RightParenthesisKeyword_2_3ElementType());

	public static final IGrammarAwareElementType ParserRule_ColonKeyword_3_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_ColonKeyword_3ElementType());

	public static final IGrammarAwareElementType ParserRule_AlternativesAssignment_4_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_AlternativesAssignment_4ElementType());

	public static final IGrammarAwareElementType ParserRule_AlternativesAlternativesParserRuleCall_4_0_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_AlternativesAlternativesParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType ParserRule_SemicolonKeyword_5_ELEMENT_TYPE = associate(ParserRuleFactory.createParserRule_SemicolonKeyword_5ElementType());

	private static class TypeRefFactory {
		public static IGrammarAwareElementType createTypeRefElementType() {
			return new IGrammarAwareElementType("TypeRef_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefRule());
		}
		public static IGrammarAwareElementType createTypeRef_GroupElementType() {
			return new IGrammarAwareElementType("TypeRef_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getGroup());
		}
		public static IGrammarAwareElementType createTypeRef_Group_0ElementType() {
			return new IGrammarAwareElementType("TypeRef_Group_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createTypeRef_MetamodelAssignment_0_0ElementType() {
			return new IGrammarAwareElementType("TypeRef_MetamodelAssignment_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getMetamodelAssignment_0_0());
		}
		public static IGrammarAwareElementType createTypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0ElementType() {
			return new IGrammarAwareElementType("TypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0());
		}
		public static IGrammarAwareElementType createTypeRef_MetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1ElementType() {
			return new IGrammarAwareElementType("TypeRef_MetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1());
		}
		public static IGrammarAwareElementType createTypeRef_ColonColonKeyword_0_1ElementType() {
			return new IGrammarAwareElementType("TypeRef_ColonColonKeyword_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getColonColonKeyword_0_1());
		}
		public static IGrammarAwareElementType createTypeRef_ClassifierAssignment_1ElementType() {
			return new IGrammarAwareElementType("TypeRef_ClassifierAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getClassifierAssignment_1());
		}
		public static IGrammarAwareElementType createTypeRef_ClassifierEClassifierCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("TypeRef_ClassifierEClassifierCrossReference_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0());
		}
		public static IGrammarAwareElementType createTypeRef_ClassifierEClassifierIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("TypeRef_ClassifierEClassifierIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1());
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
			return new IGrammarAwareElementType("Alternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesRule());
		}
		public static IGrammarAwareElementType createAlternatives_GroupElementType() {
			return new IGrammarAwareElementType("Alternatives_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getGroup());
		}
		public static IGrammarAwareElementType createAlternatives_GroupParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Alternatives_GroupParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getGroupParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAlternatives_Group_1ElementType() {
			return new IGrammarAwareElementType("Alternatives_Group_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createAlternatives_AlternativesGroupsAction_1_0ElementType() {
			return new IGrammarAwareElementType("Alternatives_AlternativesGroupsAction_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getAlternativesGroupsAction_1_0());
		}
		public static IGrammarAwareElementType createAlternatives_Group_1_1ElementType() {
			return new IGrammarAwareElementType("Alternatives_Group_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAlternatives_VerticalLineKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("Alternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getVerticalLineKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createAlternatives_GroupsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("Alternatives_GroupsAssignment_1_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getGroupsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createAlternatives_GroupsGroupParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Alternatives_GroupsGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Alternatives_ELEMENT_TYPE = associate(AlternativesFactory.createAlternativesElementType());

	public static final IGrammarAwareElementType Alternatives_Group_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_GroupElementType());

	public static final IGrammarAwareElementType Alternatives_GroupParserRuleCall_0_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_GroupParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Alternatives_Group_1_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_Group_1ElementType());

	public static final IGrammarAwareElementType Alternatives_AlternativesGroupsAction_1_0_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_AlternativesGroupsAction_1_0ElementType());

	public static final IGrammarAwareElementType Alternatives_Group_1_1_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_Group_1_1ElementType());

	public static final IGrammarAwareElementType Alternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_VerticalLineKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType Alternatives_GroupsAssignment_1_1_1_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_GroupsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType Alternatives_GroupsGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(AlternativesFactory.createAlternatives_GroupsGroupParserRuleCall_1_1_1_0ElementType());

	private static class GroupFactory {
		public static IGrammarAwareElementType createGroupElementType() {
			return new IGrammarAwareElementType("Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupRule());
		}
		public static IGrammarAwareElementType createGroup_GroupElementType() {
			return new IGrammarAwareElementType("Group_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getGroup());
		}
		public static IGrammarAwareElementType createGroup_AbstractTokenParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Group_AbstractTokenParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getAbstractTokenParserRuleCall_0());
		}
		public static IGrammarAwareElementType createGroup_Group_1ElementType() {
			return new IGrammarAwareElementType("Group_Group_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createGroup_GroupTokensAction_1_0ElementType() {
			return new IGrammarAwareElementType("Group_GroupTokensAction_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getGroupTokensAction_1_0());
		}
		public static IGrammarAwareElementType createGroup_TokensAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Group_TokensAssignment_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getTokensAssignment_1_1());
		}
		public static IGrammarAwareElementType createGroup_TokensAbstractTokenParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Group_TokensAbstractTokenParserRuleCall_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Group_ELEMENT_TYPE = associate(GroupFactory.createGroupElementType());

	public static final IGrammarAwareElementType Group_Group_ELEMENT_TYPE = associate(GroupFactory.createGroup_GroupElementType());

	public static final IGrammarAwareElementType Group_AbstractTokenParserRuleCall_0_ELEMENT_TYPE = associate(GroupFactory.createGroup_AbstractTokenParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Group_Group_1_ELEMENT_TYPE = associate(GroupFactory.createGroup_Group_1ElementType());

	public static final IGrammarAwareElementType Group_GroupTokensAction_1_0_ELEMENT_TYPE = associate(GroupFactory.createGroup_GroupTokensAction_1_0ElementType());

	public static final IGrammarAwareElementType Group_TokensAssignment_1_1_ELEMENT_TYPE = associate(GroupFactory.createGroup_TokensAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Group_TokensAbstractTokenParserRuleCall_1_1_0_ELEMENT_TYPE = associate(GroupFactory.createGroup_TokensAbstractTokenParserRuleCall_1_1_0ElementType());

	private static class AbstractTokenFactory {
		public static IGrammarAwareElementType createAbstractTokenElementType() {
			return new IGrammarAwareElementType("AbstractToken_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenRule());
		}
		public static IGrammarAwareElementType createAbstractToken_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractToken_Alternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractToken_AbstractTokenWithCardinalityParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractToken_ActionParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractToken_ActionParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenAccess().getActionParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractToken_ELEMENT_TYPE = associate(AbstractTokenFactory.createAbstractTokenElementType());

	public static final IGrammarAwareElementType AbstractToken_Alternatives_ELEMENT_TYPE = associate(AbstractTokenFactory.createAbstractToken_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractToken_AbstractTokenWithCardinalityParserRuleCall_0_ELEMENT_TYPE = associate(AbstractTokenFactory.createAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractToken_ActionParserRuleCall_1_ELEMENT_TYPE = associate(AbstractTokenFactory.createAbstractToken_ActionParserRuleCall_1ElementType());

	private static class AbstractTokenWithCardinalityFactory {
		public static IGrammarAwareElementType createAbstractTokenWithCardinalityElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityRule());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_GroupElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getGroup());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_Alternatives_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getAlternatives_0());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_AssignmentParserRuleCall_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_CardinalityAssignment_1ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_CardinalityAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_CardinalityAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_CardinalityAlternatives_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_CardinalityQuestionMarkKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_CardinalityQuestionMarkKeyword_1_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_CardinalityAsteriskKeyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_CardinalityAsteriskKeyword_1_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1());
		}
		public static IGrammarAwareElementType createAbstractTokenWithCardinality_CardinalityPlusSignKeyword_1_0_2ElementType() {
			return new IGrammarAwareElementType("AbstractTokenWithCardinality_CardinalityPlusSignKeyword_1_0_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2());
		}
	}

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinalityElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_Group_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_GroupElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_Alternatives_0_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_Alternatives_0ElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_AssignmentParserRuleCall_0_0_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_CardinalityAssignment_1_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_CardinalityAssignment_1ElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_CardinalityAlternatives_1_0_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_CardinalityAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_CardinalityQuestionMarkKeyword_1_0_0_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_CardinalityQuestionMarkKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_CardinalityAsteriskKeyword_1_0_1_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_CardinalityAsteriskKeyword_1_0_1ElementType());

	public static final IGrammarAwareElementType AbstractTokenWithCardinality_CardinalityPlusSignKeyword_1_0_2_ELEMENT_TYPE = associate(AbstractTokenWithCardinalityFactory.createAbstractTokenWithCardinality_CardinalityPlusSignKeyword_1_0_2ElementType());

	private static class ActionFactory {
		public static IGrammarAwareElementType createActionElementType() {
			return new IGrammarAwareElementType("Action_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionRule());
		}
		public static IGrammarAwareElementType createAction_GroupElementType() {
			return new IGrammarAwareElementType("Action_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getGroup());
		}
		public static IGrammarAwareElementType createAction_LeftCurlyBracketKeyword_0ElementType() {
			return new IGrammarAwareElementType("Action_LeftCurlyBracketKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getLeftCurlyBracketKeyword_0());
		}
		public static IGrammarAwareElementType createAction_TypeAssignment_1ElementType() {
			return new IGrammarAwareElementType("Action_TypeAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getTypeAssignment_1());
		}
		public static IGrammarAwareElementType createAction_TypeTypeRefParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Action_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getTypeTypeRefParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createAction_Group_2ElementType() {
			return new IGrammarAwareElementType("Action_Group_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createAction_FullStopKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Action_FullStopKeyword_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getFullStopKeyword_2_0());
		}
		public static IGrammarAwareElementType createAction_FeatureAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Action_FeatureAssignment_2_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getFeatureAssignment_2_1());
		}
		public static IGrammarAwareElementType createAction_FeatureIDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Action_FeatureIDTerminalRuleCall_2_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createAction_OperatorAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("Action_OperatorAssignment_2_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getOperatorAssignment_2_2());
		}
		public static IGrammarAwareElementType createAction_OperatorAlternatives_2_2_0ElementType() {
			return new IGrammarAwareElementType("Action_OperatorAlternatives_2_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getOperatorAlternatives_2_2_0());
		}
		public static IGrammarAwareElementType createAction_OperatorEqualsSignKeyword_2_2_0_0ElementType() {
			return new IGrammarAwareElementType("Action_OperatorEqualsSignKeyword_2_2_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0());
		}
		public static IGrammarAwareElementType createAction_OperatorPlusSignEqualsSignKeyword_2_2_0_1ElementType() {
			return new IGrammarAwareElementType("Action_OperatorPlusSignEqualsSignKeyword_2_2_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1());
		}
		public static IGrammarAwareElementType createAction_CurrentKeyword_2_3ElementType() {
			return new IGrammarAwareElementType("Action_CurrentKeyword_2_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getCurrentKeyword_2_3());
		}
		public static IGrammarAwareElementType createAction_RightCurlyBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("Action_RightCurlyBracketKeyword_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAccess().getRightCurlyBracketKeyword_3());
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
			return new IGrammarAwareElementType("AbstractTerminal_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalRule());
		}
		public static IGrammarAwareElementType createAbstractTerminal_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_Alternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractTerminal_KeywordParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getKeywordParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractTerminal_RuleCallParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getRuleCallParserRuleCall_1());
		}
		public static IGrammarAwareElementType createAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("AbstractTerminal_ParenthesizedElementParserRuleCall_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType AbstractTerminal_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminalElementType());

	public static final IGrammarAwareElementType AbstractTerminal_Alternatives_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_KeywordParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_RuleCallParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType AbstractTerminal_ParenthesizedElementParserRuleCall_2_ELEMENT_TYPE = associate(AbstractTerminalFactory.createAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType());

	private static class KeywordFactory {
		public static IGrammarAwareElementType createKeywordElementType() {
			return new IGrammarAwareElementType("Keyword_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordRule());
		}
		public static IGrammarAwareElementType createKeyword_ValueAssignmentElementType() {
			return new IGrammarAwareElementType("Keyword_ValueAssignment_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordAccess().getValueAssignment());
		}
		public static IGrammarAwareElementType createKeyword_ValueSTRINGTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Keyword_ValueSTRINGTerminalRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKeywordAccess().getValueSTRINGTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Keyword_ELEMENT_TYPE = associate(KeywordFactory.createKeywordElementType());

	public static final IGrammarAwareElementType Keyword_ValueAssignment_ELEMENT_TYPE = associate(KeywordFactory.createKeyword_ValueAssignmentElementType());

	public static final IGrammarAwareElementType Keyword_ValueSTRINGTerminalRuleCall_0_ELEMENT_TYPE = associate(KeywordFactory.createKeyword_ValueSTRINGTerminalRuleCall_0ElementType());

	private static class RuleCallFactory {
		public static IGrammarAwareElementType createRuleCallElementType() {
			return new IGrammarAwareElementType("RuleCall_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallRule());
		}
		public static IGrammarAwareElementType createRuleCall_RuleAssignmentElementType() {
			return new IGrammarAwareElementType("RuleCall_RuleAssignment_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getRuleAssignment());
		}
		public static IGrammarAwareElementType createRuleCall_RuleAbstractRuleCrossReference_0ElementType() {
			return new IGrammarAwareElementType("RuleCall_RuleAbstractRuleCrossReference_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getRuleAbstractRuleCrossReference_0());
		}
		public static IGrammarAwareElementType createRuleCall_RuleAbstractRuleIDTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("RuleCall_RuleAbstractRuleIDTerminalRuleCall_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType RuleCall_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCallElementType());

	public static final IGrammarAwareElementType RuleCall_RuleAssignment_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_RuleAssignmentElementType());

	public static final IGrammarAwareElementType RuleCall_RuleAbstractRuleCrossReference_0_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_RuleAbstractRuleCrossReference_0ElementType());

	public static final IGrammarAwareElementType RuleCall_RuleAbstractRuleIDTerminalRuleCall_0_1_ELEMENT_TYPE = associate(RuleCallFactory.createRuleCall_RuleAbstractRuleIDTerminalRuleCall_0_1ElementType());

	private static class AssignmentFactory {
		public static IGrammarAwareElementType createAssignmentElementType() {
			return new IGrammarAwareElementType("Assignment_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentRule());
		}
		public static IGrammarAwareElementType createAssignment_GroupElementType() {
			return new IGrammarAwareElementType("Assignment_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getGroup());
		}
		public static IGrammarAwareElementType createAssignment_FeatureAssignment_0ElementType() {
			return new IGrammarAwareElementType("Assignment_FeatureAssignment_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getFeatureAssignment_0());
		}
		public static IGrammarAwareElementType createAssignment_FeatureIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Assignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createAssignment_OperatorAssignment_1ElementType() {
			return new IGrammarAwareElementType("Assignment_OperatorAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getOperatorAssignment_1());
		}
		public static IGrammarAwareElementType createAssignment_OperatorAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("Assignment_OperatorAlternatives_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getOperatorAlternatives_1_0());
		}
		public static IGrammarAwareElementType createAssignment_OperatorPlusSignEqualsSignKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Assignment_OperatorPlusSignEqualsSignKeyword_1_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createAssignment_OperatorEqualsSignKeyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("Assignment_OperatorEqualsSignKeyword_1_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1());
		}
		public static IGrammarAwareElementType createAssignment_OperatorQuestionMarkEqualsSignKeyword_1_0_2ElementType() {
			return new IGrammarAwareElementType("Assignment_OperatorQuestionMarkEqualsSignKeyword_1_0_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2());
		}
		public static IGrammarAwareElementType createAssignment_TerminalAssignment_2ElementType() {
			return new IGrammarAwareElementType("Assignment_TerminalAssignment_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getTerminalAssignment_2());
		}
		public static IGrammarAwareElementType createAssignment_TerminalAssignableTerminalParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Assignment_TerminalAssignableTerminalParserRuleCall_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Assignment_ELEMENT_TYPE = associate(AssignmentFactory.createAssignmentElementType());

	public static final IGrammarAwareElementType Assignment_Group_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_GroupElementType());

	public static final IGrammarAwareElementType Assignment_FeatureAssignment_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_FeatureAssignment_0ElementType());

	public static final IGrammarAwareElementType Assignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_FeatureIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Assignment_OperatorAssignment_1_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_OperatorAssignment_1ElementType());

	public static final IGrammarAwareElementType Assignment_OperatorAlternatives_1_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_OperatorAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType Assignment_OperatorPlusSignEqualsSignKeyword_1_0_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_OperatorPlusSignEqualsSignKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Assignment_OperatorEqualsSignKeyword_1_0_1_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_OperatorEqualsSignKeyword_1_0_1ElementType());

	public static final IGrammarAwareElementType Assignment_OperatorQuestionMarkEqualsSignKeyword_1_0_2_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_OperatorQuestionMarkEqualsSignKeyword_1_0_2ElementType());

	public static final IGrammarAwareElementType Assignment_TerminalAssignment_2_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_TerminalAssignment_2ElementType());

	public static final IGrammarAwareElementType Assignment_TerminalAssignableTerminalParserRuleCall_2_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_TerminalAssignableTerminalParserRuleCall_2_0ElementType());

	private static class AssignableTerminalFactory {
		public static IGrammarAwareElementType createAssignableTerminalElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalRule());
		}
		public static IGrammarAwareElementType createAssignableTerminal_AlternativesElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_Alternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAssignableTerminal_KeywordParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalAccess().getKeywordParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAssignableTerminal_RuleCallParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalAccess().getRuleCallParserRuleCall_1());
		}
		public static IGrammarAwareElementType createAssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2());
		}
		public static IGrammarAwareElementType createAssignableTerminal_CrossReferenceParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("AssignableTerminal_CrossReferenceParserRuleCall_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3());
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
			return new IGrammarAwareElementType("ParenthesizedAssignableElement_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAssignableElementRule());
		}
		public static IGrammarAwareElementType createParenthesizedAssignableElement_GroupElementType() {
			return new IGrammarAwareElementType("ParenthesizedAssignableElement_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAssignableElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("ParenthesizedAssignableElement_LeftParenthesisKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParenthesizedAssignableElement_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("ParenthesizedAssignableElement_RightParenthesisKeyword_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2());
		}
	}

	public static final IGrammarAwareElementType ParenthesizedAssignableElement_ELEMENT_TYPE = associate(ParenthesizedAssignableElementFactory.createParenthesizedAssignableElementElementType());

	public static final IGrammarAwareElementType ParenthesizedAssignableElement_Group_ELEMENT_TYPE = associate(ParenthesizedAssignableElementFactory.createParenthesizedAssignableElement_GroupElementType());

	public static final IGrammarAwareElementType ParenthesizedAssignableElement_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParenthesizedAssignableElementFactory.createParenthesizedAssignableElement_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType ParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1_ELEMENT_TYPE = associate(ParenthesizedAssignableElementFactory.createParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType ParenthesizedAssignableElement_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParenthesizedAssignableElementFactory.createParenthesizedAssignableElement_RightParenthesisKeyword_2ElementType());

	private static class AssignableAlternativesFactory {
		public static IGrammarAwareElementType createAssignableAlternativesElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesRule());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_GroupElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getGroup());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_AssignableTerminalParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_Group_1ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_Group_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_AlternativesGroupsAction_1_0ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_AlternativesGroupsAction_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_Group_1_1ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_Group_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_GroupsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_GroupsAssignment_1_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getGroupsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createAssignableAlternatives_GroupsAssignableTerminalParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("AssignableAlternatives_GroupsAssignableTerminalParserRuleCall_1_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType AssignableAlternatives_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternativesElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_Group_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_GroupElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_AssignableTerminalParserRuleCall_0_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_Group_1_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_Group_1ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_AlternativesGroupsAction_1_0_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_AlternativesGroupsAction_1_0ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_Group_1_1_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_Group_1_1ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_GroupsAssignment_1_1_1_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_GroupsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType AssignableAlternatives_GroupsAssignableTerminalParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(AssignableAlternativesFactory.createAssignableAlternatives_GroupsAssignableTerminalParserRuleCall_1_1_1_0ElementType());

	private static class CrossReferenceFactory {
		public static IGrammarAwareElementType createCrossReferenceElementType() {
			return new IGrammarAwareElementType("CrossReference_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceRule());
		}
		public static IGrammarAwareElementType createCrossReference_GroupElementType() {
			return new IGrammarAwareElementType("CrossReference_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getGroup());
		}
		public static IGrammarAwareElementType createCrossReference_LeftSquareBracketKeyword_0ElementType() {
			return new IGrammarAwareElementType("CrossReference_LeftSquareBracketKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getLeftSquareBracketKeyword_0());
		}
		public static IGrammarAwareElementType createCrossReference_TypeAssignment_1ElementType() {
			return new IGrammarAwareElementType("CrossReference_TypeAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getTypeAssignment_1());
		}
		public static IGrammarAwareElementType createCrossReference_TypeTypeRefParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("CrossReference_TypeTypeRefParserRuleCall_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createCrossReference_Group_2ElementType() {
			return new IGrammarAwareElementType("CrossReference_Group_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createCrossReference_VerticalLineKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("CrossReference_VerticalLineKeyword_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getVerticalLineKeyword_2_0());
		}
		public static IGrammarAwareElementType createCrossReference_TerminalAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("CrossReference_TerminalAssignment_2_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getTerminalAssignment_2_1());
		}
		public static IGrammarAwareElementType createCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("CrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createCrossReference_RightSquareBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("CrossReference_RightSquareBracketKeyword_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceAccess().getRightSquareBracketKeyword_3());
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
			return new IGrammarAwareElementType("CrossReferenceableTerminal_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceableTerminalRule());
		}
		public static IGrammarAwareElementType createCrossReferenceableTerminal_AlternativesElementType() {
			return new IGrammarAwareElementType("CrossReferenceableTerminal_Alternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceableTerminalAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("CrossReferenceableTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0());
		}
		public static IGrammarAwareElementType createCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("CrossReferenceableTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType CrossReferenceableTerminal_ELEMENT_TYPE = associate(CrossReferenceableTerminalFactory.createCrossReferenceableTerminalElementType());

	public static final IGrammarAwareElementType CrossReferenceableTerminal_Alternatives_ELEMENT_TYPE = associate(CrossReferenceableTerminalFactory.createCrossReferenceableTerminal_AlternativesElementType());

	public static final IGrammarAwareElementType CrossReferenceableTerminal_KeywordParserRuleCall_0_ELEMENT_TYPE = associate(CrossReferenceableTerminalFactory.createCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType CrossReferenceableTerminal_RuleCallParserRuleCall_1_ELEMENT_TYPE = associate(CrossReferenceableTerminalFactory.createCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType());

	private static class ParenthesizedElementFactory {
		public static IGrammarAwareElementType createParenthesizedElementElementType() {
			return new IGrammarAwareElementType("ParenthesizedElement_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedElementRule());
		}
		public static IGrammarAwareElementType createParenthesizedElement_GroupElementType() {
			return new IGrammarAwareElementType("ParenthesizedElement_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createParenthesizedElement_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("ParenthesizedElement_LeftParenthesisKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParenthesizedElement_AlternativesParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ParenthesizedElement_AlternativesParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedElementAccess().getAlternativesParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParenthesizedElement_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("ParenthesizedElement_RightParenthesisKeyword_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedElementAccess().getRightParenthesisKeyword_2());
		}
	}

	public static final IGrammarAwareElementType ParenthesizedElement_ELEMENT_TYPE = associate(ParenthesizedElementFactory.createParenthesizedElementElementType());

	public static final IGrammarAwareElementType ParenthesizedElement_Group_ELEMENT_TYPE = associate(ParenthesizedElementFactory.createParenthesizedElement_GroupElementType());

	public static final IGrammarAwareElementType ParenthesizedElement_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParenthesizedElementFactory.createParenthesizedElement_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType ParenthesizedElement_AlternativesParserRuleCall_1_ELEMENT_TYPE = associate(ParenthesizedElementFactory.createParenthesizedElement_AlternativesParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType ParenthesizedElement_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParenthesizedElementFactory.createParenthesizedElement_RightParenthesisKeyword_2ElementType());

	private static class TerminalRuleFactory {
		public static IGrammarAwareElementType createTerminalRuleElementType() {
			return new IGrammarAwareElementType("TerminalRule_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleRule());
		}
		public static IGrammarAwareElementType createTerminalRule_GroupElementType() {
			return new IGrammarAwareElementType("TerminalRule_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createTerminalRule_TerminalKeyword_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_TerminalKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getTerminalKeyword_0());
		}
		public static IGrammarAwareElementType createTerminalRule_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("TerminalRule_NameAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createTerminalRule_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTerminalRule_Group_2ElementType() {
			return new IGrammarAwareElementType("TerminalRule_Group_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createTerminalRule_ReturnsKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_ReturnsKeyword_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getReturnsKeyword_2_0());
		}
		public static IGrammarAwareElementType createTerminalRule_TypeAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("TerminalRule_TypeAssignment_2_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getTypeAssignment_2_1());
		}
		public static IGrammarAwareElementType createTerminalRule_TypeTypeRefParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_TypeTypeRefParserRuleCall_2_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createTerminalRule_ColonKeyword_3ElementType() {
			return new IGrammarAwareElementType("TerminalRule_ColonKeyword_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getColonKeyword_3());
		}
		public static IGrammarAwareElementType createTerminalRule_AlternativesAssignment_4ElementType() {
			return new IGrammarAwareElementType("TerminalRule_AlternativesAssignment_4_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getAlternativesAssignment_4());
		}
		public static IGrammarAwareElementType createTerminalRule_AlternativesTerminalAlternativesParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("TerminalRule_AlternativesTerminalAlternativesParserRuleCall_4_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createTerminalRule_SemicolonKeyword_5ElementType() {
			return new IGrammarAwareElementType("TerminalRule_SemicolonKeyword_5_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalRuleAccess().getSemicolonKeyword_5());
		}
	}

	public static final IGrammarAwareElementType TerminalRule_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRuleElementType());

	public static final IGrammarAwareElementType TerminalRule_Group_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_GroupElementType());

	public static final IGrammarAwareElementType TerminalRule_TerminalKeyword_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_TerminalKeyword_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_NameAssignment_1_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType TerminalRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_Group_2_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_Group_2ElementType());

	public static final IGrammarAwareElementType TerminalRule_ReturnsKeyword_2_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_ReturnsKeyword_2_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_TypeAssignment_2_1_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_TypeAssignment_2_1ElementType());

	public static final IGrammarAwareElementType TerminalRule_TypeTypeRefParserRuleCall_2_1_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_TypeTypeRefParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_ColonKeyword_3_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_ColonKeyword_3ElementType());

	public static final IGrammarAwareElementType TerminalRule_AlternativesAssignment_4_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_AlternativesAssignment_4ElementType());

	public static final IGrammarAwareElementType TerminalRule_AlternativesTerminalAlternativesParserRuleCall_4_0_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_AlternativesTerminalAlternativesParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType TerminalRule_SemicolonKeyword_5_ELEMENT_TYPE = associate(TerminalRuleFactory.createTerminalRule_SemicolonKeyword_5ElementType());

	private static class TerminalAlternativesFactory {
		public static IGrammarAwareElementType createTerminalAlternativesElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesRule());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_GroupElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getGroup());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_TerminalGroupParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_Group_1ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_Group_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_AlternativesGroupsAction_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_AlternativesGroupsAction_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_Group_1_1ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_Group_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_GroupsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_GroupsAssignment_1_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getGroupsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createTerminalAlternatives_GroupsTerminalGroupParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalAlternatives_GroupsTerminalGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType TerminalAlternatives_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternativesElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_Group_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_GroupElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_TerminalGroupParserRuleCall_0_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_Group_1_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_Group_1ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_AlternativesGroupsAction_1_0_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_AlternativesGroupsAction_1_0ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_Group_1_1_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_Group_1_1ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_GroupsAssignment_1_1_1_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_GroupsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType TerminalAlternatives_GroupsTerminalGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(TerminalAlternativesFactory.createTerminalAlternatives_GroupsTerminalGroupParserRuleCall_1_1_1_0ElementType());

	private static class TerminalGroupFactory {
		public static IGrammarAwareElementType createTerminalGroupElementType() {
			return new IGrammarAwareElementType("TerminalGroup_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupRule());
		}
		public static IGrammarAwareElementType createTerminalGroup_GroupElementType() {
			return new IGrammarAwareElementType("TerminalGroup_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getGroup());
		}
		public static IGrammarAwareElementType createTerminalGroup_TerminalTokenParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("TerminalGroup_TerminalTokenParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerminalGroup_Group_1ElementType() {
			return new IGrammarAwareElementType("TerminalGroup_Group_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createTerminalGroup_GroupTokensAction_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalGroup_GroupTokensAction_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getGroupTokensAction_1_0());
		}
		public static IGrammarAwareElementType createTerminalGroup_TokensAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("TerminalGroup_TokensAssignment_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getTokensAssignment_1_1());
		}
		public static IGrammarAwareElementType createTerminalGroup_TokensTerminalTokenParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalGroup_TokensTerminalTokenParserRuleCall_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType TerminalGroup_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroupElementType());

	public static final IGrammarAwareElementType TerminalGroup_Group_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_GroupElementType());

	public static final IGrammarAwareElementType TerminalGroup_TerminalTokenParserRuleCall_0_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_TerminalTokenParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType TerminalGroup_Group_1_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_Group_1ElementType());

	public static final IGrammarAwareElementType TerminalGroup_GroupTokensAction_1_0_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_GroupTokensAction_1_0ElementType());

	public static final IGrammarAwareElementType TerminalGroup_TokensAssignment_1_1_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_TokensAssignment_1_1ElementType());

	public static final IGrammarAwareElementType TerminalGroup_TokensTerminalTokenParserRuleCall_1_1_0_ELEMENT_TYPE = associate(TerminalGroupFactory.createTerminalGroup_TokensTerminalTokenParserRuleCall_1_1_0ElementType());

	private static class TerminalTokenFactory {
		public static IGrammarAwareElementType createTerminalTokenElementType() {
			return new IGrammarAwareElementType("TerminalToken_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenRule());
		}
		public static IGrammarAwareElementType createTerminalToken_GroupElementType() {
			return new IGrammarAwareElementType("TerminalToken_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenAccess().getGroup());
		}
		public static IGrammarAwareElementType createTerminalToken_TerminalTokenElementParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("TerminalToken_TerminalTokenElementParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerminalToken_CardinalityAssignment_1ElementType() {
			return new IGrammarAwareElementType("TerminalToken_CardinalityAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenAccess().getCardinalityAssignment_1());
		}
		public static IGrammarAwareElementType createTerminalToken_CardinalityAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("TerminalToken_CardinalityAlternatives_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenAccess().getCardinalityAlternatives_1_0());
		}
		public static IGrammarAwareElementType createTerminalToken_CardinalityQuestionMarkKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("TerminalToken_CardinalityQuestionMarkKeyword_1_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createTerminalToken_CardinalityAsteriskKeyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("TerminalToken_CardinalityAsteriskKeyword_1_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1());
		}
		public static IGrammarAwareElementType createTerminalToken_CardinalityPlusSignKeyword_1_0_2ElementType() {
			return new IGrammarAwareElementType("TerminalToken_CardinalityPlusSignKeyword_1_0_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2());
		}
	}

	public static final IGrammarAwareElementType TerminalToken_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalTokenElementType());

	public static final IGrammarAwareElementType TerminalToken_Group_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalToken_GroupElementType());

	public static final IGrammarAwareElementType TerminalToken_TerminalTokenElementParserRuleCall_0_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalToken_TerminalTokenElementParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType TerminalToken_CardinalityAssignment_1_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalToken_CardinalityAssignment_1ElementType());

	public static final IGrammarAwareElementType TerminalToken_CardinalityAlternatives_1_0_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalToken_CardinalityAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType TerminalToken_CardinalityQuestionMarkKeyword_1_0_0_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalToken_CardinalityQuestionMarkKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType TerminalToken_CardinalityAsteriskKeyword_1_0_1_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalToken_CardinalityAsteriskKeyword_1_0_1ElementType());

	public static final IGrammarAwareElementType TerminalToken_CardinalityPlusSignKeyword_1_0_2_ELEMENT_TYPE = associate(TerminalTokenFactory.createTerminalToken_CardinalityPlusSignKeyword_1_0_2ElementType());

	private static class TerminalTokenElementFactory {
		public static IGrammarAwareElementType createTerminalTokenElementElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementRule());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_AlternativesElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_Alternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_CharacterRangeParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_RuleCallParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_RuleCallParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_AbstractNegatedTokenParserRuleCall_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3());
		}
		public static IGrammarAwareElementType createTerminalTokenElement_WildcardParserRuleCall_4ElementType() {
			return new IGrammarAwareElementType("TerminalTokenElement_WildcardParserRuleCall_4_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTerminalTokenElementAccess().getWildcardParserRuleCall_4());
		}
	}

	public static final IGrammarAwareElementType TerminalTokenElement_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElementElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_Alternatives_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_AlternativesElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_CharacterRangeParserRuleCall_0_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_RuleCallParserRuleCall_1_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_RuleCallParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_AbstractNegatedTokenParserRuleCall_3_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType TerminalTokenElement_WildcardParserRuleCall_4_ELEMENT_TYPE = associate(TerminalTokenElementFactory.createTerminalTokenElement_WildcardParserRuleCall_4ElementType());

	private static class ParenthesizedTerminalElementFactory {
		public static IGrammarAwareElementType createParenthesizedTerminalElementElementType() {
			return new IGrammarAwareElementType("ParenthesizedTerminalElement_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedTerminalElementRule());
		}
		public static IGrammarAwareElementType createParenthesizedTerminalElement_GroupElementType() {
			return new IGrammarAwareElementType("ParenthesizedTerminalElement_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedTerminalElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("ParenthesizedTerminalElement_LeftParenthesisKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParenthesizedTerminalElement_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("ParenthesizedTerminalElement_RightParenthesisKeyword_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2());
		}
	}

	public static final IGrammarAwareElementType ParenthesizedTerminalElement_ELEMENT_TYPE = associate(ParenthesizedTerminalElementFactory.createParenthesizedTerminalElementElementType());

	public static final IGrammarAwareElementType ParenthesizedTerminalElement_Group_ELEMENT_TYPE = associate(ParenthesizedTerminalElementFactory.createParenthesizedTerminalElement_GroupElementType());

	public static final IGrammarAwareElementType ParenthesizedTerminalElement_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParenthesizedTerminalElementFactory.createParenthesizedTerminalElement_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType ParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1_ELEMENT_TYPE = associate(ParenthesizedTerminalElementFactory.createParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType ParenthesizedTerminalElement_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParenthesizedTerminalElementFactory.createParenthesizedTerminalElement_RightParenthesisKeyword_2ElementType());

	private static class AbstractNegatedTokenFactory {
		public static IGrammarAwareElementType createAbstractNegatedTokenElementType() {
			return new IGrammarAwareElementType("AbstractNegatedToken_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractNegatedTokenRule());
		}
		public static IGrammarAwareElementType createAbstractNegatedToken_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractNegatedToken_Alternatives_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractNegatedTokenAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractNegatedToken_NegatedTokenParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractNegatedToken_UntilTokenParserRuleCall_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractNegatedToken_ELEMENT_TYPE = associate(AbstractNegatedTokenFactory.createAbstractNegatedTokenElementType());

	public static final IGrammarAwareElementType AbstractNegatedToken_Alternatives_ELEMENT_TYPE = associate(AbstractNegatedTokenFactory.createAbstractNegatedToken_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractNegatedToken_NegatedTokenParserRuleCall_0_ELEMENT_TYPE = associate(AbstractNegatedTokenFactory.createAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractNegatedToken_UntilTokenParserRuleCall_1_ELEMENT_TYPE = associate(AbstractNegatedTokenFactory.createAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType());

	private static class NegatedTokenFactory {
		public static IGrammarAwareElementType createNegatedTokenElementType() {
			return new IGrammarAwareElementType("NegatedToken_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNegatedTokenRule());
		}
		public static IGrammarAwareElementType createNegatedToken_GroupElementType() {
			return new IGrammarAwareElementType("NegatedToken_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNegatedTokenAccess().getGroup());
		}
		public static IGrammarAwareElementType createNegatedToken_ExclamationMarkKeyword_0ElementType() {
			return new IGrammarAwareElementType("NegatedToken_ExclamationMarkKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNegatedTokenAccess().getExclamationMarkKeyword_0());
		}
		public static IGrammarAwareElementType createNegatedToken_TerminalAssignment_1ElementType() {
			return new IGrammarAwareElementType("NegatedToken_TerminalAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNegatedTokenAccess().getTerminalAssignment_1());
		}
		public static IGrammarAwareElementType createNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType NegatedToken_ELEMENT_TYPE = associate(NegatedTokenFactory.createNegatedTokenElementType());

	public static final IGrammarAwareElementType NegatedToken_Group_ELEMENT_TYPE = associate(NegatedTokenFactory.createNegatedToken_GroupElementType());

	public static final IGrammarAwareElementType NegatedToken_ExclamationMarkKeyword_0_ELEMENT_TYPE = associate(NegatedTokenFactory.createNegatedToken_ExclamationMarkKeyword_0ElementType());

	public static final IGrammarAwareElementType NegatedToken_TerminalAssignment_1_ELEMENT_TYPE = associate(NegatedTokenFactory.createNegatedToken_TerminalAssignment_1ElementType());

	public static final IGrammarAwareElementType NegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0_ELEMENT_TYPE = associate(NegatedTokenFactory.createNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());

	private static class UntilTokenFactory {
		public static IGrammarAwareElementType createUntilTokenElementType() {
			return new IGrammarAwareElementType("UntilToken_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUntilTokenRule());
		}
		public static IGrammarAwareElementType createUntilToken_GroupElementType() {
			return new IGrammarAwareElementType("UntilToken_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUntilTokenAccess().getGroup());
		}
		public static IGrammarAwareElementType createUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("UntilToken_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0());
		}
		public static IGrammarAwareElementType createUntilToken_TerminalAssignment_1ElementType() {
			return new IGrammarAwareElementType("UntilToken_TerminalAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUntilTokenAccess().getTerminalAssignment_1());
		}
		public static IGrammarAwareElementType createUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("UntilToken_TerminalTerminalTokenElementParserRuleCall_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType UntilToken_ELEMENT_TYPE = associate(UntilTokenFactory.createUntilTokenElementType());

	public static final IGrammarAwareElementType UntilToken_Group_ELEMENT_TYPE = associate(UntilTokenFactory.createUntilToken_GroupElementType());

	public static final IGrammarAwareElementType UntilToken_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE = associate(UntilTokenFactory.createUntilToken_HyphenMinusGreaterThanSignKeyword_0ElementType());

	public static final IGrammarAwareElementType UntilToken_TerminalAssignment_1_ELEMENT_TYPE = associate(UntilTokenFactory.createUntilToken_TerminalAssignment_1ElementType());

	public static final IGrammarAwareElementType UntilToken_TerminalTerminalTokenElementParserRuleCall_1_0_ELEMENT_TYPE = associate(UntilTokenFactory.createUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType());

	private static class WildcardFactory {
		public static IGrammarAwareElementType createWildcardElementType() {
			return new IGrammarAwareElementType("Wildcard_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWildcardRule());
		}
		public static IGrammarAwareElementType createWildcard_GroupElementType() {
			return new IGrammarAwareElementType("Wildcard_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWildcardAccess().getGroup());
		}
		public static IGrammarAwareElementType createWildcard_WildcardAction_0ElementType() {
			return new IGrammarAwareElementType("Wildcard_WildcardAction_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWildcardAccess().getWildcardAction_0());
		}
		public static IGrammarAwareElementType createWildcard_FullStopKeyword_1ElementType() {
			return new IGrammarAwareElementType("Wildcard_FullStopKeyword_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWildcardAccess().getFullStopKeyword_1());
		}
	}

	public static final IGrammarAwareElementType Wildcard_ELEMENT_TYPE = associate(WildcardFactory.createWildcardElementType());

	public static final IGrammarAwareElementType Wildcard_Group_ELEMENT_TYPE = associate(WildcardFactory.createWildcard_GroupElementType());

	public static final IGrammarAwareElementType Wildcard_WildcardAction_0_ELEMENT_TYPE = associate(WildcardFactory.createWildcard_WildcardAction_0ElementType());

	public static final IGrammarAwareElementType Wildcard_FullStopKeyword_1_ELEMENT_TYPE = associate(WildcardFactory.createWildcard_FullStopKeyword_1ElementType());

	private static class CharacterRangeFactory {
		public static IGrammarAwareElementType createCharacterRangeElementType() {
			return new IGrammarAwareElementType("CharacterRange_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeRule());
		}
		public static IGrammarAwareElementType createCharacterRange_GroupElementType() {
			return new IGrammarAwareElementType("CharacterRange_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getGroup());
		}
		public static IGrammarAwareElementType createCharacterRange_KeywordParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("CharacterRange_KeywordParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getKeywordParserRuleCall_0());
		}
		public static IGrammarAwareElementType createCharacterRange_Group_1ElementType() {
			return new IGrammarAwareElementType("CharacterRange_Group_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createCharacterRange_CharacterRangeLeftAction_1_0ElementType() {
			return new IGrammarAwareElementType("CharacterRange_CharacterRangeLeftAction_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0());
		}
		public static IGrammarAwareElementType createCharacterRange_FullStopFullStopKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("CharacterRange_FullStopFullStopKeyword_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1());
		}
		public static IGrammarAwareElementType createCharacterRange_RightAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("CharacterRange_RightAssignment_1_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getRightAssignment_1_2());
		}
		public static IGrammarAwareElementType createCharacterRange_RightKeywordParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("CharacterRange_RightKeywordParserRuleCall_1_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0());
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
			return new IGrammarAwareElementType("EnumRule_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleRule());
		}
		public static IGrammarAwareElementType createEnumRule_GroupElementType() {
			return new IGrammarAwareElementType("EnumRule_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createEnumRule_EnumKeyword_0ElementType() {
			return new IGrammarAwareElementType("EnumRule_EnumKeyword_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getEnumKeyword_0());
		}
		public static IGrammarAwareElementType createEnumRule_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("EnumRule_NameAssignment_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createEnumRule_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("EnumRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createEnumRule_Group_2ElementType() {
			return new IGrammarAwareElementType("EnumRule_Group_2_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createEnumRule_ReturnsKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("EnumRule_ReturnsKeyword_2_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getReturnsKeyword_2_0());
		}
		public static IGrammarAwareElementType createEnumRule_TypeAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("EnumRule_TypeAssignment_2_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getTypeAssignment_2_1());
		}
		public static IGrammarAwareElementType createEnumRule_TypeTypeRefParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("EnumRule_TypeTypeRefParserRuleCall_2_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createEnumRule_ColonKeyword_3ElementType() {
			return new IGrammarAwareElementType("EnumRule_ColonKeyword_3_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getColonKeyword_3());
		}
		public static IGrammarAwareElementType createEnumRule_AlternativesAssignment_4ElementType() {
			return new IGrammarAwareElementType("EnumRule_AlternativesAssignment_4_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getAlternativesAssignment_4());
		}
		public static IGrammarAwareElementType createEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("EnumRule_AlternativesEnumLiteralsParserRuleCall_4_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createEnumRule_SemicolonKeyword_5ElementType() {
			return new IGrammarAwareElementType("EnumRule_SemicolonKeyword_5_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRuleAccess().getSemicolonKeyword_5());
		}
	}

	public static final IGrammarAwareElementType EnumRule_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRuleElementType());

	public static final IGrammarAwareElementType EnumRule_Group_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_GroupElementType());

	public static final IGrammarAwareElementType EnumRule_EnumKeyword_0_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_EnumKeyword_0ElementType());

	public static final IGrammarAwareElementType EnumRule_NameAssignment_1_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType EnumRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType EnumRule_Group_2_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_Group_2ElementType());

	public static final IGrammarAwareElementType EnumRule_ReturnsKeyword_2_0_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_ReturnsKeyword_2_0ElementType());

	public static final IGrammarAwareElementType EnumRule_TypeAssignment_2_1_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_TypeAssignment_2_1ElementType());

	public static final IGrammarAwareElementType EnumRule_TypeTypeRefParserRuleCall_2_1_0_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_TypeTypeRefParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType EnumRule_ColonKeyword_3_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_ColonKeyword_3ElementType());

	public static final IGrammarAwareElementType EnumRule_AlternativesAssignment_4_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_AlternativesAssignment_4ElementType());

	public static final IGrammarAwareElementType EnumRule_AlternativesEnumLiteralsParserRuleCall_4_0_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType EnumRule_SemicolonKeyword_5_ELEMENT_TYPE = associate(EnumRuleFactory.createEnumRule_SemicolonKeyword_5ElementType());

	private static class EnumLiteralsFactory {
		public static IGrammarAwareElementType createEnumLiteralsElementType() {
			return new IGrammarAwareElementType("EnumLiterals_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsRule());
		}
		public static IGrammarAwareElementType createEnumLiterals_GroupElementType() {
			return new IGrammarAwareElementType("EnumLiterals_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getGroup());
		}
		public static IGrammarAwareElementType createEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_EnumLiteralDeclarationParserRuleCall_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0());
		}
		public static IGrammarAwareElementType createEnumLiterals_Group_1ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_Group_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createEnumLiterals_AlternativesGroupsAction_1_0ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_AlternativesGroupsAction_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0());
		}
		public static IGrammarAwareElementType createEnumLiterals_Group_1_1ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_Group_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createEnumLiterals_VerticalLineKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_VerticalLineKeyword_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createEnumLiterals_GroupsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_GroupsAssignment_1_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getGroupsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createEnumLiterals_GroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("EnumLiterals_GroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType EnumLiterals_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiteralsElementType());

	public static final IGrammarAwareElementType EnumLiterals_Group_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_GroupElementType());

	public static final IGrammarAwareElementType EnumLiterals_EnumLiteralDeclarationParserRuleCall_0_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType EnumLiterals_Group_1_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_Group_1ElementType());

	public static final IGrammarAwareElementType EnumLiterals_AlternativesGroupsAction_1_0_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_AlternativesGroupsAction_1_0ElementType());

	public static final IGrammarAwareElementType EnumLiterals_Group_1_1_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_Group_1_1ElementType());

	public static final IGrammarAwareElementType EnumLiterals_VerticalLineKeyword_1_1_0_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_VerticalLineKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType EnumLiterals_GroupsAssignment_1_1_1_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_GroupsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType EnumLiterals_GroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(EnumLiteralsFactory.createEnumLiterals_GroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType());

	private static class EnumLiteralDeclarationFactory {
		public static IGrammarAwareElementType createEnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationRule());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_GroupElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_Group_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getGroup());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_EnumLiteralAssignment_0ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_EnumLiteralAssignment_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_EnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_EnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_Group_1ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_Group_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_EqualsSignKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_EqualsSignKeyword_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_LiteralAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_LiteralAssignment_1_1_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1());
		}
		public static IGrammarAwareElementType createEnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("EnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0_ELEMENT_TYPE", XtextTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0());
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

	public IGrammarAwareElementType getGrammar_Group_3ElementType() {
		return Grammar_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_DefinesHiddenTokensAssignment_3_0ElementType() {
		return Grammar_DefinesHiddenTokensAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_DefinesHiddenTokensHiddenKeyword_3_0_0ElementType() {
		return Grammar_DefinesHiddenTokensHiddenKeyword_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_LeftParenthesisKeyword_3_1ElementType() {
		return Grammar_LeftParenthesisKeyword_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_Group_3_2ElementType() {
		return Grammar_Group_3_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_HiddenTokensAssignment_3_2_0ElementType() {
		return Grammar_HiddenTokensAssignment_3_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0ElementType() {
		return Grammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1ElementType() {
		return Grammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_Group_3_2_1ElementType() {
		return Grammar_Group_3_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_CommaKeyword_3_2_1_0ElementType() {
		return Grammar_CommaKeyword_3_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_HiddenTokensAssignment_3_2_1_1ElementType() {
		return Grammar_HiddenTokensAssignment_3_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_1_1_0ElementType() {
		return Grammar_HiddenTokensAbstractRuleCrossReference_3_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1ElementType() {
		return Grammar_HiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGrammar_RightParenthesisKeyword_3_3ElementType() {
		return Grammar_RightParenthesisKeyword_3_3_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getParserRule_NameAssignment_0ElementType() {
		return ParserRule_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_NameIDTerminalRuleCall_0_0ElementType() {
		return ParserRule_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_Group_1ElementType() {
		return ParserRule_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_ReturnsKeyword_1_0ElementType() {
		return ParserRule_ReturnsKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_TypeAssignment_1_1ElementType() {
		return ParserRule_TypeAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_TypeTypeRefParserRuleCall_1_1_0ElementType() {
		return ParserRule_TypeTypeRefParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_Group_2ElementType() {
		return ParserRule_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_DefinesHiddenTokensAssignment_2_0ElementType() {
		return ParserRule_DefinesHiddenTokensAssignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_DefinesHiddenTokensHiddenKeyword_2_0_0ElementType() {
		return ParserRule_DefinesHiddenTokensHiddenKeyword_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_LeftParenthesisKeyword_2_1ElementType() {
		return ParserRule_LeftParenthesisKeyword_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_Group_2_2ElementType() {
		return ParserRule_Group_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_HiddenTokensAssignment_2_2_0ElementType() {
		return ParserRule_HiddenTokensAssignment_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_HiddenTokensAbstractRuleCrossReference_2_2_0_0ElementType() {
		return ParserRule_HiddenTokensAbstractRuleCrossReference_2_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1ElementType() {
		return ParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_Group_2_2_1ElementType() {
		return ParserRule_Group_2_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_CommaKeyword_2_2_1_0ElementType() {
		return ParserRule_CommaKeyword_2_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_HiddenTokensAssignment_2_2_1_1ElementType() {
		return ParserRule_HiddenTokensAssignment_2_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_HiddenTokensAbstractRuleCrossReference_2_2_1_1_0ElementType() {
		return ParserRule_HiddenTokensAbstractRuleCrossReference_2_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1ElementType() {
		return ParserRule_HiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_RightParenthesisKeyword_2_3ElementType() {
		return ParserRule_RightParenthesisKeyword_2_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_ColonKeyword_3ElementType() {
		return ParserRule_ColonKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_AlternativesAssignment_4ElementType() {
		return ParserRule_AlternativesAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_AlternativesAlternativesParserRuleCall_4_0ElementType() {
		return ParserRule_AlternativesAlternativesParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRule_SemicolonKeyword_5ElementType() {
		return ParserRule_SemicolonKeyword_5_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getAlternatives_GroupParserRuleCall_0ElementType() {
		return Alternatives_GroupParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_Group_1ElementType() {
		return Alternatives_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_AlternativesGroupsAction_1_0ElementType() {
		return Alternatives_AlternativesGroupsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_Group_1_1ElementType() {
		return Alternatives_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_VerticalLineKeyword_1_1_0ElementType() {
		return Alternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_GroupsAssignment_1_1_1ElementType() {
		return Alternatives_GroupsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlternatives_GroupsGroupParserRuleCall_1_1_1_0ElementType() {
		return Alternatives_GroupsGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getGroup_GroupTokensAction_1_0ElementType() {
		return Group_GroupTokensAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroup_TokensAssignment_1_1ElementType() {
		return Group_TokensAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGroup_TokensAbstractTokenParserRuleCall_1_1_0ElementType() {
		return Group_TokensAbstractTokenParserRuleCall_1_1_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getAbstractTokenWithCardinality_CardinalityAssignment_1ElementType() {
		return AbstractTokenWithCardinality_CardinalityAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenWithCardinality_CardinalityAlternatives_1_0ElementType() {
		return AbstractTokenWithCardinality_CardinalityAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenWithCardinality_CardinalityQuestionMarkKeyword_1_0_0ElementType() {
		return AbstractTokenWithCardinality_CardinalityQuestionMarkKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenWithCardinality_CardinalityAsteriskKeyword_1_0_1ElementType() {
		return AbstractTokenWithCardinality_CardinalityAsteriskKeyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractTokenWithCardinality_CardinalityPlusSignKeyword_1_0_2ElementType() {
		return AbstractTokenWithCardinality_CardinalityPlusSignKeyword_1_0_2_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getRuleCall_RuleAssignmentElementType() {
		return RuleCall_RuleAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_RuleAbstractRuleCrossReference_0ElementType() {
		return RuleCall_RuleAbstractRuleCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCall_RuleAbstractRuleIDTerminalRuleCall_0_1ElementType() {
		return RuleCall_RuleAbstractRuleIDTerminalRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentElementType() {
		return Assignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_GroupElementType() {
		return Assignment_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_FeatureAssignment_0ElementType() {
		return Assignment_FeatureAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_FeatureIDTerminalRuleCall_0_0ElementType() {
		return Assignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_OperatorAssignment_1ElementType() {
		return Assignment_OperatorAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_OperatorAlternatives_1_0ElementType() {
		return Assignment_OperatorAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_OperatorPlusSignEqualsSignKeyword_1_0_0ElementType() {
		return Assignment_OperatorPlusSignEqualsSignKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_OperatorEqualsSignKeyword_1_0_1ElementType() {
		return Assignment_OperatorEqualsSignKeyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_OperatorQuestionMarkEqualsSignKeyword_1_0_2ElementType() {
		return Assignment_OperatorQuestionMarkEqualsSignKeyword_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_TerminalAssignment_2ElementType() {
		return Assignment_TerminalAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_TerminalAssignableTerminalParserRuleCall_2_0ElementType() {
		return Assignment_TerminalAssignableTerminalParserRuleCall_2_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getAssignableAlternatives_AlternativesGroupsAction_1_0ElementType() {
		return AssignableAlternatives_AlternativesGroupsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_Group_1_1ElementType() {
		return AssignableAlternatives_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_VerticalLineKeyword_1_1_0ElementType() {
		return AssignableAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_GroupsAssignment_1_1_1ElementType() {
		return AssignableAlternatives_GroupsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignableAlternatives_GroupsAssignableTerminalParserRuleCall_1_1_1_0ElementType() {
		return AssignableAlternatives_GroupsAssignableTerminalParserRuleCall_1_1_1_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getTerminalRuleElementType() {
		return TerminalRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_GroupElementType() {
		return TerminalRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_TerminalKeyword_0ElementType() {
		return TerminalRule_TerminalKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_NameAssignment_1ElementType() {
		return TerminalRule_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_NameIDTerminalRuleCall_1_0ElementType() {
		return TerminalRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_Group_2ElementType() {
		return TerminalRule_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_ReturnsKeyword_2_0ElementType() {
		return TerminalRule_ReturnsKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_TypeAssignment_2_1ElementType() {
		return TerminalRule_TypeAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_TypeTypeRefParserRuleCall_2_1_0ElementType() {
		return TerminalRule_TypeTypeRefParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_ColonKeyword_3ElementType() {
		return TerminalRule_ColonKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_AlternativesAssignment_4ElementType() {
		return TerminalRule_AlternativesAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_AlternativesTerminalAlternativesParserRuleCall_4_0ElementType() {
		return TerminalRule_AlternativesTerminalAlternativesParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalRule_SemicolonKeyword_5ElementType() {
		return TerminalRule_SemicolonKeyword_5_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getTerminalAlternatives_AlternativesGroupsAction_1_0ElementType() {
		return TerminalAlternatives_AlternativesGroupsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_Group_1_1ElementType() {
		return TerminalAlternatives_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_VerticalLineKeyword_1_1_0ElementType() {
		return TerminalAlternatives_VerticalLineKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_GroupsAssignment_1_1_1ElementType() {
		return TerminalAlternatives_GroupsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalAlternatives_GroupsTerminalGroupParserRuleCall_1_1_1_0ElementType() {
		return TerminalAlternatives_GroupsTerminalGroupParserRuleCall_1_1_1_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getTerminalGroup_GroupTokensAction_1_0ElementType() {
		return TerminalGroup_GroupTokensAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalGroup_TokensAssignment_1_1ElementType() {
		return TerminalGroup_TokensAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalGroup_TokensTerminalTokenParserRuleCall_1_1_0ElementType() {
		return TerminalGroup_TokensTerminalTokenParserRuleCall_1_1_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getTerminalToken_CardinalityAssignment_1ElementType() {
		return TerminalToken_CardinalityAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalToken_CardinalityAlternatives_1_0ElementType() {
		return TerminalToken_CardinalityAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalToken_CardinalityQuestionMarkKeyword_1_0_0ElementType() {
		return TerminalToken_CardinalityQuestionMarkKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalToken_CardinalityAsteriskKeyword_1_0_1ElementType() {
		return TerminalToken_CardinalityAsteriskKeyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerminalToken_CardinalityPlusSignKeyword_1_0_2ElementType() {
		return TerminalToken_CardinalityPlusSignKeyword_1_0_2_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getTerminalTokenElement_RuleCallParserRuleCall_1ElementType() {
		return TerminalTokenElement_RuleCallParserRuleCall_1_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getEnumRule_Group_2ElementType() {
		return EnumRule_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_ReturnsKeyword_2_0ElementType() {
		return EnumRule_ReturnsKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_TypeAssignment_2_1ElementType() {
		return EnumRule_TypeAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumRule_TypeTypeRefParserRuleCall_2_1_0ElementType() {
		return EnumRule_TypeTypeRefParserRuleCall_2_1_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getEnumLiterals_AlternativesGroupsAction_1_0ElementType() {
		return EnumLiterals_AlternativesGroupsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_Group_1_1ElementType() {
		return EnumLiterals_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_VerticalLineKeyword_1_1_0ElementType() {
		return EnumLiterals_VerticalLineKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_GroupsAssignment_1_1_1ElementType() {
		return EnumLiterals_GroupsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumLiterals_GroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType() {
		return EnumLiterals_GroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0_ELEMENT_TYPE;
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
