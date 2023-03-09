/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.impl.SimpleResourceDescriptionsBasedContainerManager;

import com.google.inject.ImplementedBy;

/**
 * A {@link IContainer container} describes resources that should be treated as visible
 * on the same level during the scoping stage. This depends on language implementations
 * in a way that a container that was obtained for a given resource may contain other resources
 * that would create other containers with distinct contents.
 * A container may be optimized by means of the {@link ISelectable}-contract. 
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 * @author Sebastian Zarnekow - Extracted {@link ISelectable}
 */
public interface IContainer extends ISelectable {

	/**
	 * @return the {@link IResourceDescription} contained in this container. The result is never
	 * <code>null</code>. The result may be a cached view on the actual content of the underlying resources.
	 */
	Iterable<IResourceDescription> getResourceDescriptions();
	
	/**
	 * @return the total number of resource descriptions returned by {@link #getResourceDescriptions()}
	 */
	int getResourceDescriptionCount();
	
	/**
	 * @return <code>true</code> if the container can provide a {@link #getResourceDescription(URI) resource description with the given uri}. 
	 */
	boolean hasResourceDescription(URI uri);

	/**
	 * @return the {@link IResourceDescription} for the given URI, or null is this container does 
	 * not contain such an {@link IResourceDescription}. 
	 * The result may be a cached view on the actual content of the underlying resource.
	 */
	IResourceDescription getResourceDescription(URI uri);
	
	/**
	 * a no-op implementation
	 */
	static IContainer NULL_CONTAINER = new IContainer() {

		@Override
		public boolean isEmpty() {
			return true;
		}
		
		@Override
		public int getResourceDescriptionCount() {
			return 0;
		}
		
		@Override
		public boolean hasResourceDescription(URI uri) {
			return false;
		}
		
		@Override
		public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
			return emptySet();
		}
		
		@Override
		public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
			return emptySet();
		}
		
		@Override
		public Iterable<IEObjectDescription> getExportedObjects() {
			return emptySet();
		}
		
		@Override
		public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
			return emptySet();
		}
		
		@Override
		public Iterable<IResourceDescription> getResourceDescriptions() {
			return emptySet();
		}

		@Override
		public IResourceDescription getResourceDescription(URI uri) {
			return null;
		}
	};

	@ImplementedBy(SimpleResourceDescriptionsBasedContainerManager.class)
	interface Manager {

		/**
		 * @return returns the container for a given {@link IResourceDescription}. The result is never
		 * <code>null</code>.
		 */
		IContainer getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions);

		/**
		 * @return a sorted list of all {@link IContainer}, which are visible from the given {@link IResourceDescription}.
		 * In an Java environment this would correspond to the list of class-path entries. The list includes the 
		 * container that contains the given resource description. However, the result may be empty due to
		 * internal errors.
		 */
		List<IContainer> getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions);

	}

}