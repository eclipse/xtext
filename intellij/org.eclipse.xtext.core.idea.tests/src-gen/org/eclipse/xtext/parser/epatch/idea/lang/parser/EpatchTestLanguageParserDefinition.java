package org.eclipse.xtext.parser.epatch.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.epatch.idea.lang.psi.impl.EpatchTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class EpatchTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private EpatchTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new EpatchTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getModelImport_ResourceImportParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getResourceImport_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getModelImport_EPackageImportParserRuleCall_1ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getEPackageImport_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getEPatch_ResourcesNamedResourceParserRuleCall_4_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getNamedResource_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getEPatch_ObjectsObjectRefParserRuleCall_5_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getObjectRef_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getNamedObject_ObjectRefParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getObjectRef_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getNamedResource_LeftRootCreatedObjectParserRuleCall_4_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getCreatedObject_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getNamedResource_RightRootCreatedObjectParserRuleCall_7_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getCreatedObject_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getNamedObject_CreatedObjectParserRuleCall_1ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getCreatedObject_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getCreatedObject_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getListAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getCreatedObject_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getSingleAssignmentValue_NewObjectCreatedObjectParserRuleCall_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getCreatedObject_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getObjectRef_LeftResNamedResourceCrossReference_2_0_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getObjectRef_LeftResNamedResourceCrossReference_2_1_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getObjectRef_RightResNamedResourceCrossReference_2_1_4_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getAssignmentValue_RefObjectNamedObjectCrossReference_1_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getAssignmentValue_ImportImportCrossReference_3_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getListAssignmentValue_RefObjectNamedObjectCrossReference_2_2_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getListAssignmentValue_ImportImportCrossReference_2_4_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getSingleAssignmentValue_RefObjectNamedObjectCrossReference_2_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getSingleAssignmentValue_ImportImportCrossReference_4_0_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getObjectNew_ImportImportCrossReference_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getObjectCopy_ResourceNamedResourceCrossReference_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
