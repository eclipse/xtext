/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class InheritanceTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = InheritanceTestLanguageAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.tokens");
	}
}
