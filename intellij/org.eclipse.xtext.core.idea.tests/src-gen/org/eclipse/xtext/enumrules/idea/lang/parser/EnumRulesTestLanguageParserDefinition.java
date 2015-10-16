package org.eclipse.xtext.enumrules.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageElementTypeProvider;
import org.eclipse.xtext.enumrules.idea.lang.psi.impl.EnumRulesTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class EnumRulesTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private EnumRulesTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new EnumRulesTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getModelElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_ExistingKeyword_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_ExistingAssignment_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_ExistingExistingEnumEnumRuleCall_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_Group_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_GeneratedKeyword_0_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_GeneratedAssignment_0_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_GeneratedGeneratedEnumEnumRuleCall_0_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_GeneratedKeyword_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_GeneratedAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_GeneratedGeneratedEnumEnumRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExistingEnumElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExistingEnum_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExistingEnum_SameNameEnumLiteralDeclaration_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExistingEnum_SameNameSameNameKeyword_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExistingEnum_OverriddenLiteralEnumLiteralDeclaration_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExistingEnum_OverriddenLiteralOverriddenKeyword_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExistingEnum_DifferentNameEnumLiteralDeclaration_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExistingEnum_DifferentNameDifferentLiteralKeyword_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getGeneratedEnumElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getGeneratedEnum_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getGeneratedEnum_SameNameEnumLiteralDeclaration_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getGeneratedEnum_SameNameSameNameKeyword_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getGeneratedEnum_DifferentNameEnumLiteralDeclaration_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getGeneratedEnum_DifferentNameDifferentLiteralKeyword_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		throw new java.lang.IllegalStateException("Unexpected element type: " + elementType);
	}

}
