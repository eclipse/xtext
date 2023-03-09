/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

public class ArrayClient2<T> {
	
    private T[] internal;

    public ArrayClient2(T[] internal) {
        this.internal = internal;
    }

    public T get(int index) {
        return internal[index];
    }

    public T set(int index, T value) {
        return internal[index] = value;
    }

    public static <X> ArrayClient2<X> access(X[] val) {
        return new ArrayClient2<X>(val);
    }

}