package org.eclipse.xtext.parser.antlr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.lang.psi.impl.Bug378967TestLanguageFileImpl;
import org.eclipse.xtext.parser.antlr.services.Bug378967TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug378967TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug378967TestLanguageFileImpl>>(Bug378967TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug378967TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug378967TestLanguageLanguage.INSTANCE.getInstance(Bug378967TestLanguageGrammarAccess.class);

	private static class RootFactory {
		public static IGrammarAwareElementType createRootElementType() {
			return new IGrammarAwareElementType("Root_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRule());
		}
		public static IGrammarAwareElementType createRoot_AlternativesElementType() {
			return new IGrammarAwareElementType("Root_Alternatives_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createRoot_Group_0ElementType() {
			return new IGrammarAwareElementType("Root_Group_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createRoot_DigitOneKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Root_DigitOneKeyword_0_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getDigitOneKeyword_0_0());
		}
		public static IGrammarAwareElementType createRoot_ElementAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Root_ElementAssignment_0_1_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getElementAssignment_0_1());
		}
		public static IGrammarAwareElementType createRoot_ElementRule1ParserRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Root_ElementRule1ParserRuleCall_0_1_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getElementRule1ParserRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createRoot_Group_1ElementType() {
			return new IGrammarAwareElementType("Root_Group_1_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createRoot_DigitTwoKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Root_DigitTwoKeyword_1_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getDigitTwoKeyword_1_0());
		}
		public static IGrammarAwareElementType createRoot_ElementAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Root_ElementAssignment_1_1_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getElementAssignment_1_1());
		}
		public static IGrammarAwareElementType createRoot_ElementRule2ParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Root_ElementRule2ParserRuleCall_1_1_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getElementRule2ParserRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createRoot_Group_2ElementType() {
			return new IGrammarAwareElementType("Root_Group_2_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createRoot_DigitThreeKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Root_DigitThreeKeyword_2_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getDigitThreeKeyword_2_0());
		}
		public static IGrammarAwareElementType createRoot_ElementAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Root_ElementAssignment_2_1_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getElementAssignment_2_1());
		}
		public static IGrammarAwareElementType createRoot_ElementRule3ParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Root_ElementRule3ParserRuleCall_2_1_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getElementRule3ParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createRoot_Group_3ElementType() {
			return new IGrammarAwareElementType("Root_Group_3_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createRoot_DigitFourKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Root_DigitFourKeyword_3_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getDigitFourKeyword_3_0());
		}
		public static IGrammarAwareElementType createRoot_ElementAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Root_ElementAssignment_3_1_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getElementAssignment_3_1());
		}
		public static IGrammarAwareElementType createRoot_ElementRule4ParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Root_ElementRule4ParserRuleCall_3_1_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getElementRule4ParserRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType Root_ELEMENT_TYPE = associate(RootFactory.createRootElementType());

	public static final IGrammarAwareElementType Root_Alternatives_ELEMENT_TYPE = associate(RootFactory.createRoot_AlternativesElementType());

	public static final IGrammarAwareElementType Root_Group_0_ELEMENT_TYPE = associate(RootFactory.createRoot_Group_0ElementType());

	public static final IGrammarAwareElementType Root_DigitOneKeyword_0_0_ELEMENT_TYPE = associate(RootFactory.createRoot_DigitOneKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Root_ElementAssignment_0_1_ELEMENT_TYPE = associate(RootFactory.createRoot_ElementAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Root_ElementRule1ParserRuleCall_0_1_0_ELEMENT_TYPE = associate(RootFactory.createRoot_ElementRule1ParserRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Root_Group_1_ELEMENT_TYPE = associate(RootFactory.createRoot_Group_1ElementType());

	public static final IGrammarAwareElementType Root_DigitTwoKeyword_1_0_ELEMENT_TYPE = associate(RootFactory.createRoot_DigitTwoKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Root_ElementAssignment_1_1_ELEMENT_TYPE = associate(RootFactory.createRoot_ElementAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Root_ElementRule2ParserRuleCall_1_1_0_ELEMENT_TYPE = associate(RootFactory.createRoot_ElementRule2ParserRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Root_Group_2_ELEMENT_TYPE = associate(RootFactory.createRoot_Group_2ElementType());

	public static final IGrammarAwareElementType Root_DigitThreeKeyword_2_0_ELEMENT_TYPE = associate(RootFactory.createRoot_DigitThreeKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Root_ElementAssignment_2_1_ELEMENT_TYPE = associate(RootFactory.createRoot_ElementAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Root_ElementRule3ParserRuleCall_2_1_0_ELEMENT_TYPE = associate(RootFactory.createRoot_ElementRule3ParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Root_Group_3_ELEMENT_TYPE = associate(RootFactory.createRoot_Group_3ElementType());

	public static final IGrammarAwareElementType Root_DigitFourKeyword_3_0_ELEMENT_TYPE = associate(RootFactory.createRoot_DigitFourKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Root_ElementAssignment_3_1_ELEMENT_TYPE = associate(RootFactory.createRoot_ElementAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Root_ElementRule4ParserRuleCall_3_1_0_ELEMENT_TYPE = associate(RootFactory.createRoot_ElementRule4ParserRuleCall_3_1_0ElementType());

	private static class Rule1Factory {
		public static IGrammarAwareElementType createRule1ElementType() {
			return new IGrammarAwareElementType("Rule1_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule1Rule());
		}
		public static IGrammarAwareElementType createRule1_GroupElementType() {
			return new IGrammarAwareElementType("Rule1_Group_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule1Access().getGroup());
		}
		public static IGrammarAwareElementType createRule1_TypeAssignment_0ElementType() {
			return new IGrammarAwareElementType("Rule1_TypeAssignment_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule1Access().getTypeAssignment_0());
		}
		public static IGrammarAwareElementType createRule1_TypeFirstEnumEnumRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Rule1_TypeFirstEnumEnumRuleCall_0_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule1Access().getTypeFirstEnumEnumRuleCall_0_0());
		}
		public static IGrammarAwareElementType createRule1_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("Rule1_ValueAssignment_1_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule1Access().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createRule1_ValueINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Rule1_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule1Access().getValueINTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createRule1_UnitAssignment_2ElementType() {
			return new IGrammarAwareElementType("Rule1_UnitAssignment_2_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule1Access().getUnitAssignment_2());
		}
		public static IGrammarAwareElementType createRule1_UnitSecondEnumEnumRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Rule1_UnitSecondEnumEnumRuleCall_2_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule1Access().getUnitSecondEnumEnumRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Rule1_ELEMENT_TYPE = associate(Rule1Factory.createRule1ElementType());

	public static final IGrammarAwareElementType Rule1_Group_ELEMENT_TYPE = associate(Rule1Factory.createRule1_GroupElementType());

	public static final IGrammarAwareElementType Rule1_TypeAssignment_0_ELEMENT_TYPE = associate(Rule1Factory.createRule1_TypeAssignment_0ElementType());

	public static final IGrammarAwareElementType Rule1_TypeFirstEnumEnumRuleCall_0_0_ELEMENT_TYPE = associate(Rule1Factory.createRule1_TypeFirstEnumEnumRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Rule1_ValueAssignment_1_ELEMENT_TYPE = associate(Rule1Factory.createRule1_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType Rule1_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Rule1Factory.createRule1_ValueINTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Rule1_UnitAssignment_2_ELEMENT_TYPE = associate(Rule1Factory.createRule1_UnitAssignment_2ElementType());

	public static final IGrammarAwareElementType Rule1_UnitSecondEnumEnumRuleCall_2_0_ELEMENT_TYPE = associate(Rule1Factory.createRule1_UnitSecondEnumEnumRuleCall_2_0ElementType());

	private static class Rule2Factory {
		public static IGrammarAwareElementType createRule2ElementType() {
			return new IGrammarAwareElementType("Rule2_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule2Rule());
		}
		public static IGrammarAwareElementType createRule2_GroupElementType() {
			return new IGrammarAwareElementType("Rule2_Group_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule2Access().getGroup());
		}
		public static IGrammarAwareElementType createRule2_AfterKeyword_0ElementType() {
			return new IGrammarAwareElementType("Rule2_AfterKeyword_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule2Access().getAfterKeyword_0());
		}
		public static IGrammarAwareElementType createRule2_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("Rule2_ValueAssignment_1_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule2Access().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createRule2_ValueINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Rule2_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule2Access().getValueINTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createRule2_SKeyword_2ElementType() {
			return new IGrammarAwareElementType("Rule2_SKeyword_2_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule2Access().getSKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Rule2_ELEMENT_TYPE = associate(Rule2Factory.createRule2ElementType());

	public static final IGrammarAwareElementType Rule2_Group_ELEMENT_TYPE = associate(Rule2Factory.createRule2_GroupElementType());

	public static final IGrammarAwareElementType Rule2_AfterKeyword_0_ELEMENT_TYPE = associate(Rule2Factory.createRule2_AfterKeyword_0ElementType());

	public static final IGrammarAwareElementType Rule2_ValueAssignment_1_ELEMENT_TYPE = associate(Rule2Factory.createRule2_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType Rule2_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Rule2Factory.createRule2_ValueINTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Rule2_SKeyword_2_ELEMENT_TYPE = associate(Rule2Factory.createRule2_SKeyword_2ElementType());

	private static class Rule3Factory {
		public static IGrammarAwareElementType createRule3ElementType() {
			return new IGrammarAwareElementType("Rule3_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule3Rule());
		}
		public static IGrammarAwareElementType createRule3_GroupElementType() {
			return new IGrammarAwareElementType("Rule3_Group_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule3Access().getGroup());
		}
		public static IGrammarAwareElementType createRule3_AfterParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Rule3_AfterParserRuleCall_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule3Access().getAfterParserRuleCall_0());
		}
		public static IGrammarAwareElementType createRule3_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("Rule3_ValueAssignment_1_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule3Access().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createRule3_ValueINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Rule3_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule3Access().getValueINTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createRule3_SParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Rule3_SParserRuleCall_2_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule3Access().getSParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType Rule3_ELEMENT_TYPE = associate(Rule3Factory.createRule3ElementType());

	public static final IGrammarAwareElementType Rule3_Group_ELEMENT_TYPE = associate(Rule3Factory.createRule3_GroupElementType());

	public static final IGrammarAwareElementType Rule3_AfterParserRuleCall_0_ELEMENT_TYPE = associate(Rule3Factory.createRule3_AfterParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Rule3_ValueAssignment_1_ELEMENT_TYPE = associate(Rule3Factory.createRule3_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType Rule3_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Rule3Factory.createRule3_ValueINTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Rule3_SParserRuleCall_2_ELEMENT_TYPE = associate(Rule3Factory.createRule3_SParserRuleCall_2ElementType());

	private static class Rule4Factory {
		public static IGrammarAwareElementType createRule4ElementType() {
			return new IGrammarAwareElementType("Rule4_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule4Rule());
		}
		public static IGrammarAwareElementType createRule4_GroupElementType() {
			return new IGrammarAwareElementType("Rule4_Group_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule4Access().getGroup());
		}
		public static IGrammarAwareElementType createRule4_AfterAssignment_0ElementType() {
			return new IGrammarAwareElementType("Rule4_AfterAssignment_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule4Access().getAfterAssignment_0());
		}
		public static IGrammarAwareElementType createRule4_AfterAfterObjParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Rule4_AfterAfterObjParserRuleCall_0_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule4Access().getAfterAfterObjParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createRule4_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("Rule4_ValueAssignment_1_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule4Access().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createRule4_ValueINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Rule4_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule4Access().getValueINTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createRule4_SAssignment_2ElementType() {
			return new IGrammarAwareElementType("Rule4_SAssignment_2_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule4Access().getSAssignment_2());
		}
		public static IGrammarAwareElementType createRule4_SSObjParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Rule4_SSObjParserRuleCall_2_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRule4Access().getSSObjParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Rule4_ELEMENT_TYPE = associate(Rule4Factory.createRule4ElementType());

	public static final IGrammarAwareElementType Rule4_Group_ELEMENT_TYPE = associate(Rule4Factory.createRule4_GroupElementType());

	public static final IGrammarAwareElementType Rule4_AfterAssignment_0_ELEMENT_TYPE = associate(Rule4Factory.createRule4_AfterAssignment_0ElementType());

	public static final IGrammarAwareElementType Rule4_AfterAfterObjParserRuleCall_0_0_ELEMENT_TYPE = associate(Rule4Factory.createRule4_AfterAfterObjParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Rule4_ValueAssignment_1_ELEMENT_TYPE = associate(Rule4Factory.createRule4_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType Rule4_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Rule4Factory.createRule4_ValueINTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Rule4_SAssignment_2_ELEMENT_TYPE = associate(Rule4Factory.createRule4_SAssignment_2ElementType());

	public static final IGrammarAwareElementType Rule4_SSObjParserRuleCall_2_0_ELEMENT_TYPE = associate(Rule4Factory.createRule4_SSObjParserRuleCall_2_0ElementType());

	private static class FirstEnumFactory {
		public static IGrammarAwareElementType createFirstEnumElementType() {
			return new IGrammarAwareElementType("FirstEnum_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstEnumRule());
		}
		public static IGrammarAwareElementType createFirstEnum_ValueEnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("FirstEnum_ValueEnumLiteralDeclaration_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstEnumAccess().getValueEnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createFirstEnum_ValueAfterKeyword_0ElementType() {
			return new IGrammarAwareElementType("FirstEnum_ValueAfterKeyword_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstEnumAccess().getValueAfterKeyword_0());
		}
	}

	public static final IGrammarAwareElementType FirstEnum_ELEMENT_TYPE = associate(FirstEnumFactory.createFirstEnumElementType());

	public static final IGrammarAwareElementType FirstEnum_ValueEnumLiteralDeclaration_ELEMENT_TYPE = associate(FirstEnumFactory.createFirstEnum_ValueEnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType FirstEnum_ValueAfterKeyword_0_ELEMENT_TYPE = associate(FirstEnumFactory.createFirstEnum_ValueAfterKeyword_0ElementType());

	private static class SecondEnumFactory {
		public static IGrammarAwareElementType createSecondEnumElementType() {
			return new IGrammarAwareElementType("SecondEnum_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondEnumRule());
		}
		public static IGrammarAwareElementType createSecondEnum_ValueEnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("SecondEnum_ValueEnumLiteralDeclaration_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondEnumAccess().getValueEnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createSecondEnum_ValueSKeyword_0ElementType() {
			return new IGrammarAwareElementType("SecondEnum_ValueSKeyword_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondEnumAccess().getValueSKeyword_0());
		}
	}

	public static final IGrammarAwareElementType SecondEnum_ELEMENT_TYPE = associate(SecondEnumFactory.createSecondEnumElementType());

	public static final IGrammarAwareElementType SecondEnum_ValueEnumLiteralDeclaration_ELEMENT_TYPE = associate(SecondEnumFactory.createSecondEnum_ValueEnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType SecondEnum_ValueSKeyword_0_ELEMENT_TYPE = associate(SecondEnumFactory.createSecondEnum_ValueSKeyword_0ElementType());

	private static class AfterObjFactory {
		public static IGrammarAwareElementType createAfterObjElementType() {
			return new IGrammarAwareElementType("AfterObj_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAfterObjRule());
		}
		public static IGrammarAwareElementType createAfterObj_ValueAssignmentElementType() {
			return new IGrammarAwareElementType("AfterObj_ValueAssignment_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAfterObjAccess().getValueAssignment());
		}
		public static IGrammarAwareElementType createAfterObj_ValueAfterKeyword_0ElementType() {
			return new IGrammarAwareElementType("AfterObj_ValueAfterKeyword_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAfterObjAccess().getValueAfterKeyword_0());
		}
	}

	public static final IGrammarAwareElementType AfterObj_ELEMENT_TYPE = associate(AfterObjFactory.createAfterObjElementType());

	public static final IGrammarAwareElementType AfterObj_ValueAssignment_ELEMENT_TYPE = associate(AfterObjFactory.createAfterObj_ValueAssignmentElementType());

	public static final IGrammarAwareElementType AfterObj_ValueAfterKeyword_0_ELEMENT_TYPE = associate(AfterObjFactory.createAfterObj_ValueAfterKeyword_0ElementType());

	private static class SObjFactory {
		public static IGrammarAwareElementType createSObjElementType() {
			return new IGrammarAwareElementType("SObj_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSObjRule());
		}
		public static IGrammarAwareElementType createSObj_ValueAssignmentElementType() {
			return new IGrammarAwareElementType("SObj_ValueAssignment_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSObjAccess().getValueAssignment());
		}
		public static IGrammarAwareElementType createSObj_ValueSKeyword_0ElementType() {
			return new IGrammarAwareElementType("SObj_ValueSKeyword_0_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSObjAccess().getValueSKeyword_0());
		}
	}

	public static final IGrammarAwareElementType SObj_ELEMENT_TYPE = associate(SObjFactory.createSObjElementType());

	public static final IGrammarAwareElementType SObj_ValueAssignment_ELEMENT_TYPE = associate(SObjFactory.createSObj_ValueAssignmentElementType());

	public static final IGrammarAwareElementType SObj_ValueSKeyword_0_ELEMENT_TYPE = associate(SObjFactory.createSObj_ValueSKeyword_0ElementType());

	private static class AfterFactory {
		public static IGrammarAwareElementType createAfterElementType() {
			return new IGrammarAwareElementType("After_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAfterRule());
		}
		public static IGrammarAwareElementType createAfter_AfterKeywordElementType() {
			return new IGrammarAwareElementType("After_AfterKeyword_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAfterAccess().getAfterKeyword());
		}
	}

	public static final IGrammarAwareElementType After_ELEMENT_TYPE = associate(AfterFactory.createAfterElementType());

	public static final IGrammarAwareElementType After_AfterKeyword_ELEMENT_TYPE = associate(AfterFactory.createAfter_AfterKeywordElementType());

	private static class SFactory {
		public static IGrammarAwareElementType createSElementType() {
			return new IGrammarAwareElementType("S_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSRule());
		}
		public static IGrammarAwareElementType createS_SKeywordElementType() {
			return new IGrammarAwareElementType("S_SKeyword_ELEMENT_TYPE", Bug378967TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSAccess().getSKeyword());
		}
	}

	public static final IGrammarAwareElementType S_ELEMENT_TYPE = associate(SFactory.createSElementType());

	public static final IGrammarAwareElementType S_SKeyword_ELEMENT_TYPE = associate(SFactory.createS_SKeywordElementType());

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

	public IGrammarAwareElementType getRoot_AlternativesElementType() {
		return Root_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_Group_0ElementType() {
		return Root_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_DigitOneKeyword_0_0ElementType() {
		return Root_DigitOneKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ElementAssignment_0_1ElementType() {
		return Root_ElementAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ElementRule1ParserRuleCall_0_1_0ElementType() {
		return Root_ElementRule1ParserRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_Group_1ElementType() {
		return Root_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_DigitTwoKeyword_1_0ElementType() {
		return Root_DigitTwoKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ElementAssignment_1_1ElementType() {
		return Root_ElementAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ElementRule2ParserRuleCall_1_1_0ElementType() {
		return Root_ElementRule2ParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_Group_2ElementType() {
		return Root_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_DigitThreeKeyword_2_0ElementType() {
		return Root_DigitThreeKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ElementAssignment_2_1ElementType() {
		return Root_ElementAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ElementRule3ParserRuleCall_2_1_0ElementType() {
		return Root_ElementRule3ParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_Group_3ElementType() {
		return Root_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_DigitFourKeyword_3_0ElementType() {
		return Root_DigitFourKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ElementAssignment_3_1ElementType() {
		return Root_ElementAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ElementRule4ParserRuleCall_3_1_0ElementType() {
		return Root_ElementRule4ParserRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule1ElementType() {
		return Rule1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule1_GroupElementType() {
		return Rule1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule1_TypeAssignment_0ElementType() {
		return Rule1_TypeAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule1_TypeFirstEnumEnumRuleCall_0_0ElementType() {
		return Rule1_TypeFirstEnumEnumRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule1_ValueAssignment_1ElementType() {
		return Rule1_ValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule1_ValueINTTerminalRuleCall_1_0ElementType() {
		return Rule1_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule1_UnitAssignment_2ElementType() {
		return Rule1_UnitAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule1_UnitSecondEnumEnumRuleCall_2_0ElementType() {
		return Rule1_UnitSecondEnumEnumRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule2ElementType() {
		return Rule2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule2_GroupElementType() {
		return Rule2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule2_AfterKeyword_0ElementType() {
		return Rule2_AfterKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule2_ValueAssignment_1ElementType() {
		return Rule2_ValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule2_ValueINTTerminalRuleCall_1_0ElementType() {
		return Rule2_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule2_SKeyword_2ElementType() {
		return Rule2_SKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule3ElementType() {
		return Rule3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule3_GroupElementType() {
		return Rule3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule3_AfterParserRuleCall_0ElementType() {
		return Rule3_AfterParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule3_ValueAssignment_1ElementType() {
		return Rule3_ValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule3_ValueINTTerminalRuleCall_1_0ElementType() {
		return Rule3_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule3_SParserRuleCall_2ElementType() {
		return Rule3_SParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule4ElementType() {
		return Rule4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule4_GroupElementType() {
		return Rule4_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule4_AfterAssignment_0ElementType() {
		return Rule4_AfterAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule4_AfterAfterObjParserRuleCall_0_0ElementType() {
		return Rule4_AfterAfterObjParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule4_ValueAssignment_1ElementType() {
		return Rule4_ValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule4_ValueINTTerminalRuleCall_1_0ElementType() {
		return Rule4_ValueINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule4_SAssignment_2ElementType() {
		return Rule4_SAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRule4_SSObjParserRuleCall_2_0ElementType() {
		return Rule4_SSObjParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstEnumElementType() {
		return FirstEnum_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstEnum_ValueEnumLiteralDeclarationElementType() {
		return FirstEnum_ValueEnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstEnum_ValueAfterKeyword_0ElementType() {
		return FirstEnum_ValueAfterKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondEnumElementType() {
		return SecondEnum_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondEnum_ValueEnumLiteralDeclarationElementType() {
		return SecondEnum_ValueEnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondEnum_ValueSKeyword_0ElementType() {
		return SecondEnum_ValueSKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAfterObjElementType() {
		return AfterObj_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAfterObj_ValueAssignmentElementType() {
		return AfterObj_ValueAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAfterObj_ValueAfterKeyword_0ElementType() {
		return AfterObj_ValueAfterKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSObjElementType() {
		return SObj_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSObj_ValueAssignmentElementType() {
		return SObj_ValueAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSObj_ValueSKeyword_0ElementType() {
		return SObj_ValueSKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAfterElementType() {
		return After_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAfter_AfterKeywordElementType() {
		return After_AfterKeyword_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSElementType() {
		return S_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getS_SKeywordElementType() {
		return S_SKeyword_ELEMENT_TYPE;
	}

}
