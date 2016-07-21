/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.hover;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.typefox.lsapi.Hover;
import io.typefox.lsapi.HoverImpl;
import io.typefox.lsapi.MarkedStringImpl;
import io.typefox.lsapi.RangeImpl;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class HoverService {
  @Inject
  @Extension
  private DocumentExtensions _documentExtensions;
  
  @Inject
  @Extension
  private EObjectAtOffsetHelper _eObjectAtOffsetHelper;
  
  @Inject
  @Extension
  private ILocationInFileProvider _iLocationInFileProvider;
  
  @Inject
  @Extension
  private IEObjectDocumentationProvider _iEObjectDocumentationProvider;
  
  public Hover hover(final XtextResource resource, final int offset) {
    final EObject element = this._eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    if ((element == null)) {
      List<MarkedStringImpl> _emptyList = CollectionLiterals.<MarkedStringImpl>emptyList();
      return new HoverImpl(_emptyList, null);
    }
    final String documentation = this._iEObjectDocumentationProvider.getDocumentation(element);
    if ((documentation == null)) {
      List<MarkedStringImpl> _emptyList_1 = CollectionLiterals.<MarkedStringImpl>emptyList();
      return new HoverImpl(_emptyList_1, null);
    }
    MarkedStringImpl _markedStringImpl = new MarkedStringImpl(null, documentation);
    final List<MarkedStringImpl> contents = Collections.<MarkedStringImpl>unmodifiableList(CollectionLiterals.<MarkedStringImpl>newArrayList(_markedStringImpl));
    final EObject containedElement = this._eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
    final ITextRegion textRegion = this._iLocationInFileProvider.getSignificantTextRegion(containedElement);
    if ((textRegion == null)) {
      return new HoverImpl(contents, null);
    }
    boolean _contains = textRegion.contains(offset);
    boolean _not = (!_contains);
    if (_not) {
      List<MarkedStringImpl> _emptyList_2 = CollectionLiterals.<MarkedStringImpl>emptyList();
      return new HoverImpl(_emptyList_2, null);
    }
    final RangeImpl range = this._documentExtensions.newRange(resource, textRegion);
    return new HoverImpl(contents, range);
  }
}
