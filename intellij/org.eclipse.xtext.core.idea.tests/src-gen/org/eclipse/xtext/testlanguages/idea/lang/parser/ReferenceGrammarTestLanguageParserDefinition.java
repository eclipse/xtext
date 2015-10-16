package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.ReferenceGrammarTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class ReferenceGrammarTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private ReferenceGrammarTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ReferenceGrammarTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getSpielplatz_KinderKindParserRuleCall_4_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getKind_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getPerson_KindParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getKind_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getSpielplatz_ErzieherErwachsenerParserRuleCall_4_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getErwachsener_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getPerson_ErwachsenerParserRuleCall_1ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getErwachsener_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getSpielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getSpielzeug_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getSpielplatz_FamilieFamilieParserRuleCall_4_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getFamilie_NameSTRINGTerminalRuleCall_2_0_1ElementType(),
				elementTypeProvider.getFamilie_NameIDTerminalRuleCall_2_0_2ElementType()
			);
		}
		if (elementType == elementTypeProvider.getFamilie_MutterErwachsenerCrossReference_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getFamilie_VaterErwachsenerCrossReference_4_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getFamilie_KinderKindCrossReference_5_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getFamilie_KinderKindCrossReference_6_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getSpielplatzElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_SpielplatzKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_GroesseAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_GroesseINTTerminalRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_BeschreibungAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_BeschreibungSTRINGTerminalRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_LeftCurlyBracketKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_Alternatives_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_KinderAssignment_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_ErzieherAssignment_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_SpielzeugeAssignment_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_FamilieAssignment_4_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielplatz_RightCurlyBracketKeyword_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getPersonElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getPerson_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getKindElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getKind_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getKind_KindKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getKind_LeftParenthesisKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getKind_NameAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getKind_NameIDTerminalRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getKind_AgeAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getKind_AgeINTTerminalRuleCall_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getKind_RightParenthesisKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getErwachsenerElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getErwachsener_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getErwachsener_ErwachsenerKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getErwachsener_LeftParenthesisKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getErwachsener_NameAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getErwachsener_NameIDTerminalRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getErwachsener_AgeAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getErwachsener_AgeINTTerminalRuleCall_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getErwachsener_RightParenthesisKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielzeugElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielzeug_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielzeug_SpielzeugKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielzeug_LeftParenthesisKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielzeug_NameAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielzeug_NameIDTerminalRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielzeug_FarbeAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielzeug_FarbeFarbeParserRuleCall_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSpielzeug_RightParenthesisKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFarbeElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFarbe_WertAssignmentElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFarbe_WertAlternatives_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFarbe_WertROTKeyword_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFarbe_WertBLAUKeyword_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFarbe_WertGELBKeyword_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFarbe_WertGRÜNKeyword_0_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilieElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_FamilieKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_LeftParenthesisKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_NameAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_NameAlternatives_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_NameKeywordKeyword_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_NameSTRINGTerminalRuleCall_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_NameIDTerminalRuleCall_2_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_MutterAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_MutterErwachsenerIDTerminalRuleCall_3_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_VaterAssignment_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_VaterErwachsenerIDTerminalRuleCall_4_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_KinderAssignment_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_KinderKindIDTerminalRuleCall_5_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_Group_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_CommaKeyword_6_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_KinderAssignment_6_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_KinderKindIDTerminalRuleCall_6_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFamilie_RightParenthesisKeyword_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		throw new java.lang.IllegalStateException("Unexpected element type: " + elementType);
	}

}
