/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.richstring;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Loop End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.richstring.ForLoopEnd#getStart <em>Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtend2.richstring.ProcessedRichStringPackage#getForLoopEnd()
 * @model
 * @generated
 */
public interface ForLoopEnd extends LinePart
{
	/**
	 * Returns the value of the '<em><b>Start</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.xtend2.richstring.ForLoopStart#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' reference.
	 * @see #setStart(ForLoopStart)
	 * @see org.eclipse.xtext.xtend2.richstring.ProcessedRichStringPackage#getForLoopEnd_Start()
	 * @see org.eclipse.xtext.xtend2.richstring.ForLoopStart#getEnd
	 * @model opposite="end"
	 * @generated
	 */
	ForLoopStart getStart();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.richstring.ForLoopEnd#getStart <em>Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(ForLoopStart value);

} // ForLoopEnd
