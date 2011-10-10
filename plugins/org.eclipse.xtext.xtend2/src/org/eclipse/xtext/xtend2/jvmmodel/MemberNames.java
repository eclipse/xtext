/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.jvmmodel;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class MemberNames {

	public static class Factory {
		public MemberNames create(XtendClass source) {
			MemberNames memberNames = new MemberNames();
			memberNames.initialize(source);
			return memberNames;
		}
	}
	
	private List<String> usedNames; 
	
	protected void initialize(XtendClass xtendClass) {
		usedNames = newArrayList();
		for(XtendMember xtendMember: xtendClass.getMembers()) {
			String name = SimpleAttributeResolver.NAME_RESOLVER.apply(xtendMember);
			if(name != null) 
				usedNames.add(name);
		}
	}

	public String newName(String proposedName, String... prefixes) {
		return newName(proposedName, 0, prefixes);
	}
	
	protected String newName(String proposedName, int count, String... prefixes) {
		if(count < 0)
			throw new IllegalStateException("couldn't find a free member name for " + proposedName);
		String currentName  = proposedName + ((count == 0) ? "" : "_" + count);
		if(prefixes.length == 0 && usedNames.contains(currentName)) {
			return newName(proposedName, count + 1, prefixes);
		}
		for(String prefix: prefixes) {
			if(usedNames.contains(prefix + currentName)) 
				return newName(proposedName, count + 1, prefixes);
		}
		for(String prefix: prefixes) 
			usedNames.add(prefix + currentName);
		return currentName;
	}

}
