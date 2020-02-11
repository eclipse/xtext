/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata.ordersensitivity;

import java.util.Collection;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
@SuppressWarnings("unused")
public class CaseB {
	
	public <T> String overloaded(Iterable<? extends T> iterable, Collection<T> collection) {
		return "overloaded(Iterable,Collection)";
	}

	public <T> String overloaded(Collection<T> collection, Iterable<? extends T> iterable) {
		return "overloaded(Collection,Iterable)";
	}
}
