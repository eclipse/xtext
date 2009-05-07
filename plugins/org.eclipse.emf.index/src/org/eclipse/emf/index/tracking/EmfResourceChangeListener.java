/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.tracking;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.index.resource.IndexFeeder;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface EmfResourceChangeListener {

	void resourceChanged(URI resourceURI, IndexFeeder indexFeeder);
	
	void resourceDeleted(URI resourceURI, IndexFeeder indexFeeder);
	
	public interface Registry {
		void registerListener(String fileExtension, EmfResourceChangeListener listener);

		void deregisterListeners(String fileExtension, EmfResourceChangeListener listener);

		Collection<EmfResourceChangeListener> getListenersFor(String fileExtension);
	}
}
