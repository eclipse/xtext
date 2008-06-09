/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.xtext.xtextgen.GenModel;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class GenExtensions {

    public static String outletPath(GenModel genModel, String outletName) {
        String result = genModel.getOutletMap().get(outletName);
        if(result == null) {
            throw new NullPointerException("No such outlet : " + outletName);
        }
        return result;
    }
}
