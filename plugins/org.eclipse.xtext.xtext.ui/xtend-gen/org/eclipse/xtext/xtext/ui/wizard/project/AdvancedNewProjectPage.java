/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.ui.wizard.project;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.ui.wizard.project.Messages;

@SuppressWarnings("all")
public class AdvancedNewProjectPage extends WizardPage {
  private Button createUiProject;
  
  private Button createIdeaProject;
  
  private Button createWebProject;
  
  private Button createIdeProject;
  
  private Button createTestProject;
  
  private Combo buildSystem;
  
  private Combo projectLayout;
  
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
                it.setEnabled(false);
              }
            };
            Button _CheckBox_1 = AdvancedNewProjectPage.this.CheckBox(it, _function_1);
            AdvancedNewProjectPage.this.createIdeaProject = _CheckBox_1;
            final Procedure1<Button> _function_2 = new Procedure1<Button>() {
              @Override
              public void apply(final Button it) {
                it.setText("Web Integration");
                it.setEnabled(false);
              }
            };
            Button _CheckBox_2 = AdvancedNewProjectPage.this.CheckBox(it, _function_2);
            AdvancedNewProjectPage.this.createWebProject = _CheckBox_2;
            final Procedure1<Button> _function_3 = new Procedure1<Button>() {
              @Override
              public void apply(final Button it) {
                it.setText("Generic IDE Support");
                it.setEnabled(false);
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
            it.setText("Build System");
            final Procedure1<Combo> _function = new Procedure1<Combo>() {
              @Override
              public void apply(final Combo it) {
                it.setEnabled(false);
                it.setItems(new String[] { "None", "Maven", "Gradle" });
              }
            };
            Combo _DropDown = AdvancedNewProjectPage.this.DropDown(it, _function);
            AdvancedNewProjectPage.this.buildSystem = _DropDown;
          }
        };
        AdvancedNewProjectPage.this.Group(it, _function_1);
        final Procedure1<Group> _function_2 = new Procedure1<Group>() {
          @Override
          public void apply(final Group it) {
            it.setText("Project Layout");
            final Procedure1<Combo> _function = new Procedure1<Combo>() {
              @Override
              public void apply(final Combo it) {
                it.setEnabled(false);
                it.setItems(new String[] { "Eclipse", "Maven/Gradle" });
              }
            };
            Combo _DropDown = AdvancedNewProjectPage.this.DropDown(it, _function);
            AdvancedNewProjectPage.this.projectLayout = _DropDown;
          }
        };
        AdvancedNewProjectPage.this.Group(it, _function_2);
      }
    };
    Composite _doubleArrow = ObjectExtensions.<Composite>operator_doubleArrow(_composite, _function);
    this.setControl(_doubleArrow);
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
    this.buildSystem.select(0);
    this.projectLayout.select(0);
  }
  
  public boolean isCreateUiProject() {
    return this.createUiProject.getSelection();
  }
  
  public boolean isCreateTestProject() {
    return this.createTestProject.getSelection();
  }
}
