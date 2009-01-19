/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class TerminalRulesTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = TerminalRulesTestLanguageAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.tokens");
	}
}
