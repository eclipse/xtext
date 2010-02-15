package org.eclipse.xtext.ui.generator;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;

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
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] {
				"org.eclipse.xtext.ui",
				"org.eclipse.ui.editors",
				"org.eclipse.ui" };
	}
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
		.addTypeToType("org.eclipse.xtext.resource.ILocationInFileProvider","org.eclipse.xtext.resource.DefaultLocationInFileProvider")
		.addTypeToType("org.eclipse.jface.text.hyperlink.IHyperlinkDetector","org.eclipse.xtext.ui.editor.hyperlinking.DefaultHyperlinkDetector")
		.addTypeToType("org.eclipse.jface.text.reconciler.IReconciler","org.eclipse.xtext.ui.editor.reconciler.XtextReconciler")
		.addTypeToType("org.eclipse.xtext.ui.editor.toggleComments.ISingleLineCommentHelper","org.eclipse.xtext.ui.editor.toggleComments.DefaultSingleLineCommentHelper")
		
		// outline
		.addTypeToType("org.eclipse.xtext.ui.editor.outline.transformer.ISemanticModelTransformer","org.eclipse.xtext.ui.editor.outline.transformer.DefaultSemanticModelTransformer")
		.addTypeToType("org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider","org.eclipse.xtext.ui.editor.outline.transformer.TransformingTreeProvider")
		.addTypeToType("org.eclipse.ui.views.contentoutline.IContentOutlinePage","org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage")
		.addTypeToType("org.eclipse.xtext.ui.editor.outline.actions.IActionBarContributor", "org.eclipse.xtext.ui.editor.outline.actions.IActionBarContributor.DefaultActionBarContributor")
		
		// syntax coloring
		.addTypeToType("org.eclipse.jface.text.rules.ITokenScanner","org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultTokenScanner")
		.addTypeToType("org.eclipse.xtext.ui.editor.IDamagerRepairer","org.eclipse.xtext.ui.editor.FastLineBasedDamagerRepairer")
		.addTypeToType("org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingHelper","org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingHelper")
		
		// label provider
		.addTypeToType("org.eclipse.jface.viewers.ILabelProvider","org.eclipse.xtext.ui.DefaultLabelProvider")
		.addTypeToType("org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider","org.eclipse.xtext.ui.DefaultLabelProvider")
		.addTypeToType("org.eclipse.emf.common.notify.AdapterFactory","org.eclipse.xtext.ui.InjectableAdapterFactory")
		.addTypeToType("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider","org.eclipse.xtext.ui.InjectableAdapterFactoryLabelProvider")
		.addTypeToInstance("org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry","org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE")
		
		// content assist
		.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IContentAssistantFactory", "org.eclipse.xtext.ui.editor.contentassist.DefaultContentAssistantFactory")
		.addTypeToType("org.eclipse.jface.text.contentassist.IContentAssistProcessor", "org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor")
		.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalPostProcessor", "org.eclipse.xtext.ui.editor.contentassist.DefaultCompletionProposalPostProcessor")
		.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IFollowElementCalculator", "org.eclipse.xtext.ui.editor.contentassist.DefaultFollowElementCalculator")

		// template proposals
		.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider","org.eclipse.xtext.ui.editor.templates.DefaultTemplateProposalProvider")
		.addTypeToType("org.eclipse.jface.text.templates.persistence.TemplateStore","org.eclipse.xtext.ui.editor.templates.XtextTemplateStore")
		.addTypeToType("org.eclipse.jface.text.templates.ContextTypeRegistry","org.eclipse.xtext.ui.editor.templates.XtextTemplateContextTypeRegistry")
		.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider","org.eclipse.xtext.common.ui.contentassist.TerminalsProposalProvider")
		
		// formatting 
		.addTypeToType("org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory", "org.eclipse.xtext.ui.editor.formatting.ContentFormatterFactory")
		
		// editor notification
		.addConfiguredBinding("XtextEditorErrorTickUpdater", 
					"binder.bind(org.eclipse.xtext.ui.editor.IXtextEditorCallback.class)"+
					".annotatedWith(com.google.inject.name.Names.named(\"IXtextEditorCallBack\")).to(org.eclipse.xtext.ui.editor.XtextEditorErrorTickUpdater.class)")
		.addTypeToType("org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider", 
				"org.eclipse.xtext.ui.editor.IDirtyStateManager")
		.addTypeToProviderInstance("org.eclipse.xtext.ui.editor.IDirtyStateManager", 
				"new org.eclipse.xtext.ui.editor.DirtyStateManagerProvider()")
		.addTypeToProviderInstance("org.eclipse.xtext.ui.notification.IStateChangeEventBroker", 
				"new org.eclipse.xtext.ui.notification.StateChangeEventBrokerProvider()")
		.getBindings();
	}

}
