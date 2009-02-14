/*
Generated with Xtext
*/
package org.eclipse.xtext.builtin.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class XtextBuiltinPackratParser extends AbstractPackratParser {
	
	@Inject
	public XtextBuiltinPackratParser(IParseResultFactory parseResultFactory, XtextBuiltinGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected XtextBuiltinParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new XtextBuiltinParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected XtextBuiltinGrammarAccess getGrammarAccess() {
		return (XtextBuiltinGrammarAccess)super.getGrammarAccess();
	}
	
}
