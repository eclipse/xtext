package org.eclipse.xtext.generator.scoping;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.scoping.IScopeProvider;

public class XtendScopingFragment extends AbstractGeneratorFragment {
	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[] {"org.eclipse.xtend","org.eclipse.xtext.xtend"};
	}
	
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
		.addTypeToType(IScopeProvider.class.getName(), grammar.getName()+"ScopeProvider")
		.getBindings();
	}
}
