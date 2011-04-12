package xtend.tutorial.basics

import xtend.tutorial.util.Person

class Xtend11_PersonExtensions {
	
	fullName(Person p) {
		p.forename +" "+ p.name
	}	
}