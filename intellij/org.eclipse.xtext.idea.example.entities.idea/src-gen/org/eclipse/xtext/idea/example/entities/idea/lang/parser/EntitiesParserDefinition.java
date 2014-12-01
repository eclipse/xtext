package org.eclipse.xtext.idea.example.entities.idea.lang.parser;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesElementTypeProvider;
import org.eclipse.xtext.idea.example.entities.idea.lang.psi.impl.EntitiesFileImpl;
import org.eclipse.xtext.xbase.idea.lang.parser.XbaseParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class EntitiesParserDefinition extends XbaseParserDefinition {

	@Inject 
	private EntitiesElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new EntitiesFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getAbstractElement_PackageDeclarationParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getPackageDeclaration_NameQualifiedNameParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getFeature_OperationParserRuleCall_1ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getOperation_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAbstractElement_EntityParserRuleCall_1ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getEntity_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getFeature_PropertyParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getProperty_NameValidIDParserRuleCall_0_0ElementType()
			);
		}
		return super.createElement(node);
	}

}
