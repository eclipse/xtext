/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.boostrap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GenerateXtextGrammars {
	private static final String uiPath = "../org.eclipse.xtext.xtext.ui_gen";
	private static final Logger logger = Logger.getLogger(GenerateXtextGrammars.class);

	public static void main(String[] args) throws Exception {
		EcorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.getNsURI();
		XtextStandaloneSetup.doSetup();
		String srcGenPath = "../org.eclipse.xtext/src-gen";
		String filename = "../org.eclipse.xtext/src/org/eclipse/xtext/Xtext.xtext";
		String languageName = "Xtext";
		String languageNamespace = "org/eclipse/xtext";
		logger.info("loading " + filename);
		XtextStandaloneSetup.doSetup();

		GeneratorFacade.cleanFolder(srcGenPath);
		generate(srcGenPath, filename, languageName, languageNamespace);
	}

	private static void generate(String srcGenPath, String filename, String languageName, String languageNamespace)
			throws FileNotFoundException, IOException {
		ResourceSet rs = new XtextResourceSet();
		XtextResource resource = (XtextResource) rs.createResource(URI.createURI(filename));
		resource.load(null);
		List<SyntaxError> parseErrors = resource.getParseResult().getParseErrors();
		for (SyntaxError syntaxError : parseErrors) {
			logger.error(syntaxError.getMessage());
		}
		Grammar grammarModel = (Grammar) resource.getContents().iterator().next();
		GeneratorFacade.generate(grammarModel, srcGenPath, uiPath, "xtext", "xtext2");
	}
}
