/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class ParameterData {

	private List<Pair<String, Boolean>> variants = Lists.newArrayList();
	private boolean sorted = false;
	private String cachedDisplayString;
	
	public String getDisplayString() {
		if (cachedDisplayString == null) {
			sort();
			cachedDisplayString = Joiner.on('\n').join(getRawDisplayString());
		}
		return cachedDisplayString;
	}

	private void sort() {
		if (sorted)
			return;
		Collections.sort(variants, new Comparator<Pair<String, Boolean>>() {
			@Override
			public int compare(Pair<String, Boolean> o1, Pair<String, Boolean> o2) {
				return o1.getFirst().compareTo(o2.getFirst());
			}
		});
		sorted = true;
	}

	public void addOverloaded(String string, boolean varArgs) {
		cachedDisplayString = null;
		sorted = false;
		Pair<String, Boolean> newVariant = Tuples.create(string, varArgs);
		if(!variants.contains(newVariant)) 
			variants.add(newVariant);
	}
	
	public boolean isVarArgs(int variant) {
		return variants.get(variant).getSecond();
	}

	public List<String> getRawDisplayString() {
		sort();
		return Lists.transform(variants, new Function<Pair<String, Boolean>, String>() {
			@Override
			public String apply(Pair<String, Boolean> input) {
				return input.getFirst();
			}
		});
	}

}
