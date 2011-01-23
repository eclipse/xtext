/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.validation;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xtend2.xtend2.Xtend2Package.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class Xtend2JavaValidator extends XbaseJavaValidator {

	@Inject
	private RichStringProcessor richStringProcessor;
	
	public static final String WRONG_PACKAGE = Xtend2JavaValidator.class.getName() + ".wrong_package";
	public static final String WRONG_FILE = Xtend2JavaValidator.class.getName() + ".wrong_file";

	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(Xtend2Package.eINSTANCE, XbasePackage.eINSTANCE);
	}

	@Check
	public void checkFileNamingConventions(XtendFile xtendFile) {
		Resource resource = xtendFile.eResource();
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
			error("The class '" + notNull(packageName) + "." + xtendClass.getName() + "' must be defined in its own file",
					xtendClass, Literals.XTEND_CLASS__NAME, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, WRONG_FILE);
	}

	protected void reportInvalidPackage(String packageName, URI classpathURI) {
		error("The declared package '" + notNull(packageName) + "' does not match the expected package", 
				Literals.XTEND_FILE__PACKAGE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, WRONG_PACKAGE);
	}
	
	@Check
	public void checkWhitespaceInRichStrings(RichString richString) {
		// don't check the indentation of nested rich strings in 
		// IF and FOR individually
		if (richString.eContainer() instanceof RichStringIf) {
			RichStringIf container = (RichStringIf) richString.eContainer();
			if (container.getThen() == richString || container.getElse() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringElseIf) {
			RichStringElseIf container = (RichStringElseIf) richString.eContainer();
			if (container.getThen() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringForLoop) {
			RichStringForLoop container = (RichStringForLoop) richString.eContainer();
			if (container.getEachExpression() == richString)
				return;
		}
		doCheckWhitespaceIn(richString);
	}

	protected void doCheckWhitespaceIn(RichString richString) {
		ValidatingRichStringAcceptor helper = new ValidatingRichStringAcceptor(this);
		richStringProcessor.process(richString, helper, helper);
	}
}
