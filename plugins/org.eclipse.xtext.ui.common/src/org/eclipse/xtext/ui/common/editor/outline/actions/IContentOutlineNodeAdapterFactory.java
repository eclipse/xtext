/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.actions;

import org.eclipse.core.runtime.IAdapterFactory;

import com.google.inject.ImplementedBy;

/**
 * @author Peter Friese - Initial contribution and API
 */
@ImplementedBy(value = DefaultContentOutlineNodeAdapterFactory.class)
public interface IContentOutlineNodeAdapterFactory extends IAdapterFactory {

}
