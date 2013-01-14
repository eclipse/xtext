/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator;

import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblem;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.JavaModelManager.PerWorkingCopyInfo;
import org.eclipse.jdt.internal.core.JavaModelStatus;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.builder.trace.AbstractTrace;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.4
 */
public class XtendUIValidator extends XbaseUIValidator {

	public static final String JAVADOC_LINKING_ISSUE = "JAVADOC_LINKING_ISSUE";

	@Inject
	protected IEObjectDocumentationProvider documentationProvider;

	@Inject
	protected JvmModelGenerator generator;

	@Inject
	protected IJvmModelAssociations associations;

	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> packages = super.getEPackages();
		packages.add(XtendPackage.eINSTANCE);
		return packages;
	}

	@Check
	public void checkFileNamingConventions(XtendFile xtendFile) {
		//TODO replace usage of CLASSPATH_SCHEME by using IJavaProject
		Resource resource = xtendFile.eResource();
		// editor already closed
		if (resource == null || resource.getResourceSet() == null)
			return;
		URI resourceURI = resource.getURI();
		String packageName = xtendFile.getPackage();
		StringBuilder classpathURIBuilder = new StringBuilder(ClasspathUriUtil.CLASSPATH_SCHEME);
		classpathURIBuilder.append(":/");
		if (packageName != null)
			classpathURIBuilder.append(packageName.replace(".", "/")).append("/");
		classpathURIBuilder.append(resourceURI.lastSegment());
		URI classpathURI = URI.createURI(classpathURIBuilder.toString());
		URIConverter uriConverter = resource.getResourceSet().getURIConverter();
		try {
			URI normalizedURI = uriConverter.normalize(classpathURI);
			if (!resourceURI.equals(normalizedURI))
				reportInvalidPackage(packageName, classpathURI);
		} catch (ClasspathUriResolutionException e) {
			reportInvalidPackage(packageName, classpathURI);
		}
//		XtendClass xtendClass = xtendFile.getXtendClass();
//		if (xtendClass != null && xtendClass.getName() != null
//				&& !equal(resourceURI.trimFileExtension().lastSegment(), xtendClass.getName()))
//			error("The class '" + (packageName!=null ? notNull(packageName) + ".":"") + xtendClass.getName() + "' must be defined in its own file",
//					xtendClass, XtendPackage.Literals.XTEND_CLASS__NAME, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.WRONG_FILE);
	}

	protected void reportInvalidPackage(String packageName, URI classpathURI) {
		error("The declared package '" + notNull(packageName) + "' does not match the expected package",
				XtendPackage.Literals.XTEND_FILE__PACKAGE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.WRONG_PACKAGE);
	}

	@Check
	public void checkJavaDocForClazz(final XtendClass clazz) {
		if (clazz == null)
			return;
		ILineSeparatorInformation lineSeparatorInformation = whitespaceInformationProvider
				.getLineSeparatorInformation(EcoreUtil.getURI(clazz));
		String lineBreak = lineSeparatorInformation.getLineSeparator();
		Object classpathURIContext = ((XtextResourceSet) clazz.eResource().getResourceSet()).getClasspathURIContext();
		if (classpathURIContext instanceof IJavaProject) {
			IJavaProject javaProject = (IJavaProject) classpathURIContext;
			final List<ITrace> traces = Lists.newArrayList();
			IProblemRequestor requestor = new IProblemRequestor() {

				public boolean isActive() {
					return true;
				}

				public void endReporting() {
				}

				public void beginReporting() {
				}

				public void acceptProblem(IProblem problem) {
					if (problem instanceof DefaultProblem) {
						DefaultProblem castedProblem = (DefaultProblem) problem;
						if ((castedProblem.getID() & IProblem.Javadoc) != 0) {
							int offset = castedProblem.getSourceStart();
							int length = castedProblem.getSourceEnd() - offset;
							List<ILocationInResource> allAssociatedLocations = Lists.newArrayList(traces.get(0)
									.getAllAssociatedLocations(new TextRegion(offset, length)));
							if (allAssociatedLocations.size() > 0) {
								ITextRegionWithLineInformation textRegion = allAssociatedLocations.get(0)
										.getTextRegion();
								if (textRegion != null)
									getChain().add(
											createDiagnostic(castedProblem.isError() ? Severity.ERROR
													: Severity.WARNING, castedProblem.getMessage(), clazz, textRegion
													.getOffset(), textRegion.getLength(), castedProblem.getID() == IProblem.JavadocUndefinedType ? IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC : null, new String[0]));
							}
						}
					}
				}
			};
			Pair<CompilationUnit, SimpleTrace> compilationUnitAndTrace = getCompilationUnitAndTrace(javaProject,
					clazz, requestor, lineBreak);
			try {
				CompilationUnit compilationUnit = compilationUnitAndTrace.getFirst();
				traces.add(compilationUnitAndTrace.getSecond());
				compilationUnit.reconcile(ICompilationUnit.NO_AST, true, null,
						new NullProgressMonitor());
			} catch (JavaModelException e) {
				// Ignore
			}
		}

	}

	public Pair<CompilationUnit, SimpleTrace> getCompilationUnitAndTrace(IJavaProject project, final XtendClass clazz,
			final IProblemRequestor requestor, String lineBreak) {
		try {
			final PackageFragment packageFragment = (PackageFragment) project.getPackageFragments()[0];
			CompilationUnit compilationUnit = new CompilationUnit(packageFragment, clazz.getName(),
					new WorkingCopyOwner() {
					}) {
				@Override
				protected IStatus validateExistence(IResource underlyingResource) {
					return JavaModelStatus.VERIFIED_OK;
				}

				@Override
				public PerWorkingCopyInfo getPerWorkingCopyInfo() {
					return new PerWorkingCopyInfo(null, requestor);
				}

				@Override
				public boolean isConsistent() {
					return true;
				}
			};
			List<EObject> jvmElements = Lists.newArrayList(associations.getJvmElements(clazz));
			JvmDeclaredType inferredType = (JvmDeclaredType) jvmElements.get(0);
			CharSequence compiledCode = generator.generateType(inferredType);
			compilationUnit.getBuffer().append(removeSuppressedWarningsAnnotation(compiledCode.toString()));
			AbstractTraceRegion traceRegion = ((ITraceRegionProvider) compiledCode).getTraceRegion();
			return Tuples.create(compilationUnit, new SimpleTrace(traceRegion));
		} catch (Exception e) {
			return null;
		}
	}
	// TODO: Remove this when there are compiler-settings for Xbase to avoid this annotation by configuration
	// For now an easy search and replace
	protected String removeSuppressedWarningsAnnotation(String compiledCodeAsString) {
		String textToReplace = "@SuppressWarnings(\"all\")";
		int annotationOffset = compiledCodeAsString.indexOf(textToReplace);
		if(annotationOffset != -1){
			// To not destroy offset of traces we have to keep the offsets valid by filling in same amount of whitespaces
			String space = "                        ";
			compiledCodeAsString = compiledCodeAsString.substring(0, annotationOffset) + space + compiledCodeAsString.substring(annotationOffset + textToReplace.length());
		}
		return compiledCodeAsString;
	}

	protected class SimpleTrace extends AbstractTrace {
		private final AbstractTraceRegion root;

		public SimpleTrace(AbstractTraceRegion root) {
			this.root = root;
		}

		@Override
		protected AbstractTraceRegion doGetRootTraceRegion() {
			return root;
		}

		@Override
		@NonNull
		public IProject getLocalProject() {
			throw new UnsupportedOperationException();
		}

		@Override
		@NonNull
		public IStorage getLocalStorage() {
			throw new UnsupportedOperationException();
		}
	}

}
