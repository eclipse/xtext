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
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

import com.google.inject.Provider;

public class SharedStateModule extends AbstractGenericModule {
	
	public Provider<IResourceDescriptions> provideIResourceDescriptions() {
		return Access.getIResourceDescriptions();
	}
	public Provider<IStorage2UriMapper> provideIStorage2UriMapper() {
		return Access.getIStorage2UriMapper();
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
	
	public Provider<IWorkspace> provideIWorkspace(){
		return new Provider<IWorkspace>() {
			public IWorkspace get() {
				return ResourcesPlugin.getWorkspace();
			}
		};
	}
	
	public Provider<IWorkbench> provideIWorkbench(){
		return new Provider<IWorkbench>() {
			public IWorkbench get() {
				return PlatformUI.getWorkbench();
			}
		};
	}
	
}
