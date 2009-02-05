/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * Run this class in order to generate the EmfaticDsl grammar.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDsl {
	private Logger log = Logger.getLogger(EcoreDsl.class);

	private static final String PATH = ".";
	private static final String UI_PATH = "../org.eclipse.xtext.example.ecoredsl.ui";

	public void generate() throws IOException {
		XtextStandaloneSetup.doSetup();

		GeneratorFacade.cleanFolder(PATH + "/src-gen");
		GeneratorFacade.cleanFolder(UI_PATH + "/src-gen");

		String classpathUri = "classpath:/org/eclipse/xtext/example/EcoreDsl.xtext";
		log.info("loading " + classpathUri);
		ResourceSet rs = new XtextResourceSet();
		Resource resource = rs.createResource(new ClassloaderClasspathUriResolver().resolve(null, URI
				.createURI(classpathUri)));
		resource.load(null);
		Grammar grammarModel = (Grammar) resource.getContents().get(0);

		GeneratorFacade.generate(grammarModel, PATH, UI_PATH, "ecoredsl");
		log.info("Done.");
	}

	public static void main(String[] args) throws IOException {
		EcoreDsl generator = new EcoreDsl();
		generator.generate();
	}

}
