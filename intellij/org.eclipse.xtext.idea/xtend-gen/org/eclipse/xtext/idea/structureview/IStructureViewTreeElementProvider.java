/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.structureview;

import com.google.inject.ImplementedBy;
import com.intellij.ide.structureView.StructureViewTreeElement;
import org.eclipse.xtext.idea.structureview.DefaultStructureViewTreeElementProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@ImplementedBy(DefaultStructureViewTreeElementProvider.class)
@SuppressWarnings("all")
public interface IStructureViewTreeElementProvider {
  public abstract void buildChildren(final StructureViewTreeElement structureViewTreeElement);
}
