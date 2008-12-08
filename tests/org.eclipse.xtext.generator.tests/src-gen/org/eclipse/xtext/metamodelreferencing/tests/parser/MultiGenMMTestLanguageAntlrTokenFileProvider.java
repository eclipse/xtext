/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parser;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class MultiGenMMTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = MultiGenMMTestLanguageAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/metamodelreferencing/tests/parser/internal/InternalMultiGenMMTestLanguage.tokens");
	}
}
