/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.core.runtime.IAdapterFactory;

import com.google.inject.ImplementedBy;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Jan Köhnlein - deprecation
 * @deprecation Instances are registered globally by the
 *              {@link org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage} 
 *              to adapt IContentOutlineNode thus yielding collisions with other
 *              Xtext languages. 
 *              Clients should rather implement 
 *              {@link org.eclipse.core.runtime.IAdaptable#getAdapter(Class)} in their
 *              own {@link org.eclipse.xtext.ui.editor.outline.IContentOutlineNode}. 
 *              See also https://bugs.eclipse.org/bugs/show_bug.cgi?id=319966
 */
@Deprecated
@ImplementedBy(value = DefaultContentOutlineNodeAdapterFactory.class)
public interface IContentOutlineNodeAdapterFactory extends IAdapterFactory {

}
