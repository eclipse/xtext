/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.newapi;

import java.util.Collections;

import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SingletonScope extends IterableBasedScope {

	public SingletonScope(IEObjectDescription desc, INewScope parent) {
		super(Collections.singleton(desc), parent);
	}
	
	public SingletonScope(IEObjectDescription desc) {
		super(Collections.singleton(desc), INewScope.NULL_SCOPE);
	}

}
