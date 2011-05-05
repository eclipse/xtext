/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.refactoring.IJavaRefactorings;
import org.eclipse.jdt.core.refactoring.descriptors.RenameJavaElementDescriptor;
import org.eclipse.jdt.internal.corext.refactoring.rename.JavaRenameProcessor;
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
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JvmRenameRefactoringProvider extends DefaultRenameRefactoringProvider {

//	private PolymorphicDispatcher<JavaRenameProcessor> createProcessor = PolymorphicDispatcher.createForSingleTarget(
//			"createProcessor", this);

	@Override
	public ProcessorBasedRefactoring getRenameRefactoring(IRenameElementContext renameElementContext) {
		if (renameElementContext instanceof RenameJavaElementContext) {
			for (IJavaElement javaElement : ((RenameJavaElementContext) renameElementContext).getJavaElements()) {
				if (isJavaSource(javaElement)) {
					try {
						RenameJavaElementDescriptor renameDescriptor = createRenameDescriptor(javaElement,
								javaElement.getElementName());
						return (ProcessorBasedRefactoring) renameDescriptor.createRefactoring(new RefactoringStatus());
					} catch (Exception exc) {
						throw new WrappedException(exc);
					}
					//					JavaRenameProcessor javaRenameProcessor = createProcessor.invoke(javaElement);
					//					if (javaRenameProcessor != null) {
					//						return new RenameRefactoring(javaRenameProcessor);
					//					}

				}
			}
		}
		return super.getRenameRefactoring(renameElementContext);
	}

	protected boolean isJavaSource(IJavaElement javaElement) {
		return "java".equals(javaElement.getResource().getFileExtension());
	}

//	protected JavaRenameProcessor createProcessor(ICompilationUnit compilationUnit) throws CoreException {
//		return configure(new RenameCompilationUnitProcessor(compilationUnit));
//	}
//
//	protected JavaRenameProcessor createProcessor(IType type) throws JavaModelException {
//		return configure(new RenameTypeProcessor(type));
//	}
//
//	protected JavaRenameProcessor createProcessor(IMethod method) throws JavaModelException {
//		if (MethodChecks.isVirtual(method)) {
//			return configure(new RenameVirtualMethodProcessor(method));
//		} else {
//			return configure(new RenameNonVirtualMethodProcessor(method));
//		}
//	}
//
//	protected JavaRenameProcessor createProcessor(IField field) throws JavaModelException {
//		if (JdtFlags.isEnum(field))
//			return configure(new RenameEnumConstProcessor(field));
//		else {
//			final RenameFieldProcessor processor = new RenameFieldProcessor(field);
//			processor.setRenameGetter(true);
//			processor.setRenameSetter(true);
//			return configure(processor);
//		}
//	}
//
//	protected JavaRenameProcessor configure(JavaRenameProcessor processor) {
//		if (processor instanceof IReferenceUpdating) {
//			IReferenceUpdating reference = (IReferenceUpdating) processor;
//			reference.setUpdateReferences(isUpdateReferences());
//		}
//		if (processor instanceof ITextUpdating) {
//			ITextUpdating text = (ITextUpdating) processor;
//			text.setUpdateTextualMatches(isUpdateTextualMatches());
//		}
//		return processor;
//	}
//
//	protected boolean isUpdateReferences() {
//		return true;
//	}
//
//	protected boolean isUpdateTextualMatches() {
//		return true;
//	}
//
	/**
	 * Copied from {@link org.eclipse.jdt.internal.ui.refactoring.reorg.RenameLinkedMode}. There does not seem to be a
	 * way to properly initialize a JDT refactoring from the outside.
	 */
	protected RenameJavaElementDescriptor createRenameDescriptor(IJavaElement javaElement, String newName)
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
