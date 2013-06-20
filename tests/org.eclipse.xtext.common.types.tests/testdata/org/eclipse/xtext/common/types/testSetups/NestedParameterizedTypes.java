/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class NestedParameterizedTypes<K, V> extends TestScenario {

	public abstract class WrappedCollection extends AbstractCollection<V> {
		
		public abstract class WrappedIterator implements Iterator<V> {
			
			WrappedIterator() {}
			
			WrappedIterator(@TestAnnotationWithDefaults String s, int i, @TestAnnotation.NestedAnnotation Iterator<V> iterator) {
			}
			
			WrappedIterator(int i, @TestAnnotationWithDefaults String s, int j, @TestAnnotation.NestedAnnotation String s2) {
			}
		}
		
	}
	
}
