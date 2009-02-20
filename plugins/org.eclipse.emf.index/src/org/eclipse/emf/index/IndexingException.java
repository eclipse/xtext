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
public class IndexingException extends RuntimeException {

	private static final long serialVersionUID = 1301917628130598408L;

	public IndexingException(String message, Object object) {
		StringBuilder builder = new StringBuilder(message);
		if (object == null)
			builder.append("null");
		else
			builder.append(object.toString());
		message = builder.toString();
	}

}
