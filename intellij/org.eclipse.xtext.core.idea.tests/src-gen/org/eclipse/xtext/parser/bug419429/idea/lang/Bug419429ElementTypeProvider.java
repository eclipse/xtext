package org.eclipse.xtext.parser.bug419429.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.bug419429.idea.lang.psi.impl.Bug419429FileImpl;
import org.eclipse.xtext.parser.bug419429.services.Bug419429GrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug419429ElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug419429FileImpl>>(Bug419429Language.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug419429GrammarAccess GRAMMAR_ACCESS = Bug419429Language.INSTANCE.getInstance(Bug419429GrammarAccess.class);

	private static class EReferenceFactory {
		public static IGrammarAwareElementType createEReferenceElementType() {
			return new IGrammarAwareElementType("EReference_ELEMENT_TYPE", Bug419429Language.INSTANCE, GRAMMAR_ACCESS.getEReferenceRule());
		}
		public static IGrammarAwareElementType createEReference_ETypeAssignmentElementType() {
			return new IGrammarAwareElementType("EReference_ETypeAssignment_ELEMENT_TYPE", Bug419429Language.INSTANCE, GRAMMAR_ACCESS.getEReferenceAccess().getETypeAssignment());
		}
		public static IGrammarAwareElementType createEReference_ETypeEClassifierCrossReference_0ElementType() {
			return new IGrammarAwareElementType("EReference_ETypeEClassifierCrossReference_0_ELEMENT_TYPE", Bug419429Language.INSTANCE, GRAMMAR_ACCESS.getEReferenceAccess().getETypeEClassifierCrossReference_0());
		}
		public static IGrammarAwareElementType createEReference_ETypeEClassifierIDTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("EReference_ETypeEClassifierIDTerminalRuleCall_0_1_ELEMENT_TYPE", Bug419429Language.INSTANCE, GRAMMAR_ACCESS.getEReferenceAccess().getETypeEClassifierIDTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType EReference_ELEMENT_TYPE = associate(EReferenceFactory.createEReferenceElementType());

	public static final IGrammarAwareElementType EReference_ETypeAssignment_ELEMENT_TYPE = associate(EReferenceFactory.createEReference_ETypeAssignmentElementType());

	public static final IGrammarAwareElementType EReference_ETypeEClassifierCrossReference_0_ELEMENT_TYPE = associate(EReferenceFactory.createEReference_ETypeEClassifierCrossReference_0ElementType());

	public static final IGrammarAwareElementType EReference_ETypeEClassifierIDTerminalRuleCall_0_1_ELEMENT_TYPE = associate(EReferenceFactory.createEReference_ETypeEClassifierIDTerminalRuleCall_0_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getEReferenceElementType() {
		return EReference_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEReference_ETypeAssignmentElementType() {
		return EReference_ETypeAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEReference_ETypeEClassifierCrossReference_0ElementType() {
		return EReference_ETypeEClassifierCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEReference_ETypeEClassifierIDTerminalRuleCall_0_1ElementType() {
		return EReference_ETypeEClassifierIDTerminalRuleCall_0_1_ELEMENT_TYPE;
	}

}
