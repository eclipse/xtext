/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.mocks;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.index.IGenericQuery;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class MockQuery<T> implements IGenericQuery<T> {

	private T result = null;
	
	public MockQuery() {
	}

	public MockQuery(T result) {
		this.result = result;
	}
	
	public List<T> executeListResult() {
		return (result == null) ? null : Collections.singletonList(result);
	}

	public T executeSingleResult() {
		return result;
	}

}
