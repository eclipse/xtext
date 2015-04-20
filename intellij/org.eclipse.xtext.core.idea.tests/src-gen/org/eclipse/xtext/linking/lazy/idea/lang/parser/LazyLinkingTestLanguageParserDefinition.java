package org.eclipse.xtext.linking.lazy.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.lazy.idea.lang.psi.impl.LazyLinkingTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class LazyLinkingTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private LazyLinkingTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new LazyLinkingTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getModel_TypesTypeParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_PropertiesPropertyParserRuleCall_5_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getProperty_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getUnresolvedProxyProperty_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_ExtendsTypeCrossReference_2_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getType_ParentIdPropertyCrossReference_2_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getType_ParentIdPropertyCrossReference_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getType_ExtendsTypeCrossReference_3_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getProperty_TypeTypeCrossReference_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getUnresolvedProxyProperty_TypeTypeCrossReference_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
