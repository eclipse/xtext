package org.eclipse.xtext.serializer.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.serializer.idea.lang.psi.impl.HiddenTokenSequencerTestLanguageFileImpl;
import org.eclipse.xtext.serializer.services.HiddenTokenSequencerTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class HiddenTokenSequencerTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<HiddenTokenSequencerTestLanguageFileImpl>>(HiddenTokenSequencerTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final HiddenTokenSequencerTestLanguageGrammarAccess GRAMMAR_ACCESS = HiddenTokenSequencerTestLanguageLanguage.INSTANCE.getInstance(HiddenTokenSequencerTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_DomainModelAssignmentElementType() {
			return new IGrammarAwareElementType("Model_DomainModelAssignment_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDomainModelAssignment());
		}
		public static IGrammarAwareElementType createModel_DomainModelDomainModelParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_DomainModelDomainModelParserRuleCall_0_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDomainModelDomainModelParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_DomainModelAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_DomainModelAssignmentElementType());

	public static final IGrammarAwareElementType Model_DomainModelDomainModelParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DomainModelDomainModelParserRuleCall_0ElementType());

	private static class DomainModelFactory {
		public static IGrammarAwareElementType createDomainModelElementType() {
			return new IGrammarAwareElementType("DomainModel_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDomainModelRule());
		}
		public static IGrammarAwareElementType createDomainModel_GroupElementType() {
			return new IGrammarAwareElementType("DomainModel_Group_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDomainModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createDomainModel_EntitiesKeyword_0ElementType() {
			return new IGrammarAwareElementType("DomainModel_EntitiesKeyword_0_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDomainModelAccess().getEntitiesKeyword_0());
		}
		public static IGrammarAwareElementType createDomainModel_EntitiesAssignment_1ElementType() {
			return new IGrammarAwareElementType("DomainModel_EntitiesAssignment_1_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDomainModelAccess().getEntitiesAssignment_1());
		}
		public static IGrammarAwareElementType createDomainModel_EntitiesEntityParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("DomainModel_EntitiesEntityParserRuleCall_1_0_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDomainModelAccess().getEntitiesEntityParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createDomainModel_EndKeyword_2ElementType() {
			return new IGrammarAwareElementType("DomainModel_EndKeyword_2_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDomainModelAccess().getEndKeyword_2());
		}
	}

	public static final IGrammarAwareElementType DomainModel_ELEMENT_TYPE = associate(DomainModelFactory.createDomainModelElementType());

	public static final IGrammarAwareElementType DomainModel_Group_ELEMENT_TYPE = associate(DomainModelFactory.createDomainModel_GroupElementType());

	public static final IGrammarAwareElementType DomainModel_EntitiesKeyword_0_ELEMENT_TYPE = associate(DomainModelFactory.createDomainModel_EntitiesKeyword_0ElementType());

	public static final IGrammarAwareElementType DomainModel_EntitiesAssignment_1_ELEMENT_TYPE = associate(DomainModelFactory.createDomainModel_EntitiesAssignment_1ElementType());

	public static final IGrammarAwareElementType DomainModel_EntitiesEntityParserRuleCall_1_0_ELEMENT_TYPE = associate(DomainModelFactory.createDomainModel_EntitiesEntityParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType DomainModel_EndKeyword_2_ELEMENT_TYPE = associate(DomainModelFactory.createDomainModel_EndKeyword_2ElementType());

	private static class EntityFactory {
		public static IGrammarAwareElementType createEntityElementType() {
			return new IGrammarAwareElementType("Entity_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityRule());
		}
		public static IGrammarAwareElementType createEntity_GroupElementType() {
			return new IGrammarAwareElementType("Entity_Group_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getGroup());
		}
		public static IGrammarAwareElementType createEntity_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Entity_NameAssignment_0_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createEntity_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Entity_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createEntity_DescriptionAssignment_1ElementType() {
			return new IGrammarAwareElementType("Entity_DescriptionAssignment_1_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getDescriptionAssignment_1());
		}
		public static IGrammarAwareElementType createEntity_DescriptionSTRINGTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Entity_DescriptionSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE", HiddenTokenSequencerTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getDescriptionSTRINGTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Entity_ELEMENT_TYPE = associate(EntityFactory.createEntityElementType());

	public static final IGrammarAwareElementType Entity_Group_ELEMENT_TYPE = associate(EntityFactory.createEntity_GroupElementType());

	public static final IGrammarAwareElementType Entity_NameAssignment_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Entity_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Entity_DescriptionAssignment_1_ELEMENT_TYPE = associate(EntityFactory.createEntity_DescriptionAssignment_1ElementType());

	public static final IGrammarAwareElementType Entity_DescriptionSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_DescriptionSTRINGTerminalRuleCall_1_0ElementType());

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

	public IGrammarAwareElementType getModel_DomainModelAssignmentElementType() {
		return Model_DomainModelAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DomainModelDomainModelParserRuleCall_0ElementType() {
		return Model_DomainModelDomainModelParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDomainModelElementType() {
		return DomainModel_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDomainModel_GroupElementType() {
		return DomainModel_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDomainModel_EntitiesKeyword_0ElementType() {
		return DomainModel_EntitiesKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDomainModel_EntitiesAssignment_1ElementType() {
		return DomainModel_EntitiesAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDomainModel_EntitiesEntityParserRuleCall_1_0ElementType() {
		return DomainModel_EntitiesEntityParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDomainModel_EndKeyword_2ElementType() {
		return DomainModel_EndKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntityElementType() {
		return Entity_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_GroupElementType() {
		return Entity_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_NameAssignment_0ElementType() {
		return Entity_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_NameIDTerminalRuleCall_0_0ElementType() {
		return Entity_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_DescriptionAssignment_1ElementType() {
		return Entity_DescriptionAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_DescriptionSTRINGTerminalRuleCall_1_0ElementType() {
		return Entity_DescriptionSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

}
