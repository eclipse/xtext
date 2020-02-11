/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.query;

import org.eclipse.emf.common.util.URI;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
@ImplementedBy(IJavaSearchParticipation.Yes.class)
public interface IJavaSearchParticipation {
	
	boolean canContainJvmReferences(URI uri);
	
	class Yes implements IJavaSearchParticipation {
		@Override
		public boolean canContainJvmReferences(URI uri) {
			return true;
		}
	}

	class No implements IJavaSearchParticipation {
		@Override
		public boolean canContainJvmReferences(URI uri) {
			return false;
		}
	}
}
