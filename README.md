# PTUT4A

In order to run the project, two aspects are to manage : the front-end is running thanks to VueJS (https://vuejs.org). An installation
with the npm manager is mandatory. Thought, at the moment, no front-end is needed because everything is not working on backend, leading
to the aspects that only the backend is needed.

The backend is using Java Springboot. Dependencies must be installed thanks to a JAVA IDE (we used Netbeans).
Then there are functions that can be run in the App.java, main file of the program.

At the moment, the algorithm of classification is working, making a prediction on which disease the patient have.
We also created classes for the logic, allowing to create new symptoms, diseases, patients, etc.

But this must be changed, in order to use SWRL logic, and to make display in the front-end aspect.
For the BPMN generation on VueJS side, multiples possibilities : 
  - Generating an XML on the backend and then interpretating it on the front-end side.
  - Dynamically generating it without new file via VUeJS and a BPMN library.
 
Possible sources for VueJS BPMN :
  - https://github.com/bpmn-io/bpmn-js
  - https://github.com/ProcessMaker/modeler
  - https://github.com/bpmn-io/vue-bpmn
  
 Many things are still to be done, since we encountered many issues and were urge by the time. But many business aspect as be done,
 with definition and classification of diseases symptoms in tables, adds in ontology, UI/UX design, etc.
 
