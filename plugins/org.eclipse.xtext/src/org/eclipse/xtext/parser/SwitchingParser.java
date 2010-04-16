/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.InputStream;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.parser.packrat.IPackratParser;
import org.eclipse.xtext.parsetree.CompositeNode;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
public class SwitchingParser implements ISwitchingParser {

	private static final Logger log = Logger.getLogger(SwitchingParser.class);
	private static boolean usePackrat;

	static {
		String param = System.getProperty("org.eclipse.xtext.parser");
		usePackrat = param != null && param.equals("packrat");
	}

	@Inject(optional=true)
	private IAntlrParser antlrParser;

	@Inject(optional=true)
	private IPackratParser packratParser;

	private boolean displayed = false;

	private void displayPackratInfo() {
		if (!displayed && !usePackrat)
			log.info("Using packrat parser.\n" +
				"If this is not desired, regenerate your language and ensure project 'de.itemis.xtext.antlr' is on your classpath.");
		displayed = true;
	}

	@Deprecated
	public IParseResult parse(InputStream in) {
		if (antlrParser != null && !usePackrat) {
			return antlrParser.parse(in);
		}
		displayPackratInfo();
		return packratParser.parse(in);
	}
	
	public IParseResult parse(Reader reader) {
		if (antlrParser != null && !usePackrat) {
			return antlrParser.parse(reader);
		}
		displayPackratInfo();
		return packratParser.parse(reader);
	}

	public IParseResult reparse(CompositeNode originalRootNode, int offset, int length, String change) {
		if (antlrParser != null && !usePackrat) {
			return antlrParser.reparse(originalRootNode, offset, length, change);
		}
		displayPackratInfo();
		return packratParser.reparse(originalRootNode, offset, length, change);
	}

	public static boolean isUsePackrat() {
		return usePackrat;
	}

	public static void setUsePackrat(boolean usePackrat) {
		SwitchingParser.usePackrat = usePackrat;
	}

	public IAntlrParser getAntlrParser() {
		return antlrParser;
	}

	public void setAntlrParser(IAntlrParser antlrParser) {
		this.antlrParser = antlrParser;
	}

	public IPackratParser getPackratParser() {
		return packratParser;
	}

	public void setPackratParser(IPackratParser packratParser) {
		this.packratParser = packratParser;
	}

}
