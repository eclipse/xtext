/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Iterables;

/**
 * This is a library used to convert arrays to lists and vice versa in a way that keeps the identity of the
 * to-be-converted object. That is, changes in the array will be reflected by the list and changes to the list will be
 * reflected by the array for both kinds of conversion.
 * 
 * The utilities in this class should only be used by the Xbase compiler.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@GwtIncompatible("reflection") public class Conversions {

}