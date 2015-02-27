package org.eclipse.xtext.parsetree.transientvalues.idea.lang.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class TransientValuesTestAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.tokens");
	}
}
