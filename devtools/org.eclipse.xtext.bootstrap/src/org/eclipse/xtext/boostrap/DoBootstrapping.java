/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.boostrap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextLanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parser.XtextASTFactory;
import org.eclipse.xtext.parser.XtextParser;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DoBootstrapping {

	public static void main(String[] args) throws Exception {
		XtextStandaloneSetup.doSetup();
		String srcGenPath = "../org.eclipse.xtext/src-gen";
		String filename = "../org.eclipse.xtext/src/org/eclipse/xtext/Xtext.xtext";
		String languageName = "Xtext";
		String languageNamespace = "org/eclipse/xtext";
		String builtinFilename = "../org.eclipse.xtext/src/org/eclipse/xtext/builtin/XtextBuiltIn.xtext";
		String builtinlanguageName = "XtextBuiltIn";
		String builtinlanguageNamespace = "org/eclipse/xtext/builtin";
		
		System.out.println("loading " + filename);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(XtextLanguageFacade.XTEXT_NS_URI, XtextPackage.eINSTANCE);
		
		generate(srcGenPath, filename, languageName, languageNamespace);

//		generate(srcGenPath, builtinFilename, builtinlanguageName, builtinlanguageNamespace);
	}

	private static void generate(String srcGenPath, String filename, String languageName, String languageNamespace)
			throws FileNotFoundException, IOException {
		String modelFileExtension = "xtext";
		InputStream resourceAsStream = new FileInputStream(filename);
		XtextParser xtext2Parser= new XtextParser();
		Grammar grammarModel = (Grammar) xtext2Parser.parse(resourceAsStream, new XtextASTFactory()).getRootASTElement();
		GeneratorFacade.cleanFolder(srcGenPath);
		GeneratorFacade.generate(grammarModel, languageName, languageNamespace, srcGenPath, modelFileExtension);
	}
}
