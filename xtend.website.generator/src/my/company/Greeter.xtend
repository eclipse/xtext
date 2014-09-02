
	package my.company
 
	import java.util.List

	class Greeter {
	
		def public void greetBunchOfPeople(List<String> people) {
  			for(String name : people) {
				println(sayHello(name));
			}
		}
	
		def public String sayHello(String personToGreet) {
			return "Hello "+personToGreet+"!";
		}
	}


