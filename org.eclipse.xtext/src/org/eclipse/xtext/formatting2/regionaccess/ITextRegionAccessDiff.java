/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
