/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.model;

import org.eclipse.xtext.resource.XtextResource;

/**
 * Interface for accessing a document. Depending on the access type, some methods may not be supported.
 */
public interface IXtextWebDocument {
  XtextResource getResource();
  
  String getResourceId();
  
  String getText();
  
  String getStateId();
  
  boolean isDirty();
  
  void setText(String text);
  
  void createNewStateId();
  
  void updateText(String text, int offset, int replaceLength);
  
  void setDirty(boolean dirty);
}
