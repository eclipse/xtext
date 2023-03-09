/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Collections;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

/**
 * Represents a set of {@link IResourceDescription}.
 * 
 * Instances of {@link IResourceDescriptions} should be obtained from the {@link ResourceDescriptionsProvider}
 * since they are specific to the configuration of the resource set. Different scenarios will provide different
 * implementations of the {@link IResourceDescriptions}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IResourceDescriptions extends ISelectable {

	Iterable<IResourceDescription> getAllResourceDescriptions();

	/**
	 * Returns the resource descriptions for the given URI. 
	 */
	IResourceDescription getResourceDescription(URI uri);

	/**
	 * A context aware instance {@link IResourceDescriptions}. Needs to be configured with the current context before
	 * used.
	 */
	interface IContextAware extends IResourceDescriptions {

		void setContext(Notifier ctx);
	}
	
	/**
	 * A resource set aware instance {@link IResourceDescriptions}.
	 * 
	 * @since 2.17
	 */
	interface IResourceSetAware extends IResourceDescriptions {

		ResourceSet getResourceSet();
	}

	class NullImpl implements IResourceDescriptions {

		@Override
		public Iterable<IResourceDescription> getAllResourceDescriptions() {
			return Collections.emptyList();
		}

		@Override
		public IResourceDescription getResourceDescription(URI uri) {
			return null;
		}

		@Override
		public boolean isEmpty() {
			return true;
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjects() {
			return Collections.emptyList();
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
			return Collections.emptyList();
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
			return Collections.emptyList();
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
			return Collections.emptyList();
		}

	}
}
