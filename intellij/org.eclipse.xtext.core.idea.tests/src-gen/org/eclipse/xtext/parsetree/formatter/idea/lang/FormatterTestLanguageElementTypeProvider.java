package org.eclipse.xtext.parsetree.formatter.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.formatter.idea.lang.psi.impl.FormatterTestLanguageFileImpl;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class FormatterTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<FormatterTestLanguageFileImpl>>(FormatterTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final FormatterTestLanguageGrammarAccess GRAMMAR_ACCESS = FormatterTestLanguageLanguage.INSTANCE.getInstance(FormatterTestLanguageGrammarAccess.class);

	private static class RootFactory {
		public static IGrammarAwareElementType createRootElementType() {
			return new IGrammarAwareElementType("Root_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRule());
		}
		public static IGrammarAwareElementType createRoot_GroupElementType() {
			return new IGrammarAwareElementType("Root_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getGroup());
		}
		public static IGrammarAwareElementType createRoot_TestKeyword_0ElementType() {
			return new IGrammarAwareElementType("Root_TestKeyword_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getTestKeyword_0());
		}
		public static IGrammarAwareElementType createRoot_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Root_Alternatives_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createRoot_TestLinewrapParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Root_TestLinewrapParserRuleCall_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getTestLinewrapParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createRoot_TestIndentationParserRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("Root_TestIndentationParserRuleCall_1_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getTestIndentationParserRuleCall_1_1());
		}
		public static IGrammarAwareElementType createRoot_TestLinewrapMinMaxParserRuleCall_1_2ElementType() {
			return new IGrammarAwareElementType("Root_TestLinewrapMinMaxParserRuleCall_1_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getTestLinewrapMinMaxParserRuleCall_1_2());
		}
		public static IGrammarAwareElementType createRoot_WrappingDataTypeTestParserRuleCall_1_3ElementType() {
			return new IGrammarAwareElementType("Root_WrappingDataTypeTestParserRuleCall_1_3_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getWrappingDataTypeTestParserRuleCall_1_3());
		}
	}

	public static final IGrammarAwareElementType Root_ELEMENT_TYPE = associate(RootFactory.createRootElementType());

	public static final IGrammarAwareElementType Root_Group_ELEMENT_TYPE = associate(RootFactory.createRoot_GroupElementType());

	public static final IGrammarAwareElementType Root_TestKeyword_0_ELEMENT_TYPE = associate(RootFactory.createRoot_TestKeyword_0ElementType());

	public static final IGrammarAwareElementType Root_Alternatives_1_ELEMENT_TYPE = associate(RootFactory.createRoot_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Root_TestLinewrapParserRuleCall_1_0_ELEMENT_TYPE = associate(RootFactory.createRoot_TestLinewrapParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Root_TestIndentationParserRuleCall_1_1_ELEMENT_TYPE = associate(RootFactory.createRoot_TestIndentationParserRuleCall_1_1ElementType());

	public static final IGrammarAwareElementType Root_TestLinewrapMinMaxParserRuleCall_1_2_ELEMENT_TYPE = associate(RootFactory.createRoot_TestLinewrapMinMaxParserRuleCall_1_2ElementType());

	public static final IGrammarAwareElementType Root_WrappingDataTypeTestParserRuleCall_1_3_ELEMENT_TYPE = associate(RootFactory.createRoot_WrappingDataTypeTestParserRuleCall_1_3ElementType());

	private static class LineFactory {
		public static IGrammarAwareElementType createLineElementType() {
			return new IGrammarAwareElementType("Line_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineRule());
		}
		public static IGrammarAwareElementType createLine_GroupElementType() {
			return new IGrammarAwareElementType("Line_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getGroup());
		}
		public static IGrammarAwareElementType createLine_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("Line_Alternatives_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getAlternatives_0());
		}
		public static IGrammarAwareElementType createLine_DeclParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Line_DeclParserRuleCall_0_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getDeclParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createLine_AssignParserRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("Line_AssignParserRuleCall_0_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getAssignParserRuleCall_0_1());
		}
		public static IGrammarAwareElementType createLine_MethParserRuleCall_0_2ElementType() {
			return new IGrammarAwareElementType("Line_MethParserRuleCall_0_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getMethParserRuleCall_0_2());
		}
		public static IGrammarAwareElementType createLine_FqnObjParserRuleCall_0_3ElementType() {
			return new IGrammarAwareElementType("Line_FqnObjParserRuleCall_0_3_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getFqnObjParserRuleCall_0_3());
		}
		public static IGrammarAwareElementType createLine_FqnRefParserRuleCall_0_4ElementType() {
			return new IGrammarAwareElementType("Line_FqnRefParserRuleCall_0_4_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getFqnRefParserRuleCall_0_4());
		}
		public static IGrammarAwareElementType createLine_EnumerationParserRuleCall_0_5ElementType() {
			return new IGrammarAwareElementType("Line_EnumerationParserRuleCall_0_5_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getEnumerationParserRuleCall_0_5());
		}
		public static IGrammarAwareElementType createLine_Group_0_6ElementType() {
			return new IGrammarAwareElementType("Line_Group_0_6_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getGroup_0_6());
		}
		public static IGrammarAwareElementType createLine_SuppressedHiddenParserRuleCall_0_6_0ElementType() {
			return new IGrammarAwareElementType("Line_SuppressedHiddenParserRuleCall_0_6_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getSuppressedHiddenParserRuleCall_0_6_0());
		}
		public static IGrammarAwareElementType createLine_PostKeyword_0_6_1ElementType() {
			return new IGrammarAwareElementType("Line_PostKeyword_0_6_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getPostKeyword_0_6_1());
		}
		public static IGrammarAwareElementType createLine_SpaceParserRuleCall_0_7ElementType() {
			return new IGrammarAwareElementType("Line_SpaceParserRuleCall_0_7_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getSpaceParserRuleCall_0_7());
		}
		public static IGrammarAwareElementType createLine_DatatypesParserRuleCall_0_8ElementType() {
			return new IGrammarAwareElementType("Line_DatatypesParserRuleCall_0_8_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getDatatypesParserRuleCall_0_8());
		}
		public static IGrammarAwareElementType createLine_SemicolonKeyword_1ElementType() {
			return new IGrammarAwareElementType("Line_SemicolonKeyword_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLineAccess().getSemicolonKeyword_1());
		}
	}

	public static final IGrammarAwareElementType Line_ELEMENT_TYPE = associate(LineFactory.createLineElementType());

	public static final IGrammarAwareElementType Line_Group_ELEMENT_TYPE = associate(LineFactory.createLine_GroupElementType());

	public static final IGrammarAwareElementType Line_Alternatives_0_ELEMENT_TYPE = associate(LineFactory.createLine_Alternatives_0ElementType());

	public static final IGrammarAwareElementType Line_DeclParserRuleCall_0_0_ELEMENT_TYPE = associate(LineFactory.createLine_DeclParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Line_AssignParserRuleCall_0_1_ELEMENT_TYPE = associate(LineFactory.createLine_AssignParserRuleCall_0_1ElementType());

	public static final IGrammarAwareElementType Line_MethParserRuleCall_0_2_ELEMENT_TYPE = associate(LineFactory.createLine_MethParserRuleCall_0_2ElementType());

	public static final IGrammarAwareElementType Line_FqnObjParserRuleCall_0_3_ELEMENT_TYPE = associate(LineFactory.createLine_FqnObjParserRuleCall_0_3ElementType());

	public static final IGrammarAwareElementType Line_FqnRefParserRuleCall_0_4_ELEMENT_TYPE = associate(LineFactory.createLine_FqnRefParserRuleCall_0_4ElementType());

	public static final IGrammarAwareElementType Line_EnumerationParserRuleCall_0_5_ELEMENT_TYPE = associate(LineFactory.createLine_EnumerationParserRuleCall_0_5ElementType());

	public static final IGrammarAwareElementType Line_Group_0_6_ELEMENT_TYPE = associate(LineFactory.createLine_Group_0_6ElementType());

	public static final IGrammarAwareElementType Line_SuppressedHiddenParserRuleCall_0_6_0_ELEMENT_TYPE = associate(LineFactory.createLine_SuppressedHiddenParserRuleCall_0_6_0ElementType());

	public static final IGrammarAwareElementType Line_PostKeyword_0_6_1_ELEMENT_TYPE = associate(LineFactory.createLine_PostKeyword_0_6_1ElementType());

	public static final IGrammarAwareElementType Line_SpaceParserRuleCall_0_7_ELEMENT_TYPE = associate(LineFactory.createLine_SpaceParserRuleCall_0_7ElementType());

	public static final IGrammarAwareElementType Line_DatatypesParserRuleCall_0_8_ELEMENT_TYPE = associate(LineFactory.createLine_DatatypesParserRuleCall_0_8ElementType());

	public static final IGrammarAwareElementType Line_SemicolonKeyword_1_ELEMENT_TYPE = associate(LineFactory.createLine_SemicolonKeyword_1ElementType());

	private static class DeclFactory {
		public static IGrammarAwareElementType createDeclElementType() {
			return new IGrammarAwareElementType("Decl_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDeclRule());
		}
		public static IGrammarAwareElementType createDecl_GroupElementType() {
			return new IGrammarAwareElementType("Decl_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDeclAccess().getGroup());
		}
		public static IGrammarAwareElementType createDecl_TypeAssignment_0ElementType() {
			return new IGrammarAwareElementType("Decl_TypeAssignment_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDeclAccess().getTypeAssignment_0());
		}
		public static IGrammarAwareElementType createDecl_TypeIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Decl_TypeIDTerminalRuleCall_0_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDeclAccess().getTypeIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createDecl_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Decl_NameAssignment_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDeclAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createDecl_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Decl_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDeclAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Decl_ELEMENT_TYPE = associate(DeclFactory.createDeclElementType());

	public static final IGrammarAwareElementType Decl_Group_ELEMENT_TYPE = associate(DeclFactory.createDecl_GroupElementType());

	public static final IGrammarAwareElementType Decl_TypeAssignment_0_ELEMENT_TYPE = associate(DeclFactory.createDecl_TypeAssignment_0ElementType());

	public static final IGrammarAwareElementType Decl_TypeIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(DeclFactory.createDecl_TypeIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Decl_NameAssignment_1_ELEMENT_TYPE = associate(DeclFactory.createDecl_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Decl_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(DeclFactory.createDecl_NameIDTerminalRuleCall_1_0ElementType());

	private static class AssignFactory {
		public static IGrammarAwareElementType createAssignElementType() {
			return new IGrammarAwareElementType("Assign_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignRule());
		}
		public static IGrammarAwareElementType createAssign_GroupElementType() {
			return new IGrammarAwareElementType("Assign_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getGroup());
		}
		public static IGrammarAwareElementType createAssign_VarAssignment_0ElementType() {
			return new IGrammarAwareElementType("Assign_VarAssignment_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getVarAssignment_0());
		}
		public static IGrammarAwareElementType createAssign_VarIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Assign_VarIDTerminalRuleCall_0_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getVarIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createAssign_OpAssignment_1ElementType() {
			return new IGrammarAwareElementType("Assign_OpAssignment_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getOpAssignment_1());
		}
		public static IGrammarAwareElementType createAssign_OpAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("Assign_OpAlternatives_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getOpAlternatives_1_0());
		}
		public static IGrammarAwareElementType createAssign_OpEqualsSignKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Assign_OpEqualsSignKeyword_1_0_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getOpEqualsSignKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createAssign_OpPlusSignEqualsSignKeyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("Assign_OpPlusSignEqualsSignKeyword_1_0_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getOpPlusSignEqualsSignKeyword_1_0_1());
		}
		public static IGrammarAwareElementType createAssign_LeftSquareBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("Assign_LeftSquareBracketKeyword_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getLeftSquareBracketKeyword_2());
		}
		public static IGrammarAwareElementType createAssign_Group_3ElementType() {
			return new IGrammarAwareElementType("Assign_Group_3_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createAssign_ValAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("Assign_ValAssignment_3_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getValAssignment_3_0());
		}
		public static IGrammarAwareElementType createAssign_ValINTTerminalRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("Assign_ValINTTerminalRuleCall_3_0_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getValINTTerminalRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createAssign_Group_3_1ElementType() {
			return new IGrammarAwareElementType("Assign_Group_3_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createAssign_CommaKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("Assign_CommaKeyword_3_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getCommaKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createAssign_ValAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("Assign_ValAssignment_3_1_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getValAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createAssign_ValINTTerminalRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("Assign_ValINTTerminalRuleCall_3_1_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getValINTTerminalRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createAssign_RightSquareBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("Assign_RightSquareBracketKeyword_4_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignAccess().getRightSquareBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Assign_ELEMENT_TYPE = associate(AssignFactory.createAssignElementType());

	public static final IGrammarAwareElementType Assign_Group_ELEMENT_TYPE = associate(AssignFactory.createAssign_GroupElementType());

	public static final IGrammarAwareElementType Assign_VarAssignment_0_ELEMENT_TYPE = associate(AssignFactory.createAssign_VarAssignment_0ElementType());

	public static final IGrammarAwareElementType Assign_VarIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(AssignFactory.createAssign_VarIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Assign_OpAssignment_1_ELEMENT_TYPE = associate(AssignFactory.createAssign_OpAssignment_1ElementType());

	public static final IGrammarAwareElementType Assign_OpAlternatives_1_0_ELEMENT_TYPE = associate(AssignFactory.createAssign_OpAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType Assign_OpEqualsSignKeyword_1_0_0_ELEMENT_TYPE = associate(AssignFactory.createAssign_OpEqualsSignKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Assign_OpPlusSignEqualsSignKeyword_1_0_1_ELEMENT_TYPE = associate(AssignFactory.createAssign_OpPlusSignEqualsSignKeyword_1_0_1ElementType());

	public static final IGrammarAwareElementType Assign_LeftSquareBracketKeyword_2_ELEMENT_TYPE = associate(AssignFactory.createAssign_LeftSquareBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType Assign_Group_3_ELEMENT_TYPE = associate(AssignFactory.createAssign_Group_3ElementType());

	public static final IGrammarAwareElementType Assign_ValAssignment_3_0_ELEMENT_TYPE = associate(AssignFactory.createAssign_ValAssignment_3_0ElementType());

	public static final IGrammarAwareElementType Assign_ValINTTerminalRuleCall_3_0_0_ELEMENT_TYPE = associate(AssignFactory.createAssign_ValINTTerminalRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType Assign_Group_3_1_ELEMENT_TYPE = associate(AssignFactory.createAssign_Group_3_1ElementType());

	public static final IGrammarAwareElementType Assign_CommaKeyword_3_1_0_ELEMENT_TYPE = associate(AssignFactory.createAssign_CommaKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType Assign_ValAssignment_3_1_1_ELEMENT_TYPE = associate(AssignFactory.createAssign_ValAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType Assign_ValINTTerminalRuleCall_3_1_1_0_ELEMENT_TYPE = associate(AssignFactory.createAssign_ValINTTerminalRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType Assign_RightSquareBracketKeyword_4_ELEMENT_TYPE = associate(AssignFactory.createAssign_RightSquareBracketKeyword_4ElementType());

	private static class MethFactory {
		public static IGrammarAwareElementType createMethElementType() {
			return new IGrammarAwareElementType("Meth_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethRule());
		}
		public static IGrammarAwareElementType createMeth_GroupElementType() {
			return new IGrammarAwareElementType("Meth_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getGroup());
		}
		public static IGrammarAwareElementType createMeth_VoidKeyword_0ElementType() {
			return new IGrammarAwareElementType("Meth_VoidKeyword_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getVoidKeyword_0());
		}
		public static IGrammarAwareElementType createMeth_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Meth_NameAssignment_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createMeth_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Meth_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createMeth_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("Meth_LeftParenthesisKeyword_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createMeth_Group_3ElementType() {
			return new IGrammarAwareElementType("Meth_Group_3_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createMeth_ParamAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("Meth_ParamAssignment_3_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getParamAssignment_3_0());
		}
		public static IGrammarAwareElementType createMeth_ParamParamParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("Meth_ParamParamParserRuleCall_3_0_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getParamParamParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createMeth_Group_3_1ElementType() {
			return new IGrammarAwareElementType("Meth_Group_3_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createMeth_CommaKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("Meth_CommaKeyword_3_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getCommaKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createMeth_ParamAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("Meth_ParamAssignment_3_1_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getParamAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createMeth_ParamParamParserRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("Meth_ParamParamParserRuleCall_3_1_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getParamParamParserRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createMeth_RightParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("Meth_RightParenthesisKeyword_4_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMethAccess().getRightParenthesisKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Meth_ELEMENT_TYPE = associate(MethFactory.createMethElementType());

	public static final IGrammarAwareElementType Meth_Group_ELEMENT_TYPE = associate(MethFactory.createMeth_GroupElementType());

	public static final IGrammarAwareElementType Meth_VoidKeyword_0_ELEMENT_TYPE = associate(MethFactory.createMeth_VoidKeyword_0ElementType());

	public static final IGrammarAwareElementType Meth_NameAssignment_1_ELEMENT_TYPE = associate(MethFactory.createMeth_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Meth_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(MethFactory.createMeth_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Meth_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(MethFactory.createMeth_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType Meth_Group_3_ELEMENT_TYPE = associate(MethFactory.createMeth_Group_3ElementType());

	public static final IGrammarAwareElementType Meth_ParamAssignment_3_0_ELEMENT_TYPE = associate(MethFactory.createMeth_ParamAssignment_3_0ElementType());

	public static final IGrammarAwareElementType Meth_ParamParamParserRuleCall_3_0_0_ELEMENT_TYPE = associate(MethFactory.createMeth_ParamParamParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType Meth_Group_3_1_ELEMENT_TYPE = associate(MethFactory.createMeth_Group_3_1ElementType());

	public static final IGrammarAwareElementType Meth_CommaKeyword_3_1_0_ELEMENT_TYPE = associate(MethFactory.createMeth_CommaKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType Meth_ParamAssignment_3_1_1_ELEMENT_TYPE = associate(MethFactory.createMeth_ParamAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType Meth_ParamParamParserRuleCall_3_1_1_0_ELEMENT_TYPE = associate(MethFactory.createMeth_ParamParamParserRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType Meth_RightParenthesisKeyword_4_ELEMENT_TYPE = associate(MethFactory.createMeth_RightParenthesisKeyword_4ElementType());

	private static class ParamFactory {
		public static IGrammarAwareElementType createParamElementType() {
			return new IGrammarAwareElementType("Param_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParamRule());
		}
		public static IGrammarAwareElementType createParam_GroupElementType() {
			return new IGrammarAwareElementType("Param_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParamAccess().getGroup());
		}
		public static IGrammarAwareElementType createParam_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Param_NameAssignment_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParamAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createParam_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Param_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParamAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createParam_ColonKeyword_1ElementType() {
			return new IGrammarAwareElementType("Param_ColonKeyword_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParamAccess().getColonKeyword_1());
		}
		public static IGrammarAwareElementType createParam_TypeAssignment_2ElementType() {
			return new IGrammarAwareElementType("Param_TypeAssignment_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParamAccess().getTypeAssignment_2());
		}
		public static IGrammarAwareElementType createParam_TypeIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Param_TypeIDTerminalRuleCall_2_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParamAccess().getTypeIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Param_ELEMENT_TYPE = associate(ParamFactory.createParamElementType());

	public static final IGrammarAwareElementType Param_Group_ELEMENT_TYPE = associate(ParamFactory.createParam_GroupElementType());

	public static final IGrammarAwareElementType Param_NameAssignment_0_ELEMENT_TYPE = associate(ParamFactory.createParam_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Param_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ParamFactory.createParam_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Param_ColonKeyword_1_ELEMENT_TYPE = associate(ParamFactory.createParam_ColonKeyword_1ElementType());

	public static final IGrammarAwareElementType Param_TypeAssignment_2_ELEMENT_TYPE = associate(ParamFactory.createParam_TypeAssignment_2ElementType());

	public static final IGrammarAwareElementType Param_TypeIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ParamFactory.createParam_TypeIDTerminalRuleCall_2_0ElementType());

	private static class SpaceFactory {
		public static IGrammarAwareElementType createSpaceElementType() {
			return new IGrammarAwareElementType("Space_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpaceRule());
		}
		public static IGrammarAwareElementType createSpace_GroupElementType() {
			return new IGrammarAwareElementType("Space_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpaceAccess().getGroup());
		}
		public static IGrammarAwareElementType createSpace_SpaceKeyword_0ElementType() {
			return new IGrammarAwareElementType("Space_SpaceKeyword_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpaceAccess().getSpaceKeyword_0());
		}
		public static IGrammarAwareElementType createSpace_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("Space_ValAssignment_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpaceAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createSpace_ValIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Space_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpaceAccess().getValIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Space_ELEMENT_TYPE = associate(SpaceFactory.createSpaceElementType());

	public static final IGrammarAwareElementType Space_Group_ELEMENT_TYPE = associate(SpaceFactory.createSpace_GroupElementType());

	public static final IGrammarAwareElementType Space_SpaceKeyword_0_ELEMENT_TYPE = associate(SpaceFactory.createSpace_SpaceKeyword_0ElementType());

	public static final IGrammarAwareElementType Space_ValAssignment_1_ELEMENT_TYPE = associate(SpaceFactory.createSpace_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType Space_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SpaceFactory.createSpace_ValIDTerminalRuleCall_1_0ElementType());

	private static class TestLinewrapFactory {
		public static IGrammarAwareElementType createTestLinewrapElementType() {
			return new IGrammarAwareElementType("TestLinewrap_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapRule());
		}
		public static IGrammarAwareElementType createTestLinewrap_GroupElementType() {
			return new IGrammarAwareElementType("TestLinewrap_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapAccess().getGroup());
		}
		public static IGrammarAwareElementType createTestLinewrap_TestLinewrapAction_0ElementType() {
			return new IGrammarAwareElementType("TestLinewrap_TestLinewrapAction_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapAccess().getTestLinewrapAction_0());
		}
		public static IGrammarAwareElementType createTestLinewrap_LinewrapKeyword_1ElementType() {
			return new IGrammarAwareElementType("TestLinewrap_LinewrapKeyword_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapAccess().getLinewrapKeyword_1());
		}
		public static IGrammarAwareElementType createTestLinewrap_ItemsAssignment_2ElementType() {
			return new IGrammarAwareElementType("TestLinewrap_ItemsAssignment_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapAccess().getItemsAssignment_2());
		}
		public static IGrammarAwareElementType createTestLinewrap_ItemsLineParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TestLinewrap_ItemsLineParserRuleCall_2_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapAccess().getItemsLineParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType TestLinewrap_ELEMENT_TYPE = associate(TestLinewrapFactory.createTestLinewrapElementType());

	public static final IGrammarAwareElementType TestLinewrap_Group_ELEMENT_TYPE = associate(TestLinewrapFactory.createTestLinewrap_GroupElementType());

	public static final IGrammarAwareElementType TestLinewrap_TestLinewrapAction_0_ELEMENT_TYPE = associate(TestLinewrapFactory.createTestLinewrap_TestLinewrapAction_0ElementType());

	public static final IGrammarAwareElementType TestLinewrap_LinewrapKeyword_1_ELEMENT_TYPE = associate(TestLinewrapFactory.createTestLinewrap_LinewrapKeyword_1ElementType());

	public static final IGrammarAwareElementType TestLinewrap_ItemsAssignment_2_ELEMENT_TYPE = associate(TestLinewrapFactory.createTestLinewrap_ItemsAssignment_2ElementType());

	public static final IGrammarAwareElementType TestLinewrap_ItemsLineParserRuleCall_2_0_ELEMENT_TYPE = associate(TestLinewrapFactory.createTestLinewrap_ItemsLineParserRuleCall_2_0ElementType());

	private static class TestLinewrapMinMaxFactory {
		public static IGrammarAwareElementType createTestLinewrapMinMaxElementType() {
			return new IGrammarAwareElementType("TestLinewrapMinMax_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapMinMaxRule());
		}
		public static IGrammarAwareElementType createTestLinewrapMinMax_GroupElementType() {
			return new IGrammarAwareElementType("TestLinewrapMinMax_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapMinMaxAccess().getGroup());
		}
		public static IGrammarAwareElementType createTestLinewrapMinMax_TestLinewrapMinMaxAction_0ElementType() {
			return new IGrammarAwareElementType("TestLinewrapMinMax_TestLinewrapMinMaxAction_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapMinMaxAccess().getTestLinewrapMinMaxAction_0());
		}
		public static IGrammarAwareElementType createTestLinewrapMinMax_WrapminmaxKeyword_1ElementType() {
			return new IGrammarAwareElementType("TestLinewrapMinMax_WrapminmaxKeyword_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapMinMaxAccess().getWrapminmaxKeyword_1());
		}
		public static IGrammarAwareElementType createTestLinewrapMinMax_ItemsAssignment_2ElementType() {
			return new IGrammarAwareElementType("TestLinewrapMinMax_ItemsAssignment_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapMinMaxAccess().getItemsAssignment_2());
		}
		public static IGrammarAwareElementType createTestLinewrapMinMax_ItemsLineParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TestLinewrapMinMax_ItemsLineParserRuleCall_2_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestLinewrapMinMaxAccess().getItemsLineParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType TestLinewrapMinMax_ELEMENT_TYPE = associate(TestLinewrapMinMaxFactory.createTestLinewrapMinMaxElementType());

	public static final IGrammarAwareElementType TestLinewrapMinMax_Group_ELEMENT_TYPE = associate(TestLinewrapMinMaxFactory.createTestLinewrapMinMax_GroupElementType());

	public static final IGrammarAwareElementType TestLinewrapMinMax_TestLinewrapMinMaxAction_0_ELEMENT_TYPE = associate(TestLinewrapMinMaxFactory.createTestLinewrapMinMax_TestLinewrapMinMaxAction_0ElementType());

	public static final IGrammarAwareElementType TestLinewrapMinMax_WrapminmaxKeyword_1_ELEMENT_TYPE = associate(TestLinewrapMinMaxFactory.createTestLinewrapMinMax_WrapminmaxKeyword_1ElementType());

	public static final IGrammarAwareElementType TestLinewrapMinMax_ItemsAssignment_2_ELEMENT_TYPE = associate(TestLinewrapMinMaxFactory.createTestLinewrapMinMax_ItemsAssignment_2ElementType());

	public static final IGrammarAwareElementType TestLinewrapMinMax_ItemsLineParserRuleCall_2_0_ELEMENT_TYPE = associate(TestLinewrapMinMaxFactory.createTestLinewrapMinMax_ItemsLineParserRuleCall_2_0ElementType());

	private static class TestIndentationFactory {
		public static IGrammarAwareElementType createTestIndentationElementType() {
			return new IGrammarAwareElementType("TestIndentation_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationRule());
		}
		public static IGrammarAwareElementType createTestIndentation_GroupElementType() {
			return new IGrammarAwareElementType("TestIndentation_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getGroup());
		}
		public static IGrammarAwareElementType createTestIndentation_TestIndentationAction_0ElementType() {
			return new IGrammarAwareElementType("TestIndentation_TestIndentationAction_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getTestIndentationAction_0());
		}
		public static IGrammarAwareElementType createTestIndentation_IndentationKeyword_1ElementType() {
			return new IGrammarAwareElementType("TestIndentation_IndentationKeyword_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getIndentationKeyword_1());
		}
		public static IGrammarAwareElementType createTestIndentation_LeftCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("TestIndentation_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getLeftCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createTestIndentation_ItemsAssignment_3ElementType() {
			return new IGrammarAwareElementType("TestIndentation_ItemsAssignment_3_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getItemsAssignment_3());
		}
		public static IGrammarAwareElementType createTestIndentation_ItemsAlternatives_3_0ElementType() {
			return new IGrammarAwareElementType("TestIndentation_ItemsAlternatives_3_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getItemsAlternatives_3_0());
		}
		public static IGrammarAwareElementType createTestIndentation_ItemsLineParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("TestIndentation_ItemsLineParserRuleCall_3_0_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getItemsLineParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createTestIndentation_ItemsTestIndentationParserRuleCall_3_0_1ElementType() {
			return new IGrammarAwareElementType("TestIndentation_ItemsTestIndentationParserRuleCall_3_0_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getItemsTestIndentationParserRuleCall_3_0_1());
		}
		public static IGrammarAwareElementType createTestIndentation_RightCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("TestIndentation_RightCurlyBracketKeyword_4_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getRightCurlyBracketKeyword_4());
		}
		public static IGrammarAwareElementType createTestIndentation_SemiAssignment_5ElementType() {
			return new IGrammarAwareElementType("TestIndentation_SemiAssignment_5_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getSemiAssignment_5());
		}
		public static IGrammarAwareElementType createTestIndentation_SemiSemicolonKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("TestIndentation_SemiSemicolonKeyword_5_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestIndentationAccess().getSemiSemicolonKeyword_5_0());
		}
	}

	public static final IGrammarAwareElementType TestIndentation_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentationElementType());

	public static final IGrammarAwareElementType TestIndentation_Group_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_GroupElementType());

	public static final IGrammarAwareElementType TestIndentation_TestIndentationAction_0_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_TestIndentationAction_0ElementType());

	public static final IGrammarAwareElementType TestIndentation_IndentationKeyword_1_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_IndentationKeyword_1ElementType());

	public static final IGrammarAwareElementType TestIndentation_LeftCurlyBracketKeyword_2_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_LeftCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType TestIndentation_ItemsAssignment_3_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_ItemsAssignment_3ElementType());

	public static final IGrammarAwareElementType TestIndentation_ItemsAlternatives_3_0_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_ItemsAlternatives_3_0ElementType());

	public static final IGrammarAwareElementType TestIndentation_ItemsLineParserRuleCall_3_0_0_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_ItemsLineParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType TestIndentation_ItemsTestIndentationParserRuleCall_3_0_1_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_ItemsTestIndentationParserRuleCall_3_0_1ElementType());

	public static final IGrammarAwareElementType TestIndentation_RightCurlyBracketKeyword_4_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_RightCurlyBracketKeyword_4ElementType());

	public static final IGrammarAwareElementType TestIndentation_SemiAssignment_5_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_SemiAssignment_5ElementType());

	public static final IGrammarAwareElementType TestIndentation_SemiSemicolonKeyword_5_0_ELEMENT_TYPE = associate(TestIndentationFactory.createTestIndentation_SemiSemicolonKeyword_5_0ElementType());

	private static class FqnObjFactory {
		public static IGrammarAwareElementType createFqnObjElementType() {
			return new IGrammarAwareElementType("FqnObj_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnObjRule());
		}
		public static IGrammarAwareElementType createFqnObj_GroupElementType() {
			return new IGrammarAwareElementType("FqnObj_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnObjAccess().getGroup());
		}
		public static IGrammarAwareElementType createFqnObj_FqnKeyword_0ElementType() {
			return new IGrammarAwareElementType("FqnObj_FqnKeyword_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnObjAccess().getFqnKeyword_0());
		}
		public static IGrammarAwareElementType createFqnObj_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("FqnObj_NameAssignment_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnObjAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createFqnObj_NameFQNParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("FqnObj_NameFQNParserRuleCall_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnObjAccess().getNameFQNParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType FqnObj_ELEMENT_TYPE = associate(FqnObjFactory.createFqnObjElementType());

	public static final IGrammarAwareElementType FqnObj_Group_ELEMENT_TYPE = associate(FqnObjFactory.createFqnObj_GroupElementType());

	public static final IGrammarAwareElementType FqnObj_FqnKeyword_0_ELEMENT_TYPE = associate(FqnObjFactory.createFqnObj_FqnKeyword_0ElementType());

	public static final IGrammarAwareElementType FqnObj_NameAssignment_1_ELEMENT_TYPE = associate(FqnObjFactory.createFqnObj_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType FqnObj_NameFQNParserRuleCall_1_0_ELEMENT_TYPE = associate(FqnObjFactory.createFqnObj_NameFQNParserRuleCall_1_0ElementType());

	private static class FQNFactory {
		public static IGrammarAwareElementType createFQNElementType() {
			return new IGrammarAwareElementType("FQN_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNRule());
		}
		public static IGrammarAwareElementType createFQN_GroupElementType() {
			return new IGrammarAwareElementType("FQN_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN_Group_1ElementType() {
			return new IGrammarAwareElementType("FQN_Group_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createFQN_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("FQN_FullStopKeyword_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType FQN_ELEMENT_TYPE = associate(FQNFactory.createFQNElementType());

	public static final IGrammarAwareElementType FQN_Group_ELEMENT_TYPE = associate(FQNFactory.createFQN_GroupElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType FQN_Group_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_Group_1ElementType());

	public static final IGrammarAwareElementType FQN_FullStopKeyword_1_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_1_1ElementType());

	private static class FqnRefFactory {
		public static IGrammarAwareElementType createFqnRefElementType() {
			return new IGrammarAwareElementType("FqnRef_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnRefRule());
		}
		public static IGrammarAwareElementType createFqnRef_GroupElementType() {
			return new IGrammarAwareElementType("FqnRef_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnRefAccess().getGroup());
		}
		public static IGrammarAwareElementType createFqnRef_FqnrefKeyword_0ElementType() {
			return new IGrammarAwareElementType("FqnRef_FqnrefKeyword_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnRefAccess().getFqnrefKeyword_0());
		}
		public static IGrammarAwareElementType createFqnRef_RefAssignment_1ElementType() {
			return new IGrammarAwareElementType("FqnRef_RefAssignment_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnRefAccess().getRefAssignment_1());
		}
		public static IGrammarAwareElementType createFqnRef_RefFqnObjCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("FqnRef_RefFqnObjCrossReference_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnRefAccess().getRefFqnObjCrossReference_1_0());
		}
		public static IGrammarAwareElementType createFqnRef_RefFqnObjFQNParserRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("FqnRef_RefFqnObjFQNParserRuleCall_1_0_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFqnRefAccess().getRefFqnObjFQNParserRuleCall_1_0_1());
		}
	}

	public static final IGrammarAwareElementType FqnRef_ELEMENT_TYPE = associate(FqnRefFactory.createFqnRefElementType());

	public static final IGrammarAwareElementType FqnRef_Group_ELEMENT_TYPE = associate(FqnRefFactory.createFqnRef_GroupElementType());

	public static final IGrammarAwareElementType FqnRef_FqnrefKeyword_0_ELEMENT_TYPE = associate(FqnRefFactory.createFqnRef_FqnrefKeyword_0ElementType());

	public static final IGrammarAwareElementType FqnRef_RefAssignment_1_ELEMENT_TYPE = associate(FqnRefFactory.createFqnRef_RefAssignment_1ElementType());

	public static final IGrammarAwareElementType FqnRef_RefFqnObjCrossReference_1_0_ELEMENT_TYPE = associate(FqnRefFactory.createFqnRef_RefFqnObjCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType FqnRef_RefFqnObjFQNParserRuleCall_1_0_1_ELEMENT_TYPE = associate(FqnRefFactory.createFqnRef_RefFqnObjFQNParserRuleCall_1_0_1ElementType());

	private static class EnumerationFactory {
		public static IGrammarAwareElementType createEnumerationElementType() {
			return new IGrammarAwareElementType("Enumeration_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumerationRule());
		}
		public static IGrammarAwareElementType createEnumeration_GroupElementType() {
			return new IGrammarAwareElementType("Enumeration_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumerationAccess().getGroup());
		}
		public static IGrammarAwareElementType createEnumeration_EnumKeyword_0ElementType() {
			return new IGrammarAwareElementType("Enumeration_EnumKeyword_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumerationAccess().getEnumKeyword_0());
		}
		public static IGrammarAwareElementType createEnumeration_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("Enumeration_ValAssignment_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumerationAccess().getValAssignment_1());
		}
		public static IGrammarAwareElementType createEnumeration_ValEnum1EnumRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Enumeration_ValEnum1EnumRuleCall_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumerationAccess().getValEnum1EnumRuleCall_1_0());
		}
		public static IGrammarAwareElementType createEnumeration_Group_2ElementType() {
			return new IGrammarAwareElementType("Enumeration_Group_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumerationAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createEnumeration_CommaKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Enumeration_CommaKeyword_2_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumerationAccess().getCommaKeyword_2_0());
		}
		public static IGrammarAwareElementType createEnumeration_ValAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Enumeration_ValAssignment_2_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumerationAccess().getValAssignment_2_1());
		}
		public static IGrammarAwareElementType createEnumeration_ValEnum1EnumRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Enumeration_ValEnum1EnumRuleCall_2_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumerationAccess().getValEnum1EnumRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType Enumeration_ELEMENT_TYPE = associate(EnumerationFactory.createEnumerationElementType());

	public static final IGrammarAwareElementType Enumeration_Group_ELEMENT_TYPE = associate(EnumerationFactory.createEnumeration_GroupElementType());

	public static final IGrammarAwareElementType Enumeration_EnumKeyword_0_ELEMENT_TYPE = associate(EnumerationFactory.createEnumeration_EnumKeyword_0ElementType());

	public static final IGrammarAwareElementType Enumeration_ValAssignment_1_ELEMENT_TYPE = associate(EnumerationFactory.createEnumeration_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType Enumeration_ValEnum1EnumRuleCall_1_0_ELEMENT_TYPE = associate(EnumerationFactory.createEnumeration_ValEnum1EnumRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Enumeration_Group_2_ELEMENT_TYPE = associate(EnumerationFactory.createEnumeration_Group_2ElementType());

	public static final IGrammarAwareElementType Enumeration_CommaKeyword_2_0_ELEMENT_TYPE = associate(EnumerationFactory.createEnumeration_CommaKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Enumeration_ValAssignment_2_1_ELEMENT_TYPE = associate(EnumerationFactory.createEnumeration_ValAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Enumeration_ValEnum1EnumRuleCall_2_1_0_ELEMENT_TYPE = associate(EnumerationFactory.createEnumeration_ValEnum1EnumRuleCall_2_1_0ElementType());

	private static class Enum1Factory {
		public static IGrammarAwareElementType createEnum1ElementType() {
			return new IGrammarAwareElementType("Enum1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Rule());
		}
		public static IGrammarAwareElementType createEnum1_AlternativesElementType() {
			return new IGrammarAwareElementType("Enum1_Alternatives_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Access().getAlternatives());
		}
		public static IGrammarAwareElementType createEnum1_Lit1EnumLiteralDeclaration_0ElementType() {
			return new IGrammarAwareElementType("Enum1_Lit1EnumLiteralDeclaration_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Access().getLit1EnumLiteralDeclaration_0());
		}
		public static IGrammarAwareElementType createEnum1_Lit1Lit1Keyword_0_0ElementType() {
			return new IGrammarAwareElementType("Enum1_Lit1Lit1Keyword_0_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Access().getLit1Lit1Keyword_0_0());
		}
		public static IGrammarAwareElementType createEnum1_Lit2EnumLiteralDeclaration_1ElementType() {
			return new IGrammarAwareElementType("Enum1_Lit2EnumLiteralDeclaration_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Access().getLit2EnumLiteralDeclaration_1());
		}
		public static IGrammarAwareElementType createEnum1_Lit2Lit2Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("Enum1_Lit2Lit2Keyword_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Access().getLit2Lit2Keyword_1_0());
		}
		public static IGrammarAwareElementType createEnum1_Lit3EnumLiteralDeclaration_2ElementType() {
			return new IGrammarAwareElementType("Enum1_Lit3EnumLiteralDeclaration_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Access().getLit3EnumLiteralDeclaration_2());
		}
		public static IGrammarAwareElementType createEnum1_Lit3Lit3Keyword_2_0ElementType() {
			return new IGrammarAwareElementType("Enum1_Lit3Lit3Keyword_2_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnum1Access().getLit3Lit3Keyword_2_0());
		}
	}

	public static final IGrammarAwareElementType Enum1_ELEMENT_TYPE = associate(Enum1Factory.createEnum1ElementType());

	public static final IGrammarAwareElementType Enum1_Alternatives_ELEMENT_TYPE = associate(Enum1Factory.createEnum1_AlternativesElementType());

	public static final IGrammarAwareElementType Enum1_Lit1EnumLiteralDeclaration_0_ELEMENT_TYPE = associate(Enum1Factory.createEnum1_Lit1EnumLiteralDeclaration_0ElementType());

	public static final IGrammarAwareElementType Enum1_Lit1Lit1Keyword_0_0_ELEMENT_TYPE = associate(Enum1Factory.createEnum1_Lit1Lit1Keyword_0_0ElementType());

	public static final IGrammarAwareElementType Enum1_Lit2EnumLiteralDeclaration_1_ELEMENT_TYPE = associate(Enum1Factory.createEnum1_Lit2EnumLiteralDeclaration_1ElementType());

	public static final IGrammarAwareElementType Enum1_Lit2Lit2Keyword_1_0_ELEMENT_TYPE = associate(Enum1Factory.createEnum1_Lit2Lit2Keyword_1_0ElementType());

	public static final IGrammarAwareElementType Enum1_Lit3EnumLiteralDeclaration_2_ELEMENT_TYPE = associate(Enum1Factory.createEnum1_Lit3EnumLiteralDeclaration_2ElementType());

	public static final IGrammarAwareElementType Enum1_Lit3Lit3Keyword_2_0_ELEMENT_TYPE = associate(Enum1Factory.createEnum1_Lit3Lit3Keyword_2_0ElementType());

	private static class SuppressedHiddenFactory {
		public static IGrammarAwareElementType createSuppressedHiddenElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenRule());
		}
		public static IGrammarAwareElementType createSuppressedHidden_GroupElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getGroup());
		}
		public static IGrammarAwareElementType createSuppressedHidden_SuppressedHiddenAction_0ElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_SuppressedHiddenAction_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getSuppressedHiddenAction_0());
		}
		public static IGrammarAwareElementType createSuppressedHidden_GraveAccentKeyword_1ElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_GraveAccentKeyword_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getGraveAccentKeyword_1());
		}
		public static IGrammarAwareElementType createSuppressedHidden_Group_2ElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_Group_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createSuppressedHidden_ValsAssignment_2_0ElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_ValsAssignment_2_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getValsAssignment_2_0());
		}
		public static IGrammarAwareElementType createSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_0_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getValsSuppressedHiddenSubParserRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createSuppressedHidden_Group_2_1ElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_Group_2_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getGroup_2_1());
		}
		public static IGrammarAwareElementType createSuppressedHidden_PercentSignKeyword_2_1_0ElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_PercentSignKeyword_2_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getPercentSignKeyword_2_1_0());
		}
		public static IGrammarAwareElementType createSuppressedHidden_ValsAssignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_ValsAssignment_2_1_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getValsAssignment_2_1_1());
		}
		public static IGrammarAwareElementType createSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_1_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getValsSuppressedHiddenSubParserRuleCall_2_1_1_0());
		}
		public static IGrammarAwareElementType createSuppressedHidden_GraveAccentKeyword_3ElementType() {
			return new IGrammarAwareElementType("SuppressedHidden_GraveAccentKeyword_3_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenAccess().getGraveAccentKeyword_3());
		}
	}

	public static final IGrammarAwareElementType SuppressedHidden_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHiddenElementType());

	public static final IGrammarAwareElementType SuppressedHidden_Group_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_GroupElementType());

	public static final IGrammarAwareElementType SuppressedHidden_SuppressedHiddenAction_0_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_SuppressedHiddenAction_0ElementType());

	public static final IGrammarAwareElementType SuppressedHidden_GraveAccentKeyword_1_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_GraveAccentKeyword_1ElementType());

	public static final IGrammarAwareElementType SuppressedHidden_Group_2_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_Group_2ElementType());

	public static final IGrammarAwareElementType SuppressedHidden_ValsAssignment_2_0_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_ValsAssignment_2_0ElementType());

	public static final IGrammarAwareElementType SuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_0_0_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType SuppressedHidden_Group_2_1_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_Group_2_1ElementType());

	public static final IGrammarAwareElementType SuppressedHidden_PercentSignKeyword_2_1_0_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_PercentSignKeyword_2_1_0ElementType());

	public static final IGrammarAwareElementType SuppressedHidden_ValsAssignment_2_1_1_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_ValsAssignment_2_1_1ElementType());

	public static final IGrammarAwareElementType SuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_1_1_0_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_1_1_0ElementType());

	public static final IGrammarAwareElementType SuppressedHidden_GraveAccentKeyword_3_ELEMENT_TYPE = associate(SuppressedHiddenFactory.createSuppressedHidden_GraveAccentKeyword_3ElementType());

	private static class SuppressedHiddenSubFactory {
		public static IGrammarAwareElementType createSuppressedHiddenSubElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSub_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubRule());
		}
		public static IGrammarAwareElementType createSuppressedHiddenSub_AlternativesElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSub_Alternatives_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createSuppressedHiddenSub_SuppressedHiddenSubSubParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSub_SuppressedHiddenSubSubParserRuleCall_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubAccess().getSuppressedHiddenSubSubParserRuleCall_0());
		}
		public static IGrammarAwareElementType createSuppressedHiddenSub_SuppressedHiddenSubIDParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSub_SuppressedHiddenSubIDParserRuleCall_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubAccess().getSuppressedHiddenSubIDParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType SuppressedHiddenSub_ELEMENT_TYPE = associate(SuppressedHiddenSubFactory.createSuppressedHiddenSubElementType());

	public static final IGrammarAwareElementType SuppressedHiddenSub_Alternatives_ELEMENT_TYPE = associate(SuppressedHiddenSubFactory.createSuppressedHiddenSub_AlternativesElementType());

	public static final IGrammarAwareElementType SuppressedHiddenSub_SuppressedHiddenSubSubParserRuleCall_0_ELEMENT_TYPE = associate(SuppressedHiddenSubFactory.createSuppressedHiddenSub_SuppressedHiddenSubSubParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType SuppressedHiddenSub_SuppressedHiddenSubIDParserRuleCall_1_ELEMENT_TYPE = associate(SuppressedHiddenSubFactory.createSuppressedHiddenSub_SuppressedHiddenSubIDParserRuleCall_1ElementType());

	private static class SuppressedHiddenSubSubFactory {
		public static IGrammarAwareElementType createSuppressedHiddenSubSubElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSubSub_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubSubRule());
		}
		public static IGrammarAwareElementType createSuppressedHiddenSubSub_GroupElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSubSub_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubSubAccess().getGroup());
		}
		public static IGrammarAwareElementType createSuppressedHiddenSubSub_LessThanSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSubSub_LessThanSignKeyword_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubSubAccess().getLessThanSignKeyword_0());
		}
		public static IGrammarAwareElementType createSuppressedHiddenSubSub_IdvalAssignment_1ElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSubSub_IdvalAssignment_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubSubAccess().getIdvalAssignment_1());
		}
		public static IGrammarAwareElementType createSuppressedHiddenSubSub_IdvalIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSubSub_IdvalIDTerminalRuleCall_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubSubAccess().getIdvalIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSuppressedHiddenSubSub_GreaterThanSignKeyword_2ElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSubSub_GreaterThanSignKeyword_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubSubAccess().getGreaterThanSignKeyword_2());
		}
	}

	public static final IGrammarAwareElementType SuppressedHiddenSubSub_ELEMENT_TYPE = associate(SuppressedHiddenSubSubFactory.createSuppressedHiddenSubSubElementType());

	public static final IGrammarAwareElementType SuppressedHiddenSubSub_Group_ELEMENT_TYPE = associate(SuppressedHiddenSubSubFactory.createSuppressedHiddenSubSub_GroupElementType());

	public static final IGrammarAwareElementType SuppressedHiddenSubSub_LessThanSignKeyword_0_ELEMENT_TYPE = associate(SuppressedHiddenSubSubFactory.createSuppressedHiddenSubSub_LessThanSignKeyword_0ElementType());

	public static final IGrammarAwareElementType SuppressedHiddenSubSub_IdvalAssignment_1_ELEMENT_TYPE = associate(SuppressedHiddenSubSubFactory.createSuppressedHiddenSubSub_IdvalAssignment_1ElementType());

	public static final IGrammarAwareElementType SuppressedHiddenSubSub_IdvalIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SuppressedHiddenSubSubFactory.createSuppressedHiddenSubSub_IdvalIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType SuppressedHiddenSubSub_GreaterThanSignKeyword_2_ELEMENT_TYPE = associate(SuppressedHiddenSubSubFactory.createSuppressedHiddenSubSub_GreaterThanSignKeyword_2ElementType());

	private static class SuppressedHiddenSubIDFactory {
		public static IGrammarAwareElementType createSuppressedHiddenSubIDElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSubID_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubIDRule());
		}
		public static IGrammarAwareElementType createSuppressedHiddenSubID_IdvalAssignmentElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSubID_IdvalAssignment_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubIDAccess().getIdvalAssignment());
		}
		public static IGrammarAwareElementType createSuppressedHiddenSubID_IdvalIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("SuppressedHiddenSubID_IdvalIDTerminalRuleCall_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuppressedHiddenSubIDAccess().getIdvalIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType SuppressedHiddenSubID_ELEMENT_TYPE = associate(SuppressedHiddenSubIDFactory.createSuppressedHiddenSubIDElementType());

	public static final IGrammarAwareElementType SuppressedHiddenSubID_IdvalAssignment_ELEMENT_TYPE = associate(SuppressedHiddenSubIDFactory.createSuppressedHiddenSubID_IdvalAssignmentElementType());

	public static final IGrammarAwareElementType SuppressedHiddenSubID_IdvalIDTerminalRuleCall_0_ELEMENT_TYPE = associate(SuppressedHiddenSubIDFactory.createSuppressedHiddenSubID_IdvalIDTerminalRuleCall_0ElementType());

	private static class Datatype1Factory {
		public static IGrammarAwareElementType createDatatype1ElementType() {
			return new IGrammarAwareElementType("Datatype1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatype1Rule());
		}
		public static IGrammarAwareElementType createDatatype1_FQNParserRuleCallElementType() {
			return new IGrammarAwareElementType("Datatype1_FQNParserRuleCall_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatype1Access().getFQNParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType Datatype1_ELEMENT_TYPE = associate(Datatype1Factory.createDatatype1ElementType());

	public static final IGrammarAwareElementType Datatype1_FQNParserRuleCall_ELEMENT_TYPE = associate(Datatype1Factory.createDatatype1_FQNParserRuleCallElementType());

	private static class Datatype2Factory {
		public static IGrammarAwareElementType createDatatype2ElementType() {
			return new IGrammarAwareElementType("Datatype2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatype2Rule());
		}
		public static IGrammarAwareElementType createDatatype2_FQNParserRuleCallElementType() {
			return new IGrammarAwareElementType("Datatype2_FQNParserRuleCall_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatype2Access().getFQNParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType Datatype2_ELEMENT_TYPE = associate(Datatype2Factory.createDatatype2ElementType());

	public static final IGrammarAwareElementType Datatype2_FQNParserRuleCall_ELEMENT_TYPE = associate(Datatype2Factory.createDatatype2_FQNParserRuleCallElementType());

	private static class Datatype3Factory {
		public static IGrammarAwareElementType createDatatype3ElementType() {
			return new IGrammarAwareElementType("Datatype3_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatype3Rule());
		}
		public static IGrammarAwareElementType createDatatype3_FQNParserRuleCallElementType() {
			return new IGrammarAwareElementType("Datatype3_FQNParserRuleCall_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatype3Access().getFQNParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType Datatype3_ELEMENT_TYPE = associate(Datatype3Factory.createDatatype3ElementType());

	public static final IGrammarAwareElementType Datatype3_FQNParserRuleCall_ELEMENT_TYPE = associate(Datatype3Factory.createDatatype3_FQNParserRuleCallElementType());

	private static class DatatypesFactory {
		public static IGrammarAwareElementType createDatatypesElementType() {
			return new IGrammarAwareElementType("Datatypes_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesRule());
		}
		public static IGrammarAwareElementType createDatatypes_GroupElementType() {
			return new IGrammarAwareElementType("Datatypes_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesAccess().getGroup());
		}
		public static IGrammarAwareElementType createDatatypes_DatatypesKeyword_0ElementType() {
			return new IGrammarAwareElementType("Datatypes_DatatypesKeyword_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesAccess().getDatatypesKeyword_0());
		}
		public static IGrammarAwareElementType createDatatypes_Val1Assignment_1ElementType() {
			return new IGrammarAwareElementType("Datatypes_Val1Assignment_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesAccess().getVal1Assignment_1());
		}
		public static IGrammarAwareElementType createDatatypes_Val1Datatype1ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Datatypes_Val1Datatype1ParserRuleCall_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesAccess().getVal1Datatype1ParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createDatatypes_Kw1Keyword_2ElementType() {
			return new IGrammarAwareElementType("Datatypes_Kw1Keyword_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesAccess().getKw1Keyword_2());
		}
		public static IGrammarAwareElementType createDatatypes_Val2Assignment_3ElementType() {
			return new IGrammarAwareElementType("Datatypes_Val2Assignment_3_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesAccess().getVal2Assignment_3());
		}
		public static IGrammarAwareElementType createDatatypes_Val2Datatype2ParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Datatypes_Val2Datatype2ParserRuleCall_3_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesAccess().getVal2Datatype2ParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createDatatypes_Val3Assignment_4ElementType() {
			return new IGrammarAwareElementType("Datatypes_Val3Assignment_4_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesAccess().getVal3Assignment_4());
		}
		public static IGrammarAwareElementType createDatatypes_Val3Datatype3ParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Datatypes_Val3Datatype3ParserRuleCall_4_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesAccess().getVal3Datatype3ParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createDatatypes_Kw3Keyword_5ElementType() {
			return new IGrammarAwareElementType("Datatypes_Kw3Keyword_5_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypesAccess().getKw3Keyword_5());
		}
	}

	public static final IGrammarAwareElementType Datatypes_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypesElementType());

	public static final IGrammarAwareElementType Datatypes_Group_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypes_GroupElementType());

	public static final IGrammarAwareElementType Datatypes_DatatypesKeyword_0_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypes_DatatypesKeyword_0ElementType());

	public static final IGrammarAwareElementType Datatypes_Val1Assignment_1_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypes_Val1Assignment_1ElementType());

	public static final IGrammarAwareElementType Datatypes_Val1Datatype1ParserRuleCall_1_0_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypes_Val1Datatype1ParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Datatypes_Kw1Keyword_2_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypes_Kw1Keyword_2ElementType());

	public static final IGrammarAwareElementType Datatypes_Val2Assignment_3_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypes_Val2Assignment_3ElementType());

	public static final IGrammarAwareElementType Datatypes_Val2Datatype2ParserRuleCall_3_0_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypes_Val2Datatype2ParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Datatypes_Val3Assignment_4_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypes_Val3Assignment_4ElementType());

	public static final IGrammarAwareElementType Datatypes_Val3Datatype3ParserRuleCall_4_0_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypes_Val3Datatype3ParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Datatypes_Kw3Keyword_5_ELEMENT_TYPE = associate(DatatypesFactory.createDatatypes_Kw3Keyword_5ElementType());

	private static class WrappingDataTypeTestFactory {
		public static IGrammarAwareElementType createWrappingDataTypeTestElementType() {
			return new IGrammarAwareElementType("WrappingDataTypeTest_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWrappingDataTypeTestRule());
		}
		public static IGrammarAwareElementType createWrappingDataTypeTest_GroupElementType() {
			return new IGrammarAwareElementType("WrappingDataTypeTest_Group_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWrappingDataTypeTestAccess().getGroup());
		}
		public static IGrammarAwareElementType createWrappingDataTypeTest_WrappingdtKeyword_0ElementType() {
			return new IGrammarAwareElementType("WrappingDataTypeTest_WrappingdtKeyword_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWrappingDataTypeTestAccess().getWrappingdtKeyword_0());
		}
		public static IGrammarAwareElementType createWrappingDataTypeTest_DatatypeAssignment_1ElementType() {
			return new IGrammarAwareElementType("WrappingDataTypeTest_DatatypeAssignment_1_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWrappingDataTypeTestAccess().getDatatypeAssignment_1());
		}
		public static IGrammarAwareElementType createWrappingDataTypeTest_DatatypeWrappingDataTypeParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("WrappingDataTypeTest_DatatypeWrappingDataTypeParserRuleCall_1_0_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWrappingDataTypeTestAccess().getDatatypeWrappingDataTypeParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createWrappingDataTypeTest_Kw1Keyword_2ElementType() {
			return new IGrammarAwareElementType("WrappingDataTypeTest_Kw1Keyword_2_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWrappingDataTypeTestAccess().getKw1Keyword_2());
		}
	}

	public static final IGrammarAwareElementType WrappingDataTypeTest_ELEMENT_TYPE = associate(WrappingDataTypeTestFactory.createWrappingDataTypeTestElementType());

	public static final IGrammarAwareElementType WrappingDataTypeTest_Group_ELEMENT_TYPE = associate(WrappingDataTypeTestFactory.createWrappingDataTypeTest_GroupElementType());

	public static final IGrammarAwareElementType WrappingDataTypeTest_WrappingdtKeyword_0_ELEMENT_TYPE = associate(WrappingDataTypeTestFactory.createWrappingDataTypeTest_WrappingdtKeyword_0ElementType());

	public static final IGrammarAwareElementType WrappingDataTypeTest_DatatypeAssignment_1_ELEMENT_TYPE = associate(WrappingDataTypeTestFactory.createWrappingDataTypeTest_DatatypeAssignment_1ElementType());

	public static final IGrammarAwareElementType WrappingDataTypeTest_DatatypeWrappingDataTypeParserRuleCall_1_0_ELEMENT_TYPE = associate(WrappingDataTypeTestFactory.createWrappingDataTypeTest_DatatypeWrappingDataTypeParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType WrappingDataTypeTest_Kw1Keyword_2_ELEMENT_TYPE = associate(WrappingDataTypeTestFactory.createWrappingDataTypeTest_Kw1Keyword_2ElementType());

	private static class WrappingDataTypeFactory {
		public static IGrammarAwareElementType createWrappingDataTypeElementType() {
			return new IGrammarAwareElementType("WrappingDataType_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWrappingDataTypeRule());
		}
		public static IGrammarAwareElementType createWrappingDataType_IDTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("WrappingDataType_IDTerminalRuleCall_ELEMENT_TYPE", FormatterTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWrappingDataTypeAccess().getIDTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType WrappingDataType_ELEMENT_TYPE = associate(WrappingDataTypeFactory.createWrappingDataTypeElementType());

	public static final IGrammarAwareElementType WrappingDataType_IDTerminalRuleCall_ELEMENT_TYPE = associate(WrappingDataTypeFactory.createWrappingDataType_IDTerminalRuleCallElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getRootElementType() {
		return Root_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_GroupElementType() {
		return Root_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_TestKeyword_0ElementType() {
		return Root_TestKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_Alternatives_1ElementType() {
		return Root_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_TestLinewrapParserRuleCall_1_0ElementType() {
		return Root_TestLinewrapParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_TestIndentationParserRuleCall_1_1ElementType() {
		return Root_TestIndentationParserRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_TestLinewrapMinMaxParserRuleCall_1_2ElementType() {
		return Root_TestLinewrapMinMaxParserRuleCall_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_WrappingDataTypeTestParserRuleCall_1_3ElementType() {
		return Root_WrappingDataTypeTestParserRuleCall_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLineElementType() {
		return Line_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_GroupElementType() {
		return Line_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_Alternatives_0ElementType() {
		return Line_Alternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_DeclParserRuleCall_0_0ElementType() {
		return Line_DeclParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_AssignParserRuleCall_0_1ElementType() {
		return Line_AssignParserRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_MethParserRuleCall_0_2ElementType() {
		return Line_MethParserRuleCall_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_FqnObjParserRuleCall_0_3ElementType() {
		return Line_FqnObjParserRuleCall_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_FqnRefParserRuleCall_0_4ElementType() {
		return Line_FqnRefParserRuleCall_0_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_EnumerationParserRuleCall_0_5ElementType() {
		return Line_EnumerationParserRuleCall_0_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_Group_0_6ElementType() {
		return Line_Group_0_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_SuppressedHiddenParserRuleCall_0_6_0ElementType() {
		return Line_SuppressedHiddenParserRuleCall_0_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_PostKeyword_0_6_1ElementType() {
		return Line_PostKeyword_0_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_SpaceParserRuleCall_0_7ElementType() {
		return Line_SpaceParserRuleCall_0_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_DatatypesParserRuleCall_0_8ElementType() {
		return Line_DatatypesParserRuleCall_0_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLine_SemicolonKeyword_1ElementType() {
		return Line_SemicolonKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDeclElementType() {
		return Decl_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDecl_GroupElementType() {
		return Decl_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDecl_TypeAssignment_0ElementType() {
		return Decl_TypeAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDecl_TypeIDTerminalRuleCall_0_0ElementType() {
		return Decl_TypeIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDecl_NameAssignment_1ElementType() {
		return Decl_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDecl_NameIDTerminalRuleCall_1_0ElementType() {
		return Decl_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignElementType() {
		return Assign_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_GroupElementType() {
		return Assign_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_VarAssignment_0ElementType() {
		return Assign_VarAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_VarIDTerminalRuleCall_0_0ElementType() {
		return Assign_VarIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_OpAssignment_1ElementType() {
		return Assign_OpAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_OpAlternatives_1_0ElementType() {
		return Assign_OpAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_OpEqualsSignKeyword_1_0_0ElementType() {
		return Assign_OpEqualsSignKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_OpPlusSignEqualsSignKeyword_1_0_1ElementType() {
		return Assign_OpPlusSignEqualsSignKeyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_LeftSquareBracketKeyword_2ElementType() {
		return Assign_LeftSquareBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_Group_3ElementType() {
		return Assign_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_ValAssignment_3_0ElementType() {
		return Assign_ValAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_ValINTTerminalRuleCall_3_0_0ElementType() {
		return Assign_ValINTTerminalRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_Group_3_1ElementType() {
		return Assign_Group_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_CommaKeyword_3_1_0ElementType() {
		return Assign_CommaKeyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_ValAssignment_3_1_1ElementType() {
		return Assign_ValAssignment_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_ValINTTerminalRuleCall_3_1_1_0ElementType() {
		return Assign_ValINTTerminalRuleCall_3_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssign_RightSquareBracketKeyword_4ElementType() {
		return Assign_RightSquareBracketKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMethElementType() {
		return Meth_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_GroupElementType() {
		return Meth_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_VoidKeyword_0ElementType() {
		return Meth_VoidKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_NameAssignment_1ElementType() {
		return Meth_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_NameIDTerminalRuleCall_1_0ElementType() {
		return Meth_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_LeftParenthesisKeyword_2ElementType() {
		return Meth_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_Group_3ElementType() {
		return Meth_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_ParamAssignment_3_0ElementType() {
		return Meth_ParamAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_ParamParamParserRuleCall_3_0_0ElementType() {
		return Meth_ParamParamParserRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_Group_3_1ElementType() {
		return Meth_Group_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_CommaKeyword_3_1_0ElementType() {
		return Meth_CommaKeyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_ParamAssignment_3_1_1ElementType() {
		return Meth_ParamAssignment_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_ParamParamParserRuleCall_3_1_1_0ElementType() {
		return Meth_ParamParamParserRuleCall_3_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMeth_RightParenthesisKeyword_4ElementType() {
		return Meth_RightParenthesisKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParamElementType() {
		return Param_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParam_GroupElementType() {
		return Param_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParam_NameAssignment_0ElementType() {
		return Param_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParam_NameIDTerminalRuleCall_0_0ElementType() {
		return Param_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParam_ColonKeyword_1ElementType() {
		return Param_ColonKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParam_TypeAssignment_2ElementType() {
		return Param_TypeAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParam_TypeIDTerminalRuleCall_2_0ElementType() {
		return Param_TypeIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpaceElementType() {
		return Space_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpace_GroupElementType() {
		return Space_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpace_SpaceKeyword_0ElementType() {
		return Space_SpaceKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpace_ValAssignment_1ElementType() {
		return Space_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpace_ValIDTerminalRuleCall_1_0ElementType() {
		return Space_ValIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrapElementType() {
		return TestLinewrap_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrap_GroupElementType() {
		return TestLinewrap_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrap_TestLinewrapAction_0ElementType() {
		return TestLinewrap_TestLinewrapAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrap_LinewrapKeyword_1ElementType() {
		return TestLinewrap_LinewrapKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrap_ItemsAssignment_2ElementType() {
		return TestLinewrap_ItemsAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrap_ItemsLineParserRuleCall_2_0ElementType() {
		return TestLinewrap_ItemsLineParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrapMinMaxElementType() {
		return TestLinewrapMinMax_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrapMinMax_GroupElementType() {
		return TestLinewrapMinMax_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrapMinMax_TestLinewrapMinMaxAction_0ElementType() {
		return TestLinewrapMinMax_TestLinewrapMinMaxAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrapMinMax_WrapminmaxKeyword_1ElementType() {
		return TestLinewrapMinMax_WrapminmaxKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrapMinMax_ItemsAssignment_2ElementType() {
		return TestLinewrapMinMax_ItemsAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestLinewrapMinMax_ItemsLineParserRuleCall_2_0ElementType() {
		return TestLinewrapMinMax_ItemsLineParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentationElementType() {
		return TestIndentation_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_GroupElementType() {
		return TestIndentation_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_TestIndentationAction_0ElementType() {
		return TestIndentation_TestIndentationAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_IndentationKeyword_1ElementType() {
		return TestIndentation_IndentationKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_LeftCurlyBracketKeyword_2ElementType() {
		return TestIndentation_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_ItemsAssignment_3ElementType() {
		return TestIndentation_ItemsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_ItemsAlternatives_3_0ElementType() {
		return TestIndentation_ItemsAlternatives_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_ItemsLineParserRuleCall_3_0_0ElementType() {
		return TestIndentation_ItemsLineParserRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_ItemsTestIndentationParserRuleCall_3_0_1ElementType() {
		return TestIndentation_ItemsTestIndentationParserRuleCall_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_RightCurlyBracketKeyword_4ElementType() {
		return TestIndentation_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_SemiAssignment_5ElementType() {
		return TestIndentation_SemiAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestIndentation_SemiSemicolonKeyword_5_0ElementType() {
		return TestIndentation_SemiSemicolonKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnObjElementType() {
		return FqnObj_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnObj_GroupElementType() {
		return FqnObj_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnObj_FqnKeyword_0ElementType() {
		return FqnObj_FqnKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnObj_NameAssignment_1ElementType() {
		return FqnObj_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnObj_NameFQNParserRuleCall_1_0ElementType() {
		return FqnObj_NameFQNParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQNElementType() {
		return FQN_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_GroupElementType() {
		return FQN_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_IDTerminalRuleCall_0ElementType() {
		return FQN_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_Group_1ElementType() {
		return FQN_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_FullStopKeyword_1_0ElementType() {
		return FQN_FullStopKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN_IDTerminalRuleCall_1_1ElementType() {
		return FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnRefElementType() {
		return FqnRef_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnRef_GroupElementType() {
		return FqnRef_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnRef_FqnrefKeyword_0ElementType() {
		return FqnRef_FqnrefKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnRef_RefAssignment_1ElementType() {
		return FqnRef_RefAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnRef_RefFqnObjCrossReference_1_0ElementType() {
		return FqnRef_RefFqnObjCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFqnRef_RefFqnObjFQNParserRuleCall_1_0_1ElementType() {
		return FqnRef_RefFqnObjFQNParserRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumerationElementType() {
		return Enumeration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumeration_GroupElementType() {
		return Enumeration_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumeration_EnumKeyword_0ElementType() {
		return Enumeration_EnumKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumeration_ValAssignment_1ElementType() {
		return Enumeration_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumeration_ValEnum1EnumRuleCall_1_0ElementType() {
		return Enumeration_ValEnum1EnumRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumeration_Group_2ElementType() {
		return Enumeration_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumeration_CommaKeyword_2_0ElementType() {
		return Enumeration_CommaKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumeration_ValAssignment_2_1ElementType() {
		return Enumeration_ValAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumeration_ValEnum1EnumRuleCall_2_1_0ElementType() {
		return Enumeration_ValEnum1EnumRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1ElementType() {
		return Enum1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1_AlternativesElementType() {
		return Enum1_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1_Lit1EnumLiteralDeclaration_0ElementType() {
		return Enum1_Lit1EnumLiteralDeclaration_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1_Lit1Lit1Keyword_0_0ElementType() {
		return Enum1_Lit1Lit1Keyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1_Lit2EnumLiteralDeclaration_1ElementType() {
		return Enum1_Lit2EnumLiteralDeclaration_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1_Lit2Lit2Keyword_1_0ElementType() {
		return Enum1_Lit2Lit2Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1_Lit3EnumLiteralDeclaration_2ElementType() {
		return Enum1_Lit3EnumLiteralDeclaration_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum1_Lit3Lit3Keyword_2_0ElementType() {
		return Enum1_Lit3Lit3Keyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenElementType() {
		return SuppressedHidden_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_GroupElementType() {
		return SuppressedHidden_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_SuppressedHiddenAction_0ElementType() {
		return SuppressedHidden_SuppressedHiddenAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_GraveAccentKeyword_1ElementType() {
		return SuppressedHidden_GraveAccentKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_Group_2ElementType() {
		return SuppressedHidden_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_ValsAssignment_2_0ElementType() {
		return SuppressedHidden_ValsAssignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_0_0ElementType() {
		return SuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_Group_2_1ElementType() {
		return SuppressedHidden_Group_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_PercentSignKeyword_2_1_0ElementType() {
		return SuppressedHidden_PercentSignKeyword_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_ValsAssignment_2_1_1ElementType() {
		return SuppressedHidden_ValsAssignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_1_1_0ElementType() {
		return SuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHidden_GraveAccentKeyword_3ElementType() {
		return SuppressedHidden_GraveAccentKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSubElementType() {
		return SuppressedHiddenSub_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSub_AlternativesElementType() {
		return SuppressedHiddenSub_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSub_SuppressedHiddenSubSubParserRuleCall_0ElementType() {
		return SuppressedHiddenSub_SuppressedHiddenSubSubParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSub_SuppressedHiddenSubIDParserRuleCall_1ElementType() {
		return SuppressedHiddenSub_SuppressedHiddenSubIDParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSubSubElementType() {
		return SuppressedHiddenSubSub_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSubSub_GroupElementType() {
		return SuppressedHiddenSubSub_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSubSub_LessThanSignKeyword_0ElementType() {
		return SuppressedHiddenSubSub_LessThanSignKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSubSub_IdvalAssignment_1ElementType() {
		return SuppressedHiddenSubSub_IdvalAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSubSub_IdvalIDTerminalRuleCall_1_0ElementType() {
		return SuppressedHiddenSubSub_IdvalIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSubSub_GreaterThanSignKeyword_2ElementType() {
		return SuppressedHiddenSubSub_GreaterThanSignKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSubIDElementType() {
		return SuppressedHiddenSubID_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSubID_IdvalAssignmentElementType() {
		return SuppressedHiddenSubID_IdvalAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuppressedHiddenSubID_IdvalIDTerminalRuleCall_0ElementType() {
		return SuppressedHiddenSubID_IdvalIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype1ElementType() {
		return Datatype1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype1_FQNParserRuleCallElementType() {
		return Datatype1_FQNParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype2ElementType() {
		return Datatype2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype2_FQNParserRuleCallElementType() {
		return Datatype2_FQNParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype3ElementType() {
		return Datatype3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype3_FQNParserRuleCallElementType() {
		return Datatype3_FQNParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypesElementType() {
		return Datatypes_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypes_GroupElementType() {
		return Datatypes_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypes_DatatypesKeyword_0ElementType() {
		return Datatypes_DatatypesKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypes_Val1Assignment_1ElementType() {
		return Datatypes_Val1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypes_Val1Datatype1ParserRuleCall_1_0ElementType() {
		return Datatypes_Val1Datatype1ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypes_Kw1Keyword_2ElementType() {
		return Datatypes_Kw1Keyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypes_Val2Assignment_3ElementType() {
		return Datatypes_Val2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypes_Val2Datatype2ParserRuleCall_3_0ElementType() {
		return Datatypes_Val2Datatype2ParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypes_Val3Assignment_4ElementType() {
		return Datatypes_Val3Assignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypes_Val3Datatype3ParserRuleCall_4_0ElementType() {
		return Datatypes_Val3Datatype3ParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypes_Kw3Keyword_5ElementType() {
		return Datatypes_Kw3Keyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWrappingDataTypeTestElementType() {
		return WrappingDataTypeTest_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWrappingDataTypeTest_GroupElementType() {
		return WrappingDataTypeTest_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWrappingDataTypeTest_WrappingdtKeyword_0ElementType() {
		return WrappingDataTypeTest_WrappingdtKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWrappingDataTypeTest_DatatypeAssignment_1ElementType() {
		return WrappingDataTypeTest_DatatypeAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWrappingDataTypeTest_DatatypeWrappingDataTypeParserRuleCall_1_0ElementType() {
		return WrappingDataTypeTest_DatatypeWrappingDataTypeParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWrappingDataTypeTest_Kw1Keyword_2ElementType() {
		return WrappingDataTypeTest_Kw1Keyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWrappingDataTypeElementType() {
		return WrappingDataType_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWrappingDataType_IDTerminalRuleCallElementType() {
		return WrappingDataType_IDTerminalRuleCall_ELEMENT_TYPE;
	}

}
