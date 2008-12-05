package org.eclipse.xtext;

import org.eclipse.xtext.service.ILanguageService;

public interface IGrammarAccess extends ILanguageService {

	public interface IAbstractRuleAccess {
		public AbstractRule getRule();
	}
	
	public interface IParserRuleAccess extends IAbstractRuleAccess {
		public ParserRule getRule();
	}

	public Grammar getGrammar();

	public IGrammarAccess getSuperGrammar();

}
