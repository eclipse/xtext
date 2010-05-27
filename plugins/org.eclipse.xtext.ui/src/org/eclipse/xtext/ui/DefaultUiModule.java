/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.service.DispatchingProvider;
import org.eclipse.xtext.ui.containers.ContainerStateProvider;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;
import org.eclipse.xtext.ui.editor.WorkspaceEncodingProvider;
import org.eclipse.xtext.ui.editor.XtextEditorErrorTickUpdater;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.editor.contentassist.DefaultCompletionProposalPostProcessor;
import org.eclipse.xtext.ui.editor.contentassist.DefaultContentAssistantFactory;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalPostProcessor;
import org.eclipse.xtext.ui.editor.contentassist.IContentAssistantFactory;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.editor.formatting.ContentFormatterFactory;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.formatting.PreferenceStoreIndentationInformation;
import org.eclipse.xtext.ui.editor.hyperlinking.DefaultHyperlinkDetector;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.editor.outline.IContentOutlineNodeComparer;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.editor.outline.actions.IActionBarContributor;
import org.eclipse.xtext.ui.editor.outline.transformer.DefaultSemanticModelTransformer;
import org.eclipse.xtext.ui.editor.outline.transformer.ISemanticModelTransformer;
import org.eclipse.xtext.ui.editor.outline.transformer.TransformingTreeProvider;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.reconciler.XtextReconciler;
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingHelper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingHelper;
import org.eclipse.xtext.ui.editor.templates.DefaultTemplateProposalProvider;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContextTypeRegistry;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateStore;
import org.eclipse.xtext.ui.editor.toggleComments.DefaultSingleLineCommentHelper;
import org.eclipse.xtext.ui.editor.toggleComments.ISingleLineCommentHelper;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.ui.label.InjectableAdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @author Jan Koehnlein
 */
public class DefaultUiModule extends AbstractGenericModule {

	private final AbstractUIPlugin plugin;

	public DefaultUiModule(AbstractUIPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(AbstractUIPlugin.class).toInstance(plugin);
		binder.bind(IDialogSettings.class).toInstance(plugin.getDialogSettings());
	}

	public void configureBracketMatchingAction(Binder binder) {
		binder.bind(IActionContributor.class).annotatedWith(Names.named("foldingActionGroup")).to( //$NON-NLS-1$
				org.eclipse.xtext.ui.editor.folding.FoldingActionContributor.class);
		binder.bind(IActionContributor.class).annotatedWith(Names.named("bracketMatcherAction")).to( //$NON-NLS-1$
				org.eclipse.xtext.ui.editor.bracketmatching.GoToMatchingBracketAction.class);
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("bracketMatcherPrefernceInitializer")) //$NON-NLS-1$
				.to(org.eclipse.xtext.ui.editor.bracketmatching.BracketMatchingPreferencesInitializer.class);
	}

	public Class<? extends IImageHelper> bindIImageHelper() {
		return PluginImageHelper.class;
	}

	public Class<? extends IIndentationInformation> bindIIndentationInformation() {
		return PreferenceStoreIndentationInformation.class;
	}

	public IPreferenceStore bindIPreferenceStore() {
		return plugin.getPreferenceStore();
	}

	public Class<? extends IReconciler> bindIReconciler() {
		return XtextReconciler.class;
	}

	public Class<? extends ISingleLineCommentHelper> bindISingleLineCommentHelper() {
		return DefaultSingleLineCommentHelper.class;
	}

	public Class<? extends IHyperlinkDetector> bindIHyperlinkDetector() {
		return DefaultHyperlinkDetector.class;
	}

	public Class<? extends ISemanticModelTransformer> bindISemanticModelTransformer() {
		return DefaultSemanticModelTransformer.class;
	}

	public Class<? extends IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return TransformingTreeProvider.class;
	}

	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return XtextContentOutlinePage.class;
	}

	public Class<? extends IActionBarContributor> bindIActionBarContributor() {
		return IActionBarContributor.DefaultActionBarContributor.class;
	}

	public Class<? extends IHighlightingHelper> bindIHighlightingHelper() {
		return HighlightingHelper.class;
	}

	public Class<? extends AdapterFactory> bindAdapterFactory() {
		return InjectableAdapterFactory.class;
	}

	public Class<? extends AdapterFactoryLabelProvider> bindAdapterFactoryLabelProvider() {
		return InjectableAdapterFactoryLabelProvider.class;
	}

	public ComposedAdapterFactory.Descriptor.Registry bindComposedAdapterFactory$Descriptor$RegistryToInstance() {
		return ComposedAdapterFactory.Descriptor.Registry.INSTANCE;
	}

	public Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
		return DefaultContentAssistantFactory.class;
	}

	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return XtextContentAssistProcessor.class;
	}

	public Class<? extends ICompletionProposalPostProcessor> bindICompletionProposalPostProcessor() {
		return DefaultCompletionProposalPostProcessor.class;
	}

	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
		return DefaultTemplateProposalProvider.class;
	}

	public Class<? extends TemplateStore> bindTemplateStore() {
		return XtextTemplateStore.class;
	}

	public Class<? extends ContextTypeRegistry> bindContextTypeRegistry() {
		return XtextTemplateContextTypeRegistry.class;
	}

	public Class<? extends IContentFormatterFactory> bindIContentFormatterFactory() {
		return ContentFormatterFactory.class;
	}

	public void configureXtextEditorErrorTickUpdater(com.google.inject.Binder binder) {
		binder.bind(IXtextEditorCallback.class).annotatedWith(
				Names.named("IXtextEditorCallBack")).to( //$NON-NLS-1$
				XtextEditorErrorTickUpdater.class);
	}

	public Class<? extends IExternalContentSupport.IExternalContentProvider> bindIExternalContentSupport$IExternalContentProvider() {
		return IDirtyStateManager.class;
	}
	
	public void configureHyperlinkLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkLabelProvider.class).to(org.eclipse.jface.viewers.ILabelProvider.class);
	}

	public void configureOutlineLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.editor.outline.OutlineLabelProvider.class).to(org.eclipse.jface.viewers.ILabelProvider.class);
	}

	public void configureContentProposalLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.editor.contentassist.ContentProposalLabelProvider.class).to(org.eclipse.jface.viewers.ILabelProvider.class);
	}
	
	public void configureResourceUIServiceLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class).to(DefaultDescriptionLabelProvider.class);
	}
	
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return DefaultEObjectLabelProvider.class;
	}
	
	public Class<? extends IssueResolutionProvider> bindIssueResolutionProvider() {
		return DefaultQuickfixProvider.class;
	}
	
	public void configureLanguageSpecificURIEditorOpener(com.google.inject.Binder binder) {
		binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class).to(LanguageSpecificURIEditorOpener.class);
	}
	
	public void configureUiEncodingProvider(Binder binder) {
		binder.bind(IEncodingProvider.class).annotatedWith(DispatchingProvider.Ui.class).to(WorkspaceEncodingProvider.class);
	}

	public Class<? extends IAllContainersState.Provider> bindIAllContainersState$Provider() {
		return ContainerStateProvider.class;
	}

	public Class<? extends IContentOutlineNodeComparer> bindIContentOutlineNodeComparer() {
		return IContentOutlineNodeComparer.Default.class;
	}
	
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return JavaClassPathResourceForIEditorInputFactory.class;
	}
	
	public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		return XtextResourceSetProvider.class;
	}
}
