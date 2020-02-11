/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * Convenient access to language specific information.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@Singleton
public class LanguageInfo {

	private final String languageName;
	
	/**
	 * @param languageName the language name. May not be <code>null</code>.
	 */
	@Inject
	public LanguageInfo(@Named(Constants.LANGUAGE_NAME) String languageName) {
		if (languageName == null)
			throw new IllegalArgumentException("languageName may not be null");
		this.languageName = languageName;
	}

	/**
	 * @return the language name. Never <code>null</code>.
	 */
	public String getLanguageName() {
		return languageName;
	}
	
	public String getShortName() {
		int lastIndex = languageName.lastIndexOf('.');
		if (lastIndex == -1)
			return getLanguageName();
		return getLanguageName().substring(lastIndex+1);
	}
	
	/**
	 * @since 2.8
	 */
	public boolean isLanguage(Resource resource) {
		if (resource instanceof XtextResource) {
			return languageName.equals(((XtextResource) resource).getLanguageName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return languageName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LanguageInfo other = (LanguageInfo) obj;
		if (!languageName.equals(other.languageName))
			return false;
		return true;
	}
	
}
