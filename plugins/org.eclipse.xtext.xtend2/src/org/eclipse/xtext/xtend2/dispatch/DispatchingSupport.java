/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.dispatch;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DispatchingSupport {

	@Inject
	private FeatureOverridesService overridesService;

	@Inject
	private TypeReferences typeRefs;

	@Inject
	private TypeConformanceComputer conformanceComputer;

	public Multimap<Pair<String, Integer>, JvmOperation> getDispatchMethods(JvmGenericType type) {
		Multimap<Pair<String, Integer>, JvmOperation> result = HashMultimap.create();
		collectDispatchMethods(type, result);
		return result;
	}

	protected void collectDispatchMethods(JvmGenericType type, Multimap<Pair<String, Integer>, JvmOperation> result) {
		Iterable<JvmOperation> features = filter(overridesService.getAllJvmFeatures(typeRefs.createTypeRef(type)),
				JvmOperation.class);
		for (JvmOperation operation : features) {
			if (isDispatchOperation(operation)) {
				final Pair<String, Integer> signatureTuple = Tuples.create(operation.getSimpleName().substring(1),
						operation.getParameters().size());
				result.put(signatureTuple, operation);
			}
		}
	}

	protected boolean isDispatchOperation(JvmOperation operation) {
		return !operation.getParameters().isEmpty() && !operation.isStatic()
				&& operation.getSimpleName().startsWith("_");
	}

	public List<JvmOperation> sort(Collection<JvmOperation> collection) {
		List<JvmOperation> list = newArrayList(collection);
		Collections.sort(list, new Comparator<JvmOperation>() {
			public int compare(JvmOperation o1, JvmOperation o2) {
				return o1.getParameters().toString().compareTo(o2.getParameters().toString());
			}
		});
		int numberOfOps = collection.size();
		CompareResult[][] matrix = new CompareResult[numberOfOps][numberOfOps];
		for (int i = 0; i < numberOfOps; i++) {
			JvmOperation left = list.get(i);
			matrix[i][i] = CompareResult.SAME;
			for (int j = i+1; j < numberOfOps; j++) {
				JvmOperation right = list.get(j);
				CompareResult compare = internalCompare(left, right);
				if (compare == CompareResult.UNRELATED) {
					matrix[i][j] = compare;
					matrix[j][i] = compare;
				} else if (compare == CompareResult.LESS_SPECIFIC) {
					matrix[i][j] = CompareResult.LESS_SPECIFIC;
					matrix[j][i] = CompareResult.MORE_SPECIFIC;
				} else if (compare == CompareResult.MORE_SPECIFIC) {
					matrix[i][j] = CompareResult.MORE_SPECIFIC;
					matrix[j][i] = CompareResult.LESS_SPECIFIC;
				} else {
					throw new IllegalArgumentException();
				}
			}
		}
		List<JvmOperation> result = newArrayList();
		boolean matched[] = new boolean[numberOfOps];
		for (int i=0;i<numberOfOps;i++) {
			int number = findMostSpecific(matrix, matched);
			matched[number] = true;
			result.add(list.get(number));
		}
		return result;
	}

	protected int findMostSpecific(CompareResult[][] matrix, boolean[] alreadyMatched) {
		for (int i = 0; i < matrix.length; i++) {
			if (!alreadyMatched[i]) {
				return findMostSpecific(i, matrix, alreadyMatched);
			}
		}
		return 0;
	}

	protected int findMostSpecific(int toCheck, CompareResult[][] matrix, boolean[] alreadyMatched) {
		CompareResult[] compareResults = matrix[toCheck];
		for (int i = 0; i < compareResults.length; i++) {
			if (!alreadyMatched[i]) {
				CompareResult c = compareResults[i];
				if (c == CompareResult.LESS_SPECIFIC) {
					return findMostSpecific(i, matrix,alreadyMatched);
				}
			}
		}
		return toCheck;
	}

	protected CompareResult internalCompare(JvmOperation o1, JvmOperation o2) {
		int params = o1.getParameters().size();
		for (int i = 0; i < params; i++) {
			final JvmTypeReference p1 = o1.getParameters().get(i).getParameterType();
			final JvmTypeReference p2 = o2.getParameters().get(i).getParameterType();
			boolean rightToLeft = conformanceComputer.isConformant(p1, p2, true);
			boolean leftToRight = conformanceComputer.isConformant(p2, p1, true);
			if (leftToRight && !rightToLeft)
				return CompareResult.MORE_SPECIFIC;
			if (rightToLeft && !leftToRight)
				return CompareResult.LESS_SPECIFIC;
			if (!rightToLeft && !leftToRight)
				return CompareResult.UNRELATED;
		}
		return CompareResult.SAME;
	}

	protected static enum CompareResult {
		SAME, UNRELATED, MORE_SPECIFIC, LESS_SPECIFIC
	}

}
