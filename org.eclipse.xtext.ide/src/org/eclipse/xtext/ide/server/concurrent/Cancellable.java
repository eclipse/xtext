/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent;

/**
 * A functional interface that indicates something that can be cancelled.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
public interface Cancellable {
	/**
	 * Attempt to cancel.
	 */
	void cancel();
}