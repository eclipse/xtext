/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import io.typefox.lsapi.WindowService
import io.typefox.lsapi.NotificationCallback
import io.typefox.lsapi.MessageParams
import io.typefox.lsapi.ShowMessageRequestParams

/**
 * @author efftinge - Initial contribution and API
 */
class WindowServiceImpl implements WindowService {
    
    override onShowMessage(NotificationCallback<MessageParams> callback) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override onShowMessageRequest(NotificationCallback<ShowMessageRequestParams> callback) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override onLogMessage(NotificationCallback<MessageParams> callback) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
}