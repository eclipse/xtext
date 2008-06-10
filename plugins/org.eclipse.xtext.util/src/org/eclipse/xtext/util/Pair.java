/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author Jan Köhnlein
 *
 */
public class Pair<T,U> {

    private T firstElement;
    
    private U secondElement;
    
    public Pair(T firstElement, U secondElement) {
        if(firstElement == null || secondElement == null) {
            throw new IllegalArgumentException("Elements of Pair cannot be null");
        }
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }
    
    
    public T getFirstElement() {
        return firstElement;
    }

    public U getSecondElement() {
        return secondElement;
    }

    public boolean equals(Object other) {
        if(other instanceof Pair<?,?>) {
            Pair<?,?> otherPair = (Pair<?, ?>)other;
            return firstElement.equals(otherPair.getFirstElement()) && secondElement.equals(otherPair.getSecondElement());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return firstElement.hashCode() + 17*secondElement.hashCode();
    }


    public void setFirstElement(T firstElement) {
        this.firstElement = firstElement;
    }


    public void setSecondElement(U secondElement) {
        this.secondElement = secondElement;
    }
    
}
