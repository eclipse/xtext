/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter.parser;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class FormatterTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = FormatterTestLanguageAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.tokens");
	}
}
