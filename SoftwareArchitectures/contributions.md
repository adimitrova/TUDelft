# Summary
A brief summary of our contributions, from the oldest to the newest (date of upstream PR opening)

| Title (upstream) | Author | PR (fork) | PR (upstream) | Date opened (upstream) | Status |
| ---------------- | -------| ----------| ------------- | ---------------------- | ------ |
| Fixed issue #980 | [@joined](https://github.com/joined) | [#1](https://github.com/delftswa2017/notebook/pull/1) | [#2220](https://github.com/jupyter/notebook/pull/2220) | 2017/02/23 | *Merged* |
| Fix issue #1911 | [@joined](https://github.com/joined) | [#2](https://github.com/delftswa2017/notebook/pull/2) | [#2244](https://github.com/jupyter/notebook/pull/2244) | 2017/03/02 | *Merged* |
| PEP8 Code Formatting | [@joined](https://github.com/joined) | [#3](https://github.com/delftswa2017/notebook/pull/3) | [#2278](https://github.com/jupyter/notebook/pull/2278) | 2017/03/12 | *Rejected* |
| Refactoring Page object | [@John-Pap](https://github.com/John-Pap) | [#4](https://github.com/delftswa2017/notebook/pull/4) | [#2279](https://github.com/jupyter/notebook/pull/2279) | 2017/03/12 | *Approved* |
| Fix deprecated decodestring warning | [@adimitrova](https://github.com/adimitrova) | [#5](https://github.com/delftswa2017/notebook/pull/5) | [#2280](https://github.com/jupyter/notebook/pull/2280) | 2017/03/13 | *Merged* |
| Remove redundant sort from back-end  | [@ajayaadhikari](https://github.com/ajayaadhikari) | [#6](https://github.com/delftswa2017/notebook/pull/6) | [#2281](https://github.com/jupyter/notebook/pull/2281) | 2017/03/13 | *Approved* |
| Add pandoc to travis | [@John-Pap](https://github.com/John-Pap) | [#7](https://github.com/delftswa2017/notebook/pull/7) | [#2283](https://github.com/jupyter/notebook/pull/2283) | 2017/03/13 | *Approved* |

# Contributions
## Fixed issue #980
### Description
[@joined](https://github.com/joined) looked into issues labeled ["cat:New Contributor"](https://github.com/jupyter/notebook/issues?q=is%3Aopen+is%3Aissue+label%3A%22cat%3ANew+Contributor%22) and focused on issue [#980](https://github.com/jupyter/notebook/issues/980). The issue was relative to the incorrect rendering of LaTeX code through the MathJax library. In particular, some delimiters for the LaTeX groups worked, while others didn't. He was able to write a bugfix.

### Process and Discussion
The PR was opened in the fork ([#1](https://github.com/delftswa2017/notebook/pull/1)) on February 23rd. On the same day, it was approved by the other team members and then it was opened upstream ([#2220](https://github.com/jupyter/notebook/pull/2220)); later, the PR received the approval by the reviewer [@blink1073](https://github.com/blink1073). The maintainer [@takluyver](https://github.com/takluyver) asked then a review of the changes to [@mpacer](https://github.com/mpacer), which seems to be knowledgeable about this part of the codebase.

No activity occurred until March 1st when the maintainer [@mpacer](https://github.com/mpacer) asked to refactor the code to improve the readability and to add support for more delimiters. Later on, [@joined](https://github.com/joined) pushed a new commit with the requested changes. [@mpacer](https://github.com/mpacer) asked the approval to [@takluyver](https://github.com/takluyver) to merge the PR without tests, which lately have been abandoned for the Javascript frontend.

On the following day, the maintainer [@ivanov](https://github.com/ivanov) asked to add unit tests to cover the code affected by the bugfix, stressing the fact that merging the pull requests without tests is a bad practice. There was a discussion between him and [@mpacer](https://github.com/mpacer) about the state of the Javascript testing suite, which lately has not been maintained properly. [@joined](https://github.com/joined) asked for guidance in writing the unit tests.

On March 4th the bugfix was ported to the JupyterLab project, by [@blink1073](https://github.com/blink1073) with PR [#1846](https://github.com/jupyterlab/jupyterlab/pull/1846), and four days later [@mpacer](https://github.com/mpacer) pushed a commit adding the unit tests.

The day after the addition of the unit tests the pull request was merged by [@rgbkrk](https://github.com/rgbkrk).

**Status:** *Merged* on 2017/03/09.

## Fixed issue #1911
### Description
[@joined](https://github.com/joined) looked (more) into issues labeled ["cat:New Contributor"](https://github.com/jupyter/notebook/issues?q=is%3Aopen+is%3Aissue+label%3A%22cat%3ANew+Contributor%22) and focused on issue [#1911](https://github.com/jupyter/notebook/issues/1911). The issue was relative to the incorrect syntax highlighting of the LaTeX groups through the CodeMirror library. He was able to write a bugfix.

### Process and Discussion
The PR was opened in the fork ([#2](https://github.com/delftswa2017/notebook/pull/2)) on March 2nd. On the same day, it was approved by the other team members and then it was opened upstream ([#2244](https://github.com/jupyter/notebook/pull/2244)); later on, [@takluyver](https://github.com/takluyver) approved the pull request acknowledging that it's not possible to write test for the functionality.

On the following day, [@minrk](https://github.com/minrk) merged the pull request.

**Status:** *Merged* on 2017/03/03.

## PEP8 Code Formatting
### Description
While investigating the technical debt of the project, [@joined](https://github.com/joined) used the `flake8` linting tool to check the compliance of the Python codebase with the PEP8 code style. Many inconsistencies were discovered, and most of them were solved either by using automated tools like `autopep8` and by visual inspection. The fixes were grouped into different commits by the reference code of the PEP8 style guide.

### Process and Discussion
The PR was opened in the fork ([#3](https://github.com/delftswa2017/notebook/pull/3)) on March 12th. On the same day, it was approved by the other team members and then it was opened upstream ([#2278](https://github.com/jupyter/notebook/pull/2278)).

On the following day, the core developer [@Carreau](https://github.com/Carreau) commented to the pull request. He explained that while the project tries to adhere to the PEP8 style guide, it's not actively enforced. He also explained the problems connected with a such big change (80 files, more than 1000 lines affected), like the inability to work with tools like `git blame` and `git bisect`. He also suggested as a tradeoff to enforce PEP8 only on the new changes to the repository, to make the code progressively compliant.
Other developers chimed in and a discussion of the possible linting tools to use to gradually improve the compliance of the codebase to PEP8 was born.
Later, [@joined](https://github.com/joined) commented explaining to [@Carreau](https://github.com/Carreau) the context of the pull request, pointing out that the project was chosen by the team as part of the Software Architecture course.
[@Carreau](https://github.com/Carreau) then commented some of the changes part of the pull request pointing out possible problems introduced by the usage of automatic tools like `autopep8`.
He then showed his interest in the work of the team and offered his help to navigate the codebase.

The issue was then closed by [@takluyver](https://github.com/takluyver) two days later.

**Status:** *Rejected* on 2017/03/14.

## Refactoring Page object
### Description
While investigating the technical debt of the project, [@John-Pap](https://github.com/John-Pap) found a TODO comment in the `notebook/static/base/js/page.js` Javascript module. The comment mentioned that the `Page` object should accept the `site` and `header` `div`s selectors as parameters in the constructor, rather than hardcoding them in the methods. The object was refactored and the references to it in other parts of the codebase were adjusted accordingly.

### Process and Discussion
The PR was opened in the fork ([#4](https://github.com/delftswa2017/notebook/pull/4)) on March 12th On the same day, it was approved by the other team members and then it was opened upstream ([#2279](https://github.com/jupyter/notebook/pull/2279)).

On the following day, [@Carreau](https://github.com/Carreau) showed his approval to the pull request, asking for confirmation to other developers. He also flagged the pull request to be part of the 5.1 release, since the 5.0 release is about to happen.

Two days later, [@minrk](https://github.com/minrk) showed his approval to the PR, too. He also said that given that the `Page` object is never invoked with other parameters, they could also be made constant removing the TODO comments.

**Status:** *Approved* on 2017/03/13.

## Fix deprecated decodestring warning
### Description
While investigating the technical debt of the project, [@adimitrova](https://github.com/adimitrova) spotted a deprecation warning in the output of the backend tests. The relevant function call in `notebook/services/contents/largefilemanager.py` was modified to the newer version of the API.

### Process and Discussion
The PR was opened in the fork ([#5](https://github.com/delftswa2017/notebook/pull/5)) on March 13th. On the same day, it was approved by the other team members and then it was opened upstream ([#2280](https://github.com/jupyter/notebook/pull/2280)). Later, the continuous integration tests using Travis CI failed. The cause was discovered to be the fact that the function that was used to replace the deprecated method is only compatible with Python 3. A new commit was made changing the function to one to a non-deprecated version compatible both with Python 2 and 3.
Afterwards, the maintainer [@Carreau](https://github.com/Carreau) showed his approval to the PR and asked to submit a patch to `setup.cfg` to make the usage of the deprecated method an error instead of a simple warning in the tests execution.

On the following day, [@gnestor](https://github.com/gnestor) submitted the requested patch. Later on, the PR was merged by [@Carreau](https://github.com/Carreau).

**Status:** *Merged* on 2017/03/14.

## Remove redundant sort from back-end
### Description
While investigating the technical debt of the project, [@ajayaadhikari](https://github.com/ajayaadhikari) spotted a FIXME comment in `notebook/services/contents/handlers.py`. The comment mentioned that some functionality was supposed to be implemented in the Javascript frontend rather than in the backend. It was discovered that the functionality was already present in the frontend and therefore the backend code was redundant. The functionality was therefore removed from the backend.

### Process and Discussion
The PR was opened in the fork ([#6](https://github.com/delftswa2017/notebook/pull/6)) on March 13th. On the same day, it was approved by the other team members and then it was opened upstream ([#2281](https://github.com/jupyter/notebook/pull/2281)). Later on, [@Carreau](https://github.com/Carreau) approved the PR, saying that in his opinion the change should be introduced after the 5.0 release which is imminent.

**Status:** *Approved* on 2017/03/13.

## Add pandoc to travis
### Description
While investigating the testing debt of the project, [@John-Pap](https://github.com/John-Pap) realised that some tests were not ran by Travis because the `pandoc` requirement was missing. The requirement was added to the Travis configuration file as an APT addon.

### Process and Discussion
The PR was opened in the fork ([#7](https://github.com/delftswa2017/notebook/pull/7)) on March 13th. On the same day, it was approved by the other team members and then it was opened upstream ([#2283](https://github.com/jupyter/notebook/pull/2283)). Later on, the maintainer [@blink1073](https://github.com/blink1073) showed his approval. Then, [@mpacer](https://github.com/mpacer) noted that the `pandoc` version available on APT is out of date and will not handle the tests. He pushed two commits, one to use an up-to-date version of `pandoc` in the requirements and one to enable `sudo`on Travis CI. Adding the missing `pandoc` requirement resulted in an increase of the test coverage of the 1.09%, as reported by Codecov. The PR is currently waiting to be merged.

**Status:** *Approved* on 2017/03/13.