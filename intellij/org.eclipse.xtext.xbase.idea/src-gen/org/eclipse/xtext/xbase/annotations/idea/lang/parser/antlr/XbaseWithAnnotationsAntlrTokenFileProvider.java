package org.eclipse.xtext.xbase.annotations.idea.lang.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class XbaseWithAnnotationsAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/xbase/annotations/idea/parser/antlr/internal/PsiInternalXbaseWithAnnotations.tokens");
	}
}
