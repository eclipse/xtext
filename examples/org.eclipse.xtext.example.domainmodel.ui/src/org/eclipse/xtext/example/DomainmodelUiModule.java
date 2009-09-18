/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.emf.emfindex.EmfIndexPlugin;
import org.eclipse.emf.emfindex.Index;
import org.eclipse.xtext.example.syntaxcoloring.SemanticHighlightingCalculator;
import org.eclipse.xtext.example.syntaxcoloring.SemanticHighlightingConfiguration;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingConfiguration;

import com.google.inject.Provider;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelUiModule extends AbstractDomainmodelUiModule {
	
	@Override
	public Provider<Index> provideIndex() {
		return new Provider<Index>() {
			public Index get() {
				return EmfIndexPlugin.getDefault().getIndex();
			}
		};
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlightingCalculator.class;
	}
	
	public Class<? extends ISemanticHighlightingConfiguration> bindISemanticHighlightingConfiguration() {
		return SemanticHighlightingConfiguration.class;
	}
}
