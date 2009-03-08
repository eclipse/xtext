package org.eclipse.xtext.ui.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;

public class BasicUiGeneratorFragment extends AbstractGeneratorFragment {

	private List<String> fileExtensions = new ArrayList<String>();

	public void setFileExtensions(String fileExtensions) {
		if ("".equals(fileExtensions.trim()))
			return;
		String[] split = fileExtensions.split("\\s*,\\s*");
		for (String string : split) {
			this.fileExtensions.add(string);
		}
	}
	
	public List<String> getFileExtensions(Grammar g) {
		if (fileExtensions.isEmpty())
			return Collections.singletonList(GrammarUtil.getName(g).toLowerCase());
		return fileExtensions;
	}

	@Override
	protected List<Object> getParameters(Grammar g) {
		return Collections.singletonList((Object) getFileExtensions(g));
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { 
				"org.eclipse.xtext.ui.core", 
				"org.eclipse.xtext.ui.common", 
				"org.eclipse.ui.editors",
				"org.eclipse.ui" };
	}

}
