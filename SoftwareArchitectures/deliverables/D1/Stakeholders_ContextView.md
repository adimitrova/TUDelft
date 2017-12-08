# Stakeholders analysis

Everyday users of Jupyter notebook are most affected by the system architecture of Jupyter Notebook, namely developers who use it in their everyday projects as well as users who learn or exercise with [Python](https://www.python.org/), [R](https://www.r-project.org/) or [Julia](http://julialang.org/) in Jupyter environment. Furthermore, important stakeholders are the ones directly involved in the development process, i.e. cutting edge scientists, dynamic developers who construct and deploy the system together with the ones who maintain it. As this is an open-source project we should also refer to the contributors who work on the project too by proposing improvements or fixing bugs via pull requests to the project owners. These open-source community users are important stakeholder to help advance the project.

From the analyzed issues and pull requests it is visible that the above mentioned stakeholders and specifically the Open Source Community (OSC) stakeholders have three main types of suggestions towards the project:

- Bug fix
- Feature requests & fixes
- Documentation & current architecture improvements

# Issue analysis
We try to achieve diversity of terms of types of issues we review, so that we can show what do developers have to deal with on a daily basis. Issues like bugs, feature requests, improvements for documentation and for the product in general, are selected. Issues, open for general questions, are not taken into consideration as they are simply answered and closed. Further analysis of each of these issues and relevant stakeholders follow below.

## 1) jupyter notebook opens one of my R codes with python kernel ([#2212](https://github.com/jupyter/notebook/issues/2212))
### Summary
Jupyter opens R with Python kernel instead of R kernel. 

### Stakeholder type(s)
The user who opened the issue ([@yasharz](https://github.com/yasharz)) is not active on Git, however they seem to have issue compiling their code properly due to the Python kernel starting up instead of the R kernel. We could assume the user belongs to the most affected stakeholder class, namely the **Users** class.
	
### Stakeholder interest & influence
[@yasharz](https://github.com/yasharz) seems to have interest in the product and would like to work with it, hence trying to help fix unexpected behaviour. The issue is marked as **no action** as it's missing the details needed to troubleshoot the issue.

## 2) Equations line breaking problem in table ([#2217](https://github.com/jupyter/notebook/issues/2217))

### Summary
Table formulas show incorrectly in Safari & Firefox
### Stakeholder type(s)
The stakeholder ([@shanhaiying](https://github.com/shanhaiying)) belongs to the **Users** stakeholder class. 
### Stakeholder interest & influence
The user seems to be moderately active on Github and uses Jupyter and seems to report about issues or bugs they have with the product. In this case the user is trying to improve the system by advising developers for browser compatibility issue they experience.

## 3) The asterisk for "busy cell" is ambiguous ([#2216](https://github.com/jupyter/notebook/issues/2216))
### Summary
The asterisk showing when excecuting code is ambiguous.
>This ambiguity makes it hard to handle notebooks with cells that take some time to execute and are sometimes queued or interrupted. It's hard to understand the current execution status. Often I find myself returning to a notebook and not remembering if the cell is still executing or not.

### Stakeholder type(s)
The stakeholder ([@ymost](https://github.com/ymost)) is also in this case from the class **Users**, i.e. directly affected by a problem in the system. 

### Stakeholder interest & influence
The user has no particular issue per se, but is trying to improve the system by advising developers that they get confused by the asterisk which can mean one of the following:

> (1) The cell is currently executing.
> (2) An "execute" command was sent to the cell, but another cell is currently executing. The cell will execute when its turn comes.
> (3) The kernel was interrupted / restarted while the cell was executing, it is currently not executing.

Unfortunately the user is advised that this is an architecture issue and for the moment they cannot do much about it. Regarding point (3) developers advise this is a bug, but hard to fix.

## 4) Document the IPython.notebook.kernel.execute function ([#2219](https://github.com/jupyter/notebook/issues/2219))
### Summary
Jupyter.notebook.kernel.execute() command is useful in a JavaScript cell for [D3](https://d3js.org/) and other purposes.
### Stakeholder type(s)
The user ([@alexgarel](https://github.com/alexgarel)) contributes to Python projects and seems to be proficient in this language. They fall into the **OSC contributers** class.
### Stakeholder interest & influence
The influence the user is trying to achieve here is improvement of documentation by including a useful feature they found about. That issue hasn't been looked at yet.

## 5) R Kernel Dies with loading packages via library() ([#2200](https://github.com/jupyter/notebook/issues/2200))
### Summary
R kernel crashing when loading certain libraries.
### Stakeholder type(s)
The user who reported this issue ([@DevinRouth](https://github.com/DevinRouth)) is a scientist and seem to use the Jupyter environment regarding projects they work on in the field of statistics and cloud computing. This user falls into the **User** stakeholder class.
### Stakeholder interest & influence
The influence is supposed to be a fix for potentially critical bug for some users. The issue is being currently investigated. 

## 6) Terminal background wrong size until resized ([#2172](https://github.com/jupyter/notebook/issues/2172))
### Summary
Terminal background missing until the terminal get resized
### Stakeholder type(s)
The person who opened the issue ([@takluyver](https://github.com/takluyver)) is one of the project developers, i.e. this user belongs to the **Developers** stakeholder class.
### Stakeholder interest & influence
Their aim is to fix unexpected behaviour which even they are not sure how that occured, so they are looking for ideas by their colleagues on how to reproduce and fix the issue.

## 7) [#2141](https://github.com/jupyter/notebook/issues/2141), [#1508](https://github.com/jupyter/notebook/issues/1508), [#1992](https://github.com/jupyter/notebook/issues/1992), [#1797](https://github.com/jupyter/notebook/issues/1797), [#1706](https://github.com/jupyter/notebook/issues/1706)
### Summary
Inconsistencies between nbextensions and server extensions. 
> The problem is that these create "shared" configuration information that causes problems when I then run Jupyter from inside a Conda environment where those extensions are not installed. 

### Stakeholder type(s)
This issue has been reported by many people from the **OSC** & **Users** stakeholder classes

### Stakeholder interest & influence

Developers are looking for a way to fix these inconsistencies and in issue [#1706](https://github.com/jupyter/notebook/issues/1706) they propose a solution:
>One of the main issues is with package management since extension enabling consists in modifying a configuration file, which is not a thing package managers do well - and we would like switch to a configuration mechanism where each extension would simply add a file into a directory to be picked up by the application. 

All stakeholders involved aim to fix an issue which occurs for many of them and needs a major reconstruction of the way extensions work at the moment. 

## 8) Clear the one-time token from the URL when the notebook is launched ([#2127](https://github.com/jupyter/notebook/issues/2127))
### Summary
One-time-pad in the URL of the notebook launch screen is confusing.
### Stakeholder type(s)
The user ([@jasongrout](https://github.com/jasongrout)) proposing the token to be removed belongs to the "Developers" stakeholder class.
### Stakeholder interest & influence
They propose the one-time token query to be removed from the pages as it confuses people. The contribution aim in this case is enhancement.

## 9) Make "Find and Replace" cell only by default? ([#2115](https://github.com/jupyter/notebook/issues/2115))
### Summary
User requests the "Find & Replace" option to be the default option.
### Stakeholder type(s)
The user ([@Jessime](https://github.com/Jessime)) is a PhD in Bioinformatics and maybe uses the Jupyter environment for projects related to their doctorate.
### Stakeholder interest & influence
The aim of the issue is for the user to request a feature. The request has been scheduled as TODO and closed. The issue has been later solved under [#2131](https://github.com/jupyter/notebook/issues/2131).

## 10) Deleting multiple files in file browser errors  ([#2206](https://github.com/jupyter/notebook/issues/2206))
### Summary
Getting errors when trying to delete multiple files from the file browser. One file deletion works fine. 
### Stakeholder type(s)
The user who opened this issue ([@Jessime](https://github.com/Jessime)) seems to contribute by opening pull requests to Jupyter and iPython. We could classify them as part of the "OSC" Stakeholder class.
### Stakeholder interest & influence
The user is asking for a basic function, namely to delete many files at once, instead of one by one. Issue is marked as Bug and fixed in [#2211](https://github.com/jupyter/notebook/issues/2211).


# Pull requests analysis
In this section we include an analysis of recently opened and closed pull requests. The pull requests are chosen in such a way that will help us gain useful insights in the **notebook** project and also in the stakeholders that are involved in it. We try with the chosen pull requests not only to identify some recent major changes of Jupyter Notebook but also to recognize different types of stakeholders.

In particular, for every pull request we identify the stakeholders that are involved along with their role in the project. Moreover, we give a brief summary for each pull request, possibly along with some interesting facts. 

## 1) Restore `npm run build:watch` ([#2095](https://github.com/jupyter/notebook/pull/2095))

*Merged at Jan 31, 2017*

This pull request was created by [@minrk](https://github.com/minrk) and merged by [@blink1073](https://github.com/blink1073). This pull request restored the command `npm run build:watch` which helps developers during development to automatically rebuild JavaScript and LESS sources as they are modified. Furthermore, this merge closed the issue [#1641](https://github.com/jupyter/notebook/issues/1641) that was created by an external developer during their try to set up a local development installation.

### Stakeholders:

| Username                                  |  Type              |
| -------------                             |----------------	   | 
| [@minrk](https://github.com/minrk)        | core developer	   |
| [@blink1073](https://github.com/blink1073)| core developer	   | 
| [@Anne623](https://github.com/Anne623) 	  | external contributor |


## 2) Fix for uploading large files crashing the browser ([#2162](https://github.com/jupyter/notebook/pull/2162))

*Opened at Feb 7, 2017*

[@blackrock-engineering](https://github.com/blackrock-engineering) opened a pull request that fixes the bug [#96](https://github.com/jupyter/notebook/issues/96). The problem occurs when a user tries to upload a file that is larger than 35mb. In particular, the browser tab will crash about 5 seconds after clicking "Upload" Behind the 
[@blackrock-engineering](https://github.com/blackrock-engineering) account is a company called BlackRock as mentioned by [@daniel1124](https://github.com/jupyter/notebook/issues/96) in comments section of issue [#96](https://github.com/jupyter/notebook/issues/96). This PR is reviewed and discussed by multiple core developers such as [@blink1073](https://github.com/blink1073), [@takluyver](https://github.com/takluyver), [@Carreau](https://github.com/Carreau), [@rgbkrk](https://github.com/rgbkrk).
 
### Stakeholders:

| Username                                  |  Type              |
| -------------                             |----------------	   | 
| [@takluyver](https://github.com/takluyver)| core developer	   |
| [@Carreau](https://github.com/Carreau)	| core developer	   | 
| [@blink1073](https://github.com/blink1073)| core developer	   | 
| [@rgbkrk](https://github.com/rgbkrk)		| core developer	   | 
| [@blackrock-engineering](https://github.com/blackrock-engineering) 	| external team of developers who work in a company that may uses Jupyter notebook for their own purposes |

## 3) enable token-authentication by default ([#1831](https://github.com/jupyter/notebook/pull/1831))


*Merged at Nov 16, 2016*

This pull request was opened by [@minrk](https://github.com/minrk) and reviewed by [@takluyver](https://github.com/takluyver), [@damianavila](https://github.com/damianavila), [@rgbkrk](https://github.com/rgbkrk). At the PR discussion many members of Jupyter's steering council take part such as [@parente](https://github.com/parente), 
[@ellisonbg](https://github.com/ellisonbg). This is because the activation of token-based authentication by default was one of the biggest changes in Jupyter Notebook *4.3* release. Several of the security issues that notebook had over the years would have been avoided if the notebook ran with authentication by default.

### Stakeholders:

| Username                                  |  Type              |
| -------------                             |----------------	   | 
| [@minrk](https://github.com/minrk)		| core developer	   |
| [@damianavila](https://github.com/damianavila)| core developer	| 
| [@rgbkrk](https://github.com/rgbkrk)		| core developer	   | 
| [@takluyver](https://github.com/takluyver)| core developer	   |

## 4) Merge nbserver_extensions ([#2108](https://github.com/jupyter/notebook/pull/2108))

*Merged at Feb 2, 2017*

[@minrk](https://github.com/minrk) open this PR that fixes the bug [#2063](https://github.com/jupyter/notebook/issues/2063). The bug was reported by the user [@jbeezley](https://github.com/jbeezley) and reviewed by @[takluyver](https://github.com/takluyver), [@Carreau](https://github.com/Carreau). More specific, the user identified that server extensions did not load when they were installed in different locations.
### Stakeholders:

| Username                                  |  Type              |
| -------------                             |----------------	   | 
| [@takluyver](https://github.com/takluyver)| core developer	   |
|[@Carreau](https://github.com/Carreau)	| core developer	   | 
| [@minrk](https://github.com/minrk)		| core developer	   |
|[@jbeezley](https://github.com/jbeezley)	| user				   | 

## 5) Add output callback overrides ([#1958](https://github.com/jupyter/notebook/pull/1958))

*Merged at Dec 9, 2016*

The contribution of this pull request is twofold. First, it allows the override of output callbacks to redirect output messages and secondly it fixes an async bug in message handling. In this PR two more members of Jupyter's steering council are involved, [@jasongrout](https://github.com/jasongrout) who opened the PR and [@ivanov](https://github.com/ivanov) who reviewed it.
### Stakeholders:

| Username                                  |  Type              |
| -------------                             |----------------	   | 
| [@jasongrout](https://github.com/jasongrout)| core developer	   |
| [@ivanov](https://github.com/ivanov)	| core developer	   | 


## 6) Remove token query parameter from pages on load ([#2128](https://github.com/jupyter/notebook/pull/2128))

*Merged at Feb 6, 2017*

This PR aims to remove the one-time token query from the pages as it confuses people. This enhancement was proposed by [@jasongrout](https://github.com/jasongrout) and implemented by 
[@minrk](https://github.com/minrk). Responsible for reviewing this PR were [@takluyver](https://github.com/takluyver) and [@blink1073](https://github.com/blink1073).

### Stakeholders:

| Username                                  |  Type              |
| -------------                             |----------------	   | 
| [@takluyver](https://github.com/takluyver)| core developer	   |
| [@blink1073](https://github.com/blink1073)| core developer	   | 
| [@jasongrout](https://github.com/jasongrout)	| core developer   | 
| [@minrk](https://github.com/minrk)		| core developer	   |

## 7) Apply find-and-replace to selected cells only by default. ([#2131](https://github.com/jupyter/notebook/pull/2131))

*Merged at Feb 7, 2017*

This pull request was opened by an external contributor and makes the "Find & Replace"option the default option to all cells. The same user is the one who proposed this functionality at the first place. This change got the approval and it was merged by the co-leader of Jupyter Notebook [@ellisonbg](https://github.com/ellisonbg).
### Stakeholders:

| Username                                  |  Type              |
| -------------                             |----------------	   | 
| [@ellisonbg](https://github.com/ellisonbg)| co-leader of Jupyter Notebook	   |
| [@Jessime](https://github.com/Jessime)	|  external contributor	   | 


## 8) Upgrade xterm.js to newly released 2.3.2 ([#2184](https://github.com/jupyter/notebook/pull/2184))

*Merged at Feb 13, 2017*

In this pull request we can see the collaboration between the development teams of two different projects: Jupyter Notebook and xterm.js which is a library that helps applications to provide fully featured terminals to their users. In particular, a problem occurred with the terminal background size when the development team of Jupyter upgraded xterm from 2.2.3 to 2.3.1 in Jupyter. [@takluyver](https://github.com/takluyver) reported this issue ([#539](https://github.com/sourcelair/xterm.js/issues/539)) to the development of xterm who responded quick and released a new release with a fix included for that bug.

### Stakeholders:

| Username                                  |  Type              |
| -------------                             |----------------	   | 
| [@takluyver](https://github.com/takluyver)| core developer	   |
| developement team of xterm.js project	| external development team	   | 
| [@blink1073](https://github.com/blink1073)| core developer	   | 


## 9) Adds edit and view buttons ([#1905](https://github.com/jupyter/notebook/pull/1905))


*Merged at Jan 30, 2017*

In this pull request the edit and view buttons were added to the file browser. Another core developer ([@gnestor](https://github.com/gnestor)) opened this pull request which was reviewed by [@takluyver](https://github.com/takluyver), [@minrk](https://github.com/minrk) and [@ivanov](https://github.com/ivanov).

### Stakeholders:

| Username                                  |  Type              |
| -------------                             |----------------	   | 
| [@takluyver](https://github.com/takluyver)| core developer	   |
| [@ivanov](https://github.com/ivanov)	| core developer	   | 
| [@minrk](https://github.com/minrk)| core developer	   | 
| [@gnestor](https://github.com/gnestor)		| core developer	   | 

## 10) Simple implementation of cell tags ([#2048](https://github.com/jupyter/notebook/pull/2048))

*Merged at Jan 30, 2017*

This pull request was created by an external contributor [@vidartf](https://github.com/vidartf) who implemented the user interface for adding cell tags. This functionality was first requested by another user ([@stevengj](https://github.com/stevengj)) of notebook who opened an issue ([#601](https://github.com/jupyter/notebook/issues/601)) asking for this feature. This basic implementation was finally merged by [@takluyver](https://github.com/takluyver).

### Stakeholders:

| Username                                  |  Type              |
| -------------                             |----------------	   | 
| [@takluyver](https://github.com/takluyver)| core developer	   |
| [@vidartf](https://github.com/vidartf)	| external developer | 
| [@stevengj](https://github.com/stevengj)  | user	   | 

# Integrators
Integrators play a very important role in the Open Source Software projects. They make sure that the quality of the project is high by carefully reviewing the pull requests, opening new issues such that new contributions can be made and discuss new features ([blog post by Georgios Gousios](http://www.gousios.gr/blog/How-do-project-owners-use-pull-requests-on-Github.html)). In the case our project the integrators are well defined. The institutional partners of Jupyter employ the [steering council members](http://jupyter.org/about). They consist of the most active project contributors. These members provide leadership, strategy and direction of the project and have the final decision. But these members are defined in the context of the whole Jupyter project. We analyzed the history of these members for the notebook repository to extract the important integrators only related to our project.

The following are the Members of the steering council, who are mostly involved in our project, listed in decreasing order according to their number of commits.
* Min Ragan-Kelley ([@minrk](https://github.com/minrk))
 He is the most active developer. He has reviewed more than twenty percent of the pull requests. However, he has created relatively small amount of issues.
* Jonathan Frederic ([@jdfreder](https://github.com/jdfreder))
He is mostly involved in contributing to the project. He has relatively small amount of issues or reviews. The issues he created concerns small changes of the project.
* Matthias Bussonier ([@carreau](https://github.com/carreau))
He is a core developer. He is very active in reviewing pull requests and specially helping new contributors. He has created a lot of issues, of which a lot are related to adding new features.
* Brian Granger ([@ellisonbg](https://github.com/ellisonbg))
He actively reviews different pull requests and comments on issues.  He has the third most line contribution in the project.

## Integrators' challenges

One of the main challenges that integrators have is to keep up with everything under control by monitoring and carefully analysing the pull requests. It is hard for the integrators to keep up with the large amount of external contributors and provide extensive guideness to them, while making contributing. For example [carreau](https://github.com/carreau) is very active in commenting and providing guidance to external contributors, hence he has less time to make contributions him self. Another challenge for the integrators, especially for [Min RK](https://github.com/minrk) as the coordinator, was the split of IPython into the different sub-projects.

Furthermore, the integrators are responsible for maintaining the quality of code and therefore guide new contributors on how they should contribute in the project. This is challenging because most of the time the pull requests are not rejected. Instead, they are providing with feedback the developers in order to improve their code and merge their proposed changes.

## Merge decision strategies

Based on our pull request analysis we can conclude that higher priority on merging PRs have those that fix an already existing bug. On the contrary, pull requests that introduce an enhancement can be postponed because it is likely to introduce a new bug. 

In general, the merge decisions are made through open community discussion and the Steering Council has the final hand if a consensus cannot be reached.

# Relevant people to contact

Based on the issue and pull request analysis we identified the following people that we would like to contact:

- [Steven Silvester](https://github.com/blink1073): Seems to be one of the main reviewers of our project. Thus, it would be interesting to contact him in order to understand the steps that are involved in his review process.
- [Min RK](https://github.com/minrk): In addition to being a member of Jupyter's steering council and the most active developer(in terms of number of commits and reviews), Min Ragan-Kelley is the one that coordinated in 2015 the split of IPython into the different sub-projects that are part of Jupyter. Therefore, we would like to ask him what were the biggest challenge at this big split.
- [Thomas Kluyver](https://github.com/takluyver): Thomas seem to be very knowledgeable and works on many different parts of the architecture of Jupyter Notebook and also works actively on issues. In case something is not what he deals with, he seems to know the person to refer to. Furthermore, his response time seem to be fast. Thus, we believe he is a reliable person to contact. 
- [Matthias Bussonnier](https://github.com/Carreau) He is the second person you'd most probably encounter if you open an issue for Jupyter. He takes care of issues as well as on different aspect of the product itseld, just like Thomas Kluyver and seem to know the architecture well. 

# Context View
![contextview](/images-team-jupyter/contextview.png)

The context view describes the dependencies, interactions and relationships between the system and its enviroment.

- **Programming languages**: Python (Backend), Javascript, HTML, CSS (Frontend)
- **Licensing & Copyright**: Shared copyright (each contributor has the copyright of his code), revised BSD license
- **Supported browsers**: Chrome, Firefox, Safari
- **Supported platforms**: Windows, *nix
- **Continuous integration**: Travis CI (Backend, *nix), Appveyor (Backend, Windows), Codecov (Code coverage)
- **Testing frameworks**: nosetests (Backend), PhantomJS, CasperJS (Frontend)
- **Dependencies**:
	- **Frontend**: Bootstrap, Backbone, BabelJS, MathJax
	- **Backend**: Jinja2, Tornado
- **Package managers**: Bower (Frontend), npm, pip (Backend)
- **Code quality**: ESLint (Javascript linting)
- **Sponsors**:
	- **Companies**: Google, Microsoft, rackspace, fastly
	- **Institutional partners**: Bloomberg, Berkeley University, Continuum analytics
- **Documentation**: Sphinx, readthedocs.io
- **Version control & Bug Tracking**: github.com
- **Communication**: Google Groups, Gitter, Stackoverflow #jupyter
- **Users**: Researchers, data scientists
- **Competitors**: Zeppelin, Beaker
