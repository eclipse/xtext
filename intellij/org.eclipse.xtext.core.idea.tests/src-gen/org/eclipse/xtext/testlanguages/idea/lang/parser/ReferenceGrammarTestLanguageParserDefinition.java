package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.ReferenceGrammarTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageElementTypeProvider;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
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
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			IElementType elementType = node.getElementType();
			if (elementType == elementTypeProvider.getSpielplatzElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getSpielplatz_KinderKindParserRuleCall_4_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getSpielplatz_ErzieherErwachsenerParserRuleCall_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getSpielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getSpielplatz_FamilieFamilieParserRuleCall_4_3_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getPersonElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getPerson_KindParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getPerson_ErwachsenerParserRuleCall_1ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getKindElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getErwachsenerElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getSpielzeugElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getSpielzeug_FarbeFarbeParserRuleCall_3_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getFarbeElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getFamilieElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			throw new IllegalStateException("Unexpected element type: " + elementType);
		}
		return super.createElement(node);
	}

}
