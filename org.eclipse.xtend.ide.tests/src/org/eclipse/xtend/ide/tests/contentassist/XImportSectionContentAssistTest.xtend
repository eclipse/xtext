/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.eclipse.core.runtime.preferences.InstanceScope
import org.eclipse.jdt.ui.JavaUI
import org.eclipse.jdt.ui.PreferenceConstants
import org.junit.Test
import org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XImportSectionContentAssistTest extends AbstractXtendContentAssistBugTest {
	
	@Test def void testMemberName() {
		val builder = newBuilder.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.")
		.assertTextAtCursorPosition("Foo.", "Foo.".length, "publicStaticMethod", "publicStaticField")
		
		builder.applyProposal("publicStaticMethod")
		.expectContent("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticMethod")
		
		builder.applyProposal("publicStaticField")
		.expectContent("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticField")
	}
	
	@Test def void testMemberName_2() {
		newBuilder.append('''
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticM
			
			class Bar {}''')
		.assertTextAtCursorPosition("publicStaticM", "publicStaticM".length, "publicStaticMethod")
	}
	
	@Test def void testMemberName_3() {
		val builder = newBuilder.append('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.''')
		.assertText("publicStaticMethod", "defaultStaticMethod", "protectedStaticMethod",
			"publicStaticField", "defaultStaticField", "protectedStaticField")
		
		builder.applyProposal("publicStaticMethod").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticMethod''')
		
		builder.applyProposal("defaultStaticMethod").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.defaultStaticMethod''')
		
		builder.applyProposal("protectedStaticMethod").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.protectedStaticMethod''')
		
		builder.applyProposal("publicStaticField").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticField''')
		
		builder.applyProposal("defaultStaticField").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.defaultStaticField''')
		
		builder.applyProposal("protectedStaticField").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.protectedStaticField''')
	}
	
	@Test def void testMemberName_4() {
		newBuilder.append('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.default
			
			class Bar {}''')
		.assertTextAtCursorPosition("default", "default".length, "defaultStaticMethod", "defaultStaticField")
	}
	
	@Test 
	def void testStaticFavoriteImports_operation(){
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".*")
			
			newBuilder.append('''
				package mypack
				class Bar{
					def void foo(){
						''')
			.applyProposal("staticMethod()")
			.expectContent('''
				package mypack
				
				import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod
				
				class Bar{
					def void foo(){
				staticMethod()''')
				
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	@Test 
	def void testStaticFavoriteImports_operation_direct(){
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".staticMethod")
			
			newBuilder.append('''
				package mypack
				class Bar{
					def void foo(){
						''')
			.applyProposal("staticMethod()")
			.expectContent('''
				package mypack
				
				import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod
				
				class Bar{
					def void foo(){
				staticMethod()''')
				
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	@Test 
	def void testStaticFavoriteImports_operation_direct_extension(){
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".staticMethod")
			
			newBuilder.append('''
				package mypack
				class Bar{
					def void foo(){
						"foo".''')
			.applyProposal("staticMethod")
			.expectContent('''
				package mypack
				
				import static extension org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod
				
				class Bar{
					def void foo(){
						"foo".staticMethod''')
				
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	@Test 
	def void testStaticFavoriteImports_operation_extension(){
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".*")
			
			newBuilder.append('''
				package mypack
				class Bar{
					def void foo(){
						"foo".''')
			.applyProposal("staticMethod")
			.expectContent('''
				package mypack
				
				import static extension org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod
				
				class Bar{
					def void foo(){
						"foo".staticMethod''')
				
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	@Test 
	def void testStaticFavoriteImports_field(){
		
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS,StaticClassExample.name + ".*")
			
			newBuilder.append('''
				package mypack
				class Bar{
					def void foo(){
						''')
			.applyProposal("STATICFIELD")
			.expectContent('''
				package mypack
				
				import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.STATICFIELD
				
				class Bar{
					def void foo(){
				STATICFIELD''')
				
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	@Test 
	def void testStaticFavoriteImports_no_constructor(){
		
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".*")
			
			newBuilder.append('''
				package mypack
				class Bar{
					def void foo(){
						<|>''')
			.assertNoProposalAtCursor("StaticClassExample")
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	
	@Test 
	def void testStaticFavoriteImports_no_proposal_non_static_operation(){
		
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".*")
			
			newBuilder.append('''
				package mypack
				class Bar{
					def void foo(){
						<|>''')
			.assertNoProposalAtCursor("nonStaticMethod")
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	@Test 
	def void testStaticFavoriteImports_no_proposal_non_static_operation_extension(){
		
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".*")
			
			newBuilder.append('''
				package mypack
				class Bar{
					def void foo(){
						"FOO".<|>''')
			.assertNoProposalAtCursor("nonStaticMethod")
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	@Test 
	def void testStaticFavoriteImports_field_No_additional_import(){
		
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".*")
			
			newBuilder.append('''
				package mypack
				class Bar{
					def void foo(){
						STATICFIELD
						''')
			.applyProposal("STATICFIELD")
			.expectContent('''
				package mypack
				
				import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.STATICFIELD
				
				class Bar{
					def void foo(){
						STATICFIELD
				STATICFIELD''')
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	@Test 
	def void testStaticFavoriteImports_No_additional_import(){
		
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".*")
			
			newBuilder.append('''
				package mypack
				class Bar{
					def void foo(){
						staticMethod()
						''')
			.applyProposal("staticMethod()")
			.expectContent('''
				package mypack
				
				import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod
				
				class Bar{
					def void foo(){
						staticMethod()
				staticMethod()''')
				
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	
}