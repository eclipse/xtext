/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.impl.XtextBuilder;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public interface IXtextBuilderParticipant {

	/**
	 * Allows clients to perform additional steps in the build process such as code generation. It is not expected that
	 * any object in the resource set will be modified by a builder participant.
	 */
	void build(IBuildContext context,
			IProgressMonitor monitor) throws CoreException;
	
	public static interface IBuildContext {
		IProject getBuiltProject();
		List<IResourceDescription.Delta> getDeltas();
		ResourceSet getResourceSet();
		BuildType getBuildType();
		void needRebuild();
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

	public static class BuildContext implements IBuildContext {
		private final ResourceSet resourceSet;
		private final List<IResourceDescription.Delta> deltas;
		private final XtextBuilder builder;
		private final BuildType type;

		public BuildContext(XtextBuilder builder, ResourceSet resourceSet, List<Delta> deltas, BuildType type) {
			super();
			this.type = type;
			this.builder = builder;
			this.resourceSet = resourceSet;
			this.deltas = deltas;
		}

		public IProject getBuiltProject() {
			return builder.getProject();
		}

		public List<IResourceDescription.Delta> getDeltas() {
			return deltas;
		}

		public ResourceSet getResourceSet() {
			return resourceSet;
		}
		
		public void needRebuild() {
			builder.needRebuild();
		}
		
		public BuildType getBuildType() {
			return type;
		}
	}
}
