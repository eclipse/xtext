package org.eclipse.xtext.generator.scoping;

import java.util.Collections;
import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;

public class XtendScopingFragment extends AbstractGeneratorFragment {
	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[] {"org.eclipse.xtend","org.eclipse.xtend.typesystem.emf","org.eclipse.xtext.xtend"};
	}
	
	@Override
	public Map<String, String> getGuiceBindingsRt(Grammar grammar) {
		return Collections.singletonMap(IScopeProvider.class.getName(), grammar.getName()+"ScopeProvider");
	}
}
