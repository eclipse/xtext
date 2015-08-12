package org.eclipse.xtext.parser.terminalrules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.HiddenTerminalsTestLanguageFileImpl;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class HiddenTerminalsTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<HiddenTerminalsTestLanguageFileImpl>>(HiddenTerminalsTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final HiddenTerminalsTestLanguageGrammarAccess GRAMMAR_ACCESS = HiddenTerminalsTestLanguageLanguage.INSTANCE.getInstance(HiddenTerminalsTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_WithoutHiddensParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_WithoutHiddensParserRuleCall_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getWithoutHiddensParserRuleCall_0());
		}
		public static IGrammarAwareElementType createModel_WithHiddensParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Model_WithHiddensParserRuleCall_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getWithHiddensParserRuleCall_1());
		}
		public static IGrammarAwareElementType createModel_OverridingHiddensParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Model_OverridingHiddensParserRuleCall_2_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getOverridingHiddensParserRuleCall_2());
		}
		public static IGrammarAwareElementType createModel_InheritingHiddensParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Model_InheritingHiddensParserRuleCall_3_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getInheritingHiddensParserRuleCall_3());
		}
		public static IGrammarAwareElementType createModel_DatatypeHiddensParserRuleCall_4ElementType() {
			return new IGrammarAwareElementType("Model_DatatypeHiddensParserRuleCall_4_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDatatypeHiddensParserRuleCall_4());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_WithoutHiddensParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_WithoutHiddensParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Model_WithHiddensParserRuleCall_1_ELEMENT_TYPE = associate(ModelFactory.createModel_WithHiddensParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Model_OverridingHiddensParserRuleCall_2_ELEMENT_TYPE = associate(ModelFactory.createModel_OverridingHiddensParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType Model_InheritingHiddensParserRuleCall_3_ELEMENT_TYPE = associate(ModelFactory.createModel_InheritingHiddensParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType Model_DatatypeHiddensParserRuleCall_4_ELEMENT_TYPE = associate(ModelFactory.createModel_DatatypeHiddensParserRuleCall_4ElementType());

	private static class WithoutHiddensFactory {
		public static IGrammarAwareElementType createWithoutHiddensElementType() {
			return new IGrammarAwareElementType("WithoutHiddens_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithoutHiddensRule());
		}
		public static IGrammarAwareElementType createWithoutHiddens_GroupElementType() {
			return new IGrammarAwareElementType("WithoutHiddens_Group_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithoutHiddensAccess().getGroup());
		}
		public static IGrammarAwareElementType createWithoutHiddens_WithoutKeyword_0ElementType() {
			return new IGrammarAwareElementType("WithoutHiddens_WithoutKeyword_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithoutHiddensAccess().getWithoutKeyword_0());
		}
		public static IGrammarAwareElementType createWithoutHiddens_SpacesAssignment_1ElementType() {
			return new IGrammarAwareElementType("WithoutHiddens_SpacesAssignment_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithoutHiddensAccess().getSpacesAssignment_1());
		}
		public static IGrammarAwareElementType createWithoutHiddens_SpacesWSTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("WithoutHiddens_SpacesWSTerminalRuleCall_1_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithoutHiddensAccess().getSpacesWSTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createWithoutHiddens_HiddensKeyword_2ElementType() {
			return new IGrammarAwareElementType("WithoutHiddens_HiddensKeyword_2_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithoutHiddensAccess().getHiddensKeyword_2());
		}
		public static IGrammarAwareElementType createWithoutHiddens_SpacesAssignment_3ElementType() {
			return new IGrammarAwareElementType("WithoutHiddens_SpacesAssignment_3_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithoutHiddensAccess().getSpacesAssignment_3());
		}
		public static IGrammarAwareElementType createWithoutHiddens_SpacesWSTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("WithoutHiddens_SpacesWSTerminalRuleCall_3_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithoutHiddensAccess().getSpacesWSTerminalRuleCall_3_0());
		}
		public static IGrammarAwareElementType createWithoutHiddens_ValidAssignment_4ElementType() {
			return new IGrammarAwareElementType("WithoutHiddens_ValidAssignment_4_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithoutHiddensAccess().getValidAssignment_4());
		}
		public static IGrammarAwareElementType createWithoutHiddens_ValidSemicolonKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("WithoutHiddens_ValidSemicolonKeyword_4_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithoutHiddensAccess().getValidSemicolonKeyword_4_0());
		}
	}

	public static final IGrammarAwareElementType WithoutHiddens_ELEMENT_TYPE = associate(WithoutHiddensFactory.createWithoutHiddensElementType());

	public static final IGrammarAwareElementType WithoutHiddens_Group_ELEMENT_TYPE = associate(WithoutHiddensFactory.createWithoutHiddens_GroupElementType());

	public static final IGrammarAwareElementType WithoutHiddens_WithoutKeyword_0_ELEMENT_TYPE = associate(WithoutHiddensFactory.createWithoutHiddens_WithoutKeyword_0ElementType());

	public static final IGrammarAwareElementType WithoutHiddens_SpacesAssignment_1_ELEMENT_TYPE = associate(WithoutHiddensFactory.createWithoutHiddens_SpacesAssignment_1ElementType());

	public static final IGrammarAwareElementType WithoutHiddens_SpacesWSTerminalRuleCall_1_0_ELEMENT_TYPE = associate(WithoutHiddensFactory.createWithoutHiddens_SpacesWSTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType WithoutHiddens_HiddensKeyword_2_ELEMENT_TYPE = associate(WithoutHiddensFactory.createWithoutHiddens_HiddensKeyword_2ElementType());

	public static final IGrammarAwareElementType WithoutHiddens_SpacesAssignment_3_ELEMENT_TYPE = associate(WithoutHiddensFactory.createWithoutHiddens_SpacesAssignment_3ElementType());

	public static final IGrammarAwareElementType WithoutHiddens_SpacesWSTerminalRuleCall_3_0_ELEMENT_TYPE = associate(WithoutHiddensFactory.createWithoutHiddens_SpacesWSTerminalRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType WithoutHiddens_ValidAssignment_4_ELEMENT_TYPE = associate(WithoutHiddensFactory.createWithoutHiddens_ValidAssignment_4ElementType());

	public static final IGrammarAwareElementType WithoutHiddens_ValidSemicolonKeyword_4_0_ELEMENT_TYPE = associate(WithoutHiddensFactory.createWithoutHiddens_ValidSemicolonKeyword_4_0ElementType());

	private static class WithHiddensFactory {
		public static IGrammarAwareElementType createWithHiddensElementType() {
			return new IGrammarAwareElementType("WithHiddens_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithHiddensRule());
		}
		public static IGrammarAwareElementType createWithHiddens_GroupElementType() {
			return new IGrammarAwareElementType("WithHiddens_Group_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithHiddensAccess().getGroup());
		}
		public static IGrammarAwareElementType createWithHiddens_WithKeyword_0ElementType() {
			return new IGrammarAwareElementType("WithHiddens_WithKeyword_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithHiddensAccess().getWithKeyword_0());
		}
		public static IGrammarAwareElementType createWithHiddens_HiddensKeyword_1ElementType() {
			return new IGrammarAwareElementType("WithHiddens_HiddensKeyword_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithHiddensAccess().getHiddensKeyword_1());
		}
		public static IGrammarAwareElementType createWithHiddens_ValidAssignment_2ElementType() {
			return new IGrammarAwareElementType("WithHiddens_ValidAssignment_2_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithHiddensAccess().getValidAssignment_2());
		}
		public static IGrammarAwareElementType createWithHiddens_ValidSemicolonKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("WithHiddens_ValidSemicolonKeyword_2_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWithHiddensAccess().getValidSemicolonKeyword_2_0());
		}
	}

	public static final IGrammarAwareElementType WithHiddens_ELEMENT_TYPE = associate(WithHiddensFactory.createWithHiddensElementType());

	public static final IGrammarAwareElementType WithHiddens_Group_ELEMENT_TYPE = associate(WithHiddensFactory.createWithHiddens_GroupElementType());

	public static final IGrammarAwareElementType WithHiddens_WithKeyword_0_ELEMENT_TYPE = associate(WithHiddensFactory.createWithHiddens_WithKeyword_0ElementType());

	public static final IGrammarAwareElementType WithHiddens_HiddensKeyword_1_ELEMENT_TYPE = associate(WithHiddensFactory.createWithHiddens_HiddensKeyword_1ElementType());

	public static final IGrammarAwareElementType WithHiddens_ValidAssignment_2_ELEMENT_TYPE = associate(WithHiddensFactory.createWithHiddens_ValidAssignment_2ElementType());

	public static final IGrammarAwareElementType WithHiddens_ValidSemicolonKeyword_2_0_ELEMENT_TYPE = associate(WithHiddensFactory.createWithHiddens_ValidSemicolonKeyword_2_0ElementType());

	private static class OverridingHiddensFactory {
		public static IGrammarAwareElementType createOverridingHiddensElementType() {
			return new IGrammarAwareElementType("OverridingHiddens_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensRule());
		}
		public static IGrammarAwareElementType createOverridingHiddens_GroupElementType() {
			return new IGrammarAwareElementType("OverridingHiddens_Group_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensAccess().getGroup());
		}
		public static IGrammarAwareElementType createOverridingHiddens_OverridingKeyword_0ElementType() {
			return new IGrammarAwareElementType("OverridingHiddens_OverridingKeyword_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensAccess().getOverridingKeyword_0());
		}
		public static IGrammarAwareElementType createOverridingHiddens_HiddensKeyword_1ElementType() {
			return new IGrammarAwareElementType("OverridingHiddens_HiddensKeyword_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensAccess().getHiddensKeyword_1());
		}
		public static IGrammarAwareElementType createOverridingHiddens_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("OverridingHiddens_LeftParenthesisKeyword_2_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createOverridingHiddens_CalledAssignment_3ElementType() {
			return new IGrammarAwareElementType("OverridingHiddens_CalledAssignment_3_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensAccess().getCalledAssignment_3());
		}
		public static IGrammarAwareElementType createOverridingHiddens_CalledOverridingHiddensCallParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("OverridingHiddens_CalledOverridingHiddensCallParserRuleCall_3_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensAccess().getCalledOverridingHiddensCallParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createOverridingHiddens_RightParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("OverridingHiddens_RightParenthesisKeyword_4_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensAccess().getRightParenthesisKeyword_4());
		}
		public static IGrammarAwareElementType createOverridingHiddens_ValidAssignment_5ElementType() {
			return new IGrammarAwareElementType("OverridingHiddens_ValidAssignment_5_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensAccess().getValidAssignment_5());
		}
		public static IGrammarAwareElementType createOverridingHiddens_ValidSemicolonKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("OverridingHiddens_ValidSemicolonKeyword_5_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensAccess().getValidSemicolonKeyword_5_0());
		}
	}

	public static final IGrammarAwareElementType OverridingHiddens_ELEMENT_TYPE = associate(OverridingHiddensFactory.createOverridingHiddensElementType());

	public static final IGrammarAwareElementType OverridingHiddens_Group_ELEMENT_TYPE = associate(OverridingHiddensFactory.createOverridingHiddens_GroupElementType());

	public static final IGrammarAwareElementType OverridingHiddens_OverridingKeyword_0_ELEMENT_TYPE = associate(OverridingHiddensFactory.createOverridingHiddens_OverridingKeyword_0ElementType());

	public static final IGrammarAwareElementType OverridingHiddens_HiddensKeyword_1_ELEMENT_TYPE = associate(OverridingHiddensFactory.createOverridingHiddens_HiddensKeyword_1ElementType());

	public static final IGrammarAwareElementType OverridingHiddens_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(OverridingHiddensFactory.createOverridingHiddens_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType OverridingHiddens_CalledAssignment_3_ELEMENT_TYPE = associate(OverridingHiddensFactory.createOverridingHiddens_CalledAssignment_3ElementType());

	public static final IGrammarAwareElementType OverridingHiddens_CalledOverridingHiddensCallParserRuleCall_3_0_ELEMENT_TYPE = associate(OverridingHiddensFactory.createOverridingHiddens_CalledOverridingHiddensCallParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType OverridingHiddens_RightParenthesisKeyword_4_ELEMENT_TYPE = associate(OverridingHiddensFactory.createOverridingHiddens_RightParenthesisKeyword_4ElementType());

	public static final IGrammarAwareElementType OverridingHiddens_ValidAssignment_5_ELEMENT_TYPE = associate(OverridingHiddensFactory.createOverridingHiddens_ValidAssignment_5ElementType());

	public static final IGrammarAwareElementType OverridingHiddens_ValidSemicolonKeyword_5_0_ELEMENT_TYPE = associate(OverridingHiddensFactory.createOverridingHiddens_ValidSemicolonKeyword_5_0ElementType());

	private static class OverridingHiddensCallFactory {
		public static IGrammarAwareElementType createOverridingHiddensCallElementType() {
			return new IGrammarAwareElementType("OverridingHiddensCall_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensCallRule());
		}
		public static IGrammarAwareElementType createOverridingHiddensCall_GroupElementType() {
			return new IGrammarAwareElementType("OverridingHiddensCall_Group_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensCallAccess().getGroup());
		}
		public static IGrammarAwareElementType createOverridingHiddensCall_CallKeyword_0ElementType() {
			return new IGrammarAwareElementType("OverridingHiddensCall_CallKeyword_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensCallAccess().getCallKeyword_0());
		}
		public static IGrammarAwareElementType createOverridingHiddensCall_SpacesAssignment_1ElementType() {
			return new IGrammarAwareElementType("OverridingHiddensCall_SpacesAssignment_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensCallAccess().getSpacesAssignment_1());
		}
		public static IGrammarAwareElementType createOverridingHiddensCall_SpacesWSTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("OverridingHiddensCall_SpacesWSTerminalRuleCall_1_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensCallAccess().getSpacesWSTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createOverridingHiddensCall_ValidAssignment_2ElementType() {
			return new IGrammarAwareElementType("OverridingHiddensCall_ValidAssignment_2_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensCallAccess().getValidAssignment_2());
		}
		public static IGrammarAwareElementType createOverridingHiddensCall_ValidSemicolonKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("OverridingHiddensCall_ValidSemicolonKeyword_2_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridingHiddensCallAccess().getValidSemicolonKeyword_2_0());
		}
	}

	public static final IGrammarAwareElementType OverridingHiddensCall_ELEMENT_TYPE = associate(OverridingHiddensCallFactory.createOverridingHiddensCallElementType());

	public static final IGrammarAwareElementType OverridingHiddensCall_Group_ELEMENT_TYPE = associate(OverridingHiddensCallFactory.createOverridingHiddensCall_GroupElementType());

	public static final IGrammarAwareElementType OverridingHiddensCall_CallKeyword_0_ELEMENT_TYPE = associate(OverridingHiddensCallFactory.createOverridingHiddensCall_CallKeyword_0ElementType());

	public static final IGrammarAwareElementType OverridingHiddensCall_SpacesAssignment_1_ELEMENT_TYPE = associate(OverridingHiddensCallFactory.createOverridingHiddensCall_SpacesAssignment_1ElementType());

	public static final IGrammarAwareElementType OverridingHiddensCall_SpacesWSTerminalRuleCall_1_0_ELEMENT_TYPE = associate(OverridingHiddensCallFactory.createOverridingHiddensCall_SpacesWSTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType OverridingHiddensCall_ValidAssignment_2_ELEMENT_TYPE = associate(OverridingHiddensCallFactory.createOverridingHiddensCall_ValidAssignment_2ElementType());

	public static final IGrammarAwareElementType OverridingHiddensCall_ValidSemicolonKeyword_2_0_ELEMENT_TYPE = associate(OverridingHiddensCallFactory.createOverridingHiddensCall_ValidSemicolonKeyword_2_0ElementType());

	private static class InheritingHiddensFactory {
		public static IGrammarAwareElementType createInheritingHiddensElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensRule());
		}
		public static IGrammarAwareElementType createInheritingHiddens_GroupElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_Group_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getGroup());
		}
		public static IGrammarAwareElementType createInheritingHiddens_InheritingKeyword_0ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_InheritingKeyword_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getInheritingKeyword_0());
		}
		public static IGrammarAwareElementType createInheritingHiddens_HiddensKeyword_1ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_HiddensKeyword_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getHiddensKeyword_1());
		}
		public static IGrammarAwareElementType createInheritingHiddens_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_LeftParenthesisKeyword_2_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createInheritingHiddens_Alternatives_3ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_Alternatives_3_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getAlternatives_3());
		}
		public static IGrammarAwareElementType createInheritingHiddens_CalledAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_CalledAssignment_3_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getCalledAssignment_3_0());
		}
		public static IGrammarAwareElementType createInheritingHiddens_CalledInheritingHiddensCallParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_CalledInheritingHiddensCallParserRuleCall_3_0_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createInheritingHiddens_HidingCalledAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_HidingCalledAssignment_3_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getHidingCalledAssignment_3_1());
		}
		public static IGrammarAwareElementType createInheritingHiddens_HidingCalledHidingHiddensParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_HidingCalledHidingHiddensParserRuleCall_3_1_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getHidingCalledHidingHiddensParserRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createInheritingHiddens_RightParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_RightParenthesisKeyword_4_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getRightParenthesisKeyword_4());
		}
		public static IGrammarAwareElementType createInheritingHiddens_ValidAssignment_5ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_ValidAssignment_5_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getValidAssignment_5());
		}
		public static IGrammarAwareElementType createInheritingHiddens_ValidSemicolonKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("InheritingHiddens_ValidSemicolonKeyword_5_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensAccess().getValidSemicolonKeyword_5_0());
		}
	}

	public static final IGrammarAwareElementType InheritingHiddens_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddensElementType());

	public static final IGrammarAwareElementType InheritingHiddens_Group_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_GroupElementType());

	public static final IGrammarAwareElementType InheritingHiddens_InheritingKeyword_0_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_InheritingKeyword_0ElementType());

	public static final IGrammarAwareElementType InheritingHiddens_HiddensKeyword_1_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_HiddensKeyword_1ElementType());

	public static final IGrammarAwareElementType InheritingHiddens_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType InheritingHiddens_Alternatives_3_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_Alternatives_3ElementType());

	public static final IGrammarAwareElementType InheritingHiddens_CalledAssignment_3_0_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_CalledAssignment_3_0ElementType());

	public static final IGrammarAwareElementType InheritingHiddens_CalledInheritingHiddensCallParserRuleCall_3_0_0_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_CalledInheritingHiddensCallParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType InheritingHiddens_HidingCalledAssignment_3_1_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_HidingCalledAssignment_3_1ElementType());

	public static final IGrammarAwareElementType InheritingHiddens_HidingCalledHidingHiddensParserRuleCall_3_1_0_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_HidingCalledHidingHiddensParserRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType InheritingHiddens_RightParenthesisKeyword_4_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_RightParenthesisKeyword_4ElementType());

	public static final IGrammarAwareElementType InheritingHiddens_ValidAssignment_5_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_ValidAssignment_5ElementType());

	public static final IGrammarAwareElementType InheritingHiddens_ValidSemicolonKeyword_5_0_ELEMENT_TYPE = associate(InheritingHiddensFactory.createInheritingHiddens_ValidSemicolonKeyword_5_0ElementType());

	private static class DatatypeHiddensFactory {
		public static IGrammarAwareElementType createDatatypeHiddensElementType() {
			return new IGrammarAwareElementType("DatatypeHiddens_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeHiddensRule());
		}
		public static IGrammarAwareElementType createDatatypeHiddens_GroupElementType() {
			return new IGrammarAwareElementType("DatatypeHiddens_Group_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeHiddensAccess().getGroup());
		}
		public static IGrammarAwareElementType createDatatypeHiddens_DatatypeKeyword_0ElementType() {
			return new IGrammarAwareElementType("DatatypeHiddens_DatatypeKeyword_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeHiddensAccess().getDatatypeKeyword_0());
		}
		public static IGrammarAwareElementType createDatatypeHiddens_ValidAssignment_1ElementType() {
			return new IGrammarAwareElementType("DatatypeHiddens_ValidAssignment_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeHiddensAccess().getValidAssignment_1());
		}
		public static IGrammarAwareElementType createDatatypeHiddens_ValidDatatypeRuleParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("DatatypeHiddens_ValidDatatypeRuleParserRuleCall_1_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeHiddensAccess().getValidDatatypeRuleParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType DatatypeHiddens_ELEMENT_TYPE = associate(DatatypeHiddensFactory.createDatatypeHiddensElementType());

	public static final IGrammarAwareElementType DatatypeHiddens_Group_ELEMENT_TYPE = associate(DatatypeHiddensFactory.createDatatypeHiddens_GroupElementType());

	public static final IGrammarAwareElementType DatatypeHiddens_DatatypeKeyword_0_ELEMENT_TYPE = associate(DatatypeHiddensFactory.createDatatypeHiddens_DatatypeKeyword_0ElementType());

	public static final IGrammarAwareElementType DatatypeHiddens_ValidAssignment_1_ELEMENT_TYPE = associate(DatatypeHiddensFactory.createDatatypeHiddens_ValidAssignment_1ElementType());

	public static final IGrammarAwareElementType DatatypeHiddens_ValidDatatypeRuleParserRuleCall_1_0_ELEMENT_TYPE = associate(DatatypeHiddensFactory.createDatatypeHiddens_ValidDatatypeRuleParserRuleCall_1_0ElementType());

	private static class DatatypeRuleFactory {
		public static IGrammarAwareElementType createDatatypeRuleElementType() {
			return new IGrammarAwareElementType("DatatypeRule_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRuleRule());
		}
		public static IGrammarAwareElementType createDatatypeRule_GroupElementType() {
			return new IGrammarAwareElementType("DatatypeRule_Group_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createDatatypeRule_RuleKeyword_0ElementType() {
			return new IGrammarAwareElementType("DatatypeRule_RuleKeyword_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRuleAccess().getRuleKeyword_0());
		}
		public static IGrammarAwareElementType createDatatypeRule_SemicolonKeyword_1ElementType() {
			return new IGrammarAwareElementType("DatatypeRule_SemicolonKeyword_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRuleAccess().getSemicolonKeyword_1());
		}
	}

	public static final IGrammarAwareElementType DatatypeRule_ELEMENT_TYPE = associate(DatatypeRuleFactory.createDatatypeRuleElementType());

	public static final IGrammarAwareElementType DatatypeRule_Group_ELEMENT_TYPE = associate(DatatypeRuleFactory.createDatatypeRule_GroupElementType());

	public static final IGrammarAwareElementType DatatypeRule_RuleKeyword_0_ELEMENT_TYPE = associate(DatatypeRuleFactory.createDatatypeRule_RuleKeyword_0ElementType());

	public static final IGrammarAwareElementType DatatypeRule_SemicolonKeyword_1_ELEMENT_TYPE = associate(DatatypeRuleFactory.createDatatypeRule_SemicolonKeyword_1ElementType());

	private static class HidingHiddensFactory {
		public static IGrammarAwareElementType createHidingHiddensElementType() {
			return new IGrammarAwareElementType("HidingHiddens_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHidingHiddensRule());
		}
		public static IGrammarAwareElementType createHidingHiddens_GroupElementType() {
			return new IGrammarAwareElementType("HidingHiddens_Group_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHidingHiddensAccess().getGroup());
		}
		public static IGrammarAwareElementType createHidingHiddens_HidingKeyword_0ElementType() {
			return new IGrammarAwareElementType("HidingHiddens_HidingKeyword_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHidingHiddensAccess().getHidingKeyword_0());
		}
		public static IGrammarAwareElementType createHidingHiddens_SpaceAssignment_1ElementType() {
			return new IGrammarAwareElementType("HidingHiddens_SpaceAssignment_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHidingHiddensAccess().getSpaceAssignment_1());
		}
		public static IGrammarAwareElementType createHidingHiddens_SpaceWSTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("HidingHiddens_SpaceWSTerminalRuleCall_1_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHidingHiddensAccess().getSpaceWSTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createHidingHiddens_CalledAssignment_2ElementType() {
			return new IGrammarAwareElementType("HidingHiddens_CalledAssignment_2_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHidingHiddensAccess().getCalledAssignment_2());
		}
		public static IGrammarAwareElementType createHidingHiddens_CalledInheritingHiddensCallParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("HidingHiddens_CalledInheritingHiddensCallParserRuleCall_2_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getHidingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType HidingHiddens_ELEMENT_TYPE = associate(HidingHiddensFactory.createHidingHiddensElementType());

	public static final IGrammarAwareElementType HidingHiddens_Group_ELEMENT_TYPE = associate(HidingHiddensFactory.createHidingHiddens_GroupElementType());

	public static final IGrammarAwareElementType HidingHiddens_HidingKeyword_0_ELEMENT_TYPE = associate(HidingHiddensFactory.createHidingHiddens_HidingKeyword_0ElementType());

	public static final IGrammarAwareElementType HidingHiddens_SpaceAssignment_1_ELEMENT_TYPE = associate(HidingHiddensFactory.createHidingHiddens_SpaceAssignment_1ElementType());

	public static final IGrammarAwareElementType HidingHiddens_SpaceWSTerminalRuleCall_1_0_ELEMENT_TYPE = associate(HidingHiddensFactory.createHidingHiddens_SpaceWSTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType HidingHiddens_CalledAssignment_2_ELEMENT_TYPE = associate(HidingHiddensFactory.createHidingHiddens_CalledAssignment_2ElementType());

	public static final IGrammarAwareElementType HidingHiddens_CalledInheritingHiddensCallParserRuleCall_2_0_ELEMENT_TYPE = associate(HidingHiddensFactory.createHidingHiddens_CalledInheritingHiddensCallParserRuleCall_2_0ElementType());

	private static class InheritingHiddensCallFactory {
		public static IGrammarAwareElementType createInheritingHiddensCallElementType() {
			return new IGrammarAwareElementType("InheritingHiddensCall_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensCallRule());
		}
		public static IGrammarAwareElementType createInheritingHiddensCall_GroupElementType() {
			return new IGrammarAwareElementType("InheritingHiddensCall_Group_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensCallAccess().getGroup());
		}
		public static IGrammarAwareElementType createInheritingHiddensCall_CallKeyword_0ElementType() {
			return new IGrammarAwareElementType("InheritingHiddensCall_CallKeyword_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensCallAccess().getCallKeyword_0());
		}
		public static IGrammarAwareElementType createInheritingHiddensCall_ValidAssignment_1ElementType() {
			return new IGrammarAwareElementType("InheritingHiddensCall_ValidAssignment_1_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensCallAccess().getValidAssignment_1());
		}
		public static IGrammarAwareElementType createInheritingHiddensCall_ValidSemicolonKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("InheritingHiddensCall_ValidSemicolonKeyword_1_0_ELEMENT_TYPE", HiddenTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritingHiddensCallAccess().getValidSemicolonKeyword_1_0());
		}
	}

	public static final IGrammarAwareElementType InheritingHiddensCall_ELEMENT_TYPE = associate(InheritingHiddensCallFactory.createInheritingHiddensCallElementType());

	public static final IGrammarAwareElementType InheritingHiddensCall_Group_ELEMENT_TYPE = associate(InheritingHiddensCallFactory.createInheritingHiddensCall_GroupElementType());

	public static final IGrammarAwareElementType InheritingHiddensCall_CallKeyword_0_ELEMENT_TYPE = associate(InheritingHiddensCallFactory.createInheritingHiddensCall_CallKeyword_0ElementType());

	public static final IGrammarAwareElementType InheritingHiddensCall_ValidAssignment_1_ELEMENT_TYPE = associate(InheritingHiddensCallFactory.createInheritingHiddensCall_ValidAssignment_1ElementType());

	public static final IGrammarAwareElementType InheritingHiddensCall_ValidSemicolonKeyword_1_0_ELEMENT_TYPE = associate(InheritingHiddensCallFactory.createInheritingHiddensCall_ValidSemicolonKeyword_1_0ElementType());

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

	public IGrammarAwareElementType getModel_WithoutHiddensParserRuleCall_0ElementType() {
		return Model_WithoutHiddensParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_WithHiddensParserRuleCall_1ElementType() {
		return Model_WithHiddensParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_OverridingHiddensParserRuleCall_2ElementType() {
		return Model_OverridingHiddensParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_InheritingHiddensParserRuleCall_3ElementType() {
		return Model_InheritingHiddensParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DatatypeHiddensParserRuleCall_4ElementType() {
		return Model_DatatypeHiddensParserRuleCall_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithoutHiddensElementType() {
		return WithoutHiddens_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithoutHiddens_GroupElementType() {
		return WithoutHiddens_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithoutHiddens_WithoutKeyword_0ElementType() {
		return WithoutHiddens_WithoutKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithoutHiddens_SpacesAssignment_1ElementType() {
		return WithoutHiddens_SpacesAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithoutHiddens_SpacesWSTerminalRuleCall_1_0ElementType() {
		return WithoutHiddens_SpacesWSTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithoutHiddens_HiddensKeyword_2ElementType() {
		return WithoutHiddens_HiddensKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithoutHiddens_SpacesAssignment_3ElementType() {
		return WithoutHiddens_SpacesAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithoutHiddens_SpacesWSTerminalRuleCall_3_0ElementType() {
		return WithoutHiddens_SpacesWSTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithoutHiddens_ValidAssignment_4ElementType() {
		return WithoutHiddens_ValidAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithoutHiddens_ValidSemicolonKeyword_4_0ElementType() {
		return WithoutHiddens_ValidSemicolonKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithHiddensElementType() {
		return WithHiddens_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithHiddens_GroupElementType() {
		return WithHiddens_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithHiddens_WithKeyword_0ElementType() {
		return WithHiddens_WithKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithHiddens_HiddensKeyword_1ElementType() {
		return WithHiddens_HiddensKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithHiddens_ValidAssignment_2ElementType() {
		return WithHiddens_ValidAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWithHiddens_ValidSemicolonKeyword_2_0ElementType() {
		return WithHiddens_ValidSemicolonKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddensElementType() {
		return OverridingHiddens_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddens_GroupElementType() {
		return OverridingHiddens_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddens_OverridingKeyword_0ElementType() {
		return OverridingHiddens_OverridingKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddens_HiddensKeyword_1ElementType() {
		return OverridingHiddens_HiddensKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddens_LeftParenthesisKeyword_2ElementType() {
		return OverridingHiddens_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddens_CalledAssignment_3ElementType() {
		return OverridingHiddens_CalledAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddens_CalledOverridingHiddensCallParserRuleCall_3_0ElementType() {
		return OverridingHiddens_CalledOverridingHiddensCallParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddens_RightParenthesisKeyword_4ElementType() {
		return OverridingHiddens_RightParenthesisKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddens_ValidAssignment_5ElementType() {
		return OverridingHiddens_ValidAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddens_ValidSemicolonKeyword_5_0ElementType() {
		return OverridingHiddens_ValidSemicolonKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddensCallElementType() {
		return OverridingHiddensCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddensCall_GroupElementType() {
		return OverridingHiddensCall_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddensCall_CallKeyword_0ElementType() {
		return OverridingHiddensCall_CallKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddensCall_SpacesAssignment_1ElementType() {
		return OverridingHiddensCall_SpacesAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddensCall_SpacesWSTerminalRuleCall_1_0ElementType() {
		return OverridingHiddensCall_SpacesWSTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddensCall_ValidAssignment_2ElementType() {
		return OverridingHiddensCall_ValidAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridingHiddensCall_ValidSemicolonKeyword_2_0ElementType() {
		return OverridingHiddensCall_ValidSemicolonKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddensElementType() {
		return InheritingHiddens_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_GroupElementType() {
		return InheritingHiddens_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_InheritingKeyword_0ElementType() {
		return InheritingHiddens_InheritingKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_HiddensKeyword_1ElementType() {
		return InheritingHiddens_HiddensKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_LeftParenthesisKeyword_2ElementType() {
		return InheritingHiddens_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_Alternatives_3ElementType() {
		return InheritingHiddens_Alternatives_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_CalledAssignment_3_0ElementType() {
		return InheritingHiddens_CalledAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_CalledInheritingHiddensCallParserRuleCall_3_0_0ElementType() {
		return InheritingHiddens_CalledInheritingHiddensCallParserRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_HidingCalledAssignment_3_1ElementType() {
		return InheritingHiddens_HidingCalledAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_HidingCalledHidingHiddensParserRuleCall_3_1_0ElementType() {
		return InheritingHiddens_HidingCalledHidingHiddensParserRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_RightParenthesisKeyword_4ElementType() {
		return InheritingHiddens_RightParenthesisKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_ValidAssignment_5ElementType() {
		return InheritingHiddens_ValidAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddens_ValidSemicolonKeyword_5_0ElementType() {
		return InheritingHiddens_ValidSemicolonKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeHiddensElementType() {
		return DatatypeHiddens_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeHiddens_GroupElementType() {
		return DatatypeHiddens_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeHiddens_DatatypeKeyword_0ElementType() {
		return DatatypeHiddens_DatatypeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeHiddens_ValidAssignment_1ElementType() {
		return DatatypeHiddens_ValidAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeHiddens_ValidDatatypeRuleParserRuleCall_1_0ElementType() {
		return DatatypeHiddens_ValidDatatypeRuleParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeRuleElementType() {
		return DatatypeRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeRule_GroupElementType() {
		return DatatypeRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeRule_RuleKeyword_0ElementType() {
		return DatatypeRule_RuleKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeRule_SemicolonKeyword_1ElementType() {
		return DatatypeRule_SemicolonKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHidingHiddensElementType() {
		return HidingHiddens_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHidingHiddens_GroupElementType() {
		return HidingHiddens_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHidingHiddens_HidingKeyword_0ElementType() {
		return HidingHiddens_HidingKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHidingHiddens_SpaceAssignment_1ElementType() {
		return HidingHiddens_SpaceAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHidingHiddens_SpaceWSTerminalRuleCall_1_0ElementType() {
		return HidingHiddens_SpaceWSTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHidingHiddens_CalledAssignment_2ElementType() {
		return HidingHiddens_CalledAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getHidingHiddens_CalledInheritingHiddensCallParserRuleCall_2_0ElementType() {
		return HidingHiddens_CalledInheritingHiddensCallParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddensCallElementType() {
		return InheritingHiddensCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddensCall_GroupElementType() {
		return InheritingHiddensCall_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddensCall_CallKeyword_0ElementType() {
		return InheritingHiddensCall_CallKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddensCall_ValidAssignment_1ElementType() {
		return InheritingHiddensCall_ValidAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritingHiddensCall_ValidSemicolonKeyword_1_0ElementType() {
		return InheritingHiddensCall_ValidSemicolonKeyword_1_0_ELEMENT_TYPE;
	}

}
