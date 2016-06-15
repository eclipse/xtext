/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public enum TestEnum {

	FirstValue("Zonk") {
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	},
	SecondValue("Bla");
	
	String string;
	
	TestEnum(String string) {
		this.string = string;
	}
	
	public enum Nested {
		SINGLETON {};
	}

}

