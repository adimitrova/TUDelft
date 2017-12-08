# Jupyter Notebook
![team_jupyter](/images-team-jupyter/team-jupyter.png)

### Abstract

With the increasing amount of unstructured raw data that scientists need to analyze and process, naturally they are looking into easy, convenient and intuitive ways to process it. Jupyter Notebook provides the perfect environment not only for scientists but also for learners and developers who work with Python, Julia, R and other programming languages. In this chapter the Jupyter Notebook project is analyzed in depth including the Stakeholders involved, the Context view, the system's architecture with Development and Functional analysis, the Evolution of the project and the Technical Debt analysis. This chapter is suitable to anyone who would like to get acquainted with project Jupyter Notebook.



*Table of Contents*

* [Introduction](#intro) - Done
* [Organization](#org)	- Done
	*  [Stakeholders](#stake)
	*  [Context View](#cont)
* [Architecture](#arch)	
	*  [Development Viewpoint](#dev) - Done
	*  [Functional Viewpoint](#fun)	- Todo
* [Evolution Perspective](#evo)	- Todo
* [Technical Debt](#debt) - Todo
* [Contributions](#contr) - Done
* [Conclusion](#concl)	- Todo
* [References](#ref)

### Plan of Action

The following chapters have been rewritten according to the feedback of the TA. We will adjust it according to the feedback form the other teams. They might also have to be shortened to respect the word limit, when all sections are done.
- **The Stakeholders**
- **The Context View**
- **The Development View**
- **The Contributions**

We have written a draft of **the abstract** and **the introduction** but it will be adjusted after we have finished all of the sections.

We are going to add **the functional view** to the chapter. This section will describe the different packages used by Jupyter notebook and the interactions between them during run-time.

**The evolution perspective** is the perfect fit for this project to gain more insights, because our project is a spin-off of IPython and is evolving towards a new project, namely Jupyter lab.
Due to our multiple pull-requests and discussions within it, we have a good relationship with the core developers.
Especially core developer [@carreau](https://github.com/Carreau) mentioned in a [discussion](https://github.com/jupyter/notebook/pull/2278) that he would be happy to answer our questions.
We are planning to interview him and ask for more details about the evolution of the project, more specifically the following:
- Details regarding the challenges when IPython was split.
- The progress on JupyterLab (the next generation of Jupyter Notebook).

On Monday 20th of March, we got the feedback from our TA regarding **technical debt**. We will add the plan of action for resolving the testing debt and add the debt evolution.

The conclusion will be written at the end when we have finished all the sections.

<div id="intro"></div>

## Introduction

Jupyter Notebook is an open-source web-application which allows the user to visualize the code in an effective way. The user is able to write and share code, result of the code execution, equations, explanations and visualizations.
It gives opportunity to process large amount of data and supports **Ju**lia, **Pyt**hon, **R** (origin of the name **Jupyter**) and many other programming languages. 
It is fast, intuitive, easy to install and use and thus, the perfect tool for scientists, programmers and learners. 

This project emerged from the growth of the IPython project in 2014. 
As IPython grew there were two major problems. First, the different components of it grew in different pace, so it did not make sense anymore to release all the components at the same time. Second, they wanted to support more programming languages. 
To solve this the IPython project was split in different sub-projects. 
All the language-agnostic code was moved to Jupyter while the python specific code was kept in IPython. Notebook is an imported sub-project of Jupyter.  

Notebook team consists of fifteen steering committee members who ultimately make the final decisions. All of them play the role of developers, maintainers, testers, supporters and are fully working on the open source project. As it is open-source, the team of Notebook welcomes any contributions to the project, especially bug fixes, new features and kernel developing. Kernels are what users need in order to work with different programming languages. 
This chapter overviews different aspects of the architecture of the system as well as a thorough analysis of the project including everything one needs to know it he/she wants to contribute to or understand the project.


<div id="org"></div>

## Organization
This section discuss the parties that are involved in the development, maintenance, testing and building of the system. These stakeholders are then visualized using a context-view diagram.

<div id="stake"></div>

### Stakeholders
Everyday users of Jupyter notebook are most affected by the system architecture of Jupyter Notebook, namely developers who use it in their everyday projects as well as users who learn or exercise with [Julia](http://julialang.org/), [Python](https://www.python.org/), [R](https://www.r-project.org/) and other languages in Jupyter environment. Furthermore, important stakeholders are the ones directly involved in the development process, i.e. cutting edge scientists, dynamic developers who construct and deploy the system together with the ones who maintain it. A number of different types of stakeholders exist as defined by Rozanski & Woods [[1](#rw)] and this section goes through them with a short explanation and explample, where possible. 

#### **Assessors**
As Jupyter Notebook's team consists of 15 developers, they are the people who oversee the conformance of the standards, in the case of Jupyter, this refers to programming standards. They are the ones responsible about handling pull requests and communicate them between each other to decide whether or not to merge them. Furthermore, they do the planning of future releases and/or sub-systems of the Notebook. 

#### **Communicators**
Communicators are people who explain the system and the architecture to other stakeholders via documentation or training materials. A number of general and training presentations are available online [[3](#data-science)],[[4](#ipy-jupyt)],[[5](#arch)], prepared and presented by Fernando Perez and Matthias Bussonier. Other than that, in Jupyter Notebook communicators are basically all the developers who throughout the process of development have also written the documentation. It is hard to find specific developers who mainly work on documentation as they are a small team and all of them update it when necessary. Documentation is necessary, because Notebook was previously part of IPython, but has separated and new users often seek information about system requirements, how to work with the Notebook etc. The documentation is useful as well for developers and contributors to the system and communicators are therefore an essential stakeholder for the Notebook system. 

#### **Developers**
Two major types of Developer stakeholders were identified in the open source project Jupyter Notebook: core and contributors, or also mentioned further down as Open Source Community (OSC).
* **Core**
Core developers work actively to write, fix, test and improve the system. Their main job is to also go through the open pull requests in their git repository and review them, communicate, ensure that what contributors propose is well tested and would not interfere with the current system in any way other than improving it. 
Developers focusing mainly on Notebook are Matthias Bussonnier [@carreau](https://github.com/carreau), Thomas Kluyver [@takluyver](https://github.com/takluyver), Jason Grout [@jasongrout](https://github.com/jasongrout), Kyle Kelley [@rgbkrk](https://github.com/rgbkrk), Min Ragan-Kelley [@minrk](https://github.com/minrk) and Steven Silvester [@blink1073](https://github.com/blink1073)
* **Open Source Community (OSC)**
Contributors are an important stakeholder for open source projects as often contributors solve issues the core team has no time for or implement a new feature making the product even better. OSC contributes also with documentation improvement and bug fixes. Not only this, but they can contribute by writing their own kernel supporting a new programming language or a new version of an already supported language. Vidar Tonaas Fauske [@vidartf](https://github.com/vidartf) and Yuvi Panda [yuvipanda](https://github.com/yuvipanda) are contributors with commits in Jupyter Notebook, JupyterLab, IPyWidgets and other projects in 2016-2017.

<div id="maint"></div>

#### **Maintainers** 
Jupyter Notebook's Code of Conduct advises that the **Steering Council** is the authority that takes decisions about further evolution of the project together with a NumFOCUS Subcommittee, consisting of four Council members and one external member.

> The Project will have a **Steering Council** that consists of Project Contributors who have produced contributions that are substantial in quality and quantity, and sustained over at least one year. The overall role of the Council is to ensure, through working with the BDFL (Benevolent Dictator for Life), in the face of Fernando Perez and taking input from the Community, the long-term well-being of the project, both technically and as a community.

> The Project is formally affiliated with the 501c3 [NumFOCUS Foundation](http://numfocus.org), which serves as its fiscal sponsor, may hold project trademarks and other intellectual property, helps manage project donations and acts as a parent legal entity. 

#### **Suppliers**
The user who is about to use Notebook needs to check and ensure he/she has the minimum system requirements. As per the book of Rozanski [[1](#rw)] suppliers are responsible to provide or build the software on which the system will be running. Notebook is a locally hosted application and thus, user needs to ensure he/she has the appropriate hardware and software (Python or Anaconda) necessary to run it. This does not stop here, however, as if the user needs certain programming language support, he/she also needs to install additional kernels for the purpose. 

#### **Support Staff**
As per the book of Rozanski & Woods [[1](#rw)] support staff are the people who provide support to the users for the product or system when it is running. Therefore Jupyter Notebook members taking care of issues in their git repository could be considered support staff. These users are usually Min Ragan-Kelley [@minrk](https://github.com/minrk) and Thomas Kluyver [@takluyver](https://github.com/takluyver). In case they are not sure about something, they know who to get involved. 

#### **Testers**
Testers are people who test the system to ensure it's suitable to use. Since the Notebook team consists of only fifteen core developers, each of them has to write tests whenever they implement new feature or improve current code. So in general all of them are also testers. However going through the project a few members were identified who wrote new or updated the old tests: Jonathan Frederic [@jdfreder](https://github.com/jdfreder) (no longer active on the project), [@minrk](https://github.com/minrk) (Core Developer), Scott Sanderson [ssanderson](https://github.com/ssanderson) (Contributor) and others.

#### **Users**
* **Scientists**
Mostly Jupyter is used by data scientists, however it is not only aimed at them, but is generally used by other types of users as well. However it is very suitable for data scientists working with R and Python on daily basis and for this reason is largely adopted among them. 
* **Learners**
Learners are stakeholders who, for example, use Notebook for study & teaching purposes. For example, at TUDelft the course [CS4065 Multimedia Search and Recommendation](http://studiegids.tudelft.nl/a101_displayCourse.do?course_id=37836) 2015-2016 used Notebook for all of its labs on image and video processing with Python. 
* **Others**
This sub-type includes all other users of IPython and Jupyter Notebook. 

<div id="cont"></div>

### Context View
In this section, the context viewpoint of Jupyter Notebook is described. The context view describes and visualizes the relationships and interactions between Jupyter Notebook with the environment.

#### System Scope
According to the Jupyter foundation website, the Jupyter Notebook is *an open-source web application that allows you to create and share documents that contain live code, equations, visualizations and explanatory text*. 

The Notebooks are typically used for data cleaning and transformation, numerical simulation and machine learning tasks; the target audience is the broad tech audience, spanning from high school students to the most advanced researchers of the world.

Jupyter Notebook is the main application of the broader Jupyter project, which focuses on interactive and exploratory computing that is reproducible and multi-language.

#### Context Model

<div id="contextmodel"></div>

![contextview](/images-team-jupyter/contextview.png)

**Figure 1** - Context Model of Jupyter Notebook

In [Figure 1](#contextmodel), the context model of Jupyter Notebook is displayed. A short description of the most important entities in the diagram follows.

The project, which is a complex web application mainly **used by** *researchers* and *students*, can be conceptually separated in *front-end* and *back-end*. For what concerns the **programming languages**, *Python* is used for the back-end while the *LESS* stylesheet language is used in combination with *HTML* and *Javascript* for the front-end.

Thanks to the interoperability of Python, the project can run on most **platforms**, including *Windows*, *Mac OS X* and other *Unix-like* systems. There are no clear indications of officially supported **browsers**, but the documentation recommends the usage of *Chrome*, *Firefox* or *Safari*.

In terms of **testing frameworks**, *Nose* is used for the Python back-end while *CasperJS* is used for the front-end. Tests are executed automatically at each pull request, thanks to **continuous integration**. To this regard, *Travis CI* is used for testing on Linux and *AppVeyor* for Windows. Code coverage is analyzed by *Codecov*. *ESLint* is used to enforce the **code quality** on the Javascript sources.

The system has multiple external **dependencies**, both in the front-end and in the back-end. In the former case the key ones are *Bootstrap*, *Backbone.js*, *CodeMirror*, *Marked* and *MathJax*. In the latter they are *Jinja2* and *Tornado*. The dependencies are managed using **package managers**, in particular *Bower* is used for the front-end and *NPM* is used for the building tools.

**Sponsoring** occurs in two ways: directly from companies like *Google*, *Microsoft* and *Rackspace* or by employing members of the Steering Council. The latter is the case for companies like *Bloomberg*, *Netflix* and for the *Berkeley University of California*. The **development** is carried on by the members of the Steering Council, including the BFDL Fernando Pérez, and by the Github community.

As far as the **documentation** goes, it is maintained using the *Sphinx* documentation generator and published on the *Read The Docs* hosting platform.

The main **competitors** are the *Beaker Notebook* and *Apache Zeppelin*, both of which have shorter history and have not yet reached the maturity level of Jupyter.

Jupyter Notebook is **licensed** using the *3-clause BSD license*, while the **copyright** of the code belongs to the respective authors

<div id="arch"></div>

## Architecture

<div id="dev"></div>

### Development Viewpoint

The development view describes the architecture of a project from the viewpoint of the developers. According to Rozanski and Woods [[1](#rw)], the development view is responsible to address different aspects of the system development process such as code structure and dependencies, build and configuration management of deliverables, system-wide design constraints, and system-wide standards to ensure technical integrity. At the following sections we ought to present the development view of Jupyter Notebook based on the three models that Rozanski and Woods [[1](#rw)] define in their book: Module Structure Model, Common Design Model and Codeline Model. In addition to this we provide a high level view of Jupyter Notebook in order to ensure thorough understanding of the project in different granularity.

#### High level view

![Global overview](/images-team-jupyter/global-overview.png)

**Figure 2** - High level view

First, the user interacts with the browser, consequently a request is sent to the Notebook server. This can be either HTTP or Websocket request. If user code has to be executed, the notebook server sends it to the kernel in [ZeroMQ](http://zeromq.org/) messages. The kernel returns the results of the execution. At last, the notebook server returns a HTML page to the user.
When the user saves the document, it is sent from the browser to the notebook server. The server saves it on disk as a JSON file with an .ipynb extension. This notebook file contains the code, output and markdown notes. [[6](#global_view)]

#### Module Structure Model

The module structure model defines the organization of the system's code by means of clustering related source code files into modules and determining the dependencies between these modules [[1](#rw)]. In this section we first briefly describe the modules of Jupyter Notebook and then we view the dependencies between these modules in the module dependencies diagram. It should be also noted that this section focuses only on the internal modules of the project and not the external dependencies.

Each one of the modules is shortly described below.

***notebookapp***

This module constitutes the entry point of the web application, including the Tornado based Jupyter Notebook server. More precisely, the `Application object` that is  needed for the Tornado framework is defined in this module. It is responsible for the global configuration of the project, including the mapping of requests to the handlers classes [[7](#noteapp)].


***auth***

In this module the Tornado handlers for logging in and out of the notebook are included. Furthermore, the security.py is also included in which the password for the Notebook is generated.

***base***

This module consists of the base Tornado handlers that are used and extended by other handlers throughout the structure of the directory hierarchy (source code structure). In addition, Tornado handlers for the ZeroMQ sockets, which are responsible for the communication with the kernel, are included.

***bundler***

The bundler module is used in order to bundle the notebook documents and in addition is responsible for enabling and disabling bundler extensions.

***edit***, ***kernelspecs***, ***nbconvert***, ***view***, ***files***, ***terminal***, ***tree***, ***notebook***

These modules contain Tornado handlers for rendering the text editor interface, handling the views that are displayed to the user, converting notebook files to other formats, serving files via the content manager, rendering the terminal interface, displaying the tree view and controlling the live notebook view respectively.

***frontend***

This package contains code that is responsible for the user interface and the interaction with the user.More particularly, the package `static` contains the JS&CSS code while `templates` consists of the Jinja2 HTML templates that are rendered by the modules in the previous point.

***services***

This package registers the Tornado handlers for the different services, including kernels, kernel specifications and contents web services. Furthermore, it contains code that communicates with the frontend and handles the requests of the user. The important thing to mention here is that all the handlers registered here start with the `/api/` prefix. Finally, the main difference with the handlers registered outside and explained before is that they communicate with the frontend using the JSON format whereas the handlers outside render the HTML views.

The module structure and dependencies are shown in [Figure 3](#modulediagram).

<div id="modulediagram"></div>

![Module dependencies](/images-team-jupyter/module.png)

**Figure 3** - Module dependencies diagram

Furthermore, it should be noted that the figure above shows high level dependencies between the most significant modules of the system. In this graph modules that share a similar role in the system are grouped together for the convenience of the reader. The same purpose serve the colors of each of the modules. The diagram starts from the top with the `notebookapp` module which constitutes the entry point of the web application. It is worth mentioning that there are no circular dependencies [[8](#circ)] which makes the system easier to understand and maintain.

#### Source code structure
The overall structure of the directory hierarchy of the Jupyter Notebook is organized as follows. The root folder consists of several files that are used to configure the system. More specifically, the root folder contains YAML files that are responsible for configuring the continuous integration of the project such as `.travis.yml` and `appveyor.yml`. Other important configuration files that are included in the root folder are `bower.json`, `setup.py` and `setupbase.py`. The `bower.json`  manifest file keeps track of the right versions of the front-end packages that are needed for the system. The `setup.py` and `setupbase.py` files are essential for configuring the installation of packages and their dependencies. These files are also used for building the LESS stylesheets and JS files. 

Furthermore, the root folder is divided into five separate folders: the `docs/` folder where all the documentation files that are built using Sphinx are located, the `git-hooks/` which consists of custom git hooks that are available for Jupyter Notebook. For example, there is a git-hook which is used to compile JS&LESS files after git checkout.The `scripts/` which contains scripts that are used as an interface to the components of the notebook for the command line, the `tools/` folder containing tools used in the build process and the `notebook/` which contains all of the source code.

The `notebook/` folder is divided into sub-folders by grouping together source files with similar purpose and functionality. First of all, it is divided into sub-folders that contain back-end functionality which are structured in a similar way. The related initializers can be found in `__init__.py` for the given sub-folder and next to that every sub-folder contains a module called `handlers.py` in which the Tornado handlers are included and registered. In addition, a `tests/` folder is included which consists of files that test the Tornado handlers functionality. The front-end code is located in separate folders and in particular the Javascript and CSS files are located in the `static` folder grouped by the back-end sub-folders that interact with.The [Jinja2](#http://jinja.pocoo.org/docs/2.9/) HTML templates are included in the `templates/` folder. Concerning the tests that are responsible for testing the front-end functionality they are contained in the `notebook/tests/` folder. Finally, the `notebook/` folder contains the entry point of the web application which is the `notebookapp.py` module and some common utilities that are used throughout the whole source code. A graphical overview can be found in [Figure 4](#src).

<div id="src"></div>

![Source code structure](/images-team-jupyter/source_code.png)

**Figure 4** - Source code structure of Jupyter Notebook.

#### Continuous Integration and Testing Approach
*Continuous Integration (CI)* refers to the development practice in which developers *integrate* the code to a shared repository frequently. Each integration is verified by an automated build and test system.

##### Testing Frameworks
The Jupyter Notebook project has a Python backend and a HTML + Javascript frontend. There are two separate testing suites: one for the backend and one for the frontend.

###### Nose (Backend)
The Python backend is tested using the `nose` testing framework. It's a package built on top of `unittest` that simplifies testing.

The backend unit tests are contained in the `notebook/tests` folder.

The `nose` testing framework has been in maintainance mode for several years now [[9]](#nose-maintainance) and its maintainers are suggesting to move to the new framework `nose2`. The Jupyter Notebook maintainers don't seem to have any plan to change testing framework.

After installing the dependencies needed for testing using `pip install -e .[test] --user` the tests can be run using the `nosetests` command.

##### CasperJS (Frontend)
For the frontend code testing, CasperJS is used. It's a Javascript testing framework built with JS itself and leveraging PhantomJS or SlimerJS. These are headless browsers with a Javascript API.

The frontend tests are located in the `notebook/tests/notebook` folder. To run the tests the command
```
python -m notebook.jstest [group]
```
can be used, where `[group]` represents the group of tests to be run, for example `notebook` to run all the tests.

In the recent issue [#2243](https://github.com/jupyter/notebook/issues/2243) the developers discuss about the problems related to the Javascript tests. Apparently, race conditions and the asynchronous nature of Javascript make the tests fail at times. Developers are investigating a fix for this.

#### Continuous Integration Services
The project uses the integration offered by Github [[10]](#gh-ci) to automate building and testing of the pull requests as they are opened or updated.

In particular three CI services are used: *Travis CI* for testing on Linux, *AppVeyor* for testing on Windows and *Codecov* for test coverage checking.

##### Travis CI
*Travis CI* is used by the project to automate build and testing on Linux. It provides free testing for open-source projects.

The build is customized using the `.travis.yml` configuration file [[11]](#travis-ci-yaml). Here are the most important options used by the project:
- Testing is done using both Python 2.7 and 3.5.1.
- **Both** the frontend and the backend are tested.
- In order to speed up the building process, some requirements are installed as [Python wheels](https://www.python.org/dev/peps/pep-0427/) from [this](https://github.com/minrk/travis-wheels) repository.
- For the frontend testing, the `travis_retry` function is used which runs the tests up to 3 times if they fail. As acknowledged in [#2243](https://github.com/jupyter/notebook/issues/2243), this is a bad practice and the maintainers are looking forward to fix it.
- Nosetests is asked to generate coverage reports which are then analyzed by Codecov.
- When testing is done, coverage reports are uploaded to Codecov.

###### AppVeyor
Since Travis CI does not support Windows as an operating system yet, AppVeyor is used instead. Similarly to Travis CI, this service is free for open-source projects.

The configuration file is in the root folder and it's named `appveyor.yml` [[12]](#appveyor-yaml). Here are the most relevant options:
- **Only the backend** is tested.
- Code coverage is not checked.
- The operating system is 64 bit.
- Testing is done using Python 2.7 and 3.5.

##### Codecov
Code coverage is tightly connected to unit testing, and measures the number of lines of code that were executed by the test suite.

Codecov is a hosted CI service that computes a coverage score of the unit tests, expressed as a percentage and defined as follows
```
COV% = n_lines_executed / (n_lines_executed + n_lines_partially_executed + n_lines_not_executed)
```

The Jupyter Notebook project uses Codecov to check the coverage of the Python backend tests at each pull request. Testing the HTML & Javascript frontend is not currently supported by Codecov.

The Codecov configuration for the project is stored in the root folder of the project in the `codecov.yml` file [[6]](#codecov-yaml). The Jupyter Notebook project has chosen the following options:
- Project
    + A decrease of 10% maximum in the entire project test coverage after the pull request is allowed in order for the check to be marked as a success
- Pull request
    + The test coverage of the lines adjusted with the pull request is not checked (minimum 0%)

The coverage reports are generated by Travis CI during the testing procedure (`nosetests --with-coverage`) and then they are uploaded to Codecov using the `codecov` bash utility.



<div id="fun"></div>

### Functional Viewpoint
TODO

<div id="evo"></div>

## Evolution Perspective

TODO

<div id="debt"></div>

## Technical Debt

TODO

<div id="contr"></div>

## Contributions

As part of the course, some contributions to the project repository were made in the form of pull requests. 

### Bugfixes
The first pull request was related to the issue [#980](https://github.com/jupyter/notebook/issues/980), which concerns the incorrect rendering of some LaTeX code through the MathJax library. [@joined](https://github.com/joined) wrote a bugfix that was submitted on February 23rd as pull request [#2220](https://github.com/jupyter/notebook/pull/2220) to the repository. After a back and forth with the maintainers that first asked to extend the changes and then to add unit tests, the pull request was merged.

The second pull request was related to issue [#1911](https://github.com/jupyter/notebook/issues/1911), concerned the incorrect syntax highlighting of the LaTeX groups through the CodeMirror library. [@joined](https://github.com/joined) wrote a bugfix that was submitted on March 2nd as pull request [#2244](https://github.com/jupyter/notebook/pull/2244) to the repository. It was immediately approved and merged in the following day.

### Technical debt related
As part of the investigation of technical debt, a number of pull requests were made trying to pay it off.

[@joined](https://github.com/joined) used the `flake8` linting tool to check the compliance of the Python codebase with the PEP8 code style. Many inconsistencies were discovered, and most of them were solved either by using automated tools like `autopep8` and by visual inspection. Finally the pull request [#2278](https://github.com/jupyter/notebook/pull/2278)) was opened. The core developer [@Carreau](https://github.com/Carreau) commented saying that the code style is not actively enforced, and a pull request modifying various parts of the codebase is too problematic, therefore rejecting it.

[@John-Pap](https://github.com/John-Pap) found a TODO comment in the `notebook/static/base/js/page.js` Javascript module. The comment mentioned that the `Page` object should accept the `site` and `header` `div`s selectors as parameters in the constructor, rather than hardcoding them in the methods. The object was refactored and the references to it in other parts of the codebase were adjusted accordingly; the changes were submitted with pull request [#2279](https://github.com/jupyter/notebook/pull/2279). The contribution was approved and waits to be merged after the 5.0 release of the notebook.

[@adimitrova](https://github.com/adimitrova) spotted a deprecation warning in the output of the backend tests. The relevant function call in `notebook/services/contents/largefilemanager.py` was modified to the newer version of the API. The pull request was merged on March 14th.

[@ajayaadhikari](https://github.com/ajayaadhikari) spotted a FIXME comment in `notebook/services/contents/handlers.py`. The comment mentioned that some functionality was supposed to be implemented in the Javascript frontend rather than in the backend. It was discovered that the functionality was already present in the frontend and therefore the backend code was redundant. The functionality was therefore removed from the backend and the changes were submitted as pull request [#2281](https://github.com/jupyter/notebook/pull/2281)). The contribution was approved and waits to be merged after the 5.0 release of the notebook.

[@John-Pap](https://github.com/John-Pap) realised that some tests were not ran by Travis because the `pandoc` requirement was missing. The requirement was added to the Travis configuration file as an APT addon and the changes were submitted with pull request [#2283](https://github.com/jupyter/notebook/pull/2283). The contribution was approved and waits to be merged after the 5.0 release of the notebook.

<div id="concl"></div>

## Conclusion
TODO

<div id="ref"></div>

## References

1. <div id="rw"/>Nick Rozanski and Eoin Woods. Software Systems Architecture: Working with Stakeholders using Viewpoints and Perspectives. Addison-Wesley, 2012.
2. <div id="inst-noteb"/>Instant Temporary IPython Notebooks (https://lambdaops.com/ipythonjupyter-tmpnb-debuts/)
3. <div id="data-science"/>Jupyter, A Platform for Data Science at Scale (https://www.slideshare.net/mbussonn/jupyter-a-platform-for-data-science-at-scale)
4. <div id="ipy-jupyt"/>IPython & Jupyter (https://www.slideshare.net/BigDataColombia/ipython-jupyter)
5. <div id="arch"/>PLOTCON NYC: The Architecture of Jupyter: Protocols for Interactive Data Exploration and Visualization Across Languages (https://www.slideshare.net/Plotly/plotcon-nyc-the-architecture-of-jupyter-protocols-for-interactive-data-exploration-and-visualization-across-languages)
6. <div id="global_view"/> Jupyter documentation (http://jupyter.readthedocs.io/en/latest/architecture/how_jupyter_ipython_work.html)
7. <div id="noteapp"/>Notebook application object (http://www.tornadoweb.org/en/stable/guide/structure.html#the-application-object)
8. <div id="circ"/>Circular Dependencies (https://en.wikipedia.org/wiki/Circular_dependency)
9. <div id="nose-maintainance"/>Nose testing framework (https://nose.readthedocs.io/en/latest/)
10. <div id="gh-ci"/>Github Continuous Integration Add-ons (https://github.com/integrations/feature/continuous-integration)
11. <div id="travis-ci-yaml"/>Travis CI YAML Configuration (https://docs.travis-ci.com/user/customizing-the-build)
12. <div id="appveyor-yaml"/>AppVeyor YAML Configuration (https://www.appveyor.com/docs/build-configuration/)