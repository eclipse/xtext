package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;

/**
 * A wrapper for EObjects holding the information about what values have already
 * been consumed by a serialization process.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 */
public interface IInstanceDescription {

	/**
	 * @param the
	 *            type name as it is used within the grammar of the given
	 *            language
	 * @return true if the delegate is a direct instance of the given type
	 */
	public abstract boolean isInstanceOf(String string);

	/**
	 * @return the wrapped EObject
	 */
	public abstract EObject getDelegate();
	
	public Object getConsumable(String feature, boolean allowDefault);
	
	public IInstanceDescription cloneAndConsume(String feature);
	
	public boolean isConsumedWithLastConsumtion(String feature);
}