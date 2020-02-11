/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtext.testing.AbstractLanguageServerTest;

/**
 * @author akosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractTestLangLanguageServerTest extends AbstractLanguageServerTest {
  public AbstractTestLangLanguageServerTest() {
    super("testlang");
  }
}
