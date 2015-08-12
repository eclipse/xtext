package org.eclipse.xtext.parser.encoding.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.encoding.idea.lang.psi.impl.EncodingTestLanguageFileImpl;
import org.eclipse.xtext.parser.encoding.services.EncodingTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class EncodingTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<EncodingTestLanguageFileImpl>>(EncodingTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final EncodingTestLanguageGrammarAccess GRAMMAR_ACCESS = EncodingTestLanguageLanguage.INSTANCE.getInstance(EncodingTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", EncodingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_WordsAssignmentElementType() {
			return new IGrammarAwareElementType("Model_WordsAssignment_ELEMENT_TYPE", EncodingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getWordsAssignment());
		}
		public static IGrammarAwareElementType createModel_WordsWordParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_WordsWordParserRuleCall_0_ELEMENT_TYPE", EncodingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getWordsWordParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_WordsAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_WordsAssignmentElementType());

	public static final IGrammarAwareElementType Model_WordsWordParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_WordsWordParserRuleCall_0ElementType());

	private static class WordFactory {
		public static IGrammarAwareElementType createWordElementType() {
			return new IGrammarAwareElementType("Word_ELEMENT_TYPE", EncodingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWordRule());
		}
		public static IGrammarAwareElementType createWord_ValueAssignmentElementType() {
			return new IGrammarAwareElementType("Word_ValueAssignment_ELEMENT_TYPE", EncodingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWordAccess().getValueAssignment());
		}
		public static IGrammarAwareElementType createWord_ValueLEXEMETerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Word_ValueLEXEMETerminalRuleCall_0_ELEMENT_TYPE", EncodingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getWordAccess().getValueLEXEMETerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Word_ELEMENT_TYPE = associate(WordFactory.createWordElementType());

	public static final IGrammarAwareElementType Word_ValueAssignment_ELEMENT_TYPE = associate(WordFactory.createWord_ValueAssignmentElementType());

	public static final IGrammarAwareElementType Word_ValueLEXEMETerminalRuleCall_0_ELEMENT_TYPE = associate(WordFactory.createWord_ValueLEXEMETerminalRuleCall_0ElementType());

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

	public IGrammarAwareElementType getModel_WordsAssignmentElementType() {
		return Model_WordsAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_WordsWordParserRuleCall_0ElementType() {
		return Model_WordsWordParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWordElementType() {
		return Word_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWord_ValueAssignmentElementType() {
		return Word_ValueAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getWord_ValueLEXEMETerminalRuleCall_0ElementType() {
		return Word_ValueLEXEMETerminalRuleCall_0_ELEMENT_TYPE;
	}

}
