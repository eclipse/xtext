/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParserRuleImpl.java,v 1.11 2008/06/05 15:03:51 sefftinge Exp $
 */
package org.eclipse.xtext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.impl.ParserRuleImpl#getAlternatives <em>Alternatives</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParserRuleImpl extends AbstractRuleImpl implements ParserRule
{
  /**
	 * The cached value of the '{@link #getAlternatives() <em>Alternatives</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAlternatives()
	 * @generated
	 * @ordered
	 */
  protected AbstractElement alternatives;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ParserRuleImpl()
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
		return XtextPackage.Literals.PARSER_RULE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AbstractElement getAlternatives()
  {
		return alternatives;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetAlternatives(AbstractElement newAlternatives, NotificationChain msgs)
  {
		AbstractElement oldAlternatives = alternatives;
		alternatives = newAlternatives;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextPackage.PARSER_RULE__ALTERNATIVES, oldAlternatives, newAlternatives);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAlternatives(AbstractElement newAlternatives)
  {
		if (newAlternatives != alternatives) {
			NotificationChain msgs = null;
			if (alternatives != null)
				msgs = ((InternalEObject)alternatives).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextPackage.PARSER_RULE__ALTERNATIVES, null, msgs);
			if (newAlternatives != null)
				msgs = ((InternalEObject)newAlternatives).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextPackage.PARSER_RULE__ALTERNATIVES, null, msgs);
			msgs = basicSetAlternatives(newAlternatives, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.PARSER_RULE__ALTERNATIVES, newAlternatives, newAlternatives));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case XtextPackage.PARSER_RULE__ALTERNATIVES:
				return basicSetAlternatives(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case XtextPackage.PARSER_RULE__ALTERNATIVES:
				return getAlternatives();
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
		switch (featureID) {
			case XtextPackage.PARSER_RULE__ALTERNATIVES:
				setAlternatives((AbstractElement)newValue);
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
		switch (featureID) {
			case XtextPackage.PARSER_RULE__ALTERNATIVES:
				setAlternatives((AbstractElement)null);
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
		switch (featureID) {
			case XtextPackage.PARSER_RULE__ALTERNATIVES:
				return alternatives != null;
		}
		return super.eIsSet(featureID);
	}

} //ParserRuleImpl
