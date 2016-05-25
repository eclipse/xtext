/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import io.typefox.lsapi.PositionImpl
import io.typefox.lsapi.RangeImpl

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class LSPExtensions {
    
    
    static def PositionImpl newPosition(int line, int character) {
        new PositionImpl => [
            it.line = line
            it.character = character
        ]
    }
    
    static def RangeImpl newRange(PositionImpl start, PositionImpl end) {
        new RangeImpl => [
            it.start = start
            it.end = end
        ]
    }
}