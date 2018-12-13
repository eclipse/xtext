/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package extract;

import extract.Extract;
import extract.ExtractExampleInterface;

@Extract
@SuppressWarnings("all")
public class ExtractExample implements ExtractExampleInterface {
  /**
   * This method is extracted to an interface
   */
  @Override
  public void myPublicMethod() {
  }
  
  /**
   * This method is not extracted
   */
  protected void myPrivateMethod() {
  }
}
