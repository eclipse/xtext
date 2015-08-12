package org.eclipse.xtext.grammarinheritance.idea.lang.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class InheritanceTest3LanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalInheritanceTest3Language.tokens");
	}
}
