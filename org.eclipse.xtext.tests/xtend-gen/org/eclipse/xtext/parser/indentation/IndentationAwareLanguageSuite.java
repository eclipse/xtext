/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.indentation;

import org.eclipse.xtext.parser.indentation.IndentationAwareLanguageTest;
import org.eclipse.xtext.parser.indentation.NodeModelTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ IndentationAwareLanguageTest.class, NodeModelTest.class })
@SuppressWarnings("all")
public class IndentationAwareLanguageSuite {
}
