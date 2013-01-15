/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package foo;

/**
 * Example taken from JEP 101: Generalized Target-Type Inference
 * (http://openjdk.java.net/jeps/101)
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JEP101List<E> {

	public static <Z> JEP101List<Z> nil() {
		return null;
	}

	public static <Z> JEP101List<Z> cons(Z head, JEP101List<Z> tail) {
		return null;
	}

	public E head() {
		return null;
	}

}
