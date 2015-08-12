package org.eclipse.xtext.parser.terminalrules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.UnicodeTestLanguageFileImpl;
import org.eclipse.xtext.parser.terminalrules.services.UnicodeTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class UnicodeTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<UnicodeTestLanguageFileImpl>>(UnicodeTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final UnicodeTestLanguageGrammarAccess GRAMMAR_ACCESS = UnicodeTestLanguageLanguage.INSTANCE.getInstance(UnicodeTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_StringsAssignmentElementType() {
			return new IGrammarAwareElementType("Model_StringsAssignment_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getStringsAssignment());
		}
		public static IGrammarAwareElementType createModel_StringsAbstractStringParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_StringsAbstractStringParserRuleCall_0_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getStringsAbstractStringParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_StringsAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_StringsAssignmentElementType());

	public static final IGrammarAwareElementType Model_StringsAbstractStringParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_StringsAbstractStringParserRuleCall_0ElementType());

	private static class AbstractStringFactory {
		public static IGrammarAwareElementType createAbstractStringElementType() {
			return new IGrammarAwareElementType("AbstractString_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractStringRule());
		}
		public static IGrammarAwareElementType createAbstractString_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractString_Alternatives_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractStringAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractString_GStringParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractString_GStringParserRuleCall_0_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractStringAccess().getGStringParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractString_QuotedStringParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractString_QuotedStringParserRuleCall_1_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractStringAccess().getQuotedStringParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractString_ELEMENT_TYPE = associate(AbstractStringFactory.createAbstractStringElementType());

	public static final IGrammarAwareElementType AbstractString_Alternatives_ELEMENT_TYPE = associate(AbstractStringFactory.createAbstractString_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractString_GStringParserRuleCall_0_ELEMENT_TYPE = associate(AbstractStringFactory.createAbstractString_GStringParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractString_QuotedStringParserRuleCall_1_ELEMENT_TYPE = associate(AbstractStringFactory.createAbstractString_QuotedStringParserRuleCall_1ElementType());

	private static class GStringFactory {
		public static IGrammarAwareElementType createGStringElementType() {
			return new IGrammarAwareElementType("GString_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGStringRule());
		}
		public static IGrammarAwareElementType createGString_NameAssignmentElementType() {
			return new IGrammarAwareElementType("GString_NameAssignment_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGStringAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createGString_NameGERMAN_STRINGTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("GString_NameGERMAN_STRINGTerminalRuleCall_0_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGStringAccess().getNameGERMAN_STRINGTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType GString_ELEMENT_TYPE = associate(GStringFactory.createGStringElementType());

	public static final IGrammarAwareElementType GString_NameAssignment_ELEMENT_TYPE = associate(GStringFactory.createGString_NameAssignmentElementType());

	public static final IGrammarAwareElementType GString_NameGERMAN_STRINGTerminalRuleCall_0_ELEMENT_TYPE = associate(GStringFactory.createGString_NameGERMAN_STRINGTerminalRuleCall_0ElementType());

	private static class QuotedStringFactory {
		public static IGrammarAwareElementType createQuotedStringElementType() {
			return new IGrammarAwareElementType("QuotedString_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuotedStringRule());
		}
		public static IGrammarAwareElementType createQuotedString_NameAssignmentElementType() {
			return new IGrammarAwareElementType("QuotedString_NameAssignment_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuotedStringAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createQuotedString_NameSTRINGTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("QuotedString_NameSTRINGTerminalRuleCall_0_ELEMENT_TYPE", UnicodeTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQuotedStringAccess().getNameSTRINGTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType QuotedString_ELEMENT_TYPE = associate(QuotedStringFactory.createQuotedStringElementType());

	public static final IGrammarAwareElementType QuotedString_NameAssignment_ELEMENT_TYPE = associate(QuotedStringFactory.createQuotedString_NameAssignmentElementType());

	public static final IGrammarAwareElementType QuotedString_NameSTRINGTerminalRuleCall_0_ELEMENT_TYPE = associate(QuotedStringFactory.createQuotedString_NameSTRINGTerminalRuleCall_0ElementType());

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

	public IGrammarAwareElementType getModel_StringsAssignmentElementType() {
		return Model_StringsAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_StringsAbstractStringParserRuleCall_0ElementType() {
		return Model_StringsAbstractStringParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractStringElementType() {
		return AbstractString_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractString_AlternativesElementType() {
		return AbstractString_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractString_GStringParserRuleCall_0ElementType() {
		return AbstractString_GStringParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractString_QuotedStringParserRuleCall_1ElementType() {
		return AbstractString_QuotedStringParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGStringElementType() {
		return GString_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGString_NameAssignmentElementType() {
		return GString_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGString_NameGERMAN_STRINGTerminalRuleCall_0ElementType() {
		return GString_NameGERMAN_STRINGTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuotedStringElementType() {
		return QuotedString_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuotedString_NameAssignmentElementType() {
		return QuotedString_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQuotedString_NameSTRINGTerminalRuleCall_0ElementType() {
		return QuotedString_NameSTRINGTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
