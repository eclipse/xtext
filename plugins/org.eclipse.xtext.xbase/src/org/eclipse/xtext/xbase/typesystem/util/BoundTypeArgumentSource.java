/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public enum BoundTypeArgumentSource {
	/**
	 * <pre>
	 *  public <T> void method(List<? extends T> list) {
	 *    List<String> someList = ..
	 *    this.<CharSequence>method(someList);
	 *  }
	 * </pre>
	 */
	EXPLICIT,
	
	/**
	 * <pre>
	 *  public <T extends CharSequence> void method() {
	 *    this.method();
	 *  }
	 * </pre>
	 */
	CONSTRAINT,
	
	/**
	 * <pre>
	 *  CharIterable<E extends CharSequence> extends Iterable<E> {}
	 *  public <T> void method(CharIterable<T>) {
	 *    this.method();
	 *  }
	 * </pre>
	 */
	INFERRED_CONSTRAINT,
	
	/**
	 * <pre>
	 *    public <T> List<T> createList(T... elements) {}
	 *    
	 *    val list = createList() // list<unbound/T>
	 *    list.add('string') // bind T to String
	 * </pre>
	 */
	INFERRED_LATER,
	
	/**
	 * <pre>
	 *  public <T extends CharSequence> T method() {
	 *    String s = method();
	 *  }
	 * </pre>
	 */
	EXPECTATION,
	
	/**
	 * <pre>
	 *  public <T> void method(List<T> list) {
	 *    List<String> someList = ..
	 *    this.method(someList);
	 *  }
	 * </pre>
	 */
	INFERRED
}
