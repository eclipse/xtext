/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.IOException;
import java.io.Writer;

import org.antlr.Tool;
import org.antlr.tool.Grammar;
import org.eclipse.xtext.util.TailWriter;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class AntlrToolRunner {
    
    public static void run(String grammarFullPath) {        
        Tool antlr = new Tool(new String[] { grammarFullPath }) {
        	/**
        	 * Use a writer that suppresses the first comment line of java files, because
        	 * we don't want to have a timestamp in our generated parsers and lexers.
        	 */
			@Override
			public Writer getOutputFile(Grammar g, String fileName) throws IOException {
				Writer result = super.getOutputFile(g, fileName);
				if (fileName.endsWith(".java"))
					result = new TailWriter(result, 2);
				return result;
			}
        };
        antlr.process();
    }
}
