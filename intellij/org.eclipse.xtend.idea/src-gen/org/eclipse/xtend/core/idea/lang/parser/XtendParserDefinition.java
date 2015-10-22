/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.lang.parser;

import org.eclipse.xtend.core.idea.lang.XtendElementTypeProvider;
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

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
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			if (elementType == elementTypeProvider.getFile_XtendTypesTypeParserRuleCall_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_XtendTypeDeclarationAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_XtendClassAnnotationInfoAction_2_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_XtendInterfaceAnnotationInfoAction_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_XtendEnumAnnotationInfoAction_2_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_XtendAnnotationTypeAnnotationInfoAction_2_3_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_MembersAnnotationFieldParserRuleCall_2_3_5_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendMemberAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendFieldAnnotationInfoAction_2_0_0_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendFieldAnnotationInfoAction_2_0_0_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendClassAnnotationInfoAction_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendInterfaceAnnotationInfoAction_2_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendEnumAnnotationInfoAction_2_3_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_XtendAnnotationTypeAnnotationInfoAction_2_4_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_MembersAnnotationFieldParserRuleCall_2_4_5_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_MembersAnnotationFieldParserRuleCall_2_6_5_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_MembersMemberParserRuleCall_2_0_8_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendMemberAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendFieldAnnotationInfoAction_2_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendFunctionAnnotationInfoAction_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendConstructorAnnotationInfoAction_2_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendClassAnnotationInfoAction_2_3_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendInterfaceAnnotationInfoAction_2_4_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendEnumAnnotationInfoAction_2_5_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_XtendAnnotationTypeAnnotationInfoAction_2_6_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_MembersMemberParserRuleCall_2_1_7_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_MembersMemberParserRuleCall_2_1_8_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_MembersMemberParserRuleCall_2_2_7_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_MembersMemberParserRuleCall_2_3_8_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_MembersMemberParserRuleCall_2_4_7_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXConstructorCall_MembersMemberParserRuleCall_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
					elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
					elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_MembersXtendEnumLiteralParserRuleCall_2_2_5_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_MembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_MembersXtendEnumLiteralParserRuleCall_2_3_5_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_MembersXtendEnumLiteralParserRuleCall_2_3_5_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_MembersXtendEnumLiteralParserRuleCall_2_5_5_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_MembersXtendEnumLiteralParserRuleCall_2_5_5_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_CreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getCreateExtensionInfo_NameValidIDParserRuleCall_1_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_CreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_3_0_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getCreateExtensionInfo_NameValidIDParserRuleCall_1_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_1_6_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameter_NameValidIDParserRuleCall_4_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_1_6_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameter_NameValidIDParserRuleCall_4_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_2_5_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameter_NameValidIDParserRuleCall_4_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_2_5_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameter_NameValidIDParserRuleCall_4_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getXVariableDeclaration_NameInnerVarIDParserRuleCall_1_0_0_1_0ElementType(),
					elementTypeProvider.getXVariableDeclaration_NameInnerVarIDParserRuleCall_1_1_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXVariableDeclaration_XtendVariableDeclarationAction_0_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getXVariableDeclaration_NameInnerVarIDParserRuleCall_1_0_0_1_0ElementType(),
					elementTypeProvider.getXVariableDeclaration_NameInnerVarIDParserRuleCall_1_1_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getRichStringForLoop_DeclaredParamJvmFormalParameterParserRuleCall_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getXCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getFullJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_0_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_0_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getType_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_2_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getAnnotationField_TypeParametersJvmTypeParameterParserRuleCall_2_2_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_2_3_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_2_3_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_3_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_3_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_4_4_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
			if (elementType == elementTypeProvider.getMember_TypeParametersJvmTypeParameterParserRuleCall_2_4_4_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()
				) {};
			}
		}
		return super.createElement(node);
	}

}
