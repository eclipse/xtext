package org.eclipse.xtext.parser.assignments.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.assignments.idea.lang.psi.impl.AssignmentsTestLanguageFileImpl;
import org.eclipse.xtext.parser.assignments.services.AssignmentsTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class AssignmentsTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<AssignmentsTestLanguageFileImpl>>(AssignmentsTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final AssignmentsTestLanguageGrammarAccess GRAMMAR_ACCESS = AssignmentsTestLanguageLanguage.INSTANCE.getInstance(AssignmentsTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_SimpleKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_SimpleKeyword_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSimpleKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_Alternatives_0_1ElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_0_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives_0_1());
		}
		public static IGrammarAwareElementType createModel_SingleAssignment_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SingleAssignment_0_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSingleAssignment_0_1_0());
		}
		public static IGrammarAwareElementType createModel_SingleSingleValueParserRuleCall_0_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_SingleSingleValueParserRuleCall_0_1_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSingleSingleValueParserRuleCall_0_1_0_0());
		}
		public static IGrammarAwareElementType createModel_MultiAssignment_0_1_1ElementType() {
			return new IGrammarAwareElementType("Model_MultiAssignment_0_1_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiAssignment_0_1_1());
		}
		public static IGrammarAwareElementType createModel_MultiMultiValueParserRuleCall_0_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_MultiMultiValueParserRuleCall_0_1_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiMultiValueParserRuleCall_0_1_1_0());
		}
		public static IGrammarAwareElementType createModel_SingleAssignment_0_1_2ElementType() {
			return new IGrammarAwareElementType("Model_SingleAssignment_0_1_2_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSingleAssignment_0_1_2());
		}
		public static IGrammarAwareElementType createModel_SingleSingleDatatypeParserRuleCall_0_1_2_0ElementType() {
			return new IGrammarAwareElementType("Model_SingleSingleDatatypeParserRuleCall_0_1_2_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSingleSingleDatatypeParserRuleCall_0_1_2_0());
		}
		public static IGrammarAwareElementType createModel_MultiAssignment_0_1_3ElementType() {
			return new IGrammarAwareElementType("Model_MultiAssignment_0_1_3_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiAssignment_0_1_3());
		}
		public static IGrammarAwareElementType createModel_MultiMultiDatatypeParserRuleCall_0_1_3_0ElementType() {
			return new IGrammarAwareElementType("Model_MultiMultiDatatypeParserRuleCall_0_1_3_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getMultiMultiDatatypeParserRuleCall_0_1_3_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_ComplexKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ComplexKeyword_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getComplexKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_ObjectAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_ObjectAssignment_1_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getObjectAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_ObjectAlternatives_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ObjectAlternatives_1_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getObjectAlternatives_1_1_0());
		}
		public static IGrammarAwareElementType createModel_ObjectSingleValueParserRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ObjectSingleValueParserRuleCall_1_1_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getObjectSingleValueParserRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createModel_ObjectMultiValueParserRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ObjectMultiValueParserRuleCall_1_1_0_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getObjectMultiValueParserRuleCall_1_1_0_1());
		}
		public static IGrammarAwareElementType createModel_ObjectSingleDatatypeParserRuleCall_1_1_0_2ElementType() {
			return new IGrammarAwareElementType("Model_ObjectSingleDatatypeParserRuleCall_1_1_0_2_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getObjectSingleDatatypeParserRuleCall_1_1_0_2());
		}
		public static IGrammarAwareElementType createModel_ObjectMultiDatatypeParserRuleCall_1_1_0_3ElementType() {
			return new IGrammarAwareElementType("Model_ObjectMultiDatatypeParserRuleCall_1_1_0_3_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getObjectMultiDatatypeParserRuleCall_1_1_0_3());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_SimpleKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SimpleKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_Alternatives_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Alternatives_0_1ElementType());

	public static final IGrammarAwareElementType Model_SingleAssignment_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SingleAssignment_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_SingleSingleValueParserRuleCall_0_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SingleSingleValueParserRuleCall_0_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_MultiAssignment_0_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiAssignment_0_1_1ElementType());

	public static final IGrammarAwareElementType Model_MultiMultiValueParserRuleCall_0_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiMultiValueParserRuleCall_0_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_SingleAssignment_0_1_2_ELEMENT_TYPE = associate(ModelFactory.createModel_SingleAssignment_0_1_2ElementType());

	public static final IGrammarAwareElementType Model_SingleSingleDatatypeParserRuleCall_0_1_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SingleSingleDatatypeParserRuleCall_0_1_2_0ElementType());

	public static final IGrammarAwareElementType Model_MultiAssignment_0_1_3_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiAssignment_0_1_3ElementType());

	public static final IGrammarAwareElementType Model_MultiMultiDatatypeParserRuleCall_0_1_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_MultiMultiDatatypeParserRuleCall_0_1_3_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_ComplexKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ComplexKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_ObjectAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ObjectAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_ObjectAlternatives_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ObjectAlternatives_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_ObjectSingleValueParserRuleCall_1_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ObjectSingleValueParserRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_ObjectMultiValueParserRuleCall_1_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ObjectMultiValueParserRuleCall_1_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_ObjectSingleDatatypeParserRuleCall_1_1_0_2_ELEMENT_TYPE = associate(ModelFactory.createModel_ObjectSingleDatatypeParserRuleCall_1_1_0_2ElementType());

	public static final IGrammarAwareElementType Model_ObjectMultiDatatypeParserRuleCall_1_1_0_3_ELEMENT_TYPE = associate(ModelFactory.createModel_ObjectMultiDatatypeParserRuleCall_1_1_0_3ElementType());

	private static class SingleValueFactory {
		public static IGrammarAwareElementType createSingleValueElementType() {
			return new IGrammarAwareElementType("SingleValue_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueRule());
		}
		public static IGrammarAwareElementType createSingleValue_AlternativesElementType() {
			return new IGrammarAwareElementType("SingleValue_Alternatives_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createSingleValue_Group_0ElementType() {
			return new IGrammarAwareElementType("SingleValue_Group_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createSingleValue_IdKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("SingleValue_IdKeyword_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getIdKeyword_0_0());
		}
		public static IGrammarAwareElementType createSingleValue_ValueAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("SingleValue_ValueAssignment_0_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getValueAssignment_0_1());
		}
		public static IGrammarAwareElementType createSingleValue_ValueIDTerminalRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("SingleValue_ValueIDTerminalRuleCall_0_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getValueIDTerminalRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createSingleValue_Group_1ElementType() {
			return new IGrammarAwareElementType("SingleValue_Group_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createSingleValue_AlternativeKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("SingleValue_AlternativeKeyword_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getAlternativeKeyword_1_0());
		}
		public static IGrammarAwareElementType createSingleValue_ValueAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("SingleValue_ValueAssignment_1_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getValueAssignment_1_1());
		}
		public static IGrammarAwareElementType createSingleValue_ValueAlternatives_1_1_0ElementType() {
			return new IGrammarAwareElementType("SingleValue_ValueAlternatives_1_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getValueAlternatives_1_1_0());
		}
		public static IGrammarAwareElementType createSingleValue_ValueIDTerminalRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("SingleValue_ValueIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getValueIDTerminalRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createSingleValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleValue_ValueSTRINGTerminalRuleCall_1_1_0_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getValueSTRINGTerminalRuleCall_1_1_0_1());
		}
		public static IGrammarAwareElementType createSingleValue_Group_2ElementType() {
			return new IGrammarAwareElementType("SingleValue_Group_2_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createSingleValue_StringKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("SingleValue_StringKeyword_2_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getStringKeyword_2_0());
		}
		public static IGrammarAwareElementType createSingleValue_ValueAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("SingleValue_ValueAssignment_2_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getValueAssignment_2_1());
		}
		public static IGrammarAwareElementType createSingleValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("SingleValue_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleValueAccess().getValueSTRINGTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType SingleValue_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValueElementType());

	public static final IGrammarAwareElementType SingleValue_Alternatives_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_AlternativesElementType());

	public static final IGrammarAwareElementType SingleValue_Group_0_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_Group_0ElementType());

	public static final IGrammarAwareElementType SingleValue_IdKeyword_0_0_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_IdKeyword_0_0ElementType());

	public static final IGrammarAwareElementType SingleValue_ValueAssignment_0_1_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_ValueAssignment_0_1ElementType());

	public static final IGrammarAwareElementType SingleValue_ValueIDTerminalRuleCall_0_1_0_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_ValueIDTerminalRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType SingleValue_Group_1_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_Group_1ElementType());

	public static final IGrammarAwareElementType SingleValue_AlternativeKeyword_1_0_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_AlternativeKeyword_1_0ElementType());

	public static final IGrammarAwareElementType SingleValue_ValueAssignment_1_1_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_ValueAssignment_1_1ElementType());

	public static final IGrammarAwareElementType SingleValue_ValueAlternatives_1_1_0_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_ValueAlternatives_1_1_0ElementType());

	public static final IGrammarAwareElementType SingleValue_ValueIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_ValueIDTerminalRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType SingleValue_ValueSTRINGTerminalRuleCall_1_1_0_1_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleValue_Group_2_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_Group_2ElementType());

	public static final IGrammarAwareElementType SingleValue_StringKeyword_2_0_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_StringKeyword_2_0ElementType());

	public static final IGrammarAwareElementType SingleValue_ValueAssignment_2_1_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_ValueAssignment_2_1ElementType());

	public static final IGrammarAwareElementType SingleValue_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(SingleValueFactory.createSingleValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());

	private static class MultiValueFactory {
		public static IGrammarAwareElementType createMultiValueElementType() {
			return new IGrammarAwareElementType("MultiValue_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueRule());
		}
		public static IGrammarAwareElementType createMultiValue_AlternativesElementType() {
			return new IGrammarAwareElementType("MultiValue_Alternatives_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createMultiValue_Group_0ElementType() {
			return new IGrammarAwareElementType("MultiValue_Group_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createMultiValue_IdsKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("MultiValue_IdsKeyword_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getIdsKeyword_0_0());
		}
		public static IGrammarAwareElementType createMultiValue_ValueAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("MultiValue_ValueAssignment_0_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getValueAssignment_0_1());
		}
		public static IGrammarAwareElementType createMultiValue_ValueIDTerminalRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("MultiValue_ValueIDTerminalRuleCall_0_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getValueIDTerminalRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createMultiValue_Group_1ElementType() {
			return new IGrammarAwareElementType("MultiValue_Group_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createMultiValue_AlternativesKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("MultiValue_AlternativesKeyword_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getAlternativesKeyword_1_0());
		}
		public static IGrammarAwareElementType createMultiValue_ValueAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("MultiValue_ValueAssignment_1_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getValueAssignment_1_1());
		}
		public static IGrammarAwareElementType createMultiValue_ValueAlternatives_1_1_0ElementType() {
			return new IGrammarAwareElementType("MultiValue_ValueAlternatives_1_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getValueAlternatives_1_1_0());
		}
		public static IGrammarAwareElementType createMultiValue_ValueIDTerminalRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("MultiValue_ValueIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getValueIDTerminalRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createMultiValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("MultiValue_ValueSTRINGTerminalRuleCall_1_1_0_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getValueSTRINGTerminalRuleCall_1_1_0_1());
		}
		public static IGrammarAwareElementType createMultiValue_Group_2ElementType() {
			return new IGrammarAwareElementType("MultiValue_Group_2_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createMultiValue_StringsKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("MultiValue_StringsKeyword_2_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getStringsKeyword_2_0());
		}
		public static IGrammarAwareElementType createMultiValue_ValueAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("MultiValue_ValueAssignment_2_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getValueAssignment_2_1());
		}
		public static IGrammarAwareElementType createMultiValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("MultiValue_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiValueAccess().getValueSTRINGTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType MultiValue_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValueElementType());

	public static final IGrammarAwareElementType MultiValue_Alternatives_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_AlternativesElementType());

	public static final IGrammarAwareElementType MultiValue_Group_0_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_Group_0ElementType());

	public static final IGrammarAwareElementType MultiValue_IdsKeyword_0_0_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_IdsKeyword_0_0ElementType());

	public static final IGrammarAwareElementType MultiValue_ValueAssignment_0_1_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_ValueAssignment_0_1ElementType());

	public static final IGrammarAwareElementType MultiValue_ValueIDTerminalRuleCall_0_1_0_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_ValueIDTerminalRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType MultiValue_Group_1_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_Group_1ElementType());

	public static final IGrammarAwareElementType MultiValue_AlternativesKeyword_1_0_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_AlternativesKeyword_1_0ElementType());

	public static final IGrammarAwareElementType MultiValue_ValueAssignment_1_1_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_ValueAssignment_1_1ElementType());

	public static final IGrammarAwareElementType MultiValue_ValueAlternatives_1_1_0_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_ValueAlternatives_1_1_0ElementType());

	public static final IGrammarAwareElementType MultiValue_ValueIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_ValueIDTerminalRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType MultiValue_ValueSTRINGTerminalRuleCall_1_1_0_1_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType());

	public static final IGrammarAwareElementType MultiValue_Group_2_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_Group_2ElementType());

	public static final IGrammarAwareElementType MultiValue_StringsKeyword_2_0_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_StringsKeyword_2_0ElementType());

	public static final IGrammarAwareElementType MultiValue_ValueAssignment_2_1_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_ValueAssignment_2_1ElementType());

	public static final IGrammarAwareElementType MultiValue_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(MultiValueFactory.createMultiValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());

	private static class SingleDatatypeFactory {
		public static IGrammarAwareElementType createSingleDatatypeElementType() {
			return new IGrammarAwareElementType("SingleDatatype_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeRule());
		}
		public static IGrammarAwareElementType createSingleDatatype_AlternativesElementType() {
			return new IGrammarAwareElementType("SingleDatatype_Alternatives_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createSingleDatatype_Group_0ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_Group_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createSingleDatatype_DatatypeidKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_DatatypeidKeyword_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getDatatypeidKeyword_0_0());
		}
		public static IGrammarAwareElementType createSingleDatatype_ValueAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_ValueAssignment_0_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getValueAssignment_0_1());
		}
		public static IGrammarAwareElementType createSingleDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_ValueIdDatatypeParserRuleCall_0_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createSingleDatatype_Group_1ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_Group_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createSingleDatatype_DatatypealternativeKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_DatatypealternativeKeyword_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getDatatypealternativeKeyword_1_0());
		}
		public static IGrammarAwareElementType createSingleDatatype_ValueAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_ValueAssignment_1_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getValueAssignment_1_1());
		}
		public static IGrammarAwareElementType createSingleDatatype_ValueAlternatives_1_1_0ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_ValueAlternatives_1_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getValueAlternatives_1_1_0());
		}
		public static IGrammarAwareElementType createSingleDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createSingleDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1());
		}
		public static IGrammarAwareElementType createSingleDatatype_Group_2ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_Group_2_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createSingleDatatype_DatatypestringKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_DatatypestringKeyword_2_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getDatatypestringKeyword_2_0());
		}
		public static IGrammarAwareElementType createSingleDatatype_ValueAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_ValueAssignment_2_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getValueAssignment_2_1());
		}
		public static IGrammarAwareElementType createSingleDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("SingleDatatype_ValueStringDatatypeParserRuleCall_2_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType SingleDatatype_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatypeElementType());

	public static final IGrammarAwareElementType SingleDatatype_Alternatives_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_AlternativesElementType());

	public static final IGrammarAwareElementType SingleDatatype_Group_0_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_Group_0ElementType());

	public static final IGrammarAwareElementType SingleDatatype_DatatypeidKeyword_0_0_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_DatatypeidKeyword_0_0ElementType());

	public static final IGrammarAwareElementType SingleDatatype_ValueAssignment_0_1_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_ValueAssignment_0_1ElementType());

	public static final IGrammarAwareElementType SingleDatatype_ValueIdDatatypeParserRuleCall_0_1_0_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType SingleDatatype_Group_1_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_Group_1ElementType());

	public static final IGrammarAwareElementType SingleDatatype_DatatypealternativeKeyword_1_0_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_DatatypealternativeKeyword_1_0ElementType());

	public static final IGrammarAwareElementType SingleDatatype_ValueAssignment_1_1_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_ValueAssignment_1_1ElementType());

	public static final IGrammarAwareElementType SingleDatatype_ValueAlternatives_1_1_0_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_ValueAlternatives_1_1_0ElementType());

	public static final IGrammarAwareElementType SingleDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType SingleDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType());

	public static final IGrammarAwareElementType SingleDatatype_Group_2_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_Group_2ElementType());

	public static final IGrammarAwareElementType SingleDatatype_DatatypestringKeyword_2_0_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_DatatypestringKeyword_2_0ElementType());

	public static final IGrammarAwareElementType SingleDatatype_ValueAssignment_2_1_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_ValueAssignment_2_1ElementType());

	public static final IGrammarAwareElementType SingleDatatype_ValueStringDatatypeParserRuleCall_2_1_0_ELEMENT_TYPE = associate(SingleDatatypeFactory.createSingleDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType());

	private static class MultiDatatypeFactory {
		public static IGrammarAwareElementType createMultiDatatypeElementType() {
			return new IGrammarAwareElementType("MultiDatatype_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeRule());
		}
		public static IGrammarAwareElementType createMultiDatatype_AlternativesElementType() {
			return new IGrammarAwareElementType("MultiDatatype_Alternatives_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createMultiDatatype_Group_0ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_Group_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createMultiDatatype_DatatypeidsKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_DatatypeidsKeyword_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getDatatypeidsKeyword_0_0());
		}
		public static IGrammarAwareElementType createMultiDatatype_ValueAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_ValueAssignment_0_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getValueAssignment_0_1());
		}
		public static IGrammarAwareElementType createMultiDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_ValueIdDatatypeParserRuleCall_0_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createMultiDatatype_Group_1ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_Group_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createMultiDatatype_DatatypealternativesKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_DatatypealternativesKeyword_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getDatatypealternativesKeyword_1_0());
		}
		public static IGrammarAwareElementType createMultiDatatype_ValueAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_ValueAssignment_1_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getValueAssignment_1_1());
		}
		public static IGrammarAwareElementType createMultiDatatype_ValueAlternatives_1_1_0ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_ValueAlternatives_1_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getValueAlternatives_1_1_0());
		}
		public static IGrammarAwareElementType createMultiDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getValueIdDatatypeParserRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createMultiDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_1_1_0_1());
		}
		public static IGrammarAwareElementType createMultiDatatype_Group_2ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_Group_2_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createMultiDatatype_DatatypestringsKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_DatatypestringsKeyword_2_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getDatatypestringsKeyword_2_0());
		}
		public static IGrammarAwareElementType createMultiDatatype_ValueAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_ValueAssignment_2_1_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getValueAssignment_2_1());
		}
		public static IGrammarAwareElementType createMultiDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("MultiDatatype_ValueStringDatatypeParserRuleCall_2_1_0_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiDatatypeAccess().getValueStringDatatypeParserRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType MultiDatatype_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatypeElementType());

	public static final IGrammarAwareElementType MultiDatatype_Alternatives_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_AlternativesElementType());

	public static final IGrammarAwareElementType MultiDatatype_Group_0_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_Group_0ElementType());

	public static final IGrammarAwareElementType MultiDatatype_DatatypeidsKeyword_0_0_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_DatatypeidsKeyword_0_0ElementType());

	public static final IGrammarAwareElementType MultiDatatype_ValueAssignment_0_1_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_ValueAssignment_0_1ElementType());

	public static final IGrammarAwareElementType MultiDatatype_ValueIdDatatypeParserRuleCall_0_1_0_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType MultiDatatype_Group_1_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_Group_1ElementType());

	public static final IGrammarAwareElementType MultiDatatype_DatatypealternativesKeyword_1_0_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_DatatypealternativesKeyword_1_0ElementType());

	public static final IGrammarAwareElementType MultiDatatype_ValueAssignment_1_1_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_ValueAssignment_1_1ElementType());

	public static final IGrammarAwareElementType MultiDatatype_ValueAlternatives_1_1_0_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_ValueAlternatives_1_1_0ElementType());

	public static final IGrammarAwareElementType MultiDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType MultiDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType());

	public static final IGrammarAwareElementType MultiDatatype_Group_2_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_Group_2ElementType());

	public static final IGrammarAwareElementType MultiDatatype_DatatypestringsKeyword_2_0_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_DatatypestringsKeyword_2_0ElementType());

	public static final IGrammarAwareElementType MultiDatatype_ValueAssignment_2_1_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_ValueAssignment_2_1ElementType());

	public static final IGrammarAwareElementType MultiDatatype_ValueStringDatatypeParserRuleCall_2_1_0_ELEMENT_TYPE = associate(MultiDatatypeFactory.createMultiDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType());

	private static class IdDatatypeFactory {
		public static IGrammarAwareElementType createIdDatatypeElementType() {
			return new IGrammarAwareElementType("IdDatatype_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIdDatatypeRule());
		}
		public static IGrammarAwareElementType createIdDatatype_IDTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("IdDatatype_IDTerminalRuleCall_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIdDatatypeAccess().getIDTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType IdDatatype_ELEMENT_TYPE = associate(IdDatatypeFactory.createIdDatatypeElementType());

	public static final IGrammarAwareElementType IdDatatype_IDTerminalRuleCall_ELEMENT_TYPE = associate(IdDatatypeFactory.createIdDatatype_IDTerminalRuleCallElementType());

	private static class StringDatatypeFactory {
		public static IGrammarAwareElementType createStringDatatypeElementType() {
			return new IGrammarAwareElementType("StringDatatype_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStringDatatypeRule());
		}
		public static IGrammarAwareElementType createStringDatatype_STRINGTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("StringDatatype_STRINGTerminalRuleCall_ELEMENT_TYPE", AssignmentsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStringDatatypeAccess().getSTRINGTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType StringDatatype_ELEMENT_TYPE = associate(StringDatatypeFactory.createStringDatatypeElementType());

	public static final IGrammarAwareElementType StringDatatype_STRINGTerminalRuleCall_ELEMENT_TYPE = associate(StringDatatypeFactory.createStringDatatype_STRINGTerminalRuleCallElementType());

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

	public IGrammarAwareElementType getModel_Group_0ElementType() {
		return Model_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SimpleKeyword_0_0ElementType() {
		return Model_SimpleKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Alternatives_0_1ElementType() {
		return Model_Alternatives_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SingleAssignment_0_1_0ElementType() {
		return Model_SingleAssignment_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SingleSingleValueParserRuleCall_0_1_0_0ElementType() {
		return Model_SingleSingleValueParserRuleCall_0_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiAssignment_0_1_1ElementType() {
		return Model_MultiAssignment_0_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiMultiValueParserRuleCall_0_1_1_0ElementType() {
		return Model_MultiMultiValueParserRuleCall_0_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SingleAssignment_0_1_2ElementType() {
		return Model_SingleAssignment_0_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SingleSingleDatatypeParserRuleCall_0_1_2_0ElementType() {
		return Model_SingleSingleDatatypeParserRuleCall_0_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiAssignment_0_1_3ElementType() {
		return Model_MultiAssignment_0_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_MultiMultiDatatypeParserRuleCall_0_1_3_0ElementType() {
		return Model_MultiMultiDatatypeParserRuleCall_0_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ComplexKeyword_1_0ElementType() {
		return Model_ComplexKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ObjectAssignment_1_1ElementType() {
		return Model_ObjectAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ObjectAlternatives_1_1_0ElementType() {
		return Model_ObjectAlternatives_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ObjectSingleValueParserRuleCall_1_1_0_0ElementType() {
		return Model_ObjectSingleValueParserRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ObjectMultiValueParserRuleCall_1_1_0_1ElementType() {
		return Model_ObjectMultiValueParserRuleCall_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ObjectSingleDatatypeParserRuleCall_1_1_0_2ElementType() {
		return Model_ObjectSingleDatatypeParserRuleCall_1_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ObjectMultiDatatypeParserRuleCall_1_1_0_3ElementType() {
		return Model_ObjectMultiDatatypeParserRuleCall_1_1_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValueElementType() {
		return SingleValue_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_AlternativesElementType() {
		return SingleValue_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_Group_0ElementType() {
		return SingleValue_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_IdKeyword_0_0ElementType() {
		return SingleValue_IdKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_ValueAssignment_0_1ElementType() {
		return SingleValue_ValueAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_ValueIDTerminalRuleCall_0_1_0ElementType() {
		return SingleValue_ValueIDTerminalRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_Group_1ElementType() {
		return SingleValue_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_AlternativeKeyword_1_0ElementType() {
		return SingleValue_AlternativeKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_ValueAssignment_1_1ElementType() {
		return SingleValue_ValueAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_ValueAlternatives_1_1_0ElementType() {
		return SingleValue_ValueAlternatives_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_ValueIDTerminalRuleCall_1_1_0_0ElementType() {
		return SingleValue_ValueIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType() {
		return SingleValue_ValueSTRINGTerminalRuleCall_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_Group_2ElementType() {
		return SingleValue_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_StringKeyword_2_0ElementType() {
		return SingleValue_StringKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_ValueAssignment_2_1ElementType() {
		return SingleValue_ValueAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType() {
		return SingleValue_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValueElementType() {
		return MultiValue_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_AlternativesElementType() {
		return MultiValue_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_Group_0ElementType() {
		return MultiValue_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_IdsKeyword_0_0ElementType() {
		return MultiValue_IdsKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_ValueAssignment_0_1ElementType() {
		return MultiValue_ValueAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_ValueIDTerminalRuleCall_0_1_0ElementType() {
		return MultiValue_ValueIDTerminalRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_Group_1ElementType() {
		return MultiValue_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_AlternativesKeyword_1_0ElementType() {
		return MultiValue_AlternativesKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_ValueAssignment_1_1ElementType() {
		return MultiValue_ValueAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_ValueAlternatives_1_1_0ElementType() {
		return MultiValue_ValueAlternatives_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_ValueIDTerminalRuleCall_1_1_0_0ElementType() {
		return MultiValue_ValueIDTerminalRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType() {
		return MultiValue_ValueSTRINGTerminalRuleCall_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_Group_2ElementType() {
		return MultiValue_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_StringsKeyword_2_0ElementType() {
		return MultiValue_StringsKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_ValueAssignment_2_1ElementType() {
		return MultiValue_ValueAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType() {
		return MultiValue_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatypeElementType() {
		return SingleDatatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_AlternativesElementType() {
		return SingleDatatype_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_Group_0ElementType() {
		return SingleDatatype_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_DatatypeidKeyword_0_0ElementType() {
		return SingleDatatype_DatatypeidKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_ValueAssignment_0_1ElementType() {
		return SingleDatatype_ValueAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType() {
		return SingleDatatype_ValueIdDatatypeParserRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_Group_1ElementType() {
		return SingleDatatype_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_DatatypealternativeKeyword_1_0ElementType() {
		return SingleDatatype_DatatypealternativeKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_ValueAssignment_1_1ElementType() {
		return SingleDatatype_ValueAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_ValueAlternatives_1_1_0ElementType() {
		return SingleDatatype_ValueAlternatives_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType() {
		return SingleDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType() {
		return SingleDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_Group_2ElementType() {
		return SingleDatatype_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_DatatypestringKeyword_2_0ElementType() {
		return SingleDatatype_DatatypestringKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_ValueAssignment_2_1ElementType() {
		return SingleDatatype_ValueAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType() {
		return SingleDatatype_ValueStringDatatypeParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatypeElementType() {
		return MultiDatatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_AlternativesElementType() {
		return MultiDatatype_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_Group_0ElementType() {
		return MultiDatatype_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_DatatypeidsKeyword_0_0ElementType() {
		return MultiDatatype_DatatypeidsKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_ValueAssignment_0_1ElementType() {
		return MultiDatatype_ValueAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType() {
		return MultiDatatype_ValueIdDatatypeParserRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_Group_1ElementType() {
		return MultiDatatype_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_DatatypealternativesKeyword_1_0ElementType() {
		return MultiDatatype_DatatypealternativesKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_ValueAssignment_1_1ElementType() {
		return MultiDatatype_ValueAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_ValueAlternatives_1_1_0ElementType() {
		return MultiDatatype_ValueAlternatives_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType() {
		return MultiDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType() {
		return MultiDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_Group_2ElementType() {
		return MultiDatatype_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_DatatypestringsKeyword_2_0ElementType() {
		return MultiDatatype_DatatypestringsKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_ValueAssignment_2_1ElementType() {
		return MultiDatatype_ValueAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType() {
		return MultiDatatype_ValueStringDatatypeParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIdDatatypeElementType() {
		return IdDatatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIdDatatype_IDTerminalRuleCallElementType() {
		return IdDatatype_IDTerminalRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStringDatatypeElementType() {
		return StringDatatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStringDatatype_STRINGTerminalRuleCallElementType() {
		return StringDatatype_STRINGTerminalRuleCall_ELEMENT_TYPE;
	}

}
