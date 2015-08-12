package org.eclipse.xtext.generator.ecore.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.generator.ecore.idea.lang.psi.impl.EcoreFragmentTestLanguageFileImpl;
import org.eclipse.xtext.generator.ecore.services.EcoreFragmentTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class EcoreFragmentTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<EcoreFragmentTestLanguageFileImpl>>(EcoreFragmentTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final EcoreFragmentTestLanguageGrammarAccess GRAMMAR_ACCESS = EcoreFragmentTestLanguageLanguage.INSTANCE.getInstance(EcoreFragmentTestLanguageGrammarAccess.class);

	private static class SecondFactory {
		public static IGrammarAwareElementType createSecondElementType() {
			return new IGrammarAwareElementType("Second_ELEMENT_TYPE", EcoreFragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondRule());
		}
		public static IGrammarAwareElementType createSecond_GroupElementType() {
			return new IGrammarAwareElementType("Second_Group_ELEMENT_TYPE", EcoreFragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondAccess().getGroup());
		}
		public static IGrammarAwareElementType createSecond_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Second_NameAssignment_0_ELEMENT_TYPE", EcoreFragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createSecond_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Second_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", EcoreFragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createSecond_FirstKeyword_1ElementType() {
			return new IGrammarAwareElementType("Second_FirstKeyword_1_ELEMENT_TYPE", EcoreFragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondAccess().getFirstKeyword_1());
		}
		public static IGrammarAwareElementType createSecond_FirstAssignment_2ElementType() {
			return new IGrammarAwareElementType("Second_FirstAssignment_2_ELEMENT_TYPE", EcoreFragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondAccess().getFirstAssignment_2());
		}
		public static IGrammarAwareElementType createSecond_FirstFirstCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("Second_FirstFirstCrossReference_2_0_ELEMENT_TYPE", EcoreFragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondAccess().getFirstFirstCrossReference_2_0());
		}
		public static IGrammarAwareElementType createSecond_FirstFirstIDTerminalRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Second_FirstFirstIDTerminalRuleCall_2_0_1_ELEMENT_TYPE", EcoreFragmentTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondAccess().getFirstFirstIDTerminalRuleCall_2_0_1());
		}
	}

	public static final IGrammarAwareElementType Second_ELEMENT_TYPE = associate(SecondFactory.createSecondElementType());

	public static final IGrammarAwareElementType Second_Group_ELEMENT_TYPE = associate(SecondFactory.createSecond_GroupElementType());

	public static final IGrammarAwareElementType Second_NameAssignment_0_ELEMENT_TYPE = associate(SecondFactory.createSecond_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Second_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(SecondFactory.createSecond_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Second_FirstKeyword_1_ELEMENT_TYPE = associate(SecondFactory.createSecond_FirstKeyword_1ElementType());

	public static final IGrammarAwareElementType Second_FirstAssignment_2_ELEMENT_TYPE = associate(SecondFactory.createSecond_FirstAssignment_2ElementType());

	public static final IGrammarAwareElementType Second_FirstFirstCrossReference_2_0_ELEMENT_TYPE = associate(SecondFactory.createSecond_FirstFirstCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType Second_FirstFirstIDTerminalRuleCall_2_0_1_ELEMENT_TYPE = associate(SecondFactory.createSecond_FirstFirstIDTerminalRuleCall_2_0_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getSecondElementType() {
		return Second_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecond_GroupElementType() {
		return Second_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecond_NameAssignment_0ElementType() {
		return Second_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecond_NameIDTerminalRuleCall_0_0ElementType() {
		return Second_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecond_FirstKeyword_1ElementType() {
		return Second_FirstKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecond_FirstAssignment_2ElementType() {
		return Second_FirstAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecond_FirstFirstCrossReference_2_0ElementType() {
		return Second_FirstFirstCrossReference_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecond_FirstFirstIDTerminalRuleCall_2_0_1ElementType() {
		return Second_FirstFirstIDTerminalRuleCall_2_0_1_ELEMENT_TYPE;
	}

}
