/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import com.google.common.collect.LinkedHashMultimap;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class ResourceRelocationStrategyExecutor {
  private final static Logger LOG = Logger.getLogger(ResourceRelocationStrategyExecutor.class);
  
  public void executeParticipants(final List<? extends IResourceRelocationStrategy> strategies, final ResourceRelocationContext context) {
    final LinkedHashMultimap<ResourceRelocationChange, IResourceRelocationStrategy> change2strategies = LinkedHashMultimap.<ResourceRelocationChange, IResourceRelocationStrategy>create();
    List<ResourceRelocationChange> _changes = context.getChanges();
    for (final ResourceRelocationChange change : _changes) {
      for (final IResourceRelocationStrategy strategy : strategies) {
        boolean _canHandle = strategy.canHandle(change);
        if (_canHandle) {
          change2strategies.put(change, strategy);
        }
      }
    }
    final HashMap<ResourceRelocationChange, Resource> change2resource = CollectionLiterals.<ResourceRelocationChange, Resource>newHashMap();
    Set<ResourceRelocationChange> _keySet = change2strategies.keySet();
    for (final ResourceRelocationChange change_1 : _keySet) {
      {
        final IResourceRelocationStrategy primaryStrategy = IterableExtensions.<IResourceRelocationStrategy>head(change2strategies.get(change_1));
        try {
          final Resource resource = primaryStrategy.loadAndWatchResource(change_1, context);
          change2resource.put(change_1, resource);
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable t = (Throwable)_t;
            URI _fromURI = null;
            if (change_1!=null) {
              _fromURI=change_1.getFromURI();
            }
            String _string = null;
            if (_fromURI!=null) {
              _string=_fromURI.toString();
            }
            String _plus = ("Error loading resource " + _string);
            context.getIssueAcceptor().add(RefactoringIssueAcceptor.Severity.ERROR, _plus, t);
            ResourceRelocationStrategyExecutor.LOG.error(t);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    Set<ResourceRelocationChange> _keySet_1 = change2strategies.keySet();
    for (final ResourceRelocationChange change_2 : _keySet_1) {
      {
        boolean changeApplied = false;
        final Resource resource = change2resource.get(change_2);
        Set<IResourceRelocationStrategy> _get = change2strategies.get(change_2);
        for (final IResourceRelocationStrategy strategy_1 : _get) {
          {
            if ((!changeApplied)) {
              try {
                strategy_1.applyChange(change_2, resource, context);
                changeApplied = true;
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable t = (Throwable)_t;
                  URI _fromURI = null;
                  if (change_2!=null) {
                    _fromURI=change_2.getFromURI();
                  }
                  String _string = null;
                  if (_fromURI!=null) {
                    _string=_fromURI.toString();
                  }
                  String _plus = ("Error applying relocation change to " + _string);
                  context.getIssueAcceptor().add(RefactoringIssueAcceptor.Severity.ERROR, _plus, t);
                  ResourceRelocationStrategyExecutor.LOG.error(t);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
            }
            if (changeApplied) {
              try {
                strategy_1.applySideEffects(change_2, resource, context);
              } catch (final Throwable _t_1) {
                if (_t_1 instanceof Throwable) {
                  final Throwable t_1 = (Throwable)_t_1;
                  URI _fromURI_1 = null;
                  if (change_2!=null) {
                    _fromURI_1=change_2.getFromURI();
                  }
                  String _string_1 = null;
                  if (_fromURI_1!=null) {
                    _string_1=_fromURI_1.toString();
                  }
                  String _plus_1 = ("Error applying side effect to " + _string_1);
                  context.getIssueAcceptor().add(RefactoringIssueAcceptor.Severity.ERROR, _plus_1, t_1);
                  ResourceRelocationStrategyExecutor.LOG.error(t_1);
                } else {
                  throw Exceptions.sneakyThrow(_t_1);
                }
              }
            }
          }
        }
      }
    }
  }
}
