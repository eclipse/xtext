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
public class CircularDependencyFactory1 implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor descriptor, Class<? extends ILanguageService> serviceClass) {
        return new CircularDependencyService1();
    }

    public boolean isFactoryFor(ILanguageDescriptor descriptor, Class<? extends ILanguageService> serviceClass) {
        return CircularDependencyService1.class.equals(serviceClass);
    }

}
