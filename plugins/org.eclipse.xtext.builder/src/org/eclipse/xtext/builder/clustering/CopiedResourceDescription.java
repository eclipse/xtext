/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public class CopiedResourceDescription extends AbstractResourceDescription {
	
	private final static Logger log = Logger.getLogger(CopiedResourceDescription.class);
    
	private URI uri;
    
	private ImmutableList<IEObjectDescription> exported;

    public CopiedResourceDescription(IResourceDescription original) {
        this.uri = original.getURI();
        this.exported = ImmutableList.copyOf(Iterables.transform(original.getExportedObjects(),
                new Function<IEObjectDescription, IEObjectDescription>() {
                    public IEObjectDescription apply(IEObjectDescription from) {
                        if (from.getEObjectOrProxy().eIsProxy()) {
                            return from;
                        }
                        InternalEObject result = (InternalEObject) EcoreUtil.create(from.getEClass());
                        result.eSetProxyURI(from.getEObjectURI());
                        Map<String, String> userData = null;
                        for (final String key : from.getUserDataKeys()) {
                            if (userData == null) {
                                userData = Maps.newHashMapWithExpectedSize(2);
                            }
                            userData.put(key, from.getUserData(key));
                        }
                        return EObjectDescription.create(from.getName(), result, userData);
                    }
                }));
    }

    @Override
    protected List<IEObjectDescription> computeExportedObjects() {
        return exported;
    }

    public Iterable<QualifiedName> getImportedNames() {
    	// TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=344373
    	IllegalStateException exception = new IllegalStateException("getImportedNames "+getURI());
		log.error(exception, exception);
    	return Collections.emptyList();
//        throw new UnsupportedOperationException("getImportedNames()");
    }

    public Iterable<IReferenceDescription> getReferenceDescriptions() {
    	// TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=344373
    	IllegalStateException exception = new IllegalStateException("getReferenceDescriptions "+getURI());
    	log.error(exception, exception);
    	return Collections.emptyList();
//        throw new UnsupportedOperationException("getReferenceDescriptions()");
    }

    public URI getURI() {
        return uri;
    }
}