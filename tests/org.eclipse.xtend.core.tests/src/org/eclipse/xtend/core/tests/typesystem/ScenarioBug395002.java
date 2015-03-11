/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ScenarioBug395002 {

//	public class Bug<A extends SelfBound<?, A>> {
//		public Bug() {
//			new Test<A, SelfBound<?, A>>();
//		}
//	}
	
	interface SelfBound<S extends SelfBound<S, T>, T> {
	}
	
	class Test<X extends SelfBound<? extends Y, ?>, Y> {
	}
	
	<A extends SelfBound<?,A>> void foo3(A arg3) {
        SelfBound<?, A> var3 = arg3;
        @SuppressWarnings("unused")
		SelfBound<? extends SelfBound<?, A>, ?> var4 = var3;
//        SelfBound<? extends SelfBound<?, A>, ?> var5 = arg3;
    }
	
}
