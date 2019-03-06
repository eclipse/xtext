/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
