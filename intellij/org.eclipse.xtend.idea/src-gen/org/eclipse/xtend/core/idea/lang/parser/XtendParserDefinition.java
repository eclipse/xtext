/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.lang.parser;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtend.core.idea.lang.XtendElementTypeProvider;
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

public class XtendParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private XtendElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new XtendFileImpl(viewProvider);
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			IElementType elementType = node.getElementType();
			if (elementType == elementTypeProvider.getFileElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getFile_ImportSectionXImportSectionParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getFile_XtendTypesTypeParserRuleCall_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTypeElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_XtendTypeDeclarationAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_AnnotationsXAnnotationParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_XtendClassAnnotationInfoAction_2_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_0_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_0_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_0_5_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_ImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_ImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_MembersMemberParserRuleCall_2_0_8_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_XtendInterfaceAnnotationInfoAction_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_ExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_ExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_MembersMemberParserRuleCall_2_1_7_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_XtendEnumAnnotationInfoAction_2_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_MembersXtendEnumLiteralParserRuleCall_2_2_5_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_MembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_XtendAnnotationTypeAnnotationInfoAction_2_3_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getType_MembersAnnotationFieldParserRuleCall_2_3_5_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmSuperTypeReferenceElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmSuperTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmSuperTypeReference_XFunctionSuperTypeRefParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFunctionSuperTypeRefElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationFieldElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendMemberAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_AnnotationsXAnnotationParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendFieldAnnotationInfoAction_2_0_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_4_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendFieldAnnotationInfoAction_2_0_0_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_TypeJvmTypeReferenceParserRuleCall_2_0_0_1_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_InitialValueXAnnotationElementValueParserRuleCall_2_0_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendClassAnnotationInfoAction_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_MembersMemberParserRuleCall_2_1_8_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendInterfaceAnnotationInfoAction_2_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_2_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_2_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_MembersMemberParserRuleCall_2_2_7_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendEnumAnnotationInfoAction_2_3_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_MembersXtendEnumLiteralParserRuleCall_2_3_5_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_MembersXtendEnumLiteralParserRuleCall_2_3_5_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendAnnotationTypeAnnotationInfoAction_2_4_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_MembersAnnotationFieldParserRuleCall_2_4_5_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMemberElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendMemberAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_AnnotationsXAnnotationParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendFieldAnnotationInfoAction_2_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_0_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_1_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_2_4_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_3_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_InitialValueXExpressionParserRuleCall_2_0_3_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendFunctionAnnotationInfoAction_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_0_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_CreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ReturnTypeTypeReferenceWithTypeArgsParserRuleCall_2_1_5_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ReturnTypeTypeReferenceNoTypeArgsParserRuleCall_2_1_5_2_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_CreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_3_0_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_1_6_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_1_6_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_1_8_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_1_8_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ExpressionXBlockExpressionParserRuleCall_2_1_9_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ExpressionRichStringParserRuleCall_2_1_9_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendConstructorAnnotationInfoAction_2_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_2_3_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_2_3_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_2_5_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_2_5_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_2_7_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_2_7_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ExpressionXBlockExpressionParserRuleCall_2_2_8_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendClassAnnotationInfoAction_2_3_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_3_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_3_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_3_5_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_MembersMemberParserRuleCall_2_3_8_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendInterfaceAnnotationInfoAction_2_4_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_4_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_4_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_MembersMemberParserRuleCall_2_4_7_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendEnumAnnotationInfoAction_2_5_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_MembersXtendEnumLiteralParserRuleCall_2_5_5_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_MembersXtendEnumLiteralParserRuleCall_2_5_5_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendAnnotationTypeAnnotationInfoAction_2_6_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getMember_MembersAnnotationFieldParserRuleCall_2_6_5_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTypeReferenceNoTypeArgsElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgsElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_ParameterizedTypeReferenceWithTypeArgsParserRuleCall_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_TypeReferenceNoTypeArgsParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_JvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_XFunctionTypeRefParserRuleCall_2ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgsElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXtendEnumLiteralElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCreateExtensionInfoElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getCreateExtensionInfo_CreateExpressionXExpressionParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParameterElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParameter_AnnotationsXAnnotationParserRuleCall_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParameter_AnnotationsXAnnotationParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getParameter_ParameterTypeJvmTypeReferenceParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXVariableDeclarationElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXVariableDeclaration_XtendVariableDeclarationAction_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_1_0_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXVariableDeclaration_RightXExpressionParserRuleCall_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXConstructorCallElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXConstructorCall_XbaseConstructorCallParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXConstructorCall_AnonymousClassConstructorCallAction_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXConstructorCall_MembersMemberParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXbaseConstructorCallElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXbaseConstructorCall_XConstructorCallAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXbaseConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXbaseConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsXClosureParserRuleCall_5_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmFormalParameterElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getFullJvmFormalParameterElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getFullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXStringLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXStringLiteral_SimpleStringLiteralParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXStringLiteral_RichStringParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSwitchExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSwitchExpression_XSwitchExpressionAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSwitchExpression_SwitchXExpressionOrSimpleConstructorCallParserRuleCall_2_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSwitchExpression_CasesXCasePartParserRuleCall_4_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpressionOrSimpleConstructorCallElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpressionOrSimpleConstructorCall_XbaseConstructorCallParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpressionOrSimpleConstructorCall_XExpressionParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getSimpleStringLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getSimpleStringLiteral_XStringLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichString_RichStringAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringLiteralParserRuleCall_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringLiteralStartParserRuleCall_1_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringPartParserRuleCall_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringPartParserRuleCall_1_1_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringLiteralEndParserRuleCall_1_1_3_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringLiteral_RichStringLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringLiteralStartElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringLiteralStart_RichStringLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringLiteralInbetweenElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringLiteralInbetween_RichStringLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringLiteralEndElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringLiteralEnd_RichStringLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getInternalRichStringElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getInternalRichString_RichStringAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getInternalRichString_ExpressionsRichStringLiteralInbetweenParserRuleCall_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getInternalRichString_ExpressionsRichStringPartParserRuleCall_1_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getInternalRichString_ExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringPartElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringPart_XExpressionOrVarDeclarationParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringPart_RichStringForLoopParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringPart_RichStringIfParserRuleCall_2ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringForLoopElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringForLoop_RichStringForLoopAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringForLoop_DeclaredParamJvmFormalParameterParserRuleCall_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringForLoop_ForExpressionXExpressionParserRuleCall_4_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringForLoop_BeforeXExpressionParserRuleCall_5_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringForLoop_SeparatorXExpressionParserRuleCall_6_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringForLoop_AfterXExpressionParserRuleCall_7_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringForLoop_EachExpressionInternalRichStringParserRuleCall_8_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringIfElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringIf_RichStringIfAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringIf_IfXExpressionParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringIf_ThenInternalRichStringParserRuleCall_3_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringIf_ElseIfsRichStringElseIfParserRuleCall_4_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringIf_ElseInternalRichStringParserRuleCall_5_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringElseIfElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringElseIf_IfXExpressionParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getRichStringElseIf_ThenInternalRichStringParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotation_XAnnotationAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotation_ElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotation_ElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotation_ValueXAnnotationElementValueOrCommaListParserRuleCall_3_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValuePairElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValuePair_ValueXAnnotationElementValueParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaListElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_XListLiteralAction_0_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_XAnnotationOrExpressionParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_XListLiteralElementsAction_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsXAnnotationOrExpressionParserRuleCall_1_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValueElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValue_XListLiteralAction_0_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValue_ElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValue_ElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationElementValue_XAnnotationOrExpressionParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationOrExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationOrExpression_XAnnotationParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAnnotationOrExpression_XExpressionParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpression_XAssignmentParserRuleCallElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAssignmentElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAssignment_XAssignmentAction_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAssignment_ValueXAssignmentParserRuleCall_0_3_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAssignment_XOrExpressionParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXOrExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXOrExpression_XAndExpressionParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAndExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAndExpression_XEqualityExpressionParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXEqualityExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXEqualityExpression_XRelationalExpressionParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXRelationalExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXRelationalExpression_XOtherOperatorExpressionParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXOtherOperatorExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAdditiveExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMultiplicativeExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMultiplicativeExpression_XUnaryOperationParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXUnaryOperationElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXUnaryOperation_XUnaryOperationAction_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXUnaryOperation_XCastedExpressionParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCastedExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCastedExpression_XPostfixOperationParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCastedExpression_XCastedExpressionTargetAction_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPostfixOperationElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPostfixOperation_XMemberFeatureCallParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPostfixOperation_XPostfixOperationOperandAction_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCallElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCall_XPrimaryExpressionParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XConstructorCallParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XBlockExpressionParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XSwitchExpressionParserRuleCall_2ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XSynchronizedExpressionParserRuleCall_3ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XFeatureCallParserRuleCall_4ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XLiteralParserRuleCall_5ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XIfExpressionParserRuleCall_6ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XForLoopExpressionParserRuleCall_7ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XWhileExpressionParserRuleCall_9ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XDoWhileExpressionParserRuleCall_10ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XThrowExpressionParserRuleCall_11ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XReturnExpressionParserRuleCall_12ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXPrimaryExpression_XParenthesizedExpressionParserRuleCall_14ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXLiteral_XCollectionLiteralParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXLiteral_XClosureParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXLiteral_XBooleanLiteralParserRuleCall_2ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXLiteral_XNumberLiteralParserRuleCall_3ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXLiteral_XNullLiteralParserRuleCall_4ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXLiteral_XStringLiteralParserRuleCall_5ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXLiteral_XTypeLiteralParserRuleCall_6ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCollectionLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCollectionLiteral_XSetLiteralParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCollectionLiteral_XListLiteralParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSetLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSetLiteral_XSetLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXListLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXListLiteral_XListLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXClosureElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXClosure_XClosureAction_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXClosure_ExpressionXExpressionInClosureParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpressionInClosureElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpressionInClosure_XBlockExpressionAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXShortClosureElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXShortClosure_XClosureAction_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXShortClosure_ExpressionXExpressionParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXParenthesizedExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXParenthesizedExpression_XExpressionParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXIfExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXIfExpression_XIfExpressionAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXIfExpression_IfXExpressionParserRuleCall_3_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXIfExpression_ThenXExpressionParserRuleCall_5_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXIfExpression_ElseXExpressionParserRuleCall_6_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCasePartElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCasePart_XCasePartAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCasePart_CaseXExpressionParserRuleCall_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCasePart_ThenXExpressionParserRuleCall_3_0_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXForLoopExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXForLoopExpression_XForLoopExpressionAction_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBasicForLoopExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBasicForLoopExpression_XBasicForLoopExpressionAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXWhileExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXWhileExpression_XWhileExpressionAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXWhileExpression_PredicateXExpressionParserRuleCall_3_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXWhileExpression_BodyXExpressionParserRuleCall_5_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXDoWhileExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXDoWhileExpression_XDoWhileExpressionAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXDoWhileExpression_BodyXExpressionParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXDoWhileExpression_PredicateXExpressionParserRuleCall_5_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBlockExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBlockExpression_XBlockExpressionAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpressionOrVarDeclarationElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXExpressionOrVarDeclaration_XExpressionParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFeatureCallElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFeatureCall_XFeatureCallAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBooleanLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXBooleanLiteral_XBooleanLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXNullLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXNullLiteral_XNullLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXNumberLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXNumberLiteral_XNumberLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXTypeLiteralElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXTypeLiteral_XTypeLiteralAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXThrowExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXThrowExpression_XThrowExpressionAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXThrowExpression_ExpressionXExpressionParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXReturnExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXReturnExpression_XReturnExpressionAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXReturnExpression_ExpressionXExpressionParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXTryCatchFinallyExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSynchronizedExpressionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSynchronizedExpression_XSynchronizedExpressionAction_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSynchronizedExpression_ParamXExpressionParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCatchClauseElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXCatchClause_ExpressionXExpressionParserRuleCall_4_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmTypeReferenceElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFunctionTypeRefElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmParameterizedTypeReferenceElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmArgumentTypeReferenceElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmWildcardTypeReferenceElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmUpperBoundElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmUpperBoundAndedElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmLowerBoundElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmLowerBoundAndedElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmTypeParameterElementType()) {
				return new PsiNamedEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getJvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXImportSectionElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			if (elementType == elementTypeProvider.getXImportDeclarationElementType()) {
				return new org.eclipse.xtext.psi.impl.PsiEObjectImpl(node) {};
			}
			throw new IllegalStateException("Unexpected element type: " + elementType);
		}
		return super.createElement(node);
	}

}
