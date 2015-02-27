package org.eclipse.xtext.xtext.ecoreInference.idea.lang.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class MultiValueFeatureTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalMultiValueFeatureTestLanguage.tokens");
	}
}
