package org.eclipse.xtext.purexbase.idea;

import org.eclipse.xtext.idea.findusages.WordsScannerProvider;
import org.eclipse.xtext.xbase.idea.findusages.XbaseWordsScanner.XbaseWordsScannerProvider;

public class PureXbaseIdeaModule extends AbstractPureXbaseIdeaModule {
	
	public Class<? extends WordsScannerProvider> bindWordsScannerProvider() {
		return XbaseWordsScannerProvider.class;
	}

}
