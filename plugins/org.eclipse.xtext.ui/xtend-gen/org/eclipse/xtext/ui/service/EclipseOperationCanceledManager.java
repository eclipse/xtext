/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.service;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.xtext.service.OperationCanceledManager;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class EclipseOperationCanceledManager extends OperationCanceledManager {
  @Override
  protected Throwable getPlatformSpecificOperationCanceledException() {
    return new OperationCanceledException();
  }
}
