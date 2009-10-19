package org.eclipse.xtext.ui.generator.scoping;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.scoping.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.namespaces.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.scoping.namespaces.IndexBasedQualifiedNameScopeProvider;
import org.eclipse.xtext.scoping.namespaces.QualifiedNameBasedScopeProvider;

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
						"\"" + IScopeProvider.class.getName() + ".delegate\"" +
						")).to("+ QualifiedNameBasedScopeProvider.class.getName() + ".class)")
		.addTypeToType(IQualifiedNameProvider.class.getName(), 
				DefaultDeclarativeQualifiedNameProvider.class.getName())
		.getBindings();
	}
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addConfiguredBinding(IScopeProvider.class.getName() + "Delegate", 
				"binder.bind(" + 
					IScopeProvider.class.getName() + ".class" +
					").annotatedWith(com.google.inject.name.Names.named(" +
					"\"" + IScopeProvider.class.getName() + ".delegate\"" +
					")).to("+ IndexBasedQualifiedNameScopeProvider.class.getName() + ".class)")
			.addTypeToType("org.eclipse.xtext.scoping.namespaces.IContainerDependencyProvider",
					"org.eclipse.xtext.ui.core.scoping.namespaces.ContainerDependencyProviderIJavaProjectImpl")
			.addTypeToType("org.eclipse.xtext.ui.core.editor.IXtextEditorCallback",
					"org.eclipse.xtext.ui.core.editor.IXtextEditorCallback.NullImpl")
			.addTypeToProvider("org.eclipse.emf.emfindex.store.UpdateableIndex", 
					"org.eclipse.xtext.ui.core.index.IndexProvider")
			.addTypeToType("org.eclipse.xtext.scoping.IQualifiedNameProvider", 
					"org.eclipse.xtext.scoping.namespaces.DefaultDeclarativeQualifiedNameProvider")
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
