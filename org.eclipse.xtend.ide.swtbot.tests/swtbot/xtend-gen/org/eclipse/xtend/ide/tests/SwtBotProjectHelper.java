/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.ContextMenuHelper;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
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
  private static final String defaultProject = "test";

  public static SWTBotShell newXtendProject(final SWTWorkbenchBot it) {
    return SwtBotProjectHelper.newXtendProject(it, SwtBotProjectHelper.defaultProject);
  }

  public static SWTBotShell newXtendProject(final SWTWorkbenchBot it, final String projectName) {
    SWTBotShell _xblockexpression = null;
    {
      final SWTBotShell shell = it.activeShell();
      final Function1<SWTBotView, Boolean> _function = (SWTBotView it_1) -> {
        String _title = it_1.getTitle();
        return Boolean.valueOf(Objects.equals(_title, "Welcome"));
      };
      SWTBotView _findFirst = IterableExtensions.<SWTBotView>findFirst(it.views(), _function);
      if (_findFirst!=null) {
        _findFirst.close();
      }
      it.perspectiveByLabel("Java").activate();
      SwtBotProjectHelper.fileNew(it, "Project...");
      it.shell("New Project").activate();
      SwtBotProjectHelper.expandNode(it.tree(), "Java").select("Java Project");
      it.button("Next >").click();
      SWTBotText _textWithLabel = it.textWithLabel("Project name:");
      _textWithLabel.setText(projectName);
      it.button("Next >").click();
      it.tabItem("Libraries").activate();
      it.button("Add Library...").click();
      it.shell("Add Library").activate();
      it.list().select("Xtend Library");
      it.button("Next >").click();
      it.button("Finish").click();
      it.button("Finish").click();
      _xblockexpression = shell.activate();
    }
    return _xblockexpression;
  }

  public static SWTBotEclipseEditor newJavaEditor(final SWTWorkbenchBot it, final String typeName) {
    return SwtBotProjectHelper.newJavaEditor(it, typeName, "", (SwtBotProjectHelper.defaultProject + "/src"));
  }

  public static SWTBotEclipseEditor newJavaEditor(final SWTWorkbenchBot it, final String typeName, final CharSequence content) {
    SWTBotEclipseEditor _newJavaEditor = SwtBotProjectHelper.newJavaEditor(it, typeName, "", (SwtBotProjectHelper.defaultProject + "/src"));
    final Procedure1<SWTBotEclipseEditor> _function = (SWTBotEclipseEditor it_1) -> {
      SwtBotProjectHelper.setContent(it_1, content);
    };
    return ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newJavaEditor, _function);
  }

  public static SWTBotEclipseEditor newJavaEditor(final SWTWorkbenchBot it, final String typeName, final String packageName, final CharSequence content) {
    SWTBotEclipseEditor _newJavaEditor = SwtBotProjectHelper.newJavaEditor(it, typeName, packageName, (SwtBotProjectHelper.defaultProject + "/src"));
    final Procedure1<SWTBotEclipseEditor> _function = (SWTBotEclipseEditor it_1) -> {
      SwtBotProjectHelper.setContent(it_1, content);
    };
    return ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newJavaEditor, _function);
  }

  public static SWTBotEclipseEditor newJavaEditor(final SWTWorkbenchBot it, final String typeName, final String packageName, final String sourceFolderPath) {
    SWTBotEclipseEditor _xblockexpression = null;
    {
      SwtBotProjectHelper.fileNew(it, "Class");
      it.shell("New Java Class").activate();
      SWTBotText _textWithLabel = it.textWithLabel("Source folder:");
      _textWithLabel.setText(sourceFolderPath);
      SWTBotText _textWithLabel_1 = it.textWithLabel("Package:");
      _textWithLabel_1.setText(packageName);
      SWTBotText _textWithLabel_2 = it.textWithLabel("Name:");
      _textWithLabel_2.setText(typeName);
      it.button("Finish").click();
      _xblockexpression = it.editorByTitle((typeName + ".java")).toTextEditor();
    }
    return _xblockexpression;
  }

  public static SWTBotEclipseEditor newXtendEditor(final SWTWorkbenchBot it, final String typeName, final CharSequence content) {
    SWTBotEclipseEditor _newXtendEditor = SwtBotProjectHelper.newXtendEditor(it, typeName, "", (SwtBotProjectHelper.defaultProject + "/src"));
    final Procedure1<SWTBotEclipseEditor> _function = (SWTBotEclipseEditor it_1) -> {
      SwtBotProjectHelper.setContent(it_1, content);
    };
    return ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newXtendEditor, _function);
  }

  public static SWTBotEclipseEditor newXtendEditor(final SWTWorkbenchBot it, final String typeName, final String packageName, final CharSequence content) {
    SWTBotEclipseEditor _newXtendEditor = SwtBotProjectHelper.newXtendEditor(it, typeName, packageName, (SwtBotProjectHelper.defaultProject + "/src"));
    final Procedure1<SWTBotEclipseEditor> _function = (SWTBotEclipseEditor it_1) -> {
      SwtBotProjectHelper.setContent(it_1, content);
    };
    return ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newXtendEditor, _function);
  }

  public static SWTBotEclipseEditor newXtendEditor(final SWTWorkbenchBot it, final String typeName, final String packageName, final String sourceFolderPath) {
    SWTBotEclipseEditor _xblockexpression = null;
    {
      try {
        SwtBotProjectHelper.fileNew(it, "Xtend Class");
      } catch (final Throwable _t) {
        if (_t instanceof WidgetNotFoundException) {
          final WidgetNotFoundException e = (WidgetNotFoundException)_t;
          final Consumer<SWTBotShell> _function = (SWTBotShell it_1) -> {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Shell: \'");
            String _text = it_1.getText();
            _builder.append(_text);
            _builder.append("\', active: ");
            boolean _isActive = it_1.isActive();
            _builder.append(_isActive);
            InputOutput.<String>println(_builder.toString());
          };
          ((List<SWTBotShell>)Conversions.doWrapArray(it.shells())).forEach(_function);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(SWTBotPreferences.SCREENSHOTS_DIR);
          _builder.append("/MenuFileNotFound");
          long _currentTimeMillis = System.currentTimeMillis();
          _builder.append(_currentTimeMillis);
          _builder.append(".");
          _builder.append(SWTBotPreferences.SCREENSHOT_FORMAT);
          final Function1<SWTBotShell, Boolean> _function_1 = (SWTBotShell it_1) -> {
            return Boolean.valueOf(it_1.isActive());
          };
          SWTUtils.captureScreenshot(_builder.toString(), 
            IterableExtensions.<SWTBotShell>head(IterableExtensions.<SWTBotShell>filter(((Iterable<SWTBotShell>)Conversions.doWrapArray(it.shells())), _function_1)).widget);
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      it.shell("Xtend Class").activate();
      SWTBotText _textWithLabel = it.textWithLabel("Source folder:");
      _textWithLabel.setText(sourceFolderPath);
      SWTBotText _textWithLabel_1 = it.textWithLabel("Package:");
      _textWithLabel_1.setText(packageName);
      SWTBotText _textWithLabel_2 = it.textWithLabel("Name:");
      _textWithLabel_2.setText(typeName);
      it.button("Finish").click();
      _xblockexpression = it.editorByTitle((typeName + ".xtend")).toTextEditor();
    }
    return _xblockexpression;
  }

  protected static void fileNew(final SWTWorkbenchBot it, final String newWhat) {
    int retries = 3;
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, retries, true);
    for (final Integer i : _doubleDotLessThan) {
      try {
        it.menu("File").menu("New").menu(newWhat).click();
        return;
      } catch (final Throwable _t) {
        if (_t instanceof WidgetNotFoundException) {
          final WidgetNotFoundException e = (WidgetNotFoundException)_t;
          if (((i).intValue() == (retries - 1))) {
            throw e;
          }
          String _message = e.getMessage();
          String _plus = ("failed: " + _message);
          InputOutput.<String>println(_plus);
          InputOutput.<String>println("retrying...");
          it.sleep(1000);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }

  public static void closeAllEditors(final SWTWorkbenchBot it) {
    final Consumer<SWTBotEditor> _function = (SWTBotEditor it_1) -> {
      it_1.close();
    };
    it.editors().forEach(_function);
  }

  public static void setContent(final SWTBotEclipseEditor it, final CharSequence content) {
    final String contentString = content.toString();
    it.setText(contentString.replace("?", ""));
    final int offset = contentString.indexOf("?");
    if ((offset != (-1))) {
      final Pair<Integer, Integer> lineAndColumn = SwtBotProjectHelper.getLineAndColumn(contentString, offset);
      int _lastIndexOf = contentString.lastIndexOf("?");
      int _minus = (_lastIndexOf - offset);
      int _minus_1 = (_minus - 1);
      it.selectRange((lineAndColumn.getKey()).intValue(), (lineAndColumn.getValue()).intValue(), _minus_1);
    }
  }

  public static SWTBotMenu clickableContextMenu(final SWTBotEclipseEditor editor, final String... text) {
    MenuItem _contextMenu = ContextMenuHelper.contextMenu(editor.getStyledText(), text);
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
        if (Objects.equals(_substring, ignoreNext)) {
          _matched=true;
          ignoreNext = null;
        }
        if (!_matched) {
          if (Objects.equals(_substring, "\n")) {
            _matched=true;
            column = 0;
            line = (line + 1);
            ignoreNext = "\r";
          }
        }
        if (!_matched) {
          if (Objects.equals(_substring, "\r")) {
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
        boolean _hasItems = it.tree().hasItems();
        boolean _not = (!_hasItems);
        if (_not) {
          packageExplorerTree = it.viewByTitle("Package Explorer").bot().tree();
        }
        final SWTBotTreeItem srcNode = SwtBotProjectHelper.expandNode(SwtBotProjectHelper.expandNode(packageExplorerTree, project), "src");
        SWTBotTreeItem[] _items = srcNode.getItems();
        for (final SWTBotTreeItem source : _items) {
          boolean _isDisposed = source.widget.isDisposed();
          boolean _not_1 = (!_isDisposed);
          if (_not_1) {
            InputOutput.<SWTBotText>println(it.text());
            srcNode.select(source.getText());
            source.contextMenu("Delete").click();
            it.shell("Delete").activate();
            it.button("OK").click();
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof WidgetNotFoundException) {
          final Consumer<IResource> _function = (IResource it_1) -> {
            try {
              it_1.delete(true, null);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          ((List<IResource>)Conversions.doWrapArray(ResourcesPlugin.getWorkspace().getRoot().getProject(project).getFolder("src").members())).forEach(_function);
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
      item = ((SWTBotTree)bot).getTreeItem(node);
    } else {
      if ((bot instanceof SWTBotTreeItem)) {
        item = ((SWTBotTreeItem)bot).getNode(node);
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
