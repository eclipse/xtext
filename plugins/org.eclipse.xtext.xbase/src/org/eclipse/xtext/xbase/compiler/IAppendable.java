/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IAppendable {

	IAppendable append(String string);

	IAppendable append(JvmType type);

	IAppendable increaseIndentation();

	IAppendable decreaseIndentation();
	
	List<String> getImports();

	void openScope();

	String declareVariable(Object key, String proposedName);

	String getName(Object key);
	
	Object getObject(String name);

	void closeScope();

}
