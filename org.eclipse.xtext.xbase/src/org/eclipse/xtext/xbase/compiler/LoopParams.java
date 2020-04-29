/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public class LoopParams {
	private Function1<? super ITreeAppendable, ? extends ITreeAppendable> prefix;

	private Function1<? super ITreeAppendable, ? extends ITreeAppendable> separator;

	private Function1<? super ITreeAppendable, ? extends ITreeAppendable> suffix;

	public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setPrefix(
			Function1<? super ITreeAppendable, ? extends ITreeAppendable> prefix) {
		return this.prefix = prefix;
	}

	public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setSeparator(
			Function1<? super ITreeAppendable, ? extends ITreeAppendable> separator) {
		return this.separator = separator;
	}

	public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setSuffix(
			Function1<? super ITreeAppendable, ? extends ITreeAppendable> suffix) {
		return this.suffix = suffix;
	}

	public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setPrefix(String prefix) {
		return this.prefix = it -> {
			return it.append(prefix);
		};
	}

	public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setSeparator(String separator) {
		return this.separator = it -> {
			return it.append(separator);
		};
	}

	public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setSuffix(String suffix) {
		return this.suffix = it -> {
			return it.append(suffix);
		};
	}

	public ITreeAppendable appendPrefix(ITreeAppendable app) {
		if (prefix != null) {
			prefix.apply(app);
		}
		return app;
	}

	public ITreeAppendable appendSeparator(ITreeAppendable app) {
		if (separator != null) {
			separator.apply(app);
		}
		return app;
	}

	public ITreeAppendable appendSuffix(ITreeAppendable app) {
		if (suffix != null) {
			suffix.apply(app);
		}
		return app;
	}
}
