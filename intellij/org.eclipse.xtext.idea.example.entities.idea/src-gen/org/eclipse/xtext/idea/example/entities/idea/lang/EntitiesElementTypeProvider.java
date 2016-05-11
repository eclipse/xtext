/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea.lang;

import com.intellij.psi.tree.IFileElementType;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.example.entities.idea.lang.psi.impl.EntitiesFileImpl;
import org.eclipse.xtext.idea.example.entities.services.EntitiesGrammarAccess;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

public class EntitiesElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<EntitiesFileImpl>>(EntitiesLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final EntitiesGrammarAccess GRAMMAR_ACCESS = EntitiesLanguage.INSTANCE.getInstance(EntitiesGrammarAccess.class);

	private static class EntitiesFactory {
		public static IGrammarAwareElementType createEntitiesElementType() {
			return new IGrammarAwareElementType("Entities_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntitiesRule());
		}
		public static IGrammarAwareElementType createEntities_GroupElementType() {
			return new IGrammarAwareElementType("Entities_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntitiesAccess().getGroup());
		}
		public static IGrammarAwareElementType createEntities_ImportSectionAssignment_0ElementType() {
			return new IGrammarAwareElementType("Entities_ImportSectionAssignment_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntitiesAccess().getImportSectionAssignment_0());
		}
		public static IGrammarAwareElementType createEntities_ImportSectionXImportSectionParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Entities_ImportSectionXImportSectionParserRuleCall_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntitiesAccess().getImportSectionXImportSectionParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createEntities_ElementsAssignment_1ElementType() {
			return new IGrammarAwareElementType("Entities_ElementsAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntitiesAccess().getElementsAssignment_1());
		}
		public static IGrammarAwareElementType createEntities_ElementsAbstractElementParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Entities_ElementsAbstractElementParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntitiesAccess().getElementsAbstractElementParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Entities_ELEMENT_TYPE = associate(EntitiesFactory.createEntitiesElementType());

	public static final IGrammarAwareElementType Entities_Group_ELEMENT_TYPE = associate(EntitiesFactory.createEntities_GroupElementType());

	public static final IGrammarAwareElementType Entities_ImportSectionAssignment_0_ELEMENT_TYPE = associate(EntitiesFactory.createEntities_ImportSectionAssignment_0ElementType());

	public static final IGrammarAwareElementType Entities_ImportSectionXImportSectionParserRuleCall_0_0_ELEMENT_TYPE = associate(EntitiesFactory.createEntities_ImportSectionXImportSectionParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Entities_ElementsAssignment_1_ELEMENT_TYPE = associate(EntitiesFactory.createEntities_ElementsAssignment_1ElementType());

	public static final IGrammarAwareElementType Entities_ElementsAbstractElementParserRuleCall_1_0_ELEMENT_TYPE = associate(EntitiesFactory.createEntities_ElementsAbstractElementParserRuleCall_1_0ElementType());

	private static class AbstractElementFactory {
		public static IGrammarAwareElementType createAbstractElementElementType() {
			return new IGrammarAwareElementType("AbstractElement_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractElementRule());
		}
		public static IGrammarAwareElementType createAbstractElement_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractElement_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractElementAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractElement_PackageDeclarationParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractElement_PackageDeclarationParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractElement_EntityParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractElement_EntityParserRuleCall_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractElementAccess().getEntityParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractElement_ELEMENT_TYPE = associate(AbstractElementFactory.createAbstractElementElementType());

	public static final IGrammarAwareElementType AbstractElement_Alternatives_ELEMENT_TYPE = associate(AbstractElementFactory.createAbstractElement_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractElement_PackageDeclarationParserRuleCall_0_ELEMENT_TYPE = associate(AbstractElementFactory.createAbstractElement_PackageDeclarationParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractElement_EntityParserRuleCall_1_ELEMENT_TYPE = associate(AbstractElementFactory.createAbstractElement_EntityParserRuleCall_1ElementType());

	private static class PackageDeclarationFactory {
		public static IGrammarAwareElementType createPackageDeclarationElementType() {
			return new IGrammarAwareElementType("PackageDeclaration_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPackageDeclarationRule());
		}
		public static IGrammarAwareElementType createPackageDeclaration_GroupElementType() {
			return new IGrammarAwareElementType("PackageDeclaration_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPackageDeclarationAccess().getGroup());
		}
		public static IGrammarAwareElementType createPackageDeclaration_PackageKeyword_0ElementType() {
			return new IGrammarAwareElementType("PackageDeclaration_PackageKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPackageDeclarationAccess().getPackageKeyword_0());
		}
		public static IGrammarAwareElementType createPackageDeclaration_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("PackageDeclaration_NameAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPackageDeclarationAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createPackageDeclaration_NameQualifiedNameParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("PackageDeclaration_NameQualifiedNameParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createPackageDeclaration_LeftCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("PackageDeclaration_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createPackageDeclaration_ElementsAssignment_3ElementType() {
			return new IGrammarAwareElementType("PackageDeclaration_ElementsAssignment_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPackageDeclarationAccess().getElementsAssignment_3());
		}
		public static IGrammarAwareElementType createPackageDeclaration_ElementsAbstractElementParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("PackageDeclaration_ElementsAbstractElementParserRuleCall_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createPackageDeclaration_RightCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("PackageDeclaration_RightCurlyBracketKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType PackageDeclaration_ELEMENT_TYPE = associate(PackageDeclarationFactory.createPackageDeclarationElementType());

	public static final IGrammarAwareElementType PackageDeclaration_Group_ELEMENT_TYPE = associate(PackageDeclarationFactory.createPackageDeclaration_GroupElementType());

	public static final IGrammarAwareElementType PackageDeclaration_PackageKeyword_0_ELEMENT_TYPE = associate(PackageDeclarationFactory.createPackageDeclaration_PackageKeyword_0ElementType());

	public static final IGrammarAwareElementType PackageDeclaration_NameAssignment_1_ELEMENT_TYPE = associate(PackageDeclarationFactory.createPackageDeclaration_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType PackageDeclaration_NameQualifiedNameParserRuleCall_1_0_ELEMENT_TYPE = associate(PackageDeclarationFactory.createPackageDeclaration_NameQualifiedNameParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType PackageDeclaration_LeftCurlyBracketKeyword_2_ELEMENT_TYPE = associate(PackageDeclarationFactory.createPackageDeclaration_LeftCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType PackageDeclaration_ElementsAssignment_3_ELEMENT_TYPE = associate(PackageDeclarationFactory.createPackageDeclaration_ElementsAssignment_3ElementType());

	public static final IGrammarAwareElementType PackageDeclaration_ElementsAbstractElementParserRuleCall_3_0_ELEMENT_TYPE = associate(PackageDeclarationFactory.createPackageDeclaration_ElementsAbstractElementParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType PackageDeclaration_RightCurlyBracketKeyword_4_ELEMENT_TYPE = associate(PackageDeclarationFactory.createPackageDeclaration_RightCurlyBracketKeyword_4ElementType());

	private static class EntityFactory {
		public static IGrammarAwareElementType createEntityElementType() {
			return new IGrammarAwareElementType("Entity_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityRule());
		}
		public static IGrammarAwareElementType createEntity_GroupElementType() {
			return new IGrammarAwareElementType("Entity_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getGroup());
		}
		public static IGrammarAwareElementType createEntity_EntityKeyword_0ElementType() {
			return new IGrammarAwareElementType("Entity_EntityKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getEntityKeyword_0());
		}
		public static IGrammarAwareElementType createEntity_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Entity_NameAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createEntity_NameValidIDParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Entity_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getNameValidIDParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createEntity_Group_2ElementType() {
			return new IGrammarAwareElementType("Entity_Group_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createEntity_ExtendsKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Entity_ExtendsKeyword_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getExtendsKeyword_2_0());
		}
		public static IGrammarAwareElementType createEntity_SuperTypeAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Entity_SuperTypeAssignment_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getSuperTypeAssignment_2_1());
		}
		public static IGrammarAwareElementType createEntity_SuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Entity_SuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getSuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createEntity_LeftCurlyBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("Entity_LeftCurlyBracketKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getLeftCurlyBracketKeyword_3());
		}
		public static IGrammarAwareElementType createEntity_FeaturesAssignment_4ElementType() {
			return new IGrammarAwareElementType("Entity_FeaturesAssignment_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getFeaturesAssignment_4());
		}
		public static IGrammarAwareElementType createEntity_FeaturesFeatureParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Entity_FeaturesFeatureParserRuleCall_4_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getFeaturesFeatureParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createEntity_RightCurlyBracketKeyword_5ElementType() {
			return new IGrammarAwareElementType("Entity_RightCurlyBracketKeyword_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getRightCurlyBracketKeyword_5());
		}
	}

	public static final IGrammarAwareElementType Entity_ELEMENT_TYPE = associate(EntityFactory.createEntityElementType());

	public static final IGrammarAwareElementType Entity_Group_ELEMENT_TYPE = associate(EntityFactory.createEntity_GroupElementType());

	public static final IGrammarAwareElementType Entity_EntityKeyword_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_EntityKeyword_0ElementType());

	public static final IGrammarAwareElementType Entity_NameAssignment_1_ELEMENT_TYPE = associate(EntityFactory.createEntity_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Entity_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_NameValidIDParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Entity_Group_2_ELEMENT_TYPE = associate(EntityFactory.createEntity_Group_2ElementType());

	public static final IGrammarAwareElementType Entity_ExtendsKeyword_2_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_ExtendsKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Entity_SuperTypeAssignment_2_1_ELEMENT_TYPE = associate(EntityFactory.createEntity_SuperTypeAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Entity_SuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_SuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Entity_LeftCurlyBracketKeyword_3_ELEMENT_TYPE = associate(EntityFactory.createEntity_LeftCurlyBracketKeyword_3ElementType());

	public static final IGrammarAwareElementType Entity_FeaturesAssignment_4_ELEMENT_TYPE = associate(EntityFactory.createEntity_FeaturesAssignment_4ElementType());

	public static final IGrammarAwareElementType Entity_FeaturesFeatureParserRuleCall_4_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_FeaturesFeatureParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Entity_RightCurlyBracketKeyword_5_ELEMENT_TYPE = associate(EntityFactory.createEntity_RightCurlyBracketKeyword_5ElementType());

	private static class FeatureFactory {
		public static IGrammarAwareElementType createFeatureElementType() {
			return new IGrammarAwareElementType("Feature_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureRule());
		}
		public static IGrammarAwareElementType createFeature_AlternativesElementType() {
			return new IGrammarAwareElementType("Feature_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createFeature_PropertyParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Feature_PropertyParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureAccess().getPropertyParserRuleCall_0());
		}
		public static IGrammarAwareElementType createFeature_OperationParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Feature_OperationParserRuleCall_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureAccess().getOperationParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Feature_ELEMENT_TYPE = associate(FeatureFactory.createFeatureElementType());

	public static final IGrammarAwareElementType Feature_Alternatives_ELEMENT_TYPE = associate(FeatureFactory.createFeature_AlternativesElementType());

	public static final IGrammarAwareElementType Feature_PropertyParserRuleCall_0_ELEMENT_TYPE = associate(FeatureFactory.createFeature_PropertyParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Feature_OperationParserRuleCall_1_ELEMENT_TYPE = associate(FeatureFactory.createFeature_OperationParserRuleCall_1ElementType());

	private static class PropertyFactory {
		public static IGrammarAwareElementType createPropertyElementType() {
			return new IGrammarAwareElementType("Property_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyRule());
		}
		public static IGrammarAwareElementType createProperty_GroupElementType() {
			return new IGrammarAwareElementType("Property_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getGroup());
		}
		public static IGrammarAwareElementType createProperty_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Property_NameAssignment_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createProperty_NameValidIDParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Property_NameValidIDParserRuleCall_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getNameValidIDParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createProperty_ColonKeyword_1ElementType() {
			return new IGrammarAwareElementType("Property_ColonKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getColonKeyword_1());
		}
		public static IGrammarAwareElementType createProperty_TypeAssignment_2ElementType() {
			return new IGrammarAwareElementType("Property_TypeAssignment_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getTypeAssignment_2());
		}
		public static IGrammarAwareElementType createProperty_TypeJvmTypeReferenceParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Property_TypeJvmTypeReferenceParserRuleCall_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getTypeJvmTypeReferenceParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Property_ELEMENT_TYPE = associate(PropertyFactory.createPropertyElementType());

	public static final IGrammarAwareElementType Property_Group_ELEMENT_TYPE = associate(PropertyFactory.createProperty_GroupElementType());

	public static final IGrammarAwareElementType Property_NameAssignment_0_ELEMENT_TYPE = associate(PropertyFactory.createProperty_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Property_NameValidIDParserRuleCall_0_0_ELEMENT_TYPE = associate(PropertyFactory.createProperty_NameValidIDParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Property_ColonKeyword_1_ELEMENT_TYPE = associate(PropertyFactory.createProperty_ColonKeyword_1ElementType());

	public static final IGrammarAwareElementType Property_TypeAssignment_2_ELEMENT_TYPE = associate(PropertyFactory.createProperty_TypeAssignment_2ElementType());

	public static final IGrammarAwareElementType Property_TypeJvmTypeReferenceParserRuleCall_2_0_ELEMENT_TYPE = associate(PropertyFactory.createProperty_TypeJvmTypeReferenceParserRuleCall_2_0ElementType());

	private static class OperationFactory {
		public static IGrammarAwareElementType createOperationElementType() {
			return new IGrammarAwareElementType("Operation_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationRule());
		}
		public static IGrammarAwareElementType createOperation_GroupElementType() {
			return new IGrammarAwareElementType("Operation_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getGroup());
		}
		public static IGrammarAwareElementType createOperation_OpKeyword_0ElementType() {
			return new IGrammarAwareElementType("Operation_OpKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getOpKeyword_0());
		}
		public static IGrammarAwareElementType createOperation_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Operation_NameAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createOperation_NameValidIDParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Operation_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getNameValidIDParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createOperation_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("Operation_LeftParenthesisKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createOperation_Group_3ElementType() {
			return new IGrammarAwareElementType("Operation_Group_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createOperation_ParamsAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("Operation_ParamsAssignment_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getParamsAssignment_3_0());
		}
		public static IGrammarAwareElementType createOperation_ParamsFullJvmFormalParameterParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("Operation_ParamsFullJvmFormalParameterParserRuleCall_3_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getParamsFullJvmFormalParameterParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createOperation_Group_3_1ElementType() {
			return new IGrammarAwareElementType("Operation_Group_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createOperation_CommaKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("Operation_CommaKeyword_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getCommaKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createOperation_ParamsAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("Operation_ParamsAssignment_3_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getParamsAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createOperation_ParamsFullJvmFormalParameterParserRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("Operation_ParamsFullJvmFormalParameterParserRuleCall_3_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getParamsFullJvmFormalParameterParserRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createOperation_RightParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("Operation_RightParenthesisKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getRightParenthesisKeyword_4());
		}
		public static IGrammarAwareElementType createOperation_Group_5ElementType() {
			return new IGrammarAwareElementType("Operation_Group_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createOperation_ColonKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("Operation_ColonKeyword_5_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getColonKeyword_5_0());
		}
		public static IGrammarAwareElementType createOperation_TypeAssignment_5_1ElementType() {
			return new IGrammarAwareElementType("Operation_TypeAssignment_5_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getTypeAssignment_5_1());
		}
		public static IGrammarAwareElementType createOperation_TypeJvmTypeReferenceParserRuleCall_5_1_0ElementType() {
			return new IGrammarAwareElementType("Operation_TypeJvmTypeReferenceParserRuleCall_5_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getTypeJvmTypeReferenceParserRuleCall_5_1_0());
		}
		public static IGrammarAwareElementType createOperation_BodyAssignment_6ElementType() {
			return new IGrammarAwareElementType("Operation_BodyAssignment_6_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getBodyAssignment_6());
		}
		public static IGrammarAwareElementType createOperation_BodyXBlockExpressionParserRuleCall_6_0ElementType() {
			return new IGrammarAwareElementType("Operation_BodyXBlockExpressionParserRuleCall_6_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOperationAccess().getBodyXBlockExpressionParserRuleCall_6_0());
		}
	}

	public static final IGrammarAwareElementType Operation_ELEMENT_TYPE = associate(OperationFactory.createOperationElementType());

	public static final IGrammarAwareElementType Operation_Group_ELEMENT_TYPE = associate(OperationFactory.createOperation_GroupElementType());

	public static final IGrammarAwareElementType Operation_OpKeyword_0_ELEMENT_TYPE = associate(OperationFactory.createOperation_OpKeyword_0ElementType());

	public static final IGrammarAwareElementType Operation_NameAssignment_1_ELEMENT_TYPE = associate(OperationFactory.createOperation_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Operation_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE = associate(OperationFactory.createOperation_NameValidIDParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Operation_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(OperationFactory.createOperation_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType Operation_Group_3_ELEMENT_TYPE = associate(OperationFactory.createOperation_Group_3ElementType());

	public static final IGrammarAwareElementType Operation_ParamsAssignment_3_0_ELEMENT_TYPE = associate(OperationFactory.createOperation_ParamsAssignment_3_0ElementType());

	public static final IGrammarAwareElementType Operation_ParamsFullJvmFormalParameterParserRuleCall_3_0_0_ELEMENT_TYPE = associate(OperationFactory.createOperation_ParamsFullJvmFormalParameterParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType Operation_Group_3_1_ELEMENT_TYPE = associate(OperationFactory.createOperation_Group_3_1ElementType());

	public static final IGrammarAwareElementType Operation_CommaKeyword_3_1_0_ELEMENT_TYPE = associate(OperationFactory.createOperation_CommaKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType Operation_ParamsAssignment_3_1_1_ELEMENT_TYPE = associate(OperationFactory.createOperation_ParamsAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType Operation_ParamsFullJvmFormalParameterParserRuleCall_3_1_1_0_ELEMENT_TYPE = associate(OperationFactory.createOperation_ParamsFullJvmFormalParameterParserRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType Operation_RightParenthesisKeyword_4_ELEMENT_TYPE = associate(OperationFactory.createOperation_RightParenthesisKeyword_4ElementType());

	public static final IGrammarAwareElementType Operation_Group_5_ELEMENT_TYPE = associate(OperationFactory.createOperation_Group_5ElementType());

	public static final IGrammarAwareElementType Operation_ColonKeyword_5_0_ELEMENT_TYPE = associate(OperationFactory.createOperation_ColonKeyword_5_0ElementType());

	public static final IGrammarAwareElementType Operation_TypeAssignment_5_1_ELEMENT_TYPE = associate(OperationFactory.createOperation_TypeAssignment_5_1ElementType());

	public static final IGrammarAwareElementType Operation_TypeJvmTypeReferenceParserRuleCall_5_1_0_ELEMENT_TYPE = associate(OperationFactory.createOperation_TypeJvmTypeReferenceParserRuleCall_5_1_0ElementType());

	public static final IGrammarAwareElementType Operation_BodyAssignment_6_ELEMENT_TYPE = associate(OperationFactory.createOperation_BodyAssignment_6ElementType());

	public static final IGrammarAwareElementType Operation_BodyXBlockExpressionParserRuleCall_6_0_ELEMENT_TYPE = associate(OperationFactory.createOperation_BodyXBlockExpressionParserRuleCall_6_0ElementType());

	private static class XExpressionFactory {
		public static IGrammarAwareElementType createXExpressionElementType() {
			return new IGrammarAwareElementType("XExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionRule());
		}
		public static IGrammarAwareElementType createXExpression_XAssignmentParserRuleCallElementType() {
			return new IGrammarAwareElementType("XExpression_XAssignmentParserRuleCall_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionAccess().getXAssignmentParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType XExpression_ELEMENT_TYPE = associate(XExpressionFactory.createXExpressionElementType());

	public static final IGrammarAwareElementType XExpression_XAssignmentParserRuleCall_ELEMENT_TYPE = associate(XExpressionFactory.createXExpression_XAssignmentParserRuleCallElementType());

	private static class XAssignmentFactory {
		public static IGrammarAwareElementType createXAssignmentElementType() {
			return new IGrammarAwareElementType("XAssignment_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentRule());
		}
		public static IGrammarAwareElementType createXAssignment_AlternativesElementType() {
			return new IGrammarAwareElementType("XAssignment_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createXAssignment_Group_0ElementType() {
			return new IGrammarAwareElementType("XAssignment_Group_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createXAssignment_XAssignmentAction_0_0ElementType() {
			return new IGrammarAwareElementType("XAssignment_XAssignmentAction_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getXAssignmentAction_0_0());
		}
		public static IGrammarAwareElementType createXAssignment_FeatureAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("XAssignment_FeatureAssignment_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getFeatureAssignment_0_1());
		}
		public static IGrammarAwareElementType createXAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType() {
			return new IGrammarAwareElementType("XAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
		}
		public static IGrammarAwareElementType createXAssignment_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XAssignment_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1());
		}
		public static IGrammarAwareElementType createXAssignment_OpSingleAssignParserRuleCall_0_2ElementType() {
			return new IGrammarAwareElementType("XAssignment_OpSingleAssignParserRuleCall_0_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2());
		}
		public static IGrammarAwareElementType createXAssignment_ValueAssignment_0_3ElementType() {
			return new IGrammarAwareElementType("XAssignment_ValueAssignment_0_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getValueAssignment_0_3());
		}
		public static IGrammarAwareElementType createXAssignment_ValueXAssignmentParserRuleCall_0_3_0ElementType() {
			return new IGrammarAwareElementType("XAssignment_ValueXAssignmentParserRuleCall_0_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0());
		}
		public static IGrammarAwareElementType createXAssignment_Group_1ElementType() {
			return new IGrammarAwareElementType("XAssignment_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXAssignment_XOrExpressionParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("XAssignment_XOrExpressionParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createXAssignment_Group_1_1ElementType() {
			return new IGrammarAwareElementType("XAssignment_Group_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createXAssignment_Group_1_1_0ElementType() {
			return new IGrammarAwareElementType("XAssignment_Group_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getGroup_1_1_0());
		}
		public static IGrammarAwareElementType createXAssignment_Group_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("XAssignment_Group_1_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getGroup_1_1_0_0());
		}
		public static IGrammarAwareElementType createXAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0());
		}
		public static IGrammarAwareElementType createXAssignment_FeatureAssignment_1_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XAssignment_FeatureAssignment_1_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getFeatureAssignment_1_1_0_0_1());
		}
		public static IGrammarAwareElementType createXAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createXAssignment_FeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XAssignment_FeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1());
		}
		public static IGrammarAwareElementType createXAssignment_RightOperandAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("XAssignment_RightOperandAssignment_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getRightOperandAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createXAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XAssignment_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignmentElementType());

	public static final IGrammarAwareElementType XAssignment_Alternatives_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_AlternativesElementType());

	public static final IGrammarAwareElementType XAssignment_Group_0_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_Group_0ElementType());

	public static final IGrammarAwareElementType XAssignment_XAssignmentAction_0_0_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_XAssignmentAction_0_0ElementType());

	public static final IGrammarAwareElementType XAssignment_FeatureAssignment_0_1_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_FeatureAssignment_0_1ElementType());

	public static final IGrammarAwareElementType XAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType());

	public static final IGrammarAwareElementType XAssignment_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1ElementType());

	public static final IGrammarAwareElementType XAssignment_OpSingleAssignParserRuleCall_0_2_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_OpSingleAssignParserRuleCall_0_2ElementType());

	public static final IGrammarAwareElementType XAssignment_ValueAssignment_0_3_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_ValueAssignment_0_3ElementType());

	public static final IGrammarAwareElementType XAssignment_ValueXAssignmentParserRuleCall_0_3_0_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_ValueXAssignmentParserRuleCall_0_3_0ElementType());

	public static final IGrammarAwareElementType XAssignment_Group_1_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_Group_1ElementType());

	public static final IGrammarAwareElementType XAssignment_XOrExpressionParserRuleCall_1_0_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_XOrExpressionParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType XAssignment_Group_1_1_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_Group_1_1ElementType());

	public static final IGrammarAwareElementType XAssignment_Group_1_1_0_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_Group_1_1_0ElementType());

	public static final IGrammarAwareElementType XAssignment_Group_1_1_0_0_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_Group_1_1_0_0ElementType());

	public static final IGrammarAwareElementType XAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XAssignment_FeatureAssignment_1_1_0_0_1_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_FeatureAssignment_1_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XAssignment_FeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_FeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1ElementType());

	public static final IGrammarAwareElementType XAssignment_RightOperandAssignment_1_1_1_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_RightOperandAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType XAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(XAssignmentFactory.createXAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0ElementType());

	private static class OpSingleAssignFactory {
		public static IGrammarAwareElementType createOpSingleAssignElementType() {
			return new IGrammarAwareElementType("OpSingleAssign_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpSingleAssignRule());
		}
		public static IGrammarAwareElementType createOpSingleAssign_EqualsSignKeywordElementType() {
			return new IGrammarAwareElementType("OpSingleAssign_EqualsSignKeyword_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpSingleAssignAccess().getEqualsSignKeyword());
		}
	}

	public static final IGrammarAwareElementType OpSingleAssign_ELEMENT_TYPE = associate(OpSingleAssignFactory.createOpSingleAssignElementType());

	public static final IGrammarAwareElementType OpSingleAssign_EqualsSignKeyword_ELEMENT_TYPE = associate(OpSingleAssignFactory.createOpSingleAssign_EqualsSignKeywordElementType());

	private static class OpMultiAssignFactory {
		public static IGrammarAwareElementType createOpMultiAssignElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignRule());
		}
		public static IGrammarAwareElementType createOpMultiAssign_AlternativesElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createOpMultiAssign_PlusSignEqualsSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_PlusSignEqualsSignKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
		}
		public static IGrammarAwareElementType createOpMultiAssign_HyphenMinusEqualsSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_HyphenMinusEqualsSignKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
		}
		public static IGrammarAwareElementType createOpMultiAssign_AsteriskEqualsSignKeyword_2ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_AsteriskEqualsSignKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
		}
		public static IGrammarAwareElementType createOpMultiAssign_SolidusEqualsSignKeyword_3ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_SolidusEqualsSignKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
		}
		public static IGrammarAwareElementType createOpMultiAssign_PercentSignEqualsSignKeyword_4ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_PercentSignEqualsSignKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
		}
		public static IGrammarAwareElementType createOpMultiAssign_Group_5ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_Group_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createOpMultiAssign_LessThanSignKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_LessThanSignKeyword_5_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getLessThanSignKeyword_5_0());
		}
		public static IGrammarAwareElementType createOpMultiAssign_LessThanSignKeyword_5_1ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_LessThanSignKeyword_5_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getLessThanSignKeyword_5_1());
		}
		public static IGrammarAwareElementType createOpMultiAssign_EqualsSignKeyword_5_2ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_EqualsSignKeyword_5_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getEqualsSignKeyword_5_2());
		}
		public static IGrammarAwareElementType createOpMultiAssign_Group_6ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_Group_6_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getGroup_6());
		}
		public static IGrammarAwareElementType createOpMultiAssign_GreaterThanSignKeyword_6_0ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_GreaterThanSignKeyword_6_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_0());
		}
		public static IGrammarAwareElementType createOpMultiAssign_GreaterThanSignKeyword_6_1ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_GreaterThanSignKeyword_6_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_1());
		}
		public static IGrammarAwareElementType createOpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2ElementType() {
			return new IGrammarAwareElementType("OpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_6_2());
		}
	}

	public static final IGrammarAwareElementType OpMultiAssign_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssignElementType());

	public static final IGrammarAwareElementType OpMultiAssign_Alternatives_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_AlternativesElementType());

	public static final IGrammarAwareElementType OpMultiAssign_PlusSignEqualsSignKeyword_0_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_PlusSignEqualsSignKeyword_0ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_HyphenMinusEqualsSignKeyword_1_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_HyphenMinusEqualsSignKeyword_1ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_AsteriskEqualsSignKeyword_2_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_AsteriskEqualsSignKeyword_2ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_SolidusEqualsSignKeyword_3_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_SolidusEqualsSignKeyword_3ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_PercentSignEqualsSignKeyword_4_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_PercentSignEqualsSignKeyword_4ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_Group_5_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_Group_5ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_LessThanSignKeyword_5_0_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_LessThanSignKeyword_5_0ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_LessThanSignKeyword_5_1_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_LessThanSignKeyword_5_1ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_EqualsSignKeyword_5_2_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_EqualsSignKeyword_5_2ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_Group_6_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_Group_6ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_GreaterThanSignKeyword_6_0_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_GreaterThanSignKeyword_6_0ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_GreaterThanSignKeyword_6_1_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_GreaterThanSignKeyword_6_1ElementType());

	public static final IGrammarAwareElementType OpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2_ELEMENT_TYPE = associate(OpMultiAssignFactory.createOpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2ElementType());

	private static class XOrExpressionFactory {
		public static IGrammarAwareElementType createXOrExpressionElementType() {
			return new IGrammarAwareElementType("XOrExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionRule());
		}
		public static IGrammarAwareElementType createXOrExpression_GroupElementType() {
			return new IGrammarAwareElementType("XOrExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXOrExpression_XAndExpressionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XOrExpression_XAndExpressionParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXOrExpression_Group_1ElementType() {
			return new IGrammarAwareElementType("XOrExpression_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXOrExpression_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XOrExpression_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXOrExpression_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("XOrExpression_Group_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createXOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0());
		}
		public static IGrammarAwareElementType createXOrExpression_FeatureAssignment_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XOrExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getFeatureAssignment_1_0_0_1());
		}
		public static IGrammarAwareElementType createXOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createXOrExpression_FeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XOrExpression_FeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1());
		}
		public static IGrammarAwareElementType createXOrExpression_RightOperandAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("XOrExpression_RightOperandAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getRightOperandAssignment_1_1());
		}
		public static IGrammarAwareElementType createXOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("XOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XOrExpression_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpressionElementType());

	public static final IGrammarAwareElementType XOrExpression_Group_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_GroupElementType());

	public static final IGrammarAwareElementType XOrExpression_XAndExpressionParserRuleCall_0_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_XAndExpressionParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XOrExpression_Group_1_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_Group_1ElementType());

	public static final IGrammarAwareElementType XOrExpression_Group_1_0_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_Group_1_0ElementType());

	public static final IGrammarAwareElementType XOrExpression_Group_1_0_0_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType XOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XOrExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_FeatureAssignment_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XOrExpression_FeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_FeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1ElementType());

	public static final IGrammarAwareElementType XOrExpression_RightOperandAssignment_1_1_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_RightOperandAssignment_1_1ElementType());

	public static final IGrammarAwareElementType XOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0_ELEMENT_TYPE = associate(XOrExpressionFactory.createXOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0ElementType());

	private static class OpOrFactory {
		public static IGrammarAwareElementType createOpOrElementType() {
			return new IGrammarAwareElementType("OpOr_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOrRule());
		}
		public static IGrammarAwareElementType createOpOr_VerticalLineVerticalLineKeywordElementType() {
			return new IGrammarAwareElementType("OpOr_VerticalLineVerticalLineKeyword_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOrAccess().getVerticalLineVerticalLineKeyword());
		}
	}

	public static final IGrammarAwareElementType OpOr_ELEMENT_TYPE = associate(OpOrFactory.createOpOrElementType());

	public static final IGrammarAwareElementType OpOr_VerticalLineVerticalLineKeyword_ELEMENT_TYPE = associate(OpOrFactory.createOpOr_VerticalLineVerticalLineKeywordElementType());

	private static class XAndExpressionFactory {
		public static IGrammarAwareElementType createXAndExpressionElementType() {
			return new IGrammarAwareElementType("XAndExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionRule());
		}
		public static IGrammarAwareElementType createXAndExpression_GroupElementType() {
			return new IGrammarAwareElementType("XAndExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXAndExpression_XEqualityExpressionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XAndExpression_XEqualityExpressionParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXAndExpression_Group_1ElementType() {
			return new IGrammarAwareElementType("XAndExpression_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXAndExpression_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XAndExpression_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXAndExpression_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("XAndExpression_Group_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createXAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0());
		}
		public static IGrammarAwareElementType createXAndExpression_FeatureAssignment_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XAndExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getFeatureAssignment_1_0_0_1());
		}
		public static IGrammarAwareElementType createXAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createXAndExpression_FeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XAndExpression_FeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1());
		}
		public static IGrammarAwareElementType createXAndExpression_RightOperandAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("XAndExpression_RightOperandAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getRightOperandAssignment_1_1());
		}
		public static IGrammarAwareElementType createXAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("XAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XAndExpression_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpressionElementType());

	public static final IGrammarAwareElementType XAndExpression_Group_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_GroupElementType());

	public static final IGrammarAwareElementType XAndExpression_XEqualityExpressionParserRuleCall_0_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_XEqualityExpressionParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XAndExpression_Group_1_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_Group_1ElementType());

	public static final IGrammarAwareElementType XAndExpression_Group_1_0_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_Group_1_0ElementType());

	public static final IGrammarAwareElementType XAndExpression_Group_1_0_0_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType XAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XAndExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_FeatureAssignment_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XAndExpression_FeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_FeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1ElementType());

	public static final IGrammarAwareElementType XAndExpression_RightOperandAssignment_1_1_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_RightOperandAssignment_1_1ElementType());

	public static final IGrammarAwareElementType XAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0_ELEMENT_TYPE = associate(XAndExpressionFactory.createXAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0ElementType());

	private static class OpAndFactory {
		public static IGrammarAwareElementType createOpAndElementType() {
			return new IGrammarAwareElementType("OpAnd_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAndRule());
		}
		public static IGrammarAwareElementType createOpAnd_AmpersandAmpersandKeywordElementType() {
			return new IGrammarAwareElementType("OpAnd_AmpersandAmpersandKeyword_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAndAccess().getAmpersandAmpersandKeyword());
		}
	}

	public static final IGrammarAwareElementType OpAnd_ELEMENT_TYPE = associate(OpAndFactory.createOpAndElementType());

	public static final IGrammarAwareElementType OpAnd_AmpersandAmpersandKeyword_ELEMENT_TYPE = associate(OpAndFactory.createOpAnd_AmpersandAmpersandKeywordElementType());

	private static class XEqualityExpressionFactory {
		public static IGrammarAwareElementType createXEqualityExpressionElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionRule());
		}
		public static IGrammarAwareElementType createXEqualityExpression_GroupElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXEqualityExpression_XRelationalExpressionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_XRelationalExpressionParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXEqualityExpression_Group_1ElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXEqualityExpression_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXEqualityExpression_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_Group_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createXEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0());
		}
		public static IGrammarAwareElementType createXEqualityExpression_FeatureAssignment_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getFeatureAssignment_1_0_0_1());
		}
		public static IGrammarAwareElementType createXEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createXEqualityExpression_FeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_FeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1());
		}
		public static IGrammarAwareElementType createXEqualityExpression_RightOperandAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_RightOperandAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getRightOperandAssignment_1_1());
		}
		public static IGrammarAwareElementType createXEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("XEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XEqualityExpression_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpressionElementType());

	public static final IGrammarAwareElementType XEqualityExpression_Group_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_GroupElementType());

	public static final IGrammarAwareElementType XEqualityExpression_XRelationalExpressionParserRuleCall_0_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_XRelationalExpressionParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XEqualityExpression_Group_1_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_Group_1ElementType());

	public static final IGrammarAwareElementType XEqualityExpression_Group_1_0_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_Group_1_0ElementType());

	public static final IGrammarAwareElementType XEqualityExpression_Group_1_0_0_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType XEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XEqualityExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_FeatureAssignment_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XEqualityExpression_FeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_FeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1ElementType());

	public static final IGrammarAwareElementType XEqualityExpression_RightOperandAssignment_1_1_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_RightOperandAssignment_1_1ElementType());

	public static final IGrammarAwareElementType XEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0_ELEMENT_TYPE = associate(XEqualityExpressionFactory.createXEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0ElementType());

	private static class OpEqualityFactory {
		public static IGrammarAwareElementType createOpEqualityElementType() {
			return new IGrammarAwareElementType("OpEquality_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpEqualityRule());
		}
		public static IGrammarAwareElementType createOpEquality_AlternativesElementType() {
			return new IGrammarAwareElementType("OpEquality_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpEqualityAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createOpEquality_EqualsSignEqualsSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("OpEquality_EqualsSignEqualsSignKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
		}
		public static IGrammarAwareElementType createOpEquality_ExclamationMarkEqualsSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("OpEquality_ExclamationMarkEqualsSignKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
		}
		public static IGrammarAwareElementType createOpEquality_EqualsSignEqualsSignEqualsSignKeyword_2ElementType() {
			return new IGrammarAwareElementType("OpEquality_EqualsSignEqualsSignEqualsSignKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpEqualityAccess().getEqualsSignEqualsSignEqualsSignKeyword_2());
		}
		public static IGrammarAwareElementType createOpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3ElementType() {
			return new IGrammarAwareElementType("OpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpEqualityAccess().getExclamationMarkEqualsSignEqualsSignKeyword_3());
		}
	}

	public static final IGrammarAwareElementType OpEquality_ELEMENT_TYPE = associate(OpEqualityFactory.createOpEqualityElementType());

	public static final IGrammarAwareElementType OpEquality_Alternatives_ELEMENT_TYPE = associate(OpEqualityFactory.createOpEquality_AlternativesElementType());

	public static final IGrammarAwareElementType OpEquality_EqualsSignEqualsSignKeyword_0_ELEMENT_TYPE = associate(OpEqualityFactory.createOpEquality_EqualsSignEqualsSignKeyword_0ElementType());

	public static final IGrammarAwareElementType OpEquality_ExclamationMarkEqualsSignKeyword_1_ELEMENT_TYPE = associate(OpEqualityFactory.createOpEquality_ExclamationMarkEqualsSignKeyword_1ElementType());

	public static final IGrammarAwareElementType OpEquality_EqualsSignEqualsSignEqualsSignKeyword_2_ELEMENT_TYPE = associate(OpEqualityFactory.createOpEquality_EqualsSignEqualsSignEqualsSignKeyword_2ElementType());

	public static final IGrammarAwareElementType OpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3_ELEMENT_TYPE = associate(OpEqualityFactory.createOpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3ElementType());

	private static class XRelationalExpressionFactory {
		public static IGrammarAwareElementType createXRelationalExpressionElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionRule());
		}
		public static IGrammarAwareElementType createXRelationalExpression_GroupElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXRelationalExpression_XOtherOperatorExpressionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_XOtherOperatorExpressionParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXRelationalExpression_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_Alternatives_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createXRelationalExpression_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXRelationalExpression_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_Group_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createXRelationalExpression_Group_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_Group_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getGroup_1_0_0_0());
		}
		public static IGrammarAwareElementType createXRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0());
		}
		public static IGrammarAwareElementType createXRelationalExpression_InstanceofKeyword_1_0_0_0_1ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_InstanceofKeyword_1_0_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
		}
		public static IGrammarAwareElementType createXRelationalExpression_TypeAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_TypeAssignment_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getTypeAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createXRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createXRelationalExpression_Group_1_1ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_Group_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createXRelationalExpression_Group_1_1_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_Group_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getGroup_1_1_0());
		}
		public static IGrammarAwareElementType createXRelationalExpression_Group_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_Group_1_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getGroup_1_1_0_0());
		}
		public static IGrammarAwareElementType createXRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0());
		}
		public static IGrammarAwareElementType createXRelationalExpression_FeatureAssignment_1_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_FeatureAssignment_1_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getFeatureAssignment_1_1_0_0_1());
		}
		public static IGrammarAwareElementType createXRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createXRelationalExpression_FeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_FeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1());
		}
		public static IGrammarAwareElementType createXRelationalExpression_RightOperandAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_RightOperandAssignment_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getRightOperandAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createXRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XRelationalExpression_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpressionElementType());

	public static final IGrammarAwareElementType XRelationalExpression_Group_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_GroupElementType());

	public static final IGrammarAwareElementType XRelationalExpression_XOtherOperatorExpressionParserRuleCall_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_XOtherOperatorExpressionParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_Alternatives_1_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_Alternatives_1ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_Group_1_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_Group_1_0ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_Group_1_0_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_Group_1_0_0_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_Group_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_InstanceofKeyword_1_0_0_0_1_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_InstanceofKeyword_1_0_0_0_1ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_TypeAssignment_1_0_1_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_TypeAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_Group_1_1_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_Group_1_1ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_Group_1_1_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_Group_1_1_0ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_Group_1_1_0_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_Group_1_1_0_0ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_FeatureAssignment_1_1_0_0_1_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_FeatureAssignment_1_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_FeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_FeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_RightOperandAssignment_1_1_1_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_RightOperandAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType XRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(XRelationalExpressionFactory.createXRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0ElementType());

	private static class OpCompareFactory {
		public static IGrammarAwareElementType createOpCompareElementType() {
			return new IGrammarAwareElementType("OpCompare_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpCompareRule());
		}
		public static IGrammarAwareElementType createOpCompare_AlternativesElementType() {
			return new IGrammarAwareElementType("OpCompare_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpCompareAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createOpCompare_GreaterThanSignEqualsSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("OpCompare_GreaterThanSignEqualsSignKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
		}
		public static IGrammarAwareElementType createOpCompare_Group_1ElementType() {
			return new IGrammarAwareElementType("OpCompare_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpCompareAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createOpCompare_LessThanSignKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("OpCompare_LessThanSignKeyword_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpCompareAccess().getLessThanSignKeyword_1_0());
		}
		public static IGrammarAwareElementType createOpCompare_EqualsSignKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("OpCompare_EqualsSignKeyword_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpCompareAccess().getEqualsSignKeyword_1_1());
		}
		public static IGrammarAwareElementType createOpCompare_GreaterThanSignKeyword_2ElementType() {
			return new IGrammarAwareElementType("OpCompare_GreaterThanSignKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpCompareAccess().getGreaterThanSignKeyword_2());
		}
		public static IGrammarAwareElementType createOpCompare_LessThanSignKeyword_3ElementType() {
			return new IGrammarAwareElementType("OpCompare_LessThanSignKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpCompareAccess().getLessThanSignKeyword_3());
		}
	}

	public static final IGrammarAwareElementType OpCompare_ELEMENT_TYPE = associate(OpCompareFactory.createOpCompareElementType());

	public static final IGrammarAwareElementType OpCompare_Alternatives_ELEMENT_TYPE = associate(OpCompareFactory.createOpCompare_AlternativesElementType());

	public static final IGrammarAwareElementType OpCompare_GreaterThanSignEqualsSignKeyword_0_ELEMENT_TYPE = associate(OpCompareFactory.createOpCompare_GreaterThanSignEqualsSignKeyword_0ElementType());

	public static final IGrammarAwareElementType OpCompare_Group_1_ELEMENT_TYPE = associate(OpCompareFactory.createOpCompare_Group_1ElementType());

	public static final IGrammarAwareElementType OpCompare_LessThanSignKeyword_1_0_ELEMENT_TYPE = associate(OpCompareFactory.createOpCompare_LessThanSignKeyword_1_0ElementType());

	public static final IGrammarAwareElementType OpCompare_EqualsSignKeyword_1_1_ELEMENT_TYPE = associate(OpCompareFactory.createOpCompare_EqualsSignKeyword_1_1ElementType());

	public static final IGrammarAwareElementType OpCompare_GreaterThanSignKeyword_2_ELEMENT_TYPE = associate(OpCompareFactory.createOpCompare_GreaterThanSignKeyword_2ElementType());

	public static final IGrammarAwareElementType OpCompare_LessThanSignKeyword_3_ELEMENT_TYPE = associate(OpCompareFactory.createOpCompare_LessThanSignKeyword_3ElementType());

	private static class XOtherOperatorExpressionFactory {
		public static IGrammarAwareElementType createXOtherOperatorExpressionElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionRule());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_GroupElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_Group_1ElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_Group_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_FeatureAssignment_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_FeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_FeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_RightOperandAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_RightOperandAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getRightOperandAssignment_1_1());
		}
		public static IGrammarAwareElementType createXOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("XOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XOtherOperatorExpression_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpressionElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_Group_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_GroupElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_Group_1_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_Group_1ElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_Group_1_0_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_Group_1_0ElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_Group_1_0_0_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_FeatureAssignment_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_FeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_FeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1ElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_RightOperandAssignment_1_1_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_RightOperandAssignment_1_1ElementType());

	public static final IGrammarAwareElementType XOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0_ELEMENT_TYPE = associate(XOtherOperatorExpressionFactory.createXOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0ElementType());

	private static class OpOtherFactory {
		public static IGrammarAwareElementType createOpOtherElementType() {
			return new IGrammarAwareElementType("OpOther_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherRule());
		}
		public static IGrammarAwareElementType createOpOther_AlternativesElementType() {
			return new IGrammarAwareElementType("OpOther_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createOpOther_HyphenMinusGreaterThanSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("OpOther_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0());
		}
		public static IGrammarAwareElementType createOpOther_FullStopFullStopLessThanSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("OpOther_FullStopFullStopLessThanSignKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1());
		}
		public static IGrammarAwareElementType createOpOther_Group_2ElementType() {
			return new IGrammarAwareElementType("OpOther_Group_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createOpOther_GreaterThanSignKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("OpOther_GreaterThanSignKeyword_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGreaterThanSignKeyword_2_0());
		}
		public static IGrammarAwareElementType createOpOther_FullStopFullStopKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("OpOther_FullStopFullStopKeyword_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getFullStopFullStopKeyword_2_1());
		}
		public static IGrammarAwareElementType createOpOther_FullStopFullStopKeyword_3ElementType() {
			return new IGrammarAwareElementType("OpOther_FullStopFullStopKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getFullStopFullStopKeyword_3());
		}
		public static IGrammarAwareElementType createOpOther_EqualsSignGreaterThanSignKeyword_4ElementType() {
			return new IGrammarAwareElementType("OpOther_EqualsSignGreaterThanSignKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4());
		}
		public static IGrammarAwareElementType createOpOther_Group_5ElementType() {
			return new IGrammarAwareElementType("OpOther_Group_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createOpOther_GreaterThanSignKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("OpOther_GreaterThanSignKeyword_5_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGreaterThanSignKeyword_5_0());
		}
		public static IGrammarAwareElementType createOpOther_Alternatives_5_1ElementType() {
			return new IGrammarAwareElementType("OpOther_Alternatives_5_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getAlternatives_5_1());
		}
		public static IGrammarAwareElementType createOpOther_Group_5_1_0ElementType() {
			return new IGrammarAwareElementType("OpOther_Group_5_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGroup_5_1_0());
		}
		public static IGrammarAwareElementType createOpOther_Group_5_1_0_0ElementType() {
			return new IGrammarAwareElementType("OpOther_Group_5_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGroup_5_1_0_0());
		}
		public static IGrammarAwareElementType createOpOther_GreaterThanSignKeyword_5_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("OpOther_GreaterThanSignKeyword_5_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0());
		}
		public static IGrammarAwareElementType createOpOther_GreaterThanSignKeyword_5_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("OpOther_GreaterThanSignKeyword_5_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1());
		}
		public static IGrammarAwareElementType createOpOther_GreaterThanSignKeyword_5_1_1ElementType() {
			return new IGrammarAwareElementType("OpOther_GreaterThanSignKeyword_5_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1());
		}
		public static IGrammarAwareElementType createOpOther_Group_6ElementType() {
			return new IGrammarAwareElementType("OpOther_Group_6_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGroup_6());
		}
		public static IGrammarAwareElementType createOpOther_LessThanSignKeyword_6_0ElementType() {
			return new IGrammarAwareElementType("OpOther_LessThanSignKeyword_6_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getLessThanSignKeyword_6_0());
		}
		public static IGrammarAwareElementType createOpOther_Alternatives_6_1ElementType() {
			return new IGrammarAwareElementType("OpOther_Alternatives_6_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getAlternatives_6_1());
		}
		public static IGrammarAwareElementType createOpOther_Group_6_1_0ElementType() {
			return new IGrammarAwareElementType("OpOther_Group_6_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGroup_6_1_0());
		}
		public static IGrammarAwareElementType createOpOther_Group_6_1_0_0ElementType() {
			return new IGrammarAwareElementType("OpOther_Group_6_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getGroup_6_1_0_0());
		}
		public static IGrammarAwareElementType createOpOther_LessThanSignKeyword_6_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("OpOther_LessThanSignKeyword_6_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0());
		}
		public static IGrammarAwareElementType createOpOther_LessThanSignKeyword_6_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("OpOther_LessThanSignKeyword_6_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1());
		}
		public static IGrammarAwareElementType createOpOther_LessThanSignKeyword_6_1_1ElementType() {
			return new IGrammarAwareElementType("OpOther_LessThanSignKeyword_6_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getLessThanSignKeyword_6_1_1());
		}
		public static IGrammarAwareElementType createOpOther_EqualsSignGreaterThanSignKeyword_6_1_2ElementType() {
			return new IGrammarAwareElementType("OpOther_EqualsSignGreaterThanSignKeyword_6_1_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2());
		}
		public static IGrammarAwareElementType createOpOther_LessThanSignGreaterThanSignKeyword_7ElementType() {
			return new IGrammarAwareElementType("OpOther_LessThanSignGreaterThanSignKeyword_7_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7());
		}
		public static IGrammarAwareElementType createOpOther_QuestionMarkColonKeyword_8ElementType() {
			return new IGrammarAwareElementType("OpOther_QuestionMarkColonKeyword_8_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpOtherAccess().getQuestionMarkColonKeyword_8());
		}
	}

	public static final IGrammarAwareElementType OpOther_ELEMENT_TYPE = associate(OpOtherFactory.createOpOtherElementType());

	public static final IGrammarAwareElementType OpOther_Alternatives_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_AlternativesElementType());

	public static final IGrammarAwareElementType OpOther_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_HyphenMinusGreaterThanSignKeyword_0ElementType());

	public static final IGrammarAwareElementType OpOther_FullStopFullStopLessThanSignKeyword_1_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_FullStopFullStopLessThanSignKeyword_1ElementType());

	public static final IGrammarAwareElementType OpOther_Group_2_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_Group_2ElementType());

	public static final IGrammarAwareElementType OpOther_GreaterThanSignKeyword_2_0_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_GreaterThanSignKeyword_2_0ElementType());

	public static final IGrammarAwareElementType OpOther_FullStopFullStopKeyword_2_1_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_FullStopFullStopKeyword_2_1ElementType());

	public static final IGrammarAwareElementType OpOther_FullStopFullStopKeyword_3_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_FullStopFullStopKeyword_3ElementType());

	public static final IGrammarAwareElementType OpOther_EqualsSignGreaterThanSignKeyword_4_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_EqualsSignGreaterThanSignKeyword_4ElementType());

	public static final IGrammarAwareElementType OpOther_Group_5_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_Group_5ElementType());

	public static final IGrammarAwareElementType OpOther_GreaterThanSignKeyword_5_0_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_GreaterThanSignKeyword_5_0ElementType());

	public static final IGrammarAwareElementType OpOther_Alternatives_5_1_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_Alternatives_5_1ElementType());

	public static final IGrammarAwareElementType OpOther_Group_5_1_0_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_Group_5_1_0ElementType());

	public static final IGrammarAwareElementType OpOther_Group_5_1_0_0_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_Group_5_1_0_0ElementType());

	public static final IGrammarAwareElementType OpOther_GreaterThanSignKeyword_5_1_0_0_0_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_GreaterThanSignKeyword_5_1_0_0_0ElementType());

	public static final IGrammarAwareElementType OpOther_GreaterThanSignKeyword_5_1_0_0_1_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_GreaterThanSignKeyword_5_1_0_0_1ElementType());

	public static final IGrammarAwareElementType OpOther_GreaterThanSignKeyword_5_1_1_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_GreaterThanSignKeyword_5_1_1ElementType());

	public static final IGrammarAwareElementType OpOther_Group_6_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_Group_6ElementType());

	public static final IGrammarAwareElementType OpOther_LessThanSignKeyword_6_0_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_LessThanSignKeyword_6_0ElementType());

	public static final IGrammarAwareElementType OpOther_Alternatives_6_1_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_Alternatives_6_1ElementType());

	public static final IGrammarAwareElementType OpOther_Group_6_1_0_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_Group_6_1_0ElementType());

	public static final IGrammarAwareElementType OpOther_Group_6_1_0_0_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_Group_6_1_0_0ElementType());

	public static final IGrammarAwareElementType OpOther_LessThanSignKeyword_6_1_0_0_0_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_LessThanSignKeyword_6_1_0_0_0ElementType());

	public static final IGrammarAwareElementType OpOther_LessThanSignKeyword_6_1_0_0_1_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_LessThanSignKeyword_6_1_0_0_1ElementType());

	public static final IGrammarAwareElementType OpOther_LessThanSignKeyword_6_1_1_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_LessThanSignKeyword_6_1_1ElementType());

	public static final IGrammarAwareElementType OpOther_EqualsSignGreaterThanSignKeyword_6_1_2_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_EqualsSignGreaterThanSignKeyword_6_1_2ElementType());

	public static final IGrammarAwareElementType OpOther_LessThanSignGreaterThanSignKeyword_7_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_LessThanSignGreaterThanSignKeyword_7ElementType());

	public static final IGrammarAwareElementType OpOther_QuestionMarkColonKeyword_8_ELEMENT_TYPE = associate(OpOtherFactory.createOpOther_QuestionMarkColonKeyword_8ElementType());

	private static class XAdditiveExpressionFactory {
		public static IGrammarAwareElementType createXAdditiveExpressionElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionRule());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_GroupElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_Group_1ElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_Group_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_FeatureAssignment_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_FeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_FeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_RightOperandAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_RightOperandAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getRightOperandAssignment_1_1());
		}
		public static IGrammarAwareElementType createXAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("XAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XAdditiveExpression_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpressionElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_Group_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_GroupElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_Group_1_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_Group_1ElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_Group_1_0_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_Group_1_0ElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_Group_1_0_0_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_FeatureAssignment_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_FeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_FeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1ElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_RightOperandAssignment_1_1_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_RightOperandAssignment_1_1ElementType());

	public static final IGrammarAwareElementType XAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0_ELEMENT_TYPE = associate(XAdditiveExpressionFactory.createXAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0ElementType());

	private static class OpAddFactory {
		public static IGrammarAwareElementType createOpAddElementType() {
			return new IGrammarAwareElementType("OpAdd_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAddRule());
		}
		public static IGrammarAwareElementType createOpAdd_AlternativesElementType() {
			return new IGrammarAwareElementType("OpAdd_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAddAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createOpAdd_PlusSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("OpAdd_PlusSignKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAddAccess().getPlusSignKeyword_0());
		}
		public static IGrammarAwareElementType createOpAdd_HyphenMinusKeyword_1ElementType() {
			return new IGrammarAwareElementType("OpAdd_HyphenMinusKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAddAccess().getHyphenMinusKeyword_1());
		}
	}

	public static final IGrammarAwareElementType OpAdd_ELEMENT_TYPE = associate(OpAddFactory.createOpAddElementType());

	public static final IGrammarAwareElementType OpAdd_Alternatives_ELEMENT_TYPE = associate(OpAddFactory.createOpAdd_AlternativesElementType());

	public static final IGrammarAwareElementType OpAdd_PlusSignKeyword_0_ELEMENT_TYPE = associate(OpAddFactory.createOpAdd_PlusSignKeyword_0ElementType());

	public static final IGrammarAwareElementType OpAdd_HyphenMinusKeyword_1_ELEMENT_TYPE = associate(OpAddFactory.createOpAdd_HyphenMinusKeyword_1ElementType());

	private static class XMultiplicativeExpressionFactory {
		public static IGrammarAwareElementType createXMultiplicativeExpressionElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionRule());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_GroupElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_XUnaryOperationParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_XUnaryOperationParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_Group_1ElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_Group_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_FeatureAssignment_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_FeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_FeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_RightOperandAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_RightOperandAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getRightOperandAssignment_1_1());
		}
		public static IGrammarAwareElementType createXMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("XMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XMultiplicativeExpression_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpressionElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_Group_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_GroupElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_XUnaryOperationParserRuleCall_0_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_XUnaryOperationParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_Group_1_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_Group_1ElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_Group_1_0_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_Group_1_0ElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_Group_1_0_0_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_FeatureAssignment_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_FeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_FeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1ElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_RightOperandAssignment_1_1_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_RightOperandAssignment_1_1ElementType());

	public static final IGrammarAwareElementType XMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0_ELEMENT_TYPE = associate(XMultiplicativeExpressionFactory.createXMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0ElementType());

	private static class OpMultiFactory {
		public static IGrammarAwareElementType createOpMultiElementType() {
			return new IGrammarAwareElementType("OpMulti_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiRule());
		}
		public static IGrammarAwareElementType createOpMulti_AlternativesElementType() {
			return new IGrammarAwareElementType("OpMulti_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createOpMulti_AsteriskKeyword_0ElementType() {
			return new IGrammarAwareElementType("OpMulti_AsteriskKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAccess().getAsteriskKeyword_0());
		}
		public static IGrammarAwareElementType createOpMulti_AsteriskAsteriskKeyword_1ElementType() {
			return new IGrammarAwareElementType("OpMulti_AsteriskAsteriskKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAccess().getAsteriskAsteriskKeyword_1());
		}
		public static IGrammarAwareElementType createOpMulti_SolidusKeyword_2ElementType() {
			return new IGrammarAwareElementType("OpMulti_SolidusKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAccess().getSolidusKeyword_2());
		}
		public static IGrammarAwareElementType createOpMulti_PercentSignKeyword_3ElementType() {
			return new IGrammarAwareElementType("OpMulti_PercentSignKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpMultiAccess().getPercentSignKeyword_3());
		}
	}

	public static final IGrammarAwareElementType OpMulti_ELEMENT_TYPE = associate(OpMultiFactory.createOpMultiElementType());

	public static final IGrammarAwareElementType OpMulti_Alternatives_ELEMENT_TYPE = associate(OpMultiFactory.createOpMulti_AlternativesElementType());

	public static final IGrammarAwareElementType OpMulti_AsteriskKeyword_0_ELEMENT_TYPE = associate(OpMultiFactory.createOpMulti_AsteriskKeyword_0ElementType());

	public static final IGrammarAwareElementType OpMulti_AsteriskAsteriskKeyword_1_ELEMENT_TYPE = associate(OpMultiFactory.createOpMulti_AsteriskAsteriskKeyword_1ElementType());

	public static final IGrammarAwareElementType OpMulti_SolidusKeyword_2_ELEMENT_TYPE = associate(OpMultiFactory.createOpMulti_SolidusKeyword_2ElementType());

	public static final IGrammarAwareElementType OpMulti_PercentSignKeyword_3_ELEMENT_TYPE = associate(OpMultiFactory.createOpMulti_PercentSignKeyword_3ElementType());

	private static class XUnaryOperationFactory {
		public static IGrammarAwareElementType createXUnaryOperationElementType() {
			return new IGrammarAwareElementType("XUnaryOperation_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXUnaryOperationRule());
		}
		public static IGrammarAwareElementType createXUnaryOperation_AlternativesElementType() {
			return new IGrammarAwareElementType("XUnaryOperation_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXUnaryOperationAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createXUnaryOperation_Group_0ElementType() {
			return new IGrammarAwareElementType("XUnaryOperation_Group_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXUnaryOperationAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createXUnaryOperation_XUnaryOperationAction_0_0ElementType() {
			return new IGrammarAwareElementType("XUnaryOperation_XUnaryOperationAction_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXUnaryOperationAccess().getXUnaryOperationAction_0_0());
		}
		public static IGrammarAwareElementType createXUnaryOperation_FeatureAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("XUnaryOperation_FeatureAssignment_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXUnaryOperationAccess().getFeatureAssignment_0_1());
		}
		public static IGrammarAwareElementType createXUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType() {
			return new IGrammarAwareElementType("XUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
		}
		public static IGrammarAwareElementType createXUnaryOperation_FeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XUnaryOperation_FeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1());
		}
		public static IGrammarAwareElementType createXUnaryOperation_OperandAssignment_0_2ElementType() {
			return new IGrammarAwareElementType("XUnaryOperation_OperandAssignment_0_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXUnaryOperationAccess().getOperandAssignment_0_2());
		}
		public static IGrammarAwareElementType createXUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0ElementType() {
			return new IGrammarAwareElementType("XUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0());
		}
		public static IGrammarAwareElementType createXUnaryOperation_XCastedExpressionParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("XUnaryOperation_XCastedExpressionParserRuleCall_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType XUnaryOperation_ELEMENT_TYPE = associate(XUnaryOperationFactory.createXUnaryOperationElementType());

	public static final IGrammarAwareElementType XUnaryOperation_Alternatives_ELEMENT_TYPE = associate(XUnaryOperationFactory.createXUnaryOperation_AlternativesElementType());

	public static final IGrammarAwareElementType XUnaryOperation_Group_0_ELEMENT_TYPE = associate(XUnaryOperationFactory.createXUnaryOperation_Group_0ElementType());

	public static final IGrammarAwareElementType XUnaryOperation_XUnaryOperationAction_0_0_ELEMENT_TYPE = associate(XUnaryOperationFactory.createXUnaryOperation_XUnaryOperationAction_0_0ElementType());

	public static final IGrammarAwareElementType XUnaryOperation_FeatureAssignment_0_1_ELEMENT_TYPE = associate(XUnaryOperationFactory.createXUnaryOperation_FeatureAssignment_0_1ElementType());

	public static final IGrammarAwareElementType XUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0_ELEMENT_TYPE = associate(XUnaryOperationFactory.createXUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType());

	public static final IGrammarAwareElementType XUnaryOperation_FeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1_ELEMENT_TYPE = associate(XUnaryOperationFactory.createXUnaryOperation_FeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1ElementType());

	public static final IGrammarAwareElementType XUnaryOperation_OperandAssignment_0_2_ELEMENT_TYPE = associate(XUnaryOperationFactory.createXUnaryOperation_OperandAssignment_0_2ElementType());

	public static final IGrammarAwareElementType XUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0_ELEMENT_TYPE = associate(XUnaryOperationFactory.createXUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0ElementType());

	public static final IGrammarAwareElementType XUnaryOperation_XCastedExpressionParserRuleCall_1_ELEMENT_TYPE = associate(XUnaryOperationFactory.createXUnaryOperation_XCastedExpressionParserRuleCall_1ElementType());

	private static class OpUnaryFactory {
		public static IGrammarAwareElementType createOpUnaryElementType() {
			return new IGrammarAwareElementType("OpUnary_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpUnaryRule());
		}
		public static IGrammarAwareElementType createOpUnary_AlternativesElementType() {
			return new IGrammarAwareElementType("OpUnary_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpUnaryAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createOpUnary_ExclamationMarkKeyword_0ElementType() {
			return new IGrammarAwareElementType("OpUnary_ExclamationMarkKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpUnaryAccess().getExclamationMarkKeyword_0());
		}
		public static IGrammarAwareElementType createOpUnary_HyphenMinusKeyword_1ElementType() {
			return new IGrammarAwareElementType("OpUnary_HyphenMinusKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpUnaryAccess().getHyphenMinusKeyword_1());
		}
		public static IGrammarAwareElementType createOpUnary_PlusSignKeyword_2ElementType() {
			return new IGrammarAwareElementType("OpUnary_PlusSignKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpUnaryAccess().getPlusSignKeyword_2());
		}
	}

	public static final IGrammarAwareElementType OpUnary_ELEMENT_TYPE = associate(OpUnaryFactory.createOpUnaryElementType());

	public static final IGrammarAwareElementType OpUnary_Alternatives_ELEMENT_TYPE = associate(OpUnaryFactory.createOpUnary_AlternativesElementType());

	public static final IGrammarAwareElementType OpUnary_ExclamationMarkKeyword_0_ELEMENT_TYPE = associate(OpUnaryFactory.createOpUnary_ExclamationMarkKeyword_0ElementType());

	public static final IGrammarAwareElementType OpUnary_HyphenMinusKeyword_1_ELEMENT_TYPE = associate(OpUnaryFactory.createOpUnary_HyphenMinusKeyword_1ElementType());

	public static final IGrammarAwareElementType OpUnary_PlusSignKeyword_2_ELEMENT_TYPE = associate(OpUnaryFactory.createOpUnary_PlusSignKeyword_2ElementType());

	private static class XCastedExpressionFactory {
		public static IGrammarAwareElementType createXCastedExpressionElementType() {
			return new IGrammarAwareElementType("XCastedExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCastedExpressionRule());
		}
		public static IGrammarAwareElementType createXCastedExpression_GroupElementType() {
			return new IGrammarAwareElementType("XCastedExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCastedExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXCastedExpression_XPostfixOperationParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XCastedExpression_XPostfixOperationParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCastedExpressionAccess().getXPostfixOperationParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXCastedExpression_Group_1ElementType() {
			return new IGrammarAwareElementType("XCastedExpression_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCastedExpressionAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXCastedExpression_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XCastedExpression_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCastedExpressionAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXCastedExpression_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("XCastedExpression_Group_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCastedExpressionAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createXCastedExpression_XCastedExpressionTargetAction_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XCastedExpression_XCastedExpressionTargetAction_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0());
		}
		public static IGrammarAwareElementType createXCastedExpression_AsKeyword_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XCastedExpression_AsKeyword_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
		}
		public static IGrammarAwareElementType createXCastedExpression_TypeAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("XCastedExpression_TypeAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCastedExpressionAccess().getTypeAssignment_1_1());
		}
		public static IGrammarAwareElementType createXCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("XCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XCastedExpression_ELEMENT_TYPE = associate(XCastedExpressionFactory.createXCastedExpressionElementType());

	public static final IGrammarAwareElementType XCastedExpression_Group_ELEMENT_TYPE = associate(XCastedExpressionFactory.createXCastedExpression_GroupElementType());

	public static final IGrammarAwareElementType XCastedExpression_XPostfixOperationParserRuleCall_0_ELEMENT_TYPE = associate(XCastedExpressionFactory.createXCastedExpression_XPostfixOperationParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XCastedExpression_Group_1_ELEMENT_TYPE = associate(XCastedExpressionFactory.createXCastedExpression_Group_1ElementType());

	public static final IGrammarAwareElementType XCastedExpression_Group_1_0_ELEMENT_TYPE = associate(XCastedExpressionFactory.createXCastedExpression_Group_1_0ElementType());

	public static final IGrammarAwareElementType XCastedExpression_Group_1_0_0_ELEMENT_TYPE = associate(XCastedExpressionFactory.createXCastedExpression_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType XCastedExpression_XCastedExpressionTargetAction_1_0_0_0_ELEMENT_TYPE = associate(XCastedExpressionFactory.createXCastedExpression_XCastedExpressionTargetAction_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XCastedExpression_AsKeyword_1_0_0_1_ELEMENT_TYPE = associate(XCastedExpressionFactory.createXCastedExpression_AsKeyword_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XCastedExpression_TypeAssignment_1_1_ELEMENT_TYPE = associate(XCastedExpressionFactory.createXCastedExpression_TypeAssignment_1_1ElementType());

	public static final IGrammarAwareElementType XCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0_ELEMENT_TYPE = associate(XCastedExpressionFactory.createXCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0ElementType());

	private static class XPostfixOperationFactory {
		public static IGrammarAwareElementType createXPostfixOperationElementType() {
			return new IGrammarAwareElementType("XPostfixOperation_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPostfixOperationRule());
		}
		public static IGrammarAwareElementType createXPostfixOperation_GroupElementType() {
			return new IGrammarAwareElementType("XPostfixOperation_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPostfixOperationAccess().getGroup());
		}
		public static IGrammarAwareElementType createXPostfixOperation_XMemberFeatureCallParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XPostfixOperation_XMemberFeatureCallParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPostfixOperationAccess().getXMemberFeatureCallParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXPostfixOperation_Group_1ElementType() {
			return new IGrammarAwareElementType("XPostfixOperation_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPostfixOperationAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXPostfixOperation_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XPostfixOperation_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPostfixOperationAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXPostfixOperation_XPostfixOperationOperandAction_1_0_0ElementType() {
			return new IGrammarAwareElementType("XPostfixOperation_XPostfixOperationOperandAction_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0());
		}
		public static IGrammarAwareElementType createXPostfixOperation_FeatureAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("XPostfixOperation_FeatureAssignment_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPostfixOperationAccess().getFeatureAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createXPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("XPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_1_0());
		}
		public static IGrammarAwareElementType createXPostfixOperation_FeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("XPostfixOperation_FeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1());
		}
	}

	public static final IGrammarAwareElementType XPostfixOperation_ELEMENT_TYPE = associate(XPostfixOperationFactory.createXPostfixOperationElementType());

	public static final IGrammarAwareElementType XPostfixOperation_Group_ELEMENT_TYPE = associate(XPostfixOperationFactory.createXPostfixOperation_GroupElementType());

	public static final IGrammarAwareElementType XPostfixOperation_XMemberFeatureCallParserRuleCall_0_ELEMENT_TYPE = associate(XPostfixOperationFactory.createXPostfixOperation_XMemberFeatureCallParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XPostfixOperation_Group_1_ELEMENT_TYPE = associate(XPostfixOperationFactory.createXPostfixOperation_Group_1ElementType());

	public static final IGrammarAwareElementType XPostfixOperation_Group_1_0_ELEMENT_TYPE = associate(XPostfixOperationFactory.createXPostfixOperation_Group_1_0ElementType());

	public static final IGrammarAwareElementType XPostfixOperation_XPostfixOperationOperandAction_1_0_0_ELEMENT_TYPE = associate(XPostfixOperationFactory.createXPostfixOperation_XPostfixOperationOperandAction_1_0_0ElementType());

	public static final IGrammarAwareElementType XPostfixOperation_FeatureAssignment_1_0_1_ELEMENT_TYPE = associate(XPostfixOperationFactory.createXPostfixOperation_FeatureAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType XPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0_ELEMENT_TYPE = associate(XPostfixOperationFactory.createXPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0ElementType());

	public static final IGrammarAwareElementType XPostfixOperation_FeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1_ELEMENT_TYPE = associate(XPostfixOperationFactory.createXPostfixOperation_FeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1ElementType());

	private static class OpPostfixFactory {
		public static IGrammarAwareElementType createOpPostfixElementType() {
			return new IGrammarAwareElementType("OpPostfix_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpPostfixRule());
		}
		public static IGrammarAwareElementType createOpPostfix_AlternativesElementType() {
			return new IGrammarAwareElementType("OpPostfix_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpPostfixAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createOpPostfix_PlusSignPlusSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("OpPostfix_PlusSignPlusSignKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
		}
		public static IGrammarAwareElementType createOpPostfix_HyphenMinusHyphenMinusKeyword_1ElementType() {
			return new IGrammarAwareElementType("OpPostfix_HyphenMinusHyphenMinusKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1());
		}
	}

	public static final IGrammarAwareElementType OpPostfix_ELEMENT_TYPE = associate(OpPostfixFactory.createOpPostfixElementType());

	public static final IGrammarAwareElementType OpPostfix_Alternatives_ELEMENT_TYPE = associate(OpPostfixFactory.createOpPostfix_AlternativesElementType());

	public static final IGrammarAwareElementType OpPostfix_PlusSignPlusSignKeyword_0_ELEMENT_TYPE = associate(OpPostfixFactory.createOpPostfix_PlusSignPlusSignKeyword_0ElementType());

	public static final IGrammarAwareElementType OpPostfix_HyphenMinusHyphenMinusKeyword_1_ELEMENT_TYPE = associate(OpPostfixFactory.createOpPostfix_HyphenMinusHyphenMinusKeyword_1ElementType());

	private static class XMemberFeatureCallFactory {
		public static IGrammarAwareElementType createXMemberFeatureCallElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallRule());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_GroupElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_XPrimaryExpressionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_XPrimaryExpressionParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Alternatives_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_0_0_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Alternatives_1_0_0_0_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Alternatives_1_0_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getAlternatives_1_0_0_0_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_ExplicitStaticAssignment_1_0_0_0_1_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_ExplicitStaticAssignment_1_0_0_0_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getExplicitStaticAssignment_1_0_0_0_1_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_FeatureAssignment_1_0_0_0_2ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_FeatureAssignment_1_0_0_0_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getFeatureAssignment_1_0_0_0_2());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_OpSingleAssignParserRuleCall_1_0_0_0_3ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_OpSingleAssignParserRuleCall_1_0_0_0_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_ValueAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_ValueAssignment_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getValueAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_1_0_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Alternatives_1_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Alternatives_1_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getAlternatives_1_1_0_0_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_NullSafeAssignment_1_1_0_0_1_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_NullSafeAssignment_1_1_0_0_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getNullSafeAssignment_1_1_0_0_1_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_ExplicitStaticAssignment_1_1_0_0_1_2ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_ExplicitStaticAssignment_1_1_0_0_1_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getExplicitStaticAssignment_1_1_0_0_1_2());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_1_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_1_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_LessThanSignKeyword_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_LessThanSignKeyword_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_TypeArgumentsAssignment_1_1_1_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_TypeArgumentsAssignment_1_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getTypeArgumentsAssignment_1_1_1_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_1_1_2ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_1_1_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_1_1_2());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_CommaKeyword_1_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_CommaKeyword_1_1_1_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_TypeArgumentsAssignment_1_1_1_2_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_TypeArgumentsAssignment_1_1_1_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getTypeArgumentsAssignment_1_1_1_2_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_GreaterThanSignKeyword_1_1_1_3ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_GreaterThanSignKeyword_1_1_1_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_FeatureAssignment_1_1_2ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_FeatureAssignment_1_1_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getFeatureAssignment_1_1_2());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_1_3ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_1_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_1_3());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_ExplicitOperationCallAssignment_1_1_3_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_ExplicitOperationCallAssignment_1_1_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getExplicitOperationCallAssignment_1_1_3_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Alternatives_1_1_3_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Alternatives_1_1_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getAlternatives_1_1_3_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_1_3_1_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_1_3_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_1_3_1_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_Group_1_1_3_1_1_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_Group_1_1_3_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getGroup_1_1_3_1_1_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_1_1ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_1_1_1());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_RightParenthesisKeyword_1_1_3_2ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_RightParenthesisKeyword_1_1_3_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_4ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_4());
		}
		public static IGrammarAwareElementType createXMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0ElementType() {
			return new IGrammarAwareElementType("XMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0());
		}
	}

	public static final IGrammarAwareElementType XMemberFeatureCall_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCallElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_GroupElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_XPrimaryExpressionParserRuleCall_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_XPrimaryExpressionParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Alternatives_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Alternatives_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_0_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_0_0_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Alternatives_1_0_0_0_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Alternatives_1_0_0_0_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_ExplicitStaticAssignment_1_0_0_0_1_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_ExplicitStaticAssignment_1_0_0_0_1_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_FeatureAssignment_1_0_0_0_2_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_FeatureAssignment_1_0_0_0_2ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_OpSingleAssignParserRuleCall_1_0_0_0_3_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_OpSingleAssignParserRuleCall_1_0_0_0_3ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_ValueAssignment_1_0_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_ValueAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_1_0_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_1_0_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Alternatives_1_1_0_0_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Alternatives_1_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_NullSafeAssignment_1_1_0_0_1_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_NullSafeAssignment_1_1_0_0_1_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_ExplicitStaticAssignment_1_1_0_0_1_2_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_ExplicitStaticAssignment_1_1_0_0_1_2ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_1_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_1_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_LessThanSignKeyword_1_1_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_LessThanSignKeyword_1_1_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_TypeArgumentsAssignment_1_1_1_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_TypeArgumentsAssignment_1_1_1_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_1_1_2_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_1_1_2ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_CommaKeyword_1_1_1_2_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_CommaKeyword_1_1_1_2_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_TypeArgumentsAssignment_1_1_1_2_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_TypeArgumentsAssignment_1_1_1_2_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_GreaterThanSignKeyword_1_1_1_3_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_GreaterThanSignKeyword_1_1_1_3ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_FeatureAssignment_1_1_2_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_FeatureAssignment_1_1_2ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_1_3_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_1_3ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_ExplicitOperationCallAssignment_1_1_3_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_ExplicitOperationCallAssignment_1_1_3_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Alternatives_1_1_3_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Alternatives_1_1_3_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_1_3_1_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_1_3_1_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_Group_1_1_3_1_1_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_Group_1_1_3_1_1_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_1_1_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_1_1ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_RightParenthesisKeyword_1_1_3_2_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_RightParenthesisKeyword_1_1_3_2ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_4_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_4ElementType());

	public static final IGrammarAwareElementType XMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0_ELEMENT_TYPE = associate(XMemberFeatureCallFactory.createXMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0ElementType());

	private static class XPrimaryExpressionFactory {
		public static IGrammarAwareElementType createXPrimaryExpressionElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionRule());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_AlternativesElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XConstructorCallParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XConstructorCallParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XBlockExpressionParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XBlockExpressionParserRuleCall_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XSwitchExpressionParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XSwitchExpressionParserRuleCall_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XSynchronizedExpressionParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XSynchronizedExpressionParserRuleCall_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXSynchronizedExpressionParserRuleCall_3());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XFeatureCallParserRuleCall_4ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XFeatureCallParserRuleCall_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XLiteralParserRuleCall_5ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XLiteralParserRuleCall_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_5());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XIfExpressionParserRuleCall_6ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XIfExpressionParserRuleCall_6_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_6());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XForLoopExpressionParserRuleCall_7ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XForLoopExpressionParserRuleCall_7_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_7());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXBasicForLoopExpressionParserRuleCall_8());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XWhileExpressionParserRuleCall_9ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XWhileExpressionParserRuleCall_9_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_9());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XDoWhileExpressionParserRuleCall_10ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XDoWhileExpressionParserRuleCall_10_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_10());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XThrowExpressionParserRuleCall_11ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XThrowExpressionParserRuleCall_11_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_11());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XReturnExpressionParserRuleCall_12ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XReturnExpressionParserRuleCall_12_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_12());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_13());
		}
		public static IGrammarAwareElementType createXPrimaryExpression_XParenthesizedExpressionParserRuleCall_14ElementType() {
			return new IGrammarAwareElementType("XPrimaryExpression_XParenthesizedExpressionParserRuleCall_14_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_14());
		}
	}

	public static final IGrammarAwareElementType XPrimaryExpression_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpressionElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_Alternatives_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_AlternativesElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XConstructorCallParserRuleCall_0_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XConstructorCallParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XBlockExpressionParserRuleCall_1_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XBlockExpressionParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XSwitchExpressionParserRuleCall_2_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XSwitchExpressionParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XSynchronizedExpressionParserRuleCall_3_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XSynchronizedExpressionParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XFeatureCallParserRuleCall_4_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XFeatureCallParserRuleCall_4ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XLiteralParserRuleCall_5_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XLiteralParserRuleCall_5ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XIfExpressionParserRuleCall_6_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XIfExpressionParserRuleCall_6ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XForLoopExpressionParserRuleCall_7_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XForLoopExpressionParserRuleCall_7ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XWhileExpressionParserRuleCall_9_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XWhileExpressionParserRuleCall_9ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XDoWhileExpressionParserRuleCall_10_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XDoWhileExpressionParserRuleCall_10ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XThrowExpressionParserRuleCall_11_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XThrowExpressionParserRuleCall_11ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XReturnExpressionParserRuleCall_12_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XReturnExpressionParserRuleCall_12ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13ElementType());

	public static final IGrammarAwareElementType XPrimaryExpression_XParenthesizedExpressionParserRuleCall_14_ELEMENT_TYPE = associate(XPrimaryExpressionFactory.createXPrimaryExpression_XParenthesizedExpressionParserRuleCall_14ElementType());

	private static class XLiteralFactory {
		public static IGrammarAwareElementType createXLiteralElementType() {
			return new IGrammarAwareElementType("XLiteral_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXLiteralRule());
		}
		public static IGrammarAwareElementType createXLiteral_AlternativesElementType() {
			return new IGrammarAwareElementType("XLiteral_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXLiteralAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createXLiteral_XCollectionLiteralParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XLiteral_XCollectionLiteralParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXLiteralAccess().getXCollectionLiteralParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXLiteral_XClosureParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("XLiteral_XClosureParserRuleCall_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXLiteralAccess().getXClosureParserRuleCall_1());
		}
		public static IGrammarAwareElementType createXLiteral_XBooleanLiteralParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("XLiteral_XBooleanLiteralParserRuleCall_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXLiteralAccess().getXBooleanLiteralParserRuleCall_2());
		}
		public static IGrammarAwareElementType createXLiteral_XNumberLiteralParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("XLiteral_XNumberLiteralParserRuleCall_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXLiteralAccess().getXNumberLiteralParserRuleCall_3());
		}
		public static IGrammarAwareElementType createXLiteral_XNullLiteralParserRuleCall_4ElementType() {
			return new IGrammarAwareElementType("XLiteral_XNullLiteralParserRuleCall_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXLiteralAccess().getXNullLiteralParserRuleCall_4());
		}
		public static IGrammarAwareElementType createXLiteral_XStringLiteralParserRuleCall_5ElementType() {
			return new IGrammarAwareElementType("XLiteral_XStringLiteralParserRuleCall_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXLiteralAccess().getXStringLiteralParserRuleCall_5());
		}
		public static IGrammarAwareElementType createXLiteral_XTypeLiteralParserRuleCall_6ElementType() {
			return new IGrammarAwareElementType("XLiteral_XTypeLiteralParserRuleCall_6_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXLiteralAccess().getXTypeLiteralParserRuleCall_6());
		}
	}

	public static final IGrammarAwareElementType XLiteral_ELEMENT_TYPE = associate(XLiteralFactory.createXLiteralElementType());

	public static final IGrammarAwareElementType XLiteral_Alternatives_ELEMENT_TYPE = associate(XLiteralFactory.createXLiteral_AlternativesElementType());

	public static final IGrammarAwareElementType XLiteral_XCollectionLiteralParserRuleCall_0_ELEMENT_TYPE = associate(XLiteralFactory.createXLiteral_XCollectionLiteralParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XLiteral_XClosureParserRuleCall_1_ELEMENT_TYPE = associate(XLiteralFactory.createXLiteral_XClosureParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType XLiteral_XBooleanLiteralParserRuleCall_2_ELEMENT_TYPE = associate(XLiteralFactory.createXLiteral_XBooleanLiteralParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType XLiteral_XNumberLiteralParserRuleCall_3_ELEMENT_TYPE = associate(XLiteralFactory.createXLiteral_XNumberLiteralParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType XLiteral_XNullLiteralParserRuleCall_4_ELEMENT_TYPE = associate(XLiteralFactory.createXLiteral_XNullLiteralParserRuleCall_4ElementType());

	public static final IGrammarAwareElementType XLiteral_XStringLiteralParserRuleCall_5_ELEMENT_TYPE = associate(XLiteralFactory.createXLiteral_XStringLiteralParserRuleCall_5ElementType());

	public static final IGrammarAwareElementType XLiteral_XTypeLiteralParserRuleCall_6_ELEMENT_TYPE = associate(XLiteralFactory.createXLiteral_XTypeLiteralParserRuleCall_6ElementType());

	private static class XCollectionLiteralFactory {
		public static IGrammarAwareElementType createXCollectionLiteralElementType() {
			return new IGrammarAwareElementType("XCollectionLiteral_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCollectionLiteralRule());
		}
		public static IGrammarAwareElementType createXCollectionLiteral_AlternativesElementType() {
			return new IGrammarAwareElementType("XCollectionLiteral_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCollectionLiteralAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createXCollectionLiteral_XSetLiteralParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XCollectionLiteral_XSetLiteralParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCollectionLiteralAccess().getXSetLiteralParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXCollectionLiteral_XListLiteralParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("XCollectionLiteral_XListLiteralParserRuleCall_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCollectionLiteralAccess().getXListLiteralParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType XCollectionLiteral_ELEMENT_TYPE = associate(XCollectionLiteralFactory.createXCollectionLiteralElementType());

	public static final IGrammarAwareElementType XCollectionLiteral_Alternatives_ELEMENT_TYPE = associate(XCollectionLiteralFactory.createXCollectionLiteral_AlternativesElementType());

	public static final IGrammarAwareElementType XCollectionLiteral_XSetLiteralParserRuleCall_0_ELEMENT_TYPE = associate(XCollectionLiteralFactory.createXCollectionLiteral_XSetLiteralParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XCollectionLiteral_XListLiteralParserRuleCall_1_ELEMENT_TYPE = associate(XCollectionLiteralFactory.createXCollectionLiteral_XListLiteralParserRuleCall_1ElementType());

	private static class XSetLiteralFactory {
		public static IGrammarAwareElementType createXSetLiteralElementType() {
			return new IGrammarAwareElementType("XSetLiteral_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralRule());
		}
		public static IGrammarAwareElementType createXSetLiteral_GroupElementType() {
			return new IGrammarAwareElementType("XSetLiteral_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getGroup());
		}
		public static IGrammarAwareElementType createXSetLiteral_XSetLiteralAction_0ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_XSetLiteralAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getXSetLiteralAction_0());
		}
		public static IGrammarAwareElementType createXSetLiteral_NumberSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_NumberSignKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getNumberSignKeyword_1());
		}
		public static IGrammarAwareElementType createXSetLiteral_LeftCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createXSetLiteral_Group_3ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_Group_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createXSetLiteral_ElementsAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_ElementsAssignment_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getElementsAssignment_3_0());
		}
		public static IGrammarAwareElementType createXSetLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_ElementsXExpressionParserRuleCall_3_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createXSetLiteral_Group_3_1ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_Group_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createXSetLiteral_CommaKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_CommaKeyword_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getCommaKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createXSetLiteral_ElementsAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_ElementsAssignment_3_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getElementsAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createXSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createXSetLiteral_RightCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("XSetLiteral_RightCurlyBracketKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSetLiteralAccess().getRightCurlyBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType XSetLiteral_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteralElementType());

	public static final IGrammarAwareElementType XSetLiteral_Group_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_GroupElementType());

	public static final IGrammarAwareElementType XSetLiteral_XSetLiteralAction_0_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_XSetLiteralAction_0ElementType());

	public static final IGrammarAwareElementType XSetLiteral_NumberSignKeyword_1_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_NumberSignKeyword_1ElementType());

	public static final IGrammarAwareElementType XSetLiteral_LeftCurlyBracketKeyword_2_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_LeftCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType XSetLiteral_Group_3_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_Group_3ElementType());

	public static final IGrammarAwareElementType XSetLiteral_ElementsAssignment_3_0_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_ElementsAssignment_3_0ElementType());

	public static final IGrammarAwareElementType XSetLiteral_ElementsXExpressionParserRuleCall_3_0_0_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType XSetLiteral_Group_3_1_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_Group_3_1ElementType());

	public static final IGrammarAwareElementType XSetLiteral_CommaKeyword_3_1_0_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_CommaKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType XSetLiteral_ElementsAssignment_3_1_1_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_ElementsAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType XSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType XSetLiteral_RightCurlyBracketKeyword_4_ELEMENT_TYPE = associate(XSetLiteralFactory.createXSetLiteral_RightCurlyBracketKeyword_4ElementType());

	private static class XListLiteralFactory {
		public static IGrammarAwareElementType createXListLiteralElementType() {
			return new IGrammarAwareElementType("XListLiteral_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralRule());
		}
		public static IGrammarAwareElementType createXListLiteral_GroupElementType() {
			return new IGrammarAwareElementType("XListLiteral_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getGroup());
		}
		public static IGrammarAwareElementType createXListLiteral_XListLiteralAction_0ElementType() {
			return new IGrammarAwareElementType("XListLiteral_XListLiteralAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getXListLiteralAction_0());
		}
		public static IGrammarAwareElementType createXListLiteral_NumberSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("XListLiteral_NumberSignKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getNumberSignKeyword_1());
		}
		public static IGrammarAwareElementType createXListLiteral_LeftSquareBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("XListLiteral_LeftSquareBracketKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getLeftSquareBracketKeyword_2());
		}
		public static IGrammarAwareElementType createXListLiteral_Group_3ElementType() {
			return new IGrammarAwareElementType("XListLiteral_Group_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createXListLiteral_ElementsAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("XListLiteral_ElementsAssignment_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getElementsAssignment_3_0());
		}
		public static IGrammarAwareElementType createXListLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("XListLiteral_ElementsXExpressionParserRuleCall_3_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createXListLiteral_Group_3_1ElementType() {
			return new IGrammarAwareElementType("XListLiteral_Group_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createXListLiteral_CommaKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("XListLiteral_CommaKeyword_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getCommaKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createXListLiteral_ElementsAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("XListLiteral_ElementsAssignment_3_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getElementsAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createXListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("XListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createXListLiteral_RightSquareBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("XListLiteral_RightSquareBracketKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXListLiteralAccess().getRightSquareBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType XListLiteral_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteralElementType());

	public static final IGrammarAwareElementType XListLiteral_Group_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_GroupElementType());

	public static final IGrammarAwareElementType XListLiteral_XListLiteralAction_0_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_XListLiteralAction_0ElementType());

	public static final IGrammarAwareElementType XListLiteral_NumberSignKeyword_1_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_NumberSignKeyword_1ElementType());

	public static final IGrammarAwareElementType XListLiteral_LeftSquareBracketKeyword_2_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_LeftSquareBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType XListLiteral_Group_3_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_Group_3ElementType());

	public static final IGrammarAwareElementType XListLiteral_ElementsAssignment_3_0_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_ElementsAssignment_3_0ElementType());

	public static final IGrammarAwareElementType XListLiteral_ElementsXExpressionParserRuleCall_3_0_0_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType XListLiteral_Group_3_1_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_Group_3_1ElementType());

	public static final IGrammarAwareElementType XListLiteral_CommaKeyword_3_1_0_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_CommaKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType XListLiteral_ElementsAssignment_3_1_1_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_ElementsAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType XListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType XListLiteral_RightSquareBracketKeyword_4_ELEMENT_TYPE = associate(XListLiteralFactory.createXListLiteral_RightSquareBracketKeyword_4ElementType());

	private static class XClosureFactory {
		public static IGrammarAwareElementType createXClosureElementType() {
			return new IGrammarAwareElementType("XClosure_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureRule());
		}
		public static IGrammarAwareElementType createXClosure_GroupElementType() {
			return new IGrammarAwareElementType("XClosure_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getGroup());
		}
		public static IGrammarAwareElementType createXClosure_Group_0ElementType() {
			return new IGrammarAwareElementType("XClosure_Group_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createXClosure_Group_0_0ElementType() {
			return new IGrammarAwareElementType("XClosure_Group_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getGroup_0_0());
		}
		public static IGrammarAwareElementType createXClosure_XClosureAction_0_0_0ElementType() {
			return new IGrammarAwareElementType("XClosure_XClosureAction_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getXClosureAction_0_0_0());
		}
		public static IGrammarAwareElementType createXClosure_LeftSquareBracketKeyword_0_0_1ElementType() {
			return new IGrammarAwareElementType("XClosure_LeftSquareBracketKeyword_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1());
		}
		public static IGrammarAwareElementType createXClosure_Group_1ElementType() {
			return new IGrammarAwareElementType("XClosure_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXClosure_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XClosure_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXClosure_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("XClosure_Group_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createXClosure_DeclaredFormalParametersAssignment_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XClosure_DeclaredFormalParametersAssignment_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getDeclaredFormalParametersAssignment_1_0_0_0());
		}
		public static IGrammarAwareElementType createXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0ElementType() {
			return new IGrammarAwareElementType("XClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0());
		}
		public static IGrammarAwareElementType createXClosure_Group_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XClosure_Group_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getGroup_1_0_0_1());
		}
		public static IGrammarAwareElementType createXClosure_CommaKeyword_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XClosure_CommaKeyword_1_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getCommaKeyword_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createXClosure_DeclaredFormalParametersAssignment_1_0_0_1_1ElementType() {
			return new IGrammarAwareElementType("XClosure_DeclaredFormalParametersAssignment_1_0_0_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getDeclaredFormalParametersAssignment_1_0_0_1_1());
		}
		public static IGrammarAwareElementType createXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0ElementType() {
			return new IGrammarAwareElementType("XClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0());
		}
		public static IGrammarAwareElementType createXClosure_ExplicitSyntaxAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("XClosure_ExplicitSyntaxAssignment_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getExplicitSyntaxAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createXClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("XClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0());
		}
		public static IGrammarAwareElementType createXClosure_ExpressionAssignment_2ElementType() {
			return new IGrammarAwareElementType("XClosure_ExpressionAssignment_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getExpressionAssignment_2());
		}
		public static IGrammarAwareElementType createXClosure_ExpressionXExpressionInClosureParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("XClosure_ExpressionXExpressionInClosureParserRuleCall_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createXClosure_RightSquareBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("XClosure_RightSquareBracketKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXClosureAccess().getRightSquareBracketKeyword_3());
		}
	}

	public static final IGrammarAwareElementType XClosure_ELEMENT_TYPE = associate(XClosureFactory.createXClosureElementType());

	public static final IGrammarAwareElementType XClosure_Group_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_GroupElementType());

	public static final IGrammarAwareElementType XClosure_Group_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_Group_0ElementType());

	public static final IGrammarAwareElementType XClosure_Group_0_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_Group_0_0ElementType());

	public static final IGrammarAwareElementType XClosure_XClosureAction_0_0_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_XClosureAction_0_0_0ElementType());

	public static final IGrammarAwareElementType XClosure_LeftSquareBracketKeyword_0_0_1_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_LeftSquareBracketKeyword_0_0_1ElementType());

	public static final IGrammarAwareElementType XClosure_Group_1_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_Group_1ElementType());

	public static final IGrammarAwareElementType XClosure_Group_1_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_Group_1_0ElementType());

	public static final IGrammarAwareElementType XClosure_Group_1_0_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType XClosure_DeclaredFormalParametersAssignment_1_0_0_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_DeclaredFormalParametersAssignment_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0ElementType());

	public static final IGrammarAwareElementType XClosure_Group_1_0_0_1_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_Group_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XClosure_CommaKeyword_1_0_0_1_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_CommaKeyword_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XClosure_DeclaredFormalParametersAssignment_1_0_0_1_1_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_DeclaredFormalParametersAssignment_1_0_0_1_1ElementType());

	public static final IGrammarAwareElementType XClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0ElementType());

	public static final IGrammarAwareElementType XClosure_ExplicitSyntaxAssignment_1_0_1_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_ExplicitSyntaxAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType XClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0ElementType());

	public static final IGrammarAwareElementType XClosure_ExpressionAssignment_2_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_ExpressionAssignment_2ElementType());

	public static final IGrammarAwareElementType XClosure_ExpressionXExpressionInClosureParserRuleCall_2_0_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_ExpressionXExpressionInClosureParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType XClosure_RightSquareBracketKeyword_3_ELEMENT_TYPE = associate(XClosureFactory.createXClosure_RightSquareBracketKeyword_3ElementType());

	private static class XExpressionInClosureFactory {
		public static IGrammarAwareElementType createXExpressionInClosureElementType() {
			return new IGrammarAwareElementType("XExpressionInClosure_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionInClosureRule());
		}
		public static IGrammarAwareElementType createXExpressionInClosure_GroupElementType() {
			return new IGrammarAwareElementType("XExpressionInClosure_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionInClosureAccess().getGroup());
		}
		public static IGrammarAwareElementType createXExpressionInClosure_XBlockExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("XExpressionInClosure_XBlockExpressionAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionInClosureAccess().getXBlockExpressionAction_0());
		}
		public static IGrammarAwareElementType createXExpressionInClosure_Group_1ElementType() {
			return new IGrammarAwareElementType("XExpressionInClosure_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionInClosureAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXExpressionInClosure_ExpressionsAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("XExpressionInClosure_ExpressionsAssignment_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionInClosureAccess().getExpressionsAssignment_1_0());
		}
		public static IGrammarAwareElementType createXExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("XExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createXExpressionInClosure_SemicolonKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("XExpressionInClosure_SemicolonKeyword_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
		}
	}

	public static final IGrammarAwareElementType XExpressionInClosure_ELEMENT_TYPE = associate(XExpressionInClosureFactory.createXExpressionInClosureElementType());

	public static final IGrammarAwareElementType XExpressionInClosure_Group_ELEMENT_TYPE = associate(XExpressionInClosureFactory.createXExpressionInClosure_GroupElementType());

	public static final IGrammarAwareElementType XExpressionInClosure_XBlockExpressionAction_0_ELEMENT_TYPE = associate(XExpressionInClosureFactory.createXExpressionInClosure_XBlockExpressionAction_0ElementType());

	public static final IGrammarAwareElementType XExpressionInClosure_Group_1_ELEMENT_TYPE = associate(XExpressionInClosureFactory.createXExpressionInClosure_Group_1ElementType());

	public static final IGrammarAwareElementType XExpressionInClosure_ExpressionsAssignment_1_0_ELEMENT_TYPE = associate(XExpressionInClosureFactory.createXExpressionInClosure_ExpressionsAssignment_1_0ElementType());

	public static final IGrammarAwareElementType XExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0_ELEMENT_TYPE = associate(XExpressionInClosureFactory.createXExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType XExpressionInClosure_SemicolonKeyword_1_1_ELEMENT_TYPE = associate(XExpressionInClosureFactory.createXExpressionInClosure_SemicolonKeyword_1_1ElementType());

	private static class XShortClosureFactory {
		public static IGrammarAwareElementType createXShortClosureElementType() {
			return new IGrammarAwareElementType("XShortClosure_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureRule());
		}
		public static IGrammarAwareElementType createXShortClosure_GroupElementType() {
			return new IGrammarAwareElementType("XShortClosure_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getGroup());
		}
		public static IGrammarAwareElementType createXShortClosure_Group_0ElementType() {
			return new IGrammarAwareElementType("XShortClosure_Group_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createXShortClosure_Group_0_0ElementType() {
			return new IGrammarAwareElementType("XShortClosure_Group_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getGroup_0_0());
		}
		public static IGrammarAwareElementType createXShortClosure_XClosureAction_0_0_0ElementType() {
			return new IGrammarAwareElementType("XShortClosure_XClosureAction_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getXClosureAction_0_0_0());
		}
		public static IGrammarAwareElementType createXShortClosure_Group_0_0_1ElementType() {
			return new IGrammarAwareElementType("XShortClosure_Group_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getGroup_0_0_1());
		}
		public static IGrammarAwareElementType createXShortClosure_DeclaredFormalParametersAssignment_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XShortClosure_DeclaredFormalParametersAssignment_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getDeclaredFormalParametersAssignment_0_0_1_0());
		}
		public static IGrammarAwareElementType createXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0ElementType() {
			return new IGrammarAwareElementType("XShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0());
		}
		public static IGrammarAwareElementType createXShortClosure_Group_0_0_1_1ElementType() {
			return new IGrammarAwareElementType("XShortClosure_Group_0_0_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getGroup_0_0_1_1());
		}
		public static IGrammarAwareElementType createXShortClosure_CommaKeyword_0_0_1_1_0ElementType() {
			return new IGrammarAwareElementType("XShortClosure_CommaKeyword_0_0_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
		}
		public static IGrammarAwareElementType createXShortClosure_DeclaredFormalParametersAssignment_0_0_1_1_1ElementType() {
			return new IGrammarAwareElementType("XShortClosure_DeclaredFormalParametersAssignment_0_0_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getDeclaredFormalParametersAssignment_0_0_1_1_1());
		}
		public static IGrammarAwareElementType createXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0());
		}
		public static IGrammarAwareElementType createXShortClosure_ExplicitSyntaxAssignment_0_0_2ElementType() {
			return new IGrammarAwareElementType("XShortClosure_ExplicitSyntaxAssignment_0_0_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getExplicitSyntaxAssignment_0_0_2());
		}
		public static IGrammarAwareElementType createXShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0ElementType() {
			return new IGrammarAwareElementType("XShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0());
		}
		public static IGrammarAwareElementType createXShortClosure_ExpressionAssignment_1ElementType() {
			return new IGrammarAwareElementType("XShortClosure_ExpressionAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getExpressionAssignment_1());
		}
		public static IGrammarAwareElementType createXShortClosure_ExpressionXExpressionParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("XShortClosure_ExpressionXExpressionParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType XShortClosure_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosureElementType());

	public static final IGrammarAwareElementType XShortClosure_Group_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_GroupElementType());

	public static final IGrammarAwareElementType XShortClosure_Group_0_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_Group_0ElementType());

	public static final IGrammarAwareElementType XShortClosure_Group_0_0_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_Group_0_0ElementType());

	public static final IGrammarAwareElementType XShortClosure_XClosureAction_0_0_0_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_XClosureAction_0_0_0ElementType());

	public static final IGrammarAwareElementType XShortClosure_Group_0_0_1_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_Group_0_0_1ElementType());

	public static final IGrammarAwareElementType XShortClosure_DeclaredFormalParametersAssignment_0_0_1_0_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_DeclaredFormalParametersAssignment_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0ElementType());

	public static final IGrammarAwareElementType XShortClosure_Group_0_0_1_1_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_Group_0_0_1_1ElementType());

	public static final IGrammarAwareElementType XShortClosure_CommaKeyword_0_0_1_1_0_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_CommaKeyword_0_0_1_1_0ElementType());

	public static final IGrammarAwareElementType XShortClosure_DeclaredFormalParametersAssignment_0_0_1_1_1_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_DeclaredFormalParametersAssignment_0_0_1_1_1ElementType());

	public static final IGrammarAwareElementType XShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0ElementType());

	public static final IGrammarAwareElementType XShortClosure_ExplicitSyntaxAssignment_0_0_2_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_ExplicitSyntaxAssignment_0_0_2ElementType());

	public static final IGrammarAwareElementType XShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0ElementType());

	public static final IGrammarAwareElementType XShortClosure_ExpressionAssignment_1_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_ExpressionAssignment_1ElementType());

	public static final IGrammarAwareElementType XShortClosure_ExpressionXExpressionParserRuleCall_1_0_ELEMENT_TYPE = associate(XShortClosureFactory.createXShortClosure_ExpressionXExpressionParserRuleCall_1_0ElementType());

	private static class XParenthesizedExpressionFactory {
		public static IGrammarAwareElementType createXParenthesizedExpressionElementType() {
			return new IGrammarAwareElementType("XParenthesizedExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXParenthesizedExpressionRule());
		}
		public static IGrammarAwareElementType createXParenthesizedExpression_GroupElementType() {
			return new IGrammarAwareElementType("XParenthesizedExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXParenthesizedExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXParenthesizedExpression_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("XParenthesizedExpression_LeftParenthesisKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createXParenthesizedExpression_XExpressionParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("XParenthesizedExpression_XExpressionParserRuleCall_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1());
		}
		public static IGrammarAwareElementType createXParenthesizedExpression_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("XParenthesizedExpression_RightParenthesisKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
		}
	}

	public static final IGrammarAwareElementType XParenthesizedExpression_ELEMENT_TYPE = associate(XParenthesizedExpressionFactory.createXParenthesizedExpressionElementType());

	public static final IGrammarAwareElementType XParenthesizedExpression_Group_ELEMENT_TYPE = associate(XParenthesizedExpressionFactory.createXParenthesizedExpression_GroupElementType());

	public static final IGrammarAwareElementType XParenthesizedExpression_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(XParenthesizedExpressionFactory.createXParenthesizedExpression_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType XParenthesizedExpression_XExpressionParserRuleCall_1_ELEMENT_TYPE = associate(XParenthesizedExpressionFactory.createXParenthesizedExpression_XExpressionParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType XParenthesizedExpression_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(XParenthesizedExpressionFactory.createXParenthesizedExpression_RightParenthesisKeyword_2ElementType());

	private static class XIfExpressionFactory {
		public static IGrammarAwareElementType createXIfExpressionElementType() {
			return new IGrammarAwareElementType("XIfExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionRule());
		}
		public static IGrammarAwareElementType createXIfExpression_GroupElementType() {
			return new IGrammarAwareElementType("XIfExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXIfExpression_XIfExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("XIfExpression_XIfExpressionAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getXIfExpressionAction_0());
		}
		public static IGrammarAwareElementType createXIfExpression_IfKeyword_1ElementType() {
			return new IGrammarAwareElementType("XIfExpression_IfKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getIfKeyword_1());
		}
		public static IGrammarAwareElementType createXIfExpression_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("XIfExpression_LeftParenthesisKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createXIfExpression_IfAssignment_3ElementType() {
			return new IGrammarAwareElementType("XIfExpression_IfAssignment_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getIfAssignment_3());
		}
		public static IGrammarAwareElementType createXIfExpression_IfXExpressionParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("XIfExpression_IfXExpressionParserRuleCall_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createXIfExpression_RightParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("XIfExpression_RightParenthesisKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getRightParenthesisKeyword_4());
		}
		public static IGrammarAwareElementType createXIfExpression_ThenAssignment_5ElementType() {
			return new IGrammarAwareElementType("XIfExpression_ThenAssignment_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getThenAssignment_5());
		}
		public static IGrammarAwareElementType createXIfExpression_ThenXExpressionParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("XIfExpression_ThenXExpressionParserRuleCall_5_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0());
		}
		public static IGrammarAwareElementType createXIfExpression_Group_6ElementType() {
			return new IGrammarAwareElementType("XIfExpression_Group_6_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getGroup_6());
		}
		public static IGrammarAwareElementType createXIfExpression_ElseKeyword_6_0ElementType() {
			return new IGrammarAwareElementType("XIfExpression_ElseKeyword_6_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getElseKeyword_6_0());
		}
		public static IGrammarAwareElementType createXIfExpression_ElseAssignment_6_1ElementType() {
			return new IGrammarAwareElementType("XIfExpression_ElseAssignment_6_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getElseAssignment_6_1());
		}
		public static IGrammarAwareElementType createXIfExpression_ElseXExpressionParserRuleCall_6_1_0ElementType() {
			return new IGrammarAwareElementType("XIfExpression_ElseXExpressionParserRuleCall_6_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0());
		}
	}

	public static final IGrammarAwareElementType XIfExpression_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpressionElementType());

	public static final IGrammarAwareElementType XIfExpression_Group_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_GroupElementType());

	public static final IGrammarAwareElementType XIfExpression_XIfExpressionAction_0_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_XIfExpressionAction_0ElementType());

	public static final IGrammarAwareElementType XIfExpression_IfKeyword_1_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_IfKeyword_1ElementType());

	public static final IGrammarAwareElementType XIfExpression_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType XIfExpression_IfAssignment_3_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_IfAssignment_3ElementType());

	public static final IGrammarAwareElementType XIfExpression_IfXExpressionParserRuleCall_3_0_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_IfXExpressionParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType XIfExpression_RightParenthesisKeyword_4_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_RightParenthesisKeyword_4ElementType());

	public static final IGrammarAwareElementType XIfExpression_ThenAssignment_5_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_ThenAssignment_5ElementType());

	public static final IGrammarAwareElementType XIfExpression_ThenXExpressionParserRuleCall_5_0_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_ThenXExpressionParserRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType XIfExpression_Group_6_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_Group_6ElementType());

	public static final IGrammarAwareElementType XIfExpression_ElseKeyword_6_0_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_ElseKeyword_6_0ElementType());

	public static final IGrammarAwareElementType XIfExpression_ElseAssignment_6_1_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_ElseAssignment_6_1ElementType());

	public static final IGrammarAwareElementType XIfExpression_ElseXExpressionParserRuleCall_6_1_0_ELEMENT_TYPE = associate(XIfExpressionFactory.createXIfExpression_ElseXExpressionParserRuleCall_6_1_0ElementType());

	private static class XSwitchExpressionFactory {
		public static IGrammarAwareElementType createXSwitchExpressionElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionRule());
		}
		public static IGrammarAwareElementType createXSwitchExpression_GroupElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXSwitchExpression_XSwitchExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_XSwitchExpressionAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getXSwitchExpressionAction_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_SwitchKeyword_1ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_SwitchKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getSwitchKeyword_1());
		}
		public static IGrammarAwareElementType createXSwitchExpression_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_Alternatives_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createXSwitchExpression_Group_2_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_Group_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getGroup_2_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_Group_2_0_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_Group_2_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getGroup_2_0_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_Group_2_0_0_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_Group_2_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getGroup_2_0_0_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_0_0_0_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_DeclaredParamAssignment_2_0_0_0_1ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_DeclaredParamAssignment_2_0_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getDeclaredParamAssignment_2_0_0_0_1());
		}
		public static IGrammarAwareElementType createXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_ColonKeyword_2_0_0_0_2ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_ColonKeyword_2_0_0_0_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_2());
		}
		public static IGrammarAwareElementType createXSwitchExpression_SwitchAssignment_2_0_1ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_SwitchAssignment_2_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getSwitchAssignment_2_0_1());
		}
		public static IGrammarAwareElementType createXSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_RightParenthesisKeyword_2_0_2ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_RightParenthesisKeyword_2_0_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_0_2());
		}
		public static IGrammarAwareElementType createXSwitchExpression_Group_2_1ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_Group_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getGroup_2_1());
		}
		public static IGrammarAwareElementType createXSwitchExpression_Group_2_1_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_Group_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getGroup_2_1_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_Group_2_1_0_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_Group_2_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getGroup_2_1_0_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_DeclaredParamAssignment_2_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_DeclaredParamAssignment_2_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getDeclaredParamAssignment_2_1_0_0_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_ColonKeyword_2_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_ColonKeyword_2_1_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_1());
		}
		public static IGrammarAwareElementType createXSwitchExpression_SwitchAssignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_SwitchAssignment_2_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getSwitchAssignment_2_1_1());
		}
		public static IGrammarAwareElementType createXSwitchExpression_SwitchXExpressionParserRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_SwitchXExpressionParserRuleCall_2_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_1_1_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_LeftCurlyBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_LeftCurlyBracketKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
		}
		public static IGrammarAwareElementType createXSwitchExpression_CasesAssignment_4ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_CasesAssignment_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getCasesAssignment_4());
		}
		public static IGrammarAwareElementType createXSwitchExpression_CasesXCasePartParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_CasesXCasePartParserRuleCall_4_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_Group_5ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_Group_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createXSwitchExpression_DefaultKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_DefaultKeyword_5_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_ColonKeyword_5_1ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_ColonKeyword_5_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getColonKeyword_5_1());
		}
		public static IGrammarAwareElementType createXSwitchExpression_DefaultAssignment_5_2ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_DefaultAssignment_5_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getDefaultAssignment_5_2());
		}
		public static IGrammarAwareElementType createXSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0());
		}
		public static IGrammarAwareElementType createXSwitchExpression_RightCurlyBracketKeyword_6ElementType() {
			return new IGrammarAwareElementType("XSwitchExpression_RightCurlyBracketKeyword_6_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6());
		}
	}

	public static final IGrammarAwareElementType XSwitchExpression_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpressionElementType());

	public static final IGrammarAwareElementType XSwitchExpression_Group_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_GroupElementType());

	public static final IGrammarAwareElementType XSwitchExpression_XSwitchExpressionAction_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_XSwitchExpressionAction_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_SwitchKeyword_1_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_SwitchKeyword_1ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_Alternatives_2_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_Alternatives_2ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_Group_2_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_Group_2_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_Group_2_0_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_Group_2_0_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_Group_2_0_0_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_Group_2_0_0_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_DeclaredParamAssignment_2_0_0_0_1_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_DeclaredParamAssignment_2_0_0_0_1ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_ColonKeyword_2_0_0_0_2_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_ColonKeyword_2_0_0_0_2ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_SwitchAssignment_2_0_1_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_SwitchAssignment_2_0_1ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_RightParenthesisKeyword_2_0_2_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_RightParenthesisKeyword_2_0_2ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_Group_2_1_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_Group_2_1ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_Group_2_1_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_Group_2_1_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_Group_2_1_0_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_Group_2_1_0_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_DeclaredParamAssignment_2_1_0_0_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_DeclaredParamAssignment_2_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_ColonKeyword_2_1_0_0_1_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_ColonKeyword_2_1_0_0_1ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_SwitchAssignment_2_1_1_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_SwitchAssignment_2_1_1ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_SwitchXExpressionParserRuleCall_2_1_1_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_SwitchXExpressionParserRuleCall_2_1_1_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_LeftCurlyBracketKeyword_3_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_LeftCurlyBracketKeyword_3ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_CasesAssignment_4_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_CasesAssignment_4ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_CasesXCasePartParserRuleCall_4_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_CasesXCasePartParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_Group_5_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_Group_5ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_DefaultKeyword_5_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_DefaultKeyword_5_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_ColonKeyword_5_1_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_ColonKeyword_5_1ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_DefaultAssignment_5_2_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_DefaultAssignment_5_2ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0ElementType());

	public static final IGrammarAwareElementType XSwitchExpression_RightCurlyBracketKeyword_6_ELEMENT_TYPE = associate(XSwitchExpressionFactory.createXSwitchExpression_RightCurlyBracketKeyword_6ElementType());

	private static class XCasePartFactory {
		public static IGrammarAwareElementType createXCasePartElementType() {
			return new IGrammarAwareElementType("XCasePart_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartRule());
		}
		public static IGrammarAwareElementType createXCasePart_GroupElementType() {
			return new IGrammarAwareElementType("XCasePart_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getGroup());
		}
		public static IGrammarAwareElementType createXCasePart_XCasePartAction_0ElementType() {
			return new IGrammarAwareElementType("XCasePart_XCasePartAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getXCasePartAction_0());
		}
		public static IGrammarAwareElementType createXCasePart_TypeGuardAssignment_1ElementType() {
			return new IGrammarAwareElementType("XCasePart_TypeGuardAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getTypeGuardAssignment_1());
		}
		public static IGrammarAwareElementType createXCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("XCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createXCasePart_Group_2ElementType() {
			return new IGrammarAwareElementType("XCasePart_Group_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createXCasePart_CaseKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("XCasePart_CaseKeyword_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getCaseKeyword_2_0());
		}
		public static IGrammarAwareElementType createXCasePart_CaseAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("XCasePart_CaseAssignment_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getCaseAssignment_2_1());
		}
		public static IGrammarAwareElementType createXCasePart_CaseXExpressionParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("XCasePart_CaseXExpressionParserRuleCall_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createXCasePart_Alternatives_3ElementType() {
			return new IGrammarAwareElementType("XCasePart_Alternatives_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getAlternatives_3());
		}
		public static IGrammarAwareElementType createXCasePart_Group_3_0ElementType() {
			return new IGrammarAwareElementType("XCasePart_Group_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getGroup_3_0());
		}
		public static IGrammarAwareElementType createXCasePart_ColonKeyword_3_0_0ElementType() {
			return new IGrammarAwareElementType("XCasePart_ColonKeyword_3_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getColonKeyword_3_0_0());
		}
		public static IGrammarAwareElementType createXCasePart_ThenAssignment_3_0_1ElementType() {
			return new IGrammarAwareElementType("XCasePart_ThenAssignment_3_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getThenAssignment_3_0_1());
		}
		public static IGrammarAwareElementType createXCasePart_ThenXExpressionParserRuleCall_3_0_1_0ElementType() {
			return new IGrammarAwareElementType("XCasePart_ThenXExpressionParserRuleCall_3_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_1_0());
		}
		public static IGrammarAwareElementType createXCasePart_FallThroughAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("XCasePart_FallThroughAssignment_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getFallThroughAssignment_3_1());
		}
		public static IGrammarAwareElementType createXCasePart_FallThroughCommaKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("XCasePart_FallThroughCommaKeyword_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCasePartAccess().getFallThroughCommaKeyword_3_1_0());
		}
	}

	public static final IGrammarAwareElementType XCasePart_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePartElementType());

	public static final IGrammarAwareElementType XCasePart_Group_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_GroupElementType());

	public static final IGrammarAwareElementType XCasePart_XCasePartAction_0_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_XCasePartAction_0ElementType());

	public static final IGrammarAwareElementType XCasePart_TypeGuardAssignment_1_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_TypeGuardAssignment_1ElementType());

	public static final IGrammarAwareElementType XCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType XCasePart_Group_2_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_Group_2ElementType());

	public static final IGrammarAwareElementType XCasePart_CaseKeyword_2_0_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_CaseKeyword_2_0ElementType());

	public static final IGrammarAwareElementType XCasePart_CaseAssignment_2_1_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_CaseAssignment_2_1ElementType());

	public static final IGrammarAwareElementType XCasePart_CaseXExpressionParserRuleCall_2_1_0_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_CaseXExpressionParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType XCasePart_Alternatives_3_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_Alternatives_3ElementType());

	public static final IGrammarAwareElementType XCasePart_Group_3_0_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_Group_3_0ElementType());

	public static final IGrammarAwareElementType XCasePart_ColonKeyword_3_0_0_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_ColonKeyword_3_0_0ElementType());

	public static final IGrammarAwareElementType XCasePart_ThenAssignment_3_0_1_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_ThenAssignment_3_0_1ElementType());

	public static final IGrammarAwareElementType XCasePart_ThenXExpressionParserRuleCall_3_0_1_0_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_ThenXExpressionParserRuleCall_3_0_1_0ElementType());

	public static final IGrammarAwareElementType XCasePart_FallThroughAssignment_3_1_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_FallThroughAssignment_3_1ElementType());

	public static final IGrammarAwareElementType XCasePart_FallThroughCommaKeyword_3_1_0_ELEMENT_TYPE = associate(XCasePartFactory.createXCasePart_FallThroughCommaKeyword_3_1_0ElementType());

	private static class XForLoopExpressionFactory {
		public static IGrammarAwareElementType createXForLoopExpressionElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionRule());
		}
		public static IGrammarAwareElementType createXForLoopExpression_GroupElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXForLoopExpression_Group_0ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_Group_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createXForLoopExpression_Group_0_0ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_Group_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getGroup_0_0());
		}
		public static IGrammarAwareElementType createXForLoopExpression_XForLoopExpressionAction_0_0_0ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_XForLoopExpressionAction_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0());
		}
		public static IGrammarAwareElementType createXForLoopExpression_ForKeyword_0_0_1ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_ForKeyword_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getForKeyword_0_0_1());
		}
		public static IGrammarAwareElementType createXForLoopExpression_LeftParenthesisKeyword_0_0_2ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_LeftParenthesisKeyword_0_0_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
		}
		public static IGrammarAwareElementType createXForLoopExpression_DeclaredParamAssignment_0_0_3ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_DeclaredParamAssignment_0_0_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getDeclaredParamAssignment_0_0_3());
		}
		public static IGrammarAwareElementType createXForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0());
		}
		public static IGrammarAwareElementType createXForLoopExpression_ColonKeyword_0_0_4ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_ColonKeyword_0_0_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getColonKeyword_0_0_4());
		}
		public static IGrammarAwareElementType createXForLoopExpression_ForExpressionAssignment_1ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_ForExpressionAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getForExpressionAssignment_1());
		}
		public static IGrammarAwareElementType createXForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createXForLoopExpression_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_RightParenthesisKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getRightParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createXForLoopExpression_EachExpressionAssignment_3ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_EachExpressionAssignment_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getEachExpressionAssignment_3());
		}
		public static IGrammarAwareElementType createXForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("XForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType XForLoopExpression_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpressionElementType());

	public static final IGrammarAwareElementType XForLoopExpression_Group_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_GroupElementType());

	public static final IGrammarAwareElementType XForLoopExpression_Group_0_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_Group_0ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_Group_0_0_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_Group_0_0ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_XForLoopExpressionAction_0_0_0_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_XForLoopExpressionAction_0_0_0ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_ForKeyword_0_0_1_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_ForKeyword_0_0_1ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_LeftParenthesisKeyword_0_0_2_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_LeftParenthesisKeyword_0_0_2ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_DeclaredParamAssignment_0_0_3_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_DeclaredParamAssignment_0_0_3ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_ColonKeyword_0_0_4_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_ColonKeyword_0_0_4ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_ForExpressionAssignment_1_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_ForExpressionAssignment_1ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_RightParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_EachExpressionAssignment_3_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_EachExpressionAssignment_3ElementType());

	public static final IGrammarAwareElementType XForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0_ELEMENT_TYPE = associate(XForLoopExpressionFactory.createXForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0ElementType());

	private static class XBasicForLoopExpressionFactory {
		public static IGrammarAwareElementType createXBasicForLoopExpressionElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionRule());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_GroupElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_XBasicForLoopExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_XBasicForLoopExpressionAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_ForKeyword_1ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_ForKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getForKeyword_1());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_LeftParenthesisKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_Group_3ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_Group_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_InitExpressionsAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_InitExpressionsAssignment_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_0());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_Group_3_1ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_Group_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_CommaKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_CommaKeyword_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_InitExpressionsAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_InitExpressionsAssignment_3_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_SemicolonKeyword_4ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_SemicolonKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_ExpressionAssignment_5ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_ExpressionAssignment_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getExpressionAssignment_5());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_SemicolonKeyword_6ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_SemicolonKeyword_6_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getSemicolonKeyword_6());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_Group_7ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_Group_7_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getGroup_7());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_UpdateExpressionsAssignment_7_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_UpdateExpressionsAssignment_7_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_0());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_0_0());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_Group_7_1ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_Group_7_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getGroup_7_1());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_CommaKeyword_7_1_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_CommaKeyword_7_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_UpdateExpressionsAssignment_7_1_1ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_UpdateExpressionsAssignment_7_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_1_1());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_RightParenthesisKeyword_8ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_RightParenthesisKeyword_8_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_EachExpressionAssignment_9ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_EachExpressionAssignment_9_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getEachExpressionAssignment_9());
		}
		public static IGrammarAwareElementType createXBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0ElementType() {
			return new IGrammarAwareElementType("XBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBasicForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_9_0());
		}
	}

	public static final IGrammarAwareElementType XBasicForLoopExpression_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpressionElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_Group_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_GroupElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_XBasicForLoopExpressionAction_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_XBasicForLoopExpressionAction_0ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_ForKeyword_1_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_ForKeyword_1ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_Group_3_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_Group_3ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_InitExpressionsAssignment_3_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_InitExpressionsAssignment_3_0ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_Group_3_1_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_Group_3_1ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_CommaKeyword_3_1_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_CommaKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_InitExpressionsAssignment_3_1_1_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_InitExpressionsAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_SemicolonKeyword_4_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_SemicolonKeyword_4ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_ExpressionAssignment_5_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_ExpressionAssignment_5ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_SemicolonKeyword_6_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_SemicolonKeyword_6ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_Group_7_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_Group_7ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_UpdateExpressionsAssignment_7_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_UpdateExpressionsAssignment_7_0ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_Group_7_1_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_Group_7_1ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_CommaKeyword_7_1_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_CommaKeyword_7_1_0ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_UpdateExpressionsAssignment_7_1_1_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_UpdateExpressionsAssignment_7_1_1ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_RightParenthesisKeyword_8_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_RightParenthesisKeyword_8ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_EachExpressionAssignment_9_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_EachExpressionAssignment_9ElementType());

	public static final IGrammarAwareElementType XBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0_ELEMENT_TYPE = associate(XBasicForLoopExpressionFactory.createXBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0ElementType());

	private static class XWhileExpressionFactory {
		public static IGrammarAwareElementType createXWhileExpressionElementType() {
			return new IGrammarAwareElementType("XWhileExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXWhileExpressionRule());
		}
		public static IGrammarAwareElementType createXWhileExpression_GroupElementType() {
			return new IGrammarAwareElementType("XWhileExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXWhileExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXWhileExpression_XWhileExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("XWhileExpression_XWhileExpressionAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXWhileExpressionAccess().getXWhileExpressionAction_0());
		}
		public static IGrammarAwareElementType createXWhileExpression_WhileKeyword_1ElementType() {
			return new IGrammarAwareElementType("XWhileExpression_WhileKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXWhileExpressionAccess().getWhileKeyword_1());
		}
		public static IGrammarAwareElementType createXWhileExpression_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("XWhileExpression_LeftParenthesisKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createXWhileExpression_PredicateAssignment_3ElementType() {
			return new IGrammarAwareElementType("XWhileExpression_PredicateAssignment_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXWhileExpressionAccess().getPredicateAssignment_3());
		}
		public static IGrammarAwareElementType createXWhileExpression_PredicateXExpressionParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("XWhileExpression_PredicateXExpressionParserRuleCall_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createXWhileExpression_RightParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("XWhileExpression_RightParenthesisKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
		}
		public static IGrammarAwareElementType createXWhileExpression_BodyAssignment_5ElementType() {
			return new IGrammarAwareElementType("XWhileExpression_BodyAssignment_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXWhileExpressionAccess().getBodyAssignment_5());
		}
		public static IGrammarAwareElementType createXWhileExpression_BodyXExpressionParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("XWhileExpression_BodyXExpressionParserRuleCall_5_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0());
		}
	}

	public static final IGrammarAwareElementType XWhileExpression_ELEMENT_TYPE = associate(XWhileExpressionFactory.createXWhileExpressionElementType());

	public static final IGrammarAwareElementType XWhileExpression_Group_ELEMENT_TYPE = associate(XWhileExpressionFactory.createXWhileExpression_GroupElementType());

	public static final IGrammarAwareElementType XWhileExpression_XWhileExpressionAction_0_ELEMENT_TYPE = associate(XWhileExpressionFactory.createXWhileExpression_XWhileExpressionAction_0ElementType());

	public static final IGrammarAwareElementType XWhileExpression_WhileKeyword_1_ELEMENT_TYPE = associate(XWhileExpressionFactory.createXWhileExpression_WhileKeyword_1ElementType());

	public static final IGrammarAwareElementType XWhileExpression_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(XWhileExpressionFactory.createXWhileExpression_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType XWhileExpression_PredicateAssignment_3_ELEMENT_TYPE = associate(XWhileExpressionFactory.createXWhileExpression_PredicateAssignment_3ElementType());

	public static final IGrammarAwareElementType XWhileExpression_PredicateXExpressionParserRuleCall_3_0_ELEMENT_TYPE = associate(XWhileExpressionFactory.createXWhileExpression_PredicateXExpressionParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType XWhileExpression_RightParenthesisKeyword_4_ELEMENT_TYPE = associate(XWhileExpressionFactory.createXWhileExpression_RightParenthesisKeyword_4ElementType());

	public static final IGrammarAwareElementType XWhileExpression_BodyAssignment_5_ELEMENT_TYPE = associate(XWhileExpressionFactory.createXWhileExpression_BodyAssignment_5ElementType());

	public static final IGrammarAwareElementType XWhileExpression_BodyXExpressionParserRuleCall_5_0_ELEMENT_TYPE = associate(XWhileExpressionFactory.createXWhileExpression_BodyXExpressionParserRuleCall_5_0ElementType());

	private static class XDoWhileExpressionFactory {
		public static IGrammarAwareElementType createXDoWhileExpressionElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionRule());
		}
		public static IGrammarAwareElementType createXDoWhileExpression_GroupElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXDoWhileExpression_XDoWhileExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_XDoWhileExpressionAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0());
		}
		public static IGrammarAwareElementType createXDoWhileExpression_DoKeyword_1ElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_DoKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionAccess().getDoKeyword_1());
		}
		public static IGrammarAwareElementType createXDoWhileExpression_BodyAssignment_2ElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_BodyAssignment_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionAccess().getBodyAssignment_2());
		}
		public static IGrammarAwareElementType createXDoWhileExpression_BodyXExpressionParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_BodyXExpressionParserRuleCall_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createXDoWhileExpression_WhileKeyword_3ElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_WhileKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionAccess().getWhileKeyword_3());
		}
		public static IGrammarAwareElementType createXDoWhileExpression_LeftParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_LeftParenthesisKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
		}
		public static IGrammarAwareElementType createXDoWhileExpression_PredicateAssignment_5ElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_PredicateAssignment_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionAccess().getPredicateAssignment_5());
		}
		public static IGrammarAwareElementType createXDoWhileExpression_PredicateXExpressionParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_PredicateXExpressionParserRuleCall_5_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0());
		}
		public static IGrammarAwareElementType createXDoWhileExpression_RightParenthesisKeyword_6ElementType() {
			return new IGrammarAwareElementType("XDoWhileExpression_RightParenthesisKeyword_6_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
		}
	}

	public static final IGrammarAwareElementType XDoWhileExpression_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpressionElementType());

	public static final IGrammarAwareElementType XDoWhileExpression_Group_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpression_GroupElementType());

	public static final IGrammarAwareElementType XDoWhileExpression_XDoWhileExpressionAction_0_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpression_XDoWhileExpressionAction_0ElementType());

	public static final IGrammarAwareElementType XDoWhileExpression_DoKeyword_1_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpression_DoKeyword_1ElementType());

	public static final IGrammarAwareElementType XDoWhileExpression_BodyAssignment_2_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpression_BodyAssignment_2ElementType());

	public static final IGrammarAwareElementType XDoWhileExpression_BodyXExpressionParserRuleCall_2_0_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpression_BodyXExpressionParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType XDoWhileExpression_WhileKeyword_3_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpression_WhileKeyword_3ElementType());

	public static final IGrammarAwareElementType XDoWhileExpression_LeftParenthesisKeyword_4_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpression_LeftParenthesisKeyword_4ElementType());

	public static final IGrammarAwareElementType XDoWhileExpression_PredicateAssignment_5_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpression_PredicateAssignment_5ElementType());

	public static final IGrammarAwareElementType XDoWhileExpression_PredicateXExpressionParserRuleCall_5_0_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpression_PredicateXExpressionParserRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType XDoWhileExpression_RightParenthesisKeyword_6_ELEMENT_TYPE = associate(XDoWhileExpressionFactory.createXDoWhileExpression_RightParenthesisKeyword_6ElementType());

	private static class XBlockExpressionFactory {
		public static IGrammarAwareElementType createXBlockExpressionElementType() {
			return new IGrammarAwareElementType("XBlockExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBlockExpressionRule());
		}
		public static IGrammarAwareElementType createXBlockExpression_GroupElementType() {
			return new IGrammarAwareElementType("XBlockExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBlockExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXBlockExpression_XBlockExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("XBlockExpression_XBlockExpressionAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBlockExpressionAccess().getXBlockExpressionAction_0());
		}
		public static IGrammarAwareElementType createXBlockExpression_LeftCurlyBracketKeyword_1ElementType() {
			return new IGrammarAwareElementType("XBlockExpression_LeftCurlyBracketKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
		}
		public static IGrammarAwareElementType createXBlockExpression_Group_2ElementType() {
			return new IGrammarAwareElementType("XBlockExpression_Group_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBlockExpressionAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createXBlockExpression_ExpressionsAssignment_2_0ElementType() {
			return new IGrammarAwareElementType("XBlockExpression_ExpressionsAssignment_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBlockExpressionAccess().getExpressionsAssignment_2_0());
		}
		public static IGrammarAwareElementType createXBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("XBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createXBlockExpression_SemicolonKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("XBlockExpression_SemicolonKeyword_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		}
		public static IGrammarAwareElementType createXBlockExpression_RightCurlyBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("XBlockExpression_RightCurlyBracketKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
		}
	}

	public static final IGrammarAwareElementType XBlockExpression_ELEMENT_TYPE = associate(XBlockExpressionFactory.createXBlockExpressionElementType());

	public static final IGrammarAwareElementType XBlockExpression_Group_ELEMENT_TYPE = associate(XBlockExpressionFactory.createXBlockExpression_GroupElementType());

	public static final IGrammarAwareElementType XBlockExpression_XBlockExpressionAction_0_ELEMENT_TYPE = associate(XBlockExpressionFactory.createXBlockExpression_XBlockExpressionAction_0ElementType());

	public static final IGrammarAwareElementType XBlockExpression_LeftCurlyBracketKeyword_1_ELEMENT_TYPE = associate(XBlockExpressionFactory.createXBlockExpression_LeftCurlyBracketKeyword_1ElementType());

	public static final IGrammarAwareElementType XBlockExpression_Group_2_ELEMENT_TYPE = associate(XBlockExpressionFactory.createXBlockExpression_Group_2ElementType());

	public static final IGrammarAwareElementType XBlockExpression_ExpressionsAssignment_2_0_ELEMENT_TYPE = associate(XBlockExpressionFactory.createXBlockExpression_ExpressionsAssignment_2_0ElementType());

	public static final IGrammarAwareElementType XBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0_ELEMENT_TYPE = associate(XBlockExpressionFactory.createXBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType XBlockExpression_SemicolonKeyword_2_1_ELEMENT_TYPE = associate(XBlockExpressionFactory.createXBlockExpression_SemicolonKeyword_2_1ElementType());

	public static final IGrammarAwareElementType XBlockExpression_RightCurlyBracketKeyword_3_ELEMENT_TYPE = associate(XBlockExpressionFactory.createXBlockExpression_RightCurlyBracketKeyword_3ElementType());

	private static class XExpressionOrVarDeclarationFactory {
		public static IGrammarAwareElementType createXExpressionOrVarDeclarationElementType() {
			return new IGrammarAwareElementType("XExpressionOrVarDeclaration_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionOrVarDeclarationRule());
		}
		public static IGrammarAwareElementType createXExpressionOrVarDeclaration_AlternativesElementType() {
			return new IGrammarAwareElementType("XExpressionOrVarDeclaration_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionOrVarDeclarationAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createXExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionOrVarDeclarationAccess().getXVariableDeclarationParserRuleCall_0());
		}
		public static IGrammarAwareElementType createXExpressionOrVarDeclaration_XExpressionParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("XExpressionOrVarDeclaration_XExpressionParserRuleCall_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXExpressionOrVarDeclarationAccess().getXExpressionParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType XExpressionOrVarDeclaration_ELEMENT_TYPE = associate(XExpressionOrVarDeclarationFactory.createXExpressionOrVarDeclarationElementType());

	public static final IGrammarAwareElementType XExpressionOrVarDeclaration_Alternatives_ELEMENT_TYPE = associate(XExpressionOrVarDeclarationFactory.createXExpressionOrVarDeclaration_AlternativesElementType());

	public static final IGrammarAwareElementType XExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0_ELEMENT_TYPE = associate(XExpressionOrVarDeclarationFactory.createXExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType XExpressionOrVarDeclaration_XExpressionParserRuleCall_1_ELEMENT_TYPE = associate(XExpressionOrVarDeclarationFactory.createXExpressionOrVarDeclaration_XExpressionParserRuleCall_1ElementType());

	private static class XVariableDeclarationFactory {
		public static IGrammarAwareElementType createXVariableDeclarationElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationRule());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_GroupElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getGroup());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_XVariableDeclarationAction_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_XVariableDeclarationAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getXVariableDeclarationAction_0());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_Alternatives_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_WriteableAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_WriteableAssignment_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getWriteableAssignment_1_0());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_WriteableVarKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_WriteableVarKeyword_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_ValKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_ValKeyword_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getValKeyword_1_1());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_Alternatives_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_Group_2_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_Group_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getGroup_2_0());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_Group_2_0_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_Group_2_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getGroup_2_0_0());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_TypeAssignment_2_0_0_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_TypeAssignment_2_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getTypeAssignment_2_0_0_0());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_NameAssignment_2_0_0_1ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_NameAssignment_2_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getNameAssignment_2_0_0_1());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_NameAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_NameAssignment_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getNameAssignment_2_1());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_NameValidIDParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_NameValidIDParserRuleCall_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_Group_3ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_Group_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_EqualsSignKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_EqualsSignKeyword_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_RightAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_RightAssignment_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getRightAssignment_3_1());
		}
		public static IGrammarAwareElementType createXVariableDeclaration_RightXExpressionParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("XVariableDeclaration_RightXExpressionParserRuleCall_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType XVariableDeclaration_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclarationElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_Group_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_GroupElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_XVariableDeclarationAction_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_XVariableDeclarationAction_0ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_Alternatives_1_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_Alternatives_1ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_WriteableAssignment_1_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_WriteableAssignment_1_0ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_WriteableVarKeyword_1_0_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_WriteableVarKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_ValKeyword_1_1_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_ValKeyword_1_1ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_Alternatives_2_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_Alternatives_2ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_Group_2_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_Group_2_0ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_Group_2_0_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_Group_2_0_0ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_TypeAssignment_2_0_0_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_TypeAssignment_2_0_0_0ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_0ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_NameAssignment_2_0_0_1_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_NameAssignment_2_0_0_1ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_NameAssignment_2_1_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_NameAssignment_2_1ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_NameValidIDParserRuleCall_2_1_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_NameValidIDParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_Group_3_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_Group_3ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_EqualsSignKeyword_3_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_EqualsSignKeyword_3_0ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_RightAssignment_3_1_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_RightAssignment_3_1ElementType());

	public static final IGrammarAwareElementType XVariableDeclaration_RightXExpressionParserRuleCall_3_1_0_ELEMENT_TYPE = associate(XVariableDeclarationFactory.createXVariableDeclaration_RightXExpressionParserRuleCall_3_1_0ElementType());

	private static class JvmFormalParameterFactory {
		public static IGrammarAwareElementType createJvmFormalParameterElementType() {
			return new IGrammarAwareElementType("JvmFormalParameter_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmFormalParameterRule());
		}
		public static IGrammarAwareElementType createJvmFormalParameter_GroupElementType() {
			return new IGrammarAwareElementType("JvmFormalParameter_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmFormalParameterAccess().getGroup());
		}
		public static IGrammarAwareElementType createJvmFormalParameter_ParameterTypeAssignment_0ElementType() {
			return new IGrammarAwareElementType("JvmFormalParameter_ParameterTypeAssignment_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmFormalParameterAccess().getParameterTypeAssignment_0());
		}
		public static IGrammarAwareElementType createJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("JvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createJvmFormalParameter_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("JvmFormalParameter_NameAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmFormalParameterAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("JvmFormalParameter_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType JvmFormalParameter_ELEMENT_TYPE = associate(JvmFormalParameterFactory.createJvmFormalParameterElementType());

	public static final IGrammarAwareElementType JvmFormalParameter_Group_ELEMENT_TYPE = associate(JvmFormalParameterFactory.createJvmFormalParameter_GroupElementType());

	public static final IGrammarAwareElementType JvmFormalParameter_ParameterTypeAssignment_0_ELEMENT_TYPE = associate(JvmFormalParameterFactory.createJvmFormalParameter_ParameterTypeAssignment_0ElementType());

	public static final IGrammarAwareElementType JvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0_ELEMENT_TYPE = associate(JvmFormalParameterFactory.createJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType JvmFormalParameter_NameAssignment_1_ELEMENT_TYPE = associate(JvmFormalParameterFactory.createJvmFormalParameter_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType JvmFormalParameter_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE = associate(JvmFormalParameterFactory.createJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType());

	private static class FullJvmFormalParameterFactory {
		public static IGrammarAwareElementType createFullJvmFormalParameterElementType() {
			return new IGrammarAwareElementType("FullJvmFormalParameter_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFullJvmFormalParameterRule());
		}
		public static IGrammarAwareElementType createFullJvmFormalParameter_GroupElementType() {
			return new IGrammarAwareElementType("FullJvmFormalParameter_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFullJvmFormalParameterAccess().getGroup());
		}
		public static IGrammarAwareElementType createFullJvmFormalParameter_ParameterTypeAssignment_0ElementType() {
			return new IGrammarAwareElementType("FullJvmFormalParameter_ParameterTypeAssignment_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFullJvmFormalParameterAccess().getParameterTypeAssignment_0());
		}
		public static IGrammarAwareElementType createFullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("FullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createFullJvmFormalParameter_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("FullJvmFormalParameter_NameAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFullJvmFormalParameterAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createFullJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("FullJvmFormalParameter_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType FullJvmFormalParameter_ELEMENT_TYPE = associate(FullJvmFormalParameterFactory.createFullJvmFormalParameterElementType());

	public static final IGrammarAwareElementType FullJvmFormalParameter_Group_ELEMENT_TYPE = associate(FullJvmFormalParameterFactory.createFullJvmFormalParameter_GroupElementType());

	public static final IGrammarAwareElementType FullJvmFormalParameter_ParameterTypeAssignment_0_ELEMENT_TYPE = associate(FullJvmFormalParameterFactory.createFullJvmFormalParameter_ParameterTypeAssignment_0ElementType());

	public static final IGrammarAwareElementType FullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0_ELEMENT_TYPE = associate(FullJvmFormalParameterFactory.createFullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType FullJvmFormalParameter_NameAssignment_1_ELEMENT_TYPE = associate(FullJvmFormalParameterFactory.createFullJvmFormalParameter_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType FullJvmFormalParameter_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE = associate(FullJvmFormalParameterFactory.createFullJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType());

	private static class XFeatureCallFactory {
		public static IGrammarAwareElementType createXFeatureCallElementType() {
			return new IGrammarAwareElementType("XFeatureCall_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallRule());
		}
		public static IGrammarAwareElementType createXFeatureCall_GroupElementType() {
			return new IGrammarAwareElementType("XFeatureCall_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getGroup());
		}
		public static IGrammarAwareElementType createXFeatureCall_XFeatureCallAction_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_XFeatureCallAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getXFeatureCallAction_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_Group_1ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createXFeatureCall_LessThanSignKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_LessThanSignKeyword_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getLessThanSignKeyword_1_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_TypeArgumentsAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_TypeArgumentsAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getTypeArgumentsAssignment_1_1());
		}
		public static IGrammarAwareElementType createXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_Group_1_2ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_Group_1_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getGroup_1_2());
		}
		public static IGrammarAwareElementType createXFeatureCall_CommaKeyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_CommaKeyword_1_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getCommaKeyword_1_2_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_TypeArgumentsAssignment_1_2_1ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_TypeArgumentsAssignment_1_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getTypeArgumentsAssignment_1_2_1());
		}
		public static IGrammarAwareElementType createXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_GreaterThanSignKeyword_1_3ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_GreaterThanSignKeyword_1_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureAssignment_2ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureAssignment_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureAssignment_2());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1());
		}
		public static IGrammarAwareElementType createXFeatureCall_Group_3ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_Group_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createXFeatureCall_ExplicitOperationCallAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_ExplicitOperationCallAssignment_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getExplicitOperationCallAssignment_3_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_Alternatives_3_1ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_Alternatives_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getAlternatives_3_1());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureCallArgumentsAssignment_3_1_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureCallArgumentsAssignment_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_Group_3_1_1ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_Group_3_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getGroup_3_1_1());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureCallArgumentsAssignment_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureCallArgumentsAssignment_3_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_1_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_Group_3_1_1_1ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_Group_3_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getGroup_3_1_1_1());
		}
		public static IGrammarAwareElementType createXFeatureCall_CommaKeyword_3_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_CommaKeyword_3_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureCallArgumentsAssignment_3_1_1_1_1ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureCallArgumentsAssignment_3_1_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_1_1_1());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0());
		}
		public static IGrammarAwareElementType createXFeatureCall_RightParenthesisKeyword_3_2ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_RightParenthesisKeyword_3_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getRightParenthesisKeyword_3_2());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureCallArgumentsAssignment_4ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureCallArgumentsAssignment_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_4());
		}
		public static IGrammarAwareElementType createXFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("XFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0());
		}
	}

	public static final IGrammarAwareElementType XFeatureCall_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCallElementType());

	public static final IGrammarAwareElementType XFeatureCall_Group_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_GroupElementType());

	public static final IGrammarAwareElementType XFeatureCall_XFeatureCallAction_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_XFeatureCallAction_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_Group_1_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_Group_1ElementType());

	public static final IGrammarAwareElementType XFeatureCall_LessThanSignKeyword_1_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_LessThanSignKeyword_1_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_TypeArgumentsAssignment_1_1_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_TypeArgumentsAssignment_1_1ElementType());

	public static final IGrammarAwareElementType XFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_Group_1_2_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_Group_1_2ElementType());

	public static final IGrammarAwareElementType XFeatureCall_CommaKeyword_1_2_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_CommaKeyword_1_2_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_TypeArgumentsAssignment_1_2_1_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_TypeArgumentsAssignment_1_2_1ElementType());

	public static final IGrammarAwareElementType XFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_GreaterThanSignKeyword_1_3_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_GreaterThanSignKeyword_1_3ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureAssignment_2_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureAssignment_2ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1ElementType());

	public static final IGrammarAwareElementType XFeatureCall_Group_3_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_Group_3ElementType());

	public static final IGrammarAwareElementType XFeatureCall_ExplicitOperationCallAssignment_3_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_ExplicitOperationCallAssignment_3_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_Alternatives_3_1_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_Alternatives_3_1ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureCallArgumentsAssignment_3_1_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureCallArgumentsAssignment_3_1_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_Group_3_1_1_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_Group_3_1_1ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureCallArgumentsAssignment_3_1_1_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureCallArgumentsAssignment_3_1_1_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_Group_3_1_1_1_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_Group_3_1_1_1ElementType());

	public static final IGrammarAwareElementType XFeatureCall_CommaKeyword_3_1_1_1_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_CommaKeyword_3_1_1_1_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureCallArgumentsAssignment_3_1_1_1_1_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureCallArgumentsAssignment_3_1_1_1_1ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0ElementType());

	public static final IGrammarAwareElementType XFeatureCall_RightParenthesisKeyword_3_2_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_RightParenthesisKeyword_3_2ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureCallArgumentsAssignment_4_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureCallArgumentsAssignment_4ElementType());

	public static final IGrammarAwareElementType XFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0_ELEMENT_TYPE = associate(XFeatureCallFactory.createXFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0ElementType());

	private static class FeatureCallIDFactory {
		public static IGrammarAwareElementType createFeatureCallIDElementType() {
			return new IGrammarAwareElementType("FeatureCallID_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureCallIDRule());
		}
		public static IGrammarAwareElementType createFeatureCallID_AlternativesElementType() {
			return new IGrammarAwareElementType("FeatureCallID_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureCallIDAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createFeatureCallID_ValidIDParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("FeatureCallID_ValidIDParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureCallIDAccess().getValidIDParserRuleCall_0());
		}
		public static IGrammarAwareElementType createFeatureCallID_ExtendsKeyword_1ElementType() {
			return new IGrammarAwareElementType("FeatureCallID_ExtendsKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureCallIDAccess().getExtendsKeyword_1());
		}
		public static IGrammarAwareElementType createFeatureCallID_StaticKeyword_2ElementType() {
			return new IGrammarAwareElementType("FeatureCallID_StaticKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureCallIDAccess().getStaticKeyword_2());
		}
		public static IGrammarAwareElementType createFeatureCallID_ImportKeyword_3ElementType() {
			return new IGrammarAwareElementType("FeatureCallID_ImportKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureCallIDAccess().getImportKeyword_3());
		}
		public static IGrammarAwareElementType createFeatureCallID_ExtensionKeyword_4ElementType() {
			return new IGrammarAwareElementType("FeatureCallID_ExtensionKeyword_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getFeatureCallIDAccess().getExtensionKeyword_4());
		}
	}

	public static final IGrammarAwareElementType FeatureCallID_ELEMENT_TYPE = associate(FeatureCallIDFactory.createFeatureCallIDElementType());

	public static final IGrammarAwareElementType FeatureCallID_Alternatives_ELEMENT_TYPE = associate(FeatureCallIDFactory.createFeatureCallID_AlternativesElementType());

	public static final IGrammarAwareElementType FeatureCallID_ValidIDParserRuleCall_0_ELEMENT_TYPE = associate(FeatureCallIDFactory.createFeatureCallID_ValidIDParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType FeatureCallID_ExtendsKeyword_1_ELEMENT_TYPE = associate(FeatureCallIDFactory.createFeatureCallID_ExtendsKeyword_1ElementType());

	public static final IGrammarAwareElementType FeatureCallID_StaticKeyword_2_ELEMENT_TYPE = associate(FeatureCallIDFactory.createFeatureCallID_StaticKeyword_2ElementType());

	public static final IGrammarAwareElementType FeatureCallID_ImportKeyword_3_ELEMENT_TYPE = associate(FeatureCallIDFactory.createFeatureCallID_ImportKeyword_3ElementType());

	public static final IGrammarAwareElementType FeatureCallID_ExtensionKeyword_4_ELEMENT_TYPE = associate(FeatureCallIDFactory.createFeatureCallID_ExtensionKeyword_4ElementType());

	private static class IdOrSuperFactory {
		public static IGrammarAwareElementType createIdOrSuperElementType() {
			return new IGrammarAwareElementType("IdOrSuper_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getIdOrSuperRule());
		}
		public static IGrammarAwareElementType createIdOrSuper_AlternativesElementType() {
			return new IGrammarAwareElementType("IdOrSuper_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getIdOrSuperAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createIdOrSuper_FeatureCallIDParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("IdOrSuper_FeatureCallIDParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getIdOrSuperAccess().getFeatureCallIDParserRuleCall_0());
		}
		public static IGrammarAwareElementType createIdOrSuper_SuperKeyword_1ElementType() {
			return new IGrammarAwareElementType("IdOrSuper_SuperKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getIdOrSuperAccess().getSuperKeyword_1());
		}
	}

	public static final IGrammarAwareElementType IdOrSuper_ELEMENT_TYPE = associate(IdOrSuperFactory.createIdOrSuperElementType());

	public static final IGrammarAwareElementType IdOrSuper_Alternatives_ELEMENT_TYPE = associate(IdOrSuperFactory.createIdOrSuper_AlternativesElementType());

	public static final IGrammarAwareElementType IdOrSuper_FeatureCallIDParserRuleCall_0_ELEMENT_TYPE = associate(IdOrSuperFactory.createIdOrSuper_FeatureCallIDParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType IdOrSuper_SuperKeyword_1_ELEMENT_TYPE = associate(IdOrSuperFactory.createIdOrSuper_SuperKeyword_1ElementType());

	private static class XConstructorCallFactory {
		public static IGrammarAwareElementType createXConstructorCallElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallRule());
		}
		public static IGrammarAwareElementType createXConstructorCall_GroupElementType() {
			return new IGrammarAwareElementType("XConstructorCall_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getGroup());
		}
		public static IGrammarAwareElementType createXConstructorCall_XConstructorCallAction_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_XConstructorCallAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getXConstructorCallAction_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_NewKeyword_1ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_NewKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getNewKeyword_1());
		}
		public static IGrammarAwareElementType createXConstructorCall_ConstructorAssignment_2ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ConstructorAssignment_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getConstructorAssignment_2());
		}
		public static IGrammarAwareElementType createXConstructorCall_ConstructorJvmConstructorCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ConstructorJvmConstructorCrossReference_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_ConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1());
		}
		public static IGrammarAwareElementType createXConstructorCall_Group_3ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_Group_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createXConstructorCall_LessThanSignKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_LessThanSignKeyword_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_TypeArgumentsAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_TypeArgumentsAssignment_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getTypeArgumentsAssignment_3_1());
		}
		public static IGrammarAwareElementType createXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_Group_3_2ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_Group_3_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getGroup_3_2());
		}
		public static IGrammarAwareElementType createXConstructorCall_CommaKeyword_3_2_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_CommaKeyword_3_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getCommaKeyword_3_2_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_TypeArgumentsAssignment_3_2_1ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_TypeArgumentsAssignment_3_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getTypeArgumentsAssignment_3_2_1());
		}
		public static IGrammarAwareElementType createXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_GreaterThanSignKeyword_3_3ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_GreaterThanSignKeyword_3_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
		}
		public static IGrammarAwareElementType createXConstructorCall_Group_4ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_Group_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createXConstructorCall_ExplicitConstructorCallAssignment_4_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ExplicitConstructorCallAssignment_4_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getExplicitConstructorCallAssignment_4_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_Alternatives_4_1ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_Alternatives_4_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getAlternatives_4_1());
		}
		public static IGrammarAwareElementType createXConstructorCall_ArgumentsAssignment_4_1_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ArgumentsAssignment_4_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getArgumentsAssignment_4_1_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_Group_4_1_1ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_Group_4_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getGroup_4_1_1());
		}
		public static IGrammarAwareElementType createXConstructorCall_ArgumentsAssignment_4_1_1_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ArgumentsAssignment_4_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getArgumentsAssignment_4_1_1_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_Group_4_1_1_1ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_Group_4_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getGroup_4_1_1_1());
		}
		public static IGrammarAwareElementType createXConstructorCall_CommaKeyword_4_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_CommaKeyword_4_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_ArgumentsAssignment_4_1_1_1_1ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ArgumentsAssignment_4_1_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getArgumentsAssignment_4_1_1_1_1());
		}
		public static IGrammarAwareElementType createXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0());
		}
		public static IGrammarAwareElementType createXConstructorCall_RightParenthesisKeyword_4_2ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_RightParenthesisKeyword_4_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
		}
		public static IGrammarAwareElementType createXConstructorCall_ArgumentsAssignment_5ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ArgumentsAssignment_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getArgumentsAssignment_5());
		}
		public static IGrammarAwareElementType createXConstructorCall_ArgumentsXClosureParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("XConstructorCall_ArgumentsXClosureParserRuleCall_5_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0());
		}
	}

	public static final IGrammarAwareElementType XConstructorCall_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCallElementType());

	public static final IGrammarAwareElementType XConstructorCall_Group_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_GroupElementType());

	public static final IGrammarAwareElementType XConstructorCall_XConstructorCallAction_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_XConstructorCallAction_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_NewKeyword_1_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_NewKeyword_1ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ConstructorAssignment_2_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ConstructorAssignment_2ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ConstructorJvmConstructorCrossReference_2_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ConstructorJvmConstructorCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1ElementType());

	public static final IGrammarAwareElementType XConstructorCall_Group_3_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_Group_3ElementType());

	public static final IGrammarAwareElementType XConstructorCall_LessThanSignKeyword_3_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_LessThanSignKeyword_3_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_TypeArgumentsAssignment_3_1_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_TypeArgumentsAssignment_3_1ElementType());

	public static final IGrammarAwareElementType XConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_Group_3_2_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_Group_3_2ElementType());

	public static final IGrammarAwareElementType XConstructorCall_CommaKeyword_3_2_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_CommaKeyword_3_2_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_TypeArgumentsAssignment_3_2_1_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_TypeArgumentsAssignment_3_2_1ElementType());

	public static final IGrammarAwareElementType XConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_GreaterThanSignKeyword_3_3_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_GreaterThanSignKeyword_3_3ElementType());

	public static final IGrammarAwareElementType XConstructorCall_Group_4_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_Group_4ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ExplicitConstructorCallAssignment_4_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ExplicitConstructorCallAssignment_4_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_Alternatives_4_1_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_Alternatives_4_1ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ArgumentsAssignment_4_1_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ArgumentsAssignment_4_1_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_Group_4_1_1_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_Group_4_1_1ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ArgumentsAssignment_4_1_1_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ArgumentsAssignment_4_1_1_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_Group_4_1_1_1_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_Group_4_1_1_1ElementType());

	public static final IGrammarAwareElementType XConstructorCall_CommaKeyword_4_1_1_1_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_CommaKeyword_4_1_1_1_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ArgumentsAssignment_4_1_1_1_1_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ArgumentsAssignment_4_1_1_1_1ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0ElementType());

	public static final IGrammarAwareElementType XConstructorCall_RightParenthesisKeyword_4_2_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_RightParenthesisKeyword_4_2ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ArgumentsAssignment_5_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ArgumentsAssignment_5ElementType());

	public static final IGrammarAwareElementType XConstructorCall_ArgumentsXClosureParserRuleCall_5_0_ELEMENT_TYPE = associate(XConstructorCallFactory.createXConstructorCall_ArgumentsXClosureParserRuleCall_5_0ElementType());

	private static class XBooleanLiteralFactory {
		public static IGrammarAwareElementType createXBooleanLiteralElementType() {
			return new IGrammarAwareElementType("XBooleanLiteral_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBooleanLiteralRule());
		}
		public static IGrammarAwareElementType createXBooleanLiteral_GroupElementType() {
			return new IGrammarAwareElementType("XBooleanLiteral_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBooleanLiteralAccess().getGroup());
		}
		public static IGrammarAwareElementType createXBooleanLiteral_XBooleanLiteralAction_0ElementType() {
			return new IGrammarAwareElementType("XBooleanLiteral_XBooleanLiteralAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBooleanLiteralAccess().getXBooleanLiteralAction_0());
		}
		public static IGrammarAwareElementType createXBooleanLiteral_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("XBooleanLiteral_Alternatives_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBooleanLiteralAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createXBooleanLiteral_FalseKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("XBooleanLiteral_FalseKeyword_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBooleanLiteralAccess().getFalseKeyword_1_0());
		}
		public static IGrammarAwareElementType createXBooleanLiteral_IsTrueAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("XBooleanLiteral_IsTrueAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBooleanLiteralAccess().getIsTrueAssignment_1_1());
		}
		public static IGrammarAwareElementType createXBooleanLiteral_IsTrueTrueKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("XBooleanLiteral_IsTrueTrueKeyword_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XBooleanLiteral_ELEMENT_TYPE = associate(XBooleanLiteralFactory.createXBooleanLiteralElementType());

	public static final IGrammarAwareElementType XBooleanLiteral_Group_ELEMENT_TYPE = associate(XBooleanLiteralFactory.createXBooleanLiteral_GroupElementType());

	public static final IGrammarAwareElementType XBooleanLiteral_XBooleanLiteralAction_0_ELEMENT_TYPE = associate(XBooleanLiteralFactory.createXBooleanLiteral_XBooleanLiteralAction_0ElementType());

	public static final IGrammarAwareElementType XBooleanLiteral_Alternatives_1_ELEMENT_TYPE = associate(XBooleanLiteralFactory.createXBooleanLiteral_Alternatives_1ElementType());

	public static final IGrammarAwareElementType XBooleanLiteral_FalseKeyword_1_0_ELEMENT_TYPE = associate(XBooleanLiteralFactory.createXBooleanLiteral_FalseKeyword_1_0ElementType());

	public static final IGrammarAwareElementType XBooleanLiteral_IsTrueAssignment_1_1_ELEMENT_TYPE = associate(XBooleanLiteralFactory.createXBooleanLiteral_IsTrueAssignment_1_1ElementType());

	public static final IGrammarAwareElementType XBooleanLiteral_IsTrueTrueKeyword_1_1_0_ELEMENT_TYPE = associate(XBooleanLiteralFactory.createXBooleanLiteral_IsTrueTrueKeyword_1_1_0ElementType());

	private static class XNullLiteralFactory {
		public static IGrammarAwareElementType createXNullLiteralElementType() {
			return new IGrammarAwareElementType("XNullLiteral_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXNullLiteralRule());
		}
		public static IGrammarAwareElementType createXNullLiteral_GroupElementType() {
			return new IGrammarAwareElementType("XNullLiteral_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXNullLiteralAccess().getGroup());
		}
		public static IGrammarAwareElementType createXNullLiteral_XNullLiteralAction_0ElementType() {
			return new IGrammarAwareElementType("XNullLiteral_XNullLiteralAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXNullLiteralAccess().getXNullLiteralAction_0());
		}
		public static IGrammarAwareElementType createXNullLiteral_NullKeyword_1ElementType() {
			return new IGrammarAwareElementType("XNullLiteral_NullKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXNullLiteralAccess().getNullKeyword_1());
		}
	}

	public static final IGrammarAwareElementType XNullLiteral_ELEMENT_TYPE = associate(XNullLiteralFactory.createXNullLiteralElementType());

	public static final IGrammarAwareElementType XNullLiteral_Group_ELEMENT_TYPE = associate(XNullLiteralFactory.createXNullLiteral_GroupElementType());

	public static final IGrammarAwareElementType XNullLiteral_XNullLiteralAction_0_ELEMENT_TYPE = associate(XNullLiteralFactory.createXNullLiteral_XNullLiteralAction_0ElementType());

	public static final IGrammarAwareElementType XNullLiteral_NullKeyword_1_ELEMENT_TYPE = associate(XNullLiteralFactory.createXNullLiteral_NullKeyword_1ElementType());

	private static class XNumberLiteralFactory {
		public static IGrammarAwareElementType createXNumberLiteralElementType() {
			return new IGrammarAwareElementType("XNumberLiteral_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXNumberLiteralRule());
		}
		public static IGrammarAwareElementType createXNumberLiteral_GroupElementType() {
			return new IGrammarAwareElementType("XNumberLiteral_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXNumberLiteralAccess().getGroup());
		}
		public static IGrammarAwareElementType createXNumberLiteral_XNumberLiteralAction_0ElementType() {
			return new IGrammarAwareElementType("XNumberLiteral_XNumberLiteralAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXNumberLiteralAccess().getXNumberLiteralAction_0());
		}
		public static IGrammarAwareElementType createXNumberLiteral_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("XNumberLiteral_ValueAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXNumberLiteralAccess().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createXNumberLiteral_ValueNumberParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("XNumberLiteral_ValueNumberParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType XNumberLiteral_ELEMENT_TYPE = associate(XNumberLiteralFactory.createXNumberLiteralElementType());

	public static final IGrammarAwareElementType XNumberLiteral_Group_ELEMENT_TYPE = associate(XNumberLiteralFactory.createXNumberLiteral_GroupElementType());

	public static final IGrammarAwareElementType XNumberLiteral_XNumberLiteralAction_0_ELEMENT_TYPE = associate(XNumberLiteralFactory.createXNumberLiteral_XNumberLiteralAction_0ElementType());

	public static final IGrammarAwareElementType XNumberLiteral_ValueAssignment_1_ELEMENT_TYPE = associate(XNumberLiteralFactory.createXNumberLiteral_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType XNumberLiteral_ValueNumberParserRuleCall_1_0_ELEMENT_TYPE = associate(XNumberLiteralFactory.createXNumberLiteral_ValueNumberParserRuleCall_1_0ElementType());

	private static class XStringLiteralFactory {
		public static IGrammarAwareElementType createXStringLiteralElementType() {
			return new IGrammarAwareElementType("XStringLiteral_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXStringLiteralRule());
		}
		public static IGrammarAwareElementType createXStringLiteral_GroupElementType() {
			return new IGrammarAwareElementType("XStringLiteral_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXStringLiteralAccess().getGroup());
		}
		public static IGrammarAwareElementType createXStringLiteral_XStringLiteralAction_0ElementType() {
			return new IGrammarAwareElementType("XStringLiteral_XStringLiteralAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXStringLiteralAccess().getXStringLiteralAction_0());
		}
		public static IGrammarAwareElementType createXStringLiteral_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("XStringLiteral_ValueAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXStringLiteralAccess().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createXStringLiteral_ValueSTRINGTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("XStringLiteral_ValueSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType XStringLiteral_ELEMENT_TYPE = associate(XStringLiteralFactory.createXStringLiteralElementType());

	public static final IGrammarAwareElementType XStringLiteral_Group_ELEMENT_TYPE = associate(XStringLiteralFactory.createXStringLiteral_GroupElementType());

	public static final IGrammarAwareElementType XStringLiteral_XStringLiteralAction_0_ELEMENT_TYPE = associate(XStringLiteralFactory.createXStringLiteral_XStringLiteralAction_0ElementType());

	public static final IGrammarAwareElementType XStringLiteral_ValueAssignment_1_ELEMENT_TYPE = associate(XStringLiteralFactory.createXStringLiteral_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType XStringLiteral_ValueSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE = associate(XStringLiteralFactory.createXStringLiteral_ValueSTRINGTerminalRuleCall_1_0ElementType());

	private static class XTypeLiteralFactory {
		public static IGrammarAwareElementType createXTypeLiteralElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralRule());
		}
		public static IGrammarAwareElementType createXTypeLiteral_GroupElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralAccess().getGroup());
		}
		public static IGrammarAwareElementType createXTypeLiteral_XTypeLiteralAction_0ElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_XTypeLiteralAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralAccess().getXTypeLiteralAction_0());
		}
		public static IGrammarAwareElementType createXTypeLiteral_TypeofKeyword_1ElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_TypeofKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralAccess().getTypeofKeyword_1());
		}
		public static IGrammarAwareElementType createXTypeLiteral_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_LeftParenthesisKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createXTypeLiteral_TypeAssignment_3ElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_TypeAssignment_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralAccess().getTypeAssignment_3());
		}
		public static IGrammarAwareElementType createXTypeLiteral_TypeJvmTypeCrossReference_3_0ElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_TypeJvmTypeCrossReference_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0());
		}
		public static IGrammarAwareElementType createXTypeLiteral_TypeJvmTypeQualifiedNameParserRuleCall_3_0_1ElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_TypeJvmTypeQualifiedNameParserRuleCall_3_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralAccess().getTypeJvmTypeQualifiedNameParserRuleCall_3_0_1());
		}
		public static IGrammarAwareElementType createXTypeLiteral_ArrayDimensionsAssignment_4ElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_ArrayDimensionsAssignment_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralAccess().getArrayDimensionsAssignment_4());
		}
		public static IGrammarAwareElementType createXTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralAccess().getArrayDimensionsArrayBracketsParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createXTypeLiteral_RightParenthesisKeyword_5ElementType() {
			return new IGrammarAwareElementType("XTypeLiteral_RightParenthesisKeyword_5_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTypeLiteralAccess().getRightParenthesisKeyword_5());
		}
	}

	public static final IGrammarAwareElementType XTypeLiteral_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteralElementType());

	public static final IGrammarAwareElementType XTypeLiteral_Group_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteral_GroupElementType());

	public static final IGrammarAwareElementType XTypeLiteral_XTypeLiteralAction_0_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteral_XTypeLiteralAction_0ElementType());

	public static final IGrammarAwareElementType XTypeLiteral_TypeofKeyword_1_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteral_TypeofKeyword_1ElementType());

	public static final IGrammarAwareElementType XTypeLiteral_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteral_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType XTypeLiteral_TypeAssignment_3_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteral_TypeAssignment_3ElementType());

	public static final IGrammarAwareElementType XTypeLiteral_TypeJvmTypeCrossReference_3_0_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteral_TypeJvmTypeCrossReference_3_0ElementType());

	public static final IGrammarAwareElementType XTypeLiteral_TypeJvmTypeQualifiedNameParserRuleCall_3_0_1_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteral_TypeJvmTypeQualifiedNameParserRuleCall_3_0_1ElementType());

	public static final IGrammarAwareElementType XTypeLiteral_ArrayDimensionsAssignment_4_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteral_ArrayDimensionsAssignment_4ElementType());

	public static final IGrammarAwareElementType XTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType XTypeLiteral_RightParenthesisKeyword_5_ELEMENT_TYPE = associate(XTypeLiteralFactory.createXTypeLiteral_RightParenthesisKeyword_5ElementType());

	private static class XThrowExpressionFactory {
		public static IGrammarAwareElementType createXThrowExpressionElementType() {
			return new IGrammarAwareElementType("XThrowExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXThrowExpressionRule());
		}
		public static IGrammarAwareElementType createXThrowExpression_GroupElementType() {
			return new IGrammarAwareElementType("XThrowExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXThrowExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXThrowExpression_XThrowExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("XThrowExpression_XThrowExpressionAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXThrowExpressionAccess().getXThrowExpressionAction_0());
		}
		public static IGrammarAwareElementType createXThrowExpression_ThrowKeyword_1ElementType() {
			return new IGrammarAwareElementType("XThrowExpression_ThrowKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXThrowExpressionAccess().getThrowKeyword_1());
		}
		public static IGrammarAwareElementType createXThrowExpression_ExpressionAssignment_2ElementType() {
			return new IGrammarAwareElementType("XThrowExpression_ExpressionAssignment_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXThrowExpressionAccess().getExpressionAssignment_2());
		}
		public static IGrammarAwareElementType createXThrowExpression_ExpressionXExpressionParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("XThrowExpression_ExpressionXExpressionParserRuleCall_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType XThrowExpression_ELEMENT_TYPE = associate(XThrowExpressionFactory.createXThrowExpressionElementType());

	public static final IGrammarAwareElementType XThrowExpression_Group_ELEMENT_TYPE = associate(XThrowExpressionFactory.createXThrowExpression_GroupElementType());

	public static final IGrammarAwareElementType XThrowExpression_XThrowExpressionAction_0_ELEMENT_TYPE = associate(XThrowExpressionFactory.createXThrowExpression_XThrowExpressionAction_0ElementType());

	public static final IGrammarAwareElementType XThrowExpression_ThrowKeyword_1_ELEMENT_TYPE = associate(XThrowExpressionFactory.createXThrowExpression_ThrowKeyword_1ElementType());

	public static final IGrammarAwareElementType XThrowExpression_ExpressionAssignment_2_ELEMENT_TYPE = associate(XThrowExpressionFactory.createXThrowExpression_ExpressionAssignment_2ElementType());

	public static final IGrammarAwareElementType XThrowExpression_ExpressionXExpressionParserRuleCall_2_0_ELEMENT_TYPE = associate(XThrowExpressionFactory.createXThrowExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());

	private static class XReturnExpressionFactory {
		public static IGrammarAwareElementType createXReturnExpressionElementType() {
			return new IGrammarAwareElementType("XReturnExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXReturnExpressionRule());
		}
		public static IGrammarAwareElementType createXReturnExpression_GroupElementType() {
			return new IGrammarAwareElementType("XReturnExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXReturnExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXReturnExpression_XReturnExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("XReturnExpression_XReturnExpressionAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXReturnExpressionAccess().getXReturnExpressionAction_0());
		}
		public static IGrammarAwareElementType createXReturnExpression_ReturnKeyword_1ElementType() {
			return new IGrammarAwareElementType("XReturnExpression_ReturnKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXReturnExpressionAccess().getReturnKeyword_1());
		}
		public static IGrammarAwareElementType createXReturnExpression_ExpressionAssignment_2ElementType() {
			return new IGrammarAwareElementType("XReturnExpression_ExpressionAssignment_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXReturnExpressionAccess().getExpressionAssignment_2());
		}
		public static IGrammarAwareElementType createXReturnExpression_ExpressionXExpressionParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("XReturnExpression_ExpressionXExpressionParserRuleCall_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType XReturnExpression_ELEMENT_TYPE = associate(XReturnExpressionFactory.createXReturnExpressionElementType());

	public static final IGrammarAwareElementType XReturnExpression_Group_ELEMENT_TYPE = associate(XReturnExpressionFactory.createXReturnExpression_GroupElementType());

	public static final IGrammarAwareElementType XReturnExpression_XReturnExpressionAction_0_ELEMENT_TYPE = associate(XReturnExpressionFactory.createXReturnExpression_XReturnExpressionAction_0ElementType());

	public static final IGrammarAwareElementType XReturnExpression_ReturnKeyword_1_ELEMENT_TYPE = associate(XReturnExpressionFactory.createXReturnExpression_ReturnKeyword_1ElementType());

	public static final IGrammarAwareElementType XReturnExpression_ExpressionAssignment_2_ELEMENT_TYPE = associate(XReturnExpressionFactory.createXReturnExpression_ExpressionAssignment_2ElementType());

	public static final IGrammarAwareElementType XReturnExpression_ExpressionXExpressionParserRuleCall_2_0_ELEMENT_TYPE = associate(XReturnExpressionFactory.createXReturnExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());

	private static class XTryCatchFinallyExpressionFactory {
		public static IGrammarAwareElementType createXTryCatchFinallyExpressionElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionRule());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_GroupElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_TryKeyword_1ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_TryKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_ExpressionAssignment_2ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_ExpressionAssignment_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getExpressionAssignment_2());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_Alternatives_3ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_Alternatives_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getAlternatives_3());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_Group_3_0ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_Group_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getGroup_3_0());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_CatchClausesAssignment_3_0_0ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_CatchClausesAssignment_3_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getCatchClausesAssignment_3_0_0());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_Group_3_0_1ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_Group_3_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getGroup_3_0_1());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_FinallyKeyword_3_0_1_0ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_FinallyKeyword_3_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_FinallyExpressionAssignment_3_0_1_1ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_FinallyExpressionAssignment_3_0_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_3_0_1_1());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_Group_3_1ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_Group_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_FinallyKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_FinallyKeyword_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_FinallyExpressionAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_FinallyExpressionAssignment_3_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("XTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0());
		}
	}

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpressionElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_Group_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_GroupElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_TryKeyword_1_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_TryKeyword_1ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_ExpressionAssignment_2_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_ExpressionAssignment_2ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_Alternatives_3_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_Alternatives_3ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_Group_3_0_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_Group_3_0ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_CatchClausesAssignment_3_0_0_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_CatchClausesAssignment_3_0_0ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_Group_3_0_1_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_Group_3_0_1ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_FinallyKeyword_3_0_1_0_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_FinallyKeyword_3_0_1_0ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_FinallyExpressionAssignment_3_0_1_1_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_FinallyExpressionAssignment_3_0_1_1ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_Group_3_1_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_Group_3_1ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_FinallyKeyword_3_1_0_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_FinallyKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_FinallyExpressionAssignment_3_1_1_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_FinallyExpressionAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType XTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0_ELEMENT_TYPE = associate(XTryCatchFinallyExpressionFactory.createXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0ElementType());

	private static class XSynchronizedExpressionFactory {
		public static IGrammarAwareElementType createXSynchronizedExpressionElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionRule());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_GroupElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_Group_0ElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_Group_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_Group_0_0ElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_Group_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getGroup_0_0());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_XSynchronizedExpressionAction_0_0_0ElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_XSynchronizedExpressionAction_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_SynchronizedKeyword_0_0_1ElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_SynchronizedKeyword_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_LeftParenthesisKeyword_0_0_2ElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_LeftParenthesisKeyword_0_0_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_ParamAssignment_1ElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_ParamAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getParamAssignment_1());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_ParamXExpressionParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_ParamXExpressionParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_RightParenthesisKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getRightParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_ExpressionAssignment_3ElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_ExpressionAssignment_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getExpressionAssignment_3());
		}
		public static IGrammarAwareElementType createXSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("XSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXSynchronizedExpressionAccess().getExpressionXExpressionParserRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType XSynchronizedExpression_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpressionElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_Group_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_GroupElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_Group_0_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_Group_0ElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_Group_0_0_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_Group_0_0ElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_XSynchronizedExpressionAction_0_0_0_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_XSynchronizedExpressionAction_0_0_0ElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_SynchronizedKeyword_0_0_1_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_SynchronizedKeyword_0_0_1ElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_LeftParenthesisKeyword_0_0_2_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_LeftParenthesisKeyword_0_0_2ElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_ParamAssignment_1_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_ParamAssignment_1ElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_ParamXExpressionParserRuleCall_1_0_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_ParamXExpressionParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_RightParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_ExpressionAssignment_3_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_ExpressionAssignment_3ElementType());

	public static final IGrammarAwareElementType XSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0_ELEMENT_TYPE = associate(XSynchronizedExpressionFactory.createXSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0ElementType());

	private static class XCatchClauseFactory {
		public static IGrammarAwareElementType createXCatchClauseElementType() {
			return new IGrammarAwareElementType("XCatchClause_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCatchClauseRule());
		}
		public static IGrammarAwareElementType createXCatchClause_GroupElementType() {
			return new IGrammarAwareElementType("XCatchClause_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCatchClauseAccess().getGroup());
		}
		public static IGrammarAwareElementType createXCatchClause_CatchKeyword_0ElementType() {
			return new IGrammarAwareElementType("XCatchClause_CatchKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCatchClauseAccess().getCatchKeyword_0());
		}
		public static IGrammarAwareElementType createXCatchClause_LeftParenthesisKeyword_1ElementType() {
			return new IGrammarAwareElementType("XCatchClause_LeftParenthesisKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
		}
		public static IGrammarAwareElementType createXCatchClause_DeclaredParamAssignment_2ElementType() {
			return new IGrammarAwareElementType("XCatchClause_DeclaredParamAssignment_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCatchClauseAccess().getDeclaredParamAssignment_2());
		}
		public static IGrammarAwareElementType createXCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("XCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createXCatchClause_RightParenthesisKeyword_3ElementType() {
			return new IGrammarAwareElementType("XCatchClause_RightParenthesisKeyword_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCatchClauseAccess().getRightParenthesisKeyword_3());
		}
		public static IGrammarAwareElementType createXCatchClause_ExpressionAssignment_4ElementType() {
			return new IGrammarAwareElementType("XCatchClause_ExpressionAssignment_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCatchClauseAccess().getExpressionAssignment_4());
		}
		public static IGrammarAwareElementType createXCatchClause_ExpressionXExpressionParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("XCatchClause_ExpressionXExpressionParserRuleCall_4_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0());
		}
	}

	public static final IGrammarAwareElementType XCatchClause_ELEMENT_TYPE = associate(XCatchClauseFactory.createXCatchClauseElementType());

	public static final IGrammarAwareElementType XCatchClause_Group_ELEMENT_TYPE = associate(XCatchClauseFactory.createXCatchClause_GroupElementType());

	public static final IGrammarAwareElementType XCatchClause_CatchKeyword_0_ELEMENT_TYPE = associate(XCatchClauseFactory.createXCatchClause_CatchKeyword_0ElementType());

	public static final IGrammarAwareElementType XCatchClause_LeftParenthesisKeyword_1_ELEMENT_TYPE = associate(XCatchClauseFactory.createXCatchClause_LeftParenthesisKeyword_1ElementType());

	public static final IGrammarAwareElementType XCatchClause_DeclaredParamAssignment_2_ELEMENT_TYPE = associate(XCatchClauseFactory.createXCatchClause_DeclaredParamAssignment_2ElementType());

	public static final IGrammarAwareElementType XCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0_ELEMENT_TYPE = associate(XCatchClauseFactory.createXCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType XCatchClause_RightParenthesisKeyword_3_ELEMENT_TYPE = associate(XCatchClauseFactory.createXCatchClause_RightParenthesisKeyword_3ElementType());

	public static final IGrammarAwareElementType XCatchClause_ExpressionAssignment_4_ELEMENT_TYPE = associate(XCatchClauseFactory.createXCatchClause_ExpressionAssignment_4ElementType());

	public static final IGrammarAwareElementType XCatchClause_ExpressionXExpressionParserRuleCall_4_0_ELEMENT_TYPE = associate(XCatchClauseFactory.createXCatchClause_ExpressionXExpressionParserRuleCall_4_0ElementType());

	private static class QualifiedNameFactory {
		public static IGrammarAwareElementType createQualifiedNameElementType() {
			return new IGrammarAwareElementType("QualifiedName_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameRule());
		}
		public static IGrammarAwareElementType createQualifiedName_GroupElementType() {
			return new IGrammarAwareElementType("QualifiedName_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getGroup());
		}
		public static IGrammarAwareElementType createQualifiedName_ValidIDParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("QualifiedName_ValidIDParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getValidIDParserRuleCall_0());
		}
		public static IGrammarAwareElementType createQualifiedName_Group_1ElementType() {
			return new IGrammarAwareElementType("QualifiedName_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createQualifiedName_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createQualifiedName_ValidIDParserRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("QualifiedName_ValidIDParserRuleCall_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType QualifiedName_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedNameElementType());

	public static final IGrammarAwareElementType QualifiedName_Group_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_GroupElementType());

	public static final IGrammarAwareElementType QualifiedName_ValidIDParserRuleCall_0_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_ValidIDParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType QualifiedName_Group_1_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_Group_1ElementType());

	public static final IGrammarAwareElementType QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType QualifiedName_ValidIDParserRuleCall_1_1_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_ValidIDParserRuleCall_1_1ElementType());

	private static class NumberFactory {
		public static IGrammarAwareElementType createNumberElementType() {
			return new IGrammarAwareElementType("Number_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberRule());
		}
		public static IGrammarAwareElementType createNumber_AlternativesElementType() {
			return new IGrammarAwareElementType("Number_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createNumber_HEXTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Number_HEXTerminalRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getHEXTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createNumber_Group_1ElementType() {
			return new IGrammarAwareElementType("Number_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createNumber_Alternatives_1_0ElementType() {
			return new IGrammarAwareElementType("Number_Alternatives_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getAlternatives_1_0());
		}
		public static IGrammarAwareElementType createNumber_INTTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("Number_INTTerminalRuleCall_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getINTTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createNumber_DECIMALTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("Number_DECIMALTerminalRuleCall_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createNumber_Group_1_1ElementType() {
			return new IGrammarAwareElementType("Number_Group_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createNumber_FullStopKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("Number_FullStopKeyword_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getFullStopKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createNumber_Alternatives_1_1_1ElementType() {
			return new IGrammarAwareElementType("Number_Alternatives_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getAlternatives_1_1_1());
		}
		public static IGrammarAwareElementType createNumber_INTTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Number_INTTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getINTTerminalRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createNumber_DECIMALTerminalRuleCall_1_1_1_1ElementType() {
			return new IGrammarAwareElementType("Number_DECIMALTerminalRuleCall_1_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1());
		}
	}

	public static final IGrammarAwareElementType Number_ELEMENT_TYPE = associate(NumberFactory.createNumberElementType());

	public static final IGrammarAwareElementType Number_Alternatives_ELEMENT_TYPE = associate(NumberFactory.createNumber_AlternativesElementType());

	public static final IGrammarAwareElementType Number_HEXTerminalRuleCall_0_ELEMENT_TYPE = associate(NumberFactory.createNumber_HEXTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType Number_Group_1_ELEMENT_TYPE = associate(NumberFactory.createNumber_Group_1ElementType());

	public static final IGrammarAwareElementType Number_Alternatives_1_0_ELEMENT_TYPE = associate(NumberFactory.createNumber_Alternatives_1_0ElementType());

	public static final IGrammarAwareElementType Number_INTTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(NumberFactory.createNumber_INTTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType Number_DECIMALTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(NumberFactory.createNumber_DECIMALTerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType Number_Group_1_1_ELEMENT_TYPE = associate(NumberFactory.createNumber_Group_1_1ElementType());

	public static final IGrammarAwareElementType Number_FullStopKeyword_1_1_0_ELEMENT_TYPE = associate(NumberFactory.createNumber_FullStopKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType Number_Alternatives_1_1_1_ELEMENT_TYPE = associate(NumberFactory.createNumber_Alternatives_1_1_1ElementType());

	public static final IGrammarAwareElementType Number_INTTerminalRuleCall_1_1_1_0_ELEMENT_TYPE = associate(NumberFactory.createNumber_INTTerminalRuleCall_1_1_1_0ElementType());

	public static final IGrammarAwareElementType Number_DECIMALTerminalRuleCall_1_1_1_1_ELEMENT_TYPE = associate(NumberFactory.createNumber_DECIMALTerminalRuleCall_1_1_1_1ElementType());

	private static class StaticQualifierFactory {
		public static IGrammarAwareElementType createStaticQualifierElementType() {
			return new IGrammarAwareElementType("StaticQualifier_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticQualifierRule());
		}
		public static IGrammarAwareElementType createStaticQualifier_GroupElementType() {
			return new IGrammarAwareElementType("StaticQualifier_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticQualifierAccess().getGroup());
		}
		public static IGrammarAwareElementType createStaticQualifier_ValidIDParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("StaticQualifier_ValidIDParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticQualifierAccess().getValidIDParserRuleCall_0());
		}
		public static IGrammarAwareElementType createStaticQualifier_ColonColonKeyword_1ElementType() {
			return new IGrammarAwareElementType("StaticQualifier_ColonColonKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getStaticQualifierAccess().getColonColonKeyword_1());
		}
	}

	public static final IGrammarAwareElementType StaticQualifier_ELEMENT_TYPE = associate(StaticQualifierFactory.createStaticQualifierElementType());

	public static final IGrammarAwareElementType StaticQualifier_Group_ELEMENT_TYPE = associate(StaticQualifierFactory.createStaticQualifier_GroupElementType());

	public static final IGrammarAwareElementType StaticQualifier_ValidIDParserRuleCall_0_ELEMENT_TYPE = associate(StaticQualifierFactory.createStaticQualifier_ValidIDParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType StaticQualifier_ColonColonKeyword_1_ELEMENT_TYPE = associate(StaticQualifierFactory.createStaticQualifier_ColonColonKeyword_1ElementType());

	private static class JvmTypeReferenceFactory {
		public static IGrammarAwareElementType createJvmTypeReferenceElementType() {
			return new IGrammarAwareElementType("JvmTypeReference_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeReferenceRule());
		}
		public static IGrammarAwareElementType createJvmTypeReference_AlternativesElementType() {
			return new IGrammarAwareElementType("JvmTypeReference_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeReferenceAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createJvmTypeReference_Group_0ElementType() {
			return new IGrammarAwareElementType("JvmTypeReference_Group_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeReferenceAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("JvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createJvmTypeReference_Group_0_1ElementType() {
			return new IGrammarAwareElementType("JvmTypeReference_Group_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeReferenceAccess().getGroup_0_1());
		}
		public static IGrammarAwareElementType createJvmTypeReference_Group_0_1_0ElementType() {
			return new IGrammarAwareElementType("JvmTypeReference_Group_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeReferenceAccess().getGroup_0_1_0());
		}
		public static IGrammarAwareElementType createJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType() {
			return new IGrammarAwareElementType("JvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0());
		}
		public static IGrammarAwareElementType createJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("JvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1());
		}
		public static IGrammarAwareElementType createJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("JvmTypeReference_XFunctionTypeRefParserRuleCall_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType JvmTypeReference_ELEMENT_TYPE = associate(JvmTypeReferenceFactory.createJvmTypeReferenceElementType());

	public static final IGrammarAwareElementType JvmTypeReference_Alternatives_ELEMENT_TYPE = associate(JvmTypeReferenceFactory.createJvmTypeReference_AlternativesElementType());

	public static final IGrammarAwareElementType JvmTypeReference_Group_0_ELEMENT_TYPE = associate(JvmTypeReferenceFactory.createJvmTypeReference_Group_0ElementType());

	public static final IGrammarAwareElementType JvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0_ELEMENT_TYPE = associate(JvmTypeReferenceFactory.createJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType JvmTypeReference_Group_0_1_ELEMENT_TYPE = associate(JvmTypeReferenceFactory.createJvmTypeReference_Group_0_1ElementType());

	public static final IGrammarAwareElementType JvmTypeReference_Group_0_1_0_ELEMENT_TYPE = associate(JvmTypeReferenceFactory.createJvmTypeReference_Group_0_1_0ElementType());

	public static final IGrammarAwareElementType JvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0_ELEMENT_TYPE = associate(JvmTypeReferenceFactory.createJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType());

	public static final IGrammarAwareElementType JvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1_ELEMENT_TYPE = associate(JvmTypeReferenceFactory.createJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType());

	public static final IGrammarAwareElementType JvmTypeReference_XFunctionTypeRefParserRuleCall_1_ELEMENT_TYPE = associate(JvmTypeReferenceFactory.createJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType());

	private static class ArrayBracketsFactory {
		public static IGrammarAwareElementType createArrayBracketsElementType() {
			return new IGrammarAwareElementType("ArrayBrackets_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getArrayBracketsRule());
		}
		public static IGrammarAwareElementType createArrayBrackets_GroupElementType() {
			return new IGrammarAwareElementType("ArrayBrackets_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getArrayBracketsAccess().getGroup());
		}
		public static IGrammarAwareElementType createArrayBrackets_LeftSquareBracketKeyword_0ElementType() {
			return new IGrammarAwareElementType("ArrayBrackets_LeftSquareBracketKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getArrayBracketsAccess().getLeftSquareBracketKeyword_0());
		}
		public static IGrammarAwareElementType createArrayBrackets_RightSquareBracketKeyword_1ElementType() {
			return new IGrammarAwareElementType("ArrayBrackets_RightSquareBracketKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getArrayBracketsAccess().getRightSquareBracketKeyword_1());
		}
	}

	public static final IGrammarAwareElementType ArrayBrackets_ELEMENT_TYPE = associate(ArrayBracketsFactory.createArrayBracketsElementType());

	public static final IGrammarAwareElementType ArrayBrackets_Group_ELEMENT_TYPE = associate(ArrayBracketsFactory.createArrayBrackets_GroupElementType());

	public static final IGrammarAwareElementType ArrayBrackets_LeftSquareBracketKeyword_0_ELEMENT_TYPE = associate(ArrayBracketsFactory.createArrayBrackets_LeftSquareBracketKeyword_0ElementType());

	public static final IGrammarAwareElementType ArrayBrackets_RightSquareBracketKeyword_1_ELEMENT_TYPE = associate(ArrayBracketsFactory.createArrayBrackets_RightSquareBracketKeyword_1ElementType());

	private static class XFunctionTypeRefFactory {
		public static IGrammarAwareElementType createXFunctionTypeRefElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefRule());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_GroupElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getGroup());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_Group_0ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_Group_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_LeftParenthesisKeyword_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_Group_0_1ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_Group_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getGroup_0_1());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_ParamTypesAssignment_0_1_0ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_ParamTypesAssignment_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_Group_0_1_1ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_Group_0_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getGroup_0_1_1());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_CommaKeyword_0_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_ParamTypesAssignment_0_1_1_1ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_ParamTypesAssignment_0_1_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_RightParenthesisKeyword_0_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_ReturnTypeAssignment_2ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_ReturnTypeAssignment_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getReturnTypeAssignment_2());
		}
		public static IGrammarAwareElementType createXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("XFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType XFunctionTypeRef_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRefElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_Group_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_GroupElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_Group_0_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_Group_0ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_LeftParenthesisKeyword_0_0_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_Group_0_1_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_Group_0_1ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_ParamTypesAssignment_0_1_0_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_ParamTypesAssignment_0_1_0ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_Group_0_1_1_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_Group_0_1_1ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_CommaKeyword_0_1_1_0_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_ParamTypesAssignment_0_1_1_1_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_ParamTypesAssignment_0_1_1_1ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_RightParenthesisKeyword_0_2_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_ReturnTypeAssignment_2_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_ReturnTypeAssignment_2ElementType());

	public static final IGrammarAwareElementType XFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0_ELEMENT_TYPE = associate(XFunctionTypeRefFactory.createXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType());

	private static class JvmParameterizedTypeReferenceFactory {
		public static IGrammarAwareElementType createJvmParameterizedTypeReferenceElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceRule());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_GroupElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getGroup());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_TypeAssignment_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_TypeAssignment_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_TypeJvmTypeQualifiedNameParserRuleCall_0_0_1ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_TypeJvmTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_Group_1ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_LessThanSignKeyword_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_ArgumentsAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_ArgumentsAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_Group_1_2ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_Group_1_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getGroup_1_2());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_CommaKeyword_1_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_ArgumentsAssignment_1_2_1ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_ArgumentsAssignment_1_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_GreaterThanSignKeyword_1_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_Group_1_4ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_Group_1_4_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getGroup_1_4());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_Group_1_4_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_Group_1_4_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_Group_1_4_0_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_Group_1_4_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_TypeAssignment_1_4_1ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_TypeAssignment_1_4_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_TypeJvmTypeValidIDParserRuleCall_1_4_1_0_1ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_TypeJvmTypeValidIDParserRuleCall_1_4_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_Group_1_4_2ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_Group_1_4_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_1ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_1());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_Group_1_4_2_2ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_Group_1_4_2_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2_2());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_2_1ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_2_1());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0());
		}
		public static IGrammarAwareElementType createJvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3ElementType() {
			return new IGrammarAwareElementType("JvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3());
		}
	}

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReferenceElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_Group_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_GroupElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_TypeAssignment_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_TypeAssignment_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_TypeJvmTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_TypeJvmTypeQualifiedNameParserRuleCall_0_0_1ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_Group_1_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_Group_1ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_LessThanSignKeyword_1_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_ArgumentsAssignment_1_1_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_ArgumentsAssignment_1_1ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_Group_1_2_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_Group_1_2ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_CommaKeyword_1_2_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_ArgumentsAssignment_1_2_1_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_ArgumentsAssignment_1_2_1ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_GreaterThanSignKeyword_1_3_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_Group_1_4_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_Group_1_4ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_Group_1_4_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_Group_1_4_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_Group_1_4_0_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_Group_1_4_0_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_TypeAssignment_1_4_1_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_TypeAssignment_1_4_1ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_TypeJvmTypeValidIDParserRuleCall_1_4_1_0_1_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_TypeJvmTypeValidIDParserRuleCall_1_4_1_0_1ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_Group_1_4_2_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_Group_1_4_2ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_1_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_1ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_Group_1_4_2_2_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_Group_1_4_2_2ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_2_1_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_2_1ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType());

	public static final IGrammarAwareElementType JvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3_ELEMENT_TYPE = associate(JvmParameterizedTypeReferenceFactory.createJvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3ElementType());

	private static class JvmArgumentTypeReferenceFactory {
		public static IGrammarAwareElementType createJvmArgumentTypeReferenceElementType() {
			return new IGrammarAwareElementType("JvmArgumentTypeReference_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmArgumentTypeReferenceRule());
		}
		public static IGrammarAwareElementType createJvmArgumentTypeReference_AlternativesElementType() {
			return new IGrammarAwareElementType("JvmArgumentTypeReference_Alternatives_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmArgumentTypeReferenceAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("JvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0());
		}
		public static IGrammarAwareElementType createJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("JvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType JvmArgumentTypeReference_ELEMENT_TYPE = associate(JvmArgumentTypeReferenceFactory.createJvmArgumentTypeReferenceElementType());

	public static final IGrammarAwareElementType JvmArgumentTypeReference_Alternatives_ELEMENT_TYPE = associate(JvmArgumentTypeReferenceFactory.createJvmArgumentTypeReference_AlternativesElementType());

	public static final IGrammarAwareElementType JvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0_ELEMENT_TYPE = associate(JvmArgumentTypeReferenceFactory.createJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType JvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1_ELEMENT_TYPE = associate(JvmArgumentTypeReferenceFactory.createJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType());

	private static class JvmWildcardTypeReferenceFactory {
		public static IGrammarAwareElementType createJvmWildcardTypeReferenceElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceRule());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_GroupElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getGroup());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_QuestionMarkKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_Alternatives_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_Group_2_0ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_Group_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getGroup_2_0());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_ConstraintsAssignment_2_0_0ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_ConstraintsAssignment_2_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_0());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_ConstraintsAssignment_2_0_1ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_ConstraintsAssignment_2_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_1());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_Group_2_1ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_Group_2_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getGroup_2_1());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_ConstraintsAssignment_2_1_0ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_ConstraintsAssignment_2_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_0());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_ConstraintsAssignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_ConstraintsAssignment_2_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_1());
		}
		public static IGrammarAwareElementType createJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("JvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0());
		}
	}

	public static final IGrammarAwareElementType JvmWildcardTypeReference_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReferenceElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_Group_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_GroupElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_QuestionMarkKeyword_1_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_Alternatives_2_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_Alternatives_2ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_Group_2_0_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_Group_2_0ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_ConstraintsAssignment_2_0_0_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_ConstraintsAssignment_2_0_0ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_ConstraintsAssignment_2_0_1_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_ConstraintsAssignment_2_0_1ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_Group_2_1_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_Group_2_1ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_ConstraintsAssignment_2_1_0_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_ConstraintsAssignment_2_1_0ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_ConstraintsAssignment_2_1_1_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_ConstraintsAssignment_2_1_1ElementType());

	public static final IGrammarAwareElementType JvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0_ELEMENT_TYPE = associate(JvmWildcardTypeReferenceFactory.createJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType());

	private static class JvmUpperBoundFactory {
		public static IGrammarAwareElementType createJvmUpperBoundElementType() {
			return new IGrammarAwareElementType("JvmUpperBound_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmUpperBoundRule());
		}
		public static IGrammarAwareElementType createJvmUpperBound_GroupElementType() {
			return new IGrammarAwareElementType("JvmUpperBound_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmUpperBoundAccess().getGroup());
		}
		public static IGrammarAwareElementType createJvmUpperBound_ExtendsKeyword_0ElementType() {
			return new IGrammarAwareElementType("JvmUpperBound_ExtendsKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmUpperBoundAccess().getExtendsKeyword_0());
		}
		public static IGrammarAwareElementType createJvmUpperBound_TypeReferenceAssignment_1ElementType() {
			return new IGrammarAwareElementType("JvmUpperBound_TypeReferenceAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmUpperBoundAccess().getTypeReferenceAssignment_1());
		}
		public static IGrammarAwareElementType createJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("JvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType JvmUpperBound_ELEMENT_TYPE = associate(JvmUpperBoundFactory.createJvmUpperBoundElementType());

	public static final IGrammarAwareElementType JvmUpperBound_Group_ELEMENT_TYPE = associate(JvmUpperBoundFactory.createJvmUpperBound_GroupElementType());

	public static final IGrammarAwareElementType JvmUpperBound_ExtendsKeyword_0_ELEMENT_TYPE = associate(JvmUpperBoundFactory.createJvmUpperBound_ExtendsKeyword_0ElementType());

	public static final IGrammarAwareElementType JvmUpperBound_TypeReferenceAssignment_1_ELEMENT_TYPE = associate(JvmUpperBoundFactory.createJvmUpperBound_TypeReferenceAssignment_1ElementType());

	public static final IGrammarAwareElementType JvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE = associate(JvmUpperBoundFactory.createJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());

	private static class JvmUpperBoundAndedFactory {
		public static IGrammarAwareElementType createJvmUpperBoundAndedElementType() {
			return new IGrammarAwareElementType("JvmUpperBoundAnded_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmUpperBoundAndedRule());
		}
		public static IGrammarAwareElementType createJvmUpperBoundAnded_GroupElementType() {
			return new IGrammarAwareElementType("JvmUpperBoundAnded_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmUpperBoundAndedAccess().getGroup());
		}
		public static IGrammarAwareElementType createJvmUpperBoundAnded_AmpersandKeyword_0ElementType() {
			return new IGrammarAwareElementType("JvmUpperBoundAnded_AmpersandKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
		}
		public static IGrammarAwareElementType createJvmUpperBoundAnded_TypeReferenceAssignment_1ElementType() {
			return new IGrammarAwareElementType("JvmUpperBoundAnded_TypeReferenceAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1());
		}
		public static IGrammarAwareElementType createJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("JvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType JvmUpperBoundAnded_ELEMENT_TYPE = associate(JvmUpperBoundAndedFactory.createJvmUpperBoundAndedElementType());

	public static final IGrammarAwareElementType JvmUpperBoundAnded_Group_ELEMENT_TYPE = associate(JvmUpperBoundAndedFactory.createJvmUpperBoundAnded_GroupElementType());

	public static final IGrammarAwareElementType JvmUpperBoundAnded_AmpersandKeyword_0_ELEMENT_TYPE = associate(JvmUpperBoundAndedFactory.createJvmUpperBoundAnded_AmpersandKeyword_0ElementType());

	public static final IGrammarAwareElementType JvmUpperBoundAnded_TypeReferenceAssignment_1_ELEMENT_TYPE = associate(JvmUpperBoundAndedFactory.createJvmUpperBoundAnded_TypeReferenceAssignment_1ElementType());

	public static final IGrammarAwareElementType JvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE = associate(JvmUpperBoundAndedFactory.createJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());

	private static class JvmLowerBoundFactory {
		public static IGrammarAwareElementType createJvmLowerBoundElementType() {
			return new IGrammarAwareElementType("JvmLowerBound_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmLowerBoundRule());
		}
		public static IGrammarAwareElementType createJvmLowerBound_GroupElementType() {
			return new IGrammarAwareElementType("JvmLowerBound_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmLowerBoundAccess().getGroup());
		}
		public static IGrammarAwareElementType createJvmLowerBound_SuperKeyword_0ElementType() {
			return new IGrammarAwareElementType("JvmLowerBound_SuperKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmLowerBoundAccess().getSuperKeyword_0());
		}
		public static IGrammarAwareElementType createJvmLowerBound_TypeReferenceAssignment_1ElementType() {
			return new IGrammarAwareElementType("JvmLowerBound_TypeReferenceAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmLowerBoundAccess().getTypeReferenceAssignment_1());
		}
		public static IGrammarAwareElementType createJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("JvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType JvmLowerBound_ELEMENT_TYPE = associate(JvmLowerBoundFactory.createJvmLowerBoundElementType());

	public static final IGrammarAwareElementType JvmLowerBound_Group_ELEMENT_TYPE = associate(JvmLowerBoundFactory.createJvmLowerBound_GroupElementType());

	public static final IGrammarAwareElementType JvmLowerBound_SuperKeyword_0_ELEMENT_TYPE = associate(JvmLowerBoundFactory.createJvmLowerBound_SuperKeyword_0ElementType());

	public static final IGrammarAwareElementType JvmLowerBound_TypeReferenceAssignment_1_ELEMENT_TYPE = associate(JvmLowerBoundFactory.createJvmLowerBound_TypeReferenceAssignment_1ElementType());

	public static final IGrammarAwareElementType JvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE = associate(JvmLowerBoundFactory.createJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());

	private static class JvmLowerBoundAndedFactory {
		public static IGrammarAwareElementType createJvmLowerBoundAndedElementType() {
			return new IGrammarAwareElementType("JvmLowerBoundAnded_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmLowerBoundAndedRule());
		}
		public static IGrammarAwareElementType createJvmLowerBoundAnded_GroupElementType() {
			return new IGrammarAwareElementType("JvmLowerBoundAnded_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmLowerBoundAndedAccess().getGroup());
		}
		public static IGrammarAwareElementType createJvmLowerBoundAnded_AmpersandKeyword_0ElementType() {
			return new IGrammarAwareElementType("JvmLowerBoundAnded_AmpersandKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
		}
		public static IGrammarAwareElementType createJvmLowerBoundAnded_TypeReferenceAssignment_1ElementType() {
			return new IGrammarAwareElementType("JvmLowerBoundAnded_TypeReferenceAssignment_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmLowerBoundAndedAccess().getTypeReferenceAssignment_1());
		}
		public static IGrammarAwareElementType createJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("JvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType JvmLowerBoundAnded_ELEMENT_TYPE = associate(JvmLowerBoundAndedFactory.createJvmLowerBoundAndedElementType());

	public static final IGrammarAwareElementType JvmLowerBoundAnded_Group_ELEMENT_TYPE = associate(JvmLowerBoundAndedFactory.createJvmLowerBoundAnded_GroupElementType());

	public static final IGrammarAwareElementType JvmLowerBoundAnded_AmpersandKeyword_0_ELEMENT_TYPE = associate(JvmLowerBoundAndedFactory.createJvmLowerBoundAnded_AmpersandKeyword_0ElementType());

	public static final IGrammarAwareElementType JvmLowerBoundAnded_TypeReferenceAssignment_1_ELEMENT_TYPE = associate(JvmLowerBoundAndedFactory.createJvmLowerBoundAnded_TypeReferenceAssignment_1ElementType());

	public static final IGrammarAwareElementType JvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE = associate(JvmLowerBoundAndedFactory.createJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());

	private static class JvmTypeParameterFactory {
		public static IGrammarAwareElementType createJvmTypeParameterElementType() {
			return new IGrammarAwareElementType("JvmTypeParameter_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeParameterRule());
		}
		public static IGrammarAwareElementType createJvmTypeParameter_GroupElementType() {
			return new IGrammarAwareElementType("JvmTypeParameter_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeParameterAccess().getGroup());
		}
		public static IGrammarAwareElementType createJvmTypeParameter_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("JvmTypeParameter_NameAssignment_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeParameterAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("JvmTypeParameter_NameValidIDParserRuleCall_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeParameterAccess().getNameValidIDParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createJvmTypeParameter_Group_1ElementType() {
			return new IGrammarAwareElementType("JvmTypeParameter_Group_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeParameterAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createJvmTypeParameter_ConstraintsAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("JvmTypeParameter_ConstraintsAssignment_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeParameterAccess().getConstraintsAssignment_1_0());
		}
		public static IGrammarAwareElementType createJvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("JvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundParserRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createJvmTypeParameter_ConstraintsAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("JvmTypeParameter_ConstraintsAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeParameterAccess().getConstraintsAssignment_1_1());
		}
		public static IGrammarAwareElementType createJvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("JvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType JvmTypeParameter_ELEMENT_TYPE = associate(JvmTypeParameterFactory.createJvmTypeParameterElementType());

	public static final IGrammarAwareElementType JvmTypeParameter_Group_ELEMENT_TYPE = associate(JvmTypeParameterFactory.createJvmTypeParameter_GroupElementType());

	public static final IGrammarAwareElementType JvmTypeParameter_NameAssignment_0_ELEMENT_TYPE = associate(JvmTypeParameterFactory.createJvmTypeParameter_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType JvmTypeParameter_NameValidIDParserRuleCall_0_0_ELEMENT_TYPE = associate(JvmTypeParameterFactory.createJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType JvmTypeParameter_Group_1_ELEMENT_TYPE = associate(JvmTypeParameterFactory.createJvmTypeParameter_Group_1ElementType());

	public static final IGrammarAwareElementType JvmTypeParameter_ConstraintsAssignment_1_0_ELEMENT_TYPE = associate(JvmTypeParameterFactory.createJvmTypeParameter_ConstraintsAssignment_1_0ElementType());

	public static final IGrammarAwareElementType JvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0_ELEMENT_TYPE = associate(JvmTypeParameterFactory.createJvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType JvmTypeParameter_ConstraintsAssignment_1_1_ELEMENT_TYPE = associate(JvmTypeParameterFactory.createJvmTypeParameter_ConstraintsAssignment_1_1ElementType());

	public static final IGrammarAwareElementType JvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0_ELEMENT_TYPE = associate(JvmTypeParameterFactory.createJvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0ElementType());

	private static class QualifiedNameWithWildcardFactory {
		public static IGrammarAwareElementType createQualifiedNameWithWildcardElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithWildcard_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithWildcardRule());
		}
		public static IGrammarAwareElementType createQualifiedNameWithWildcard_GroupElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithWildcard_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithWildcardAccess().getGroup());
		}
		public static IGrammarAwareElementType createQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithWildcard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
		}
		public static IGrammarAwareElementType createQualifiedNameWithWildcard_FullStopKeyword_1ElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithWildcard_FullStopKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1());
		}
		public static IGrammarAwareElementType createQualifiedNameWithWildcard_AsteriskKeyword_2ElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithWildcard_AsteriskKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2());
		}
	}

	public static final IGrammarAwareElementType QualifiedNameWithWildcard_ELEMENT_TYPE = associate(QualifiedNameWithWildcardFactory.createQualifiedNameWithWildcardElementType());

	public static final IGrammarAwareElementType QualifiedNameWithWildcard_Group_ELEMENT_TYPE = associate(QualifiedNameWithWildcardFactory.createQualifiedNameWithWildcard_GroupElementType());

	public static final IGrammarAwareElementType QualifiedNameWithWildcard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE = associate(QualifiedNameWithWildcardFactory.createQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType QualifiedNameWithWildcard_FullStopKeyword_1_ELEMENT_TYPE = associate(QualifiedNameWithWildcardFactory.createQualifiedNameWithWildcard_FullStopKeyword_1ElementType());

	public static final IGrammarAwareElementType QualifiedNameWithWildcard_AsteriskKeyword_2_ELEMENT_TYPE = associate(QualifiedNameWithWildcardFactory.createQualifiedNameWithWildcard_AsteriskKeyword_2ElementType());

	private static class ValidIDFactory {
		public static IGrammarAwareElementType createValidIDElementType() {
			return new IGrammarAwareElementType("ValidID_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getValidIDRule());
		}
		public static IGrammarAwareElementType createValidID_IDTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("ValidID_IDTerminalRuleCall_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getValidIDAccess().getIDTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType ValidID_ELEMENT_TYPE = associate(ValidIDFactory.createValidIDElementType());

	public static final IGrammarAwareElementType ValidID_IDTerminalRuleCall_ELEMENT_TYPE = associate(ValidIDFactory.createValidID_IDTerminalRuleCallElementType());

	private static class XImportSectionFactory {
		public static IGrammarAwareElementType createXImportSectionElementType() {
			return new IGrammarAwareElementType("XImportSection_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportSectionRule());
		}
		public static IGrammarAwareElementType createXImportSection_ImportDeclarationsAssignmentElementType() {
			return new IGrammarAwareElementType("XImportSection_ImportDeclarationsAssignment_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportSectionAccess().getImportDeclarationsAssignment());
		}
		public static IGrammarAwareElementType createXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("XImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportSectionAccess().getImportDeclarationsXImportDeclarationParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType XImportSection_ELEMENT_TYPE = associate(XImportSectionFactory.createXImportSectionElementType());

	public static final IGrammarAwareElementType XImportSection_ImportDeclarationsAssignment_ELEMENT_TYPE = associate(XImportSectionFactory.createXImportSection_ImportDeclarationsAssignmentElementType());

	public static final IGrammarAwareElementType XImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0_ELEMENT_TYPE = associate(XImportSectionFactory.createXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType());

	private static class XImportDeclarationFactory {
		public static IGrammarAwareElementType createXImportDeclarationElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationRule());
		}
		public static IGrammarAwareElementType createXImportDeclaration_GroupElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getGroup());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ImportKeyword_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ImportKeyword_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getImportKeyword_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_Alternatives_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createXImportDeclaration_Group_1_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_Group_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_StaticAssignment_1_0_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_StaticAssignment_1_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getStaticAssignment_1_0_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_StaticStaticKeyword_1_0_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ExtensionAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ExtensionAssignment_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getExtensionAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ExtensionExtensionKeyword_1_0_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ImportedTypeAssignment_1_0_2ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ImportedTypeAssignment_1_0_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1());
		}
		public static IGrammarAwareElementType createXImportDeclaration_Alternatives_1_0_3ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_Alternatives_1_0_3_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getAlternatives_1_0_3());
		}
		public static IGrammarAwareElementType createXImportDeclaration_WildcardAssignment_1_0_3_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_WildcardAssignment_1_0_3_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getWildcardAssignment_1_0_3_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_MemberNameAssignment_1_0_3_1ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_MemberNameAssignment_1_0_3_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getMemberNameAssignment_1_0_3_1());
		}
		public static IGrammarAwareElementType createXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ImportedTypeAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ImportedTypeAssignment_1_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getImportedTypeAssignment_1_1());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ImportedNamespaceAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ImportedNamespaceAssignment_1_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getImportedNamespaceAssignment_1_2());
		}
		public static IGrammarAwareElementType createXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createXImportDeclaration_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("XImportDeclaration_SemicolonKeyword_2_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getXImportDeclarationAccess().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType XImportDeclaration_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclarationElementType());

	public static final IGrammarAwareElementType XImportDeclaration_Group_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_GroupElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ImportKeyword_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ImportKeyword_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_Alternatives_1_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_Alternatives_1ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_Group_1_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_Group_1_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_StaticAssignment_1_0_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_StaticAssignment_1_0_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_StaticStaticKeyword_1_0_0_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ExtensionAssignment_1_0_1_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ExtensionAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ExtensionExtensionKeyword_1_0_1_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ImportedTypeAssignment_1_0_2_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ImportedTypeAssignment_1_0_2ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_Alternatives_1_0_3_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_Alternatives_1_0_3ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_WildcardAssignment_1_0_3_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_WildcardAssignment_1_0_3_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_MemberNameAssignment_1_0_3_1_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_MemberNameAssignment_1_0_3_1ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ImportedTypeAssignment_1_1_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ImportedTypeAssignment_1_1ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ImportedNamespaceAssignment_1_2_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ImportedNamespaceAssignment_1_2ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType XImportDeclaration_SemicolonKeyword_2_ELEMENT_TYPE = associate(XImportDeclarationFactory.createXImportDeclaration_SemicolonKeyword_2ElementType());

	private static class QualifiedNameInStaticImportFactory {
		public static IGrammarAwareElementType createQualifiedNameInStaticImportElementType() {
			return new IGrammarAwareElementType("QualifiedNameInStaticImport_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameInStaticImportRule());
		}
		public static IGrammarAwareElementType createQualifiedNameInStaticImport_GroupElementType() {
			return new IGrammarAwareElementType("QualifiedNameInStaticImport_Group_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameInStaticImportAccess().getGroup());
		}
		public static IGrammarAwareElementType createQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("QualifiedNameInStaticImport_ValidIDParserRuleCall_0_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0());
		}
		public static IGrammarAwareElementType createQualifiedNameInStaticImport_FullStopKeyword_1ElementType() {
			return new IGrammarAwareElementType("QualifiedNameInStaticImport_FullStopKeyword_1_ELEMENT_TYPE", EntitiesLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1());
		}
	}

	public static final IGrammarAwareElementType QualifiedNameInStaticImport_ELEMENT_TYPE = associate(QualifiedNameInStaticImportFactory.createQualifiedNameInStaticImportElementType());

	public static final IGrammarAwareElementType QualifiedNameInStaticImport_Group_ELEMENT_TYPE = associate(QualifiedNameInStaticImportFactory.createQualifiedNameInStaticImport_GroupElementType());

	public static final IGrammarAwareElementType QualifiedNameInStaticImport_ValidIDParserRuleCall_0_ELEMENT_TYPE = associate(QualifiedNameInStaticImportFactory.createQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType QualifiedNameInStaticImport_FullStopKeyword_1_ELEMENT_TYPE = associate(QualifiedNameInStaticImportFactory.createQualifiedNameInStaticImport_FullStopKeyword_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}
	
	public IGrammarAwareElementType getEntitiesElementType() {
		return Entities_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntities_GroupElementType() {
		return Entities_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntities_ImportSectionAssignment_0ElementType() {
		return Entities_ImportSectionAssignment_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntities_ImportSectionXImportSectionParserRuleCall_0_0ElementType() {
		return Entities_ImportSectionXImportSectionParserRuleCall_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntities_ElementsAssignment_1ElementType() {
		return Entities_ElementsAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntities_ElementsAbstractElementParserRuleCall_1_0ElementType() {
		return Entities_ElementsAbstractElementParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getAbstractElementElementType() {
		return AbstractElement_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getAbstractElement_AlternativesElementType() {
		return AbstractElement_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getAbstractElement_PackageDeclarationParserRuleCall_0ElementType() {
		return AbstractElement_PackageDeclarationParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getAbstractElement_EntityParserRuleCall_1ElementType() {
		return AbstractElement_EntityParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPackageDeclarationElementType() {
		return PackageDeclaration_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPackageDeclaration_GroupElementType() {
		return PackageDeclaration_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPackageDeclaration_PackageKeyword_0ElementType() {
		return PackageDeclaration_PackageKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPackageDeclaration_NameAssignment_1ElementType() {
		return PackageDeclaration_NameAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPackageDeclaration_NameQualifiedNameParserRuleCall_1_0ElementType() {
		return PackageDeclaration_NameQualifiedNameParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPackageDeclaration_LeftCurlyBracketKeyword_2ElementType() {
		return PackageDeclaration_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPackageDeclaration_ElementsAssignment_3ElementType() {
		return PackageDeclaration_ElementsAssignment_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPackageDeclaration_ElementsAbstractElementParserRuleCall_3_0ElementType() {
		return PackageDeclaration_ElementsAbstractElementParserRuleCall_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPackageDeclaration_RightCurlyBracketKeyword_4ElementType() {
		return PackageDeclaration_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntityElementType() {
		return Entity_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_GroupElementType() {
		return Entity_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_EntityKeyword_0ElementType() {
		return Entity_EntityKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_NameAssignment_1ElementType() {
		return Entity_NameAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_NameValidIDParserRuleCall_1_0ElementType() {
		return Entity_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_Group_2ElementType() {
		return Entity_Group_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_ExtendsKeyword_2_0ElementType() {
		return Entity_ExtendsKeyword_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_SuperTypeAssignment_2_1ElementType() {
		return Entity_SuperTypeAssignment_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_SuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0ElementType() {
		return Entity_SuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_LeftCurlyBracketKeyword_3ElementType() {
		return Entity_LeftCurlyBracketKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_FeaturesAssignment_4ElementType() {
		return Entity_FeaturesAssignment_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_FeaturesFeatureParserRuleCall_4_0ElementType() {
		return Entity_FeaturesFeatureParserRuleCall_4_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_RightCurlyBracketKeyword_5ElementType() {
		return Entity_RightCurlyBracketKeyword_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeatureElementType() {
		return Feature_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeature_AlternativesElementType() {
		return Feature_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeature_PropertyParserRuleCall_0ElementType() {
		return Feature_PropertyParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeature_OperationParserRuleCall_1ElementType() {
		return Feature_OperationParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPropertyElementType() {
		return Property_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_GroupElementType() {
		return Property_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_NameAssignment_0ElementType() {
		return Property_NameAssignment_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_NameValidIDParserRuleCall_0_0ElementType() {
		return Property_NameValidIDParserRuleCall_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_ColonKeyword_1ElementType() {
		return Property_ColonKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_TypeAssignment_2ElementType() {
		return Property_TypeAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_TypeJvmTypeReferenceParserRuleCall_2_0ElementType() {
		return Property_TypeJvmTypeReferenceParserRuleCall_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperationElementType() {
		return Operation_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_GroupElementType() {
		return Operation_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_OpKeyword_0ElementType() {
		return Operation_OpKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_NameAssignment_1ElementType() {
		return Operation_NameAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_NameValidIDParserRuleCall_1_0ElementType() {
		return Operation_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_LeftParenthesisKeyword_2ElementType() {
		return Operation_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_Group_3ElementType() {
		return Operation_Group_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_ParamsAssignment_3_0ElementType() {
		return Operation_ParamsAssignment_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_ParamsFullJvmFormalParameterParserRuleCall_3_0_0ElementType() {
		return Operation_ParamsFullJvmFormalParameterParserRuleCall_3_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_Group_3_1ElementType() {
		return Operation_Group_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_CommaKeyword_3_1_0ElementType() {
		return Operation_CommaKeyword_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_ParamsAssignment_3_1_1ElementType() {
		return Operation_ParamsAssignment_3_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_ParamsFullJvmFormalParameterParserRuleCall_3_1_1_0ElementType() {
		return Operation_ParamsFullJvmFormalParameterParserRuleCall_3_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_RightParenthesisKeyword_4ElementType() {
		return Operation_RightParenthesisKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_Group_5ElementType() {
		return Operation_Group_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_ColonKeyword_5_0ElementType() {
		return Operation_ColonKeyword_5_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_TypeAssignment_5_1ElementType() {
		return Operation_TypeAssignment_5_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_TypeJvmTypeReferenceParserRuleCall_5_1_0ElementType() {
		return Operation_TypeJvmTypeReferenceParserRuleCall_5_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_BodyAssignment_6ElementType() {
		return Operation_BodyAssignment_6_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOperation_BodyXBlockExpressionParserRuleCall_6_0ElementType() {
		return Operation_BodyXBlockExpressionParserRuleCall_6_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionElementType() {
		return XExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpression_XAssignmentParserRuleCallElementType() {
		return XExpression_XAssignmentParserRuleCall_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignmentElementType() {
		return XAssignment_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_AlternativesElementType() {
		return XAssignment_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_Group_0ElementType() {
		return XAssignment_Group_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_XAssignmentAction_0_0ElementType() {
		return XAssignment_XAssignmentAction_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_FeatureAssignment_0_1ElementType() {
		return XAssignment_FeatureAssignment_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType() {
		return XAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1ElementType() {
		return XAssignment_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_OpSingleAssignParserRuleCall_0_2ElementType() {
		return XAssignment_OpSingleAssignParserRuleCall_0_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_ValueAssignment_0_3ElementType() {
		return XAssignment_ValueAssignment_0_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_ValueXAssignmentParserRuleCall_0_3_0ElementType() {
		return XAssignment_ValueXAssignmentParserRuleCall_0_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_Group_1ElementType() {
		return XAssignment_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_XOrExpressionParserRuleCall_1_0ElementType() {
		return XAssignment_XOrExpressionParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_Group_1_1ElementType() {
		return XAssignment_Group_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_Group_1_1_0ElementType() {
		return XAssignment_Group_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_Group_1_1_0_0ElementType() {
		return XAssignment_Group_1_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType() {
		return XAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_FeatureAssignment_1_1_0_0_1ElementType() {
		return XAssignment_FeatureAssignment_1_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType() {
		return XAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_FeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1ElementType() {
		return XAssignment_FeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_RightOperandAssignment_1_1_1ElementType() {
		return XAssignment_RightOperandAssignment_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0ElementType() {
		return XAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpSingleAssignElementType() {
		return OpSingleAssign_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpSingleAssign_EqualsSignKeywordElementType() {
		return OpSingleAssign_EqualsSignKeyword_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssignElementType() {
		return OpMultiAssign_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_AlternativesElementType() {
		return OpMultiAssign_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_PlusSignEqualsSignKeyword_0ElementType() {
		return OpMultiAssign_PlusSignEqualsSignKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_HyphenMinusEqualsSignKeyword_1ElementType() {
		return OpMultiAssign_HyphenMinusEqualsSignKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_AsteriskEqualsSignKeyword_2ElementType() {
		return OpMultiAssign_AsteriskEqualsSignKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_SolidusEqualsSignKeyword_3ElementType() {
		return OpMultiAssign_SolidusEqualsSignKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_PercentSignEqualsSignKeyword_4ElementType() {
		return OpMultiAssign_PercentSignEqualsSignKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_Group_5ElementType() {
		return OpMultiAssign_Group_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_LessThanSignKeyword_5_0ElementType() {
		return OpMultiAssign_LessThanSignKeyword_5_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_LessThanSignKeyword_5_1ElementType() {
		return OpMultiAssign_LessThanSignKeyword_5_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_EqualsSignKeyword_5_2ElementType() {
		return OpMultiAssign_EqualsSignKeyword_5_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_Group_6ElementType() {
		return OpMultiAssign_Group_6_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_GreaterThanSignKeyword_6_0ElementType() {
		return OpMultiAssign_GreaterThanSignKeyword_6_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_GreaterThanSignKeyword_6_1ElementType() {
		return OpMultiAssign_GreaterThanSignKeyword_6_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2ElementType() {
		return OpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpressionElementType() {
		return XOrExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_GroupElementType() {
		return XOrExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_XAndExpressionParserRuleCall_0ElementType() {
		return XOrExpression_XAndExpressionParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_Group_1ElementType() {
		return XOrExpression_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_Group_1_0ElementType() {
		return XOrExpression_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_Group_1_0_0ElementType() {
		return XOrExpression_Group_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
		return XOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_FeatureAssignment_1_0_0_1ElementType() {
		return XOrExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
		return XOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_FeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1ElementType() {
		return XOrExpression_FeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_RightOperandAssignment_1_1ElementType() {
		return XOrExpression_RightOperandAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0ElementType() {
		return XOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOrElementType() {
		return OpOr_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOr_VerticalLineVerticalLineKeywordElementType() {
		return OpOr_VerticalLineVerticalLineKeyword_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpressionElementType() {
		return XAndExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_GroupElementType() {
		return XAndExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_XEqualityExpressionParserRuleCall_0ElementType() {
		return XAndExpression_XEqualityExpressionParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_Group_1ElementType() {
		return XAndExpression_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_Group_1_0ElementType() {
		return XAndExpression_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_Group_1_0_0ElementType() {
		return XAndExpression_Group_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
		return XAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_FeatureAssignment_1_0_0_1ElementType() {
		return XAndExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
		return XAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_FeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1ElementType() {
		return XAndExpression_FeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_RightOperandAssignment_1_1ElementType() {
		return XAndExpression_RightOperandAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0ElementType() {
		return XAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpAndElementType() {
		return OpAnd_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpAnd_AmpersandAmpersandKeywordElementType() {
		return OpAnd_AmpersandAmpersandKeyword_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpressionElementType() {
		return XEqualityExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_GroupElementType() {
		return XEqualityExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_XRelationalExpressionParserRuleCall_0ElementType() {
		return XEqualityExpression_XRelationalExpressionParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_Group_1ElementType() {
		return XEqualityExpression_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_Group_1_0ElementType() {
		return XEqualityExpression_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_Group_1_0_0ElementType() {
		return XEqualityExpression_Group_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
		return XEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_FeatureAssignment_1_0_0_1ElementType() {
		return XEqualityExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
		return XEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_FeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1ElementType() {
		return XEqualityExpression_FeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_RightOperandAssignment_1_1ElementType() {
		return XEqualityExpression_RightOperandAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0ElementType() {
		return XEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpEqualityElementType() {
		return OpEquality_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpEquality_AlternativesElementType() {
		return OpEquality_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpEquality_EqualsSignEqualsSignKeyword_0ElementType() {
		return OpEquality_EqualsSignEqualsSignKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpEquality_ExclamationMarkEqualsSignKeyword_1ElementType() {
		return OpEquality_ExclamationMarkEqualsSignKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpEquality_EqualsSignEqualsSignEqualsSignKeyword_2ElementType() {
		return OpEquality_EqualsSignEqualsSignEqualsSignKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3ElementType() {
		return OpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpressionElementType() {
		return XRelationalExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_GroupElementType() {
		return XRelationalExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_XOtherOperatorExpressionParserRuleCall_0ElementType() {
		return XRelationalExpression_XOtherOperatorExpressionParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_Alternatives_1ElementType() {
		return XRelationalExpression_Alternatives_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_Group_1_0ElementType() {
		return XRelationalExpression_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_Group_1_0_0ElementType() {
		return XRelationalExpression_Group_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_Group_1_0_0_0ElementType() {
		return XRelationalExpression_Group_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0ElementType() {
		return XRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_InstanceofKeyword_1_0_0_0_1ElementType() {
		return XRelationalExpression_InstanceofKeyword_1_0_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_TypeAssignment_1_0_1ElementType() {
		return XRelationalExpression_TypeAssignment_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0ElementType() {
		return XRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_Group_1_1ElementType() {
		return XRelationalExpression_Group_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_Group_1_1_0ElementType() {
		return XRelationalExpression_Group_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_Group_1_1_0_0ElementType() {
		return XRelationalExpression_Group_1_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType() {
		return XRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_FeatureAssignment_1_1_0_0_1ElementType() {
		return XRelationalExpression_FeatureAssignment_1_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType() {
		return XRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_FeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1ElementType() {
		return XRelationalExpression_FeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_RightOperandAssignment_1_1_1ElementType() {
		return XRelationalExpression_RightOperandAssignment_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0ElementType() {
		return XRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpCompareElementType() {
		return OpCompare_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpCompare_AlternativesElementType() {
		return OpCompare_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpCompare_GreaterThanSignEqualsSignKeyword_0ElementType() {
		return OpCompare_GreaterThanSignEqualsSignKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpCompare_Group_1ElementType() {
		return OpCompare_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpCompare_LessThanSignKeyword_1_0ElementType() {
		return OpCompare_LessThanSignKeyword_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpCompare_EqualsSignKeyword_1_1ElementType() {
		return OpCompare_EqualsSignKeyword_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpCompare_GreaterThanSignKeyword_2ElementType() {
		return OpCompare_GreaterThanSignKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpCompare_LessThanSignKeyword_3ElementType() {
		return OpCompare_LessThanSignKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpressionElementType() {
		return XOtherOperatorExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_GroupElementType() {
		return XOtherOperatorExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0ElementType() {
		return XOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_Group_1ElementType() {
		return XOtherOperatorExpression_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_Group_1_0ElementType() {
		return XOtherOperatorExpression_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_Group_1_0_0ElementType() {
		return XOtherOperatorExpression_Group_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
		return XOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_FeatureAssignment_1_0_0_1ElementType() {
		return XOtherOperatorExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
		return XOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_FeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1ElementType() {
		return XOtherOperatorExpression_FeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_RightOperandAssignment_1_1ElementType() {
		return XOtherOperatorExpression_RightOperandAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0ElementType() {
		return XOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOtherElementType() {
		return OpOther_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_AlternativesElementType() {
		return OpOther_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_HyphenMinusGreaterThanSignKeyword_0ElementType() {
		return OpOther_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_FullStopFullStopLessThanSignKeyword_1ElementType() {
		return OpOther_FullStopFullStopLessThanSignKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_Group_2ElementType() {
		return OpOther_Group_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_GreaterThanSignKeyword_2_0ElementType() {
		return OpOther_GreaterThanSignKeyword_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_FullStopFullStopKeyword_2_1ElementType() {
		return OpOther_FullStopFullStopKeyword_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_FullStopFullStopKeyword_3ElementType() {
		return OpOther_FullStopFullStopKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_EqualsSignGreaterThanSignKeyword_4ElementType() {
		return OpOther_EqualsSignGreaterThanSignKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_Group_5ElementType() {
		return OpOther_Group_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_GreaterThanSignKeyword_5_0ElementType() {
		return OpOther_GreaterThanSignKeyword_5_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_Alternatives_5_1ElementType() {
		return OpOther_Alternatives_5_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_Group_5_1_0ElementType() {
		return OpOther_Group_5_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_Group_5_1_0_0ElementType() {
		return OpOther_Group_5_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_GreaterThanSignKeyword_5_1_0_0_0ElementType() {
		return OpOther_GreaterThanSignKeyword_5_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_GreaterThanSignKeyword_5_1_0_0_1ElementType() {
		return OpOther_GreaterThanSignKeyword_5_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_GreaterThanSignKeyword_5_1_1ElementType() {
		return OpOther_GreaterThanSignKeyword_5_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_Group_6ElementType() {
		return OpOther_Group_6_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_LessThanSignKeyword_6_0ElementType() {
		return OpOther_LessThanSignKeyword_6_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_Alternatives_6_1ElementType() {
		return OpOther_Alternatives_6_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_Group_6_1_0ElementType() {
		return OpOther_Group_6_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_Group_6_1_0_0ElementType() {
		return OpOther_Group_6_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_LessThanSignKeyword_6_1_0_0_0ElementType() {
		return OpOther_LessThanSignKeyword_6_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_LessThanSignKeyword_6_1_0_0_1ElementType() {
		return OpOther_LessThanSignKeyword_6_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_LessThanSignKeyword_6_1_1ElementType() {
		return OpOther_LessThanSignKeyword_6_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_EqualsSignGreaterThanSignKeyword_6_1_2ElementType() {
		return OpOther_EqualsSignGreaterThanSignKeyword_6_1_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_LessThanSignGreaterThanSignKeyword_7ElementType() {
		return OpOther_LessThanSignGreaterThanSignKeyword_7_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpOther_QuestionMarkColonKeyword_8ElementType() {
		return OpOther_QuestionMarkColonKeyword_8_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpressionElementType() {
		return XAdditiveExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_GroupElementType() {
		return XAdditiveExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0ElementType() {
		return XAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_Group_1ElementType() {
		return XAdditiveExpression_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_Group_1_0ElementType() {
		return XAdditiveExpression_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_Group_1_0_0ElementType() {
		return XAdditiveExpression_Group_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
		return XAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_FeatureAssignment_1_0_0_1ElementType() {
		return XAdditiveExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
		return XAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_FeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1ElementType() {
		return XAdditiveExpression_FeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_RightOperandAssignment_1_1ElementType() {
		return XAdditiveExpression_RightOperandAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0ElementType() {
		return XAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpAddElementType() {
		return OpAdd_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpAdd_AlternativesElementType() {
		return OpAdd_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpAdd_PlusSignKeyword_0ElementType() {
		return OpAdd_PlusSignKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpAdd_HyphenMinusKeyword_1ElementType() {
		return OpAdd_HyphenMinusKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpressionElementType() {
		return XMultiplicativeExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_GroupElementType() {
		return XMultiplicativeExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_XUnaryOperationParserRuleCall_0ElementType() {
		return XMultiplicativeExpression_XUnaryOperationParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_Group_1ElementType() {
		return XMultiplicativeExpression_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_Group_1_0ElementType() {
		return XMultiplicativeExpression_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_Group_1_0_0ElementType() {
		return XMultiplicativeExpression_Group_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType() {
		return XMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_FeatureAssignment_1_0_0_1ElementType() {
		return XMultiplicativeExpression_FeatureAssignment_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType() {
		return XMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_FeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1ElementType() {
		return XMultiplicativeExpression_FeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_RightOperandAssignment_1_1ElementType() {
		return XMultiplicativeExpression_RightOperandAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0ElementType() {
		return XMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMultiElementType() {
		return OpMulti_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMulti_AlternativesElementType() {
		return OpMulti_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMulti_AsteriskKeyword_0ElementType() {
		return OpMulti_AsteriskKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMulti_AsteriskAsteriskKeyword_1ElementType() {
		return OpMulti_AsteriskAsteriskKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMulti_SolidusKeyword_2ElementType() {
		return OpMulti_SolidusKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpMulti_PercentSignKeyword_3ElementType() {
		return OpMulti_PercentSignKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXUnaryOperationElementType() {
		return XUnaryOperation_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXUnaryOperation_AlternativesElementType() {
		return XUnaryOperation_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXUnaryOperation_Group_0ElementType() {
		return XUnaryOperation_Group_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXUnaryOperation_XUnaryOperationAction_0_0ElementType() {
		return XUnaryOperation_XUnaryOperationAction_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXUnaryOperation_FeatureAssignment_0_1ElementType() {
		return XUnaryOperation_FeatureAssignment_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType() {
		return XUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXUnaryOperation_FeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1ElementType() {
		return XUnaryOperation_FeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXUnaryOperation_OperandAssignment_0_2ElementType() {
		return XUnaryOperation_OperandAssignment_0_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0ElementType() {
		return XUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXUnaryOperation_XCastedExpressionParserRuleCall_1ElementType() {
		return XUnaryOperation_XCastedExpressionParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpUnaryElementType() {
		return OpUnary_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpUnary_AlternativesElementType() {
		return OpUnary_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpUnary_ExclamationMarkKeyword_0ElementType() {
		return OpUnary_ExclamationMarkKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpUnary_HyphenMinusKeyword_1ElementType() {
		return OpUnary_HyphenMinusKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpUnary_PlusSignKeyword_2ElementType() {
		return OpUnary_PlusSignKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCastedExpressionElementType() {
		return XCastedExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCastedExpression_GroupElementType() {
		return XCastedExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCastedExpression_XPostfixOperationParserRuleCall_0ElementType() {
		return XCastedExpression_XPostfixOperationParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCastedExpression_Group_1ElementType() {
		return XCastedExpression_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCastedExpression_Group_1_0ElementType() {
		return XCastedExpression_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCastedExpression_Group_1_0_0ElementType() {
		return XCastedExpression_Group_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCastedExpression_XCastedExpressionTargetAction_1_0_0_0ElementType() {
		return XCastedExpression_XCastedExpressionTargetAction_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCastedExpression_AsKeyword_1_0_0_1ElementType() {
		return XCastedExpression_AsKeyword_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCastedExpression_TypeAssignment_1_1ElementType() {
		return XCastedExpression_TypeAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0ElementType() {
		return XCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPostfixOperationElementType() {
		return XPostfixOperation_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPostfixOperation_GroupElementType() {
		return XPostfixOperation_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPostfixOperation_XMemberFeatureCallParserRuleCall_0ElementType() {
		return XPostfixOperation_XMemberFeatureCallParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPostfixOperation_Group_1ElementType() {
		return XPostfixOperation_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPostfixOperation_Group_1_0ElementType() {
		return XPostfixOperation_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPostfixOperation_XPostfixOperationOperandAction_1_0_0ElementType() {
		return XPostfixOperation_XPostfixOperationOperandAction_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPostfixOperation_FeatureAssignment_1_0_1ElementType() {
		return XPostfixOperation_FeatureAssignment_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0ElementType() {
		return XPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPostfixOperation_FeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1ElementType() {
		return XPostfixOperation_FeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpPostfixElementType() {
		return OpPostfix_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpPostfix_AlternativesElementType() {
		return OpPostfix_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpPostfix_PlusSignPlusSignKeyword_0ElementType() {
		return OpPostfix_PlusSignPlusSignKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getOpPostfix_HyphenMinusHyphenMinusKeyword_1ElementType() {
		return OpPostfix_HyphenMinusHyphenMinusKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCallElementType() {
		return XMemberFeatureCall_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_GroupElementType() {
		return XMemberFeatureCall_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_XPrimaryExpressionParserRuleCall_0ElementType() {
		return XMemberFeatureCall_XPrimaryExpressionParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Alternatives_1ElementType() {
		return XMemberFeatureCall_Alternatives_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_0ElementType() {
		return XMemberFeatureCall_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_0_0ElementType() {
		return XMemberFeatureCall_Group_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_0_0_0ElementType() {
		return XMemberFeatureCall_Group_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0ElementType() {
		return XMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Alternatives_1_0_0_0_1ElementType() {
		return XMemberFeatureCall_Alternatives_1_0_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0ElementType() {
		return XMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_ExplicitStaticAssignment_1_0_0_0_1_1ElementType() {
		return XMemberFeatureCall_ExplicitStaticAssignment_1_0_0_0_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0ElementType() {
		return XMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_FeatureAssignment_1_0_0_0_2ElementType() {
		return XMemberFeatureCall_FeatureAssignment_1_0_0_0_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0ElementType() {
		return XMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1ElementType() {
		return XMemberFeatureCall_FeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_OpSingleAssignParserRuleCall_1_0_0_0_3ElementType() {
		return XMemberFeatureCall_OpSingleAssignParserRuleCall_1_0_0_0_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_ValueAssignment_1_0_1ElementType() {
		return XMemberFeatureCall_ValueAssignment_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0ElementType() {
		return XMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_1ElementType() {
		return XMemberFeatureCall_Group_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_1_0ElementType() {
		return XMemberFeatureCall_Group_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_1_0_0ElementType() {
		return XMemberFeatureCall_Group_1_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0ElementType() {
		return XMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Alternatives_1_1_0_0_1ElementType() {
		return XMemberFeatureCall_Alternatives_1_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0ElementType() {
		return XMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_NullSafeAssignment_1_1_0_0_1_1ElementType() {
		return XMemberFeatureCall_NullSafeAssignment_1_1_0_0_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0ElementType() {
		return XMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_ExplicitStaticAssignment_1_1_0_0_1_2ElementType() {
		return XMemberFeatureCall_ExplicitStaticAssignment_1_1_0_0_1_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0ElementType() {
		return XMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_1_1ElementType() {
		return XMemberFeatureCall_Group_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_LessThanSignKeyword_1_1_1_0ElementType() {
		return XMemberFeatureCall_LessThanSignKeyword_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_TypeArgumentsAssignment_1_1_1_1ElementType() {
		return XMemberFeatureCall_TypeArgumentsAssignment_1_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0ElementType() {
		return XMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_1_1_2ElementType() {
		return XMemberFeatureCall_Group_1_1_1_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_CommaKeyword_1_1_1_2_0ElementType() {
		return XMemberFeatureCall_CommaKeyword_1_1_1_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_TypeArgumentsAssignment_1_1_1_2_1ElementType() {
		return XMemberFeatureCall_TypeArgumentsAssignment_1_1_1_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0ElementType() {
		return XMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_GreaterThanSignKeyword_1_1_1_3ElementType() {
		return XMemberFeatureCall_GreaterThanSignKeyword_1_1_1_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_FeatureAssignment_1_1_2ElementType() {
		return XMemberFeatureCall_FeatureAssignment_1_1_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0ElementType() {
		return XMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1ElementType() {
		return XMemberFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_1_3ElementType() {
		return XMemberFeatureCall_Group_1_1_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_ExplicitOperationCallAssignment_1_1_3_0ElementType() {
		return XMemberFeatureCall_ExplicitOperationCallAssignment_1_1_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0ElementType() {
		return XMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Alternatives_1_1_3_1ElementType() {
		return XMemberFeatureCall_Alternatives_1_1_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_0ElementType() {
		return XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0ElementType() {
		return XMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_1_3_1_1ElementType() {
		return XMemberFeatureCall_Group_1_1_3_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_0ElementType() {
		return XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0ElementType() {
		return XMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_Group_1_1_3_1_1_1ElementType() {
		return XMemberFeatureCall_Group_1_1_3_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0ElementType() {
		return XMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_1_1ElementType() {
		return XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_3_1_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0ElementType() {
		return XMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_RightParenthesisKeyword_1_1_3_2ElementType() {
		return XMemberFeatureCall_RightParenthesisKeyword_1_1_3_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_MemberCallArgumentsAssignment_1_1_4ElementType() {
		return XMemberFeatureCall_MemberCallArgumentsAssignment_1_1_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0ElementType() {
		return XMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpressionElementType() {
		return XPrimaryExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_AlternativesElementType() {
		return XPrimaryExpression_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XConstructorCallParserRuleCall_0ElementType() {
		return XPrimaryExpression_XConstructorCallParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XBlockExpressionParserRuleCall_1ElementType() {
		return XPrimaryExpression_XBlockExpressionParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XSwitchExpressionParserRuleCall_2ElementType() {
		return XPrimaryExpression_XSwitchExpressionParserRuleCall_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XSynchronizedExpressionParserRuleCall_3ElementType() {
		return XPrimaryExpression_XSynchronizedExpressionParserRuleCall_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XFeatureCallParserRuleCall_4ElementType() {
		return XPrimaryExpression_XFeatureCallParserRuleCall_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XLiteralParserRuleCall_5ElementType() {
		return XPrimaryExpression_XLiteralParserRuleCall_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XIfExpressionParserRuleCall_6ElementType() {
		return XPrimaryExpression_XIfExpressionParserRuleCall_6_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XForLoopExpressionParserRuleCall_7ElementType() {
		return XPrimaryExpression_XForLoopExpressionParserRuleCall_7_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8ElementType() {
		return XPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XWhileExpressionParserRuleCall_9ElementType() {
		return XPrimaryExpression_XWhileExpressionParserRuleCall_9_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XDoWhileExpressionParserRuleCall_10ElementType() {
		return XPrimaryExpression_XDoWhileExpressionParserRuleCall_10_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XThrowExpressionParserRuleCall_11ElementType() {
		return XPrimaryExpression_XThrowExpressionParserRuleCall_11_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XReturnExpressionParserRuleCall_12ElementType() {
		return XPrimaryExpression_XReturnExpressionParserRuleCall_12_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13ElementType() {
		return XPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXPrimaryExpression_XParenthesizedExpressionParserRuleCall_14ElementType() {
		return XPrimaryExpression_XParenthesizedExpressionParserRuleCall_14_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXLiteralElementType() {
		return XLiteral_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXLiteral_AlternativesElementType() {
		return XLiteral_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXLiteral_XCollectionLiteralParserRuleCall_0ElementType() {
		return XLiteral_XCollectionLiteralParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXLiteral_XClosureParserRuleCall_1ElementType() {
		return XLiteral_XClosureParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXLiteral_XBooleanLiteralParserRuleCall_2ElementType() {
		return XLiteral_XBooleanLiteralParserRuleCall_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXLiteral_XNumberLiteralParserRuleCall_3ElementType() {
		return XLiteral_XNumberLiteralParserRuleCall_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXLiteral_XNullLiteralParserRuleCall_4ElementType() {
		return XLiteral_XNullLiteralParserRuleCall_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXLiteral_XStringLiteralParserRuleCall_5ElementType() {
		return XLiteral_XStringLiteralParserRuleCall_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXLiteral_XTypeLiteralParserRuleCall_6ElementType() {
		return XLiteral_XTypeLiteralParserRuleCall_6_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCollectionLiteralElementType() {
		return XCollectionLiteral_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCollectionLiteral_AlternativesElementType() {
		return XCollectionLiteral_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCollectionLiteral_XSetLiteralParserRuleCall_0ElementType() {
		return XCollectionLiteral_XSetLiteralParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCollectionLiteral_XListLiteralParserRuleCall_1ElementType() {
		return XCollectionLiteral_XListLiteralParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteralElementType() {
		return XSetLiteral_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_GroupElementType() {
		return XSetLiteral_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_XSetLiteralAction_0ElementType() {
		return XSetLiteral_XSetLiteralAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_NumberSignKeyword_1ElementType() {
		return XSetLiteral_NumberSignKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_LeftCurlyBracketKeyword_2ElementType() {
		return XSetLiteral_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_Group_3ElementType() {
		return XSetLiteral_Group_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_ElementsAssignment_3_0ElementType() {
		return XSetLiteral_ElementsAssignment_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType() {
		return XSetLiteral_ElementsXExpressionParserRuleCall_3_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_Group_3_1ElementType() {
		return XSetLiteral_Group_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_CommaKeyword_3_1_0ElementType() {
		return XSetLiteral_CommaKeyword_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_ElementsAssignment_3_1_1ElementType() {
		return XSetLiteral_ElementsAssignment_3_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType() {
		return XSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSetLiteral_RightCurlyBracketKeyword_4ElementType() {
		return XSetLiteral_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteralElementType() {
		return XListLiteral_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_GroupElementType() {
		return XListLiteral_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_XListLiteralAction_0ElementType() {
		return XListLiteral_XListLiteralAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_NumberSignKeyword_1ElementType() {
		return XListLiteral_NumberSignKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_LeftSquareBracketKeyword_2ElementType() {
		return XListLiteral_LeftSquareBracketKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_Group_3ElementType() {
		return XListLiteral_Group_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_ElementsAssignment_3_0ElementType() {
		return XListLiteral_ElementsAssignment_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType() {
		return XListLiteral_ElementsXExpressionParserRuleCall_3_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_Group_3_1ElementType() {
		return XListLiteral_Group_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_CommaKeyword_3_1_0ElementType() {
		return XListLiteral_CommaKeyword_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_ElementsAssignment_3_1_1ElementType() {
		return XListLiteral_ElementsAssignment_3_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType() {
		return XListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXListLiteral_RightSquareBracketKeyword_4ElementType() {
		return XListLiteral_RightSquareBracketKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosureElementType() {
		return XClosure_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_GroupElementType() {
		return XClosure_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_Group_0ElementType() {
		return XClosure_Group_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_Group_0_0ElementType() {
		return XClosure_Group_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_XClosureAction_0_0_0ElementType() {
		return XClosure_XClosureAction_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_LeftSquareBracketKeyword_0_0_1ElementType() {
		return XClosure_LeftSquareBracketKeyword_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_Group_1ElementType() {
		return XClosure_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_Group_1_0ElementType() {
		return XClosure_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_Group_1_0_0ElementType() {
		return XClosure_Group_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_DeclaredFormalParametersAssignment_1_0_0_0ElementType() {
		return XClosure_DeclaredFormalParametersAssignment_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0ElementType() {
		return XClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_Group_1_0_0_1ElementType() {
		return XClosure_Group_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_CommaKeyword_1_0_0_1_0ElementType() {
		return XClosure_CommaKeyword_1_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_DeclaredFormalParametersAssignment_1_0_0_1_1ElementType() {
		return XClosure_DeclaredFormalParametersAssignment_1_0_0_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0ElementType() {
		return XClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_ExplicitSyntaxAssignment_1_0_1ElementType() {
		return XClosure_ExplicitSyntaxAssignment_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0ElementType() {
		return XClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_ExpressionAssignment_2ElementType() {
		return XClosure_ExpressionAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_ExpressionXExpressionInClosureParserRuleCall_2_0ElementType() {
		return XClosure_ExpressionXExpressionInClosureParserRuleCall_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXClosure_RightSquareBracketKeyword_3ElementType() {
		return XClosure_RightSquareBracketKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionInClosureElementType() {
		return XExpressionInClosure_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionInClosure_GroupElementType() {
		return XExpressionInClosure_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionInClosure_XBlockExpressionAction_0ElementType() {
		return XExpressionInClosure_XBlockExpressionAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionInClosure_Group_1ElementType() {
		return XExpressionInClosure_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionInClosure_ExpressionsAssignment_1_0ElementType() {
		return XExpressionInClosure_ExpressionsAssignment_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType() {
		return XExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionInClosure_SemicolonKeyword_1_1ElementType() {
		return XExpressionInClosure_SemicolonKeyword_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosureElementType() {
		return XShortClosure_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_GroupElementType() {
		return XShortClosure_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_Group_0ElementType() {
		return XShortClosure_Group_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_Group_0_0ElementType() {
		return XShortClosure_Group_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_XClosureAction_0_0_0ElementType() {
		return XShortClosure_XClosureAction_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_Group_0_0_1ElementType() {
		return XShortClosure_Group_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_DeclaredFormalParametersAssignment_0_0_1_0ElementType() {
		return XShortClosure_DeclaredFormalParametersAssignment_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0ElementType() {
		return XShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_Group_0_0_1_1ElementType() {
		return XShortClosure_Group_0_0_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_CommaKeyword_0_0_1_1_0ElementType() {
		return XShortClosure_CommaKeyword_0_0_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_DeclaredFormalParametersAssignment_0_0_1_1_1ElementType() {
		return XShortClosure_DeclaredFormalParametersAssignment_0_0_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0ElementType() {
		return XShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_ExplicitSyntaxAssignment_0_0_2ElementType() {
		return XShortClosure_ExplicitSyntaxAssignment_0_0_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0ElementType() {
		return XShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_ExpressionAssignment_1ElementType() {
		return XShortClosure_ExpressionAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXShortClosure_ExpressionXExpressionParserRuleCall_1_0ElementType() {
		return XShortClosure_ExpressionXExpressionParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXParenthesizedExpressionElementType() {
		return XParenthesizedExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXParenthesizedExpression_GroupElementType() {
		return XParenthesizedExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXParenthesizedExpression_LeftParenthesisKeyword_0ElementType() {
		return XParenthesizedExpression_LeftParenthesisKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXParenthesizedExpression_XExpressionParserRuleCall_1ElementType() {
		return XParenthesizedExpression_XExpressionParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXParenthesizedExpression_RightParenthesisKeyword_2ElementType() {
		return XParenthesizedExpression_RightParenthesisKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpressionElementType() {
		return XIfExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_GroupElementType() {
		return XIfExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_XIfExpressionAction_0ElementType() {
		return XIfExpression_XIfExpressionAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_IfKeyword_1ElementType() {
		return XIfExpression_IfKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_LeftParenthesisKeyword_2ElementType() {
		return XIfExpression_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_IfAssignment_3ElementType() {
		return XIfExpression_IfAssignment_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_IfXExpressionParserRuleCall_3_0ElementType() {
		return XIfExpression_IfXExpressionParserRuleCall_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_RightParenthesisKeyword_4ElementType() {
		return XIfExpression_RightParenthesisKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_ThenAssignment_5ElementType() {
		return XIfExpression_ThenAssignment_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_ThenXExpressionParserRuleCall_5_0ElementType() {
		return XIfExpression_ThenXExpressionParserRuleCall_5_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_Group_6ElementType() {
		return XIfExpression_Group_6_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_ElseKeyword_6_0ElementType() {
		return XIfExpression_ElseKeyword_6_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_ElseAssignment_6_1ElementType() {
		return XIfExpression_ElseAssignment_6_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXIfExpression_ElseXExpressionParserRuleCall_6_1_0ElementType() {
		return XIfExpression_ElseXExpressionParserRuleCall_6_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpressionElementType() {
		return XSwitchExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_GroupElementType() {
		return XSwitchExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_XSwitchExpressionAction_0ElementType() {
		return XSwitchExpression_XSwitchExpressionAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_SwitchKeyword_1ElementType() {
		return XSwitchExpression_SwitchKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_Alternatives_2ElementType() {
		return XSwitchExpression_Alternatives_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_Group_2_0ElementType() {
		return XSwitchExpression_Group_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_Group_2_0_0ElementType() {
		return XSwitchExpression_Group_2_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_Group_2_0_0_0ElementType() {
		return XSwitchExpression_Group_2_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0ElementType() {
		return XSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_DeclaredParamAssignment_2_0_0_0_1ElementType() {
		return XSwitchExpression_DeclaredParamAssignment_2_0_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType() {
		return XSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_ColonKeyword_2_0_0_0_2ElementType() {
		return XSwitchExpression_ColonKeyword_2_0_0_0_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_SwitchAssignment_2_0_1ElementType() {
		return XSwitchExpression_SwitchAssignment_2_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0ElementType() {
		return XSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_RightParenthesisKeyword_2_0_2ElementType() {
		return XSwitchExpression_RightParenthesisKeyword_2_0_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_Group_2_1ElementType() {
		return XSwitchExpression_Group_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_Group_2_1_0ElementType() {
		return XSwitchExpression_Group_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_Group_2_1_0_0ElementType() {
		return XSwitchExpression_Group_2_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_DeclaredParamAssignment_2_1_0_0_0ElementType() {
		return XSwitchExpression_DeclaredParamAssignment_2_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType() {
		return XSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_ColonKeyword_2_1_0_0_1ElementType() {
		return XSwitchExpression_ColonKeyword_2_1_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_SwitchAssignment_2_1_1ElementType() {
		return XSwitchExpression_SwitchAssignment_2_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_SwitchXExpressionParserRuleCall_2_1_1_0ElementType() {
		return XSwitchExpression_SwitchXExpressionParserRuleCall_2_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_LeftCurlyBracketKeyword_3ElementType() {
		return XSwitchExpression_LeftCurlyBracketKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_CasesAssignment_4ElementType() {
		return XSwitchExpression_CasesAssignment_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_CasesXCasePartParserRuleCall_4_0ElementType() {
		return XSwitchExpression_CasesXCasePartParserRuleCall_4_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_Group_5ElementType() {
		return XSwitchExpression_Group_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_DefaultKeyword_5_0ElementType() {
		return XSwitchExpression_DefaultKeyword_5_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_ColonKeyword_5_1ElementType() {
		return XSwitchExpression_ColonKeyword_5_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_DefaultAssignment_5_2ElementType() {
		return XSwitchExpression_DefaultAssignment_5_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0ElementType() {
		return XSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSwitchExpression_RightCurlyBracketKeyword_6ElementType() {
		return XSwitchExpression_RightCurlyBracketKeyword_6_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePartElementType() {
		return XCasePart_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_GroupElementType() {
		return XCasePart_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_XCasePartAction_0ElementType() {
		return XCasePart_XCasePartAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_TypeGuardAssignment_1ElementType() {
		return XCasePart_TypeGuardAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0ElementType() {
		return XCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_Group_2ElementType() {
		return XCasePart_Group_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_CaseKeyword_2_0ElementType() {
		return XCasePart_CaseKeyword_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_CaseAssignment_2_1ElementType() {
		return XCasePart_CaseAssignment_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_CaseXExpressionParserRuleCall_2_1_0ElementType() {
		return XCasePart_CaseXExpressionParserRuleCall_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_Alternatives_3ElementType() {
		return XCasePart_Alternatives_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_Group_3_0ElementType() {
		return XCasePart_Group_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_ColonKeyword_3_0_0ElementType() {
		return XCasePart_ColonKeyword_3_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_ThenAssignment_3_0_1ElementType() {
		return XCasePart_ThenAssignment_3_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_ThenXExpressionParserRuleCall_3_0_1_0ElementType() {
		return XCasePart_ThenXExpressionParserRuleCall_3_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_FallThroughAssignment_3_1ElementType() {
		return XCasePart_FallThroughAssignment_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCasePart_FallThroughCommaKeyword_3_1_0ElementType() {
		return XCasePart_FallThroughCommaKeyword_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpressionElementType() {
		return XForLoopExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_GroupElementType() {
		return XForLoopExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_Group_0ElementType() {
		return XForLoopExpression_Group_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_Group_0_0ElementType() {
		return XForLoopExpression_Group_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_XForLoopExpressionAction_0_0_0ElementType() {
		return XForLoopExpression_XForLoopExpressionAction_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_ForKeyword_0_0_1ElementType() {
		return XForLoopExpression_ForKeyword_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_LeftParenthesisKeyword_0_0_2ElementType() {
		return XForLoopExpression_LeftParenthesisKeyword_0_0_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_DeclaredParamAssignment_0_0_3ElementType() {
		return XForLoopExpression_DeclaredParamAssignment_0_0_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0ElementType() {
		return XForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_ColonKeyword_0_0_4ElementType() {
		return XForLoopExpression_ColonKeyword_0_0_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_ForExpressionAssignment_1ElementType() {
		return XForLoopExpression_ForExpressionAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0ElementType() {
		return XForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_RightParenthesisKeyword_2ElementType() {
		return XForLoopExpression_RightParenthesisKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_EachExpressionAssignment_3ElementType() {
		return XForLoopExpression_EachExpressionAssignment_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0ElementType() {
		return XForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpressionElementType() {
		return XBasicForLoopExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_GroupElementType() {
		return XBasicForLoopExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_XBasicForLoopExpressionAction_0ElementType() {
		return XBasicForLoopExpression_XBasicForLoopExpressionAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_ForKeyword_1ElementType() {
		return XBasicForLoopExpression_ForKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_LeftParenthesisKeyword_2ElementType() {
		return XBasicForLoopExpression_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_Group_3ElementType() {
		return XBasicForLoopExpression_Group_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_InitExpressionsAssignment_3_0ElementType() {
		return XBasicForLoopExpression_InitExpressionsAssignment_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0ElementType() {
		return XBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_Group_3_1ElementType() {
		return XBasicForLoopExpression_Group_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_CommaKeyword_3_1_0ElementType() {
		return XBasicForLoopExpression_CommaKeyword_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_InitExpressionsAssignment_3_1_1ElementType() {
		return XBasicForLoopExpression_InitExpressionsAssignment_3_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0ElementType() {
		return XBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_SemicolonKeyword_4ElementType() {
		return XBasicForLoopExpression_SemicolonKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_ExpressionAssignment_5ElementType() {
		return XBasicForLoopExpression_ExpressionAssignment_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0ElementType() {
		return XBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_SemicolonKeyword_6ElementType() {
		return XBasicForLoopExpression_SemicolonKeyword_6_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_Group_7ElementType() {
		return XBasicForLoopExpression_Group_7_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_UpdateExpressionsAssignment_7_0ElementType() {
		return XBasicForLoopExpression_UpdateExpressionsAssignment_7_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0ElementType() {
		return XBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_Group_7_1ElementType() {
		return XBasicForLoopExpression_Group_7_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_CommaKeyword_7_1_0ElementType() {
		return XBasicForLoopExpression_CommaKeyword_7_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_UpdateExpressionsAssignment_7_1_1ElementType() {
		return XBasicForLoopExpression_UpdateExpressionsAssignment_7_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0ElementType() {
		return XBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_RightParenthesisKeyword_8ElementType() {
		return XBasicForLoopExpression_RightParenthesisKeyword_8_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_EachExpressionAssignment_9ElementType() {
		return XBasicForLoopExpression_EachExpressionAssignment_9_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0ElementType() {
		return XBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXWhileExpressionElementType() {
		return XWhileExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXWhileExpression_GroupElementType() {
		return XWhileExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXWhileExpression_XWhileExpressionAction_0ElementType() {
		return XWhileExpression_XWhileExpressionAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXWhileExpression_WhileKeyword_1ElementType() {
		return XWhileExpression_WhileKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXWhileExpression_LeftParenthesisKeyword_2ElementType() {
		return XWhileExpression_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXWhileExpression_PredicateAssignment_3ElementType() {
		return XWhileExpression_PredicateAssignment_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXWhileExpression_PredicateXExpressionParserRuleCall_3_0ElementType() {
		return XWhileExpression_PredicateXExpressionParserRuleCall_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXWhileExpression_RightParenthesisKeyword_4ElementType() {
		return XWhileExpression_RightParenthesisKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXWhileExpression_BodyAssignment_5ElementType() {
		return XWhileExpression_BodyAssignment_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXWhileExpression_BodyXExpressionParserRuleCall_5_0ElementType() {
		return XWhileExpression_BodyXExpressionParserRuleCall_5_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpressionElementType() {
		return XDoWhileExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpression_GroupElementType() {
		return XDoWhileExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpression_XDoWhileExpressionAction_0ElementType() {
		return XDoWhileExpression_XDoWhileExpressionAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpression_DoKeyword_1ElementType() {
		return XDoWhileExpression_DoKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpression_BodyAssignment_2ElementType() {
		return XDoWhileExpression_BodyAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpression_BodyXExpressionParserRuleCall_2_0ElementType() {
		return XDoWhileExpression_BodyXExpressionParserRuleCall_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpression_WhileKeyword_3ElementType() {
		return XDoWhileExpression_WhileKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpression_LeftParenthesisKeyword_4ElementType() {
		return XDoWhileExpression_LeftParenthesisKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpression_PredicateAssignment_5ElementType() {
		return XDoWhileExpression_PredicateAssignment_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpression_PredicateXExpressionParserRuleCall_5_0ElementType() {
		return XDoWhileExpression_PredicateXExpressionParserRuleCall_5_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXDoWhileExpression_RightParenthesisKeyword_6ElementType() {
		return XDoWhileExpression_RightParenthesisKeyword_6_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBlockExpressionElementType() {
		return XBlockExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBlockExpression_GroupElementType() {
		return XBlockExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBlockExpression_XBlockExpressionAction_0ElementType() {
		return XBlockExpression_XBlockExpressionAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBlockExpression_LeftCurlyBracketKeyword_1ElementType() {
		return XBlockExpression_LeftCurlyBracketKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBlockExpression_Group_2ElementType() {
		return XBlockExpression_Group_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBlockExpression_ExpressionsAssignment_2_0ElementType() {
		return XBlockExpression_ExpressionsAssignment_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0ElementType() {
		return XBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBlockExpression_SemicolonKeyword_2_1ElementType() {
		return XBlockExpression_SemicolonKeyword_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBlockExpression_RightCurlyBracketKeyword_3ElementType() {
		return XBlockExpression_RightCurlyBracketKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionOrVarDeclarationElementType() {
		return XExpressionOrVarDeclaration_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionOrVarDeclaration_AlternativesElementType() {
		return XExpressionOrVarDeclaration_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0ElementType() {
		return XExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXExpressionOrVarDeclaration_XExpressionParserRuleCall_1ElementType() {
		return XExpressionOrVarDeclaration_XExpressionParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclarationElementType() {
		return XVariableDeclaration_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_GroupElementType() {
		return XVariableDeclaration_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_XVariableDeclarationAction_0ElementType() {
		return XVariableDeclaration_XVariableDeclarationAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_Alternatives_1ElementType() {
		return XVariableDeclaration_Alternatives_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_WriteableAssignment_1_0ElementType() {
		return XVariableDeclaration_WriteableAssignment_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_WriteableVarKeyword_1_0_0ElementType() {
		return XVariableDeclaration_WriteableVarKeyword_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_ValKeyword_1_1ElementType() {
		return XVariableDeclaration_ValKeyword_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_Alternatives_2ElementType() {
		return XVariableDeclaration_Alternatives_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_Group_2_0ElementType() {
		return XVariableDeclaration_Group_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_Group_2_0_0ElementType() {
		return XVariableDeclaration_Group_2_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_TypeAssignment_2_0_0_0ElementType() {
		return XVariableDeclaration_TypeAssignment_2_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_0ElementType() {
		return XVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_NameAssignment_2_0_0_1ElementType() {
		return XVariableDeclaration_NameAssignment_2_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0ElementType() {
		return XVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_NameAssignment_2_1ElementType() {
		return XVariableDeclaration_NameAssignment_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_NameValidIDParserRuleCall_2_1_0ElementType() {
		return XVariableDeclaration_NameValidIDParserRuleCall_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_Group_3ElementType() {
		return XVariableDeclaration_Group_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_EqualsSignKeyword_3_0ElementType() {
		return XVariableDeclaration_EqualsSignKeyword_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_RightAssignment_3_1ElementType() {
		return XVariableDeclaration_RightAssignment_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXVariableDeclaration_RightXExpressionParserRuleCall_3_1_0ElementType() {
		return XVariableDeclaration_RightXExpressionParserRuleCall_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmFormalParameterElementType() {
		return JvmFormalParameter_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmFormalParameter_GroupElementType() {
		return JvmFormalParameter_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmFormalParameter_ParameterTypeAssignment_0ElementType() {
		return JvmFormalParameter_ParameterTypeAssignment_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType() {
		return JvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmFormalParameter_NameAssignment_1ElementType() {
		return JvmFormalParameter_NameAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType() {
		return JvmFormalParameter_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFullJvmFormalParameterElementType() {
		return FullJvmFormalParameter_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFullJvmFormalParameter_GroupElementType() {
		return FullJvmFormalParameter_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFullJvmFormalParameter_ParameterTypeAssignment_0ElementType() {
		return FullJvmFormalParameter_ParameterTypeAssignment_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType() {
		return FullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFullJvmFormalParameter_NameAssignment_1ElementType() {
		return FullJvmFormalParameter_NameAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFullJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType() {
		return FullJvmFormalParameter_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCallElementType() {
		return XFeatureCall_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_GroupElementType() {
		return XFeatureCall_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_XFeatureCallAction_0ElementType() {
		return XFeatureCall_XFeatureCallAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_Group_1ElementType() {
		return XFeatureCall_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_LessThanSignKeyword_1_0ElementType() {
		return XFeatureCall_LessThanSignKeyword_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_TypeArgumentsAssignment_1_1ElementType() {
		return XFeatureCall_TypeArgumentsAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType() {
		return XFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_Group_1_2ElementType() {
		return XFeatureCall_Group_1_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_CommaKeyword_1_2_0ElementType() {
		return XFeatureCall_CommaKeyword_1_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_TypeArgumentsAssignment_1_2_1ElementType() {
		return XFeatureCall_TypeArgumentsAssignment_1_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType() {
		return XFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_GreaterThanSignKeyword_1_3ElementType() {
		return XFeatureCall_GreaterThanSignKeyword_1_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureAssignment_2ElementType() {
		return XFeatureCall_FeatureAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0ElementType() {
		return XFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1ElementType() {
		return XFeatureCall_FeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_Group_3ElementType() {
		return XFeatureCall_Group_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_ExplicitOperationCallAssignment_3_0ElementType() {
		return XFeatureCall_ExplicitOperationCallAssignment_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0ElementType() {
		return XFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_Alternatives_3_1ElementType() {
		return XFeatureCall_Alternatives_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureCallArgumentsAssignment_3_1_0ElementType() {
		return XFeatureCall_FeatureCallArgumentsAssignment_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0ElementType() {
		return XFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_Group_3_1_1ElementType() {
		return XFeatureCall_Group_3_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureCallArgumentsAssignment_3_1_1_0ElementType() {
		return XFeatureCall_FeatureCallArgumentsAssignment_3_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0ElementType() {
		return XFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_Group_3_1_1_1ElementType() {
		return XFeatureCall_Group_3_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_CommaKeyword_3_1_1_1_0ElementType() {
		return XFeatureCall_CommaKeyword_3_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureCallArgumentsAssignment_3_1_1_1_1ElementType() {
		return XFeatureCall_FeatureCallArgumentsAssignment_3_1_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0ElementType() {
		return XFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_RightParenthesisKeyword_3_2ElementType() {
		return XFeatureCall_RightParenthesisKeyword_3_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureCallArgumentsAssignment_4ElementType() {
		return XFeatureCall_FeatureCallArgumentsAssignment_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0ElementType() {
		return XFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeatureCallIDElementType() {
		return FeatureCallID_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeatureCallID_AlternativesElementType() {
		return FeatureCallID_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeatureCallID_ValidIDParserRuleCall_0ElementType() {
		return FeatureCallID_ValidIDParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeatureCallID_ExtendsKeyword_1ElementType() {
		return FeatureCallID_ExtendsKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeatureCallID_StaticKeyword_2ElementType() {
		return FeatureCallID_StaticKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeatureCallID_ImportKeyword_3ElementType() {
		return FeatureCallID_ImportKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFeatureCallID_ExtensionKeyword_4ElementType() {
		return FeatureCallID_ExtensionKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getIdOrSuperElementType() {
		return IdOrSuper_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getIdOrSuper_AlternativesElementType() {
		return IdOrSuper_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getIdOrSuper_FeatureCallIDParserRuleCall_0ElementType() {
		return IdOrSuper_FeatureCallIDParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getIdOrSuper_SuperKeyword_1ElementType() {
		return IdOrSuper_SuperKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCallElementType() {
		return XConstructorCall_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_GroupElementType() {
		return XConstructorCall_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_XConstructorCallAction_0ElementType() {
		return XConstructorCall_XConstructorCallAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_NewKeyword_1ElementType() {
		return XConstructorCall_NewKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ConstructorAssignment_2ElementType() {
		return XConstructorCall_ConstructorAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ConstructorJvmConstructorCrossReference_2_0ElementType() {
		return XConstructorCall_ConstructorJvmConstructorCrossReference_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1ElementType() {
		return XConstructorCall_ConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_Group_3ElementType() {
		return XConstructorCall_Group_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_LessThanSignKeyword_3_0ElementType() {
		return XConstructorCall_LessThanSignKeyword_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_TypeArgumentsAssignment_3_1ElementType() {
		return XConstructorCall_TypeArgumentsAssignment_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0ElementType() {
		return XConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_Group_3_2ElementType() {
		return XConstructorCall_Group_3_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_CommaKeyword_3_2_0ElementType() {
		return XConstructorCall_CommaKeyword_3_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_TypeArgumentsAssignment_3_2_1ElementType() {
		return XConstructorCall_TypeArgumentsAssignment_3_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0ElementType() {
		return XConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_GreaterThanSignKeyword_3_3ElementType() {
		return XConstructorCall_GreaterThanSignKeyword_3_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_Group_4ElementType() {
		return XConstructorCall_Group_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ExplicitConstructorCallAssignment_4_0ElementType() {
		return XConstructorCall_ExplicitConstructorCallAssignment_4_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0ElementType() {
		return XConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_Alternatives_4_1ElementType() {
		return XConstructorCall_Alternatives_4_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ArgumentsAssignment_4_1_0ElementType() {
		return XConstructorCall_ArgumentsAssignment_4_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0ElementType() {
		return XConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_Group_4_1_1ElementType() {
		return XConstructorCall_Group_4_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ArgumentsAssignment_4_1_1_0ElementType() {
		return XConstructorCall_ArgumentsAssignment_4_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0ElementType() {
		return XConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_Group_4_1_1_1ElementType() {
		return XConstructorCall_Group_4_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_CommaKeyword_4_1_1_1_0ElementType() {
		return XConstructorCall_CommaKeyword_4_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ArgumentsAssignment_4_1_1_1_1ElementType() {
		return XConstructorCall_ArgumentsAssignment_4_1_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0ElementType() {
		return XConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_RightParenthesisKeyword_4_2ElementType() {
		return XConstructorCall_RightParenthesisKeyword_4_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ArgumentsAssignment_5ElementType() {
		return XConstructorCall_ArgumentsAssignment_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXConstructorCall_ArgumentsXClosureParserRuleCall_5_0ElementType() {
		return XConstructorCall_ArgumentsXClosureParserRuleCall_5_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBooleanLiteralElementType() {
		return XBooleanLiteral_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBooleanLiteral_GroupElementType() {
		return XBooleanLiteral_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBooleanLiteral_XBooleanLiteralAction_0ElementType() {
		return XBooleanLiteral_XBooleanLiteralAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBooleanLiteral_Alternatives_1ElementType() {
		return XBooleanLiteral_Alternatives_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBooleanLiteral_FalseKeyword_1_0ElementType() {
		return XBooleanLiteral_FalseKeyword_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBooleanLiteral_IsTrueAssignment_1_1ElementType() {
		return XBooleanLiteral_IsTrueAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXBooleanLiteral_IsTrueTrueKeyword_1_1_0ElementType() {
		return XBooleanLiteral_IsTrueTrueKeyword_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXNullLiteralElementType() {
		return XNullLiteral_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXNullLiteral_GroupElementType() {
		return XNullLiteral_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXNullLiteral_XNullLiteralAction_0ElementType() {
		return XNullLiteral_XNullLiteralAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXNullLiteral_NullKeyword_1ElementType() {
		return XNullLiteral_NullKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXNumberLiteralElementType() {
		return XNumberLiteral_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXNumberLiteral_GroupElementType() {
		return XNumberLiteral_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXNumberLiteral_XNumberLiteralAction_0ElementType() {
		return XNumberLiteral_XNumberLiteralAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXNumberLiteral_ValueAssignment_1ElementType() {
		return XNumberLiteral_ValueAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXNumberLiteral_ValueNumberParserRuleCall_1_0ElementType() {
		return XNumberLiteral_ValueNumberParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXStringLiteralElementType() {
		return XStringLiteral_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXStringLiteral_GroupElementType() {
		return XStringLiteral_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXStringLiteral_XStringLiteralAction_0ElementType() {
		return XStringLiteral_XStringLiteralAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXStringLiteral_ValueAssignment_1ElementType() {
		return XStringLiteral_ValueAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXStringLiteral_ValueSTRINGTerminalRuleCall_1_0ElementType() {
		return XStringLiteral_ValueSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteralElementType() {
		return XTypeLiteral_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteral_GroupElementType() {
		return XTypeLiteral_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteral_XTypeLiteralAction_0ElementType() {
		return XTypeLiteral_XTypeLiteralAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteral_TypeofKeyword_1ElementType() {
		return XTypeLiteral_TypeofKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteral_LeftParenthesisKeyword_2ElementType() {
		return XTypeLiteral_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteral_TypeAssignment_3ElementType() {
		return XTypeLiteral_TypeAssignment_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteral_TypeJvmTypeCrossReference_3_0ElementType() {
		return XTypeLiteral_TypeJvmTypeCrossReference_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteral_TypeJvmTypeQualifiedNameParserRuleCall_3_0_1ElementType() {
		return XTypeLiteral_TypeJvmTypeQualifiedNameParserRuleCall_3_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteral_ArrayDimensionsAssignment_4ElementType() {
		return XTypeLiteral_ArrayDimensionsAssignment_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0ElementType() {
		return XTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTypeLiteral_RightParenthesisKeyword_5ElementType() {
		return XTypeLiteral_RightParenthesisKeyword_5_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXThrowExpressionElementType() {
		return XThrowExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXThrowExpression_GroupElementType() {
		return XThrowExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXThrowExpression_XThrowExpressionAction_0ElementType() {
		return XThrowExpression_XThrowExpressionAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXThrowExpression_ThrowKeyword_1ElementType() {
		return XThrowExpression_ThrowKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXThrowExpression_ExpressionAssignment_2ElementType() {
		return XThrowExpression_ExpressionAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXThrowExpression_ExpressionXExpressionParserRuleCall_2_0ElementType() {
		return XThrowExpression_ExpressionXExpressionParserRuleCall_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXReturnExpressionElementType() {
		return XReturnExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXReturnExpression_GroupElementType() {
		return XReturnExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXReturnExpression_XReturnExpressionAction_0ElementType() {
		return XReturnExpression_XReturnExpressionAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXReturnExpression_ReturnKeyword_1ElementType() {
		return XReturnExpression_ReturnKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXReturnExpression_ExpressionAssignment_2ElementType() {
		return XReturnExpression_ExpressionAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXReturnExpression_ExpressionXExpressionParserRuleCall_2_0ElementType() {
		return XReturnExpression_ExpressionXExpressionParserRuleCall_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpressionElementType() {
		return XTryCatchFinallyExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_GroupElementType() {
		return XTryCatchFinallyExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0ElementType() {
		return XTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_TryKeyword_1ElementType() {
		return XTryCatchFinallyExpression_TryKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_ExpressionAssignment_2ElementType() {
		return XTryCatchFinallyExpression_ExpressionAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0ElementType() {
		return XTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_Alternatives_3ElementType() {
		return XTryCatchFinallyExpression_Alternatives_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_Group_3_0ElementType() {
		return XTryCatchFinallyExpression_Group_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_CatchClausesAssignment_3_0_0ElementType() {
		return XTryCatchFinallyExpression_CatchClausesAssignment_3_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0ElementType() {
		return XTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_Group_3_0_1ElementType() {
		return XTryCatchFinallyExpression_Group_3_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_FinallyKeyword_3_0_1_0ElementType() {
		return XTryCatchFinallyExpression_FinallyKeyword_3_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_FinallyExpressionAssignment_3_0_1_1ElementType() {
		return XTryCatchFinallyExpression_FinallyExpressionAssignment_3_0_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0ElementType() {
		return XTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_Group_3_1ElementType() {
		return XTryCatchFinallyExpression_Group_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_FinallyKeyword_3_1_0ElementType() {
		return XTryCatchFinallyExpression_FinallyKeyword_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_FinallyExpressionAssignment_3_1_1ElementType() {
		return XTryCatchFinallyExpression_FinallyExpressionAssignment_3_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0ElementType() {
		return XTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpressionElementType() {
		return XSynchronizedExpression_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_GroupElementType() {
		return XSynchronizedExpression_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_Group_0ElementType() {
		return XSynchronizedExpression_Group_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_Group_0_0ElementType() {
		return XSynchronizedExpression_Group_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_XSynchronizedExpressionAction_0_0_0ElementType() {
		return XSynchronizedExpression_XSynchronizedExpressionAction_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_SynchronizedKeyword_0_0_1ElementType() {
		return XSynchronizedExpression_SynchronizedKeyword_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_LeftParenthesisKeyword_0_0_2ElementType() {
		return XSynchronizedExpression_LeftParenthesisKeyword_0_0_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_ParamAssignment_1ElementType() {
		return XSynchronizedExpression_ParamAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_ParamXExpressionParserRuleCall_1_0ElementType() {
		return XSynchronizedExpression_ParamXExpressionParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_RightParenthesisKeyword_2ElementType() {
		return XSynchronizedExpression_RightParenthesisKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_ExpressionAssignment_3ElementType() {
		return XSynchronizedExpression_ExpressionAssignment_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0ElementType() {
		return XSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCatchClauseElementType() {
		return XCatchClause_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCatchClause_GroupElementType() {
		return XCatchClause_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCatchClause_CatchKeyword_0ElementType() {
		return XCatchClause_CatchKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCatchClause_LeftParenthesisKeyword_1ElementType() {
		return XCatchClause_LeftParenthesisKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCatchClause_DeclaredParamAssignment_2ElementType() {
		return XCatchClause_DeclaredParamAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0ElementType() {
		return XCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCatchClause_RightParenthesisKeyword_3ElementType() {
		return XCatchClause_RightParenthesisKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCatchClause_ExpressionAssignment_4ElementType() {
		return XCatchClause_ExpressionAssignment_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXCatchClause_ExpressionXExpressionParserRuleCall_4_0ElementType() {
		return XCatchClause_ExpressionXExpressionParserRuleCall_4_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameElementType() {
		return QualifiedName_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedName_GroupElementType() {
		return QualifiedName_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedName_ValidIDParserRuleCall_0ElementType() {
		return QualifiedName_ValidIDParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedName_Group_1ElementType() {
		return QualifiedName_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedName_FullStopKeyword_1_0ElementType() {
		return QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedName_ValidIDParserRuleCall_1_1ElementType() {
		return QualifiedName_ValidIDParserRuleCall_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumberElementType() {
		return Number_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_AlternativesElementType() {
		return Number_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_HEXTerminalRuleCall_0ElementType() {
		return Number_HEXTerminalRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_Group_1ElementType() {
		return Number_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_Alternatives_1_0ElementType() {
		return Number_Alternatives_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_INTTerminalRuleCall_1_0_0ElementType() {
		return Number_INTTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_DECIMALTerminalRuleCall_1_0_1ElementType() {
		return Number_DECIMALTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_Group_1_1ElementType() {
		return Number_Group_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_FullStopKeyword_1_1_0ElementType() {
		return Number_FullStopKeyword_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_Alternatives_1_1_1ElementType() {
		return Number_Alternatives_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_INTTerminalRuleCall_1_1_1_0ElementType() {
		return Number_INTTerminalRuleCall_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNumber_DECIMALTerminalRuleCall_1_1_1_1ElementType() {
		return Number_DECIMALTerminalRuleCall_1_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getStaticQualifierElementType() {
		return StaticQualifier_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getStaticQualifier_GroupElementType() {
		return StaticQualifier_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getStaticQualifier_ValidIDParserRuleCall_0ElementType() {
		return StaticQualifier_ValidIDParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getStaticQualifier_ColonColonKeyword_1ElementType() {
		return StaticQualifier_ColonColonKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeReferenceElementType() {
		return JvmTypeReference_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeReference_AlternativesElementType() {
		return JvmTypeReference_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeReference_Group_0ElementType() {
		return JvmTypeReference_Group_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType() {
		return JvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeReference_Group_0_1ElementType() {
		return JvmTypeReference_Group_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeReference_Group_0_1_0ElementType() {
		return JvmTypeReference_Group_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType() {
		return JvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType() {
		return JvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType() {
		return JvmTypeReference_XFunctionTypeRefParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getArrayBracketsElementType() {
		return ArrayBrackets_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getArrayBrackets_GroupElementType() {
		return ArrayBrackets_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getArrayBrackets_LeftSquareBracketKeyword_0ElementType() {
		return ArrayBrackets_LeftSquareBracketKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getArrayBrackets_RightSquareBracketKeyword_1ElementType() {
		return ArrayBrackets_RightSquareBracketKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRefElementType() {
		return XFunctionTypeRef_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_GroupElementType() {
		return XFunctionTypeRef_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_Group_0ElementType() {
		return XFunctionTypeRef_Group_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType() {
		return XFunctionTypeRef_LeftParenthesisKeyword_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_Group_0_1ElementType() {
		return XFunctionTypeRef_Group_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_ParamTypesAssignment_0_1_0ElementType() {
		return XFunctionTypeRef_ParamTypesAssignment_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType() {
		return XFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_Group_0_1_1ElementType() {
		return XFunctionTypeRef_Group_0_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType() {
		return XFunctionTypeRef_CommaKeyword_0_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_ParamTypesAssignment_0_1_1_1ElementType() {
		return XFunctionTypeRef_ParamTypesAssignment_0_1_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType() {
		return XFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType() {
		return XFunctionTypeRef_RightParenthesisKeyword_0_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType() {
		return XFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_ReturnTypeAssignment_2ElementType() {
		return XFunctionTypeRef_ReturnTypeAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType() {
		return XFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReferenceElementType() {
		return JvmParameterizedTypeReference_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_GroupElementType() {
		return JvmParameterizedTypeReference_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_TypeAssignment_0ElementType() {
		return JvmParameterizedTypeReference_TypeAssignment_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType() {
		return JvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_TypeJvmTypeQualifiedNameParserRuleCall_0_0_1ElementType() {
		return JvmParameterizedTypeReference_TypeJvmTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_Group_1ElementType() {
		return JvmParameterizedTypeReference_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType() {
		return JvmParameterizedTypeReference_LessThanSignKeyword_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_ArgumentsAssignment_1_1ElementType() {
		return JvmParameterizedTypeReference_ArgumentsAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType() {
		return JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_Group_1_2ElementType() {
		return JvmParameterizedTypeReference_Group_1_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType() {
		return JvmParameterizedTypeReference_CommaKeyword_1_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_ArgumentsAssignment_1_2_1ElementType() {
		return JvmParameterizedTypeReference_ArgumentsAssignment_1_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType() {
		return JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType() {
		return JvmParameterizedTypeReference_GreaterThanSignKeyword_1_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_Group_1_4ElementType() {
		return JvmParameterizedTypeReference_Group_1_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_Group_1_4_0ElementType() {
		return JvmParameterizedTypeReference_Group_1_4_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_Group_1_4_0_0ElementType() {
		return JvmParameterizedTypeReference_Group_1_4_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType() {
		return JvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType() {
		return JvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_TypeAssignment_1_4_1ElementType() {
		return JvmParameterizedTypeReference_TypeAssignment_1_4_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType() {
		return JvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_TypeJvmTypeValidIDParserRuleCall_1_4_1_0_1ElementType() {
		return JvmParameterizedTypeReference_TypeJvmTypeValidIDParserRuleCall_1_4_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_Group_1_4_2ElementType() {
		return JvmParameterizedTypeReference_Group_1_4_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType() {
		return JvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_1ElementType() {
		return JvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType() {
		return JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_Group_1_4_2_2ElementType() {
		return JvmParameterizedTypeReference_Group_1_4_2_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType() {
		return JvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_2_1ElementType() {
		return JvmParameterizedTypeReference_ArgumentsAssignment_1_4_2_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType() {
		return JvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3ElementType() {
		return JvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmArgumentTypeReferenceElementType() {
		return JvmArgumentTypeReference_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmArgumentTypeReference_AlternativesElementType() {
		return JvmArgumentTypeReference_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType() {
		return JvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType() {
		return JvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReferenceElementType() {
		return JvmWildcardTypeReference_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_GroupElementType() {
		return JvmWildcardTypeReference_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType() {
		return JvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType() {
		return JvmWildcardTypeReference_QuestionMarkKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_Alternatives_2ElementType() {
		return JvmWildcardTypeReference_Alternatives_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_Group_2_0ElementType() {
		return JvmWildcardTypeReference_Group_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_ConstraintsAssignment_2_0_0ElementType() {
		return JvmWildcardTypeReference_ConstraintsAssignment_2_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType() {
		return JvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_ConstraintsAssignment_2_0_1ElementType() {
		return JvmWildcardTypeReference_ConstraintsAssignment_2_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType() {
		return JvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_Group_2_1ElementType() {
		return JvmWildcardTypeReference_Group_2_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_ConstraintsAssignment_2_1_0ElementType() {
		return JvmWildcardTypeReference_ConstraintsAssignment_2_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType() {
		return JvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_ConstraintsAssignment_2_1_1ElementType() {
		return JvmWildcardTypeReference_ConstraintsAssignment_2_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType() {
		return JvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmUpperBoundElementType() {
		return JvmUpperBound_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmUpperBound_GroupElementType() {
		return JvmUpperBound_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmUpperBound_ExtendsKeyword_0ElementType() {
		return JvmUpperBound_ExtendsKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmUpperBound_TypeReferenceAssignment_1ElementType() {
		return JvmUpperBound_TypeReferenceAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType() {
		return JvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmUpperBoundAndedElementType() {
		return JvmUpperBoundAnded_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmUpperBoundAnded_GroupElementType() {
		return JvmUpperBoundAnded_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmUpperBoundAnded_AmpersandKeyword_0ElementType() {
		return JvmUpperBoundAnded_AmpersandKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmUpperBoundAnded_TypeReferenceAssignment_1ElementType() {
		return JvmUpperBoundAnded_TypeReferenceAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType() {
		return JvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmLowerBoundElementType() {
		return JvmLowerBound_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmLowerBound_GroupElementType() {
		return JvmLowerBound_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmLowerBound_SuperKeyword_0ElementType() {
		return JvmLowerBound_SuperKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmLowerBound_TypeReferenceAssignment_1ElementType() {
		return JvmLowerBound_TypeReferenceAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType() {
		return JvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmLowerBoundAndedElementType() {
		return JvmLowerBoundAnded_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmLowerBoundAnded_GroupElementType() {
		return JvmLowerBoundAnded_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmLowerBoundAnded_AmpersandKeyword_0ElementType() {
		return JvmLowerBoundAnded_AmpersandKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmLowerBoundAnded_TypeReferenceAssignment_1ElementType() {
		return JvmLowerBoundAnded_TypeReferenceAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType() {
		return JvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeParameterElementType() {
		return JvmTypeParameter_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeParameter_GroupElementType() {
		return JvmTypeParameter_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeParameter_NameAssignment_0ElementType() {
		return JvmTypeParameter_NameAssignment_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType() {
		return JvmTypeParameter_NameValidIDParserRuleCall_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeParameter_Group_1ElementType() {
		return JvmTypeParameter_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeParameter_ConstraintsAssignment_1_0ElementType() {
		return JvmTypeParameter_ConstraintsAssignment_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0ElementType() {
		return JvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeParameter_ConstraintsAssignment_1_1ElementType() {
		return JvmTypeParameter_ConstraintsAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getJvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0ElementType() {
		return JvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameWithWildcardElementType() {
		return QualifiedNameWithWildcard_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameWithWildcard_GroupElementType() {
		return QualifiedNameWithWildcard_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType() {
		return QualifiedNameWithWildcard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameWithWildcard_FullStopKeyword_1ElementType() {
		return QualifiedNameWithWildcard_FullStopKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameWithWildcard_AsteriskKeyword_2ElementType() {
		return QualifiedNameWithWildcard_AsteriskKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getValidIDElementType() {
		return ValidID_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getValidID_IDTerminalRuleCallElementType() {
		return ValidID_IDTerminalRuleCall_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportSectionElementType() {
		return XImportSection_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportSection_ImportDeclarationsAssignmentElementType() {
		return XImportSection_ImportDeclarationsAssignment_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType() {
		return XImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclarationElementType() {
		return XImportDeclaration_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_GroupElementType() {
		return XImportDeclaration_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ImportKeyword_0ElementType() {
		return XImportDeclaration_ImportKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_Alternatives_1ElementType() {
		return XImportDeclaration_Alternatives_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_Group_1_0ElementType() {
		return XImportDeclaration_Group_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_StaticAssignment_1_0_0ElementType() {
		return XImportDeclaration_StaticAssignment_1_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType() {
		return XImportDeclaration_StaticStaticKeyword_1_0_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ExtensionAssignment_1_0_1ElementType() {
		return XImportDeclaration_ExtensionAssignment_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType() {
		return XImportDeclaration_ExtensionExtensionKeyword_1_0_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ImportedTypeAssignment_1_0_2ElementType() {
		return XImportDeclaration_ImportedTypeAssignment_1_0_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType() {
		return XImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1ElementType() {
		return XImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_Alternatives_1_0_3ElementType() {
		return XImportDeclaration_Alternatives_1_0_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_WildcardAssignment_1_0_3_0ElementType() {
		return XImportDeclaration_WildcardAssignment_1_0_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType() {
		return XImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_MemberNameAssignment_1_0_3_1ElementType() {
		return XImportDeclaration_MemberNameAssignment_1_0_3_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType() {
		return XImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ImportedTypeAssignment_1_1ElementType() {
		return XImportDeclaration_ImportedTypeAssignment_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType() {
		return XImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1ElementType() {
		return XImportDeclaration_ImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ImportedNamespaceAssignment_1_2ElementType() {
		return XImportDeclaration_ImportedNamespaceAssignment_1_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType() {
		return XImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getXImportDeclaration_SemicolonKeyword_2ElementType() {
		return XImportDeclaration_SemicolonKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameInStaticImportElementType() {
		return QualifiedNameInStaticImport_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameInStaticImport_GroupElementType() {
		return QualifiedNameInStaticImport_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType() {
		return QualifiedNameInStaticImport_ValidIDParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameInStaticImport_FullStopKeyword_1ElementType() {
		return QualifiedNameInStaticImport_FullStopKeyword_1_ELEMENT_TYPE;
	}

}
