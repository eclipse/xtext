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

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
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
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> packages = super.getEPackages();
		packages.add(XtendPackage.eINSTANCE);
		return packages;
	}

	@Check
	public void checkFileNamingConventions(XtendFile xtendFile) {
		String expectedPackage = getExpectedPackageName(xtendFile);
		String declaredPackage = xtendFile.getPackage();
		if(expectedPackage != null && !((isEmpty(expectedPackage) && declaredPackage == null) || expectedPackage.equals(declaredPackage))) {
			error("The declared package '" + notNull(declaredPackage) + "' does not match the expected package '" + notNull(expectedPackage) + "'",
					XtendPackage.Literals.XTEND_FILE__PACKAGE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.WRONG_PACKAGE, expectedPackage);
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
