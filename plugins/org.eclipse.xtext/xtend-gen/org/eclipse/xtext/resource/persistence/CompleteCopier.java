/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Similar to EcoreUtil.Copier (initially copied).
 * But copies proxy objects for external cross references.
 */
@SuppressWarnings("all")
public class CompleteCopier {
  /**
   * Whether proxies should be resolved during copying.
   */
  protected boolean resolveProxies = true;
  
  /**
   * Whether non-copied references should be used during copying.
   */
  protected boolean useOriginalReferences = false;
  
  private LinkedHashMap<EObject, EObject> old2new = new LinkedHashMap<EObject, EObject>();
  
  /**
   * Creates an instance.
   */
  public CompleteCopier() {
    super();
  }
  
  public static <T extends Object> T completeCopy(final T toCopy) {
    final CompleteCopier copier = new CompleteCopier();
    boolean _matched = false;
    if (!_matched) {
      if (toCopy instanceof Collection) {
        _matched=true;
        final Collection<InternalEObject> copyOfAll = copier.<InternalEObject>copyAll(((Collection<? extends InternalEObject>)toCopy));
        copier.copyReferences();
        return ((T) copyOfAll);
      }
    }
    if (!_matched) {
      if (toCopy instanceof InternalEObject) {
        _matched=true;
        final EObject copyOfAll = copier.copy(((InternalEObject)toCopy));
        copier.copyReferences();
        return ((T) copyOfAll);
      }
    }
    throw new IllegalArgumentException(("toCopy - " + toCopy));
  }
  
  /**
   * Returns a collection containing a copy of each EObject in the given collection.
   * @param eObjects the collection of objects to copy.
   * @return the collection of copies.
   */
  public <T extends EObject> Collection<T> copyAll(final Collection<? extends T> eObjects) {
    int _size = eObjects.size();
    final Collection<T> result = new ArrayList<T>(_size);
    for (final T object : eObjects) {
      {
        final EObject t = this.copy(object);
        boolean _notEquals = (!Objects.equal(t, null));
        if (_notEquals) {
          result.add(((T) t));
        }
      }
    }
    return result;
  }
  
