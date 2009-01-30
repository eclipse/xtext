/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.parser.ISwitchingParser;
import org.eclipse.xtext.parser.ITokenToStringConverter;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.parser.packrat.IPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.xtext.XtextFormattingTokenSerializer;
import org.eclipse.xtext.xtext.XtextLinkingService;
import org.eclipse.xtext.xtext.XtextScopeProvider;
import org.eclipse.xtext.xtext.XtextTransientValueService;

import com.google.inject.Binder;

/**
 * used to register components to be used at runtime.
 */
public class XtextRuntimeModule extends AbstractXtextRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		
	}

	@Override
	protected Class<? extends ILinkingService> getILinkingService() {
		return XtextLinkingService.class;
	}
	
	@Override
	protected Class<? extends IScopeProvider> getIScopeProvider() {
		return XtextScopeProvider.class;
	}
	
	@Override
	protected Class<? extends ILinker> getILinker() {
		return org.eclipse.xtext.xtext.XtextLinker.class;
	}

	@Override
	protected Class<? extends ITransientValueService> getITransientValueService() {
		return XtextTransientValueService.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.AbstractXtextRuntimeModule#getITokenSerializer()
	 */
	@Override
	protected Class<? extends ITokenSerializer> getITokenSerializer() {
		return XtextFormattingTokenSerializer.class;
	}


}
