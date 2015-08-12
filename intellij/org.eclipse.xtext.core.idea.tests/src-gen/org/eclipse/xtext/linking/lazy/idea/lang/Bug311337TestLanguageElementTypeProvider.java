package org.eclipse.xtext.linking.lazy.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.linking.lazy.idea.lang.psi.impl.Bug311337TestLanguageFileImpl;
import org.eclipse.xtext.linking.lazy.services.Bug311337TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug311337TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug311337TestLanguageFileImpl>>(Bug311337TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug311337TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug311337TestLanguageLanguage.INSTANCE.getInstance(Bug311337TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_DefAssignmentElementType() {
			return new IGrammarAwareElementType("Model_DefAssignment_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDefAssignment());
		}
		public static IGrammarAwareElementType createModel_DefDefinitionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_DefDefinitionParserRuleCall_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDefDefinitionParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_DefAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_DefAssignmentElementType());

	public static final IGrammarAwareElementType Model_DefDefinitionParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DefDefinitionParserRuleCall_0ElementType());

	private static class DefinitionFactory {
		public static IGrammarAwareElementType createDefinitionElementType() {
			return new IGrammarAwareElementType("Definition_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefinitionRule());
		}
		public static IGrammarAwareElementType createDefinition_GroupElementType() {
			return new IGrammarAwareElementType("Definition_Group_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefinitionAccess().getGroup());
		}
		public static IGrammarAwareElementType createDefinition_DefKeyword_0ElementType() {
			return new IGrammarAwareElementType("Definition_DefKeyword_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefinitionAccess().getDefKeyword_0());
		}
		public static IGrammarAwareElementType createDefinition_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Definition_NameAssignment_1_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefinitionAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createDefinition_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Definition_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefinitionAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createDefinition_ColonKeyword_2ElementType() {
			return new IGrammarAwareElementType("Definition_ColonKeyword_2_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefinitionAccess().getColonKeyword_2());
		}
		public static IGrammarAwareElementType createDefinition_ChildAssignment_3ElementType() {
			return new IGrammarAwareElementType("Definition_ChildAssignment_3_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefinitionAccess().getChildAssignment_3());
		}
		public static IGrammarAwareElementType createDefinition_ChildChildParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Definition_ChildChildParserRuleCall_3_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefinitionAccess().getChildChildParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createDefinition_RefAssignment_4ElementType() {
			return new IGrammarAwareElementType("Definition_RefAssignment_4_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefinitionAccess().getRefAssignment_4());
		}
		public static IGrammarAwareElementType createDefinition_RefReferenceParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Definition_RefReferenceParserRuleCall_4_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDefinitionAccess().getRefReferenceParserRuleCall_4_0());
		}
	}

	public static final IGrammarAwareElementType Definition_ELEMENT_TYPE = associate(DefinitionFactory.createDefinitionElementType());

	public static final IGrammarAwareElementType Definition_Group_ELEMENT_TYPE = associate(DefinitionFactory.createDefinition_GroupElementType());

	public static final IGrammarAwareElementType Definition_DefKeyword_0_ELEMENT_TYPE = associate(DefinitionFactory.createDefinition_DefKeyword_0ElementType());

	public static final IGrammarAwareElementType Definition_NameAssignment_1_ELEMENT_TYPE = associate(DefinitionFactory.createDefinition_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Definition_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(DefinitionFactory.createDefinition_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Definition_ColonKeyword_2_ELEMENT_TYPE = associate(DefinitionFactory.createDefinition_ColonKeyword_2ElementType());

	public static final IGrammarAwareElementType Definition_ChildAssignment_3_ELEMENT_TYPE = associate(DefinitionFactory.createDefinition_ChildAssignment_3ElementType());

	public static final IGrammarAwareElementType Definition_ChildChildParserRuleCall_3_0_ELEMENT_TYPE = associate(DefinitionFactory.createDefinition_ChildChildParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Definition_RefAssignment_4_ELEMENT_TYPE = associate(DefinitionFactory.createDefinition_RefAssignment_4ElementType());

	public static final IGrammarAwareElementType Definition_RefReferenceParserRuleCall_4_0_ELEMENT_TYPE = associate(DefinitionFactory.createDefinition_RefReferenceParserRuleCall_4_0ElementType());

	private static class ChildFactory {
		public static IGrammarAwareElementType createChildElementType() {
			return new IGrammarAwareElementType("Child_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildRule());
		}
		public static IGrammarAwareElementType createChild_GroupElementType() {
			return new IGrammarAwareElementType("Child_Group_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getGroup());
		}
		public static IGrammarAwareElementType createChild_ChildKeyword_0ElementType() {
			return new IGrammarAwareElementType("Child_ChildKeyword_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getChildKeyword_0());
		}
		public static IGrammarAwareElementType createChild_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Child_NameAssignment_1_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createChild_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Child_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createChild_ColonKeyword_2ElementType() {
			return new IGrammarAwareElementType("Child_ColonKeyword_2_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getColonKeyword_2());
		}
		public static IGrammarAwareElementType createChild_LinkAssignment_3ElementType() {
			return new IGrammarAwareElementType("Child_LinkAssignment_3_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getLinkAssignment_3());
		}
		public static IGrammarAwareElementType createChild_LinkDefinitionCrossReference_3_0ElementType() {
			return new IGrammarAwareElementType("Child_LinkDefinitionCrossReference_3_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getLinkDefinitionCrossReference_3_0());
		}
		public static IGrammarAwareElementType createChild_LinkDefinitionIDTerminalRuleCall_3_0_1ElementType() {
			return new IGrammarAwareElementType("Child_LinkDefinitionIDTerminalRuleCall_3_0_1_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getLinkDefinitionIDTerminalRuleCall_3_0_1());
		}
	}

	public static final IGrammarAwareElementType Child_ELEMENT_TYPE = associate(ChildFactory.createChildElementType());

	public static final IGrammarAwareElementType Child_Group_ELEMENT_TYPE = associate(ChildFactory.createChild_GroupElementType());

	public static final IGrammarAwareElementType Child_ChildKeyword_0_ELEMENT_TYPE = associate(ChildFactory.createChild_ChildKeyword_0ElementType());

	public static final IGrammarAwareElementType Child_NameAssignment_1_ELEMENT_TYPE = associate(ChildFactory.createChild_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Child_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ChildFactory.createChild_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Child_ColonKeyword_2_ELEMENT_TYPE = associate(ChildFactory.createChild_ColonKeyword_2ElementType());

	public static final IGrammarAwareElementType Child_LinkAssignment_3_ELEMENT_TYPE = associate(ChildFactory.createChild_LinkAssignment_3ElementType());

	public static final IGrammarAwareElementType Child_LinkDefinitionCrossReference_3_0_ELEMENT_TYPE = associate(ChildFactory.createChild_LinkDefinitionCrossReference_3_0ElementType());

	public static final IGrammarAwareElementType Child_LinkDefinitionIDTerminalRuleCall_3_0_1_ELEMENT_TYPE = associate(ChildFactory.createChild_LinkDefinitionIDTerminalRuleCall_3_0_1ElementType());

	private static class ReferenceFactory {
		public static IGrammarAwareElementType createReferenceElementType() {
			return new IGrammarAwareElementType("Reference_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceRule());
		}
		public static IGrammarAwareElementType createReference_GroupElementType() {
			return new IGrammarAwareElementType("Reference_Group_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getGroup());
		}
		public static IGrammarAwareElementType createReference_RefKeyword_0ElementType() {
			return new IGrammarAwareElementType("Reference_RefKeyword_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getRefKeyword_0());
		}
		public static IGrammarAwareElementType createReference_RefChildAssignment_1ElementType() {
			return new IGrammarAwareElementType("Reference_RefChildAssignment_1_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getRefChildAssignment_1());
		}
		public static IGrammarAwareElementType createReference_RefChildChildCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("Reference_RefChildChildCrossReference_1_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getRefChildChildCrossReference_1_0());
		}
		public static IGrammarAwareElementType createReference_RefChildChildIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("Reference_RefChildChildIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getRefChildChildIDTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createReference_Group_2ElementType() {
			return new IGrammarAwareElementType("Reference_Group_2_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createReference_ColonKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Reference_ColonKeyword_2_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getColonKeyword_2_0());
		}
		public static IGrammarAwareElementType createReference_NestedRefLeftAction_2_1ElementType() {
			return new IGrammarAwareElementType("Reference_NestedRefLeftAction_2_1_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getNestedRefLeftAction_2_1());
		}
		public static IGrammarAwareElementType createReference_RefChildAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("Reference_RefChildAssignment_2_2_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getRefChildAssignment_2_2());
		}
		public static IGrammarAwareElementType createReference_RefChildChildCrossReference_2_2_0ElementType() {
			return new IGrammarAwareElementType("Reference_RefChildChildCrossReference_2_2_0_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getRefChildChildCrossReference_2_2_0());
		}
		public static IGrammarAwareElementType createReference_RefChildChildIDTerminalRuleCall_2_2_0_1ElementType() {
			return new IGrammarAwareElementType("Reference_RefChildChildIDTerminalRuleCall_2_2_0_1_ELEMENT_TYPE", Bug311337TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getReferenceAccess().getRefChildChildIDTerminalRuleCall_2_2_0_1());
		}
	}

	public static final IGrammarAwareElementType Reference_ELEMENT_TYPE = associate(ReferenceFactory.createReferenceElementType());

	public static final IGrammarAwareElementType Reference_Group_ELEMENT_TYPE = associate(ReferenceFactory.createReference_GroupElementType());

	public static final IGrammarAwareElementType Reference_RefKeyword_0_ELEMENT_TYPE = associate(ReferenceFactory.createReference_RefKeyword_0ElementType());

	public static final IGrammarAwareElementType Reference_RefChildAssignment_1_ELEMENT_TYPE = associate(ReferenceFactory.createReference_RefChildAssignment_1ElementType());

	public static final IGrammarAwareElementType Reference_RefChildChildCrossReference_1_0_ELEMENT_TYPE = associate(ReferenceFactory.createReference_RefChildChildCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType Reference_RefChildChildIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(ReferenceFactory.createReference_RefChildChildIDTerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType Reference_Group_2_ELEMENT_TYPE = associate(ReferenceFactory.createReference_Group_2ElementType());

	public static final IGrammarAwareElementType Reference_ColonKeyword_2_0_ELEMENT_TYPE = associate(ReferenceFactory.createReference_ColonKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Reference_NestedRefLeftAction_2_1_ELEMENT_TYPE = associate(ReferenceFactory.createReference_NestedRefLeftAction_2_1ElementType());

	public static final IGrammarAwareElementType Reference_RefChildAssignment_2_2_ELEMENT_TYPE = associate(ReferenceFactory.createReference_RefChildAssignment_2_2ElementType());

	public static final IGrammarAwareElementType Reference_RefChildChildCrossReference_2_2_0_ELEMENT_TYPE = associate(ReferenceFactory.createReference_RefChildChildCrossReference_2_2_0ElementType());

	public static final IGrammarAwareElementType Reference_RefChildChildIDTerminalRuleCall_2_2_0_1_ELEMENT_TYPE = associate(ReferenceFactory.createReference_RefChildChildIDTerminalRuleCall_2_2_0_1ElementType());

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

	public IGrammarAwareElementType getModel_DefAssignmentElementType() {
		return Model_DefAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DefDefinitionParserRuleCall_0ElementType() {
		return Model_DefDefinitionParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefinitionElementType() {
		return Definition_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefinition_GroupElementType() {
		return Definition_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefinition_DefKeyword_0ElementType() {
		return Definition_DefKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefinition_NameAssignment_1ElementType() {
		return Definition_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefinition_NameIDTerminalRuleCall_1_0ElementType() {
		return Definition_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefinition_ColonKeyword_2ElementType() {
		return Definition_ColonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefinition_ChildAssignment_3ElementType() {
		return Definition_ChildAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefinition_ChildChildParserRuleCall_3_0ElementType() {
		return Definition_ChildChildParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefinition_RefAssignment_4ElementType() {
		return Definition_RefAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefinition_RefReferenceParserRuleCall_4_0ElementType() {
		return Definition_RefReferenceParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildElementType() {
		return Child_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_GroupElementType() {
		return Child_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_ChildKeyword_0ElementType() {
		return Child_ChildKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_NameAssignment_1ElementType() {
		return Child_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_NameIDTerminalRuleCall_1_0ElementType() {
		return Child_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_ColonKeyword_2ElementType() {
		return Child_ColonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_LinkAssignment_3ElementType() {
		return Child_LinkAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_LinkDefinitionCrossReference_3_0ElementType() {
		return Child_LinkDefinitionCrossReference_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_LinkDefinitionIDTerminalRuleCall_3_0_1ElementType() {
		return Child_LinkDefinitionIDTerminalRuleCall_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReferenceElementType() {
		return Reference_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_GroupElementType() {
		return Reference_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_RefKeyword_0ElementType() {
		return Reference_RefKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_RefChildAssignment_1ElementType() {
		return Reference_RefChildAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_RefChildChildCrossReference_1_0ElementType() {
		return Reference_RefChildChildCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_RefChildChildIDTerminalRuleCall_1_0_1ElementType() {
		return Reference_RefChildChildIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_Group_2ElementType() {
		return Reference_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_ColonKeyword_2_0ElementType() {
		return Reference_ColonKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_NestedRefLeftAction_2_1ElementType() {
		return Reference_NestedRefLeftAction_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_RefChildAssignment_2_2ElementType() {
		return Reference_RefChildAssignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_RefChildChildCrossReference_2_2_0ElementType() {
		return Reference_RefChildChildCrossReference_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReference_RefChildChildIDTerminalRuleCall_2_2_0_1ElementType() {
		return Reference_RefChildChildIDTerminalRuleCall_2_2_0_1_ELEMENT_TYPE;
	}

}
