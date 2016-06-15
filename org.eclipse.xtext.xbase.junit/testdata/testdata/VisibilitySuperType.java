/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("unused")
public class VisibilitySuperType {
	private String privateField;
	private void privateMethod(){}
	
	protected String protectedField;
	protected void protectedMethod(){}
	
	public String publicField;
	public void publicMethod(){}
	
	private String getPrivateProperty() {return "";}
	protected String getProtectedProperty() {return "";}
	public String getPublicProperty() {return "";}
	
	private void setPrivateProperty(String x) {}
	protected void setProtectedProperty(String x) {}
	public void setPublicProperty(String x) {}
}
