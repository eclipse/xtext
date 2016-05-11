/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.navigation;

/**
 * Represents an instance that can be opened in an editor.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public interface INavigatable {
  /**
   * <p>
   * Returns an instance containing enough information to identify an editor that should be opened and a region that should be revealed.
   * </p>
   * <p>
   * Typical navigation elements are resource, object and reference descriptions as well as another navigatable element.
   * </p>
   * <p>
   * Avoid usage of resource sets, resources and eobjects as navigation elements, since it can lead to memory leaks.
   * </p>
   */
  public abstract Object getNavigationElement();
}
