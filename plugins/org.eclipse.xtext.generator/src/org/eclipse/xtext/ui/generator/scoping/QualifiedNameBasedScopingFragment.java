package org.eclipse.xtext.ui.generator.scoping;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;

/**
 * @author Sven Efftinge
 */
public class QualifiedNameBasedScopingFragment extends AbstractGeneratorFragment {
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.xtext.scoping.IScopeProvider",
					"org.eclipse.xtext.scoping.namespaces.IndexBasedQualifiedNameScopeProvider")
			.addTypeToType("org.eclipse.xtext.scoping.namespaces.IndexBasedQualifiedNameScopeProvider.IContainerDependencyProvider",
					"org.eclipse.xtext.ui.core.scoping.namespaces.ContainerDependencyProviderIProjectImpl")
			.addTypeToType("org.eclipse.xtext.ui.core.editor.IXtextEditorCallback",
					"org.eclipse.xtext.ui.core.editor.IXtextEditorCallback.NullImpl")
			.addTypeToProvider("org.eclipse.emf.emfindex.Index", 
					"org.eclipse.xtext.ui.core.builder.IndexProvider")
			.getBindings();
	}

	private String fileExtensions;
	
	public void setFileExtensions(String fileExtensions) {
		this.fileExtensions = fileExtensions;
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.singletonList((Object)fileExtensions);
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui.common",
				"org.eclipse.xtext.ui.core"
		};
	}

}
