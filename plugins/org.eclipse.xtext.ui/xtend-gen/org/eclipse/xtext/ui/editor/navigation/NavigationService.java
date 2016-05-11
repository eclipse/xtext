/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.navigation;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.OpenAndLinkWithEditorHelper;
import org.eclipse.xtext.ide.editor.navigation.INavigatable;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @since 2.10
 * 
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class NavigationService {
  @Inject
  private IURIEditorOpener uriEditorOpener;
  
  public void open(final OpenEvent openEvent) {
    this.open(openEvent, true);
  }
  
  public void open(final OpenEvent openEvent, final boolean select) {
    final ISelection selection = openEvent.getSelection();
    if ((selection instanceof IStructuredSelection)) {
      Iterator _iterator = ((IStructuredSelection)selection).iterator();
      Iterable<Object> _iterable = IteratorExtensions.<Object>toIterable(_iterator);
      Iterable<INavigatable> _filter = Iterables.<INavigatable>filter(_iterable, INavigatable.class);
      for (final INavigatable navigatable : _filter) {
        this.open(navigatable, select);
      }
    }
  }
  
  public void open(final INavigatable navigatable) {
    this.open(navigatable, true);
  }
  
  public void open(final INavigatable navigatable, final boolean select) {
    Object _navigationElement = null;
    if (navigatable!=null) {
      _navigationElement=navigatable.getNavigationElement();
    }
    final Object navigatableElement = _navigationElement;
    boolean _matched = false;
    if (navigatableElement instanceof IReferenceDescription) {
      _matched=true;
      URI _sourceEObjectUri = ((IReferenceDescription)navigatableElement).getSourceEObjectUri();
      EReference _eReference = ((IReferenceDescription)navigatableElement).getEReference();
      int _indexInList = ((IReferenceDescription)navigatableElement).getIndexInList();
      this.uriEditorOpener.open(_sourceEObjectUri, _eReference, _indexInList, select);
    }
    if (!_matched) {
      if (navigatableElement instanceof IEObjectDescription) {
        _matched=true;
        URI _eObjectURI = ((IEObjectDescription)navigatableElement).getEObjectURI();
        this.uriEditorOpener.open(_eObjectURI, select);
      }
    }
    if (!_matched) {
      if (navigatableElement instanceof IResourceDescription) {
        _matched=true;
        URI _uRI = ((IResourceDescription)navigatableElement).getURI();
        this.uriEditorOpener.open(_uRI, select);
      }
    }
    if (!_matched) {
      if (navigatableElement instanceof INavigatable) {
        _matched=true;
        this.open(((INavigatable)navigatableElement), select);
      }
    }
  }
  
  public OpenAndLinkWithEditorHelper installNavigationSupport(final StructuredViewer viewer) {
    return this.installNavigationSupport(viewer, true);
  }
  
  public OpenAndLinkWithEditorHelper installNavigationSupport(final StructuredViewer viewer, final boolean select) {
    final Procedure1<OpenEvent> _function = new Procedure1<OpenEvent>() {
      @Override
      public void apply(final OpenEvent it) {
        NavigationService.this.open(it, select);
      }
    };
    return this.installNavigationSupport(viewer, _function);
  }
  
  public OpenAndLinkWithEditorHelper installNavigationSupport(final StructuredViewer viewer, final Procedure1<? super OpenEvent> opener) {
    return new OpenAndLinkWithEditorHelper(viewer) {
      @Override
      protected void activate(final ISelection selection) {
        final int currentMode = OpenStrategy.getOpenMethod();
        try {
          OpenStrategy.setOpenMethod(OpenStrategy.DOUBLE_CLICK);
          OpenEvent _openEvent = new OpenEvent(viewer, selection);
          opener.apply(_openEvent);
        } finally {
          OpenStrategy.setOpenMethod(currentMode);
        }
      }
      
      @Override
      protected void linkToEditor(final ISelection selection) {
      }
      
      @Override
      protected void open(final ISelection selection, final boolean activate) {
        OpenEvent _openEvent = new OpenEvent(viewer, selection);
        opener.apply(_openEvent);
      }
    };
  }
}
