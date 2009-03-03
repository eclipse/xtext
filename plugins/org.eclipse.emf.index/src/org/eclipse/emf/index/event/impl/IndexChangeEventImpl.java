/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.event.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.index.event.IndexChangeEvent;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IndexChangeEventImpl implements IndexChangeEvent {

	private Object descriptor;
	private Type type;
	private List<IndexChangeEvent> children;

	public IndexChangeEventImpl(Object descriptor, Type type) {
		this.descriptor = descriptor;
		this.type = type;
	}

	public List<IndexChangeEvent> getChildren() {
		if (children == null)
			children = new ArrayList<IndexChangeEvent>();
		return children;
	}

	public boolean hasChildren() {
		return children != null && !children.isEmpty();
	}

	public Object getDescriptor() {
		return descriptor;
	}

	public Type getType() {
		return type;
	}

}
