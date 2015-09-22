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
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.MacroAwareTextBrowseFolderListener;
import com.intellij.ui.SeparatorWithText;
import com.intellij.ui.components.JBTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaWidgetFactory {
  public static class TwoColumnPanel extends JPanel {
    private int rowsAdded = 0;
    
    public IdeaWidgetFactory.TwoColumnPanel row(final IdeaWidgetFactory.TwoColumnPanel host, final Function1<? super GridBagConstraints, ? extends JComponent> col) {
      final GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = this.rowsAdded;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridwidth = 2;
      gbc.ipady = 4;
      JComponent _apply = col.apply(gbc);
      host.add(_apply, gbc);
      this.rowsAdded++;
      return host;
    }
    
    public IdeaWidgetFactory.TwoColumnPanel row(final IdeaWidgetFactory.TwoColumnPanel host, final Function1<? super GridBagConstraints, ? extends JComponent> col1, final Function1<? super GridBagConstraints, ? extends JComponent> col2) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = this.rowsAdded;
      gbc.ipady = 4;
      gbc.anchor = GridBagConstraints.EAST;
      JComponent _apply = col1.apply(gbc);
      host.add(_apply, gbc);
      GridBagConstraints _gridBagConstraints = new GridBagConstraints();
      gbc = _gridBagConstraints;
      gbc.gridx = 1;
      gbc.gridy = this.rowsAdded;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      JComponent _apply_1 = col2.apply(gbc);
      host.add(_apply_1, gbc);
      this.rowsAdded++;
      return host;
    }
    
    @Override
    public void add(final Component comp, final Object constraints) {
      super.add(comp, constraints);
      if ((comp instanceof JComponent)) {
        if (IdeaWidgetFactory.debug) {
          Border _createLineBorder = BorderFactory.createLineBorder(Color.BLACK);
          ((JComponent)comp).setBorder(_createLineBorder);
        }
      }
    }
  }
  
  public JPanel container(final Function1<? super GridBagConstraints, ? extends JComponent>... children) {
    final GridBagLayout layout = new GridBagLayout();
    final JPanel flowPanel = new JPanel(layout);
    for (final Function1<? super GridBagConstraints, ? extends JComponent> childAddition : children) {
      {
        final GridBagConstraints ld = new GridBagConstraints();
        JComponent _apply = childAddition.apply(ld);
        flowPanel.add(_apply, ld);
      }
    }
    return flowPanel;
  }
  
  public JCheckBox checkBox(final String string) {
    JCheckBox _jCheckBox = new JCheckBox(string);
    final Procedure1<JCheckBox> _function = new Procedure1<JCheckBox>() {
      @Override
      public void apply(final JCheckBox it) {
        if (IdeaWidgetFactory.debug) {
          it.setBorderPainted(true);
        }
      }
    };
    return ObjectExtensions.<JCheckBox>operator_doubleArrow(_jCheckBox, _function);
  }
  
  public IdeaWidgetFactory.TwoColumnPanel twoColumnPanel(final Function1<? super IdeaWidgetFactory.TwoColumnPanel, ? extends IdeaWidgetFactory.TwoColumnPanel> additions) {
    IdeaWidgetFactory.TwoColumnPanel _twoColumnPanel = new IdeaWidgetFactory.TwoColumnPanel();
    final Procedure1<IdeaWidgetFactory.TwoColumnPanel> _function = new Procedure1<IdeaWidgetFactory.TwoColumnPanel>() {
      @Override
      public void apply(final IdeaWidgetFactory.TwoColumnPanel it) {
        EmptyBorder _emptyBorder = IdeaWidgetFactory.this.emptyBorder(10);
        it.setBorder(_emptyBorder);
        GridBagLayout _gridBagLayout = new GridBagLayout();
        it.setLayout(_gridBagLayout);
      }
    };
    final IdeaWidgetFactory.TwoColumnPanel panel = ObjectExtensions.<IdeaWidgetFactory.TwoColumnPanel>operator_doubleArrow(_twoColumnPanel, _function);
    additions.apply(panel);
    return panel;
  }
  
  public EmptyBorder emptyBorder(final int i) {
    return new EmptyBorder(i, i, i, i);
  }
  
  public JLabel label(final String text) {
    return new JLabel(text);
  }
  
  public TextFieldWithBrowseButton browseField(final Project project) {
    final TextFieldWithBrowseButton field = new TextFieldWithBrowseButton();
    FileChooserDescriptor _createSingleFolderDescriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor();
    final MacroAwareTextBrowseFolderListener listener = new MacroAwareTextBrowseFolderListener(_createSingleFolderDescriptor, project);
    field.addBrowseFolderListener(listener);
    return field;
  }
  
  public JBTextField textField() {
    return this.textField("");
  }
  
  public JBTextField textField(final String text) {
    final JBTextField jbTextField = new JBTextField(text, 20);
    return jbTextField;
  }
  
  public ComboBox comboBox(final Object... values) {
    final ComboBox cb = new ComboBox(values);
    return cb;
  }
  
  public void expand(final GridBagConstraints it, final int dim) {
    if ((dim == GridBagConstraints.VERTICAL)) {
      it.weighty = 1.0;
      it.fill = GridBagConstraints.VERTICAL;
    } else {
      if ((dim == GridBagConstraints.HORIZONTAL)) {
        it.weightx = 1.0;
        it.fill = GridBagConstraints.HORIZONTAL;
      } else {
        throw new IllegalArgumentException();
      }
    }
  }
  
  public void indent(final GridBagConstraints it) {
    Insets _insets = new Insets(it.insets.top, (it.insets.left + 40), it.insets.bottom, it.insets.right);
    it.insets = _insets;
  }
  
  public void indentRight(final GridBagConstraints it, final int size) {
    Insets _insets = new Insets(it.insets.top, it.insets.left, it.insets.bottom, (it.insets.right + size));
    it.insets = _insets;
  }
  
  public SeparatorWithText separator(final String title) {
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
  
  private static boolean debug = false;
}
