/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

/**
 * DAOs provide access to the index store. The are used to store and delete
 * index entries and as factories for queries.
 * 
 * Each index element type has its own DAO.
 * 
 * Sub-interfaces define additonal createQuery methods to mark often used
 * high-level queries that can be optimized to the storage technology in the
 * concrete implementation of the DAO.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IDAO<T> {

	void store(T element);

	void delete(T element);

}
