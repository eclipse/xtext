package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;

/**
 * A wrapper for EObjects holding the information about what values have already
 * been consumed by a serialization process.
 * 
 * @author Sven Efftinge - Initial contribution and API
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
	 * @param the
	 *            type name as it is used within the grammar of the given
	 *            language
	 * @return true if the delegate's type is assignable to the given type
	 */
	public abstract boolean isOfType(String string);

	/**
	 * @return the wrapped EObject
	 */
	public abstract EObject getDelegate();

	/**
	 * returns the last consumed value in the given feature
	 * 
	 * @param feature
	 * @return the consumed value
	 */
	public abstract Object get(String feature);

	/**
	 * 
	 * @param feature
	 * @return whether there are any consumable values for the given feature
	 */
	public abstract boolean isConsumable(String feature);

	/**
	 * 
	 * @return whether all values referenced by the delegate have been consumed
	 */
	public abstract boolean isConsumed();

	/**
	 * @param feature
	 * @return the number of values already consumed for this feature
	 */
	public abstract int getConsumed(String feature);

}