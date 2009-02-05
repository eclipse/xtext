/*
Generated with Xtext
*/
package org.eclipse.xtext.generator.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class LowerCaseNamedTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = LowerCaseNamedTestLanguageAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/generator/parser/antlr/internal/InternalLowerCaseNamedTestLanguage.tokens");
	}
}
