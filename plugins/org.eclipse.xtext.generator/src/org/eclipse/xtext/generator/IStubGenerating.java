/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

/**
 * @since 2.4
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IStubGenerating {
	
	boolean isGenerateStub();

	void setGenerateStub(boolean isGenerateStub);
	
	interface XtendOption {
		
		boolean isGenerateXtendStub();

		void setGenerateXtendStub(boolean isGenerateXtendStub);
	}
}
