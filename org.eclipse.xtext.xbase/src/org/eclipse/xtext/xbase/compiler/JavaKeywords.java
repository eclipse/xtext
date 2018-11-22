/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import javax.lang.model.SourceVersion;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JavaKeywords {
	public boolean isJavaKeyword(String s) {
		return SourceVersion.isKeyword(s);
	}
}
