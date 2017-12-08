# Development view
## Introduction
The development view describes the architecture of a project from the viewpoint of the developers. According to Rozanski and Woods [[2](#rw)], the development view is responsible to address different aspects of the system development process such as code structure and dependencies, build and configuration management of deliverables, system-wide design constraints, and system-wide standards to ensure technical integrity. At the following sections we ought to present the development view of Jupyter Notebook based on the three models that Rozanski and Woods [[2](#rw)] define in their book: Module Structure Model, Common Design Model and Codeline Model. In addition to this we provide a high level view of Jupyter Notebook in order to ensure thorough understanding of the project in different granularity.

## High level view

![Global overview](/images-team-jupyter/global-overview.png)

First, the user interacts with the browser, consequently a request is sent to the Notebook server. This can be either HTTP or Websocket request. If user code has to be executed, the notebook server sends it to the kernel in [ZeroMQ](http://zeromq.org/) messages. The kernel returns the results of the execution. At last, the notebook server returns a HTML page to the user.
When the user saves the document, it is sent from the browser to the notebook server. The server saves it on disk as a JSON file with an .ipynb extension. This notebook file contains the code, output and markdown notes. [[1](#global_view)]

## Web application

![Web application](/images-team-jupyter/web-application.png)

Jupyter notebook uses Tornado as its web framework. They follow the model-view-controller design pattern to handle HTTP requests. This pattern separates these three components to enable efficient reuse of code and parallel development. These components are further analysed specifically for our project.

### Controllers
In the Tornado framework a `web.Application` type has to be defined [[16](#noteapp)]. This class is responsible for mapping the incoming request url to the correct handler. In the file notebookapp.py `NotebookWebApplication` class is defined as a subclass of `web.Application`.

Each handler is responsible for returning the html page of certain requests. The handler provides different functions for different HTTP request methods e.g. `post()` function if it handles post requests. Most of the logic and calculation of the web application resides in the handlers. It has access to the database. The handler accesses the kernel if it needs to execute user code. When a handler has the needed information to populate the content of the html page, it passes this information to an appropriate template of the view component. The template returns the final html page and the handler returns it to the user.
### Model
The database and the notebook file form the model. The SQLite database is used. In this project the database is only used to save session variables. Futhermore, notebook files are used to save the code, output and markdown notes.
### View
The view component is responsible for generating HTML content. In the folder templates the html files for each page is listed. Each of the templates have placeholders. These templates are called by the handlers which also provide values for the placeholders.


## Models
### Module Structure Model

The module structure model defines the organization of the system's code by means of clustering related source code files into modules and determining the dependencies between these modules [[2](#rw)]. In this section we first briefly describe the modules of Jupyter Notebook and then we view the dependencies between these modules in the module dependencies diagram. It should be also noted that this section focuses only on the internal modules of the project and not the external dependencies.

Each one of the modules is shortly described below.

***notebookapp***

This module constitutes the entry point of the web application, including the Tornado based Jupyter Notebook server. More precisely, the `Application object` that is  needed for the Tornado framework is defined in this module. It is responsible for the global configuration of the project, including the mapping of requests to the handlers classes [[16](#noteapp)].


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

The module structure and dependencies are shown in the following diagram:

![module dependencies](/images-team-jupyter/module.png)

Furthermore, it should be noted that the figure above shows high level dependencies between the most significant modules of the system. In this graph modules that share a similar role in the system are grouped together for the convenience of the reader. The same purpose serve the colors of each of the modules. The diagram starts from the top with the `notebookapp` module which constitutes the entry point of the web application. It is worth mentioning that there are no circular dependencies [[15](#circ)] which makes the system easier to understand and maintain.

## Common Design Model
 The common design model is used in order to maximize the commonality across element implementations [[2](#rw)]. Defining such a model is beneficial for the system's coherence and also makes easier the process of understanding, maintaining and operating the system. Moreover, it can reduce the risk and the duplication of effort during the solution of a problem. In this section the pieces that constitute the common design model of Jupyter Notebook are identified.

### Common Processing

#### Initialization
Jupyter Notebook initialization must first ensure that all the minimum requirements are met, then needs to find packages and package data, import dependencies, setup the Notebook. The Notebook setup involves checking directories, setting up a path for files, looking up for npm packages, staging npm frontend components, JS, CSS compiling etc. Generic values such as paths, certain variables have to be put in a config file. Initially also utilities are loaded, allowing installation of JavaScript and Python extensions.

#### Termination and restart of operation
The termination and restart is configured so that whenever the kernel dies it tries to restart automatically. If this is not possible for some reason, then the user is able to still save their notebook, however without closing and reopening the notebook, the code within cannot not be run.

#### Message Logging and Instrumentation
Communication between the front-end and the kernel happens through Comm messages.
Generally, three types of messaging [[13](#Messaging_in_Jupyter)] exists in the project and the low-level message transport is ensured by [ZeroMQ](http://zeromq.org/). The kernel has four sockets **DEALER**, **SUB**, **ROUTER** and **PUB** serving the following functions:
* **Shell**: a Single ROUTER socket allowing multiple connections from the front-end to the kernel. This socket requests code execution, prompts, information for objects and others.  
* **IOPub**: this is the "broadcast channel" socket (PUB) for all errors, outputs etc. When there is the case of multiple clients, information must be available for each front-end to know what the others have sent to the kernel.
* **stdin**: ROUTER socket, connected to all of the front-ends and it requests input from the active front-end. The code executing notebook has a DEALER socket providing the reply to the kernel's request.
* **Control**: handles important messages without queuing. Other than that, it works identically as the Shell.
* **Heartbeat**: sends simple byte string messages to ensure connectivity between kernel and front-end

Within the project's core, Messages are implemented in the Session class.

Instrumentation is called the practice to insert special code to log information, necessary for monitoring and debugging. This information is regarding step execution, states of the system, usage of the resources available etc. Jupyter developers log information about the system state, code execution etc. using the configured Logger given by traitlets with the class LoggingConfigurable, in order for the logging to be centralized. Under the hood the Python package `logging` is used. Different logging levels are supported, like `debug` and `error`.

#### Internationalization
In general internationalization refers to the support of the product of languages, other than English, e.g. French, Spanish etc. For the moment, the product is relatively new (3 years old) and development is focused mainly on functionality, rather than on services translation in other languages. Thus, for the moment Jupuyter Notebook supports only English.  

#### Use of third party libraries
Jupyter Notebook is written in Python and JavaScript and thus, takes advantage of the numerous good libraries and frameworks to build different parts of the system and to ensure high quality, secure and maintainable product. While most of the components use the built-in libraries, we list the ones that need to be additionally installed in order to be able to run, contribute to or just use the product. Some are required only for contribution, others are required and installed automatically with Jupyter. The list goes as follows:
* Backend: [Node.js](https://howtonode.org/how-to-install-nodejs)
* Frontend: [Tornado web framework and asynchronous networking library](http://www.tornadoweb.org/en/stable/)
* Testing:
    * Python: [Nose](http://nose.readthedocs.io/en/latest/testing.html)
    * JavaScript: [PhantomJS](http://phantomjs.org/documentation/)
* Instrumentation: [Sphinx](http://www.sphinx-doc.org/); [pandoc](http://pandoc.org/)
* Configuration: [traitlets](http://traitlets.readthedocs.io/en/stable/)
* Messaging: [ZeroMQ](http://zeromq.org/)
* Security:
    * Authentication: [Passport](http://passportjs.org/); [OpenSSL](http://www.pyopenssl.org/en/stable/api.html)
* Documentation: [Sphinx documentation generator](https://pypi.python.org/pypi/Sphinx)

#### Processing configuration parameters
IPython & Jupyter use a number of configuration abstractions, each defined in its own Python class. The main framework used to set the configurations for Jupyter is [traitlets](http://traitlets.readthedocs.io/en/stable/) . Types of traitlets [[14](#Traitlets)] include configuration objects, application (executing certain service/job by running one or a number of config. files), configurable (sets configuration object with attributes), singletons (single instance object).
The initial configuration for the frontend configuration imports traitlets, configuration path and directory and JSON config manager. It then gathers the configurations from all the config sections of the application and sets them to the settings of the current user.


#### Security
Jupyter becomes more and more popular and used due to its interactivity, simple design and ease of use. For that reason security precautions must be taken into consideration.

Running code on the Jupyter Notebook server means that code might be potentially in danger. Authentication must be integrated on the server itself as well as in the document themselves. Notebook \4.3 integrates token-based authentication which is turned on by default. Wish this authentication requests to the server are encrypted. At the start of the Notebook server a token is generated. If the server opens the browser, a second token must(is) generated. With the command **jupyter notebook list** the tokens may be seen anytime.

Alternatives must also be provided for developers who do not completely trust this form of security. Passwords are also available to use for the notebook documents as a second layer of security. To setup a password, in version \5.0 there is a command **jupyter notebook password**. The file which contains the notebook password is __jupyter_notebook_config__.py and is usually located in the home directory of the current user. Passwords are hashed, but it is also recommended that users also use SSL to encrypt the communication between

#### Database interaction
Jupyter Notebook uses the SQLite database only for saving session variables.
From consumer point of view, Jupyter Notebook must support the most commonly used database languages and RDBS. When working with Python, it is easy to use MySQL. It is possible to connect to a MySQL database and to perform data access operations.
Moreover, the amount of data is rising and the need for Big Data Analysts is rising. Jupyter Notebook supports Python and R which are widely used by specialists for different tasks performed on big data.
For the moment Jupyter does not directly support Hadoop, however it is possible to use it in the Notebook through the [Big SQL Technology Sandbox](https://my.imdemocloud.com/projects/3467#%21resources) by registering
SQL for RDBMS or Relational Database Management System access and using the Sandbox's username and password, a certain port, database name and hostname provided by Sandbox and by making use of the RJDBC package.  

#### Contributions
Jupyter provides developers with a [development environment](https://jupyter.readthedocs.io/en/latest/contributor/content-contributor.html) and a detailed [Developer Guide](https://jupyter.readthedocs.io/en/latest/developer-docs/index.html). Initial configuration involves installing of Node.js (wondows) or nodejs-legacy and rebuilding JavaScript and CSS which need to be rebuilt every time there's a change in the LSS or JS sources. Jupyter also advise developers to use Git Hooks for auto-update of the dependencies. They require developers to run tests. [Nose](http://nose.readthedocs.io/en/latest/testing.html) is used for Python testing and [PhantomJS](http://phantomjs.org/documentation/) \+ [CasperJS](http://casperjs.org/) for JavaScript testing. [Documentation](https://jupyter-client.readthedocs.io/en/latest/kernels.html) for developing Kernels for Jupyter is provided too for contributors.



### Design Constraints
Jupyter Notebook supports multiple programming languages based on kernels, specifically developed for these targeted languages. It is crucial for the kernel to be able to communicate with the frontends and "understand" what is happening. As Jupyter is an open source project and everyone can contribute, it is important that developers understand the importance of Messaging in Jupyter. Since this might be a potential design constraint, developers have designed a pattern to help contributors handle this neatly which will be reviewed in the respective section.

### Design Patterns
Design patterns aim at helping developers handle often occurring issues by providing solutions to these problems. The design pattern is more of a blueprint towards solving a certain problem and provides best practices that could be used in different occasions. Alternatively, the design patterns could also be looked at as a defined algorithm, a programming paradigm or relationship and interaction between classes or speaking as types: *implementation*, *algorithmic*, *behavioral*, *structural* etc. We overview patterns present in the Jupyter Notebook project.  

#### Initialization Pattern
This pattern aims at ensuring that the Jupyter Notebook server and all the services initialize and run without problems. The server handler gets the system info, performs authentication, takes care of cookies, configurations, logs etc, loading of templates, absolute paths etc. All this is necessary to ensure normal functionality.

#### Kernel Pattern
The kernel pattern ensures that no matter what code the kernel is written in, Jupyter will be able to find and load the kernel according to the programming language required by the user. All Jupyter Kernels implement two main types of messaging: The first type is `execute_request`, used by frontends to request the kernel to execute user's code, in a namespace reserved to the user’s variables. This is how separation of kernel's own implementation and variables are split. The second type is `kernel_info_request` which returns information regarding target language, name of the language in which kernel is implemented, file extension, mime type etc. There is a third, optional type, called `completion` including `complete_request` and `complete_reply` regarding execution of the user's code and status. When developing kernels, this handler pattern must be implemented in order for the Kernel to be usable.
Generally, every Kernel developer must create a class for the kernel with methods for actual kernel implementation, version of implementation, banner to return to the user at first prompt, language info and execution information. Optionally, methods for restart and shutdown, code complete and history are also good to implement.   [[11](#Making_kernels_for_Jupyter)]

#### Event Handling Pattern
Event listeners or handlers are used to handle events occurring between the kernel and the Jupyter front-ends, i.e. the Notebooks. This happens with the `MainKernelHandler(APIHandler)` and the `ZMQChannelsHandler(AuthenticatedZMQStreamHandler)` classes.
Heartbeat messages are critical [[12](#Handling_Messages)] and must be communicated back as soon as they occur. Messages on the shell and control sockets should be parsed and with validated signature.

#### File Handling Pattern
The File handling pattern is used to setup the initial location of the start-up folder for each user. Furthermore, it checks whether the user creates sub-folders and files and takes care of these too. It first checks whether the user has specified a different location for the start-up folder and if not, it goes to the default one.

## Codeline Model

According to Rozanski and Woods [[2](#rw)] the codeline model defines the overall structure of the directory hierarchy (source code structure), the build, integration and test approach, the release process and the configuration management. Based on these points we try to identify the codeline model of Jupyter Notebook.

### Source code structure

The overall structure of the directory hierarchy of the Jupyter Notebook is organised as follows.
The root folder consists of configuration files that are essential for Jupyter Notebook such as the setup.py which is responsible for building Jupyter Notebook. Furthermore, the root folder is divided into the following five folders:

- `docs/`: In this folder all the documentation files that are built using Sphinx are included.
- `git-hooks/`: This folder consists of custom git hooks that are available for Jupyter Notebook. Git hooks are customs scripts that run when certain important actions occur.
- `notebook/`: All the source code files of Jupyter Notebook project are included in this folder. This folder is divided into sub-folders by grouping together source files with similar purpose and functionality. You can see an analytical view of the directory structure in the file tree below.
- `scripts/`: This folder consists of scripts that are used when Jupyter Notebook runs. For example, the less-watch script that is inside that folder is responsible for compiling the LESS variables.
- `tools/`: It contains tools used in the build process, as described in the relative chapter.

The directory structure of Jupyter Notebook with the most important directories and files is listed below in more detail:

* jupyter/notebook
  * **docs**/
    	* resources/
    	* source/
    	* sphinxext/
    	* Makefile
  * **git-hooks**/
    	* README.md
    	* install-hooks.sh
    	* post-checkout
    	* post-merge
  * **notebook**/
  		* auth/
  		* base/
  		* bundler/
  		* notebookapp.py
  		* utils.py
  * **scripts**/
  		* jupyter-bundlerextension
  		* jupyter-nbextension
  		* jupyter-notebook	 
  		* jupyter-serverextension
  		* less-watch
  * **tools**/
  		* patches/
  		* tests/
  		* build-main.js
  		* secure-notebook.py
  * README.md
  * setup.py
  * setupbase.py

## Continuous Integration and Testing Approach
*Continuous Integration (CI)* refers to the development practice in which developers *integrate* the code to a shared repository frequently. Each integration is verified by an automated build and test system.

### Testing Frameworks
The Jupyter Notebook project has a Python backend and a HTML + Javascript frontend. There are two separate testing suites: one for the backend and one for the frontend.

#### Nose (Backend)
The Python backend is tested using the `nose` testing framework. It's a package built on top of `unittest` that simplifies testing.

The backend unit tests are contained in the `notebook/tests` folder.

The `nose` testing framework has been in maintainance mode for several years now [[8]](#nose-maintainance) and its maintainers are suggesting to move to the new framework `nose2`. The Jupyter Notebook maintainers don't seem to have any plan to change testing framework.

After installing the dependencies needed for testing using `pip install -e .[test] --user` the tests can be run using the `nosetests` command.

#### CasperJS (Frontend)
For the frontend code testing, CasperJS is used. It's a Javascript testing framework built with JS itself and leveraging PhantomJS or SlimerJS. These are headless browsers with a Javascript API.

The frontend tests are located in the `notebook/tests/notebook` folder. To run the tests the command
```
python -m notebook.jstest [group]
```
can be used, where `[group]` represents the group of tests to be run, for example `notebook` to run all the tests.

In the recent issue [#2243](https://github.com/jupyter/notebook/issues/2243) the developers discuss about the problems related to the Javascript tests. Apparently, race conditions and the asynchronous nature of Javascript make the tests fail at times. Developers are investigating a fix for this.

### Continuous Integration Services
The project uses the integration offered by Github [[4]](#gh-ci) to automate building and testing of the pull requests as they are opened or updated.

In particular three CI services are used: *Travis CI* for testing on Linux, *AppVeyor* for testing on Windows and *Codecov* for test coverage checking.

#### Travis CI
*Travis CI* is used by the project to automate build and testing on Linux. It provides free testing for open-source projects.

The build is customized using the `.travis.yml` configuration file [[5]](#travis-ci-yaml). Here are the most important options used by the project:
- Testing is done using both Python 2.7 and 3.5.1.
- **Both** the frontend and the backend are tested.
- In order to speed up the building process, some requirements are installed as [Python wheels](https://www.python.org/dev/peps/pep-0427/) from [this](https://github.com/minrk/travis-wheels) repository.
- For the frontend testing, the `travis_retry` function is used which runs the tests up to 3 times if they fail. As acknowledged in [#2243](https://github.com/jupyter/notebook/issues/2243), this is a bad practice and the maintainers are looking forward to fix it.
- Nosetests is asked to generate coverage reports which are then analyzed by Codecov.
- When testing is done, coverage reports are uploaded to Codecov.

#### AppVeyor
Since Travis CI does not support Windows as an operating system yet, AppVeyor is used instead. Similarly to Travis CI, this service is free for open-source projects.

The configuration file is in the root folder and it's named `appveyor.yml` [[7]](#appveyor-yaml). Here are the most relevant options:
- **Only the backend** is tested.
- Code coverage is not checked.
- The operating system is 64 bit.
- Testing is done using Python 2.7 and 3.5.

### Codecov
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

## Build
### Code
The first step to build the codebase is to update the Python distribution toolchain and download the repository contents, as following
```
pip install setuptools pip --upgrade --user
git clone https://github.com/jupyter/notebook
```
then after entering the repository folder the project can be installed with
```
pip install -e . --user
```

The build is organised by means of the Python `setuptools` package. The `universal=1` flag in the `setup.cfg` file states that the package supports both Python 2 and 3.

As the project contains LESS stylesheets and combines multiple Javascript files in a single `main.min.js` file for optimization purposes, it is necessary to preprocess both the LESS and the JS files.
For this purpose the `setup.py` can be used as follows:
```
python setup.py js css
# equivalently
npm run build
```
This command leverages the functions defined in `setupbase.py` and does the following steps:

1. The development (NPM) dependencies that are needed to compile the files and to manage the frontend dependencies are downloaded. These include `bower` (to manage frontend dependencies), `less` (to compile the LESS stylesheets) and `requirejs` (to combine and minify the Javascript files).
2. Bower is used to download the frontend dependencies, like Backbone.js, Bootstrap, jQuery and others (the complete list can be found in `bower.json`).
3. The Javascript files are combined and minified using the `tools/build-main.js` script.
4. The LESS stylesheets are compiled to CSS using the `lessc` command line tool.

For development purposes, it's possible to use the `npm run build:watch` command that builds automatically the files every 3 seconds.

After having installed the project and its dependencies, and having compiles the JS and LESS files, the notebook can be run with `jupyter notebook`.

### Documentation
The documentation, which is managed using the *Sphinx* Python tool, is organised in the `docs` folder and is hosted by the [readthedocs.org](https://readthedocs.org/) service.

The configuration for the Read The Docs service is stored in the `readthedocs.yml` file [[9]](#rtd-yaml). The file is used to specify that the documentation has to be built with Python 3 and that the `enviroment.yml` Conda enviroment file [[10]](#conda-yaml) inside `docs/` should be used. In that file the dependencies needed to build the documentation are listed.

To build the documentation manually the first step is to install the needed dependencies using the provided Conda enviroment file, like so
```
conda env create -f docs/environment.yml
source activate notebook_docs
```
afterwards it's sufficient to run `make html` from the `docs/` folder to generate the HTML documentation, which is stored in the `build/html` folder.

### Release Process
The process used to make a new release is documented [here](https://jupyter-notebook.readthedocs.io/en/latest/development_release.html).

Here are the steps:

1. The version number is updated in `notebook/_version.py`.
2. The command `python setup.py jsversion` is run to update the version number of the Notebook in the JS files, making it available within Javascript.
3. A new commit is created and tagged referencing the version number, like so

    ```
    git commit -am "release $VERSION"
    git tag $VERSION
    ```
4. The source distribution (`sdist`) and the built distribution (`bdist_wheel`) are built using `python setup.py sdist bdist_wheel`.
5. The archives are uploaded over SSL using `twine`, with the command `twine upload dist/*`.
6. The `.dev` suffix is added back to the `notebook/_version.py` file.
7. The commit and the tags are pushed to the repository.

### Configuration management
Configuration management is related to managing the state of the server. It should automatically create the necessary files, install software and starts services to ensure its correct working according to the environment. In this way the source code is decoupled from the environment on which its run and consequently there are no hard coded configuration values in the source code. In our project Traitlets [[14](#traitlets)] is used for configuration and loading values from files or from command line arguments. The user can set the configuration variables from the command line or create a file called
`jupyter_notebook_config.py` containing the configuration values.

## References

1. <div id="global_view"/> Jupyter documentation (http://jupyter.readthedocs.io/en/latest/architecture/how_jupyter_ipython_work.html)
2. <div id="rw"/>Nick Rozanski and Eoin Woods. Software Systems Architecture: Working with Stakeholders using Viewpoints and Perspectives. Addison-Wesley, 2012.
3. <div id="traitlets"/> Traitlets documentation (http://traitlets.readthedocs.io/en/stable/)
4. <div id="gh-ci"/>Github Continuous Integration Add-ons (https://github.com/integrations/feature/continuous-integration)
5. <div id="travis-ci-yaml"/>Travis CI YAML Configuration (https://docs.travis-ci.com/user/customizing-the-build)
6. <div id="codecov-yaml"/>Codecov YAML Configuration (https://github.com/codecov/support/wiki/Codecov-Yaml)
7. <div id="appveyor-yaml"/>AppVeyor YAML Configuration (https://www.appveyor.com/docs/build-configuration/)
8. <div id="nose-maintainance"/>Nose testing framework (https://nose.readthedocs.io/en/latest/)
9. <div id="rtd-yaml"/>Read The Docs YAML Configuration (http://docs.readthedocs.io/en/latest/yaml-config.html)
10. <div id="conda-yaml"/>Conda YAML Enviroment Configuration (https://conda.io/docs/using/envs.html#share-an-environment)
11. <div id="Making_kernels_for_Jupyter"/>Making kernels for Jupyter (http://jupyter-client.readthedocs.io/en/latest/kernels.html)
12. <div id="Handling_Messages"/>Handling Messages (http://jupyter-client.readthedocs.io/en/latest/kernels.html#handling-messages)
13. <div id="Messaging_in_Jupyter"/>Messaging in Jupyter (http://jupyter-client.readthedocs.io/en/latest/messaging.html)
14. <div id="Traitlets"/>Traitlets (http://traitlets.readthedocs.io/en/stable/#)
15. <div id="circ"/>Circular Dependencies (https://en.wikipedia.org/wiki/Circular_dependency)
16. <div id="noteapp"/>Notebook application object (http://www.tornadoweb.org/en/stable/guide/structure.html#the-application-object)
