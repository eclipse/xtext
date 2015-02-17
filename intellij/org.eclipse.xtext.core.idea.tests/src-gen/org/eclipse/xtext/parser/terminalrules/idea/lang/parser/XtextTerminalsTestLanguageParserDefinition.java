package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.XtextTerminalsTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
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

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new XtextTerminalsTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getAbstractMetamodelDeclaration_GeneratedMetamodelParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getGeneratedMetamodel_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAbstractRule_ParserRuleParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getParserRule_NameIDTerminalRuleCall_0_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAbstractRule_TerminalRuleParserRuleCall_1ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getTerminalRule_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAbstractRule_EnumRuleParserRuleCall_2ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getEnumRule_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getGrammar_UsedGrammarsGrammarCrossReference_2_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getGrammar_UsedGrammarsGrammarCrossReference_2_2_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getGrammar_HiddenTokensAbstractRuleCrossReference_3_2_1_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getGeneratedMetamodel_EPackageEPackageCrossReference_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getReferencedMetamodel_EPackageEPackageCrossReference_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getParserRule_HiddenTokensAbstractRuleCrossReference_2_2_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getParserRule_HiddenTokensAbstractRuleCrossReference_2_2_1_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getTypeRef_MetamodelAbstractMetamodelDeclarationCrossReference_0_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getTypeRef_ClassifierEClassifierCrossReference_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getRuleCall_RuleAbstractRuleCrossReference_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getEnumLiteralDeclaration_EnumLiteralEEnumLiteralCrossReference_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
