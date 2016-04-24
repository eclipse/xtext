/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.hierarchy.DeferredHierarchyBuilder;
import org.eclipse.xtext.ui.editor.hierarchy.HierarchyLabelProvider;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyNode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public class XtextCallHierarchyLabelProvider extends LabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {
  @Inject
  private HierarchyLabelProvider hierarchyLabelProvider;
  
  @Override
  public Image getImage(final Object element) {
    return this.hierarchyLabelProvider.getImage(element);
  }
  
  protected String _getText(final Object element) {
    return this.hierarchyLabelProvider.getText(element);
  }
  
  protected String _getText(final DeferredHierarchyBuilder.DeferredHierarchyNode it) {
    IHierarchyNode _delegate = it.getDelegate();
    return this.getText(_delegate);
  }
  
  protected String _getText(final XtextCallHierarchyNode it) {
    IEObjectDescription _element = it.getElement();
    boolean _tripleEquals = (_element == null);
    if (_tripleEquals) {
      return this.hierarchyLabelProvider.getText(it);
    }
    IEObjectDescription _element_1 = it.getElement();
    QualifiedName _qualifiedName = _element_1.getQualifiedName();
    IEObjectDescription _grammarDescription = it.getGrammarDescription();
    QualifiedName _qualifiedName_1 = null;
    if (_grammarDescription!=null) {
      _qualifiedName_1=_grammarDescription.getQualifiedName();
    }
    Iterable<QualifiedName> _filterNull = IterableExtensions.<QualifiedName>filterNull(Collections.<QualifiedName>unmodifiableList(CollectionLiterals.<QualifiedName>newArrayList(_qualifiedName, _qualifiedName_1)));
    return IterableExtensions.join(_filterNull, " - ");
  }
  
  protected StyledString _getStyledText(final Object element) {
    return this.hierarchyLabelProvider.getStyledText(element);
  }
  
  protected StyledString _getStyledText(final DeferredHierarchyBuilder.DeferredHierarchyNode it) {
    IHierarchyNode _delegate = it.getDelegate();
    return this.getStyledText(_delegate);
  }
  
  protected StyledString _getStyledText(final XtextCallHierarchyNode it) {
    IEObjectDescription _element = it.getElement();
    boolean _tripleEquals = (_element == null);
    if (_tripleEquals) {
      return this.hierarchyLabelProvider.getStyledText(it);
    }
    IEObjectDescription _element_1 = it.getElement();
    QualifiedName _qualifiedName = _element_1.getQualifiedName();
    String _plus = ("" + _qualifiedName);
    final StyledString styledString = new StyledString(_plus);
    IEObjectDescription _grammarDescription = it.getGrammarDescription();
    boolean _tripleEquals_1 = (_grammarDescription == null);
    if (_tripleEquals_1) {
      return styledString;
    }
    IEObjectDescription _grammarDescription_1 = it.getGrammarDescription();
    QualifiedName _qualifiedName_1 = _grammarDescription_1.getQualifiedName();
    String _plus_1 = (" - " + _qualifiedName_1);
    StyledString _styledString = new StyledString(_plus_1, StyledString.QUALIFIER_STYLER);
    return styledString.append(_styledString);
  }
  
  public String getText(final Object it) {
    if (it instanceof XtextCallHierarchyNode) {
      return _getText((XtextCallHierarchyNode)it);
    } else if (it instanceof DeferredHierarchyBuilder.DeferredHierarchyNode) {
      return _getText((DeferredHierarchyBuilder.DeferredHierarchyNode)it);
    } else if (it != null) {
      return _getText(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public StyledString getStyledText(final Object it) {
    if (it instanceof XtextCallHierarchyNode) {
      return _getStyledText((XtextCallHierarchyNode)it);
    } else if (it instanceof DeferredHierarchyBuilder.DeferredHierarchyNode) {
      return _getStyledText((DeferredHierarchyBuilder.DeferredHierarchyNode)it);
    } else if (it != null) {
      return _getStyledText(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
