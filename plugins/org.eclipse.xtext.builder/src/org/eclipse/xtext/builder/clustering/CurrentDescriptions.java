/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CurrentDescriptions extends AdapterImpl implements IResourceDescriptions {
    
	private final IResourceDescriptions oldState;
    
	private final Map<URI, IResourceDescription> updatedDescriptions = Maps.newHashMap();

    public CurrentDescriptions(ResourceSet resourceSet, IResourceDescriptions oldState, Set<URI> initiallyDeleted) {
        this.oldState = oldState;
        for (URI uri : initiallyDeleted) {
            updatedDescriptions.put(uri, null);
        }
        resourceSet.eAdapters().add(this);
    }

    public void register(IResourceDescription.Delta delta) {
        if (updatedDescriptions.containsKey(delta.getUri())) {
        	if (updatedDescriptions.get(delta.getUri()) != delta.getNew()) {
        		throw new IllegalStateException("Cannot register description twice: " + delta.getUri());
        	}
        	return;
        }
        updatedDescriptions.put(delta.getUri(), delta.getNew());
    }

    public Iterable<IResourceDescription> getAllResourceDescriptions() {
        return Iterables.filter(Iterables.concat(updatedDescriptions.values(),
                Iterables.filter(oldState.getAllResourceDescriptions(), new Predicate<IResourceDescription>() {
                    public boolean apply(IResourceDescription input) {
                        return !updatedDescriptions.containsKey(input.getURI());
                    }
                })), Predicates.notNull());
    }

    public IResourceDescription getResourceDescription(URI uri) {
        if (updatedDescriptions.containsKey(uri)) {
            return updatedDescriptions.get(uri);
        }
        return oldState.getResourceDescription(uri);
    }

    @Override
    public boolean isAdapterForType(Object type) {
        return CurrentDescriptions.class.equals(type);
    }

    public static class ResourceSetAware implements IResourceDescriptions.IContextAware {

        private IResourceDescriptions delegate;

        public void setContext(Notifier ctx) {
            ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
            delegate = (IResourceDescriptions) EcoreUtil.getAdapter(
                    resourceSet.eAdapters(), CurrentDescriptions.class);
        }

        public Iterable<IResourceDescription> getAllResourceDescriptions() {
            return delegate.getAllResourceDescriptions();
        }

        public IResourceDescription getResourceDescription(URI uri) {
            return delegate.getResourceDescription(uri);
        }

    }
}