/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.integration.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class TestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = TestLanguageAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.tokens");
	}
}
