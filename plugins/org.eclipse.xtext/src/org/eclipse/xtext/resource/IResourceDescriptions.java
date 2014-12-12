/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Collections;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
