/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package closures;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Client {

	public static CharSequence invokeSubIntf(SubIntf intf) {
		return intf.method("zonk");
	}
	
	public static <T> T invokeIntf(Intf<T> intf) {
		return intf.method(null);
	}
	
	public static <T extends CharSequence> T invokeConstrainedIntf(Intf<T> intf) {
		return intf.method(null);
	}
	
	public static <T extends CharSequence> T invokeParameterizedSubIntf(ParameterizedSubIntf<T> intf) {
		return intf.method(null);
	}
	
	public static String invokeConcreteParameterizedSubIntf(ParameterizedSubIntf<String> intf) {
		return intf.method(null);
	}
	
}
