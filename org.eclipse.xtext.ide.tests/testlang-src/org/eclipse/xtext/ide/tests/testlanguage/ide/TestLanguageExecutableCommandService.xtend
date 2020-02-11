/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide

import org.eclipse.xtext.ide.server.commands.IExecutableCommandService
import org.eclipse.lsp4j.ExecuteCommandParams
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class TestLanguageExecutableCommandService implements IExecutableCommandService {
	
	override initialize() {
		#["testlang.a", "testlang.b", "testlang.c"]
	}
	
	override execute(ExecuteCommandParams params, ILanguageServerAccess access, CancelIndicator cancelIndicator) {
		if (params.command == "testlang.a") {
			return "a"
		} else if (params.command == "testlang.b") {
			return "b"
		} else if (params.command == "testlang.c") {
			return "c"
		}
	}
	
}