/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.corext.refactoring.rename.JavaRenameProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.MethodChecks;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameCompilationUnitProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameEnumConstProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameFieldProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameNonVirtualMethodProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameTypeProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameVirtualMethodProcessor;
import org.eclipse.jdt.internal.corext.refactoring.tagging.IReferenceUpdating;
import org.eclipse.jdt.internal.corext.refactoring.tagging.ITextUpdating;
import org.eclipse.jdt.internal.corext.util.JdtFlags;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JvmRenameRefactoringProvider extends DefaultRenameRefactoringProvider {

	private PolymorphicDispatcher<JavaRenameProcessor> createProcessor = PolymorphicDispatcher.createForSingleTarget(
			"createProcessor", this);

	@Override
	public ProcessorBasedRefactoring getRenameRefactoring(IRenameElementContext renameElementContext) {
		if (renameElementContext instanceof RenameJavaElementContext) {
			for (IJavaElement javaElement : ((RenameJavaElementContext) renameElementContext).getJavaElements()) {
				if (isJavaSource(javaElement)) {
					JavaRenameProcessor javaRenameProcessor = createProcessor.invoke(javaElement);
					if (javaRenameProcessor != null) {
						return new RenameRefactoring(javaRenameProcessor);
					}
						
				}
			}
		}
		return super.getRenameRefactoring(renameElementContext);
	}

	protected boolean isJavaSource(IJavaElement javaElement) {
		return "java".equals(javaElement.getResource().getFileExtension());
	}

	protected JavaRenameProcessor createProcessor(ICompilationUnit compilationUnit) throws CoreException {
		return configure(new RenameCompilationUnitProcessor(compilationUnit));
	}

	protected JavaRenameProcessor createProcessor(IType type) throws JavaModelException {
		return configure(new RenameTypeProcessor(type));
	}

	protected JavaRenameProcessor createProcessor(IMethod method) throws JavaModelException {
		if (MethodChecks.isVirtual(method)) {
			return configure(new RenameVirtualMethodProcessor(method));
		} else {
			return configure(new RenameNonVirtualMethodProcessor(method));
		}
	}

	protected JavaRenameProcessor createProcessor(IField field) throws JavaModelException {
		if (JdtFlags.isEnum(field))
			return configure(new RenameEnumConstProcessor(field));
		else {
			final RenameFieldProcessor processor = new RenameFieldProcessor(field);
			processor.setRenameGetter(true);
			processor.setRenameSetter(true);
			return configure(processor);
		}
	}
	
	protected JavaRenameProcessor configure(JavaRenameProcessor processor) {
		if (processor instanceof IReferenceUpdating) {
			IReferenceUpdating reference= (IReferenceUpdating) processor;
			reference.setUpdateReferences(isUpdateReferences());
		}
		if (processor instanceof ITextUpdating) {
			ITextUpdating text= (ITextUpdating) processor;
			text.setUpdateTextualMatches(isUpdateTextualMatches());
		}
		return processor;
	}

	protected boolean isUpdateReferences() {
		return true;
	}

	protected boolean isUpdateTextualMatches() {
		return true;
	}


}
