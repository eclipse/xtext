package org.eclipse.xtext.parser.fragments.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.fragments.idea.lang.psi.impl.FragmentTestLanguageExFileImpl;
import org.eclipse.xtext.parser.fragments.services.FragmentTestLanguageExGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class FragmentTestLanguageExElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<FragmentTestLanguageExFileImpl>>(FragmentTestLanguageExLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final FragmentTestLanguageExGrammarAccess GRAMMAR_ACCESS = FragmentTestLanguageExLanguage.INSTANCE.getInstance(FragmentTestLanguageExGrammarAccess.class);

	private static class ParserRuleFragmentsExFactory {
		public static IGrammarAwareElementType createParserRuleFragmentsExElementType() {
			return new IGrammarAwareElementType("ParserRuleFragmentsEx_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsExRule());
		}
		public static IGrammarAwareElementType createParserRuleFragmentsEx_ParserRuleFragmentsParserRuleCallElementType() {
			return new IGrammarAwareElementType("ParserRuleFragmentsEx_ParserRuleFragmentsParserRuleCall_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsExAccess().getParserRuleFragmentsParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType ParserRuleFragmentsEx_ELEMENT_TYPE = associate(ParserRuleFragmentsExFactory.createParserRuleFragmentsExElementType());

	public static final IGrammarAwareElementType ParserRuleFragmentsEx_ParserRuleFragmentsParserRuleCall_ELEMENT_TYPE = associate(ParserRuleFragmentsExFactory.createParserRuleFragmentsEx_ParserRuleFragmentsParserRuleCallElementType());

	private static class ParserRuleFragmentsFactory {
		public static IGrammarAwareElementType createParserRuleFragmentsElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsRule());
		}
		public static IGrammarAwareElementType createParserRuleFragments_GroupElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ParserRuleFragmentsAction_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ParserRuleFragmentsAction_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getParserRuleFragmentsAction_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Alternatives_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitOneKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitOneKeyword_1_0_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitOneKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedParserRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitTwoKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_1_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedParserRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2());
		}
		public static IGrammarAwareElementType createParserRuleFragments_RefAssignment_1_1_3ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_RefAssignment_1_1_3_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getRefAssignment_1_1_3());
		}
		public static IGrammarAwareElementType createParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getRefPRFNamedCrossReference_1_1_3_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_RefPRFNamedIDTerminalRuleCall_1_1_3_0_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_RefPRFNamedIDTerminalRuleCall_1_1_3_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getRefPRFNamedIDTerminalRuleCall_1_1_3_0_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_2ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_2_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_2());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitThreeKeyword_1_2_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_2_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_2_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_2_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedRefFirstParserRuleCall_1_2_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_3ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_3_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_3());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitFourKeyword_1_3_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitFourKeyword_1_3_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitFourKeyword_1_3_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_3_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_3_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_3_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedWithActionParserRuleCall_1_3_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_4ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_4_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_4());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitEightKeyword_1_4_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitEightKeyword_1_4_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitEightKeyword_1_4_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_4_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_4_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_4_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_4_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_4_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedWithFQNParserRuleCall_1_4_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_5ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_5_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_5());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitNineKeyword_1_5_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitNineKeyword_1_5_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitNineKeyword_1_5_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_5_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_5_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_5_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFWithPredicateParserRuleCall_1_5_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFWithPredicateParserRuleCall_1_5_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFWithPredicateParserRuleCall_1_5_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_6ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_6_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_6());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitOneDigitZeroKeyword_1_6_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitOneDigitZeroKeyword_1_6_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitOneDigitZeroKeyword_1_6_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_6_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_6_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_6_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedRecursiveParserRuleCall_1_6_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedRecursiveParserRuleCall_1_6_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedRecursiveParserRuleCall_1_6_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_7ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_7_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_7());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitOneDigitOneKeyword_1_7_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitOneDigitOneKeyword_1_7_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitOneDigitOneKeyword_1_7_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_7_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_7_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_7_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedRecursiveFragmentParserRuleCall_1_7_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedRecursiveFragmentParserRuleCall_1_7_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedRecursiveFragmentParserRuleCall_1_7_1_0());
		}
	}

	public static final IGrammarAwareElementType ParserRuleFragments_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragmentsElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_GroupElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ParserRuleFragmentsAction_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ParserRuleFragmentsAction_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Alternatives_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Alternatives_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitOneKeyword_1_0_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitOneKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_0_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_1_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_RefAssignment_1_1_3_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_RefAssignment_1_1_3ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_RefPRFNamedIDTerminalRuleCall_1_1_3_0_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_RefPRFNamedIDTerminalRuleCall_1_1_3_0_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_2_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_2ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_2_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_2_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_3_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_3ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitFourKeyword_1_3_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitFourKeyword_1_3_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_3_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_3_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_4_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_4ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitEightKeyword_1_4_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitEightKeyword_1_4_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_4_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_4_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_4_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_4_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_5_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_5ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitNineKeyword_1_5_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitNineKeyword_1_5_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_5_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_5_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFWithPredicateParserRuleCall_1_5_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFWithPredicateParserRuleCall_1_5_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_6_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_6ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitOneDigitZeroKeyword_1_6_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitOneDigitZeroKeyword_1_6_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_6_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_6_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedRecursiveParserRuleCall_1_6_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedRecursiveParserRuleCall_1_6_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_7_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_7ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitOneDigitOneKeyword_1_7_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitOneDigitOneKeyword_1_7_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_7_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_7_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedRecursiveFragmentParserRuleCall_1_7_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedRecursiveFragmentParserRuleCall_1_7_1_0ElementType());

	private static class PRFNamedFactory {
		public static IGrammarAwareElementType createPRFNamedElementType() {
			return new IGrammarAwareElementType("PRFNamed_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRule());
		}
		public static IGrammarAwareElementType createPRFNamed_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamed_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamed_PRFNamedFragmentParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PRFNamed_PRFNamedFragmentParserRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getPRFNamedFragmentParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPRFNamed_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("PRFNamed_Alternatives_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createPRFNamed_Group_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamed_Group_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createPRFNamed_ColonKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamed_ColonKeyword_1_0_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getColonKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createPRFNamed_RefAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamed_RefAssignment_1_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getRefAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createPRFNamed_RefPRFNamedCrossReference_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamed_RefPRFNamedCrossReference_1_0_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getRefPRFNamedCrossReference_1_0_1_0());
		}
		public static IGrammarAwareElementType createPRFNamed_RefPRFNamedIDTerminalRuleCall_1_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamed_RefPRFNamedIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getRefPRFNamedIDTerminalRuleCall_1_0_1_0_1());
		}
		public static IGrammarAwareElementType createPRFNamed_Group_1_1ElementType() {
			return new IGrammarAwareElementType("PRFNamed_Group_1_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createPRFNamed_HyphenMinusKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamed_HyphenMinusKeyword_1_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getHyphenMinusKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createPRFNamed_PRFNamedRefParserRuleCall_1_1_1ElementType() {
			return new IGrammarAwareElementType("PRFNamed_PRFNamedRefParserRuleCall_1_1_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getPRFNamedRefParserRuleCall_1_1_1());
		}
	}

	public static final IGrammarAwareElementType PRFNamed_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamedElementType());

	public static final IGrammarAwareElementType PRFNamed_Group_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_GroupElementType());

	public static final IGrammarAwareElementType PRFNamed_PRFNamedFragmentParserRuleCall_0_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_PRFNamedFragmentParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType PRFNamed_Alternatives_1_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_Alternatives_1ElementType());

	public static final IGrammarAwareElementType PRFNamed_Group_1_0_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_Group_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamed_ColonKeyword_1_0_0_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_ColonKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType PRFNamed_RefAssignment_1_0_1_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_RefAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType PRFNamed_RefPRFNamedCrossReference_1_0_1_0_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_RefPRFNamedCrossReference_1_0_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamed_RefPRFNamedIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_RefPRFNamedIDTerminalRuleCall_1_0_1_0_1ElementType());

	public static final IGrammarAwareElementType PRFNamed_Group_1_1_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_Group_1_1ElementType());

	public static final IGrammarAwareElementType PRFNamed_HyphenMinusKeyword_1_1_0_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_HyphenMinusKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamed_PRFNamedRefParserRuleCall_1_1_1_ELEMENT_TYPE = associate(PRFNamedFactory.createPRFNamed_PRFNamedRefParserRuleCall_1_1_1ElementType());

	private static class PRFNamedRecursiveFactory {
		public static IGrammarAwareElementType createPRFNamedRecursiveElementType() {
			return new IGrammarAwareElementType("PRFNamedRecursive_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRecursiveRule());
		}
		public static IGrammarAwareElementType createPRFNamedRecursive_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedRecursive_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRecursiveAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedRecursive_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedRecursive_NameAssignment_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRecursiveAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createPRFNamedRecursive_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedRecursive_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRecursiveAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createPRFNamedRecursive_RecursiveFromFragmentParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedRecursive_RecursiveFromFragmentParserRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRecursiveAccess().getRecursiveFromFragmentParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType PRFNamedRecursive_ELEMENT_TYPE = associate(PRFNamedRecursiveFactory.createPRFNamedRecursiveElementType());

	public static final IGrammarAwareElementType PRFNamedRecursive_Group_ELEMENT_TYPE = associate(PRFNamedRecursiveFactory.createPRFNamedRecursive_GroupElementType());

	public static final IGrammarAwareElementType PRFNamedRecursive_NameAssignment_0_ELEMENT_TYPE = associate(PRFNamedRecursiveFactory.createPRFNamedRecursive_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType PRFNamedRecursive_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(PRFNamedRecursiveFactory.createPRFNamedRecursive_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType PRFNamedRecursive_RecursiveFromFragmentParserRuleCall_1_ELEMENT_TYPE = associate(PRFNamedRecursiveFactory.createPRFNamedRecursive_RecursiveFromFragmentParserRuleCall_1ElementType());

	private static class PRFNamedRecursiveFragmentFactory {
		public static IGrammarAwareElementType createPRFNamedRecursiveFragmentElementType() {
			return new IGrammarAwareElementType("PRFNamedRecursiveFragment_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRecursiveFragmentRule());
		}
		public static IGrammarAwareElementType createPRFNamedRecursiveFragment_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedRecursiveFragment_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRecursiveFragmentAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedRecursiveFragment_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedRecursiveFragment_NameAssignment_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRecursiveFragmentAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createPRFNamedRecursiveFragment_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedRecursiveFragment_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRecursiveFragmentAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createPRFNamedRecursiveFragment_RecursiveFragmentParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedRecursiveFragment_RecursiveFragmentParserRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRecursiveFragmentAccess().getRecursiveFragmentParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType PRFNamedRecursiveFragment_ELEMENT_TYPE = associate(PRFNamedRecursiveFragmentFactory.createPRFNamedRecursiveFragmentElementType());

	public static final IGrammarAwareElementType PRFNamedRecursiveFragment_Group_ELEMENT_TYPE = associate(PRFNamedRecursiveFragmentFactory.createPRFNamedRecursiveFragment_GroupElementType());

	public static final IGrammarAwareElementType PRFNamedRecursiveFragment_NameAssignment_0_ELEMENT_TYPE = associate(PRFNamedRecursiveFragmentFactory.createPRFNamedRecursiveFragment_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType PRFNamedRecursiveFragment_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(PRFNamedRecursiveFragmentFactory.createPRFNamedRecursiveFragment_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType PRFNamedRecursiveFragment_RecursiveFragmentParserRuleCall_1_ELEMENT_TYPE = associate(PRFNamedRecursiveFragmentFactory.createPRFNamedRecursiveFragment_RecursiveFragmentParserRuleCall_1ElementType());

	private static class PRFNamedRefFirstFactory {
		public static IGrammarAwareElementType createPRFNamedRefFirstElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstRule());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_RefAssignment_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_RefAssignment_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getRefAssignment_0());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_RefPRFNamedCrossReference_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_RefPRFNamedCrossReference_0_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getRefPRFNamedCrossReference_0_0());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_RefPRFNamedIDTerminalRuleCall_0_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_RefPRFNamedIDTerminalRuleCall_0_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getRefPRFNamedIDTerminalRuleCall_0_0_1());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getLessThanSignHyphenMinusKeyword_1());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getPRFNamedFragmentParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType PRFNamedRefFirst_ELEMENT_TYPE = associate(PRFNamedRefFirstFactory.createPRFNamedRefFirstElementType());

	public static final IGrammarAwareElementType PRFNamedRefFirst_Group_ELEMENT_TYPE = associate(PRFNamedRefFirstFactory.createPRFNamedRefFirst_GroupElementType());

	public static final IGrammarAwareElementType PRFNamedRefFirst_RefAssignment_0_ELEMENT_TYPE = associate(PRFNamedRefFirstFactory.createPRFNamedRefFirst_RefAssignment_0ElementType());

	public static final IGrammarAwareElementType PRFNamedRefFirst_RefPRFNamedCrossReference_0_0_ELEMENT_TYPE = associate(PRFNamedRefFirstFactory.createPRFNamedRefFirst_RefPRFNamedCrossReference_0_0ElementType());

	public static final IGrammarAwareElementType PRFNamedRefFirst_RefPRFNamedIDTerminalRuleCall_0_0_1_ELEMENT_TYPE = associate(PRFNamedRefFirstFactory.createPRFNamedRefFirst_RefPRFNamedIDTerminalRuleCall_0_0_1ElementType());

	public static final IGrammarAwareElementType PRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1_ELEMENT_TYPE = associate(PRFNamedRefFirstFactory.createPRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1ElementType());

	public static final IGrammarAwareElementType PRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2_ELEMENT_TYPE = associate(PRFNamedRefFirstFactory.createPRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2ElementType());

	private static class PRFNamedWithActionFactory {
		public static IGrammarAwareElementType createPRFNamedWithActionElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionRule());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_PRFNamedParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_PRFNamedParserRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getPRFNamedParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_PRFNamedWithActionPrevAction_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_PRFNamedWithActionPrevAction_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getPRFNamedWithActionPrevAction_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_NameAssignment_2_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_Group_3ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_Group_3_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_RefAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_RefAssignment_3_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRefAssignment_3_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_RefPRFNamedCrossReference_3_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_RefPRFNamedCrossReference_3_0_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRefPRFNamedCrossReference_3_0_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_RefPRFNamedIDTerminalRuleCall_3_0_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_RefPRFNamedIDTerminalRuleCall_3_0_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRefPRFNamedIDTerminalRuleCall_3_0_0_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_Ref2Assignment_3_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_Ref2Assignment_3_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRef2Assignment_3_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRef2PRFNamedCrossReference_3_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_Ref2PRFNamedIDTerminalRuleCall_3_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_Ref2PRFNamedIDTerminalRuleCall_3_1_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRef2PRFNamedIDTerminalRuleCall_3_1_0_1());
		}
	}

	public static final IGrammarAwareElementType PRFNamedWithAction_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithActionElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_Group_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_GroupElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_PRFNamedParserRuleCall_0_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_PRFNamedParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_PRFNamedWithActionPrevAction_1_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_PRFNamedWithActionPrevAction_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_NameAssignment_2_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_Group_3_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_Group_3ElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_RefAssignment_3_0_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_RefAssignment_3_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_RefPRFNamedCrossReference_3_0_0_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_RefPRFNamedCrossReference_3_0_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_RefPRFNamedIDTerminalRuleCall_3_0_0_1_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_RefPRFNamedIDTerminalRuleCall_3_0_0_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_Ref2Assignment_3_1_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_Ref2Assignment_3_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithAction_Ref2PRFNamedIDTerminalRuleCall_3_1_0_1_ELEMENT_TYPE = associate(PRFNamedWithActionFactory.createPRFNamedWithAction_Ref2PRFNamedIDTerminalRuleCall_3_1_0_1ElementType());

	private static class PRFNamedWithFQNFactory {
		public static IGrammarAwareElementType createPRFNamedWithFQNElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNRule());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_NameAssignment_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_NameFQNParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_NameFQNParserRuleCall_0_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getNameFQNParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_Group_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_Group_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_HyphenMinusKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_HyphenMinusKeyword_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getHyphenMinusKeyword_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_RefAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_RefAssignment_1_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getRefAssignment_1_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getRefPRFNamedCrossReference_1_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_RefPRFNamedFQN2ParserRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_RefPRFNamedFQN2ParserRuleCall_1_1_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getRefPRFNamedFQN2ParserRuleCall_1_1_0_1());
		}
	}

	public static final IGrammarAwareElementType PRFNamedWithFQN_ELEMENT_TYPE = associate(PRFNamedWithFQNFactory.createPRFNamedWithFQNElementType());

	public static final IGrammarAwareElementType PRFNamedWithFQN_Group_ELEMENT_TYPE = associate(PRFNamedWithFQNFactory.createPRFNamedWithFQN_GroupElementType());

	public static final IGrammarAwareElementType PRFNamedWithFQN_NameAssignment_0_ELEMENT_TYPE = associate(PRFNamedWithFQNFactory.createPRFNamedWithFQN_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithFQN_NameFQNParserRuleCall_0_0_ELEMENT_TYPE = associate(PRFNamedWithFQNFactory.createPRFNamedWithFQN_NameFQNParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithFQN_Group_1_ELEMENT_TYPE = associate(PRFNamedWithFQNFactory.createPRFNamedWithFQN_Group_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithFQN_HyphenMinusKeyword_1_0_ELEMENT_TYPE = associate(PRFNamedWithFQNFactory.createPRFNamedWithFQN_HyphenMinusKeyword_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithFQN_RefAssignment_1_1_ELEMENT_TYPE = associate(PRFNamedWithFQNFactory.createPRFNamedWithFQN_RefAssignment_1_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0_ELEMENT_TYPE = associate(PRFNamedWithFQNFactory.createPRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithFQN_RefPRFNamedFQN2ParserRuleCall_1_1_0_1_ELEMENT_TYPE = associate(PRFNamedWithFQNFactory.createPRFNamedWithFQN_RefPRFNamedFQN2ParserRuleCall_1_1_0_1ElementType());

	private static class PRFWithPredicateFactory {
		public static IGrammarAwareElementType createPRFWithPredicateElementType() {
			return new IGrammarAwareElementType("PRFWithPredicate_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFWithPredicateRule());
		}
		public static IGrammarAwareElementType createPRFWithPredicate_GroupElementType() {
			return new IGrammarAwareElementType("PRFWithPredicate_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFWithPredicateAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFWithPredicate_PRFNamedFragmentParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PRFWithPredicate_PRFNamedFragmentParserRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFWithPredicateAccess().getPRFNamedFragmentParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPRFWithPredicate_Group_1ElementType() {
			return new IGrammarAwareElementType("PRFWithPredicate_Group_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFWithPredicateAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createPRFWithPredicate_Group_1_0ElementType() {
			return new IGrammarAwareElementType("PRFWithPredicate_Group_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFWithPredicateAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createPRFWithPredicate_HyphenMinusKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("PRFWithPredicate_HyphenMinusKeyword_1_0_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFWithPredicateAccess().getHyphenMinusKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createPRFWithPredicate_PRFNamedRefParserRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFWithPredicate_PRFNamedRefParserRuleCall_1_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFWithPredicateAccess().getPRFNamedRefParserRuleCall_1_0_1());
		}
	}

	public static final IGrammarAwareElementType PRFWithPredicate_ELEMENT_TYPE = associate(PRFWithPredicateFactory.createPRFWithPredicateElementType());

	public static final IGrammarAwareElementType PRFWithPredicate_Group_ELEMENT_TYPE = associate(PRFWithPredicateFactory.createPRFWithPredicate_GroupElementType());

	public static final IGrammarAwareElementType PRFWithPredicate_PRFNamedFragmentParserRuleCall_0_ELEMENT_TYPE = associate(PRFWithPredicateFactory.createPRFWithPredicate_PRFNamedFragmentParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType PRFWithPredicate_Group_1_ELEMENT_TYPE = associate(PRFWithPredicateFactory.createPRFWithPredicate_Group_1ElementType());

	public static final IGrammarAwareElementType PRFWithPredicate_Group_1_0_ELEMENT_TYPE = associate(PRFWithPredicateFactory.createPRFWithPredicate_Group_1_0ElementType());

	public static final IGrammarAwareElementType PRFWithPredicate_HyphenMinusKeyword_1_0_0_ELEMENT_TYPE = associate(PRFWithPredicateFactory.createPRFWithPredicate_HyphenMinusKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType PRFWithPredicate_PRFNamedRefParserRuleCall_1_0_1_ELEMENT_TYPE = associate(PRFWithPredicateFactory.createPRFWithPredicate_PRFNamedRefParserRuleCall_1_0_1ElementType());

	private static class FQNFactory {
		public static IGrammarAwareElementType createFQNElementType() {
			return new IGrammarAwareElementType("FQN_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNRule());
		}
		public static IGrammarAwareElementType createFQN_GroupElementType() {
			return new IGrammarAwareElementType("FQN_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN_SuffixParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("FQN_SuffixParserRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getSuffixParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType FQN_ELEMENT_TYPE = associate(FQNFactory.createFQNElementType());

	public static final IGrammarAwareElementType FQN_Group_ELEMENT_TYPE = associate(FQNFactory.createFQN_GroupElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType FQN_SuffixParserRuleCall_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_SuffixParserRuleCall_1ElementType());

	private static class FQN2Factory {
		public static IGrammarAwareElementType createFQN2ElementType() {
			return new IGrammarAwareElementType("FQN2_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getFQN2Rule());
		}
		public static IGrammarAwareElementType createFQN2_GroupElementType() {
			return new IGrammarAwareElementType("FQN2_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getFQN2Access().getGroup());
		}
		public static IGrammarAwareElementType createFQN2_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN2_IDTerminalRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getFQN2Access().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN2_Suffix2ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("FQN2_Suffix2ParserRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getFQN2Access().getSuffix2ParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType FQN2_ELEMENT_TYPE = associate(FQN2Factory.createFQN2ElementType());

	public static final IGrammarAwareElementType FQN2_Group_ELEMENT_TYPE = associate(FQN2Factory.createFQN2_GroupElementType());

	public static final IGrammarAwareElementType FQN2_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FQN2Factory.createFQN2_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType FQN2_Suffix2ParserRuleCall_1_ELEMENT_TYPE = associate(FQN2Factory.createFQN2_Suffix2ParserRuleCall_1ElementType());

	private static class SuffixFactory {
		public static IGrammarAwareElementType createSuffixElementType() {
			return new IGrammarAwareElementType("Suffix_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffixRule());
		}
		public static IGrammarAwareElementType createSuffix_GroupElementType() {
			return new IGrammarAwareElementType("Suffix_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffixAccess().getGroup());
		}
		public static IGrammarAwareElementType createSuffix_FullStopKeyword_0ElementType() {
			return new IGrammarAwareElementType("Suffix_FullStopKeyword_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffixAccess().getFullStopKeyword_0());
		}
		public static IGrammarAwareElementType createSuffix_IDTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Suffix_IDTerminalRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffixAccess().getIDTerminalRuleCall_1());
		}
		public static IGrammarAwareElementType createSuffix_SuffixParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Suffix_SuffixParserRuleCall_2_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffixAccess().getSuffixParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType Suffix_ELEMENT_TYPE = associate(SuffixFactory.createSuffixElementType());

	public static final IGrammarAwareElementType Suffix_Group_ELEMENT_TYPE = associate(SuffixFactory.createSuffix_GroupElementType());

	public static final IGrammarAwareElementType Suffix_FullStopKeyword_0_ELEMENT_TYPE = associate(SuffixFactory.createSuffix_FullStopKeyword_0ElementType());

	public static final IGrammarAwareElementType Suffix_IDTerminalRuleCall_1_ELEMENT_TYPE = associate(SuffixFactory.createSuffix_IDTerminalRuleCall_1ElementType());

	public static final IGrammarAwareElementType Suffix_SuffixParserRuleCall_2_ELEMENT_TYPE = associate(SuffixFactory.createSuffix_SuffixParserRuleCall_2ElementType());

	private static class Suffix2Factory {
		public static IGrammarAwareElementType createSuffix2ElementType() {
			return new IGrammarAwareElementType("Suffix2_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffix2Rule());
		}
		public static IGrammarAwareElementType createSuffix2_GroupElementType() {
			return new IGrammarAwareElementType("Suffix2_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffix2Access().getGroup());
		}
		public static IGrammarAwareElementType createSuffix2_FullStopKeyword_0ElementType() {
			return new IGrammarAwareElementType("Suffix2_FullStopKeyword_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffix2Access().getFullStopKeyword_0());
		}
		public static IGrammarAwareElementType createSuffix2_IDTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Suffix2_IDTerminalRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffix2Access().getIDTerminalRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Suffix2_ELEMENT_TYPE = associate(Suffix2Factory.createSuffix2ElementType());

	public static final IGrammarAwareElementType Suffix2_Group_ELEMENT_TYPE = associate(Suffix2Factory.createSuffix2_GroupElementType());

	public static final IGrammarAwareElementType Suffix2_FullStopKeyword_0_ELEMENT_TYPE = associate(Suffix2Factory.createSuffix2_FullStopKeyword_0ElementType());

	public static final IGrammarAwareElementType Suffix2_IDTerminalRuleCall_1_ELEMENT_TYPE = associate(Suffix2Factory.createSuffix2_IDTerminalRuleCall_1ElementType());

	private static class PRFNamedFragmentFactory {
		public static IGrammarAwareElementType createPRFNamedFragmentElementType() {
			return new IGrammarAwareElementType("PRFNamedFragment_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedFragmentRule());
		}
		public static IGrammarAwareElementType createPRFNamedFragment_NameAssignmentElementType() {
			return new IGrammarAwareElementType("PRFNamedFragment_NameAssignment_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedFragmentAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createPRFNamedFragment_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedFragment_NameIDTerminalRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedFragmentAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType PRFNamedFragment_ELEMENT_TYPE = associate(PRFNamedFragmentFactory.createPRFNamedFragmentElementType());

	public static final IGrammarAwareElementType PRFNamedFragment_NameAssignment_ELEMENT_TYPE = associate(PRFNamedFragmentFactory.createPRFNamedFragment_NameAssignmentElementType());

	public static final IGrammarAwareElementType PRFNamedFragment_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(PRFNamedFragmentFactory.createPRFNamedFragment_NameIDTerminalRuleCall_0ElementType());

	private static class PRFNamedRefFactory {
		public static IGrammarAwareElementType createPRFNamedRefElementType() {
			return new IGrammarAwareElementType("PRFNamedRef_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefRule());
		}
		public static IGrammarAwareElementType createPRFNamedRef_RefAssignmentElementType() {
			return new IGrammarAwareElementType("PRFNamedRef_RefAssignment_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefAccess().getRefAssignment());
		}
		public static IGrammarAwareElementType createPRFNamedRef_RefPRFNamedCrossReference_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedRef_RefPRFNamedCrossReference_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefAccess().getRefPRFNamedCrossReference_0());
		}
		public static IGrammarAwareElementType createPRFNamedRef_RefPRFNamedIDTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedRef_RefPRFNamedIDTerminalRuleCall_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefAccess().getRefPRFNamedIDTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType PRFNamedRef_ELEMENT_TYPE = associate(PRFNamedRefFactory.createPRFNamedRefElementType());

	public static final IGrammarAwareElementType PRFNamedRef_RefAssignment_ELEMENT_TYPE = associate(PRFNamedRefFactory.createPRFNamedRef_RefAssignmentElementType());

	public static final IGrammarAwareElementType PRFNamedRef_RefPRFNamedCrossReference_0_ELEMENT_TYPE = associate(PRFNamedRefFactory.createPRFNamedRef_RefPRFNamedCrossReference_0ElementType());

	public static final IGrammarAwareElementType PRFNamedRef_RefPRFNamedIDTerminalRuleCall_0_1_ELEMENT_TYPE = associate(PRFNamedRefFactory.createPRFNamedRef_RefPRFNamedIDTerminalRuleCall_0_1ElementType());

	private static class RecursiveFromFragmentFactory {
		public static IGrammarAwareElementType createRecursiveFromFragmentElementType() {
			return new IGrammarAwareElementType("RecursiveFromFragment_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFromFragmentRule());
		}
		public static IGrammarAwareElementType createRecursiveFromFragment_PrevAssignmentElementType() {
			return new IGrammarAwareElementType("RecursiveFromFragment_PrevAssignment_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFromFragmentAccess().getPrevAssignment());
		}
		public static IGrammarAwareElementType createRecursiveFromFragment_PrevNamedInParenthesesParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("RecursiveFromFragment_PrevNamedInParenthesesParserRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFromFragmentAccess().getPrevNamedInParenthesesParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType RecursiveFromFragment_ELEMENT_TYPE = associate(RecursiveFromFragmentFactory.createRecursiveFromFragmentElementType());

	public static final IGrammarAwareElementType RecursiveFromFragment_PrevAssignment_ELEMENT_TYPE = associate(RecursiveFromFragmentFactory.createRecursiveFromFragment_PrevAssignmentElementType());

	public static final IGrammarAwareElementType RecursiveFromFragment_PrevNamedInParenthesesParserRuleCall_0_ELEMENT_TYPE = associate(RecursiveFromFragmentFactory.createRecursiveFromFragment_PrevNamedInParenthesesParserRuleCall_0ElementType());

	private static class NamedInParenthesesFactory {
		public static IGrammarAwareElementType createNamedInParenthesesElementType() {
			return new IGrammarAwareElementType("NamedInParentheses_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedInParenthesesRule());
		}
		public static IGrammarAwareElementType createNamedInParentheses_AlternativesElementType() {
			return new IGrammarAwareElementType("NamedInParentheses_Alternatives_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedInParenthesesAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createNamedInParentheses_Group_0ElementType() {
			return new IGrammarAwareElementType("NamedInParentheses_Group_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedInParenthesesAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createNamedInParentheses_LeftParenthesisKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("NamedInParentheses_LeftParenthesisKeyword_0_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedInParenthesesAccess().getLeftParenthesisKeyword_0_0());
		}
		public static IGrammarAwareElementType createNamedInParentheses_NamedInParenthesesParserRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("NamedInParentheses_NamedInParenthesesParserRuleCall_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedInParenthesesAccess().getNamedInParenthesesParserRuleCall_0_1());
		}
		public static IGrammarAwareElementType createNamedInParentheses_RightParenthesisKeyword_0_2ElementType() {
			return new IGrammarAwareElementType("NamedInParentheses_RightParenthesisKeyword_0_2_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedInParenthesesAccess().getRightParenthesisKeyword_0_2());
		}
		public static IGrammarAwareElementType createNamedInParentheses_Group_1ElementType() {
			return new IGrammarAwareElementType("NamedInParentheses_Group_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedInParenthesesAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createNamedInParentheses_PRFNamedAction_1_0ElementType() {
			return new IGrammarAwareElementType("NamedInParentheses_PRFNamedAction_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedInParenthesesAccess().getPRFNamedAction_1_0());
		}
		public static IGrammarAwareElementType createNamedInParentheses_NameAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("NamedInParentheses_NameAssignment_1_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedInParenthesesAccess().getNameAssignment_1_1());
		}
		public static IGrammarAwareElementType createNamedInParentheses_NameIDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("NamedInParentheses_NameIDTerminalRuleCall_1_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedInParenthesesAccess().getNameIDTerminalRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType NamedInParentheses_ELEMENT_TYPE = associate(NamedInParenthesesFactory.createNamedInParenthesesElementType());

	public static final IGrammarAwareElementType NamedInParentheses_Alternatives_ELEMENT_TYPE = associate(NamedInParenthesesFactory.createNamedInParentheses_AlternativesElementType());

	public static final IGrammarAwareElementType NamedInParentheses_Group_0_ELEMENT_TYPE = associate(NamedInParenthesesFactory.createNamedInParentheses_Group_0ElementType());

	public static final IGrammarAwareElementType NamedInParentheses_LeftParenthesisKeyword_0_0_ELEMENT_TYPE = associate(NamedInParenthesesFactory.createNamedInParentheses_LeftParenthesisKeyword_0_0ElementType());

	public static final IGrammarAwareElementType NamedInParentheses_NamedInParenthesesParserRuleCall_0_1_ELEMENT_TYPE = associate(NamedInParenthesesFactory.createNamedInParentheses_NamedInParenthesesParserRuleCall_0_1ElementType());

	public static final IGrammarAwareElementType NamedInParentheses_RightParenthesisKeyword_0_2_ELEMENT_TYPE = associate(NamedInParenthesesFactory.createNamedInParentheses_RightParenthesisKeyword_0_2ElementType());

	public static final IGrammarAwareElementType NamedInParentheses_Group_1_ELEMENT_TYPE = associate(NamedInParenthesesFactory.createNamedInParentheses_Group_1ElementType());

	public static final IGrammarAwareElementType NamedInParentheses_PRFNamedAction_1_0_ELEMENT_TYPE = associate(NamedInParenthesesFactory.createNamedInParentheses_PRFNamedAction_1_0ElementType());

	public static final IGrammarAwareElementType NamedInParentheses_NameAssignment_1_1_ELEMENT_TYPE = associate(NamedInParenthesesFactory.createNamedInParentheses_NameAssignment_1_1ElementType());

	public static final IGrammarAwareElementType NamedInParentheses_NameIDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(NamedInParenthesesFactory.createNamedInParentheses_NameIDTerminalRuleCall_1_1_0ElementType());

	private static class RecursiveFragmentFactory {
		public static IGrammarAwareElementType createRecursiveFragmentElementType() {
			return new IGrammarAwareElementType("RecursiveFragment_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFragmentRule());
		}
		public static IGrammarAwareElementType createRecursiveFragment_AlternativesElementType() {
			return new IGrammarAwareElementType("RecursiveFragment_Alternatives_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFragmentAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createRecursiveFragment_Group_0ElementType() {
			return new IGrammarAwareElementType("RecursiveFragment_Group_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFragmentAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createRecursiveFragment_LeftParenthesisKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("RecursiveFragment_LeftParenthesisKeyword_0_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFragmentAccess().getLeftParenthesisKeyword_0_0());
		}
		public static IGrammarAwareElementType createRecursiveFragment_RecursiveFragmentParserRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("RecursiveFragment_RecursiveFragmentParserRuleCall_0_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFragmentAccess().getRecursiveFragmentParserRuleCall_0_1());
		}
		public static IGrammarAwareElementType createRecursiveFragment_RightParenthesisKeyword_0_2ElementType() {
			return new IGrammarAwareElementType("RecursiveFragment_RightParenthesisKeyword_0_2_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFragmentAccess().getRightParenthesisKeyword_0_2());
		}
		public static IGrammarAwareElementType createRecursiveFragment_PrevAssignment_1ElementType() {
			return new IGrammarAwareElementType("RecursiveFragment_PrevAssignment_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFragmentAccess().getPrevAssignment_1());
		}
		public static IGrammarAwareElementType createRecursiveFragment_PrevNamedByActionParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("RecursiveFragment_PrevNamedByActionParserRuleCall_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getRecursiveFragmentAccess().getPrevNamedByActionParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType RecursiveFragment_ELEMENT_TYPE = associate(RecursiveFragmentFactory.createRecursiveFragmentElementType());

	public static final IGrammarAwareElementType RecursiveFragment_Alternatives_ELEMENT_TYPE = associate(RecursiveFragmentFactory.createRecursiveFragment_AlternativesElementType());

	public static final IGrammarAwareElementType RecursiveFragment_Group_0_ELEMENT_TYPE = associate(RecursiveFragmentFactory.createRecursiveFragment_Group_0ElementType());

	public static final IGrammarAwareElementType RecursiveFragment_LeftParenthesisKeyword_0_0_ELEMENT_TYPE = associate(RecursiveFragmentFactory.createRecursiveFragment_LeftParenthesisKeyword_0_0ElementType());

	public static final IGrammarAwareElementType RecursiveFragment_RecursiveFragmentParserRuleCall_0_1_ELEMENT_TYPE = associate(RecursiveFragmentFactory.createRecursiveFragment_RecursiveFragmentParserRuleCall_0_1ElementType());

	public static final IGrammarAwareElementType RecursiveFragment_RightParenthesisKeyword_0_2_ELEMENT_TYPE = associate(RecursiveFragmentFactory.createRecursiveFragment_RightParenthesisKeyword_0_2ElementType());

	public static final IGrammarAwareElementType RecursiveFragment_PrevAssignment_1_ELEMENT_TYPE = associate(RecursiveFragmentFactory.createRecursiveFragment_PrevAssignment_1ElementType());

	public static final IGrammarAwareElementType RecursiveFragment_PrevNamedByActionParserRuleCall_1_0_ELEMENT_TYPE = associate(RecursiveFragmentFactory.createRecursiveFragment_PrevNamedByActionParserRuleCall_1_0ElementType());

	private static class NamedByActionFactory {
		public static IGrammarAwareElementType createNamedByActionElementType() {
			return new IGrammarAwareElementType("NamedByAction_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedByActionRule());
		}
		public static IGrammarAwareElementType createNamedByAction_GroupElementType() {
			return new IGrammarAwareElementType("NamedByAction_Group_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedByActionAccess().getGroup());
		}
		public static IGrammarAwareElementType createNamedByAction_PRFNamedAction_0ElementType() {
			return new IGrammarAwareElementType("NamedByAction_PRFNamedAction_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedByActionAccess().getPRFNamedAction_0());
		}
		public static IGrammarAwareElementType createNamedByAction_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("NamedByAction_NameAssignment_1_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedByActionAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createNamedByAction_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NamedByAction_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", FragmentTestLanguageExLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedByActionAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType NamedByAction_ELEMENT_TYPE = associate(NamedByActionFactory.createNamedByActionElementType());

	public static final IGrammarAwareElementType NamedByAction_Group_ELEMENT_TYPE = associate(NamedByActionFactory.createNamedByAction_GroupElementType());

	public static final IGrammarAwareElementType NamedByAction_PRFNamedAction_0_ELEMENT_TYPE = associate(NamedByActionFactory.createNamedByAction_PRFNamedAction_0ElementType());

	public static final IGrammarAwareElementType NamedByAction_NameAssignment_1_ELEMENT_TYPE = associate(NamedByActionFactory.createNamedByAction_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType NamedByAction_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(NamedByActionFactory.createNamedByAction_NameIDTerminalRuleCall_1_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getParserRuleFragmentsExElementType() {
		return ParserRuleFragmentsEx_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragmentsEx_ParserRuleFragmentsParserRuleCallElementType() {
		return ParserRuleFragmentsEx_ParserRuleFragmentsParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragmentsElementType() {
		return ParserRuleFragments_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_GroupElementType() {
		return ParserRuleFragments_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ParserRuleFragmentsAction_0ElementType() {
		return ParserRuleFragments_ParserRuleFragmentsAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Alternatives_1ElementType() {
		return ParserRuleFragments_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_0ElementType() {
		return ParserRuleFragments_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitOneKeyword_1_0_0ElementType() {
		return ParserRuleFragments_NumberSignDigitOneKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_0_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_1ElementType() {
		return ParserRuleFragments_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0ElementType() {
		return ParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_1_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2ElementType() {
		return ParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_RefAssignment_1_1_3ElementType() {
		return ParserRuleFragments_RefAssignment_1_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0ElementType() {
		return ParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_RefPRFNamedIDTerminalRuleCall_1_1_3_0_1ElementType() {
		return ParserRuleFragments_RefPRFNamedIDTerminalRuleCall_1_1_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_2ElementType() {
		return ParserRuleFragments_Group_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0ElementType() {
		return ParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_2_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_3ElementType() {
		return ParserRuleFragments_Group_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitFourKeyword_1_3_0ElementType() {
		return ParserRuleFragments_NumberSignDigitFourKeyword_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_3_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_4ElementType() {
		return ParserRuleFragments_Group_1_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitEightKeyword_1_4_0ElementType() {
		return ParserRuleFragments_NumberSignDigitEightKeyword_1_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_4_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_4_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_5ElementType() {
		return ParserRuleFragments_Group_1_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitNineKeyword_1_5_0ElementType() {
		return ParserRuleFragments_NumberSignDigitNineKeyword_1_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_5_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFWithPredicateParserRuleCall_1_5_1_0ElementType() {
		return ParserRuleFragments_ElementPRFWithPredicateParserRuleCall_1_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_6ElementType() {
		return ParserRuleFragments_Group_1_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitOneDigitZeroKeyword_1_6_0ElementType() {
		return ParserRuleFragments_NumberSignDigitOneDigitZeroKeyword_1_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_6_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedRecursiveParserRuleCall_1_6_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedRecursiveParserRuleCall_1_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_7ElementType() {
		return ParserRuleFragments_Group_1_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitOneDigitOneKeyword_1_7_0ElementType() {
		return ParserRuleFragments_NumberSignDigitOneDigitOneKeyword_1_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_7_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_7_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedRecursiveFragmentParserRuleCall_1_7_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedRecursiveFragmentParserRuleCall_1_7_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedElementType() {
		return PRFNamed_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_GroupElementType() {
		return PRFNamed_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_PRFNamedFragmentParserRuleCall_0ElementType() {
		return PRFNamed_PRFNamedFragmentParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_Alternatives_1ElementType() {
		return PRFNamed_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_Group_1_0ElementType() {
		return PRFNamed_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_ColonKeyword_1_0_0ElementType() {
		return PRFNamed_ColonKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_RefAssignment_1_0_1ElementType() {
		return PRFNamed_RefAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_RefPRFNamedCrossReference_1_0_1_0ElementType() {
		return PRFNamed_RefPRFNamedCrossReference_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_RefPRFNamedIDTerminalRuleCall_1_0_1_0_1ElementType() {
		return PRFNamed_RefPRFNamedIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_Group_1_1ElementType() {
		return PRFNamed_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_HyphenMinusKeyword_1_1_0ElementType() {
		return PRFNamed_HyphenMinusKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamed_PRFNamedRefParserRuleCall_1_1_1ElementType() {
		return PRFNamed_PRFNamedRefParserRuleCall_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRecursiveElementType() {
		return PRFNamedRecursive_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRecursive_GroupElementType() {
		return PRFNamedRecursive_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRecursive_NameAssignment_0ElementType() {
		return PRFNamedRecursive_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRecursive_NameIDTerminalRuleCall_0_0ElementType() {
		return PRFNamedRecursive_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRecursive_RecursiveFromFragmentParserRuleCall_1ElementType() {
		return PRFNamedRecursive_RecursiveFromFragmentParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRecursiveFragmentElementType() {
		return PRFNamedRecursiveFragment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRecursiveFragment_GroupElementType() {
		return PRFNamedRecursiveFragment_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRecursiveFragment_NameAssignment_0ElementType() {
		return PRFNamedRecursiveFragment_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRecursiveFragment_NameIDTerminalRuleCall_0_0ElementType() {
		return PRFNamedRecursiveFragment_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRecursiveFragment_RecursiveFragmentParserRuleCall_1ElementType() {
		return PRFNamedRecursiveFragment_RecursiveFragmentParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRefFirstElementType() {
		return PRFNamedRefFirst_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRefFirst_GroupElementType() {
		return PRFNamedRefFirst_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRefFirst_RefAssignment_0ElementType() {
		return PRFNamedRefFirst_RefAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRefFirst_RefPRFNamedCrossReference_0_0ElementType() {
		return PRFNamedRefFirst_RefPRFNamedCrossReference_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRefFirst_RefPRFNamedIDTerminalRuleCall_0_0_1ElementType() {
		return PRFNamedRefFirst_RefPRFNamedIDTerminalRuleCall_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1ElementType() {
		return PRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2ElementType() {
		return PRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionElementType() {
		return PRFNamedWithAction_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_GroupElementType() {
		return PRFNamedWithAction_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_PRFNamedParserRuleCall_0ElementType() {
		return PRFNamedWithAction_PRFNamedParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_PRFNamedWithActionPrevAction_1ElementType() {
		return PRFNamedWithAction_PRFNamedWithActionPrevAction_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_NameAssignment_2ElementType() {
		return PRFNamedWithAction_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_NameIDTerminalRuleCall_2_0ElementType() {
		return PRFNamedWithAction_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_Group_3ElementType() {
		return PRFNamedWithAction_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_RefAssignment_3_0ElementType() {
		return PRFNamedWithAction_RefAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_RefPRFNamedCrossReference_3_0_0ElementType() {
		return PRFNamedWithAction_RefPRFNamedCrossReference_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_RefPRFNamedIDTerminalRuleCall_3_0_0_1ElementType() {
		return PRFNamedWithAction_RefPRFNamedIDTerminalRuleCall_3_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_Ref2Assignment_3_1ElementType() {
		return PRFNamedWithAction_Ref2Assignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0ElementType() {
		return PRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithAction_Ref2PRFNamedIDTerminalRuleCall_3_1_0_1ElementType() {
		return PRFNamedWithAction_Ref2PRFNamedIDTerminalRuleCall_3_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithFQNElementType() {
		return PRFNamedWithFQN_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithFQN_GroupElementType() {
		return PRFNamedWithFQN_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithFQN_NameAssignment_0ElementType() {
		return PRFNamedWithFQN_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithFQN_NameFQNParserRuleCall_0_0ElementType() {
		return PRFNamedWithFQN_NameFQNParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithFQN_Group_1ElementType() {
		return PRFNamedWithFQN_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithFQN_HyphenMinusKeyword_1_0ElementType() {
		return PRFNamedWithFQN_HyphenMinusKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithFQN_RefAssignment_1_1ElementType() {
		return PRFNamedWithFQN_RefAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0ElementType() {
		return PRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithFQN_RefPRFNamedFQN2ParserRuleCall_1_1_0_1ElementType() {
		return PRFNamedWithFQN_RefPRFNamedFQN2ParserRuleCall_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFWithPredicateElementType() {
		return PRFWithPredicate_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFWithPredicate_GroupElementType() {
		return PRFWithPredicate_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFWithPredicate_PRFNamedFragmentParserRuleCall_0ElementType() {
		return PRFWithPredicate_PRFNamedFragmentParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFWithPredicate_Group_1ElementType() {
		return PRFWithPredicate_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFWithPredicate_Group_1_0ElementType() {
		return PRFWithPredicate_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFWithPredicate_HyphenMinusKeyword_1_0_0ElementType() {
		return PRFWithPredicate_HyphenMinusKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFWithPredicate_PRFNamedRefParserRuleCall_1_0_1ElementType() {
		return PRFWithPredicate_PRFNamedRefParserRuleCall_1_0_1_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getFQN_SuffixParserRuleCall_1ElementType() {
		return FQN_SuffixParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN2ElementType() {
		return FQN2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN2_GroupElementType() {
		return FQN2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN2_IDTerminalRuleCall_0ElementType() {
		return FQN2_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFQN2_Suffix2ParserRuleCall_1ElementType() {
		return FQN2_Suffix2ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuffixElementType() {
		return Suffix_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuffix_GroupElementType() {
		return Suffix_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuffix_FullStopKeyword_0ElementType() {
		return Suffix_FullStopKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuffix_IDTerminalRuleCall_1ElementType() {
		return Suffix_IDTerminalRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuffix_SuffixParserRuleCall_2ElementType() {
		return Suffix_SuffixParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuffix2ElementType() {
		return Suffix2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuffix2_GroupElementType() {
		return Suffix2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuffix2_FullStopKeyword_0ElementType() {
		return Suffix2_FullStopKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuffix2_IDTerminalRuleCall_1ElementType() {
		return Suffix2_IDTerminalRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedFragmentElementType() {
		return PRFNamedFragment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedFragment_NameAssignmentElementType() {
		return PRFNamedFragment_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedFragment_NameIDTerminalRuleCall_0ElementType() {
		return PRFNamedFragment_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRefElementType() {
		return PRFNamedRef_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRef_RefAssignmentElementType() {
		return PRFNamedRef_RefAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRef_RefPRFNamedCrossReference_0ElementType() {
		return PRFNamedRef_RefPRFNamedCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedRef_RefPRFNamedIDTerminalRuleCall_0_1ElementType() {
		return PRFNamedRef_RefPRFNamedIDTerminalRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFromFragmentElementType() {
		return RecursiveFromFragment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFromFragment_PrevAssignmentElementType() {
		return RecursiveFromFragment_PrevAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFromFragment_PrevNamedInParenthesesParserRuleCall_0ElementType() {
		return RecursiveFromFragment_PrevNamedInParenthesesParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedInParenthesesElementType() {
		return NamedInParentheses_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedInParentheses_AlternativesElementType() {
		return NamedInParentheses_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedInParentheses_Group_0ElementType() {
		return NamedInParentheses_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedInParentheses_LeftParenthesisKeyword_0_0ElementType() {
		return NamedInParentheses_LeftParenthesisKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedInParentheses_NamedInParenthesesParserRuleCall_0_1ElementType() {
		return NamedInParentheses_NamedInParenthesesParserRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedInParentheses_RightParenthesisKeyword_0_2ElementType() {
		return NamedInParentheses_RightParenthesisKeyword_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedInParentheses_Group_1ElementType() {
		return NamedInParentheses_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedInParentheses_PRFNamedAction_1_0ElementType() {
		return NamedInParentheses_PRFNamedAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedInParentheses_NameAssignment_1_1ElementType() {
		return NamedInParentheses_NameAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedInParentheses_NameIDTerminalRuleCall_1_1_0ElementType() {
		return NamedInParentheses_NameIDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFragmentElementType() {
		return RecursiveFragment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFragment_AlternativesElementType() {
		return RecursiveFragment_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFragment_Group_0ElementType() {
		return RecursiveFragment_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFragment_LeftParenthesisKeyword_0_0ElementType() {
		return RecursiveFragment_LeftParenthesisKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFragment_RecursiveFragmentParserRuleCall_0_1ElementType() {
		return RecursiveFragment_RecursiveFragmentParserRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFragment_RightParenthesisKeyword_0_2ElementType() {
		return RecursiveFragment_RightParenthesisKeyword_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFragment_PrevAssignment_1ElementType() {
		return RecursiveFragment_PrevAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRecursiveFragment_PrevNamedByActionParserRuleCall_1_0ElementType() {
		return RecursiveFragment_PrevNamedByActionParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedByActionElementType() {
		return NamedByAction_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedByAction_GroupElementType() {
		return NamedByAction_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedByAction_PRFNamedAction_0ElementType() {
		return NamedByAction_PRFNamedAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedByAction_NameAssignment_1ElementType() {
		return NamedByAction_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedByAction_NameIDTerminalRuleCall_1_0ElementType() {
		return NamedByAction_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

}
