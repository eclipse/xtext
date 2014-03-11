/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import org.eclipse.xtext.xbase.ui.tests.editor.ContentAssistTest;
import org.junit.Ignore;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=430022")
@SuppressWarnings("all")
public class ContentAssistReturnTest extends ContentAssistTest {
  protected String getPrefix() {
    return "return";
  }
}
