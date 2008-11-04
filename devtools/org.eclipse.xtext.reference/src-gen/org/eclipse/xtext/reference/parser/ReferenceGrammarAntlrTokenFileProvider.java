/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ReferenceGrammarAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = ReferenceGrammarAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/reference/parser/internal/InternalReferenceGrammar.tokens");
	}
}
