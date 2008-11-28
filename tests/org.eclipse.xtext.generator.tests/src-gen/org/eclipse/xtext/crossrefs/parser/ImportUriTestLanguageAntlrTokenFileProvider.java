/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parser;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ImportUriTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = ImportUriTestLanguageAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.tokens");
	}
}
