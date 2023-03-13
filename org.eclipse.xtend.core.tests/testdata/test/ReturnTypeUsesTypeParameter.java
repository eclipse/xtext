/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package test;

import org.eclipse.xtext.xbase.lib.Procedures;

public interface ReturnTypeUsesTypeParameter {
	<T extends CharSequence> Inner<T> accept(T t);
	
	interface Inner<T extends CharSequence> {
		void useProcedure(Procedures.Procedure1<? super T> proc);
	}
}
