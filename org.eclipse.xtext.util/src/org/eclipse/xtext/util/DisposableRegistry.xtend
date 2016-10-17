/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util

import com.google.inject.Singleton
import java.util.List

/**
 * A compound disposable that serves as a registry. Call this one at the end of the lifecycle of your injector.
 */
@Singleton
class DisposableRegistry implements IDisposable {
	
	val List<IDisposable> disposables = newArrayList
	
	def void register(IDisposable disposable) {
		disposables += disposable
	}
	
	override dispose() {
		for (d : disposables) {
			d.dispose()
		}
	}
	
}