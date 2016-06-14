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
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - Separated read and write access
 */
public interface IReadAccess<P> {
	
	<T> T readOnly(IUnitOfWork<T,P> work);
	
	/**
	 * Cancels all cancelable readers before executing the {@link IUnitOfWork}.
	 * For interactive jobs that need fastest possible execution.
	 *   
	 * @since 2.7
	 * @see CancelableUnitOfWork
	 */
	interface Priority<P> {
		<T> T priorityReadOnly(IUnitOfWork<T,P> work);
	}
}
