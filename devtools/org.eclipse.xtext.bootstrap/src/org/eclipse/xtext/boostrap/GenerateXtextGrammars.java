/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.boostrap;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
	
	private static final String[] xtextGrammars = new String[]{
		"/src/org/eclipse/xtext/builtin/XtextBuiltin.xtext",
		"/src/org/eclipse/xtext/Xtext.xtext"
	};
	
	private static final String[][] extensions = new String[][] {
		{},
		{"xtext", "xtext2"}
	};
	
	private static final String path = "../org.eclipse.xtext";
	private static final String uiPath = "../org.eclipse.xtext.xtext.ui";
	private static final Logger logger = Logger.getLogger(GenerateXtextGrammars.class);

	public static void main(String[] args) throws Exception {
		try {
			EcorePackage.eINSTANCE.eClass();
			EcorePackage.eINSTANCE.getNsURI();
			XtextStandaloneSetup.doSetup();
			
			GeneratorFacade.cleanFolder(path + "/src-gen");
			GeneratorFacade.cleanFolder(uiPath + "/src-gen");
			
			for (int i = 0; i < xtextGrammars.length; i++) {
				String xtextGrammar = xtextGrammars[i];
				String filename = path + xtextGrammar;
				logger.info("loading " + filename);
	
				
				ResourceSet rs = new XtextResourceSet();
				XtextResource resource = (XtextResource) rs.createResource(URI.createURI(filename));
				resource.load(null);
				List<SyntaxError> parseErrors = resource.getParseResult().getParseErrors();
				for (SyntaxError syntaxError : parseErrors) {
					logger.error(syntaxError.getMessage());
				}
				Grammar grammarModel = (Grammar) resource.getContents().iterator().next();
				GeneratorFacade.generate(grammarModel, path, uiPath, extensions[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
