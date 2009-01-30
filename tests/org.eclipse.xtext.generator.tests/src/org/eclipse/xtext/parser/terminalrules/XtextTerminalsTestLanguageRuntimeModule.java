/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.xtext.XtextLinker;
import org.eclipse.xtext.xtext.XtextLinkingService;
import org.eclipse.xtext.xtext.XtextScopeProvider;
import org.eclipse.xtext.xtext.XtextTransientValueService;

import com.google.inject.Binder;

/**
 * used to register components to be used within the IDE.
 */
public class XtextTerminalsTestLanguageRuntimeModule extends AbstractXtextTerminalsTestLanguageRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}
	
	@Override
	protected Class<? extends IValueConverterService> getIValueConverterService() {
		return TerminalRuleTestLanguageConverters.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.DefaultRuntimeModule#getIScopeProvider()
	 */
	@Override
	protected Class<? extends IScopeProvider> getIScopeProvider() {
		return XtextScopeProvider.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.DefaultRuntimeModule#getILinker()
	 */
	@Override
	protected Class<? extends ILinker> getILinker() {
		return XtextLinker.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.DefaultRuntimeModule#getILinkingService()
	 */
	@Override
	protected Class<? extends ILinkingService> getILinkingService() {
		return XtextLinkingService.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parser.terminalrules.AbstractXtextTerminalsTestLanguageRuntimeModule#getITransientValueService()
	 */
	@Override
	protected Class<? extends ITransientValueService> getITransientValueService() {
		return XtextTransientValueService.class;
	}
	
}
