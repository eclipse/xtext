/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 */
@Beta
public interface ActiveAnnotationProcessor {
	
	public interface Context {
		Iterable<?> getAnnotatedElements();
		
	}

	public interface TypeAcceptor {
		void acceptInterface(String name);
		void acceptEnum(String name);
		void acceptAnnotationType(String name);
		void acceptClass(String name);
	}

	public void registerTypes(TypeAcceptor acceptor);
	
	public void process(Context ctx);
}
