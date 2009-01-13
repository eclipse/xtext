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
public interface ICharacterClass {

	boolean matches(char candidate);
	
	public class Factory {
		public static ICharacterClass nullClass() {
			return new ICharacterClass() {
				public boolean matches(char candidate) {
					return false;
				}
			};
		}
		
		public static ICharacterClass create(char... characters) {
			if (characters.length == 1)
				return new SingleCharacter(characters[0]);
			return new CharacterArray(characters);
		}
		
		public static ICharacterClass createRange(char min, char max) {
			return new CharacterRange(min, max);
		}
		
		public static ICharacterClass join(ICharacterClass... classes) {
			return new CharacterAlternatives(classes);
		}
		
		public static ICharacterClass invert(final ICharacterClass clazz) {
			return new ICharacterClass() {
				public boolean matches(char candidate) {
					return !clazz.matches(candidate);
				}
			};
		}
	}
}
