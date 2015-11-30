/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public abstract class GenericFormatter<T extends EObject> extends AbstractFormatter2 {
  @Override
  protected void _format(final EObject obj, final IFormattableDocument document) {
    FormatterRequest _request = this.getRequest();
    ITextRegionAccess _textRegionAccess = _request.getTextRegionAccess();
    ITextRegionExtensions _extensions = _textRegionAccess.getExtensions();
    this.format(((T) obj), _extensions, document);
  }
  
  protected abstract void format(final T model, final ITextRegionExtensions regionAccess, final IFormattableDocument document);
  
  public void format(final Object obj, final IFormattableDocument document) {
    if (obj instanceof XtextResource) {
      _format((XtextResource)obj, document);
      return;
    } else if (obj instanceof EObject) {
      _format((EObject)obj, document);
      return;
    } else if (obj == null) {
      _format((Void)null, document);
      return;
    } else if (obj != null) {
      _format(obj, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(obj, document).toString());
    }
  }
}
