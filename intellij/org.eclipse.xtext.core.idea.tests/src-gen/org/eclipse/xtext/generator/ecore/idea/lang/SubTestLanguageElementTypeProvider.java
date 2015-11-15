package org.eclipse.xtext.generator.ecore.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.generator.ecore.idea.lang.psi.impl.SubTestLanguageFileImpl;
import org.eclipse.xtext.generator.ecore.services.SubTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class SubTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<SubTestLanguageFileImpl>>(SubTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final SubTestLanguageGrammarAccess GRAMMAR_ACCESS = SubTestLanguageLanguage.INSTANCE.getInstance(SubTestLanguageGrammarAccess.class);

	private static class SubMainFactory {
		public static IGrammarAwareElementType createSubMainElementType() {
			return new IGrammarAwareElementType("SubMain_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubMainRule());
		}
		public static IGrammarAwareElementType createSubMain_GroupElementType() {
			return new IGrammarAwareElementType("SubMain_Group_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubMainAccess().getGroup());
		}
		public static IGrammarAwareElementType createSubMain_LeftCurlyBracketKeyword_0ElementType() {
			return new IGrammarAwareElementType("SubMain_LeftCurlyBracketKeyword_0_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubMainAccess().getLeftCurlyBracketKeyword_0());
		}
		public static IGrammarAwareElementType createSubMain_SuperMainsAssignment_1ElementType() {
			return new IGrammarAwareElementType("SubMain_SuperMainsAssignment_1_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubMainAccess().getSuperMainsAssignment_1());
		}
		public static IGrammarAwareElementType createSubMain_SuperMainsSuperMainParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SubMain_SuperMainsSuperMainParserRuleCall_1_0_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubMainAccess().getSuperMainsSuperMainParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSubMain_RightCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("SubMain_RightCurlyBracketKeyword_2_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubMainAccess().getRightCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createSubMain_AnotherAssignment_3ElementType() {
			return new IGrammarAwareElementType("SubMain_AnotherAssignment_3_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubMainAccess().getAnotherAssignment_3());
		}
		public static IGrammarAwareElementType createSubMain_AnotherAnotherSuperMainParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("SubMain_AnotherAnotherSuperMainParserRuleCall_3_0_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSubMainAccess().getAnotherAnotherSuperMainParserRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType SubMain_ELEMENT_TYPE = associate(SubMainFactory.createSubMainElementType());

	public static final IGrammarAwareElementType SubMain_Group_ELEMENT_TYPE = associate(SubMainFactory.createSubMain_GroupElementType());

	public static final IGrammarAwareElementType SubMain_LeftCurlyBracketKeyword_0_ELEMENT_TYPE = associate(SubMainFactory.createSubMain_LeftCurlyBracketKeyword_0ElementType());

	public static final IGrammarAwareElementType SubMain_SuperMainsAssignment_1_ELEMENT_TYPE = associate(SubMainFactory.createSubMain_SuperMainsAssignment_1ElementType());

	public static final IGrammarAwareElementType SubMain_SuperMainsSuperMainParserRuleCall_1_0_ELEMENT_TYPE = associate(SubMainFactory.createSubMain_SuperMainsSuperMainParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType SubMain_RightCurlyBracketKeyword_2_ELEMENT_TYPE = associate(SubMainFactory.createSubMain_RightCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType SubMain_AnotherAssignment_3_ELEMENT_TYPE = associate(SubMainFactory.createSubMain_AnotherAssignment_3ElementType());

	public static final IGrammarAwareElementType SubMain_AnotherAnotherSuperMainParserRuleCall_3_0_ELEMENT_TYPE = associate(SubMainFactory.createSubMain_AnotherAnotherSuperMainParserRuleCall_3_0ElementType());

	private static class AnotherSuperMainFactory {
		public static IGrammarAwareElementType createAnotherSuperMainElementType() {
			return new IGrammarAwareElementType("AnotherSuperMain_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherSuperMainRule());
		}
		public static IGrammarAwareElementType createAnotherSuperMain_GroupElementType() {
			return new IGrammarAwareElementType("AnotherSuperMain_Group_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherSuperMainAccess().getGroup());
		}
		public static IGrammarAwareElementType createAnotherSuperMain_UpsKeyword_0ElementType() {
			return new IGrammarAwareElementType("AnotherSuperMain_UpsKeyword_0_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherSuperMainAccess().getUpsKeyword_0());
		}
		public static IGrammarAwareElementType createAnotherSuperMain_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("AnotherSuperMain_NameAssignment_1_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherSuperMainAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createAnotherSuperMain_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AnotherSuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherSuperMainAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AnotherSuperMain_ELEMENT_TYPE = associate(AnotherSuperMainFactory.createAnotherSuperMainElementType());

	public static final IGrammarAwareElementType AnotherSuperMain_Group_ELEMENT_TYPE = associate(AnotherSuperMainFactory.createAnotherSuperMain_GroupElementType());

	public static final IGrammarAwareElementType AnotherSuperMain_UpsKeyword_0_ELEMENT_TYPE = associate(AnotherSuperMainFactory.createAnotherSuperMain_UpsKeyword_0ElementType());

	public static final IGrammarAwareElementType AnotherSuperMain_NameAssignment_1_ELEMENT_TYPE = associate(AnotherSuperMainFactory.createAnotherSuperMain_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType AnotherSuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AnotherSuperMainFactory.createAnotherSuperMain_NameIDTerminalRuleCall_1_0ElementType());

	private static class SuperMainFactory {
		public static IGrammarAwareElementType createSuperMainElementType() {
			return new IGrammarAwareElementType("SuperMain_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuperMainRule());
		}
		public static IGrammarAwareElementType createSuperMain_GroupElementType() {
			return new IGrammarAwareElementType("SuperMain_Group_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuperMainAccess().getGroup());
		}
		public static IGrammarAwareElementType createSuperMain_SuperKeyword_0ElementType() {
			return new IGrammarAwareElementType("SuperMain_SuperKeyword_0_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuperMainAccess().getSuperKeyword_0());
		}
		public static IGrammarAwareElementType createSuperMain_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("SuperMain_NameAssignment_1_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuperMainAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSuperMain_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", SubTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuperMainAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType SuperMain_ELEMENT_TYPE = associate(SuperMainFactory.createSuperMainElementType());

	public static final IGrammarAwareElementType SuperMain_Group_ELEMENT_TYPE = associate(SuperMainFactory.createSuperMain_GroupElementType());

	public static final IGrammarAwareElementType SuperMain_SuperKeyword_0_ELEMENT_TYPE = associate(SuperMainFactory.createSuperMain_SuperKeyword_0ElementType());

	public static final IGrammarAwareElementType SuperMain_NameAssignment_1_ELEMENT_TYPE = associate(SuperMainFactory.createSuperMain_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType SuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SuperMainFactory.createSuperMain_NameIDTerminalRuleCall_1_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getSubMainElementType() {
		return SubMain_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubMain_GroupElementType() {
		return SubMain_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubMain_LeftCurlyBracketKeyword_0ElementType() {
		return SubMain_LeftCurlyBracketKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubMain_SuperMainsAssignment_1ElementType() {
		return SubMain_SuperMainsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubMain_SuperMainsSuperMainParserRuleCall_1_0ElementType() {
		return SubMain_SuperMainsSuperMainParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubMain_RightCurlyBracketKeyword_2ElementType() {
		return SubMain_RightCurlyBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubMain_AnotherAssignment_3ElementType() {
		return SubMain_AnotherAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSubMain_AnotherAnotherSuperMainParserRuleCall_3_0ElementType() {
		return SubMain_AnotherAnotherSuperMainParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherSuperMainElementType() {
		return AnotherSuperMain_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherSuperMain_GroupElementType() {
		return AnotherSuperMain_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherSuperMain_UpsKeyword_0ElementType() {
		return AnotherSuperMain_UpsKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherSuperMain_NameAssignment_1ElementType() {
		return AnotherSuperMain_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherSuperMain_NameIDTerminalRuleCall_1_0ElementType() {
		return AnotherSuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuperMainElementType() {
		return SuperMain_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuperMain_GroupElementType() {
		return SuperMain_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuperMain_SuperKeyword_0ElementType() {
		return SuperMain_SuperKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuperMain_NameAssignment_1ElementType() {
		return SuperMain_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSuperMain_NameIDTerminalRuleCall_1_0ElementType() {
		return SuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

}
