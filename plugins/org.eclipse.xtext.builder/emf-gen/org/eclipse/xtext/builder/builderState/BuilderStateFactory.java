/**
 * <copyright>
 * </copyright>
 *
 * $Id: BuilderStateFactory.java,v 1.6 2009/12/02 16:38:29 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.core.resource.IStorageAwareResourceDescription;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage
 * @generated
 */
public interface BuilderStateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BuilderStateFactory eINSTANCE = org.eclipse.xtext.builder.builderState.impl.BuilderStateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Resource Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Description</em>'.
	 * @generated
	 */
	IStorageAwareResourceDescription createResourceDescription();

	/**
	 * Returns a new object of class '<em>EObject Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject Description</em>'.
	 * @generated
	 */
	IEObjectDescription createEObjectDescription();

	/**
	 * Returns a new object of class '<em>Reference Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Description</em>'.
	 * @generated
	 */
	IReferenceDescription createReferenceDescription();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BuilderStatePackage getBuilderStatePackage();

} //BuilderStateFactory
