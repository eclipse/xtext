/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotPerspective;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.ContextMenuHelper;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotList;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTabItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class SwtBotProjectHelper {
  private final static String defaultProject = "test";
  
  public static SWTBotShell newXtendProject(final SWTWorkbenchBot it) {
    return SwtBotProjectHelper.newXtendProject(it, SwtBotProjectHelper.defaultProject);
  }
  
  public static SWTBotShell newXtendProject(final SWTWorkbenchBot it, final String projectName) {
    SWTBotShell _xblockexpression = null;
    {
      final SWTBotShell shell = it.activeShell();
      List<SWTBotView> _views = it.views();
      final Function1<SWTBotView, Boolean> _function = new Function1<SWTBotView, Boolean>() {
        @Override
        public Boolean apply(final SWTBotView it) {
          String _title = it.getTitle();
          return Boolean.valueOf(Objects.equal(_title, "Welcome"));
        }
      };
      SWTBotView _findFirst = IterableExtensions.<SWTBotView>findFirst(_views, _function);
      if (_findFirst!=null) {
        _findFirst.close();
      }
      SWTBotPerspective _perspectiveByLabel = it.perspectiveByLabel("Java");
      _perspectiveByLabel.activate();
      SWTBotMenu _menu = it.menu("File");
      SWTBotMenu _menu_1 = _menu.menu("New");
      SWTBotMenu _menu_2 = _menu_1.menu("Project...");
      _menu_2.click();
      SWTBotShell _shell = it.shell("New Project");
      _shell.activate();
      SWTBotTree _tree = it.tree();
      SWTBotTreeItem _expandNode = SwtBotProjectHelper.expandNode(_tree, "Java");
      _expandNode.select("Java Project");
      SWTBotButton _button = it.button("Next >");
      _button.click();
      SWTBotText _textWithLabel = it.textWithLabel("Project name:");
      _textWithLabel.setText("test");
      SWTBotButton _button_1 = it.button("Next >");
      _button_1.click();
      SWTBotTabItem _tabItem = it.tabItem("Libraries");
      _tabItem.activate();
      SWTBotButton _button_2 = it.button("Add Library...");
      _button_2.click();
      SWTBotShell _shell_1 = it.shell("Add Library");
      _shell_1.activate();
      SWTBotList _list = it.list();
      _list.select("Xtend Library");
      SWTBotButton _button_3 = it.button("Next >");
      _button_3.click();
      SWTBotButton _button_4 = it.button("Finish");
      _button_4.click();
      SWTBotButton _button_5 = it.button("Finish");
      _button_5.click();
      _xblockexpression = shell.activate();
    }
    return _xblockexpression;
  }
  
  public static SWTBotEclipseEditor newJavaEditor(final SWTWorkbenchBot it, final String typeName) {
    return SwtBotProjectHelper.newJavaEditor(it, typeName, "", (SwtBotProjectHelper.defaultProject + "/src"));
  }
  
  public static SWTBotEclipseEditor newJavaEditor(final SWTWorkbenchBot it, final String typeName, final CharSequence content) {
    SWTBotEclipseEditor _newJavaEditor = SwtBotProjectHelper.newJavaEditor(it, typeName, "", (SwtBotProjectHelper.defaultProject + "/src"));
    final Procedure1<SWTBotEclipseEditor> _function = new Procedure1<SWTBotEclipseEditor>() {
      @Override
      public void apply(final SWTBotEclipseEditor it) {
        SwtBotProjectHelper.setContent(it, content);
      }
    };
    return ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newJavaEditor, _function);
  }
  
  public static SWTBotEclipseEditor newJavaEditor(final SWTWorkbenchBot it, final String typeName, final String packageName, final String sourceFolderPath) {
    SWTBotEclipseEditor _xblockexpression = null;
    {
      SWTBotMenu _menu = it.menu("File");
      SWTBotMenu _menu_1 = _menu.menu("New");
      SWTBotMenu _menu_2 = _menu_1.menu("Class");
      _menu_2.click();
      SWTBotShell _shell = it.shell("New Java Class");
      _shell.activate();
      SWTBotText _textWithLabel = it.textWithLabel("Source folder:");
      _textWithLabel.setText(sourceFolderPath);
      SWTBotText _textWithLabel_1 = it.textWithLabel("Package:");
      _textWithLabel_1.setText(packageName);
      SWTBotText _textWithLabel_2 = it.textWithLabel("Name:");
      _textWithLabel_2.setText(typeName);
      SWTBotButton _button = it.button("Finish");
      _button.click();
      SWTBotEditor _editorByTitle = it.editorByTitle((typeName + ".java"));
      _xblockexpression = _editorByTitle.toTextEditor();
    }
    return _xblockexpression;
  }
  
  public static SWTBotEclipseEditor newXtendEditor(final SWTWorkbenchBot it, final String typeName, final CharSequence content) {
    SWTBotEclipseEditor _newXtendEditor = SwtBotProjectHelper.newXtendEditor(it, typeName, "", (SwtBotProjectHelper.defaultProject + "/src"));
    final Procedure1<SWTBotEclipseEditor> _function = new Procedure1<SWTBotEclipseEditor>() {
      @Override
      public void apply(final SWTBotEclipseEditor it) {
        SwtBotProjectHelper.setContent(it, content);
      }
    };
    return ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newXtendEditor, _function);
  }
  
  public static SWTBotEclipseEditor newXtendEditor(final SWTWorkbenchBot it, final String typeName, final String packageName, final String sourceFolderPath) {
    SWTBotEclipseEditor _xblockexpression = null;
    {
      try {
        SWTBotMenu _menu = it.menu("File");
        SWTBotMenu _menu_1 = _menu.menu("New");
        SWTBotMenu _menu_2 = _menu_1.menu("Xtend Class");
        _menu_2.click();
      } catch (final Throwable _t) {
        if (_t instanceof WidgetNotFoundException) {
          final WidgetNotFoundException e = (WidgetNotFoundException)_t;
          SWTBotShell[] _shells = it.shells();
          final Procedure1<SWTBotShell> _function = new Procedure1<SWTBotShell>() {
            @Override
            public void apply(final SWTBotShell it) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Shell: \'");
              String _text = it.getText();
              _builder.append(_text, "");
              _builder.append("\', active: ");
              boolean _isActive = it.isActive();
              _builder.append(_isActive, "");
              InputOutput.<String>println(_builder.toString());
            }
          };
          IterableExtensions.<SWTBotShell>forEach(((Iterable<SWTBotShell>)Conversions.doWrapArray(_shells)), _function);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(SWTBotPreferences.SCREENSHOTS_DIR, "");
          _builder.append("/MenuFileNotFound");
          long _currentTimeMillis = System.currentTimeMillis();
          _builder.append(_currentTimeMillis, "");
          _builder.append(".");
          _builder.append(SWTBotPreferences.SCREENSHOT_FORMAT, "");
          SWTBotShell[] _shells_1 = it.shells();
          final Function1<SWTBotShell, Boolean> _function_1 = new Function1<SWTBotShell, Boolean>() {
            @Override
            public Boolean apply(final SWTBotShell it) {
              return Boolean.valueOf(it.isActive());
            }
          };
          Iterable<SWTBotShell> _filter = IterableExtensions.<SWTBotShell>filter(((Iterable<SWTBotShell>)Conversions.doWrapArray(_shells_1)), _function_1);
          SWTBotShell _head = IterableExtensions.<SWTBotShell>head(_filter);
          SWTUtils.captureScreenshot(_builder.toString(), 
            _head.widget);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      SWTBotShell _shell = it.shell("Xtend Class");
      _shell.activate();
      SWTBotText _textWithLabel = it.textWithLabel("Source folder:");
      _textWithLabel.setText(sourceFolderPath);
      SWTBotText _textWithLabel_1 = it.textWithLabel("Package:");
      _textWithLabel_1.setText(packageName);
      SWTBotText _textWithLabel_2 = it.textWithLabel("Name:");
      _textWithLabel_2.setText(typeName);
      SWTBotButton _button = it.button("Finish");
      _button.click();
      SWTBotEditor _editorByTitle = it.editorByTitle((typeName + ".xtend"));
      _xblockexpression = _editorByTitle.toTextEditor();
    }
    return _xblockexpression;
  }
  
  public static void closeAllEditors(final SWTWorkbenchBot it) {
    List<? extends SWTBotEditor> _editors = it.editors();
    final Procedure1<SWTBotEditor> _function = new Procedure1<SWTBotEditor>() {
      @Override
      public void apply(final SWTBotEditor it) {
        it.close();
      }
    };
    IterableExtensions.forEach(_editors, _function);
  }
  
  public static void setContent(final SWTBotEclipseEditor it, final CharSequence content) {
    final String contentString = content.toString();
    String _replace = contentString.replace("?", "");
    it.setText(_replace);
    final int offset = contentString.indexOf("?");
    if ((offset != (-1))) {
      final Pair<Integer, Integer> lineAndColumn = SwtBotProjectHelper.getLineAndColumn(contentString, offset);
      Integer _key = lineAndColumn.getKey();
      Integer _value = lineAndColumn.getValue();
      int _lastIndexOf = contentString.lastIndexOf("?");
      int _minus = (_lastIndexOf - offset);
      int _minus_1 = (_minus - 1);
      it.selectRange((_key).intValue(), (_value).intValue(), _minus_1);
    }
  }
  
  public static SWTBotMenu clickableContextMenu(final SWTBotEclipseEditor editor, final String... text) {
    SWTBotStyledText _styledText = editor.getStyledText();
    MenuItem _contextMenu = ContextMenuHelper.contextMenu(_styledText, text);
    return new SWTBotMenu(_contextMenu);
  }
  
  protected static Pair<Integer, Integer> getLineAndColumn(final String content, final int offset) {
    Pair<Integer, Integer> _xblockexpression = null;
    {
      int line = 0;
      int column = 0;
      String ignoreNext = null;
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, offset, true);
      for (final Integer i : _doubleDotLessThan) {
        String _substring = content.substring((i).intValue(), ((i).intValue() + 1));
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_substring, ignoreNext)) {
            _matched=true;
            ignoreNext = null;
          }
        }
        if (!_matched) {
          if (Objects.equal(_substring, "\n")) {
            _matched=true;
            column = 0;
            line = (line + 1);
            ignoreNext = "\r";
          }
        }
        if (!_matched) {
          if (Objects.equal(_substring, "\r")) {
            _matched=true;
            column = 0;
            line = (line + 1);
            ignoreNext = "\n";
          }
        }
        if (!_matched) {
          {
            ignoreNext = null;
            column = (column + 1);
          }
        }
      }
      _xblockexpression = Pair.<Integer, Integer>of(Integer.valueOf(line), Integer.valueOf(column));
    }
    return _xblockexpression;
  }
  
  public static void clearSourceFolderContents(final SWTWorkbenchBot it) {
    SwtBotProjectHelper.clearSourceFolderContents(it, SwtBotProjectHelper.defaultProject);
  }
  
  public static void clearSourceFolderContents(final SWTWorkbenchBot it, final String project) {
    try {
      try {
        SWTBotTree packageExplorerTree = it.tree();
        SWTBotTree _tree = it.tree();
        boolean _hasItems = _tree.hasItems();
        boolean _not = (!_hasItems);
        if (_not) {
          SWTBotView _viewByTitle = it.viewByTitle("Package Explorer");
          SWTBot _bot = _viewByTitle.bot();
          SWTBotTree _tree_1 = _bot.tree();
          packageExplorerTree = _tree_1;
        }
        SWTBotTreeItem _expandNode = SwtBotProjectHelper.expandNode(packageExplorerTree, project);
        final SWTBotTreeItem srcNode = SwtBotProjectHelper.expandNode(_expandNode, "src");
        SWTBotTreeItem[] _items = srcNode.getItems();
        for (final SWTBotTreeItem source : _items) {
          boolean _isDisposed = source.widget.isDisposed();
          boolean _not_1 = (!_isDisposed);
          if (_not_1) {
            SWTBotText _text = it.text();
            InputOutput.<SWTBotText>println(_text);
            String _text_1 = source.getText();
            srcNode.select(_text_1);
            SWTBotMenu _contextMenu = source.contextMenu("Delete");
            _contextMenu.click();
            SWTBotShell _shell = it.shell("Delete");
            _shell.activate();
            SWTBotButton _button = it.button("OK");
            _button.click();
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof WidgetNotFoundException) {
          final WidgetNotFoundException exc = (WidgetNotFoundException)_t;
          IWorkspace _workspace = ResourcesPlugin.getWorkspace();
          IWorkspaceRoot _root = _workspace.getRoot();
          IProject _project = _root.getProject(project);
          IFolder _folder = _project.getFolder("src");
          IResource[] _members = _folder.members();
          final Procedure1<IResource> _function = new Procedure1<IResource>() {
            @Override
            public void apply(final IResource it) {
              try {
                it.delete(true, null);
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
          IterableExtensions.<IResource>forEach(((Iterable<IResource>)Conversions.doWrapArray(_members)), _function);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static SWTBotTreeItem expandNode(final AbstractSWTBot<?> bot, final String node) {
    SWTBotTreeItem item = null;
    if ((bot instanceof SWTBotTree)) {
      SWTBotTreeItem _treeItem = ((SWTBotTree)bot).getTreeItem(node);
      item = _treeItem;
    } else {
      if ((bot instanceof SWTBotTreeItem)) {
        SWTBotTreeItem _node = ((SWTBotTreeItem)bot).getNode(node);
        item = _node;
      }
    }
    boolean _isExpanded = item.isExpanded();
    boolean _not = (!_isExpanded);
    if (_not) {
      item.expand();
    }
    return item;
  }
}
