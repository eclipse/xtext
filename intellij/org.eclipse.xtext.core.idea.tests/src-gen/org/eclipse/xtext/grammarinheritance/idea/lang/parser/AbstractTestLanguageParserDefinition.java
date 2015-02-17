package org.eclipse.xtext.grammarinheritance.idea.lang.parser;

import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageElementTypeProvider;
import org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl.AbstractTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class AbstractTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private AbstractTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new AbstractTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getAbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendableParserRule_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		return super.createElement(node);
	}

}
