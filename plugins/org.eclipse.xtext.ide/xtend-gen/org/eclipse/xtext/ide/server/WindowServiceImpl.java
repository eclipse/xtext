/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import io.typefox.lsapi.MessageParams;
import io.typefox.lsapi.NotificationCallback;
import io.typefox.lsapi.ShowMessageRequestParams;
import io.typefox.lsapi.WindowService;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class WindowServiceImpl implements WindowService {
  @Override
  public void onShowMessage(final NotificationCallback<MessageParams> callback) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void onShowMessageRequest(final NotificationCallback<ShowMessageRequestParams> callback) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void onLogMessage(final NotificationCallback<MessageParams> callback) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
