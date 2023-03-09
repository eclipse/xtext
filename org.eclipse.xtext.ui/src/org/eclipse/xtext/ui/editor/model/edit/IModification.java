/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IModification {

	void apply(IModificationContext context) throws Exception;
	
	IModification NULL = new IModification() {
		@Override
		public void apply(IModificationContext context) {
		}
	};
}
