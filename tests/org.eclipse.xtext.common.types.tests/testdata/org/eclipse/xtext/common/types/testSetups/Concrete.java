/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Concrete<T> extends Abstract<T> {

	@Override
	public void overriddenByAll(T element) {
	}
}

abstract class Abstract<T> implements Interface<T> {
	@Override
	public abstract void overriddenByAll(T element);
	@Override
	public T inherited() { return null; }
}

interface Interface<T> {
	void overriddenByAll(T element);
	T inherited();
}