/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared;

import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.internal.Activator;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.containers.JavaProjectsState;
import org.eclipse.xtext.ui.containers.StrictJavaProjectsState;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsState;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

import com.google.inject.Provider;

public class Access {
	
	static class InternalProvider<T> implements Provider<T> {
		
		private Class<? extends T> clazz;
		
		public InternalProvider(Class<? extends T> clazz) {
			super();
			this.clazz = clazz;
		}

		public T get() {
			if (Activator.getDefault()==null) {
				throw new IllegalStateException("The bundle has not been started!");
			}
			return org.eclipse.xtext.ui.shared.internal.Activator.getDefault().getInjector().getInstance(clazz);
		}
	}
	
	public static <T> Provider<T> provider(Class<? extends T> clazz) {
		return new InternalProvider<T>(clazz);
	}
	 
	public static Provider<IResourceDescriptions> getIResourceDescriptions() {
		return provider(IResourceDescriptions.class);
	}
	
	public static Provider<IStorage2UriMapper> getIStorage2UriMapper() {
		return provider(IStorage2UriMapper.class);
	}
	
	public static Provider<IStateChangeEventBroker> getIStateChangeEventBroker() {
		return provider(IStateChangeEventBroker.class);
	}
		
	public static Provider<IDirtyStateManager> getIDirtyStateManager() {
		return provider(IDirtyStateManager.class);
	}
	
	public static Provider<IBuilderState> getIBuilderState() {
		return provider(IBuilderState.class);
	}
	
	public static Provider<IURIEditorOpener> getIURIEditorOpener() {
		return provider(IURIEditorOpener.class);
	}
	
	public static Provider<IAllContainersState> getWorkspaceProjectsState() {
		return Access.<IAllContainersState>provider(WorkspaceProjectsState.class);
	}
	
	public static Provider<IAllContainersState> getJavaProjectsState() {
		return Access.<IAllContainersState>provider(JavaProjectsState.class);
	}
	
	public static Provider<IAllContainersState> getStrictJavaProjectsState() {
		return Access.<IAllContainersState>provider(StrictJavaProjectsState.class);
	}
}
