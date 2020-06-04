/*******************************************************************************
 * Copyright (c) 2019, 2020 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;

/**
 * A cancel indicator that will not cancel immediately but only after a delay to
 * allow short running tasks to complete despite an attempt to cancel.
 */
public class BufferedCancelIndicator implements CancelIndicator {

	private static final long ONE_SECOND = TimeUnit.SECONDS.toNanos(1);

	private final CancelIndicator delegate;

	private final Ticker clock;

	private final long delayInNanos;

	private long cancelAt;

	/**
	 * Buffer the cancellation attempts that are issued by the given delegate.
	 */
	public BufferedCancelIndicator(CancelIndicator delegate) {
		this(delegate, Ticker.systemTicker(), ONE_SECOND);
	}

	/**
	 * Buffer the cancellation attempts that are issued by the given delegate.
	 * Use the given clock as the source for the time.
	 *
	 * This is public for testing purpose.
	 */
	public BufferedCancelIndicator(CancelIndicator delegate, Ticker clock, long delayInNanos) {
		this.delegate = Preconditions.checkNotNull(delegate);
		this.clock = Preconditions.checkNotNull(clock);
		this.delayInNanos = delayInNanos;
	}

	@Override
	public boolean isCanceled() {
		if (cancelAt == 0) {
			if (delegate.isCanceled()) {
				cancelAt = clock.read() + delayInNanos;
			}
			return false;
		} else {
			return clock.read() > cancelAt;
		}
	}
}