/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.util;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;

/**
 * A compound disposable that serves as a registry. Call this one at the end of
 * the lifecycle of your injector.
 */
@Singleton
public class DisposableRegistry implements IDisposable {
	private final List<IDisposable> disposables = new ArrayList<>();

	public void register(IDisposable disposable) {
		disposables.add(disposable);
	}

	@Override
	public void dispose() {
		for (IDisposable d : disposables) {
			d.dispose();
		}
	}
}
