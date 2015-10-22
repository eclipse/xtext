package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.parser;

import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageElementTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi.impl.EcoreReferenceTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class EcoreReferenceTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private EcoreReferenceTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new EcoreReferenceTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			if (elementType == elementTypeProvider.getModel_ExtendsExtendsNsURIEObjectParserRuleCall_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_5_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getModel_ExtendsExtendsPluginEObjectParserRuleCall_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_6_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getModel_ExtendsExtendsResourceEObjectParserRuleCall_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_7_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType()
				);
			}
		}
		return super.createElement(node);
	}

}
