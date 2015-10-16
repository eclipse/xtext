package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageElementTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi.impl.EcoreReferenceTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class EcoreReferenceTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private EcoreReferenceTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new EcoreReferenceTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getModel_ExtendsExtendsNsURIEObjectParserRuleCall_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_5_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getModel_ExtendsExtendsPluginEObjectParserRuleCall_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_6_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getModel_ExtendsExtendsResourceEObjectParserRuleCall_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_7_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EAttributeReferenceMyEAttributeCrossReference_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_4_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1EObjectCrossReference_2_0_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference3ExtendsPluginEObjectCrossReference_3_2_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference4ExtendsResourceEObjectCrossReference_3_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getModelElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_ExtendsAssignment_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_ExtendsAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getModel_ExtendsAssignment_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObjectElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_ExtendsNsURIEObjectKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_NameAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_NameValidIDParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_Alternatives_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_Group_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectKeyword_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1Assignment_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1EObjectIDTerminalRuleCall_2_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_Group_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1Assignment_2_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsNsURIEObjectIDTerminalRuleCall_2_1_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_Group_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1Assignment_2_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsPluginEObjectIDTerminalRuleCall_2_2_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_Group_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1Assignment_2_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference1ExtendsResourceEObjectIDTerminalRuleCall_2_3_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_Group_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_ExtendsPluginEObjectKeyword_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EAttributeReferenceAssignment_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EAttributeReferenceMyEAttributeIDTerminalRuleCall_3_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference2Assignment_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference2ExtendsNsURIEObjectIDTerminalRuleCall_3_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference3Assignment_3_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference3ExtendsPluginEObjectIDTerminalRuleCall_3_3_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference4Assignment_3_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectReference4ExtendsResourceEObjectIDTerminalRuleCall_3_4_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentAssignment_3_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentAssignment_3_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentAssignment_3_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentAssignment_3_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentEObjectParserRuleCall_3_8_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentAssignment_3_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentEAttributeParserRuleCall_3_9_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentAssignment_3_10ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsNsURIEObject_EObjectContainmentMyEAttributeParserRuleCall_3_10_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMyEAttributeElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMyEAttribute_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMyEAttribute_MyEAttributeAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getMyEAttribute_MyEAttributeKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getEAttributeElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getEAttribute_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getEAttribute_EAttributeAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getEAttribute_EAttributeKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObjectElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_NameAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_NameValidIDParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_Alternatives_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_Group_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectKeyword_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1Assignment_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1EObjectIDTerminalRuleCall_2_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_Group_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1Assignment_2_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsNsURIEObjectIDTerminalRuleCall_2_1_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_Group_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1Assignment_2_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsPluginEObjectIDTerminalRuleCall_2_2_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_Group_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1Assignment_2_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference1ExtendsResourceEObjectIDTerminalRuleCall_2_3_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_Group_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_ExtendsPluginEObjectKeyword_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference2Assignment_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference2ExtendsNsURIEObjectIDTerminalRuleCall_3_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference3Assignment_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference3ExtendsPluginEObjectIDTerminalRuleCall_3_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference4Assignment_3_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectReference4ExtendsResourceEObjectIDTerminalRuleCall_3_3_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentAssignment_3_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentAssignment_3_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentAssignment_3_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentAssignment_3_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentEObjectParserRuleCall_3_7_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentAssignment_3_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentEAttributeParserRuleCall_3_8_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentAssignment_3_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsPluginEObject_EObjectContainmentMyEAttributeParserRuleCall_3_9_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_01ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_01_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_01_MyNamedElement_01Action_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_01_NameAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_01_NameValidIDParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_02ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_02_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_02_MyNamedElement_02Action_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_02_NameAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_02_NameValidIDParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_03ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_03_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_03_MyNamedElement_03Action_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_03_NameAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getUnused_03_NameValidIDParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObjectElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_NameAssignment_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_NameValidIDParserRuleCall_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_Alternatives_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_Group_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectKeyword_2_0_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1Assignment_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1EObjectIDTerminalRuleCall_2_0_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_Group_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_ExtendsNsURIEObjectKeyword_2_1_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1Assignment_2_1_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsNsURIEObjectIDTerminalRuleCall_2_1_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_Group_2_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_ExtendsPluginEObjectKeyword_2_2_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1Assignment_2_2_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsPluginEObjectIDTerminalRuleCall_2_2_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_Group_2_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_2_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1Assignment_2_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference1ExtendsResourceEObjectIDTerminalRuleCall_2_3_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_Group_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_ExtendsResourceEObjectKeyword_3_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference2Assignment_3_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference2ExtendsNsURIEObjectIDTerminalRuleCall_3_1_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference3Assignment_3_2ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference3ExtendsPluginEObjectIDTerminalRuleCall_3_2_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference4Assignment_3_3ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectReference4ExtendsResourceEObjectIDTerminalRuleCall_3_3_0_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentAssignment_3_4ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentAssignment_3_5ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentAssignment_3_6ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentAssignment_3_7ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentEObjectParserRuleCall_3_7_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentAssignment_3_8ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentEAttributeParserRuleCall_3_8_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentAssignment_3_9ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getExtendsResourceEObject_EObjectContainmentMyEAttributeParserRuleCall_3_9_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getEObjectElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getEObject_GroupElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getEObject_EObjectAction_0ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getEObject_ObjectKeyword_1ElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getValidIDElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		if (elementType == elementTypeProvider.getValidID_IDTerminalRuleCallElementType()) {
			return new PsiEObjectImpl(node) {};
		}
		throw new java.lang.IllegalStateException("Unexpected element type: " + elementType);
	}

}
