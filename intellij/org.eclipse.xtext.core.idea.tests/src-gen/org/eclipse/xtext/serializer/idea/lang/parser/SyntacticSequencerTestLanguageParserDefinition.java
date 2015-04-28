package org.eclipse.xtext.serializer.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.serializer.idea.lang.psi.impl.SyntacticSequencerTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class SyntacticSequencerTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private SyntacticSequencerTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new SyntacticSequencerTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getSingleCrossReference_Ref1SingleCrossReferenceCrossReference_2_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getSingleCrossReference_Ref2SingleCrossReferenceCrossReference_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getSingleCrossReference_Ref3SingleCrossReferenceCrossReference_4_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getSingleCrossReference_Ref4SingleCrossReferenceCrossReference_5_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
