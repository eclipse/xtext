/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.IWebContentProposaAcceptor;
import org.eclipse.xtext.web.server.contentassist.WebContentProposalPriorities;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class CrossrefProposalProvider {
  private final static Logger LOG = Logger.getLogger(CrossrefProposalProvider.class);
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Inject
  private WebContentProposalPriorities proposalPriorities;
  
  public void lookupCrossReference(final IScope scope, final CrossReference crossReference, final ContentAssistContext context, final IWebContentProposaAcceptor acceptor, final Predicate<IEObjectDescription> filter) {
    try {
      Iterable<IEObjectDescription> _queryScope = this.queryScope(scope, crossReference, context);
      for (final IEObjectDescription candidate : _queryScope) {
        boolean _apply = filter.apply(candidate);
        if (_apply) {
          final ContentAssistResult.Entry entry = this.createProposal(candidate, crossReference, context);
          int _crossRefPriority = this.proposalPriorities.getCrossRefPriority(candidate, entry);
          acceptor.accept(entry, _crossRefPriority);
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof UnsupportedOperationException) {
        final UnsupportedOperationException uoe = (UnsupportedOperationException)_t;
        CrossrefProposalProvider.LOG.error("Failed to create content assist proposals for cross-reference.", uoe);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected Iterable<IEObjectDescription> queryScope(final IScope scope, final CrossReference crossReference, final ContentAssistContext context) {
    Iterable<IEObjectDescription> _xblockexpression = null;
    {
      String _prefix = context.getPrefix();
      boolean _isEmpty = _prefix.isEmpty();
      if (_isEmpty) {
        return scope.getAllElements();
      }
      String _prefix_1 = context.getPrefix();
      final QualifiedName prefix = this.qualifiedNameConverter.toQualifiedName(_prefix_1);
      Iterable<IEObjectDescription> _allElements = scope.getAllElements();
      final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
        @Override
        public Boolean apply(final IEObjectDescription it) {
          return Boolean.valueOf(CrossrefProposalProvider.this.matchesPrefix(it, prefix));
        }
      };
      _xblockexpression = IterableExtensions.<IEObjectDescription>filter(_allElements, _function);
    }
    return _xblockexpression;
  }
  
  protected boolean matchesPrefix(final IEObjectDescription candidate, final QualifiedName prefix) {
    final QualifiedName name = candidate.getName();
    final int count = prefix.getSegmentCount();
    int _segmentCount = name.getSegmentCount();
    boolean _greaterThan = (count > _segmentCount);
    if (_greaterThan) {
      return false;
    }
    for (int i = 0; (i < count); i++) {
      {
        final String nameSegment = name.getSegment(i);
        final String prefixSegment = prefix.getSegment(i);
        boolean _or = false;
        boolean _and = false;
        if (!(i < (count - 1))) {
          _and = false;
        } else {
          boolean _notEquals = (!Objects.equal(nameSegment, prefixSegment));
          _and = _notEquals;
        }
        if (_and) {
          _or = true;
        } else {
          boolean _and_1 = false;
          if (!(i == (count - 1))) {
            _and_1 = false;
          } else {
            int _length = prefixSegment.length();
            boolean _regionMatches = nameSegment.regionMatches(true, 0, prefixSegment, 0, _length);
            boolean _not = (!_regionMatches);
            _and_1 = _not;
          }
          _or = _and_1;
        }
        if (_or) {
          return false;
        }
      }
    }
    return true;
  }
  
  protected ContentAssistResult.Entry createProposal(final IEObjectDescription candidate, final CrossReference crossRef, final ContentAssistContext context) {
    String _prefix = context.getPrefix();
    ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(_prefix);
    final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
      @Override
      public void apply(final ContentAssistResult.Entry it) {
        QualifiedName _name = candidate.getName();
        String _string = CrossrefProposalProvider.this.qualifiedNameConverter.toString(_name);
        it.setProposal(_string);
        EClass _eClass = candidate.getEClass();
        String _name_1 = null;
        if (_eClass!=null) {
          _name_1=_eClass.getName();
        }
        it.setDescription(_name_1);
      }
    };
    return ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
  }
  
  @Pure
  protected IQualifiedNameConverter getQualifiedNameConverter() {
    return this.qualifiedNameConverter;
  }
}
