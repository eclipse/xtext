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
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.impl.PsiEObjectReference;
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
		IElementType elementType = node.getElementType();
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
		if (elementType == elementTypeProvider.getTypeReferenceNoTypeArgs_TypeJvmTypeCrossReference_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_TypeJvmTypeCrossReference_0_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_TypeJvmTypeCrossReference_1_4_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ConstructorJvmConstructorCrossReference_2_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_AnnotationTypeJvmAnnotationTypeCrossReference_2_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePair_ElementJvmOperationCrossReference_0_0_0_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_TypeJvmTypeCrossReference_3_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType()) {
			return new PsiEObjectReference(node) {};
		}
		if (elementType == elementTypeProvider.getFileElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFile_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFile_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFile_PackageKeyword_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFile_PackageAssignment_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFile_PackageQualifiedNameParserRuleCall_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFile_SemicolonKeyword_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFile_ImportSectionAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFile_ImportSectionXImportSectionParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFile_XtendTypesAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_AnnotationsAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_AnnotationsXAnnotationParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Alternatives_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ModifiersAssignment_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ModifiersCommonModifierParserRuleCall_2_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ClassKeyword_2_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_NameAssignment_2_0_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_0_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_LessThanSignKeyword_2_0_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_TypeParametersAssignment_2_0_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_0_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_CommaKeyword_2_0_4_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_TypeParametersAssignment_2_0_4_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_GreaterThanSignKeyword_2_0_4_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_0_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ExtendsKeyword_2_0_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ExtendsAssignment_2_0_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_0_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_0_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ImplementsKeyword_2_0_6_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ImplementsAssignment_2_0_6_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_0_6_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_CommaKeyword_2_0_6_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ImplementsAssignment_2_0_6_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_LeftCurlyBracketKeyword_2_0_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_MembersAssignment_2_0_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_RightCurlyBracketKeyword_2_0_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ModifiersAssignment_2_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ModifiersCommonModifierParserRuleCall_2_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_InterfaceKeyword_2_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_NameAssignment_2_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_1_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_LessThanSignKeyword_2_1_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_TypeParametersAssignment_2_1_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_1_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_CommaKeyword_2_1_4_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_TypeParametersAssignment_2_1_4_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_GreaterThanSignKeyword_2_1_4_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_1_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ExtendsKeyword_2_1_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ExtendsAssignment_2_1_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_1_5_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_CommaKeyword_2_1_5_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ExtendsAssignment_2_1_5_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_LeftCurlyBracketKeyword_2_1_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_MembersAssignment_2_1_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_RightCurlyBracketKeyword_2_1_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ModifiersAssignment_2_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ModifiersCommonModifierParserRuleCall_2_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_EnumKeyword_2_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_NameAssignment_2_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_LeftCurlyBracketKeyword_2_2_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_2_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_MembersAssignment_2_2_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_2_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_CommaKeyword_2_2_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_MembersAssignment_2_2_5_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_SemicolonKeyword_2_2_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_RightCurlyBracketKeyword_2_2_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_Group_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ModifiersAssignment_2_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_ModifiersCommonModifierParserRuleCall_2_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_AnnotationKeyword_2_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_NameAssignment_2_3_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_LeftCurlyBracketKeyword_2_3_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_MembersAssignment_2_3_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getType_RightCurlyBracketKeyword_2_3_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmSuperTypeReferenceElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmSuperTypeReference_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmSuperTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmSuperTypeReference_XFunctionSuperTypeRefParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRefElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_InstanceContextAssignment_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_InstanceContextLeftParenthesisKeyword_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_Group_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_ParamTypesAssignment_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_Group_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_CommaKeyword_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_ParamTypesAssignment_0_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_RightParenthesisKeyword_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_ReturnTypeAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionSuperTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationFieldElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_AnnotationsAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_AnnotationsXAnnotationParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Alternatives_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Alternatives_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersAssignment_2_0_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_0_0_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersAssignment_2_0_0_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersFieldModifierParserRuleCall_2_0_0_0_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersAssignment_2_0_0_0_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_0_0_0_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_TypeAssignment_2_0_0_0_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameAssignment_2_0_0_0_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersAssignment_2_0_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_0_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_TypeAssignment_2_0_0_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_TypeJvmTypeReferenceParserRuleCall_2_0_0_1_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameAssignment_2_0_0_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_EqualsSignKeyword_2_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_InitialValueAssignment_2_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_InitialValueXAnnotationElementValueParserRuleCall_2_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_SemicolonKeyword_2_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersAssignment_2_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ClassKeyword_2_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameAssignment_2_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_1_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_LessThanSignKeyword_2_1_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_TypeParametersAssignment_2_1_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_1_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_CommaKeyword_2_1_4_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_TypeParametersAssignment_2_1_4_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_GreaterThanSignKeyword_2_1_4_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_1_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ExtendsKeyword_2_1_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ExtendsAssignment_2_1_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_1_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ImplementsKeyword_2_1_6_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ImplementsAssignment_2_1_6_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_1_6_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_CommaKeyword_2_1_6_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ImplementsAssignment_2_1_6_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_LeftCurlyBracketKeyword_2_1_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_MembersAssignment_2_1_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_RightCurlyBracketKeyword_2_1_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersAssignment_2_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_InterfaceKeyword_2_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameAssignment_2_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_2_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_LessThanSignKeyword_2_2_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_TypeParametersAssignment_2_2_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_2_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_CommaKeyword_2_2_4_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_TypeParametersAssignment_2_2_4_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_GreaterThanSignKeyword_2_2_4_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_2_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ExtendsKeyword_2_2_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ExtendsAssignment_2_2_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_2_5_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_CommaKeyword_2_2_5_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ExtendsAssignment_2_2_5_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_LeftCurlyBracketKeyword_2_2_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_MembersAssignment_2_2_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_RightCurlyBracketKeyword_2_2_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersAssignment_2_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_EnumKeyword_2_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameAssignment_2_3_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_LeftCurlyBracketKeyword_2_3_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_3_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_MembersAssignment_2_3_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_3_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_CommaKeyword_2_3_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_MembersAssignment_2_3_5_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_SemicolonKeyword_2_3_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_RightCurlyBracketKeyword_2_3_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_Group_2_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersAssignment_2_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_ModifiersCommonModifierParserRuleCall_2_4_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_AnnotationKeyword_2_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameAssignment_2_4_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_LeftCurlyBracketKeyword_2_4_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_MembersAssignment_2_4_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getAnnotationField_RightCurlyBracketKeyword_2_4_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMemberElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_AnnotationsAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_AnnotationsXAnnotationParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Alternatives_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Alternatives_2_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_0_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_0_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersFieldModifierParserRuleCall_2_0_2_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_0_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_0_2_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeAssignment_2_0_2_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_0_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_0_2_0_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_0_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_0_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersExtensionKeyword_2_0_2_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Alternatives_2_0_2_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_0_2_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersFieldModifierParserRuleCall_2_0_2_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_0_2_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_0_2_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeAssignment_2_0_2_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_1_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_0_2_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_0_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_0_2_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersFieldModifierParserRuleCall_2_0_2_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_0_2_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_0_2_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_0_2_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersExtensionKeyword_2_0_2_2_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_0_2_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_0_2_2_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeAssignment_2_0_2_2_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_2_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_0_2_2_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_0_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeAssignment_2_0_2_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeJvmTypeReferenceParserRuleCall_2_0_2_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_0_2_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_0_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_EqualsSignKeyword_2_0_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_InitialValueAssignment_2_0_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_InitialValueXExpressionParserRuleCall_2_0_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_SemicolonKeyword_2_0_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersMethodModifierParserRuleCall_2_1_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Alternatives_2_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_1_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_1_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_1_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersMethodModifierParserRuleCall_2_1_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LessThanSignKeyword_2_1_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeParametersAssignment_2_1_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_1_4_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeParametersAssignment_2_1_4_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_GreaterThanSignKeyword_2_1_4_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Alternatives_2_1_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_5_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ReturnTypeAssignment_2_1_5_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_0_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CreateExtensionInfoAssignment_2_1_5_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_1_5_0_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LeftParenthesisKeyword_2_1_5_0_0_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ReturnTypeAssignment_2_1_5_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ReturnTypeTypeReferenceWithTypeArgsParserRuleCall_2_1_5_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_1_5_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LeftParenthesisKeyword_2_1_5_1_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_5_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_5_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ReturnTypeAssignment_2_1_5_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ReturnTypeTypeReferenceNoTypeArgsParserRuleCall_2_1_5_2_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_1_5_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LeftParenthesisKeyword_2_1_5_2_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_5_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_5_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CreateExtensionInfoAssignment_2_1_5_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_1_5_3_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LeftParenthesisKeyword_2_1_5_3_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_5_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_1_5_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LeftParenthesisKeyword_2_1_5_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ParametersAssignment_2_1_6_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_6_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_1_6_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ParametersAssignment_2_1_6_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_RightParenthesisKeyword_2_1_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ThrowsKeyword_2_1_8_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExceptionsAssignment_2_1_8_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_1_8_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_1_8_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_1_8_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExceptionsAssignment_2_1_8_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_1_8_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Alternatives_2_1_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExpressionAssignment_2_1_9_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExpressionXBlockExpressionParserRuleCall_2_1_9_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExpressionAssignment_2_1_9_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExpressionRichStringParserRuleCall_2_1_9_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_SemicolonKeyword_2_1_9_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NewKeyword_2_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LessThanSignKeyword_2_2_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeParametersAssignment_2_2_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_2_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_2_3_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeParametersAssignment_2_2_3_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_GreaterThanSignKeyword_2_2_3_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LeftParenthesisKeyword_2_2_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_2_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ParametersAssignment_2_2_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_2_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_2_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ParametersAssignment_2_2_5_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_RightParenthesisKeyword_2_2_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_2_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ThrowsKeyword_2_2_7_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExceptionsAssignment_2_2_7_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_2_7_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_2_7_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_2_7_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExceptionsAssignment_2_2_7_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExceptionsJvmTypeReferenceParserRuleCall_2_2_7_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExpressionAssignment_2_2_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExpressionXBlockExpressionParserRuleCall_2_2_8_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ClassKeyword_2_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_3_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_3_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LessThanSignKeyword_2_3_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeParametersAssignment_2_3_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_3_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_3_4_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeParametersAssignment_2_3_4_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_GreaterThanSignKeyword_2_3_4_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_3_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExtendsKeyword_2_3_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExtendsAssignment_2_3_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_3_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_3_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ImplementsKeyword_2_3_6_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ImplementsAssignment_2_3_6_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_3_6_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_3_6_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ImplementsAssignment_2_3_6_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LeftCurlyBracketKeyword_2_3_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_MembersAssignment_2_3_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_RightCurlyBracketKeyword_2_3_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_4_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_InterfaceKeyword_2_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_4_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_4_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LessThanSignKeyword_2_4_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeParametersAssignment_2_4_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_4_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_4_4_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_TypeParametersAssignment_2_4_4_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_GreaterThanSignKeyword_2_4_4_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_4_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExtendsKeyword_2_4_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExtendsAssignment_2_4_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_4_5_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_4_5_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExtendsAssignment_2_4_5_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LeftCurlyBracketKeyword_2_4_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_MembersAssignment_2_4_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_RightCurlyBracketKeyword_2_4_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_EnumKeyword_2_5_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_5_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LeftCurlyBracketKeyword_2_5_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_5_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_MembersAssignment_2_5_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_5_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_CommaKeyword_2_5_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_MembersAssignment_2_5_5_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_SemicolonKeyword_2_5_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_RightCurlyBracketKeyword_2_5_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_Group_2_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersAssignment_2_6_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_ModifiersCommonModifierParserRuleCall_2_6_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_AnnotationKeyword_2_6_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameAssignment_2_6_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_LeftCurlyBracketKeyword_2_6_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_MembersAssignment_2_6_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMember_RightCurlyBracketKeyword_2_6_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceNoTypeArgsElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceNoTypeArgs_TypeAssignmentElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceNoTypeArgs_TypeJvmTypeQualifiedNameParserRuleCall_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgsElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_ParameterizedTypeReferenceWithTypeArgsParserRuleCall_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_Group_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_Group_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_ArrayBracketsParserRuleCall_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_TypeReferenceNoTypeArgsParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_Group_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_Group_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_JvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_ArrayBracketsParserRuleCall_1_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getTypeReferenceWithTypeArgs_XFunctionTypeRefParserRuleCall_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgsElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_TypeAssignment_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_TypeJvmTypeQualifiedNameParserRuleCall_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_LessThanSignKeyword_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_Group_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_CommaKeyword_1_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsAssignment_1_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_GreaterThanSignKeyword_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_Group_1_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_Group_1_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_Group_1_4_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_FullStopKeyword_1_4_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_TypeAssignment_1_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_TypeJvmTypeValidIDParserRuleCall_1_4_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_Group_1_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_LessThanSignKeyword_1_4_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsAssignment_1_4_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_Group_1_4_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_CommaKeyword_1_4_2_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsAssignment_1_4_2_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_GreaterThanSignKeyword_1_4_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFunctionIDElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFunctionID_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFunctionID_ValidIDParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFunctionID_OperatorsParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperatorsElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperators_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperators_OpMultiAssignParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperators_OpOrParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperators_OpAndParserRuleCall_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperators_OpEqualityParserRuleCall_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperators_OpCompareParserRuleCall_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperators_OpOtherParserRuleCall_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperators_OpMultiParserRuleCall_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperators_OpUnaryParserRuleCall_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOperators_OpPostfixParserRuleCall_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXtendEnumLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXtendEnumLiteral_NameAssignmentElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifierElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_PublicKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_PrivateKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_ProtectedKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_PackageKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_AbstractKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_StaticKeyword_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_DispatchKeyword_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_FinalKeyword_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_StrictfpKeyword_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_NativeKeyword_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_VolatileKeyword_10ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_SynchronizedKeyword_11ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCommonModifier_TransientKeyword_12ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFieldModifierElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFieldModifier_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFieldModifier_ValKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFieldModifier_VarKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMethodModifierElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMethodModifier_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMethodModifier_DefKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMethodModifier_OverrideKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCreateExtensionInfoElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCreateExtensionInfo_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCreateExtensionInfo_CreateKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCreateExtensionInfo_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCreateExtensionInfo_NameAssignment_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCreateExtensionInfo_NameValidIDParserRuleCall_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCreateExtensionInfo_ColonKeyword_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCreateExtensionInfo_CreateExpressionAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getCreateExtensionInfo_CreateExpressionXExpressionParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getValidIDElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getValidID_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getValidID_IDTerminalRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getValidID_CreateKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getValidID_AnnotationKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getValidID_AFTERKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getValidID_BEFOREKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getValidID_SEPARATORKeyword_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFeatureCallIDElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFeatureCallID_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFeatureCallID_InnerVarIDParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFeatureCallID_ExtensionKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarIDElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_IDTerminalRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_AbstractKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_AnnotationKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_ClassKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_CreateKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_DefKeyword_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_DispatchKeyword_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_EnumKeyword_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_ExtendsKeyword_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_FinalKeyword_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_ImplementsKeyword_10ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_ImportKeyword_11ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_InterfaceKeyword_12ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_OverrideKeyword_13ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_PackageKeyword_14ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_PublicKeyword_15ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_PrivateKeyword_16ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_ProtectedKeyword_17ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_StaticKeyword_18ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_ThrowsKeyword_19ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_StrictfpKeyword_20ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_NativeKeyword_21ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_VolatileKeyword_22ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_SynchronizedKeyword_23ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_TransientKeyword_24ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_AFTERKeyword_25ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_BEFOREKeyword_26ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInnerVarID_SEPARATORKeyword_27ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameterElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_AnnotationsAssignment_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_AnnotationsXAnnotationParserRuleCall_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_ExtensionAssignment_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_ExtensionExtensionKeyword_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_AnnotationsAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_AnnotationsXAnnotationParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_ParameterTypeAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_ParameterTypeJvmTypeReferenceParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_VarArgAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_VarArgFullStopFullStopFullStopKeyword_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_NameAssignment_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getParameter_NameValidIDParserRuleCall_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclarationElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Group_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Alternatives_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Group_0_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Alternatives_0_0_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_WriteableAssignment_0_0_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_WriteableVarKeyword_0_0_1_0_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_ValKeyword_0_0_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_ExtensionAssignment_0_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_ExtensionExtensionKeyword_0_0_1_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Group_0_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_ExtensionAssignment_0_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_ExtensionExtensionKeyword_0_0_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Alternatives_0_0_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_WriteableAssignment_0_0_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_WriteableVarKeyword_0_0_1_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_ValKeyword_0_0_1_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Alternatives_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_TypeAssignment_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_1_0_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_NameAssignment_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_NameInnerVarIDParserRuleCall_1_0_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_NameAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_NameInnerVarIDParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_Group_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_EqualsSignKeyword_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_RightAssignment_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXVariableDeclaration_RightXExpressionParserRuleCall_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXConstructorCallElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXConstructorCall_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXConstructorCall_XbaseConstructorCallParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXConstructorCall_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXConstructorCall_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXConstructorCall_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXConstructorCall_AnonymousClassConstructorCallAction_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXConstructorCall_LeftCurlyBracketKeyword_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXConstructorCall_MembersAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXConstructorCall_RightCurlyBracketKeyword_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCallElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_XConstructorCallAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_NewKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ConstructorAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_Group_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_LessThanSignKeyword_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_TypeArgumentsAssignment_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_Group_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_CommaKeyword_3_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_TypeArgumentsAssignment_3_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_GreaterThanSignKeyword_3_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_Group_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ExplicitConstructorCallAssignment_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_Alternatives_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsAssignment_4_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_Group_4_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsAssignment_4_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_Group_4_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_CommaKeyword_4_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsAssignment_4_1_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_RightParenthesisKeyword_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsAssignment_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ArgumentsXClosureParserRuleCall_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmFormalParameterElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmFormalParameter_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmFormalParameter_ExtensionAssignment_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmFormalParameter_ExtensionExtensionKeyword_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmFormalParameter_ParameterTypeAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmFormalParameter_NameAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFullJvmFormalParameterElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFullJvmFormalParameter_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFullJvmFormalParameter_ExtensionAssignment_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFullJvmFormalParameter_ExtensionExtensionKeyword_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFullJvmFormalParameter_ParameterTypeAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFullJvmFormalParameter_NameAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getFullJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXStringLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXStringLiteral_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXStringLiteral_SimpleStringLiteralParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXStringLiteral_RichStringParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_XSwitchExpressionAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_SwitchKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_Alternatives_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_Group_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_Group_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_Group_2_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_DeclaredParamAssignment_2_0_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_ColonKeyword_2_0_0_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_SwitchAssignment_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_RightParenthesisKeyword_2_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_Group_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_Group_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_Group_2_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_DeclaredParamAssignment_2_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_ColonKeyword_2_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_SwitchAssignment_2_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_SwitchXExpressionOrSimpleConstructorCallParserRuleCall_2_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_LeftCurlyBracketKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_CasesAssignment_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_CasesXCasePartParserRuleCall_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_Group_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_DefaultKeyword_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_ColonKeyword_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_DefaultAssignment_5_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_RightCurlyBracketKeyword_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionOrSimpleConstructorCallElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionOrSimpleConstructorCall_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionOrSimpleConstructorCall_XbaseConstructorCallParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionOrSimpleConstructorCall_XExpressionParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSimpleStringLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSimpleStringLiteral_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSimpleStringLiteral_XStringLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSimpleStringLiteral_ValueAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getSimpleStringLiteral_ValueSTRINGTerminalRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_RichStringAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_Alternatives_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsAssignment_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringLiteralParserRuleCall_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_Group_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsAssignment_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringLiteralStartParserRuleCall_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsAssignment_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringPartParserRuleCall_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_Group_1_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsAssignment_1_1_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsAssignment_1_1_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringPartParserRuleCall_1_1_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsAssignment_1_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichString_ExpressionsRichStringLiteralEndParserRuleCall_1_1_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteral_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteral_RichStringLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteral_ValueAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteral_ValueRICH_TEXTTerminalRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralStartElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralStart_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralStart_RichStringLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralStart_ValueAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralStart_ValueRICH_TEXT_STARTTerminalRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralInbetweenElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralInbetween_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralInbetween_RichStringLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralInbetween_Alternatives_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralInbetween_ValueAssignment_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralInbetween_ValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralInbetween_ValueAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralInbetween_ValueCOMMENT_RICH_TEXT_INBETWEENTerminalRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralEndElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralEnd_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralEnd_RichStringLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralEnd_Alternatives_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralEnd_ValueAssignment_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralEnd_ValueRICH_TEXT_ENDTerminalRuleCall_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralEnd_ValueAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringLiteralEnd_ValueCOMMENT_RICH_TEXT_ENDTerminalRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichStringElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichString_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichString_RichStringAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichString_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichString_ExpressionsAssignment_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichString_ExpressionsRichStringLiteralInbetweenParserRuleCall_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichString_Group_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichString_ExpressionsAssignment_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichString_ExpressionsRichStringPartParserRuleCall_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichString_ExpressionsAssignment_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getInternalRichString_ExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringPartElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringPart_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringPart_XExpressionOrVarDeclarationParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringPart_RichStringForLoopParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringPart_RichStringIfParserRuleCall_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoopElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_RichStringForLoopAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_FORKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_DeclaredParamAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_ColonKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_ForExpressionAssignment_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_ForExpressionXExpressionParserRuleCall_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_Group_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_BEFOREKeyword_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_BeforeAssignment_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_BeforeXExpressionParserRuleCall_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_Group_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_SEPARATORKeyword_6_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_SeparatorAssignment_6_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_SeparatorXExpressionParserRuleCall_6_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_Group_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_AFTERKeyword_7_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_AfterAssignment_7_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_AfterXExpressionParserRuleCall_7_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_EachExpressionAssignment_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_EachExpressionInternalRichStringParserRuleCall_8_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_ENDFORKeyword_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIfElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_RichStringIfAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_IFKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_IfAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_IfXExpressionParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_ThenAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_ThenInternalRichStringParserRuleCall_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_ElseIfsAssignment_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_ElseIfsRichStringElseIfParserRuleCall_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_Group_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_ELSEKeyword_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_ElseAssignment_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_ElseInternalRichStringParserRuleCall_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringIf_ENDIFKeyword_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringElseIfElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringElseIf_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringElseIf_ELSEIFKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringElseIf_IfAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringElseIf_IfXExpressionParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringElseIf_ThenAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getRichStringElseIf_ThenInternalRichStringParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_XAnnotationAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_CommercialAtKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_AnnotationTypeAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_AnnotationTypeJvmAnnotationTypeQualifiedNameParserRuleCall_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_Group_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_LeftParenthesisKeyword_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_Alternatives_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_Group_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_ElementValuePairsAssignment_3_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_ElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_Group_3_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_CommaKeyword_3_1_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_ElementValuePairsAssignment_3_1_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_ElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_ValueAssignment_3_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_ValueXAnnotationElementValueOrCommaListParserRuleCall_3_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotation_RightParenthesisKeyword_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePairElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePair_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePair_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePair_Group_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePair_ElementAssignment_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePair_ElementJvmOperationValidIDParserRuleCall_0_0_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePair_EqualsSignKeyword_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePair_ValueAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValuePair_ValueXAnnotationElementValueParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaListElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_Group_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_Group_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_XListLiteralAction_0_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_NumberSignKeyword_0_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_LeftSquareBracketKeyword_0_0_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_Group_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsAssignment_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_Group_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_CommaKeyword_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsAssignment_0_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_RightSquareBracketKeyword_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_XAnnotationOrExpressionParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_Group_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_XListLiteralElementsAction_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_Group_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_CommaKeyword_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsAssignment_1_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueOrCommaList_ElementsXAnnotationOrExpressionParserRuleCall_1_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValueElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_Group_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_Group_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_XListLiteralAction_0_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_NumberSignKeyword_0_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_LeftSquareBracketKeyword_0_0_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_Group_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_ElementsAssignment_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_ElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_Group_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_CommaKeyword_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_ElementsAssignment_0_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_ElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_RightSquareBracketKeyword_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationElementValue_XAnnotationOrExpressionParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationOrExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationOrExpression_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationOrExpression_XAnnotationParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAnnotationOrExpression_XExpressionParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpression_XAssignmentParserRuleCallElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignmentElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_XAssignmentAction_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_FeatureAssignment_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_OpSingleAssignParserRuleCall_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_ValueAssignment_0_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_ValueXAssignmentParserRuleCall_0_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_XOrExpressionParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_Group_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_Group_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_Group_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_FeatureAssignment_1_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_RightOperandAssignment_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpSingleAssignElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpSingleAssign_EqualsSignKeywordElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssignElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_PlusSignEqualsSignKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_HyphenMinusEqualsSignKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_AsteriskEqualsSignKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_SolidusEqualsSignKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_PercentSignEqualsSignKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_Group_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_LessThanSignKeyword_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_LessThanSignKeyword_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_EqualsSignKeyword_5_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_Group_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_GreaterThanSignKeyword_6_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_GreaterThanSignKeyword_6_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_XAndExpressionParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_FeatureAssignment_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_FeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_RightOperandAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOrElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOr_VerticalLineVerticalLineKeywordElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_XEqualityExpressionParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_FeatureAssignment_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_FeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_RightOperandAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpAndElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpAnd_AmpersandAmpersandKeywordElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_XRelationalExpressionParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_FeatureAssignment_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_FeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_RightOperandAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpEqualityElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpEquality_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpEquality_EqualsSignEqualsSignKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpEquality_ExclamationMarkEqualsSignKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpEquality_EqualsSignEqualsSignEqualsSignKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_XOtherOperatorExpressionParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_Alternatives_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_Group_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_InstanceofKeyword_1_0_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_TypeAssignment_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_Group_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_Group_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_Group_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_FeatureAssignment_1_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_FeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_RightOperandAssignment_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpCompareElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpCompare_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpCompare_GreaterThanSignEqualsSignKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpCompare_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpCompare_LessThanSignKeyword_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpCompare_EqualsSignKeyword_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpCompare_GreaterThanSignKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpCompare_LessThanSignKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_FeatureAssignment_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_FeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_RightOperandAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOtherElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_HyphenMinusGreaterThanSignKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_FullStopFullStopLessThanSignKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_Group_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_GreaterThanSignKeyword_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_FullStopFullStopKeyword_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_FullStopFullStopKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_EqualsSignGreaterThanSignKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_Group_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_Alternatives_5_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_Group_5_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_Group_5_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_Group_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_LessThanSignKeyword_6_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_Alternatives_6_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_Group_6_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_Group_6_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_EqualsSignGreaterThanSignKeyword_6_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_LessThanSignGreaterThanSignKeyword_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpOther_QuestionMarkColonKeyword_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_FeatureAssignment_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_FeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_RightOperandAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpAddElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpAdd_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpAdd_PlusSignKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpAdd_HyphenMinusKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_XUnaryOperationParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_FeatureAssignment_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_FeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_RightOperandAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMultiElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMulti_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMulti_AsteriskKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMulti_AsteriskAsteriskKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMulti_SolidusKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpMulti_PercentSignKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXUnaryOperationElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXUnaryOperation_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXUnaryOperation_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXUnaryOperation_XUnaryOperationAction_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXUnaryOperation_FeatureAssignment_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXUnaryOperation_FeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXUnaryOperation_OperandAssignment_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXUnaryOperation_XCastedExpressionParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpUnaryElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpUnary_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpUnary_ExclamationMarkKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpUnary_HyphenMinusKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpUnary_PlusSignKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCastedExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCastedExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCastedExpression_XPostfixOperationParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCastedExpression_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCastedExpression_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCastedExpression_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCastedExpression_XCastedExpressionTargetAction_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCastedExpression_AsKeyword_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCastedExpression_TypeAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPostfixOperationElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPostfixOperation_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPostfixOperation_XMemberFeatureCallParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPostfixOperation_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPostfixOperation_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPostfixOperation_XPostfixOperationOperandAction_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPostfixOperation_FeatureAssignment_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPostfixOperation_FeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpPostfixElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpPostfix_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpPostfix_PlusSignPlusSignKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getOpPostfix_HyphenMinusHyphenMinusKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCallElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_XPrimaryExpressionParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Alternatives_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Alternatives_1_0_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_ExplicitStaticAssignment_1_0_0_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_FeatureAssignment_1_0_0_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_OpSingleAssignParserRuleCall_1_0_0_0_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_ValueAssignment_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Alternatives_1_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_NullSafeAssignment_1_1_0_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_ExplicitStaticAssignment_1_1_0_0_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_LessThanSignKeyword_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_TypeArgumentsAssignment_1_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_1_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_CommaKeyword_1_1_1_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_TypeArgumentsAssignment_1_1_1_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_GreaterThanSignKeyword_1_1_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_FeatureAssignment_1_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_ExplicitOperationCallAssignment_1_1_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Alternatives_1_1_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_1_3_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_Group_1_1_3_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_RightParenthesisKeyword_1_1_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XConstructorCallParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XBlockExpressionParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XSwitchExpressionParserRuleCall_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XSynchronizedExpressionParserRuleCall_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XFeatureCallParserRuleCall_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XLiteralParserRuleCall_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XIfExpressionParserRuleCall_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XForLoopExpressionParserRuleCall_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XWhileExpressionParserRuleCall_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XDoWhileExpressionParserRuleCall_10ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XThrowExpressionParserRuleCall_11ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XReturnExpressionParserRuleCall_12ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXPrimaryExpression_XParenthesizedExpressionParserRuleCall_14ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXLiteral_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXLiteral_XCollectionLiteralParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXLiteral_XClosureParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXLiteral_XBooleanLiteralParserRuleCall_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXLiteral_XNumberLiteralParserRuleCall_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXLiteral_XNullLiteralParserRuleCall_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXLiteral_XStringLiteralParserRuleCall_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXLiteral_XTypeLiteralParserRuleCall_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCollectionLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCollectionLiteral_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCollectionLiteral_XSetLiteralParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCollectionLiteral_XListLiteralParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_XSetLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_NumberSignKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_LeftCurlyBracketKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_Group_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_ElementsAssignment_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_Group_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_CommaKeyword_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_ElementsAssignment_3_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSetLiteral_RightCurlyBracketKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_XListLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_NumberSignKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_LeftSquareBracketKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_Group_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_ElementsAssignment_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_Group_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_CommaKeyword_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_ElementsAssignment_3_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXListLiteral_RightSquareBracketKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosureElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_Group_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_XClosureAction_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_LeftSquareBracketKeyword_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_Group_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_DeclaredFormalParametersAssignment_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_Group_1_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_CommaKeyword_1_0_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_DeclaredFormalParametersAssignment_1_0_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_ExplicitSyntaxAssignment_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_ExpressionAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_ExpressionXExpressionInClosureParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXClosure_RightSquareBracketKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionInClosureElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionInClosure_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionInClosure_XBlockExpressionAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionInClosure_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionInClosure_ExpressionsAssignment_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionInClosure_SemicolonKeyword_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosureElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_Group_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_XClosureAction_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_Group_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_DeclaredFormalParametersAssignment_0_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_Group_0_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_CommaKeyword_0_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_DeclaredFormalParametersAssignment_0_0_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_ExplicitSyntaxAssignment_0_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_ExpressionAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXShortClosure_ExpressionXExpressionParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXParenthesizedExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXParenthesizedExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXParenthesizedExpression_LeftParenthesisKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXParenthesizedExpression_XExpressionParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXParenthesizedExpression_RightParenthesisKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_XIfExpressionAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_IfKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_LeftParenthesisKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_IfAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_IfXExpressionParserRuleCall_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_RightParenthesisKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_ThenAssignment_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_ThenXExpressionParserRuleCall_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_Group_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_ElseKeyword_6_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_ElseAssignment_6_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXIfExpression_ElseXExpressionParserRuleCall_6_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePartElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_XCasePartAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_TypeGuardAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_Group_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_CaseKeyword_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_CaseAssignment_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_CaseXExpressionParserRuleCall_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_Alternatives_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_Group_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_ColonKeyword_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_ThenAssignment_3_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_ThenXExpressionParserRuleCall_3_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_FallThroughAssignment_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCasePart_FallThroughCommaKeyword_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_Group_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_XForLoopExpressionAction_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_ForKeyword_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_LeftParenthesisKeyword_0_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_DeclaredParamAssignment_0_0_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_ColonKeyword_0_0_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_ForExpressionAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_RightParenthesisKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_EachExpressionAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_XBasicForLoopExpressionAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_ForKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_LeftParenthesisKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_Group_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_InitExpressionsAssignment_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_Group_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_CommaKeyword_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_InitExpressionsAssignment_3_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_SemicolonKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_ExpressionAssignment_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_SemicolonKeyword_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_Group_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsAssignment_7_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_Group_7_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_CommaKeyword_7_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsAssignment_7_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_RightParenthesisKeyword_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_EachExpressionAssignment_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXWhileExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXWhileExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXWhileExpression_XWhileExpressionAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXWhileExpression_WhileKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXWhileExpression_LeftParenthesisKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXWhileExpression_PredicateAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXWhileExpression_PredicateXExpressionParserRuleCall_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXWhileExpression_RightParenthesisKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXWhileExpression_BodyAssignment_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXWhileExpression_BodyXExpressionParserRuleCall_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpression_XDoWhileExpressionAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpression_DoKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpression_BodyAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpression_BodyXExpressionParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpression_WhileKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpression_LeftParenthesisKeyword_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpression_PredicateAssignment_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpression_PredicateXExpressionParserRuleCall_5_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXDoWhileExpression_RightParenthesisKeyword_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBlockExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBlockExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBlockExpression_XBlockExpressionAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBlockExpression_LeftCurlyBracketKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBlockExpression_Group_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBlockExpression_ExpressionsAssignment_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBlockExpression_SemicolonKeyword_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBlockExpression_RightCurlyBracketKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionOrVarDeclarationElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionOrVarDeclaration_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXExpressionOrVarDeclaration_XExpressionParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCallElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_XFeatureCallAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_LessThanSignKeyword_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_TypeArgumentsAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_Group_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_CommaKeyword_1_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_TypeArgumentsAssignment_1_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_GreaterThanSignKeyword_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_Group_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_ExplicitOperationCallAssignment_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_Alternatives_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsAssignment_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_Group_3_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsAssignment_3_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_Group_3_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_CommaKeyword_3_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsAssignment_3_1_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_RightParenthesisKeyword_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsAssignment_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIdOrSuperElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIdOrSuper_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIdOrSuper_FeatureCallIDParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getIdOrSuper_SuperKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBooleanLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBooleanLiteral_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBooleanLiteral_XBooleanLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBooleanLiteral_Alternatives_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBooleanLiteral_FalseKeyword_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBooleanLiteral_IsTrueAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXBooleanLiteral_IsTrueTrueKeyword_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXNullLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXNullLiteral_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXNullLiteral_XNullLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXNullLiteral_NullKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXNumberLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXNumberLiteral_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXNumberLiteral_XNumberLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXNumberLiteral_ValueAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXNumberLiteral_ValueNumberParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteralElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_XTypeLiteralAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_TypeofKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_LeftParenthesisKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_TypeAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_TypeJvmTypeQualifiedNameParserRuleCall_3_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_ArrayDimensionsAssignment_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTypeLiteral_RightParenthesisKeyword_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXThrowExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXThrowExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXThrowExpression_XThrowExpressionAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXThrowExpression_ThrowKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXThrowExpression_ExpressionAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXThrowExpression_ExpressionXExpressionParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXReturnExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXReturnExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXReturnExpression_XReturnExpressionAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXReturnExpression_ReturnKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXReturnExpression_ExpressionAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXReturnExpression_ExpressionXExpressionParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_TryKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_ExpressionAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_Alternatives_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_Group_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_CatchClausesAssignment_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_Group_3_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_FinallyKeyword_3_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionAssignment_3_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_Group_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_FinallyKeyword_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionAssignment_3_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpressionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_Group_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_XSynchronizedExpressionAction_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_SynchronizedKeyword_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_LeftParenthesisKeyword_0_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_ParamAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_ParamXExpressionParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_RightParenthesisKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_ExpressionAssignment_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCatchClauseElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCatchClause_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCatchClause_CatchKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCatchClause_LeftParenthesisKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCatchClause_DeclaredParamAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCatchClause_RightParenthesisKeyword_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCatchClause_ExpressionAssignment_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXCatchClause_ExpressionXExpressionParserRuleCall_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedNameElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedName_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedName_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumberElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_HEXTerminalRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_Alternatives_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_INTTerminalRuleCall_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_DECIMALTerminalRuleCall_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_Group_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_FullStopKeyword_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_Alternatives_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_INTTerminalRuleCall_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getNumber_DECIMALTerminalRuleCall_1_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getStaticQualifierElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getStaticQualifier_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getStaticQualifier_ValidIDParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getStaticQualifier_ColonColonKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeReferenceElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeReference_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeReference_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeReference_Group_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeReference_Group_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getArrayBracketsElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getArrayBrackets_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getArrayBrackets_LeftSquareBracketKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getArrayBrackets_RightSquareBracketKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRefElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_Group_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_Group_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_ParamTypesAssignment_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_Group_0_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_ParamTypesAssignment_0_1_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_ReturnTypeAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReferenceElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_TypeAssignment_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeQualifiedNameParserRuleCall_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_Group_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsAssignment_1_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_Group_1_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_Group_1_4_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_Group_1_4_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_TypeAssignment_1_4_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeValidIDParserRuleCall_1_4_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_Group_1_4_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_Group_1_4_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmArgumentTypeReferenceElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmArgumentTypeReference_AlternativesElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReferenceElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_Alternatives_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_Group_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsAssignment_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsAssignment_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_Group_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsAssignment_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsAssignment_2_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmUpperBoundElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmUpperBound_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmUpperBound_ExtendsKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmUpperBound_TypeReferenceAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmUpperBoundAndedElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmUpperBoundAnded_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmUpperBoundAnded_AmpersandKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmLowerBoundElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmLowerBound_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmLowerBound_SuperKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmLowerBound_TypeReferenceAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmLowerBoundAndedElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmLowerBoundAnded_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmLowerBoundAnded_AmpersandKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeParameterElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeParameter_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeParameter_NameAssignment_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeParameter_Group_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeParameter_ConstraintsAssignment_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeParameter_ConstraintsAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getJvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedNameWithWildcardElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedNameWithWildcard_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedNameWithWildcard_FullStopKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedNameWithWildcard_AsteriskKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportSectionElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportSection_ImportDeclarationsAssignmentElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclarationElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ImportKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_Alternatives_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_Group_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_StaticAssignment_1_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ExtensionAssignment_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ImportedTypeAssignment_1_0_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_Alternatives_1_0_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_WildcardAssignment_1_0_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_MemberNameAssignment_1_0_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ImportedTypeAssignment_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ImportedNamespaceAssignment_1_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getXImportDeclaration_SemicolonKeyword_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedNameInStaticImportElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedNameInStaticImport_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getQualifiedNameInStaticImport_FullStopKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		throw new IllegalStateException("Unexpected element type: " + elementType);
	}

}
