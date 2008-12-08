/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class SimpleReconstrTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = SimpleReconstrTestLanguageAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTestLanguage.tokens");
	}
}
