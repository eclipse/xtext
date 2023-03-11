/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package mypackage

import java.util.concurrent.Future

import static java.util.concurrent.Executors.*

class Bug416262 {
	def <R> void createDelete(() => R create) {
		val pool = newCachedThreadPool
		val Iterable<Future<R>> creates = (0 ..< 3).map[
			pool.submit[|create.apply]
		]
	}
}