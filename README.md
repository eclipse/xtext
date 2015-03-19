# Xtext

Xtext is a framework for development of programming languages and domain specific languages. It covers all aspects of a complete language infrastructure, from parsers, over linker, compiler or interpreter to fully-blown top-notch Eclipse IDE integration. It comes with great defaults for all these aspects, which at the same time can be easily tailored to your individual needs.

More information: [xtext.org](http://xtext.org) (source maintained [in the *xtext-website* subfolder](xtext-website/))

## Xtend

In addition to Xtext, this repository also hosts the Xtend programming language. Xtend is a flexible and expressive dialect of Java that compiles into readable Java 5 compatible source code. You can use any existing Java library seamlessly. The compiled output is readable and pretty-printed, and tends to run as fast as the equivalent handwritten Java code. Become productive and write beautiful code with powerful macros, lambdas, operator overloading, and many more modern language features.

More information: [xtend-lang.org](http://xtend-lang.org) (source maintained [in the *xtend-website* subfolder](xtend-website/))

## How to Contribute

The Xtext project accepts normal [GitHub pull requests](https://help.github.com/categories/collaborating/). Before your contribution can be accepted by the project, you need to create and electronically sign the [Eclipse Foundation Contributor License Agreement (CLA)](https://wiki.eclipse.org/CLA). Furthermore, all commits have to be signed off (`git commit -s`).

As a subproject of Eclipse, Xtext uses [Bugzilla](https://bugs.eclipse.org/bugs/) to track ongoing development and issues (GitHub Issues are *not* used). In Bugzilla you can

- [search for existing bug reports](https://bugs.eclipse.org/bugs/buglist.cgi?product=TMF&product=Xtend),
- [create a new bug report](https://bugs.eclipse.org/bugs/enter_bug.cgi?product=TMF).

More information: [projects.eclipse.org](http://projects.eclipse.org/projects/modeling.tmf.xtext/developer)

## How to Build an Xtext p2 repository

Xtext is build with [buckminster] (http://wiki.eclipse.org/index.php/Buckminster_Project). You can run the full Xtext build on your machine using an [ant script](releng/org.eclipse.xtext.releng/releng/ant/xtext-build.ant).

in eclipse:
 - launch the /org.eclipse.xtext.releng/local-xtext-build.launch file.

in terminal:
 - From the xtext git repository root
   
   ```cd releng/org.eclipse.xtext.releng/releng/ant/```
 - Run xtext-build.ant script
   
   ```ant -f xtext-build.ant ```
