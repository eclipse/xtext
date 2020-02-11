/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import com.google.inject.ImplementedBy;

/**
 * @author dietrich - Initial contribution and API
 * 
 * @since 2.16
 */
@ImplementedBy(ILanguageServerShutdownAndExitHandler.DefaultImpl.class)
public interface ILanguageServerShutdownAndExitHandler {

	/**
	 * Callback that is called when Language Servers <code>exit</code> is called.
	 */
	void exit();

	/**
	 * Callback that is called when Language Servers <code>shutdown</code> is called.
	 */
	void shutdown();

	/**
	 * Implementation for {@link ILanguageServerShutdownAndExitHandler} that does nothing.
	 */
	public static class NullImpl implements ILanguageServerShutdownAndExitHandler {

		@Override
		public void exit() {
			// do nothing
		}

		@Override
		public void shutdown() {
			// do nothing
		}

	}

	/**
	 * Default Implementation for {@link ILanguageServerShutdownAndExitHandler}. Calls <code>System.exit</code>.
	 */
	public static class DefaultImpl implements ILanguageServerShutdownAndExitHandler {

		private boolean hasShutdownBeenCalled = false;

		@Override
		public void exit() {
			if (hasShutdownBeenCalled) {
				System.exit(0);
			} else {
				System.exit(1);
			}
		}

		@Override
		public void shutdown() {
			hasShutdownBeenCalled = true;
		}

	}

}
