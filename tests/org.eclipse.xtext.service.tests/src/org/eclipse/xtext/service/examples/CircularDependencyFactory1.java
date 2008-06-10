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
import org.eclipse.xtext.service.ILanguageServiceFactory;

/**
 * @author Jan Köhnlein
 *
 */
public class CircularDependencyFactory1 implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        return new CircularDependencyService1();
    }

    public Class<? extends ILanguageService> getServiceInterface() {
        return CircularDependencyService1.class;
    }

}
