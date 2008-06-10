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
 * 
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class MyLanguageService implements ILanguageService {

    InjectedLanguageService injectedService = null;

    public InjectedLanguageService getInjectedService() {
        return injectedService;
    }

    @InjectedService
    public void setInjectedService(InjectedLanguageService injectedService) {
        this.injectedService = injectedService;
    }

}
