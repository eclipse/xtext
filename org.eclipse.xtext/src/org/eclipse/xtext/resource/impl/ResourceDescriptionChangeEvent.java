/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.collect.ImmutableList;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionChangeEvent implements IResourceDescription.Event {

	private final ImmutableList<Delta> delta;

	/**
	 * @since 2.5
	 */
	public ResourceDescriptionChangeEvent(Iterable<IResourceDescription.Delta> delta) {
		this.delta = ImmutableList.copyOf(delta);
	}
	
	@Override
	public ImmutableList<IResourceDescription.Delta> getDeltas() {
		return delta;
	}

}
