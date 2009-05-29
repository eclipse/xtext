/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

public class NodeAdapterFactory extends AdapterFactoryImpl {

	public static final NodeAdapterFactory INSTANCE = new NodeAdapterFactory();
	
	private NodeAdapterFactory() {
	}
	
	@Override
	protected Adapter createAdapter(Notifier target) {
		return new NodeAdapter();
	}
	
	@Override
	public boolean isFactoryForType(Object type) {
		return type == AbstractNode.class;
	}
}
