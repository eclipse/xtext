/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index;

import org.eclipse.emf.common.util.URI;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class DanglingCrossrefEvent {

	private URI referencer;
	private URI referenced;
	
	public DanglingCrossrefEvent(URI referencer, URI referenced) {
		super();
		this.referencer = referencer;
		this.referenced = referenced;
	}
	
	/**
	 * @return the referenced
	 */
	public URI getReferenced() {
		return referenced;
	}
	
	/**
	 * @return the referencer
	 */
	public URI getReferencer() {
		return referencer;
	}
}
