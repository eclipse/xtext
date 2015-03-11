package org.eclipse.xtext.parser.unorderedGroups.idea.lang.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class BacktrackingBug325745TestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/unorderedGroups/idea/parser/antlr/internal/PsiInternalBacktrackingBug325745TestLanguage.tokens");
	}
}
