/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Bug381381TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.CopyFieldNameToVariableStmt;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Copy Field Name To Variable Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.CopyFieldNameToVariableStmtImpl#getLine <em>Line</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.CopyFieldNameToVariableStmtImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.CopyFieldNameToVariableStmtImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CopyFieldNameToVariableStmtImpl extends MinimalEObjectImpl.Container implements CopyFieldNameToVariableStmt
{
  /**
   * The default value of the '{@link #getLine() <em>Line</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLine()
   * @generated
   * @ordered
   */
  protected static final int LINE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLine() <em>Line</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLine()
   * @generated
   * @ordered
   */
  protected int line = LINE_EDEFAULT;

  /**
   * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected static final int COLUMN_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected int column = COLUMN_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CopyFieldNameToVariableStmtImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Bug381381TestLanguagePackage.Literals.COPY_FIELD_NAME_TO_VARIABLE_STMT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLine()
  {
    return line;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLine(int newLine)
  {
    int oldLine = line;
    line = newLine;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__LINE, oldLine, line));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getColumn()
  {
    return column;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setColumn(int newColumn)
  {
    int oldColumn = column;
    column = newColumn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__COLUMN, oldColumn, column));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__LINE:
        return getLine();
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__COLUMN:
        return getColumn();
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__NAME:
        return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__LINE:
        setLine((Integer)newValue);
        return;
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__COLUMN:
        setColumn((Integer)newValue);
        return;
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__NAME:
        setName((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__LINE:
        setLine(LINE_EDEFAULT);
        return;
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__COLUMN:
        setColumn(COLUMN_EDEFAULT);
        return;
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__NAME:
        setName(NAME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__LINE:
        return line != LINE_EDEFAULT;
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__COLUMN:
        return column != COLUMN_EDEFAULT;
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (line: ");
    result.append(line);
    result.append(", column: ");
    result.append(column);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //CopyFieldNameToVariableStmtImpl
