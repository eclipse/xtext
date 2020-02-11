/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.Iterators;


/**
 * Utility that calculates possible inner class names separated with a '.' given
 * a name containing '$' at places where outer and inner class may be separated
 * 
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.11
 */
public class InnerClassNameVariants {

	public Iterator<String> variantsFor(final String base) {
		//if (1==1) return Lists.newArrayList(base).iterator();
		// System.out.println("xxxxxx yyyy " + base);
		int[] positionsOfDollar = getPositionsOfDollar(base);
		if (positionsOfDollar.length == 0) {
			return Iterators.singletonIterator(base);
		}

		int numberPositionsOfDollar = positionsOfDollar.length;
		int numberOfCombinations = (int) Math.pow(2, numberPositionsOfDollar);
		/*
		 * turns the given value to a int[] binary representation
		 * 
		 * 0 -> [0,0,0] 1 -> [1,0,0 7 -> [1,1,1]
		 */
		IntFunction<int[]> shouldElementAtPositionBeReplaced = new IntFunction<int[]>() {

			@Override
			public int[] apply(final int value) {
				int[] shouldElementBeReplaced = new int[numberPositionsOfDollar];
				int valueCopy = value;

				for (int c = 0; c < shouldElementBeReplaced.length; c++) {
					if (valueCopy % 2 == 1) {
						shouldElementBeReplaced[c] = 1;
					}
					valueCopy = valueCopy / 2;
				}
				return shouldElementBeReplaced;
			}
		};
		/*
		 * takes the given positon array to decide if a positon shall be
		 * replaced or not [0,1,0] => replace the second occurrence of '$' only
		 */
		Function<int[], String> replaceAtPositions = new Function<int[], String>() {

			@Override
			public String apply(int[] shouldElementBeReplaced) {
				StringBuilder baseAsBuilder = new StringBuilder(base);

				for (int position = 0; position < shouldElementBeReplaced.length; position++) {
					int p = shouldElementBeReplaced[position];
					if (p > 0) {
						baseAsBuilder.setCharAt(positionsOfDollar[position], '.');
					}
				}

				return baseAsBuilder.toString();
			}
		};

		Stream<String> resultStream = IntStream.range(0, numberOfCombinations)
				.mapToObj(shouldElementAtPositionBeReplaced).map(replaceAtPositions);
		return resultStream.iterator();
	}

	private int[] getPositionsOfDollar(final String base) {
		int start = base.lastIndexOf('.');
		if (start < 0) {
			start = 0;
		}
		StringBuilder baseAsBuilder = new StringBuilder(base);
		return IntStream.range(start, baseAsBuilder.length()).filter((int i) -> baseAsBuilder.charAt(i) == '$')
				.toArray();
	}

}
