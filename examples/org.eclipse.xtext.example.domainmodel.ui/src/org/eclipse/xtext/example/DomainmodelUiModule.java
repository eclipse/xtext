/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.example.syntaxcoloring.SemanticHighlightingCalculator;
import org.eclipse.xtext.example.syntaxcoloring.SemanticHighlightingConfiguration;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IContainer.Manager;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingConfiguration;
import org.eclipse.xtext.ui.core.scoping.namespaces.JavaProjectAwareContainerManager;

import com.google.inject.Binder;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelUiModule extends AbstractDomainmodelUiModule {
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlightingCalculator.class;
	}
	
	public Class<? extends ISemanticHighlightingConfiguration> bindISemanticHighlightingConfiguration() {
		return SemanticHighlightingConfiguration.class;
	}
	
	@Override
	public Class<? extends Manager> bindIContainer$Manager() {
		return JavaProjectAwareContainerManager.class;
	}
	
	@Override
	public Class<? extends IResourceDescriptions> bindIResourceDescriptions() {
		return super.bindIResourceDescriptions();
	}
	
	@Override
	public void configureIResourceDescriptionsBuilderScope(Binder binder) {
		super.configureIResourceDescriptionsBuilderScope(binder);
	}
}
