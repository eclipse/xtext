package org.eclipse.xtext.ui.generator.scoping;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.ResourceSetGlobalScopeProvider;
import org.eclipse.xtext.scoping.namespaces.IndexGlobalScopeProvider;
import org.eclipse.xtext.scoping.namespaces.QualifiedNameScopeProvider;

/**
 * @author Sven Efftinge
 */
public class QualifiedNameBasedScopingFragment extends AbstractGeneratorFragment {
	
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
		.addConfiguredBinding(IScopeProvider.class.getName() + "Delegate", 
				"binder.bind(" + 
					IScopeProvider.class.getName() + ".class" +
					").annotatedWith(com.google.inject.name.Names.named(" +
					"\"" + AbstractDeclarativeScopeProvider.NAMED_DELEGATE + "\"" +
					")).to("+ QualifiedNameScopeProvider.class.getName() + ".class)")
		.addTypeToType(IGlobalScopeProvider.class.getName(), ResourceSetGlobalScopeProvider.class.getName())
		.getBindings();
	}
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(IGlobalScopeProvider.class.getName(), IndexGlobalScopeProvider.class.getName())
			.addTypeToType("org.eclipse.xtext.scoping.namespaces.IContainerDependencyProvider",
					"org.eclipse.xtext.ui.core.scoping.namespaces.ContainerDependencyProviderIJavaProjectImpl")
			.addTypeToType("org.eclipse.xtext.ui.core.builder.ILanguageBuilder", 
					"org.eclipse.xtext.ui.core.builder.impl.JavaProjectLanguageBuilder")
			.getBindings();
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui.common",
				"org.eclipse.xtext.ui.core",
				"org.eclipse.jdt.core"
		};
	}

}
