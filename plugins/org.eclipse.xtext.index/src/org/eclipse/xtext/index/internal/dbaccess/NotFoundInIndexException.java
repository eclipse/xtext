/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index.internal.dbaccess;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class NotFoundInIndexException extends Exception {

	private static final long serialVersionUID = -7458489937462606476L;

	public NotFoundInIndexException() {
		super();
	}
	
	public NotFoundInIndexException(String message) {
		super(message);
	}

}
