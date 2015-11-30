package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.XtextTerminalsTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class XtextTerminalsTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private XtextTerminalsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new XtextTerminalsTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			IElementType elementType = node.getElementType();
			if (elementType == elementTypeProvider.getGrammarElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getGrammar_MetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getGrammar_RulesAbstractRuleParserRuleCall_5_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractRuleElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractRule_ParserRuleParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractRule_TerminalRuleParserRuleCall_1ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractRule_EnumRuleParserRuleCall_2ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractMetamodelDeclarationElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractMetamodelDeclaration_ReferencedMetamodelParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getGeneratedMetamodelElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getReferencedMetamodelElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParserRuleElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParserRule_TypeTypeRefParserRuleCall_1_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParserRule_AlternativesAlternativesParserRuleCall_4_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTypeRefElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAlternativesElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAlternatives_GroupParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAlternatives_AlternativesGroupsAction_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAlternatives_GroupsGroupParserRuleCall_1_1_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getGroupElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getGroup_AbstractTokenParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getGroup_GroupTokensAction_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getGroup_TokensAbstractTokenParserRuleCall_1_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractTokenElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractToken_AbstractTokenWithCardinalityParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractToken_ActionParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractTokenWithCardinalityElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractTokenWithCardinality_AssignmentParserRuleCall_0_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractTokenWithCardinality_AbstractTerminalParserRuleCall_0_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getActionElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAction_TypeTypeRefParserRuleCall_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractTerminalElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractTerminal_KeywordParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractTerminal_RuleCallParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractTerminal_ParenthesizedElementParserRuleCall_2ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getKeywordElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRuleCallElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignmentElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignment_TerminalAssignableTerminalParserRuleCall_2_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignableTerminalElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignableTerminal_KeywordParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignableTerminal_RuleCallParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignableTerminal_ParenthesizedAssignableElementParserRuleCall_2ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignableTerminal_CrossReferenceParserRuleCall_3ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParenthesizedAssignableElementElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParenthesizedAssignableElement_AssignableAlternativesParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignableAlternativesElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignableAlternatives_AssignableTerminalParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignableAlternatives_AlternativesGroupsAction_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAssignableAlternatives_GroupsAssignableTerminalParserRuleCall_1_1_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCrossReferenceElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCrossReference_TypeTypeRefParserRuleCall_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCrossReference_TerminalCrossReferenceableTerminalParserRuleCall_2_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCrossReferenceableTerminalElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCrossReferenceableTerminal_KeywordParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCrossReferenceableTerminal_RuleCallParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParenthesizedElementElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParenthesizedElement_AlternativesParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalRuleElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalRule_TypeTypeRefParserRuleCall_2_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalRule_AlternativesTerminalAlternativesParserRuleCall_4_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalAlternativesElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalAlternatives_TerminalGroupParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalAlternatives_AlternativesGroupsAction_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalAlternatives_GroupsTerminalGroupParserRuleCall_1_1_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalGroupElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalGroup_TerminalTokenParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalGroup_GroupTokensAction_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalGroup_TokensTerminalTokenParserRuleCall_1_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalTokenElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalToken_TerminalTokenElementParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalTokenElementElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalTokenElement_CharacterRangeParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalTokenElement_RuleCallParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalTokenElement_ParenthesizedTerminalElementParserRuleCall_2ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalTokenElement_AbstractNegatedTokenParserRuleCall_3ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTerminalTokenElement_WildcardParserRuleCall_4ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParenthesizedTerminalElementElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParenthesizedTerminalElement_TerminalAlternativesParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractNegatedTokenElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractNegatedToken_NegatedTokenParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAbstractNegatedToken_UntilTokenParserRuleCall_1ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getNegatedTokenElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getNegatedToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getUntilTokenElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getUntilToken_TerminalTerminalTokenElementParserRuleCall_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getWildcardElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getWildcard_WildcardAction_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCharacterRangeElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCharacterRange_KeywordParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCharacterRange_CharacterRangeLeftAction_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCharacterRange_RightKeywordParserRuleCall_1_2_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getEnumRuleElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getEnumRule_TypeTypeRefParserRuleCall_2_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getEnumRule_AlternativesEnumLiteralsParserRuleCall_4_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getEnumLiteralsElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getEnumLiterals_EnumLiteralDeclarationParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getEnumLiterals_AlternativesGroupsAction_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getEnumLiterals_GroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getEnumLiteralDeclarationElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getEnumLiteralDeclaration_LiteralKeywordParserRuleCall_1_1_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			throw new IllegalStateException("Unexpected element type: " + elementType);
		}
		return super.createElement(node);
	}

}
