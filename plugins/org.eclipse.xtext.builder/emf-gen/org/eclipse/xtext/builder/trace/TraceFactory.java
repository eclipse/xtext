/**
 */
package org.eclipse.xtext.builder.trace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.builder.trace.TracePackage
 * @generated
 */
public interface TraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TraceFactory eINSTANCE = org.eclipse.xtext.builder.trace.impl.TraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Debug Trace Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Debug Trace Region</em>'.
	 * @generated
	 */
	DebugTraceRegion createDebugTraceRegion();

	/**
	 * Returns a new object of class '<em>Debug Location Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Debug Location Data</em>'.
	 * @generated
	 */
	DebugLocationData createDebugLocationData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TracePackage getTracePackage();

} //TraceFactory
