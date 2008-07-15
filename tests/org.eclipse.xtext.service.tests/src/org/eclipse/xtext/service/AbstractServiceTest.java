/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service;

import junit.framework.TestCase;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public abstract class AbstractServiceTest extends TestCase {

    protected IServiceScope myScope;

    /**
     * 
     */
    public AbstractServiceTest() {
        super();
    }

    /**
     * @param name
     */
    public AbstractServiceTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ServiceRegistry.resetInternal();
        ServiceScopeFactory.resetInternal();
        myScope = ServiceScopeFactory.createScope("xx", null);
    }

}