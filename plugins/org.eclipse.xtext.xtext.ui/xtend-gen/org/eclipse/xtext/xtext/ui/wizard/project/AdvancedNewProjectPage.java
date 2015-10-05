/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.ui.wizard.project;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.ui.wizard.project.Messages;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.SourceLayout;

@SuppressWarnings("all")
public class AdvancedNewProjectPage extends WizardPage {
  private Button createUiProject;
  
  private Button createIdeaProject;
  
  private Button createWebProject;
  
  private Button createIdeProject;
  
  private Button createTestProject;
  
  private Combo preferredBuildSystem;
  
  private Combo sourceLayout;
  
  public AdvancedNewProjectPage(final String pageName) {
    super(pageName);
    this.setTitle(Messages.AdvancedNewProjectPage_WindowTitle);
    this.setDescription(Messages.AdvancedNewProjectPage_Description);
  }
  
  @Override
  public void createControl(final Composite parent) {
    Composite _composite = new Composite(parent, SWT.NONE);
    final Procedure1<Composite> _function = new Procedure1<Composite>() {
      @Override
      public void apply(final Composite it) {
        GridData _gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
        it.setLayoutData(_gridData);
        GridLayout _gridLayout = new GridLayout(1, false);
        it.setLayout(_gridLayout);
        final Procedure1<Group> _function = new Procedure1<Group>() {
          @Override
          public void apply(final Group it) {
            it.setText(Messages.WizardNewXtextProjectCreationPage_LabelFacets);
            final Procedure1<Button> _function = new Procedure1<Button>() {
              @Override
              public void apply(final Button it) {
                it.setText("Eclipse Plugin");
              }
            };
            Button _CheckBox = AdvancedNewProjectPage.this.CheckBox(it, _function);
            AdvancedNewProjectPage.this.createUiProject = _CheckBox;
            final Procedure1<Button> _function_1 = new Procedure1<Button>() {
              @Override
              public void apply(final Button it) {
                it.setText("IntelliJ IDEA Plugin");
                it.setEnabled(true);
              }
            };
            Button _CheckBox_1 = AdvancedNewProjectPage.this.CheckBox(it, _function_1);
            AdvancedNewProjectPage.this.createIdeaProject = _CheckBox_1;
            final Procedure1<Button> _function_2 = new Procedure1<Button>() {
              @Override
              public void apply(final Button it) {
                it.setText("Web Integration");
                it.setEnabled(true);
              }
            };
            Button _CheckBox_2 = AdvancedNewProjectPage.this.CheckBox(it, _function_2);
            AdvancedNewProjectPage.this.createWebProject = _CheckBox_2;
            final Procedure1<Button> _function_3 = new Procedure1<Button>() {
              @Override
              public void apply(final Button it) {
                it.setText("Generic IDE Support");
                it.setEnabled(true);
              }
            };
            Button _CheckBox_3 = AdvancedNewProjectPage.this.CheckBox(it, _function_3);
            AdvancedNewProjectPage.this.createIdeProject = _CheckBox_3;
            final Procedure1<Button> _function_4 = new Procedure1<Button>() {
              @Override
              public void apply(final Button it) {
                it.setText(Messages.WizardNewXtextProjectCreationPage_TestingSupport);
              }
            };
            Button _CheckBox_4 = AdvancedNewProjectPage.this.CheckBox(it, _function_4);
            AdvancedNewProjectPage.this.createTestProject = _CheckBox_4;
          }
        };
        AdvancedNewProjectPage.this.Group(it, _function);
        final Procedure1<Group> _function_1 = new Procedure1<Group>() {
          @Override
          public void apply(final Group it) {
            it.setText("Preferred Build System");
            final Procedure1<Combo> _function = new Procedure1<Combo>() {
              @Override
              public void apply(final Combo it) {
                it.setEnabled(true);
                BuildSystem[] _values = BuildSystem.values();
                final Function1<BuildSystem, String> _function = new Function1<BuildSystem, String>() {
                  @Override
                  public String apply(final BuildSystem it) {
                    return it.toString();
                  }
                };
                List<String> _map = ListExtensions.<BuildSystem, String>map(((List<BuildSystem>)Conversions.doWrapArray(_values)), _function);
                it.setItems(((String[])Conversions.unwrapArray(_map, String.class)));
              }
            };
            Combo _DropDown = AdvancedNewProjectPage.this.DropDown(it, _function);
            AdvancedNewProjectPage.this.preferredBuildSystem = _DropDown;
          }
        };
        AdvancedNewProjectPage.this.Group(it, _function_1);
        final Procedure1<Group> _function_2 = new Procedure1<Group>() {
          @Override
          public void apply(final Group it) {
            it.setText("Source Layout");
            final Procedure1<Combo> _function = new Procedure1<Combo>() {
              @Override
              public void apply(final Combo it) {
                it.setEnabled(true);
                SourceLayout[] _values = SourceLayout.values();
                final Function1<SourceLayout, String> _function = new Function1<SourceLayout, String>() {
                  @Override
                  public String apply(final SourceLayout it) {
                    return it.toString();
                  }
                };
                List<String> _map = ListExtensions.<SourceLayout, String>map(((List<SourceLayout>)Conversions.doWrapArray(_values)), _function);
                it.setItems(((String[])Conversions.unwrapArray(_map, String.class)));
              }
            };
            Combo _DropDown = AdvancedNewProjectPage.this.DropDown(it, _function);
            AdvancedNewProjectPage.this.sourceLayout = _DropDown;
          }
        };
        AdvancedNewProjectPage.this.Group(it, _function_2);
      }
    };
    Composite _doubleArrow = ObjectExtensions.<Composite>operator_doubleArrow(_composite, _function);
    this.setControl(_doubleArrow);
    this.require(this.createIdeaProject, this.createIdeProject);
    this.require(this.createWebProject, this.createIdeProject);
    this.makeUiProjectRequirePlainLayout();
    this.makeWebProjectRequireMavenOrGradle();
    this.setDefaults();
  }
  
