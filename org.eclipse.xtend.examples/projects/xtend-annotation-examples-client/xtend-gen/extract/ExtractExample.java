/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package extract;

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
