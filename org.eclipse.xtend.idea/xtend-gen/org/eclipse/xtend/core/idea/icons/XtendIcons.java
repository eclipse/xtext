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
  
  public final static Icon Xtend_FILETYPE = XtendIcons.load("/icons/xtend_filetype.png");
  
  public final static Icon Xtend_CLASS = XtendIcons.load("/icons/xtend_class.png");
  
  public final static Icon Xtend_INTERFACE = XtendIcons.load("/icons/xtend_interface.png");
  
  public final static Icon Xtend_ENUM = XtendIcons.load("/icons/xtend_enum.png");
  
  public final static Icon Xtend_ANNOTATIONTYPE = XtendIcons.load("/icons/xtend_annotationtype.png");
  
  public final static Icon Xtend_ICON = XtendIcons.load("/icons/xtend.png");
}
