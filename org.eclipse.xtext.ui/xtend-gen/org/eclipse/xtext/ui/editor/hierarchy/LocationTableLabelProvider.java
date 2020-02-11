/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.inject.Singleton;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
@SuppressWarnings("all")
public class LocationTableLabelProvider extends BaseLabelProvider implements ITableLabelProvider {
  @Override
  public Image getColumnImage(final Object element, final int columnIndex) {
    return null;
  }
  
  @Override
  public String getColumnText(final Object reference, final int columnIndex) {
    if ((reference instanceof IHierarchyNodeReference)) {
      switch (columnIndex) {
        case 0:
          int _lineNumber = ((IHierarchyNodeReference)reference).getLineNumber();
          int _plus = (_lineNumber + 1);
          return String.valueOf(_plus);
        case 1:
          return ((IHierarchyNodeReference)reference).getText();
      }
    }
    return "";
  }
}
