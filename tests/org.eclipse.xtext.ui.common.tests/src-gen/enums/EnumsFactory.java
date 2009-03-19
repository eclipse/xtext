/**
 * <copyright>
 * </copyright>
 *
 */
package enums;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see enums.EnumsPackage
 * @generated
 */
public interface EnumsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EnumsFactory eINSTANCE = enums.impl.EnumsFactoryImpl.init();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  EnumsPackage getEnumsPackage();

} //EnumsFactory
