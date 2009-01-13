package org.eclipse.xtext.valueconverter;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public abstract class AbstractBug250313RuntimeConfig extends AbstractServiceRegistrationFactory {

	protected Class<? extends org.eclipse.xtext.IMetamodelAccess> getIMetamodelAccess() {
		return org.eclipse.xtext.valueconverter.services.Bug250313MetamodelAccess.class;
	}
		
	protected Class<? extends org.eclipse.xtext.IGrammarAccess> getIGrammarAccess() {
		return org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.packrat.IPackratParser> getIPackratParser() {
		return org.eclipse.xtext.valueconverter.parser.packrat.Bug250313PackratParser.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.IAstFactory> getIAstFactory() {
		return org.eclipse.xtext.parser.antlr.AntlrEcoreElementFactory.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.IParser> getIParser() {
		return org.eclipse.xtext.valueconverter.parser.antlr.Bug250313Parser.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> getIAntlrTokenFileProvider() {
		return org.eclipse.xtext.valueconverter.parser.antlr.Bug250313AntlrTokenFileProvider.class;
	}
		
	protected Class<? extends org.eclipse.xtext.resource.IResourceFactory> getIResourceFactory() {
		return org.eclipse.xtext.valueconverter.services.Bug250313ResourceFactory.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> getIParseTreeConstructor() {
		return org.eclipse.xtext.valueconverter.parsetree.reconstr.Bug250313ParseTreeConstructor.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ITokenSerializer> getITokenSerializer() {
		return org.eclipse.xtext.parsetree.reconstr.impl.WhitespacePreservingTokenSerializer.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer> getICrossReferenceSerializer() {
		return org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ITransientValueService> getITransientValueService() {
		return org.eclipse.xtext.parsetree.reconstr.impl.SimpleTransientValueService.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.antlr.Lexer> getLexer() {
		return org.eclipse.xtext.valueconverter.parser.antlr.internal.InternalBug250313Lexer.class;
	}
		
	
	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.valueconverter.IBug250313.SCOPE)
		.with(org.eclipse.xtext.IMetamodelAccess.class, getIMetamodelAccess())
		.with(org.eclipse.xtext.IGrammarAccess.class, getIGrammarAccess())
		.with(org.eclipse.xtext.parser.packrat.IPackratParser.class, getIPackratParser())
		.with(org.eclipse.xtext.parser.IAstFactory.class, getIAstFactory())
		.with(org.eclipse.xtext.parser.IParser.class, getIParser())
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, getIAntlrTokenFileProvider())
		.with(org.eclipse.xtext.resource.IResourceFactory.class, getIResourceFactory())
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, getIParseTreeConstructor())
		.with(org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.class, getITokenSerializer())
		.with(org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer.class, getICrossReferenceSerializer())
		.with(org.eclipse.xtext.parsetree.reconstr.ITransientValueService.class, getITransientValueService())
		.with(org.eclipse.xtext.parser.antlr.Lexer.class, getLexer())
		
			.registrations();
	}

}
			
