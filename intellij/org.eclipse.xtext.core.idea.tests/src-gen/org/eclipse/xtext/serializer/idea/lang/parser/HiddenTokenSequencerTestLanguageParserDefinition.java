package org.eclipse.xtext.serializer.idea.lang.parser;

import org.eclipse.xtext.serializer.idea.lang.psi.impl.HiddenTokenSequencerTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class HiddenTokenSequencerTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private HiddenTokenSequencerTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new HiddenTokenSequencerTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			IElementType elementType = node.getElementType();
			if (elementType == elementTypeProvider.getModelElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getModel_DomainModelDomainModelParserRuleCall_0ElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getDomainModelElementType()) {
				return new PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getDomainModel_EntitiesEntityParserRuleCall_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getEntityElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			throw new IllegalStateException("Unexpected element type: " + elementType);
		}
		return super.createElement(node);
	}

}
