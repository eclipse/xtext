/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class HoverContext {
  private final Document document;
  
  private final XtextResource resource;
  
  private final int offset;
  
  private final ITextRegion region;
  
  private final EObject element;
  
  public HoverContext(final Document document, final XtextResource resource, final int offset, final ITextRegion region, final EObject element) {
    super();
    this.document = document;
    this.resource = resource;
    this.offset = offset;
    this.region = region;
    this.element = element;
  }
  
  @Pure
  public Document getDocument() {
    return this.document;
  }
  
  @Pure
  public XtextResource getResource() {
    return this.resource;
  }
  
  @Pure
  public int getOffset() {
    return this.offset;
  }
  
  @Pure
  public ITextRegion getRegion() {
    return this.region;
  }
  
  @Pure
  public EObject getElement() {
    return this.element;
  }
}
