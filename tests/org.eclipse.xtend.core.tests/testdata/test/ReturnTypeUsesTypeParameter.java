/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package test;

import org.eclipse.xtext.xbase.lib.Procedures;

public interface ReturnTypeUsesTypeParameter {
	<T extends CharSequence> Inner<T> accept(T t);
	
	interface Inner<T extends CharSequence> {
		void useProcedure(Procedures.Procedure1<? super T> proc);
	}
}
