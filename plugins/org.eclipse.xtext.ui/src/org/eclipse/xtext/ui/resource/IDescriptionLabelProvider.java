/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.jface.viewers.ILabelProvider;

import com.google.inject.ImplementedBy;


/**
 * Provides an image and a human readable display text from an {@link IEObjectDescription}.
 *  
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultDescriptionLabelProvider.class)
public interface IDescriptionLabelProvider extends ILabelProvider {

}
