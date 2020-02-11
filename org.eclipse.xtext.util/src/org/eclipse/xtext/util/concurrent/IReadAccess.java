/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.util.concurrent;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - Separated read and write access
 */
public interface IReadAccess<State> {
	
	/**
	 * Gets a read-only copy of the State and executes {@code work} on it.
	 * 
	 * WARNING: the State passed to {@code work} can be null.
	 * e.g. when reading from a read-only zip/jar entry
	 * 
	 * @param work Work to execute on the State
	 * 
	 * @return The result of executing {@code work}
	 * @since 2.7
	 */
	<Result> Result readOnly(IUnitOfWork<Result, State> work);

	/**
	 * Tries to get a read-only copy of the State and execute {@code work} on it.
	 * 
	 * @param work Work to execute on the State
	 * @param defaultResult Supplies a result in case the State is null
	 * 
	 * @return The result of executing {@code work}, or
	 *         the result of querying {@code defaultResult} if the State is null
	 * @since 2.14
	 */
	default <Result> Result tryReadOnly(
		IUnitOfWork<Result, State> work,
		Supplier<? extends Result> defaultResult
	) {
		// Some implementations rely on the type of {@code work}
		if (work instanceof CancelableUnitOfWork<?, ?>) {
			return readOnly(new WrappingCancelableUnitOfWork<>(defaultResult, work));
		}

		return readOnly((state) -> {
			if (state == null) {
				return defaultResult.get();
			}
			return work.exec(state);
		});
	}

	/**
	 * Tries to get a read-only copy of the State and execute {@code work} on it.
	 * 
	 * @param work Work to execute on the State
	 * 
	 * @return The result of executing {@code work}, or
	 *         null if the State is null
	 * @since 2.15
	 */
	default <Result> Result tryReadOnly(IUnitOfWork<Result, State> work) {
		return tryReadOnly(work, () -> null);
	}

	/**
	 * Tries to get a read-only copy of the State and execute {@code work} on it.
	 * 
	 * @param work Work to execute on the State
	 * @param defaultResult Supplies a result in case the State is null
	 * @param exceptionHandler Supplies a result in case an exception is raised during execution
	 * 
	 * @return The result of executing {@code work},
	 *         the result of querying {@code defaultResult} if the State is null, or
	 *         the result of executing {@code exceptionHandler} in case an exception is raised
	 * @since 2.14
	 */
	default <Result> Result tryReadOnly(
		IUnitOfWork<Result, State> work,
		Supplier<? extends Result> defaultResult,
		Function<? super Exception, ? extends Result> exceptionHandler
	) {
		try {
			return tryReadOnly(work, defaultResult);
		} catch (Exception e) {
			return exceptionHandler.apply(e);
		}
	}
	
	/**
	 * @since 2.7
	 */
	interface Priority<State> {
		
		/**
		 * Gets a read-only copy of the State and executes {@code work} on it.
		 * Cancels all cancelable readers before executing the {@link IUnitOfWork}.
		 * For interactive jobs that need fastest possible execution.
		 * 
		 * WARNING: the State passed to {@code work} can be null.
		 * 
		 * @since 2.7
		 * @see CancelableUnitOfWork
		 */
		<Result> Result priorityReadOnly(IUnitOfWork<Result, State> work);
		
		/**
		 * Tries to get a read-only copy of the State and execute {@code work} on it.
		 * Cancels all cancelable readers before executing the {@link IUnitOfWork}.
		 * For interactive jobs that need fastest possible execution.
		 * 
		 * @param work Work to execute on the State
		 * @param defaultResult Supplies a result in case the State is null
		 * 
		 * @return The result of executing {@code work}, or
		 *         the result of querying {@code defaultResult} if the State is null
		 * @since 2.14
		 * @see CancelableUnitOfWork
		 */
		default <Result> Result tryPriorityReadOnly(
			IUnitOfWork<Result, State> work,
			Supplier<? extends Result> defaultResult
		) {
			// Some implementations rely on the type of {@code work}
			if (work instanceof CancelableUnitOfWork<?, ?>) {
				return priorityReadOnly(new WrappingCancelableUnitOfWork<>(defaultResult, work));
			}

			return priorityReadOnly((state) -> {
				if (state == null) {
					return defaultResult.get();
				}
				return work.exec(state);
			});
		}

		/**
		 * Tries to get a read-only copy of the State and execute {@code work} on it.
		 * Cancels all cancelable readers before executing the {@link IUnitOfWork}.
		 * For interactive jobs that need fastest possible execution.
		 * 
		 * @param work Work to execute on the State
		 * 
		 * @return The result of executing {@code work}, or
		 *         null if the State is null
		 * @since 2.15
		 * @see CancelableUnitOfWork
		 */
		default <Result> Result tryPriorityReadOnly(IUnitOfWork<Result, State> work) {
			return tryPriorityReadOnly(work, () -> null);
		}

		/**
		 * Tries to get a read-only copy of the State and execute {@code work} on it.
		 * Cancels all cancelable readers before executing the {@link IUnitOfWork}.
		 * For interactive jobs that need fastest possible execution.
		 * 
		 * @param work Work to execute on the State
		 * @param defaultResult Supplies a result in case the State is null
		 * @param exceptionHandler Supplies a result in case an exception is raised during execution
		 * 
		 * @return The result of executing {@code work},
		 *         the result of querying {@code defaultResult} if the State is null, or
		 *         the result of executing {@code exceptionHandler} in case an exception is raised
		 * @since 2.14
		 * @see CancelableUnitOfWork
		 */
		default <Result> Result tryPriorityReadOnly(
			IUnitOfWork<Result, State> work,
			Supplier<? extends Result> defaultResult,
			Function<? super Exception, ? extends Result> exceptionHandler
		) {
			try {
				return tryPriorityReadOnly(work, defaultResult);
			} catch (Exception e) {
				return exceptionHandler.apply(e);
			}
		}
	}
}
