/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service;

/**
 * @author Jan Köhnlein
 * 
 */
public class CircularDependencyService0 implements ILanguageService {

    private CircularDependencyService1 service;

    @InjectedService
    public void setDependency(CircularDependencyService1 service) {
        this.service = service;
    }
    
    public CircularDependencyService1 getService() {
        return service;
    }
    
}
