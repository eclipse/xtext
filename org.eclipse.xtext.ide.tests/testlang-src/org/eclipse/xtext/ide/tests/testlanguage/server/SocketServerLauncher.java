/*******************************************************************************
 * Copyright (c) 2016, 2022 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.server;

/**
 * @author kosyakov - Initial contribution and API
 */
public class SocketServerLauncher {

	public static void main(String[] args) throws Exception {
		org.eclipse.xtext.ide.server.SocketServerLauncher.main(new String[] {
			"-host", "localhost",
			"-port", "5007",
			"-trace"
		});
	}

}
