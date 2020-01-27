/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @noreference
 */
public class MonitorBasedCancelIndicator implements CancelIndicator {
	private final IProgressMonitor monitor;

	@Override
	public boolean isCanceled() {
		return this.monitor.isCanceled();
	}

	public MonitorBasedCancelIndicator(IProgressMonitor monitor) {
		super();
		this.monitor = monitor;
	}
}
