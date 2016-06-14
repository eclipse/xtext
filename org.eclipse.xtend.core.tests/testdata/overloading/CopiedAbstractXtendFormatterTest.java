/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package overloading;

import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.lib.Procedures;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class CopiedAbstractXtendFormatterTest {
	
	public void assertFormatted(CharSequence c) {}
	
	public void put(MapBasedPreferenceValues m, PreferenceKey k, Object o) {}
	
	public void assertFormattedExpression(Procedures.Procedure1<? super MapBasedPreferenceValues> p, CharSequence c) {}
	public void assertFormattedExpression(CharSequence c) {}
	public void assertFormattedExpression(String s, CharSequence c) {}
	public void assertFormattedExpression(Procedures.Procedure1<? super MapBasedPreferenceValues> p, CharSequence c, CharSequence c2) {}
	public void assertFormattedExpression(Procedures.Procedure1<? super MapBasedPreferenceValues> p, CharSequence c, CharSequence c2, boolean b) {}
	
	public void assertFormattedMember(String s, CharSequence c) {}
//	public void assertFormattedMember(Procedures.Procedure1<? super MapBasedPreferenceValues> p, String s, CharSequence c) {}
	public void assertFormattedMember(Procedures.Procedure1<? super MapBasedPreferenceValues> p, String s) {}
//	public void assertFormattedMember(String c) {}
	
	public void assertFormatted(Procedures.Procedure1<? super MapBasedPreferenceValues> p, CharSequence c) {}
	public void assertFormatted(CharSequence c1, CharSequence c2) {}
	public void assertFormatted(Procedures.Procedure1<? super MapBasedPreferenceValues> p, CharSequence c1, CharSequence c2) {}
	public void assertFormatted(Procedures.Procedure1<? super MapBasedPreferenceValues> p, CharSequence c1, CharSequence c2, String s1, String s2, boolean b) {}
	
}
