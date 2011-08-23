/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/eplv10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge  Initial contribution and API
 */
@Singleton
public class FeatureOverridesService {

    @Inject
    private SuperTypeCollector superTypeCollector;
    
    @Inject
    private TypeArgumentContextProvider contextProvider;

    @Inject
    protected FeatureOverridesService() {}
    
    public FeatureOverridesService(SuperTypeCollector superTypeCollector, TypeArgumentContextProvider contextProvider) {
        this.superTypeCollector = superTypeCollector;
        this.contextProvider = contextProvider;
    }
    
    public Iterable<JvmFeature> getAllJvmFeatures(JvmTypeReference type) {
    	if (type == null)
    		return Collections.emptyList();
        TypeArgumentContext context = contextProvider.getReceiverContext(type);
        JvmType rawType = type.getType();
        if (rawType == null || rawType.eIsProxy() || !(rawType instanceof JvmDeclaredType))
        	return Collections.emptyList();
        return getAllJvmFeatures((JvmDeclaredType) rawType, context);
    }
    
    public Iterable<JvmFeature> getAllJvmFeatures(JvmDeclaredType type, TypeArgumentContext ctx) {
    	Multimap<Triple<EClass,String,Integer>, JvmFeature> featureIndex = LinkedHashMultimap.create();
    	indexFeatures(type, featureIndex);
        Set<JvmTypeReference> types = superTypeCollector.collectSuperTypes(type);
        for (JvmTypeReference jvmTypeReference : types) {
            JvmType jvmType = jvmTypeReference.getType();
            if (jvmType instanceof JvmDeclaredType) {
            	indexFeatures((JvmDeclaredType) jvmType, featureIndex);
            }
        }
        return removeOverridden(featureIndex, ctx);
    }

	protected void indexFeatures(JvmDeclaredType type, Multimap<Triple<EClass, String, Integer>, JvmFeature> index) {
		for(JvmMember member: type.getMembers()) {
    		if (member instanceof JvmExecutable) {
				Triple<EClass, String, Integer> key = Tuples.create(member.eClass(), member.getSimpleName(), ((JvmExecutable) member).getParameters().size());
				index.put(key, (JvmFeature) member);
			} else if (member instanceof JvmField) {
				Triple<EClass, String, Integer> key = Tuples.create(member.eClass(), member.getSimpleName(), -1);
				index.put(key, (JvmFeature) member);
			}
    	}
	}

    protected Iterable<JvmFeature> removeOverridden(Multimap<Triple<EClass,String,Integer>,JvmFeature> featureIndex, TypeArgumentContext ctx) {
    	Set<JvmFeature> result = Sets.newLinkedHashSet(featureIndex.values()); 
    	for(Collection<JvmFeature> featuresWithSameName: featureIndex.asMap().values()) {
			if (featuresWithSameName.size() > 1) {
				for (JvmFeature op1 : featuresWithSameName) {
					for (JvmFeature op2 : featuresWithSameName) {
						if (result.contains(op1) && op1.getDeclaringType() != op2.getDeclaringType() && internalIsOverridden(op1, op2, ctx, true))
							result.remove(op2);
					}
				}
			}
    	}
        return result;
    }
    
    protected boolean internalIsOverridden(JvmFeature overriding, JvmFeature overridden, TypeArgumentContext context, boolean isCheckInheritance) {
    	if (overriding == overridden)
    		return false;
        if (!isNameEqual(overriding, overridden))
            return false;
        if (overriding instanceof JvmOperation && overridden instanceof JvmOperation) {
            JvmOperation overridingOp = (JvmOperation) overriding;
            JvmOperation overriddenOp = (JvmOperation) overridden;
            if (!isSameNumberOfArguments(overridingOp, overriddenOp))
                return false;
            if (!isSameArgumentTypes(overridingOp, overriddenOp, context))
                return false;
        }
        if (overriding instanceof JvmField && overridden instanceof JvmField) {
            JvmField overridingField = (JvmField) overriding;
            JvmField overriddenField = (JvmField) overridden;
            if (overridingField.isStatic() != overriddenField.isStatic())
                return false;
        }
        return true;
    }

    public boolean isOverridden(JvmFeature overriding, JvmFeature overridden, TypeArgumentContext context, boolean isCheckInheritance) {
    	if (overriding == overridden)
    		return false;
        if (overridden.getClass() != overriding.getClass())
            return false;
        if (!isNameEqual(overriding, overridden))
            return false;
        if (isCheckInheritance && !isInheritanceRelation(overriding, overridden))
            return false;
       return internalIsOverridden(overriding, overridden, context, isCheckInheritance);
    }
    
    protected boolean isNameEqual(JvmFeature overriding, JvmFeature overridden) {
        return overriding.getSimpleName().equals(overridden.getSimpleName());
    }

    protected boolean isSameNumberOfArguments(JvmOperation overriding, JvmOperation overridden) {
        return overriding.getParameters().size() == overridden.getParameters().size();
    }
    
    protected boolean isSameArgumentTypes(JvmOperation overriding, JvmOperation overridden, TypeArgumentContext context) {
        for (int i = 0; i < overriding.getParameters().size(); i++) {
            JvmFormalParameter overridingParam = overriding.getParameters().get(i);
            JvmFormalParameter overriddenParam = overridden.getParameters().get(i);
            JvmTypeReference overridingType = context.getLowerBound(overridingParam.getParameterType());
            JvmTypeReference overriddenType = context.getLowerBound(overriddenParam.getParameterType());
            if (!EcoreUtil.equals(overridingType, overriddenType))
                return false;
        }
        return true;
    }

    protected boolean isInheritanceRelation(JvmMember overriding, JvmMember overridden) {
        return superTypeCollector.isSuperType(overriding.getDeclaringType(), overridden.getDeclaringType());
    }
}