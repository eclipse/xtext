package org.eclipse.xtext.parser.antlr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.lang.psi.impl.Bug299237TestLanguageFileImpl;
import org.eclipse.xtext.parser.antlr.services.Bug299237TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug299237TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug299237TestLanguageFileImpl>>(Bug299237TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug299237TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug299237TestLanguageLanguage.INSTANCE.getInstance(Bug299237TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug299237TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", Bug299237TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ModelKeyword_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelKeyword_0_ELEMENT_TYPE", Bug299237TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelKeyword_0());
		}
		public static IGrammarAwareElementType createModel_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_NameAssignment_1_ELEMENT_TYPE", Bug299237TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createModel_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug299237TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModel_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("Model_SemicolonKeyword_2_ELEMENT_TYPE", Bug299237TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ModelKeyword_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelKeyword_0ElementType());

	public static final IGrammarAwareElementType Model_NameAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Model_SemicolonKeyword_2_ELEMENT_TYPE = associate(ModelFactory.createModel_SemicolonKeyword_2ElementType());

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

	public IGrammarAwareElementType getModel_ModelKeyword_0ElementType() {
		return Model_ModelKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameAssignment_1ElementType() {
		return Model_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameIDTerminalRuleCall_1_0ElementType() {
		return Model_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SemicolonKeyword_2ElementType() {
		return Model_SemicolonKeyword_2_ELEMENT_TYPE;
	}

}
