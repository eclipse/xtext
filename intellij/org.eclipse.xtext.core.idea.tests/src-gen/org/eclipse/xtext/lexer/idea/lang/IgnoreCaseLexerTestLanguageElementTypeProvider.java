package org.eclipse.xtext.lexer.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.lexer.idea.lang.psi.impl.IgnoreCaseLexerTestLanguageFileImpl;
import org.eclipse.xtext.lexer.services.IgnoreCaseLexerTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class IgnoreCaseLexerTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<IgnoreCaseLexerTestLanguageFileImpl>>(IgnoreCaseLexerTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final IgnoreCaseLexerTestLanguageGrammarAccess GRAMMAR_ACCESS = IgnoreCaseLexerTestLanguageLanguage.INSTANCE.getInstance(IgnoreCaseLexerTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", IgnoreCaseLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", IgnoreCaseLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_CaseKeyword_0ElementType() {
			return new IGrammarAwareElementType("Model_CaseKeyword_0_ELEMENT_TYPE", IgnoreCaseLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getCaseKeyword_0());
		}
		public static IGrammarAwareElementType createModel_FooKeyword_1ElementType() {
			return new IGrammarAwareElementType("Model_FooKeyword_1_ELEMENT_TYPE", IgnoreCaseLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFooKeyword_1());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_2_ELEMENT_TYPE", IgnoreCaseLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_2());
		}
		public static IGrammarAwareElementType createModel_ValueCaSeKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueCaSeKeyword_2_0_ELEMENT_TYPE", IgnoreCaseLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueCaSeKeyword_2_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_CaseKeyword_0_ELEMENT_TYPE = associate(ModelFactory.createModel_CaseKeyword_0ElementType());

	public static final IGrammarAwareElementType Model_FooKeyword_1_ELEMENT_TYPE = associate(ModelFactory.createModel_FooKeyword_1ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_ValueCaSeKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueCaSeKeyword_2_0ElementType());

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

	public IGrammarAwareElementType getModel_GroupElementType() {
		return Model_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_CaseKeyword_0ElementType() {
		return Model_CaseKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FooKeyword_1ElementType() {
		return Model_FooKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_2ElementType() {
		return Model_ValueAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueCaSeKeyword_2_0ElementType() {
		return Model_ValueCaSeKeyword_2_0_ELEMENT_TYPE;
	}

}
