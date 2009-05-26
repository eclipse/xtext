/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;


/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IGenericQuery<T> {
	
	static final char WILDCARD = '*';
	
	T executeSingleResult();
	
	Iterable<T> executeListResult();
}
