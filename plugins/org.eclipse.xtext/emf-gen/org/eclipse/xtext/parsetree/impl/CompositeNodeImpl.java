/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositeNodeImpl.java,v 1.6 2008/07/01 10:18:06 sefftinge Exp $
 */
package org.eclipse.xtext.parsetree.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.ParsetreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.CompositeNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.CompositeNodeImpl#getLookahead <em>Lookahead</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.CompositeNodeImpl#getLookaheadConsumed <em>Lookahead Consumed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeNodeImpl extends AbstractNodeImpl implements CompositeNode
{
  /**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
  protected EList<AbstractNode> children;

  /**
	 * The default value of the '{@link #getLookahead() <em>Lookahead</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLookahead()
	 * @generated
	 * @ordered
	 */
    protected static final int LOOKAHEAD_EDEFAULT = 0;
/**
	 * The cached value of the '{@link #getLookahead() <em>Lookahead</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLookahead()
	 * @generated
	 * @ordered
	 */
    protected int lookahead = LOOKAHEAD_EDEFAULT;

/**
	 * The default value of the '{@link #getLookaheadConsumed() <em>Lookahead Consumed</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLookaheadConsumed()
	 * @generated
	 * @ordered
	 */
    protected static final int LOOKAHEAD_CONSUMED_EDEFAULT = 0;

/**
	 * The cached value of the '{@link #getLookaheadConsumed() <em>Lookahead Consumed</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLookaheadConsumed()
	 * @generated
	 * @ordered
	 */
    protected int lookaheadConsumed = LOOKAHEAD_CONSUMED_EDEFAULT;

/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CompositeNodeImpl()
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
		return ParsetreePackage.Literals.COMPOSITE_NODE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<AbstractNode> getChildren()
  {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList.Resolving<AbstractNode>(AbstractNode.class, this, ParsetreePackage.COMPOSITE_NODE__CHILDREN, ParsetreePackage.ABSTRACT_NODE__PARENT);
		}
		return children;
	}

  /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getLookahead() {
		return lookahead;
	}

/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setLookahead(int newLookahead) {
		int oldLookahead = lookahead;
		lookahead = newLookahead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.COMPOSITE_NODE__LOOKAHEAD, oldLookahead, lookahead));
	}

/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getLookaheadConsumed() {
		return lookaheadConsumed;
	}

/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setLookaheadConsumed(int newLookaheadConsumed) {
		int oldLookaheadConsumed = lookaheadConsumed;
		lookaheadConsumed = newLookaheadConsumed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.COMPOSITE_NODE__LOOKAHEAD_CONSUMED, oldLookaheadConsumed, lookaheadConsumed));
	}

/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				return getChildren();
			case ParsetreePackage.COMPOSITE_NODE__LOOKAHEAD:
				return new Integer(getLookahead());
			case ParsetreePackage.COMPOSITE_NODE__LOOKAHEAD_CONSUMED:
				return new Integer(getLookaheadConsumed());
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends AbstractNode>)newValue);
				return;
			case ParsetreePackage.COMPOSITE_NODE__LOOKAHEAD:
				setLookahead(((Integer)newValue).intValue());
				return;
			case ParsetreePackage.COMPOSITE_NODE__LOOKAHEAD_CONSUMED:
				setLookaheadConsumed(((Integer)newValue).intValue());
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
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				getChildren().clear();
				return;
			case ParsetreePackage.COMPOSITE_NODE__LOOKAHEAD:
				setLookahead(LOOKAHEAD_EDEFAULT);
				return;
			case ParsetreePackage.COMPOSITE_NODE__LOOKAHEAD_CONSUMED:
				setLookaheadConsumed(LOOKAHEAD_CONSUMED_EDEFAULT);
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
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case ParsetreePackage.COMPOSITE_NODE__LOOKAHEAD:
				return lookahead != LOOKAHEAD_EDEFAULT;
			case ParsetreePackage.COMPOSITE_NODE__LOOKAHEAD_CONSUMED:
				return lookaheadConsumed != LOOKAHEAD_CONSUMED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lookahead: ");
		result.append(lookahead);
		result.append(", lookaheadConsumed: ");
		result.append(lookaheadConsumed);
		result.append(')');
		return result.toString();
	}

} //CompositeNodeImpl
