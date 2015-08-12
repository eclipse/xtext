package org.eclipse.xtext.parser.fragments.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.fragments.idea.lang.psi.impl.FragmentTestLanguageFileImpl;
import org.eclipse.xtext.parser.fragments.services.FragmentTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class FragmentTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<FragmentTestLanguageFileImpl>>(FragmentTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final FragmentTestLanguageGrammarAccess GRAMMAR_ACCESS = FragmentTestLanguageLanguage.INSTANCE.getInstance(FragmentTestLanguageGrammarAccess.class);

	private static class ParserRuleFragmentsFactory {
		public static IGrammarAwareElementType createParserRuleFragmentsElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsRule());
		}
		public static IGrammarAwareElementType createParserRuleFragments_GroupElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ParserRuleFragmentsAction_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ParserRuleFragmentsAction_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getParserRuleFragmentsAction_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Alternatives_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitOneKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitOneKeyword_1_0_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitOneKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedParserRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitTwoKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_1_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedParserRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2());
		}
		public static IGrammarAwareElementType createParserRuleFragments_RefAssignment_1_1_3ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_RefAssignment_1_1_3_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getRefAssignment_1_1_3());
		}
		public static IGrammarAwareElementType createParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getRefPRFNamedCrossReference_1_1_3_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_RefPRFNamedIDTerminalRuleCall_1_1_3_0_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_RefPRFNamedIDTerminalRuleCall_1_1_3_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getRefPRFNamedIDTerminalRuleCall_1_1_3_0_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_2ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_2());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitThreeKeyword_1_2_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_2_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_2_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_2_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedRefFirstParserRuleCall_1_2_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_3ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_3_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_3());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitFourKeyword_1_3_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitFourKeyword_1_3_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitFourKeyword_1_3_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_3_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_3_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_3_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedWithActionParserRuleCall_1_3_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_4ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_4_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_4());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitFiveKeyword_1_4_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitFiveKeyword_1_4_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitFiveKeyword_1_4_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_4_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_4_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_4_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedWithActionInFragmentParserRuleCall_1_4_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedWithActionInFragmentParserRuleCall_1_4_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedWithActionInFragmentParserRuleCall_1_4_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_5ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_5_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_5());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitSixKeyword_1_5_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitSixKeyword_1_5_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitSixKeyword_1_5_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_5_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_5_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_5_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedWithActionInFragment2ParserRuleCall_1_5_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedWithActionInFragment2ParserRuleCall_1_5_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedWithActionInFragment2ParserRuleCall_1_5_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_6ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_6_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_6());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitSevenKeyword_1_6_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitSevenKeyword_1_6_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitSevenKeyword_1_6_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_6_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_6_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_6_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedWithActionInFragment3ParserRuleCall_1_6_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedWithActionInFragment3ParserRuleCall_1_6_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedWithActionInFragment3ParserRuleCall_1_6_1_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_Group_1_7ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_Group_1_7_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getGroup_1_7());
		}
		public static IGrammarAwareElementType createParserRuleFragments_NumberSignDigitEightKeyword_1_7_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_NumberSignDigitEightKeyword_1_7_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getNumberSignDigitEightKeyword_1_7_0());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementAssignment_1_7_1ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementAssignment_1_7_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementAssignment_1_7_1());
		}
		public static IGrammarAwareElementType createParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_7_1_0ElementType() {
			return new IGrammarAwareElementType("ParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_7_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParserRuleFragmentsAccess().getElementPRFNamedWithFQNParserRuleCall_1_7_1_0());
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

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitFiveKeyword_1_4_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitFiveKeyword_1_4_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_4_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_4_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedWithActionInFragmentParserRuleCall_1_4_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedWithActionInFragmentParserRuleCall_1_4_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_5_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_5ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitSixKeyword_1_5_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitSixKeyword_1_5_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_5_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_5_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedWithActionInFragment2ParserRuleCall_1_5_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedWithActionInFragment2ParserRuleCall_1_5_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_6_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_6ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitSevenKeyword_1_6_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitSevenKeyword_1_6_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_6_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_6_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedWithActionInFragment3ParserRuleCall_1_6_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedWithActionInFragment3ParserRuleCall_1_6_1_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_Group_1_7_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_Group_1_7ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_NumberSignDigitEightKeyword_1_7_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_NumberSignDigitEightKeyword_1_7_0ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementAssignment_1_7_1_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementAssignment_1_7_1ElementType());

	public static final IGrammarAwareElementType ParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_7_1_0_ELEMENT_TYPE = associate(ParserRuleFragmentsFactory.createParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_7_1_0ElementType());

	private static class PRFNamedFactory {
		public static IGrammarAwareElementType createPRFNamedElementType() {
			return new IGrammarAwareElementType("PRFNamed_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRule());
		}
		public static IGrammarAwareElementType createPRFNamed_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamed_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamed_PRFNamedFragmentParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PRFNamed_PRFNamedFragmentParserRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getPRFNamedFragmentParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPRFNamed_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("PRFNamed_Alternatives_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createPRFNamed_Group_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamed_Group_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createPRFNamed_ColonKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamed_ColonKeyword_1_0_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getColonKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createPRFNamed_RefAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamed_RefAssignment_1_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getRefAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createPRFNamed_RefPRFNamedCrossReference_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamed_RefPRFNamedCrossReference_1_0_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getRefPRFNamedCrossReference_1_0_1_0());
		}
		public static IGrammarAwareElementType createPRFNamed_RefPRFNamedIDTerminalRuleCall_1_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamed_RefPRFNamedIDTerminalRuleCall_1_0_1_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getRefPRFNamedIDTerminalRuleCall_1_0_1_0_1());
		}
		public static IGrammarAwareElementType createPRFNamed_Group_1_1ElementType() {
			return new IGrammarAwareElementType("PRFNamed_Group_1_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createPRFNamed_HyphenMinusKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamed_HyphenMinusKeyword_1_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getHyphenMinusKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createPRFNamed_PRFNamedRefParserRuleCall_1_1_1ElementType() {
			return new IGrammarAwareElementType("PRFNamed_PRFNamedRefParserRuleCall_1_1_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedAccess().getPRFNamedRefParserRuleCall_1_1_1());
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

	private static class PRFNamedRefFirstFactory {
		public static IGrammarAwareElementType createPRFNamedRefFirstElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstRule());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_RefAssignment_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_RefAssignment_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getRefAssignment_0());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_RefPRFNamedCrossReference_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_RefPRFNamedCrossReference_0_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getRefPRFNamedCrossReference_0_0());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_RefPRFNamedIDTerminalRuleCall_0_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_RefPRFNamedIDTerminalRuleCall_0_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getRefPRFNamedIDTerminalRuleCall_0_0_1());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getLessThanSignHyphenMinusKeyword_1());
		}
		public static IGrammarAwareElementType createPRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("PRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefFirstAccess().getPRFNamedFragmentParserRuleCall_2());
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
			return new IGrammarAwareElementType("PRFNamedWithAction_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionRule());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_PRFNamedParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_PRFNamedParserRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getPRFNamedParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_PRFNamedWithActionPrevAction_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_PRFNamedWithActionPrevAction_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getPRFNamedWithActionPrevAction_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_NameAssignment_2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_Group_3ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_Group_3_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_RefAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_RefAssignment_3_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRefAssignment_3_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_RefPRFNamedCrossReference_3_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_RefPRFNamedCrossReference_3_0_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRefPRFNamedCrossReference_3_0_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_RefPRFNamedIDTerminalRuleCall_3_0_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_RefPRFNamedIDTerminalRuleCall_3_0_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRefPRFNamedIDTerminalRuleCall_3_0_0_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_Ref2Assignment_3_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_Ref2Assignment_3_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRef2Assignment_3_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRef2PRFNamedCrossReference_3_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithAction_Ref2PRFNamedIDTerminalRuleCall_3_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithAction_Ref2PRFNamedIDTerminalRuleCall_3_1_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionAccess().getRef2PRFNamedIDTerminalRuleCall_3_1_0_1());
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

	private static class PRFNamedWithActionInFragmentFactory {
		public static IGrammarAwareElementType createPRFNamedWithActionInFragmentElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragmentRule());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragmentAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment_FragmentWithActionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment_FragmentWithActionParserRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragmentAccess().getFragmentWithActionParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment_Group_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment_Group_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragmentAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment_HyphenMinusKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment_HyphenMinusKeyword_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragmentAccess().getHyphenMinusKeyword_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment_RefAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment_RefAssignment_1_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragmentAccess().getRefAssignment_1_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment_RefPRFNamedCrossReference_1_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment_RefPRFNamedCrossReference_1_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragmentAccess().getRefPRFNamedCrossReference_1_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment_RefPRFNamedIDTerminalRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment_RefPRFNamedIDTerminalRuleCall_1_1_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragmentAccess().getRefPRFNamedIDTerminalRuleCall_1_1_0_1());
		}
	}

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment_ELEMENT_TYPE = associate(PRFNamedWithActionInFragmentFactory.createPRFNamedWithActionInFragmentElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment_Group_ELEMENT_TYPE = associate(PRFNamedWithActionInFragmentFactory.createPRFNamedWithActionInFragment_GroupElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment_FragmentWithActionParserRuleCall_0_ELEMENT_TYPE = associate(PRFNamedWithActionInFragmentFactory.createPRFNamedWithActionInFragment_FragmentWithActionParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment_Group_1_ELEMENT_TYPE = associate(PRFNamedWithActionInFragmentFactory.createPRFNamedWithActionInFragment_Group_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment_HyphenMinusKeyword_1_0_ELEMENT_TYPE = associate(PRFNamedWithActionInFragmentFactory.createPRFNamedWithActionInFragment_HyphenMinusKeyword_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment_RefAssignment_1_1_ELEMENT_TYPE = associate(PRFNamedWithActionInFragmentFactory.createPRFNamedWithActionInFragment_RefAssignment_1_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment_RefPRFNamedCrossReference_1_1_0_ELEMENT_TYPE = associate(PRFNamedWithActionInFragmentFactory.createPRFNamedWithActionInFragment_RefPRFNamedCrossReference_1_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment_RefPRFNamedIDTerminalRuleCall_1_1_0_1_ELEMENT_TYPE = associate(PRFNamedWithActionInFragmentFactory.createPRFNamedWithActionInFragment_RefPRFNamedIDTerminalRuleCall_1_1_0_1ElementType());

	private static class PRFNamedWithActionInFragment2Factory {
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment2ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment2Rule());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment2_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment2_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment2Access().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment2_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment2_NameAssignment_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment2Access().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment2_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment2_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment2Access().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment2_FragmentWithAction2ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment2_FragmentWithAction2ParserRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment2Access().getFragmentWithAction2ParserRuleCall_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment2_Group_2ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment2_Group_2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment2Access().getGroup_2());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment2_HyphenMinusKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment2_HyphenMinusKeyword_2_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment2Access().getHyphenMinusKeyword_2_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment2_RefAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment2_RefAssignment_2_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment2Access().getRefAssignment_2_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment2_RefPRFNamedCrossReference_2_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment2_RefPRFNamedCrossReference_2_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment2Access().getRefPRFNamedCrossReference_2_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment2_RefPRFNamedIDTerminalRuleCall_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment2_RefPRFNamedIDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment2Access().getRefPRFNamedIDTerminalRuleCall_2_1_0_1());
		}
	}

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment2_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment2Factory.createPRFNamedWithActionInFragment2ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment2_Group_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment2Factory.createPRFNamedWithActionInFragment2_GroupElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment2_NameAssignment_0_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment2Factory.createPRFNamedWithActionInFragment2_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment2_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment2Factory.createPRFNamedWithActionInFragment2_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment2_FragmentWithAction2ParserRuleCall_1_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment2Factory.createPRFNamedWithActionInFragment2_FragmentWithAction2ParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment2_Group_2_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment2Factory.createPRFNamedWithActionInFragment2_Group_2ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment2_HyphenMinusKeyword_2_0_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment2Factory.createPRFNamedWithActionInFragment2_HyphenMinusKeyword_2_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment2_RefAssignment_2_1_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment2Factory.createPRFNamedWithActionInFragment2_RefAssignment_2_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment2_RefPRFNamedCrossReference_2_1_0_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment2Factory.createPRFNamedWithActionInFragment2_RefPRFNamedCrossReference_2_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment2_RefPRFNamedIDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment2Factory.createPRFNamedWithActionInFragment2_RefPRFNamedIDTerminalRuleCall_2_1_0_1ElementType());

	private static class PRFNamedWithActionInFragment3Factory {
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment3ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment3_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment3Rule());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment3_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment3_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment3Access().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment3_FragmentWithAction3ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment3_FragmentWithAction3ParserRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment3Access().getFragmentWithAction3ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment3_Group_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment3_Group_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment3Access().getGroup_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment3_HyphenMinusKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment3_HyphenMinusKeyword_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment3Access().getHyphenMinusKeyword_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment3_RefAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment3_RefAssignment_1_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment3Access().getRefAssignment_1_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment3_RefPRFNamedCrossReference_1_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment3_RefPRFNamedCrossReference_1_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment3Access().getRefPRFNamedCrossReference_1_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithActionInFragment3_RefPRFNamedIDTerminalRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithActionInFragment3_RefPRFNamedIDTerminalRuleCall_1_1_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithActionInFragment3Access().getRefPRFNamedIDTerminalRuleCall_1_1_0_1());
		}
	}

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment3_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment3Factory.createPRFNamedWithActionInFragment3ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment3_Group_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment3Factory.createPRFNamedWithActionInFragment3_GroupElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment3_FragmentWithAction3ParserRuleCall_0_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment3Factory.createPRFNamedWithActionInFragment3_FragmentWithAction3ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment3_Group_1_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment3Factory.createPRFNamedWithActionInFragment3_Group_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment3_HyphenMinusKeyword_1_0_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment3Factory.createPRFNamedWithActionInFragment3_HyphenMinusKeyword_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment3_RefAssignment_1_1_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment3Factory.createPRFNamedWithActionInFragment3_RefAssignment_1_1ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment3_RefPRFNamedCrossReference_1_1_0_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment3Factory.createPRFNamedWithActionInFragment3_RefPRFNamedCrossReference_1_1_0ElementType());

	public static final IGrammarAwareElementType PRFNamedWithActionInFragment3_RefPRFNamedIDTerminalRuleCall_1_1_0_1_ELEMENT_TYPE = associate(PRFNamedWithActionInFragment3Factory.createPRFNamedWithActionInFragment3_RefPRFNamedIDTerminalRuleCall_1_1_0_1ElementType());

	private static class PRFNamedWithFQNFactory {
		public static IGrammarAwareElementType createPRFNamedWithFQNElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNRule());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_GroupElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_NameAssignment_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_NameFQNParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_NameFQNParserRuleCall_0_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getNameFQNParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_Group_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_Group_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_HyphenMinusKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_HyphenMinusKeyword_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getHyphenMinusKeyword_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_RefAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_RefAssignment_1_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getRefAssignment_1_1());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getRefPRFNamedCrossReference_1_1_0());
		}
		public static IGrammarAwareElementType createPRFNamedWithFQN_RefPRFNamedFQN2ParserRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedWithFQN_RefPRFNamedFQN2ParserRuleCall_1_1_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedWithFQNAccess().getRefPRFNamedFQN2ParserRuleCall_1_1_0_1());
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

	private static class FQNFactory {
		public static IGrammarAwareElementType createFQNElementType() {
			return new IGrammarAwareElementType("FQN_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNRule());
		}
		public static IGrammarAwareElementType createFQN_GroupElementType() {
			return new IGrammarAwareElementType("FQN_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getGroup());
		}
		public static IGrammarAwareElementType createFQN_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN_IDTerminalRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN_SuffixParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("FQN_SuffixParserRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQNAccess().getSuffixParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType FQN_ELEMENT_TYPE = associate(FQNFactory.createFQNElementType());

	public static final IGrammarAwareElementType FQN_Group_ELEMENT_TYPE = associate(FQNFactory.createFQN_GroupElementType());

	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FQNFactory.createFQN_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType FQN_SuffixParserRuleCall_1_ELEMENT_TYPE = associate(FQNFactory.createFQN_SuffixParserRuleCall_1ElementType());

	private static class FQN2Factory {
		public static IGrammarAwareElementType createFQN2ElementType() {
			return new IGrammarAwareElementType("FQN2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQN2Rule());
		}
		public static IGrammarAwareElementType createFQN2_GroupElementType() {
			return new IGrammarAwareElementType("FQN2_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQN2Access().getGroup());
		}
		public static IGrammarAwareElementType createFQN2_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FQN2_IDTerminalRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQN2Access().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createFQN2_Suffix2ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("FQN2_Suffix2ParserRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFQN2Access().getSuffix2ParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType FQN2_ELEMENT_TYPE = associate(FQN2Factory.createFQN2ElementType());

	public static final IGrammarAwareElementType FQN2_Group_ELEMENT_TYPE = associate(FQN2Factory.createFQN2_GroupElementType());

	public static final IGrammarAwareElementType FQN2_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(FQN2Factory.createFQN2_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType FQN2_Suffix2ParserRuleCall_1_ELEMENT_TYPE = associate(FQN2Factory.createFQN2_Suffix2ParserRuleCall_1ElementType());

	private static class SuffixFactory {
		public static IGrammarAwareElementType createSuffixElementType() {
			return new IGrammarAwareElementType("Suffix_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffixRule());
		}
		public static IGrammarAwareElementType createSuffix_GroupElementType() {
			return new IGrammarAwareElementType("Suffix_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffixAccess().getGroup());
		}
		public static IGrammarAwareElementType createSuffix_FullStopKeyword_0ElementType() {
			return new IGrammarAwareElementType("Suffix_FullStopKeyword_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffixAccess().getFullStopKeyword_0());
		}
		public static IGrammarAwareElementType createSuffix_IDTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Suffix_IDTerminalRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffixAccess().getIDTerminalRuleCall_1());
		}
		public static IGrammarAwareElementType createSuffix_SuffixParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Suffix_SuffixParserRuleCall_2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffixAccess().getSuffixParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType Suffix_ELEMENT_TYPE = associate(SuffixFactory.createSuffixElementType());

	public static final IGrammarAwareElementType Suffix_Group_ELEMENT_TYPE = associate(SuffixFactory.createSuffix_GroupElementType());

	public static final IGrammarAwareElementType Suffix_FullStopKeyword_0_ELEMENT_TYPE = associate(SuffixFactory.createSuffix_FullStopKeyword_0ElementType());

	public static final IGrammarAwareElementType Suffix_IDTerminalRuleCall_1_ELEMENT_TYPE = associate(SuffixFactory.createSuffix_IDTerminalRuleCall_1ElementType());

	public static final IGrammarAwareElementType Suffix_SuffixParserRuleCall_2_ELEMENT_TYPE = associate(SuffixFactory.createSuffix_SuffixParserRuleCall_2ElementType());

	private static class Suffix2Factory {
		public static IGrammarAwareElementType createSuffix2ElementType() {
			return new IGrammarAwareElementType("Suffix2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffix2Rule());
		}
		public static IGrammarAwareElementType createSuffix2_GroupElementType() {
			return new IGrammarAwareElementType("Suffix2_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffix2Access().getGroup());
		}
		public static IGrammarAwareElementType createSuffix2_FullStopKeyword_0ElementType() {
			return new IGrammarAwareElementType("Suffix2_FullStopKeyword_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffix2Access().getFullStopKeyword_0());
		}
		public static IGrammarAwareElementType createSuffix2_IDTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Suffix2_IDTerminalRuleCall_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuffix2Access().getIDTerminalRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Suffix2_ELEMENT_TYPE = associate(Suffix2Factory.createSuffix2ElementType());

	public static final IGrammarAwareElementType Suffix2_Group_ELEMENT_TYPE = associate(Suffix2Factory.createSuffix2_GroupElementType());

	public static final IGrammarAwareElementType Suffix2_FullStopKeyword_0_ELEMENT_TYPE = associate(Suffix2Factory.createSuffix2_FullStopKeyword_0ElementType());

	public static final IGrammarAwareElementType Suffix2_IDTerminalRuleCall_1_ELEMENT_TYPE = associate(Suffix2Factory.createSuffix2_IDTerminalRuleCall_1ElementType());

	private static class FragmentWithActionFactory {
		public static IGrammarAwareElementType createFragmentWithActionElementType() {
			return new IGrammarAwareElementType("FragmentWithAction_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithActionRule());
		}
		public static IGrammarAwareElementType createFragmentWithAction_GroupElementType() {
			return new IGrammarAwareElementType("FragmentWithAction_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithActionAccess().getGroup());
		}
		public static IGrammarAwareElementType createFragmentWithAction_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction_NameAssignment_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithActionAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithActionAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction_PRFNamedWithActionPrevAction_1ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction_PRFNamedWithActionPrevAction_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithActionAccess().getPRFNamedWithActionPrevAction_1());
		}
		public static IGrammarAwareElementType createFragmentWithAction_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction_NameAssignment_2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithActionAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createFragmentWithAction_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithActionAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction_Ref2Assignment_3ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction_Ref2Assignment_3_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithActionAccess().getRef2Assignment_3());
		}
		public static IGrammarAwareElementType createFragmentWithAction_Ref2PRFNamedCrossReference_3_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction_Ref2PRFNamedCrossReference_3_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithActionAccess().getRef2PRFNamedCrossReference_3_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction_Ref2PRFNamedIDTerminalRuleCall_3_0_1ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction_Ref2PRFNamedIDTerminalRuleCall_3_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithActionAccess().getRef2PRFNamedIDTerminalRuleCall_3_0_1());
		}
	}

	public static final IGrammarAwareElementType FragmentWithAction_ELEMENT_TYPE = associate(FragmentWithActionFactory.createFragmentWithActionElementType());

	public static final IGrammarAwareElementType FragmentWithAction_Group_ELEMENT_TYPE = associate(FragmentWithActionFactory.createFragmentWithAction_GroupElementType());

	public static final IGrammarAwareElementType FragmentWithAction_NameAssignment_0_ELEMENT_TYPE = associate(FragmentWithActionFactory.createFragmentWithAction_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(FragmentWithActionFactory.createFragmentWithAction_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction_PRFNamedWithActionPrevAction_1_ELEMENT_TYPE = associate(FragmentWithActionFactory.createFragmentWithAction_PRFNamedWithActionPrevAction_1ElementType());

	public static final IGrammarAwareElementType FragmentWithAction_NameAssignment_2_ELEMENT_TYPE = associate(FragmentWithActionFactory.createFragmentWithAction_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType FragmentWithAction_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(FragmentWithActionFactory.createFragmentWithAction_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction_Ref2Assignment_3_ELEMENT_TYPE = associate(FragmentWithActionFactory.createFragmentWithAction_Ref2Assignment_3ElementType());

	public static final IGrammarAwareElementType FragmentWithAction_Ref2PRFNamedCrossReference_3_0_ELEMENT_TYPE = associate(FragmentWithActionFactory.createFragmentWithAction_Ref2PRFNamedCrossReference_3_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction_Ref2PRFNamedIDTerminalRuleCall_3_0_1_ELEMENT_TYPE = associate(FragmentWithActionFactory.createFragmentWithAction_Ref2PRFNamedIDTerminalRuleCall_3_0_1ElementType());

	private static class FragmentWithAction2Factory {
		public static IGrammarAwareElementType createFragmentWithAction2ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction2Rule());
		}
		public static IGrammarAwareElementType createFragmentWithAction2_GroupElementType() {
			return new IGrammarAwareElementType("FragmentWithAction2_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction2Access().getGroup());
		}
		public static IGrammarAwareElementType createFragmentWithAction2_PRFNamedWithActionPrevAction_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction2_PRFNamedWithActionPrevAction_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction2Access().getPRFNamedWithActionPrevAction_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction2_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction2_NameAssignment_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction2Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createFragmentWithAction2_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction2Access().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction2_Ref2Assignment_2ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction2_Ref2Assignment_2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction2Access().getRef2Assignment_2());
		}
		public static IGrammarAwareElementType createFragmentWithAction2_Ref2PRFNamedCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction2_Ref2PRFNamedCrossReference_2_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction2Access().getRef2PRFNamedCrossReference_2_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction2_Ref2PRFNamedIDTerminalRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction2_Ref2PRFNamedIDTerminalRuleCall_2_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction2Access().getRef2PRFNamedIDTerminalRuleCall_2_0_1());
		}
	}

	public static final IGrammarAwareElementType FragmentWithAction2_ELEMENT_TYPE = associate(FragmentWithAction2Factory.createFragmentWithAction2ElementType());

	public static final IGrammarAwareElementType FragmentWithAction2_Group_ELEMENT_TYPE = associate(FragmentWithAction2Factory.createFragmentWithAction2_GroupElementType());

	public static final IGrammarAwareElementType FragmentWithAction2_PRFNamedWithActionPrevAction_0_ELEMENT_TYPE = associate(FragmentWithAction2Factory.createFragmentWithAction2_PRFNamedWithActionPrevAction_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction2_NameAssignment_1_ELEMENT_TYPE = associate(FragmentWithAction2Factory.createFragmentWithAction2_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType FragmentWithAction2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(FragmentWithAction2Factory.createFragmentWithAction2_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction2_Ref2Assignment_2_ELEMENT_TYPE = associate(FragmentWithAction2Factory.createFragmentWithAction2_Ref2Assignment_2ElementType());

	public static final IGrammarAwareElementType FragmentWithAction2_Ref2PRFNamedCrossReference_2_0_ELEMENT_TYPE = associate(FragmentWithAction2Factory.createFragmentWithAction2_Ref2PRFNamedCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction2_Ref2PRFNamedIDTerminalRuleCall_2_0_1_ELEMENT_TYPE = associate(FragmentWithAction2Factory.createFragmentWithAction2_Ref2PRFNamedIDTerminalRuleCall_2_0_1ElementType());

	private static class FragmentWithAction3Factory {
		public static IGrammarAwareElementType createFragmentWithAction3ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Rule());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_GroupElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_Group_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getGroup());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_NameAssignment_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_Group_1ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_Group_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getGroup_1());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_PRFNamedWithActionPrevAction_1_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_PRFNamedWithActionPrevAction_1_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getPRFNamedWithActionPrevAction_1_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_HyphenMinusGreaterThanSignKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_HyphenMinusGreaterThanSignKeyword_1_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getHyphenMinusGreaterThanSignKeyword_1_1());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_NameAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_NameAssignment_1_2_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getNameAssignment_1_2());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_NameIDTerminalRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_NameIDTerminalRuleCall_1_2_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getNameIDTerminalRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_Ref2Assignment_1_3ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_Ref2Assignment_1_3_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getRef2Assignment_1_3());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_Ref2PRFNamedCrossReference_1_3_0ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_Ref2PRFNamedCrossReference_1_3_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getRef2PRFNamedCrossReference_1_3_0());
		}
		public static IGrammarAwareElementType createFragmentWithAction3_Ref2PRFNamedIDTerminalRuleCall_1_3_0_1ElementType() {
			return new IGrammarAwareElementType("FragmentWithAction3_Ref2PRFNamedIDTerminalRuleCall_1_3_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFragmentWithAction3Access().getRef2PRFNamedIDTerminalRuleCall_1_3_0_1());
		}
	}

	public static final IGrammarAwareElementType FragmentWithAction3_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3ElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_Group_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_GroupElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_NameAssignment_0_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_Group_1_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_Group_1ElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_PRFNamedWithActionPrevAction_1_0_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_PRFNamedWithActionPrevAction_1_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_HyphenMinusGreaterThanSignKeyword_1_1_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_HyphenMinusGreaterThanSignKeyword_1_1ElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_NameAssignment_1_2_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_NameAssignment_1_2ElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_NameIDTerminalRuleCall_1_2_0_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_NameIDTerminalRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_Ref2Assignment_1_3_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_Ref2Assignment_1_3ElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_Ref2PRFNamedCrossReference_1_3_0_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_Ref2PRFNamedCrossReference_1_3_0ElementType());

	public static final IGrammarAwareElementType FragmentWithAction3_Ref2PRFNamedIDTerminalRuleCall_1_3_0_1_ELEMENT_TYPE = associate(FragmentWithAction3Factory.createFragmentWithAction3_Ref2PRFNamedIDTerminalRuleCall_1_3_0_1ElementType());

	private static class PRFNamedFragmentFactory {
		public static IGrammarAwareElementType createPRFNamedFragmentElementType() {
			return new IGrammarAwareElementType("PRFNamedFragment_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedFragmentRule());
		}
		public static IGrammarAwareElementType createPRFNamedFragment_NameAssignmentElementType() {
			return new IGrammarAwareElementType("PRFNamedFragment_NameAssignment_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedFragmentAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createPRFNamedFragment_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedFragment_NameIDTerminalRuleCall_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedFragmentAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType PRFNamedFragment_ELEMENT_TYPE = associate(PRFNamedFragmentFactory.createPRFNamedFragmentElementType());

	public static final IGrammarAwareElementType PRFNamedFragment_NameAssignment_ELEMENT_TYPE = associate(PRFNamedFragmentFactory.createPRFNamedFragment_NameAssignmentElementType());

	public static final IGrammarAwareElementType PRFNamedFragment_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(PRFNamedFragmentFactory.createPRFNamedFragment_NameIDTerminalRuleCall_0ElementType());

	private static class PRFNamedRefFactory {
		public static IGrammarAwareElementType createPRFNamedRefElementType() {
			return new IGrammarAwareElementType("PRFNamedRef_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefRule());
		}
		public static IGrammarAwareElementType createPRFNamedRef_RefAssignmentElementType() {
			return new IGrammarAwareElementType("PRFNamedRef_RefAssignment_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefAccess().getRefAssignment());
		}
		public static IGrammarAwareElementType createPRFNamedRef_RefPRFNamedCrossReference_0ElementType() {
			return new IGrammarAwareElementType("PRFNamedRef_RefPRFNamedCrossReference_0_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefAccess().getRefPRFNamedCrossReference_0());
		}
		public static IGrammarAwareElementType createPRFNamedRef_RefPRFNamedIDTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("PRFNamedRef_RefPRFNamedIDTerminalRuleCall_0_1_ELEMENT_TYPE", FragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPRFNamedRefAccess().getRefPRFNamedIDTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType PRFNamedRef_ELEMENT_TYPE = associate(PRFNamedRefFactory.createPRFNamedRefElementType());

	public static final IGrammarAwareElementType PRFNamedRef_RefAssignment_ELEMENT_TYPE = associate(PRFNamedRefFactory.createPRFNamedRef_RefAssignmentElementType());

	public static final IGrammarAwareElementType PRFNamedRef_RefPRFNamedCrossReference_0_ELEMENT_TYPE = associate(PRFNamedRefFactory.createPRFNamedRef_RefPRFNamedCrossReference_0ElementType());

	public static final IGrammarAwareElementType PRFNamedRef_RefPRFNamedIDTerminalRuleCall_0_1_ELEMENT_TYPE = associate(PRFNamedRefFactory.createPRFNamedRef_RefPRFNamedIDTerminalRuleCall_0_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
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

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitFiveKeyword_1_4_0ElementType() {
		return ParserRuleFragments_NumberSignDigitFiveKeyword_1_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_4_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedWithActionInFragmentParserRuleCall_1_4_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedWithActionInFragmentParserRuleCall_1_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_5ElementType() {
		return ParserRuleFragments_Group_1_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitSixKeyword_1_5_0ElementType() {
		return ParserRuleFragments_NumberSignDigitSixKeyword_1_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_5_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedWithActionInFragment2ParserRuleCall_1_5_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedWithActionInFragment2ParserRuleCall_1_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_6ElementType() {
		return ParserRuleFragments_Group_1_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitSevenKeyword_1_6_0ElementType() {
		return ParserRuleFragments_NumberSignDigitSevenKeyword_1_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_6_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedWithActionInFragment3ParserRuleCall_1_6_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedWithActionInFragment3ParserRuleCall_1_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_Group_1_7ElementType() {
		return ParserRuleFragments_Group_1_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_NumberSignDigitEightKeyword_1_7_0ElementType() {
		return ParserRuleFragments_NumberSignDigitEightKeyword_1_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementAssignment_1_7_1ElementType() {
		return ParserRuleFragments_ElementAssignment_1_7_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_7_1_0ElementType() {
		return ParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_7_1_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getPRFNamedWithActionInFragmentElementType() {
		return PRFNamedWithActionInFragment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment_GroupElementType() {
		return PRFNamedWithActionInFragment_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment_FragmentWithActionParserRuleCall_0ElementType() {
		return PRFNamedWithActionInFragment_FragmentWithActionParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment_Group_1ElementType() {
		return PRFNamedWithActionInFragment_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment_HyphenMinusKeyword_1_0ElementType() {
		return PRFNamedWithActionInFragment_HyphenMinusKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment_RefAssignment_1_1ElementType() {
		return PRFNamedWithActionInFragment_RefAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment_RefPRFNamedCrossReference_1_1_0ElementType() {
		return PRFNamedWithActionInFragment_RefPRFNamedCrossReference_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment_RefPRFNamedIDTerminalRuleCall_1_1_0_1ElementType() {
		return PRFNamedWithActionInFragment_RefPRFNamedIDTerminalRuleCall_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment2ElementType() {
		return PRFNamedWithActionInFragment2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment2_GroupElementType() {
		return PRFNamedWithActionInFragment2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment2_NameAssignment_0ElementType() {
		return PRFNamedWithActionInFragment2_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment2_NameIDTerminalRuleCall_0_0ElementType() {
		return PRFNamedWithActionInFragment2_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment2_FragmentWithAction2ParserRuleCall_1ElementType() {
		return PRFNamedWithActionInFragment2_FragmentWithAction2ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment2_Group_2ElementType() {
		return PRFNamedWithActionInFragment2_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment2_HyphenMinusKeyword_2_0ElementType() {
		return PRFNamedWithActionInFragment2_HyphenMinusKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment2_RefAssignment_2_1ElementType() {
		return PRFNamedWithActionInFragment2_RefAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment2_RefPRFNamedCrossReference_2_1_0ElementType() {
		return PRFNamedWithActionInFragment2_RefPRFNamedCrossReference_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment2_RefPRFNamedIDTerminalRuleCall_2_1_0_1ElementType() {
		return PRFNamedWithActionInFragment2_RefPRFNamedIDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment3ElementType() {
		return PRFNamedWithActionInFragment3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment3_GroupElementType() {
		return PRFNamedWithActionInFragment3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment3_FragmentWithAction3ParserRuleCall_0ElementType() {
		return PRFNamedWithActionInFragment3_FragmentWithAction3ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment3_Group_1ElementType() {
		return PRFNamedWithActionInFragment3_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment3_HyphenMinusKeyword_1_0ElementType() {
		return PRFNamedWithActionInFragment3_HyphenMinusKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment3_RefAssignment_1_1ElementType() {
		return PRFNamedWithActionInFragment3_RefAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment3_RefPRFNamedCrossReference_1_1_0ElementType() {
		return PRFNamedWithActionInFragment3_RefPRFNamedCrossReference_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPRFNamedWithActionInFragment3_RefPRFNamedIDTerminalRuleCall_1_1_0_1ElementType() {
		return PRFNamedWithActionInFragment3_RefPRFNamedIDTerminalRuleCall_1_1_0_1_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getFragmentWithActionElementType() {
		return FragmentWithAction_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction_GroupElementType() {
		return FragmentWithAction_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction_NameAssignment_0ElementType() {
		return FragmentWithAction_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction_NameIDTerminalRuleCall_0_0ElementType() {
		return FragmentWithAction_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction_PRFNamedWithActionPrevAction_1ElementType() {
		return FragmentWithAction_PRFNamedWithActionPrevAction_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction_NameAssignment_2ElementType() {
		return FragmentWithAction_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction_NameIDTerminalRuleCall_2_0ElementType() {
		return FragmentWithAction_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction_Ref2Assignment_3ElementType() {
		return FragmentWithAction_Ref2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction_Ref2PRFNamedCrossReference_3_0ElementType() {
		return FragmentWithAction_Ref2PRFNamedCrossReference_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction_Ref2PRFNamedIDTerminalRuleCall_3_0_1ElementType() {
		return FragmentWithAction_Ref2PRFNamedIDTerminalRuleCall_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction2ElementType() {
		return FragmentWithAction2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction2_GroupElementType() {
		return FragmentWithAction2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction2_PRFNamedWithActionPrevAction_0ElementType() {
		return FragmentWithAction2_PRFNamedWithActionPrevAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction2_NameAssignment_1ElementType() {
		return FragmentWithAction2_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction2_NameIDTerminalRuleCall_1_0ElementType() {
		return FragmentWithAction2_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction2_Ref2Assignment_2ElementType() {
		return FragmentWithAction2_Ref2Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction2_Ref2PRFNamedCrossReference_2_0ElementType() {
		return FragmentWithAction2_Ref2PRFNamedCrossReference_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction2_Ref2PRFNamedIDTerminalRuleCall_2_0_1ElementType() {
		return FragmentWithAction2_Ref2PRFNamedIDTerminalRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3ElementType() {
		return FragmentWithAction3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_GroupElementType() {
		return FragmentWithAction3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_NameAssignment_0ElementType() {
		return FragmentWithAction3_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_NameIDTerminalRuleCall_0_0ElementType() {
		return FragmentWithAction3_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_Group_1ElementType() {
		return FragmentWithAction3_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_PRFNamedWithActionPrevAction_1_0ElementType() {
		return FragmentWithAction3_PRFNamedWithActionPrevAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_HyphenMinusGreaterThanSignKeyword_1_1ElementType() {
		return FragmentWithAction3_HyphenMinusGreaterThanSignKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_NameAssignment_1_2ElementType() {
		return FragmentWithAction3_NameAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_NameIDTerminalRuleCall_1_2_0ElementType() {
		return FragmentWithAction3_NameIDTerminalRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_Ref2Assignment_1_3ElementType() {
		return FragmentWithAction3_Ref2Assignment_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_Ref2PRFNamedCrossReference_1_3_0ElementType() {
		return FragmentWithAction3_Ref2PRFNamedCrossReference_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFragmentWithAction3_Ref2PRFNamedIDTerminalRuleCall_1_3_0_1ElementType() {
		return FragmentWithAction3_Ref2PRFNamedIDTerminalRuleCall_1_3_0_1_ELEMENT_TYPE;
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

}
