/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.example.css.xcss.FontLiteral;
import org.eclipse.xtext.example.css.xcss.XcssPackage;

import org.eclipse.xtext.xbase.impl.XExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.FontLiteralImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.FontLiteralImpl#isItalic <em>Italic</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.FontLiteralImpl#isBold <em>Bold</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.impl.FontLiteralImpl#isSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FontLiteralImpl extends XExpressionImpl implements FontLiteral
{
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
   * The default value of the '{@link #isItalic() <em>Italic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isItalic()
   * @generated
   * @ordered
   */
  protected static final boolean ITALIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isItalic() <em>Italic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isItalic()
   * @generated
   * @ordered
   */
  protected boolean italic = ITALIC_EDEFAULT;

  /**
   * The default value of the '{@link #isBold() <em>Bold</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBold()
   * @generated
   * @ordered
   */
  protected static final boolean BOLD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isBold() <em>Bold</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBold()
   * @generated
   * @ordered
   */
  protected boolean bold = BOLD_EDEFAULT;

  /**
   * The default value of the '{@link #isSize() <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSize()
   * @generated
   * @ordered
   */
  protected static final boolean SIZE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSize() <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSize()
   * @generated
   * @ordered
   */
  protected boolean size = SIZE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FontLiteralImpl()
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
    return XcssPackage.Literals.FONT_LITERAL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, XcssPackage.FONT_LITERAL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isItalic()
  {
    return italic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setItalic(boolean newItalic)
  {
    boolean oldItalic = italic;
    italic = newItalic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XcssPackage.FONT_LITERAL__ITALIC, oldItalic, italic));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isBold()
  {
    return bold;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBold(boolean newBold)
  {
    boolean oldBold = bold;
    bold = newBold;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XcssPackage.FONT_LITERAL__BOLD, oldBold, bold));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSize()
  {
    return size;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSize(boolean newSize)
  {
    boolean oldSize = size;
    size = newSize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XcssPackage.FONT_LITERAL__SIZE, oldSize, size));
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
      case XcssPackage.FONT_LITERAL__NAME:
        return getName();
      case XcssPackage.FONT_LITERAL__ITALIC:
        return isItalic();
      case XcssPackage.FONT_LITERAL__BOLD:
        return isBold();
      case XcssPackage.FONT_LITERAL__SIZE:
        return isSize();
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
      case XcssPackage.FONT_LITERAL__NAME:
        setName((String)newValue);
        return;
      case XcssPackage.FONT_LITERAL__ITALIC:
        setItalic((Boolean)newValue);
        return;
      case XcssPackage.FONT_LITERAL__BOLD:
        setBold((Boolean)newValue);
        return;
      case XcssPackage.FONT_LITERAL__SIZE:
        setSize((Boolean)newValue);
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
      case XcssPackage.FONT_LITERAL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XcssPackage.FONT_LITERAL__ITALIC:
        setItalic(ITALIC_EDEFAULT);
        return;
      case XcssPackage.FONT_LITERAL__BOLD:
        setBold(BOLD_EDEFAULT);
        return;
      case XcssPackage.FONT_LITERAL__SIZE:
        setSize(SIZE_EDEFAULT);
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
      case XcssPackage.FONT_LITERAL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XcssPackage.FONT_LITERAL__ITALIC:
        return italic != ITALIC_EDEFAULT;
      case XcssPackage.FONT_LITERAL__BOLD:
        return bold != BOLD_EDEFAULT;
      case XcssPackage.FONT_LITERAL__SIZE:
        return size != SIZE_EDEFAULT;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", italic: ");
    result.append(italic);
    result.append(", bold: ");
    result.append(bold);
    result.append(", size: ");
    result.append(size);
    result.append(')');
    return result.toString();
  }

} //FontLiteralImpl
