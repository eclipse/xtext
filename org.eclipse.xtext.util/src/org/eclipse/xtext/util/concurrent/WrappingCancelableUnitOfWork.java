/*******************************************************************************
 * Copyright (c) 2018 Sigasi N.V. (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.concurrent;

import java.util.function.Supplier;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IReadAccess.Priority;

/**
 * <p>
 * Wraps a CancelableUnitOfWork in a CancelableUnitOfWork instead of a lambda.
 * </p>
 *
 * <p>
 * It is used in the try* methods of {@link IReadAccess}, {@link Priority} and
 * {@link IWriteAccess} to make sure that {@code work} can still be checked to
 * be cancelable. It does so by delegating
 * {@link #setCancelIndicator(CancelIndicator)} to {@code work}.
 * </p>
 * 
 * <p>
 * As it is meant to be used with the try... methods it also makes sure that the
 * {@code Resource} passed to {@code work}'s {@code exec} method is
 * never null. If the {@code Resource} would be null, it returns the value
 * supplied by {@code defaultResult}.
 * </p>
 * 
 * @author Titouan Vervack - Initial contribution and API
 */
final class WrappingCancelableUnitOfWork<Result, State> extends CancelableUnitOfWork<Result, State> {

	private final Supplier<? extends Result> defaultResult;
	private final IUnitOfWork<Result, State> work;

	WrappingCancelableUnitOfWork(Supplier<? extends Result> defaultResult, IUnitOfWork<Result, State> work) {
		this.defaultResult = defaultResult;
		this.work = work;
	}

	@Override
	public void setCancelIndicator(final CancelIndicator cancelIndicator) {
		super.setCancelIndicator(cancelIndicator);
		((CancelableUnitOfWork<Result, State>) work).setCancelIndicator(cancelIndicator);
	}

	@Override
	public Result exec(final State state, final CancelIndicator cancelIndicator) throws Exception {
		if (state == null) {
			return defaultResult.get();
		}
		return work.exec(state);
	}
}
