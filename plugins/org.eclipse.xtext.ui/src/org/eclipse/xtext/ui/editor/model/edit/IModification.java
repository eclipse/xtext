/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IModification {

	void apply(IModificationContext context) throws Exception;
	
	IModification NULL = new IModification() {
		public void apply(IModificationContext context) {
		}
	};
}
