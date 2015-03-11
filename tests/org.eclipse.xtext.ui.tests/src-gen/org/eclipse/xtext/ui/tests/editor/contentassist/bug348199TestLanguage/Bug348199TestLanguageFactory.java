/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Bug348199TestLanguagePackage
 * @generated
 */
public interface Bug348199TestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug348199TestLanguageFactory eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.Bug348199TestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Timeperiod</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Timeperiod</em>'.
   * @generated
   */
  Timeperiod createTimeperiod();

  /**
   * Returns a new object of class '<em>Time Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Def</em>'.
   * @generated
   */
  TimeDef createTimeDef();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Bug348199TestLanguagePackage getBug348199TestLanguagePackage();

} //Bug348199TestLanguageFactory
