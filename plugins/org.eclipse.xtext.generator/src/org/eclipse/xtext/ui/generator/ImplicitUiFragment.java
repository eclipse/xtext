package org.eclipse.xtext.ui.generator;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;

public class ImplicitUiFragment extends AbstractGeneratorFragment {

	private final List<String> fileExtensions;

	public ImplicitUiFragment(List<String> fileExtensions2) {
		this.fileExtensions = fileExtensions2;
	}

	@Override
	protected List<Object> getParameters(Grammar g) {
		return Collections.singletonList((Object) fileExtensions);
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] {
				"org.eclipse.xtext.ui",
				"org.eclipse.xtext.ui.shared",
				"org.eclipse.ui.editors",
				"org.eclipse.ui" };
	}
	
}
