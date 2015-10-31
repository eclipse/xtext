/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.formatting

import com.intellij.openapi.fileTypes.LanguageFileType
import org.eclipse.xtext.idea.tests.AbstractAutoEditTest

abstract class AbstractXbaseAutoEditTest extends AbstractAutoEditTest {

	new(LanguageFileType fileType) {
		super(fileType)
	}

	def void test_if_then_01() {
		'''
			var x = 0
			if (x == 1)|
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1)
				|
		''')
	}

	def void test_if_then_02() {
		'''
			var x = 0
			if (x == 1) |return true
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1) 
				|return true
		''')
	}

	def void test_if_then_03() {
		'''
			var x = 0
			if (x == 1) {|}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1) {
				|
			}
		''')
	}

	def void test_if_then_04() {
		'''
			var x = 0
			if (x == 1) {|return true}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1) {
				|return true}
		''')
	}

	def void test_if_then_05() {
		'''
			var x = 0
			if (x == 1)| {return true}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1)
			|{return true}
		''')
	}

	def void test_if_then_06() {
		'''
			var x = 0
			|if (x == 1) {return true}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			
			|if (x == 1) {return true}
		''')
	}

	def void test_if_then_07() {
		'''
			var x = 0|
			if (x == 1) {return true}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			|
			if (x == 1) {return true}
		''')
	}

	def void test_if_else_01() {
		'''
			var x = 0
			if (x == 1)
				return true
			else|
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1)
				return true
			else
				|
		''')
	}

	def void test_if_else_02() {
		'''
			var x = 0
			if (x == 1)
				return true
			else {|}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1)
				return true
			else {
				|
			}
		''')
	}

	def void test_if_else_03() {
		'''
			var x = 0
			if (x == 1)
				return true
			else |return false
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1)
				return true
			else 
				|return false
		''')
	}

	def void test_if_else_04() {
		'''
			var x = 0
			if (x == 1)
				return true
			else {|return false}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1)
				return true
			else {
				|return false}
		''')
	}

	def void test_if_else_05() {
		'''
			var x = 0
			if (x == 1)
				return true
			else| {return false}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1)
				return true
			else
			|{return false}
		''')
	}

	def void test_if_else_06() {
		'''
			var x = 0
			if (x == 1)
				return true
			|else {return false}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1)
				return true
			
			|else {return false}
		''')
	}

	def void test_if_else_07() {
		'''
			var x = 0
			if (x == 1)
				return true|
			else {return false}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			if (x == 1)
				return true
			|
			else {return false}
		''')
	}

	def void test_switch_default_01() {
		'''
			var x = 0
			switch x {
				default:|
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				default:
					|
			}
		''')
	}

	def void test_switch_default_02() {
		'''
			var x = 0
			switch x {
				default|:
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				default
				|:
			}
		''')
	}

	def void test_switch_default_03() {
		'''
			var x = 0
			switch x {
				default| :
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				default
				|:
			}
		''')
	}

	def void test_switch_default_04() {
		'''
			var x = 0
			switch x {
				default |:
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				default 
				|:
			}
		''')
	}

	def void test_switch_default_05() {
		'''
			var x = 0
			switch x {
				default:|return true
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				default:
					|return true
			}
		''')
	}

	def void test_switch_default_06() {
		'''
			var x = 0
			switch x {
				|default:return true
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				
				|default:return true
			}
		''')
	}

	def void test_switch_default_07() {
		'''
			var x = 0
			switch x {|
				default:return true
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				|
				default:return true
			}
		''')
	}

	def void test_switch_case_01() {
		'''
			var x = 0
			switch x {
				case 1:|
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				case 1:
					|
			}
		''')
	}

	def void test_switch_case_02() {
		'''
			var x = 0
			switch x {
				case 1:|return true
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				case 1:
					|return true
			}
		''')
	}

	def void test_switch_case_03() {
		'''
			var x = 0
			switch x {
				case 1: {|return true}
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				case 1: {
					|return true}
			}
		''')
	}

	def void test_switch_case_04() {
		'''
			var x = 0
			switch x {
				case 1: {|}
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				case 1: {
					|
				}
			}
		''')
	}

	def void test_switch_case_05() {
		'''
			var x = 0
			switch x {
				case| 1: {}
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				case
				|1: {}
			}
		''')
	}

	def void test_switch_case_06() {
		'''
			var x = 0
			switch x {
				|case 1: {}
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				
				|case 1: {}
			}
		''')
	}

	def void test_switch_case_07() {
		'''
			var x = 0
			switch x {|
				case 1: {}
			}
		'''.assertAutoIndentOnNewLine(
		'''
			var x = 0
			switch x {
				|
				case 1: {}
			}
		''')
	}

	def void test_for_01() {
		'''
			var values = <String>newArrayList
			for (value : values)|
		'''.assertAutoIndentOnNewLine(
		'''
			var values = <String>newArrayList
			for (value : values)
				|
		''')
	}

	def void test_for_02() {
		'''
			var values = <String>newArrayList
			var result = 0
			for (value : values)|result += value.length
			result
		'''.assertAutoIndentOnNewLine(
		'''
			var values = <String>newArrayList
			var result = 0
			for (value : values)
				|result += value.length
			result
		''')
	}

	def void test_for_03() {
		'''
			var values = <String>newArrayList
			var result = 0
			for (value : values) {|result += value.length}
			result
		'''.assertAutoIndentOnNewLine(
		'''
			var values = <String>newArrayList
			var result = 0
			for (value : values) {
				|result += value.length}
			result
		''')
	}

	def void test_for_04() {
		'''
			var values = <String>newArrayList
			var result = 0
			for| (value : values) {result += value.length}
			result
		'''.assertAutoIndentOnNewLine(
		'''
			var values = <String>newArrayList
			var result = 0
			for
			|(value : values) {result += value.length}
			result
		''')
	}

	def void test_for_05() {
		'''
			var values = <String>newArrayList
			var result = 0
			|for (value : values) {result += value.length}
			result
		'''.assertAutoIndentOnNewLine(
		'''
			var values = <String>newArrayList
			var result = 0
			
			|for (value : values) {result += value.length}
			result
		''')
	}

	def void test_for_06() {
		'''
			var values = <String>newArrayList
			var result = 0|
			for (value : values) {result += value.length}
			result
		'''.assertAutoIndentOnNewLine(
		'''
			var values = <String>newArrayList
			var result = 0
			|
			for (value : values) {result += value.length}
			result
		''')
	}

	def void test_basic_for_01() {
		'''
			for (;;)|
		'''.assertAutoIndentOnNewLine(
		'''
			for (;;)
				|
		''')
	}

	def void test_basic_for_02() {
		'''
			for (var i = 0;;) |i++
		'''.assertAutoIndentOnNewLine(
		'''
			for (var i = 0;;) 
				|i++
		''')
	}

	def void test_basic_for_03() {
		'''
			for (var i = 0;;) {|i++}
		'''.assertAutoIndentOnNewLine(
		'''
			for (var i = 0;;) {
				|i++}
		''')
	}

	def void test_basic_for_04() {
		'''
			for (var i = 0;;)| {i++}
		'''.assertAutoIndentOnNewLine(
		'''
			for (var i = 0;;)
			|{i++}
		''')
	}

	def void test_basic_for_05() {
		'''
			println('Hello World')
			|for (var i = 0;;) {i++}
		'''.assertAutoIndentOnNewLine(
		'''
			println('Hello World')
			
			|for (var i = 0;;) {i++}
		''')
	}

	def void test_basic_for_06() {
		'''
			println('Hello World')|
			for (var i = 0;;) {i++}
		'''.assertAutoIndentOnNewLine(
		'''
			println('Hello World')
			|
			for (var i = 0;;) {i++}
		''')
	}

	def void test_while_01() {
		'''
			var i = 0
			while (i < 10)|
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 0
			while (i < 10)
				|
		''')
	}

	def void test_while_02() {
		'''
			var i = 0
			while (i < 10)|i++
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 0
			while (i < 10)
				|i++
		''')
	}

	def void test_while_03() {
		'''
			var i = 0
			|while (i < 10)i++
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 0
			
			|while (i < 10)i++
		''')
	}

	def void test_while_04() {
		'''
			var i = 0|
			while (i < 10)i++
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 0
			|
			while (i < 10)i++
		''')
	}

	def void test_do_while_01() {
		'''
			var i = 0
			do|
			while (i < 10)
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 0
			do
				|
			while (i < 10)
		''')
	}

	def void test_do_while_02() {
		'''
			var i = 0
			do |i++
			while (i < 10)
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 0
			do 
				|i++
			while (i < 10)
		''')
	}

	def void test_do_while_03() {
		'''
			var i = 0
			do {|i++}
			while (i < 10)
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 0
			do {
				|i++}
			while (i < 10)
		''')
	}

	def void test_do_while_04() {
		'''
			var i = 0
			|do {i++}
			while (i < 10)
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 0
			
			|do {i++}
			while (i < 10)
		''')
	}

	def void test_do_while_05() {
		'''
			var i = 0|
			do {i++}
			while (i < 10)
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 0
			|
			do {i++}
			while (i < 10)
		''')
	}

	def void test_var_declaration_01() {
		'''
			var i = |
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 
				|
		''')
	}

	def void test_var_declaration_02() {
		'''
			var i = {|}
		'''.assertAutoIndentOnNewLine(
		'''
			var i = {
				|
			}
		''')
	}

	def void test_var_declaration_03() {
		'''
			var i = |1
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 
				|1
		''')
	}

	def void test_var_declaration_04() {
		'''
			var i = {|1}
		'''.assertAutoIndentOnNewLine(
		'''
			var i = {
				|1}
		''')
	}

	def void test_var_declaration_05() {
		'''
			println('Hello World')
			|var i = {1}
		'''.assertAutoIndentOnNewLine(
		'''
			println('Hello World')
			
			|var i = {1}
		''')
	}

	def void test_var_declaration_06() {
		'''
			println('Hello World')|
			var i = {1}
		'''.assertAutoIndentOnNewLine(
		'''
			println('Hello World')
			|
			var i = {1}
		''')
	}

	def void test_throw_01() {
		'''
			throw |
		'''.assertAutoIndentOnNewLine(
		'''
			throw 
				|
		''')
	}

	def void test_throw_02() {
		'''
			throw {|}
		'''.assertAutoIndentOnNewLine(
		'''
			throw {
				|
			}
		''')
	}

	def void test_throw_03() {
		'''
			throw |new java.lang.IllegalStateException
		'''.assertAutoIndentOnNewLine(
		'''
			throw 
				|new java.lang.IllegalStateException
		''')
	}

	def void test_throw_04() {
		'''
			throw {|new java.lang.IllegalStateException}
		'''.assertAutoIndentOnNewLine(
		'''
			throw {
				|new java.lang.IllegalStateException}
		''')
	}

	def void test_throw_05() {
		'''
			throw| {new java.lang.IllegalStateException}
		'''.assertAutoIndentOnNewLine(
		'''
			throw
			|{new java.lang.IllegalStateException}
		''')
	}

	def void test_throw_06() {
		'''
			println('Hello World')
			|throw {new java.lang.IllegalStateException}
		'''.assertAutoIndentOnNewLine(
		'''
			println('Hello World')
			
			|throw {new java.lang.IllegalStateException}
		''')
	}

	def void test_throw_07() {
		'''
			println('Hello World')|
			throw {new java.lang.IllegalStateException}
		'''.assertAutoIndentOnNewLine(
		'''
			println('Hello World')
			|
			throw {new java.lang.IllegalStateException}
		''')
	}

	def void test_return_01() {
		'''
			return |
		'''.assertAutoIndentOnNewLine(
		'''
			return 
				|
		''')
	}

	def void test_return_02() {
		'''
			return {|}
		'''.assertAutoIndentOnNewLine(
		'''
			return {
				|
			}
		''')
	}

	def void test_return_03() {
		'''
			return |1
		'''.assertAutoIndentOnNewLine(
		'''
			return 
				|1
		''')
	}

	def void test_return_04() {
		'''
			return {|1}
		'''.assertAutoIndentOnNewLine(
		'''
			return {
				|1}
		''')
	}

	def void test_return_05() {
		'''
			println('Hello World')|
			return
		'''.assertAutoIndentOnNewLine(
		'''
			println('Hello World')
			|
			return
		''')
	}

	def void test_return_06() {
		'''
			println('Hello World')
			|return
		'''.assertAutoIndentOnNewLine(
		'''
			println('Hello World')
			
			|return
		''')
	}

	def void test_try_01() {
		'''
			try|
		'''.assertAutoIndentOnNewLine(
		'''
			try
				|
		''')
	}

	def void test_try_02() {
		'''
			try {|}
		'''.assertAutoIndentOnNewLine(
		'''
			try {
				|
			}
		''')
	}

	def void test_try_03() {
		'''
			try |return 1
		'''.assertAutoIndentOnNewLine(
		'''
			try 
				|return 1
		''')
	}

	def void test_try_04() {
		'''
			try {|return 1}
		'''.assertAutoIndentOnNewLine(
		'''
			try {
				|return 1}
		''')
	}

	def void test_try_05() {
		'''
			try| {return 1}
		'''.assertAutoIndentOnNewLine(
		'''
			try
			|{return 1}
		''')
	}

	def void test_try_06() {
		'''
			println('Hello World')
			|try {return 1}
		'''.assertAutoIndentOnNewLine(
		'''
			println('Hello World')
			
			|try {return 1}
		''')
	}

	def void test_try_07() {
		'''
			println('Hello World')|
			try {return 1}
		'''.assertAutoIndentOnNewLine(
		'''
			println('Hello World')
			|
			try {return 1}
		''')
	}

	def void test_catch_01() {
		'''
			try
				return 1
			catch (Exception e)|
		'''.assertAutoIndentOnNewLine(
		'''
			try
				return 1
			catch (Exception e)
				|
		''')
	}

	def void test_catch_02() {
		'''
			try
				return 1
			catch (Exception e) {|}
		'''.assertAutoIndentOnNewLine(
		'''
			try
				return 1
			catch (Exception e) {
				|
			}
		''')
	}

	def void test_catch_03() {
		'''
			try
				return 1
			catch (Exception e)|return 2
		'''.assertAutoIndentOnNewLine(
		'''
			try
				return 1
			catch (Exception e)
				|return 2
		''')
	}

	def void test_catch_04() {
		'''
			try
				return 1
			catch (Exception e) {|return 2}
		'''.assertAutoIndentOnNewLine(
		'''
			try
				return 1
			catch (Exception e) {
				|return 2}
		''')
	}

	def void test_catch_05() {
		'''
			try
				return 1
			catch| (Exception e) {return 2}
		'''.assertAutoIndentOnNewLine(
		'''
			try
				return 1
			catch
			|(Exception e) {return 2}
		''')
	}

	def void test_catch_06() {
		'''
			try
				return 1
			|catch (Exception e) {return 2}
		'''.assertAutoIndentOnNewLine(
		'''
			try
				return 1
			
			|catch (Exception e) {return 2}
		''')
	}

	def void test_catch_07() {
		'''
			try
				return 1|
			catch (Exception e) {return 2}
		'''.assertAutoIndentOnNewLine(
		'''
			try
				return 1
			|
			catch (Exception e) {return 2}
		''')
	}

	def void test_finally_01() {
		'''
			try
				return 1
			finally|
		'''.assertAutoIndentOnNewLine(
		'''
			try
				return 1
			finally
				|
		''')
	}

	def void test_finally_02() {
		'''
			try
				return 1
			finally {|}
		'''.assertAutoIndentOnNewLine(
		'''
			try
				return 1
			finally {
				|
			}
		''')
	}

	def void test_finally_03() {
		'''
			var i = 1
			try
				return 1
			finally |i = 1
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 1
			try
				return 1
			finally 
				|i = 1
		''')
	}

	def void test_finally_04() {
		'''
			var i = 1
			try
				return 1
			finally {|i = 1}
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 1
			try
				return 1
			finally {
				|i = 1}
		''')
	}

	def void test_finally_05() {
		'''
			var i = 1
			try
				return 1
			finally| {i = 1}
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 1
			try
				return 1
			finally
			|{i = 1}
		''')
	}

	def void test_finally_06() {
		'''
			var i = 1
			try
				return 1
			|finally {i = 1}
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 1
			try
				return 1
			
			|finally {i = 1}
		''')
	}

	def void test_finally_07() {
		'''
			var i = 1
			try
				return 1|
			finally {i = 1}
		'''.assertAutoIndentOnNewLine(
		'''
			var i = 1
			try
				return 1
			|
			finally {i = 1}
		''')
	}

	def void test_synchronized_01() {
		'''
			val lock = new Object
			synchronized(lock)|
		'''.assertAutoIndentOnNewLine(
		'''
			val lock = new Object
			synchronized(lock)
				|
		''')
	}

	def void test_synchronized_02() {
		'''
			val lock = new Object
			synchronized(lock) {|}
		'''.assertAutoIndentOnNewLine(
		'''
			val lock = new Object
			synchronized(lock) {
				|
			}
		''')
	}

	def void test_synchronized_03() {
		'''
			val lock = new Object
			synchronized(lock) |return true
		'''.assertAutoIndentOnNewLine(
		'''
			val lock = new Object
			synchronized(lock) 
				|return true
		''')
	}

	def void test_synchronized_04() {
		'''
			val lock = new Object
			synchronized(lock) {|return true}
		'''.assertAutoIndentOnNewLine(
		'''
			val lock = new Object
			synchronized(lock) {
				|return true}
		''')
	}

	def void test_synchronized_05() {
		'''
			val lock = new Object
			synchronized(lock)| {return true}
		'''.assertAutoIndentOnNewLine(
		'''
			val lock = new Object
			synchronized(lock)
			|{return true}
		''')
	}

	def void test_synchronized_06() {
		'''
			val lock = new Object
			|synchronized(lock) {return true}
		'''.assertAutoIndentOnNewLine(
		'''
			val lock = new Object
			
			|synchronized(lock) {return true}
		''')
	}

	def void test_synchronized_07() {
		'''
			val lock = new Object|
			synchronized(lock) {return true}
		'''.assertAutoIndentOnNewLine(
		'''
			val lock = new Object
			|
			synchronized(lock) {return true}
		''')
	}

}
