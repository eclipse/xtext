/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UniqueURIQueue implements IUniqueURIQueue {

	public static class Factory implements IUniqueURIQueue.Factory {

		public UniqueURIQueue create(Collection<URI> initial) {
			return new UniqueURIQueue(initial);
		}
		
	}
	
    private static final Logger logger = Logger.getLogger(UniqueURIQueue.class);

    private final Queue<URI> delegate;
    private final Set<URI> allURIs;

    private UniqueURIQueue() {
        delegate = Lists.newLinkedList();
        allURIs = Sets.newHashSet();
    }

    protected UniqueURIQueue(Collection<URI> initial) {
        this();
        allURIs.addAll(initial);
        delegate.addAll(allURIs);
    }

	public void add(URI uri) {
        if (allURIs.add(uri)) {
            delegate.add(uri);
            if (logger.isDebugEnabled())
                logger.debug("Queue element no " + delegate.size() + " (" + allURIs.size() + "): " + uri.toString());
        }
    }

	public URI get() {
        if (isEmpty()) {
            return null;
        }
        final URI result = delegate.poll();
        if (logger.isDebugEnabled())
            logger.debug("Get element no " + (delegate.size() + 1) + ": " + result.toString());
        return result;
    }

	public Collection<URI> getAllURIs() {
        return Collections.unmodifiableSet(allURIs);
    }

	public boolean isEmpty() {
        return delegate.isEmpty();
    }

}
