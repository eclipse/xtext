/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.NamedElement;

import com.google.common.annotations.Beta;

/**
 * 
 * @author Sven Efftinge
 *
 * @param <T> - the type
 */
@Beta
public interface RegisterGlobalsParticipant<T extends NamedElement> {
	
	void doRegisterGlobals(List<? extends T> annotatedTargetElements, RegisterGlobalsContext context);
}
