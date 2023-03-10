/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.xtext.builder.impl.IQueuedBuildDataContribution;
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.builder.impl.javasupport.JdtQueuedBuildData;
import org.eclipse.xtext.builder.impl.javasupport.JdtToBeBuiltComputer;
import org.eclipse.xtext.builder.impl.javasupport.JdtToBeBuiltComputer.ModificationStampCache;
import org.eclipse.xtext.builder.impl.javasupport.ProjectClasspathChangeListener;
import org.eclipse.xtext.builder.impl.javasupport.SimpleProjectDependencyGraph;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.ui.trace.JarEntryAwareTrace;
import org.eclipse.xtext.ui.containers.JavaProjectsState;
import org.eclipse.xtext.ui.containers.JavaProjectsStateHelper;
import org.eclipse.xtext.ui.containers.StrictJavaProjectsState;
import org.eclipse.xtext.ui.generator.trace.IStorageAwareTraceContribution;
import org.eclipse.xtext.ui.resource.IResourceSetInitializer;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperContribution;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperJdtExtensions;
import org.eclipse.xtext.ui.resource.JarEntryLocator;
import org.eclipse.xtext.ui.resource.JavaProjectResourceSetInitializer;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;
import org.eclipse.xtext.ui.util.JavaProjectClasspathChangeAnalyzer;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SharedContributionWithJDT implements Module {

	@Override
	public void configure(Binder binder) {
		if (Activator.isJavaEnabled()) {
			binder.install(new Delegate());
		}
	}
	
	private static class Delegate implements Module {

		@Override
		public void configure(Binder binder) {
			binder.bind(JarEntryLocator.class);
			
			binder.bind(JavaProjectClasspathChangeAnalyzer.class);
			binder.bind(ProjectClasspathChangeListener.class);
			binder.bind(SimpleProjectDependencyGraph.class);
			
			binder.bind(JavaProjectsStateHelper.class);
			binder.bind(JavaProjectsState.class);
			binder.bind(StrictJavaProjectsState.class);
			
			binder.bind(IEagerContribution.class).to(JavaCoreListenerRegistrar.class);
			
			binder.bind(IStorage2UriMapperJdtExtensions.class).to(Storage2UriMapperJavaImpl.class);
			binder.bind(IStorage2UriMapperContribution.class).to(Storage2UriMapperJavaImpl.class);
			binder.bind(Storage2UriMapperJavaImpl.class).in(Scopes.SINGLETON);
			
			binder.bind(IStorageAwareTraceContribution.class).to(JarEntryAwareTrace.class);
			
			binder.bind(IResourceSetInitializer.class).to(JavaProjectResourceSetInitializer.class);
			
			binder.bind(IToBeBuiltComputerContribution.class).to(JdtToBeBuiltComputer.class);
			binder.bind(IQueuedBuildDataContribution.class).to(JdtQueuedBuildData.class);
			binder.bind(TypeURIHelper.class);
			binder.bind(ModificationStampCache.class);
			
		}
		
	}

}