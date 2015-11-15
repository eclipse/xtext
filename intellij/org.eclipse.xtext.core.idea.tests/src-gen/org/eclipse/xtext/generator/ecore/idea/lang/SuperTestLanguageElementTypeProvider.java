package org.eclipse.xtext.generator.ecore.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.generator.ecore.idea.lang.psi.impl.SuperTestLanguageFileImpl;
import org.eclipse.xtext.generator.ecore.services.SuperTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class SuperTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<SuperTestLanguageFileImpl>>(SuperTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final SuperTestLanguageGrammarAccess GRAMMAR_ACCESS = SuperTestLanguageLanguage.INSTANCE.getInstance(SuperTestLanguageGrammarAccess.class);

	private static class SuperMainFactory {
		public static IGrammarAwareElementType createSuperMainElementType() {
			return new IGrammarAwareElementType("SuperMain_ELEMENT_TYPE", SuperTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuperMainRule());
		}
		public static IGrammarAwareElementType createSuperMain_GroupElementType() {
			return new IGrammarAwareElementType("SuperMain_Group_ELEMENT_TYPE", SuperTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuperMainAccess().getGroup());
		}
		public static IGrammarAwareElementType createSuperMain_SuperKeyword_0ElementType() {
			return new IGrammarAwareElementType("SuperMain_SuperKeyword_0_ELEMENT_TYPE", SuperTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuperMainAccess().getSuperKeyword_0());
		}
		public static IGrammarAwareElementType createSuperMain_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("SuperMain_NameAssignment_1_ELEMENT_TYPE", SuperTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuperMainAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSuperMain_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", SuperTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSuperMainAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType SuperMain_ELEMENT_TYPE = associate(SuperMainFactory.createSuperMainElementType());

	public static final IGrammarAwareElementType SuperMain_Group_ELEMENT_TYPE = associate(SuperMainFactory.createSuperMain_GroupElementType());

	public static final IGrammarAwareElementType SuperMain_SuperKeyword_0_ELEMENT_TYPE = associate(SuperMainFactory.createSuperMain_SuperKeyword_0ElementType());

	public static final IGrammarAwareElementType SuperMain_NameAssignment_1_ELEMENT_TYPE = associate(SuperMainFactory.createSuperMain_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType SuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SuperMainFactory.createSuperMain_NameIDTerminalRuleCall_1_0ElementType());

	private static class AnotherSuperMainFactory {
		public static IGrammarAwareElementType createAnotherSuperMainElementType() {
			return new IGrammarAwareElementType("AnotherSuperMain_ELEMENT_TYPE", SuperTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherSuperMainRule());
		}
		public static IGrammarAwareElementType createAnotherSuperMain_GroupElementType() {
			return new IGrammarAwareElementType("AnotherSuperMain_Group_ELEMENT_TYPE", SuperTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherSuperMainAccess().getGroup());
		}
		public static IGrammarAwareElementType createAnotherSuperMain_AnotherKeyword_0ElementType() {
			return new IGrammarAwareElementType("AnotherSuperMain_AnotherKeyword_0_ELEMENT_TYPE", SuperTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherSuperMainAccess().getAnotherKeyword_0());
		}
		public static IGrammarAwareElementType createAnotherSuperMain_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("AnotherSuperMain_NameAssignment_1_ELEMENT_TYPE", SuperTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherSuperMainAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createAnotherSuperMain_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AnotherSuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", SuperTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherSuperMainAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AnotherSuperMain_ELEMENT_TYPE = associate(AnotherSuperMainFactory.createAnotherSuperMainElementType());

	public static final IGrammarAwareElementType AnotherSuperMain_Group_ELEMENT_TYPE = associate(AnotherSuperMainFactory.createAnotherSuperMain_GroupElementType());

	public static final IGrammarAwareElementType AnotherSuperMain_AnotherKeyword_0_ELEMENT_TYPE = associate(AnotherSuperMainFactory.createAnotherSuperMain_AnotherKeyword_0ElementType());

	public static final IGrammarAwareElementType AnotherSuperMain_NameAssignment_1_ELEMENT_TYPE = associate(AnotherSuperMainFactory.createAnotherSuperMain_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType AnotherSuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AnotherSuperMainFactory.createAnotherSuperMain_NameIDTerminalRuleCall_1_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
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

	public IGrammarAwareElementType getAnotherSuperMainElementType() {
		return AnotherSuperMain_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherSuperMain_GroupElementType() {
		return AnotherSuperMain_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherSuperMain_AnotherKeyword_0ElementType() {
		return AnotherSuperMain_AnotherKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherSuperMain_NameAssignment_1ElementType() {
		return AnotherSuperMain_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherSuperMain_NameIDTerminalRuleCall_1_0ElementType() {
		return AnotherSuperMain_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

}
