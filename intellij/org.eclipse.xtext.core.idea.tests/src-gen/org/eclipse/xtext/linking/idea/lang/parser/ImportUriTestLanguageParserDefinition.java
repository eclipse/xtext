package org.eclipse.xtext.linking.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.ImportUriTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class ImportUriTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private ImportUriTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ImportUriTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getType_ExtendsTypeCrossReference_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
