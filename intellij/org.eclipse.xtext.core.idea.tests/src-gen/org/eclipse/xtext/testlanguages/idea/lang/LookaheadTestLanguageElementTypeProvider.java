package org.eclipse.xtext.testlanguages.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.LookaheadTestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class LookaheadTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<LookaheadTestLanguageFileImpl>>(LookaheadTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final LookaheadTestLanguageGrammarAccess GRAMMAR_ACCESS = LookaheadTestLanguageLanguage.INSTANCE.getInstance(LookaheadTestLanguageGrammarAccess.class);

	private static class EntryFactory {
		public static IGrammarAwareElementType createEntryElementType() {
			return new IGrammarAwareElementType("Entry_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntryRule());
		}
		public static IGrammarAwareElementType createEntry_ContentsAssignmentElementType() {
			return new IGrammarAwareElementType("Entry_ContentsAssignment_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntryAccess().getContentsAssignment());
		}
		public static IGrammarAwareElementType createEntry_ContentsAltsParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Entry_ContentsAltsParserRuleCall_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntryAccess().getContentsAltsParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Entry_ELEMENT_TYPE = associate(EntryFactory.createEntryElementType());

	public static final IGrammarAwareElementType Entry_ContentsAssignment_ELEMENT_TYPE = associate(EntryFactory.createEntry_ContentsAssignmentElementType());

	public static final IGrammarAwareElementType Entry_ContentsAltsParserRuleCall_0_ELEMENT_TYPE = associate(EntryFactory.createEntry_ContentsAltsParserRuleCall_0ElementType());

	private static class AltsFactory {
		public static IGrammarAwareElementType createAltsElementType() {
			return new IGrammarAwareElementType("Alts_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltsRule());
		}
		public static IGrammarAwareElementType createAlts_AlternativesElementType() {
			return new IGrammarAwareElementType("Alts_Alternatives_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltsAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAlts_LookAhead0ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Alts_LookAhead0ParserRuleCall_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltsAccess().getLookAhead0ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAlts_LookAhead1ParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Alts_LookAhead1ParserRuleCall_1_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltsAccess().getLookAhead1ParserRuleCall_1());
		}
		public static IGrammarAwareElementType createAlts_LookAhead3ParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Alts_LookAhead3ParserRuleCall_2_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAltsAccess().getLookAhead3ParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType Alts_ELEMENT_TYPE = associate(AltsFactory.createAltsElementType());

	public static final IGrammarAwareElementType Alts_Alternatives_ELEMENT_TYPE = associate(AltsFactory.createAlts_AlternativesElementType());

	public static final IGrammarAwareElementType Alts_LookAhead0ParserRuleCall_0_ELEMENT_TYPE = associate(AltsFactory.createAlts_LookAhead0ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Alts_LookAhead1ParserRuleCall_1_ELEMENT_TYPE = associate(AltsFactory.createAlts_LookAhead1ParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Alts_LookAhead3ParserRuleCall_2_ELEMENT_TYPE = associate(AltsFactory.createAlts_LookAhead3ParserRuleCall_2ElementType());

	private static class LookAhead0Factory {
		public static IGrammarAwareElementType createLookAhead0ElementType() {
			return new IGrammarAwareElementType("LookAhead0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead0Rule());
		}
		public static IGrammarAwareElementType createLookAhead0_GroupElementType() {
			return new IGrammarAwareElementType("LookAhead0_Group_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead0Access().getGroup());
		}
		public static IGrammarAwareElementType createLookAhead0_BarKeyword_0ElementType() {
			return new IGrammarAwareElementType("LookAhead0_BarKeyword_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead0Access().getBarKeyword_0());
		}
		public static IGrammarAwareElementType createLookAhead0_XAssignment_1ElementType() {
			return new IGrammarAwareElementType("LookAhead0_XAssignment_1_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead0Access().getXAssignment_1());
		}
		public static IGrammarAwareElementType createLookAhead0_XAKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("LookAhead0_XAKeyword_1_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead0Access().getXAKeyword_1_0());
		}
	}

	public static final IGrammarAwareElementType LookAhead0_ELEMENT_TYPE = associate(LookAhead0Factory.createLookAhead0ElementType());

	public static final IGrammarAwareElementType LookAhead0_Group_ELEMENT_TYPE = associate(LookAhead0Factory.createLookAhead0_GroupElementType());

	public static final IGrammarAwareElementType LookAhead0_BarKeyword_0_ELEMENT_TYPE = associate(LookAhead0Factory.createLookAhead0_BarKeyword_0ElementType());

	public static final IGrammarAwareElementType LookAhead0_XAssignment_1_ELEMENT_TYPE = associate(LookAhead0Factory.createLookAhead0_XAssignment_1ElementType());

	public static final IGrammarAwareElementType LookAhead0_XAKeyword_1_0_ELEMENT_TYPE = associate(LookAhead0Factory.createLookAhead0_XAKeyword_1_0ElementType());

	private static class LookAhead1Factory {
		public static IGrammarAwareElementType createLookAhead1ElementType() {
			return new IGrammarAwareElementType("LookAhead1_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead1Rule());
		}
		public static IGrammarAwareElementType createLookAhead1_GroupElementType() {
			return new IGrammarAwareElementType("LookAhead1_Group_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead1Access().getGroup());
		}
		public static IGrammarAwareElementType createLookAhead1_FooKeyword_0ElementType() {
			return new IGrammarAwareElementType("LookAhead1_FooKeyword_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead1Access().getFooKeyword_0());
		}
		public static IGrammarAwareElementType createLookAhead1_YAssignment_1ElementType() {
			return new IGrammarAwareElementType("LookAhead1_YAssignment_1_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead1Access().getYAssignment_1());
		}
		public static IGrammarAwareElementType createLookAhead1_YLookAhead2ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("LookAhead1_YLookAhead2ParserRuleCall_1_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead1Access().getYLookAhead2ParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createLookAhead1_XAssignment_2ElementType() {
			return new IGrammarAwareElementType("LookAhead1_XAssignment_2_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead1Access().getXAssignment_2());
		}
		public static IGrammarAwareElementType createLookAhead1_XBKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("LookAhead1_XBKeyword_2_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead1Access().getXBKeyword_2_0());
		}
		public static IGrammarAwareElementType createLookAhead1_ZAssignment_3ElementType() {
			return new IGrammarAwareElementType("LookAhead1_ZAssignment_3_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead1Access().getZAssignment_3());
		}
		public static IGrammarAwareElementType createLookAhead1_ZDKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("LookAhead1_ZDKeyword_3_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead1Access().getZDKeyword_3_0());
		}
	}

	public static final IGrammarAwareElementType LookAhead1_ELEMENT_TYPE = associate(LookAhead1Factory.createLookAhead1ElementType());

	public static final IGrammarAwareElementType LookAhead1_Group_ELEMENT_TYPE = associate(LookAhead1Factory.createLookAhead1_GroupElementType());

	public static final IGrammarAwareElementType LookAhead1_FooKeyword_0_ELEMENT_TYPE = associate(LookAhead1Factory.createLookAhead1_FooKeyword_0ElementType());

	public static final IGrammarAwareElementType LookAhead1_YAssignment_1_ELEMENT_TYPE = associate(LookAhead1Factory.createLookAhead1_YAssignment_1ElementType());

	public static final IGrammarAwareElementType LookAhead1_YLookAhead2ParserRuleCall_1_0_ELEMENT_TYPE = associate(LookAhead1Factory.createLookAhead1_YLookAhead2ParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType LookAhead1_XAssignment_2_ELEMENT_TYPE = associate(LookAhead1Factory.createLookAhead1_XAssignment_2ElementType());

	public static final IGrammarAwareElementType LookAhead1_XBKeyword_2_0_ELEMENT_TYPE = associate(LookAhead1Factory.createLookAhead1_XBKeyword_2_0ElementType());

	public static final IGrammarAwareElementType LookAhead1_ZAssignment_3_ELEMENT_TYPE = associate(LookAhead1Factory.createLookAhead1_ZAssignment_3ElementType());

	public static final IGrammarAwareElementType LookAhead1_ZDKeyword_3_0_ELEMENT_TYPE = associate(LookAhead1Factory.createLookAhead1_ZDKeyword_3_0ElementType());

	private static class LookAhead2Factory {
		public static IGrammarAwareElementType createLookAhead2ElementType() {
			return new IGrammarAwareElementType("LookAhead2_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead2Rule());
		}
		public static IGrammarAwareElementType createLookAhead2_GroupElementType() {
			return new IGrammarAwareElementType("LookAhead2_Group_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead2Access().getGroup());
		}
		public static IGrammarAwareElementType createLookAhead2_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("LookAhead2_Alternatives_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead2Access().getAlternatives_0());
		}
		public static IGrammarAwareElementType createLookAhead2_ZAssignment_0_0ElementType() {
			return new IGrammarAwareElementType("LookAhead2_ZAssignment_0_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead2Access().getZAssignment_0_0());
		}
		public static IGrammarAwareElementType createLookAhead2_ZFooKeyword_0_0_0ElementType() {
			return new IGrammarAwareElementType("LookAhead2_ZFooKeyword_0_0_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead2Access().getZFooKeyword_0_0_0());
		}
		public static IGrammarAwareElementType createLookAhead2_ZAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("LookAhead2_ZAssignment_0_1_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead2Access().getZAssignment_0_1());
		}
		public static IGrammarAwareElementType createLookAhead2_ZBarKeyword_0_1_0ElementType() {
			return new IGrammarAwareElementType("LookAhead2_ZBarKeyword_0_1_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead2Access().getZBarKeyword_0_1_0());
		}
		public static IGrammarAwareElementType createLookAhead2_CKeyword_1ElementType() {
			return new IGrammarAwareElementType("LookAhead2_CKeyword_1_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead2Access().getCKeyword_1());
		}
	}

	public static final IGrammarAwareElementType LookAhead2_ELEMENT_TYPE = associate(LookAhead2Factory.createLookAhead2ElementType());

	public static final IGrammarAwareElementType LookAhead2_Group_ELEMENT_TYPE = associate(LookAhead2Factory.createLookAhead2_GroupElementType());

	public static final IGrammarAwareElementType LookAhead2_Alternatives_0_ELEMENT_TYPE = associate(LookAhead2Factory.createLookAhead2_Alternatives_0ElementType());

	public static final IGrammarAwareElementType LookAhead2_ZAssignment_0_0_ELEMENT_TYPE = associate(LookAhead2Factory.createLookAhead2_ZAssignment_0_0ElementType());

	public static final IGrammarAwareElementType LookAhead2_ZFooKeyword_0_0_0_ELEMENT_TYPE = associate(LookAhead2Factory.createLookAhead2_ZFooKeyword_0_0_0ElementType());

	public static final IGrammarAwareElementType LookAhead2_ZAssignment_0_1_ELEMENT_TYPE = associate(LookAhead2Factory.createLookAhead2_ZAssignment_0_1ElementType());

	public static final IGrammarAwareElementType LookAhead2_ZBarKeyword_0_1_0_ELEMENT_TYPE = associate(LookAhead2Factory.createLookAhead2_ZBarKeyword_0_1_0ElementType());

	public static final IGrammarAwareElementType LookAhead2_CKeyword_1_ELEMENT_TYPE = associate(LookAhead2Factory.createLookAhead2_CKeyword_1ElementType());

	private static class LookAhead3Factory {
		public static IGrammarAwareElementType createLookAhead3ElementType() {
			return new IGrammarAwareElementType("LookAhead3_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead3Rule());
		}
		public static IGrammarAwareElementType createLookAhead3_GroupElementType() {
			return new IGrammarAwareElementType("LookAhead3_Group_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead3Access().getGroup());
		}
		public static IGrammarAwareElementType createLookAhead3_FooKeyword_0ElementType() {
			return new IGrammarAwareElementType("LookAhead3_FooKeyword_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead3Access().getFooKeyword_0());
		}
		public static IGrammarAwareElementType createLookAhead3_BarKeyword_1ElementType() {
			return new IGrammarAwareElementType("LookAhead3_BarKeyword_1_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead3Access().getBarKeyword_1());
		}
		public static IGrammarAwareElementType createLookAhead3_XAssignment_2ElementType() {
			return new IGrammarAwareElementType("LookAhead3_XAssignment_2_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead3Access().getXAssignment_2());
		}
		public static IGrammarAwareElementType createLookAhead3_XBKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("LookAhead3_XBKeyword_2_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead3Access().getXBKeyword_2_0());
		}
		public static IGrammarAwareElementType createLookAhead3_ZAssignment_3ElementType() {
			return new IGrammarAwareElementType("LookAhead3_ZAssignment_3_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead3Access().getZAssignment_3());
		}
		public static IGrammarAwareElementType createLookAhead3_ZLookAhead4ParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("LookAhead3_ZLookAhead4ParserRuleCall_3_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead3Access().getZLookAhead4ParserRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType LookAhead3_ELEMENT_TYPE = associate(LookAhead3Factory.createLookAhead3ElementType());

	public static final IGrammarAwareElementType LookAhead3_Group_ELEMENT_TYPE = associate(LookAhead3Factory.createLookAhead3_GroupElementType());

	public static final IGrammarAwareElementType LookAhead3_FooKeyword_0_ELEMENT_TYPE = associate(LookAhead3Factory.createLookAhead3_FooKeyword_0ElementType());

	public static final IGrammarAwareElementType LookAhead3_BarKeyword_1_ELEMENT_TYPE = associate(LookAhead3Factory.createLookAhead3_BarKeyword_1ElementType());

	public static final IGrammarAwareElementType LookAhead3_XAssignment_2_ELEMENT_TYPE = associate(LookAhead3Factory.createLookAhead3_XAssignment_2ElementType());

	public static final IGrammarAwareElementType LookAhead3_XBKeyword_2_0_ELEMENT_TYPE = associate(LookAhead3Factory.createLookAhead3_XBKeyword_2_0ElementType());

	public static final IGrammarAwareElementType LookAhead3_ZAssignment_3_ELEMENT_TYPE = associate(LookAhead3Factory.createLookAhead3_ZAssignment_3ElementType());

	public static final IGrammarAwareElementType LookAhead3_ZLookAhead4ParserRuleCall_3_0_ELEMENT_TYPE = associate(LookAhead3Factory.createLookAhead3_ZLookAhead4ParserRuleCall_3_0ElementType());

	private static class LookAhead4Factory {
		public static IGrammarAwareElementType createLookAhead4ElementType() {
			return new IGrammarAwareElementType("LookAhead4_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead4Rule());
		}
		public static IGrammarAwareElementType createLookAhead4_AlternativesElementType() {
			return new IGrammarAwareElementType("LookAhead4_Alternatives_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead4Access().getAlternatives());
		}
		public static IGrammarAwareElementType createLookAhead4_XAssignment_0ElementType() {
			return new IGrammarAwareElementType("LookAhead4_XAssignment_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead4Access().getXAssignment_0());
		}
		public static IGrammarAwareElementType createLookAhead4_XCKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("LookAhead4_XCKeyword_0_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead4Access().getXCKeyword_0_0());
		}
		public static IGrammarAwareElementType createLookAhead4_XAssignment_1ElementType() {
			return new IGrammarAwareElementType("LookAhead4_XAssignment_1_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead4Access().getXAssignment_1());
		}
		public static IGrammarAwareElementType createLookAhead4_XDKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("LookAhead4_XDKeyword_1_0_ELEMENT_TYPE", LookaheadTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLookAhead4Access().getXDKeyword_1_0());
		}
	}

	public static final IGrammarAwareElementType LookAhead4_ELEMENT_TYPE = associate(LookAhead4Factory.createLookAhead4ElementType());

	public static final IGrammarAwareElementType LookAhead4_Alternatives_ELEMENT_TYPE = associate(LookAhead4Factory.createLookAhead4_AlternativesElementType());

	public static final IGrammarAwareElementType LookAhead4_XAssignment_0_ELEMENT_TYPE = associate(LookAhead4Factory.createLookAhead4_XAssignment_0ElementType());

	public static final IGrammarAwareElementType LookAhead4_XCKeyword_0_0_ELEMENT_TYPE = associate(LookAhead4Factory.createLookAhead4_XCKeyword_0_0ElementType());

	public static final IGrammarAwareElementType LookAhead4_XAssignment_1_ELEMENT_TYPE = associate(LookAhead4Factory.createLookAhead4_XAssignment_1ElementType());

	public static final IGrammarAwareElementType LookAhead4_XDKeyword_1_0_ELEMENT_TYPE = associate(LookAhead4Factory.createLookAhead4_XDKeyword_1_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getEntryElementType() {
		return Entry_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntry_ContentsAssignmentElementType() {
		return Entry_ContentsAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntry_ContentsAltsParserRuleCall_0ElementType() {
		return Entry_ContentsAltsParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAltsElementType() {
		return Alts_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlts_AlternativesElementType() {
		return Alts_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlts_LookAhead0ParserRuleCall_0ElementType() {
		return Alts_LookAhead0ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlts_LookAhead1ParserRuleCall_1ElementType() {
		return Alts_LookAhead1ParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAlts_LookAhead3ParserRuleCall_2ElementType() {
		return Alts_LookAhead3ParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead0ElementType() {
		return LookAhead0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead0_GroupElementType() {
		return LookAhead0_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead0_BarKeyword_0ElementType() {
		return LookAhead0_BarKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead0_XAssignment_1ElementType() {
		return LookAhead0_XAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead0_XAKeyword_1_0ElementType() {
		return LookAhead0_XAKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead1ElementType() {
		return LookAhead1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead1_GroupElementType() {
		return LookAhead1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead1_FooKeyword_0ElementType() {
		return LookAhead1_FooKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead1_YAssignment_1ElementType() {
		return LookAhead1_YAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead1_YLookAhead2ParserRuleCall_1_0ElementType() {
		return LookAhead1_YLookAhead2ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead1_XAssignment_2ElementType() {
		return LookAhead1_XAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead1_XBKeyword_2_0ElementType() {
		return LookAhead1_XBKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead1_ZAssignment_3ElementType() {
		return LookAhead1_ZAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead1_ZDKeyword_3_0ElementType() {
		return LookAhead1_ZDKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead2ElementType() {
		return LookAhead2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead2_GroupElementType() {
		return LookAhead2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead2_Alternatives_0ElementType() {
		return LookAhead2_Alternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead2_ZAssignment_0_0ElementType() {
		return LookAhead2_ZAssignment_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead2_ZFooKeyword_0_0_0ElementType() {
		return LookAhead2_ZFooKeyword_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead2_ZAssignment_0_1ElementType() {
		return LookAhead2_ZAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead2_ZBarKeyword_0_1_0ElementType() {
		return LookAhead2_ZBarKeyword_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead2_CKeyword_1ElementType() {
		return LookAhead2_CKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead3ElementType() {
		return LookAhead3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead3_GroupElementType() {
		return LookAhead3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead3_FooKeyword_0ElementType() {
		return LookAhead3_FooKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead3_BarKeyword_1ElementType() {
		return LookAhead3_BarKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead3_XAssignment_2ElementType() {
		return LookAhead3_XAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead3_XBKeyword_2_0ElementType() {
		return LookAhead3_XBKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead3_ZAssignment_3ElementType() {
		return LookAhead3_ZAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead3_ZLookAhead4ParserRuleCall_3_0ElementType() {
		return LookAhead3_ZLookAhead4ParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead4ElementType() {
		return LookAhead4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead4_AlternativesElementType() {
		return LookAhead4_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead4_XAssignment_0ElementType() {
		return LookAhead4_XAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead4_XCKeyword_0_0ElementType() {
		return LookAhead4_XCKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead4_XAssignment_1ElementType() {
		return LookAhead4_XAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLookAhead4_XDKeyword_1_0ElementType() {
		return LookAhead4_XDKeyword_1_0_ELEMENT_TYPE;
	}

}
