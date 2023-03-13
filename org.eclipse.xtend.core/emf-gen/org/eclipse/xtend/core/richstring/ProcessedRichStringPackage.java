/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringFactory
 * @model kind="package"
 * @generated
 */
public interface ProcessedRichStringPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "richstring";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtend/RichString";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "richstring";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProcessedRichStringPackage eINSTANCE = org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.ProcessedRichStringImpl <em>Processed Rich String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getProcessedRichString()
	 * @generated
	 */
	int PROCESSED_RICH_STRING = 0;

	/**
	 * The feature id for the '<em><b>Rich String</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSED_RICH_STRING__RICH_STRING = 0;

	/**
	 * The feature id for the '<em><b>Lines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSED_RICH_STRING__LINES = 1;

	/**
	 * The number of structural features of the '<em>Processed Rich String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSED_RICH_STRING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.LineImpl <em>Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.LineImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getLine()
	 * @generated
	 */
	int LINE = 1;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__PARTS = 0;

	/**
	 * The feature id for the '<em><b>Rich String</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__RICH_STRING = 1;

	/**
	 * The number of structural features of the '<em>Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.LinePartImpl <em>Line Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.LinePartImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getLinePart()
	 * @generated
	 */
	int LINE_PART = 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_PART__LINE = 0;

	/**
	 * The number of structural features of the '<em>Line Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_PART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.LiteralImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 3;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__LINE = LINE_PART__LINE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__LITERAL = LINE_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__OFFSET = LINE_PART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__LENGTH = LINE_PART_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = LINE_PART_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.LineBreakImpl <em>Line Break</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.LineBreakImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getLineBreak()
	 * @generated
	 */
	int LINE_BREAK = 4;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK__LINE = LITERAL__LINE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK__LITERAL = LITERAL__LITERAL;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK__OFFSET = LITERAL__OFFSET;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK__LENGTH = LITERAL__LENGTH;

	/**
	 * The number of structural features of the '<em>Line Break</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.ForLoopStartImpl <em>For Loop Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.ForLoopStartImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getForLoopStart()
	 * @generated
	 */
	int FOR_LOOP_START = 5;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_START__LINE = LINE_PART__LINE;

	/**
	 * The feature id for the '<em><b>Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_START__LOOP = LINE_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_START__END = LINE_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>For Loop Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_START_FEATURE_COUNT = LINE_PART_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.ForLoopEndImpl <em>For Loop End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.ForLoopEndImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getForLoopEnd()
	 * @generated
	 */
	int FOR_LOOP_END = 6;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_END__LINE = LINE_PART__LINE;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_END__START = LINE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>For Loop End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_END_FEATURE_COUNT = LINE_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.PrintedExpressionImpl <em>Printed Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.PrintedExpressionImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getPrintedExpression()
	 * @generated
	 */
	int PRINTED_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINTED_EXPRESSION__LINE = LINE_PART__LINE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINTED_EXPRESSION__EXPRESSION = LINE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Printed Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINTED_EXPRESSION_FEATURE_COUNT = LINE_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.IfConditionStartImpl <em>If Condition Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.IfConditionStartImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getIfConditionStart()
	 * @generated
	 */
	int IF_CONDITION_START = 8;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_CONDITION_START__LINE = LINE_PART__LINE;

	/**
	 * The feature id for the '<em><b>Rich String If</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_CONDITION_START__RICH_STRING_IF = LINE_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_CONDITION_START__ELSE_START = LINE_PART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else If Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_CONDITION_START__ELSE_IF_CONDITIONS = LINE_PART_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End If</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_CONDITION_START__END_IF = LINE_PART_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>If Condition Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_CONDITION_START_FEATURE_COUNT = LINE_PART_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.ElseIfConditionImpl <em>Else If Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.ElseIfConditionImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getElseIfCondition()
	 * @generated
	 */
	int ELSE_IF_CONDITION = 9;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_IF_CONDITION__LINE = LINE_PART__LINE;

	/**
	 * The feature id for the '<em><b>Rich String Else If</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_IF_CONDITION__RICH_STRING_ELSE_IF = LINE_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>If Condition Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_IF_CONDITION__IF_CONDITION_START = LINE_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Else If Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_IF_CONDITION_FEATURE_COUNT = LINE_PART_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.ElseStartImpl <em>Else Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.ElseStartImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getElseStart()
	 * @generated
	 */
	int ELSE_START = 10;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_START__LINE = LINE_PART__LINE;

	/**
	 * The feature id for the '<em><b>If Condition Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_START__IF_CONDITION_START = LINE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Else Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_START_FEATURE_COUNT = LINE_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtend.core.richstring.impl.EndIfImpl <em>End If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtend.core.richstring.impl.EndIfImpl
	 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getEndIf()
	 * @generated
	 */
	int END_IF = 11;

	/**
	 * The feature id for the '<em><b>Line</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_IF__LINE = LINE_PART__LINE;

	/**
	 * The feature id for the '<em><b>If Condition Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_IF__IF_CONDITION_START = LINE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>End If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_IF_FEATURE_COUNT = LINE_PART_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.ProcessedRichString <em>Processed Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processed Rich String</em>'.
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichString
	 * @generated
	 */
	EClass getProcessedRichString();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.ProcessedRichString#getRichString <em>Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rich String</em>'.
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichString#getRichString()
	 * @see #getProcessedRichString()
	 * @generated
	 */
	EReference getProcessedRichString_RichString();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.richstring.ProcessedRichString#getLines <em>Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lines</em>'.
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichString#getLines()
	 * @see #getProcessedRichString()
	 * @generated
	 */
	EReference getProcessedRichString_Lines();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.Line <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line</em>'.
	 * @see org.eclipse.xtend.core.richstring.Line
	 * @generated
	 */
	EClass getLine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.core.richstring.Line#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipse.xtend.core.richstring.Line#getParts()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_Parts();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtend.core.richstring.Line#getRichString <em>Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Rich String</em>'.
	 * @see org.eclipse.xtend.core.richstring.Line#getRichString()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_RichString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.LinePart <em>Line Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Part</em>'.
	 * @see org.eclipse.xtend.core.richstring.LinePart
	 * @generated
	 */
	EClass getLinePart();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtend.core.richstring.LinePart#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Line</em>'.
	 * @see org.eclipse.xtend.core.richstring.LinePart#getLine()
	 * @see #getLinePart()
	 * @generated
	 */
	EReference getLinePart_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see org.eclipse.xtend.core.richstring.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.Literal#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal</em>'.
	 * @see org.eclipse.xtend.core.richstring.Literal#getLiteral()
	 * @see #getLiteral()
	 * @generated
	 */
	EReference getLiteral_Literal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.richstring.Literal#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.xtend.core.richstring.Literal#getOffset()
	 * @see #getLiteral()
	 * @generated
	 */
	EAttribute getLiteral_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtend.core.richstring.Literal#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.eclipse.xtend.core.richstring.Literal#getLength()
	 * @see #getLiteral()
	 * @generated
	 */
	EAttribute getLiteral_Length();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.LineBreak <em>Line Break</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Break</em>'.
	 * @see org.eclipse.xtend.core.richstring.LineBreak
	 * @generated
	 */
	EClass getLineBreak();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.ForLoopStart <em>For Loop Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Loop Start</em>'.
	 * @see org.eclipse.xtend.core.richstring.ForLoopStart
	 * @generated
	 */
	EClass getForLoopStart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.ForLoopStart#getLoop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop</em>'.
	 * @see org.eclipse.xtend.core.richstring.ForLoopStart#getLoop()
	 * @see #getForLoopStart()
	 * @generated
	 */
	EReference getForLoopStart_Loop();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.ForLoopStart#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End</em>'.
	 * @see org.eclipse.xtend.core.richstring.ForLoopStart#getEnd()
	 * @see #getForLoopStart()
	 * @generated
	 */
	EReference getForLoopStart_End();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.ForLoopEnd <em>For Loop End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Loop End</em>'.
	 * @see org.eclipse.xtend.core.richstring.ForLoopEnd
	 * @generated
	 */
	EClass getForLoopEnd();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.ForLoopEnd#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start</em>'.
	 * @see org.eclipse.xtend.core.richstring.ForLoopEnd#getStart()
	 * @see #getForLoopEnd()
	 * @generated
	 */
	EReference getForLoopEnd_Start();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.PrintedExpression <em>Printed Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Printed Expression</em>'.
	 * @see org.eclipse.xtend.core.richstring.PrintedExpression
	 * @generated
	 */
	EClass getPrintedExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.PrintedExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipse.xtend.core.richstring.PrintedExpression#getExpression()
	 * @see #getPrintedExpression()
	 * @generated
	 */
	EReference getPrintedExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.IfConditionStart <em>If Condition Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Condition Start</em>'.
	 * @see org.eclipse.xtend.core.richstring.IfConditionStart
	 * @generated
	 */
	EClass getIfConditionStart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.IfConditionStart#getRichStringIf <em>Rich String If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rich String If</em>'.
	 * @see org.eclipse.xtend.core.richstring.IfConditionStart#getRichStringIf()
	 * @see #getIfConditionStart()
	 * @generated
	 */
	EReference getIfConditionStart_RichStringIf();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.IfConditionStart#getElseStart <em>Else Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Else Start</em>'.
	 * @see org.eclipse.xtend.core.richstring.IfConditionStart#getElseStart()
	 * @see #getIfConditionStart()
	 * @generated
	 */
	EReference getIfConditionStart_ElseStart();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.xtend.core.richstring.IfConditionStart#getElseIfConditions <em>Else If Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Else If Conditions</em>'.
	 * @see org.eclipse.xtend.core.richstring.IfConditionStart#getElseIfConditions()
	 * @see #getIfConditionStart()
	 * @generated
	 */
	EReference getIfConditionStart_ElseIfConditions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.IfConditionStart#getEndIf <em>End If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End If</em>'.
	 * @see org.eclipse.xtend.core.richstring.IfConditionStart#getEndIf()
	 * @see #getIfConditionStart()
	 * @generated
	 */
	EReference getIfConditionStart_EndIf();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.ElseIfCondition <em>Else If Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Else If Condition</em>'.
	 * @see org.eclipse.xtend.core.richstring.ElseIfCondition
	 * @generated
	 */
	EClass getElseIfCondition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.ElseIfCondition#getRichStringElseIf <em>Rich String Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rich String Else If</em>'.
	 * @see org.eclipse.xtend.core.richstring.ElseIfCondition#getRichStringElseIf()
	 * @see #getElseIfCondition()
	 * @generated
	 */
	EReference getElseIfCondition_RichStringElseIf();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.ElseIfCondition#getIfConditionStart <em>If Condition Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>If Condition Start</em>'.
	 * @see org.eclipse.xtend.core.richstring.ElseIfCondition#getIfConditionStart()
	 * @see #getElseIfCondition()
	 * @generated
	 */
	EReference getElseIfCondition_IfConditionStart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.ElseStart <em>Else Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Else Start</em>'.
	 * @see org.eclipse.xtend.core.richstring.ElseStart
	 * @generated
	 */
	EClass getElseStart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.ElseStart#getIfConditionStart <em>If Condition Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>If Condition Start</em>'.
	 * @see org.eclipse.xtend.core.richstring.ElseStart#getIfConditionStart()
	 * @see #getElseStart()
	 * @generated
	 */
	EReference getElseStart_IfConditionStart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtend.core.richstring.EndIf <em>End If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End If</em>'.
	 * @see org.eclipse.xtend.core.richstring.EndIf
	 * @generated
	 */
	EClass getEndIf();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtend.core.richstring.EndIf#getIfConditionStart <em>If Condition Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>If Condition Start</em>'.
	 * @see org.eclipse.xtend.core.richstring.EndIf#getIfConditionStart()
	 * @see #getEndIf()
	 * @generated
	 */
	EReference getEndIf_IfConditionStart();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProcessedRichStringFactory getProcessedRichStringFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.ProcessedRichStringImpl <em>Processed Rich String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getProcessedRichString()
		 * @generated
		 */
		EClass PROCESSED_RICH_STRING = eINSTANCE.getProcessedRichString();

		/**
		 * The meta object literal for the '<em><b>Rich String</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSED_RICH_STRING__RICH_STRING = eINSTANCE.getProcessedRichString_RichString();

		/**
		 * The meta object literal for the '<em><b>Lines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSED_RICH_STRING__LINES = eINSTANCE.getProcessedRichString_Lines();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.LineImpl <em>Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.LineImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getLine()
		 * @generated
		 */
		EClass LINE = eINSTANCE.getLine();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE__PARTS = eINSTANCE.getLine_Parts();

		/**
		 * The meta object literal for the '<em><b>Rich String</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE__RICH_STRING = eINSTANCE.getLine_RichString();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.LinePartImpl <em>Line Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.LinePartImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getLinePart()
		 * @generated
		 */
		EClass LINE_PART = eINSTANCE.getLinePart();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE_PART__LINE = eINSTANCE.getLinePart_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.LiteralImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL__LITERAL = eINSTANCE.getLiteral_Literal();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL__OFFSET = eINSTANCE.getLiteral_Offset();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL__LENGTH = eINSTANCE.getLiteral_Length();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.LineBreakImpl <em>Line Break</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.LineBreakImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getLineBreak()
		 * @generated
		 */
		EClass LINE_BREAK = eINSTANCE.getLineBreak();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.ForLoopStartImpl <em>For Loop Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.ForLoopStartImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getForLoopStart()
		 * @generated
		 */
		EClass FOR_LOOP_START = eINSTANCE.getForLoopStart();

		/**
		 * The meta object literal for the '<em><b>Loop</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_LOOP_START__LOOP = eINSTANCE.getForLoopStart_Loop();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_LOOP_START__END = eINSTANCE.getForLoopStart_End();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.ForLoopEndImpl <em>For Loop End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.ForLoopEndImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getForLoopEnd()
		 * @generated
		 */
		EClass FOR_LOOP_END = eINSTANCE.getForLoopEnd();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_LOOP_END__START = eINSTANCE.getForLoopEnd_Start();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.PrintedExpressionImpl <em>Printed Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.PrintedExpressionImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getPrintedExpression()
		 * @generated
		 */
		EClass PRINTED_EXPRESSION = eINSTANCE.getPrintedExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRINTED_EXPRESSION__EXPRESSION = eINSTANCE.getPrintedExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.IfConditionStartImpl <em>If Condition Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.IfConditionStartImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getIfConditionStart()
		 * @generated
		 */
		EClass IF_CONDITION_START = eINSTANCE.getIfConditionStart();

		/**
		 * The meta object literal for the '<em><b>Rich String If</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_CONDITION_START__RICH_STRING_IF = eINSTANCE.getIfConditionStart_RichStringIf();

		/**
		 * The meta object literal for the '<em><b>Else Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_CONDITION_START__ELSE_START = eINSTANCE.getIfConditionStart_ElseStart();

		/**
		 * The meta object literal for the '<em><b>Else If Conditions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_CONDITION_START__ELSE_IF_CONDITIONS = eINSTANCE.getIfConditionStart_ElseIfConditions();

		/**
		 * The meta object literal for the '<em><b>End If</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_CONDITION_START__END_IF = eINSTANCE.getIfConditionStart_EndIf();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.ElseIfConditionImpl <em>Else If Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.ElseIfConditionImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getElseIfCondition()
		 * @generated
		 */
		EClass ELSE_IF_CONDITION = eINSTANCE.getElseIfCondition();

		/**
		 * The meta object literal for the '<em><b>Rich String Else If</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELSE_IF_CONDITION__RICH_STRING_ELSE_IF = eINSTANCE.getElseIfCondition_RichStringElseIf();

		/**
		 * The meta object literal for the '<em><b>If Condition Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELSE_IF_CONDITION__IF_CONDITION_START = eINSTANCE.getElseIfCondition_IfConditionStart();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.ElseStartImpl <em>Else Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.ElseStartImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getElseStart()
		 * @generated
		 */
		EClass ELSE_START = eINSTANCE.getElseStart();

		/**
		 * The meta object literal for the '<em><b>If Condition Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELSE_START__IF_CONDITION_START = eINSTANCE.getElseStart_IfConditionStart();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtend.core.richstring.impl.EndIfImpl <em>End If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtend.core.richstring.impl.EndIfImpl
		 * @see org.eclipse.xtend.core.richstring.impl.ProcessedRichStringPackageImpl#getEndIf()
		 * @generated
		 */
		EClass END_IF = eINSTANCE.getEndIf();

		/**
		 * The meta object literal for the '<em><b>If Condition Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_IF__IF_CONDITION_START = eINSTANCE.getEndIf_IfConditionStart();

	}

} //ProcessedRichStringPackage
