/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class ParameterizedMethods extends TestScenario {
	
	abstract <T> void twoListParamsNoResult(List<T> first, List<T> second);
	
	abstract void twoListWildcardsNoResult(List<?> first, List<?> second);
	
	abstract <T> List<T> twoListParamsListResult(List<T> first, List<T> second);
	
	abstract List<?> twoListWildcardsListResult(List<?> first, List<?> second);
	
	abstract void arrayWildcard(List<?>[] array);
	
	abstract <T> void arrayParameterized(List<T>[] array);
	
	abstract <T extends List<?>> void arrayVariable(T[] array);

	abstract void nestedArrayWildcard(List<?>[][] array);
	
	abstract <T> void nestedArrayParameterized(List<T>[][] array);
	
	abstract <T extends List<?>> void nestedArrayVariable(T[][] array);

}
