/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class ParameterizedTypes {

	abstract <T> void twoListParamsNoResult(List<T> first, List<T> second);
	
	void twoListWildcardsNoResult(List<?> first, List<?> second) {
		first = second;
	}
	
	abstract <T> List<T> twoListParamsListResult(List<T> first, List<T> second);
	
	List<?> twoListWildcardsListResult(List<?> first, List<?> second) {
		first = second;
		return second;
	}
	
	abstract void arrayWildcard(List<?>[] array);
	
	abstract <T> void arrayParameterized(List<T>[] array);
	
	abstract <T extends List<?>> void arrayVariable(T[] array);

	abstract void nestedArrayWildcard(List<?>[][] array);
	
	abstract <T> void nestedArrayParameterized(List<T>[][] array);
	
	abstract <T extends List<?>> void nestedArrayVariable(T[][] array);

}
