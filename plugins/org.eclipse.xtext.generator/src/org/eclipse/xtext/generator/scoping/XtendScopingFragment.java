package org.eclipse.xtext.generator.scoping;

import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;

public class XtendScopingFragment extends AbstractGeneratorFragment {
	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[] {"org.eclipse.xtend","org.eclipse.xtext.xtend"};
	}
	
	@Override
	public Map<BindKey, BindValue> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
		.addTypeToType(IScopeProvider.class.getName(), grammar.getName()+"ScopeProvider")
		.getBindings();
	}
}
