/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IPreferenceValues {

	/**
	 * @return the currently active value for the given preference
	 */
	String getPreference(PreferenceKey key);
	
}
