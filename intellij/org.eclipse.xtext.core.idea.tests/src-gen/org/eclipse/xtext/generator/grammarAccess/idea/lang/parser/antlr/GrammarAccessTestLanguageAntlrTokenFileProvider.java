package org.eclipse.xtext.generator.grammarAccess.idea.lang.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class GrammarAccessTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.tokens");
	}
}
