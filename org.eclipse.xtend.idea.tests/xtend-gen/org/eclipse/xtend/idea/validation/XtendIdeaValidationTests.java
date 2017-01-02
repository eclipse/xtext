/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.validation;

import org.eclipse.xtend.idea.LightXtendTest;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendIdeaValidationTests extends LightXtendTest {
  public void testWrongPackage() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method configureByText(String) is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\ncheckHighlighting cannot be resolved");
  }
  
  public void testExcludedFile() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ApplicationManager is undefined"
      + "\nThe method or field ModuleRootManager is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field VfsUtil is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\napplication cannot be resolved"
      + "\nrunWriteAction cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\nmodule cannot be resolved"
      + "\nmodifiableModel cannot be resolved"
      + "\ncontentEntries cannot be resolved"
      + "\nhead cannot be resolved"
      + "\ncreateDirectoryIfMissing cannot be resolved"
      + "\nfile cannot be resolved"
      + "\naddExcludeFolder cannot be resolved"
      + "\ncommit cannot be resolved"
      + "\naddFileToProject cannot be resolved"
      + "\nvirtualFile cannot be resolved"
      + "\ntestHighlighting cannot be resolved");
  }
}