  protected Group Group(final Composite parent, final Procedure1<? super Group> config) {
    Group _group = new Group(parent, SWT.NONE);
    final Procedure1<Group> _function = new Procedure1<Group>() {
      @Override
      public void apply(final Group it) {
        Font _font = parent.getFont();
        it.setFont(_font);
        GridData _gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
        it.setLayoutData(_gridData);
        GridLayout _gridLayout = new GridLayout(1, false);
        it.setLayout(_gridLayout);
        config.apply(it);
      }
    };
    return ObjectExtensions.<Group>operator_doubleArrow(_group, _function);
  }
  
  protected Button CheckBox(final Composite composite, final Procedure1<? super Button> config) {
    Button _button = new Button(composite, SWT.CHECK);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      @Override
      public void apply(final Button it) {
        Composite _parent = it.getParent();
        Font _font = _parent.getFont();
        it.setFont(_font);
        GridData _gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        it.setLayoutData(_gridData);
        config.apply(it);
      }
    };
    return ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  protected Combo DropDown(final Composite parent, final Procedure1<? super Combo> config) {
    Combo _combo = new Combo(parent, SWT.READ_ONLY);
    final Procedure1<Combo> _function = new Procedure1<Combo>() {
      @Override
      public void apply(final Combo it) {
        Font _font = parent.getFont();
        it.setFont(_font);
        GridData _gridData = new GridData(GridData.FILL_HORIZONTAL);
        it.setLayoutData(_gridData);
        config.apply(it);
      }
    };
    return ObjectExtensions.<Combo>operator_doubleArrow(_combo, _function);
  }
  
  protected void setDefaults() {
    this.createUiProject.setSelection(true);
    this.createIdeaProject.setSelection(false);
    this.createWebProject.setSelection(false);
    this.createIdeProject.setSelection(false);
    this.createTestProject.setSelection(false);
    this.preferredBuildSystem.select(0);
    this.sourceLayout.select(0);
  }
  
  public boolean isCreateUiProject() {
    return this.createUiProject.getSelection();
  }
  
  public boolean isCreateTestProject() {
    return this.createTestProject.getSelection();
  }
  
