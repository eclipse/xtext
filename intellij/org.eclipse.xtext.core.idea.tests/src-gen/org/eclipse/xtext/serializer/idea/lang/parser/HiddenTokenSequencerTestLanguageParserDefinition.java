package org.eclipse.xtext.serializer.idea.lang.parser;

import org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.serializer.idea.lang.psi.impl.HiddenTokenSequencerTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class HiddenTokenSequencerTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private HiddenTokenSequencerTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new HiddenTokenSequencerTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getDomainModel_EntitiesEntityParserRuleCall_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getEntity_NameIDTerminalRuleCall_0_0ElementType()
			);
		}
		return super.createElement(node);
	}

}
