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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtend.core.conversion.JavaConverter;
import org.eclipse.xtend.core.conversion.JavaConverter.ConversionResult;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class ConvertJavaCodeHandler extends AbstractHandler {
	//	@Inject
	//	private XtextDocumentProvider documentProvider;

	@Inject
	private IResourceSetProvider resourceSetProvider;
	@Inject
	private Provider<JavaConverter> converterProvider;

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) currentSelection;
			final Set<ICompilationUnit> compilationUnits = getCompilationUnits(structuredSelection);
			if (compilationUnits.size() > 0) {
				try {
					IRunnableWithProgress op = new WorkspaceModifyOperation() {
						@Override
						protected void execute(IProgressMonitor monitor) throws CoreException,
								InvocationTargetException, InterruptedException {
							monitor.beginTask("Converting files.", compilationUnits.size());
							try {
								Map<ICompilationUnit, Iterable<String>> failedConversions = doConvert(compilationUnits,
										monitor, false);
								if (failedConversions.size() != 0) {
									String message = Iterables.toString(transform(failedConversions.keySet(),
											new Function<ICompilationUnit, String>() {
												public String apply(ICompilationUnit input) {
													return input.getElementName();
												}
											}));
									throw new ExecutionException("Failed to convert: " + message);
								}
							} catch (ExecutionException e) {
								throw new InvocationTargetException(e);
							}
						}
					};
					new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(true, true, op);
				} catch (InvocationTargetException e) {
					handleException("An exception occures during conversion proccess.", e, null);
				} catch (InterruptedException e) {
				}
			}
		}
		return null;
	}

	private Map<ICompilationUnit, Iterable<String>> doConvert(final Set<ICompilationUnit> compilationUnits,
			IProgressMonitor monitor, boolean forceConversion) throws ExecutionException {
		final Map<ICompilationUnit, Iterable<String>> result = newHashMap();
		for (ICompilationUnit iCompilationUnit : compilationUnits) {
			IContainer parent = iCompilationUnit.getResource().getParent();
			IFile file = parent.getFile(new Path(iCompilationUnit.getElementName() + ".xtend"));
			JavaConverter converter = converterProvider.get();
			ConversionResult conversionResult = converter.toXtend(iCompilationUnit);
			monitor.subTask("Working with " + iCompilationUnit.getElementName());
			if (!forceConversion && conversionResult.getProblems().iterator().hasNext()) {
				result.put(iCompilationUnit, conversionResult.getProblems());
			} else {
				String content = conversionResult.getXtendCode();
				if (!forceConversion && !validateFile(file, content)) {
					monitor.subTask("Conversion was not successfull. Re-trying with another strategy.");
					converter.useRobustSyntax();
					content = converter.toXtend(iCompilationUnit).getXtendCode();
				}
				writeToFile(file, content);
			}
			monitor.worked(1);
		}
		return result;
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

	private Set<ICompilationUnit> getCompilationUnits(IStructuredSelection structuredSelection) {
		Set<ICompilationUnit> result = new HashSet<ICompilationUnit>();
		for (Object element : structuredSelection.toList()) {
			if (element instanceof IJavaElement) {
				IJavaElement elem = (IJavaElement) element;
				if (elem.exists()) {
					switch (elem.getElementType()) {
						case IJavaElement.TYPE:
							if (elem.getParent().getElementType() == IJavaElement.COMPILATION_UNIT) {
								result.add((ICompilationUnit) elem.getParent());
							}
							break;
						case IJavaElement.COMPILATION_UNIT:
							result.add((ICompilationUnit) elem);
							break;
					}
				}
			}
		}
		return result;
	}

	private void handleException(String message, Throwable e, IFile file) throws ExecutionException {
		throw new ExecutionException(message + (file != null ? (" " + file.getFullPath()) : ""), e);
	}
}
