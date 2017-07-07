/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.internal.HiddenRegionPartMerger;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(HiddenRegionPartMerger.class)
public interface IHiddenRegionPartMerger {

	List<IHiddenRegionPart> merge(ITextRegionAccess base, IHiddenRegion first, IHiddenRegion last, boolean delete);

}
