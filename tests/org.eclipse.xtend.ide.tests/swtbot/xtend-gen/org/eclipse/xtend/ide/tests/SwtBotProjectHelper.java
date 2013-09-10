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
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotPerspective;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.finders.ContextMenuHelper;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotList;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTabItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class SwtBotProjectHelper {
  private final static String defaultProject = "test";
  
  public static SWTBotShell newXtendProject(final SWTWorkbenchBot it) {
    SWTBotShell _newXtendProject = SwtBotProjectHelper.newXtendProject(it, SwtBotProjectHelper.defaultProject);
    return _newXtendProject;
  }
  
  public static SWTBotShell newXtendProject(final SWTWorkbenchBot it, final String projectName) {
    SWTBotShell _xblockexpression = null;
    {
      final SWTBotShell shell = it.activeShell();
      SWTBotView _viewByTitle = it.viewByTitle("Welcome");
      _viewByTitle.close();
      SWTBotPerspective _perspectiveByLabel = it.perspectiveByLabel("Java");
      _perspectiveByLabel.activate();
      SWTBotMenu _menu = it.menu("File");
      SWTBotMenu _menu_1 = _menu.menu("New");
      SWTBotMenu _menu_2 = _menu_1.menu("Project...");
      _menu_2.click();
      SWTBotShell _shell = it.shell("New Project");
      _shell.activate();
      SWTBotTree _tree = it.tree();
      SWTBotTreeItem _expandNode = _tree.expandNode("Java");
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
      SWTBotShell _activate = shell.activate();
      _xblockexpression = (_activate);
    }
    return _xblockexpression;
  }
  
  public static SWTBotEclipseEditor newJavaEditor(final SWTWorkbenchBot it, final String typeName) {
    String _plus = (SwtBotProjectHelper.defaultProject + "/src");
    SWTBotEclipseEditor _newJavaEditor = SwtBotProjectHelper.newJavaEditor(it, typeName, "", _plus);
    return _newJavaEditor;
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
      String _plus = (typeName + ".java");
      SWTBotEditor _editorByTitle = it.editorByTitle(_plus);
      SWTBotEclipseEditor _textEditor = _editorByTitle.toTextEditor();
      _xblockexpression = (_textEditor);
    }
    return _xblockexpression;
  }
  
  public static SWTBotEclipseEditor newXtendEditor(final SWTWorkbenchBot it, final String typeName) {
    String _plus = (SwtBotProjectHelper.defaultProject + "/src");
    SWTBotEclipseEditor _newXtendEditor = SwtBotProjectHelper.newXtendEditor(it, typeName, "", _plus);
    return _newXtendEditor;
  }
  
  public static SWTBotEclipseEditor newXtendEditor(final SWTWorkbenchBot it, final String typeName, final String packageName, final String sourceFolderPath) {
    SWTBotEclipseEditor _xblockexpression = null;
    {
      SWTBotMenu _menu = it.menu("File");
      SWTBotMenu _menu_1 = _menu.menu("New");
      SWTBotMenu _menu_2 = _menu_1.menu("Xtend Class");
      _menu_2.click();
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
      String _plus = (typeName + ".xtend");
      SWTBotEditor _editorByTitle = it.editorByTitle(_plus);
      SWTBotEclipseEditor _textEditor = _editorByTitle.toTextEditor();
      _xblockexpression = (_textEditor);
    }
    return _xblockexpression;
  }
  
  public static void closeAllEditors(final SWTWorkbenchBot it) {
    List<? extends SWTBotEditor> _editors = it.editors();
    final Procedure1<SWTBotEditor> _function = new Procedure1<SWTBotEditor>() {
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
    int _minus = (-1);
    boolean _notEquals = (offset != _minus);
    if (_notEquals) {
      final Pair<Integer,Integer> lineAndColumn = SwtBotProjectHelper.getLineAndColumn(contentString, offset);
      Integer _key = lineAndColumn.getKey();
      Integer _value = lineAndColumn.getValue();
      int _lastIndexOf = contentString.lastIndexOf("?");
      int _minus_1 = (_lastIndexOf - offset);
      int _minus_2 = (_minus_1 - 1);
      it.selectRange((_key).intValue(), (_value).intValue(), _minus_2);
    }
  }
  
  public static SWTBotMenu clickableContextMenu(final SWTBotEclipseEditor editor, final String... text) {
    SWTBotStyledText _styledText = editor.getStyledText();
    MenuItem _contextMenu = ContextMenuHelper.contextMenu(_styledText, text);
    SWTBotMenu _sWTBotMenu = new SWTBotMenu(_contextMenu);
    return _sWTBotMenu;
  }
  
  protected static Pair<Integer,Integer> getLineAndColumn(final String content, final int offset) {
    Pair<Integer,Integer> _xblockexpression = null;
    {
      int line = 0;
      int column = 0;
      String ignoreNext = null;
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, offset, true);
      for (final Integer i : _doubleDotLessThan) {
        int _plus = ((i).intValue() + 1);
        String _substring = content.substring((i).intValue(), _plus);
        final String _switchValue = _substring;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_switchValue,ignoreNext)) {
            _matched=true;
            ignoreNext = null;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"\n")) {
            _matched=true;
            column = 0;
            int _plus_1 = (line + 1);
            line = _plus_1;
            ignoreNext = "\r";
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"\r")) {
            _matched=true;
            column = 0;
            int _plus_2 = (line + 1);
            line = _plus_2;
            ignoreNext = "\n";
          }
        }
        if (!_matched) {
          {
            ignoreNext = null;
            int _plus_3 = (column + 1);
            column = _plus_3;
          }
        }
      }
      Pair<Integer,Integer> _mappedTo = Pair.<Integer, Integer>of(Integer.valueOf(line), Integer.valueOf(column));
      _xblockexpression = (_mappedTo);
    }
    return _xblockexpression;
  }
  
  public static void clearSourceFolderContents(final SWTWorkbenchBot it) {
    SwtBotProjectHelper.clearSourceFolderContents(it, SwtBotProjectHelper.defaultProject);
  }
  
  public static void clearSourceFolderContents(final SWTWorkbenchBot it, final String project) {
    SWTBotTree _tree = it.tree();
    SWTBotTreeItem _expandNode = _tree.expandNode(project);
    final SWTBotTreeItem srcNode = _expandNode.expandNode("src");
    SWTBotTreeItem[] _items = srcNode.getItems();
    for (final SWTBotTreeItem source : _items) {
      boolean _isDisposed = source.widget.isDisposed();
      boolean _not = (!_isDisposed);
      if (_not) {
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
  }
}
