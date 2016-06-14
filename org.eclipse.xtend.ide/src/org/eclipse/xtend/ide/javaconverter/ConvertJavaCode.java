/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.javaconverter;

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

import org.apache.log4j.Logger;
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
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend.core.javaconverter.JavaConverter.ConversionResult;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.TypedPreferenceValues;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.util.DontAskAgainDialogs;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author dhuebner - Initial contribution and API
 */
public class ConvertJavaCode {
	private static String DELETE_JAVA_FILES_AFTER_CONVERSION = "delete_java_file_after_conversion";

	private @Inject Provider<JavaConverter> converterProvider;
	private @Inject IResourceSetProvider resourceSetProvider;
	private @Inject FileExtensionProvider fileExtensionProvider;
	private @Inject @FormatterPreferences IPreferenceValuesProvider cfgProvider;
	private @Inject IFormatter2 formatter;
	private @Inject Provider<TextRegionAccessBuilder> regionAccessBuilder;
	private @Inject DontAskAgainDialogs dialogs;
	private static final Logger LOG = Logger.getLogger(ConvertJavaCode.class);

	public void runJavaConverter(final Set<ICompilationUnit> compilationUnits, Shell activeShell)
			throws ExecutionException {
		Map<ICompilationUnit, ConversionResult> conversionResults = newHashMap();
		boolean canceled = convertAllWithProgress(activeShell, compilationUnits, conversionResults);
		if (canceled) {
			return;
		}
		boolean hasConversionFailures = any(conversionResults.values(), new Predicate<ConversionResult>() {
			@Override
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

		final String storedValue = dialogs.getUserDecision(DELETE_JAVA_FILES_AFTER_CONVERSION);

		boolean deleteJavaFiles = false;
		if (MessageDialogWithToggle.PROMPT.equals(storedValue)) {
			int userAnswer = dialogs.askUser("Delete Java source files?", "Xtend converter",
					DELETE_JAVA_FILES_AFTER_CONVERSION, activeShell);
			if (userAnswer == IDialogConstants.CANCEL_ID) {
				//cancel
				return;
			} else if (userAnswer == IDialogConstants.YES_ID) {
				deleteJavaFiles = true;
			}
		} else if (MessageDialogWithToggle.ALWAYS.equals(storedValue)) {
			deleteJavaFiles = true;
		}
		for (final Entry<ICompilationUnit, ConversionResult> result : conversionResults.entrySet()) {
			ICompilationUnit compilationUnit = result.getKey();
			ConversionResult conversionResult = result.getValue();
			String xtendCode = conversionResult.getXtendCode();
			IFile xtendFileToCreate = xtendFileToCreate(compilationUnit);
			if (!conversionResult.getProblems().iterator().hasNext()) {
				String formattedCode = formatXtendCode(xtendFileToCreate, xtendCode);
				if (formattedCode != null) {
					xtendCode = formattedCode;
				}
			}
			writeToFile(xtendFileToCreate, xtendCode);
			if (deleteJavaFiles) {
				try {
					compilationUnit.delete(true, null);
				} catch (JavaModelException e) {
					handleException("Unable to delete Java file.", e, compilationUnit.getResource());
				}
			}
		}

	}

	/**
	 * @return <code>true</code> if canceled by user
	 */
	private boolean convertAllWithProgress(final Shell shell, final Set<ICompilationUnit> compilationUnits,
			final Map<ICompilationUnit, ConversionResult> conversionResults) throws ExecutionException {
		IRunnableWithProgress op = new IRunnableWithProgress() {
			@Override
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
			new ProgressMonitorDialog(shell).run(true, true, op);
		} catch (InvocationTargetException e) {
			handleException("An exception occures during conversion proccess.", e, null);
		} catch (InterruptedException e) {
			//interrupted by user
			return true;
		}
		return false;
	}

	private void doConvert(final Set<ICompilationUnit> compilationUnits, IProgressMonitor monitor,
			Map<ICompilationUnit, ConversionResult> conversionResults) throws ExecutionException, InterruptedException {
		for (ICompilationUnit iCompilationUnit : compilationUnits) {
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
			JavaConverter converter = converterProvider.get();
			ConversionResult conversionResult = converter.toXtend(iCompilationUnit);
			monitor.subTask("Working with " + iCompilationUnit.getElementName());
			if (!conversionResult.getProblems().iterator().hasNext()) {
				IFile file = xtendFileToCreate(iCompilationUnit);
				Resource resource = createResource(file, conversionResult.getXtendCode());
				if (!validateResource(resource)) {
					monitor.subTask("Conversion was not successfull. Re-trying with another strategy.");
					conversionResult = converter.useRobustSyntax().toXtend(iCompilationUnit);
				}
			}
			conversionResults.put(iCompilationUnit, conversionResult);
			monitor.worked(1);
		}
	}

	private String formatXtendCode(IFile xtendFile, final String xtendCode) {
		try {
			XtextResource resource = (XtextResource) createResource(xtendFile, xtendCode);
			ITextRegionAccess regionAccess = regionAccessBuilder.get().forNodeModel(resource).create();
			FormatterRequest request = new FormatterRequest();
			request.setAllowIdentityEdits(false);
			request.setTextRegionAccess(regionAccess);
			request.setPreferences(TypedPreferenceValues.castOrWrap(cfgProvider.getPreferenceValues(resource)));
			List<ITextReplacement> replacements = formatter.format(request);
			String formatted = regionAccess.getRewriter().renderToString(replacements);
			return formatted;
		} catch (Exception e) {
			LOG.error("Formatting step canceled due to an exception.", e);
			return null;
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

	private boolean validateResource(Resource resource) {
		if (resource.getErrors().size() == 0) {
			List<Issue> issues = Lists.newArrayList(filter(((XtextResource) resource).getResourceServiceProvider()
					.getResourceValidator().validate(resource, CheckMode.ALL, CancelIndicator.NullImpl),
					new Predicate<Issue>() {
						@Override
						public boolean apply(Issue issue) {
							String code = issue.getCode();
							return issue.getSeverity() == Severity.ERROR
									&& !(IssueCodes.DUPLICATE_TYPE.equals(code) || org.eclipse.xtend.core.validation.IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH
											.equals(code));
						}
					}));
			return issues.size() == 0;
		}
		return false;
	}

	private Resource createResource(IFile file, String content) throws ExecutionException {
		ResourceSet set = resourceSetProvider.get(file.getProject());
		Resource resource = set.createResource(URI.createPlatformResourceURI(file.getFullPath().toString(), false));
		try {
			resource.load(new LazyStringInputStream(content, file.getCharset()), null);
		} catch (CoreException e) {
			handleException("Failed to read file content", e, file);
		} catch (IOException e) {
			handleException("Failed to load resource.", e, file);
		}
		return resource;
	}

	private void handleException(String message, Throwable e, IResource file) throws ExecutionException {
		throw new ExecutionException(message + (file != null ? (" " + file.getFullPath()) : ""), e);
	}
}
