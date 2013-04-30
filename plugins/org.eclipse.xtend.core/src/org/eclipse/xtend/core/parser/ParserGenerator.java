/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import static org.eclipse.xtext.util.Files.*;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserGenerator extends XtextAntlrGeneratorFragment {

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		String srcGenPath = ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath();
		String absoluteGrammarFileName = srcGenPath+"/"+getGrammarFileName(grammar, getNaming()).replace('.', '/')+".g";
		minifyParser(absoluteGrammarFileName);
	}
	
	protected void minifyParser(String absoluteGrammarFileName) {
		String filename = absoluteGrammarFileName.replaceAll("\\.g$", getParserFileNameSuffix());
		String content = readFileIntoString(filename);
		Minifier minifier = new Minifier(content);
		writeStringIntoFile(filename, minifier.transform());
	}
}
