/*******************************************************************************
 * Copyright (c) 2024 Lorenzo Bettini and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata.stubs;

import java.util.Iterator;
import java.util.RandomAccess;

/**
 * A stub type to use instead of relying on Java API like AbstractList, whose methods and supertypes might change in newer versions (see,
 * e.g., https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/SequencedCollection.html).
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
@SuppressWarnings("serial")
public class StubbedArrayList<E> extends StubbedAbstractList<E>
		implements RandomAccess, Cloneable, java.io.Serializable {

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

}
