/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.validation;

import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
@Singleton
public class MarkerTypeProvider {

	public String getMarkerType(Issue issue) {
		return MarkerTypes.forCheckType(issue.getType());
	}

	public CheckType getCheckType(String markerType) {
		return MarkerTypes.toCheckType(markerType);
	}

}
