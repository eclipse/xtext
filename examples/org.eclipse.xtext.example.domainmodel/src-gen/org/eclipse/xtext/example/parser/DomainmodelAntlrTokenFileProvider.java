/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class DomainmodelAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = DomainmodelAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/internal/InternalDomainmodel.tokens");
	}
}
