/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collection;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.collect.ImmutableList;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionChangeEvent implements IResourceDescription.Event {

	private final Source sender;
	private final ImmutableList<Delta> delta;

	public ResourceDescriptionChangeEvent(Collection<IResourceDescription.Delta> delta, Source sender) {
		this.sender = sender;
		this.delta = ImmutableList.copyOf(delta);
	}
	
	public ImmutableList<IResourceDescription.Delta> getDeltas() {
		return delta;
	}

	public Source getSender() {
		return sender;
	}

}
