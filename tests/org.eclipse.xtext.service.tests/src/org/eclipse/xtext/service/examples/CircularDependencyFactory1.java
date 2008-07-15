/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.examples;

import org.eclipse.xtext.service.IServiceFactory;

/**
 * @author Jan Köhnlein
 *
 */
public class CircularDependencyFactory1 implements IServiceFactory {

    public Object createService() {
        return new CircularDependencyService1();
    }

    public Class<? > getServiceInterface() {
        return CircularDependencyService1.class;
    }

}
