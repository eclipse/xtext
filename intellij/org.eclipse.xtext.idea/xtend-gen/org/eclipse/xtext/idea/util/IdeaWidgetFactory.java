/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.util;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.MacroAwareTextBrowseFolderListener;
import com.intellij.ui.SeparatorWithText;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaWidgetFactory {
  public static TextFieldWithBrowseButton createBrowseField(final Project project) {
    final TextFieldWithBrowseButton field = new TextFieldWithBrowseButton();
    FileChooserDescriptor _createSingleFolderDescriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor();
    MacroAwareTextBrowseFolderListener _macroAwareTextBrowseFolderListener = new MacroAwareTextBrowseFolderListener(_createSingleFolderDescriptor, project);
    field.addBrowseFolderListener(_macroAwareTextBrowseFolderListener);
    return field;
  }
  
  public static SeparatorWithText createTitledSeparator(final String title) {
    SeparatorWithText _separatorWithText = new SeparatorWithText();
    final Procedure1<SeparatorWithText> _function = new Procedure1<SeparatorWithText>() {
      @Override
      public void apply(final SeparatorWithText it) {
        it.setCaption(title);
        it.setCaptionCentered(false);
      }
    };
    final SeparatorWithText separator = ObjectExtensions.<SeparatorWithText>operator_doubleArrow(_separatorWithText, _function);
    return separator;
  }
}
