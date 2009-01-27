/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.apache.log4j.Logger;
import org.eclipse.xtext.parser.packrat.PackratParserAssembler;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.IGenModelAssembler;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserAssembler implements IGenModelAssembler {

	private static final Logger log = Logger.getLogger(ParserAssembler.class);
	
	// TODO use properties file?
	private static final String[] ALL_PARSER_ASSEMBLERS = {
		"de.itemis.xtext.antlr.XtextAntlrConnector"
	};
	
	public void assemble(GenModel model) {
		for (String className: ALL_PARSER_ASSEMBLERS) {
			IGenModelAssembler assembler = findAssemblerByName(className);
			if (assembler != null) {
				if (log.isTraceEnabled())
					log.trace("Using parser assembler '" + className + "'");
				assembler.assemble(model);
				break;
			}
		}
		if (log.isTraceEnabled())
			log.trace("Using default parser assembler '" + PackratParserAssembler.class.getName() + "'");
		IGenModelAssembler defaultAssembler = new PackratParserAssembler();
		defaultAssembler.assemble(model);
	}
	
	private IGenModelAssembler findAssemblerByName(String className) {
		try {
			Class<? extends IGenModelAssembler> clazz = Class.forName(className).asSubclass(IGenModelAssembler.class);
			return clazz.newInstance();
		}
		catch (ClassNotFoundException e) {
			log.trace("Cannot find class '" + className + "'", e);
			return null;
		}
		catch (ClassCastException e) {
			log.trace("Cannot cast class '" + className + "' to IGenModelAssembler", e);
			return null;
		}
		catch (InstantiationException e) {
			log.trace("Cannot instantiate instance of class '" + className + "'", e);
			return null;
		}
		catch (IllegalAccessException e) {
			log.trace("Cannot access default constructor of class '" + className + "'", e);
			return null;
		}
	}

}
