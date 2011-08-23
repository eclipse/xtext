/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.validation;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package.Literals;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ClasspathBasedChecks extends AbstractDeclarativeValidator {
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// do nothing
	}

	@Check
	public void checkFileNamingConventions(XtendFile xtendFile) {
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
			if(!resourceURI.equals(normalizedURI))
				reportInvalidPackage(packageName, classpathURI);
		} catch(ClasspathUriResolutionException e) {
			reportInvalidPackage(packageName, classpathURI);
		}
		XtendClass xtendClass = xtendFile.getXtendClass();
		if (xtendClass != null && xtendClass.getName() != null
				&& !equal(resourceURI.trimFileExtension().lastSegment(), xtendClass.getName()))
			error("The class '" + (packageName!=null ? notNull(packageName) + ".":"") + xtendClass.getName() + "' must be defined in its own file",
					xtendClass, Literals.XTEND_CLASS__NAME, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.WRONG_FILE);
	}

	protected void reportInvalidPackage(String packageName, URI classpathURI) {
		error("The declared package '" + notNull(packageName) + "' does not match the expected package", 
				Literals.XTEND_FILE__PACKAGE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.WRONG_PACKAGE);
	}
}
