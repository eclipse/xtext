/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.service.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class SampleServiceDependentClass {

    private IParser parser;

    @Inject
    public void setParser(IParser parser) {
        this.parser = parser;
    }
    
    public IParser getParser() {
        return parser;
    }
}
