package org.eclipse.xtext.grammarinheritance.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl.ConcreteTestLanguageFileImpl;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class ConcreteTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<ConcreteTestLanguageFileImpl>>(ConcreteTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final ConcreteTestLanguageGrammarAccess GRAMMAR_ACCESS = ConcreteTestLanguageLanguage.INSTANCE.getInstance(ConcreteTestLanguageGrammarAccess.class);

	private static class RootRuleFactory {
		public static IGrammarAwareElementType createRootRuleElementType() {
			return new IGrammarAwareElementType("RootRule_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRuleRule());
		}
		public static IGrammarAwareElementType createRootRule_AlternativesElementType() {
			return new IGrammarAwareElementType("RootRule_Alternatives_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRuleAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createRootRule_ConcreteParserRuleParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("RootRule_ConcreteParserRuleParserRuleCall_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRuleAccess().getConcreteParserRuleParserRuleCall_0());
		}
		public static IGrammarAwareElementType createRootRule_CallOverridenParserRuleParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("RootRule_CallOverridenParserRuleParserRuleCall_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRuleAccess().getCallOverridenParserRuleParserRuleCall_1());
		}
		public static IGrammarAwareElementType createRootRule_CallExtendedParserRuleParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("RootRule_CallExtendedParserRuleParserRuleCall_2_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRuleAccess().getCallExtendedParserRuleParserRuleCall_2());
		}
		public static IGrammarAwareElementType createRootRule_OverridableParserRule2ParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("RootRule_OverridableParserRule2ParserRuleCall_3_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRuleAccess().getOverridableParserRule2ParserRuleCall_3());
		}
	}

	public static final IGrammarAwareElementType RootRule_ELEMENT_TYPE = associate(RootRuleFactory.createRootRuleElementType());

	public static final IGrammarAwareElementType RootRule_Alternatives_ELEMENT_TYPE = associate(RootRuleFactory.createRootRule_AlternativesElementType());

	public static final IGrammarAwareElementType RootRule_ConcreteParserRuleParserRuleCall_0_ELEMENT_TYPE = associate(RootRuleFactory.createRootRule_ConcreteParserRuleParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType RootRule_CallOverridenParserRuleParserRuleCall_1_ELEMENT_TYPE = associate(RootRuleFactory.createRootRule_CallOverridenParserRuleParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType RootRule_CallExtendedParserRuleParserRuleCall_2_ELEMENT_TYPE = associate(RootRuleFactory.createRootRule_CallExtendedParserRuleParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType RootRule_OverridableParserRule2ParserRuleCall_3_ELEMENT_TYPE = associate(RootRuleFactory.createRootRule_OverridableParserRule2ParserRuleCall_3ElementType());

	private static class ConcreteParserRuleFactory {
		public static IGrammarAwareElementType createConcreteParserRuleElementType() {
			return new IGrammarAwareElementType("ConcreteParserRule_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteParserRuleRule());
		}
		public static IGrammarAwareElementType createConcreteParserRule_GroupElementType() {
			return new IGrammarAwareElementType("ConcreteParserRule_Group_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createConcreteParserRule_ModelKeyword_0ElementType() {
			return new IGrammarAwareElementType("ConcreteParserRule_ModelKeyword_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteParserRuleAccess().getModelKeyword_0());
		}
		public static IGrammarAwareElementType createConcreteParserRule_MagicNumberAssignment_1ElementType() {
			return new IGrammarAwareElementType("ConcreteParserRule_MagicNumberAssignment_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteParserRuleAccess().getMagicNumberAssignment_1());
		}
		public static IGrammarAwareElementType createConcreteParserRule_MagicNumberREALTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ConcreteParserRule_MagicNumberREALTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteParserRuleAccess().getMagicNumberREALTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createConcreteParserRule_ColonKeyword_2ElementType() {
			return new IGrammarAwareElementType("ConcreteParserRule_ColonKeyword_2_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteParserRuleAccess().getColonKeyword_2());
		}
		public static IGrammarAwareElementType createConcreteParserRule_ElementsAssignment_3ElementType() {
			return new IGrammarAwareElementType("ConcreteParserRule_ElementsAssignment_3_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteParserRuleAccess().getElementsAssignment_3());
		}
		public static IGrammarAwareElementType createConcreteParserRule_ElementsInheritedParserRuleParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("ConcreteParserRule_ElementsInheritedParserRuleParserRuleCall_3_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteParserRuleAccess().getElementsInheritedParserRuleParserRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType ConcreteParserRule_ELEMENT_TYPE = associate(ConcreteParserRuleFactory.createConcreteParserRuleElementType());

	public static final IGrammarAwareElementType ConcreteParserRule_Group_ELEMENT_TYPE = associate(ConcreteParserRuleFactory.createConcreteParserRule_GroupElementType());

	public static final IGrammarAwareElementType ConcreteParserRule_ModelKeyword_0_ELEMENT_TYPE = associate(ConcreteParserRuleFactory.createConcreteParserRule_ModelKeyword_0ElementType());

	public static final IGrammarAwareElementType ConcreteParserRule_MagicNumberAssignment_1_ELEMENT_TYPE = associate(ConcreteParserRuleFactory.createConcreteParserRule_MagicNumberAssignment_1ElementType());

	public static final IGrammarAwareElementType ConcreteParserRule_MagicNumberREALTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ConcreteParserRuleFactory.createConcreteParserRule_MagicNumberREALTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType ConcreteParserRule_ColonKeyword_2_ELEMENT_TYPE = associate(ConcreteParserRuleFactory.createConcreteParserRule_ColonKeyword_2ElementType());

	public static final IGrammarAwareElementType ConcreteParserRule_ElementsAssignment_3_ELEMENT_TYPE = associate(ConcreteParserRuleFactory.createConcreteParserRule_ElementsAssignment_3ElementType());

	public static final IGrammarAwareElementType ConcreteParserRule_ElementsInheritedParserRuleParserRuleCall_3_0_ELEMENT_TYPE = associate(ConcreteParserRuleFactory.createConcreteParserRule_ElementsInheritedParserRuleParserRuleCall_3_0ElementType());

	private static class OverridableParserRuleFactory {
		public static IGrammarAwareElementType createOverridableParserRuleElementType() {
			return new IGrammarAwareElementType("OverridableParserRule_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRuleRule());
		}
		public static IGrammarAwareElementType createOverridableParserRule_GroupElementType() {
			return new IGrammarAwareElementType("OverridableParserRule_Group_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createOverridableParserRule_OverriddenelementKeyword_0ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule_OverriddenelementKeyword_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRuleAccess().getOverriddenelementKeyword_0());
		}
		public static IGrammarAwareElementType createOverridableParserRule_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule_NameAssignment_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRuleAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType OverridableParserRule_ELEMENT_TYPE = associate(OverridableParserRuleFactory.createOverridableParserRuleElementType());

	public static final IGrammarAwareElementType OverridableParserRule_Group_ELEMENT_TYPE = associate(OverridableParserRuleFactory.createOverridableParserRule_GroupElementType());

	public static final IGrammarAwareElementType OverridableParserRule_OverriddenelementKeyword_0_ELEMENT_TYPE = associate(OverridableParserRuleFactory.createOverridableParserRule_OverriddenelementKeyword_0ElementType());

	public static final IGrammarAwareElementType OverridableParserRule_NameAssignment_1_ELEMENT_TYPE = associate(OverridableParserRuleFactory.createOverridableParserRule_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType OverridableParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(OverridableParserRuleFactory.createOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType());

	private static class CallOverridenParserRuleFactory {
		public static IGrammarAwareElementType createCallOverridenParserRuleElementType() {
			return new IGrammarAwareElementType("CallOverridenParserRule_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallOverridenParserRuleRule());
		}
		public static IGrammarAwareElementType createCallOverridenParserRule_CallAssignmentElementType() {
			return new IGrammarAwareElementType("CallOverridenParserRule_CallAssignment_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallOverridenParserRuleAccess().getCallAssignment());
		}
		public static IGrammarAwareElementType createCallOverridenParserRule_CallAbstractCallOverridenParserRuleParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("CallOverridenParserRule_CallAbstractCallOverridenParserRuleParserRuleCall_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallOverridenParserRuleAccess().getCallAbstractCallOverridenParserRuleParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType CallOverridenParserRule_ELEMENT_TYPE = associate(CallOverridenParserRuleFactory.createCallOverridenParserRuleElementType());

	public static final IGrammarAwareElementType CallOverridenParserRule_CallAssignment_ELEMENT_TYPE = associate(CallOverridenParserRuleFactory.createCallOverridenParserRule_CallAssignmentElementType());

	public static final IGrammarAwareElementType CallOverridenParserRule_CallAbstractCallOverridenParserRuleParserRuleCall_0_ELEMENT_TYPE = associate(CallOverridenParserRuleFactory.createCallOverridenParserRule_CallAbstractCallOverridenParserRuleParserRuleCall_0ElementType());

	private static class OverridableParserRule2Factory {
		public static IGrammarAwareElementType createOverridableParserRule2ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Rule());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_GroupElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_Group_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getGroup());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_OverriddenOtherElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_OverriddenOtherElementKeyword_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getOverriddenOtherElementKeyword_0());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_NameAssignment_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_HyphenMinusKeyword_2ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_HyphenMinusKeyword_2_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getHyphenMinusKeyword_2());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_AgeAssignment_3ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_AgeAssignment_3_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getAgeAssignment_3());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_AgeINTTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_AgeINTTerminalRuleCall_3_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getAgeINTTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType OverridableParserRule2_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2ElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_Group_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_GroupElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_OverriddenOtherElementKeyword_0_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_OverriddenOtherElementKeyword_0ElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_NameAssignment_1_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_HyphenMinusKeyword_2_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_HyphenMinusKeyword_2ElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_AgeAssignment_3_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_AgeAssignment_3ElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_AgeINTTerminalRuleCall_3_0_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_AgeINTTerminalRuleCall_3_0ElementType());

	private static class ExtendableParserRuleFactory {
		public static IGrammarAwareElementType createExtendableParserRuleElementType() {
			return new IGrammarAwareElementType("ExtendableParserRule_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtendableParserRuleRule());
		}
		public static IGrammarAwareElementType createExtendableParserRule_AlternativesElementType() {
			return new IGrammarAwareElementType("ExtendableParserRule_Alternatives_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtendableParserRuleAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createExtendableParserRule_Subrule1ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("ExtendableParserRule_Subrule1ParserRuleCall_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtendableParserRuleAccess().getSubrule1ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createExtendableParserRule_Subrule2ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ExtendableParserRule_Subrule2ParserRuleCall_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtendableParserRuleAccess().getSubrule2ParserRuleCall_1());
		}
		public static IGrammarAwareElementType createExtendableParserRule_Subrule3ParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("ExtendableParserRule_Subrule3ParserRuleCall_2_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtendableParserRuleAccess().getSubrule3ParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType ExtendableParserRule_ELEMENT_TYPE = associate(ExtendableParserRuleFactory.createExtendableParserRuleElementType());

	public static final IGrammarAwareElementType ExtendableParserRule_Alternatives_ELEMENT_TYPE = associate(ExtendableParserRuleFactory.createExtendableParserRule_AlternativesElementType());

	public static final IGrammarAwareElementType ExtendableParserRule_Subrule1ParserRuleCall_0_ELEMENT_TYPE = associate(ExtendableParserRuleFactory.createExtendableParserRule_Subrule1ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType ExtendableParserRule_Subrule2ParserRuleCall_1_ELEMENT_TYPE = associate(ExtendableParserRuleFactory.createExtendableParserRule_Subrule2ParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType ExtendableParserRule_Subrule3ParserRuleCall_2_ELEMENT_TYPE = associate(ExtendableParserRuleFactory.createExtendableParserRule_Subrule3ParserRuleCall_2ElementType());

	private static class Subrule1Factory {
		public static IGrammarAwareElementType createSubrule1ElementType() {
			return new IGrammarAwareElementType("Subrule1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule1Rule());
		}
		public static IGrammarAwareElementType createSubrule1_GroupElementType() {
			return new IGrammarAwareElementType("Subrule1_Group_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule1Access().getGroup());
		}
		public static IGrammarAwareElementType createSubrule1_Subrule1Keyword_0ElementType() {
			return new IGrammarAwareElementType("Subrule1_Subrule1Keyword_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule1Access().getSubrule1Keyword_0());
		}
		public static IGrammarAwareElementType createSubrule1_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Subrule1_NameAssignment_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule1Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSubrule1_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Subrule1_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule1Access().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSubrule1_Sub1Assignment_2ElementType() {
			return new IGrammarAwareElementType("Subrule1_Sub1Assignment_2_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule1Access().getSub1Assignment_2());
		}
		public static IGrammarAwareElementType createSubrule1_Sub1IDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Subrule1_Sub1IDTerminalRuleCall_2_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule1Access().getSub1IDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Subrule1_ELEMENT_TYPE = associate(Subrule1Factory.createSubrule1ElementType());

	public static final IGrammarAwareElementType Subrule1_Group_ELEMENT_TYPE = associate(Subrule1Factory.createSubrule1_GroupElementType());

	public static final IGrammarAwareElementType Subrule1_Subrule1Keyword_0_ELEMENT_TYPE = associate(Subrule1Factory.createSubrule1_Subrule1Keyword_0ElementType());

	public static final IGrammarAwareElementType Subrule1_NameAssignment_1_ELEMENT_TYPE = associate(Subrule1Factory.createSubrule1_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Subrule1_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Subrule1Factory.createSubrule1_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Subrule1_Sub1Assignment_2_ELEMENT_TYPE = associate(Subrule1Factory.createSubrule1_Sub1Assignment_2ElementType());

	public static final IGrammarAwareElementType Subrule1_Sub1IDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(Subrule1Factory.createSubrule1_Sub1IDTerminalRuleCall_2_0ElementType());

	private static class Subrule2Factory {
		public static IGrammarAwareElementType createSubrule2ElementType() {
			return new IGrammarAwareElementType("Subrule2_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule2Rule());
		}
		public static IGrammarAwareElementType createSubrule2_GroupElementType() {
			return new IGrammarAwareElementType("Subrule2_Group_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule2Access().getGroup());
		}
		public static IGrammarAwareElementType createSubrule2_Subrule3Keyword_0ElementType() {
			return new IGrammarAwareElementType("Subrule2_Subrule3Keyword_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule2Access().getSubrule3Keyword_0());
		}
		public static IGrammarAwareElementType createSubrule2_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Subrule2_NameAssignment_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule2Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSubrule2_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Subrule2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule2Access().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSubrule2_Sub2Assignment_2ElementType() {
			return new IGrammarAwareElementType("Subrule2_Sub2Assignment_2_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule2Access().getSub2Assignment_2());
		}
		public static IGrammarAwareElementType createSubrule2_Sub2STRINGTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Subrule2_Sub2STRINGTerminalRuleCall_2_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule2Access().getSub2STRINGTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Subrule2_ELEMENT_TYPE = associate(Subrule2Factory.createSubrule2ElementType());

	public static final IGrammarAwareElementType Subrule2_Group_ELEMENT_TYPE = associate(Subrule2Factory.createSubrule2_GroupElementType());

	public static final IGrammarAwareElementType Subrule2_Subrule3Keyword_0_ELEMENT_TYPE = associate(Subrule2Factory.createSubrule2_Subrule3Keyword_0ElementType());

	public static final IGrammarAwareElementType Subrule2_NameAssignment_1_ELEMENT_TYPE = associate(Subrule2Factory.createSubrule2_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Subrule2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Subrule2Factory.createSubrule2_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Subrule2_Sub2Assignment_2_ELEMENT_TYPE = associate(Subrule2Factory.createSubrule2_Sub2Assignment_2ElementType());

	public static final IGrammarAwareElementType Subrule2_Sub2STRINGTerminalRuleCall_2_0_ELEMENT_TYPE = associate(Subrule2Factory.createSubrule2_Sub2STRINGTerminalRuleCall_2_0ElementType());

	private static class Subrule3Factory {
		public static IGrammarAwareElementType createSubrule3ElementType() {
			return new IGrammarAwareElementType("Subrule3_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule3Rule());
		}
		public static IGrammarAwareElementType createSubrule3_GroupElementType() {
			return new IGrammarAwareElementType("Subrule3_Group_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule3Access().getGroup());
		}
		public static IGrammarAwareElementType createSubrule3_Subrule3Keyword_0ElementType() {
			return new IGrammarAwareElementType("Subrule3_Subrule3Keyword_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule3Access().getSubrule3Keyword_0());
		}
		public static IGrammarAwareElementType createSubrule3_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Subrule3_NameAssignment_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule3Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSubrule3_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Subrule3_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule3Access().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSubrule3_Sub1Assignment_2ElementType() {
			return new IGrammarAwareElementType("Subrule3_Sub1Assignment_2_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule3Access().getSub1Assignment_2());
		}
		public static IGrammarAwareElementType createSubrule3_Sub1INTTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Subrule3_Sub1INTTerminalRuleCall_2_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubrule3Access().getSub1INTTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Subrule3_ELEMENT_TYPE = associate(Subrule3Factory.createSubrule3ElementType());

	public static final IGrammarAwareElementType Subrule3_Group_ELEMENT_TYPE = associate(Subrule3Factory.createSubrule3_GroupElementType());

	public static final IGrammarAwareElementType Subrule3_Subrule3Keyword_0_ELEMENT_TYPE = associate(Subrule3Factory.createSubrule3_Subrule3Keyword_0ElementType());

	public static final IGrammarAwareElementType Subrule3_NameAssignment_1_ELEMENT_TYPE = associate(Subrule3Factory.createSubrule3_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Subrule3_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Subrule3Factory.createSubrule3_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Subrule3_Sub1Assignment_2_ELEMENT_TYPE = associate(Subrule3Factory.createSubrule3_Sub1Assignment_2ElementType());

	public static final IGrammarAwareElementType Subrule3_Sub1INTTerminalRuleCall_2_0_ELEMENT_TYPE = associate(Subrule3Factory.createSubrule3_Sub1INTTerminalRuleCall_2_0ElementType());

	private static class CallExtendedParserRuleFactory {
		public static IGrammarAwareElementType createCallExtendedParserRuleElementType() {
			return new IGrammarAwareElementType("CallExtendedParserRule_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallExtendedParserRuleRule());
		}
		public static IGrammarAwareElementType createCallExtendedParserRule_CallAssignmentElementType() {
			return new IGrammarAwareElementType("CallExtendedParserRule_CallAssignment_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallExtendedParserRuleAccess().getCallAssignment());
		}
		public static IGrammarAwareElementType createCallExtendedParserRule_CallAbstractCallExtendedParserRuleParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("CallExtendedParserRule_CallAbstractCallExtendedParserRuleParserRuleCall_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCallExtendedParserRuleAccess().getCallAbstractCallExtendedParserRuleParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType CallExtendedParserRule_ELEMENT_TYPE = associate(CallExtendedParserRuleFactory.createCallExtendedParserRuleElementType());

	public static final IGrammarAwareElementType CallExtendedParserRule_CallAssignment_ELEMENT_TYPE = associate(CallExtendedParserRuleFactory.createCallExtendedParserRule_CallAssignmentElementType());

	public static final IGrammarAwareElementType CallExtendedParserRule_CallAbstractCallExtendedParserRuleParserRuleCall_0_ELEMENT_TYPE = associate(CallExtendedParserRuleFactory.createCallExtendedParserRule_CallAbstractCallExtendedParserRuleParserRuleCall_0ElementType());

	private static class InheritedParserRuleFactory {
		public static IGrammarAwareElementType createInheritedParserRuleElementType() {
			return new IGrammarAwareElementType("InheritedParserRule_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritedParserRuleRule());
		}
		public static IGrammarAwareElementType createInheritedParserRule_GroupElementType() {
			return new IGrammarAwareElementType("InheritedParserRule_Group_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritedParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createInheritedParserRule_ElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("InheritedParserRule_ElementKeyword_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritedParserRuleAccess().getElementKeyword_0());
		}
		public static IGrammarAwareElementType createInheritedParserRule_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("InheritedParserRule_NameAssignment_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritedParserRuleAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createInheritedParserRule_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("InheritedParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType InheritedParserRule_ELEMENT_TYPE = associate(InheritedParserRuleFactory.createInheritedParserRuleElementType());

	public static final IGrammarAwareElementType InheritedParserRule_Group_ELEMENT_TYPE = associate(InheritedParserRuleFactory.createInheritedParserRule_GroupElementType());

	public static final IGrammarAwareElementType InheritedParserRule_ElementKeyword_0_ELEMENT_TYPE = associate(InheritedParserRuleFactory.createInheritedParserRule_ElementKeyword_0ElementType());

	public static final IGrammarAwareElementType InheritedParserRule_NameAssignment_1_ELEMENT_TYPE = associate(InheritedParserRuleFactory.createInheritedParserRule_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType InheritedParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(InheritedParserRuleFactory.createInheritedParserRule_NameIDTerminalRuleCall_1_0ElementType());

	private static class AbstractCallOverridenParserRuleFactory {
		public static IGrammarAwareElementType createAbstractCallOverridenParserRuleElementType() {
			return new IGrammarAwareElementType("AbstractCallOverridenParserRule_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallOverridenParserRuleRule());
		}
		public static IGrammarAwareElementType createAbstractCallOverridenParserRule_GroupElementType() {
			return new IGrammarAwareElementType("AbstractCallOverridenParserRule_Group_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallOverridenParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createAbstractCallOverridenParserRule_OverridemodelKeyword_0ElementType() {
			return new IGrammarAwareElementType("AbstractCallOverridenParserRule_OverridemodelKeyword_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallOverridenParserRuleAccess().getOverridemodelKeyword_0());
		}
		public static IGrammarAwareElementType createAbstractCallOverridenParserRule_ElementsAssignment_1ElementType() {
			return new IGrammarAwareElementType("AbstractCallOverridenParserRule_ElementsAssignment_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallOverridenParserRuleAccess().getElementsAssignment_1());
		}
		public static IGrammarAwareElementType createAbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallOverridenParserRuleAccess().getElementsOverridableParserRuleParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AbstractCallOverridenParserRule_ELEMENT_TYPE = associate(AbstractCallOverridenParserRuleFactory.createAbstractCallOverridenParserRuleElementType());

	public static final IGrammarAwareElementType AbstractCallOverridenParserRule_Group_ELEMENT_TYPE = associate(AbstractCallOverridenParserRuleFactory.createAbstractCallOverridenParserRule_GroupElementType());

	public static final IGrammarAwareElementType AbstractCallOverridenParserRule_OverridemodelKeyword_0_ELEMENT_TYPE = associate(AbstractCallOverridenParserRuleFactory.createAbstractCallOverridenParserRule_OverridemodelKeyword_0ElementType());

	public static final IGrammarAwareElementType AbstractCallOverridenParserRule_ElementsAssignment_1_ELEMENT_TYPE = associate(AbstractCallOverridenParserRuleFactory.createAbstractCallOverridenParserRule_ElementsAssignment_1ElementType());

	public static final IGrammarAwareElementType AbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0_ELEMENT_TYPE = associate(AbstractCallOverridenParserRuleFactory.createAbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0ElementType());

	private static class AbstractCallExtendedParserRuleFactory {
		public static IGrammarAwareElementType createAbstractCallExtendedParserRuleElementType() {
			return new IGrammarAwareElementType("AbstractCallExtendedParserRule_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallExtendedParserRuleRule());
		}
		public static IGrammarAwareElementType createAbstractCallExtendedParserRule_GroupElementType() {
			return new IGrammarAwareElementType("AbstractCallExtendedParserRule_Group_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallExtendedParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createAbstractCallExtendedParserRule_ExtendedmodelKeyword_0ElementType() {
			return new IGrammarAwareElementType("AbstractCallExtendedParserRule_ExtendedmodelKeyword_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallExtendedParserRuleAccess().getExtendedmodelKeyword_0());
		}
		public static IGrammarAwareElementType createAbstractCallExtendedParserRule_ElementsAssignment_1ElementType() {
			return new IGrammarAwareElementType("AbstractCallExtendedParserRule_ElementsAssignment_1_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallExtendedParserRuleAccess().getElementsAssignment_1());
		}
		public static IGrammarAwareElementType createAbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0_ELEMENT_TYPE", ConcreteTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallExtendedParserRuleAccess().getElementsExtendableParserRuleParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AbstractCallExtendedParserRule_ELEMENT_TYPE = associate(AbstractCallExtendedParserRuleFactory.createAbstractCallExtendedParserRuleElementType());

	public static final IGrammarAwareElementType AbstractCallExtendedParserRule_Group_ELEMENT_TYPE = associate(AbstractCallExtendedParserRuleFactory.createAbstractCallExtendedParserRule_GroupElementType());

	public static final IGrammarAwareElementType AbstractCallExtendedParserRule_ExtendedmodelKeyword_0_ELEMENT_TYPE = associate(AbstractCallExtendedParserRuleFactory.createAbstractCallExtendedParserRule_ExtendedmodelKeyword_0ElementType());

	public static final IGrammarAwareElementType AbstractCallExtendedParserRule_ElementsAssignment_1_ELEMENT_TYPE = associate(AbstractCallExtendedParserRuleFactory.createAbstractCallExtendedParserRule_ElementsAssignment_1ElementType());

	public static final IGrammarAwareElementType AbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0_ELEMENT_TYPE = associate(AbstractCallExtendedParserRuleFactory.createAbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getRootRuleElementType() {
		return RootRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRootRule_AlternativesElementType() {
		return RootRule_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRootRule_ConcreteParserRuleParserRuleCall_0ElementType() {
		return RootRule_ConcreteParserRuleParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRootRule_CallOverridenParserRuleParserRuleCall_1ElementType() {
		return RootRule_CallOverridenParserRuleParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRootRule_CallExtendedParserRuleParserRuleCall_2ElementType() {
		return RootRule_CallExtendedParserRuleParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRootRule_OverridableParserRule2ParserRuleCall_3ElementType() {
		return RootRule_OverridableParserRule2ParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteParserRuleElementType() {
		return ConcreteParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteParserRule_GroupElementType() {
		return ConcreteParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteParserRule_ModelKeyword_0ElementType() {
		return ConcreteParserRule_ModelKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteParserRule_MagicNumberAssignment_1ElementType() {
		return ConcreteParserRule_MagicNumberAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteParserRule_MagicNumberREALTerminalRuleCall_1_0ElementType() {
		return ConcreteParserRule_MagicNumberREALTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteParserRule_ColonKeyword_2ElementType() {
		return ConcreteParserRule_ColonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteParserRule_ElementsAssignment_3ElementType() {
		return ConcreteParserRule_ElementsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteParserRule_ElementsInheritedParserRuleParserRuleCall_3_0ElementType() {
		return ConcreteParserRule_ElementsInheritedParserRuleParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRuleElementType() {
		return OverridableParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule_GroupElementType() {
		return OverridableParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule_OverriddenelementKeyword_0ElementType() {
		return OverridableParserRule_OverriddenelementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule_NameAssignment_1ElementType() {
		return OverridableParserRule_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType() {
		return OverridableParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallOverridenParserRuleElementType() {
		return CallOverridenParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallOverridenParserRule_CallAssignmentElementType() {
		return CallOverridenParserRule_CallAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallOverridenParserRule_CallAbstractCallOverridenParserRuleParserRuleCall_0ElementType() {
		return CallOverridenParserRule_CallAbstractCallOverridenParserRuleParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2ElementType() {
		return OverridableParserRule2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_GroupElementType() {
		return OverridableParserRule2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_OverriddenOtherElementKeyword_0ElementType() {
		return OverridableParserRule2_OverriddenOtherElementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_NameAssignment_1ElementType() {
		return OverridableParserRule2_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_NameIDTerminalRuleCall_1_0ElementType() {
		return OverridableParserRule2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_HyphenMinusKeyword_2ElementType() {
		return OverridableParserRule2_HyphenMinusKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_AgeAssignment_3ElementType() {
		return OverridableParserRule2_AgeAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_AgeINTTerminalRuleCall_3_0ElementType() {
		return OverridableParserRule2_AgeINTTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtendableParserRuleElementType() {
		return ExtendableParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtendableParserRule_AlternativesElementType() {
		return ExtendableParserRule_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtendableParserRule_Subrule1ParserRuleCall_0ElementType() {
		return ExtendableParserRule_Subrule1ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtendableParserRule_Subrule2ParserRuleCall_1ElementType() {
		return ExtendableParserRule_Subrule2ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtendableParserRule_Subrule3ParserRuleCall_2ElementType() {
		return ExtendableParserRule_Subrule3ParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule1ElementType() {
		return Subrule1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule1_GroupElementType() {
		return Subrule1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule1_Subrule1Keyword_0ElementType() {
		return Subrule1_Subrule1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule1_NameAssignment_1ElementType() {
		return Subrule1_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule1_NameIDTerminalRuleCall_1_0ElementType() {
		return Subrule1_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule1_Sub1Assignment_2ElementType() {
		return Subrule1_Sub1Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule1_Sub1IDTerminalRuleCall_2_0ElementType() {
		return Subrule1_Sub1IDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule2ElementType() {
		return Subrule2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule2_GroupElementType() {
		return Subrule2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule2_Subrule3Keyword_0ElementType() {
		return Subrule2_Subrule3Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule2_NameAssignment_1ElementType() {
		return Subrule2_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule2_NameIDTerminalRuleCall_1_0ElementType() {
		return Subrule2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule2_Sub2Assignment_2ElementType() {
		return Subrule2_Sub2Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule2_Sub2STRINGTerminalRuleCall_2_0ElementType() {
		return Subrule2_Sub2STRINGTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule3ElementType() {
		return Subrule3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule3_GroupElementType() {
		return Subrule3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule3_Subrule3Keyword_0ElementType() {
		return Subrule3_Subrule3Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule3_NameAssignment_1ElementType() {
		return Subrule3_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule3_NameIDTerminalRuleCall_1_0ElementType() {
		return Subrule3_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule3_Sub1Assignment_2ElementType() {
		return Subrule3_Sub1Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubrule3_Sub1INTTerminalRuleCall_2_0ElementType() {
		return Subrule3_Sub1INTTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallExtendedParserRuleElementType() {
		return CallExtendedParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallExtendedParserRule_CallAssignmentElementType() {
		return CallExtendedParserRule_CallAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCallExtendedParserRule_CallAbstractCallExtendedParserRuleParserRuleCall_0ElementType() {
		return CallExtendedParserRule_CallAbstractCallExtendedParserRuleParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritedParserRuleElementType() {
		return InheritedParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritedParserRule_GroupElementType() {
		return InheritedParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritedParserRule_ElementKeyword_0ElementType() {
		return InheritedParserRule_ElementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritedParserRule_NameAssignment_1ElementType() {
		return InheritedParserRule_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritedParserRule_NameIDTerminalRuleCall_1_0ElementType() {
		return InheritedParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallOverridenParserRuleElementType() {
		return AbstractCallOverridenParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallOverridenParserRule_GroupElementType() {
		return AbstractCallOverridenParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallOverridenParserRule_OverridemodelKeyword_0ElementType() {
		return AbstractCallOverridenParserRule_OverridemodelKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallOverridenParserRule_ElementsAssignment_1ElementType() {
		return AbstractCallOverridenParserRule_ElementsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0ElementType() {
		return AbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallExtendedParserRuleElementType() {
		return AbstractCallExtendedParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallExtendedParserRule_GroupElementType() {
		return AbstractCallExtendedParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallExtendedParserRule_ExtendedmodelKeyword_0ElementType() {
		return AbstractCallExtendedParserRule_ExtendedmodelKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallExtendedParserRule_ElementsAssignment_1ElementType() {
		return AbstractCallExtendedParserRule_ElementsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0ElementType() {
		return AbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0_ELEMENT_TYPE;
	}

}
