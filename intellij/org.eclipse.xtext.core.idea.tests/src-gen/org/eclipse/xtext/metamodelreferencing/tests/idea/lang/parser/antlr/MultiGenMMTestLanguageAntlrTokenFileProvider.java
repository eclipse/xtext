package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class MultiGenMMTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.tokens");
	}
}
