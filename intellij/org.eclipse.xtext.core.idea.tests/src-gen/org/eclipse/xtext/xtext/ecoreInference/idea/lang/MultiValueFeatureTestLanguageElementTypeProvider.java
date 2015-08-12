package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.psi.impl.MultiValueFeatureTestLanguageFileImpl;
import org.eclipse.xtext.xtext.ecoreInference.services.MultiValueFeatureTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class MultiValueFeatureTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<MultiValueFeatureTestLanguageFileImpl>>(MultiValueFeatureTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final MultiValueFeatureTestLanguageGrammarAccess GRAMMAR_ACCESS = MultiValueFeatureTestLanguageLanguage.INSTANCE.getInstance(MultiValueFeatureTestLanguageGrammarAccess.class);

	private static class StartFactory {
		public static IGrammarAwareElementType createStartElementType() {
			return new IGrammarAwareElementType("Start_ELEMENT_TYPE", MultiValueFeatureTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStartRule());
		}
		public static IGrammarAwareElementType createStart_FeatureAAssignmentElementType() {
			return new IGrammarAwareElementType("Start_FeatureAAssignment_ELEMENT_TYPE", MultiValueFeatureTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStartAccess().getFeatureAAssignment());
		}
		public static IGrammarAwareElementType createStart_FeatureAIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Start_FeatureAIDTerminalRuleCall_0_ELEMENT_TYPE", MultiValueFeatureTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStartAccess().getFeatureAIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Start_ELEMENT_TYPE = associate(StartFactory.createStartElementType());

	public static final IGrammarAwareElementType Start_FeatureAAssignment_ELEMENT_TYPE = associate(StartFactory.createStart_FeatureAAssignmentElementType());

	public static final IGrammarAwareElementType Start_FeatureAIDTerminalRuleCall_0_ELEMENT_TYPE = associate(StartFactory.createStart_FeatureAIDTerminalRuleCall_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getStartElementType() {
		return Start_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStart_FeatureAAssignmentElementType() {
		return Start_FeatureAAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStart_FeatureAIDTerminalRuleCall_0ElementType() {
		return Start_FeatureAIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
