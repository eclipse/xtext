package org.eclipse.xtext.generator.grammarAccess.idea.lang.parser;

import org.eclipse.xtext.generator.grammarAccess.idea.lang.psi.impl.GrammarAccessTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageElementTypeProvider;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class GrammarAccessTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private GrammarAccessTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new GrammarAccessTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			IElementType elementType = node.getElementType();
			if (elementType == elementTypeProvider.getRootElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRoot_ElementsTypeParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTypeElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_ATypeParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_AnotherTypeParserRuleCall_1ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getATypeElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAType_ATypeAction_1ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnotherTypeElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnotherType_AnotherTypeAction_1ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			throw new IllegalStateException("Unexpected element type: " + elementType);
		}
		return super.createElement(node);
	}

}
