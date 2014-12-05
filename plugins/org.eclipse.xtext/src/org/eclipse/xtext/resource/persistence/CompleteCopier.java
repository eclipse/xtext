/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * a EcoreUtil.Copier specialization that sets proxy objects for external references.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("serial")
public class CompleteCopier extends EcoreUtil.Copier {

	public CompleteCopier() {
		super(true, false);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T completeCopy(T toCopy) {
		CompleteCopier copier = new CompleteCopier();
		if (toCopy instanceof Collection) {
			Collection<? extends InternalEObject> collection = (Collection<? extends InternalEObject>) toCopy;
			Collection<? extends InternalEObject> copyOfAll = copier.copyAll(collection);
			copier.copyReferences();
			return (T) copyOfAll;
		} else if (toCopy instanceof InternalEObject) {
			InternalEObject internalEObject = (InternalEObject) toCopy;
			InternalEObject copy = (InternalEObject) copier.copy(internalEObject);
			copier.copyReferences();
			return (T) copy;
		}
		throw new IllegalArgumentException("toCopy - "+toCopy);
	}
	
	protected EObject createProxy(EObject value) {
		URI uri = EcoreUtil.getURI(value);
		EObject proxy = EcoreUtil.create(value.eClass());
		((InternalEObject)proxy).eSetProxyURI(uri);
		return proxy;
	}
	
	/*
     * copied from super class and added setting of fresh proxy objects
     * 
     * see //CUSTOMIZATION START/END markers
     */
    @Override
	protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject)
    {
      if (eObject.eIsSet(eReference))
      {
        EStructuralFeature.Setting setting = getTarget(eReference, eObject, copyEObject);
        if (setting != null)
        {
          Object value = eObject.eGet(eReference, resolveProxies);
          if (eReference.isMany())
          {
            @SuppressWarnings("unchecked") InternalEList<EObject> source = (InternalEList<EObject>)value;
            @SuppressWarnings("unchecked") InternalEList<EObject> target = (InternalEList<EObject>)setting;
            if (source.isEmpty())
            {
              target.clear();
            }
            else
            {
              boolean isBidirectional = eReference.getEOpposite() != null;
              int index = 0;
              for (Iterator<EObject> k = resolveProxies ? source.iterator() : source.basicIterator(); k.hasNext();)
              {
                EObject referencedEObject = k.next();
                EObject copyReferencedEObject = get(referencedEObject);
                if (copyReferencedEObject == null)
                {
                  if (useOriginalReferences && !isBidirectional)
                  {
                    target.addUnique(index, referencedEObject);
                    ++index;
                  }
                  //CUSTOMIZATION START
                  else {
                	target.addUnique(index, createProxy((EObject)value));
	                ++index;
	              }
                  //CUSTOMIZATION END
                }
                else
                {
                  if (isBidirectional)
                  {
                    int position = target.indexOf(copyReferencedEObject);
                    if (position == -1)
                    {
                      target.addUnique(index, copyReferencedEObject);
                    }
                    else if (index != position)
                    {
                      target.move(index, copyReferencedEObject);
                    }
                  }
                  else
                  {
                    target.addUnique(index, copyReferencedEObject);
                  }
                  ++index;
                }
              }
            }
          }
          else
          {
            if (value == null)
            {
              setting.set(null);
            }
            else
            {
              Object copyReferencedEObject = get(value);
              if (copyReferencedEObject == null)
              {
                if (useOriginalReferences && eReference.getEOpposite() == null)
                {
                  setting.set(value);
                }
                //CUSTOMIZATION START 
                else {
                  setting.set(createProxy((EObject)value));
                }
                //CUSTOMIZATION END
              }
              else
              {
                setting.set(copyReferencedEObject);
              }
            }
          }
        }
      }
    }


}
