/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.ui.wizard.project.Messages;
import org.eclipse.xtext.xtext.ui.wizard.project.WizardContribution;

@SuppressWarnings("all")
public class AdvancedNewProjectPage extends WizardPage {
  private Button createFeatureProject;
  
  private Button createTestProject;
  
  private Combo generatorConfigurationField;
  
  public AdvancedNewProjectPage(final String pageName) {
    super(pageName);
    this.setTitle(Messages.WizardNewXtextProjectCreationPage_WindowTitle);
    this.setDescription(Messages.WizardNewXtextProjectCreationPage_Description);
  }
  
  @Override
  public void createControl(final Composite parent) {
    Map<String, WizardContribution> _fromRegistry = WizardContribution.getFromRegistry();
    int _size = _fromRegistry.size();
    final boolean showGeneratorConfigCombo = (_size > 1);
    Group _group = new Group(parent, SWT.NONE);
    final Procedure1<Group> _function = new Procedure1<Group>() {
      @Override
      public void apply(final Group it) {
        Font _font = parent.getFont();
        it.setFont(_font);
        it.setText(Messages.WizardNewXtextProjectCreationPage_LabelFacets);
        GridData _gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
        it.setLayoutData(_gridData);
        int _xifexpression = (int) 0;
        if (showGeneratorConfigCombo) {
          _xifexpression = 2;
        } else {
          _xifexpression = 1;
        }
        GridLayout _gridLayout = new GridLayout(_xifexpression, false);
        it.setLayout(_gridLayout);
      }
    };
    final Group facetsGroup = ObjectExtensions.<Group>operator_doubleArrow(_group, _function);
    Composite _composite = new Composite(facetsGroup, SWT.NONE);
    final Procedure1<Composite> _function_1 = new Procedure1<Composite>() {
      @Override
      public void apply(final Composite it) {
        GridData _gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
        it.setLayoutData(_gridData);
        GridLayout _gridLayout = new GridLayout(1, false);
        it.setLayout(_gridLayout);
      }
    };
    final Composite composite = ObjectExtensions.<Composite>operator_doubleArrow(_composite, _function_1);
    Button _newCheckBox = this.newCheckBox(composite);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setText(Messages.WizardNewXtextProjectCreationPage_CreateFeatureLabel);
        it.setSelection(true);
      }
    };
    Button _doubleArrow = ObjectExtensions.<Button>operator_doubleArrow(_newCheckBox, _function_2);
    this.createFeatureProject = _doubleArrow;
    Button _newCheckBox_1 = this.newCheckBox(composite);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        it.setText(Messages.WizardNewXtextProjectCreationPage_CreateATestProject);
        it.setSelection(true);
      }
    };
    Button _doubleArrow_1 = ObjectExtensions.<Button>operator_doubleArrow(_newCheckBox_1, _function_3);
    this.createTestProject = _doubleArrow_1;
    if (showGeneratorConfigCombo) {
      Label _label = new Label(composite, SWT.NONE);
      final Procedure1<Label> _function_4 = new Procedure1<Label>() {
        @Override
        public void apply(final Label it) {
          it.setText(Messages.WizardNewXtextProjectCreationPage_GeneratorConfiguration);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label, _function_4);
      Combo _combo = new Combo(composite, SWT.READ_ONLY);
      final Procedure1<Combo> _function_5 = new Procedure1<Combo>() {
        @Override
        public void apply(final Combo it) {
          GridData _gridData = new GridData(GridData.FILL_HORIZONTAL);
          final Procedure1<GridData> _function = new Procedure1<GridData>() {
            @Override
            public void apply(final GridData it) {
              it.horizontalSpan = 1;
            }
          };
          GridData _doubleArrow = ObjectExtensions.<GridData>operator_doubleArrow(_gridData, _function);
          it.setLayoutData(_doubleArrow);
          Font _font = parent.getFont();
          it.setFont(_font);
        }
      };
      Combo _doubleArrow_2 = ObjectExtensions.<Combo>operator_doubleArrow(_combo, _function_5);
      this.generatorConfigurationField = _doubleArrow_2;
      this.fillMweSnippet();
    }
    this.setControl(facetsGroup);
  }
  
  protected Button newCheckBox(final Composite composite) {
    Button _button = new Button(composite, SWT.CHECK);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        GridData _gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        final Procedure1<GridData> _function = new Procedure1<GridData>() {
          @Override
          public void apply(final GridData it) {
            it.horizontalSpan = 1;
          }
        };
        GridData _doubleArrow = ObjectExtensions.<GridData>operator_doubleArrow(_gridData, _function);
        it.setLayoutData(_doubleArrow);
      }
    };
    return ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  protected void fillMweSnippet() {
    Map<String, WizardContribution> _fromRegistry = WizardContribution.getFromRegistry();
    final Collection<WizardContribution> contributions = _fromRegistry.values();
    List<WizardContribution> _list = IterableExtensions.<WizardContribution>toList(contributions);
    List<WizardContribution> _sortInplace = ListExtensions.<WizardContribution>sortInplace(_list);
    final Function1<WizardContribution, String> _function = new Function1<WizardContribution, String>() {
      @Override
      public String apply(final WizardContribution it) {
        return it.getName();
      }
    };
    final List<String> names = ListExtensions.<WizardContribution, String>map(_sortInplace, _function);
    if ((this.generatorConfigurationField != null)) {
      this.generatorConfigurationField.setItems(((String[])Conversions.unwrapArray(names, String.class)));
      int _indexOfDefault = this.indexOfDefault(names);
      this.generatorConfigurationField.select(_indexOfDefault);
    }
  }
  
  protected int indexOfDefault(final List<String> contributions) {
    int _xblockexpression = (int) 0;
    {
      String _defaultConfigName = this.getDefaultConfigName();
      final int index = contributions.indexOf(_defaultConfigName);
      int _xifexpression = (int) 0;
      if ((index != (-1))) {
        _xifexpression = index;
      } else {
        _xifexpression = 0;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String getDefaultConfigName() {
    return "Standard";
  }
  
  public boolean isCreateFeatureProject() {
    return this.createFeatureProject.getSelection();
  }
  
  public boolean isCreateTestProject() {
    return this.createTestProject.getSelection();
  }
  
  public String getGeneratorConfig() {
    String _xifexpression = null;
    if ((this.generatorConfigurationField == null)) {
      Map<String, WizardContribution> _fromRegistry = WizardContribution.getFromRegistry();
      Collection<WizardContribution> _values = _fromRegistry.values();
      WizardContribution _head = IterableExtensions.<WizardContribution>head(_values);
      _xifexpression = _head.getName();
    } else {
      String _xblockexpression = null;
      {
        final int index = this.generatorConfigurationField.getSelectionIndex();
        String[] _items = this.generatorConfigurationField.getItems();
        _xblockexpression = _items[index];
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
}
