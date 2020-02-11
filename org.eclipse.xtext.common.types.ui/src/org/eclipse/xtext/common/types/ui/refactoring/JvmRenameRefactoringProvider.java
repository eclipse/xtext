/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.refactoring.IJavaRefactorings;
import org.eclipse.jdt.core.refactoring.descriptors.RenameJavaElementDescriptor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenamingNameSuggestor;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.refactoring.DelegateUIHelper;
import org.eclipse.jdt.internal.ui.refactoring.reorg.RenameRefactoringWizard;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ltk.core.refactoring.RefactoringCore;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardPage;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmRenameRefactoringProvider extends DefaultRenameRefactoringProvider {

	@Override
	public ProcessorBasedRefactoring getRenameRefactoring(IRenameElementContext renameElementContext) {
		if (renameElementContext instanceof JdtRefactoringContext) {
			IJavaElement javaElement = ((JdtRefactoringContext) renameElementContext).getJavaElement();
			if (isJavaSource(javaElement)) {
				try {
					RenameJavaElementDescriptor renameDescriptor = createRenameDescriptor(javaElement,
							javaElement.getElementName());
					return (ProcessorBasedRefactoring) renameDescriptor.createRefactoring(new RefactoringStatus());
				} catch (Exception exc) {
					throw new WrappedException(exc);
				}
			}
		}
		return super.getRenameRefactoring(renameElementContext);
	}

	protected boolean isJavaSource(IJavaElement javaElement) {
		return "java".equals(javaElement.getResource().getFileExtension());
	}

	/**
	 * Copied from {@link org.eclipse.jdt.internal.ui.refactoring.reorg.RenameLinkedMode}. There does not seem to be a
	 * clean way to initialize a JDT refactoring from the outside.
	 */
	public RenameJavaElementDescriptor createRenameDescriptor(IJavaElement javaElement, String newName)
			throws JavaModelException {
		String contributionId;
		// see RefactoringExecutionStarter#createRenameSupport(..):
		int elementType = javaElement.getElementType();
		switch (elementType) {
			case IJavaElement.JAVA_PROJECT:
				contributionId = IJavaRefactorings.RENAME_JAVA_PROJECT;
				break;
			case IJavaElement.PACKAGE_FRAGMENT_ROOT:
				contributionId = IJavaRefactorings.RENAME_SOURCE_FOLDER;
				break;
			case IJavaElement.PACKAGE_FRAGMENT:
				contributionId = IJavaRefactorings.RENAME_PACKAGE;
				break;
			case IJavaElement.COMPILATION_UNIT:
				contributionId = IJavaRefactorings.RENAME_COMPILATION_UNIT;
				break;
			case IJavaElement.TYPE:
				contributionId = IJavaRefactorings.RENAME_TYPE;
				break;
			case IJavaElement.METHOD:
				final IMethod method = (IMethod) javaElement;
				if (method.isConstructor())
					return createRenameDescriptor(method.getDeclaringType(), newName);
				else
					contributionId = IJavaRefactorings.RENAME_METHOD;
				break;
			case IJavaElement.FIELD:
				IField field = (IField) javaElement;
				if (field.isEnumConstant())
					contributionId = IJavaRefactorings.RENAME_ENUM_CONSTANT;
				else
					contributionId = IJavaRefactorings.RENAME_FIELD;
				break;
			case IJavaElement.TYPE_PARAMETER:
				contributionId = IJavaRefactorings.RENAME_TYPE_PARAMETER;
				break;
			case IJavaElement.LOCAL_VARIABLE:
				contributionId = IJavaRefactorings.RENAME_LOCAL_VARIABLE;
				break;
			default:
				return null;
		}

		RenameJavaElementDescriptor descriptor = (RenameJavaElementDescriptor) RefactoringCore
				.getRefactoringContribution(contributionId).createDescriptor();
		descriptor.setJavaElement(javaElement);
		descriptor.setNewName(newName);
		if (elementType != IJavaElement.PACKAGE_FRAGMENT_ROOT)
			descriptor.setUpdateReferences(true);

		IDialogSettings javaSettings = JavaPlugin.getDefault().getDialogSettings();
		IDialogSettings refactoringSettings = javaSettings.getSection(RefactoringWizardPage.REFACTORING_SETTINGS); //TODO: undocumented API
		if (refactoringSettings == null) {
			refactoringSettings = javaSettings.addNewSection(RefactoringWizardPage.REFACTORING_SETTINGS);
		}

		switch (elementType) {
			case IJavaElement.METHOD:
			case IJavaElement.FIELD:
				descriptor.setDeprecateDelegate(refactoringSettings.getBoolean(DelegateUIHelper.DELEGATE_DEPRECATION));
				descriptor.setKeepOriginal(refactoringSettings.getBoolean(DelegateUIHelper.DELEGATE_UPDATING));
		}
		switch (elementType) {
			case IJavaElement.TYPE:
				//			case IJavaElement.COMPILATION_UNIT: // TODO
				descriptor.setUpdateSimilarDeclarations(refactoringSettings
						.getBoolean(RenameRefactoringWizard.TYPE_UPDATE_SIMILAR_ELEMENTS));
				int strategy;
				try {
					strategy = refactoringSettings.getInt(RenameRefactoringWizard.TYPE_SIMILAR_MATCH_STRATEGY);
				} catch (NumberFormatException e) {
					strategy = RenamingNameSuggestor.STRATEGY_EXACT;
				}
				descriptor.setMatchStrategy(strategy);
		}
		switch (elementType) {
			case IJavaElement.PACKAGE_FRAGMENT:
				descriptor.setUpdateHierarchy(refactoringSettings
						.getBoolean(RenameRefactoringWizard.PACKAGE_RENAME_SUBPACKAGES));
		}
		switch (elementType) {
			case IJavaElement.PACKAGE_FRAGMENT:
			case IJavaElement.TYPE:
				String fileNamePatterns = refactoringSettings.get(RenameRefactoringWizard.QUALIFIED_NAMES_PATTERNS);
				if (fileNamePatterns != null && fileNamePatterns.length() != 0) {
					descriptor.setFileNamePatterns(fileNamePatterns);
					boolean updateQualifiedNames = refactoringSettings
							.getBoolean(RenameRefactoringWizard.UPDATE_QUALIFIED_NAMES);
					descriptor.setUpdateQualifiedNames(updateQualifiedNames);
					//					fShowPreview|= updateQualifiedNames;
				}
		}
		switch (elementType) {
			case IJavaElement.PACKAGE_FRAGMENT:
			case IJavaElement.TYPE:
			case IJavaElement.FIELD:
				boolean updateTextualOccurrences = refactoringSettings
						.getBoolean(RenameRefactoringWizard.UPDATE_TEXTUAL_MATCHES);
				descriptor.setUpdateTextualOccurrences(updateTextualOccurrences);
				//				fShowPreview|= updateTextualOccurrences;
		}
		switch (elementType) {
			case IJavaElement.FIELD:
				descriptor
						.setRenameGetters(refactoringSettings.getBoolean(RenameRefactoringWizard.FIELD_RENAME_GETTER));
				descriptor
						.setRenameSetters(refactoringSettings.getBoolean(RenameRefactoringWizard.FIELD_RENAME_SETTER));
		}
		return descriptor;
	}
}
