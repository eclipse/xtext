/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import java.util.List;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class ResourceRelocationStrategyExecutor {
  private final static Logger LOG = Logger.getLogger(ResourceRelocationStrategyExecutor.class);
  
  public void executeParticipants(final List<? extends IResourceRelocationStrategy> strategies, final ResourceRelocationContext context) {
    ResourceRelocationContext.ChangeType _changeType = context.getChangeType();
    boolean _tripleEquals = (_changeType == ResourceRelocationContext.ChangeType.COPY);
    if (_tripleEquals) {
      IChangeSerializer _changeSerializer = context.getChangeSerializer();
      _changeSerializer.setUpdateRelatedFiles(false);
    }
    final Consumer<IResourceRelocationStrategy> _function = (IResourceRelocationStrategy it) -> {
      try {
        it.loadAndWatchResources(context);
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          context.getIssueAcceptor().add(RefactoringIssueAcceptor.Severity.ERROR, "Error loading resources", t);
          ResourceRelocationStrategyExecutor.LOG.error(t);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    strategies.forEach(_function);
    final Consumer<IResourceRelocationStrategy> _function_1 = (IResourceRelocationStrategy it) -> {
      try {
        it.applyChange(context);
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          context.getIssueAcceptor().add(RefactoringIssueAcceptor.Severity.ERROR, "Error applying resource changes", t);
          ResourceRelocationStrategyExecutor.LOG.error(t);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    strategies.forEach(_function_1);
    final Consumer<IResourceRelocationStrategy> _function_2 = (IResourceRelocationStrategy it) -> {
      try {
        it.applySideEffects(context);
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          context.getIssueAcceptor().add(RefactoringIssueAcceptor.Severity.ERROR, "Error applying side effects", t);
          ResourceRelocationStrategyExecutor.LOG.error(t);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    strategies.forEach(_function_2);
  }
}
