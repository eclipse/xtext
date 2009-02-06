/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.xtend.crossref.AbstractXtendScopeProvider;

/**
 * An {@link IScopeProvider} that calls Xtend extensions.
 */
public class XtendTreeTestLanguageScopeProvider extends AbstractXtendScopeProvider {

	@Override
	protected ClassLoader getClassLoader() {
		return this.getClass().getClassLoader();
	}

	@Override
	protected String getMasterXtendFileName() {
		return "org::eclipse::xtext::testlanguages::TreeTestLanguageScopeProvider";	
	}
	
}
