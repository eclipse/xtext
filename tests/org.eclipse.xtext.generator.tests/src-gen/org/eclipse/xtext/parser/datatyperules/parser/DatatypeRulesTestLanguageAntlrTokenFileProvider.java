/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parser;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class DatatypeRulesTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = DatatypeRulesTestLanguageAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/datatyperules/parser/internal/InternalDatatypeRulesTestLanguage.tokens");
	}
}
