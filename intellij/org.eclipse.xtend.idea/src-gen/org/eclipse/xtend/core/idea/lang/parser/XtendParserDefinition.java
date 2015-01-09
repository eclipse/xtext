package org.eclipse.xtend.core.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtend.core.idea.lang.XtendElementTypeProvider;
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl;
import org.eclipse.xtext.xbase.annotations.idea.lang.parser.XbaseWithAnnotationsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class XtendParserDefinition extends XbaseWithAnnotationsParserDefinition {

	@Inject 
	private XtendElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new XtendFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getType_MembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_XtendTypeDeclarationAction_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_XtendFunctionAnnotationInfoAction_2_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_XtendClassAnnotationInfoAction_2_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_MembersMemberParserRuleCall_2_1_8_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getFile_XtendTypesTypeParserRuleCall_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_XtendFieldAnnotationInfoAction_2_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_XtendMemberAction_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_XtendInterfaceAnnotationInfoAction_2_4_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_2_5_1_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getParameter_NameValidIDParserRuleCall_4_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_CreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_3_0_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getCreateExtensionInfo_NameValidIDParserRuleCall_1_0_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_MembersMemberParserRuleCall_2_1_7_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_1_6_1_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getParameter_NameValidIDParserRuleCall_4_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_MembersXtendEnumLiteralParserRuleCall_2_5_5_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_XtendInterfaceAnnotationInfoAction_2_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_XtendAnnotationTypeAnnotationInfoAction_2_6_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_1_6_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getParameter_NameValidIDParserRuleCall_4_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_XtendInterfaceAnnotationInfoAction_2_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_MembersMemberParserRuleCall_2_2_7_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_MembersXtendEnumLiteralParserRuleCall_2_3_5_1_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_MembersMemberParserRuleCall_2_3_8_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_XtendEnumAnnotationInfoAction_2_5_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_XtendEnumAnnotationInfoAction_2_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_CreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getCreateExtensionInfo_NameValidIDParserRuleCall_1_0_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXConstructorCall_MembersMemberParserRuleCall_1_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getRichStringForLoop_DeclaredParamJvmFormalParameterParserRuleCall_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_MembersAnnotationFieldParserRuleCall_2_3_5_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_XtendClassAnnotationInfoAction_2_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_MembersAnnotationFieldParserRuleCall_2_6_5_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_MembersAnnotationFieldParserRuleCall_2_4_5_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_MembersMemberParserRuleCall_2_0_8_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_XtendEnumAnnotationInfoAction_2_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_XtendAnnotationTypeAnnotationInfoAction_2_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_0_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_1_3_0ElementType(),
				elementTypeProvider.getType_NameValidIDParserRuleCall_2_3_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_MembersXtendEnumLiteralParserRuleCall_2_5_5_1_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_XtendMemberAction_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_XtendClassAnnotationInfoAction_2_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_MembersMemberParserRuleCall_2_4_7_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_XtendFieldAnnotationInfoAction_2_0_0_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_ParametersParameterParserRuleCall_2_2_5_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getParameter_NameValidIDParserRuleCall_4_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getType_MembersXtendEnumLiteralParserRuleCall_2_2_5_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_XtendFieldAnnotationInfoAction_2_0_0_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getMember_XtendConstructorAnnotationInfoAction_2_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_1_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_4_0_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_3_0_1_0ElementType(),
				elementTypeProvider.getMember_NameFunctionIDParserRuleCall_2_1_5_2_0_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_2_5_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_5_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_0_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_1_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_0_2_3_1_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_1_5_0_0_2_0ElementType(),
				elementTypeProvider.getMember_NameValidIDParserRuleCall_2_6_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getJvmFormalParameter_NameInnerVarIDParserRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_XtendAnnotationTypeAnnotationInfoAction_2_4_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_4_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_0_5_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_0_0_1_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_2_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_3_3_0ElementType(),
				elementTypeProvider.getAnnotationField_NameValidIDParserRuleCall_2_1_3_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAnnotationField_MembersXtendEnumLiteralParserRuleCall_2_3_5_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getXtendEnumLiteral_NameValidIDParserRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getTypeReferenceNoTypeArgs_TypeJvmTypeCrossReference_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_TypeJvmTypeCrossReference_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getParameterizedTypeReferenceWithTypeArgs_TypeJvmTypeCrossReference_1_4_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getXbaseConstructorCall_ConstructorJvmConstructorCrossReference_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
