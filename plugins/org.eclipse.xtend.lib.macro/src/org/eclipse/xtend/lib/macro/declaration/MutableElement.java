package org.eclipse.xtend.lib.macro.declaration;

import com.google.common.annotations.Beta;

/**
 * 
 * @author Anton Kosyakov
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableElement extends Element {

	/**
	 * Removes this element from its container and renders it invalid.
	 * @throws IllegalStateException if this element has already been removed or it was not possible to remove
	 */
	public void remove();

}
