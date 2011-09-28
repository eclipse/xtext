/*******************************************************************************
 * Copyright (c) 2011 Sigasi NV (http://www.sigasi.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.resourceloader;

import java.util.Collection;
import java.util.Queue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.collect.Lists;
import com.google.inject.Provider;

/**
 * Loads resources in sequentially in the same thread as it was invoked.
 *
 * @author Lieven Lemiengre - Initial contribution and API
 * @since 2.1
 */
public class SerialResourceLoader extends AbstractResourceLoader {

	public SerialResourceLoader(Provider<XtextResourceSet> resourceSetProvider, Sorter sorter) {
		super(resourceSetProvider, sorter);
	}

	public LoadOperation create(final ResourceSet parent) {
		final Queue<URI> queue = Lists.newLinkedList();

		return new CheckedLoadOperation(new LoadOperation() {

			public Resource next() {
				URI uri = queue.poll();
				Resource resource = parent.getResource(uri, true);
				return resource;
			}

			public boolean hasNext() {
				return !queue.isEmpty();
			}

			public Collection<URI> cancel() {
				return queue;
			}

			public void load(Collection<URI> uris) {
				queue.addAll(getSorter().sort(uris));
			}
		});
	}

}
