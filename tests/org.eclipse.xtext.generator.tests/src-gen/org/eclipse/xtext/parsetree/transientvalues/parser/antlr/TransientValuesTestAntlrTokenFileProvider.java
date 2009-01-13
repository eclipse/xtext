/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class TransientValuesTestAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = TransientValuesTestAntlrTokenFileProvider.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.tokens");
	}
}
