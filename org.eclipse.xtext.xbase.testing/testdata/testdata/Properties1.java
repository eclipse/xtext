/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Properties1 {
	public String prop1;
	private String prop2;
	
	public String getProp1() {
		return prop1;
	}
	
	public String getProp2() {
		return prop2;
	}
	
	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
	
	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}
	
	public void setProp2(int i) {
		setProp2("Integer: " + Integer.toString(i));
	}
	
	public String getProp3() {
		return prop2;
	}
	
	public String setProp3(int i) {
		setProp2("Integer: " + Integer.toString(i));
		return prop2;
	}
}
