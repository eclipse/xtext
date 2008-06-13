/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.List;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class Strings {

    public static String concat(String separator, List<String> list) {
        return concat(separator, list, 0);
    }
     
    public static String concat(String separator, List<String> list, int skip) {
        StringBuffer buff = new StringBuffer();
        int lastIndex = list.size() - skip;
        for (int i = 0; i < lastIndex; i++) {
            buff.append(list.get(i));
            if (i + 1 < lastIndex)
                buff.append(separator);
        }
        String string = buff.toString();
        return string.trim().length() == 0 ? null : string;
    }

    public static String skipLastToken(String value, String separator) {
        int endIndex = value.lastIndexOf(separator);
        if(endIndex > 0)
            return value.substring(0, endIndex);
        else
            return value;
    }
    
    public static String lastToken(String value, String separator) {
        int index = value.lastIndexOf(separator) + 1;
        if(index < value.length())
            return value.substring(index, value.length());
        else
            return "";
    }
    
    public static String toFirstUpper(String s) {
    	if (s==null || s.length()==0)
    		return s;
    	if (s.length()==1)
    		return s.toUpperCase();
    	return s.substring(0, 1).toUpperCase()+s.substring(1);
    }

}
