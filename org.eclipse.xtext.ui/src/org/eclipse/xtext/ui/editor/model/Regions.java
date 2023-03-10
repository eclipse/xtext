/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;

import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Regions {
	/**
	 * Returns a predicate  which returns <code>true</code> if the passed range and the region passed to the predicate overlap. Returns <code>false</code> if one of the
	 * arguments is <code>null</code>. Based on {@link TextUtilities#overlaps(IRegion, IRegion)}
	 *
	 * @param  offset range offset
	 * @param  length range length
	 * @return the predicate
	 */
	public static Predicate<? super IRegion> overlaps(final int offset, final int length) {
		return overlaps(new Region(offset,length));
	}
	
	/**
	 * Returns a predicate  which returns <code>true</code> if the passed region and the one passed to the predicate overlap. Returns <code>false</code> if one of the
	 * arguments is <code>null</code>. Based on {@link TextUtilities#overlaps(IRegion, IRegion)}
	 *
	 * @param region to work with
	 * @return the predicate
	 */
	public static Predicate<? super IRegion> overlaps(final IRegion region) {
		return new Predicate<IRegion>() {
			@Override
			public boolean apply(IRegion input) {
				return TextUtilities.overlaps(region, input);
			}
		};
	}
	
}
