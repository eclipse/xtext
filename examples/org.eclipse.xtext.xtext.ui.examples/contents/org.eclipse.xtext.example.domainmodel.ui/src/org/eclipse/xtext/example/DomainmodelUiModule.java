/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.example.labeling.DomainmodelDescriptorLabelProvider;
import org.eclipse.xtext.example.labeling.DomainmodelLabelProvider;
import org.eclipse.xtext.example.quickfix.DomainmodelQuickfixProvider;
import org.eclipse.xtext.example.syntaxcoloring.SemanticHighlightingCalculator;
import org.eclipse.xtext.example.syntaxcoloring.SemanticHighlightingConfiguration;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.core.resource.IDescriptionLabelProvider;
import org.eclipse.xtext.validation.IssueResolutionProvider;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelUiModule extends AbstractDomainmodelUiModule {
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlightingCalculator.class;
	}
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return SemanticHighlightingConfiguration.class;
	}
	
	@Override
	public Class<? extends IssueResolutionProvider> bindIssueResolutionProvider() {
		return DomainmodelQuickfixProvider.class;
	}

	@Override
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return DomainmodelLabelProvider.class;
	}
	
	@Override
	public Class<? extends org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider> bindDelegatingStyledCellLabelProvider$IStyledLabelProvider() {
		return DomainmodelLabelProvider.class;
	}

	public Class<? extends IDescriptionLabelProvider> bindIDescriptionLabelProvider() {
		return DomainmodelDescriptorLabelProvider.class;
	}

}
