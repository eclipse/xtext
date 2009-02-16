/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class BaseInheritanceTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = BaseInheritanceTestLanguageAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalBaseInheritanceTestLanguage.tokens");
	}
}
