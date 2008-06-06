/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtextgen.impl;

import org.eclipse.xtext.util.Strings;


/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class XtextgenUtil {

    /**
     * @param genServiceImpl
     * @return
     */
    public static String genClassPackageFQName(GenClassImpl genClass) {
        return Strings.skipLastToken(genClass.getGenClassFQName(), ".");
    }

    /**
     * @param genServiceImpl
     * @return
     */
    public static String genClassName(GenClassImpl genClass) {
        return Strings.lastToken(genClass.getGenClassFQName(), ".");
    }

    /**
     * @param genServiceImpl
     * @return
     */
    public static String serviceInterfaceName(GenServiceImpl genService) {
        return Strings.lastToken(genService.getServiceInterfaceFQName(), ".");
    }

    /**
     * @param genServiceImpl
     * @return
     */
    public static String extensionPointName(GenServiceImpl genService) {
        return Strings.lastToken(genService.getExtensionPointID(), ".");
    }

    
}
