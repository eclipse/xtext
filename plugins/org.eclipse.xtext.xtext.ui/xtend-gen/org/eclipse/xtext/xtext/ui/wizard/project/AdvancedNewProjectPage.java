/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtend2.lib.StringConcatenation;
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
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

@SuppressWarnings("all")
public class AdvancedNewProjectPage extends WizardPage {
  private Button createUiProject;
  
  private Button createIdeaProject;
  
  private Button createWebProject;
  
  private Button createIdeProject;
  
  private Button createTestProject;
  
  private Combo preferredBuildSystem;
  
  private Combo sourceLayout;
  
  private StatusWidget statusWidget;
  
  public AdvancedNewProjectPage(final String pageName) {
    super(pageName);
    this.setTitle(Messages.AdvancedNewProjectPage_WindowTitle);
    this.setDescription(Messages.AdvancedNewProjectPage_Description);
  }
  
  @Override
  public void createControl(final Composite parent) {
    ScrolledComposite _scrolledComposite = new ScrolledComposite(parent, SWT.V_SCROLL);
    final Procedure1<ScrolledComposite> _function = new Procedure1<ScrolledComposite>() {
      @Override
      public void apply(final ScrolledComposite it) {
        FillLayout _fillLayout = new FillLayout();
        it.setLayout(_fillLayout);
        it.setExpandHorizontal(true);
        it.setExpandVertical(true);
        Composite _composite = new Composite(it, SWT.NONE);
        final Procedure1<Composite> _function = new Procedure1<Composite>() {
          @Override
          public void apply(final Composite it) {
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
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Generic IDE Support is requiered for front end projects like Eclipse, Idea or Web.");
                Button _decorate = AdvancedNewProjectPage.this.<Button>decorate(_CheckBox_3, 
                  IMessageProvider.INFORMATION, _builder.toString());
                AdvancedNewProjectPage.this.createIdeProject = _decorate;
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
                Combo _decorate = AdvancedNewProjectPage.this.<Combo>decorate(_DropDown, IMessageProvider.INFORMATION, "Info about layout");
                AdvancedNewProjectPage.this.sourceLayout = _decorate;
              }
            };
            AdvancedNewProjectPage.this.Group(it, _function_2);
            StatusWidget _statusWidget = new StatusWidget(it, SWT.NONE);
            final Procedure1<StatusWidget> _function_3 = new Procedure1<StatusWidget>() {
              @Override
              public void apply(final StatusWidget it) {
                GridData _gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
                it.setLayoutData(_gridData);
              }
            };
            StatusWidget _doubleArrow = ObjectExtensions.<StatusWidget>operator_doubleArrow(_statusWidget, _function_3);
            AdvancedNewProjectPage.this.statusWidget = _doubleArrow;
          }
        };
        Composite _doubleArrow = ObjectExtensions.<Composite>operator_doubleArrow(_composite, _function);
        it.setContent(_doubleArrow);
        Control _content = it.getContent();
        Point _computeSize = _content.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        it.setMinSize(_computeSize);
      }
    };
    ScrolledComposite _doubleArrow = ObjectExtensions.<ScrolledComposite>operator_doubleArrow(_scrolledComposite, _function);
    this.setControl(_doubleArrow);
    final SelectionAdapter selectionControl = new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        AdvancedNewProjectPage.this.validate(e);
      }
    };
    this.createUiProject.addSelectionListener(selectionControl);
    this.sourceLayout.addSelectionListener(selectionControl);
    this.createWebProject.addSelectionListener(selectionControl);
    this.preferredBuildSystem.addSelectionListener(selectionControl);
    this.createUiProject.addSelectionListener(selectionControl);
    this.createIdeaProject.addSelectionListener(selectionControl);
    this.createWebProject.addSelectionListener(selectionControl);
    this.createIdeProject.addSelectionListener(selectionControl);
    this.setDefaults();
  }
  
  public void validate(final SelectionEvent e) {
    this.statusWidget.clearStatus();
    this.setMessage(null);
    this.checkWidgets(e);
    int _severtity = this.statusWidget.getSevertity();
    boolean _tripleNotEquals = (_severtity != IMessageProvider.ERROR);
    this.setPageComplete(_tripleNotEquals);
  }
  
  public void checkWidgets(final SelectionEvent e) {
    Object _source = null;
    if (e!=null) {
      _source=e.getSource();
    }
    final Object source = _source;
    boolean _and = false;
    boolean _selection = this.createUiProject.getSelection();
    if (!_selection) {
      _and = false;
    } else {
      boolean _isSelected = this.isSelected(this.sourceLayout, SourceLayout.PLAIN);
      boolean _not = (!_isSelected);
      _and = _not;
    }
    if (_and) {
      if ((this.createUiProject == source)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\'");
        String _text = this.createUiProject.getText();
        _builder.append(_text, "");
        _builder.append("\' requiers ");
        _builder.append(SourceLayout.PLAIN, "");
        _builder.append(" source layout.");
        _builder.newLineIfNotEmpty();
        _builder.append("Please <a>select \'");
        _builder.append(SourceLayout.PLAIN, "");
        _builder.append("\'</a> source layout.");
        final Procedure0 _function = new Procedure0() {
          @Override
          public void apply() {
            AdvancedNewProjectPage.this.select(AdvancedNewProjectPage.this.sourceLayout, SourceLayout.PLAIN);
          }
        };
        this.<Control>reportIssue(IMessageProvider.ERROR, _builder.toString(), _function);
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(SourceLayout.PLAIN, "");
        _builder_1.append(" source layout is not supported by the \'");
        String _text_1 = this.createUiProject.getText();
        _builder_1.append(_text_1, "");
        _builder_1.append("\' project.");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("Please <a>deselect \'");
        String _text_2 = this.createUiProject.getText();
        _builder_1.append(_text_2, "");
        _builder_1.append("\'</a>.");
        final Procedure0 _function_1 = new Procedure0() {
          @Override
          public void apply() {
            AdvancedNewProjectPage.this.createUiProject.setSelection(false);
          }
        };
        this.<Control>reportIssue(IMessageProvider.ERROR, _builder_1.toString(), _function_1);
      }
    }
    boolean _and_1 = false;
    boolean _selection_1 = this.createWebProject.getSelection();
    if (!_selection_1) {
      _and_1 = false;
    } else {
      boolean _isSelected_1 = this.isSelected(this.preferredBuildSystem, BuildSystem.ECLIPSE);
      _and_1 = _isSelected_1;
    }
    if (_and_1) {
      if ((this.preferredBuildSystem == source)) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("The \'");
        String _text_3 = this.createWebProject.getText();
        _builder_2.append(_text_3, "");
        _builder_2.append("\' project can not be build using Eclipse-PDE build.");
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("Please <a>deselect \'");
        String _text_4 = this.createWebProject.getText();
        _builder_2.append(_text_4, "");
        _builder_2.append("\'</a>.");
        final Procedure0 _function_2 = new Procedure0() {
          @Override
          public void apply() {
            AdvancedNewProjectPage.this.createWebProject.setSelection(false);
          }
        };
        this.<Control>reportIssue(IMessageProvider.WARNING, _builder_2.toString(), _function_2);
      } else {
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("To build the \'");
        String _text_5 = this.createWebProject.getText();
        _builder_3.append(_text_5, "");
        _builder_3.append("\' project, you need to choose maven or gradle build system.");
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("Select <a>gradle</a> build.");
        final Procedure0 _function_3 = new Procedure0() {
          @Override
          public void apply() {
            AdvancedNewProjectPage.this.select(AdvancedNewProjectPage.this.preferredBuildSystem, BuildSystem.GRADLE);
          }
        };
        this.<Control>reportIssue(IMessageProvider.WARNING, _builder_3.toString(), _function_3);
      }
    }
    final List<Button> dependend = Collections.<Button>unmodifiableList(CollectionLiterals.<Button>newArrayList(this.createUiProject, this.createIdeaProject, this.createWebProject));
    boolean _and_2 = false;
    boolean _selection_2 = this.createIdeProject.getSelection();
    boolean _not_1 = (!_selection_2);
    if (!_not_1) {
      _and_2 = false;
    } else {
      final Function1<Button, Boolean> _function_4 = new Function1<Button, Boolean>() {
        @Override
        public Boolean apply(final Button it) {
          return Boolean.valueOf(it.getSelection());
        }
      };
      boolean _exists = IterableExtensions.<Button>exists(dependend, _function_4);
      _and_2 = _exists;
    }
    if (_and_2) {
      final Function1<Button, Boolean> _function_5 = new Function1<Button, Boolean>() {
        @Override
        public Boolean apply(final Button it) {
          return Boolean.valueOf(it.getSelection());
        }
      };
      Iterable<Button> _filter = IterableExtensions.<Button>filter(dependend, _function_5);
      final Function1<Button, CharSequence> _function_6 = new Function1<Button, CharSequence>() {
        @Override
        public CharSequence apply(final Button it) {
          return it.getText();
        }
      };
      final String affectedProjects = IterableExtensions.<Button>join(_filter, ", ", _function_6);
      if ((this.createIdeProject == source)) {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("Frontend projects like \'");
        _builder_4.append(affectedProjects, "");
        _builder_4.append("\' depends on \'");
        String _text_6 = this.createIdeProject.getText();
        _builder_4.append(_text_6, "");
        _builder_4.append("\' project.");
        _builder_4.newLineIfNotEmpty();
        _builder_4.append("Please <a>deselect</a> these.");
        final Procedure0 _function_7 = new Procedure0() {
          @Override
          public void apply() {
            final Procedure1<Button> _function = new Procedure1<Button>() {
              @Override
              public void apply(final Button it) {
                it.setSelection(false);
              }
            };
            IterableExtensions.<Button>forEach(dependend, _function);
          }
        };
        this.<Control>reportIssue(IMessageProvider.ERROR, _builder_4.toString(), _function_7);
      } else {
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("Projects like \'");
        _builder_5.append(affectedProjects, "");
        _builder_5.append("\' depends on \'");
        String _text_7 = this.createIdeProject.getText();
        _builder_5.append(_text_7, "");
        _builder_5.append("\' project.");
        _builder_5.newLineIfNotEmpty();
        _builder_5.append("Please <a>enable \'");
        String _text_8 = this.createIdeProject.getText();
        _builder_5.append(_text_8, "");
        _builder_5.append("\'</a> project.");
        final Procedure0 _function_8 = new Procedure0() {
          @Override
          public void apply() {
            AdvancedNewProjectPage.this.createIdeProject.setSelection(true);
          }
        };
        this.<Control>reportIssue(IMessageProvider.ERROR, _builder_5.toString(), _function_8);
      }
    }
    boolean _and_3 = false;
    boolean _isSelected_2 = this.isSelected(this.preferredBuildSystem, BuildSystem.MAVEN);
    if (!_isSelected_2) {
      _and_3 = false;
    } else {
      boolean _isBundleResolved = this.isBundleResolved("org.eclipse.m2e.maven.runtime");
      boolean _not_2 = (!_isBundleResolved);
      _and_3 = _not_2;
    }
    if (_and_3) {
      this.setMessage("Maven integration for eclipse is not installed. Consider to install M2e.", IMessageProvider.WARNING);
    }
    boolean _and_4 = false;
    boolean _isSelected_3 = this.isSelected(this.preferredBuildSystem, BuildSystem.GRADLE);
    if (!_isSelected_3) {
      _and_4 = false;
    } else {
      boolean _isBundleResolved_1 = this.isBundleResolved("org.eclipse.buildship.core");
      boolean _not_3 = (!_isBundleResolved_1);
      _and_4 = _not_3;
    }
    if (_and_4) {
      this.setMessage("Gradle integration for eclipse is not installed. Consider to install Buildship.", IMessageProvider.WARNING);
    }
  }
  
  protected void select(final Combo combo, final Enum<?> enu) {
    String[] _items = combo.getItems();
    Iterable<Pair<Integer, String>> _indexed = IterableExtensions.<String>indexed(((Iterable<? extends String>)Conversions.doWrapArray(_items)));
    final Function1<Pair<Integer, String>, Boolean> _function = new Function1<Pair<Integer, String>, Boolean>() {
      @Override
      public Boolean apply(final Pair<Integer, String> it) {
        String _value = it.getValue();
        String _string = enu.toString();
        return Boolean.valueOf(Objects.equal(_value, _string));
      }
    };
    Pair<Integer, String> _findFirst = IterableExtensions.<Pair<Integer, String>>findFirst(_indexed, _function);
    Integer _key = _findFirst.getKey();
    combo.select((_key).intValue());
  }
  
  protected boolean isSelected(final Combo combo, final Enum<?> enu) {
    String _string = enu.toString();
    String _text = combo.getText();
    return Objects.equal(_string, _text);
  }
  
  protected <T extends Control> int reportIssue(final int severity, final String text, final Procedure0 fix) {
    final Procedure0 _function = new Procedure0() {
      @Override
      public void apply() {
        AdvancedNewProjectPage.this.validate(null);
      }
    };
    return this.statusWidget.setStatus(severity, text, fix, _function);
  }
  
  protected boolean isBundleResolved(final String bundleId) {
    Activator _instance = Activator.getInstance();
    Bundle _bundle = _instance.getBundle();
    BundleContext _bundleContext = _bundle.getBundleContext();
    Bundle[] _bundles = _bundleContext.getBundles();
    final Function1<Bundle, Boolean> _function = new Function1<Bundle, Boolean>() {
      @Override
      public Boolean apply(final Bundle it) {
        String _symbolicName = it.getSymbolicName();
        return Boolean.valueOf(Objects.equal(bundleId, _symbolicName));
      }
    };
    final Bundle bundle = IterableExtensions.<Bundle>findFirst(((Iterable<Bundle>)Conversions.doWrapArray(_bundles)), _function);
    boolean _and = false;
    if (!(bundle != null)) {
      _and = false;
    } else {
      int _state = bundle.getState();
      boolean _tripleEquals = (_state == Bundle.RESOLVED);
      _and = _tripleEquals;
    }
    return _and;
  }
  
  private <T extends Control> T decorate(final T control, final int severity, final String text) {
    int _xifexpression = (int) 0;
    if ((severity == IMessageProvider.INFORMATION)) {
      _xifexpression = SWT.DOWN;
    } else {
      _xifexpression = SWT.UP;
    }
    final int vertical = _xifexpression;
    Composite _parent = control.getParent();
    ControlDecoration dec = new ControlDecoration(control, (vertical | SWT.LEFT), _parent);
    String _switchResult = null;
    switch (severity) {
      case IMessageProvider.WARNING:
        _switchResult = FieldDecorationRegistry.DEC_WARNING;
        break;
      case IMessageProvider.ERROR:
        _switchResult = FieldDecorationRegistry.DEC_ERROR;
        break;
      default:
        _switchResult = FieldDecorationRegistry.DEC_INFORMATION;
        break;
    }
    final String decoration = _switchResult;
    FieldDecorationRegistry _default = FieldDecorationRegistry.getDefault();
    FieldDecoration infoIndication = _default.getFieldDecoration(decoration);
    Image _image = infoIndication.getImage();
    dec.setImage(_image);
    dec.setDescriptionText(text);
    return control;
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
    this.createIdeProject.setSelection(true);
    this.createTestProject.setSelection(true);
    this.createIdeaProject.setSelection(false);
    this.createWebProject.setSelection(false);
    BuildSystem[] _values = BuildSystem.values();
    Enum<?> _head = IterableExtensions.<Enum<?>>head(((Iterable<Enum<?>>)Conversions.doWrapArray(_values)));
    this.select(this.preferredBuildSystem, _head);
    SourceLayout[] _values_1 = SourceLayout.values();
    Enum<?> _head_1 = IterableExtensions.<Enum<?>>head(((Iterable<Enum<?>>)Conversions.doWrapArray(_values_1)));
    this.select(this.sourceLayout, _head_1);
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
}
