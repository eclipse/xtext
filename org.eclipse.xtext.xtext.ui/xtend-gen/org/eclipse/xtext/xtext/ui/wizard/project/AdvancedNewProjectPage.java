/**
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.ui.wizard.project;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.JUnitVersion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.ui.internal.Activator;
import org.eclipse.xtext.xtext.ui.wizard.project.Messages;
import org.eclipse.xtext.xtext.ui.wizard.project.StatusWidget;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.LanguageServer;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.osgi.framework.Bundle;

@SuppressWarnings("all")
public class AdvancedNewProjectPage extends WizardPage {
  private Button createUiProject;
  
  private Button createSDKProject;
  
  private Button createP2Project;
  
  private Button createWebProject;
  
  private Button createIdeProject;
  
  private Button createTestProject;
  
  private Button junitVersion4;
  
  private Button junitVersion5;
  
  private Combo preferredBuildSystem;
  
  private Combo createLanguageServer;
  
  private Combo sourceLayout;
  
  private Group createUiProjectSubGroup;
  
  private StatusWidget statusWidget;
  
  private boolean autoSelectIdeProject;
  
  private boolean autoSelectSDKProject;
  
  public AdvancedNewProjectPage(final String pageName) {
    super(pageName);
    this.setTitle(Messages.AdvancedNewProjectPage_WindowTitle);
    this.setDescription(Messages.AdvancedNewProjectPage_Description);
  }
  
  @Override
  public void createControl(final Composite parent) {
    Composite _composite = new Composite(parent, SWT.NONE);
    final Procedure1<Composite> _function = (Composite it) -> {
      GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
      it.setLayoutData(_gridData);
      GridLayout _gridLayout = new GridLayout(1, false);
      it.setLayout(_gridLayout);
      final Procedure1<Group> _function_1 = (Group it_1) -> {
        it_1.setText(Messages.AdvancedNewProjectPage_LabelFacets);
        final Procedure1<Button> _function_2 = (Button it_2) -> {
          it_2.setText(Messages.AdvancedNewProjectPage_projEclipse);
        };
        this.createUiProject = this.CheckBox(it_1, _function_2);
        final Procedure1<Group> _function_3 = (Group it_2) -> {
          final Procedure1<Button> _function_4 = (Button it_3) -> {
            it_3.setText(Messages.AdvancedNewProjectPage_projEclipseSDKFeature);
          };
          this.createSDKProject = this.CheckBox(it_2, _function_4);
          final Procedure1<Button> _function_5 = (Button it_3) -> {
            it_3.setText(Messages.AdvancedNewProjectPage_projEclipseP2);
          };
          this.createP2Project = this.CheckBox(it_2, _function_5);
        };
        this.createUiProjectSubGroup = this.Group(it_1, _function_3);
        final Procedure1<Button> _function_4 = (Button it_2) -> {
          it_2.setText(Messages.AdvancedNewProjectPage_projWeb);
          it_2.setEnabled(true);
        };
        this.createWebProject = this.CheckBox(it_1, _function_4);
        final Procedure1<Button> _function_5 = (Button it_2) -> {
          it_2.setText(Messages.AdvancedNewProjectPage_projIde);
          it_2.setEnabled(false);
          this.InfoDecoration(it_2, Messages.AdvancedNewProjectPage_projIde_description);
          GridData _gridData_1 = new GridData(SWT.LEFT, SWT.CENTER, true, false);
          it_2.setLayoutData(_gridData_1);
        };
        this.createIdeProject = this.CheckBox(it_1, _function_5);
        Composite _composite_1 = new Composite(it_1, SWT.NONE);
        final Procedure1<Composite> _function_6 = (Composite it_2) -> {
          final GridLayout _layout = new GridLayout(3, false);
          _layout.marginWidth = 0;
          _layout.marginHeight = 0;
          it_2.setLayout(_layout);
          final Procedure1<Button> _function_7 = (Button it_3) -> {
            it_3.setText(Messages.WizardNewXtextProjectCreationPage_TestingSupport);
            GridData _gridData_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false);
            it_3.setLayoutData(_gridData_1);
          };
          this.createTestProject = this.CheckBox(it_2, _function_7);
          final Procedure1<Button> _function_8 = (Button it_3) -> {
            GridData _gridData_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false);
            it_3.setLayoutData(_gridData_1);
            it_3.setText("4");
            it_3.setSelection(true);
          };
          this.junitVersion4 = this.Radio(it_2, _function_8);
          final Procedure1<Button> _function_9 = (Button it_3) -> {
            GridData _gridData_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false);
            it_3.setLayoutData(_gridData_1);
            it_3.setText("5");
          };
          this.junitVersion5 = this.Radio(it_2, _function_9);
        };
        ObjectExtensions.<Composite>operator_doubleArrow(_composite_1, _function_6);
      };
      this.Group(it, _function_1);
      final Procedure1<Group> _function_2 = (Group it_1) -> {
        it_1.setText(Messages.AdvancedNewProjectPage_prefBuildSys);
        final Procedure1<Combo> _function_3 = (Combo it_2) -> {
          it_2.setEnabled(true);
          final Function1<BuildSystem, String> _function_4 = (BuildSystem it_3) -> {
            return it_3.toString();
          };
          it_2.setItems(((String[])Conversions.unwrapArray(ListExtensions.<BuildSystem, String>map(((List<BuildSystem>)Conversions.doWrapArray(BuildSystem.values())), _function_4), String.class)));
        };
        this.preferredBuildSystem = this.DropDown(it_1, _function_3);
      };
      this.Group(it, _function_2);
      final Procedure1<Group> _function_3 = (Group it_1) -> {
        it_1.setText(Messages.AdvancedNewProjectPage_languageServer);
        final Procedure1<Combo> _function_4 = (Combo it_2) -> {
          it_2.setEnabled(false);
          final Function1<LanguageServer, String> _function_5 = (LanguageServer it_3) -> {
            return it_3.toString();
          };
          it_2.setItems(((String[])Conversions.unwrapArray(ListExtensions.<LanguageServer, String>map(((List<LanguageServer>)Conversions.doWrapArray(LanguageServer.values())), _function_5), String.class)));
          this.InfoDecoration(it_2, Messages.AdvancedNewProjectPage_languageServer_description);
        };
        this.createLanguageServer = this.DropDown(it_1, _function_4);
      };
      this.Group(it, _function_3);
      final Procedure1<Group> _function_4 = (Group it_1) -> {
        it_1.setText(Messages.AdvancedNewProjectPage_srcLayout);
        final Procedure1<Combo> _function_5 = (Combo it_2) -> {
          it_2.setEnabled(true);
          final Function1<SourceLayout, String> _function_6 = (SourceLayout it_3) -> {
            return it_3.toString();
          };
          it_2.setItems(((String[])Conversions.unwrapArray(ListExtensions.<SourceLayout, String>map(((List<SourceLayout>)Conversions.doWrapArray(SourceLayout.values())), _function_6), String.class)));
        };
        this.sourceLayout = this.DropDown(it_1, _function_5);
      };
      this.Group(it, _function_4);
      StatusWidget _statusWidget = new StatusWidget(it, SWT.NONE);
      final Procedure1<StatusWidget> _function_5 = (StatusWidget it_1) -> {
        GridData _gridData_1 = new GridData(SWT.FILL, SWT.TOP, true, false);
        it_1.setLayoutData(_gridData_1);
      };
      StatusWidget _doubleArrow = ObjectExtensions.<StatusWidget>operator_doubleArrow(_statusWidget, _function_5);
      this.statusWidget = _doubleArrow;
    };
    Composite _doubleArrow = ObjectExtensions.<Composite>operator_doubleArrow(_composite, _function);
    this.setControl(_doubleArrow);
    final SelectionAdapter selectionControl = new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        AdvancedNewProjectPage.this.validate(e);
      }
    };
    final List<Button> uiButtons = Collections.<Button>unmodifiableList(CollectionLiterals.<Button>newArrayList(this.createUiProject, this.createWebProject));
    final SelectionAdapter selectionControlUi = new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        Object _source = e.getSource();
        boolean _selection = ((Button) _source).getSelection();
        if (_selection) {
          boolean _selection_1 = AdvancedNewProjectPage.this.createIdeProject.getSelection();
          boolean _not = (!_selection_1);
          if (_not) {
            AdvancedNewProjectPage.this.autoSelectIdeProject = true;
          }
          AdvancedNewProjectPage.this.createIdeProject.setSelection(true);
          AdvancedNewProjectPage.this.createIdeProject.setEnabled(false);
        } else {
          final Function1<Button, Boolean> _function = (Button it) -> {
            boolean _selection_2 = it.getSelection();
            return Boolean.valueOf((!_selection_2));
          };
          boolean _forall = IterableExtensions.<Button>forall(uiButtons, _function);
          if (_forall) {
            AdvancedNewProjectPage.this.createIdeProject.setEnabled(true);
          }
          Object _source_1 = e.getSource();
          boolean _equals = Objects.equal(_source_1, AdvancedNewProjectPage.this.createUiProject);
          if (_equals) {
            AdvancedNewProjectPage.this.createSDKProject.setSelection(false);
            AdvancedNewProjectPage.this.createP2Project.setSelection(false);
          }
        }
        AdvancedNewProjectPage.this.validate(e);
      }
    };
    final SelectionAdapter selectionControlUpdateSite = new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        Object _source = e.getSource();
        boolean _selection = ((Button) _source).getSelection();
        if (_selection) {
          boolean _selection_1 = AdvancedNewProjectPage.this.createSDKProject.getSelection();
          boolean _not = (!_selection_1);
          if (_not) {
            AdvancedNewProjectPage.this.autoSelectSDKProject = true;
          }
          AdvancedNewProjectPage.this.createSDKProject.setSelection(true);
          AdvancedNewProjectPage.this.createSDKProject.setEnabled(false);
        } else {
          AdvancedNewProjectPage.this.createSDKProject.setEnabled(true);
        }
        AdvancedNewProjectPage.this.validate(e);
      }
    };
    this.createUiProject.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        final boolean uiProjectSelected = AdvancedNewProjectPage.this.createUiProject.getSelection();
        AdvancedNewProjectPage.this.createUiProjectSubGroup.setEnabled(uiProjectSelected);
        AdvancedNewProjectPage.this.createSDKProject.setEnabled(uiProjectSelected);
        AdvancedNewProjectPage.this.createP2Project.setEnabled(uiProjectSelected);
        AdvancedNewProjectPage.this.validate(e);
      }
    });
    this.preferredBuildSystem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        BuildSystem _preferredBuildSystem = AdvancedNewProjectPage.this.getPreferredBuildSystem();
        final boolean lsEnabled = (!Objects.equal(_preferredBuildSystem, BuildSystem.NONE));
        AdvancedNewProjectPage.this.createLanguageServer.setEnabled(lsEnabled);
        AdvancedNewProjectPage.this.validate(e);
      }
    });
    this.createLanguageServer.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        boolean _isSelected = AdvancedNewProjectPage.this.isSelected(AdvancedNewProjectPage.this.createLanguageServer, LanguageServer.NONE);
        if (_isSelected) {
          final Function1<Button, Boolean> _function = (Button it) -> {
            boolean _selection = it.getSelection();
            return Boolean.valueOf((!_selection));
          };
          boolean _forall = IterableExtensions.<Button>forall(uiButtons, _function);
          if (_forall) {
            AdvancedNewProjectPage.this.createIdeProject.setEnabled(true);
          }
        } else {
          boolean _selection = AdvancedNewProjectPage.this.createIdeProject.getSelection();
          boolean _not = (!_selection);
          if (_not) {
            AdvancedNewProjectPage.this.createIdeProject.setSelection(true);
            AdvancedNewProjectPage.this.autoSelectIdeProject = true;
          }
        }
        AdvancedNewProjectPage.this.validate(e);
      }
    });
    this.createTestProject.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        boolean _selection = AdvancedNewProjectPage.this.createTestProject.getSelection();
        final boolean enabled = (_selection == true);
        AdvancedNewProjectPage.this.junitVersion4.setEnabled(enabled);
        AdvancedNewProjectPage.this.junitVersion5.setEnabled(enabled);
        AdvancedNewProjectPage.this.validate(e);
      }
    });
    this.sourceLayout.addSelectionListener(selectionControl);
    this.createUiProject.addSelectionListener(selectionControlUi);
    this.createWebProject.addSelectionListener(selectionControlUi);
    this.createIdeProject.addSelectionListener(selectionControl);
    this.createSDKProject.addSelectionListener(selectionControl);
    this.createP2Project.addSelectionListener(selectionControlUpdateSite);
    this.createLanguageServer.addSelectionListener(selectionControl);
    this.setDefaults();
    PlatformUI.getWorkbench().getHelpSystem().setHelp(this.getShell(), "org.eclipse.xtext.xtext.ui.newProject_Advanced");
  }
  
  public void validate(final SelectionEvent e) {
    this.statusWidget.clearStatus();
    this.checkWidgets(e);
    int _severtity = this.statusWidget.getSevertity();
    boolean _tripleNotEquals = (_severtity != IMessageProvider.ERROR);
    this.setPageComplete(_tripleNotEquals);
  }
  
  public Procedure0 checkWidgets(final SelectionEvent e) {
    Procedure0 _xblockexpression = null;
    {
      final List<Button> uiButtons = Collections.<Button>unmodifiableList(CollectionLiterals.<Button>newArrayList(this.createUiProject, this.createWebProject));
      if ((this.isSelected(this.preferredBuildSystem, BuildSystem.MAVEN) && (!this.isBundleResolved("org.eclipse.m2e.maven.runtime")))) {
        this.<Control>reportIssue(IMessageProvider.WARNING, Messages.AdvancedNewProjectPage_noM2e);
      }
      if ((this.isSelected(this.preferredBuildSystem, BuildSystem.GRADLE) && (!this.isBundleResolved("org.eclipse.buildship.core")))) {
        this.<Control>reportIssue(IMessageProvider.WARNING, Messages.AdvancedNewProjectPage_noBuildship);
      }
      if ((this.isSelected(this.preferredBuildSystem, BuildSystem.GRADLE) && this.createUiProject.getSelection())) {
        this.<Control>reportIssue(IMessageProvider.WARNING, 
          Messages.AdvancedNewProjectPage_eclipseAndGradleWarn);
      }
      if (((this.createUiProject.getSelection() && this.createP2Project.getSelection()) && (!this.createSDKProject.getSelection()))) {
        this.<Control>addIssue(IMessageProvider.INFORMATION, 
          Messages.AdvancedNewProjectPage_p2AndSdkInfo);
      }
      Object _source = null;
      if (e!=null) {
        _source=e.getSource();
      }
      final Object source = _source;
      if ((this.createUiProject.getSelection() && (!this.isSelected(this.sourceLayout, SourceLayout.PLAIN)))) {
        if ((this.createUiProject == source)) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("\'");
          String _text = this.createUiProject.getText();
          _builder.append(_text);
          _builder.append("\' requires ");
          _builder.append(SourceLayout.PLAIN);
          _builder.append(" source layout.");
          _builder.newLineIfNotEmpty();
          _builder.append("Please <a>select \'");
          _builder.append(SourceLayout.PLAIN);
          _builder.append("\'</a> source layout.");
          final Procedure0 _function = () -> {
            this.select(this.sourceLayout, SourceLayout.PLAIN);
          };
          this.<Control>reportIssue(IMessageProvider.ERROR, _builder.toString(), _function);
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(SourceLayout.MAVEN);
          _builder_1.append(" source layout is not supported by the \'");
          String _text_1 = this.createUiProject.getText();
          _builder_1.append(_text_1);
          _builder_1.append("\' project.");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("Please <a>deselect \'");
          String _text_2 = this.createUiProject.getText();
          _builder_1.append(_text_2);
          _builder_1.append("\'</a>.");
          final Procedure0 _function_1 = () -> {
            this.createUiProject.setSelection(false);
          };
          this.<Control>reportIssue(IMessageProvider.ERROR, _builder_1.toString(), _function_1);
        }
      }
      if ((this.isSelected(this.preferredBuildSystem, BuildSystem.NONE) && this.isSelected(this.sourceLayout, SourceLayout.MAVEN))) {
        if ((this.preferredBuildSystem == source)) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("Maven/Gradle source layout is not supported without a build system.");
          _builder_2.newLine();
          _builder_2.append("Please <a>select \'");
          _builder_2.append(SourceLayout.PLAIN);
          _builder_2.append("\'</a> source layout.");
          final Procedure0 _function_2 = () -> {
            this.select(this.sourceLayout, SourceLayout.PLAIN);
          };
          this.<Control>reportIssue(IMessageProvider.ERROR, _builder_2.toString(), _function_2);
        } else {
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("Maven/Gradle source layout is only supported when using Maven or Gradle build system.");
          _builder_3.newLine();
          _builder_3.append("You need to choose Maven or Gradle build system.");
          _builder_3.newLine();
          _builder_3.append("Select <a>Gradle</a> build.");
          final Procedure0 _function_3 = () -> {
            this.select(this.preferredBuildSystem, BuildSystem.GRADLE);
          };
          this.<Control>reportIssue(IMessageProvider.ERROR, _builder_3.toString(), _function_3);
        }
      }
      if ((this.createWebProject.getSelection() && this.isSelected(this.preferredBuildSystem, BuildSystem.NONE))) {
        if ((this.preferredBuildSystem == source)) {
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("The \'");
          String _text_3 = this.createWebProject.getText();
          _builder_4.append(_text_3);
          _builder_4.append("\' project can not be build without a build system.");
          _builder_4.newLineIfNotEmpty();
          _builder_4.append("Please <a>deselect \'");
          String _text_4 = this.createWebProject.getText();
          _builder_4.append(_text_4);
          _builder_4.append("\'</a>.");
          final Procedure0 _function_4 = () -> {
            this.createWebProject.setSelection(false);
          };
          this.<Control>reportIssue(IMessageProvider.ERROR, _builder_4.toString(), _function_4);
        } else {
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("To build the \'");
          String _text_5 = this.createWebProject.getText();
          _builder_5.append(_text_5);
          _builder_5.append("\' project, you need to choose Maven or Gradle build system.");
          _builder_5.newLineIfNotEmpty();
          _builder_5.append("Select <a>Gradle</a> build.");
          final Procedure0 _function_5 = () -> {
            this.select(this.preferredBuildSystem, BuildSystem.GRADLE);
          };
          this.<Control>reportIssue(IMessageProvider.ERROR, _builder_5.toString(), _function_5);
        }
      }
      final Function1<Button, Boolean> _function_6 = (Button it) -> {
        return Boolean.valueOf(it.getSelection());
      };
      boolean _exists = IterableExtensions.<Button>exists(uiButtons, _function_6);
      if (_exists) {
        this.createIdeProject.setEnabled(false);
      }
      if (this.autoSelectIdeProject) {
        this.autoSelectIdeProject = false;
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("\'");
        String _text_6 = this.createIdeProject.getText();
        _builder_6.append(_text_6);
        _builder_6.append("\' project was automatically selected as option \'");
        String _text_7 = ((Button) source).getText();
        _builder_6.append(_text_7);
        _builder_6.append("\' requires it.");
        this.<Control>reportIssue(IMessageProvider.INFORMATION, _builder_6.toString());
      }
      Procedure0 _xifexpression = null;
      if (this.autoSelectSDKProject) {
        Procedure0 _xblockexpression_1 = null;
        {
          this.autoSelectSDKProject = false;
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("\'");
          String _text_8 = this.createSDKProject.getText();
          _builder_7.append(_text_8);
          _builder_7.append("\' was automatically selected as option \'");
          String _text_9 = ((Button) source).getText();
          _builder_7.append(_text_9);
          _builder_7.append("\' requires it.");
          _xblockexpression_1 = this.<Control>reportIssue(IMessageProvider.INFORMATION, _builder_7.toString());
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected void select(final Combo combo, final Enum<?> enu) {
    final Function1<Pair<Integer, String>, Boolean> _function = (Pair<Integer, String> it) -> {
      String _value = it.getValue();
      String _string = enu.toString();
      return Boolean.valueOf(Objects.equal(_value, _string));
    };
    combo.select((IterableExtensions.<Pair<Integer, String>>findFirst(IterableExtensions.<String>indexed(((Iterable<? extends String>)Conversions.doWrapArray(combo.getItems()))), _function).getKey()).intValue());
  }
  
  protected boolean isSelected(final Combo combo, final Enum<?> enu) {
    String _string = enu.toString();
    String _text = combo.getText();
    return Objects.equal(_string, _text);
  }
  
  protected <T extends Control> Procedure0 reportIssue(final int severity, final String text) {
    final Procedure0 _function = () -> {
    };
    return this.<Control>reportIssue(severity, text, _function);
  }
  
  protected <T extends Control> Procedure0 reportIssue(final int severity, final String text, final Procedure0 fix) {
    final Procedure0 _function = () -> {
      this.validate(null);
    };
    return this.statusWidget.setStatus(severity, text, fix, _function);
  }
  
  protected <T extends Control> Procedure0 addIssue(final int severity, final String text) {
    return this.statusWidget.addStatus(severity, text);
  }
  
  protected boolean isBundleResolved(final String bundleId) {
    final Function1<Bundle, Boolean> _function = (Bundle it) -> {
      String _symbolicName = it.getSymbolicName();
      return Boolean.valueOf(Objects.equal(bundleId, _symbolicName));
    };
    final Bundle bundle = IterableExtensions.<Bundle>findFirst(((Iterable<Bundle>)Conversions.doWrapArray(Activator.getInstance().getBundle().getBundleContext().getBundles())), _function);
    return ((bundle != null) && ((bundle.getState() & ((Bundle.RESOLVED | Bundle.STARTING) | Bundle.ACTIVE)) != 0));
  }
  
  protected Group Group(final Composite parent, final Procedure1<? super Group> config) {
    Group _group = new Group(parent, SWT.NONE);
    final Procedure1<Group> _function = (Group it) -> {
      it.setFont(parent.getFont());
      GridData _gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
      it.setLayoutData(_gridData);
      GridLayout _gridLayout = new GridLayout(1, false);
      it.setLayout(_gridLayout);
      config.apply(it);
    };
    return ObjectExtensions.<Group>operator_doubleArrow(_group, _function);
  }
  
  protected Button CheckBox(final Composite composite, final Procedure1<? super Button> config) {
    Button _button = new Button(composite, SWT.CHECK);
    final Procedure1<Button> _function = (Button it) -> {
      it.setFont(it.getParent().getFont());
      GridData _gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
      it.setLayoutData(_gridData);
      config.apply(it);
    };
    return ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  protected Button Radio(final Composite composite, final Procedure1<? super Button> config) {
    Button _button = new Button(composite, SWT.RADIO);
    final Procedure1<Button> _function = (Button it) -> {
      it.setFont(it.getParent().getFont());
      GridData _gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
      it.setLayoutData(_gridData);
      config.apply(it);
    };
    return ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  protected Combo DropDown(final Composite parent, final Procedure1<? super Combo> config) {
    Combo _combo = new Combo(parent, SWT.READ_ONLY);
    final Procedure1<Combo> _function = (Combo it) -> {
      it.setFont(parent.getFont());
      GridData _gridData = new GridData(GridData.FILL_HORIZONTAL);
      it.setLayoutData(_gridData);
      config.apply(it);
    };
    return ObjectExtensions.<Combo>operator_doubleArrow(_combo, _function);
  }
  
  protected ControlDecoration InfoDecoration(final Control control, final String text) {
    ControlDecoration _xblockexpression = null;
    {
      final FieldDecoration infoField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
      ControlDecoration _controlDecoration = new ControlDecoration(control, (SWT.TOP + SWT.RIGHT));
      final Procedure1<ControlDecoration> _function = (ControlDecoration it) -> {
        it.setImage(infoField.getImage());
        it.setDescriptionText(text);
        it.setShowHover(true);
      };
      _xblockexpression = ObjectExtensions.<ControlDecoration>operator_doubleArrow(_controlDecoration, _function);
    }
    return _xblockexpression;
  }
  
  protected void setDefaults() {
    this.createUiProject.setSelection(true);
    this.createIdeProject.setSelection(true);
    this.createTestProject.setSelection(true);
    this.createWebProject.setSelection(false);
    this.createSDKProject.setSelection(false);
    this.createP2Project.setSelection(false);
    this.select(this.preferredBuildSystem, IterableExtensions.<Enum<?>>head(((Iterable<Enum<?>>)Conversions.doWrapArray(BuildSystem.values()))));
    this.select(this.createLanguageServer, IterableExtensions.<Enum<?>>head(((Iterable<Enum<?>>)Conversions.doWrapArray(LanguageServer.values()))));
    this.select(this.sourceLayout, IterableExtensions.<Enum<?>>head(((Iterable<Enum<?>>)Conversions.doWrapArray(SourceLayout.values()))));
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
  
  public boolean isCreateWebProject() {
    return this.createWebProject.getSelection();
  }
  
  public boolean isCreateSdkProject() {
    return (this.createUiProject.getSelection() && this.createSDKProject.getSelection());
  }
  
  public boolean isCreateP2Project() {
    return (this.createUiProject.getSelection() && this.createP2Project.getSelection());
  }
  
  public BuildSystem getPreferredBuildSystem() {
    return BuildSystem.values()[this.preferredBuildSystem.getSelectionIndex()];
  }
  
  public SourceLayout getSourceLayout() {
    return SourceLayout.values()[this.sourceLayout.getSelectionIndex()];
  }
  
  public LanguageServer getLanguageServer() {
    LanguageServer _xblockexpression = null;
    {
      BuildSystem _preferredBuildSystem = this.getPreferredBuildSystem();
      boolean _equals = Objects.equal(_preferredBuildSystem, BuildSystem.NONE);
      if (_equals) {
        return LanguageServer.NONE;
      }
      _xblockexpression = LanguageServer.values()[this.createLanguageServer.getSelectionIndex()];
    }
    return _xblockexpression;
  }
  
  public JUnitVersion getJUnitVersion() {
    boolean _selection = this.junitVersion4.getSelection();
    if (_selection) {
      return JUnitVersion.JUNIT_4;
    } else {
      boolean _selection_1 = this.junitVersion5.getSelection();
      if (_selection_1) {
        return JUnitVersion.JUNIT_5;
      } else {
        throw new IllegalStateException();
      }
    }
  }
}
