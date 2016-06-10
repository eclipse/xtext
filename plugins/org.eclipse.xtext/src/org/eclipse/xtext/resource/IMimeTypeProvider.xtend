/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource

import com.google.inject.ImplementedBy
import java.util.List

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(DefaultImpl)
interface IMimeTypeProvider {
    
    def List<String> getMimeTypes()
    
    static class DefaultImpl implements IMimeTypeProvider {
        
        override getMimeTypes() {
            #[]
        }
        
    }
}