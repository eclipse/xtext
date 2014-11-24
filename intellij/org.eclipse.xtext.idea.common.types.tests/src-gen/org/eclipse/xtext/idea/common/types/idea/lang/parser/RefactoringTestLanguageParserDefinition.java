package org.eclipse.xtext.idea.common.types.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.common.types.idea.lang.psi.impl.RefactoringTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class RefactoringTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private RefactoringTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new RefactoringTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getModel_ReferenceHolderReferenceHolderParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node, elementTypeProvider.getReferenceHolder_NameIDTerminalRuleCall_0_0ElementType());
		}
		if (elementType == elementTypeProvider.getReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
