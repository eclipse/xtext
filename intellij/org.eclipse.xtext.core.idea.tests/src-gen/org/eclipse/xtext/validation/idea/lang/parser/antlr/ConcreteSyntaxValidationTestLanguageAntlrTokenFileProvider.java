package org.eclipse.xtext.validation.idea.lang.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ConcreteSyntaxValidationTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.tokens");
	}
}
