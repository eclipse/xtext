/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

public class LinkingType {

	protected String protectedField;
	
	public String publicField;
	
	public void fieldOverloadsMethod() {}
	public void withArgument(Object o) {}
	public void getWithArgument2(Object o) {}
	
	public void withArgument(Object o, int i, int j) {}
	public void getWithArgument2(Object o, int i, int j) {}
	public void fieldOverloadsMethod(int i, int j) {}
	
	protected String getProtectedField() {
		return protectedField;
	}
	public String getPublicField() {
		return publicField;
	}
}
