/*******************************************************************************
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import java.util.List;

import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.collect.Lists;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class TestLanguageExecutableCommandService implements IExecutableCommandService {
	
	@Override
	public List<String> initialize() {
		return Lists.newArrayList("testlang.a", "testlang.b", "testlang.c");
	}
	
	@Override
	public Object execute(ExecuteCommandParams params, ILanguageServerAccess access, CancelIndicator cancelIndicator) {
		if ("testlang.a".equals(params.getCommand())) {
			return "a";
		} else if ("testlang.b".equals(params.getCommand())) {
			return "b";
		} else if ("testlang.c".equals(params.getCommand())) {
			return "c";
		}
		return null;
	}
	
}