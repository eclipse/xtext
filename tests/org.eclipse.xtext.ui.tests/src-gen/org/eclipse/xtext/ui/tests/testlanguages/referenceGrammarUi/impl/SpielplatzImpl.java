/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Erwachsener;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Familie;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Kind;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielplatz;
import org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.Spielzeug;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spielplatz</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielplatzImpl#getGroesse <em>Groesse</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielplatzImpl#getBeschreibung <em>Beschreibung</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielplatzImpl#getKinder <em>Kinder</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielplatzImpl#getErzieher <em>Erzieher</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielplatzImpl#getSpielzeuge <em>Spielzeuge</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.SpielplatzImpl#getFamilie <em>Familie</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpielplatzImpl extends MinimalEObjectImpl.Container implements Spielplatz
{
  /**
   * The default value of the '{@link #getGroesse() <em>Groesse</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroesse()
   * @generated
   * @ordered
   */
  protected static final int GROESSE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getGroesse() <em>Groesse</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroesse()
   * @generated
   * @ordered
   */
  protected int groesse = GROESSE_EDEFAULT;

  /**
   * The default value of the '{@link #getBeschreibung() <em>Beschreibung</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBeschreibung()
   * @generated
   * @ordered
   */
  protected static final String BESCHREIBUNG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBeschreibung() <em>Beschreibung</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBeschreibung()
   * @generated
   * @ordered
   */
  protected String beschreibung = BESCHREIBUNG_EDEFAULT;

  /**
   * The cached value of the '{@link #getKinder() <em>Kinder</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKinder()
   * @generated
   * @ordered
   */
  protected EList<Kind> kinder;

  /**
   * The cached value of the '{@link #getErzieher() <em>Erzieher</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErzieher()
   * @generated
   * @ordered
   */
  protected EList<Erwachsener> erzieher;

  /**
   * The cached value of the '{@link #getSpielzeuge() <em>Spielzeuge</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpielzeuge()
   * @generated
   * @ordered
   */
  protected EList<Spielzeug> spielzeuge;

  /**
   * The cached value of the '{@link #getFamilie() <em>Familie</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFamilie()
   * @generated
   * @ordered
   */
  protected EList<Familie> familie;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpielplatzImpl()
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
    return ReferenceGrammarUiPackage.Literals.SPIELPLATZ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getGroesse()
  {
    return groesse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGroesse(int newGroesse)
  {
    int oldGroesse = groesse;
    groesse = newGroesse;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReferenceGrammarUiPackage.SPIELPLATZ__GROESSE, oldGroesse, groesse));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBeschreibung()
  {
    return beschreibung;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBeschreibung(String newBeschreibung)
  {
    String oldBeschreibung = beschreibung;
    beschreibung = newBeschreibung;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReferenceGrammarUiPackage.SPIELPLATZ__BESCHREIBUNG, oldBeschreibung, beschreibung));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Kind> getKinder()
  {
    if (kinder == null)
    {
      kinder = new EObjectContainmentEList<Kind>(Kind.class, this, ReferenceGrammarUiPackage.SPIELPLATZ__KINDER);
    }
    return kinder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Erwachsener> getErzieher()
  {
    if (erzieher == null)
    {
      erzieher = new EObjectContainmentEList<Erwachsener>(Erwachsener.class, this, ReferenceGrammarUiPackage.SPIELPLATZ__ERZIEHER);
    }
    return erzieher;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Spielzeug> getSpielzeuge()
  {
    if (spielzeuge == null)
    {
      spielzeuge = new EObjectContainmentEList<Spielzeug>(Spielzeug.class, this, ReferenceGrammarUiPackage.SPIELPLATZ__SPIELZEUGE);
    }
    return spielzeuge;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Familie> getFamilie()
  {
    if (familie == null)
    {
      familie = new EObjectContainmentEList<Familie>(Familie.class, this, ReferenceGrammarUiPackage.SPIELPLATZ__FAMILIE);
    }
    return familie;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReferenceGrammarUiPackage.SPIELPLATZ__KINDER:
        return ((InternalEList<?>)getKinder()).basicRemove(otherEnd, msgs);
      case ReferenceGrammarUiPackage.SPIELPLATZ__ERZIEHER:
        return ((InternalEList<?>)getErzieher()).basicRemove(otherEnd, msgs);
      case ReferenceGrammarUiPackage.SPIELPLATZ__SPIELZEUGE:
        return ((InternalEList<?>)getSpielzeuge()).basicRemove(otherEnd, msgs);
      case ReferenceGrammarUiPackage.SPIELPLATZ__FAMILIE:
        return ((InternalEList<?>)getFamilie()).basicRemove(otherEnd, msgs);
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
    switch (featureID)
    {
      case ReferenceGrammarUiPackage.SPIELPLATZ__GROESSE:
        return getGroesse();
      case ReferenceGrammarUiPackage.SPIELPLATZ__BESCHREIBUNG:
        return getBeschreibung();
      case ReferenceGrammarUiPackage.SPIELPLATZ__KINDER:
        return getKinder();
      case ReferenceGrammarUiPackage.SPIELPLATZ__ERZIEHER:
        return getErzieher();
      case ReferenceGrammarUiPackage.SPIELPLATZ__SPIELZEUGE:
        return getSpielzeuge();
      case ReferenceGrammarUiPackage.SPIELPLATZ__FAMILIE:
        return getFamilie();
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
    switch (featureID)
    {
      case ReferenceGrammarUiPackage.SPIELPLATZ__GROESSE:
        setGroesse((Integer)newValue);
        return;
      case ReferenceGrammarUiPackage.SPIELPLATZ__BESCHREIBUNG:
        setBeschreibung((String)newValue);
        return;
      case ReferenceGrammarUiPackage.SPIELPLATZ__KINDER:
        getKinder().clear();
        getKinder().addAll((Collection<? extends Kind>)newValue);
        return;
      case ReferenceGrammarUiPackage.SPIELPLATZ__ERZIEHER:
        getErzieher().clear();
        getErzieher().addAll((Collection<? extends Erwachsener>)newValue);
        return;
      case ReferenceGrammarUiPackage.SPIELPLATZ__SPIELZEUGE:
        getSpielzeuge().clear();
        getSpielzeuge().addAll((Collection<? extends Spielzeug>)newValue);
        return;
      case ReferenceGrammarUiPackage.SPIELPLATZ__FAMILIE:
        getFamilie().clear();
        getFamilie().addAll((Collection<? extends Familie>)newValue);
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
      case ReferenceGrammarUiPackage.SPIELPLATZ__GROESSE:
        setGroesse(GROESSE_EDEFAULT);
        return;
      case ReferenceGrammarUiPackage.SPIELPLATZ__BESCHREIBUNG:
        setBeschreibung(BESCHREIBUNG_EDEFAULT);
        return;
      case ReferenceGrammarUiPackage.SPIELPLATZ__KINDER:
        getKinder().clear();
        return;
      case ReferenceGrammarUiPackage.SPIELPLATZ__ERZIEHER:
        getErzieher().clear();
        return;
      case ReferenceGrammarUiPackage.SPIELPLATZ__SPIELZEUGE:
        getSpielzeuge().clear();
        return;
      case ReferenceGrammarUiPackage.SPIELPLATZ__FAMILIE:
        getFamilie().clear();
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
      case ReferenceGrammarUiPackage.SPIELPLATZ__GROESSE:
        return groesse != GROESSE_EDEFAULT;
      case ReferenceGrammarUiPackage.SPIELPLATZ__BESCHREIBUNG:
        return BESCHREIBUNG_EDEFAULT == null ? beschreibung != null : !BESCHREIBUNG_EDEFAULT.equals(beschreibung);
      case ReferenceGrammarUiPackage.SPIELPLATZ__KINDER:
        return kinder != null && !kinder.isEmpty();
      case ReferenceGrammarUiPackage.SPIELPLATZ__ERZIEHER:
        return erzieher != null && !erzieher.isEmpty();
      case ReferenceGrammarUiPackage.SPIELPLATZ__SPIELZEUGE:
        return spielzeuge != null && !spielzeuge.isEmpty();
      case ReferenceGrammarUiPackage.SPIELPLATZ__FAMILIE:
        return familie != null && !familie.isEmpty();
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
    result.append(" (groesse: ");
    result.append(groesse);
    result.append(", beschreibung: ");
    result.append(beschreibung);
    result.append(')');
    return result.toString();
  }

} //SpielplatzImpl
