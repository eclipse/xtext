/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package test;


/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class OverrideFunctions<T, W> {

	public abstract void plain();
	
	public abstract T classTypeParameter(T param);
	
	public abstract T classTypeParameter2(Iterable<? extends W> param);
	
	public abstract T classTypeParameter3(Iterable<? super W> param);
	
	public abstract <V> V methodTypeParameter(V param);
	
	public abstract void exception() throws Exception;
	
	protected abstract void protectedMethod();
	
	public void concretePlain() {}
	
	public T concreteClassTypeParameter(T param) {
		return null;
	}
	
	public <V> V concreteMethodTypeParameter(V param) {
		return null;
	}
	
}
