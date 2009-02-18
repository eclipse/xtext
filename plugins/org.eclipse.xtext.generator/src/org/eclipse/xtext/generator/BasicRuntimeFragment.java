package org.eclipse.xtext.generator;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;

public class BasicRuntimeFragment extends AbstractGeneratorFragment {
	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
	}
	
	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
	}
	
	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
	}
	
	@Override
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
	}
	
	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[]{"org.eclipse.xtext", "org.eclipse.xtext.util"};
	}
}
