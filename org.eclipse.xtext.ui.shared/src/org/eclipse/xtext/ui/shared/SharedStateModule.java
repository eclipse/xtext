/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.shared;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.builder.DerivedResourceMarkers;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.xtext.ui.JdtAwareProjectByResourceProvider;
import org.eclipse.xtext.common.types.xtext.ui.JdtIndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.xtext.ui.ProjectAwareResourceDescriptionsProvider;
import org.eclipse.xtext.generator.trace.ITraceForURIProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.generator.trace.StorageAwareTrace;
import org.eclipse.xtext.ui.generator.trace.TraceForStorageProvider;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperJdtExtensions;
import org.eclipse.xtext.ui.resource.ProjectByResourceProvider;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;
import org.eclipse.xtext.ui.shared.internal.Activator;
import org.eclipse.xtext.ui.util.IJdtHelper;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

public class SharedStateModule extends AbstractGenericModule {

	public Provider<IResourceDescriptions> provideIResourceDescriptions() {
		return Access.getIResourceDescriptions();
	}

	public Provider<IStorage2UriMapper> provideIStorage2UriMapper() {
		return Access.getIStorage2UriMapper();
	}
	
	/**
	 * @since 2.4
	 */
	public Provider<IStorage2UriMapperJdtExtensions> provideIStorage2UriMapperJdtExtensions() {
		return Access.getIStorage2UriMapperJdtExtensions();
	}
	
	/**
	 * @since 2.4
	 */
	public Provider<StorageAwareTrace> provideStorageAwareTrace() {
		return Access.provider(StorageAwareTrace.class);
	}

	public Provider<IStateChangeEventBroker> provideIStateChangeEventBroker() {
		return Access.getIStateChangeEventBroker();
	}

	public Provider<IBuilderState> provideIBuilderState() {
		return Access.getIBuilderState();
	}

	public Provider<IDirtyStateManager> provideIDirtyStateManager() {
		return Access.getIDirtyStateManager();
	}

	public Provider<IURIEditorOpener> provideIURIEditorOpener() {
		return Access.getIURIEditorOpener();
	}

	/**
	 * @since 2.3
	 */
	public Class<? extends IDerivedResourceMarkers> bindDerivedResourceMarkers() {
		return DerivedResourceMarkers.class;
	}
	
	/**
	 * @since 2.9
	 */
	public Class<? extends ITraceForURIProvider> bindPlatformNeutralTraceInformation() {
		return ITraceForStorageProvider.class;
	}
	
	/**
	 * @since 2.3
	 */
	public Class<? extends ITraceForStorageProvider> bindITraceInformation() {
		return TraceForStorageProvider.class;
	}
	
	/**
	 * @since 2.1
	 */
	public Provider<IJdtHelper> provideJdtHelper() {
		return Access.getJdtHelper();
	}
	
	/**
	 * @since 2.5
	 */
	public Provider<ISharedStateContributionRegistry> provideSharedStateContributionRegistry() {
		return Access.getSharedStateContributionRegistry();
	}
	
	/**
	 * @since 2.5
	 */
	public Provider<QueuedBuildData> provideQueuedBuildData() {
		return Access.getQueuedBuildData();
	}

	public Provider<IWorkspace> provideIWorkspace() {
		return new Provider<IWorkspace>() {
			@Override
			public IWorkspace get() {
				return ResourcesPlugin.getWorkspace();
			}
		};
	}
	
	public void configureIWorkbench(Binder binder) {
		if (PlatformUI.isWorkbenchRunning()) {
			binder.bind(IWorkbench.class).toProvider(new Provider<IWorkbench>() {
				@Override
				public IWorkbench get() {
					return (PlatformUI.isWorkbenchRunning()) ? PlatformUI.getWorkbench() : null;
				}
			});
		}
	}
	
	/**
	 * @since 2.8
	 */
	public void configureResourceDescriptionsProvider(Binder binder) {
		if (Activator.isJavaEnabled()) {
			binder.install(new ResourceDescriptionsProviderModule());
		} else {
			binder.bind(ResourceDescriptionsProvider.class).in(Scopes.SINGLETON);
		}
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE))
			.to(LiveShadowedResourceDescriptions.class);
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE))
			.to(CurrentDescriptions.ResourceSetAware.class);
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)).to(IBuilderState.class);
	}
	
	/*
	 * Extracted to an own static class to get rid of the dependency to the ProjectAwareResourceDescriptionsProvider
	 * from the SharedStateModule
	 */
	private static class ResourceDescriptionsProviderModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(ResourceDescriptionsProvider.class).to(ProjectAwareResourceDescriptionsProvider.class).in(Scopes.SINGLETON);
			bind(IndexedJvmTypeAccess.class).to(JdtIndexedJvmTypeAccess.class);
		}
		
	}
	
	/**
	 * @since 2.8
	 */
	public void configureProjectByResourceProvider(Binder binder) {
		if (Activator.isJavaEnabled()) {
			binder.install(new ProjectByResourceProviderModule());
		} else {
			binder.bind(ProjectByResourceProvider.class);
		}
	}
	
	/*
	 * Extracted to an own static class to get rid of the dependency to the JdtAwareProjectByResourceProvider
	 * from the SharedStateModule
	 */
	private static class ProjectByResourceProviderModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(ProjectByResourceProvider.class).to(JdtAwareProjectByResourceProvider.class);
		}
		
	}
	

}
