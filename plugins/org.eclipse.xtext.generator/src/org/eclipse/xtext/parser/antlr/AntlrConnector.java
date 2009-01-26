/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.IGenModelAssembler;
import org.eclipse.xtext.xtextgen.XtextgenFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrConnector implements IGenModelAssembler {

	public void assemble(GenModel model) {
		Grammar grammarModel = model.getGrammar();
		String languageName = GrammarUtil.getName(grammarModel);
		String namespace = GrammarUtil.getNamespace(grammarModel);
		if (!GrammarUtil.isAbstract(grammarModel)) {

			GenService elementFactoryService = XtextgenFactory.eINSTANCE.createGenService();
			elementFactoryService.setServiceInterfaceFQName("org.eclipse.xtext.parser.IAstFactory");
			elementFactoryService.setGenClassFQName("org.eclipse.xtext.parser.antlr.AntlrEcoreElementFactory");
			// no template, as service is generic. Nevertheless, we need the
			// individual registration to avoid conflicts
			elementFactoryService.setExtensionPointID("org.eclipse.xtext.ui.aSTFactory");
			model.getServices().add(elementFactoryService);

			GenService parserService = XtextgenFactory.eINSTANCE.createGenService();
			parserService.setServiceInterfaceFQName("org.eclipse.xtext.parser.IParser");
			parserService.setGenClassFQName(namespace + ".parser.antlr." + languageName + "Parser");
			parserService.setTemplatePath("org::eclipse::xtext::parser::antlr::Parser::root");
			parserService.setExtensionPointID("org.eclipse.xtext.ui.parser");
			model.getServices().add(parserService);

			GenService tokenFileProviderService = XtextgenFactory.eINSTANCE.createGenService();
			tokenFileProviderService
					.setServiceInterfaceFQName("org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider");
			tokenFileProviderService.setGenClassFQName(namespace + ".parser.antlr." + languageName	+ "AntlrTokenFileProvider");
			tokenFileProviderService.setTemplatePath("org::eclipse::xtext::parser::antlr::AntlrTokenFileProvider::root");
			// tokenFileProviderService.setExtensionPointID(
			// "org.eclipse.xtext.ui.parser");
			model.getServices().add(tokenFileProviderService);
			
			GenService tokenScannerService = XtextgenFactory.eINSTANCE.createGenService();
			tokenScannerService.setServiceInterfaceFQName("org.eclipse.xtext.parser.antlr.Lexer");
			tokenScannerService.setGenClassFQName(namespace + ".parser.antlr.internal.Internal" + languageName	+ "Lexer");
			model.getServices().add(tokenScannerService);
		}
	}
	
}
