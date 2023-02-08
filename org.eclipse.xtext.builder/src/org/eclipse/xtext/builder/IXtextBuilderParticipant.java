/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.inject.ImplementedBy;

/**
 * <p>A builder participant allows to process resources that are built by an Eclipse incremental project builder.</p>
 * <p>A common implementation pattern is to filter the list of {@link IBuildContext#getDeltas() deltas} by
 * file extension and execute some logic on the respective resources. One main use case is to generate additional
 * artifacts from those resources, i.e. implement a code generator.</p>
 * 
 * <p>A sample implementation may look like this:</p>
 * <pre>
 * public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
 *   for(IResourceDescription.Delta delta: context.getDeltas()) {
 *     Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
 *     .. process resource here ..
 *   }
 * }
 * </pre>
 * 
 * <p>Implementors should keep in mind that they share the resource set with other builder participants thus you
 * shall not modify the state of the given resource set besides adding or removing resources. Removed resources
 * should be unloaded properly or the resource set should be cleared.</p>
 * <p>Another important aspect is memory consumption. If you expect a very large number of resources in a single project,
 * try to apply some clustering algorithm to the processing. The application may run out of memory otherwise.</p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@ImplementedBy(BuilderParticipant.class)
public interface IXtextBuilderParticipant {

	/**
	 * Allows clients to perform additional steps in the build process such as code generation. It is not expected that
	 * any object in the resource set will be modified by a builder participant. However, resources may be dynamically
	 * loaded or unloaded.
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	void build(IBuildContext context, IProgressMonitor monitor) throws CoreException;
	
	/**
	 * The build context provides information that may be used by the participant. This context is shared among
	 * all registered builder participants thus the {@link #getDeltas() deltas} {@link org.eclipse.emf.common.util.URI URI's} 
	 * are not necessarily matching the expected file extension.
	 * 
	 * @noextend This interface is not intended to be extended by clients.
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	public static interface IBuildContext {
		/**
		 * Returns the current project.
		 * @return the currently built project. Never <code>null</code>.
		 */
		IProject getBuiltProject();
		/**
		 * Returns the list of resource deltas that was produced by this run of the incremental project builder.
		 * This list is the only safe way to obtain resources that were processed by this build run.
		 * These resources may be requested from the {@link #getResourceSet() resource set} by means of
		 * {@link ResourceSet#getResource(org.eclipse.emf.common.util.URI, boolean) getResource}.
		 * @return the list of deltas. Never <code>null</code>.
		 */
		List<IResourceDescription.Delta> getDeltas();
		/**
		 * Returns true if the given uri points to a resource from the workspace rather than from an archive.
		 * 
		 * @since 2.9
		 */
		boolean isSourceLevelURI(URI uri);
		/**
		 * The correctly configured resource set for this run of the incremental project builder. Clients should 
		 * not assume that the list of resources in the resource set contains anything. However, they are free to
		 * dynamically load and unload resources from the resource set. Other changes should be avoided.
		 * @return the configured resource set. Never <code>null</code>.
		 */
		ResourceSet getResourceSet();
		/**
		 * The current build type.
		 * @return the current build type.
		 */
		BuildType getBuildType();
		/**
		 * Request a rebuild after the this build run. It is necessary to call {@link #needRebuild()} if this
		 * participant generates file that need to be compiled or processed by another builder.
		 * 
		 * @deprecated call {@link #needRebuild(IProject)}
		 */
		@Deprecated
		void needRebuild();
		
		/**
		 * Request a rebuild after the this build run. It is necessary to call {@link #needRebuild(IProject)} if this
		 * participant generates file that need to be compiled or processed by another builder.
		 * 
		 * @param project the project to be rebuilt
		 */
		default void needRebuild(IProject project) {
			needRebuild();
		}
	}
	
	public static enum BuildType {
		INCREMENTAL,
		FULL,
		CLEAN,
		/**
		 * Triggered if the persisted builder state could not be loaded.
		 */
		RECOVERY
	}
}
