/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.concurrent;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - Separated read and write access
 */
public interface IWriteAccess<State> {

	/**
	 * Modifies the State by executing {@code work} on it.
	 * 
	 * WARNING: the State passed to {@code work} can be null.
	 * 
	 * @param work Work that modifies the State
	 * 
	 * @return The result of executing {@code work}
	 * @since 2.7
	 */
	public <Result> Result modify(IUnitOfWork<Result, State> work);
	
	/**
	 * Tries to modify the State by executing {@code work} on it.
	 * 
	 * @param work Work that modifies the State
	 * @param defaultResult Supplies a result in case the State is null
	 * 
	 * @return The result of executing {@code work}, or
	 *         the result of querying {@code defaultResult} if the State is null
	 * @since 2.14
	 */
	default <Result> Result tryModify(
		IUnitOfWork<Result, State> work,
		Supplier<? extends Result> defaultResult
	) {
		// Some implementations rely on the type of {@code work}
		if (work instanceof CancelableUnitOfWork<?, ?>) {
			return modify(new WrappingCancelableUnitOfWork<>(defaultResult, work));
		}

		return modify((state) -> {
			if (state == null) {
				return defaultResult.get();
			}
			return work.exec(state);
		});
	}

	/**
	 * Tries to modify the State by executing {@code work} on it.
	 * 
	 * @param work Work that modifies the State
	 * 
	 * @return The result of executing {@code work}, or
	 *         null if the State is null
	 * @since 2.15
	 */
	default <Result> Result tryModify(IUnitOfWork<Result, State> work) {
		return tryModify(work, () -> null);
	}

	/**
	 * Tries to modify the State by executing {@code work} on it.
	 * 
	 * @param work Work that modifies the State
	 * @param defaultResult Supplies a result in case the State is null
	 * @param exceptionHandler Supplies a result in case an exception is raised during execution
	 * 
	 * @return The result of executing {@code work},
	 *         the result of querying {@code defaultResult} if the State is null, or
	 *         the result of executing {@code exceptionHandler} in case an exception is raised
	 * @since 2.14
	 */
	default <Result> Result tryModify(
		IUnitOfWork<Result, State> work,
		Supplier<? extends Result> defaultResult,
		Function<? super Exception, ? extends Result> exceptionHandler
	) {
		try {
			return tryModify(work, defaultResult);
		} catch (Exception e) {
			return exceptionHandler.apply(e);
		}
	}
}
