/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.outline.actions.IContentOutlineNodeAdapterFactory;
import org.eclipse.xtext.ui.common.editor.outline.transformer.ISemanticModelTransformer;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingConfiguration;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.wizard.IProjectCreator;
import org.eclipse.xtext.xtext.ui.XtextLocationInFileProvider;
import org.eclipse.xtext.xtext.ui.editor.outline.FilteringXtextOutlinePage;
import org.eclipse.xtext.xtext.ui.editor.outline.XtextDeclarativeModelTransformer;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingCalculator;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;

/**
 * used to register components to be used within the IDE.
 */
public class XtextUiModule extends AbstractXtextUiModule {

	@Override
	public Class<? extends ISemanticModelTransformer> bindISemanticModelTransformer() {
		return XtextDeclarativeModelTransformer.class;
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlightingCalculator.class;
	}
	
	public Class<? extends ISemanticHighlightingConfiguration> bindISemanticHighlightingConfiguration() {
		return SemanticHighlightingConfiguration.class;
	}
	
	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return FilteringXtextOutlinePage.class;
	}
	
	public Class<? extends IProjectCreator> bindIProjectCreator() {
		return XtextProjectCreator.class;
	}
	
	@Override
	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return XtextLocationInFileProvider.class;
	}
	
	@Override
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return XtextLabelProvider.class;
	}
	
	public Class<? extends IContentOutlineNodeAdapterFactory> bindIContentOutlineNodeAdapterFactory() {
		return org.eclipse.xtext.xtext.ui.editor.outline.XtextContentOutlineNodeAdapterFactory.class;
	}
	
}
