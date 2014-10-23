package org.xtext.idea.sdomain.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.xtext.idea.sdomain.idea.lang.SDomainElementTypeProvider;
import org.xtext.idea.sdomain.idea.lang.psi.impl.SDomainFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class SDomainParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private SDomainElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new SDomainFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getElement_NamespaceParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node, elementTypeProvider.getNamespace_NameQualifiedNameParserRuleCall_0_0ElementType());
		}
		if (elementType == elementTypeProvider.getType_EntityParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node, elementTypeProvider.getEntity_NameIDTerminalRuleCall_1_0ElementType());
		}
		if (elementType == elementTypeProvider.getType_DatatypeParserRuleCall_1ElementType()) {
			return new PsiNamedEObjectImpl(node, elementTypeProvider.getDatatype_NameIDTerminalRuleCall_1_0ElementType());
		}
		if (elementType == elementTypeProvider.getEntity_PropertiesPropertyParserRuleCall_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node, elementTypeProvider.getProperty_NameIDTerminalRuleCall_1_0ElementType());
		}
		if (elementType == elementTypeProvider.getProperty_TypeTypeCrossReference_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