  public boolean isCreateIdeProject() {
    return this.createIdeProject.getSelection();
  }
  
  public boolean isCreateIntellijProject() {
    return this.createIdeaProject.getSelection();
  }
  
  public boolean isCreateWebProject() {
    return this.createWebProject.getSelection();
  }
  
  public BuildSystem getPreferredBuildSystem() {
    BuildSystem[] _values = BuildSystem.values();
    int _selectionIndex = this.preferredBuildSystem.getSelectionIndex();
    return _values[_selectionIndex];
  }
  
  public SourceLayout getSourceLayout() {
    SourceLayout[] _values = SourceLayout.values();
    int _selectionIndex = this.sourceLayout.getSelectionIndex();
    return _values[_selectionIndex];
  }
  
  private void require(final Button project, final Button requirement) {
    final SelectionAdapter selectionControl = new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        boolean _and = false;
        boolean _equals = project.equals(e.widget);
        if (!_equals) {
          _and = false;
        } else {
          boolean _selection = project.getSelection();
          _and = _selection;
        }
        if (_and) {
          requirement.setSelection(true);
        } else {
          boolean _and_1 = false;
          boolean _equals_1 = requirement.equals(e.widget);
          if (!_equals_1) {
            _and_1 = false;
          } else {
            boolean _selection_1 = requirement.getSelection();
            boolean _not = (!_selection_1);
            _and_1 = _not;
          }
          if (_and_1) {
            project.setSelection(false);
          }
        }
      }
    };
    project.addSelectionListener(selectionControl);
    requirement.addSelectionListener(selectionControl);
  }
  
  public void makeUiProjectRequirePlainLayout() {
    final SelectionAdapter selectionControl = new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        boolean _and = false;
        boolean _equals = Objects.equal(e.widget, AdvancedNewProjectPage.this.createUiProject);
        if (!_equals) {
          _and = false;
        } else {
          boolean _selection = AdvancedNewProjectPage.this.createUiProject.getSelection();
          _and = _selection;
        }
        if (_and) {
          AdvancedNewProjectPage.this.sourceLayout.select(0);
        } else {
          boolean _and_1 = false;
          boolean _equals_1 = Objects.equal(e.widget, AdvancedNewProjectPage.this.sourceLayout);
          if (!_equals_1) {
            _and_1 = false;
          } else {
            int _selectionIndex = AdvancedNewProjectPage.this.sourceLayout.getSelectionIndex();
            boolean _notEquals = (_selectionIndex != 0);
            _and_1 = _notEquals;
          }
          if (_and_1) {
            AdvancedNewProjectPage.this.createUiProject.setSelection(false);
          }
        }
      }
    };
    this.createUiProject.addSelectionListener(selectionControl);
    this.sourceLayout.addSelectionListener(selectionControl);
  }
  
  public void makeWebProjectRequireMavenOrGradle() {
    final SelectionAdapter selectionControl = new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        boolean _and = false;
        boolean _equals = Objects.equal(e.widget, AdvancedNewProjectPage.this.createWebProject);
        if (!_equals) {
          _and = false;
        } else {
          boolean _selection = AdvancedNewProjectPage.this.createWebProject.getSelection();
          _and = _selection;
        }
        if (_and) {
          AdvancedNewProjectPage.this.preferredBuildSystem.select(2);
        } else {
          boolean _and_1 = false;
          boolean _equals_1 = Objects.equal(e.widget, AdvancedNewProjectPage.this.preferredBuildSystem);
          if (!_equals_1) {
            _and_1 = false;
          } else {
            int _selectionIndex = AdvancedNewProjectPage.this.preferredBuildSystem.getSelectionIndex();
            boolean _equals_2 = (_selectionIndex == 0);
            _and_1 = _equals_2;
          }
          if (_and_1) {
            AdvancedNewProjectPage.this.createWebProject.setSelection(false);
          }
        }
      }
    };
    this.createWebProject.addSelectionListener(selectionControl);
    this.preferredBuildSystem.addSelectionListener(selectionControl);
  }
}
