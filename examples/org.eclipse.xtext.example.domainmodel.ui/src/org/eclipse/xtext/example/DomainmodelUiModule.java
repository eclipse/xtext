/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;
import org.eclipse.xtext.example.syntaxcoloring.SemanticHighlightingCalculator;
import org.eclipse.xtext.example.syntaxcoloring.SemanticHighlightingConfiguration;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingConfiguration;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelUiModule extends AbstractDomainmodelUiModule {
	
	public IndexStore bindIndexStore() {
		return EmfIndexUIPlugin.getDefault().getIndexStore();
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlightingCalculator.class;
	}
	
	public Class<? extends ISemanticHighlightingConfiguration> bindISemanticHighlightingConfiguration() {
		return SemanticHighlightingConfiguration.class;
	}
}
