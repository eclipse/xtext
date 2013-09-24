/**
 * 
 */
package org.eclipse.xtext.builder.standalone;

import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Provider;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class XtextResourceSetProvider implements Provider<XtextResourceSet> {

	public XtextResourceSet get() {
		return new XtextResourceSet();
	}

}
