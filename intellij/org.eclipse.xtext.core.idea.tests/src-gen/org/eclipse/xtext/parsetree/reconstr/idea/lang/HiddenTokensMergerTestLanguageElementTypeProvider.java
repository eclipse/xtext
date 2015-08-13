package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.HiddenTokensMergerTestLanguageFileImpl;
import org.eclipse.xtext.parsetree.reconstr.services.HiddenTokensMergerTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class HiddenTokensMergerTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<HiddenTokensMergerTestLanguageFileImpl>>(HiddenTokensMergerTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final HiddenTokensMergerTestLanguageGrammarAccess GRAMMAR_ACCESS = HiddenTokensMergerTestLanguageLanguage.INSTANCE.getInstance(HiddenTokensMergerTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_DatatypeBug286557ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_DatatypeBug286557ParserRuleCall_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDatatypeBug286557ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createModel_EnumBugParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Model_EnumBugParserRuleCall_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEnumBugParserRuleCall_1());
		}
		public static IGrammarAwareElementType createModel_CommentableParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Model_CommentableParserRuleCall_2_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getCommentableParserRuleCall_2());
		}
		public static IGrammarAwareElementType createModel_ValueListParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Model_ValueListParserRuleCall_3_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueListParserRuleCall_3());
		}
		public static IGrammarAwareElementType createModel_RefListParserRuleCall_4ElementType() {
			return new IGrammarAwareElementType("Model_RefListParserRuleCall_4_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRefListParserRuleCall_4());
		}
		public static IGrammarAwareElementType createModel_SingleRefParserRuleCall_5ElementType() {
			return new IGrammarAwareElementType("Model_SingleRefParserRuleCall_5_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSingleRefParserRuleCall_5());
		}
		public static IGrammarAwareElementType createModel_AppendToFileEndParserRuleCall_6ElementType() {
			return new IGrammarAwareElementType("Model_AppendToFileEndParserRuleCall_6_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAppendToFileEndParserRuleCall_6());
		}
		public static IGrammarAwareElementType createModel_Action1ParserRuleCall_7ElementType() {
			return new IGrammarAwareElementType("Model_Action1ParserRuleCall_7_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAction1ParserRuleCall_7());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_DatatypeBug286557ParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DatatypeBug286557ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Model_EnumBugParserRuleCall_1_ELEMENT_TYPE = associate(ModelFactory.createModel_EnumBugParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Model_CommentableParserRuleCall_2_ELEMENT_TYPE = associate(ModelFactory.createModel_CommentableParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType Model_ValueListParserRuleCall_3_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueListParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType Model_RefListParserRuleCall_4_ELEMENT_TYPE = associate(ModelFactory.createModel_RefListParserRuleCall_4ElementType());

	public static final IGrammarAwareElementType Model_SingleRefParserRuleCall_5_ELEMENT_TYPE = associate(ModelFactory.createModel_SingleRefParserRuleCall_5ElementType());

	public static final IGrammarAwareElementType Model_AppendToFileEndParserRuleCall_6_ELEMENT_TYPE = associate(ModelFactory.createModel_AppendToFileEndParserRuleCall_6ElementType());

	public static final IGrammarAwareElementType Model_Action1ParserRuleCall_7_ELEMENT_TYPE = associate(ModelFactory.createModel_Action1ParserRuleCall_7ElementType());

	private static class DatatypeBug286557Factory {
		public static IGrammarAwareElementType createDatatypeBug286557ElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Rule());
		}
		public static IGrammarAwareElementType createDatatypeBug286557_GroupElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Access().getGroup());
		}
		public static IGrammarAwareElementType createDatatypeBug286557_NumberSignDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_NumberSignDigitOneKeyword_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Access().getNumberSignDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createDatatypeBug286557_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_NameAssignment_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createDatatypeBug286557_NameFQNParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_NameFQNParserRuleCall_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Access().getNameFQNParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createDatatypeBug286557_Group_2ElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_Group_2_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Access().getGroup_2());
		}
		public static IGrammarAwareElementType createDatatypeBug286557_RefKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_RefKeyword_2_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Access().getRefKeyword_2_0());
		}
		public static IGrammarAwareElementType createDatatypeBug286557_RefAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_RefAssignment_2_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Access().getRefAssignment_2_1());
		}
		public static IGrammarAwareElementType createDatatypeBug286557_RefDatatypeBug286557CrossReference_2_1_0ElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_RefDatatypeBug286557CrossReference_2_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Access().getRefDatatypeBug286557CrossReference_2_1_0());
		}
		public static IGrammarAwareElementType createDatatypeBug286557_RefDatatypeBug286557FQNParserRuleCall_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_RefDatatypeBug286557FQNParserRuleCall_2_1_0_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Access().getRefDatatypeBug286557FQNParserRuleCall_2_1_0_1());
		}
		public static IGrammarAwareElementType createDatatypeBug286557_SemicolonKeyword_3ElementType() {
			return new IGrammarAwareElementType("DatatypeBug286557_SemicolonKeyword_3_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeBug286557Access().getSemicolonKeyword_3());
		}
	}

	public static final IGrammarAwareElementType DatatypeBug286557_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557ElementType());

	public static final IGrammarAwareElementType DatatypeBug286557_Group_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557_GroupElementType());

	public static final IGrammarAwareElementType DatatypeBug286557_NumberSignDigitOneKeyword_0_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557_NumberSignDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType DatatypeBug286557_NameAssignment_1_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType DatatypeBug286557_NameFQNParserRuleCall_1_0_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557_NameFQNParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType DatatypeBug286557_Group_2_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557_Group_2ElementType());

	public static final IGrammarAwareElementType DatatypeBug286557_RefKeyword_2_0_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557_RefKeyword_2_0ElementType());

	public static final IGrammarAwareElementType DatatypeBug286557_RefAssignment_2_1_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557_RefAssignment_2_1ElementType());

	public static final IGrammarAwareElementType DatatypeBug286557_RefDatatypeBug286557CrossReference_2_1_0_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557_RefDatatypeBug286557CrossReference_2_1_0ElementType());

	public static final IGrammarAwareElementType DatatypeBug286557_RefDatatypeBug286557FQNParserRuleCall_2_1_0_1_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557_RefDatatypeBug286557FQNParserRuleCall_2_1_0_1ElementType());

	public static final IGrammarAwareElementType DatatypeBug286557_SemicolonKeyword_3_ELEMENT_TYPE = associate(DatatypeBug286557Factory.createDatatypeBug286557_SemicolonKeyword_3ElementType());

	private static class FQNFactory {
		public static IGrammarAwareElementType createFQNElementType() {
			return new IGrammarAwareElementType("FQN_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNRule());
		}
		public static IGrammarAwareElementType createFQN_GroupElementType() {
			return new IGrammarAwareElementType("FQN_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN_Group_1ElementType() {
			return new IGrammarAwareElementType("FQN_Group_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createFQN_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("FQN_FullStopKeyword_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType FQN_ELEMENT_TYPE = associate(FQNFactory.createFQNElementType());

	public static final IGrammarAwareElementType FQN_Group_ELEMENT_TYPE = associate(FQNFactory.createFQN_GroupElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType FQN_Group_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_Group_1ElementType());

	public static final IGrammarAwareElementType FQN_FullStopKeyword_1_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_1_1ElementType());

	private static class EnumBugFactory {
		public static IGrammarAwareElementType createEnumBugElementType() {
			return new IGrammarAwareElementType("EnumBug_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugRule());
		}
		public static IGrammarAwareElementType createEnumBug_GroupElementType() {
			return new IGrammarAwareElementType("EnumBug_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugAccess().getGroup());
		}
		public static IGrammarAwareElementType createEnumBug_NumberSignDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("EnumBug_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugAccess().getNumberSignDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createEnumBug_Kw1Keyword_1ElementType() {
			return new IGrammarAwareElementType("EnumBug_Kw1Keyword_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugAccess().getKw1Keyword_1());
		}
		public static IGrammarAwareElementType createEnumBug_ReturnAssignment_2ElementType() {
			return new IGrammarAwareElementType("EnumBug_ReturnAssignment_2_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugAccess().getReturnAssignment_2());
		}
		public static IGrammarAwareElementType createEnumBug_ReturnEnumBugEnumEnumRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("EnumBug_ReturnEnumBugEnumEnumRuleCall_2_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugAccess().getReturnEnumBugEnumEnumRuleCall_2_0());
		}
		public static IGrammarAwareElementType createEnumBug_NameAssignment_3ElementType() {
			return new IGrammarAwareElementType("EnumBug_NameAssignment_3_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugAccess().getNameAssignment_3());
		}
		public static IGrammarAwareElementType createEnumBug_NameIDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("EnumBug_NameIDTerminalRuleCall_3_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugAccess().getNameIDTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType EnumBug_ELEMENT_TYPE = associate(EnumBugFactory.createEnumBugElementType());

	public static final IGrammarAwareElementType EnumBug_Group_ELEMENT_TYPE = associate(EnumBugFactory.createEnumBug_GroupElementType());

	public static final IGrammarAwareElementType EnumBug_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE = associate(EnumBugFactory.createEnumBug_NumberSignDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType EnumBug_Kw1Keyword_1_ELEMENT_TYPE = associate(EnumBugFactory.createEnumBug_Kw1Keyword_1ElementType());

	public static final IGrammarAwareElementType EnumBug_ReturnAssignment_2_ELEMENT_TYPE = associate(EnumBugFactory.createEnumBug_ReturnAssignment_2ElementType());

	public static final IGrammarAwareElementType EnumBug_ReturnEnumBugEnumEnumRuleCall_2_0_ELEMENT_TYPE = associate(EnumBugFactory.createEnumBug_ReturnEnumBugEnumEnumRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType EnumBug_NameAssignment_3_ELEMENT_TYPE = associate(EnumBugFactory.createEnumBug_NameAssignment_3ElementType());

	public static final IGrammarAwareElementType EnumBug_NameIDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(EnumBugFactory.createEnumBug_NameIDTerminalRuleCall_3_0ElementType());

	private static class EnumBugEnumFactory {
		public static IGrammarAwareElementType createEnumBugEnumElementType() {
			return new IGrammarAwareElementType("EnumBugEnum_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugEnumRule());
		}
		public static IGrammarAwareElementType createEnumBugEnum_AlternativesElementType() {
			return new IGrammarAwareElementType("EnumBugEnum_Alternatives_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugEnumAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createEnumBugEnum_ArrayEnumLiteralDeclaration_0ElementType() {
			return new IGrammarAwareElementType("EnumBugEnum_ArrayEnumLiteralDeclaration_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugEnumAccess().getArrayEnumLiteralDeclaration_0());
		}
		public static IGrammarAwareElementType createEnumBugEnum_ArrayArrayKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("EnumBugEnum_ArrayArrayKeyword_0_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugEnumAccess().getArrayArrayKeyword_0_0());
		}
		public static IGrammarAwareElementType createEnumBugEnum_ObjectEnumLiteralDeclaration_1ElementType() {
			return new IGrammarAwareElementType("EnumBugEnum_ObjectEnumLiteralDeclaration_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugEnumAccess().getObjectEnumLiteralDeclaration_1());
		}
		public static IGrammarAwareElementType createEnumBugEnum_ObjectObjectKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("EnumBugEnum_ObjectObjectKeyword_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugEnumAccess().getObjectObjectKeyword_1_0());
		}
		public static IGrammarAwareElementType createEnumBugEnum_ResultSetEnumLiteralDeclaration_2ElementType() {
			return new IGrammarAwareElementType("EnumBugEnum_ResultSetEnumLiteralDeclaration_2_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugEnumAccess().getResultSetEnumLiteralDeclaration_2());
		}
		public static IGrammarAwareElementType createEnumBugEnum_ResultSetResultSetKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("EnumBugEnum_ResultSetResultSetKeyword_2_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugEnumAccess().getResultSetResultSetKeyword_2_0());
		}
		public static IGrammarAwareElementType createEnumBugEnum_IteratorEnumLiteralDeclaration_3ElementType() {
			return new IGrammarAwareElementType("EnumBugEnum_IteratorEnumLiteralDeclaration_3_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugEnumAccess().getIteratorEnumLiteralDeclaration_3());
		}
		public static IGrammarAwareElementType createEnumBugEnum_IteratorIteratorKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("EnumBugEnum_IteratorIteratorKeyword_3_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBugEnumAccess().getIteratorIteratorKeyword_3_0());
		}
	}

	public static final IGrammarAwareElementType EnumBugEnum_ELEMENT_TYPE = associate(EnumBugEnumFactory.createEnumBugEnumElementType());

	public static final IGrammarAwareElementType EnumBugEnum_Alternatives_ELEMENT_TYPE = associate(EnumBugEnumFactory.createEnumBugEnum_AlternativesElementType());

	public static final IGrammarAwareElementType EnumBugEnum_ArrayEnumLiteralDeclaration_0_ELEMENT_TYPE = associate(EnumBugEnumFactory.createEnumBugEnum_ArrayEnumLiteralDeclaration_0ElementType());

	public static final IGrammarAwareElementType EnumBugEnum_ArrayArrayKeyword_0_0_ELEMENT_TYPE = associate(EnumBugEnumFactory.createEnumBugEnum_ArrayArrayKeyword_0_0ElementType());

	public static final IGrammarAwareElementType EnumBugEnum_ObjectEnumLiteralDeclaration_1_ELEMENT_TYPE = associate(EnumBugEnumFactory.createEnumBugEnum_ObjectEnumLiteralDeclaration_1ElementType());

	public static final IGrammarAwareElementType EnumBugEnum_ObjectObjectKeyword_1_0_ELEMENT_TYPE = associate(EnumBugEnumFactory.createEnumBugEnum_ObjectObjectKeyword_1_0ElementType());

	public static final IGrammarAwareElementType EnumBugEnum_ResultSetEnumLiteralDeclaration_2_ELEMENT_TYPE = associate(EnumBugEnumFactory.createEnumBugEnum_ResultSetEnumLiteralDeclaration_2ElementType());

	public static final IGrammarAwareElementType EnumBugEnum_ResultSetResultSetKeyword_2_0_ELEMENT_TYPE = associate(EnumBugEnumFactory.createEnumBugEnum_ResultSetResultSetKeyword_2_0ElementType());

	public static final IGrammarAwareElementType EnumBugEnum_IteratorEnumLiteralDeclaration_3_ELEMENT_TYPE = associate(EnumBugEnumFactory.createEnumBugEnum_IteratorEnumLiteralDeclaration_3ElementType());

	public static final IGrammarAwareElementType EnumBugEnum_IteratorIteratorKeyword_3_0_ELEMENT_TYPE = associate(EnumBugEnumFactory.createEnumBugEnum_IteratorIteratorKeyword_3_0ElementType());

	private static class CommentableFactory {
		public static IGrammarAwareElementType createCommentableElementType() {
			return new IGrammarAwareElementType("Commentable_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommentableRule());
		}
		public static IGrammarAwareElementType createCommentable_GroupElementType() {
			return new IGrammarAwareElementType("Commentable_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommentableAccess().getGroup());
		}
		public static IGrammarAwareElementType createCommentable_NumberSignDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Commentable_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommentableAccess().getNumberSignDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createCommentable_ItemAssignment_1ElementType() {
			return new IGrammarAwareElementType("Commentable_ItemAssignment_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommentableAccess().getItemAssignment_1());
		}
		public static IGrammarAwareElementType createCommentable_ItemCommentableItemParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Commentable_ItemCommentableItemParserRuleCall_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommentableAccess().getItemCommentableItemParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Commentable_ELEMENT_TYPE = associate(CommentableFactory.createCommentableElementType());

	public static final IGrammarAwareElementType Commentable_Group_ELEMENT_TYPE = associate(CommentableFactory.createCommentable_GroupElementType());

	public static final IGrammarAwareElementType Commentable_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE = associate(CommentableFactory.createCommentable_NumberSignDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType Commentable_ItemAssignment_1_ELEMENT_TYPE = associate(CommentableFactory.createCommentable_ItemAssignment_1ElementType());

	public static final IGrammarAwareElementType Commentable_ItemCommentableItemParserRuleCall_1_0_ELEMENT_TYPE = associate(CommentableFactory.createCommentable_ItemCommentableItemParserRuleCall_1_0ElementType());

	private static class CommentableItemFactory {
		public static IGrammarAwareElementType createCommentableItemElementType() {
			return new IGrammarAwareElementType("CommentableItem_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommentableItemRule());
		}
		public static IGrammarAwareElementType createCommentableItem_GroupElementType() {
			return new IGrammarAwareElementType("CommentableItem_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommentableItemAccess().getGroup());
		}
		public static IGrammarAwareElementType createCommentableItem_ItemKeyword_0ElementType() {
			return new IGrammarAwareElementType("CommentableItem_ItemKeyword_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommentableItemAccess().getItemKeyword_0());
		}
		public static IGrammarAwareElementType createCommentableItem_IdAssignment_1ElementType() {
			return new IGrammarAwareElementType("CommentableItem_IdAssignment_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommentableItemAccess().getIdAssignment_1());
		}
		public static IGrammarAwareElementType createCommentableItem_IdIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("CommentableItem_IdIDTerminalRuleCall_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommentableItemAccess().getIdIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType CommentableItem_ELEMENT_TYPE = associate(CommentableItemFactory.createCommentableItemElementType());

	public static final IGrammarAwareElementType CommentableItem_Group_ELEMENT_TYPE = associate(CommentableItemFactory.createCommentableItem_GroupElementType());

	public static final IGrammarAwareElementType CommentableItem_ItemKeyword_0_ELEMENT_TYPE = associate(CommentableItemFactory.createCommentableItem_ItemKeyword_0ElementType());

	public static final IGrammarAwareElementType CommentableItem_IdAssignment_1_ELEMENT_TYPE = associate(CommentableItemFactory.createCommentableItem_IdAssignment_1ElementType());

	public static final IGrammarAwareElementType CommentableItem_IdIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(CommentableItemFactory.createCommentableItem_IdIDTerminalRuleCall_1_0ElementType());

	private static class ValueListFactory {
		public static IGrammarAwareElementType createValueListElementType() {
			return new IGrammarAwareElementType("ValueList_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueListRule());
		}
		public static IGrammarAwareElementType createValueList_GroupElementType() {
			return new IGrammarAwareElementType("ValueList_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueListAccess().getGroup());
		}
		public static IGrammarAwareElementType createValueList_NumberSignDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("ValueList_NumberSignDigitFourKeyword_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueListAccess().getNumberSignDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createValueList_IdsAssignment_1ElementType() {
			return new IGrammarAwareElementType("ValueList_IdsAssignment_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueListAccess().getIdsAssignment_1());
		}
		public static IGrammarAwareElementType createValueList_IdsFQNParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ValueList_IdsFQNParserRuleCall_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getValueListAccess().getIdsFQNParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType ValueList_ELEMENT_TYPE = associate(ValueListFactory.createValueListElementType());

	public static final IGrammarAwareElementType ValueList_Group_ELEMENT_TYPE = associate(ValueListFactory.createValueList_GroupElementType());

	public static final IGrammarAwareElementType ValueList_NumberSignDigitFourKeyword_0_ELEMENT_TYPE = associate(ValueListFactory.createValueList_NumberSignDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType ValueList_IdsAssignment_1_ELEMENT_TYPE = associate(ValueListFactory.createValueList_IdsAssignment_1ElementType());

	public static final IGrammarAwareElementType ValueList_IdsFQNParserRuleCall_1_0_ELEMENT_TYPE = associate(ValueListFactory.createValueList_IdsFQNParserRuleCall_1_0ElementType());

	private static class RefListFactory {
		public static IGrammarAwareElementType createRefListElementType() {
			return new IGrammarAwareElementType("RefList_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefListRule());
		}
		public static IGrammarAwareElementType createRefList_GroupElementType() {
			return new IGrammarAwareElementType("RefList_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefListAccess().getGroup());
		}
		public static IGrammarAwareElementType createRefList_NumberSignDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("RefList_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefListAccess().getNumberSignDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createRefList_ObjsAssignment_1ElementType() {
			return new IGrammarAwareElementType("RefList_ObjsAssignment_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefListAccess().getObjsAssignment_1());
		}
		public static IGrammarAwareElementType createRefList_ObjsRefObjParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("RefList_ObjsRefObjParserRuleCall_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefListAccess().getObjsRefObjParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createRefList_RefsKeyword_2ElementType() {
			return new IGrammarAwareElementType("RefList_RefsKeyword_2_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefListAccess().getRefsKeyword_2());
		}
		public static IGrammarAwareElementType createRefList_RefsAssignment_3ElementType() {
			return new IGrammarAwareElementType("RefList_RefsAssignment_3_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefListAccess().getRefsAssignment_3());
		}
		public static IGrammarAwareElementType createRefList_RefsRefObjCrossReference_3_0ElementType() {
			return new IGrammarAwareElementType("RefList_RefsRefObjCrossReference_3_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefListAccess().getRefsRefObjCrossReference_3_0());
		}
		public static IGrammarAwareElementType createRefList_RefsRefObjFQNParserRuleCall_3_0_1ElementType() {
			return new IGrammarAwareElementType("RefList_RefsRefObjFQNParserRuleCall_3_0_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefListAccess().getRefsRefObjFQNParserRuleCall_3_0_1());
		}
	}

	public static final IGrammarAwareElementType RefList_ELEMENT_TYPE = associate(RefListFactory.createRefListElementType());

	public static final IGrammarAwareElementType RefList_Group_ELEMENT_TYPE = associate(RefListFactory.createRefList_GroupElementType());

	public static final IGrammarAwareElementType RefList_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE = associate(RefListFactory.createRefList_NumberSignDigitFiveKeyword_0ElementType());

	public static final IGrammarAwareElementType RefList_ObjsAssignment_1_ELEMENT_TYPE = associate(RefListFactory.createRefList_ObjsAssignment_1ElementType());

	public static final IGrammarAwareElementType RefList_ObjsRefObjParserRuleCall_1_0_ELEMENT_TYPE = associate(RefListFactory.createRefList_ObjsRefObjParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType RefList_RefsKeyword_2_ELEMENT_TYPE = associate(RefListFactory.createRefList_RefsKeyword_2ElementType());

	public static final IGrammarAwareElementType RefList_RefsAssignment_3_ELEMENT_TYPE = associate(RefListFactory.createRefList_RefsAssignment_3ElementType());

	public static final IGrammarAwareElementType RefList_RefsRefObjCrossReference_3_0_ELEMENT_TYPE = associate(RefListFactory.createRefList_RefsRefObjCrossReference_3_0ElementType());

	public static final IGrammarAwareElementType RefList_RefsRefObjFQNParserRuleCall_3_0_1_ELEMENT_TYPE = associate(RefListFactory.createRefList_RefsRefObjFQNParserRuleCall_3_0_1ElementType());

	private static class RefObjFactory {
		public static IGrammarAwareElementType createRefObjElementType() {
			return new IGrammarAwareElementType("RefObj_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefObjRule());
		}
		public static IGrammarAwareElementType createRefObj_NameAssignmentElementType() {
			return new IGrammarAwareElementType("RefObj_NameAssignment_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefObjAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createRefObj_NameFQNParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("RefObj_NameFQNParserRuleCall_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRefObjAccess().getNameFQNParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType RefObj_ELEMENT_TYPE = associate(RefObjFactory.createRefObjElementType());

	public static final IGrammarAwareElementType RefObj_NameAssignment_ELEMENT_TYPE = associate(RefObjFactory.createRefObj_NameAssignmentElementType());

	public static final IGrammarAwareElementType RefObj_NameFQNParserRuleCall_0_ELEMENT_TYPE = associate(RefObjFactory.createRefObj_NameFQNParserRuleCall_0ElementType());

	private static class SingleRefFactory {
		public static IGrammarAwareElementType createSingleRefElementType() {
			return new IGrammarAwareElementType("SingleRef_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleRefRule());
		}
		public static IGrammarAwareElementType createSingleRef_GroupElementType() {
			return new IGrammarAwareElementType("SingleRef_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleRefAccess().getGroup());
		}
		public static IGrammarAwareElementType createSingleRef_NumberSignDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("SingleRef_NumberSignDigitSixKeyword_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleRefAccess().getNumberSignDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createSingleRef_ObjAssignment_1ElementType() {
			return new IGrammarAwareElementType("SingleRef_ObjAssignment_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleRefAccess().getObjAssignment_1());
		}
		public static IGrammarAwareElementType createSingleRef_ObjRefObjParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SingleRef_ObjRefObjParserRuleCall_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleRefAccess().getObjRefObjParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSingleRef_RefKeyword_2ElementType() {
			return new IGrammarAwareElementType("SingleRef_RefKeyword_2_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleRefAccess().getRefKeyword_2());
		}
		public static IGrammarAwareElementType createSingleRef_RefAssignment_3ElementType() {
			return new IGrammarAwareElementType("SingleRef_RefAssignment_3_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleRefAccess().getRefAssignment_3());
		}
		public static IGrammarAwareElementType createSingleRef_RefRefObjCrossReference_3_0ElementType() {
			return new IGrammarAwareElementType("SingleRef_RefRefObjCrossReference_3_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleRefAccess().getRefRefObjCrossReference_3_0());
		}
		public static IGrammarAwareElementType createSingleRef_RefRefObjFQNParserRuleCall_3_0_1ElementType() {
			return new IGrammarAwareElementType("SingleRef_RefRefObjFQNParserRuleCall_3_0_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleRefAccess().getRefRefObjFQNParserRuleCall_3_0_1());
		}
	}

	public static final IGrammarAwareElementType SingleRef_ELEMENT_TYPE = associate(SingleRefFactory.createSingleRefElementType());

	public static final IGrammarAwareElementType SingleRef_Group_ELEMENT_TYPE = associate(SingleRefFactory.createSingleRef_GroupElementType());

	public static final IGrammarAwareElementType SingleRef_NumberSignDigitSixKeyword_0_ELEMENT_TYPE = associate(SingleRefFactory.createSingleRef_NumberSignDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType SingleRef_ObjAssignment_1_ELEMENT_TYPE = associate(SingleRefFactory.createSingleRef_ObjAssignment_1ElementType());

	public static final IGrammarAwareElementType SingleRef_ObjRefObjParserRuleCall_1_0_ELEMENT_TYPE = associate(SingleRefFactory.createSingleRef_ObjRefObjParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType SingleRef_RefKeyword_2_ELEMENT_TYPE = associate(SingleRefFactory.createSingleRef_RefKeyword_2ElementType());

	public static final IGrammarAwareElementType SingleRef_RefAssignment_3_ELEMENT_TYPE = associate(SingleRefFactory.createSingleRef_RefAssignment_3ElementType());

	public static final IGrammarAwareElementType SingleRef_RefRefObjCrossReference_3_0_ELEMENT_TYPE = associate(SingleRefFactory.createSingleRef_RefRefObjCrossReference_3_0ElementType());

	public static final IGrammarAwareElementType SingleRef_RefRefObjFQNParserRuleCall_3_0_1_ELEMENT_TYPE = associate(SingleRefFactory.createSingleRef_RefRefObjFQNParserRuleCall_3_0_1ElementType());

	private static class AppendToFileEndFactory {
		public static IGrammarAwareElementType createAppendToFileEndElementType() {
			return new IGrammarAwareElementType("AppendToFileEnd_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndRule());
		}
		public static IGrammarAwareElementType createAppendToFileEnd_GroupElementType() {
			return new IGrammarAwareElementType("AppendToFileEnd_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndAccess().getGroup());
		}
		public static IGrammarAwareElementType createAppendToFileEnd_NumberSignDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("AppendToFileEnd_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndAccess().getNumberSignDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createAppendToFileEnd_ItemsAssignment_1ElementType() {
			return new IGrammarAwareElementType("AppendToFileEnd_ItemsAssignment_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndAccess().getItemsAssignment_1());
		}
		public static IGrammarAwareElementType createAppendToFileEnd_ItemsAppendToFileEndItemParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AppendToFileEnd_ItemsAppendToFileEndItemParserRuleCall_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndAccess().getItemsAppendToFileEndItemParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AppendToFileEnd_ELEMENT_TYPE = associate(AppendToFileEndFactory.createAppendToFileEndElementType());

	public static final IGrammarAwareElementType AppendToFileEnd_Group_ELEMENT_TYPE = associate(AppendToFileEndFactory.createAppendToFileEnd_GroupElementType());

	public static final IGrammarAwareElementType AppendToFileEnd_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE = associate(AppendToFileEndFactory.createAppendToFileEnd_NumberSignDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType AppendToFileEnd_ItemsAssignment_1_ELEMENT_TYPE = associate(AppendToFileEndFactory.createAppendToFileEnd_ItemsAssignment_1ElementType());

	public static final IGrammarAwareElementType AppendToFileEnd_ItemsAppendToFileEndItemParserRuleCall_1_0_ELEMENT_TYPE = associate(AppendToFileEndFactory.createAppendToFileEnd_ItemsAppendToFileEndItemParserRuleCall_1_0ElementType());

	private static class AppendToFileEndItemFactory {
		public static IGrammarAwareElementType createAppendToFileEndItemElementType() {
			return new IGrammarAwareElementType("AppendToFileEndItem_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndItemRule());
		}
		public static IGrammarAwareElementType createAppendToFileEndItem_GroupElementType() {
			return new IGrammarAwareElementType("AppendToFileEndItem_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndItemAccess().getGroup());
		}
		public static IGrammarAwareElementType createAppendToFileEndItem_ClassKeyword_0ElementType() {
			return new IGrammarAwareElementType("AppendToFileEndItem_ClassKeyword_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndItemAccess().getClassKeyword_0());
		}
		public static IGrammarAwareElementType createAppendToFileEndItem_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("AppendToFileEndItem_NameAssignment_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndItemAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createAppendToFileEndItem_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AppendToFileEndItem_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndItemAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createAppendToFileEndItem_EndclassKeyword_2ElementType() {
			return new IGrammarAwareElementType("AppendToFileEndItem_EndclassKeyword_2_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAppendToFileEndItemAccess().getEndclassKeyword_2());
		}
	}

	public static final IGrammarAwareElementType AppendToFileEndItem_ELEMENT_TYPE = associate(AppendToFileEndItemFactory.createAppendToFileEndItemElementType());

	public static final IGrammarAwareElementType AppendToFileEndItem_Group_ELEMENT_TYPE = associate(AppendToFileEndItemFactory.createAppendToFileEndItem_GroupElementType());

	public static final IGrammarAwareElementType AppendToFileEndItem_ClassKeyword_0_ELEMENT_TYPE = associate(AppendToFileEndItemFactory.createAppendToFileEndItem_ClassKeyword_0ElementType());

	public static final IGrammarAwareElementType AppendToFileEndItem_NameAssignment_1_ELEMENT_TYPE = associate(AppendToFileEndItemFactory.createAppendToFileEndItem_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType AppendToFileEndItem_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AppendToFileEndItemFactory.createAppendToFileEndItem_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType AppendToFileEndItem_EndclassKeyword_2_ELEMENT_TYPE = associate(AppendToFileEndItemFactory.createAppendToFileEndItem_EndclassKeyword_2ElementType());

	private static class Action1Factory {
		public static IGrammarAwareElementType createAction1ElementType() {
			return new IGrammarAwareElementType("Action1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Rule());
		}
		public static IGrammarAwareElementType createAction1_GroupElementType() {
			return new IGrammarAwareElementType("Action1_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Access().getGroup());
		}
		public static IGrammarAwareElementType createAction1_NumberSignDigitEightKeyword_0ElementType() {
			return new IGrammarAwareElementType("Action1_NumberSignDigitEightKeyword_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Access().getNumberSignDigitEightKeyword_0());
		}
		public static IGrammarAwareElementType createAction1_Action1Action_1ElementType() {
			return new IGrammarAwareElementType("Action1_Action1Action_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Access().getAction1Action_1());
		}
		public static IGrammarAwareElementType createAction1_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("Action1_NameAssignment_2_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Access().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createAction1_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Action1_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Access().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createAction1_Actions2Assignment_3ElementType() {
			return new IGrammarAwareElementType("Action1_Actions2Assignment_3_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Access().getActions2Assignment_3());
		}
		public static IGrammarAwareElementType createAction1_Actions2Action1Sub1ParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Action1_Actions2Action1Sub1ParserRuleCall_3_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Access().getActions2Action1Sub1ParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createAction1_Actions2Assignment_4ElementType() {
			return new IGrammarAwareElementType("Action1_Actions2Assignment_4_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Access().getActions2Assignment_4());
		}
		public static IGrammarAwareElementType createAction1_Actions2Action1Sub2ParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Action1_Actions2Action1Sub2ParserRuleCall_4_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Access().getActions2Action1Sub2ParserRuleCall_4_0());
		}
	}

	public static final IGrammarAwareElementType Action1_ELEMENT_TYPE = associate(Action1Factory.createAction1ElementType());

	public static final IGrammarAwareElementType Action1_Group_ELEMENT_TYPE = associate(Action1Factory.createAction1_GroupElementType());

	public static final IGrammarAwareElementType Action1_NumberSignDigitEightKeyword_0_ELEMENT_TYPE = associate(Action1Factory.createAction1_NumberSignDigitEightKeyword_0ElementType());

	public static final IGrammarAwareElementType Action1_Action1Action_1_ELEMENT_TYPE = associate(Action1Factory.createAction1_Action1Action_1ElementType());

	public static final IGrammarAwareElementType Action1_NameAssignment_2_ELEMENT_TYPE = associate(Action1Factory.createAction1_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType Action1_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(Action1Factory.createAction1_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Action1_Actions2Assignment_3_ELEMENT_TYPE = associate(Action1Factory.createAction1_Actions2Assignment_3ElementType());

	public static final IGrammarAwareElementType Action1_Actions2Action1Sub1ParserRuleCall_3_0_ELEMENT_TYPE = associate(Action1Factory.createAction1_Actions2Action1Sub1ParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Action1_Actions2Assignment_4_ELEMENT_TYPE = associate(Action1Factory.createAction1_Actions2Assignment_4ElementType());

	public static final IGrammarAwareElementType Action1_Actions2Action1Sub2ParserRuleCall_4_0_ELEMENT_TYPE = associate(Action1Factory.createAction1_Actions2Action1Sub2ParserRuleCall_4_0ElementType());

	private static class Action1Sub1Factory {
		public static IGrammarAwareElementType createAction1Sub1ElementType() {
			return new IGrammarAwareElementType("Action1Sub1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Sub1Rule());
		}
		public static IGrammarAwareElementType createAction1Sub1_GroupElementType() {
			return new IGrammarAwareElementType("Action1Sub1_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Sub1Access().getGroup());
		}
		public static IGrammarAwareElementType createAction1Sub1_Action1SubAction_0ElementType() {
			return new IGrammarAwareElementType("Action1Sub1_Action1SubAction_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Sub1Access().getAction1SubAction_0());
		}
		public static IGrammarAwareElementType createAction1Sub1_Sub1Keyword_1ElementType() {
			return new IGrammarAwareElementType("Action1Sub1_Sub1Keyword_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Sub1Access().getSub1Keyword_1());
		}
	}

	public static final IGrammarAwareElementType Action1Sub1_ELEMENT_TYPE = associate(Action1Sub1Factory.createAction1Sub1ElementType());

	public static final IGrammarAwareElementType Action1Sub1_Group_ELEMENT_TYPE = associate(Action1Sub1Factory.createAction1Sub1_GroupElementType());

	public static final IGrammarAwareElementType Action1Sub1_Action1SubAction_0_ELEMENT_TYPE = associate(Action1Sub1Factory.createAction1Sub1_Action1SubAction_0ElementType());

	public static final IGrammarAwareElementType Action1Sub1_Sub1Keyword_1_ELEMENT_TYPE = associate(Action1Sub1Factory.createAction1Sub1_Sub1Keyword_1ElementType());

	private static class Action1Sub2Factory {
		public static IGrammarAwareElementType createAction1Sub2ElementType() {
			return new IGrammarAwareElementType("Action1Sub2_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Sub2Rule());
		}
		public static IGrammarAwareElementType createAction1Sub2_GroupElementType() {
			return new IGrammarAwareElementType("Action1Sub2_Group_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Sub2Access().getGroup());
		}
		public static IGrammarAwareElementType createAction1Sub2_Action1SubClassAction_0ElementType() {
			return new IGrammarAwareElementType("Action1Sub2_Action1SubClassAction_0_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Sub2Access().getAction1SubClassAction_0());
		}
		public static IGrammarAwareElementType createAction1Sub2_Sub2Keyword_1ElementType() {
			return new IGrammarAwareElementType("Action1Sub2_Sub2Keyword_1_ELEMENT_TYPE", HiddenTokensMergerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAction1Sub2Access().getSub2Keyword_1());
		}
	}

	public static final IGrammarAwareElementType Action1Sub2_ELEMENT_TYPE = associate(Action1Sub2Factory.createAction1Sub2ElementType());

	public static final IGrammarAwareElementType Action1Sub2_Group_ELEMENT_TYPE = associate(Action1Sub2Factory.createAction1Sub2_GroupElementType());

	public static final IGrammarAwareElementType Action1Sub2_Action1SubClassAction_0_ELEMENT_TYPE = associate(Action1Sub2Factory.createAction1Sub2_Action1SubClassAction_0ElementType());

	public static final IGrammarAwareElementType Action1Sub2_Sub2Keyword_1_ELEMENT_TYPE = associate(Action1Sub2Factory.createAction1Sub2_Sub2Keyword_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getModelElementType() {
		return Model_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AlternativesElementType() {
		return Model_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DatatypeBug286557ParserRuleCall_0ElementType() {
		return Model_DatatypeBug286557ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_EnumBugParserRuleCall_1ElementType() {
		return Model_EnumBugParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_CommentableParserRuleCall_2ElementType() {
		return Model_CommentableParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueListParserRuleCall_3ElementType() {
		return Model_ValueListParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RefListParserRuleCall_4ElementType() {
		return Model_RefListParserRuleCall_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SingleRefParserRuleCall_5ElementType() {
		return Model_SingleRefParserRuleCall_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AppendToFileEndParserRuleCall_6ElementType() {
		return Model_AppendToFileEndParserRuleCall_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Action1ParserRuleCall_7ElementType() {
		return Model_Action1ParserRuleCall_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557ElementType() {
		return DatatypeBug286557_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557_GroupElementType() {
		return DatatypeBug286557_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557_NumberSignDigitOneKeyword_0ElementType() {
		return DatatypeBug286557_NumberSignDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557_NameAssignment_1ElementType() {
		return DatatypeBug286557_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557_NameFQNParserRuleCall_1_0ElementType() {
		return DatatypeBug286557_NameFQNParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557_Group_2ElementType() {
		return DatatypeBug286557_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557_RefKeyword_2_0ElementType() {
		return DatatypeBug286557_RefKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557_RefAssignment_2_1ElementType() {
		return DatatypeBug286557_RefAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557_RefDatatypeBug286557CrossReference_2_1_0ElementType() {
		return DatatypeBug286557_RefDatatypeBug286557CrossReference_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557_RefDatatypeBug286557FQNParserRuleCall_2_1_0_1ElementType() {
		return DatatypeBug286557_RefDatatypeBug286557FQNParserRuleCall_2_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeBug286557_SemicolonKeyword_3ElementType() {
		return DatatypeBug286557_SemicolonKeyword_3_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getEnumBugElementType() {
		return EnumBug_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug_GroupElementType() {
		return EnumBug_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug_NumberSignDigitTwoKeyword_0ElementType() {
		return EnumBug_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug_Kw1Keyword_1ElementType() {
		return EnumBug_Kw1Keyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug_ReturnAssignment_2ElementType() {
		return EnumBug_ReturnAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug_ReturnEnumBugEnumEnumRuleCall_2_0ElementType() {
		return EnumBug_ReturnEnumBugEnumEnumRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug_NameAssignment_3ElementType() {
		return EnumBug_NameAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug_NameIDTerminalRuleCall_3_0ElementType() {
		return EnumBug_NameIDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBugEnumElementType() {
		return EnumBugEnum_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBugEnum_AlternativesElementType() {
		return EnumBugEnum_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBugEnum_ArrayEnumLiteralDeclaration_0ElementType() {
		return EnumBugEnum_ArrayEnumLiteralDeclaration_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBugEnum_ArrayArrayKeyword_0_0ElementType() {
		return EnumBugEnum_ArrayArrayKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBugEnum_ObjectEnumLiteralDeclaration_1ElementType() {
		return EnumBugEnum_ObjectEnumLiteralDeclaration_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBugEnum_ObjectObjectKeyword_1_0ElementType() {
		return EnumBugEnum_ObjectObjectKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBugEnum_ResultSetEnumLiteralDeclaration_2ElementType() {
		return EnumBugEnum_ResultSetEnumLiteralDeclaration_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBugEnum_ResultSetResultSetKeyword_2_0ElementType() {
		return EnumBugEnum_ResultSetResultSetKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBugEnum_IteratorEnumLiteralDeclaration_3ElementType() {
		return EnumBugEnum_IteratorEnumLiteralDeclaration_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBugEnum_IteratorIteratorKeyword_3_0ElementType() {
		return EnumBugEnum_IteratorIteratorKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommentableElementType() {
		return Commentable_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommentable_GroupElementType() {
		return Commentable_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommentable_NumberSignDigitThreeKeyword_0ElementType() {
		return Commentable_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommentable_ItemAssignment_1ElementType() {
		return Commentable_ItemAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommentable_ItemCommentableItemParserRuleCall_1_0ElementType() {
		return Commentable_ItemCommentableItemParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommentableItemElementType() {
		return CommentableItem_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommentableItem_GroupElementType() {
		return CommentableItem_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommentableItem_ItemKeyword_0ElementType() {
		return CommentableItem_ItemKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommentableItem_IdAssignment_1ElementType() {
		return CommentableItem_IdAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommentableItem_IdIDTerminalRuleCall_1_0ElementType() {
		return CommentableItem_IdIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueListElementType() {
		return ValueList_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueList_GroupElementType() {
		return ValueList_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueList_NumberSignDigitFourKeyword_0ElementType() {
		return ValueList_NumberSignDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueList_IdsAssignment_1ElementType() {
		return ValueList_IdsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueList_IdsFQNParserRuleCall_1_0ElementType() {
		return ValueList_IdsFQNParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefListElementType() {
		return RefList_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefList_GroupElementType() {
		return RefList_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefList_NumberSignDigitFiveKeyword_0ElementType() {
		return RefList_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefList_ObjsAssignment_1ElementType() {
		return RefList_ObjsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefList_ObjsRefObjParserRuleCall_1_0ElementType() {
		return RefList_ObjsRefObjParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefList_RefsKeyword_2ElementType() {
		return RefList_RefsKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefList_RefsAssignment_3ElementType() {
		return RefList_RefsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefList_RefsRefObjCrossReference_3_0ElementType() {
		return RefList_RefsRefObjCrossReference_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefList_RefsRefObjFQNParserRuleCall_3_0_1ElementType() {
		return RefList_RefsRefObjFQNParserRuleCall_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefObjElementType() {
		return RefObj_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefObj_NameAssignmentElementType() {
		return RefObj_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRefObj_NameFQNParserRuleCall_0ElementType() {
		return RefObj_NameFQNParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleRefElementType() {
		return SingleRef_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleRef_GroupElementType() {
		return SingleRef_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleRef_NumberSignDigitSixKeyword_0ElementType() {
		return SingleRef_NumberSignDigitSixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleRef_ObjAssignment_1ElementType() {
		return SingleRef_ObjAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleRef_ObjRefObjParserRuleCall_1_0ElementType() {
		return SingleRef_ObjRefObjParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleRef_RefKeyword_2ElementType() {
		return SingleRef_RefKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleRef_RefAssignment_3ElementType() {
		return SingleRef_RefAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleRef_RefRefObjCrossReference_3_0ElementType() {
		return SingleRef_RefRefObjCrossReference_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleRef_RefRefObjFQNParserRuleCall_3_0_1ElementType() {
		return SingleRef_RefRefObjFQNParserRuleCall_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEndElementType() {
		return AppendToFileEnd_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEnd_GroupElementType() {
		return AppendToFileEnd_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEnd_NumberSignDigitSevenKeyword_0ElementType() {
		return AppendToFileEnd_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEnd_ItemsAssignment_1ElementType() {
		return AppendToFileEnd_ItemsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEnd_ItemsAppendToFileEndItemParserRuleCall_1_0ElementType() {
		return AppendToFileEnd_ItemsAppendToFileEndItemParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEndItemElementType() {
		return AppendToFileEndItem_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEndItem_GroupElementType() {
		return AppendToFileEndItem_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEndItem_ClassKeyword_0ElementType() {
		return AppendToFileEndItem_ClassKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEndItem_NameAssignment_1ElementType() {
		return AppendToFileEndItem_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEndItem_NameIDTerminalRuleCall_1_0ElementType() {
		return AppendToFileEndItem_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAppendToFileEndItem_EndclassKeyword_2ElementType() {
		return AppendToFileEndItem_EndclassKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1ElementType() {
		return Action1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1_GroupElementType() {
		return Action1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1_NumberSignDigitEightKeyword_0ElementType() {
		return Action1_NumberSignDigitEightKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1_Action1Action_1ElementType() {
		return Action1_Action1Action_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1_NameAssignment_2ElementType() {
		return Action1_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1_NameIDTerminalRuleCall_2_0ElementType() {
		return Action1_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1_Actions2Assignment_3ElementType() {
		return Action1_Actions2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1_Actions2Action1Sub1ParserRuleCall_3_0ElementType() {
		return Action1_Actions2Action1Sub1ParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1_Actions2Assignment_4ElementType() {
		return Action1_Actions2Assignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1_Actions2Action1Sub2ParserRuleCall_4_0ElementType() {
		return Action1_Actions2Action1Sub2ParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1Sub1ElementType() {
		return Action1Sub1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1Sub1_GroupElementType() {
		return Action1Sub1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1Sub1_Action1SubAction_0ElementType() {
		return Action1Sub1_Action1SubAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1Sub1_Sub1Keyword_1ElementType() {
		return Action1Sub1_Sub1Keyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1Sub2ElementType() {
		return Action1Sub2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1Sub2_GroupElementType() {
		return Action1Sub2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1Sub2_Action1SubClassAction_0ElementType() {
		return Action1Sub2_Action1SubClassAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAction1Sub2_Sub2Keyword_1ElementType() {
		return Action1Sub2_Sub2Keyword_1_ELEMENT_TYPE;
	}

}
