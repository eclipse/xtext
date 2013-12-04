/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.builder.DerivedResourceMarkers;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.builder.trace.StorageAwareTrace;
import org.eclipse.xtext.builder.trace.TraceForStorageProvider;
import org.eclipse.xtext.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.generator.trace.DefaultTraceURIConverter;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;
import org.eclipse.xtext.ui.util.IJdtHelper;

import com.google.inject.Binder;
import com.google.inject.Provider;

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
	public Provider<StorageAwareTrace> provideStorageAwareTrace() {
		return Access.provider(StorageAwareTrace.class);
	}
	
	/**
	 * @since 2.4
	 */
	public Provider<DefaultTraceURIConverter> provideDefaultTraceURIConverter() {
		return Access.provider(DefaultTraceURIConverter.class);
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
			public IWorkspace get() {
				return ResourcesPlugin.getWorkspace();
			}
		};
	}
	
	public void configureIWorkbench(Binder binder) {
		if (PlatformUI.isWorkbenchRunning()) {
			binder.bind(IWorkbench.class).toProvider(new Provider<IWorkbench>() {
				public IWorkbench get() {
					return (PlatformUI.isWorkbenchRunning()) ? PlatformUI.getWorkbench() : null;
				}
			});
		}
	}

}
