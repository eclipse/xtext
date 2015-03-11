/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package test;

import java.util.List;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SuperClass {

	public String string() {
		return null;
	}

	public String string(String s) {
		return null;
	}

	public Object object() {
		return null;
	}

	public Object object(Object o) {
		return null;
	}

	@SuppressWarnings("unused")
	private String privateMethod() {
		return null;
	}
	
	@SuppressWarnings("unused")
	private static String privateStaticMethod() {
		return null;
	}

	public List<String> returnsListString() {
		return null;
	}

	public List<? extends Object> returnsListExtendsObject() {
		return null;
	}

	public void voidFunction() {
	}
}
