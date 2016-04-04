/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.tasks.ITaskParser;
import org.eclipse.xtext.tasks.ITaskTagProvider;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskTags;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class DefaultTaskFinder implements ITaskFinder {
  @Inject
  private ITaskParser parser;
  
  @Inject
  private ITaskTagProvider taskTagProvider;
  
  @Inject
  private IHiddenTokenHelper hiddenTokenHelper;
  
  @Override
  public List<Task> findTasks(final Resource resource) {
    List<Task> _xblockexpression = null;
    {
      final TaskTags taskTags = this.taskTagProvider.getTaskTags(resource);
      boolean _isEmpty = IterableExtensions.isEmpty(taskTags);
      if (_isEmpty) {
        return Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList());
      }
      List<Task> _xifexpression = null;
      if ((resource instanceof XtextResource)) {
        List<Task> _elvis = null;
        IParseResult _parseResult = ((XtextResource)resource).getParseResult();
        ICompositeNode _rootNode = null;
        if (_parseResult!=null) {
          _rootNode=_parseResult.getRootNode();
        }
        List<Task> _findTasks = null;
        if (_rootNode!=null) {
          _findTasks=this.findTasks(_rootNode, taskTags);
        }
        if (_findTasks != null) {
          _elvis = _findTasks;
        } else {
          _elvis = Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList());
        }
        _xifexpression = _elvis;
      } else {
        _xifexpression = Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected List<Task> findTasks(final ICompositeNode it, final TaskTags taskTags) {
    Iterable<ILeafNode> _leafNodes = it.getLeafNodes();
    final Function1<ILeafNode, List<Task>> _function = new Function1<ILeafNode, List<Task>>() {
      @Override
      public List<Task> apply(final ILeafNode it) {
        return DefaultTaskFinder.this.findTasks(it, taskTags);
      }
    };
    Iterable<List<Task>> _map = IterableExtensions.<ILeafNode, List<Task>>map(_leafNodes, _function);
    Iterable<Task> _flatten = Iterables.<Task>concat(_map);
    return IterableExtensions.<Task>toList(_flatten);
  }
  
  protected List<Task> findTasks(final ILeafNode node, final TaskTags taskTags) {
    boolean _canContainTaskTags = this.canContainTaskTags(node);
    if (_canContainTaskTags) {
      String _text = node.getText();
      final List<Task> tasks = this.parser.parseTasks(_text, taskTags);
      for (final Task it : tasks) {
        {
          int _offset = it.getOffset();
          int _offset_1 = node.getOffset();
          int _plus = (_offset + _offset_1);
          it.setOffset(_plus);
          int _lineNumber = it.getLineNumber();
          int _startLine = node.getStartLine();
          int _plus_1 = (_lineNumber + _startLine);
          int _minus = (_plus_1 - 1);
          it.setLineNumber(_minus);
        }
      }
      return tasks;
    }
    return Collections.<Task>unmodifiableList(CollectionLiterals.<Task>newArrayList());
  }
  
  protected boolean canContainTaskTags(final ILeafNode node) {
    final EObject rule = node.getGrammarElement();
    if ((rule instanceof AbstractRule)) {
      return this.hiddenTokenHelper.isComment(((AbstractRule)rule));
    }
    return false;
  }
}
