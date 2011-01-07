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

/**
 * Represents a set of {@link IResourceDescription}
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IResourceDescriptions extends ISelectable {

	Iterable<IResourceDescription> getAllResourceDescriptions();

	/**
	 * Returns the resource descriptions for the given URI. It's the client's responsibility to normalize the URI.
	 */
	IResourceDescription getResourceDescription(URI normalizedURI);

	/**
	 * A context aware instance {@link IResourceDescriptions}. Needs to be configured with the current context before
	 * used.
	 */
	interface IContextAware extends IResourceDescriptions {

		void setContext(Notifier ctx);
	}

	class NullImpl implements IResourceDescriptions {

		public Iterable<IResourceDescription> getAllResourceDescriptions() {
			return Collections.emptyList();
		}

		public IResourceDescription getResourceDescription(URI uri) {
			return null;
		}

		public boolean isEmpty() {
			return true;
		}

		public Iterable<IEObjectDescription> getExportedObjects() {
			return Collections.emptyList();
		}

		public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
			return Collections.emptyList();
		}

		public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
			return Collections.emptyList();
		}

		public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
			return Collections.emptyList();
		}

	}
}
