package org.eclipse.xtext;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class AbstractXtextRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.IXtext.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.services.XtextGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.services.XtextMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.parser.XtextParser.class)
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, org.eclipse.xtext.parser.XtextAntlrTokenFileProvider.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.services.XtextResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.parsetree.reconstr.XtextParseTreeConstructor.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructorCallback.class, org.eclipse.xtext.parsetree.reconstr.callbacks.WhitespacePreservingCallback.class)
		.with(org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer.class, org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer.class)
		.with(org.eclipse.xtext.parser.antlr.Lexer.class, org.eclipse.xtext.parser.internal.InternalXtextLexer.class)
		
			.registrations();
	}

}
			
