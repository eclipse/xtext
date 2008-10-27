/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parser;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class Bug250313AntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = Bug250313AntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/valueconverter/parser/internal/InternalBug250313.tokens");
	}
}
