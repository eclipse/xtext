/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.icons;

import com.intellij.openapi.util.IconLoader;
import javax.swing.Icon;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendIcons {
  private static Icon load(final String path) {
    return IconLoader.getIcon(path, XtendIcons.class);
  }
  
  public final static Icon Xtend_16x16 = XtendIcons.load("/org/eclipse/xtend/core/idea/icons/xtend_16x16.png");
  
  public final static Icon Xtend_FILE_16x16 = XtendIcons.load("/org/eclipse/xtend/core/idea/icons/xtend_file_16x16.png");
}
