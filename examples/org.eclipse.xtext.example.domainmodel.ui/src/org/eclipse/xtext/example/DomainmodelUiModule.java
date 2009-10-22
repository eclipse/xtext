/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.example.syntaxcoloring.SemanticHighlightingCalculator;
import org.eclipse.xtext.example.syntaxcoloring.SemanticHighlightingConfiguration;
import org.eclipse.xtext.scoping.namespaces.IContainerDependencyProvider;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingConfiguration;
import org.eclipse.xtext.ui.core.scoping.namespaces.ContainerDependencyProviderIProjectImpl;


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
	public Class<? extends IContainerDependencyProvider> bindIContainerDependencyProvider() {
		return ContainerDependencyProviderIProjectImpl.class;
	}
	
	@Override
	public Class<? extends org.eclipse.xtext.ui.core.builder.ILanguageBuilder> bindILanguageBuilder() {
		return org.eclipse.xtext.ui.core.builder.impl.SimpleProjectLanguageBuilder.class;
	}
}
