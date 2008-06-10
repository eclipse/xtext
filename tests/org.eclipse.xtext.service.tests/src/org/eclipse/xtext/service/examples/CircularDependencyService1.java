/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.examples;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.InjectedService;

/**
 * @author Jan Köhnlein
 *
 */
public class CircularDependencyService1 implements ILanguageService {

    private CircularDependencyService0 service;

    @InjectedService
    public void setDependency(CircularDependencyService0 service) {
        this.service = service;
    }
    
    public CircularDependencyService0 getService() {
        return service;
    }
}
