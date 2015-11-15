package org.eclipse.xtext.lexer.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.lexer.idea.lang.psi.impl.BacktrackingLexerTestLanguageFileImpl;
import org.eclipse.xtext.lexer.services.BacktrackingLexerTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class BacktrackingLexerTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<BacktrackingLexerTestLanguageFileImpl>>(BacktrackingLexerTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final BacktrackingLexerTestLanguageGrammarAccess GRAMMAR_ACCESS = BacktrackingLexerTestLanguageLanguage.INSTANCE.getInstance(BacktrackingLexerTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_EnumsAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_EnumsAssignment_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEnumsAssignment_0());
		}
		public static IGrammarAwareElementType createModel_EnumsEnumNameEnumRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_EnumsEnumNameEnumRuleCall_0_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEnumsEnumNameEnumRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_YcsAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_YcsAssignment_1_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getYcsAssignment_1());
		}
		public static IGrammarAwareElementType createModel_YcsYcTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_YcsYcTerminalRuleCall_1_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getYcsYcTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createModel_AbsAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_AbsAssignment_2_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAbsAssignment_2());
		}
		public static IGrammarAwareElementType createModel_AbsAbParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Model_AbsAbParserRuleCall_2_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAbsAbParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createModel_XbsAssignment_3ElementType() {
			return new IGrammarAwareElementType("Model_XbsAssignment_3_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getXbsAssignment_3());
		}
		public static IGrammarAwareElementType createModel_XbsXbParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Model_XbsXbParserRuleCall_3_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getXbsXbParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createModel_YsAssignment_4ElementType() {
			return new IGrammarAwareElementType("Model_YsAssignment_4_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getYsAssignment_4());
		}
		public static IGrammarAwareElementType createModel_YsCharYTerminalRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Model_YsCharYTerminalRuleCall_4_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getYsCharYTerminalRuleCall_4_0());
		}
		public static IGrammarAwareElementType createModel_AsAssignment_5ElementType() {
			return new IGrammarAwareElementType("Model_AsAssignment_5_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAsAssignment_5());
		}
		public static IGrammarAwareElementType createModel_AsCharATerminalRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("Model_AsCharATerminalRuleCall_5_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAsCharATerminalRuleCall_5_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_EnumsAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_EnumsAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_EnumsEnumNameEnumRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_EnumsEnumNameEnumRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_YcsAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_YcsAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_YcsYcTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_YcsYcTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Model_AbsAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_AbsAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_AbsAbParserRuleCall_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AbsAbParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Model_XbsAssignment_3_ELEMENT_TYPE = associate(ModelFactory.createModel_XbsAssignment_3ElementType());

	public static final IGrammarAwareElementType Model_XbsXbParserRuleCall_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_XbsXbParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Model_YsAssignment_4_ELEMENT_TYPE = associate(ModelFactory.createModel_YsAssignment_4ElementType());

	public static final IGrammarAwareElementType Model_YsCharYTerminalRuleCall_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_YsCharYTerminalRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Model_AsAssignment_5_ELEMENT_TYPE = associate(ModelFactory.createModel_AsAssignment_5ElementType());

	public static final IGrammarAwareElementType Model_AsCharATerminalRuleCall_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AsCharATerminalRuleCall_5_0ElementType());

	private static class AbFactory {
		public static IGrammarAwareElementType createAbElementType() {
			return new IGrammarAwareElementType("Ab_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbRule());
		}
		public static IGrammarAwareElementType createAb_GroupElementType() {
			return new IGrammarAwareElementType("Ab_Group_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbAccess().getGroup());
		}
		public static IGrammarAwareElementType createAb_XAssignment_0ElementType() {
			return new IGrammarAwareElementType("Ab_XAssignment_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbAccess().getXAssignment_0());
		}
		public static IGrammarAwareElementType createAb_XCharATerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Ab_XCharATerminalRuleCall_0_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbAccess().getXCharATerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createAb_YAssignment_1ElementType() {
			return new IGrammarAwareElementType("Ab_YAssignment_1_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbAccess().getYAssignment_1());
		}
		public static IGrammarAwareElementType createAb_YCharbTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Ab_YCharbTerminalRuleCall_1_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbAccess().getYCharbTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Ab_ELEMENT_TYPE = associate(AbFactory.createAbElementType());

	public static final IGrammarAwareElementType Ab_Group_ELEMENT_TYPE = associate(AbFactory.createAb_GroupElementType());

	public static final IGrammarAwareElementType Ab_XAssignment_0_ELEMENT_TYPE = associate(AbFactory.createAb_XAssignment_0ElementType());

	public static final IGrammarAwareElementType Ab_XCharATerminalRuleCall_0_0_ELEMENT_TYPE = associate(AbFactory.createAb_XCharATerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Ab_YAssignment_1_ELEMENT_TYPE = associate(AbFactory.createAb_YAssignment_1ElementType());

	public static final IGrammarAwareElementType Ab_YCharbTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AbFactory.createAb_YCharbTerminalRuleCall_1_0ElementType());

	private static class XbFactory {
		public static IGrammarAwareElementType createXbElementType() {
			return new IGrammarAwareElementType("Xb_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getXbRule());
		}
		public static IGrammarAwareElementType createXb_GroupElementType() {
			return new IGrammarAwareElementType("Xb_Group_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getXbAccess().getGroup());
		}
		public static IGrammarAwareElementType createXb_XAssignment_0ElementType() {
			return new IGrammarAwareElementType("Xb_XAssignment_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getXbAccess().getXAssignment_0());
		}
		public static IGrammarAwareElementType createXb_XCharXTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Xb_XCharXTerminalRuleCall_0_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getXbAccess().getXCharXTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createXb_YAssignment_1ElementType() {
			return new IGrammarAwareElementType("Xb_YAssignment_1_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getXbAccess().getYAssignment_1());
		}
		public static IGrammarAwareElementType createXb_YCharbTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Xb_YCharbTerminalRuleCall_1_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getXbAccess().getYCharbTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Xb_ELEMENT_TYPE = associate(XbFactory.createXbElementType());

	public static final IGrammarAwareElementType Xb_Group_ELEMENT_TYPE = associate(XbFactory.createXb_GroupElementType());

	public static final IGrammarAwareElementType Xb_XAssignment_0_ELEMENT_TYPE = associate(XbFactory.createXb_XAssignment_0ElementType());

	public static final IGrammarAwareElementType Xb_XCharXTerminalRuleCall_0_0_ELEMENT_TYPE = associate(XbFactory.createXb_XCharXTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Xb_YAssignment_1_ELEMENT_TYPE = associate(XbFactory.createXb_YAssignment_1ElementType());

	public static final IGrammarAwareElementType Xb_YCharbTerminalRuleCall_1_0_ELEMENT_TYPE = associate(XbFactory.createXb_YCharbTerminalRuleCall_1_0ElementType());

	private static class EnumNameFactory {
		public static IGrammarAwareElementType createEnumNameElementType() {
			return new IGrammarAwareElementType("EnumName_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumNameRule());
		}
		public static IGrammarAwareElementType createEnumName_AlternativesElementType() {
			return new IGrammarAwareElementType("EnumName_Alternatives_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumNameAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createEnumName_AbcEnumLiteralDeclaration_0ElementType() {
			return new IGrammarAwareElementType("EnumName_AbcEnumLiteralDeclaration_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumNameAccess().getAbcEnumLiteralDeclaration_0());
		}
		public static IGrammarAwareElementType createEnumName_AbcAbcKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("EnumName_AbcAbcKeyword_0_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumNameAccess().getAbcAbcKeyword_0_0());
		}
		public static IGrammarAwareElementType createEnumName_EfgEnumLiteralDeclaration_1ElementType() {
			return new IGrammarAwareElementType("EnumName_EfgEnumLiteralDeclaration_1_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumNameAccess().getEfgEnumLiteralDeclaration_1());
		}
		public static IGrammarAwareElementType createEnumName_EfgEfgKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("EnumName_EfgEfgKeyword_1_0_ELEMENT_TYPE", BacktrackingLexerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumNameAccess().getEfgEfgKeyword_1_0());
		}
	}

	public static final IGrammarAwareElementType EnumName_ELEMENT_TYPE = associate(EnumNameFactory.createEnumNameElementType());

	public static final IGrammarAwareElementType EnumName_Alternatives_ELEMENT_TYPE = associate(EnumNameFactory.createEnumName_AlternativesElementType());

	public static final IGrammarAwareElementType EnumName_AbcEnumLiteralDeclaration_0_ELEMENT_TYPE = associate(EnumNameFactory.createEnumName_AbcEnumLiteralDeclaration_0ElementType());

	public static final IGrammarAwareElementType EnumName_AbcAbcKeyword_0_0_ELEMENT_TYPE = associate(EnumNameFactory.createEnumName_AbcAbcKeyword_0_0ElementType());

	public static final IGrammarAwareElementType EnumName_EfgEnumLiteralDeclaration_1_ELEMENT_TYPE = associate(EnumNameFactory.createEnumName_EfgEnumLiteralDeclaration_1ElementType());

	public static final IGrammarAwareElementType EnumName_EfgEfgKeyword_1_0_ELEMENT_TYPE = associate(EnumNameFactory.createEnumName_EfgEfgKeyword_1_0ElementType());

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

	public IGrammarAwareElementType getModel_EnumsAssignment_0ElementType() {
		return Model_EnumsAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_EnumsEnumNameEnumRuleCall_0_0ElementType() {
		return Model_EnumsEnumNameEnumRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_YcsAssignment_1ElementType() {
		return Model_YcsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_YcsYcTerminalRuleCall_1_0ElementType() {
		return Model_YcsYcTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AbsAssignment_2ElementType() {
		return Model_AbsAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AbsAbParserRuleCall_2_0ElementType() {
		return Model_AbsAbParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_XbsAssignment_3ElementType() {
		return Model_XbsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_XbsXbParserRuleCall_3_0ElementType() {
		return Model_XbsXbParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_YsAssignment_4ElementType() {
		return Model_YsAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_YsCharYTerminalRuleCall_4_0ElementType() {
		return Model_YsCharYTerminalRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AsAssignment_5ElementType() {
		return Model_AsAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AsCharATerminalRuleCall_5_0ElementType() {
		return Model_AsCharATerminalRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbElementType() {
		return Ab_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAb_GroupElementType() {
		return Ab_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAb_XAssignment_0ElementType() {
		return Ab_XAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAb_XCharATerminalRuleCall_0_0ElementType() {
		return Ab_XCharATerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAb_YAssignment_1ElementType() {
		return Ab_YAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAb_YCharbTerminalRuleCall_1_0ElementType() {
		return Ab_YCharbTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getXbElementType() {
		return Xb_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getXb_GroupElementType() {
		return Xb_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getXb_XAssignment_0ElementType() {
		return Xb_XAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getXb_XCharXTerminalRuleCall_0_0ElementType() {
		return Xb_XCharXTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getXb_YAssignment_1ElementType() {
		return Xb_YAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getXb_YCharbTerminalRuleCall_1_0ElementType() {
		return Xb_YCharbTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumNameElementType() {
		return EnumName_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumName_AlternativesElementType() {
		return EnumName_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumName_AbcEnumLiteralDeclaration_0ElementType() {
		return EnumName_AbcEnumLiteralDeclaration_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumName_AbcAbcKeyword_0_0ElementType() {
		return EnumName_AbcAbcKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumName_EfgEnumLiteralDeclaration_1ElementType() {
		return EnumName_EfgEnumLiteralDeclaration_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumName_EfgEfgKeyword_1_0ElementType() {
		return EnumName_EfgEfgKeyword_1_0_ELEMENT_TYPE;
	}

}
