package org.eclipse.xtext.ui.generator;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.resource.containers.IAllContainersState;

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
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToProviderInstance(
					IAllContainersState.class.getName(), 
					"org.eclipse.xtext.ui.shared.Access.getJavaProjectsState()")
			.getBindings();
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
