/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
@SuppressWarnings("unused")
public class MethodOverrides3<V extends Iterable<String>> {
	public <T extends CharSequence> String m1(T t) {
		return "m1(t)";
	}

	public <T extends Iterable<CharSequence>> String m2(T t) {
		return "m2(t)";
	}
	
	public <T extends CharSequence> String m3(T t) {
		return "m3(t)";
	}

	public <T extends Iterable<CharSequence>> String m4(T t) {
		return "m4(t)";
	}
	
	public String m5(V v) {
		return "m5(t)";
	}
	
}
