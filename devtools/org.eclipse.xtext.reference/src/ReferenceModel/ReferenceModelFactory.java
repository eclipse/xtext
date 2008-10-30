/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferenceModelFactory.java,v 1.1 2008/10/30 21:37:04 mclay Exp $
 */
package ReferenceModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ReferenceModel.ReferenceModelPackage
 * @generated
 */
public interface ReferenceModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReferenceModelFactory eINSTANCE = ReferenceModel.impl.ReferenceModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Custom Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Type</em>'.
	 * @generated
	 */
	CustomType createCustomType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ReferenceModelPackage getReferenceModelPackage();

} //ReferenceModelFactory
