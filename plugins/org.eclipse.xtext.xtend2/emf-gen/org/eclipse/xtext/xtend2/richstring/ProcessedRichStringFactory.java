/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.richstring;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtend2.richstring.ProcessedRichStringPackage
 * @generated
 */
public interface ProcessedRichStringFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProcessedRichStringFactory eINSTANCE = org.eclipse.xtext.xtend2.richstring.impl.ProcessedRichStringFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Processed Rich String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processed Rich String</em>'.
	 * @generated
	 */
	ProcessedRichString createProcessedRichString();

	/**
	 * Returns a new object of class '<em>Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line</em>'.
	 * @generated
	 */
	Line createLine();

	/**
	 * Returns a new object of class '<em>Line Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Part</em>'.
	 * @generated
	 */
	LinePart createLinePart();

	/**
	 * Returns a new object of class '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal</em>'.
	 * @generated
	 */
	Literal createLiteral();

	/**
	 * Returns a new object of class '<em>Line Break</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Break</em>'.
	 * @generated
	 */
	LineBreak createLineBreak();

	/**
	 * Returns a new object of class '<em>For Loop Start</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Loop Start</em>'.
	 * @generated
	 */
	ForLoopStart createForLoopStart();

	/**
	 * Returns a new object of class '<em>For Loop End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Loop End</em>'.
	 * @generated
	 */
	ForLoopEnd createForLoopEnd();

	/**
	 * Returns a new object of class '<em>Printed Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Printed Expression</em>'.
	 * @generated
	 */
	PrintedExpression createPrintedExpression();

	/**
	 * Returns a new object of class '<em>If Condition Start</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Condition Start</em>'.
	 * @generated
	 */
	IfConditionStart createIfConditionStart();

	/**
	 * Returns a new object of class '<em>Else If Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Else If Condition</em>'.
	 * @generated
	 */
	ElseIfCondition createElseIfCondition();

	/**
	 * Returns a new object of class '<em>Else Start</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Else Start</em>'.
	 * @generated
	 */
	ElseStart createElseStart();

	/**
	 * Returns a new object of class '<em>End If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End If</em>'.
	 * @generated
	 */
	EndIf createEndIf();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProcessedRichStringPackage getProcessedRichStringPackage();

} //ProcessedRichStringFactory
