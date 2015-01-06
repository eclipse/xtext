/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.common.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public interface IXtendOutlineTreeBuilder {
  public abstract void build(final EObject modelElement, final IXtendOutlineContext context);
}
