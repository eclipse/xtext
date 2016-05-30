/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.concurrent;

import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.server.concurrent.CancellableIndicator;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class RequestCancelIndicator implements CancellableIndicator {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private volatile boolean canceled;
  
  @Override
  public void cancel() {
    this.canceled = true;
  }
  
  @Pure
  public boolean isCanceled() {
    return this.canceled;
  }
}
