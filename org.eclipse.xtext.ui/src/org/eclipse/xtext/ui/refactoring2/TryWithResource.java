/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2;

import java.io.Closeable;
import java.util.function.Supplier;

import org.apache.log4j.Logger;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 * @deprecated Use the Java {@code try}-with-resources statement
 */
@Deprecated
public class TryWithResource {

	private static final Logger LOG = Logger.getLogger(TryWithResource.class);

	public static <T extends Object> T tryWith(Closeable closeable, Supplier<? extends T> action) {
		try {
			return action.get();
		} finally {
			try {
				closeable.close();
			} catch (Throwable t) {
				LOG.error("Error closing stream", t);
			}
		}
	}

	public static void tryWith(Closeable closeable, Procedure0 action) {
		try {
			action.apply();
		} finally {
			try {
				closeable.close();
			} catch (Throwable t) {
				LOG.error("Error closing stream", t);
			}
		}
	}
}
