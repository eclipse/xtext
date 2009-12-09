/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.ui.common.editor.outline.actions.IActionBarContributor;
import org.eclipse.xtext.ui.common.editor.outline.actions.IContentOutlineNodeAdapterFactory;
import org.eclipse.xtext.ui.common.editor.outline.transformer.ISemanticModelTransformer;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingConfiguration;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.core.wizard.IProjectCreator;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;
import org.eclipse.xtext.xtext.ecoreInference.ProjectAwareXtendXtext2EcorePostProcessor;
import org.eclipse.xtext.xtext.ui.XtextLocationInFileProvider;
import org.eclipse.xtext.xtext.ui.editor.outline.XtextActionBarContributor;
import org.eclipse.xtext.xtext.ui.editor.outline.XtextDeclarativeModelTransformer;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingCalculator;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * used to register components to be used within the IDE.
 */
public class XtextUiModule extends AbstractXtextUiModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named(
				XtextContentAssistProcessor.COMPLETION_AUTO_ACTIVATION_CHARS)).toInstance("=[{");

	}
	
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
	
	@Override
	public Class<? extends IActionBarContributor> bindIActionBarContributor() {
		return XtextActionBarContributor.class;
	}
	
	@Override
	public Class<? extends IXtext2EcorePostProcessor> bindIXtext2EcorePostProcessor() {
		return ProjectAwareXtendXtext2EcorePostProcessor.class;
	}

}
