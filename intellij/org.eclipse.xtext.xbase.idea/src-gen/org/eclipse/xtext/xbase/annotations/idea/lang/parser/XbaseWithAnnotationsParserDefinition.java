package org.eclipse.xtext.xbase.annotations.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsElementTypeProvider;
import org.eclipse.xtext.xbase.annotations.idea.lang.psi.impl.XbaseWithAnnotationsFileImpl;
import org.eclipse.xtext.xbase.idea.lang.parser.XbaseParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class XbaseWithAnnotationsParserDefinition extends XbaseParserDefinition {

	@Inject 
	private XbaseWithAnnotationsElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new XbaseWithAnnotationsFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getXAnnotation_AnnotationTypeJvmAnnotationTypeCrossReference_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePair_ElementJvmOperationCrossReference_0_0_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
