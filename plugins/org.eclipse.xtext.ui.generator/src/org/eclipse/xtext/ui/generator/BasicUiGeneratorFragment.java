package org.eclipse.xtext.ui.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;

public class BasicUiGeneratorFragment extends AbstractGeneratorFragment {

	private List<String> fileExtensions = new ArrayList<String>();

	public void setFileExtensions(String fileExtensions) {
		String[] split = fileExtensions.split("\\s*,\\s*");
		for (String string : split) {
			this.fileExtensions.add(string);
		}
	}

	@Override
	protected List<Object> getParameters() {
		return Collections.singletonList((Object) fileExtensions);
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.eclipse.xtext.ui.core", "org.eclipse.xtext.ui.common", "org.eclipse.ui.editors",
				"org.eclipse.ui" };
	}

}
