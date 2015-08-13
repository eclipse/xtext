package org.eclipse.xtext.linking.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.Bug287988TestLanguageFileImpl;
import org.eclipse.xtext.linking.services.Bug287988TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug287988TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug287988TestLanguageFileImpl>>(Bug287988TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug287988TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug287988TestLanguageLanguage.INSTANCE.getInstance(Bug287988TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_ActionsKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ActionsKeyword_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getActionsKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_AttributesAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Model_AttributesAssignment_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesAssignment_0_1());
		}
		public static IGrammarAwareElementType createModel_AttributesBaseAttributeParserRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_AttributesBaseAttributeParserRuleCall_0_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesBaseAttributeParserRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_SimpleKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SimpleKeyword_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSimpleKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_AttributesAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_AttributesAssignment_1_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_AttributesSimpleAttributeParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_AttributesSimpleAttributeParserRuleCall_1_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesSimpleAttributeParserRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_2_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createModel_RulecallKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_RulecallKeyword_2_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRulecallKeyword_2_0());
		}
		public static IGrammarAwareElementType createModel_AttributesAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Model_AttributesAssignment_2_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesAssignment_2_1());
		}
		public static IGrammarAwareElementType createModel_AttributesRuleCallAttributeParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_AttributesRuleCallAttributeParserRuleCall_2_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesRuleCallAttributeParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_3ElementType() {
			return new IGrammarAwareElementType("Model_Group_3_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createModel_Rulecall2Keyword_3_0ElementType() {
			return new IGrammarAwareElementType("Model_Rulecall2Keyword_3_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRulecall2Keyword_3_0());
		}
		public static IGrammarAwareElementType createModel_AttributesAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Model_AttributesAssignment_3_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesAssignment_3_1());
		}
		public static IGrammarAwareElementType createModel_AttributesRuleCallAttribute2ParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Model_AttributesRuleCallAttribute2ParserRuleCall_3_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesRuleCallAttribute2ParserRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_4ElementType() {
			return new IGrammarAwareElementType("Model_Group_4_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createModel_Rulecall3Keyword_4_0ElementType() {
			return new IGrammarAwareElementType("Model_Rulecall3Keyword_4_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getRulecall3Keyword_4_0());
		}
		public static IGrammarAwareElementType createModel_AttributesAssignment_4_1ElementType() {
			return new IGrammarAwareElementType("Model_AttributesAssignment_4_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesAssignment_4_1());
		}
		public static IGrammarAwareElementType createModel_AttributesRuleCallAttribute3ParserRuleCall_4_1_0ElementType() {
			return new IGrammarAwareElementType("Model_AttributesRuleCallAttribute3ParserRuleCall_4_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesRuleCallAttribute3ParserRuleCall_4_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_5ElementType() {
			return new IGrammarAwareElementType("Model_Group_5_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createModel_InlinedActionsKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("Model_InlinedActionsKeyword_5_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getInlinedActionsKeyword_5_0());
		}
		public static IGrammarAwareElementType createModel_AttributesAssignment_5_1ElementType() {
			return new IGrammarAwareElementType("Model_AttributesAssignment_5_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesAssignment_5_1());
		}
		public static IGrammarAwareElementType createModel_AttributesActionAttributeParserRuleCall_5_1_0ElementType() {
			return new IGrammarAwareElementType("Model_AttributesActionAttributeParserRuleCall_5_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAttributesActionAttributeParserRuleCall_5_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_ActionsKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ActionsKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_AttributesAssignment_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Model_AttributesBaseAttributeParserRuleCall_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesBaseAttributeParserRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_SimpleKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SimpleKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_AttributesAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_AttributesSimpleAttributeParserRuleCall_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesSimpleAttributeParserRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_2ElementType());

	public static final IGrammarAwareElementType Model_RulecallKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_RulecallKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Model_AttributesAssignment_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Model_AttributesRuleCallAttributeParserRuleCall_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesRuleCallAttributeParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_3_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_3ElementType());

	public static final IGrammarAwareElementType Model_Rulecall2Keyword_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Rulecall2Keyword_3_0ElementType());

	public static final IGrammarAwareElementType Model_AttributesAssignment_3_1_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Model_AttributesRuleCallAttribute2ParserRuleCall_3_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesRuleCallAttribute2ParserRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_4_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_4ElementType());

	public static final IGrammarAwareElementType Model_Rulecall3Keyword_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Rulecall3Keyword_4_0ElementType());

	public static final IGrammarAwareElementType Model_AttributesAssignment_4_1_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesAssignment_4_1ElementType());

	public static final IGrammarAwareElementType Model_AttributesRuleCallAttribute3ParserRuleCall_4_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesRuleCallAttribute3ParserRuleCall_4_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_5_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_5ElementType());

	public static final IGrammarAwareElementType Model_InlinedActionsKeyword_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_InlinedActionsKeyword_5_0ElementType());

	public static final IGrammarAwareElementType Model_AttributesAssignment_5_1_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesAssignment_5_1ElementType());

	public static final IGrammarAwareElementType Model_AttributesActionAttributeParserRuleCall_5_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AttributesActionAttributeParserRuleCall_5_1_0ElementType());

	private static class BaseAttributeFactory {
		public static IGrammarAwareElementType createBaseAttributeElementType() {
			return new IGrammarAwareElementType("BaseAttribute_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeRule());
		}
		public static IGrammarAwareElementType createBaseAttribute_GroupElementType() {
			return new IGrammarAwareElementType("BaseAttribute_Group_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getGroup());
		}
		public static IGrammarAwareElementType createBaseAttribute_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_Alternatives_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getAlternatives_0());
		}
		public static IGrammarAwareElementType createBaseAttribute_AttributeParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_AttributeParserRuleCall_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getAttributeParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createBaseAttribute_MasterParserRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_MasterParserRuleCall_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getMasterParserRuleCall_0_1());
		}
		public static IGrammarAwareElementType createBaseAttribute_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_Alternatives_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createBaseAttribute_Group_1_0ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_Group_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createBaseAttribute_RefKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_RefKeyword_1_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getRefKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createBaseAttribute_TypeRefAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_TypeRefAssignment_1_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getTypeRefAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createBaseAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getTypeRefBaseAttributeCrossReference_1_0_1_0());
		}
		public static IGrammarAwareElementType createBaseAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getTypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1());
		}
		public static IGrammarAwareElementType createBaseAttribute_TypeAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_TypeAssignment_1_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getTypeAssignment_1_1());
		}
		public static IGrammarAwareElementType createBaseAttribute_TypeIDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getTypeIDTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createBaseAttribute_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_NameAssignment_2_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createBaseAttribute_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createBaseAttribute_SemicolonKeyword_3ElementType() {
			return new IGrammarAwareElementType("BaseAttribute_SemicolonKeyword_3_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBaseAttributeAccess().getSemicolonKeyword_3());
		}
	}

	public static final IGrammarAwareElementType BaseAttribute_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttributeElementType());

	public static final IGrammarAwareElementType BaseAttribute_Group_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_GroupElementType());

	public static final IGrammarAwareElementType BaseAttribute_Alternatives_0_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_Alternatives_0ElementType());

	public static final IGrammarAwareElementType BaseAttribute_AttributeParserRuleCall_0_0_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_AttributeParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType BaseAttribute_MasterParserRuleCall_0_1_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_MasterParserRuleCall_0_1ElementType());

	public static final IGrammarAwareElementType BaseAttribute_Alternatives_1_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_Alternatives_1ElementType());

	public static final IGrammarAwareElementType BaseAttribute_Group_1_0_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_Group_1_0ElementType());

	public static final IGrammarAwareElementType BaseAttribute_RefKeyword_1_0_0_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_RefKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType BaseAttribute_TypeRefAssignment_1_0_1_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_TypeRefAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType BaseAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());

	public static final IGrammarAwareElementType BaseAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType());

	public static final IGrammarAwareElementType BaseAttribute_TypeAssignment_1_1_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_TypeAssignment_1_1ElementType());

	public static final IGrammarAwareElementType BaseAttribute_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_TypeIDTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType BaseAttribute_NameAssignment_2_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType BaseAttribute_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType BaseAttribute_SemicolonKeyword_3_ELEMENT_TYPE = associate(BaseAttributeFactory.createBaseAttribute_SemicolonKeyword_3ElementType());

	private static class AttributeFactory {
		public static IGrammarAwareElementType createAttributeElementType() {
			return new IGrammarAwareElementType("Attribute_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeRule());
		}
		public static IGrammarAwareElementType createAttribute_GroupElementType() {
			return new IGrammarAwareElementType("Attribute_Group_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeAccess().getGroup());
		}
		public static IGrammarAwareElementType createAttribute_AttributeAction_0ElementType() {
			return new IGrammarAwareElementType("Attribute_AttributeAction_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeAccess().getAttributeAction_0());
		}
		public static IGrammarAwareElementType createAttribute_AttributeKeyword_1ElementType() {
			return new IGrammarAwareElementType("Attribute_AttributeKeyword_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAttributeAccess().getAttributeKeyword_1());
		}
	}

	public static final IGrammarAwareElementType Attribute_ELEMENT_TYPE = associate(AttributeFactory.createAttributeElementType());

	public static final IGrammarAwareElementType Attribute_Group_ELEMENT_TYPE = associate(AttributeFactory.createAttribute_GroupElementType());

	public static final IGrammarAwareElementType Attribute_AttributeAction_0_ELEMENT_TYPE = associate(AttributeFactory.createAttribute_AttributeAction_0ElementType());

	public static final IGrammarAwareElementType Attribute_AttributeKeyword_1_ELEMENT_TYPE = associate(AttributeFactory.createAttribute_AttributeKeyword_1ElementType());

	private static class MasterFactory {
		public static IGrammarAwareElementType createMasterElementType() {
			return new IGrammarAwareElementType("Master_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMasterRule());
		}
		public static IGrammarAwareElementType createMaster_GroupElementType() {
			return new IGrammarAwareElementType("Master_Group_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMasterAccess().getGroup());
		}
		public static IGrammarAwareElementType createMaster_MasterAction_0ElementType() {
			return new IGrammarAwareElementType("Master_MasterAction_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMasterAccess().getMasterAction_0());
		}
		public static IGrammarAwareElementType createMaster_MasterKeyword_1ElementType() {
			return new IGrammarAwareElementType("Master_MasterKeyword_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMasterAccess().getMasterKeyword_1());
		}
	}

	public static final IGrammarAwareElementType Master_ELEMENT_TYPE = associate(MasterFactory.createMasterElementType());

	public static final IGrammarAwareElementType Master_Group_ELEMENT_TYPE = associate(MasterFactory.createMaster_GroupElementType());

	public static final IGrammarAwareElementType Master_MasterAction_0_ELEMENT_TYPE = associate(MasterFactory.createMaster_MasterAction_0ElementType());

	public static final IGrammarAwareElementType Master_MasterKeyword_1_ELEMENT_TYPE = associate(MasterFactory.createMaster_MasterKeyword_1ElementType());

	private static class ActionAttributeFactory {
		public static IGrammarAwareElementType createActionAttributeElementType() {
			return new IGrammarAwareElementType("ActionAttribute_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeRule());
		}
		public static IGrammarAwareElementType createActionAttribute_GroupElementType() {
			return new IGrammarAwareElementType("ActionAttribute_Group_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getGroup());
		}
		public static IGrammarAwareElementType createActionAttribute_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_Alternatives_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getAlternatives_0());
		}
		public static IGrammarAwareElementType createActionAttribute_Group_0_0ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_Group_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getGroup_0_0());
		}
		public static IGrammarAwareElementType createActionAttribute_AttributeAction_0_0_0ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_AttributeAction_0_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getAttributeAction_0_0_0());
		}
		public static IGrammarAwareElementType createActionAttribute_AttributeKeyword_0_0_1ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_AttributeKeyword_0_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getAttributeKeyword_0_0_1());
		}
		public static IGrammarAwareElementType createActionAttribute_Group_0_1ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_Group_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getGroup_0_1());
		}
		public static IGrammarAwareElementType createActionAttribute_MasterAction_0_1_0ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_MasterAction_0_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getMasterAction_0_1_0());
		}
		public static IGrammarAwareElementType createActionAttribute_MasterKeyword_0_1_1ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_MasterKeyword_0_1_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getMasterKeyword_0_1_1());
		}
		public static IGrammarAwareElementType createActionAttribute_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_Alternatives_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createActionAttribute_Group_1_0ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_Group_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createActionAttribute_RefKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_RefKeyword_1_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getRefKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createActionAttribute_TypeRefAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_TypeRefAssignment_1_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getTypeRefAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createActionAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getTypeRefBaseAttributeCrossReference_1_0_1_0());
		}
		public static IGrammarAwareElementType createActionAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getTypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1());
		}
		public static IGrammarAwareElementType createActionAttribute_TypeAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_TypeAssignment_1_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getTypeAssignment_1_1());
		}
		public static IGrammarAwareElementType createActionAttribute_TypeIDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getTypeIDTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createActionAttribute_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_NameAssignment_2_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createActionAttribute_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createActionAttribute_SemicolonKeyword_3ElementType() {
			return new IGrammarAwareElementType("ActionAttribute_SemicolonKeyword_3_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getActionAttributeAccess().getSemicolonKeyword_3());
		}
	}

	public static final IGrammarAwareElementType ActionAttribute_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttributeElementType());

	public static final IGrammarAwareElementType ActionAttribute_Group_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_GroupElementType());

	public static final IGrammarAwareElementType ActionAttribute_Alternatives_0_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_Alternatives_0ElementType());

	public static final IGrammarAwareElementType ActionAttribute_Group_0_0_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_Group_0_0ElementType());

	public static final IGrammarAwareElementType ActionAttribute_AttributeAction_0_0_0_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_AttributeAction_0_0_0ElementType());

	public static final IGrammarAwareElementType ActionAttribute_AttributeKeyword_0_0_1_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_AttributeKeyword_0_0_1ElementType());

	public static final IGrammarAwareElementType ActionAttribute_Group_0_1_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_Group_0_1ElementType());

	public static final IGrammarAwareElementType ActionAttribute_MasterAction_0_1_0_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_MasterAction_0_1_0ElementType());

	public static final IGrammarAwareElementType ActionAttribute_MasterKeyword_0_1_1_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_MasterKeyword_0_1_1ElementType());

	public static final IGrammarAwareElementType ActionAttribute_Alternatives_1_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_Alternatives_1ElementType());

	public static final IGrammarAwareElementType ActionAttribute_Group_1_0_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_Group_1_0ElementType());

	public static final IGrammarAwareElementType ActionAttribute_RefKeyword_1_0_0_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_RefKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType ActionAttribute_TypeRefAssignment_1_0_1_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_TypeRefAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType ActionAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());

	public static final IGrammarAwareElementType ActionAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType());

	public static final IGrammarAwareElementType ActionAttribute_TypeAssignment_1_1_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_TypeAssignment_1_1ElementType());

	public static final IGrammarAwareElementType ActionAttribute_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_TypeIDTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType ActionAttribute_NameAssignment_2_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType ActionAttribute_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType ActionAttribute_SemicolonKeyword_3_ELEMENT_TYPE = associate(ActionAttributeFactory.createActionAttribute_SemicolonKeyword_3ElementType());

	private static class SimpleAttributeFactory {
		public static IGrammarAwareElementType createSimpleAttributeElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeRule());
		}
		public static IGrammarAwareElementType createSimpleAttribute_GroupElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_Group_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getGroup());
		}
		public static IGrammarAwareElementType createSimpleAttribute_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_Alternatives_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getAlternatives_0());
		}
		public static IGrammarAwareElementType createSimpleAttribute_Group_0_0ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_Group_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getGroup_0_0());
		}
		public static IGrammarAwareElementType createSimpleAttribute_RefKeyword_0_0_0ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_RefKeyword_0_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getRefKeyword_0_0_0());
		}
		public static IGrammarAwareElementType createSimpleAttribute_TypeRefAssignment_0_0_1ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_TypeRefAssignment_0_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getTypeRefAssignment_0_0_1());
		}
		public static IGrammarAwareElementType createSimpleAttribute_TypeRefBaseAttributeCrossReference_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_TypeRefBaseAttributeCrossReference_0_0_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getTypeRefBaseAttributeCrossReference_0_0_1_0());
		}
		public static IGrammarAwareElementType createSimpleAttribute_TypeRefBaseAttributeIDTerminalRuleCall_0_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_TypeRefBaseAttributeIDTerminalRuleCall_0_0_1_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getTypeRefBaseAttributeIDTerminalRuleCall_0_0_1_0_1());
		}
		public static IGrammarAwareElementType createSimpleAttribute_TypeAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_TypeAssignment_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getTypeAssignment_0_1());
		}
		public static IGrammarAwareElementType createSimpleAttribute_TypeIDTerminalRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_TypeIDTerminalRuleCall_0_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getTypeIDTerminalRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createSimpleAttribute_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_NameAssignment_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSimpleAttribute_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSimpleAttribute_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("SimpleAttribute_SemicolonKeyword_2_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAttributeAccess().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType SimpleAttribute_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttributeElementType());

	public static final IGrammarAwareElementType SimpleAttribute_Group_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_GroupElementType());

	public static final IGrammarAwareElementType SimpleAttribute_Alternatives_0_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_Alternatives_0ElementType());

	public static final IGrammarAwareElementType SimpleAttribute_Group_0_0_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_Group_0_0ElementType());

	public static final IGrammarAwareElementType SimpleAttribute_RefKeyword_0_0_0_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_RefKeyword_0_0_0ElementType());

	public static final IGrammarAwareElementType SimpleAttribute_TypeRefAssignment_0_0_1_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_TypeRefAssignment_0_0_1ElementType());

	public static final IGrammarAwareElementType SimpleAttribute_TypeRefBaseAttributeCrossReference_0_0_1_0_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_TypeRefBaseAttributeCrossReference_0_0_1_0ElementType());

	public static final IGrammarAwareElementType SimpleAttribute_TypeRefBaseAttributeIDTerminalRuleCall_0_0_1_0_1_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_TypeRefBaseAttributeIDTerminalRuleCall_0_0_1_0_1ElementType());

	public static final IGrammarAwareElementType SimpleAttribute_TypeAssignment_0_1_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_TypeAssignment_0_1ElementType());

	public static final IGrammarAwareElementType SimpleAttribute_TypeIDTerminalRuleCall_0_1_0_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_TypeIDTerminalRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType SimpleAttribute_NameAssignment_1_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType SimpleAttribute_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType SimpleAttribute_SemicolonKeyword_2_ELEMENT_TYPE = associate(SimpleAttributeFactory.createSimpleAttribute_SemicolonKeyword_2ElementType());

	private static class RuleCallAttributeFactory {
		public static IGrammarAwareElementType createRuleCallAttributeElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttributeRule());
		}
		public static IGrammarAwareElementType createRuleCallAttribute_GroupElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute_Group_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttributeAccess().getGroup());
		}
		public static IGrammarAwareElementType createRuleCallAttribute_CallMeParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute_CallMeParserRuleCall_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttributeAccess().getCallMeParserRuleCall_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute_NameAssignment_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttributeAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createRuleCallAttribute_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttributeAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute_SemicolonKeyword_2_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttributeAccess().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType RuleCallAttribute_ELEMENT_TYPE = associate(RuleCallAttributeFactory.createRuleCallAttributeElementType());

	public static final IGrammarAwareElementType RuleCallAttribute_Group_ELEMENT_TYPE = associate(RuleCallAttributeFactory.createRuleCallAttribute_GroupElementType());

	public static final IGrammarAwareElementType RuleCallAttribute_CallMeParserRuleCall_0_ELEMENT_TYPE = associate(RuleCallAttributeFactory.createRuleCallAttribute_CallMeParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute_NameAssignment_1_ELEMENT_TYPE = associate(RuleCallAttributeFactory.createRuleCallAttribute_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(RuleCallAttributeFactory.createRuleCallAttribute_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute_SemicolonKeyword_2_ELEMENT_TYPE = associate(RuleCallAttributeFactory.createRuleCallAttribute_SemicolonKeyword_2ElementType());

	private static class CallMeFactory {
		public static IGrammarAwareElementType createCallMeElementType() {
			return new IGrammarAwareElementType("CallMe_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMeRule());
		}
		public static IGrammarAwareElementType createCallMe_AlternativesElementType() {
			return new IGrammarAwareElementType("CallMe_Alternatives_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMeAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createCallMe_Group_0ElementType() {
			return new IGrammarAwareElementType("CallMe_Group_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMeAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createCallMe_RefKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("CallMe_RefKeyword_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMeAccess().getRefKeyword_0_0());
		}
		public static IGrammarAwareElementType createCallMe_TypeRefAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("CallMe_TypeRefAssignment_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMeAccess().getTypeRefAssignment_0_1());
		}
		public static IGrammarAwareElementType createCallMe_TypeRefBaseAttributeCrossReference_0_1_0ElementType() {
			return new IGrammarAwareElementType("CallMe_TypeRefBaseAttributeCrossReference_0_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMeAccess().getTypeRefBaseAttributeCrossReference_0_1_0());
		}
		public static IGrammarAwareElementType createCallMe_TypeRefBaseAttributeIDTerminalRuleCall_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("CallMe_TypeRefBaseAttributeIDTerminalRuleCall_0_1_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMeAccess().getTypeRefBaseAttributeIDTerminalRuleCall_0_1_0_1());
		}
		public static IGrammarAwareElementType createCallMe_TypeAssignment_1ElementType() {
			return new IGrammarAwareElementType("CallMe_TypeAssignment_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMeAccess().getTypeAssignment_1());
		}
		public static IGrammarAwareElementType createCallMe_TypeIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("CallMe_TypeIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMeAccess().getTypeIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType CallMe_ELEMENT_TYPE = associate(CallMeFactory.createCallMeElementType());

	public static final IGrammarAwareElementType CallMe_Alternatives_ELEMENT_TYPE = associate(CallMeFactory.createCallMe_AlternativesElementType());

	public static final IGrammarAwareElementType CallMe_Group_0_ELEMENT_TYPE = associate(CallMeFactory.createCallMe_Group_0ElementType());

	public static final IGrammarAwareElementType CallMe_RefKeyword_0_0_ELEMENT_TYPE = associate(CallMeFactory.createCallMe_RefKeyword_0_0ElementType());

	public static final IGrammarAwareElementType CallMe_TypeRefAssignment_0_1_ELEMENT_TYPE = associate(CallMeFactory.createCallMe_TypeRefAssignment_0_1ElementType());

	public static final IGrammarAwareElementType CallMe_TypeRefBaseAttributeCrossReference_0_1_0_ELEMENT_TYPE = associate(CallMeFactory.createCallMe_TypeRefBaseAttributeCrossReference_0_1_0ElementType());

	public static final IGrammarAwareElementType CallMe_TypeRefBaseAttributeIDTerminalRuleCall_0_1_0_1_ELEMENT_TYPE = associate(CallMeFactory.createCallMe_TypeRefBaseAttributeIDTerminalRuleCall_0_1_0_1ElementType());

	public static final IGrammarAwareElementType CallMe_TypeAssignment_1_ELEMENT_TYPE = associate(CallMeFactory.createCallMe_TypeAssignment_1ElementType());

	public static final IGrammarAwareElementType CallMe_TypeIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(CallMeFactory.createCallMe_TypeIDTerminalRuleCall_1_0ElementType());

	private static class RuleCallAttribute2Factory {
		public static IGrammarAwareElementType createRuleCallAttribute2ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Rule());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_GroupElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_Group_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getGroup());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_CallMe2ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_CallMe2ParserRuleCall_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getCallMe2ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_Alternatives_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_Group_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_Group_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_RefKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_RefKeyword_1_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getRefKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_TypeRefAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_TypeRefAssignment_1_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getTypeRefAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getTypeRefBaseAttributeCrossReference_1_0_1_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getTypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_TypeAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_TypeAssignment_1_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getTypeAssignment_1_1());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_TypeIDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getTypeIDTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute2_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute2_SemicolonKeyword_2_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute2Access().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType RuleCallAttribute2_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_Group_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_GroupElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_CallMe2ParserRuleCall_0_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_CallMe2ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_Alternatives_1_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_Alternatives_1ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_Group_1_0_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_Group_1_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_RefKeyword_1_0_0_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_RefKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_TypeRefAssignment_1_0_1_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_TypeRefAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_TypeAssignment_1_1_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_TypeAssignment_1_1ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_TypeIDTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute2_SemicolonKeyword_2_ELEMENT_TYPE = associate(RuleCallAttribute2Factory.createRuleCallAttribute2_SemicolonKeyword_2ElementType());

	private static class CallMe2Factory {
		public static IGrammarAwareElementType createCallMe2ElementType() {
			return new IGrammarAwareElementType("CallMe2_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe2Rule());
		}
		public static IGrammarAwareElementType createCallMe2_NameAssignmentElementType() {
			return new IGrammarAwareElementType("CallMe2_NameAssignment_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe2Access().getNameAssignment());
		}
		public static IGrammarAwareElementType createCallMe2_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("CallMe2_NameIDTerminalRuleCall_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe2Access().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType CallMe2_ELEMENT_TYPE = associate(CallMe2Factory.createCallMe2ElementType());

	public static final IGrammarAwareElementType CallMe2_NameAssignment_ELEMENT_TYPE = associate(CallMe2Factory.createCallMe2_NameAssignmentElementType());

	public static final IGrammarAwareElementType CallMe2_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(CallMe2Factory.createCallMe2_NameIDTerminalRuleCall_0ElementType());

	private static class RuleCallAttribute3Factory {
		public static IGrammarAwareElementType createRuleCallAttribute3ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Rule());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_GroupElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_Group_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getGroup());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_CallMe3ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_CallMe3ParserRuleCall_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getCallMe3ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_Alternatives_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_Group_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_Group_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_RefKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_RefKeyword_1_0_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getRefKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_TypeRefAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_TypeRefAssignment_1_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getTypeRefAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getTypeRefBaseAttributeCrossReference_1_0_1_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getTypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_TypeAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_TypeAssignment_1_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getTypeAssignment_1_1());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_TypeIDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getTypeIDTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createRuleCallAttribute3_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("RuleCallAttribute3_SemicolonKeyword_2_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRuleCallAttribute3Access().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType RuleCallAttribute3_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_Group_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_GroupElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_CallMe3ParserRuleCall_0_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_CallMe3ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_Alternatives_1_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_Alternatives_1ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_Group_1_0_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_Group_1_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_RefKeyword_1_0_0_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_RefKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_TypeRefAssignment_1_0_1_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_TypeRefAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_TypeAssignment_1_1_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_TypeAssignment_1_1ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_TypeIDTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType RuleCallAttribute3_SemicolonKeyword_2_ELEMENT_TYPE = associate(RuleCallAttribute3Factory.createRuleCallAttribute3_SemicolonKeyword_2ElementType());

	private static class CallMe3Factory {
		public static IGrammarAwareElementType createCallMe3ElementType() {
			return new IGrammarAwareElementType("CallMe3_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe3Rule());
		}
		public static IGrammarAwareElementType createCallMe3_GroupElementType() {
			return new IGrammarAwareElementType("CallMe3_Group_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe3Access().getGroup());
		}
		public static IGrammarAwareElementType createCallMe3_CallKeyword_0ElementType() {
			return new IGrammarAwareElementType("CallMe3_CallKeyword_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe3Access().getCallKeyword_0());
		}
		public static IGrammarAwareElementType createCallMe3_MeKeyword_1ElementType() {
			return new IGrammarAwareElementType("CallMe3_MeKeyword_1_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe3Access().getMeKeyword_1());
		}
		public static IGrammarAwareElementType createCallMe3_CallMe4ParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("CallMe3_CallMe4ParserRuleCall_2_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe3Access().getCallMe4ParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType CallMe3_ELEMENT_TYPE = associate(CallMe3Factory.createCallMe3ElementType());

	public static final IGrammarAwareElementType CallMe3_Group_ELEMENT_TYPE = associate(CallMe3Factory.createCallMe3_GroupElementType());

	public static final IGrammarAwareElementType CallMe3_CallKeyword_0_ELEMENT_TYPE = associate(CallMe3Factory.createCallMe3_CallKeyword_0ElementType());

	public static final IGrammarAwareElementType CallMe3_MeKeyword_1_ELEMENT_TYPE = associate(CallMe3Factory.createCallMe3_MeKeyword_1ElementType());

	public static final IGrammarAwareElementType CallMe3_CallMe4ParserRuleCall_2_ELEMENT_TYPE = associate(CallMe3Factory.createCallMe3_CallMe4ParserRuleCall_2ElementType());

	private static class CallMe4Factory {
		public static IGrammarAwareElementType createCallMe4ElementType() {
			return new IGrammarAwareElementType("CallMe4_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe4Rule());
		}
		public static IGrammarAwareElementType createCallMe4_NameAssignmentElementType() {
			return new IGrammarAwareElementType("CallMe4_NameAssignment_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe4Access().getNameAssignment());
		}
		public static IGrammarAwareElementType createCallMe4_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("CallMe4_NameIDTerminalRuleCall_0_ELEMENT_TYPE", Bug287988TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallMe4Access().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType CallMe4_ELEMENT_TYPE = associate(CallMe4Factory.createCallMe4ElementType());

	public static final IGrammarAwareElementType CallMe4_NameAssignment_ELEMENT_TYPE = associate(CallMe4Factory.createCallMe4_NameAssignmentElementType());

	public static final IGrammarAwareElementType CallMe4_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(CallMe4Factory.createCallMe4_NameIDTerminalRuleCall_0ElementType());

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

	public IGrammarAwareElementType getModel_ActionsKeyword_0_0ElementType() {
		return Model_ActionsKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesAssignment_0_1ElementType() {
		return Model_AttributesAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesBaseAttributeParserRuleCall_0_1_0ElementType() {
		return Model_AttributesBaseAttributeParserRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SimpleKeyword_1_0ElementType() {
		return Model_SimpleKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesAssignment_1_1ElementType() {
		return Model_AttributesAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesSimpleAttributeParserRuleCall_1_1_0ElementType() {
		return Model_AttributesSimpleAttributeParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_2ElementType() {
		return Model_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_RulecallKeyword_2_0ElementType() {
		return Model_RulecallKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesAssignment_2_1ElementType() {
		return Model_AttributesAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesRuleCallAttributeParserRuleCall_2_1_0ElementType() {
		return Model_AttributesRuleCallAttributeParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_3ElementType() {
		return Model_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Rulecall2Keyword_3_0ElementType() {
		return Model_Rulecall2Keyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesAssignment_3_1ElementType() {
		return Model_AttributesAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesRuleCallAttribute2ParserRuleCall_3_1_0ElementType() {
		return Model_AttributesRuleCallAttribute2ParserRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_4ElementType() {
		return Model_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Rulecall3Keyword_4_0ElementType() {
		return Model_Rulecall3Keyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesAssignment_4_1ElementType() {
		return Model_AttributesAssignment_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesRuleCallAttribute3ParserRuleCall_4_1_0ElementType() {
		return Model_AttributesRuleCallAttribute3ParserRuleCall_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_5ElementType() {
		return Model_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_InlinedActionsKeyword_5_0ElementType() {
		return Model_InlinedActionsKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesAssignment_5_1ElementType() {
		return Model_AttributesAssignment_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AttributesActionAttributeParserRuleCall_5_1_0ElementType() {
		return Model_AttributesActionAttributeParserRuleCall_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttributeElementType() {
		return BaseAttribute_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_GroupElementType() {
		return BaseAttribute_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_Alternatives_0ElementType() {
		return BaseAttribute_Alternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_AttributeParserRuleCall_0_0ElementType() {
		return BaseAttribute_AttributeParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_MasterParserRuleCall_0_1ElementType() {
		return BaseAttribute_MasterParserRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_Alternatives_1ElementType() {
		return BaseAttribute_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_Group_1_0ElementType() {
		return BaseAttribute_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_RefKeyword_1_0_0ElementType() {
		return BaseAttribute_RefKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_TypeRefAssignment_1_0_1ElementType() {
		return BaseAttribute_TypeRefAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType() {
		return BaseAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType() {
		return BaseAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_TypeAssignment_1_1ElementType() {
		return BaseAttribute_TypeAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_TypeIDTerminalRuleCall_1_1_0ElementType() {
		return BaseAttribute_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_NameAssignment_2ElementType() {
		return BaseAttribute_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_NameIDTerminalRuleCall_2_0ElementType() {
		return BaseAttribute_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaseAttribute_SemicolonKeyword_3ElementType() {
		return BaseAttribute_SemicolonKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttributeElementType() {
		return Attribute_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttribute_GroupElementType() {
		return Attribute_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttribute_AttributeAction_0ElementType() {
		return Attribute_AttributeAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAttribute_AttributeKeyword_1ElementType() {
		return Attribute_AttributeKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMasterElementType() {
		return Master_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMaster_GroupElementType() {
		return Master_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMaster_MasterAction_0ElementType() {
		return Master_MasterAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMaster_MasterKeyword_1ElementType() {
		return Master_MasterKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttributeElementType() {
		return ActionAttribute_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_GroupElementType() {
		return ActionAttribute_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_Alternatives_0ElementType() {
		return ActionAttribute_Alternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_Group_0_0ElementType() {
		return ActionAttribute_Group_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_AttributeAction_0_0_0ElementType() {
		return ActionAttribute_AttributeAction_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_AttributeKeyword_0_0_1ElementType() {
		return ActionAttribute_AttributeKeyword_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_Group_0_1ElementType() {
		return ActionAttribute_Group_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_MasterAction_0_1_0ElementType() {
		return ActionAttribute_MasterAction_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_MasterKeyword_0_1_1ElementType() {
		return ActionAttribute_MasterKeyword_0_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_Alternatives_1ElementType() {
		return ActionAttribute_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_Group_1_0ElementType() {
		return ActionAttribute_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_RefKeyword_1_0_0ElementType() {
		return ActionAttribute_RefKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_TypeRefAssignment_1_0_1ElementType() {
		return ActionAttribute_TypeRefAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType() {
		return ActionAttribute_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType() {
		return ActionAttribute_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_TypeAssignment_1_1ElementType() {
		return ActionAttribute_TypeAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_TypeIDTerminalRuleCall_1_1_0ElementType() {
		return ActionAttribute_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_NameAssignment_2ElementType() {
		return ActionAttribute_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_NameIDTerminalRuleCall_2_0ElementType() {
		return ActionAttribute_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getActionAttribute_SemicolonKeyword_3ElementType() {
		return ActionAttribute_SemicolonKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttributeElementType() {
		return SimpleAttribute_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_GroupElementType() {
		return SimpleAttribute_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_Alternatives_0ElementType() {
		return SimpleAttribute_Alternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_Group_0_0ElementType() {
		return SimpleAttribute_Group_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_RefKeyword_0_0_0ElementType() {
		return SimpleAttribute_RefKeyword_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_TypeRefAssignment_0_0_1ElementType() {
		return SimpleAttribute_TypeRefAssignment_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_TypeRefBaseAttributeCrossReference_0_0_1_0ElementType() {
		return SimpleAttribute_TypeRefBaseAttributeCrossReference_0_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_TypeRefBaseAttributeIDTerminalRuleCall_0_0_1_0_1ElementType() {
		return SimpleAttribute_TypeRefBaseAttributeIDTerminalRuleCall_0_0_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_TypeAssignment_0_1ElementType() {
		return SimpleAttribute_TypeAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_TypeIDTerminalRuleCall_0_1_0ElementType() {
		return SimpleAttribute_TypeIDTerminalRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_NameAssignment_1ElementType() {
		return SimpleAttribute_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_NameIDTerminalRuleCall_1_0ElementType() {
		return SimpleAttribute_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleAttribute_SemicolonKeyword_2ElementType() {
		return SimpleAttribute_SemicolonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttributeElementType() {
		return RuleCallAttribute_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute_GroupElementType() {
		return RuleCallAttribute_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute_CallMeParserRuleCall_0ElementType() {
		return RuleCallAttribute_CallMeParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute_NameAssignment_1ElementType() {
		return RuleCallAttribute_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute_NameIDTerminalRuleCall_1_0ElementType() {
		return RuleCallAttribute_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute_SemicolonKeyword_2ElementType() {
		return RuleCallAttribute_SemicolonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMeElementType() {
		return CallMe_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe_AlternativesElementType() {
		return CallMe_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe_Group_0ElementType() {
		return CallMe_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe_RefKeyword_0_0ElementType() {
		return CallMe_RefKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe_TypeRefAssignment_0_1ElementType() {
		return CallMe_TypeRefAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe_TypeRefBaseAttributeCrossReference_0_1_0ElementType() {
		return CallMe_TypeRefBaseAttributeCrossReference_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe_TypeRefBaseAttributeIDTerminalRuleCall_0_1_0_1ElementType() {
		return CallMe_TypeRefBaseAttributeIDTerminalRuleCall_0_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe_TypeAssignment_1ElementType() {
		return CallMe_TypeAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe_TypeIDTerminalRuleCall_1_0ElementType() {
		return CallMe_TypeIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2ElementType() {
		return RuleCallAttribute2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_GroupElementType() {
		return RuleCallAttribute2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_CallMe2ParserRuleCall_0ElementType() {
		return RuleCallAttribute2_CallMe2ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_Alternatives_1ElementType() {
		return RuleCallAttribute2_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_Group_1_0ElementType() {
		return RuleCallAttribute2_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_RefKeyword_1_0_0ElementType() {
		return RuleCallAttribute2_RefKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_TypeRefAssignment_1_0_1ElementType() {
		return RuleCallAttribute2_TypeRefAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType() {
		return RuleCallAttribute2_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType() {
		return RuleCallAttribute2_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_TypeAssignment_1_1ElementType() {
		return RuleCallAttribute2_TypeAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_TypeIDTerminalRuleCall_1_1_0ElementType() {
		return RuleCallAttribute2_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute2_SemicolonKeyword_2ElementType() {
		return RuleCallAttribute2_SemicolonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe2ElementType() {
		return CallMe2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe2_NameAssignmentElementType() {
		return CallMe2_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe2_NameIDTerminalRuleCall_0ElementType() {
		return CallMe2_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3ElementType() {
		return RuleCallAttribute3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_GroupElementType() {
		return RuleCallAttribute3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_CallMe3ParserRuleCall_0ElementType() {
		return RuleCallAttribute3_CallMe3ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_Alternatives_1ElementType() {
		return RuleCallAttribute3_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_Group_1_0ElementType() {
		return RuleCallAttribute3_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_RefKeyword_1_0_0ElementType() {
		return RuleCallAttribute3_RefKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_TypeRefAssignment_1_0_1ElementType() {
		return RuleCallAttribute3_TypeRefAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_TypeRefBaseAttributeCrossReference_1_0_1_0ElementType() {
		return RuleCallAttribute3_TypeRefBaseAttributeCrossReference_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1ElementType() {
		return RuleCallAttribute3_TypeRefBaseAttributeIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_TypeAssignment_1_1ElementType() {
		return RuleCallAttribute3_TypeAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_TypeIDTerminalRuleCall_1_1_0ElementType() {
		return RuleCallAttribute3_TypeIDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRuleCallAttribute3_SemicolonKeyword_2ElementType() {
		return RuleCallAttribute3_SemicolonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe3ElementType() {
		return CallMe3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe3_GroupElementType() {
		return CallMe3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe3_CallKeyword_0ElementType() {
		return CallMe3_CallKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe3_MeKeyword_1ElementType() {
		return CallMe3_MeKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe3_CallMe4ParserRuleCall_2ElementType() {
		return CallMe3_CallMe4ParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe4ElementType() {
		return CallMe4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe4_NameAssignmentElementType() {
		return CallMe4_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallMe4_NameIDTerminalRuleCall_0ElementType() {
		return CallMe4_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
