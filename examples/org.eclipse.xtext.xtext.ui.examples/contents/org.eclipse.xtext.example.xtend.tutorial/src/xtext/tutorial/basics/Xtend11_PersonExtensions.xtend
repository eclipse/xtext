package xtext.tutorial.basics

import xtext.tutorial.util.Person

class Xtend11_PersonExtensions {
	
	fullName(Person p) {
		p.forename +" "+ p.name
	}	
}