/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.formatting2.internal.GenericFormatter;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class GenericFormatterTestRequest extends FormatterTestRequest {
  @Accessors
  private GenericFormatter<? extends EObject> formatter;
  
  @Pure
  public GenericFormatter<? extends EObject> getFormatter() {
    return this.formatter;
  }
  
  public void setFormatter(final GenericFormatter<? extends EObject> formatter) {
    this.formatter = formatter;
  }
}
