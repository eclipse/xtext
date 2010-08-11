/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.builderState.IResourceDescriptionsUpdater;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClusteringModule implements Module {

    public void configure(Binder binder) {
        binder.bind(IBuilderState.class).to(ClusteringBuilderState.class).in(Scopes.SINGLETON);
        binder.bind(IResourceDescriptionsUpdater.class).to(ClusteringUpdater.class);
    }

}
