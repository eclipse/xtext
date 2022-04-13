/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractAnnotationBuilder extends AbstractCodeBuilder {
  @Accessors
  private String annotationName;

  @Override
  public String getImage() {
    return "newannotation_wiz.gif";
  }

  @Pure
  public String getAnnotationName() {
    return this.annotationName;
  }

  public void setAnnotationName(final String annotationName) {
    this.annotationName = annotationName;
  }
}
