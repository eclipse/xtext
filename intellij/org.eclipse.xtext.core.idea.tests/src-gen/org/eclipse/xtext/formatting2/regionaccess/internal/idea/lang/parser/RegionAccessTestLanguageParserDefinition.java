package org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageElementTypeProvider;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.psi.impl.RegionAccessTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class RegionAccessTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private RegionAccessTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new RegionAccessTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getMixed_RefMixedCrossReference_2_2_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
