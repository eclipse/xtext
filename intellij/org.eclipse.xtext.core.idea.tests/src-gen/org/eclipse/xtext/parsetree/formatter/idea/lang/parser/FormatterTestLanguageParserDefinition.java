package org.eclipse.xtext.parsetree.formatter.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.formatter.idea.lang.psi.impl.FormatterTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class FormatterTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private FormatterTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new FormatterTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getLine_DeclParserRuleCall_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getDecl_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getLine_MethParserRuleCall_0_2ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMeth_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMeth_ParamParamParserRuleCall_3_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getParam_NameIDTerminalRuleCall_0_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMeth_ParamParamParserRuleCall_3_1_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getParam_NameIDTerminalRuleCall_0_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getLine_FqnObjParserRuleCall_0_3ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getFqnObj_NameFQNParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getFqnRef_RefFqnObjCrossReference_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
