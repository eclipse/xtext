/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.GenService;
import org.eclipse.xtext.xtextgen.IGenModelAssembler;
import org.eclipse.xtext.xtextgen.XtextgenFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PackratParserAssembler implements IGenModelAssembler {

	public void assemble(GenModel model) {
		Grammar grammar = model.getGrammar();
		String languageName = GrammarUtil.getName(grammar);
		String namespace = GrammarUtil.getNamespace(grammar);
		GenService packratParser = XtextgenFactory.eINSTANCE.createGenService();
		packratParser.setServiceInterfaceFQName("org.eclipse.xtext.parser.packrat.IPackratParser");
		packratParser.setGenClassFQName(namespace + ".parser.packrat." + languageName + "PackratParser");
		packratParser.setTemplatePath("org::eclipse::xtext::parser::packrat::PackratParserGen::root");
		model.getServices().add(packratParser);
		
		GenService parseResultFactory = XtextgenFactory.eINSTANCE.createGenService();
		parseResultFactory.setServiceInterfaceFQName(IParseResultFactory.class.getName());
		parseResultFactory.setGenClassFQName(ParseResultFactory.class.getName());
		model.getServices().add(parseResultFactory);
	}

}
