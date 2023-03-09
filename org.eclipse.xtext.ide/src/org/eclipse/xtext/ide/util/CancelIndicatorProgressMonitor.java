/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.util;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
public class CancelIndicatorProgressMonitor implements IProgressMonitor {
	private final CancelIndicator delegate;

	private volatile boolean canceled;

	@Override
	public boolean isCanceled() {
		return canceled || delegate.isCanceled();
	}

	@Override
	public void setCanceled(boolean value) {
		this.canceled = value;
	}

	@Override
	public void beginTask(String name, int totalWork) {
	}

	@Override
	public void setTaskName(String name) {
	}

	@Override
	public void subTask(String name) {
	}

	@Override
	public void internalWorked(double work) {
	}

	@Override
	public void worked(int work) {
	}

	@Override
	public void done() {
	}

	public CancelIndicatorProgressMonitor(CancelIndicator delegate) {
		this.delegate = delegate;
	}
}
