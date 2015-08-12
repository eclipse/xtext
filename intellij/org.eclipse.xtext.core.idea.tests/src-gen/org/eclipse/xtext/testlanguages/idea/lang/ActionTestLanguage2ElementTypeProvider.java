package org.eclipse.xtext.testlanguages.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.ActionTestLanguage2FileImpl;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguage2GrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class ActionTestLanguage2ElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<ActionTestLanguage2FileImpl>>(ActionTestLanguage2Language.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final ActionTestLanguage2GrammarAccess GRAMMAR_ACCESS = ActionTestLanguage2Language.INSTANCE.getInstance(ActionTestLanguage2GrammarAccess.class);

	private static class ORingFactory {
		public static IGrammarAwareElementType createORingElementType() {
			return new IGrammarAwareElementType("ORing_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getORingRule());
		}
		public static IGrammarAwareElementType createORing_GroupElementType() {
			return new IGrammarAwareElementType("ORing_Group_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getORingAccess().getGroup());
		}
		public static IGrammarAwareElementType createORing_ValueParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("ORing_ValueParserRuleCall_0_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getORingAccess().getValueParserRuleCall_0());
		}
		public static IGrammarAwareElementType createORing_Group_1ElementType() {
			return new IGrammarAwareElementType("ORing_Group_1_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getORingAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createORing_ORingDisjunctsAction_1_0ElementType() {
			return new IGrammarAwareElementType("ORing_ORingDisjunctsAction_1_0_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getORingAccess().getORingDisjunctsAction_1_0());
		}
		public static IGrammarAwareElementType createORing_VerticalLineKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("ORing_VerticalLineKeyword_1_1_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getORingAccess().getVerticalLineKeyword_1_1());
		}
		public static IGrammarAwareElementType createORing_DisjunctsAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("ORing_DisjunctsAssignment_1_2_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getORingAccess().getDisjunctsAssignment_1_2());
		}
		public static IGrammarAwareElementType createORing_DisjunctsValueParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("ORing_DisjunctsValueParserRuleCall_1_2_0_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getORingAccess().getDisjunctsValueParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType ORing_ELEMENT_TYPE = associate(ORingFactory.createORingElementType());

	public static final IGrammarAwareElementType ORing_Group_ELEMENT_TYPE = associate(ORingFactory.createORing_GroupElementType());

	public static final IGrammarAwareElementType ORing_ValueParserRuleCall_0_ELEMENT_TYPE = associate(ORingFactory.createORing_ValueParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType ORing_Group_1_ELEMENT_TYPE = associate(ORingFactory.createORing_Group_1ElementType());

	public static final IGrammarAwareElementType ORing_ORingDisjunctsAction_1_0_ELEMENT_TYPE = associate(ORingFactory.createORing_ORingDisjunctsAction_1_0ElementType());

	public static final IGrammarAwareElementType ORing_VerticalLineKeyword_1_1_ELEMENT_TYPE = associate(ORingFactory.createORing_VerticalLineKeyword_1_1ElementType());

	public static final IGrammarAwareElementType ORing_DisjunctsAssignment_1_2_ELEMENT_TYPE = associate(ORingFactory.createORing_DisjunctsAssignment_1_2ElementType());

	public static final IGrammarAwareElementType ORing_DisjunctsValueParserRuleCall_1_2_0_ELEMENT_TYPE = associate(ORingFactory.createORing_DisjunctsValueParserRuleCall_1_2_0ElementType());

	private static class ValueFactory {
		public static IGrammarAwareElementType createValueElementType() {
			return new IGrammarAwareElementType("Value_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getValueRule());
		}
		public static IGrammarAwareElementType createValue_ValueAssignmentElementType() {
			return new IGrammarAwareElementType("Value_ValueAssignment_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getValueAccess().getValueAssignment());
		}
		public static IGrammarAwareElementType createValue_ValueAKeyword_0ElementType() {
			return new IGrammarAwareElementType("Value_ValueAKeyword_0_ELEMENT_TYPE", ActionTestLanguage2Language.INSTANCE, GRAMMAR_ACCESS.getValueAccess().getValueAKeyword_0());
		}
	}

	public static final IGrammarAwareElementType Value_ELEMENT_TYPE = associate(ValueFactory.createValueElementType());

	public static final IGrammarAwareElementType Value_ValueAssignment_ELEMENT_TYPE = associate(ValueFactory.createValue_ValueAssignmentElementType());

	public static final IGrammarAwareElementType Value_ValueAKeyword_0_ELEMENT_TYPE = associate(ValueFactory.createValue_ValueAKeyword_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getORingElementType() {
		return ORing_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getORing_GroupElementType() {
		return ORing_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getORing_ValueParserRuleCall_0ElementType() {
		return ORing_ValueParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getORing_Group_1ElementType() {
		return ORing_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getORing_ORingDisjunctsAction_1_0ElementType() {
		return ORing_ORingDisjunctsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getORing_VerticalLineKeyword_1_1ElementType() {
		return ORing_VerticalLineKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getORing_DisjunctsAssignment_1_2ElementType() {
		return ORing_DisjunctsAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getORing_DisjunctsValueParserRuleCall_1_2_0ElementType() {
		return ORing_DisjunctsValueParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValueElementType() {
		return Value_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValue_ValueAssignmentElementType() {
		return Value_ValueAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getValue_ValueAKeyword_0ElementType() {
		return Value_ValueAKeyword_0_ELEMENT_TYPE;
	}

}
