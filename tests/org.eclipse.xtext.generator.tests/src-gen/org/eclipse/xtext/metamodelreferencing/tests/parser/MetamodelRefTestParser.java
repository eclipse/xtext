/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.metamodelreferencing.tests.parser.internal.InternalMetamodelRefTestLexer;
import org.eclipse.xtext.metamodelreferencing.tests.parser.internal.InternalMetamodelRefTestParser;


public class MetamodelRefTestParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalMetamodelRefTestLexer lexer = new InternalMetamodelRefTestLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalMetamodelRefTestParser parser = new InternalMetamodelRefTestParser(
				stream, factory, grammarAccess.getGrammar());
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
