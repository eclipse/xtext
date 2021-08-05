/*******************************************************************************
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.service;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.formatting.impl.DefaultNodeModelFormatter;
import org.eclipse.xtext.formatting.impl.OneWhitespaceFormatter;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.SimpleNameProvider;
import org.eclipse.xtext.parser.EclipseProjectPropertiesEncodingProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.NullTokenDefProvider;
import org.eclipse.xtext.parser.impl.PartialParsingHelper;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;
import org.eclipse.xtext.resource.DefaultFragmentProvider;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.IsAffectedExtension;
import org.eclipse.xtext.resource.impl.IsAffectedExtension.AllIsAffectedExtensions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.resource.impl.SimpleResourceDescriptionsBasedContainerManager;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleLocalScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.sequencer.BacktrackingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxValidator;

import com.google.common.collect.ImmutableList;
import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sven Efftinge
 * @author Jan Koehnlein
 */
public abstract class DefaultRuntimeModule extends AbstractGenericModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}

	public EValidator.Registry bindEValidatorRegistry() {
		return EValidator.Registry.INSTANCE;
	}

	public EPackage.Registry bindEPackageRegistry() {
		return EPackage.Registry.INSTANCE;
	}

	public IResourceServiceProvider.Registry bindIResourceServiceProvider$Registry() {
		return IResourceServiceProvider.Registry.INSTANCE;
	}

	@SingletonBinding
	public Class<? extends Diagnostician> bindDiagnostician() {
		return CancelableDiagnostician.class;
	}

	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return DefaultFragmentProvider.class;
	}

	public Class<? extends ITransientValueService> bindITransientValueService() {
		return DefaultTransientValueService.class;
	}

	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return DefaultLocationInFileProvider.class;
	}
	
	public Class<? extends IFormatter> bindIFormatter() {
		return OneWhitespaceFormatter.class;
	}
	
	public Class<? extends INodeModelFormatter> bindINodeModelFormatter() {
		return DefaultNodeModelFormatter.class;
	}

	@SuppressWarnings("deprecation")
	public Class<? extends ISerializer> bindISerializer() {
		return org.eclipse.xtext.parsetree.reconstr.Serializer.class;
	}
	
	/**
	 * @since 2.0
	 */
	public Class<? extends ISemanticSequencer> bindISemanticSequencer() {
		return BacktrackingSemanticSequencer.class;
	}

	public Class<? extends IConcreteSyntaxValidator> bindConcreteSyntaxValidator() {
		return ConcreteSyntaxValidator.class;
	}

	public Class<? extends IResourceFactory> bindIResourceFactory() {
		return XtextResourceFactory.class;
	}

	public Class<? extends ILinkingService> bindILinkingService() {
		return DefaultLinkingService.class;
	}

	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return SimpleLocalScopeProvider.class;
	}
	
	/**
	 * @since 2.4
	 */
	public void configureSerializerIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(SerializerScopeProviderBinding.class).to(IScopeProvider.class);
	}
	
	public void configureLinkingIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(LinkingScopeProviderBinding.class).to(IScopeProvider.class);
	}
	
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return ImportUriGlobalScopeProvider.class;
	}
	
	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
		binder.bind(IResourceDescriptions.class).to(ResourceSetBasedResourceDescriptions.class);
	}

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SimpleNameProvider.class;
	}

	public Class<? extends org.eclipse.xtext.linking.ILinker> bindILinker() {
		return LazyLinker.class;
	}

	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return DefaultTerminalConverters.class;
	}

	public Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> bindITokenToStringConverter() {
		return AntlrTokenToStringConverter.class;
	}

	public Class<? extends org.eclipse.xtext.parser.antlr.IPartialParsingHelper> bindIPartialParserHelper() {
		return PartialParsingHelper.class;
	}
	
	public Class<? extends ITokenDefProvider> bindITokenDefProvider() {
		return NullTokenDefProvider.class;
	}

	public Class<? extends org.eclipse.xtext.parser.IAstFactory> bindIAstFactory() {
		return org.eclipse.xtext.parser.DefaultEcoreElementFactory.class;
	}

	public Class<? extends XtextResource> bindXtextResource() {
		return LazyLinkingResource.class;
	}
	
	public Class<? extends ResourceSet> bindResourceSet() {
		return XtextResourceSet.class;
	}
	
	public Class<? extends XtextResourceSet> bindXtextResourceSet() {
		return SynchronizedXtextResourceSet.class;
	}
	
	public Class<? extends IContainer.Manager> bindIContainer$Manager() {
		return SimpleResourceDescriptionsBasedContainerManager.class;
	}
	
	public void configureRuntimeEncodingProvider(Binder binder) {
		binder.bind(IEncodingProvider.class).annotatedWith(DispatchingProvider.Runtime.class).to(IEncodingProvider.Runtime.class);
	}
	
	/**
	 * @since 2.8
	 */
	public Class<? extends IEncodingProvider.Runtime> bindRuntimeEncodingProvider() {
		return EclipseProjectPropertiesEncodingProvider.class;
	}

	public Class<? extends Provider<IEncodingProvider>> provideIEncodingProvider() {
		return IEncodingProviderDispatcher.class;
	}

	static class IEncodingProviderDispatcher extends DispatchingProvider<IEncodingProvider>{}
	
	public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(ResourceSetBasedResourceDescriptions.class);
	}
	
	public void configureIResourceDescriptionsLiveScope(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE)).to(ResourceSetBasedResourceDescriptions.class);
	}
	
	/** @since 2.0 */
	public void configureGenericSemanticSequencer(com.google.inject.Binder binder) {
		binder.bind(ISemanticSequencer.class).annotatedWith(GenericSequencer.class).to(BacktrackingSemanticSequencer.class);
	}
	
	/**
	 * @since 2.7
	 */
	public void configureUseIndexFragmentsForLazyLinking(com.google.inject.Binder binder) {
		binder.bind(Boolean.TYPE).annotatedWith(Names.named(LazyURIEncoder.USE_INDEXED_FRAGMENTS_BINDING)).toInstance(Boolean.TRUE);
	}
	
	/**
	 * @see IsAffectedExtension
	 * @since 2.22
	 */
	public void configureIsAffectedExtensions(Binder binder) {
		binder.bind(new TypeLiteral<ImmutableList<IsAffectedExtension>>() {}).toProvider(AllIsAffectedExtensions.class);
		binder.bind(Key.get(IsAffectedExtension.class, Names.named("IsAffectedExtension.UniqueNames"))).to(INamesAreUniqueValidationHelper.ContextProvider.class);
	}
	
}
