/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.internal;

import org.eclipse.xtext.service.IServiceScope;

/**
 * @author Peter Friese - Initial contribution and API
 * @author svenefftinge
 */
public class ServiceScope implements IServiceScope {
	private String id;
	private IServiceScope parentScope;

    public ServiceScope(String id, IServiceScope parentScope) {
        super();
        this.id = id;
        this.parentScope = parentScope;
    }

    /* (non-Javadoc)
     * @see org.eclipse.xtext.service.IServiceScope#getId()
     */
	public String getId() {
		return id;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.IServiceScope#getParentScope()
	 */
	public IServiceScope getParentScope() {
		return parentScope;
	}

	@Override
	public String toString() {
	    return "Scope " + id + " -> " + parentScope!=null?parentScope.toString():""; 
	}
}
