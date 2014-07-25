/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Accessors
@SuppressWarnings("all")
public abstract class GenericFormatter<T extends EObject> extends AbstractFormatter2 {
  protected void format(final IFormattableDocument document) {
    XtextResource _resource = this.regionAccess.getResource();
    EList<EObject> _contents = _resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    FormatterRequest _request = this.getRequest();
    ITextRegionAccess _textRegionAccess = _request.getTextRegionAccess();
    this.format(((T) _head), _textRegionAccess, document);
  }
  
  protected abstract void format(final T model, final ITextRegionAccess regionAccess, final IFormattableDocument document);
}
