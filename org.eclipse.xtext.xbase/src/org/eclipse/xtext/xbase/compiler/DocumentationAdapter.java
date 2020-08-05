/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DocumentationAdapter extends AdapterImpl {

	private String documentation;
	
	/**
	 * @since 2.23
	 */
	public DocumentationAdapter(String documentation) {
		this.documentation = documentation;
	}
	
	public DocumentationAdapter() {
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == DocumentationAdapter.class;
	}
}
