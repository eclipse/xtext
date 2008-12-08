/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.service.Inject;

import org.eclipse.xtext.metamodelreferencing.tests.parser.internal.InternalMetamodelRefTestLanguageLexer;
import org.eclipse.xtext.metamodelreferencing.tests.parser.internal.InternalMetamodelRefTestLanguageParser;

public class MetamodelRefTestLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalMetamodelRefTestLanguageLexer lexer = new InternalMetamodelRefTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalMetamodelRefTestLanguageParser parser = new InternalMetamodelRefTestLanguageParser(
				stream, factory, grammarAccess.getGrammar());
		parser.setTokenTypeMap(antlrTokenDefProvider.getTokenDefMap());
		try {
			if(ruleName != null) {
				return parser.parse(ruleName);
			} else {
				return parser.parse();
			}
		} catch (Exception re) {
			throw new ParseException(re.getMessage(),re);
		}
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Foo";
	}
}
