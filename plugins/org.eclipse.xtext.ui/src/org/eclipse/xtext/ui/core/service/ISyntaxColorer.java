/**
 * 
 */
package org.eclipse.xtext.ui.core.service;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.xtext.ui.core.language.ILanguageService;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public interface ISyntaxColorer extends ILanguageService {
	TextAttribute color(int type, Object token);
}
