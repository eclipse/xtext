/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManagerRegistry;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public interface IResourceDescription {

	/**
	 * @return descriptions of all EObjects provided by the given Resource. The result is expected to return any
	 *         combination of <code>name</code> and <code>eObjectOrProxy</code> only once as an
	 *         {@link IEObjectDescription}.
	 */
	Iterable<IEObjectDescription> getExportedObjects();
	
	/**
	 * @return all {@link IEObjectDescription} from {@link #getExportedObjects()} which are instances of the given {@link EClass} and match the given name.
	 */
	Iterable<IEObjectDescription> getExportedObjects(EClass clazz, String name);
	
	/**
	 * @return all {@link IEObjectDescription} from {@link #getExportedObjects()} which are instances of the given {@link EClass}.
	 */
	Iterable<IEObjectDescription> getExportedObjects(EClass clazz);
	
	/**
	 * @return the all {@link IEObjectDescription} from {@link #getExportedObjects()} which describe the given EObject.
	 */
	Iterable<IEObjectDescription> getExportedObjectsForEObject(EObject object);

	/**
	 * returns the list of names the described resource depends depends on.
	 */
	Iterable<String> getImportedNames();

	URI getURI();

	@ImplementedBy(DefaultResourceDescriptionManager.class)
	interface Manager {

		/**
		 * @return a resource description for the given resource
		 */
		IResourceDescription getResourceDescription(Resource resource);

		/**
		 * @return whether the candidate is affected by the change in the delta.
		 * @throws IllegalArgumentException, if this manager is not responsible for the given candidate.
		 */
		boolean isAffected(IResourceDescription.Delta delta, IResourceDescription candidate)
				throws IllegalArgumentException;
		
		/**
		 * @return the container manager that is responsible for descriptions provided by this manager. 
		 */
		IContainer.Manager getContainerManager();

		@ImplementedBy(DefaultResourceDescriptionManagerRegistry.class)
		interface Registry {

			/**
			 * Returns the {@link IResourceDescription.Manager} appropriate for the given URI. <b>Content types are not
			 * yet supported.</b>
			 * 
			 * @param uri
			 *            the URI.
			 * @param contentType
			 *            the content type of the URI or <code>null</code> if a content type should not be used during
			 *            lookup.
			 * @return the {@link IResourceDescription.Manager} appropriate for the given URI, or <code>null</code> if
			 *         there isn't one.
			 */
			IResourceDescription.Manager getResourceDescriptionManager(URI uri, String contentType);
		}
	}

	/**
	 * A delta describing the differences between two versions of the same {@link IResourceDescription}. Instances have
	 * to follow the rule :
	 * <p>
	 * <code>getNew()==null || getOld()==null || getOld().getURI().equals(getNew().getURI())</code>
	 * </p>
	 * and
	 * <p>
	 * <code>getNew()!=getOld()</code>
	 * </p>
	 * 
	 * @author Sven Efftinge - Initial contribution and API
	 */
	interface Delta {
		/**
		 * @return the old resource description, or null if the change is an addition
		 */
		IResourceDescription getOld();

		/**
		 * @return the new resource description, or null if the change is a deletion
		 */
		IResourceDescription getNew();
		
		/**
		 * @return whether there are differences between the old and the new resource description. 
		 */
		boolean hasChanges();
	}

}