  /**
   * Returns a copy of the given eObject.
   * @param eObject the object to copy.
   * @return the copy.
   */
  public EObject copy(final EObject eObject) {
    boolean _equals = Objects.equal(eObject, null);
    if (_equals) {
      return null;
    }
    final EObject copyEObject = this.createCopy(eObject);
    boolean _notEquals = (!Objects.equal(copyEObject, null));
    if (_notEquals) {
      this.old2new.put(eObject, copyEObject);
      final EClass eClass = eObject.eClass();
      EList<EStructuralFeature> _eAllStructuralFeatures = eClass.getEAllStructuralFeatures();
      final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
        public Boolean apply(final EStructuralFeature it) {
          boolean _and = false;
          boolean _isChangeable = it.isChangeable();
          if (!_isChangeable) {
            _and = false;
          } else {
            boolean _isDerived = it.isDerived();
            boolean _not = (!_isDerived);
            _and = _not;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
      for (final EStructuralFeature it : _filter) {
        boolean _matched = false;
        if (!_matched) {
          if (it instanceof EAttribute) {
            _matched=true;
            this.copyAttribute(((EAttribute)it), eObject, copyEObject);
          }
        }
        if (!_matched) {
          if (it instanceof EReference) {
            boolean _isContainment = ((EReference)it).isContainment();
            if (_isContainment) {
              _matched=true;
              this.copyContainment(((EReference)it), eObject, copyEObject);
            }
          }
        }
      }
      this.copyProxyURI(eObject, copyEObject);
    }
    return copyEObject;
  }
  
  /**
   * Copies the proxy URI from the original to the copy, if present.
   * @param eObject the object being copied.
   * @param copyEObject the copy being initialized.
   */
  protected void copyProxyURI(final EObject eObject, final EObject copyEObject) {
    boolean _eIsProxy = eObject.eIsProxy();
    if (_eIsProxy) {
      URI _eProxyURI = ((InternalEObject) eObject).eProxyURI();
      ((InternalEObject) copyEObject).eSetProxyURI(_eProxyURI);
    }
  }
  
  /**
   * Returns a new instance of the object's target class.
   * @param eObject the object to copy.
   * @return a new instance of the target class.
   * @see #getTarget(EObject)
   * @see EcoreUtil#create(EClass)
   */
  protected EObject createCopy(final EObject eObject) {
    final EClass eClass = this.getTarget(eObject);
    EObject _xifexpression = null;
    boolean _equals = Objects.equal(eClass, null);
    if (_equals) {
      _xifexpression = null;
    } else {
      _xifexpression = EcoreUtil.create(eClass);
    }
    return _xifexpression;
  }
  
  /**
   * Returns the target class used to create a copy instance for the given instance object.
   * @param eObject the object to be copied.
   * @return the target class used to create a copy instance.
   * @since 2.10
   */
  protected EClass getTarget(final EObject eObject) {
    EClass _eClass = eObject.eClass();
    return this.getTarget(_eClass);
  }
  
  /**
   * Returns the target class used to create a copy instance for objects of the given source class.
   * @param eClass the source class.
   * @return the target class used to create a copy instance.
   * @see #getTarget(EStructuralFeature, EObject, EObject)
   */
  protected EClass getTarget(final EClass eClass) {
    return eClass;
  }
  
  /**
   * Returns a setting for the feature and copy instance to be populated with the original object's source feature's value.
   * @param eStructuralFeature the source feature.
   * @return the target feature used to populate a copy instance.
   * @see #getTarget(EStructuralFeature)
   * @see #getTarget(EObject)
   * @since 2.10
   */
  protected EStructuralFeature.Setting getTarget(final EStructuralFeature eStructuralFeature, final EObject eObject, final EObject copyEObject) {
    final EStructuralFeature targetEStructuralFeature = this.getTarget(eStructuralFeature);
    EStructuralFeature.Setting _xifexpression = null;
    boolean _equals = Objects.equal(targetEStructuralFeature, null);
    if (_equals) {
      _xifexpression = null;
    } else {
      _xifexpression = ((InternalEObject) copyEObject).eSetting(targetEStructuralFeature);
    }
    return _xifexpression;
  }
  
  /**
   * Returns the target feature used to populate a copy instance from the given source feature.
   * @param eStructuralFeature the source feature.
   * @return the target feature used to populate a copy instance.
   * @see #getTarget(EClass)
   */
  protected EStructuralFeature getTarget(final EStructuralFeature eStructuralFeature) {
    return eStructuralFeature;
  }
  
  /**
   * Called to handle the copying of a containment feature;
   * this adds a list of copies or sets a single copy as appropriate for the multiplicity.
   * @param eReference the feature to copy.
   * @param eObject the object from which to copy.
   * @param copyEObject the object to copy to.
   */
  protected void copyContainment(final EReference eReference, final EObject eObject, final EObject copyEObject) {
    boolean _eIsSet = eObject.eIsSet(eReference);
    if (_eIsSet) {
      final EStructuralFeature.Setting setting = this.getTarget(eReference, eObject, copyEObject);
      boolean _notEquals = (!Objects.equal(setting, null));
      if (_notEquals) {
        final Object value = eObject.eGet(eReference);
        boolean _isMany = eReference.isMany();
        if (_isMany) {
          final List<EObject> target = ((List<EObject>) value);
          Collection<EObject> _copyAll = this.<EObject>copyAll(target);
          setting.set(_copyAll);
        } else {
          EObject _copy = this.copy(((EObject) value));
          setting.set(_copy);
        }
      }
    }
  }
  
  /**
   * Called to handle the copying of an attribute;
   * this adds a list of values or sets a single value as appropriate for the multiplicity.
   * @param eAttribute the attribute to copy.
   * @param eObject the object from which to copy.
   * @param copyEObject the object to copy to.
   */
  protected void copyAttribute(final EAttribute eAttribute, final EObject eObject, final EObject copyEObject) {
    boolean _eIsSet = eObject.eIsSet(eAttribute);
    if (_eIsSet) {
      boolean _isFeatureMap = FeatureMapUtil.isFeatureMap(eAttribute);
      if (_isFeatureMap) {
        Object _eGet = eObject.eGet(eAttribute);
        final FeatureMap featureMap = ((FeatureMap) _eGet);
        this.copyFeatureMap(featureMap);
      } else {
        final EStructuralFeature.Setting setting = this.getTarget(eAttribute, eObject, copyEObject);
        boolean _notEquals = (!Objects.equal(setting, null));
        if (_notEquals) {
          Object _eGet_1 = eObject.eGet(eAttribute);
          this.copyAttributeValue(eAttribute, eObject, _eGet_1, setting);
        }
      }
    }
  }
  
  /**
   * Call to handle copying the contained objects within a feature map.
   * @param featureMap the feature map the copy.
   * @since 2.10
   */
  protected void copyFeatureMap(final FeatureMap featureMap) {
    int _size = featureMap.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      EStructuralFeature _eStructuralFeature = featureMap.getEStructuralFeature((i).intValue());
      final EStructuralFeature feature = _eStructuralFeature;
      boolean _matched = false;
      if (!_matched) {
        if (feature instanceof EReference) {
          boolean _isContainment = ((EReference)feature).isContainment();
          if (_isContainment) {
            _matched=true;
            final Object value = featureMap.getValue((i).intValue());
            boolean _notEquals = (!Objects.equal(value, null));
            if (_notEquals) {
              this.copy(((EObject) value));
            }
          }
        }
      }
    }
  }
  
  /**
   * Called to handle copying of an attribute's value to the target setting.
   * @param eAttribute the attribute of the source object corresponding to the value.
   * @param eObject the object being copied.
   * @param value the value to be copied.
   * @param setting the feature-value pair that is the target of of the copy.
   * @since 2.10
   */
  protected void copyAttributeValue(final EAttribute eAttribute, final EObject eObject, final Object value, final EStructuralFeature.Setting setting) {
    setting.set(value);
  }
  
  /**
   * Hooks up cross references; it delegates to {@link #copyReference copyReference}.
   */
  public void copyReferences() {
    Set<Map.Entry<EObject, EObject>> _entrySet = this.old2new.entrySet();
    for (final Map.Entry<EObject, EObject> it : _entrySet) {
      {
        final EObject eObject = it.getKey();
        final EObject copyEObject = it.getValue();
        final EClass eClass = eObject.eClass();
        EList<EStructuralFeature> _eStructuralFeatures = eClass.getEStructuralFeatures();
        final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
          public Boolean apply(final EStructuralFeature it) {
            boolean _and = false;
            boolean _isChangeable = it.isChangeable();
            if (!_isChangeable) {
              _and = false;
            } else {
              boolean _isDerived = it.isDerived();
              boolean _not = (!_isDerived);
              _and = _not;
            }
            return Boolean.valueOf(_and);
          }
        };
        Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_eStructuralFeatures, _function);
        for (final EStructuralFeature it_1 : _filter) {
          if ((it_1 instanceof EReference)) {
            boolean _and = false;
            boolean _isContainment = ((EReference)it_1).isContainment();
            boolean _not = (!_isContainment);
            if (!_not) {
              _and = false;
            } else {
              boolean _isContainer = ((EReference)it_1).isContainer();
              boolean _not_1 = (!_isContainer);
              _and = _not_1;
            }
            if (_and) {
              this.copyReference(((EReference)it_1), eObject, copyEObject);
            }
          } else {
            boolean _isFeatureMap = FeatureMapUtil.isFeatureMap(it_1);
            if (_isFeatureMap) {
              EStructuralFeature.Setting _target = this.getTarget(it_1, eObject, copyEObject);
              final FeatureMap copyFeatureMap = ((FeatureMap) _target);
              boolean _notEquals = (!Objects.equal(copyFeatureMap, null));
              if (_notEquals) {
                Object _eGet = eObject.eGet(it_1);
                final FeatureMap featureMap = ((FeatureMap) _eGet);
                int copyFeatureMapSize = copyFeatureMap.size();
                int _size = featureMap.size();
                ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
                for (final Integer k : _doubleDotLessThan) {
                  EStructuralFeature _eStructuralFeature = featureMap.getEStructuralFeature((k).intValue());
                  final EStructuralFeature feature = _eStructuralFeature;
                  boolean _matched = false;
                  if (!_matched) {
                    if (feature instanceof EReference) {
                      _matched=true;
                      final Object referencedEObject = featureMap.getValue((k).intValue());
                      Object copyReferencedEObject = this.old2new.get(referencedEObject);
                      boolean _and_1 = false;
                      boolean _equals = Objects.equal(copyReferencedEObject, null);
                      if (!_equals) {
                        _and_1 = false;
                      } else {
                        boolean _notEquals_1 = (!Objects.equal(referencedEObject, null));
                        _and_1 = _notEquals_1;
                      }
                      if (_and_1) {
                        boolean _or = false;
                        boolean _or_1 = false;
                        if ((!this.useOriginalReferences)) {
                          _or_1 = true;
                        } else {
                          boolean _isContainment_1 = ((EReference)feature).isContainment();
                          _or_1 = _isContainment_1;
                        }
                        if (_or_1) {
                          _or = true;
                        } else {
                          EReference _eOpposite = ((EReference)feature).getEOpposite();
                          boolean _notEquals_2 = (!Objects.equal(_eOpposite, null));
                          _or = _notEquals_2;
                        }
                        if (_or) {
                        } else {
                          copyReferencedEObject = referencedEObject;
                        }
                      }
                      boolean _add = copyFeatureMap.add(feature, copyReferencedEObject);
                      boolean _not_2 = (!_add);
                      if (_not_2) {
                        for (int l = 0; (l < copyFeatureMapSize); l = (l + 1)) {
                          boolean _and_2 = false;
                          EStructuralFeature _eStructuralFeature_1 = copyFeatureMap.getEStructuralFeature(l);
                          boolean _equals_1 = Objects.equal(_eStructuralFeature_1, feature);
                          if (!_equals_1) {
                            _and_2 = false;
                          } else {
                            Object _value = copyFeatureMap.getValue(l);
                            boolean _equals_2 = Objects.equal(_value, copyReferencedEObject);
                            _and_2 = _equals_2;
                          }
                          if (_and_2) {
                            int _size_1 = copyFeatureMap.size();
                            int _minus = (_size_1 - 1);
                            copyFeatureMap.move(_minus, l);
                            copyFeatureMapSize = (copyFeatureMapSize - 1);
                          }
                        }
                      }
                    }
                  }
                  if (!_matched) {
                    EStructuralFeature _eStructuralFeature_1 = featureMap.getEStructuralFeature((k).intValue());
                    EStructuralFeature _target_1 = this.getTarget(_eStructuralFeature_1);
                    Object _value = featureMap.getValue((k).intValue());
                    copyFeatureMap.add(_target_1, _value);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  /**
   * Called to handle the copying of a cross reference;
   * this adds values or sets a single value as appropriate for the multiplicity
   * while omitting any bidirectional reference that isn't in the copy map.
   * @param eReference the reference to copy.
   * @param eObject the object from which to copy.
   * @param copyEObject the object to copy to.
   */
  protected void copyReference(final EReference eReference, final EObject eObject, final EObject copyEObject) {
    boolean _eIsSet = eObject.eIsSet(eReference);
    if (_eIsSet) {
      final EStructuralFeature.Setting setting = this.getTarget(eReference, eObject, copyEObject);
      boolean _notEquals = (!Objects.equal(setting, null));
      if (_notEquals) {
        final Object value = eObject.eGet(eReference, this.resolveProxies);
        boolean _isMany = eReference.isMany();
        if (_isMany) {
          final InternalEList<EObject> source = ((InternalEList<EObject>) value);
          final InternalEList<EObject> target = ((InternalEList<EObject>) setting);
          boolean _isEmpty = source.isEmpty();
          if (_isEmpty) {
            target.clear();
          } else {
            EReference _eOpposite = eReference.getEOpposite();
            final boolean isBidirectional = (!Objects.equal(_eOpposite, null));
            int index = 0;
            {
              Iterator<EObject> _xifexpression = null;
              if (this.resolveProxies) {
                _xifexpression = source.iterator();
              } else {
                _xifexpression = source.basicIterator();
              }
              final Iterator<EObject> k = _xifexpression;
              boolean _hasNext = k.hasNext();
              boolean _while = _hasNext;
              while (_while) {
                {
                  final EObject referencedEObject = k.next();
                  final EObject copyReferencedEObject = this.old2new.get(referencedEObject);
                  boolean _equals = Objects.equal(copyReferencedEObject, null);
                  if (_equals) {
                    boolean _and = false;
                    if (!this.useOriginalReferences) {
                      _and = false;
                    } else {
                      _and = (!isBidirectional);
                    }
                    if (_and) {
                      target.addUnique(index, referencedEObject);
                      index = (index + 1);
                    } else {
                      EObject _createProxy = this.createProxy(referencedEObject);
                      target.addUnique(index, _createProxy);
                    }
                  } else {
                    if (isBidirectional) {
                      final int position = target.indexOf(copyReferencedEObject);
                      if ((position == (-1))) {
                        target.addUnique(index, copyReferencedEObject);
                      } else {
                        if ((index != position)) {
                          target.move(index, copyReferencedEObject);
                        }
                      }
                    } else {
                      target.addUnique(index, copyReferencedEObject);
                    }
                    index = (index + 1);
                  }
                }
                boolean _hasNext_1 = k.hasNext();
                _while = _hasNext_1;
              }
            }
          }
        } else {
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            setting.set(null);
          } else {
            final Object copyReferencedEObject = this.old2new.get(value);
            boolean _equals_1 = Objects.equal(copyReferencedEObject, null);
            if (_equals_1) {
              boolean _and = false;
              if (!this.useOriginalReferences) {
                _and = false;
              } else {
                EReference _eOpposite_1 = eReference.getEOpposite();
                boolean _equals_2 = Objects.equal(_eOpposite_1, null);
                _and = _equals_2;
              }
              if (_and) {
                setting.set(value);
              } else {
                EObject _createProxy = this.createProxy(((EObject) value));
                setting.set(_createProxy);
              }
            } else {
              setting.set(copyReferencedEObject);
            }
          }
        }
      }
    }
  }
  
  public EObject createProxy(final EObject object) {
    final URI proxyURI = EcoreUtil.getURI(object);
    EClass _eClass = object.eClass();
    final EObject proxy = EcoreUtil.create(_eClass);
    ((InternalEObject) proxy).eSetProxyURI(proxyURI);
    return proxy;
  }
}
