/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @TODO move to TypeResolutionStateTest
 */
public class TypeResolutionTestData {

	interface NestedList<T> extends List<List<T>> {}

	static <T> List<T> fixedToList(Iterable<T> iter) { return null; }
	static <T> List<T> brokenToList(Iterable<? extends T> iter) { return null; }
	static <T> List<T> brokenToList2(Iterable<? super T> iter) { return null; }
	
}
