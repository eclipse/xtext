/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.findReferences

import com.google.common.collect.Iterators
import com.google.inject.Singleton
import org.eclipse.emf.common.util.URI

/**
 * It is used to look up all references for a resource or object scope.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
package class AnyTargetURISet implements TargetURIs {

	override addAllURIs(Iterable<URI> uris) {
		// do nothing
	}

	override addURI(URI uri) {
		// do nothing
	}

	override asSet() {
		emptySet
	}

	override contains(URI uri) {
		true
	}

	override containsResource(URI resourceURI) {
		true
	}

	override getEObjectURIs(URI resourceURI) {
		emptySet
	}

	override getTargetResourceURIs() {
		emptySet
	}

	override <T> getUserData(Key<T> key) {
		null
	}

	override isEmpty() {
		true
	}

	override <T> putUserData(Key<T> key, T data) {
		// do nothing
	}

	override size() {
		0
	}

	override iterator() {
		Iterators.emptyIterator
	}

}
