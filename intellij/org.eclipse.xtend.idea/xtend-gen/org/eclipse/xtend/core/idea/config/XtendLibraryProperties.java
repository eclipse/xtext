/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.intellij.openapi.roots.libraries.LibraryProperties;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendLibraryProperties extends LibraryProperties<XtendLibraryProperties> {
  @Override
  public boolean equals(final Object obj) {
    return true;
  }
  
  @Override
  public int hashCode() {
    return 0;
  }
  
  @Override
  public XtendLibraryProperties getState() {
    return null;
  }
  
  @Override
  public void loadState(final XtendLibraryProperties state) {
  }
}
