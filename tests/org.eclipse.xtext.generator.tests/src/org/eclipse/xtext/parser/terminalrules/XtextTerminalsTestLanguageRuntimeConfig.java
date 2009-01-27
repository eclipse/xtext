package org.eclipse.xtext.parser.terminalrules;

import java.util.Set;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.impl.DefaultLinkingService;
import org.eclipse.xtext.crossref.impl.DefaultScopeProvider;
import org.eclipse.xtext.crossref.internal.Linker;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.resource.DefaultFragmentProvider;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.xtext.XtextLinker;
import org.eclipse.xtext.xtext.XtextLinkingService;
import org.eclipse.xtext.xtext.XtextScopeProvider;
import org.eclipse.xtext.xtext.XtextTransientValueService;

/**
 * used to register components to be used at runtime.
 */
public class XtextTerminalsTestLanguageRuntimeConfig extends AbstractXtextTerminalsTestLanguageRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		generated.addAll(
			scope(XtextTerminalsTestLanguageStandaloneSetup.getServiceScope())
				.with(IGrammarAccess.class, getIGrammarAccess())
				.with(IValueConverterService.class, getIValueConverterService())
				.with(IFragmentProvider.class, getIFragmentProvider())
				.with(AntlrTokenDefProvider.class)
				.with(IScopeProvider.class, XtextScopeProvider.class)
				.with(ILinker.class, XtextLinker.class)
				.with(ILinkingService.class, XtextLinkingService.class)
				.with(ITransientValueService.class, XtextTransientValueService.class)
				.registrations());
		return generated;
	}

	protected Class<? extends IFragmentProvider> getIFragmentProvider() {
		return DefaultFragmentProvider.class;
	}

	protected Class<? extends IScopeProvider> getIScopeProvider() {
		return DefaultScopeProvider.class;
	}

	protected Class<? extends ILinkingService> getILinkingService() {
		return DefaultLinkingService.class;
	}

	protected Class<? extends ILinker> getILinker() {
		return Linker.class;
	}

	protected Class<? extends IValueConverterService> getIValueConverterService() {
		return TerminalRuleTestLanguageConverters.class;
	}
}
			
