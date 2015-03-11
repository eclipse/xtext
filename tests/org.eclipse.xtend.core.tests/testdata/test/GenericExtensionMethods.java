/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package test;

import static com.google.common.collect.Lists.*;

import java.util.List;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class GenericExtensionMethods<A extends CharSequence,B> {
	
	private List<String> result = newArrayList();
	
	public void method(A b) {
		result.add("method(A)");
	}
	
	public void method(B b) {
		result.add("method(B)");
	}
	
	public List<String> getResult() {
		return result;
	}
	
}
