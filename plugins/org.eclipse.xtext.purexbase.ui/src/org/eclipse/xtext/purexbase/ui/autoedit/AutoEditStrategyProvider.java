package org.eclipse.xtext.purexbase.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

import com.google.inject.Inject;

public class AutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {
	
	@Inject ReplAutoEdit autoEdit;
	
	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);
		//acceptor.accept(newShortCuts("PI", "PI"));
		acceptor.accept(autoEdit,IDocument.DEFAULT_CONTENT_TYPE);
	}
}
