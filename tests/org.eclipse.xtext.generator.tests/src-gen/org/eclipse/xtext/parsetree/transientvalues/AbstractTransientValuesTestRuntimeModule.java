/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues;

import org.eclipse.xtext.service.DefaultRuntimeModule;
import org.eclipse.xtext.service.IServiceScope;

import com.google.inject.Binder;

/**
 * GENERATED! Manual modification goes to TransientValuesTestRuntimeModule
 */
public abstract class AbstractTransientValuesTestRuntimeModule extends DefaultRuntimeModule {
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(IServiceScope.class).toInstance(org.eclipse.xtext.parsetree.transientvalues.ITransientValuesTest.SCOPE);
	}
	
	public Class<? extends org.eclipse.xtext.IMetamodelAccess> bindIMetamodelAccess() {
		return org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestMetamodelAccess.class;
	}
	public Class<? extends org.eclipse.xtext.IGrammarAccess> bindIGrammarAccess() {
		return org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess.class;
	}
	public Class<? extends org.eclipse.xtext.parser.IAstFactory> bindIAstFactory() {
		return org.eclipse.xtext.parser.DefaultEcoreElementFactory.class;
	}
	public Class<? extends org.eclipse.xtext.resource.IResourceFactory> bindIResourceFactory() {
		return org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestResourceFactory.class;
	}
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> bindIParseTreeConstructor() {
		return org.eclipse.xtext.parsetree.transientvalues.parsetree.reconstr.TransientValuesTestParseTreeConstructor.class;
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
		return org.eclipse.xtext.parsetree.transientvalues.parser.antlr.TransientValuesTestParser.class;
	}
	public Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> bindITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.eclipse.xtext.parsetree.transientvalues.parser.antlr.TransientValuesTestAntlrTokenFileProvider.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.eclipse.xtext.parsetree.transientvalues.parser.antlr.internal.InternalTransientValuesTestLexer.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.ITokenDefProvider> bindITokenDefProvider() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class;
	}
	public Class<? extends org.eclipse.xtext.parser.packrat.IPackratParser> bindIPackratParser() {
		return org.eclipse.xtext.parsetree.transientvalues.parser.packrat.TransientValuesTestPackratParser.class;
	}
	public Class<? extends org.eclipse.xtext.parser.packrat.IParseResultFactory> bindIParseResultFactory() {
		return org.eclipse.xtext.parser.packrat.ParseResultFactory.class;
	}
	public Class<? extends org.eclipse.xtext.parser.ISwitchingParser> bindISwitchingParser() {
		return org.eclipse.xtext.parser.SwitchingParser.class;
	}
	
	
}
