/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util.concurrent;


/**
 * A unit of work acts as a transaction block, which can be passed to an
 * IXtextDocument in order to get read or write access to it's parsed models.
 * 
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public interface IUnitOfWork<R,P> {
	/**
	 * @param state - The state, which is synchronized while this method is executed
	 * <b>Do not return any references to something contained in this resource</b>
	 * @return
	 * @throws Exception
	 */
	R exec(P state) throws Exception;
	
	
	/**
	 * convenience class for side-effect only units
	 * 
	 * @param <T>
	 */
	public static abstract class Void<T> implements IUnitOfWork<Object,T> {
		public final Object exec(T state) throws Exception {
			process(state);
			return null;
		}

		public abstract void process(T state) throws Exception;
	}
}
