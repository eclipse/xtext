/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JavaKeywords {
	public boolean isJavaKeyword(String s) {
		return JAVA_KEYWORDS.contains(s);
	}
	
	private final static Set<String> JAVA_KEYWORDS= Sets.newHashSet(
			"abstract" ,
	        "assert" , // added in 1.4
	        "boolean" ,
	        "break" ,
	        "byte" ,
	        "case" ,
	        "catch" ,
	        "char" ,
	        "class" ,
	        "const" , // not used
	        "continue" ,
	        "default" ,
	        "do" ,
	        "double" ,
	        "else" ,
	        "enum" , // added in 5.0
	        "extends" ,
	        "false" ,
	        "final" ,
	        "finally" ,
	        "float" ,
	        "for" ,
	        "goto" , // not used
	        "if" ,
	        "implements" ,
	        "import" ,
	        "instanceof" ,
	        "int" ,
	        "interface" ,
	        "long" ,
	        "native" ,
	        "new" ,
	        "null" ,
	        "package" ,
	        "private" ,
	        "protected" ,
	        "public" ,
	        "return" ,
	        "short" ,
	        "static" ,
	        "strictfp" , // added in 1.2
	        "super" ,
	        "switch" ,
	        "synchronized" ,
	        "this" ,
	        "throw" ,
	        "throws" ,
	        "transient" ,
	        "true" ,
	        "try" ,
	        "void" ,
	        "volatile" ,
	        "while");
}
