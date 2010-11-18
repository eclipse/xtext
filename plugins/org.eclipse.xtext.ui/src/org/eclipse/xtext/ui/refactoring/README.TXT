Refactoring steps:

1) Find element declaration
2) Change element's name (hook)
3) Find xrefs to element
4) Change xrefs to element using crossref serializer
5) Find elements whose name dependends on renamed element
6) Change xrefs to dependent elements using crossref serializer
 
Validation: 
- Resources could have errors before 
- Names are unique must be separated form plain validation.

Initial simplifications
- Refactorings are language local, i.e. I can simply have components injected


Problems
- StatefulReourceDecription does not provide references, even on demand


TODO
- dependent elements
- tests
- handle xrefs form unsaved resources

- lazily load/ realease files
- cache IRefactoringDocuments
