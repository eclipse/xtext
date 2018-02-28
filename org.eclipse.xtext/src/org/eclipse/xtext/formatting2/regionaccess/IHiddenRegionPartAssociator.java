/*******************************************************************************
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import java.util.function.BiConsumer;

import org.eclipse.xtext.formatting2.regionaccess.internal.HiddenRegionPartAssociator;

import com.google.inject.ImplementedBy;

/**
 * Implement this interface to customize the return values of {@link IHiddenRegionPart#getAssociation()}.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @since 2.14
 */
@ImplementedBy(HiddenRegionPartAssociator.class)
public interface IHiddenRegionPartAssociator {

	void associate(IHiddenRegion region, BiConsumer<IHiddenRegionPart, HiddenRegionPartAssociation> handler);

}
