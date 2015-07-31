/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase;

import org.eclipse.xtext.common.types.DefaultCommonTypesRuntimeModule;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.debug.IStratumBreakpointSupport;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.LineSeparatorHarmonizer;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;
import org.eclipse.xtext.workspace.RuntimeWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.annotations.validation.LinkingDiagnosticTypeAwareMessageProducer;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.output.TraceAwarePostProcessor;
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService;
import org.eclipse.xtext.xbase.debug.XbaseStratumBreakpointSupport;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.linking.BrokenConstructorCallAwareEObjectAtOffsetHelper;
import org.eclipse.xtext.xbase.linking.XbaseLazyLinker;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.serializer.XbaseTransientValueService;
import org.eclipse.xtext.xbase.validation.JvmTypeReferencesValidator;
import org.eclipse.xtext.xbase.validation.UniqueClassNameValidator;
import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;
import org.eclipse.xtext.xbase.validation.XbaseDiagnostician;
import org.eclipse.xtext.xbase.validation.XbaseSeverityConverter;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.8
 */
public class DefaultXbaseRuntimeModule extends DefaultCommonTypesRuntimeModule {

	public Class<? extends IEvaluationContext> bindIEvaluationContext() {
		return DefaultEvaluationContext.class;
	}

	public Class<? extends IExpressionInterpreter> bindIExpressionInterpreter() {
		return XbaseInterpreter.class;
	}

	public Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return XbaseQualifiedNameConverter.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return XbaseQualifiedNameProvider.class;
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return XbaseValueConverterService.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return IBatchScopeProvider.class;
	}

	@Override
	public void configureLinkingIScopeProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class).annotatedWith(org.eclipse.xtext.linking.LinkingScopeProviderBinding.class)
				.to(org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider.class);
	}

	@Override
	public void configureSerializerIScopeProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class).annotatedWith(org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding.class)
				.to(org.eclipse.xtext.xbase.serializer.SerializerScopeProvider.class);
	}

	@SuppressWarnings("deprecation")
	public void configureIScopeProviderDelegate(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class)
				.annotatedWith(Names.named(org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
				.to(org.eclipse.xtext.xbase.scoping.XbaseImportedNamespaceScopeProvider.class);
	}

	@Override
	public Class<? extends ILinker> bindILinker() {
		return XbaseLazyLinker.class;
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return BatchLinkableResource.class;
	}

	@SingletonBinding(eager = true)
	public Class<? extends JvmTypeReferencesValidator> bindJvmTypeReferencesValidator() {
		return JvmTypeReferencesValidator.class;
	}
	
	@SingletonBinding(eager = true)
	public Class<? extends UniqueClassNameValidator> bindUniqueClassNameValidator() {
		return UniqueClassNameValidator.class;
	}

	// obsolete convenience bindings
	public Class<? extends IdentifiableSimpleNameProvider> bindIdentifiableSimpleNameProvider() {
		return IdentifiableSimpleNameProvider.class;
	}

	public Class<? extends IDerivedStateComputer> bindIDerivedStateComputer() {
		return JvmModelAssociator.class;
	}

	public Class<? extends IResourceDescription.Manager> bindIResourceDescription$Manager() {
		return DerivedStateAwareResourceDescriptionManager.class;
	}

	public Class<? extends IGenerator> bindIGenerator() {
		return JvmModelGenerator.class;
	}

	public XtypeFactory bindXtypeFactoryToInstance() {
		return XtypeFactory.eINSTANCE;
	}

	public Class<? extends IStratumBreakpointSupport> bindIStratumBreakpointSupport() {
		return XbaseStratumBreakpointSupport.class;
	}

	public Class<? extends LineSeparatorHarmonizer> bindLineSeparatorHarmonizer() {
		return TraceAwarePostProcessor.class;
	}

	public Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return XbaseResourceDescriptionStrategy.class;
	}

	public Class<? extends SeverityConverter> bindSeverityConverter() {
		return XbaseSeverityConverter.class;
	}

	public Class<? extends ConfigurableIssueCodesProvider> bindConfigurableIssueCodesProvider() {
		return XbaseConfigurableIssueCodes.class;
	}

	public Class<? extends EObjectAtOffsetHelper> bindEObjectAtOffsetHelper() {
		return BrokenConstructorCallAwareEObjectAtOffsetHelper.class;
	}

	public Class<? extends CancelableDiagnostician> bindCancelableDiagnostician() {
		return XbaseDiagnostician.class;
	}

	@SuppressWarnings("deprecation")
	public Class<? extends org.eclipse.xtext.xbase.scoping.featurecalls.StaticImplicitMethodsFeatureForTypeProvider.ExtensionClassNameProvider> bindStaticImplicitMethodsFeatureForTypeProvider$ExtensionClassNameProvider() {
		return org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedTypesAdapter.class;
	}
	
	public void configureITransientValueService(Binder binder) {
		binder.bind(ITransientValueService.class).to(XbaseTransientValueService.class);
	}

	public Class<? extends AbstractFileSystemAccess2> bindAbstractFileSystemAccess2() {
		return JavaIoFileSystemAccess.class;
	}
	
	/**
	 * @since 2.9
	 */
	public Class<? extends IWorkspaceConfigProvider> bindWorkspaceConfigProvider() {
		return RuntimeWorkspaceConfigProvider.class;
	}
	
	/**
	 * @since 2.9
	 */
	public Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return LinkingDiagnosticTypeAwareMessageProducer.class;
	}
}
