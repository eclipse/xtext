/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Iterables;

/**
 * @author Jan Koehnlein
 */
public class LoopExtensions {
	/**
	 * Iterates elements and execute the procedure. A prefix, a separator and a
	 * suffix can be initialized with the loopInitializer lambda.
	 */
	public <T> void forEach(ITreeAppendable appendable, Iterable<T> elements,
			Procedure1<? super LoopParams> loopInitializer, Procedure1<? super T> procedure) {
		if (Iterables.isEmpty(elements)) {
			return;
		}
		LoopParams params = new LoopParams();
		loopInitializer.apply(params);
		params.appendPrefix(appendable);
		procedure.apply(Iterables.getFirst(elements, null));
		IterableExtensions.tail(elements).forEach((T it) -> {
			params.appendSeparator(appendable);
			procedure.apply(it);
		});
		params.appendSuffix(appendable);
	}

	/**
	 * Uses curly braces and comma as delimiters. Doesn't use them for single
	 * valued iterables.
	 */
	public <T> void forEachWithShortcut(ITreeAppendable appendable, Iterable<T> elements,
			Procedure1<? super T> procedure) {
		if (IterableExtensions.size(elements) == 1) {
			procedure.apply(Iterables.getFirst(elements, null));
		} else {
			appendable.append("{");
			forEach(appendable, elements, (LoopParams it) -> {
				it.setPrefix(" ");
				it.setSeparator(", ");
				it.setSuffix(" ");
			}, procedure);
			appendable.append("}");
		}
	}
}
