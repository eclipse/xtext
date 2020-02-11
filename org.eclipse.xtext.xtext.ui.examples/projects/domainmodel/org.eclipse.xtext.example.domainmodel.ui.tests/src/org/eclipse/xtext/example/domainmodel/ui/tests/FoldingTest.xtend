/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractFoldingTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class FoldingTest extends AbstractFoldingTest {

	@Test def imports() {
		'''
			[>import java.util.List
			import java.util.Date<]
		'''.testFoldingRegions
	}

	@Test def package_declaration() {
		'''
			[>package p1 {
				
			}<]
		'''.testFoldingRegions
	}

	@Test def package_declarations() {
		'''
			[>package p1 {
				
			}<]
			
			[>package p2 {
				
			}<]
		'''.testFoldingRegions
	}

	@Test def entitiy() {
		'''
			[>entity HasAuthor {
				
			}<]
		'''.testFoldingRegions
	}

	@Test def operation1() {
		'''
			[>entity HasAuthor {
				author: String
				
			[>[>op getAuthor() {
					author
				}<]<]
			}<]
		'''.testFoldingRegions
	}

	@Test def operation2() {
		'''
			[>entity HasAuthor {
				author: String
				
			[>	op getAuthor()
			[>	{
					author
				}<]<]
			}<]
		'''.testFoldingRegions
	}

	@Test def complex() {
		'''
			import java.util.List
			
			[>entity Blog {
				title: String
				posts: List<Post>
				
				op addPost(Post post) : void {}
				op getPosts() : List<Post> {}
			}<]
			
			[>entity HasAuthor {
				author: String
				
				op getAuthor() { author }
				op setAuthor() : void {}
			}<]
			
			[>entity Post extends HasAuthor {
				title: String
				content: String
				comments: List<Comment>
			}<]
			
			[>entity Comment extends HasAuthor {
				content: String
			}<]
		'''.testFoldingRegions
	}

	@Test def multi_line_comment() {
		'''
		[>/*
		   * Description of the entity E.
		   */<]
		entity E {}
		'''.testFoldingRegions
	}

	@Test def java_doc() {
		'''
		[>/**
		   * Documentation of the entity E.
		   */<]
		entity E {}
		'''.testFoldingRegions
	}
}
