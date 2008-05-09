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
import java.io.InputStream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextEPackageAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.XtextFactory;
import org.eclipse.xtext.parser.XtextParser;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DoBootstrapping {

	public static void main(String[] args) throws Exception {

		String srcGenPath = "../org.eclipse.xtext/src-gen";
		String filename = "../org.eclipse.xtext/src/model/Xtext.xtext";
		String languageName = "Xtext";
		String languageNamespace = "org/eclipse/xtext";
		
		System.out.println("loading " + filename);
		InputStream resourceAsStream = new FileInputStream(filename);
		//TODO make Xtext2Factory manual so one can overwrite 'getEPackages' in order to support generated epackages
		EPackage.Registry.INSTANCE.put(XtextEPackageAccess.XTEXT_NS_URI, XtextPackage.eINSTANCE);
		XtextParser xtext2Parser= new XtextParser();
		Grammar grammarModel = (Grammar) xtext2Parser.parse(resourceAsStream, new XtextFactory());
		GeneratorFacade.generate(grammarModel, languageName, languageNamespace, srcGenPath);
	}
}
