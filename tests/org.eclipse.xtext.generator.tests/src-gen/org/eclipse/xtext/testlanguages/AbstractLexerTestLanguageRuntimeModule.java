/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.service.DefaultRuntimeModule;
import org.eclipse.xtext.service.IServiceScope;

import com.google.inject.Binder;

/**
 * GENERATED! Manual modification goes to LexerTestLanguageRuntimeModule
 */
public abstract class AbstractLexerTestLanguageRuntimeModule extends DefaultRuntimeModule {
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(IServiceScope.class).toInstance(org.eclipse.xtext.testlanguages.ILexerTestLanguage.SCOPE);
	}
	
	public Class<? extends org.eclipse.xtext.IMetamodelAccess> bindIMetamodelAccess() {
		return org.eclipse.xtext.testlanguages.services.LexerTestLanguageMetamodelAccess.class;
	}
	public Class<? extends org.eclipse.xtext.IGrammarAccess> bindIGrammarAccess() {
		return org.eclipse.xtext.testlanguages.services.LexerTestLanguageGrammarAccess.class;
	}
	public Class<? extends org.eclipse.xtext.parser.IAstFactory> bindIAstFactory() {
		return org.eclipse.xtext.parser.DefaultEcoreElementFactory.class;
	}
	public Class<? extends org.eclipse.xtext.resource.IResourceFactory> bindIResourceFactory() {
		return org.eclipse.xtext.testlanguages.services.LexerTestLanguageResourceFactory.class;
	}
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> bindIParseTreeConstructor() {
		return org.eclipse.xtext.testlanguages.parsetree.reconstr.LexerTestLanguageParseTreeConstructor.class;
	}
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITokenSerializer> bindITokenSerializer() {
		return org.eclipse.xtext.parsetree.reconstr.impl.WhitespacePreservingTokenSerializer.class;
	}
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer.class;
	}
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITransientValueService> bindITransientValueService() {
		return org.eclipse.xtext.parsetree.reconstr.impl.SimpleTransientValueService.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrParser> bindIAntlrParser() {
		return org.eclipse.xtext.testlanguages.parser.antlr.LexerTestLanguageParser.class;
	}
	public Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> bindITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.eclipse.xtext.testlanguages.parser.antlr.LexerTestLanguageAntlrTokenFileProvider.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.eclipse.xtext.testlanguages.parser.antlr.internal.InternalLexerTestLanguageLexer.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.ITokenDefProvider> bindITokenDefProvider() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class;
	}
	public Class<? extends org.eclipse.xtext.parser.packrat.IPackratParser> bindIPackratParser() {
		return org.eclipse.xtext.testlanguages.parser.packrat.LexerTestLanguagePackratParser.class;
	}
	public Class<? extends org.eclipse.xtext.parser.packrat.IParseResultFactory> bindIParseResultFactory() {
		return org.eclipse.xtext.parser.packrat.ParseResultFactory.class;
	}
	public Class<? extends org.eclipse.xtext.parser.ISwitchingParser> bindISwitchingParser() {
		return org.eclipse.xtext.parser.SwitchingParser.class;
	}
	
	
}
