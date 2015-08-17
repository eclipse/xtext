/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator;

import static org.eclipse.xtend.core.validation.IssueCodes.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtend.core.macro.XAnnotationExtensions;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 * @since 2.4
 */
public class XtendUIValidator extends XbaseUIValidator {

	private static final Logger LOG = Logger.getLogger(XtendUIValidator.class);
	
	@Inject 
	private IStorage2UriMapper storage2UriMapper;
	
	@Inject private XAnnotationExtensions annotationExtensions;
	@Inject private IJavaProjectProvider projectProvider;
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> packages = super.getEPackages();
		packages.add(XtendPackage.eINSTANCE);
		packages.add(XAnnotationsPackage.eINSTANCE);
		return packages;
	}
	
	@Check
	protected void checkAnnotationInSameProject(XAnnotation annotation) throws JavaModelException {
		try {
			if (annotationExtensions.isProcessed(annotation)) {
				JvmType annotationType = annotation.getAnnotationType();
				if (isSameProject(annotation, annotationType)) {
					error("The referenced active annotation cannot be used from within the same project.",XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, -1, ACTIVE_ANNOTAION_IN_SAME_CONTAINER);
				}
			}
		} catch(JavaModelException e) {
			if (!e.isDoesNotExist()) {
				throw e;
			}
		}
	}

	protected boolean isSameProject(XAnnotation annotation, JvmType annotationType) throws JavaModelException {
		IJavaProject project = projectProvider.getJavaProject(annotation.eResource().getResourceSet());
		if (annotationType.eResource().getURI().isPlatformResource()) {
			String projectName = annotationType.eResource().getURI().segments()[1];
			return project.getProject().getName().equals(projectName);
		} else { // assume java type resource
			IType type = project.findType(annotationType.getIdentifier());
			if (type != null && type.getUnderlyingResource() instanceof IFile) {
				return isInSourceFolder(project, (IFile) type.getUnderlyingResource());
			}
			return false;
		}
	}
	
	protected boolean isInSourceFolder(IJavaProject javaProject, IFile resource) {
		IPath path = resource.getFullPath();
		IClasspathEntry[] classpath;
		try {
			classpath = javaProject.getResolvedClasspath(true);
		} catch(JavaModelException e){
			return false; // not a Java project
		}
		for (int i = 0; i < classpath.length; i++) {
			IClasspathEntry entry = classpath[i];
			if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				IPath entryPath = entry.getPath();
				if (entryPath.isPrefixOf(path)) {
					return true;
				}
			}
		}
		return false;
	}

	@Check
	public void checkFileNamingConventions(XtendFile xtendFile) {
		String expectedPackage = getExpectedPackageName(xtendFile);
		String declaredPackage = xtendFile.getPackage();
		if(expectedPackage != null && !((isEmpty(expectedPackage) && declaredPackage == null) || expectedPackage.equals(declaredPackage))) {
			error("The declared package '" + notNull(declaredPackage) + "' does not match the expected package '" + notNull(expectedPackage) + "'",
					XtendPackage.Literals.XTEND_FILE__PACKAGE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.WRONG_PACKAGE, expectedPackage);
		}

		if (xtendFile.getXtendTypes().size() == 1) {
			XtendTypeDeclaration xtendType = xtendFile.getXtendTypes().get(0);
			String currentFileName = xtendFile.eResource().getURI().trimFileExtension().lastSegment();
			String expectedFileName = xtendType.getName();
			if (expectedFileName != null && !equal(currentFileName, expectedFileName)) {
				addIssue("The type name '" + expectedFileName + "' doesn't match the file name '" + currentFileName + "'",
						xtendType, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.WRONG_FILE, expectedFileName);
			}
		}
	}
	
	protected String getExpectedPackageName(XtendFile xtendFile) {
		URI fileURI = xtendFile.eResource().getURI();
		for(Pair<IStorage, IProject> storage: storage2UriMapper.getStorages(fileURI)) {
			if(storage.getFirst() instanceof IFile) {
				IPath fileWorkspacePath = storage.getFirst().getFullPath();
				IJavaProject javaProject = JavaCore.create(storage.getSecond());
				if(javaProject != null && javaProject.exists() && javaProject.isOpen()) {
					try {
						for(IPackageFragmentRoot root: javaProject.getPackageFragmentRoots()) {
							if(!root.isArchive() && !root.isExternal()) {
								IResource resource = root.getResource();
								if(resource != null) {
									IPath sourceFolderPath = resource.getFullPath();
									if(sourceFolderPath.isPrefixOf(fileWorkspacePath)) {
										IPath claspathRelativePath = fileWorkspacePath.makeRelativeTo(sourceFolderPath);
										return claspathRelativePath.removeLastSegments(1).toString().replace("/", ".");
									}
								}
							}
						}
					} catch (JavaModelException e) {
						LOG.error("Error resolving expected path for XtendFile", e);
					}
				}
			}
		}
		return null;
	}
}
