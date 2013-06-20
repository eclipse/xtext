/**
 * 
 */
package org.eclipse.xtext.pom.modifier;

import org.apache.maven.model.Model;

/**
 * @author huebner
 * 
 */
public interface ModelModifier {

	/**
	 * @param pomModel
	 *            Pom
	 * @return <code>true</code> if something changed
	 */
	boolean modifiy(Model pomModel);

}
