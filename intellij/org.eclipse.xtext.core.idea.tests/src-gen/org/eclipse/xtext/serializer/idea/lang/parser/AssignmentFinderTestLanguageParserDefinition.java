package org.eclipse.xtext.serializer.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageElementTypeProvider;
import org.eclipse.xtext.serializer.idea.lang.psi.impl.AssignmentFinderTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class AssignmentFinderTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private AssignmentFinderTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new AssignmentFinderTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getModel_CrossRefCrossRefParserRuleCall_9_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getCrossRef_NameTerminal1TerminalRuleCall_0_0_0ElementType(),
				elementTypeProvider.getCrossRef_NameTerminal2TerminalRuleCall_0_0_1ElementType()
			);
		}
		if (elementType == elementTypeProvider.getCrossRef_CrossRefCrossRefCrossReference_1_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getCrossRef_CrossRefCrossRefCrossReference_1_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
