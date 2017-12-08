# Technical Debt

The concept of Technical Debt was first introduced in 1992 by Ward Cunningham, a programmer who is also known for developing the first wiki. This term is a metaphor that associates software development to financial debt. More specifically, technical debt is a concept in programming related to the extra development work that is introduced when code that is easy to implement in the short run is used instead of applying the optimal overall solution that will keep the code maintainable and readable in the long run.

Technical debt is not only related to the code though, it can also be associated with the written or unwritten documentation, or in the lack of testing coverage.

Jupyter Notebook is a large project comprising of more than 41.000 lines of code evolved over the years; this makes checking the entire project for technical debt in a short timeframe challenging.

Therefore, this document focuses and identifies the following three types of technical debt in the project: *code debt*, *testing debt* and *documentation debt*. Furthermore, instead of just identifying the technical debt an action was taken in some cases by *initiating a pull request* that tackles the identified debt.

## Code Debt

A lot of the code that is currently being written in Jupyter Notebook will probably be around for many years and it will be continuously maintained and changed throughout that time. The sheer size of the code, as it grows, will make its maintenance harder and harder as time goes by. Making the code readable means it is easier to modify or change. This is the reason that the Jupyter Notebook has a development documentation with guidelines for potential contributors.

In accordance to the readability of the code mentioned before the Jupyter project documentation states in the [coding style](http://jupyter.readthedocs.io/en/latest/development_guide/coding_style.html) section that the code should follow the PEP8 guidelines.

To investigate if the code adheres to these guidelines the `flake8` tool was used to lint the codebase, discovering numerous inconsistencies. A mitigation of this technical debt was doen by making the codebase more consistent, using both automated tools like `autopep8` and manual inspection. Moreover, the tests with `nosetests` were ran to make sure that no bug was introduced in the system.

The pull request that tackles this technical debt can be found [here](https://github.com/jupyter/notebook/pull/2278). 

In particular, below you can see two tables with the results given by `flake8 . --statistics` before and after our changes.

### Before

|Occurrences| Code| Description|
| ------------- |:-------------:| -----:|
|1     | E101|indentation contains mixed spaces and tabs|
|8     | E122|continuation line missing indentation or outdented|
|59    | E124|closing bracket does not match visual indentation|
|4     | E125|continuation line with same indent as next logical line|
|9     | E127|continuation line over-indented for visual indent|
|157   | E128|continuation line under-indented for visual indent|
|16    | E201|whitespace after '{'|
|15    | E202|whitespace before '}'|
|75    | E203|whitespace before ':'|
|13    | E221|multiple spaces before operator|
|2     | E222|multiple spaces after operator|
|11    | E225|missing whitespace around operator|
|1     | E228|missing whitespace around modulo operator|
|63    | E231|missing whitespace after ','|
|53    | E251|unexpected spaces around keyword / parameter equals|
|44    | E261|at least two spaces before inline comment|
|11    | E262|inline comment should start with '# '|
|131   | E265|block comment should start with '# '|
|1     | E266|too many leading '#' for block comment|
|1     | E272|multiple spaces before keyword|
|4     | E301|expected 1 blank line, found 0|
|139   | E302|expected 2 blank lines, found 1|
|16    | E303|too many blank lines (2)|
|31    | E305|expected 2 blank lines after class or function definition, found 1|
|6     | E306|expected 1 blank line before a nested definition, found 0|
|1     | E401|multiple imports on one line|
|85    | E402|module level import not at top of file|
|481   | E501|line too long (81 > 79 characters)|
|5     | E701|multiple statements on one line (colon)|
|1 	   | E712|comparison to False should be 'if cond is False:' or 'if not cond:'|
|3     | E713|test for membership should be 'not in'|
|2     | E731|do not assign a lambda expression, use a def|
|42    | F401|'shlex' imported but unused|
|1     | F811|redefinition of unused 'WebSocketHandler' from line 20|
|6     | F841|local variable 'app' is assigned to but never used|
|31    | W191|indentation contains tabs|
|37    | W291|trailing whitespace|
|9     | W292|no newline at end of file|
|488   | W293|blank line contains whitespace|
|12    | W391|blank line at end of file|

### After

|Occurrences| Code| Description|
| ------------- |:-------------:| -----:|
|131  | E265|block comment should start with '# '|
|1    | E266| too many leading '#' for block comment|
|81   | E402| module level import not at top of file|
|517  | E501| line too long (81 > 79 characters)|
|12   | F401| '.nbextensions.install_nbextension' imported but unused|
|1    | F811| redefinition of unused 'WebSocketHandler' from line 20|
|6    | F841| local variable 'app' is assigned to but never used|

As can be seen from the above tables, the code after the changes is more consistent and readable. 

Another way identifying technical debt is by manually searching for ['TODO'](https://github.com/jupyter/notebook/search?utf8=%E2%9C%93&q=TODO) and ['FIXME'](https://github.com/jupyter/notebook/search?utf8=%E2%9C%93&q=FIXME) comments in the project repository. The existence of such comments in the source code is a clear indicator of code debt as the most of the times this practice implies that a quick fix was preferred instead of an overall solution that would keep the code maintainable and clean.

As of *13/03/2017* Jupyter Notebook has **21 'TODO'** comments and **10 'FIXME'** comments in the code. During the process of mitigating code debt multiple pull requests were opened by emphasizing in a few diverse cases worth mentioning.

The first pull request ([#2279](https://github.com/jupyter/notebook/pull/2279)) is related to some TODO comments for some hardcoded selectors in the [page.js](https://github.com/jupyter/notebook/blob/666ecbf35c3310335a3c8c182e8f53441c991c14/notebook/static/base/js/page.js) file. In general hardcoding strings is a bad coding practice which seriously hinders the flexibility of the code. Therefore, the constructor of the class `Page` was re-factored in order to accept the two selectors as arguments. Even if an immediate advantage is not present, in the long run the flexibility and extensibility of the code is improved. By making the selectors of the `site` and `header` divs parameters of the constructor of the `Page` object, it's possible to create `Page` objects with different selectors.

Another pull request was opened based on a 'FIXME' comment found during the investigation of code debt. More precisely, in the file [handlers.py](https://github.com/jupyter/notebook/blob/master/notebook/services/contents/handlers.py#L126-L129) a 'FIXME' comment mentions that the sorting of the contents of a directory should be done in the front-end. After examining the code of the front-end, where this functinality should be added, it turned out that this functionality already exists in [notebooklist.js](https://github.com/jupyter/notebook/blob/420715e3e5685d9216f09c25d644b420d11fe109/notebook/static/tree/js/notebooklist.js#L372-L386). Thus, before the changes the sorting was done redundantly on the front-end and the back-end which had as a result of adding more complexity in the code without being needed. After the removal of the sorting functionality in the back-end, that was introduced by the pull request, there is not needless duplicate functionality which makes the code easier to understand and maintain in the long term.

Finally a pull request ([#2280](https://github.com/jupyter/notebook/pull/2280)) was created based on the results that `nosetests` gave. More specifically, while running these tests the following deprecation warning was shown

```
notebook/services/contents/largefilemanager.py:60: DeprecationWarning: decodestring() is a deprecated alias, use decodebytes() bcontent = base64.decodestring(b64_bytes)
```

As per the documentation of [base64.decodestring](https://docs.python.org/3/library/base64.html#base64.decodestring) this is deprecated since version 3.1 and the new function to use is [base64.decodebytes](https://docs.python.org/3/library/base64.html#base64.decodebytes). To keep the compatibility of the Jupyter Notebook project with both the version 2 and 3 of Python, the function call was changed to [base64.b64decode](https://docs.python.org/3/library/base64.html#base64.b64decode) which, as the documentation states, is the new API that is supposed to be used.

The existence of deprecation warnings means that the developers are not keeping the code up to date with the evolution of the ecosystem and this constitutes technical debt. The changes proposed by the pull request were made in the source code of the file [largefilemanager.py](https://github.com/jupyter/notebook/blob/a42fa3f45334f8d0dc15b7679918ea635deb6305/notebook/services/contents/largefilemanager.py) by replacing the deprecated function with the new function that is mentioned above.

### Evolution
Jupyter Notebook [was born](http://blog.jupyter.org/2015/04/15/the-big-split/) in 2015 from the IPython project. The process of decoupling the Notebook from the other components is not yet finished and many traces of the old monolith can still be found in the codebase.

For instance, the [`ipython_genutils`](https://github.com/ipython/ipython_genutils) package which contains code shared among the different Jupyter projects is still in use and its deprecation is planned shortly.

The [`jupyter/roadmap`](https://github.com/jupyter/roadmap) repository contains the roadmap for the Jupyter Notebook and the removal of the connections to the shared repositories.

## Testing Debt
As seen in the Development View, the Jupyter Notebook project can be divided in two parts: the HTML & JS & CSS frontend and the Python backend.

The unit testing of these two parts is done independently. The Python backend is tested using nose and the frontend is tested using CasperJS.

### Backend
The testing of the Python backend with `nosetests` is done automatically at each pull request, thanks to Travis CI (for Linux) and AppVeyor (for Windows). The testing is done on both the 2.7 and 3.5.1 versions of the Python interpreter.

The coverage of the tests is reported by nose and analysed by CodeCov. The actual coverage on the master branch is [*77.24%*](https://codecov.io/gh/jupyter/notebook). Test coverage usefulness as a metric has been debated, and the general consensus [is that](https://martinfowler.com/bliki/TestCoverage.html) it is mainly a tool to discover untested parts of the codebase, rather than being an assurance that the codebase is well tested. In fact, even if a project has a 100% coverage there is no gurantee that the unit tests are targeting the correct cases.

Some details on the less tested parts, as reported by CodeCov:

- The `allow76` module has a 0% coverage. This module was introduced to restore the "draft 76" WebSocket protocol for the Tornado web server. It is an earlier version of the WebSocket protocol that was implemented by certain browsers, notably PhantomJS. In this case it is used only when testing the frontend with PhantomJS. It's low coverage affects only the frontend unit tests and can be deemed not critical.
- The `jstest` module has a 0% coverage. It is only used to manage the frontend unit testing, so again its low coverage is not critical since it only affects the frontend tests.
- The `nbconvert` package has a 39.28% coverage. Being this suspiciously low, the detailed coverage per-file was analysed. It resulted that most of the tests are not executed. By inspecting the logs of `nosetests` on Travis it was discovered that the tests were skipped because the `pandoc` package, which is requested to test this functionality, is not available. Therefore the pull request [#2283](https://github.com/jupyter/notebook/pull/2283) was opened adding `pandoc` to the packages installed by Travis during the initial installation.

Moreover, the project is still using nose as a testing framework, but as the [website](http://nose.readthedocs.io/en/latest/) states, the project has been in maintainance mode for several years, and it is suggested to move to a newer testing library. There doesn't seem to be any discussion by the developers about the deprecation of this framework.

### Frontend
The testing of the frontend is done using CasperJS. Unfortunately the coverage is not checked since CasperJS does not have the option to output a coverage report. 

It seems like there is significant technical debt in the frontend testing. A number of pull requests were lately [accepted](https://github.com/jupyter/notebook/pull/2220#issuecomment-283406164) without requiring the unit tests, since the Javascript testing suite seems to have significant problems.

It also seems like not all the developers are up to date with the frontend testing. In [this comment](https://github.com/jupyter/notebook/pull/2220#issuecomment-283530644) to a pull request that was opened, [@michaelpacer](https://github.com/michaelpacer) mentions that he's not up to date with the frontend testing and he is asking [@ivanov](https://github.com/ivanov) for help in writing the tests.

Moreover, Travis CI was configured to use the `travis_retry` for the frontend tests, in order to repeat them 3 times in the case that they fail. This function is [supposed to be used](https://docs.travis-ci.com/user/common-build-problems/) to deal with network timeouts during the requirements installation and is therefore misused in this context. 

The maintainers have opened [issue #2243](https://github.com/jupyter/notebook/issues/2243) to track the status of the Javascript tests and eliminate the race conditions that cause them to fail.

## Documentation Debt
Developers need to write documentation of their source code, which may be of help for other developers to understand their code. More importantly, they do not work anymore for the company, people coming after should also be able to understand the system. This type of documentation does not include only code documentation, but also functionality, dependencies etc. An example for a well-documented piece of the system is the [messaging](http://jupyter-client.readthedocs.io/en/latest/messaging.html). It includes versioning, format, protocol and other useful information which is the single source of information for this matter. 
 
- Going through Notebook's documentation issues, in issue [#571](https://github.com/jupyter/notebook/issues/571) documentation debt was spotted regarding lack of explanation of how Notebook interacts with Docker. This request is discussed by members and contributors whether to be added as a link in the main README.md file or directly within the documentation of Jupyter. The core developer [@willingc](https://github.com/willingc) advised that this is very specific to the user's OS, security permissions etc, so they decided to put it into the Jupyter developer docs as part of the [5.0](https://github.com/jupyter/notebook/milestone/18) milestone.
- Another example indicating documention debt was found from the first sight, by just looking at the title. The title of the documentation says *(source: old IPython wiki)* ([IPython Development Guide](https://jupyter.readthedocs.io/en/latest/development_guide/index.html)) and the whole documentation is outdated. There is a note that:
> This is copied verbatim from the old IPython wiki and is currently under development. Much of the information in this part of the development guide is out of date.

This is a clear indication of debt that needs to be paid and may cause confusion about where the correct documentation is, if such exists and where is it located. Improvements of documentation are always welcome by the core developers and they try to encourage contributors to help them with this.

#### User Documentation
User documentation is written for the end user of the product to understand how to download, install and use the product. Furthermore, information could be found about supported programming languages, Jupyter interaction with different modules etc. Specific requests submitted as issues in the project's repository may overlap Development and User Documentation's Technical Debt. For example, not only the developers may take advantage of knowing more for the Docker-Jupyter interaction (issue [#571](https://github.com/jupyter/notebook/issues/571)), but the end users can do that too.
- Public Server Documentation aimed for use by end users and also by developers needs improvement in terms of troubleshooting steps and more resources. This is a suggestion made by the core developer [@willingc](https://github.com/willingc), however it's put into [backlog](https://github.com/jupyter/notebook/milestone/2) since the core developer [@takluyver](https://github.com/takluyver) prefers to not add more stuff to fix for release of version [5.0](https://github.com/jupyter/notebook/milestone/18). 
- An example of bad documentation is observed in issue [#603](https://github.com/jupyter/notebook/issues/603) where a new user tries to use the shortcuts within Notebook, but runs into trouble because the functionality is not clearly explained, e.g. `D, D` meaning push `D` twice in order to delete a cell or information about the case sensitivity of key shortcuts was not explained well. This is supposed to be fixed in release [5.0](https://github.com/jupyter/notebook/milestone/18) as [@pkgw](https://github.com/pkgw) and [@ellisonbg](https://github.com/ellisonbg) advised.
- Security wise, most users don't care about getting a token and do not want to use tokens. Documentation improvement was needed in order to show a proper message to the user letting them know that they need to setup a password. Core dev [@Carreau](https://github.com/Carreau) states that the documentation is not correct and has to be fixed. This is a documentation debt regarding to unclear or bad documentation. 

#### Contributions Documentation
Since this is an open-source project and everyone can contribute to it, there must be documentation explaining in more details how the project is setup, dependencies, general guidance for testing, contributing, code style, languages etc. This documentation seem to have some technical debt too. Specific examples are listed below:

- An example of contribution documentation technical debt is issue [#1754](https://github.com/jupyter/notebook/issues/1754) where user [@dsblank](https://github.com/dsblank) wanted to contribute to the project and tried to install the development environment on Ubuntu, but got a lot of errors. Eventually he found the [.travis.yml](https://github.com/jupyter/jupyter_server/blob/master/.travis.yml) file and figured out that it uses nvm (Node Version Manager) and was able to fix the issue by installing nvm. The user claims this is not explained in the documentation. The user further elaborates and suggests the documentation to include some verifications such as "Now you should be able to run: node, nvm, npm..". In the end the core developer [@blink1073](https://github.com/blink1073) suggests that there are some mandatory steps of installing `nodejs-legacy` required in order to get a `node` command on Ubuntu. Documentation debt here is in the fact that this is not clearly stated in the documentation and also the lack of some sort of checks as the user requested.
- User [jaredjburgess](https://github.com/jaredjburgess) is working on a notebook extension returning code snippets based on selection. The user needs to read notebook events documentation, however such does not exist. This introduces documentation debt in terms of user not being able to understand the system well. If he doesn't know how an important part of it works and thus, may result in the user not contributing, or bad implementation which may trigger critical issues in the future. 

---

From the above mentioned issues introducing documentation debt, it can be concluded that despite the initial expectations, the documentation is not complete nor perfectly written. The major problem for the Jupyter Notebook team in regards to documentation, is the separation of the Notebook specific from the IPython specific documents for all types of documentation. 
