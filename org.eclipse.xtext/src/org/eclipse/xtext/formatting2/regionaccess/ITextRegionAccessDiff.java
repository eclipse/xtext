/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import java.util.List;

/**
 * A {@link ITextRegionAccess} that has been created by modifying another ITextRegionAccess.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.13
 */
public interface ITextRegionAccessDiff extends ITextRegionAccess {

	/**
	 * Retrieve the {@link ITextRegionAccess} from which this ITextRegionAccessDiff has been derived.
	 */
	ITextRegionAccess getOriginalTextRegionAccess();

	/**
	 * Retrieve all differences between this ITextRegionAccess and the one returned by
	 * {@link #getOriginalTextRegionAccess()}.
	 */
	List<ITextSegmentDiff> getRegionDifferences();

}
