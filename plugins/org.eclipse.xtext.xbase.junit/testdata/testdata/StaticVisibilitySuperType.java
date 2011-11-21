/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("unused")
public class StaticVisibilitySuperType {
	static private String privateField;
	static private void privateMethod(){}
	
	static protected String protectedField;
	static protected void protectedMethod(){}
	
	static public String publicField;
	static public void publicMethod(){}
	
	static private String getPrivateProperty() {return "";}
	static protected String getProtectedProperty() {return "";}
	static public String getPublicProperty() {return "";}
	
	static private void setPrivateProperty(String x) {}
	static protected void setProtectedProperty(String x) {}
	static public void setPublicProperty(String x) {}
}
