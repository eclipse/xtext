package org.eclipse.xtext.linking.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.linking.idea.lang.Bug362902ElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.Bug362902FileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class Bug362902ParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private Bug362902ElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new Bug362902FileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getModel_GreetingsGreetingParserRuleCall_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getGreeting_NameMyIdParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getModel_FavouriteGreetingCrossReference_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
