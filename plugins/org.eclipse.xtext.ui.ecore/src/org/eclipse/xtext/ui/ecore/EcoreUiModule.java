package org.eclipse.xtext.ui.ecore;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.InjectableAdapterFactory;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.ui.label.InjectableAdapterFactoryLabelProvider;

import com.google.inject.Binder;

public class EcoreUiModule extends AbstractGenericModule {

	private final AbstractUIPlugin plugin;

	public EcoreUiModule(AbstractUIPlugin plugin) {
		super();
		this.plugin = plugin;
	}
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(AbstractUIPlugin.class).toInstance(plugin);
		binder.bind(IDialogSettings.class).toInstance(plugin.getDialogSettings());
	}
	
	public Class<? extends AdapterFactory> bindAdapterFactory() {
		return InjectableAdapterFactory.class;
	}
	
	public Class<? extends AdapterFactoryLabelProvider> bindAdapterFactoryLabelProvider() {
		return InjectableAdapterFactoryLabelProvider.class;
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
	
	public void configureLanguageSpecificURIEditorOpener(com.google.inject.Binder binder) {
		binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class).to(LanguageSpecificURIEditorOpener.class);
	}
	
	public Class<? extends IImageHelper> bindIImageHelper() {
		return PluginImageHelper.class;
	}
	
	public ComposedAdapterFactory.Descriptor.Registry bindComposedAdapterFactory$Descriptor$RegistryToInstance() {
		return ComposedAdapterFactory.Descriptor.Registry.INSTANCE;
	}
}
