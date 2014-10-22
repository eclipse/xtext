/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.edit;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend.core.conversion.JavaConverter;
import org.eclipse.xtend.core.conversion.JavaConverter.ConversionResult;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author dhuebner - Initial contribution and API
 */
public class ConvertJavaCode {

	@Inject
	private IResourceSetProvider resourceSetProvider;
	@Inject
	private Provider<JavaConverter> converterProvider;
	@Inject
	private FileExtensionProvider fileExtensionProvider;

	public void runJavaConverter(final Set<ICompilationUnit> compilationUnits, Shell activeShell)
			throws ExecutionException {
		Map<ICompilationUnit, ConversionResult> conversionResults = newHashMap();
		convertAllWithProgress(activeShell, compilationUnits, conversionResults);
		boolean hasConversionFailures = any(conversionResults.values(), new Predicate<ConversionResult>() {
			public boolean apply(ConversionResult input) {
				return input.getProblems().iterator().hasNext();
			}
		});
		if (hasConversionFailures) {
			ConversionProblemsDialog problemsDialog = new ConversionProblemsDialog(activeShell, conversionResults);
			problemsDialog.open();
			if (problemsDialog.getReturnCode() == Window.CANCEL) {
				return;
			}
		}
		//TODO save decision
		MessageDialog dialogWithToggle = new MessageDialog(activeShell, "Xtend converter", null,
				"Delete Java source files?", MessageDialog.QUESTION_WITH_CANCEL, new String[] {
						IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, IDialogConstants.CANCEL_LABEL }, 0);
		//			dialogWithToggle.setPrefKey("delete_java_files_after_successfull_conversion");
		//			dialogWithToggle.setPrefStore(prefStore.getWritablePreferenceStore());
		final int deleteJavaFiles = dialogWithToggle.open();
		if (deleteJavaFiles == 2) {
			return;
		}
		for (final Entry<ICompilationUnit, ConversionResult> result : conversionResults.entrySet()) {
			ICompilationUnit compilationUnit = result.getKey();
			writeToFile(xtendFileToCreate(compilationUnit), result.getValue().getXtendCode());
			if (deleteJavaFiles == 0) {
				try {
					compilationUnit.delete(true, null);
				} catch (JavaModelException e) {
					handleException("Unable to delete Java file.", e, compilationUnit.getResource());
				}
			}
		}

	}

	private void convertAllWithProgress(final Shell shell, final Set<ICompilationUnit> compilationUnits,
			final Map<ICompilationUnit, ConversionResult> conversionResults) throws ExecutionException {
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				monitor.beginTask("Converting files.", compilationUnits.size());
				try {
					doConvert(compilationUnits, monitor, conversionResults);
				} catch (ExecutionException e) {
					throw new InvocationTargetException(e);
				}
			}
		};
		try {
			new ProgressMonitorDialog(shell).run(false, true, op);
		} catch (InvocationTargetException e) {
			handleException("An exception occures during conversion proccess.", e, null);
		} catch (InterruptedException e) {
		}
	}

	private void doConvert(final Set<ICompilationUnit> compilationUnits, IProgressMonitor monitor,
			Map<ICompilationUnit, ConversionResult> conversionResults) throws ExecutionException {
		for (ICompilationUnit iCompilationUnit : compilationUnits) {
			JavaConverter converter = converterProvider.get();
			ConversionResult conversionResult = converter.toXtend(iCompilationUnit);
			monitor.subTask("Working with " + iCompilationUnit.getElementName());
			if (!conversionResult.getProblems().iterator().hasNext()) {
				IFile file = xtendFileToCreate(iCompilationUnit);
				if (!validateFile(file, conversionResult.getXtendCode())) {
					monitor.subTask("Conversion was not successfull. Re-trying with another strategy.");
					conversionResult = converter.useRobustSyntax().toXtend(iCompilationUnit);
				}
			}
			conversionResults.put(iCompilationUnit, conversionResult);
			monitor.worked(1);
		}
	}

	private IFile xtendFileToCreate(ICompilationUnit iCompilationUnit) {
		IContainer parent = iCompilationUnit.getResource().getParent();
		String xtendFileName = Files.getNameWithoutExtension(iCompilationUnit.getElementName()) + "."
				+ fileExtensionProvider.getPrimaryFileExtension();
		IFile file = parent.getFile(new Path(xtendFileName));
		return file;
	}

	private void writeToFile(IFile file, String content) throws ExecutionException {
		try {
			InputStream source = new ByteArrayInputStream(content.getBytes(file.getCharset()));
			if (!file.exists()) {
				file.create(source, true, null);
			} else {
				file.setContents(source, true, false, null);
			}
		} catch (CoreException e) {
			handleException("Failed to create file.", e, file);
		} catch (UnsupportedEncodingException e) {
			handleException("Failed to write to file.", e, file);
		}
	}

	private boolean validateFile(IFile file, String content) throws ExecutionException {
		ResourceSet set = resourceSetProvider.get(file.getProject());
		Resource resource = set.createResource(URI.createPlatformResourceURI(file.getFullPath().toString(), false));
		try {
			resource.load(new ByteArrayInputStream(content.getBytes(file.getCharset())), null);
		} catch (CoreException e) {
			handleException("Failed to read file content", e, file);
		} catch (IOException e) {
			handleException("Failed to load resource.", e, file);
		}
		if (resource.getErrors().size() == 0) {
			List<Issue> issues = Lists.newArrayList(filter(((XtextResource) resource).getResourceServiceProvider()
					.getResourceValidator().validate(resource, CheckMode.ALL, CancelIndicator.NullImpl),
					new Predicate<Issue>() {
						public boolean apply(Issue issue) {
							return issue.getSeverity() == Severity.ERROR;
						}
					}));
			return issues.size() == 0;
		}
		return false;
	}

	private void handleException(String message, Throwable e, IResource file) throws ExecutionException {
		throw new ExecutionException(message + (file != null ? (" " + file.getFullPath()) : ""), e);
	}
}
