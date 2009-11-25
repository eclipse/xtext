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
				"org.eclipse.xtext.ui.core",
				"org.eclipse.xtext.ui.common",
				"org.eclipse.ui.editors",
				"org.eclipse.ui" };
	}
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
		.addTypeToType("org.eclipse.xtext.ui.core.ILocationInFileProvider","org.eclipse.xtext.ui.core.DefaultLocationInFileProvider")
		.addTypeToType("org.eclipse.jface.text.hyperlink.IHyperlinkDetector","org.eclipse.xtext.ui.common.editor.hyperlinking.DefaultHyperlinkDetector")
		.addTypeToType("org.eclipse.jface.text.reconciler.IReconciler","org.eclipse.xtext.ui.core.editor.reconciler.XtextReconciler")
		.addTypeToType("org.eclipse.xtext.ui.core.editor.toggleComments.ISingleLineCommentHelper","org.eclipse.xtext.ui.common.editor.toggleComments.DefaultSingleLineCommentHelper")
		
		// outline
		.addTypeToType("org.eclipse.xtext.ui.common.editor.outline.transformer.ISemanticModelTransformer","org.eclipse.xtext.ui.common.editor.outline.transformer.DefaultSemanticModelTransformer")
		.addTypeToType("org.eclipse.xtext.ui.common.editor.outline.ITreeProvider","org.eclipse.xtext.ui.common.editor.outline.transformer.TransformingTreeProvider")
		.addTypeToType("org.eclipse.ui.views.contentoutline.IContentOutlinePage","org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage")
		.addTypeToType("org.eclipse.xtext.ui.common.editor.outline.actions.IActionBarContributor", "org.eclipse.xtext.ui.common.editor.outline.actions.IActionBarContributor.DefaultActionBarContributor")
		
		// syntax coloring
		.addTypeToType("org.eclipse.jface.text.rules.ITokenScanner","org.eclipse.xtext.ui.common.editor.syntaxcoloring.DefaultTokenScanner")
		.addTypeToType("org.eclipse.xtext.ui.core.editor.IDamagerRepairer","org.eclipse.xtext.ui.core.editor.FastLineBasedDamagerRepairer")
		.addTypeToType("org.eclipse.xtext.ui.core.editor.syntaxcoloring.IHighlightingHelper","org.eclipse.xtext.ui.common.editor.syntaxcoloring.HighlightingHelper")
		
		// label provider
		.addTypeToType("org.eclipse.jface.viewers.ILabelProvider","org.eclipse.xtext.ui.core.DefaultLabelProvider")
		.addTypeToType("org.eclipse.emf.common.notify.AdapterFactory","org.eclipse.xtext.ui.core.InjectableAdapterFactory")
		.addTypeToType("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider","org.eclipse.xtext.ui.core.InjectableAdapterFactoryLabelProvider")
		.addTypeToInstance("org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry","org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE")
		
		// content assist
		.addTypeToType("org.eclipse.xtext.ui.core.editor.contentassist.IContentAssistantFactory", "org.eclipse.xtext.ui.common.editor.contentassist.DefaultContentAssistantFactory")
		.addTypeToType("org.eclipse.jface.text.contentassist.IContentAssistProcessor", "org.eclipse.xtext.ui.core.editor.contentassist.XtextContentAssistProcessor")
		.addTypeToType("org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalPostProcessor", "org.eclipse.xtext.ui.common.editor.contentassist.DefaultCompletionProposalPostProcessor")
		.addTypeToType("org.eclipse.xtext.ui.core.editor.contentassist.IFollowElementCalculator", "org.eclipse.xtext.ui.common.editor.contentassist.DefaultFollowElementCalculator")

		// template proposals
		.addTypeToType("org.eclipse.xtext.ui.core.editor.contentassist.ITemplateProposalProvider","org.eclipse.xtext.ui.common.editor.templates.DefaultTemplateProposalProvider")
		.addTypeToType("org.eclipse.jface.text.templates.persistence.TemplateStore","org.eclipse.xtext.ui.common.editor.templates.XtextTemplateStore")
		.addTypeToType("org.eclipse.jface.text.templates.ContextTypeRegistry","org.eclipse.xtext.ui.common.editor.templates.XtextTemplateContextTypeRegistry")
		.addTypeToType("org.eclipse.xtext.ui.core.editor.contentassist.IContentProposalProvider","org.eclipse.xtext.common.contentassist.TerminalsProposalProvider")
		
		// formatting 
		.addTypeToType("org.eclipse.xtext.ui.core.editor.formatting.IContentFormatterFactory", "org.eclipse.xtext.ui.core.editor.formatting.ContentFormatterFactory")
		
		// validation
		.addTypeToType("org.eclipse.xtext.ui.core.editor.validation.IXtextResourceChecker", "org.eclipse.xtext.ui.core.editor.validation.DefaultXtextResourceChecker")
		
		// index
		.addTypeToProvider("org.eclipse.xtext.index.IXtextIndex", "org.eclipse.xtext.ui.core.index.IndexProvider")
		
		// builder
		.addTypeToType("org.eclipse.xtext.ui.core.builder.ILanguageBuilder", 
					"org.eclipse.xtext.ui.core.builder.impl.SimpleProjectLanguageBuilder")
		
		// editor notification
		.addTypeToType("org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider", 
				"org.eclipse.xtext.ui.core.editor.IDirtyStateManager")
		.addTypeToProviderInstance("org.eclipse.xtext.ui.core.editor.IDirtyStateManager", 
				"new org.eclipse.xtext.ui.core.editor.DirtyStateManagerProvider()")
		.addTypeToProviderInstance("org.eclipse.xtext.ui.core.notification.IStateChangeEventBroker", 
				"new org.eclipse.xtext.ui.core.notification.StateChangeEventBrokerProvider()")
		.getBindings();
	}

}
