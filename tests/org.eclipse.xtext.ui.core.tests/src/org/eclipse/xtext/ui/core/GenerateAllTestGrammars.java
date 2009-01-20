/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GenerateAllTestGrammars {
	private static String path = ".";

	private static Logger log = Logger.getLogger(GenerateAllTestGrammars.class);

	public final static Class<?>[] testclasses = new Class[] { TestLanguage.class };

	public static void main(String... args) throws Exception {
		try {
			log.info(Thread.currentThread().getContextClassLoader());
			XtextStandaloneSetup.doSetup();
			if (args.length > 0) {
				path = args[0] + "/" + path;
			}
			GeneratorFacade.cleanFolder(path + "/src-gen");
			for (Class<?> c : testclasses) {
				String filename = "classpath:/" + c.getName().replace('.', '/') + ".xtext";
				log.info("loading " + filename);
				ResourceSetImpl rs = new XtextResourceSet();
				URI uri = URI.createURI(filename);
				Resource resource = rs.createResource(uri);
				resource.load(null);
				Grammar grammarModel = (Grammar) resource.getContents().iterator().next();
				GeneratorFacade.generate(grammarModel, path, null, c.getSimpleName().toLowerCase());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
