/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.matching;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SingleCharacter implements ICharacterClass {

	private char c;

	public SingleCharacter(char c) {
		this.c = c;
	}
	
	public boolean matches(char candidate) {
		return candidate == c;
	}

	@Override
	public String toString() {
		return "'" + Character.toString(c) + "'";
	}
	
	

}
